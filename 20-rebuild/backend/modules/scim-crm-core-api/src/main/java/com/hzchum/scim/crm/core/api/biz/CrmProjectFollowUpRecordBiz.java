package com.hzchum.scim.crm.core.api.biz;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectFollowUpRecord;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmAuditCommonDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmFollowUpSimpleListDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmProjectFollowUpRecordDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmprojectInformationWarehousingFollowUpTimesAndDateDTO;
import com.hzchum.scim.crm.core.api.pojo.param.save.CrmProjectFollowUpRecordSaveParam;
import java.util.List;

public interface CrmProjectFollowUpRecordBiz extends IBiz<CrmProjectFollowUpRecord> {
   Boolean saveCrmProjectFollowUpRecord(CrmProjectFollowUpRecordSaveParam copy);

   CrmprojectInformationWarehousingFollowUpTimesAndDateDTO getFollowUpTimesAndDate(Long crmProjectInformationWarehousingId);

   Boolean projectFilingApproval(CrmAuditCommonDTO crmAuditCommonDTO);

   Boolean projectFollowUpQuash(Long id);

   CrmProjectFollowUpRecordDTO getFollowUpDetail(Long id);

   List<CrmFollowUpSimpleListDTO> getFollowUpSimpleList(Long projectId);
}
