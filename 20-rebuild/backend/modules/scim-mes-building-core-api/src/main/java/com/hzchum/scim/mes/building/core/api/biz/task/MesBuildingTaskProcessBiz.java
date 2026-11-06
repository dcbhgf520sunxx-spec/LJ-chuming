package com.hzchum.scim.mes.building.core.api.biz.task;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.common.core.api.pojo.vo.MesBuildingWIPStatisticsVO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.ProductMonitorKanbanByGroupDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.MesBuildingProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingArtifactTypeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ProductMonitorByGroupDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingProductionTaskDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingWIPStatisticsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingWIPStatisticsDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingWipDailySnapshotProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.ProduceStatisticsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.ProductProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.ProgressProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.ProjectProcessingOutBoundDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskArtifactProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskProcessDullDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskProcessProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskTrackingProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.topTaskOrder.MesBuildingAssistProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.topTaskOrder.MesBuildingAssistProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.topTaskOrder.MesBuildingAssistProductFromArtifactDTO;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface MesBuildingTaskProcessBiz extends IBiz<MesBuildingTaskProcess> {
   List<MesBuildingProcessDTO> getProcessList(Integer taskType, Long orderId);

   List<MesBuildingProductionTaskDTO> getProductTaskList(
      Long projectId,
      Long processId,
      Long orderId,
      Integer productType,
      Integer type,
      Integer productionLineTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String serialNumber,
      String specification,
      Boolean boolAccurateQuery
   );

   void checkBoolRevoke(List<MesBuildingProductionTaskDTO> tasks, MesBuildingTaskOrder artifactTaskOrder);

   PageVO<MesBuildingProductionTaskDTO> getProductTaskListPage(
      Long projectId,
      Long processId,
      Long orderId,
      Integer productType,
      Integer type,
      Integer productionLineTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String serialNumber,
      String specification,
      Boolean boolAccurateQuery,
      Integer pageNumber,
      Integer pageSize
   );

   Boolean getTaskOrderRevoke(
      Long projectId,
      Long processId,
      Long orderId,
      Integer productType,
      Integer type,
      Integer productionLineTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String serialNumber,
      String specification,
      Boolean boolAccurateQuery
   );

   PrintVO<List<Map<String, Object>>> getProductTaskListPrint(
      Long projectId,
      Long processId,
      Long orderId,
      Integer productType,
      Integer type,
      Integer productionLineTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate
   );

   PrintVO<List<Map<String, Object>>> getProductTasksListPrint(
      Long projectId,
      Long processId,
      List<Long> orderIds,
      Integer productType,
      Integer type,
      Integer productionLineTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate
   );

   PrintVO<List<Map<String, Object>>> getProductTasksListPrintV2(
      Long projectId,
      Long processId,
      List<Long> orderIds,
      Integer productType,
      Integer type,
      Integer productionLineTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate
   );

   List<List<TaskTrackingProcessDTO>> taskMachinePartProcess(
      Long taskOrderId, Long projectId, Long monomerId, Long areaId, Long workshopId, Long productionLineId, Integer taskType
   );

   ProgressProcessDTO taskArtifactProcess(Long taskOrderId, Long projectId, Long monomerId, Long areaId, Long workshopId, Long productionLineId);

   List<TaskArtifactProductDTO> taskArtifactList(Long topTaskOrderId, Long projectId, Long monomerId, Long areaId, Long workshopId, Long productionLineId);

   PageVO<TaskArtifactProductDTO> taskArtifactPage(
      Long topTaskOrderId, Long projectId, Long monomerId, Long areaId, Long workshopId, Long productionLineId, Integer pageNumber, Integer pageSize
   );

   List<TaskProcessProductDTO> taskProcessProduct(
      Long processId, Integer taskType, Long orderId, Long prodLineId, String name, Long projectId, Long monomerId, Long areaId, String serialNumber
   );

   PageVO<TaskProcessProductDTO> taskProcessProductPage(
      Long processId,
      Integer taskType,
      Long orderId,
      Long groupId,
      String name,
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Integer pageNumber,
      Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> taskProcessProductPrint(
      LocalDateTime dateTime,
      Long processId,
      Integer taskType,
      Long orderId,
      Long groupId,
      String name,
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber
   );

   List<TaskProcessDullDTO> taskDullProcess(Long workShopId);

   PageVO<TaskProcessDullDTO> taskDullProcessV2(
      Long workShopId, Long productionLineId, Long projectId, Long processId, Long teamId, Integer pageNumber, Integer pageSize
   );

   List<TaskProcessProductDTO> taskDullProcessDetail(
      Integer taskType, Long processId, Long productionLineId, Long projectId, Long monomerId, Long areaId, String serialNumber, Long groupId
   );

   PageVO<TaskProcessProductDTO> taskDullProcessDetailPage(
      Integer taskType,
      Long processId,
      Long productionLineId,
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Long groupId,
      Integer pageNumber,
      Integer pageSize
   );

   PageVO<TaskProcessProductDTO> taskDullProcessDetailPageV2(
      Integer taskType,
      Long processId,
      Long productionLineId,
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Long groupId,
      Integer pageNumber,
      Integer pageSize
   );

   List<ProjectDetailDO> taskDullProcessProject(Integer productType, Long processId, Long productionLineId);

   PrintVO<List<Map<String, Object>>> taskDullProcessDetailPrint(
      Integer productType, Long processId, Long productionLineId, Long projectId, Long monomerId, Long areaId, String serialNumber, Long groupId
   );

   PrintVO<List<Map<String, Object>>> taskDullProcessDetailPrintV2(
      Integer productType, Long processId, Long productionLineId, Long projectId, Long monomerId, Long areaId, String serialNumber, Long groupId
   );

   Boolean getProductTaskListPrintSign(Long orderId);

   List<MesBuildingAssistProcessDTO> getAssistProcessListByTaskOrderIdList(List<Long> taskOrderIds);

   List<List<TaskTrackingProcessDTO>> taskDullMachine(Long topTaskOrderId, Long workshopId, Long productionLineId, Integer productType);

   ProgressProcessDTO taskDullArtifact(Long topTaskOrderId, Long workshopId, Long productionLineId);

   List<TaskProcessProductDTO> taskDullProductProcessDetail(Long processId, Integer taskType, Long orderId, Long groupId);

   PageVO<TaskProcessProductDTO> taskDullProductProcessDetailPage(
      Long processId, Integer taskType, Long orderId, Long groupId, Integer pageNumber, Integer pageSize
   );

   List<MesBuildingAssistProductDTO> getProductAssistList(
      Long taskOrderId,
      Long areaId,
      Long processId,
      Integer taskTypeEnum,
      String serialNumber,
      String specification,
      List<Long> taskProcessIds,
      Integer assistEnum
   );

   PageVO<TaskProcessProductDTO> appTaskProcessProductPage(
      Long processId,
      Integer taskType,
      Long orderId,
      Long groupId,
      String name,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Integer pageNumber,
      Integer pageSize
   );

   List<TaskProcessProductDTO> appTaskProcessProductList(
      Long processId, Integer taskType, Long orderId, Long groupId, String name, Long monomerId, Long areaId, String serialNumber
   );

   PageVO<ProjectProcessingOutBoundDTO> projectProgressingOutBoundPage(
      Long projectId, Integer type, LocalDateTime startDate, LocalDateTime endDate, Integer pageNumber, Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> projectProgressingOutBoundPrint(Long projectId, Integer type, LocalDateTime startDate, LocalDateTime endDate);

   List<ProjectProcessingOutBoundDTO> projectProgressingOutBound(Long projectId, Integer type, LocalDateTime startDate, LocalDateTime endDate);

   PageVO<MesBuildingProductionTaskDTO> projectProgressingTaskPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long workshopId,
      Integer pageNumber,
      Integer pageSize
   );

   List<MesBuildingProductionTaskDTO> projectProgressingTaskList(
      Long projectId, Long monomerId, Long areaId, String serialNumber, LocalDateTime startDate, LocalDateTime endDate, Long workshopId
   );

   PrintVO<List<Map<String, Object>>> projectProgressingTaskPrint(
      Long projectId, Long monomerId, Long areaId, String serialNumber, LocalDateTime startDate, LocalDateTime endDate, Long workshopId
   );

   PageVO<MesBuildingProductionTaskDTO> projectProgressingProcessPage(
      Long projectId,
      Long processId,
      Integer taskTypeEnum,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Long workshopId,
      Integer pageNumber,
      Integer pageSize
   );

   List<MesBuildingProductionTaskDTO> projectProgressingProcessList(
      Long projectId, Long processId, Integer taskTypeEnum, Long monomerId, Long areaId, String serialNumber, Long workshopId
   );

   PrintVO<List<Map<String, Object>>> projectProgressingProcessPrint(
      Long projectId, Long processId, Integer taskTypeEnum, Long monomerId, Long areaId, String serialNumber, Long workshopId
   );

   List<ProductMonitorKanbanByGroupDO> getProductByLastMonth(Long workshopId, Long processId, Integer taskTypeEnum);

   List<ProductMonitorKanbanByGroupDO> getProductByYear(Long workshopId, Long processId, Integer taskTypeEnum);

   List<ProductMonitorKanbanByGroupDO> getProductByUnComplete(Long workshopId, Long processId, Integer taskTypeEnum);

   List<ProductMonitorByGroupDetailDTO> getProductMonitorKanbanByGroupDetail(
      Long workshopId,
      Long productionLineId,
      Long groupId,
      Long teamId,
      Long processId,
      Integer taskTypeEnum,
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber
   );

   PageVO<ProductProcessDTO> pageArtifactProcessByCondition(
      Long areaId,
      Long areaBatchId,
      Long factoryId,
      Long classificationId,
      Long productionLineId,
      String serialNumber,
      String specification,
      String material,
      Integer pageNumber,
      Integer pageSize
   );

   PageVO<ProductProcessDTO> pageAssembleProcessByCondition(
      Long areaId,
      Long areaBatchId,
      Long factoryId,
      Long classificationId,
      Long productionLineId,
      String serialNumber,
      String specification,
      String material,
      Integer pageNumber,
      Integer pageSize
   );

   Map<Long, String> pageArtifactOrAssembleProdLineList(
      Long areaId,
      Long areaBatchId,
      Long factoryId,
      Long classificationId,
      Long productionLineId,
      String serialNumber,
      String specification,
      String material,
      Integer taskTypeEnum
   );

   void pageArtifactOrAssemblePrint(
      Long projectId,
      Long areaId,
      Long areaBatchId,
      Long factoryId,
      Long classificationId,
      Long productionLineId,
      String serialNumber,
      String specification,
      String material,
      Integer processType,
      HttpServletResponse response
   );

   PageVO<ProduceStatisticsDTO> produceStatistics(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer status,
      Long workshopId,
      Integer projectType,
      Integer lumpSumSystemType,
      Integer pageNumber,
      Integer pageSize
   );

   List<ProduceStatisticsDTO> produceStatisticsList(LocalDateTime startDate, LocalDateTime endDate, Integer status, Long workshopId);

   PrintVO<List<Map<String, Object>>> produceStatisticsPrint(LocalDateTime startDate, LocalDateTime endDate, Integer status, Long workshopId);

   List<MesBuildingArtifactTypeDTO> getProductTypeList(Long areaId, Long areaBatchId, Long factoryId, Integer taskTypeEnum);

   PageVO<MesBuildingProductionTaskDTO> produceStatisticsFinishPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long workshopId,
      Integer pageNumber,
      Integer pageSize
   );

   List<MesBuildingProductionTaskDTO> produceStatisticsFinishList(
      Long projectId, Long monomerId, Long areaId, String serialNumber, LocalDateTime startDate, LocalDateTime endDate, Long workshopId
   );

   PrintVO<List<Map<String, Object>>> produceStatisticsFinishPrint(
      Long projectId, Long monomerId, Long areaId, String serialNumber, LocalDateTime startDate, LocalDateTime endDate, Long workshopId
   );

   List<MesBuildingProductionTaskDTO> computeBoolCanRevokeOnecode(
      List<MesBuildingProductionTaskDTO> dtoList, MesBuildingTaskOrder taskOrder, Boolean boolAllCheck
   );

   List<MesBuildingAssistProductFromArtifactDTO> getAssembleAssistListByComponent(
      Long taskOrderId,
      Long areaId,
      Long processId,
      Integer taskTypeEnum,
      String serialNumber,
      String specification,
      List<Long> taskProcessIds,
      Integer assistEnum,
      String artifactSerialNumber,
      String artifactSpecification
   );

   List<MesBuildingWIPStatisticsDTO> findWipStatisticsList(MesBuildingWIPStatisticsVO query);

   List<MesBuildingWipDailySnapshotProcessDTO> findWipStatisticsProcessList(MesBuildingWIPStatisticsVO query);

   List<MesBuildingWIPStatisticsDetailDTO> findWipStatisticsDetail(MesBuildingWIPStatisticsVO query);
}
