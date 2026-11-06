package com.hzchum.scim.mes.building.core.api.biz.task;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNeedMachinePartSchedulingUnProduction;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MachinePartSchedulingUnProductionDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MachinePartSchedulingUnProductionParam;
import java.util.List;

public interface MesBuildingTaskNeedMachinePartSchedulingUnProductionBiz extends IBiz<MesBuildingTaskNeedMachinePartSchedulingUnProduction> {
   Boolean saveUnProduction(List<MachinePartSchedulingUnProductionParam> paramList);

   PageVO<MachinePartSchedulingUnProductionDTO> getUnProductionPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      Long productionLineId,
      Long groupsId,
      String artifactSerialNumber,
      String serialNumber,
      Integer pageNumber,
      Integer pageSize
   );

   List<MachinePartSchedulingUnProductionDTO> getUnProductionList(
      Long projectId, Long monomerId, Long areaId, Long workshopId, Long productionLineId, Long groupsId, String artifactSerialNumber, String serialNumber
   );

   Boolean updateUnProduction(Long id, Integer quantity);
}
