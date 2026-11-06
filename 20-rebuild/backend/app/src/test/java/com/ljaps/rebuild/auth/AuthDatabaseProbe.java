package com.ljaps.rebuild.auth;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;
import javax.crypto.Cipher;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/** Optional private-fixture comparison. Prints field names/counts only, never identity or token values. */
public final class AuthDatabaseProbe {
    public static void main(String[] args) throws Exception {
        ((ch.qos.logback.classic.Logger)org.slf4j.LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME)).setLevel(ch.qos.logback.classic.Level.WARN);
        Map<String,String> settings=env(args[0]), fixture=env(args[1]);
        DriverManagerDataSource ds=new DriverManagerDataSource("jdbc:mysql://mysql:3306/"+settings.get("LJAPS_DB_NAME")+"?useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Shanghai",settings.get("LJAPS_DB_USER"),settings.get("LJAPS_DB_PASSWORD"));
        AuthService auth=new AuthService(new JdbcTemplate(ds),args[2],settings.get("LJAPS_JWT_SECRET"),3600,"classify,contract,plan,mes,scm,wms,assemble_typesetting,bim,operation","artifact,auxiliary_material","building,enclosure,bridge,grid","1");
        Cipher rsa=Cipher.getInstance("RSA/ECB/PKCS1Padding");
        String pub=auth.publicKey().replace("-----BEGIN PUBLIC KEY-----","").replace("-----END PUBLIC KEY-----","");
        rsa.init(Cipher.ENCRYPT_MODE,KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.getMimeDecoder().decode(pub))));
        String encrypted=Base64.getEncoder().encodeToString(rsa.doFinal(fixture.get("LOCAL_WEB_PASSWORD").getBytes(StandardCharsets.UTF_8)));
        Map<String,Object> login=auth.login(fixture.get("LOCAL_WEB_USERNAME"),encrypted);
        String token=String.valueOf(login.get("token"));
        Map<String,Object> user=auth.authenticate(token);
        ObjectMapper json=new ObjectMapper();
        JsonNode actual=json.readTree(json.writeValueAsBytes(auth.info(user))), expected=json.readTree(Files.readAllBytes(Paths.get(args[3]))).get("data");
        List<String> differences=new ArrayList<>();
        expected.fieldNames().forEachRemaining(k -> { if(!Objects.equals(expected.get(k),actual.get(k))) differences.add(k); });
        System.out.println("info-field-differences="+differences+"; expected-field-count="+expected.size()+"; actual-field-count="+actual.size()+"; exact-json-equal="+actual.equals(expected));
        JsonNode menus=json.readTree(json.writeValueAsBytes(auth.menus(user))), expectedMenus=json.readTree(Files.readAllBytes(Paths.get(args[4]))).get("data");
        System.out.println("menu-root-count="+menus.size()+"; original="+expectedMenus.size()+"; exact-json-equal="+menus.equals(expectedMenus));
        System.out.println("login-conform-policy-equal="+Objects.equals(login.get("conformPasswordPolicy"),json.readTree(Files.readAllBytes(Paths.get(args[5]))).get("data").get("conformPasswordPolicy").asBoolean()));
        if(!actual.equals(expected)) throw new AssertionError("Info contract differs");
        if(!menus.equals(expectedMenus)) throw new AssertionError("Menu contract differs");
        auth.logout(token);
        AuthContractProbe.reject(() -> auth.authenticate(token),"logout revocation");
        AuthService restarted=new AuthService(new JdbcTemplate(ds),args[2],settings.get("LJAPS_JWT_SECRET"),3600,"mes","artifact,auxiliary_material","building,enclosure,bridge,grid","1");
        AuthContractProbe.reject(() -> restarted.authenticate(token),"logout persists across service restart");
        System.out.println("AuthDatabaseProbe: real independent database read chain, original response comparison, persistent logout passed");
    }
    private static Map<String,String> env(String file) throws Exception {
        Map<String,String> values=new HashMap<>();
        for(String line:Files.readAllLines(Paths.get(file),StandardCharsets.UTF_8)) { int i=line.indexOf('='); if(i>0&&!line.startsWith("#")) values.put(line.substring(0,i),line.substring(i+1)); }
        return values;
    }
}
