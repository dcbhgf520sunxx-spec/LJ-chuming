package com.hzchum.scim.mes.enclosure.core.biz.impl.factory;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.enclosure.core.api.biz.factory.MesEnclosureLineInspectionTeamLinkBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureLineInspectionTeamLink;
import com.hzchum.scim.mes.enclosure.core.api.service.factory.MesEnclosureLineInspectionTeamLinkService;
import com.hzchum.scim.mes.enclosure.core.mapper.factory.MesEnclosureLineInspectionTeamLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesEnclosureLineInspectionTeamLinkBizImpl
   extends IBizImpl<MesEnclosureLineInspectionTeamLinkService, MesEnclosureLineInspectionTeamLinkMapper, MesEnclosureLineInspectionTeamLink>
   implements MesEnclosureLineInspectionTeamLinkBiz {
}
