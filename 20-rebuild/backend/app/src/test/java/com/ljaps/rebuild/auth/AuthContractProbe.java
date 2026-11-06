package com.ljaps.rebuild.auth;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.*;
import javax.crypto.Cipher;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/** Synthetic input only; never needs real users, passwords, private keys or source binaries. */
public final class AuthContractProbe {
    public static void main(String[] args) throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA"); generator.initialize(2048);
        KeyPair keys = generator.generateKeyPair();
        Path pem = Files.createTempFile("ljaps-auth-probe", ".pem");
        try {
            Files.write(pem, ("-----BEGIN PRIVATE KEY-----\n" + Base64.getMimeEncoder().encodeToString(keys.getPrivate().getEncoded()) + "\n-----END PRIVATE KEY-----\n").getBytes(StandardCharsets.US_ASCII));
            FakeDb db = new FakeDb();
            AuthService service = new AuthService(db, pem.toString(), String.join("", Collections.nCopies(64, "x")), 3600,
                "mes", "artifact,auxiliary_material", "building,enclosure,bridge,grid", "1");
            Cipher rsa = Cipher.getInstance("RSA/ECB/PKCS1Padding"); rsa.init(Cipher.ENCRYPT_MODE, keys.getPublic());
            String encrypted = Base64.getEncoder().encodeToString(rsa.doFinal("Synthetic@123".getBytes(StandardCharsets.UTF_8)));
            Map<String,Object> login = service.login("testuser", encrypted);
            String wrongPassword = Base64.getEncoder().encodeToString(rsa.doFinal("Wrong@123".getBytes(StandardCharsets.UTF_8)));
            reject(() -> service.login("testuser", wrongPassword), "wrong BCrypt password rejected");
            String token = (String)login.get("token");
            check(token != null && service.authenticate(token).get("id").equals(7L), "raw JWT authenticates database user");
            reject(() -> service.authenticate("Bearer " + token), "Bearer prefix rejected");
            reject(() -> service.login("testuser", "plaintext"), "unencrypted password rejected");
            reject(() -> service.login("testuser", encrypted.substring(4)), "corrupt RSA rejected");
            db.enabled = false; reject(() -> service.authenticate(token), "disabled account cannot reuse token"); db.enabled = true;
            db.resetVersion="changed"; reject(() -> service.authenticate(token), "password reset invalidates token"); db.resetVersion=null;
            db.deleted=true; reject(() -> service.authenticate(token), "deleted account cannot reuse token"); db.deleted=false;
            reject(() -> service.authenticate(null), "missing token rejected");
            String expired = io.jsonwebtoken.Jwts.builder().setSubject("testuser").setId(UUID.randomUUID().toString()).claim("uid",7L).claim("pwdv","").setExpiration(new Date(System.currentTimeMillis()-60000)).signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, String.join("",Collections.nCopies(64,"x")).getBytes(StandardCharsets.UTF_8)).compact();
            reject(() -> service.authenticate(expired), "expired signed token rejected");
            reject(() -> service.authenticate(token.substring(0,token.length()-10)+"tamperedxx"), "tampered token rejected");
            check(service.menus(service.authenticate(token)).isEmpty(), "no roles yields no menu");
            Map<String,Object> basic = AuthService.map("id",1L,"pid",0L,"name","root","bool_main_system",false,"type",3,"category",0);
            Map<String,Object> child = AuthService.map("id",2L,"pid",1L,"name","child","component_name","Child","cache",true,"type",1,"hidden",true);
            List<Map<String,Object>> tree = AuthService.buildTree(Arrays.asList(basic,child));
            List<?> children = (List<?>)tree.get(0).get("children");
            check(children.size()==1 && Boolean.TRUE.equals(((Map<?,?>)children.get(0)).get("hidden")), "tree keeps original hidden contract");
            check(!service.publicKey().contains("PRIVATE"), "public key contains no private material");
            db.roleRows=Collections.singletonList(AuthService.map("id",17L,"permission","viewer","name","admin"));
            db.menuRows=Arrays.asList(child,child,AuthService.map("id",3L,"pid",1L,"name","button","type",2));
            db.rootRows=Collections.singletonList(basic);
            List<Map<String,Object>> restricted=service.menus(service.authenticate(token));
            check(((List<?>)restricted.get(0).get("children")).size()==1, "non-admin only gets role-linked distinct non-button menus plus roots");
            db.infoRows=Arrays.asList(AuthService.map("permission","deep_pen_config_edit"),AuthService.map("permission","mes_task:get"),AuthService.map("permission","  "),AuthService.map("permission",null));
            List<?> assigned=(List<?>)service.info(AuthService.map("id",7L)).get("permissions");
            check(assigned.contains("deep_pen_config_edit"), "existing assigned permission without colon remains visible");
            check(assigned.equals(Arrays.asList("deep_pen_config_edit","mes_task:get")), "blank and null permission values are excluded");
            db.infoRows=Collections.emptyList();
            check(((List<?>)service.info(AuthService.map("id",7L)).get("permissions")).isEmpty(), "unassigned permission is not invented");
            db.roleRows=Collections.singletonList(AuthService.map("id",17L,"permission","admin","name","ordinary name"));
            check(service.menus(service.authenticate(token)).size()==1 && db.adminMenuRead, "admin determined by role permission, fresh role read");
            service.logout(token); reject(() -> service.authenticate(token), "logout revokes token");
            AuthService restarted = new AuthService(db, pem.toString(), String.join("", Collections.nCopies(64, "x")), 3600, "mes", "artifact,auxiliary_material", "building,enclosure,bridge,grid", "1");
            reject(() -> restarted.authenticate(token), "logout remains revoked after service restart");
            System.out.println("AuthContractProbe: 21 synthetic checks passed");
        } finally { Files.deleteIfExists(pem); }
    }
    static void check(boolean value, String message) { if(!value) throw new AssertionError(message); }
    static void reject(Runnable action, String message) { try { action.run(); } catch(AuthService.AuthFailure expected) { return; } throw new AssertionError(message); }
    static final class FakeDb extends JdbcTemplate {
        boolean enabled=true, deleted=false, adminMenuRead=false;
        String resetVersion=null;
        List<Map<String,Object>> roleRows=Collections.emptyList(),menuRows=Collections.emptyList(),rootRows=Collections.emptyList();
        List<Map<String,Object>> infoRows=Collections.emptyList();
        @Override public List<Map<String,Object>> queryForList(String sql) {
            if(sql.contains("FROM sys_menu m ") && sql.contains("m.pid=0")) return new ArrayList<>(rootRows);
            if(sql.contains("FROM sys_menu m ") && sql.contains("m.category=0")) { adminMenuRead=true; List<Map<String,Object>> rows=new ArrayList<>(rootRows); rows.addAll(menuRows); return rows; }
            if(sql.startsWith("SELECT id FROM sys_menu ") || sql.startsWith("SELECT is_enable FROM sys_home_enable_config ")) return Collections.emptyList();
            throw new AssertionError("Unexpected SQL query");
        }
        final Set<String> revoked = new HashSet<>();
        @Override public int update(String sql,Object... args) {
            if(sql.startsWith("INSERT INTO rebuild_auth_revoked_token")) { revoked.add(String.valueOf(args[0])); return 1; }
            throw new AssertionError("Unexpected SQL mutation");
        }
        final String hash = new BCryptPasswordEncoder().encode("Synthetic@123");
        @Override public List<Map<String,Object>> queryForList(String sql, Object... args) {
            if(sql.contains("FROM rebuild_auth_revoked_token ")) return revoked.contains(String.valueOf(args[0]))?Collections.singletonList(AuthService.map("jti",args[0])):Collections.emptyList();
            if(sql.contains("FROM sys_user ")) return deleted?Collections.emptyList():Collections.singletonList(AuthService.map("id",7L,"username","testuser","password",hash,"is_enabled",enabled,"last_password_reset_date",resetVersion));
            if(sql.contains("FROM sys_role ")) return roleRows;
            if(sql.startsWith("SELECT m.id,") && sql.contains("url.user_id=?")) {
                check(sql.contains("url.bool_delete_enum=0") && sql.contains("r.bool_delete_enum=0") && sql.contains("rml.bool_delete_enum=0") && args[0].equals(7L), "user info reads only assigned live role menu permissions");
                return new ArrayList<>(infoRows);
            }
            if(sql.contains("FROM sys_role_menu_link ")) {
                check(sql.contains("m.bool_delete_enum=0") && sql.contains("rml.bool_delete_enum=0") && sql.contains("m.category=0") && args.length==1 && args[0].equals(17L), "role menu query limits by live role");
                return new ArrayList<>(menuRows);
            }
            if(sql.contains("FROM sys_config ")) return args[0].equals("COMPANY_NAME")?Collections.singletonList(AuthService.map("value","{\"companyName\":\"Synthetic\"}")):Collections.emptyList();
            if(sql.contains("FROM wms_basic_config ")) return Collections.emptyList();
            throw new AssertionError("Unexpected SQL query in synthetic auth probe");
        }
    }
}
