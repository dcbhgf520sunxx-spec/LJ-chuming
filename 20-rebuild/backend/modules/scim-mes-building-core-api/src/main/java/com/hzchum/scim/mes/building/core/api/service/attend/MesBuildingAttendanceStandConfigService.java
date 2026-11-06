package com.hzchum.scim.mes.building.core.api.service.attend;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendanceStandConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.laborManagement.MesRoster;

public interface MesBuildingAttendanceStandConfigService extends IService<MesBuildingAttendanceStandConfig> {
   void generateAttendanceTask();

   void saveRosterAttendanceInfo(MesRoster roster);
}
