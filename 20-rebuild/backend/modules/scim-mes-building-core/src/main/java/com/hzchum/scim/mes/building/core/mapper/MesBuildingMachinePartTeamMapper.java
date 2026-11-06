package com.hzchum.scim.mes.building.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingMachinePartTeam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingMachinePartTeamDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingPartTeamDTOParam;
import java.util.List;

public interface MesBuildingMachinePartTeamMapper extends BaseMapper<MesBuildingMachinePartTeam> {
   List<MesBuildingMachinePartTeamDTO> machinePartListByCondition(MesBuildingPartTeamDTOParam dtoParam);

   List<MesBuildingMachinePartTeamDTO> machinePartListByConditionNoGroup(MesBuildingPartTeamDTOParam dtoParam);
}
