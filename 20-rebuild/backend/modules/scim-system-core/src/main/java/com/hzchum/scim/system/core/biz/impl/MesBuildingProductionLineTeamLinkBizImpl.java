package com.hzchum.scim.system.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.system.core.api.biz.MesBuildingProductionLineTeamLinkBiz;
import com.hzchum.scim.system.core.api.pojo._do.MesBuildingProductionLineTeamLink;
import com.hzchum.scim.system.core.api.service.MesBuildingProductionLineTeamLinkService;
import com.hzchum.scim.system.core.mapper.MesBuildingProductionLineTeamLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingProductionLineTeamLinkBizImpl
   extends IBizImpl<MesBuildingProductionLineTeamLinkService, MesBuildingProductionLineTeamLinkMapper, MesBuildingProductionLineTeamLink>
   implements MesBuildingProductionLineTeamLinkBiz {
}
