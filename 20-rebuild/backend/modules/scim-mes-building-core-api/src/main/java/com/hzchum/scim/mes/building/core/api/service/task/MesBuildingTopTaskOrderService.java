package com.hzchum.scim.mes.building.core.api.service.task;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.topTaskOrder.MesBuildingTopTaskOrderDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTopTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._dto.onecodeChange.MesBuildingOrderIdAndQuantityDTO;
import java.time.LocalDateTime;
import java.util.List;

public interface MesBuildingTopTaskOrderService extends IService<MesBuildingTopTaskOrder> {
   List<MesBuildingTopTaskOrderDO> getTopTaskOrderAssistList(LocalDateTime dateTime, List<Long> projectIds, Long monomerId, Long areaId, String serialNumber);

   List<MesBuildingOrderIdAndQuantityDTO> boolOrderComplete(List<Long> topOrderIds);
}
