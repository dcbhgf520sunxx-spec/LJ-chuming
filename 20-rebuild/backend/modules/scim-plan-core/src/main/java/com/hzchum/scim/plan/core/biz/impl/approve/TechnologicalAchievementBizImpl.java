package com.hzchum.scim.plan.core.biz.impl.approve;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.bim.core.api.service.BimModelCommonService;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ApproveRecordStatusEnum;
import com.hzchum.scim.common.core.api.enums.AttachmentTypeEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.Attachment;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.biz.TechArtifactProcessFileBiz;
import com.hzchum.scim.plan.core.api.biz.approve.TechnologicalAchievementBiz;
import com.hzchum.scim.plan.core.api.enums.PlanFileOverlayEnum;
import com.hzchum.scim.plan.core.api.enums.PlanModuleTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.PlanTechnologicalAchievementApproveRecord;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanApproveOpinionDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanTechnologicalAchievementApproveRecordDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.PlanApproveCacheDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.PlanApproveCacheObjectDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechArtifactProcessFileSaveDTOParam;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.PlanTechnologicalAchievementApproveRecordService;
import com.hzchum.scim.plan.core.api.service.TechDrawingService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.service.UserService;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

@Service
public class TechnologicalAchievementBizImpl implements TechnologicalAchievementBiz {
   private static final Logger log = LoggerFactory.getLogger(TechnologicalAchievementBizImpl.class);
   @Resource
   private WmsApproveRecordService recordService;
   @Resource
   private TechDrawingService drawingService;
   @Resource
   private WmsApproveRecordService wmsApproveRecordService;
   @Resource
   private PlanTechnologicalAchievementApproveRecordService approveRecordService;
   @Resource
   private TechArtifactProcessFileBiz artifactProcessFileBiz;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private PlanMonomerService monomerService;
   @Resource
   private UserService userService;
   @Resource
   private RedisUtils redisUtils;
   @Resource
   private ObjectMapper convert;
   @Resource
   private PlanAreaService areaService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private BimModelCommonService commonService;
   @Resource
   private ConfigProperties configProperties;
   private static final String PLAN_KEY = "plan";

   @Transactional(rollbackFor = Exception.class)
   @Override
   public ResultVO commonApprove(PlanApproveOpinionDTOParam opinionDTOParam) throws Exception {
      ResultVO<Object> build = ResultVO.<Object>builder().build();
      log.info("审批之后的方法调用");
      WmsApproveRecord wmsApproveRecord = this.recordService.getById(opinionDTOParam.getApproveRecordId());
      PlanTechnologicalAchievementApproveRecord approveRecord = this.approveRecordService
         .getOne(
            (Wrapper<PlanTechnologicalAchievementApproveRecord>)new LambdaQueryWrapper<PlanTechnologicalAchievementApproveRecord>()
               .eq(PlanTechnologicalAchievementApproveRecord::getApproveRecordId, opinionDTOParam.getApproveRecordId())
         );
      Preconditions.checkArgument(wmsApproveRecord != null && approveRecord != null, "审批记录不存在");
      Preconditions.checkArgument(Objects.equals(approveRecord.getDataId(), opinionDTOParam.getDataId()), "数据不属于该审批记录");
      Boolean result = this.recordService
         .commonApproveStep(opinionDTOParam.getDataId(), opinionDTOParam.getDecision(), opinionDTOParam.getOpinion(), wmsApproveRecord.getSerialNumber(), null);
      Integer approveStatus;
      if (result) {
         approveStatus = opinionDTOParam.getDecision();
      } else {
         approveStatus = ReviewStatusEnum.AUDITING.getType();
         build.setMessage("审批进行中");
      }

      approveRecord.setApproveStatus(approveStatus);
      approveRecord.setOpinion(opinionDTOParam.getOpinion());
      this.approveRecordService.updateById(approveRecord);
      String key;
      if (PlanModuleTypeEnum.TECHNOLOGY.getType().equals(approveRecord.getModuleType())) {
         key = "plan:" + opinionDTOParam.getApproveRecordId() + ":" + PlanModuleTypeEnum.TECHNOLOGY.getType();
         if (result && ReviewStatusEnum.REVIEWED.getType().equals(approveStatus)) {
            build.setMessage("审批流已结束！审批通过");
            build.setData(true);
            if (this.redisUtils.hasKey(key)) {
               String jsontr = (String)this.redisUtils.get(key);
               log.info("获取到的key值" + jsontr);
               TechArtifactProcessFileSaveDTOParam param = this.convert.readValue(jsontr, TechArtifactProcessFileSaveDTOParam.class);
               this.artifactProcessFileBiz.newSaveProcessFile(param);
               log.info("执行工艺文件方法");
               this.redisUtils.del(key);
            }
         }
      } else {
         key = "plan:" + opinionDTOParam.getApproveRecordId() + ":" + opinionDTOParam.getDataId();
         log.info("进入审批后的方法获取key值" + key);
         if (result && ReviewStatusEnum.REVIEWED.getType().equals(approveStatus)) {
            build.setMessage("审批流已结束！审批通过");
            build.setData(true);
            if (this.redisUtils.hasKey(key)) {
               log.info("key值在redis中存在");
               String jsontr = (String)this.redisUtils.get(key);
               PlanApproveCacheDTOParam cache = this.convert.readValue(jsontr, PlanApproveCacheDTOParam.class);
               log.info("反序列化之后获取到的缓存值" + cache.getFileName());
               MultipartFile mockMultipartFile = this.convertFileToMultipartFile(Long.valueOf(approveRecord.getAttachmentIds()));
               PlanApproveCacheObjectDTOParam cacheObjectDTOParam = cache.getCacheObjectDTOParam();
               if (PlanFileOverlayEnum.DRAWING_NUMERICAL_CONTROL_XML.getType().equals(cacheObjectDTOParam.getCover())) {
                  log.info("执行图纸，数控，XML覆盖导入");
                  this.drawingService
                     .newUpdateFile(
                        cacheObjectDTOParam.getProductId(),
                        cache.getProductType(),
                        cache.getDataType(),
                        mockMultipartFile,
                        cache.getProjectld(),
                        cache.getMonomerld(),
                        cache.getAreaId(),
                        cacheObjectDTOParam
                     );
               } else if (PlanFileOverlayEnum.ALTER_CONSTRUCTION_BLUEPRINT.getType().equals(cacheObjectDTOParam.getCover())) {
                  log.info("执行变更，施工蓝图文件替换接口");
                  this.drawingService.newUpdateDrawing(cacheObjectDTOParam.getDataId(), mockMultipartFile, cache.getFileName(), cacheObjectDTOParam);
               } else if (cacheObjectDTOParam.getNormal()) {
                  log.info("执行数控，XML匹配导入");
                  this.drawingService
                     .newUploadZipFileChoose(
                        mockMultipartFile,
                        cache.getProjectld(),
                        cache.getMonomerld(),
                        cache.getAreaId(),
                        cache.getDataType(),
                        cache.getProductType(),
                        cache.getFileName(),
                        cacheObjectDTOParam,
                        null
                     );
               } else if (PlanModuleTypeEnum.MODEL.getType().equals(approveRecord.getModuleType())) {
                  this.commonService.newUploadModel(mockMultipartFile, cache.getMonomerld(), cache.getAreaId(), cacheObjectDTOParam);
               } else {
                  log.info("审批之后的方法调用" + mockMultipartFile.getName());
                  if (cache.getProductType().equals(ProductTypeEnum.ALL_PRODUCT.getType())) {
                     this.drawingService
                        .newAllUploadFileAndUnzip(
                           mockMultipartFile,
                           cache.getProjectld(),
                           cache.getMonomerld(),
                           cache.getDataType(),
                           cache.getProductType(),
                           cache.getFileName(),
                           cacheObjectDTOParam,
                           cache.getAreaId(),
                           null
                        );
                  } else {
                     this.drawingService
                        .newUploadFileAndUnzip(
                           mockMultipartFile,
                           cache.getProjectld(),
                           cache.getMonomerld(),
                           cache.getDataType(),
                           cache.getProductType(),
                           cache.getFileName(),
                           cacheObjectDTOParam,
                           cache.getAreaId(),
                           null
                        );
                  }
               }

               this.redisUtils.del(key);
            }
         }
      }

      if (result && ReviewStatusEnum.RETURNED.getType().equals(approveStatus)) {
         build.setMessage("审批流已结束！审批驳回");
         this.redisUtils.del(key);
      }

      return build;
   }

   @Override
   public Boolean OaCommonApprove(PlanApproveOpinionDTOParam opinionDTOParam) throws Exception {
      String key = "plan:" + opinionDTOParam.getApproveRecordId() + ":" + opinionDTOParam.getDataId();
      Integer approveStatus = opinionDTOParam.getDecision();
      PlanTechnologicalAchievementApproveRecord approveRecord = this.approveRecordService
         .getOne(
            (Wrapper<PlanTechnologicalAchievementApproveRecord>)new LambdaQueryWrapper<PlanTechnologicalAchievementApproveRecord>()
               .eq(PlanTechnologicalAchievementApproveRecord::getApproveRecordId, opinionDTOParam.getApproveRecordId())
         );
      approveRecord.setApproveStatus(approveStatus);
      approveRecord.setOpinion(opinionDTOParam.getOpinion());
      this.approveRecordService.updateById(approveRecord);
      log.info("进入审批后的方法获取key值" + key);
      if (ReviewStatusEnum.REVIEWED.getType().equals(approveStatus) && this.redisUtils.hasKey(key)) {
         log.info("key值在redis中存在");
         String jsontr = (String)this.redisUtils.get(key);
         PlanApproveCacheDTOParam cache = JSON.parseObject(jsontr, PlanApproveCacheDTOParam.class);
         log.info("反序列化之后获取到的缓存值" + cache.getFileName());
         MultipartFile mockMultipartFile = this.convertFileToMultipartFile(Long.valueOf(approveRecord.getAttachmentIds()));
         PlanApproveCacheObjectDTOParam cacheObjectDTOParam = cache.getCacheObjectDTOParam();
         if (PlanFileOverlayEnum.DRAWING_NUMERICAL_CONTROL_XML.getType().equals(cacheObjectDTOParam.getCover())) {
            log.info("执行图纸，数控，XML覆盖导入");
            this.drawingService
               .newUpdateFile(
                  cacheObjectDTOParam.getProductId(),
                  cache.getProductType(),
                  cache.getDataType(),
                  mockMultipartFile,
                  cache.getProjectld(),
                  cache.getMonomerld(),
                  cache.getAreaId(),
                  cacheObjectDTOParam
               );
         } else if (PlanFileOverlayEnum.ALTER_CONSTRUCTION_BLUEPRINT.getType().equals(cacheObjectDTOParam.getCover())) {
            log.info("执行变更，施工蓝图文件替换接口");
         } else if (cacheObjectDTOParam.getNormal()) {
            log.info("执行数控，XML匹配导入");
         } else if (!PlanModuleTypeEnum.MODEL.getType().equals(approveRecord.getModuleType())) {
            log.info("审批之后的方法调用" + mockMultipartFile.getName());
            if (ProductTypeEnum.ALL_PRODUCT.getType().equals(cache.getProductType())) {
               this.drawingService
                  .newAllUploadFileAndUnzip(
                     mockMultipartFile,
                     cache.getProjectld(),
                     cache.getMonomerld(),
                     cache.getDataType(),
                     cache.getProductType(),
                     cache.getFileName(),
                     cacheObjectDTOParam,
                     cache.getAreaId(),
                     null
                  );
            } else {
               this.drawingService
                  .newUploadFileAndUnzip(
                     mockMultipartFile,
                     cache.getProjectld(),
                     cache.getMonomerld(),
                     cache.getDataType(),
                     cache.getProductType(),
                     cache.getFileName(),
                     cacheObjectDTOParam,
                     cache.getAreaId(),
                     null
                  );
            }
         }
      }

      this.redisUtils.del(key);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public ResultVO createDrawingApprove(
      MultipartFile multipartFile,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long dataId,
      Integer dataType,
      Integer productType,
      Long productId,
      String fileName,
      Integer cover,
      Boolean normal,
      HttpServletResponse response
   ) throws Exception {
      Integer approveProcessType = 0;
      Integer fileType = 0;
      switch (dataType) {
         case 1:
            approveProcessType = ApproveProcessTypeEnumV2.PLAN_DRAWING_DOCUMENT_MANAGE.getType();
            fileType = AttachmentTypeEnum.PLAN.getType();
            break;
         case 2:
            approveProcessType = ApproveProcessTypeEnumV2.PLAN_NUMERICAL_CONTROL_DOCUMENT_MANAGE.getType();
            fileType = AttachmentTypeEnum.ZIP.getType();
            break;
         case 4:
            approveProcessType = ApproveProcessTypeEnumV2.PLAN_CHANGE_FILE.getType();
            fileType = AttachmentTypeEnum.TECH_CHANGE.getType();
            break;
         case 8:
            approveProcessType = ApproveProcessTypeEnumV2.PLAN_CONSTRUCTION_BLUEPRINT.getType();
            fileType = AttachmentTypeEnum.DATA_CONSTRUCTION.getType();
            break;
         case 64:
            approveProcessType = ApproveProcessTypeEnumV2.PLAN_MODEL_DOCUMENT_MANAGE.getType();
            fileType = AttachmentTypeEnum.BIMFACE.getType();
      }

      Long id = monomerId != null ? monomerId : projectId;
      List<String> subjoinMsgList = new ArrayList<>();
      ContractProject project = this.projectService.getById(projectId);
      if (monomerId != null) {
         PlanMonomer planMonomer = this.monomerService.getById(monomerId);
         subjoinMsgList.add(project.getShortName() + "/" + planMonomer.getName());
      } else {
         subjoinMsgList.add(project.getShortName());
      }

      String subjoinMsg = JSONArray.toJSONString(subjoinMsgList);
      WmsApproveRecord record = this.wmsApproveRecordService.createRecord(id, null, approveProcessType, null, null, null, false, null, subjoinMsg, null);
      log.info("开始创建审批流");
      ResultVO<Object> build = ResultVO.<Object>builder().build();
      Integer approveStatus = ReviewStatusEnum.AUDITING.getType();
      Attachment attachment = this.attachmentService.uploadFile(multipartFile, fileType);
      PlanTechnologicalAchievementApproveRecord achievementApproveRecord = PlanTechnologicalAchievementApproveRecord.builder()
         .approveRecordId(record.getId())
         .moduleType(dataType)
         .projectId(projectId)
         .dataId(id)
         .deleId(dataId)
         .applicantId(UserUtil.getCurrentUser().getId())
         .attachmentIds(attachment == null ? null : attachment.getId().toString())
         .fileNames(attachment == null ? null : attachment.getName())
         .monomerId(monomerId)
         .productType(productType)
         .build();
      boolean result = ApproveRecordStatusEnum.END.getType().equals(record.getStatus());
      if (result) {
         approveStatus = ReviewStatusEnum.REVIEWED.getType();
         MultipartFile mockMultipartFile = this.convertFileToMultipartFile(attachment.getId());
         log.info("审批流结束：审批状态" + approveStatus);
         if (PlanFileOverlayEnum.DRAWING_NUMERICAL_CONTROL_XML.getType().equals(cover)) {
            this.drawingService.newUpdateFile(productId, productType, dataType, mockMultipartFile, projectId, monomerId, areaId, null);
         } else if (PlanFileOverlayEnum.ALTER_CONSTRUCTION_BLUEPRINT.getType().equals(cover)) {
            this.drawingService.newUpdateDrawing(dataId, mockMultipartFile, fileName, null);
         } else if (normal) {
            this.drawingService.newUploadZipFileChoose(mockMultipartFile, projectId, monomerId, areaId, dataType, productType, fileName, null, null);
         } else if (PlanModuleTypeEnum.MODEL.getType().equals(dataType)) {
            this.commonService.newUploadModel(mockMultipartFile, monomerId, areaId, null);
         } else if (ProductTypeEnum.ALL_PRODUCT.getType().equals(productType)) {
            this.drawingService.newAllUploadFileAndUnzip(mockMultipartFile, projectId, monomerId, dataType, productType, fileName, null, areaId, null);
         } else {
            this.drawingService.newUploadFileAndUnzip(mockMultipartFile, projectId, monomerId, dataType, productType, fileName, null, areaId, null);
         }
      }

      achievementApproveRecord.setApproveStatus(approveStatus);
      this.approveRecordService.save(achievementApproveRecord);
      if (result) {
         return build;
      }

      if (ReviewStatusEnum.AUDITING.getType().equals(approveStatus)) {
         String key = "plan:" + record.getId() + ":" + id;
         PlanApproveCacheDTOParam planApproveCacheDTOParam = PlanApproveCacheDTOParam.builder()
            .fileName(multipartFile.getOriginalFilename())
            .contentType(multipartFile.getContentType())
            .projectld(projectId)
            .monomerld(monomerId)
            .areaId(areaId)
            .dataType(dataType)
            .productType(productType)
            .cacheObjectDTOParam(
               PlanApproveCacheObjectDTOParam.builder()
                  .createUserId(UserUtil.getCurrentUser().getId())
                  .productId(productId)
                  .dataId(dataId)
                  .normal(normal)
                  .cover(cover)
                  .build()
            )
            .build();
         String approveCacheJson = this.convert.writeValueAsString(planApproveCacheDTOParam);
         this.redisUtils.set(key, approveCacheJson);
         log.info("key:" + key + "已添加到redis缓存");
      }

      build.setData(true);
      build.setMessage("审批流已生成！请点击审批记录查看");
      return build;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public ResultVO createAllDrawingApprove(
      MultipartFile multipartFile,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long dataId,
      Integer dataType,
      Integer productType,
      Long productId,
      String fileName,
      Integer cover,
      Boolean normal,
      HttpServletResponse response
   ) throws Exception {
      Integer approveProcessType = ApproveProcessTypeEnumV2.PLAN_DRAWING_DOCUMENT_MANAGE.getType();
      Integer fileType = AttachmentTypeEnum.PLAN.getType();
      Long id = monomerId != null ? monomerId : projectId;
      List<String> subjoinMsgList = new ArrayList<>();
      ContractProject project = this.projectService.getById(projectId);
      if (monomerId != null) {
         PlanMonomer planMonomer = this.monomerService.getById(monomerId);
         subjoinMsgList.add(project.getShortName() + "/" + planMonomer.getName());
      } else {
         subjoinMsgList.add(project.getShortName());
      }

      String subjoinMsg = JSONArray.toJSONString(subjoinMsgList);
      WmsApproveRecord record = this.wmsApproveRecordService.createRecord(id, null, approveProcessType, null, null, null, false, null, subjoinMsg, null);
      log.info("开始创建审批流");
      ResultVO<Object> build = ResultVO.<Object>builder().build();
      Integer approveStatus = ReviewStatusEnum.AUDITING.getType();
      Attachment attachment = this.attachmentService.uploadFile(multipartFile, fileType);
      PlanTechnologicalAchievementApproveRecord achievementApproveRecord = PlanTechnologicalAchievementApproveRecord.builder()
         .approveRecordId(record.getId())
         .moduleType(dataType)
         .projectId(projectId)
         .dataId(id)
         .deleId(dataId)
         .applicantId(UserUtil.getCurrentUser().getId())
         .attachmentIds(attachment == null ? null : attachment.getId().toString())
         .fileNames(attachment == null ? null : attachment.getName())
         .monomerId(monomerId)
         .productType(null)
         .build();
      boolean result = ApproveRecordStatusEnum.END.getType().equals(record.getStatus());
      if (result) {
         approveStatus = ReviewStatusEnum.REVIEWED.getType();
         MultipartFile mockMultipartFile = this.convertFileToMultipartFile(attachment.getId());
         log.info("审批流结束：审批状态" + approveStatus);
         this.drawingService.newAllUploadFileAndUnzip(mockMultipartFile, projectId, monomerId, dataType, productType, fileName, null, areaId, null);
      }

      achievementApproveRecord.setApproveStatus(approveStatus);
      this.approveRecordService.save(achievementApproveRecord);
      if (result) {
         return build;
      }

      if (ReviewStatusEnum.AUDITING.getType().equals(approveStatus)) {
         String key = "plan:" + record.getId() + ":" + id;
         PlanApproveCacheDTOParam planApproveCacheDTOParam = PlanApproveCacheDTOParam.builder()
            .fileName(multipartFile.getOriginalFilename())
            .contentType(multipartFile.getContentType())
            .projectld(projectId)
            .monomerld(monomerId)
            .areaId(areaId)
            .dataType(dataType)
            .productType(null)
            .cacheObjectDTOParam(
               PlanApproveCacheObjectDTOParam.builder()
                  .createUserId(UserUtil.getCurrentUser().getId())
                  .productId(productId)
                  .dataId(dataId)
                  .normal(normal)
                  .cover(cover)
                  .build()
            )
            .build();
         String approveCacheJson = this.convert.writeValueAsString(planApproveCacheDTOParam);
         this.redisUtils.set(key, approveCacheJson);
         log.info("key:" + key + "已添加到redis缓存");
      }

      build.setData(true);
      build.setMessage("审批流已生成！请点击审批记录查看");
      return build;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public ResultVO createTechnologyApprove(TechArtifactProcessFileSaveDTOParam param) throws RuntimeException {
      Map map = new HashMap();
      if (ObjectUtil.isNotEmpty(param.getProjectId())) {
         map.put("project_id", param.getProjectId());
      }

      if (ObjectUtil.isNotEmpty(param.getProcessType())) {
         map.put("product_type", param.getProcessType());
      }

      map.put("module_type", PlanModuleTypeEnum.TECHNOLOGY.getType());
      map.put("approve_status", ReviewStatusEnum.AUDITING.getType());
      List<PlanTechnologicalAchievementApproveRecord> approveRecord = this.approveRecordService.getBaseMapper().selectByMap(map);
      Preconditions.checkArgument(CollectionUtils.isEmpty(approveRecord), "已存在审批数据，请查看审批记录");
      Long dataId = param.getProjectId() != null ? param.getProjectId() : param.getFileList().get(0).getAttachmentId();
      WmsApproveRecord record = this.wmsApproveRecordService
         .createRecord(dataId, null, ApproveProcessTypeEnumV2.PLAN_PROCESS_DOCUMENT.getType(), null, null, null, false, null, null, null);
      ResultVO<Object> build = ResultVO.<Object>builder().build();
      Integer approveStatus = ReviewStatusEnum.AUDITING.getType();
      String attachmentId = param.getFileList()
         .stream()
         .map(item -> item.getAttachmentId())
         .collect(Collectors.toList())
         .stream()
         .map(Object::toString)
         .collect(Collectors.joining(","));
      String fileName = param.getFileList().stream().map(item -> item.getFileName()).collect(Collectors.toList()).stream().collect(Collectors.joining(","));
      String remarks = param.getFileList()
         .stream()
         .filter(item -> ObjectUtil.isNotEmpty(item.getRemark()))
         .map(item -> item.getRemark())
         .collect(Collectors.toList())
         .stream()
         .collect(Collectors.joining(","));
      PlanTechnologicalAchievementApproveRecord achievementApproveRecord = PlanTechnologicalAchievementApproveRecord.builder()
         .approveRecordId(record.getId())
         .moduleType(PlanModuleTypeEnum.TECHNOLOGY.getType())
         .projectId(param.getProjectId())
         .dataId(dataId)
         .attachmentIds(attachmentId)
         .fileNames(fileName)
         .applicantId(UserUtil.getCurrentUser().getId())
         .productType(param.getProcessType())
         .remark(remarks)
         .build();
      boolean result = ApproveRecordStatusEnum.END.getType().equals(record.getStatus());
      if (result) {
         approveStatus = ReviewStatusEnum.REVIEWED.getType();
         this.artifactProcessFileBiz.newSaveProcessFile(param);
      }

      achievementApproveRecord.setApproveStatus(approveStatus);
      this.approveRecordService.save(achievementApproveRecord);
      if (result) {
         return build;
      }

      if (ReviewStatusEnum.AUDITING.getType().equals(approveStatus)) {
         String key = "plan:" + record.getId() + ":" + PlanModuleTypeEnum.TECHNOLOGY.getType();

         try {
            this.redisUtils.set(key, this.convert.writeValueAsString(param));
         } catch (Exception e) {
            e.printStackTrace();
         }
      }

      build.setData(true);
      build.setMessage("审批流已生成！请点击审批记录查看");
      return build;
   }

   @Override
   public void downloadFile(Long id, Long approvalRecordId) {
      PlanTechnologicalAchievementApproveRecord approveRecord = this.approveRecordService
         .getOne(
            (Wrapper<PlanTechnologicalAchievementApproveRecord>)new LambdaQueryWrapper<PlanTechnologicalAchievementApproveRecord>()
               .eq(PlanTechnologicalAchievementApproveRecord::getApproveRecordId, approvalRecordId)
         );
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(approveRecord), "暂没有生成审批记录");
      Preconditions.checkArgument(id != null && approveRecord.getAttachmentIds() != null
            && Arrays.stream(approveRecord.getAttachmentIds().split(",")).map(String::trim).anyMatch(String.valueOf(id)::equals),
         "附件不属于该审批记录");
      if (PlanModuleTypeEnum.TECHNOLOGY.getType().equals(approveRecord.getModuleType())) {
         Preconditions.checkArgument(id != null, "工艺文件附件id不能为空！");
         this.attachmentService.downloadFile(id, null);
      } else {
         this.attachmentService.downloadFile(id, null);
      }
   }

   public static void downloadFile(byte[] fileData, String fileName) {
      ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
      if (servletRequestAttributes == null) {
         throw new BusinessException(ResultCodeEnum.ERROR, "无法获取当前请求上下文");
      }

      HttpServletResponse response = servletRequestAttributes.getResponse();
      if (response == null) {
         throw new BusinessException(ResultCodeEnum.ERROR, "无法获取响应对象");
      }

      response.setContentType("application/octet-stream;charset=UTF-8");
      response.setContentLengthLong(fileData.length);
      if (fileName.contains("_")) {
         String timeStamp = fileName.split("_")[0];
         fileName = fileName.replaceFirst(timeStamp + "_", "");
      }

      try {
         response.setCharacterEncoding("UTF-8");
         response.setHeader("content-Type", "application/vnd.ms-excel");
         response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
         response.setHeader("Access-Control-Expose-Headers", "*");
      } catch (UnsupportedEncodingException e) {
         throw new BusinessException(e.getMessage());
      }

      response.setHeader("Access-Control-Expose-Headers", "*");

      try (OutputStream outputStream = response.getOutputStream()) {
         outputStream.write(fileData);
         outputStream.flush();
      } catch (IOException e) {
         throw new BusinessException(ResultCodeEnum.ERROR, "文件下载失败");
      }
   }

   @Override
   public ResultVO<Object> getApproveDetail(long approvalRecordId) {
      PlanTechnologicalAchievementApproveRecord approveRecord = this.approveRecordService
         .getOne(
            (Wrapper<PlanTechnologicalAchievementApproveRecord>)new LambdaQueryWrapper<PlanTechnologicalAchievementApproveRecord>()
               .eq(PlanTechnologicalAchievementApproveRecord::getApproveRecordId, approvalRecordId)
         );
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(approveRecord), "暂没有生成审批记录");
      PlanTechnologicalAchievementApproveRecordDTO approveRecordDTO = BeanUtil.copy(approveRecord, PlanTechnologicalAchievementApproveRecordDTO.class);
      if (this.projectService.getById(approveRecord.getProjectId()) != null) {
         approveRecordDTO.setProjectName(this.projectService.getById(approveRecord.getProjectId()).getName());
      }

      if (this.monomerService.getById(approveRecord.getMonomerId()) != null) {
         approveRecordDTO.setMonomerName(this.monomerService.getById(approveRecord.getMonomerId()).getName());
      }

      if (this.userService.getById(approveRecord.getApplicantId()) != null) {
         approveRecordDTO.setApplicantName(this.userService.getById(approveRecord.getApplicantId()).getName());
      }

      if (this.areaService.getById(approveRecord.getAreaId()) != null) {
         approveRecordDTO.setAreaName(this.areaService.getById(approveRecord.getAreaId()).getName());
      }

      if (PlanModuleTypeEnum.TECHNOLOGY.getType().equals(approveRecord.getModuleType())) {
         if (approveRecord.getAttachmentIds() != null) {
            List<AttachmentDTO> attachmentDTOS = this.attachmentService.listByIds(approveRecord.getAttachmentIds());
            approveRecordDTO.setAttachments(attachmentDTOS);
         }
      } else if (approveRecord.getAttachmentIds() != null) {
         List<AttachmentDTO> attachmentDTOS = this.attachmentService.listByIds(approveRecord.getAttachmentIds());
         approveRecordDTO.setAttachments(attachmentDTOS);
      }

      return ResultVO.<Object>builder().data(approveRecordDTO).build();
   }

   @Override
   public Boolean cancelApproveDetail(long approvalRecordId) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      PlanTechnologicalAchievementApproveRecord approveRecord = this.approveRecordService
         .getOne(
            (Wrapper<PlanTechnologicalAchievementApproveRecord>)new LambdaQueryWrapper<PlanTechnologicalAchievementApproveRecord>()
               .eq(PlanTechnologicalAchievementApproveRecord::getApproveRecordId, approvalRecordId)
         );
      Preconditions.checkArgument(currentUser.getId().equals(approveRecord.getApplicantId()), "仅创建人才可进行撤销操作");
      Preconditions.checkArgument(ReviewStatusEnum.AUDITING.getType().equals(approveRecord.getApproveStatus()), "只可在创建中才可撤销申请，撤销失败");
      approveRecord.setApproveStatus(ReviewStatusEnum.CANCEL.getType());
      if (ObjectUtil.isNotEmpty(approveRecord.getApproveRecordId())) {
         this.wmsApproveRecordService.revocation(approveRecord.getApproveRecordId());
      }

      this.approveRecordService.updateById(approveRecord);
      return true;
   }

   private static MockMultipartFile convertToMultipartFile(String fileName, String contentType, byte[] bytes) throws IOException {
      InputStream inputStream = new ByteArrayInputStream(bytes);
      return new MockMultipartFile(fileName, fileName, contentType, inputStream);
   }

   private MultipartFile convertFileToMultipartFile(Long attachmentId) throws IOException {
      AttachmentDTO attachment = this.attachmentService.getById(attachmentId);
      Preconditions.checkArgument(attachment != null, "附件不存在");
      String path = this.configProperties.getFilePath() + attachment.getRelativePath();
      File file = new File(path);
      InputStream fileInputStream = new FileInputStream(file);
      String contentType;
      if (file.getName().toLowerCase().endsWith(".pdf")) {
         contentType = "application/pdf";
      } else if (file.getName().toLowerCase().endsWith(".docx") || file.getName().toLowerCase().endsWith(".doc")) {
         contentType = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
      } else if (file.getName().toLowerCase().endsWith(".jpeg")) {
         contentType = ContentType.IMAGE_JPEG.getMimeType();
      } else if (file.getName().toLowerCase().endsWith(".png")) {
         contentType = ContentType.IMAGE_PNG.getMimeType();
      } else {
         contentType = ContentType.APPLICATION_OCTET_STREAM.getMimeType();
      }

      return new MockMultipartFile(attachment.getName(), attachment.getName(), contentType, fileInputStream);
   }
}
