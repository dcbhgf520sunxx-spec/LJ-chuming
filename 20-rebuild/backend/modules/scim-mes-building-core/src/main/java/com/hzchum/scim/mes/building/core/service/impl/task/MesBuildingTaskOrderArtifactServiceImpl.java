package com.hzchum.scim.mes.building.core.service.impl.task;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrderArtifact;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskOrderArtifactService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingTaskOrderArtifactMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingTaskOrderArtifactServiceImpl
   extends ServiceImpl<MesBuildingTaskOrderArtifactMapper, MesBuildingTaskOrderArtifact>
   implements MesBuildingTaskOrderArtifactService {
}
