package com.hzchum.scim.mes.building.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.MesBuildingMachinePartTeamBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingMachinePartTeam;
import com.hzchum.scim.mes.building.core.api.service.MesBuildingMachinePartTeamService;
import com.hzchum.scim.mes.building.core.mapper.MesBuildingMachinePartTeamMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingMachinePartTeamBizImpl
   extends IBizImpl<MesBuildingMachinePartTeamService, MesBuildingMachinePartTeamMapper, MesBuildingMachinePartTeam>
   implements MesBuildingMachinePartTeamBiz {
}
