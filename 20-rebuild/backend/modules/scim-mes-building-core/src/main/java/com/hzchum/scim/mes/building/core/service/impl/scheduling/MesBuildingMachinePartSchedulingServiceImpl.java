package com.hzchum.scim.mes.building.core.service.impl.scheduling;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingMachinePartSchedulingDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingMachinePartScheduling;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingMachinePartSchedulingService;
import com.hzchum.scim.mes.building.core.mapper.scheduling.MesBuildingMachinePartSchedulingMapper;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingMachinePartSchedulingServiceImpl
   extends ServiceImpl<MesBuildingMachinePartSchedulingMapper, MesBuildingMachinePartScheduling>
   implements MesBuildingMachinePartSchedulingService {
   @Override
   public List<MesBuildingMachinePartSchedulingDO> getMachinePartSchedulingRecordList(Integer issueStatusEnum, LocalDateTime dateTime) {
      return this.baseMapper.getMachinePartSchedulingRecordList(issueStatusEnum, dateTime);
   }

   @Override
   public int passDeleteCount(LocalDateTime now) {
      return this.baseMapper.passDeleteCount(now);
   }
}
