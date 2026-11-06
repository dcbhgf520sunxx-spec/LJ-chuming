package com.hzchum.scim.mes.building.core.api.biz.task;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.APPAutoCutTaskSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.APPCutTaskProcessDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.APPSemiAutoCutTaskDetailDTO;
import java.time.LocalDateTime;
import java.util.List;

public interface MesBuildingAutoCutTaskBiz {
   PageVO<APPAutoCutTaskSummaryDTO> taskOrderPage(
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

   List<ProjectInfo> existTaskOrderProjectList(Integer taskTypeEnum, Integer machinePartProductionClass);

   APPCutTaskProcessDetailDTO numericalControlDetail(Long jobId, List<String> guidList, Boolean boolCheck);

   APPCutTaskProcessDetailDTO numericalControlDetailSubmit(Long jobId);

   APPCutTaskProcessDetailDTO getApproveRecordDetail(Long wmsApproveRecordId);

   List<APPSemiAutoCutTaskDetailDTO> taskOrderDetail(Long jobId);

   APPSemiAutoCutTaskDetailDTO taskOrderDetailTwo(Long taskOrderId);

   PageVO<APPSemiAutoCutTaskDetailDTO> taskOrderDetailHistory(
      LocalDateTime startDate, LocalDateTime endDate, Integer taskTypeEnum, Integer processType, String serialNumber, Integer pageNumber, Integer pageSize
   );

   String updatePartLabelStatus(Long id);
}
