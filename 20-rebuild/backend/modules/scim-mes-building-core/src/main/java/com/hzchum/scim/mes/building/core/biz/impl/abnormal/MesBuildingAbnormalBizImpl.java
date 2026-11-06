package com.hzchum.scim.mes.building.core.biz.impl.abnormal;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.mes.building.core.api.biz.abnormal.MesBuildingAbnormalBiz;
import com.hzchum.scim.mes.building.core.api.biz.qhse.MesBuildingQhseInspectionLinkBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingProduceTeamReportBiz;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.biz.warehouse.WarehouseBiz;
import com.hzchum.scim.mes.building.core.api.enums.AbnormalStatusTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.AbnormalTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.TaskStatusTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._do.abnormal.AbnormalProcessPreviewDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.abnormal.AbonrmalTaskDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.abnormal.MesBuildingAbnormalDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.abnormal.MesBuildingAbnormal;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.abnormal.MesBuildingAbnormalReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhse;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhseInspectionLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhseRectify;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhseUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.surplus.MesBuildingProduceSurplus;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingComplete;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingInProduction;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceInspectionTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceQhseTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReportSummary;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.record.ProductProductionSummaryDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.record.ProductProductionSummaryTaskDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.AbnormalChangeReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.AbnormalPreviewDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.AbnormalProcessPreviewDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.AbnormalProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.AbnormalSchedulingPreviewDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.AbnormalTaskDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProcessAndQuantityDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProduceAbonrmalReportAndLimitDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProduceAbonrmalReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.TaskProcessAndQuantityDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingTaskProcessSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.SchedulingDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.abnormal.AbnormalHandleDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.abnormal.TaskChangeDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingSchedulingClearDTOParam;
import com.hzchum.scim.mes.building.core.api.service.abnormal.MesBuildingAbnormalReportService;
import com.hzchum.scim.mes.building.core.api.service.abnormal.MesBuildingAbnormalService;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseRectifyService;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseService;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.record.MesBuildingProductProductionSummaryService;
import com.hzchum.scim.mes.building.core.api.service.surplus.MesBuildingProduceSurplusService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingInProductionService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceInspectionTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceQhseTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportSummaryService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleDetail;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleDetailService;
import com.hzchum.scim.plan.core.api.service.TechAssembleMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingAbnormalBizImpl implements MesBuildingAbnormalBiz {
   @Autowired
   private MesBuildingTaskProcessService taskProcessService;
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;
   @Autowired
   private MesBuildingTaskService taskService;
   @Autowired
   private TechAssembleService assembleService;
   @Autowired
   private TechMachinePartService machinePartService;
   @Autowired
   private TechEnclosureService enclosureService;
   @Autowired
   private TechAssembleDetailService assembleDetailService;
   @Autowired
   private TechAssembleMachinePartLinkService assembleMachinePartLinkService;
   @Autowired
   private MesBuildingSchedulingService schedulingService;
   @Autowired
   private MesBuildingProduceTeamReportSummaryService produceTeamReportSummaryService;
   @Autowired
   private MesBuildingProduceTeamReportService produceTeamReportService;
   @Autowired
   private MesBuildingAbnormalService abnormalService;
   @Autowired
   private MesBuildingProduceSurplusService surplusService;
   @Autowired
   private MesBuildingQhseService mesBuildingQhseService;
   @Autowired
   private MesBuildingQhseRectifyService qhseRectifyService;
   @Autowired
   private MesBuildingQhseUserLinkService qhseUserLinkService;
   @Autowired
   private MesBuildingInProductionService inProductionService;
   @Autowired
   private MesBuildingCompleteService completeService;
   @Autowired
   private MesBuildingProduceTeamReportBiz teamReportBiz;
   @Autowired
   private MesBuildingProductProductionSummaryService productionSummaryService;
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private TechArtifactMachinePartLinkService artifactMachinePartLinkService;
   @Autowired
   private WarehouseBiz warehouseBiz;
   @Autowired
   private MesBuildingProduceQhseTeamReportService qhseTeamReportService;
   @Autowired
   private MesBuildingProduceInspectionTeamReportService inspectionTeamReportService;
   @Autowired
   private MesBuildingAbnormalReportService abnormalReportService;
   @Autowired
   private MesBuildingProductProductionSummaryService productProductionSummaryService;
   @Autowired
   private MesBuildingQhseInspectionLinkBiz qhseInspectionLinkBiz;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean changeProductQuantity(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long productId,
      Integer productType,
      Integer oldQuantity,
      Integer newQuantity,
      String changeType,
      Boolean boolSurplusEnum,
      Long artifactId,
      String artifactSerialNumber,
      Long assembleId,
      String assembleSerialNumber
   ) {
      SchedulingDetailDTO schedulingDetailDTO = this.schedulingService.getSchedulingDetailByProductIdAndProductType(productId, productType, assembleId);
      if (schedulingDetailDTO.getTotalSchedulingQuantity() > newQuantity) {
         List<Long> productIds = new ArrayList<>();
         productIds.add(productId);
         if (assembleId == null) {
            this.schedulingService.clearSchedulingQuantity(MesBuildingSchedulingClearDTOParam.builder().productId(productIds).productType(productType).build());
         }

         if (schedulingDetailDTO.getTotalTaskQuantity() > newQuantity) {
            List<MesBuildingTask> taskList = this.taskService
               .list(
                  (Wrapper<MesBuildingTask>)(Wrappers.<MesBuildingTask>lambdaQuery().eq(MesBuildingTask::getTaskTypeEnum, productType))
                     .eq(MesBuildingTask::getProductId, productId)
               );
            taskList.forEach(e -> this.taskService.updateById(e.setStatus(TaskStatusTypeEnum.STOP.getType())));
            List<MesBuildingTaskProcess> taskProcessList = this.taskProcessService
               .list(
                  (Wrapper<MesBuildingTaskProcess>)(Wrappers.<MesBuildingTaskProcess>lambdaQuery().eq(MesBuildingTaskProcess::getTaskTypeEnum, productType))
                     .eq(MesBuildingTaskProcess::getProductId, productId)
               );
            taskProcessList.forEach(e -> this.taskProcessService.updateById(e.setStatus(TaskStatusTypeEnum.STOP.getType())));
            MesBuildingAbnormal abnormal = MesBuildingAbnormal.builder()
               .productId(productId)
               .productType(productType)
               .newQuantity(newQuantity)
               .changeType(changeType)
               .projectId(projectId)
               .monomerId(monomerId)
               .areaId(areaId)
               .artifactId(artifactId)
               .artifactSerialNumber(artifactSerialNumber)
               .assembleId(assembleId)
               .assembleSerialNumber(assembleSerialNumber)
               .inProductionQuantity(schedulingDetailDTO.getInProductionQuantity())
               .oldQuantity(oldQuantity)
               .newQuantity(newQuantity)
               .taskQuantity(schedulingDetailDTO.getTotalTaskQuantity())
               .userId(UserUtil.getCurrentUserId())
               .status(AbnormalStatusTypeEnum.PENDING.getType())
               .boolSurplusEnum(boolSurplusEnum)
               .build();
            this.abnormalService.save(abnormal);
            this.updateProductAbnormal(productId, productType, true);
            if (productType.equals(ProductTypeEnum.ASSEMBLE.getType())) {
            }
         }
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean handleAbnormal(List<AbnormalHandleDTOParam> dtoParamList, Long id) {
      MesBuildingAbnormal abnormal = this.abnormalService.getById(id);
      Preconditions.checkArgument(abnormal != null, "操作失败：传入id有误");
      this.updateProductStatus(abnormal.getProductId(), abnormal.getProductType(), false);
      List<Long> taskIds = this.produceTeamReportService
         .list(
            (Wrapper<MesBuildingProduceTeamReport>)Wrappers.<MesBuildingProduceTeamReport>lambdaQuery()
               .in(MesBuildingProduceTeamReport::getId, dtoParamList.stream().map(AbnormalHandleDTOParam::getId).collect(Collectors.toList()))
         )
         .stream()
         .map(MesBuildingProduceTeamReport::getTaskId)
         .distinct()
         .collect(Collectors.toList());
      taskIds.forEach(
         e -> {
            MesBuildingTask task = this.taskService.getById(e);
            task.setTaskQuantity(task.getInProductionQuantity());
            this.productProductionSummaryService
               .updateTaskQuantity(
                  ProductProductionSummaryTaskDTOParam.builder()
                     .productId(task.getProductId())
                     .productType(task.getTaskTypeEnum())
                     .taskQuantity(-(task.getTaskQuantity() - task.getInProductionQuantity()))
                     .dateTime(task.getCreateTime())
                     .build()
               );
            this.taskService.updateById(task);
            this.taskProcessService
               .list((Wrapper<MesBuildingTaskProcess>)Wrappers.<MesBuildingTaskProcess>lambdaQuery().eq(MesBuildingTaskProcess::getTaskId, task.getId()))
               .forEach(taskProcess -> this.taskProcessService.updateById(taskProcess.setTaskQuantity(task.getTaskQuantity())));
         }
      );
      dtoParamList.forEach(
         e -> {
            MesBuildingProduceTeamReport teamReport = this.produceTeamReportService.getById(e.getId());
            this.abnormalReportService
               .save(
                  MesBuildingAbnormalReport.builder()
                     .abnormalId(id)
                     .productId(abnormal.getProductId())
                     .productType(abnormal.getProductType())
                     .quantity(e.getQuantity())
                     .reportId(e.getId())
                     .reportType(teamReport.getReportType())
                     .userId(UserUtil.getCurrentUserId())
                     .type(AbnormalTypeEnum.PRODUCTION_ABNORMAL.getType())
                     .build()
               );
         }
      );
      BigDecimal price = BigDecimal.ZERO;
      dtoParamList.forEach(e -> price.add(this.handleTeamReport(e.getId(), e.getQuantity(), true, abnormal.getBoolSurplusEnum(), id)));
      taskIds.forEach(e -> price.add(this.handleTaskProcess(e, abnormal.getBoolSurplusEnum(), id)));
      this.handleTaskAndScheduling(taskIds);
      abnormal.setStatus(AbnormalStatusTypeEnum.PROCESSING_COMPLETE.getType());
      abnormal.setPrice(price);
      if (abnormal.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
         List<MesBuildingAbnormal> abnormalList = this.abnormalService
            .list(
               (Wrapper<MesBuildingAbnormal>)((Wrappers.<MesBuildingAbnormal>lambdaQuery()
                        .eq(MesBuildingAbnormal::getArtifactId, abnormal.getProductId()))
                     .ne(MesBuildingAbnormal::getProductType, ProductTypeEnum.ARTIFACT.getType()))
                  .in(MesBuildingAbnormal::getStatus, AbnormalStatusTypeEnum.PENDING.getType(), AbnormalStatusTypeEnum.PROCESSING.getType())
            );
         Preconditions.checkArgument(abnormalList.size() == 0, "操作失败，请先处理零件或者组立");
      }

      if (abnormal.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
         List<MesBuildingAbnormal> abnormalList = this.abnormalService
            .list(
               (Wrapper<MesBuildingAbnormal>)(Wrappers.<MesBuildingAbnormal>lambdaQuery().eq(MesBuildingAbnormal::getAssembleId, abnormal.getProductId()))
                  .in(MesBuildingAbnormal::getStatus, AbnormalStatusTypeEnum.PENDING.getType(), AbnormalStatusTypeEnum.PROCESSING.getType())
            );
         Preconditions.checkArgument(abnormalList.size() == 0, "操作失败，请先处理零件");
         TechAssemble assemble = this.assembleService.getById(abnormal.getProductId());
         Integer otherUsedQuantity = this.assembleDetailService
            .list((Wrapper<TechAssembleDetail>)Wrappers.<TechAssembleDetail>lambdaQuery().eq(TechAssembleDetail::getAssembleId, assemble.getId()))
            .stream()
            .mapToInt(
               e -> {
                  TechArtifact artifact = this.artifactService.getById(abnormal.getArtifactId());
                  if (artifact == null) {
                     return 0;
                  }

                  Integer artifactInProductionQuantity = this.schedulingService
                     .getSchedulingDetailByProductIdAndProductType(e.getArtifactId(), ProductTypeEnum.ARTIFACT.getType(), null)
                     .getInProductionQuantity();
                  return artifact.getQuantity() >= artifactInProductionQuantity
                     ? artifactInProductionQuantity * e.getQuantity()
                     : artifact.getQuantity() * e.getQuantity();
               }
            )
            .sum();
         assemble.setUsedQuantity(otherUsedQuantity);
         this.assembleService.updateById(assemble);
         this.handleAssembleSurplus(abnormal.getId(), abnormal.getProductId(), abnormal.getArtifactId());
      }

      if (abnormal.getProductType().equals(ProductTypeEnum.MACHINE_PART.getType())) {
         TechMachinePart machinePart = this.machinePartService.getByIdIgnoreDelete(abnormal.getProductId());
         Integer otherUsedQuantity = this.artifactMachinePartLinkService
            .list((Wrapper<TechArtifactMachinePartLink>)Wrappers.<TechArtifactMachinePartLink>lambdaQuery().eq(TechArtifactMachinePartLink::getMachinePartId, machinePart.getId()))
            .stream()
            .mapToInt(
               e -> {
                  TechArtifact artifact = this.artifactService.getById(abnormal.getArtifactId());
                  if (artifact == null) {
                     return 0;
                  }

                  Integer artifactInProductionQuantity = this.schedulingService
                     .getSchedulingDetailByProductIdAndProductType(e.getArtifactId(), ProductTypeEnum.ARTIFACT.getType(), null)
                     .getInProductionQuantity();
                  return artifact.getQuantity() >= artifactInProductionQuantity
                     ? artifactInProductionQuantity * e.getQuantity()
                     : artifact.getQuantity() * e.getQuantity();
               }
            )
            .sum();
         machinePart.setUsedQuantity(otherUsedQuantity);
         this.machinePartService.updateById(machinePart);
         if (machinePart.getRelationType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
            this.handleAssemblePartSurplus(abnormal.getId(), abnormal.getProductId(), abnormal.getAssembleId());
         } else {
            if (!machinePart.getRelationType().equals(ProductTypeEnum.ARTIFACT.getType())) {
               throw new IllegalArgumentException("操作失败，数据有误");
            }

            this.handlePartSurplus(abnormal.getId(), abnormal.getProductId(), abnormal.getArtifactId());
         }
      }

      this.updateProductAbnormal(abnormal.getProductId(), abnormal.getProductType(), false);
      this.abnormalService.updateById(abnormal);
      return true;
   }

   private Boolean handleAssembleSurplus(Long abnormalId, Long assembleId, Long artifactId) {
      SchedulingDetailDTO schedulingDetailDTO = this.schedulingService
         .getSchedulingDetailByProductIdAndProductType(artifactId, ProductTypeEnum.ARTIFACT.getType(), null);
      TechArtifact artifact = this.artifactService.getByIdIgnoreDelete(artifactId);
      Integer reduceArtifactQuantity = schedulingDetailDTO.getInProductionQuantity() - artifact.getQuantity();
      TechAssembleDetail detail = this.assembleDetailService
         .getOne(
            (Wrapper<TechAssembleDetail>)(Wrappers.<TechAssembleDetail>lambdaQuery().eq(TechAssembleDetail::getAssembleId, assembleId))
               .eq(TechAssembleDetail::getArtifactId, artifactId)
         );
      if (detail == null) {
         return Boolean.TRUE;
      }

      Integer reduceAssembleQuantity = detail.getQuantity() * reduceArtifactQuantity;
      return this.deleteSurplus(abnormalId, assembleId, ProductTypeEnum.ASSEMBLE.getType(), reduceAssembleQuantity);
   }

   private Boolean handleAssemblePartSurplus(Long abnormalId, Long partId, Long assembleId) {
      SchedulingDetailDTO schedulingDetailDTO = this.schedulingService
         .getSchedulingDetailByProductIdAndProductType(assembleId, ProductTypeEnum.ASSEMBLE.getType(), null);
      TechAssemble assemble = this.assembleService.getByIdIgnoreDelete(assembleId);
      Integer reduceAssembleQuantity = schedulingDetailDTO.getInProductionQuantity() - assemble.getQuantity();
      TechAssembleMachinePartLink link = this.assembleMachinePartLinkService
         .getOne(
            (Wrapper<TechAssembleMachinePartLink>)(Wrappers.<TechAssembleMachinePartLink>lambdaQuery().eq(TechAssembleMachinePartLink::getAssembleId, assembleId))
               .eq(TechAssembleMachinePartLink::getMachinePartId, partId)
         );
      if (link == null) {
         return Boolean.TRUE;
      }

      Integer reducePartQuantity = link.getQuantity() * reduceAssembleQuantity;
      return this.deleteSurplus(abnormalId, partId, ProductTypeEnum.MACHINE_PART.getType(), reducePartQuantity);
   }

   private Boolean handlePartSurplus(Long abnormalId, Long partId, Long artifactId) {
      SchedulingDetailDTO schedulingDetailDTO = this.schedulingService
         .getSchedulingDetailByProductIdAndProductType(artifactId, ProductTypeEnum.ARTIFACT.getType(), null);
      TechArtifact artifact = this.artifactService.getByIdIgnoreDelete(artifactId);
      Integer reduceArtifactQuantity = schedulingDetailDTO.getInProductionQuantity() - artifact.getQuantity();
      TechArtifactMachinePartLink link = this.artifactMachinePartLinkService
         .getOne(
            (Wrapper<TechArtifactMachinePartLink>)(Wrappers.<TechArtifactMachinePartLink>lambdaQuery().eq(TechArtifactMachinePartLink::getArtifactId, artifactId))
               .eq(TechArtifactMachinePartLink::getMachinePartId, partId)
         );
      if (link == null) {
         return Boolean.TRUE;
      }

      Integer reducePartQuantity = link.getQuantity() * reduceArtifactQuantity;
      return this.deleteSurplus(abnormalId, partId, ProductTypeEnum.MACHINE_PART.getType(), reducePartQuantity);
   }

   private Boolean deleteSurplus(Long abnormalId, Long productId, Integer productType, Integer reduceQuantity) {
      List<MesBuildingProduceSurplus> surplusList = this.surplusService
         .list((Wrapper<MesBuildingProduceSurplus>)Wrappers.<MesBuildingProduceSurplus>lambdaQuery().eq(MesBuildingProduceSurplus::getAbnormalId, abnormalId));
      List<MesBuildingProcess> processList = this.utilsBiz.getProcessByProduct(productId, productType, false);
      Map<Long, List<MesBuildingProduceSurplus>> processSurplusMap = new HashMap<>();
      processList.forEach(
         e -> processSurplusMap.put(e.getId(), surplusList.stream().filter(surplus -> surplus.getProcessId().equals(e.getId())).collect(Collectors.toList()))
      );

      for (Long processId : processSurplusMap.keySet()) {
         if (processSurplusMap.get(processId) != null) {
            for (int i = 0; i < processSurplusMap.get(processId).size() && reduceQuantity != 0; i++) {
               if (processSurplusMap.get(processId).get(i).getQuantity() <= reduceQuantity) {
                  this.surplusService.removeById(processSurplusMap.get(processId).get(i).getId());
                  reduceQuantity = reduceQuantity - processSurplusMap.get(processId).get(i).getQuantity();
               } else {
                  processSurplusMap.get(processId).get(i).setQuantity(processSurplusMap.get(processId).get(i).getQuantity() - reduceQuantity);
                  reduceQuantity = 0;
                  this.surplusService.updateById(processSurplusMap.get(processId).get(i));
               }
            }
         }
      }

      return Boolean.TRUE;
   }

   private Boolean updateProductAbnormal(Long productId, Integer productType, Boolean abnormalEnum) {
      if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
         this.artifactService
            .update(
               (Wrapper<TechArtifact>)(Wrappers.<TechArtifact>lambdaUpdate().eq(TechArtifact::getId, productId))
                  .set(TechArtifact::getBoolAbnormalEnum, abnormalEnum)
            );
      } else if (productType.equals(ProductTypeEnum.ASSEMBLE.getType())) {
         this.assembleService
            .update(
               (Wrapper<TechAssemble>)(Wrappers.<TechAssemble>lambdaUpdate().eq(TechAssemble::getId, productId))
                  .set(TechAssemble::getBoolAbnormalEnum, abnormalEnum)
            );
      } else {
         if (!productType.equals(ProductTypeEnum.MACHINE_PART.getType())) {
            throw new IllegalArgumentException("操作失败：暂不支持的类型");
         }

         this.machinePartService
            .update(
               (Wrapper<TechMachinePart>)(Wrappers.<TechMachinePart>lambdaUpdate().eq(TechMachinePart::getId, productId))
                  .set(TechMachinePart::getBoolAbnormalEnum, abnormalEnum)
            );
      }

      return Boolean.TRUE;
   }

   private Boolean handleTaskAndScheduling(List<Long> taskIds) {
      List<MesBuildingTask> tasks = this.taskService.listByIds(taskIds);
      tasks.forEach(
         e -> {
            if (e.getTaskQuantity() < e.getInProductionQuantity()) {
               e.setInProductionQuantity(e.getTaskQuantity());
            }

            if (e.getCompleteQuantity().equals(e.getTaskQuantity()) && e.getCompleteTime() == null) {
               e.setCompleteTime(LocalDateTime.now());
            }

            e.setStatus(TaskStatusTypeEnum.START.getType());
            this.taskService.updateById(e);
            MesBuildingScheduling scheduling = this.schedulingService
               .getOne((Wrapper<MesBuildingScheduling>)Wrappers.<MesBuildingScheduling>lambdaQuery().eq(MesBuildingScheduling::getProductType, e.getTaskTypeEnum()));
            if (scheduling != null) {
               scheduling.setTaskQuantity(e.getTaskQuantity());
               scheduling.setSchedulingQuantity(e.getTaskQuantity());
               scheduling.setCompleteQuantity(e.getCompleteQuantity());
               if (scheduling.getTaskQuantity().equals(scheduling.getCompleteQuantity()) && scheduling.getCompleteTime() == null) {
                  scheduling.setCompleteTime(LocalDateTime.now());
               }

               this.schedulingService.updateById(scheduling);
            }

            this.taskProcessService
               .list((Wrapper<MesBuildingTaskProcess>)Wrappers.<MesBuildingTaskProcess>lambdaQuery().eq(MesBuildingTaskProcess::getTaskId, e))
               .forEach(taskProcess -> {
                  taskProcess.setStatus(TaskStatusTypeEnum.START.getType());
                  this.taskProcessService.updateById(taskProcess);
               });
            this.produceTeamReportService
               .list((Wrapper<MesBuildingProduceTeamReport>)Wrappers.<MesBuildingProduceTeamReport>lambdaQuery().eq(MesBuildingProduceTeamReport::getTaskId, e))
               .forEach(report -> {
                  report.setReportType(0);
                  this.produceTeamReportService.updateById(report);
               });
         }
      );
      return true;
   }

   private BigDecimal handleTaskProcess(Long taskId, Boolean boolSurplusEnum, Long abnormalId) {
      BigDecimal price = BigDecimal.ZERO;
      MesBuildingTask task = this.taskService.getById(taskId);
      List<MesBuildingTaskProcess> taskProcessList = this.taskProcessService
         .list(
            (Wrapper<MesBuildingTaskProcess>)(Wrappers.<MesBuildingTaskProcess>lambdaQuery().eq(MesBuildingTaskProcess::getTaskId, taskId))
               .orderByAsc(MesBuildingTaskProcess::getSequence)
         );
      taskProcessList.forEach(e -> {
         e.setTaskQuantity(task.getTaskQuantity());
         if (e.getCompleteQuantity() > e.getTaskQuantity()) {
            Integer reduceQuantity = e.getCompleteQuantity() - e.getTaskQuantity();
            price.add(this.handleTaskProcessTeamReport(e.getId(), reduceQuantity, boolSurplusEnum, abnormalId));
         }
      });
      List<MesBuildingTaskProcess> newTaskProcessList = this.taskProcessService
         .list(
            (Wrapper<MesBuildingTaskProcess>)(Wrappers.<MesBuildingTaskProcess>lambdaQuery().eq(MesBuildingTaskProcess::getTaskId, taskId))
               .orderByAsc(MesBuildingTaskProcess::getSequence)
         );

      for (int i = 0; i <= newTaskProcessList.size() - 1; i++) {
         newTaskProcessList.get(i).setTaskQuantity(task.getTaskQuantity());
         if (i == 0) {
            newTaskProcessList.get(i).setNeedQuantity(newTaskProcessList.get(i).getTaskQuantity());
         } else {
            newTaskProcessList.get(i).setNeedQuantity(newTaskProcessList.get(i - 1).getInspectionQuantity());
         }

         if (newTaskProcessList.get(i).getTaskQuantity().equals(newTaskProcessList.get(i).getCompleteQuantity())
            && newTaskProcessList.get(i).getCompleteTime() == null) {
            newTaskProcessList.get(i).setAskCompleteTime(LocalDateTime.now());
         }

         newTaskProcessList.get(i).setStatus(TaskStatusTypeEnum.START.getType());
         this.taskProcessService.updateById(newTaskProcessList.get(i));
      }

      return price;
   }

   private BigDecimal handleTaskProcessTeamReport(Long taskProcessId, Integer quantity, Boolean boolSurplusEnum, Long abnormalId) {
      BigDecimal price = BigDecimal.ZERO;
      List<MesBuildingProduceTeamReport> teamReportList = this.produceTeamReportService
         .list(
            (Wrapper<MesBuildingProduceTeamReport>)(Wrappers.<MesBuildingProduceTeamReport>lambdaQuery()
                  .eq(MesBuildingProduceTeamReport::getTaskProcessId, taskProcessId))
               .orderByDesc(BaseEntity::getCreateTime)
         );

      for (int i = 0; i <= teamReportList.size() - 1 && quantity > 0; i++) {
         if (quantity > teamReportList.get(i).getQuantity()) {
            price.add(this.handleTeamReport(teamReportList.get(i).getId(), teamReportList.get(i).getQuantity(), false, boolSurplusEnum, abnormalId));
            quantity = quantity - teamReportList.get(i).getQuantity();
         } else {
            price.add(this.handleTeamReport(teamReportList.get(i).getId(), quantity, false, boolSurplusEnum, abnormalId));
            quantity = 0;
         }
      }

      return price;
   }

   private BigDecimal handleTeamReport(Long id, Integer quantity, Boolean handle, Boolean boolSurplusEnum, Long abnormalId) {
      MesBuildingProduceTeamReport teamReport = this.produceTeamReportService.getById(id);
      Preconditions.checkArgument(teamReport.getQuantity() >= quantity, "操作失败，减少数量不能低于上报数量");
      if (handle) {
         this.handleComplete(teamReport.getTaskId(), teamReport.getTeamId(), quantity);
         MesBuildingTask task = this.taskService.getById(teamReport.getTaskId());
         this.handleInProduction(teamReport.getId(), teamReport.getQuantity() - quantity, task);
         task.setTaskQuantity(task.getTaskQuantity() - quantity);
         this.productProductionSummaryService
            .updateTaskQuantity(
               ProductProductionSummaryTaskDTOParam.builder()
                  .productId(task.getProductId())
                  .productType(task.getTaskTypeEnum())
                  .taskQuantity(-quantity)
                  .dateTime(task.getCreateTime())
                  .build()
            );
         this.taskService.updateById(task);
         if (boolSurplusEnum) {
            this.saveSurplus(teamReport, quantity, abnormalId);
         }
      }

      this.handleTeamReportSummary(teamReport.getTaskId(), teamReport.getTeamId(), quantity);
      if (teamReport.getQuantity().equals(quantity)) {
         this.produceTeamReportService.removeById(id);
      } else {
         teamReport.setQuantity(teamReport.getQuantity() - quantity);
         if (teamReport.getInspectionQuantity() > teamReport.getQuantity()) {
            teamReport.setInspectionQuantity(teamReport.getQuantity());
         }

         this.produceTeamReportService.updateById(teamReport);
      }

      return BigDecimal.ZERO;
   }

   private Boolean handleInProduction(Long teamReportId, Integer quantity, MesBuildingTask task) {
      this.productProductionSummaryService
         .updateTaskQuantity(
            ProductProductionSummaryTaskDTOParam.builder()
               .productId(task.getProductId())
               .productType(task.getTaskTypeEnum())
               .inProductionQuantity(-quantity)
               .dateTime(task.getCreateTime())
               .build()
         );
      if (quantity == 0) {
         this.inProductionService.remove((Wrapper<MesBuildingInProduction>)Wrappers.<MesBuildingInProduction>lambdaQuery().eq(MesBuildingInProduction::getTeamReportId, teamReportId));
      } else {
         MesBuildingInProduction inProduction = this.inProductionService
            .getOne((Wrapper<MesBuildingInProduction>)Wrappers.<MesBuildingInProduction>lambdaQuery().eq(MesBuildingInProduction::getTeamReportId, teamReportId));
         if (inProduction != null) {
            inProduction.setQuantity(quantity);
            this.inProductionService.updateById(inProduction);
         }
      }

      return true;
   }

   private Boolean handleQhse(Long taskId, Long teamId, Integer quantity) {
      List<MesBuildingQhse> qhseList = this.mesBuildingQhseService
         .list(
            (Wrapper<MesBuildingQhse>)((((Wrappers.<MesBuildingQhse>lambdaQuery()
                           .eq(MesBuildingQhse::getTaskId, taskId))
                        .eq(teamId != null, MesBuildingQhse::getTeamId, teamId))
                     .eq(teamId != null, MesBuildingQhse::getTeamId, teamId))
                  .orderByAsc(MesBuildingQhse::getStatus))
               .orderByDesc(BaseEntity::getCreateTime)
         );

      for (int i = 0; i < qhseList.size() && quantity >= 0; i++) {
         if (qhseList.get(i).getProblemQuantity() <= quantity) {
            quantity = quantity - qhseList.get(i).getProblemQuantity();
            this.mesBuildingQhseService.removeById(qhseList.get(i));
            this.qhseRectifyService
               .remove((Wrapper<MesBuildingQhseRectify>)Wrappers.<MesBuildingQhseRectify>lambdaQuery().eq(MesBuildingQhseRectify::getQhseId, qhseList.get(i).getId()));
            this.qhseUserLinkService
               .remove((Wrapper<MesBuildingQhseUserLink>)Wrappers.<MesBuildingQhseUserLink>lambdaQuery().eq(MesBuildingQhseUserLink::getQhseId, qhseList.get(i).getId()));
            List<MesBuildingQhseInspectionLink> linkList = this.qhseInspectionLinkBiz
               .list((Wrapper<MesBuildingQhseInspectionLink>)new LambdaQueryWrapper<MesBuildingQhseInspectionLink>().eq(MesBuildingQhseInspectionLink::getQhseId, qhseList.get(i).getId()));
            this.qhseTeamReportService.removeById(linkList.get(0).getQhseReportId());
         } else {
            qhseList.get(i).setProblemQuantity(qhseList.get(i).getProblemQuantity() - quantity);
            quantity = 0;
            this.mesBuildingQhseService.updateById(qhseList.get(i));
            List<MesBuildingQhseInspectionLink> linkList = this.qhseInspectionLinkBiz
               .list((Wrapper<MesBuildingQhseInspectionLink>)new LambdaQueryWrapper<MesBuildingQhseInspectionLink>().eq(MesBuildingQhseInspectionLink::getQhseId, qhseList.get(i).getId()));
            MesBuildingProduceQhseTeamReport qhseTeamReport = this.qhseTeamReportService.getById(linkList.get(0).getQhseReportId());
            qhseTeamReport.setQhseQuantity(qhseList.get(i).getProblemQuantity());
            this.qhseTeamReportService.updateById(qhseTeamReport);
         }
      }

      return null;
   }

   private Boolean handleTeamReportSummary(Long taskId, Long teamId, Integer quantity) {
      MesBuildingProduceTeamReportSummary summary = this.produceTeamReportSummaryService
         .getOne(
            (Wrapper<MesBuildingProduceTeamReportSummary>)(Wrappers.<MesBuildingProduceTeamReportSummary>lambdaQuery()
                  .eq(MesBuildingProduceTeamReportSummary::getTeamId, teamId))
               .eq(MesBuildingProduceTeamReportSummary::getTaskId, taskId)
         );
      MesBuildingTaskProcess taskProcess = this.taskProcessService.getById(summary.getTaskProcessId());
      Integer oldQhseQuantity = summary.getProblemQuantity();
      if (quantity > summary.getProblemQuantity()) {
         this.handleQhse(summary.getTaskId(), summary.getTeamId(), summary.getProblemQuantity());
         summary.setProblemQuantity(0);
      } else {
         this.handleQhse(summary.getTaskId(), summary.getTeamId(), quantity);
         summary.setProblemQuantity(summary.getProblemQuantity() - quantity);
      }

      summary.setQuantity(summary.getQuantity() - quantity);
      Integer oldInspectionQuantity = summary.getInspectionQuantity();
      if (summary.getQuantity() < summary.getInspectionQuantity() + summary.getProblemQuantity()) {
         summary.setInspectionQuantity(summary.getQuantity() - summary.getProblemQuantity());
         this.handleInspectionQuantity(summary.getTaskId(), summary.getTeamId(), summary.getInspectionQuantity());
      }

      taskProcess.setProblemQuantity(taskProcess.getProblemQuantity() - (oldQhseQuantity - summary.getProblemQuantity()));
      taskProcess.setInspectionQuantity(taskProcess.getInspectionQuantity() - (oldInspectionQuantity - summary.getInspectionQuantity()));
      taskProcess.setCompleteQuantity(taskProcess.getCompleteQuantity() - quantity);
      this.taskProcessService.updateById(taskProcess);
      if (summary.getQuantity() != 0) {
         this.produceTeamReportSummaryService.updateById(summary);
      } else {
         this.produceTeamReportSummaryService.removeById(summary.getId());
      }

      return true;
   }

   private Boolean handleComplete(Long taskId, Long teamId, Integer quantity) {
      List<MesBuildingComplete> completeList = this.completeService
         .list(
            (Wrapper<MesBuildingComplete>)((Wrappers.<MesBuildingComplete>lambdaQuery().eq(MesBuildingComplete::getTaskId, taskId))
                  .eq(teamId != null, MesBuildingComplete::getTeamId, teamId))
               .orderByDesc(BaseEntity::getCreateTime)
         );
      MesBuildingTask task = this.taskService.getById(taskId);
      this.productProductionSummaryService
         .updateTaskQuantity(
            ProductProductionSummaryTaskDTOParam.builder()
               .productId(task.getProductId())
               .productType(task.getTaskTypeEnum())
               .completeQuantity(-quantity)
               .dateTime(task.getCreateTime())
               .build()
         );

      for (int i = 0; i < completeList.size() && quantity >= 0; i++) {
         if (completeList.get(i).getQuantity() <= quantity) {
            task.setCompleteQuantity(task.getCompleteQuantity() - completeList.get(i).getQuantity());
            quantity = quantity - completeList.get(i).getQuantity();
            if (completeList.get(i).getTaskTypeEnum().equals(ProductTypeEnum.ARTIFACT.getType())) {
               this.warehouseBiz.reduceQuantity(completeList.get(i).getId(), completeList.get(i).getQuantity());
            }

            this.completeService.removeById(completeList.get(i).getId());
         } else {
            task.setCompleteQuantity(task.getCompleteQuantity() - quantity);
            if (completeList.get(i).getTaskTypeEnum().equals(ProductTypeEnum.ARTIFACT.getType())) {
               this.warehouseBiz.reduceQuantity(completeList.get(i).getId(), quantity);
            }

            completeList.get(i).setQuantity(completeList.get(i).getQuantity() - quantity);
            quantity = 0;
            this.completeService.updateById(completeList.get(i));
         }
      }

      this.taskService.updateById(task);
      return null;
   }

   private Boolean saveSurplus(MesBuildingProduceTeamReport report, Integer quantity, Long abnormalId) {
      MesBuildingProduceSurplus surplus = this.surplusService
         .getOne(
            (Wrapper<MesBuildingProduceSurplus>)((Wrappers.<MesBuildingProduceSurplus>lambdaQuery()
                     .eq(MesBuildingProduceSurplus::getTeamId, report.getTeamId()))
                  .eq(MesBuildingProduceSurplus::getAbnormalId, abnormalId))
               .eq(MesBuildingProduceSurplus::getTaskId, report.getTaskId())
         );
      if (surplus != null) {
         surplus.setQuantity(surplus.getQuantity() + quantity);
         this.surplusService.updateById(surplus);
      } else {
         MesBuildingProduceSurplus newSurplus = MesBuildingProduceSurplus.builder()
            .taskId(report.getTaskId())
            .taskProcessId(report.getTaskProcessId())
            .productId(report.getProductId())
            .processId(report.getProcessId())
            .teamId(report.getTeamId())
            .productType(report.getTaskTypeEnum())
            .quantity(quantity)
            .abnormalId(abnormalId)
            .schedulingId(report.getSchedulingId())
            .userId(UserUtil.getCurrentUserId())
            .build();
         this.surplusService.save(newSurplus);
      }

      return true;
   }

   private Boolean handleInspectionQuantity(Long taskId, Long teamId, Integer inspectionQuantity) {
      List<MesBuildingProduceInspectionTeamReport> inspectionTeamReports = this.inspectionTeamReportService
         .list(
            (Wrapper<MesBuildingProduceInspectionTeamReport>)((Wrappers.<MesBuildingProduceInspectionTeamReport>lambdaQuery()
                     .eq(MesBuildingProduceInspectionTeamReport::getTaskId, taskId))
                  .eq(MesBuildingProduceInspectionTeamReport::getTeamId, teamId))
               .orderByDesc(BaseEntity::getCreateTime)
         );
      Integer reduceInspectionQuantity = inspectionTeamReports.stream().mapToInt(MesBuildingProduceInspectionTeamReport::getInspectionQuantity).sum()
         - inspectionQuantity;
      if (reduceInspectionQuantity > 0) {
         for (int i = 0; i < inspectionTeamReports.size() && reduceInspectionQuantity > 0; i++) {
            if (reduceInspectionQuantity >= inspectionTeamReports.get(i).getInspectionQuantity()) {
               reduceInspectionQuantity = reduceInspectionQuantity - inspectionTeamReports.get(i).getInspectionQuantity();
               this.inspectionTeamReportService.removeById(inspectionTeamReports.get(i).getId());
            } else {
               inspectionTeamReports.get(i).setInspectionQuantity(inspectionTeamReports.get(i).getInspectionQuantity() - reduceInspectionQuantity);
               reduceInspectionQuantity = 0;
               this.inspectionTeamReportService.updateById(inspectionTeamReports.get(i));
            }
         }
      }

      return true;
   }

   @Override
   public ProduceAbonrmalReportAndLimitDTO reportList(Long id) {
      MesBuildingAbnormal abnormal = this.abnormalService.getById(id);
      Preconditions.checkArgument(abnormal != null, "操作失败：id不正确");
      ProduceAbonrmalReportAndLimitDTO dto = ProduceAbonrmalReportAndLimitDTO.builder()
         .limitList(this.getProcessAndQuantity(abnormal.getProductId(), abnormal.getProductType()))
         .quantity(
            this.schedulingService
                  .getSchedulingDetailByProductIdAndProductType(abnormal.getProductId(), abnormal.getProductType(), null)
                  .getInProductionQuantity()
               - abnormal.getNewQuantity()
         )
         .build();
      List<ProduceAbonrmalReportDTO> reports = new ArrayList<>();
      dto.getLimitList()
         .forEach(
            e -> reports.addAll(
               this.produceTeamReportService
                  .reportList(
                     abnormal.getProductId(),
                     abnormal.getProductType(),
                     e.getTaskId(),
                     e.getProcessAndQuantitys().stream().map(ProcessAndQuantityDTO::getProcessId).collect(Collectors.toList())
                  )
            )
         );
      Map<Long, Long> deleteMap = new HashMap<>();
      dto.getLimitList().forEach(e -> e.getProcessAndQuantitys().forEach(temp -> {
         if (temp.getQuantity().equals(0)) {
            deleteMap.put(e.getTaskId(), temp.getProcessId());
         }
      }));
      dto.getLimitList()
         .forEach(e -> e.setProcessAndQuantitys(e.getProcessAndQuantitys().stream().filter(temp -> !temp.getQuantity().equals(0)).collect(Collectors.toList())));
      if (deleteMap.size() != 0) {
         for (Long taskId : deleteMap.keySet()) {
            dto.setReportList(
               reports.stream()
                  .filter(e -> !e.getTaskId().equals(taskId) || e.getTaskId().equals(taskId) && !e.getProcessId().equals(deleteMap.get(taskId)))
                  .collect(Collectors.toList())
            );
         }
      } else {
         dto.setReportList(reports);
      }

      return dto;
   }

   @Override
   public AbnormalTaskDTO taskQuantityList(Long productId, Integer productType) {
      List<AbonrmalTaskDO> abnormalTaskDOList = this.taskService.taskQuantityList(productId, productType);
      int handleQuantity = 0;
      if (abnormalTaskDOList.size() != 0) {
         handleQuantity = abnormalTaskDOList.stream().mapToInt(AbonrmalTaskDO::getTaskQuantity).sum() - abnormalTaskDOList.get(0).getQuantity();
      }

      return AbnormalTaskDTO.builder()
         .abnormalTaskList(abnormalTaskDOList.stream().filter(e -> e.getTaskQuantity() > e.getInProductionQuantity()).collect(Collectors.toList()))
         .handleQuantity(handleQuantity)
         .build();
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean changeTaskQuantity(Long id, List<TaskChangeDTOParam> dtoParamList) {
      MesBuildingAbnormal abnormal = this.abnormalService.getById(id);
      Preconditions.checkArgument(abnormal != null, "操作失败：异常id不正确");
      this.updateProductStatus(abnormal.getProductId(), abnormal.getProductType(), false);
      abnormal.setStatus(AbnormalStatusTypeEnum.PROCESSING_COMPLETE.getType());
      this.abnormalService.updateById(abnormal);
      dtoParamList.forEach(
         e -> {
            MesBuildingTask task = this.taskService.getById(e.getId());
            this.abnormalReportService
               .save(
                  MesBuildingAbnormalReport.builder()
                     .abnormalId(id)
                     .productId(abnormal.getProductId())
                     .productType(abnormal.getProductType())
                     .quantity(e.getQuantity())
                     .reportId(e.getId())
                     .userId(UserUtil.getCurrentUserId())
                     .type(AbnormalTypeEnum.PRODUCTION_ABNORMAL.getType())
                     .build()
               );
            Preconditions.checkArgument(task != null, "操作失败：任务id不正确");
            task.setTaskQuantity(task.getTaskQuantity() - e.getQuantity());
            Preconditions.checkArgument(task.getInProductionQuantity() <= task.getTaskQuantity(), "操作失败：数量不能小于进入生产数量");
            this.productProductionSummaryService
               .updateTaskQuantity(
                  ProductProductionSummaryTaskDTOParam.builder()
                     .productId(task.getProductId())
                     .productType(task.getTaskTypeEnum())
                     .taskQuantity(-e.getQuantity())
                     .dateTime(task.getCreateTime())
                     .build()
               );
            task.setStatus(TaskStatusTypeEnum.START.getType());
            this.taskService.updateById(task);
            this.taskProcessService
               .list((Wrapper<MesBuildingTaskProcess>)Wrappers.<MesBuildingTaskProcess>lambdaQuery().eq(MesBuildingTaskProcess::getTaskId, task.getId()))
               .forEach(taskProcess -> {
                  taskProcess.setTaskQuantity(task.getTaskQuantity());
                  taskProcess.setStatus(TaskStatusTypeEnum.START.getType());
                  if (taskProcess.getNeedQuantity() > taskProcess.getTaskQuantity()) {
                     taskProcess.setNeedQuantity(taskProcess.getTaskQuantity());
                  }

                  this.taskProcessService.updateById(taskProcess);
               });
         }
      );
      this.updateProductAbnormal(abnormal.getProductId(), abnormal.getProductType(), false);
      return true;
   }

   private List<TaskProcessAndQuantityDTO> getProcessAndQuantity(Long productId, Integer productType) {
      List<MesBuildingTaskProcessSummaryDTO> summaryDTOList = this.taskProcessService
         .getProcessAndQuantity(productId, productType)
         .stream()
         .sorted(Comparator.comparingInt(MesBuildingTaskProcessSummaryDTO::getSequence))
         .collect(Collectors.toList());
      List<TaskProcessAndQuantityDTO> taskProcessAndQuantitys = new ArrayList<>();
      summaryDTOList.stream()
         .map(MesBuildingTaskProcessSummaryDTO::getTaskId)
         .distinct()
         .collect(Collectors.toList())
         .forEach(e -> taskProcessAndQuantitys.add(TaskProcessAndQuantityDTO.builder().taskId(e).build()));
      taskProcessAndQuantitys.forEach(
         e -> {
            List<ProcessAndQuantityDTO> processAndQuantityDTOList = new ArrayList<>();
            summaryDTOList.stream()
               .filter(item -> item.getTaskId().equals(e.getTaskId()))
               .forEach(
                  item -> processAndQuantityDTOList.add(ProcessAndQuantityDTO.builder().processId(item.getProcessId()).quantity(item.getQuantity()).build())
               );
            e.setProcessAndQuantitys(processAndQuantityDTOList);
         }
      );
      taskProcessAndQuantitys.forEach(
         e -> {
            for (int i = 0; i < e.getProcessAndQuantitys().size(); i++) {
               if (i != e.getProcessAndQuantitys().size() - 1) {
                  e.getProcessAndQuantitys()
                     .get(i)
                     .setQuantity(e.getProcessAndQuantitys().get(i).getQuantity() - e.getProcessAndQuantitys().get(i + 1).getQuantity());
               }
            }

            e.getProcessAndQuantitys()
               .stream()
               .filter(item -> item.getQuantity() != 0)
               .map(item -> BeanUtil.copy(item, ProcessAndQuantityDTO.class))
               .collect(Collectors.toList());
         }
      );
      return taskProcessAndQuantitys.stream()
         .filter(e -> e.getProcessAndQuantitys().stream().mapToInt(ProcessAndQuantityDTO::getQuantity).sum() != 0)
         .collect(Collectors.toList());
   }

   private void updateQuantity(Long taskId, Integer reportQuantity) {
      MesBuildingTask task = this.taskService.getById(taskId);
      if (task.getInProductionTime() == null) {
         task.setInProductionTime(LocalDateTime.now());
      }

      task.setInProductionQuantity(task.getInProductionQuantity() + reportQuantity);
      this.taskService.updateById(task);
      this.productionSummaryService
         .updateRecord(
            ProductProductionSummaryDTOParam.builder()
               .projectId(task.getProjectId())
               .monomerId(task.getMonomerId())
               .productId(task.getProductId())
               .productType(task.getTaskTypeEnum())
               .inProductionQuantity(reportQuantity)
               .build()
         );
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Integer updateAbnormalStatus(Long id) {
      MesBuildingAbnormal abnormal = this.abnormalService.getById(id);
      this.abnormalService.updateById(abnormal.setStatus(AbnormalStatusTypeEnum.PROCESSING.getType()));
      this.taskService
         .list(
            (Wrapper<MesBuildingTask>)(Wrappers.<MesBuildingTask>lambdaQuery().eq(MesBuildingTask::getProductId, abnormal.getProductId()))
               .eq(MesBuildingTask::getTaskTypeEnum, abnormal.getProductType())
         )
         .forEach(
            task -> {
               this.taskService.updateById(task.setStatus(TaskStatusTypeEnum.STOP.getType()));
               this.taskProcessService
                  .list((Wrapper<MesBuildingTaskProcess>)Wrappers.<MesBuildingTaskProcess>lambdaQuery().eq(MesBuildingTaskProcess::getTaskId, task.getId()))
                  .forEach(taskProcess -> this.taskProcessService.updateById(taskProcess.setStatus(TaskStatusTypeEnum.STOP.getType())));
            }
         );
      MesBuildingAbnormalDO abnormalDO = this.abnormalService.selectDetailById(id);
      if (abnormalDO.getNewQuantity() < abnormalDO.getTotalInProductionQuantity()) {
         abnormal.setType(AbnormalTypeEnum.PRODUCTION_ABNORMAL.getType());
      } else {
         abnormal.setType(AbnormalTypeEnum.TASK_ABNORMAL.getType());
      }

      this.abnormalService.updateById(abnormal.setStatus(AbnormalStatusTypeEnum.PROCESSING.getType()));
      return abnormalDO.getNewQuantity() < abnormalDO.getTotalInProductionQuantity()
         ? AbnormalStatusTypeEnum.PROCESSING.getType()
         : AbnormalTypeEnum.TASK_ABNORMAL.getType();
   }

   @Override
   public List<AbnormalChangeReportDTO> abonrmalChangeReport(Long id) {
      MesBuildingAbnormal abnormal = this.abnormalService.getById(id);
      Preconditions.checkArgument(abnormal != null, "操作失败：异常不存在");
      Preconditions.checkArgument(abnormal.getStatus().equals(AbnormalStatusTypeEnum.PROCESSING_COMPLETE.getType()), "操作失败：异常未处理完成");
      return this.abnormalReportService
         .abonrmalChangeReport(abnormal.getId(), abnormal.getType())
         .stream()
         .map(e -> BeanUtil.copy(e, AbnormalChangeReportDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public List<AbnormalSchedulingPreviewDTO> handlePreview(Long abnormalId, List<TaskChangeDTOParam> taskList, List<AbnormalHandleDTOParam> reportList) {
      MesBuildingAbnormal abnormal = this.abnormalService.getById(abnormalId);
      if (abnormal.getType().equals(AbnormalTypeEnum.TASK_ABNORMAL.getType())) {
      }

      return null;
   }

   @Override
   public List<AbnormalProcessPreviewDTO> changePreview(Long productId, Integer productType, Integer oldQuantity, Integer newQuantity) {
      Integer reduceQuantity = oldQuantity - newQuantity;
      SchedulingDetailDTO schedulingDetailDTO = this.schedulingService.getSchedulingDetailByProductIdAndProductType(productId, productType, null);
      if (schedulingDetailDTO.getInProductionQuantity() <= newQuantity) {
         return new ArrayList<>();
      }

      List<AbnormalProcessPreviewDO> doList = this.abnormalService.changePreview(productId, productType);
      List<AbnormalProcessPreviewDTO> dtoList = new ArrayList<>();

      for (int i = 0; i < doList.size() - 1 && reduceQuantity == 0; i++) {
         doList.get(i).setCompleteQuantity(doList.get(i).getCompleteQuantity() - doList.get(i + 1).getCompleteQuantity());
         AbnormalProcessPreviewDTO dto = BeanUtil.copy(dtoList.get(i), AbnormalProcessPreviewDTO.class);
         if (reduceQuantity > doList.get(i).getCompleteQuantity()) {
            dto.setQuantity(doList.get(i).getCompleteQuantity());
            reduceQuantity = reduceQuantity - doList.get(i).getCompleteQuantity();
         } else {
            dto.setQuantity(reduceQuantity);
            reduceQuantity = 0;
         }

         dtoList.add(dto);
      }

      return dtoList.stream().filter(e -> e.getQuantity() != null && e.getQuantity() > 0).collect(Collectors.toList());
   }

   @Override
   public AbnormalPreviewDTO preview(Long id) {
      MesBuildingAbnormal abnormal = this.abnormalService.getById(id);
      Preconditions.checkArgument(abnormal != null, "操作失败：id不正确");
      Preconditions.checkArgument(!abnormal.getStatus().equals(AbnormalStatusTypeEnum.PROCESSING_COMPLETE.getType()), "操作失败：异常已处理完成");
      SchedulingDetailDTO schedulingDetailDTO = this.schedulingService
         .getSchedulingDetailByProductIdAndProductType(abnormal.getProductId(), abnormal.getProductType(), null);
      Integer type = AbnormalTypeEnum.TASK_ABNORMAL.getType();
      if (schedulingDetailDTO.getInProductionQuantity() > abnormal.getNewQuantity()) {
         type = AbnormalTypeEnum.PRODUCTION_ABNORMAL.getType();
      }

      return AbnormalPreviewDTO.builder().preview(this.abnormalService.preview(abnormal.getProductId(), abnormal.getProductType(), type)).type(type).build();
   }

   @Override
   public AbnormalProductDTO productInfo(Long id, Integer productType) {
      if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
         return BeanUtil.copy(this.artifactService.getByIdIgnoreDelete(id), AbnormalProductDTO.class);
      } else if (productType.equals(ProductTypeEnum.ENCLOSURE.getType())) {
         return BeanUtil.copy(this.enclosureService.getByIdIgnoreDelete(id), AbnormalProductDTO.class);
      } else if (productType.equals(ProductTypeEnum.ASSEMBLE.getType())) {
         return BeanUtil.copy(this.assembleService.getByIdIgnoreDelete(id), AbnormalProductDTO.class);
      } else if (productType.equals(ProductTypeEnum.MACHINE_PART.getType())) {
         return BeanUtil.copy(this.machinePartService.getByIdIgnoreDelete(id), AbnormalProductDTO.class);
      } else {
         throw new IllegalArgumentException("操作失败：产品类型不正确");
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean productChange(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long productId,
      Integer productType,
      Integer oldQuantity,
      Integer newQuantity,
      String changeType,
      Boolean boolSurplusEnum,
      Integer type,
      Long artifactId,
      String artifactSerialNumber,
      Long assembleId,
      String assembleSerialNumber
   ) {
      List<Integer> status = new ArrayList<>();
      status.add(AbnormalStatusTypeEnum.PENDING.getType());
      status.add(AbnormalStatusTypeEnum.PROCESSING.getType());
      List<MesBuildingAbnormal> abnormalList = this.abnormalService
         .list(
            (Wrapper<MesBuildingAbnormal>)((Wrappers.<MesBuildingAbnormal>lambdaQuery().eq(MesBuildingAbnormal::getProductId, productId))
                  .eq(MesBuildingAbnormal::getProductType, productType))
               .in(MesBuildingAbnormal::getStatus, status)
         );
      Preconditions.checkArgument(abnormalList.size() == 0, "操作失败，构件零件或组立处于异常中，请先处理异常");
      if (type != null && type.equals(AbnormalTypeEnum.MACHINE_PART_EDITING.getType())) {
         this.abnormalService
            .update(
               (Wrapper<MesBuildingAbnormal>)((((Wrappers.<MesBuildingAbnormal>lambdaUpdate()
                              .eq(MesBuildingAbnormal::getProductId, productId))
                           .eq(MesBuildingAbnormal::getProductType, productType))
                        .eq(MesBuildingAbnormal::getType, AbnormalTypeEnum.MACHINE_PART_EDITING.getType()))
                     .in(MesBuildingAbnormal::getStatus, status))
                  .set(MesBuildingAbnormal::getStatus, AbnormalStatusTypeEnum.CANCEL.getType())
            );
         SchedulingDetailDTO detailDTO = this.schedulingService.getSchedulingDetailByProductIdAndProductType(productId, productType, assembleId);
         MesBuildingAbnormal newAbnormal = MesBuildingAbnormal.builder()
            .productId(productId)
            .productType(productType)
            .newQuantity(newQuantity)
            .changeType(changeType)
            .projectId(projectId)
            .monomerId(monomerId)
            .areaId(areaId)
            .oldQuantity(oldQuantity)
            .newQuantity(newQuantity)
            .artifactId(artifactId)
            .artifactSerialNumber(artifactSerialNumber)
            .taskQuantity(detailDTO.getTotalTaskQuantity())
            .inProductionQuantity(detailDTO.getInProductionQuantity())
            .userId(UserUtil.getCurrentUserId())
            .type(AbnormalTypeEnum.MACHINE_PART_EDITING.getType())
            .status(AbnormalStatusTypeEnum.PENDING.getType())
            .boolSurplusEnum(boolSurplusEnum)
            .build();
         this.abnormalService.save(newAbnormal);
         this.artifactService.updateById(TechArtifact.builder().id(artifactId).boolAbnormalEnum(true).build());
         List<MesBuildingTask> taskList = this.taskService
            .list(
               (Wrapper<MesBuildingTask>)(Wrappers.<MesBuildingTask>lambdaQuery().eq(MesBuildingTask::getTaskTypeEnum, ProductTypeEnum.ARTIFACT.getType()))
                  .eq(MesBuildingTask::getProductId, artifactId)
            );
         taskList.forEach(e -> this.taskService.updateById(e.setStatus(TaskStatusTypeEnum.STOP.getType())));
         List<MesBuildingTaskProcess> taskProcessList = this.taskProcessService
            .list(
               (Wrapper<MesBuildingTaskProcess>)(Wrappers.<MesBuildingTaskProcess>lambdaQuery()
                     .eq(MesBuildingTaskProcess::getTaskTypeEnum, ProductTypeEnum.ARTIFACT.getType()))
                  .eq(MesBuildingTaskProcess::getProductId, artifactId)
            );
         taskProcessList.forEach(e -> this.taskProcessService.updateById(e.setStatus(TaskStatusTypeEnum.STOP.getType())));
      } else {
         MesBuildingAbnormal abnormal = this.abnormalService
            .getOne(
               (Wrapper<MesBuildingAbnormal>)(((Wrappers.<MesBuildingAbnormal>lambdaQuery()
                           .eq(MesBuildingAbnormal::getProductId, productId))
                        .eq(MesBuildingAbnormal::getProductType, productType))
                     .and(
                        e -> {
                           LambdaQueryWrapper var10000 = ((e.isNull(MesBuildingAbnormal::getType))
                                 .or())
                              .ne(MesBuildingAbnormal::getType, AbnormalTypeEnum.MACHINE_PART_EDITING.getType());
                        }
                     ))
                  .in(MesBuildingAbnormal::getStatus, status)
            );
         if (abnormal != null) {
            if (abnormal.getOldQuantity() > newQuantity) {
               abnormal.setNewQuantity(newQuantity);
               abnormal.setStatus(AbnormalStatusTypeEnum.PENDING.getType());
               MesBuildingAbnormalDO abnormalDO = this.abnormalService.selectDetailById(abnormal.getId());
               if (abnormalDO.getNewQuantity() < abnormalDO.getTotalInProductionQuantity()) {
                  abnormal.setType(AbnormalTypeEnum.PRODUCTION_ABNORMAL.getType());
               } else {
                  abnormal.setType(AbnormalTypeEnum.TASK_ABNORMAL.getType());
               }
            } else {
               abnormal.setStatus(AbnormalStatusTypeEnum.CANCEL.getType());
               this.updateTaskStatus(productId, productType, TaskStatusTypeEnum.START.getType(), Boolean.FALSE);
            }

            this.abnormalService.updateById(abnormal);
         } else {
            this.changeProductQuantity(
               projectId,
               monomerId,
               areaId,
               productId,
               productType,
               oldQuantity,
               newQuantity,
               changeType,
               boolSurplusEnum,
               artifactId,
               artifactSerialNumber,
               assembleId,
               assembleSerialNumber
            );
         }
      }

      return Boolean.TRUE;
   }

   @Override
   public Boolean handlePart(Long id) {
      MesBuildingAbnormal abnormal = this.abnormalService.getById(id);
      Preconditions.checkArgument(abnormal != null, "id不正确");
      TechArtifact artifact = this.artifactService.getById(abnormal.getArtifactId());
      Integer addLinkQuantity = abnormal.getNewQuantity() - abnormal.getOldQuantity();
      TechMachinePart machinePart = this.machinePartService.getById(abnormal.getProductId());
      if (machinePart.getProducedQuantity() - machinePart.getUsedQuantity() >= addLinkQuantity) {
         Integer otherUsedQuantity = this.artifactMachinePartLinkService
            .list(
               (Wrapper<TechArtifactMachinePartLink>)(Wrappers.<TechArtifactMachinePartLink>lambdaQuery()
                     .ne(TechArtifactMachinePartLink::getArtifactId, artifact.getId()))
                  .eq(TechArtifactMachinePartLink::getMachinePartId, machinePart.getId())
            )
            .stream()
            .mapToInt(
               e -> this.schedulingService
                     .getSchedulingDetailByProductIdAndProductType(e.getArtifactId(), ProductTypeEnum.ARTIFACT.getType(), null)
                     .getInProductionQuantity()
                  * e.getQuantity()
            )
            .sum();
         SchedulingDetailDTO detailDTO = this.schedulingService
            .getSchedulingDetailByProductIdAndProductType(artifact.getId(), ProductTypeEnum.ARTIFACT.getType(), null);
         machinePart.setUsedQuantity(
            otherUsedQuantity
               + detailDTO.getInProductionQuantity()
                  * this.artifactMachinePartLinkService
                     .getOne(
                        (Wrapper<TechArtifactMachinePartLink>)(Wrappers.<TechArtifactMachinePartLink>lambdaQuery()
                              .eq(TechArtifactMachinePartLink::getArtifactId, artifact.getId()))
                           .eq(TechArtifactMachinePartLink::getMachinePartId, machinePart.getId())
                     )
                     .getQuantity()
         );
         this.machinePartService.updateById(machinePart);
         Integer countQuantity = this.abnormalService
            .list(
               (Wrapper<MesBuildingAbnormal>)(Wrappers.<MesBuildingAbnormal>lambdaQuery().eq(MesBuildingAbnormal::getArtifactId, abnormal.getArtifactId()))
                  .in(MesBuildingAbnormal::getStatus, AbnormalStatusTypeEnum.PENDING.getType(), AbnormalStatusTypeEnum.PROCESSING.getType())
            )
            .size();
         if (countQuantity == 1) {
            this.taskService
               .update(
                  (Wrapper<MesBuildingTask>)((Wrappers.<MesBuildingTask>lambdaUpdate()
                           .eq(MesBuildingTask::getTaskTypeEnum, ProductTypeEnum.ARTIFACT.getType()))
                        .eq(MesBuildingTask::getProductId, abnormal.getArtifactId()))
                     .set(MesBuildingTask::getStatus, TaskStatusTypeEnum.START.getType())
               );
            this.taskProcessService
               .update(
                  (Wrapper<MesBuildingTaskProcess>)((Wrappers.<MesBuildingTaskProcess>lambdaUpdate()
                           .eq(MesBuildingTaskProcess::getTaskTypeEnum, ProductTypeEnum.ARTIFACT.getType()))
                        .eq(MesBuildingTaskProcess::getProductId, abnormal.getArtifactId()))
                     .set(MesBuildingTaskProcess::getStatus, TaskStatusTypeEnum.START.getType())
               );
            this.artifactService.updateById(TechArtifact.builder().id(abnormal.getArtifactId()).boolAbnormalEnum(false).build());
         }

         abnormal.setStatus(AbnormalStatusTypeEnum.PROCESSING_COMPLETE.getType());
         this.abnormalService.updateById(abnormal);
         return Boolean.TRUE;
      } else {
         throw new IllegalArgumentException("操作失败，条件不满足");
      }
   }

   @Override
   public Boolean checkAbnormalExist(Long productId, Integer productType) {
      List<Integer> status = new ArrayList<>();
      status.add(AbnormalStatusTypeEnum.PENDING.getType());
      status.add(AbnormalStatusTypeEnum.PROCESSING.getType());
      List<MesBuildingAbnormal> abnormalList = this.abnormalService
         .list(
            (Wrapper<MesBuildingAbnormal>)((Wrappers.<MesBuildingAbnormal>lambdaQuery().eq(MesBuildingAbnormal::getProductId, productId))
                  .eq(MesBuildingAbnormal::getProductType, productType))
               .in(MesBuildingAbnormal::getStatus, status)
         );
      return abnormalList.size() == 0 ? Boolean.FALSE : Boolean.TRUE;
   }

   private Boolean updateProductStatus(Long productId, Integer productType, Boolean status) {
      if (productType.equals(ProductTypeEnum.MACHINE_PART.getType())) {
         TechMachinePart machinePart = this.machinePartService.getByIdIgnoreDelete(productId);
         machinePart.setBoolAbnormalEnum(status);
         this.machinePartService.updateById(machinePart);
      }

      return true;
   }

   private Boolean updateTaskStatus(Long productId, Integer productType, Integer status, Boolean boolAbnormalEnum) {
      this.taskService
         .update(
            (Wrapper<MesBuildingTask>)((Wrappers.<MesBuildingTask>lambdaUpdate().eq(MesBuildingTask::getTaskTypeEnum, productType))
                  .eq(MesBuildingTask::getProductId, productId))
               .set(MesBuildingTask::getStatus, status)
         );
      this.taskProcessService
         .update(
            (Wrapper<MesBuildingTaskProcess>)((Wrappers.<MesBuildingTaskProcess>lambdaUpdate()
                     .eq(MesBuildingTaskProcess::getTaskTypeEnum, productType))
                  .eq(MesBuildingTaskProcess::getProductId, productId))
               .set(MesBuildingTaskProcess::getStatus, status)
         );
      if (productType.equals(ProductTypeEnum.ARTIFACT.getType())) {
         this.artifactService.updateById(TechArtifact.builder().id(productId).boolAbnormalEnum(boolAbnormalEnum).build());
      } else if (productType.equals(ProductTypeEnum.ASSEMBLE.getType())) {
         this.assembleService.updateById(TechAssemble.builder().id(productId).boolAbnormalEnum(boolAbnormalEnum).build());
      } else if (productType.equals(ProductTypeEnum.MACHINE_PART.getType())) {
         this.machinePartService.updateById(TechMachinePart.builder().id(productId).boolAbnormalEnum(boolAbnormalEnum).build());
      }

      return Boolean.TRUE;
   }
}
