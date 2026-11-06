package com.hzchum.scim.mes.enclosure.core.server.impl.factory;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureLineTeamLink;
import com.hzchum.scim.mes.enclosure.core.api.service.factory.MesEnclosureLineTeamLinkService;
import com.hzchum.scim.mes.enclosure.core.mapper.factory.MesEnclosureLineTeamLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesEnclosureLineTeamLinkServiceImpl
   extends ServiceImpl<MesEnclosureLineTeamLinkMapper, MesEnclosureLineTeamLink>
   implements MesEnclosureLineTeamLinkService {
}
