package com.hzchum.scim.mes.building.core.mapper.task;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.dto.TwoQuantityDTO;
import com.hzchum.scim.common.core.api.pojo.vo.BimArtifactStatusDetailVO;
import com.hzchum.scim.mes.building.core.api.pojo._do.abnormal.AbonrmalTaskDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.ProductMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.productionAnalysis.HysteresisDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.productionStatements.ArtifactProductionStatementsDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.productionStatements.EnclosureProductionStatementsDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.productionStatements.ProductionStatementsDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.projectKanban.ArtifactSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.projectKanban.EnclosureSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.projectKanban.FormSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.projectKanban.KanBanMachinePartSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.projectKanban.ProcessSummaryDetailsDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.projectKanban.ProductKanBanDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.ArtifactSchedulingDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.TaskArtifactPrintDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.TaskEnclosurePrintDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.TaskPartPrintDO;
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
import com.hzchum.scim.mes.building.core.api.pojo._doParam.projectKanban.ProjectSummaryDOParam;
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
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ArtifactKanbanDetailDTO;
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
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.TeamScheduledInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.YearQuantityAndMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.LossStatisticsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.LossStatisticsDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingPartReportDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingProductionTaskDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingSteelFeedingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingTaskDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskProcessProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskTrackingProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.change.MesBuildingOrderProductDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.LineSchedulingInfoDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.manufacturingDeptProduction.TaskProductionVO;
import com.hzchum.scim.plan.core.api.pojo.dto.SendPurlinDTO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingTaskMapper extends BaseMapper<MesBuildingTask> {
   Integer countByCompleteAndProductProcessId(Long id);

   List<ProductKanBanDO> productKanban(ProductKanbanDOParam doParam);

   List<ProcessSummaryDetailsDO> getSummaryByIdAndType(@Param("id") Long id, @Param("type") Integer type);

   List<ProcessSummaryDetailsDO> getSummaryByTaskIdAndType(@Param("taskIds") List<Long> taskIds, @Param("type") Integer type);

   List<ProcessSummaryDetailsDO> getSummaryBySerialNumberAndType(
      @Param("serialNumber") String serialNumber, @Param("monomerId") Long monomerId, @Param("type") Integer type
   );

   List<ProcessSummaryDetailsDO> getSummaryByCondition(
      @Param("id") Long id, @Param("type") Integer type, @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate
   );

   ArtifactSummaryDO artifactSummaryByPeoject(ProjectSummaryDOParam doParam);

   List<EnclosureSummaryDO> enclosureSummaryByPeoject(ProjectSummaryDOParam doParam);

   List<ArtifactProductionStatementsDO> artifactlistByCondition(ProductionStatementsDOParam doParam);

   List<ProductionStatementsDO> listByCondition(ProductionStatementsDOParam doParam);

   List<EnclosureProductionStatementsDO> enclosurelistByCondition(ProductionStatementsDOParam doParam);

   List<HysteresisDO> hysteresisSummaryList(HysteresisDOParam doParam);

   List<HysteresisDO> hysteresisList(HysteresisDOParam doParam);

   List<TeamFormDO> teamFormProcessSummary(TeamFormDOParam doParam);

   List<TeamFormProcessDetailsDO> teamFormSummary(
      @Param("projectId") Long projectId,
      @Param("projectIds") List<Long> projectIds,
      @Param("productionLineIds") List<Long> productionLineId,
      @Param("productTypes") List<Integer> productType,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate
   );

   TeamFormProcessDetailsDO teamFormProcessDetail(
      @Param("projectId") Long projectId,
      @Param("projectIds") List<Long> projectIds,
      @Param("processId") Long processId,
      @Param("productionLineId") Long productionLineId,
      @Param("productType") Integer productType,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate
   );

   TeamFormProcessDetailsDO teamFormTaskProcessDetail(
      @Param("projectId") Long projectId,
      @Param("projectIds") List<Long> projectIds,
      @Param("processId") Long processId,
      @Param("productionLineId") Long productionLineId,
      @Param("productType") Integer productType,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate
   );

   List<TeamFormDetailsDO> teamFormProcessDetails(TeamFormDOParam doParam);

   List<TeamFormArtifactAssembleProcessDO> teamFormProcess(TeamFormDOParam doParam);

   ProcessSummaryDetailsDO formProcessDetails(
      @Param("taskId") Long taskId, @Param("processId") Long processId, @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate
   );

   List<TeamFormEnclosureDO> teamFormEnclosure(TeamFormDOParam doParam);

   List<TeamFormEnclosureDetailsDO> teamFormEnclosureDetails(TeamFormDOParam doParam);

   ProductMeteDO sumTaskMeteByCondition(@Param("monomerId") Long monomerId, @Param("factoryId") Long factoryId, @Param("productType") Integer productType);

   List<TaskArtifactPrintDO> listArtifactPrint(TaskArtifactPrintDOParam param);

   List<TaskPartPrintDO> listPartPrint(TaskPartPrintDOParam param);

   List<TaskPartPrintDO> listAssemblePrint(TaskPartPrintDOParam param);

   List<TaskEnclosurePrintDO> listEnclosurePrint(TaskEnclosurePrintDOParam param);

   List<AbonrmalTaskDO> taskQuantityList(@Param("productId") Long productId, @Param("productType") Integer productType);

   List<FormSummaryDO> formSummary(FormSummaryDOParam doParam);

   List<KanBanMachinePartSummaryDO> machinePartSteelSpec(ProductKanbanDOParam doParam);

   Integer selectTotalInProductQuantity(@Param("productId") Long productId, @Param("productType") Integer productType);

   List<BimArtifactStatusDetailVO> getBimArtifactAsStatus(
      @Param("productType") Integer productType,
      @Param("status") Integer status,
      @Param("monomerId") Long monomerId,
      @Param("areaIds") List<Long> areaIds,
      @Param("menuBar") Integer menuBar
   );

   List<AppCompleteSumDO> completeSum(@Param("projectId") Long projectId, @Param("monomerId") Long monomerId, @Param("productType") Integer productType);

   List<TaskProductDTO> getTaskByProductionLine(
      @Param("startTime") LocalDateTime startTime,
      @Param("endTime") LocalDateTime endTime,
      @Param("taskType") Integer taskType,
      @Param("workShopId") Long workShopId,
      @Param("projectId") Long projectId
   );

   List<TaskProductDTO> getAssembleProductionLine(
      @Param("startTime") LocalDateTime startTime,
      @Param("endTime") LocalDateTime endTime,
      @Param("taskType") Integer taskType,
      @Param("workShopId") Long workShopId,
      @Param("projectId") Long projectId
   );

   List<TaskProcessProductDTO> taskTrackProductionLineDetail(
      @Param("startTime") LocalDateTime startTime,
      @Param("endTime") LocalDateTime endTime,
      @Param("taskType") Integer taskType,
      @Param("productionLineId") Long productionLineId,
      @Param("projectIds") List<Long> projectIds,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("serialNumber") String serialNumber
   );

   List<TaskTrackingLineMonthDO> taskTrackingMonth(
      @Param("dateTime") LocalDateTime dateTime, @Param("workShopId") Long workShopId, @Param("productionLineId") Long productionLineId
   );

   List<TaskTrackingProductionLineDO> taskTrackingMonthDetail(
      @Param("dateTime") LocalDateTime dateTime, @Param("workShopId") Long workShopId, @Param("productionLineId") Long productionLineId
   );

   List<TaskTrackingProductDTO> taskTrackingMonthProject(
      @Param("dateTime") LocalDateTime dateTime,
      @Param("workShopId") Long workShopId,
      @Param("productionLineId") Long productionLineId,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("serialNumber") String serialNumber
   );

   List<TaskTrackingProductDTO> processSummaryDetail(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("dateTime") LocalDateTime dateTime,
      @Param("workshopId") Long workshopId,
      @Param("productionLineId") Long productionLineId,
      @Param("serialNumber") String serialNumber,
      @Param("taskType") Integer taskType,
      @Param("processId") Long processId,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("status") Integer status,
      @Param("assembleIds") List<Long> assembleIds,
      @Param("typesettingIds") List<Long> typesettingIds
   );

   List<TaskProcessProductDTO> groupTaskDetail(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("productId") Long productId,
      @Param("productionLineId") Long productionLineId,
      @Param("taskType") Integer taskType,
      @Param("processId") Long processId,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate
   );

   List<TaskProductDTO> taskProductionLineList(
      @Param("startTime") LocalDateTime startTime,
      @Param("endTime") LocalDateTime endTime,
      @Param("productType") Integer productType,
      @Param("type") Integer type,
      @Param("processId") Long processId
   );

   List<TaskProductDTO> getTaskAssembleProductionLine(
      @Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime, @Param("type") Integer type, @Param("processId") Long processId
   );

   List<ProductMonitorKanbanDTO> getProductMonitorKanban(
      @Param("workshopId") Long workshopId, @Param("status") Integer status, @Param("name") String name, @Param("projectIds") List<Long> projectIds
   );

   List<MesBuildingProductionTaskDTO> getProductMonitorKanbanDetail(
      @Param("workshopId") Long workshopId, @Param("projectId") Long projectId, @Param("monomerId") Long monomerId, @Param("areaId") Long areaId
   );

   QuantityAndWeightDetailDO taskMeteByProject(
      @Param("projectId") Long projectId,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("workshopId") Long workshopId
   );

   List<QuantityAndWeightDetailDO> listTaskMeteByProject(
      @Param("projectIds") List<Long> projectIds,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("workshopId") Long workshopId
   );

   QuantityAndWeightDetailDO unCompletTaskMeteByProject(
      @Param("projectId") Long projectId,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("singleArtifactIds") List<Long> singleArtifactIds,
      @Param("workshopId") Long workshopId
   );

   List<MesBuildingProductionTaskDTO> projectProgressingTaskList(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("serialNumber") String serialNumber,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("workshopId") Long workshopId
   );

   ProductMonitorKanbanBySummaryDTO getArtifactTaskMete(Long workshopId);

   List<MesBuildingTaskDTO> listTasks(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("areaBatchId") Long areaBatchId,
      @Param("productType") Integer productType
   );

   List<TaskProductionVO> getTaskProduction(@Param("date") Date date);

   List<ArtifactSchedulingDO> artifactSchedulingProjectList(
      @Param("dateTime") LocalDateTime dateTime, @Param("workshopId") Long workshopId, @Param("projectIds") List<Long> projectIds
   );

   List<YearQuantityAndMeteDTO> artifactSchedulingMeteList(
      @Param("dateTime") LocalDateTime dateTime, @Param("workshopId") Long workshopId, @Param("projectId") Long projectId, @Param("monomerId") Long monomerId
   );

   List<ArtifactSchedulingDetailDTO> artifactSchedulingDetail(
      @Param("dateTime") LocalDateTime dateTime,
      @Param("workshopId") Long workshopId,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("serialNumber") String serialNumber
   );

   YearQuantityAndMeteDTO artifactSchedulingMeteByMonth(
      @Param("startDate") String startDate,
      @Param("endDate") String endDate,
      @Param("workshopId") Long workshopId,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId
   );

   List<TaskTrackingProductDTO> taskSummaryDetail(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("workshopId") Long workshopId,
      @Param("productionLineId") Long productionLineId,
      @Param("serialNumber") String serialNumber,
      @Param("taskType") Integer taskType,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("status") Integer status,
      @Param("singleArtifactIds") List<Long> singleArtifactIds
   );

   List<SendPurlinDTO> listAssKitByTaskIds(@Param("taskId") Long taskId);

   List<SendPurlinDTO> listPartKitByTaskIds(@Param("taskId") Long taskId);

   List<MesBuildingProductionTaskDTO> projectProgressingList(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("serialNumber") String serialNumber,
      @Param("singleArtifactIds") List<Long> singleArtifactIds,
      @Param("workshopId") Long workshopId
   );

   Integer getLastOneCode(@Param("processId") Long processId, @Param("productId") Long productId);

   List<TaskPartPrintDO> partPrintSummary(TaskPartPrintDOParam param);

   List<TaskPartPrintDO> assPrintSummary(TaskPartPrintDOParam param);

   List<MesBuildingOrderProductDetailDTO> listOrderProduceDetail(@Param("orderIds") List<Long> orderIds);

   List<MesBuildingTask> listTasksByData(
      @Param("taskOrderId") Long taskOrderId,
      @Param("areaId") Long areaId,
      @Param("serialNumber") String serialNumber,
      @Param("specification") String specification,
      @Param("taskTypeEnum") Integer taskTypeEnum
   );

   List<TeamScheduledInfoDTO> findAssembleScheduledSummary(Long workshopId, Long projectId);

   List<TaskConditionByDateDTO> getEachWorkShopTaskCondition(@Param("date") LocalDateTime date);

   List<TeamEachMonthRateDTO> getEachTeamTaskCondition(@Param("teamIds") List<Long> teamIds, @Param("time") LocalDateTime time);

   List<WorkShopTaskCompleteDetailDTO> findWorkshopTaskPercentageDetail(@Param("date") LocalDateTime date, @Param("workShopId") Long workShopId);

   List<TeamTaskCompleteDetailDTO> getEachTeamTaskDetail(@Param("date") LocalDateTime date, @Param("teamId") Long teamId);

   List<ArtifactKanbanDetailDTO> getArtifactKanbanInfo(@Param("productId") Long productId);

   List<ProductKanBanInfoDTO> findArtifactAssembleLinkInfo(List<Long> productIds);

   List<TeamCapacityAnalysisDTO> findTeamCapacityAnalysis(
      @Param("teamIds") List<Long> teamIds, @Param("time") LocalDateTime time, @Param("projectIds") List<Long> projectIds
   );

   List<ProjectProductionKanBanListDTO> findKanBanArtifactTaskList(
      @Param("projectId") Long projectId,
      @Param("workShopId") Long workShopId,
      @Param("productionLineId") Long productionLineId,
      @Param("monomerId") Long monomerId,
      @Param("areaIds") List<Long> areaIds,
      @Param("classId") Long classId,
      @Param("serialNumber") String serialNumber,
      @Param("productKanBanEnum") Integer productKanBanEnum,
      @Param("dateTimeList") List<LocalDateTime> dateTimeList,
      @Param("areaBatchIds") List<Long> areaBatchIds,
      @Param("artifactIds") List<Long> artifactIds
   );

   List<ProjectKanBanIdAndQuantityDTO> findArtifactTaskAndPartTask(@Param("artifactTaskIds") List<Long> artifactTaskIds);

   List<ProjectKanArtifactTaskWorkShopDTO> findArtifactTaskAssistWorkShop(@Param("artifactTaskIds") List<Long> artifactTaskIds);

   List<ProjectKanBanProductProductionStateDTO> findSignageProductProductionStateList(
      @Param("projectId") Long projectId,
      @Param("productType") Integer productType,
      @Param("monomerId") Long monomerId,
      @Param("areaIds") List<Long> areaIds,
      @Param("workShopId") Long workShopId,
      @Param("productionLineId") Long productionLineId,
      @Param("classId") Long classId,
      @Param("serialNumber") String serialNumber,
      @Param("productKanBanCompanyEnum") Integer productKanBanCompanyEnum,
      @Param("areaBatchIds") List<Long> areaBatchIds
   );

   Integer findTotalAmountByDate(@Param("date") LocalDate date, @Param("workShopId") Long workShopId, @Param("format") String format);

   TwoQuantityDTO achievementRate(@Param("workShopId") Long workShopId);

   Integer findTotalQuantityByDate(@Param("date") LocalDate date, @Param("workShopId") Long workShopId, @Param("format") String format);

   List<ProjectKanBanProductProductionStateDTO> findArtifactSchedulingList(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaIds") List<Long> areaIds,
      @Param("classId") Long classId,
      @Param("serialNumber") String serialNumber,
      @Param("areaBatchIds") List<Long> areaBatchIds
   );

   List<WastageCostSummaryValueDTO> getTaskWastageLossCostSummary(
      @Param("projectId") Long projectId,
      @Param("workShopId") Long workShopId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("minYearMonth") String minYearMonth,
      @Param("maxYearMonth") String maxYearMonth,
      @Param("yearMonthDateList") List<LocalDate> yearMonthDateList
   );

   List<WastageCostSummaryValueDTO> getTaskCompleteWastageLossCostSummary(
      @Param("projectId") Long projectId,
      @Param("workShopId") Long workShopId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("minYearMonth") String minYearMonth,
      @Param("maxYearMonth") String maxYearMonth,
      @Param("yearMonthDateList") List<LocalDate> yearMonthDateList
   );

   List<WastageCostSummaryValueDTO> getTaskPendingProductsWastageLossCostSummary(
      @Param("projectId") Long projectId,
      @Param("workShopId") Long workShopId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("minYearMonth") String minYearMonth,
      @Param("maxYearMonth") String maxYearMonth,
      @Param("yearMonthDateList") List<LocalDate> yearMonthDateList
   );

   List<ProductWastageLossCostMesDetailDTO> getTaskProductSchedulingDetailList(
      @Param("dateTimeList") List<LocalDateTime> dateTimeList,
      @Param("projectId") Long projectId,
      @Param("workshopId") Long workShopId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("processId") Integer processId,
      @Param("serialNumber") String serialNumber,
      @Param("groupId") Long groupId,
      @Param("productionLineId") Long productionLineId,
      @Param("relationType") Integer relationType
   );

   List<ProductWastageLossCostMesDetailDTO> getTaskPendingProductsWastageLossCostDetailList(
      @Param("dateTimeList") List<LocalDateTime> dateTimeList,
      @Param("projectId") Long projectId,
      @Param("workshopId") Long workShopId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("processId") Integer processId,
      @Param("serialNumber") String serialNumber,
      @Param("groupId") Long groupId,
      @Param("productionLineId") Long productionLineId,
      @Param("relationType") Integer relationType
   );

   List<ProductWastageLossCostMesDetailDTO> getTaskProcessProductsWastageLossCostDetailList(
      @Param("dateTimeList") List<LocalDateTime> dateTimeList,
      @Param("projectId") Long projectId,
      @Param("workshopId") Long workShopId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("processId") Integer processId,
      @Param("serialNumber") String serialNumber,
      @Param("groupId") Long groupId,
      @Param("productionLineId") Long productionLineId,
      @Param("relationType") Integer relationType
   );

   List<ProductWastageLossCostMesDetailDTO> getTaskCompleteWastageLossCostDetailList(
      @Param("dateTimeList") List<LocalDateTime> dateTimeList,
      @Param("projectId") Long projectId,
      @Param("workshopId") Long workShopId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("processId") Integer processId,
      @Param("serialNumber") String serialNumber,
      @Param("groupId") Long groupId,
      @Param("productionLineId") Long productionLineId,
      @Param("relationType") Integer relationType
   );

   List<ProductWastageLossCostMesDetailDTO> getTaskProcessCompleteWastageLossCostDetailList(
      @Param("dateTimeList") List<LocalDateTime> dateTimeList,
      @Param("projectId") Long projectId,
      @Param("workshopId") Long workShopId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("processId") Integer processId,
      @Param("serialNumber") String serialNumber,
      @Param("groupId") Long groupId,
      @Param("productionLineId") Long productionLineId,
      @Param("relationType") Integer relationType
   );

   List<ProductWastageLossCostMesDetailDTO> getPartsAllocationDetailList(
      @Param("dateTimeList") List<LocalDateTime> dateTimeList,
      @Param("projectId") Long projectId,
      @Param("workshopId") Long workShopId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("processId") Integer processId,
      @Param("serialNumber") String serialNumber,
      @Param("groupId") Long groupId,
      @Param("productionLineId") Long productionLineId,
      @Param("oldRelationType") Integer relationType,
      @Param("relationTypeList") List<Integer> relationTypeList
   );

   List<WastageCostSummaryValueDTO> getPartsAllocationWastageLossCostSummary(
      @Param("projectId") Long projectId,
      @Param("workshopId") Long workShopId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("minYearMonth") String minYearMonth,
      @Param("maxYearMonth") String maxYearMonth,
      @Param("yearMonthDateList") List<LocalDate> yearMonthDateList,
      @Param("relationTypeList") List<Integer> relationTypeList
   );

   List<LossStatisticsDTO> getLossStatisticsList(
      @Param("workShopId") Long workShopId,
      @Param("branchCompanyId") Long branchCompanyId,
      @Param("projectStatus") Integer projectStatus,
      @Param("projectName") String projectName,
      @Param("date") String date
   );

   List<MesBuildingSteelFeedingDTO> getSteelFeedingDetail(@Param("projectId") Long projectId, @Param("workShopId") Long workShopId, @Param("date") String date);

   List<MesBuildingPartReportDetailDTO> getPartReportDetail(
      @Param("projectId") Long projectId, @Param("workShopId") Long workShopId, @Param("partType") Integer partType, @Param("date") String date
   );

   List<LossStatisticsDetailDTO> getLossStatisticsTaskDetail(
      @Param("projectId") Long projectId,
      @Param("workShopId") Long workShopId,
      @Param("projectStatus") Integer projectStatus,
      @Param("projectName") String projectName,
      @Param("date") String date
   );

   List<AvgProductionLineInfoDTO> getAvgProductionLineInfo(LineSchedulingInfoDTOParam param);

   List<OrderUncompletedInfoDTO> getOrderUncompletedInfo(LineSchedulingInfoDTOParam param);

   List<OrderArtifactDetailDTO> getOrderUncompletedDetailInfo(@Param("orderId") Long orderId, @Param("teamId") Long teamId);

   List<OrderArtifactDetailDTO> getCurrentProjectScheduling(
      @Param("projectId") Long projectId, @Param("serialNumber") String serialNumber, @Param("teamId") Long teamId
   );

   List<SchedulingArtifactSummaryDTO> findSchedulingArtifactSummary(@Param("projectId") Long projectId, @Param("monomerId") Long monomerId);

   List<SchedulingArtifactDetailDTO> findSchedulingArtifactDetail(MesBuildingArtifactSchedulingParam param);
}
