import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.bimface.api.bean.request.translate.FileTranslateRequest;
import com.bimface.api.bean.response.FileTranslateBean;
import com.bimface.bdfs.bean.dto.FileItemDTO;
import com.bimface.exception.BimfaceException;
import com.bimface.sdk.BimfaceClient;
import com.hzchum.scim.bim.core.api.pojo._do.BimModelCommonDO;
import com.hzchum.scim.bim.core.api.pojo._do.BimModelConfigurationDO;
import com.hzchum.scim.bim.core.api.pojo.vo.BimEngineStatusResponseVO;
import com.hzchum.scim.bim.core.mapper.BimModelCommonMapper;
import com.hzchum.scim.bim.core.service.BimModelCommonServiceImpl;
import com.hzchum.scim.bim.core.api.service.BimModelConfigurationService;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.pojo._do.Attachment;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.PlanApproveCacheObjectDTOParam;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.PlanTechnologicalAchievementApproveRecordService;
import com.hzchum.scim.rest.controller.bim.BimModelController;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.pojo._do.SysBusinessDataStatistics;
import com.hzchum.scim.system.core.api.service.BimModelRestrictConfigService;
import com.hzchum.scim.system.core.api.service.ConfigService;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.SimpleTransactionStatus;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.web.multipart.MultipartFile;

/** Exercises production conversion code with an offline SDK, mapper and Redis boundary. */
public final class BimModelConversionProbe {
    private static final long MODEL_ID = 34L;
    private static final long FILE_ID = 72L;
    private static final String TOKEN = "0123456789abcdef0123456789abcdef";
    private static final String NONCE = "probe-nonce";

    public static void main(String[] args) throws Exception {
        ((Logger)LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME)).setLevel(Level.WARN);
        MapperBuilderAssistant mapper = new MapperBuilderAssistant(new MybatisConfiguration(), "probe");
        TableInfoHelper.initTableInfo(mapper, BimModelCommonDO.class);
        TableInfoHelper.initTableInfo(mapper, SysBusinessDataStatistics.class);
        TableInfoHelper.initTableInfo(mapper, PlanMonomer.class);
        if (args.length == 1 && "upload".equals(args[0])) {
            checkUploads();
            return;
        }
        checkDeadlines();
        Fixture failed = new Fixture();
        failed.vendorResult("failed", null);
        BimEngineStatusResponseVO failure = failed.service.getTranslate(12L, null);
        require("failed".equals(failure.getStatus()), "polling must persist and return authoritative conversion failure");
        require(failed.writes == 1 && failed.quota == 0, "failed conversion must not be counted as a successful import");

        Fixture succeeded = new Fixture();
        succeeded.vendorResult("success", new String[] {"https://example.invalid/tiny"});
        require("success".equals(succeeded.service.getTranslate(12L, null).getStatus()), "one thumbnail must not block successful conversion");
        require("https://example.invalid/tiny".equals(succeeded.row.getFileTinyThumbnail()), "single thumbnail should be retained");
        require(succeeded.writes == 1 && succeeded.quota == 1, "success and quota must be updated once");
        require(succeeded.callback(TOKEN, FILE_ID, "success", succeeded.signature(FILE_ID, "success")) == 200, "valid duplicate callback should acknowledge completed job");
        require(succeeded.writes == 1 && succeeded.quota == 1, "duplicate callback must not recount a polled success");

        Fixture pending = new Fixture();
        pending.vendorResult("processing", null);
        require("processing".equals(pending.service.getTranslate(12L, null).getStatus()), "pending translation stays processing");
        require(pending.callback(TOKEN, FILE_ID, "success", pending.signature(FILE_ID, "success")) == 503, "early callback should request retry when authoritative status is still pending");
        require(pending.writes == 0 && pending.quota == 0, "pending response cannot update state or quota");
        pending.vendorUnavailable = true;
        require("processing".equals(pending.service.getTranslate(12L, null).getStatus()), "transient SDK errors must leave a retryable status");
        require(pending.callback(TOKEN, FILE_ID, "failed", pending.signature(FILE_ID, "failed")) == 503, "transient callback query should request retry");
        require(pending.writes == 0 && pending.quota == 0, "transient SDK failure cannot finalize");
        pending.vendorUnavailable = false;
        pending.vendorResult("success", null);
        require(pending.callback(TOKEN, FILE_ID, "failed", pending.signature(FILE_ID, "failed")) == 200, "signed callback should use current vendor status");
        require("success".equals(pending.row.getTranslateStatus()) && pending.quota == 1, "callback payload status is not the persisted authority");

        Fixture invalid = new Fixture();
        require(invalid.callback("wrong", FILE_ID, "success", invalid.signature(FILE_ID, "success")) == 403, "wrong callback token should be forbidden");
        require(invalid.callback(TOKEN, FILE_ID, "success", "bad-signature") == 403, "wrong vendor signature should be forbidden");
        require(invalid.callback(TOKEN, FILE_ID + 1, "success", invalid.signature(FILE_ID + 1, "success")) == 403, "token cannot authorize another file");
        require(invalid.callback(TOKEN, FILE_ID, "success", null) == 400, "missing vendor signature should yield bad request");
        invalid.row.setAttachmentId(15L);
        require(invalid.callback(TOKEN, FILE_ID, "success", invalid.signature(FILE_ID, "success")) == 403, "a prior attachment token cannot authorize a replacement with the same file ID");
        invalid.tokenExists = false;
        require(invalid.callback(TOKEN, FILE_ID, "success", invalid.signature(FILE_ID, "success")) == 403, "expired callback token should be forbidden");
        require(invalid.vendorReads == 0 && invalid.writes == 0, "unauthorized callback must never query vendor or write");

        Fixture raced = new Fixture();
        raced.vendorResult("success", null);
        raced.winElsewhere = true;
        require("success".equals(raced.service.getTranslate(12L, null).getStatus()), "losing status writer should read back winner");
        require(raced.writes == 0 && raced.quota == 0, "losing status writer cannot count a competing completion");
        System.out.println("BIM conversion offline probe passed (poll, callbacks, transient/terminal states, competing updates)");
        checkUploads();
    }

    private static void checkDeadlines() throws Exception {
        Fixture interruptedUpload = new Fixture();
        interruptedUpload.row.setTranslateStatus("uploadProcessing");
        interruptedUpload.row.setCreateTime(LocalDateTime.now().minusHours(3));
        BimEngineStatusResponseVO upload = interruptedUpload.service.getTranslate(12L, null);
        require("uploadFailed".equals(upload.getStatus()) && FILE_ID == upload.getFileId(),
                "interrupted upload should expire with its previous vendor file retained");
        require(interruptedUpload.vendorReads == 0 && interruptedUpload.writes == 1,
                "an upload timeout must not query the retained vendor file");

        Fixture interruptedConversion = new Fixture();
        interruptedConversion.row.setCreateTime(LocalDateTime.now().minusHours(25));
        interruptedConversion.vendorUnavailable = true;
        require("failed".equals(interruptedConversion.service.getTranslate(12L, null).getStatus()),
                "conversion deadline must release an interrupted job");
        require(interruptedConversion.writes == 1 && interruptedConversion.quota == 0,
                "expired conversion must not use successful conversion quota");

        Fixture lateSuccess = new Fixture();
        lateSuccess.row.setCreateTime(LocalDateTime.now().minusHours(25));
        lateSuccess.vendorResult("success", null);
        require("success".equals(lateSuccess.service.getTranslate(12L, null).getStatus()) && lateSuccess.quota == 1,
                "authoritative success takes precedence over the local conversion deadline");
    }

    private static void checkUploads() throws Exception {
        try {
            new BimModelCommonServiceImpl().newUploadModel(null, 12L, null, null);
            throw new AssertionError("disabled upload must be rejected before writing attachments");
        } catch (IllegalArgumentException expected) {
            require(expected.getMessage().contains("未启用"), "disabled upload must be rejected before writing attachments");
        }
        new UploadFixture(false, false).run();
        new UploadFixture(true, false).run();
        new UploadFixture(false, true).run();
        new UploadFixture(false, false).checkActiveJobGuards();
        System.out.println("BIM upload offline probe passed (post-commit start, separate staged bytes, old-file retention, active-job guards, rollback cleanup, bound callback URL)");
    }

    private static final class UploadFixture {
        private final BimModelCommonServiceImpl service = new BimModelCommonServiceImpl();
        private final boolean nullUpload;
        private final boolean rollback;
        private final Path directory = Files.createTempDirectory("ljaps bim probe ");
        private final Path staged = directory.resolve("fixture model.ifc");
        private final CountDownLatch workerDone = new CountDownLatch(1);
        private final AtomicReference<String> workerError = new AtomicReference<>();
        private volatile boolean committed;
        private volatile boolean uploadInvoked;
        private volatile boolean cleaned;
        private volatile String storedStatus;
        private volatile String callbackKey;
        private BimModelCommonDO existingModel;
        private volatile BimModelCommonDO queued;

        UploadFixture(boolean nullUpload, boolean rollback) throws Exception {
            this.nullUpload = nullUpload;
            this.rollback = rollback;
            set(service, "bimEnabled", true);
            set(service, "projectId", "probe-project");
            set(service, "translateCallbackBaseUrl", "https://example.invalid/bim");
            ConfigProperties configuration = new ConfigProperties();
            configuration.setFilePath(directory + "/");
            configuration.setUrl("http://127.0.0.1:3122/");
            set(service, "configProperties", configuration);
            set(service, "planMonomerService", proxy(PlanMonomerService.class, (target, method, args) -> {
                require("getOne".equals(method.getName()) && ((LambdaQueryWrapper<?>)args[0]).getSqlSegment().endsWith("FOR UPDATE"),
                        "upload and delete must lock the monomer");
                return PlanMonomer.builder().id(12L).projectId(13L).build();
            }));
            set(service, "approveRecordService", proxy(PlanTechnologicalAchievementApproveRecordService.class, (target, method, args) -> null));
            set(service, "contractProjectService", proxy(ContractProjectService.class, (target, method, args) ->
                    ContractProject.builder().id(13L).status(-1).build()));
            set(service, "bimModelConfigurationService", proxy(BimModelConfigurationService.class, (target, method, args) ->
                    BimModelConfigurationDO.builder().monomerId(12L).importMode(1).build()));
            set(service, "configService", proxy(ConfigService.class, (target, method, args) -> null));
            if (nullUpload) {
                existingModel = BimModelCommonDO.builder().id(MODEL_ID).fileId(73L).modelType("file").translateStatus("success")
                        .integrationStatus("processing_no").attachmentId(13L).successQuantity(1L).build();
            }
            set(service, "attachmentService", proxy(AttachmentService.class, (target, method, args) -> {
                if ("uploadFile".equals(method.getName())) {
                    require(args.length == 3 && UUID.fromString((String)args[2]).toString().equals(args[2]), "staged names must use a per-job UUID");
                    Files.write(staged, new byte[] {10, 20, 30});
                    return Attachment.builder().id(14L).relativePath(staged.getFileName().toString()).build();
                }
                if ("deleteFile".equals(method.getName())) {
                    cleaned = Files.deleteIfExists(staged);
                    if (nullUpload) workerDone.countDown();
                    return cleaned;
                }
                throw new AssertionError("Unexpected attachment operation " + method.getName());
            }));
            set(service, "baseMapper", proxy(BimModelCommonMapper.class, (target, method, args) -> {
                switch (method.getName()) {
                    case "selectOne":
                        require(((LambdaQueryWrapper<?>)args[0]).getSqlSegment().endsWith("FOR UPDATE"),
                                "upload and delete must read the current model with a row lock");
                        return existingModel;
                    case "selectById":
                        return queued;
                    case "insert":
                        queued = (BimModelCommonDO) args[0];
                        require("uploadProcessing".equals(queued.getTranslateStatus()), "queued job state");
                        queued.setId(MODEL_ID);
                        storedStatus = queued.getTranslateStatus();
                        return 1;
                    case "update":
                        if (args[0] != null) {
                            queued = (BimModelCommonDO) args[0];
                            require(queued.getFileId() == 73L && "uploadProcessing".equals(queued.getTranslateStatus()),
                                    "replacement must keep the previous file ID while the upload is pending");
                            storedStatus = queued.getTranslateStatus();
                            return 1;
                        }
                        LambdaUpdateWrapper<?> update = (LambdaUpdateWrapper<?>) args[1];
                        String where = update.getSqlSegment();
                        Map<String, Object> params = update.getParamNameValuePairs();
                        checkWorker(where.contains("attachment_id") && params.containsValue(14L), "upload worker must match its attachment/job");
                        if (nullUpload) {
                            checkWorker(params.values().stream().filter(value -> Long.valueOf(73L).equals(value)).count() == 2,
                                    "upload failure must match and preserve the previous file ID");
                        }
                        storedStatus = params.containsValue("uploadFailed") ? "uploadFailed" : "processing";
                        return 1;
                    default: throw new AssertionError("Unexpected mapper operation " + method.getName());
                }
            }));
            set(service, "bimfaceClient", new BimfaceClient("probe-app", "probe-secret") {
                @Override
                public FileItemDTO uploadFileItem(InputStream stream, String projectId, String parentId,
                        String parentPath, String name, Long length, String sourceId) throws BimfaceException {
                    uploadInvoked = true;
                    checkWorker(committed, "upload must wait for the transaction commit");
                    checkWorker("probe-project".equals(projectId) && projectId.equals(parentId) && "/".equals(parentPath)
                            && "fixture model.ifc".equals(name) && length == 3L, "vendor upload must use configured project and exact staged byte length");
                    try {
                        checkWorker(stream.read() == 10 && stream.read() == 20 && stream.read() == 30 && stream.read() == -1,
                                "vendor upload must receive the staged file bytes");
                    } catch (java.io.IOException e) {
                        throw new BimfaceException("could not read fixture bytes", e);
                    }
                    if (nullUpload) return null;
                    FileItemDTO uploaded = new FileItemDTO();
                    uploaded.setFileId(String.valueOf(FILE_ID));
                    return uploaded;
                }

                @Override public FileTranslateBean translate(FileTranslateRequest request) {
                    checkWorker(!nullUpload && "processing".equals(storedStatus), "translation should start only for a recorded vendor file");
                    checkWorker(request.getSource().getFileId().equals(FILE_ID), "conversion must use returned file ID");
                    String callbackPrefix = "https://example.invalid/bim/api/model/3DModel/translate/status/callback?modelId=34&token=";
                    checkWorker(request.getCallback().startsWith(callbackPrefix), "callback should normalize the base slash");
                    String token = request.getCallback().substring(callbackPrefix.length());
                    checkWorker(("model_translate:" + MODEL_ID + ":" + FILE_ID + ":" + SecureUtil.sha256(token)).equals(callbackKey),
                            "the saved callback key must bind model, file and token digest");
                    workerDone.countDown();
                    FileTranslateBean translation = new FileTranslateBean();
                    translation.setFileId(FILE_ID);
                    translation.setStatus("processing");
                    return translation;
                }
            });
            RedisUtils redis = new RedisUtils();
            set(redis, "redisTemplate", new RedisTemplate<String, Object>() {
                @Override public Boolean expire(String key, long timeout, TimeUnit timeUnit) { return true; }

                @Override public ValueOperations<String, Object> opsForValue() {
                    return proxy(ValueOperations.class, (target, method, args) -> {
                        checkWorker("set".equals(method.getName()) && args.length == 4 && (long) args[2] > 0,
                                "callback token must expire");
                        checkWorker("14".equals(args[1]), "callback record must bind the attachment job");
                        callbackKey = (String) args[0];
                        return null;
                    });
                }
            });
            set(service, "redisUtils", redis);
        }

        void run() throws Exception {
            try {
                TransactionSynchronizationManager.initSynchronization();
                try {
                    MultipartFile file = multipartFile();
                    PlanApproveCacheObjectDTOParam applicant = new PlanApproveCacheObjectDTOParam();
                    applicant.setCreateUserId(15L);
                    require("uploadProcessing".equals(service.newUploadModel(file, 12L, null, applicant).getMessage()), "upload should return queued state");
                    require(!uploadInvoked && Files.exists(staged), "vendor upload must wait for commit");
                    List<TransactionSynchronization> jobs = TransactionSynchronizationManager.getSynchronizations();
                    require(jobs.size() == 1, "queued upload must have a post-transaction job");
                    if (rollback) {
                        jobs.get(0).afterCompletion(TransactionSynchronization.STATUS_ROLLED_BACK);
                        require(!uploadInvoked && !Files.exists(staged), "rollback should remove staging file without vendor upload");
                        return;
                    }
                    committed = true;
                    jobs.get(0).afterCommit();
                    jobs.get(0).afterCompletion(TransactionSynchronization.STATUS_COMMITTED);
                } finally {
                    TransactionSynchronizationManager.clearSynchronization();
                }
                require(workerDone.await(5, TimeUnit.SECONDS), "committed worker did not reach the expected result");
                require(workerError.get() == null, workerError.get());
                require(cleaned && !Files.exists(staged), "worker must clean the local staged attachment");
                require((nullUpload ? "uploadFailed" : "processing").equals(storedStatus), "worker must persist upload result");
            } finally {
                Files.deleteIfExists(staged);
                Files.deleteIfExists(directory);
            }
        }

        void checkActiveJobGuards() throws Exception {
            try {
                existingModel = BimModelCommonDO.builder().id(MODEL_ID).fileId(73L).modelType("file").translateStatus("uploadProcessing")
                        .integrationStatus("processing_no").attachmentId(13L).build();
                existingModel.setCreateTime(LocalDateTime.now());
                expectActiveGuard(() -> service.newUploadModel(multipartFile(), 12L, null, null));
                expectActiveGuard(() -> service.delete(12L, null));
                require(!Files.exists(staged) && !uploadInvoked, "active-job guards must precede attachment and vendor actions");
            } finally {
                Files.deleteIfExists(staged);
                Files.deleteIfExists(directory);
            }
        }

        private static MultipartFile multipartFile() {
            return proxy(MultipartFile.class, (target, method, args) -> {
                switch (method.getName()) {
                    case "getOriginalFilename": return "fixture model.ifc";
                    case "getSize": return 3L;
                    case "isEmpty": return false;
                    default: throw new AssertionError("Unexpected multipart operation " + method.getName());
                }
            });
        }

        private static void expectActiveGuard(Runnable operation) {
            try {
                operation.run();
                throw new AssertionError("active upload cannot be replaced or deleted");
            } catch (IllegalArgumentException expected) {
                require(expected.getMessage().contains("模型正在上传或转换"), "active job must block this operation");
            }
        }

        private void checkWorker(boolean condition, String message) {
            if (!condition) workerError.compareAndSet(null, message);
        }
    }

    private static final class Fixture {
        private final BimModelCommonServiceImpl service = new BimModelCommonServiceImpl();
        private final BimModelController controller = new BimModelController();
        private final BimModelCommonDO row = BimModelCommonDO.builder().id(MODEL_ID).fileId(FILE_ID)
                .attachmentId(14L).modelType("file").translateStatus("processing").successQuantity(0L).fileSize(1.25).build();
        private FileTranslateBean vendor;
        private boolean vendorUnavailable;
        private boolean tokenExists = true;
        private boolean winElsewhere;
        private int vendorReads;
        private int writes;
        private int quota;

        Fixture() throws Exception {
            set(service, "baseMapper", proxy(BimModelCommonMapper.class, (target, method, args) -> {
                switch (method.getName()) {
                    case "selectOne":
                    case "selectById":
                        BimModelCommonDO current = BimModelCommonDO.builder().id(row.getId()).fileId(row.getFileId())
                                .attachmentId(row.getAttachmentId()).modelType(row.getModelType()).translateStatus(row.getTranslateStatus())
                                .successQuantity(row.getSuccessQuantity()).fileSize(row.getFileSize())
                                .fileTinyThumbnail(row.getFileTinyThumbnail()).build();
                        current.setCreateTime(row.getCreateTime());
                        return current;
                    case "update":
                        LambdaUpdateWrapper<?> update = (LambdaUpdateWrapper<?>)args[1];
                        String where = update.getSqlSegment();
                        String set = update.getSqlSet();
                        Map<String, Object> parameters = update.getParamNameValuePairs();
                        require(where.contains("id") && where.contains("file_id") && where.contains("translate_status")
                                && parameters.containsValue(MODEL_ID) && parameters.containsValue(FILE_ID)
                                && where.contains("attachment_id") && parameters.containsValue(14L)
                                && parameters.containsValue(row.getTranslateStatus()), "terminal write must match the exact processing job");
                        if (winElsewhere) {
                            row.setTranslateStatus("success");
                            return 0;
                        }
                        if (parameters.containsValue("success")) {
                            row.setTranslateStatus("success");
                        } else if (parameters.containsValue("uploadFailed")) {
                            row.setTranslateStatus("uploadFailed");
                        } else {
                            row.setTranslateStatus("failed");
                        }
                        if (parameters.containsValue("https://example.invalid/tiny")) {
                            row.setFileTinyThumbnail("https://example.invalid/tiny");
                        }
                        require(!"success".equals(row.getTranslateStatus()) || set.contains("success_quantity"), "successful transition must increment model success count");
                        writes++;
                        return 1;
                    default: throw new AssertionError("Unexpected mapper call " + method.getName());
                }
            }));
            set(service, "bimModelConfigurationService", proxy(BimModelConfigurationService.class, (target, method, args) -> null));
            set(service, "restrictConfigService", proxy(BimModelRestrictConfigService.class, (target, method, args) -> {
                if ("list".equals(method.getName())) {
                    require(((LambdaQueryWrapper<?>)args[0]).getSqlSegment().endsWith("FOR UPDATE"), "quota updates must serialize on current rows");
                    return null;
                }
                require("updateValue".equals(method.getName()), "unexpected quota method");
                quota++;
                return null;
            }));
            set(service, "bimfaceClient", new BimfaceClient("probe-app", "probe-secret") {
                @Override public FileTranslateBean getTranslate(Long id) throws BimfaceException {
                    require(id.equals(FILE_ID), "translation query must use the saved file");
                    vendorReads++;
                    if (vendorUnavailable) throw new IllegalStateException("offline fixture");
                    return vendor;
                }
                @Override public String getViewTokenByFileId(Long id) { return "probe-view-token"; }
            });
            RedisUtils redis = new RedisUtils();
            set(redis, "redisTemplate", new RedisTemplate<String, Object>() {
                @Override public ValueOperations<String, Object> opsForValue() {
                    return proxy(ValueOperations.class, (target, method, args) -> {
                        require("get".equals(method.getName()), "unexpected Redis operation");
                        return tokenExists && ("model_translate:" + MODEL_ID + ":" + FILE_ID + ":" + SecureUtil.sha256(TOKEN)).equals(args[0])
                                ? "14" : null;
                    });
                }
            });
            set(service, "redisUtils", redis);
            set(controller, "bimModelCommonService", service);
            try {
                set(service, "bimEnabled", true);
                set(service, "transactionManager", proxy(PlatformTransactionManager.class, (target, method, args) ->
                        "getTransaction".equals(method.getName()) ? new SimpleTransactionStatus() : null));
            } catch (NoSuchFieldException baseline) {
                // The recovered baseline has no explicit BIM-enabled guard.
            }
        }

        void vendorResult(String status, String[] thumbnail) {
            vendor = new FileTranslateBean();
            vendor.setFileId(FILE_ID);
            vendor.setStatus(status);
            vendor.setThumbnail(thumbnail);
            vendor.setReason("failed".equals(status) ? "fixture rejected" : null);
        }

        String signature(long fileId, String status) {
            return SecureUtil.md5("probe-app:probe-secret:" + fileId + ":" + status + ":" + NONCE);
        }

        int callback(String token, long fileId, String status, String signature) throws Exception {
            Method method = BimModelController.class.getMethod("setTranslateStatusCallback",
                    String.class, String.class, String.class, String.class, String.class, String.class);
            return ((ResponseEntity<?>)method.invoke(controller, String.valueOf(MODEL_ID), token,
                    String.valueOf(fileId), status, NONCE, signature)).getStatusCodeValue();
        }
    }

    private static void set(Object instance, String name, Object value) throws Exception {
        for (Class<?> type = instance.getClass(); type != null; type = type.getSuperclass()) {
            try {
                Field field = type.getDeclaredField(name);
                field.setAccessible(true);
                field.set(instance, value);
                return;
            } catch (NoSuchFieldException missing) {
                if (type.getSuperclass() == null) throw missing;
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static <T> T proxy(Class<T> type, InvocationHandler handler) {
        return (T)Proxy.newProxyInstance(type.getClassLoader(), new Class<?>[] {type}, handler);
    }

    private static void require(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }
}
