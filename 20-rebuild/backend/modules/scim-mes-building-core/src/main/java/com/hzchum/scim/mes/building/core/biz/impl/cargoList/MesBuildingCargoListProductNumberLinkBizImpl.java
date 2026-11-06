package com.hzchum.scim.mes.building.core.biz.impl.cargoList;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.cargoList.MesBuildingCargoListProductNumberLinkBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoListProductNumberLink;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListProductNumberLinkService;
import com.hzchum.scim.mes.building.core.mapper.cargoList.MesBuildingCargoListProductNumberLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingCargoListProductNumberLinkBizImpl
   extends IBizImpl<MesBuildingCargoListProductNumberLinkService, MesBuildingCargoListProductNumberLinkMapper, MesBuildingCargoListProductNumberLink>
   implements MesBuildingCargoListProductNumberLinkBiz {
}
