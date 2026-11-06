package com.hzchum.scim.mes.building.core.biz.impl.scheduling;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingMachinePartSchedulingLinkMonthBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingMachinePartSchedulingLinkMonth;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingMachinePartSchedulingLinkMonthService;
import com.hzchum.scim.mes.building.core.mapper.scheduling.MesBuildingMachinePartSchedulingLinkMonthMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingMachinePartSchedulingLinkMonthBizImpl
   extends IBizImpl<MesBuildingMachinePartSchedulingLinkMonthService, MesBuildingMachinePartSchedulingLinkMonthMapper, MesBuildingMachinePartSchedulingLinkMonth>
   implements MesBuildingMachinePartSchedulingLinkMonthBiz {
}
