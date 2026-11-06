package com.hzchum.scim.mes.building.core.service.impl.factory;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLineLink;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineLinkService;
import com.hzchum.scim.mes.building.core.mapper.factory.MesBuildingProductionLineLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingProductionLineLinkServiceImpl
   extends ServiceImpl<MesBuildingProductionLineLinkMapper, MesBuildingProductionLineLink>
   implements MesBuildingProductionLineLinkService {
}
