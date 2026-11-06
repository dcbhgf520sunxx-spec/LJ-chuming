package com.hzchum.scim.crm.core.biz.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
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
import com.hzchum.scim.common.core.api.pojo.dto.MountMessageDTO;
import com.hzchum.scim.common.core.api.pojo.dto.oa.ZhongNanWorkFlowDTO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaArgumentDTO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaAttachmentsDTO;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaProjectBidApplicationDTOParam;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaRevocationDTOParam;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordDetailService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.common.core.api.service.zhongnanoa.OaBusinessProcessService;
import com.hzchum.scim.common.core.api.utils.ComponentNameUtils;
import com.hzchum.scim.crm.core.api.biz.CrmApplyBusinessBiddingRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmApplyDeepDesignBiddingRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmApplyForBidRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmApplyStructuralDesignBiddingRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmApplyTechnologyBiddingRecordBiz;
import com.hzchum.scim.crm.core.api.biz.CrmEnterpriseWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmOaConfigBiz;
import com.hzchum.scim.crm.core.api.biz.CrmProjectInformationWarehousingBiz;
import com.hzchum.scim.crm.core.api.biz.CrmTenderRequestConfigBiz;
import com.hzchum.scim.crm.core.api.enums.CrmBiddingRegulationsTypeEnum;
import com.hzchum.scim.crm.core.api.enums.CrmCheckStatusEnum;
import com.hzchum.scim.crm.core.api.enums.CrmProjectScheduleTypeEnum;
import com.hzchum.scim.crm.core.api.enums.CrmSettlementBusinessTypeEnum;
import com.hzchum.scim.crm.core.api.enums.CrmSpecialBubmissionStatusEnum;
import com.hzchum.scim.crm.core.api.enums.CrmTenderApprovalFlowsTypeEnum;
import com.hzchum.scim.crm.core.api.enums.CrmTenderRequirementTypeEnum;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyBusinessBiddingRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyDeepDesignBiddingRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyForBidRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyStructuralDesignBiddingRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyTechnologyBiddingRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmEnterpriseWarehousing;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectInformationWarehousing;
import com.hzchum.scim.crm.core.api.pojo._do.CrmTenderRequestConfig;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmApplyForBidRecordDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmApplyForBidRecordDetailDTOV2;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmAuditCommonDTO;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmApplyForBidRecordSaveParam;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmApplyForBidRecordSaveParamV2;
import com.hzchum.scim.crm.core.api.service.CrmApplyForBidRecordService;
import com.hzchum.scim.crm.core.api.service.CrmProjectInformationWarehousingService;
import com.hzchum.scim.crm.core.mapper.CrmApplyBusinessBiddingRecordMapper;
import com.hzchum.scim.crm.core.mapper.CrmApplyDeepDesignBiddingRecordMapper;
import com.hzchum.scim.crm.core.mapper.CrmApplyForBidRecordMapper;
import com.hzchum.scim.crm.core.mapper.CrmApplyStructuralDesignBiddingRecordMapper;
import com.hzchum.scim.crm.core.mapper.CrmApplyTechnologyBiddingRecordMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CrmApplyForBidRecordBizImpl
   extends IBizImpl<CrmApplyForBidRecordService, CrmApplyForBidRecordMapper, CrmApplyForBidRecord>
   implements CrmApplyForBidRecordBiz {
   private static final Logger log = LoggerFactory.getLogger(CrmApplyForBidRecordBizImpl.class);
   private static final String OA_PROJECT_BID_APPLICATION = "项目投标申请";
   private static final String OA_PROJECT_BID_APPLICATION_WORKFLOW = "CRM项目投标申请流程（初鸣）";
   @Resource
   private UserService userService;
   @Resource
   private CrmProjectInformationWarehousingService crmProjectInformationWarehousingService;
   @Resource
   private WmsApproveRecordService wmsApproveRecordService;
   @Resource
   private WmsApproveRecordDetailService wmsApproveRecordDetailService;
   @Resource
   private OaBusinessProcessService oaBusinessProcessService;
   @Resource
   private CrmEnterpriseWarehousingBiz crmEnterpriseWarehousingBiz;
   @Resource
   private CrmTenderRequestConfigBiz crmTenderRequestConfigBiz;
   @Resource
   private DepartmentService departmentService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private CrmApplyStructuralDesignBiddingRecordBiz crmApplyStructuralDesignBiddingRecordBiz;
   @Resource
   private CrmApplyBusinessBiddingRecordBiz crmApplyBusinessBiddingRecordBiz;
   @Resource
   private CrmApplyDeepDesignBiddingRecordBiz crmApplyDeepDesignBiddingRecordBiz;
   @Resource
   private CrmApplyTechnologyBiddingRecordBiz crmApplyTechnologyBiddingRecordBiz;
   @Resource
   private CrmProjectInformationWarehousingBiz crmProjectInformationWarehousingBiz;
   @Resource
   private CrmOaConfigBiz crmOaConfigBiz;
   @Resource
   private CrmApplyStructuralDesignBiddingRecordMapper crmApplyStructuralDesignBiddingRecordMapper;
   @Resource
   private CrmApplyBusinessBiddingRecordMapper crmApplyBusinessBiddingRecordMapper;
   @Resource
   private CrmApplyDeepDesignBiddingRecordMapper crmApplyDeepDesignBiddingRecordMapper;
   @Resource
   private CrmApplyTechnologyBiddingRecordMapper crmApplyTechnologyBiddingRecordMapper;

   @Transactional
   @Override
   public Boolean saveCrmApplyForBidRecord(CrmApplyForBidRecordSaveParam param) {
      CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingService
         .getById(param.getCrmProjectInformationWarehousingId());
      Preconditions.checkArgument(crmProjectInformationWarehousing != null, "项目备案不存在");
      Preconditions.checkArgument(crmProjectInformationWarehousing.getInformationOperatorUserId().equals(UserUtil.getCurrentUserId()), "您不是该项目的操作人员,不可操作");
      Preconditions.checkArgument(crmProjectInformationWarehousing.getCrmCheckStatusEnum().equals(CrmCheckStatusEnum.PASS.getType()), "项目备案审核暂未通过不可进行预审");
      Preconditions.checkArgument(
         !crmProjectInformationWarehousing.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.LAPSE_STATUS.getType()), "项目备案已失效不可进行预审"
      );
      Preconditions.checkArgument(
         !crmProjectInformationWarehousing.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType()), "项目已中标不可进行预审"
      );
      CrmApplyForBidRecord applyForBidRecord = this.baseService
         .getOne(
            Wrappers.lambdaQuery(CrmApplyForBidRecord.class)
               .eq(CrmApplyForBidRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               .eq(CrmApplyForBidRecord::getCrmProjectInformationWarehousingId, param.getCrmProjectInformationWarehousingId())
         );
      Preconditions.checkArgument(applyForBidRecord == null, "该项目的投标申请已存在");
      CrmApplyForBidRecord crmApplyForBidRecord = BeanUtil.copy(param, CrmApplyForBidRecord.class);
      crmApplyForBidRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.PENDING.getType());
      crmApplyForBidRecord.setInformantUserName(
         crmApplyForBidRecord.getInformantUserId() != null ? this.userService.getById(crmApplyForBidRecord.getInformantUserId()).getName() : null
      );
      List<Integer> crmTenderApprovalFlowsType = new ArrayList<>();
      Integer[] number = new Integer[]{Math.toIntExact(0L)};
      param.getTenderRequirement().forEach(item -> {
         if (item.equals(CrmTenderRequirementTypeEnum.BIDDING_METHOD.getType())) {
            crmProjectInformationWarehousing.setIsBiddingMethod(Boolean.TRUE);
            number[0] = number[0] + CrmTenderApprovalFlowsTypeEnum.BIDDING_METHOD.getType();
         }

         if (item.equals(CrmTenderRequirementTypeEnum.TYPE_OF_PERFORMANCE_BOND.getType())) {
            crmProjectInformationWarehousing.setIsTypeOfPerformanceBond(Boolean.TRUE);
            number[0] = number[0] + CrmTenderApprovalFlowsTypeEnum.TYPE_OF_PERFORMANCE_BOND.getType();
         }

         if (item.equals(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType())) {
            crmProjectInformationWarehousing.setIsSettlementMethod(Boolean.TRUE);
            number[0] = number[0] + CrmTenderApprovalFlowsTypeEnum.SETTLEMENT_METHOD.getType();
         }
      });
      Integer integer = number[0];
      MountMessageDTO mountMessageDTO = new MountMessageDTO();
      if (integer != null && integer != 0) {
         crmTenderApprovalFlowsType.add(integer);
         mountMessageDTO.setCrmTenderApprovalFlowsType(crmTenderApprovalFlowsType);
      }

      this.crmProjectInformationWarehousingService.updateById(crmProjectInformationWarehousing);
      crmApplyForBidRecord.setCreateUserId(UserUtil.getCurrentUserId());
      if (CollectionUtils.isNotEmpty(param.getAttachmentIds())) {
         crmApplyForBidRecord.setAttachmentIds(StringUtils.join(param.getAttachmentIds().stream().map(AttachmentDTO::getId).collect(Collectors.toList()), ","));
      }

      this.baseService.save(crmApplyForBidRecord);
      WmsApproveRecord record = this.wmsApproveRecordService
         .createRecord(
            crmApplyForBidRecord.getId(),
            crmProjectInformationWarehousing.getProjectName(),
            ApproveProcessTypeEnumV2.CRM_TENDER.getType(),
            null,
            null,
            null,
            false,
            mountMessageDTO,
            null,
            null
         );
      CrmApplyForBidRecord forBidRecord = this.baseService.getById(crmApplyForBidRecord.getId());
      forBidRecord.setApproveRecordId(record.getId());
      if (record.getReviewStatus().equals(ReviewStatusEnum.REVIEWED.getType())) {
         crmProjectInformationWarehousing.setCrmProjectScheduleTypeEnum(CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType());
         forBidRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.PASS.getType());
         this.crmProjectInformationWarehousingService.updateById(crmProjectInformationWarehousing);
      }

      this.baseService.updateById(forBidRecord);
      return Boolean.TRUE;
   }

   private String createOaProjectBidApplication(
      CrmApplyForBidRecordSaveParamV2 param,
      CrmProjectInformationWarehousing project,
      User applicant,
      List<AttachmentDTO> attachments,
      List<Integer> tenderRequirements
   ) {
      Preconditions.checkArgument(applicant.getOaUserId() != null, "申请人未配置OA人员ID");
      Preconditions.checkArgument(applicant.getOaSubDeptId() != null, "申请人未配置OA所属公司ID");
      Preconditions.checkArgument(applicant.getOaDeptId() != null, "申请人未配置OA所属部门ID");
      String requestTitle = project.getProjectName() + "项目投标申请";
      LocalDate applicationDate = param.getInformantDateTime() == null ? LocalDate.now() : param.getInformantDateTime().toLocalDate();
      OaProjectBidApplicationDTOParam oaParam = OaProjectBidApplicationDTOParam.builder()
         .requestName("CRM项目投标申请流程（初鸣）")
         .title(requestTitle)
         .zbdw(param.getCompanyName())
         .sqrq(applicationDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
         .sqr(applicant.getOaUserId().toString())
         .fj(this.buildOaAttachments(attachments))
         .bz(param.getRemark())
         .sqrszgs(applicant.getOaSubDeptId().toString())
         .sqrszbm(applicant.getOaDeptId().toString())
         .xmmc(project.getProjectName())
         .zbfs(this.getTenderConfigName(param.getBiddingMethodId()))
         .zbgd(CrmBiddingRegulationsTypeEnum.getNameByType(param.getCrmBiddingRegulationsTypeEnum()))
         .bstjfs(this.getTenderConfigName(param.getTenderSubmissionMethodId()))
         .tbjzr(this.formatDateTime(param.getBidExpirationDate()))
         .kbsj(this.formatDateTime(param.getBidOpeningDate()))
         .pbfs(this.getTenderConfigName(param.getBidEvaluationMethodId()))
         .zbkzjwy(this.toPlainString(param.getControlledBiddingPrice()))
         .tbbzjewy(this.toPlainString(param.getTenderBond()))
         .tbbzjjzr(this.formatDateTime(param.getTenderBondDeadline()))
         .cldc(param.getMaterialAdjustment())
         .fkfs(param.getPaymentMethod())
         .bsxq(this.buildTenderRequirements(tenderRequirements))
         .build();
      ZhongNanWorkFlowDTO workflow = this.oaBusinessProcessService.checkPermission(oaParam.getSqr(), oaParam.getRequestName());
      Preconditions.checkArgument(StringUtils.isNotBlank(workflow.getWorkflowId()), "该用户没有提交项目投标申请流程权限");

      List<OaArgumentDTO> mainData;
      try {
         mainData = this.oaBusinessProcessService.resultData(oaParam);
      } catch (IllegalAccessException e) {
         throw new IllegalArgumentException("构建项目投标申请OA请求参数失败", e);
      }

      String response = this.oaBusinessProcessService.doCreateRequest(requestTitle, workflow.getWorkflowId(), oaParam.getSqr(), mainData, null);
      JSONObject responseJson = JSONObject.parseObject(response);
      Preconditions.checkArgument(responseJson != null, "OA项目投标申请接口返回为空");
      Preconditions.checkArgument("SUCCESS".equals(responseJson.getString("code")), responseJson.getString("errMsg"));
      JSONObject data = responseJson.getJSONObject("data");
      Preconditions.checkArgument(data != null && StringUtils.isNotBlank(data.getString("requestid")), "OA项目投标申请未返回requestId");
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
            log.error("CRM投标申请OA补偿撤回失败，requestId={}", requestId, compensationFailure);
         }
      } catch (RuntimeException compensationFailure) {
         originalException.addSuppressed(compensationFailure);
         log.error("CRM投标申请OA补偿撤回失败，requestId={}", requestId, compensationFailure);
      }
   }

   private WmsApproveRecord createOaApproveRecord(
      Long dataId, CrmProjectInformationWarehousing project, User applicant, String requestId, ApproveProcessTypeEnumV2 approveType
   ) {
      LocalDateTime now = LocalDateTime.now();

      String serialNumber;
      do {
         serialNumber = this.wmsApproveRecordService.createApproveSerialNumber("wms_approve_flow_operation");
      } while (this.wmsApproveRecordService.count(Wrappers.lambdaQuery(WmsApproveRecord.class).eq(WmsApproveRecord::getSerialNumber, serialNumber)) > 0);

      WmsApproveRecord record = WmsApproveRecord.builder()
         .moduleType(approveType.getModuleType())
         .functionType(approveType.getFunctionType())
         .approveProcessType(approveType.getType())
         .dataId(dataId)
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
         .dataId(dataId)
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

   private String getTenderConfigName(Long configId) {
      if (configId == null) {
         return null;
      }

      CrmTenderRequestConfig config = this.crmTenderRequestConfigBiz.getById(configId);
      return config == null ? null : config.getName();
   }

   private String buildTenderRequirements(List<Integer> tenderRequirements) {
      return CollectionUtils.isEmpty(tenderRequirements)
         ? null
         : tenderRequirements.stream().map(CrmTenderRequirementTypeEnum::getNameByType).filter(StringUtils::isNotBlank).collect(Collectors.joining("/"));
   }

   private String toPlainString(BigDecimal value) {
      return value == null ? null : value.stripTrailingZeros().toPlainString();
   }

   private String formatDateTime(LocalDateTime value) {
      return value == null ? null : value.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
   }

   @Transactional
   @Override
   public Boolean deleteCrmApplyForBidRecord(Long id) {
      CrmApplyForBidRecord crmApplyForBidRecord = this.baseService.getById(id);
      Preconditions.checkArgument(crmApplyForBidRecord != null, "投标申请信息不存在");
      Preconditions.checkArgument(crmApplyForBidRecord.getCrmCheckStatusEnum().equals(CrmCheckStatusEnum.TEMPORARY_STORAGE.getType()), "投标申请已申请审核不可删除");
      this.baseService.removeById(id);
      return Boolean.TRUE;
   }

   @Override
   public CrmApplyForBidRecordDetailDTO crmApplyForBidRecordDetailByProjectId(Long id) {
      CrmProjectInformationWarehousing projectInformationWarehousing = this.crmProjectInformationWarehousingService.getById(id);
      Preconditions.checkArgument(projectInformationWarehousing != null, "项目备案不存在");
      CrmApplyForBidRecord crmApplyForBidRecord = this.baseService
         .getOne(
            Wrappers.lambdaQuery(CrmApplyForBidRecord.class)
               .eq(CrmApplyForBidRecord::getCrmProjectInformationWarehousingId, id)
               .eq(CrmApplyForBidRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
         );
      Preconditions.checkArgument(crmApplyForBidRecord != null, "投标申请不存在");
      CrmEnterpriseWarehousing crmEnterpriseWarehousing = null;
      if (projectInformationWarehousing.getCrmEnterpriseWarehousingId() != null) {
         crmEnterpriseWarehousing = this.crmEnterpriseWarehousingBiz.getById(projectInformationWarehousing.getCrmEnterpriseWarehousingId());
      }

      CrmApplyForBidRecordDetailDTO crmApplyForBidRecordDetailDTO = BeanUtil.copy(crmApplyForBidRecord, CrmApplyForBidRecordDetailDTO.class);
      crmApplyForBidRecordDetailDTO.setBiddingPlatformName(crmApplyForBidRecord.getCompanyName());
      if (crmEnterpriseWarehousing != null) {
         crmApplyForBidRecordDetailDTO.setCrmEnterpriseWarehousingName(crmEnterpriseWarehousing.getBusinessName());
      }

      crmApplyForBidRecordDetailDTO.setProjectName(projectInformationWarehousing.getProjectName());
      crmApplyForBidRecordDetailDTO.setProjectSerialNumber(projectInformationWarehousing.getSerialNumber());
      crmApplyForBidRecordDetailDTO.setCreateUserName(this.userService.getById(crmApplyForBidRecord.getCreateUserId()).getName());
      if (crmApplyForBidRecord.getInformantUserId() != null) {
         crmApplyForBidRecordDetailDTO.setInformantUserName(this.userService.getById(crmApplyForBidRecord.getInformantUserId()).getName());
      }

      if (crmApplyForBidRecord.getDepartmentId() != null) {
         crmApplyForBidRecordDetailDTO.setDepartmentName(this.departmentService.getDepartmentById(crmApplyForBidRecord.getDepartmentId()).getName());
      }

      crmApplyForBidRecordDetailDTO.setProjectName(projectInformationWarehousing.getProjectName());
      crmApplyForBidRecordDetailDTO.setProjectSerialNumber(projectInformationWarehousing.getSerialNumber());
      if (crmApplyForBidRecord.getBiddingMethodId() != null) {
         crmApplyForBidRecordDetailDTO.setBiddingMethodName(this.crmTenderRequestConfigBiz.getById(crmApplyForBidRecord.getBiddingMethodId()).getName());
      }

      if (crmApplyForBidRecord.getTenderSubmissionMethodId() != null) {
         crmApplyForBidRecordDetailDTO.setTenderSubmissionMethodName(
            this.crmTenderRequestConfigBiz.getById(crmApplyForBidRecord.getTenderSubmissionMethodId()).getName()
         );
      }

      if (crmApplyForBidRecord.getBidEvaluationMethodId() != null) {
         crmApplyForBidRecordDetailDTO.setBidEvaluationMethodName(
            this.crmTenderRequestConfigBiz.getById(crmApplyForBidRecord.getBidEvaluationMethodId()).getName()
         );
      }

      if (crmApplyForBidRecord.getBidEvaluationMethodId() != null) {
         crmApplyForBidRecordDetailDTO.setSettlementMethodName(
            this.crmTenderRequestConfigBiz.getById(crmApplyForBidRecord.getBidEvaluationMethodId()).getName()
         );
      }

      if (crmApplyForBidRecord.getTypeOfPerformanceBondId() != null) {
         crmApplyForBidRecordDetailDTO.setTypeOfPerformanceBondName(
            this.crmTenderRequestConfigBiz.getById(crmApplyForBidRecord.getTypeOfPerformanceBondId()).getName()
         );
      }

      String crmTenderRequirementTypeEnum = this.appendTenderRequirement(projectInformationWarehousing);
      crmApplyForBidRecordDetailDTO.setTenderRequirement(crmTenderRequirementTypeEnum);
      if (com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank(crmApplyForBidRecord.getAttachmentIds())) {
         crmApplyForBidRecordDetailDTO.setAttachmentDTOList(this.attachmentService.listByIds(crmApplyForBidRecord.getAttachmentIds()));
      }

      return crmApplyForBidRecordDetailDTO;
   }

   @Transactional
   @Override
   public Boolean saveCrmApplyForBidRecordCustom(CrmApplyForBidRecordSaveParamV2 paramV2) {
      CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingService
         .getOne(
            Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
               .eq(CrmProjectInformationWarehousing::getId, paramV2.getCrmProjectInformationWarehousingId())
               .last("FOR UPDATE")
         );
      Preconditions.checkArgument(crmProjectInformationWarehousing != null, "项目备案不存在");
      Preconditions.checkArgument(crmProjectInformationWarehousing.getInformationOperatorUserId().equals(UserUtil.getCurrentUserId()), "您不是该项目的操作人员,不可操作");
      Preconditions.checkArgument(crmProjectInformationWarehousing.getCrmCheckStatusEnum().equals(CrmCheckStatusEnum.PASS.getType()), "项目备案审核暂未通过不可进行预审");
      Preconditions.checkArgument(
         !crmProjectInformationWarehousing.getCrmProjectScheduleTypeEnum().equals(CrmProjectScheduleTypeEnum.LAPSE_STATUS.getType()), "项目备案已失效不可进行申请"
      );
      List<Integer> tenderRequirement = paramV2.getTenderRequirement();
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(tenderRequirement), "请至少选择一种标书需求");
      User applicant = this.userService.getById(UserUtil.getCurrentUserId());
      Preconditions.checkArgument(applicant != null, "申请人不存在");
      List<CrmApplyForBidRecordBizImpl.CustomOaRequest> createdOaRequests = new ArrayList<>();

      try {
         tenderRequirement.forEach(
            item -> {
               if (item.equals(CrmTenderRequirementTypeEnum.BIDDING_METHOD.getType())) {
                  List<CrmApplyBusinessBiddingRecord> crmApplyBusinessBiddingRecords = this.crmApplyBusinessBiddingRecordBiz
                     .list(
                        Wrappers.lambdaQuery(CrmApplyBusinessBiddingRecord.class)
                           .eq(CrmApplyBusinessBiddingRecord::getCrmProjectInformationWarehousingId, crmProjectInformationWarehousing.getId())
                     );
                  crmApplyBusinessBiddingRecords.forEach(
                     crmApplyBusinessBiddingRecord -> {
                        Preconditions.checkArgument(
                           !crmApplyBusinessBiddingRecord.getCrmCheckStatusEnum().equals(CrmCheckStatusEnum.PASS.getType()), "该项目商务标已审核通过,不可进行申请"
                        );
                        Preconditions.checkArgument(
                           !crmApplyBusinessBiddingRecord.getCrmCheckStatusEnum().equals(CrmCheckStatusEnum.PENDING.getType()), "该项目商务标正在审核中,不可进行申请"
                        );
                     }
                  );
                  CrmApplyBusinessBiddingRecord crmApplyBusinessBiddingRecord = BeanUtil.copy(paramV2, CrmApplyBusinessBiddingRecord.class);
                  crmApplyBusinessBiddingRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.PENDING.getType());
                  crmApplyBusinessBiddingRecord.setInformantUserName(
                     crmApplyBusinessBiddingRecord.getInformantUserId() != null
                        ? this.userService.getById(crmApplyBusinessBiddingRecord.getInformantUserId()).getName()
                        : null
                  );
                  crmApplyBusinessBiddingRecord.setCreateUserId(UserUtil.getCurrentUserId());
                  if (CollectionUtils.isNotEmpty(paramV2.getAttachmentIds())) {
                     crmApplyBusinessBiddingRecord.setAttachmentIds(
                        StringUtils.join(paramV2.getAttachmentIds().stream().map(AttachmentDTO::getId).collect(Collectors.toList()), ",")
                     );
                  }

                  this.crmApplyBusinessBiddingRecordBiz.save(crmApplyBusinessBiddingRecord);
                  this.createCustomOaApproval(
                     crmApplyBusinessBiddingRecord.getId(),
                     ApproveProcessTypeEnumV2.CRM_BUSINESS_BIDDING,
                     paramV2,
                     crmProjectInformationWarehousing,
                     applicant,
                     item,
                     createdOaRequests,
                     record -> {
                        crmApplyBusinessBiddingRecord.setApproveRecordId(record.getId());
                        Preconditions.checkArgument(this.crmApplyBusinessBiddingRecordBiz.updateById(crmApplyBusinessBiddingRecord), "商务标回写审批记录失败");
                     }
                  );
               }

               if (item.equals(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType())) {
                  List<CrmApplyTechnologyBiddingRecord> crmApplyTechnologyBiddingRecords = this.crmApplyTechnologyBiddingRecordBiz
                     .list(
                        Wrappers.lambdaQuery(CrmApplyTechnologyBiddingRecord.class)
                           .eq(CrmApplyTechnologyBiddingRecord::getCrmProjectInformationWarehousingId, crmProjectInformationWarehousing.getId())
                     );
                  crmApplyTechnologyBiddingRecords.forEach(
                     crmApplyTechnologyBiddingRecord -> {
                        Preconditions.checkArgument(
                           !crmApplyTechnologyBiddingRecord.getCrmCheckStatusEnum().equals(CrmCheckStatusEnum.PASS.getType()), "该项目技术标已审核通过,不可进行申请"
                        );
                        Preconditions.checkArgument(
                           !crmApplyTechnologyBiddingRecord.getCrmCheckStatusEnum().equals(CrmCheckStatusEnum.PENDING.getType()), "该项目技术标正在审核中,不可进行申请"
                        );
                     }
                  );
                  CrmApplyTechnologyBiddingRecord crmApplyTechnologyBiddingRecord = BeanUtil.copy(paramV2, CrmApplyTechnologyBiddingRecord.class);
                  crmApplyTechnologyBiddingRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.PENDING.getType());
                  crmApplyTechnologyBiddingRecord.setCrmSettlementBusinessTypeEnum(CrmSettlementBusinessTypeEnum.DIRECT_SALE.getType());
                  crmApplyTechnologyBiddingRecord.setCrmSpecialBubmissionStatusEnum(CrmSpecialBubmissionStatusEnum.BID_ALLOCATION.getType());
                  crmApplyTechnologyBiddingRecord.setInformantUserName(
                     crmApplyTechnologyBiddingRecord.getInformantUserId() != null
                        ? this.userService.getById(crmApplyTechnologyBiddingRecord.getInformantUserId()).getName()
                        : null
                  );
                  crmApplyTechnologyBiddingRecord.setCreateUserId(UserUtil.getCurrentUserId());
                  if (CollectionUtils.isNotEmpty(paramV2.getAttachmentIds())) {
                     crmApplyTechnologyBiddingRecord.setAttachmentIds(
                        StringUtils.join(paramV2.getAttachmentIds().stream().map(AttachmentDTO::getId).collect(Collectors.toList()), ",")
                     );
                  }

                  this.crmApplyTechnologyBiddingRecordBiz.save(crmApplyTechnologyBiddingRecord);
                  this.createCustomOaApproval(
                     crmApplyTechnologyBiddingRecord.getId(),
                     ApproveProcessTypeEnumV2.CRM_TECHNOLOGY_BIDDING,
                     paramV2,
                     crmProjectInformationWarehousing,
                     applicant,
                     item,
                     createdOaRequests,
                     record -> {
                        crmApplyTechnologyBiddingRecord.setApproveRecordId(record.getId());
                        Preconditions.checkArgument(this.crmApplyTechnologyBiddingRecordBiz.updateById(crmApplyTechnologyBiddingRecord), "技术标回写审批记录失败");
                     }
                  );
               }

               if (item.equals(CrmTenderRequirementTypeEnum.STRUCTURAL_DESIGN_TARGET.getType())) {
                  List<CrmApplyStructuralDesignBiddingRecord> crmApplyStructuralDesignBiddingRecords = this.crmApplyStructuralDesignBiddingRecordBiz
                     .list(
                        Wrappers.lambdaQuery(CrmApplyStructuralDesignBiddingRecord.class)
                           .eq(CrmApplyStructuralDesignBiddingRecord::getCrmProjectInformationWarehousingId, crmProjectInformationWarehousing.getId())
                     );
                  crmApplyStructuralDesignBiddingRecords.forEach(
                     crmApplyStructuralDesignBiddingRecordx -> {
                        Preconditions.checkArgument(
                           !crmApplyStructuralDesignBiddingRecordx.getCrmCheckStatusEnum().equals(CrmCheckStatusEnum.PASS.getType()), "该项目结构设计标已审核通过,不可进行申请"
                        );
                        Preconditions.checkArgument(
                           !crmApplyStructuralDesignBiddingRecordx.getCrmCheckStatusEnum().equals(CrmCheckStatusEnum.PENDING.getType()), "该项目结构设计标正在审核中,不可进行申请"
                        );
                     }
                  );
                  CrmApplyStructuralDesignBiddingRecord crmApplyStructuralDesignBiddingRecord = BeanUtil.copy(
                     paramV2, CrmApplyStructuralDesignBiddingRecord.class
                  );
                  crmApplyStructuralDesignBiddingRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.PENDING.getType());
                  crmApplyStructuralDesignBiddingRecord.setInformantUserName(
                     crmApplyStructuralDesignBiddingRecord.getInformantUserId() != null
                        ? this.userService.getById(crmApplyStructuralDesignBiddingRecord.getInformantUserId()).getName()
                        : null
                  );
                  crmApplyStructuralDesignBiddingRecord.setCreateUserId(UserUtil.getCurrentUserId());
                  if (CollectionUtils.isNotEmpty(paramV2.getAttachmentIds())) {
                     crmApplyStructuralDesignBiddingRecord.setAttachmentIds(
                        StringUtils.join(paramV2.getAttachmentIds().stream().map(AttachmentDTO::getId).collect(Collectors.toList()), ",")
                     );
                  }

                  this.crmApplyStructuralDesignBiddingRecordBiz.save(crmApplyStructuralDesignBiddingRecord);
                  this.createCustomOaApproval(
                     crmApplyStructuralDesignBiddingRecord.getId(),
                     ApproveProcessTypeEnumV2.CRM_STRUCTURAL_DESIGN_BIDDING,
                     paramV2,
                     crmProjectInformationWarehousing,
                     applicant,
                     item,
                     createdOaRequests,
                     record -> {
                        crmApplyStructuralDesignBiddingRecord.setApproveRecordId(record.getId());
                        Preconditions.checkArgument(
                           this.crmApplyStructuralDesignBiddingRecordBiz.updateById(crmApplyStructuralDesignBiddingRecord), "结构设计标回写审批记录失败"
                        );
                     }
                  );
               }

               if (item.equals(CrmTenderRequirementTypeEnum.DEEPENING_THE_DESIGN_STANDARD.getType())) {
                  List<CrmApplyDeepDesignBiddingRecord> crmApplyDeepDesignBiddingRecords = this.crmApplyDeepDesignBiddingRecordBiz
                     .list(
                        Wrappers.lambdaQuery(CrmApplyDeepDesignBiddingRecord.class)
                           .eq(CrmApplyDeepDesignBiddingRecord::getCrmProjectInformationWarehousingId, crmProjectInformationWarehousing.getId())
                     );
                  crmApplyDeepDesignBiddingRecords.forEach(
                     crmApplyDeepDesignBiddingRecord -> {
                        Preconditions.checkArgument(
                           !crmApplyDeepDesignBiddingRecord.getCrmCheckStatusEnum().equals(CrmCheckStatusEnum.PASS.getType()), "该项目深化设计标已审核通过,不可进行申请"
                        );
                        Preconditions.checkArgument(
                           !crmApplyDeepDesignBiddingRecord.getCrmCheckStatusEnum().equals(CrmCheckStatusEnum.PENDING.getType()), "该项目深化设计标正在审核中,不可进行申请"
                        );
                     }
                  );
                  CrmApplyDeepDesignBiddingRecord crmApplyStructuralDesignBiddingRecord = BeanUtil.copy(paramV2, CrmApplyDeepDesignBiddingRecord.class);
                  crmApplyStructuralDesignBiddingRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.PENDING.getType());
                  crmApplyStructuralDesignBiddingRecord.setInformantUserName(
                     crmApplyStructuralDesignBiddingRecord.getInformantUserId() != null
                        ? this.userService.getById(crmApplyStructuralDesignBiddingRecord.getInformantUserId()).getName()
                        : null
                  );
                  crmApplyStructuralDesignBiddingRecord.setCreateUserId(UserUtil.getCurrentUserId());
                  if (CollectionUtils.isNotEmpty(paramV2.getAttachmentIds())) {
                     crmApplyStructuralDesignBiddingRecord.setAttachmentIds(
                        StringUtils.join(paramV2.getAttachmentIds().stream().map(AttachmentDTO::getId).collect(Collectors.toList()), ",")
                     );
                  }

                  this.crmApplyDeepDesignBiddingRecordBiz.save(crmApplyStructuralDesignBiddingRecord);
                  this.createCustomOaApproval(
                     crmApplyStructuralDesignBiddingRecord.getId(),
                     ApproveProcessTypeEnumV2.CRM_DEEP_DESIGN_BIDDING,
                     paramV2,
                     crmProjectInformationWarehousing,
                     applicant,
                     item,
                     createdOaRequests,
                     record -> {
                        crmApplyStructuralDesignBiddingRecord.setApproveRecordId(record.getId());
                        Preconditions.checkArgument(this.crmApplyDeepDesignBiddingRecordBiz.updateById(crmApplyStructuralDesignBiddingRecord), "深化设计标回写审批记录失败");
                     }
                  );
               }
            }
         );
      } catch (RuntimeException e) {
         createdOaRequests.forEach(request -> this.compensateOaRequest(request.requestId, applicant, request.approveProcessType, e));
         throw e;
      }

      this.updateProjectScheduleType(crmProjectInformationWarehousing);
      return Boolean.TRUE;
   }

   private void createCustomOaApproval(
      Long dataId,
      ApproveProcessTypeEnumV2 approveType,
      CrmApplyForBidRecordSaveParamV2 param,
      CrmProjectInformationWarehousing project,
      User applicant,
      Integer tenderRequirement,
      List<CrmApplyForBidRecordBizImpl.CustomOaRequest> createdOaRequests,
      Consumer<WmsApproveRecord> linkApprovalRecord
   ) {
      if (!Boolean.TRUE.equals(this.crmOaConfigBiz.getOaConfig().getEnabled())) {
         WmsApproveRecord record = this.wmsApproveRecordService
            .createRecord(dataId, project.getProjectName(), approveType.getType(), null, null, null, false, null, null, null);
         linkApprovalRecord.accept(record);
         if (ReviewStatusEnum.REVIEWED.getType().equals(record.getReviewStatus())) {
            this.passCustomBidWithoutApproval(dataId, approveType, project);
         }
      } else {
         String requestId = this.createOaProjectBidApplication(
            param, project, applicant, param.getAttachmentIds(), Collections.singletonList(tenderRequirement)
         );
         createdOaRequests.add(new CrmApplyForBidRecordBizImpl.CustomOaRequest(requestId, approveType.getType()));
         WmsApproveRecord record = this.createOaApproveRecord(dataId, project, applicant, requestId, approveType);
         linkApprovalRecord.accept(record);
      }
   }

   private void passCustomBidWithoutApproval(Long dataId, ApproveProcessTypeEnumV2 approveType, CrmProjectInformationWarehousing project) {
      if (ApproveProcessTypeEnumV2.CRM_BUSINESS_BIDDING.equals(approveType)) {
         CrmApplyBusinessBiddingRecord record = this.crmApplyBusinessBiddingRecordBiz.getById(dataId);
         record.setCrmCheckStatusEnum(CrmCheckStatusEnum.PASS.getType());
         this.crmApplyBusinessBiddingRecordBiz.updateById(record);
      } else if (ApproveProcessTypeEnumV2.CRM_TECHNOLOGY_BIDDING.equals(approveType)) {
         CrmApplyTechnologyBiddingRecord record = this.crmApplyTechnologyBiddingRecordBiz.getById(dataId);
         record.setCrmCheckStatusEnum(CrmCheckStatusEnum.PASS.getType());
         this.crmApplyTechnologyBiddingRecordBiz.updateById(record);
      } else if (ApproveProcessTypeEnumV2.CRM_STRUCTURAL_DESIGN_BIDDING.equals(approveType)) {
         CrmApplyStructuralDesignBiddingRecord record = this.crmApplyStructuralDesignBiddingRecordBiz.getById(dataId);
         record.setCrmCheckStatusEnum(CrmCheckStatusEnum.PASS.getType());
         this.crmApplyStructuralDesignBiddingRecordBiz.updateById(record);
      } else if (ApproveProcessTypeEnumV2.CRM_DEEP_DESIGN_BIDDING.equals(approveType)) {
         CrmApplyDeepDesignBiddingRecord record = this.crmApplyDeepDesignBiddingRecordBiz.getById(dataId);
         record.setCrmCheckStatusEnum(CrmCheckStatusEnum.PASS.getType());
         this.crmApplyDeepDesignBiddingRecordBiz.updateById(record);
      }

      project.setCrmProjectScheduleTypeEnum(CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType());
      this.crmProjectInformationWarehousingService.updateById(project);
   }

   private void updateProjectScheduleType(CrmProjectInformationWarehousing crmProjectInformationWarehousing) {
   }

   @Override
   public CrmApplyForBidRecordDetailDTOV2 crmApplyForBidRecordDetailByProjectIdCustom(Long id, Integer crmTenderRequirementTypeEnum) {
      CrmProjectInformationWarehousing projectInformationWarehousing = this.crmProjectInformationWarehousingService.getById(id);
      Preconditions.checkArgument(projectInformationWarehousing != null, "项目备案不存在");
      Preconditions.checkArgument(crmTenderRequirementTypeEnum != null, "请先选择标书类型");
      CrmEnterpriseWarehousing crmEnterpriseWarehousing = null;
      if (projectInformationWarehousing.getCrmEnterpriseWarehousingId() != null) {
         crmEnterpriseWarehousing = this.crmEnterpriseWarehousingBiz.getById(projectInformationWarehousing.getCrmEnterpriseWarehousingId());
      }

      CrmApplyForBidRecordDetailDTOV2 crmApplyForBidRecordDetailDTOV2 = new CrmApplyForBidRecordDetailDTOV2();
      if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.BIDDING_METHOD.getType())) {
         CrmApplyBusinessBiddingRecord crmApplyBusinessBiddingRecord = this.crmApplyBusinessBiddingRecordBiz
            .getOne(
               Wrappers.lambdaQuery(CrmApplyBusinessBiddingRecord.class)
                  .eq(CrmApplyBusinessBiddingRecord::getCrmProjectInformationWarehousingId, id)
                  .eq(CrmApplyBusinessBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
            );
         Preconditions.checkArgument(crmApplyBusinessBiddingRecord != null, "投标申请不存在");
         BeanUtil.copy(crmApplyBusinessBiddingRecord, crmApplyForBidRecordDetailDTOV2);
         crmApplyForBidRecordDetailDTOV2.setBiddingPlatformName(crmApplyBusinessBiddingRecord.getCompanyName());
         if (crmEnterpriseWarehousing != null) {
            crmApplyForBidRecordDetailDTOV2.setCrmEnterpriseWarehousingName(crmEnterpriseWarehousing.getBusinessName());
         }

         crmApplyForBidRecordDetailDTOV2.setProjectName(projectInformationWarehousing.getProjectName());
         crmApplyForBidRecordDetailDTOV2.setProjectSerialNumber(projectInformationWarehousing.getSerialNumber());
         crmApplyForBidRecordDetailDTOV2.setCreateUserName(this.userService.getById(crmApplyBusinessBiddingRecord.getCreateUserId()).getName());
         if (crmApplyBusinessBiddingRecord.getInformantUserId() != null) {
            crmApplyForBidRecordDetailDTOV2.setInformantUserName(this.userService.getById(crmApplyBusinessBiddingRecord.getInformantUserId()).getName());
         }

         if (crmApplyBusinessBiddingRecord.getDepartmentId() != null) {
            crmApplyForBidRecordDetailDTOV2.setDepartmentName(
               this.departmentService.getDepartmentById(crmApplyBusinessBiddingRecord.getDepartmentId()).getName()
            );
         }

         crmApplyForBidRecordDetailDTOV2.setProjectName(projectInformationWarehousing.getProjectName());
         crmApplyForBidRecordDetailDTOV2.setProjectSerialNumber(projectInformationWarehousing.getSerialNumber());
         if (crmApplyBusinessBiddingRecord.getBiddingMethodId() != null) {
            crmApplyForBidRecordDetailDTOV2.setBiddingMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyBusinessBiddingRecord.getBiddingMethodId()).getName()
            );
         }

         if (crmApplyBusinessBiddingRecord.getTenderSubmissionMethodId() != null) {
            crmApplyForBidRecordDetailDTOV2.setTenderSubmissionMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyBusinessBiddingRecord.getTenderSubmissionMethodId()).getName()
            );
         }

         if (crmApplyBusinessBiddingRecord.getBidEvaluationMethodId() != null) {
            crmApplyForBidRecordDetailDTOV2.setBidEvaluationMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyBusinessBiddingRecord.getBidEvaluationMethodId()).getName()
            );
         }

         if (crmApplyBusinessBiddingRecord.getBidEvaluationMethodId() != null) {
            crmApplyForBidRecordDetailDTOV2.setSettlementMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyBusinessBiddingRecord.getBidEvaluationMethodId()).getName()
            );
         }

         if (crmApplyBusinessBiddingRecord.getTypeOfPerformanceBondId() != null) {
            crmApplyForBidRecordDetailDTOV2.setTypeOfPerformanceBondName(
               this.crmTenderRequestConfigBiz.getById(crmApplyBusinessBiddingRecord.getTypeOfPerformanceBondId()).getName()
            );
         }

         String crmTenderRequirementTypeEnumName = this.appendTenderRequirement(projectInformationWarehousing);
         crmApplyForBidRecordDetailDTOV2.setTenderRequirement(crmTenderRequirementTypeEnumName);
         if (com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank(crmApplyBusinessBiddingRecord.getAttachmentIds())) {
            crmApplyForBidRecordDetailDTOV2.setAttachmentDTOList(this.attachmentService.listByIds(crmApplyBusinessBiddingRecord.getAttachmentIds()));
         }
      }

      if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType())) {
         CrmApplyTechnologyBiddingRecord crmApplyStructuralDesignBiddingRecord = this.crmApplyTechnologyBiddingRecordBiz
            .getOne(
               Wrappers.lambdaQuery(CrmApplyTechnologyBiddingRecord.class)
                  .eq(CrmApplyTechnologyBiddingRecord::getCrmProjectInformationWarehousingId, id)
                  .eq(CrmApplyTechnologyBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
            );
         Preconditions.checkArgument(crmApplyStructuralDesignBiddingRecord != null, "投标申请不存在");
         BeanUtil.copy(crmApplyStructuralDesignBiddingRecord, crmApplyForBidRecordDetailDTOV2);
         crmApplyForBidRecordDetailDTOV2.setBiddingPlatformName(crmApplyStructuralDesignBiddingRecord.getCompanyName());
         if (crmEnterpriseWarehousing != null) {
            crmApplyForBidRecordDetailDTOV2.setCrmEnterpriseWarehousingName(crmEnterpriseWarehousing.getBusinessName());
         }

         crmApplyForBidRecordDetailDTOV2.setProjectName(projectInformationWarehousing.getProjectName());
         crmApplyForBidRecordDetailDTOV2.setProjectSerialNumber(projectInformationWarehousing.getSerialNumber());
         crmApplyForBidRecordDetailDTOV2.setCreateUserName(this.userService.getById(crmApplyStructuralDesignBiddingRecord.getCreateUserId()).getName());
         if (crmApplyStructuralDesignBiddingRecord.getInformantUserId() != null) {
            crmApplyForBidRecordDetailDTOV2.setInformantUserName(this.userService.getById(crmApplyStructuralDesignBiddingRecord.getInformantUserId()).getName());
         }

         if (crmApplyStructuralDesignBiddingRecord.getDepartmentId() != null) {
            crmApplyForBidRecordDetailDTOV2.setDepartmentName(
               this.departmentService.getDepartmentById(crmApplyStructuralDesignBiddingRecord.getDepartmentId()).getName()
            );
         }

         crmApplyForBidRecordDetailDTOV2.setProjectName(projectInformationWarehousing.getProjectName());
         crmApplyForBidRecordDetailDTOV2.setProjectSerialNumber(projectInformationWarehousing.getSerialNumber());
         if (crmApplyStructuralDesignBiddingRecord.getBiddingMethodId() != null) {
            crmApplyForBidRecordDetailDTOV2.setBiddingMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyStructuralDesignBiddingRecord.getBiddingMethodId()).getName()
            );
         }

         if (crmApplyStructuralDesignBiddingRecord.getTenderSubmissionMethodId() != null) {
            crmApplyForBidRecordDetailDTOV2.setTenderSubmissionMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyStructuralDesignBiddingRecord.getTenderSubmissionMethodId()).getName()
            );
         }

         if (crmApplyStructuralDesignBiddingRecord.getBidEvaluationMethodId() != null) {
            crmApplyForBidRecordDetailDTOV2.setBidEvaluationMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyStructuralDesignBiddingRecord.getBidEvaluationMethodId()).getName()
            );
         }

         if (crmApplyStructuralDesignBiddingRecord.getBidEvaluationMethodId() != null) {
            crmApplyForBidRecordDetailDTOV2.setSettlementMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyStructuralDesignBiddingRecord.getBidEvaluationMethodId()).getName()
            );
         }

         if (crmApplyStructuralDesignBiddingRecord.getTypeOfPerformanceBondId() != null) {
            crmApplyForBidRecordDetailDTOV2.setTypeOfPerformanceBondName(
               this.crmTenderRequestConfigBiz.getById(crmApplyStructuralDesignBiddingRecord.getTypeOfPerformanceBondId()).getName()
            );
         }

         String crmTenderRequirementTypeEnumName = this.appendTenderRequirement(projectInformationWarehousing);
         crmApplyForBidRecordDetailDTOV2.setTenderRequirement(crmTenderRequirementTypeEnumName);
         if (com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank(crmApplyStructuralDesignBiddingRecord.getAttachmentIds())) {
            crmApplyForBidRecordDetailDTOV2.setAttachmentDTOList(this.attachmentService.listByIds(crmApplyStructuralDesignBiddingRecord.getAttachmentIds()));
         }
      }

      if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.STRUCTURAL_DESIGN_TARGET.getType())) {
         CrmApplyStructuralDesignBiddingRecord crmApplyStructuralDesignBiddingRecord = this.crmApplyStructuralDesignBiddingRecordBiz
            .getOne(
               Wrappers.lambdaQuery(CrmApplyStructuralDesignBiddingRecord.class)
                  .eq(CrmApplyStructuralDesignBiddingRecord::getCrmProjectInformationWarehousingId, id)
                  .eq(CrmApplyStructuralDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
            );
         Preconditions.checkArgument(crmApplyStructuralDesignBiddingRecord != null, "投标申请不存在");
         BeanUtil.copy(crmApplyStructuralDesignBiddingRecord, crmApplyForBidRecordDetailDTOV2);
         crmApplyForBidRecordDetailDTOV2.setBiddingPlatformName(crmApplyStructuralDesignBiddingRecord.getCompanyName());
         if (crmEnterpriseWarehousing != null) {
            crmApplyForBidRecordDetailDTOV2.setCrmEnterpriseWarehousingName(crmEnterpriseWarehousing.getBusinessName());
         }

         crmApplyForBidRecordDetailDTOV2.setProjectName(projectInformationWarehousing.getProjectName());
         crmApplyForBidRecordDetailDTOV2.setProjectSerialNumber(projectInformationWarehousing.getSerialNumber());
         crmApplyForBidRecordDetailDTOV2.setCreateUserName(this.userService.getById(crmApplyStructuralDesignBiddingRecord.getCreateUserId()).getName());
         if (crmApplyStructuralDesignBiddingRecord.getInformantUserId() != null) {
            crmApplyForBidRecordDetailDTOV2.setInformantUserName(this.userService.getById(crmApplyStructuralDesignBiddingRecord.getInformantUserId()).getName());
         }

         if (crmApplyStructuralDesignBiddingRecord.getDepartmentId() != null) {
            crmApplyForBidRecordDetailDTOV2.setDepartmentName(
               this.departmentService.getDepartmentById(crmApplyStructuralDesignBiddingRecord.getDepartmentId()).getName()
            );
         }

         crmApplyForBidRecordDetailDTOV2.setProjectName(projectInformationWarehousing.getProjectName());
         crmApplyForBidRecordDetailDTOV2.setProjectSerialNumber(projectInformationWarehousing.getSerialNumber());
         if (crmApplyStructuralDesignBiddingRecord.getBiddingMethodId() != null) {
            crmApplyForBidRecordDetailDTOV2.setBiddingMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyStructuralDesignBiddingRecord.getBiddingMethodId()).getName()
            );
         }

         if (crmApplyStructuralDesignBiddingRecord.getTenderSubmissionMethodId() != null) {
            crmApplyForBidRecordDetailDTOV2.setTenderSubmissionMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyStructuralDesignBiddingRecord.getTenderSubmissionMethodId()).getName()
            );
         }

         if (crmApplyStructuralDesignBiddingRecord.getBidEvaluationMethodId() != null) {
            crmApplyForBidRecordDetailDTOV2.setBidEvaluationMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyStructuralDesignBiddingRecord.getBidEvaluationMethodId()).getName()
            );
         }

         if (crmApplyStructuralDesignBiddingRecord.getBidEvaluationMethodId() != null) {
            crmApplyForBidRecordDetailDTOV2.setSettlementMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyStructuralDesignBiddingRecord.getBidEvaluationMethodId()).getName()
            );
         }

         if (crmApplyStructuralDesignBiddingRecord.getTypeOfPerformanceBondId() != null) {
            crmApplyForBidRecordDetailDTOV2.setTypeOfPerformanceBondName(
               this.crmTenderRequestConfigBiz.getById(crmApplyStructuralDesignBiddingRecord.getTypeOfPerformanceBondId()).getName()
            );
         }

         String crmTenderRequirementTypeEnumName = this.appendTenderRequirement(projectInformationWarehousing);
         crmApplyForBidRecordDetailDTOV2.setTenderRequirement(crmTenderRequirementTypeEnumName);
         if (com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank(crmApplyStructuralDesignBiddingRecord.getAttachmentIds())) {
            crmApplyForBidRecordDetailDTOV2.setAttachmentDTOList(this.attachmentService.listByIds(crmApplyStructuralDesignBiddingRecord.getAttachmentIds()));
         }
      }

      if (crmTenderRequirementTypeEnum.equals(CrmTenderRequirementTypeEnum.DEEPENING_THE_DESIGN_STANDARD.getType())) {
         CrmApplyDeepDesignBiddingRecord crmApplyDeepDesignBiddingRecord = this.crmApplyDeepDesignBiddingRecordBiz
            .getOne(
               Wrappers.lambdaQuery(CrmApplyDeepDesignBiddingRecord.class)
                  .eq(CrmApplyDeepDesignBiddingRecord::getCrmProjectInformationWarehousingId, id)
                  .eq(CrmApplyDeepDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
            );
         Preconditions.checkArgument(crmApplyDeepDesignBiddingRecord != null, "投标申请不存在");
         BeanUtil.copy(crmApplyDeepDesignBiddingRecord, crmApplyForBidRecordDetailDTOV2);
         crmApplyForBidRecordDetailDTOV2.setBiddingPlatformName(crmApplyDeepDesignBiddingRecord.getCompanyName());
         if (crmEnterpriseWarehousing != null) {
            crmApplyForBidRecordDetailDTOV2.setCrmEnterpriseWarehousingName(crmEnterpriseWarehousing.getBusinessName());
         }

         crmApplyForBidRecordDetailDTOV2.setProjectName(projectInformationWarehousing.getProjectName());
         crmApplyForBidRecordDetailDTOV2.setProjectSerialNumber(projectInformationWarehousing.getSerialNumber());
         crmApplyForBidRecordDetailDTOV2.setCreateUserName(this.userService.getById(crmApplyDeepDesignBiddingRecord.getCreateUserId()).getName());
         if (crmApplyDeepDesignBiddingRecord.getInformantUserId() != null) {
            crmApplyForBidRecordDetailDTOV2.setInformantUserName(this.userService.getById(crmApplyDeepDesignBiddingRecord.getInformantUserId()).getName());
         }

         if (crmApplyDeepDesignBiddingRecord.getDepartmentId() != null) {
            crmApplyForBidRecordDetailDTOV2.setDepartmentName(
               this.departmentService.getDepartmentById(crmApplyDeepDesignBiddingRecord.getDepartmentId()).getName()
            );
         }

         crmApplyForBidRecordDetailDTOV2.setProjectName(projectInformationWarehousing.getProjectName());
         crmApplyForBidRecordDetailDTOV2.setProjectSerialNumber(projectInformationWarehousing.getSerialNumber());
         if (crmApplyDeepDesignBiddingRecord.getBiddingMethodId() != null) {
            crmApplyForBidRecordDetailDTOV2.setBiddingMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyDeepDesignBiddingRecord.getBiddingMethodId()).getName()
            );
         }

         if (crmApplyDeepDesignBiddingRecord.getTenderSubmissionMethodId() != null) {
            crmApplyForBidRecordDetailDTOV2.setTenderSubmissionMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyDeepDesignBiddingRecord.getTenderSubmissionMethodId()).getName()
            );
         }

         if (crmApplyDeepDesignBiddingRecord.getBidEvaluationMethodId() != null) {
            crmApplyForBidRecordDetailDTOV2.setBidEvaluationMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyDeepDesignBiddingRecord.getBidEvaluationMethodId()).getName()
            );
         }

         if (crmApplyDeepDesignBiddingRecord.getBidEvaluationMethodId() != null) {
            crmApplyForBidRecordDetailDTOV2.setSettlementMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyDeepDesignBiddingRecord.getBidEvaluationMethodId()).getName()
            );
         }

         if (crmApplyDeepDesignBiddingRecord.getTypeOfPerformanceBondId() != null) {
            crmApplyForBidRecordDetailDTOV2.setTypeOfPerformanceBondName(
               this.crmTenderRequestConfigBiz.getById(crmApplyDeepDesignBiddingRecord.getTypeOfPerformanceBondId()).getName()
            );
         }

         String crmTenderRequirementTypeEnumName = this.appendTenderRequirement(projectInformationWarehousing);
         crmApplyForBidRecordDetailDTOV2.setTenderRequirement(crmTenderRequirementTypeEnumName);
         if (com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank(crmApplyDeepDesignBiddingRecord.getAttachmentIds())) {
            crmApplyForBidRecordDetailDTOV2.setAttachmentDTOList(this.attachmentService.listByIds(crmApplyDeepDesignBiddingRecord.getAttachmentIds()));
         }
      }

      return crmApplyForBidRecordDetailDTOV2;
   }

   @Override
   public CrmApplyForBidRecordDetailDTOV2 crmApplyForBidRecordDetailDTOCustom(Long id, Integer approveProcessTypeEnumV2) {
      CrmApplyForBidRecordDetailDTOV2 crmApplyForBidRecordDetailDTO = new CrmApplyForBidRecordDetailDTOV2();
      if (approveProcessTypeEnumV2.equals(ApproveProcessTypeEnumV2.CRM_BUSINESS_BIDDING.getType())) {
         CrmApplyBusinessBiddingRecord crmApplyBusinessBiddingRecord = this.crmApplyBusinessBiddingRecordMapper.getDetailByDelete(id);
         Preconditions.checkArgument(crmApplyBusinessBiddingRecord != null, "投标申请不存在");
         CrmProjectInformationWarehousing projectInformationWarehousing = this.crmProjectInformationWarehousingService
            .getById(crmApplyBusinessBiddingRecord.getCrmProjectInformationWarehousingId());
         Preconditions.checkArgument(projectInformationWarehousing != null, "项目备案不存在");
         CrmEnterpriseWarehousing crmEnterpriseWarehousing = null;
         if (projectInformationWarehousing.getCrmEnterpriseWarehousingId() != null) {
            crmEnterpriseWarehousing = this.crmEnterpriseWarehousingBiz.getById(projectInformationWarehousing.getCrmEnterpriseWarehousingId());
         }

         BeanUtil.copy(crmApplyBusinessBiddingRecord, crmApplyForBidRecordDetailDTO);
         crmApplyForBidRecordDetailDTO.setBiddingPlatformName(crmApplyBusinessBiddingRecord.getCompanyName());
         crmApplyForBidRecordDetailDTO.setTenderRequirement("商务标");
         if (crmEnterpriseWarehousing != null) {
            crmApplyForBidRecordDetailDTO.setCrmEnterpriseWarehousingName(crmEnterpriseWarehousing.getBusinessName());
         }

         crmApplyForBidRecordDetailDTO.setProjectName(projectInformationWarehousing.getProjectName());
         crmApplyForBidRecordDetailDTO.setProjectSerialNumber(projectInformationWarehousing.getSerialNumber());
         crmApplyForBidRecordDetailDTO.setCreateUserName(this.userService.getById(crmApplyBusinessBiddingRecord.getCreateUserId()).getName());
         if (crmApplyBusinessBiddingRecord.getInformantUserId() != null) {
            crmApplyForBidRecordDetailDTO.setInformantUserName(this.userService.getById(crmApplyBusinessBiddingRecord.getInformantUserId()).getName());
         }

         if (crmApplyBusinessBiddingRecord.getDepartmentId() != null) {
            crmApplyForBidRecordDetailDTO.setDepartmentName(this.departmentService.getDepartmentById(crmApplyBusinessBiddingRecord.getDepartmentId()).getName());
         }

         crmApplyForBidRecordDetailDTO.setProjectName(projectInformationWarehousing.getProjectName());
         crmApplyForBidRecordDetailDTO.setProjectSerialNumber(projectInformationWarehousing.getSerialNumber());
         if (crmApplyBusinessBiddingRecord.getBiddingMethodId() != null) {
            crmApplyForBidRecordDetailDTO.setBiddingMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyBusinessBiddingRecord.getBiddingMethodId()).getName()
            );
         }

         if (crmApplyBusinessBiddingRecord.getTenderSubmissionMethodId() != null) {
            crmApplyForBidRecordDetailDTO.setTenderSubmissionMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyBusinessBiddingRecord.getTenderSubmissionMethodId()).getName()
            );
         }

         if (crmApplyBusinessBiddingRecord.getBidEvaluationMethodId() != null) {
            crmApplyForBidRecordDetailDTO.setBidEvaluationMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyBusinessBiddingRecord.getBidEvaluationMethodId()).getName()
            );
         }

         if (crmApplyBusinessBiddingRecord.getSettlementMethodId() != null) {
            crmApplyForBidRecordDetailDTO.setSettlementMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyBusinessBiddingRecord.getSettlementMethodId()).getName()
            );
         }

         if (crmApplyBusinessBiddingRecord.getTypeOfPerformanceBondId() != null) {
            crmApplyForBidRecordDetailDTO.setTypeOfPerformanceBondName(
               this.crmTenderRequestConfigBiz.getById(crmApplyBusinessBiddingRecord.getTypeOfPerformanceBondId()).getName()
            );
         }

         if (com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank(crmApplyBusinessBiddingRecord.getAttachmentIds())) {
            crmApplyForBidRecordDetailDTO.setAttachmentDTOList(this.attachmentService.listByIds(crmApplyBusinessBiddingRecord.getAttachmentIds()));
         }
      }

      if (approveProcessTypeEnumV2.equals(ApproveProcessTypeEnumV2.CRM_TECHNOLOGY_BIDDING.getType())) {
         CrmApplyTechnologyBiddingRecord crmApplyTechnologyBiddingRecord = this.crmApplyTechnologyBiddingRecordMapper.getDetailByDelete(id);
         Preconditions.checkArgument(crmApplyTechnologyBiddingRecord != null, "投标申请不存在");
         CrmProjectInformationWarehousing projectInformationWarehousing = this.crmProjectInformationWarehousingService
            .getById(crmApplyTechnologyBiddingRecord.getCrmProjectInformationWarehousingId());
         Preconditions.checkArgument(projectInformationWarehousing != null, "项目备案不存在");
         CrmEnterpriseWarehousing crmEnterpriseWarehousing = null;
         if (projectInformationWarehousing.getCrmEnterpriseWarehousingId() != null) {
            crmEnterpriseWarehousing = this.crmEnterpriseWarehousingBiz.getById(projectInformationWarehousing.getCrmEnterpriseWarehousingId());
         }

         BeanUtil.copy(crmApplyTechnologyBiddingRecord, crmApplyForBidRecordDetailDTO);
         crmApplyForBidRecordDetailDTO.setTenderRequirement("技术标");
         crmApplyForBidRecordDetailDTO.setBiddingPlatformName(crmApplyTechnologyBiddingRecord.getCompanyName());
         if (crmEnterpriseWarehousing != null) {
            crmApplyForBidRecordDetailDTO.setCrmEnterpriseWarehousingName(crmEnterpriseWarehousing.getBusinessName());
         }

         crmApplyForBidRecordDetailDTO.setProjectName(projectInformationWarehousing.getProjectName());
         crmApplyForBidRecordDetailDTO.setProjectSerialNumber(projectInformationWarehousing.getSerialNumber());
         crmApplyForBidRecordDetailDTO.setCreateUserName(this.userService.getById(crmApplyTechnologyBiddingRecord.getCreateUserId()).getName());
         if (crmApplyTechnologyBiddingRecord.getInformantUserId() != null) {
            crmApplyForBidRecordDetailDTO.setInformantUserName(this.userService.getById(crmApplyTechnologyBiddingRecord.getInformantUserId()).getName());
         }

         if (crmApplyTechnologyBiddingRecord.getDepartmentId() != null) {
            crmApplyForBidRecordDetailDTO.setDepartmentName(
               this.departmentService.getDepartmentById(crmApplyTechnologyBiddingRecord.getDepartmentId()).getName()
            );
         }

         crmApplyForBidRecordDetailDTO.setProjectName(projectInformationWarehousing.getProjectName());
         crmApplyForBidRecordDetailDTO.setProjectSerialNumber(projectInformationWarehousing.getSerialNumber());
         if (crmApplyTechnologyBiddingRecord.getBiddingMethodId() != null) {
            crmApplyForBidRecordDetailDTO.setBiddingMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyTechnologyBiddingRecord.getBiddingMethodId()).getName()
            );
         }

         if (crmApplyTechnologyBiddingRecord.getTenderSubmissionMethodId() != null) {
            crmApplyForBidRecordDetailDTO.setTenderSubmissionMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyTechnologyBiddingRecord.getTenderSubmissionMethodId()).getName()
            );
         }

         if (crmApplyTechnologyBiddingRecord.getBidEvaluationMethodId() != null) {
            crmApplyForBidRecordDetailDTO.setBidEvaluationMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyTechnologyBiddingRecord.getBidEvaluationMethodId()).getName()
            );
         }

         if (crmApplyTechnologyBiddingRecord.getSettlementMethodId() != null) {
            crmApplyForBidRecordDetailDTO.setSettlementMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyTechnologyBiddingRecord.getSettlementMethodId()).getName()
            );
         }

         if (crmApplyTechnologyBiddingRecord.getTypeOfPerformanceBondId() != null) {
            crmApplyForBidRecordDetailDTO.setTypeOfPerformanceBondName(
               this.crmTenderRequestConfigBiz.getById(crmApplyTechnologyBiddingRecord.getTypeOfPerformanceBondId()).getName()
            );
         }

         if (com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank(crmApplyTechnologyBiddingRecord.getAttachmentIds())) {
            crmApplyForBidRecordDetailDTO.setAttachmentDTOList(this.attachmentService.listByIds(crmApplyTechnologyBiddingRecord.getAttachmentIds()));
         }
      }

      if (approveProcessTypeEnumV2.equals(ApproveProcessTypeEnumV2.CRM_STRUCTURAL_DESIGN_BIDDING.getType())) {
         CrmApplyStructuralDesignBiddingRecord crmApplyStructuralDesignBiddingRecord = this.crmApplyStructuralDesignBiddingRecordMapper.getDetailByDelete(id);
         Preconditions.checkArgument(crmApplyStructuralDesignBiddingRecord != null, "投标申请不存在");
         CrmProjectInformationWarehousing projectInformationWarehousing = this.crmProjectInformationWarehousingService
            .getById(crmApplyStructuralDesignBiddingRecord.getCrmProjectInformationWarehousingId());
         Preconditions.checkArgument(projectInformationWarehousing != null, "项目备案不存在");
         CrmEnterpriseWarehousing crmEnterpriseWarehousing = null;
         if (projectInformationWarehousing.getCrmEnterpriseWarehousingId() != null) {
            crmEnterpriseWarehousing = this.crmEnterpriseWarehousingBiz.getById(projectInformationWarehousing.getCrmEnterpriseWarehousingId());
         }

         BeanUtil.copy(crmApplyStructuralDesignBiddingRecord, crmApplyForBidRecordDetailDTO);
         crmApplyForBidRecordDetailDTO.setTenderRequirement("结构设计标");
         crmApplyForBidRecordDetailDTO.setBiddingPlatformName(crmApplyStructuralDesignBiddingRecord.getCompanyName());
         if (crmEnterpriseWarehousing != null) {
            crmApplyForBidRecordDetailDTO.setCrmEnterpriseWarehousingName(crmEnterpriseWarehousing.getBusinessName());
         }

         crmApplyForBidRecordDetailDTO.setProjectName(projectInformationWarehousing.getProjectName());
         crmApplyForBidRecordDetailDTO.setProjectSerialNumber(projectInformationWarehousing.getSerialNumber());
         crmApplyForBidRecordDetailDTO.setCreateUserName(this.userService.getById(crmApplyStructuralDesignBiddingRecord.getCreateUserId()).getName());
         if (crmApplyStructuralDesignBiddingRecord.getInformantUserId() != null) {
            crmApplyForBidRecordDetailDTO.setInformantUserName(this.userService.getById(crmApplyStructuralDesignBiddingRecord.getInformantUserId()).getName());
         }

         if (crmApplyStructuralDesignBiddingRecord.getDepartmentId() != null) {
            crmApplyForBidRecordDetailDTO.setDepartmentName(
               this.departmentService.getDepartmentById(crmApplyStructuralDesignBiddingRecord.getDepartmentId()).getName()
            );
         }

         crmApplyForBidRecordDetailDTO.setProjectName(projectInformationWarehousing.getProjectName());
         crmApplyForBidRecordDetailDTO.setProjectSerialNumber(projectInformationWarehousing.getSerialNumber());
         if (crmApplyStructuralDesignBiddingRecord.getBiddingMethodId() != null) {
            crmApplyForBidRecordDetailDTO.setBiddingMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyStructuralDesignBiddingRecord.getBiddingMethodId()).getName()
            );
         }

         if (crmApplyStructuralDesignBiddingRecord.getTenderSubmissionMethodId() != null) {
            crmApplyForBidRecordDetailDTO.setTenderSubmissionMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyStructuralDesignBiddingRecord.getTenderSubmissionMethodId()).getName()
            );
         }

         if (crmApplyStructuralDesignBiddingRecord.getBidEvaluationMethodId() != null) {
            crmApplyForBidRecordDetailDTO.setBidEvaluationMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyStructuralDesignBiddingRecord.getBidEvaluationMethodId()).getName()
            );
         }

         if (crmApplyStructuralDesignBiddingRecord.getSettlementMethodId() != null) {
            crmApplyForBidRecordDetailDTO.setSettlementMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyStructuralDesignBiddingRecord.getSettlementMethodId()).getName()
            );
         }

         if (crmApplyStructuralDesignBiddingRecord.getTypeOfPerformanceBondId() != null) {
            crmApplyForBidRecordDetailDTO.setTypeOfPerformanceBondName(
               this.crmTenderRequestConfigBiz.getById(crmApplyStructuralDesignBiddingRecord.getTypeOfPerformanceBondId()).getName()
            );
         }

         if (com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank(crmApplyStructuralDesignBiddingRecord.getAttachmentIds())) {
            crmApplyForBidRecordDetailDTO.setAttachmentDTOList(this.attachmentService.listByIds(crmApplyStructuralDesignBiddingRecord.getAttachmentIds()));
         }
      }

      if (approveProcessTypeEnumV2.equals(ApproveProcessTypeEnumV2.CRM_DEEP_DESIGN_BIDDING.getType())) {
         CrmApplyDeepDesignBiddingRecord crmApplyDeepDesignBiddingRecord = this.crmApplyDeepDesignBiddingRecordMapper.getDetailByDelete(id);
         Preconditions.checkArgument(crmApplyDeepDesignBiddingRecord != null, "投标申请不存在");
         CrmProjectInformationWarehousing projectInformationWarehousing = this.crmProjectInformationWarehousingService
            .getById(crmApplyDeepDesignBiddingRecord.getCrmProjectInformationWarehousingId());
         Preconditions.checkArgument(projectInformationWarehousing != null, "项目备案不存在");
         CrmEnterpriseWarehousing crmEnterpriseWarehousing = null;
         if (projectInformationWarehousing.getCrmEnterpriseWarehousingId() != null) {
            crmEnterpriseWarehousing = this.crmEnterpriseWarehousingBiz.getById(projectInformationWarehousing.getCrmEnterpriseWarehousingId());
         }

         BeanUtil.copy(crmApplyDeepDesignBiddingRecord, crmApplyForBidRecordDetailDTO);
         crmApplyForBidRecordDetailDTO.setTenderRequirement("深化设计标");
         crmApplyForBidRecordDetailDTO.setBiddingPlatformName(crmApplyDeepDesignBiddingRecord.getCompanyName());
         if (crmEnterpriseWarehousing != null) {
            crmApplyForBidRecordDetailDTO.setCrmEnterpriseWarehousingName(crmEnterpriseWarehousing.getBusinessName());
         }

         crmApplyForBidRecordDetailDTO.setProjectName(projectInformationWarehousing.getProjectName());
         crmApplyForBidRecordDetailDTO.setProjectSerialNumber(projectInformationWarehousing.getSerialNumber());
         crmApplyForBidRecordDetailDTO.setCreateUserName(this.userService.getById(crmApplyDeepDesignBiddingRecord.getCreateUserId()).getName());
         if (crmApplyDeepDesignBiddingRecord.getInformantUserId() != null) {
            crmApplyForBidRecordDetailDTO.setInformantUserName(this.userService.getById(crmApplyDeepDesignBiddingRecord.getInformantUserId()).getName());
         }

         if (crmApplyDeepDesignBiddingRecord.getDepartmentId() != null) {
            crmApplyForBidRecordDetailDTO.setDepartmentName(
               this.departmentService.getDepartmentById(crmApplyDeepDesignBiddingRecord.getDepartmentId()).getName()
            );
         }

         crmApplyForBidRecordDetailDTO.setProjectName(projectInformationWarehousing.getProjectName());
         crmApplyForBidRecordDetailDTO.setProjectSerialNumber(projectInformationWarehousing.getSerialNumber());
         if (crmApplyDeepDesignBiddingRecord.getBiddingMethodId() != null) {
            crmApplyForBidRecordDetailDTO.setBiddingMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyDeepDesignBiddingRecord.getBiddingMethodId()).getName()
            );
         }

         if (crmApplyDeepDesignBiddingRecord.getTenderSubmissionMethodId() != null) {
            crmApplyForBidRecordDetailDTO.setTenderSubmissionMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyDeepDesignBiddingRecord.getTenderSubmissionMethodId()).getName()
            );
         }

         if (crmApplyDeepDesignBiddingRecord.getBidEvaluationMethodId() != null) {
            crmApplyForBidRecordDetailDTO.setBidEvaluationMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyDeepDesignBiddingRecord.getBidEvaluationMethodId()).getName()
            );
         }

         if (crmApplyDeepDesignBiddingRecord.getSettlementMethodId() != null) {
            crmApplyForBidRecordDetailDTO.setSettlementMethodName(
               this.crmTenderRequestConfigBiz.getById(crmApplyDeepDesignBiddingRecord.getSettlementMethodId()).getName()
            );
         }

         if (crmApplyDeepDesignBiddingRecord.getTypeOfPerformanceBondId() != null) {
            crmApplyForBidRecordDetailDTO.setTypeOfPerformanceBondName(
               this.crmTenderRequestConfigBiz.getById(crmApplyDeepDesignBiddingRecord.getTypeOfPerformanceBondId()).getName()
            );
         }

         if (com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank(crmApplyDeepDesignBiddingRecord.getAttachmentIds())) {
            crmApplyForBidRecordDetailDTO.setAttachmentDTOList(this.attachmentService.listByIds(crmApplyDeepDesignBiddingRecord.getAttachmentIds()));
         }
      }

      return crmApplyForBidRecordDetailDTO;
   }

   @Transactional
   @Override
   public Boolean projectFilingApprovalCustom(CrmAuditCommonDTO crmAuditCommonDTO) {
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(crmAuditCommonDTO.getApproveRecordId());
      Preconditions.checkArgument(wmsApproveRecord != null, "投标申请审批记录不存在");
      Preconditions.checkArgument(!ApproveSourceEnum.OA.getType().equals(wmsApproveRecord.getApproveSource()), "该单据由OA审批，请在OA中处理");
      Boolean result = this.wmsApproveRecordService
         .commonApproveStep(
            crmAuditCommonDTO.getDataId(), crmAuditCommonDTO.getDecision(), crmAuditCommonDTO.getOpinion(), wmsApproveRecord.getSerialNumber(), null
         );
      CrmProjectInformationWarehousing crmProjectInformationWarehousing = null;
      if (wmsApproveRecord.getApproveProcessType().equals(ApproveProcessTypeEnumV2.CRM_BUSINESS_BIDDING.getType())) {
         CrmApplyBusinessBiddingRecord crmApplyBusinessBiddingRecord = this.crmApplyBusinessBiddingRecordBiz.getById(crmAuditCommonDTO.getDataId());
         crmProjectInformationWarehousing = this.crmProjectInformationWarehousingService
            .getById(crmApplyBusinessBiddingRecord.getCrmProjectInformationWarehousingId());
         if (result) {
            if (crmAuditCommonDTO.getDecision() == 2) {
               crmApplyBusinessBiddingRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.PASS.getType());
               crmProjectInformationWarehousing.setCrmProjectScheduleTypeEnum(CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType());
               this.crmProjectInformationWarehousingService.updateById(crmProjectInformationWarehousing);
            }

            if (crmAuditCommonDTO.getDecision() == 4) {
               crmApplyBusinessBiddingRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.FAIL.getType());
            }

            this.crmApplyBusinessBiddingRecordBiz.updateById(crmApplyBusinessBiddingRecord);
         }
      }

      if (wmsApproveRecord.getApproveProcessType().equals(ApproveProcessTypeEnumV2.CRM_TECHNOLOGY_BIDDING.getType())) {
         CrmApplyTechnologyBiddingRecord crmApplyTechnologyBiddingRecord = this.crmApplyTechnologyBiddingRecordBiz.getById(crmAuditCommonDTO.getDataId());
         crmProjectInformationWarehousing = this.crmProjectInformationWarehousingService
            .getById(crmApplyTechnologyBiddingRecord.getCrmProjectInformationWarehousingId());
         if (result) {
            if (crmAuditCommonDTO.getDecision() == 2) {
               crmApplyTechnologyBiddingRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.PASS.getType());
               crmProjectInformationWarehousing.setCrmProjectScheduleTypeEnum(CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType());
               this.crmProjectInformationWarehousingService.updateById(crmProjectInformationWarehousing);
            }

            if (crmAuditCommonDTO.getDecision() == 4) {
               crmApplyTechnologyBiddingRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.FAIL.getType());
            }

            this.crmApplyTechnologyBiddingRecordBiz.updateById(crmApplyTechnologyBiddingRecord);
         }
      }

      if (wmsApproveRecord.getApproveProcessType().equals(ApproveProcessTypeEnumV2.CRM_STRUCTURAL_DESIGN_BIDDING.getType())) {
         CrmApplyStructuralDesignBiddingRecord crmApplyStructuralDesignBiddingRecord = this.crmApplyStructuralDesignBiddingRecordBiz
            .getById(crmAuditCommonDTO.getDataId());
         crmProjectInformationWarehousing = this.crmProjectInformationWarehousingService
            .getById(crmApplyStructuralDesignBiddingRecord.getCrmProjectInformationWarehousingId());
         if (result) {
            if (crmAuditCommonDTO.getDecision() == 2) {
               crmApplyStructuralDesignBiddingRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.PASS.getType());
               crmProjectInformationWarehousing.setCrmProjectScheduleTypeEnum(CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType());
               this.crmProjectInformationWarehousingService.updateById(crmProjectInformationWarehousing);
            }

            if (crmAuditCommonDTO.getDecision() == 4) {
               crmApplyStructuralDesignBiddingRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.FAIL.getType());
            }

            this.crmApplyStructuralDesignBiddingRecordBiz.updateById(crmApplyStructuralDesignBiddingRecord);
         }
      }

      if (wmsApproveRecord.getApproveProcessType().equals(ApproveProcessTypeEnumV2.CRM_DEEP_DESIGN_BIDDING.getType())) {
         CrmApplyDeepDesignBiddingRecord crmApplyDeepDesignBiddingRecord = this.crmApplyDeepDesignBiddingRecordBiz.getById(crmAuditCommonDTO.getDataId());
         crmProjectInformationWarehousing = this.crmProjectInformationWarehousingService
            .getById(crmApplyDeepDesignBiddingRecord.getCrmProjectInformationWarehousingId());
         if (result) {
            if (crmAuditCommonDTO.getDecision() == 2) {
               crmApplyDeepDesignBiddingRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.PASS.getType());
               crmProjectInformationWarehousing.setCrmProjectScheduleTypeEnum(CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType());
               this.crmProjectInformationWarehousingService.updateById(crmProjectInformationWarehousing);
            }

            if (crmAuditCommonDTO.getDecision() == 4) {
               crmApplyDeepDesignBiddingRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.FAIL.getType());
            }

            this.crmApplyDeepDesignBiddingRecordBiz.updateById(crmApplyDeepDesignBiddingRecord);
         }
      }

      this.updateProjectScheduleType(crmProjectInformationWarehousing);
      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public Boolean projectApplyForBidQuashCustom(Long id, Integer approveProcessTypeEnumV2) {
      if (approveProcessTypeEnumV2.equals(ApproveProcessTypeEnumV2.CRM_BUSINESS_BIDDING.getType())) {
         CrmApplyBusinessBiddingRecord forBidRecord = this.crmApplyBusinessBiddingRecordBiz.getById(id);
         Preconditions.checkArgument(forBidRecord != null, "投标申请备案不存在");
         WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(forBidRecord.getApproveRecordId());
         Preconditions.checkArgument(wmsApproveRecord != null, "投标申请审批不存在");
         if (ApproveSourceEnum.OA.getType().equals(wmsApproveRecord.getApproveSource())) {
            this.withdrawCustomOaRequest(wmsApproveRecord);
            this.crmApplyBusinessBiddingRecordBiz.removeById(forBidRecord.getId());
         } else {
            wmsApproveRecord.setReviewStatus(ReviewStatusEnum.CANCEL.getType());
            this.crmApplyBusinessBiddingRecordBiz.removeById(forBidRecord.getId());
            this.wmsApproveRecordService.updateById(wmsApproveRecord);
            this.wmsApproveRecordService.revocation(wmsApproveRecord.getId());
         }
      }

      if (approveProcessTypeEnumV2.equals(ApproveProcessTypeEnumV2.CRM_TECHNOLOGY_BIDDING.getType())) {
         CrmApplyTechnologyBiddingRecord forBidRecord = this.crmApplyTechnologyBiddingRecordBiz.getById(id);
         Preconditions.checkArgument(forBidRecord != null, "投标申请备案不存在");
         WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(forBidRecord.getApproveRecordId());
         Preconditions.checkArgument(wmsApproveRecord != null, "投标申请审批不存在");
         if (ApproveSourceEnum.OA.getType().equals(wmsApproveRecord.getApproveSource())) {
            this.withdrawCustomOaRequest(wmsApproveRecord);
            this.crmApplyTechnologyBiddingRecordBiz.removeById(forBidRecord.getId());
         } else {
            wmsApproveRecord.setReviewStatus(ReviewStatusEnum.CANCEL.getType());
            this.crmApplyTechnologyBiddingRecordBiz.removeById(forBidRecord.getId());
            this.wmsApproveRecordService.updateById(wmsApproveRecord);
            this.wmsApproveRecordService.revocation(wmsApproveRecord.getId());
         }
      }

      if (approveProcessTypeEnumV2.equals(ApproveProcessTypeEnumV2.CRM_DEEP_DESIGN_BIDDING.getType())) {
         CrmApplyDeepDesignBiddingRecord forBidRecord = this.crmApplyDeepDesignBiddingRecordBiz.getById(id);
         Preconditions.checkArgument(forBidRecord != null, "投标申请备案不存在");
         WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(forBidRecord.getApproveRecordId());
         Preconditions.checkArgument(wmsApproveRecord != null, "投标申请审批不存在");
         if (ApproveSourceEnum.OA.getType().equals(wmsApproveRecord.getApproveSource())) {
            this.withdrawCustomOaRequest(wmsApproveRecord);
            this.crmApplyDeepDesignBiddingRecordBiz.removeById(forBidRecord.getId());
         } else {
            wmsApproveRecord.setReviewStatus(ReviewStatusEnum.CANCEL.getType());
            this.crmApplyDeepDesignBiddingRecordBiz.removeById(forBidRecord.getId());
            this.wmsApproveRecordService.updateById(wmsApproveRecord);
            this.wmsApproveRecordService.revocation(wmsApproveRecord.getId());
         }
      }

      if (approveProcessTypeEnumV2.equals(ApproveProcessTypeEnumV2.CRM_STRUCTURAL_DESIGN_BIDDING.getType())) {
         CrmApplyStructuralDesignBiddingRecord forBidRecord = this.crmApplyStructuralDesignBiddingRecordBiz.getById(id);
         Preconditions.checkArgument(forBidRecord != null, "投标申请备案不存在");
         WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(forBidRecord.getApproveRecordId());
         Preconditions.checkArgument(wmsApproveRecord != null, "投标申请审批不存在");
         if (ApproveSourceEnum.OA.getType().equals(wmsApproveRecord.getApproveSource())) {
            this.withdrawCustomOaRequest(wmsApproveRecord);
            this.crmApplyStructuralDesignBiddingRecordBiz.removeById(forBidRecord.getId());
         } else {
            wmsApproveRecord.setReviewStatus(ReviewStatusEnum.CANCEL.getType());
            this.crmApplyStructuralDesignBiddingRecordBiz.removeById(forBidRecord.getId());
            this.wmsApproveRecordService.updateById(wmsApproveRecord);
            this.wmsApproveRecordService.revocation(wmsApproveRecord.getId());
         }
      }

      return Boolean.TRUE;
   }

   private void withdrawCustomOaRequest(WmsApproveRecord approveRecord) {
      Preconditions.checkArgument(StringUtils.isNotBlank(approveRecord.getRequestId()), "OA投标申请审批缺少requestId");
      User applicant = this.userService.getById(approveRecord.getApplicantId());
      Preconditions.checkArgument(applicant != null && applicant.getOaUserId() != null, "申请人未配置OA人员ID");
      ResultVO withdrawResult = this.oaBusinessProcessService
         .withdrawRequest(
            OaRevocationDTOParam.builder()
               .requestId(approveRecord.getRequestId())
               .isremind("0")
               .remark("初鸣系统撤回项目投标申请审批")
               .oaUserId(applicant.getOaUserId().toString())
               .approveProcessType(approveRecord.getApproveProcessType())
               .build()
         );
      Preconditions.checkArgument(
         withdrawResult != null && Long.valueOf(20000L).equals(withdrawResult.getCode()), withdrawResult == null ? "OA项目投标申请撤回失败" : withdrawResult.getMessage()
      );
   }

   @Override
   public List<Integer> getApprovalAlreadyEnums(Long crmProjectInformationWarehousingId) {
      CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingBiz.getById(crmProjectInformationWarehousingId);
      Preconditions.checkArgument(crmProjectInformationWarehousing != null, "项目备案不存在");
      List<Integer> list = new ArrayList<>();
      CrmApplyBusinessBiddingRecord applyBusinessBiddingRecord = this.crmApplyBusinessBiddingRecordBiz
         .getOne(
            Wrappers.lambdaQuery(CrmApplyBusinessBiddingRecord.class)
               .eq(CrmApplyBusinessBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               .eq(CrmApplyBusinessBiddingRecord::getCrmProjectInformationWarehousingId, crmProjectInformationWarehousingId)
         );
      if (applyBusinessBiddingRecord != null) {
         list.add(CrmTenderRequirementTypeEnum.BIDDING_METHOD.getType());
      }

      CrmApplyTechnologyBiddingRecord crmApplyTechnologyBiddingRecord = this.crmApplyTechnologyBiddingRecordBiz
         .getOne(
            Wrappers.lambdaQuery(CrmApplyTechnologyBiddingRecord.class)
               .eq(CrmApplyTechnologyBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               .eq(CrmApplyTechnologyBiddingRecord::getCrmSpecialBubmissionStatusEnum, CrmSpecialBubmissionStatusEnum.BID_ALLOCATION.getType())
               .eq(CrmApplyTechnologyBiddingRecord::getCrmProjectInformationWarehousingId, crmProjectInformationWarehousingId)
         );
      if (crmApplyTechnologyBiddingRecord != null) {
         list.add(CrmTenderRequirementTypeEnum.SETTLEMENT_METHOD.getType());
      }

      CrmApplyStructuralDesignBiddingRecord crmApplyStructuralDesignBiddingRecord = this.crmApplyStructuralDesignBiddingRecordBiz
         .getOne(
            Wrappers.lambdaQuery(CrmApplyStructuralDesignBiddingRecord.class)
               .eq(CrmApplyStructuralDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               .eq(CrmApplyStructuralDesignBiddingRecord::getCrmProjectInformationWarehousingId, crmProjectInformationWarehousingId)
         );
      if (crmApplyStructuralDesignBiddingRecord != null) {
         list.add(CrmTenderRequirementTypeEnum.STRUCTURAL_DESIGN_TARGET.getType());
      }

      CrmApplyDeepDesignBiddingRecord crmApplyDeepDesignBiddingRecord = this.crmApplyDeepDesignBiddingRecordBiz
         .getOne(
            Wrappers.lambdaQuery(CrmApplyDeepDesignBiddingRecord.class)
               .eq(CrmApplyDeepDesignBiddingRecord::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               .eq(CrmApplyDeepDesignBiddingRecord::getCrmProjectInformationWarehousingId, crmProjectInformationWarehousingId)
         );
      if (crmApplyDeepDesignBiddingRecord != null) {
         list.add(CrmTenderRequirementTypeEnum.DEEPENING_THE_DESIGN_STANDARD.getType());
      }

      return list;
   }

   @Override
   public CrmApplyForBidRecordDetailDTO crmApplyForBidRecordDetailDTO(Long id) {
      CrmApplyForBidRecord crmApplyForBidRecord = this.baseService.getById(id);
      Preconditions.checkArgument(crmApplyForBidRecord != null, "投标申请id不存在");
      CrmProjectInformationWarehousing projectInformationWarehousing = this.crmProjectInformationWarehousingService
         .getById(crmApplyForBidRecord.getCrmProjectInformationWarehousingId());
      Preconditions.checkArgument(projectInformationWarehousing != null, "项目备案id不存在");
      CrmEnterpriseWarehousing crmEnterpriseWarehousing = null;
      if (projectInformationWarehousing.getCrmEnterpriseWarehousingId() != null) {
         crmEnterpriseWarehousing = this.crmEnterpriseWarehousingBiz.getById(projectInformationWarehousing.getCrmEnterpriseWarehousingId());
      }

      CrmApplyForBidRecordDetailDTO crmApplyForBidRecordDetailDTO = BeanUtil.copy(crmApplyForBidRecord, CrmApplyForBidRecordDetailDTO.class);
      crmApplyForBidRecordDetailDTO.setBiddingPlatformName(crmApplyForBidRecord.getCompanyName());
      if (crmEnterpriseWarehousing != null) {
         crmApplyForBidRecordDetailDTO.setCrmEnterpriseWarehousingName(crmEnterpriseWarehousing.getBusinessName());
      }

      crmApplyForBidRecordDetailDTO.setProjectName(projectInformationWarehousing.getProjectName());
      crmApplyForBidRecordDetailDTO.setProjectSerialNumber(projectInformationWarehousing.getSerialNumber());
      crmApplyForBidRecordDetailDTO.setCreateUserName(this.userService.getById(crmApplyForBidRecord.getCreateUserId()).getName());
      if (crmApplyForBidRecord.getInformantUserId() != null) {
         crmApplyForBidRecordDetailDTO.setInformantUserName(this.userService.getById(crmApplyForBidRecord.getInformantUserId()).getName());
      }

      if (crmApplyForBidRecord.getDepartmentId() != null) {
         crmApplyForBidRecordDetailDTO.setDepartmentName(this.departmentService.getDepartmentById(crmApplyForBidRecord.getDepartmentId()).getName());
      }

      crmApplyForBidRecordDetailDTO.setProjectName(projectInformationWarehousing.getProjectName());
      crmApplyForBidRecordDetailDTO.setProjectSerialNumber(projectInformationWarehousing.getSerialNumber());
      if (crmApplyForBidRecord.getBiddingMethodId() != null) {
         crmApplyForBidRecordDetailDTO.setBiddingMethodName(this.crmTenderRequestConfigBiz.getById(crmApplyForBidRecord.getBiddingMethodId()).getName());
      }

      if (crmApplyForBidRecord.getTenderSubmissionMethodId() != null) {
         crmApplyForBidRecordDetailDTO.setTenderSubmissionMethodName(
            this.crmTenderRequestConfigBiz.getById(crmApplyForBidRecord.getTenderSubmissionMethodId()).getName()
         );
      }

      if (crmApplyForBidRecord.getBidEvaluationMethodId() != null) {
         crmApplyForBidRecordDetailDTO.setBidEvaluationMethodName(
            this.crmTenderRequestConfigBiz.getById(crmApplyForBidRecord.getBidEvaluationMethodId()).getName()
         );
      }

      if (crmApplyForBidRecord.getBidEvaluationMethodId() != null) {
         crmApplyForBidRecordDetailDTO.setSettlementMethodName(
            this.crmTenderRequestConfigBiz.getById(crmApplyForBidRecord.getBidEvaluationMethodId()).getName()
         );
      }

      if (crmApplyForBidRecord.getTypeOfPerformanceBondId() != null) {
         crmApplyForBidRecordDetailDTO.setTypeOfPerformanceBondName(
            this.crmTenderRequestConfigBiz.getById(crmApplyForBidRecord.getTypeOfPerformanceBondId()).getName()
         );
      }

      String crmTenderRequirementTypeEnum = this.appendTenderRequirement(projectInformationWarehousing);
      crmApplyForBidRecordDetailDTO.setTenderRequirement(crmTenderRequirementTypeEnum);
      if (com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank(crmApplyForBidRecord.getAttachmentIds())) {
         crmApplyForBidRecordDetailDTO.setAttachmentDTOList(this.attachmentService.listByIds(crmApplyForBidRecord.getAttachmentIds()));
      }

      return crmApplyForBidRecordDetailDTO;
   }

   private String appendTenderRequirement(CrmProjectInformationWarehousing projectInformationWarehousing) {
      String result = "";
      if (projectInformationWarehousing.getIsBiddingMethod()) {
         result = "商务标";
      }

      if (projectInformationWarehousing.getIsSettlementMethod()) {
         result = result + "/技术标";
      }

      if (projectInformationWarehousing.getIsTypeOfPerformanceBond()) {
         result = result + "/设计标";
      }

      return result;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean projectFilingApproval(CrmAuditCommonDTO crmAuditCommonDTO) {
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(crmAuditCommonDTO.getApproveRecordId());
      Boolean result = this.wmsApproveRecordService
         .commonApproveStep(
            crmAuditCommonDTO.getDataId(), crmAuditCommonDTO.getDecision(), crmAuditCommonDTO.getOpinion(), wmsApproveRecord.getSerialNumber(), null
         );
      CrmApplyForBidRecord crmApplyForBidRecord = this.baseService.getById(crmAuditCommonDTO.getDataId());
      if (result) {
         if (crmAuditCommonDTO.getDecision() == 2) {
            CrmProjectInformationWarehousing crmProjectInformationWarehousing = this.crmProjectInformationWarehousingService
               .getById(crmApplyForBidRecord.getCrmProjectInformationWarehousingId());
            crmProjectInformationWarehousing.setCrmProjectScheduleTypeEnum(CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType());
            crmApplyForBidRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.PASS.getType());
            this.crmProjectInformationWarehousingService.updateById(crmProjectInformationWarehousing);
         }

         if (crmAuditCommonDTO.getDecision() == 4) {
            crmApplyForBidRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.FAIL.getType());
         }

         this.baseService.updateById(crmApplyForBidRecord);
      }

      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public Boolean projectApplyForBidQuash(Long id) {
      CrmApplyForBidRecord forBidRecord = this.baseService.getById(id);
      Preconditions.checkArgument(forBidRecord != null, "投标申请备案不存在");
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(forBidRecord.getApproveRecordId());
      Preconditions.checkArgument(wmsApproveRecord != null, "投标申请审批不存在");
      wmsApproveRecord.setReviewStatus(ReviewStatusEnum.CANCEL.getType());
      this.baseService.removeById(forBidRecord.getId());
      this.wmsApproveRecordService.updateById(wmsApproveRecord);
      this.wmsApproveRecordService.revocation(wmsApproveRecord.getId());
      return Boolean.TRUE;
   }

   private static final class CustomOaRequest {
      private final String requestId;
      private final Integer approveProcessType;

      private CustomOaRequest(String requestId, Integer approveProcessType) {
         this.requestId = requestId;
         this.approveProcessType = approveProcessType;
      }
   }
}
