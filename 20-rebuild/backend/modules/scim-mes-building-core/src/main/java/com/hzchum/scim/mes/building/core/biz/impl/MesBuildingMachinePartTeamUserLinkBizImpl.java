package com.hzchum.scim.mes.building.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.MesBuildingMachinePartTeamUserLinkBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingMachinePartTeamUserLink;
import com.hzchum.scim.mes.building.core.api.service.MesBuildingMachinePartTeamUserLinkService;
import com.hzchum.scim.mes.building.core.mapper.MesBuildingMachinePartTeamUserLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingMachinePartTeamUserLinkBizImpl
   extends IBizImpl<MesBuildingMachinePartTeamUserLinkService, MesBuildingMachinePartTeamUserLinkMapper, MesBuildingMachinePartTeamUserLink>
   implements MesBuildingMachinePartTeamUserLinkBiz {
}
