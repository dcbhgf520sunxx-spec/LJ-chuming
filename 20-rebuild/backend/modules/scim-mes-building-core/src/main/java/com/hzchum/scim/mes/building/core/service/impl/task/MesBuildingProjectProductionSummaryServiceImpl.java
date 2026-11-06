package com.hzchum.scim.mes.building.core.service.impl.task;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProjectProductionSummary;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProjectProductionSummaryService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingProjectProductionSummaryMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingProjectProductionSummaryServiceImpl
   extends ServiceImpl<MesBuildingProjectProductionSummaryMapper, MesBuildingProjectProductionSummary>
   implements MesBuildingProjectProductionSummaryService {
}
