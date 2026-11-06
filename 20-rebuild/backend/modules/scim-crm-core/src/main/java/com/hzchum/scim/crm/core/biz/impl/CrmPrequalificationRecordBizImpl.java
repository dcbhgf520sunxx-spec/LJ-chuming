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
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaProjectPrequalificationDTOParam;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaRevocationDTOParam;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordDetailService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.common.core.api.service.zhongnanoa.OaBusinessProcessService;
import com.hzchum.scim.common.core.api.utils.ComponentNameUtils;
import com.hzchum.scim.crm.core.api.biz.CrmOaConfigBiz;
import com.hzchum.scim.crm.core.api.biz.CrmPrequalificationRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectInformationConfigBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectInformationWarehousingBiz;
import com.hzchum.scim.crm.core.api.enums.CrmCheckStatusEnum;
import com.hzchum.scim.crm.core.api.enums.CrmProjectScheduleTypeEnum;
import com.hzchum.scim.crm.core.api.pojo._do.CrmPrequalificationRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectInformationWarehousing;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmAuditCommonDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmPrequalificationRecordDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmPrequalificationRecordSaveParam;
import com.hzchum.scim.crm.core.api.service.CrmPrequalificationRecordService;
import com.hzchum.scim.crm.core.mapper.CrmPrequalificationRecordMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.UserService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import jodd.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CrmPrequalificationRecordBizImpl
   extends IBizImpl<CrmPrequalificationRecordService, CrmPrequalificationRecordMapper, CrmPrequalificationRecord>
   implements CrmPrequalificationRecordBiz {
   private static final Logger log = LoggerFactory.getLogger(CrmPrequalificationRecordBizImpl.class);
   private static final String OA_PROJECT_PREQUALIFICATION = "项目资格预审";
   private static final String OA_PROJECT_PREQUALIFICATION_WORKFLOW = "CRM项目资格预审流程（初鸣）";
   @Resource
   private CrmProjectInformationWarehousingBiz crmProjectInformationWarehousingBiz;
   @Resource
   private WmsApproveRecordService wmsApproveRecordService;
   @Resource
   private WmsApproveRecordDetailService wmsApproveRecordDetailService;
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
   public Boolean saveCrmPrequalificationRecord(CrmPrequalificationRecordSaveParam copy) {
      CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingBiz
         .getOne(
            Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
               .eq(CrmProjectInformationWarehousing::getId, copy.getCrmProjectInformationWarehousingId())
               .last("FOR UPDATE")
         );
      Preconditions.checkArgument(crmProjectInformationWarehousing != null, "项目备案不存在");
      Preconditions.checkArgument(crmProjectInformationWarehousing.getInformationOperatorUserId().equals(UserUtil.getCurrentUserId()), "您不是该项目的操作人员,不可操作");
      CrmPrequalificationRecord prequalificationRecord1 = this.baseService
         .getOne(
            Wrappers.lambdaQuery(CrmPrequalificationRecord.class)
               .eq(CrmPrequalificationRecord::getCrmProjectInformationWarehousingId, copy.getCrmProjectInformationWarehousingId())
               .eq(CrmPrequalificationRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PENDING.getType())
         );
      Preconditions.checkArgument(prequalificationRecord1 == null, "该项目已处于预审审批中");
      CrmPrequalificationRecord oldPrequalificationRecord = this.baseService
         .getOne(
            Wrappers.lambdaQuery(CrmPrequalificationRecord.class)
               .eq(CrmPrequalificationRecord::getCrmProjectInformationWarehousingId, copy.getCrmProjectInformationWarehousingId())
               .eq(CrmPrequalificationRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
         );
      Preconditions.checkArgument(oldPrequalificationRecord == null, "该项目预审审批已通过");
      Preconditions.checkArgument(crmProjectInformationWarehousing.getCrmCheckStatusEnum().equals(CrmCheckStatusEnum.PASS.getType()), "项目备案审核暂未通过不可进行预审");
      Preconditions.checkArgument(
         !crmProjectInformationWarehousing.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.LAPSE_STATUS.getType()), "项目备案已失效不可进行预审"
      );
      Preconditions.checkArgument(
         !crmProjectInformationWarehousing.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType()), "项目已中标不可进行预审"
      );
      Preconditions.checkArgument(
         !crmProjectInformationWarehousing.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType()),
         "项目处于投标申请状态不可进行预审"
      );
      Preconditions.checkArgument(
         !crmProjectInformationWarehousing.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.PREQUALIFICATION_STATUS.getType()),
         "项目已处于预审状态不可进行预审"
      );
      Preconditions.checkArgument(
         !crmProjectInformationWarehousing.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.LAPSE_STATUS.getType()), "项目处于投标失效状态不可进行预审"
      );
      CrmPrequalificationRecord prequalificationRecord = BeanUtil.copy(copy, CrmPrequalificationRecord.class);
      prequalificationRecord.setCreateUserId(UserUtil.getCurrentUserId());
      prequalificationRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.PENDING.getType());
      if (CollectionUtils.isNotEmpty(copy.getAttachmentIds())) {
         prequalificationRecord.setAttachmentIds(StrUtil.join(",", copy.getAttachmentIds().stream().map(item -> item.getId()).collect(Collectors.toList())));
      }

      this.baseService.save(prequalificationRecord);
      User applicant = this.userService.getById(UserUtil.getCurrentUserId());
      Preconditions.checkArgument(applicant != null, "申请人不存在");
      Integer effectiveRemainingDays = this.calculateEffectiveRemainingDays(crmProjectInformationWarehousing);
      if (Boolean.TRUE.equals(this.crmOaConfigBiz.getOaConfig().getEnabled())) {
         String requestId = this.createOaProjectPrequalification(
            prequalificationRecord, crmProjectInformationWarehousing, applicant, effectiveRemainingDays, copy.getAttachmentIds()
         );

         try {
            WmsApproveRecord record = this.createOaApproveRecord(prequalificationRecord, crmProjectInformationWarehousing, applicant, requestId);
            prequalificationRecord.setApproveRecordId(record.getId());
            Preconditions.checkArgument(this.baseService.updateById(prequalificationRecord), "资格预审回写审批记录失败");
         } catch (RuntimeException e) {
            this.compensateOaRequest(requestId, applicant, ApproveProcessTypeEnumV2.CRM_PRELIMINARY.getType(), e);
            throw e;
         }

         return Boolean.TRUE;
      } else {
         WmsApproveRecord record = this.wmsApproveRecordService
            .createRecord(
               prequalificationRecord.getId(),
               crmProjectInformationWarehousing.getProjectName(),
               ApproveProcessTypeEnumV2.CRM_PRELIMINARY.getType(),
               null,
               null,
               null,
               false,
               null,
               null,
               null
            );
         if (ReviewStatusEnum.REVIEWED.getType().equals(record.getReviewStatus())) {
            if (CrmProjectScheduleTypeEnum.FILING_STATUS.getType().equals(crmProjectInformationWarehousing.getCrmProjectScheduleTypeEnum())
               || CrmProjectScheduleTypeEnum.FOLLOW_UP_STATUS.getType().equals(crmProjectInformationWarehousing.getCrmProjectScheduleTypeEnum())) {
               crmProjectInformationWarehousing.setCrmProjectScheduleTypeEnum(CrmProjectScheduleTypeEnum.PREQUALIFICATION_STATUS.getType());
               this.crmProjectInformationWarehousingBiz.updateById(crmProjectInformationWarehousing);
            }

            prequalificationRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.PASS.getType());
         }

         prequalificationRecord.setApproveRecordId(record.getId());
         Preconditions.checkArgument(this.baseService.updateById(prequalificationRecord), "资格预审回写审批记录失败");
         return Boolean.TRUE;
      }
   }

   private String createOaProjectPrequalification(
      CrmPrequalificationRecord record,
      CrmProjectInformationWarehousing project,
      User applicant,
      Integer effectiveRemainingDays,
      List<AttachmentDTO> attachments
   ) {
      Preconditions.checkArgument(applicant.getOaUserId() != null, "申请人未配置OA人员ID");
      Preconditions.checkArgument(applicant.getOaSubDeptId() != null, "申请人未配置OA所属公司ID");
      Preconditions.checkArgument(applicant.getOaDeptId() != null, "申请人未配置OA所属部门ID");
      String requestTitle = project.getProjectName() + "项目资格预审";
      OaProjectPrequalificationDTOParam oaParam = OaProjectPrequalificationDTOParam.builder()
         .requestName("CRM项目资格预审流程（初鸣）")
         .title(requestTitle)
         .sqrq(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
         .sqr(applicant.getOaUserId().toString())
         .bz(record.getRemark())
         .sqrszgs(applicant.getOaSubDeptId().toString())
         .sqrszbm(applicant.getOaDeptId().toString())
         .xmmc(project.getProjectName())
         .yxqsyt(effectiveRemainingDays.toString())
         .sljzr(record.getDeadlineForAcceptanceTime() == null ? null : record.getDeadlineForAcceptanceTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
         .sldd(record.getAddress())
         .zgystzwj(this.buildOaAttachments(attachments))
         .zgysfy(record.getCost() == null ? null : record.getCost().toPlainString())
         .build();
      ZhongNanWorkFlowDTO workflow = this.oaBusinessProcessService.checkPermission(oaParam.getSqr(), oaParam.getRequestName());
      Preconditions.checkArgument(StringUtils.isNotBlank(workflow.getWorkflowId()), "该用户没有提交项目资格预审流程权限");

      List<OaArgumentDTO> mainData;
      try {
         mainData = this.oaBusinessProcessService.resultData(oaParam);
      } catch (IllegalAccessException e) {
         throw new IllegalArgumentException("构建项目资格预审OA请求参数失败", e);
      }

      String response = this.oaBusinessProcessService.doCreateRequest(requestTitle, workflow.getWorkflowId(), oaParam.getSqr(), mainData, null);
      JSONObject responseJson = JSONObject.parseObject(response);
      Preconditions.checkArgument(responseJson != null, "OA项目资格预审接口返回为空");
      Preconditions.checkArgument("SUCCESS".equals(responseJson.getString("code")), responseJson.getString("errMsg"));
      JSONObject data = responseJson.getJSONObject("data");
      Preconditions.checkArgument(data != null && StringUtils.isNotBlank(data.getString("requestid")), "OA项目资格预审未返回requestId");
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
            log.error("CRM资格预审OA补偿撤回失败，requestId={}", requestId, compensationFailure);
         }
      } catch (RuntimeException compensationFailure) {
         originalException.addSuppressed(compensationFailure);
         log.error("CRM资格预审OA补偿撤回失败，requestId={}", requestId, compensationFailure);
      }
   }

   private WmsApproveRecord createOaApproveRecord(
      CrmPrequalificationRecord prequalificationRecord, CrmProjectInformationWarehousing project, User applicant, String requestId
   ) {
      ApproveProcessTypeEnumV2 approveType = ApproveProcessTypeEnumV2.CRM_PRELIMINARY;
      LocalDateTime now = LocalDateTime.now();

      String serialNumber;
      do {
         serialNumber = this.wmsApproveRecordService.createApproveSerialNumber("wms_approve_flow_operation");
      } while (this.wmsApproveRecordService.count(Wrappers.lambdaQuery(WmsApproveRecord.class).eq(WmsApproveRecord::getSerialNumber, serialNumber)) > 0);

      WmsApproveRecord record = WmsApproveRecord.builder()
         .moduleType(approveType.getModuleType())
         .functionType(approveType.getFunctionType())
         .approveProcessType(approveType.getType())
         .dataId(prequalificationRecord.getId())
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
         .dataId(prequalificationRecord.getId())
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

   private Integer calculateEffectiveRemainingDays(CrmProjectInformationWarehousing project) {
      if (project.getValidityOfRegistration() != null && project.getUpdateTime() != null) {
         long days = ChronoUnit.DAYS.between(LocalDate.now(), project.getUpdateTime().toLocalDate().plusDays(project.getValidityOfRegistration().intValue()));
         return days <= 0L ? 0 : (int)days;
      } else {
         return 0;
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean projectPrequalificationApproval(CrmAuditCommonDTO crmAuditCommonDTO) {
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(crmAuditCommonDTO.getApproveRecordId());
      Preconditions.checkArgument(wmsApproveRecord != null, "项目资格预审审批记录不存在");
      Preconditions.checkArgument(!ApproveSourceEnum.OA.getType().equals(wmsApproveRecord.getApproveSource()), "该单据由OA审批，请在OA中处理");
      Boolean result = this.wmsApproveRecordService
         .commonApproveStep(
            crmAuditCommonDTO.getDataId(), crmAuditCommonDTO.getDecision(), crmAuditCommonDTO.getOpinion(), wmsApproveRecord.getSerialNumber(), null
         );
      CrmPrequalificationRecord crmPrequalificationRecord = this.baseService.getById(crmAuditCommonDTO.getDataId());
      if (result) {
         if (crmAuditCommonDTO.getDecision() == 2) {
            CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingBiz
               .getById(crmPrequalificationRecord.getCrmProjectInformationWarehousingId());
            if (crmProjectInformationWarehousing.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.FILING_STATUS.getType())
               || crmProjectInformationWarehousing.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.FOLLOW_UP_STATUS.getType())) {
               crmProjectInformationWarehousing.setCrmProjectScheduleTypeEnum(CrmProjectScheduleTypeEnum.PREQUALIFICATION_STATUS.getType());
               this.crmProjectInformationWarehousingBiz.updateById(crmProjectInformationWarehousing);
            }

            crmPrequalificationRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.PASS.getType());
         }

         if (crmAuditCommonDTO.getDecision() == 4) {
            crmPrequalificationRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.FAIL.getType());
         }

         this.baseService.updateById(crmPrequalificationRecord);
      }

      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public Boolean projectPrequalificationQuash(Long id) {
      CrmPrequalificationRecord prequalificationRecord = this.baseService.getById(id);
      Preconditions.checkArgument(prequalificationRecord != null, "项目预审审批不存在");
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(prequalificationRecord.getApproveRecordId());
      Preconditions.checkArgument(wmsApproveRecord != null, "项目预审审批不存在");
      if (!ApproveSourceEnum.OA.getType().equals(wmsApproveRecord.getApproveSource())) {
         wmsApproveRecord.setReviewStatus(ReviewStatusEnum.CANCEL.getType());
         this.baseService.removeById(prequalificationRecord.getId());
         this.wmsApproveRecordService.updateById(wmsApproveRecord);
         this.wmsApproveRecordService.revocation(wmsApproveRecord.getId());
         return Boolean.TRUE;
      } else {
         Preconditions.checkArgument(StringUtils.isNotBlank(wmsApproveRecord.getRequestId()), "OA项目资格预审审批缺少requestId");
         User applicant = this.userService.getById(wmsApproveRecord.getApplicantId());
         Preconditions.checkArgument(applicant != null && applicant.getOaUserId() != null, "申请人未配置OA人员ID");
         ResultVO withdrawResult = this.oaBusinessProcessService
            .withdrawRequest(
               OaRevocationDTOParam.builder()
                  .requestId(wmsApproveRecord.getRequestId())
                  .isremind("0")
                  .remark("初鸣系统撤回项目资格预审审批")
                  .oaUserId(applicant.getOaUserId().toString())
                  .approveProcessType(wmsApproveRecord.getApproveProcessType())
                  .build()
            );
         Preconditions.checkArgument(
            withdrawResult != null && Long.valueOf(20000L).equals(withdrawResult.getCode()),
            withdrawResult == null ? "OA项目资格预审撤回失败" : withdrawResult.getMessage()
         );
         this.baseService.removeById(prequalificationRecord.getId());
         return Boolean.TRUE;
      }
   }

   @Override
   public CrmPrequalificationRecordDetailDTO getCrmProjectPrequalificationDetail(Long id) {
      CrmPrequalificationRecord prequalificationRecord = this.baseService.getById(id);
      Preconditions.checkArgument(prequalificationRecord != null, "项目预审记录不存在");
      CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingBiz
         .getById(prequalificationRecord.getCrmProjectInformationWarehousingId());
      Preconditions.checkArgument(crmProjectInformationWarehousing != null, "项目备案不存在");
      CrmPrequalificationRecordDetailDTO recordDetailDTO = BeanUtil.copy(prequalificationRecord, CrmPrequalificationRecordDetailDTO.class);
      recordDetailDTO.setCreateUserName(this.userService.getById(prequalificationRecord.getCreateUserId()).getName());
      if (StringUtil.isNotBlank(prequalificationRecord.getAttachmentIds())) {
         recordDetailDTO.setAttachmentList(this.attachmentService.listByIds(prequalificationRecord.getAttachmentIds()));
      }

      recordDetailDTO.setCrmProjectInformationWarehousingName(crmProjectInformationWarehousing.getProjectName());
      return recordDetailDTO;
   }

   @Override
   public CrmPrequalificationRecordDetailDTO getCrmProjectPrequalificationDetailByProjectId(Long id) {
      CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingBiz.getById(id);
      Preconditions.checkArgument(crmProjectInformationWarehousing != null, "项目备案不存在");
      CrmPrequalificationRecord prequalificationRecord = this.baseService
         .getOne(
            Wrappers.lambdaQuery(CrmPrequalificationRecord.class)
               .eq(CrmPrequalificationRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               .eq(CrmPrequalificationRecord::getCrmProjectInformationWarehousingId, id)
         );
      Preconditions.checkArgument(prequalificationRecord != null, "项目预审记录不存在");
      CrmPrequalificationRecordDetailDTO recordDetailDTO = BeanUtil.copy(prequalificationRecord, CrmPrequalificationRecordDetailDTO.class);
      recordDetailDTO.setCreateUserName(this.userService.getById(prequalificationRecord.getCreateUserId()).getName());
      if (StringUtil.isNotBlank(prequalificationRecord.getAttachmentIds())) {
         recordDetailDTO.setAttachmentList(this.attachmentService.listByIds(prequalificationRecord.getAttachmentIds()));
      }

      recordDetailDTO.setCrmProjectInformationWarehousingName(crmProjectInformationWarehousing.getProjectName());
      return recordDetailDTO;
   }
}
