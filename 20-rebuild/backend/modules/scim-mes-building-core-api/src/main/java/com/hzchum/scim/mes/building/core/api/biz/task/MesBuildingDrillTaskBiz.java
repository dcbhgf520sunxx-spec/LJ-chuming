package com.hzchum.scim.mes.building.core.api.biz.task;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.APPSemiAutoCutTaskDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.AppTaskOrderSummaryDTO;
import java.time.LocalDateTime;

public interface MesBuildingDrillTaskBiz {
   PageVO<AppTaskOrderSummaryDTO> taskOrderPage(
      Long projectId, Long monomerId, Long areaId, String orderNumber, String sort, Integer pageNumber, Integer pageSize
   );

   APPSemiAutoCutTaskDetailDTO taskOrderDetail(Long taskOrderId, Long monomerId, Long areaId);

   PageVO<APPSemiAutoCutTaskDetailDTO> taskOrderDetailHistory(
      LocalDateTime startDate, LocalDateTime endDate, Integer taskTypeEnum, Integer processType, String serialNumber, Integer pageNumber, Integer pageSize
   );

   String updatePartLabelStatus(Long id);
}
