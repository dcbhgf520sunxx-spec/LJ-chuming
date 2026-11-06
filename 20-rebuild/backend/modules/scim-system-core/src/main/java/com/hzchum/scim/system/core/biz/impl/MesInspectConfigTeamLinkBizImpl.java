package com.hzchum.scim.system.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.system.core.api.biz.MesInspectConfigTeamLinkBiz;
import com.hzchum.scim.system.core.api.pojo._do.MesInspectConfigTeamLink;
import com.hzchum.scim.system.core.api.service.MesInspectConfigTeamLinkService;
import com.hzchum.scim.system.core.mapper.MesInspectConfigTeamLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesInspectConfigTeamLinkBizImpl
   extends IBizImpl<MesInspectConfigTeamLinkService, MesInspectConfigTeamLinkMapper, MesInspectConfigTeamLink>
   implements MesInspectConfigTeamLinkBiz {
}
