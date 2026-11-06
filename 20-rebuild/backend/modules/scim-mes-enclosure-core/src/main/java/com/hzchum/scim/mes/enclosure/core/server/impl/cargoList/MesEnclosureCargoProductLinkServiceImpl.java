package com.hzchum.scim.mes.enclosure.core.server.impl.cargoList;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.cargoList.MesEnclosureCargoListProductLink;
import com.hzchum.scim.mes.enclosure.core.api.service.cargoList.MesEnclosureCargoListProductLinkService;
import com.hzchum.scim.mes.enclosure.core.mapper.cargoList.MesEnclosureCargoListProductLinkMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = TransactionException.class)
public class MesEnclosureCargoProductLinkServiceImpl
   extends ServiceImpl<MesEnclosureCargoListProductLinkMapper, MesEnclosureCargoListProductLink>
   implements MesEnclosureCargoListProductLinkService {
}
