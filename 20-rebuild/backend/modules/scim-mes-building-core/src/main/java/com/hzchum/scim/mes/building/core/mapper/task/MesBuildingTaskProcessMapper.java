package com.hzchum.scim.mes.building.core.mapper.task;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.dto.DateQuantityDTO;
import com.hzchum.scim.common.core.api.pojo.dto.ProjectProductProcessDTO;
import com.hzchum.scim.common.core.api.pojo.vo.MesBuildingWIPStatisticsVO;
import com.hzchum.scim.mes.building.core.api.pojo._do.process.MesBuildingProcessDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.ProductProjectSumDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingArtifactTypeDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.ProductMonitorKanbanByGroupDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MaterialTaskDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MesBuildingProductionTaskDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MesBuildingTaskProcessDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MesBuildingTaskProcessMachinePartDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MesBuildingTaskProcessSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.SteelSpecTaskDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.TaskArtifactProcessDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.TaskEnclosureProcessDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.TaskMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.TaskProcessProductDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.TaskTrackingProcessDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.app.APPTaskProcessInspectionDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.app.AppTaskOrderProjectTreeDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.app.AppTaskOrderSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.app.AppTaskProcessDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.topTaskOrder.MesBuildingAssistProcessDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.topTaskOrder.MesBuildingAssistProductDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MesBuildingGroupsTreeDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.MesBuildingProductionLineTreeDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssist;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.ProjectProductionStatistics.ProjectProductionTaskDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.ProjectProcessingProgressDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.SimpleProjectProduceDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.TeamProjectProduceInfo;
import com.hzchum.scim.mes.building.core.api.pojo._dto.ProjectProductionStatistics.ProjectProductionTaskDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.app.AverageTaskDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.app.OverdueOverInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingGroupsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.lossWorkProgressStatistics.WastageCostSummaryValueDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProductProcessProgressDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProjectKanBanProductProductionStateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProjectProductionKanBanDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.InspectRealtimeInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesManualReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.CargoStatisticsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProcessReportListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingProcessLagDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingProcessNoProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingProductionPlanningDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ProductMonitorByGroupDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ProductMonitorKanbanByGroupDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.screen.ScreenMonthlyOutputDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.screen.ScreenProductionStatisticsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.screen.ScreenProjectProcessCompletionRateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.screen.ScreenTeamAchievementRateProductionLineDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingAssembleCompleteUseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingPartCompleteUseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingProductionTaskDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingTaskProcessInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingWIPStatisticsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingWIPStatisticsDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesInspectClassIdTeamIdDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesSignageProcessLinkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.ProcessAndLastProcesLinkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.ProcessSumDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.ProduceStatisticsProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.ProductProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.ProductProcessQuantityDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskArtifactProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskInventoryProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskProcessDullDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskProcessProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskTrackingProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.AppTaskProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.ProductClassificationDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.topTaskOrder.MesBuildingAssistProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.process.MesBuildingProductProcessDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesManualReportQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingTaskProcessQuery;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.ResponseVO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProductMeteDTO;
import com.hzchum.scim.system.core.api.pojo.dto.InsepctUserConditionDTO;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingTaskProcessMapper extends BaseMapper<MesBuildingTaskProcess> {
   List<MesBuildingTaskProcessDO> selectListByTeamListAndProjectIdList(
      @Param("teamIds") List<Long> teamIds,
      @Param("projectIds") List<Long> projectIds,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("serialNumber") String serialNumber,
      @Param("material") String material,
      @Param("productionLineName") String productionLineName,
      @Param("productName") String productName,
      @Param("boolCompleteEnum") Boolean boolCompleteEnum,
      @Param("processId") Long processId,
      @Param("dateTimeList") List<LocalDateTime> dateTimeList
   );

   List<AppTaskOrderSummaryDO> selectTaskOrderIdListNoGroup(
      @Param("teamIds") List<Long> teamIds,
      @Param("projectId") Long projectId,
      @Param("projectIds") List<Long> projectIds,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("processId") Long processId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("serialNumber") String serialNumber,
      @Param("orderNumber") String orderNumber,
      @Param("boolLastProcessEnum") Integer boolLastProcessEnum
   );

   List<AppTaskOrderProjectTreeDO> selectTaskOrderProjectTree(
      @Param("teamIds") List<Long> teamIds,
      @Param("projectId") Long projectId,
      @Param("projectIds") List<Long> projectIds,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("processId") Long processId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("serialNumber") String serialNumber,
      @Param("orderNumber") String orderNumber,
      @Param("boolLastProcessEnum") Integer boolLastProcessEnum
   );

   List<AppTaskOrderSummaryDO> selectTaskOrderIdListNoGroupJobId(
      @Param("teamIds") List<Long> teamIds,
      @Param("projectId") Long projectId,
      @Param("projectIds") List<Long> projectIds,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("processId") Long processId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("serialNumber") String serialNumber,
      @Param("orderNumber") String orderNumber,
      @Param("boolLastProcessEnum") Integer boolLastProcessEnum,
      @Param("jobId") Long jobId
   );

   List<AppTaskOrderSummaryDO> selectTaskOrderIdListNoGroupFinishProduct(
      @Param("teamIds") List<Long> teamIds,
      @Param("projectId") Long projectId,
      @Param("projectIds") List<Long> projectIds,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("processId") Long processId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("serialNumber") String serialNumber,
      @Param("orderNumber") String orderNumber,
      @Param("boolLastProcessEnum") Integer boolLastProcessEnum
   );

   List<AppTaskOrderSummaryDO> selectTaskOrderIdList(
      @Param("groupsTreeList") List<MesBuildingGroupsTreeDO> groupsTreeList,
      @Param("projectId") Long projectId,
      @Param("projectIds") List<Long> projectIds,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("processId") Long processId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("serialNumber") String serialNumber,
      @Param("orderNumber") String orderNumber,
      @Param("boolLastProcessEnum") Integer boolLastProcessEnum
   );

   List<AppTaskOrderSummaryDO> selectTaskOrderIdListByProcess(
      @Param("projectId") Long projectId,
      @Param("projectIds") List<Long> projectIds,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("processId") Long processId,
      @Param("userId") Long userId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("serialNumber") String serialNumber,
      @Param("orderNumber") String orderNumber,
      @Param("boolLastProcessEnum") Integer boolLastProcessEnum
   );

   List<AppTaskOrderSummaryDO> selectTaskOrderIdListByProcessAV2(
      @Param("projectId") Long projectId,
      @Param("projectIds") List<Long> projectIds,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("areaBatchId") Long areaBatchId,
      @Param("processId") Long processId,
      @Param("userId") Long userId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("serialNumber") String serialNumber,
      @Param("orderNumber") String orderNumber,
      @Param("boolLastProcessEnum") Integer boolLastProcessEnum
   );

   List<SteelSpecTaskDO> listSteelSpec(
      @Param("teamList") List<MesBuildingTeam> teamList,
      @Param("projectIds") List<Long> projectIds,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("processId") Long processId,
      @Param("serialNumber") String serialNumber,
      @Param("productName") String productName,
      @Param("taskId") Long taskId
   );

   List<MaterialTaskDO> listMaterial(
      @Param("teamList") List<MesBuildingTeam> teamList,
      @Param("projectIds") List<Long> projectIds,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("processId") Long processId,
      @Param("serialNumber") String serialNumber,
      @Param("productName") String productName,
      @Param("taskId") Long taskId
   );

   List<MesBuildingTaskProcessDO> selectListByAssistList(
      @Param("assistList") List<MesBuildingAssist> assistList,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("processId") Long processId,
      @Param("productType") Integer productType,
      @Param("serialNumber") String serialNumber,
      @Param("productName") String productName,
      @Param("taskId") Long taskId,
      @Param("completeStatus") Boolean completeStatus,
      @Param("productionLineName") String productionLineName,
      @Param("askDate") String askDate,
      @Param("processType") Boolean processType
   );

   List<MesBuildingTaskProcessDO> selectInspectionListByTeamListAndProjectIdList(
      @Param("processIdList") List<Long> processIdList,
      @Param("groupsIdList") List<Long> groupsIdList,
      @Param("projectIds") List<Long> projectIds,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("processId") Long processId,
      @Param("taskType") Integer taskType,
      @Param("serialNumber") String serialNumber,
      @Param("productName") String productName,
      @Param("taskId") Long taskId
   );

   List<APPTaskProcessInspectionDO> selectInspectionListByTeamList(
      @Param("groupsTreeList") List<MesBuildingGroupsTreeDO> groupsTreeList,
      @Param("projectIds") List<Long> projectIds,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("processId") Long processId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("serialNumber") String serialNumber,
      @Param("productName") String productName,
      @Param("taskId") Long taskId
   );

   List<APPTaskProcessInspectionDO> selectInspectionListByTeamList2(
      @Param("linesTreeList") List<MesBuildingProductionLineTreeDO> linesTreeList,
      @Param("projectIds") List<Long> projectIds,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("areaBatchId") Long areaBatchId,
      @Param("processId") Long processId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("serialNumber") String serialNumber,
      @Param("productName") String productName,
      @Param("taskId") Long taskId
   );

   List<APPTaskProcessInspectionDO> inspectionListByTeamListAndProjectIdList(
      @Param("processIdList") List<Long> processIdList,
      @Param("groupsIdList") List<Long> groupsIdList,
      @Param("projectIds") List<Long> projectIds,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("processId") Long processId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("serialNumber") String serialNumber,
      @Param("productName") String productName,
      @Param("taskId") Long taskId
   );

   Integer listProductTaskCount(
      @Param("teamList") List<Long> teamList,
      @Param("projectIds") List<Long> projectIds,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("processId") Long processId,
      @Param("productType") Integer productType
   );

   Integer selectListByAssistListCount(
      @Param("assistList") List<MesBuildingAssist> assistList,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("processId") Long processId,
      @Param("productType") Integer productType
   );

   Integer listProductTaskInspectionCount(
      @Param("teamList") List<Long> teamList,
      @Param("projectIds") List<Long> projectIds,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("processId") Long processId,
      @Param("productType") Integer productType
   );

   List<MesBuildingTaskProcess> listTaskProcessInspection(@Param("productionLineId") Long productionLineId, @Param("processId") Long processId);

   MesBuildingTaskProcessMachinePartDO selectTaskProcessMachinePartById(@Param("taskId") Long taskId, @Param("processId") Long processId);

   List<MesBuildingTaskProcessSummaryDO> getProcessAndQuantity(@Param("prodcutId") Long prodcutId, @Param("productType") Integer productType);

   List<ProductProjectSumDO> listGroupByProjectId(
      String year,
      String month,
      @Param("productionLineId") Long productionLineId,
      @Param("processId") Long processId,
      @Param("productType") Integer productType
   );

   List<TaskMeteDO> listGroupByMonth(
      @Param("year") String year,
      @Param("month") String month,
      @Param("projectId") Long projectId,
      @Param("productionLineId") Long productionLineId,
      @Param("processId") Long processId,
      @Param("productType") Integer productType
   );

   List<TaskArtifactProcessDO> listArtifactProcessByCondition(
      @Param("year") String year,
      @Param("month") String month,
      @Param("projectId") Long projectId,
      @Param("productionLineId") Long productionLineId,
      @Param("processId") Long processId,
      @Param("name") String name,
      @Param("serialNumber") String serialNumber
   );

   List<TaskEnclosureProcessDO> listEnclosureProcessByCondition(
      @Param("year") String year,
      @Param("month") String month,
      @Param("projectId") Long projectId,
      @Param("productionLineId") Long productionLineId,
      @Param("processId") Long processId,
      @Param("name") String name,
      @Param("serialNumber") String serialNumber
   );

   Boolean getProjectCompleteStatus(Long projectId);

   List<AppTaskProcessDO> listProductTaskByTaskOrderId(
      @Param("teamIds") List<Long> teamIds,
      @Param("processIdList") List<Long> processIdList,
      @Param("groupsId") Long groupsId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("serialNumber") String serialNumber,
      @Param("taskOrderId") Long taskOrderId,
      @Param("taskId") Long taskId,
      @Param("boolLastProcessEnum") Integer boolLastProcessEnum,
      @Param("classId") Long classId
   );

   List<AppTaskProcessDO> listProductTaskByTaskOrderId2(
      @Param("teamIds") List<Long> teamIds,
      @Param("lineId") Long lineId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("areaBatchId") Long areaBatchId,
      @Param("processId") Long processId,
      @Param("specification") String specification,
      @Param("serialNumber") String serialNumber,
      @Param("taskOrderId") Long taskOrderId,
      @Param("taskId") Long taskId,
      @Param("boolLastProcessEnum") Integer boolLastProcessEnum,
      @Param("classId") Long classId
   );

   List<AppTaskProcessDO> listProductAssistTask(@Param("ids") List<Long> ids, @Param("taskTypeEnum") Integer taskTypeEnum);

   List<AppTaskOrderSummaryDO> drillTaskOrderList(
      @Param("projectId") Long projectId,
      @Param("projectIds") List<Long> projectIds,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("orderNumber") String orderNumber,
      @Param("groupsIds") List<Long> groupsIds
   );

   List<AppTaskOrderProjectTreeDO> drillTaskOrderProjectTreeList(
      @Param("projectId") Long projectId,
      @Param("projectIds") List<Long> projectIds,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("orderNumber") String orderNumber,
      @Param("groupsIds") List<Long> groupsIds
   );

   List<AppTaskOrderSummaryDO> drillTaskOrderList2(
      @Param("projectId") Long projectId,
      @Param("projectIds") List<Long> projectIds,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("orderNumber") String orderNumber,
      @Param("lineIds") List<Long> lineIds
   );

   List<AppTaskProcessDO> listDrillTaskByTaskOrderId(@Param("nestCutPlateId") Long nestCutPlateId);

   List<MesBuildingProcessDO> getProcessList(@Param("taskType") Integer taskType, @Param("orderId") Long orderId);

   List<MesBuildingProductionTaskDO> getArtifactTaskProcessList(
      @Param("projectId") Long projectId,
      @Param("processId") Long processId,
      @Param("orderId") Long orderId,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("serialNumber") String serialNumber,
      @Param("specification") String specification,
      @Param("boolAccurateQuery") Boolean boolAccurateQuery
   );

   List<MesBuildingProductionTaskDO> getAssembleTaskProcessList(
      @Param("projectId") Long projectId,
      @Param("processId") Long processId,
      @Param("orderId") Long orderId,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("serialNumber") String serialNumber,
      @Param("specification") String specification,
      @Param("boolAccurateQuery") Boolean boolAccurateQuery
   );

   List<TaskTrackingProcessDO> taskTrackProcess(
      @Param("taskOrderId") Long taskOrderId,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("workshopId") Long workshopId,
      @Param("productionLineId") Long productionLineId,
      @Param("taskType") Integer taskType,
      @Param("assembleIds") List<Long> assembleIds,
      @Param("singleArtifactIds") List<Long> singleArtifactIds
   );

   List<TaskTrackingProcessDO> taskTrack(
      @Param("taskOrderId") Long taskOrderId,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("workshopId") Long workshopId,
      @Param("productionLineId") Long productionLineId,
      @Param("taskType") Integer taskType,
      @Param("singleArtifactIds") List<Long> singleArtifactIds
   );

   List<TaskTrackingProcessDO> taskOrderNumber(
      @Param("taskOrderId") Long taskOrderId, @Param("taskType") Integer taskType, Long workshopId, Long productionLineId
   );

   List<TaskArtifactProductDTO> taskArtifactList(
      @Param("taskOrderId") Long taskOrderId,
      @Param("workshopId") Long workshopId,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("productionLineId") Long productionLineId
   );

   List<TaskProcessProductDO> taskProcessProduct(
      @Param("processId") Long processId,
      @Param("taskType") Integer taskType,
      @Param("orderId") Long orderId,
      @Param("prodLineId") Long prodLineId,
      @Param("name") String name,
      @Param("projectIds") List<Long> projectIds,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("serialNumber") String serialNumber,
      @Param("assembleIds") List<Long> assembleIds
   );

   List<TaskProcessDullDTO> taskDullProcess(@Param("workShopId") Long workShopId);

   List<TaskProcessDullDTO> taskDullProcessByAssemble(@Param("workShopId") Long workShopId);

   List<TaskProcessProductDTO> taskDullProcessDetail(
      @Param("taskType") Integer taskType,
      @Param("processId") Long processId,
      @Param("productionLineId") Long productionLineId,
      @Param("projectIds") List<Long> projectIds,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("serialNumber") String serialNumber,
      @Param("groupId") Long groupId
   );

   List<TaskProcessDullDTO> taskDullProcessV2(
      @Param("workShopId") Long workShopId,
      @Param("productionLineId") Long productionLineId,
      @Param("projectId") Long projectId,
      @Param("processId") Long processId,
      @Param("teamId") Long teamId
   );

   List<TaskProcessDullDTO> taskDullProcessByAssembleV2(
      @Param("workShopId") Long workShopId,
      @Param("productionLineId") Long productionLineId,
      @Param("projectId") Long projectId,
      @Param("processId") Long processId,
      @Param("teamId") Long teamId
   );

   List<TaskProcessProductDTO> taskDullProcessDetailV2(
      @Param("taskType") Integer taskType,
      @Param("processId") Long processId,
      @Param("productionLineId") Long productionLineId,
      @Param("projectIds") List<Long> projectIds,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("serialNumber") String serialNumber,
      @Param("groupId") Long groupId
   );

   ProductMeteDTO getProductSummary(
      @Param("projectId") Long projectId, @Param("monomerId") Long monomerId, @Param("areaId") Long areaId, @Param("taskType") Integer taskType
   );

   ProductMeteDTO getAssembleSummary(Long projectId, Long monomerId, Long areaId);

   List<TaskTrackingProcessDTO> processSummaryProduct(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("dateTime") LocalDateTime dateTime,
      @Param("productionLineId") Long productionLineId,
      @Param("taskType") Integer taskType,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("workshopId") Long workshopId
   );

   List<MesBuildingAssistProcessDO> getAssistProcessListByTaskOrderIdList(@Param("taskOrderIds") List<Long> taskOrderIds);

   List<MesBuildingAssistProductDO> getProductAssistList(
      @Param("taskOrderId") Long taskOrderId,
      @Param("areaId") Long areaId,
      @Param("processId") Long processId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("serialNumber") String serialNumber,
      @Param("specification") String specification
   );

   ProcessSumDTO taskProcessDriling(@Param("processId") Long processId);

   List<TaskInventoryProcessDTO> getInventoryProcessSummary(
      @Param("projectId") Long projectId, @Param("monomerId") Long monomerId, @Param("areaId") Long areaId, @Param("taskType") Integer taskType
   );

   List<AppTaskProcessDTO> listCutTaskByTaskOrderId(
      @Param("nestCutPlateId") Long cutId,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("serialNumber") String serialNumber
   );

   List<MesBuildingProductionTaskDTO> projectProgressingProcessList(
      @Param("projectId") Long projectId,
      @Param("processId") Long processId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("serialNumber") String serialNumber,
      @Param("workshopId") Long workshopId
   );

   List<ProduceStatisticsProcessDTO> projectProcessList(@Param("projectId") Long projectId, @Param("workshopId") Long workshopId);

   List<ProduceStatisticsProcessDTO> listProjectProcessList(@Param("projectIds") List<Long> projectIds, @Param("workshopId") Long workshopId);

   List<ProductProcessQuantityDTO> listProductProcessByProductIdAndType(@Param("productId") Long productId, @Param("taskTypeEnum") Integer taskTypeEnum);

   List<ProductMonitorKanbanByGroupDTO> getMonitorKanbanByGroup(Long workshopId, Long processId, Integer taskTypeEnum);

   List<ProductMonitorKanbanByGroupDO> getProductByLastMonth(
      @Param("workshopId") Long workshopId, @Param("processId") Long processId, @Param("taskTypeEnum") Integer taskTypeEnum
   );

   List<ProductMonitorKanbanByGroupDO> getProductByYear(
      @Param("workshopId") Long workshopId, @Param("processId") Long processId, @Param("taskTypeEnum") Integer taskTypeEnum
   );

   List<ProductMonitorKanbanByGroupDO> getProductByUnComplete(
      @Param("workshopId") Long workshopId, @Param("processId") Long processId, @Param("taskTypeEnum") Integer taskTypeEnum
   );

   List<ProductMonitorByGroupDetailDTO> getProductMonitorKanbanByGroupDetail(
      @Param("workshopId") Long workshopId,
      @Param("productionLineId") Long productionLineId,
      @Param("groupId") Long groupId,
      @Param("teamId") Long teamId,
      @Param("processId") Long processId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("serialNumber") String serialNumber
   );

   List<ProductProcessDTO> productByConditionList(
      @Param("areaId") Long areaId,
      @Param("areaBatchId") Long areaBatchId,
      @Param("factoryId") Long factoryId,
      @Param("classificationId") Long classificationId,
      @Param("productionLineId") Long productionLineId,
      @Param("serialNumber") String serialNumber,
      @Param("specification") String specification,
      @Param("material") String material,
      @Param("taskTypeEnum") Integer taskTypeEnum
   );

   BigDecimal getMeteSummaryByCondition(
      @Param("dateTime") LocalDateTime dateTime, @Param("timeTypeEnum") Integer timeTypeEnum, @Param("taskTypeEnum") Integer taskTypeEnum
   );

   List<MesBuildingArtifactTypeDO> getProductTypeList(
      @Param("areaId") Long areaId, @Param("areaBatchId") Long areaBatchId, @Param("factoryId") Long factoryId, @Param("taskTypeEnum") Integer taskTypeEnum
   );

   List<ProduceStatisticsProcessDTO> taskProcessList(
      @Param("projectId") Long projectId, @Param("assembleIds") List<Long> assembleIds, @Param("machineIds") List<Long> machineIds
   );

   List<ResponseVO> manufacturingDeptProductionProcesses();

   List<ProductClassificationDTO> productTypeByTaskOrderId(
      @Param("processIdList") List<Long> processIdList,
      @Param("groupsId") Long groupsId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("taskOrderId") Long taskOrderId,
      @Param("boolLastProcessEnum") Integer boolLastProcessEnum
   );

   List<ProductClassificationDTO> productTypeByTaskOrderId2(
      @Param("processIdList") List<Long> processIdList,
      @Param("lineIds") List<Long> lineIds,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("taskOrderId") Long taskOrderId,
      @Param("boolLastProcessEnum") Integer boolLastProcessEnum
   );

   List<TaskProcessProductDO> taskProduct(
      @Param("taskType") Integer taskType,
      @Param("orderId") Long orderId,
      @Param("prodLineId") Long prodLineId,
      @Param("name") String name,
      @Param("projectIds") List<Long> projectIds,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("serialNumber") String serialNumber,
      @Param("singleArtifactIds") List<Long> singleArtifactIds
   );

   TaskTrackingProcessDTO processSummarySingleArtifact(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("productionLineId") Long productionLineId,
      @Param("productType") Integer productType,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("singleArtifactIds") List<Long> singleArtifactIds
   );

   List<MesBuildingAssistProductDTO> productProcessList(
      @Param("taskOrderId") Long taskOrderId,
      @Param("areaId") Long areaId,
      @Param("processId") Long processId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("serialNumber") String serialNumber,
      @Param("specification") String specification,
      @Param("taskProcessIdList") List<Long> taskProcessIdList,
      @Param("assistEnum") Integer assistEnum
   );

   List<Integer> listNumberList(@Param("taskId") Long taskId, @Param("sequence") Integer sequence);

   List<ProcessAndLastProcesLinkDTO> listLastProcess(@Param("allProcessIds") List<Long> allProcessIds);

   List<MesBuildingTaskProcess> findTaskQuantityByProcessId(@Param("processId") Long processId, @Param("userId") Long userId);

   List<MesBuildingTaskProcess> findTaskQuantityByProcessIdAV2(
      @Param("processId") Long processId, @Param("userId") Long userId, @Param("taskTypeEnum") Integer taskTypeEnum
   );

   List<ProcessReportListDTO> findProcessReportProjectList(
      @Param("processId") Long processId, @Param("projectName") String projectName, @Param("userId") Long userId
   );

   List<ProcessReportListDTO> findProcessReportProjectListAV2(
      @Param("processId") Long processId, @Param("projectName") String projectName, @Param("userId") Long userId, @Param("taskTypeEnum") Integer taskTypeEnum
   );

   AverageTaskDTO getAverageTaskCompletionRate(@Param("year") int year, @Param("processId") Long processId, @Param("userId") Long userId);

   AverageTaskDTO getAverageTaskCompletionOnAssist(@Param("year") int year, @Param("processId") Long processId, @Param("userId") Long userId);

   List<OverdueOverInfoDTO> getOverdueOrderInfo(@Param("processId") Long processId, @Param("userId") Long userId);

   List<AppTaskProcessDO> listProductAssistTaskByTaskOrderId(
      @Param("processIdList") List<Long> processIdList,
      @Param("groupsId") Long groupsId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("serialNumber") String serialNumber,
      @Param("taskOrderId") Long taskOrderId,
      @Param("taskId") Long taskId,
      @Param("boolLastProcessEnum") Integer boolLastProcessEnum,
      @Param("classId") Long classId
   );

   List<MesBuildingGroupsDTO> findProcessByTaskIds(@Param("taskIds") List<Long> taskIds, @Param("processId") Long processId);

   List<MesBuildingProcessLagDTO> scheduledTaskLagNumber(@Param("crrentTime") LocalDateTime crrentTime);

   List<MesBuildingProductionPlanningDTO> getProductionPlanningDateil(@Param("crrentTime") LocalDateTime crrentTime);

   List<AppTaskProcessDO> listTaskProcessByTaskOrderId(
      @Param("processIds") List<Long> processIds,
      @Param("groupsId") Long groupsId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("serialNumber") String serialNumber,
      @Param("taskOrderId") Long taskOrderId,
      @Param("taskId") Long taskId,
      @Param("boolLastProcessEnum") Integer boolLastProcessEnum,
      @Param("classId") Long classId
   );

   List<AppTaskOrderSummaryDO> selectTaskOrderIdList2(
      @Param("teamIds") List<Long> teamIds,
      @Param("projectId") Long projectId,
      @Param("projectIds") List<Long> projectIds,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("areaBatchId") Long areaBatchId,
      @Param("processId") Long processId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("serialNumber") String serialNumber,
      @Param("orderNumber") String orderNumber,
      @Param("boolLastProcessEnum") Integer boolLastProcessEnum
   );

   List<MesInspectClassIdTeamIdDTO> findTaskClassIdandTeamIdByInspectInfo(
      @Param("workshopId") Long workshopId, @Param("processId") Long processId, @Param("teamIds") List<Long> teamIds, @Param("classIds") List<Long> classIds
   );

   List<AppTaskProcessDO> listProductAssistTaskByTaskOrderIdAV2(
      @Param("processIdList") List<Long> processIdList,
      @Param("assistProdLineId") Long assistProdLineId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("areaBatchId") Long areaBatchId,
      @Param("serialNumber") String serialNumber,
      @Param("taskOrderId") Long taskOrderId,
      @Param("taskId") Long taskId,
      @Param("boolLastProcessEnum") Integer boolLastProcessEnum,
      @Param("classId") Long classId
   );

   List<ProjectProductProcessDTO> findProductTaskProcessProgress(
      @Param("artIds") List<Long> artIds,
      @Param("areaIds") List<Long> areaIds,
      @Param("monmerId") Long monmerId,
      @Param("areaId") Long areaId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("classId") Long classId,
      @Param("serialNumber") String serialNumber
   );

   List<ProjectProductProcessDTO> findArtifctAssembleLinkProgress(@Param("artIds") List<Long> artIds);

   List<ProductProcessProgressDetailDTO> findAssembleProcessDetails(
      @Param("productId") Long productId, @Param("processId") Long processId, @Param("classId") Long classId, @Param("serialNumber") String serialNumber
   );

   List<ProductProcessProgressDetailDTO> findArtifactProcessDetails(
      @Param("productId") Long productId, @Param("processId") Long processId, @Param("classId") Long classId, @Param("serialNumber") String serialNumber
   );

   List<MesBuildingTaskProcess> findProcessByProductProcess(
      @Param("dtoParam") MesBuildingProductProcessDTOParam dtoParam, @Param("processIds") List<Long> processIds
   );

   List<ProjectProductionTaskDetailDTO> getProjectProductionTaskDetail(@Param("dtoParam") ProjectProductionTaskDOParam param);

   List<ProjectProductionTaskDetailDTO> getProjectProductionTaskTeamDetail(@Param("dtoParam") ProjectProductionTaskDOParam param);

   List<ProjectProductionKanBanDetailDTO> getKanBanProcessProductDetail(
      @Param("taskIds") List<Long> taskIds, @Param("processId") Long processId, @Param("productType") Integer productType
   );

   List<ProjectProductionKanBanDetailDTO> getKanBanProcessInspectionProductDetail(
      @Param("taskIds") List<Long> taskIds, @Param("processId") Long processId, @Param("productType") Integer productType
   );

   List<ProjectProductionKanBanDetailDTO> getPartKanBanProcessProductDetail(@Param("taskId") Long taskId);

   List<ProjectProductionKanBanDetailDTO> getPartKanBanProcessProductDetailNew(@Param("partIds") List<Long> partIds);

   List<ProjectKanBanProductProductionStateDTO> findPartSignageProductProductionStateList(
      @Param("projectId") Long projectId,
      @Param("productType") Integer productType,
      @Param("monomerId") Long monomerId,
      @Param("areaIds") List<Long> areaIds,
      @Param("workShopId") Long workShopId,
      @Param("productionLineId") Long productionLineId,
      @Param("classId") Long classId,
      @Param("serialNumber") String serialNumber,
      @Param("productKanBanCompanyEnum") Integer productKanBanCompanyEnum,
      @Param("productClassificationEnum") Integer productClassificationEnum,
      @Param("processId") Long processId,
      @Param("areaBatchIds") List<Long> areaBatchIds
   );

   List<InspectRealtimeInfoDTO> findToBeInspectedInfo(
      @Param("treeCondition") List<InsepctUserConditionDTO> treeCondition,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("projectId") Long projectId,
      @Param("workShopId") Long workShopId,
      @Param("serialNumber") String serialNumber
   );

   List<InspectRealtimeInfoDTO> findToBeInspectedInfoV2(
      @Param("treeCondition") List<InsepctUserConditionDTO> treeCondition,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("projectIdList") Collection<Long> projectIdList,
      @Param("workShopId") Long workShopId
   );

   List<DateQuantityDTO> findWorkshopAchievements(@Param("workShopId") Long workShopId, @Param("date") LocalDate date);

   List<ScreenProjectProcessCompletionRateDTO> getProjectProcessCompletionRate(@Param("year") String year, @Param("workshopId") Long workshopId);

   List<ScreenProductionStatisticsDTO> getProductionStatistics(@Param("year") String year, @Param("workshopId") Long workshopId);

   List<ScreenTeamAchievementRateProductionLineDTO> getTeamAchievementRateMonthly(@Param("year") String year, @Param("workshopId") Long workshopId);

   List<ScreenTeamAchievementRateProductionLineDTO> getTeamAchievementRateYear(@Param("year") String year, @Param("workshopId") Long workshopId);

   List<ScreenMonthlyOutputDTO> getMonthlyOutput(@Param("year") String year, @Param("month") String month, @Param("workshopId") Long workshopId);

   List<TeamProjectProduceInfo> findTeamProjectProduceInfo(
      @Param("year") Integer year, @Param("workShopId") Long workShopId, @Param("productionId") Long productionId
   );

   List<ProjectProcessingProgressDTO> projectProcessingProgress(
      @Param("year") Integer year, @Param("workShopId") Long workShopId, @Param("productionId") Long productionId
   );

   List<SimpleProjectProduceDTO> projectTotalWeightProgress();

   List<SimpleProjectProduceDTO> projectTotalWeightProgressV2();

   List<MesBuildingProcessLagDTO> scheduledTaskLagNumber();

   List<MesBuildingProductionPlanningDTO> getProductionPlanningDateil();

   List<MesSignageProcessLinkDTO> listSignageProcess(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaIds") List<Long> areaIds,
      @Param("classId") Long classId,
      @Param("workshopId") Long workshopId,
      @Param("productionLineId") Long productionLineId,
      @Param("productSerialNumber") String productSerialNumber,
      @Param("areaBatchIds") List<Long> areaBatchIds,
      @Param("artifactIds") List<Long> artifactIds
   );

   List<MesBuildingProcessNoProcessDTO> getNoProcessTeam(@Param("taskOrderIds") List<Long> taskOrderIds);

   List<MesManualReportDTO> manualReportUnreportedList(MesManualReportQuery query);

   List<WastageCostSummaryValueDTO> getTaskProcessWastageLossCostSummary(
      @Param("projectId") Long projectId,
      @Param("workShopId") Long workShopId,
      @Param("processId") Long processId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("minYearMonth") String minYearMonth,
      @Param("maxYearMonth") String maxYearMonth,
      @Param("yearMonthDateList") List<LocalDate> yearMonthDateList
   );

   List<WastageCostSummaryValueDTO> getTaskProcessCompleteWastageLossCostSummary(
      @Param("projectId") Long projectId,
      @Param("workShopId") Long workShopId,
      @Param("processId") Long processId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("minYearMonth") String minYearMonth,
      @Param("maxYearMonth") String maxYearMonth,
      @Param("yearMonthDateList") List<LocalDate> yearMonthDateList
   );

   List<WastageCostSummaryValueDTO> getTaskProcessPendingProductsWastageLossCostSummary(
      @Param("projectId") Long projectId,
      @Param("workShopId") Long workShopId,
      @Param("processId") Long processId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("minYearMonth") String minYearMonth,
      @Param("maxYearMonth") String maxYearMonth,
      @Param("yearMonthDateList") List<LocalDate> yearMonthDateList
   );

   List<MesBuildingWIPStatisticsDTO> findWipStatisticsList(MesBuildingWIPStatisticsVO query);

   List<CargoStatisticsDTO> findCargoStatisticsList(MesBuildingWIPStatisticsVO query);

   List<MesBuildingWIPStatisticsDetailDTO> findWipStatisticsDetail(MesBuildingWIPStatisticsVO query);

   List<MesBuildingTaskProcessInfoDTO> listInfo(MesBuildingTaskProcessQuery query);

   List<JSONObject> productionKanbanLagInfo(
      @Param("projectIdList") Collection<Long> projectIdList, @Param("workshopId") Long workshopId, @Param("now") LocalDate now
   );

   List<MesBuildingPartCompleteUseDTO> selectPartCompleteUse();

   List<MesBuildingAssembleCompleteUseDTO> selectAssembleCompleteUse();

   List<MesBuildingWIPStatisticsDetailDTO> findWarehouseWipStatisticsDetail();
}
