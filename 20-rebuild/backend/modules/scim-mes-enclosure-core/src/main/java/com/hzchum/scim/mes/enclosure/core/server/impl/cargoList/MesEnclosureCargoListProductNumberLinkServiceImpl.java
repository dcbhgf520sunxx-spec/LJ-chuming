package com.hzchum.scim.mes.enclosure.core.server.impl.cargoList;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.cargoList.MesEnclosureCargoListProductNumberLink;
import com.hzchum.scim.mes.enclosure.core.api.service.cargoList.MesEnclosureCargoListProductNumberLinkService;
import com.hzchum.scim.mes.enclosure.core.mapper.cargoList.MesEnclosureCargoListProductNumberLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesEnclosureCargoListProductNumberLinkServiceImpl
   extends ServiceImpl<MesEnclosureCargoListProductNumberLinkMapper, MesEnclosureCargoListProductNumberLink>
   implements MesEnclosureCargoListProductNumberLinkService {
}
