package com.hzchum.scim.mes.building.core.api.service.scheduling;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNeedMachinePartScheduling;
import java.time.LocalDateTime;
import java.util.List;

public interface MesBuildingNeedMachinePartSchedulingService extends IService<MesBuildingNeedMachinePartScheduling> {
   List<MesBuildingNeedMachinePartScheduling> listByMonthList(List<LocalDateTime> monthList);
}
