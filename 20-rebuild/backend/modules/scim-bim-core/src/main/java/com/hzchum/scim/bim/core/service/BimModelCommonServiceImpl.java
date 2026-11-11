package com.hzchum.scim.bim.core.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bimface.api.bean.request.integrate.FileIntegrateRequest;
import com.bimface.api.bean.request.integrate.IntegrateSource;
import com.bimface.api.bean.request.translate.FileTranslateRequest;
import com.bimface.api.bean.request.translate.TranslateSource;
import com.bimface.api.bean.response.FileIntegrateBean;
import com.bimface.api.bean.response.FileTranslateBean;
import com.bimface.bdfs.bean.dto.FileItemDTO;
import com.bimface.data.bean.SearchElementIdsResp;
import com.bimface.exception.BimfaceException;
import com.bimface.sdk.BimfaceClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.AESUtils;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.bim.core.api.constants.BimRedisConstants;
import com.hzchum.scim.bim.core.api.enums.BimImportModeEnum;
import com.hzchum.scim.bim.core.api.enums.BimModelTypeEnum;
import com.hzchum.scim.bim.core.api.enums.BimStatusCommonEnum;
import com.hzchum.scim.bim.core.api.enums.BimStatusIntegrationEnum;
import com.hzchum.scim.bim.core.api.pojo._do.BimModelCommonDO;
import com.hzchum.scim.bim.core.api.pojo._do.BimModelConfigurationDO;
import com.hzchum.scim.bim.core.api.pojo.vo.BimEngineStatusResponseVO;
import com.hzchum.scim.bim.core.api.pojo.vo.BimModelCommonResponseVO;
import com.hzchum.scim.bim.core.api.service.BimModelCommonService;
import com.hzchum.scim.bim.core.api.service.BimModelConfigurationService;
import com.hzchum.scim.bim.core.biz.impl.BimMonomerElementService;
import com.hzchum.scim.bim.core.mapper.BimModelCommonMapper;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.enums.AttachmentTypeEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.Attachment;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.contract.core.api.enums.ProjectContentCategoryEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectStatusEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.biz.approve.TechnologicalAchievementBiz;
import com.hzchum.scim.plan.core.api.enums.PlanModuleTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.PlanTechnologicalAchievementApproveRecord;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.PlanApproveCacheObjectDTOParam;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.PlanTechnologicalAchievementApproveRecordService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.system.core.api.common.enums.BimModelRestrictedTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.Config;
import com.hzchum.scim.system.core.api.pojo._do.SysBusinessDataStatistics;
import com.hzchum.scim.system.core.api.pojo.dto.BimModelConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.BimModelRestrictConfigDTO;
import com.hzchum.scim.system.core.api.service.BimModelRestrictConfigService;
import com.hzchum.scim.system.core.api.service.ConfigService;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BimModelCommonServiceImpl extends ServiceImpl<BimModelCommonMapper, BimModelCommonDO> implements BimModelCommonService {
   private static final Logger log = LoggerFactory.getLogger(BimModelCommonServiceImpl.class);
   @Resource
   private RedisUtils redisUtils;
   @Resource
   private PlanMonomerService planMonomerService;
   @Resource
   private ContractProjectService contractProjectService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private ConfigProperties configProperties;
   @Resource
   private BimfaceClient bimfaceClient;
   @Resource
   private BimMonomerElementService bimMonomerElementService;
   @Resource
   private PlanAreaService planAreaService;
   @Resource
   private TechnologicalAchievementBiz achievementBiz;
   @Resource
   private BimModelConfigurationService bimModelConfigurationService;
   @Resource
   private PlanTechnologicalAchievementApproveRecordService approveRecordService;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private TechAssembleService assembleService;
   @Resource
   private BimModelRestrictConfigService restrictConfigService;
   @Resource
   private ConfigService configService;
   @Resource
   private PlatformTransactionManager transactionManager;
   @Value("${engine.projectId:}")
   private String projectId;
   @Value("${engine.translateCallbackBaseUrl:}")
   private String translateCallbackBaseUrl;
   @Value("${ljaps.integrations.bim.enabled:false}")
   private boolean bimEnabled;
   // Allow large uploads two hours. A conversion has the same 24-hour window as its callback lease.
   private static final long UPLOAD_PENDING_SECONDS = 2 * 60 * 60L;
   private static final long TRANSLATE_CALLBACK_TTL_SECONDS = 24 * 60 * 60L;
   private static final String TRANSLATE_STATUS_CALLBACK = "api/model/3DModel/translate/status/callback";
   private static final String INTEGRATION_STATUS_CALLBACK = "api/model/3DModel/integrate/status/callback";

   @Override
   public BimModelCommonResponseVO getModelByMonomer(Long monomerId) {
      PlanMonomer monomer = this.planMonomerService.getById(monomerId);
      Preconditions.checkArgument(monomer != null, "单体不存在");
      BimModelConfigurationDO configurationDO = this.bimModelConfigurationService
         .getOne((Wrapper<BimModelConfigurationDO>)new LambdaQueryWrapper<BimModelConfigurationDO>().eq(BimModelConfigurationDO::getMonomerId, monomerId));
      Preconditions.checkArgument(configurationDO != null, "模型配置未设置!!!");
      BimModelCommonResponseVO bimByMonomer = this.baseMapper.getBimByMonomer(monomer.getProjectId(), monomerId, configurationDO.getImportMode());
      this.refreshConversionStatus(bimByMonomer);

      Integer successQuantity = this.baseMapper.selectSuccessQuantity(configurationDO.getImportMode(), monomerId, null);
      if (BeanUtil.checkObjAllFieldsIsNull(bimByMonomer)) {
         bimByMonomer = BimModelCommonResponseVO.builder().SuccessQuantity(successQuantity).build();
      } else {
         bimByMonomer.setSuccessQuantity(successQuantity);
      }

      return bimByMonomer;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public ListVO getModelByArea(Long monomerId) {
      PlanMonomer monomer = this.planMonomerService.getById(monomerId);
      Preconditions.checkArgument(monomer != null, "单体不存在");
      List<PlanArea> areaList = this.planAreaService
         .list(
            (Wrapper<PlanArea>)(new LambdaQueryWrapper<PlanArea>().eq(PlanArea::getMonomerId, monomerId))
               .eq(PlanArea::getProductCategory, ProjectContentCategoryEnum.STRUCTURE.getType())
         );
      if (CollectionUtils.isEmpty(areaList)) {
         return new ListVO();
      }

      BimModelConfigurationDO configurationDO = this.bimModelConfigurationService
         .getOne((Wrapper<BimModelConfigurationDO>)new LambdaQueryWrapper<BimModelConfigurationDO>().eq(BimModelConfigurationDO::getMonomerId, monomerId));
      Preconditions.checkArgument(configurationDO != null, "模型配置未设置!!!");
      List<Long> areaIdList = areaList.stream().map(PlanArea::getId).collect(Collectors.toList());
      List<BimModelCommonResponseVO> bimByArea = this.baseMapper
         .getBimByArea(monomer.getProjectId(), monomer.getId(), areaIdList, configurationDO.getImportMode());

      for (BimModelCommonResponseVO model : bimByArea) {
         this.refreshConversionStatus(model);

         model.setSuccessQuantity(this.baseMapper.selectSuccessQuantity(configurationDO.getImportMode(), monomerId, model.getArea().getId()));
      }

      BimModelCommonDO bimModelCommonDO = this.baseMapper
         .selectOne(
            (Wrapper<BimModelCommonDO>)((new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getMonomerId, monomer.getId()))
                  .eq(BimModelCommonDO::getModelType, BimModelTypeEnum.INTEGRATIONTYPE.getName()))
               .ne(BimModelCommonDO::getIntegrationStatus, BimStatusIntegrationEnum.SUCCESS)
         );
      if (this.bimEnabled && bimModelCommonDO != null) {
         FileIntegrateBean integrate = null;

         try {
            integrate = this.bimfaceClient.getIntegrate(bimModelCommonDO.getFileId());
         } catch (Exception e) {
            log.error(e.getMessage(), e);
         }

         Preconditions.checkArgument(integrate != null, "集成模型集成状态获取失败!");
         if (integrate.getStatus().equals(BimStatusCommonEnum.SUCCESS.getName())) {
            bimModelCommonDO.setIntegrationStatus(BimStatusIntegrationEnum.SUCCESS.getName());

            for (BimModelCommonResponseVO bimModelCommonResponseVO : bimByArea) {
               if (bimModelCommonResponseVO.getFileId() != null
                  && bimModelCommonResponseVO.getModelType().equals(BimModelTypeEnum.FILETYPE.getName())
                  && bimModelCommonResponseVO.getIntegrationStatus().equals(BimStatusIntegrationEnum.PROCESSING.getName())) {
                  bimModelCommonResponseVO.setIntegrationStatus(BimStatusIntegrationEnum.SUCCESS.getName());
                  BimModelCommonDO modelCommonDO = this.baseMapper.selectById(bimModelCommonResponseVO.getId());
                  modelCommonDO.setIntegrationStatus(BimStatusIntegrationEnum.SUCCESS.getName());
                  this.baseMapper.updateById(modelCommonDO);
               }
            }

            this.baseMapper.updateById(bimModelCommonDO);
         }
      }

      return new ListVO<>(bimByArea);
   }

   @Override
   public boolean setTranslateStatusCallback(Long modelId, String token, Long fileId, String status, String nonce, String signature) {
      if (!this.bimEnabled || modelId == null || modelId <= 0 || fileId == null || fileId <= 0
         || !isTerminalTranslation(status) || StringUtils.isAnyBlank(token, nonce, signature)) {
         return false;
      }

      Object expectedAttachment = this.redisUtils.get(translateCallbackKey(modelId, fileId, token));
      if (!(expectedAttachment instanceof String)) {
         return false;
      }

      try {
         if (!this.bimfaceClient.validateSignature(signature, fileId.toString(), status, nonce)) {
            return false;
         }
      } catch (BimfaceException e) {
         return false;
      }

      BimModelCommonDO model = this.baseMapper.selectById(modelId);
      if (model == null || !fileId.equals(model.getFileId()) || !expectedAttachment.equals(String.valueOf(model.getAttachmentId()))
         || !BimModelTypeEnum.FILETYPE.getName().equals(model.getModelType())) {
         return false;
      }

      if (BimStatusCommonEnum.PROCESSING.getName().equals(model.getTranslateStatus())) {
         model = this.completeTranslation(model, this.queryTranslation(fileId));
      }
      if (model == null || !fileId.equals(model.getFileId()) || !expectedAttachment.equals(String.valueOf(model.getAttachmentId()))) {
         return false;
      }
      if (!isTerminalTranslation(model.getTranslateStatus())) {
         throw new IllegalStateException("BIMFACE转换结果暂不可用");
      }
      return true;
   }

   private static String translateCallbackKey(Long modelId, Long fileId, String token) {
      return BimRedisConstants.MODEL_TRANSLATE + modelId + ":" + fileId + ":" + SecureUtil.sha256(token);
   }

   private static boolean isTerminalTranslation(String status) {
      return BimStatusCommonEnum.SUCCESS.getName().equals(status) || BimStatusCommonEnum.FAILED.getName().equals(status);
   }

   private FileTranslateBean queryTranslation(Long fileId) {
      try {
         FileTranslateBean translation = this.bimfaceClient.getTranslate(fileId);
         return translation != null && fileId.equals(translation.getFileId()) ? translation : null;
      } catch (BimfaceException | RuntimeException e) {
         log.warn("BIMFACE转换状态查询失败，文件ID {}，异常类型 {}", fileId, e.getClass().getSimpleName());
         return null;
      }
   }

   private void refreshConversionStatus(BimModelCommonResponseVO response) {
      if (!this.bimEnabled || response == null || !BimModelTypeEnum.FILETYPE.getName().equals(response.getModelType())
         || !isPending(response.getTranslateStatus())) {
         return;
      }
      BimModelCommonDO model = this.baseMapper.selectById(response.getId());
      if (model == null) {
         return;
      }
      FileTranslateBean translation = model.getFileId() != null && BimStatusCommonEnum.PROCESSING.getName().equals(model.getTranslateStatus())
         ? this.queryTranslation(model.getFileId()) : null;
      model = this.completeTranslation(model, translation);
      if (model != null) {
         response.setFileId(model.getFileId());
         response.setFileName(model.getFileName());
         response.setTranslateStatus(model.getTranslateStatus());
         response.setFileTinyThumbnail(model.getFileTinyThumbnail());
         response.setFileThumbnail(model.getFileThumbnail());
      }
   }

   private BimModelCommonDO completeTranslation(BimModelCommonDO model, FileTranslateBean translation) {
      if (translation == null || !isTerminalTranslation(translation.getStatus())) {
         if (!hasPendingExpired(model)) {
            return model;
         }
         boolean upload = BimStatusCommonEnum.UPLOAD_PROCESSING.getName().equals(model.getTranslateStatus());
         return this.persistConversionStatus(model, this.pendingJob(model, model.getFileId(), model.getTranslateStatus())
            .eq(BimModelCommonDO::getCreateTime, model.getCreateTime())
            .set(BimModelCommonDO::getTranslateStatus, upload ? BimStatusCommonEnum.UPLOAD_FAILED.getName() : BimStatusCommonEnum.FAILED.getName())
            .set(BimModelCommonDO::getReason, upload ? "模型上传超时，请重新上传" : "模型转换超时，请重新上传"), false);
      }

      String status = translation.getStatus();
      boolean success = BimStatusCommonEnum.SUCCESS.getName().equals(status);
      String[] thumbnails = translation.getThumbnail();
      String tiny = success && thumbnails != null && thumbnails.length >= 1 ? thumbnails[0] : null;
      String thumbnail = success && thumbnails != null && thumbnails.length >= 2 ? thumbnails[1] : null;
      String reason = success ? null : StringUtils.left(translation.getReason(), 255);
      LambdaUpdateWrapper<BimModelCommonDO> update = this.pendingJob(model, model.getFileId(), BimStatusCommonEnum.PROCESSING.getName())
         .set(BimModelCommonDO::getTranslateStatus, status)
         .set(BimModelCommonDO::getReason, reason)
         .set(BimModelCommonDO::getFileTinyThumbnail, StringUtils.left(tiny, 255))
         .set(BimModelCommonDO::getFileThumbnail, StringUtils.left(thumbnail, 255));
      if (success) {
         update.setSql("success_quantity = COALESCE(success_quantity, 0) + 1");
      }

      return this.persistConversionStatus(model, update, success);
   }

   private BimModelCommonDO persistConversionStatus(BimModelCommonDO model, LambdaUpdateWrapper<BimModelCommonDO> update, boolean success) {
      TransactionTemplate completion = new TransactionTemplate(this.transactionManager);
      completion.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
      completion.setIsolationLevel(TransactionDefinition.ISOLATION_REPEATABLE_READ);
      return completion.execute(transaction -> {
         if (this.baseMapper.update(null, update) == 1 && success) {
            this.updateModelDataStatistics(model.getFileSize());
         }
         return this.baseMapper.selectById(model.getId());
      });
   }

   @Override
   public BimEngineStatusResponseVO getTranslate(Long monomerId, Long areaId) {
      BimModelConfigurationDO configurationDO = this.bimModelConfigurationService
         .getOne((Wrapper<BimModelConfigurationDO>)new LambdaQueryWrapper<BimModelConfigurationDO>().eq(BimModelConfigurationDO::getMonomerId, monomerId));
      BimModelCommonDO bimModelCommonDO;
      if (configurationDO != null && BimImportModeEnum.INTEGRATION_MODE.getType().equals(configurationDO.getImportMode()) && areaId != null) {
         bimModelCommonDO = this.baseMapper
            .selectOne(
               (Wrapper<BimModelCommonDO>)(new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getMonomerId, monomerId))
                  .eq(BimModelCommonDO::getAreaId, areaId)
            );
      } else {
         bimModelCommonDO = this.baseMapper
            .selectOne(
               (Wrapper<BimModelCommonDO>)(new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getMonomerId, monomerId))
                  .isNull(BimModelCommonDO::getAreaId)
            );
      }

      if (bimModelCommonDO != null) {
         BimEngineStatusResponseVO copy;
         if (BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
            Long fileId = bimModelCommonDO.getFileId();
            String status = bimModelCommonDO.getTranslateStatus();
            FileTranslateBean translation = null;
            if (this.bimEnabled && fileId != null && (BimStatusCommonEnum.PROCESSING.getName().equals(status)
               || BimStatusCommonEnum.SUCCESS.getName().equals(status))) {
               translation = this.queryTranslation(fileId);
            }
            if (this.bimEnabled && isPending(status)) {
               bimModelCommonDO = this.completeTranslation(bimModelCommonDO, translation);
               if (bimModelCommonDO == null) {
                  return BimEngineStatusResponseVO.builder().status(BimStatusCommonEnum.UNEXIST.getName()).build();
               }
               status = bimModelCommonDO.getTranslateStatus();
            }

            if (BimStatusCommonEnum.SUCCESS.getName().equals(status) && translation != null
               && BimStatusCommonEnum.SUCCESS.getName().equals(translation.getStatus()) && fileId.equals(bimModelCommonDO.getFileId())) {
               copy = BeanUtil.copy(translation, BimEngineStatusResponseVO.class);
            } else {
               copy = BimEngineStatusResponseVO.builder().fileId(bimModelCommonDO.getFileId()).name(bimModelCommonDO.getFileName())
                  .status(status).reason(bimModelCommonDO.getReason()).build();
            }
            copy.setModelType(BimModelTypeEnum.FILETYPE.getName());
            if (this.bimEnabled && BimStatusCommonEnum.SUCCESS.getName().equals(status) && bimModelCommonDO.getFileId() != null) {
               copy.setViewToken(this.getViewToken(bimModelCommonDO.getFileId(), bimModelCommonDO.getModelType()));
            }
         } else {
            if (!this.bimEnabled || !BimStatusIntegrationEnum.SUCCESS.getName().equals(bimModelCommonDO.getIntegrationStatus())) {
               return BimEngineStatusResponseVO.builder()
                  .integrationStatus(bimModelCommonDO.getIntegrationStatus())
                  .modelType(BimModelTypeEnum.INTEGRATIONTYPE.getName())
                  .build();
            }

            FileIntegrateBean integrate = null;

            try {
               integrate = this.bimfaceClient.getIntegrate(bimModelCommonDO.getFileId());
            } catch (Exception e) {
               log.error(e.getMessage(), e);
            }

            Preconditions.checkArgument(integrate != null, "文件转换状态获取失败!");
            copy = BeanUtil.copy(bimModelCommonDO, BimEngineStatusResponseVO.class);
            if (BimStatusIntegrationEnum.SUCCESS.getName().equals(integrate.getStatus())) {
               copy.setViewToken(this.getViewToken(copy.getFileId(), bimModelCommonDO.getModelType()));
               copy.setIntegrationStatus(BimStatusIntegrationEnum.SUCCESS.getName());
            }
         }

         return copy;
      } else {
         BimEngineStatusResponseVO build = new BimEngineStatusResponseVO();
         if (configurationDO == null || BimImportModeEnum.MONOMER_MODE.getType().equals(configurationDO.getImportMode())) {
            build.setStatus(BimStatusCommonEnum.UNEXIST.getName());
            build.setModelType(BimModelTypeEnum.FILETYPE.getName());
         }

         if (configurationDO != null && BimImportModeEnum.INTEGRATION_MODE.getType().equals(configurationDO.getImportMode())) {
            if (areaId == null) {
               build.setModelType(BimModelTypeEnum.INTEGRATIONTYPE.getName());
               build.setIntegrationStatus(BimStatusIntegrationEnum.PROCESSING_NO.getName());
               List<BimModelCommonDO> bimModelCommonDOS = this.baseMapper
                  .selectList(
                     (Wrapper<BimModelCommonDO>)((new LambdaQueryWrapper<BimModelCommonDO>()
                              .eq(BimModelCommonDO::getMonomerId, monomerId))
                           .eq(BimModelCommonDO::getModelType, BimModelTypeEnum.FILETYPE.getName()))
                        .eq(BimModelCommonDO::getTranslateStatus, BimStatusCommonEnum.SUCCESS.getName())
                  );
               if (this.bimEnabled && CollectionUtils.isNotEmpty(bimModelCommonDOS) && bimModelCommonDOS.size() == 1) {
                  BimModelCommonDO areaBimModelCommonDO = bimModelCommonDOS.get(0);
                  build.setFileId(areaBimModelCommonDO.getFileId());
                  build.setIntegrationStatus(BimStatusIntegrationEnum.SUCCESS.getName());
                  build.setViewToken(this.getViewToken(build.getFileId(), BimModelTypeEnum.FILETYPE.getName()));
               }
            }

            if (areaId != null) {
               build.setModelType(BimModelTypeEnum.FILETYPE.getName());
               build.setStatus(BimStatusCommonEnum.UNEXIST.getName());
            }
         }

         return build;
      }
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean delete(Long monomerId, Long areaId) {
      PlanTechnologicalAchievementApproveRecord record = this.approveRecordService
         .getOne(
            (Wrapper<PlanTechnologicalAchievementApproveRecord>)((new LambdaQueryWrapper<PlanTechnologicalAchievementApproveRecord>()
                     .eq(PlanTechnologicalAchievementApproveRecord::getDeleId, monomerId))
                  .eq(PlanTechnologicalAchievementApproveRecord::getModuleType, PlanModuleTypeEnum.MODEL.getType()))
               .eq(PlanTechnologicalAchievementApproveRecord::getApproveStatus, ReviewStatusEnum.AUDITING.getType())
         );
      Preconditions.checkArgument(ObjectUtils.isEmpty(record), "数据在审批中，不可以删除！");
      PlanMonomer monomer = this.lockMonomer(monomerId);
      Preconditions.checkArgument(monomer != null, "单体不存在");
      ContractProject project = this.contractProjectService.getById(monomer.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在");
      Preconditions.checkArgument(!ProjectStatusEnum.COMPLETED.getType().equals(project.getStatus()), "删除模型失败，项目已完成");
      Preconditions.checkArgument(!ProjectStatusEnum.PAUSE.getType().equals(project.getStatus()), "删除模型失败，项目已暂停");
      BimModelConfigurationDO configurationDO = this.bimModelConfigurationService
         .getOne((Wrapper<BimModelConfigurationDO>)new LambdaQueryWrapper<BimModelConfigurationDO>().eq(BimModelConfigurationDO::getMonomerId, monomerId));
      if (configurationDO == null) {
         return Boolean.TRUE;
      }

      BimModelCommonDO bimModelCommonDO;
      String cacheKey;
      if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(configurationDO.getImportMode())) {
         Preconditions.checkArgument(areaId != null, "集成模式只能删除区域模型!!!");
         bimModelCommonDO = this.baseMapper
            .selectOne(
               (Wrapper<BimModelCommonDO>)(new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getMonomerId, monomerId))
                  .eq(BimModelCommonDO::getAreaId, areaId).last("FOR UPDATE")
            );
         cacheKey = "AREA_MODEL:" + areaId;
      } else {
         bimModelCommonDO = this.baseMapper
            .selectOne(
               (Wrapper<BimModelCommonDO>)(new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getMonomerId, monomerId))
                  .isNull(BimModelCommonDO::getAreaId).last("FOR UPDATE")
            );
         cacheKey = "MONOMER_MODEL:" + monomerId;
      }

      if (bimModelCommonDO == null) {
         return Boolean.TRUE;
      }

      Preconditions.checkArgument(!isActivePending(bimModelCommonDO), "模型正在上传或转换，请稍后再删除");
      Preconditions.checkArgument(!BimStatusIntegrationEnum.PROCESSING.getName().equals(bimModelCommonDO.getIntegrationStatus()), "删除失败，模型集成中");
      Preconditions.checkArgument(!BimStatusIntegrationEnum.SUCCESS.getName().equals(bimModelCommonDO.getIntegrationStatus()), "删除失败，模型已集成");
      this.baseMapper.deleteById(bimModelCommonDO);
      this.redisUtils.expire(cacheKey, 1L);
      if (bimModelCommonDO.getFileId() != null) {
         try {
            this.bimfaceClient.deleteFile(bimModelCommonDO.getFileId());
         } catch (BimfaceException e) {
            e.printStackTrace();
         }
      }

      return Boolean.TRUE;
   }

   @Override
   public List<String> getElementIds(String serialNumber, Long fileId) {
      List<String> elementIds = null;
      BimModelCommonDO bimModelCommonDO = this.baseMapper
         .selectOne((Wrapper<BimModelCommonDO>)new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getFileId, fileId));
      Preconditions.checkArgument(bimModelCommonDO != null, "bim模型不存在");
      if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())
         && BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
         BimModelConfigurationDO configuration = this.bimModelConfigurationService.getOne(
            new LambdaQueryWrapper<BimModelConfigurationDO>().eq(BimModelConfigurationDO::getMonomerId, bimModelCommonDO.getMonomerId()));
         Preconditions.checkArgument(configuration != null, "模型配置未设置");
         return this.bimMonomerElementService.getElementIds(bimModelCommonDO, configuration.getEdition(), serialNumber);
      }
      if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())
         || BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
         elementIds = Convert.toList(String.class, this.redisUtils.hget("MONOMER_MODEL:" + bimModelCommonDO.getMonomerId(), serialNumber));
      }

      if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())
         && BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
         elementIds = Convert.toList(String.class, this.redisUtils.hget("AREA_MODEL:" + bimModelCommonDO.getAreaId(), serialNumber));
      }

      return elementIds;
   }

   @Override
   public List<String> getBridgeElementIds(String serialNumber, Long fileId) {
      List<String> elementIds = null;
      BimModelCommonDO bimModelCommonDO = this.baseMapper
         .selectOne((Wrapper<BimModelCommonDO>)new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getFileId, fileId));
      Preconditions.checkArgument(bimModelCommonDO != null, "bim模型不存在");
      PlanMonomer monomer = this.planMonomerService.getById(bimModelCommonDO.getMonomerId());
      List<TechArtifact> artifacts = this.artifactService
         .list(
            (Wrapper<TechArtifact>)(new LambdaQueryWrapper<TechArtifact>().eq(TechArtifact::getMonomerId, monomer.getId()))
               .eq(TechArtifact::getSerialNumber, serialNumber)
         );
      if (CollectionUtils.isNotEmpty(artifacts)) {
         if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())
            || BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
            elementIds = Convert.toList(String.class, this.redisUtils.hget("MONOMER_MODEL:" + bimModelCommonDO.getMonomerId(), serialNumber));
         }

         if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())
            && BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
            elementIds = Convert.toList(String.class, this.redisUtils.hget("AREA_MODEL:" + bimModelCommonDO.getAreaId(), serialNumber));
         }
      } else {
         if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())
            || BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
            elementIds = Convert.toList(String.class, this.redisUtils.hget("BRIDGE_UNIT:MONOMER_MODEL:" + bimModelCommonDO.getMonomerId(), serialNumber));
         }

         if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())
            && BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
            elementIds = Convert.toList(String.class, this.redisUtils.hget("BRIDGE_UNIT:AREA_MODEL:" + bimModelCommonDO.getAreaId(), serialNumber));
         }
      }

      return elementIds;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean modelIntegration(Set<Long> areaIds, Long monomerId) {
      BimModelConfigurationDO configurationDO = this.bimModelConfigurationService
         .getOne((Wrapper<BimModelConfigurationDO>)new LambdaQueryWrapper<BimModelConfigurationDO>().eq(BimModelConfigurationDO::getMonomerId, monomerId));
      Preconditions.checkArgument(BimImportModeEnum.INTEGRATION_MODE.getType().equals(configurationDO.getImportMode()), "配置不是集成模式，无法发起模型集成");
      FileIntegrateRequest request = new FileIntegrateRequest();
      List<IntegrateSource> sources = new ArrayList<>();
      List<BimModelCommonDO> bimModelCommonDOS = this.baseMapper
         .selectList((Wrapper<BimModelCommonDO>)new LambdaQueryWrapper<BimModelCommonDO>().in(BimModelCommonDO::getAreaId, areaIds));
      Preconditions.checkArgument(bimModelCommonDOS.size() == areaIds.size(), "区域模型不存在!!!");
      bimModelCommonDOS.forEach(
         bimModelCommonDO -> {
            Preconditions.checkArgument(
               BimStatusIntegrationEnum.PROCESSING_NO.getName().equals(bimModelCommonDO.getIntegrationStatus())
                  || BimStatusIntegrationEnum.FAILED.getName().equals(bimModelCommonDO.getIntegrationStatus()),
               "该区域下的模型已参与集成!!!"
            );
            bimModelCommonDO.setIntegrationStatus(BimStatusIntegrationEnum.PROCESSING.getName());
            Preconditions.checkArgument(BimStatusCommonEnum.SUCCESS.getName().equals(bimModelCommonDO.getTranslateStatus()), "区域模型未转换成功，无法集成");
            IntegrateSource source = new IntegrateSource();
            source.setFileId(bimModelCommonDO.getFileId());
            sources.add(source);
         }
      );
      request.setSources(sources);
      BimModelCommonDO integrationModel = this.baseMapper
         .selectOne(
            (Wrapper<BimModelCommonDO>)(new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getMonomerId, monomerId))
               .eq(BimModelCommonDO::getModelType, BimModelTypeEnum.INTEGRATIONTYPE.getName())
         );
      if (integrationModel != null) {
         Preconditions.checkArgument(!BimStatusIntegrationEnum.PROCESSING.getName().equals(integrationModel.getIntegrationStatus()), "集成模型处于集成中,不能发起新的集成");
         integrationModel.setIntegrationStatus(BimStatusIntegrationEnum.PROCESSING.getName());
         this.baseMapper.updateById(integrationModel);
         List<BimModelCommonDO> areaModel = this.baseMapper
            .selectList(
               (Wrapper<BimModelCommonDO>)((((new LambdaQueryWrapper<BimModelCommonDO>()
                              .eq(BimModelCommonDO::getMonomerId, monomerId))
                           .eq(BimModelCommonDO::getImportMode, integrationModel.getImportMode()))
                        .isNotNull(BimModelCommonDO::getAreaId))
                     .eq(BimModelCommonDO::getModelType, BimModelTypeEnum.FILETYPE.getName()))
                  .eq(BimModelCommonDO::getIntegrationStatus, BimStatusIntegrationEnum.SUCCESS.getName())
            );
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(areaModel), "模型未集成成功");
         areaModel.forEach(ex -> {
            IntegrateSource source = new IntegrateSource();
            source.setFileId(ex.getFileId());
            sources.add(source);
         });
      } else {
         Preconditions.checkArgument(areaIds.size() > 1, "单体下还没有集成的模型,请选择两个及以上的区域模型发起集成!!!");
         integrationModel = BimModelCommonDO.builder()
            .monomerId(monomerId)
            .projectId(configurationDO.getProjectId())
            .fileId(null)
            .fileName(null)
            .integrationStatus(BimStatusIntegrationEnum.PROCESSING.getName())
            .modelType(BimModelTypeEnum.INTEGRATIONTYPE.getName())
            .importMode(configurationDO.getImportMode())
            .build();
         this.baseMapper.insert(integrationModel);
      }

      log.info("bim模型发起集成------------------------------");

      try {
         String token = UUID.randomUUID().toString().replace("-", "");
         String join = StringUtils.join(areaIds, ",");
         this.redisUtils.set(BimRedisConstants.MODEL_TRANSLATE + integrationModel.getId(), token);
         String modelUrl = this.configProperties.getUrl()
            + "api/model/3DModel/integrate/status/callback"
            + "?modelId="
            + integrationModel.getId()
            + "&areaIds="
            + join
            + "&userId="
            + UserUtil.getCurrentUserId()
            + "&token="
            + token;
         request.setCallback(modelUrl);
         request.setCallback(modelUrl);
         ObjectMapper objectMapper = new ObjectMapper();
         ObjectNode config = objectMapper.createObjectNode();
         ObjectNode configNode = config.putObject("config");
         configNode.put("toBimtiles", "true");

         try {
            String jsonString = objectMapper.writeValueAsString(config);
            request.setConfig(jsonString);
         } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
         }

         FileIntegrateBean integrate = this.bimfaceClient.integrate(request);
         if (integrate != null) {
            integrationModel.setOldFileId(integrationModel.getFileId());
            integrationModel.setFileId(integrate.getIntegrateId());
            log.info("bim集成模型回调URL------------------------------" + modelUrl);
         }

         return true;
      } catch (BimfaceException e) {
         log.error("bim模型集成失败------------------------------", e);
         if (integrationModel.getFileId() != null) {
            integrationModel.setIntegrationStatus(BimStatusIntegrationEnum.SUCCESS.getName());
         }

         bimModelCommonDOS.forEach(bimModelCommonDO -> bimModelCommonDO.setIntegrationStatus(BimStatusIntegrationEnum.FAILED.getName()));
      } finally {
         if (integrationModel.getFileId() == null) {
            this.baseMapper.deleteById(integrationModel);
         } else {
            this.baseMapper.updateById(integrationModel);
         }

         bimModelCommonDOS.forEach(bimModelCommonDO -> this.baseMapper.updateById(bimModelCommonDO));
      }

      return false;
   }

   @Override
   public ResultVO uploadModel(MultipartFile file, Long monomerId, Long areaId, PlanApproveCacheObjectDTOParam cacheObjectDTOParam) throws Exception {
      PlanMonomer monomer = this.planMonomerService.getById(monomerId);
      Preconditions.checkArgument(monomer != null, "上传失败，该单体不存在");
      ContractProject project = this.contractProjectService.getById(monomer.getProjectId());
      Preconditions.checkArgument(project != null, "上传失败，该项目不存在");
      BimModelConfigurationDO configurationDO = this.bimModelConfigurationService
         .getOne((Wrapper<BimModelConfigurationDO>)new LambdaQueryWrapper<BimModelConfigurationDO>().eq(BimModelConfigurationDO::getMonomerId, monomerId));
      Preconditions.checkArgument(configurationDO != null, "上传失败,模型配置未设置!!!");
      Preconditions.checkArgument(!ProjectStatusEnum.COMPLETED.getType().equals(project.getStatus()), "上传失败，项目已完成");
      Preconditions.checkArgument(!ProjectStatusEnum.PAUSE.getType().equals(project.getStatus()), "上传失败，项目已暂停");
      BimModelCommonDO bimModelCommonDO;
      if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(configurationDO.getImportMode())) {
         Preconditions.checkArgument(areaId != null, "集成模式下，区域id不能为空!!!");
         PlanArea area = this.planAreaService.getById(areaId);
         Preconditions.checkArgument(area != null, "上传失败，该区域不存在");
         bimModelCommonDO = this.baseMapper
            .selectOne(
               (Wrapper<BimModelCommonDO>)(new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getMonomerId, monomerId))
                  .eq(BimModelCommonDO::getAreaId, areaId)
            );
      } else {
         Preconditions.checkArgument(areaId == null, "单体模式,区域不能上传模型");
         bimModelCommonDO = this.baseMapper
            .selectOne(
               (Wrapper<BimModelCommonDO>)(new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getMonomerId, monomerId))
                  .isNull(BimModelCommonDO::getAreaId)
            );
      }

      if (bimModelCommonDO != null) {
         Preconditions.checkArgument(
            BimStatusIntegrationEnum.FAILED.getName().equals(bimModelCommonDO.getIntegrationStatus())
               || BimStatusIntegrationEnum.PROCESSING_NO.getName().equals(bimModelCommonDO.getIntegrationStatus()),
            "模型已集成/集成中,暂时无法替换"
         );
      }

      return this.achievementBiz
         .createDrawingApprove(
            file, monomer.getProjectId(), monomerId, areaId, monomerId, PlanModuleTypeEnum.MODEL.getType(), null, null, null, null, false, null
         );
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public ResultVO newUploadModel(MultipartFile file, Long monomerId, Long areaId, PlanApproveCacheObjectDTOParam cacheObjectDTOParam) {
      Preconditions.checkArgument(this.bimEnabled, "BIMFACE集成未启用");
      Preconditions.checkArgument(StringUtils.isNotBlank(this.projectId), "BIMFACE未配置engine.projectId");
      String callbackBase = this.translateCallbackBase();
      Preconditions.checkArgument(StringUtils.isNotBlank(this.configProperties.getFilePath()), "模型附件目录未配置");
      Preconditions.checkArgument(file != null && !file.isEmpty() && StringUtils.isNotBlank(file.getOriginalFilename()), "请选择模型文件");

      // Lock the parent so concurrent first uploads cannot create two rows for the same monomer.
      PlanMonomer monomer = this.lockMonomer(monomerId);
      Preconditions.checkArgument(monomer != null, "上传失败，该单体不存在");
      ContractProject project = this.contractProjectService.getById(monomer.getProjectId());
      Preconditions.checkArgument(project != null, "上传失败，该项目不存在");
      BimModelConfigurationDO configurationDO = this.bimModelConfigurationService
         .getOne((Wrapper<BimModelConfigurationDO>)new LambdaQueryWrapper<BimModelConfigurationDO>().eq(BimModelConfigurationDO::getMonomerId, monomerId));
      Preconditions.checkArgument(configurationDO != null, "上传失败,模型配置未设置!!!");
      Preconditions.checkArgument(!ProjectStatusEnum.COMPLETED.getType().equals(project.getStatus()), "上传失败，项目已完成");
      Preconditions.checkArgument(!ProjectStatusEnum.PAUSE.getType().equals(project.getStatus()), "上传失败，项目已暂停");
      LambdaQueryWrapper<BimModelCommonDO> modelQuery = new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getMonomerId, monomerId);
      String cacheKey;
      if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(configurationDO.getImportMode())) {
         Preconditions.checkArgument(areaId != null, "集成模式下，区域id不能为空!!!");
         PlanArea area = this.planAreaService.getById(areaId);
         Preconditions.checkArgument(area != null && monomerId.equals(area.getMonomerId()), "上传失败，该区域不属于当前单体");
         modelQuery.eq(BimModelCommonDO::getAreaId, areaId);
         cacheKey = "AREA_MODEL:" + areaId;
      } else {
         Preconditions.checkArgument(areaId == null, "单体模式,区域不能上传模型");
         modelQuery.isNull(BimModelCommonDO::getAreaId);
         cacheKey = "MONOMER_MODEL:" + monomerId;
      }

      BimModelCommonDO model = this.baseMapper.selectOne(modelQuery.last("FOR UPDATE"));
      if (model != null) {
         Preconditions.checkArgument(!isActivePending(model), "模型正在上传或转换，请稍后再替换");
         Preconditions.checkArgument(
            BimStatusIntegrationEnum.FAILED.getName().equals(model.getIntegrationStatus())
               || BimStatusIntegrationEnum.PROCESSING_NO.getName().equals(model.getIntegrationStatus()),
            "模型已集成/集成中,暂时无法替换"
         );
      }

      this.checkBimModel(file.getSize());
      // The attachment service preserves the extension when applying this unique staging name.
      Attachment attachment = this.attachmentService.uploadFile(file, AttachmentTypeEnum.BIMFACE.getType(), UUID.randomUUID().toString());
      Preconditions.checkArgument(attachment != null && attachment.getId() != null && StringUtils.isNotBlank(attachment.getRelativePath()), "模型附件保存失败");
      Path path = Paths.get(this.configProperties.getFilePath() + attachment.getRelativePath());
      long fileSize = file.getSize();
      Long previousFileId = model == null ? null : model.getFileId();
      BimModelCommonDO job = model == null ? BimModelCommonDO.builder().monomerId(monomerId).areaId(areaId)
         .projectId(monomer.getProjectId()).modelType(BimModelTypeEnum.FILETYPE.getName()).successQuantity(0L).build() : model;
      TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronization() {
         @Override
         public void afterCommit() {
            new Thread(() -> {
               BimModelCommonServiceImpl.this.redisUtils.expire(cacheKey, 1L);
               BimModelCommonServiceImpl.this.uploadAndTranslate(job, path, previousFileId, fileSize, callbackBase);
            }, "bimface-upload-" + job.getId()).start();
         }

         @Override
         public void afterCompletion(int status) {
            if (status == STATUS_ROLLED_BACK) {
               try {
                  Files.deleteIfExists(path);
               } catch (IOException e) {
                  log.warn("BIM附件回滚清理失败，附件ID {}", attachment.getId());
               }
            }
         }
      });

      job.setCreateUserId(cacheObjectDTOParam != null ? cacheObjectDTOParam.getCreateUserId() : UserUtil.getCurrentUserId());
      job.setCreateTime(LocalDateTime.now());
      job.setFileSize(modelSizeMb(fileSize));
      job.setFileName(file.getOriginalFilename());
      job.setTranslateStatus(BimStatusCommonEnum.UPLOAD_PROCESSING.getName());
      job.setFileThumbnail(null);
      job.setFileTinyThumbnail(null);
      job.setReason(null);
      job.setPath(path.toString());
      job.setImportMode(configurationDO.getImportMode());
      job.setAttachmentId(attachment.getId());
      job.setIntegrationStatus(BimStatusIntegrationEnum.PROCESSING_NO.getName());
      int updated = model == null ? this.baseMapper.insert(job) : this.baseMapper.update(job, new LambdaUpdateWrapper<BimModelCommonDO>()
         .eq(BimModelCommonDO::getId, job.getId()).set(BimModelCommonDO::getReason, null));
      Preconditions.checkState(updated == 1, "模型上传记录保存失败");
      return ResultVO.builder().message(job.getTranslateStatus()).build();
   }

   private String translateCallbackBase() {
      try {
         String callbackUrl = StringUtils.defaultIfBlank(this.translateCallbackBaseUrl, this.configProperties.getUrl());
         URI base = URI.create(StringUtils.defaultString(callbackUrl).trim());
         if (base.getHost() != null && base.getRawUserInfo() == null && base.getRawQuery() == null && base.getRawFragment() == null
            && ("http".equalsIgnoreCase(base.getScheme()) || "https".equalsIgnoreCase(base.getScheme()))) {
            return StringUtils.stripEnd(base.toString(), "/") + "/" + TRANSLATE_STATUS_CALLBACK;
         }
      } catch (IllegalArgumentException ignored) {
      }
      throw new IllegalArgumentException("请配置有效的BIMFACE回调地址engine.translateCallbackBaseUrl");
   }

   private void uploadAndTranslate(BimModelCommonDO model, Path path, Long previousFileId, long fileSize, String callbackBase) {
      Long fileId;
      try (InputStream stream = Files.newInputStream(path)) {
         BimModelCommonDO current = this.baseMapper.selectById(model.getId());
         if (current == null || !model.getAttachmentId().equals(current.getAttachmentId())
            || !BimStatusCommonEnum.UPLOAD_PROCESSING.getName().equals(current.getTranslateStatus()) || hasPendingExpired(current)) {
            return;
         }
         FileItemDTO uploaded = this.bimfaceClient.uploadFileItem(
            stream, this.projectId, this.projectId, "/", model.getFileName(), Files.size(path), null
         );
         fileId = uploaded == null || uploaded.getFileId() == null ? null : Long.valueOf(uploaded.getFileId());
         if (fileId == null || fileId <= 0) {
            throw new IllegalStateException("BIMFACE上传未返回文件ID");
         }
      } catch (Exception e) {
         log.warn("BIMFACE文件上传失败，模型ID {}，异常类型 {}", model.getId(), e.getClass().getSimpleName());
         this.recordUploadedFile(model, previousFileId, BimStatusCommonEnum.UPLOAD_FAILED, "BIMFACE文件上传失败");
         return;
      } finally {
         try {
            if (!this.attachmentService.deleteFile(model.getAttachmentId())) {
               log.warn("BIM上传附件文件清理失败，附件ID {}", model.getAttachmentId());
            }
         } catch (RuntimeException e) {
            log.warn("BIM上传附件清理失败，附件ID {}，异常类型 {}", model.getAttachmentId(), e.getClass().getSimpleName());
         }
      }

      if (!this.recordUploadedFile(model, fileId, BimStatusCommonEnum.PROCESSING, null)) {
         return;
      }

      if (previousFileId != null && !previousFileId.equals(fileId)) {
         try {
            this.bimfaceClient.deleteFile(previousFileId);
         } catch (BimfaceException | RuntimeException e) {
            log.warn("BIMFACE旧模型文件清理失败，文件ID {}，异常类型 {}", previousFileId, e.getClass().getSimpleName());
         }
      }

      String token = UUID.randomUUID().toString().replace("-", "");
      String callbackKey = translateCallbackKey(model.getId(), fileId, token);
      if (!this.redisUtils.set(callbackKey, model.getAttachmentId().toString(), TRANSLATE_CALLBACK_TTL_SECONDS)) {
         this.markSubmissionFailed(model, fileId, "模型转换回调注册失败");
         return;
      }

      FileTranslateRequest request = new FileTranslateRequest();
      TranslateSource source = new TranslateSource();
      source.setFileId(fileId);
      request.setSource(source);
      request.setCallback(callbackBase + "?modelId=" + model.getId() + "&token=" + token);
      Map<String, String> config = new HashMap<>();
      if (fileSize / 1024000L > 20L) {
         config.put("toBimtiles", "true");
      }
      request.setConfig(config);

      try {
         if (this.bimfaceClient.translate(request) == null && this.queryTranslation(fileId) == null) {
            this.markSubmissionFailed(model, fileId, "BIMFACE未返回模型转换任务");
         }
      } catch (BimfaceException | RuntimeException e) {
         log.warn("BIMFACE发起转换失败，模型ID {}，异常类型 {}", model.getId(), e.getClass().getSimpleName());
         if (this.queryTranslation(fileId) == null) {
            // A transport failure may happen after BIMFACE accepted the request.
            Throwable cause = e;
            while (cause != null && !(cause instanceof IOException)) {
               cause = cause.getCause();
            }
            if (cause == null) {
               this.markSubmissionFailed(model, fileId, "BIMFACE发起模型转换失败");
            }
         }
      }
   }

   private boolean recordUploadedFile(BimModelCommonDO model, Long fileId, BimStatusCommonEnum status, String reason) {
      LambdaUpdateWrapper<BimModelCommonDO> update = this.pendingJob(model, model.getFileId(), BimStatusCommonEnum.UPLOAD_PROCESSING.getName())
         .set(BimModelCommonDO::getFileId, fileId)
         .set(BimModelCommonDO::getTranslateStatus, status.getName())
         .set(BimModelCommonDO::getReason, reason);
      if (status == BimStatusCommonEnum.PROCESSING) {
         update.set(BimModelCommonDO::getCreateTime, LocalDateTime.now());
      }
      return this.baseMapper.update(null, update) == 1;
   }

   private void markSubmissionFailed(BimModelCommonDO model, Long fileId, String reason) {
      this.baseMapper.update(null, this.pendingJob(model, fileId, BimStatusCommonEnum.PROCESSING.getName())
         .set(BimModelCommonDO::getTranslateStatus, BimStatusCommonEnum.FAILED.getName())
         .set(BimModelCommonDO::getReason, reason));
   }

   private LambdaUpdateWrapper<BimModelCommonDO> pendingJob(BimModelCommonDO model, Long fileId, String status) {
      LambdaUpdateWrapper<BimModelCommonDO> update = new LambdaUpdateWrapper<BimModelCommonDO>()
         .eq(BimModelCommonDO::getId, model.getId())
         .eq(BimModelCommonDO::getModelType, BimModelTypeEnum.FILETYPE.getName())
         .eq(BimModelCommonDO::getTranslateStatus, status)
         .set(BimModelCommonDO::getUpdateTime, LocalDateTime.now());
      if (fileId == null) {
         update.isNull(BimModelCommonDO::getFileId);
      } else {
         update.eq(BimModelCommonDO::getFileId, fileId);
      }
      // Older processing records may not have an attachment ID.
      return model.getAttachmentId() == null ? update.isNull(BimModelCommonDO::getAttachmentId)
         : update.eq(BimModelCommonDO::getAttachmentId, model.getAttachmentId());
   }

   private PlanMonomer lockMonomer(Long monomerId) {
      return this.planMonomerService.getOne(new LambdaQueryWrapper<PlanMonomer>()
         .eq(PlanMonomer::getId, monomerId).last("FOR UPDATE"));
   }

   private static boolean isPending(String status) {
      return BimStatusCommonEnum.UPLOAD_PROCESSING.getName().equals(status) || BimStatusCommonEnum.PROCESSING.getName().equals(status);
   }

   private static boolean isActivePending(BimModelCommonDO model) {
      return isPending(model.getTranslateStatus()) && !hasPendingExpired(model);
   }

   private static boolean hasPendingExpired(BimModelCommonDO model) {
      if (!isPending(model.getTranslateStatus()) || model.getCreateTime() == null) {
         return false;
      }
      long timeout = BimStatusCommonEnum.UPLOAD_PROCESSING.getName().equals(model.getTranslateStatus())
         ? UPLOAD_PENDING_SECONDS : TRANSLATE_CALLBACK_TTL_SECONDS;
      return !model.getCreateTime().plusSeconds(timeout).isAfter(LocalDateTime.now());
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public void setIntegrateStatusCallback(Long modelId, String areaIds, Long userId, String token) {
      String key = BimRedisConstants.MODEL_TRANSLATE + modelId;
      String accessToken = (String)this.redisUtils.get(key);
      Preconditions.checkArgument(accessToken != null && accessToken.equals(token), "访问令牌已失效");
      BimModelCommonDO integrateModel = this.baseMapper.selectById(modelId);
      Preconditions.checkArgument(integrateModel != null, "集成模型不存在");
      List<Long> areaIdList = Arrays.stream(areaIds.split(",")).map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
      List<BimModelCommonDO> bimModelCommonDOS = this.baseMapper
         .selectList((Wrapper<BimModelCommonDO>)new LambdaQueryWrapper<BimModelCommonDO>().in(BimModelCommonDO::getAreaId, areaIdList));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(bimModelCommonDOS), "参与集成的区域模型不存在!!!");
      new AtomicReference();

      try {
         FileIntegrateBean integrate = this.bimfaceClient.getIntegrate(integrateModel.getFileId());
         if (integrate.getStatus().equals(BimStatusIntegrationEnum.SUCCESS.getName())) {
            log.info("集成模型缩略图：" + Arrays.toString(integrate.getThumbnail()));
            if (integrate.getThumbnail() != null && integrate.getThumbnail().length > 0) {
               integrateModel.setFileTinyThumbnail(integrate.getThumbnail()[0]);
               integrateModel.setFileThumbnail(integrate.getThumbnail()[1]);
            }

            integrateModel.setCreateUserId(userId);
            integrateModel.setIntegrationStatus(BimStatusIntegrationEnum.SUCCESS.getName());
            integrateModel.setFileName(integrate.getName());
            bimModelCommonDOS.forEach(bimModelCommonDO -> bimModelCommonDO.setIntegrationStatus(BimStatusIntegrationEnum.SUCCESS.getName()));
            log.info("bim模型集成成功------------------------------");
         } else {
            if (integrateModel.getOldFileId() != null) {
               integrateModel.setIntegrationStatus(BimStatusIntegrationEnum.SUCCESS.getName());
            } else {
               integrateModel.setIntegrationStatus(BimStatusIntegrationEnum.FAILED.getName());
            }

            integrateModel.setReason(integrate.getReason());
            integrateModel.setFileId(integrateModel.getOldFileId());
            bimModelCommonDOS.forEach(bimModelCommonDO -> bimModelCommonDO.setIntegrationStatus(BimStatusIntegrationEnum.FAILED.getName()));
            log.info("bim模型集成结果------------------------------{}", integrate);
         }
      } catch (BimfaceException e) {
         if (integrateModel.getOldFileId() != null) {
            integrateModel.setIntegrationStatus(BimStatusIntegrationEnum.SUCCESS.getName());
         } else {
            integrateModel.setIntegrationStatus(BimStatusCommonEnum.FAILED.getName());
         }

         integrateModel.setFileId(integrateModel.getOldFileId());
         bimModelCommonDOS.forEach(bimModelCommonDO -> bimModelCommonDO.setIntegrationStatus(BimStatusIntegrationEnum.FAILED.getName()));
         log.error("bim模型集成失败------------------------------", e);
      } finally {
         if (integrateModel.getFileId() == null) {
            this.baseMapper.deleteById(integrateModel);
         } else {
            this.baseMapper.updateById(integrateModel);
         }

         bimModelCommonDOS.forEach(bimModelCommonDO -> this.baseMapper.updateById(bimModelCommonDO));
         log.info("bim模型集成结束------------------------------");
      }

      this.redisUtils.del(key);
   }

   @Override
   public Boolean removeIntegration(Long monomerId) {
      BimModelCommonDO integrationModel = this.baseMapper
         .selectOne(
            (Wrapper<BimModelCommonDO>)(new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getMonomerId, monomerId))
               .eq(BimModelCommonDO::getModelType, BimModelTypeEnum.INTEGRATIONTYPE.getName())
         );
      Preconditions.checkArgument(integrationModel != null, "集成模型不存在");

      try {
         this.bimfaceClient.deleteIntegrate(integrationModel.getFileId());
      } catch (BimfaceException e) {
         log.error("集成模型删除失败------------------------------", e);
      }

      this.baseMapper.deleteById(integrationModel);
      List<BimModelCommonDO> bimModelCommonDOS = this.baseMapper
         .selectList(
            (Wrapper<BimModelCommonDO>)(new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getMonomerId, monomerId))
               .eq(BimModelCommonDO::getModelType, BimModelTypeEnum.FILETYPE.getName())
         );
      bimModelCommonDOS.forEach(bimModelCommonDO -> {
         if (!BimStatusIntegrationEnum.PROCESSING_NO.getName().equals(bimModelCommonDO.getIntegrationStatus())) {
            bimModelCommonDO.setIntegrationStatus(BimStatusIntegrationEnum.PROCESSING_NO.getName());
            this.baseMapper.updateById(bimModelCommonDO);
         }
      });
      this.redisUtils.expire("MONOMER_MODEL:" + monomerId, 1L);
      return true;
   }

   @Override
   public Integer selectSuccessQuantity(Long monomerId) {
      return this.baseMapper.selectSuccessQuantity(null, monomerId, null);
   }

   @Override
   public BimEngineStatusResponseVO getModelInfoByFileId(Long fileId) {
      FileTranslateBean integrate = null;

      try {
         integrate = this.bimfaceClient.getTranslate(fileId);
      } catch (Exception e) {
         log.error(e.getMessage(), e);
      }

      Preconditions.checkArgument(integrate != null, "文件转换状态获取失败!");
      BimEngineStatusResponseVO vo = new BimEngineStatusResponseVO();
      if (BimStatusIntegrationEnum.SUCCESS.getName().equals(integrate.getStatus())) {
         vo.setModelType(BimModelTypeEnum.FILETYPE.getName());
         vo.setViewToken(this.getViewToken(fileId, BimModelTypeEnum.FILETYPE.getName()));
         vo.setStatus(integrate.getStatus());
      }

      return vo;
   }

   @Transactional
   @Override
   public Boolean migration() {
      List<BimModelCommonDO> list = this.list();

      String accessToken;
      try {
         accessToken = this.bimfaceClient.getAccessTokenService().getAccessToken();
      } catch (BimfaceException e) {
         throw new RuntimeException(e);
      }

      String targetParentId = "10000929260860";
      String targetProjectId = "10000929260860";

      for (BimModelCommonDO model : list) {
         Long fileId = model.getFileId();
         if (fileId != null) {
            JSONObject json = new JSONObject();
            json.set("fileItemIds", CollUtil.newArrayList(fileId.toString()));
            json.set("targetParentId", targetParentId);
            json.set("targetProjectId", targetProjectId);
            json.set("onlyFile", false);
            HttpResponse response = HttpRequest.post("https://api.bimface.com/bdfs/data/v1/projects/10000000004778/fileItems/copyItem")
               .header("Authorization", "Bearer " + accessToken)
               .header("Content-Type", "application/json")
               .body(json.toString())
               .timeout(30000)
               .execute();
            if (response.getStatus() != 200) {
               log.error("复制文件失败，fileId={}, 响应={}", fileId, response.body());
               throw new RuntimeException("调用BIMFace复制接口失败");
            }

            JSONObject result = JSONUtil.parseObj(response.body());
            JSONArray dataArray = result.getJSONArray("data");
            if (!CollUtil.isEmpty(dataArray)) {
               String newFileId = dataArray.getJSONObject(0).getStr("fileId");
               model.setOriginalFileId(fileId);
               model.setFileId(Convert.toLong(newFileId));
               this.updateById(model);
            }
         }
      }

      return Boolean.TRUE;
   }

   private String getViewToken(Long fileId, String modelType) {
      String viewToken = null;

      try {
         if (BimModelTypeEnum.FILETYPE.getName().equals(modelType)) {
            viewToken = this.bimfaceClient.getViewTokenByFileId(fileId);
         }

         if (BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(modelType)) {
            viewToken = this.bimfaceClient.getViewTokenByIntegrateId(fileId);
         }
      } catch (Exception e) {
         log.error(e.getMessage(), e);
      }

      Preconditions.checkArgument(viewToken != null, "viewToken获取失败!");
      return viewToken;
   }

   private static double modelSizeMb(long fileSize) {
      return Math.round(fileSize / 1048576.0 * 100.0) / 100.0;
   }

   private void checkBimModel(long fileSize) {
      Config config = this.configService.getByCode("BIM_MODEL_CONVERT_RESTRICT_ENCIPHER");
      if (ObjectUtil.isNotEmpty(config)) {
         BimModelConfigDTO modelConfig = JSON.parseObject(AESUtils.decrypt("mdhQVigt/AZ7eiYmRONYRQ==", config.getValue()), BimModelConfigDTO.class);
         if (modelConfig.getEnabled()) {
            List<BimModelCommonDO> bimModelCommonDOList = this.baseMapper
               .selectList(
                  (Wrapper<BimModelCommonDO>)((new LambdaQueryWrapper<BimModelCommonDO>()
                           .eq(BimModelCommonDO::getTranslateStatus, BimStatusCommonEnum.PROCESSING.getName()))
                        .or())
                     .eq(BimModelCommonDO::getTranslateStatus, BimStatusCommonEnum.UPLOAD_PROCESSING.getName())
               );
            if (bimModelCommonDOList != null) {
               bimModelCommonDOList = bimModelCommonDOList.stream().filter(BimModelCommonServiceImpl::isActivePending).collect(Collectors.toList());
            }
            if (modelConfig.getModelUploadLimitType() == BimModelRestrictedTypeEnum.TOTAL_QUANTITY.getType()) {
               int num = Optional.ofNullable(bimModelCommonDOList).map(List::size).orElse(0);
               SysBusinessDataStatistics totalQuantity = this.restrictConfigService
                  .getOne((Wrapper<SysBusinessDataStatistics>)new LambdaQueryWrapper<SysBusinessDataStatistics>().eq(SysBusinessDataStatistics::getCode, "TOTAL_QUANTITY"));
               Integer original = ObjectUtil.isNotEmpty(totalQuantity) ? (int)Double.parseDouble(totalQuantity.getValue()) : 0;
               Preconditions.checkArgument(original + num < modelConfig.getMaxModelUploadNum(), "模型转换次数已达上限(包含正在转换中的文件)！");
            } else {
               Double sum = Optional.ofNullable(bimModelCommonDOList)
                  .orElseGet(Collections::emptyList)
                  .stream()
                  .filter(bimModel -> bimModel.getFileSize() != null)
                  .mapToDouble(BimModelCommonDO::getFileSize)
                  .sum();
               SysBusinessDataStatistics totalQuantity = this.restrictConfigService
                  .getOne((Wrapper<SysBusinessDataStatistics>)new LambdaQueryWrapper<SysBusinessDataStatistics>().eq(SysBusinessDataStatistics::getCode, "FILE_SIZE"));
               Double original = ObjectUtil.isNotEmpty(totalQuantity) ? Double.parseDouble(totalQuantity.getValue()) : 0.0;
               Preconditions.checkArgument(original + sum + modelSizeMb(fileSize) < modelConfig.getMaxModelUploadFileSize() * 1024.0,
                  "模型文件大小已达上限(包含正在转换中的文件)！");
            }
         }
      }
   }

   private void updateModelDataStatistics(Double fileSize) {
      // Serialize the existing quota service's read-modify-write across different models.
      this.restrictConfigService.list(new LambdaQueryWrapper<SysBusinessDataStatistics>()
         .in(SysBusinessDataStatistics::getCode, "TOTAL_QUANTITY", "FILE_SIZE")
         .orderByAsc(SysBusinessDataStatistics::getId).last("FOR UPDATE"));
      List<BimModelRestrictConfigDTO> bimModelRestrictConfigDTOList = new ArrayList<>();
      bimModelRestrictConfigDTOList.add(BimModelRestrictConfigDTO.builder().code("TOTAL_QUANTITY").name("bim模型文件转换成功次数").value("1").build());
      bimModelRestrictConfigDTOList.add(
         BimModelRestrictConfigDTO.builder().code("FILE_SIZE").name("bim模型文件大小已达值").value(String.valueOf(fileSize == null ? 0.0 : fileSize)).build()
      );
      this.restrictConfigService.updateValue(bimModelRestrictConfigDTOList);
   }

   @Override
   public List<String> getArtifactElementIdList(String fileId, String serialNumber, String targetType) {
      String artifactJson = this.getArtifactelementIdJSON(fileId, serialNumber, targetType);
      List<String> artifactElementIdList = this.getAllElementIds(artifactJson);
      if (CollectionUtils.isEmpty(artifactElementIdList)) {
         return null;
      }

      String partElementJSON = this.getPartElementIdJSON(fileId, artifactElementIdList.get(0), targetType);
      return this.getAllElementIds(partElementJSON);
   }

   private String getArtifactelementIdJSON(String targetIds, String serialNumber, String targetType) {
      String matchSerialNumber = "{ \"match\" : {\"Assembly/Cast unit Mark\" : \"" + serialNumber + "\"}}";
      return "{\"targetType\":\"" + targetType + "\",\"targetIds\":[\"" + targetIds + "\"],\"query\":" + String.join(",", matchSerialNumber) + "}";
   }

   private String getPartElementIdJSON(String targetIds, String elementId, String targetType) {
      String matchSerialNumber = "{ \"match\" : {\"IfcElementAssemblyId\" : \"" + elementId + "\"}}";
      return "{\"targetType\":\"" + targetType + "\",\"targetIds\":[\"" + targetIds + "\"],\"query\":" + String.join(",", matchSerialNumber) + "}";
   }

   private List<String> getAllElementIds(String requestBody) {
      try {
         List<SearchElementIdsResp> elementIdsResps = this.bimfaceClient.getElements(requestBody);
         if (CollectionUtils.isEmpty(elementIdsResps)) {
            return null;
         }

         List<String> elementIds = elementIdsResps.get(0).getElementIds();
         return CollectionUtils.isEmpty(elementIds) ? null : elementIds;
      } catch (Exception e) {
         log.error("请求bimFace接口报错", e);
         return null;
      }
   }
}
