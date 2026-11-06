import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.*;
import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;
import javax.crypto.Cipher;

/** Container-internal real HTTP checks; prints neither credentials nor response business data. */
public class StandaloneProbe {
    static final ObjectMapper JSON = new ObjectMapper();
    static final String BASE = "http://web";
    static String token;
    static Map<String,Object> report = new LinkedHashMap<>();
    static class Response {
        int status; byte[] bytes;
        JsonNode json() throws IOException { return JSON.readTree(bytes); }
    }
    static Response call(String path, String method, byte[] body, boolean auth) throws Exception {
        if (!path.startsWith("/") || path.startsWith("//")) throw new IllegalArgumentException("Invalid probe path");
        HttpURLConnection connection = (HttpURLConnection)new URL(BASE + path).openConnection();
        connection.setRequestProperty("Accept","application/json"); connection.setConnectTimeout(10000); connection.setReadTimeout(45000); connection.setRequestMethod(method);
        if(auth && token != null) connection.setRequestProperty("Authorization", token);
        if(body != null) { connection.setRequestProperty("Content-Type", "application/json"); connection.setDoOutput(true); connection.getOutputStream().write(body); }
        Response result = new Response(); result.status = connection.getResponseCode();
        InputStream stream = result.status < 400 ? connection.getInputStream() : connection.getErrorStream();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        if(stream != null) { byte[] block = new byte[65536]; int count; while((count=stream.read(block)) != -1) output.write(block,0,count); stream.close(); }
        result.bytes = output.toByteArray(); connection.disconnect(); return result;
    }
    static void require(boolean value,String message) { if(!value) throw new IllegalStateException(message); }
    static String sha(byte[] data) throws Exception { StringBuilder result=new StringBuilder(); for(byte b:MessageDigest.getInstance("SHA-256").digest(data)) result.append(String.format("%02x",b&255)); return result.toString(); }
    static ArrayNode sortedClassification(JsonNode nodes) {
        require(nodes.isArray(),"Classification nodes must be an array");
        List<JsonNode> items=new ArrayList<>();Set<String> identities=new HashSet<>();
        for(JsonNode node:nodes) {
            require(node.isObject() && node.hasNonNull("id") && identities.add(node.get("id").asText()),"Classification IDs must be present and unique among siblings");
            ObjectNode copy=node.deepCopy();
            if(copy.hasNonNull("children")) copy.set("children",sortedClassification(copy.get("children")));
            items.add(copy);
        }
        Collections.sort(items,Comparator.comparing(node->node.path("id").asText()));ArrayNode result=JSON.createArrayNode();items.forEach(result::add);return result;
    }
    static JsonNode classificationBody(JsonNode body) { ObjectNode copy=body.deepCopy();copy.set("data",sortedClassification(copy.get("data")));return copy; }
    public static void main(String[] args) throws Exception {
        JsonNode config=JSON.readTree(System.in);
        try {
            boolean ready=false;
            for(int attempt=0;attempt<150;attempt++) {
                try { Response health=call("/actuator/health","GET",null,false); ready=health.status==200 && "UP".equals(health.json().path("status").asText()); } catch(Exception ignored) {}
                if(ready) break; Thread.sleep(2000);
            }
            require(ready,"Independent backend/database health did not become UP"); report.put("database_health",true);
            Response index=call("/","GET",null,false); require(index.status==200 && sha(index.bytes).equals(config.path("frontend_index_sha256").asText()),"Frontend source-build index differs"); report.put("frontend_index_exact",true);
            JsonNode key=call("/api/user/public-key","GET",null,false).json();
            String encoded=key.path("data").path("publicKey").asText().replaceAll("-----[^-]+-----","").replaceAll("\\s","");
            PublicKey publicKey=KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.getDecoder().decode(encoded)));
            require(sha(publicKey.getEncoded()).equals(config.path("rsa_public_der_sha256").asText()),"Independent service public key mismatch");
            Cipher cipher=Cipher.getInstance("RSA/ECB/PKCS1Padding");cipher.init(Cipher.ENCRYPT_MODE,publicKey);
            Map<String,String> login=new HashMap<>();login.put("username",config.path("username").asText());login.put("password",Base64.getEncoder().encodeToString(cipher.doFinal(config.path("password").asText().getBytes("UTF-8"))));
            JsonNode logged=call("/api/user/login","POST",JSON.writeValueAsBytes(login),false).json();
            require(logged.path("code").asInt()==20000 && !logged.path("data").path("token").asText().isEmpty(),"Independent RSA login failed");
            token=logged.path("data").path("token").asText(); report.put("rsa_login",true);
            for(String endpoint:Arrays.asList("/api/user/info","/api/user/menu")) {
                JsonNode value=call(endpoint,"GET",null,true).json(); require(value.path("code").asInt()==20000,"Independent user/menu failed");
                require(value.path("data").equals(config.path("auth_expected").path(endpoint)),"Independent user/menu differs from packed baseline");
            }
            report.put("user_and_menu_exact",true);
            List<Map<String,Object>> cases=new ArrayList<>();report.put("business_queries",cases);
            Iterator<String> paths=config.path("business_expected").fieldNames();
            while(paths.hasNext()) {
                String path=paths.next();JsonNode expected=config.path("business_expected").path(path);
                Response response=call(path,"GET",null,true);
                boolean exact=response.status==expected.get(0).asInt() && response.json().equals(expected.get(1));
                String comparison=config.path("comparison").path(path).asText("exact");
                boolean matched=exact || (response.status==expected.get(0).asInt() && comparison.equals("classification_hierarchy_unordered") && classificationBody(response.json()).equals(classificationBody(expected.get(1))));
                if(!matched) { Map<String,Object> failure=new LinkedHashMap<>();failure.put("path",path);failure.put("expected",expected);failure.put("actual_status",response.status);failure.put("actual",response.json());Files.write(Paths.get("/evidence/failed-business-response.json"),JSON.writerWithDefaultPrettyPrinter().writeValueAsBytes(failure));throw new IllegalStateException("Independent business response mismatch: "+path); }
                JsonNode anonymous=call(path,"GET",null,false).json();require(anonymous.path("code").asInt()!=20000,"Anonymous business request was accepted: "+path);
                Map<String,Object> item=new LinkedHashMap<>(); item.put("path",path);item.put("exact_response",exact);item.put("contract_comparison",comparison);item.put("contract_match",true);item.put("anonymous_denied",true);cases.add(item);
            }
            report.put("business_queries",cases);
            Response attachment=call(config.path("attachment_path").asText(),"GET",null,true);
            require(attachment.status==200 && sha(attachment.bytes).equals(config.path("attachment_sha256").asText()),"Packed attachment static read mismatch");report.put("attachment_exact_bytes",true);
            List<String> templates=new ArrayList<>();int indexNumber=0;
            for(JsonNode path:config.path("templates")) {
                Response response=call(path.asText(),"GET",null,true);require(response.status==200,"Independent template download failed");
                Files.write(Paths.get("/evidence/template-"+(indexNumber++)+".xlsx"),response.bytes);templates.add(path.asText());
            }
            report.put("template_paths",templates);
            Response logout=call("/api/user/logout","POST","{}".getBytes("UTF-8"),true);require(logout.json().path("code").asInt()==20000,"Independent logout failed");
            require(call("/api/user/info","GET",null,true).json().path("code").asInt()!=20000,"Logged-out independent token still valid");report.put("logout_revoked",true);
            report.put("passed",true);
        } catch(Exception error) { report.put("passed",false);report.put("failure",error instanceof IllegalStateException?error.getMessage():error.getClass().getSimpleName()); }
        Files.write(Paths.get("/evidence/http-verification.json"),JSON.writerWithDefaultPrettyPrinter().writeValueAsBytes(report));
        System.out.println(JSON.writeValueAsString(Collections.singletonMap("passed",report.get("passed"))));
        if(!Boolean.TRUE.equals(report.get("passed"))) System.exit(1);
    }
}
