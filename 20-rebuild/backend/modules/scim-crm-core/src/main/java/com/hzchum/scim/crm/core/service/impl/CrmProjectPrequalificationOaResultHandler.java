package com.hzchum.scim.crm.core.service.impl;

import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.oa.OAResultWorkFlowStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaWorkflowDTOParam;
import com.hzchum.scim.common.core.api.service.zhongnanoa.OaWorkflowResultHandler;
import com.hzchum.scim.crm.core.api.enums.CrmCheckStatusEnum;
import com.hzchum.scim.crm.core.api.enums.CrmProjectScheduleTypeEnum;
import com.hzchum.scim.crm.core.api.pojo._do.CrmPrequalificationRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectInformationWarehousing;
import com.hzchum.scim.crm.core.api.service.CrmPrequalificationRecordService;
import com.hzchum.scim.crm.core.api.service.CrmProjectInformationWarehousingService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CrmProjectPrequalificationOaResultHandler implements OaWorkflowResultHandler {
   private static final String WORKFLOW_NAME = "CRM项目资格预审流程（初鸣）";
   @Resource
   private CrmPrequalificationRecordService prequalificationRecordService;
   @Resource
   private CrmProjectInformationWarehousingService projectInformationWarehousingService;

   @Override
   public boolean supports(String workflowName) {
      return "CRM项目资格预审流程（初鸣）".equals(workflowName);
   }

   @Override
   public void handle(OaWorkflowDTOParam workflow, WmsApproveRecord approveRecord) {
      if (ApproveProcessTypeEnumV2.CRM_PRELIMINARY.getType().equals(approveRecord.getApproveProcessType())) {
         CrmPrequalificationRecord prequalificationRecord = this.prequalificationRecordService.getById(approveRecord.getDataId());
         Preconditions.checkArgument(prequalificationRecord != null, "OA项目资格预审关联的预审记录不存在");
         if (OAResultWorkFlowStatusEnum.PASS.getType().equals(workflow.getApproveStatus())) {
            CrmProjectInformationWarehousing project = this.projectInformationWarehousingService
               .getById(prequalificationRecord.getCrmProjectInformationWarehousingId());
            Preconditions.checkArgument(project != null, "OA项目资格预审关联的CRM项目不存在");
            if (CrmProjectScheduleTypeEnum.FILING_STATUS.getType().equals(project.getCrmProjectScheduleTypeEnum())
               || CrmProjectScheduleTypeEnum.FOLLOW_UP_STATUS.getType().equals(project.getCrmProjectScheduleTypeEnum())) {
               project.setCrmProjectScheduleTypeEnum(CrmProjectScheduleTypeEnum.PREQUALIFICATION_STATUS.getType());
               this.projectInformationWarehousingService.updateById(project);
            }

            prequalificationRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.PASS.getType());
         } else {
            prequalificationRecord.setCrmCheckStatusEnum(CrmCheckStatusEnum.FAIL.getType());
         }

         this.prequalificationRecordService.updateById(prequalificationRecord);
      }
   }

   @Override
   public boolean supportsWithdraw(Integer approveProcessType) {
      return ApproveProcessTypeEnumV2.CRM_PRELIMINARY.getType().equals(approveProcessType);
   }

   @Override
   public boolean supportsApproveProcessType(Integer approveProcessType) {
      return ApproveProcessTypeEnumV2.CRM_PRELIMINARY.getType().equals(approveProcessType);
   }

   @Override
   public void handleWithdraw(WmsApproveRecord approveRecord) {
      this.prequalificationRecordService.removeById(approveRecord.getDataId());
   }
}
