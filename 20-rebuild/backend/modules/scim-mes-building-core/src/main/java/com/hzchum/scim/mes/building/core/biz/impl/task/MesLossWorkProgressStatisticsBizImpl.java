package com.hzchum.scim.mes.building.core.biz.impl.task;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.SimpleColumnWidthStyleStrategy;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.PageUtil;
import com.hzchum.scim.common.core.api.enums.RawMaterialLossEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectStatusEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.task.MesLossWorkProgressStatisticsBiz;
import com.hzchum.scim.mes.building.core.api.enums.MesLossWorkProgressStatisticsEnum;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.process.ProcessTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.ProjectOrWorkShopEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingGroupsTeamLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._dto.lossWorkProgressStatistics.PickingDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.lossWorkProgressStatistics.ProductProcessWorkProgressStatisticsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.lossWorkProgressStatistics.ProductProcessWorkProgressStatisticsDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.lossWorkProgressStatistics.ProductWastageLossCostMesDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.lossWorkProgressStatistics.ProjectLossProcessProductionKanBanDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.lossWorkProgressStatistics.ProjectLossWorkProgressStatisticsWastageDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.lossWorkProgressStatistics.WastageCostSummaryValueDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.lossWorkProgressStatistics.WastageLossCostSummaryDTO;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingGroupsTeamLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.plan.core.api.enums.MachinePartRelationTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.UnitEnum;
import com.hzchum.scim.wms.core.api.enums.UnitsPrecisionEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Unit;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.OutboundDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.ReturnDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.DownLoadDetailDO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.SubjectMeasureDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.IdAndMete;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.UnitService;
import com.hzchum.scim.wms.core.api.service.wmsReport.ReportService;
import feign.Util;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.stereotype.Service;

@Service
public class MesLossWorkProgressStatisticsBizImpl implements MesLossWorkProgressStatisticsBiz {
   @Resource
   private ContractProjectService projectService;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private TechAssembleService assembleService;
   @Resource
   private TechMachinePartService machinePartService;
   @Resource
   private MesBuildingTaskService taskService;
   @Resource
   private MesBuildingTaskProcessService taskProcessService;
   @Resource
   private MesBuildingProcessService processService;
   @Resource
   private MesBuildingTeamService teamService;
   @Resource
   private MesBuildingWorkshopService workshopService;
   @Resource
   private ConfigService configService;
   @Resource
   private MesBuildingGroupsTeamLinkService groupsTeamLinkService;
   @Resource
   private MesBuildingTeamUserLinkService teamUserLinkService;
   @Resource
   private ReportService reportService;
   @Resource
   private ClassificationService classificationService;
   @Resource
   private MeasureService measureService;
   @Resource
   private UnitService unitService;
   @Resource
   private RedisUtils redisUtils;
   private static final ObjectMapper objectMapper = new ObjectMapper();
   private static final String PROJECT_WASTAGEDTOBY_KEY = "project_wastagedtoby_key";
   private static final String WORKSHOP_WASTAGEDTOBY_KEY = "workshop_wastagedtoby_key";
   private static final String PROJECT_WASTAGEDTOBY_DETAIL_KEY = "project_wastagedtoby_detail_key";
   private static final String WORKSHOP_WASTAGEDTOBY_DETAIL_KEY = "workshop_wastagedtoby_deail_key";

   @Override
   public PageVO<ProjectLossWorkProgressStatisticsWastageDTO> wastageLossList(
      Integer year, Integer status, Long projectId, Long workShopId, Integer projectOrWorkShopEnum, Integer pageNumber, Integer pageSize, Boolean boolDownload
   ) {
      Integer lossCalculationFormula = this.configService.getRawMaterialLossCalculationFormula();
      Util.checkArgument(lossCalculationFormula != null && RawMaterialLossEnum.isExist(lossCalculationFormula), "查询失败,原料损耗公式不存在!");
      List<Long> projectIds = projectId == null ? new ArrayList<>() : Arrays.asList(projectId);
      List<Long> workShopIds = workShopId == null ? new ArrayList<>() : Arrays.asList(workShopId);
      new ArrayList();
      if (ProjectOrWorkShopEnum.PROJECT.getType().equals(projectOrWorkShopEnum)) {
         if (CollectionUtils.isEmpty(projectIds)) {
            projectIds = this.projectService
               .listSimpleProject(null, null, null, null)
               .getContent()
               .stream()
               .filter(ex -> status == null || ex.getStatus().equals(status))
               .map(ProjectSimpleInfoDTO::getId)
               .collect(Collectors.toList());
            if (CollectionUtils.isEmpty(projectIds)) {
               return new PageVO<>();
            }
         }

         if (boolDownload) {
            return new PageVO<>(PageHelper.startPage(pageNumber, pageSize), this.getWastageDtoByProject(year, status, projectIds, lossCalculationFormula));
         }

         Object redisDateObject = this.redisUtils.get("project_wastagedtoby_key");
         if (redisDateObject == null) {
            return new PageVO<>(PageHelper.startPage(pageNumber, pageSize), this.getWastageDtoByProject(year, status, projectIds, lossCalculationFormula));
         }

         List<ProjectLossWorkProgressStatisticsWastageDTO> var17;
         try {
            var17 = objectMapper.readValue(
               redisDateObject.toString(), objectMapper.getTypeFactory().constructCollectionType(List.class, ProjectLossWorkProgressStatisticsWastageDTO.class)
            );
         } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
         }

         List<Long> finalProjectIds = projectIds;
         var17 = var17.stream().filter(ex -> finalProjectIds.contains(ex.getProjectId())).collect(Collectors.toList());
         return PageUtil.listPage(pageNumber, pageSize, var17);
      } else if (ProjectOrWorkShopEnum.WORKSHOP.getType().equals(projectOrWorkShopEnum)) {
         if (boolDownload) {
            return new PageVO<>(PageHelper.startPage(pageNumber, pageSize), this.getWastageDtoByWorkShop(workShopIds, lossCalculationFormula));
         }

         Object redisDateObject = this.redisUtils.get("workshop_wastagedtoby_key");
         if (redisDateObject == null) {
            return new PageVO<>(PageHelper.startPage(pageNumber, pageSize), this.getWastageDtoByWorkShop(workShopIds, lossCalculationFormula));
         }

         List<ProjectLossWorkProgressStatisticsWastageDTO> resultListDTOList;
         try {
            resultListDTOList = objectMapper.readValue(
               redisDateObject.toString(), objectMapper.getTypeFactory().constructCollectionType(List.class, ProjectLossWorkProgressStatisticsWastageDTO.class)
            );
         } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
         }

         if (CollectionUtils.isNotEmpty(workShopIds)) {
            resultListDTOList = resultListDTOList.stream().filter(ex -> workShopIds.contains(ex.getWorkShopId())).collect(Collectors.toList());
         }

         return PageUtil.listPage(pageNumber, pageSize, resultListDTOList);
      } else {
         return new PageVO<>();
      }
   }

   private void updateAndCacheData() {
      Integer lossCalculationFormula = this.configService.getRawMaterialLossCalculationFormula();
      List<Long> projectIds = this.projectService.list().stream().map(ContractProject::getId).collect(Collectors.toList());
      List<ProjectLossWorkProgressStatisticsWastageDTO> wastageDtoByProject = this.getWastageDtoByProject(null, null, projectIds, lossCalculationFormula);
      if (CollectionUtils.isNotEmpty(wastageDtoByProject)) {
         try {
            String jsonData = objectMapper.writeValueAsString(wastageDtoByProject);
            this.redisUtils.set("project_wastagedtoby_key", jsonData);
         } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
         }
      }

      List<ProjectLossWorkProgressStatisticsWastageDTO> wastageDtoByWorkShop = this.getWastageDtoByWorkShop(null, lossCalculationFormula);
      if (CollectionUtils.isNotEmpty(wastageDtoByWorkShop)) {
         try {
            String jsonData = objectMapper.writeValueAsString(wastageDtoByWorkShop);
            this.redisUtils.set("workshop_wastagedtoby_key", jsonData);
         } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
         }
      }
   }

   @Override
   public List<ProjectLossWorkProgressStatisticsWastageDTO> getWastageDtoByProject(
      Integer year, Integer status, List<Long> projectIds, Integer lossCalculationFormula
   ) {
      if (CollectionUtils.isEmpty(projectIds)) {
         projectIds = this.projectService
            .listSimpleProject(null, null, null, null)
            .getContent()
            .stream()
            .map(ProjectSimpleInfoDTO::getId)
            .collect(Collectors.toList());
         if (CollectionUtils.isEmpty(projectIds)) {
            return new ArrayList<>();
         }
      }

      List<ContractProject> projects = this.projectService.wastageLossProjectList(year, status, projectIds);
      if (CollectionUtils.isEmpty(projects)) {
         return new ArrayList<>();
      }

      projectIds = projects.stream().map(ContractProject::getId).collect(Collectors.toList());
      List<TechArtifact> allArtifactList = this.artifactService
         .list(
            (new LambdaQueryWrapper<TechArtifact>().in(TechArtifact::getProjectId, projectIds))
               .select(
                  TechArtifact::getId,
                  TechArtifact::getProjectId,
                  TechArtifact::getQuantity,
                  TechArtifact::getNetWeight,
                  TechArtifact::getGrossWeight,
                  TechArtifact::getProducedQuantity
               )
         );
      List<TechAssemble> allAssembleList = this.assembleService
         .list(
            (new LambdaQueryWrapper<TechAssemble>().in(TechAssemble::getProjectId, projectIds))
               .select(
                  TechAssemble::getId,
                  TechAssemble::getProjectId,
                  TechAssemble::getQuantity,
                  TechAssemble::getNetWeight,
                  TechAssemble::getGrossWeight,
                  TechAssemble::getProducedQuantity
               )
         );
      List<TechMachinePart> machinePartList = this.machinePartService
         .list(
            (new LambdaQueryWrapper<TechMachinePart>().in(TechMachinePart::getProjectId, projectIds))
               .select(
                  TechMachinePart::getId,
                  TechMachinePart::getProjectId,
                  TechMachinePart::getQuantity,
                  TechMachinePart::getNetWeight,
                  TechMachinePart::getGrossWeight,
                  TechMachinePart::getProducedQuantity
               )
         );
      Map<Long, List<TechArtifact>> artifactProjectMap = allArtifactList.stream().collect(Collectors.groupingBy(TechArtifact::getProjectId));
      Map<Long, TechArtifact> artifactMap = allArtifactList.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      Map<Long, TechAssemble> assembleMap = allAssembleList.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
      Map<Long, TechMachinePart> machinePartMap = machinePartList.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
      Map<String, List<MesBuildingTask>> mesTaskProductTypeProjectMap = this.taskService
         .list(
            (new LambdaQueryWrapper<MesBuildingTask>().in(MesBuildingTask::getProjectId, projectIds))
               .select(
                  MesBuildingTask::getTaskTypeEnum,
                  MesBuildingTask::getProductId,
                  MesBuildingTask::getTaskQuantity,
                  MesBuildingTask::getProjectId,
                  MesBuildingTask::getWorkshopId,
                  MesBuildingTask::getCompleteQuantity
               )
         )
         .stream()
         .collect(Collectors.groupingBy(e -> e.getTaskTypeEnum() + "-" + e.getProjectId()));
      List<Long> partDrillHoleProcessIds = this.processService
         .list(
            (Wrapper<MesBuildingProcess>)(new LambdaQueryWrapper<MesBuildingProcess>().eq(MesBuildingProcess::getType, ProcessTypeEnum.DRILL_HOLE.getType()))
               .eq(MesBuildingProcess::getProductType, ProductTypeEnum.MACHINE_PART.getType())
         )
         .stream()
         .map(MesBuildingProcess::getId)
         .collect(Collectors.toList());
      Map<Long, List<MesBuildingTaskProcess>> mesTaskProcessProjectMap = this.taskProcessService
         .list(
            ((new LambdaQueryWrapper<MesBuildingTaskProcess>()
                     .notIn(CollectionUtils.isNotEmpty(partDrillHoleProcessIds), MesBuildingTaskProcess::getProcessId, partDrillHoleProcessIds))
                  .in(MesBuildingTaskProcess::getProjectId, projectIds))
               .select(
                  MesBuildingTaskProcess::getProjectId,
                  MesBuildingTaskProcess::getWorkshopId,
                  MesBuildingTaskProcess::getTaskTypeEnum,
                  MesBuildingTaskProcess::getProductId,
                  MesBuildingTaskProcess::getTaskQuantity,
                  MesBuildingTaskProcess::getInspectionQuantity,
                  MesBuildingTaskProcess::getCompleteQuantity,
                  MesBuildingTaskProcess::getProcessId,
                  MesBuildingTaskProcess::getSequence,
                  MesBuildingTaskProcess::getNeedQuantity
               )
         )
         .stream()
         .collect(Collectors.groupingBy(MesBuildingTaskProcess::getProjectId));
      Map<Long, BigDecimal> outboundMeteMap = this.reportService
         .getGroupByProjectOutboundMete()
         .stream()
         .collect(Collectors.toMap(IdAndMete::getId, IdAndMete::getMete));
      Map<Long, BigDecimal> returnMeteMap = this.reportService
         .getGroupByProjectReturnMete()
         .stream()
         .collect(Collectors.toMap(IdAndMete::getId, IdAndMete::getMete));
      return projects.stream()
         .map(
            project -> {
               BigDecimal totalArtifactNetWeight = BigDecimal.ZERO;
               BigDecimal totalArtifactTaskNetWeight = BigDecimal.ZERO;
               BigDecimal totalArtifactCompleteNetWeight = BigDecimal.ZERO;
               List<TechArtifact> artifacts = artifactProjectMap.get(project.getId());
               if (CollectionUtils.isNotEmpty(artifacts)) {
                  totalArtifactNetWeight = artifacts.stream()
                     .map(e -> e.getNetWeight().multiply(BigDecimal.valueOf(e.getQuantity().intValue())))
                     .reduce(BigDecimal.ZERO, BigDecimal::add)
                     .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
                  totalArtifactCompleteNetWeight = artifacts.stream()
                     .map(e -> e.getNetWeight().multiply(BigDecimal.valueOf(e.getProducedQuantity().intValue())))
                     .reduce(BigDecimal.ZERO, BigDecimal::add)
                     .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
               }

               List<MesBuildingTask> artifactTaskList = mesTaskProductTypeProjectMap.get(TaskTypeEnum.ARTIFACT.getType() + "-" + project.getId());
               if (CollectionUtils.isNotEmpty(artifactTaskList)) {
                  totalArtifactTaskNetWeight = artifactTaskList.stream()
                     .map(
                        e -> (artifactMap.get(e.getProductId()) == null ? BigDecimal.ZERO : artifactMap.get(e.getProductId()).getNetWeight())
                           .multiply(BigDecimal.valueOf(e.getTaskQuantity().intValue()))
                     )
                     .reduce(BigDecimal.ZERO, BigDecimal::add)
                     .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
               }

               ProjectLossWorkProgressStatisticsWastageDTO projectWastageDTO = ProjectLossWorkProgressStatisticsWastageDTO.builder()
                  .projectId(project.getId())
                  .name(project.getName())
                  .serialNumber(project.getSerialNumber())
                  .shortName(project.getShortName())
                  .totalArtifactNetWeight(totalArtifactNetWeight)
                  .totalArtifactTaskNetWeight(totalArtifactTaskNetWeight)
                  .totalArtifactCompleteNetWeight(totalArtifactCompleteNetWeight)
                  .build();
               List<MesBuildingTaskProcess> taskProcessList = mesTaskProcessProjectMap.get(project.getId());
               BigDecimal totalPickingWeight = outboundMeteMap.getOrDefault(project.getId(), BigDecimal.ZERO);
               BigDecimal totalFeedingWeight = totalPickingWeight.subtract(returnMeteMap.getOrDefault(project.getId(), BigDecimal.ZERO));
               boolean hasWeight = BigDecimal.ZERO.compareTo(totalPickingWeight) != 0 || BigDecimal.ZERO.compareTo(totalFeedingWeight) != 0;
               if (CollectionUtils.isNotEmpty(taskProcessList)) {
                  Map<Integer, List<MesBuildingTaskProcess>> taskTypeEnumTaskProcessMap = taskProcessList.stream()
                     .collect(Collectors.groupingBy(MesBuildingTaskProcess::getTaskTypeEnum));
                  if (!taskTypeEnumTaskProcessMap.containsKey(TaskTypeEnum.MACHINE_PART.getType()) && hasWeight) {
                     ProductProcessWorkProgressStatisticsDTO statisticsDTO = ProductProcessWorkProgressStatisticsDTO.builder()
                        .totalPickingWeight(totalPickingWeight)
                        .totalFeedingWeight(totalFeedingWeight)
                        .build();
                     projectWastageDTO.setPartProgressStatisticsDTO(statisticsDTO);
                  }

                  taskTypeEnumTaskProcessMap.forEach(
                     (taskTypeEnum, allTaskProcess) -> {
                        List<MesBuildingTask> tasks = mesTaskProductTypeProjectMap.get(taskTypeEnum + "-" + project.getId());
                        ProductProcessWorkProgressStatisticsDTO statisticsDTOx = ProductProcessWorkProgressStatisticsDTO.builder()
                           .totalPickingWeight(BigDecimal.ZERO)
                           .totalFeedingWeight(BigDecimal.ZERO)
                           .build();
                        List<ProductProcessWorkProgressStatisticsDetailDTO> progressStatisticsDetailDTOList = new ArrayList<>();
                        if (TaskTypeEnum.MACHINE_PART.getType().equals(taskTypeEnum)) {
                           BigDecimal totalTaskNetWeight = tasks.stream()
                              .map(
                                 e -> (machinePartMap.get(e.getProductId()) == null ? BigDecimal.ZERO : machinePartMap.get(e.getProductId()).getNetWeight())
                                    .multiply(BigDecimal.valueOf(e.getTaskQuantity().intValue()))
                              )
                              .reduce(BigDecimal.ZERO, BigDecimal::add)
                              .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
                           statisticsDTOx.setTotalSchedulingNetWeight(totalTaskNetWeight);
                           statisticsDTOx.setTotalFeedingWeight(totalFeedingWeight);
                           statisticsDTOx.setTotalPickingWeight(totalPickingWeight);
                           BigDecimal totalTaskProcessNetWeight = allTaskProcess.stream()
                              .map(
                                 e -> (machinePartMap.get(e.getProductId()) == null ? BigDecimal.ZERO : machinePartMap.get(e.getProductId()).getNetWeight())
                                    .multiply(BigDecimal.valueOf(e.getTaskQuantity().intValue()))
                              )
                              .reduce(BigDecimal.ZERO, BigDecimal::add)
                              .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
                           BigDecimal totalCompleteNetWeight = allTaskProcess.stream()
                              .map(
                                 e -> (machinePartMap.get(e.getProductId()) == null ? BigDecimal.ZERO : machinePartMap.get(e.getProductId()).getNetWeight())
                                    .multiply(BigDecimal.valueOf(e.getInspectionQuantity().intValue()))
                              )
                              .reduce(BigDecimal.ZERO, BigDecimal::add)
                              .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
                           ProductProcessWorkProgressStatisticsDetailDTO progressStatisticsDetailDTO = ProductProcessWorkProgressStatisticsDetailDTO.builder()
                              .processId(0L)
                              .totalTaskNetWeight(totalTaskProcessNetWeight)
                              .totalCompleteNetWeight(totalCompleteNetWeight)
                              .totalInProductionNetWeight(totalTaskProcessNetWeight.subtract(totalCompleteNetWeight))
                              .build();
                           if (lossCalculationFormula.equals(RawMaterialLossEnum.FORMULA_ONE.getType())) {
                              progressStatisticsDetailDTO.setTotalLossWeight(
                                 statisticsDTOx.getTotalFeedingWeight().compareTo(BigDecimal.ZERO) == 0
                                    ? BigDecimal.ZERO
                                    : statisticsDTOx.getTotalFeedingWeight().subtract(progressStatisticsDetailDTO.getTotalCompleteNetWeight())
                              );
                              progressStatisticsDetailDTO.setTotalLossRate(
                                 statisticsDTOx.getTotalFeedingWeight().compareTo(BigDecimal.ZERO) == 0
                                    ? "-"
                                    : String.valueOf(
                                       progressStatisticsDetailDTO.getTotalLossWeight()
                                          .divide(statisticsDTOx.getTotalFeedingWeight(), 3, RoundingMode.HALF_UP)
                                          .multiply(BigDecimal.valueOf(100L))
                                    )
                              );
                           }

                           if (lossCalculationFormula.equals(RawMaterialLossEnum.FORMULA_TWO.getType())) {
                              progressStatisticsDetailDTO.setTotalLossWeight(
                                 statisticsDTOx.getTotalPickingWeight().compareTo(BigDecimal.ZERO) == 0
                                    ? BigDecimal.ZERO
                                    : statisticsDTOx.getTotalPickingWeight().subtract(progressStatisticsDetailDTO.getTotalCompleteNetWeight())
                              );
                              progressStatisticsDetailDTO.setTotalLossRate(
                                 statisticsDTOx.getTotalPickingWeight().compareTo(BigDecimal.ZERO) == 0
                                    ? "-"
                                    : String.valueOf(
                                       progressStatisticsDetailDTO.getTotalLossWeight()
                                          .divide(statisticsDTOx.getTotalPickingWeight(), 3, RoundingMode.HALF_UP)
                                          .multiply(BigDecimal.valueOf(100L))
                                    )
                              );
                           }

                           progressStatisticsDetailDTOList.add(progressStatisticsDetailDTO);
                           statisticsDTOx.setStatisticsDetailDTOS(progressStatisticsDetailDTOList);
                           projectWastageDTO.setPartProgressStatisticsDTO(statisticsDTOx);
                        }

                        if (TaskTypeEnum.ARTIFACT.getType().equals(taskTypeEnum)) {
                           BigDecimal totalTaskNetWeight = tasks.stream()
                              .map(
                                 e -> (artifactMap.get(e.getProductId()) == null ? BigDecimal.ZERO : artifactMap.get(e.getProductId()).getNetWeight())
                                    .multiply(BigDecimal.valueOf(e.getTaskQuantity().intValue()))
                              )
                              .reduce(BigDecimal.ZERO, BigDecimal::add)
                              .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
                           statisticsDTOx.setTotalSchedulingNetWeight(totalTaskNetWeight);
                           Map<Long, List<MesBuildingTaskProcess>> processTaskProcessMap = allTaskProcess.stream()
                              .collect(Collectors.groupingBy(MesBuildingTaskProcess::getProcessId));
                           processTaskProcessMap.forEach(
                              (processId, processtaskProcessList) -> {
                                 BigDecimal totalTaskProcessNetWeight = processtaskProcessList.stream()
                                    .map(
                                       e -> (artifactMap.get(e.getProductId()) == null ? BigDecimal.ZERO : artifactMap.get(e.getProductId()).getNetWeight())
                                          .multiply(BigDecimal.valueOf(e.getTaskQuantity().intValue()))
                                    )
                                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                                    .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
                                 BigDecimal totalCompleteNetWeightx = processtaskProcessList.stream()
                                    .map(
                                       e -> (artifactMap.get(e.getProductId()) == null ? BigDecimal.ZERO : artifactMap.get(e.getProductId()).getNetWeight())
                                          .multiply(BigDecimal.valueOf(e.getInspectionQuantity().intValue()))
                                    )
                                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                                    .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
                                 BigDecimal totalTaskNeedProcessNetWeight = processtaskProcessList.stream()
                                    .filter(e -> e.getSequence() != 0)
                                    .map(
                                       e -> (artifactMap.get(e.getProductId()) == null ? BigDecimal.ZERO : artifactMap.get(e.getProductId()).getNetWeight())
                                          .multiply(BigDecimal.valueOf(e.getNeedQuantity().intValue()))
                                    )
                                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                                    .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
                                 BigDecimal totalTaskNeedAndCompleteProcessNetWeight = processtaskProcessList.stream()
                                    .filter(e -> e.getSequence() != 0)
                                    .map(
                                       e -> (artifactMap.get(e.getProductId()) == null ? BigDecimal.ZERO : artifactMap.get(e.getProductId()).getNetWeight())
                                          .multiply(BigDecimal.valueOf(e.getInspectionQuantity().intValue()))
                                    )
                                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                                    .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
                                 ProductProcessWorkProgressStatisticsDetailDTO progressStatisticsDetailDTOx = ProductProcessWorkProgressStatisticsDetailDTO.builder()
                                    .processId(processId)
                                    .totalTaskNetWeight(totalTaskProcessNetWeight)
                                    .totalCompleteNetWeight(totalCompleteNetWeightx)
                                    .totalInProductionNetWeight(totalTaskNeedProcessNetWeight.subtract(totalTaskNeedAndCompleteProcessNetWeight))
                                    .build();
                                 progressStatisticsDetailDTOList.add(progressStatisticsDetailDTOx);
                              }
                           );
                           statisticsDTOx.setStatisticsDetailDTOS(progressStatisticsDetailDTOList);
                           projectWastageDTO.setArtifactProgressStatisticsDTO(statisticsDTOx);
                        }

                        if (TaskTypeEnum.ASSEMBLE.getType().equals(taskTypeEnum)) {
                           BigDecimal totalTaskNetWeight = tasks.stream()
                              .map(
                                 e -> (assembleMap.get(e.getProductId()) == null ? BigDecimal.ZERO : assembleMap.get(e.getProductId()).getNetWeight())
                                    .multiply(BigDecimal.valueOf(e.getTaskQuantity().intValue()))
                              )
                              .reduce(BigDecimal.ZERO, BigDecimal::add)
                              .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
                           statisticsDTOx.setTotalSchedulingNetWeight(totalTaskNetWeight);
                           Map<Long, List<MesBuildingTaskProcess>> processTaskProcessMap = allTaskProcess.stream()
                              .collect(Collectors.groupingBy(MesBuildingTaskProcess::getProcessId));
                           processTaskProcessMap.forEach(
                              (processId, processtaskProcessList) -> {
                                 BigDecimal totalTaskProcessNetWeight = processtaskProcessList.stream()
                                    .map(
                                       e -> (assembleMap.get(e.getProductId()) == null ? BigDecimal.ZERO : assembleMap.get(e.getProductId()).getNetWeight())
                                          .multiply(BigDecimal.valueOf(e.getTaskQuantity().intValue()))
                                    )
                                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                                    .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
                                 BigDecimal totalCompleteNetWeightx = processtaskProcessList.stream()
                                    .map(
                                       e -> (assembleMap.get(e.getProductId()) == null ? BigDecimal.ZERO : assembleMap.get(e.getProductId()).getNetWeight())
                                          .multiply(BigDecimal.valueOf(e.getInspectionQuantity().intValue()))
                                    )
                                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                                    .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
                                 BigDecimal totalTaskNeedProcessNetWeight = processtaskProcessList.stream()
                                    .filter(e -> e.getSequence() != 0)
                                    .map(
                                       e -> (artifactMap.get(e.getProductId()) == null ? BigDecimal.ZERO : artifactMap.get(e.getProductId()).getNetWeight())
                                          .multiply(BigDecimal.valueOf(e.getNeedQuantity().intValue()))
                                    )
                                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                                    .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
                                 BigDecimal totalTaskNeedAndCompleteProcessNetWeight = processtaskProcessList.stream()
                                    .filter(e -> e.getSequence() != 0)
                                    .map(
                                       e -> (artifactMap.get(e.getProductId()) == null ? BigDecimal.ZERO : artifactMap.get(e.getProductId()).getNetWeight())
                                          .multiply(BigDecimal.valueOf(e.getInspectionQuantity().intValue()))
                                    )
                                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                                    .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
                                 ProductProcessWorkProgressStatisticsDetailDTO progressStatisticsDetailDTOx = ProductProcessWorkProgressStatisticsDetailDTO.builder()
                                    .processId(processId)
                                    .totalTaskNetWeight(totalTaskProcessNetWeight)
                                    .totalCompleteNetWeight(totalCompleteNetWeightx)
                                    .totalInProductionNetWeight(totalTaskNeedProcessNetWeight.subtract(totalTaskNeedAndCompleteProcessNetWeight))
                                    .build();
                                 progressStatisticsDetailDTOList.add(progressStatisticsDetailDTOx);
                              }
                           );
                           statisticsDTOx.setStatisticsDetailDTOS(progressStatisticsDetailDTOList);
                           projectWastageDTO.setAssembleProgressStatisticsDTO(statisticsDTOx);
                        }
                     }
                  );
               } else if (hasWeight) {
                  ProductProcessWorkProgressStatisticsDTO statisticsDTO = ProductProcessWorkProgressStatisticsDTO.builder()
                     .totalPickingWeight(totalPickingWeight)
                     .totalFeedingWeight(totalFeedingWeight)
                     .build();
                  projectWastageDTO.setPartProgressStatisticsDTO(statisticsDTO);
               }

               return projectWastageDTO;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public List<ProjectLossWorkProgressStatisticsWastageDTO> getWastageDtoByWorkShop(List<Long> workShopIds, Integer lossCalculationFormula) {
      List<MesBuildingWorkshop> workshopList = CollectionUtils.isEmpty(workShopIds)
         ? this.workshopService.list((Wrapper<MesBuildingWorkshop>)new LambdaQueryWrapper<MesBuildingWorkshop>().ne(MesBuildingWorkshop::getType, 2))
         : this.workshopService.listByIds(workShopIds);
      if (CollectionUtils.isEmpty(workshopList)) {
         return new ArrayList<>();
      }

      workShopIds = workshopList.stream().map(MesBuildingWorkshop::getId).collect(Collectors.toList());
      List<TechArtifact> allArtifactList = this.artifactService
         .list(
            new LambdaQueryWrapper<TechArtifact>()
               .select(
                  TechArtifact::getId, TechArtifact::getProjectId, TechArtifact::getQuantity, TechArtifact::getNetWeight, TechArtifact::getProducedQuantity
               )
         );
      List<TechAssemble> allAssembleList = this.assembleService
         .list(
            new LambdaQueryWrapper<TechAssemble>()
               .select(
                  TechAssemble::getId,
                  TechAssemble::getProjectId,
                  TechAssemble::getQuantity,
                  TechAssemble::getNetWeight,
                  TechAssemble::getGrossWeight,
                  TechAssemble::getProducedQuantity
               )
         );
      List<TechMachinePart> machinePartList = this.machinePartService
         .list(
            new LambdaQueryWrapper<TechMachinePart>()
               .select(
                  TechMachinePart::getId,
                  TechMachinePart::getProjectId,
                  TechMachinePart::getQuantity,
                  TechMachinePart::getNetWeight,
                  TechMachinePart::getGrossWeight,
                  TechMachinePart::getProducedQuantity
               )
         );
      Map<Long, TechArtifact> artifactMap = allArtifactList.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      Map<Long, TechAssemble> assembleMap = allAssembleList.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
      Map<Long, TechMachinePart> machinePartMap = machinePartList.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
      Map<String, List<MesBuildingTask>> mesProcuctTypeTaskWorkShopMap = this.taskService
         .list(
            (new LambdaQueryWrapper<MesBuildingTask>().in(MesBuildingTask::getWorkshopId, workShopIds))
               .select(
                  MesBuildingTask::getTaskTypeEnum,
                  MesBuildingTask::getProductId,
                  MesBuildingTask::getTaskQuantity,
                  MesBuildingTask::getProjectId,
                  MesBuildingTask::getWorkshopId,
                  MesBuildingTask::getCompleteQuantity
               )
         )
         .stream()
         .collect(Collectors.groupingBy(e -> e.getTaskTypeEnum() + "-" + e.getWorkshopId()));
      List<Long> partDrillHoleProcessIds = this.processService
         .list(
            (Wrapper<MesBuildingProcess>)(new LambdaQueryWrapper<MesBuildingProcess>().eq(MesBuildingProcess::getType, ProcessTypeEnum.DRILL_HOLE.getType()))
               .eq(MesBuildingProcess::getProductType, ProductTypeEnum.MACHINE_PART.getType())
         )
         .stream()
         .map(MesBuildingProcess::getId)
         .collect(Collectors.toList());
      Map<Long, List<MesBuildingTaskProcess>> mesTaskProcessWorkShopMap = this.taskProcessService
         .list(
            ((new LambdaQueryWrapper<MesBuildingTaskProcess>()
                     .notIn(CollectionUtils.isNotEmpty(partDrillHoleProcessIds), MesBuildingTaskProcess::getProcessId, partDrillHoleProcessIds))
                  .in(MesBuildingTaskProcess::getWorkshopId, workShopIds))
               .select(
                  MesBuildingTaskProcess::getProjectId,
                  MesBuildingTaskProcess::getWorkshopId,
                  MesBuildingTaskProcess::getTaskTypeEnum,
                  MesBuildingTaskProcess::getProductId,
                  MesBuildingTaskProcess::getTaskQuantity,
                  MesBuildingTaskProcess::getInspectionQuantity,
                  MesBuildingTaskProcess::getCompleteQuantity,
                  MesBuildingTaskProcess::getProcessId,
                  MesBuildingTaskProcess::getSequence,
                  MesBuildingTaskProcess::getNeedQuantity
               )
         )
         .stream()
         .collect(Collectors.groupingBy(MesBuildingTaskProcess::getWorkshopId));
      Map<Long, BigDecimal> outboundMeteMap = this.reportService
         .getGroupByMesWorkshopOutboundMete()
         .stream()
         .collect(Collectors.toMap(IdAndMete::getId, IdAndMete::getMete));
      Map<Long, BigDecimal> returnMeteMap = this.reportService
         .getGroupByMesWorkshopReturnMete()
         .stream()
         .collect(Collectors.toMap(IdAndMete::getId, IdAndMete::getMete));
      return workshopList.stream()
         .map(
            workshop -> {
               BigDecimal totalArtifactTaskNetWeight = BigDecimal.ZERO;
               BigDecimal totalArtifactCompleteNetWeight = BigDecimal.ZERO;
               List<MesBuildingTask> artifactTaskList = mesProcuctTypeTaskWorkShopMap.get(TaskTypeEnum.ARTIFACT.getType() + "-" + workshop.getId());
               if (CollectionUtils.isNotEmpty(artifactTaskList)) {
                  totalArtifactTaskNetWeight = artifactTaskList.stream()
                     .map(
                        e -> (artifactMap.get(e.getProductId()) == null ? BigDecimal.ZERO : artifactMap.get(e.getProductId()).getNetWeight())
                           .multiply(BigDecimal.valueOf(e.getTaskQuantity().intValue()))
                     )
                     .reduce(BigDecimal.ZERO, BigDecimal::add)
                     .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
                  totalArtifactCompleteNetWeight = artifactTaskList.stream()
                     .map(
                        e -> artifactMap.get(e.getProductId()) == null
                           ? BigDecimal.ZERO
                           : artifactMap.get(e.getProductId()).getNetWeight().multiply(BigDecimal.valueOf(e.getCompleteQuantity().intValue()))
                     )
                     .reduce(BigDecimal.ZERO, BigDecimal::add)
                     .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
               }

               ProjectLossWorkProgressStatisticsWastageDTO projectWastageDTO = ProjectLossWorkProgressStatisticsWastageDTO.builder()
                  .workShopId(workshop.getId())
                  .name(workshop.getName())
                  .totalArtifactTaskNetWeight(totalArtifactTaskNetWeight)
                  .totalArtifactCompleteNetWeight(totalArtifactCompleteNetWeight)
                  .build();
               List<MesBuildingTaskProcess> taskProcessList = mesTaskProcessWorkShopMap.get(workshop.getId());
               BigDecimal totalPickingWeight = outboundMeteMap.getOrDefault(workshop.getId(), BigDecimal.ZERO);
               BigDecimal totalFeedingWeight = totalPickingWeight.subtract(returnMeteMap.getOrDefault(workshop.getId(), BigDecimal.ZERO));
               boolean hasWeight = BigDecimal.ZERO.compareTo(totalPickingWeight) != 0 || BigDecimal.ZERO.compareTo(totalFeedingWeight) != 0;
               if (CollectionUtils.isNotEmpty(taskProcessList)) {
                  Map<Integer, List<MesBuildingTaskProcess>> taskTypeEnumTaskProcessMap = taskProcessList.stream()
                     .collect(Collectors.groupingBy(MesBuildingTaskProcess::getTaskTypeEnum));
                  if (!taskTypeEnumTaskProcessMap.containsKey(TaskTypeEnum.MACHINE_PART.getType()) && hasWeight) {
                     ProductProcessWorkProgressStatisticsDTO statisticsDTO = ProductProcessWorkProgressStatisticsDTO.builder()
                        .totalPickingWeight(totalPickingWeight)
                        .totalFeedingWeight(totalFeedingWeight)
                        .build();
                     projectWastageDTO.setPartProgressStatisticsDTO(statisticsDTO);
                  }

                  taskTypeEnumTaskProcessMap.forEach(
                     (taskTypeEnum, allTaskProcess) -> {
                        List<MesBuildingTask> tasks = mesProcuctTypeTaskWorkShopMap.get(taskTypeEnum + "-" + workshop.getId());
                        ProductProcessWorkProgressStatisticsDTO statisticsDTOx = ProductProcessWorkProgressStatisticsDTO.builder()
                           .totalPickingWeight(BigDecimal.ZERO)
                           .totalFeedingWeight(BigDecimal.ZERO)
                           .build();
                        List<ProductProcessWorkProgressStatisticsDetailDTO> progressStatisticsDetailDTOList = new ArrayList<>();
                        if (TaskTypeEnum.MACHINE_PART.getType().equals(taskTypeEnum)) {
                           BigDecimal totalTaskNetWeight = tasks.stream()
                              .map(
                                 e -> (machinePartMap.get(e.getProductId()) == null ? BigDecimal.ZERO : machinePartMap.get(e.getProductId()).getNetWeight())
                                    .multiply(BigDecimal.valueOf(e.getTaskQuantity().intValue()))
                              )
                              .reduce(BigDecimal.ZERO, BigDecimal::add)
                              .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
                           statisticsDTOx.setTotalSchedulingNetWeight(totalTaskNetWeight);
                           statisticsDTOx.setTotalFeedingWeight(totalFeedingWeight);
                           statisticsDTOx.setTotalPickingWeight(totalPickingWeight);
                           BigDecimal totalTaskProcessNetWeight = allTaskProcess.stream()
                              .map(
                                 e -> (machinePartMap.get(e.getProductId()) == null ? BigDecimal.ZERO : machinePartMap.get(e.getProductId()).getNetWeight())
                                    .multiply(BigDecimal.valueOf(e.getTaskQuantity().intValue()))
                              )
                              .reduce(BigDecimal.ZERO, BigDecimal::add)
                              .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
                           BigDecimal totalCompleteNetWeight = allTaskProcess.stream()
                              .map(
                                 e -> (machinePartMap.get(e.getProductId()) == null ? BigDecimal.ZERO : machinePartMap.get(e.getProductId()).getNetWeight())
                                    .multiply(BigDecimal.valueOf(e.getInspectionQuantity().intValue()))
                              )
                              .reduce(BigDecimal.ZERO, BigDecimal::add)
                              .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
                           ProductProcessWorkProgressStatisticsDetailDTO progressStatisticsDetailDTO = ProductProcessWorkProgressStatisticsDetailDTO.builder()
                              .processId(0L)
                              .totalTaskNetWeight(totalTaskProcessNetWeight)
                              .totalCompleteNetWeight(totalCompleteNetWeight)
                              .totalInProductionNetWeight(totalTaskProcessNetWeight.subtract(totalCompleteNetWeight))
                              .build();
                           if (lossCalculationFormula.equals(RawMaterialLossEnum.FORMULA_ONE.getType())) {
                              progressStatisticsDetailDTO.setTotalLossWeight(
                                 statisticsDTOx.getTotalFeedingWeight().compareTo(BigDecimal.ZERO) == 0
                                    ? BigDecimal.ZERO
                                    : statisticsDTOx.getTotalFeedingWeight().subtract(progressStatisticsDetailDTO.getTotalCompleteNetWeight())
                              );
                              progressStatisticsDetailDTO.setTotalLossRate(
                                 statisticsDTOx.getTotalFeedingWeight().compareTo(BigDecimal.ZERO) == 0
                                    ? "-"
                                    : String.valueOf(
                                       progressStatisticsDetailDTO.getTotalLossWeight()
                                          .divide(statisticsDTOx.getTotalFeedingWeight(), 3, RoundingMode.HALF_UP)
                                          .multiply(BigDecimal.valueOf(100L))
                                    )
                              );
                           }

                           if (lossCalculationFormula.equals(RawMaterialLossEnum.FORMULA_TWO.getType())) {
                              progressStatisticsDetailDTO.setTotalLossWeight(
                                 statisticsDTOx.getTotalPickingWeight().compareTo(BigDecimal.ZERO) == 0
                                    ? BigDecimal.ZERO
                                    : statisticsDTOx.getTotalPickingWeight().subtract(progressStatisticsDetailDTO.getTotalCompleteNetWeight())
                              );
                              progressStatisticsDetailDTO.setTotalLossRate(
                                 statisticsDTOx.getTotalPickingWeight().compareTo(BigDecimal.ZERO) == 0
                                    ? "-"
                                    : String.valueOf(
                                       progressStatisticsDetailDTO.getTotalLossWeight()
                                          .divide(statisticsDTOx.getTotalPickingWeight(), 3, RoundingMode.HALF_UP)
                                          .multiply(BigDecimal.valueOf(100L))
                                    )
                              );
                           }

                           progressStatisticsDetailDTOList.add(progressStatisticsDetailDTO);
                           statisticsDTOx.setStatisticsDetailDTOS(progressStatisticsDetailDTOList);
                           projectWastageDTO.setPartProgressStatisticsDTO(statisticsDTOx);
                        }

                        if (TaskTypeEnum.ARTIFACT.getType().equals(taskTypeEnum)) {
                           BigDecimal totalTaskNetWeight = tasks.stream()
                              .map(
                                 e -> (artifactMap.get(e.getProductId()) == null ? BigDecimal.ZERO : artifactMap.get(e.getProductId()).getNetWeight())
                                    .multiply(BigDecimal.valueOf(e.getTaskQuantity().intValue()))
                              )
                              .reduce(BigDecimal.ZERO, BigDecimal::add)
                              .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
                           statisticsDTOx.setTotalSchedulingNetWeight(totalTaskNetWeight);
                           Map<Long, List<MesBuildingTaskProcess>> processTaskProcessMap = allTaskProcess.stream()
                              .collect(Collectors.groupingBy(MesBuildingTaskProcess::getProcessId));
                           processTaskProcessMap.forEach(
                              (processId, processtaskProcessList) -> {
                                 BigDecimal totalTaskProcessNetWeight = processtaskProcessList.stream()
                                    .map(
                                       e -> (artifactMap.get(e.getProductId()) == null ? BigDecimal.ZERO : artifactMap.get(e.getProductId()).getNetWeight())
                                          .multiply(BigDecimal.valueOf(e.getTaskQuantity().intValue()))
                                    )
                                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                                    .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
                                 BigDecimal totalCompleteNetWeightx = processtaskProcessList.stream()
                                    .map(
                                       e -> (artifactMap.get(e.getProductId()) == null ? BigDecimal.ZERO : artifactMap.get(e.getProductId()).getNetWeight())
                                          .multiply(BigDecimal.valueOf(e.getInspectionQuantity().intValue()))
                                    )
                                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                                    .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
                                 BigDecimal totalTaskNeedProcessNetWeight = processtaskProcessList.stream()
                                    .filter(e -> e.getSequence() != 0)
                                    .map(
                                       e -> (artifactMap.get(e.getProductId()) == null ? BigDecimal.ZERO : artifactMap.get(e.getProductId()).getNetWeight())
                                          .multiply(BigDecimal.valueOf(e.getNeedQuantity().intValue()))
                                    )
                                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                                    .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
                                 BigDecimal totalTaskNeedAndCompleteProcessNetWeight = processtaskProcessList.stream()
                                    .filter(e -> e.getSequence() != 0)
                                    .map(
                                       e -> (artifactMap.get(e.getProductId()) == null ? BigDecimal.ZERO : artifactMap.get(e.getProductId()).getNetWeight())
                                          .multiply(BigDecimal.valueOf(e.getInspectionQuantity().intValue()))
                                    )
                                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                                    .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
                                 ProductProcessWorkProgressStatisticsDetailDTO progressStatisticsDetailDTOx = ProductProcessWorkProgressStatisticsDetailDTO.builder()
                                    .processId(processId)
                                    .totalTaskNetWeight(totalTaskProcessNetWeight)
                                    .totalCompleteNetWeight(totalCompleteNetWeightx)
                                    .totalInProductionNetWeight(totalTaskNeedProcessNetWeight.subtract(totalTaskNeedAndCompleteProcessNetWeight))
                                    .build();
                                 progressStatisticsDetailDTOList.add(progressStatisticsDetailDTOx);
                              }
                           );
                           statisticsDTOx.setStatisticsDetailDTOS(progressStatisticsDetailDTOList);
                           projectWastageDTO.setArtifactProgressStatisticsDTO(statisticsDTOx);
                        }

                        if (TaskTypeEnum.ASSEMBLE.getType().equals(taskTypeEnum)) {
                           BigDecimal totalTaskNetWeight = tasks.stream()
                              .map(
                                 e -> (assembleMap.get(e.getProductId()) == null ? BigDecimal.ZERO : assembleMap.get(e.getProductId()).getNetWeight())
                                    .multiply(BigDecimal.valueOf(e.getTaskQuantity().intValue()))
                              )
                              .reduce(BigDecimal.ZERO, BigDecimal::add)
                              .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
                           statisticsDTOx.setTotalSchedulingNetWeight(totalTaskNetWeight);
                           Map<Long, List<MesBuildingTaskProcess>> processTaskProcessMap = allTaskProcess.stream()
                              .collect(Collectors.groupingBy(MesBuildingTaskProcess::getProcessId));
                           processTaskProcessMap.forEach(
                              (processId, processtaskProcessList) -> {
                                 BigDecimal totalTaskProcessNetWeight = processtaskProcessList.stream()
                                    .map(
                                       e -> (assembleMap.get(e.getProductId()) == null ? BigDecimal.ZERO : assembleMap.get(e.getProductId()).getNetWeight())
                                          .multiply(BigDecimal.valueOf(e.getTaskQuantity().intValue()))
                                    )
                                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                                    .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
                                 BigDecimal totalCompleteNetWeightx = processtaskProcessList.stream()
                                    .map(
                                       e -> (assembleMap.get(e.getProductId()) == null ? BigDecimal.ZERO : assembleMap.get(e.getProductId()).getNetWeight())
                                          .multiply(BigDecimal.valueOf(e.getInspectionQuantity().intValue()))
                                    )
                                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                                    .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
                                 BigDecimal totalTaskNeedProcessNetWeight = processtaskProcessList.stream()
                                    .filter(e -> e.getSequence() != 0)
                                    .map(
                                       e -> (artifactMap.get(e.getProductId()) == null ? BigDecimal.ZERO : artifactMap.get(e.getProductId()).getNetWeight())
                                          .multiply(BigDecimal.valueOf(e.getNeedQuantity().intValue()))
                                    )
                                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                                    .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
                                 BigDecimal totalTaskNeedAndCompleteProcessNetWeight = processtaskProcessList.stream()
                                    .filter(e -> e.getSequence() != 0)
                                    .map(
                                       e -> (artifactMap.get(e.getProductId()) == null ? BigDecimal.ZERO : artifactMap.get(e.getProductId()).getNetWeight())
                                          .multiply(BigDecimal.valueOf(e.getInspectionQuantity().intValue()))
                                    )
                                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                                    .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
                                 ProductProcessWorkProgressStatisticsDetailDTO progressStatisticsDetailDTOx = ProductProcessWorkProgressStatisticsDetailDTO.builder()
                                    .processId(processId)
                                    .totalTaskNetWeight(totalTaskProcessNetWeight)
                                    .totalCompleteNetWeight(totalCompleteNetWeightx)
                                    .totalInProductionNetWeight(totalTaskNeedProcessNetWeight.subtract(totalTaskNeedAndCompleteProcessNetWeight))
                                    .build();
                                 progressStatisticsDetailDTOList.add(progressStatisticsDetailDTOx);
                              }
                           );
                           statisticsDTOx.setStatisticsDetailDTOS(progressStatisticsDetailDTOList);
                           projectWastageDTO.setArtifactProgressStatisticsDTO(statisticsDTOx);
                           statisticsDTOx.setStatisticsDetailDTOS(progressStatisticsDetailDTOList);
                           projectWastageDTO.setAssembleProgressStatisticsDTO(statisticsDTOx);
                        }
                     }
                  );
               } else if (hasWeight) {
                  ProductProcessWorkProgressStatisticsDTO statisticsDTO = ProductProcessWorkProgressStatisticsDTO.builder()
                     .totalPickingWeight(totalPickingWeight)
                     .totalFeedingWeight(totalFeedingWeight)
                     .build();
                  projectWastageDTO.setPartProgressStatisticsDTO(statisticsDTO);
               }

               return projectWastageDTO;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public List<ProjectLossProcessProductionKanBanDTO> projectSignageProcessList() {
      List<Long> processIds = this.teamService.list().stream().map(MesBuildingTeam::getProcessId).distinct().collect(Collectors.toList());
      if (CollectionUtils.isEmpty(processIds)) {
         return new ArrayList<>();
      }

      List<MesBuildingProcess> processList = this.processService
         .list(
            (Wrapper<MesBuildingProcess>)(new LambdaQueryWrapper<MesBuildingProcess>()
                  .in(MesBuildingProcess::getProductType, ProductTypeEnum.ASSEMBLE.getType(), ProductTypeEnum.ARTIFACT.getType()))
               .in(MesBuildingProcess::getId, processIds)
         );
      List<ProjectLossProcessProductionKanBanDTO> productionKanBanDTOS = BeanUtil.copyToList(processList, ProjectLossProcessProductionKanBanDTO.class);
      ProjectLossProcessProductionKanBanDTO kanBanDTO = ProjectLossProcessProductionKanBanDTO.builder()
         .id(0L)
         .productType(ProductTypeEnum.MACHINE_PART.getType())
         .name("下料")
         .sort(0)
         .build();
      productionKanBanDTOS.add(kanBanDTO);
      return productionKanBanDTOS.stream().sorted(Comparator.comparing(ProjectLossProcessProductionKanBanDTO::getSort)).collect(Collectors.toList());
   }

   @Override
   public List<WastageLossCostSummaryDTO> wastageLossCostSummary(
      Integer year, Long projectId, Long workShopId, Integer projectOrWorkShopEnum, Boolean boolDownload
   ) {
      Integer lossCalculationFormula = this.configService.getRawMaterialLossCalculationFormula();
      Util.checkArgument(lossCalculationFormula != null && RawMaterialLossEnum.isExist(lossCalculationFormula), "查询失败,原料损耗公式不存在!");
      List<WastageLossCostSummaryDTO> costSummaryDTOS = Lists.newArrayList();
      if (ProjectOrWorkShopEnum.PROJECT.getType().equals(projectOrWorkShopEnum)) {
         if (boolDownload) {
            this.getWastageLossCostSummaryByproject(projectId, costSummaryDTOS, lossCalculationFormula);
         } else {
            Object redisDateObject = this.redisUtils.get("project_wastagedtoby_detail_key" + projectId);
            if (redisDateObject == null) {
               this.getWastageLossCostSummaryByproject(projectId, costSummaryDTOS, lossCalculationFormula);
            } else {
               try {
                  costSummaryDTOS = objectMapper.readValue(
                     redisDateObject.toString(), objectMapper.getTypeFactory().constructCollectionType(List.class, WastageLossCostSummaryDTO.class)
                  );
               } catch (JsonProcessingException e) {
                  throw new RuntimeException(e);
               }
            }
         }
      }

      if (ProjectOrWorkShopEnum.WORKSHOP.getType().equals(projectOrWorkShopEnum)) {
         year = year == null ? YearMonth.now().getYear() : year;
         if (boolDownload) {
            this.getWastageLossCostSummaryByWorkShop(year, workShopId, costSummaryDTOS, lossCalculationFormula);
         } else {
            Object redisDateObject = this.redisUtils.get("workshop_wastagedtoby_deail_key" + workShopId + year);
            if (redisDateObject == null) {
               this.getWastageLossCostSummaryByWorkShop(year, workShopId, costSummaryDTOS, lossCalculationFormula);
            } else {
               try {
                  costSummaryDTOS = objectMapper.readValue(
                     redisDateObject.toString(), objectMapper.getTypeFactory().constructCollectionType(List.class, WastageLossCostSummaryDTO.class)
                  );
               } catch (JsonProcessingException e) {
                  throw new RuntimeException(e);
               }
            }
         }
      }

      return costSummaryDTOS;
   }

   @Override
   public List<ProductWastageLossCostMesDetailDTO> wastageLossCostMesDetail(
      List<LocalDateTime> dateTimeList,
      Long projectId,
      Long workShopId,
      Integer taskTypeEnum,
      Integer processId,
      String serialNumber,
      Long groupId,
      Long productionLineId,
      Integer relationType,
      Integer projectOrWorkShopEnum,
      Integer lossWorkProgressStatisticsEnum
   ) {
      List<ProductWastageLossCostMesDetailDTO> taskCompleteWastageLossCostDetailList = new ArrayList<>();
      if (TaskTypeEnum.MACHINE_PART.getType().equals(taskTypeEnum)) {
         if (MesLossWorkProgressStatisticsEnum.PARTS_ALLOCATION.getType() == lossWorkProgressStatisticsEnum) {
            List<Integer> relationTypeList = relationType == null
               ? Arrays.asList(MachinePartRelationTypeEnum.FOR_ARTIFACT.getType(), MachinePartRelationTypeEnum.FOR_ASSEMBLE.getType())
               : Arrays.asList(relationType);
            taskCompleteWastageLossCostDetailList = this.taskService
               .getPartsAllocationDetailList(
                  dateTimeList, projectId, workShopId, taskTypeEnum, processId, serialNumber, groupId, productionLineId, relationType, relationTypeList
               );
         }

         if (MesLossWorkProgressStatisticsEnum.SCHEDULING.getType() == lossWorkProgressStatisticsEnum) {
            taskCompleteWastageLossCostDetailList = this.taskService
               .getTaskProductSchedulingDetailList(
                  dateTimeList, projectId, workShopId, taskTypeEnum, processId, serialNumber, groupId, productionLineId, relationType
               );
         }

         if (MesLossWorkProgressStatisticsEnum.IN_PRODUCTION.getType() == lossWorkProgressStatisticsEnum) {
            taskCompleteWastageLossCostDetailList = this.taskService
               .getTaskPendingProductsWastageLossCostDetailList(
                  dateTimeList, projectId, workShopId, taskTypeEnum, processId, serialNumber, groupId, productionLineId, relationType
               );
         }

         if (MesLossWorkProgressStatisticsEnum.FINISHED.getType() == lossWorkProgressStatisticsEnum) {
            taskCompleteWastageLossCostDetailList = this.taskService
               .getTaskCompleteWastageLossCostDetailList(
                  dateTimeList, projectId, workShopId, taskTypeEnum, processId, serialNumber, groupId, productionLineId, relationType
               );
         }
      }

      if (TaskTypeEnum.ASSEMBLE.getType().equals(taskTypeEnum)) {
         if (MesLossWorkProgressStatisticsEnum.SCHEDULING.getType() == lossWorkProgressStatisticsEnum) {
            taskCompleteWastageLossCostDetailList = this.taskService
               .getTaskProductSchedulingDetailList(
                  dateTimeList, projectId, workShopId, taskTypeEnum, processId, serialNumber, groupId, productionLineId, relationType
               );
         }

         if (MesLossWorkProgressStatisticsEnum.IN_PRODUCTION.getType() == lossWorkProgressStatisticsEnum) {
            taskCompleteWastageLossCostDetailList = this.taskService
               .getTaskPendingProductsWastageLossCostDetailList(
                  dateTimeList, projectId, workShopId, taskTypeEnum, processId, serialNumber, groupId, productionLineId, relationType
               );
         }

         if (MesLossWorkProgressStatisticsEnum.FINISHED.getType() == lossWorkProgressStatisticsEnum) {
            if (processId == null) {
               taskCompleteWastageLossCostDetailList = this.taskService
                  .getTaskCompleteWastageLossCostDetailList(
                     dateTimeList, projectId, workShopId, taskTypeEnum, processId, serialNumber, groupId, productionLineId, relationType
                  );
            } else {
               taskCompleteWastageLossCostDetailList = this.taskService
                  .getTaskProcessCompleteWastageLossCostDetailList(
                     dateTimeList, projectId, workShopId, taskTypeEnum, processId, serialNumber, groupId, productionLineId, relationType
                  );
            }
         }

         if (MesLossWorkProgressStatisticsEnum.PROCESS_TASK.getType() == lossWorkProgressStatisticsEnum) {
            taskCompleteWastageLossCostDetailList = this.taskService
               .getTaskProcessProductsWastageLossCostDetailList(
                  dateTimeList, projectId, workShopId, taskTypeEnum, processId, serialNumber, groupId, productionLineId, relationType
               );
         }
      }

      if (TaskTypeEnum.ARTIFACT.getType().equals(taskTypeEnum)) {
         if (MesLossWorkProgressStatisticsEnum.SCHEDULING.getType() == lossWorkProgressStatisticsEnum) {
            taskCompleteWastageLossCostDetailList = this.taskService
               .getTaskProductSchedulingDetailList(
                  dateTimeList, projectId, workShopId, taskTypeEnum, processId, serialNumber, groupId, productionLineId, relationType
               );
         }

         if (MesLossWorkProgressStatisticsEnum.IN_PRODUCTION.getType() == lossWorkProgressStatisticsEnum) {
            taskCompleteWastageLossCostDetailList = this.taskService
               .getTaskPendingProductsWastageLossCostDetailList(
                  dateTimeList, projectId, workShopId, taskTypeEnum, processId, serialNumber, groupId, productionLineId, relationType
               );
         }

         if (MesLossWorkProgressStatisticsEnum.FINISHED.getType() == lossWorkProgressStatisticsEnum) {
            if (processId == null) {
               taskCompleteWastageLossCostDetailList = this.taskService
                  .getTaskCompleteWastageLossCostDetailList(
                     dateTimeList, projectId, workShopId, taskTypeEnum, processId, serialNumber, groupId, productionLineId, relationType
                  );
            } else {
               taskCompleteWastageLossCostDetailList = this.taskService
                  .getTaskProcessCompleteWastageLossCostDetailList(
                     dateTimeList, projectId, workShopId, taskTypeEnum, processId, serialNumber, groupId, productionLineId, relationType
                  );
            }
         }

         if (MesLossWorkProgressStatisticsEnum.PROCESS_TASK.getType() == lossWorkProgressStatisticsEnum) {
            taskCompleteWastageLossCostDetailList = this.taskService
               .getTaskProcessProductsWastageLossCostDetailList(
                  dateTimeList, projectId, workShopId, taskTypeEnum, processId, serialNumber, groupId, productionLineId, relationType
               );
         }
      }

      if ((
            MesLossWorkProgressStatisticsEnum.IN_PRODUCTION.getType() == lossWorkProgressStatisticsEnum
               || MesLossWorkProgressStatisticsEnum.PROCESS_TASK.getType() == lossWorkProgressStatisticsEnum
         )
         && CollectionUtils.isNotEmpty(taskCompleteWastageLossCostDetailList)) {
         Map<Long, List<MesBuildingGroupsTeamLink>> groupsMap = this.groupsTeamLinkService
            .list()
            .stream()
            .collect(Collectors.groupingBy(MesBuildingGroupsTeamLink::getGroupsId));
         List<MesBuildingTeam> teamList = this.teamService.list();
         Map<Long, MesBuildingTeamUserLink> teamUserLinkMap = this.teamUserLinkService
            .list((Wrapper<MesBuildingTeamUserLink>)new LambdaQueryWrapper<MesBuildingTeamUserLink>().eq(MesBuildingTeamUserLink::getBoolLeaderEnum, Boolean.TRUE))
            .stream()
            .collect(Collectors.toMap(MesBuildingTeamUserLink::getTeamId, Function.identity()));
         taskCompleteWastageLossCostDetailList.forEach(
            e -> {
               List<MesBuildingGroupsTeamLink> mesBuildingGroupsTeamLinks = groupsMap.get(e.getGroupsId());
               if (CollectionUtils.isNotEmpty(mesBuildingGroupsTeamLinks)) {
                  List<Long> teamIds = mesBuildingGroupsTeamLinks.stream().map(MesBuildingGroupsTeamLink::getTeamId).distinct().collect(Collectors.toList());
                  List<MesBuildingTeam> teams = teamList.stream()
                     .filter(team -> teamIds.contains(team.getId()) && team.getProcessId().equals(e.getProcessId()))
                     .collect(Collectors.toList());
                  if (CollectionUtils.isNotEmpty(teams)) {
                     String userNames = teams.stream().map(y -> teamUserLinkMap.get(y.getId()).getUserName()).distinct().collect(Collectors.joining(", "));
                     e.setTeamName(userNames);
                  }
               }
            }
         );
      }

      return taskCompleteWastageLossCostDetailList;
   }

   @Override
   public PageVO<ProductWastageLossCostMesDetailDTO> getPageWastageLossCostMesDetail(
      List<LocalDateTime> dateTimeList,
      Long projectId,
      Long workShopId,
      Integer taskTypeEnum,
      Integer processId,
      String serialNumber,
      Long groupId,
      Long productionLineId,
      Integer relationType,
      Integer projectOrWorkShopEnum,
      Integer lossWorkProgressStatisticsEnum,
      Integer pageNumber,
      Integer pageSize
   ) {
      return new PageVO<>(
         PageHelper.startPage(pageNumber, pageSize),
         this.wastageLossCostMesDetail(
            dateTimeList,
            projectId,
            workShopId,
            taskTypeEnum,
            processId,
            serialNumber,
            groupId,
            productionLineId,
            relationType,
            projectOrWorkShopEnum,
            lossWorkProgressStatisticsEnum
         )
      );
   }

   @Override
   public void wastageLossListDownload(
      Integer year, Integer status, Long projectId, Long workShopId, Integer projectOrWorkShopEnum, HttpServletResponse response
   ) {
      new Thread(this::updateAndCacheData).start();
      List<ProjectLossWorkProgressStatisticsWastageDTO> statisticsWastageDTOS = this.wastageLossList(
            year, status, projectId, workShopId, projectOrWorkShopEnum, 1, Integer.MAX_VALUE, Boolean.TRUE
         )
         .getContent();
      if (!CollectionUtils.isEmpty(statisticsWastageDTOS)) {
         String title = "损耗及在制品统计";
         Map<Integer, List<ProjectLossProcessProductionKanBanDTO>> processProductionKanBanMapDTO = this.projectSignageProcessList()
            .stream()
            .collect(Collectors.groupingBy(ProjectLossProcessProductionKanBanDTO::getProductType));
         List<List<String>> headList = this.getHead(processProductionKanBanMapDTO, projectOrWorkShopEnum, title);
         AtomicInteger orderNo = new AtomicInteger(1);
         List<List<Object>> dataList = statisticsWastageDTOS.stream()
            .map(i -> this.fillExcelData(orderNo.getAndIncrement(), i, processProductionKanBanMapDTO, projectOrWorkShopEnum))
            .collect(Collectors.toList());

         try {
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            String fileName = "损耗及在制品统计.xlsx";
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Expose-Headers", "*");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.setHeader("Result", "code=" + ResultCodeEnum.SUCCESS.getCode() + ";message=" + ResultCodeEnum.SUCCESS.getCode());

            try (ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream()).build()) {
               String sheetName = "";
               if (Objects.equals(projectOrWorkShopEnum, ProjectOrWorkShopEnum.PROJECT.getType())) {
                  sheetName = "总表(项目).xlsx";
               }

               if (Objects.equals(projectOrWorkShopEnum, ProjectOrWorkShopEnum.WORKSHOP.getType())) {
                  sheetName = "总表(车间).xlsx";
               }

               WriteSheet writeSheet = EasyExcel.writerSheet(0).sheetName(sheetName).head(headList).build();
               excelWriter.write(dataList, writeSheet);
            }
         } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
         }
      }
   }

   @Override
   public void wastageLossCostSummaryDownload(HttpServletResponse response, Integer year, Long projectId, Long workShopId, Integer projectOrWorkShopEnum) {
      List<WastageLossCostSummaryDTO> costSummaryDTOList = this.wastageLossCostSummary(year, projectId, workShopId, projectOrWorkShopEnum, Boolean.TRUE);
      if (!CollectionUtils.isEmpty(costSummaryDTOList)) {
         if (year == null) {
            year = LocalDateTime.now().getYear();
         }

         Integer finalYear = year;
         new Thread(() -> {
            if (ProjectOrWorkShopEnum.PROJECT.getType().equals(projectOrWorkShopEnum)) {
               try {
                  String jsonData = objectMapper.writeValueAsString(costSummaryDTOList);
                  this.redisUtils.set("project_wastagedtoby_detail_key" + projectId, jsonData);
               } catch (JsonProcessingException e) {
                  throw new RuntimeException(e);
               }
            }

            if (ProjectOrWorkShopEnum.WORKSHOP.getType().equals(projectOrWorkShopEnum)) {
               try {
                  String jsonData = objectMapper.writeValueAsString(costSummaryDTOList);
                  this.redisUtils.set("workshop_wastagedtoby_deail_key" + workShopId + finalYear, jsonData);
               } catch (JsonProcessingException e) {
                  throw new RuntimeException(e);
               }
            }
         }).start();
         String title = "";
         if (ProjectOrWorkShopEnum.PROJECT.getType().equals(projectOrWorkShopEnum)) {
            ContractProject project = this.projectService.getById(projectId);
            title = project.getSerialNumber() + project.getShortName();
         }

         if (ProjectOrWorkShopEnum.WORKSHOP.getType().equals(projectOrWorkShopEnum)) {
            MesBuildingWorkshop workshop = this.workshopService.getById(workShopId);
            title = workshop.getName();
         }

         List<List<String>> headList = new ArrayList<>();
         WastageLossCostSummaryDTO first = costSummaryDTOList.get(0);
         headList.add(Arrays.asList(title, "序号"));
         headList.add(Arrays.asList(title, "类别"));
         if (CollUtil.isNotEmpty(first.getWastageCostSummaryValueDTO())) {
            String finalTitle = title;
            first.getWastageCostSummaryValueDTO()
               .stream()
               .map(WastageCostSummaryValueDTO::getYearMonth)
               .forEach(yearMonth -> headList.add(Arrays.asList(finalTitle, yearMonth)));
         }

         headList.add(Arrays.asList(title, "合计"));
         List<List<Object>> dataList = new ArrayList<>();
         costSummaryDTOList.stream().filter(ex -> costSummaryDTOList.indexOf(ex) > 0).forEach(ex -> {
            List<Object> data = new ArrayList<>();
            data.add(ex.getIndexName());
            data.add(ex.getName());
            Map<String, WastageCostSummaryValueDTO> valueMap;
            if (CollUtil.isNotEmpty(ex.getWastageCostSummaryValueDTO())) {
               valueMap = ex.getWastageCostSummaryValueDTO().stream().collect(Collectors.toMap(WastageCostSummaryValueDTO::getYearMonth, Function.identity()));
            } else {
               valueMap = new HashMap<>();
            }

            first.getWastageCostSummaryValueDTO().forEach(yearMonth -> {
               WastageCostSummaryValueDTO value = valueMap.getOrDefault(yearMonth.getYearMonth(), new WastageCostSummaryValueDTO());
               if (ex.getName().equals("损耗率")) {
                  data.add(value.getProductMonthOutput() == null ? "-" : value.getProductMonthOutput() + "%");
               } else {
                  data.add(value.getProductMonthOutput() == null ? "-" : value.getProductMonthOutput());
               }
            });
            Object total = ex.getTotal() == null ? "-" : ex.getTotal().setScale(0, RoundingMode.HALF_UP);
            if (ex.getName().equals("损耗率")) {
               data.add(total + "%");
            } else {
               data.add(total);
            }

            dataList.add(data);
         });

         try {
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            String fileName = StrUtil.concat(true, "项目统计表.xlsx");
            String sheet = "项目统计";
            if (ProjectOrWorkShopEnum.WORKSHOP.getType().equals(projectOrWorkShopEnum)) {
               fileName = StrUtil.concat(true, "车间统计表.xlsx");
               sheet = "车间统计";
            }

            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Expose-Headers", "*");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "*");
            response.setHeader("Result", "code=" + ResultCodeEnum.SUCCESS.getCode() + ";message=" + ResultCodeEnum.SUCCESS.getCode());

            try (ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream()).build()) {
               WriteSheet writeSheet2 = EasyExcel.writerSheet(0, sheet)
                  .head(headList)
                  .registerWriteHandler(new SimpleColumnWidthStyleStrategy(15))
                  .registerWriteHandler(new HorizontalCellStyleStrategy(new WriteCellStyle() {
                     {
                        this.setHorizontalAlignment(HorizontalAlignment.CENTER);
                        this.setVerticalAlignment(VerticalAlignment.CENTER);
                     }
                  }, new WriteCellStyle() {
                     {
                        this.setHorizontalAlignment(HorizontalAlignment.CENTER);
                        this.setVerticalAlignment(VerticalAlignment.CENTER);
                     }
                  }))
                  .build();
               excelWriter.write(dataList, writeSheet2);
            }
         } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
         }
      }
   }

   private void updateAndCacheTwoData(Integer year, Long projectId, Long workShopId, Integer projectOrWorkShopEnum) {
      Integer lossCalculationFormula = this.configService.getRawMaterialLossCalculationFormula();
      List<WastageLossCostSummaryDTO> costSummaryDTOS = Lists.newArrayList();
      Util.checkArgument(lossCalculationFormula != null && RawMaterialLossEnum.isExist(lossCalculationFormula), "查询失败,原料损耗公式不存在!");
      if (ProjectOrWorkShopEnum.PROJECT.getType().equals(projectOrWorkShopEnum)) {
         this.getWastageLossCostSummaryByproject(projectId, costSummaryDTOS, lossCalculationFormula);
         if (CollectionUtils.isNotEmpty(costSummaryDTOS)) {
            try {
               String jsonData = objectMapper.writeValueAsString(costSummaryDTOS);
               this.redisUtils.set("project_wastagedtoby_detail_key" + workShopId + year, jsonData);
            } catch (JsonProcessingException e) {
               throw new RuntimeException(e);
            }
         }
      }

      if (ProjectOrWorkShopEnum.WORKSHOP.getType().equals(projectOrWorkShopEnum)) {
         year = year == null ? YearMonth.now().getYear() : year;
         this.getWastageLossCostSummaryByWorkShop(year, workShopId, costSummaryDTOS, lossCalculationFormula);
         if (CollectionUtils.isNotEmpty(costSummaryDTOS)) {
            try {
               String jsonData = objectMapper.writeValueAsString(costSummaryDTOS);
               this.redisUtils.set("workshop_wastagedtoby_deail_key" + workShopId + year, jsonData);
            } catch (JsonProcessingException e) {
               throw new RuntimeException(e);
            }
         }
      }
   }

   @Override
   public void getPageWastageLossCostMesDetailDownload(
      List<LocalDateTime> dateTimeList,
      Long projectId,
      Long workShopId,
      Integer taskTypeEnum,
      Integer processId,
      String serialNumber,
      Long groupId,
      Long productionLineId,
      Integer relationType,
      Integer projectOrWorkShopEnum,
      Integer lossWorkProgressStatisticsEnum,
      HttpServletResponse response
   ) {
      List<ProductWastageLossCostMesDetailDTO> productWastageLossCostMesDetailDTOS = this.wastageLossCostMesDetail(
         dateTimeList,
         projectId,
         workShopId,
         taskTypeEnum,
         processId,
         serialNumber,
         groupId,
         productionLineId,
         relationType,
         projectOrWorkShopEnum,
         lossWorkProgressStatisticsEnum
      );
      if (!CollectionUtils.isEmpty(productWastageLossCostMesDetailDTOS)) {
         String title = MesLossWorkProgressStatisticsEnum.getTitleByType(lossWorkProgressStatisticsEnum, taskTypeEnum);
         String fileAndSheetName = title;
         if (ProjectOrWorkShopEnum.PROJECT.getType().equals(projectOrWorkShopEnum)) {
            ContractProject project = this.projectService.getById(projectId);
            title = title + "(" + project.getSerialNumber() + project.getShortName() + ")";
         }

         if (ProjectOrWorkShopEnum.WORKSHOP.getType().equals(projectOrWorkShopEnum)) {
            MesBuildingWorkshop workshop = this.workshopService.getById(workShopId);
            title = title + "(" + workshop.getName() + ")";
         }

         List<List<String>> headList = this.getWastageLossCostMesDetailHead(lossWorkProgressStatisticsEnum, taskTypeEnum, title, processId, false);
         AtomicInteger orderNo = new AtomicInteger(1);
         List<List<Object>> dataList = productWastageLossCostMesDetailDTOS.stream()
            .map(i -> this.fillWastageLossCostMesDetailExcelData(orderNo.getAndIncrement(), i, lossWorkProgressStatisticsEnum, taskTypeEnum, processId))
            .collect(Collectors.toList());

         try {
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            String fileName = fileAndSheetName + ".xlsx";
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Expose-Headers", "*");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.setHeader("Result", "code=" + ResultCodeEnum.SUCCESS.getCode() + ";message=" + ResultCodeEnum.SUCCESS.getCode());

            try (ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream()).build()) {
               String sheetName = fileAndSheetName + ".xlsx";
               WriteSheet writeSheet = EasyExcel.writerSheet(0).sheetName(sheetName).head(headList).build();
               excelWriter.write(dataList, writeSheet);
            }
         } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
         }
      }
   }

   @Override
   public void workshopProjectWastageLossDetailDownload(Long projectId, Long workShopId, Integer projectOrWorkShopEnum, HttpServletResponse response) {
      ContractProject project = null;
      MesBuildingWorkshop workshop = null;
      if (ProjectOrWorkShopEnum.WORKSHOP.getType().equals(projectOrWorkShopEnum)) {
         Util.checkArgument(workShopId != null, "下载失败,车间Id不能为空!");
         workshop = this.workshopService.getById(workShopId);
         Util.checkArgument(workshop != null, "下载失败,车间不存在!");
         Util.checkArgument(projectId == null, "下载失败,车间维度,项目必须为空!");
      }

      if (ProjectOrWorkShopEnum.PROJECT.getType().equals(projectOrWorkShopEnum)) {
         Util.checkArgument(projectId != null, "下载失败,项目id不能为空!");
         project = this.projectService.getById(projectId);
         Util.checkArgument(project != null, "下载失败,项目不存在!");
         Util.checkArgument(workShopId == null, "下载失败,项目维度,车间必须为空!");
      }

      List<ProjectLossWorkProgressStatisticsWastageDTO> statisticsWastageDTOS = this.wastageLossList(
            null, null, projectId, workShopId, projectOrWorkShopEnum, 1, Integer.MAX_VALUE, Boolean.TRUE
         )
         .getContent();
      String oneTitle = "损耗及在制品统计";
      Map<Integer, List<ProjectLossProcessProductionKanBanDTO>> processProductionKanBanMapDTO = this.projectSignageProcessList()
         .stream()
         .collect(Collectors.groupingBy(ProjectLossProcessProductionKanBanDTO::getProductType));
      List<List<String>> headOneList = this.getHead(processProductionKanBanMapDTO, projectOrWorkShopEnum, oneTitle);
      AtomicInteger orderNo = new AtomicInteger(1);
      List<List<Object>> dataOneList = CollectionUtils.isEmpty(statisticsWastageDTOS)
         ? new ArrayList<>()
         : statisticsWastageDTOS.stream()
            .map(i -> this.fillExcelData(orderNo.getAndIncrement(), i, processProductionKanBanMapDTO, projectOrWorkShopEnum))
            .collect(Collectors.toList());
      List<WastageLossCostSummaryDTO> costSummaryDTOList = this.wastageLossCostSummary(null, projectId, workShopId, projectOrWorkShopEnum, Boolean.TRUE);
      String titleTwo = "";
      if (ProjectOrWorkShopEnum.PROJECT.getType().equals(projectOrWorkShopEnum)) {
         assert project != null;
         titleTwo = project.getSerialNumber() + project.getShortName();
      }

      if (ProjectOrWorkShopEnum.WORKSHOP.getType().equals(projectOrWorkShopEnum)) {
         assert workshop != null;
         titleTwo = workshop.getName();
      }

      List<List<String>> headTwoList = new ArrayList<>();
      WastageLossCostSummaryDTO first = costSummaryDTOList.get(0);
      headTwoList.add(Arrays.asList(titleTwo, "序号"));
      headTwoList.add(Arrays.asList(titleTwo, "类别"));
      if (CollUtil.isNotEmpty(first.getWastageCostSummaryValueDTO())) {
         String finalTitle = titleTwo;
         first.getWastageCostSummaryValueDTO()
            .stream()
            .map(WastageCostSummaryValueDTO::getYearMonth)
            .forEach(yearMonth -> headTwoList.add(Arrays.asList(finalTitle, yearMonth)));
      }

      headTwoList.add(Arrays.asList(titleTwo, "合计"));
      List<List<Object>> dataTwoList = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(costSummaryDTOList)) {
         costSummaryDTOList.stream().filter(ex -> costSummaryDTOList.indexOf(ex) > 0).forEach(ex -> {
            List<Object> data = new ArrayList<>();
            data.add(ex.getIndexName());
            data.add(ex.getName());
            Map<String, WastageCostSummaryValueDTO> valueMap;
            if (CollUtil.isNotEmpty(ex.getWastageCostSummaryValueDTO())) {
               valueMap = ex.getWastageCostSummaryValueDTO().stream().collect(Collectors.toMap(WastageCostSummaryValueDTO::getYearMonth, Function.identity()));
            } else {
               valueMap = new HashMap<>();
            }

            first.getWastageCostSummaryValueDTO().forEach(yearMonth -> {
               WastageCostSummaryValueDTO value = valueMap.getOrDefault(yearMonth.getYearMonth(), new WastageCostSummaryValueDTO());
               if (ex.getName().equals("损耗率")) {
                  data.add(value.getProductMonthOutput() == null ? "-" : value.getProductMonthOutput() + "%");
               } else {
                  data.add(value.getProductMonthOutput() == null ? "-" : value.getProductMonthOutput());
               }
            });
            Object total = ex.getTotal() == null ? "-" : ex.getTotal().setScale(0, RoundingMode.HALF_UP);
            data.add(total);
            dataTwoList.add(data);
         });
      }

      int sheetNo = 0;

      try {
         response.reset();
         response.setContentType("application/vnd.ms-excel;charset=utf-8");
         String fileName = "车间/项目统计详情表.xlsx";
         response.setHeader("Access-Control-Allow-Origin", "*");
         response.setHeader("Access-Control-Expose-Headers", "*");
         response.setCharacterEncoding("UTF-8");
         response.setHeader("content-Type", "application/vnd.ms-excel");
         response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
         response.setHeader("Result", "code=" + ResultCodeEnum.SUCCESS.getCode() + ";message=" + ResultCodeEnum.SUCCESS.getCode());

         try (ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream()).build()) {
            String sheetOneName = "";
            if (Objects.equals(projectOrWorkShopEnum, ProjectOrWorkShopEnum.PROJECT.getType())) {
               sheetOneName = "总表(项目).xlsx";
            }

            if (Objects.equals(projectOrWorkShopEnum, ProjectOrWorkShopEnum.WORKSHOP.getType())) {
               sheetOneName = "总表(车间).xlsx";
            }

            WriteSheet writeSheet = EasyExcel.writerSheet(sheetNo++).sheetName(sheetOneName).head(headOneList).build();
            excelWriter.write(dataOneList, writeSheet);
            String sheetName2 = "";
            if (Objects.equals(projectOrWorkShopEnum, ProjectOrWorkShopEnum.PROJECT.getType())) {
               sheetName2 = "项目查询.xlsx";
            }

            if (Objects.equals(projectOrWorkShopEnum, ProjectOrWorkShopEnum.WORKSHOP.getType())) {
               sheetName2 = "车间查询.xlsx";
            }

            WriteSheet writeSheet2 = EasyExcel.writerSheet(sheetNo++, sheetName2).head(headTwoList).build();
            excelWriter.write(dataTwoList, writeSheet2);
            List<Integer> lossWorkProgressStatistics = Arrays.asList(
               MesLossWorkProgressStatisticsEnum.FINISHED.getType(),
               MesLossWorkProgressStatisticsEnum.IN_PRODUCTION.getType(),
               MesLossWorkProgressStatisticsEnum.SCHEDULING.getType(),
               MesLossWorkProgressStatisticsEnum.PARTS_ALLOCATION.getType()
            );

            for (Integer productType : Arrays.asList(
               ProductTypeEnum.MACHINE_PART.getType(), ProductTypeEnum.ASSEMBLE.getType(), ProductTypeEnum.ARTIFACT.getType()
            )) {
               for (Integer lossWorkProgressStatisticsEnum : lossWorkProgressStatistics) {
                  if (!lossWorkProgressStatisticsEnum.equals(MesLossWorkProgressStatisticsEnum.PARTS_ALLOCATION.getType())
                     || productType.equals(ProductTypeEnum.MACHINE_PART.getType())) {
                     List<ProductWastageLossCostMesDetailDTO> productWastageLossCostMesDetailDTOS = this.wastageLossCostMesDetail(
                        null, projectId, workShopId, productType, null, null, null, null, null, projectOrWorkShopEnum, lossWorkProgressStatisticsEnum
                     );
                     String title = MesLossWorkProgressStatisticsEnum.getTitleByType(lossWorkProgressStatisticsEnum, productType);
                     String fileAndSheetName = title;
                     if (ProjectOrWorkShopEnum.PROJECT.getType().equals(projectOrWorkShopEnum)) {
                        assert project != null;
                        title = title + "(" + project.getSerialNumber() + project.getShortName() + ")";
                     }

                     if (ProjectOrWorkShopEnum.WORKSHOP.getType().equals(projectOrWorkShopEnum)) {
                        assert workshop != null;
                        title = title + "(" + workshop.getName() + ")";
                     }

                     List<List<String>> headList = this.getWastageLossCostMesDetailHead(lossWorkProgressStatisticsEnum, productType, title, null, true);
                     AtomicInteger orderNoThree = new AtomicInteger(1);
                     List<List<Object>> dataList = new ArrayList<>();
                     if (CollectionUtils.isNotEmpty(productWastageLossCostMesDetailDTOS)) {
                        dataList = productWastageLossCostMesDetailDTOS.stream()
                           .map(
                              i -> this.fillWastageLossCostMesDetailExcelData(
                                 orderNoThree.getAndIncrement(), i, lossWorkProgressStatisticsEnum, productType, null
                              )
                           )
                           .collect(Collectors.toList());
                     }

                     String sheetName = fileAndSheetName + ".xlsx";
                     WriteSheet writeSheetThree = EasyExcel.writerSheet(sheetNo++).sheetName(sheetName).head(headList).build();
                     excelWriter.write(dataList, writeSheetThree);
                  }
               }
            }
         }
      } catch (Exception e) {
         throw new RuntimeException(e.getMessage());
      }
   }

   private List<Object> fillWastageLossCostMesDetailExcelData(
      Integer orderNo, ProductWastageLossCostMesDetailDTO dto, Integer lossWorkProgressStatisticsEnum, Integer productType, Integer processId
   ) {
      List<Object> data = new ArrayList<>();
      data.add(orderNo);
      if (MesLossWorkProgressStatisticsEnum.PARTS_ALLOCATION.getType() == lossWorkProgressStatisticsEnum) {
         data.add(dto.getCreateTime().toString());
         data.add(dto.getProduceWorkshopName());
         data.add(dto.getWorkshopName());
      } else {
         data.add(dto.getWorkshopName());
      }

      data.add(dto.getProject() == null ? "-" : dto.getProject().getName());
      data.add(dto.getGroupsName());
      if (MesLossWorkProgressStatisticsEnum.IN_PRODUCTION.getType() == lossWorkProgressStatisticsEnum) {
         data.add(dto.getTeamName());
      }

      if (ProductTypeEnum.MACHINE_PART.getType().equals(productType)) {
         if (MachinePartRelationTypeEnum.FOR_ARTIFACT.getType().equals(dto.getRelationType())) {
            data.add("构件零件");
         } else {
            data.add("部件零件");
         }
      }

      data.add(dto.getName());
      data.add(dto.getSerialNumber());
      data.add(dto.getSpecification());
      data.add(dto.getLength());
      data.add(dto.getMaterial());
      data.add(dto.getQuantity());
      data.add(dto.getNetWeight());
      data.add(dto.getTotalNetWeight());
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
      if (MesLossWorkProgressStatisticsEnum.FINISHED.getType() == lossWorkProgressStatisticsEnum) {
         if (processId != null) {
            data.add(dto.getProcessName());
         }

         data.add(dto.getCreateTime().format(formatter));
      }

      if (MesLossWorkProgressStatisticsEnum.SCHEDULING.getType() == lossWorkProgressStatisticsEnum) {
         data.add(dto.getCreateTime().format(formatter));
      }

      if (MesLossWorkProgressStatisticsEnum.IN_PRODUCTION.getType() == lossWorkProgressStatisticsEnum) {
         data.add(dto.getProcessName());
         data.add(dto.getCreateTime().format(formatter));
      }

      return data;
   }

   private List<List<String>> getWastageLossCostMesDetailHead(
      Integer lossWorkProgressStatisticsEnum, Integer productType, String title, Integer processId, Boolean boolDownload
   ) {
      List<List<String>> headList = new ArrayList<>();
      headList.add(Arrays.asList(title, "序号"));
      if (MesLossWorkProgressStatisticsEnum.PARTS_ALLOCATION.getType() == lossWorkProgressStatisticsEnum) {
         headList.add(Arrays.asList(title, "使用时间"));
         headList.add(Arrays.asList(title, "生产车间"));
         headList.add(Arrays.asList(title, "使用车间"));
      } else {
         headList.add(Arrays.asList(title, "车间"));
      }

      headList.add(Arrays.asList(title, "项目"));
      headList.add(Arrays.asList(title, "生产组"));
      if (MesLossWorkProgressStatisticsEnum.IN_PRODUCTION.getType() == lossWorkProgressStatisticsEnum
         || MesLossWorkProgressStatisticsEnum.PROCESS_TASK.getType() == lossWorkProgressStatisticsEnum) {
         headList.add(Arrays.asList(title, "班组"));
      }

      if (ProductTypeEnum.MACHINE_PART.getType().equals(productType)) {
         headList.add(Arrays.asList(title, "零件类型"));
      }

      headList.add(Arrays.asList(title, "名称"));
      headList.add(Arrays.asList(title, "编号"));
      headList.add(Arrays.asList(title, "规格"));
      headList.add(Arrays.asList(title, "长度"));
      headList.add(Arrays.asList(title, "材质"));
      headList.add(Arrays.asList(title, "数量"));
      headList.add(Arrays.asList(title, "单重"));
      headList.add(Arrays.asList(title, "总重"));
      if (MesLossWorkProgressStatisticsEnum.SCHEDULING.getType() == lossWorkProgressStatisticsEnum) {
         headList.add(Arrays.asList(title, "排产时间"));
      }

      if (MesLossWorkProgressStatisticsEnum.FINISHED.getType() == lossWorkProgressStatisticsEnum) {
         if (processId != null) {
            headList.add(Arrays.asList(title, "当前工序"));
         }

         headList.add(Arrays.asList(title, "完成时间"));
      }

      if (MesLossWorkProgressStatisticsEnum.IN_PRODUCTION.getType() == lossWorkProgressStatisticsEnum) {
         if (processId != null) {
            headList.add(Arrays.asList(title, "当前工序"));
         }

         if (boolDownload) {
            headList.add(Arrays.asList(title, "当前工序"));
         }

         headList.add(Arrays.asList(title, "排产时间"));
      }

      return headList;
   }

   private List<Object> fillExcelData(
      Integer orderNo,
      ProjectLossWorkProgressStatisticsWastageDTO dto,
      Map<Integer, List<ProjectLossProcessProductionKanBanDTO>> processByProductTypeGroup,
      Integer projectOrWorkShopEnum
   ) {
      List<Object> data = new ArrayList<>();
      data.add(orderNo);
      if (ProjectOrWorkShopEnum.PROJECT.getType().equals(projectOrWorkShopEnum)) {
         data.add(dto.getShortName() + dto.getSerialNumber());
      } else {
         data.add(dto.getName());
      }

      if (ProjectOrWorkShopEnum.PROJECT.getType().equals(projectOrWorkShopEnum)) {
         data.add(dto.getTotalArtifactNetWeight());
      }

      data.add(dto.getTotalArtifactTaskNetWeight());
      ProductProcessWorkProgressStatisticsDTO partProgressStatisticsDTO = dto.getPartProgressStatisticsDTO();
      data.add(partProgressStatisticsDTO == null ? 0 : partProgressStatisticsDTO.getTotalPickingWeight());
      data.add(partProgressStatisticsDTO == null ? 0 : partProgressStatisticsDTO.getTotalSchedulingNetWeight());
      if (partProgressStatisticsDTO != null && CollectionUtils.isNotEmpty(partProgressStatisticsDTO.getStatisticsDetailDTOS())) {
         ProductProcessWorkProgressStatisticsDetailDTO progressStatisticsDetailDTO = partProgressStatisticsDTO.getStatisticsDetailDTOS().get(0);
         data.add(progressStatisticsDetailDTO.getTotalTaskNetWeight());
         data.add(progressStatisticsDetailDTO.getTotalCompleteNetWeight());
         data.add(progressStatisticsDetailDTO.getTotalInProductionNetWeight());
         data.add(progressStatisticsDetailDTO.getTotalLossWeight());
         data.add(progressStatisticsDetailDTO.getTotalLossRate() + "%");
      } else {
         data.add(0);
         data.add(0);
         data.add(0);
         data.add(0);
         data.add(0);
      }

      ProductProcessWorkProgressStatisticsDTO assembleProgressStatisticsDTO = dto.getAssembleProgressStatisticsDTO();
      data.add(assembleProgressStatisticsDTO == null ? 0 : assembleProgressStatisticsDTO.getTotalSchedulingNetWeight());
      if (assembleProgressStatisticsDTO != null) {
         List<ProductProcessWorkProgressStatisticsDetailDTO> statisticsDetailDTOS = assembleProgressStatisticsDTO.getStatisticsDetailDTOS();
         Map<Long, ProductProcessWorkProgressStatisticsDetailDTO> progressStatisticsDetailDTOMap = statisticsDetailDTOS.stream()
            .collect(Collectors.toMap(ProductProcessWorkProgressStatisticsDetailDTO::getProcessId, Function.identity()));
         processByProductTypeGroup.get(com.hzchum.scim.common.core.api.enums.ProductTypeEnum.ASSEMBLE.getType()).forEach(ap -> {
            ProductProcessWorkProgressStatisticsDetailDTO detailDTO = progressStatisticsDetailDTOMap.get(ap.getId());
            data.add(detailDTO == null ? 0 : detailDTO.getTotalTaskNetWeight());
            data.add(detailDTO == null ? 0 : detailDTO.getTotalCompleteNetWeight());
            data.add(detailDTO == null ? 0 : detailDTO.getTotalInProductionNetWeight());
         });
      } else {
         processByProductTypeGroup.get(com.hzchum.scim.common.core.api.enums.ProductTypeEnum.ASSEMBLE.getType()).forEach(ap -> {
            data.add(0);
            data.add(0);
            data.add(0);
         });
      }

      ProductProcessWorkProgressStatisticsDTO artifactProgressStatisticsDTO = dto.getArtifactProgressStatisticsDTO();
      if (artifactProgressStatisticsDTO != null) {
         List<ProductProcessWorkProgressStatisticsDetailDTO> artifactStatisticsDetailDTOS = artifactProgressStatisticsDTO.getStatisticsDetailDTOS();
         Map<Long, ProductProcessWorkProgressStatisticsDetailDTO> artifactProgressStatisticsDetailDTOMap = artifactStatisticsDetailDTOS.stream()
            .collect(Collectors.toMap(ProductProcessWorkProgressStatisticsDetailDTO::getProcessId, Function.identity()));
         processByProductTypeGroup.get(com.hzchum.scim.common.core.api.enums.ProductTypeEnum.ARTIFACT.getType()).forEach(ap -> {
            ProductProcessWorkProgressStatisticsDetailDTO detailDTO = artifactProgressStatisticsDetailDTOMap.get(ap.getId());
            data.add(detailDTO == null ? 0 : detailDTO.getTotalTaskNetWeight());
            data.add(detailDTO == null ? 0 : detailDTO.getTotalCompleteNetWeight());
            data.add(detailDTO == null ? 0 : detailDTO.getTotalInProductionNetWeight());
         });
      } else {
         processByProductTypeGroup.get(com.hzchum.scim.common.core.api.enums.ProductTypeEnum.ARTIFACT.getType()).forEach(ap -> {
            data.add(0);
            data.add(0);
            data.add(0);
         });
      }

      data.add(dto.getTotalArtifactCompleteNetWeight());
      return data;
   }

   private List<List<String>> getHead(
      Map<Integer, List<ProjectLossProcessProductionKanBanDTO>> processProductionKanBanMapDTO, Integer projectOrWorkShopEnum, String title
   ) {
      List<List<String>> headList = new ArrayList<>();
      headList.add(Arrays.asList(title, "序号", "序号", "序号"));
      if (ProjectOrWorkShopEnum.PROJECT.getType().equals(projectOrWorkShopEnum)) {
         headList.add(Arrays.asList(title, "项目", "项目", "项目"));
      } else {
         headList.add(Arrays.asList(title, "车间", "车间", "车间"));
      }

      if (ProjectOrWorkShopEnum.PROJECT.getType().equals(projectOrWorkShopEnum)) {
         headList.add(Arrays.asList(title, "清单量", "清单量", "清单量"));
      }

      headList.add(Arrays.asList(title, "累计排产量", "累计排产量", "累计排产量"));
      headList.add(Arrays.asList(title, "零件", "累计领料量", "累计领料量"));
      headList.add(Arrays.asList(title, "零件", "累计排产量", "累计排产量"));
      headList.add(Arrays.asList(title, "零件", "零件下料", "任务量"));
      headList.add(Arrays.asList(title, "零件", "零件下料", "制成品"));
      headList.add(Arrays.asList(title, "零件", "零件下料", "待制品"));
      headList.add(Arrays.asList(title, "零件", "零件下料", "损耗"));
      headList.add(Arrays.asList(title, "零件", "零件下料", "损耗率"));
      headList.add(Arrays.asList(title, "部件", "排产量", "排产量"));
      processProductionKanBanMapDTO.get(com.hzchum.scim.common.core.api.enums.ProductTypeEnum.ASSEMBLE.getType()).forEach(ap -> {
         headList.add(Arrays.asList(title, "部件", ap.getName(), "任务"));
         headList.add(Arrays.asList(title, "部件", ap.getName(), "完成"));
         headList.add(Arrays.asList(title, "部件", ap.getName(), "在制"));
      });
      processProductionKanBanMapDTO.get(com.hzchum.scim.common.core.api.enums.ProductTypeEnum.ARTIFACT.getType()).forEach(ap -> {
         headList.add(Arrays.asList(title, "构件", ap.getName(), "任务"));
         headList.add(Arrays.asList(title, "构件", ap.getName(), "完成"));
         headList.add(Arrays.asList(title, "构件", ap.getName(), "在制"));
      });
      headList.add(Arrays.asList(title, "制成品", "制成品", "制成品"));
      return headList;
   }

   @Override
   public void getWastageLossCostSummaryByWorkShop(
      Integer year, Long workShopId, List<WastageLossCostSummaryDTO> costSummaryDTOS, Integer lossCalculationFormula
   ) {
      List<String> yearStringMonthList = new ArrayList<>();
      WastageLossCostSummaryDTO firstCostSummaryDTO = this.getFirstByWorkShop(year, yearStringMonthList);
      List<LocalDate> yearMonthDateList = yearStringMonthList.stream().map(ym -> LocalDate.parse(ym + "-01")).collect(Collectors.toList());
      costSummaryDTOS.add(firstCostSummaryDTO);
      List<WastageCostSummaryValueDTO> firstCostSummaryValueDTOList = firstCostSummaryDTO.getWastageCostSummaryValueDTO();
      String maxYearMonth = firstCostSummaryValueDTOList.get(0).getYearMonth();
      String minYearMonth = firstCostSummaryValueDTOList.get(firstCostSummaryValueDTOList.size() - 1).getYearMonth();
      if (year != LocalDate.now().getYear()) {
         maxYearMonth = firstCostSummaryValueDTOList.get(firstCostSummaryValueDTOList.size() - 1).getYearMonth();
         minYearMonth = firstCostSummaryValueDTOList.get(0).getYearMonth();
      }

      WastageLossCostSummaryDTO partSummary = WastageLossCostSummaryDTO.builder().indexNumber(10).indexName("一").name("零件").build();
      List<WastageCostSummaryValueDTO> taskWastageLossCostSummary = this.taskService
         .getTaskWastageLossCostSummary(null, workShopId, TaskTypeEnum.MACHINE_PART.getType(), minYearMonth, maxYearMonth, yearMonthDateList);
      WastageLossCostSummaryDTO partSchedulingCostSummary = WastageLossCostSummaryDTO.builder()
         .wastageCostSummaryValueDTO(taskWastageLossCostSummary)
         .name("零件排产")
         .indexName("1.1")
         .indexNumber(11)
         .build();
      partSchedulingCostSummary.setTotal(this.getTotal(partSchedulingCostSummary.getWastageCostSummaryValueDTO()));
      List<WastageCostSummaryValueDTO> outboundSummaryList = this.reportService
         .getGroupByMonthOutboundSummary(null, workShopId, minYearMonth, maxYearMonth, yearMonthDateList);
      WastageLossCostSummaryDTO materialOutboundCostSummary = WastageLossCostSummaryDTO.builder()
         .wastageCostSummaryValueDTO(outboundSummaryList)
         .name("原料出库量")
         .indexName("1.2")
         .indexNumber(12)
         .build();
      materialOutboundCostSummary.setTotal(this.getTotal(materialOutboundCostSummary.getWastageCostSummaryValueDTO()));
      WastageLossCostSummaryDTO materialFeedingCostSummary = WastageLossCostSummaryDTO.builder()
         .wastageCostSummaryValueDTO(null)
         .name("原料投料")
         .indexName("1.3")
         .indexNumber(13)
         .build();
      materialFeedingCostSummary.setTotal(this.getTotal(materialFeedingCostSummary.getWastageCostSummaryValueDTO()));
      List<WastageCostSummaryValueDTO> returnSummaryList = this.reportService
         .getGroupByMonthReturnSummary(null, workShopId, minYearMonth, maxYearMonth, yearMonthDateList);
      if (maxYearMonth.substring(0, 4).equals(String.valueOf(LocalDate.now().getYear()))) {
         returnSummaryList.sort((o1, o2) -> o2.getYearMonth().compareTo(o1.getYearMonth()));
      } else {
         returnSummaryList.sort(Comparator.comparing(WastageCostSummaryValueDTO::getYearMonth));
      }

      WastageLossCostSummaryDTO materialStockReturnCostSummary = WastageLossCostSummaryDTO.builder()
         .wastageCostSummaryValueDTO(returnSummaryList)
         .name("原料退库量")
         .indexName("1.4")
         .indexNumber(14)
         .build();
      materialStockReturnCostSummary.setTotal(this.getTotal(materialStockReturnCostSummary.getWastageCostSummaryValueDTO()));
      List<WastageCostSummaryValueDTO> pickingSummaryList = this.getGroupByMonthPickingSummary(yearMonthDateList, outboundSummaryList, returnSummaryList);
      WastageLossCostSummaryDTO materialPickingCostSummary = WastageLossCostSummaryDTO.builder()
         .wastageCostSummaryValueDTO(pickingSummaryList)
         .name("原料实际领料")
         .indexName("1.5")
         .indexNumber(15)
         .build();
      materialPickingCostSummary.setTotal(this.getTotal(materialPickingCostSummary.getWastageCostSummaryValueDTO()));
      List<WastageCostSummaryValueDTO> completeCostSummaryValueDTOS = this.taskService
         .getTaskCompleteWastageLossCostSummary(null, workShopId, TaskTypeEnum.MACHINE_PART.getType(), minYearMonth, maxYearMonth, yearMonthDateList);
      WastageLossCostSummaryDTO partCompleteCostSummary = WastageLossCostSummaryDTO.builder()
         .wastageCostSummaryValueDTO(completeCostSummaryValueDTOS)
         .name("零件制成品")
         .indexName("1.6")
         .indexNumber(16)
         .build();
      partCompleteCostSummary.setTotal(this.getTotal(partCompleteCostSummary.getWastageCostSummaryValueDTO()));
      List<WastageCostSummaryValueDTO> partsAllocationWastageLossCostSummary = this.taskService
         .getPartsAllocationWastageLossCostSummary(
            null,
            workShopId,
            TaskTypeEnum.MACHINE_PART.getType(),
            minYearMonth,
            maxYearMonth,
            yearMonthDateList,
            Arrays.asList(MachinePartRelationTypeEnum.FOR_ARTIFACT.getType(), MachinePartRelationTypeEnum.FOR_ASSEMBLE.getType())
         );
      if (CollectionUtils.isNotEmpty(partsAllocationWastageLossCostSummary)) {
         partsAllocationWastageLossCostSummary = partsAllocationWastageLossCostSummary.stream()
            .sorted(Comparator.comparing(WastageCostSummaryValueDTO::getYearMonth).reversed())
            .collect(Collectors.toList());
      }

      WastageLossCostSummaryDTO materialTransferCostSummary = WastageLossCostSummaryDTO.builder()
         .wastageCostSummaryValueDTO(partsAllocationWastageLossCostSummary)
         .name("零件调拨")
         .indexName("1.7")
         .indexNumber(17)
         .build();
      materialTransferCostSummary.setTotal(this.getTotal(materialTransferCostSummary.getWastageCostSummaryValueDTO()));
      List<WastageCostSummaryValueDTO> taskPendingProductsWastageLossCostSummary = this.taskService
         .getTaskPendingProductsWastageLossCostSummary(null, workShopId, TaskTypeEnum.MACHINE_PART.getType(), minYearMonth, maxYearMonth, yearMonthDateList);
      if (CollectionUtils.isNotEmpty(taskPendingProductsWastageLossCostSummary)) {
         taskPendingProductsWastageLossCostSummary = taskPendingProductsWastageLossCostSummary.stream()
            .sorted(Comparator.comparing(WastageCostSummaryValueDTO::getYearMonth))
            .collect(Collectors.toList());
         BigDecimal productMonthOutput = BigDecimal.ZERO;

         for (WastageCostSummaryValueDTO valueDTO : taskPendingProductsWastageLossCostSummary) {
            productMonthOutput = productMonthOutput.add(valueDTO.getProductMonthOutput() == null ? BigDecimal.ZERO : valueDTO.getProductMonthOutput());
            valueDTO.setProductMonthOutput(productMonthOutput);
         }
      }

      taskPendingProductsWastageLossCostSummary = taskPendingProductsWastageLossCostSummary.stream()
         .sorted(Comparator.comparing(WastageCostSummaryValueDTO::getYearMonth).reversed())
         .collect(Collectors.toList());
      WastageLossCostSummaryDTO partPendingProductsCostSummary = WastageLossCostSummaryDTO.builder()
         .wastageCostSummaryValueDTO(taskPendingProductsWastageLossCostSummary)
         .name("零件待制品")
         .indexName("1.8")
         .indexNumber(18)
         .build();
      WastageLossCostSummaryDTO materialLossCostSummary = WastageLossCostSummaryDTO.builder()
         .wastageCostSummaryValueDTO(null)
         .name("原料损耗")
         .indexName("1.9")
         .indexNumber(19)
         .build();
      WastageLossCostSummaryDTO materialLossRateCostSummary = WastageLossCostSummaryDTO.builder()
         .wastageCostSummaryValueDTO(null)
         .name("损耗率")
         .indexName("1.9.1")
         .indexNumber(191)
         .build();
      List<WastageCostSummaryValueDTO> wastageCostSummaryValueDTOList = firstCostSummaryDTO.getWastageCostSummaryValueDTO();
      if (CollectionUtils.isNotEmpty(wastageCostSummaryValueDTOList)) {
         if (lossCalculationFormula.equals(RawMaterialLossEnum.FORMULA_ONE.getType())) {
            List<WastageCostSummaryValueDTO> wastageCostSummaryValueDTO = materialFeedingCostSummary.getWastageCostSummaryValueDTO();
            if (CollectionUtils.isNotEmpty(wastageCostSummaryValueDTO)) {
               List<WastageCostSummaryValueDTO> materialLossCostSummaryValueDTOList = new ArrayList<>();
               List<WastageCostSummaryValueDTO> materialLossRateCostSummaryValueDTOList = new ArrayList<>();
               Map<String, WastageCostSummaryValueDTO> wastageCostSummaryValueMap = wastageCostSummaryValueDTO.stream()
                  .collect(Collectors.toMap(WastageCostSummaryValueDTO::getYearMonth, Function.identity()));
               Map<String, WastageCostSummaryValueDTO> partCompleteCostSummaryValueMap = completeCostSummaryValueDTOS.stream()
                  .collect(Collectors.toMap(WastageCostSummaryValueDTO::getYearMonth, Function.identity()));

               for (WastageCostSummaryValueDTO costSummaryValueDTO : wastageCostSummaryValueDTOList) {
                  WastageCostSummaryValueDTO wastageCostSummaryValue = wastageCostSummaryValueMap.get(costSummaryValueDTO.getYearMonth());
                  WastageCostSummaryValueDTO partCompleteCostSummaryValue = partCompleteCostSummaryValueMap.get(costSummaryValueDTO.getYearMonth());
                  if (wastageCostSummaryValue != null) {
                     WastageCostSummaryValueDTO valueDTO = WastageCostSummaryValueDTO.builder()
                        .yearMonth(costSummaryValueDTO.getYearMonth())
                        .productMonthOutput(
                           wastageCostSummaryValue.getProductMonthOutput()
                              .subtract(
                                 partCompleteCostSummaryValue != null && partCompleteCostSummaryValue.getProductMonthOutput() != null
                                    ? partCompleteCostSummaryValue.getProductMonthOutput()
                                    : BigDecimal.ZERO
                              )
                        )
                        .build();
                     materialLossCostSummaryValueDTOList.add(valueDTO);
                     WastageCostSummaryValueDTO LossRateValueDTO = WastageCostSummaryValueDTO.builder().yearMonth(costSummaryValueDTO.getYearMonth()).build();
                     if (valueDTO.getProductMonthOutput().compareTo(BigDecimal.ZERO) != 0
                        && wastageCostSummaryValue.getProductMonthOutput().compareTo(BigDecimal.ZERO) != 0) {
                        LossRateValueDTO.setProductMonthOutput(
                           valueDTO.getProductMonthOutput()
                              .divide(wastageCostSummaryValue.getProductMonthOutput(), 3, RoundingMode.HALF_UP)
                              .multiply(BigDecimal.valueOf(100L))
                        );
                     }

                     materialLossRateCostSummaryValueDTOList.add(LossRateValueDTO);
                  }
               }

               materialLossCostSummary.setWastageCostSummaryValueDTO(materialLossCostSummaryValueDTOList);
               materialLossRateCostSummary.setWastageCostSummaryValueDTO(materialLossRateCostSummaryValueDTOList);
            }
         }

         if (lossCalculationFormula.equals(RawMaterialLossEnum.FORMULA_TWO.getType())) {
            List<WastageCostSummaryValueDTO> wastageCostSummaryValueDTO = materialPickingCostSummary.getWastageCostSummaryValueDTO();
            if (CollectionUtils.isNotEmpty(wastageCostSummaryValueDTO)) {
               List<WastageCostSummaryValueDTO> materialLossCostSummaryValueDTOList = new ArrayList<>();
               List<WastageCostSummaryValueDTO> materialLossRateCostSummaryValueDTOList = new ArrayList<>();
               Map<String, WastageCostSummaryValueDTO> wastageCostSummaryValueMap = wastageCostSummaryValueDTO.stream()
                  .collect(Collectors.toMap(WastageCostSummaryValueDTO::getYearMonth, Function.identity()));
               Map<String, WastageCostSummaryValueDTO> partCompleteCostSummaryValueMap = completeCostSummaryValueDTOS.stream()
                  .collect(Collectors.toMap(WastageCostSummaryValueDTO::getYearMonth, Function.identity()));

               for (WastageCostSummaryValueDTO costSummaryValueDTO : wastageCostSummaryValueDTOList) {
                  WastageCostSummaryValueDTO wastageCostSummaryValue = wastageCostSummaryValueMap.get(costSummaryValueDTO.getYearMonth());
                  WastageCostSummaryValueDTO partCompleteCostSummaryValue = partCompleteCostSummaryValueMap.get(costSummaryValueDTO.getYearMonth());
                  if (wastageCostSummaryValue != null) {
                     WastageCostSummaryValueDTO valueDTO = WastageCostSummaryValueDTO.builder()
                        .yearMonth(costSummaryValueDTO.getYearMonth())
                        .productMonthOutput(
                           wastageCostSummaryValue.getProductMonthOutput()
                              .subtract(
                                 partCompleteCostSummaryValue != null && partCompleteCostSummaryValue.getProductMonthOutput() != null
                                    ? partCompleteCostSummaryValue.getProductMonthOutput()
                                    : BigDecimal.ZERO
                              )
                        )
                        .build();
                     materialLossCostSummaryValueDTOList.add(valueDTO);
                     WastageCostSummaryValueDTO LossRateValueDTO = WastageCostSummaryValueDTO.builder().yearMonth(costSummaryValueDTO.getYearMonth()).build();
                     if (valueDTO.getProductMonthOutput().compareTo(BigDecimal.ZERO) != 0
                        && wastageCostSummaryValue.getProductMonthOutput().compareTo(BigDecimal.ZERO) != 0) {
                        LossRateValueDTO.setProductMonthOutput(
                           valueDTO.getProductMonthOutput()
                              .divide(wastageCostSummaryValue.getProductMonthOutput(), 3, RoundingMode.HALF_UP)
                              .multiply(BigDecimal.valueOf(100L))
                        );
                     }

                     materialLossRateCostSummaryValueDTOList.add(LossRateValueDTO);
                  }
               }

               materialLossCostSummary.setWastageCostSummaryValueDTO(materialLossCostSummaryValueDTOList);
               materialLossRateCostSummary.setWastageCostSummaryValueDTO(materialLossRateCostSummaryValueDTOList);
            }
         }
      }

      materialLossCostSummary.setTotal(this.getTotal(materialLossCostSummary.getWastageCostSummaryValueDTO()));
      materialLossRateCostSummary.setTotal(BigDecimal.ZERO);
      if (lossCalculationFormula.equals(RawMaterialLossEnum.FORMULA_TWO.getType())
         && materialLossCostSummary.getTotal() != null
         && materialPickingCostSummary.getTotal() != null
         && materialPickingCostSummary.getTotal().compareTo(BigDecimal.ZERO) != 0) {
         materialLossRateCostSummary.setTotal(
            materialLossCostSummary.getTotal().divide(materialPickingCostSummary.getTotal(), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100L))
         );
      }

      if (lossCalculationFormula.equals(RawMaterialLossEnum.FORMULA_ONE.getType())
         && materialLossCostSummary.getTotal() != null
         && materialStockReturnCostSummary.getTotal() != null
         && materialStockReturnCostSummary.getTotal().compareTo(BigDecimal.ZERO) != 0) {
         materialLossRateCostSummary.setTotal(
            materialLossCostSummary.getTotal().divide(materialStockReturnCostSummary.getTotal(), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100L))
         );
      }

      costSummaryDTOS.add(partSummary);
      costSummaryDTOS.add(partSchedulingCostSummary);
      costSummaryDTOS.add(materialOutboundCostSummary);
      costSummaryDTOS.add(materialStockReturnCostSummary);
      costSummaryDTOS.add(materialPickingCostSummary);
      costSummaryDTOS.add(partCompleteCostSummary);
      costSummaryDTOS.add(materialTransferCostSummary);
      costSummaryDTOS.add(partPendingProductsCostSummary);
      costSummaryDTOS.add(materialLossCostSummary);
      costSummaryDTOS.add(materialLossRateCostSummary);
      WastageLossCostSummaryDTO assembleSummary = WastageLossCostSummaryDTO.builder().indexNumber(20).indexName("二").name("部件").build();
      costSummaryDTOS.add(assembleSummary);
      List<WastageCostSummaryValueDTO> assembleTaskWastageLossCostSummary = this.taskService
         .getTaskWastageLossCostSummary(null, workShopId, TaskTypeEnum.ASSEMBLE.getType(), minYearMonth, maxYearMonth, yearMonthDateList);
      WastageLossCostSummaryDTO assembleSchedulingCostSummary = WastageLossCostSummaryDTO.builder()
         .wastageCostSummaryValueDTO(assembleTaskWastageLossCostSummary)
         .name("部件排产")
         .indexName("2.1")
         .indexNumber(21)
         .build();
      assembleSchedulingCostSummary.setTotal(this.getTotal(assembleSchedulingCostSummary.getWastageCostSummaryValueDTO()));
      costSummaryDTOS.add(assembleSchedulingCostSummary);
      List<MesBuildingTaskProcess> taskProcesses = this.taskProcessService
         .list(
            ((((new LambdaQueryWrapper<MesBuildingTaskProcess>()
                           .eq(MesBuildingTaskProcess::getWorkshopId, workShopId))
                        .eq(MesBuildingTaskProcess::getTaskTypeEnum, TaskTypeEnum.ASSEMBLE.getType()))
                     .apply(StringUtils.isNotBlank(minYearMonth), "date_format(create_time, '%Y-%m') >= {0}", minYearMonth))
                  .apply(StringUtils.isNotBlank(maxYearMonth), "date_format(create_time, '%Y-%m') <= {0}", maxYearMonth))
               .select(MesBuildingTaskProcess::getProcessId)
         );
      BigDecimal indexName = BigDecimal.valueOf(Double.parseDouble(assembleSchedulingCostSummary.getIndexName()));
      if (CollectionUtils.isNotEmpty(taskProcesses)) {
         List<Long> assembleProcessIds = taskProcesses.stream().map(MesBuildingTaskProcess::getProcessId).distinct().collect(Collectors.toList());

         for (MesBuildingProcess process : this.processService
            .listByIds(assembleProcessIds)
            .stream()
            .sorted(Comparator.comparing(MesBuildingProcess::getSort))
            .collect(Collectors.toList())) {
            indexName = indexName.add(BigDecimal.valueOf(0.1));
            BigDecimal newIndexName = indexName;
            int newIndexNumber = Integer.parseInt(newIndexName.toString().replace(".", "0"));
            List<WastageCostSummaryValueDTO> taskProcessWastageLossCostSummary = this.taskProcessService
               .getTaskProcessWastageLossCostSummary(
                  null, workShopId, process.getId(), TaskTypeEnum.ASSEMBLE.getType(), minYearMonth, maxYearMonth, yearMonthDateList
               );
            WastageLossCostSummaryDTO assembleProcessSchedulingCostSummary = WastageLossCostSummaryDTO.builder()
               .wastageCostSummaryValueDTO(taskProcessWastageLossCostSummary)
               .name(process.getName() + "任务")
               .indexName(String.valueOf(newIndexName))
               .indexNumber(newIndexNumber)
               .build();
            assembleProcessSchedulingCostSummary.setTotal(this.getTotal(assembleProcessSchedulingCostSummary.getWastageCostSummaryValueDTO()));
            newIndexName = newIndexName.add(BigDecimal.valueOf(0.01));
            newIndexNumber = Integer.parseInt(newIndexName.toString().replace(".", "0"));
            List<WastageCostSummaryValueDTO> taskProcessCompleteWastageLossCostSummary = this.taskProcessService
               .getTaskProcessCompleteWastageLossCostSummary(
                  null, workShopId, process.getId(), TaskTypeEnum.ASSEMBLE.getType(), minYearMonth, maxYearMonth, yearMonthDateList
               );
            WastageLossCostSummaryDTO assembleProcessCompleteSchedulingCostSummary = WastageLossCostSummaryDTO.builder()
               .wastageCostSummaryValueDTO(taskProcessCompleteWastageLossCostSummary)
               .name(process.getName() + "完成")
               .indexName(String.valueOf(newIndexName))
               .indexNumber(newIndexNumber)
               .build();
            assembleProcessCompleteSchedulingCostSummary.setTotal(this.getTotal(assembleProcessCompleteSchedulingCostSummary.getWastageCostSummaryValueDTO()));
            newIndexName = newIndexName.add(BigDecimal.valueOf(0.01));
            newIndexNumber = Integer.parseInt(newIndexName.toString().replace(".", "0"));
            List<WastageCostSummaryValueDTO> taskProcessPendingProductsWastageLossCostSummary = this.taskProcessService
               .getTaskProcessPendingProductsWastageLossCostSummary(
                  null, workShopId, process.getId(), TaskTypeEnum.ASSEMBLE.getType(), minYearMonth, maxYearMonth, yearMonthDateList
               );
            if (CollectionUtils.isNotEmpty(taskProcessPendingProductsWastageLossCostSummary)) {
               taskProcessPendingProductsWastageLossCostSummary = taskProcessPendingProductsWastageLossCostSummary.stream()
                  .sorted(Comparator.comparing(WastageCostSummaryValueDTO::getYearMonth))
                  .collect(Collectors.toList());
               BigDecimal productMonthOutput = BigDecimal.ZERO;

               for (WastageCostSummaryValueDTO valueDTO : taskProcessPendingProductsWastageLossCostSummary) {
                  productMonthOutput = productMonthOutput.add(valueDTO.getProductMonthOutput() == null ? BigDecimal.ZERO : valueDTO.getProductMonthOutput());
                  valueDTO.setProductMonthOutput(productMonthOutput);
               }
            }

            taskProcessPendingProductsWastageLossCostSummary = taskProcessPendingProductsWastageLossCostSummary.stream()
               .sorted(Comparator.comparing(WastageCostSummaryValueDTO::getYearMonth).reversed())
               .collect(Collectors.toList());
            WastageLossCostSummaryDTO assembleProcessPendingProductsSchedulingCostSummary = WastageLossCostSummaryDTO.builder()
               .wastageCostSummaryValueDTO(taskProcessPendingProductsWastageLossCostSummary)
               .name(process.getName() + "在制")
               .indexName(String.valueOf(newIndexName))
               .indexNumber(newIndexNumber)
               .build();
            costSummaryDTOS.add(assembleProcessSchedulingCostSummary);
            costSummaryDTOS.add(assembleProcessCompleteSchedulingCostSummary);
            costSummaryDTOS.add(assembleProcessPendingProductsSchedulingCostSummary);
         }
      }

      indexName = indexName.add(BigDecimal.ONE);
      List<WastageCostSummaryValueDTO> assembleCompleteCostSummaryValueDTOS = this.taskService
         .getTaskCompleteWastageLossCostSummary(null, workShopId, TaskTypeEnum.ASSEMBLE.getType(), minYearMonth, maxYearMonth, yearMonthDateList);
      WastageLossCostSummaryDTO assembleCompleteCostSummary = WastageLossCostSummaryDTO.builder()
         .wastageCostSummaryValueDTO(assembleCompleteCostSummaryValueDTOS)
         .name("部件制成品")
         .indexName(String.valueOf(indexName))
         .indexNumber(Integer.parseInt(indexName.toString().replace(".", "0")))
         .build();
      assembleCompleteCostSummary.setTotal(this.getTotal(assembleCompleteCostSummary.getWastageCostSummaryValueDTO()));
      costSummaryDTOS.add(assembleCompleteCostSummary);
      WastageLossCostSummaryDTO artifactSummary = WastageLossCostSummaryDTO.builder().indexNumber(80).indexName("三").name("构件").build();
      costSummaryDTOS.add(artifactSummary);
      List<WastageCostSummaryValueDTO> artifactTaskWastageLossCostSummary = this.taskService
         .getTaskWastageLossCostSummary(null, workShopId, TaskTypeEnum.ARTIFACT.getType(), minYearMonth, maxYearMonth, yearMonthDateList);
      WastageLossCostSummaryDTO artifactSchedulingCostSummary = WastageLossCostSummaryDTO.builder()
         .wastageCostSummaryValueDTO(artifactTaskWastageLossCostSummary)
         .name("构件排产")
         .indexName("3.1")
         .indexNumber(81)
         .build();
      artifactSchedulingCostSummary.setTotal(this.getTotal(artifactSchedulingCostSummary.getWastageCostSummaryValueDTO()));
      costSummaryDTOS.add(artifactSchedulingCostSummary);
      List<MesBuildingTaskProcess> artifactTaskProcesses = this.taskProcessService
         .list(
            ((((new LambdaQueryWrapper<MesBuildingTaskProcess>()
                           .eq(MesBuildingTaskProcess::getWorkshopId, workShopId))
                        .eq(MesBuildingTaskProcess::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType()))
                     .apply(StringUtils.isNotBlank(minYearMonth), "date_format(create_time, '%Y-%m') >= {0}", minYearMonth))
                  .apply(StringUtils.isNotBlank(maxYearMonth), "date_format(create_time, '%Y-%m') <= {0}", maxYearMonth))
               .select(MesBuildingTaskProcess::getProcessId)
         );
      BigDecimal artifactIndexName = BigDecimal.valueOf(Double.parseDouble(artifactSchedulingCostSummary.getIndexName()));
      if (CollectionUtils.isNotEmpty(artifactTaskProcesses)) {
         List<Long> assembleProcessIds = artifactTaskProcesses.stream().map(MesBuildingTaskProcess::getProcessId).distinct().collect(Collectors.toList());

         for (MesBuildingProcess process : this.processService
            .listByIds(assembleProcessIds)
            .stream()
            .sorted(Comparator.comparing(MesBuildingProcess::getSort))
            .collect(Collectors.toList())) {
            artifactIndexName = artifactIndexName.add(BigDecimal.valueOf(0.1));
            BigDecimal newArtifactIndexName = artifactIndexName;
            int artifactIndexNumber = Integer.parseInt(newArtifactIndexName.toString().replace(".", "0"));
            List<WastageCostSummaryValueDTO> taskProcessWastageLossCostSummary = this.taskProcessService
               .getTaskProcessWastageLossCostSummary(
                  null, workShopId, process.getId(), TaskTypeEnum.ARTIFACT.getType(), minYearMonth, maxYearMonth, yearMonthDateList
               );
            WastageLossCostSummaryDTO artifactProcessSchedulingCostSummary = WastageLossCostSummaryDTO.builder()
               .wastageCostSummaryValueDTO(taskProcessWastageLossCostSummary)
               .name(process.getName() + "任务")
               .indexName(String.valueOf(newArtifactIndexName))
               .indexNumber(artifactIndexNumber)
               .build();
            artifactProcessSchedulingCostSummary.setTotal(this.getTotal(artifactProcessSchedulingCostSummary.getWastageCostSummaryValueDTO()));
            newArtifactIndexName = newArtifactIndexName.add(BigDecimal.valueOf(0.01));
            artifactIndexNumber = Integer.parseInt(newArtifactIndexName.toString().replace(".", "0"));
            List<WastageCostSummaryValueDTO> taskProcessCompleteWastageLossCostSummary = this.taskProcessService
               .getTaskProcessCompleteWastageLossCostSummary(
                  null, workShopId, process.getId(), TaskTypeEnum.ARTIFACT.getType(), minYearMonth, maxYearMonth, yearMonthDateList
               );
            WastageLossCostSummaryDTO artifactProcessCompleteSchedulingCostSummary = WastageLossCostSummaryDTO.builder()
               .wastageCostSummaryValueDTO(taskProcessCompleteWastageLossCostSummary)
               .name(process.getName() + "完成")
               .indexName(String.valueOf(newArtifactIndexName))
               .indexNumber(artifactIndexNumber)
               .build();
            artifactProcessCompleteSchedulingCostSummary.setTotal(this.getTotal(artifactProcessCompleteSchedulingCostSummary.getWastageCostSummaryValueDTO()));
            newArtifactIndexName = newArtifactIndexName.add(BigDecimal.valueOf(0.01));
            artifactIndexNumber = Integer.parseInt(newArtifactIndexName.toString().replace(".", "0"));
            List<WastageCostSummaryValueDTO> taskProcessPendingProductsWastageLossCostSummary = this.taskProcessService
               .getTaskProcessPendingProductsWastageLossCostSummary(
                  null, workShopId, process.getId(), TaskTypeEnum.ARTIFACT.getType(), minYearMonth, maxYearMonth, yearMonthDateList
               );
            if (CollectionUtils.isNotEmpty(taskProcessPendingProductsWastageLossCostSummary)) {
               taskProcessPendingProductsWastageLossCostSummary = taskProcessPendingProductsWastageLossCostSummary.stream()
                  .sorted(Comparator.comparing(WastageCostSummaryValueDTO::getYearMonth))
                  .collect(Collectors.toList());
               BigDecimal productMonthOutput = BigDecimal.ZERO;

               for (WastageCostSummaryValueDTO valueDTO : taskProcessPendingProductsWastageLossCostSummary) {
                  productMonthOutput = productMonthOutput.add(valueDTO.getProductMonthOutput() == null ? BigDecimal.ZERO : valueDTO.getProductMonthOutput());
                  valueDTO.setProductMonthOutput(productMonthOutput);
               }
            }

            taskProcessPendingProductsWastageLossCostSummary = taskProcessPendingProductsWastageLossCostSummary.stream()
               .sorted(Comparator.comparing(WastageCostSummaryValueDTO::getYearMonth).reversed())
               .collect(Collectors.toList());
            WastageLossCostSummaryDTO artifactProcessPendingProductsSchedulingCostSummary = WastageLossCostSummaryDTO.builder()
               .wastageCostSummaryValueDTO(taskProcessPendingProductsWastageLossCostSummary)
               .name(process.getName() + "在制")
               .indexName(String.valueOf(newArtifactIndexName))
               .indexNumber(artifactIndexNumber)
               .build();
            costSummaryDTOS.add(artifactProcessSchedulingCostSummary);
            costSummaryDTOS.add(artifactProcessCompleteSchedulingCostSummary);
            costSummaryDTOS.add(artifactProcessPendingProductsSchedulingCostSummary);
         }
      }

      indexName = indexName.add(BigDecimal.ONE);
      List<WastageCostSummaryValueDTO> artifactCompleteCostSummaryValueDTOS = this.taskService
         .getTaskCompleteWastageLossCostSummary(null, workShopId, TaskTypeEnum.ARTIFACT.getType(), minYearMonth, maxYearMonth, yearMonthDateList);
      WastageLossCostSummaryDTO artifactCompleteCostSummary = WastageLossCostSummaryDTO.builder()
         .wastageCostSummaryValueDTO(artifactCompleteCostSummaryValueDTOS)
         .name("构件制成品")
         .indexName(String.valueOf(indexName))
         .indexNumber(Integer.parseInt(indexName.toString().replace(".", "0")))
         .build();
      artifactCompleteCostSummary.setTotal(this.getTotal(artifactCompleteCostSummary.getWastageCostSummaryValueDTO()));
      costSummaryDTOS.add(artifactCompleteCostSummary);
   }

   @Override
   public PageVO<PickingDetailDTO> getPagePickingDetailDTO(
      List<LocalDateTime> dateTimeList,
      Integer lossWorkProgressStatisticsEnum,
      Long projectId,
      Long workShopId,
      Integer basicClass,
      String classifyName,
      Integer pageNumber,
      Integer pageSize
   ) {
      if (MesLossWorkProgressStatisticsEnum.RAW_MATERIAL_OUTFLOW.getType() == lossWorkProgressStatisticsEnum) {
         Page page = PageHelper.startPage(pageNumber, pageSize);
         List<OutboundDetailDO> outboundDetailList = this.reportService.getOutboundDetailList(dateTimeList, projectId, workShopId, basicClass, classifyName);
         List<PickingDetailDTO> dtoList = this.convertOutboundDetailToDTO(outboundDetailList);
         dtoList.sort(Comparator.comparing(PickingDetailDTO::getReviewPassTime, Comparator.nullsLast(Comparator.reverseOrder())));
         return new PageVO<>(page, dtoList);
      } else if (MesLossWorkProgressStatisticsEnum.RAW_MATERIAL_RETURN.getType() == lossWorkProgressStatisticsEnum) {
         Page page = PageHelper.startPage(pageNumber, pageSize);
         List<ReturnDetailDO> returnDetailList = this.reportService.getReturnDetailList(dateTimeList, projectId, workShopId, basicClass, classifyName);
         List<PickingDetailDTO> dtoList = this.convertReturnDetailToDTO(returnDetailList);
         dtoList.sort(Comparator.comparing(PickingDetailDTO::getReviewPassTime, Comparator.nullsLast(Comparator.reverseOrder())));
         return new PageVO<>(page, dtoList);
      } else if (MesLossWorkProgressStatisticsEnum.RAW_MATERIAL_REQUISITION.getType() == lossWorkProgressStatisticsEnum) {
         List<PickingDetailDTO> dtoList = new ArrayList<>();
         List<OutboundDetailDO> outboundDetailList = this.reportService.getOutboundDetailList(dateTimeList, projectId, workShopId, basicClass, classifyName);
         dtoList.addAll(this.convertOutboundDetailToDTO(outboundDetailList));
         List<ReturnDetailDO> returnDetailList = this.reportService.getReturnDetailList(dateTimeList, projectId, workShopId, basicClass, classifyName);
         dtoList.addAll(this.convertReturnDetailToDTO(returnDetailList));
         dtoList.sort(Comparator.comparing(PickingDetailDTO::getReviewPassTime, Comparator.nullsLast(Comparator.reverseOrder())));
         return PageUtil.listPage(pageNumber, pageSize, dtoList);
      } else {
         throw new BusinessException("枚举类型不存在");
      }
   }

   @Override
   public void downloadPickingDetailDTO(
      List<LocalDateTime> dateTimeList,
      Integer lossWorkProgressStatisticsEnum,
      Long projectId,
      Long workShopId,
      Integer basicClass,
      String classifyName,
      HttpServletResponse response
   ) {
      List<PickingDetailDTO> dtoList = new ArrayList<>();
      if (MesLossWorkProgressStatisticsEnum.RAW_MATERIAL_OUTFLOW.getType() == lossWorkProgressStatisticsEnum) {
         List<OutboundDetailDO> outboundDetailList = this.reportService.getOutboundDetailList(dateTimeList, projectId, workShopId, basicClass, classifyName);
         dtoList.addAll(this.convertOutboundDetailToDTO(outboundDetailList));
      }

      if (MesLossWorkProgressStatisticsEnum.RAW_MATERIAL_RETURN.getType() == lossWorkProgressStatisticsEnum) {
         List<ReturnDetailDO> returnDetailList = this.reportService.getReturnDetailList(dateTimeList, projectId, workShopId, basicClass, classifyName);
         dtoList.addAll(this.convertReturnDetailToDTO(returnDetailList));
      }

      if (MesLossWorkProgressStatisticsEnum.RAW_MATERIAL_REQUISITION.getType() == lossWorkProgressStatisticsEnum) {
         List<OutboundDetailDO> outboundDetailList = this.reportService.getOutboundDetailList(dateTimeList, projectId, workShopId, basicClass, classifyName);
         dtoList.addAll(this.convertOutboundDetailToDTO(outboundDetailList));
         List<ReturnDetailDO> returnDetailList = this.reportService.getReturnDetailList(dateTimeList, projectId, workShopId, basicClass, classifyName);
         dtoList.addAll(this.convertReturnDetailToDTO(returnDetailList));
      }

      dtoList.sort(Comparator.comparing(PickingDetailDTO::getReviewPassTime, Comparator.nullsLast(Comparator.reverseOrder())));
      AtomicInteger index = new AtomicInteger(0);
      List<List<String>> headList = new ArrayList<>();
      headList.add(Arrays.asList("序号"));
      headList.add(Arrays.asList("业务类型"));
      headList.add(Arrays.asList("材料类型"));
      headList.add(Arrays.asList("项目"));
      headList.add(Arrays.asList("出/退库日期"));
      headList.add(Arrays.asList("出/退库编号"));
      headList.add(Arrays.asList("领用车间"));
      headList.add(Arrays.asList("领用人"));
      headList.add(Arrays.asList("物料种类"));
      headList.add(Arrays.asList("规格"));
      headList.add(Arrays.asList("材质/型号"));
      headList.add(Arrays.asList("数量"));
      headList.add(Arrays.asList("计量单位"));
      headList.add(Arrays.asList("核算量"));
      headList.add(Arrays.asList("核算单位"));
      List<List<Object>> dataList = new ArrayList<>();
      dtoList.forEach(ex -> {
         List<Object> data = new ArrayList<>();
         data.add(index.incrementAndGet());
         data.add(MesLossWorkProgressStatisticsEnum.RAW_MATERIAL_OUTFLOW.getType() == ex.getLossWorkProgressStatisticsEnum() ? "出库" : "退库");
         data.add(BasicClassEnum.getNameByType(ex.getBasicClass()));
         data.add(StrUtil.isNotBlank(ex.getProjectName()) ? ex.getProjectName() : "-");
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
         data.add(ex.getReviewPassTime() != null ? ex.getReviewPassTime().format(formatter) : "-");
         data.add(StrUtil.isNotBlank(ex.getSerialNumber()) ? ex.getSerialNumber() : "-");
         data.add(StrUtil.isNotBlank(ex.getUseWorkshop()) ? ex.getUseWorkshop() : "-");
         data.add(StrUtil.isNotBlank(ex.getReceivePerson()) ? ex.getReceivePerson() : "-");
         data.add(StrUtil.isNotBlank(ex.getClassifyName()) ? ex.getClassifyName() : "-");
         data.add(StrUtil.isNotBlank(ex.getSpec()) ? ex.getSpec() : "-");
         data.add(StrUtil.isNotBlank(ex.getMaterial()) ? ex.getMaterial() : "-");
         data.add(ex.getQuantity());
         data.add(ex.getMeasureUnit());
         data.add(ex.getMete());
         data.add(ex.getAccountingUnit());
         dataList.add(data);
      });

      try {
         response.reset();
         response.setContentType("application/vnd.ms-excel;charset=utf-8");
         String fileName = StrUtil.concat(true, "领用详情表.xlsx");
         response.setHeader("Access-Control-Allow-Origin", "*");
         response.setHeader("Access-Control-Expose-Headers", "*");
         response.setCharacterEncoding("UTF-8");
         response.setHeader("content-Type", "application/vnd.ms-excel");
         response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
         response.setHeader("Access-Control-Expose-Headers", "*");
         response.setHeader("Result", "code=" + ResultCodeEnum.SUCCESS.getCode() + ";message=" + ResultCodeEnum.SUCCESS.getCode());
         EasyExcel.write(response.getOutputStream())
            .head(headList)
            .registerWriteHandler(new SimpleColumnWidthStyleStrategy(15))
            .registerWriteHandler(new HorizontalCellStyleStrategy(new WriteCellStyle() {
               {
                  this.setHorizontalAlignment(HorizontalAlignment.CENTER);
                  this.setVerticalAlignment(VerticalAlignment.CENTER);
               }
            }, new WriteCellStyle() {
               {
                  this.setHorizontalAlignment(HorizontalAlignment.CENTER);
                  this.setVerticalAlignment(VerticalAlignment.CENTER);
                  this.setBorderBottom(BorderStyle.THIN);
                  this.setBorderLeft(BorderStyle.THIN);
                  this.setBorderRight(BorderStyle.THIN);
                  this.setBorderTop(BorderStyle.THIN);
               }
            }))
            .sheet("领用详情表")
            .doWrite(dataList);
      } catch (Exception e) {
         throw new RuntimeException(e.getMessage());
      }
   }

   @Override
   public HashMap<String, BigDecimal> getPickingSummary(
      List<LocalDateTime> dateTimeList, Integer lossWorkProgressStatisticsEnum, Long projectId, Long workShopId, Integer basicClass, String classifyName
   ) {
      HashMap<String, BigDecimal> map = new HashMap<>();
      List<OutboundDetailDO> outboundDetailList = this.reportService.getOutboundDetailList(dateTimeList, projectId, workShopId, basicClass, classifyName);
      List<ReturnDetailDO> returnDetailList = this.reportService.getReturnDetailList(dateTimeList, projectId, workShopId, basicClass, classifyName);
      BigDecimal outboundMete = outboundDetailList.stream()
         .map(OutboundDetailDO::getMete)
         .reduce(BigDecimal.ZERO, BigDecimal::add)
         .divide(BigDecimal.valueOf(1000000L), 4);
      BigDecimal returnMete = returnDetailList.stream()
         .map(ReturnDetailDO::getMete)
         .reduce(BigDecimal.ZERO, BigDecimal::add)
         .divide(BigDecimal.valueOf(1000000L), 4);
      map.put("outboundMete", outboundMete);
      map.put("returnMete", returnMete);
      map.put("pickingMete", outboundMete.subtract(returnMete));
      return map;
   }

   private Map<Integer, BigDecimal> unitConversion(BigDecimal value, String unit, Integer scale) {
      Unit u = this.unitService.getOne((Wrapper<Unit>)Wrappers.<Unit>lambdaQuery().eq(Unit::getName, unit));
      Map<Integer, BigDecimal> map = new HashMap<>();
      if (UnitEnum.DIGIT.getType().equals(u.getType())) {
         map.put(1, new BigDecimal(value.stripTrailingZeros().toPlainString()));
         map.put(2, BigDecimal.ONE);
      } else {
         BigDecimal precision = UnitsPrecisionEnum.getByName(unit);
         map.put(1, value.divide(precision, scale, 4));
         map.put(2, precision);
      }

      return map;
   }

   private List<PickingDetailDTO> convertReturnDetailToDTO(List<ReturnDetailDO> returnDetailList) {
      if (CollectionUtils.isEmpty(returnDetailList)) {
         return new ArrayList<>();
      }

      List<Long> classifyIds = returnDetailList.stream().map(ReturnDetailDO::getClassifyId).distinct().collect(Collectors.toList());
      Map<Long, String> classNameMap = this.classificationService
         .listByIds(classifyIds)
         .stream()
         .collect(Collectors.toMap(Classification::getId, Classification::getName));
      return returnDetailList.stream()
         .map(
            e -> {
               PickingDetailDTO detailDTO = com.hzchum.pangu.common.util.BeanUtil.copy(e, PickingDetailDTO.class);
               detailDTO.setLossWorkProgressStatisticsEnum(MesLossWorkProgressStatisticsEnum.RAW_MATERIAL_RETURN.getType());
               if (e.getProject() != null) {
                  detailDTO.setProjectName(e.getProject().getName());
               }

               if (e.getWorkshop() != null) {
                  detailDTO.setUseWorkshop(e.getWorkshop().getName());
               }

               if (e.getReturnReceipt() != null) {
                  detailDTO.setReviewPassTime(e.getReturnReceipt().getReturnTime());
                  detailDTO.setSerialNumber(e.getReturnReceipt().getSerialNumber());
               }

               detailDTO.setClassifyName(classNameMap.getOrDefault(e.getClassifyId(), null));
               SubjectMeasureDTO subjectMeasureDTO = this.measureService.measureListById(e.getClassifyId());
               if (subjectMeasureDTO != null) {
                  detailDTO.setAccountingUnit(subjectMeasureDTO.getAccountingUnit());
                  detailDTO.setMeasureUnit(subjectMeasureDTO.getMeasureUnit());
                  Map<Integer, BigDecimal> unitConversion = this.unitConversion(
                     BigDecimal.ZERO, subjectMeasureDTO.getMeasureUnit(), subjectMeasureDTO.getMeasurePrecision()
                  );
                  BigDecimal convertQuantity = e.getQuantity().divide(unitConversion.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
                  Map<Integer, BigDecimal> unitConversion2 = this.unitConversion(
                     BigDecimal.ZERO, subjectMeasureDTO.getAccountingUnit(), subjectMeasureDTO.getAccountingPrecision()
                  );
                  BigDecimal convertMete = e.getMete().divide(unitConversion2.get(2), subjectMeasureDTO.getAccountingPrecision(), RoundingMode.HALF_UP);
                  detailDTO.setQuantity(convertQuantity);
                  detailDTO.setMete(convertMete);
               }

               DownLoadDetailDO detailDO = com.hzchum.pangu.common.util.BeanUtil.copy(e, DownLoadDetailDO.class);
               StringBuilder sb = new StringBuilder();
               StringBuilder lengths = new StringBuilder();
               StringBuilder material = new StringBuilder();
               this.setSpecs(detailDO, sb, lengths, material);
               detailDTO.setSpec(sb.toString());
               detailDTO.setMaterial(material.toString());
               return detailDTO;
            }
         )
         .collect(Collectors.toList());
   }

   private List<PickingDetailDTO> convertOutboundDetailToDTO(List<OutboundDetailDO> outboundDetailList) {
      if (CollectionUtils.isEmpty(outboundDetailList)) {
         return new ArrayList<>();
      }

      List<Long> classifyIds = outboundDetailList.stream().map(OutboundDetailDO::getClassifyId).distinct().collect(Collectors.toList());
      Map<Long, String> classNameMap = this.classificationService
         .listByIds(classifyIds)
         .stream()
         .collect(Collectors.toMap(Classification::getId, Classification::getName));
      return outboundDetailList.stream()
         .map(
            e -> {
               PickingDetailDTO detailDTO = com.hzchum.pangu.common.util.BeanUtil.copy(e, PickingDetailDTO.class);
               detailDTO.setLossWorkProgressStatisticsEnum(MesLossWorkProgressStatisticsEnum.RAW_MATERIAL_OUTFLOW.getType());
               if (e.getProject() != null) {
                  detailDTO.setProjectName(e.getProject().getName());
               }

               if (e.getMesWorkshop() != null) {
                  detailDTO.setUseWorkshop(e.getMesWorkshop().getName());
               }

               if (e.getOutboundReceipt() != null) {
                  detailDTO.setReviewPassTime(e.getOutboundReceipt().getOutboundTime());
                  detailDTO.setSerialNumber(e.getOutboundReceipt().getSerialNumber());
               }

               detailDTO.setClassifyName(classNameMap.getOrDefault(e.getClassifyId(), null));
               detailDTO.setReceivePerson(e.getRecipientName());
               SubjectMeasureDTO subjectMeasureDTO = this.measureService.measureListById(e.getClassifyId());
               if (subjectMeasureDTO != null) {
                  detailDTO.setAccountingUnit(subjectMeasureDTO.getAccountingUnit());
                  detailDTO.setMeasureUnit(subjectMeasureDTO.getMeasureUnit());
                  Map<Integer, BigDecimal> unitConversion = this.unitConversion(
                     BigDecimal.ZERO, subjectMeasureDTO.getMeasureUnit(), subjectMeasureDTO.getMeasurePrecision()
                  );
                  BigDecimal convertQuantity = e.getQuantity().divide(unitConversion.get(2), subjectMeasureDTO.getMeasurePrecision(), RoundingMode.HALF_UP);
                  Map<Integer, BigDecimal> unitConversion2 = this.unitConversion(
                     BigDecimal.ZERO, subjectMeasureDTO.getAccountingUnit(), subjectMeasureDTO.getAccountingPrecision()
                  );
                  BigDecimal convertMete = e.getMete().divide(unitConversion2.get(2), subjectMeasureDTO.getAccountingPrecision(), RoundingMode.HALF_UP);
                  detailDTO.setQuantity(convertQuantity);
                  detailDTO.setMete(convertMete);
               }

               DownLoadDetailDO detailDO = com.hzchum.pangu.common.util.BeanUtil.copy(e, DownLoadDetailDO.class);
               StringBuilder sb = new StringBuilder();
               StringBuilder lengths = new StringBuilder();
               StringBuilder material = new StringBuilder();
               this.setSpecs(detailDO, sb, lengths, material);
               detailDTO.setSpec(sb.toString());
               detailDTO.setMaterial(material.toString());
               return detailDTO;
            }
         )
         .collect(Collectors.toList());
   }

   private void setSpecs(DownLoadDetailDO detailDO, StringBuilder sb, StringBuilder lengths, StringBuilder material) {
      String thickness = detailDO.getThickness() != null ? detailDO.getThickness().stripTrailingZeros().toPlainString() : null;
      String width = detailDO.getWidth() != null ? detailDO.getWidth().stripTrailingZeros().toPlainString() : null;
      String length = detailDO.getLength() != null ? detailDO.getLength().stripTrailingZeros().toPlainString() : null;
      boolean b = StrUtil.isNotBlank(detailDO.getSpecification());
      if (BasicClassEnum.STEEL_PLATE.getType().equals(detailDO.getBasicClass())) {
         sb.append(thickness);
         if (width != null) {
            sb.append("*").append(width);
         }

         if (length != null) {
            sb.append("*").append(length);
         }

         lengths.append(length);
         material.append(StrUtil.isNotBlank(detailDO.getSpecification()) ? detailDO.getSpecification() : "-");
      } else if (BasicClassEnum.SECTION_STEEL.getType().equals(detailDO.getBasicClass())) {
         lengths = lengths.append(length);
         if (b && detailDO.getSpecification().contains("*")) {
            int index = detailDO.getSpecification().lastIndexOf("*");
            if (index != -1) {
               String result = detailDO.getSpecification().substring(0, index);
               sb.append(result);
            }

            String[] parts = detailDO.getSpecification().split("\\*");
            String lastPart = parts[parts.length - 1];
            material.append(StrUtil.isNotBlank(lastPart) ? lastPart : "-");
         }
      } else if (BasicClassEnum.COLOR_ROLL.getType().equals(detailDO.getBasicClass())) {
         sb.append(thickness).append("*").append(width);
         if (b) {
            if (detailDO.getSpecification().contains("*")) {
               int index = detailDO.getSpecification().lastIndexOf("*");
               if (index != -1) {
                  String result = detailDO.getSpecification().substring(0, index);
                  sb.append(result);
               }

               String[] parts = detailDO.getSpecification().split("\\*");
               String lastPart = parts[parts.length - 1];
               material.append(lastPart);
            } else {
               material.append(detailDO.getSpecification());
            }
         }

         if (StrUtil.isNotBlank(detailDO.getColor())) {
            sb.append(" * ").append(detailDO.getColor());
         }
      } else if (BasicClassEnum.checkNotSteel(detailDO.getBasicClass())) {
         if (StrUtil.isNotBlank(detailDO.getSpecification())) {
            sb.append(detailDO.getSpecification());
            if (StrUtil.isNotBlank(detailDO.getColor())) {
               sb.append(" * ").append(detailDO.getColor());
            }
         } else if (StrUtil.isNotBlank(detailDO.getColor())) {
            sb.append(detailDO.getColor());
         }
      }
   }

   @Override
   public void getWastageLossCostSummaryByproject(Long projectId, List<WastageLossCostSummaryDTO> costSummaryDTOS, Integer lossCalculationFormula) {
      List<LocalDate> yearMonthDateList = this.getYearMonthDateList(projectId);
      WastageLossCostSummaryDTO firstCostSummaryDTO = this.getFirstByProject(yearMonthDateList);
      costSummaryDTOS.add(firstCostSummaryDTO);
      WastageLossCostSummaryDTO partSummary = WastageLossCostSummaryDTO.builder().indexNumber(10).indexName("一").name("零件").build();
      List<WastageCostSummaryValueDTO> taskWastageLossCostSummary = this.taskService
         .getTaskWastageLossCostSummary(projectId, null, TaskTypeEnum.MACHINE_PART.getType(), null, null, yearMonthDateList);
      WastageLossCostSummaryDTO partSchedulingCostSummary = WastageLossCostSummaryDTO.builder()
         .wastageCostSummaryValueDTO(taskWastageLossCostSummary)
         .name("零件排产")
         .indexName("1.1")
         .indexNumber(11)
         .build();
      partSchedulingCostSummary.setTotal(this.getTotal(partSchedulingCostSummary.getWastageCostSummaryValueDTO()));
      List<WastageCostSummaryValueDTO> outboundSummaryList = this.reportService.getGroupByMonthOutboundSummary(projectId, null, null, null, yearMonthDateList);
      WastageLossCostSummaryDTO materialOutboundCostSummary = WastageLossCostSummaryDTO.builder()
         .wastageCostSummaryValueDTO(outboundSummaryList)
         .name("原料出库量")
         .indexName("1.2")
         .indexNumber(12)
         .build();
      materialOutboundCostSummary.setTotal(this.getTotal(materialOutboundCostSummary.getWastageCostSummaryValueDTO()));
      WastageLossCostSummaryDTO materialFeedingCostSummary = WastageLossCostSummaryDTO.builder()
         .wastageCostSummaryValueDTO(null)
         .name("原料投料")
         .indexName("1.3")
         .indexNumber(13)
         .build();
      materialFeedingCostSummary.setTotal(this.getTotal(materialFeedingCostSummary.getWastageCostSummaryValueDTO()));
      List<WastageCostSummaryValueDTO> returnSummaryList = this.reportService.getGroupByMonthReturnSummary(projectId, null, null, null, yearMonthDateList);
      WastageLossCostSummaryDTO materialStockReturnCostSummary = WastageLossCostSummaryDTO.builder()
         .wastageCostSummaryValueDTO(returnSummaryList)
         .name("原料退库量")
         .indexName("1.4")
         .indexNumber(14)
         .build();
      materialStockReturnCostSummary.setTotal(this.getTotal(materialStockReturnCostSummary.getWastageCostSummaryValueDTO()));
      List<WastageCostSummaryValueDTO> pickingSummaryList = this.getGroupByMonthPickingSummary(yearMonthDateList, outboundSummaryList, returnSummaryList);
      WastageLossCostSummaryDTO materialPickingCostSummary = WastageLossCostSummaryDTO.builder()
         .wastageCostSummaryValueDTO(pickingSummaryList)
         .name("原料实际领料")
         .indexName("1.5")
         .indexNumber(15)
         .build();
      materialPickingCostSummary.setTotal(this.getTotal(materialPickingCostSummary.getWastageCostSummaryValueDTO()));
      List<WastageCostSummaryValueDTO> completeCostSummaryValueDTOS = this.taskService
         .getTaskCompleteWastageLossCostSummary(projectId, null, TaskTypeEnum.MACHINE_PART.getType(), null, null, yearMonthDateList);
      WastageLossCostSummaryDTO partCompleteCostSummary = WastageLossCostSummaryDTO.builder()
         .wastageCostSummaryValueDTO(completeCostSummaryValueDTOS)
         .name("零件制成品")
         .indexName("1.6")
         .indexNumber(16)
         .build();
      partCompleteCostSummary.setTotal(this.getTotal(partCompleteCostSummary.getWastageCostSummaryValueDTO()));
      List<WastageCostSummaryValueDTO> partsAllocationWastageLossCostSummary = this.taskService
         .getPartsAllocationWastageLossCostSummary(
            projectId,
            null,
            TaskTypeEnum.MACHINE_PART.getType(),
            null,
            null,
            yearMonthDateList,
            Arrays.asList(MachinePartRelationTypeEnum.FOR_ARTIFACT.getType(), MachinePartRelationTypeEnum.FOR_ASSEMBLE.getType())
         );
      WastageLossCostSummaryDTO materialTransferCostSummary = WastageLossCostSummaryDTO.builder()
         .wastageCostSummaryValueDTO(partsAllocationWastageLossCostSummary)
         .name("零件调拨")
         .indexName("1.7")
         .indexNumber(17)
         .build();
      materialTransferCostSummary.setTotal(this.getTotal(materialTransferCostSummary.getWastageCostSummaryValueDTO()));
      List<WastageCostSummaryValueDTO> taskPendingProductsWastageLossCostSummary = this.taskService
         .getTaskPendingProductsWastageLossCostSummary(projectId, null, TaskTypeEnum.MACHINE_PART.getType(), null, null, yearMonthDateList);
      if (CollectionUtils.isNotEmpty(taskPendingProductsWastageLossCostSummary)) {
         taskPendingProductsWastageLossCostSummary = taskPendingProductsWastageLossCostSummary.stream()
            .sorted(Comparator.comparing(WastageCostSummaryValueDTO::getYearMonth))
            .collect(Collectors.toList());
         BigDecimal productMonthOutput = BigDecimal.ZERO;

         for (WastageCostSummaryValueDTO valueDTO : taskPendingProductsWastageLossCostSummary) {
            productMonthOutput = productMonthOutput.add(valueDTO.getProductMonthOutput() == null ? BigDecimal.ZERO : valueDTO.getProductMonthOutput());
            valueDTO.setProductMonthOutput(productMonthOutput);
         }
      }

      WastageLossCostSummaryDTO partPendingProductsCostSummary = WastageLossCostSummaryDTO.builder()
         .wastageCostSummaryValueDTO(taskPendingProductsWastageLossCostSummary)
         .name("零件待制品")
         .indexName("1.8")
         .indexNumber(18)
         .build();
      WastageLossCostSummaryDTO materialLossCostSummary = WastageLossCostSummaryDTO.builder()
         .wastageCostSummaryValueDTO(null)
         .name("原料损耗")
         .indexName("1.9")
         .indexNumber(19)
         .build();
      WastageLossCostSummaryDTO materialLossRateCostSummary = WastageLossCostSummaryDTO.builder()
         .wastageCostSummaryValueDTO(null)
         .name("损耗率")
         .indexName("1.9.1")
         .indexNumber(191)
         .build();
      List<WastageCostSummaryValueDTO> wastageCostSummaryValueDTOList = firstCostSummaryDTO.getWastageCostSummaryValueDTO();
      if (CollectionUtils.isNotEmpty(wastageCostSummaryValueDTOList)) {
         if (lossCalculationFormula.equals(RawMaterialLossEnum.FORMULA_ONE.getType())) {
            List<WastageCostSummaryValueDTO> wastageCostSummaryValueDTO = materialFeedingCostSummary.getWastageCostSummaryValueDTO();
            if (CollectionUtils.isNotEmpty(wastageCostSummaryValueDTO)) {
               List<WastageCostSummaryValueDTO> materialLossCostSummaryValueDTOList = new ArrayList<>();
               List<WastageCostSummaryValueDTO> materialLossRateCostSummaryValueDTOList = new ArrayList<>();
               Map<String, WastageCostSummaryValueDTO> wastageCostSummaryValueMap = wastageCostSummaryValueDTO.stream()
                  .collect(Collectors.toMap(WastageCostSummaryValueDTO::getYearMonth, Function.identity()));
               Map<String, WastageCostSummaryValueDTO> partCompleteCostSummaryValueMap = completeCostSummaryValueDTOS.stream()
                  .collect(Collectors.toMap(WastageCostSummaryValueDTO::getYearMonth, Function.identity()));

               for (WastageCostSummaryValueDTO costSummaryValueDTO : wastageCostSummaryValueDTOList) {
                  WastageCostSummaryValueDTO wastageCostSummaryValue = wastageCostSummaryValueMap.get(costSummaryValueDTO.getYearMonth());
                  WastageCostSummaryValueDTO partCompleteCostSummaryValue = partCompleteCostSummaryValueMap.get(costSummaryValueDTO.getYearMonth());
                  if (wastageCostSummaryValue != null) {
                     WastageCostSummaryValueDTO valueDTO = WastageCostSummaryValueDTO.builder()
                        .yearMonth(costSummaryValueDTO.getYearMonth())
                        .productMonthOutput(
                           wastageCostSummaryValue.getProductMonthOutput()
                              .subtract(
                                 partCompleteCostSummaryValue != null && partCompleteCostSummaryValue.getProductMonthOutput() != null
                                    ? partCompleteCostSummaryValue.getProductMonthOutput()
                                    : BigDecimal.ZERO
                              )
                        )
                        .build();
                     materialLossCostSummaryValueDTOList.add(valueDTO);
                     WastageCostSummaryValueDTO LossRateValueDTO = WastageCostSummaryValueDTO.builder().yearMonth(costSummaryValueDTO.getYearMonth()).build();
                     if (valueDTO.getProductMonthOutput().compareTo(BigDecimal.ZERO) != 0
                        && wastageCostSummaryValue.getProductMonthOutput().compareTo(BigDecimal.ZERO) != 0) {
                        LossRateValueDTO.setProductMonthOutput(
                           valueDTO.getProductMonthOutput()
                              .divide(wastageCostSummaryValue.getProductMonthOutput(), 3, RoundingMode.HALF_UP)
                              .multiply(BigDecimal.valueOf(100L))
                        );
                     }

                     materialLossRateCostSummaryValueDTOList.add(LossRateValueDTO);
                  }
               }

               materialLossCostSummary.setWastageCostSummaryValueDTO(materialLossCostSummaryValueDTOList);
               materialLossRateCostSummary.setWastageCostSummaryValueDTO(materialLossRateCostSummaryValueDTOList);
            }
         }

         if (lossCalculationFormula.equals(RawMaterialLossEnum.FORMULA_TWO.getType())) {
            List<WastageCostSummaryValueDTO> wastageCostSummaryValueDTO = materialPickingCostSummary.getWastageCostSummaryValueDTO();
            if (CollectionUtils.isNotEmpty(wastageCostSummaryValueDTO)) {
               List<WastageCostSummaryValueDTO> materialLossCostSummaryValueDTOList = new ArrayList<>();
               List<WastageCostSummaryValueDTO> materialLossRateCostSummaryValueDTOList = new ArrayList<>();
               Map<String, WastageCostSummaryValueDTO> wastageCostSummaryValueMap = wastageCostSummaryValueDTO.stream()
                  .collect(Collectors.toMap(WastageCostSummaryValueDTO::getYearMonth, Function.identity()));
               Map<String, WastageCostSummaryValueDTO> partCompleteCostSummaryValueMap = completeCostSummaryValueDTOS.stream()
                  .collect(Collectors.toMap(WastageCostSummaryValueDTO::getYearMonth, Function.identity()));

               for (WastageCostSummaryValueDTO costSummaryValueDTO : wastageCostSummaryValueDTOList) {
                  WastageCostSummaryValueDTO wastageCostSummaryValue = wastageCostSummaryValueMap.get(costSummaryValueDTO.getYearMonth());
                  WastageCostSummaryValueDTO partCompleteCostSummaryValue = partCompleteCostSummaryValueMap.get(costSummaryValueDTO.getYearMonth());
                  if (wastageCostSummaryValue != null) {
                     WastageCostSummaryValueDTO valueDTO = WastageCostSummaryValueDTO.builder()
                        .yearMonth(costSummaryValueDTO.getYearMonth())
                        .productMonthOutput(
                           wastageCostSummaryValue.getProductMonthOutput()
                              .subtract(
                                 partCompleteCostSummaryValue != null && partCompleteCostSummaryValue.getProductMonthOutput() != null
                                    ? partCompleteCostSummaryValue.getProductMonthOutput()
                                    : BigDecimal.ZERO
                              )
                        )
                        .build();
                     materialLossCostSummaryValueDTOList.add(valueDTO);
                     WastageCostSummaryValueDTO LossRateValueDTO = WastageCostSummaryValueDTO.builder().yearMonth(costSummaryValueDTO.getYearMonth()).build();
                     if (valueDTO.getProductMonthOutput().compareTo(BigDecimal.ZERO) != 0
                        && wastageCostSummaryValue.getProductMonthOutput().compareTo(BigDecimal.ZERO) != 0) {
                        LossRateValueDTO.setProductMonthOutput(
                           valueDTO.getProductMonthOutput()
                              .divide(wastageCostSummaryValue.getProductMonthOutput(), 3, RoundingMode.HALF_UP)
                              .multiply(BigDecimal.valueOf(100L))
                        );
                     }

                     materialLossRateCostSummaryValueDTOList.add(LossRateValueDTO);
                  }
               }

               materialLossCostSummary.setWastageCostSummaryValueDTO(materialLossCostSummaryValueDTOList);
               materialLossRateCostSummary.setWastageCostSummaryValueDTO(materialLossRateCostSummaryValueDTOList);
            }
         }
      }

      materialLossRateCostSummary.setTotal(BigDecimal.ZERO);
      if (lossCalculationFormula.equals(RawMaterialLossEnum.FORMULA_TWO.getType())
         && materialLossCostSummary.getTotal() != null
         && materialPickingCostSummary.getTotal() != null
         && materialPickingCostSummary.getTotal().compareTo(BigDecimal.ZERO) != 0) {
         materialLossRateCostSummary.setTotal(
            materialLossCostSummary.getTotal().divide(materialPickingCostSummary.getTotal(), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100L))
         );
      }

      if (lossCalculationFormula.equals(RawMaterialLossEnum.FORMULA_ONE.getType())
         && materialLossCostSummary.getTotal() != null
         && materialStockReturnCostSummary.getTotal() != null
         && materialStockReturnCostSummary.getTotal().compareTo(BigDecimal.ZERO) != 0) {
         materialLossRateCostSummary.setTotal(
            materialLossCostSummary.getTotal().divide(materialStockReturnCostSummary.getTotal(), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100L))
         );
      }

      materialLossCostSummary.setTotal(this.getTotal(materialLossCostSummary.getWastageCostSummaryValueDTO()));
      costSummaryDTOS.add(partSummary);
      costSummaryDTOS.add(partSchedulingCostSummary);
      costSummaryDTOS.add(materialOutboundCostSummary);
      costSummaryDTOS.add(materialStockReturnCostSummary);
      costSummaryDTOS.add(materialPickingCostSummary);
      costSummaryDTOS.add(partCompleteCostSummary);
      costSummaryDTOS.add(materialTransferCostSummary);
      costSummaryDTOS.add(partPendingProductsCostSummary);
      costSummaryDTOS.add(materialLossCostSummary);
      costSummaryDTOS.add(materialLossRateCostSummary);
      WastageLossCostSummaryDTO assembleSummary = WastageLossCostSummaryDTO.builder().indexNumber(20).indexName("二").name("部件").build();
      costSummaryDTOS.add(assembleSummary);
      List<WastageCostSummaryValueDTO> assembleTaskWastageLossCostSummary = this.taskService
         .getTaskWastageLossCostSummary(projectId, null, TaskTypeEnum.ASSEMBLE.getType(), null, null, yearMonthDateList);
      WastageLossCostSummaryDTO assembleSchedulingCostSummary = WastageLossCostSummaryDTO.builder()
         .wastageCostSummaryValueDTO(assembleTaskWastageLossCostSummary)
         .name("部件排产")
         .indexName("2.1")
         .indexNumber(21)
         .build();
      assembleSchedulingCostSummary.setTotal(this.getTotal(assembleSchedulingCostSummary.getWastageCostSummaryValueDTO()));
      costSummaryDTOS.add(assembleSchedulingCostSummary);
      List<MesBuildingTaskProcess> taskProcesses = this.taskProcessService
         .list(
            ((new LambdaQueryWrapper<MesBuildingTaskProcess>().eq(MesBuildingTaskProcess::getProjectId, projectId))
                  .eq(MesBuildingTaskProcess::getTaskTypeEnum, TaskTypeEnum.ASSEMBLE.getType()))
               .select(MesBuildingTaskProcess::getProcessId)
         );
      BigDecimal indexName = BigDecimal.valueOf(Double.parseDouble(assembleSchedulingCostSummary.getIndexName()));
      if (CollectionUtils.isNotEmpty(taskProcesses)) {
         List<Long> assembleProcessIds = taskProcesses.stream().map(MesBuildingTaskProcess::getProcessId).distinct().collect(Collectors.toList());

         for (MesBuildingProcess process : this.processService
            .listByIds(assembleProcessIds)
            .stream()
            .sorted(Comparator.comparing(MesBuildingProcess::getSort))
            .collect(Collectors.toList())) {
            indexName = indexName.add(BigDecimal.valueOf(0.1));
            BigDecimal newIndexName = indexName;
            int newIndexNumber = Integer.parseInt(newIndexName.toString().replace(".", "0"));
            List<WastageCostSummaryValueDTO> taskProcessWastageLossCostSummary = this.taskProcessService
               .getTaskProcessWastageLossCostSummary(projectId, null, process.getId(), TaskTypeEnum.ASSEMBLE.getType(), null, null, yearMonthDateList);
            WastageLossCostSummaryDTO assembleProcessSchedulingCostSummary = WastageLossCostSummaryDTO.builder()
               .wastageCostSummaryValueDTO(taskProcessWastageLossCostSummary)
               .name(process.getName() + "任务")
               .indexName(String.valueOf(newIndexName))
               .indexNumber(newIndexNumber)
               .build();
            assembleProcessSchedulingCostSummary.setTotal(this.getTotal(assembleProcessSchedulingCostSummary.getWastageCostSummaryValueDTO()));
            newIndexName = newIndexName.add(BigDecimal.valueOf(0.01));
            newIndexNumber = Integer.parseInt(newIndexName.toString().replace(".", "0"));
            List<WastageCostSummaryValueDTO> taskProcessCompleteWastageLossCostSummary = this.taskProcessService
               .getTaskProcessCompleteWastageLossCostSummary(projectId, null, process.getId(), TaskTypeEnum.ASSEMBLE.getType(), null, null, yearMonthDateList);
            WastageLossCostSummaryDTO assembleProcessCompleteSchedulingCostSummary = WastageLossCostSummaryDTO.builder()
               .wastageCostSummaryValueDTO(taskProcessCompleteWastageLossCostSummary)
               .name(process.getName() + "完成")
               .indexName(String.valueOf(newIndexName))
               .indexNumber(newIndexNumber)
               .build();
            assembleProcessCompleteSchedulingCostSummary.setTotal(this.getTotal(assembleProcessCompleteSchedulingCostSummary.getWastageCostSummaryValueDTO()));
            newIndexName = newIndexName.add(BigDecimal.valueOf(0.01));
            newIndexNumber = Integer.parseInt(newIndexName.toString().replace(".", "0"));
            List<WastageCostSummaryValueDTO> taskProcessPendingProductsWastageLossCostSummary = this.taskProcessService
               .getTaskProcessPendingProductsWastageLossCostSummary(
                  projectId, null, process.getId(), TaskTypeEnum.ASSEMBLE.getType(), null, null, yearMonthDateList
               );
            if (CollectionUtils.isNotEmpty(taskProcessPendingProductsWastageLossCostSummary)) {
               taskProcessPendingProductsWastageLossCostSummary = taskProcessPendingProductsWastageLossCostSummary.stream()
                  .sorted(Comparator.comparing(WastageCostSummaryValueDTO::getYearMonth))
                  .collect(Collectors.toList());
               BigDecimal productMonthOutput = BigDecimal.ZERO;

               for (WastageCostSummaryValueDTO valueDTO : taskProcessPendingProductsWastageLossCostSummary) {
                  productMonthOutput = productMonthOutput.add(valueDTO.getProductMonthOutput() == null ? BigDecimal.ZERO : valueDTO.getProductMonthOutput());
                  valueDTO.setProductMonthOutput(productMonthOutput);
               }
            }

            WastageLossCostSummaryDTO assembleProcessPendingProductsSchedulingCostSummary = WastageLossCostSummaryDTO.builder()
               .wastageCostSummaryValueDTO(taskProcessPendingProductsWastageLossCostSummary)
               .name(process.getName() + "在制")
               .indexName(String.valueOf(newIndexName))
               .indexNumber(newIndexNumber)
               .build();
            costSummaryDTOS.add(assembleProcessSchedulingCostSummary);
            costSummaryDTOS.add(assembleProcessCompleteSchedulingCostSummary);
            costSummaryDTOS.add(assembleProcessPendingProductsSchedulingCostSummary);
         }
      }

      indexName = indexName.add(BigDecimal.ONE);
      List<WastageCostSummaryValueDTO> assembleCompleteCostSummaryValueDTOS = this.taskService
         .getTaskCompleteWastageLossCostSummary(projectId, null, TaskTypeEnum.ASSEMBLE.getType(), null, null, yearMonthDateList);
      WastageLossCostSummaryDTO assembleCompleteCostSummary = WastageLossCostSummaryDTO.builder()
         .wastageCostSummaryValueDTO(assembleCompleteCostSummaryValueDTOS)
         .name("部件制成品")
         .indexName(String.valueOf(indexName))
         .indexNumber(Integer.parseInt(indexName.toString().replace(".", "0")))
         .build();
      assembleCompleteCostSummary.setTotal(this.getTotal(assembleCompleteCostSummary.getWastageCostSummaryValueDTO()));
      costSummaryDTOS.add(assembleCompleteCostSummary);
      WastageLossCostSummaryDTO artifactSummary = WastageLossCostSummaryDTO.builder().indexNumber(80).indexName("三").name("构件").build();
      costSummaryDTOS.add(artifactSummary);
      List<WastageCostSummaryValueDTO> artifactTaskWastageLossCostSummary = this.taskService
         .getTaskWastageLossCostSummary(projectId, null, TaskTypeEnum.ARTIFACT.getType(), null, null, yearMonthDateList);
      WastageLossCostSummaryDTO artifactSchedulingCostSummary = WastageLossCostSummaryDTO.builder()
         .wastageCostSummaryValueDTO(artifactTaskWastageLossCostSummary)
         .name("构件排产")
         .indexName("3.1")
         .indexNumber(81)
         .build();
      artifactSchedulingCostSummary.setTotal(this.getTotal(artifactSchedulingCostSummary.getWastageCostSummaryValueDTO()));
      costSummaryDTOS.add(artifactSchedulingCostSummary);
      List<MesBuildingTaskProcess> artifactTaskProcesses = this.taskProcessService
         .list(
            ((new LambdaQueryWrapper<MesBuildingTaskProcess>().eq(MesBuildingTaskProcess::getProjectId, projectId))
                  .eq(MesBuildingTaskProcess::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType()))
               .select(MesBuildingTaskProcess::getProcessId)
         );
      BigDecimal artifactIndexName = BigDecimal.valueOf(Double.parseDouble(artifactSchedulingCostSummary.getIndexName()));
      if (CollectionUtils.isNotEmpty(artifactTaskProcesses)) {
         List<Long> assembleProcessIds = artifactTaskProcesses.stream().map(MesBuildingTaskProcess::getProcessId).distinct().collect(Collectors.toList());

         for (MesBuildingProcess process : this.processService
            .listByIds(assembleProcessIds)
            .stream()
            .sorted(Comparator.comparing(MesBuildingProcess::getSort))
            .collect(Collectors.toList())) {
            artifactIndexName = artifactIndexName.add(BigDecimal.valueOf(0.1));
            BigDecimal newArtifactIndexName = artifactIndexName;
            int artifactIndexNumber = Integer.parseInt(newArtifactIndexName.toString().replace(".", "0"));
            List<WastageCostSummaryValueDTO> taskProcessWastageLossCostSummary = this.taskProcessService
               .getTaskProcessWastageLossCostSummary(projectId, null, process.getId(), TaskTypeEnum.ARTIFACT.getType(), null, null, yearMonthDateList);
            WastageLossCostSummaryDTO artifactProcessSchedulingCostSummary = WastageLossCostSummaryDTO.builder()
               .wastageCostSummaryValueDTO(taskProcessWastageLossCostSummary)
               .name(process.getName() + "任务")
               .indexName(String.valueOf(newArtifactIndexName))
               .indexNumber(artifactIndexNumber)
               .build();
            artifactProcessSchedulingCostSummary.setTotal(this.getTotal(artifactProcessSchedulingCostSummary.getWastageCostSummaryValueDTO()));
            newArtifactIndexName = newArtifactIndexName.add(BigDecimal.valueOf(0.01));
            artifactIndexNumber = Integer.parseInt(newArtifactIndexName.toString().replace(".", "0"));
            List<WastageCostSummaryValueDTO> taskProcessCompleteWastageLossCostSummary = this.taskProcessService
               .getTaskProcessCompleteWastageLossCostSummary(projectId, null, process.getId(), TaskTypeEnum.ARTIFACT.getType(), null, null, yearMonthDateList);
            WastageLossCostSummaryDTO artifactProcessCompleteSchedulingCostSummary = WastageLossCostSummaryDTO.builder()
               .wastageCostSummaryValueDTO(taskProcessCompleteWastageLossCostSummary)
               .name(process.getName() + "完成")
               .indexName(String.valueOf(newArtifactIndexName))
               .indexNumber(artifactIndexNumber)
               .build();
            artifactProcessCompleteSchedulingCostSummary.setTotal(this.getTotal(artifactProcessCompleteSchedulingCostSummary.getWastageCostSummaryValueDTO()));
            newArtifactIndexName = newArtifactIndexName.add(BigDecimal.valueOf(0.01));
            artifactIndexNumber = Integer.parseInt(newArtifactIndexName.toString().replace(".", "0"));
            List<WastageCostSummaryValueDTO> taskProcessPendingProductsWastageLossCostSummary = this.taskProcessService
               .getTaskProcessPendingProductsWastageLossCostSummary(
                  projectId, null, process.getId(), TaskTypeEnum.ARTIFACT.getType(), null, null, yearMonthDateList
               );
            if (CollectionUtils.isNotEmpty(taskProcessPendingProductsWastageLossCostSummary)) {
               taskProcessPendingProductsWastageLossCostSummary = taskProcessPendingProductsWastageLossCostSummary.stream()
                  .sorted(Comparator.comparing(WastageCostSummaryValueDTO::getYearMonth))
                  .collect(Collectors.toList());
               BigDecimal productMonthOutput = BigDecimal.ZERO;

               for (WastageCostSummaryValueDTO valueDTO : taskProcessPendingProductsWastageLossCostSummary) {
                  productMonthOutput = productMonthOutput.add(valueDTO.getProductMonthOutput() == null ? BigDecimal.ZERO : valueDTO.getProductMonthOutput());
                  valueDTO.setProductMonthOutput(productMonthOutput);
               }
            }

            WastageLossCostSummaryDTO artifactProcessPendingProductsSchedulingCostSummary = WastageLossCostSummaryDTO.builder()
               .wastageCostSummaryValueDTO(taskProcessPendingProductsWastageLossCostSummary)
               .name(process.getName() + "在制")
               .indexName(String.valueOf(newArtifactIndexName))
               .indexNumber(artifactIndexNumber)
               .build();
            costSummaryDTOS.add(artifactProcessSchedulingCostSummary);
            costSummaryDTOS.add(artifactProcessCompleteSchedulingCostSummary);
            costSummaryDTOS.add(artifactProcessPendingProductsSchedulingCostSummary);
         }
      }

      indexName = indexName.add(BigDecimal.ONE);
      List<WastageCostSummaryValueDTO> artifactCompleteCostSummaryValueDTOS = this.taskService
         .getTaskCompleteWastageLossCostSummary(projectId, null, TaskTypeEnum.ARTIFACT.getType(), null, null, yearMonthDateList);
      WastageLossCostSummaryDTO artifactCompleteCostSummary = WastageLossCostSummaryDTO.builder()
         .wastageCostSummaryValueDTO(artifactCompleteCostSummaryValueDTOS)
         .name("构件制成品")
         .indexName(String.valueOf(indexName))
         .indexNumber(Integer.parseInt(indexName.toString().replace(".", "0")))
         .build();
      artifactCompleteCostSummary.setTotal(this.getTotal(artifactCompleteCostSummary.getWastageCostSummaryValueDTO()));
      costSummaryDTOS.add(artifactCompleteCostSummary);
   }

   private List<WastageCostSummaryValueDTO> getGroupByMonthPickingSummary(
      List<LocalDate> yearMonthDateList, List<WastageCostSummaryValueDTO> outboundSummaryList, List<WastageCostSummaryValueDTO> returnSummaryList
   ) {
      if (CollectionUtils.isEmpty(yearMonthDateList)) {
         return new ArrayList<>();
      }

      Map<String, BigDecimal> outboundSummaryMap = outboundSummaryList.stream()
         .collect(Collectors.toMap(WastageCostSummaryValueDTO::getYearMonth, WastageCostSummaryValueDTO::getProductMonthOutput));
      Map<String, BigDecimal> returnSummaryMap = returnSummaryList.stream()
         .collect(Collectors.toMap(WastageCostSummaryValueDTO::getYearMonth, WastageCostSummaryValueDTO::getProductMonthOutput));
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
      return yearMonthDateList.stream()
         .map(
            e -> {
               String key = e.format(formatter);
               return WastageCostSummaryValueDTO.builder()
                  .yearMonth(key)
                  .lossWorkProgressStatisticsEnum(4)
                  .productMonthOutput(outboundSummaryMap.getOrDefault(key, BigDecimal.ZERO).subtract(returnSummaryMap.getOrDefault(key, BigDecimal.ZERO)))
                  .build();
            }
         )
         .collect(Collectors.toList());
   }

   private BigDecimal getTotal(List<WastageCostSummaryValueDTO> valueDTOList) {
      return CollectionUtils.isEmpty(valueDTOList)
         ? BigDecimal.ZERO
         : valueDTOList.stream().map(WastageCostSummaryValueDTO::getProductMonthOutput).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add);
   }

   private WastageLossCostSummaryDTO getFirstByProject(List<LocalDate> yearMonthDateList) {
      List<WastageCostSummaryValueDTO> valueDTOS = yearMonthDateList.stream().map(e -> {
         String yearMonth = e.format(DateTimeFormatter.ofPattern("yyyy-MM"));
         WastageCostSummaryValueDTO valueDTO = new WastageCostSummaryValueDTO();
         valueDTO.setYearMonth(yearMonth);
         return valueDTO;
      }).collect(Collectors.toList());
      return WastageLossCostSummaryDTO.builder().indexNumber(1).wastageCostSummaryValueDTO(valueDTOS).build();
   }

   private WastageLossCostSummaryDTO getFirstByWorkShop(Integer year, List<String> yearMonthList) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
      int nowYear = LocalDate.now().getYear();
      if (year != null && year != nowYear) {
         int nowMouth = 12;
         if (nowYear == year) {
            nowMouth = LocalDate.now().getMonth().getValue();
         }

         yearMonthList.addAll(IntStream.rangeClosed(1, nowMouth).mapToObj(month -> YearMonth.of(year, month).format(formatter)).collect(Collectors.toList()));
      } else {
         YearMonth currentYearMonth = YearMonth.now();

         for (int i = 0; i < 12; i++) {
            YearMonth ym = currentYearMonth.minusMonths(i);
            yearMonthList.add(ym.format(formatter));
         }
      }

      List<WastageCostSummaryValueDTO> valueDTOS = yearMonthList.stream().map(yearMonth -> {
         WastageCostSummaryValueDTO valueDTO = new WastageCostSummaryValueDTO();
         valueDTO.setYearMonth(yearMonth);
         return valueDTO;
      }).collect(Collectors.toList());
      return WastageLossCostSummaryDTO.builder().indexNumber(1).wastageCostSummaryValueDTO(valueDTOS).build();
   }

   private List<LocalDate> getYearMonthDateList(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(project), "项目不存在");
      LocalDate startDate = project.getCreateTime().toLocalDate().with(TemporalAdjusters.firstDayOfMonth());
      LocalDate endDate = ProjectStatusEnum.COMPLETED.getType().equals(project.getStatus()) ? project.getCompleteDate() : LocalDate.now();
      endDate = endDate.with(TemporalAdjusters.firstDayOfMonth());
      List<LocalDate> yearMonthList = new ArrayList<>();
      long monthsBetween = ChronoUnit.MONTHS.between(startDate, endDate);
      Stream.<LocalDate>iterate(startDate, date -> date.plusMonths(1L)).limit(monthsBetween + 1L).forEach(yearMonthList::add);
      return yearMonthList;
   }
}
