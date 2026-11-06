package com.hzchum.scim.mes.building.core.api.service.task;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MachinePartSchedulingUnProductionDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNeedMachinePartSchedulingUnProduction;
import java.util.List;

public interface MesBuildingTaskNeedMachinePartSchedulingUnProductionService extends IService<MesBuildingTaskNeedMachinePartSchedulingUnProduction> {
   List<MachinePartSchedulingUnProductionDO> getUnProductionList(
      Long projectId, Long monomerId, Long areaId, Long workshopId, Long productionLineId, Long groupsId, String artifactSerialNumber, String serialNumber
   );
}
