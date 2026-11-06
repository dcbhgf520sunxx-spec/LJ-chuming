package com.hzchum.scim.crm.core.service.impl;

import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.oa.OAResultWorkFlowStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaWorkflowDTOParam;
import com.hzchum.scim.common.core.api.service.zhongnanoa.OaWorkflowResultHandler;
import com.hzchum.scim.crm.core.api.enums.CrmCheckStatusEnum;
import com.hzchum.scim.crm.core.api.enums.CrmProjectScheduleTypeEnum;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyBusinessBiddingRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyDeepDesignBiddingRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyForBidRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyStructuralDesignBiddingRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyTechnologyBiddingRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectInformationWarehousing;
import com.hzchum.scim.crm.core.api.service.CrmApplyBusinessBiddingRecordService;
import com.hzchum.scim.crm.core.api.service.CrmApplyDeepDesignBiddingRecordService;
import com.hzchum.scim.crm.core.api.service.CrmApplyForBidRecordService;
import com.hzchum.scim.crm.core.api.service.CrmApplyStructuralDesignBiddingRecordService;
import com.hzchum.scim.crm.core.api.service.CrmApplyTechnologyBiddingRecordService;
import com.hzchum.scim.crm.core.api.service.CrmProjectInformationWarehousingService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CrmProjectBidApplicationOaResultHandler implements OaWorkflowResultHandler {
   private static final String WORKFLOW_NAME = "CRM项目投标申请流程（初鸣）";
   @Resource
   private CrmApplyBusinessBiddingRecordService businessBiddingRecordService;
   @Resource
   private CrmApplyTechnologyBiddingRecordService technologyBiddingRecordService;
   @Resource
   private CrmApplyStructuralDesignBiddingRecordService structuralDesignBiddingRecordService;
   @Resource
   private CrmApplyDeepDesignBiddingRecordService deepDesignBiddingRecordService;
   @Resource
   private CrmApplyForBidRecordService applyForBidRecordService;
   @Resource
   private CrmProjectInformationWarehousingService projectInformationWarehousingService;

   @Override
   public boolean supports(String workflowName) {
      return "CRM项目投标申请流程（初鸣）".equals(workflowName);
   }

   @Override
   public void handle(OaWorkflowDTOParam workflow, WmsApproveRecord approveRecord) {
      Long projectId = this.updateBidRecordStatus(
         approveRecord,
         OAResultWorkFlowStatusEnum.PASS.getType().equals(workflow.getApproveStatus()) ? CrmCheckStatusEnum.PASS.getType() : CrmCheckStatusEnum.FAIL.getType()
      );
      if (OAResultWorkFlowStatusEnum.PASS.getType().equals(workflow.getApproveStatus())) {
         CrmProjectInformationWarehousing project = this.projectInformationWarehousingService.getById(projectId);
         Preconditions.checkArgument(project != null, "OA项目投标申请关联的CRM项目不存在");
         project.setCrmProjectScheduleTypeEnum(CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType());
         this.projectInformationWarehousingService.updateById(project);
      }
   }

   @Override
   public boolean supportsWithdraw(Integer approveProcessType) {
      return this.supportsCustomBidType(approveProcessType);
   }

   @Override
   public boolean supportsApproveProcessType(Integer approveProcessType) {
      return this.supportsCustomBidType(approveProcessType);
   }

   @Override
   public void handleWithdraw(WmsApproveRecord approveRecord) {
      Integer approveProcessType = approveRecord.getApproveProcessType();
      if (ApproveProcessTypeEnumV2.CRM_TENDER.getType().equals(approveProcessType)) {
         this.applyForBidRecordService.removeById(approveRecord.getDataId());
      } else if (ApproveProcessTypeEnumV2.CRM_BUSINESS_BIDDING.getType().equals(approveProcessType)) {
         this.businessBiddingRecordService.removeById(approveRecord.getDataId());
      } else if (ApproveProcessTypeEnumV2.CRM_TECHNOLOGY_BIDDING.getType().equals(approveProcessType)) {
         this.technologyBiddingRecordService.removeById(approveRecord.getDataId());
      } else if (ApproveProcessTypeEnumV2.CRM_STRUCTURAL_DESIGN_BIDDING.getType().equals(approveProcessType)) {
         this.structuralDesignBiddingRecordService.removeById(approveRecord.getDataId());
      } else if (ApproveProcessTypeEnumV2.CRM_DEEP_DESIGN_BIDDING.getType().equals(approveProcessType)) {
         this.deepDesignBiddingRecordService.removeById(approveRecord.getDataId());
      }
   }

   private Long updateBidRecordStatus(WmsApproveRecord approveRecord, Integer status) {
      Integer approveProcessType = approveRecord.getApproveProcessType();
      if (ApproveProcessTypeEnumV2.CRM_TENDER.getType().equals(approveProcessType)) {
         CrmApplyForBidRecord record = this.applyForBidRecordService.getById(approveRecord.getDataId());
         Preconditions.checkArgument(record != null, "OA项目投标申请关联的投标记录不存在");
         record.setCrmCheckStatusEnum(status);
         Preconditions.checkArgument(this.applyForBidRecordService.updateById(record), "投标申请审批结果回写失败");
         return record.getCrmProjectInformationWarehousingId();
      } else if (ApproveProcessTypeEnumV2.CRM_BUSINESS_BIDDING.getType().equals(approveProcessType)) {
         CrmApplyBusinessBiddingRecord record = this.businessBiddingRecordService.getById(approveRecord.getDataId());
         Preconditions.checkArgument(record != null, "OA项目投标申请关联的商务标记录不存在");
         record.setCrmCheckStatusEnum(status);
         Preconditions.checkArgument(this.businessBiddingRecordService.updateById(record), "商务标审批结果回写失败");
         return record.getCrmProjectInformationWarehousingId();
      } else if (ApproveProcessTypeEnumV2.CRM_TECHNOLOGY_BIDDING.getType().equals(approveProcessType)) {
         CrmApplyTechnologyBiddingRecord record = this.technologyBiddingRecordService.getById(approveRecord.getDataId());
         Preconditions.checkArgument(record != null, "OA项目投标申请关联的技术标记录不存在");
         record.setCrmCheckStatusEnum(status);
         Preconditions.checkArgument(this.technologyBiddingRecordService.updateById(record), "技术标审批结果回写失败");
         return record.getCrmProjectInformationWarehousingId();
      } else if (ApproveProcessTypeEnumV2.CRM_STRUCTURAL_DESIGN_BIDDING.getType().equals(approveProcessType)) {
         CrmApplyStructuralDesignBiddingRecord record = this.structuralDesignBiddingRecordService.getById(approveRecord.getDataId());
         Preconditions.checkArgument(record != null, "OA项目投标申请关联的结构设计标记录不存在");
         record.setCrmCheckStatusEnum(status);
         Preconditions.checkArgument(this.structuralDesignBiddingRecordService.updateById(record), "结构设计标审批结果回写失败");
         return record.getCrmProjectInformationWarehousingId();
      } else if (ApproveProcessTypeEnumV2.CRM_DEEP_DESIGN_BIDDING.getType().equals(approveProcessType)) {
         CrmApplyDeepDesignBiddingRecord record = this.deepDesignBiddingRecordService.getById(approveRecord.getDataId());
         Preconditions.checkArgument(record != null, "OA项目投标申请关联的深化设计标记录不存在");
         record.setCrmCheckStatusEnum(status);
         Preconditions.checkArgument(this.deepDesignBiddingRecordService.updateById(record), "深化设计标审批结果回写失败");
         return record.getCrmProjectInformationWarehousingId();
      } else {
         throw new IllegalArgumentException("OA项目投标申请审批类型不正确");
      }
   }

   private boolean supportsCustomBidType(Integer approveProcessType) {
      return ApproveProcessTypeEnumV2.CRM_TENDER.getType().equals(approveProcessType)
         || ApproveProcessTypeEnumV2.CRM_BUSINESS_BIDDING.getType().equals(approveProcessType)
         || ApproveProcessTypeEnumV2.CRM_TECHNOLOGY_BIDDING.getType().equals(approveProcessType)
         || ApproveProcessTypeEnumV2.CRM_STRUCTURAL_DESIGN_BIDDING.getType().equals(approveProcessType)
         || ApproveProcessTypeEnumV2.CRM_DEEP_DESIGN_BIDDING.getType().equals(approveProcessType);
   }
}
