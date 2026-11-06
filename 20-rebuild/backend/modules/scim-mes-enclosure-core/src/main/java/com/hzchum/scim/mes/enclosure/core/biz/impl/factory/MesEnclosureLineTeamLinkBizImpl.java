package com.hzchum.scim.mes.enclosure.core.biz.impl.factory;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.enclosure.core.api.biz.factory.MesEnclosureLineTeamLinkBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureLineTeamLink;
import com.hzchum.scim.mes.enclosure.core.api.service.factory.MesEnclosureLineTeamLinkService;
import com.hzchum.scim.mes.enclosure.core.mapper.factory.MesEnclosureLineTeamLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesEnclosureLineTeamLinkBizImpl
   extends IBizImpl<MesEnclosureLineTeamLinkService, MesEnclosureLineTeamLinkMapper, MesEnclosureLineTeamLink>
   implements MesEnclosureLineTeamLinkBiz {
}
