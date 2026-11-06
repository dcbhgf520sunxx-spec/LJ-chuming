package com.hzchum.scim.mes.building.core.service.impl.cargoList;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoListChange;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListChangeService;
import com.hzchum.scim.mes.building.core.mapper.cargoList.MesBuildingCargoListChangeMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingCargoListChangeServiceImpl
   extends ServiceImpl<MesBuildingCargoListChangeMapper, MesBuildingCargoListChange>
   implements MesBuildingCargoListChangeService {
}
