package com.hzchum.scim.mes.building.core.api.service.attend;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendance;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendanceOverConfig;
import java.util.List;

public interface MesBuildingAttendanceService extends IService<MesBuildingAttendance> {
   void appendOverTask(MesBuildingAttendanceOverConfig config, List<Long> rosterIds);

   void removeOverTask(MesBuildingAttendanceOverConfig config, List<Long> rosterIds);
}
