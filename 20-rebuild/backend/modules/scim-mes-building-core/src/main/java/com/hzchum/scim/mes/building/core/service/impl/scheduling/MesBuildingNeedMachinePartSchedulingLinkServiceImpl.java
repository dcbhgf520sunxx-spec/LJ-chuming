package com.hzchum.scim.mes.building.core.service.impl.scheduling;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNeedMachinePartSchedulingLink;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingNeedMachinePartSchedulingLinkService;
import com.hzchum.scim.mes.building.core.mapper.scheduling.MesBuildingNeedMachinePartSchedulingLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingNeedMachinePartSchedulingLinkServiceImpl
   extends ServiceImpl<MesBuildingNeedMachinePartSchedulingLinkMapper, MesBuildingNeedMachinePartSchedulingLink>
   implements MesBuildingNeedMachinePartSchedulingLinkService {
}
