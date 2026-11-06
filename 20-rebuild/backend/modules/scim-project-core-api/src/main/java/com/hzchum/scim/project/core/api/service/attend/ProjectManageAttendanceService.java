package com.hzchum.scim.project.core.api.service.attend;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectManageRoster;
import com.hzchum.scim.project.core.api.pojo._doModel.attend.ProjectManageAttendance;
import com.hzchum.scim.project.core.api.pojo._doModel.attend.ProjectManageAttendanceConfig;
import com.hzchum.scim.project.core.api.pojo.dto.attend.ProjectManageAttendanceSummaryDTO;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public interface ProjectManageAttendanceService extends IService<ProjectManageAttendance> {
   void initToDayAttendanceInfo();

   void saveProjectAttendanceInfo(ProjectManageAttendanceConfig config);

   void updateAttendanceInfoCancel(boolean isUpdateClose, boolean isUpdateSupplier, ProjectManageAttendanceConfig config);

   void saveRosterAttendanceInfo(ProjectManageRoster roster);

   void removeRosterAttendanceInfo(ProjectManageRoster roster);

   List<ProjectManageAttendanceSummaryDTO> getAttendanceSummary(Long projectId, Long supplierId, LocalDate monthDate);

   HashMap<String, Integer> getUserAttendanceSummary(Long rosterId);
}
