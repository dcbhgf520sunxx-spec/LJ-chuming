package com.hzchum.scim.mes.building.core.biz.impl.factory;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingGroupsInspectionTeamLinkBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingGroupsInspectionTeamLink;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingGroupsInspectionTeamLinkService;
import com.hzchum.scim.mes.building.core.mapper.factory.MesBuildingGroupsInspectionTeamLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingGroupsInspectionTeamLinkBizImpl
   extends IBizImpl<MesBuildingGroupsInspectionTeamLinkService, MesBuildingGroupsInspectionTeamLinkMapper, MesBuildingGroupsInspectionTeamLink>
   implements MesBuildingGroupsInspectionTeamLinkBiz {
}
