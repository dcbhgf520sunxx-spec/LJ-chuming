package com.hzchum.scim.mes.enclosure.core.biz.impl.cargoList;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.enclosure.core.api.biz.cargoList.MesEnclosureCargoListProductNumberLinkBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.cargoList.MesEnclosureCargoListProductNumberLink;
import com.hzchum.scim.mes.enclosure.core.api.service.cargoList.MesEnclosureCargoListProductNumberLinkService;
import com.hzchum.scim.mes.enclosure.core.mapper.cargoList.MesEnclosureCargoListProductNumberLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesEnclosureCargoListProductNumberLinkBizImpl
   extends IBizImpl<MesEnclosureCargoListProductNumberLinkService, MesEnclosureCargoListProductNumberLinkMapper, MesEnclosureCargoListProductNumberLink>
   implements MesEnclosureCargoListProductNumberLinkBiz {
}
