package com.hzchum.scim.mes.building.core.mapper.attend;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendance;
import com.hzchum.scim.mes.building.core.api.pojo._dto.attend.MesAttendanceSummaryDTO;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingAttendanceMapper extends BaseMapper<MesBuildingAttendance> {
   List<MesAttendanceSummaryDTO> getAttendanceSummary(@Param("monthDate") LocalDate monthDate, @Param("supplierId") Long supplierId);

   HashMap<String, Integer> getUserAttendanceSummary(@Param("rosterId") Long rosterId);
}
