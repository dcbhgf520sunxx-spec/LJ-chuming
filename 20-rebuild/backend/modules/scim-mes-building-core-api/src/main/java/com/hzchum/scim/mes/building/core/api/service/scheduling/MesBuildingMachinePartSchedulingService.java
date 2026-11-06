package com.hzchum.scim.mes.building.core.api.service.scheduling;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingMachinePartSchedulingDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingMachinePartScheduling;
import java.time.LocalDateTime;
import java.util.List;

public interface MesBuildingMachinePartSchedulingService extends IService<MesBuildingMachinePartScheduling> {
   List<MesBuildingMachinePartSchedulingDO> getMachinePartSchedulingRecordList(Integer issueStatusEnum, LocalDateTime dateTime);

   int passDeleteCount(LocalDateTime now);
}
