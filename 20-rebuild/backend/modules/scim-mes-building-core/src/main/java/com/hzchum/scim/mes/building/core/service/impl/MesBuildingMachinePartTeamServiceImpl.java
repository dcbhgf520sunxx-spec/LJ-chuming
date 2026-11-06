package com.hzchum.scim.mes.building.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingMachinePartTeam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingMachinePartTeamDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingPartTeamDTOParam;
import com.hzchum.scim.mes.building.core.api.service.MesBuildingMachinePartTeamService;
import com.hzchum.scim.mes.building.core.mapper.MesBuildingMachinePartTeamMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingMachinePartTeamServiceImpl
   extends ServiceImpl<MesBuildingMachinePartTeamMapper, MesBuildingMachinePartTeam>
   implements MesBuildingMachinePartTeamService {
   @Override
   public List<MesBuildingMachinePartTeamDTO> machinePartListByCondition(MesBuildingPartTeamDTOParam dtoParam) {
      return this.baseMapper.machinePartListByCondition(dtoParam);
   }

   @Override
   public List<MesBuildingMachinePartTeamDTO> machinePartListByConditionNoGroup(MesBuildingPartTeamDTOParam dtoParam) {
      return this.baseMapper.machinePartListByConditionNoGroup(dtoParam);
   }
}
