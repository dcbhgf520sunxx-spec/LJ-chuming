package com.hzchum.scim.mes.building.core.maneger;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.scim.business.core.api.pojo.dtoParam.ArtifactEditDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.MachinePartEditDtoParam;
import com.hzchum.scim.business.core.api.service.BusinessArtifactService;
import com.hzchum.scim.business.core.api.service.BusinessMachinePartService;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.enums.CodingTypeEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.dto.MesBuildingLinkCommonDTOParam;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskBiz;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseRecordStatusTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseTypeProductReturnEnum;
import com.hzchum.scim.mes.building.core.api.manager.MesBuildingCalcMaxNumManager;
import com.hzchum.scim.mes.building.core.api.pojo._doModel._package.MesBuildingPackageNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoListProductNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingAssistNumberDetail;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.MesBuildingCalcuDTOParam;
import com.hzchum.scim.mes.building.core.api.service._package.MesBuildingPackageNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListProductNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingArtifactSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingAssistNumberDetailService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactExt;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleDetail;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleExt;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.pojo._do.change.TechChangeRecordDetail;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactStatusDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.change.ArtifactBasicChangeDTOParam;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactExtService;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleDetailService;
import com.hzchum.scim.plan.core.api.service.TechAssembleExtService;
import com.hzchum.scim.plan.core.api.service.TechAssembleMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.plan.core.api.service.change.TechChangeRecordDetailService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingCalcMaxNumManagerImpl implements MesBuildingCalcMaxNumManager {
   @Resource
   private TechArtifactMachinePartLinkService machinePartLinkService;
   @Resource
   private TechMachinePartService machinePartService;
   @Resource
   private TechAssembleDetailService assembleDetailService;
   @Resource
   private TechAssembleService assembleService;
   @Resource
   private MesBuildingWarehouseSummaryService warehouseSummaryService;
   @Resource
   private MesBuildingTaskService mesBuildingTaskService;
   @Resource
   private PlanMonomerService monomerService;
   @Resource
   private MesBuildingWorkshopService workshopService;
   @Resource
   private MesBuildingArtifactSchedulingService artifactSchedulingService;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private TechArtifactExtService artifactExtService;
   @Resource
   private TechArtifactMachinePartLinkService artifactMachinePartLinkService;
   @Resource
   private MesBuildingPackageNumberLinkService packageNumberLinkService;
   @Resource
   private MesBuildingCargoListProductNumberLinkService cargoListProductNumberLinkService;
   @Resource
   private MesBuildingTaskNumberLinkService mesBuildingTaskNumberLinkService;
   @Resource
   private MesBuildingWarehouseRecordService warehouseRecordService;
   @Resource
   private TechAssembleExtService techAssembleExtService;
   @Resource
   private TechChangeRecordDetailService changeRecordDetailService;
   @Resource
   private BusinessArtifactService businessArtifactService;
   @Resource
   private BusinessMachinePartService businessMachinePartService;
   @Resource
   private TechAssembleExtService assembleExtService;
   @Resource
   private TechAssembleMachinePartLinkService assembleMachinePartLinkService;
   @Resource
   private MesBuildingTaskBiz mesBuildingTaskBiz;
   @Resource
   private MesBuildingTaskProcessService taskProcessService;
   @Resource
   private MesBuildingAssistNumberDetailService numberDetailService;

   @Override
   public void calculateMaximumCars(List<MesBuildingCalcuDTOParam> calcuDTOParamList) {
      List<MesBuildingWarehouseSummary> machinePartSummaryList = this.warehouseSummaryService
         .list(
            (Wrapper<MesBuildingWarehouseSummary>)((new LambdaQueryWrapper<MesBuildingWarehouseSummary>()
                     .eq(MesBuildingWarehouseSummary::getProductType, ProductTypeEnum.MACHINE_PART.getType()))
                  .eq(MesBuildingWarehouseSummary::getType, 1))
               .in(MesBuildingWarehouseSummary::getId, calcuDTOParamList.stream().map(MesBuildingCalcuDTOParam::getId).collect(Collectors.toList()))
         );
      List<MesBuildingWarehouseSummary> assembleSummaryList = this.warehouseSummaryService
         .list(
            (Wrapper<MesBuildingWarehouseSummary>)((new LambdaQueryWrapper<MesBuildingWarehouseSummary>()
                     .eq(MesBuildingWarehouseSummary::getProductType, ProductTypeEnum.ASSEMBLE.getType()))
                  .eq(MesBuildingWarehouseSummary::getType, 1))
               .in(MesBuildingWarehouseSummary::getId, calcuDTOParamList.stream().map(MesBuildingCalcuDTOParam::getId).collect(Collectors.toList()))
         );
      this.checkPart(calcuDTOParamList, machinePartSummaryList);
      this.checkAssemble(calcuDTOParamList, assembleSummaryList);
   }

   private void checkAssemble(List<MesBuildingCalcuDTOParam> calcuDTOParamList, List<MesBuildingWarehouseSummary> assembleSummaryList) {
      if (CollectionUtils.isNotEmpty(assembleSummaryList)) {
         List<MesBuildingCalcuDTOParam> assembleList = calcuDTOParamList.stream()
            .filter(e -> assembleSummaryList.stream().map(MesBuildingWarehouseSummary::getId).collect(Collectors.toList()).contains(e.getId()))
            .collect(Collectors.toList());
         List<TechAssembleDetail> assembleDetailList = this.assembleDetailService
            .list(
               (Wrapper<TechAssembleDetail>)new LambdaQueryWrapper<TechAssembleDetail>()
                  .in(
                     TechAssembleDetail::getAssembleId,
                     assembleSummaryList.stream().map(MesBuildingWarehouseSummary::getProductId).collect(Collectors.toList())
                  )
            );
         List<TechChangeRecordDetail> artifactChangeList = this.changeRecordDetailService
            .listChangeRecordDetailList(
               assembleDetailList.stream().map(TechAssembleDetail::getArtifactId).collect(Collectors.toList()), CheckStatusEnum.PENDING.getType()
            );
         Map<Long, List<TechChangeRecordDetail>> changeRecordDetailMap = artifactChangeList.stream()
            .collect(Collectors.groupingBy(TechChangeRecordDetail::getArtifactId));
         Set<Long> assembleSet = new HashSet<>();
         if (CollectionUtils.isNotEmpty(artifactChangeList)) {
            Map<Long, List<TechAssembleDetail>> assembleDetailMap = assembleDetailList.stream()
               .collect(Collectors.groupingBy(TechAssembleDetail::getArtifactId));
            changeRecordDetailMap.forEach((artifactId, changeRecordDetails) -> {
               List<TechAssembleDetail> detailListx = assembleDetailMap.get(artifactId);
               if (CollectionUtils.isNotEmpty(detailListx)) {
                  assembleSet.addAll(detailListx.stream().map(TechAssembleDetail::getAssembleId).distinct().collect(Collectors.toList()));
               }
            });
         }

         if (CollectionUtils.isNotEmpty(assembleSet)) {
            Map<Long, Integer> assembleTruckMap = new HashMap<>();
            List<TechAssembleDetail> detailList = this.assembleDetailService
               .list((Wrapper<TechAssembleDetail>)new LambdaQueryWrapper<TechAssembleDetail>().in(TechAssembleDetail::getAssembleId, assembleSet));
            List<MesBuildingTask> schedulingList = this.mesBuildingTaskService
               .list(
                  (Wrapper<MesBuildingTask>)(new LambdaQueryWrapper<MesBuildingTask>()
                        .eq(MesBuildingTask::getTaskTypeEnum, ProductTypeEnum.ARTIFACT.getType()))
                     .in(MesBuildingTask::getProductId, detailList.stream().map(TechAssembleDetail::getArtifactId).collect(Collectors.toList()))
               );
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(schedulingList), "操作失败,构件排产数据异常!!!");
            Map<Long, IntSummaryStatistics> schedulingMap = schedulingList.stream()
               .collect(Collectors.groupingBy(MesBuildingTask::getProductId, Collectors.summarizingInt(MesBuildingTask::getTaskQuantity)));

            for (TechAssembleDetail detail : detailList) {
               Integer quantity = Math.toIntExact(detail.getQuantity().intValue() * schedulingMap.get(detail.getArtifactId()).getSum());
               assembleTruckMap.merge(detail.getAssembleId(), quantity, Integer::sum);
               List<TechChangeRecordDetail> recordDetails = changeRecordDetailMap.get(detail.getArtifactId());
               if (recordDetails != null) {
                  assembleTruckMap.put(detail.getAssembleId(), assembleTruckMap.get(detail.getAssembleId()) - recordDetails.size() * detail.getQuantity());
               }
            }

            HashMap<Long, Integer> assembleMap = new HashMap<>();
            Map<Long, MesBuildingWarehouseSummary> summaryMap = assembleSummaryList.stream()
               .collect(Collectors.toMap(MesBuildingWarehouseSummary::getId, Function.identity()));
            Map<Long, Integer> inSummaryMap = assembleSummaryList.stream()
               .collect(
                  Collectors.groupingBy(
                     MesBuildingWarehouseSummary::getProductId, Collectors.summingInt(e -> e.getPackageQuantity().intValue() + e.getCargoQuantity().intValue())
                  )
               );

            for (MesBuildingCalcuDTOParam linkDTOParam : assembleList) {
               MesBuildingWarehouseSummary summary = summaryMap.get(linkDTOParam.getId());
               assembleMap.merge(summary.getProductId(), linkDTOParam.getQuantity(), Integer::sum);
            }

            assembleMap.forEach((assembleId, quantity) -> {
               Integer cargoQuantity = inSummaryMap.get(assembleId);
               Integer maxCargoQuantity = assembleTruckMap.get(assembleId);
               if (cargoQuantity > maxCargoQuantity) {
                  TechAssemble assemble = this.assembleService.getById(assembleId);
                  throw new IllegalArgumentException("编号" + assemble.getSerialNumber() + "的部件存在变更中的构件,可装车打包数不足!!!");
               }
            });
         }
      }
   }

   private void checkPart(List<MesBuildingCalcuDTOParam> calcuDTOParamList, List<MesBuildingWarehouseSummary> machinePartSummaryList) {
      if (CollectionUtils.isNotEmpty(machinePartSummaryList)) {
         List<MesBuildingCalcuDTOParam> machinePartList = calcuDTOParamList.stream()
            .filter(e -> machinePartSummaryList.stream().map(MesBuildingWarehouseSummary::getId).collect(Collectors.toList()).contains(e.getId()))
            .collect(Collectors.toList());
         List<TechArtifactMachinePartLink> machinePartLinkList = this.machinePartLinkService
            .list(
               (Wrapper<TechArtifactMachinePartLink>)new LambdaQueryWrapper<TechArtifactMachinePartLink>()
                  .in(
                     TechArtifactMachinePartLink::getMachinePartId,
                     machinePartSummaryList.stream().map(MesBuildingWarehouseSummary::getProductId).collect(Collectors.toList())
                  )
            );
         List<TechChangeRecordDetail> artifactChangeList = this.changeRecordDetailService
            .listChangeRecordDetailList(
               machinePartLinkList.stream().map(TechArtifactMachinePartLink::getArtifactId).distinct().collect(Collectors.toList()),
               CheckStatusEnum.PENDING.getType()
            );
         Map<Long, List<TechChangeRecordDetail>> changeRecordDetailMap = artifactChangeList.stream()
            .collect(Collectors.groupingBy(TechChangeRecordDetail::getArtifactId));
         Set<Long> partSet = new HashSet<>();
         if (CollectionUtils.isNotEmpty(artifactChangeList)) {
            Map<Long, List<TechArtifactMachinePartLink>> partLinKMap = machinePartLinkList.stream()
               .collect(Collectors.groupingBy(TechArtifactMachinePartLink::getArtifactId));
            changeRecordDetailMap.forEach((artifactId, changeRecordDetails) -> {
               List<TechArtifactMachinePartLink> partLinks = partLinKMap.get(artifactId);
               if (CollectionUtils.isNotEmpty(partLinks)) {
                  partSet.addAll(partLinks.stream().map(TechArtifactMachinePartLink::getMachinePartId).distinct().collect(Collectors.toList()));
               }
            });
         }

         if (CollectionUtils.isNotEmpty(partSet)) {
            Map<Long, Integer> partTruckMap = new HashMap<>();
            List<TechArtifactMachinePartLink> partLinkList = this.machinePartLinkService
               .list((Wrapper<TechArtifactMachinePartLink>)new LambdaQueryWrapper<TechArtifactMachinePartLink>().in(TechArtifactMachinePartLink::getMachinePartId, partSet));
            List<MesBuildingTask> schedulingList = this.mesBuildingTaskService
               .list(
                  (Wrapper<MesBuildingTask>)(new LambdaQueryWrapper<MesBuildingTask>()
                        .eq(MesBuildingTask::getTaskTypeEnum, ProductTypeEnum.ARTIFACT.getType()))
                     .in(MesBuildingTask::getProductId, partLinkList.stream().map(TechArtifactMachinePartLink::getArtifactId).collect(Collectors.toList()))
               );
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(schedulingList), "操作失败,该产品关联的构件处于变更中!!!");
            Map<Long, IntSummaryStatistics> schedulingMap = schedulingList.stream()
               .collect(Collectors.groupingBy(MesBuildingTask::getProductId, Collectors.summarizingInt(MesBuildingTask::getTaskQuantity)));

            for (TechArtifactMachinePartLink partLink : partLinkList) {
               Integer quantity = Math.toIntExact(partLink.getQuantity().intValue() * schedulingMap.get(partLink.getArtifactId()).getSum());
               partTruckMap.merge(partLink.getMachinePartId(), quantity, Integer::sum);
               List<TechChangeRecordDetail> recordDetails = changeRecordDetailMap.get(partLink.getArtifactId());
               if (recordDetails != null) {
                  partTruckMap.put(partLink.getMachinePartId(), partTruckMap.get(partLink.getMachinePartId()) - recordDetails.size() * partLink.getQuantity());
               }
            }

            HashMap<Long, Integer> partMap = new HashMap<>();
            Map<Long, MesBuildingWarehouseSummary> summaryMap = machinePartSummaryList.stream()
               .collect(Collectors.toMap(MesBuildingWarehouseSummary::getId, Function.identity()));
            Map<Long, IntSummaryStatistics> inSummaryMap = machinePartSummaryList.stream()
               .collect(
                  Collectors.groupingBy(
                     MesBuildingWarehouseSummary::getProductId,
                     Collectors.summarizingInt(e -> e.getPackageQuantity().intValue() + e.getCargoQuantity().intValue())
                  )
               );

            for (MesBuildingCalcuDTOParam linkDTOParam : machinePartList) {
               MesBuildingWarehouseSummary summary = summaryMap.get(linkDTOParam.getId());
               partMap.merge(summary.getProductId(), linkDTOParam.getQuantity(), Integer::sum);
            }

            partMap.forEach((partId, quantity) -> {
               Integer cargoQuantity = Math.toIntExact(inSummaryMap.get(partId).getSum());
               Integer maxCargoQuantity = partTruckMap.get(partId);
               if (cargoQuantity > maxCargoQuantity) {
                  TechMachinePart part = this.machinePartService.getById(partId);
                  throw new IllegalArgumentException("编号" + part.getSerialNumber() + "的零件存在变更中的构件,可装车打包数不足!!!");
               }
            });
         }
      }
   }

   @Override
   public void checkArtifactNumberChanger(Map<Long, List<Integer>> artifactNumberListMap, Boolean boolPass) {
      List<TechArtifact> artifactList = this.artifactService.listByIds(artifactNumberListMap.keySet());
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactList) && artifactList.size() == artifactNumberListMap.size(), "构件清单不存在!!!");
      LambdaQueryWrapper<TechArtifactExt> queryWrapper = Wrappers.<TechArtifactExt>lambdaQuery();

      for (Entry<Long, List<Integer>> entry : artifactNumberListMap.entrySet()) {
         if (queryWrapper.isEmptyOfNormal()) {
            queryWrapper.eq(TechArtifactExt::getArtifactId, entry.getKey());
            queryWrapper.in(TechArtifactExt::getSortNumber, entry.getValue());
         } else {
            queryWrapper.or(subQuery -> {
               LambdaQueryWrapper var10000 = subQuery.eq(TechArtifactExt::getArtifactId, entry.getKey()).in(TechArtifactExt::getSortNumber, entry.getValue());
            });
         }
      }

      List<TechArtifactExt> techArtifactExts = this.artifactExtService.list(queryWrapper);
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(techArtifactExts), "构件一物一码号不存在!!!");
      Map<Long, List<TechArtifactExt>> artifactExtMap = techArtifactExts.stream().collect(Collectors.groupingBy(TechArtifactExt::getArtifactId));
      artifactNumberListMap.forEach(
         (artifactId, numberList) -> {
            List<TechArtifactExt> artifactExts = artifactExtMap.get(artifactId);
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactExts) && artifactExts.size() == numberList.size(), "构件一物一码号不存在!!!");
            Preconditions.checkArgument(
               new HashSet(artifactExts.stream().map(TechArtifactExt::getSortNumber).collect(Collectors.toList())).containsAll(numberList), "构件一物一码号不存在!!!"
            );
            Preconditions.checkArgument(
               boolPass ? Boolean.TRUE : artifactExts.stream().allMatch(TechArtifactExt::getBoolStatusEnum), "操作失败,存在暂停状态的一物一码，暂不可变更!!!"
            );
         }
      );
      Map<Long, List<Integer>> artifactIdSortNumberListMap = techArtifactExts.stream()
         .filter(e -> e.getBoolTask() || e.getBoolStoreSubscription())
         .collect(Collectors.groupingBy(TechArtifactExt::getArtifactId, Collectors.mapping(TechArtifactExt::getSortNumber, Collectors.toList())));
      if (!CollectionUtils.isEmpty(artifactIdSortNumberListMap)) {
         Map<String, MesBuildingPackageNumberLink> packNumberLinkMap = this.packageNumberLinkService
            .list(
               (Wrapper<MesBuildingPackageNumberLink>)(new LambdaQueryWrapper<MesBuildingPackageNumberLink>()
                     .in(MesBuildingPackageNumberLink::getProductId, artifactIdSortNumberListMap.keySet()))
                  .eq(MesBuildingPackageNumberLink::getProductType, ProductTypeEnum.ARTIFACT.getType())
            )
            .stream()
            .collect(Collectors.toMap(e -> e.getProductId() + "-" + e.getNumber(), Function.identity()));
         Map<String, MesBuildingCargoListProductNumberLink> cargoNumberLinkMap = this.cargoListProductNumberLinkService
            .list(
               (Wrapper<MesBuildingCargoListProductNumberLink>)((new LambdaQueryWrapper<MesBuildingCargoListProductNumberLink>()
                        .eq(MesBuildingCargoListProductNumberLink::getBoolCancelShip, Boolean.FALSE))
                     .in(MesBuildingCargoListProductNumberLink::getProductId, artifactIdSortNumberListMap.keySet()))
                  .eq(MesBuildingCargoListProductNumberLink::getProductType, ProductTypeEnum.ARTIFACT.getType())
            )
            .stream()
            .collect(Collectors.toMap(e -> e.getProductId() + "-" + e.getNumber(), Function.identity()));
         artifactIdSortNumberListMap.forEach((artifactId, numberList) -> {
            if (CollectionUtils.isNotEmpty(packNumberLinkMap)) {
               Preconditions.checkArgument(numberList.stream().allMatch(e -> Objects.isNull(packNumberLinkMap.get(artifactId + "-" + e))), "操作失败,存在已打包的构件!");
            }

            if (CollectionUtils.isNotEmpty(cargoNumberLinkMap)) {
               Preconditions.checkArgument(numberList.stream().allMatch(e -> Objects.isNull(cargoNumberLinkMap.get(artifactId + "-" + e))), "操作失败,存在已装车的构件!");
            }
         });
         this.checkAssemble(artifactIdSortNumberListMap);
         this.checkPart(artifactIdSortNumberListMap);
      }
   }

   @Override
   public void checkAssembleNumberChanger(Map<Long, List<Integer>> assemleNumberListMap, Boolean boolPass) {
      List<TechAssemble> assembleList = this.assembleService.listByIds(assemleNumberListMap.keySet());
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(assembleList) && assembleList.size() == assemleNumberListMap.size(), "部件不存在!!!");
      LambdaQueryWrapper<TechAssembleExt> queryWrapper = Wrappers.<TechAssembleExt>lambdaQuery();

      for (Entry<Long, List<Integer>> entry : assemleNumberListMap.entrySet()) {
         if (queryWrapper.isEmptyOfNormal()) {
            queryWrapper.eq(TechAssembleExt::getAssembleId, entry.getKey());
            queryWrapper.in(TechAssembleExt::getSortNumber, entry.getValue());
         } else {
            queryWrapper.or(subQuery -> {
               LambdaQueryWrapper var10000 = subQuery.eq(TechAssembleExt::getAssembleId, entry.getKey()).in(TechAssembleExt::getSortNumber, entry.getValue());
            });
         }
      }

      List<TechAssembleExt> techAssembleExts = this.assembleExtService.list(queryWrapper);
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(techAssembleExts), "部件一物一码号不存在!!!");
      Map<Long, List<TechAssembleExt>> assembleExtMap = techAssembleExts.stream().collect(Collectors.groupingBy(TechAssembleExt::getAssembleId));
      assemleNumberListMap.forEach(
         (assemble, numberList) -> {
            List<TechAssembleExt> assembleExts = assembleExtMap.get(assemble);
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(assembleExts) && assembleExts.size() == numberList.size(), "部件一物一码号不存在!!!");
            Preconditions.checkArgument(
               assembleExts.stream().map(TechAssembleExt::getSortNumber).collect(Collectors.toList()).containsAll(numberList), "部件一物一码号不存在!!!"
            );
            Preconditions.checkArgument(
               boolPass ? Boolean.TRUE : assembleExts.stream().allMatch(TechAssembleExt::getBoolStatusEnum), "操作失败,存在暂停状态的一物一码，暂不可变更!!!"
            );
         }
      );
      Map<Long, List<Integer>> assembleIdSortNumberListMap = techAssembleExts.stream()
         .filter(TechAssembleExt::getBoolTask)
         .collect(Collectors.groupingBy(TechAssembleExt::getAssembleId, Collectors.mapping(TechAssembleExt::getSortNumber, Collectors.toList())));
      if (!CollectionUtils.isEmpty(assembleIdSortNumberListMap)) {
         Map<String, MesBuildingPackageNumberLink> packNumberLinkMap = this.packageNumberLinkService
            .list(
               (Wrapper<MesBuildingPackageNumberLink>)(new LambdaQueryWrapper<MesBuildingPackageNumberLink>()
                     .in(MesBuildingPackageNumberLink::getProductId, assembleIdSortNumberListMap.keySet()))
                  .eq(MesBuildingPackageNumberLink::getProductType, ProductTypeEnum.ASSEMBLE.getType())
            )
            .stream()
            .collect(Collectors.toMap(e -> e.getProductId() + "-" + e.getNumber(), Function.identity()));
         Map<String, MesBuildingCargoListProductNumberLink> cargoNumberLinkMap = this.cargoListProductNumberLinkService
            .list(
               (Wrapper<MesBuildingCargoListProductNumberLink>)((new LambdaQueryWrapper<MesBuildingCargoListProductNumberLink>()
                        .eq(MesBuildingCargoListProductNumberLink::getBoolCancelShip, Boolean.FALSE))
                     .in(MesBuildingCargoListProductNumberLink::getProductId, assembleIdSortNumberListMap.keySet()))
                  .eq(MesBuildingCargoListProductNumberLink::getProductType, ProductTypeEnum.ASSEMBLE.getType())
            )
            .stream()
            .collect(Collectors.toMap(e -> e.getProductId() + "-" + e.getNumber(), Function.identity()));
         assembleIdSortNumberListMap.forEach((assembleId, numberList) -> {
            Preconditions.checkArgument(numberList.stream().allMatch(e -> Objects.isNull(packNumberLinkMap.get(assembleId + "-" + e))), "操作失败,存在已打包的部件!!!");
            Preconditions.checkArgument(numberList.stream().allMatch(e -> Objects.isNull(cargoNumberLinkMap.get(assembleId + "-" + e))), "操作失败,存在已装车的部件!!!");
         });
         this.checkAssemblePart(assembleIdSortNumberListMap);
      }
   }

   private void checkAssemble(Map<Long, List<Integer>> artifactIdSortNumberListMap) {
      List<MesBuildingTaskNumberLink> taskNumberLinkList = this.mesBuildingTaskNumberLinkService
         .list(
            (Wrapper<MesBuildingTaskNumberLink>)(new LambdaQueryWrapper<MesBuildingTaskNumberLink>().isNotNull(MesBuildingTaskNumberLink::getAssembleId))
               .in(MesBuildingTaskNumberLink::getArtifactId, artifactIdSortNumberListMap.keySet())
         );
      if (CollectionUtils.isNotEmpty(taskNumberLinkList)) {
         List<MesBuildingTaskNumberLink> taskNumberLinks = taskNumberLinkList.stream()
            .filter(e -> artifactIdSortNumberListMap.get(e.getArtifactId()).contains(e.getArtifactNumber()))
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(taskNumberLinkList)) {
            Map<Long, List<MesBuildingTaskNumberLink>> assembleNumberMap = taskNumberLinks.stream()
               .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getAssembleId));
            Map<Long, List<MesBuildingPackageNumberLink>> packageNumberLinkMap = this.packageNumberLinkService
               .list(
                  (Wrapper<MesBuildingPackageNumberLink>)(new LambdaQueryWrapper<MesBuildingPackageNumberLink>()
                        .eq(MesBuildingPackageNumberLink::getProductType, ProductTypeEnum.ASSEMBLE.getType()))
                     .in(
                        MesBuildingPackageNumberLink::getProductId,
                        taskNumberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleId).collect(Collectors.toList())
                     )
               )
               .stream()
               .collect(Collectors.groupingBy(MesBuildingPackageNumberLink::getProductId));
            if (CollectionUtils.isNotEmpty(packageNumberLinkMap)) {
               packageNumberLinkMap.forEach(
                  (assembleId, numberList) -> Preconditions.checkArgument(
                     numberList.stream()
                        .noneMatch(
                           number -> assembleNumberMap.get(assembleId)
                              .stream()
                              .map(MesBuildingTaskNumberLink::getAssembleNumber)
                              .collect(Collectors.toList())
                              .contains(number.getNumber())
                        ),
                     "存在已打包的部件,构件不可变更!!!"
                  )
               );
            }

            Map<Long, List<MesBuildingCargoListProductNumberLink>> cargoListProductNumberLinkMap = this.cargoListProductNumberLinkService
               .list(
                  (Wrapper<MesBuildingCargoListProductNumberLink>)((new LambdaQueryWrapper<MesBuildingCargoListProductNumberLink>()
                           .eq(MesBuildingCargoListProductNumberLink::getProductType, ProductTypeEnum.ASSEMBLE.getType()))
                        .eq(MesBuildingCargoListProductNumberLink::getBoolCancelShip, Boolean.FALSE))
                     .in(
                        MesBuildingCargoListProductNumberLink::getProductId,
                        taskNumberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleId).collect(Collectors.toList())
                     )
               )
               .stream()
               .collect(Collectors.groupingBy(MesBuildingCargoListProductNumberLink::getProductId));
            if (CollectionUtils.isNotEmpty(cargoListProductNumberLinkMap)) {
               cargoListProductNumberLinkMap.forEach(
                  (assembleId, numberList) -> Preconditions.checkArgument(
                     numberList.stream()
                        .noneMatch(
                           number -> assembleNumberMap.get(assembleId)
                              .stream()
                              .map(MesBuildingTaskNumberLink::getAssembleNumber)
                              .collect(Collectors.toList())
                              .contains(number.getNumber())
                        ),
                     "存在已装车的部件,构件不可变更!!!"
                  )
               );
            }
         }
      }
   }

   private void checkPart(Map<Long, List<Integer>> artifactIdSortNumberListMap) {
      LambdaQueryWrapper<MesBuildingTaskNumberLink> taskNumberQueryWrapper = Wrappers.<MesBuildingTaskNumberLink>lambdaQuery();

      for (Entry<Long, List<Integer>> entry : artifactIdSortNumberListMap.entrySet()) {
         if (taskNumberQueryWrapper.isEmptyOfNormal()) {
            taskNumberQueryWrapper.eq(MesBuildingTaskNumberLink::getArtifactId, entry.getKey());
            taskNumberQueryWrapper.in(MesBuildingTaskNumberLink::getArtifactNumber, entry.getValue());
         } else {
            taskNumberQueryWrapper.or(
               subQuery -> {
                  LambdaQueryWrapper var10000 = subQuery.eq(MesBuildingTaskNumberLink::getArtifactId, entry.getKey())
                     .in(MesBuildingTaskNumberLink::getArtifactNumber, entry.getValue());
               }
            );
         }
      }

      List<MesBuildingTaskNumberLink> taskNumberLinks = this.mesBuildingTaskNumberLinkService.list(taskNumberQueryWrapper);
      if (!CollectionUtils.isEmpty(taskNumberLinks)) {
         Map<Long, MesBuildingTask> taskMap = this.mesBuildingTaskService
            .list(
               (Wrapper<MesBuildingTask>)(new LambdaQueryWrapper<MesBuildingTask>().eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType()))
                  .in(MesBuildingTask::getId, taskNumberLinks.stream().map(MesBuildingTaskNumberLink::getArtifactTaskId).collect(Collectors.toList()))
            )
            .stream()
            .collect(Collectors.toMap(MesBuildingTask::getId, Function.identity()));
         Map<Long, Map<Long, List<Integer>>> taskNumberLinkAndWorkShopMap = taskNumberLinks.stream()
            .collect(
               Collectors.groupingBy(
                  e -> taskMap.get(e.getArtifactTaskId()).getWorkshopId(),
                  Collectors.groupingBy(
                     MesBuildingTaskNumberLink::getArtifactId, Collectors.mapping(MesBuildingTaskNumberLink::getArtifactNumber, Collectors.toList())
                  )
               )
            );
         taskNumberLinkAndWorkShopMap.forEach(
            (workshopId, taskNumberLinkMap) -> {
               List<TechArtifactMachinePartLink> partLinks = this.artifactMachinePartLinkService
                  .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getArtifactId, taskNumberLinkMap.keySet()));
               if (!CollectionUtils.isEmpty(partLinks)) {
                  Map<Long, List<TechArtifactMachinePartLink>> linkMap = partLinks.stream()
                     .collect(Collectors.groupingBy(TechArtifactMachinePartLink::getArtifactId));
                  List<Long> partIds = partLinks.stream().map(TechArtifactMachinePartLink::getMachinePartId).distinct().collect(Collectors.toList());
                  List<TechMachinePart> machineParts = this.machinePartService
                     .list(
                        (Wrapper<TechMachinePart>)(new LambdaQueryWrapper<TechMachinePart>().eq(TechMachinePart::getBoolSendDirectly, Boolean.TRUE))
                           .in(TechMachinePart::getId, partIds)
                     );
                  Map<Long, TechMachinePart> partMap = machineParts.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
                  if (CollectionUtils.isNotEmpty(machineParts)) {
                     Map<Long, Integer> partChangeReduceMap = new HashMap<>();

                     for (Long artifactId : taskNumberLinkMap.keySet()) {
                        Set<Integer> artifactNumberList = new HashSet<>(taskNumberLinkMap.get(artifactId));
                        List<TechArtifactMachinePartLink> machinePartLinks = linkMap.get(artifactId);
                        if (CollectionUtils.isNotEmpty(machinePartLinks)) {
                           for (TechArtifactMachinePartLink machinePartLink : machinePartLinks) {
                              TechMachinePart machinePart = partMap.get(machinePartLink.getMachinePartId());
                              if (Objects.nonNull(machinePart)) {
                                 int reduceQuantity = artifactNumberList.size() * machinePartLink.getQuantity();
                                 partChangeReduceMap.merge(machinePart.getId(), reduceQuantity, Integer::sum);
                              }
                           }
                        }
                     }

                     Set<Long> sendPartIds = partMap.keySet();
                     Map<Long, Integer> allPartCanWareMap = new HashMap<>();
                     List<TechArtifactMachinePartLink> allSendLinks = this.artifactMachinePartLinkService
                        .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).in(TechArtifactMachinePartLink::getMachinePartId, sendPartIds));
                     Map<Long, List<TechArtifactMachinePartLink>> sendArtifactLinkMap = allSendLinks.stream()
                        .collect(Collectors.groupingBy(TechArtifactMachinePartLink::getArtifactId));
                     List<Long> allSendLinkArtifactIds = allSendLinks.stream()
                        .map(TechArtifactMachinePartLink::getArtifactId)
                        .distinct()
                        .collect(Collectors.toList());
                     List<MesBuildingTask> allSendLinkArtifactTasks = this.mesBuildingTaskService
                        .list(
                           Wrappers.lambdaQuery(MesBuildingTask.class)
                              .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
                              .eq(MesBuildingTask::getWorkshopId, workshopId)
                              .in(MesBuildingTask::getProductId, allSendLinkArtifactIds)
                        );
                     if (CollectionUtils.isNotEmpty(allSendLinkArtifactTasks)) {
                        Map<Long, Integer> sendArtTaskMap = allSendLinkArtifactTasks.stream()
                           .collect(Collectors.toMap(MesBuildingTask::getProductId, MesBuildingTask::getTaskQuantity, Integer::sum));

                        for (Long artifactId : sendArtTaskMap.keySet()) {
                           Integer artTaskQuantity = sendArtTaskMap.get(artifactId);
                           List<TechArtifactMachinePartLink> machinePartLinks = sendArtifactLinkMap.get(artifactId);
                           if (CollectionUtils.isNotEmpty(machinePartLinks)) {
                              for (TechArtifactMachinePartLink machinePartLink : machinePartLinks) {
                                 int reduceQuantity = artTaskQuantity * machinePartLink.getQuantity();
                                 allPartCanWareMap.merge(machinePartLink.getMachinePartId(), reduceQuantity, Integer::sum);
                              }
                           }
                        }
                     }

                     List<MesBuildingWarehouseSummary> warehouseSummaryList = this.warehouseSummaryService
                        .list(
                           Wrappers.lambdaQuery(MesBuildingWarehouseSummary.class)
                              .in(MesBuildingWarehouseSummary::getProductId, sendPartIds)
                              .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
                              .eq(MesBuildingWarehouseSummary::getWorkshopId, workshopId)
                              .eq(MesBuildingWarehouseSummary::getProductType, TaskTypeEnum.MACHINE_PART.getType())
                        );
                     Map<Long, Integer> partCargoMap = warehouseSummaryList.stream()
                        .collect(
                           Collectors.toMap(
                              MesBuildingWarehouseSummary::getProductId, e -> e.getPackageQuantity().intValue() + e.getCargoQuantity().intValue(), Integer::sum
                           )
                        );

                     for (Long senPartId : partChangeReduceMap.keySet()) {
                        Integer needReduceQuantity = partChangeReduceMap.get(senPartId);
                        Integer canWareQuantity = allPartCanWareMap.get(senPartId);
                        Integer cargoPackageQuantity = partCargoMap.get(senPartId) == null ? 0 : partCargoMap.get(senPartId);
                        Preconditions.checkArgument(canWareQuantity - cargoPackageQuantity >= needReduceQuantity, "操作失败!!!构件车间下直发零件库存数量不足!!!");
                     }
                  }
               }
            }
         );
      }
   }

   private void checkAssemblePart(Map<Long, List<Integer>> assembleIdSortNumberListMap) {
      LambdaQueryWrapper<MesBuildingTaskNumberLink> taskNumberQueryWrapper = Wrappers.<MesBuildingTaskNumberLink>lambdaQuery();

      for (Entry<Long, List<Integer>> entry : assembleIdSortNumberListMap.entrySet()) {
         if (taskNumberQueryWrapper.isEmptyOfNormal()) {
            taskNumberQueryWrapper.eq(MesBuildingTaskNumberLink::getAssembleId, entry.getKey());
            taskNumberQueryWrapper.in(MesBuildingTaskNumberLink::getAssembleNumber, entry.getValue());
         } else {
            taskNumberQueryWrapper.or(
               subQuery -> {
                  LambdaQueryWrapper var10000 = subQuery.eq(MesBuildingTaskNumberLink::getAssembleId, entry.getKey())
                     .in(MesBuildingTaskNumberLink::getAssembleNumber, entry.getValue());
               }
            );
         }
      }

      List<MesBuildingTaskNumberLink> taskNumberLinks = this.mesBuildingTaskNumberLinkService.list(taskNumberQueryWrapper);
      Map<Long, MesBuildingTask> taskMap = this.mesBuildingTaskService
         .list(
            (Wrapper<MesBuildingTask>)(new LambdaQueryWrapper<MesBuildingTask>().eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ASSEMBLE.getType()))
               .in(MesBuildingTask::getId, taskNumberLinks.stream().map(MesBuildingTaskNumberLink::getAssembleTaskId).collect(Collectors.toList()))
         )
         .stream()
         .collect(Collectors.toMap(MesBuildingTask::getId, Function.identity()));
      Map<Long, Map<Long, List<Integer>>> taskNumberLinkAndWorkShopMap = taskNumberLinks.stream()
         .collect(
            Collectors.groupingBy(
               e -> taskMap.get(e.getAssembleTaskId()).getWorkshopId(),
               Collectors.groupingBy(
                  MesBuildingTaskNumberLink::getAssembleId, Collectors.mapping(MesBuildingTaskNumberLink::getAssembleNumber, Collectors.toList())
               )
            )
         );
      taskNumberLinkAndWorkShopMap.forEach(
         (workshopId, taskNumberLinkMap) -> {
            List<TechAssembleMachinePartLink> partLinks = this.assembleMachinePartLinkService
               .list(Wrappers.lambdaQuery(TechAssembleMachinePartLink.class).in(TechAssembleMachinePartLink::getAssembleId, taskNumberLinkMap.keySet()));
            if (!CollectionUtils.isEmpty(partLinks)) {
               Map<Long, List<TechAssembleMachinePartLink>> linkMap = partLinks.stream()
                  .collect(Collectors.groupingBy(TechAssembleMachinePartLink::getAssembleId));
               List<Long> partIds = partLinks.stream().map(TechAssembleMachinePartLink::getMachinePartId).distinct().collect(Collectors.toList());
               List<TechMachinePart> machineParts = this.machinePartService
                  .list(
                     (Wrapper<TechMachinePart>)(new LambdaQueryWrapper<TechMachinePart>().eq(TechMachinePart::getBoolSendDirectly, Boolean.TRUE))
                        .in(TechMachinePart::getId, partIds)
                  );
               Map<Long, TechMachinePart> partMap = machineParts.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
               if (CollectionUtils.isNotEmpty(machineParts)) {
                  Map<Long, Integer> partChangeReduceMap = new HashMap<>();

                  for (Long assembleId : taskNumberLinkMap.keySet()) {
                     Set<Integer> AssembleNumberList = new HashSet<>(taskNumberLinkMap.get(assembleId));
                     List<TechAssembleMachinePartLink> machinePartLinks = linkMap.get(assembleId);
                     if (CollectionUtils.isNotEmpty(machinePartLinks)) {
                        for (TechAssembleMachinePartLink machinePartLink : machinePartLinks) {
                           TechMachinePart machinePart = partMap.get(machinePartLink.getMachinePartId());
                           if (Objects.nonNull(machinePart)) {
                              int reduceQuantity = AssembleNumberList.size() * machinePartLink.getQuantity();
                              partChangeReduceMap.merge(machinePart.getId(), reduceQuantity, Integer::sum);
                           }
                        }
                     }
                  }

                  Set<Long> sendPartIds = partMap.keySet();
                  Map<Long, Integer> allPartCanWareMap = new HashMap<>();
                  List<TechAssembleMachinePartLink> allSendLinks = this.assembleMachinePartLinkService
                     .list(Wrappers.lambdaQuery(TechAssembleMachinePartLink.class).in(TechAssembleMachinePartLink::getMachinePartId, sendPartIds));
                  Map<Long, List<TechAssembleMachinePartLink>> sendAssembleLinkMap = allSendLinks.stream()
                     .collect(Collectors.groupingBy(TechAssembleMachinePartLink::getAssembleId));
                  List<Long> allSendLinkAssembleIds = allSendLinks.stream()
                     .map(TechAssembleMachinePartLink::getAssembleId)
                     .distinct()
                     .collect(Collectors.toList());
                  List<MesBuildingTask> allSendLinkAssembleTasks = this.mesBuildingTaskService
                     .list(
                        Wrappers.lambdaQuery(MesBuildingTask.class)
                           .eq(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.ASSEMBLE.getType())
                           .eq(MesBuildingTask::getWorkshopId, workshopId)
                           .in(MesBuildingTask::getProductId, allSendLinkAssembleIds)
                     );
                  if (CollectionUtils.isNotEmpty(allSendLinkAssembleTasks)) {
                     Map<Long, Integer> sendAssTaskMap = allSendLinkAssembleTasks.stream()
                        .collect(Collectors.toMap(MesBuildingTask::getProductId, MesBuildingTask::getTaskQuantity, Integer::sum));

                     for (Long assembleId : sendAssTaskMap.keySet()) {
                        Integer assTaskQuantity = sendAssTaskMap.get(assembleId);
                        List<TechAssembleMachinePartLink> machinePartLinks = sendAssembleLinkMap.get(assembleId);
                        if (CollectionUtils.isNotEmpty(machinePartLinks)) {
                           for (TechAssembleMachinePartLink machinePartLink : machinePartLinks) {
                              int reduceQuantity = assTaskQuantity * machinePartLink.getQuantity();
                              allPartCanWareMap.merge(machinePartLink.getMachinePartId(), reduceQuantity, Integer::sum);
                           }
                        }
                     }
                  }

                  List<MesBuildingWarehouseSummary> warehouseSummaryList = this.warehouseSummaryService
                     .list(
                        Wrappers.lambdaQuery(MesBuildingWarehouseSummary.class)
                           .in(MesBuildingWarehouseSummary::getProductId, sendPartIds)
                           .eq(MesBuildingWarehouseSummary::getType, WarehouseTypeEnum.INTO.getType())
                           .eq(MesBuildingWarehouseSummary::getWorkshopId, workshopId)
                           .eq(MesBuildingWarehouseSummary::getProductType, TaskTypeEnum.MACHINE_PART.getType())
                     );
                  Map<Long, Integer> partCargoMap = warehouseSummaryList.stream()
                     .collect(
                        Collectors.toMap(
                           MesBuildingWarehouseSummary::getProductId, e -> e.getPackageQuantity().intValue() + e.getCargoQuantity().intValue(), Integer::sum
                        )
                     );

                  for (Long senPartId : partChangeReduceMap.keySet()) {
                     Integer needReduceQuantity = partChangeReduceMap.get(senPartId);
                     Integer canWareQuantity = allPartCanWareMap.get(senPartId);
                     Integer cargoPackageQuantity = partCargoMap.get(senPartId) == null ? 0 : partCargoMap.get(senPartId);
                     Preconditions.checkArgument(canWareQuantity - cargoPackageQuantity >= needReduceQuantity, "操作失败!!!部件车间下直发零件库存数量不足!!!");
                  }
               }
            }
         }
      );
   }

   @Override
   public <T extends MesBuildingLinkCommonDTOParam> List<T> checkPackNumberAndBuild(
      List<T> linkCommonDTOParams, Map<Integer, List<MesBuildingWarehouseSummary>> productTypeSummaryMap
   ) {
      productTypeSummaryMap.forEach(
         (productType, allSummaryList) -> {
            Map<Integer, List<MesBuildingWarehouseSummary>> warehouseSummaryListMap = allSummaryList.stream()
               .collect(Collectors.groupingBy(MesBuildingWarehouseSummary::getWarehouseType));
            warehouseSummaryListMap.forEach(
               (warehouseType, summaryList) -> {
                  if (ProductTypeEnum.ARTIFACT.getType().equals(productType)) {
                     List<Long> artifactIds = summaryList.stream().map(MesBuildingWarehouseSummary::getProductId).distinct().collect(Collectors.toList());
                     List<TechArtifact> artifactList = this.artifactService.list(new LambdaQueryWrapper<TechArtifact>().in(TechArtifact::getId, artifactIds));
                     Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactList) && artifactIds.size() == artifactList.size(), "操作失败,构件清单不存在!!!");
                     Preconditions.checkArgument(
                        artifactList.stream().allMatch(artifact -> artifact.getBoolStatusEnum() && !artifact.getBoolAbnormalEnum()), "操作失败,存在暂停状态的构件!!!"
                     );
                     Map<Long, List<MesBuildingWarehouseSummary>> warehouseSummaryMap = summaryList.stream()
                        .collect(Collectors.groupingBy(MesBuildingWarehouseSummary::getProductId));
                     Map<Long, MesBuildingLinkCommonDTOParam> dtoParamMap = linkCommonDTOParams.stream()
                        .collect(Collectors.toMap(MesBuildingLinkCommonDTOParam::getId, Function.identity()));
                     List<MesBuildingWarehouseRecord> warehouseRecordList = this.warehouseRecordService
                        .list(
                           new LambdaQueryWrapper<MesBuildingWarehouseRecord>()
                              .in(MesBuildingWarehouseRecord::getProductType, ProductTypeEnum.ARTIFACT.getType())
                              .in(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.INTO.getType())
                              .in(
                                 MesBuildingWarehouseRecord::getWorkshopId,
                                 summaryList.stream().map(MesBuildingWarehouseSummary::getWorkshopId).collect(Collectors.toList())
                              )
                              .in(MesBuildingWarehouseRecord::getProductId, artifactIds)
                              .eq(MesBuildingWarehouseRecord::getWarehouseType, warehouseType)
                        );
                     Preconditions.checkArgument(CollectionUtils.isNotEmpty(warehouseRecordList), "操作失败,构件入库详情不存在!!!");
                     Map<Long, List<MesBuildingWarehouseRecord>> warehouseRecordMap = warehouseRecordList.stream()
                        .collect(Collectors.groupingBy(MesBuildingWarehouseRecord::getProductId));
                     Map<Long, List<MesBuildingPackageNumberLink>> packageNumberLinkMap = this.packageNumberLinkService
                        .list(
                           new LambdaQueryWrapper<MesBuildingPackageNumberLink>()
                              .eq(MesBuildingPackageNumberLink::getProductType, ProductTypeEnum.ARTIFACT.getType())
                              .in(MesBuildingPackageNumberLink::getProductId, artifactIds)
                              .eq(MesBuildingPackageNumberLink::getWarehouseType, warehouseType)
                        )
                        .stream()
                        .collect(Collectors.groupingBy(MesBuildingPackageNumberLink::getProductId));
                     if (!warehouseType.equals(WarehouseTypeProductReturnEnum.SUBSCRIBE.getType())) {
                        List<TechArtifact> singleArtifacts = artifactList.stream()
                           .filter(artifact -> CodingTypeEnum.SINGLE.getType().equals(artifact.getCodingType()))
                           .collect(Collectors.toList());
                        List<TechArtifact> batchArtifacts = artifactList.stream()
                           .filter(artifact -> CodingTypeEnum.BATCH.getType().equals(artifact.getCodingType()))
                           .collect(Collectors.toList());
                        if (CollectionUtils.isNotEmpty(singleArtifacts)) {
                           for (TechArtifact artifact : singleArtifacts) {
                              List<Integer> numberList = new ArrayList<>();

                              for (MesBuildingWarehouseSummary summary : warehouseSummaryMap.get(artifact.getId())) {
                                 List<Integer> numberDTOList = dtoParamMap.get(summary.getId()).getNumberList();
                                 Preconditions.checkArgument(CollectionUtils.isNotEmpty(numberDTOList), "操作失败,一物一码构件序号不能为空!!!");
                                 Preconditions.checkArgument(
                                    numberDTOList.stream()
                                       .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                                       .values()
                                       .stream()
                                       .allMatch(count -> count == 1L),
                                    "操作失败,构件一物一码序号重复"
                                 );
                                 Preconditions.checkArgument(numberDTOList.stream().noneMatch(numberList::contains), "操作失败,构件一物一码序号重复!!!");
                                 numberList.addAll(numberDTOList);
                              }

                              List<MesBuildingWarehouseRecord> recordList = warehouseRecordMap.get(artifact.getId());
                              List<MesBuildingWarehouseRecord> warehouseRecords = recordList.stream()
                                 .filter(record -> numberList.contains(record.getNumber()))
                                 .collect(Collectors.toList());
                              Preconditions.checkArgument(
                                 CollectionUtils.isNotEmpty(warehouseRecords) && warehouseRecords.size() == numberList.size(), "操作失败,存在未入库的构件"
                              );
                              Preconditions.checkArgument(
                                 warehouseRecords.stream().allMatch(record -> record.getStatus().equals(WarehouseRecordStatusTypeEnum.INTO.getType())),
                                 "操作失败,存在已装车打包的构件!!!"
                              );
                              List<MesBuildingPackageNumberLink> packageNumberLinks = packageNumberLinkMap.get(artifact.getId());
                              if (CollectionUtils.isNotEmpty(packageNumberLinks)) {
                                 Preconditions.checkArgument(
                                    packageNumberLinks.stream().noneMatch(e -> numberList.contains(e.getNumber())), "操作失败,存在已装车打包的构件!!!"
                                 );
                              }
                           }
                        }

                        if (CollectionUtils.isNotEmpty(batchArtifacts)) {
                           Map<Long, List<TechArtifactExt>> artifactExtMap = this.artifactExtService
                              .list(
                                 new LambdaQueryWrapper<TechArtifactExt>()
                                    .in(TechArtifactExt::getArtifactId, batchArtifacts.stream().map(TechArtifact::getId).collect(Collectors.toList()))
                                    .eq(TechArtifactExt::getBoolSubscription, Boolean.FALSE)
                              )
                              .stream()
                              .collect(Collectors.groupingBy(TechArtifactExt::getArtifactId));

                           for (TechArtifact batchArtifact : batchArtifacts) {
                              List<TechArtifactExt> artifactExts = artifactExtMap.get(batchArtifact.getId());
                              List<MesBuildingWarehouseSummary> warehouseSummaries = warehouseSummaryMap.get(batchArtifact.getId());
                              List<MesBuildingWarehouseRecord> recordList = warehouseRecordMap.get(batchArtifact.getId());
                              List<MesBuildingWarehouseRecord> infoWarehouseRecords = recordList.stream()
                                 .filter(e -> e.getStatus().equals(WarehouseRecordStatusTypeEnum.INTO.getType()))
                                 .collect(Collectors.toList());
                              int sum = warehouseSummaries.stream().mapToInt(e -> dtoParamMap.get(e.getId()).getQuantity().intValue()).sum();
                              Preconditions.checkArgument(CollectionUtils.isNotEmpty(infoWarehouseRecords) && infoWarehouseRecords.size() >= sum, "操作失败,构件库存不足");
                              Map<Long, List<MesBuildingWarehouseSummary>> workshoWarehouseSummaryMap = warehouseSummaries.stream()
                                 .collect(Collectors.groupingBy(MesBuildingWarehouseSummary::getWorkshopId));
                              Map<Long, List<MesBuildingWarehouseRecord>> workshoWarehouseMap = infoWarehouseRecords.stream()
                                 .collect(Collectors.groupingBy(MesBuildingWarehouseRecord::getWorkshopId));
                              workshoWarehouseSummaryMap.forEach(
                                 (workshopId, warehouseSummariList) -> {
                                    int fromIndexx = 0;
                                    int toIndexx = 0;
                                    List<MesBuildingWarehouseRecord> warehouseRecords = workshoWarehouseMap.get(workshopId);
                                    Preconditions.checkArgument(CollectionUtils.isNotEmpty(warehouseRecords), "操作失败,该车间下构件库存不足!!!");

                                    for (MesBuildingWarehouseSummary warehouseSummaryx : warehouseSummariList) {
                                       MesBuildingLinkCommonDTOParam mesBuildingLinkDTOParamx = dtoParamMap.get(warehouseSummaryx.getId());
                                       mesBuildingLinkDTOParamx.setNumberList(
                                          warehouseRecords.subList(fromIndexx, mesBuildingLinkDTOParamx.getQuantity().intValue() + toIndexx)
                                             .stream()
                                             .map(MesBuildingWarehouseRecord::getNumber)
                                             .collect(Collectors.toList())
                                       );
                                       fromIndexx = mesBuildingLinkDTOParamx.getQuantity().intValue();
                                       toIndexx = mesBuildingLinkDTOParamx.getQuantity().intValue();
                                    }
                                 }
                              );
                           }
                        }
                     }

                     if (warehouseType.equals(WarehouseTypeProductReturnEnum.SUBSCRIBE.getType())) {
                        Map<Long, List<TechArtifactExt>> artifactExtMap = this.artifactExtService
                           .list(
                              new LambdaQueryWrapper<TechArtifactExt>()
                                 .in(TechArtifactExt::getArtifactId, artifactList.stream().map(TechArtifact::getId).collect(Collectors.toList()))
                                 .eq(TechArtifactExt::getBoolSubscription, Boolean.FALSE)
                           )
                           .stream()
                           .collect(Collectors.groupingBy(TechArtifactExt::getArtifactId));

                        for (TechArtifact batchArtifact : artifactList) {
                           List<TechArtifactExt> artifactExts = artifactExtMap.get(batchArtifact.getId());
                           List<MesBuildingWarehouseSummary> warehouseSummaries = warehouseSummaryMap.get(batchArtifact.getId());
                           List<MesBuildingWarehouseRecord> recordList = warehouseRecordMap.get(batchArtifact.getId());
                           List<MesBuildingWarehouseRecord> infoWarehouseRecords = recordList.stream()
                              .filter(e -> e.getStatus().equals(WarehouseRecordStatusTypeEnum.INTO.getType()))
                              .collect(Collectors.toList());
                           int sum = warehouseSummaries.stream().mapToInt(e -> dtoParamMap.get(e.getId()).getQuantity().intValue()).sum();
                           Preconditions.checkArgument(CollectionUtils.isNotEmpty(infoWarehouseRecords) && infoWarehouseRecords.size() >= sum, "操作失败,构件库存不足");
                           int fromIndex = 0;
                           int toIndex = 0;

                           for (MesBuildingWarehouseSummary warehouseSummary : warehouseSummaries) {
                              List<MesBuildingWarehouseRecord> warehouseRecords = infoWarehouseRecords.stream()
                                 .filter(e -> e.getWorkshopId().equals(warehouseSummary.getWorkshopId()))
                                 .collect(Collectors.toList());
                              Preconditions.checkArgument(CollectionUtils.isNotEmpty(warehouseRecords), "操作失败,构件库存不足!");
                              MesBuildingLinkCommonDTOParam mesBuildingLinkDTOParam = dtoParamMap.get(warehouseSummary.getId());
                              mesBuildingLinkDTOParam.setNumberList(
                                 warehouseRecords.subList(fromIndex, mesBuildingLinkDTOParam.getQuantity().intValue() + toIndex)
                                    .stream()
                                    .map(MesBuildingWarehouseRecord::getNumber)
                                    .collect(Collectors.toList())
                              );
                              fromIndex = mesBuildingLinkDTOParam.getQuantity().intValue();
                              toIndex = mesBuildingLinkDTOParam.getQuantity().intValue();
                           }
                        }
                     }
                  }

                  if (ProductTypeEnum.ASSEMBLE.getType().equals(productType) && CollectionUtils.isNotEmpty(summaryList)) {
                     List<Long> assembleIds = summaryList.stream().map(MesBuildingWarehouseSummary::getProductId).distinct().collect(Collectors.toList());
                     List<TechAssemble> assembleList = this.assembleService.listByIds(assembleIds);
                     Preconditions.checkArgument(CollectionUtils.isNotEmpty(assembleList) && assembleList.size() == assembleIds.size(), "操作失败,部件清单不存在!!!");
                     Map<Long, List<MesBuildingWarehouseSummary>> warehouseSummaryMap = summaryList.stream()
                        .collect(Collectors.groupingBy(MesBuildingWarehouseSummary::getProductId));
                     Map<Long, MesBuildingLinkCommonDTOParam> dtoParamMap = linkCommonDTOParams.stream()
                        .collect(Collectors.toMap(MesBuildingLinkCommonDTOParam::getId, Function.identity()));
                     List<MesBuildingWarehouseRecord> warehouseRecordList = this.warehouseRecordService
                        .list(
                           new LambdaQueryWrapper<MesBuildingWarehouseRecord>()
                              .in(MesBuildingWarehouseRecord::getProductType, ProductTypeEnum.ASSEMBLE.getType())
                              .in(MesBuildingWarehouseRecord::getType, WarehouseTypeEnum.INTO.getType())
                              .in(
                                 MesBuildingWarehouseRecord::getWorkshopId,
                                 summaryList.stream().map(MesBuildingWarehouseSummary::getWorkshopId).collect(Collectors.toList())
                              )
                              .in(MesBuildingWarehouseRecord::getProductId, assembleIds)
                        );
                     Preconditions.checkArgument(CollectionUtils.isNotEmpty(warehouseRecordList), "操作失败,部件入库详情不存在!!!");
                     Map<Long, List<MesBuildingWarehouseRecord>> warehouseRecordMap = warehouseRecordList.stream()
                        .collect(Collectors.groupingBy(MesBuildingWarehouseRecord::getProductId));
                     Map<Long, List<MesBuildingPackageNumberLink>> packageNumberLinkMap = this.packageNumberLinkService
                        .list(
                           new LambdaQueryWrapper<MesBuildingPackageNumberLink>()
                              .eq(MesBuildingPackageNumberLink::getProductType, ProductTypeEnum.ASSEMBLE.getType())
                              .in(MesBuildingPackageNumberLink::getProductId, assembleIds)
                        )
                        .stream()
                        .collect(Collectors.groupingBy(MesBuildingPackageNumberLink::getProductId));
                     Map<Long, List<TechAssembleExt>> assembleExtMap = this.techAssembleExtService
                        .list(new LambdaQueryWrapper<TechAssembleExt>().in(TechAssembleExt::getAssembleId, assembleIds))
                        .stream()
                        .collect(Collectors.groupingBy(TechAssembleExt::getAssembleId));

                     for (TechAssemble assemble : assembleList) {
                        List<TechAssembleExt> techAssembleExts = assembleExtMap.get(assemble.getId());
                        List<MesBuildingWarehouseSummary> warehouseSummaries = warehouseSummaryMap.get(assemble.getId());
                        List<MesBuildingWarehouseRecord> recordList = warehouseRecordMap.get(assemble.getId());
                        List<MesBuildingWarehouseRecord> infoWarehouseRecords = recordList.stream()
                           .filter(e -> e.getStatus().equals(WarehouseRecordStatusTypeEnum.INTO.getType()))
                           .collect(Collectors.toList());
                        int sum = warehouseSummaries.stream().mapToInt(e -> dtoParamMap.get(e.getId()).getQuantity().intValue()).sum();
                        Preconditions.checkArgument(CollectionUtils.isNotEmpty(infoWarehouseRecords) && infoWarehouseRecords.size() >= sum, "操作失败,部件库存不足");
                        List<MesBuildingPackageNumberLink> packageNumberLinks = packageNumberLinkMap.get(assemble.getId());
                        if (CollectionUtils.isNotEmpty(packageNumberLinks)) {
                           List<Integer> numberList = packageNumberLinks.stream().map(MesBuildingPackageNumberLink::getNumber).collect(Collectors.toList());
                           Preconditions.checkArgument(
                              infoWarehouseRecords.stream().noneMatch(record -> numberList.contains(record.getNumber())), "操作失败,存在已打包的部件!!!"
                           );
                        }

                        Map<Long, List<Integer>> recordMap = infoWarehouseRecords.stream()
                           .collect(
                              Collectors.groupingBy(
                                 MesBuildingWarehouseRecord::getProductId, Collectors.mapping(MesBuildingWarehouseRecord::getNumber, Collectors.toList())
                              )
                           );
                        LambdaQueryWrapper<MesBuildingTaskNumberLink> queryWrapper = Wrappers.<MesBuildingTaskNumberLink>lambdaQuery();

                        for (Entry<Long, List<Integer>> entry : recordMap.entrySet()) {
                           if (queryWrapper.isEmptyOfNormal()) {
                              queryWrapper.in(MesBuildingTaskNumberLink::getAssembleNumber, entry.getValue());
                              queryWrapper.eq(MesBuildingTaskNumberLink::getAssembleId, entry.getKey());
                           } else {
                              queryWrapper.or(
                                 subQuery -> {
                                    LambdaQueryWrapper var10000 = subQuery.eq(MesBuildingTaskNumberLink::getAssembleId, entry.getKey())
                                       .in(MesBuildingTaskNumberLink::getAssembleNumber, entry.getValue());
                                 }
                              );
                           }
                        }

                        List<MesBuildingTaskNumberLink> taskNumberLinks = this.mesBuildingTaskNumberLinkService.list(queryWrapper);
                        Preconditions.checkArgument(CollectionUtils.isNotEmpty(taskNumberLinks), "操作失败,排产下发数据有误!!!");
                        List<ArtifactStatusDTO> artifactStatusDTOS = new ArrayList<>();

                        for (Long artifactId : taskNumberLinks.stream().map(MesBuildingTaskNumberLink::getArtifactId).distinct().collect(Collectors.toList())) {
                           artifactStatusDTOS.addAll(this.mesBuildingTaskBiz.listArtifactStatus(Collections.singletonList(artifactId)));
                        }

                        Map<String, ArtifactStatusDTO> artifactStatusDTOMap = artifactStatusDTOS.stream()
                           .filter(e -> !e.getBoolCargo())
                           .collect(Collectors.toMap(e -> e.getProductId() + "-" + e.getNumber(), Function.identity()));
                        List<Integer> assembleNumberList = taskNumberLinks.stream()
                           .sorted(Comparator.comparing(e -> artifactStatusDTOMap.get(e.getArtifactId() + "-" + e.getArtifactNumber()) != null))
                           .map(MesBuildingTaskNumberLink::getAssembleNumber)
                           .distinct()
                           .collect(Collectors.toList());
                        int fromIndex = 0;
                        int toIndex = 0;

                        for (MesBuildingWarehouseSummary warehouseSummary : warehouseSummaries) {
                           MesBuildingLinkCommonDTOParam mesBuildingLinkDTOParam = dtoParamMap.get(warehouseSummary.getId());
                           mesBuildingLinkDTOParam.setNumberList(
                              assembleNumberList.subList(fromIndex, mesBuildingLinkDTOParam.getQuantity().intValue() + toIndex)
                           );
                           fromIndex = mesBuildingLinkDTOParam.getQuantity().intValue();
                           toIndex = mesBuildingLinkDTOParam.getQuantity().intValue();
                        }
                     }
                  }
               }
            );
         }
      );
      return linkCommonDTOParams;
   }

   @Override
   public void changeArtifact(TechArtifact artifact, ArtifactBasicChangeDTOParam param) {
      Preconditions.checkArgument(param.getQuantity() >= artifact.getQuantity(), "构件变更数量不能小于原数量!");
      int oldQuantity = artifact.getQuantity();
      int newQuantity = param.getQuantity();
      if (artifact.getBusinessId() != null) {
         ArtifactEditDTOParam editDtoParam = ArtifactEditDTOParam.builder()
            .businessId(artifact.getBusinessId())
            .quantity(newQuantity - oldQuantity)
            .totalWeight(
               param.getNetWeight().multiply(BigDecimal.valueOf(newQuantity)).subtract(artifact.getNetWeight().multiply(BigDecimal.valueOf(oldQuantity)))
            )
            .totalLength(
               artifact.getLength()
                  .multiply(BigDecimal.valueOf(param.getQuantity() - artifact.getQuantity()))
                  .divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_UP)
            )
            .build();
         this.businessArtifactService.editBusinessInfo(editDtoParam);
      }

      this.artifactExtService.addReduceExt(artifact.getMonomerId(), artifact.getId(), artifact.getSerialNumber(), param.getQuantity() - artifact.getQuantity());
      TechArtifact newArtifact = TechArtifact.builder()
         .id(artifact.getId())
         .quantity(param.getQuantity())
         .netWeight(param.getNetWeight())
         .grossWeight(param.getGrossWeight())
         .totalNetWeight(param.getNetWeight().multiply(BigDecimal.valueOf(param.getQuantity().intValue())))
         .totalGrossWeight(param.getGrossWeight() != null ? param.getGrossWeight().multiply(BigDecimal.valueOf(param.getQuantity().intValue())) : null)
         .length(param.getLength())
         .surfaceArea(param.getSurfaceArea())
         .boolStatusEnum(Boolean.TRUE)
         .name(param.getName())
         .printedCode(param.getPrintedCode() == null ? "" : param.getPrintedCode())
         .build();
      this.artifactService.updateById(newArtifact);
      List<TechArtifactMachinePartLink> artifactMachinePartLinkList = this.artifactMachinePartLinkService
         .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.builder().artifactId(artifact.getId()).build()));
      if (CollectionUtils.isNotEmpty(artifactMachinePartLinkList)) {
         List<TechMachinePart> machinePartList = this.machinePartService
            .listByIds(artifactMachinePartLinkList.stream().map(TechArtifactMachinePartLink::getMachinePartId).collect(Collectors.toList()));
         Map<Long, TechMachinePart> machinePartMap = machinePartList.stream().collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
         List<Long> removeMachinePartIds = new ArrayList<>(32);
         artifactMachinePartLinkList.forEach(
            link -> {
               TechMachinePart machinePart = machinePartMap.get(link.getMachinePartId());
               int partUpdateQuantity = (newQuantity - oldQuantity) * link.getQuantity();
               machinePart.setQuantity(machinePart.getQuantity() + partUpdateQuantity);
               machinePart.setTotalNetWeight(machinePart.getNetWeight().multiply(BigDecimal.valueOf(machinePart.getQuantity().intValue())));
               machinePart.setTotalGrossWeight(machinePart.getGrossWeight().multiply(BigDecimal.valueOf(machinePart.getQuantity().intValue())));
               if (machinePart.getQuantity() == 0) {
                  removeMachinePartIds.add(machinePart.getId());
               }

               if (machinePart.getBoolAllPartSendDirectly()) {
                  MachinePartEditDtoParam editDtoParam = MachinePartEditDtoParam.builder()
                     .businessId(machinePart.getBusinessId())
                     .quantity(partUpdateQuantity)
                     .totalWeight(machinePart.getNetWeight().multiply(BigDecimal.valueOf(partUpdateQuantity)))
                     .totalLength(machinePart.getLength().multiply(BigDecimal.valueOf(partUpdateQuantity)).divide(BigDecimal.valueOf(1000L)))
                     .build();
                  this.businessMachinePartService.editBusinessInfo(editDtoParam);
               }
            }
         );
         this.machinePartService.removeByIds(removeMachinePartIds);
         this.machinePartService.updateBatchById(machinePartList);
      }

      List<TechAssembleDetail> assembleDetailList = this.assembleDetailService
         .list(Wrappers.lambdaQuery(TechAssembleDetail.builder().artifactId(artifact.getId()).build()));
      if (CollectionUtils.isNotEmpty(assembleDetailList)) {
         List<Long> assembleIds = assembleDetailList.stream().map(TechAssembleDetail::getAssembleId).collect(Collectors.toList());
         List<TechAssemble> assembleList = this.assembleService.listByIds(assembleIds);
         Map<Long, TechAssemble> assembleMap = assembleList.stream().collect(Collectors.toMap(TechAssemble::getId, Function.identity()));
         List<TechAssembleMachinePartLink> assembleMachinePartLinkList = this.assembleMachinePartLinkService
            .list(Wrappers.lambdaQuery(TechAssembleMachinePartLink.class).in(TechAssembleMachinePartLink::getAssembleId, assembleIds));
         Map<Long, List<TechAssembleMachinePartLink>> assembleIdLinkListMap = Collections.emptyMap();
         Map<Long, TechMachinePart> assemblePartMap = Collections.emptyMap();
         if (CollectionUtils.isNotEmpty(assembleMachinePartLinkList)) {
            assembleIdLinkListMap = assembleMachinePartLinkList.stream().collect(Collectors.groupingBy(TechAssembleMachinePartLink::getAssembleId));
            assemblePartMap = this.machinePartService
               .listByIds(assembleMachinePartLinkList.stream().map(TechAssembleMachinePartLink::getMachinePartId).collect(Collectors.toSet()))
               .stream()
               .collect(Collectors.toMap(TechMachinePart::getId, Function.identity()));
         }

         Map<Long, List<TechAssembleMachinePartLink>> finalAssembleIdLinkListMap = assembleIdLinkListMap;
         Map<Long, TechMachinePart> finalAssemblePartMap = assemblePartMap;
         List<Long> removeAssembleIds = new ArrayList<>(16);
         assembleDetailList.forEach(assembleDetail -> {
            TechAssemble assemble = assembleMap.get(assembleDetail.getAssembleId());
            int assembleUpdateQuantity = (newQuantity - oldQuantity) * assembleDetail.getQuantity();
            assemble.setQuantity(assemble.getQuantity() + assembleUpdateQuantity);
            assemble.setTotalNetWeight(assemble.getNetWeight().multiply(BigDecimal.valueOf(assemble.getQuantity().intValue())));
            if (assemble.getQuantity() == 0) {
               removeAssembleIds.add(assemble.getId());
            }

            if (assembleUpdateQuantity != 0) {
               this.assembleExtService.addReduceExt(assemble, assembleUpdateQuantity);
            }

            if (finalAssembleIdLinkListMap.containsKey(assemble.getId())) {
               List<TechAssembleMachinePartLink> assembleMachinePartLinks = finalAssembleIdLinkListMap.get(assemble.getId());
               assembleMachinePartLinks.forEach(link -> {
                  TechMachinePart assemblePart = finalAssemblePartMap.get(link.getMachinePartId());
                  assemblePart.setQuantity(assemblePart.getQuantity() + assembleUpdateQuantity * link.getQuantity());
                  assemblePart.setTotalNetWeight(assemblePart.getNetWeight().multiply(BigDecimal.valueOf(assemblePart.getQuantity().intValue())));
                  assemblePart.setTotalGrossWeight(assemblePart.getGrossWeight().multiply(BigDecimal.valueOf(assemblePart.getQuantity().intValue())));
                  this.machinePartService.updateById(assemblePart);
                  if (assemblePart.getQuantity() == 0) {
                     this.machinePartService.removeById(assemblePart.getId());
                  }
               });
            }
         });
         this.assembleService.updateBatchById(assembleList);
         if (CollectionUtils.isNotEmpty(removeAssembleIds)) {
            this.assembleService.removeByIds(removeAssembleIds);
            this.assembleMachinePartLinkService
               .remove(Wrappers.lambdaQuery(TechAssembleMachinePartLink.class).in(TechAssembleMachinePartLink::getAssembleId, removeAssembleIds));
         }
      }
   }

   @Override
   public List<Integer> getNumberList(Long taskProcessId, Boolean boolAssist, Long assistGroupId, Integer quantity) {
      MesBuildingTaskProcess taskProcess = this.taskProcessService.getById(taskProcessId);
      Preconditions.checkArgument(taskProcess != null, "操作失败,任务分配工序详情表不存在!");
      List<Integer> numberDTOS = new ArrayList<>();
      List<MesBuildingAssistNumberDetail> assistNumberDetails = this.numberDetailService
         .list(Wrappers.lambdaQuery(MesBuildingAssistNumberDetail.class).eq(MesBuildingAssistNumberDetail::getTaskProcessId, taskProcessId));
      if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
         TechArtifact artifact = this.artifactService.getById(taskProcess.getProductId());
         Preconditions.checkArgument(artifact != null, "操作失败,构件产品不存在!");
         if (artifact.getCodingType().equals(CodingTypeEnum.BATCH.getType())) {
            return numberDTOS;
         }

         List<MesBuildingTaskNumberLink> canReportNumbers = this.mesBuildingTaskNumberLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                  .eq(MesBuildingTaskNumberLink::getArtifactTaskProcessId, taskProcessId)
                  .eq(MesBuildingTaskNumberLink::getBoolArtifactReport, false)
            );
         Map<Integer, List<MesBuildingTaskNumberLink>> numberLinkMap = canReportNumbers.stream()
            .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactNumber));
         if (boolAssist) {
            for (MesBuildingAssistNumberDetail assistNumber : assistNumberDetails.stream()
               .filter(s -> s.getGroupsId().equals(assistGroupId))
               .collect(Collectors.toList())) {
               List<MesBuildingTaskNumberLink> linkList = numberLinkMap.get(assistNumber.getNumber());
               if (!assistNumber.getBoolFinishEnum() && linkList.stream().allMatch(MesBuildingTaskNumberLink::getBoolAssembleComplete)) {
                  numberDTOS.add(assistNumber.getNumber());
               }
            }
         } else {
            List<Integer> assistNumbers = assistNumberDetails.stream().map(MesBuildingAssistNumberDetail::getNumber).collect(Collectors.toList());

            for (Integer number : numberLinkMap.keySet()) {
               if (!assistNumbers.contains(number)) {
                  List<MesBuildingTaskNumberLink> linkList = numberLinkMap.get(number);
                  if (linkList.stream().allMatch(MesBuildingTaskNumberLink::getBoolAssembleComplete)) {
                     numberDTOS.add(number);
                  }
               }
            }
         }

         Preconditions.checkArgument(numberDTOS.size() >= quantity, "操作失败,一物一码编号异常!");
         return numberDTOS.stream().sorted().limit(quantity.intValue()).collect(Collectors.toList());
      } else {
         if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
            MesBuildingTask task = this.mesBuildingTaskService.getById(taskProcess.getTaskId());
            Preconditions.checkArgument(task != null, "操作失败,任务不存在!");
            if (task.getBoolOneCode()) {
               if (boolAssist) {
                  for (MesBuildingAssistNumberDetail assNumber : assistNumberDetails.stream()
                     .filter(s -> s.getGroupsId().equals(assistGroupId))
                     .collect(Collectors.toList())) {
                     if (!assNumber.getBoolFinishEnum()) {
                        numberDTOS.add(assNumber.getNumber());
                     }
                  }
               } else {
                  List<MesBuildingTaskNumberLink> canReportNumbers = this.mesBuildingTaskNumberLinkService
                     .list(
                        Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                           .eq(MesBuildingTaskNumberLink::getAssembleTaskProcessId, taskProcessId)
                           .eq(MesBuildingTaskNumberLink::getBoolAssembleReport, false)
                     );
                  List<Integer> assistNumbers = assistNumberDetails.stream().map(MesBuildingAssistNumberDetail::getNumber).collect(Collectors.toList());

                  for (MesBuildingTaskNumberLink canReportNumber : canReportNumbers) {
                     if (!assistNumbers.contains(canReportNumber.getAssembleNumber())) {
                        numberDTOS.add(canReportNumber.getAssembleNumber());
                     }
                  }
               }

               Preconditions.checkArgument(numberDTOS.size() >= quantity, "操作失败,一物一码编号异常!");
               return numberDTOS.stream().sorted().limit(quantity.intValue()).collect(Collectors.toList());
            }
         }

         return numberDTOS;
      }
   }

   @Override
   public List<Integer> getNumberListV2(Long taskProcessId, Boolean boolAssist, Long assistLineId, Integer quantity) {
      MesBuildingTaskProcess taskProcess = this.taskProcessService.getById(taskProcessId);
      Preconditions.checkArgument(taskProcess != null, "操作失败,任务分配工序详情表不存在!");
      List<Integer> numberDTOS = new ArrayList<>();
      List<MesBuildingAssistNumberDetail> assistNumberDetails = this.numberDetailService
         .list(Wrappers.lambdaQuery(MesBuildingAssistNumberDetail.class).eq(MesBuildingAssistNumberDetail::getTaskProcessId, taskProcessId));
      if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
         TechArtifact artifact = this.artifactService.getById(taskProcess.getProductId());
         Preconditions.checkArgument(artifact != null, "操作失败,构件产品不存在!");
         if (artifact.getCodingType().equals(CodingTypeEnum.BATCH.getType())) {
            return numberDTOS;
         }

         List<MesBuildingTaskNumberLink> canReportNumbers = this.mesBuildingTaskNumberLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                  .eq(MesBuildingTaskNumberLink::getArtifactTaskProcessId, taskProcessId)
                  .eq(MesBuildingTaskNumberLink::getBoolArtifactReport, false)
            );
         Map<Integer, List<MesBuildingTaskNumberLink>> numberLinkMap = canReportNumbers.stream()
            .collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactNumber));
         if (boolAssist) {
            for (MesBuildingAssistNumberDetail assistNumber : assistNumberDetails.stream()
               .filter(s -> s.getProductionLineId().equals(assistLineId))
               .collect(Collectors.toList())) {
               List<MesBuildingTaskNumberLink> linkList = numberLinkMap.get(assistNumber.getNumber());
               if (!assistNumber.getBoolFinishEnum() && linkList.stream().allMatch(MesBuildingTaskNumberLink::getBoolAssembleComplete)) {
                  numberDTOS.add(assistNumber.getNumber());
               }
            }
         } else {
            List<Integer> assistNumbers = assistNumberDetails.stream().map(MesBuildingAssistNumberDetail::getNumber).collect(Collectors.toList());

            for (Integer number : numberLinkMap.keySet()) {
               if (!assistNumbers.contains(number)) {
                  List<MesBuildingTaskNumberLink> linkList = numberLinkMap.get(number);
                  if (linkList.stream().allMatch(MesBuildingTaskNumberLink::getBoolAssembleComplete)) {
                     numberDTOS.add(number);
                  }
               }
            }
         }

         Preconditions.checkArgument(numberDTOS.size() >= quantity, "操作失败,一物一码编号异常!");
         return numberDTOS.stream().sorted().limit(quantity.intValue()).collect(Collectors.toList());
      } else {
         if (taskProcess.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
            MesBuildingTask task = this.mesBuildingTaskService.getById(taskProcess.getTaskId());
            Preconditions.checkArgument(task != null, "操作失败,任务不存在!");
            if (task.getBoolOneCode()) {
               if (boolAssist) {
                  for (MesBuildingAssistNumberDetail assNumber : assistNumberDetails.stream()
                     .filter(s -> s.getProductionLineId().equals(assistLineId))
                     .collect(Collectors.toList())) {
                     if (!assNumber.getBoolFinishEnum()) {
                        numberDTOS.add(assNumber.getNumber());
                     }
                  }
               } else {
                  List<MesBuildingTaskNumberLink> canReportNumbers = this.mesBuildingTaskNumberLinkService
                     .list(
                        Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                           .eq(MesBuildingTaskNumberLink::getAssembleTaskProcessId, taskProcessId)
                           .eq(MesBuildingTaskNumberLink::getBoolAssembleReport, false)
                     );
                  List<Integer> assistNumbers = assistNumberDetails.stream().map(MesBuildingAssistNumberDetail::getNumber).collect(Collectors.toList());

                  for (MesBuildingTaskNumberLink canReportNumber : canReportNumbers) {
                     if (!assistNumbers.contains(canReportNumber.getAssembleNumber())) {
                        numberDTOS.add(canReportNumber.getAssembleNumber());
                     }
                  }
               }

               Preconditions.checkArgument(numberDTOS.size() >= quantity, "操作失败,一物一码编号异常!");
               return numberDTOS.stream().sorted().limit(quantity.intValue()).collect(Collectors.toList());
            }
         }

         return numberDTOS;
      }
   }
}
