package com.hzchum.scim.mes.building.core.biz.impl.onecodeChange;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.onecodeChange.MesBuildingOneCodeChangBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingNewTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingProduceTeamReportBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskOrderChangeBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskProcessBiz;
import com.hzchum.scim.mes.building.core.api.enums.QhseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.SaveProduceTeamReportSummaryTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.IssuedToNestingSoftwareStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseRecordStatusTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.process.MesBuildingNextProcessLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhse;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhseInspectionLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhseRectify;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhseUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingArtifactScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingMachinePartScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingMachinePartSchedulingLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestCutPlate;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNestCutPlatePart;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssist;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssistNumberDetail;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingComplete;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingMachinePartSchedulingArtifactTaskLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingMachinePartSeparate;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceInspectionTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceQhseTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReportSummary;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingSinglePartArtifactPrint;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNeedMachinePartScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNeedMachinePartSchedulingUnProduction;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTopTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wages.MesBuildingProduceTeamReportPrice;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingSinglePartArtifactPrintRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.pojo._dto.onecodeChange.MesBuildingOrderIdAndQuantityDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.onecodeChange.MesBuildingProductBoolChangeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.onecodeChange.MesBuildingReportSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.onecodeChange.MesBuildingSecondUseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.AddWarehouseDTO;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingNextProcessLinkService;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseInspectionLinkService;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseRectifyService;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseService;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingArtifactSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingMachinePartSchedulingLinkService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingMachinePartSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingNestCutPlatePartService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingNestCutPlateService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingAssistNumberDetailService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingAssistService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingMachinePartSchedulingArtifactTaskLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingMachinePartSeparateService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceInspectionTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceQhseTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportSummaryService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingSinglePartArtifactPrintService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNeedMachinePartSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNeedMachinePartSchedulingUnProductionService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskOrderService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTopTaskOrderService;
import com.hzchum.scim.mes.building.core.api.service.wages.MesBuildingProduceTeamReportPriceService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingSinglePartArtifactPrintRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.plan.core.api.enums.MachinePartRelationTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactExt;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleDetail;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleExt;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.change.TechChangeArtifactDelDtoParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.change.TechChangeArtifactUseDtoParam;
import com.hzchum.scim.plan.core.api.service.TechArtifactExtService;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleDetailService;
import com.hzchum.scim.plan.core.api.service.TechAssembleExtService;
import com.hzchum.scim.plan.core.api.service.TechAssembleMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.system.core.api.common.enums.ProjectModeEnum;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingOneCodeChangBizImpl implements MesBuildingOneCodeChangBiz {
   @Resource
   private MesBuildingWarehouseRecordService warehouseRecordService;
   @Resource
   private MesBuildingWarehouseSummaryService warehouseSummaryService;
   @Resource
   private MesBuildingCompleteService completeService;
   @Resource
   private TechArtifactExtService artifactExtService;
   @Resource
   private TechAssembleExtService assembleExtService;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private MesBuildingProduceQhseTeamReportService mesBuildingProduceQhseTeamReportService;
   @Resource
   private TechAssembleMachinePartLinkService assembleMachinePartLinkService;
   @Resource
   private MesBuildingTaskNumberLinkService numberLinkService;
   @Resource
   private TechArtifactMachinePartLinkService artifactMachinePartLinkService;
   @Resource
   private TechMachinePartService machinePartService;
   @Resource
   private MesBuildingTaskService taskService;
   @Resource
   private MesBuildingTaskProcessService taskProcessService;
   @Resource
   private MesBuildingTaskProcessBiz taskProcessBiz;
   @Resource
   private MesBuildingTaskBiz taskBiz;
   @Resource
   private MesBuildingNewTaskBiz mesBuildingNewTaskBiz;
   @Resource
   private MesBuildingProduceTeamReportService mesBuildingProduceTeamReportService;
   @Resource
   private MesBuildingProduceInspectionTeamReportService inspectionTeamReportService;
   @Autowired
   private MesBuildingProduceTeamReportSummaryService produceTeamReportSummaryService;
   @Autowired
   private MesBuildingProduceTeamReportBiz teamReportBiz;
   @Autowired
   private MesBuildingTaskOrderService taskOrderService;
   @Autowired
   private TechAssembleDetailService assembleDetailService;
   @Autowired
   private MesBuildingProduceTeamReportPriceService teamReportPriceService;
   @Autowired
   private MesBuildingTopTaskOrderService topTaskOrderService;
   @Autowired
   private MesBuildingQhseService mesBuildingQhseService;
   @Autowired
   private TechAssembleService assembleService;
   @Autowired
   private MesBuildingQhseRectifyService qhseRectifyService;
   @Resource
   private MesBuildingArtifactSchedulingService mesBuildingArtifactSchedulingService;
   @Autowired
   private MesBuildingQhseInspectionLinkService qhseInspectionLinkService;
   @Autowired
   private MesBuildingQhseUserLinkService qhseUserLinkService;
   @Autowired
   private MesBuildingSinglePartArtifactPrintService singlePartArtifactPrintService;
   @Autowired
   private MesBuildingSinglePartArtifactPrintRecordService singlePartArtifactPrintRecordService;
   @Autowired
   private MesBuildingTaskOrderChangeBiz orderChangeBiz;
   @Autowired
   private MesBuildingAssistNumberDetailService numberDetailService;
   @Autowired
   private MesBuildingAssistService assistService;
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private MesBuildingNextProcessLinkService nextProcessLinkService;
   @Autowired
   private RedisUtils redisUtils;
   @Autowired
   private MesBuildingAssistNumberDetailService assistNumberDetailService;
   @Autowired
   private MesBuildingTaskNeedMachinePartSchedulingService needMachinePartSchedulingService;
   @Autowired
   private MesBuildingMachinePartSchedulingArtifactTaskLinkService partSchedulingArtifactTaskLinkService;
   @Autowired
   private MesBuildingMachinePartSchedulingLinkService machinePartSchedulingLinkService;
   @Autowired
   private MesBuildingMachinePartSchedulingService machinePartSchedulingService;
   @Autowired
   private MesBuildingNestCutPlateService nestCutPlateService;
   @Autowired
   private MesBuildingNestCutPlatePartService nestCutPlatePartService;
   @Autowired
   private MesBuildingMachinePartSeparateService machinePartSeparateService;
   @Autowired
   private MesBuildingProduceTeamReportService produceTeamReportService;
   @Autowired
   private MesBuildingTaskNeedMachinePartSchedulingUnProductionService taskNeedMachinePartSchedulingUnProductionService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteArtifacts(List<TechChangeArtifactDelDtoParam> changeList, Boolean secodeUser) {
      List<NumberInfoDTO> allArtifactNumbers = changeList.stream()
         .map(
            techChangeArtifactDelDtoParam -> NumberInfoDTO.builder()
               .productId(techChangeArtifactDelDtoParam.getArtifactId())
               .number(techChangeArtifactDelDtoParam.getSortNumber())
               .build()
         )
         .collect(Collectors.toList());
      List<TechArtifactExt> artifactExts = this.artifactExtService.listArtifact(allArtifactNumbers);
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactExts), "操作失败,构件码号信息不存在!");
      Preconditions.checkArgument(artifactExts.stream().allMatch(TechArtifactExt::getBoolScheduling), "操作失败,构件未排产,不可触发生产变更!");
      List<Long> projectIds = artifactExts.stream().map(TechArtifactExt::getProjectId).distinct().collect(Collectors.toList());
      Preconditions.checkArgument(projectIds.size() == 1, "操作失败,项目异常!");
      Map<Long, List<TechArtifactExt>> reduceScheduMap = artifactExts.stream().collect(Collectors.groupingBy(TechArtifactExt::getSchedulingId));
      List<MesBuildingArtifactScheduling> artifactSchedulings = this.mesBuildingArtifactSchedulingService.listByIds(reduceScheduMap.keySet());

      for (MesBuildingArtifactScheduling scheduling : artifactSchedulings) {
         List<TechArtifactExt> reduceExts = reduceScheduMap.get(scheduling.getId());
         List<TechArtifactExt> taskExts = reduceExts.stream().filter(TechArtifactExt::getBoolTask).collect(Collectors.toList());
         scheduling.setQuantity(scheduling.getQuantity() - reduceExts.size());
         scheduling.setTaskQuantity(scheduling.getTaskQuantity() - taskExts.size());
         Preconditions.checkArgument(scheduling.getQuantity() >= 0, "操作失败,构件排产数量不可小于0");
         Preconditions.checkArgument(scheduling.getTaskQuantity() >= 0, "操作失败,构件下发数量不可小于0");
         Preconditions.checkArgument(scheduling.getQuantity() >= scheduling.getTaskQuantity(), "操作失败,构件下发数量不可大于排产数量");
      }

      this.mesBuildingArtifactSchedulingService.updateBatchById(artifactSchedulings);
      List<Long> removeIds = artifactSchedulings.stream()
         .filter(s -> s.getQuantity() == 0)
         .map(MesBuildingArtifactScheduling::getId)
         .collect(Collectors.toList());
      this.mesBuildingArtifactSchedulingService.removeByIds(removeIds);
      List<TechArtifactExt> needReduceExtTasks = artifactExts.stream().filter(TechArtifactExt::getBoolTask).collect(Collectors.toList());
      List<NumberInfoDTO> needReduceTasks = needReduceExtTasks.stream()
         .map(
            extTask -> NumberInfoDTO.builder()
               .productId(extTask.getArtifactId())
               .number(extTask.getSortNumber())
               .taskType(TaskTypeEnum.ARTIFACT.getType())
               .build()
         )
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(needReduceTasks)) {
         List<MesBuildingTaskNumberLink> numberLinks = this.numberLinkService.listLinksBydata(needReduceTasks, TaskTypeEnum.ARTIFACT.getType());
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(numberLinks), "操作失败,构件码号任务数据不存在,请刷新页面!");
         List<String> reduce = numberLinks.stream().map(s -> s.getArtifactId() + "_" + s.getArtifactNumber()).distinct().collect(Collectors.toList());
         Preconditions.checkArgument(needReduceTasks.size() == reduce.size(), "操作失败,构件已下发的码号数据异常!");
         List<NumberInfoDTO> assNumbers = numberLinks.stream()
            .filter(numberLink -> numberLink.getAssembleId() != null)
            .map(numberLink -> NumberInfoDTO.builder().productId(numberLink.getAssembleId()).number(numberLink.getAssembleNumber()).build())
            .collect(Collectors.toList());
         List<NumberInfoDTO> artifactNumbers = numberLinks.stream()
            .map(numberLink -> NumberInfoDTO.builder().productId(numberLink.getArtifactId()).number(numberLink.getArtifactNumber()).build())
            .collect(Collectors.toList());
         if (!secodeUser) {
            this.checkChangeList(artifactNumbers, assNumbers);
         }

         this.reduceProductData(artifactNumbers, TaskTypeEnum.ARTIFACT.getType(), projectIds.get(0));
      }

      return true;
   }

   public void checkChangeList(List<NumberInfoDTO> allArtifactNumbers, List<NumberInfoDTO> assNumbers) {
      List<String> idNumbers = allArtifactNumbers.stream().map(s -> s.getProductId() + "_" + s.getNumber()).distinct().collect(Collectors.toList());
      List<NumberInfoDTO> artifactNumbers = new ArrayList<>();

      for (String idNumber : idNumbers) {
         String[] split = idNumber.split("_");
         NumberInfoDTO build = NumberInfoDTO.builder().productId(Long.valueOf(split[0])).number(Integer.valueOf(split[1])).build();
         artifactNumbers.add(build);
      }

      List<MesBuildingProductBoolChangeDTO> artCarDatas = this.warehouseRecordService.listBoolArtInCargo(artifactNumbers);
      Preconditions.checkArgument(artCarDatas.size() == artifactNumbers.size(), "操作失败,构件码号数据异常!");
      Preconditions.checkArgument(artCarDatas.stream().allMatch(MesBuildingProductBoolChangeDTO::getBoolCanCange), "操作失败,构件已进入发运流程!");
      if (CollectionUtils.isNotEmpty(assNumbers)) {
         List<MesBuildingProductBoolChangeDTO> assCarDatas = this.warehouseRecordService.listBoolAssInCargo(assNumbers);
         Preconditions.checkArgument(assCarDatas.size() == assNumbers.size(), "操作失败,部件码号任务异常");
         Preconditions.checkArgument(assCarDatas.stream().allMatch(MesBuildingProductBoolChangeDTO::getBoolCanCange), "操作失败,构件下的部件已进入发运流程,请刷新页面!");
      }

      List<MesBuildingTaskNumberLink> artLinks = this.numberLinkService.listLinksBydata(artifactNumbers, TaskTypeEnum.ARTIFACT.getType());
      Map<String, MesBuildingTaskNumberLink> artLinkMap = artLinks.stream()
         .collect(Collectors.toMap(s -> s.getArtifactId() + "_" + s.getArtifactNumber(), Function.identity(), (s1, s2) -> s1));
      List<Long> artTaskIds = artLinks.stream()
         .filter(s -> s.getArtifactTaskId() != null)
         .map(MesBuildingTaskNumberLink::getArtifactTaskId)
         .distinct()
         .collect(Collectors.toList());
      List<MesBuildingTask> tasks = this.taskService.listByIds(artTaskIds);
      Map<Long, Long> taskShopMap = tasks.stream().collect(Collectors.toMap(MesBuildingTask::getId, MesBuildingTask::getWorkshopId, (s1, s2) -> s1));
      List<Long> artIds = artifactNumbers.stream().map(NumberInfoDTO::getProductId).distinct().collect(Collectors.toList());
      List<TechArtifactMachinePartLink> artPartLinks = this.artifactMachinePartLinkService
         .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getArtifactId, artIds));
      if (CollUtil.isNotEmpty(artPartLinks)) {
         Map<Long, List<TechArtifactMachinePartLink>> artPartLinkMap = artPartLinks.stream()
            .collect(Collectors.groupingBy(TechArtifactMachinePartLink::getArtifactId));
         List<Long> partIds = artPartLinks.stream().map(TechArtifactMachinePartLink::getMachinePartId).distinct().collect(Collectors.toList());
         List<TechMachinePart> partList = this.machinePartService.listByIds(partIds);
         Map<Long, TechMachinePart> partMap = partList.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
         Map<String, Integer> partChangeReduceMap = new HashMap<>();

         for (NumberInfoDTO artifactNumber : artifactNumbers) {
            String artLinkKey = artifactNumber.getProductId() + "_" + artifactNumber.getNumber();
            MesBuildingTaskNumberLink artLink = artLinkMap.get(artLinkKey);
            Long shopId = taskShopMap.get(artLink.getArtifactTaskId());

            for (TechArtifactMachinePartLink link : artPartLinkMap.getOrDefault(artifactNumber.getProductId(), new ArrayList<>())) {
               TechMachinePart part = partMap.get(link.getMachinePartId());
               if (part.getRelationType().equals(MachinePartRelationTypeEnum.FOR_ARTIFACT.getType()) && part.getBoolSendDirectly()) {
                  String reduceKey = shopId + "_" + link.getMachinePartId();
                  Integer reduceQuantity = partChangeReduceMap.getOrDefault(reduceKey, 0);
                  reduceQuantity = reduceQuantity + link.getQuantity();
                  partChangeReduceMap.put(reduceKey, reduceQuantity);
               }
            }
         }

         Map<String, Integer> sendWarehouseMap = new HashMap<>();
         List<TechArtifactMachinePartLink> allSendLinks = this.artifactMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getMachinePartId, partIds));
         Map<Long, List<TechArtifactMachinePartLink>> allArtPartLinkMap = allSendLinks.stream()
            .collect(Collectors.groupingBy(TechArtifactMachinePartLink::getArtifactId));
         List<Long> allSenLinkArtIds = allSendLinks.stream().map(TechArtifactMachinePartLink::getArtifactId).distinct().collect(Collectors.toList());

         for (MesBuildingTask task : this.taskService
            .list(
               Wrappers.lambdaQuery(MesBuildingTask.class)
                  .in(MesBuildingTask::getProductId, allSenLinkArtIds)
                  .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
            )) {
            Long shopId = task.getWorkshopId();

            for (TechArtifactMachinePartLink link : allArtPartLinkMap.getOrDefault(task.getProductId(), new ArrayList<>())) {
               TechMachinePart part = partMap.get(link.getMachinePartId());
               if (part.getRelationType().equals(MachinePartRelationTypeEnum.FOR_ARTIFACT.getType()) && part.getBoolSendDirectly()) {
                  String reduceKey = shopId + "_" + link.getMachinePartId();
                  Integer reduceQuantity = sendWarehouseMap.getOrDefault(reduceKey, 0);
                  reduceQuantity = reduceQuantity + task.getTaskQuantity() * link.getQuantity();
                  sendWarehouseMap.put(reduceKey, reduceQuantity);
               }
            }
         }

         List<MesBuildingWarehouseSummary> warehouseSummaryList = this.warehouseSummaryService
            .list(
               Wrappers.lambdaQuery(MesBuildingWarehouseSummary.class)
                  .in(MesBuildingWarehouseSummary::getProductId, partIds)
                  .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
                  .eq(MesBuildingWarehouseSummary::getProductType, TaskTypeEnum.MACHINE_PART.getType())
            );
         Map<String, Integer> cargoQuantiyiMap = warehouseSummaryList.stream()
            .collect(
               Collectors.toMap(
                  s -> s.getWorkshopId() + "_" + s.getProductId(), s -> s.getPackageQuantity().intValue() + s.getCargoQuantity().intValue(), Integer::sum
               )
            );

         for (String reduceKey : partChangeReduceMap.keySet()) {
            Integer needReduceQuantity = partChangeReduceMap.get(reduceKey);
            Integer canWareQuantity = sendWarehouseMap.get(reduceKey);
            Preconditions.checkArgument(canWareQuantity != null, "操作失败,请联系管理员!!!");
            Integer cargoPackageQuantity = cargoQuantiyiMap.getOrDefault(reduceKey, 0);
            Preconditions.checkArgument(canWareQuantity - cargoPackageQuantity >= needReduceQuantity, "操作失败,车间下直发零件库存数量不足!");
         }
      }
   }

   void reduceProductData(List<NumberInfoDTO> numberInfoDTOS, Integer taskType, Long projectId) {
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(numberInfoDTOS), "操作失败,产品码号数据不可为空!");
      Preconditions.checkArgument(taskType.equals(TaskTypeEnum.ARTIFACT.getType()) || taskType.equals(TaskTypeEnum.ASSEMBLE.getType()), "操作失败,产品类型不正确!");
      List<MesBuildingTaskNumberLink> numberLinks = this.numberLinkService.listLinksBydata(numberInfoDTOS, taskType);
      List<MesBuildingTaskNumberLink> needReduceAssnumberLink = numberLinks.stream().filter(s -> s.getAssembleId() != null).collect(Collectors.toList());
      List<Long> assTaskIds = new ArrayList<>();
      List<Long> assIds = new ArrayList<>();
      Map<Long, Integer> assTaskReduceMap = new HashMap<>();
      List<NumberInfoDTO> assNumberInfors = new ArrayList<>();
      new ArrayList();
      if (CollectionUtils.isNotEmpty(needReduceAssnumberLink)) {
         assTaskIds = needReduceAssnumberLink.stream()
            .map(MesBuildingTaskNumberLink::getAssembleTaskId)
            .filter(Objects::nonNull)
            .distinct()
            .collect(Collectors.toList());
         assIds = needReduceAssnumberLink.stream().map(MesBuildingTaskNumberLink::getAssembleId).distinct().collect(Collectors.toList());
         assTaskReduceMap = needReduceAssnumberLink.stream().collect(Collectors.toMap(MesBuildingTaskNumberLink::getAssembleTaskId, s -> 1, Integer::sum));
         assNumberInfors = needReduceAssnumberLink.stream()
            .map(numberLink -> NumberInfoDTO.builder().productId(numberLink.getAssembleId()).number(numberLink.getAssembleNumber()).build())
            .collect(Collectors.toList());
      }

      List<Long> artifactIds = numberInfoDTOS.stream().map(NumberInfoDTO::getProductId).collect(Collectors.toList());
      List<TechArtifactExt> artifactExts = this.artifactExtService.listArtifact(numberInfoDTOS);
      List<Long> artTaskIds = artifactExts.stream().map(TechArtifactExt::getTaskId).distinct().collect(Collectors.toList());
      List<MesBuildingProduceTeamReport> artifactProduceTeamReports = this.produceTeamReportService
         .list((Wrapper<MesBuildingProduceTeamReport>)new LambdaQueryWrapper<MesBuildingProduceTeamReport>().in(MesBuildingProduceTeamReport::getTaskId, artTaskIds));
      Map<Long, Integer> artTaskReduces = artifactExts.stream().collect(Collectors.toMap(TechArtifactExt::getTaskId, s -> 1, Integer::sum));
      List<TechArtifact> artifacts = this.artifactService.listByIds(artifactIds);
      this.updateQhse(numberInfoDTOS, TaskTypeEnum.ARTIFACT.getType());
      if (CollectionUtils.isNotEmpty(assNumberInfors)) {
         this.updateQhse(assNumberInfors, TaskTypeEnum.ASSEMBLE.getType());
      }

      Map<Long, Integer> artReduceMap = this.reduceProduct(artTaskIds, artTaskReduces, numberInfoDTOS, artifactIds, TaskTypeEnum.ARTIFACT.getType(), projectId);
      if (!artReduceMap.isEmpty()) {
         artifacts.forEach(artifact -> artifact.setProducedQuantity(artifact.getProducedQuantity() - artReduceMap.getOrDefault(artifact.getId(), 0)));
         Preconditions.checkArgument(artifacts.stream().allMatch(s -> s.getQuantity() - s.getProducedQuantity() >= 0), "操作失败!!!!");
         this.artifactService.updateBatchById(artifacts);
      }

      artifactExts = artifactExts.stream()
         .map(s -> s.setBoolTask(Boolean.FALSE).setTaskId(0L).setBoolScheduling(Boolean.FALSE).setSchedulingId(0L))
         .collect(Collectors.toList());
      this.artifactExtService.updateBatchById(artifactExts);
      needReduceAssnumberLink = this.numberLinkService.listByIds(numberLinks.stream().map(MesBuildingTaskNumberLink::getId).collect(Collectors.toList()));
      List<MesBuildingTaskNumberLink> assembleNumberLinksWithId = needReduceAssnumberLink.stream().filter(s -> s.getAssembleId() != null).collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(assembleNumberLinksWithId)) {
         this.reduceProduct(assTaskIds, assTaskReduceMap, assNumberInfors, assIds, TaskTypeEnum.ASSEMBLE.getType(), projectId);
         if (CollectionUtils.isNotEmpty(needReduceAssnumberLink)) {
            Map<Long, Integer> assReduceUseMap = needReduceAssnumberLink.stream()
               .filter(MesBuildingTaskNumberLink::getBoolArtifactInproduce)
               .collect(Collectors.toMap(MesBuildingTaskNumberLink::getAssembleId, s -> 1, Integer::sum));
            Map<Long, Integer> assReduceProduceMap = needReduceAssnumberLink.stream()
               .filter(MesBuildingTaskNumberLink::getBoolAssembleComplete)
               .collect(Collectors.toMap(MesBuildingTaskNumberLink::getAssembleId, s -> 1, Integer::sum));
            List<TechAssemble> assembleList = this.assembleService.listByIds(assIds);
            assembleList.forEach(
               assemble -> assemble.setProducedQuantity(assemble.getProducedQuantity() - assReduceProduceMap.getOrDefault(assemble.getId(), 0))
            );
            assembleList.forEach(assemble -> assemble.setUsedQuantity(assemble.getUsedQuantity() - assReduceUseMap.getOrDefault(assemble.getId(), 0)));
            Preconditions.checkArgument(assembleList.stream().allMatch(s -> s.getQuantity() - s.getProducedQuantity() >= 0), "操作失败!!!!");
            this.assembleService.updateBatchById(assembleList);
         }

         List<TechAssembleExt> assembleExts = this.assembleExtService.listAssExt(assNumberInfors);
         assembleExts = assembleExts.stream().map(s -> s.setBoolTask(Boolean.FALSE).setTaskId(0L)).collect(Collectors.toList());
         this.assembleExtService.updateBatchById(assembleExts);
      }

      this.numberLinkService.removeByIds(needReduceAssnumberLink.stream().map(MesBuildingTaskNumberLink::getId).collect(Collectors.toList()));
      this.removePartTasks(needReduceAssnumberLink, artifactProduceTeamReports);
   }

   private void removePartTasks(List<MesBuildingTaskNumberLink> needReduceAssnumberLink, List<MesBuildingProduceTeamReport> artifactProduceTeamReports) {
      Map<String, TechArtifactMachinePartLink> artifactMachinePartLinkMap = new HashMap<>();
      Map<Long, TechMachinePart> partMap = new HashMap<>();
      Map<Long, TechMachinePart> webPartMap = new HashMap<>();
      Map<String, TechAssembleMachinePartLink> assembleMachinePartLinkMap = new HashMap<>();
      List<Long> artifactTaskIds = needReduceAssnumberLink.stream().map(MesBuildingTaskNumberLink::getArtifactTaskId).distinct().collect(Collectors.toList());
      List<Long> artifactIds = needReduceAssnumberLink.stream().map(MesBuildingTaskNumberLink::getArtifactId).distinct().collect(Collectors.toList());
      List<Long> assembleTaskIds = needReduceAssnumberLink.stream().map(MesBuildingTaskNumberLink::getAssembleTaskId).distinct().collect(Collectors.toList());
      List<Long> assemblIds = needReduceAssnumberLink.stream().map(MesBuildingTaskNumberLink::getAssembleId).distinct().collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(artifactIds)) {
         List<TechArtifactMachinePartLink> machinePartLinkList = this.artifactMachinePartLinkService
            .list((Wrapper<TechArtifactMachinePartLink>)new LambdaQueryWrapper<TechArtifactMachinePartLink>().in(TechArtifactMachinePartLink::getArtifactId, artifactIds));
         if (CollectionUtils.isNotEmpty(machinePartLinkList)) {
            artifactMachinePartLinkMap = machinePartLinkList.stream()
               .collect(Collectors.toMap(e -> e.getArtifactId() + "-" + e.getMachinePartId(), Function.identity()));
            partMap = this.machinePartService
               .listByIds(machinePartLinkList.stream().map(TechArtifactMachinePartLink::getMachinePartId).collect(Collectors.toList()))
               .stream()
               .collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
         }
      }

      if (CollectionUtils.isNotEmpty(assemblIds)) {
         List<TechAssembleMachinePartLink> assembleMachinePartLinks = this.assembleMachinePartLinkService
            .list((Wrapper<TechAssembleMachinePartLink>)new LambdaQueryWrapper<TechAssembleMachinePartLink>().in(TechAssembleMachinePartLink::getAssembleId, assemblIds));
         if (CollectionUtils.isNotEmpty(assembleMachinePartLinks)) {
            assembleMachinePartLinkMap = assembleMachinePartLinks.stream()
               .collect(Collectors.toMap(e -> e.getAssembleId() + "-" + e.getMachinePartId(), Function.identity()));
            webPartMap = this.machinePartService
               .listByIds(assembleMachinePartLinks.stream().map(TechAssembleMachinePartLink::getMachinePartId).collect(Collectors.toList()))
               .stream()
               .collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
         }
      }

      if (CollectionUtils.isNotEmpty(artifactTaskIds)) {
         Map<Long, List<MesBuildingTaskNumberLink>> artifactTaskNumberLinkMap = needReduceAssnumberLink.stream()
            .filter(e -> e.getArtifactTaskId() != null)
            .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactTaskId));
         this.extractedArtifact(artifactTaskIds, artifactTaskNumberLinkMap, artifactMachinePartLinkMap, partMap, artifactProduceTeamReports);
      }

      if (CollectionUtils.isNotEmpty(assembleTaskIds)) {
         Map<Long, List<MesBuildingTaskNumberLink>> assembleAskNumberLinkMap = needReduceAssnumberLink.stream()
            .filter(e -> e.getAssembleTaskId() != null)
            .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getAssembleTaskId));
         this.extractedAssemble(assembleTaskIds, assembleAskNumberLinkMap, assembleMachinePartLinkMap, webPartMap);
      }
   }

   private void extractedAssemble(
      List<Long> assembleTaskIds,
      Map<Long, List<MesBuildingTaskNumberLink>> artifactTaskNumberLinkMap,
      Map<String, TechAssembleMachinePartLink> assembleMachinePartLinkMap,
      Map<Long, TechMachinePart> webPartMap
   ) {
      Map<Long, List<MesBuildingMachinePartSchedulingArtifactTaskLink>> schedulingArtifactTaskLinkMap = new HashMap<>();
      Map<Long, MesBuildingMachinePartSchedulingLink> mesBuildingMachinePartSchedulingLinkMap = new HashMap<>();
      Map<Long, MesBuildingMachinePartScheduling> machinePartSchedulingMap = new HashMap<>();
      Map<Long, MesBuildingNestCutPlate> nestCutPlateMap = new HashMap<>();
      Map<String, MesBuildingNestCutPlatePart> nestCutPlatePartMap = new HashMap<>();
      Map<Long, MesBuildingTaskOrder> partTaskOrderMap = new HashMap<>();
      Map<String, List<MesBuildingMachinePartSeparate>> machinePartSeparateMap = new HashMap<>();
      Map<String, MesBuildingTask> partTaskMap = new HashMap<>();
      Map<Long, List<MesBuildingTaskProcess>> partTaskProcessMap = new HashMap<>();
      Map<Long, List<MesBuildingProduceTeamReport>> partProduceTeamReportMap = new HashMap<>();
      Map<Long, List<MesBuildingProduceTeamReportSummary>> produceTeamReportSummaryMap = new HashMap<>();
      Map<String, List<MesBuildingTaskNeedMachinePartSchedulingUnProduction>> taskNeedMachinePartSchedulingUnProductionMap = new HashMap<>();
      List<MesBuildingTaskNeedMachinePartScheduling> artifactNeedMachinePartSchedulings = this.needMachinePartSchedulingService
         .list(
            (Wrapper<MesBuildingTaskNeedMachinePartScheduling>)new LambdaQueryWrapper<MesBuildingTaskNeedMachinePartScheduling>()
               .in(MesBuildingTaskNeedMachinePartScheduling::getTaskId, assembleTaskIds)
         );
      if (CollectionUtils.isNotEmpty(artifactNeedMachinePartSchedulings)) {
         List<MesBuildingMachinePartSchedulingArtifactTaskLink> machinePartSchedulingArtifactTaskLinks = this.partSchedulingArtifactTaskLinkService
            .list(
               (Wrapper<MesBuildingMachinePartSchedulingArtifactTaskLink>)new LambdaQueryWrapper<MesBuildingMachinePartSchedulingArtifactTaskLink>()
                  .in(
                     MesBuildingMachinePartSchedulingArtifactTaskLink::getNeedLinkId,
                     artifactNeedMachinePartSchedulings.stream().map(MesBuildingTaskNeedMachinePartScheduling::getId).collect(Collectors.toList())
                  )
            );
         if (CollectionUtils.isNotEmpty(machinePartSchedulingArtifactTaskLinks)) {
            schedulingArtifactTaskLinkMap = machinePartSchedulingArtifactTaskLinks.stream()
               .collect(Collectors.groupingBy(MesBuildingMachinePartSchedulingArtifactTaskLink::getNeedLinkId));
            mesBuildingMachinePartSchedulingLinkMap = this.machinePartSchedulingLinkService
               .list(
                  (Wrapper<MesBuildingMachinePartSchedulingLink>)new LambdaQueryWrapper<MesBuildingMachinePartSchedulingLink>()
                     .in(
                        MesBuildingMachinePartSchedulingLink::getId,
                        machinePartSchedulingArtifactTaskLinks.stream()
                           .map(MesBuildingMachinePartSchedulingArtifactTaskLink::getSchedulingLinkId)
                           .collect(Collectors.toList())
                     )
               )
               .stream()
               .collect(Collectors.toMap(MesBuildingMachinePartSchedulingLink::getId, Function.identity()));
            machinePartSchedulingMap = this.machinePartSchedulingService
               .listByIds(
                  mesBuildingMachinePartSchedulingLinkMap.values()
                     .stream()
                     .map(MesBuildingMachinePartSchedulingLink::getSchedulingId)
                     .collect(Collectors.toList())
               )
               .stream()
               .collect(Collectors.toMap(MesBuildingMachinePartScheduling::getId, Function.identity()));
            List<MesBuildingNestCutPlate> nestCutPlateList = this.nestCutPlateService
               .list(
                  (Wrapper<MesBuildingNestCutPlate>)new LambdaQueryWrapper<MesBuildingNestCutPlate>()
                     .in(MesBuildingNestCutPlate::getMachinePartSchedulingId, machinePartSchedulingMap.keySet())
               );
            nestCutPlateMap = nestCutPlateList.stream().collect(Collectors.toMap(MesBuildingNestCutPlate::getMachinePartSchedulingId, Function.identity()));
            nestCutPlatePartMap = this.nestCutPlatePartService
               .list(
                  (Wrapper<MesBuildingNestCutPlatePart>)new LambdaQueryWrapper<MesBuildingNestCutPlatePart>()
                     .in(
                        MesBuildingNestCutPlatePart::getMesBuildingNestCutPlateId,
                        nestCutPlateList.stream().map(MesBuildingNestCutPlate::getId).collect(Collectors.toList())
                     )
               )
               .stream()
               .collect(Collectors.toMap(e -> e.getMesBuildingNestCutPlateId() + "-" + e.getPartId(), Function.identity()));
            partTaskOrderMap = this.taskOrderService
               .list(
                  (Wrapper<MesBuildingTaskOrder>)(new LambdaQueryWrapper<MesBuildingTaskOrder>()
                        .eq(MesBuildingTaskOrder::getTaskTypeEnum, TaskTypeEnum.MACHINE_PART.getType()))
                     .in(MesBuildingTaskOrder::getSchedulingId, machinePartSchedulingMap.keySet())
               )
               .stream()
               .collect(Collectors.toMap(MesBuildingTaskOrder::getId, Function.identity()));
            machinePartSeparateMap = this.machinePartSeparateService
               .list(
                  (Wrapper<MesBuildingMachinePartSeparate>)new LambdaQueryWrapper<MesBuildingMachinePartSeparate>()
                     .in(MesBuildingMachinePartSeparate::getTaskOrderId, partTaskOrderMap.keySet())
               )
               .stream()
               .collect(Collectors.groupingBy(e -> e.getSchedulingId() + "-" + e.getTaskOrderId() + "-" + e.getTaskId() + "-" + e.getProductId()));
            partTaskMap = this.taskService
               .list(
                  (Wrapper<MesBuildingTask>)(new LambdaQueryWrapper<MesBuildingTask>().in(MesBuildingTask::getTaskOrderId, partTaskOrderMap.keySet()))
                     .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.MACHINE_PART.getType())
               )
               .stream()
               .collect(Collectors.toMap(e -> e.getMachinePartSchedulingId() + "-" + e.getProductId(), Function.identity()));
            partTaskProcessMap = this.taskProcessService
               .list((Wrapper<MesBuildingTaskProcess>)new LambdaQueryWrapper<MesBuildingTaskProcess>().in(MesBuildingTaskProcess::getTaskOrderId, partTaskOrderMap.keySet()))
               .stream()
               .collect(Collectors.groupingBy(MesBuildingTaskProcess::getTaskId));
            partProduceTeamReportMap = this.mesBuildingProduceTeamReportService
               .list(
                  (Wrapper<MesBuildingProduceTeamReport>)new LambdaQueryWrapper<MesBuildingProduceTeamReport>()
                     .in(MesBuildingProduceTeamReport::getTaskId, partTaskMap.values().stream().map(MesBuildingTask::getId).collect(Collectors.toList()))
               )
               .stream()
               .collect(Collectors.groupingBy(MesBuildingProduceTeamReport::getTaskProcessId));
            produceTeamReportSummaryMap = this.produceTeamReportSummaryService
               .list(
                  (Wrapper<MesBuildingProduceTeamReportSummary>)new LambdaQueryWrapper<MesBuildingProduceTeamReportSummary>()
                     .in(MesBuildingProduceTeamReportSummary::getTaskId, partTaskMap.values().stream().map(MesBuildingTask::getId).collect(Collectors.toList()))
               )
               .stream()
               .collect(Collectors.groupingBy(MesBuildingProduceTeamReportSummary::getTaskProcessId));
         }

         taskNeedMachinePartSchedulingUnProductionMap = this.taskNeedMachinePartSchedulingUnProductionService
            .list(
               (Wrapper<MesBuildingTaskNeedMachinePartSchedulingUnProduction>)new LambdaQueryWrapper<MesBuildingTaskNeedMachinePartSchedulingUnProduction>()
                  .in(
                     MesBuildingTaskNeedMachinePartSchedulingUnProduction::getTaskId,
                     artifactNeedMachinePartSchedulings.stream().map(MesBuildingTaskNeedMachinePartScheduling::getTaskId).collect(Collectors.toList())
                  )
            )
            .stream()
            .collect(Collectors.groupingBy(e -> e.getTaskId() + "-" + e.getProductId()));
         Map<String, List<MesBuildingTaskNeedMachinePartScheduling>> taskNeedMachinePartSchedulingMap = artifactNeedMachinePartSchedulings.stream()
            .collect(Collectors.groupingBy(e -> e.getTaskId() + "-" + e.getProductId()));
         Map<String, List<MesBuildingTaskNeedMachinePartSchedulingUnProduction>> finalTaskNeedMachinePartSchedulingUnProductionMap = taskNeedMachinePartSchedulingUnProductionMap;
         Map<Long, List<MesBuildingMachinePartSchedulingArtifactTaskLink>> finalSchedulingArtifactTaskLinkMap = schedulingArtifactTaskLinkMap;
         Map<Long, MesBuildingMachinePartSchedulingLink> finalMesBuildingMachinePartSchedulingLinkMap = mesBuildingMachinePartSchedulingLinkMap;
         Map<Long, MesBuildingNestCutPlate> finalNestCutPlateMap = nestCutPlateMap;
         Map<String, MesBuildingTask> finalPartTaskMap = partTaskMap;
         Map<String, MesBuildingNestCutPlatePart> finalNestCutPlatePartMap = nestCutPlatePartMap;
         Map<Long, MesBuildingTaskOrder> finalPartTaskOrderMap = partTaskOrderMap;
         Map<Long, MesBuildingMachinePartScheduling> finalMachinePartSchedulingMap = machinePartSchedulingMap;
         Map<String, List<MesBuildingMachinePartSeparate>> finalMachinePartSeparateMap = machinePartSeparateMap;
         Map<Long, List<MesBuildingTaskProcess>> finalPartTaskProcessMap = partTaskProcessMap;
         Map<Long, List<MesBuildingProduceTeamReport>> finalPartProduceTeamReportMap = partProduceTeamReportMap;
         Map<Long, List<MesBuildingProduceTeamReportSummary>> finalProduceTeamReportSummaryMap = produceTeamReportSummaryMap;
         taskNeedMachinePartSchedulingMap.forEach(
            (taskAndProductId, artifactNeedMachinePartSchedulingList) -> {
               Long artifactTaskId = Long.valueOf(taskAndProductId.split("-")[0]);
               Long partProductId = Long.valueOf(taskAndProductId.split("-")[1]);
               List<MesBuildingTaskNumberLink> artifactTskNumberLinkList = artifactTaskNumberLinkMap.get(artifactTaskId);
               if (!CollectionUtils.isEmpty(artifactTskNumberLinkList)) {
                  Long artifactId = artifactTskNumberLinkList.get(0).getAssembleId();
                  Integer artifactQuantity = Math.toIntExact(
                     artifactTskNumberLinkList.stream().map(MesBuildingTaskNumberLink::getAssembleNumber).distinct().count()
                  );
                  TechAssembleMachinePartLink machinePartLink = assembleMachinePartLinkMap.get(artifactId + "-" + partProductId);
                  int totalNeedQuantity = artifactNeedMachinePartSchedulingList.stream()
                     .mapToInt(MesBuildingTaskNeedMachinePartScheduling::getNeedQuantity)
                     .sum();
                  List<MesBuildingTaskNeedMachinePartSchedulingUnProduction> partSchedulingUnProductions = finalTaskNeedMachinePartSchedulingUnProductionMap.getOrDefault(
                     artifactTaskId + "-" + partProductId, new ArrayList<>()
                  );
                  int totalUnProductionsNeedQuantity = partSchedulingUnProductions.stream()
                     .mapToInt(MesBuildingTaskNeedMachinePartSchedulingUnProduction::getQuantity)
                     .sum();
                  int neeDelArtifactPartQuantity = machinePartLink.getQuantity() * artifactQuantity;
                  int reduceUsedQuantity = machinePartLink.getQuantity() * artifactQuantity;
                  TechMachinePart part = webPartMap.get(partProductId);
                  part.setUsedQuantity(Math.max(part.getUsedQuantity() - reduceUsedQuantity, 0));
                  Preconditions.checkArgument(totalNeedQuantity + totalUnProductionsNeedQuantity >= neeDelArtifactPartQuantity, "操作失败,零件需要排产数据异常!");
                  if (totalUnProductionsNeedQuantity > 0) {
                     for (MesBuildingTaskNeedMachinePartSchedulingUnProduction partSchedulingUnProduction : partSchedulingUnProductions) {
                        if (neeDelArtifactPartQuantity >= partSchedulingUnProduction.getQuantity()) {
                           part.setProducedQuantity(part.getProducedQuantity() - partSchedulingUnProduction.getQuantity());
                           neeDelArtifactPartQuantity -= partSchedulingUnProduction.getQuantity();
                           partSchedulingUnProduction.setQuantity(0);
                        } else {
                           part.setProducedQuantity(part.getProducedQuantity() - partSchedulingUnProduction.getQuantity());
                           partSchedulingUnProduction.setQuantity(partSchedulingUnProduction.getQuantity() - neeDelArtifactPartQuantity);
                           neeDelArtifactPartQuantity = 0;
                        }
                     }
                  }

                  if (neeDelArtifactPartQuantity != 0) {
                     Preconditions.checkArgument(
                        artifactNeedMachinePartSchedulingList.stream()
                           .noneMatch(e -> e.getIssuedToNestingSoftwareStatus().equals(IssuedToNestingSoftwareStatusEnum.ISSUED_IN_PROGRESS.getType())),
                        "存在下发中的零件,请稍后刷新重试!"
                     );

                     for (MesBuildingTaskNeedMachinePartScheduling taskNeedMachinePartScheduling : artifactNeedMachinePartSchedulingList.stream()
                        .sorted(
                           Comparator.comparing(MesBuildingTaskNeedMachinePartScheduling::getSendNestingStatus)
                              .thenComparing(MesBuildingTaskNeedMachinePartScheduling::getIssuedToNestingSoftwareStatus)
                              .thenComparing(MesBuildingTaskNeedMachinePartScheduling::getSchedulingQuantity)
                        )
                        .collect(Collectors.toList())) {
                        int needDelSchedulingQuantity = 0;
                        if (neeDelArtifactPartQuantity > 0
                           && taskNeedMachinePartScheduling.getSchedulingQuantity() == 0
                           && !taskNeedMachinePartScheduling.getSendNestingStatus()
                           && taskNeedMachinePartScheduling.getIssuedToNestingSoftwareStatus()
                              .equals(IssuedToNestingSoftwareStatusEnum.NOT_ISSUED_YET.getType())) {
                           if (neeDelArtifactPartQuantity >= taskNeedMachinePartScheduling.getNeedQuantity()) {
                              neeDelArtifactPartQuantity -= taskNeedMachinePartScheduling.getNeedQuantity();
                              taskNeedMachinePartScheduling.setNeedQuantity(0);
                           } else {
                              taskNeedMachinePartScheduling.setNeedQuantity(taskNeedMachinePartScheduling.getNeedQuantity() - neeDelArtifactPartQuantity);
                              neeDelArtifactPartQuantity = 0;
                           }
                        }

                        if (neeDelArtifactPartQuantity > 0
                           && taskNeedMachinePartScheduling.getSendNestingStatus()
                           && (
                              taskNeedMachinePartScheduling.getIssuedToNestingSoftwareStatus()
                                    .equals(IssuedToNestingSoftwareStatusEnum.NOT_ISSUED_YET.getType())
                                 || taskNeedMachinePartScheduling.getIssuedToNestingSoftwareStatus()
                                    .equals(IssuedToNestingSoftwareStatusEnum.ISSUANCE_FAILED.getType())
                           )) {
                           if (neeDelArtifactPartQuantity >= taskNeedMachinePartScheduling.getNeedQuantity()) {
                              neeDelArtifactPartQuantity -= taskNeedMachinePartScheduling.getNeedQuantity();
                              taskNeedMachinePartScheduling.setNeedQuantity(0);
                              needDelSchedulingQuantity += taskNeedMachinePartScheduling.getSchedulingQuantity();
                              taskNeedMachinePartScheduling.setSchedulingQuantity(0);
                           } else {
                              taskNeedMachinePartScheduling.setNeedQuantity(taskNeedMachinePartScheduling.getNeedQuantity() - neeDelArtifactPartQuantity);
                              taskNeedMachinePartScheduling.setSchedulingQuantity(
                                 taskNeedMachinePartScheduling.getSchedulingQuantity() - neeDelArtifactPartQuantity
                              );
                              needDelSchedulingQuantity += neeDelArtifactPartQuantity;
                              neeDelArtifactPartQuantity = 0;
                           }
                        }

                        if (neeDelArtifactPartQuantity > 0
                           && taskNeedMachinePartScheduling.getIssuedToNestingSoftwareStatus().equals(IssuedToNestingSoftwareStatusEnum.ISSUED.getType())) {
                           if (taskNeedMachinePartScheduling.getSchedulingQuantity() == 0) {
                              if (neeDelArtifactPartQuantity >= taskNeedMachinePartScheduling.getNeedQuantity()) {
                                 neeDelArtifactPartQuantity -= taskNeedMachinePartScheduling.getNeedQuantity();
                                 taskNeedMachinePartScheduling.setNeedQuantity(0);
                              } else {
                                 taskNeedMachinePartScheduling.setNeedQuantity(taskNeedMachinePartScheduling.getNeedQuantity() - neeDelArtifactPartQuantity);
                                 taskNeedMachinePartScheduling.setSchedulingQuantity(
                                    taskNeedMachinePartScheduling.getSchedulingQuantity() - neeDelArtifactPartQuantity
                                 );
                                 needDelSchedulingQuantity += neeDelArtifactPartQuantity;
                                 neeDelArtifactPartQuantity = 0;
                              }
                           }

                           if (taskNeedMachinePartScheduling.getSchedulingQuantity() > 0) {
                              if (neeDelArtifactPartQuantity >= taskNeedMachinePartScheduling.getNeedQuantity()) {
                                 needDelSchedulingQuantity += taskNeedMachinePartScheduling.getSchedulingQuantity();
                                 neeDelArtifactPartQuantity -= taskNeedMachinePartScheduling.getNeedQuantity();
                                 taskNeedMachinePartScheduling.setNeedQuantity(0);
                                 taskNeedMachinePartScheduling.setSchedulingQuantity(0);
                              } else {
                                 taskNeedMachinePartScheduling.setNeedQuantity(taskNeedMachinePartScheduling.getNeedQuantity() - neeDelArtifactPartQuantity);
                                 int needReduceSchedulingQuantity = taskNeedMachinePartScheduling.getSchedulingQuantity() <= neeDelArtifactPartQuantity
                                    ? taskNeedMachinePartScheduling.getSchedulingQuantity()
                                    : neeDelArtifactPartQuantity;
                                 taskNeedMachinePartScheduling.setSchedulingQuantity(
                                    taskNeedMachinePartScheduling.getSchedulingQuantity() - needReduceSchedulingQuantity
                                 );
                                 needDelSchedulingQuantity += needReduceSchedulingQuantity;
                                 neeDelArtifactPartQuantity = 0;
                              }
                           }
                        }

                        if (needDelSchedulingQuantity > 0) {
                           List<MesBuildingMachinePartSchedulingArtifactTaskLink> partSchedulingArtifactTaskLinks = finalSchedulingArtifactTaskLinkMap.get(
                              taskNeedMachinePartScheduling.getId()
                           );
                           Preconditions.checkArgument(CollectionUtils.isNotEmpty(partSchedulingArtifactTaskLinks), "操作失败,零件排产数据异常!");
                           int sum = partSchedulingArtifactTaskLinks.stream().mapToInt(MesBuildingMachinePartSchedulingArtifactTaskLink::getQuantity).sum();
                           Preconditions.checkArgument(sum >= needDelSchedulingQuantity, "操作失败,零件相关任务删除后数量不可为负数!");

                           for (MesBuildingMachinePartSchedulingArtifactTaskLink artifactPartTaskLink : partSchedulingArtifactTaskLinks) {
                              if (artifactPartTaskLink.getQuantity() != 0) {
                                 MesBuildingTask task = finalPartTaskMap.get(
                                    artifactPartTaskLink.getSchedulingId() + "-" + taskNeedMachinePartScheduling.getProductId()
                                 );
                                 Integer canDelSchedulingQuantity = artifactPartTaskLink.getQuantity() <= needDelSchedulingQuantity
                                    ? artifactPartTaskLink.getQuantity()
                                    : needDelSchedulingQuantity;
                                 needDelSchedulingQuantity -= canDelSchedulingQuantity;
                                 artifactPartTaskLink.setQuantity(artifactPartTaskLink.getQuantity() - canDelSchedulingQuantity);
                                 Preconditions.checkArgument(artifactPartTaskLink.getQuantity() >= 0, "操作失败,零件相关任务删除后数量不可为负数!");
                                 this.partSchedulingArtifactTaskLinkService.updateById(artifactPartTaskLink);
                                 MesBuildingMachinePartSchedulingLink mesBuildingMachinePartSchedulingLink = finalMesBuildingMachinePartSchedulingLinkMap.get(
                                    artifactPartTaskLink.getSchedulingLinkId()
                                 );
                                 Preconditions.checkArgument(mesBuildingMachinePartSchedulingLink != null, "操作失败,零件任务异常!");
                                 mesBuildingMachinePartSchedulingLink.setQuantity(mesBuildingMachinePartSchedulingLink.getQuantity() - canDelSchedulingQuantity);
                                 Preconditions.checkArgument(mesBuildingMachinePartSchedulingLink.getQuantity() >= 0, "操作失败,零件相关任务删除后数量不可为负数!");
                                 this.machinePartSchedulingLinkService.updateById(mesBuildingMachinePartSchedulingLink);
                                 MesBuildingNestCutPlate mesBuildingNestCutPlate = finalNestCutPlateMap.get(
                                    mesBuildingMachinePartSchedulingLink.getSchedulingId()
                                 );
                                 Preconditions.checkArgument(mesBuildingNestCutPlate != null, "零件排产记录不存在!");
                                 MesBuildingNestCutPlatePart mesBuildingNestCutPlatePart = finalNestCutPlatePartMap.get(
                                    mesBuildingNestCutPlate.getId() + "-" + taskNeedMachinePartScheduling.getProductId()
                                 );
                                 mesBuildingNestCutPlatePart.setQuantity(mesBuildingNestCutPlatePart.getQuantity() - canDelSchedulingQuantity);
                                 Preconditions.checkArgument(mesBuildingNestCutPlatePart.getQuantity() >= 0, "操作失败,零件相关任务删除后数量不可为负数!");
                                 if (mesBuildingNestCutPlatePart.getCompleteQuantity() > mesBuildingNestCutPlatePart.getQuantity()) {
                                    mesBuildingNestCutPlatePart.setCompleteQuantity(mesBuildingNestCutPlatePart.getQuantity());
                                 }

                                 this.nestCutPlatePartService.updateById(mesBuildingNestCutPlatePart);
                                 task.setTaskQuantity(task.getTaskQuantity() - canDelSchedulingQuantity);
                                 Preconditions.checkArgument(task.getTaskQuantity() >= 0, "操作失败,零件相关任务删除后数量不可为负数!");
                                 if (task.getTaskQuantity() < task.getCompleteQuantity()) {
                                    int partDelQuantity = task.getCompleteQuantity() - task.getTaskQuantity();
                                    task.setCompleteQuantity(task.getTaskQuantity());
                                    if (task.getInProductionQuantity() > task.getCompleteQuantity()) {
                                       task.setInProductionQuantity(task.getCompleteQuantity());
                                    }

                                    part.setProducedQuantity(part.getProducedQuantity() - partDelQuantity);
                                    Preconditions.checkArgument(part.getProducedQuantity() >= 0, "操作失败,零件相关任务删除后数量不可为负数!");
                                 }

                                 this.taskService.updateById(task);
                                 MesBuildingTaskOrder order = finalPartTaskOrderMap.get(task.getTaskOrderId());
                                 order.setQuantity(order.getQuantity() - canDelSchedulingQuantity);
                                 Preconditions.checkArgument(order.getQuantity() >= 0, "操作失败,零件相关任务删除后数量不可为负数!");
                                 this.taskOrderService.updateById(order);
                                 MesBuildingMachinePartScheduling partScheduling = finalMachinePartSchedulingMap.get(task.getMachinePartSchedulingId());
                                 Preconditions.checkArgument(partScheduling != null, "操作失败,零件排产表不可为空!");
                                 partScheduling.setQuantity(partScheduling.getQuantity() - canDelSchedulingQuantity);
                                 Preconditions.checkArgument(partScheduling.getQuantity() >= 0, "操作失败,零件相关任务删除后数量不可为负数!");
                                 this.machinePartSchedulingService.updateById(partScheduling);
                                 int canDelSchedulingQuantityV2 = canDelSchedulingQuantity;
                                 List<MesBuildingMachinePartSeparate> mesBuildingMachinePartSeparate = finalMachinePartSeparateMap.get(
                                    artifactPartTaskLink.getSchedulingId() + "-" + order.getId() + "-" + task.getId() + "-" + task.getProductId()
                                 );
                                 if (CollectionUtils.isNotEmpty(mesBuildingMachinePartSeparate)) {
                                    for (MesBuildingMachinePartSeparate partSeparate : mesBuildingMachinePartSeparate) {
                                       if (canDelSchedulingQuantityV2 == 0) {
                                          break;
                                       }

                                       if (partSeparate.getQuantity() >= canDelSchedulingQuantityV2) {
                                          partSeparate.setCunQuantity(partSeparate.getCunQuantity() - canDelSchedulingQuantityV2);
                                          partSeparate.setQuantity(partSeparate.getQuantity() - canDelSchedulingQuantityV2);
                                          canDelSchedulingQuantityV2 = 0;
                                       } else if (canDelSchedulingQuantityV2 > 0) {
                                          canDelSchedulingQuantityV2 -= partSeparate.getQuantity();
                                          partSeparate.setCunQuantity(0);
                                          partSeparate.setQuantity(0);
                                       }

                                       this.machinePartSeparateService.updateById(partSeparate);
                                       if (partSeparate.getQuantity() == 0) {
                                          this.machinePartSeparateService.removeById(partSeparate.getId());
                                       }
                                    }
                                 }

                                 for (MesBuildingTaskProcess taskProcess : finalPartTaskProcessMap.get(task.getId())) {
                                    int delCompleteQuantity = 0;
                                    int delSumCompleteQuantity = 0;
                                    taskProcess.setTaskQuantity(taskProcess.getTaskQuantity() - canDelSchedulingQuantity);
                                    Preconditions.checkArgument(taskProcess.getTaskQuantity() >= 0, "操作失败,零件相关任务删除后数量不可为负数!");
                                    if (taskProcess.getNeedQuantity() > taskProcess.getTaskQuantity()) {
                                       taskProcess.setNeedQuantity(taskProcess.getTaskQuantity());
                                       Preconditions.checkArgument(taskProcess.getNeedQuantity() >= 0, "操作失败,零件相关任务删除后数量不可为负数!");
                                    }

                                    if (taskProcess.getNeedQuantity() < taskProcess.getCompleteQuantity()) {
                                       delCompleteQuantity = taskProcess.getCompleteQuantity() - taskProcess.getNeedQuantity();
                                       delSumCompleteQuantity = taskProcess.getCompleteQuantity() - taskProcess.getNeedQuantity();
                                       taskProcess.setCompleteQuantity(taskProcess.getNeedQuantity());
                                       taskProcess.setInspectionQuantity(taskProcess.getCompleteQuantity());
                                       Preconditions.checkArgument(taskProcess.getCompleteQuantity() >= 0, "操作失败,零件相关任务删除后数量不可为负数!");
                                    }

                                    if (delCompleteQuantity > 0) {
                                       for (MesBuildingProduceTeamReport produceTeamReport : finalPartProduceTeamReportMap.get(taskProcess.getId())) {
                                          Integer quantity = produceTeamReport.getQuantity();
                                          if (delCompleteQuantity > produceTeamReport.getQuantity()) {
                                             produceTeamReport.setQuantity(0);
                                             produceTeamReport.setInspectionQuantity(0);
                                          } else {
                                             produceTeamReport.setQuantity(produceTeamReport.getQuantity() - delCompleteQuantity);
                                             produceTeamReport.setInspectionQuantity(produceTeamReport.getInspectionQuantity() - delCompleteQuantity);
                                          }

                                          Preconditions.checkArgument(produceTeamReport.getQuantity() >= 0, "操作失败,零件相关任务删除后数量不可为负数!");
                                          this.mesBuildingProduceTeamReportService.updateById(produceTeamReport);
                                          delCompleteQuantity -= quantity;
                                          if (delCompleteQuantity <= 0) {
                                             break;
                                          }
                                       }

                                       for (MesBuildingProduceTeamReportSummary produceTeamReportSummary : finalProduceTeamReportSummaryMap.get(
                                          taskProcess.getId()
                                       )) {
                                          Integer quantity = produceTeamReportSummary.getQuantity();
                                          produceTeamReportSummary.setQuantity(produceTeamReportSummary.getQuantity() - delSumCompleteQuantity);
                                          produceTeamReportSummary.setInspectionQuantity(
                                             produceTeamReportSummary.getInspectionQuantity() - delSumCompleteQuantity
                                          );
                                          Preconditions.checkArgument(produceTeamReportSummary.getQuantity() >= 0, "操作失败,零件相关任务删除后数量不可为负数!");
                                          this.produceTeamReportSummaryService.updateById(produceTeamReportSummary);
                                          delSumCompleteQuantity -= quantity;
                                          if (delSumCompleteQuantity <= 0) {
                                             break;
                                          }
                                       }
                                    }

                                    this.taskProcessService.updateById(taskProcess);
                                 }

                                 if (needDelSchedulingQuantity <= 0) {
                                    break;
                                 }
                              }
                           }
                        }

                        this.needMachinePartSchedulingService.updateById(taskNeedMachinePartScheduling);
                     }
                  }
               }
            }
         );
      }

      List<MesBuildingTaskNeedMachinePartScheduling> delTaskNeedMachinePartSchedulings = artifactNeedMachinePartSchedulings.stream()
         .filter(e -> e.getNeedQuantity() == 0)
         .collect(Collectors.toList());
      List<MesBuildingMachinePartSchedulingArtifactTaskLink> allPartSchedulingArtifactTaskLinkList = schedulingArtifactTaskLinkMap.values()
         .stream()
         .flatMap(Collection::stream)
         .collect(Collectors.toList());
      List<MesBuildingMachinePartSchedulingArtifactTaskLink> delPartSchedulingArtifactTaskLinkList = allPartSchedulingArtifactTaskLinkList.stream()
         .filter(e -> e.getQuantity() == 0)
         .collect(Collectors.toList());
      List<MesBuildingMachinePartSchedulingLink> delSchedulingLinks = mesBuildingMachinePartSchedulingLinkMap.values()
         .stream()
         .filter(e -> e.getQuantity() == 0)
         .collect(Collectors.toList());
      List<MesBuildingMachinePartScheduling> delSchedulingList = machinePartSchedulingMap.values()
         .stream()
         .filter(e -> e.getQuantity() == 0)
         .collect(Collectors.toList());
      List<MesBuildingNestCutPlatePart> delNestCutPlateParts = nestCutPlatePartMap.values()
         .stream()
         .filter(e -> e.getQuantity() == 0)
         .collect(Collectors.toList());
      List<MesBuildingTaskOrder> delTaskOrderList = partTaskOrderMap.values().stream().filter(e -> e.getQuantity() == 0).collect(Collectors.toList());
      List<MesBuildingTask> delTaskList = partTaskMap.values().stream().filter(e -> e.getTaskQuantity() == 0).collect(Collectors.toList());
      List<MesBuildingTaskProcess> taskProcessList = partTaskProcessMap.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
      List<MesBuildingTaskProcess> delTaskProcesses = taskProcessList.stream().filter(e -> e.getTaskQuantity() == 0).collect(Collectors.toList());
      List<MesBuildingProduceTeamReport> allReports = partProduceTeamReportMap.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
      List<MesBuildingProduceTeamReport> delreports = allReports.stream().filter(e -> e.getQuantity() == 0).collect(Collectors.toList());
      List<MesBuildingProduceTeamReportSummary> allReportSums = produceTeamReportSummaryMap.values()
         .stream()
         .flatMap(Collection::stream)
         .collect(Collectors.toList());
      List<MesBuildingProduceTeamReportSummary> delreportSums = allReportSums.stream().filter(e -> e.getQuantity() == 0).collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(delTaskNeedMachinePartSchedulings)) {
         this.needMachinePartSchedulingService
            .removeByIds(delTaskNeedMachinePartSchedulings.stream().map(MesBuildingTaskNeedMachinePartScheduling::getId).collect(Collectors.toList()));
      }

      if (CollectionUtils.isNotEmpty(delPartSchedulingArtifactTaskLinkList)) {
         this.partSchedulingArtifactTaskLinkService
            .removeByIds(
               delPartSchedulingArtifactTaskLinkList.stream().map(MesBuildingMachinePartSchedulingArtifactTaskLink::getId).collect(Collectors.toList())
            );
      }

      if (CollectionUtils.isNotEmpty(delSchedulingLinks)) {
         this.machinePartSchedulingLinkService
            .removeByIds(delSchedulingLinks.stream().map(MesBuildingMachinePartSchedulingLink::getId).collect(Collectors.toList()));
      }

      if (CollectionUtils.isNotEmpty(delSchedulingList)) {
         for (MesBuildingMachinePartScheduling partScheduling : delSchedulingList) {
            MesBuildingNestCutPlate mesBuildingNestCutPlate = nestCutPlateMap.get(partScheduling.getId());
            this.nestCutPlateService.removeById(mesBuildingNestCutPlate);
         }

         this.machinePartSchedulingService.removeByIds(delSchedulingList.stream().map(MesBuildingMachinePartScheduling::getId).collect(Collectors.toList()));
      }

      if (CollectionUtils.isNotEmpty(delNestCutPlateParts)) {
         this.nestCutPlatePartService.removeByIds(delNestCutPlateParts.stream().map(MesBuildingNestCutPlatePart::getId).collect(Collectors.toList()));
      }

      if (CollectionUtils.isNotEmpty(delTaskOrderList)) {
         this.taskOrderService.removeByIds(delTaskOrderList.stream().map(MesBuildingTaskOrder::getId).collect(Collectors.toList()));
      }

      if (CollectionUtils.isNotEmpty(delTaskList)) {
         this.taskService.removeByIds(delTaskList.stream().map(MesBuildingTask::getId).collect(Collectors.toList()));
      }

      if (CollectionUtils.isNotEmpty(delTaskProcesses)) {
         this.taskProcessService.removeByIds(delTaskProcesses.stream().map(MesBuildingTaskProcess::getId).collect(Collectors.toList()));
      }

      if (CollectionUtils.isNotEmpty(delreports)) {
         this.mesBuildingProduceTeamReportService.removeByIds(delreports.stream().map(MesBuildingProduceTeamReport::getId).collect(Collectors.toList()));
      }

      if (CollectionUtils.isNotEmpty(delreportSums)) {
         this.produceTeamReportSummaryService.removeByIds(delreportSums.stream().map(MesBuildingProduceTeamReportSummary::getId).collect(Collectors.toList()));
      }

      if (CollectionUtils.isNotEmpty(taskNeedMachinePartSchedulingUnProductionMap)) {
         List<MesBuildingTaskNeedMachinePartSchedulingUnProduction> taskNeedMachinePartSchedulingUnProductions = taskNeedMachinePartSchedulingUnProductionMap.values()
            .stream()
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
         List<MesBuildingTaskNeedMachinePartSchedulingUnProduction> delTaskNeedMachinePartSchedulingUnProductions = taskNeedMachinePartSchedulingUnProductions.stream()
            .filter(e -> e.getQuantity() == 0)
            .collect(Collectors.toList());
         List<MesBuildingTaskNeedMachinePartSchedulingUnProduction> updateTaskNeedMachinePartSchedulingUnProductions = taskNeedMachinePartSchedulingUnProductions.stream()
            .filter(e -> e.getQuantity() != 0)
            .collect(Collectors.toList());
         this.taskNeedMachinePartSchedulingUnProductionService.updateBatchById(updateTaskNeedMachinePartSchedulingUnProductions);
         this.taskNeedMachinePartSchedulingUnProductionService
            .removeByIds(
               delTaskNeedMachinePartSchedulingUnProductions.stream()
                  .map(MesBuildingTaskNeedMachinePartSchedulingUnProduction::getId)
                  .collect(Collectors.toList())
            );
      }

      this.machinePartService.updateBatchById(webPartMap.values());
   }

   private void extractedArtifact(
      List<Long> artifactTaskIds,
      Map<Long, List<MesBuildingTaskNumberLink>> artifactTaskNumberLinkMap,
      Map<String, TechArtifactMachinePartLink> artifactMachinePartLinkMap,
      Map<Long, TechMachinePart> partMap,
      List<MesBuildingProduceTeamReport> artifactProduceTeamReports
   ) {
      Map<Long, List<MesBuildingMachinePartSchedulingArtifactTaskLink>> schedulingArtifactTaskLinkMap = new HashMap<>();
      Map<Long, MesBuildingMachinePartSchedulingLink> mesBuildingMachinePartSchedulingLinkMap = new HashMap<>();
      Map<Long, MesBuildingMachinePartScheduling> machinePartSchedulingMap = new HashMap<>();
      Map<Long, MesBuildingNestCutPlate> nestCutPlateMap = new HashMap<>();
      Map<String, MesBuildingNestCutPlatePart> nestCutPlatePartMap = new HashMap<>();
      Map<Long, MesBuildingTaskOrder> partTaskOrderMap = new HashMap<>();
      Map<String, List<MesBuildingMachinePartSeparate>> machinePartSeparateMap = new HashMap<>();
      Map<String, MesBuildingTask> partTaskMap = new HashMap<>();
      Map<Long, List<MesBuildingTaskProcess>> partTaskProcessMap = new HashMap<>();
      Map<Long, List<MesBuildingProduceTeamReport>> partProduceTeamReportMap = new HashMap<>();
      Map<Long, List<MesBuildingProduceTeamReportSummary>> produceTeamReportSummaryMap = new HashMap<>();
      Map<String, List<MesBuildingProduceTeamReport>> produceTeamReportNumberMap = new HashMap<>();
      Map<String, List<MesBuildingTaskNeedMachinePartSchedulingUnProduction>> taskNeedMachinePartSchedulingUnProductionMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(artifactProduceTeamReports)) {
         produceTeamReportNumberMap = artifactProduceTeamReports.stream().collect(Collectors.groupingBy(e -> e.getProductId() + "-" + e.getNumber()));
      }

      List<MesBuildingTaskNeedMachinePartScheduling> artifactNeedMachinePartSchedulings = this.needMachinePartSchedulingService
         .list(
            (Wrapper<MesBuildingTaskNeedMachinePartScheduling>)new LambdaQueryWrapper<MesBuildingTaskNeedMachinePartScheduling>()
               .in(MesBuildingTaskNeedMachinePartScheduling::getTaskId, artifactTaskIds)
         );
      if (CollectionUtils.isNotEmpty(artifactNeedMachinePartSchedulings)) {
         List<MesBuildingMachinePartSchedulingArtifactTaskLink> machinePartSchedulingArtifactTaskLinks = this.partSchedulingArtifactTaskLinkService
            .list(
               (Wrapper<MesBuildingMachinePartSchedulingArtifactTaskLink>)new LambdaQueryWrapper<MesBuildingMachinePartSchedulingArtifactTaskLink>()
                  .in(
                     MesBuildingMachinePartSchedulingArtifactTaskLink::getNeedLinkId,
                     artifactNeedMachinePartSchedulings.stream().map(MesBuildingTaskNeedMachinePartScheduling::getId).collect(Collectors.toList())
                  )
            );
         if (CollectionUtils.isNotEmpty(machinePartSchedulingArtifactTaskLinks)) {
            schedulingArtifactTaskLinkMap = machinePartSchedulingArtifactTaskLinks.stream()
               .collect(Collectors.groupingBy(MesBuildingMachinePartSchedulingArtifactTaskLink::getNeedLinkId));
            mesBuildingMachinePartSchedulingLinkMap = this.machinePartSchedulingLinkService
               .list(
                  (Wrapper<MesBuildingMachinePartSchedulingLink>)new LambdaQueryWrapper<MesBuildingMachinePartSchedulingLink>()
                     .in(
                        MesBuildingMachinePartSchedulingLink::getId,
                        machinePartSchedulingArtifactTaskLinks.stream()
                           .map(MesBuildingMachinePartSchedulingArtifactTaskLink::getSchedulingLinkId)
                           .collect(Collectors.toList())
                     )
               )
               .stream()
               .collect(Collectors.toMap(MesBuildingMachinePartSchedulingLink::getId, Function.identity()));
            machinePartSchedulingMap = this.machinePartSchedulingService
               .listByIds(
                  mesBuildingMachinePartSchedulingLinkMap.values()
                     .stream()
                     .map(MesBuildingMachinePartSchedulingLink::getSchedulingId)
                     .collect(Collectors.toList())
               )
               .stream()
               .collect(Collectors.toMap(MesBuildingMachinePartScheduling::getId, Function.identity()));
            List<MesBuildingNestCutPlate> nestCutPlateList = this.nestCutPlateService
               .list(
                  (Wrapper<MesBuildingNestCutPlate>)new LambdaQueryWrapper<MesBuildingNestCutPlate>()
                     .in(MesBuildingNestCutPlate::getMachinePartSchedulingId, machinePartSchedulingMap.keySet())
               );
            nestCutPlateMap = nestCutPlateList.stream().collect(Collectors.toMap(MesBuildingNestCutPlate::getMachinePartSchedulingId, Function.identity()));
            nestCutPlatePartMap = this.nestCutPlatePartService
               .list(
                  (Wrapper<MesBuildingNestCutPlatePart>)new LambdaQueryWrapper<MesBuildingNestCutPlatePart>()
                     .in(
                        MesBuildingNestCutPlatePart::getMesBuildingNestCutPlateId,
                        nestCutPlateList.stream().map(MesBuildingNestCutPlate::getId).collect(Collectors.toList())
                     )
               )
               .stream()
               .collect(Collectors.toMap(e -> e.getMesBuildingNestCutPlateId() + "-" + e.getPartId(), Function.identity()));
            partTaskOrderMap = this.taskOrderService
               .list(
                  (Wrapper<MesBuildingTaskOrder>)(new LambdaQueryWrapper<MesBuildingTaskOrder>()
                        .eq(MesBuildingTaskOrder::getTaskTypeEnum, TaskTypeEnum.MACHINE_PART.getType()))
                     .in(MesBuildingTaskOrder::getSchedulingId, machinePartSchedulingMap.keySet())
               )
               .stream()
               .collect(Collectors.toMap(MesBuildingTaskOrder::getId, Function.identity()));
            machinePartSeparateMap = this.machinePartSeparateService
               .list(
                  (Wrapper<MesBuildingMachinePartSeparate>)new LambdaQueryWrapper<MesBuildingMachinePartSeparate>()
                     .in(MesBuildingMachinePartSeparate::getTaskOrderId, partTaskOrderMap.keySet())
               )
               .stream()
               .collect(Collectors.groupingBy(e -> e.getSchedulingId() + "-" + e.getTaskOrderId() + "-" + e.getTaskId() + "-" + e.getProductId()));
            partTaskMap = this.taskService
               .list(
                  (Wrapper<MesBuildingTask>)(new LambdaQueryWrapper<MesBuildingTask>().in(MesBuildingTask::getTaskOrderId, partTaskOrderMap.keySet()))
                     .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.MACHINE_PART.getType())
               )
               .stream()
               .collect(Collectors.toMap(e -> e.getMachinePartSchedulingId() + "-" + e.getProductId(), Function.identity()));
            partTaskProcessMap = this.taskProcessService
               .list((Wrapper<MesBuildingTaskProcess>)new LambdaQueryWrapper<MesBuildingTaskProcess>().in(MesBuildingTaskProcess::getTaskOrderId, partTaskOrderMap.keySet()))
               .stream()
               .collect(Collectors.groupingBy(MesBuildingTaskProcess::getTaskId));
            partProduceTeamReportMap = this.mesBuildingProduceTeamReportService
               .list(
                  (Wrapper<MesBuildingProduceTeamReport>)new LambdaQueryWrapper<MesBuildingProduceTeamReport>()
                     .in(MesBuildingProduceTeamReport::getTaskId, partTaskMap.values().stream().map(MesBuildingTask::getId).collect(Collectors.toList()))
               )
               .stream()
               .collect(Collectors.groupingBy(MesBuildingProduceTeamReport::getTaskProcessId));
            produceTeamReportSummaryMap = this.produceTeamReportSummaryService
               .list(
                  (Wrapper<MesBuildingProduceTeamReportSummary>)new LambdaQueryWrapper<MesBuildingProduceTeamReportSummary>()
                     .in(MesBuildingProduceTeamReportSummary::getTaskId, partTaskMap.values().stream().map(MesBuildingTask::getId).collect(Collectors.toList()))
               )
               .stream()
               .collect(Collectors.groupingBy(MesBuildingProduceTeamReportSummary::getTaskProcessId));
         }

         taskNeedMachinePartSchedulingUnProductionMap = this.taskNeedMachinePartSchedulingUnProductionService
            .list(
               (Wrapper<MesBuildingTaskNeedMachinePartSchedulingUnProduction>)new LambdaQueryWrapper<MesBuildingTaskNeedMachinePartSchedulingUnProduction>()
                  .in(
                     MesBuildingTaskNeedMachinePartSchedulingUnProduction::getTaskId,
                     artifactNeedMachinePartSchedulings.stream().map(MesBuildingTaskNeedMachinePartScheduling::getTaskId).collect(Collectors.toList())
                  )
            )
            .stream()
            .collect(Collectors.groupingBy(e -> e.getTaskId() + "-" + e.getProductId()));
         Map<String, List<MesBuildingTaskNeedMachinePartScheduling>> taskNeedMachinePartSchedulingMap = artifactNeedMachinePartSchedulings.stream()
            .collect(Collectors.groupingBy(e -> e.getTaskId() + "-" + e.getProductId()));
         Map<String, List<MesBuildingProduceTeamReport>> finalProduceTeamReportNumberMap = produceTeamReportNumberMap;
         Map<Long, List<MesBuildingMachinePartSchedulingArtifactTaskLink>> finalSchedulingArtifactTaskLinkMap = schedulingArtifactTaskLinkMap;
         Map<String, MesBuildingTask> finalPartTaskMap = partTaskMap;
         Map<Long, MesBuildingMachinePartSchedulingLink> finalMesBuildingMachinePartSchedulingLinkMap = mesBuildingMachinePartSchedulingLinkMap;
         Map<Long, MesBuildingNestCutPlate> finalNestCutPlateMap = nestCutPlateMap;
         Map<String, MesBuildingNestCutPlatePart> finalNestCutPlatePartMap = nestCutPlatePartMap;
         Map<Long, MesBuildingTaskOrder> finalPartTaskOrderMap = partTaskOrderMap;
         Map<Long, MesBuildingMachinePartScheduling> finalMachinePartSchedulingMap = machinePartSchedulingMap;
         Map<String, List<MesBuildingMachinePartSeparate>> finalMachinePartSeparateMap = machinePartSeparateMap;
         Map<Long, List<MesBuildingTaskProcess>> finalPartTaskProcessMap = partTaskProcessMap;
         Map<Long, List<MesBuildingProduceTeamReport>> finalPartProduceTeamReportMap = partProduceTeamReportMap;
         Map<Long, List<MesBuildingProduceTeamReportSummary>> finalProduceTeamReportSummaryMap = produceTeamReportSummaryMap;
         Map<String, List<MesBuildingTaskNeedMachinePartSchedulingUnProduction>> finalTaskNeedMachinePartSchedulingUnProductionMap = taskNeedMachinePartSchedulingUnProductionMap;
         taskNeedMachinePartSchedulingMap.forEach(
            (taskAndProductId, artifactNeedMachinePartSchedulingList) -> {
               Long artifactTaskId = Long.valueOf(taskAndProductId.split("-")[0]);
               Long partProductId = Long.valueOf(taskAndProductId.split("-")[1]);
               List<MesBuildingTaskNumberLink> artifactTskNumberLinkList = artifactTaskNumberLinkMap.get(artifactTaskId);
               if (!CollectionUtils.isEmpty(artifactTskNumberLinkList)) {
                  Long artifactId = artifactTskNumberLinkList.get(0).getArtifactId();
                  int artifactNumberSize = (int)artifactTskNumberLinkList.stream()
                     .map(MesBuildingTaskNumberLink::getArtifactNumber)
                     .filter(artifactNumber -> CollectionUtils.isNotEmpty(finalProduceTeamReportNumberMap.get(artifactId + "-" + artifactNumber)))
                     .distinct()
                     .count();
                  Integer artifactQuantity = Math.toIntExact(
                     artifactTskNumberLinkList.stream().map(MesBuildingTaskNumberLink::getArtifactNumber).distinct().count()
                  );
                  TechArtifactMachinePartLink machinePartLink = artifactMachinePartLinkMap.get(artifactId + "-" + partProductId);
                  int totalNeedQuantity = artifactNeedMachinePartSchedulingList.stream()
                     .mapToInt(MesBuildingTaskNeedMachinePartScheduling::getNeedQuantity)
                     .sum();
                  List<MesBuildingTaskNeedMachinePartSchedulingUnProduction> partSchedulingUnProductions = finalTaskNeedMachinePartSchedulingUnProductionMap.getOrDefault(
                     artifactTaskId + "-" + partProductId, new ArrayList<>()
                  );
                  int totalUnProductionsNeedQuantity = partSchedulingUnProductions.stream()
                     .mapToInt(MesBuildingTaskNeedMachinePartSchedulingUnProduction::getQuantity)
                     .sum();
                  int neeDelArtifactPartQuantity = machinePartLink.getQuantity() * artifactQuantity;
                  int partUseQuantity = artifactNumberSize * machinePartLink.getQuantity();
                  TechMachinePart machinePart = partMap.get(partProductId);
                  machinePart.setUsedQuantity(machinePart.getUsedQuantity() - partUseQuantity);
                  Preconditions.checkArgument(totalNeedQuantity + totalUnProductionsNeedQuantity >= neeDelArtifactPartQuantity, "操作失败,零件需要排产数据异常!");
                  if (totalUnProductionsNeedQuantity > 0) {
                     for (MesBuildingTaskNeedMachinePartSchedulingUnProduction partSchedulingUnProduction : partSchedulingUnProductions) {
                        TechMachinePart part = partMap.get(partSchedulingUnProduction.getProductId());
                        if (neeDelArtifactPartQuantity >= partSchedulingUnProduction.getQuantity()) {
                           part.setProducedQuantity(part.getProducedQuantity() - partSchedulingUnProduction.getQuantity());
                           neeDelArtifactPartQuantity -= partSchedulingUnProduction.getQuantity();
                           partSchedulingUnProduction.setQuantity(0);
                        } else {
                           part.setProducedQuantity(part.getProducedQuantity() - partSchedulingUnProduction.getQuantity());
                           partSchedulingUnProduction.setQuantity(partSchedulingUnProduction.getQuantity() - neeDelArtifactPartQuantity);
                           neeDelArtifactPartQuantity = 0;
                        }
                     }
                  }

                  if (neeDelArtifactPartQuantity != 0) {
                     Preconditions.checkArgument(
                        artifactNeedMachinePartSchedulingList.stream()
                           .noneMatch(e -> e.getIssuedToNestingSoftwareStatus().equals(IssuedToNestingSoftwareStatusEnum.ISSUED_IN_PROGRESS.getType())),
                        "存在下发中的零件,请稍后刷新重试!"
                     );

                     for (MesBuildingTaskNeedMachinePartScheduling taskNeedMachinePartScheduling : artifactNeedMachinePartSchedulingList.stream()
                        .sorted(
                           Comparator.comparing(MesBuildingTaskNeedMachinePartScheduling::getSendNestingStatus)
                              .thenComparing(MesBuildingTaskNeedMachinePartScheduling::getIssuedToNestingSoftwareStatus)
                              .thenComparing(MesBuildingTaskNeedMachinePartScheduling::getSchedulingQuantity)
                        )
                        .collect(Collectors.toList())) {
                        int needDelSchedulingQuantity = 0;
                        if (neeDelArtifactPartQuantity > 0
                           && taskNeedMachinePartScheduling.getSchedulingQuantity() == 0
                           && !taskNeedMachinePartScheduling.getSendNestingStatus()
                           && taskNeedMachinePartScheduling.getIssuedToNestingSoftwareStatus()
                              .equals(IssuedToNestingSoftwareStatusEnum.NOT_ISSUED_YET.getType())) {
                           if (neeDelArtifactPartQuantity >= taskNeedMachinePartScheduling.getNeedQuantity()) {
                              neeDelArtifactPartQuantity -= taskNeedMachinePartScheduling.getNeedQuantity();
                              taskNeedMachinePartScheduling.setNeedQuantity(0);
                           } else {
                              taskNeedMachinePartScheduling.setNeedQuantity(taskNeedMachinePartScheduling.getNeedQuantity() - neeDelArtifactPartQuantity);
                              neeDelArtifactPartQuantity = 0;
                           }
                        }

                        if (neeDelArtifactPartQuantity > 0
                           && taskNeedMachinePartScheduling.getSendNestingStatus()
                           && (
                              taskNeedMachinePartScheduling.getIssuedToNestingSoftwareStatus()
                                    .equals(IssuedToNestingSoftwareStatusEnum.NOT_ISSUED_YET.getType())
                                 || taskNeedMachinePartScheduling.getIssuedToNestingSoftwareStatus()
                                    .equals(IssuedToNestingSoftwareStatusEnum.ISSUANCE_FAILED.getType())
                           )) {
                           if (neeDelArtifactPartQuantity >= taskNeedMachinePartScheduling.getNeedQuantity()) {
                              neeDelArtifactPartQuantity -= taskNeedMachinePartScheduling.getNeedQuantity();
                              taskNeedMachinePartScheduling.setNeedQuantity(0);
                              needDelSchedulingQuantity += taskNeedMachinePartScheduling.getSchedulingQuantity();
                              taskNeedMachinePartScheduling.setSchedulingQuantity(0);
                           } else {
                              taskNeedMachinePartScheduling.setNeedQuantity(taskNeedMachinePartScheduling.getNeedQuantity() - neeDelArtifactPartQuantity);
                              taskNeedMachinePartScheduling.setSchedulingQuantity(
                                 taskNeedMachinePartScheduling.getSchedulingQuantity() - neeDelArtifactPartQuantity
                              );
                              needDelSchedulingQuantity += neeDelArtifactPartQuantity;
                              neeDelArtifactPartQuantity = 0;
                           }
                        }

                        if (neeDelArtifactPartQuantity > 0
                           && taskNeedMachinePartScheduling.getIssuedToNestingSoftwareStatus().equals(IssuedToNestingSoftwareStatusEnum.ISSUED.getType())) {
                           if (taskNeedMachinePartScheduling.getSchedulingQuantity() == 0) {
                              if (neeDelArtifactPartQuantity >= taskNeedMachinePartScheduling.getNeedQuantity()) {
                                 neeDelArtifactPartQuantity -= taskNeedMachinePartScheduling.getNeedQuantity();
                                 taskNeedMachinePartScheduling.setNeedQuantity(0);
                              } else {
                                 taskNeedMachinePartScheduling.setNeedQuantity(taskNeedMachinePartScheduling.getNeedQuantity() - neeDelArtifactPartQuantity);
                                 taskNeedMachinePartScheduling.setSchedulingQuantity(
                                    taskNeedMachinePartScheduling.getSchedulingQuantity() - neeDelArtifactPartQuantity
                                 );
                                 needDelSchedulingQuantity += neeDelArtifactPartQuantity;
                                 neeDelArtifactPartQuantity = 0;
                              }
                           }

                           if (taskNeedMachinePartScheduling.getSchedulingQuantity() > 0) {
                              if (neeDelArtifactPartQuantity >= taskNeedMachinePartScheduling.getNeedQuantity()) {
                                 needDelSchedulingQuantity += taskNeedMachinePartScheduling.getSchedulingQuantity();
                                 neeDelArtifactPartQuantity -= taskNeedMachinePartScheduling.getNeedQuantity();
                                 taskNeedMachinePartScheduling.setNeedQuantity(0);
                                 taskNeedMachinePartScheduling.setSchedulingQuantity(0);
                              } else {
                                 taskNeedMachinePartScheduling.setNeedQuantity(taskNeedMachinePartScheduling.getNeedQuantity() - neeDelArtifactPartQuantity);
                                 int needReduceSchedulingQuantity = taskNeedMachinePartScheduling.getSchedulingQuantity() <= neeDelArtifactPartQuantity
                                    ? taskNeedMachinePartScheduling.getSchedulingQuantity()
                                    : neeDelArtifactPartQuantity;
                                 taskNeedMachinePartScheduling.setSchedulingQuantity(
                                    taskNeedMachinePartScheduling.getSchedulingQuantity() - needReduceSchedulingQuantity
                                 );
                                 needDelSchedulingQuantity += needReduceSchedulingQuantity;
                                 neeDelArtifactPartQuantity = 0;
                              }
                           }
                        }

                        if (needDelSchedulingQuantity > 0) {
                           List<MesBuildingMachinePartSchedulingArtifactTaskLink> partSchedulingArtifactTaskLinks = finalSchedulingArtifactTaskLinkMap.get(
                              taskNeedMachinePartScheduling.getId()
                           );
                           Preconditions.checkArgument(CollectionUtils.isNotEmpty(partSchedulingArtifactTaskLinks), "操作失败,零件排产数据异常!");
                           int sum = partSchedulingArtifactTaskLinks.stream().mapToInt(MesBuildingMachinePartSchedulingArtifactTaskLink::getQuantity).sum();
                           Preconditions.checkArgument(sum >= needDelSchedulingQuantity, "操作失败,零件相关任务删除后数量不可为负数!");

                           for (MesBuildingMachinePartSchedulingArtifactTaskLink artifactPartTaskLink : partSchedulingArtifactTaskLinks) {
                              if (artifactPartTaskLink.getQuantity() != 0) {
                                 MesBuildingTask task = finalPartTaskMap.get(
                                    artifactPartTaskLink.getSchedulingId() + "-" + taskNeedMachinePartScheduling.getProductId()
                                 );
                                 Integer canDelSchedulingQuantity = artifactPartTaskLink.getQuantity() <= needDelSchedulingQuantity
                                    ? artifactPartTaskLink.getQuantity()
                                    : needDelSchedulingQuantity;
                                 needDelSchedulingQuantity -= canDelSchedulingQuantity;
                                 artifactPartTaskLink.setQuantity(artifactPartTaskLink.getQuantity() - canDelSchedulingQuantity);
                                 Preconditions.checkArgument(artifactPartTaskLink.getQuantity() >= 0, "操作失败,零件相关任务删除后数量不可为负数!");
                                 this.partSchedulingArtifactTaskLinkService.updateById(artifactPartTaskLink);
                                 MesBuildingMachinePartSchedulingLink mesBuildingMachinePartSchedulingLink = finalMesBuildingMachinePartSchedulingLinkMap.get(
                                    artifactPartTaskLink.getSchedulingLinkId()
                                 );
                                 Preconditions.checkArgument(mesBuildingMachinePartSchedulingLink != null, "操作失败,零件任务异常!");
                                 mesBuildingMachinePartSchedulingLink.setQuantity(mesBuildingMachinePartSchedulingLink.getQuantity() - canDelSchedulingQuantity);
                                 Preconditions.checkArgument(mesBuildingMachinePartSchedulingLink.getQuantity() >= 0, "操作失败,零件相关任务删除后数量不可为负数!");
                                 this.machinePartSchedulingLinkService.updateById(mesBuildingMachinePartSchedulingLink);
                                 MesBuildingNestCutPlate mesBuildingNestCutPlatex = finalNestCutPlateMap.get(
                                    mesBuildingMachinePartSchedulingLink.getSchedulingId()
                                 );
                                 Preconditions.checkArgument(mesBuildingNestCutPlatex != null, "零件排产记录不存在!");
                                 MesBuildingNestCutPlatePart mesBuildingNestCutPlatePart = finalNestCutPlatePartMap.get(
                                    mesBuildingNestCutPlatex.getId() + "-" + taskNeedMachinePartScheduling.getProductId()
                                 );
                                 mesBuildingNestCutPlatePart.setQuantity(mesBuildingNestCutPlatePart.getQuantity() - canDelSchedulingQuantity);
                                 Preconditions.checkArgument(mesBuildingNestCutPlatePart.getQuantity() >= 0, "操作失败,零件相关任务删除后数量不可为负数!");
                                 if (mesBuildingNestCutPlatePart.getCompleteQuantity() > mesBuildingNestCutPlatePart.getQuantity()) {
                                    mesBuildingNestCutPlatePart.setCompleteQuantity(mesBuildingNestCutPlatePart.getQuantity());
                                 }

                                 this.nestCutPlatePartService.updateById(mesBuildingNestCutPlatePart);
                                 task.setTaskQuantity(task.getTaskQuantity() - canDelSchedulingQuantity);
                                 Preconditions.checkArgument(task.getTaskQuantity() >= 0, "操作失败,零件相关任务删除后数量不可为负数!");
                                 TechMachinePart part = partMap.get(task.getProductId());
                                 if (task.getTaskQuantity() < task.getCompleteQuantity()) {
                                    int partDelQuantity = task.getCompleteQuantity() - task.getTaskQuantity();
                                    task.setCompleteQuantity(task.getTaskQuantity());
                                    if (task.getInProductionQuantity() > task.getCompleteQuantity()) {
                                       task.setInProductionQuantity(task.getCompleteQuantity());
                                    }

                                    part.setProducedQuantity(part.getProducedQuantity() - partDelQuantity);
                                    Preconditions.checkArgument(part.getProducedQuantity() >= 0, "操作失败,零件相关任务删除后数量不可为负数!");
                                 }

                                 this.taskService.updateById(task);
                                 MesBuildingTaskOrder order = finalPartTaskOrderMap.get(task.getTaskOrderId());
                                 order.setQuantity(order.getQuantity() - canDelSchedulingQuantity);
                                 Preconditions.checkArgument(order.getQuantity() >= 0, "操作失败,零件相关任务删除后数量不可为负数!");
                                 this.taskOrderService.updateById(order);
                                 MesBuildingMachinePartScheduling partSchedulingx = finalMachinePartSchedulingMap.get(task.getMachinePartSchedulingId());
                                 Preconditions.checkArgument(partSchedulingx != null, "操作失败,零件排产表不可为空!");
                                 partSchedulingx.setQuantity(partSchedulingx.getQuantity() - canDelSchedulingQuantity);
                                 Preconditions.checkArgument(partSchedulingx.getQuantity() >= 0, "操作失败,零件相关任务删除后数量不可为负数!");
                                 this.machinePartSchedulingService.updateById(partSchedulingx);
                                 int canDelSchedulingQuantityV2 = canDelSchedulingQuantity;
                                 List<MesBuildingMachinePartSeparate> mesBuildingMachinePartSeparate = finalMachinePartSeparateMap.get(
                                    artifactPartTaskLink.getSchedulingId() + "-" + order.getId() + "-" + task.getId() + "-" + task.getProductId()
                                 );
                                 if (CollectionUtils.isNotEmpty(mesBuildingMachinePartSeparate)) {
                                    for (MesBuildingMachinePartSeparate partSeparate : mesBuildingMachinePartSeparate) {
                                       if (canDelSchedulingQuantityV2 == 0) {
                                          break;
                                       }

                                       if (partSeparate.getQuantity() >= canDelSchedulingQuantityV2) {
                                          partSeparate.setCunQuantity(partSeparate.getCunQuantity() - canDelSchedulingQuantityV2);
                                          partSeparate.setQuantity(partSeparate.getQuantity() - canDelSchedulingQuantityV2);
                                          canDelSchedulingQuantityV2 = 0;
                                       } else if (canDelSchedulingQuantityV2 > 0) {
                                          canDelSchedulingQuantityV2 -= partSeparate.getQuantity();
                                          partSeparate.setCunQuantity(0);
                                          partSeparate.setQuantity(0);
                                       }

                                       this.machinePartSeparateService.updateById(partSeparate);
                                       if (partSeparate.getQuantity() == 0) {
                                          this.machinePartSeparateService.removeById(partSeparate.getId());
                                       }
                                    }
                                 }

                                 for (MesBuildingTaskProcess taskProcess : finalPartTaskProcessMap.get(task.getId())) {
                                    int delCompleteQuantity = 0;
                                    int delSumCompleteQuantity = 0;
                                    taskProcess.setTaskQuantity(taskProcess.getTaskQuantity() - canDelSchedulingQuantity);
                                    Preconditions.checkArgument(taskProcess.getTaskQuantity() >= 0, "操作失败,零件相关任务删除后数量不可为负数!");
                                    if (taskProcess.getNeedQuantity() > taskProcess.getTaskQuantity()) {
                                       taskProcess.setNeedQuantity(taskProcess.getTaskQuantity());
                                       Preconditions.checkArgument(taskProcess.getNeedQuantity() >= 0, "操作失败,零件相关任务删除后数量不可为负数!");
                                    }

                                    if (taskProcess.getNeedQuantity() < taskProcess.getCompleteQuantity()) {
                                       delCompleteQuantity = taskProcess.getCompleteQuantity() - taskProcess.getNeedQuantity();
                                       delSumCompleteQuantity = taskProcess.getCompleteQuantity() - taskProcess.getNeedQuantity();
                                       taskProcess.setCompleteQuantity(taskProcess.getNeedQuantity());
                                       taskProcess.setInspectionQuantity(taskProcess.getCompleteQuantity());
                                       Preconditions.checkArgument(taskProcess.getCompleteQuantity() >= 0, "操作失败,零件相关任务删除后数量不可为负数!");
                                    }

                                    if (delCompleteQuantity > 0) {
                                       for (MesBuildingProduceTeamReport produceTeamReport : finalPartProduceTeamReportMap.get(taskProcess.getId())) {
                                          Integer quantity = produceTeamReport.getQuantity();
                                          if (delCompleteQuantity > produceTeamReport.getQuantity()) {
                                             produceTeamReport.setQuantity(0);
                                             produceTeamReport.setInspectionQuantity(0);
                                          } else {
                                             produceTeamReport.setQuantity(produceTeamReport.getQuantity() - delCompleteQuantity);
                                             produceTeamReport.setInspectionQuantity(produceTeamReport.getInspectionQuantity() - delCompleteQuantity);
                                          }

                                          Preconditions.checkArgument(produceTeamReport.getQuantity() >= 0, "操作失败,零件相关任务删除后数量不可为负数!");
                                          this.mesBuildingProduceTeamReportService.updateById(produceTeamReport);
                                          delCompleteQuantity -= quantity;
                                          if (delCompleteQuantity <= 0) {
                                             break;
                                          }
                                       }

                                       for (MesBuildingProduceTeamReportSummary produceTeamReportSummary : finalProduceTeamReportSummaryMap.get(
                                          taskProcess.getId()
                                       )) {
                                          Integer quantity = produceTeamReportSummary.getQuantity();
                                          produceTeamReportSummary.setQuantity(produceTeamReportSummary.getQuantity() - delSumCompleteQuantity);
                                          produceTeamReportSummary.setInspectionQuantity(
                                             produceTeamReportSummary.getInspectionQuantity() - delSumCompleteQuantity
                                          );
                                          Preconditions.checkArgument(produceTeamReportSummary.getQuantity() >= 0, "操作失败,零件相关任务删除后数量不可为负数!");
                                          this.produceTeamReportSummaryService.updateById(produceTeamReportSummary);
                                          delSumCompleteQuantity -= quantity;
                                          if (delSumCompleteQuantity <= 0) {
                                             break;
                                          }
                                       }
                                    }

                                    this.taskProcessService.updateById(taskProcess);
                                 }

                                 if (needDelSchedulingQuantity <= 0) {
                                    break;
                                 }
                              }
                           }
                        }

                        this.needMachinePartSchedulingService.updateById(taskNeedMachinePartScheduling);
                     }
                  }
               }
            }
         );
      }

      List<MesBuildingTaskNeedMachinePartScheduling> delTaskNeedMachinePartSchedulings = artifactNeedMachinePartSchedulings.stream()
         .filter(e -> e.getNeedQuantity() == 0)
         .collect(Collectors.toList());
      List<MesBuildingMachinePartSchedulingArtifactTaskLink> allPartSchedulingArtifactTaskLinkList = schedulingArtifactTaskLinkMap.values()
         .stream()
         .flatMap(Collection::stream)
         .collect(Collectors.toList());
      List<MesBuildingMachinePartSchedulingArtifactTaskLink> delPartSchedulingArtifactTaskLinkList = allPartSchedulingArtifactTaskLinkList.stream()
         .filter(e -> e.getQuantity() == 0)
         .collect(Collectors.toList());
      List<MesBuildingMachinePartSchedulingLink> delSchedulingLinks = mesBuildingMachinePartSchedulingLinkMap.values()
         .stream()
         .filter(e -> e.getQuantity() == 0)
         .collect(Collectors.toList());
      List<MesBuildingMachinePartScheduling> delSchedulingList = machinePartSchedulingMap.values()
         .stream()
         .filter(e -> e.getQuantity() == 0)
         .collect(Collectors.toList());
      List<MesBuildingNestCutPlatePart> delNestCutPlateParts = nestCutPlatePartMap.values()
         .stream()
         .filter(e -> e.getQuantity() == 0)
         .collect(Collectors.toList());
      List<MesBuildingTaskOrder> delTaskOrderList = partTaskOrderMap.values().stream().filter(e -> e.getQuantity() == 0).collect(Collectors.toList());
      List<MesBuildingTask> delTaskList = partTaskMap.values().stream().filter(e -> e.getTaskQuantity() == 0).collect(Collectors.toList());
      List<MesBuildingTaskProcess> taskProcessList = partTaskProcessMap.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
      List<MesBuildingTaskProcess> delTaskProcesses = taskProcessList.stream().filter(e -> e.getTaskQuantity() == 0).collect(Collectors.toList());
      List<MesBuildingProduceTeamReport> allReports = partProduceTeamReportMap.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
      List<MesBuildingProduceTeamReport> delreports = allReports.stream().filter(e -> e.getQuantity() == 0).collect(Collectors.toList());
      List<MesBuildingProduceTeamReportSummary> allReportSums = produceTeamReportSummaryMap.values()
         .stream()
         .flatMap(Collection::stream)
         .collect(Collectors.toList());
      List<MesBuildingProduceTeamReportSummary> delreportSums = allReportSums.stream().filter(e -> e.getQuantity() == 0).collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(taskNeedMachinePartSchedulingUnProductionMap)) {
         List<MesBuildingTaskNeedMachinePartSchedulingUnProduction> taskNeedMachinePartSchedulingUnProductions = taskNeedMachinePartSchedulingUnProductionMap.values()
            .stream()
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
         List<MesBuildingTaskNeedMachinePartSchedulingUnProduction> delTaskNeedMachinePartSchedulingUnProductions = taskNeedMachinePartSchedulingUnProductions.stream()
            .filter(e -> e.getQuantity() == 0)
            .collect(Collectors.toList());
         List<MesBuildingTaskNeedMachinePartSchedulingUnProduction> updateTaskNeedMachinePartSchedulingUnProductions = taskNeedMachinePartSchedulingUnProductions.stream()
            .filter(e -> e.getQuantity() != 0)
            .collect(Collectors.toList());
         this.taskNeedMachinePartSchedulingUnProductionService.updateBatchById(updateTaskNeedMachinePartSchedulingUnProductions);
         this.taskNeedMachinePartSchedulingUnProductionService
            .removeByIds(
               delTaskNeedMachinePartSchedulingUnProductions.stream()
                  .map(MesBuildingTaskNeedMachinePartSchedulingUnProduction::getId)
                  .collect(Collectors.toList())
            );
      }

      if (CollectionUtils.isNotEmpty(delTaskNeedMachinePartSchedulings)) {
         this.needMachinePartSchedulingService
            .removeByIds(delTaskNeedMachinePartSchedulings.stream().map(MesBuildingTaskNeedMachinePartScheduling::getId).collect(Collectors.toList()));
      }

      if (CollectionUtils.isNotEmpty(delPartSchedulingArtifactTaskLinkList)) {
         this.partSchedulingArtifactTaskLinkService
            .removeByIds(
               delPartSchedulingArtifactTaskLinkList.stream().map(MesBuildingMachinePartSchedulingArtifactTaskLink::getId).collect(Collectors.toList())
            );
      }

      if (CollectionUtils.isNotEmpty(delSchedulingLinks)) {
         this.machinePartSchedulingLinkService
            .removeByIds(delSchedulingLinks.stream().map(MesBuildingMachinePartSchedulingLink::getId).collect(Collectors.toList()));
      }

      if (CollectionUtils.isNotEmpty(delSchedulingList)) {
         for (MesBuildingMachinePartScheduling partScheduling : delSchedulingList) {
            MesBuildingNestCutPlate mesBuildingNestCutPlate = nestCutPlateMap.get(partScheduling.getId());
            this.nestCutPlateService.removeById(mesBuildingNestCutPlate);
         }

         this.machinePartSchedulingService.removeByIds(delSchedulingList.stream().map(MesBuildingMachinePartScheduling::getId).collect(Collectors.toList()));
      }

      if (CollectionUtils.isNotEmpty(delNestCutPlateParts)) {
         this.nestCutPlatePartService.removeByIds(delNestCutPlateParts.stream().map(MesBuildingNestCutPlatePart::getId).collect(Collectors.toList()));
      }

      if (CollectionUtils.isNotEmpty(delTaskOrderList)) {
         this.taskOrderService.removeByIds(delTaskOrderList.stream().map(MesBuildingTaskOrder::getId).collect(Collectors.toList()));
      }

      if (CollectionUtils.isNotEmpty(delTaskList)) {
         this.taskService.removeByIds(delTaskList.stream().map(MesBuildingTask::getId).collect(Collectors.toList()));
      }

      if (CollectionUtils.isNotEmpty(delTaskProcesses)) {
         this.taskProcessService.removeByIds(delTaskProcesses.stream().map(MesBuildingTaskProcess::getId).collect(Collectors.toList()));
      }

      if (CollectionUtils.isNotEmpty(delreports)) {
         this.mesBuildingProduceTeamReportService.removeByIds(delreports.stream().map(MesBuildingProduceTeamReport::getId).collect(Collectors.toList()));
      }

      if (CollectionUtils.isNotEmpty(delreportSums)) {
         this.produceTeamReportSummaryService.removeByIds(delreportSums.stream().map(MesBuildingProduceTeamReportSummary::getId).collect(Collectors.toList()));
      }

      this.machinePartService.updateBatchById(partMap.values());
   }

   @NotNull
   private Map<Long, Integer> reduceProduct(
      List<Long> taskIds, Map<Long, Integer> taskChangeReduce, List<NumberInfoDTO> numberInfoDTOS, List<Long> productIds, Integer taskType, Long projectId
   ) {
      Map<Long, Integer> productInproduceReduceQuantity = new HashMap<>();
      Map<Long, List<NumberInfoDTO>> numberInfoMap = numberInfoDTOS.stream().collect(Collectors.groupingBy(NumberInfoDTO::getProductId));
      List<NumberInfoDTO> reduceAllSendArt = new ArrayList<>();
      List<MesBuildingTask> tasks = new ArrayList<>();
      Map<Long, MesBuildingTask> taskMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(taskIds)) {
         tasks = this.taskService.listByIds(taskIds);
         taskMap = tasks.stream().collect(Collectors.toMap(MesBuildingTask::getId, Function.identity()));
      }

      if (taskType.equals(TaskTypeEnum.ARTIFACT.getType())) {
         List<TechArtifact> artifacts = this.artifactService.listByIds(productIds);
         List<String> choose = new ArrayList<>();

         for (TechArtifact artifact : artifacts) {
            if (artifact.getBoolAllPartSendDirectly()) {
               for (NumberInfoDTO allSenArt : numberInfoMap.get(artifact.getId())) {
                  String key = allSenArt.getProductId() + "_" + allSenArt.getNumber();
                  if (!choose.contains(key)) {
                     reduceAllSendArt.add(allSenArt);
                     choose.add(key);
                  }
               }
            }
         }

         if (CollectionUtils.isNotEmpty(reduceAllSendArt)) {
            List<MesBuildingSinglePartArtifactPrint> prints = this.singlePartArtifactPrintService.listBydata(reduceAllSendArt);

            for (MesBuildingSinglePartArtifactPrint print : prints) {
               if (print.getBoolAllReport()) {
                  MesBuildingTask task = taskMap.get(print.getTaskId());
                  task.setInProductionQuantity(task.getInProductionQuantity() - 1);
                  Preconditions.checkArgument(task.getInProductionQuantity() >= 0, "操作失败,请联系管理员");
                  task.setCompleteQuantity(task.getCompleteQuantity() - 1);
                  if (Objects.equals(task.getTaskQuantity(), task.getCompleteQuantity())) {
                     task.setCompleteTime(LocalDateTime.now());
                  }

                  productInproduceReduceQuantity.merge(print.getProductId(), 1, Integer::sum);
               }
            }

            Preconditions.checkArgument(prints.size() == reduceAllSendArt.size(), "操作失败!!");
            List<Long> printIds = prints.stream().map(MesBuildingSinglePartArtifactPrint::getId).collect(Collectors.toList());
            this.singlePartArtifactPrintService.removeByIds(printIds);
            List<MesBuildingSinglePartArtifactPrintRecord> records = this.singlePartArtifactPrintRecordService.listBydata(reduceAllSendArt);
            if (CollectionUtils.isNotEmpty(records)) {
               List<Long> recordIds = records.stream().map(MesBuildingSinglePartArtifactPrintRecord::getId).collect(Collectors.toList());
               this.singlePartArtifactPrintRecordService.removeByIds(recordIds);
            }
         }
      }

      Map<Long, Integer> reduceProduceMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(taskIds)) {
         Map<Long, Integer> orderReduceMap = new HashMap<>();
         Map<Long, Integer> topOrderReduceMap = new HashMap<>();

         for (Long taskId : taskIds) {
            MesBuildingTask task = taskMap.get(taskId);
            Integer taskReduceQuantity = taskChangeReduce.get(taskId);
            task.setTaskQuantity(task.getTaskQuantity() - taskReduceQuantity);
            orderReduceMap.merge(task.getTaskOrderId(), taskReduceQuantity, Integer::sum);
            if (task.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
               topOrderReduceMap.merge(task.getTopTaskOrderId(), taskReduceQuantity, Integer::sum);
            }
         }

         List<Long> orderIds = tasks.stream().map(MesBuildingTask::getTaskOrderId).distinct().collect(Collectors.toList());
         List<MesBuildingTaskOrder> orders = this.taskOrderService.listByIds(orderIds);
         List<Long> topOrderIds = tasks.stream().map(MesBuildingTask::getTopTaskOrderId).distinct().collect(Collectors.toList());
         List<MesBuildingTopTaskOrder> topTaskOrders = this.topTaskOrderService.listByIds(topOrderIds);
         List<MesBuildingTaskProcess> taskProcessList = this.taskProcessService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
                  .in(MesBuildingTaskProcess::getTaskId, taskIds)
                  .orderByAsc(MesBuildingTaskProcess::getTaskId)
                  .orderByAsc(MesBuildingTaskProcess::getSequence)
            );
         Map<Long, List<MesBuildingNextProcessLink>> nextProcessLinkMap = this.nextProcessLinkService
            .list(
               (Wrapper<MesBuildingNextProcessLink>)new LambdaQueryWrapper<MesBuildingNextProcessLink>()
                  .in(MesBuildingNextProcessLink::getTaskProcessId, taskProcessList.stream().map(MesBuildingTaskProcess::getId).collect(Collectors.toList()))
            )
            .stream()
            .collect(Collectors.groupingBy(MesBuildingNextProcessLink::getTaskProcessId));
         List<MesBuildingProduceTeamReport> allReports = this.mesBuildingProduceTeamReportService.listReports(numberInfoDTOS, taskType);
         Map<Long, Integer> reportTaskProcessMap = allReports.stream()
            .collect(Collectors.toMap(MesBuildingProduceTeamReport::getTaskProcessId, s -> 1, Integer::sum));
         Map<Long, Integer> inspectTaskProcessMap = allReports.stream()
            .collect(Collectors.toMap(MesBuildingProduceTeamReport::getTaskProcessId, MesBuildingProduceTeamReport::getInspectionQuantity, Integer::sum));
         List<MesBuildingProduceInspectionTeamReport> inspectReports = this.inspectionTeamReportService.listReports(numberInfoDTOS, taskType);
         Map<Long, List<MesBuildingProduceInspectionTeamReport>> artInspectReportTaskProcessMap = inspectReports.stream()
            .collect(Collectors.groupingBy(MesBuildingProduceInspectionTeamReport::getTaskProcessId));
         Integer lastInspectQuantity = 0;

         for (int i = 0; i < taskProcessList.size(); i++) {
            MesBuildingTaskProcess taskProcess = taskProcessList.get(i);
            List<MesBuildingNextProcessLink> mesBuildingNextProcessLinks = nextProcessLinkMap.getOrDefault(taskProcess.getId(), new ArrayList<>());
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(mesBuildingNextProcessLinks) || mesBuildingNextProcessLinks.size() == 1, "操作失败,暂不支持并行工序变更!");
            MesBuildingNextProcessLink nextProcessLink = mesBuildingNextProcessLinks.get(0);
            Integer taskReduceQuantity = taskChangeReduce.get(taskProcess.getTaskId());
            Integer reportQuantity = reportTaskProcessMap.get(taskProcess.getId()) == null ? 0 : reportTaskProcessMap.get(taskProcess.getId());
            Integer inspectQuantity = inspectTaskProcessMap.get(taskProcess.getId()) == null ? 0 : inspectTaskProcessMap.get(taskProcess.getId());
            List<MesBuildingProduceInspectionTeamReport> reports = artInspectReportTaskProcessMap.get(taskProcess.getId()) == null
               ? new ArrayList<>()
               : artInspectReportTaskProcessMap.get(taskProcess.getId());
            int problemQuantity = reports.stream()
               .filter(s -> !s.getBoolAdoptEnum())
               .mapToInt(MesBuildingProduceInspectionTeamReport::getInspectionQuantity)
               .sum();
            taskProcess.setTaskQuantity(taskProcess.getTaskQuantity() - taskReduceQuantity);
            taskProcess.setCompleteQuantity(taskProcess.getCompleteQuantity() - reportQuantity);
            taskProcess.setInspectionQuantity(taskProcess.getInspectionQuantity() - inspectQuantity);
            taskProcess.setProblemQuantity(taskProcess.getProblemQuantity() - problemQuantity);
            if (taskProcess.getSequence().equals(0)) {
               MesBuildingTask task = taskMap.get(taskProcess.getTaskId());
               Preconditions.checkArgument(task.getTaskQuantity() >= 0, "操作失败!!!请刷新页面!!!");
               task.setInProductionQuantity(task.getInProductionQuantity() - reportQuantity);
               Preconditions.checkArgument(task.getInProductionQuantity() >= 0, "操作失败,请联系管理员");
               productInproduceReduceQuantity.merge(taskProcess.getProductId(), reportQuantity, Integer::sum);
               Preconditions.checkArgument(task.getInProductionQuantity() >= 0, "操作失败!!!请刷新页面!!!");
               Preconditions.checkArgument(task.getTaskQuantity() >= task.getInProductionQuantity(), "操作失败!!!请刷新页面!!!");
               taskProcess.setNeedQuantity(taskProcess.getTaskQuantity());
            } else {
               lastInspectQuantity = taskProcessList.get(i - 1).getInspectionQuantity();
               taskProcess.setNeedQuantity(lastInspectQuantity);
            }

            Preconditions.checkArgument(taskProcess.getNeedQuantity() >= 0, "操作失败!!!请刷新页面!!!");
            Preconditions.checkArgument(taskProcess.getTaskQuantity() >= taskProcess.getNeedQuantity(), "操作失败!!!请刷新页面!!!");
            Preconditions.checkArgument(taskProcess.getTaskQuantity() >= 0, "操作失败!!!请刷新页面!!!");
            Preconditions.checkArgument(taskProcess.getCompleteQuantity() >= 0, "操作失败!!!请刷新页面!!!");
            Preconditions.checkArgument(taskProcess.getInspectionQuantity() >= 0, "操作失败!!!请刷新页面!!!");
            Preconditions.checkArgument(taskProcess.getProblemQuantity() >= 0, "操作失败!!!请刷新页面!!!");
            if (nextProcessLink.getNextProcessId() == null) {
               MesBuildingTask task = taskMap.get(taskProcess.getTaskId());
               task.setCompleteQuantity(taskProcess.getInspectionQuantity());
               Preconditions.checkArgument(task.getCompleteQuantity() >= 0, "操作失败!!!请刷新页面!!!");
               Preconditions.checkArgument(task.getTaskQuantity() >= task.getCompleteQuantity(), "操作失败!!!请刷新页面!!!");
               if (task.getTaskQuantity().equals(task.getCompleteQuantity())) {
                  task.setCompleteTime(LocalDateTime.now());
               }
            }
         }

         this.taskProcessService.updateBatchById(taskProcessList);
         List<Long> needRemoveProcessIds = taskProcessList.stream()
            .filter(s -> s.getTaskQuantity().equals(0))
            .map(MesBuildingTaskProcess::getId)
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(needRemoveProcessIds)) {
            this.taskProcessService.removeByIds(needRemoveProcessIds);
         }

         List<MesBuildingTask> updataTasks = new ArrayList<>(taskMap.values());
         this.taskService.updateBatchById(updataTasks);
         List<Long> needRemoveTaskIds = updataTasks.stream()
            .filter(s -> s.getTaskQuantity().equals(0))
            .map(MesBuildingTask::getId)
            .collect(Collectors.toList());
         List<MesBuildingOrderIdAndQuantityDTO> artOrderCompleteList = this.taskOrderService.boolOrderComplete(orderIds);
         Map<Long, Integer> artOrderCompleteMap = artOrderCompleteList.stream()
            .collect(Collectors.toMap(MesBuildingOrderIdAndQuantityDTO::getId, s -> s.getTaskQuantity() - s.getCompleteQuantity()));
         orders = orders.stream()
            .map(s -> s.setCompleteTime(artOrderCompleteMap.get(s.getId()).equals(0) ? LocalDateTime.now() : null))
            .map(s -> s.setQuantity(s.getQuantity() - orderReduceMap.get(s.getId())))
            .collect(Collectors.toList());
         this.taskOrderService.updateBatchById(orders);
         List<Long> needRemoveOrderIds = artOrderCompleteList.stream()
            .filter(s -> s.getTaskQuantity().equals(0))
            .map(MesBuildingOrderIdAndQuantityDTO::getId)
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(needRemoveOrderIds)) {
            this.taskOrderService.removeByIds(needRemoveOrderIds);
            this.orderChangeBiz.deleteOrderChanges(needRemoveOrderIds);
         }

         List<MesBuildingOrderIdAndQuantityDTO> artTopOrderCompleteList = this.topTaskOrderService.boolOrderComplete(topOrderIds);
         Map<Long, Integer> artTopOrderCompleteMap = artTopOrderCompleteList.stream()
            .collect(Collectors.toMap(MesBuildingOrderIdAndQuantityDTO::getId, s -> s.getTaskQuantity() - s.getCompleteQuantity()));
         topTaskOrders = topTaskOrders.stream()
            .map(s -> s.setCompleteTime(artTopOrderCompleteMap.get(s.getId()).equals(0) ? LocalDateTime.now() : null))
            .map(s -> s.setQuantity(s.getQuantity() - topOrderReduceMap.getOrDefault(s.getId(), 0)))
            .collect(Collectors.toList());
         this.topTaskOrderService.updateBatchById(topTaskOrders);
         List<Long> needRemoveTopOrderIds = artTopOrderCompleteList.stream()
            .filter(s -> s.getTaskQuantity().equals(0))
            .map(MesBuildingOrderIdAndQuantityDTO::getId)
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(needRemoveTopOrderIds)) {
            this.topTaskOrderService.removeByIds(needRemoveTopOrderIds);
         }

         if (CollectionUtils.isNotEmpty(needRemoveTaskIds)) {
            this.taskService.removeByIds(needRemoveTaskIds);
         }

         List<Long> removReportIds = allReports.stream().map(MesBuildingProduceTeamReport::getId).collect(Collectors.toList());
         this.mesBuildingProduceTeamReportService.removeByIds(removReportIds);
         if (CollectionUtils.isNotEmpty(removReportIds)) {
            List<MesBuildingProduceTeamReportPrice> artPriceList = this.teamReportPriceService
               .list(Wrappers.lambdaQuery(MesBuildingProduceTeamReportPrice.class).in(MesBuildingProduceTeamReportPrice::getTeamReoprtId, removReportIds));
            List<Long> artPriceIds = artPriceList.stream().map(MesBuildingProduceTeamReportPrice::getId).collect(Collectors.toList());
            this.teamReportPriceService.removeByIds(artPriceIds);
         }

         Map<String, List<MesBuildingProduceTeamReport>> artReportSummaryMap = allReports.stream()
            .collect(Collectors.groupingBy(s -> s.getTaskProcessId() + "_" + s.getProductionLineId() + "_" + s.getTeamId()));
         List<MesBuildingReportSummaryDTO> artSummarydatas = artReportSummaryMap.keySet()
            .stream()
            .map(
               s -> {
                  String[] split = s.split("_");
                  return MesBuildingReportSummaryDTO.builder()
                     .taskProcessId(Long.valueOf(split[0]))
                     .groupId(Long.valueOf(split[1]))
                     .prodLineId(Long.valueOf(split[1]))
                     .teamId(Long.valueOf(split[2]))
                     .build();
               }
            )
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(artSummarydatas)) {
            List<MesBuildingProduceTeamReportSummary> artSummaryList = this.produceTeamReportSummaryService.listReportSummarysByData(artSummarydatas);

            for (MesBuildingProduceTeamReportSummary reportSummary : artSummaryList) {
               String key = reportSummary.getTaskProcessId() + "_" + reportSummary.getProductionLineId() + "_" + reportSummary.getTeamId();
               List<MesBuildingProduceTeamReport> linkReports = artReportSummaryMap.get(key);
               int reportQuantity = linkReports.stream().mapToInt(MesBuildingProduceTeamReport::getQuantity).sum();
               int inspectQuantity = linkReports.stream().mapToInt(MesBuildingProduceTeamReport::getInspectionQuantity).sum();
               int problemQuantity = linkReports.stream().mapToInt(MesBuildingProduceTeamReport::getProblemQuantity).sum();
               reportSummary.setQuantity(reportSummary.getQuantity() - reportQuantity);
               reportSummary.setInspectionQuantity(reportSummary.getInspectionQuantity() - inspectQuantity);
               reportSummary.setProblemQuantity(reportSummary.getProblemQuantity() - problemQuantity);
               Preconditions.checkArgument(reportSummary.getQuantity() >= 0, "操作失败!!");
               Preconditions.checkArgument(reportSummary.getInspectionQuantity() >= 0, "操作失败!!");
               Preconditions.checkArgument(reportSummary.getProblemQuantity() >= 0, "操作失败!!");
               Preconditions.checkArgument(reportSummary.getQuantity() >= reportSummary.getInspectionQuantity() + reportSummary.getProblemQuantity(), "操作失败!!");
            }

            this.produceTeamReportSummaryService.updateBatchById(artSummaryList);
            List<Long> artNeedRemoveReportIds = artSummaryList.stream()
               .filter(s -> s.getQuantity().equals(0))
               .map(MesBuildingProduceTeamReportSummary::getId)
               .collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(artNeedRemoveReportIds)) {
               this.produceTeamReportSummaryService.removeByIds(artNeedRemoveReportIds);
            }
         }

         if (CollectionUtils.isNotEmpty(inspectReports)) {
            List<Long> artRemovInspectIds = inspectReports.stream().map(MesBuildingProduceInspectionTeamReport::getId).collect(Collectors.toList());
            this.inspectionTeamReportService.removeByIds(artRemovInspectIds);
            List<MesBuildingQhseInspectionLink> links = this.qhseInspectionLinkService
               .list(Wrappers.lambdaQuery(MesBuildingQhseInspectionLink.class).in(MesBuildingQhseInspectionLink::getInspectionReportId, artRemovInspectIds));
            if (CollectionUtils.isNotEmpty(links)) {
               List var106 = links.stream().map(MesBuildingQhseInspectionLink::getId).collect(Collectors.toList());
            }
         }
      }

      if (CollectionUtils.isNotEmpty(numberInfoDTOS)) {
         List<MesBuildingComplete> completes = this.completeService.listCompleteByData(numberInfoDTOS, taskType);
         reduceProduceMap = completes.stream().collect(Collectors.toMap(MesBuildingComplete::getProductId, MesBuildingComplete::getQuantity, Integer::sum));
         List<Long> completeRemoveIds = completes.stream().map(MesBuildingComplete::getId).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(completeRemoveIds)) {
            this.completeService.removeByIds(completeRemoveIds);
            List<MesBuildingWarehouseRecord> artRecords = this.warehouseRecordService
               .list(
                  Wrappers.lambdaQuery(MesBuildingWarehouseRecord.class)
                     .eq(MesBuildingWarehouseRecord::getProductType, taskType)
                     .in(MesBuildingWarehouseRecord::getCompleteId, completeRemoveIds)
               );
            if (CollectionUtils.isNotEmpty(artRecords)) {
               List<Long> warehouseRecordsIds = artRecords.stream().map(MesBuildingWarehouseRecord::getId).collect(Collectors.toList());
               this.warehouseRecordService.removeByIds(warehouseRecordsIds);
               Map<String, BigDecimal> artRecordShopMap = artRecords.stream()
                  .collect(Collectors.toMap(s -> s.getProductId() + "_" + s.getWorkshopId(), MesBuildingWarehouseRecord::getQuantity, BigDecimal::add));
               List<Long> recordShopId = artRecords.stream().map(s -> s.getWorkshopId()).distinct().collect(Collectors.toList());
               List<MesBuildingWarehouseSummary> warehouseSummarys = this.warehouseSummaryService
                  .list(
                     Wrappers.lambdaQuery(MesBuildingWarehouseSummary.class)
                        .eq(MesBuildingWarehouseSummary::getProductType, taskType)
                        .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
                        .in(MesBuildingWarehouseSummary::getWorkshopId, recordShopId)
                        .in(MesBuildingWarehouseSummary::getProductId, productIds)
                  );

               for (MesBuildingWarehouseSummary artSummary : warehouseSummarys) {
                  String key = artSummary.getProductId() + "_" + artSummary.getWorkshopId();
                  BigDecimal integer = artRecordShopMap.getOrDefault(key, BigDecimal.ZERO);
                  artSummary.setQuantity(artSummary.getQuantity().subtract(integer));
                  Preconditions.checkArgument(artSummary.getQuantity().compareTo(BigDecimal.ZERO) >= 0, "操作失败!!!");
               }

               this.warehouseSummaryService.updateBatchById(warehouseSummarys);
               List<Long> removeSummaryIds = warehouseSummarys.stream()
                  .filter(s -> s.getQuantity().equals(0))
                  .map(MesBuildingWarehouseSummary::getId)
                  .collect(Collectors.toList());
               this.warehouseSummaryService.removeByIds(removeSummaryIds);
            }
         }

         this.reducePartProduce(numberInfoDTOS, taskType);
         List<MesBuildingAssistNumberDetail> numberDetails = this.numberDetailService.listAssistDetails(numberInfoDTOS, taskType);
         if (CollectionUtils.isNotEmpty(numberDetails)) {
            List<Long> assistIds = numberDetails.stream().map(MesBuildingAssistNumberDetail::getAssistId).distinct().collect(Collectors.toList());
            Map<Long, MesBuildingAssist> assistMap = this.assistService
               .listByIds(assistIds)
               .stream()
               .collect(Collectors.toMap(MesBuildingAssist::getId, Function.identity()));

            for (MesBuildingAssistNumberDetail detail : numberDetails) {
               MesBuildingAssist assist = assistMap.get(detail.getAssistId());
               assist.setQuantity(assist.getQuantity() - 1);
               if (detail.getBoolFinishEnum()) {
                  assist.setProduceQuantity(assist.getProduceQuantity() - 1);
               }

               Preconditions.checkArgument(assist.getQuantity() >= assist.getProduceQuantity(), "操作失败!!!");
               assist.setBoolFinishEnum(assist.getQuantity().equals(assist.getProduceQuantity()));
            }

            List<Long> detailIds = numberDetails.stream().map(MesBuildingAssistNumberDetail::getId).collect(Collectors.toList());
            this.numberDetailService.removeByIds(detailIds);
            List<MesBuildingAssist> assistList = new ArrayList<>(assistMap.values());
            this.assistService.updateBatchById(assistList);
            List<MesBuildingAssist> deleteIds = assistList.stream().filter(s -> s.getQuantity().equals(0)).collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(deleteIds)) {
               this.assistService.removeByIds(deleteIds.stream().map(MesBuildingAssist::getId).collect(Collectors.toList()));
            }
         }
      }

      if (CollectionUtils.isNotEmpty(productIds) && this.projectService.getProjectMode(projectId).equals(ProjectModeEnum.STANDARD_MODE.getType())) {
         this.reduceUseQuantity(productInproduceReduceQuantity, productIds, taskType);
      }

      return reduceProduceMap;
   }

   private void reducePartProduce(List<NumberInfoDTO> numberInfoDTOS, Integer taskType) {
      List<MesBuildingComplete> needRemoveComplete = new ArrayList<>();
      if (taskType.equals(TaskTypeEnum.ARTIFACT.getType())) {
         List<MesBuildingTaskNumberLink> linkList = this.numberLinkService.listLinksBydata(numberInfoDTOS, taskType);
         List<Long> needRemoveLinkIds = linkList.stream().map(MesBuildingTaskNumberLink::getId).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(needRemoveLinkIds)) {
            needRemoveComplete = this.completeService
               .list(Wrappers.lambdaQuery(MesBuildingComplete.class).in(MesBuildingComplete::getNumberLinkId, needRemoveLinkIds));
         }

         Map<Long, Set<Integer>> artReduceMap = new HashMap<>();

         for (NumberInfoDTO numberInfoDTO : numberInfoDTOS) {
            Set<Integer> numbers = artReduceMap.getOrDefault(numberInfoDTO.getProductId(), new HashSet<>());
            numbers.add(numberInfoDTO.getNumber());
            artReduceMap.put(numberInfoDTO.getProductId(), numbers);
         }

         List<TechArtifactMachinePartLink> patLinks = this.artifactMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getArtifactId, artReduceMap.keySet()));
         if (CollectionUtils.isNotEmpty(patLinks)) {
            List<Long> partIds = patLinks.stream().map(TechArtifactMachinePartLink::getMachinePartId).distinct().collect(Collectors.toList());
            List<TechMachinePart> machineParts = this.machinePartService.listByIds(partIds);
            Map<Long, TechMachinePart> patMap = machineParts.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
            Map<Long, List<TechArtifactMachinePartLink>> linkMap = patLinks.stream().collect(Collectors.groupingBy(TechArtifactMachinePartLink::getArtifactId));

            for (Long artId : artReduceMap.keySet()) {
               Integer reduceQuantity = artReduceMap.get(artId).size();
               List<TechArtifactMachinePartLink> partLinks = linkMap.get(artId);
               if (CollectionUtils.isNotEmpty(partLinks)) {
                  for (TechArtifactMachinePartLink partLink : partLinks) {
                     TechMachinePart machinePart = patMap.get(partLink.getMachinePartId());
                     if (!machinePart.getBoolProcess() && machinePart.getRelationType().equals(MachinePartRelationTypeEnum.FOR_ARTIFACT.getType())) {
                        machinePart.setProducedQuantity(machinePart.getProducedQuantity() - reduceQuantity * partLink.getQuantity());
                     }
                  }
               }
            }

            List<TechMachinePart> techMachineParts = new ArrayList<>(patMap.values());
            this.machinePartService.updateBatchById(techMachineParts);
         }
      } else if (taskType.equals(TaskTypeEnum.ASSEMBLE.getType())) {
      }

      if (CollectionUtils.isNotEmpty(needRemoveComplete)) {
         List<Long> removeCompleteIds = needRemoveComplete.stream().map(MesBuildingComplete::getId).distinct().collect(Collectors.toList());
         this.completeService.removeByIds(removeCompleteIds);
         List<MesBuildingWarehouseRecord> needRemoveRecords = this.warehouseRecordService
            .list(Wrappers.lambdaQuery(MesBuildingWarehouseRecord.class).in(MesBuildingWarehouseRecord::getCompleteId, removeCompleteIds));
         if (CollectionUtils.isNotEmpty(needRemoveRecords)) {
            List<Long> removeRecordIds = needRemoveRecords.stream().map(MesBuildingWarehouseRecord::getId).distinct().collect(Collectors.toList());
            this.warehouseRecordService.removeByIds(removeRecordIds);
            List<Long> reducePartIds = needRemoveRecords.stream().map(MesBuildingWarehouseRecord::getProductId).distinct().collect(Collectors.toList());
            Map<String, List<MesBuildingWarehouseRecord>> recordMap = needRemoveRecords.stream()
               .collect(Collectors.groupingBy(s -> s.getProductType() + "_" + s.getProductId() + "_" + s.getWorkshopId()));
            List<MesBuildingWarehouseSummary> summaryList = this.warehouseSummaryService
               .list(
                  Wrappers.lambdaQuery(MesBuildingWarehouseSummary.class)
                     .in(MesBuildingWarehouseSummary::getProductId, reducePartIds)
                     .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
                     .apply("product_type & 17")
               );
            Map<String, MesBuildingWarehouseSummary> summaryMap = summaryList.stream()
               .collect(Collectors.toMap(s -> s.getProductType() + "_" + s.getProductId() + "_" + s.getWorkshopId(), Function.identity()));
            List<MesBuildingWarehouseSummary> reduceSummaryList = new ArrayList<>();

            for (String key : recordMap.keySet()) {
               List<MesBuildingWarehouseRecord> warehouseRecords = recordMap.get(key);
               MesBuildingWarehouseSummary summary = summaryMap.get(key);
               BigDecimal reduceQuantity = warehouseRecords.stream().map(MesBuildingWarehouseRecord::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);
               summary.setQuantity(summary.getQuantity().subtract(reduceQuantity));
               reduceSummaryList.add(summary);
            }

            this.warehouseSummaryService.updateBatchById(reduceSummaryList);
            List<Long> removeSummaryIds = reduceSummaryList.stream()
               .filter(s -> s.getQuantity().equals(0))
               .map(MesBuildingWarehouseSummary::getId)
               .collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(removeSummaryIds)) {
               this.warehouseSummaryService.removeByIds(removeSummaryIds);
            }
         }
      }
   }

   private void reduceUseQuantity(Map<Long, Integer> productReduceQuantityMap, List<Long> productIds, Integer taskType) {
      if (taskType.equals(TaskTypeEnum.ARTIFACT.getType())) {
         List<TechArtifactMachinePartLink> artPartLinks = this.artifactMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getArtifactId, productIds));
         if (CollectionUtils.isNotEmpty(artPartLinks)) {
            Map<Long, List<TechArtifactMachinePartLink>> partArtLinkMap = artPartLinks.stream()
               .collect(Collectors.groupingBy(TechArtifactMachinePartLink::getMachinePartId));
            List<Long> partIds = artPartLinks.stream().map(TechArtifactMachinePartLink::getMachinePartId).distinct().collect(Collectors.toList());
            List<TechMachinePart> machineParts = this.machinePartService.listByIds(partIds);
            machineParts = machineParts.stream()
               .filter(s -> !s.getBoolProcess())
               .filter(s -> s.getRelationType().equals(MachinePartRelationTypeEnum.FOR_ARTIFACT.getType()))
               .collect(Collectors.toList());

            for (TechMachinePart machinePart : machineParts) {
               List<TechArtifactMachinePartLink> machinePartLinks = partArtLinkMap.get(machinePart.getId());
               Integer reduceQuantity = 0;

               for (TechArtifactMachinePartLink machinePartLink : machinePartLinks) {
                  Integer artReduceQuantity = productReduceQuantityMap.get(machinePartLink.getArtifactId());
                  if (artReduceQuantity != null) {
                     reduceQuantity = reduceQuantity + artReduceQuantity * machinePartLink.getQuantity();
                  }
               }

               machinePart.setUsedQuantity(machinePart.getUsedQuantity() - reduceQuantity);
               if (machinePart.getUsedQuantity() < 0) {
                  machinePart.setUsedQuantity(0);
               }

               if (machinePart.getUsedQuantity() < 0) {
                  machinePart.setUsedQuantity(0);
               }

               if (machinePart.getProducedQuantity() < 0) {
                  machinePart.setProducedQuantity(0);
               }
            }

            this.machinePartService.updateBatchById(machineParts);
         }
      } else if (taskType.equals(TaskTypeEnum.ASSEMBLE.getType())) {
         List<TechAssembleMachinePartLink> assemblePartLinkList = this.assembleMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechAssembleMachinePartLink.class).in(TechAssembleMachinePartLink::getAssembleId, productIds));
         if (CollectionUtils.isNotEmpty(assemblePartLinkList)) {
            Map<Long, List<TechAssembleMachinePartLink>> partAssLinkMap = assemblePartLinkList.stream()
               .collect(Collectors.groupingBy(TechAssembleMachinePartLink::getMachinePartId));
            List<Long> partIds = assemblePartLinkList.stream().map(TechAssembleMachinePartLink::getMachinePartId).distinct().collect(Collectors.toList());
            List<TechMachinePart> machineParts = this.machinePartService.listByIds(partIds);
            machineParts = machineParts.stream()
               .filter(s -> s.getRelationType().equals(MachinePartRelationTypeEnum.FOR_ASSEMBLE.getType()))
               .collect(Collectors.toList());

            for (TechMachinePart machinePart : machineParts) {
               List<TechAssembleMachinePartLink> machinePartLinks = partAssLinkMap.get(machinePart.getId());
               Integer reduceQuantity = 0;

               for (TechAssembleMachinePartLink machinePartLink : machinePartLinks) {
                  Integer artReduceQuantity = productReduceQuantityMap.get(machinePartLink.getAssembleId());
                  if (artReduceQuantity != null) {
                     reduceQuantity = reduceQuantity + artReduceQuantity * machinePartLink.getQuantity();
                  }
               }

               machinePart.setUsedQuantity(machinePart.getUsedQuantity() - reduceQuantity);
               if (machinePart.getUsedQuantity() < 0) {
                  machinePart.setUsedQuantity(0);
               }

               if (machinePart.getProducedQuantity() < 0) {
                  machinePart.setProducedQuantity(0);
               }
            }

            this.machinePartService.updateBatchById(machineParts);
         }
      } else {
         Preconditions.checkArgument(false, "产品类型不正确!!!");
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean useArtifact(List<TechChangeArtifactUseDtoParam> useArtifacts) {
      if (CollectionUtils.isEmpty(useArtifacts)) {
         return Boolean.TRUE;
      }

      List<NumberInfoDTO> lastArtNumbers = useArtifacts.stream()
         .map(
            techChangeArtifactDelDtoParam -> NumberInfoDTO.builder()
               .productId(techChangeArtifactDelDtoParam.getLastArtifactId())
               .number(techChangeArtifactDelDtoParam.getLastSortNumber())
               .build()
         )
         .collect(Collectors.toList());
      List<TechArtifactExt> lastArtExts = this.artifactExtService.listArtifact(lastArtNumbers);
      Preconditions.checkArgument(lastArtExts.size() == lastArtNumbers.size(), "操作失败,构件码号不存在!");
      Preconditions.checkArgument(lastArtExts.stream().allMatch(TechArtifactExt::getBoolScheduling), "操作失败,构件未排期,不会触发MES变更!");
      Map<String, TechArtifactExt> lastExtMap = lastArtExts.stream()
         .collect(Collectors.toMap(s -> s.getArtifactId() + "_" + s.getSortNumber(), Function.identity()));
      List<NumberInfoDTO> newArtifactNumbers = useArtifacts.stream()
         .map(
            techChangeArtifactDelDtoParam -> NumberInfoDTO.builder()
               .productId(techChangeArtifactDelDtoParam.getNewArtifactId())
               .number(techChangeArtifactDelDtoParam.getNewSortNumber())
               .build()
         )
         .collect(Collectors.toList());
      List<TechArtifactExt> newTechArtifactExts = this.artifactExtService.listArtifact(newArtifactNumbers);
      Map<String, TechArtifactExt> newExtMap = newTechArtifactExts.stream()
         .collect(Collectors.toMap(s -> s.getArtifactId() + "_" + s.getSortNumber(), Function.identity()));
      List<Long> newArtIds = useArtifacts.stream().map(TechChangeArtifactUseDtoParam::getNewArtifactId).distinct().collect(Collectors.toList());
      List<MesBuildingArtifactScheduling> newArtSchedulings = this.mesBuildingArtifactSchedulingService
         .list(Wrappers.lambdaQuery(MesBuildingArtifactScheduling.class).in(MesBuildingArtifactScheduling::getProductId, newArtIds));
      Map<String, MesBuildingArtifactScheduling> newArtSchedulingMap = newArtSchedulings.stream()
         .collect(Collectors.toMap(s -> s.getProductId() + "_" + s.getProductionLineId(), Function.identity()));
      Map<Long, Integer> needReduceSchedulingMap = lastArtExts.stream()
         .filter(TechArtifactExt::getBoolTask)
         .collect(Collectors.toMap(TechArtifactExt::getSchedulingId, s -> 1, Integer::sum));
      List<Long> allSchedulingIds = lastArtExts.stream().map(TechArtifactExt::getSchedulingId).distinct().collect(Collectors.toList());
      Map<Long, MesBuildingArtifactScheduling> allSchedulingMap = this.mesBuildingArtifactSchedulingService
         .listByIds(allSchedulingIds)
         .stream()
         .collect(Collectors.toMap(MesBuildingArtifactScheduling::getId, Function.identity()));
      List<TechChangeArtifactUseDtoParam> needReduceTaskUse = new ArrayList<>();

      for (TechChangeArtifactUseDtoParam useArtifact : useArtifacts) {
         String lastKey = useArtifact.getLastArtifactId() + "_" + useArtifact.getLastSortNumber();
         String newKey = useArtifact.getNewArtifactId() + "_" + useArtifact.getNewSortNumber();
         TechArtifactExt lastArtExt = lastExtMap.get(lastKey);
         TechArtifactExt newArtExt = newExtMap.get(newKey);
         MesBuildingArtifactScheduling lastScheduing = allSchedulingMap.get(lastArtExt.getSchedulingId());
         String newSchKey = useArtifact.getNewArtifactId() + "_" + lastScheduing.getProductionLineId();
         MesBuildingArtifactScheduling newScheduling = newArtSchedulingMap.get(newSchKey);
         int lastTaskQuantity = lastArtExt.getBoolTask() ? 1 : 0;
         if (newScheduling != null) {
            newScheduling.setQuantity(newScheduling.getQuantity() + 1);
            newScheduling.setTaskQuantity(newScheduling.getTaskQuantity() + lastTaskQuantity);
         } else {
            newScheduling = BeanUtil.copy(lastScheduing, MesBuildingArtifactScheduling.class);
            newScheduling.setId(null);
            newScheduling.setProductId(useArtifact.getNewArtifactId());
            newScheduling.setQuantity(1);
            newScheduling.setTaskQuantity(lastTaskQuantity);
            this.mesBuildingArtifactSchedulingService.save(newScheduling);
         }

         newArtSchedulingMap.put(newSchKey, newScheduling);
         newArtExt.setBoolScheduling(Boolean.TRUE);
         newArtExt.setSchedulingId(newScheduling.getId());
         if (lastArtExt.getBoolTask()) {
            needReduceTaskUse.add(BeanUtil.copy(useArtifact, TechChangeArtifactUseDtoParam.class));
         } else {
            lastScheduing.setQuantity(lastScheduing.getQuantity() - 1);
         }
      }

      List<MesBuildingArtifactScheduling> needAppendScedulings = new ArrayList<>(newArtSchedulingMap.values());
      this.mesBuildingArtifactSchedulingService.updateBatchById(needAppendScedulings);
      List<TechArtifactExt> needUpdateExts = new ArrayList<>(newExtMap.values());
      this.artifactExtService.updateBatchById(needUpdateExts);
      lastArtExts.stream().filter(s -> !s.getBoolTask()).forEach(s -> s.setBoolScheduling(Boolean.FALSE).setSchedulingId(0L));
      this.artifactExtService.updateBatchById(lastArtExts);
      List<MesBuildingArtifactScheduling> neeUpdateSchedulings = new ArrayList<>(allSchedulingMap.values());
      Preconditions.checkArgument(neeUpdateSchedulings.stream().allMatch(s -> s.getQuantity() >= 0), "操作失败!!");
      this.mesBuildingArtifactSchedulingService.updateBatchById(neeUpdateSchedulings);
      if (CollectionUtils.isNotEmpty(needReduceTaskUse)) {
         this.secondUseDeleteTask(needReduceTaskUse);
      }

      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   public void secondUseDeleteTask(List<TechChangeArtifactUseDtoParam> useArtifacts) {
      List<NumberInfoDTO> lastArtNumbers = useArtifacts.stream()
         .map(
            techChangeArtifactDelDtoParam -> NumberInfoDTO.builder()
               .productId(techChangeArtifactDelDtoParam.getLastArtifactId())
               .number(techChangeArtifactDelDtoParam.getLastSortNumber())
               .build()
         )
         .collect(Collectors.toList());
      this.updateQhse(lastArtNumbers, TaskTypeEnum.ARTIFACT.getType());
      List<MesBuildingTaskNumberLink> numberLinks = this.numberLinkService.listLinksBydata(lastArtNumbers, TaskTypeEnum.ARTIFACT.getType());
      List<NumberInfoDTO> assNumberInfors = numberLinks.stream()
         .map(numberLink -> NumberInfoDTO.builder().productId(numberLink.getAssembleId()).number(numberLink.getAssembleNumber()).build())
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(assNumberInfors)) {
         this.updateQhse(assNumberInfors, TaskTypeEnum.ASSEMBLE.getType());
      }

      List<TechArtifactExt> lastArtExts = this.artifactExtService.listArtifact(lastArtNumbers);
      Preconditions.checkArgument(lastArtExts.size() == lastArtNumbers.size(), "操作失败,码号不存在!");
      Long projectId = lastArtExts.get(0).getProjectId();
      Preconditions.checkArgument(lastArtExts.stream().allMatch(TechArtifactExt::getBoolTask), "操作失败,构件未下发不会触发生产变更!");
      List<MesBuildingTaskNumberLink> allLastNumberLinks = this.numberLinkService.listLinksBydata(lastArtNumbers, TaskTypeEnum.ARTIFACT.getType());
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(allLastNumberLinks), "操作失败!!!排产数据不存在,请刷新页面!!!");
      List<NumberInfoDTO> assNumbers = allLastNumberLinks.stream()
         .filter(numberLink -> numberLink.getAssembleId() != null)
         .map(numberLink -> NumberInfoDTO.builder().productId(numberLink.getAssembleId()).number(numberLink.getAssembleNumber()).build())
         .collect(Collectors.toList());
      List<NumberInfoDTO> artifactNumbers = allLastNumberLinks.stream()
         .map(numberLink -> NumberInfoDTO.builder().productId(numberLink.getArtifactId()).number(numberLink.getArtifactNumber()).build())
         .collect(Collectors.toList());
      this.checkChangeList(artifactNumbers, assNumbers);
      Map<Long, TechArtifact> lastArtifactMap = this.artifactService
         .listByIds(useArtifacts.stream().map(TechChangeArtifactUseDtoParam::getLastArtifactId).distinct().collect(Collectors.toList()))
         .stream()
         .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      Map<String, List<MesBuildingTaskNumberLink>> lastNumberLinkMap = allLastNumberLinks.stream()
         .collect(Collectors.groupingBy(s -> s.getArtifactId() + "_" + s.getArtifactNumber()));
      List<Long> lastArtTaskIds = allLastNumberLinks.stream().map(MesBuildingTaskNumberLink::getArtifactTaskId).distinct().collect(Collectors.toList());
      List<MesBuildingTask> lastArtTasks = this.taskService.listByIds(lastArtTaskIds);
      Map<Long, MesBuildingTask> lastTaskMap = lastArtTasks.stream().collect(Collectors.toMap(MesBuildingTask::getId, Function.identity()));
      Map<Long, List<MesBuildingTaskProcess>> lastTaskProcessMap = new HashMap<>();
      Map<String, List<MesBuildingProduceTeamReport>> lastArtReportMap = new HashMap<>();
      Map<String, List<MesBuildingProduceInspectionTeamReport>> lastArtInspectReportMap = new HashMap<>();
      Map<String, MesBuildingComplete> lastCompleteMap = new HashMap<>();
      Map<String, MesBuildingSinglePartArtifactPrint> singPartMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(lastArtTaskIds)) {
         List<MesBuildingTaskProcess> lastTaskProces = this.taskProcessService
            .list(Wrappers.lambdaQuery(MesBuildingTaskProcess.class).in(MesBuildingTaskProcess::getTaskId, lastArtTaskIds));
         lastTaskProcessMap = lastTaskProces.stream().collect(Collectors.groupingBy(MesBuildingTaskProcess::getTaskId));
         Preconditions.checkArgument(lastTaskProces.stream().noneMatch(MesBuildingTaskProcess::getBoolParallelProcess), "操作失败,暂不支持有并行任务的构件变更!");
         List<MesBuildingProduceTeamReport> lastArtReports = this.mesBuildingProduceTeamReportService
            .listReports(lastArtNumbers, TaskTypeEnum.ARTIFACT.getType());
         lastArtReportMap = lastArtReports.stream().collect(Collectors.groupingBy(s -> s.getProductId() + "_" + s.getNumber()));
         List<MesBuildingProduceInspectionTeamReport> allLastArtInspectReports = this.inspectionTeamReportService
            .listReports(lastArtNumbers, TaskTypeEnum.ARTIFACT.getType());
         lastArtInspectReportMap = allLastArtInspectReports.stream().collect(Collectors.groupingBy(s -> s.getProductId() + "_" + s.getNumber()));
         List<MesBuildingComplete> completes = this.completeService.listCompleteByData(lastArtNumbers, TaskTypeEnum.ARTIFACT.getType());
         lastCompleteMap = completes.stream().collect(Collectors.toMap(s -> s.getProductId() + "_" + s.getNumber(), Function.identity()));
         List<MesBuildingSinglePartArtifactPrint> lastSings = this.singlePartArtifactPrintService.listBydata(lastArtNumbers);
         singPartMap = lastSings.stream().collect(Collectors.toMap(s -> s.getProductId() + "_" + s.getNumber(), Function.identity()));
      }

      Map<String, MesBuildingTask> newArtTaskMap = new HashMap<>();
      Map<Long, List<MesBuildingTaskProcess>> newArtTaskProcessMap = new HashMap<>();
      Map<Long, List<MesBuildingTaskProcess>> newArtTaskProcessNewMap = new HashMap<>();
      List<NumberInfoDTO> newArtifactNumbers = useArtifacts.stream()
         .map(
            techChangeArtifactDelDtoParam -> NumberInfoDTO.builder()
               .productId(techChangeArtifactDelDtoParam.getNewArtifactId())
               .number(techChangeArtifactDelDtoParam.getNewSortNumber())
               .build()
         )
         .collect(Collectors.toList());
      List<TechArtifactExt> newTechArtifactExts = this.artifactExtService.listArtifact(newArtifactNumbers);
      Preconditions.checkArgument(newTechArtifactExts.size() == newArtifactNumbers.size(), "操作失败!!!!");
      Map<String, TechArtifactExt> newExtMap = newTechArtifactExts.stream()
         .collect(Collectors.toMap(s -> s.getArtifactId() + "_" + s.getSortNumber(), Function.identity()));
      List<Long> newArtIds = useArtifacts.stream().map(TechChangeArtifactUseDtoParam::getNewArtifactId).distinct().collect(Collectors.toList());
      List<TechArtifact> newArtifacts = this.artifactService.listByIds(newArtIds);
      Map<Long, TechArtifact> newArtMap = newArtifacts.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      List<MesBuildingTask> newArtTasks = this.taskService
         .list(
            Wrappers.lambdaQuery(MesBuildingTask.class)
               .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
               .in(MesBuildingTask::getProductId, newArtIds)
         );
      if (CollectionUtils.isNotEmpty(newArtTasks)) {
         List<Long> newArtTaskIds = newArtTasks.stream().map(MesBuildingTask::getId).collect(Collectors.toList());
         newArtTaskMap = newArtTasks.stream().collect(Collectors.toMap(s -> s.getTaskOrderId() + "_" + s.getProductId(), Function.identity()));
         List<MesBuildingTaskProcess> newArtTaskProcess = this.taskProcessService
            .list(Wrappers.lambdaQuery(MesBuildingTaskProcess.class).in(MesBuildingTaskProcess::getTaskId, newArtTaskIds));
         newArtTaskProcessMap = newArtTaskProcess.stream().collect(Collectors.groupingBy(MesBuildingTaskProcess::getTaskId));
      }

      List<MesBuildingSecondUseDTO> taskAddNumbers = new ArrayList<>();
      List<MesBuildingProduceTeamReport> needAppendTeamReport = new ArrayList<>();
      List<MesBuildingProduceInspectionTeamReport> needAppendTeamInspectReport = new ArrayList<>();
      List<MesBuildingComplete> needComplete = new ArrayList<>();
      Long InspectNumber = this.redisUtils.incr("inspection_reportnumber:", 1L);
      Long reportNumber = this.redisUtils.incr("teamreport_reportnumber:", 1L);
      List<MesBuildingSinglePartArtifactPrint> appendSings = new ArrayList<>();

      for (TechChangeArtifactUseDtoParam useArtifact : useArtifacts) {
         TechArtifact lastArt = lastArtifactMap.get(useArtifact.getLastArtifactId());
         TechArtifact newArt = newArtMap.get(useArtifact.getNewArtifactId());
         Preconditions.checkArgument(
            lastArt.getStructureClassId().equals(newArt.getStructureClassId())
               && lastArt.getBoolAllPartSendDirectly().equals(newArt.getBoolAllPartSendDirectly())
               && lastArt.getArtifactType().equals(newArt.getArtifactType()),
            "操作失败,不同类构件无法利用!!!!"
         );
         String key = useArtifact.getLastArtifactId() + "_" + useArtifact.getLastSortNumber();
         List<MesBuildingTaskNumberLink> lastNumberLinks = lastNumberLinkMap.get(key);
         MesBuildingTaskNumberLink numberLink = lastNumberLinks.get(0);
         MesBuildingTask task = lastTaskMap.get(numberLink.getArtifactTaskId());
         List<MesBuildingTaskProcess> lastTaskProcessList = lastTaskProcessMap.get(task.getId());
         List<MesBuildingProduceTeamReport> lastArtReports = lastArtReportMap.get(key);
         Map<Long, MesBuildingProduceTeamReport> lastReportMap = new HashMap<>();
         if (CollectionUtils.isNotEmpty(lastArtReports)) {
            lastReportMap = lastArtReports.stream().collect(Collectors.toMap(MesBuildingProduceTeamReport::getProcessId, Function.identity()));
         }

         List<MesBuildingProduceInspectionTeamReport> lastArtInspects = lastArtInspectReportMap.get(key);
         Map<Long, MesBuildingProduceInspectionTeamReport> lastInspectMap = new HashMap<>();
         if (CollectionUtils.isNotEmpty(lastArtInspects)) {
            lastInspectMap = lastArtInspects.stream().collect(Collectors.toMap(MesBuildingProduceInspectionTeamReport::getProcessId, Function.identity()));
         }

         MesBuildingComplete complete = lastCompleteMap.get(key);
         MesBuildingTask newTask = newArtTaskMap.get(task.getTaskOrderId() + "_" + useArtifact.getNewArtifactId());
         if (newTask != null) {
            TechArtifact newArtifact = newArtMap.get(useArtifact.getNewArtifactId());
            newTask.setTaskQuantity(newTask.getTaskQuantity() + 1);
            newTask.setInProductionQuantity(newTask.getInProductionQuantity() + (numberLink.getBoolArtifactInproduce() ? 1 : 0));
            newTask.setCompleteQuantity(newTask.getCompleteQuantity() + (numberLink.getBoolArtifactComplete() ? 1 : 0));
            MesBuildingSecondUseDTO secondUseDTO = MesBuildingSecondUseDTO.builder()
               .taskId(newTask.getId())
               .productId(useArtifact.getNewArtifactId())
               .taskProcessId(0L)
               .boolArtifactInproduce(Boolean.FALSE)
               .boolOneArtifactInproduce(Boolean.FALSE)
               .boolArtifactReport(Boolean.FALSE)
               .boolArtifactInspection(Boolean.FALSE)
               .boolArtifactComplete(Boolean.FALSE)
               .number(useArtifact.getNewSortNumber())
               .boolOnecode(newTask.getBoolOneCode())
               .build();
            List<MesBuildingTaskProcess> newArtTaskProcessList = newArtTaskProcessMap.get(newTask.getId());
            Integer needQuantity = 0;
            if (!CollectionUtils.isNotEmpty(newArtTaskProcessList)) {
               Preconditions.checkArgument(lastArt.getBoolAllPartSendDirectly(), "操作失败!!原构件不是直发檩条!!生产工序丢失!!!");
            } else {
               Map<Long, List<MesBuildingNextProcessLink>> nextProcessLinkMap = this.nextProcessLinkService
                  .list(
                     (Wrapper<MesBuildingNextProcessLink>)new LambdaQueryWrapper<MesBuildingNextProcessLink>()
                        .in(
                           MesBuildingNextProcessLink::getTaskProcessId,
                           newArtTaskProcessList.stream().map(MesBuildingTaskProcess::getId).collect(Collectors.toList())
                        )
                  )
                  .stream()
                  .collect(Collectors.groupingBy(MesBuildingNextProcessLink::getTaskProcessId));
               newArtTaskProcessList.sort(Comparator.comparingInt(MesBuildingTaskProcess::getSequence));
               Preconditions.checkArgument(!lastArt.getBoolAllPartSendDirectly(), "操作失败!!原构件为直发檩条!!不应存在生产工序!!!");

               for (int i = 0; i < newArtTaskProcessList.size(); i++) {
                  MesBuildingTaskProcess newTaskProcess = newArtTaskProcessList.get(i);
                  newTaskProcess.setTaskQuantity(newTaskProcess.getTaskQuantity() + 1);
                  MesBuildingProduceTeamReport lastTeamReport = lastReportMap.get(newTaskProcess.getProcessId());
                  MesBuildingProduceInspectionTeamReport lastTeamInspectReport = lastInspectMap.get(newTaskProcess.getProcessId());
                  if (newTaskProcess.getSequence().equals(0)) {
                     newTaskProcess.setNeedQuantity(newTaskProcess.getTaskQuantity());
                     secondUseDTO.setTaskProcessId(newTaskProcess.getId());
                     secondUseDTO.setBoolArtifactInproduce(lastTeamReport != null);
                     secondUseDTO.setBoolOneArtifactInproduce(lastTeamReport != null);
                  } else {
                     newTaskProcess.setNeedQuantity(needQuantity);
                     if (secondUseDTO.getBoolArtifactInspection()) {
                        secondUseDTO.setTaskProcessId(newTaskProcess.getId());
                     }
                  }

                  List<MesBuildingNextProcessLink> mesBuildingNextProcessLinks = nextProcessLinkMap.getOrDefault(newTaskProcess.getId(), new ArrayList<>());
                  Preconditions.checkArgument(
                     CollectionUtils.isEmpty(mesBuildingNextProcessLinks) || mesBuildingNextProcessLinks.size() == 1, "操作失败,暂不支持并行工序的变更!"
                  );
                  if (CollectionUtils.isEmpty(mesBuildingNextProcessLinks)) {
                     secondUseDTO.setBoolHaveNextProcess(Boolean.FALSE);
                  } else {
                     MesBuildingNextProcessLink nextProcessLink = mesBuildingNextProcessLinks.get(0);
                     secondUseDTO.setBoolHaveNextProcess(nextProcessLink != null && nextProcessLink.getNextProcessId() != null);
                  }

                  if (lastTeamReport != null) {
                     newTaskProcess.setCompleteQuantity(newTaskProcess.getCompleteQuantity() + lastTeamReport.getQuantity());
                     newTaskProcess.setInspectionQuantity(newTaskProcess.getInspectionQuantity() + lastTeamReport.getInspectionQuantity());
                     newTaskProcess.setProblemQuantity(newTaskProcess.getProblemQuantity() + lastTeamReport.getProblemQuantity());
                     secondUseDTO.setTaskProcessId(newTaskProcess.getId());
                     secondUseDTO.setBoolArtifactInproduce(Boolean.TRUE);
                     secondUseDTO.setBoolArtifactReport(Boolean.TRUE);
                     secondUseDTO.setBoolArtifactInspection(lastTeamReport.getInspectionQuantity() > 0);
                     if (CollectionUtils.isEmpty(mesBuildingNextProcessLinks)) {
                        secondUseDTO.setBoolHaveNextProcess(Boolean.FALSE);
                        if (lastTeamReport.getInspectionQuantity() == 0) {
                           secondUseDTO.setBoolArtifactReport(Boolean.TRUE);
                           secondUseDTO.setBoolArtifactInspection(Boolean.FALSE);
                        } else {
                           secondUseDTO.setTaskProcessId(0L);
                        }
                     } else {
                        MesBuildingNextProcessLink nextProcessLink = mesBuildingNextProcessLinks.get(0);
                        if (nextProcessLink == null || nextProcessLink.getNextProcessId() == null) {
                           secondUseDTO.setBoolHaveNextProcess(Boolean.FALSE);
                           if (lastTeamReport.getInspectionQuantity() == 0) {
                              secondUseDTO.setBoolArtifactReport(Boolean.TRUE);
                              secondUseDTO.setBoolArtifactInspection(Boolean.FALSE);
                           } else {
                              secondUseDTO.setTaskProcessId(0L);
                           }
                        } else if (lastTeamReport.getInspectionQuantity() > 0) {
                           secondUseDTO.setTaskProcessId(newArtTaskProcessList.get(i + 1).getId());
                           secondUseDTO.setBoolArtifactReport(Boolean.FALSE);
                           secondUseDTO.setBoolArtifactInspection(Boolean.FALSE);
                        }
                     }
                  }

                  secondUseDTO.setBoolArtifactInproduce(lastTeamReport != null);
                  needQuantity = newTaskProcess.getInspectionQuantity();
                  if (lastTeamReport != null) {
                     MesBuildingProduceTeamReport newTeamReport = BeanUtil.copy(lastTeamReport, MesBuildingProduceTeamReport.class);
                     newTeamReport.setUseById(newTeamReport.getId());
                     newTeamReport.setId(null);
                     newTeamReport.setTaskId(newTask.getId());
                     newTeamReport.setTaskProcessId(newTaskProcess.getId());
                     newTeamReport.setProductId(useArtifact.getNewArtifactId());
                     newTeamReport.setNumber(useArtifact.getNewSortNumber());
                     newTeamReport.setReportNumber(reportNumber);
                     newTeamReport.setAssistId(null);
                     newTeamReport.setWorkshopId(newTask.getWorkshopId());
                     newTeamReport.setProductionLineId(newTask.getProductionLineId());
                     reportNumber = this.redisUtils.incr("teamreport_reportnumber:", 1L);
                     needAppendTeamReport.add(newTeamReport);
                  }

                  if (lastTeamInspectReport != null) {
                     MesBuildingProduceInspectionTeamReport newTeamInspectReport = BeanUtil.copy(
                        lastTeamInspectReport, MesBuildingProduceInspectionTeamReport.class
                     );
                     newTeamInspectReport.setUseById(newTeamInspectReport.getId());
                     newTeamInspectReport.setId(null);
                     newTeamInspectReport.setTaskId(newTask.getId());
                     newTeamInspectReport.setTaskProcessId(newTaskProcess.getId());
                     newTeamInspectReport.setProductId(useArtifact.getNewArtifactId());
                     newTeamInspectReport.setNumber(useArtifact.getNewSortNumber());
                     newTeamInspectReport.setInspectReportNumber(InspectNumber);
                     InspectNumber = this.redisUtils.incr("inspection_reportnumber:", 1L);
                     needAppendTeamInspectReport.add(newTeamInspectReport);
                  }
               }
            }

            secondUseDTO.setBoolArtifactComplete(complete != null);
            if (lastArt.getBoolAllPartSendDirectly()) {
               MesBuildingSinglePartArtifactPrint print = singPartMap.get(useArtifact.getLastArtifactId() + "_" + useArtifact.getLastSortNumber());
               MesBuildingSinglePartArtifactPrint newSing = BeanUtil.copy(print, MesBuildingSinglePartArtifactPrint.class);
               newSing.setId(null);
               newSing.setTaskId(newTask.getId());
               newSing.setProductId(useArtifact.getNewArtifactId());
               newSing.setNumber(useArtifact.getNewSortNumber());
               if (!newSing.getBoolAllReport()) {
                  newSing.setQuantity(1);
               }

               appendSings.add(newSing);
            }

            if (complete != null) {
               MesBuildingComplete newComplete = BeanUtil.copy(complete, MesBuildingComplete.class);
               newComplete.setProductId(newTask.getProductId());
               newComplete.setNumber(useArtifact.getNewSortNumber());
               newComplete.setProjectId(newComplete.getProjectId());
               newComplete.setMonomerId(newComplete.getMonomerId());
               newComplete.setAreaId(newComplete.getAreaId());
               newComplete.setAreaBatchId(newComplete.getAreaBatchId());
               newComplete.setTaskId(newTask.getId());
               needComplete.add(newComplete);
               newArtifact.setProducedQuantity(newArtifact.getProducedQuantity() + 1);
            }

            taskAddNumbers.add(secondUseDTO);
         } else {
            newTask = BeanUtil.copy(task, MesBuildingTask.class);
            newTask.setId(null);
            TechArtifact newArtifact = newArtMap.get(useArtifact.getNewArtifactId());
            MesBuildingArtifactScheduling scheduling = this.mesBuildingArtifactSchedulingService
               .getOne(
                  Wrappers.lambdaQuery(MesBuildingArtifactScheduling.class)
                     .eq(MesBuildingArtifactScheduling::getProductionLineId, task.getProductionLineId())
                     .eq(MesBuildingArtifactScheduling::getProductId, newArtifact.getId())
               );
            newTask.setSchedulingId(scheduling.getId());
            newTask.setProjectId(newArtifact.getProjectId());
            newTask.setMonomerId(newArtifact.getMonomerId());
            newTask.setAreaId(newArtifact.getAreaId());
            newTask.setAreaBatchId(newArtifact.getAreaBatchId());
            newTask.setProductId(newArtifact.getId());
            newTask.setTaskQuantity(1);
            newTask.setInProductionQuantity(numberLink.getBoolArtifactInproduce() ? 1 : 0);
            newTask.setCompleteQuantity(numberLink.getBoolArtifactComplete() ? 1 : 0);
            this.taskService.save(newTask);
            newArtTaskMap.put(newTask.getTaskOrderId() + "_" + useArtifact.getNewArtifactId(), newTask);
            MesBuildingSecondUseDTO secondUseDTO = MesBuildingSecondUseDTO.builder()
               .taskId(newTask.getId())
               .productId(useArtifact.getNewArtifactId())
               .taskProcessId(0L)
               .boolArtifactInproduce(Boolean.FALSE)
               .boolOneArtifactInproduce(Boolean.FALSE)
               .boolArtifactReport(Boolean.FALSE)
               .boolArtifactInspection(Boolean.FALSE)
               .boolArtifactComplete(Boolean.FALSE)
               .number(useArtifact.getNewSortNumber())
               .boolOnecode(newTask.getBoolOneCode())
               .build();
            List<MesBuildingTaskProcess> newArtTaskProcessList = new ArrayList<>();
            Integer needQuantity = 0;
            if (CollectionUtils.isNotEmpty(lastTaskProcessList)) {
               Map<Long, List<MesBuildingNextProcessLink>> nextProcessLinkMap = this.nextProcessLinkService
                  .list(
                     (Wrapper<MesBuildingNextProcessLink>)new LambdaQueryWrapper<MesBuildingNextProcessLink>()
                        .in(
                           MesBuildingNextProcessLink::getTaskProcessId,
                           lastTaskProcessList.stream().map(MesBuildingTaskProcess::getId).collect(Collectors.toList())
                        )
                  )
                  .stream()
                  .collect(Collectors.groupingBy(MesBuildingNextProcessLink::getTaskProcessId));
               Preconditions.checkArgument(!lastArt.getBoolAllPartSendDirectly(), "操作失败!!原构件为直发檩条!!不应存在生产工序!!!");
               lastTaskProcessList.sort(Comparator.comparingInt(MesBuildingTaskProcess::getSequence));

               for (int i = 0; i < lastTaskProcessList.size(); i++) {
                  MesBuildingTaskProcess lastProcess = lastTaskProcessList.get(i);
                  List<MesBuildingNextProcessLink> mesBuildingNextProcessLinks = nextProcessLinkMap.get(lastProcess.getId());
                  Preconditions.checkArgument(
                     CollectionUtils.isNotEmpty(mesBuildingNextProcessLinks) || mesBuildingNextProcessLinks.size() == 1, "操作失败,暂不支持并行工序变更!"
                  );
                  MesBuildingNextProcessLink nextProcessLink = mesBuildingNextProcessLinks.get(0);
                  MesBuildingProduceTeamReport lastTeamReport = lastReportMap.get(lastProcess.getProcessId());
                  MesBuildingProduceInspectionTeamReport lastTeamInspectReport = lastInspectMap.get(lastProcess.getProcessId());
                  MesBuildingTaskProcess newTaskProcess = BeanUtil.copy(lastProcess, MesBuildingTaskProcess.class);
                  newTaskProcess.setId(null);
                  newTaskProcess.setProjectId(newArtifact.getProjectId());
                  newTaskProcess.setMonomerId(newArtifact.getMonomerId());
                  newTaskProcess.setAreaId(newArtifact.getAreaId());
                  newTaskProcess.setAreaBatchId(newArtifact.getAreaBatchId());
                  newTaskProcess.setProductId(newArtifact.getId());
                  newTaskProcess.setTaskId(newTask.getId());
                  newTaskProcess.setTaskQuantity(1);
                  if (lastProcess.getSequence().equals(0)) {
                     newTaskProcess.setNeedQuantity(1);
                  } else {
                     newTaskProcess.setNeedQuantity(needQuantity);
                  }

                  if (lastTeamReport != null) {
                     secondUseDTO.setBoolOneArtifactInproduce(Boolean.TRUE);
                     newTaskProcess.setCompleteQuantity(1);
                     newTaskProcess.setInspectionQuantity(lastTeamReport.getInspectionQuantity());
                     newTaskProcess.setProblemQuantity(lastTeamReport.getProblemQuantity());
                  } else {
                     newTaskProcess.setCompleteQuantity(0);
                     newTaskProcess.setInspectionQuantity(0);
                     newTaskProcess.setProblemQuantity(0);
                  }

                  needQuantity = newTaskProcess.getInspectionQuantity();
                  this.taskProcessService.save(newTaskProcess);
                  newArtTaskProcessList.add(newTaskProcess);
                  if (secondUseDTO.getTaskProcessId() == 0L) {
                     secondUseDTO.setTaskProcessId(newTaskProcess.getId());
                  }

                  secondUseDTO.setBoolHaveNextProcess(nextProcessLink != null && nextProcessLink.getNextProcessId() != null);
                  if (lastTeamReport != null) {
                     secondUseDTO.setTaskProcessIdIndex(0);
                     secondUseDTO.setTaskProcessId(newTaskProcess.getId());
                     secondUseDTO.setBoolArtifactInproduce(Boolean.TRUE);
                     secondUseDTO.setBoolArtifactReport(Boolean.TRUE);
                     secondUseDTO.setBoolArtifactInspection(lastTeamReport.getInspectionQuantity() > 0);
                     if (nextProcessLink == null || nextProcessLink.getNextProcessId() == null) {
                        secondUseDTO.setBoolHaveNextProcess(Boolean.FALSE);
                        if (lastTeamReport.getInspectionQuantity() == 0) {
                           secondUseDTO.setBoolArtifactReport(Boolean.TRUE);
                           secondUseDTO.setBoolArtifactInspection(Boolean.FALSE);
                        } else {
                           secondUseDTO.setTaskProcessId(0L);
                        }
                     } else if (lastTeamReport.getInspectionQuantity() > 0) {
                        secondUseDTO.setTaskProcessIdIndex(i + 1);
                        secondUseDTO.setBoolArtifactReport(Boolean.FALSE);
                        secondUseDTO.setBoolArtifactInspection(Boolean.FALSE);
                     }
                  }

                  secondUseDTO.setBoolArtifactInproduce(lastTeamReport != null);
                  if (lastTeamReport != null) {
                     MesBuildingProduceTeamReport newTeamReport = BeanUtil.copy(lastTeamReport, MesBuildingProduceTeamReport.class);
                     newTeamReport.setUseById(newTeamReport.getId());
                     newTeamReport.setId(null);
                     newTeamReport.setTaskId(newTask.getId());
                     newTeamReport.setTaskProcessId(newTaskProcess.getId());
                     newTeamReport.setProductId(useArtifact.getNewArtifactId());
                     newTeamReport.setNumber(useArtifact.getNewSortNumber());
                     newTeamReport.setReportNumber(reportNumber);
                     newTeamReport.setWorkshopId(newTask.getWorkshopId());
                     newTeamReport.setProductionLineId(newTask.getProductionLineId());
                     newTeamReport.setAssistId(null);
                     reportNumber = this.redisUtils.incr("teamreport_reportnumber:", 1L);
                     needAppendTeamReport.add(newTeamReport);
                  }

                  if (lastTeamInspectReport != null) {
                     MesBuildingProduceInspectionTeamReport newTeamInspectReport = BeanUtil.copy(
                        lastTeamInspectReport, MesBuildingProduceInspectionTeamReport.class
                     );
                     newTeamInspectReport.setUseById(newTeamInspectReport.getId());
                     newTeamInspectReport.setId(null);
                     newTeamInspectReport.setTaskId(newTask.getId());
                     newTeamInspectReport.setTaskProcessId(newTaskProcess.getId());
                     newTeamInspectReport.setProductId(useArtifact.getNewArtifactId());
                     newTeamInspectReport.setNumber(useArtifact.getNewSortNumber());
                     newTeamInspectReport.setInspectReportNumber(InspectNumber);
                     InspectNumber = this.redisUtils.incr("inspection_reportnumber:", 1L);
                     needAppendTeamInspectReport.add(newTeamInspectReport);
                  }

                  secondUseDTO.setBoolArtifactComplete(complete != null);
               }

               if (secondUseDTO.getTaskProcessIdIndex() != null && secondUseDTO.getTaskProcessIdIndex() != 0) {
                  secondUseDTO.setTaskProcessId(newArtTaskProcessList.get(secondUseDTO.getTaskProcessIdIndex()).getId());
               }

               if (complete != null) {
                  MesBuildingComplete newComplete = BeanUtil.copy(complete, MesBuildingComplete.class);
                  newComplete.setProductId(newTask.getProductId());
                  newComplete.setNumber(useArtifact.getNewSortNumber());
                  newComplete.setProjectId(newComplete.getProjectId());
                  newComplete.setMonomerId(newComplete.getMonomerId());
                  newComplete.setAreaId(newComplete.getAreaId());
                  newComplete.setAreaBatchId(newComplete.getAreaBatchId());
                  newComplete.setTaskId(newTask.getId());
                  needComplete.add(newComplete);
                  newArtifact.setProducedQuantity(newArtifact.getProducedQuantity() + 1);
               }
            } else {
               Preconditions.checkArgument(lastArt.getBoolAllPartSendDirectly(), "操作失败!!原构件不是直发檩条!!生产工序丢失!!!");
            }

            taskAddNumbers.add(secondUseDTO);
            if (lastArt.getBoolAllPartSendDirectly()) {
               MesBuildingSinglePartArtifactPrint print = singPartMap.get(useArtifact.getLastArtifactId() + "_" + useArtifact.getLastSortNumber());
               MesBuildingSinglePartArtifactPrint newSing = BeanUtil.copy(print, MesBuildingSinglePartArtifactPrint.class);
               newSing.setId(null);
               newSing.setTaskId(newTask.getId());
               newSing.setProductId(useArtifact.getNewArtifactId());
               newSing.setNumber(useArtifact.getNewSortNumber());
               if (!newSing.getBoolAllReport()) {
                  newSing.setQuantity(1);
               }

               appendSings.add(newSing);
            }

            newArtTaskProcessMap.put(newTask.getId(), newArtTaskProcessList);
            newArtTaskProcessNewMap.put(newTask.getId(), newArtTaskProcessList);
         }
      }

      ArrayList<TechArtifact> techArtifacts = new ArrayList<>(newArtMap.values());
      this.artifactService.updateBatchById(techArtifacts);
      List<MesBuildingTask> newTasks = new ArrayList<>(newArtTaskMap.values());
      Preconditions.checkArgument(newTasks.stream().allMatch(s -> s.getTaskQuantity() >= s.getCompleteQuantity()), "操作失败!!!");
      this.taskService.updateBatchById(newTasks);
      List<MesBuildingTaskProcess> newTaskProcess = newArtTaskProcessMap.keySet()
         .stream()
         .map(newArtTaskProcessMap::get)
         .flatMap(Collection::stream)
         .collect(Collectors.toList());
      Preconditions.checkArgument(newTaskProcess.stream().allMatch(s -> s.getTaskQuantity() >= s.getNeedQuantity()), "操作失败!!!");
      Preconditions.checkArgument(newTaskProcess.stream().allMatch(s -> s.getNeedQuantity() >= s.getCompleteQuantity()), "操作失败!!!");
      Preconditions.checkArgument(newTaskProcess.stream().allMatch(s -> s.getCompleteQuantity() >= s.getInspectionQuantity()), "操作失败!!!");
      List<MesBuildingTaskProcess> newTaskNewProcess = newArtTaskProcessNewMap.keySet()
         .stream()
         .map(newArtTaskProcessMap::get)
         .flatMap(Collection::stream)
         .collect(Collectors.toList());
      Map<Long, List<MesBuildingTaskProcess>> taskProcessMap = newTaskNewProcess.stream().collect(Collectors.groupingBy(MesBuildingTaskProcess::getProductId));
      List<MesBuildingNextProcessLink> nextProcessLinks = new ArrayList<>();
      taskProcessMap.forEach(
         (productId, taskProcessList) -> {
            Map<Integer, MesBuildingTaskProcess> newTaskProcessMapx = taskProcessList.stream()
               .collect(Collectors.toMap(MesBuildingTaskProcess::getSequence, Function.identity()));
            newTaskProcessMapx.forEach((sequence, taskProcess) -> {
               MesBuildingNextProcessLink nextProcessLink = MesBuildingNextProcessLink.builder().taskProcessId(taskProcess.getId()).sequence(sequence).build();
               MesBuildingTaskProcess nextTaskProcess = newTaskProcessMapx.get(sequence + 1);
               if (nextTaskProcess != null) {
                  nextProcessLink.setNextProcessId(nextTaskProcess.getProcessId());
               }

               nextProcessLinks.add(nextProcessLink);
            });
         }
      );
      this.nextProcessLinkService.saveBatch(nextProcessLinks);
      this.taskProcessService.updateBatchById(newTaskProcess);
      if (CollectionUtils.isNotEmpty(needAppendTeamReport)) {
         List<MesBuildingProduceTeamReport> assistReports = needAppendTeamReport.stream().filter(e -> e.getAssistId() != null).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(assistReports)) {
            Map<String, List<MesBuildingProduceTeamReport>> assistProduceTeamReportMap = assistReports.stream()
               .collect(Collectors.groupingBy(e -> e.getTaskProcessId() + "-" + e.getProductionLineId() + "-" + e.getTeamId()));
            assistProduceTeamReportMap.forEach(
               (key, produceTeamReportList) -> {
                  MesBuildingProduceTeamReport report = produceTeamReportList.get(0);
                  MesBuildingAssist assist = this.assistService
                     .getOne(
                        (Wrapper<MesBuildingAssist>)((new LambdaQueryWrapper<MesBuildingAssist>()
                                 .eq(MesBuildingAssist::getTaskProcessId, report.getTaskProcessId()))
                              .eq(MesBuildingAssist::getProductionLineId, report.getProductionLineId()))
                           .eq(MesBuildingAssist::getTeamId, report.getTeamId())
                     );
                  if (assist != null) {
                     assist.setProduceQuantity(assist.getProduceQuantity() + produceTeamReportList.size());
                     assist.setQuantity(assist.getQuantity() + produceTeamReportList.size());
                     this.assistService.updateById(assist);
                  } else {
                     assist = MesBuildingAssist.builder()
                        .taskId(report.getTaskId())
                        .userId(UserUtil.getCurrentUserId())
                        .taskProcessId(report.getId())
                        .boolFinishEnum(Boolean.FALSE)
                        .quantity(produceTeamReportList.size())
                        .productionLineId(report.getProductionLineId())
                        .processId(report.getProcessId())
                        .teamId(report.getTeamId())
                        .projectId(projectId)
                        .productType(report.getTaskTypeEnum())
                        .build();
                     this.assistService.save(assist);
                  }

                  for (MesBuildingProduceTeamReport produceTeamReport : produceTeamReportList) {
                     MesBuildingAssistNumberDetail numberDetail = MesBuildingAssistNumberDetail.builder()
                        .assistId(assist.getId())
                        .taskProcessId(assist.getTaskProcessId())
                        .taskId(assist.getTaskId())
                        .productionLineId(assist.getProductionLineId())
                        .userId(UserUtil.getCurrentUserId())
                        .productId(produceTeamReport.getProductId())
                        .taskType(assist.getProductType())
                        .number(produceTeamReport.getNumber())
                        .boolFinishEnum(Boolean.TRUE)
                        .processId(assist.getProcessId())
                        .teamId(assist.getTeamId())
                        .projectId(assist.getProjectId())
                        .productType(assist.getProductType())
                        .build();
                     this.assistNumberDetailService.save(numberDetail);
                     produceTeamReport.setAssistId(numberDetail.getAssistId());
                  }
               }
            );
         }

         this.mesBuildingProduceTeamReportService.saveBatch(needAppendTeamReport);
         List<Long> taskProcessIds = needAppendTeamReport.stream().map(MesBuildingProduceTeamReport::getTaskProcessId).distinct().collect(Collectors.toList());
         List<MesBuildingProduceTeamReportSummary> reportSummaries = this.produceTeamReportSummaryService
            .list(
               (Wrapper<MesBuildingProduceTeamReportSummary>)Wrappers.<MesBuildingProduceTeamReportSummary>lambdaQuery().in(MesBuildingProduceTeamReportSummary::getTaskProcessId, taskProcessIds)
            );
         Map<String, MesBuildingProduceTeamReportSummary> summaryMap = reportSummaries.stream()
            .collect(Collectors.toMap(s -> s.getTaskProcessId() + "_" + s.getGroupsId() + "_" + s.getTeamId(), Function.identity()));

         for (MesBuildingProduceTeamReport teamReport : needAppendTeamReport) {
            String key = teamReport.getTaskProcessId() + "_" + teamReport.getGroupsId() + "_" + teamReport.getTeamId();
            MesBuildingProduceTeamReportSummary reportSummary = summaryMap.get(key);
            if (reportSummary == null) {
               MesBuildingProduceTeamReportSummary summary = MesBuildingProduceTeamReportSummary.builder()
                  .productId(teamReport.getProductId())
                  .taskTypeEnum(teamReport.getTaskTypeEnum())
                  .processId(teamReport.getProcessId())
                  .taskId(teamReport.getTaskId())
                  .groupsId(teamReport.getGroupsId())
                  .productionLineId(teamReport.getProductionLineId())
                  .teamId(teamReport.getTeamId())
                  .taskProcessId(teamReport.getTaskProcessId())
                  .quantity(teamReport.getQuantity())
                  .userId(UserUtil.getCurrentUserId())
                  .inspectionQuantity(teamReport.getInspectionQuantity())
                  .problemQuantity(teamReport.getProblemQuantity())
                  .schedulingId(teamReport.getSchedulingId())
                  .build();
               summaryMap.put(key, summary);
            } else {
               reportSummary.setQuantity(reportSummary.getQuantity() + teamReport.getQuantity());
               reportSummary.setInspectionQuantity(reportSummary.getInspectionQuantity() + teamReport.getInspectionQuantity());
               reportSummary.setProblemQuantity(reportSummary.getProblemQuantity() + teamReport.getProblemQuantity());
            }
         }

         List<MesBuildingProduceTeamReportSummary> summaryList = new ArrayList<>(summaryMap.values());
         List<MesBuildingProduceTeamReportSummary> needSaveSummarys = summaryList.stream().filter(s -> s.getId() == null).collect(Collectors.toList());
         List<MesBuildingProduceTeamReportSummary> needUpdateSummarys = summaryList.stream().filter(s -> s.getId() != null).collect(Collectors.toList());
         this.produceTeamReportSummaryService.saveBatch(needSaveSummarys);
         this.produceTeamReportSummaryService.updateBatchById(needUpdateSummarys);
         this.inspectionTeamReportService.saveBatch(needAppendTeamInspectReport);
      }

      if (CollectionUtils.isNotEmpty(needComplete)) {
         this.completeService.saveBatch(needComplete);
         this.secondUseAddWrehouseByCompletes(needComplete);
         Map<String, MesBuildingComplete> newCompleteMap = needComplete.stream()
            .collect(Collectors.toMap(s -> s.getProductId() + "_" + s.getNumber(), Function.identity()));

         for (MesBuildingSinglePartArtifactPrint appendSing : appendSings) {
            MesBuildingComplete complete = newCompleteMap.get(appendSing.getProductId() + "_" + appendSing.getNumber());
            if (complete != null) {
               appendSing.setCompleteId(complete.getId());
            }
         }
      }

      if (CollectionUtils.isNotEmpty(appendSings)) {
         this.singlePartArtifactPrintService.saveBatch(appendSings);
      }

      Map<Long, Integer> addTaskMap = taskAddNumbers.stream().collect(Collectors.toMap(MesBuildingSecondUseDTO::getTaskId, s -> 1, Integer::sum));
      List<MesBuildingTask> appendTasks = this.taskService.listByIds(addTaskMap.keySet());
      Map<Long, Long> taskOrderLink = appendTasks.stream().collect(Collectors.toMap(MesBuildingTask::getId, MesBuildingTask::getTaskOrderId));
      Map<Long, Integer> orderMap = addTaskMap.keySet()
         .stream()
         .collect(Collectors.toMap(taskId -> taskOrderLink.getOrDefault(taskId, 0L), addTaskMap::get, Integer::sum));
      List<MesBuildingTaskOrder> taskOrders = this.taskOrderService.listByIds(orderMap.keySet());
      taskOrders.forEach(s -> s.setQuantity(s.getQuantity() + orderMap.get(s.getId())));
      this.taskOrderService.updateBatchById(taskOrders);
      Map<Long, Long> topTaskOrderLink = appendTasks.stream().collect(Collectors.toMap(MesBuildingTask::getId, MesBuildingTask::getTopTaskOrderId));
      Map<Long, Integer> topOrderMap = addTaskMap.keySet()
         .stream()
         .collect(Collectors.toMap(taskId -> topTaskOrderLink.getOrDefault(taskId, 0L), addTaskMap::get, Integer::sum));
      List<MesBuildingTopTaskOrder> topTaskOrders = this.topTaskOrderService.listByIds(topOrderMap.keySet());
      topTaskOrders.forEach(s -> s.setQuantity(s.getQuantity() + topOrderMap.get(s.getId())));
      this.topTaskOrderService.updateBatchById(topTaskOrders);
      List<TechAssembleDetail> assembleDetails = this.assembleDetailService
         .list(Wrappers.lambdaQuery(TechAssembleDetail.class).in(TechAssembleDetail::getArtifactId, newArtIds));
      Map<Long, TechAssemble> assembleMap = new HashMap<>();
      Map<Long, List<TechAssembleExt>> assExtMap = new HashMap<>();
      Map<Long, List<TechAssembleDetail>> assDetailMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(assembleDetails)) {
         assDetailMap = assembleDetails.stream().collect(Collectors.groupingBy(TechAssembleDetail::getArtifactId));
         List<Long> assIds = assembleDetails.stream().map(TechAssembleDetail::getAssembleId).distinct().collect(Collectors.toList());
         List<TechAssemble> assembleList = this.assembleService.listByIds(assIds);
         assembleMap = assembleList.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
         List<TechAssembleExt> assembleExts = this.assembleExtService
            .list(Wrappers.lambdaQuery(TechAssembleExt.class).in(TechAssembleExt::getAssembleId, assIds).eq(TechAssembleExt::getBoolTask, false));
         assExtMap = assembleExts.stream().collect(Collectors.groupingBy(TechAssembleExt::getAssembleId));
      }

      List<TechArtifactMachinePartLink> partLinks = this.artifactMachinePartLinkService
         .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getArtifactId, newArtIds));
      Map<Long, List<TechArtifactMachinePartLink>> partLinkMap = new HashMap<>();
      Map<Long, TechMachinePart> partMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(partLinks)) {
         partLinkMap = partLinks.stream().collect(Collectors.groupingBy(TechArtifactMachinePartLink::getArtifactId));
         List<Long> partIds = partLinks.stream().map(TechArtifactMachinePartLink::getMachinePartId).distinct().collect(Collectors.toList());
         List<TechMachinePart> machineParts = this.machinePartService.listByIds(partIds);
         partMap = machineParts.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
      }

      List<MesBuildingTaskNumberLink> appendNumbers = new ArrayList<>();
      List<Long> newTaskIds = taskAddNumbers.stream().map(MesBuildingSecondUseDTO::getTaskId).collect(Collectors.toList());
      List<MesBuildingTaskProcess> newTaskProcesses = this.taskProcessService
         .list((Wrapper<MesBuildingTaskProcess>)new LambdaQueryWrapper<MesBuildingTaskProcess>().in(MesBuildingTaskProcess::getTaskId, newTaskIds));
      Map<Long, List<MesBuildingTaskProcess>> newTaskProcessListMap = newTaskProcesses.stream()
         .collect(Collectors.groupingBy(MesBuildingTaskProcess::getTaskId));
      Map<Long, MesBuildingTaskProcess> newTaskProcessMap = newTaskProcesses.stream()
         .collect(Collectors.toMap(MesBuildingTaskProcess::getId, Function.identity()));

      for (MesBuildingSecondUseDTO taskAddNumber : taskAddNumbers) {
         MesBuildingTaskProcess taskProcess = newTaskProcessMap.get(taskAddNumber.getTaskProcessId());
         List<MesBuildingTaskProcess> taskProcessList = newTaskProcessListMap.get(taskAddNumber.getTaskId());
         List<MesBuildingTaskProcess> collect = taskProcessList.stream()
            .sorted(Comparator.comparing(MesBuildingTaskProcess::getSequence))
            .collect(Collectors.toList());
         MesBuildingTaskProcess nextTaskProcess = null;
         if (taskProcess != null && taskAddNumber.getBoolHaveNextProcess() && CollectionUtils.isNotEmpty(collect)) {
            nextTaskProcess = collect.get(taskProcess.getSequence() + 1);
         }

         List<TechAssembleDetail> assDetailList = assDetailMap.get(taskAddNumber.getProductId());
         if (CollectionUtils.isNotEmpty(assDetailList)) {
            for (TechAssembleDetail detail : assDetailList) {
               Integer quantity = detail.getQuantity();
               List<TechAssembleExt> assembleExts = assExtMap.get(detail.getAssembleId());
               Preconditions.checkArgument(assembleExts.size() >= quantity, "绑码失败!!!");

               for (int i = 0; i < quantity; i++) {
                  TechAssembleExt assembleExt = assembleExts.get(0);
                  MesBuildingTaskNumberLink numberLink = MesBuildingTaskNumberLink.builder()
                     .artifactId(taskAddNumber.getProductId())
                     .artifactNumber(taskAddNumber.getNumber())
                     .artifactTaskId(taskAddNumber.getTaskId())
                     .artifactTaskProcessId(taskAddNumber.getTaskProcessId())
                     .boolArtifactInproduce(taskAddNumber.getBoolArtifactInproduce())
                     .boolArtifactReport(taskAddNumber.getBoolArtifactReport())
                     .boolArtifactInspection(taskAddNumber.getBoolArtifactInspection())
                     .boolArtifactComplete(taskAddNumber.getBoolArtifactComplete())
                     .boolOneCode(taskAddNumber.getBoolOnecode())
                     .assembleId(detail.getAssembleId())
                     .assembleNumber(assembleExt.getSortNumber())
                     .boolAssembleComplete(Boolean.TRUE)
                     .boolSecondUse(Boolean.TRUE)
                     .build();
                  assembleExts.remove(0);
                  if (numberLink.getBoolArtifactReport() && nextTaskProcess != null) {
                     numberLink.setArtifactNextProcessId(nextTaskProcess.getProcessId());
                  }

                  appendNumbers.add(numberLink);
               }

               TechAssemble assemble = assembleMap.get(detail.getAssembleId());
               assemble.setProducedQuantity(assemble.getProducedQuantity() + quantity);
               assemble.setUseCompleteQuantity(assemble.getUseCompleteQuantity() + quantity);
               if (taskAddNumber.getBoolOneArtifactInproduce()) {
                  assemble.setUsedQuantity(assemble.getUsedQuantity() + quantity);
               }

               assembleMap.put(detail.getAssembleId(), assemble);
            }
         } else {
            MesBuildingTaskNumberLink numberLink = MesBuildingTaskNumberLink.builder()
               .artifactId(taskAddNumber.getProductId())
               .artifactNumber(taskAddNumber.getNumber())
               .artifactTaskId(taskAddNumber.getTaskId())
               .artifactTaskProcessId(taskAddNumber.getTaskProcessId())
               .boolArtifactInproduce(taskAddNumber.getBoolArtifactInproduce())
               .boolArtifactReport(taskAddNumber.getBoolArtifactReport())
               .boolArtifactInspection(taskAddNumber.getBoolArtifactInspection())
               .boolArtifactComplete(taskAddNumber.getBoolArtifactComplete())
               .boolSecondUse(Boolean.TRUE)
               .boolOneCode(taskAddNumber.getBoolOnecode())
               .boolAssembleComplete(Boolean.TRUE)
               .build();
            if (numberLink.getBoolArtifactReport() && nextTaskProcess != null) {
               numberLink.setArtifactNextProcessId(nextTaskProcess.getProcessId());
            }

            appendNumbers.add(numberLink);
         }

         List<TechArtifactMachinePartLink> partLinkList = partLinkMap.get(taskAddNumber.getProductId());
         if (CollectionUtils.isNotEmpty(partLinkList)) {
            for (TechArtifactMachinePartLink link : partLinkList) {
               Integer quantity = link.getQuantity();
               TechMachinePart machinePart = partMap.get(link.getMachinePartId());
               machinePart.setProducedQuantity(machinePart.getProducedQuantity() + quantity);
               machinePart.setUseCompleteQuantity(machinePart.getUseCompleteQuantity() + quantity);
               if (taskAddNumber.getBoolOneArtifactInproduce()) {
                  machinePart.setUsedQuantity(machinePart.getUsedQuantity() + quantity);
               }

               partMap.put(link.getMachinePartId(), machinePart);
            }
         }
      }

      this.numberLinkService.saveBatch(appendNumbers);
      List<Long> artTaskIds = appendNumbers.stream().map(MesBuildingTaskNumberLink::getArtifactTaskId).distinct().collect(Collectors.toList());
      Map<Long, MesBuildingTask> taskMap = this.taskService
         .listByIds(artTaskIds)
         .stream()
         .collect(Collectors.toMap(MesBuildingTask::getId, Function.identity()));
      List<TechAssemble> techAssembles = new ArrayList<>(assembleMap.values());
      this.assembleService.updateBatchById(techAssembles);
      List<TechMachinePart> parts = new ArrayList<>(partMap.values());
      this.machinePartService.updateBatchById(parts);
      this.updateExts(appendNumbers);
      List<MesBuildingComplete> needCompletes = new ArrayList<>();
      List<String> artNumbers = new ArrayList<>();

      for (MesBuildingTaskNumberLink senAppend : appendNumbers) {
         MesBuildingTask task = taskMap.get(senAppend.getArtifactTaskId());
         if (senAppend.getAssembleId() != null) {
            TechAssemble assemble = assembleMap.get(senAppend.getAssembleId());
            if (assemble.getBoolSendDirectly()) {
               MesBuildingComplete complete = MesBuildingComplete.builder()
                  .projectId(assemble.getProjectId())
                  .monomerId(assemble.getMonomerId())
                  .areaId(assemble.getAreaId())
                  .areaBatchId(assemble.getAreaBatchId())
                  .factoryId(task.getFactoryId())
                  .number(senAppend.getAssembleNumber())
                  .workshopId(task.getWorkshopId())
                  .productionLineId(task.getProductionLineId())
                  .productId(assemble.getId())
                  .quantity(1)
                  .taskTypeEnum(TaskTypeEnum.ASSEMBLE.getType())
                  .boolAbnormalEnum(false)
                  .userId(UserUtil.getCurrentUserId())
                  .artifactTaskId(task.getId())
                  .parentType(TaskTypeEnum.ARTIFACT.getType())
                  .numberLinkId(senAppend.getId())
                  .build();
               needCompletes.add(complete);
            }
         }

         if (!artNumbers.contains(senAppend.getArtifactId() + "_" + senAppend.getArtifactNumber())) {
            artNumbers.add(senAppend.getArtifactId() + "_" + senAppend.getArtifactNumber());
            List<TechArtifactMachinePartLink> partLinkList = partLinkMap.get(senAppend.getArtifactId());
            if (CollectionUtils.isNotEmpty(partLinkList)) {
               for (TechArtifactMachinePartLink link : partLinkList) {
                  TechMachinePart machinePart = partMap.get(link.getMachinePartId());
                  if (machinePart.getRelationType().equals(2) && machinePart.getBoolSendDirectly()) {
                     MesBuildingComplete complete = MesBuildingComplete.builder()
                        .projectId(machinePart.getProjectId())
                        .monomerId(machinePart.getMonomerId())
                        .areaId(machinePart.getAreaId())
                        .areaBatchId(machinePart.getAreaBatchId())
                        .factoryId(task.getFactoryId())
                        .number(senAppend.getAssembleNumber())
                        .workshopId(task.getWorkshopId())
                        .productionLineId(task.getProductionLineId())
                        .productId(machinePart.getId())
                        .quantity(link.getQuantity())
                        .taskTypeEnum(TaskTypeEnum.MACHINE_PART.getType())
                        .boolAbnormalEnum(false)
                        .userId(UserUtil.getCurrentUserId())
                        .artifactTaskId(task.getId())
                        .parentType(TaskTypeEnum.ARTIFACT.getType())
                        .numberLinkId(senAppend.getId())
                        .build();
                     needCompletes.add(complete);
                  }
               }
            }
         }
      }

      if (CollectionUtils.isNotEmpty(needCompletes)) {
         this.completeService.saveBatch(needCompletes);
         this.secondUseAddWrehouseByCompletes(needCompletes);
      }

      List<TechChangeArtifactDelDtoParam> changeList = useArtifacts.stream()
         .map(s -> TechChangeArtifactDelDtoParam.builder().artifactId(s.getLastArtifactId()).sortNumber(s.getLastSortNumber()).build())
         .collect(Collectors.toList());
      this.deleteArtifacts(changeList, Boolean.TRUE);
   }

   private void updateExts(List<MesBuildingTaskNumberLink> appendNumbers) {
      List<String> keys = new ArrayList<>();
      List<NumberInfoDTO> artNumber = new ArrayList<>();

      for (MesBuildingTaskNumberLink appendNumber : appendNumbers) {
         String key = appendNumber.getArtifactId() + "_" + appendNumber.getArtifactNumber();
         if (!keys.contains(key)) {
            artNumber.add(NumberInfoDTO.builder().productId(appendNumber.getArtifactId()).number(appendNumber.getArtifactNumber()).build());
            keys.add(key);
         }
      }

      Map<String, MesBuildingTaskNumberLink> artNumberMap = appendNumbers.stream()
         .collect(Collectors.toMap(s -> s.getArtifactId() + "_" + s.getArtifactNumber(), Function.identity(), (s1, s2) -> s1));
      List<TechArtifactExt> artifactExtList = this.artifactExtService.listArtifact(artNumber);
      Preconditions.checkArgument(artifactExtList.size() == artNumber.size(), "操作失败!!!");

      for (TechArtifactExt techArtifactExt : artifactExtList) {
         String key = techArtifactExt.getArtifactId() + "_" + techArtifactExt.getSortNumber();
         MesBuildingTaskNumberLink numberLink = artNumberMap.get(key);
         techArtifactExt.setBoolTask(Boolean.TRUE);
         techArtifactExt.setTaskId(numberLink.getArtifactTaskId());
         techArtifactExt.setBoolScheduling(Boolean.TRUE);
      }

      this.artifactExtService.updateBatchById(artifactExtList);
      List<NumberInfoDTO> assNumber = appendNumbers.stream()
         .filter(s -> s.getAssembleId() != null)
         .map(s -> NumberInfoDTO.builder().productId(s.getAssembleId()).number(s.getAssembleNumber()).build())
         .collect(Collectors.toList());
      Map<String, MesBuildingTaskNumberLink> assNumberMap = appendNumbers.stream()
         .filter(s -> s.getAssembleId() != null)
         .collect(Collectors.toMap(s -> s.getAssembleId() + "_" + s.getAssembleNumber(), Function.identity()));
      if (CollectionUtils.isNotEmpty(assNumber)) {
         List<TechAssembleExt> assembleExtList = this.assembleExtService.listAssExt(assNumber);
         Preconditions.checkArgument(assembleExtList.size() == assNumber.size(), "操作失败!!!");

         for (TechAssembleExt assembleExt : assembleExtList) {
            String key = assembleExt.getAssembleId() + "_" + assembleExt.getSortNumber();
            MesBuildingTaskNumberLink numberLink = assNumberMap.get(key);
            assembleExt.setBoolTask(Boolean.TRUE);
         }

         this.assembleExtService.updateBatchById(assembleExtList);
      }
   }

   private void secondUseAddWrehouseByCompletes(List<MesBuildingComplete> completes) {
      List<AddWarehouseDTO> addWarehouseDTOS = new ArrayList<>();

      for (MesBuildingComplete complete : completes) {
         AddWarehouseDTO build = AddWarehouseDTO.builder()
            .factoryId(complete.getFactoryId())
            .workshopId(complete.getWorkshopId())
            .productType(complete.getTaskTypeEnum())
            .productId(complete.getProductId())
            .type(WarehouseTypeEnum.INTO.getType())
            .build();
         addWarehouseDTOS.add(build);
      }

      List<MesBuildingWarehouseSummary> summaries = this.warehouseSummaryService.listWareHouseSummary(addWarehouseDTOS);
      List<MesBuildingWarehouseRecord> records = new ArrayList<>();

      for (MesBuildingComplete complete : completes) {
         MesBuildingWarehouseRecord record = BeanUtil.copy(complete, MesBuildingWarehouseRecord.class);
         record.setCompleteId(complete.getId());
         record.setQuantity(BigDecimal.valueOf(complete.getQuantity().intValue()));
         record.setUserId(UserUtil.getCurrentUserId());
         record.setUserName(UserUtil.getCurrentName());
         record.setNumber(complete.getNumber());
         record.setProductType(complete.getTaskTypeEnum());
         record.setStatus(WarehouseRecordStatusTypeEnum.INTO.getType());
         record.setType(WarehouseTypeEnum.INTO.getType());
         records.add(record);
      }

      this.warehouseRecordService.saveBatch(records);
      Map<String, List<MesBuildingComplete>> completeMap = completes.stream()
         .collect(
            Collectors.groupingBy(
               s -> s.getFactoryId()
                  + "_"
                  + s.getWorkshopId()
                  + "_"
                  + s.getTaskTypeEnum()
                  + "_"
                  + s.getProductId()
                  + "_"
                  + WarehouseRecordStatusTypeEnum.INTO.getType()
            )
         );
      Map<String, MesBuildingWarehouseSummary> summaryMap = summaries.stream()
         .collect(
            Collectors.toMap(
               s -> s.getFactoryId() + "_" + s.getWorkshopId() + "_" + s.getProductType() + "_" + s.getProductId() + "_" + s.getType(), Function.identity()
            )
         );
      Map<String, MesBuildingWarehouseSummary> saveSummaryMap = new HashMap<>();

      for (String key : completeMap.keySet()) {
         List<MesBuildingComplete> completeList = completeMap.get(key);
         int quantity = completeList.stream().mapToInt(MesBuildingComplete::getQuantity).sum();
         MesBuildingWarehouseSummary summary = summaryMap.get(key);
         Long factoryId = Long.valueOf(key.split("_")[0]);
         Long workShopId = Long.valueOf(key.split("_")[1]);
         Integer taskType = Integer.valueOf(key.split("_")[2]);
         Long productId = Long.valueOf(key.split("_")[3]);
         Integer wareHouseType = Integer.valueOf(key.split("_")[4]);
         if (summary == null) {
            MesBuildingWarehouseSummary saveSummary = saveSummaryMap.get(key);
            if (saveSummary == null) {
               saveSummary = BeanUtil.copy(completes.get(0), MesBuildingWarehouseSummary.class);
               saveSummary.setId(null);
               saveSummary.setFactoryId(factoryId);
               saveSummary.setWorkshopId(workShopId);
               saveSummary.setProductType(taskType);
               saveSummary.setType(wareHouseType);
               saveSummary.setProductId(productId);
               saveSummary.setQuantity(BigDecimal.valueOf(quantity));
               saveSummary.setType(WarehouseTypeEnum.INTO.getType());
               saveSummaryMap.put(key, saveSummary);
            } else {
               saveSummary.setQuantity(saveSummary.getQuantity().add(BigDecimal.valueOf(quantity)));
               saveSummaryMap.put(key, saveSummary);
            }
         } else {
            summary.setQuantity(summary.getQuantity().add(BigDecimal.valueOf(quantity)));
         }
      }

      this.warehouseSummaryService.saveBatch(new ArrayList<>(saveSummaryMap.values()));
      this.warehouseSummaryService.updateBatchById(new ArrayList<>(summaryMap.values()));
   }

   private void updateQhse(List<NumberInfoDTO> numberInfors, Integer taskType) {
      Preconditions.checkArgument((taskType & (TaskTypeEnum.ASSEMBLE.getType() | TaskTypeEnum.ARTIFACT.getType())) > 0, "操作失败!!!");
      List<MesBuildingProduceInspectionTeamReport> inspectReports = this.inspectionTeamReportService.listReports(numberInfors, taskType);
      List<MesBuildingProduceInspectionTeamReport> needUpdateInspects = inspectReports.stream().filter(s -> !s.getBoolAdoptEnum()).collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(needUpdateInspects)) {
         Map<Long, MesBuildingProduceInspectionTeamReport> inspectMap = needUpdateInspects.stream()
            .collect(Collectors.toMap(MesBuildingProduceInspectionTeamReport::getId, Function.identity()));
         List<NumberInfoDTO> needUpdateNumbers = needUpdateInspects.stream()
            .map(s -> NumberInfoDTO.builder().productId(s.getProductId()).number(s.getNumber()).build())
            .collect(Collectors.toList());
         List<MesBuildingProduceTeamReport> produceReports = this.mesBuildingProduceTeamReportService.listReports(needUpdateNumbers, taskType);
         Map<String, MesBuildingProduceTeamReport> reportMap = produceReports.stream()
            .collect(Collectors.toMap(s -> s.getTaskProcessId() + "_" + s.getProductId() + "_" + s.getNumber(), Function.identity()));
         List<Long> inspectIds = needUpdateInspects.stream().map(MesBuildingProduceInspectionTeamReport::getId).collect(Collectors.toList());
         List<MesBuildingQhseInspectionLink> qhseInspectLinks = this.qhseInspectionLinkService
            .list((Wrapper<MesBuildingQhseInspectionLink>)Wrappers.<MesBuildingQhseInspectionLink>lambdaQuery().in(MesBuildingQhseInspectionLink::getInspectionReportId, inspectIds));
         HashMap<Long, Integer> savePriceMap = new HashMap<>();
         List<MesBuildingProduceTeamReport> needUpdateReports = new ArrayList<>();

         for (MesBuildingQhseInspectionLink link : qhseInspectLinks) {
            MesBuildingProduceInspectionTeamReport inspectionReport = inspectMap.get(link.getInspectionReportId());
            inspectionReport.setInspectReportTime(LocalDateTime.now());
            inspectionReport.setBoolAdoptEnum(Boolean.TRUE);
            inspectionReport.setInspectReportTime(LocalDateTime.now());
            String key = inspectionReport.getTaskProcessId() + "_" + inspectionReport.getProductId() + "_" + inspectionReport.getNumber();
            MesBuildingProduceTeamReport report = reportMap.get(key);
            report.setInspectionQuantity(report.getInspectionQuantity() + 1);
            report.setProblemQuantity(report.getProblemQuantity() - 1);
            Preconditions.checkArgument(report.getInspectionQuantity() >= 0, "操作失败");
            Preconditions.checkArgument(report.getProblemQuantity() >= 0, "操作失败");
            needUpdateReports.add(report);
            savePriceMap.merge(report.getId(), 1, Integer::sum);
         }

         List<MesBuildingProduceInspectionTeamReport> inspects = new ArrayList<>(inspectMap.values());
         this.inspectionTeamReportService.updateBatchById(inspects);
         Map<String, MesBuildingProduceInspectionTeamReport> inspectNumberMap = inspects.stream()
            .collect(Collectors.toMap(s -> s.getProductId() + "_" + s.getNumber(), Function.identity()));
         this.mesBuildingProduceTeamReportService.updateBatchById(needUpdateReports);
         Map<String, List<MesBuildingProduceTeamReport>> taskProcessReportMap = new HashMap<>();

         for (MesBuildingProduceTeamReport needUpdateReport : needUpdateReports) {
            String inspectKey = needUpdateReport.getProductId() + "_" + needUpdateReport.getNumber();
            MesBuildingProduceInspectionTeamReport inspectionTeamReport = inspectNumberMap.get(inspectKey);
            String key = needUpdateReport.getTaskProcessId() + "_" + inspectionTeamReport.getTeamId() + "_" + inspectionTeamReport.getProductionLineId();
            List<MesBuildingProduceTeamReport> reports = taskProcessReportMap.getOrDefault(key, new ArrayList<>());
            reports.add(needUpdateReport);
            taskProcessReportMap.put(key, reports);
         }

         List<Long> taskProcessIds = needUpdateReports.stream().map(MesBuildingProduceTeamReport::getTaskProcessId).distinct().collect(Collectors.toList());
         Map<Long, MesBuildingTaskProcess> taskProcessMap = this.taskProcessBiz
            .listByIds(taskProcessIds)
            .stream()
            .collect(Collectors.toMap(MesBuildingTaskProcess::getId, Function.identity()));
         Map<Long, List<MesBuildingNextProcessLink>> nextProcessLinkMap = this.nextProcessLinkService
            .list((Wrapper<MesBuildingNextProcessLink>)new LambdaQueryWrapper<MesBuildingNextProcessLink>().in(MesBuildingNextProcessLink::getTaskProcessId, taskProcessMap.keySet()))
            .stream()
            .collect(Collectors.groupingBy(MesBuildingNextProcessLink::getTaskProcessId));

         for (String taskProcessAndTeamId : taskProcessReportMap.keySet()) {
            Long taskProcessId = Long.valueOf(taskProcessAndTeamId.split("_")[0]);
            Long teamId = Long.valueOf(taskProcessAndTeamId.split("_")[1]);
            Long productionLineId = Long.valueOf(taskProcessAndTeamId.split("_")[2]);
            MesBuildingTaskProcess taskProcess = taskProcessMap.get(taskProcessId);
            List<MesBuildingNextProcessLink> mesBuildingNextProcessLinks = nextProcessLinkMap.get(taskProcessId);
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(mesBuildingNextProcessLinks) || mesBuildingNextProcessLinks.size() == 1, "操作失败,暂不支持并行工序变更!");
            MesBuildingNextProcessLink nextProcessLink = mesBuildingNextProcessLinks.get(0);
            List<MesBuildingProduceTeamReport> reportList = taskProcessReportMap.get(taskProcessAndTeamId);
            int sum = reportList.stream().mapToInt(MesBuildingProduceTeamReport::getQuantity).sum();
            List<Integer> numberList = reportList.stream().map(MesBuildingProduceTeamReport::getNumber).collect(Collectors.toList());
            Preconditions.checkArgument(numberList.size() == sum, "操作失败!!!");
            taskProcess.setInspectionQuantity(taskProcess.getInspectionQuantity() + sum);
            taskProcess.setProblemQuantity(taskProcess.getProblemQuantity() - sum);
            this.taskProcessService.updateById(taskProcess);
            this.mesBuildingNewTaskBiz
               .saveProduceTeamReportSummary2(taskProcess, sum, productionLineId, teamId, SaveProduceTeamReportSummaryTypeEnum.ADOPT_PROBLEM_REPORT.getType());
            Long nextProcessId = 0L;
            if (nextProcessLink.getNextProcessId() != null) {
               MesBuildingTaskProcess nextProcess = this.taskProcessService
                  .getOne(
                     Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
                        .eq(MesBuildingTaskProcess::getTaskId, taskProcess.getTaskId())
                        .eq(MesBuildingTaskProcess::getProcessId, nextProcessLink.getNextProcessId())
                  );
               nextProcessId = nextProcess.getId();
            }

            if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
               List<MesBuildingTaskNumberLink> numberLinks = this.numberLinkService
                  .list(
                     Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                        .eq(MesBuildingTaskNumberLink::getArtifactTaskProcessId, taskProcess.getId())
                        .eq(MesBuildingTaskNumberLink::getBoolArtifactReport, true)
                        .in(MesBuildingTaskNumberLink::getArtifactNumber, numberList)
                  );
               List<Integer> numbers = numberLinks.stream().map(MesBuildingTaskNumberLink::getArtifactNumber).distinct().collect(Collectors.toList());
               Preconditions.checkArgument(numbers.size() == numberList.size(), "操作失败!!!请刷新页面后重试!!!!");

               for (MesBuildingTaskNumberLink numberLink : numberLinks) {
                  numberLink.setArtifactTaskProcessId(nextProcessId);
                  numberLink.setBoolArtifactReport(Boolean.FALSE);
                  numberLink.setBoolArtifactInspection(Boolean.FALSE);
                  numberLink.setBoolArtifactComplete(nextProcessId == 0L);
               }

               this.numberLinkService.updateBatchById(numberLinks);
            } else {
               if (!taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
                  throw new IllegalArgumentException("产品类型不正确");
               }

               List<MesBuildingTaskNumberLink> numberLinks = this.numberLinkService
                  .list(
                     Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                        .eq(MesBuildingTaskNumberLink::getAssembleTaskProcessId, taskProcess.getId())
                        .eq(MesBuildingTaskNumberLink::getBoolAssembleReport, true)
                        .in(MesBuildingTaskNumberLink::getAssembleNumber, numberList)
                  );
               List<Integer> numbers = numberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleNumber).distinct().collect(Collectors.toList());
               Preconditions.checkArgument(numbers.size() == numberList.size(), "操作失败!!!请刷新页面后重试!!!!");

               for (MesBuildingTaskNumberLink numberLink : numberLinks) {
                  numberLink.setAssembleTaskProcessId(nextProcessId);
                  numberLink.setBoolAssembleReport(Boolean.FALSE);
                  numberLink.setBoolAssembleInspection(Boolean.FALSE);
                  numberLink.setBoolAssembleComplete(nextProcessId == 0L);
               }

               this.numberLinkService.updateBatchById(numberLinks);
            }

            this.taskBiz.updateNextTaskProcess(taskProcess, sum, teamId, numberList);
         }
      }

      List<Long> allInspectIds = inspectReports.stream().map(MesBuildingProduceInspectionTeamReport::getId).collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(allInspectIds)) {
         List<MesBuildingQhseInspectionLink> allQhseInspectLinks = this.qhseInspectionLinkService
            .list((Wrapper<MesBuildingQhseInspectionLink>)Wrappers.<MesBuildingQhseInspectionLink>lambdaQuery().in(MesBuildingQhseInspectionLink::getInspectionReportId, allInspectIds));
         if (CollectionUtils.isNotEmpty(allQhseInspectLinks)) {
            List<Long> needRemoveLinks = allQhseInspectLinks.stream().map(MesBuildingQhseInspectionLink::getId).collect(Collectors.toList());
            this.qhseInspectionLinkService.removeByIds(needRemoveLinks);
            List<MesBuildingQhse> allMesBuildingQhse = this.mesBuildingQhseService
               .listByIds(allQhseInspectLinks.stream().map(MesBuildingQhseInspectionLink::getQhseId).collect(Collectors.toList()));
            Map<Long, MesBuildingQhse> allQhseMap = allMesBuildingQhse.stream().collect(Collectors.toMap(MesBuildingQhse::getId, Function.identity()));

            for (MesBuildingQhseInspectionLink link : allQhseInspectLinks) {
               MesBuildingQhse qhse = allQhseMap.get(link.getQhseId());
               qhse.setProblemQuantity(qhse.getProblemQuantity() - 1);
            }

            List<MesBuildingQhse> needUpdateQhse = new ArrayList<>(allQhseMap.values());
            this.mesBuildingQhseService.updateBatchById(needUpdateQhse);
            List<Long> needRemoveQhseIds = needUpdateQhse.stream()
               .filter(s -> s.getProblemQuantity().equals(0))
               .map(MesBuildingQhse::getId)
               .collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(needRemoveQhseIds)) {
               this.mesBuildingQhseService.removeByIds(needRemoveQhseIds);
               List<MesBuildingQhseRectify> qhseRectifies = this.qhseRectifyService
                  .list(Wrappers.lambdaQuery(MesBuildingQhseRectify.class).in(MesBuildingQhseRectify::getQhseId, needRemoveQhseIds));
               if (CollectionUtils.isNotEmpty(qhseRectifies)) {
                  this.qhseRectifyService.removeByIds(qhseRectifies.stream().map(MesBuildingQhseRectify::getId).collect(Collectors.toList()));
               }

               List<MesBuildingQhseUserLink> userLinks = this.qhseUserLinkService
                  .list(Wrappers.lambdaQuery(MesBuildingQhseUserLink.class).in(MesBuildingQhseUserLink::getQhseId, needRemoveQhseIds));
               List<Long> userLinkIds = userLinks.stream().map(MesBuildingQhseUserLink::getId).collect(Collectors.toList());
               this.qhseUserLinkService.removeByIds(userLinkIds);
            }

            if (CollectionUtils.isNotEmpty(inspectReports)) {
               List<Long> inspectReportIds = inspectReports.stream().map(MesBuildingProduceInspectionTeamReport::getId).collect(Collectors.toList());
               List<MesBuildingProduceQhseTeamReport> qhseTeamReport = this.mesBuildingProduceQhseTeamReportService
                  .list(
                     Wrappers.lambdaQuery(MesBuildingProduceQhseTeamReport.class)
                        .in(MesBuildingProduceQhseTeamReport::getInspectionTeamReportId, inspectReportIds)
                  );
               if (CollectionUtils.isNotEmpty(qhseTeamReport)) {
                  List<Long> qhseReportIds = qhseTeamReport.stream().map(MesBuildingProduceQhseTeamReport::getId).collect(Collectors.toList());
                  this.mesBuildingProduceQhseTeamReportService.removeByIds(qhseReportIds);
               }
            }
         }

         if (taskType.equals(TaskTypeEnum.ARTIFACT.getType())) {
            List<MesBuildingQhse> needDeleteOnecodeQhses = this.mesBuildingQhseService.listByData(numberInfors, taskType);
            List<MesBuildingQhse> allqhses = new ArrayList<>(needDeleteOnecodeQhses);
            List<MesBuildingTaskNumberLink> allLinks = this.numberLinkService.listLinksBydata(numberInfors, TaskTypeEnum.ARTIFACT.getType());
            List<MesBuildingTaskNumberLink> unOneCodeList = allLinks.stream().filter(s -> !s.getBoolOneCode()).collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(unOneCodeList)) {
               Map<Long, List<MesBuildingTaskNumberLink>> linksMap = unOneCodeList.stream()
                  .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactTaskId));
               HashMap<Long, Integer> taskDeleteMap = new HashMap<>();

               for (Long taskId : linksMap.keySet()) {
                  int size = (int)linksMap.get(taskId).stream().map(MesBuildingTaskNumberLink::getArtifactNumber).distinct().count();
                  taskDeleteMap.put(taskId, size);
               }

               Set<Long> taskIds = taskDeleteMap.keySet();
               List<MesBuildingTask> tasks = this.taskService.listByIds(taskIds);
               Map<Long, MesBuildingTask> taskMap = tasks.stream().collect(Collectors.toMap(MesBuildingTask::getId, Function.identity()));
               List<Long> needDeleteTaskIds = new ArrayList<>();

               for (Long taskId : taskDeleteMap.keySet()) {
                  Integer deleteQuantity = taskDeleteMap.get(taskId);
                  MesBuildingTask mesBuildingTask = taskMap.get(taskId);
                  if (deleteQuantity.equals(mesBuildingTask.getTaskQuantity())) {
                     needDeleteTaskIds.add(taskId);
                  }
               }

               List<MesBuildingQhse> needDeleteUnOnecodeQhses = new ArrayList<>();
               if (CollectionUtils.isNotEmpty(needDeleteTaskIds)) {
                  needDeleteUnOnecodeQhses = this.mesBuildingQhseService
                     .list(Wrappers.lambdaQuery(MesBuildingQhse.class).in(MesBuildingQhse::getTaskId, needDeleteTaskIds));
               }

               allqhses.addAll(needDeleteUnOnecodeQhses);
            }

            List<MesBuildingTaskNumberLink> checkAllLinks = this.numberLinkService.listLinksBydata(numberInfors, TaskTypeEnum.ARTIFACT.getType());
            if (CollectionUtils.isNotEmpty(checkAllLinks)) {
               Map<Long, List<MesBuildingTaskNumberLink>> linksMap = checkAllLinks.stream()
                  .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactTaskId));
               HashMap<Long, Integer> taskDeleteMap = new HashMap<>();

               for (Long taskId : linksMap.keySet()) {
                  int size = (int)linksMap.get(taskId).stream().map(MesBuildingTaskNumberLink::getArtifactNumber).distinct().count();
                  taskDeleteMap.put(taskId, size);
               }

               Set<Long> taskIds = taskDeleteMap.keySet();
               List<MesBuildingTask> tasks = this.taskService.listByIds(taskIds);
               Map<Long, MesBuildingTask> taskMap = tasks.stream().collect(Collectors.toMap(MesBuildingTask::getId, Function.identity()));
               List<Long> needDeleteTaskIds = new ArrayList<>();

               for (Long taskId : taskDeleteMap.keySet()) {
                  Integer deleteQuantity = taskDeleteMap.get(taskId);
                  MesBuildingTask mesBuildingTask = taskMap.get(taskId);
                  if (deleteQuantity.equals(mesBuildingTask.getTaskQuantity())) {
                     needDeleteTaskIds.add(taskId);
                  }
               }

               List<MesBuildingQhse> needDeleteUnOnecodeQhses = new ArrayList<>();
               if (CollectionUtils.isNotEmpty(needDeleteTaskIds)) {
                  needDeleteUnOnecodeQhses = this.mesBuildingQhseService
                     .list(
                        Wrappers.lambdaQuery(MesBuildingQhse.class)
                           .in(MesBuildingQhse::getTaskId, needDeleteTaskIds)
                           .eq(MesBuildingQhse::getType, QhseTypeEnum.SPOT_CHECK.getType())
                     );
               }

               allqhses.addAll(needDeleteUnOnecodeQhses);
            }

            if (CollectionUtils.isNotEmpty(allqhses) && CollectionUtils.isNotEmpty(allqhses)) {
               List<Long> qhseIds = allqhses.stream().map(MesBuildingQhse::getId).collect(Collectors.toList());
               this.mesBuildingQhseService.removeByIds(qhseIds);
               List<MesBuildingQhseRectify> qhseRectifies = this.qhseRectifyService
                  .list(Wrappers.lambdaQuery(MesBuildingQhseRectify.class).in(MesBuildingQhseRectify::getQhseId, qhseIds));
               if (CollectionUtils.isNotEmpty(qhseRectifies)) {
                  this.qhseRectifyService.removeByIds(qhseRectifies.stream().map(MesBuildingQhseRectify::getId).collect(Collectors.toList()));
               }

               List<MesBuildingQhseUserLink> userLinks = this.qhseUserLinkService
                  .list(Wrappers.lambdaQuery(MesBuildingQhseUserLink.class).in(MesBuildingQhseUserLink::getQhseId, qhseIds));
               List<Long> useLinkIds = userLinks.stream().map(MesBuildingQhseUserLink::getId).collect(Collectors.toList());
               this.qhseUserLinkService.removeByIds(useLinkIds);
            }
         }
      }
   }
}
