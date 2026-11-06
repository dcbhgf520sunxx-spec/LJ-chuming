package com.hzchum.scim.mes.enclosure.core.server.impl.task;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureTaskOrder;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.MesEnclosureTaskOrderDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.OrderTaskAndCompleteLengthDTO;
import com.hzchum.scim.mes.enclosure.core.api.service.task.MesEnclosureTaskOrderService;
import com.hzchum.scim.mes.enclosure.core.mapper.task.MesEnclosureTaskOrderMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesEnclosureTaskOrderServiceImpl extends ServiceImpl<MesEnclosureTaskOrderMapper, MesEnclosureTaskOrder> implements MesEnclosureTaskOrderService {
   @Override
   public List<MesEnclosureTaskOrderDTO> getOrders(String orderNumber, Long projectId, String userName) {
      return this.baseMapper.getOrders(orderNumber, projectId, userName);
   }

   @Override
   public List<OrderTaskAndCompleteLengthDTO> getTaskAndCompLength(List<Long> orderIds) {
      return this.baseMapper.getTaskAndCompLength(orderIds);
   }
}
