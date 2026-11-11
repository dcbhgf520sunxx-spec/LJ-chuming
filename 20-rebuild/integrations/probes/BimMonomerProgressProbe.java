import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bimface.data.bean.Property;
import com.bimface.data.bean.PropertyGroup;
import com.bimface.data.bean.PropertyItem;
import com.bimface.data.bean.SearchElementIdsResp;
import com.bimface.exception.BimfaceException;
import com.bimface.sdk.BimfaceClient;
import com.bimface.sdk.bean.request.QueryElementIdsRequest;
import com.bimface.sdk.config.Config;
import com.bimface.sdk.config.Endpoint;
import com.bimface.sdk.service.ElementService;
import com.hzchum.scim.bim.core.api.pojo._do.BimModelCommonDO;
import com.hzchum.scim.bim.core.api.pojo._do.BimModelConfigurationDO;
import com.hzchum.scim.bim.core.api.service.BimModelCommonService;
import com.hzchum.scim.bim.core.api.service.BimModelConfigurationService;
import com.hzchum.scim.bim.core.biz.impl.BimModelBizImpl;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo.vo.BimArtifactVO;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectInstallSummary;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReceivingSummary;
import com.hzchum.scim.project.core.api.service.ProjectInstallSummaryService;
import com.hzchum.scim.project.core.api.service.ProjectReceivingSummaryService;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

public final class BimMonomerProgressProbe {
    public static void main(String[] args) throws Exception {
        BimModelCommonDO model = BimModelCommonDO.builder()
                .id(10L).projectId(20L).monomerId(30L).fileId(100L)
                .modelType("file").importMode(1).translateStatus("success").build();
        BimModelConfigurationDO configuration = BimModelConfigurationDO.builder().edition(18).build();
        List<TechArtifact> artifacts = Arrays.asList(
                artifact(1L, "ZERO", 0), artifact(2L, "OK", 2), artifact(3L, "OK", 2),
                artifact(4L, "MISSING", 1), artifact(5L, "OPEN", 1), artifact(6L, "STALE", 1),
                artifact(7L, "CONFLICT", 1));
        OfflineBimface provider = new OfflineBimface();
        MemoryRedis memory = new MemoryRedis();
        memory.values.put("MONOMER_MODEL:30/OK", Arrays.asList("base", "v1a"));
        RedisUtils redis = new RedisUtils();
        inject(redis, "redisTemplate", memory);
        BimModelBizImpl biz = new BimModelBizImpl();
        inject(biz, "bimfaceClient", provider);
        inject(biz, "redisUtils", redis);
        inject(biz, "bimModelCommonService", service(BimModelCommonService.class, "getOne", model));
        inject(biz, "bimModelConfigurationService", service(BimModelConfigurationService.class, "getOne", configuration));
        inject(biz, "contractProjectService", service(ContractProjectService.class, "getById", new ContractProject()));
        inject(biz, "techArtifactService", service(TechArtifactService.class, "list", artifacts));
        inject(biz, "mesBuildingTaskService", service(MesBuildingTaskService.class, "list",
                Arrays.asList(task(2L, 2), task(3L, 2), task(5L, 1))));
        inject(biz, "mesBuildingWarehouseSummaryService", service(MesBuildingWarehouseSummaryService.class, "list",
                Arrays.asList(warehouse(2L, 2), warehouse(3L, 2))));
        inject(biz, "projectInstallSummaryService", service(ProjectInstallSummaryService.class, "list",
                Collections.singletonList(ProjectInstallSummary.builder().productId(5L).actualQuantity(BigDecimal.ONE).build())));
        inject(biz, "projectReceivingSummaryService", service(ProjectReceivingSummaryService.class, "list",
                Arrays.asList(receiving(2L, 2), receiving(3L, 2))));
        Object mapping = attachMappingService(biz, redis, provider);

        requireIds(biz.getArtifactStatus(100L, 4), "7", "v1a", "v1b");
        requireIds(biz.getArtifactStatus(100L, 5), "11", "v1a", "v1b");
        requireIds(biz.getArtifactStatus(100L, 5), "12", "open");
        requireIds(biz.getArtifactStatus(100L, 3), "4", "v1a", "v1b");
        requireIds(biz.getArtifactStatus(100L, 3), "3", "open");
        requireIds(biz.getArtifactStatus(100L, 2), "9", "v1a", "v1b", "open", "usable");
        requireIds(biz.getArtifactStatus(100L, 2), "1", "base", "zero", "shared");

        model.setFileId(101L);
        requireIds(biz.getArtifactStatus(101L, 4), "7", "v2a", "v2b");
        requireIds(biz.getArtifactStatus(101L, 2), "0", "v2a", "v2b", "base", "zero", "open", "usable", "shared");

        model.setFileId(102L);
        provider.failNext = true;
        expectUnavailable(() -> biz.getArtifactStatus(102L, 4), "provider failure must not become no-match");
        requireIds(biz.getArtifactStatus(102L, 4), "7", "v2a", "v2b");
        model.setTranslateStatus("processing");
        expectUnavailable(() -> biz.getArtifactStatus(102L, 4), "pending viewer must not acquire status");
        model.setTranslateStatus("success");
        model.setModelType("integration");
        expectUnavailable(() -> biz.getArtifactStatus(102L, 4), "wrong viewer model type");
        model.setModelType("file");

        model.setFileId(103L);
        requireLookup(mapping, model, 17, "Q\"\\号", Collections.singletonList("open"));
        requireLookup(mapping, model, 17, "MISSING", Collections.emptyList());
        requireLookup(mapping, model, 18, "OK", Arrays.asList("v2a", "v2b", "shared"));
        verifyClickDetails(biz, provider, model);
        System.out.println("BIM monomer progress probe passed (offline)");
    }

    private static void verifyClickDetails(BimModelBizImpl biz, OfflineBimface provider, BimModelCommonDO model) throws Exception {
        BimArtifactVO unrelated = new BimArtifactVO();
        unrelated.setId(777L);
        unrelated.setSerialNumber("UNRELATED");
        inject(biz, "techArtifactService", Proxy.newProxyInstance(TechArtifactService.class.getClassLoader(),
                new Class<?>[]{TechArtifactService.class}, (proxy, method, args) -> {
                    if ("selectArtifactByBim".equals(method.getName())) {
                        return unrelated;
                    }
                    if ("list".equals(method.getName())) {
                        return Arrays.asList(artifact(5L, "OPEN", 1), artifact(50L, "open", 1),
                                artifact(2L, "OK", 2), artifact(3L, "OK", 2));
                    }
                    throw new AssertionError("unexpected artifact operation " + method);
                }));
        inject(biz, "planMonomerService", service(PlanMonomerService.class, "getSimpleById", NameInfo.builder().name("Building").build()));
        inject(biz, "planAreaService", service(PlanAreaService.class, "getSimpleById", NameInfo.builder().name("Zone").build()));

        Long fileId = model.getFileId();
        requireNoDetail(biz.getArtifactInfo(fileId, "base", 1), "null assembly mark");
        provider.baseMark = " ";
        requireNoDetail(biz.getArtifactInfo(fileId, "base", 1), "blank assembly mark");
        requireNoDetail(biz.getArtifactInfo(fileId, "former-model-id", 1), "ID outside current file");
        requireNoDetail(biz.getArtifactInfo(fileId, "usable", 1), "reverse mark does not map back to clicked ID");
        requireNoDetail(biz.getArtifactInfo(fileId, "zero", 1), "valid model mark without a business row");
        expectUnavailable(() -> biz.getArtifactInfo(fileId, "v2a", 1), "duplicate business rows are ambiguous");
        expectUnavailable(() -> biz.getArtifactInfo(fileId, "shared", 1), "multiple distinct assembly marks are ambiguous");
        provider.failDetail = true;
        expectUnavailable(() -> biz.getArtifactInfo(fileId, "open", 1), "provider failure must not become no-match");
        BimArtifactVO detail = biz.getArtifactInfo(fileId, "open", 1);
        if (detail == null || !Long.valueOf(5L).equals(detail.getId()) || !"OPEN".equals(detail.getSerialNumber())
                || !"Building".equals(detail.getMonomerName()) || !"Zone".equals(detail.getAreaName())) {
            throw new AssertionError("current exact business detail and enrichment were not returned");
        }
    }

    private static void requireNoDetail(BimArtifactVO detail, String scenario) {
        if (detail != null) {
            throw new AssertionError(scenario + " returned unrelated construct " + detail.getSerialNumber());
        }
    }

    private static Object attachMappingService(BimModelBizImpl biz, RedisUtils redis, BimfaceClient provider) throws Exception {
        try {
            Class<?> type = Class.forName("com.hzchum.scim.bim.core.biz.impl.BimMonomerElementService");
            Object mapping = type.getDeclaredConstructor().newInstance();
            inject(mapping, "redisUtils", redis);
            inject(mapping, "bimfaceClient", provider);
            inject(mapping, "enabled", true);
            inject(biz, "bimMonomerElementService", mapping);
            return mapping;
        } catch (ClassNotFoundException baseline) {
            // The same probe can exercise the original service before the mapping change.
            return null;
        }
    }

    private static void requireLookup(Object mapping, BimModelCommonDO model, Integer edition, String number, List<String> expected)
            throws ReflectiveOperationException {
        Object actual = mapping.getClass().getMethod("getElementIds", BimModelCommonDO.class, Integer.class, String.class)
                .invoke(mapping, model, edition, number);
        if (!expected.equals(actual)) {
            throw new AssertionError("fresh lookup for " + number + " expected " + expected + " but got " + actual);
        }
    }

    private static TechArtifact artifact(long id, String number, int quantity) {
        return TechArtifact.builder().id(id).monomerId(30L).areaId(40L).serialNumber(number).quantity(quantity).build();
    }

    private static MesBuildingTask task(long id, int quantity) {
        return MesBuildingTask.builder().productId(id).inProductionQuantity(quantity).build();
    }

    private static MesBuildingWarehouseSummary warehouse(long id, int quantity) {
        return MesBuildingWarehouseSummary.builder().productId(id).quantity(BigDecimal.valueOf(quantity)).build();
    }

    private static ProjectReceivingSummary receiving(long id, int quantity) {
        return ProjectReceivingSummary.builder().productId(id).quantity(BigDecimal.valueOf(quantity)).build();
    }

    private static void requireIds(Map<String, List<String>> grouped, String status, String... expected) {
        List<String> actual = grouped.getOrDefault(status, Collections.emptyList());
        if (actual.size() != expected.length || !new HashSet<>(actual).equals(new HashSet<>(Arrays.asList(expected)))) {
            throw new AssertionError("status " + status + " expected " + Arrays.toString(expected) + " but got " + actual);
        }
    }

    private static void expectUnavailable(Runnable call, String assertion) {
        try {
            call.run();
        } catch (IllegalArgumentException | IllegalStateException expected) {
            return;
        }
        throw new AssertionError(assertion);
    }

    private static void inject(Object target, String field, Object value) throws ReflectiveOperationException {
        Field member = target.getClass().getDeclaredField(field);
        member.setAccessible(true);
        member.set(target, value);
    }

    private static <T> T service(Class<T> type, String method, Object result) {
        return type.cast(Proxy.newProxyInstance(type.getClassLoader(), new Class<?>[]{type}, (proxy, called, args) -> {
            if (method.equals(called.getName())) {
                return result;
            }
            throw new AssertionError("unexpected service call " + called);
        }));
    }

    private static final class OfflineBimface extends BimfaceClient {
        private static final Endpoint ENDPOINT = new Endpoint();
        private boolean failNext;
        private boolean failDetail;
        private String baseMark;
        private final ElementService elementService = new ElementService(ENDPOINT, new Config(), null) {
            @Override
            public List<String> getElementIdsV2(Long fileId, QueryElementIdsRequest request) {
                String prefix = fileId == 100L ? "v1" : "v2";
                return Arrays.asList(prefix + "a", prefix + "b", "base", "zero", "open", "usable", "shared", prefix + "b");
            }

            @Override
            public Property getSingleModelElementV2(Long fileId, String elementId, boolean includeProperties) throws BimfaceException {
                if (failDetail) {
                    failDetail = false;
                    throw new BimfaceException("offline detail failure");
                }
                Property property = new Property(elementId);
                List<PropertyItem> marks;
                switch (elementId) {
                    case "base":
                        marks = Collections.singletonList(new PropertyItem("Assembly mark", baseMark));
                        break;
                    case "zero":
                        marks = Collections.singletonList(new PropertyItem("Assembly mark", "ZERO"));
                        break;
                    case "v2a":
                        marks = Collections.singletonList(new PropertyItem("Assembly mark", "OK"));
                        break;
                    case "shared":
                        marks = Arrays.asList(new PropertyItem("Assembly mark", "OK"), new PropertyItem("Assembly mark", "CONFLICT"));
                        break;
                    default:
                        marks = Collections.singletonList(new PropertyItem("Assembly_mark", "OPEN"));
                }
                property.setProperties(Collections.singletonList(new PropertyGroup("Tekla_Common", marks)));
                return property;
            }
        };

        private OfflineBimface() {
            super("offline", "offline", ENDPOINT, new Config());
        }

        @Override
        public ElementService getElementService() {
            return elementService;
        }

        @Override
        public String getPaginationContextId() {
            return "offline";
        }

        @Override
        public List<SearchElementIdsResp> getElements(String request) throws BimfaceException {
            if (failNext) {
                failNext = false;
                throw new BimfaceException("offline transient fixture");
            }
            JSONObject body = JSON.parseObject(request);
            String target = body.getJSONArray("targetIds").getString(0);
            String prefix = "100".equals(target) ? "v1" : "v2";
            JSONObject lookup = body.getJSONObject("query").getJSONObject("in");
            List<Object> oldEdition = lookup.getJSONArray("Assembly_mark");
            if (oldEdition != null) {
                return oldEdition.contains("Q\"\\号")
                        ? Collections.singletonList(new SearchElementIdsResp(target, Collections.singletonList("open")))
                        : Collections.emptyList();
            }
            List<Object> marks = lookup.getJSONArray("Assembly mark");
            if (marks.contains("OK")) {
                return Arrays.asList(
                        new SearchElementIdsResp(target, Arrays.asList(prefix + "a", prefix + "a")),
                        new SearchElementIdsResp(target, Arrays.asList(prefix + "b", "shared")),
                        new SearchElementIdsResp("999", Collections.singletonList("base")));
            }
            if (marks.contains("ZERO")) {
                return Collections.singletonList(new SearchElementIdsResp(target, Collections.singletonList("zero")));
            }
            if (marks.contains("OPEN")) {
                return Collections.singletonList(new SearchElementIdsResp(target, Collections.singletonList("open")));
            }
            if (marks.contains("STALE")) {
                return Collections.singletonList(new SearchElementIdsResp(target, Arrays.asList("usable", "former-model-id")));
            }
            if (marks.contains("CONFLICT")) {
                return Collections.singletonList(new SearchElementIdsResp(target, Collections.singletonList("shared")));
            }
            return Collections.emptyList();
        }
    }

    private static final class MemoryRedis extends RedisTemplate<String, Object> {
        private final Map<String, Object> values = new HashMap<>();

        @Override
        @SuppressWarnings("unchecked")
        public <K, V> HashOperations<String, K, V> opsForHash() {
            return (HashOperations<String, K, V>) Proxy.newProxyInstance(
                    HashOperations.class.getClassLoader(), new Class<?>[]{HashOperations.class}, (proxy, method, args) -> {
                        String key = args[0] + "/" + args[1];
                        if ("get".equals(method.getName())) {
                            return values.get(key);
                        }
                        if ("put".equals(method.getName())) {
                            values.put(key, args[2]);
                            return null;
                        }
                        throw new AssertionError("unexpected hash operation " + method);
                    });
        }

        @Override
        @SuppressWarnings("unchecked")
        public ValueOperations<String, Object> opsForValue() {
            return (ValueOperations<String, Object>) Proxy.newProxyInstance(
                    ValueOperations.class.getClassLoader(), new Class<?>[]{ValueOperations.class}, (proxy, method, args) -> {
                        if ("get".equals(method.getName())) {
                            return values.get(args[0]);
                        }
                        if ("set".equals(method.getName())) {
                            values.put((String) args[0], args[1]);
                            return null;
                        }
                        throw new AssertionError("unexpected value operation " + method);
                    });
        }
    }
}
