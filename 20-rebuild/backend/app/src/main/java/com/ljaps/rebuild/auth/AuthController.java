package com.ljaps.rebuild.auth;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class AuthController {
    private final AuthService auth;
    public AuthController(AuthService auth) { this.auth=auth; }

    @PostMapping("/login")
    public Map<String,Object> login(@RequestBody Map<String,String> input) { return success(auth.login(input.get("username"),input.get("password"))); }
    @GetMapping("/public-key")
    public Map<String,Object> publicKey() { return success(AuthService.map("publicKey",auth.publicKey(),"algorithm","RSA/ECB/PKCS1Padding")); }
    @GetMapping("/info")
    public Map<String,Object> info(HttpServletRequest request) { return success(auth.info(current(request))); }
    @GetMapping("/menu")
    public Map<String,Object> menu(HttpServletRequest request) { return success(auth.menus(current(request))); }
    @RequestMapping(value="/logout",method={RequestMethod.POST,RequestMethod.DELETE})
    public Map<String,Object> logout(@RequestHeader(value="Authorization",required=false) String token) { auth.logout(token); return success(null); }
    private Map<String,Object> current(HttpServletRequest request) { return auth.authenticate(request.getHeader("Authorization")); }
    static Map<String,Object> success(Object data) { return AuthService.map("code",20000,"message","操作成功","data",data); }
}
