package com.hzchum.scim.crm.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.oa.OAResultWorkFlowStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo.dtoParam.oa.OaWorkflowDTOParam;
import com.hzchum.scim.common.core.api.service.zhongnanoa.OaWorkflowResultHandler;
import com.hzchum.scim.crm.core.api.enums.CrmCheckStatusEnum;
import com.hzchum.scim.crm.core.api.enums.CrmInformationValidityPeriodConfigEnum;
import com.hzchum.scim.crm.core.api.pojo._do.CrmInformationValidityPeriodConfig;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectInformationWarehousing;
import com.hzchum.scim.crm.core.api.service.CrmInformationValidityPeriodConfigService;
import com.hzchum.scim.crm.core.api.service.CrmProjectInformationWarehousingService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CrmProjectInformationOaResultHandler implements OaWorkflowResultHandler {
   private static final String WORKFLOW_NAME = "CRM项目信息登记立项流程（初鸣）";
   @Resource
   private CrmProjectInformationWarehousingService projectInformationWarehousingService;
   @Resource
   private CrmInformationValidityPeriodConfigService informationValidityPeriodConfigService;

   @Override
   public boolean supports(String workflowName) {
      return "CRM项目信息登记立项流程（初鸣）".equals(workflowName);
   }

   @Override
   public void handle(OaWorkflowDTOParam workflow, WmsApproveRecord approveRecord) {
      if (ApproveProcessTypeEnumV2.CRM_PROJECT_FILING.getType().equals(approveRecord.getApproveProcessType())) {
         CrmProjectInformationWarehousing project = this.projectInformationWarehousingService.getById(approveRecord.getDataId());
         Preconditions.checkArgument(project != null, "OA项目信息登记关联的CRM项目不存在");
         if (OAResultWorkFlowStatusEnum.PASS.getType().equals(workflow.getApproveStatus())) {
            CrmInformationValidityPeriodConfig validityConfig = this.informationValidityPeriodConfigService
               .getOne(
                  Wrappers.lambdaQuery(CrmInformationValidityPeriodConfig.class)
                     .eq(
                        CrmInformationValidityPeriodConfig::getCrmInformationValidityPeriodConfigEnum,
                        CrmInformationValidityPeriodConfigEnum.INFORMATION_VALIDITY_PERIOD.getType()
                     )
               );
            Preconditions.checkArgument(validityConfig != null, "请先配置项目信息登记有效期");
            project.setCrmCheckStatusEnum(CrmCheckStatusEnum.PASS.getType());
            project.setValidityOfRegistration(validityConfig.getValidityOfRegistration());
         } else {
            project.setCrmCheckStatusEnum(CrmCheckStatusEnum.FAIL.getType());
         }

         this.projectInformationWarehousingService.updateById(project);
      }
   }

   @Override
   public boolean supportsWithdraw(Integer approveProcessType) {
      return ApproveProcessTypeEnumV2.CRM_PROJECT_FILING.getType().equals(approveProcessType);
   }

   @Override
   public boolean supportsApproveProcessType(Integer approveProcessType) {
      return ApproveProcessTypeEnumV2.CRM_PROJECT_FILING.getType().equals(approveProcessType);
   }

   @Override
   public void handleWithdraw(WmsApproveRecord approveRecord) {
      this.projectInformationWarehousingService.removeById(approveRecord.getDataId());
   }
}
