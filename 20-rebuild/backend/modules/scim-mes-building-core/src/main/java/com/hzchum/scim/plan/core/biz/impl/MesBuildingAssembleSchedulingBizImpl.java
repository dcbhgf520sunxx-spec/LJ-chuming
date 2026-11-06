package com.hzchum.scim.plan.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.plan.core.api.biz.MesBuildingAssembleSchedulingBiz;
import com.hzchum.scim.plan.core.api.pojo._doModel.MesBuildingAssembleScheduling;
import com.hzchum.scim.plan.core.api.service.MesBuildingAssembleSchedulingService;
import com.hzchum.scim.plan.core.mapper.MesBuildingAssembleSchedulingMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingAssembleSchedulingBizImpl
   extends IBizImpl<MesBuildingAssembleSchedulingService, MesBuildingAssembleSchedulingMapper, MesBuildingAssembleScheduling>
   implements MesBuildingAssembleSchedulingBiz {
}
