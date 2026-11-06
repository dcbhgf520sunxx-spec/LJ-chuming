import cn.hutool.crypto.SecureUtil;
import com.hzchum.scim.common.core.api.third_party_api.BoChuNesting;
import com.ljaps.rebuild.business.BusinessConfiguration;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;

/** Offline constructor/header probe only. Compile/run after all integration preparation is ready. */
public final class BimBochuPreparationProbe {
    public static void main(String[] args) throws Exception {
        BusinessConfiguration config = new BusinessConfiguration();
        Method bean = BusinessConfiguration.class.getMethod("bimfaceClient", boolean.class,
                String.class, String.class, String.class, String.class, String.class);
        boolean defaultDisabled = false;
        for (Annotation annotation : bean.getParameterAnnotations()[0]) {
            if (annotation instanceof Value)
                defaultDisabled = "${ljaps.integrations.bim.enabled:false}".equals(((Value) annotation).value());
        }
        require(defaultDisabled, "BIM must explicitly default to disabled");
        require(config.bimfaceClient(false, "", "", "", "", "") != null, "Disabled BIM bean");
        expectMissingBim(config, "", "");
        expectMissingBim(config, "probe-app", " ");
        expectMissingBim(config, " ", "probe-secret");
        require(config.bimfaceClient(true, "probe-app", "probe-secret",
                "http://127.0.0.1:1", "http://127.0.0.1:1/file/", "http://127.0.0.1:1/bdfs/") != null,
                "Enabled BIM constructor with explicit local endpoints");
        // Constructors and headers only: no HTTP/SDK operation is called.
        if (args.length == 1 && "--missing-bochu".equals(args[0])) {
            try {
                BoChuNesting.headers("probe-team");
                throw new AssertionError("Missing BoChu credentials must be rejected");
            } catch (IllegalArgumentException expected) {
                require(expected.getMessage().contains("LJAPS_BOCHU_"), "Named missing environment variable");
            }
        } else {
            String appId = System.getenv("LJAPS_BOCHU_APP_ID");
            String secret = System.getenv("LJAPS_BOCHU_SECRET");
            require(appId != null && secret != null, "Use disposable placeholder environment values for this probe");
            HttpHeaders headers = BoChuNesting.headers("probe-team");
            String time = headers.getFirst("X-FS-Time");
            LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            require(appId.equals(headers.getFirst("X-FS-Appid")), "App header must match signing app");
            require("probe-team".equals(headers.getFirst("X-FS-Orgcode")), "Business team must pass through");
            require("UTF-8".equals(headers.getFirst("X-FS-Encode")), "Existing common encoding");
            String expectedToken = SecureUtil.md5(appId + '\n' + secret + '\n' + time).toLowerCase();
            require(expectedToken.equals(headers.getFirst("X-FS-Token")), "Original newline/MD5 signature");
            require(!BoChuNesting.headers().containsKey("X-FS-Orgcode"), "Legacy no-org path stays without org header");
        }
        System.out.println("BIM/BoChu offline configuration probe passed; no network operation invoked");
    }

    private static void expectMissingBim(BusinessConfiguration config, String appKey, String appSecret) {
        try {
            config.bimfaceClient(true, appKey, appSecret, "", "", "");
            throw new AssertionError("Enabled BIM must reject missing credentials");
        } catch (IllegalArgumentException expected) {
            require(expected.getMessage().contains("engine.appKey"), "Named BIM credential properties");
        }
    }

    private static void require(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }
}
