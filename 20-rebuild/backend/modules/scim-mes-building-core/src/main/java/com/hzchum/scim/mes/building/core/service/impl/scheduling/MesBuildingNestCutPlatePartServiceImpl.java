package com.hzchum.scim.mes.building.core.service.impl.scheduling;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestCutPlatePart;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingNestCutPlatePartService;
import com.hzchum.scim.mes.building.core.mapper.scheduling.MesBuildingNestCutPlatePartMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingNestCutPlatePartServiceImpl
   extends ServiceImpl<MesBuildingNestCutPlatePartMapper, MesBuildingNestCutPlatePart>
   implements MesBuildingNestCutPlatePartService {
}
