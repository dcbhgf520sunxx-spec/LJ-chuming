package com.hzchum.scim.mes.building.core.service.impl.task;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingInProduction;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingInProductionService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingInProductionMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingInProductionServiceImpl
   extends ServiceImpl<MesBuildingInProductionMapper, MesBuildingInProduction>
   implements MesBuildingInProductionService {
}
