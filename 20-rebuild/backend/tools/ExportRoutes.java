import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import org.springframework.core.MethodIntrospector;
import org.springframework.web.context.support.StaticWebApplicationContext;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/** Annotation metadata only: no original application, controller or runner is instantiated. */
public class ExportRoutes {
    static class Reader extends RequestMappingHandlerMapping {
        RequestMappingInfo inspect(Method method, Class<?> type) { return getMappingForMethod(method, type); }
    }

    public static void main(String[] args) throws Exception {
        StaticWebApplicationContext context = new StaticWebApplicationContext();
        context.refresh();
        Reader reader = new Reader();
        reader.setApplicationContext(context);
        reader.afterPropertiesSet();
        List<Map<String,Object>> routes = new ArrayList<>();
        List<Map<String,String>> unresolved = new ArrayList<>();
        for (String name : Files.readAllLines(Paths.get(args[0]), StandardCharsets.UTF_8)) {
            if (name.trim().isEmpty()) continue;
            try {
                Class<?> type = Class.forName(name, false, ExportRoutes.class.getClassLoader());
                Map<Method, RequestMappingInfo> methods = MethodIntrospector.selectMethods(type,
                    (MethodIntrospector.MetadataLookup<RequestMappingInfo>) method -> reader.inspect(method, type));
                for (Map.Entry<Method, RequestMappingInfo> entry : methods.entrySet()) {
                    Method method = entry.getKey();
                    RequestMappingInfo mapping = entry.getValue();
                    for (String path : mapping.getPatternValues()) {
                        Map<String,Object> row = new LinkedHashMap<>();
                        row.put("controller", name);
                        row.put("handler", method.toGenericString());
                        row.put("path", path);
                        row.put("http_methods", mapping.getMethodsCondition().getMethods());
                        row.put("params", mapping.getParamsCondition().toString());
                        row.put("headers", mapping.getHeadersCondition().toString());
                        row.put("consumes", mapping.getConsumesCondition().toString());
                        row.put("produces", mapping.getProducesCondition().toString());
                        routes.add(row);
                    }
                }
            } catch (LinkageError | RuntimeException | ClassNotFoundException error) {
                Map<String,String> failure = new LinkedHashMap<>();
                failure.put("controller", name);
                failure.put("error_type", error.getClass().getName());
                unresolved.add(failure);
            }
        }
        routes.sort(Comparator.comparing(row -> row.get("path") + ":" + row.get("handler")));
        Map<String,Object> result = new LinkedHashMap<>();
        result.put("evidence", "Spring merged class/method annotations on source-compiled classes; empty metadata context");
        result.put("runtime_registration_verified", false);
        result.put("limitations", Arrays.asList("Static candidates only; original business controllers are not registered in the new first-chain runtime", "Empty HTTP methods means ANY; conditions remain part of each mapping", "No controller or original application was instantiated"));
        result.put("routes", routes);
        result.put("unresolved", unresolved);
        new ObjectMapper().writerWithDefaultPrettyPrinter().writeValue(Paths.get(args[1]).toFile(), result);
        context.close();
        System.out.println("Static mapping candidates=" + routes.size() + "; unresolved controllers=" + unresolved.size());
        if (!unresolved.isEmpty()) throw new IllegalStateException("Inspect unresolved metadata before treating inventory as complete");
    }
}
