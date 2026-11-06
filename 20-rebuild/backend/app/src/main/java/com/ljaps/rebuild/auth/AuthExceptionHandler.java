package com.ljaps.rebuild.auth;

import java.util.Map;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice(basePackageClasses=AuthController.class)
public class AuthExceptionHandler {
    @ExceptionHandler(AuthService.AuthFailure.class)
    public Map<String,Object> authFailure(AuthService.AuthFailure error) { return AuthService.map("code",error.code,"message",error.getMessage(),"data",null); }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Map<String,Object> invalidBody(HttpMessageNotReadableException error) { return AuthService.map("code",40000,"message","请求参数格式错误","data",null); }
}
