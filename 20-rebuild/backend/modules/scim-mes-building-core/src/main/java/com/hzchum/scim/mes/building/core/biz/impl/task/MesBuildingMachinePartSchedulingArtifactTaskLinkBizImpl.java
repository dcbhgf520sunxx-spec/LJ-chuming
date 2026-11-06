package com.hzchum.scim.mes.building.core.biz.impl.task;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingMachinePartSchedulingArtifactTaskLinkBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingMachinePartSchedulingArtifactTaskLink;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingMachinePartSchedulingArtifactTaskLinkService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingMachinePartSchedulingArtifactTaskLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingMachinePartSchedulingArtifactTaskLinkBizImpl
   extends IBizImpl<MesBuildingMachinePartSchedulingArtifactTaskLinkService, MesBuildingMachinePartSchedulingArtifactTaskLinkMapper, MesBuildingMachinePartSchedulingArtifactTaskLink>
   implements MesBuildingMachinePartSchedulingArtifactTaskLinkBiz {
}
