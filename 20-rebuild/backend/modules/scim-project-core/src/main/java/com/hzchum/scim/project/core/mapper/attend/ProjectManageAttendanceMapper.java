package com.hzchum.scim.project.core.mapper.attend;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.project.core.api.pojo._doModel.attend.ProjectManageAttendance;
import com.hzchum.scim.project.core.api.pojo.dto.attend.ProjectManageAttendanceSummaryDTO;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectManageAttendanceMapper extends BaseMapper<ProjectManageAttendance> {
   List<ProjectManageAttendanceSummaryDTO> getAttendanceSummary(
      @Param("projectId") Long projectId, @Param("supplierId") Long supplierId, @Param("monthDate") LocalDate monthDate
   );

   HashMap<String, Integer> getUserAttendanceSummary(@Param("rosterId") Long rosterId);
}
