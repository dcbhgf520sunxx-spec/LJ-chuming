package com.hzchum.scim.mes.building.core.biz.impl.task;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.pangu.common.util.DateTimeUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingProjectProductionSummaryBiz;
import com.hzchum.scim.mes.building.core.api.enums.process.ProcessTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProjectProductionSummary;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProjectProductionSummaryService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingProjectProductionSummaryMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingProjectProductionSummaryBizImpl
   extends IBizImpl<MesBuildingProjectProductionSummaryService, MesBuildingProjectProductionSummaryMapper, MesBuildingProjectProductionSummary>
   implements MesBuildingProjectProductionSummaryBiz {
   @Autowired
   private MesBuildingTaskService taskService;
   @Autowired
   private MesBuildingTaskProcessService taskProcessService;
   @Autowired
   private MesBuildingProcessService processService;
   @Autowired
   private TechArtifactService artifactService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateProjectMeteSummary(Long taskId, Long taskProcessId, Integer quantity, LocalDateTime dateTime) {
      MesBuildingTask task = this.taskService.getById(taskId);
      TechArtifact artifact = this.artifactService.getById(task.getProductId());
      List<MesBuildingTaskProcess> taskProcessList = this.taskProcessService
         .list(Wrappers.lambdaQuery(MesBuildingTaskProcess.class).eq(MesBuildingTaskProcess::getTaskId, taskId).orderByAsc(MesBuildingTaskProcess::getSequence));
      Map<Long, MesBuildingTaskProcess> taskProcessMap = taskProcessList.stream().collect(Collectors.toMap(MesBuildingTaskProcess::getId, Function.identity()));
      Map<Long, MesBuildingProcess> processMap = this.processService
         .list(Wrappers.lambdaQuery(MesBuildingProcess.class).eq(MesBuildingProcess::getProductType, TaskTypeEnum.ARTIFACT.getType()))
         .stream()
         .collect(Collectors.toMap(MesBuildingProcess::getId, Function.identity()));
      if (processMap.get(taskProcessMap.get(taskProcessId).getProcessId()).getType().equals(ProcessTypeEnum.PAINT.getType())) {
         MesBuildingProjectProductionSummary projectProductionSummary = this.baseService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingProjectProductionSummary.class)
                  .eq(MesBuildingProjectProductionSummary::getProjectId, task.getProjectId())
                  .eq(
                     MesBuildingProjectProductionSummary::getMonth,
                     dateTime == null ? DateTimeUtil.getLocalMonthStr() : DateTimeUtil.getLocalMonthStr(dateTime)
                  )
            );
         if (projectProductionSummary == null) {
            projectProductionSummary = MesBuildingProjectProductionSummary.builder()
               .projectId(task.getProjectId())
               .month(dateTime == null ? DateTimeUtil.getLocalMonthStr() : DateTimeUtil.getLocalMonthStr(dateTime))
               .painingQuantity(quantity)
               .painingMete(artifact.getNetWeight().multiply(BigDecimal.valueOf(quantity.intValue())))
               .build();
            this.baseService.save(projectProductionSummary);
         } else {
            projectProductionSummary.setPainingQuantity(projectProductionSummary.getPainingQuantity() + quantity);
            projectProductionSummary.setPainingMete(
               projectProductionSummary.getPainingMete().add(artifact.getNetWeight().multiply(BigDecimal.valueOf(quantity.intValue())))
            );
            this.baseService.updateById(projectProductionSummary);
         }

         MesBuildingProjectProductionSummary summary = this.baseService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingProjectProductionSummary.class)
                  .isNull(MesBuildingProjectProductionSummary::getProjectId)
                  .eq(
                     MesBuildingProjectProductionSummary::getMonth,
                     dateTime == null ? DateTimeUtil.getLocalMonthStr() : DateTimeUtil.getLocalMonthStr(dateTime)
                  )
            );
         if (summary == null) {
            summary = MesBuildingProjectProductionSummary.builder()
               .month(dateTime == null ? DateTimeUtil.getLocalMonthStr() : DateTimeUtil.getLocalMonthStr(dateTime))
               .painingQuantity(quantity)
               .painingMete(artifact.getNetWeight().multiply(BigDecimal.valueOf(quantity.intValue())))
               .build();
            this.baseService.save(summary);
         } else {
            summary.setPainingQuantity(summary.getPainingQuantity() + quantity);
            summary.setPainingMete(summary.getPainingMete().add(artifact.getNetWeight().multiply(BigDecimal.valueOf(quantity.intValue()))));
            this.baseService.updateById(summary);
         }
      }

      if (processMap.get(taskProcessList.get(taskProcessList.size() - 1).getProcessId()).getType().equals(ProcessTypeEnum.PAINT.getType())
         && processMap.get(taskProcessMap.get(taskProcessId).getProcessId()).getType().equals(ProcessTypeEnum.ASSEMBLY_RIVETING_WELDING.getType())
         && taskProcessMap.get(taskProcessId).getSequence().equals(taskProcessList.size() - 2)) {
         MesBuildingProjectProductionSummary projectProductionSummary = this.baseService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingProjectProductionSummary.class)
                  .eq(MesBuildingProjectProductionSummary::getProjectId, task.getProjectId())
                  .eq(
                     MesBuildingProjectProductionSummary::getMonth,
                     dateTime == null ? DateTimeUtil.getLocalMonthStr() : DateTimeUtil.getLocalMonthStr(dateTime)
                  )
            );
         if (projectProductionSummary == null) {
            projectProductionSummary = MesBuildingProjectProductionSummary.builder()
               .projectId(task.getProjectId())
               .month(dateTime == null ? DateTimeUtil.getLocalMonthStr() : DateTimeUtil.getLocalMonthStr(dateTime))
               .assemblyRivetingWeldingQuantity(quantity)
               .assemblyRivetingWeldingMete(artifact.getNetWeight().multiply(BigDecimal.valueOf(quantity.intValue())))
               .build();
            this.baseService.save(projectProductionSummary);
         } else {
            projectProductionSummary.setAssemblyRivetingWeldingQuantity(projectProductionSummary.getAssemblyRivetingWeldingQuantity() + quantity);
            projectProductionSummary.setAssemblyRivetingWeldingMete(
               projectProductionSummary.getAssemblyRivetingWeldingMete().add(artifact.getNetWeight().multiply(BigDecimal.valueOf(quantity.intValue())))
            );
            this.baseService.updateById(projectProductionSummary);
         }

         MesBuildingProjectProductionSummary summary = this.baseService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingProjectProductionSummary.class)
                  .isNull(MesBuildingProjectProductionSummary::getProjectId)
                  .eq(
                     MesBuildingProjectProductionSummary::getMonth,
                     dateTime == null ? DateTimeUtil.getLocalMonthStr() : DateTimeUtil.getLocalMonthStr(dateTime)
                  )
            );
         if (summary == null) {
            summary = MesBuildingProjectProductionSummary.builder()
               .month(dateTime == null ? DateTimeUtil.getLocalMonthStr() : DateTimeUtil.getLocalMonthStr(dateTime))
               .assemblyRivetingWeldingQuantity(quantity)
               .assemblyRivetingWeldingMete(artifact.getNetWeight().multiply(BigDecimal.valueOf(quantity.intValue())))
               .build();
            this.baseService.save(summary);
         } else {
            summary.setAssemblyRivetingWeldingQuantity(summary.getAssemblyRivetingWeldingQuantity() + quantity);
            summary.setAssemblyRivetingWeldingMete(summary.getAssemblyRivetingWeldingMete().add(artifact.getNetWeight().multiply(BigDecimal.valueOf(quantity.intValue()))));
            this.baseService.updateById(summary);
         }
      }

      if (taskProcessMap.get(taskProcessId).getSequence().equals(taskProcessList.size() - 1)) {
         MesBuildingProjectProductionSummary projectProductionSummary = this.baseService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingProjectProductionSummary.class)
                  .eq(MesBuildingProjectProductionSummary::getProjectId, task.getProjectId())
                  .eq(
                     MesBuildingProjectProductionSummary::getMonth,
                     dateTime == null ? DateTimeUtil.getLocalMonthStr() : DateTimeUtil.getLocalMonthStr(dateTime)
                  )
            );
         if (projectProductionSummary == null) {
            projectProductionSummary = MesBuildingProjectProductionSummary.builder()
               .projectId(task.getProjectId())
               .month(dateTime == null ? DateTimeUtil.getLocalMonthStr() : DateTimeUtil.getLocalMonthStr(dateTime))
               .quantity(quantity)
               .mete(artifact.getNetWeight().multiply(BigDecimal.valueOf(quantity.intValue())))
               .build();
            this.baseService.save(projectProductionSummary);
         } else {
            projectProductionSummary.setQuantity(projectProductionSummary.getQuantity() + quantity);
            projectProductionSummary.setMete(
               projectProductionSummary.getMete().add(artifact.getNetWeight().multiply(BigDecimal.valueOf(quantity.intValue())))
            );
            this.baseService.updateById(projectProductionSummary);
         }

         MesBuildingProjectProductionSummary summary = this.baseService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingProjectProductionSummary.class)
                  .isNull(MesBuildingProjectProductionSummary::getProjectId)
                  .eq(
                     MesBuildingProjectProductionSummary::getMonth,
                     dateTime == null ? DateTimeUtil.getLocalMonthStr() : DateTimeUtil.getLocalMonthStr(dateTime)
                  )
            );
         if (summary == null) {
            summary = MesBuildingProjectProductionSummary.builder()
               .month(dateTime == null ? DateTimeUtil.getLocalMonthStr() : DateTimeUtil.getLocalMonthStr(dateTime))
               .quantity(quantity)
               .mete(artifact.getNetWeight().multiply(BigDecimal.valueOf(quantity.intValue())))
               .build();
            this.baseService.save(summary);
         } else {
            summary.setQuantity(summary.getQuantity() + quantity);
            summary.setMete(summary.getMete().add(artifact.getNetWeight().multiply(BigDecimal.valueOf(quantity.intValue()))));
            this.baseService.updateById(summary);
         }
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean revokeProjectMeteSummary(Long taskId, Long taskProcessId, Integer quantity, LocalDateTime dateTime) {
      MesBuildingTask task = this.taskService.getById(taskId);
      TechArtifact artifact = this.artifactService.getById(task.getProductId());
      List<MesBuildingTaskProcess> taskProcessList = this.taskProcessService
         .list(Wrappers.lambdaQuery(MesBuildingTaskProcess.class).eq(MesBuildingTaskProcess::getTaskId, taskId).orderByAsc(MesBuildingTaskProcess::getSequence));
      Map<Long, MesBuildingTaskProcess> taskProcessMap = taskProcessList.stream().collect(Collectors.toMap(MesBuildingTaskProcess::getId, Function.identity()));
      Map<Long, MesBuildingProcess> processMap = this.processService
         .list(Wrappers.lambdaQuery(MesBuildingProcess.class).eq(MesBuildingProcess::getProductType, TaskTypeEnum.ARTIFACT.getType()))
         .stream()
         .collect(Collectors.toMap(MesBuildingProcess::getId, Function.identity()));
      if (processMap.get(taskProcessMap.get(taskProcessId).getProcessId()).getType().equals(ProcessTypeEnum.PAINT.getType())) {
         MesBuildingProjectProductionSummary projectProductionSummary = this.baseService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingProjectProductionSummary.class)
                  .eq(MesBuildingProjectProductionSummary::getProjectId, task.getProjectId())
                  .eq(
                     MesBuildingProjectProductionSummary::getMonth,
                     dateTime == null ? DateTimeUtil.getLocalMonthStr() : DateTimeUtil.getLocalMonthStr(dateTime)
                  )
            );
         if (projectProductionSummary != null) {
            projectProductionSummary.setPainingQuantity(projectProductionSummary.getPainingQuantity() - quantity);
            projectProductionSummary.setPainingMete(
               projectProductionSummary.getPainingMete().subtract(artifact.getNetWeight().multiply(BigDecimal.valueOf(quantity.intValue())))
            );
            this.baseService.updateById(projectProductionSummary);
            this.removeSummary(projectProductionSummary);
         }

         MesBuildingProjectProductionSummary summary = this.baseService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingProjectProductionSummary.class)
                  .isNull(MesBuildingProjectProductionSummary::getProjectId)
                  .eq(
                     MesBuildingProjectProductionSummary::getMonth,
                     dateTime == null ? DateTimeUtil.getLocalMonthStr() : DateTimeUtil.getLocalMonthStr(dateTime)
                  )
            );
         if (summary != null) {
            summary.setPainingQuantity(summary.getPainingQuantity() - quantity);
            summary.setPainingMete(summary.getPainingMete().subtract(artifact.getNetWeight().multiply(BigDecimal.valueOf(quantity.intValue()))));
            this.baseService.updateById(summary);
            this.removeSummary(summary);
         }
      }

      if (processMap.get(taskProcessList.get(taskProcessList.size() - 1).getProcessId()).getType().equals(ProcessTypeEnum.PAINT.getType())
         && processMap.get(taskProcessMap.get(taskProcessId).getProcessId()).getType().equals(ProcessTypeEnum.ASSEMBLY_RIVETING_WELDING.getType())
         && taskProcessMap.get(taskProcessId).getSequence().equals(taskProcessList.size() - 2)) {
         MesBuildingProjectProductionSummary projectProductionSummary = this.baseService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingProjectProductionSummary.class)
                  .eq(MesBuildingProjectProductionSummary::getProjectId, task.getProjectId())
                  .eq(
                     MesBuildingProjectProductionSummary::getMonth,
                     dateTime == null ? DateTimeUtil.getLocalMonthStr() : DateTimeUtil.getLocalMonthStr(dateTime)
                  )
            );
         if (projectProductionSummary != null) {
            projectProductionSummary.setAssemblyRivetingWeldingQuantity(projectProductionSummary.getAssemblyRivetingWeldingQuantity() - quantity);
            projectProductionSummary.setAssemblyRivetingWeldingMete(
               projectProductionSummary.getAssemblyRivetingWeldingMete().subtract(artifact.getNetWeight().multiply(BigDecimal.valueOf(quantity.intValue())))
            );
            this.baseService.updateById(projectProductionSummary);
            this.removeSummary(projectProductionSummary);
         }

         MesBuildingProjectProductionSummary summary = this.baseService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingProjectProductionSummary.class)
                  .isNull(MesBuildingProjectProductionSummary::getProjectId)
                  .eq(
                     MesBuildingProjectProductionSummary::getMonth,
                     dateTime == null ? DateTimeUtil.getLocalMonthStr() : DateTimeUtil.getLocalMonthStr(dateTime)
                  )
            );
         if (summary != null) {
            summary.setAssemblyRivetingWeldingQuantity(summary.getAssemblyRivetingWeldingQuantity() - quantity);
            summary.setAssemblyRivetingWeldingMete(summary.getAssemblyRivetingWeldingMete().subtract(artifact.getNetWeight().multiply(BigDecimal.valueOf(quantity.intValue()))));
            this.baseService.updateById(summary);
            this.removeSummary(summary);
         }
      }

      if (taskProcessMap.get(taskProcessId).getSequence().equals(taskProcessList.size() - 1)) {
         MesBuildingProjectProductionSummary projectProductionSummary = this.baseService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingProjectProductionSummary.class)
                  .eq(MesBuildingProjectProductionSummary::getProjectId, task.getProjectId())
                  .eq(
                     MesBuildingProjectProductionSummary::getMonth,
                     dateTime == null ? DateTimeUtil.getLocalMonthStr() : DateTimeUtil.getLocalMonthStr(dateTime)
                  )
            );
         if (projectProductionSummary != null) {
            projectProductionSummary.setQuantity(projectProductionSummary.getQuantity() - quantity);
            projectProductionSummary.setMete(
               projectProductionSummary.getMete().subtract(artifact.getNetWeight().multiply(BigDecimal.valueOf(quantity.intValue())))
            );
            this.baseService.updateById(projectProductionSummary);
            this.removeSummary(projectProductionSummary);
         }

         MesBuildingProjectProductionSummary summary = this.baseService
            .getOne(
               Wrappers.lambdaQuery(MesBuildingProjectProductionSummary.class)
                  .isNull(MesBuildingProjectProductionSummary::getProjectId)
                  .eq(
                     MesBuildingProjectProductionSummary::getMonth,
                     dateTime == null ? DateTimeUtil.getLocalMonthStr() : DateTimeUtil.getLocalMonthStr(dateTime)
                  )
            );
         if (summary != null) {
            summary.setQuantity(summary.getQuantity() - quantity);
            summary.setMete(summary.getMete().subtract(artifact.getNetWeight().multiply(BigDecimal.valueOf(quantity.intValue()))));
            this.baseService.updateById(summary);
            this.removeSummary(summary);
         }
      }

      return true;
   }

   public void removeSummary(MesBuildingProjectProductionSummary summary) {
      if (summary.getQuantity() == 0 && summary.getPainingQuantity() == 0 && summary.getAssemblyRivetingWeldingQuantity() == 0) {
         this.baseService.removeById(summary);
      }
   }
}
