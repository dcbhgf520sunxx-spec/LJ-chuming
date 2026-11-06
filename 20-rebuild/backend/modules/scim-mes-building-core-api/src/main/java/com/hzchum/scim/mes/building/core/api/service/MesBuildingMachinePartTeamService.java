package com.hzchum.scim.mes.building.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingMachinePartTeam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingMachinePartTeamDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingPartTeamDTOParam;
import java.util.List;

public interface MesBuildingMachinePartTeamService extends IService<MesBuildingMachinePartTeam> {
   List<MesBuildingMachinePartTeamDTO> machinePartListByCondition(MesBuildingPartTeamDTOParam dtoParam);

   List<MesBuildingMachinePartTeamDTO> machinePartListByConditionNoGroup(MesBuildingPartTeamDTOParam dtoParam);
}
