package com.hzchum.scim.mes.building.core.api.service.task;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
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
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProcessReportListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProcessReportSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingProcessLagDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingProcessNoProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingProductionPlanningDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ProductMonitorByGroupDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.ProductMonitorKanbanByGroupDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingTaskProcessInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingTaskProcessSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingWIPStatisticsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingWIPStatisticsDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingWipDailySnapshotProcessDTO;
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
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.screen.ScreenMonthlyOutputVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.screen.ScreenProductionStatisticsVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.screen.ScreenTeamAchievementRateProductionLineVO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProductMeteDTO;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.pojo.dto.InsepctUserConditionDTO;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingTaskProcessService extends IService<MesBuildingTaskProcess> {
   List<MesBuildingTaskProcess> listTaskProcessInspection(Long productionLineId, Long processId);

   List<MesBuildingTaskProcessDO> selectListByTeamListAndProjectIdList(
      List<Long> teamIds,
      List<Long> projectIds,
      Long monomerId,
      Long areaId,
      Integer taskTypeEnum,
      String serialNumber,
      String material,
      String productionLineName,
      String productName,
      Boolean boolCompleteEnum,
      Long processId,
      List<LocalDateTime> dateTimeList
   );

   List<AppTaskOrderSummaryDO> selectTaskOrderIdListNoGroup(
      List<Long> teamIds,
      Long projectId,
      List<Long> projectIds,
      Long monomerId,
      Long areaId,
      Long processId,
      Integer taskTypeEnum,
      String serialNumber,
      String orderNumber,
      Integer boolLastProcessEnum
   );

   List<AppTaskOrderProjectTreeDO> selectTaskOrderProjectTree(
      List<Long> teamIds,
      Long projectId,
      List<Long> projectIds,
      Long monomerId,
      Long areaId,
      Long processId,
      Integer taskTypeEnum,
      String serialNumber,
      String orderNumber,
      Integer boolLastProcessEnum
   );

   List<AppTaskOrderSummaryDO> selectTaskOrderIdListNoGroupJobId(
      List<Long> teamIds,
      Long projectId,
      List<Long> projectIds,
      Long monomerId,
      Long areaId,
      Long processId,
      Integer taskTypeEnum,
      String serialNumber,
      String orderNumber,
      Integer boolLastProcessEnum,
      Long jobId
   );

   List<AppTaskOrderSummaryDO> selectTaskOrderIdListNoGroupFinishProduct(
      List<Long> teamIds,
      Long projectId,
      List<Long> projectIds,
      Long monomerId,
      Long areaId,
      Long processId,
      Integer taskTypeEnum,
      String serialNumber,
      String orderNumber,
      Integer boolLastProcessEnum
   );

   List<AppTaskOrderSummaryDO> selectTaskOrderIdList(
      List<MesBuildingGroupsTreeDO> groupsTreeList,
      Long projectId,
      List<Long> projectIds,
      Long monomerId,
      Long areaId,
      Long processId,
      Integer taskTypeEnum,
      String serialNumber,
      String orderNumber,
      Integer boolLastProcessEnum
   );

   List<AppTaskOrderSummaryDO> selectTaskOrderIdList2(
      List<Long> teamIds,
      Long projectId,
      List<Long> projectIds,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long processId,
      Integer taskTypeEnum,
      String serialNumber,
      String orderNumber,
      Integer boolLastProcessEnum
   );

   List<AppTaskOrderSummaryDO> selectTaskOrderIdListByProcess(
      Long projectId,
      List<Long> projectIds,
      Long monomerId,
      Long areaId,
      Long processId,
      Long userId,
      Integer taskTypeEnum,
      String serialNumber,
      String orderNumber,
      Integer boolLastProcessEnum
   );

   List<AppTaskOrderSummaryDO> selectTaskOrderIdListByProcessAV2(
      Long projectId,
      List<Long> projectIds,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long processId,
      Long userId,
      Integer taskTypeEnum,
      String serialNumber,
      String orderNumber,
      Integer boolLastProcessEnum
   );

   List<SteelSpecTaskDO> listSteelSpec(
      List<MesBuildingTeam> teamList,
      List<Long> projectIds,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long processId,
      String serialNumber,
      String productName,
      Long taskId
   );

   List<MaterialTaskDO> listMaterial(
      List<MesBuildingTeam> teamList,
      List<Long> projectIds,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long processId,
      String serialNumber,
      String productName,
      Long taskId
   );

   List<MesBuildingTaskProcessDO> selectListByAssistList(
      List<MesBuildingAssist> assistList,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long processId,
      Integer productType,
      String serialNumber,
      String productName,
      Long taskId,
      Boolean completeStatus,
      String productionLineName,
      String askDate,
      Boolean processType
   );

   MesBuildingTaskProcessMachinePartDO selectTaskProcessMachinePartById(Long taskId, Long processId);

   List<MesBuildingTaskProcessDO> selectInspectionListByTeamListAndProjectIdList(
      List<Long> processIdList,
      List<Long> groupsIdList,
      List<Long> projectIds,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long processId,
      Integer productType,
      String serialNumber,
      String productName,
      Long taskId
   );

   List<APPTaskProcessInspectionDO> selectInspectionListByTeamList(
      List<MesBuildingGroupsTreeDO> groupsTreeList,
      List<Long> projectIds,
      Long monomerId,
      Long areaId,
      Long processId,
      Integer productType,
      String serialNumber,
      String productName,
      Long taskId
   );

   List<APPTaskProcessInspectionDO> selectInspectionListByTeamList2(
      List<MesBuildingProductionLineTreeDO> linesTreeList,
      List<Long> projectIds,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long processId,
      Integer productType,
      String serialNumber,
      String productName,
      Long taskId
   );

   List<APPTaskProcessInspectionDO> selectInspectionListByTeamListAndProjectIdList(
      List<Long> processIdList,
      List<Long> groupsIdList,
      List<Long> projectIds,
      Long monomerId,
      Long areaId,
      Long processId,
      Integer taskTypeEnum,
      String serialNumber,
      String productName,
      Long taskId
   );

   Integer listProductTaskCount(List<Long> teamList, List<Long> projectIds, Long projectId, Long monomerId, Long areaId, Long processId, Integer productType);

   Integer selectListByAssistListCount(List<MesBuildingAssist> assistList, Long projectId, Long monomerId, Long areaId, Long processId, Integer productType);

   Integer listProductTaskInspectionCount(
      List<Long> teamList, List<Long> projectIds, Long projectId, Long monomerId, Long areaId, Long processId, Integer productType
   );

   List<MesBuildingTaskProcessSummaryDTO> getProcessAndQuantity(Long prodcutId, Integer productType);

   List<ProductProjectSumDO> listGroupByProjectId(String year, String month, Long productionLineId, Long processId, Integer productType);

   List<TaskMeteDO> listGroupByMonth(String year, String month, Long projectId, Long productionLineId, Long processId, Integer productType);

   List<TaskArtifactProcessDO> listArtifactProcessByCondition(
      String month, String date, Long projectId, Long productionLineId, Long processId, String name, String serialNumber
   );

   List<TaskEnclosureProcessDO> listEnclosureProcessByCondition(
      String month, String date, Long projectId, Long productionLineId, Long processId, String name, String serialNumber
   );

   Boolean getProjectCompleteStatus(Long projectId);

   List<AppTaskProcessDO> listProductTaskByTaskOrderId(
      List<Long> processIdList,
      Long groupsId,
      Integer taskTypeEnum,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Long taskOrderId,
      Long taskId,
      Integer boolLastProcessEnum,
      Long classId
   );

   List<AppTaskProcessDO> listProductAssistTaskByTaskOrderId(
      List<Long> processIdList,
      Long groupsId,
      Integer taskTypeEnum,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Long taskOrderId,
      Long taskId,
      Integer boolLastProcessEnum,
      Long classId
   );

   List<AppTaskProcessDO> listProductAssistTaskByTaskOrderIdAV2(
      List<Long> processIdList,
      Long assistProdLineId,
      Integer taskTypeEnum,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      String serialNumber,
      Long taskOrderId,
      Long taskId,
      Integer boolLastProcessEnum,
      Long classId
   );

   List<AppTaskProcessDO> listProductTaskByTaskOrderId2(
      List<Long> teamIds,
      Long lineId,
      Integer taskTypeEnum,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long processId,
      String specification,
      String serialNumber,
      Long taskOrderId,
      Long taskId,
      Integer boolLastProcessEnum,
      Long classId
   );

   List<AppTaskProcessDO> listProductAssistTask(List<Long> IdList, Integer taskTypeEnum);

   List<AppTaskOrderSummaryDO> drillTaskOrderList(Long projectId, List<Long> projectIds, Long monomerId, Long areaId, String orderNumber, List<Long> groupsIds);

   List<AppTaskOrderProjectTreeDO> drillTaskOrderProjectTreeList(
      Long projectId, List<Long> projectIds, Long monomerId, Long areaId, String orderNumber, List<Long> groupsIds
   );

   List<AppTaskOrderSummaryDO> drillTaskOrderList2(Long projectId, List<Long> projectIds, Long monomerId, Long areaId, String orderNumber, List<Long> lineIds);

   List<AppTaskProcessDO> listDrillTaskByTaskOrderId(Long nestCutPlateId);

   List<MesBuildingProcessDO> getProcessList(Integer taskType, Long orderId);

   List<MesBuildingProductionTaskDO> getArtifactTaskProcessList(
      Long projectId,
      Long processId,
      Long orderId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String serialNumber,
      String specification,
      Boolean boolAccurateQuery
   );

   List<MesBuildingProductionTaskDO> getAssembleTaskProcessList(
      Long projectId,
      Long processId,
      Long orderId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String serialNumber,
      String specification,
      Boolean boolAccurateQuery
   );

   List<TaskTrackingProcessDO> taskTrackProcess(
      Long taskOrderId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      Long productionLineId,
      Integer taskType,
      List<Long> assembleIds,
      List<Long> singleArtifactIds
   );

   List<TaskTrackingProcessDO> taskTrack(
      Long taskOrderId, Long projectId, Long monomerId, Long areaId, Long workshopId, Long productionLineId, Integer taskTypeEnum, List<Long> singleArtifactIds
   );

   List<TaskTrackingProcessDO> taskOrderNumber(Long taskOrderId, Integer taskTypeEnum, Long workshopId, Long productionLineId);

   List<TaskArtifactProductDTO> taskArtifactList(Long taskOrderId, Long projectId, Long monomerId, Long areaId, Long workshopId, Long productionLineId);

   List<TaskProcessProductDO> taskProcessProduct(
      Long processId,
      Integer taskType,
      Long orderId,
      Long prodLineId,
      String name,
      List<Long> projectIds,
      Long monomerId,
      Long areaId,
      String serialNumber,
      List<Long> assembleIds
   );

   List<TaskProcessDullDTO> taskDullProcess(Long workShopId);

   List<TaskProcessDullDTO> taskDullProcessByAssemble(Long workShopId);

   List<TaskProcessProductDTO> taskDullProcessDetail(
      Integer taskType, Long processId, Long productionLineId, List<Long> projectIds, Long monomerId, Long areaId, String serialNumber, Long groupId
   );

   ProductMeteDTO getProductSummary(Long projectId, Long monomerId, Long areaId, Integer taskType);

   ProductMeteDTO getAssembleSummary(Long projectId, Long monomerId, Long areaId);

   List<TaskTrackingProcessDTO> processSummaryProduct(
      Long projectId,
      Long monomerId,
      Long areaId,
      LocalDateTime dateTime,
      Long productionLineId,
      Integer taskType,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long workshopId
   );

   List<MesBuildingAssistProcessDO> getAssistProcessListByTaskOrderIdList(List<Long> taskOrderIds);

   List<MesBuildingAssistProductDO> getProductAssistList(
      Long taskOrderId, Long areaId, Long processId, Integer taskTypeEnum, String serialNumber, String specification
   );

   ProcessSumDTO taskProcessDriling(Long processId);

   List<TaskInventoryProcessDTO> getInventoryProcessSummary(Long projectId, Long monomerId, Long areaId, Integer taskType);

   List<ProduceStatisticsProcessDTO> projectProcessList(Long projectId, Long workshopId);

   List<ProduceStatisticsProcessDTO> listProjectProcessList(List<Long> projectIds, Long workshopId);

   List<AppTaskProcessDTO> listCutTaskByTaskOrderId(Long cutId, Long projectId, Long monomerId, Long areaId, String serialNumber);

   List<ProductProcessQuantityDTO> listProductProcessByProductIdAndType(Long id, Integer taskTypeEnum);

   List<ProductMonitorKanbanByGroupDTO> getMonitorKanbanByGroup(Long workshopId, Long processId, Integer taskTypeEnum);

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

   List<ProductProcessDTO> productByConditionList(
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

   BigDecimal getMeteSummaryByCondition(LocalDateTime dateTime, Integer timeTypeEnum, Integer taskTypeEnum);

   List<MesBuildingArtifactTypeDO> getProductTypeList(Long areaId, Long areaBatchId, Long factoryId, Integer taskTypeEnum);

   List<ProduceStatisticsProcessDTO> taskProcessList(Long projectId, List<Long> assembleIds, List<Long> machineIds);

   List<ResponseVO> manufacturingDeptProductionProcesses();

   List<ProductClassificationDTO> productTypeByTaskOrderId(
      List<Long> processIdList, Long groupsId, Integer taskTypeEnum, Long taskOrderId, Integer boolLastProcessEnum
   );

   List<ProductClassificationDTO> productTypeByTaskOrderId2(
      List<Long> processIdList, List<Long> lineIds, Integer taskTypeEnum, Long taskOrderId, Integer boolLastProcessEnum
   );

   List<TaskProcessProductDO> taskProduct(
      Integer taskType,
      Long orderId,
      Long groupId,
      String name,
      List<Long> projectIds,
      Long monomerId,
      Long areaId,
      String serialNumber,
      List<Long> singleArtifactIds
   );

   TaskTrackingProcessDTO processSummarySingleArtifact(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long productionLineId,
      Integer productType,
      LocalDateTime startDate,
      LocalDateTime endDate,
      List<Long> singleArtifactIds
   );

   List<MesBuildingAssistProductDTO> productProcessList(
      Long taskOrderId,
      Long areaId,
      Long processId,
      Integer taskTypeEnum,
      String serialNumber,
      String specification,
      List<Long> taskProcessIdList,
      Integer assistEnum
   );

   List<ProcessAndLastProcesLinkDTO> listLastProcess(List<Long> allProcessIds);

   ProcessReportSummaryDTO getProcessReportSummary(Long processId, SecurityUser user);

   ProcessReportSummaryDTO getProcessReportSummaryAV2(Long processId, SecurityUser user);

   List<ProcessReportListDTO> findProcessReportProjectList(Long processId, String projectName, SecurityUser user);

   List<ProcessReportListDTO> findProcessReportProjectListAV2(Long processId, String projectName, SecurityUser user);

   AverageTaskDTO getAverageTaskCompletionRate(int y, Long processId, Long userId);

   AverageTaskDTO getAverageTaskCompletionOnAssist(int y, Long processId, Long userId);

   List<OverdueOverInfoDTO> getOverdueOrderInfo(Long processId, Long userId);

   List<MesBuildingGroupsDTO> findProcessByTaskIds(List<Long> taskIds, Long processId);

   List<AppTaskProcessDO> listTaskProcessByTaskOrderId(
      List<Long> processIds,
      Long groupsId,
      Integer taskTypeEnum,
      Long monomerId,
      Long areaId,
      String serialNumber,
      Long taskOrderId,
      Long taskId,
      Integer boolLastProcessEnum,
      Long classId
   );

   List<MesInspectClassIdTeamIdDTO> findTaskClassIdandTeamIdByInspectInfo(Long workshopId, Long processId, List<Long> teamIds, List<Long> classIds);

   List<ProjectProductProcessDTO> findProductTaskProcessProgress(
      List<Long> artIds, List<Long> areaIds, Long monmerId, Long areaId, Integer taskTypeEnum, Long classId, String serialNumber
   );

   List<ProjectProductProcessDTO> findArtifctAssembleLinkProgress(List<Long> artIds);

   List<ProductProcessProgressDetailDTO> findAssembleProcessDetails(Long productId, Long processId, Long classId, String serialNumber);

   List<ProductProcessProgressDetailDTO> findArtifactProcessDetails(Long productId, Long processId, Long classId, String serialNumber);

   List<MesBuildingTaskProcess> findProcessByProductPorcess(MesBuildingProductProcessDTOParam dtoParam, List<Long> processIds);

   List<ProjectProductionTaskDetailDTO> getProjectProductionTaskDetail(ProjectProductionTaskDOParam param);

   List<ProjectProductionTaskDetailDTO> getProjectProductionTaskTeamDetail(ProjectProductionTaskDOParam param);

   List<ProjectProductionKanBanDetailDTO> getKanBanProcessProductDetail(List<Long> taskIds, Long processId, Integer productType);

   List<ProjectProductionKanBanDetailDTO> getKanBanProcessInspectionProductDetail(List<Long> taskIds, Long processId, Integer productType);

   List<ProjectProductionKanBanDetailDTO> getPartKanBanProcessProductDetail(Long taskId);

   List<ProjectProductionKanBanDetailDTO> getPartKanBanProcessProductDetailNew(List<Long> partIds);

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
      List<InsepctUserConditionDTO> treeCondition, LocalDateTime startDate, LocalDateTime endDate, Long projectId, Long workShopId, String serialNumber
   );

   List<InspectRealtimeInfoDTO> findToBeInspectedInfoV2(
      List<InsepctUserConditionDTO> treeCondition, LocalDateTime startDate, LocalDateTime endDate, Collection<Long> projectIdList, Long workShopId
   );

   List<DateQuantityDTO> findWorkshopAchievements(Long workShopId, LocalDate date);

   Object getProjectProcessCompletionRate(String year, Long workshopId);

   List<ScreenProductionStatisticsVO> getProductionStatistics(String year, Long workshopId);

   List<ScreenTeamAchievementRateProductionLineVO> getTeamAchievementRate(String year, Long workshopId);

   List<ScreenMonthlyOutputVO> getMonthlyOutput(String year, String month, Long workshopId);

   List<TeamProjectProduceInfo> findTeamProjectProduceInfo(Integer year, Long workShopId, Long productionId);

   List<ProjectProcessingProgressDTO> projectProcessingProgress(int year, Long workShopId, Long productionId);

   List<SimpleProjectProduceDTO> projectTotalWeightProgress();

   List<SimpleProjectProduceDTO> projectTotalWeightProgressV2();

   List<MesBuildingProcessLagDTO> scheduledTaskLagNumber(LocalDateTime crrentTime);

   List<MesBuildingProductionPlanningDTO> getProductionPlanningDateil(LocalDateTime crrentTime);

   List<MesSignageProcessLinkDTO> listSignageProcess(
      Long projectId,
      Long monomerId,
      List<Long> areaIds,
      Long classId,
      Long workshopId,
      Long productionLineId,
      String productSerialNumber,
      List<Long> areaBatchIds,
      List<Long> artifactIds
   );

   List<MesBuildingProcessNoProcessDTO> getNoProcessTeam(List<Long> taskOrderIds);

   List<MesManualReportDTO> manualReportUnreportedList(MesManualReportQuery query);

   List<WastageCostSummaryValueDTO> getTaskProcessWastageLossCostSummary(
      Long projectId, Long workShopId, Long processId, Integer taskTypeEnum, String minYearMonth, String maxYearMonth, List<LocalDate> yearMonthDateList
   );

   List<WastageCostSummaryValueDTO> getTaskProcessCompleteWastageLossCostSummary(
      Long projectId, Long workShopId, Long processId, Integer taskTypeEnum, String minYearMonth, String maxYearMonth, List<LocalDate> yearMonthDateList
   );

   List<WastageCostSummaryValueDTO> getTaskProcessPendingProductsWastageLossCostSummary(
      Long projectId, Long workShopId, Long processId, Integer taskTypeEnum, String minYearMonth, String maxYearMonth, List<LocalDate> yearMonthDateList
   );

   List<MesBuildingWipDailySnapshotProcessDTO> findWipStatisticsProcessList(MesBuildingWIPStatisticsVO query);

   List<MesBuildingWIPStatisticsDTO> findWipStatisticsList(MesBuildingWIPStatisticsVO query);

   List<MesBuildingWIPStatisticsDetailDTO> findWipStatisticsDetail(MesBuildingWIPStatisticsVO query);

   List<MesBuildingTaskProcessInfoDTO> listInfo(MesBuildingTaskProcessQuery query);

   List<JSONObject> productionKanbanLagInfo(Collection<Long> projectIdList, Long workshopId);
}
