package com.hzchum.scim.mes.building.core.service.impl.factory;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingGroupsTeamLink;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingGroupsTeamLinkService;
import com.hzchum.scim.mes.building.core.mapper.factory.MesBuildingGroupsTeamLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingGroupsTeamLinkServiceImpl
   extends ServiceImpl<MesBuildingGroupsTeamLinkMapper, MesBuildingGroupsTeamLink>
   implements MesBuildingGroupsTeamLinkService {
}
