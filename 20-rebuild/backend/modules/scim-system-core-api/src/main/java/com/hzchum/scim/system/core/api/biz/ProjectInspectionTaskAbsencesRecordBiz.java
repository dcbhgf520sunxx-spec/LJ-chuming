package com.hzchum.scim.system.core.api.biz;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.system.core.api.pojo._do.ProjectInspectionTaskAbsencesRecord;

public interface ProjectInspectionTaskAbsencesRecordBiz extends IBiz<ProjectInspectionTaskAbsencesRecord> {
   void generateInspectionTaskAbsencesRecord(Long projectInspectionUserId);
}
