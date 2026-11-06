package com.hzchum.scim.mes.building.core.biz.impl.projectKanban;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.DateTimeUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.dto.ProjectProductInfoDTO;
import com.hzchum.scim.common.core.api.pojo.dto.ProjectProductProcessDTO;
import com.hzchum.scim.common.core.api.pojo.dto.ProjectsTreeDTO;
import com.hzchum.scim.contract.core.api.enums.ProjectStatusEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingGroupsTeamLinkBiz;
import com.hzchum.scim.mes.building.core.api.biz.projectKanban.ProjectKanbanBiz;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProductProcessProgressDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProgressDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProjectKanBanDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProjectProductTaskSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProjectStatusSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskInventoryProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskProcessProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskTrackingProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.TaskTrackingProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.util.ArtifactCompleteSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.util.EnclosureCompleteSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.projectKanban.ProjectSummaryDTOParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskOrderService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleDetailService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectKanbanBizImpl implements ProjectKanbanBiz {
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private MesBuildingTaskService taskService;
   @Autowired
   private MesBuildingTaskProcessService taskProcessService;
   @Autowired
   private TechAssembleService assembleService;
   @Autowired
   private TechAssembleDetailService assembleDetailService;
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;
   @Autowired
   private MesBuildingGroupsTeamLinkBiz groupsTeamLinkBiz;
   @Autowired
   private MesBuildingTeamUserLinkService teamUserLinkService;
   @Autowired
   private MesBuildingTeamService teamService;
   @Autowired
   private MesBuildingTaskOrderService taskOrderService;
   @Autowired
   private MesBuildingProductionLineService productionLineService;
   @Autowired
   private MesBuildingWorkshopService workshopService;
   @Autowired
   private MesBuildingProcessService processService;

   @Override
   public ProjectKanBanDTO projectSummary(ProjectSummaryDTOParam dtoParam) {
      return ProjectKanBanDTO.builder()
         .type(this.projectService.getById(dtoParam.getProjectId()).getEnclosureMeasureMode())
         .artifactSummary(BeanUtil.copy(this.taskService.artifactSummary(dtoParam), ArtifactCompleteSummaryDTO.class))
         .enclosureSummary(
            this.taskService.enclosureSummary(dtoParam).stream().map(e -> BeanUtil.copy(e, EnclosureCompleteSummaryDTO.class)).collect(Collectors.toList())
         )
         .build();
   }

   @Override
   public List<ProjectSimpleInfoDTO> projectSummaryYear(LocalDateTime date, Integer status, String name, List<Long> projectIds, Integer projectType) {
      return this.projectService.projectSummaryYear(date, status, name, projectIds, projectType);
   }

   @Override
   public PageVO<ProjectSimpleInfoDTO> projectSummaryYearPage(
      LocalDateTime date, Integer status, String name, Integer pageNumber, Integer pageSize, Integer projectType, Integer lumpSumSystemType
   ) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(projectType, null, lumpSumSystemType, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      return projectIds.size() == 0
         ? new PageVO<>()
         : new PageVO<>(PageHelper.startPage(pageNumber, pageSize), this.projectSummaryYear(date, status, name, projectIds, projectType));
   }

   @Override
   public List<TaskTrackingProcessDTO> processSummary(
      Long projectId,
      Long monomerId,
      Long areaId,
      LocalDateTime dateTime,
      Long productionLineId,
      Integer ProductType,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long workshopId
   ) {
      List<TaskTrackingProcessDTO> trackingProcessList = this.taskProcessService
         .processSummaryProduct(projectId, monomerId, areaId, dateTime, productionLineId, ProductType, startDate, endDate, workshopId);
      List<MesBuildingTask> taskList = this.taskService
         .list(
            Wrappers.lambdaQuery(MesBuildingTask.class)
               .eq(projectId != null, MesBuildingTask::getProjectId, projectId)
               .eq(monomerId != null, MesBuildingTask::getMonomerId, monomerId)
               .eq(areaId != null, MesBuildingTask::getAreaId, areaId)
               .eq(productionLineId != null, MesBuildingTask::getProductionLineId, productionLineId)
               .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
         );
      Map<Long, List<MesBuildingTask>> productMap = taskList.stream().collect(Collectors.groupingBy(MesBuildingTask::getProductId));
      List<Long> artifactIds = taskList.stream().map(MesBuildingTask::getProductId).collect(Collectors.toList());
      if (artifactIds.size() > 0) {
         List<TechArtifact> techArtifacts = this.artifactService.listByIds(artifactIds);
         List<Long> singleArtifactIds = new ArrayList<>();
         List<Long> allPartArtifactIds = techArtifacts.stream()
            .filter(TechArtifact::getBoolAllPartSendDirectly)
            .map(TechArtifact::getId)
            .collect(Collectors.toList());
         singleArtifactIds.addAll(allPartArtifactIds);
         if (singleArtifactIds.size() != 0) {
            TaskTrackingProcessDTO processSummarySingleArtifact = this.taskProcessService
               .processSummarySingleArtifact(projectId, monomerId, areaId, productionLineId, ProductType, startDate, endDate, singleArtifactIds);
            if (processSummarySingleArtifact != null) {
               processSummarySingleArtifact.setId(-1L);
               processSummarySingleArtifact.setName("散发檩条");
               trackingProcessList.add(processSummarySingleArtifact);
            }
         }
      }

      return trackingProcessList;
   }

   private void buildTrackingProcess(
      List<TaskTrackingProcessDTO> trackingProcessDTOS, Map<Long, List<TaskInventoryProcessDTO>> inventoryProcessMap, Integer productType
   ) {
      trackingProcessDTOS.forEach(e -> {
         Integer quantity = 0;
         BigDecimal netWeight = BigDecimal.ZERO;
         BigDecimal grossWeight = BigDecimal.ZERO;
         List<TaskInventoryProcessDTO> processDTOS = inventoryProcessMap.get(e.getId());
         if (CollectionUtils.isNotEmpty(processDTOS)) {
            if (TaskTypeEnum.MACHINE_PART.getType().equals(productType) && "钻孔".equals(e.getName())) {
               processDTOS = processDTOS.stream().filter(TaskInventoryProcessDTO::getBoolHaveHole).collect(Collectors.toList());
            }

            quantity = processDTOS.stream().mapToInt(TaskInventoryProcessDTO::getQuantity).sum();
            netWeight = processDTOS.stream().map(x -> x.getNetWeight().multiply(new BigDecimal(x.getQuantity()))).reduce(BigDecimal.ZERO, BigDecimal::add);
            grossWeight = processDTOS.stream().map(x -> x.getGrossWeight().multiply(new BigDecimal(x.getQuantity()))).reduce(BigDecimal.ZERO, BigDecimal::add);
         }

         e.setTotalNetWeight(netWeight);
         e.setTotalGrossWeight(grossWeight);
         e.setQuantity(quantity);
         e.setRate(BigDecimal.valueOf(e.getCompleteQuantity() / e.getQuantity()));
      });
   }

   @Override
   public List<TaskTrackingProductDTO> processSummaryDetail(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      Long productionLineId,
      String serialNumber,
      Integer taskType,
      Long processId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer status
   ) {
      if (processId == null && taskType.equals(TaskTypeEnum.ARTIFACT.getType())) {
         List<MesBuildingTask> taskList = this.taskService
            .list(
               Wrappers.lambdaQuery(MesBuildingTask.class)
                  .eq(projectId != null, MesBuildingTask::getProjectId, projectId)
                  .eq(monomerId != null, MesBuildingTask::getMonomerId, monomerId)
                  .eq(areaId != null, MesBuildingTask::getAreaId, areaId)
                  .eq(productionLineId != null, MesBuildingTask::getProductionLineId, productionLineId)
                  .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
            );
         Map<Long, Long> productMap = taskList.stream().collect(Collectors.toMap(s -> s.getProductId(), s -> s.getProductionLineId()));
         List<Long> artifactIds = taskList.stream().map(MesBuildingTask::getProductId).collect(Collectors.toList());
         List<TaskTrackingProductDTO> taskTrackingProductDTOS = new ArrayList<>();
         if (artifactIds.size() > 0) {
            List<TechArtifact> techArtifacts = this.artifactService.listByIds(artifactIds);
            List<Long> singleArtifactIds = new ArrayList<>();

            for (TechArtifact techArtifact : techArtifacts.stream()
               .filter(artifact -> artifact.getBoolSinglePartEnum() && !artifact.getBoolAllPartSendDirectly())
               .collect(Collectors.toList())) {
               if (!this.utilsBiz.getBoolSinglePartArtifactPaint(techArtifact, productMap.get(techArtifact.getId()))) {
                  singleArtifactIds.add(techArtifact.getId());
               }
            }

            List<Long> allPartArtifactIds = techArtifacts.stream()
               .filter(TechArtifact::getBoolAllPartSendDirectly)
               .map(TechArtifact::getId)
               .collect(Collectors.toList());
            singleArtifactIds.addAll(allPartArtifactIds);
            if (singleArtifactIds.size() != 0) {
               taskTrackingProductDTOS = this.taskService
                  .taskSummaryDetail(
                     projectId, monomerId, areaId, workshopId, productionLineId, serialNumber, taskType, startDate, endDate, status, singleArtifactIds
                  );
            }
         }

         return taskTrackingProductDTOS;
      } else {
         List<Long> assembleIds = new ArrayList<>();
         List<Long> typesettingIds = new ArrayList<>();
         List<TaskTrackingProductDTO> taskTrackingProductDTOS = this.taskService
            .processSummaryDetail(
               projectId,
               monomerId,
               areaId,
               null,
               workshopId,
               productionLineId,
               serialNumber,
               taskType,
               processId,
               startDate,
               endDate,
               status,
               typesettingIds,
               assembleIds
            );
         return taskTrackingProductDTOS.size() == 0 ? new ArrayList<>() : taskTrackingProductDTOS;
      }
   }

   @Override
   public PageVO<TaskTrackingProductDTO> processSummaryDetailPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      LocalDateTime dateTime,
      Long workshopId,
      Long productionLineId,
      String serialNumber,
      Integer productType,
      Long processId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer status,
      Integer pageNumber,
      Integer pageSize
   ) {
      if ((processId == null || processId == -1L) && productType.equals(TaskTypeEnum.ARTIFACT.getType())) {
         String dataTime = "";
         if (dateTime != null) {
            dataTime = dateTime.getMonthValue() > 9
               ? dateTime.getYear() + "-" + dateTime.getMonthValue()
               : dateTime.getYear() + "-0" + dateTime.getMonthValue();
         }

         List<MesBuildingTask> taskList = this.taskService
            .list(
               Wrappers.lambdaQuery(MesBuildingTask.class)
                  .eq(projectId != null, MesBuildingTask::getProjectId, projectId)
                  .eq(monomerId != null, MesBuildingTask::getMonomerId, monomerId)
                  .eq(areaId != null, MesBuildingTask::getAreaId, areaId)
                  .likeRight(dateTime != null, BaseEntity::getCreateTime, dataTime)
                  .eq(productionLineId != null, MesBuildingTask::getProductionLineId, productionLineId)
                  .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
            );
         Map<Long, Long> productMap = taskList.stream().collect(Collectors.toMap(s -> s.getProductId(), s -> s.getProductionLineId()));
         List<Long> artifactIds = taskList.stream().map(MesBuildingTask::getProductId).collect(Collectors.toList());
         List<TaskTrackingProductDTO> taskTrackingProductDTOS = new ArrayList<>();
         Page<Object> page = null;
         if (artifactIds.size() > 0) {
            List<TechArtifact> techArtifacts = this.artifactService.listByIds(artifactIds);
            List<Long> singleArtifactIds = new ArrayList<>();

            for (TechArtifact techArtifact : techArtifacts.stream()
               .filter(artifact -> artifact.getBoolSinglePartEnum() && !artifact.getBoolAllPartSendDirectly())
               .collect(Collectors.toList())) {
               if (!this.utilsBiz.getBoolSinglePartArtifactPaint(techArtifact, productMap.get(techArtifact.getId()))) {
                  singleArtifactIds.add(techArtifact.getId());
               }
            }

            List<Long> allPartArtifactIds = techArtifacts.stream()
               .filter(TechArtifact::getBoolAllPartSendDirectly)
               .map(TechArtifact::getId)
               .collect(Collectors.toList());
            singleArtifactIds.addAll(allPartArtifactIds);
            if (singleArtifactIds.size() != 0) {
               page = PageHelper.startPage(pageNumber, pageSize);
               taskTrackingProductDTOS = this.taskService
                  .taskSummaryDetail(
                     projectId, monomerId, areaId, workshopId, productionLineId, serialNumber, productType, startDate, endDate, status, singleArtifactIds
                  );
            }
         }

         return new PageVO<>(page, taskTrackingProductDTOS);
      } else {
         List<Long> assembleIds = new ArrayList<>();
         List<Long> typesettingIds = new ArrayList<>();
         Page<Object> page = PageHelper.startPage(pageNumber, pageSize);
         List<TaskTrackingProductDTO> taskTrackingProductDTOS = this.taskService
            .processSummaryDetail(
               projectId,
               monomerId,
               areaId,
               dateTime,
               workshopId,
               productionLineId,
               serialNumber,
               productType,
               processId,
               startDate,
               endDate,
               status,
               typesettingIds,
               assembleIds
            );
         return taskTrackingProductDTOS.size() == 0 ? new PageVO<>() : new PageVO<>(page, taskTrackingProductDTOS);
      }
   }

   @Override
   public PrintVO<List<Map<String, Object>>> processSummaryDetailPrint(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      Long productionLineId,
      String serialNumber,
      Integer productType,
      Long processId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer status
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      String date = startDate != null && endDate != null ? DateTimeUtil.getLocalDateStr(startDate) + "-" + DateTimeUtil.getLocalDateStr(endDate) : "全部";
      header.put("date", date);
      printVO.setHeader(header);
      printVO.setTable(
         this.processSummaryDetail(projectId, monomerId, areaId, workshopId, productionLineId, serialNumber, productType, processId, startDate, endDate, status)
            .stream()
            .map(BeanUtil::beanToMap)
            .collect(Collectors.toList())
      );
      return printVO;
   }

   @Override
   public List<TaskProcessProductDTO> groupTaskDetail(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long productId,
      Long productionLineId,
      Integer taskType,
      Long processId,
      LocalDateTime startDate,
      LocalDateTime endDate
   ) {
      return this.taskService.groupTaskDetail(projectId, monomerId, areaId, productId, productionLineId, taskType, processId, startDate, endDate);
   }

   @Override
   public PageVO<TaskProcessProductDTO> groupTaskDetailPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long productId,
      Long productionLineId,
      Integer productType,
      Long processId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer pageNumber,
      Integer pageSize
   ) {
      return new PageVO<>(
         PageHelper.startPage(pageNumber, pageSize),
         this.groupTaskDetail(projectId, monomerId, areaId, productId, productionLineId, productType, processId, startDate, endDate)
      );
   }

   @Override
   public List<NameInfo> findHasTaskWorkShop() {
      List<Long> prodLineIds = this.taskOrderService
         .list(Wrappers.lambdaQuery(MesBuildingTaskOrder.class).select(MesBuildingTaskOrder::getProductionLineId))
         .stream()
         .map(e -> e.getProductionLineId())
         .distinct()
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(prodLineIds)) {
         return new ArrayList<>();
      }

      List<MesBuildingProductionLine> lines = this.productionLineService.listByIds(prodLineIds);
      List<Long> shopIds = lines.stream().map(e -> e.getWorkshopId()).distinct().collect(Collectors.toList());
      return this.workshopService.listByIds(shopIds).stream().map(e -> BeanUtil.copy(e, NameInfo.class)).collect(Collectors.toList());
   }

   @Override
   public List<ProjectsTreeDTO> getProjectKanbanTrees(Long workshopId, Integer status, LocalDateTime dateTime) {
      List<Long> projectIds = this.taskOrderService
         .list(Wrappers.lambdaQuery(MesBuildingTaskOrder.class).select(MesBuildingTaskOrder::getProjectId))
         .stream()
         .map(e -> e.getProjectId())
         .distinct()
         .collect(Collectors.toList());
      List<ProjectsTreeDTO> projectTreeByProjectId = new ArrayList<>();
      if (com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isNotEmpty(projectIds)) {
         List<ProjectSimpleInfoDTO> dtoList = this.projectService
            .listSimpleProject(null, null, null, null)
            .getContent()
            .stream()
            .filter(e -> e.getStatus().equals(status) && projectIds.contains(e.getId()))
            .collect(Collectors.toList());
         projectTreeByProjectId = this.projectService
            .findProjectTreeByProjectId(dtoList.stream().map(e -> e.getId()).collect(Collectors.toList()), workshopId, dateTime);
      }

      return projectTreeByProjectId;
   }

   @Override
   public ProjectStatusSummaryDTO getProjectStatusSummary(Long workshopId, LocalDateTime dateTime) {
      ProjectStatusSummaryDTO summaryDTO = new ProjectStatusSummaryDTO();
      List<Long> containLineIds = this.productionLineService
         .list(
            Wrappers.lambdaQuery(MesBuildingProductionLine.class)
               .select(MesBuildingProductionLine::getId)
               .eq(MesBuildingProductionLine::getWorkshopId, workshopId)
               .eq(MesBuildingProductionLine::getBoolEnabledEnum, Boolean.TRUE)
         )
         .stream()
         .map(e -> e.getId())
         .collect(Collectors.toList());
      List<Long> projectIds = this.taskOrderService
         .list(
            Wrappers.lambdaQuery(MesBuildingTaskOrder.class)
               .select(MesBuildingTaskOrder::getProjectId)
               .in(MesBuildingTaskOrder::getProductionLineId, containLineIds)
               .last("AND DATE_FORMAT(orde.create_time, '%Y') = DATE_FORMAT(" + dateTime + ", '%Y')")
         )
         .stream()
         .map(e -> e.getProjectId())
         .distinct()
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(projectIds)) {
         List<ProjectSimpleInfoDTO> dtoList = this.projectService
            .listSimpleProject(null, null, null, null)
            .getContent()
            .stream()
            .filter(e -> projectIds.contains(e.getId()))
            .collect(Collectors.toList());
         summaryDTO.setProjectCount(dtoList.size());
         summaryDTO.setProcessingCount((int)dtoList.stream().filter(e -> e.getStatus().equals(ProjectStatusEnum.PROCESSING.getType())).count());
         summaryDTO.setCompletedCount((int)dtoList.stream().filter(e -> e.getStatus().equals(ProjectStatusEnum.COMPLETED.getType())).count());
      }

      return summaryDTO;
   }

   @Override
   public ProjectProductTaskSummaryDTO getProductTaskSummary(List<Long> areaIds) {
      ProjectProductTaskSummaryDTO summaryDTO = new ProjectProductTaskSummaryDTO();
      List<MesBuildingTask> tasks = this.taskService.list(Wrappers.lambdaQuery(MesBuildingTask.class).in(MesBuildingTask::getAreaId, areaIds));
      List<MesBuildingTask> artTasks = tasks.stream().filter(e -> e.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())).collect(Collectors.toList());
      summaryDTO.setArtifactTaskCount(artTasks.stream().map(e -> e.getTaskQuantity()).reduce(0, Integer::sum));
      summaryDTO.setArtifactCompletedCount(artTasks.stream().map(e -> e.getCompleteQuantity()).reduce(0, Integer::sum));
      List<MesBuildingTask> assTasks = tasks.stream().filter(e -> e.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())).collect(Collectors.toList());
      summaryDTO.setArtifactTaskCount(assTasks.stream().map(e -> e.getTaskQuantity()).reduce(0, Integer::sum));
      summaryDTO.setArtifactCompletedCount(assTasks.stream().map(e -> e.getCompleteQuantity()).reduce(0, Integer::sum));
      return summaryDTO;
   }

   @Override
   public PageVO<ProjectProductInfoDTO> findProjectProductProcessInfos(
      List<Long> areaIds, Long monmerId, Long areaId, Long classId, String serialNumber, Integer pageNumber, Integer pageSize
   ) {
      List<Long> userProjectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(userProjectIds)) {
         return new PageVO<>();
      }

      PageHelper.startPage(pageNumber, pageSize);
      List<ProjectProductInfoDTO> artifacts = this.artifactService.findSchedulingArtifactInfo(userProjectIds, areaIds, monmerId, areaId, classId, serialNumber);
      PageVO vo = new PageVO<>(artifacts);
      List<Long> artIds = artifacts.stream().map(e -> e.getId()).collect(Collectors.toList());
      List<ProjectProductProcessDTO> progressDTOS = this.taskProcessService
         .findProductTaskProcessProgress(artIds, null, null, null, TaskTypeEnum.ARTIFACT.getType(), null, null);
      Map<Long, List<ProjectProductProcessDTO>> artProgressMap = progressDTOS.stream().collect(Collectors.groupingBy(ProjectProductProcessDTO::getProductId));
      List<ProjectProductProcessDTO> artifctAssembleLinkProgress = this.taskProcessService.findArtifctAssembleLinkProgress(artIds);
      Map<Long, List<ProjectProductProcessDTO>> artAssProgressMap = artifctAssembleLinkProgress.stream()
         .collect(Collectors.groupingBy(ProjectProductProcessDTO::getProductId));

      for (ProjectProductInfoDTO artifact : artifacts) {
         List<ProjectProductProcessDTO> artAssProgress = artAssProgressMap.get(artifact.getId());
         List<ProjectProductProcessDTO> artProgress = artProgressMap.get(artifact.getId());
         artAssProgress.addAll(artProgress);
         artifact.setProcessDTOList(artAssProgress);
      }

      vo.setContent(artifacts);
      return vo;
   }

   @Override
   public ProgressDetailDTO findProductProcessDetails(Long productId, Long processId, Long classId, String serialNumber, Integer taskTypeEnum, Integer type) {
      type = type == null ? 0 : type;
      Preconditions.checkArgument(productId != null && processId != null, "产品和工序不能为空");
      List<ProductProcessProgressDetailDTO> productProcessDetails = new ArrayList<>();
      if (TaskTypeEnum.ARTIFACT.getType().equals(taskTypeEnum)) {
         productProcessDetails = this.taskProcessService.findArtifactProcessDetails(productId, processId, classId, serialNumber);
      } else if (TaskTypeEnum.ASSEMBLE.getType().equals(taskTypeEnum)) {
         productProcessDetails = this.taskProcessService.findAssembleProcessDetails(productId, processId, classId, serialNumber);
      }

      Integer finalType = type;
      productProcessDetails.stream().filter(e -> {
         if (finalType == 1) {
            return e.getNeedQuantity() == e.getCompletedQuantity();
         } else if (finalType != 2) {
            return finalType == 3 ? e.getCompletedQuantity() == 0 : true;
         } else {
            return e.getNeedQuantity() > e.getCompletedQuantity() && e.getCompletedQuantity() > 0;
         }
      }).collect(Collectors.toList());
      Integer needSum = productProcessDetails.stream().map(e -> e.getNeedQuantity()).reduce(0, Integer::sum);
      Integer competeSum = productProcessDetails.stream().map(e -> e.getCompletedQuantity()).reduce(0, Integer::sum);
      ProgressDetailDTO dto = new ProgressDetailDTO();
      Long projectId = 0L;
      if (TaskTypeEnum.ARTIFACT.getType().equals(taskTypeEnum)) {
         TechArtifact art = this.artifactService.getById(productId);
         projectId = art.getProjectId();
      } else if (TaskTypeEnum.ASSEMBLE.getType().equals(taskTypeEnum)) {
         TechAssemble ass = this.assembleService.getById(productId);
         projectId = ass.getProjectId();
      }

      ContractProject project = this.projectService.getById(projectId);
      dto.setName(project.getShortName());
      dto.setSerialNumber(project.getSerialNumber());
      dto.setProcessName(this.processService.getById(processId).getName());
      dto.setNeedQuantitySum(needSum);
      dto.setCompleteQuantitySum(competeSum);
      dto.setProgressList(productProcessDetails);
      return dto;
   }
}
