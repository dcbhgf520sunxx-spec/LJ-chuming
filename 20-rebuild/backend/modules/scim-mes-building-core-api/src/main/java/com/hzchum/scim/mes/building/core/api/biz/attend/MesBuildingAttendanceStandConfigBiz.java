package com.hzchum.scim.mes.building.core.api.biz.attend;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendanceStandConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.attend.MesBuildingAttendanceStandConfigDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.attend.MesBuildingAttendanceStandConfigDTO;

public interface MesBuildingAttendanceStandConfigBiz extends IBiz<MesBuildingAttendanceStandConfig> {
   boolean editStandConfig(MesBuildingAttendanceStandConfigDTOParam param);

   MesBuildingAttendanceStandConfigDTO getStandConfig();
}
