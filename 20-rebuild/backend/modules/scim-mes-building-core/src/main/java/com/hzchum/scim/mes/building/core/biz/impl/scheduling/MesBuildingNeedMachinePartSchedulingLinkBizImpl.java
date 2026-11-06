package com.hzchum.scim.mes.building.core.biz.impl.scheduling;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingNeedMachinePartSchedulingLinkBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNeedMachinePartSchedulingLink;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingNeedMachinePartSchedulingLinkService;
import com.hzchum.scim.mes.building.core.mapper.scheduling.MesBuildingNeedMachinePartSchedulingLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingNeedMachinePartSchedulingLinkBizImpl
   extends IBizImpl<MesBuildingNeedMachinePartSchedulingLinkService, MesBuildingNeedMachinePartSchedulingLinkMapper, MesBuildingNeedMachinePartSchedulingLink>
   implements MesBuildingNeedMachinePartSchedulingLinkBiz {
}
