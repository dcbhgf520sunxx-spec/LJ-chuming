package com.hzchum.scim.mes.enclosure.core.api.service.task;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureTaskOrder;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.MesEnclosureTaskOrderDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.OrderTaskAndCompleteLengthDTO;
import java.util.List;

public interface MesEnclosureTaskOrderService extends IService<MesEnclosureTaskOrder> {
   List<MesEnclosureTaskOrderDTO> getOrders(String orderNumber, Long projectId, String userName);

   List<OrderTaskAndCompleteLengthDTO> getTaskAndCompLength(List<Long> orderIds);
}
