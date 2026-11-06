import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.net.*;
import java.util.*;

/** JSON stdin/stdout bridge for further tests inside this independent network. */
public class ContainerHttp {
    public static void main(String[] args) throws Exception {
        ObjectMapper json=new ObjectMapper();JsonNode input=json.readTree(System.in);
        String path=input.path("path").asText();
        if(!path.startsWith("/") || path.startsWith("//")) throw new IllegalArgumentException("Only this independent web container is allowed");
        HttpURLConnection connection=(HttpURLConnection)new URL("http://web"+path).openConnection();
        connection.setRequestProperty("Accept","application/json"); connection.setConnectTimeout(10000);connection.setReadTimeout(45000);connection.setRequestMethod(input.path("method").asText("GET"));
        if(input.hasNonNull("token")) connection.setRequestProperty("Authorization",input.get("token").asText());
        if(input.has("financeBranchId")) {
            String branch=input.get("financeBranchId").asText();
            if(!branch.matches("[1-9][0-9]{0,18}") || Long.parseLong(branch)<=0) throw new IllegalArgumentException("Positive financeBranchId required");
            connection.setRequestProperty("financeBranchId",branch);
        }
        if(input.has("data") || input.has("bodyBase64")) { connection.setDoOutput(true);connection.setRequestProperty("Content-Type",input.path("contentType").asText("application/json"));connection.getOutputStream().write(input.has("bodyBase64")?Base64.getDecoder().decode(input.get("bodyBase64").asText()):json.writeValueAsBytes(input.get("data"))); }
        int status=connection.getResponseCode();InputStream stream=status<400?connection.getInputStream():connection.getErrorStream();
        ByteArrayOutputStream output=new ByteArrayOutputStream();if(stream!=null){byte[] block=new byte[65536];int count;while((count=stream.read(block))!=-1)output.write(block,0,count);stream.close();}
        Map<String,Object> result=new LinkedHashMap<>();result.put("status",status);result.put("bodyBase64",Base64.getEncoder().encodeToString(output.toByteArray()));Map<String,Object> headers=new LinkedHashMap<>();for(Map.Entry<String,List<String>> entry:connection.getHeaderFields().entrySet())if(entry.getKey()!=null)headers.put(entry.getKey(),entry.getValue());result.put("headers",headers);connection.disconnect();
        System.out.println(json.writeValueAsString(result));
    }
}
