package com.hzchum.scim.system.core.api.biz;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.system.core.api.pojo._do.ProjectInspectionUserLinkRecord;
import com.hzchum.scim.system.core.api.pojo.request.ProjectInspectionUserLinkRecordDTOParam;

public interface ProjectInspectionUserLinkRecordBiz extends IBiz<ProjectInspectionUserLinkRecord> {
   ProjectInspectionUserLinkRecord getMostNewRecordByMasterTableId(Long masterId);

   ProjectInspectionUserLinkRecord createRecord(ProjectInspectionUserLinkRecordDTOParam recordDTOParam);
}
