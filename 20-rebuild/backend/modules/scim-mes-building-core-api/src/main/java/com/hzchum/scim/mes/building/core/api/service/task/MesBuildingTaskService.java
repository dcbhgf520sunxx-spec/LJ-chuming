package com.hzchum.scim.mes.building.core.api.service.task;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.common.core.api.pojo.dto.TwoQuantityDTO;
import com.hzchum.scim.common.core.api.pojo.vo.BimArtifactStatusDetailVO;
import com.hzchum.scim.mes.building.core.api.pojo._do.abnormal.AbonrmalTaskDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.ProductMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.productionAnalysis.HysteresisDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.projectKanban.ArtifactSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.projectKanban.EnclosureSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.projectKanban.FormSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.projectKanban.KanBanMachinePartSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.projectKanban.ProcessSummaryDetailsDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.projectKanban.ProductKanBanDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.ArtifactSchedulingDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.TaskTrackingLineMonthDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.TaskTrackingProductionLineDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.app.AppCompleteSumDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.teamForm.TeamFormArtifactAssembleProcessDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.teamForm.TeamFormDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.teamForm.TeamFormDetailsDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.teamForm.TeamFormEnclosureDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.teamForm.TeamFormEnclosureDetailsDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.teamForm.TeamFormProcessDetailsDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.QuantityAndWeightDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.productionAnalysis.HysteresisDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.productionStatements.ProductionStatementsDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.projectKanban.FormSummaryDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.projectKanban.ProductKanbanDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.record.TaskArtifactPrintDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.record.TaskEnclosurePrintDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.record.TaskPartPrintDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.scheduling.MesBuildingArtifactSchedulingParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.teamForm.TeamFormDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.AvgProductionLineInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.OrderArtifactDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.OrderUncompletedInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.SchedulingArtifactDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.SchedulingArtifactSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.lossWorkProgressStatistics.ProductWastageLossCostMesDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.lossWorkProgressStatistics.WastageCostSummaryValueDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.productionStatements.ArtifactProductionStatementsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.productionStatements.ProductionStatementsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.productionStatements.SummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ArtifactKanbanDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProcessSummaryDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProductKanBanInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProjectKanArtifactTaskWorkShopDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProjectKanBanIdAndQuantityDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProjectKanBanProductProductionStateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProjectProductionKanBanListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.TaskConditionByDateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.TeamCapacityAnalysisDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.TeamEachMonthRateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.TeamTaskCompleteDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.WorkShopTaskCompleteDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ArtifactSchedulingDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ProductMonitorKanbanBySummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ProductMonitorKanbanDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.YearQuantityAndMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.LossStatisticsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.LossStatisticsDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.LossStatisticsSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingPartReportDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingProductionTaskDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingSteelFeedingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingTaskDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskProcessProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskTrackingProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.change.MesBuildingOrderProductDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.LineSchedulingInfoDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.productionStatements.ProductionStatementsDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.projectKanban.ProjectSummaryDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.manufacturingDeptProduction.TaskProductionVO;
import com.hzchum.scim.plan.core.api.pojo.dto.SendPurlinDTO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface MesBuildingTaskService extends IService<MesBuildingTask> {
   Integer countByCompleteAndProductProcessId(Long id);

   List<KanBanMachinePartSummaryDO> machinePartSteelSpec(ProductKanbanDOParam doParam);

   List<ProductKanBanDO> productKanban(ProductKanbanDOParam doParam);

   List<ProcessSummaryDetailsDTO> getSummaryByIdAndType(Long id, Integer type);

   List<ProcessSummaryDetailsDTO> getSummaryBySerialNumberAndType(String serialNumber, Long monomerId, Integer type);

   List<ProcessSummaryDetailsDTO> getSummaryByTaskIdAndType(List<Long> taskIds, Integer type);

   List<ProcessSummaryDetailsDTO> getSummaryByCondition(Long id, Integer type, LocalDateTime startDate, LocalDateTime endDate);

   ArtifactSummaryDO artifactSummary(ProjectSummaryDTOParam dtoParam);

   List<EnclosureSummaryDO> enclosureSummary(ProjectSummaryDTOParam dtoParam);

   SummaryDTO summary(ProductionStatementsDOParam copy);

   List<ArtifactProductionStatementsDTO> artifactlistByCondition(ProductionStatementsDTOParam dtoParam);

   List<ProductionStatementsDTO> listByCondition(ProductionStatementsDOParam dtoParam);

   PageVO<ProductionStatementsDTO> pageByCondition(ProductionStatementsDOParam doParam, Integer pageNumber, Integer pageSize);

   PrintVO<List<Map<String, Object>>> print(ProductionStatementsDOParam param);

   List<HysteresisDO> hysteresisSummaryList(HysteresisDOParam doParam);

   List<HysteresisDO> hysteresisList(HysteresisDOParam doParam);

   List<TeamFormDO> teamFormProcessSummary(TeamFormDOParam doParam);

   List<TeamFormProcessDetailsDO> teamFormSummary(
      Long projectId, List<Long> projectIds, List<Long> productionLineIds, List<Integer> productTypes, LocalDateTime startDate, LocalDateTime endDate
   );

   TeamFormProcessDetailsDO teamFormProcessDetail(
      Long projectId, List<Long> projectIds, Long processId, Long productionLineId, Integer productType, LocalDateTime startDate, LocalDateTime endDate
   );

   TeamFormProcessDetailsDO teamFormTaskProcessDetail(
      Long projectId, List<Long> projectIds, Long processId, Long productionLineId, Integer productType, LocalDateTime startDate, LocalDateTime endDate
   );

   List<TeamFormDetailsDO> teamFormProcessDetails(TeamFormDOParam doParam);

   List<TeamFormArtifactAssembleProcessDO> teamFormProcess(TeamFormDOParam doParam);

   ProcessSummaryDetailsDO processSummary(Long taskId, Long processId, LocalDateTime startDate, LocalDateTime endDate);

   List<TeamFormEnclosureDO> teamFormEnclosure(TeamFormDOParam doParam);

   List<TeamFormEnclosureDetailsDO> teamFormEnclosureDetails(TeamFormDOParam doParam);

   ProductMeteDO sumTaskMeteByCondition(Long monomerId, Long factoryId, Integer productType);

   PageVO listArtifactPrint(TaskArtifactPrintDOParam param);

   PageVO listPartPrint(TaskPartPrintDOParam param);

   PageVO listEnclosurePrint(TaskEnclosurePrintDOParam param);

   List<AbonrmalTaskDO> taskQuantityList(Long productId, Integer productType);

   Boolean checkStatus(Long productionLine);

   List<FormSummaryDO> formSummary(FormSummaryDOParam doParam);

   Integer getTotalInProductQuantity(Long productId, Integer productType);

   List<BimArtifactStatusDetailVO> getBimArtifactAsStatus(Integer productType, Integer status, Long monomerId, List<Long> areaIds, Integer menuBar);

   List<AppCompleteSumDO> completeSum(Long projectId, Long monomerId, Integer productType);

   List<TaskProductDTO> getTaskByProductionLine(LocalDateTime startTime, LocalDateTime endTime, Integer taskType, Long workShopId, Long projectId);

   List<TaskProductDTO> getAssembleProductionLine(LocalDateTime startTime, LocalDateTime endTime, Integer taskType, Long workShopId, Long projectId);

   List<TaskProcessProductDTO> taskTrackProductionLineDetail(
      LocalDateTime startTime,
      LocalDateTime endTime,
      Integer taskType,
      Long productionLineId,
      List<Long> projectIds,
      Long monomerId,
      Long areaId,
      String serialNumber
   );

   List<TaskTrackingLineMonthDO> taskTrackingMonth(LocalDateTime dateTime, Long workShopId, Long productionLineId);

   List<TaskTrackingProductionLineDO> taskTrackingMonthDetail(LocalDateTime dateTime, Long workShopId, Long productionLineId);

   List<TaskTrackingProductDTO> taskTrackingMonthProject(
      LocalDateTime dateTime, Long workShopId, Long productionLineId, Long projectId, Long monomerId, Long areaId, String serialNumber
   );

   List<TaskTrackingProductDTO> processSummaryDetail(
      Long projectId,
      Long monomerId,
      Long areaId,
      LocalDateTime dateTime,
      Long workshopId,
      Long productionLineId,
      String serialNumber,
      Integer taskType,
      Long processId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer status,
      List<Long> assembleIds,
      List<Long> typesettingIds
   );

   List<TaskProcessProductDTO> groupTaskDetail(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long productId,
      Long productionLineId,
      Integer taskType,
      Long processId,
      LocalDateTime startDate,
      LocalDateTime endDate
   );

   List<TaskProductDTO> taskProductionLineList(LocalDateTime startTime, LocalDateTime endTime, Integer productType, Integer type, Long processId);

   List<TaskProductDTO> getTaskAssembleProductionLine(LocalDateTime startTime, LocalDateTime endTime, Integer type, Long processId);

   List<ProductMonitorKanbanDTO> getProductMonitorKanban(Long workshopId, Integer status, String name, List<Long> projectIds);

   List<MesBuildingProductionTaskDTO> getProductMonitorKanbanDetail(Long workshopId, Long projectId, Long monomerId, Long areaId);

   QuantityAndWeightDetailDO taskMeteByProject(Long projectId, LocalDateTime startDate, LocalDateTime endDate, Long workshopId);

   List<QuantityAndWeightDetailDO> listTaskMeteByProject(List<Long> projectIds, LocalDateTime startDate, LocalDateTime endDate, Long workshopId);

   List<MesBuildingProductionTaskDTO> projectProgressingTaskList(
      Long projectId, Long monomerId, Long areaId, String serialNumber, LocalDateTime startDate, LocalDateTime endDate, Long workshopId
   );

   ProductMonitorKanbanBySummaryDTO getArtifactTaskMete(Long workshopId);

   List<TaskProductionVO> getTaskProduction(Date date);

   List<MesBuildingTaskDTO> listTasks(Long projectId, Long monomerId, Long areaId, Long areaBatchId, Integer productType);

   List<ArtifactSchedulingDO> artifactSchedulingProjectList(LocalDateTime dateTime, Long workshopId, List<Long> projectIds);

   List<YearQuantityAndMeteDTO> artifactSchedulingMeteList(LocalDateTime dateTime, Long workshopId, Long projectId, Long monomerId);

   List<ArtifactSchedulingDetailDTO> artifactSchedulingDetail(
      LocalDateTime dateTime, Long workshopId, Long projectId, Long monomerId, Long areaId, String serialNumber
   );

   YearQuantityAndMeteDTO artifactSchedulingMeteByMonth(String startDate, String endDate, Long workshopId, Long projectId, Long monomerId);

   List<TaskTrackingProductDTO> taskSummaryDetail(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      Long productionLineId,
      String serialNumber,
      Integer taskType,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer status,
      List<Long> singleArtifactIds
   );

   List<SendPurlinDTO> listAssKitByTaskIds(Long taskId);

   List<SendPurlinDTO> listPartKitByTaskIds(Long taskId);

   List<MesBuildingOrderProductDetailDTO> listOrderProduceDetail(List<Long> orderIds);

   List<MesBuildingTask> listTasksByData(Long taskOrderId, Long areaId, String serialNumber, String specification, Integer taskType);

   List<TaskConditionByDateDTO> getEachWorkShopTaskCondition(LocalDateTime date);

   List<TeamEachMonthRateDTO> getEachTeamTaskCondition(List<Long> teamIds, LocalDateTime time);

   List<WorkShopTaskCompleteDetailDTO> findWorkshopTaskPercentageDetail(LocalDateTime date, Long workShopId);

   List<TeamTaskCompleteDetailDTO> getEachTeamTaskDetail(LocalDateTime date, Long teamId);

   List<ArtifactKanbanDetailDTO> getArtifactKanbanInfo(Long productId);

   List<ProductKanBanInfoDTO> findArtifactAssembleLinkInfo(List<Long> productId);

   List<TeamCapacityAnalysisDTO> findTeamCapacityAnalysis(List<Long> teamIds, LocalDateTime time, List<Long> projectIds);

   List<ProjectProductionKanBanListDTO> findKanBanArtifactTaskList(
      Long projectId,
      Long workShopId,
      Long productionLineId,
      Long monomerId,
      List<Long> areaIds,
      Long classId,
      String serialNumber,
      Integer productKanBanEnum,
      List<LocalDateTime> dateTimeList,
      List<Long> areaBatchIds,
      List<Long> artifactIds
   );

   List<ProjectKanBanIdAndQuantityDTO> findArtifactTaskAndPartTask(List<Long> artifactTaskIds);

   List<ProjectKanArtifactTaskWorkShopDTO> findArtifactTaskAssistWorkShop(List<Long> artifactTaskIds);

   List<ProjectKanBanProductProductionStateDTO> findSignageProductProductionStateList(
      Long projectId,
      Integer productType,
      Long monomerId,
      List<Long> areaIds,
      Long workShopId,
      Long productionLineId,
      Long classId,
      String serialNumber,
      Integer productKanBanCompanyEnum,
      List<Long> areaBatchIds
   );

   List<ProjectKanBanProductProductionStateDTO> findArtifactSchedulingList(
      Long projectId, Long monomerId, List<Long> areaIds, Long classId, String serialNumber, List<Long> areaBatchIds
   );

   Integer findTotalAmountByDate(LocalDate year, Long workShopId, String format);

   Integer findTotalQuantityByDate(LocalDate date, Long workShopId, String format);

   TwoQuantityDTO achievementRate(Long workShopId);

   List<WastageCostSummaryValueDTO> getTaskWastageLossCostSummary(
      Long projectId, Long workShopId, Integer taskTypeEnum, String minYearMonth, String maxYearMonth, List<LocalDate> yearMonthDateList
   );

   List<WastageCostSummaryValueDTO> getTaskCompleteWastageLossCostSummary(
      Long projectId, Long workShopId, Integer taskTypeEnum, String minYearMonth, String maxYearMonth, List<LocalDate> yearMonthDateList
   );

   List<WastageCostSummaryValueDTO> getTaskPendingProductsWastageLossCostSummary(
      Long projectId, Long workShopId, Integer taskTypeEnum, String minYearMonth, String maxYearMonth, List<LocalDate> yearMonthDateList
   );

   List<ProductWastageLossCostMesDetailDTO> getTaskProductSchedulingDetailList(
      List<LocalDateTime> dateTimeList,
      Long projectId,
      Long workShopId,
      Integer taskTypeEnum,
      Integer processId,
      String serialNumber,
      Long groupId,
      Long productionLineId,
      Integer relationType
   );

   List<ProductWastageLossCostMesDetailDTO> getTaskPendingProductsWastageLossCostDetailList(
      List<LocalDateTime> dateTimeList,
      Long projectId,
      Long workShopId,
      Integer taskTypeEnum,
      Integer processId,
      String serialNumber,
      Long groupId,
      Long productionLineId,
      Integer relationType
   );

   List<ProductWastageLossCostMesDetailDTO> getTaskProcessProductsWastageLossCostDetailList(
      List<LocalDateTime> dateTimeList,
      Long projectId,
      Long workShopId,
      Integer taskTypeEnum,
      Integer processId,
      String serialNumber,
      Long groupId,
      Long productionLineId,
      Integer relationType
   );

   List<ProductWastageLossCostMesDetailDTO> getTaskCompleteWastageLossCostDetailList(
      List<LocalDateTime> dateTimeList,
      Long projectId,
      Long workShopId,
      Integer taskTypeEnum,
      Integer processId,
      String serialNumber,
      Long groupId,
      Long productionLineId,
      Integer relationType
   );

   List<ProductWastageLossCostMesDetailDTO> getTaskProcessCompleteWastageLossCostDetailList(
      List<LocalDateTime> dateTimeList,
      Long projectId,
      Long workShopId,
      Integer taskTypeEnum,
      Integer processId,
      String serialNumber,
      Long groupId,
      Long productionLineId,
      Integer relationType
   );

   List<ProductWastageLossCostMesDetailDTO> getPartsAllocationDetailList(
      List<LocalDateTime> dateTimeList,
      Long projectId,
      Long workShopId,
      Integer taskTypeEnum,
      Integer processId,
      String serialNumber,
      Long groupId,
      Long productionLineId,
      Integer relationType,
      List<Integer> relationTypeList
   );

   List<WastageCostSummaryValueDTO> getPartsAllocationWastageLossCostSummary(
      Long projectId,
      Long workShopId,
      Integer taskTypeEnum,
      String minYearMonth,
      String maxYearMonth,
      List<LocalDate> yearMonthDateList,
      List<Integer> relationTypeList
   );

   PageVO<LossStatisticsDTO> getLossStatisticsList(
      Long workShopId, Long branchCompanyId, Integer projectStatus, String projectName, String date, Integer pageNumber, Integer pageSize
   );

   PrintVO<List<LossStatisticsDTO>> getLossStatisticsListPrint(Long workShopId, Long branchCompanyId, Integer projectStatus, String projectName, String date);

   List<LossStatisticsDetailDTO> getLossStatisticsTaskDetail(Long projectId, Long workShopId, Integer projectStatus, String projectName, String date);

   LossStatisticsSummaryDTO getLossStatisticsSummary(Long workShopId, Long branchCompanyId, Integer projectStatus, String projectName, String date);

   List<MesBuildingSteelFeedingDTO> getSteelFeedingDetail(Long projectId, Long workShopId, Integer basicClass, String date);

   PrintVO<List<MesBuildingSteelFeedingDTO>> getSteelFeedingDetailPrint(Long projectId, Long workShopId, Integer basicClass, String date);

   List<MesBuildingPartReportDetailDTO> getPartReportDetail(Long projectId, Long workShopId, Integer partType, String date);

   PrintVO<List<MesBuildingPartReportDetailDTO>> getPartReportDetailPrint(Long projectId, Long workShopId, Integer partType, String date);

   PrintVO<List<LossStatisticsDetailDTO>> getLossStatisticsTaskDetailPrint(
      Long projectId, Long workShopId, Integer projectStatus, String projectName, String year
   );

   List<AvgProductionLineInfoDTO> getAvgProductionLineInfo(LineSchedulingInfoDTOParam param);

   List<OrderUncompletedInfoDTO> getOrderUncompletedInfo(LineSchedulingInfoDTOParam param);

   List<OrderArtifactDetailDTO> getOrderUncompletedDetailInfo(Long orderId, Long teamId);

   List<OrderArtifactDetailDTO> getCurrentProjectScheduling(Long projectId, String serialNumber, Long teamId);

   List<SchedulingArtifactSummaryDTO> findSchedulingArtifactSummary(Long projectId, Long monomerId);

   List<SchedulingArtifactDetailDTO> findSchedulingArtifactDetail(MesBuildingArtifactSchedulingParam param);
}
