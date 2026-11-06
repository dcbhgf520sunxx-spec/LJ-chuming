package com.hzchum.scim.system.core.api.biz;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.system.core.api.pojo._do.ProjectInspectionTaskRecord;
import com.hzchum.scim.system.core.api.pojo.dto.safety.inspection.ProjectInspectionTaskInfoDTO;
import com.hzchum.scim.system.core.api.pojo.dto.safety.inspection.ProjectInspectionTaskRecordDTO;
import com.hzchum.scim.system.core.api.pojo.request.ProjectInspectionTaskRecordDTOParam;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public interface ProjectInspectionTaskRecordBiz extends IBiz<ProjectInspectionTaskRecord> {
   boolean scanningCode(ProjectInspectionTaskRecordDTOParam projectInspectionTaskRecordDTOParam);

   ProjectInspectionTaskRecordDTO getInspectionTask();

   HashMap<String, Integer> getInspectionSummaryByUserId(Long userId, Integer inspectionSiteOptionType);

   List<ProjectInspectionTaskInfoDTO> getInspectionTaskInfo(Long userId, LocalDate startDate, LocalDate endDate, Integer inspectionSiteOptionType);

   ProjectInspectionTaskRecordDTO getInspectionTaskDetail(Long userId, LocalDate date, Integer inspectionSiteOptionType);
}
