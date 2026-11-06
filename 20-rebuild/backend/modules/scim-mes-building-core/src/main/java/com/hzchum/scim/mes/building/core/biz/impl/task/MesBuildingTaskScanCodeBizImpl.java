package com.hzchum.scim.mes.building.core.biz.impl.task;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.bim.core.api.enums.BimImportModeEnum;
import com.hzchum.scim.bim.core.api.enums.BimModelTypeEnum;
import com.hzchum.scim.bim.core.api.enums.BimStatusCommonEnum;
import com.hzchum.scim.bim.core.api.pojo._do.BimModelCommonDO;
import com.hzchum.scim.bim.core.api.pojo._do.BimModelConfigurationDO;
import com.hzchum.scim.bim.core.api.service.BimModelCommonService;
import com.hzchum.scim.bim.core.api.service.BimModelConfigurationService;
import com.hzchum.scim.common.core.api.enums.CodingTypeEnum;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskScanCodeBiz;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.cargoList.CargoListStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoList;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoListProductNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingMachinePartSchedulingLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingComplete;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingMachinePartSchedulingArtifactTaskLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceInspectionTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._dto.product.ArtifactTaskDetailBaseInfo;
import com.hzchum.scim.mes.building.core.api.pojo._dto.product.ArtifactTaskMarkingBaseInfo;
import com.hzchum.scim.mes.building.core.api.pojo._dto.product.ScanCodeProductTaskInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.product.ScanCodeProductTaskInfoDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.product.ScanCodeProductTaskInfoV3DTO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.task.TraceConfigItemVO;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListProductLinkService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListProductNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingMachinePartSchedulingLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingMachinePartSchedulingArtifactTaskLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceInspectionTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskOrderService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureProductionLine;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.process.MesEnclosureProcess;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureProduceTeamReport;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.task.MesEnclosureTask;
import com.hzchum.scim.mes.enclosure.core.api.service.factory.MesEnclosureProductionLineService;
import com.hzchum.scim.mes.enclosure.core.api.service.process.MesEnclosureProcessService;
import com.hzchum.scim.mes.enclosure.core.api.service.task.MesEnclosureProduceTeamReportService;
import com.hzchum.scim.mes.enclosure.core.api.service.task.MesEnclosureTaskService;
import com.hzchum.scim.plan.core.api.enums.BuildingTypeEnum;
import com.hzchum.scim.plan.core.api.enums.DrawingProductTypeEnum;
import com.hzchum.scim.plan.core.api.enums.TechDataTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactExt;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleDetail;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleExt;
import com.hzchum.scim.plan.core.api.pojo._do.TechDrawing;
import com.hzchum.scim.plan.core.api.pojo._do.TechEnclosure;
import com.hzchum.scim.plan.core.api.pojo.dto.DrawingAndSerialNumberDTO;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactExtService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleDetailService;
import com.hzchum.scim.plan.core.api.service.TechAssembleExtService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechDrawingService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.system.core.api.pojo._do.TraceConfigItem;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.TraceConfigItemService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingTaskScanCodeBizImpl implements MesBuildingTaskScanCodeBiz {
   @Resource
   private MesBuildingTaskService taskService;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private TechAssembleService assembleService;
   @Resource
   private TechAssembleExtService assembleExtService;
   @Resource
   private TechArtifactExtService artifactExtService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private PlanMonomerService monomerService;
   @Resource
   private PlanAreaService areaService;
   @Resource
   private TechDrawingService drawingService;
   @Resource
   private MesBuildingWorkshopService workshopService;
   @Resource
   private MesBuildingProductionLineService productionLineService;
   @Resource
   private MesEnclosureProductionLineService enclosureProductionLineService;
   @Resource
   private MesBuildingTaskProcessService taskProcessService;
   @Resource
   private MesBuildingCargoListProductNumberLinkService productNumberLinkService;
   @Resource
   private MesBuildingCargoListProductLinkService cargoListProductLinkService;
   @Resource
   private MesBuildingCompleteService completeService;
   @Resource
   private MesBuildingCargoListService cargoListService;
   @Resource
   private MesBuildingMachinePartSchedulingArtifactTaskLinkService partSchedulingArtifactTaskLinkService;
   @Resource
   private MesBuildingMachinePartSchedulingLinkService partSchedulingLinkService;
   @Resource
   private MesBuildingProduceTeamReportService produceTeamReportService;
   @Resource
   private MesEnclosureProduceTeamReportService enclosureProduceTeamReportService;
   @Resource
   private MesBuildingProcessService processService;
   @Resource
   private MesEnclosureProcessService enclosureProcessService;
   @Resource
   private MesBuildingProduceInspectionTeamReportService inspectionTeamReportService;
   @Resource
   private UserService userService;
   @Resource
   private MesBuildingTaskNumberLinkService taskNumberLinkService;
   @Resource
   private TechAssembleDetailService assembleDetailService;
   @Resource
   private MesEnclosureTaskService enclosureTaskService;
   @Resource
   private TechEnclosureService enclosureService;
   @Resource
   private MesBuildingTaskOrderService taskOrderService;
   @Resource
   private TraceConfigItemService configItemService;
   @Resource
   private BimModelConfigurationService bimModelConfigurationService;
   @Resource
   private BimModelCommonService bimModelCommonService;

   @Override
   public ScanCodeProductTaskInfoDTO getProductTaskV2(Long taskId, Long productId, Integer productType, Integer number) {
      ScanCodeProductTaskInfoDTO productTaskInfoDTO = null;
      if (taskId == null && productId == null) {
         throw new IllegalArgumentException("查询失败,参数有误!");
      }

      if (taskId == null) {
         Preconditions.checkArgument(productType != null, "查询失败,参数有误!");
         if (ProductTypeEnum.ARTIFACT.getType().equals(productType)) {
            List<MesBuildingTaskNumberLink> mesBuildingTaskNumberLinks = this.taskNumberLinkService
               .list(
                  (new LambdaQueryWrapper<MesBuildingTaskNumberLink>().eq(MesBuildingTaskNumberLink::getArtifactId, productId))
                     .eq(number != null, MesBuildingTaskNumberLink::getArtifactNumber, number)
               );
            if (CollectionUtils.isEmpty(mesBuildingTaskNumberLinks)) {
               return productTaskInfoDTO;
            }

            if (CollectionUtils.isNotEmpty(mesBuildingTaskNumberLinks)) {
               taskId = mesBuildingTaskNumberLinks.get(0).getArtifactTaskId();
            }
         }

         if (ProductTypeEnum.ASSEMBLE.getType().equals(productType)) {
            List<MesBuildingTaskNumberLink> mesBuildingTaskNumberLinks = this.taskNumberLinkService
               .list(
                  (new LambdaQueryWrapper<MesBuildingTaskNumberLink>().eq(MesBuildingTaskNumberLink::getAssembleId, productId))
                     .eq(number != null, MesBuildingTaskNumberLink::getAssembleNumber, number)
               );
            if (CollectionUtils.isEmpty(mesBuildingTaskNumberLinks)) {
               return productTaskInfoDTO;
            }

            if (CollectionUtils.isNotEmpty(mesBuildingTaskNumberLinks)) {
               taskId = mesBuildingTaskNumberLinks.get(0).getAssembleTaskId();
            }
         }
      }

      MesBuildingTask task = null;
      MesEnclosureTask enclosureTask = null;
      if (productType != null && ProductTypeEnum.ENCLOSURE.getType().equals(productType)) {
         enclosureTask = this.enclosureTaskService.getOne((Wrapper<MesEnclosureTask>)new LambdaQueryWrapper<MesEnclosureTask>().eq(MesEnclosureTask::getProductId, productId));
         Preconditions.checkArgument(enclosureTask != null, "查询失败,产品任务不存在!");
         taskId = enclosureTask.getId();
      } else {
         task = this.taskService.getById(taskId);
         Preconditions.checkArgument(task != null, "查询失败,产品任务不存在!");
      }

      if (task != null && TaskTypeEnum.ARTIFACT.getType().equals(task.getTaskTypeEnum())) {
         productTaskInfoDTO = this.getArtifactScanCodeProductTaskInfoDTO(taskId, number, task);
      }

      if (task != null && TaskTypeEnum.ASSEMBLE.getType().equals(task.getTaskTypeEnum())) {
         productTaskInfoDTO = this.getAssembleScanCodeProductTaskInfoDTO(taskId, number, task);
      }

      if (enclosureTask != null) {
         productTaskInfoDTO = this.getEnclosureScanCodeProductTaskInfoDTO(taskId, number, enclosureTask);
      }

      if (productTaskInfoDTO != null) {
         List<TraceConfigItem> configItemList = this.configItemService
            .list(
               (Wrapper<TraceConfigItem>)(new LambdaQueryWrapper<TraceConfigItem>().eq(TraceConfigItem::getEnableFlag, Boolean.TRUE))
                  .apply("find_in_set({0}, display_project)", productTaskInfoDTO.getProject().getId())
            );
         List<TraceConfigItem> configItems = this.configItemService
            .list(
               (Wrapper<TraceConfigItem>)(new LambdaQueryWrapper<TraceConfigItem>().eq(TraceConfigItem::getEnableFlag, Boolean.TRUE))
                  .and(
                     w -> {
                        LambdaQueryWrapper var10000 = ((w.isNull(TraceConfigItem::getDisplayProject))
                              .or())
                           .eq(TraceConfigItem::getDisplayProject, "");
                     }
                  )
            );
         List<TraceConfigItemVO> voList = Stream.of(configItemList, configItems)
            .filter(CollectionUtils::isNotEmpty)
            .flatMap(Collection::stream)
            .map(item -> BeanUtil.copy(item, TraceConfigItemVO.class))
            .collect(Collectors.toList());
         productTaskInfoDTO.setConfigItemVOList(voList);
      }

      return productTaskInfoDTO;
   }

   @Override
   public ScanCodeProductTaskInfoV3DTO getProductTaskV3(Long taskId, Long productId, Integer productType, Integer number) {
      ScanCodeProductTaskInfoV3DTO taskInfoV3DTO = new ScanCodeProductTaskInfoV3DTO();
      if ((productType == null || ProductTypeEnum.ARTIFACT.getType().equals(productType) || ProductTypeEnum.ASSEMBLE.getType().equals(productType))
         && taskId != null) {
         MesBuildingTask task = this.taskService.getById(taskId);
         Preconditions.checkArgument(task != null, "任务不存在!");
         taskInfoV3DTO = ScanCodeProductTaskInfoV3DTO.builder()
            .taskId(task.getId())
            .productId(task.getProductId())
            .number(number)
            .productType(task.getTaskTypeEnum())
            .build();
      }

      return taskInfoV3DTO;
   }

   @Override
   public ArtifactTaskMarkingBaseInfo getArtifactMarkingTask(Long productId) {
      TechArtifact artifact = this.artifactService.getById(productId);
      if (artifact == null) {
         return new ArtifactTaskMarkingBaseInfo();
      }

      ArtifactTaskMarkingBaseInfo result = BeanUtil.copy(artifact, ArtifactTaskMarkingBaseInfo.class);
      result.setBoolOneCode(artifact.getCodingType().equals(CodingTypeEnum.SINGLE.getType()));
      if (!result.getBoolOneCode()) {
         List<MesBuildingTask> tasks = this.taskService
            .list(
               (Wrapper<MesBuildingTask>)(new LambdaQueryWrapper<MesBuildingTask>().eq(MesBuildingTask::getProductId, productId))
                  .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
            );
         List<ArtifactTaskDetailBaseInfo> taskDetailBaseInfoArrayList = new ArrayList<>();
         if (CollectionUtils.isNotEmpty(tasks)) {
            Map<Long, List<MesBuildingTask>> taskMap = tasks.stream().collect(Collectors.groupingBy(MesBuildingTask::getTaskOrderId));
            taskMap.forEach((taskOrderId, taskList) -> {
               ArtifactTaskDetailBaseInfo artifactTaskDetailBaseInfo = new ArtifactTaskDetailBaseInfo();
               MesBuildingTask task = taskList.get(0);
               MesBuildingTaskOrder taskOrder = this.taskOrderService.getById(taskOrderId);
               artifactTaskDetailBaseInfo.setTaskId(task.getId());
               artifactTaskDetailBaseInfo.setOrderNumber(taskOrder.getOrderNumber());
               artifactTaskDetailBaseInfo.setSchedulingTime(task.getCreateTime());
               taskDetailBaseInfoArrayList.add(artifactTaskDetailBaseInfo);
            });
         }

         result.setTaskDetailBaseInfoList(taskDetailBaseInfoArrayList);
      }

      if (result.getBoolOneCode()) {
         List<MesBuildingTask> tasks = this.taskService
            .list(
               (Wrapper<MesBuildingTask>)(new LambdaQueryWrapper<MesBuildingTask>().eq(MesBuildingTask::getProductId, productId))
                  .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
            );
         List<ArtifactTaskDetailBaseInfo> taskDetailBaseInfoArrayList = new ArrayList<>();
         if (CollectionUtils.isNotEmpty(tasks)) {
            List<MesBuildingTaskNumberLink> mesBuildingTaskNumberLinks = this.taskNumberLinkService
               .list(
                  (Wrapper<MesBuildingTaskNumberLink>)new LambdaQueryWrapper<MesBuildingTaskNumberLink>()
                     .in(MesBuildingTaskNumberLink::getArtifactTaskId, tasks.stream().map(MesBuildingTask::getId).collect(Collectors.toList()))
               );
            Map<Long, List<MesBuildingTask>> taskMap = tasks.stream().collect(Collectors.groupingBy(MesBuildingTask::getTaskOrderId));
            Map<Long, List<MesBuildingTaskNumberLink>> artifactTaskNumberLinkMap = mesBuildingTaskNumberLinks.stream()
               .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactTaskId));
            taskMap.forEach(
               (taskOrderId, taskList) -> {
                  for (MesBuildingTask task : taskList) {
                     ArtifactTaskDetailBaseInfo artifactTaskDetailBaseInfo = new ArtifactTaskDetailBaseInfo();
                     MesBuildingTaskOrder taskOrder = this.taskOrderService.getById(taskOrderId);
                     artifactTaskDetailBaseInfo.setTaskId(task.getId());
                     artifactTaskDetailBaseInfo.setOrderNumber(taskOrder.getOrderNumber());
                     artifactTaskDetailBaseInfo.setSchedulingTime(task.getCreateTime());
                     List<MesBuildingTaskNumberLink> numberLinks = artifactTaskNumberLinkMap.get(task.getId());
                     artifactTaskDetailBaseInfo.setNumberList(
                        numberLinks.stream().map(MesBuildingTaskNumberLink::getArtifactNumber).distinct().collect(Collectors.toList())
                     );
                     taskDetailBaseInfoArrayList.add(artifactTaskDetailBaseInfo);
                  }
               }
            );
         }

         result.setTaskDetailBaseInfoList(taskDetailBaseInfoArrayList);
      }

      return result;
   }

   @Override
   public ArtifactTaskMarkingBaseInfo getAssembleMarkingTask(Long productId) {
      TechAssemble assemble = this.assembleService.getById(productId);
      if (assemble == null) {
         return new ArtifactTaskMarkingBaseInfo();
      }

      ArtifactTaskMarkingBaseInfo result = BeanUtil.copy(assemble, ArtifactTaskMarkingBaseInfo.class);
      List<MesBuildingTask> tasks = this.taskService
         .list(
            (Wrapper<MesBuildingTask>)(new LambdaQueryWrapper<MesBuildingTask>().eq(MesBuildingTask::getProductId, productId))
               .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ASSEMBLE.getType())
         );
      if (CollectionUtils.isEmpty(tasks)) {
         return result;
      }

      MesBuildingTask assembleTask = tasks.get(0);
      result.setBoolOneCode(assembleTask.getBoolOneCode());
      if (!result.getBoolOneCode()) {
         List<ArtifactTaskDetailBaseInfo> taskDetailBaseInfoArrayList = new ArrayList<>();
         if (CollectionUtils.isNotEmpty(tasks)) {
            Map<Long, List<MesBuildingTask>> taskMap = tasks.stream().collect(Collectors.groupingBy(MesBuildingTask::getTaskOrderId));
            taskMap.forEach((taskOrderId, taskList) -> {
               ArtifactTaskDetailBaseInfo artifactTaskDetailBaseInfo = new ArtifactTaskDetailBaseInfo();
               MesBuildingTask task = taskList.get(0);
               MesBuildingTaskOrder taskOrder = this.taskOrderService.getById(taskOrderId);
               artifactTaskDetailBaseInfo.setTaskId(task.getId());
               artifactTaskDetailBaseInfo.setOrderNumber(taskOrder.getOrderNumber());
               artifactTaskDetailBaseInfo.setSchedulingTime(task.getCreateTime());
               taskDetailBaseInfoArrayList.add(artifactTaskDetailBaseInfo);
            });
         }

         result.setTaskDetailBaseInfoList(taskDetailBaseInfoArrayList);
      }

      if (result.getBoolOneCode()) {
         List<ArtifactTaskDetailBaseInfo> taskDetailBaseInfoArrayList = new ArrayList<>();
         if (CollectionUtils.isNotEmpty(tasks)) {
            List<MesBuildingTaskNumberLink> mesBuildingTaskNumberLinks = this.taskNumberLinkService
               .list(
                  (Wrapper<MesBuildingTaskNumberLink>)new LambdaQueryWrapper<MesBuildingTaskNumberLink>()
                     .in(MesBuildingTaskNumberLink::getAssembleTaskId, tasks.stream().map(MesBuildingTask::getId).collect(Collectors.toList()))
               );
            Map<Long, List<MesBuildingTask>> taskMap = tasks.stream().collect(Collectors.groupingBy(MesBuildingTask::getTaskOrderId));
            Map<Long, List<MesBuildingTaskNumberLink>> artifactTaskNumberLinkMap = mesBuildingTaskNumberLinks.stream()
               .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getAssembleTaskId));
            taskMap.forEach(
               (taskOrderId, taskList) -> {
                  for (MesBuildingTask task : taskList) {
                     ArtifactTaskDetailBaseInfo artifactTaskDetailBaseInfo = new ArtifactTaskDetailBaseInfo();
                     MesBuildingTaskOrder taskOrder = this.taskOrderService.getById(taskOrderId);
                     artifactTaskDetailBaseInfo.setTaskId(task.getId());
                     artifactTaskDetailBaseInfo.setOrderNumber(taskOrder.getOrderNumber());
                     artifactTaskDetailBaseInfo.setSchedulingTime(task.getCreateTime());
                     List<MesBuildingTaskNumberLink> numberLinks = artifactTaskNumberLinkMap.get(task.getId());
                     artifactTaskDetailBaseInfo.setNumberList(
                        numberLinks.stream().map(MesBuildingTaskNumberLink::getArtifactNumber).distinct().collect(Collectors.toList())
                     );
                     taskDetailBaseInfoArrayList.add(artifactTaskDetailBaseInfo);
                  }
               }
            );
         }

         result.setTaskDetailBaseInfoList(taskDetailBaseInfoArrayList);
      }

      return result;
   }

   private ScanCodeProductTaskInfoDTO getArtifactScanCodeProductTaskInfoDTO(Long taskId, Integer number, MesBuildingTask task) {
      TechArtifact artifact = this.artifactService.getById(task.getProductId());
      Preconditions.checkArgument(artifact != null, "查询失败,构件清单不存在!");
      PlanMonomer monomer = this.monomerService.getById(artifact.getMonomerId());
      List<TechArtifactExt> artifactExtList = this.artifactExtService
         .list((Wrapper<TechArtifactExt>)new LambdaQueryWrapper<TechArtifactExt>().eq(TechArtifactExt::getArtifactId, artifact.getId()));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactExtList), "操作失败,产品码号不存在!");
      ScanCodeProductTaskInfoDTO artifactQrTaskInfoDTO = BeanUtil.copy(artifact, ScanCodeProductTaskInfoDTO.class);
      artifactQrTaskInfoDTO.setProject(this.projectService.getSimpleById(artifact.getProjectId()));
      artifactQrTaskInfoDTO.setMonomer(this.monomerService.getSimpleById(artifact.getMonomerId()));
      artifactQrTaskInfoDTO.setArea(this.areaService.getSimpleById(artifact.getAreaId()));
      artifactQrTaskInfoDTO.setProductType(ProductTypeEnum.ARTIFACT.getType());
      artifactQrTaskInfoDTO.setProductId(artifact.getId());
      artifactQrTaskInfoDTO.setBoolHavDrawing(Boolean.FALSE);
      artifactQrTaskInfoDTO.setBoolHavModel(Boolean.FALSE);

      try {
         BimModelConfigurationDO configurationDO = this.bimModelConfigurationService
            .getOne((Wrapper<BimModelConfigurationDO>)new LambdaQueryWrapper<BimModelConfigurationDO>().eq(BimModelConfigurationDO::getMonomerId, artifact.getMonomerId()));
         if (configurationDO != null) {
            List<String> elementIds = new ArrayList<>();
            if (configurationDO.getImportMode().equals(BimImportModeEnum.MONOMER_MODE.getType())) {
               BimModelCommonDO bimModelCommonDO = this.bimModelCommonService
                  .getOne(
                     (Wrapper<BimModelCommonDO>)(new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getMonomerId, artifact.getMonomerId()))
                        .eq(BimModelCommonDO::getTranslateStatus, BimStatusCommonEnum.SUCCESS.getName())
                  );
               if (bimModelCommonDO != null) {
                  elementIds = this.bimModelCommonService
                     .getArtifactElementIdList(bimModelCommonDO.getFileId().toString(), artifact.getSerialNumber(), BimModelTypeEnum.FILETYPE.getName());
               }
            }

            if (configurationDO.getImportMode().equals(BimImportModeEnum.INTEGRATION_MODE.getType())) {
               BimModelCommonDO bimModelCommonDO = this.bimModelCommonService
                  .getOne(
                     (Wrapper<BimModelCommonDO>)(new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getAreaId, artifact.getAreaId()))
                        .eq(BimModelCommonDO::getTranslateStatus, BimStatusCommonEnum.SUCCESS.getName())
                  );
               if (bimModelCommonDO != null) {
                  elementIds = this.bimModelCommonService
                     .getArtifactElementIdList(bimModelCommonDO.getFileId().toString(), artifact.getSerialNumber(), BimModelTypeEnum.FILETYPE.getName());
               }
            }

            if (CollectionUtils.isNotEmpty(elementIds)) {
               artifactQrTaskInfoDTO.setBoolHavModel(Boolean.TRUE);
               artifactQrTaskInfoDTO.setModelElementIds(elementIds);
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }

      Map<String, List<TechDrawing>> drawingListMap = this.drawingService
         .list(
            (Wrapper<TechDrawing>)(((new LambdaQueryWrapper<TechDrawing>()
                        .eq(TechDrawing::getDataType, TechDataTypeEnum.DEEPEN.getType()))
                     .eq(TechDrawing::getProductType, DrawingProductTypeEnum.ARTIFACT.getType()))
                  .eq(TechDrawing::getSerialNumber, artifact.getSerialNumber()))
               .eq(TechDrawing::getMonomerId, artifact.getMonomerId())
         )
         .stream()
         .collect(Collectors.groupingBy(TechDrawing::getSerialNumber));
      if (com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isNotEmpty(drawingListMap)) {
         artifactQrTaskInfoDTO.setNumbers(drawingListMap.get(artifact.getSerialNumber()).stream().map(TechDrawing::getNumber).collect(Collectors.toList()));
         artifactQrTaskInfoDTO.setDrawingAndSerialNumber(
            drawingListMap.get(artifact.getSerialNumber())
               .stream()
               .map(drawing -> BeanUtil.copy(drawing, DrawingAndSerialNumberDTO.class))
               .collect(Collectors.toList())
         );
         artifactQrTaskInfoDTO.setBoolHavDrawing(Boolean.TRUE);
      }

      MesBuildingWorkshop workshop = this.workshopService.getById(task.getWorkshopId());
      MesBuildingProductionLine productionLine = this.productionLineService.getById(task.getProductionLineId());
      if (workshop != null && productionLine != null) {
         artifactQrTaskInfoDTO.setWorkShopAndProdLineName(workshop.getName() + "-" + productionLine.getName());
      }

      MesBuildingCargoList cargoList = null;
      if (number != null) {
         List<MesBuildingCargoListProductNumberLink> cargoListProductNumberLinks = this.productNumberLinkService
            .list(
               (Wrapper<MesBuildingCargoListProductNumberLink>)(((new LambdaQueryWrapper<MesBuildingCargoListProductNumberLink>()
                           .eq(MesBuildingCargoListProductNumberLink::getProductId, task.getProductId()))
                        .eq(MesBuildingCargoListProductNumberLink::getNumber, number))
                     .eq(MesBuildingCargoListProductNumberLink::getProductType, task.getTaskTypeEnum()))
                  .eq(MesBuildingCargoListProductNumberLink::getBoolCancelShip, Boolean.FALSE)
            );
         if (CollectionUtils.isNotEmpty(cargoListProductNumberLinks)) {
            List<MesBuildingCargoList> cargoListList = this.cargoListService
               .list(
                  (Wrapper<MesBuildingCargoList>)(new LambdaQueryWrapper<MesBuildingCargoList>()
                        .in(MesBuildingCargoList::getStatus, CargoListStatusEnum.SHIPMENT.getType(), CargoListStatusEnum.RECEIPT.getType()))
                     .in(
                        MesBuildingCargoList::getId,
                        cargoListProductNumberLinks.stream().map(MesBuildingCargoListProductNumberLink::getCargoListId).collect(Collectors.toList())
                     )
               );
            if (CollectionUtils.isNotEmpty(cargoListList)) {
               cargoList = cargoListList.get(0);
            }
         }
      }

      if (number == null) {
         List<MesBuildingCargoListProductNumberLink> cargoListProductNumberLinks = this.productNumberLinkService
            .list(
               (Wrapper<MesBuildingCargoListProductNumberLink>)((new LambdaQueryWrapper<MesBuildingCargoListProductNumberLink>()
                        .eq(MesBuildingCargoListProductNumberLink::getProductId, task.getProductId()))
                     .eq(MesBuildingCargoListProductNumberLink::getProductType, task.getTaskTypeEnum()))
                  .eq(MesBuildingCargoListProductNumberLink::getBoolCancelShip, Boolean.FALSE)
            );
         if (CollectionUtils.isNotEmpty(cargoListProductNumberLinks)) {
            List<MesBuildingCargoList> cargoListList = this.cargoListService
               .list(
                  (Wrapper<MesBuildingCargoList>)(new LambdaQueryWrapper<MesBuildingCargoList>()
                        .in(MesBuildingCargoList::getStatus, CargoListStatusEnum.SHIPMENT.getType(), CargoListStatusEnum.RECEIPT.getType()))
                     .in(
                        MesBuildingCargoList::getId,
                        cargoListProductNumberLinks.stream().map(MesBuildingCargoListProductNumberLink::getCargoListId).collect(Collectors.toList())
                     )
               );
            if (CollectionUtils.isEmpty(cargoListList)) {
               number = cargoListProductNumberLinks.get(0).getNumber();
            } else {
               cargoList = cargoListList.get(0);
               MesBuildingCargoList finalCargoList = cargoList;
               number = cargoListProductNumberLinks.stream()
                  .filter(e -> finalCargoList.getId().equals(e.getCargoListId()))
                  .collect(Collectors.toList())
                  .get(0)
                  .getNumber();
            }
         }

         if (number == null) {
            List<MesBuildingComplete> completes = this.completeService
               .list((Wrapper<MesBuildingComplete>)new LambdaQueryWrapper<MesBuildingComplete>().eq(MesBuildingComplete::getTaskId, taskId));
            if (CollectionUtils.isNotEmpty(completes)) {
               number = completes.get(0).getNumber();
            }
         }

         if (number == null) {
            number = artifactExtList.get(0).getSortNumber();
         }
      }

      Integer finalNumber = number;
      List<TechArtifactExt> artifactExts = artifactExtList.stream().filter(e -> e.getSortNumber().equals(finalNumber)).collect(Collectors.toList());
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactExts) && artifactExts.size() == 1, "操作失败,产品码号不存在!");
      TechArtifactExt artifactExt = artifactExts.get(0);
      List<ScanCodeProductTaskInfoDetailDTO> taskInfoDetailDTOS = new ArrayList<>();
      Long assembleTaskId = null;
      Integer assembleNumber = null;
      List<TechAssembleDetail> assembleDetailList = this.assembleDetailService
         .list((Wrapper<TechAssembleDetail>)new LambdaQueryWrapper<TechAssembleDetail>().eq(TechAssembleDetail::getArtifactId, artifactExt.getArtifactId()));
      if (CollectionUtils.isNotEmpty(assembleDetailList)) {
         List<TechAssemble> allAssembles = this.assembleService
            .listByIds(assembleDetailList.stream().map(TechAssembleDetail::getAssembleId).collect(Collectors.toList()));
         List<TechAssemble> assembles = allAssembles.stream().filter(e -> e.getSpecPrefix().equals(artifact.getSpecPrefix())).collect(Collectors.toList());
         Long assembleId = CollectionUtils.isNotEmpty(assembles) ? assembles.get(0).getId() : allAssembles.get(0).getId();
         List<MesBuildingTaskNumberLink> mesBuildingTaskNumberLinks = this.taskNumberLinkService
            .list(
               (Wrapper<MesBuildingTaskNumberLink>)((new LambdaQueryWrapper<MesBuildingTaskNumberLink>()
                        .eq(MesBuildingTaskNumberLink::getArtifactTaskId, taskId))
                     .eq(MesBuildingTaskNumberLink::getArtifactNumber, artifactExt.getSortNumber()))
                  .eq(MesBuildingTaskNumberLink::getAssembleId, assembleId)
            );
         if (CollectionUtils.isNotEmpty(mesBuildingTaskNumberLinks)) {
            assembleTaskId = mesBuildingTaskNumberLinks.get(0).getAssembleTaskId();
            assembleNumber = mesBuildingTaskNumberLinks.get(0).getAssembleNumber();
         }
      }

      List<MesBuildingTaskProcess> taskProcesses = this.taskProcessService
         .list(
            (Wrapper<MesBuildingTaskProcess>)(new LambdaQueryWrapper<MesBuildingTaskProcess>().eq(MesBuildingTaskProcess::getTaskId, taskId))
               .gt(MesBuildingTaskProcess::getCompleteQuantity, 0)
         );
      List<MesBuildingTaskProcess> assembleTaskProcesses = new ArrayList<>();
      if (assembleTaskId != null) {
         assembleTaskProcesses = this.taskProcessService
            .list(
               (Wrapper<MesBuildingTaskProcess>)(new LambdaQueryWrapper<MesBuildingTaskProcess>().eq(MesBuildingTaskProcess::getTaskId, assembleTaskId))
                  .gt(MesBuildingTaskProcess::getCompleteQuantity, 0)
            );
      }

      if (CollectionUtils.isEmpty(taskProcesses) && CollectionUtils.isEmpty(assembleTaskProcesses)) {
         return artifactQrTaskInfoDTO;
      }

      ScanCodeProductTaskInfoDetailDTO drawingDeepeningDTO = ScanCodeProductTaskInfoDetailDTO.builder()
         .processName("图纸深化")
         .userName(artifactExt.getImportUserName())
         .inspectionOrReportingTime(artifactExt.getCreateTime())
         .boolInspection(Boolean.FALSE)
         .build();
      taskInfoDetailDTOS.add(drawingDeepeningDTO);
      List<MesBuildingMachinePartSchedulingArtifactTaskLink> partSchedulingArtifactTaskLinks = this.partSchedulingArtifactTaskLinkService
         .list(
            (Wrapper<MesBuildingMachinePartSchedulingArtifactTaskLink>)new LambdaQueryWrapper<MesBuildingMachinePartSchedulingArtifactTaskLink>()
               .eq(MesBuildingMachinePartSchedulingArtifactTaskLink::getTaskId, taskId)
         );
      if (CollectionUtils.isNotEmpty(partSchedulingArtifactTaskLinks)) {
         List<MesBuildingMachinePartSchedulingLink> partSchedulingLinks = this.partSchedulingLinkService
            .listByIds(
               partSchedulingArtifactTaskLinks.stream()
                  .map(MesBuildingMachinePartSchedulingArtifactTaskLink::getSchedulingLinkId)
                  .distinct()
                  .collect(Collectors.toList())
            );
         if (CollectionUtils.isNotEmpty(partSchedulingLinks)) {
            List<MesBuildingTask> taskList = this.taskService
               .list(
                  (Wrapper<MesBuildingTask>)((new LambdaQueryWrapper<MesBuildingTask>()
                           .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.MACHINE_PART.getType()))
                        .in(
                           MesBuildingTask::getMachinePartSchedulingId,
                           partSchedulingLinks.stream().map(MesBuildingMachinePartSchedulingLink::getSchedulingId).distinct().collect(Collectors.toList())
                        ))
                     .in(
                        MesBuildingTask::getProductId,
                        partSchedulingLinks.stream().map(MesBuildingMachinePartSchedulingLink::getProductId).distinct().collect(Collectors.toList())
                     )
               );
            if (CollectionUtils.isNotEmpty(taskList)) {
               List<MesBuildingTask> partTaskList = taskList.stream().filter(e -> e.getCompleteTime() != null).collect(Collectors.toList());
               if (CollectionUtils.isNotEmpty(partTaskList)) {
                  List<MesBuildingProduceTeamReport> produceTeamReportList = this.produceTeamReportService
                     .list(
                        (Wrapper<MesBuildingProduceTeamReport>)new LambdaQueryWrapper<MesBuildingProduceTeamReport>()
                           .eq(MesBuildingProduceTeamReport::getTaskId, partTaskList.get(0).getId())
                     );
                  if (CollectionUtils.isNotEmpty(produceTeamReportList)) {
                     User user = this.userService.getById(produceTeamReportList.get(0).getUserId());
                     taskInfoDetailDTOS.add(
                        ScanCodeProductTaskInfoDetailDTO.builder()
                           .processName("零件下料")
                           .userName(user == null ? "超管" : user.getName())
                           .inspectionOrReportingTime(partTaskList.get(0).getCompleteTime())
                           .boolInspection(Boolean.FALSE)
                           .build()
                     );
                  }
               }
            }
         }
      }

      if (CollectionUtils.isNotEmpty(assembleTaskProcesses) && !monomer.getBuildingTypeEnum().equals(BuildingTypeEnum.BRIDGE.getType())) {
         Map<Long, MesBuildingProcess> processMap = this.processService
            .listByIds(assembleTaskProcesses.stream().map(MesBuildingTaskProcess::getProcessId).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(MesBuildingProcess::getId, Function.identity()));
         assembleTaskProcesses = assembleTaskProcesses.stream().sorted(Comparator.comparing(MesBuildingTaskProcess::getSequence)).collect(Collectors.toList());
         Map<Long, MesBuildingProduceTeamReport> produceTeamReportMap = this.produceTeamReportService
            .list(
               (Wrapper<MesBuildingProduceTeamReport>)(new LambdaQueryWrapper<MesBuildingProduceTeamReport>().eq(MesBuildingProduceTeamReport::getTaskId, assembleTaskId))
                  .eq(MesBuildingProduceTeamReport::getNumber, assembleNumber)
            )
            .stream()
            .collect(Collectors.toMap(MesBuildingProduceTeamReport::getTaskProcessId, Function.identity()));
         Map<Long, MesBuildingProduceInspectionTeamReport> inspectionTeamReportMap = this.inspectionTeamReportService
            .list(
               (Wrapper<MesBuildingProduceInspectionTeamReport>)((new LambdaQueryWrapper<MesBuildingProduceInspectionTeamReport>()
                        .eq(MesBuildingProduceInspectionTeamReport::getTaskId, assembleTaskId))
                     .eq(MesBuildingProduceInspectionTeamReport::getBoolAdoptEnum, Boolean.TRUE))
                  .eq(MesBuildingProduceInspectionTeamReport::getNumber, assembleNumber)
            )
            .stream()
            .collect(Collectors.toMap(MesBuildingProduceInspectionTeamReport::getTaskProcessId, Function.identity()));

         for (MesBuildingTaskProcess taskProcess : assembleTaskProcesses) {
            MesBuildingProcess process = processMap.get(taskProcess.getProcessId());
            MesBuildingProduceTeamReport produceTeamReport = produceTeamReportMap.get(taskProcess.getId());
            if (produceTeamReport != null) {
               User user = this.userService.getById(produceTeamReport.getUserId());
               taskInfoDetailDTOS.add(
                  ScanCodeProductTaskInfoDetailDTO.builder()
                     .processName(process.getName())
                     .userName(user == null ? "超管" : user.getName())
                     .inspectionOrReportingTime(produceTeamReport.getCreateTime())
                     .boolInspection(Boolean.FALSE)
                     .build()
               );
            }

            MesBuildingProduceInspectionTeamReport inspectionTeamReport = inspectionTeamReportMap.get(taskProcess.getId());
            if (inspectionTeamReport != null) {
               User user = this.userService.getById(inspectionTeamReport.getUserId());
               taskInfoDetailDTOS.add(
                  ScanCodeProductTaskInfoDetailDTO.builder()
                     .processName(process.getName() + "质检")
                     .userName(user == null ? "超管" : user.getName())
                     .inspectionOrReportingTime(inspectionTeamReport.getCreateTime())
                     .boolInspection(Boolean.TRUE)
                     .build()
               );
            }
         }
      }

      if (CollectionUtils.isNotEmpty(taskProcesses)) {
         Map<Long, MesBuildingProcess> processMap = this.processService
            .listByIds(taskProcesses.stream().map(MesBuildingTaskProcess::getProcessId).collect(Collectors.toList()))
            .stream()
            .collect(Collectors.toMap(MesBuildingProcess::getId, Function.identity()));
         taskProcesses = taskProcesses.stream().sorted(Comparator.comparing(MesBuildingTaskProcess::getSequence)).collect(Collectors.toList());
         Map<Long, MesBuildingProduceTeamReport> produceTeamReportMap = this.produceTeamReportService
            .list(
               (Wrapper<MesBuildingProduceTeamReport>)(new LambdaQueryWrapper<MesBuildingProduceTeamReport>().eq(MesBuildingProduceTeamReport::getTaskId, taskId))
                  .eq(MesBuildingProduceTeamReport::getNumber, number)
            )
            .stream()
            .collect(Collectors.toMap(MesBuildingProduceTeamReport::getTaskProcessId, Function.identity()));
         Map<Long, MesBuildingProduceInspectionTeamReport> inspectionTeamReportMap = this.inspectionTeamReportService
            .list(
               (Wrapper<MesBuildingProduceInspectionTeamReport>)((new LambdaQueryWrapper<MesBuildingProduceInspectionTeamReport>()
                        .eq(MesBuildingProduceInspectionTeamReport::getTaskId, taskId))
                     .eq(MesBuildingProduceInspectionTeamReport::getBoolAdoptEnum, Boolean.TRUE))
                  .eq(MesBuildingProduceInspectionTeamReport::getNumber, number)
            )
            .stream()
            .collect(Collectors.toMap(MesBuildingProduceInspectionTeamReport::getTaskProcessId, Function.identity()));

         for (MesBuildingTaskProcess taskProcess : taskProcesses) {
            MesBuildingProcess process = processMap.get(taskProcess.getProcessId());
            MesBuildingProduceTeamReport produceTeamReport = produceTeamReportMap.get(taskProcess.getId());
            if (produceTeamReport != null) {
               User user = this.userService.getById(produceTeamReport.getUserId());
               taskInfoDetailDTOS.add(
                  ScanCodeProductTaskInfoDetailDTO.builder()
                     .processName(process.getName())
                     .userName(user == null ? "超管" : user.getName())
                     .inspectionOrReportingTime(produceTeamReport.getCreateTime())
                     .boolInspection(Boolean.FALSE)
                     .build()
               );
            }

            MesBuildingProduceInspectionTeamReport inspectionTeamReport = inspectionTeamReportMap.get(taskProcess.getId());
            if (inspectionTeamReport != null) {
               User user = this.userService.getById(inspectionTeamReport.getUserId());
               taskInfoDetailDTOS.add(
                  ScanCodeProductTaskInfoDetailDTO.builder()
                     .processName(process.getName() + "质检")
                     .userName(user == null ? "超管" : user.getName())
                     .inspectionOrReportingTime(inspectionTeamReport.getCreateTime())
                     .boolInspection(Boolean.TRUE)
                     .build()
               );
            }
         }
      }

      if (cargoList != null) {
         taskInfoDetailDTOS.add(
            ScanCodeProductTaskInfoDetailDTO.builder()
               .processName("发运")
               .userName(cargoList.getAuditUserName())
               .inspectionOrReportingTime(cargoList.getAuditTime())
               .boolInspection(Boolean.FALSE)
               .build()
         );
      }

      artifactQrTaskInfoDTO.setQrTaskInfoDetailDTOList(taskInfoDetailDTOS);
      if (CollectionUtils.isNotEmpty(taskInfoDetailDTOS)) {
         artifactQrTaskInfoDTO.setQrTaskInfoDetailDTOMap(
            taskInfoDetailDTOS.stream().collect(Collectors.toMap(ScanCodeProductTaskInfoDetailDTO::getProcessName, Function.identity()))
         );
      }

      return artifactQrTaskInfoDTO;
   }

   @NotNull
   private ScanCodeProductTaskInfoDTO getAssembleScanCodeProductTaskInfoDTO(Long taskId, Integer number, MesBuildingTask task) {
      TechAssemble assemble = this.assembleService.getById(task.getProductId());
      Preconditions.checkArgument(assemble != null, "查询失败,部件清单不存在!");
      List<TechAssembleExt> assembleExtList = this.assembleExtService
         .list((Wrapper<TechAssembleExt>)new LambdaQueryWrapper<TechAssembleExt>().eq(TechAssembleExt::getAssembleId, assemble.getId()));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(assembleExtList), "操作失败,产品码号不存在!");
      ScanCodeProductTaskInfoDTO assembleQrTaskInfoDTO = BeanUtil.copy(assemble, ScanCodeProductTaskInfoDTO.class);
      assembleQrTaskInfoDTO.setProject(this.projectService.getSimpleById(assemble.getProjectId()));
      assembleQrTaskInfoDTO.setMonomer(this.monomerService.getSimpleById(assemble.getMonomerId()));
      assembleQrTaskInfoDTO.setArea(this.areaService.getSimpleById(assemble.getAreaId()));
      assembleQrTaskInfoDTO.setProductType(ProductTypeEnum.ASSEMBLE.getType());
      assembleQrTaskInfoDTO.setProductId(assemble.getId());
      assembleQrTaskInfoDTO.setBoolHavDrawing(Boolean.FALSE);
      Map<String, List<TechDrawing>> drawingListMap = this.drawingService
         .list(
            (Wrapper<TechDrawing>)(((new LambdaQueryWrapper<TechDrawing>()
                        .eq(TechDrawing::getDataType, TechDataTypeEnum.DEEPEN.getType()))
                     .eq(TechDrawing::getProductType, DrawingProductTypeEnum.ASSEMBLE.getType()))
                  .eq(TechDrawing::getSerialNumber, assemble.getSerialNumber()))
               .eq(TechDrawing::getMonomerId, assemble.getMonomerId())
         )
         .stream()
         .collect(Collectors.groupingBy(TechDrawing::getSerialNumber));
      if (com.baomidou.mybatisplus.core.toolkit.CollectionUtils.isNotEmpty(drawingListMap)) {
         assembleQrTaskInfoDTO.setNumbers(drawingListMap.get(assemble.getSerialNumber()).stream().map(TechDrawing::getNumber).collect(Collectors.toList()));
         assembleQrTaskInfoDTO.setDrawingAndSerialNumber(
            drawingListMap.get(assemble.getSerialNumber())
               .stream()
               .map(drawing -> BeanUtil.copy(drawing, DrawingAndSerialNumberDTO.class))
               .collect(Collectors.toList())
         );
         assembleQrTaskInfoDTO.setBoolHavDrawing(Boolean.TRUE);
      }

      MesBuildingWorkshop workshop = this.workshopService.getById(task.getWorkshopId());
      MesBuildingProductionLine productionLine = this.productionLineService.getById(task.getProductionLineId());
      if (workshop != null && productionLine != null) {
         assembleQrTaskInfoDTO.setWorkShopAndProdLineName(workshop.getName() + "-" + productionLine.getName());
      }

      MesBuildingCargoList cargoList = null;
      if (number != null) {
         List<MesBuildingCargoListProductNumberLink> cargoListProductNumberLinks = this.productNumberLinkService
            .list(
               (Wrapper<MesBuildingCargoListProductNumberLink>)(((new LambdaQueryWrapper<MesBuildingCargoListProductNumberLink>()
                           .eq(MesBuildingCargoListProductNumberLink::getProductId, task.getProductId()))
                        .eq(MesBuildingCargoListProductNumberLink::getNumber, number))
                     .eq(MesBuildingCargoListProductNumberLink::getProductType, task.getTaskTypeEnum()))
                  .eq(MesBuildingCargoListProductNumberLink::getBoolCancelShip, Boolean.FALSE)
            );
         if (CollectionUtils.isNotEmpty(cargoListProductNumberLinks)) {
            List<MesBuildingCargoList> cargoListList = this.cargoListService
               .list(
                  (Wrapper<MesBuildingCargoList>)(new LambdaQueryWrapper<MesBuildingCargoList>()
                        .in(MesBuildingCargoList::getStatus, CargoListStatusEnum.SHIPMENT.getType(), CargoListStatusEnum.RECEIPT.getType()))
                     .in(
                        MesBuildingCargoList::getId,
                        cargoListProductNumberLinks.stream().map(MesBuildingCargoListProductNumberLink::getCargoListId).collect(Collectors.toList())
                     )
               );
            if (CollectionUtils.isNotEmpty(cargoListList)) {
               cargoList = cargoListList.get(0);
            }
         }
      }

      if (number == null) {
         List<MesBuildingCargoListProductNumberLink> cargoListProductNumberLinks = this.productNumberLinkService
            .list(
               (Wrapper<MesBuildingCargoListProductNumberLink>)((new LambdaQueryWrapper<MesBuildingCargoListProductNumberLink>()
                        .eq(MesBuildingCargoListProductNumberLink::getProductId, task.getProductId()))
                     .eq(MesBuildingCargoListProductNumberLink::getProductType, task.getTaskTypeEnum()))
                  .eq(MesBuildingCargoListProductNumberLink::getBoolCancelShip, Boolean.FALSE)
            );
         if (CollectionUtils.isNotEmpty(cargoListProductNumberLinks)) {
            List<MesBuildingCargoList> cargoListList = this.cargoListService
               .list(
                  (Wrapper<MesBuildingCargoList>)(new LambdaQueryWrapper<MesBuildingCargoList>()
                        .in(MesBuildingCargoList::getStatus, CargoListStatusEnum.SHIPMENT.getType(), CargoListStatusEnum.RECEIPT.getType()))
                     .in(
                        MesBuildingCargoList::getId,
                        cargoListProductNumberLinks.stream().map(MesBuildingCargoListProductNumberLink::getCargoListId).collect(Collectors.toList())
                     )
               );
            if (CollectionUtils.isEmpty(cargoListList)) {
               number = cargoListProductNumberLinks.get(0).getNumber();
            } else {
               cargoList = cargoListList.get(0);
               MesBuildingCargoList finalCargoList = cargoList;
               number = cargoListProductNumberLinks.stream()
                  .filter(e -> finalCargoList.getId().equals(e.getCargoListId()))
                  .collect(Collectors.toList())
                  .get(0)
                  .getNumber();
            }
         }

         if (number == null) {
            List<MesBuildingComplete> completes = this.completeService
               .list((Wrapper<MesBuildingComplete>)new LambdaQueryWrapper<MesBuildingComplete>().eq(MesBuildingComplete::getTaskId, taskId));
            if (CollectionUtils.isNotEmpty(completes)) {
               number = completes.get(0).getNumber();
            }
         }

         if (number == null) {
            number = assembleExtList.get(0).getSortNumber();
         }
      }

      Integer finalNumber = number;
      List<TechAssembleExt> assembleExts = assembleExtList.stream().filter(e -> e.getSortNumber().equals(finalNumber)).collect(Collectors.toList());
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(assembleExts) && assembleExts.size() == 1, "操作失败,产品码号不存在!");
      TechAssembleExt assembleExt = assembleExts.get(0);
      List<ScanCodeProductTaskInfoDetailDTO> taskInfoDetailDTOS = new ArrayList<>();
      List<MesBuildingTaskProcess> taskProcesses = this.taskProcessService
         .list(
            (Wrapper<MesBuildingTaskProcess>)(new LambdaQueryWrapper<MesBuildingTaskProcess>().eq(MesBuildingTaskProcess::getTaskId, taskId))
               .gt(MesBuildingTaskProcess::getCompleteQuantity, 0)
         );
      if (CollectionUtils.isEmpty(taskProcesses)) {
         return assembleQrTaskInfoDTO;
      }

      User importUser = this.userService.getById(assemble.getUserId());
      ScanCodeProductTaskInfoDetailDTO drawingDeepeningDTO = ScanCodeProductTaskInfoDetailDTO.builder()
         .processName("图纸深化")
         .userName(importUser == null ? "超管" : importUser.getName())
         .inspectionOrReportingTime(assembleExt.getCreateTime())
         .boolInspection(Boolean.FALSE)
         .build();
      taskInfoDetailDTOS.add(drawingDeepeningDTO);
      List<MesBuildingMachinePartSchedulingArtifactTaskLink> partSchedulingArtifactTaskLinks = this.partSchedulingArtifactTaskLinkService
         .list(
            (Wrapper<MesBuildingMachinePartSchedulingArtifactTaskLink>)new LambdaQueryWrapper<MesBuildingMachinePartSchedulingArtifactTaskLink>()
               .eq(MesBuildingMachinePartSchedulingArtifactTaskLink::getTaskId, taskId)
         );
      if (CollectionUtils.isNotEmpty(partSchedulingArtifactTaskLinks)) {
         List<MesBuildingMachinePartSchedulingLink> partSchedulingLinks = this.partSchedulingLinkService
            .listByIds(
               partSchedulingArtifactTaskLinks.stream()
                  .map(MesBuildingMachinePartSchedulingArtifactTaskLink::getSchedulingLinkId)
                  .distinct()
                  .collect(Collectors.toList())
            );
         if (CollectionUtils.isNotEmpty(partSchedulingLinks)) {
            List<MesBuildingTask> taskList = this.taskService
               .list(
                  (Wrapper<MesBuildingTask>)((new LambdaQueryWrapper<MesBuildingTask>()
                           .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.MACHINE_PART.getType()))
                        .in(
                           MesBuildingTask::getMachinePartSchedulingId,
                           partSchedulingLinks.stream().map(MesBuildingMachinePartSchedulingLink::getSchedulingId).distinct().collect(Collectors.toList())
                        ))
                     .in(
                        MesBuildingTask::getProductId,
                        partSchedulingLinks.stream().map(MesBuildingMachinePartSchedulingLink::getProductId).distinct().collect(Collectors.toList())
                     )
               );
            if (CollectionUtils.isNotEmpty(taskList)) {
               List<MesBuildingTask> partTaskList = taskList.stream().filter(e -> e.getCompleteTime() != null).collect(Collectors.toList());
               if (CollectionUtils.isNotEmpty(partTaskList)) {
                  List<MesBuildingProduceTeamReport> produceTeamReportList = this.produceTeamReportService
                     .list(
                        (Wrapper<MesBuildingProduceTeamReport>)new LambdaQueryWrapper<MesBuildingProduceTeamReport>()
                           .eq(MesBuildingProduceTeamReport::getTaskId, partTaskList.get(0).getId())
                     );
                  if (CollectionUtils.isNotEmpty(produceTeamReportList)) {
                     User user = this.userService.getById(produceTeamReportList.get(0).getUserId());
                     taskInfoDetailDTOS.add(
                        ScanCodeProductTaskInfoDetailDTO.builder()
                           .processName("零件下料")
                           .userName(user == null ? "超管" : user.getName())
                           .inspectionOrReportingTime(partTaskList.get(0).getCompleteTime())
                           .boolInspection(Boolean.FALSE)
                           .build()
                     );
                  }
               }
            }
         }
      }

      Map<Long, MesBuildingProcess> processMap = this.processService
         .listByIds(taskProcesses.stream().map(MesBuildingTaskProcess::getProcessId).collect(Collectors.toList()))
         .stream()
         .collect(Collectors.toMap(MesBuildingProcess::getId, Function.identity()));
      taskProcesses = taskProcesses.stream().sorted(Comparator.comparing(MesBuildingTaskProcess::getSequence)).collect(Collectors.toList());
      Map<Long, MesBuildingProduceTeamReport> produceTeamReportMap = this.produceTeamReportService
         .list(
            (Wrapper<MesBuildingProduceTeamReport>)(new LambdaQueryWrapper<MesBuildingProduceTeamReport>().eq(MesBuildingProduceTeamReport::getTaskId, taskId))
               .eq(MesBuildingProduceTeamReport::getNumber, number)
         )
         .stream()
         .collect(Collectors.toMap(MesBuildingProduceTeamReport::getTaskProcessId, Function.identity()));
      Map<Long, MesBuildingProduceInspectionTeamReport> inspectionTeamReportMap = this.inspectionTeamReportService
         .list(
            (Wrapper<MesBuildingProduceInspectionTeamReport>)((new LambdaQueryWrapper<MesBuildingProduceInspectionTeamReport>()
                     .eq(MesBuildingProduceInspectionTeamReport::getTaskId, taskId))
                  .eq(MesBuildingProduceInspectionTeamReport::getBoolAdoptEnum, Boolean.TRUE))
               .eq(MesBuildingProduceInspectionTeamReport::getNumber, number)
         )
         .stream()
         .collect(Collectors.toMap(MesBuildingProduceInspectionTeamReport::getTaskProcessId, Function.identity()));

      for (MesBuildingTaskProcess taskProcess : taskProcesses) {
         MesBuildingProcess process = processMap.get(taskProcess.getProcessId());
         MesBuildingProduceTeamReport produceTeamReport = produceTeamReportMap.get(taskProcess.getId());
         if (produceTeamReport != null) {
            User user = this.userService.getById(produceTeamReport.getUserId());
            taskInfoDetailDTOS.add(
               ScanCodeProductTaskInfoDetailDTO.builder()
                  .processName(process.getName())
                  .userName(user == null ? "超管" : user.getName())
                  .inspectionOrReportingTime(produceTeamReport.getCreateTime())
                  .boolInspection(Boolean.FALSE)
                  .build()
            );
         }

         MesBuildingProduceInspectionTeamReport inspectionTeamReport = inspectionTeamReportMap.get(taskProcess.getId());
         if (inspectionTeamReport != null) {
            User user = this.userService.getById(inspectionTeamReport.getUserId());
            taskInfoDetailDTOS.add(
               ScanCodeProductTaskInfoDetailDTO.builder()
                  .processName(process.getName() + "质检")
                  .userName(user == null ? "超管" : user.getName())
                  .inspectionOrReportingTime(inspectionTeamReport.getCreateTime())
                  .boolInspection(Boolean.TRUE)
                  .build()
            );
         }
      }

      if (cargoList != null) {
         taskInfoDetailDTOS.add(
            ScanCodeProductTaskInfoDetailDTO.builder()
               .processName("发运")
               .userName(cargoList.getAuditUserName())
               .inspectionOrReportingTime(cargoList.getAuditTime())
               .boolInspection(Boolean.FALSE)
               .build()
         );
      }

      assembleQrTaskInfoDTO.setQrTaskInfoDetailDTOList(taskInfoDetailDTOS);
      if (CollectionUtils.isNotEmpty(taskInfoDetailDTOS)) {
         assembleQrTaskInfoDTO.setQrTaskInfoDetailDTOMap(
            taskInfoDetailDTOS.stream().collect(Collectors.toMap(ScanCodeProductTaskInfoDetailDTO::getProcessName, Function.identity()))
         );
      }

      return assembleQrTaskInfoDTO;
   }

   @NotNull
   private ScanCodeProductTaskInfoDTO getEnclosureScanCodeProductTaskInfoDTO(Long taskId, Integer number, MesEnclosureTask task) {
      TechEnclosure enclosure = this.enclosureService.getById(task.getProductId());
      Preconditions.checkArgument(enclosure != null, "查询失败,围护清单不存在!");
      ScanCodeProductTaskInfoDTO enclosureQrTaskInfoDTO = BeanUtil.copy(enclosure, ScanCodeProductTaskInfoDTO.class);
      enclosureQrTaskInfoDTO.setProject(this.projectService.getSimpleById(enclosure.getProjectId()));
      enclosureQrTaskInfoDTO.setMonomer(this.monomerService.getSimpleById(enclosure.getMonomerId()));
      enclosureQrTaskInfoDTO.setArea(this.areaService.getSimpleById(enclosure.getAreaId()));
      enclosureQrTaskInfoDTO.setProductType(ProductTypeEnum.ENCLOSURE.getType());
      enclosureQrTaskInfoDTO.setProductId(enclosure.getId());
      enclosureQrTaskInfoDTO.setBoolHavDrawing(Boolean.FALSE);
      enclosureQrTaskInfoDTO.setSpecification(enclosure.getPlate());
      MesBuildingWorkshop workshop = this.workshopService.getById(task.getWorkshopId());
      MesEnclosureProductionLine productionLine = this.enclosureProductionLineService.getById(task.getProductionLineId());
      if (workshop != null && productionLine != null) {
         enclosureQrTaskInfoDTO.setWorkShopAndProdLineName(workshop.getName() + "-" + productionLine.getName());
      }

      MesBuildingCargoList cargoList = null;
      if (number == null) {
         List<MesBuildingCargoListProductNumberLink> cargoListProductNumberLinks = this.productNumberLinkService
            .list(
               (Wrapper<MesBuildingCargoListProductNumberLink>)((new LambdaQueryWrapper<MesBuildingCargoListProductNumberLink>()
                        .eq(MesBuildingCargoListProductNumberLink::getProductId, task.getProductId()))
                     .eq(MesBuildingCargoListProductNumberLink::getProductType, TaskTypeEnum.ENCLOSURE.getType()))
                  .eq(MesBuildingCargoListProductNumberLink::getBoolCancelShip, Boolean.FALSE)
            );
         if (CollectionUtils.isNotEmpty(cargoListProductNumberLinks)) {
            List<MesBuildingCargoList> cargoListList = this.cargoListService
               .list(
                  (Wrapper<MesBuildingCargoList>)(new LambdaQueryWrapper<MesBuildingCargoList>()
                        .in(MesBuildingCargoList::getStatus, CargoListStatusEnum.SHIPMENT.getType(), CargoListStatusEnum.RECEIPT.getType()))
                     .in(
                        MesBuildingCargoList::getId,
                        cargoListProductNumberLinks.stream().map(MesBuildingCargoListProductNumberLink::getCargoListId).collect(Collectors.toList())
                     )
               );
            if (CollectionUtils.isEmpty(cargoListList)) {
               number = cargoListProductNumberLinks.get(0).getNumber();
            } else {
               cargoList = cargoListList.get(0);
               MesBuildingCargoList finalCargoList = cargoList;
               number = cargoListProductNumberLinks.stream()
                  .filter(e -> finalCargoList.getId().equals(e.getCargoListId()))
                  .collect(Collectors.toList())
                  .get(0)
                  .getNumber();
            }
         }

         if (number == null) {
            List<MesBuildingComplete> completes = this.completeService
               .list(
                  (Wrapper<MesBuildingComplete>)(new LambdaQueryWrapper<MesBuildingComplete>().eq(MesBuildingComplete::getTaskId, taskId))
                     .eq(MesBuildingComplete::getTaskTypeEnum, TaskTypeEnum.ENCLOSURE.getType())
               );
            if (CollectionUtils.isNotEmpty(completes)) {
               number = completes.get(0).getNumber();
            }
         }
      }

      List<ScanCodeProductTaskInfoDetailDTO> taskInfoDetailDTOS = new ArrayList<>();
      MesEnclosureProcess process = this.enclosureProcessService.getById(task.getProcessId());
      List<MesEnclosureProduceTeamReport> produceTeamReportList = this.enclosureProduceTeamReportService
         .list(
            (Wrapper<MesEnclosureProduceTeamReport>)(new LambdaQueryWrapper<MesEnclosureProduceTeamReport>().eq(MesEnclosureProduceTeamReport::getTaskId, taskId))
               .orderByAsc(BaseEntity::getCreateTime)
         );
      produceTeamReportList.forEach(
         e -> {
            User user = this.userService.getById(e.getUserId());
            taskInfoDetailDTOS.add(
               ScanCodeProductTaskInfoDetailDTO.builder()
                  .processName(process.getName())
                  .userName(user == null ? "超管" : user.getName())
                  .inspectionOrReportingTime(e.getCreateTime())
                  .quantity(BigDecimal.valueOf(e.getQuantity().intValue()))
                  .boolInspection(Boolean.FALSE)
                  .build()
            );
         }
      );
      if (cargoList != null) {
         taskInfoDetailDTOS.add(
            ScanCodeProductTaskInfoDetailDTO.builder()
               .processName("发运")
               .userName(cargoList.getAuditUserName())
               .inspectionOrReportingTime(cargoList.getAuditTime())
               .boolInspection(Boolean.FALSE)
               .build()
         );
      }

      enclosureQrTaskInfoDTO.setQrTaskInfoDetailDTOList(taskInfoDetailDTOS);
      return enclosureQrTaskInfoDTO;
   }
}
