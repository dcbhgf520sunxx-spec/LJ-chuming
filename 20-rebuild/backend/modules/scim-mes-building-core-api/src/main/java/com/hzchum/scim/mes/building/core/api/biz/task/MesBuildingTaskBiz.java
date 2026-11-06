package com.hzchum.scim.mes.building.core.api.biz.task;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.ProductProjectSumDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.ArtifactSchedulingDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.TaskMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.complete.ProductionLoadDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.QuantityAndWeightDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingInspectionTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestCutPlate;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssist;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._dto.IdAndRecelveQuantityDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingProductionLineDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.product.ScanCodeArtifactDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.product.ScanCodeEnclosureDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.AnalysisQhseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.QhseDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.InspectionReportSavedDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.TeamAndNumberDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ArtifactSchedulingDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingNestCutPlateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ProductMonitorKanbanBySummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ProductMonitorKanbanDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.YearQuantityAndMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingArtifactTaskProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingProductionTaskDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingTaskProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskProcessProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskProductLineListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskTrackingLineMonthDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskTrackingProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskTrackingProductionLineDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TrackSteelDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TrackSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.APPQuantityAndMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.APPTaskProcessInspectionDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.AppTaskMissingDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.AppTaskOrderSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.AppTaskProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.AppTaskProcessDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.ProductClassificationDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.get.ProductSourceDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingMachinePartSchedulingDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingProduceTeamReportDTOParam;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactStatusDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectTreeResponseVO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public interface MesBuildingTaskBiz extends IBiz<MesBuildingTask> {
   List<Integer> saveProduceTeamReport(MesBuildingProduceTeamReportDTOParam dtoParam);

   Boolean qhseAdopt(MesBuildingTaskProcess taskProcess, Integer quantity, Long userId, Long teamId, Long qhseId);

   Boolean updateNextTaskProcess(MesBuildingTaskProcess taskProcess, Integer reportQuantity, Long teamId, List<Integer> numberList);

   void completeCurrentProcess(
      MesBuildingTaskProcess taskProcess,
      Integer typeEnum,
      Integer reportQuantity,
      int ARTIFACT_TYPE,
      int ASSEMBLE_TYPE,
      Long teamId,
      List<Integer> numberList,
      LocalDateTime now
   );

   Boolean updateNextTaskInspectionProcess(MesBuildingTaskProcess taskProcess, Integer reportQuantity, List<TeamAndNumberDTO> numberList);

   Boolean deleteInspection(MesBuildingInspectionTeam inspectionTeam);

   Boolean deleteInspection(Long groupsId, Long processId);

   Boolean saveProduceTeamReportSummary(MesBuildingTaskProcess taskProcess, Integer reportQuantity, Long assistGroupId, Long teamId, Integer type);

   List<MesBuildingTaskProcessDTO> listProductTask(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long processId,
      Integer taskTypeEnum,
      String serialNumber,
      String specification,
      String material,
      Long taskOrderId,
      Boolean boolCompleteEnum
   );

   PageVO<MesBuildingTaskProcessDTO> newProductTaskPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long processId,
      Integer taskTypeEnum,
      String serialNumber,
      String specification,
      String material,
      Long taskOrderId,
      String productionLineName,
      String productName,
      Boolean boolCompleteEnum,
      List<LocalDateTime> dateTimeList,
      String sort,
      Integer pageNumber,
      Integer pageSize
   );

   PageVO<APPTaskProcessInspectionDTO> productTaskInspectionPage2(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long processId,
      Integer productType,
      String serialNumber,
      String productName,
      Long taskId,
      String sort,
      Integer pageNumber,
      Integer pageSize
   );

   PageVO<APPTaskProcessInspectionDTO> productTaskInspectionPage3(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long processId,
      Integer productType,
      String serialNumber,
      String productName,
      Long taskId,
      Integer reportType,
      String sort,
      Integer pageNumber,
      Integer pageSize
   );

   List<APPTaskProcessInspectionDTO> productTaskInspectionList2(
      Long projectId, Long monomerId, Long areaId, Long processId, Integer productType, String serialNumber, String productName, Long taskId, String sort
   );

   List<APPTaskProcessInspectionDTO> productTaskInspectionList3(
      List<Long> inspectConfigIds,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long processId,
      Integer taskTypeEnum,
      String serialNumber,
      String productName,
      Long taskId,
      String sort
   );

   PageVO<APPTaskProcessInspectionDTO> productTaskInspectionPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long processId,
      Integer taskTypeEnum,
      String serialNumber,
      String productName,
      Long taskId,
      String sort,
      Integer pageNumber,
      Integer pageSize
   );

   Map<String, Integer> listProductTaskCount2(Long userId);

   Map<String, List<Long>> listHasTaskProductionLineId(Long projectId, Long monomerId, Long areaId, Long areaBatchId, Integer productType);

   ListVO<ProductProjectSumDO> listGroupByProjectId(String year, String month, Long productionLineId, Long processId);

   ListVO<TaskMeteDO> listGroupByMonth(String year, String month, Long projectId, Long productionLineId, Long processId);

   ScanCodeArtifactDTO getArtifactTask(Long productId);

   ScanCodeEnclosureDTO getEnclosureTask(Long productId);

   ScanCodeEnclosureDTO getEnclosureTaskV2(Long productId);

   Integer checkReportQuantity(Long id);

   ProductSourceDTO productSource(Long id, Integer productType);

   List<ProductionLoadDO> productionLoad(LocalDateTime dateTime, Long factoryId);

   List<MesBuildingArtifactTaskProcessDTO> artifactTaskList(Long taskProcessId, Long number);

   Boolean artifactTaskRevoke(List<Long> taskIdList);

   Boolean artifactTaskOrderRevoke(Long id);

   List<MesBuildingArtifactTaskProcessDTO> artifactInspectionTaskList(Long taskProcessId, Long number, Long teamId);

   Boolean revokeTaskPocess(Long id);

   Boolean addTaskProcess(MesBuildingTask task);

   Boolean addPartTaskProcess(
      MesBuildingTask task,
      MesBuildingTeam drillGroups,
      LocalDateTime drillAskCompleteTime,
      MesBuildingNestCutPlate nestCutPlate,
      MesBuildingMachinePartSchedulingDTOParam dtoParamOld
   );

   Boolean addPartTaskProcessFast(
      List<MesBuildingTask> mesBuildingTaskList,
      MesBuildingTeam drillGroups,
      LocalDateTime drillAskCompleteTime,
      MesBuildingNestCutPlate nestCutPlate,
      MesBuildingMachinePartSchedulingDTOParam dtoParamOld
   );

   List<AppTaskOrderSummaryDTO> taskOrderList(Long projectId, Integer taskTypeEnum, String serialNumber, Integer boolLastProcessEnum);

   List<AppTaskOrderSummaryDTO> taskOrderList2(Long projectId, Integer taskTypeEnum, String serialNumber, Integer boolLastProcessEnum);

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

   PageVO<AppTaskOrderSummaryDTO> taskOrderPage2(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Integer taskTypeEnum,
      String serialNumber,
      String orderNumber,
      Integer boolLastProcessEnum,
      String sort,
      Integer pageNumber,
      Integer pageSize
   );

   List<AppTaskOrderSummaryDTO> drillTaskOrderList();

   List<AppTaskOrderSummaryDTO> drillTaskOrderList2();

   PageVO<AppTaskOrderSummaryDTO> drillTaskOrderPage(
      Long projectId, Long monomerId, Long areaId, String orderNumber, String sort, Integer pageNumber, Integer pageSize
   );

   Boolean saveNestCutPlateReport(Long nestCutPlateId, List<Long> partIds, String ncCode, Boolean reportType, List<IdAndRecelveQuantityDTO> parts);

   Boolean saveDrillNestCutPlateReport(Long nestCutPlateId, List<IdAndRecelveQuantityDTO> parts, Boolean reportType);

   List<MesBuildingNestCutPlateDTO> taskOrderNestPartList(Long taskOrderId);

   List<MesBuildingNestCutPlateDTO> getDrillTaskOrderNestPartList(Long taskOrderId);

   PageVO<AppTaskProcessDTO> pageProductTaskByTaskOrderId(
      Integer taskTypeEnum,
      Long monomerId,
      Long areaId,
      Long classId,
      String serialNumber,
      Long taskOrderId,
      Integer boolLastProcessEnum,
      Integer pageNumber,
      Integer pageSize
   );

   PageVO<AppTaskProcessDTO> pageProductTaskByTaskOrderId2(
      Integer taskTypeEnum,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long batchId,
      Long classId,
      Long processId,
      String specification,
      String serialNumber,
      Long taskOrderId,
      Integer boolLastProcessEnum,
      Boolean boolMissingParts,
      Integer reportType,
      Integer pageNumber,
      Integer pageSize
   );

   PageVO<AppTaskProcessDTO> pageProductAssistTask(
      Integer taskTypeEnum,
      Long taskId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      String serialNumber,
      Integer pageNumber,
      Integer pageSize
   );

   PageVO<AppTaskProcessDTO> pageProductAssistTask2(
      Integer taskTypeEnum,
      Long taskId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long processId,
      String serialNumber,
      Integer boolLastProcessEnum,
      Boolean boolMissingParts,
      Integer reportType,
      Integer pageNumber,
      Integer pageSize
   );

   Integer assistTaskCount(Integer taskTypeEnum);

   Integer assistTaskCount2(Integer taskTypeEnum);

   List<AppTaskProcessDTO> listTaskProcessByTaskId(Long taskId, Integer boolLastProcessEnum);

   List<AppTaskProcessDTO> listProductTaskByTaskId(Long taskId, Integer boolLastProcessEnum);

   List<AppTaskProcessDTO> listDrillTaskByNestCutPlateId(Long taskOrderId);

   PageVO<AppTaskProcessDTO> pageDrillTaskByNestCutPlateId(Long nestCutPlateId, Integer pageNumber, Integer pageSize);

   List<AppTaskMissingDetailsDTO> taskProcessMissingDetails2(Long id, Boolean boolAssist, Long assistLineId);

   TaskProductLineListDTO taskTrackProductionLine(LocalDateTime startTime, LocalDateTime endTime, Integer taskType, Long workShopId, Long projectId);

   List<TaskProcessProductDTO> taskTrackProductionLineDetail(
      LocalDateTime startTime, LocalDateTime endTime, Integer taskType, Long productionLineId, Long projectId, Long monomerId, Long areaId, String serialNumber
   );

   PageVO<TaskProcessProductDTO> taskTrackProductionLineDetailPage(
      LocalDateTime startTime,
      LocalDateTime endTime,
      Integer taskType,
      Long productionLineId,
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Integer pageNumber,
      Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> taskTrackProductionLineDetailPrint(
      LocalDateTime startTime, LocalDateTime endTime, Integer taskType, Long productionLineId, Long projectId, Long monomerId, Long areaId, String serialNumber
   );

   List<MesBuildingProductionLineDTO> getProductionLine(Integer productType, Long workShopId);

   AppTaskProcessDetailsDTO taskProcessDetails(Long id, Boolean boolAssist, Long assistGroupId);

   AppTaskProcessDetailsDTO taskProcessDetails2(
      Long id, Boolean boolAssist, Long assistLineId, Map<Long, List<MesBuildingTaskNumberLink>> assembleTaskNumberLinkMap
   );

   List<String> productNumberDetails(Long taskProcessId, Integer assembleNumber);

   List<AppTaskMissingDetailsDTO> taskProcessMissingDetails(Long id, Boolean boolAssist, Long assistGroupId);

   List<TaskTrackingLineMonthDTO> taskTrackingMonth(LocalDateTime dateTime, Long workShopId, Long productionLineId);

   List<TaskTrackingProductionLineDTO> taskTrackingMonthDetail(LocalDateTime dateTime, Long workShopId, Long productionLineId);

   PageVO<TaskTrackingProductionLineDTO> taskTrackingMonthPage(
      LocalDateTime dateTime, Long workShopId, Long productionLineId, Integer pageNumber, Integer pageSize
   );

   List<TaskTrackingProductDTO> taskTrackingMonthProject(
      LocalDateTime dateTime, Long workShopId, Long productionLineId, Long projectId, Long monomerId, Long areaId, String serialNumber
   );

   PageVO<TaskTrackingProductDTO> taskTrackingMonthProjectPage(
      LocalDateTime dateTime,
      Long workShopId,
      Long productionLineId,
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Integer pageNumber,
      Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> taskTrackingMonthProjectPrint(
      LocalDateTime dateTime, Long workShopId, Long productionLineId, Long projectId, Long monomerId, Long areaId, String serialNumber
   );

   APPQuantityAndMeteDTO taskTrackingMonthProjectSummary(LocalDateTime dateTime, Long projectId, Long monomerId, Long areaId, String serialNumber);

   List<TaskProductDTO> taskProductionLineList(LocalDateTime startTime, LocalDateTime endTime, Integer productType, Integer type, Long processId);

   TrackSummaryDTO trackSummary(Long projectId);

   List<TrackSteelDTO> trackSteel(Long projectId);

   List<TrackSteelDTO> trackSection(Long projectId);

   List personal(LocalDateTime time, Long workShopId);

   Map personalSummary(LocalDateTime time, Long workShopId);

   List<AnalysisQhseDTO> analysisQhse(LocalDateTime time, Long workShopId);

   List<QhseDetailsDTO> analysisData(LocalDateTime time, Long workShopId);

   List<AppTaskProcessDTO> getMachinePartListByCutId(Long cutId, Long projectId, Long monomerId, Long areaId, String serialNumber);

   List<ProductMonitorKanbanDTO> getProductMonitorKanban(Long workshopId, Integer status, String name, List<Long> projectIds);

   List<MesBuildingProductionTaskDTO> getProductMonitorKanbanDetail(Long workshopId, Long projectId, Long monomerId, Long areaId);

   List<Integer> saveTeamReport(
      MesBuildingTaskProcess taskProcess,
      Integer reportQuantity,
      boolean isInspection,
      Boolean reportType,
      List<Integer> numberList,
      MesBuildingTeam team,
      MesBuildingAssist assist,
      Boolean booleOneCode
   );

   List<Integer> saveTeamReportV2(
      MesBuildingTaskProcess taskProcess,
      Integer reportQuantity,
      boolean isInspection,
      Boolean reportType,
      List<Integer> numberList,
      MesBuildingTeam team,
      MesBuildingAssist assist,
      Boolean booleOneCode,
      Long reportPersonId,
      BigDecimal perforateQuantity
   );

   Boolean saveSinglePartArtifactPaint(TechArtifact artifact, MesBuildingTaskProcess taskProcess, Integer reportQuantity, Long teamId, Long completeId);

   QuantityAndWeightDetailDO taskMeteByProject(Long projectId, LocalDateTime startDate, LocalDateTime endDate, Long workshopId);

   List<QuantityAndWeightDetailDO> listTaskMeteByProject(List<Long> projectIds, LocalDateTime startDate, LocalDateTime endDate, Long workshopId);

   QuantityAndWeightDetailDO unCompletTaskMeteByProject(
      Long projectId, LocalDateTime startDate, LocalDateTime endDate, List<Long> singleArtifactIds, Long workshopId
   );

   List<MesBuildingProductionTaskDTO> projectProgressingTaskList(
      Long projectId, Long monomerId, Long areaId, String serialNumber, LocalDateTime startDate, LocalDateTime endDate, Long workshopId
   );

   ListVO<ProjectTreeResponseVO> taskOrderProjectList();

   ListVO<ProjectTreeResponseVO> drillTaskOrderProjectList();

   List<ProductClassificationDTO> productTypeByTaskOrderId(Integer taskTypeEnum, Long taskOrderId, Integer boolLastProcessEnum);

   ProductMonitorKanbanBySummaryDTO getArtifactTaskMete(Long workshopId);

   List<ArtifactSchedulingDO> artifactSchedulingProjectList(LocalDateTime dateTime, Long workshopId, List<Long> projectIds);

   List<YearQuantityAndMeteDTO> artifactSchedulingMeteList(LocalDateTime dateTime, Long workshopId, Long projectId, Long monomerId);

   List<ArtifactSchedulingDetailDTO> artifactSchedulingDetail(
      LocalDateTime dateTime, Long workshopId, Long projectId, Long monomerId, Long areaId, String serialNumber
   );

   YearQuantityAndMeteDTO artifactSchedulingMeteByMonth(String startDate, String endDate, Long workshopId, Long projectId, Long monomerId);

   void saveAllSendPartArtifact(Long taskId, Integer quantity);

   Map<Long, Integer> minKitting(List<MesBuildingTask> taskList);

   List<MesBuildingProductionTaskDTO> projectProgressingList(
      Long projectId, Long monomerId, Long areaId, String serialNumber, List<Long> singleArtifactIds, Long workshopId
   );

   Boolean artifactChange(Long changeId, Long id, Integer newQuantity);

   @NotNull
   Map<Long, Integer> artShopCanChange(Long artifactId);

   Boolean checkBoolChangeWithIdenticalSens(Long id, Integer quantity);

   Boolean checkProductStatus(List<Long> productIds, Integer taskTypeEnum);

   PageVO<AppTaskOrderSummaryDTO> taskOrderProcessPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long processId,
      Integer taskTypeEnum,
      String serialNumber,
      String orderNumber,
      Integer boolLastProcessEnum,
      String sort,
      Integer pageNumber,
      Integer pageSize
   );

   PageVO<AppTaskOrderSummaryDTO> taskOrderProcessPageAV2(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long processId,
      Integer taskTypeEnum,
      String serialNumber,
      String orderNumber,
      Integer boolLastProcessEnum,
      String sort,
      Integer pageNumber,
      Integer pageSize
   );

   PageVO<AppTaskProcessDTO> pageArtifactProcessByTaskOrderIdAV2(
      Integer taskTypeEnum,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long processId,
      Long classId,
      String serialNumber,
      Boolean boolAssist,
      Long assistProdLineId,
      Long taskOrderId,
      Integer boolLastProcessEnum,
      Integer pageNumber,
      Integer pageSize
   );

   List<ArtifactStatusDTO> listArtifactStatus(List<Long> artifactIds);

   Map<Long, Long> addAllTaskProces(List<MesBuildingTask> tasks, Map<Long, TechArtifact> artifactMap, Map<Long, TechAssemble> assMap, Integer productType);

   void checkBoolMissing(List<AppTaskProcessDTO> dtoList, MesBuildingTaskOrder taskOrder, Integer taskTypeEnum, Boolean boolAssist);

   void checkBoolMissing2(List<AppTaskProcessDTO> dtoList, MesBuildingTaskOrder taskOrder, Integer taskTypeEnum, Boolean boolAssist);

   Boolean saveProduceInspection(List<InspectionReportSavedDTO> saveVORequest);

   PageVO<MesBuildingTaskProcessDTO> productTaskPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long processId,
      Integer taskTypeEnum,
      String serialNumber,
      String specification,
      String material,
      Long taskOrderId,
      String productionLineName,
      String productName,
      Boolean boolCompleteEnum,
      String sort,
      Integer pageNumber,
      Integer pageSize
   );
}
