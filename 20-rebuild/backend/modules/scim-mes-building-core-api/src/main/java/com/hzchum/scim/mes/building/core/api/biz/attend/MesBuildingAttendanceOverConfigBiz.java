package com.hzchum.scim.mes.building.core.api.biz.attend;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendanceOverConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.attend.MesBuildingAttendanceOverConfigDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.attend.MesBuildingAttendanceOverConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.DepartmentDTO;
import com.hzchum.scim.system.core.api.pojo.dto.IdAndNameDTO;
import java.time.LocalDate;
import java.util.List;

public interface MesBuildingAttendanceOverConfigBiz extends IBiz<MesBuildingAttendanceOverConfig> {
   List<DepartmentDTO> getRosterDepartmentList();

   List<IdAndNameDTO> getRosterByDepartment(Long deptId);

   boolean editOverConfig(MesBuildingAttendanceOverConfigDTOParam param);

   PageVO<MesBuildingAttendanceOverConfigDTO> getOverConfigPage(LocalDate startDate, LocalDate endDate, Integer pageNumber, Integer pageSize);

   MesBuildingAttendanceOverConfigDTO getOverConfigDetails(Long overConfigId);

   List<MesBuildingAttendanceOverConfigDTO> getUserOverConfigList(LocalDate monthDate);

   boolean delete(Long id);
}
