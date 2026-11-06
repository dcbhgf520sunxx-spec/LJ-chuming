package com.hzchum.scim.mes.building.core.service.impl.cargoList;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoListAddress;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListAddressService;
import com.hzchum.scim.mes.building.core.mapper.cargoList.MesBuildingCargoListAddressMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingCargoListAddressServiceImpl
   extends ServiceImpl<MesBuildingCargoListAddressMapper, MesBuildingCargoListAddress>
   implements MesBuildingCargoListAddressService {
}
