package com.hzchum.scim.crm.core.api.biz;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectAbandonRecord;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmAuditCommonDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmProjectAbandonRecordDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmProjectAbandonRecordSaveParam;

public interface CrmProjectAbandonRecordBiz extends IBiz<CrmProjectAbandonRecord> {
   Boolean saveCrmProjectAbandonRecord(CrmProjectAbandonRecordSaveParam copy);

   Boolean projectAbandonApproval(CrmAuditCommonDTO crmAuditCommonDTO);

   Boolean projectAbandonQuash(Long id);

   CrmProjectAbandonRecordDetailDTO getCrmProjectAbandonRecordDetail(Long id);
}
