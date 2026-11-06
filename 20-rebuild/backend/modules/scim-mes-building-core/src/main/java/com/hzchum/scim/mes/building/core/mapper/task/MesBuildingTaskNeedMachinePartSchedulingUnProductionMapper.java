package com.hzchum.scim.mes.building.core.mapper.task;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MachinePartSchedulingUnProductionDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNeedMachinePartSchedulingUnProduction;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingTaskNeedMachinePartSchedulingUnProductionMapper extends BaseMapper<MesBuildingTaskNeedMachinePartSchedulingUnProduction> {
   List<MachinePartSchedulingUnProductionDO> getUnProductionList(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("workshopId") Long workshopId,
      @Param("productionLineId") Long productionLineId,
      @Param("groupsId") Long groupsId,
      @Param("artifactSerialNumber") String artifactSerialNumber,
      @Param("serialNumber") String serialNumber
   );
}
