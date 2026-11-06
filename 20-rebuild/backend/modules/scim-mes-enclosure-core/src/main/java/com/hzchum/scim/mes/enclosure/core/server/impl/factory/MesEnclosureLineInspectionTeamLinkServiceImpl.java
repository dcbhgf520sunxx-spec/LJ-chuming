package com.hzchum.scim.mes.enclosure.core.server.impl.factory;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureLineInspectionTeamLink;
import com.hzchum.scim.mes.enclosure.core.api.service.factory.MesEnclosureLineInspectionTeamLinkService;
import com.hzchum.scim.mes.enclosure.core.mapper.factory.MesEnclosureLineInspectionTeamLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesEnclosureLineInspectionTeamLinkServiceImpl
   extends ServiceImpl<MesEnclosureLineInspectionTeamLinkMapper, MesEnclosureLineInspectionTeamLink>
   implements MesEnclosureLineInspectionTeamLinkService {
}
