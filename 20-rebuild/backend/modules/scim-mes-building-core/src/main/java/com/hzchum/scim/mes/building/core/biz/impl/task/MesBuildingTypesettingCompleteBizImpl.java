package com.hzchum.scim.mes.building.core.biz.impl.task;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTypesettingCompleteBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTypesettingComplete;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTypesettingCompleteService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingTypesettingCompleteMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingTypesettingCompleteBizImpl
   extends IBizImpl<MesBuildingTypesettingCompleteService, MesBuildingTypesettingCompleteMapper, MesBuildingTypesettingComplete>
   implements MesBuildingTypesettingCompleteBiz {
}
