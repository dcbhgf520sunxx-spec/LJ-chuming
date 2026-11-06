package com.hzchum.scim.crm.core.api.biz;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyForBidRecord;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmApplyForBidRecordDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmApplyForBidRecordDetailDTOV2;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmAuditCommonDTO;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmApplyForBidRecordSaveParam;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmApplyForBidRecordSaveParamV2;
import java.util.List;

public interface CrmApplyForBidRecordBiz extends IBiz<CrmApplyForBidRecord> {
   Boolean saveCrmApplyForBidRecord(CrmApplyForBidRecordSaveParam param);

   Boolean deleteCrmApplyForBidRecord(Long id);

   CrmApplyForBidRecordDetailDTO crmApplyForBidRecordDetailDTO(Long id);

   Boolean projectFilingApproval(CrmAuditCommonDTO crmAuditCommonDTO);

   Boolean projectApplyForBidQuash(Long id);

   CrmApplyForBidRecordDetailDTO crmApplyForBidRecordDetailByProjectId(Long id);

   Boolean saveCrmApplyForBidRecordCustom(CrmApplyForBidRecordSaveParamV2 paramV2);

   CrmApplyForBidRecordDetailDTOV2 crmApplyForBidRecordDetailByProjectIdCustom(Long id, Integer crmTenderRequirementTypeEnum);

   CrmApplyForBidRecordDetailDTOV2 crmApplyForBidRecordDetailDTOCustom(Long id, Integer approveProcessTypeEnumV2);

   Boolean projectFilingApprovalCustom(CrmAuditCommonDTO crmAuditCommonDTO);

   Boolean projectApplyForBidQuashCustom(Long id, Integer approveProcessTypeEnumV2);

   List<Integer> getApprovalAlreadyEnums(Long crmProjectInformationWarehousingId);
}
