package com.ljaps.rebuild.business;

import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import java.lang.reflect.Proxy;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/** Synthetic authorization/files only; emits the actual endpoint SQL for a read-only MySQL probe. */
public final class IfcPerformanceProbe {
    private static final String REVISION = String.join("", Collections.nCopies(64, "a"));
    private static final String NEXT_REVISION = String.join("", Collections.nCopies(64, "b"));
    private static final String BASE = "/api/bim/ifc/127/105/354/" + REVISION;

    public static void main(String[] args) throws Exception {
        Path root = Files.createTempDirectory("ljaps-ifc-http-probe-");
        Path area = root.resolve("127/105/354");
        try {
            Files.createDirectories(area.resolve(REVISION));
            Files.write(area.resolve("current"), REVISION.getBytes(StandardCharsets.US_ASCII));
            Files.write(area.resolve(REVISION).resolve("index.json"), "{\"fixture\":true}".getBytes(StandardCharsets.UTF_8));
            Files.write(area.resolve(REVISION).resolve("model.glb"), new byte[] { 103, 108, 84, 70 });
            Scope scope = new Scope();
            QueryCapture database = new QueryCapture();
            IfcModelController controller = new IfcModelController(root.toString(), scope.projects(), scope.monomers(),
                scope.areas(), database, null, null, null);
            SecurityUser user = new SecurityUser(7L, "fixture", "fixture", null, null, null, null, null, null,
                Collections.emptyList(), null, null, Collections.emptyList(), Collections.emptyList(), true, null,
                Collections.emptyList(), false, false, null, null, null, null);
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user, null));
            controller.progress(127L, 105L, 354L, REVISION);
            check(Arrays.equals(database.arguments, new Object[] { 105L, 354L }), "progress must retain monomer/area scope");
            Files.write(Paths.get(args[0]), database.sql.getBytes(StandardCharsets.UTF_8));
            check("@permission.menu(1009)".equals(IfcModelController.class.getAnnotation(PreAuthorize.class).value()),
                "IFC files must inherit existing menu authorization");
            MockMvc mvc = MockMvcBuilders.standaloneSetup(controller).build();
            String indexTag = '"' + REVISION + "/index.json\"";
            String geometryTag = '"' + REVISION + "/model.glb\"";
            MockHttpServletResponse index = get(mvc, "/index", null);
            check(index.getStatus() == 200 && index.getContentAsString().equals("{\"fixture\":true}"), "index response bytes");
            cacheHeaders(index, indexTag);
            MockHttpServletResponse geometry = get(mvc, "/geometry", null);
            check(geometry.getStatus() == 200 && Arrays.equals(geometry.getContentAsByteArray(), new byte[] { 103, 108, 84, 70 }),
                "geometry response bytes");
            cacheHeaders(geometry, geometryTag);
            for (String endpoint : Arrays.asList("/index", "/geometry")) {
                String tag = endpoint.equals("/index") ? indexTag : geometryTag;
                for (String conditional : Arrays.asList(tag, "W/" + tag, "\"unrelated\", " + tag)) {
                    MockHttpServletResponse response = get(mvc, endpoint, conditional);
                    check(response.getStatus() == 304 && response.getContentAsByteArray().length == 0,
                        "matching ETag must return bodyless 304");
                    cacheHeaders(response, tag);
                }
            }
            check(get(mvc, "/geometry", indexTag).getStatus() == 200, "ETags must distinguish model files");
            scope.allowed = false;
            reject(mvc, "/index", indexTag, "无权查看该项目的模型");
            reject(mvc, "/geometry", "*", "无权查看该项目的模型");
            scope.allowed = true;
            scope.monomer.setProjectId(999L);
            reject(mvc, "/index", indexTag, "单体不存在");
            scope.monomer.setProjectId(127L);
            scope.area.setProjectId(999L);
            reject(mvc, "/index", indexTag, "区域不存在");
            scope.area.setProjectId(127L).setMonomerId(999L);
            reject(mvc, "/geometry", geometryTag, "区域不存在");
            scope.area.setMonomerId(105L);
            Files.write(area.resolve("current"), NEXT_REVISION.getBytes(StandardCharsets.US_ASCII));
            reject(mvc, "/index", indexTag, "IFC 模型版本已更新或不存在");
            Files.createDirectories(area.resolve(NEXT_REVISION));
            Files.copy(area.resolve(REVISION).resolve("index.json"), area.resolve(NEXT_REVISION).resolve("index.json"));
            Files.copy(area.resolve(REVISION).resolve("model.glb"), area.resolve(NEXT_REVISION).resolve("model.glb"));
            reject(mvc, "/geometry", geometryTag, "IFC 模型版本已更新或不存在");
            MockHttpServletResponse next = mvc.perform(MockMvcRequestBuilders.get(BASE.replace(REVISION, NEXT_REVISION) + "/index")
                .header("If-None-Match", indexTag)).andReturn().getResponse();
            check(next.getStatus() == 200 && !indexTag.equals(next.getHeader("ETag")), "new revision must not reuse old body");
            Files.write(area.resolve("current"), REVISION.getBytes(StandardCharsets.US_ASCII));
            MockHttpServletResponse progress = get(mvc, "/progress", indexTag);
            check(progress.getStatus() == 200 && progress.getHeader("ETag") == null, "live progress must not be conditionally cached");
            MockHttpServletResponse details = mvc.perform(MockMvcRequestBuilders.get(BASE + "/components").param("mark", "fixture")
                .header("If-None-Match", indexTag)).andReturn().getResponse();
            check(details.getStatus() == 200 && details.getHeader("ETag") == null, "component details must not be conditionally cached");
            System.out.println("IFC_HTTP_CACHE_PROBE_PASSED: 200/304 bytes, weak/list tags, wildcard authorization and current revision");
        } finally {
            SecurityContextHolder.clearContext();
            try (Stream<Path> files = Files.walk(root)) {
                for (Path file : (Iterable<Path>) files.sorted(java.util.Comparator.reverseOrder())::iterator) Files.delete(file);
            }
        }
    }

    private static MockHttpServletResponse get(MockMvc mvc, String endpoint, String tag) throws Exception {
        org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(BASE + endpoint);
        if (tag != null) request.header("If-None-Match", tag);
        return mvc.perform(request).andReturn().getResponse();
    }

    private static void cacheHeaders(MockHttpServletResponse response, String tag) {
        check(tag.equals(response.getHeader("ETag")), "authenticated model response must carry revision/file ETag");
        String control = response.getHeader("Cache-Control");
        check(control != null && control.contains("private") && control.contains("no-cache") && control.contains("must-revalidate")
            && !control.contains("public") && !control.contains("immutable") && !control.contains("max-age"), "private cache must always revalidate");
        String vary = String.join(",", response.getHeaders("Vary")).toLowerCase(java.util.Locale.ROOT);
        check(vary.contains("authorization") && vary.contains("accept-encoding"), "200 and 304 must vary by credentials and encoding");
    }

    private static void reject(MockMvc mvc, String endpoint, String tag, String message) throws Exception {
        try { get(mvc, endpoint, tag); } catch (Exception exception) {
            Throwable cause = exception;
            while (cause.getCause() != null) cause = cause.getCause();
            check(cause instanceof IllegalArgumentException && message.equals(cause.getMessage()), "specific scope rejection: " + message);
            return;
        }
        throw new AssertionError("Conditional request bypassed authorization: " + message);
    }

    private static void check(boolean value, String message) { if (!value) throw new AssertionError(message); }

    private static final class QueryCapture extends JdbcTemplate {
        String sql;
        Object[] arguments;
        @Override public List<Map<String,Object>> queryForList(String query, Object... args) {
            sql = query; arguments = args; return Collections.emptyList();
        }
        @Override public <T> List<T> queryForList(String query, Class<T> type, Object... args) {
            return Collections.emptyList();
        }
    }

    private static final class Scope {
        boolean allowed = true;
        final PlanMonomer monomer = new PlanMonomer().setId(105L).setProjectId(127L);
        final PlanArea area = new PlanArea().setId(354L).setProjectId(127L).setMonomerId(105L);
        ContractProjectService projects() {
            return proxy(ContractProjectService.class, (method, args) -> {
                check(method.equals("listProjectIdByUser") && args[0].equals(7L), "read current user's project grants");
                return allowed ? Collections.singletonList(127L) : Collections.emptyList();
            });
        }
        PlanMonomerService monomers() {
            return proxy(PlanMonomerService.class, (method, args) -> {
                check(method.equals("getById") && args[0].equals(105L), "requested monomer lookup"); return monomer;
            });
        }
        PlanAreaService areas() {
            return proxy(PlanAreaService.class, (method, args) -> {
                check(method.equals("getById") && args[0].equals(354L), "requested area lookup"); return area;
            });
        }
        @SuppressWarnings("unchecked")
        private static <T> T proxy(Class<T> type, java.util.function.BiFunction<String,Object[],Object> call) {
            return (T) Proxy.newProxyInstance(type.getClassLoader(), new Class<?>[] { type },
                (instance, method, args) -> call.apply(method.getName(), args));
        }
    }
}
