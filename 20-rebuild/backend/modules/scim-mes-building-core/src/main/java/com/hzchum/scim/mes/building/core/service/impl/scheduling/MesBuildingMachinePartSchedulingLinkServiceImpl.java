package com.hzchum.scim.mes.building.core.service.impl.scheduling;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingMachinePartSchedulingLinkDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingMachinePartSchedulingLink;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingMachinePartSchedulingLinkService;
import com.hzchum.scim.mes.building.core.mapper.scheduling.MesBuildingMachinePartSchedulingLinkMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingMachinePartSchedulingLinkServiceImpl
   extends ServiceImpl<MesBuildingMachinePartSchedulingLinkMapper, MesBuildingMachinePartSchedulingLink>
   implements MesBuildingMachinePartSchedulingLinkService {
   @Override
   public List<MesBuildingMachinePartSchedulingLinkDO> getMachinePartSchedulingRecordDetails(Long id) {
      return this.baseMapper.getMachinePartSchedulingRecordDetails(id);
   }
}
