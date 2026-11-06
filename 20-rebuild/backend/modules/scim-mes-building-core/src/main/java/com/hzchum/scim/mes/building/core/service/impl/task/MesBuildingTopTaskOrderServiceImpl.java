package com.hzchum.scim.mes.building.core.service.impl.task;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.topTaskOrder.MesBuildingTopTaskOrderDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTopTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._dto.onecodeChange.MesBuildingOrderIdAndQuantityDTO;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTopTaskOrderService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingTopTaskOrderMapper;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingTopTaskOrderServiceImpl
   extends ServiceImpl<MesBuildingTopTaskOrderMapper, MesBuildingTopTaskOrder>
   implements MesBuildingTopTaskOrderService {
   @Override
   public List<MesBuildingTopTaskOrderDO> getTopTaskOrderAssistList(
      LocalDateTime dateTime, List<Long> projectIds, Long monomerId, Long areaId, String serialNumber
   ) {
      return this.baseMapper.getTopTaskOrderAssistList(dateTime, projectIds, monomerId, areaId, serialNumber);
   }

   @Override
   public List<MesBuildingOrderIdAndQuantityDTO> boolOrderComplete(List<Long> topOrderIds) {
      return this.baseMapper.boolOrderComplete(topOrderIds);
   }
}
