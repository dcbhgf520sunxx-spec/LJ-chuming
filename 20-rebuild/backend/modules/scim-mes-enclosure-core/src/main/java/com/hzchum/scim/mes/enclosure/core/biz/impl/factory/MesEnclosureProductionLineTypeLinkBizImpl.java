package com.hzchum.scim.mes.enclosure.core.biz.impl.factory;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.enclosure.core.api.biz.factory.MesEnclosureProductionLineTypeLinkBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.factory.MesEnclosureProductionLineTypeLink;
import com.hzchum.scim.mes.enclosure.core.api.service.factory.MesEnclosureProductionLineTypeLinkService;
import com.hzchum.scim.mes.enclosure.core.mapper.factory.MesEnclosureProductionLineTypeLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesEnclosureProductionLineTypeLinkBizImpl
   extends IBizImpl<MesEnclosureProductionLineTypeLinkService, MesEnclosureProductionLineTypeLinkMapper, MesEnclosureProductionLineTypeLink>
   implements MesEnclosureProductionLineTypeLinkBiz {
}
