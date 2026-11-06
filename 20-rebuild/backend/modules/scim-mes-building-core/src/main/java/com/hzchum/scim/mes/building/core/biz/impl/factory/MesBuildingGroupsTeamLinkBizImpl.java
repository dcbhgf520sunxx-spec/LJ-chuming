package com.hzchum.scim.mes.building.core.biz.impl.factory;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingGroupsTeamLinkBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingGroupsTeamLink;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingGroupsTeamLinkService;
import com.hzchum.scim.mes.building.core.mapper.factory.MesBuildingGroupsTeamLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingGroupsTeamLinkBizImpl
   extends IBizImpl<MesBuildingGroupsTeamLinkService, MesBuildingGroupsTeamLinkMapper, MesBuildingGroupsTeamLink>
   implements MesBuildingGroupsTeamLinkBiz {
}
