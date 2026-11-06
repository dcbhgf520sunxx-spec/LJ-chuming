package com.hzchum.scim.mes.building.core.service.impl.task;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MachinePartSchedulingUnProductionDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNeedMachinePartSchedulingUnProduction;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNeedMachinePartSchedulingUnProductionService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingTaskNeedMachinePartSchedulingUnProductionMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingTaskNeedMachinePartSchedulingUnProductionServiceImpl
   extends ServiceImpl<MesBuildingTaskNeedMachinePartSchedulingUnProductionMapper, MesBuildingTaskNeedMachinePartSchedulingUnProduction>
   implements MesBuildingTaskNeedMachinePartSchedulingUnProductionService {
   @Override
   public List<MachinePartSchedulingUnProductionDO> getUnProductionList(
      Long projectId, Long monomerId, Long areaId, Long workshopId, Long productionLineId, Long groupsId, String artifactSerialNumber, String serialNumber
   ) {
      return this.baseMapper.getUnProductionList(projectId, monomerId, areaId, workshopId, productionLineId, groupsId, artifactSerialNumber, serialNumber);
   }
}
