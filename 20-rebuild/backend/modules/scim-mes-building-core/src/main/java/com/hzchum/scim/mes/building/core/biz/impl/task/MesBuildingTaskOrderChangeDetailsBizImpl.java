package com.hzchum.scim.mes.building.core.biz.impl.task;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskOrderChangeDetailsBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrderChangeDetails;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskOrderChangeDetailsService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingTaskOrderChangeDetailsMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingTaskOrderChangeDetailsBizImpl
   extends IBizImpl<MesBuildingTaskOrderChangeDetailsService, MesBuildingTaskOrderChangeDetailsMapper, MesBuildingTaskOrderChangeDetails>
   implements MesBuildingTaskOrderChangeDetailsBiz {
}
