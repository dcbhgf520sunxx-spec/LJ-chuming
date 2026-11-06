package com.hzchum.scim.mes.building.core.api.biz.task;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.APPCutTaskProcessDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.APPSemiAutoCutTaskDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.AppTaskOrderSummaryDTO;
import java.time.LocalDateTime;

public interface MesBuildingSemiAutoCutTaskBiz {
   PageVO<AppTaskOrderSummaryDTO> taskOrderPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer taskTypeEnum,
      String serialNumber,
      String orderNumber,
      Integer boolLastProcessEnum,
      String sort,
      Integer pageNumber,
      Integer pageSize
   );

   APPCutTaskProcessDetailDTO taskOrderProcessDetail(Long schedulingId);

   APPSemiAutoCutTaskDetailDTO taskOrderDetail(Long taskOrderId, Long monomerId, Long areaId);

   PageVO<APPSemiAutoCutTaskDetailDTO> taskOrderDetailHistory(
      LocalDateTime startDate, LocalDateTime endDate, Integer taskTypeEnum, Integer processType, String serialNumber, Integer pageNumber, Integer pageSize
   );

   String updatePartLabelStatus(Long id);
}
