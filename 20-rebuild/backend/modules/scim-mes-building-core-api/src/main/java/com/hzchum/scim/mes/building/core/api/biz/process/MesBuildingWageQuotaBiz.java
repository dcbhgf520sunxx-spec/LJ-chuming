package com.hzchum.scim.mes.building.core.api.biz.process;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.MesBuildingMachinePartProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.process.MesBuildingWageQuotaDTOParam;
import java.util.List;

public interface MesBuildingWageQuotaBiz {
   Boolean saveWageQuot(MesBuildingWageQuotaDTOParam dtoParam);

   List<MesBuildingMachinePartProcessDTO> machinePartProcessWage(String name);

   PageVO<MesBuildingMachinePartProcessDTO> machinePartProcessWagePage(String name, Integer pageNumber, Integer pageSize);
}
