package com.hzchum.scim.mes.building.core.biz.impl.projectKanban;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DatePattern;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.projectKanban.ProductionSignageBiz;
import com.hzchum.scim.mes.building.core.api.enums.KanBanProcessTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.ProductKanBanCompanyStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.ProductKanBanEnum;
import com.hzchum.scim.mes.building.core.api.enums.ProductStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseRecordStatusTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel._package.MesBuildingPackageNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoList;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoListProductNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingMachinePartSchedulingLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssist;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssistNumberDetail;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingComplete;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingMachinePartSchedulingArtifactTaskLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceInspectionTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNeedMachinePartScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.pojo._dto.ProjectProductionStatistics.MesTeamReportProductStaticsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingProjectProductionLineDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingProjectTeamDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingProjectWorkshopDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ClassificationBaseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProcessSummaryDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProjectKanArtifactTaskWorkShopDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProjectKanBanIdAndQuantityDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProjectKanBanProductProductionStateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProjectProductionKanBanCargoDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProjectProductionKanBanDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProjectProductionKanBanListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProjectProductionKanBanNameInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProjectProductionKanBanProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProjectProductionKanBanReportDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.ProjectSignageProductionSumDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.TeamTraceDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.produceTeamRecourseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.projectProductionDashboardCardDisplayDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.projectProductionDashboardCardDisplayDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesSignageProcessLinkDTO;
import com.hzchum.scim.mes.building.core.api.service._package.MesBuildingPackageNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service._package.MesBuildingPackageService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListProductNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingMachinePartSchedulingLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingAssistNumberDetailService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingAssistService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingMachinePartSchedulingArtifactTaskLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceInspectionTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNeedMachinePartSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskOrderService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleDetail;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleDetailService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.MesInspectConfigUserLink;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleConfig;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureClassification;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesInspectConfigBasicDTO;
import com.hzchum.scim.system.core.api.service.MesInspectConfigService;
import com.hzchum.scim.system.core.api.service.MesInspectConfigUserLinkService;
import com.hzchum.scim.system.core.api.service.SysAssembleConfigService;
import com.hzchum.scim.system.core.api.service.SysStructureClassificationService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class ProductionSignageBizImpl implements ProductionSignageBiz {
   @Resource
   private ContractProjectService projectService;
   @Resource
   private PlanMonomerService monomerService;
   @Resource
   private PlanAreaService areaService;
   @Resource
   private MesBuildingTaskService taskService;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private TechAssembleService assembleService;
   @Resource
   private TechMachinePartService machinePartService;
   @Resource
   private SysStructureClassificationService classificationService;
   @Resource
   private SysAssembleConfigService assembleConfigService;
   @Resource
   private MesBuildingTaskProcessService taskProcessService;
   @Resource
   private MesBuildingProcessService mesBuildingProcessService;
   @Resource
   private MesBuildingTaskNumberLinkService taskNumberLinkService;
   @Resource
   private MesBuildingProduceTeamReportService produceTeamReportService;
   @Resource
   private MesBuildingTaskNeedMachinePartSchedulingService taskNeedMachinePartSchedulingService;
   @Resource
   private MesBuildingProcessService processService;
   @Resource
   private MesBuildingTeamService teamService;
   @Resource
   private MesBuildingTeamUserLinkService teamUserLinkService;
   @Resource
   private MesBuildingProductionLineService productionLineService;
   @Resource
   private TechAssembleDetailService assembleDetailService;
   @Resource
   private MesBuildingMachinePartSchedulingArtifactTaskLinkService schedulingArtifactTaskLinkService;
   @Resource
   private MesBuildingMachinePartSchedulingLinkService partSchedulingLinkService;
   @Resource
   private TechArtifactMachinePartLinkService artifactMachinePartLinkService;
   @Resource
   private MesBuildingAssistService assistService;
   @Resource
   private UserService userService;
   @Resource
   private MesInspectConfigService inspectConfigService;
   @Resource
   private MesInspectConfigUserLinkService inspectConfigUserLinkService;
   @Resource
   private MesBuildingCompleteService completeService;
   @Resource
   private MesBuildingCargoListProductNumberLinkService cargoListProductNumberLinkService;
   @Resource
   private MesBuildingAssistNumberDetailService assistNumberDetailService;
   @Resource
   private MesBuildingWarehouseRecordService warehouseRecordService;
   @Resource
   private MesBuildingWorkshopService workshopService;
   @Resource
   private MesBuildingCargoListService cargoListService;
   @Resource
   private MesBuildingTaskOrderService taskOrderService;
   @Resource
   private MesBuildingProduceInspectionTeamReportService produceInspectionTeamReportService;
   @Resource
   private MesBuildingPackageNumberLinkService packageNumberLinkService;
   @Resource
   private MesBuildingPackageService packageService;

   @Override
   public ProjectSignageProductionSumDTO projectSignageProductionSum(
      Long projectId, Long workShopId, Long productionLineId, Long monomerId, List<Long> areaIds, List<Long> areaBatchIds
   ) {
      ProjectSignageProductionSumDTO productionSumDTO = ProjectSignageProductionSumDTO.builder().build();
      List<MesBuildingTask> allTaskList = this.taskService
         .list(
            ((((((new LambdaQueryWrapper<MesBuildingTask>()
                                 .in(
                                    MesBuildingTask::getTaskTypeEnum,
                                    TaskTypeEnum.ARTIFACT.getType(),
                                    TaskTypeEnum.ASSEMBLE.getType(),
                                    TaskTypeEnum.MACHINE_PART.getType()
                                 ))
                              .eq(MesBuildingTask::getProjectId, projectId))
                           .eq(workShopId != null, MesBuildingTask::getWorkshopId, workShopId))
                        .eq(productionLineId != null, MesBuildingTask::getProductionLineId, productionLineId))
                     .eq(monomerId != null, MesBuildingTask::getMonomerId, monomerId))
                  .in(CollectionUtils.isNotEmpty(areaIds), MesBuildingTask::getAreaId, areaIds))
               .in(CollectionUtils.isNotEmpty(areaBatchIds), MesBuildingTask::getAreaBatchId, areaBatchIds)
         );
      List<MesBuildingTaskNeedMachinePartScheduling> taskNeedMachinePartSchedulings = this.taskNeedMachinePartSchedulingService
         .list(
            (((new LambdaQueryWrapper<MesBuildingTaskNeedMachinePartScheduling>()
                        .eq(MesBuildingTaskNeedMachinePartScheduling::getProjectId, projectId))
                     .eq(monomerId != null, MesBuildingTaskNeedMachinePartScheduling::getMonomerId, monomerId))
                  .in(CollectionUtils.isNotEmpty(areaIds), MesBuildingTaskNeedMachinePartScheduling::getAreaId, areaIds))
               .in(CollectionUtils.isNotEmpty(areaBatchIds), MesBuildingTaskNeedMachinePartScheduling::getAreaBatchId, areaBatchIds)
         );
      if (CollectionUtils.isNotEmpty(taskNeedMachinePartSchedulings)) {
         productionSumDTO.setPartNeedTaskQuantity(taskNeedMachinePartSchedulings.stream().mapToInt(e -> e.getNeedQuantity() - e.getSchedulingQuantity()).sum());
      }

      int totalArtifactSum = 0;
      List<TechArtifact> artifacts = this.artifactService
         .list(
            (((new LambdaQueryWrapper<TechArtifact>().eq(TechArtifact::getProjectId, projectId))
                     .eq(monomerId != null, TechArtifact::getMonomerId, monomerId))
                  .in(CollectionUtils.isNotEmpty(areaIds), TechArtifact::getAreaId, areaIds))
               .select(TechArtifact::getQuantity, TechArtifact::getSubscriptionQuantity)
         );
      if (CollectionUtils.isNotEmpty(artifacts)) {
         totalArtifactSum = artifacts.stream().mapToInt(e -> e.getQuantity() - e.getSubscriptionQuantity()).sum();
      }

      if (CollectionUtils.isEmpty(allTaskList)) {
         return productionSumDTO;
      }

      Map<Integer, List<MesBuildingTask>> allTaskMap = allTaskList.stream().collect(Collectors.groupingBy(MesBuildingTask::getTaskTypeEnum));
      Integer finalTotalArtifactSum = totalArtifactSum;
      allTaskMap.forEach((taskTypeEnum, tasks) -> {
         int taskQuantity = tasks.stream().mapToInt(MesBuildingTask::getTaskQuantity).sum();
         int completeQuantity = tasks.stream().mapToInt(MesBuildingTask::getCompleteQuantity).sum();
         if (TaskTypeEnum.ARTIFACT.getType().equals(taskTypeEnum)) {
            productionSumDTO.setArtifactCompanyQuantity(completeQuantity);
            productionSumDTO.setArtifactTaskQuantity(taskQuantity);
            productionSumDTO.setArtifactNoTaskQuantity(finalTotalArtifactSum - productionSumDTO.getArtifactTaskQuantity());
         }

         if (TaskTypeEnum.ASSEMBLE.getType().equals(taskTypeEnum)) {
            productionSumDTO.setAssembleCompanyQuantity(completeQuantity);
            productionSumDTO.setAssembleTaskQuantity(taskQuantity);
         }

         if (TaskTypeEnum.MACHINE_PART.getType().equals(taskTypeEnum)) {
            productionSumDTO.setPartCompanyQuantity(completeQuantity);
            productionSumDTO.setPartTaskQuantity(taskQuantity);
         }
      });
      return productionSumDTO;
   }

   @Override
   public List<ClassificationBaseDTO> projectSignageArtifactClass(
      Long projectId,
      Long workShopId,
      Long productionLineId,
      Long monomerId,
      List<Long> areaIds,
      Integer productType,
      List<Long> areaBatchIds,
      Boolean boolNotIssued
   ) {
      if (!boolNotIssued) {
         List<MesBuildingTask> artifactTaskList = this.taskService
            .list(
               ((((((new LambdaQueryWrapper<MesBuildingTask>()
                                    .eq(MesBuildingTask::getTaskTypeEnum, productType))
                                 .eq(MesBuildingTask::getProjectId, projectId))
                              .eq(workShopId != null, MesBuildingTask::getWorkshopId, workShopId))
                           .eq(productionLineId != null, MesBuildingTask::getProductionLineId, productionLineId))
                        .eq(monomerId != null, MesBuildingTask::getMonomerId, monomerId))
                     .in(CollectionUtils.isNotEmpty(areaIds), MesBuildingTask::getAreaId, areaIds))
                  .in(CollectionUtils.isNotEmpty(areaBatchIds), MesBuildingTask::getAreaBatchId, areaBatchIds)
            );
         if (CollectionUtils.isEmpty(artifactTaskList)) {
            return new ArrayList<>();
         } else {
            List<Long> classificationIds = artifactTaskList.stream().map(MesBuildingTask::getClassificationId).distinct().collect(Collectors.toList());
            if (ProductTypeEnum.ARTIFACT.getType().equals(productType)) {
               List<SysStructureClassification> structureClassifications = this.classificationService.listByIds(classificationIds);
               return structureClassifications.stream()
                  .map(
                     e -> ClassificationBaseDTO.builder()
                        .classificationName(e.getClassificationName())
                        .mesProductEnum(e.getMesProductEnum())
                        .artifactType(e.getArtifactType())
                        .id(e.getId())
                        .build()
                  )
                  .collect(Collectors.toList());
            } else if (ProductTypeEnum.ASSEMBLE.getType().equals(productType)) {
               List<SysAssembleConfig> sysAssembleConfigs = this.assembleConfigService.listByIds(classificationIds);
               return sysAssembleConfigs.stream()
                  .map(e -> ClassificationBaseDTO.builder().classificationName(e.getName()).mesProductEnum(e.getMesProductEnum()).id(e.getId()).build())
                  .collect(Collectors.toList());
            } else {
               return new ArrayList<>();
            }
         }
      } else {
         Preconditions.checkArgument(ProductTypeEnum.ARTIFACT.getType().equals(productType), "仅构件可查看未排产列表");
         List<ProjectKanBanProductProductionStateDTO> artifactSchedulingList = this.taskService
            .findArtifactSchedulingList(projectId, monomerId, areaIds, null, null, areaBatchIds);
         if (CollectionUtils.isEmpty(artifactSchedulingList)) {
            return new ArrayList<>();
         }

         List<SysStructureClassification> structureClassifications = this.classificationService
            .listByIds(artifactSchedulingList.stream().map(ProjectKanBanProductProductionStateDTO::getClassificationId).distinct().collect(Collectors.toList()));
         return structureClassifications.stream()
            .map(
               e -> ClassificationBaseDTO.builder()
                  .classificationName(e.getClassificationName())
                  .mesProductEnum(e.getMesProductEnum())
                  .artifactType(e.getArtifactType())
                  .id(e.getId())
                  .build()
            )
            .collect(Collectors.toList());
      }
   }

   @Override
   public List<ProjectProductionKanBanNameInfoDTO> projectSignageProcessList(
      Long projectId,
      Long monomerId,
      List<Long> areaIds,
      Long classId,
      Long workshopId,
      Long productionLineId,
      String productSerialNumber,
      List<Long> areaBatchIds,
      String assembleSerialNumber
   ) {
      List<Long> artifactIds = null;
      if (StringUtils.isNotBlank(assembleSerialNumber)) {
         List<TechAssemble> assembles = this.assembleService
            .list(
               (((((new LambdaQueryWrapper<TechAssemble>()
                                 .eq(TechAssemble::getProjectId, projectId))
                              .eq(monomerId != null, TechAssemble::getMonomerId, monomerId))
                           .in(CollectionUtils.isNotEmpty(areaIds), TechAssemble::getAreaId, areaIds))
                        .in(CollectionUtils.isNotEmpty(areaBatchIds), TechAssemble::getAreaBatchId, areaBatchIds))
                     .like(TechAssemble::getSerialNumber, assembleSerialNumber))
                  .select(TechAssemble::getId)
            );
         if (CollectionUtils.isEmpty(assembles)) {
            return new ArrayList<>();
         }

         List<TechAssembleDetail> assembleDetailList = this.assembleDetailService
            .list(
               (Wrapper<TechAssembleDetail>)new LambdaQueryWrapper<TechAssembleDetail>()
                  .in(TechAssembleDetail::getAssembleId, assembles.stream().map(TechAssemble::getId).distinct().collect(Collectors.toList()))
            );
         artifactIds = CollectionUtils.isEmpty(assembleDetailList)
            ? null
            : assembleDetailList.stream().map(TechAssembleDetail::getArtifactId).distinct().collect(Collectors.toList());
      }

      List<MesSignageProcessLinkDTO> mesBuildingProductionPlanningDTOS = this.taskProcessService
         .listSignageProcess(projectId, monomerId, areaIds, classId, workshopId, productionLineId, productSerialNumber, areaBatchIds, artifactIds);
      if (CollectionUtils.isEmpty(mesBuildingProductionPlanningDTOS)) {
         return new ArrayList<>();
      }

      List<Long> artifactTaskProcessIds = mesBuildingProductionPlanningDTOS.stream()
         .map(MesSignageProcessLinkDTO::getTaskProcessId)
         .distinct()
         .collect(Collectors.toList());
      Map<Long, List<MesBuildingAssist>> artifactAssistProcessListMap = this.assistService
         .list((Wrapper<MesBuildingAssist>)new LambdaQueryWrapper<MesBuildingAssist>().in(MesBuildingAssist::getTaskProcessId, artifactTaskProcessIds))
         .stream()
         .collect(Collectors.groupingBy(MesBuildingAssist::getProcessId));
      Map<Long, List<MesSignageProcessLinkDTO>> artifactLinkDTOMap = mesBuildingProductionPlanningDTOS.stream()
         .collect(Collectors.groupingBy(MesSignageProcessLinkDTO::getProcessId));
      List<Long> processIds = mesBuildingProductionPlanningDTOS.stream().map(MesSignageProcessLinkDTO::getProcessId).distinct().collect(Collectors.toList());
      Map<Long, List<MesBuildingProduceInspectionTeamReport>> artifactInspectionTeamReportMap = this.produceInspectionTeamReportService
         .list(
            (Wrapper<MesBuildingProduceInspectionTeamReport>)new LambdaQueryWrapper<MesBuildingProduceInspectionTeamReport>()
               .in(
                  MesBuildingProduceInspectionTeamReport::getTaskProcessId,
                  mesBuildingProductionPlanningDTOS.stream().map(MesSignageProcessLinkDTO::getTaskProcessId).collect(Collectors.toList())
               )
         )
         .stream()
         .collect(Collectors.groupingBy(MesBuildingProduceInspectionTeamReport::getTaskProcessId));
      Map<Long, List<MesBuildingProduceInspectionTeamReport>> assembleInspectionTeamReportMap = new HashMap<>();
      List<MesBuildingTaskNumberLink> assembleTaskNumberLinks = this.taskNumberLinkService
         .list(
            (Wrapper<MesBuildingTaskNumberLink>)(new LambdaQueryWrapper<MesBuildingTaskNumberLink>().isNotNull(MesBuildingTaskNumberLink::getAssembleTaskId))
               .in(
                  MesBuildingTaskNumberLink::getArtifactTaskId,
                  mesBuildingProductionPlanningDTOS.stream().map(MesSignageProcessLinkDTO::getTaskId).collect(Collectors.toList())
               )
         );
      Map<Long, List<MesBuildingTaskProcess>> assembleLinkDTOMap = new HashMap<>();
      Map<Long, List<MesBuildingAssist>> assembleAssistProcessListMap = new HashMap<>();
      Map<Long, TechAssemble> assembleMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(assembleTaskNumberLinks)) {
         List<MesBuildingTaskProcess> taskProcesses = this.taskProcessService
            .list(
               (Wrapper<MesBuildingTaskProcess>)(new LambdaQueryWrapper<MesBuildingTaskProcess>()
                     .eq(MesBuildingTaskProcess::getTaskTypeEnum, TaskTypeEnum.ASSEMBLE.getType()))
                  .in(
                     MesBuildingTaskProcess::getTaskId,
                     assembleTaskNumberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleTaskId).distinct().collect(Collectors.toList())
                  )
            );
         if (CollectionUtils.isNotEmpty(taskProcesses)) {
            processIds.addAll(taskProcesses.stream().map(MesBuildingTaskProcess::getProcessId).distinct().collect(Collectors.toList()));
            assembleLinkDTOMap = taskProcesses.stream().collect(Collectors.groupingBy(MesBuildingTaskProcess::getProcessId));
            assembleAssistProcessListMap = this.assistService
               .list(
                  (Wrapper<MesBuildingAssist>)new LambdaQueryWrapper<MesBuildingAssist>()
                     .in(MesBuildingAssist::getTaskProcessId, taskProcesses.stream().map(MesBuildingTaskProcess::getId).distinct().collect(Collectors.toList()))
               )
               .stream()
               .collect(Collectors.groupingBy(MesBuildingAssist::getProcessId));
            assembleMap = this.assembleService
               .listByIds(taskProcesses.stream().map(MesBuildingTaskProcess::getProductId).distinct().collect(Collectors.toList()))
               .stream()
               .collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
            assembleInspectionTeamReportMap = this.produceInspectionTeamReportService
               .list(
                  (Wrapper<MesBuildingProduceInspectionTeamReport>)new LambdaQueryWrapper<MesBuildingProduceInspectionTeamReport>()
                     .in(
                        MesBuildingProduceInspectionTeamReport::getTaskProcessId,
                        taskProcesses.stream().map(MesBuildingTaskProcess::getId).collect(Collectors.toList())
                     )
               )
               .stream()
               .collect(Collectors.groupingBy(MesBuildingProduceInspectionTeamReport::getTaskProcessId));
         }
      }

      List<ProjectProductionKanBanNameInfoDTO> processList = new ArrayList<>();
      ProjectProductionKanBanNameInfoDTO partNameInfo = ProjectProductionKanBanNameInfoDTO.builder()
         .name("零件")
         .id(0L)
         .productType(ProductTypeEnum.MACHINE_PART.getType())
         .processType(KanBanProcessTypeEnum.REPORT.getType())
         .build();
      processList.add(partNameInfo);
      Map<Integer, List<MesBuildingProcess>> mesBuildingProcessMap = this.mesBuildingProcessService
         .listByIds(processIds)
         .stream()
         .collect(Collectors.groupingBy(MesBuildingProcess::getProductType));
      List<Integer> proDuctList = Arrays.asList(TaskTypeEnum.ASSEMBLE.getType(), TaskTypeEnum.ARTIFACT.getType());
      Map<String, List<MesInspectConfigBasicDTO>> configBasicDTOMap = this.inspectConfigService
         .queryAllInspectConfigList()
         .stream()
         .collect(Collectors.groupingBy(e -> e.getProcessId() + "-" + e.getTeamId() + "-" + e.getClassificationId()));

      for (Integer productType : proDuctList) {
         List<MesBuildingProcess> mesBuildingProcesses = mesBuildingProcessMap.get(productType);
         if (!CollectionUtils.isEmpty(mesBuildingProcesses)) {
            mesBuildingProcesses = mesBuildingProcesses.stream().sorted(Comparator.comparingInt(MesBuildingProcess::getSort)).collect(Collectors.toList());
            if (ProductTypeEnum.ASSEMBLE.getType().equals(productType)) {
               for (MesBuildingProcess mesBuildingProcess : mesBuildingProcesses) {
                  ProjectProductionKanBanNameInfoDTO nameInfoDTO = BeanUtil.copyProperties(mesBuildingProcess, ProjectProductionKanBanNameInfoDTO.class);
                  nameInfoDTO.setProcessType(KanBanProcessTypeEnum.REPORT.getType());
                  processList.add(nameInfoDTO);
                  List<MesBuildingTaskProcess> mesSignageProcessLinkDTOS = assembleLinkDTOMap.get(mesBuildingProcess.getId());
                  if (CollectionUtils.isNotEmpty(mesSignageProcessLinkDTOS)) {
                     Map<Long, TechAssemble> finalAssembleMap = assembleMap;
                     boolean flag = true;
                     List<MesBuildingAssist> mesBuildingAssists = assembleAssistProcessListMap.get(mesBuildingProcess.getId());
                     if (CollectionUtils.isNotEmpty(mesBuildingAssists)
                        && mesBuildingAssists.stream()
                           .anyMatch(e -> configBasicDTOMap.containsKey(e.getProcessId() + "-" + e.getTeamId() + "-" + e.getClassId()))
                        && !mesBuildingAssists.stream().allMatch(e -> e.getQuantity().equals(e.getProduceQuantity()))) {
                        ProjectProductionKanBanNameInfoDTO kanBanNameInfoDTO = ProjectProductionKanBanNameInfoDTO.builder()
                           .productType(productType)
                           .id(mesBuildingProcess.getId())
                           .name(mesBuildingProcess.getName() + "质检")
                           .processType(KanBanProcessTypeEnum.INSPECTION.getType())
                           .build();
                        processList.add(kanBanNameInfoDTO);
                        flag = false;
                     }

                     if (flag
                        && mesSignageProcessLinkDTOS.stream()
                           .anyMatch(
                              e -> configBasicDTOMap.containsKey(
                                 e.getProcessId() + "-" + e.getTeamId() + "-" + finalAssembleMap.get(e.getProductId()).getAssembleConfigId()
                              )
                           )
                        && !mesSignageProcessLinkDTOS.stream().allMatch(e -> e.getTaskQuantity().equals(e.getInspectionQuantity()))) {
                        ProjectProductionKanBanNameInfoDTO kanBanNameInfoDTO = ProjectProductionKanBanNameInfoDTO.builder()
                           .productType(productType)
                           .id(mesBuildingProcess.getId())
                           .name(mesBuildingProcess.getName() + "质检")
                           .processType(KanBanProcessTypeEnum.INSPECTION.getType())
                           .build();
                        processList.add(kanBanNameInfoDTO);
                        flag = false;
                     }

                     if (flag) {
                        List<MesBuildingTaskProcess> processLinkDTOS = mesSignageProcessLinkDTOS.stream()
                           .filter(e -> e.getTaskQuantity().equals(e.getInspectionQuantity()))
                           .collect(Collectors.toList());
                        if (CollectionUtils.isNotEmpty(processLinkDTOS)) {
                           Map<Long, List<MesBuildingProduceInspectionTeamReport>> finalAssembleInspectionTeamReportMap = assembleInspectionTeamReportMap;
                           if (processLinkDTOS.stream().anyMatch(e -> CollectionUtils.isNotEmpty(finalAssembleInspectionTeamReportMap.get(e.getId())))) {
                              ProjectProductionKanBanNameInfoDTO kanBanNameInfoDTO = ProjectProductionKanBanNameInfoDTO.builder()
                                 .productType(productType)
                                 .id(mesBuildingProcess.getId())
                                 .name(mesBuildingProcess.getName() + "质检")
                                 .processType(KanBanProcessTypeEnum.INSPECTION.getType())
                                 .build();
                              processList.add(kanBanNameInfoDTO);
                           }
                        }
                     }
                  }
               }
            }

            if (ProductTypeEnum.ARTIFACT.getType().equals(productType)) {
               for (MesBuildingProcess mesBuildingProcess : mesBuildingProcesses) {
                  ProjectProductionKanBanNameInfoDTO nameInfoDTO = BeanUtil.copyProperties(mesBuildingProcess, ProjectProductionKanBanNameInfoDTO.class);
                  nameInfoDTO.setProcessType(KanBanProcessTypeEnum.REPORT.getType());
                  processList.add(nameInfoDTO);
                  List<MesSignageProcessLinkDTO> mesSignageProcessLinkDTOS = artifactLinkDTOMap.get(mesBuildingProcess.getId());
                  if (CollectionUtils.isNotEmpty(mesSignageProcessLinkDTOS)) {
                     boolean flag = true;
                     List<MesBuildingAssist> mesBuildingAssists = artifactAssistProcessListMap.get(mesBuildingProcess.getId());
                     if (CollectionUtils.isNotEmpty(mesBuildingAssists)
                        && mesBuildingAssists.stream()
                           .anyMatch(e -> configBasicDTOMap.containsKey(e.getProcessId() + "-" + e.getTeamId() + "-" + e.getClassId()))
                        && !mesBuildingAssists.stream().allMatch(e -> e.getQuantity().equals(e.getProduceQuantity()))) {
                        ProjectProductionKanBanNameInfoDTO kanBanNameInfoDTO = ProjectProductionKanBanNameInfoDTO.builder()
                           .productType(productType)
                           .id(mesBuildingProcess.getId())
                           .name(mesBuildingProcess.getName() + "质检")
                           .processType(KanBanProcessTypeEnum.INSPECTION.getType())
                           .build();
                        processList.add(kanBanNameInfoDTO);
                        flag = false;
                     }

                     if (flag
                        && mesSignageProcessLinkDTOS.stream()
                           .anyMatch(e -> configBasicDTOMap.containsKey(e.getProcessId() + "-" + e.getTeamId() + "-" + e.getClassId()))
                        && !mesSignageProcessLinkDTOS.stream().allMatch(e -> e.getTaskQuantity().equals(e.getInspectionQuantity()))) {
                        ProjectProductionKanBanNameInfoDTO kanBanNameInfoDTO = ProjectProductionKanBanNameInfoDTO.builder()
                           .productType(productType)
                           .id(mesBuildingProcess.getId())
                           .name(mesBuildingProcess.getName() + "质检")
                           .processType(KanBanProcessTypeEnum.INSPECTION.getType())
                           .build();
                        processList.add(kanBanNameInfoDTO);
                        flag = false;
                     }

                     if (flag) {
                        List<MesSignageProcessLinkDTO> processLinkDTOS = mesSignageProcessLinkDTOS.stream()
                           .filter(e -> e.getTaskQuantity().equals(e.getInspectionQuantity()))
                           .collect(Collectors.toList());
                        if (CollectionUtils.isNotEmpty(processLinkDTOS)
                           && processLinkDTOS.stream().anyMatch(e -> CollectionUtils.isNotEmpty(artifactInspectionTeamReportMap.get(e.getTaskProcessId())))) {
                           ProjectProductionKanBanNameInfoDTO kanBanNameInfoDTO = ProjectProductionKanBanNameInfoDTO.builder()
                              .productType(productType)
                              .id(mesBuildingProcess.getId())
                              .name(mesBuildingProcess.getName() + "质检")
                              .processType(KanBanProcessTypeEnum.INSPECTION.getType())
                              .build();
                           processList.add(kanBanNameInfoDTO);
                        }
                     }
                  }
               }
            }
         }
      }

      ProjectProductionKanBanNameInfoDTO cargoNameInfo = ProjectProductionKanBanNameInfoDTO.builder()
         .name("发运")
         .id(-1L)
         .productType(ProductTypeEnum.ARTIFACT.getType())
         .processType(KanBanProcessTypeEnum.CARGO.getType())
         .build();
      processList.add(cargoNameInfo);
      return processList;
   }

   @Override
   public PageVO<ProjectProductionKanBanListDTO> projectSignageProcessProductList(
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
      String assembleSerialNumber,
      Long processId,
      Integer processStatus,
      Integer pageNumber,
      Integer pageSize
   ) {
      List<Long> artifactIds = null;
      if (StringUtils.isNotBlank(assembleSerialNumber)) {
         List<TechAssemble> assembles = this.assembleService
            .list(
               (((((new LambdaQueryWrapper<TechAssemble>()
                                 .eq(TechAssemble::getProjectId, projectId))
                              .eq(monomerId != null, TechAssemble::getMonomerId, monomerId))
                           .in(CollectionUtils.isNotEmpty(areaIds), TechAssemble::getAreaId, areaIds))
                        .in(CollectionUtils.isNotEmpty(areaBatchIds), TechAssemble::getAreaBatchId, areaBatchIds))
                     .like(TechAssemble::getSerialNumber, assembleSerialNumber))
                  .select(TechAssemble::getId)
            );
         if (CollectionUtils.isEmpty(assembles)) {
            return new PageVO<>();
         }

         List<TechAssembleDetail> assembleDetailList = this.assembleDetailService
            .list(
               (Wrapper<TechAssembleDetail>)new LambdaQueryWrapper<TechAssembleDetail>()
                  .in(TechAssembleDetail::getAssembleId, assembles.stream().map(TechAssemble::getId).distinct().collect(Collectors.toList()))
            );
         artifactIds = CollectionUtils.isEmpty(assembleDetailList)
            ? null
            : assembleDetailList.stream().map(TechAssembleDetail::getArtifactId).distinct().collect(Collectors.toList());
      }

      List<ProjectProductionKanBanListDTO> kanBanArtifactTaskList = this.taskService
         .findKanBanArtifactTaskList(
            projectId, workShopId, productionLineId, monomerId, areaIds, classId, serialNumber, productKanBanEnum, dateTimeList, areaBatchIds, artifactIds
         );
      if (CollectionUtils.isEmpty(kanBanArtifactTaskList)) {
         return new PageVO<>();
      }

      Map<Long, MesBuildingProcess> processMap = this.processService.list().stream().collect(Collectors.toMap(MesBuildingProcess::getId, Function.identity()));
      List<MesInspectConfigUserLink> inspectConfigUserLinks = this.inspectConfigUserLinkService.list();
      Map<Long, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
      Map<Long, List<MesInspectConfigUserLink>> inspectConfigUserLinkMap = inspectConfigUserLinks.stream()
         .collect(Collectors.groupingBy(MesInspectConfigUserLink::getInspectConfigId));
      List<ProjectProductionKanBanListDTO> retunKanBanArtifactTaskList = new ArrayList<>();
      Map<String, ProjectProductionKanBanProcessDTO> productionKanBanProcessDTOMap = new HashMap<>();
      List<Long> artifactTaskIds = kanBanArtifactTaskList.stream().map(ProjectProductionKanBanListDTO::getTaskId).collect(Collectors.toList());
      Map<String, List<MesInspectConfigBasicDTO>> configBasicDTOMap = this.inspectConfigService
         .queryAllInspectConfigList()
         .stream()
         .collect(Collectors.groupingBy(e -> e.getProcessId() + "-" + e.getTeamId() + "-" + e.getClassificationId()));
      List<MesBuildingComplete> completes = this.completeService
         .list(
            (Wrapper<MesBuildingComplete>)(new LambdaQueryWrapper<MesBuildingComplete>().in(MesBuildingComplete::getTaskId, artifactTaskIds))
               .eq(MesBuildingComplete::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
         );
      Map<Long, List<MesBuildingWarehouseRecord>> warehouseOutRecordMap = new HashMap<>();
      Map<Long, List<MesBuildingComplete>> completeMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(completes)) {
         warehouseOutRecordMap = this.warehouseRecordService
            .list(
               (Wrapper<MesBuildingWarehouseRecord>)((new LambdaQueryWrapper<MesBuildingWarehouseRecord>()
                        .eq(MesBuildingWarehouseRecord::getType, 2))
                     .eq(MesBuildingWarehouseRecord::getProductType, ProductTypeEnum.ARTIFACT.getType()))
                  .in(MesBuildingWarehouseRecord::getProductId, completes.stream().map(MesBuildingComplete::getProductId).collect(Collectors.toList()))
            )
            .stream()
            .collect(Collectors.groupingBy(MesBuildingWarehouseRecord::getProductId));
         completeMap = completes.stream().collect(Collectors.groupingBy(MesBuildingComplete::getTaskId));
      }

      List<ProjectKanArtifactTaskWorkShopDTO> shopList = this.taskService.findArtifactTaskAssistWorkShop(artifactTaskIds);
      if (CollectionUtils.isNotEmpty(shopList)) {
         kanBanArtifactTaskList.forEach(
            y -> {
               Map<Long, String> assistWorkShop = shopList.stream()
                  .collect(Collectors.toMap(e -> e.getArtifactTaskId(), ProjectKanArtifactTaskWorkShopDTO::getAssistWorkShopNames));
               if (assistWorkShop.get(y.getTaskId()) != null) {
                  Set<String> stringSet = Arrays.stream(assistWorkShop.get(y.getTaskId()).split(",")).collect(Collectors.toSet());
                  stringSet.add(y.getWorkshopName());
                  y.setWorkshopName(String.join(",", stringSet));
               }
            }
         );
      }

      this.buildingTaskPart(artifactTaskIds, productionKanBanProcessDTOMap);
      this.buildingTaskAssemble(artifactTaskIds, productionKanBanProcessDTOMap, configBasicDTOMap, processMap, inspectConfigUserLinkMap, userMap);
      this.buildingTaskArtifact(
         artifactTaskIds, productionKanBanProcessDTOMap, configBasicDTOMap, processMap, inspectConfigUserLinkMap, userMap, completeMap, warehouseOutRecordMap
      );
      List<ProjectProductionKanBanNameInfoDTO> processList = this.projectSignageProcessList(
         projectId, monomerId, areaIds, classId, workShopId, productionLineId, serialNumber, areaBatchIds, assembleSerialNumber
      );
      List<String> sortList = processList.stream().map(e -> e.getId() + e.getName()).collect(Collectors.toList());
      List<ProjectProductionKanBanListDTO> projectProductionKanBanListDTOS = this.getConversionResult(
         productKanBanEnum, productionKanBanProcessDTOMap, kanBanArtifactTaskList, retunKanBanArtifactTaskList, sortList, processId, processStatus
      );
      if (CollectionUtils.isEmpty(projectProductionKanBanListDTOS)) {
         return new PageVO<>();
      }

      Page<ProjectProductionKanBanListDTO> pageVO = PageUtils.getPageVO(
         projectProductionKanBanListDTOS.stream().sorted(Comparator.comparing(ProjectProductionKanBanListDTO::getSerialNumber)).collect(Collectors.toList()),
         pageNumber,
         pageSize
      );
      return new PageVO<>(pageVO);
   }

   @Override
   public void projectSignageProcessProductDownload(
      Long projectId,
      Long workShopId,
      Long productionLineId,
      Long monomerId,
      List<Long> areaIds,
      Long classId,
      String serialNumber,
      String assembleSerialNumber,
      Integer productKanBanEnum,
      List<LocalDateTime> dateTimeList,
      Long processId,
      Integer processStatus,
      HttpServletResponse response
   ) throws IOException {
      List<ProjectProductionKanBanListDTO> dtos = this.projectSignageProcessProductList(
            projectId,
            workShopId,
            productionLineId,
            monomerId,
            areaIds,
            classId,
            serialNumber,
            productKanBanEnum,
            dateTimeList,
            null,
            assembleSerialNumber,
            processId,
            processStatus,
            1,
            Integer.MAX_VALUE
         )
         .getContent();
      this.exportToExcel(dtos, response);
   }

   public void exportToExcel(List<ProjectProductionKanBanListDTO> dataList, HttpServletResponse response) throws IOException {
      Workbook workbook = new XSSFWorkbook();
      Sheet sheet = workbook.createSheet("KanBan");
      Row headerRow = sheet.createRow(0);
      String[] staticHeaders = new String[]{"构件名称", "构件编号", "排产时间", "排产数量", "材质", "规格", "单净重(kg)", "总净重(t)", "单面积(㎡)", "生产车间"};

      for (int i = 0; i < staticHeaders.length; i++) {
         Cell cell = headerRow.createCell(i);
         cell.setCellValue(staticHeaders[i]);
      }

      int dynamicColumnStartIndex = staticHeaders.length;
      List<ProjectProductionKanBanProcessDTO> processDTOS = dataList.isEmpty()
         ? null
         : dataList.stream().max(Comparator.comparingInt(e -> e.getProductionKanBanProcessDTOS().size())).get().getProductionKanBanProcessDTOS();
      if (processDTOS != null && !processDTOS.isEmpty()) {
         for (int i = 0; i < processDTOS.size(); i++) {
            Cell cell = headerRow.createCell(dynamicColumnStartIndex + i * 2);
            cell.setCellValue(processDTOS.get(i).getProcessName());
            Cell cell2 = headerRow.createCell(dynamicColumnStartIndex + i * 2 + 1);
            cell2.setCellValue("完成重量");
         }
      }

      int rowNum = 1;

      for (ProjectProductionKanBanListDTO data : dataList) {
         Row row = sheet.createRow(rowNum++);
         row.createCell(0).setCellValue(data.getName());
         row.createCell(1).setCellValue(data.getSerialNumber());
         row.createCell(2).setCellValue(String.valueOf(data.getSchedulingTime()));
         row.createCell(3).setCellValue(String.valueOf(data.getTaskQuantity()));
         row.createCell(4).setCellValue(data.getMaterial());
         row.createCell(5).setCellValue(data.getSpecification());
         row.createCell(6).setCellValue(data.getNetWeight().toString());
         row.createCell(7).setCellValue(data.getNetWeight().multiply(BigDecimal.valueOf(data.getTaskQuantity().intValue())).divide(BigDecimal.valueOf(1000)).toString());
         row.createCell(8).setCellValue(data.getSurfaceArea().toString());
         row.createCell(9).setCellValue(data.getWorkshopName());
         List<ProjectProductionKanBanProcessDTO> processes = data.getProductionKanBanProcessDTOS();
         Map<String, ProjectProductionKanBanProcessDTO> processMap = processes.stream()
            .collect(Collectors.toMap(s -> s.getProcessType() + "-" + s.getProcessId(), Function.identity()));

         for (int i = 0; i < processDTOS.size(); i++) {
            ProjectProductionKanBanProcessDTO dto = processDTOS.get(i);
            ProjectProductionKanBanProcessDTO processDTO = processMap.get(dto.getProcessType() + "-" + dto.getProcessId());
            if (processDTO != null) {
               if (StringUtils.isNotBlank(processDTO.getProcessName()) && processDTO.getProcessName().contains("质检")) {
                  boolean boolEmpty = processDTO.getTotalInspectionQuantity() == null || processDTO.getTotalInspectionQuantity() == 0;
                  row.createCell(dynamicColumnStartIndex + i * 2).setCellValue(boolEmpty ? "-" : processDTO.getTotalInspectionQuantity().toString());
                  String str = boolEmpty
                     ? "-"
                     : BigDecimal.valueOf(processDTO.getTotalInspectionQuantity().intValue()).multiply(data.getNetWeight()).toString();
                  row.createCell(dynamicColumnStartIndex + i * 2 + 1).setCellValue(str);
               } else {
                  boolean boolEmpty = processDTO.getTotalReportQuantity() == null || processDTO.getTotalReportQuantity() == 0;
                  row.createCell(dynamicColumnStartIndex + i * 2).setCellValue(boolEmpty ? "-" : processDTO.getTotalReportQuantity().toString());
                  String str = boolEmpty ? "-" : BigDecimal.valueOf(processDTO.getTotalReportQuantity().intValue()).multiply(data.getNetWeight()).toString();
                  row.createCell(dynamicColumnStartIndex + i * 2 + 1).setCellValue(str);
               }
            } else {
               row.createCell(dynamicColumnStartIndex + i * 2).setCellValue("-");
               row.createCell(dynamicColumnStartIndex + i * 2 + 1).setCellValue("-");
            }
         }
      }

      response.setCharacterEncoding("UTF-8");
      response.setHeader("content-Type", "application/vnd.ms-excel");
      response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("生产跟踪.xlsx", "UTF-8"));
      response.setHeader("Access-Control-Expose-Headers", "*");
      response.setHeader("Result", "code=" + ResultCodeEnum.SUCCESS.getCode() + ";message=" + ResultCodeEnum.SUCCESS.getCode());
      workbook.write(response.getOutputStream());
      workbook.close();
   }

   @Override
   public List<?> projectSignageProcessProductDetailList(Long artifactTaskId, Long processId, Integer productType, Integer processType) {
      MesBuildingTask artifactTask = this.taskService.getById(artifactTaskId);
      Preconditions.checkArgument(artifactTask != null, "操作失败,构件任务不存在!");
      if (!ProductTypeEnum.MACHINE_PART.getType().equals(productType) && !KanBanProcessTypeEnum.CARGO.getType().equals(processType)) {
         MesBuildingProcess process = this.processService.getById(processId);
         Preconditions.checkArgument(process != null, "操作失败,工序不存在!");
         Preconditions.checkArgument(process.getProductType().equals(productType), "操作失败,产品类型不一致!");
      }

      Map<Long, MesBuildingWorkshop> workshopMap = this.workshopService
         .list()
         .stream()
         .collect(Collectors.toMap(MesBuildingWorkshop::getId, Function.identity()));
      Map<Long, MesBuildingProductionLine> productionLineMap = this.productionLineService
         .list()
         .stream()
         .collect(Collectors.toMap(MesBuildingProductionLine::getId, Function.identity()));
      if (ProductTypeEnum.ARTIFACT.getType().equals(productType)) {
         if (KanBanProcessTypeEnum.REPORT.getType().equals(processType) && !KanBanProcessTypeEnum.CARGO.getType().equals(processType)) {
            List<ProjectProductionKanBanReportDetailDTO> returnReportDetailDTOS = new ArrayList<>();
            List<ProjectProductionKanBanDetailDTO> kanBanProcessProductDetailList = this.taskProcessService
               .getKanBanProcessProductDetail(Collections.singletonList(artifactTaskId), processId, productType);

            for (ProjectProductionKanBanDetailDTO kanBanDetailDTO : kanBanProcessProductDetailList) {
               if (kanBanDetailDTO.getTaskQuantity() > kanBanDetailDTO.getCompanyQuantity()) {
                  ProjectProductionKanBanReportDetailDTO detailDTO = ProjectProductionKanBanReportDetailDTO.builder()
                     .name(kanBanDetailDTO.getName())
                     .serialNumber(kanBanDetailDTO.getSerialNumber())
                     .specification(kanBanDetailDTO.getSpecification())
                     .workShopName(kanBanDetailDTO.getWorkShopName())
                     .productionLineName(kanBanDetailDTO.getProductionLineName())
                     .teamUserName(kanBanDetailDTO.getTeamUserName())
                     .createUserName(null)
                     .createTime(null)
                     .quantity(kanBanDetailDTO.getTaskQuantity() - kanBanDetailDTO.getCompanyQuantity())
                     .boolAssist(kanBanDetailDTO.getBoolAssist())
                     .boolCompleted(Boolean.FALSE)
                     .build();
                  returnReportDetailDTOS.add(detailDTO);
               }
            }

            List<MesBuildingProduceTeamReport> produceTeamReportList = this.produceTeamReportService
               .list(
                  (Wrapper<MesBuildingProduceTeamReport>)(new LambdaQueryWrapper<MesBuildingProduceTeamReport>()
                        .eq(MesBuildingProduceTeamReport::getProcessId, processId))
                     .in(
                        MesBuildingProduceTeamReport::getTaskProcessId,
                        kanBanProcessProductDetailList.stream().map(ProjectProductionKanBanDetailDTO::getTaskProcessId).collect(Collectors.toList())
                     )
               );
            Map<Long, List<ProjectProductionKanBanDetailDTO>> productionKanBanDetailDTOMap = kanBanProcessProductDetailList.stream()
               .collect(Collectors.groupingBy(ProjectProductionKanBanDetailDTO::getProductId));
            if (CollectionUtils.isNotEmpty(produceTeamReportList)) {
               Map<Long, MesBuildingTeamUserLink> teamUserLinkMap = this.teamUserLinkService
                  .list(
                     (Wrapper<MesBuildingTeamUserLink>)(new LambdaQueryWrapper<MesBuildingTeamUserLink>()
                           .eq(MesBuildingTeamUserLink::getBoolLeaderEnum, Boolean.TRUE))
                        .in(
                           MesBuildingTeamUserLink::getTeamId,
                           produceTeamReportList.stream().map(MesBuildingProduceTeamReport::getTeamId).distinct().collect(Collectors.toList())
                        )
                  )
                  .stream()
                  .collect(Collectors.toMap(MesBuildingTeamUserLink::getTeamId, Function.identity()));
               Map<Long, User> userMap = this.userService
                  .listByIds(produceTeamReportList.stream().map(MesBuildingProduceTeamReport::getUserId).distinct().collect(Collectors.toList()))
                  .stream()
                  .collect(Collectors.toMap(User::getId, Function.identity()));
               Map<String, List<MesBuildingProduceTeamReport>> produceTeamReportMap = produceTeamReportList.stream()
                  .collect(
                     Collectors.groupingBy(
                        e -> e.getProductId() + "-" + e.getTeamId() + e.getUserId() + e.getCreateTime().format(DatePattern.NORM_DATETIME_MINUTE_FORMATTER)
                     )
                  );
               produceTeamReportMap.forEach(
                  (teamUserAndTime, produceTeamReports) -> {
                     MesBuildingProduceTeamReport report = produceTeamReports.get(0);
                     ProjectProductionKanBanDetailDTO kanBanDetailDTO = productionKanBanDetailDTOMap.get(report.getProductId()).get(0);
                     ProjectProductionKanBanReportDetailDTO detailDTO = ProjectProductionKanBanReportDetailDTO.builder()
                        .name(kanBanDetailDTO.getName())
                        .serialNumber(kanBanDetailDTO.getSerialNumber())
                        .specification(kanBanDetailDTO.getSpecification())
                        .workShopName(workshopMap.get(report.getWorkshopId()).getName())
                        .productionLineName(productionLineMap.get(report.getProductionLineId()).getName())
                        .teamUserName(teamUserLinkMap.get(report.getTeamId()).getUserName())
                        .createUserName(userMap.get(report.getUserId()).getName())
                        .createTime(report.getCreateTime().format(DatePattern.NORM_DATETIME_MINUTE_FORMATTER))
                        .quantity(produceTeamReports.stream().mapToInt(MesBuildingProduceTeamReport::getQuantity).sum())
                        .boolAssist(report.getAssistId() != null)
                        .boolCompleted(Boolean.TRUE)
                        .build();
                     returnReportDetailDTOS.add(detailDTO);
                  }
               );
            }

            return returnReportDetailDTOS;
         }

         if (KanBanProcessTypeEnum.INSPECTION.getType().equals(processType)) {
            List<ProjectProductionKanBanReportDetailDTO> returnReportDetailDTOS = new ArrayList<>();
            List<ProjectProductionKanBanDetailDTO> kanBanProcessProductDetailList = this.taskProcessService
               .getKanBanProcessInspectionProductDetail(Collections.singletonList(artifactTaskId), processId, productType);
            if (CollectionUtils.isEmpty(kanBanProcessProductDetailList)) {
               return returnReportDetailDTOS;
            }

            List<MesInspectConfigUserLink> allInspectConfigUserLinks = this.inspectConfigUserLinkService.list();
            Map<Long, User> userMap = new HashMap<>();
            if (CollectionUtils.isNotEmpty(allInspectConfigUserLinks)) {
               userMap = this.userService
                  .listByIds(allInspectConfigUserLinks.stream().map(MesInspectConfigUserLink::getInspectUserId).distinct().collect(Collectors.toList()))
                  .stream()
                  .collect(Collectors.toMap(User::getId, Function.identity()));
            }

            Map<Long, List<MesInspectConfigUserLink>> inspectConfigUserLinkMap = allInspectConfigUserLinks.stream()
               .collect(Collectors.groupingBy(MesInspectConfigUserLink::getInspectConfigId));
            Map<String, List<MesInspectConfigBasicDTO>> configBasicDTOMap = this.inspectConfigService
               .queryAllInspectConfigList()
               .stream()
               .collect(Collectors.groupingBy(e -> e.getProcessId() + "-" + e.getTeamId() + "-" + e.getClassificationId()));
            Map<Long, List<MesBuildingProduceTeamReport>> produceTeamReportMap = this.produceTeamReportService
               .list(
                  (Wrapper<MesBuildingProduceTeamReport>)(new LambdaQueryWrapper<MesBuildingProduceTeamReport>()
                        .eq(MesBuildingProduceTeamReport::getInspectionQuantity, 0))
                     .in(
                        MesBuildingProduceTeamReport::getTaskProcessId,
                        kanBanProcessProductDetailList.stream().map(ProjectProductionKanBanDetailDTO::getTaskProcessId).distinct().collect(Collectors.toList())
                     )
               )
               .stream()
               .collect(Collectors.groupingBy(e -> e.getAssistId() == null ? 0L : e.getAssistId()));
            Map<Long, List<ProjectProductionKanBanDetailDTO>> taskProcessIdProductionKanBanDetailDTOMap = kanBanProcessProductDetailList.stream()
               .collect(Collectors.groupingBy(ProjectProductionKanBanDetailDTO::getTaskProcessId));
            Map<Long, User> finalUserMap = userMap;
            produceTeamReportMap.forEach(
               (assistId, produceTeamReportListx) -> produceTeamReportListx.stream()
                  .collect(Collectors.groupingBy(MesBuildingProduceTeamReport::getTeamId))
                  .forEach(
                     (teamId, produceTeamReports) -> {
                        MesBuildingProduceTeamReport teamReport = (MesBuildingProduceTeamReport)produceTeamReportListx.get(0);
                        ProjectProductionKanBanDetailDTO kanBanDetailDTO = taskProcessIdProductionKanBanDetailDTOMap.get(teamReport.getTaskProcessId()).get(0);
                        List<MesInspectConfigBasicDTO> mesInspectConfigBasicDTOS = configBasicDTOMap.get(
                           teamReport.getProcessId() + "-" + teamReport.getTeamId() + "-" + kanBanDetailDTO.getClassId()
                        );
                        if (CollectionUtils.isNotEmpty(mesInspectConfigBasicDTOS)) {
                           Set<String> userNames = new HashSet<>();

                           for (MesInspectConfigBasicDTO mesInspectConfigBasicDTO : mesInspectConfigBasicDTOS) {
                              for (MesInspectConfigUserLink inspectConfigUserLink : inspectConfigUserLinkMap.get(mesInspectConfigBasicDTO.getId())) {
                                 String name = finalUserMap.get(inspectConfigUserLink.getInspectUserId()).getName();
                                 userNames.add(name);
                              }
                           }

                           ProjectProductionKanBanReportDetailDTO detailDTO = ProjectProductionKanBanReportDetailDTO.builder()
                              .name(kanBanDetailDTO.getName())
                              .serialNumber(kanBanDetailDTO.getSerialNumber())
                              .specification(kanBanDetailDTO.getSpecification())
                              .workShopName(workshopMap.get(teamReport.getWorkshopId()).getName())
                              .productionLineName(productionLineMap.get(teamReport.getProductionLineId()).getName())
                              .createUserName(StringUtils.join(userNames.toArray(), ","))
                              .createTime(null)
                              .quantity(produceTeamReportListx.stream().mapToInt(MesBuildingProduceTeamReport::getQuantity).sum())
                              .boolCompleted(Boolean.FALSE)
                              .boolAssist(assistId != 0L)
                              .build();
                           returnReportDetailDTOS.add(detailDTO);
                        }
                     }
                  )
            );
            List<MesBuildingProduceInspectionTeamReport> produceTeamReportList = this.produceInspectionTeamReportService
               .list(
                  (Wrapper<MesBuildingProduceInspectionTeamReport>)((new LambdaQueryWrapper<MesBuildingProduceInspectionTeamReport>()
                           .eq(MesBuildingProduceInspectionTeamReport::getProcessId, processId))
                        .eq(MesBuildingProduceInspectionTeamReport::getBoolAdoptEnum, Boolean.TRUE))
                     .in(
                        MesBuildingProduceInspectionTeamReport::getTaskProcessId,
                        kanBanProcessProductDetailList.stream().map(ProjectProductionKanBanDetailDTO::getTaskProcessId).collect(Collectors.toList())
                     )
               );
            if (CollectionUtils.isNotEmpty(produceTeamReportList)) {
               Map<Long, List<ProjectProductionKanBanDetailDTO>> productionKanBanDetailDTOMap = kanBanProcessProductDetailList.stream()
                  .collect(Collectors.groupingBy(ProjectProductionKanBanDetailDTO::getProductId));
               Map<Long, User> inspectionUserMap = this.userService
                  .listByIds(produceTeamReportList.stream().map(MesBuildingProduceInspectionTeamReport::getUserId).distinct().collect(Collectors.toList()))
                  .stream()
                  .collect(Collectors.toMap(User::getId, Function.identity()));
               Map<String, List<MesBuildingProduceInspectionTeamReport>> inspectionProduceTeamReportMap = produceTeamReportList.stream()
                  .collect(
                     Collectors.groupingBy(
                        e -> e.getProductId() + "-" + e.getTeamId() + e.getUserId() + e.getCreateTime().format(DatePattern.NORM_DATETIME_MINUTE_FORMATTER)
                     )
                  );
               inspectionProduceTeamReportMap.forEach(
                  (teamUserAndTime, produceTeamReports) -> {
                     MesBuildingProduceInspectionTeamReport report = produceTeamReports.get(0);
                     ProjectProductionKanBanDetailDTO kanBanDetailDTO = productionKanBanDetailDTOMap.get(report.getProductId()).get(0);
                     ProjectProductionKanBanReportDetailDTO detailDTO = ProjectProductionKanBanReportDetailDTO.builder()
                        .name(kanBanDetailDTO.getName())
                        .serialNumber(kanBanDetailDTO.getSerialNumber())
                        .specification(kanBanDetailDTO.getSpecification())
                        .workShopName(workshopMap.get(productionLineMap.get(report.getProductionLineId()).getWorkshopId()).getName())
                        .productionLineName(productionLineMap.get(report.getProductionLineId()).getName())
                        .createUserName(inspectionUserMap.get(report.getUserId()).getName())
                        .createTime(report.getInspectReportTime().format(DatePattern.NORM_DATETIME_MINUTE_FORMATTER))
                        .quantity(produceTeamReports.stream().mapToInt(MesBuildingProduceInspectionTeamReport::getInspectionQuantity).sum())
                        .boolCompleted(report.getBoolAdoptEnum())
                        .boolAssist(Boolean.FALSE)
                        .build();
                     returnReportDetailDTOS.add(detailDTO);
                  }
               );
            }

            return returnReportDetailDTOS;
         }

         if (KanBanProcessTypeEnum.CARGO.getType().equals(processType)) {
            List<ProjectProductionKanBanCargoDetailDTO> kanBanCargoDetailDTOS = new ArrayList<>();
            List<MesBuildingComplete> completes = this.completeService
               .list((Wrapper<MesBuildingComplete>)new LambdaQueryWrapper<MesBuildingComplete>().eq(MesBuildingComplete::getTaskId, artifactTaskId));
            if (CollectionUtils.isNotEmpty(completes)) {
               List<MesBuildingCargoListProductNumberLink> cargoListProductNumberLinks = this.cargoListProductNumberLinkService
                  .list(
                     (Wrapper<MesBuildingCargoListProductNumberLink>)((new LambdaQueryWrapper<MesBuildingCargoListProductNumberLink>()
                              .eq(MesBuildingCargoListProductNumberLink::getProductId, completes.get(0).getProductId()))
                           .eq(MesBuildingCargoListProductNumberLink::getProductType, ProductTypeEnum.ARTIFACT.getType()))
                        .eq(MesBuildingCargoListProductNumberLink::getBoolCancelShip, Boolean.FALSE)
                  );
               List<MesBuildingPackageNumberLink> packageNumberLinkList = this.packageNumberLinkService
                  .list(
                     (Wrapper<MesBuildingPackageNumberLink>)(new LambdaQueryWrapper<MesBuildingPackageNumberLink>()
                           .eq(MesBuildingPackageNumberLink::getProductId, completes.get(0).getProductId()))
                        .eq(MesBuildingPackageNumberLink::getProductType, ProductTypeEnum.ARTIFACT.getType())
                  );
               List<MesBuildingWarehouseRecord> recordList = this.warehouseRecordService
                  .list(
                     (Wrapper<MesBuildingWarehouseRecord>)((new LambdaQueryWrapper<MesBuildingWarehouseRecord>()
                              .eq(MesBuildingWarehouseRecord::getType, 1))
                           .eq(MesBuildingWarehouseRecord::getProductType, ProductTypeEnum.ARTIFACT.getType()))
                        .in(MesBuildingWarehouseRecord::getCompleteId, completes.stream().map(MesBuildingComplete::getId).collect(Collectors.toList()))
                  );
               Map<Long, TechArtifact> artifactMap = this.artifactService
                  .listByIds(completes.stream().map(MesBuildingComplete::getProductId).collect(Collectors.toList()))
                  .stream()
                  .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
               Map<String, List<MesBuildingWarehouseRecord>> warehouseRecordMap = recordList.stream()
                  .collect(Collectors.groupingBy(e -> e.getWorkshopId() + "-" + e.getStatus()));
               warehouseRecordMap.forEach(
                  (workshopIdAndStatus, recordLists) -> {
                     MesBuildingWarehouseRecord record = recordLists.get(0);
                     List<Integer> recordNumbers = recordLists.stream().map(MesBuildingWarehouseRecord::getNumber).distinct().collect(Collectors.toList());
                     TechArtifact artifact = artifactMap.get(record.getProductId());
                     if (!record.getStatus().equals(WarehouseRecordStatusTypeEnum.OUT.getType())) {
                        ProjectProductionKanBanCargoDetailDTO kanBanDetailDTO = ProjectProductionKanBanCargoDetailDTO.builder()
                           .quantity(recordLists.stream().mapToInt(s -> s.getQuantity().intValue()).sum())
                           .serialNumber(artifact.getSerialNumber())
                           .name(artifact.getName())
                           .specification(artifact.getSpecification())
                           .status(record.getStatus())
                           .workShopName(workshopMap.get(record.getWorkshopId()).getName())
                           .build();
                        if (record.getStatus().equals(WarehouseRecordStatusTypeEnum.INTO.getType())) {
                           kanBanDetailDTO.setUserNames(
                              recordLists.stream().map(MesBuildingWarehouseRecord::getUserName).distinct().collect(Collectors.joining(","))
                           );
                           List<LocalDateTime> createTimeList = recordLists.stream().map(BaseEntity::getCreateTime).collect(Collectors.toList());
                           String minTime = Collections.min(createTimeList).format(DatePattern.NORM_DATE_FORMATTER);
                           String maxTime = Collections.max(createTimeList).format(DatePattern.NORM_DATE_FORMATTER);
                           if (!minTime.equals(maxTime)) {
                              kanBanDetailDTO.setDateTimes(minTime + "/" + maxTime);
                           } else {
                              kanBanDetailDTO.setDateTimes(minTime);
                           }
                        }

                        if (record.getStatus().equals(WarehouseRecordStatusTypeEnum.PACKAGING.getType())) {
                           List<MesBuildingPackageNumberLink> packageNumberLinks = packageNumberLinkList.stream()
                              .filter(e -> recordNumbers.contains(e.getNumber()))
                              .collect(Collectors.toList());
                           if (CollectionUtils.isNotEmpty(packageNumberLinks)) {
                              List<LocalDateTime> createTimeList = packageNumberLinks.stream().map(BaseEntity::getCreateTime).collect(Collectors.toList());
                              String minTime = Collections.min(createTimeList).format(DatePattern.NORM_DATE_FORMATTER);
                              String maxTime = Collections.max(createTimeList).format(DatePattern.NORM_DATE_FORMATTER);
                              if (!minTime.equals(maxTime)) {
                                 kanBanDetailDTO.setDateTimes(minTime + "/" + maxTime);
                              } else {
                                 kanBanDetailDTO.setDateTimes(minTime);
                              }

                              List<MesBuildingPackageNumberLink> buildingPackageNumberLinks = packageNumberLinks.stream()
                                 .filter(e -> StringUtils.isNotBlank(e.getUserName()))
                                 .collect(Collectors.toList());
                              if (CollectionUtils.isNotEmpty(buildingPackageNumberLinks)) {
                                 kanBanDetailDTO.setUserNames(
                                    packageNumberLinks.stream().map(MesBuildingPackageNumberLink::getUserName).distinct().collect(Collectors.joining(","))
                                 );
                              }
                           }
                        }

                        if (record.getStatus().equals(WarehouseRecordStatusTypeEnum.CARGOLIST.getType())) {
                           List<MesBuildingCargoListProductNumberLink> productNumberLinks = cargoListProductNumberLinks.stream()
                              .filter(e -> recordNumbers.contains(e.getNumber()))
                              .collect(Collectors.toList());
                           if (CollectionUtils.isNotEmpty(productNumberLinks)) {
                              List<LocalDateTime> createTimeList = productNumberLinks.stream().map(BaseEntity::getCreateTime).collect(Collectors.toList());
                              String minTime = Collections.min(createTimeList).format(DatePattern.NORM_DATE_FORMATTER);
                              String maxTime = Collections.max(createTimeList).format(DatePattern.NORM_DATE_FORMATTER);
                              if (!minTime.equals(maxTime)) {
                                 kanBanDetailDTO.setDateTimes(minTime + "/" + maxTime);
                              } else {
                                 kanBanDetailDTO.setDateTimes(minTime);
                              }

                              List<MesBuildingCargoListProductNumberLink> cargoListProductNumberLinkList = productNumberLinks.stream()
                                 .filter(e -> StringUtils.isNotBlank(e.getUserName()))
                                 .collect(Collectors.toList());
                              if (CollectionUtils.isNotEmpty(cargoListProductNumberLinkList)) {
                                 kanBanDetailDTO.setUserNames(
                                    cargoListProductNumberLinkList.stream()
                                       .map(MesBuildingCargoListProductNumberLink::getUserName)
                                       .distinct()
                                       .collect(Collectors.joining(","))
                                 );
                              }
                           }
                        }

                        kanBanCargoDetailDTOS.add(kanBanDetailDTO);
                     }

                     if (record.getStatus().equals(WarehouseRecordStatusTypeEnum.OUT.getType())) {
                        List<MesBuildingCargoListProductNumberLink> productNumberLinks = cargoListProductNumberLinks.stream()
                           .filter(e -> recordNumbers.contains(e.getNumber()))
                           .collect(Collectors.toList());
                        if (CollectionUtils.isNotEmpty(productNumberLinks)) {
                           Map<Long, List<MesBuildingCargoListProductNumberLink>> cargoListProductNumberLinkListMap = productNumberLinks.stream()
                              .collect(Collectors.groupingBy(MesBuildingCargoListProductNumberLink::getCargoListId));
                           Map<Long, MesBuildingCargoList> cargoListMap = this.cargoListService
                              .listByIds(cargoListProductNumberLinkListMap.keySet())
                              .stream()
                              .collect(Collectors.toMap(e -> e.getId(), Function.identity()));
                           cargoListProductNumberLinkListMap.forEach(
                              (cargoId, linkList) -> {
                                 MesBuildingCargoList cargoList = cargoListMap.get(cargoId);
                                 ProjectProductionKanBanCargoDetailDTO kanBanDetailDTO = ProjectProductionKanBanCargoDetailDTO.builder()
                                    .quantity(linkList.size())
                                    .serialNumber(artifact.getSerialNumber())
                                    .name(artifact.getName())
                                    .specification(artifact.getSpecification())
                                    .status(record.getStatus())
                                    .workShopName(workshopMap.get(record.getWorkshopId()).getName())
                                    .build();
                                 kanBanDetailDTO.setDateTimes(cargoList.getAuditTime().format(DatePattern.NORM_DATE_FORMATTER));
                                 kanBanDetailDTO.setUserNames(cargoList.getActualUserName());
                                 kanBanDetailDTO.setCargoSerialNumbers(cargoList.getSerialNumber());
                                 kanBanDetailDTO.setLicensePlate(cargoList.getLicensePlate());
                                 kanBanCargoDetailDTOS.add(kanBanDetailDTO);
                              }
                           );
                        }
                     }
                  }
               );
            }

            return kanBanCargoDetailDTOS;
         }
      }

      if (ProductTypeEnum.ASSEMBLE.getType().equals(productType)) {
         if (KanBanProcessTypeEnum.REPORT.getType().equals(processType)) {
            List<MesBuildingTaskNumberLink> mesBuildingTaskNumberLinks = this.taskNumberLinkService
               .list(
                  (Wrapper<MesBuildingTaskNumberLink>)(new LambdaQueryWrapper<MesBuildingTaskNumberLink>()
                        .eq(MesBuildingTaskNumberLink::getArtifactTaskId, artifactTaskId))
                     .isNotNull(MesBuildingTaskNumberLink::getAssembleTaskId)
               );
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(mesBuildingTaskNumberLinks), "操作失败,部件任务异常!");
            List<Long> assembleTaskIds = mesBuildingTaskNumberLinks.stream()
               .map(MesBuildingTaskNumberLink::getAssembleTaskId)
               .distinct()
               .collect(Collectors.toList());
            Map<Long, List<MesBuildingAssistNumberDetail>> assistNumberNumberDetailMap = this.assistNumberDetailService
               .list(
                  (Wrapper<MesBuildingAssistNumberDetail>)(new LambdaQueryWrapper<MesBuildingAssistNumberDetail>()
                        .in(MesBuildingAssistNumberDetail::getTaskId, assembleTaskIds))
                     .eq(MesBuildingAssistNumberDetail::getProductType, ProductTypeEnum.ASSEMBLE.getType())
               )
               .stream()
               .collect(Collectors.groupingBy(MesBuildingAssistNumberDetail::getTaskId));
            List<ProjectProductionKanBanDetailDTO> kanBanProcessProductDetailList = this.taskProcessService
               .getKanBanProcessProductDetail(
                  mesBuildingTaskNumberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleTaskId).distinct().collect(Collectors.toList()),
                  processId,
                  productType
               );
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(kanBanProcessProductDetailList), "操作失败,部件任务不存在!");
            Map<Long, List<ProjectProductionKanBanDetailDTO>> productionKanBanDetailDTOMap = kanBanProcessProductDetailList.stream()
               .collect(Collectors.groupingBy(ProjectProductionKanBanDetailDTO::getTaskId));
            Map<Long, List<MesBuildingTaskNumberLink>> taskNumberLinkMap = mesBuildingTaskNumberLinks.stream()
               .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getAssembleTaskId));
            taskNumberLinkMap.forEach(
               (assembleTaskId, taskNumberLinkList) -> {
                  List<MesBuildingAssistNumberDetail> assistNumberDetails = assistNumberNumberDetailMap.get(assembleTaskId);
                  List<ProjectProductionKanBanDetailDTO> projectProductionKanBanDetailDTOList = productionKanBanDetailDTOMap.get(assembleTaskId);
                  if (!CollectionUtils.isEmpty(projectProductionKanBanDetailDTOList)) {
                     if (CollectionUtils.isEmpty(assistNumberDetails)) {
                        Preconditions.checkArgument(projectProductionKanBanDetailDTOList.size() == 1, "查询失败,数据有误!");
                        projectProductionKanBanDetailDTOList.forEach(
                           e -> e.setTaskQuantity((int)taskNumberLinkList.stream().map(MesBuildingTaskNumberLink::getAssembleNumber).distinct().count())
                        );
                     } else {
                        for (ProjectProductionKanBanDetailDTO banDetailDTO : projectProductionKanBanDetailDTOList) {
                           if (!banDetailDTO.getBoolAssist()) {
                              List<Integer> assistNumberList = assistNumberDetails.stream()
                                 .map(MesBuildingAssistNumberDetail::getNumber)
                                 .distinct()
                                 .collect(Collectors.toList());
                              List<MesBuildingTaskNumberLink> taskNumberLink = taskNumberLinkList.stream()
                                 .filter(e -> !assistNumberList.contains(e.getAssembleNumber()))
                                 .collect(Collectors.toList());
                              banDetailDTO.setTaskQuantity((int)taskNumberLink.stream().map(MesBuildingTaskNumberLink::getAssembleNumber).distinct().count());
                           } else {
                              List<Integer> assistNumberList = assistNumberDetails.stream()
                                 .filter(e -> e.getAssistId().equals(banDetailDTO.getAssistId()))
                                 .map(MesBuildingAssistNumberDetail::getNumber)
                                 .distinct()
                                 .collect(Collectors.toList());
                              List<MesBuildingTaskNumberLink> taskNumberLink = taskNumberLinkList.stream()
                                 .filter(e -> assistNumberList.contains(e.getAssembleNumber()))
                                 .collect(Collectors.toList());
                              banDetailDTO.setTaskQuantity((int)taskNumberLink.stream().map(MesBuildingTaskNumberLink::getAssembleNumber).distinct().count());
                           }
                        }
                     }

                     if (CollectionUtils.isEmpty(assistNumberDetails)) {
                        for (ProjectProductionKanBanDetailDTO projectProductionKanBanDetailDTO : projectProductionKanBanDetailDTOList) {
                           List<MesBuildingProduceTeamReport> produceTeamReportListx = this.produceTeamReportService
                              .list(
                                 (Wrapper<MesBuildingProduceTeamReport>)((new LambdaQueryWrapper<MesBuildingProduceTeamReport>()
                                          .eq(MesBuildingProduceTeamReport::getTaskProcessId, projectProductionKanBanDetailDTO.getTaskProcessId()))
                                       .in(
                                          MesBuildingProduceTeamReport::getNumber,
                                          taskNumberLinkList.stream().map(MesBuildingTaskNumberLink::getAssembleNumber).distinct().collect(Collectors.toList())
                                       ))
                                    .eq(MesBuildingProduceTeamReport::getTaskTypeEnum, productType)
                              );
                           projectProductionKanBanDetailDTO.setCompanyQuantity(
                              produceTeamReportListx.stream().mapToInt(MesBuildingProduceTeamReport::getInspectionQuantity).sum()
                           );
                        }
                     } else {
                        Map<Long, List<MesBuildingProduceTeamReport>> produceTeamReportMapx = this.produceTeamReportService
                           .list(
                              (Wrapper<MesBuildingProduceTeamReport>)((new LambdaQueryWrapper<MesBuildingProduceTeamReport>()
                                       .in(
                                          MesBuildingProduceTeamReport::getTaskProcessId,
                                          projectProductionKanBanDetailDTOList.stream()
                                             .map(ProjectProductionKanBanDetailDTO::getTaskProcessId)
                                             .collect(Collectors.toList())
                                       ))
                                    .in(
                                       MesBuildingProduceTeamReport::getNumber,
                                       taskNumberLinkList.stream().map(MesBuildingTaskNumberLink::getAssembleNumber).distinct().collect(Collectors.toList())
                                    ))
                                 .eq(MesBuildingProduceTeamReport::getTaskTypeEnum, productType)
                           )
                           .stream()
                           .collect(Collectors.groupingBy(MesBuildingProduceTeamReport::getTaskProcessId));

                        for (ProjectProductionKanBanDetailDTO kanBanDetailDTO : projectProductionKanBanDetailDTOList) {
                           List<MesBuildingProduceTeamReport> produceTeamReports = produceTeamReportMapx.get(kanBanDetailDTO.getTaskProcessId());
                           if (!kanBanDetailDTO.getBoolAssist()) {
                              kanBanDetailDTO.setCompanyQuantity(
                                 produceTeamReports.stream()
                                    .filter(e -> e.getAssistId() == null)
                                    .mapToInt(MesBuildingProduceTeamReport::getInspectionQuantity)
                                    .sum()
                              );
                           } else {
                              kanBanDetailDTO.setCompanyQuantity(
                                 produceTeamReports.stream()
                                    .filter(e -> e.getAssistId().equals(kanBanDetailDTO.getAssistId()))
                                    .mapToInt(MesBuildingProduceTeamReport::getInspectionQuantity)
                                    .sum()
                              );
                           }
                        }
                     }
                  }
               }
            );
            List<ProjectProductionKanBanReportDetailDTO> returnReportDetailDTOS = new ArrayList<>();
            Map<Long, List<ProjectProductionKanBanDetailDTO>> collect = kanBanProcessProductDetailList.stream()
               .collect(Collectors.groupingBy(ProjectProductionKanBanDetailDTO::getProductId));

            for (ProjectProductionKanBanDetailDTO kanBanDetailDTO : kanBanProcessProductDetailList) {
               if (kanBanDetailDTO.getTaskQuantity() > kanBanDetailDTO.getCompanyQuantity()) {
                  ProjectProductionKanBanReportDetailDTO detailDTO = ProjectProductionKanBanReportDetailDTO.builder()
                     .name(kanBanDetailDTO.getName())
                     .serialNumber(kanBanDetailDTO.getSerialNumber())
                     .specification(kanBanDetailDTO.getSpecification())
                     .workShopName(kanBanDetailDTO.getWorkShopName())
                     .productionLineName(kanBanDetailDTO.getProductionLineName())
                     .teamUserName(kanBanDetailDTO.getTeamUserName())
                     .createUserName(null)
                     .createTime(null)
                     .quantity(kanBanDetailDTO.getTaskQuantity() - kanBanDetailDTO.getCompanyQuantity())
                     .boolAssist(kanBanDetailDTO.getBoolAssist())
                     .boolCompleted(Boolean.FALSE)
                     .build();
                  returnReportDetailDTOS.add(detailDTO);
               }
            }

            List<MesBuildingProduceTeamReport> produceTeamReportList = this.produceTeamReportService
               .list(
                  (Wrapper<MesBuildingProduceTeamReport>)((new LambdaQueryWrapper<MesBuildingProduceTeamReport>()
                           .in(
                              MesBuildingProduceTeamReport::getTaskProcessId,
                              kanBanProcessProductDetailList.stream().map(ProjectProductionKanBanDetailDTO::getTaskProcessId).collect(Collectors.toList())
                           ))
                        .in(
                           MesBuildingProduceTeamReport::getNumber,
                           mesBuildingTaskNumberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleNumber).distinct().collect(Collectors.toList())
                        ))
                     .eq(MesBuildingProduceTeamReport::getTaskTypeEnum, productType)
               );
            if (CollectionUtils.isNotEmpty(produceTeamReportList)) {
               Map<Long, MesBuildingTeamUserLink> teamUserLinkMap = this.teamUserLinkService
                  .list(
                     (Wrapper<MesBuildingTeamUserLink>)(new LambdaQueryWrapper<MesBuildingTeamUserLink>()
                           .eq(MesBuildingTeamUserLink::getBoolLeaderEnum, Boolean.TRUE))
                        .in(
                           MesBuildingTeamUserLink::getTeamId,
                           produceTeamReportList.stream().map(MesBuildingProduceTeamReport::getTeamId).distinct().collect(Collectors.toList())
                        )
                  )
                  .stream()
                  .collect(Collectors.toMap(MesBuildingTeamUserLink::getTeamId, Function.identity()));
               Map<Long, User> userMap = this.userService
                  .listByIds(produceTeamReportList.stream().map(MesBuildingProduceTeamReport::getUserId).distinct().collect(Collectors.toList()))
                  .stream()
                  .collect(Collectors.toMap(User::getId, Function.identity()));
               Map<String, List<MesBuildingProduceTeamReport>> produceTeamReportMap = produceTeamReportList.stream()
                  .collect(
                     Collectors.groupingBy(
                        e -> e.getProductId() + "-" + e.getTeamId() + e.getUserId() + e.getCreateTime().format(DatePattern.NORM_DATETIME_MINUTE_FORMATTER)
                     )
                  );
               produceTeamReportMap.forEach(
                  (teamUserAndTime, produceTeamReports) -> {
                     MesBuildingProduceTeamReport report = produceTeamReports.get(0);
                     ProjectProductionKanBanDetailDTO kanBanDetailDTO = collect.get(report.getProductId()).get(0);
                     ProjectProductionKanBanReportDetailDTO detailDTO = ProjectProductionKanBanReportDetailDTO.builder()
                        .name(kanBanDetailDTO.getName())
                        .serialNumber(kanBanDetailDTO.getSerialNumber())
                        .specification(kanBanDetailDTO.getSpecification())
                        .workShopName(workshopMap.get(report.getWorkshopId()).getName())
                        .productionLineName(productionLineMap.get(report.getProductionLineId()).getName())
                        .teamUserName(teamUserLinkMap.get(report.getTeamId()).getUserName())
                        .createUserName(userMap.get(report.getUserId()).getName())
                        .createTime(report.getCreateTime().format(DatePattern.NORM_DATETIME_MINUTE_FORMATTER))
                        .quantity(produceTeamReports.stream().mapToInt(MesBuildingProduceTeamReport::getQuantity).sum())
                        .boolAssist(report.getAssistId() != null)
                        .boolCompleted(Boolean.TRUE)
                        .build();
                     returnReportDetailDTOS.add(detailDTO);
                  }
               );
            }

            return returnReportDetailDTOS;
         }

         if (KanBanProcessTypeEnum.INSPECTION.getType().equals(processType)) {
            List<ProjectProductionKanBanReportDetailDTO> returnReportDetailDTOS = new ArrayList<>();
            List<MesBuildingTaskNumberLink> mesBuildingTaskNumberLinks = this.taskNumberLinkService
               .list(
                  (Wrapper<MesBuildingTaskNumberLink>)(new LambdaQueryWrapper<MesBuildingTaskNumberLink>()
                        .eq(MesBuildingTaskNumberLink::getArtifactTaskId, artifactTaskId))
                     .isNotNull(MesBuildingTaskNumberLink::getAssembleTaskId)
               );
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(mesBuildingTaskNumberLinks), "操作失败,部件任务异常!");
            Map<Long, List<MesBuildingTaskNumberLink>> taskNumberLinkMap = mesBuildingTaskNumberLinks.stream()
               .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getAssembleTaskId));
            List<ProjectProductionKanBanDetailDTO> kanBanProcessProductDetailList = this.taskProcessService
               .getKanBanProcessInspectionProductDetail(
                  mesBuildingTaskNumberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleTaskId).distinct().collect(Collectors.toList()),
                  processId,
                  productType
               );
            if (CollectionUtils.isEmpty(kanBanProcessProductDetailList)) {
               return returnReportDetailDTOS;
            }

            List<MesInspectConfigUserLink> allInspectConfigUserLinks = this.inspectConfigUserLinkService.list();
            Map<Long, User> userMap = new HashMap<>();
            if (CollectionUtils.isNotEmpty(allInspectConfigUserLinks)) {
               userMap = this.userService
                  .listByIds(allInspectConfigUserLinks.stream().map(MesInspectConfigUserLink::getInspectUserId).distinct().collect(Collectors.toList()))
                  .stream()
                  .collect(Collectors.toMap(User::getId, Function.identity()));
            }

            Map<Long, List<MesInspectConfigUserLink>> inspectConfigUserLinkMap = allInspectConfigUserLinks.stream()
               .collect(Collectors.groupingBy(MesInspectConfigUserLink::getInspectConfigId));
            Map<String, List<MesInspectConfigBasicDTO>> configBasicDTOMap = this.inspectConfigService
               .queryAllInspectConfigList()
               .stream()
               .collect(Collectors.groupingBy(e -> e.getProcessId() + "-" + e.getTeamId() + "-" + e.getClassificationId()));
            Map<Long, List<ProjectProductionKanBanDetailDTO>> productionTaskKanBanDetailDTOMap = kanBanProcessProductDetailList.stream()
               .collect(Collectors.groupingBy(ProjectProductionKanBanDetailDTO::getTaskId));
            List<MesBuildingProduceTeamReport> allProduceTeamReportList = new ArrayList<>();
            taskNumberLinkMap.forEach(
               (assembleTaskId, taskNumberLinkList) -> {
                  List<ProjectProductionKanBanDetailDTO> projectProductionKanBanDetailDTOS = productionTaskKanBanDetailDTOMap.get(assembleTaskId);
                  if (CollectionUtils.isNotEmpty(projectProductionKanBanDetailDTOS)) {
                     for (ProjectProductionKanBanDetailDTO projectProductionKanBanDetailDTO : projectProductionKanBanDetailDTOS) {
                        List<MesBuildingProduceTeamReport> produceTeamReportListx = this.produceTeamReportService
                           .list(
                              (Wrapper<MesBuildingProduceTeamReport>)(((new LambdaQueryWrapper<MesBuildingProduceTeamReport>()
                                          .eq(MesBuildingProduceTeamReport::getInspectionQuantity, 0))
                                       .eq(MesBuildingProduceTeamReport::getTaskProcessId, projectProductionKanBanDetailDTO.getTaskProcessId()))
                                    .in(
                                       MesBuildingProduceTeamReport::getNumber,
                                       taskNumberLinkList.stream().map(MesBuildingTaskNumberLink::getAssembleNumber).distinct().collect(Collectors.toList())
                                    ))
                                 .eq(MesBuildingProduceTeamReport::getTaskTypeEnum, productType)
                           );
                        if (CollectionUtils.isNotEmpty(produceTeamReportListx)) {
                           allProduceTeamReportList.addAll(produceTeamReportListx);
                        }
                     }
                  }
               }
            );
            if (CollectionUtils.isNotEmpty(allProduceTeamReportList)) {
               Map<Long, List<ProjectProductionKanBanDetailDTO>> taskProcessIdProductionKanBanDetailDTOMap = kanBanProcessProductDetailList.stream()
                  .collect(Collectors.groupingBy(ProjectProductionKanBanDetailDTO::getTaskProcessId));
               Map<Long, List<MesBuildingProduceTeamReport>> produceTeamReportMap = allProduceTeamReportList.stream()
                  .collect(Collectors.groupingBy(e -> e.getAssistId() == null ? 0L : e.getAssistId()));
               Map<Long, User> finalUserMap = userMap;
               produceTeamReportMap.forEach(
                  (assistId, produceTeamReportListx) -> produceTeamReportListx.stream()
                     .collect(Collectors.groupingBy(e -> e.getProductId() + "-" + e.getTeamId()))
                     .forEach(
                        (productAndteamId, produceTeamReports) -> {
                           MesBuildingProduceTeamReport teamReport = (MesBuildingProduceTeamReport)produceTeamReportListx.get(0);
                           ProjectProductionKanBanDetailDTO kanBanDetailDTO = taskProcessIdProductionKanBanDetailDTOMap.get(teamReport.getTaskProcessId())
                              .get(0);
                           List<MesInspectConfigBasicDTO> mesInspectConfigBasicDTOS = configBasicDTOMap.get(
                              teamReport.getProcessId() + "-" + teamReport.getTeamId() + "-" + kanBanDetailDTO.getClassId()
                           );
                           if (CollectionUtils.isNotEmpty(mesInspectConfigBasicDTOS)) {
                              Set<String> userNames = new HashSet<>();

                              for (MesInspectConfigBasicDTO mesInspectConfigBasicDTO : mesInspectConfigBasicDTOS) {
                                 for (MesInspectConfigUserLink inspectConfigUserLink : inspectConfigUserLinkMap.get(mesInspectConfigBasicDTO.getId())) {
                                    String name = finalUserMap.get(inspectConfigUserLink.getInspectUserId()).getName();
                                    userNames.add(name);
                                 }
                              }

                              ProjectProductionKanBanReportDetailDTO detailDTO = ProjectProductionKanBanReportDetailDTO.builder()
                                 .name(kanBanDetailDTO.getName())
                                 .serialNumber(kanBanDetailDTO.getSerialNumber())
                                 .specification(kanBanDetailDTO.getSpecification())
                                 .workShopName(workshopMap.get(teamReport.getWorkshopId()).getName())
                                 .productionLineName(productionLineMap.get(teamReport.getProductionLineId()).getName())
                                 .createUserName(StringUtils.join(userNames.toArray(), ","))
                                 .createTime(null)
                                 .quantity(produceTeamReportListx.stream().mapToInt(MesBuildingProduceTeamReport::getQuantity).sum())
                                 .boolCompleted(Boolean.FALSE)
                                 .boolAssist(assistId != 0L)
                                 .build();
                              returnReportDetailDTOS.add(detailDTO);
                           }
                        }
                     )
               );
            }

            List<MesBuildingProduceInspectionTeamReport> produceTeamReportList = this.produceInspectionTeamReportService
               .list(
                  (Wrapper<MesBuildingProduceInspectionTeamReport>)(((new LambdaQueryWrapper<MesBuildingProduceInspectionTeamReport>()
                              .eq(MesBuildingProduceInspectionTeamReport::getProcessId, processId))
                           .eq(MesBuildingProduceInspectionTeamReport::getBoolAdoptEnum, Boolean.TRUE))
                        .in(
                           MesBuildingProduceInspectionTeamReport::getNumber,
                           mesBuildingTaskNumberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleNumber).distinct().collect(Collectors.toList())
                        ))
                     .in(
                        MesBuildingProduceInspectionTeamReport::getTaskProcessId,
                        kanBanProcessProductDetailList.stream().map(ProjectProductionKanBanDetailDTO::getTaskProcessId).collect(Collectors.toList())
                     )
               );
            if (CollectionUtils.isNotEmpty(produceTeamReportList)) {
               Map<Long, List<ProjectProductionKanBanDetailDTO>> productionKanBanDetailDTOMap = kanBanProcessProductDetailList.stream()
                  .collect(Collectors.groupingBy(ProjectProductionKanBanDetailDTO::getProductId));
               Map<Long, User> inspectionUserMap = this.userService
                  .listByIds(produceTeamReportList.stream().map(MesBuildingProduceInspectionTeamReport::getUserId).distinct().collect(Collectors.toList()))
                  .stream()
                  .collect(Collectors.toMap(User::getId, Function.identity()));
               Map<String, List<MesBuildingProduceInspectionTeamReport>> produceTeamReportMap = produceTeamReportList.stream()
                  .collect(
                     Collectors.groupingBy(e -> e.getProductId() + "-" + e.getUserId() + e.getCreateTime().format(DatePattern.NORM_DATETIME_MINUTE_FORMATTER))
                  );
               produceTeamReportMap.forEach(
                  (teamUserAndTime, produceTeamReports) -> {
                     MesBuildingProduceInspectionTeamReport report = produceTeamReports.get(0);
                     ProjectProductionKanBanDetailDTO kanBanDetailDTO = productionKanBanDetailDTOMap.get(report.getProductId()).get(0);
                     ProjectProductionKanBanReportDetailDTO detailDTO = ProjectProductionKanBanReportDetailDTO.builder()
                        .name(kanBanDetailDTO.getName())
                        .serialNumber(kanBanDetailDTO.getSerialNumber())
                        .specification(kanBanDetailDTO.getSpecification())
                        .workShopName(workshopMap.get(productionLineMap.get(report.getProductionLineId()).getWorkshopId()).getName())
                        .productionLineName(productionLineMap.get(report.getProductionLineId()).getName())
                        .createUserName(inspectionUserMap.get(report.getUserId()).getName())
                        .createTime(report.getInspectReportTime().format(DatePattern.NORM_DATETIME_MINUTE_FORMATTER))
                        .quantity(produceTeamReports.stream().mapToInt(MesBuildingProduceInspectionTeamReport::getInspectionQuantity).sum())
                        .boolCompleted(report.getBoolAdoptEnum())
                        .build();
                     returnReportDetailDTOS.add(detailDTO);
                  }
               );
            }

            return returnReportDetailDTOS;
         }
      }

      if (ProductTypeEnum.MACHINE_PART.getType().equals(productType)) {
         List<TechArtifactMachinePartLink> artifactMachinePartLinks = this.artifactMachinePartLinkService
            .list((Wrapper<TechArtifactMachinePartLink>)new LambdaQueryWrapper<TechArtifactMachinePartLink>().eq(TechArtifactMachinePartLink::getArtifactId, artifactTask.getProductId()));
         if (CollectionUtils.isEmpty(artifactMachinePartLinks)) {
            return null;
         }

         List<TechMachinePart> parts = this.machinePartService
            .list(
               (Wrapper<TechMachinePart>)(new LambdaQueryWrapper<TechMachinePart>()
                     .in(
                        TechMachinePart::getId,
                        artifactMachinePartLinks.stream().map(TechArtifactMachinePartLink::getMachinePartId).collect(Collectors.toList())
                     ))
                  .eq(TechMachinePart::getBoolProcess, Boolean.TRUE)
            );
         if (CollectionUtils.isEmpty(parts)) {
            return null;
         }

         List<Long> machinePartIds = parts.stream().map(TechMachinePart::getId).collect(Collectors.toList());
         List<ProjectProductionKanBanDetailDTO> kanBanProcessProductDetailList = this.taskProcessService.getPartKanBanProcessProductDetailNew(machinePartIds);
         kanBanProcessProductDetailList.removeIf(Objects::isNull);
         if (CollectionUtils.isNotEmpty(kanBanProcessProductDetailList)) {
            List<Long> partIds = kanBanProcessProductDetailList.stream().map(ProjectProductionKanBanDetailDTO::getPartId).collect(Collectors.toList());
            parts = parts.stream().filter(e -> !partIds.contains(e.getId())).collect(Collectors.toList());
         }

         if (CollectionUtils.isNotEmpty(parts)) {
            for (TechMachinePart part : parts) {
               ProjectProductionKanBanDetailDTO build = ProjectProductionKanBanDetailDTO.builder()
                  .productionLineName("-")
                  .processName("未排产")
                  .configName("未排产")
                  .companyQuantity(0)
                  .serialNumber(part.getSerialNumber())
                  .specification(part.getSpecification())
                  .orderNumber("-")
                  .teamUserName("-")
                  .taskQuantity(0)
                  .build();
               kanBanProcessProductDetailList.add(build);
            }
         }

         return kanBanProcessProductDetailList.stream()
            .sorted(Comparator.comparing(ProjectProductionKanBanDetailDTO::getSerialNumber).thenComparing(ProjectProductionKanBanDetailDTO::getTaskQuantity))
            .collect(Collectors.toList());
      } else {
         return new ArrayList();
      }
   }

   @Override
   public PageVO<ProjectKanBanProductProductionStateDTO> pageProjectSignageProductProductionStateList(
      Long projectId,
      Long monomerId,
      List<Long> areaIds,
      Long classId,
      String serialNumber,
      Long workShopId,
      Long productionLineId,
      Long processId,
      Integer productClassificationEnum,
      List<LocalDateTime> dateTimeList,
      Integer productType,
      Integer productKanBanCompanyEnum,
      List<Long> areaBatchIds,
      Boolean boolNotIssued,
      Integer pageNumber,
      Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      if (!boolNotIssued) {
         return new PageVO<>(
            this.projectSignageProductProductionStateList(
               projectId,
               monomerId,
               areaIds,
               classId,
               serialNumber,
               workShopId,
               productionLineId,
               processId,
               productClassificationEnum,
               dateTimeList,
               productType,
               productKanBanCompanyEnum,
               areaBatchIds
            )
         );
      }

      Preconditions.checkArgument(com.hzchum.scim.common.core.api.enums.ProductTypeEnum.ARTIFACT.getType().equals(productType), "仅构件可查看未排产列表");
      return new PageVO<>(this.taskService.findArtifactSchedulingList(projectId, monomerId, areaIds, classId, serialNumber, areaBatchIds));
   }

   @Override
   public List<ProjectKanBanProductProductionStateDTO> projectSignageProductProductionStateList(
      Long projectId,
      Long monomerId,
      List<Long> areaIds,
      Long classId,
      String serialNumber,
      Long workShopId,
      Long productionLineId,
      Long processId,
      Integer productClassificationEnum,
      List<LocalDateTime> dateTimeList,
      Integer productType,
      Integer productKanBanCompanyEnum,
      List<Long> areaBatchIds
   ) {
      if (ProductTypeEnum.ARTIFACT.getType().equals(productType) || ProductTypeEnum.ASSEMBLE.getType().equals(productType)) {
         return this.taskService
            .findSignageProductProductionStateList(
               projectId, productType, monomerId, areaIds, workShopId, productionLineId, classId, serialNumber, productKanBanCompanyEnum, areaBatchIds
            );
      } else {
         return ProductTypeEnum.MACHINE_PART.getType().equals(productType)
            ? this.taskProcessService
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
               )
            : new ArrayList<>();
      }
   }

   @Override
   public List<ProjectProductionKanBanNameInfoDTO> findProjectPartProcessList(
      Long projectId, Integer productType, Long workShopId, Long productionLineId, Long monomerId, List<Long> areaIds, List<Long> areaBatchIds
   ) {
      List<MesBuildingTaskProcess> taskProcesses = this.taskProcessService
         .list(
            ((((((new LambdaQueryWrapper<MesBuildingTaskProcess>()
                                 .eq(MesBuildingTaskProcess::getProjectId, projectId))
                              .eq(productType != null, MesBuildingTaskProcess::getTaskTypeEnum, productType))
                           .eq(workShopId != null, MesBuildingTaskProcess::getWorkshopId, workShopId))
                        .eq(productionLineId != null, MesBuildingTaskProcess::getProductionLineId, productionLineId))
                     .eq(monomerId != null, MesBuildingTaskProcess::getMonomerId, monomerId))
                  .eq(CollectionUtils.isNotEmpty(areaIds), MesBuildingTaskProcess::getAreaId, areaIds))
               .eq(CollectionUtils.isNotEmpty(areaBatchIds), MesBuildingTaskProcess::getAreaBatchId, areaBatchIds)
         );
      if (CollectionUtils.isEmpty(taskProcesses)) {
         return new ArrayList<>();
      }

      List<Long> processIds = taskProcesses.stream().map(MesBuildingTaskProcess::getProcessId).collect(Collectors.toList());
      List<MesBuildingProcess> mesBuildingProcesses = this.processService.listByIds(processIds);
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(mesBuildingProcesses), "操作失败,零件工序不存在!");
      return BeanUtil.copyToList(mesBuildingProcesses, ProjectProductionKanBanNameInfoDTO.class);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printProjectSignageProductProductionStateList(
      Long projectId,
      Long monomerId,
      List<Long> areaIds,
      Long classId,
      String serialNumber,
      Long workShopId,
      Long productionLineId,
      Long processId,
      Integer productClassificationEnum,
      List<LocalDateTime> dateTimeList,
      Integer productType,
      Integer productKanBanCompanyEnum,
      List<Long> areaBatchIds,
      Boolean boolNotIssued
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      ContractProject project = this.projectService.getById(projectId);
      header.put("projectName", project.getShortName() + "-" + project.getSerialNumber());
      header.put("statisticalDate", "全部");
      header.put("productType", ProductTypeEnum.getNameByType(productType));
      if (com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isNotEmpty(dateTimeList) && dateTimeList.size() == 2) {
         DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         String startTime = df.format(dateTimeList.get(0));
         String endTime = df.format(dateTimeList.get(1));
         header.put("statisticalDate", startTime + "-" + endTime);
      }

      printVO.setHeader(header);
      new ArrayList();
      List var21;
      if (!boolNotIssued) {
         var21 = this.projectSignageProductProductionStateList(
               projectId,
               monomerId,
               areaIds,
               classId,
               serialNumber,
               workShopId,
               productionLineId,
               processId,
               productClassificationEnum,
               dateTimeList,
               productType,
               productKanBanCompanyEnum,
               areaBatchIds
            )
            .stream()
            .map(com.hzchum.pangu.common.util.BeanUtil::beanToMap)
            .collect(Collectors.toList());
      } else {
         Preconditions.checkArgument(com.hzchum.scim.common.core.api.enums.ProductTypeEnum.ARTIFACT.getType().equals(productType), "仅构件可查看未排产列表");
         var21 = this.taskService
            .findArtifactSchedulingList(projectId, monomerId, areaIds, classId, serialNumber, areaBatchIds)
            .stream()
            .map(com.hzchum.pangu.common.util.BeanUtil::beanToMap)
            .collect(Collectors.toList());
      }

      printVO.setTable(var21);
      return printVO;
   }

   @Override
   public ListVO<projectProductionDashboardCardDisplayDTO> projectProductionDashboardCardDisplay(
      Long projectId, Long monomerId, Long areaId, String serialNumber, String name, String specification, String material, Integer status, Long areaBatchId
   ) {
      List<TechArtifact> artifactList = this.artifactService
         .list(
            (((((((new LambdaQueryWrapper<TechArtifact>()
                                    .eq(TechArtifact::getProjectId, projectId))
                                 .eq(monomerId != null, TechArtifact::getMonomerId, monomerId))
                              .eq(areaId != null, TechArtifact::getAreaId, areaId))
                           .eq(areaBatchId != null, TechArtifact::getAreaBatchId, areaBatchId))
                        .like(StringUtils.isNotBlank(serialNumber), TechArtifact::getSerialNumber, serialNumber))
                     .like(StringUtils.isNotBlank(name), TechArtifact::getName, name))
                  .like(StringUtils.isNotBlank(specification), TechArtifact::getSpecification, specification))
               .like(StringUtils.isNotBlank(material), TechArtifact::getMaterial, material)
         );
      if (CollectionUtils.isEmpty(artifactList)) {
         return new ListVO<>();
      }

      List<Long> artifactIds = artifactList.stream().map(TechArtifact::getId).collect(Collectors.toList());
      List<projectProductionDashboardCardDisplayDTO> dashboardCardDisplayDTOS = BeanUtil.copyToList(
         artifactList, projectProductionDashboardCardDisplayDTO.class
      );
      List<MesBuildingTask> artifactAllTaskList = this.taskService
         .list(
            ((((new LambdaQueryWrapper<MesBuildingTask>()
                           .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType()))
                        .eq(MesBuildingTask::getProjectId, projectId))
                     .eq(monomerId != null, MesBuildingTask::getMonomerId, monomerId))
                  .eq(areaId != null, MesBuildingTask::getAreaId, areaId))
               .eq(areaBatchId != null, MesBuildingTask::getAreaBatchId, areaBatchId)
         );
      Map<Long, List<MesBuildingTask>> artifactTaskMap = artifactAllTaskList.stream().collect(Collectors.groupingBy(MesBuildingTask::getProductId));
      Map<Long, List<MesBuildingTaskNumberLink>> artifactAssembleTaskNumberLinkMap = this.taskNumberLinkService
         .list((Wrapper<MesBuildingTaskNumberLink>)new LambdaQueryWrapper<MesBuildingTaskNumberLink>().in(MesBuildingTaskNumberLink::getArtifactId, artifactIds))
         .stream()
         .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactId));
      Map<Long, List<MesBuildingMachinePartSchedulingArtifactTaskLink>> artifactPartSchedulingArtifactTaskLinksMap = new HashMap<>();
      Map<Long, List<MesBuildingTask>> allPartTasksMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(artifactAllTaskList)) {
         List<MesBuildingMachinePartSchedulingArtifactTaskLink> partSchedulingArtifactTaskLinks = this.schedulingArtifactTaskLinkService
            .list(
               (Wrapper<MesBuildingMachinePartSchedulingArtifactTaskLink>)new LambdaQueryWrapper<MesBuildingMachinePartSchedulingArtifactTaskLink>()
                  .in(
                     MesBuildingMachinePartSchedulingArtifactTaskLink::getTaskId,
                     artifactAllTaskList.stream().map(MesBuildingTask::getId).collect(Collectors.toList())
                  )
            );
         if (CollectionUtils.isNotEmpty(partSchedulingArtifactTaskLinks)) {
            artifactPartSchedulingArtifactTaskLinksMap = partSchedulingArtifactTaskLinks.stream()
               .collect(Collectors.groupingBy(MesBuildingMachinePartSchedulingArtifactTaskLink::getTaskId));
            List<MesBuildingMachinePartSchedulingLink> mesBuildingMachinePartSchedulingLinks = this.partSchedulingLinkService
               .listByIds(
                  partSchedulingArtifactTaskLinks.stream()
                     .map(MesBuildingMachinePartSchedulingArtifactTaskLink::getSchedulingLinkId)
                     .collect(Collectors.toList())
               );
            if (CollectionUtils.isNotEmpty(mesBuildingMachinePartSchedulingLinks)) {
               allPartTasksMap = this.taskService
                  .list(
                     (Wrapper<MesBuildingTask>)(new LambdaQueryWrapper<MesBuildingTask>()
                           .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.MACHINE_PART.getType()))
                        .in(
                           MesBuildingTask::getMachinePartSchedulingId,
                           mesBuildingMachinePartSchedulingLinks.stream()
                              .map(MesBuildingMachinePartSchedulingLink::getSchedulingId)
                              .collect(Collectors.toList())
                        )
                  )
                  .stream()
                  .collect(Collectors.groupingBy(MesBuildingTask::getMachinePartSchedulingId));
            }
         }
      }

      Map<Long, List<MesBuildingMachinePartSchedulingArtifactTaskLink>> finalArtifactPartSchedulingArtifactTaskLinksMap = artifactPartSchedulingArtifactTaskLinksMap;
      Map<Long, List<MesBuildingTask>> finalAllPartTasksMap = allPartTasksMap;
      dashboardCardDisplayDTOS.forEach(
         displayDTO -> {
            List<MesBuildingTask> artifactTaskList = artifactTaskMap.get(displayDTO.getId());
            List<MesBuildingTaskNumberLink> numberLinks = artifactAssembleTaskNumberLinkMap.get(displayDTO.getId());
            displayDTO.setQuantity(displayDTO.getQuantity() - displayDTO.getOutsourcingQuantity());
            if (CollectionUtils.isEmpty(artifactTaskList)) {
               displayDTO.setStatus(ProductStatusEnum.UNPROCESSED.getType());
            } else if (displayDTO.getProducedQuantity().equals(displayDTO.getQuantity())) {
               displayDTO.setStatus(ProductStatusEnum.COMPLETED.getType());
            } else if (displayDTO.getProducedQuantity() < displayDTO.getQuantity() && displayDTO.getProducedQuantity() > 0) {
               displayDTO.setStatus(ProductStatusEnum.IN_PRODUCTION.getType());
            } else {
               if (displayDTO.getProducedQuantity().equals(0)) {
                  displayDTO.setStatus(ProductStatusEnum.UNPROCESSED.getType());
                  if (CollectionUtils.isNotEmpty(numberLinks)
                     && numberLinks.stream().anyMatch(e -> e.getBoolAssembleComplete() && e.getAssembleTaskId() != null)) {
                     displayDTO.setStatus(ProductStatusEnum.IN_PRODUCTION.getType());
                     return;
                  }

                  for (MesBuildingTask artifactTask : artifactTaskList) {
                     List<MesBuildingMachinePartSchedulingArtifactTaskLink> partSchedulingArtifactTaskLinks = finalArtifactPartSchedulingArtifactTaskLinksMap.get(
                        artifactTask.getId()
                     );
                     if (CollectionUtils.isNotEmpty(partSchedulingArtifactTaskLinks)) {
                        for (MesBuildingMachinePartSchedulingArtifactTaskLink schedulingArtifactTaskLink : partSchedulingArtifactTaskLinks) {
                           List<MesBuildingTask> partTasks = finalAllPartTasksMap.get(schedulingArtifactTaskLink.getSchedulingId());
                           if (CollectionUtils.isNotEmpty(partTasks) && partTasks.stream().anyMatch(e -> e.getCompleteQuantity() > 0)) {
                              displayDTO.setStatus(ProductStatusEnum.IN_PRODUCTION.getType());
                              return;
                           }
                        }
                     }
                  }
               }
            }
         }
      );
      if (status != null) {
         dashboardCardDisplayDTOS = dashboardCardDisplayDTOS.stream()
            .filter(e -> e.getStatus().equals(status))
            .filter(e -> e.getQuantity() > 0)
            .collect(Collectors.toList());
      } else {
         dashboardCardDisplayDTOS = dashboardCardDisplayDTOS.stream()
            .filter(e -> e.getQuantity() > 0)
            .sorted(Comparator.comparing(projectProductionDashboardCardDisplayDTO::getStatus))
            .collect(Collectors.toList());
      }

      return new ListVO<>(dashboardCardDisplayDTOS);
   }

   @Override
   public projectProductionDashboardCardDisplayDetailDTO projectProductionDashboardCardDisplayDetail(Long productId) {
      TechArtifact artifact = this.artifactService.getById(productId);
      Preconditions.checkArgument(artifact != null, "构件不存在");
      projectProductionDashboardCardDisplayDetailDTO artifactDashboardCardDisplayDetailDTO = BeanUtil.copyProperties(
         artifact, projectProductionDashboardCardDisplayDetailDTO.class
      );
      artifactDashboardCardDisplayDetailDTO.setArtifactId(artifact.getId());
      artifactDashboardCardDisplayDetailDTO.setCompanyQuantity(artifact.getProducedQuantity());
      artifactDashboardCardDisplayDetailDTO.setTaskQuantity(0);
      artifactDashboardCardDisplayDetailDTO.setBoolCompany(Boolean.FALSE);
      artifactDashboardCardDisplayDetailDTO.setProductType(ProductTypeEnum.ARTIFACT.getType());
      List<MesBuildingTask> tasks = this.taskService
         .list((Wrapper<MesBuildingTask>)new LambdaQueryWrapper<MesBuildingTask>().eq(MesBuildingTask::getProductId, artifact.getId()));
      if (CollectionUtils.isNotEmpty(tasks)) {
         artifactDashboardCardDisplayDetailDTO.setTaskQuantity(tasks.stream().mapToInt(MesBuildingTask::getTaskQuantity).sum());
         artifactDashboardCardDisplayDetailDTO.setBoolCompany(
            artifactDashboardCardDisplayDetailDTO.getQuantity().equals(artifactDashboardCardDisplayDetailDTO.getCompanyQuantity())
         );
      }

      List<TechAssembleDetail> assembleDetailList = this.assembleDetailService
         .list((Wrapper<TechAssembleDetail>)new LambdaQueryWrapper<TechAssembleDetail>().eq(TechAssembleDetail::getArtifactId, artifact.getId()));
      Map<Long, TechAssembleDetail> assembleDetailMap = assembleDetailList.stream()
         .collect(Collectors.toMap(TechAssembleDetail::getAssembleId, Function.identity()));
      if (CollectionUtils.isNotEmpty(assembleDetailList)) {
         List<TechAssemble> techAssembles = this.assembleService
            .listByIds(assembleDetailList.stream().map(TechAssembleDetail::getAssembleId).collect(Collectors.toList()));
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(techAssembles), "操作失败,部件清单不存在!");
         Map<Long, TechAssemble> assembleMap = techAssembles.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
         List<projectProductionDashboardCardDisplayDetailDTO> assembleDisplayDetailDTOS = BeanUtil.copyToList(
            techAssembles, projectProductionDashboardCardDisplayDetailDTO.class
         );
         assembleDisplayDetailDTOS.forEach(assemble -> {
            TechAssembleDetail detail = assembleDetailMap.get(assemble.getId());
            TechAssemble techAssemble = assembleMap.get(assemble.getId());
            assemble.setArtifactId(artifact.getId());
            assemble.setProductType(ProductTypeEnum.ASSEMBLE.getType());
            assemble.setQuantity(detail.getQuantity() * artifact.getQuantity());
            assemble.setTaskQuantity(0);
            assemble.setCompanyQuantity(0);
            if (!techAssemble.getBoolProcess()) {
               assemble.setCompanyQuantity(assemble.getQuantity());
            }

            assemble.setBoolCompany(assemble.getQuantity().equals(assemble.getCompanyQuantity()));
         });
         if (CollectionUtils.isNotEmpty(tasks)) {
            List<MesBuildingTaskNumberLink> mesBuildingTaskNumberLinks = this.taskNumberLinkService
               .list(
                  (Wrapper<MesBuildingTaskNumberLink>)new LambdaQueryWrapper<MesBuildingTaskNumberLink>()
                     .in(MesBuildingTaskNumberLink::getArtifactTaskId, tasks.stream().map(MesBuildingTask::getId).collect(Collectors.toList()))
               );
            if (CollectionUtils.isNotEmpty(mesBuildingTaskNumberLinks)) {
               Map<Long, List<MesBuildingTaskNumberLink>> assembleTaskNumberLinksMap = mesBuildingTaskNumberLinks.stream()
                  .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getAssembleId));

               for (projectProductionDashboardCardDisplayDetailDTO assembleDisplayDetailDTO : assembleDisplayDetailDTOS) {
                  List<MesBuildingTaskNumberLink> numberLinks = assembleTaskNumberLinksMap.get(assembleDisplayDetailDTO.getId());
                  if (CollectionUtils.isEmpty(numberLinks)) {
                     assembleDisplayDetailDTO.setTaskQuantity(0);
                     assembleDisplayDetailDTO.setCompanyQuantity(assembleDisplayDetailDTO.getCompanyQuantity());
                  } else {
                     assembleDisplayDetailDTO.setTaskQuantity(
                        (int)mesBuildingTaskNumberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleNumber).distinct().count()
                     );
                     assembleDisplayDetailDTO.setCompanyQuantity(
                        (int)mesBuildingTaskNumberLinks.stream()
                           .filter(MesBuildingTaskNumberLink::getBoolAssembleComplete)
                           .map(MesBuildingTaskNumberLink::getAssembleNumber)
                           .distinct()
                           .count()
                     );
                  }

                  assembleDisplayDetailDTO.setBoolCompany(assembleDisplayDetailDTO.getQuantity().equals(assembleDisplayDetailDTO.getCompanyQuantity()));
               }
            }
         }

         artifactDashboardCardDisplayDetailDTO.setAssembleList(assembleDisplayDetailDTOS);
      }

      List<TechArtifactMachinePartLink> artifactMachinePartLinks = this.artifactMachinePartLinkService
         .list((Wrapper<TechArtifactMachinePartLink>)new LambdaQueryWrapper<TechArtifactMachinePartLink>().eq(TechArtifactMachinePartLink::getArtifactId, artifact.getId()));
      Map<Long, TechArtifactMachinePartLink> machinePartLinkMap = artifactMachinePartLinks.stream()
         .collect(Collectors.toMap(TechArtifactMachinePartLink::getMachinePartId, Function.identity()));
      if (CollectionUtils.isNotEmpty(artifactMachinePartLinks)) {
         List<TechMachinePart> partList = this.machinePartService
            .listByIds(artifactMachinePartLinks.stream().map(TechArtifactMachinePartLink::getMachinePartId).collect(Collectors.toList()));
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(partList), "操作失败,零件清单不存在!");
         Map<Long, TechMachinePart> machinePartMap = partList.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
         List<projectProductionDashboardCardDisplayDetailDTO> partDisplayDetailDTOS = BeanUtil.copyToList(
            partList, projectProductionDashboardCardDisplayDetailDTO.class
         );
         partDisplayDetailDTOS.forEach(part -> {
            TechArtifactMachinePartLink detail = machinePartLinkMap.get(part.getId());
            TechMachinePart machinePart = machinePartMap.get(part.getId());
            part.setArtifactId(artifact.getId());
            part.setProductType(ProductTypeEnum.MACHINE_PART.getType());
            part.setQuantity(detail.getQuantity() * artifact.getQuantity());
            part.setTaskQuantity(0);
            part.setCompanyQuantity(0);
            if (!machinePart.getBoolProcess()) {
               part.setCompanyQuantity(part.getQuantity());
            }

            part.setBoolCompany(part.getQuantity().equals(part.getCompanyQuantity()));
         });
         if (CollectionUtils.isNotEmpty(tasks)) {
            List<MesBuildingMachinePartSchedulingArtifactTaskLink> allPartSchedulingArtifactTaskLinks = this.schedulingArtifactTaskLinkService
               .list(
                  (Wrapper<MesBuildingMachinePartSchedulingArtifactTaskLink>)new LambdaQueryWrapper<MesBuildingMachinePartSchedulingArtifactTaskLink>()
                     .in(MesBuildingMachinePartSchedulingArtifactTaskLink::getTaskId, tasks.stream().map(MesBuildingTask::getId).collect(Collectors.toList()))
               );
            if (CollectionUtils.isNotEmpty(allPartSchedulingArtifactTaskLinks)) {
               List<MesBuildingMachinePartSchedulingLink> mesBuildingMachinePartSchedulingLinks = this.partSchedulingLinkService
                  .listByIds(
                     allPartSchedulingArtifactTaskLinks.stream()
                        .map(MesBuildingMachinePartSchedulingArtifactTaskLink::getSchedulingLinkId)
                        .collect(Collectors.toList())
                  );
               if (CollectionUtils.isNotEmpty(mesBuildingMachinePartSchedulingLinks)) {
                  Map<Long, List<MesBuildingTask>> partTaskListMap = this.taskService
                     .list(
                        (Wrapper<MesBuildingTask>)(new LambdaQueryWrapper<MesBuildingTask>()
                              .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.MACHINE_PART.getType()))
                           .in(
                              MesBuildingTask::getMachinePartSchedulingId,
                              mesBuildingMachinePartSchedulingLinks.stream()
                                 .map(MesBuildingMachinePartSchedulingLink::getSchedulingId)
                                 .collect(Collectors.toList())
                           )
                     )
                     .stream()
                     .collect(Collectors.groupingBy(MesBuildingTask::getProductId));
                  if (com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isNotEmpty(partTaskListMap)) {
                     partDisplayDetailDTOS.forEach(part -> {
                        List<MesBuildingTask> partTaskList = partTaskListMap.get(part.getId());
                        if (CollectionUtils.isNotEmpty(partTaskList)) {
                           int totalTaskQuantity = partTaskList.stream().mapToInt(MesBuildingTask::getTaskQuantity).sum();
                           int totalCompleteQuantity = partTaskList.stream().mapToInt(MesBuildingTask::getCompleteQuantity).sum();
                           part.setTaskQuantity(totalTaskQuantity > part.getQuantity() ? part.getQuantity() : totalTaskQuantity);
                           part.setCompanyQuantity(totalCompleteQuantity > part.getQuantity() ? part.getQuantity() : totalCompleteQuantity);
                           part.setBoolCompany(part.getQuantity().equals(part.getCompanyQuantity()));
                        }
                     });
                  }
               }
            }
         }

         artifactDashboardCardDisplayDetailDTO.setMachinePartList(partDisplayDetailDTOS);
      }

      return artifactDashboardCardDisplayDetailDTO;
   }

   @Override
   public List<ProcessSummaryDetailsDTO> projectProductionDashboardCardDisplayProcessDetail(Long productId, Integer artifactId, Integer productType) {
      if (ProductTypeEnum.ARTIFACT.getType().equals(productType)) {
         List<ProcessSummaryDetailsDTO> detailsDTOS = this.taskService.getSummaryByIdAndType(productId, productType);
         if (CollectionUtils.isEmpty(detailsDTOS)) {
            return new ArrayList<>();
         }

         List<MesBuildingTaskProcess> taskProcessList = this.taskProcessService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
                  .eq(MesBuildingTaskProcess::getProductId, productId)
                  .eq(MesBuildingTaskProcess::getTaskTypeEnum, productType)
            );
         List<Long> taskProcessIds = taskProcessList.stream().map(MesBuildingTaskProcess::getId).distinct().collect(Collectors.toList());
         List<Long> assitLinesIds = this.assistService
            .list(Wrappers.lambdaQuery(MesBuildingAssist.class).in(MesBuildingAssist::getTaskProcessId, taskProcessIds))
            .stream()
            .map(MesBuildingAssist::getProductionLineId)
            .distinct()
            .collect(Collectors.toList());
         Map<Long, String> teamUserMap = new HashMap<>();
         detailsDTOS.forEach(
            process -> {
               List<produceTeamRecourseDTO> produceTeamDTOS = this.produceTeamReportService
                  .listproduceInfo(Collections.singletonList(process.getProcessId()), productId, productType, assitLinesIds);
               Map<String, Map<Long, List<produceTeamRecourseDTO>>> teamProduceMap = produceTeamDTOS.stream()
                  .collect(Collectors.groupingBy(produceTeamRecourseDTO::getProductLineName, Collectors.groupingBy(produceTeamRecourseDTO::getTeamId)));
               List<TeamTraceDTO> teamTraceList = new ArrayList<>();

               for (String lineName : teamProduceMap.keySet()) {
                  for (Long teamId : teamProduceMap.get(lineName).keySet()) {
                     TeamTraceDTO teamTraceDTO = new TeamTraceDTO();
                     teamTraceDTO.setProductLineName(lineName);
                     Long leaderUserId = this.teamUserLinkService
                        .getOne(
                           Wrappers.lambdaQuery(MesBuildingTeamUserLink.class)
                              .eq(MesBuildingTeamUserLink::getTeamId, teamId)
                              .eq(MesBuildingTeamUserLink::getBoolLeaderEnum, 1)
                        )
                        .getUserId();
                     if (teamUserMap.get(leaderUserId) == null) {
                        User user = this.userService.getById(leaderUserId);
                        teamUserMap.put(user.getId(), user.getName());
                     }

                     teamTraceDTO.setTeamId(teamId);
                     teamTraceDTO.setUserId(leaderUserId);
                     teamTraceDTO.setUserName(teamUserMap.get(leaderUserId));
                     List<produceTeamRecourseDTO> teamManufacture = teamProduceMap.get(lineName).get(teamId);
                     teamTraceDTO.setProduceTeamRecourseList(teamManufacture);
                     teamTraceList.add(teamTraceDTO);
                  }
               }

               process.setTeamTraceList(teamTraceList);
            }
         );
         return detailsDTOS;
      } else if (ProductTypeEnum.ASSEMBLE.getType().equals(productType)) {
         List<MesBuildingTaskNumberLink> mesBuildingTaskNumberLinks = this.taskNumberLinkService
            .list(
               (Wrapper<MesBuildingTaskNumberLink>)(new LambdaQueryWrapper<MesBuildingTaskNumberLink>().eq(MesBuildingTaskNumberLink::getArtifactId, artifactId))
                  .eq(MesBuildingTaskNumberLink::getAssembleId, productId)
            );
         if (CollectionUtils.isEmpty(mesBuildingTaskNumberLinks)) {
            return new ArrayList<>();
         }

         List<Long> assembleTaskIds = mesBuildingTaskNumberLinks.stream()
            .map(MesBuildingTaskNumberLink::getAssembleTaskId)
            .distinct()
            .collect(Collectors.toList());
         if (CollectionUtils.isEmpty(assembleTaskIds)) {
            return new ArrayList<>();
         }

         List<ProcessSummaryDetailsDTO> detailsDTOS = this.taskService.getSummaryByTaskIdAndType(assembleTaskIds, productType);
         if (CollectionUtils.isEmpty(detailsDTOS)) {
            return new ArrayList<>();
         }

         List<MesBuildingTaskProcess> taskProcessList = this.taskProcessService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
                  .in(MesBuildingTaskProcess::getTaskId, assembleTaskIds)
                  .eq(MesBuildingTaskProcess::getTaskTypeEnum, productType)
            );
         List<Long> taskProcessIds = taskProcessList.stream().map(MesBuildingTaskProcess::getId).distinct().collect(Collectors.toList());
         List<Long> assitLinesIds = this.assistService
            .list(Wrappers.lambdaQuery(MesBuildingAssist.class).in(MesBuildingAssist::getTaskProcessId, taskProcessIds))
            .stream()
            .map(MesBuildingAssist::getProductionLineId)
            .distinct()
            .collect(Collectors.toList());
         Map<Long, String> teamUserMap = new HashMap<>();
         List<Integer> assembleNumberList = mesBuildingTaskNumberLinks.stream()
            .map(MesBuildingTaskNumberLink::getAssembleNumber)
            .distinct()
            .collect(Collectors.toList());
         detailsDTOS.forEach(
            process -> {
               List<produceTeamRecourseDTO> produceTeamDTOS = this.produceTeamReportService
                  .listProduceInfoByTypeAndNumber(Collections.singletonList(process.getProcessId()), productId, productType, assitLinesIds, assembleNumberList);
               process.setCompleteQuantity(produceTeamDTOS.stream().mapToInt(produceTeamRecourseDTO::getQuantity).sum());
               process.setInspectionQuantity(produceTeamDTOS.stream().mapToInt(produceTeamRecourseDTO::getInspectionQuantity).sum());
               Map<String, Map<Long, List<produceTeamRecourseDTO>>> teamProduceMap = produceTeamDTOS.stream()
                  .collect(Collectors.groupingBy(produceTeamRecourseDTO::getProductLineName, Collectors.groupingBy(produceTeamRecourseDTO::getTeamId)));
               List<TeamTraceDTO> teamTraceList = new ArrayList<>();

               for (String lineName : teamProduceMap.keySet()) {
                  for (Long teamId : teamProduceMap.get(lineName).keySet()) {
                     TeamTraceDTO teamTraceDTO = new TeamTraceDTO();
                     teamTraceDTO.setProductLineName(lineName);
                     Long leaderUserId = this.teamUserLinkService
                        .getOne(
                           Wrappers.lambdaQuery(MesBuildingTeamUserLink.class)
                              .eq(MesBuildingTeamUserLink::getTeamId, teamId)
                              .eq(MesBuildingTeamUserLink::getBoolLeaderEnum, 1)
                        )
                        .getUserId();
                     if (teamUserMap.get(leaderUserId) == null) {
                        User user = this.userService.getById(leaderUserId);
                        teamUserMap.put(user.getId(), user.getName());
                     }

                     teamTraceDTO.setTeamId(teamId);
                     teamTraceDTO.setUserId(leaderUserId);
                     teamTraceDTO.setUserName(teamUserMap.get(leaderUserId));
                     List<produceTeamRecourseDTO> teamManufacture = teamProduceMap.get(lineName).get(teamId);
                     teamTraceDTO.setProduceTeamRecourseList(teamManufacture);
                     teamTraceList.add(teamTraceDTO);
                  }
               }

               process.setTeamTraceList(teamTraceList);
            }
         );
         return detailsDTOS;
      } else {
         if (ProductTypeEnum.MACHINE_PART.getType().equals(productType)) {
            TechMachinePart machinePart = this.machinePartService.getById(productId);
            Preconditions.checkArgument(machinePart != null, "操作失败,零件清单不存在!");
            if (!machinePart.getBoolProcess()) {
               return new ArrayList<>();
            }

            List<MesBuildingTask> tasks = this.taskService
               .list((Wrapper<MesBuildingTask>)new LambdaQueryWrapper<MesBuildingTask>().eq(MesBuildingTask::getProductId, artifactId));
            TechArtifactMachinePartLink machinePartLink = this.artifactMachinePartLinkService
               .getOne(
                  (Wrapper<TechArtifactMachinePartLink>)(new LambdaQueryWrapper<TechArtifactMachinePartLink>()
                        .eq(TechArtifactMachinePartLink::getArtifactId, artifactId))
                     .eq(TechArtifactMachinePartLink::getMachinePartId, productId)
               );
            Preconditions.checkArgument(machinePartLink != null, "查询失败,构件零件关联不存在!");
            int partQuantity = machinePartLink.getQuantity() * tasks.stream().mapToInt(MesBuildingTask::getTaskQuantity).sum();
            if (CollectionUtils.isNotEmpty(tasks)) {
               List<MesBuildingMachinePartSchedulingArtifactTaskLink> allPartSchedulingArtifactTaskLinks = this.schedulingArtifactTaskLinkService
                  .list(
                     (Wrapper<MesBuildingMachinePartSchedulingArtifactTaskLink>)new LambdaQueryWrapper<MesBuildingMachinePartSchedulingArtifactTaskLink>()
                        .in(
                           MesBuildingMachinePartSchedulingArtifactTaskLink::getTaskId, tasks.stream().map(MesBuildingTask::getId).collect(Collectors.toList())
                        )
                  );
               if (CollectionUtils.isNotEmpty(allPartSchedulingArtifactTaskLinks)) {
                  List<MesBuildingMachinePartSchedulingLink> mesBuildingMachinePartSchedulingLinks = this.partSchedulingLinkService
                     .listByIds(
                        allPartSchedulingArtifactTaskLinks.stream()
                           .map(MesBuildingMachinePartSchedulingArtifactTaskLink::getSchedulingLinkId)
                           .collect(Collectors.toList())
                     );
                  if (CollectionUtils.isNotEmpty(mesBuildingMachinePartSchedulingLinks)) {
                     List<MesBuildingTask> partTaskIds = this.taskService
                        .list(
                           (Wrapper<MesBuildingTask>)(new LambdaQueryWrapper<MesBuildingTask>()
                                 .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.MACHINE_PART.getType()))
                              .in(
                                 MesBuildingTask::getMachinePartSchedulingId,
                                 mesBuildingMachinePartSchedulingLinks.stream()
                                    .map(MesBuildingMachinePartSchedulingLink::getSchedulingId)
                                    .collect(Collectors.toList())
                              )
                        );
                     Preconditions.checkArgument(CollectionUtils.isNotEmpty(partTaskIds), "操作失败,零件任务不存在!");
                     List<Long> taskIds = partTaskIds.stream().map(MesBuildingTask::getId).distinct().collect(Collectors.toList());
                     List<ProcessSummaryDetailsDTO> detailsDTOS = this.taskService.getSummaryByTaskIdAndType(taskIds, productType);
                     Preconditions.checkArgument(CollectionUtils.isNotEmpty(detailsDTOS), "操作失败,零件任务不存在!");
                     List<MesBuildingTaskProcess> taskProcessList = this.taskProcessService
                        .list(
                           Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
                              .in(MesBuildingTaskProcess::getTaskId, taskIds)
                              .eq(MesBuildingTaskProcess::getTaskTypeEnum, productType)
                        );
                     List<Long> taskProcessIds = taskProcessList.stream().map(MesBuildingTaskProcess::getId).distinct().collect(Collectors.toList());
                     List<Long> assitLinesIds = this.assistService
                        .list(Wrappers.lambdaQuery(MesBuildingAssist.class).in(MesBuildingAssist::getTaskProcessId, taskProcessIds))
                        .stream()
                        .map(MesBuildingAssist::getProductionLineId)
                        .distinct()
                        .collect(Collectors.toList());
                     Map<Long, String> teamUserMap = new HashMap<>();
                     detailsDTOS.forEach(
                        process -> {
                           List<produceTeamRecourseDTO> produceTeamDTOS = this.produceTeamReportService
                              .listproduceInfo(Collections.singletonList(process.getProcessId()), productId, productType, assitLinesIds);
                           process.setCompleteQuantity(produceTeamDTOS.stream().mapToInt(produceTeamRecourseDTO::getQuantity).sum());
                           process.setInspectionQuantity(produceTeamDTOS.stream().mapToInt(produceTeamRecourseDTO::getInspectionQuantity).sum());
                           if (process.getCompleteQuantity() > partQuantity) {
                              process.setCompleteQuantity(partQuantity);
                           }

                           if (process.getInspectionQuantity() > partQuantity) {
                              process.setInspectionQuantity(partQuantity);
                           }

                           Map<String, Map<Long, List<produceTeamRecourseDTO>>> teamProduceMap = produceTeamDTOS.stream()
                              .collect(
                                 Collectors.groupingBy(produceTeamRecourseDTO::getProductLineName, Collectors.groupingBy(produceTeamRecourseDTO::getTeamId))
                              );
                           List<TeamTraceDTO> teamTraceList = new ArrayList<>();

                           for (String lineName : teamProduceMap.keySet()) {
                              for (Long teamId : teamProduceMap.get(lineName).keySet()) {
                                 TeamTraceDTO teamTraceDTO = new TeamTraceDTO();
                                 teamTraceDTO.setProductLineName(lineName);
                                 Long leaderUserId = this.teamUserLinkService
                                    .getOne(
                                       Wrappers.lambdaQuery(MesBuildingTeamUserLink.class)
                                          .eq(MesBuildingTeamUserLink::getTeamId, teamId)
                                          .eq(MesBuildingTeamUserLink::getBoolLeaderEnum, 1)
                                    )
                                    .getUserId();
                                 if (teamUserMap.get(leaderUserId) == null) {
                                    User user = this.userService.getById(leaderUserId);
                                    teamUserMap.put(user.getId(), user.getName());
                                 }

                                 teamTraceDTO.setTeamId(teamId);
                                 teamTraceDTO.setUserId(leaderUserId);
                                 teamTraceDTO.setUserName(teamUserMap.get(leaderUserId));
                                 List<produceTeamRecourseDTO> teamManufacture = teamProduceMap.get(lineName).get(teamId);
                                 teamTraceDTO.setProduceTeamRecourseList(teamManufacture);
                                 teamTraceList.add(teamTraceDTO);
                              }
                           }

                           process.setTeamTraceList(teamTraceList);
                        }
                     );
                     return detailsDTOS;
                  }
               }
            }
         }

         return new ArrayList<>();
      }
   }

   @Override
   public PageVO<MesTeamReportProductStaticsDTO> pageTeamReportProductList(
      Integer productType,
      Long workShopId,
      Long productionLineId,
      Long teamId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long processId,
      String serialNumber,
      List<LocalDateTime> dateTimeList,
      Integer pageNumber,
      Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      return new PageVO<>(
         this.getTeamReportProductList(
            productType, workShopId, productionLineId, teamId, projectId, monomerId, areaId, areaBatchId, processId, serialNumber, dateTimeList
         )
      );
   }

   @Override
   public List<MesTeamReportProductStaticsDTO> getTeamReportProductList(
      Integer productType,
      Long workShopId,
      Long productionLineId,
      Long teamId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long processId,
      String serialNumber,
      List<LocalDateTime> dateTimeList
   ) {
      return this.produceTeamReportService
         .getTeamReportProductList(
            productType, workShopId, productionLineId, teamId, projectId, monomerId, areaId, areaBatchId, processId, serialNumber, dateTimeList
         );
   }

   @Override
   public List<MesBuildingProjectWorkshopDTO> getTeamReportProductWorkList(Integer productType) {
      List<Long> allProcessIds = this.processService
         .list((Wrapper<MesBuildingProcess>)new LambdaQueryWrapper<MesBuildingProcess>().eq(MesBuildingProcess::getProductType, productType))
         .stream()
         .map(MesBuildingProcess::getId)
         .collect(Collectors.toList());
      List<MesBuildingTeam> teamList = this.teamService
         .list((Wrapper<MesBuildingTeam>)new LambdaQueryWrapper<MesBuildingTeam>().in(MesBuildingTeam::getProcessId, allProcessIds));
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
               MesBuildingProjectWorkshopDTO workshopDTO = com.hzchum.pangu.common.util.BeanUtil.copy(workshop, MesBuildingProjectWorkshopDTO.class);
               List<MesBuildingProductionLine> productionLineList = productionLineMap.get(workshop.getId());
               List<MesBuildingProjectProductionLineDTO> projectProductionLineDTOS = BeanUtil.copyToList(
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
   public PrintVO<List<Map<String, Object>>> printTeamReportProductList(
      Integer productType,
      Long workShopId,
      Long productionLineId,
      Long teamId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long processId,
      String serialNumber,
      List<LocalDateTime> dateTimeList
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("statisticalDate", "全部");
      header.put("productType", ProductTypeEnum.getNameByType(productType));
      if (com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isNotEmpty(dateTimeList) && dateTimeList.size() == 2) {
         DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         String startTime = df.format(dateTimeList.get(0));
         String endTime = df.format(dateTimeList.get(1));
         header.put("statisticalDate", startTime + "-" + endTime);
      }

      printVO.setHeader(header);
      printVO.setTable(
         this.getTeamReportProductList(
               productType, workShopId, productionLineId, teamId, projectId, monomerId, areaId, areaBatchId, processId, serialNumber, dateTimeList
            )
            .stream()
            .map(com.hzchum.pangu.common.util.BeanUtil::beanToMap)
            .collect(Collectors.toList())
      );
      return printVO;
   }

   private List<ProjectProductionKanBanListDTO> getConversionResult(
      Integer productKanBanEnum,
      Map<String, ProjectProductionKanBanProcessDTO> productionKanBanProcessDTOMap,
      List<ProjectProductionKanBanListDTO> kanBanArtifactTaskList,
      List<ProjectProductionKanBanListDTO> retunKanBanArtifactTaskList,
      List<String> sortList,
      Long processId,
      Integer processStatus
   ) {
      if (com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isNotEmpty(productionKanBanProcessDTOMap)) {
         List<ProjectProductionKanBanProcessDTO> kanBanProcessDTOS = new ArrayList<>(productionKanBanProcessDTOMap.values());
         Map<Long, List<ProjectProductionKanBanProcessDTO>> allProductionKanBanProcessDTOMap = kanBanProcessDTOS.stream()
            .collect(Collectors.groupingBy(ProjectProductionKanBanProcessDTO::getArtifactTaskId));

         for (ProjectProductionKanBanListDTO detailDTO : kanBanArtifactTaskList) {
            List<ProjectProductionKanBanProcessDTO> dtos = allProductionKanBanProcessDTOMap.get(detailDTO.getTaskId());
            if (CollectionUtils.isEmpty(dtos)) {
               if (processId == null) {
                  retunKanBanArtifactTaskList.add(detailDTO);

                  for (ProjectProductionKanBanListDTO projectProductionKanBanListDTO : retunKanBanArtifactTaskList) {
                     System.out.println(projectProductionKanBanListDTO);
                  }
               }
            } else if (CollectionUtils.isNotEmpty(dtos)) {
               for (ProjectProductionKanBanProcessDTO dto : dtos) {
                  if (dto.getTotalReportQuantity() == 0) {
                     dto.setProductKanBanCompanyStatusEnum(ProductKanBanCompanyStatusEnum.UNFINISHED.getType());
                  }

                  if (dto.getTotalReportQuantity() > 0 && dto.getTotalReportQuantity() < dto.getTotalTaskQuantity()) {
                     dto.setProductKanBanCompanyStatusEnum(ProductKanBanCompanyStatusEnum.PARTLY_COMPLETED.getType());
                  }

                  if (dto.getTotalReportQuantity().equals(dto.getTotalTaskQuantity())) {
                     dto.setProductKanBanCompanyStatusEnum(ProductKanBanCompanyStatusEnum.COMPLETED.getType());
                  }

                  if (dto.getProductKanBanCompanyStatusEnum() == null && dto.getTotalReportQuantity() > 0) {
                     dto.setProductKanBanCompanyStatusEnum(ProductKanBanCompanyStatusEnum.COMPLETED.getType());
                  }
               }

               Map<String, Integer> orderMap = IntStream.range(0, sortList.size()).boxed().collect(Collectors.toMap(sortList::get, Function.identity()));
               AtomicReference<Float> sum = new AtomicReference<>(0.0F);
               dtos.sort(Comparator.comparing(e -> {
                  if (e.getProcessName().contains("质检")) {
                     sum.set(0.5F);
                  } else if (e.getProcessName().contains("发运")) {
                     sum.set(100.0F);
                  }

                  Float sortNumber = orderMap.getOrDefault(e.getProcessId() + e.getProcessName().replace("质检", ""), 0).intValue() + sum.get();
                  sum.set(0.0F);
                  return sortNumber;
               }));
               detailDTO.setProductionKanBanProcessDTOS(dtos);
               if (productKanBanEnum == null) {
                  retunKanBanArtifactTaskList.add(detailDTO);
               } else {
                  if (!ProductKanBanEnum.checkBoolArtifactType(productKanBanEnum)) {
                     List<ProjectProductionKanBanProcessDTO> processDTOS = dtos.stream()
                        .filter(e -> e.getProductType().equals(ProductTypeEnum.ARTIFACT.getType()))
                        .collect(Collectors.toList());
                     if (CollectionUtils.isNotEmpty(processDTOS)) {
                        if (processId != null) {
                           List<ProjectProductionKanBanProcessDTO> productionKanBanProcessDTOS = dtos.stream()
                              .filter(e -> e.getProcessId().equals(processId) && !e.getProcessName().contains("质检"))
                              .collect(Collectors.toList());
                           if (CollectionUtils.isEmpty(productionKanBanProcessDTOS)) {
                              continue;
                           }

                           if (processStatus != null) {
                              int totalProcessReportQuantity = productionKanBanProcessDTOS.stream()
                                 .mapToInt(e -> e.getTotalReportQuantity() == null ? 0 : e.getTotalReportQuantity())
                                 .sum();
                              int totalProcessTaskQuantity = productionKanBanProcessDTOS.stream()
                                 .mapToInt(ProjectProductionKanBanProcessDTO::getTotalTaskQuantity)
                                 .sum();
                              if (ProductKanBanCompanyStatusEnum.UNFINISHED.getType().equals(processStatus) && totalProcessReportQuantity != 0
                                 || ProductKanBanCompanyStatusEnum.PARTLY_COMPLETED.getType().equals(processStatus)
                                    && (totalProcessReportQuantity == totalProcessTaskQuantity || totalProcessReportQuantity == 0)
                                 || ProductKanBanCompanyStatusEnum.COMPLETED.getType().equals(processStatus)
                                    && totalProcessReportQuantity < totalProcessTaskQuantity) {
                                 continue;
                              }
                           }
                        }

                        retunKanBanArtifactTaskList.add(detailDTO);
                     }
                  }

                  if (ProductKanBanEnum.UNFINISHED_PART.getType().equals(productKanBanEnum)) {
                     List<ProjectProductionKanBanProcessDTO> processDTOS = dtos.stream()
                        .filter(e -> e.getProductType().equals(ProductTypeEnum.MACHINE_PART.getType()))
                        .collect(Collectors.toList());
                     if (CollectionUtils.isNotEmpty(processDTOS)) {
                        int totalReportQuantity = processDTOS.stream().mapToInt(ProjectProductionKanBanProcessDTO::getTotalReportQuantity).sum();
                        if (totalReportQuantity == 0) {
                           retunKanBanArtifactTaskList.add(detailDTO);
                        }
                     }
                  }

                  if (ProductKanBanEnum.FINISHED_PART.getType().equals(productKanBanEnum)) {
                     List<ProjectProductionKanBanProcessDTO> processDTOS = dtos.stream()
                        .filter(e -> e.getProductType().equals(ProductTypeEnum.MACHINE_PART.getType()))
                        .collect(Collectors.toList());
                     if (CollectionUtils.isNotEmpty(processDTOS)) {
                        int totalReportQuantity = processDTOS.stream().mapToInt(ProjectProductionKanBanProcessDTO::getTotalReportQuantity).sum();
                        int totalTaskQuantity = processDTOS.stream().mapToInt(ProjectProductionKanBanProcessDTO::getTotalTaskQuantity).sum();
                        if (totalReportQuantity == totalTaskQuantity) {
                           retunKanBanArtifactTaskList.add(detailDTO);
                        }
                     } else {
                        retunKanBanArtifactTaskList.add(detailDTO);
                     }
                  }

                  if (ProductKanBanEnum.PARTIAL_COMPLETION_PART.getType().equals(productKanBanEnum)) {
                     List<ProjectProductionKanBanProcessDTO> processDTOS = dtos.stream()
                        .filter(e -> e.getProductType().equals(ProductTypeEnum.MACHINE_PART.getType()))
                        .collect(Collectors.toList());
                     if (CollectionUtils.isNotEmpty(processDTOS)) {
                        int totalReportQuantity = processDTOS.stream().mapToInt(ProjectProductionKanBanProcessDTO::getTotalReportQuantity).sum();
                        int totalTaskQuantity = processDTOS.stream().mapToInt(ProjectProductionKanBanProcessDTO::getTotalTaskQuantity).sum();
                        if (totalReportQuantity > 0 && totalReportQuantity < totalTaskQuantity) {
                           retunKanBanArtifactTaskList.add(detailDTO);
                        }
                     }
                  }

                  if (ProductKanBanEnum.UNFINISHED_ASSEMBLE.getType().equals(productKanBanEnum)) {
                     List<ProjectProductionKanBanProcessDTO> processDTOS = dtos.stream()
                        .filter(e -> e.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType()))
                        .collect(Collectors.toList());
                     if (CollectionUtils.isNotEmpty(processDTOS)) {
                        int totalReportQuantity = processDTOS.stream().mapToInt(ProjectProductionKanBanProcessDTO::getTotalInspectionQuantity).sum();
                        int totalTaskQuantity = processDTOS.stream().mapToInt(ProjectProductionKanBanProcessDTO::getTotalTaskQuantity).sum();
                        if (totalReportQuantity == totalTaskQuantity || totalReportQuantity == 0) {
                           continue;
                        }

                        if (processId != null) {
                           List<ProjectProductionKanBanProcessDTO> productionKanBanProcessDTOS = dtos.stream()
                              .filter(e -> e.getProcessId().equals(processId))
                              .collect(Collectors.toList());
                           if (CollectionUtils.isEmpty(productionKanBanProcessDTOS)) {
                              continue;
                           }

                           if (processStatus != null) {
                              int totalProcessReportQuantity = productionKanBanProcessDTOS.stream()
                                 .mapToInt(e -> e.getTotalInspectionQuantity() == null ? 0 : e.getTotalInspectionQuantity())
                                 .sum();
                              int totalProcessTaskQuantity = productionKanBanProcessDTOS.stream()
                                 .mapToInt(ProjectProductionKanBanProcessDTO::getTotalTaskQuantity)
                                 .sum();
                              if (ProductKanBanCompanyStatusEnum.UNFINISHED.getType().equals(processStatus) && totalProcessReportQuantity != 0
                                 || ProductKanBanCompanyStatusEnum.PARTLY_COMPLETED.getType().equals(processStatus)
                                    && (totalProcessReportQuantity == totalProcessTaskQuantity || totalProcessReportQuantity == 0)
                                 || ProductKanBanCompanyStatusEnum.COMPLETED.getType().equals(processStatus)
                                    && totalProcessReportQuantity < totalProcessTaskQuantity) {
                                 continue;
                              }
                           }
                        }

                        retunKanBanArtifactTaskList.add(detailDTO);
                     }
                  }

                  if (ProductKanBanEnum.FINISHED_ASSEMBLE.getType().equals(productKanBanEnum)) {
                     List<ProjectProductionKanBanProcessDTO> processDTOS = dtos.stream()
                        .filter(e -> e.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType()))
                        .collect(Collectors.toList());
                     if (CollectionUtils.isNotEmpty(processDTOS)) {
                        int totalReportQuantity = processDTOS.stream().mapToInt(ProjectProductionKanBanProcessDTO::getTotalInspectionQuantity).sum();
                        int totalTaskQuantity = processDTOS.stream().mapToInt(ProjectProductionKanBanProcessDTO::getTotalTaskQuantity).sum();
                        if (totalReportQuantity == totalTaskQuantity) {
                           retunKanBanArtifactTaskList.add(detailDTO);
                        }
                     } else {
                        retunKanBanArtifactTaskList.add(detailDTO);
                     }
                  }

                  if (ProductKanBanEnum.PARTIAL_COMPLETION_ASSEMBLE.getType().equals(productKanBanEnum)) {
                     List<ProjectProductionKanBanProcessDTO> processDTOS = dtos.stream()
                        .filter(e -> e.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType()))
                        .collect(Collectors.toList());
                     if (CollectionUtils.isNotEmpty(processDTOS)) {
                        int totalReportQuantity = processDTOS.stream().mapToInt(ProjectProductionKanBanProcessDTO::getTotalInspectionQuantity).sum();
                        int totalTaskQuantity = processDTOS.stream().mapToInt(ProjectProductionKanBanProcessDTO::getTotalTaskQuantity).sum();
                        if (totalReportQuantity == 0 || totalReportQuantity >= totalTaskQuantity) {
                           continue;
                        }

                        if (processId != null) {
                           List<ProjectProductionKanBanProcessDTO> productionKanBanProcessDTOS = dtos.stream()
                              .filter(e -> e.getProcessId().equals(processId) && !e.getProcessName().contains("质检"))
                              .collect(Collectors.toList());
                           if (CollectionUtils.isEmpty(productionKanBanProcessDTOS)) {
                              continue;
                           }

                           if (processStatus != null) {
                              int totalProcessReportQuantity = productionKanBanProcessDTOS.stream()
                                 .mapToInt(e -> e.getTotalReportQuantity() == null ? 0 : e.getTotalReportQuantity())
                                 .sum();
                              int totalProcessTaskQuantity = productionKanBanProcessDTOS.stream()
                                 .mapToInt(ProjectProductionKanBanProcessDTO::getTotalTaskQuantity)
                                 .sum();
                              if (ProductKanBanCompanyStatusEnum.UNFINISHED.getType().equals(processStatus) && totalProcessTaskQuantity != 0
                                 || ProductKanBanCompanyStatusEnum.PARTLY_COMPLETED.getType().equals(processStatus)
                                    && (totalProcessReportQuantity == totalProcessTaskQuantity || totalProcessReportQuantity == 0)
                                 || ProductKanBanCompanyStatusEnum.COMPLETED.getType().equals(processStatus)
                                    && totalProcessReportQuantity < totalProcessTaskQuantity) {
                                 continue;
                              }
                           }
                        }

                        retunKanBanArtifactTaskList.add(detailDTO);
                     }
                  }

                  if (ProductKanBanEnum.UNFINISHED_CARGO.getType().equals(productKanBanEnum)) {
                     List<ProjectProductionKanBanProcessDTO> processDTOS = dtos.stream()
                        .filter(e -> e.getProcessType().equals(KanBanProcessTypeEnum.CARGO.getType()))
                        .collect(Collectors.toList());
                     if (CollectionUtils.isNotEmpty(processDTOS)) {
                        int totalReportQuantity = processDTOS.stream().mapToInt(ProjectProductionKanBanProcessDTO::getTotalReportQuantity).sum();
                        if (totalReportQuantity == 0) {
                           retunKanBanArtifactTaskList.add(detailDTO);
                        }
                     }
                  }

                  if (ProductKanBanEnum.PARTIAL_COMPLETION_CARGO.getType().equals(productKanBanEnum)) {
                     List<ProjectProductionKanBanProcessDTO> processDTOS = dtos.stream()
                        .filter(e -> e.getProcessType().equals(KanBanProcessTypeEnum.CARGO.getType()))
                        .collect(Collectors.toList());
                     if (CollectionUtils.isNotEmpty(processDTOS)) {
                        int totalReportQuantity = processDTOS.stream().mapToInt(ProjectProductionKanBanProcessDTO::getTotalReportQuantity).sum();
                        int totalTaskQuantity = processDTOS.stream().mapToInt(ProjectProductionKanBanProcessDTO::getTotalTaskQuantity).sum();
                        if (totalReportQuantity > 0 && totalReportQuantity < totalTaskQuantity) {
                           retunKanBanArtifactTaskList.add(detailDTO);
                        }
                     }
                  }

                  if (ProductKanBanEnum.FINISHED_CARGO.getType().equals(productKanBanEnum)) {
                     List<ProjectProductionKanBanProcessDTO> processDTOS = dtos.stream()
                        .filter(e -> e.getProcessType().equals(KanBanProcessTypeEnum.CARGO.getType()))
                        .collect(Collectors.toList());
                     if (CollectionUtils.isNotEmpty(processDTOS)) {
                        int totalReportQuantity = processDTOS.stream().mapToInt(ProjectProductionKanBanProcessDTO::getTotalReportQuantity).sum();
                        int totalTaskQuantity = processDTOS.stream().mapToInt(ProjectProductionKanBanProcessDTO::getTotalTaskQuantity).sum();
                        if (totalReportQuantity > 0 && totalReportQuantity == totalTaskQuantity) {
                           retunKanBanArtifactTaskList.add(detailDTO);
                        }
                     } else {
                        retunKanBanArtifactTaskList.add(detailDTO);
                     }
                  }
               }
            }
         }
      }

      return retunKanBanArtifactTaskList;
   }

   private void buildingTaskArtifact(
      List<Long> artifactTaskIds,
      Map<String, ProjectProductionKanBanProcessDTO> productionKanBanProcessDTOMap,
      Map<String, List<MesInspectConfigBasicDTO>> configBasicDTOMap,
      Map<Long, MesBuildingProcess> processMap,
      Map<Long, List<MesInspectConfigUserLink>> inspectConfigUserLinkMap,
      Map<Long, User> userMap,
      Map<Long, List<MesBuildingComplete>> completeMap,
      Map<Long, List<MesBuildingWarehouseRecord>> warehouseOutRecordMap
   ) {
      List<MesBuildingTaskProcess> taskProcesses = this.taskProcessService
         .list((Wrapper<MesBuildingTaskProcess>)new LambdaQueryWrapper<MesBuildingTaskProcess>().in(MesBuildingTaskProcess::getTaskId, artifactTaskIds));
      if (!CollectionUtils.isEmpty(taskProcesses)) {
         Map<Long, TechArtifact> artifactMap = this.artifactService
            .listByIds(taskProcesses.stream().map(MesBuildingTaskProcess::getProductId).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
         Map<Long, List<MesBuildingProduceInspectionTeamReport>> inspectionTeamReportMap = this.produceInspectionTeamReportService
            .list(
               (Wrapper<MesBuildingProduceInspectionTeamReport>)new LambdaQueryWrapper<MesBuildingProduceInspectionTeamReport>()
                  .in(
                     MesBuildingProduceInspectionTeamReport::getTaskProcessId,
                     taskProcesses.stream().map(MesBuildingTaskProcess::getId).collect(Collectors.toList())
                  )
            )
            .stream()
            .collect(Collectors.groupingBy(MesBuildingProduceInspectionTeamReport::getTaskProcessId));
         Map<Long, List<MesBuildingTaskProcess>> artifactTaskProcessMap = taskProcesses.stream()
            .collect(Collectors.groupingBy(MesBuildingTaskProcess::getTaskId));
         Map<Long, MesBuildingTaskOrder> taskOrderMap = this.taskOrderService
            .listByIds(taskProcesses.stream().map(MesBuildingTaskProcess::getTaskOrderId).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(MesBuildingTaskOrder::getId, Function.identity()));
         Map<Long, List<MesBuildingAssist>> artifactAssistMap = this.assistService
            .list(
               (Wrapper<MesBuildingAssist>)new LambdaQueryWrapper<MesBuildingAssist>()
                  .in(MesBuildingAssist::getTaskProcessId, taskProcesses.stream().map(MesBuildingTaskProcess::getId).collect(Collectors.toList()))
            )
            .stream()
            .collect(Collectors.groupingBy(MesBuildingAssist::getTaskProcessId));
         artifactTaskProcessMap.forEach(
            (artifactTaskId, artifactTaskProcessList) -> {
               MesBuildingTaskProcess taskProcessByOne = artifactTaskProcessList.get(0);

               for (MesBuildingTaskProcess taskProcess : artifactTaskProcessList) {
                  ProjectProductionKanBanProcessDTO kanBanProcessDTO = productionKanBanProcessDTOMap.get(
                     artifactTaskId + "-" + taskProcess.getProcessId() + "-" + KanBanProcessTypeEnum.REPORT.getType()
                  );
                  if (kanBanProcessDTO == null) {
                     ProjectProductionKanBanProcessDTO artifactBleKanBanProcessDTO = ProjectProductionKanBanProcessDTO.builder()
                        .artifactTaskId(artifactTaskId)
                        .netWeight(artifactMap.get(taskProcess.getProductId()).getNetWeight())
                        .processId(taskProcess.getProcessId())
                        .totalTaskQuantity(taskProcess.getTaskQuantity())
                        .totalReportQuantity(0)
                        .processType(KanBanProcessTypeEnum.REPORT.getType())
                        .processName(processMap.get(taskProcess.getProcessId()).getName())
                        .productType(ProductTypeEnum.ARTIFACT.getType())
                        .orderNumber(taskOrderMap.get(taskProcess.getTaskOrderId()).getOrderNumber())
                        .build();
                     productionKanBanProcessDTOMap.put(
                        artifactTaskId + "-" + taskProcess.getProcessId() + "-" + KanBanProcessTypeEnum.REPORT.getType(), artifactBleKanBanProcessDTO
                     );
                  } else {
                     kanBanProcessDTO.setTotalTaskQuantity(kanBanProcessDTO.getTotalTaskQuantity() + taskProcess.getTaskQuantity());
                  }

                  List<MesBuildingAssist> artifactMesBuildingAssists = artifactAssistMap.get(taskProcess.getId());
                  List<MesInspectConfigBasicDTO> mesInspectConfigBasicDTOList = configBasicDTOMap.get(
                     taskProcess.getProcessId() + "-" + taskProcess.getTeamId() + "-" + artifactMap.get(taskProcess.getProductId()).getStructureClassId()
                  );
                  if (!taskProcess.getTaskQuantity().equals(taskProcess.getInspectionQuantity())
                     || CollectionUtils.isNotEmpty(inspectionTeamReportMap.get(taskProcess.getId()))) {
                     ProjectProductionKanBanProcessDTO inspectionKanBanProcessDTO = productionKanBanProcessDTOMap.get(
                        artifactTaskId + "-" + taskProcess.getProcessId() + "-" + KanBanProcessTypeEnum.INSPECTION.getType()
                     );
                     if (inspectionKanBanProcessDTO == null) {
                        ProjectProductionKanBanProcessDTO artifactBleKanBanProcessDTO = ProjectProductionKanBanProcessDTO.builder()
                           .artifactTaskId(artifactTaskId)
                           .processId(taskProcess.getProcessId())
                           .totalTaskQuantity(taskProcess.getTaskQuantity())
                           .totalReportQuantity(0)
                           .totalInspectionQuantity(0)
                           .processType(KanBanProcessTypeEnum.INSPECTION.getType())
                           .processName(processMap.get(taskProcess.getProcessId()).getName() + "质检")
                           .productType(ProductTypeEnum.ARTIFACT.getType())
                           .orderNumber(taskOrderMap.get(taskProcess.getTaskOrderId()).getOrderNumber())
                           .build();
                        Set<String> userNames = new HashSet<>();
                        int assistsSum = CollectionUtils.isEmpty(artifactMesBuildingAssists)
                           ? 0
                           : artifactMesBuildingAssists.stream().mapToInt(MesBuildingAssist::getQuantity).sum();
                        if (!taskProcess.getTaskQuantity().equals(taskProcess.getInspectionQuantity())
                           && taskProcess.getTaskQuantity() > assistsSum
                           && CollectionUtils.isNotEmpty(mesInspectConfigBasicDTOList)) {
                           for (MesInspectConfigBasicDTO mesInspectConfigBasicDTO : mesInspectConfigBasicDTOList) {
                              for (MesInspectConfigUserLink inspectConfigUserLink : inspectConfigUserLinkMap.get(mesInspectConfigBasicDTO.getId())) {
                                 String name = userMap.get(inspectConfigUserLink.getInspectUserId()).getName();
                                 userNames.add(name);
                              }
                           }
                        }

                        if (!taskProcess.getTaskQuantity().equals(taskProcess.getInspectionQuantity()) && assistsSum > 0) {
                           for (MesBuildingAssist assist : artifactMesBuildingAssists) {
                              List<MesInspectConfigBasicDTO> assistInspectConfigBasicDTOList = configBasicDTOMap.get(
                                 taskProcess.getProcessId()
                                    + "-"
                                    + assist.getTeamId()
                                    + "-"
                                    + artifactMap.get(taskProcess.getProductId()).getStructureClassId()
                              );
                              if (CollectionUtils.isNotEmpty(assistInspectConfigBasicDTOList)) {
                                 for (MesInspectConfigBasicDTO mesInspectConfigBasicDTO : assistInspectConfigBasicDTOList) {
                                    for (MesInspectConfigUserLink inspectConfigUserLink : inspectConfigUserLinkMap.get(mesInspectConfigBasicDTO.getId())) {
                                       String name = userMap.get(inspectConfigUserLink.getInspectUserId()).getName();
                                       userNames.add(name);
                                    }
                                 }
                              }
                           }
                        }

                        if (CollectionUtils.isNotEmpty(inspectionTeamReportMap.get(taskProcess.getId()))) {
                           List<MesBuildingProduceInspectionTeamReport> inspectionTeamReports = inspectionTeamReportMap.get(taskProcess.getId());
                           inspectionTeamReports.forEach(
                              e -> userNames.add(userMap.get(e.getUserId()) == null ? "超级管理员" : userMap.get(e.getUserId()).getName())
                           );
                        }

                        artifactBleKanBanProcessDTO.setInspectionUserName(StringUtils.join(userNames.toArray(), ","));
                        productionKanBanProcessDTOMap.put(
                           artifactTaskId + "-" + taskProcess.getProcessId() + "-" + KanBanProcessTypeEnum.INSPECTION.getType(), artifactBleKanBanProcessDTO
                        );
                     } else {
                        inspectionKanBanProcessDTO.setTotalTaskQuantity(inspectionKanBanProcessDTO.getTotalTaskQuantity() + taskProcess.getTaskQuantity());
                     }
                  }
               }

               for (MesBuildingTaskProcess taskProcess : artifactTaskProcessList) {
                  ProjectProductionKanBanProcessDTO kanBanProcessDTO = productionKanBanProcessDTOMap.get(
                     artifactTaskId + "-" + taskProcess.getProcessId() + "-" + KanBanProcessTypeEnum.REPORT.getType()
                  );
                  Preconditions.checkArgument(kanBanProcessDTO != null, "操作失败,数据异常!");
                  kanBanProcessDTO.setTotalReportQuantity(kanBanProcessDTO.getTotalReportQuantity() + taskProcess.getCompleteQuantity());
                  ProjectProductionKanBanProcessDTO inspectionKanBanProcessDTO = productionKanBanProcessDTOMap.get(
                     artifactTaskId + "-" + taskProcess.getProcessId() + "-" + KanBanProcessTypeEnum.INSPECTION.getType()
                  );
                  if (inspectionKanBanProcessDTO != null) {
                     inspectionKanBanProcessDTO.setTotalReportQuantity(inspectionKanBanProcessDTO.getTotalReportQuantity() + taskProcess.getCompleteQuantity());
                     inspectionKanBanProcessDTO.setTotalInspectionQuantity(
                        inspectionKanBanProcessDTO.getTotalInspectionQuantity() + taskProcess.getInspectionQuantity()
                     );
                  }
               }

               List<MesBuildingComplete> completes = completeMap.get(artifactTaskId);
               ProjectProductionKanBanProcessDTO artifactCargoBleKanBanProcessDTO = ProjectProductionKanBanProcessDTO.builder()
                  .artifactTaskId(artifactTaskId)
                  .processId(-1L)
                  .netWeight(artifactMap.get(taskProcessByOne.getProductId()).getNetWeight())
                  .totalTaskQuantity(taskProcessByOne.getTaskQuantity())
                  .totalReportQuantity(0)
                  .totalNeedQuantity(0)
                  .processType(KanBanProcessTypeEnum.CARGO.getType())
                  .processName("发运")
                  .productType(ProductTypeEnum.ARTIFACT.getType())
                  .orderNumber(taskOrderMap.get(taskProcessByOne.getTaskOrderId()).getOrderNumber())
                  .build();
               if (CollectionUtils.isNotEmpty(completes)) {
                  artifactCargoBleKanBanProcessDTO.setTotalNeedQuantity(completes.size());
                  List<MesBuildingWarehouseRecord> mesBuildingCargoListProductNumberLinks = warehouseOutRecordMap.get(completes.get(0).getProductId());
                  if (CollectionUtils.isNotEmpty(mesBuildingCargoListProductNumberLinks)) {
                     List<Integer> artifactNumbers = completes.stream().map(MesBuildingComplete::getNumber).distinct().collect(Collectors.toList());
                     artifactCargoBleKanBanProcessDTO.setTotalReportQuantity(
                        (int)mesBuildingCargoListProductNumberLinks.stream().filter(e -> artifactNumbers.contains(e.getNumber())).count()
                     );
                  }
               }

               productionKanBanProcessDTOMap.put(artifactTaskId + "-" + -1 + "-" + KanBanProcessTypeEnum.CARGO.getType(), artifactCargoBleKanBanProcessDTO);
            }
         );
      }
   }

   private void buildingTaskAssemble(
      List<Long> artifactTaskIds,
      Map<String, ProjectProductionKanBanProcessDTO> productionKanBanProcessDTOMap,
      Map<String, List<MesInspectConfigBasicDTO>> configBasicDTOMap,
      Map<Long, MesBuildingProcess> processMap,
      Map<Long, List<MesInspectConfigUserLink>> inspectConfigUserLinkMap,
      Map<Long, User> userMap
   ) {
      List<MesBuildingTaskNumberLink> mesBuildingTaskNumberLinks = this.taskNumberLinkService
         .list(
            (Wrapper<MesBuildingTaskNumberLink>)(new LambdaQueryWrapper<MesBuildingTaskNumberLink>().in(MesBuildingTaskNumberLink::getArtifactTaskId, artifactTaskIds))
               .isNotNull(MesBuildingTaskNumberLink::getAssembleTaskId)
         );
      if (CollectionUtils.isNotEmpty(mesBuildingTaskNumberLinks)) {
         List<Long> assIds = mesBuildingTaskNumberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleId).distinct().collect(Collectors.toList());
         Map<Long, TechAssemble> assembleMap = new HashMap<>();
         if (CollectionUtils.isNotEmpty(assIds)) {
            assembleMap = this.assembleService.listByIds(assIds).stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
         }

         List<MesBuildingTaskProcess> taskProcesses = this.taskProcessService
            .list(
               (Wrapper<MesBuildingTaskProcess>)new LambdaQueryWrapper<MesBuildingTaskProcess>()
                  .in(
                     MesBuildingTaskProcess::getTaskId,
                     mesBuildingTaskNumberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleTaskId).distinct().collect(Collectors.toList())
                  )
            );
         if (CollectionUtils.isNotEmpty(taskProcesses)) {
            Map<Long, List<MesBuildingProduceInspectionTeamReport>> inspectionTeamReportMap = this.produceInspectionTeamReportService
               .list(
                  (Wrapper<MesBuildingProduceInspectionTeamReport>)new LambdaQueryWrapper<MesBuildingProduceInspectionTeamReport>()
                     .in(
                        MesBuildingProduceInspectionTeamReport::getTaskProcessId,
                        taskProcesses.stream().map(MesBuildingTaskProcess::getId).collect(Collectors.toList())
                     )
               )
               .stream()
               .collect(Collectors.groupingBy(MesBuildingProduceInspectionTeamReport::getTaskProcessId));
            Map<Long, List<MesBuildingTaskProcess>> assembleTaskProcessMap = taskProcesses.stream()
               .collect(Collectors.groupingBy(MesBuildingTaskProcess::getTaskId));
            Map<Long, MesBuildingTaskOrder> taskOrderMap = this.taskOrderService
               .listByIds(taskProcesses.stream().map(MesBuildingTaskProcess::getTaskOrderId).collect(Collectors.toList()))
               .stream()
               .collect(Collectors.toMap(MesBuildingTaskOrder::getId, Function.identity()));
            Map<Long, List<MesBuildingAssist>> assembleAssistMap = this.assistService
               .list(
                  (Wrapper<MesBuildingAssist>)new LambdaQueryWrapper<MesBuildingAssist>()
                     .in(MesBuildingAssist::getTaskProcessId, taskProcesses.stream().map(MesBuildingTaskProcess::getId).collect(Collectors.toList()))
               )
               .stream()
               .collect(Collectors.groupingBy(MesBuildingAssist::getTaskProcessId));
            LambdaQueryWrapper<MesBuildingProduceTeamReport> teamReportQueryWrapper = Wrappers.<MesBuildingProduceTeamReport>lambdaQuery();

            for (MesBuildingTaskNumberLink taskNumberLink : mesBuildingTaskNumberLinks) {
               if (teamReportQueryWrapper.isEmptyOfNormal()) {
                  teamReportQueryWrapper.eq(MesBuildingProduceTeamReport::getTaskId, taskNumberLink.getAssembleTaskId());
                  teamReportQueryWrapper.in(MesBuildingProduceTeamReport::getNumber, taskNumberLink.getAssembleNumber());
               } else {
                  teamReportQueryWrapper.or(
                     subQuery -> {
                        LambdaQueryWrapper var10000 = subQuery.eq(MesBuildingProduceTeamReport::getTaskId, taskNumberLink.getAssembleTaskId())
                           .in(MesBuildingProduceTeamReport::getNumber, taskNumberLink.getAssembleNumber());
                     }
                  );
               }
            }

            Map<String, List<MesBuildingProduceTeamReport>> produceTeamReportMap = this.produceTeamReportService
               .list(teamReportQueryWrapper)
               .stream()
               .collect(Collectors.groupingBy(e -> e.getTaskId() + "-" + e.getNumber()));
            Map<Long, List<MesBuildingTaskNumberLink>> artifactTaskNumberLinkMap = mesBuildingTaskNumberLinks.stream()
               .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactTaskId));
            Map<Long, TechAssemble> finalAssembleMap = assembleMap;
            artifactTaskNumberLinkMap.forEach(
               (artifactTaskId, taskNumberLinks) -> {
                  Map<Long, List<MesBuildingTaskNumberLink>> taskNumberLinkMap = taskNumberLinks.stream()
                     .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getAssembleTaskId));
                  taskNumberLinkMap.forEach(
                     (assembleTaskId, taskNumberLinkx) -> {
                        List<MesBuildingTaskProcess> mesBuildingTaskProcesses = assembleTaskProcessMap.get(assembleTaskId);
                        if (CollectionUtils.isNotEmpty(mesBuildingTaskProcesses)) {
                           BigDecimal assembleNetWeight = finalAssembleMap.get(((MesBuildingTaskNumberLink)taskNumberLinkx.get(0)).getAssembleId()) == null
                              ? BigDecimal.ZERO
                              : finalAssembleMap.get(((MesBuildingTaskNumberLink)taskNumberLinkx.get(0)).getAssembleId()).getNetWeight();
                           List<Integer> assembleNumberList = taskNumberLinkx.stream()
                              .map(MesBuildingTaskNumberLink::getAssembleNumber)
                              .distinct()
                              .collect(Collectors.toList());

                           for (MesBuildingTaskProcess mesBuildingTaskProcess : mesBuildingTaskProcesses) {
                              ProjectProductionKanBanProcessDTO kanBanProcessDTO = productionKanBanProcessDTOMap.get(
                                 artifactTaskId + "-" + mesBuildingTaskProcess.getProcessId() + "-" + KanBanProcessTypeEnum.REPORT.getType()
                              );
                              if (kanBanProcessDTO == null) {
                                 ProjectProductionKanBanProcessDTO assembleKanBanProcessDTO = ProjectProductionKanBanProcessDTO.builder()
                                    .artifactTaskId(artifactTaskId)
                                    .productId(((MesBuildingTaskNumberLink)taskNumberLinkx.get(0)).getAssembleId())
                                    .netWeight(assembleNetWeight)
                                    .productType(ProductTypeEnum.ASSEMBLE.getType())
                                    .processId(mesBuildingTaskProcess.getProcessId())
                                    .totalTaskQuantity(assembleNumberList.size())
                                    .totalReportQuantity(0)
                                    .totalInspectionQuantity(0)
                                    .processType(KanBanProcessTypeEnum.REPORT.getType())
                                    .processName(processMap.get(mesBuildingTaskProcess.getProcessId()).getName())
                                    .orderNumber(taskOrderMap.get(mesBuildingTaskProcess.getTaskOrderId()).getOrderNumber())
                                    .build();
                                 productionKanBanProcessDTOMap.put(
                                    artifactTaskId + "-" + mesBuildingTaskProcess.getProcessId() + "-" + KanBanProcessTypeEnum.REPORT.getType(),
                                    assembleKanBanProcessDTO
                                 );
                              } else {
                                 kanBanProcessDTO.setTotalTaskQuantity(kanBanProcessDTO.getTotalTaskQuantity() + assembleNumberList.size());
                              }

                              List<MesBuildingAssist> assistBuildingAssists = assembleAssistMap.get(mesBuildingTaskProcess.getId());
                              List<MesInspectConfigBasicDTO> mesInspectConfigBasicDTOList = configBasicDTOMap.get(
                                 mesBuildingTaskProcess.getProcessId()
                                    + "-"
                                    + mesBuildingTaskProcess.getTeamId()
                                    + "-"
                                    + finalAssembleMap.get(mesBuildingTaskProcess.getProductId()).getAssembleConfigId()
                              );
                              if (!mesBuildingTaskProcess.getTaskQuantity().equals(mesBuildingTaskProcess.getInspectionQuantity())
                                 || CollectionUtils.isNotEmpty(inspectionTeamReportMap.get(mesBuildingTaskProcess.getId()))) {
                                 ProjectProductionKanBanProcessDTO inspectionKanBanProcessDTO = productionKanBanProcessDTOMap.get(
                                    artifactTaskId + "-" + mesBuildingTaskProcess.getProcessId() + "-" + KanBanProcessTypeEnum.INSPECTION.getType()
                                 );
                                 if (inspectionKanBanProcessDTO == null) {
                                    ProjectProductionKanBanProcessDTO artifactBleKanBanProcessDTO = ProjectProductionKanBanProcessDTO.builder()
                                       .artifactTaskId(artifactTaskId)
                                       .processId(mesBuildingTaskProcess.getProcessId())
                                       .totalTaskQuantity(assembleNumberList.size())
                                       .totalReportQuantity(0)
                                       .totalInspectionQuantity(0)
                                       .processType(KanBanProcessTypeEnum.INSPECTION.getType())
                                       .processName(processMap.get(mesBuildingTaskProcess.getProcessId()).getName() + "质检")
                                       .productType(ProductTypeEnum.ASSEMBLE.getType())
                                       .orderNumber(taskOrderMap.get(mesBuildingTaskProcess.getTaskOrderId()).getOrderNumber())
                                       .build();
                                    Set<String> userNames = new HashSet<>();
                                    int assistSum = CollectionUtils.isEmpty(assistBuildingAssists)
                                       ? 0
                                       : assistBuildingAssists.stream().mapToInt(MesBuildingAssist::getQuantity).sum();
                                    if (CollectionUtils.isNotEmpty(mesInspectConfigBasicDTOList)
                                       && !mesBuildingTaskProcess.getTaskQuantity().equals(mesBuildingTaskProcess.getInspectionQuantity())
                                       && mesBuildingTaskProcess.getTaskQuantity() > assistSum) {
                                       for (MesInspectConfigBasicDTO mesInspectConfigBasicDTO : mesInspectConfigBasicDTOList) {
                                          for (MesInspectConfigUserLink inspectConfigUserLink : inspectConfigUserLinkMap.get(mesInspectConfigBasicDTO.getId())) {
                                             String name = userMap.get(inspectConfigUserLink.getInspectUserId()).getName();
                                             userNames.add(name);
                                          }
                                       }
                                    }

                                    if (CollectionUtils.isNotEmpty(inspectionTeamReportMap.get(mesBuildingTaskProcess.getId()))) {
                                       List<MesBuildingProduceInspectionTeamReport> inspectionTeamReports = inspectionTeamReportMap.get(
                                          mesBuildingTaskProcess.getId()
                                       );
                                       inspectionTeamReports.forEach(
                                          e -> userNames.add(userMap.get(e.getUserId()) == null ? "超级管理员" : userMap.get(e.getUserId()).getName())
                                       );
                                    }

                                    if (!mesBuildingTaskProcess.getTaskQuantity().equals(mesBuildingTaskProcess.getInspectionQuantity()) && assistSum > 0) {
                                       for (MesBuildingAssist assist : assistBuildingAssists) {
                                          List<MesInspectConfigBasicDTO> assistInspectConfigBasicDTOList = configBasicDTOMap.get(
                                             mesBuildingTaskProcess.getProcessId()
                                                + "-"
                                                + assist.getTeamId()
                                                + "-"
                                                + finalAssembleMap.get(mesBuildingTaskProcess.getProductId()).getAssembleConfigId()
                                          );
                                          if (CollectionUtils.isNotEmpty(assistInspectConfigBasicDTOList)) {
                                             for (MesInspectConfigBasicDTO mesInspectConfigBasicDTO : assistInspectConfigBasicDTOList) {
                                                for (MesInspectConfigUserLink inspectConfigUserLink : inspectConfigUserLinkMap.get(
                                                   mesInspectConfigBasicDTO.getId()
                                                )) {
                                                   String name = userMap.get(inspectConfigUserLink.getInspectUserId()).getName();
                                                   userNames.add(name);
                                                }
                                             }
                                          }
                                       }
                                    }

                                    artifactBleKanBanProcessDTO.setInspectionUserName(StringUtils.join(userNames.toArray(), ","));
                                    productionKanBanProcessDTOMap.put(
                                       artifactTaskId + "-" + mesBuildingTaskProcess.getProcessId() + "-" + KanBanProcessTypeEnum.INSPECTION.getType(),
                                       artifactBleKanBanProcessDTO
                                    );
                                 } else {
                                    inspectionKanBanProcessDTO.setTotalTaskQuantity(
                                       inspectionKanBanProcessDTO.getTotalTaskQuantity() + assembleNumberList.size()
                                    );
                                 }
                              }
                           }
                        }
                     }
                  );
                  List<MesBuildingProduceTeamReport> produceTeamReportList = new ArrayList<>();

                  for (MesBuildingTaskNumberLink taskNumberLink : taskNumberLinks) {
                     List<MesBuildingProduceTeamReport> produceTeamReports = produceTeamReportMap.get(
                        taskNumberLink.getAssembleTaskId() + "-" + taskNumberLink.getAssembleNumber()
                     );
                     if (CollectionUtils.isNotEmpty(produceTeamReports)) {
                        produceTeamReportList.addAll(produceTeamReports);
                     }
                  }

                  if (CollectionUtils.isNotEmpty(produceTeamReportList)) {
                     Map<Long, List<MesBuildingProduceTeamReport>> processProduceTeamReportMap = produceTeamReportList.stream()
                        .collect(Collectors.groupingBy(MesBuildingProduceTeamReport::getProcessId));
                     processProduceTeamReportMap.forEach(
                        (processId, teamReports) -> {
                           ProjectProductionKanBanProcessDTO projectProductionKanBanProcessDTO = productionKanBanProcessDTOMap.get(
                              artifactTaskId + "-" + processId + "-" + KanBanProcessTypeEnum.REPORT.getType()
                           );
                           if (projectProductionKanBanProcessDTO != null) {
                              int totalReportQuantity = produceTeamReportList.stream()
                                 .filter(e -> e.getProcessId().equals(processId))
                                 .mapToInt(MesBuildingProduceTeamReport::getQuantity)
                                 .sum();
                              projectProductionKanBanProcessDTO.setTotalReportQuantity(
                                 projectProductionKanBanProcessDTO.getTotalReportQuantity() + totalReportQuantity
                              );
                              projectProductionKanBanProcessDTO.setTotalInspectionQuantity(
                                 projectProductionKanBanProcessDTO.getTotalInspectionQuantity()
                                    + produceTeamReportList.stream()
                                       .filter(e -> e.getProcessId().equals(processId))
                                       .mapToInt(MesBuildingProduceTeamReport::getInspectionQuantity)
                                       .sum()
                              );
                           }

                           ProjectProductionKanBanProcessDTO inspectionKanBanProcessDTO = productionKanBanProcessDTOMap.get(
                              artifactTaskId + "-" + processId + "-" + KanBanProcessTypeEnum.INSPECTION.getType()
                           );
                           if (inspectionKanBanProcessDTO != null) {
                              int totalInspectionQuantity = produceTeamReportList.stream()
                                 .filter(e -> e.getProcessId().equals(processId))
                                 .mapToInt(MesBuildingProduceTeamReport::getInspectionQuantity)
                                 .sum();
                              int totalInspectionReportQuantity = produceTeamReportList.stream()
                                 .filter(e -> e.getProcessId().equals(processId))
                                 .mapToInt(MesBuildingProduceTeamReport::getQuantity)
                                 .sum();
                              inspectionKanBanProcessDTO.setTotalReportQuantity(
                                 inspectionKanBanProcessDTO.getTotalReportQuantity() + totalInspectionReportQuantity
                              );
                              inspectionKanBanProcessDTO.setTotalInspectionQuantity(
                                 inspectionKanBanProcessDTO.getTotalInspectionQuantity() + totalInspectionQuantity
                              );
                           }
                        }
                     );
                  }
               }
            );
         }
      }
   }

   private void buildingTaskPart(List<Long> artifactTaskIds, Map<String, ProjectProductionKanBanProcessDTO> productionKanBanProcessDTOMap) {
      Map<String, List<ProjectProductionKanBanProcessDTO>> KanBanProcessDTOListMap = new HashMap<>();
      List<MesBuildingTaskNeedMachinePartScheduling> needMachinePartSchedulingList = this.taskNeedMachinePartSchedulingService
         .list(
            (Wrapper<MesBuildingTaskNeedMachinePartScheduling>)new LambdaQueryWrapper<MesBuildingTaskNeedMachinePartScheduling>()
               .in(MesBuildingTaskNeedMachinePartScheduling::getTaskId, artifactTaskIds)
         );
      if (CollectionUtils.isNotEmpty(needMachinePartSchedulingList)) {
         Map<Long, List<MesBuildingTaskNeedMachinePartScheduling>> taskNeedMachinePartSchedulingMap = needMachinePartSchedulingList.stream()
            .collect(Collectors.groupingBy(MesBuildingTaskNeedMachinePartScheduling::getTaskId));
         taskNeedMachinePartSchedulingMap.forEach(
            (artifactTaskId, needMachinePartSchedulings) -> {
               List<ProjectProductionKanBanProcessDTO> processDTOS = new ArrayList<>();

               for (MesBuildingTaskNeedMachinePartScheduling needMachinePartScheduling : needMachinePartSchedulings) {
                  ProjectProductionKanBanProcessDTO assembleKanBanProcessDTO = ProjectProductionKanBanProcessDTO.builder()
                     .artifactTaskId(artifactTaskId)
                     .processId(0L)
                     .productType(ProductTypeEnum.MACHINE_PART.getType())
                     .totalTaskQuantity(needMachinePartScheduling.getNeedQuantity())
                     .totalReportQuantity(0)
                     .processType(KanBanProcessTypeEnum.REPORT.getType())
                     .processName("零件")
                     .productId(needMachinePartScheduling.getProductId())
                     .build();
                  processDTOS.add(assembleKanBanProcessDTO);
               }

               KanBanProcessDTOListMap.put(artifactTaskId + "-" + 0L, processDTOS);
            }
         );
         List<ProjectKanBanIdAndQuantityDTO> artifactTaskAndPartTask = this.taskService.findArtifactTaskAndPartTask(artifactTaskIds);
         if (CollectionUtils.isNotEmpty(artifactTaskAndPartTask)) {
            Map<Long, List<ProjectKanBanIdAndQuantityDTO>> artifactTaskAndPartTaskMap = artifactTaskAndPartTask.stream()
               .collect(Collectors.groupingBy(ProjectKanBanIdAndQuantityDTO::getArtifactTaskId));
            artifactTaskAndPartTaskMap.forEach(
               (artifactTaskId, artifactTaskAndPartTasks) -> {
                  List<ProjectProductionKanBanProcessDTO> processDTOS = KanBanProcessDTOListMap.get(artifactTaskId + "-" + 0L);
                  int totalReportQuantity = 0;
                  if (CollectionUtils.isNotEmpty(processDTOS)) {
                     Map<Long, ProjectKanBanIdAndQuantityDTO> banIdAndQuantityDTOMap = artifactTaskAndPartTasks.stream()
                        .collect(Collectors.toMap(ProjectKanBanIdAndQuantityDTO::getProductId, Function.identity()));

                     for (ProjectProductionKanBanProcessDTO processDTO : processDTOS) {
                        ProjectKanBanIdAndQuantityDTO dto = banIdAndQuantityDTOMap.get(processDTO.getProductId());
                        if (dto != null) {
                           if (dto.getTotalCompleteQuantity() > processDTO.getTotalTaskQuantity()) {
                              totalReportQuantity += processDTO.getTotalTaskQuantity();
                           } else {
                              totalReportQuantity += dto.getTotalCompleteQuantity();
                           }
                        }
                     }

                     ProjectProductionKanBanProcessDTO projectProductionKanBanProcessDTO = processDTOS.get(0);
                     projectProductionKanBanProcessDTO.setTotalTaskQuantity(
                        processDTOS.stream().mapToInt(ProjectProductionKanBanProcessDTO::getTotalTaskQuantity).sum()
                     );
                     projectProductionKanBanProcessDTO.setTotalReportQuantity(totalReportQuantity);
                     projectProductionKanBanProcessDTO.setNetWeight(artifactTaskAndPartTask.get(0).getNetWeight());
                     productionKanBanProcessDTOMap.put(artifactTaskId + "-" + 0L, projectProductionKanBanProcessDTO);
                  }
               }
            );
         }
      }
   }
}
