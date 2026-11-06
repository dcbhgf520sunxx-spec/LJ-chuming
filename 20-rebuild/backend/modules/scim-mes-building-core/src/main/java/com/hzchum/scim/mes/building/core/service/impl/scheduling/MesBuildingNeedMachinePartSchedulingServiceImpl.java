package com.hzchum.scim.mes.building.core.service.impl.scheduling;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNeedMachinePartScheduling;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingNeedMachinePartSchedulingService;
import com.hzchum.scim.mes.building.core.mapper.scheduling.MesBuildingNeedMachinePartSchedulingMapper;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingNeedMachinePartSchedulingServiceImpl
   extends ServiceImpl<MesBuildingNeedMachinePartSchedulingMapper, MesBuildingNeedMachinePartScheduling>
   implements MesBuildingNeedMachinePartSchedulingService {
   @Override
   public List<MesBuildingNeedMachinePartScheduling> listByMonthList(List<LocalDateTime> monthList) {
      return this.baseMapper.listByMonthList(monthList);
   }
}
