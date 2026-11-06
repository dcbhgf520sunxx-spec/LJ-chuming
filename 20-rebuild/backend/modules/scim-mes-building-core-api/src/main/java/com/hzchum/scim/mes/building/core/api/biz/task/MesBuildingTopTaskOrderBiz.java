package com.hzchum.scim.mes.building.core.api.biz.task;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTopTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.topTaskOrder.MesBuildingAssistTopTaskOrderDTO;
import java.time.LocalDateTime;
import java.util.List;

public interface MesBuildingTopTaskOrderBiz extends IBiz<MesBuildingTopTaskOrder> {
   PageVO<MesBuildingAssistTopTaskOrderDTO> getTopTaskOrderAssistPage(
      LocalDateTime dateTime, Long projectId, Long monomerId, Long areaId, String serialNumber, Integer pageNumber, Integer pageSize
   );

   List<MesBuildingAssistTopTaskOrderDTO> getTopTaskOrderAssistList(LocalDateTime dateTime, Long projectId);

   int getNumber(LocalDateTime now);
}
