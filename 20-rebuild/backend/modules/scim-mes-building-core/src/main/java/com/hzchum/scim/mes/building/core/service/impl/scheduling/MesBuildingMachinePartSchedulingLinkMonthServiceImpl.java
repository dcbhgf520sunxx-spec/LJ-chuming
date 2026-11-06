package com.hzchum.scim.mes.building.core.service.impl.scheduling;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingMachinePartSchedulingLinkMonth;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingMachinePartSchedulingLinkMonthService;
import com.hzchum.scim.mes.building.core.mapper.scheduling.MesBuildingMachinePartSchedulingLinkMonthMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingMachinePartSchedulingLinkMonthServiceImpl
   extends ServiceImpl<MesBuildingMachinePartSchedulingLinkMonthMapper, MesBuildingMachinePartSchedulingLinkMonth>
   implements MesBuildingMachinePartSchedulingLinkMonthService {
}
