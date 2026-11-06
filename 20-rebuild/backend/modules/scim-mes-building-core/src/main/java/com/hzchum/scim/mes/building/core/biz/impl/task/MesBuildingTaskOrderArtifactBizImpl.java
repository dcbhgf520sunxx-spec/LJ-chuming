package com.hzchum.scim.mes.building.core.biz.impl.task;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskOrderArtifactBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrderArtifact;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskOrderArtifactService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingTaskOrderArtifactMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingTaskOrderArtifactBizImpl
   extends IBizImpl<MesBuildingTaskOrderArtifactService, MesBuildingTaskOrderArtifactMapper, MesBuildingTaskOrderArtifact>
   implements MesBuildingTaskOrderArtifactBiz {
}
