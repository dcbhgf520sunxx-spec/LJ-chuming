package com.hzchum.scim.mes.building.core.biz.impl.task;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskOrderTypesettingBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrderTypesetting;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskOrderTypesettingService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingTaskOrderTypesettingMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingTaskOrderTypesettingBizImpl
   extends IBizImpl<MesBuildingTaskOrderTypesettingService, MesBuildingTaskOrderTypesettingMapper, MesBuildingTaskOrderTypesetting>
   implements MesBuildingTaskOrderTypesettingBiz {
}
