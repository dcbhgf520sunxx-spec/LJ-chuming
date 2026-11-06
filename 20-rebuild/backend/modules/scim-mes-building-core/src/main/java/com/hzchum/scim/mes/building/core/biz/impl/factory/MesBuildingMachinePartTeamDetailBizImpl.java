package com.hzchum.scim.mes.building.core.biz.impl.factory;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.team.MesBuildingMachinePartTeamDetailBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingMachinePartTeamDetail;
import com.hzchum.scim.mes.building.core.api.service.team.MesBuildingMachinePartTeamDetailService;
import com.hzchum.scim.mes.building.core.mapper.factory.MesBuildingMachinePartTeamDetailMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingMachinePartTeamDetailBizImpl
   extends IBizImpl<MesBuildingMachinePartTeamDetailService, MesBuildingMachinePartTeamDetailMapper, MesBuildingMachinePartTeamDetail>
   implements MesBuildingMachinePartTeamDetailBiz {
}
