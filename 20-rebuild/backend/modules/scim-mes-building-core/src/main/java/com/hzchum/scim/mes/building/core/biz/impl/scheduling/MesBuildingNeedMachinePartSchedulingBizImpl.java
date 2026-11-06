package com.hzchum.scim.mes.building.core.biz.impl.scheduling;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingNeedMachinePartSchedulingBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNeedMachinePartScheduling;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingNeedMachinePartSchedulingService;
import com.hzchum.scim.mes.building.core.mapper.scheduling.MesBuildingNeedMachinePartSchedulingMapper;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingNeedMachinePartSchedulingBizImpl
   extends IBizImpl<MesBuildingNeedMachinePartSchedulingService, MesBuildingNeedMachinePartSchedulingMapper, MesBuildingNeedMachinePartScheduling>
   implements MesBuildingNeedMachinePartSchedulingBiz {
   @Override
   public List<MesBuildingNeedMachinePartScheduling> listByMonthList(List<LocalDateTime> monthList) {
      return this.baseService.listByMonthList(monthList);
   }
}
