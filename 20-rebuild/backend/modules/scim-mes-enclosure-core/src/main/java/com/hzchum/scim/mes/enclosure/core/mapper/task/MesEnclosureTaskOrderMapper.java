package com.hzchum.scim.mes.enclosure.core.mapper.task;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureTaskOrder;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.MesEnclosureTaskOrderDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.OrderTaskAndCompleteLengthDTO;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.List;

public interface MesEnclosureTaskOrderMapper extends BaseMapper<MesEnclosureTaskOrder> {
   List<MesEnclosureTaskOrderDTO> getOrders(@Param("orderNumber") String orderNumber, @Param("projectId") Long projectId, @Param("userName") String userName);

   List<OrderTaskAndCompleteLengthDTO> getTaskAndCompLength(@Param("orderIds") List<Long> orderIds);
}
