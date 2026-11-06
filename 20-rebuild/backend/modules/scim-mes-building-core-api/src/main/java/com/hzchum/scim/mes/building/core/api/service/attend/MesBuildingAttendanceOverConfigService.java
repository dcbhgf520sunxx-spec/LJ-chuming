package com.hzchum.scim.mes.building.core.api.service.attend;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.attend.MesBuildingAttendanceOverConfig;
import java.util.List;

public interface MesBuildingAttendanceOverConfigService extends IService<MesBuildingAttendanceOverConfig> {
   List<MesBuildingAttendanceOverConfig> getListByIdStr(String ids);
}
