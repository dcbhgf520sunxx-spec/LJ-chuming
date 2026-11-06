package com.hzchum.scim.crm.core.api.biz;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmPrequalificationRecord;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmAuditCommonDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmPrequalificationRecordDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmPrequalificationRecordSaveParam;

public interface CrmPrequalificationRecordBiz extends IBiz<CrmPrequalificationRecord> {
   Boolean saveCrmPrequalificationRecord(CrmPrequalificationRecordSaveParam copy);

   Boolean projectPrequalificationApproval(CrmAuditCommonDTO crmAuditCommonDTO);

   Boolean projectPrequalificationQuash(Long id);

   CrmPrequalificationRecordDetailDTO getCrmProjectPrequalificationDetailByProjectId(Long id);

   CrmPrequalificationRecordDetailDTO getCrmProjectPrequalificationDetail(Long id);
}
