package com.hzchum.scim.project.core.api.biz.attend;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.project.core.api.pojo._doModel.attend.ProjectManageAttendance;
import com.hzchum.scim.project.core.api.pojo.dto.attend.ProjectManageAttendanceDayDetailsDTO;
import com.hzchum.scim.project.core.api.pojo.dto.attend.ProjectManageAttendanceMonthDetailsDTO;
import com.hzchum.scim.project.core.api.pojo.dto.attend.ProjectManageAttendanceSummaryDTO;
import com.hzchum.scim.project.core.api.pojo.dto.attend.ProjectManageTodayAttendanceConfig;
import com.hzchum.scim.project.core.api.pojo.dtoParam.put.ProjectManageAttendanceDTOParam;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public interface ProjectManageAttendanceBiz extends IBiz<ProjectManageAttendance> {
   boolean saveAttendance(ProjectManageAttendanceDTOParam param);

   ProjectManageTodayAttendanceConfig getUserConfig(Long projectId);

   List<ProjectManageAttendanceSummaryDTO> getAttendanceSummary(Long projectId, Long supplierId, LocalDate monthDate);

   PageVO<ProjectManageAttendanceDayDetailsDTO> getAttendanceDayDetails(
      Boolean isSummaryDetail, Long projectId, Long supplierId, LocalDate dayDate, LocalDate startDate, LocalDate endDate, Integer pageNumber, Integer pageSize
   );

   void getAttendanceDayDetailsDownload(Boolean isSummaryDetail, Long projectId, Long supplierId, LocalDate monthDate, LocalDate startDate, LocalDate endDate);

   PageVO<ProjectManageAttendanceMonthDetailsDTO> getAttendanceMonthDetails(Long projectId, LocalDate monthDate, Integer pageNumber, Integer pageSize);

   void getAttendanceMonthDetailsDownload(Long projectId, LocalDate monthDate);

   HashMap<String, Integer> getUserAttendanceSummary();

   List<ProjectManageAttendanceDayDetailsDTO> getUserAttendanceDayDetails(LocalDate monthDate);
}
