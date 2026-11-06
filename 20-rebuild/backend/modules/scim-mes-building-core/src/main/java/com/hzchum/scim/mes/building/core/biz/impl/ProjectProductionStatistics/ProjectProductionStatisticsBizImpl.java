package com.hzchum.scim.mes.building.core.biz.impl.ProjectProductionStatistics;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.ProjectProductionStatisticsBiz.ProjectProductionStatisticsBiz;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskCompanyStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingArtifactScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.ProjectProductionStatistics.ProjectProductionStatisticsDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.ProjectProductionStatistics.ProjectProductionTaskDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.ProjectProductionStatistics.ProjectProductionStatisticsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.ProjectProductionStatistics.ProjectProductionStatisticsDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.ProjectProductionStatistics.ProjectProductionStatisticsProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.ProjectProductionStatistics.ProjectProductionTaskDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingProjectProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingProjectProductionLineDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingProjectTeamDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingProjectWorkshopDTO;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingArtifactSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ProjectPickingDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.ProjectPickingMeteListDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryProjectPickingDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

@Service
public class ProjectProductionStatisticsBizImpl implements ProjectProductionStatisticsBiz {
   @Resource
   private TechArtifactService techArtifactService;
   @Resource
   private TechAssembleService assembleService;
   @Resource
   private TechMachinePartService machinePartService;
   @Resource
   private MesBuildingTaskService mesBuildingTaskService;
   @Resource
   private MesBuildingTaskProcessService mesBuildingTaskProcessService;
   @Resource
   private MesBuildingProcessService mesBuildingProcessService;
   @Resource
   private MesBuildingArtifactSchedulingService artifactSchedulingService;
   @Resource
   private MesBuildingWorkshopService workshopService;
   @Resource
   private MesBuildingProductionLineService productionLineService;
   @Resource
   private MesBuildingTeamService teamService;
   @Resource
   private MesBuildingTeamUserLinkService teamUserLinkService;
   @Resource
   private ContractProjectService contractProjectService;
   @Resource
   private OutboundService outboundService;

   @Override
   public ProjectProductionStatisticsDTO projectProductionStatisticsSum(ProjectProductionStatisticsDOParam param) {
      ProjectProductionStatisticsDTO statisticsDTO = ProjectProductionStatisticsDTO.builder()
         .inProductionTotalGrossWeight(BigDecimal.ZERO)
         .companyTotalGrossWeight(BigDecimal.ZERO)
         .companyTotalNetWeight(BigDecimal.ZERO)
         .inProductionTotalNetWeight(BigDecimal.ZERO)
         .partInProductionTotalNetWeight(BigDecimal.ZERO)
         .partInProductionTotalGrossWeight(BigDecimal.ZERO)
         .projectGetMaterialsTotalWeight(BigDecimal.ZERO)
         .totalGrossWeight(BigDecimal.ZERO)
         .totalNetWeight(BigDecimal.ZERO)
         .finishingRate(BigDecimal.ZERO)
         .build();
      QueryProjectPickingDTOParam build = QueryProjectPickingDTOParam.builder().projectId(param.getProjectId()).build();
      ProjectPickingMeteListDTO projectPickingMeteListDTO = this.outboundService.PickingMete(build);
      BigDecimal projectGetMaterialsTotalWeight = BigDecimal.ZERO;
      if (projectPickingMeteListDTO != null) {
         if (CollectionUtils.isNotEmpty(projectPickingMeteListDTO.getProjectPickingSteelMeteList())) {
            BigDecimal reduce = projectPickingMeteListDTO.getProjectPickingSteelMeteList()
               .stream()
               .map(ProjectPickingDTO::getMeteCount)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            projectGetMaterialsTotalWeight = projectGetMaterialsTotalWeight.add(reduce);
         }

         if (CollectionUtils.isNotEmpty(projectPickingMeteListDTO.getProjectPickingSectionSteelMeteList())) {
            BigDecimal reduce = projectPickingMeteListDTO.getProjectPickingSectionSteelMeteList()
               .stream()
               .map(ProjectPickingDTO::getMeteCount)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            projectGetMaterialsTotalWeight = projectGetMaterialsTotalWeight.add(reduce);
         }
      }

      statisticsDTO.setProjectGetMaterialsTotalWeight(
         projectGetMaterialsTotalWeight.compareTo(BigDecimal.ZERO) > 0
            ? projectGetMaterialsTotalWeight.divide(BigDecimal.valueOf(1000000L), 3, 4)
            : BigDecimal.ZERO
      );
      List<MesBuildingTask> partTaskList = this.mesBuildingTaskService
         .list(
            (Wrapper<MesBuildingTask>)((((new LambdaQueryWrapper<MesBuildingTask>()
                           .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.MACHINE_PART.getType()))
                        .eq(MesBuildingTask::getProjectId, param.getProjectId()))
                     .eq(param.getMonomerId() != null, MesBuildingTask::getMonomerId, param.getMonomerId()))
                  .in(CollectionUtils.isNotEmpty(param.getAreaIdList()), MesBuildingTask::getAreaId, param.getAreaIdList()))
               .apply("complete_quantity < task_quantity")
         );
      if (CollectionUtils.isNotEmpty(partTaskList)) {
         Map<Long, TechMachinePart> partMap = this.machinePartService
            .list(
               ((new LambdaQueryWrapper<TechMachinePart>().eq(TechMachinePart::getProjectId, param.getProjectId()))
                     .eq(param.getMonomerId() != null, TechMachinePart::getMonomerId, param.getMonomerId()))
                  .in(CollectionUtils.isNotEmpty(param.getAreaIdList()), TechMachinePart::getAreaId, param.getAreaIdList())
            )
            .stream()
            .collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
         BigDecimal partInProductionTotalNetWeight = partTaskList.stream()
            .map(e -> partMap.get(e.getProductId()).getNetWeight().multiply(BigDecimal.valueOf(e.getTaskQuantity() - e.getCompleteQuantity())))
            .reduce(BigDecimal.ZERO, BigDecimal::add)
            .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
         BigDecimal partInProductionTotalGrossWeight = partTaskList.stream()
            .map(e -> partMap.get(e.getProductId()).getGrossWeight().multiply(BigDecimal.valueOf(e.getTaskQuantity() - e.getCompleteQuantity())))
            .reduce(BigDecimal.ZERO, BigDecimal::add)
            .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
         statisticsDTO.setInProductionTotalGrossWeight(partInProductionTotalGrossWeight);
         statisticsDTO.setInProductionTotalNetWeight(partInProductionTotalNetWeight);
      }

      List<TechArtifact> artifactList = this.techArtifactService
         .list(
            ((new LambdaQueryWrapper<TechArtifact>().eq(TechArtifact::getProjectId, param.getProjectId()))
                  .eq(param.getMonomerId() != null, TechArtifact::getMonomerId, param.getMonomerId()))
               .in(CollectionUtils.isNotEmpty(param.getAreaIdList()), TechArtifact::getAreaId, param.getAreaIdList())
         );
      if (CollectionUtils.isEmpty(artifactList)) {
         return statisticsDTO;
      }

      Map<Long, TechArtifact> artifactMap = artifactList.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      BigDecimal totalNetWeight = artifactList.stream()
         .map(e -> e.getNetWeight().multiply(BigDecimal.valueOf(e.getQuantity().intValue())))
         .reduce(BigDecimal.ZERO, BigDecimal::add)
         .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
      BigDecimal totalGrossWeight = artifactList.stream()
         .map(e -> e.getGrossWeight().multiply(BigDecimal.valueOf(e.getQuantity().intValue())))
         .reduce(BigDecimal.ZERO, BigDecimal::add)
         .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
      BigDecimal companyTotalNetWeight = artifactList.stream()
         .map(e -> e.getNetWeight().multiply(BigDecimal.valueOf(e.getProducedQuantity().intValue())))
         .reduce(BigDecimal.ZERO, BigDecimal::add)
         .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
      BigDecimal companyTotalGrossWeight = artifactList.stream()
         .map(e -> e.getGrossWeight().multiply(BigDecimal.valueOf(e.getProducedQuantity().intValue())))
         .reduce(BigDecimal.ZERO, BigDecimal::add)
         .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
      List<MesBuildingTask> artifactTasks = this.mesBuildingTaskService
         .list(
            (Wrapper<MesBuildingTask>)((((new LambdaQueryWrapper<MesBuildingTask>()
                           .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType()))
                        .eq(MesBuildingTask::getProjectId, param.getProjectId()))
                     .eq(param.getMonomerId() != null, MesBuildingTask::getMonomerId, param.getMonomerId()))
                  .in(CollectionUtils.isNotEmpty(param.getAreaIdList()), MesBuildingTask::getAreaId, param.getAreaIdList()))
               .apply("complete_quantity < task_quantity")
         );
      if (CollectionUtils.isNotEmpty(artifactTasks)) {
         BigDecimal inProductionTotalNetWeight = artifactTasks.stream()
            .map(e -> artifactMap.get(e.getProductId()).getNetWeight().multiply(BigDecimal.valueOf(e.getTaskQuantity() - e.getCompleteQuantity())))
            .reduce(BigDecimal.ZERO, BigDecimal::add)
            .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
         BigDecimal inProductionTotalGrossWeight = artifactTasks.stream()
            .map(e -> artifactMap.get(e.getProductId()).getGrossWeight().multiply(BigDecimal.valueOf(e.getTaskQuantity() - e.getCompleteQuantity())))
            .reduce(BigDecimal.ZERO, BigDecimal::add)
            .divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP);
         statisticsDTO.setInProductionTotalGrossWeight(inProductionTotalGrossWeight);
         statisticsDTO.setInProductionTotalNetWeight(inProductionTotalNetWeight);
      }

      BigDecimal finishingRate = BigDecimal.ZERO;
      if (totalNetWeight.compareTo(BigDecimal.ZERO) > 0) {
         finishingRate = companyTotalNetWeight.divide(totalNetWeight, 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100L));
      }

      statisticsDTO.setFinishingRate(finishingRate);
      statisticsDTO.setCompanyTotalNetWeight(companyTotalNetWeight);
      statisticsDTO.setCompanyTotalGrossWeight(companyTotalGrossWeight);
      statisticsDTO.setTotalNetWeight(totalNetWeight);
      statisticsDTO.setTotalGrossWeight(totalGrossWeight);
      return statisticsDTO;
   }

   @Override
   public ProjectProductionStatisticsDetailDTO projectProductionStatisticsDetail(ProjectProductionStatisticsDOParam param) {
      ProjectProductionStatisticsDetailDTO projectProductionStatisticsDetailDTO = new ProjectProductionStatisticsDetailDTO();
      QueryProjectPickingDTOParam build = QueryProjectPickingDTOParam.builder().projectId(param.getProjectId()).build();
      ProjectPickingMeteListDTO projectPickingMeteListDTO = this.outboundService.PickingMete(build);
      BigDecimal projectGetMaterialsTotalWeight = BigDecimal.ZERO;
      if (projectPickingMeteListDTO != null) {
         if (CollectionUtils.isNotEmpty(projectPickingMeteListDTO.getProjectPickingSteelMeteList())) {
            BigDecimal reduce = projectPickingMeteListDTO.getProjectPickingSteelMeteList()
               .stream()
               .map(ProjectPickingDTO::getMeteCount)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            projectGetMaterialsTotalWeight = projectGetMaterialsTotalWeight.add(reduce);
         }

         if (CollectionUtils.isNotEmpty(projectPickingMeteListDTO.getProjectPickingSectionSteelMeteList())) {
            BigDecimal reduce = projectPickingMeteListDTO.getProjectPickingSectionSteelMeteList()
               .stream()
               .map(ProjectPickingDTO::getMeteCount)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            projectGetMaterialsTotalWeight = projectGetMaterialsTotalWeight.add(reduce);
         }
      }

      projectProductionStatisticsDetailDTO.setProjectGetMaterialsTotalWeight(
         projectGetMaterialsTotalWeight.compareTo(BigDecimal.ZERO) > 0
            ? projectGetMaterialsTotalWeight.divide(BigDecimal.valueOf(1000000L), 3, 4)
            : BigDecimal.ZERO
      );
      List<TechArtifact> artifactList = this.techArtifactService
         .list(
            ((new LambdaQueryWrapper<TechArtifact>().eq(TechArtifact::getProjectId, param.getProjectId()))
                  .eq(param.getMonomerId() != null, TechArtifact::getMonomerId, param.getMonomerId()))
               .in(CollectionUtils.isNotEmpty(param.getAreaIdList()), TechArtifact::getAreaId, param.getAreaIdList())
         );
      Map<Long, TechArtifact> artifactMap = artifactList.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      Map<Long, TechAssemble> assembleMap = this.assembleService
         .list(
            ((new LambdaQueryWrapper<TechAssemble>().eq(TechAssemble::getProjectId, param.getProjectId()))
                  .eq(param.getMonomerId() != null, TechAssemble::getMonomerId, param.getMonomerId()))
               .in(CollectionUtils.isNotEmpty(param.getAreaIdList()), TechAssemble::getAreaId, param.getAreaIdList())
         )
         .stream()
         .collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
      Map<Long, TechMachinePart> machinePartMap = this.machinePartService
         .list(
            ((new LambdaQueryWrapper<TechMachinePart>().eq(TechMachinePart::getProjectId, param.getProjectId()))
                  .eq(param.getMonomerId() != null, TechMachinePart::getMonomerId, param.getMonomerId()))
               .in(CollectionUtils.isNotEmpty(param.getAreaIdList()), TechMachinePart::getAreaId, param.getAreaIdList())
         )
         .stream()
         .collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
      if (CollectionUtils.isNotEmpty(artifactList)) {
         BigDecimal totalNetWeight = artifactList.stream()
            .map(e -> e.getNetWeight().multiply(BigDecimal.valueOf(e.getQuantity().intValue())))
            .reduce(BigDecimal.ZERO, BigDecimal::add)
            .divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP);
         BigDecimal totalGrossWeight = artifactList.stream()
            .map(e -> e.getGrossWeight().multiply(BigDecimal.valueOf(e.getQuantity().intValue())))
            .reduce(BigDecimal.ZERO, BigDecimal::add)
            .divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP);
         List<MesBuildingArtifactScheduling> artifactSchedulingList = this.artifactSchedulingService
            .list(
               ((new LambdaQueryWrapper<MesBuildingArtifactScheduling>().eq(MesBuildingArtifactScheduling::getProjectId, param.getProjectId()))
                     .eq(param.getMonomerId() != null, MesBuildingArtifactScheduling::getMonomerId, param.getMonomerId()))
                  .in(CollectionUtils.isNotEmpty(param.getAreaIdList()), MesBuildingArtifactScheduling::getAreaId, param.getAreaIdList())
            );
         projectProductionStatisticsDetailDTO.setTotalNetWeight(totalNetWeight);
         projectProductionStatisticsDetailDTO.setTotalGrossWeight(totalGrossWeight);
         if (CollectionUtils.isNotEmpty(artifactSchedulingList)) {
            BigDecimal totalSchedulingNetWeight = artifactSchedulingList.stream()
               .map(e -> artifactMap.get(e.getProductId()).getNetWeight().multiply(BigDecimal.valueOf(e.getTaskQuantity().intValue())))
               .reduce(BigDecimal.ZERO, BigDecimal::add)
               .divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP);
            BigDecimal totalSchedulingGrossWeight = artifactSchedulingList.stream()
               .map(e -> artifactMap.get(e.getProductId()).getGrossWeight().multiply(BigDecimal.valueOf(e.getQuantity().intValue())))
               .reduce(BigDecimal.ZERO, BigDecimal::add)
               .divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP);
            projectProductionStatisticsDetailDTO.setTotalSchedulingNetWeight(totalSchedulingNetWeight);
            projectProductionStatisticsDetailDTO.setTotalSchedulingGrossWeight(totalSchedulingGrossWeight);
         }
      }

      List<ProjectProductionStatisticsProcessDTO> productionStatisticsProcessDTOS = this.getBuildStatisticsProcessDTOS(
         param, artifactMap, assembleMap, machinePartMap
      );
      projectProductionStatisticsDetailDTO.setProductionStatisticsProcessDTOS(productionStatisticsProcessDTOS);
      return projectProductionStatisticsDetailDTO;
   }

   @Override
   public List<MesBuildingProjectProcessDTO> getProjectProcessList(ProjectProductionStatisticsDOParam param) {
      List<MesBuildingTaskProcess> taskProcesses = this.mesBuildingTaskProcessService
         .list(
            (Wrapper<MesBuildingTaskProcess>)((((new LambdaQueryWrapper<MesBuildingTaskProcess>()
                           .eq(MesBuildingTaskProcess::getProjectId, param.getProjectId()))
                        .eq(param.getMonomerId() != null, MesBuildingTaskProcess::getMonomerId, param.getMonomerId()))
                     .eq(param.getProductType() != null, MesBuildingTaskProcess::getTaskTypeEnum, param.getProductType()))
                  .in(CollectionUtils.isNotEmpty(param.getAreaIdList()), MesBuildingTaskProcess::getAreaId, param.getAreaIdList()))
               .in(
                  MesBuildingTaskProcess::getTaskTypeEnum,
                  TaskTypeEnum.ARTIFACT.getType(),
                  TaskTypeEnum.ASSEMBLE.getType(),
                  TaskTypeEnum.MACHINE_PART.getType()
               )
         );
      if (CollectionUtils.isEmpty(taskProcesses)) {
         return new ArrayList<>();
      }

      List<MesBuildingProcess> mesBuildingProcesses = this.mesBuildingProcessService
         .listByIds(taskProcesses.stream().map(MesBuildingTaskProcess::getProcessId).collect(Collectors.toList()));
      return mesBuildingProcesses.stream()
         .map(
            process -> MesBuildingProjectProcessDTO.builder().id(process.getId()).processName(process.getName()).productType(process.getProductType()).build()
         )
         .collect(Collectors.toList());
   }

   @Override
   public List<MesBuildingProjectWorkshopDTO> getProjectQueryCondition(ProjectProductionStatisticsDOParam param) {
      List<MesBuildingTaskProcess> taskProcesses = this.mesBuildingTaskProcessService
         .list(
            ((((((new LambdaQueryWrapper<MesBuildingTaskProcess>()
                                 .eq(MesBuildingTaskProcess::getProjectId, param.getProjectId()))
                              .eq(param.getMonomerId() != null, MesBuildingTaskProcess::getMonomerId, param.getMonomerId()))
                           .in(CollectionUtils.isNotEmpty(param.getAreaIdList()), MesBuildingTaskProcess::getAreaId, param.getAreaIdList()))
                        .eq(param.getProductType() != null, MesBuildingTaskProcess::getTaskTypeEnum, param.getProductType()))
                     .eq(param.getProcessId() != null, MesBuildingTaskProcess::getProcessId, param.getProcessId()))
                  .isNotNull(MesBuildingTaskProcess::getTeamId))
               .select(MesBuildingTaskProcess::getTeamId)
         );
      if (CollectionUtils.isEmpty(taskProcesses)) {
         return new ArrayList<>();
      }

      List<Long> teamIds = taskProcesses.stream().map(MesBuildingTaskProcess::getTeamId).filter(Objects::nonNull).distinct().collect(Collectors.toList());
      List<MesBuildingTeam> teamList = this.teamService.listByIds(teamIds);
      List<Long> workshopIds = teamList.stream().map(MesBuildingTeam::getWorkshopId).distinct().collect(Collectors.toList());
      List<Long> productionLineIds = teamList.stream().map(MesBuildingTeam::getProductionLineId).distinct().collect(Collectors.toList());
      List<Long> processIds = teamList.stream().map(MesBuildingTeam::getProcessId).distinct().collect(Collectors.toList());
      List<MesBuildingWorkshop> workshopList = this.workshopService.listByIds(workshopIds);
      Map<Long, List<MesBuildingProductionLine>> productionLineMap = this.productionLineService
         .listByIds(productionLineIds)
         .stream()
         .collect(Collectors.groupingBy(MesBuildingProductionLine::getWorkshopId));
      Map<Long, List<MesBuildingTeam>> teamMap = teamList.stream().collect(Collectors.groupingBy(MesBuildingTeam::getProductionLineId));
      List<MesBuildingProcess> mesBuildingProcesses = this.mesBuildingProcessService.listByIds(processIds);
      Map<Long, MesBuildingProcess> processMap = mesBuildingProcesses.stream().collect(Collectors.toMap(MesBuildingProcess::getId, Function.identity()));
      Map<Long, MesBuildingTeamUserLink> teamUserLinkMap = this.teamUserLinkService
         .list(
            (Wrapper<MesBuildingTeamUserLink>)(new LambdaQueryWrapper<MesBuildingTeamUserLink>()
                  .in(MesBuildingTeamUserLink::getTeamId, teamList.stream().map(MesBuildingTeam::getId).collect(Collectors.toList())))
               .eq(MesBuildingTeamUserLink::getBoolLeaderEnum, Boolean.TRUE)
         )
         .stream()
         .collect(Collectors.toMap(MesBuildingTeamUserLink::getTeamId, Function.identity()));
      return workshopList.stream()
         .map(
            workshop -> {
               MesBuildingProjectWorkshopDTO workshopDTO = BeanUtil.copy(workshop, MesBuildingProjectWorkshopDTO.class);
               List<MesBuildingProductionLine> productionLineList = productionLineMap.get(workshop.getId());
               List<MesBuildingProjectProductionLineDTO> projectProductionLineDTOS = cn.hutool.core.bean.BeanUtil.copyToList(
                  productionLineList, MesBuildingProjectProductionLineDTO.class
               );

               for (MesBuildingProjectProductionLineDTO projectProductionLineDTO : projectProductionLineDTOS) {
                  List<MesBuildingTeam> mesBuildingTeams = teamMap.get(projectProductionLineDTO.getId());
                  List<MesBuildingProjectTeamDTO> projectTeamDTOS = mesBuildingTeams.stream()
                     .map(
                        team -> {
                           MesBuildingTeamUserLink userLink = teamUserLinkMap.get(team.getId());
                           return MesBuildingProjectTeamDTO.builder()
                              .id(team.getId())
                              .userName(userLink.getUserName())
                              .userId(userLink.getUserId())
                              .processId(team.getProcessId())
                              .processName(processMap.get(team.getProcessId()).getName())
                              .build();
                        }
                     )
                     .collect(Collectors.toList());
                  projectProductionLineDTO.setProjectTeamDTOS(projectTeamDTOS);
               }

               workshopDTO.setProjectProductionLineDTOS(projectProductionLineDTOS);
               return workshopDTO;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public List<ProjectProductionTaskDetailDTO> getProjectProductionTaskDetail(ProjectProductionTaskDOParam param) {
      List<ProjectProductionTaskDetailDTO> projectProductionTaskDetail = this.mesBuildingTaskProcessService.getProjectProductionTaskDetail(param);
      if (CollectionUtils.isNotEmpty(projectProductionTaskDetail)) {
         projectProductionTaskDetail.forEach(taskDeTail -> {
            if (taskDeTail.getCompleteQuantity() == 0) {
               taskDeTail.setTaskCompanyStatusEnum(TaskCompanyStatusEnum.UNFINISHED.getType());
            }

            if (taskDeTail.getCompleteQuantity().equals(taskDeTail.getTaskQuantity())) {
               taskDeTail.setTaskCompanyStatusEnum(TaskCompanyStatusEnum.COMPLETED.getType());
            }

            if (taskDeTail.getCompleteQuantity() < taskDeTail.getTaskQuantity()) {
               taskDeTail.setTaskCompanyStatusEnum(TaskCompanyStatusEnum.PARTLY_COMPLETED.getType());
            }
         });
      }

      return projectProductionTaskDetail.stream()
         .sorted(Comparator.comparing(ProjectProductionTaskDetailDTO::getTaskCompanyStatusEnum))
         .collect(Collectors.toList());
   }

   @Override
   public List<ProjectProductionTaskDetailDTO> getProjectProductionTaskTeamDetail(ProjectProductionTaskDOParam param) {
      List<ProjectProductionTaskDetailDTO> projectProductionTaskDetail = this.mesBuildingTaskProcessService.getProjectProductionTaskTeamDetail(param);
      if (CollectionUtils.isNotEmpty(projectProductionTaskDetail)) {
         projectProductionTaskDetail.forEach(taskDeTail -> {
            if (taskDeTail.getCompleteQuantity() == 0) {
               taskDeTail.setTaskCompanyStatusEnum(TaskCompanyStatusEnum.UNFINISHED.getType());
            }

            if (taskDeTail.getCompleteQuantity().equals(taskDeTail.getTaskQuantity())) {
               taskDeTail.setTaskCompanyStatusEnum(TaskCompanyStatusEnum.COMPLETED.getType());
            }

            if (taskDeTail.getCompleteQuantity() < taskDeTail.getTaskQuantity()) {
               taskDeTail.setTaskCompanyStatusEnum(TaskCompanyStatusEnum.PARTLY_COMPLETED.getType());
            }
         });
      }

      return projectProductionTaskDetail.stream()
         .sorted(Comparator.comparing(ProjectProductionTaskDetailDTO::getTaskCompanyStatusEnum))
         .collect(Collectors.toList());
   }

   @Override
   public PageVO<ProjectProductionTaskDetailDTO> getPageProjectProductionTaskDetail(ProjectProductionTaskDOParam param) {
      Preconditions.checkArgument(param.getProductType() != null, "操作失败,产品类型不可为空!");
      return new PageVO<>(PageHelper.startPage(param.getPageNumber(), param.getPageSize()), this.getProjectProductionTaskDetail(param));
   }

   @Override
   public Map<String, Object> getProjectProductionTaskSum(ProjectProductionTaskDOParam param) {
      Preconditions.checkArgument(param.getProductType() != null, "操作失败,产品类型不可为空!");
      Map<String, Object> map = new HashMap<>();
      List<ProjectProductionTaskDetailDTO> projectProductionTaskDetail = this.mesBuildingTaskProcessService.getProjectProductionTaskDetail(param);
      if (CollectionUtils.isEmpty(projectProductionTaskDetail)) {
         return map;
      }

      map.put("totalTaskQuantity", projectProductionTaskDetail.stream().mapToInt(ProjectProductionTaskDetailDTO::getTaskQuantity).sum());
      map.put(
         "totalNetWeight",
         projectProductionTaskDetail.stream()
            .map(ProjectProductionTaskDetailDTO::getTotalNetWeight)
            .reduce(BigDecimal.ZERO, BigDecimal::add)
            .divide(BigDecimal.valueOf(1000L), 2, 4)
      );
      map.put(
         "totalGrossWeight",
         projectProductionTaskDetail.stream()
            .map(ProjectProductionTaskDetailDTO::getTotalGrossWeight)
            .reduce(BigDecimal.ZERO, BigDecimal::add)
            .divide(BigDecimal.valueOf(1000L), 2, 4)
      );
      map.put("totalCompleteQuantity", projectProductionTaskDetail.stream().mapToInt(ProjectProductionTaskDetailDTO::getCompleteQuantity).sum());
      map.put(
         "totalCompleteNetWeight",
         projectProductionTaskDetail.stream()
            .map(ProjectProductionTaskDetailDTO::getTotalCompleteNetWeight)
            .reduce(BigDecimal.ZERO, BigDecimal::add)
            .divide(BigDecimal.valueOf(1000L), 2, 4)
      );
      map.put(
         "totalCompleteGrossWeight",
         projectProductionTaskDetail.stream()
            .map(ProjectProductionTaskDetailDTO::getTotalCompleteGrossWeight)
            .reduce(BigDecimal.ZERO, BigDecimal::add)
            .divide(BigDecimal.valueOf(1000L), 2, 4)
      );
      return map;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printProjectProductionTaskDetail(ProjectProductionTaskDOParam param) {
      Preconditions.checkArgument(param.getProductType() != null, "操作失败,产品类型不可为空!");
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      ContractProject project = this.contractProjectService.getById(param.getProjectId());
      header.put("projectName", project.getShortName() + "-" + project.getSerialNumber());
      header.put("statisticalDate", "全部");
      header.put("productType", ProductTypeEnum.getNameByType(param.getProductType()));
      if (com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isNotEmpty(param.getDateTimeList()) && param.getDateTimeList().size() == 2) {
         DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd");
         String startTime = df.format(param.getDateTimeList().get(0));
         String endTime = df.format(param.getDateTimeList().get(1));
         header.put("statisticalDate", startTime + "-" + endTime);
      }

      printVO.setHeader(header);
      printVO.setTable(this.getProjectProductionTaskDetail(param).stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   @Override
   public PageVO<ProjectProductionTaskDetailDTO> getPageProjectProductionTaskTeamDetail(ProjectProductionTaskDOParam param) {
      Preconditions.checkArgument(param.getProductType() != null, "操作失败,产品类型不可为空!");
      return new PageVO<>(PageHelper.startPage(param.getPageNumber(), param.getPageSize()), this.getProjectProductionTaskTeamDetail(param));
   }

   @Override
   public Map<String, Object> getProjectProductionTaskTeamSum(ProjectProductionTaskDOParam param) {
      Map<String, Object> map = new HashMap<>();
      Preconditions.checkArgument(param.getProductType() != null, "操作失败,产品类型不可为空!");
      List<ProjectProductionTaskDetailDTO> projectProductionTaskDetail = this.getProjectProductionTaskTeamDetail(param);
      if (CollectionUtils.isNotEmpty(projectProductionTaskDetail)) {
         map.put("totalTaskQuantity", projectProductionTaskDetail.stream().mapToInt(ProjectProductionTaskDetailDTO::getTaskQuantity).sum());
         map.put(
            "totalNetWeight",
            projectProductionTaskDetail.stream()
               .map(ProjectProductionTaskDetailDTO::getTotalNetWeight)
               .reduce(BigDecimal.ZERO, BigDecimal::add)
               .divide(BigDecimal.valueOf(1000L), 2, 4)
         );
         map.put(
            "totalGrossWeight",
            projectProductionTaskDetail.stream()
               .map(ProjectProductionTaskDetailDTO::getTotalGrossWeight)
               .reduce(BigDecimal.ZERO, BigDecimal::add)
               .divide(BigDecimal.valueOf(1000L), 2, 4)
         );
         map.put("totalCompleteQuantity", projectProductionTaskDetail.stream().mapToInt(ProjectProductionTaskDetailDTO::getCompleteQuantity).sum());
         map.put(
            "totalCompleteNetWeight",
            projectProductionTaskDetail.stream()
               .map(ProjectProductionTaskDetailDTO::getTotalCompleteNetWeight)
               .reduce(BigDecimal.ZERO, BigDecimal::add)
               .divide(BigDecimal.valueOf(1000L), 2, 4)
         );
         map.put(
            "totalCompleteGrossWeight",
            projectProductionTaskDetail.stream()
               .map(ProjectProductionTaskDetailDTO::getTotalCompleteGrossWeight)
               .reduce(BigDecimal.ZERO, BigDecimal::add)
               .divide(BigDecimal.valueOf(1000L), 2, 4)
         );
      }

      return map;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printProjectProductionTaskTeamDetail(ProjectProductionTaskDOParam param) {
      Preconditions.checkArgument(param.getProductType() != null, "操作失败,产品类型不可为空");
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      ContractProject project = this.contractProjectService.getById(param.getProjectId());
      header.put("projectName", project.getShortName() + "-" + project.getSerialNumber());
      header.put("statisticalDate", "全部");
      header.put("productType", ProductTypeEnum.getNameByType(param.getProductType()));
      if (com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isNotEmpty(param.getDateTimeList()) && param.getDateTimeList().size() == 2) {
         DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         String startTime = df.format(param.getDateTimeList().get(0));
         String endTime = df.format(param.getDateTimeList().get(1));
         header.put("statisticalDate", startTime + "-" + endTime);
      }

      printVO.setHeader(header);
      printVO.setTable(this.getProjectProductionTaskTeamDetail(param).stream().map(BeanUtil::beanToMap).collect(Collectors.toList()));
      return printVO;
   }

   private List<ProjectProductionStatisticsProcessDTO> getBuildStatisticsProcessDTOS(
      ProjectProductionStatisticsDOParam param,
      Map<Long, TechArtifact> artifactMap,
      Map<Long, TechAssemble> assembleMap,
      Map<Long, TechMachinePart> machinePartMap
   ) {
      List<ProjectProductionStatisticsProcessDTO> productionStatisticsProcessDTOS = new ArrayList<>();
      List<MesBuildingTaskProcess> taskProcesses = this.mesBuildingTaskProcessService
         .list(
            (Wrapper<MesBuildingTaskProcess>)(((new LambdaQueryWrapper<MesBuildingTaskProcess>()
                        .eq(MesBuildingTaskProcess::getProjectId, param.getProjectId()))
                     .eq(param.getMonomerId() != null, MesBuildingTaskProcess::getMonomerId, param.getMonomerId()))
                  .in(CollectionUtils.isNotEmpty(param.getAreaIdList()), MesBuildingTaskProcess::getAreaId, param.getAreaIdList()))
               .in(
                  MesBuildingTaskProcess::getTaskTypeEnum,
                  TaskTypeEnum.ARTIFACT.getType(),
                  TaskTypeEnum.ASSEMBLE.getType(),
                  TaskTypeEnum.MACHINE_PART.getType()
               )
         );
      if (CollectionUtils.isNotEmpty(taskProcesses)) {
         Map<Long, List<MesBuildingTaskProcess>> taskProcessMap = taskProcesses.stream().collect(Collectors.groupingBy(MesBuildingTaskProcess::getProcessId));
         List<Long> processIds = taskProcesses.stream().map(MesBuildingTaskProcess::getProcessId).distinct().collect(Collectors.toList());
         Map<Integer, List<MesBuildingProcess>> mesBuildingProcessMap = this.mesBuildingProcessService
            .listByIds(processIds)
            .stream()
            .collect(Collectors.groupingBy(MesBuildingProcess::getProductType));

         for (Integer productType : Arrays.asList(TaskTypeEnum.MACHINE_PART.getType(), TaskTypeEnum.ASSEMBLE.getType(), TaskTypeEnum.ARTIFACT.getType())) {
            List<MesBuildingProcess> mesBuildingProcesses = mesBuildingProcessMap.get(productType);
            if (!CollectionUtils.isEmpty(mesBuildingProcesses)) {
               for (MesBuildingProcess process : mesBuildingProcesses.stream()
                  .sorted(Comparator.comparing(MesBuildingProcess::getSort))
                  .collect(Collectors.toList())) {
                  BigDecimal taskTotalNetWeight = BigDecimal.ZERO;
                  BigDecimal taskTotalGrossWeight = BigDecimal.ZERO;
                  BigDecimal taskCompanyTotalNetWeight = BigDecimal.ZERO;
                  BigDecimal taskCompanyTotalGrossWeight = BigDecimal.ZERO;
                  int taskTotalQuantity = 0;
                  int taskCompanyTotalQuantity = 0;
                  List<MesBuildingTaskProcess> mesBuildingTaskProcesses = taskProcessMap.get(process.getId());
                  if (ProductTypeEnum.ARTIFACT.getType().equals(productType)) {
                     taskTotalNetWeight = mesBuildingTaskProcesses.stream()
                        .map(e -> artifactMap.get(e.getProductId()).getNetWeight().multiply(BigDecimal.valueOf(e.getTaskQuantity().intValue())))
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
                        .divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP);
                     taskTotalGrossWeight = mesBuildingTaskProcesses.stream()
                        .map(e -> artifactMap.get(e.getProductId()).getGrossWeight().multiply(BigDecimal.valueOf(e.getTaskQuantity().intValue())))
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
                        .divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP);
                     taskTotalQuantity = mesBuildingTaskProcesses.stream().mapToInt(MesBuildingTaskProcess::getTaskQuantity).sum();
                     taskCompanyTotalNetWeight = mesBuildingTaskProcesses.stream()
                        .map(e -> artifactMap.get(e.getProductId()).getNetWeight().multiply(BigDecimal.valueOf(e.getInspectionQuantity().intValue())))
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
                        .divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP);
                     taskCompanyTotalGrossWeight = mesBuildingTaskProcesses.stream()
                        .map(e -> artifactMap.get(e.getProductId()).getGrossWeight().multiply(BigDecimal.valueOf(e.getInspectionQuantity().intValue())))
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
                        .divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP);
                     taskCompanyTotalQuantity = mesBuildingTaskProcesses.stream().mapToInt(MesBuildingTaskProcess::getInspectionQuantity).sum();
                  }

                  if (ProductTypeEnum.ASSEMBLE.getType().equals(productType)) {
                     taskTotalNetWeight = mesBuildingTaskProcesses.stream()
                        .map(e -> assembleMap.get(e.getProductId()).getNetWeight().multiply(BigDecimal.valueOf(e.getTaskQuantity().intValue())))
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
                        .divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP);
                     taskTotalGrossWeight = mesBuildingTaskProcesses.stream()
                        .map(e -> assembleMap.get(e.getProductId()).getGrossWeight().multiply(BigDecimal.valueOf(e.getTaskQuantity().intValue())))
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
                        .divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP);
                     taskTotalQuantity = mesBuildingTaskProcesses.stream().mapToInt(MesBuildingTaskProcess::getTaskQuantity).sum();
                     taskCompanyTotalNetWeight = mesBuildingTaskProcesses.stream()
                        .map(e -> assembleMap.get(e.getProductId()).getNetWeight().multiply(BigDecimal.valueOf(e.getInspectionQuantity().intValue())))
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
                        .divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP);
                     taskCompanyTotalGrossWeight = mesBuildingTaskProcesses.stream()
                        .map(e -> assembleMap.get(e.getProductId()).getGrossWeight().multiply(BigDecimal.valueOf(e.getInspectionQuantity().intValue())))
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
                        .divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP);
                     taskCompanyTotalQuantity = mesBuildingTaskProcesses.stream().mapToInt(MesBuildingTaskProcess::getInspectionQuantity).sum();
                  }

                  if (ProductTypeEnum.MACHINE_PART.getType().equals(productType)) {
                     taskTotalNetWeight = mesBuildingTaskProcesses.stream()
                        .map(e -> machinePartMap.get(e.getProductId()).getNetWeight().multiply(BigDecimal.valueOf(e.getTaskQuantity().intValue())))
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
                        .divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP);
                     taskTotalGrossWeight = mesBuildingTaskProcesses.stream()
                        .map(e -> machinePartMap.get(e.getProductId()).getGrossWeight().multiply(BigDecimal.valueOf(e.getTaskQuantity().intValue())))
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
                        .divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP);
                     taskTotalQuantity = mesBuildingTaskProcesses.stream().mapToInt(MesBuildingTaskProcess::getTaskQuantity).sum();
                     taskCompanyTotalNetWeight = mesBuildingTaskProcesses.stream()
                        .map(e -> machinePartMap.get(e.getProductId()).getNetWeight().multiply(BigDecimal.valueOf(e.getInspectionQuantity().intValue())))
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
                        .divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP);
                     taskCompanyTotalGrossWeight = mesBuildingTaskProcesses.stream()
                        .map(e -> machinePartMap.get(e.getProductId()).getGrossWeight().multiply(BigDecimal.valueOf(e.getInspectionQuantity().intValue())))
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
                        .divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP);
                     taskCompanyTotalQuantity = mesBuildingTaskProcesses.stream().mapToInt(MesBuildingTaskProcess::getInspectionQuantity).sum();
                  }

                  ProjectProductionStatisticsProcessDTO processDTO = ProjectProductionStatisticsProcessDTO.builder()
                     .processId(process.getId())
                     .processName(process.getName())
                     .taskTotalQuantity(taskTotalQuantity)
                     .taskTotalNetWeight(taskTotalNetWeight)
                     .taskTotalGrossWeight(taskTotalGrossWeight)
                     .taskCompanyTotalQuantity(taskCompanyTotalQuantity)
                     .taskCompanyTotalNetWeight(taskCompanyTotalNetWeight)
                     .taskCompanyTotalGrossWeight(taskCompanyTotalGrossWeight)
                     .build();
                  productionStatisticsProcessDTOS.add(processDTO);
               }
            }
         }
      }

      return productionStatisticsProcessDTOS;
   }
}
