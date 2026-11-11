package com.ljaps.rebuild.auth;

import com.hzchum.scim.system.core.security.GeneratorUserDetailService;
import java.lang.reflect.Proxy;
import javax.servlet.http.HttpServletRequest;

/** Checks which requests are delegated to BIMFACE callback authentication. */
public final class BimCallbackRoutingProbe {
    private static final String TRANSLATE = "/api/model/3DModel/translate/status/callback";

    private static AuthFilter filter(boolean enabled) throws Exception {
        try {
            return AuthFilter.class.getConstructor(AuthService.class, GeneratorUserDetailService.class, boolean.class)
                .newInstance(null, null, enabled);
        } catch (NoSuchMethodException baseline) {
            return AuthFilter.class.getConstructor(AuthService.class, GeneratorUserDetailService.class)
                .newInstance(null, null);
        }
    }

    private static HttpServletRequest request(String method, String path) {
        return (HttpServletRequest) Proxy.newProxyInstance(HttpServletRequest.class.getClassLoader(),
            new Class<?>[] {HttpServletRequest.class}, (proxy, operation, args) -> {
                if ("getMethod".equals(operation.getName())) return method;
                if ("getServletPath".equals(operation.getName())) return path;
                throw new UnsupportedOperationException(operation.getName());
            });
    }

    private static void expect(AuthFilter filter, boolean skip, String method, String path) {
        if (filter.shouldNotFilter(request(method, path)) != skip) {
            throw new AssertionError(method + " " + path + " expected JWT bypass=" + skip);
        }
    }

    public static void main(String[] args) throws Exception {
        AuthFilter disabled = filter(false);
        AuthFilter enabled = filter(true);
        expect(disabled, false, "GET", TRANSLATE);
        expect(enabled, true, "GET", TRANSLATE);
        expect(enabled, false, "POST", TRANSLATE);
        expect(enabled, false, "GET", TRANSLATE + "/");
        expect(enabled, false, "GET", "/api/model/3DModel/integrate/status/callback");
        expect(enabled, false, "GET", "/api/model/3DModel/artifact/status");
        expect(enabled, false, "POST", "/api/model/3DModel/upload");
        expect(enabled, true, "POST", "/api/user/login");
        System.out.println("bim_callback_route_checks=8");
    }
}
