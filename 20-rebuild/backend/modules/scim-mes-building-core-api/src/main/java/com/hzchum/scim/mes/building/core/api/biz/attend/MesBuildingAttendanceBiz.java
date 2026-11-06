package com.hzchum.scim.mes.building.core.api.biz.attend;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendance;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.attend.MesBuildingAttendanceDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.attend.MesAttendanceDayDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.attend.MesAttendanceMonthDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.attend.MesAttendanceSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.attend.MesTodayAttendanceConfigDTO;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

public interface MesBuildingAttendanceBiz extends IBiz<MesBuildingAttendance> {
   MesTodayAttendanceConfigDTO getTodayConfig(Boolean hasBaseInfo);

   boolean saveAttendance(MesBuildingAttendanceDTOParam param);

   PageVO<MesAttendanceDayDetailsDTO> getAttendanceDayDetails(
      Long deptId, String wokeType, String name, LocalDate startDate, LocalDate endDate, Boolean isStand, Integer pageNumber, Integer pageSize
   );

   void getAttendanceDayDetailsDownload(Long deptId, String workType, String name, LocalDate startDate, LocalDate endDate, Boolean isStand);

   List<MesAttendanceSummaryDTO> getAttendanceSummary(LocalDate monthDate, Long supplierId);

   PageVO<MesAttendanceDayDetailsDTO> getCardDetails(LocalDate dayDate, Long supplierId, Boolean isStand, Integer pageNumber, Integer pageSize);

   void getCardDetailsDownload(LocalDate dayDate, Long supplierId, Boolean isStand);

   HashMap<String, Integer> getUserAttendanceSummary();

   List<MesAttendanceDayDetailsDTO> getUserAttendanceDayDetails(LocalDate monthDate);

   PageVO<MesAttendanceMonthDetailsDTO> getAttendanceMonthDetails(LocalDate monthDate, Integer pageNumber, Integer pageSize);

   void getAttendanceMonthDetailsDownload(LocalDate monthDate);
}
