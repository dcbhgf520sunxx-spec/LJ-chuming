package com.hzchum.scim.mes.building.core.service.impl.task;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingMachinePartSchedulingArtifactTaskLink;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingMachinePartSchedulingArtifactTaskLinkService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingMachinePartSchedulingArtifactTaskLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingMachinePartSchedulingArtifactTaskLinkServiceImpl
   extends ServiceImpl<MesBuildingMachinePartSchedulingArtifactTaskLinkMapper, MesBuildingMachinePartSchedulingArtifactTaskLink>
   implements MesBuildingMachinePartSchedulingArtifactTaskLinkService {
}
