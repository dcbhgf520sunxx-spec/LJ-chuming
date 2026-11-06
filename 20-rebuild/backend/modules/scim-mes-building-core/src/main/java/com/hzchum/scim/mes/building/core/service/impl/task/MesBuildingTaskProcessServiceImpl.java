package com.hzchum.scim.mes.building.core.service.impl.task;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSONObject;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.dto.DateQuantityDTO;
import com.hzchum.scim.common.core.api.pojo.dto.ProjectProductProcessDTO;
import com.hzchum.scim.common.core.api.pojo.vo.MesBuildingWIPStatisticsVO;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
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
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssist;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssistNumberDetail;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNumberLink;
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
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProcessAndQuantityDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProcessReportListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProcessReportSummaryDTO;
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
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.topTaskOrder.MesBuildingAssistOrderDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.topTaskOrder.MesBuildingAssistProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.topTaskOrder.MesBuildingAssistProjectDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.process.MesBuildingProductProcessDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesManualReportQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingTaskProcessQuery;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.ResponseVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.screen.ScreenMonthlyOutputVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.screen.ScreenProductionStatisticsVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.screen.ScreenProjectProcessCompletionRate1VO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.screen.ScreenProjectProcessCompletionRateVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.screen.ScreenTeamAchievementRateProductionLineVO;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingGroupsTeamLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingAssistService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.utils.SerialNumberComparatorUtils;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingTaskProcessMapper;
import com.hzchum.scim.plan.core.api.pojo.dto.ProductMeteDTO;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.pojo.dto.InsepctUserConditionDTO;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingTaskProcessServiceImpl
   extends ServiceImpl<MesBuildingTaskProcessMapper, MesBuildingTaskProcess>
   implements MesBuildingTaskProcessService {
   @Resource
   private MesBuildingProduceTeamReportService teamReportService;
   @Resource
   private MesBuildingTeamUserLinkService teamUserLinkService;
   @Resource
   private MesBuildingTeamService teamService;
   @Resource
   private MesBuildingAssistService assistService;
   @Resource
   private MesBuildingGroupsTeamLinkService teamLinkService;
   @Resource
   private MesBuildingProcessService processService;
   @Resource
   private MesBuildingAssistNumberDetailServiceImpl assistNumberDetailService;
   @Resource
   private MesBuildingTaskNumberLinkService taskNumberLinkService;
   @Resource
   private MesBuildingCompleteService completeService;

   @Override
   public List<MesBuildingTaskProcess> listTaskProcessInspection(Long productionLineId, Long processId) {
      return this.baseMapper.listTaskProcessInspection(productionLineId, processId);
   }

   @Override
   public List<MesBuildingTaskProcessDO> selectListByTeamListAndProjectIdList(
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
   ) {
      return this.baseMapper
         .selectListByTeamListAndProjectIdList(
            teamIds,
            projectIds,
            monomerId,
            areaId,
            taskTypeEnum,
            serialNumber,
            material,
            productionLineName,
            productName,
            boolCompleteEnum,
            processId,
            dateTimeList
         );
   }

   @Override
   public List<AppTaskOrderSummaryDO> selectTaskOrderIdListNoGroup(
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
   ) {
      return this.baseMapper
         .selectTaskOrderIdListNoGroup(
            teamIds, projectId, projectIds, monomerId, areaId, processId, taskTypeEnum, serialNumber, orderNumber, boolLastProcessEnum
         );
   }

   @Override
   public List<AppTaskOrderProjectTreeDO> selectTaskOrderProjectTree(
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
   ) {
      return this.baseMapper
         .selectTaskOrderProjectTree(teamIds, projectId, projectIds, monomerId, areaId, processId, taskTypeEnum, serialNumber, orderNumber, boolLastProcessEnum);
   }

   @Override
   public List<AppTaskOrderSummaryDO> selectTaskOrderIdListNoGroupJobId(
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
   ) {
      return this.baseMapper
         .selectTaskOrderIdListNoGroupJobId(
            teamIds, projectId, projectIds, monomerId, areaId, processId, taskTypeEnum, serialNumber, orderNumber, boolLastProcessEnum, jobId
         );
   }

   @Override
   public List<AppTaskOrderSummaryDO> selectTaskOrderIdListNoGroupFinishProduct(
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
   ) {
      return this.baseMapper
         .selectTaskOrderIdListNoGroupFinishProduct(
            teamIds, projectId, projectIds, monomerId, areaId, processId, taskTypeEnum, serialNumber, orderNumber, boolLastProcessEnum
         );
   }

   @Override
   public List<AppTaskOrderSummaryDO> selectTaskOrderIdList(
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
   ) {
      return this.baseMapper
         .selectTaskOrderIdList(
            groupsTreeList, projectId, projectIds, monomerId, areaId, processId, taskTypeEnum, serialNumber, orderNumber, boolLastProcessEnum
         );
   }

   @Override
   public List<AppTaskOrderSummaryDO> selectTaskOrderIdList2(
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
   ) {
      return this.baseMapper
         .selectTaskOrderIdList2(
            teamIds, projectId, projectIds, monomerId, areaId, areaBatchId, processId, taskTypeEnum, serialNumber, orderNumber, boolLastProcessEnum
         );
   }

   @Override
   public List<AppTaskOrderSummaryDO> selectTaskOrderIdListByProcess(
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
   ) {
      return this.baseMapper
         .selectTaskOrderIdListByProcess(
            projectId, projectIds, monomerId, areaId, processId, userId, taskTypeEnum, serialNumber, orderNumber, boolLastProcessEnum
         );
   }

   @Override
   public List<AppTaskOrderSummaryDO> selectTaskOrderIdListByProcessAV2(
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
   ) {
      return this.baseMapper
         .selectTaskOrderIdListByProcessAV2(
            projectId, projectIds, monomerId, areaId, areaBatchId, processId, userId, taskTypeEnum, serialNumber, orderNumber, boolLastProcessEnum
         );
   }

   @Override
   public List<SteelSpecTaskDO> listSteelSpec(
      List<MesBuildingTeam> teamList,
      List<Long> projectIds,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long processId,
      String serialNumber,
      String productName,
      Long taskId
   ) {
      return this.baseMapper.listSteelSpec(teamList, projectIds, projectId, monomerId, areaId, processId, serialNumber, productName, taskId);
   }

   @Override
   public List<MaterialTaskDO> listMaterial(
      List<MesBuildingTeam> teamList,
      List<Long> projectIds,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long processId,
      String serialNumber,
      String productName,
      Long taskId
   ) {
      return this.baseMapper.listMaterial(teamList, projectIds, projectId, monomerId, areaId, processId, serialNumber, productName, taskId);
   }

   @Override
   public List<MesBuildingTaskProcessDO> selectListByAssistList(
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
   ) {
      return this.baseMapper
         .selectListByAssistList(
            assistList,
            projectId,
            monomerId,
            areaId,
            processId,
            productType,
            serialNumber,
            productName,
            taskId,
            completeStatus,
            productionLineName,
            askDate,
            processType
         );
   }

   @Override
   public MesBuildingTaskProcessMachinePartDO selectTaskProcessMachinePartById(Long taskId, Long processId) {
      return this.baseMapper.selectTaskProcessMachinePartById(taskId, processId);
   }

   @Override
   public List<MesBuildingTaskProcessDO> selectInspectionListByTeamListAndProjectIdList(
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
   ) {
      return this.baseMapper
         .selectInspectionListByTeamListAndProjectIdList(
            processIdList, groupsIdList, projectIds, projectId, monomerId, areaId, processId, productType, serialNumber, productName, taskId
         );
   }

   @Override
   public List<APPTaskProcessInspectionDO> selectInspectionListByTeamList(
      List<MesBuildingGroupsTreeDO> groupsTreeList,
      List<Long> projectIds,
      Long monomerId,
      Long areaId,
      Long processId,
      Integer taskTypeEnum,
      String serialNumber,
      String productName,
      Long taskId
   ) {
      List<APPTaskProcessInspectionDO> doList = this.baseMapper
         .selectInspectionListByTeamList(groupsTreeList, projectIds, monomerId, areaId, processId, taskTypeEnum, serialNumber, productName, taskId);
      if (CollectionUtils.isNotEmpty(doList)) {
         doList.sort(SerialNumberComparatorUtils.create(APPTaskProcessInspectionDO::getSerialNumber));
      }

      return doList;
   }

   @Override
   public List<APPTaskProcessInspectionDO> selectInspectionListByTeamList2(
      List<MesBuildingProductionLineTreeDO> linesTreeList,
      List<Long> projectIds,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long processId,
      Integer taskTypeEnum,
      String serialNumber,
      String productName,
      Long taskId
   ) {
      return this.baseMapper
         .selectInspectionListByTeamList2(linesTreeList, projectIds, monomerId, areaId, areaBatchId, processId, taskTypeEnum, serialNumber, productName, taskId);
   }

   @Override
   public List<APPTaskProcessInspectionDO> selectInspectionListByTeamListAndProjectIdList(
      List<Long> processIdList,
      List<Long> groupsIdList,
      List<Long> projectIds,
      Long monomerId,
      Long areaId,
      Long processId,
      Integer productType,
      String serialNumber,
      String productName,
      Long taskId
   ) {
      return this.baseMapper
         .inspectionListByTeamListAndProjectIdList(
            processIdList, groupsIdList, projectIds, monomerId, areaId, processId, productType, serialNumber, productName, taskId
         );
   }

   @Override
   public Integer listProductTaskCount(
      List<Long> teamList, List<Long> projectIds, Long projectId, Long monomerId, Long areaId, Long processId, Integer productType
   ) {
      return this.baseMapper.listProductTaskCount(teamList, projectIds, projectId, monomerId, areaId, processId, productType);
   }

   @Override
   public Integer selectListByAssistListCount(
      List<MesBuildingAssist> assistList, Long projectId, Long monomerId, Long areaId, Long processId, Integer productType
   ) {
      return this.baseMapper.selectListByAssistListCount(assistList, projectId, monomerId, areaId, processId, productType);
   }

   @Override
   public Integer listProductTaskInspectionCount(
      List<Long> teamList, List<Long> projectIds, Long projectId, Long monomerId, Long areaId, Long processId, Integer productType
   ) {
      return this.baseMapper.listProductTaskInspectionCount(teamList, projectIds, projectId, monomerId, areaId, processId, productType);
   }

   @Override
   public List<MesBuildingTaskProcessSummaryDTO> getProcessAndQuantity(Long prodcutId, Integer productType) {
      return this.baseMapper
         .getProcessAndQuantity(prodcutId, productType)
         .stream()
         .map(e -> BeanUtil.copy(e, MesBuildingTaskProcessSummaryDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<ProductProjectSumDO> listGroupByProjectId(String year, String month, Long productionLineId, Long processId, Integer productType) {
      return this.baseMapper.listGroupByProjectId(year, month, productionLineId, processId, productType);
   }

   @Override
   public List<TaskMeteDO> listGroupByMonth(String year, String month, Long projectId, Long productionLineId, Long processId, Integer productType) {
      return this.baseMapper.listGroupByMonth(year, month, projectId, productionLineId, processId, productType);
   }

   @Override
   public List<TaskArtifactProcessDO> listArtifactProcessByCondition(
      String month, String date, Long projectId, Long productionLineId, Long processId, String name, String serialNumber
   ) {
      return this.baseMapper.listArtifactProcessByCondition(month, date, projectId, productionLineId, processId, name, serialNumber);
   }

   @Override
   public List<TaskEnclosureProcessDO> listEnclosureProcessByCondition(
      String month, String date, Long projectId, Long productionLineId, Long processId, String name, String serialNumber
   ) {
      return this.baseMapper.listEnclosureProcessByCondition(month, date, projectId, productionLineId, processId, name, serialNumber);
   }

   @Override
   public Boolean getProjectCompleteStatus(Long projectId) {
      return this.baseMapper.getProjectCompleteStatus(projectId);
   }

   @Override
   public List<AppTaskProcessDO> listProductTaskByTaskOrderId(
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
   ) {
      List<AppTaskProcessDO> doList = this.baseMapper
         .listProductTaskByTaskOrderId(
            null, processIdList, groupsId, taskTypeEnum, monomerId, areaId, serialNumber, taskOrderId, taskId, boolLastProcessEnum, classId
         );
      if (CollectionUtils.isNotEmpty(doList)) {
         doList.sort(SerialNumberComparatorUtils.create(AppTaskProcessDO::getSerialNumber));
      }

      return doList;
   }

   @Override
   public List<AppTaskProcessDO> listProductTaskByTaskOrderId2(
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
   ) {
      List<AppTaskProcessDO> doList = this.baseMapper
         .listProductTaskByTaskOrderId2(
            teamIds,
            lineId,
            taskTypeEnum,
            projectId,
            monomerId,
            areaId,
            areaBatchId,
            processId,
            specification,
            serialNumber,
            taskOrderId,
            taskId,
            boolLastProcessEnum,
            classId
         );
      if (CollectionUtils.isNotEmpty(doList)) {
         doList.sort(SerialNumberComparatorUtils.create(AppTaskProcessDO::getSerialNumber));
      }

      return doList;
   }

   @Override
   public List<AppTaskProcessDO> listProductAssistTask(List<Long> ids, Integer taskTypeEnum) {
      return this.baseMapper.listProductAssistTask(ids, taskTypeEnum);
   }

   @Override
   public List<AppTaskOrderSummaryDO> drillTaskOrderList(
      Long projectId, List<Long> projectIds, Long monomerId, Long areaId, String orderNumber, List<Long> groupsIds
   ) {
      return this.baseMapper.drillTaskOrderList(projectId, projectIds, monomerId, areaId, orderNumber, groupsIds);
   }

   @Override
   public List<AppTaskOrderProjectTreeDO> drillTaskOrderProjectTreeList(
      Long projectId, List<Long> projectIds, Long monomerId, Long areaId, String orderNumber, List<Long> groupsIds
   ) {
      return this.baseMapper.drillTaskOrderProjectTreeList(projectId, projectIds, monomerId, areaId, orderNumber, groupsIds);
   }

   @Override
   public List<AppTaskOrderSummaryDO> drillTaskOrderList2(
      Long projectId, List<Long> projectIds, Long monomerId, Long areaId, String orderNumber, List<Long> lineIds
   ) {
      return this.baseMapper.drillTaskOrderList2(projectId, projectIds, monomerId, areaId, orderNumber, lineIds);
   }

   @Override
   public List<AppTaskProcessDO> listDrillTaskByTaskOrderId(Long nestCutPlateId) {
      return this.baseMapper.listDrillTaskByTaskOrderId(nestCutPlateId);
   }

   @Override
   public List<MesBuildingProcessDO> getProcessList(Integer taskType, Long orderId) {
      return this.baseMapper.getProcessList(taskType, orderId);
   }

   @Override
   public List<MesBuildingProductionTaskDO> getArtifactTaskProcessList(
      Long projectId,
      Long processId,
      Long orderId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String serialNumber,
      String specification,
      Boolean boolAccurateQuery
   ) {
      return this.baseMapper.getArtifactTaskProcessList(projectId, processId, orderId, startDate, endDate, serialNumber, specification, boolAccurateQuery);
   }

   @Override
   public List<MesBuildingProductionTaskDO> getAssembleTaskProcessList(
      Long projectId,
      Long processId,
      Long orderId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      String serialNumber,
      String specification,
      Boolean boolAccurateQuery
   ) {
      return this.baseMapper.getAssembleTaskProcessList(projectId, processId, orderId, startDate, endDate, serialNumber, specification, boolAccurateQuery);
   }

   @Override
   public List<TaskTrackingProcessDO> taskTrackProcess(
      Long taskOrderId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      Long productionLineId,
      Integer taskType,
      List<Long> assembleIds,
      List<Long> singleArtifactIds
   ) {
      return this.baseMapper
         .taskTrackProcess(taskOrderId, projectId, monomerId, areaId, workshopId, productionLineId, taskType, assembleIds, singleArtifactIds);
   }

   @Override
   public List<TaskTrackingProcessDO> taskTrack(
      Long taskOrderId, Long projectId, Long monomerId, Long areaId, Long workshopId, Long productionLineId, Integer taskType, List<Long> singleArtifactIds
   ) {
      return this.baseMapper.taskTrack(taskOrderId, projectId, monomerId, areaId, workshopId, productionLineId, taskType, singleArtifactIds);
   }

   @Override
   public List<TaskTrackingProcessDO> taskOrderNumber(Long taskOrderId, Integer taskTypeEnum, Long workshopId, Long productionLineId) {
      return this.baseMapper.taskOrderNumber(taskOrderId, taskTypeEnum, workshopId, productionLineId);
   }

   @Override
   public List<TaskArtifactProductDTO> taskArtifactList(Long taskOrderId, Long projectId, Long monomerId, Long areaId, Long workshopId, Long productionLineId) {
      return this.baseMapper.taskArtifactList(taskOrderId, workshopId, projectId, monomerId, areaId, productionLineId);
   }

   @Override
   public List<TaskProcessProductDO> taskProcessProduct(
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
   ) {
      return this.baseMapper.taskProcessProduct(processId, taskType, orderId, prodLineId, name, projectIds, monomerId, areaId, serialNumber, assembleIds);
   }

   @Override
   public List<TaskProcessDullDTO> taskDullProcess(Long workShopId) {
      return this.baseMapper.taskDullProcess(workShopId);
   }

   @Override
   public List<TaskProcessDullDTO> taskDullProcessByAssemble(Long workShopId) {
      return this.baseMapper.taskDullProcessByAssemble(workShopId);
   }

   @Override
   public List<TaskProcessProductDTO> taskDullProcessDetail(
      Integer taskType, Long processId, Long productionLineId, List<Long> projectIds, Long monomerId, Long areaId, String serialNumber, Long groupId
   ) {
      return this.baseMapper.taskDullProcessDetail(taskType, processId, productionLineId, projectIds, monomerId, areaId, serialNumber, groupId);
   }

   @Override
   public ProductMeteDTO getProductSummary(Long projectId, Long monomerId, Long areaId, Integer taskType) {
      return this.baseMapper.getProductSummary(projectId, monomerId, areaId, taskType);
   }

   @Override
   public ProductMeteDTO getAssembleSummary(Long projectId, Long monomerId, Long areaId) {
      return this.baseMapper.getAssembleSummary(projectId, monomerId, areaId);
   }

   @Override
   public List<TaskTrackingProcessDTO> processSummaryProduct(
      Long projectId,
      Long monomerId,
      Long areaId,
      LocalDateTime dateTime,
      Long productionLineId,
      Integer taskType,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long workshopId
   ) {
      return this.baseMapper.processSummaryProduct(projectId, monomerId, areaId, dateTime, productionLineId, taskType, startDate, endDate, workshopId);
   }

   @Override
   public List<MesBuildingAssistProcessDO> getAssistProcessListByTaskOrderIdList(List<Long> taskOrderIds) {
      return this.baseMapper.getAssistProcessListByTaskOrderIdList(taskOrderIds);
   }

   @Override
   public List<MesBuildingAssistProductDO> getProductAssistList(
      Long taskOrderId, Long areaId, Long processId, Integer taskTypeEnum, String serialNumber, String specification
   ) {
      return this.baseMapper.getProductAssistList(taskOrderId, areaId, processId, taskTypeEnum, serialNumber, specification);
   }

   @Override
   public ProcessSumDTO taskProcessDriling(Long processId) {
      return this.baseMapper.taskProcessDriling(processId);
   }

   @Override
   public List<TaskInventoryProcessDTO> getInventoryProcessSummary(Long projectId, Long monomerId, Long areaId, Integer taskType) {
      return this.baseMapper.getInventoryProcessSummary(projectId, monomerId, areaId, taskType);
   }

   @Override
   public List<AppTaskProcessDTO> listCutTaskByTaskOrderId(Long cutId, Long projectId, Long monomerId, Long areaId, String serialNumber) {
      return this.baseMapper.listCutTaskByTaskOrderId(cutId, projectId, monomerId, areaId, serialNumber);
   }

   @Override
   public List<ProductProcessQuantityDTO> listProductProcessByProductIdAndType(Long productId, Integer taskTypeEnum) {
      return this.baseMapper.listProductProcessByProductIdAndType(productId, taskTypeEnum);
   }

   @Override
   public List<ProductMonitorKanbanByGroupDTO> getMonitorKanbanByGroup(Long workshopId, Long processId, Integer taskTypeEnum) {
      return this.baseMapper.getMonitorKanbanByGroup(workshopId, processId, taskTypeEnum);
   }

   @Override
   public List<ProductMonitorKanbanByGroupDO> getProductByLastMonth(Long workshopId, Long processId, Integer taskTypeEnum) {
      return this.baseMapper.getProductByLastMonth(workshopId, processId, taskTypeEnum);
   }

   @Override
   public List<ProductMonitorKanbanByGroupDO> getProductByYear(Long workshopId, Long processId, Integer taskTypeEnum) {
      return this.baseMapper.getProductByYear(workshopId, processId, taskTypeEnum);
   }

   @Override
   public List<ProductMonitorKanbanByGroupDO> getProductByUnComplete(Long workshopId, Long processId, Integer taskTypeEnum) {
      return this.baseMapper.getProductByUnComplete(workshopId, processId, taskTypeEnum);
   }

   @Override
   public List<ProductMonitorByGroupDetailDTO> getProductMonitorKanbanByGroupDetail(
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
   ) {
      return this.baseMapper
         .getProductMonitorKanbanByGroupDetail(
            workshopId, productionLineId, groupId, teamId, processId, taskTypeEnum, projectId, monomerId, areaId, serialNumber
         );
   }

   @Override
   public List<ProductProcessDTO> productByConditionList(
      Long areaId,
      Long areaBatchId,
      Long factoryId,
      Long classificationId,
      Long productionLineId,
      String serialNumber,
      String specification,
      String material,
      Integer taskTypeEnum
   ) {
      return this.baseMapper
         .productByConditionList(areaId, areaBatchId, factoryId, classificationId, productionLineId, serialNumber, specification, material, taskTypeEnum);
   }

   @Override
   public BigDecimal getMeteSummaryByCondition(LocalDateTime dateTime, Integer timeTypeEnum, Integer taskTypeEnum) {
      return this.baseMapper.getMeteSummaryByCondition(dateTime, timeTypeEnum, taskTypeEnum);
   }

   @Override
   public List<ResponseVO> manufacturingDeptProductionProcesses() {
      return this.baseMapper.manufacturingDeptProductionProcesses();
   }

   @Override
   public List<ProductClassificationDTO> productTypeByTaskOrderId(
      List<Long> processIdList, Long groupsId, Integer taskTypeEnum, Long taskOrderId, Integer boolLastProcessEnum
   ) {
      return this.baseMapper.productTypeByTaskOrderId(processIdList, groupsId, taskTypeEnum, taskOrderId, boolLastProcessEnum);
   }

   @Override
   public List<ProductClassificationDTO> productTypeByTaskOrderId2(
      List<Long> processIdList, List<Long> lineIds, Integer taskTypeEnum, Long taskOrderId, Integer boolLastProcessEnum
   ) {
      return this.baseMapper.productTypeByTaskOrderId2(processIdList, lineIds, taskTypeEnum, taskOrderId, boolLastProcessEnum);
   }

   @Override
   public List<TaskProcessProductDO> taskProduct(
      Integer taskType,
      Long orderId,
      Long groupId,
      String name,
      List<Long> projectIds,
      Long monomerId,
      Long areaId,
      String serialNumber,
      List<Long> singleArtifactIds
   ) {
      return this.baseMapper.taskProduct(taskType, orderId, groupId, name, projectIds, monomerId, areaId, serialNumber, singleArtifactIds);
   }

   @Override
   public TaskTrackingProcessDTO processSummarySingleArtifact(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long productionLineId,
      Integer productType,
      LocalDateTime startDate,
      LocalDateTime endDate,
      List<Long> singleArtifactIds
   ) {
      return this.baseMapper.processSummarySingleArtifact(projectId, monomerId, areaId, productionLineId, productType, startDate, endDate, singleArtifactIds);
   }

   @Override
   public List<MesBuildingArtifactTypeDO> getProductTypeList(Long areaId, Long areaBatchId, Long factoryId, Integer taskTypeEnum) {
      return this.baseMapper.getProductTypeList(areaId, areaBatchId, factoryId, taskTypeEnum);
   }

   @Override
   public List<ProduceStatisticsProcessDTO> taskProcessList(Long projectId, List<Long> assembleIds, List<Long> machineIds) {
      return this.baseMapper.taskProcessList(projectId, assembleIds, machineIds);
   }

   @Override
   public List<ProduceStatisticsProcessDTO> projectProcessList(Long projectId, Long workshopId) {
      return this.baseMapper.projectProcessList(projectId, workshopId);
   }

   @Override
   public List<ProduceStatisticsProcessDTO> listProjectProcessList(List<Long> projectIds, Long workshopId) {
      return this.baseMapper.listProjectProcessList(projectIds, workshopId);
   }

   @Override
   public List<MesBuildingAssistProductDTO> productProcessList(
      Long taskOrderId,
      Long areaId,
      Long processId,
      Integer taskTypeEnum,
      String serialNumber,
      String specification,
      List<Long> taskProcessIdList,
      Integer assistEnum
   ) {
      return this.baseMapper.productProcessList(taskOrderId, areaId, processId, taskTypeEnum, serialNumber, specification, taskProcessIdList, assistEnum);
   }

   @Override
   public List<ProcessAndLastProcesLinkDTO> listLastProcess(List<Long> allProcessIds) {
      return this.baseMapper.listLastProcess(allProcessIds);
   }

   @Override
   public ProcessReportSummaryDTO getProcessReportSummary(Long processId, SecurityUser user) {
      ProcessReportSummaryDTO summaryDTO = new ProcessReportSummaryDTO();
      MesBuildingProcess process = this.processService.getOne(Wrappers.lambdaQuery(MesBuildingProcess.class).eq(MesBuildingProcess::getId, processId));
      List<MesBuildingTaskProcess> taskProcesses = this.baseMapper.findTaskQuantityByProcessId(processId, user.getId());
      taskProcesses = taskProcesses.stream().filter(s -> s.getNeedQuantity() != 0).collect(Collectors.toList());
      Set<Long> projectSet = taskProcesses.stream().map(MesBuildingTaskProcess::getProjectId).collect(Collectors.toSet());
      List<MesBuildingAssistOrderDTO> assistList = this.assistService.findAssistByUserIds(processId, user.getId());
      int assistSum = 0;
      int produceQuantity = 0;
      if (CollectionUtil.isNotEmpty(assistList)) {
         projectSet.addAll(assistList.stream().map(MesBuildingAssistOrderDTO::getProjectId).collect(Collectors.toSet()));
         assistSum = assistList.stream().mapToInt(MesBuildingAssistOrderDTO::getQuantity).sum();
         produceQuantity = assistList.stream().mapToInt(s -> s.getQuantity() - s.getProduceQuantity()).sum();
      }

      int taskCount = taskProcesses.stream().mapToInt(MesBuildingTaskProcess::getNeedQuantity).sum() + assistSum;
      int inCompleteCount = taskProcesses.stream().mapToInt(s -> s.getNeedQuantity() - s.getInspectionQuantity()).sum() + produceQuantity;
      LocalDateTime now = LocalDateTime.now();
      LocalDateTime startTime = now.withHour(0).withMinute(0).withSecond(0).withNano(0);
      List<MesBuildingProduceTeamReport> teamReports = this.teamReportService
         .list(
            Wrappers.lambdaQuery(MesBuildingProduceTeamReport.class)
               .eq(MesBuildingProduceTeamReport::getUserId, user.getId())
               .eq(MesBuildingProduceTeamReport::getProcessId, processId)
               .eq(MesBuildingProduceTeamReport::getTaskTypeEnum, process.getProductType())
               .ge(BaseEntity::getCreateTime, startTime)
               .lt(BaseEntity::getCreateTime, now)
         );
      int completeCount = teamReports.stream().mapToInt(MesBuildingProduceTeamReport::getQuantity).sum();
      summaryDTO.setProjectCount(projectSet.size());
      summaryDTO.setTaskCount(taskCount);
      summaryDTO.setCompleteCount(completeCount);
      summaryDTO.setIncompleteCount(inCompleteCount);
      return summaryDTO;
   }

   @Override
   public ProcessReportSummaryDTO getProcessReportSummaryAV2(Long processId, SecurityUser user) {
      ProcessReportSummaryDTO summaryDTO = new ProcessReportSummaryDTO();
      MesBuildingProcess process = this.processService.getOne(Wrappers.lambdaQuery(MesBuildingProcess.class).eq(MesBuildingProcess::getId, processId));
      List<MesBuildingTaskProcess> taskProcesses = this.baseMapper.findTaskQuantityByProcessIdAV2(processId, user.getId(), process.getProductType());
      this.setTaskProcessNeedQuantity(taskProcesses, process);
      taskProcesses = taskProcesses.stream().filter(s -> s.getNeedQuantity() != 0).collect(Collectors.toList());
      Set<Long> projectSet = taskProcesses.stream().map(MesBuildingTaskProcess::getProjectId).collect(Collectors.toSet());
      List<MesBuildingAssistOrderDTO> assistList = this.assistService.findAssistByUserIds(processId, user.getId());
      int assistSum = 0;
      int produceQuantity = 0;
      this.setAssistQuantity(assistList, process);
      if (CollectionUtil.isNotEmpty(assistList)) {
         projectSet.addAll(assistList.stream().map(MesBuildingAssistOrderDTO::getProjectId).collect(Collectors.toSet()));
         assistSum = assistList.stream().mapToInt(MesBuildingAssistOrderDTO::getQuantity).sum();
         produceQuantity = assistList.stream().mapToInt(s -> s.getQuantity() - s.getProduceQuantity()).sum();
      }

      int taskCount = taskProcesses.stream().mapToInt(MesBuildingTaskProcess::getNeedQuantity).sum() + assistSum;
      int inCompleteCount = taskProcesses.stream().mapToInt(s -> s.getNeedQuantity() - s.getInspectionQuantity()).sum() + produceQuantity;
      LocalDateTime now = LocalDateTime.now();
      LocalDateTime startTime = now.withHour(0).withMinute(0).withSecond(0).withNano(0);
      List<MesBuildingProduceTeamReport> teamReports = this.teamReportService
         .list(
            Wrappers.lambdaQuery(MesBuildingProduceTeamReport.class)
               .eq(MesBuildingProduceTeamReport::getUserId, user.getId())
               .eq(MesBuildingProduceTeamReport::getProcessId, processId)
               .eq(MesBuildingProduceTeamReport::getTaskTypeEnum, process.getProductType())
               .ge(BaseEntity::getCreateTime, startTime)
               .lt(BaseEntity::getCreateTime, now)
         );
      int completeCount = teamReports.stream().mapToInt(MesBuildingProduceTeamReport::getQuantity).sum();
      summaryDTO.setProjectCount(projectSet.size());
      summaryDTO.setTaskCount(taskCount);
      summaryDTO.setCompleteCount(completeCount);
      summaryDTO.setIncompleteCount(inCompleteCount);
      return summaryDTO;
   }

   private void setAssistQuantity(List<MesBuildingAssistOrderDTO> assistList, MesBuildingProcess process) {
      if (CollectionUtil.isNotEmpty(assistList)) {
         List<MesBuildingAssistNumberDetail> assistNumberDetails = this.assistNumberDetailService
            .list(
               (Wrapper<MesBuildingAssistNumberDetail>)(new LambdaQueryWrapper<MesBuildingAssistNumberDetail>()
                     .in(MesBuildingAssistNumberDetail::getAssistId, assistList.stream().map(MesBuildingAssistOrderDTO::getId).collect(Collectors.toList())))
                  .eq(MesBuildingAssistNumberDetail::getBoolFinishEnum, Boolean.FALSE)
            );
         if (CollectionUtil.isNotEmpty(assistNumberDetails)) {
            Map<Long, List<Integer>> assistNumberDetailMap = assistNumberDetails.stream()
               .collect(
                  Collectors.groupingBy(
                     MesBuildingAssistNumberDetail::getTaskProcessId, Collectors.mapping(MesBuildingAssistNumberDetail::getNumber, Collectors.toList())
                  )
               );
            LambdaQueryWrapper<MesBuildingTaskNumberLink> taskNumberQueryWrapper = Wrappers.<MesBuildingTaskNumberLink>lambdaQuery();
            if (process.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
               for (Entry<Long, List<Integer>> entry : assistNumberDetailMap.entrySet()) {
                  if (taskNumberQueryWrapper.isEmptyOfNormal()) {
                     taskNumberQueryWrapper.eq(MesBuildingTaskNumberLink::getArtifactTaskProcessId, entry.getKey());
                     taskNumberQueryWrapper.in(MesBuildingTaskNumberLink::getArtifactNumber, entry.getValue());
                  } else {
                     taskNumberQueryWrapper.or(
                        subQuery -> {
                           LambdaQueryWrapper var10000 = subQuery.eq(MesBuildingTaskNumberLink::getArtifactTaskProcessId, entry.getKey())
                              .in(MesBuildingTaskNumberLink::getArtifactNumber, entry.getValue());
                        }
                     );
                  }
               }
            }

            if (process.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
               for (Entry<Long, List<Integer>> entry : assistNumberDetailMap.entrySet()) {
                  if (taskNumberQueryWrapper.isEmptyOfNormal()) {
                     taskNumberQueryWrapper.eq(MesBuildingTaskNumberLink::getAssembleTaskProcessId, entry.getKey());
                     taskNumberQueryWrapper.in(MesBuildingTaskNumberLink::getAssembleNumber, entry.getValue());
                  } else {
                     taskNumberQueryWrapper.or(
                        subQuery -> {
                           LambdaQueryWrapper var10000 = subQuery.eq(MesBuildingTaskNumberLink::getAssembleTaskProcessId, entry.getKey())
                              .in(MesBuildingTaskNumberLink::getAssembleNumber, entry.getValue());
                        }
                     );
                  }
               }
            }

            List<MesBuildingTaskNumberLink> taskNumberLinks = this.taskNumberLinkService.list(taskNumberQueryWrapper);
            if (CollectionUtil.isNotEmpty(taskNumberLinks)) {
               Map<Long, List<MesBuildingTaskNumberLink>> taskNumberLinkMap = new HashMap<>();
               if (process.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                  taskNumberLinkMap = taskNumberLinks.stream().collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactTaskProcessId));
               }

               if (process.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
                  taskNumberLinkMap = taskNumberLinks.stream().collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactTaskProcessId));
               }

               for (MesBuildingAssistOrderDTO assistOrderDTO : assistList) {
                  List<MesBuildingTaskNumberLink> numberLinks = taskNumberLinkMap.get(assistOrderDTO.getTaskProcessId());
                  if (CollectionUtil.isNotEmpty(numberLinks)) {
                     int size = 0;
                     if (process.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                        size = numberLinks.stream().map(MesBuildingTaskNumberLink::getArtifactNumber).distinct().collect(Collectors.toList()).size();
                     }

                     if (process.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
                        size = numberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleNumber).distinct().collect(Collectors.toList()).size();
                     }

                     assistOrderDTO.setQuantity(size);
                     taskNumberLinkMap.remove(assistOrderDTO.getTaskProcessId());
                  } else {
                     assistOrderDTO.setQuantity(assistOrderDTO.getProduceQuantity());
                  }
               }
            }

            if (CollectionUtil.isEmpty(taskNumberLinks)) {
               assistList.forEach(e -> e.setQuantity(e.getProduceQuantity()));
            }
         }
      }
   }

   private void setTaskProcessNeedQuantity(List<MesBuildingTaskProcess> taskProcesses, MesBuildingProcess process) {
      if (CollectionUtil.isNotEmpty(taskProcesses)) {
         List<MesBuildingAssistNumberDetail> assistNumberDetails = this.assistNumberDetailService
            .list(
               (Wrapper<MesBuildingAssistNumberDetail>)(new LambdaQueryWrapper<MesBuildingAssistNumberDetail>()
                     .in(
                        MesBuildingAssistNumberDetail::getTaskProcessId, taskProcesses.stream().map(MesBuildingTaskProcess::getId).collect(Collectors.toList())
                     ))
                  .eq(MesBuildingAssistNumberDetail::getBoolFinishEnum, Boolean.FALSE)
            );
         if (CollectionUtil.isNotEmpty(assistNumberDetails)) {
            Map<Long, List<Integer>> assistNumberDetailMap = assistNumberDetails.stream()
               .collect(
                  Collectors.groupingBy(
                     MesBuildingAssistNumberDetail::getTaskProcessId, Collectors.mapping(MesBuildingAssistNumberDetail::getNumber, Collectors.toList())
                  )
               );
            LambdaQueryWrapper<MesBuildingTaskNumberLink> taskNumberQueryWrapper = Wrappers.<MesBuildingTaskNumberLink>lambdaQuery();
            if (process.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
               for (Entry<Long, List<Integer>> entry : assistNumberDetailMap.entrySet()) {
                  if (taskNumberQueryWrapper.isEmptyOfNormal()) {
                     taskNumberQueryWrapper.eq(MesBuildingTaskNumberLink::getArtifactTaskProcessId, entry.getKey());
                     taskNumberQueryWrapper.in(MesBuildingTaskNumberLink::getArtifactNumber, entry.getValue());
                  } else {
                     taskNumberQueryWrapper.or(
                        subQuery -> {
                           LambdaQueryWrapper var10000 = subQuery.eq(MesBuildingTaskNumberLink::getArtifactTaskProcessId, entry.getKey())
                              .in(MesBuildingTaskNumberLink::getArtifactNumber, entry.getValue());
                        }
                     );
                  }
               }
            }

            if (process.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
               for (Entry<Long, List<Integer>> entry : assistNumberDetailMap.entrySet()) {
                  if (taskNumberQueryWrapper.isEmptyOfNormal()) {
                     taskNumberQueryWrapper.eq(MesBuildingTaskNumberLink::getAssembleTaskProcessId, entry.getKey());
                     taskNumberQueryWrapper.in(MesBuildingTaskNumberLink::getAssembleNumber, entry.getValue());
                  } else {
                     taskNumberQueryWrapper.or(
                        subQuery -> {
                           LambdaQueryWrapper var10000 = subQuery.eq(MesBuildingTaskNumberLink::getAssembleTaskProcessId, entry.getKey())
                              .in(MesBuildingTaskNumberLink::getAssembleNumber, entry.getValue());
                        }
                     );
                  }
               }
            }

            List<MesBuildingTaskNumberLink> taskNumberLinks = this.taskNumberLinkService.list(taskNumberQueryWrapper);
            if (CollectionUtil.isNotEmpty(taskNumberLinks)) {
               Map<Long, List<MesBuildingTaskNumberLink>> taskNumberLinkMap = new HashMap<>();
               if (process.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                  taskNumberLinkMap = taskNumberLinks.stream().collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactTaskProcessId));
               }

               if (process.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
                  taskNumberLinkMap = taskNumberLinks.stream().collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactTaskProcessId));
               }

               for (MesBuildingTaskProcess taskProcess : taskProcesses) {
                  int size = 0;
                  List<MesBuildingTaskNumberLink> numberLinks = taskNumberLinkMap.get(taskProcess.getId());
                  if (CollectionUtil.isNotEmpty(numberLinks)) {
                     if (process.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                        size = numberLinks.stream().map(MesBuildingTaskNumberLink::getArtifactNumber).distinct().collect(Collectors.toList()).size();
                     }

                     if (process.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
                        size = numberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleNumber).distinct().collect(Collectors.toList()).size();
                     }

                     taskProcess.setNeedQuantity(taskProcess.getNeedQuantity() - size);
                  }
               }
            }
         }
      }
   }

   @Override
   public List<ProcessReportListDTO> findProcessReportProjectList(Long processId, String projectName, SecurityUser user) {
      List<ProcessReportListDTO> processProjectList = this.baseMapper.findProcessReportProjectList(processId, projectName, user.getId());
      List<MesBuildingAssistProjectDTO> assistProjectDTOS = this.assistService.findProcessReportProjectList(processId, projectName, user.getId());
      List<ProcessReportListDTO> dtos = processProjectList;
      if (CollectionUtil.isNotEmpty(assistProjectDTOS)) {
         List<ProcessReportListDTO> dtoList = assistProjectDTOS.stream().map(s -> {
            ProcessReportListDTO listDTO = new ProcessReportListDTO();
            listDTO.setId(s.getProject().getId());
            listDTO.setSerialNumber(s.getProject().getSerialNumber());
            listDTO.setName(s.getProject().getName());
            listDTO.setShortName(s.getProject().getShortName());
            listDTO.setTaskQuantity(s.getQuantity());
            listDTO.setCompleteQuantity(s.getProduceQuantity());
            listDTO.setInCompleteQuantity(s.getQuantity() - s.getProduceQuantity());
            return listDTO;
         }).collect(Collectors.toList());
         List<ProcessReportListDTO> finalDtos = dtos;
         Map<Long, ProcessReportListDTO> intersectMap = dtoList.stream()
            .filter(s -> finalDtos.stream().anyMatch(e -> e.getId().equals(s.getId())))
            .collect(Collectors.toMap(ProcessReportListDTO::getId, Function.identity()));
         dtoList.removeAll(intersectMap.values());
         if (!intersectMap.isEmpty()) {
            finalDtos.stream().map(s -> {
               ProcessReportListDTO dto = intersectMap.get(s.getId());
               if (dto != null) {
                  s.setTaskQuantity(s.getTaskQuantity() + dto.getTaskQuantity());
                  s.setCompleteQuantity(s.getCompleteQuantity() + dto.getCompleteQuantity());
                  s.setInCompleteQuantity(s.getInCompleteQuantity() + dto.getInCompleteQuantity());
               }

               return (ProcessReportListDTO)s;
            }).collect(Collectors.toList());
         }

         dtos.addAll(dtoList);
      }

      return dtos.stream().filter(s -> s.getTaskQuantity().compareTo(s.getCompleteQuantity()) != 0).collect(Collectors.toList());
   }

   @Override
   public List<ProcessReportListDTO> findProcessReportProjectListAV2(Long processId, String projectName, SecurityUser user) {
      MesBuildingProcess process = this.processService.getById(processId);
      Preconditions.checkArgument(process != null, "工序不存在!");
      List<ProcessReportListDTO> processProjectList = this.baseMapper
         .findProcessReportProjectListAV2(processId, projectName, user.getId(), process.getProductType());
      this.setProjectTaskQuantity(processProjectList, process);
      List<MesBuildingAssistProjectDTO> assistProjectDTOS = this.assistService
         .findProcessReportProjectListAV2(processId, projectName, user.getId(), process.getProductType());
      List<ProcessReportListDTO> dtos = processProjectList;
      if (CollectionUtil.isNotEmpty(assistProjectDTOS)) {
         List<ProcessReportListDTO> dtoList = assistProjectDTOS.stream().map(s -> {
            ProcessReportListDTO listDTO = new ProcessReportListDTO();
            listDTO.setId(s.getProject().getId());
            listDTO.setSerialNumber(s.getProject().getSerialNumber());
            listDTO.setName(s.getProject().getName());
            listDTO.setShortName(s.getProject().getShortName());
            listDTO.setTaskQuantity(s.getQuantity());
            listDTO.setCompleteQuantity(s.getProduceQuantity());
            listDTO.setInCompleteQuantity(s.getQuantity() - s.getProduceQuantity());
            return listDTO;
         }).collect(Collectors.toList());
         List<ProcessReportListDTO> finalDtos = dtos;
         Map<Long, ProcessReportListDTO> intersectMap = dtoList.stream()
            .filter(s -> finalDtos.stream().anyMatch(e -> e.getId().equals(s.getId())))
            .collect(Collectors.toMap(ProcessReportListDTO::getId, Function.identity()));
         dtoList.removeAll(intersectMap.values());
         if (!intersectMap.isEmpty()) {
            finalDtos.stream().map(s -> {
               ProcessReportListDTO dto = intersectMap.get(s.getId());
               if (dto != null) {
                  s.setTaskQuantity(s.getTaskQuantity() + dto.getTaskQuantity());
                  s.setCompleteQuantity(s.getCompleteQuantity() + dto.getCompleteQuantity());
                  s.setInCompleteQuantity(s.getInCompleteQuantity() + dto.getInCompleteQuantity());
               }

               return (ProcessReportListDTO)s;
            }).collect(Collectors.toList());
         }

         dtos.addAll(dtoList);
      }

      return dtos.stream().filter(s -> s.getTaskQuantity().compareTo(s.getCompleteQuantity()) != 0).collect(Collectors.toList());
   }

   private void setProjectTaskQuantity(List<ProcessReportListDTO> processProjectList, MesBuildingProcess process) {
      if (CollectionUtil.isNotEmpty(processProjectList)) {
         Map<Long, ProcessReportListDTO> reportListDTOMap = processProjectList.stream()
            .collect(Collectors.toMap(ProcessReportListDTO::getId, Function.identity()));
         List<Long> projectIds = processProjectList.stream().map(ProcessReportListDTO::getId).collect(Collectors.toList());
         List<Integer> taskProcessIdList = processProjectList.stream()
            .map(ProcessReportListDTO::getTaskProcessIds)
            .flatMap(ids -> Arrays.stream(ids.split(",")))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
         List<MesBuildingAssistNumberDetail> assistNumberDetails = this.assistNumberDetailService
            .list(
               (Wrapper<MesBuildingAssistNumberDetail>)((((new LambdaQueryWrapper<MesBuildingAssistNumberDetail>()
                              .in(MesBuildingAssistNumberDetail::getProjectId, projectIds))
                           .in(MesBuildingAssistNumberDetail::getTaskProcessId, taskProcessIdList))
                        .eq(MesBuildingAssistNumberDetail::getProductType, process.getProductType()))
                     .eq(MesBuildingAssistNumberDetail::getProcessId, process.getId()))
                  .eq(MesBuildingAssistNumberDetail::getBoolFinishEnum, Boolean.FALSE)
            );
         if (CollectionUtil.isNotEmpty(assistNumberDetails)) {
            Map<Long, List<MesBuildingAssistNumberDetail>> assistNumberDetailProjectMap = assistNumberDetails.stream()
               .collect(Collectors.groupingBy(MesBuildingAssistNumberDetail::getProjectId));
            Map<Long, List<Integer>> assistNumberDetailMap = assistNumberDetails.stream()
               .collect(
                  Collectors.groupingBy(
                     MesBuildingAssistNumberDetail::getTaskProcessId, Collectors.mapping(MesBuildingAssistNumberDetail::getNumber, Collectors.toList())
                  )
               );
            LambdaQueryWrapper<MesBuildingTaskNumberLink> taskNumberQueryWrapper = Wrappers.<MesBuildingTaskNumberLink>lambdaQuery();
            if (process.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
               for (Entry<Long, List<Integer>> entry : assistNumberDetailMap.entrySet()) {
                  if (taskNumberQueryWrapper.isEmptyOfNormal()) {
                     taskNumberQueryWrapper.eq(MesBuildingTaskNumberLink::getArtifactTaskProcessId, entry.getKey());
                     taskNumberQueryWrapper.in(MesBuildingTaskNumberLink::getArtifactNumber, entry.getValue());
                  } else {
                     taskNumberQueryWrapper.or(
                        subQuery -> {
                           LambdaQueryWrapper var10000 = subQuery.eq(MesBuildingTaskNumberLink::getArtifactTaskProcessId, entry.getKey())
                              .in(MesBuildingTaskNumberLink::getArtifactNumber, entry.getValue());
                        }
                     );
                  }
               }
            }

            if (process.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
               for (Entry<Long, List<Integer>> entry : assistNumberDetailMap.entrySet()) {
                  if (taskNumberQueryWrapper.isEmptyOfNormal()) {
                     taskNumberQueryWrapper.eq(MesBuildingTaskNumberLink::getAssembleTaskProcessId, entry.getKey());
                     taskNumberQueryWrapper.in(MesBuildingTaskNumberLink::getAssembleNumber, entry.getValue());
                  } else {
                     taskNumberQueryWrapper.or(
                        subQuery -> {
                           LambdaQueryWrapper var10000 = subQuery.eq(MesBuildingTaskNumberLink::getAssembleTaskProcessId, entry.getKey())
                              .in(MesBuildingTaskNumberLink::getAssembleNumber, entry.getValue());
                        }
                     );
                  }
               }
            }

            List<MesBuildingTaskNumberLink> taskNumberLinks = this.taskNumberLinkService.list(taskNumberQueryWrapper);
            if (CollectionUtil.isNotEmpty(taskNumberLinks)) {
               Map<Long, List<MesBuildingTaskNumberLink>> taskNumberLinkMap = new HashMap<>();
               if (process.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                  taskNumberLinkMap = taskNumberLinks.stream().collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactTaskProcessId));
               }

               if (process.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
                  taskNumberLinkMap = taskNumberLinks.stream().collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getAssembleTaskProcessId));
               }

               Map<Long, List<MesBuildingTaskNumberLink>> finalTaskNumberLinkMap = taskNumberLinkMap;
               assistNumberDetailProjectMap.forEach(
                  (projectId, assistNumberDetailList) -> {
                     List<Long> taskProcessIds = assistNumberDetailList.stream()
                        .map(MesBuildingAssistNumberDetail::getTaskProcessId)
                        .distinct()
                        .collect(Collectors.toList());
                     int size = 0;
                     if (process.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
                        for (Long taskProcessId : taskProcessIds) {
                           List<MesBuildingTaskNumberLink> numberLinks = finalTaskNumberLinkMap.get(taskProcessId);
                           if (CollectionUtil.isNotEmpty(numberLinks)) {
                              size += numberLinks.stream().map(MesBuildingTaskNumberLink::getArtifactNumber).distinct().collect(Collectors.toList()).size();
                           }
                        }
                     }

                     if (process.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
                        for (Long taskProcessId : taskProcessIds) {
                           List<MesBuildingTaskNumberLink> numberLinks = finalTaskNumberLinkMap.get(taskProcessId);
                           if (CollectionUtil.isNotEmpty(numberLinks)) {
                              size += numberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleNumber).distinct().collect(Collectors.toList()).size();
                           }
                        }
                     }

                     ProcessReportListDTO processReportListDTO = reportListDTOMap.get(projectId);
                     processReportListDTO.setTaskQuantity(processReportListDTO.getTaskQuantity() - size);
                     processReportListDTO.setInCompleteQuantity(processReportListDTO.getInCompleteQuantity() - size);
                  }
               );
            }
         }
      }
   }

   @Override
   public AverageTaskDTO getAverageTaskCompletionRate(int y, Long processId, Long userId) {
      return this.baseMapper.getAverageTaskCompletionRate(y, processId, userId);
   }

   @Override
   public AverageTaskDTO getAverageTaskCompletionOnAssist(int y, Long processId, Long userId) {
      return this.baseMapper.getAverageTaskCompletionOnAssist(y, processId, userId);
   }

   @Override
   public List<OverdueOverInfoDTO> getOverdueOrderInfo(Long processId, Long userId) {
      return this.baseMapper.getOverdueOrderInfo(processId, userId);
   }

   @Override
   public List<AppTaskProcessDO> listProductAssistTaskByTaskOrderId(
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
   ) {
      return this.baseMapper
         .listProductAssistTaskByTaskOrderId(
            processIdList, groupsId, taskTypeEnum, monomerId, areaId, serialNumber, taskOrderId, taskId, boolLastProcessEnum, classId
         );
   }

   @Override
   public List<AppTaskProcessDO> listProductAssistTaskByTaskOrderIdAV2(
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
   ) {
      return this.baseMapper
         .listProductAssistTaskByTaskOrderIdAV2(
            processIdList, assistProdLineId, taskTypeEnum, monomerId, areaId, areaBatchId, serialNumber, taskOrderId, taskId, boolLastProcessEnum, classId
         );
   }

   @Override
   public List<MesBuildingGroupsDTO> findProcessByTaskIds(List<Long> taskIds, Long processId) {
      return this.baseMapper.findProcessByTaskIds(taskIds, processId);
   }

   @Override
   public List<AppTaskProcessDO> listTaskProcessByTaskOrderId(
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
   ) {
      return this.baseMapper
         .listTaskProcessByTaskOrderId(processIds, groupsId, taskTypeEnum, monomerId, areaId, serialNumber, taskOrderId, taskId, boolLastProcessEnum, classId);
   }

   @Override
   public List<MesInspectClassIdTeamIdDTO> findTaskClassIdandTeamIdByInspectInfo(Long workshopId, Long processId, List<Long> teamIds, List<Long> classIds) {
      return this.baseMapper.findTaskClassIdandTeamIdByInspectInfo(workshopId, processId, teamIds, classIds);
   }

   @Override
   public List<ProjectProductProcessDTO> findProductTaskProcessProgress(
      List<Long> artIds, List<Long> areaIds, Long monmerId, Long areaId, Integer taskTypeEnum, Long classId, String serialNumber
   ) {
      return this.baseMapper.findProductTaskProcessProgress(artIds, areaIds, monmerId, areaId, taskTypeEnum, classId, serialNumber);
   }

   @Override
   public List<ProjectProductProcessDTO> findArtifctAssembleLinkProgress(List<Long> artIds) {
      return this.baseMapper.findArtifctAssembleLinkProgress(artIds);
   }

   @Override
   public List<ProductProcessProgressDetailDTO> findAssembleProcessDetails(Long productId, Long processId, Long classId, String serialNumber) {
      return this.baseMapper.findAssembleProcessDetails(productId, processId, classId, serialNumber);
   }

   @Override
   public List<ProductProcessProgressDetailDTO> findArtifactProcessDetails(Long productId, Long processId, Long classId, String serialNumber) {
      return this.baseMapper.findArtifactProcessDetails(productId, processId, classId, serialNumber);
   }

   @Override
   public List<MesBuildingTaskProcess> findProcessByProductPorcess(MesBuildingProductProcessDTOParam dtoParam, List<Long> processIds) {
      return this.baseMapper.findProcessByProductProcess(dtoParam, processIds);
   }

   @Override
   public List<ProjectProductionTaskDetailDTO> getProjectProductionTaskDetail(ProjectProductionTaskDOParam param) {
      return this.baseMapper.getProjectProductionTaskDetail(param);
   }

   @Override
   public List<ProjectProductionTaskDetailDTO> getProjectProductionTaskTeamDetail(ProjectProductionTaskDOParam param) {
      return this.baseMapper.getProjectProductionTaskTeamDetail(param);
   }

   @Override
   public List<ProjectProductionKanBanDetailDTO> getKanBanProcessProductDetail(List<Long> taskIds, Long processId, Integer productType) {
      return this.baseMapper.getKanBanProcessProductDetail(taskIds, processId, productType);
   }

   @Override
   public List<ProjectProductionKanBanDetailDTO> getKanBanProcessInspectionProductDetail(List<Long> taskIds, Long processId, Integer productType) {
      return this.baseMapper.getKanBanProcessInspectionProductDetail(taskIds, processId, productType);
   }

   @Override
   public List<ProjectProductionKanBanDetailDTO> getPartKanBanProcessProductDetail(Long taskId) {
      return this.baseMapper.getPartKanBanProcessProductDetail(taskId);
   }

   @Override
   public List<ProjectProductionKanBanDetailDTO> getPartKanBanProcessProductDetailNew(List<Long> partIds) {
      return this.baseMapper.getPartKanBanProcessProductDetailNew(partIds);
   }

   @Override
   public List<ProjectKanBanProductProductionStateDTO> findPartSignageProductProductionStateList(
      Long projectId,
      Integer productType,
      Long monomerId,
      List<Long> areaIds,
      Long workShopId,
      Long productionLineId,
      Long classId,
      String serialNumber,
      Integer productKanBanCompanyEnum,
      Integer productClassificationEnum,
      Long processId,
      List<Long> areaBatchIds
   ) {
      return this.baseMapper
         .findPartSignageProductProductionStateList(
            projectId,
            productType,
            monomerId,
            areaIds,
            workShopId,
            productionLineId,
            classId,
            serialNumber,
            productKanBanCompanyEnum,
            productClassificationEnum,
            processId,
            areaBatchIds
         );
   }

   @Override
   public List<InspectRealtimeInfoDTO> findToBeInspectedInfo(
      List<InsepctUserConditionDTO> treeCondition, LocalDateTime startDate, LocalDateTime endDate, Long projectId, Long workShopId, String serialNumber
   ) {
      return this.baseMapper.findToBeInspectedInfo(treeCondition, startDate, endDate, projectId, workShopId, serialNumber);
   }

   @Override
   public List<InspectRealtimeInfoDTO> findToBeInspectedInfoV2(
      List<InsepctUserConditionDTO> treeCondition, LocalDateTime startDate, LocalDateTime endDate, Collection<Long> projectIdList, Long workShopId
   ) {
      return this.baseMapper.findToBeInspectedInfoV2(treeCondition, startDate, endDate, projectIdList, workShopId);
   }

   @Override
   public List<DateQuantityDTO> findWorkshopAchievements(Long workShopId, LocalDate date) {
      return this.baseMapper.findWorkshopAchievements(workShopId, date);
   }

   @Override
   public Object getProjectProcessCompletionRate(String year, Long workshopId) {
      List<ScreenProjectProcessCompletionRateVO> values = new ArrayList<>();
      List<ScreenProjectProcessCompletionRateDTO> list = this.baseMapper.getProjectProcessCompletionRate(year, workshopId);
      Map<String, List<ScreenProjectProcessCompletionRateDTO>> projectNameMaps = list.stream()
         .collect(Collectors.groupingBy(ScreenProjectProcessCompletionRateDTO::getProjectName));
      projectNameMaps.forEach(
         (projectName, screenProjectProcessCompletionRateDTOS) -> {
            List<ScreenProjectProcessCompletionRate1VO> items = new ArrayList<>();
            ScreenProjectProcessCompletionRateVO valueVO = new ScreenProjectProcessCompletionRateVO();
            screenProjectProcessCompletionRateDTOS.stream()
               .collect(Collectors.groupingBy(ScreenProjectProcessCompletionRateDTO::getProductTaskName))
               .forEach((productTaskName, value) -> {
                  ScreenProjectProcessCompletionRate1VO screenProjectProcessCompletionRateVO = new ScreenProjectProcessCompletionRate1VO();
                  screenProjectProcessCompletionRateVO.set工序名称(productTaskName);
                  Double ton = 1000.0;
                  Double quantity = value.stream().mapToDouble(ScreenProjectProcessCompletionRateDTO::getQuantity).sum() / ton;
                  Double inspectionQuantity = value.stream().mapToDouble(ScreenProjectProcessCompletionRateDTO::getInspectionQuantity).sum() / ton;
                  screenProjectProcessCompletionRateVO.set完成率(quantity == 0.0 ? 0.0 : Double.valueOf(String.format("%.2f", inspectionQuantity / quantity)));
                  items.add(screenProjectProcessCompletionRateVO);
               });
            valueVO.set图表数据(items);
            valueVO.set项目名称(projectName);
            valueVO.setChartData(JSON.toJSONString(items));
            values.add(valueVO);
         }
      );
      return values;
   }

   @Override
   public List<ScreenProductionStatisticsVO> getProductionStatistics(String year, Long workshopId) {
      List<ScreenProductionStatisticsVO> result = new ArrayList<>();
      List<ScreenProductionStatisticsDTO> productionStatistics = this.baseMapper.getProductionStatistics(year, workshopId);
      Double ton = 1000.0;
      productionStatistics.forEach(
         item -> result.add(
            ScreenProductionStatisticsVO.builder()
               .build()
               .set工序(item.getProcessName())
               .set班组(item.getTeamName())
               .set昨日产量(Double.valueOf(String.format("%.2f", item.getYesterdayInspectionQuantity() / ton)))
               .set今日产量(Double.valueOf(String.format("%.2f", item.getTodayInspectionQuantity() / ton)))
         )
      );
      return result;
   }

   @Override
   public List<ScreenTeamAchievementRateProductionLineVO> getTeamAchievementRate(String year, Long workshopId) {
      List<ScreenTeamAchievementRateProductionLineVO> ScreenTeamAchievementRateProductionLineVOs = new ArrayList<>();
      Double ton = 1000.0;
      List<ScreenTeamAchievementRateProductionLineDTO> teamAchievementRateMonthly = this.baseMapper
         .getTeamAchievementRateMonthly(year, workshopId)
         .stream()
         .filter(item -> item.getProductionName() != null)
         .collect(Collectors.toList());
      teamAchievementRateMonthly.forEach(
         item -> {
            double v = item.getCompleteQuantity() / ton / (item.getSchedulingQuantity() / ton);
            ScreenTeamAchievementRateProductionLineVOs.add(
               ScreenTeamAchievementRateProductionLineVO.builder()
                  .build()
                  .set上月(Double.valueOf(String.format("%.2f", v * 100.0)))
                  .set产线(item.getProductionName())
            );
         }
      );
      Map<String, List<ScreenTeamAchievementRateProductionLineVO>> productionNameMobthMap = ScreenTeamAchievementRateProductionLineVOs.stream()
         .collect(Collectors.groupingBy(ScreenTeamAchievementRateProductionLineVO::get产线));
      List<ScreenTeamAchievementRateProductionLineDTO> teamAchievementRateYear = this.baseMapper
         .getTeamAchievementRateYear(year, workshopId)
         .stream()
         .filter(item -> item.getProductionName() != null)
         .collect(Collectors.toList());
      Map<String, List<ScreenTeamAchievementRateProductionLineDTO>> collect = teamAchievementRateYear.stream()
         .collect(Collectors.groupingBy(ScreenTeamAchievementRateProductionLineDTO::getProductionName));
      collect.forEach(
         (productionName, values) -> {
            AtomicReference<Double> annualAverage = new AtomicReference<>(0.0);
            values.forEach(item -> {
               double completeQuantity = item.getCompleteQuantity() / ton;
               double schedulingQuantity = item.getSchedulingQuantity() / ton;
               if (schedulingQuantity != 0.0) {
                  annualAverage.updateAndGet(v -> v + completeQuantity / schedulingQuantity);
               }
            });
            if (productionNameMobthMap.containsKey(productionName)) {
               ScreenTeamAchievementRateProductionLineVO screenTeamAchievementRateProductionLineVO = productionNameMobthMap.get(productionName).get(0);
               screenTeamAchievementRateProductionLineVO.set年度平均(Double.valueOf(String.format("%.2f", annualAverage.get() * 100.0 / values.size())));
            } else {
               ScreenTeamAchievementRateProductionLineVOs.add(
                  ScreenTeamAchievementRateProductionLineVO.builder()
                     .build()
                     .set上月(0.0)
                     .set年度平均(Double.valueOf(String.format("%.2f", annualAverage.get() * 100.0 / values.size())))
                     .set产线(productionName)
               );
            }
         }
      );
      return ScreenTeamAchievementRateProductionLineVOs;
   }

   @Override
   public List<ScreenMonthlyOutputVO> getMonthlyOutput(String year, String month, Long workshopId) {
      List<ScreenMonthlyOutputVO> monthlyOutputVOS = new ArrayList<>();
      List<ScreenMonthlyOutputDTO> monthlyOutput = this.baseMapper.getMonthlyOutput(year, month, workshopId);
      monthlyOutput.forEach(
         item -> monthlyOutputVOS.add(ScreenMonthlyOutputVO.builder().build().set班组(item.getTeamName()).set产量(item.getInspectionQuantity() / 1000.0))
      );
      return monthlyOutputVOS;
   }

   @Override
   public List<TeamProjectProduceInfo> findTeamProjectProduceInfo(Integer year, Long workShopId, Long productionId) {
      return this.baseMapper.findTeamProjectProduceInfo(year, workShopId, productionId);
   }

   @Override
   public List<ProjectProcessingProgressDTO> projectProcessingProgress(int year, Long workShopId, Long productionId) {
      return this.baseMapper.projectProcessingProgress(year, workShopId, productionId);
   }

   @Override
   public List<SimpleProjectProduceDTO> projectTotalWeightProgress() {
      return this.baseMapper.projectTotalWeightProgress();
   }

   @Override
   public List<SimpleProjectProduceDTO> projectTotalWeightProgressV2() {
      return this.baseMapper.projectTotalWeightProgressV2();
   }

   @Override
   public List<MesBuildingProductionPlanningDTO> getProductionPlanningDateil(LocalDateTime crrentTime) {
      return this.baseMapper.getProductionPlanningDateil(crrentTime);
   }

   @Override
   public List<MesSignageProcessLinkDTO> listSignageProcess(
      Long projectId,
      Long monomerId,
      List<Long> areaIds,
      Long classId,
      Long workshopId,
      Long productionLineId,
      String productSerialNumber,
      List<Long> areaBatchIds,
      List<Long> artifactIds
   ) {
      return this.baseMapper
         .listSignageProcess(projectId, monomerId, areaIds, classId, workshopId, productionLineId, productSerialNumber, areaBatchIds, artifactIds);
   }

   @Override
   public List<MesBuildingProcessLagDTO> scheduledTaskLagNumber(LocalDateTime crrentTime) {
      return this.baseMapper.scheduledTaskLagNumber(crrentTime);
   }

   @Override
   public List<MesBuildingProcessNoProcessDTO> getNoProcessTeam(List<Long> taskOrderIds) {
      return this.baseMapper.getNoProcessTeam(taskOrderIds);
   }

   @Override
   public List<MesManualReportDTO> manualReportUnreportedList(MesManualReportQuery query) {
      return this.baseMapper.manualReportUnreportedList(query);
   }

   @Override
   public List<WastageCostSummaryValueDTO> getTaskProcessWastageLossCostSummary(
      Long projectId, Long workShopId, Long processId, Integer taskTypeEnum, String minYearMonth, String maxYearMonth, List<LocalDate> yearMonthDateList
   ) {
      return this.baseMapper
         .getTaskProcessWastageLossCostSummary(projectId, workShopId, processId, taskTypeEnum, minYearMonth, maxYearMonth, yearMonthDateList);
   }

   @Override
   public List<WastageCostSummaryValueDTO> getTaskProcessCompleteWastageLossCostSummary(
      Long projectId, Long workShopId, Long processId, Integer taskTypeEnum, String minYearMonth, String maxYearMonth, List<LocalDate> yearMonthDateList
   ) {
      return this.baseMapper
         .getTaskProcessCompleteWastageLossCostSummary(projectId, workShopId, processId, taskTypeEnum, minYearMonth, maxYearMonth, yearMonthDateList);
   }

   @Override
   public List<WastageCostSummaryValueDTO> getTaskProcessPendingProductsWastageLossCostSummary(
      Long projectId, Long workShopId, Long processId, Integer taskTypeEnum, String minYearMonth, String maxYearMonth, List<LocalDate> yearMonthDateList
   ) {
      return this.baseMapper
         .getTaskProcessPendingProductsWastageLossCostSummary(projectId, workShopId, processId, taskTypeEnum, minYearMonth, maxYearMonth, yearMonthDateList);
   }

   @Override
   public List<MesBuildingWipDailySnapshotProcessDTO> findWipStatisticsProcessList(MesBuildingWIPStatisticsVO query) {
      List<MesBuildingWIPStatisticsDTO> statisticsList = this.findWipStatisticsList(query);
      List<Integer> sortList = Arrays.asList(1, 16, 2);
      return extractprocess(statisticsList, sortList);
   }

   @Override
   public List<MesBuildingWIPStatisticsDTO> findWipStatisticsList(MesBuildingWIPStatisticsVO query) {
      List<MesBuildingWIPStatisticsDTO> wipStatisticsList = this.baseMapper.findWipStatisticsList(query);
      Map<String, MesBuildingWIPStatisticsDTO> statisticsDTOMap = wipStatisticsList.stream()
         .collect(Collectors.toMap(e -> e.getProjectId() + "-" + e.getWorkShopId(), Function.identity()));
      Map<Long, List<MesBuildingWIPStatisticsDTO>> statisticsProjectDTOMap = wipStatisticsList.stream().collect(Collectors.groupingBy(e -> e.getProjectId()));
      List<MesBuildingPartCompleteUseDTO> completePartList = this.baseMapper.selectPartCompleteUse();
      Map<String, List<MesBuildingPartCompleteUseDTO>> completePartMap = completePartList.stream()
         .collect(Collectors.groupingBy(e -> e.getProjectId() + "-" + e.getWorkShopId()));
      List<MesBuildingAssembleCompleteUseDTO> completeAssList = this.baseMapper.selectAssembleCompleteUse();
      Map<String, List<MesBuildingAssembleCompleteUseDTO>> completeAssMap = completeAssList.stream()
         .collect(Collectors.groupingBy(e -> e.getProjectId() + "-" + e.getWorkShopId()));
      List<CargoStatisticsDTO> cargoStatisticsList = this.baseMapper.findCargoStatisticsList(query);
      Map<Long, List<CargoStatisticsDTO>> cargoDTOMap = cargoStatisticsList.stream().collect(Collectors.groupingBy(e -> e.getProjectId()));
      statisticsDTOMap.forEach(
         (k, v) -> {
            if (completePartMap.containsKey(k)) {
               List<MesBuildingPartCompleteUseDTO> partDTO = completePartMap.get(k);
               if (CollectionUtils.isNotEmpty(partDTO)) {
                  Integer notUsedQuantity = partDTO.stream().map(e -> e.getCompleteQuantity() - e.getUseQuantity()).reduce(0, Integer::sum);
                  BigDecimal notUsedWeight = partDTO.stream()
                     .map(e -> BigDecimal.valueOf(e.getCompleteQuantity() - e.getUseQuantity()).multiply(e.getNetWeight()))
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  v.getProcessWipList().forEach(e -> {
                     if (e.getTaskTypeEnum().equals(TaskTypeEnum.MACHINE_PART.getType())) {
                        e.setQuantity(e.getQuantity() + notUsedQuantity);
                        e.setWeight(e.getWeight().add(notUsedWeight));
                     }
                  });
               }
            }

            if (completeAssMap.containsKey(k)) {
               List<MesBuildingAssembleCompleteUseDTO> assDTO = completeAssMap.get(k);
               if (CollectionUtils.isNotEmpty(assDTO)) {
                  Integer notUsedQuantity = assDTO.stream().map(e -> e.getCompleteQuantity() - e.getUseQuantity()).reduce(0, Integer::sum);
                  BigDecimal notUsedWeight = assDTO.stream()
                     .map(e -> BigDecimal.valueOf(e.getCompleteQuantity() - e.getUseQuantity()).multiply(e.getNetWeight()))
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  v.getProcessWipList().forEach(e -> {
                     if (e.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
                        e.setQuantity(e.getQuantity() + notUsedQuantity);
                        e.setWeight(e.getWeight().add(notUsedWeight));
                     }
                  });
               }
            }
         }
      );
      statisticsProjectDTOMap.forEach(
         (k, v) -> {
            if (cargoDTOMap.containsKey(k)) {
               List<CargoStatisticsDTO> dto = cargoDTOMap.get(k);
               if (v.size() >= dto.size()) {
                  v.forEach(
                     e -> {
                        CargoStatisticsDTO dtoItem = dto.stream().filter(d -> d.getWorkShopId().equals(e.getWorkShopId())).findFirst().orElse(null);
                        if (dtoItem != null) {
                           ProcessAndQuantityDTO one = ProcessAndQuantityDTO.builder()
                              .build()
                              .setProcessId(1000L)
                              .setProcessName("入库")
                              .setQuantity(dtoItem.getInboundQuantity())
                              .setWeight(dtoItem.getInboundWeight());
                           e.getProcessWipList().add(one);
                           ProcessAndQuantityDTO two = ProcessAndQuantityDTO.builder()
                              .build()
                              .setProcessId(1001L)
                              .setProcessName("发运")
                              .setQuantity(dtoItem.getCargoQuantity())
                              .setWeight(dtoItem.getCargoWeight());
                           e.getProcessWipList().add(two);
                           ProcessAndQuantityDTO three = ProcessAndQuantityDTO.builder()
                              .build()
                              .setProcessId(1002L)
                              .setProcessName("制成品库存")
                              .setQuantity(dtoItem.getInboundQuantity() - dtoItem.getCargoQuantity())
                              .setWeight(dtoItem.getInboundWeight().subtract(dtoItem.getCargoWeight()));
                           e.getProcessWipList().add(three);
                        }
                     }
                  );
               } else {
                  v.forEach(
                     e -> {
                        Integer inboundQuantity = dto.stream().mapToInt(CargoStatisticsDTO::getInboundQuantity).sum() / v.size();
                        BigDecimal inboundWeight = dto.stream()
                           .reduce(BigDecimal.ZERO, (a, b) -> a.add(b.getInboundWeight()), BigDecimal::add)
                           .divide(BigDecimal.valueOf(v.size()), 2, RoundingMode.HALF_UP);
                        ProcessAndQuantityDTO one = ProcessAndQuantityDTO.builder()
                           .build()
                           .setProcessId(1000L)
                           .setProcessName("入库")
                           .setQuantity(inboundQuantity)
                           .setWeight(inboundWeight);
                        e.getProcessWipList().add(one);
                        Integer cargoQuantity = dto.stream().mapToInt(CargoStatisticsDTO::getCargoQuantity).sum() / v.size();
                        BigDecimal cargoWeight = dto.stream()
                           .reduce(BigDecimal.ZERO, (a, b) -> a.add(b.getCargoWeight()), BigDecimal::add)
                           .divide(BigDecimal.valueOf(v.size()), 2, RoundingMode.HALF_UP);
                        ProcessAndQuantityDTO two = ProcessAndQuantityDTO.builder()
                           .build()
                           .setProcessId(1001L)
                           .setProcessName("发运")
                           .setQuantity(cargoQuantity)
                           .setWeight(cargoWeight);
                        e.getProcessWipList().add(two);
                        ProcessAndQuantityDTO three = ProcessAndQuantityDTO.builder()
                           .build()
                           .setProcessId(1002L)
                           .setProcessName("制成品库存")
                           .setQuantity(inboundQuantity - cargoQuantity)
                           .setWeight(inboundWeight.subtract(cargoWeight));
                        e.getProcessWipList().add(three);
                     }
                  );
               }
            }
         }
      );
      return wipStatisticsList;
   }

   private static List<MesBuildingWipDailySnapshotProcessDTO> extractprocess(List<MesBuildingWIPStatisticsDTO> dataList, List<Integer> sortList) {
      return dataList.stream()
         .flatMap(e -> e.getProcessWipList().stream())
         .collect(Collectors.toMap(e -> e.getProcessId(), Function.identity(), (old, newVal) -> old))
         .values()
         .stream()
         .sorted(
            (s1, s2) -> {
               if (sortList.contains(s1.getTaskTypeEnum())) {
                  return s1.getTaskTypeEnum().equals(s2.getTaskTypeEnum())
                     ? sortList.indexOf(s1.getTaskTypeEnum()) - sortList.indexOf(s2.getTaskTypeEnum())
                     : s1.getProcessId().compareTo(s2.getProcessId());
               } else {
                  return 1;
               }
            }
         )
         .map(e -> BeanUtil.copy(e, MesBuildingWipDailySnapshotProcessDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<MesBuildingWIPStatisticsDetailDTO> findWipStatisticsDetail(MesBuildingWIPStatisticsVO query) {
      List<MesBuildingWIPStatisticsDetailDTO> wipStatisticsList = this.baseMapper.findWipStatisticsDetail(query);
      List<MesBuildingWIPStatisticsDetailDTO> warehouseWipStatisticsDetail = this.baseMapper.findWarehouseWipStatisticsDetail();
      Map<String, List<MesBuildingWIPStatisticsDetailDTO>> statisticsMap = wipStatisticsList.stream()
         .filter(e -> e.getTaskTypeEnum().equals(TaskTypeEnum.MACHINE_PART.getType()) || e.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType()))
         .collect(Collectors.groupingBy(e -> e.getProjectId() + "-" + e.getWorkShopId() + "-" + e.getTaskTypeEnum() + "-" + e.getProductId()));
      List<MesBuildingPartCompleteUseDTO> completePartList = this.baseMapper.selectPartCompleteUse();
      Map<String, MesBuildingPartCompleteUseDTO> completePartMap = completePartList.stream()
         .collect(Collectors.toMap(e -> e.getProjectId() + "-" + e.getWorkShopId() + "-" + e.getTaskTypeEnum() + "-" + e.getPartId(), Function.identity()));
      List<MesBuildingAssembleCompleteUseDTO> completeAssList = this.baseMapper.selectAssembleCompleteUse();
      Map<String, MesBuildingAssembleCompleteUseDTO> completeAssMap = completeAssList.stream()
         .collect(Collectors.toMap(e -> e.getProjectId() + "-" + e.getWorkShopId() + "-" + e.getTaskTypeEnum() + "-" + e.getAssembleId(), Function.identity()));
      List<MesBuildingWIPStatisticsDetailDTO> needAdd = new ArrayList<>();
      statisticsMap.forEach((k, v) -> {
         MesBuildingPartCompleteUseDTO dto = completePartMap.get(k);
         MesBuildingAssembleCompleteUseDTO assDto = completeAssMap.get(k);
         boolean hasPartData = dto != null;
         boolean hasAssData = assDto != null;
         if (hasPartData || hasAssData) {
            v.forEach(e -> {
               if (hasPartData) {
                  BigDecimal notUsedLPart = BigDecimal.valueOf(dto.getCompleteQuantity() - dto.getUseQuantity());
                  e.setQuantity(e.getQuantity() + dto.getCompleteQuantity() - dto.getUseQuantity());
                  e.setTotalWeight(e.getTotalWeight().add(notUsedLPart.multiply(dto.getNetWeight())));
               } else if (hasAssData) {
                  BigDecimal notUsedAss = BigDecimal.valueOf(assDto.getCompleteQuantity() - assDto.getUseQuantity());
                  e.setQuantity(e.getQuantity() + assDto.getCompleteQuantity() - assDto.getUseQuantity());
                  e.setTotalWeight(e.getTotalWeight().add(notUsedAss.multiply(assDto.getNetWeight())));
               }
            });
            if (dto != null) {
               completePartMap.remove(k);
            } else if (assDto != null) {
               completeAssMap.remove(k);
            }
         }
      });
      completePartMap.values()
         .forEach(
            e -> needAdd.add(
               MesBuildingWIPStatisticsDetailDTO.builder()
                  .projectId(e.getProjectId())
                  .workShopId(e.getWorkShopId())
                  .serialNumber(e.getSerialNumber())
                  .specification(e.getSpecification())
                  .taskTypeEnum(e.getTaskTypeEnum())
                  .productId(e.getPartId())
                  .processId(0L)
                  .processName("未使用零件")
                  .quantity(e.getCompleteQuantity() - e.getUseQuantity())
                  .netWeight(e.getNetWeight())
                  .totalWeight(BigDecimal.valueOf(e.getCompleteQuantity() - e.getUseQuantity()).multiply(e.getNetWeight()))
                  .build()
            )
         );
      completeAssMap.values()
         .forEach(
            e -> needAdd.add(
               MesBuildingWIPStatisticsDetailDTO.builder()
                  .projectId(e.getProjectId())
                  .workShopId(e.getWorkShopId())
                  .serialNumber(e.getSerialNumber())
                  .specification(e.getSpecification())
                  .taskTypeEnum(e.getTaskTypeEnum())
                  .productId(e.getAssembleId())
                  .processId(0L)
                  .processName("未使用部件")
                  .quantity(e.getCompleteQuantity() - e.getUseQuantity())
                  .netWeight(e.getNetWeight())
                  .totalWeight(BigDecimal.valueOf(e.getCompleteQuantity() - e.getUseQuantity()).multiply(e.getNetWeight()))
                  .build()
            )
         );
      wipStatisticsList.addAll(needAdd);
      wipStatisticsList.addAll(warehouseWipStatisticsDetail);
      return wipStatisticsList;
   }

   @Override
   public List<MesBuildingTaskProcessInfoDTO> listInfo(MesBuildingTaskProcessQuery query) {
      return this.baseMapper.listInfo(query);
   }

   @Override
   public List<JSONObject> productionKanbanLagInfo(Collection<Long> projectIdList, Long workshopId) {
      return this.baseMapper.productionKanbanLagInfo(projectIdList, workshopId, LocalDate.now());
   }
}
