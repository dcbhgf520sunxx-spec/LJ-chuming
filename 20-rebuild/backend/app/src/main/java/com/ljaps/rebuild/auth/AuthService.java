package com.ljaps.rebuild.auth;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.security.*;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.*;
import java.util.*;
import java.util.stream.Collectors;
import javax.crypto.Cipher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/** Read-only reconstruction from the original mapper XML and auth/menu service behavior. */
@Service
public class AuthService {
    private static final String USER_COLUMNS = "id,username,name,sex,phone,email,is_enabled,department_id,job_id,inventory_notify_perm,user_type,dd_user_id,dd_dept_id,oa_user_id,last_password_reset_date";
    private static final String MENU_COLUMNS = "m.id,m.pid,m.name,m.path,m.permission,m.component,m.component_name,m.cache,m.icon,m.iframe,m.always_show,m.category,m.hidden,m.redirect,m.type,m.sort,m.bool_main_system";
    private final JdbcTemplate jdbc;
    private final ObjectMapper json = new ObjectMapper();
    private final BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
    private final PrivateKey privateKey;
    private final String publicPem;
    private final byte[] secret;
    private final long expirationSeconds;
    private final String modules, productMenu, mesEnum, menuEnum;

    public AuthService(JdbcTemplate jdbc,
            @Value("${LJAPS_RSA_PRIVATE_KEY_PATH}") String privateKeyPath,
            @Value("${LJAPS_JWT_SECRET}") String secret,
            @Value("${LJAPS_JWT_EXPIRATION_SECONDS:28800}") long expirationSeconds,
            @Value("${LJAPS_MODULES:classify,contract,plan,mes,scm,wms,assemble_typesetting,bim,operation}") String modules,
            @Value("${LJAPS_PRODUCT_MENU:artifact,auxiliary_material}") String productMenu,
            @Value("${LJAPS_MES_ENUM:building,enclosure,bridge,grid}") String mesEnum,
            @Value("${LJAPS_MENU_ENUM:1}") String menuEnum) throws Exception {
        this.jdbc=jdbc; this.secret=secret.getBytes(StandardCharsets.UTF_8); this.expirationSeconds=expirationSeconds;
        this.modules=modules; this.productMenu=productMenu; this.mesEnum=mesEnum; this.menuEnum=menuEnum;
        if(this.secret.length<64 || expirationSeconds<1) throw new IllegalArgumentException("JWT secret must contain at least 64 UTF-8 bytes; lifetime must be positive");
        String pem=new String(Files.readAllBytes(Paths.get(privateKeyPath)), StandardCharsets.US_ASCII);
        if(!pem.contains("-----BEGIN PRIVATE KEY-----")) throw new IllegalArgumentException("RSA key must be PKCS#8 PEM");
        privateKey=KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.getMimeDecoder().decode(pem.replace("-----BEGIN PRIVATE KEY-----", "").replace("-----END PRIVATE KEY-----", ""))));
        RSAPrivateCrtKey key=(RSAPrivateCrtKey)privateKey;
        PublicKey pub=KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(key.getModulus(),key.getPublicExponent()));
        publicPem="-----BEGIN PUBLIC KEY-----\n"+Base64.getMimeEncoder(64,new byte[]{'\n'}).encodeToString(pub.getEncoded())+"\n-----END PUBLIC KEY-----\n";
    }

    public String publicKey() { return publicPem; }

    public Map<String,Object> login(String username, String encryptedPassword) {
        String field=loginField(username);
        List<Map<String,Object>> rows=jdbc.queryForList("SELECT "+USER_COLUMNS+",password FROM sys_user WHERE "+field+"=? AND bool_delete_enum=0",username);
        if(rows.size()!=1) throw fail(40000,"用户不存在");
        Map<String,Object> user=rows.get(0);
        String password;
        try {
            Cipher cipher=Cipher.getInstance("RSA/ECB/PKCS1Padding"); cipher.init(Cipher.DECRYPT_MODE,privateKey);
            if(encryptedPassword==null || encryptedPassword.length()>2048) throw new IllegalArgumentException();
            password=new String(cipher.doFinal(Base64.getDecoder().decode(encryptedPassword)),StandardCharsets.UTF_8);
        } catch(Exception e) { throw fail(40000,"失败，密码解析错误"); }
        if(!truth(user.get("is_enabled"))) throw fail(40000,"该账号已被禁用，请联系管理员");
        if(!bcrypt.matches(password,String.valueOf(user.get("password")))) throw fail(40000,"账号密码错误");
        long now=System.currentTimeMillis();
        String token=Jwts.builder().setSubject(String.valueOf(user.get("username"))).setId(UUID.randomUUID().toString())
            .claim("uid",number(user.get("id"))).claim("pwdv",resetVersion(user))
            .setIssuedAt(new Date(now)).setExpiration(new Date(now+expirationSeconds*1000L)).signWith(SignatureAlgorithm.HS512,secret).compact();
        return map("token",token,"conformPasswordPolicy",conforms(password,isAdmin(roles(number(user.get("id"))))));
    }

    static String loginField(String username) {
        if(username!=null && username.matches("((13[0-9])|(14[0-9])|(15[0-9])|(16[0-9])|(17[0-9])|(18[0-9])|(19[0-9]))\\d{8}$")) return "phone";
        if(username!=null && username.matches("[A-Za-z0-9]{4,16}")) return "username";
        if(username!=null && username.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$")) return "email";
        throw fail(40000,"用户不存在");
    }

    public Map<String,Object> authenticate(String token) {
        if(token==null || token.isEmpty()) throw fail(40001,"未传入token信息");
        if(token.length()>4096 || token.contains(" ")) throw fail(40004,"token格式不正确");
        Claims claims;
        try { claims=Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody(); }
        catch(ExpiredJwtException e) { throw fail(40002,"token过期，请重新登录"); }
        catch(JwtException|IllegalArgumentException e) { throw fail(40003,"token解析失败"); }
        if(claims.getId()==null || claims.getExpiration()==null || !(claims.get("uid") instanceof Number)) throw fail(40005,"token已失效，请重新登录");
        if(!jdbc.queryForList("SELECT jti FROM rebuild_auth_revoked_token WHERE jti=? AND expires_at_epoch_ms>?",claims.getId(),System.currentTimeMillis()).isEmpty()) throw fail(40005,"token已失效，请重新登录");
        List<Map<String,Object>> rows=jdbc.queryForList("SELECT "+USER_COLUMNS+" FROM sys_user WHERE id=? AND bool_delete_enum=0",((Number)claims.get("uid")).longValue());
        if(rows.size()!=1) throw fail(40005,"token已失效，请重新登录");
        Map<String,Object> user=rows.get(0);
        if(!truth(user.get("is_enabled"))) throw fail(40103,"该账号已被禁用");
        if(!Objects.equals(claims.getSubject(),user.get("username")) || !Objects.equals(claims.get("pwdv"),resetVersion(user))) throw fail(40005,"token已失效，请重新登录");
        return user;
    }

    public void logout(String token) {
        authenticate(token);
        Claims claims=Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        jdbc.update("INSERT INTO rebuild_auth_revoked_token(jti,expires_at_epoch_ms) VALUES (?,?) ON DUPLICATE KEY UPDATE expires_at_epoch_ms=VALUES(expires_at_epoch_ms)",claims.getId(),claims.getExpiration().getTime());
    }

    private static String resetVersion(Map<String,Object> user) { return Objects.toString(user.get("last_password_reset_date"),""); }
    private List<Map<String,Object>> roles(long id) {
        return jdbc.queryForList("SELECT r.id,r.name,r.permission FROM sys_role r INNER JOIN sys_user_role_link url ON r.id=url.role_id WHERE url.user_id=? AND url.bool_delete_enum=0 AND r.bool_delete_enum=0",id);
    }
    private static boolean isAdmin(List<Map<String,Object>> roles) { return roles.stream().anyMatch(r -> "admin".equals(r.get("permission"))); }

    public List<Map<String,Object>> menus(Map<String,Object> user) {
        List<Map<String,Object>> roles=roles(number(user.get("id")));
        List<Map<String,Object>> menus;
        if(isAdmin(roles)) menus=jdbc.queryForList("SELECT "+MENU_COLUMNS+" FROM sys_menu m WHERE m.bool_delete_enum=0 AND m.category=0 ORDER BY m.sort,m.id");
        else if(roles.isEmpty()) return new ArrayList<>();
        else {
            List<Object> ids=roles.stream().map(r -> r.get("id")).collect(Collectors.toList());
            menus=jdbc.queryForList("SELECT "+MENU_COLUMNS+" FROM sys_role_menu_link rml INNER JOIN sys_menu m ON rml.menu_id=m.id WHERE m.bool_delete_enum=0 AND rml.bool_delete_enum=0 AND m.category=0 AND rml.role_id IN ("+marks(ids.size())+") ORDER BY m.sort,m.id",ids.toArray());
            menus.addAll(jdbc.queryForList("SELECT "+MENU_COLUMNS+" FROM sys_menu m WHERE m.bool_delete_enum=0 AND m.pid=0"));
        }
        LinkedHashMap<Long,Map<String,Object>> unique=new LinkedHashMap<>();
        for(Map<String,Object> menu:menus) if(number(menu.get("type"))!=2) unique.putIfAbsent(number(menu.get("id")),menu);
        List<Map<String,Object>> tree=buildTree(new ArrayList<>(unique.values()));
        if(unique.containsKey(6000200L)) expandPricing(tree);
        return tree;
    }

    static List<Map<String,Object>> buildTree(List<Map<String,Object>> menus) {
        List<Map<String,Object>> result=new ArrayList<>();
        for(Map<String,Object> row:menus) if(truth(row.get("bool_main_system")) || number(row.get("pid"))==0) {
            Map<String,Object> root=node(); root.putAll(map("id",row.get("id"),"name",row.get("name"),"boolMainSystem",truth(row.get("bool_main_system")),"redirect",row.get("redirect")));
            children(root,menus,new HashSet<Long>()); result.add(root);
        }
        return result;
    }
    private static Map<String,Object> node() { return map("id",null,"path",null,"redirect",null,"name",null,"component",null,"alwaysShow",null,"hidden",null,"boolMainSystem",null,"meta",null,"children",null); }
    private static void children(Map<String,Object> parent,List<Map<String,Object>> menus,Set<Long> ancestors) {
        long id=number(parent.get("id"));
        if(!ancestors.add(id)) throw fail(50000,"菜单数据存在循环关系");
        List<Map<String,Object>> children=new ArrayList<>();
        for(Map<String,Object> row:menus) if(number(row.get("pid"))==id) {
            Map<String,Object> child=node(); child.putAll(map("id",row.get("id"),"name",row.get("component_name"),"path",row.get("path"),"hidden",truth(row.get("hidden")),"component",row.get("component"),"alwaysShow",truth(row.get("always_show")),"redirect",row.get("redirect"),"meta",map("title",row.get("name"),"icon",row.get("icon"),"noCache",!truth(row.get("cache")))));
            children(child,menus,new HashSet<>(ancestors)); children.add(child);
        }
        if(!children.isEmpty()) parent.put("children",children);
    }
    @SuppressWarnings("unchecked")
    private void expandPricing(List<Map<String,Object>> nodes) {
        for(Map<String,Object> node:nodes) {
            List<Map<String,Object>> children=(List<Map<String,Object>>)node.get("children");
            if(number(node.get("id"))==6000200L) {
                if(children==null || children.isEmpty()) throw fail(50000,"计价菜单缺少模板");
                Map<String,Object> template=children.get(0); List<Map<String,Object>> copies=new ArrayList<>();
                for(Map<String,Object> company:jdbc.queryForList("SELECT id,short_name FROM sys_branch_company WHERE bool_delete_enum=0 ORDER BY level,id")) {
                    String id=String.valueOf(company.get("id")); Map<String,Object> copy=new LinkedHashMap<>(template);
                    copy.put("branchCompanyId",company.get("id")); copy.put("name",Objects.toString(template.get("name"),"")+id); copy.put("path",template.get("path")+"/"+id);
                    Map<String,Object> meta=new LinkedHashMap<>((Map<String,Object>)template.get("meta")); meta.put("title",company.get("short_name")); copy.put("meta",meta);
                    String redirect=Objects.toString(template.get("redirect"),""); List<String> segments=new ArrayList<>(Arrays.asList(redirect.split("/"))); segments.removeIf(String::isEmpty);
                    if(segments.isEmpty()) throw fail(50000,"计价菜单跳转路径无效"); segments.add(segments.size()-1,id); copy.put("redirect",String.join("/",segments));
                    List<Map<String,Object>> leaves=new ArrayList<>();
                    List<Map<String,Object>> original=(List<Map<String,Object>>)template.get("children");
                    if(original!=null) for(Map<String,Object> leaf:original) { Map<String,Object> cloned=new LinkedHashMap<>(leaf); cloned.put("branchCompanyId",company.get("id")); cloned.put("name",Objects.toString(leaf.get("name"),"")+id); leaves.add(cloned); }
                    copy.put("children",leaves); copies.add(copy);
                }
                node.put("children",copies);
            } else if(children!=null) expandPricing(children);
        }
    }

    public Map<String,Object> info(Map<String,Object> user) {
        long id=number(user.get("id")); List<Map<String,Object>> roles=roles(id);
        List<Map<String,Object>> allMenus=new ArrayList<>();
        if(isAdmin(roles)) allMenus=jdbc.queryForList("SELECT "+MENU_COLUMNS+" FROM sys_menu m WHERE m.bool_delete_enum=0");
        else if(!roles.isEmpty()) allMenus=jdbc.queryForList("SELECT "+MENU_COLUMNS+" FROM sys_menu m WHERE m.bool_delete_enum=0 AND (m.bool_main_system=1 OR m.id IN (SELECT rml.menu_id FROM sys_user_role_link url INNER JOIN sys_role r ON url.role_id=r.id INNER JOIN sys_role_menu_link rml ON r.id=rml.role_id WHERE url.user_id=? AND url.bool_delete_enum=0 AND r.bool_delete_enum=0 AND rml.bool_delete_enum=0)) ORDER BY m.sort",id);
        List<String> permissions=allMenus.stream().map(m -> Objects.toString(m.get("permission"),"")).filter(p -> !p.trim().isEmpty()).collect(Collectors.toList());
        List<Map<String,Object>> visible=allMenus.stream().filter(m -> !truth(m.get("hidden"))).collect(Collectors.toList());
        List<Map<String,Object>> main=jdbc.queryForList("SELECT id FROM sys_menu WHERE bool_delete_enum=0 AND bool_main_system=1");
        if(main.size()>1) throw fail(50000,"主系统菜单配置不唯一");
        if(!main.isEmpty()) {
            long mainId=number(main.get(0).get("id"));
            if(visible.stream().anyMatch(m -> number(m.get("id"))==mainId)) visible=visible.stream().filter(m -> number(m.get("pid"))==mainId || (number(m.get("pid"))==0 && number(m.get("id"))!=mainId)).collect(Collectors.toList());
        }
        visible.sort(Comparator.comparingLong(m -> number(m.get("sort"))));
        List<Map<String,Object>> modelMenus=new ArrayList<>();
        for(Map<String,Object> m:visible) if(number(m.get("category"))==0 && (modules.contains("enclosure") || number(m.get("id"))!=11)) modelMenus.add(map("id",m.get("id"),"name",m.get("name"),"icon",m.get("icon"),"iframe",truth(m.get("iframe")),"redirect",m.get("redirect"),"isTripartite","初鸣云招采".equals(m.get("name"))));
        Map<String,Object> company=configObject("COMPANY_NAME");
        if(company.isEmpty()) throw fail(50000,"获取公司配置信息失败!!!");
        Map<String,Object> result=map("id",user.get("id"),"name",user.get("name"),"username",user.get("username"),"ddUserId",user.get("dd_user_id"),"ddDeptId",user.get("dd_dept_id"),"oaUserId",user.get("oa_user_id"),"sex",user.get("sex"),"phone",user.get("phone"),"email",user.get("email"),"companyName",number(user.get("user_type"))==1?company.get("companyName"):user.get("name"),"roles",roles.stream().map(r -> r.get("permission")).collect(Collectors.toList()),"roleNames",roles.stream().map(r -> r.get("name")).collect(Collectors.toList()),"deptId",user.get("department_id"),"dept",lookupName("sys_department",user.get("department_id")),"job",lookupName("sys_job",user.get("job_id")),"menus",modelMenus,"isEnabled",truth(user.get("is_enabled")),"permissions",permissions,"inventoryNotifyPerm",user.get("inventory_notify_perm")==null?null:truth(user.get("inventory_notify_perm")),"userType",user.get("user_type"));
        result.putAll(map("companyLogo",logo("LOGO"),"productLabelLogoPath",logo("productLabelLogo"),"website",company.get("website"),"telephone",company.get("telephone"),"enclosureType",modules.contains("enclosure")?0:1,"projectTypes",(modules.contains("enclosure")?8:0)|(modules.contains("mes")?3:0),"boolSmartLine",modules.contains("smartLine")?1:0,"boolBridge",modules.contains("bridge")?1:0,"productMenu",(productMenu.contains("artifact")?19:0)+(productMenu.contains("enclosure")?4:0)+(productMenu.contains("auxiliary_material")?8:0)));
        List<Integer> mes=new ArrayList<>(), inventory=new ArrayList<>(), factory=new ArrayList<>(), building=new ArrayList<>();
        if(mesEnum.contains("building")) { mes.add(1); inventory.add(1); factory.add(1); building.add(1); }
        if(mesEnum.contains("bridge")) { mes.add(2); inventory.add(2); factory.add(2); }
        if(mesEnum.contains("grid")) inventory.add(8);
        if(mesEnum.contains("enclosure")) factory.add(4);
        List<Integer> systems=Arrays.stream(menuEnum.split(",")).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
        List<Map<String,Object>> home=jdbc.queryForList("SELECT is_enable FROM sys_home_enable_config WHERE id=1 AND bool_delete_enum=0");
        List<Map<String,Object>> material=jdbc.queryForList("SELECT value FROM wms_basic_config WHERE name=? AND bool_delete_enum=0","物料获取配置");
        Object gain=material.isEmpty()?1:readObject(String.valueOf(material.get(0).get("value"))).get("inventoryGainType");
        String drawing=configValue("NUMERICAL_CONTROL_DRAWING_MATCH_RANGE");
        result.putAll(map("mesProductEnum",mes,"mesInventoryProductEnum",inventory,"factoryProductEnum",factory,"buildingAndBridgeModels",building,"menuSystemEnum",systems,"inventoryGainType",gain,"homePageShowConfig",home.isEmpty()?null:truth(home.get(0).get("is_enable")),"drawingMatchRange",drawing==null?null:Integer.valueOf(drawing)));
        return result;
    }
    private Object lookupName(String table,Object id) {
        if(id==null) return null;
        List<Map<String,Object>> rows=jdbc.queryForList("SELECT name FROM "+table+" WHERE id=? AND bool_delete_enum=0",id); return rows.isEmpty()?null:rows.get(0).get("name");
    }
    private boolean conforms(String password,boolean admin) {
        Map<String,Object> policy=configObject("PASSWORD_POLICY");
        if(policy.isEmpty() || Boolean.FALSE.equals(policy.get("loginVerification"))) return true;
        return (!(admin||truth(policy.get("containNumbers"))) || password.matches(".*\\d.*"))
            && (!(admin||truth(policy.get("containLetter"))) || password.matches(".*[a-zA-Z].*"))
            && (!(admin||truth(policy.get("containSpecialCharacters"))) || password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{}|;:,.<>?].*"))
            && password.length()>=(admin?8:number(policy.get("minLength")));
    }
    private String configValue(String code) { List<Map<String,Object>> rows=jdbc.queryForList("SELECT value FROM sys_config WHERE code=? AND bool_delete_enum=0",code); return rows.isEmpty()?null:Objects.toString(rows.get(0).get("value"),null); }
    private Map<String,Object> configObject(String code) { String value=configValue(code); return value==null||value.trim().isEmpty()?new LinkedHashMap<>():readObject(value); }
    private Map<String,Object> readObject(String value) { try { return json.readValue(value,new TypeReference<Map<String,Object>>(){}); } catch(Exception e) { throw fail(50000,"系统配置格式错误"); } }
    private String logo(String code) { String value=configValue(code); if(value==null||value.trim().isEmpty())return ""; try { List<Map<String,Object>> list=json.readValue(value,new TypeReference<List<Map<String,Object>>>(){}); return list.isEmpty()?"":Objects.toString(list.get(0).get("path"),""); } catch(Exception e) { throw fail(50000,"系统配置格式错误"); } }
    private static String marks(int n) { return String.join(",",Collections.nCopies(n,"?")); }
    static boolean truth(Object value) { return Boolean.TRUE.equals(value) || (value instanceof Number && ((Number)value).intValue()!=0) || "1".equals(value); }
    static long number(Object value) { return value instanceof Number?((Number)value).longValue():0L; }
    static Map<String,Object> map(Object... values) { Map<String,Object> result=new LinkedHashMap<>(); for(int i=0;i<values.length;i+=2) result.put(String.valueOf(values[i]),values[i+1]); return result; }
    static AuthFailure fail(int code,String message) { return new AuthFailure(code,message); }
    public static final class AuthFailure extends RuntimeException { public final int code; AuthFailure(int code,String message) { super(message); this.code=code; } }
}
