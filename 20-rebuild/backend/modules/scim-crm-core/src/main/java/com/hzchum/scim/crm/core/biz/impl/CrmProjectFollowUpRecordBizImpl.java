package com.hzchum.scim.crm.core.biz.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ApproveRecordStatusEnum;
import com.hzchum.scim.common.core.api.enums.ApproveSourceEnum;
import com.hzchum.scim.common.core.api.enums.ApproveTemplateVersionsFlowEnum;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecordDetail;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.pojo.dto.oa.ZhongNanWorkFlowDTO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaArgumentDTO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaAttachmentsDTO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaProjectTrackingDTOParam;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaRevocationDTOParam;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordDetailService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.common.core.api.service.zhongnanoa.OaBusinessProcessService;
import com.hzchum.scim.common.core.api.utils.ComponentNameUtils;
import com.hzchum.scim.crm.core.api.biz.CrmInformationValidityPeriodConfigBiz;
import com.hzchum.scim.crm.core.api.biz.CrmOaConfigBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectFollowUpRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectInformationConfigBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectInformationWarehousingBiz;
import com.hzchum.scim.crm.core.api.enums.CrmCheckStatusEnum;
import com.hzchum.scim.crm.core.api.enums.CrmInformationValidityPeriodConfigEnum;
import com.hzchum.scim.crm.core.api.enums.CrmProjectInformationConfigEnum;
import com.hzchum.scim.crm.core.api.enums.CrmProjectScheduleTypeEnum;
import com.hzchum.scim.crm.core.api.pojo._do.CrmInformationValidityPeriodConfig;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectFollowUpRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectInformationConfig;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectInformationWarehousing;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmAuditCommonDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmFollowUpSimpleListDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmProjectFollowUpRecordDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmprojectInformationWarehousingFollowUpTimesAndDateDTO;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmProjectFollowUpRecordSaveParam;
import com.hzchum.scim.crm.core.api.service.CrmProjectFollowUpRecordService;
import com.hzchum.scim.crm.core.mapper.CrmProjectFollowUpRecordMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.UserService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CrmProjectFollowUpRecordBizImpl
   extends IBizImpl<CrmProjectFollowUpRecordService, CrmProjectFollowUpRecordMapper, CrmProjectFollowUpRecord>
   implements CrmProjectFollowUpRecordBiz {
   private static final Logger log = LoggerFactory.getLogger(CrmProjectFollowUpRecordBizImpl.class);
   private static final String OA_PROJECT_TRACKING = "项目跟踪";
   private static final String OA_PROJECT_TRACKING_WORKFLOW = "CRM项目跟踪流程（初鸣）";
   @Resource
   private CrmProjectInformationWarehousingBiz crmProjectInformationWarehousingBiz;
   @Resource
   private WmsApproveRecordService wmsApproveRecordService;
   @Resource
   private WmsApproveRecordDetailService wmsApproveRecordDetailService;
   @Resource
   private CrmInformationValidityPeriodConfigBiz crmInformationValidityPeriodConfigBiz;
   @Resource
   private CrmProjectInformationConfigBiz crmProjectInformationConfigBiz;
   @Resource
   private CrmOaConfigBiz crmOaConfigBiz;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private UserService userService;
   @Resource
   private OaBusinessProcessService oaBusinessProcessService;

   @Transactional
   @Override
   public Boolean saveCrmProjectFollowUpRecord(CrmProjectFollowUpRecordSaveParam copy) {
      CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingBiz
         .getById(copy.getCrmProjectInformationWarehousingId());
      Preconditions.checkArgument(crmProjectInformationWarehousing != null, "项目备案信息不存在");
      Preconditions.checkArgument(crmProjectInformationWarehousing.getInformationOperatorUserId().equals(UserUtil.getCurrentUserId()), "您不是该项目的操作人员,不可操作");
      Preconditions.checkArgument(crmProjectInformationWarehousing.getCrmCheckStatusEnum().equals(CrmCheckStatusEnum.PASS.getType()), "项目备案审核暂未通过不可进行跟进");
      Preconditions.checkArgument(
         !crmProjectInformationWarehousing.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.LAPSE_STATUS.getType()), "项目备案已失效不可进行跟进"
      );
      Preconditions.checkArgument(
         !crmProjectInformationWarehousing.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType()), "项目已中标不可进行跟进"
      );
      CrmProjectFollowUpRecord followUpRecord = BeanUtil.copy(copy, CrmProjectFollowUpRecord.class);
      followUpRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.PENDING.getType());
      followUpRecord.setCreateUserId(UserUtil.getCurrentUserId());
      if (CollectionUtils.isNotEmpty(copy.getFollowUpAttachment())) {
         followUpRecord.setFollowUpAttachment(StrUtil.join(",", copy.getFollowUpAttachment().stream().map(AttachmentDTO::getId).collect(Collectors.toList())));
      }

      this.baseService.save(followUpRecord);
      User applicant = this.userService.getById(UserUtil.getCurrentUserId());
      Preconditions.checkArgument(applicant != null, "申请人不存在");
      Integer effectiveRemainingTime = this.getFollowUpTimesAndDate(crmProjectInformationWarehousing.getId()).getEffectiveRemainingTime();
      if (!Boolean.TRUE.equals(this.crmOaConfigBiz.getOaConfig().getEnabled())) {
         WmsApproveRecord record = this.wmsApproveRecordService
            .createRecord(
               followUpRecord.getId(),
               crmProjectInformationWarehousing.getProjectName(),
               ApproveProcessTypeEnumV2.CRM_PROJECT_FOLLOW_UP.getType(),
               null,
               null,
               null,
               false,
               null,
               null,
               null
            );
         if (ReviewStatusEnum.REVIEWED.getType().equals(record.getReviewStatus())) {
            CrmInformationValidityPeriodConfig validityConfig = this.crmInformationValidityPeriodConfigBiz
               .getOne(
                  Wrappers.lambdaQuery(CrmInformationValidityPeriodConfig.class)
                     .eq(
                        CrmInformationValidityPeriodConfig::getCrmInformationValidityPeriodConfigEnum,
                        CrmInformationValidityPeriodConfigEnum.INFORMATION_VALIDITY_PERIOD.getType()
                     )
               );
            Preconditions.checkArgument(validityConfig != null, "项目有效期配置不存在");
            if (CrmProjectScheduleTypeEnum.FILING_STATUS.getType().equals(crmProjectInformationWarehousing.getCrmProjectScheduleTypeEnum())) {
               crmProjectInformationWarehousing.setCrmProjectScheduleTypeEnum(CrmProjectScheduleTypeEnum.FOLLOW_UP_STATUS.getType());
            }

            crmProjectInformationWarehousing.setValidityOfRegistration(validityConfig.getValidityOfRegistration());
            followUpRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.PASS.getType());
            this.crmProjectInformationWarehousingBiz.updateById(crmProjectInformationWarehousing);
         }

         followUpRecord.setApproveRecordId(record.getId());
         Preconditions.checkArgument(this.baseService.updateById(followUpRecord), "项目跟进回写审批记录失败");
         return Boolean.TRUE;
      } else {
         String requestId = this.createOaProjectTracking(
            followUpRecord, crmProjectInformationWarehousing, applicant, effectiveRemainingTime, copy.getFollowUpAttachment()
         );

         try {
            WmsApproveRecord record = this.createOaApproveRecord(followUpRecord, crmProjectInformationWarehousing, applicant, requestId);
            followUpRecord.setApproveRecordId(record.getId());
            Preconditions.checkArgument(this.baseService.updateById(followUpRecord), "项目跟踪回写审批记录失败");
         } catch (RuntimeException e) {
            this.compensateOaRequest(requestId, applicant, ApproveProcessTypeEnumV2.CRM_PROJECT_FOLLOW_UP.getType(), e);
            throw e;
         }

         return Boolean.TRUE;
      }
   }

   private String createOaProjectTracking(
      CrmProjectFollowUpRecord followUpRecord,
      CrmProjectInformationWarehousing project,
      User applicant,
      Integer effectiveRemainingTime,
      List<AttachmentDTO> attachments
   ) {
      Preconditions.checkArgument(applicant.getOaUserId() != null, "申请人未配置OA人员ID");
      Preconditions.checkArgument(applicant.getOaSubDeptId() != null, "申请人未配置OA所属公司ID");
      Preconditions.checkArgument(applicant.getOaDeptId() != null, "申请人未配置OA所属部门ID");
      CrmProjectInformationConfig followUpMethod = followUpRecord.getFollowUpMethods() == null
         ? null
         : this.crmProjectInformationConfigBiz.getById(followUpRecord.getFollowUpMethods());
      String requestTitle = project.getProjectName() + "项目跟踪";
      LocalDate applicationDate = followUpRecord.getFollowUpDate() == null ? LocalDate.now() : followUpRecord.getFollowUpDate().toLocalDate();
      OaProjectTrackingDTOParam oaParam = OaProjectTrackingDTOParam.builder()
         .requestName("CRM项目跟踪流程（初鸣）")
         .title(requestTitle)
         .sqrq(applicationDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
         .sqr(applicant.getOaUserId().toString())
         .bz(followUpRecord.getRemark())
         .sqrszgs(applicant.getOaSubDeptId().toString())
         .sqrszbm(applicant.getOaDeptId().toString())
         .xmmc(project.getProjectName())
         .gjfs(followUpMethod == null ? null : followUpMethod.getName())
         .yxqsyt(effectiveRemainingTime == null ? "0" : effectiveRemainingTime.toString())
         .gjzm(this.buildOaAttachments(attachments))
         .build();
      ZhongNanWorkFlowDTO workflow = this.oaBusinessProcessService.checkPermission(oaParam.getSqr(), oaParam.getRequestName());
      Preconditions.checkArgument(StringUtils.isNotBlank(workflow.getWorkflowId()), "该用户没有提交项目跟踪流程权限");

      List<OaArgumentDTO> mainData;
      try {
         mainData = this.oaBusinessProcessService.resultData(oaParam);
      } catch (IllegalAccessException e) {
         throw new IllegalArgumentException("构建项目跟踪OA请求参数失败", e);
      }

      String response = this.oaBusinessProcessService.doCreateRequest(requestTitle, workflow.getWorkflowId(), oaParam.getSqr(), mainData, null);
      JSONObject responseJson = JSONObject.parseObject(response);
      Preconditions.checkArgument(responseJson != null, "OA项目跟踪接口返回为空");
      Preconditions.checkArgument("SUCCESS".equals(responseJson.getString("code")), responseJson.getString("errMsg"));
      JSONObject data = responseJson.getJSONObject("data");
      Preconditions.checkArgument(data != null && StringUtils.isNotBlank(data.getString("requestid")), "OA项目跟踪未返回requestId");
      return data.getString("requestid");
   }

   private void compensateOaRequest(String requestId, User applicant, Integer approveProcessType, RuntimeException originalException) {
      try {
         ResultVO withdrawResult = this.oaBusinessProcessService
            .withdrawRequest(
               OaRevocationDTOParam.builder()
                  .requestId(requestId)
                  .isremind("0")
                  .remark("CRM本地数据保存失败，系统自动撤回OA流程")
                  .oaUserId(String.valueOf(applicant.getOaUserId()))
                  .approveProcessType(approveProcessType)
                  .build()
            );
         if (withdrawResult == null || !Long.valueOf(20000L).equals(withdrawResult.getCode())) {
            IllegalStateException compensationFailure = new IllegalStateException(withdrawResult == null ? "OA补偿撤回未返回结果" : withdrawResult.getMessage());
            originalException.addSuppressed(compensationFailure);
            log.error("CRM项目跟踪OA补偿撤回失败，requestId={}", requestId, compensationFailure);
         }
      } catch (RuntimeException compensationFailure) {
         originalException.addSuppressed(compensationFailure);
         log.error("CRM项目跟踪OA补偿撤回失败，requestId={}", requestId, compensationFailure);
      }
   }

   private WmsApproveRecord createOaApproveRecord(
      CrmProjectFollowUpRecord followUpRecord, CrmProjectInformationWarehousing project, User applicant, String requestId
   ) {
      ApproveProcessTypeEnumV2 approveType = ApproveProcessTypeEnumV2.CRM_PROJECT_FOLLOW_UP;
      LocalDateTime now = LocalDateTime.now();

      String serialNumber;
      do {
         serialNumber = this.wmsApproveRecordService.createApproveSerialNumber("wms_approve_flow_operation");
      } while (this.wmsApproveRecordService.count(Wrappers.lambdaQuery(WmsApproveRecord.class).eq(WmsApproveRecord::getSerialNumber, serialNumber)) > 0);

      WmsApproveRecord record = WmsApproveRecord.builder()
         .moduleType(approveType.getModuleType())
         .functionType(approveType.getFunctionType())
         .approveProcessType(approveType.getType())
         .dataId(followUpRecord.getId())
         .dataSerialNumber(project.getProjectName())
         .serialNumber(serialNumber)
         .startTime(now)
         .applicantId(applicant.getId())
         .departmentId(applicant.getDepartmentId())
         .status(ApproveRecordStatusEnum.UNDERWAY.getType())
         .reviewStatus(ReviewStatusEnum.AUDITING.getType())
         .lastApproverId(applicant.getId())
         .lastApprovalTime(now)
         .componentName(ComponentNameUtils.getComponentName(approveType.getType(), null))
         .approveSource(ApproveSourceEnum.OA.getType())
         .requestId(requestId)
         .build();
      Preconditions.checkArgument(this.wmsApproveRecordService.save(record), "本地审批主记录保存失败");
      WmsApproveRecordDetail recordDetail = WmsApproveRecordDetail.builder()
         .dataId(followUpRecord.getId())
         .moduleType(approveType.getModuleType())
         .functionType(approveType.getFunctionType())
         .approveProcessType(approveType.getType())
         .approveRecordSerialNumber(serialNumber)
         .flowType(ApproveTemplateVersionsFlowEnum.LAUNCH_APPLICATION.getType())
         .checkUserId(applicant.getId())
         .arrivalTime(now)
         .approveTime(now)
         .decision(CheckStatusEnum.PASS.getType())
         .status(ApproveRecordStatusEnum.UNDERWAY.getType())
         .approveSource(ApproveSourceEnum.OA.getType())
         .requestId(requestId)
         .build();
      Preconditions.checkArgument(this.wmsApproveRecordDetailService.save(recordDetail), "本地审批明细保存失败");
      return record;
   }

   private List<OaAttachmentsDTO> buildOaAttachments(List<AttachmentDTO> attachments) {
      return CollectionUtils.isEmpty(attachments)
         ? new ArrayList<>()
         : attachments.stream()
            .filter(Objects::nonNull)
            .filter(item -> StringUtils.isNotBlank(item.getName()) && StringUtils.isNotBlank(item.getRelativePath()))
            .map(item -> OaAttachmentsDTO.builder().fileName(item.getName()).filePath(item.getRelativePath()).build())
            .collect(Collectors.toList());
   }

   @Override
   public CrmprojectInformationWarehousingFollowUpTimesAndDateDTO getFollowUpTimesAndDate(Long crmProjectInformationWarehousingId) {
      CrmProjectInformationWarehousing projectInformationWarehousing = this.crmProjectInformationWarehousingBiz.getById(crmProjectInformationWarehousingId);
      Preconditions.checkArgument(projectInformationWarehousing != null, "当前项目备案不存在");
      CrmprojectInformationWarehousingFollowUpTimesAndDateDTO build = CrmprojectInformationWarehousingFollowUpTimesAndDateDTO.builder()
         .effectiveRemainingTime(0)
         .followUpTimes(0)
         .build();
      List<CrmProjectFollowUpRecord> crmProjectFollowUpRecords = this.baseService
         .list(
            Wrappers.lambdaQuery(CrmProjectFollowUpRecord.class)
               .eq(CrmProjectFollowUpRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               .eq(CrmProjectFollowUpRecord::getCrmProjectInformationWarehousingId, crmProjectInformationWarehousingId)
               .orderByDesc(CrmProjectFollowUpRecord::getFollowUpDate)
         );
      if (CollectionUtils.isNotEmpty(crmProjectFollowUpRecords) && crmProjectFollowUpRecords.get(0).getFollowUpDate() != null) {
         build = CrmprojectInformationWarehousingFollowUpTimesAndDateDTO.builder()
            .followUpTimes(crmProjectFollowUpRecords.size())
            .lastFollowUpDate(crmProjectFollowUpRecords.get(0).getFollowUpDate().toLocalDate())
            .build();
      }

      if (projectInformationWarehousing.getValidityOfRegistration() != null) {
         LocalDate localDate = LocalDate.now();
         long daysBetween = ChronoUnit.DAYS
            .between(
               localDate,
               projectInformationWarehousing.getUpdateTime().toLocalDate().plusDays(projectInformationWarehousing.getValidityOfRegistration().intValue())
            );
         if (daysBetween <= 0L) {
            daysBetween = 0L;
         }

         build.setEffectiveRemainingTime((int)daysBetween);
      }

      return build;
   }

   @Transactional
   @Override
   public Boolean projectFilingApproval(CrmAuditCommonDTO crmAuditCommonDTO) {
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(crmAuditCommonDTO.getApproveRecordId());
      Preconditions.checkArgument(wmsApproveRecord != null, "项目跟踪审批记录不存在");
      Preconditions.checkArgument(!ApproveSourceEnum.OA.getType().equals(wmsApproveRecord.getApproveSource()), "该单据由OA审批，请在OA中处理");
      Boolean result = this.wmsApproveRecordService
         .commonApproveStep(
            crmAuditCommonDTO.getDataId(), crmAuditCommonDTO.getDecision(), crmAuditCommonDTO.getOpinion(), wmsApproveRecord.getSerialNumber(), null
         );
      CrmProjectFollowUpRecord projectFollowUpRecord = this.baseService.getById(crmAuditCommonDTO.getDataId());
      if (result) {
         if (crmAuditCommonDTO.getDecision() == 2) {
            CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingBiz
               .getById(projectFollowUpRecord.getCrmProjectInformationWarehousingId());
            CrmInformationValidityPeriodConfig crmInformationValidityPeriodConfig = this.crmInformationValidityPeriodConfigBiz
               .getOne(
                  Wrappers.lambdaQuery(CrmInformationValidityPeriodConfig.class)
                     .eq(
                        CrmInformationValidityPeriodConfig::getCrmInformationValidityPeriodConfigEnum,
                        CrmInformationValidityPeriodConfigEnum.INFORMATION_VALIDITY_PERIOD.getType()
                     )
               );
            Preconditions.checkArgument(crmInformationValidityPeriodConfig != null, "项目有效期配置不存在");
            if (crmProjectInformationWarehousing.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.FILING_STATUS.getType())) {
               crmProjectInformationWarehousing.setCrmProjectScheduleTypeEnum(CrmProjectScheduleTypeEnum.FOLLOW_UP_STATUS.getType());
            }

            projectFollowUpRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.PASS.getType());
            crmProjectInformationWarehousing.setValidityOfRegistration(crmInformationValidityPeriodConfig.getValidityOfRegistration());
            this.crmProjectInformationWarehousingBiz.updateById(crmProjectInformationWarehousing);
         }

         if (crmAuditCommonDTO.getDecision() == 4) {
            projectFollowUpRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.FAIL.getType());
         }

         this.baseService.updateById(projectFollowUpRecord);
      }

      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public Boolean projectFollowUpQuash(Long id) {
      CrmProjectFollowUpRecord followUpRecord = this.baseService.getById(id);
      Preconditions.checkArgument(followUpRecord != null, "项目跟进审批不存在");
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(followUpRecord.getApproveRecordId());
      Preconditions.checkArgument(wmsApproveRecord != null, "项目跟进审批记录不存在");
      if (!ApproveSourceEnum.OA.getType().equals(wmsApproveRecord.getApproveSource())) {
         wmsApproveRecord.setReviewStatus(ReviewStatusEnum.CANCEL.getType());
         this.baseService.removeById(followUpRecord.getId());
         this.wmsApproveRecordService.updateById(wmsApproveRecord);
         this.wmsApproveRecordService.revocation(wmsApproveRecord.getId());
         return Boolean.TRUE;
      } else {
         Preconditions.checkArgument(StringUtils.isNotBlank(wmsApproveRecord.getRequestId()), "OA项目跟踪审批缺少requestId");
         User applicant = this.userService.getById(wmsApproveRecord.getApplicantId());
         Preconditions.checkArgument(applicant != null && applicant.getOaUserId() != null, "申请人未配置OA人员ID");
         ResultVO withdrawResult = this.oaBusinessProcessService
            .withdrawRequest(
               OaRevocationDTOParam.builder()
                  .requestId(wmsApproveRecord.getRequestId())
                  .isremind("0")
                  .remark("初鸣系统撤回项目跟踪审批")
                  .oaUserId(applicant.getOaUserId().toString())
                  .approveProcessType(wmsApproveRecord.getApproveProcessType())
                  .build()
            );
         Preconditions.checkArgument(
            withdrawResult != null && Long.valueOf(20000L).equals(withdrawResult.getCode()),
            withdrawResult == null ? "OA项目跟踪撤回失败" : withdrawResult.getMessage()
         );
         this.baseService.removeById(followUpRecord.getId());
         return Boolean.TRUE;
      }
   }

   @Override
   public CrmProjectFollowUpRecordDTO getFollowUpDetail(Long id) {
      CrmProjectFollowUpRecord crmProjectFollowUpRecords = this.baseService.getById(id);
      CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingBiz
         .getById(crmProjectFollowUpRecords.getCrmProjectInformationWarehousingId());
      Preconditions.checkArgument(crmProjectInformationWarehousing != null, "项目备案不存在");
      Map<Long, CrmProjectInformationConfig> informationConfigMap = this.crmProjectInformationConfigBiz
         .list(
            Wrappers.lambdaQuery(CrmProjectInformationConfig.class)
               .eq(CrmProjectInformationConfig::getCrmProjectInformationConfigEnum, CrmProjectInformationConfigEnum.FOLLOW_UP_METHODS.getType())
         )
         .stream()
         .collect(Collectors.toMap(CrmProjectInformationConfig::getId, Function.identity()));
      CrmProjectFollowUpRecordDTO crmProjectFollowUpRecordDTO = new CrmProjectFollowUpRecordDTO();
      BeanUtils.copyProperties(crmProjectFollowUpRecords, crmProjectFollowUpRecordDTO);
      if (crmProjectFollowUpRecords.getFollowUpMethods() != null) {
         CrmProjectInformationConfig crmProjectInformationConfig = informationConfigMap.get(crmProjectFollowUpRecords.getFollowUpMethods());
         crmProjectFollowUpRecordDTO.setFollowUpMethodsName(crmProjectInformationConfig != null ? crmProjectInformationConfig.getName() : null);
      }

      crmProjectFollowUpRecordDTO.setFollowUpAttachment(this.attachmentService.listByIds(crmProjectFollowUpRecords.getFollowUpAttachment()));
      crmProjectFollowUpRecordDTO.setCrmProjectInformationWarehousingName(crmProjectInformationWarehousing.getProjectName());
      if (crmProjectFollowUpRecords.getCreateUserId() != null) {
         crmProjectFollowUpRecordDTO.setCreateUserName(this.userService.getById(crmProjectFollowUpRecords.getCreateUserId()).getName());
      }

      return crmProjectFollowUpRecordDTO;
   }

   @Override
   public List<CrmFollowUpSimpleListDTO> getFollowUpSimpleList(Long projectId) {
      CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingBiz.getById(projectId);
      Preconditions.checkArgument(crmProjectInformationWarehousing != null, "项目备案不存在");
      List<CrmProjectFollowUpRecord> crmProjectFollowUpRecords = this.baseService
         .list(Wrappers.lambdaQuery(CrmProjectFollowUpRecord.class).eq(CrmProjectFollowUpRecord::getCrmProjectInformationWarehousingId, projectId));
      List<CrmFollowUpSimpleListDTO> crmFollowUpSimpleListDTOS = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(crmProjectFollowUpRecords)) {
         crmProjectFollowUpRecords.forEach(item -> {
            CrmFollowUpSimpleListDTO crmFollowUpSimpleListDTO = new CrmFollowUpSimpleListDTO();
            crmFollowUpSimpleListDTO.setId(item.getId());
            crmFollowUpSimpleListDTO.setFollowUpDate(item.getCreateTime());
            crmFollowUpSimpleListDTO.setApproveRecordId(item.getApproveRecordId());
            crmFollowUpSimpleListDTOS.add(crmFollowUpSimpleListDTO);
         });
      }

      return crmFollowUpSimpleListDTOS;
   }
}
