package com.hzchum.scim.mes.enclosure.core.server.impl.cargoList;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.cargoList.MesEnclosureSupplierPriceCarLink;
import com.hzchum.scim.mes.enclosure.core.api.service.cargoList.MesEnclosureSupplierPriceCarLinkService;
import com.hzchum.scim.mes.enclosure.core.mapper.cargoList.MesEnclosureSupplierPriceCarLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesEnclosureSupplierPriceCarLinkServiceImpl
   extends ServiceImpl<MesEnclosureSupplierPriceCarLinkMapper, MesEnclosureSupplierPriceCarLink>
   implements MesEnclosureSupplierPriceCarLinkService {
}
