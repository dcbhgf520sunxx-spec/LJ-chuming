package com.hzchum.scim.rest.initialize.mes.building;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingMachinePartSchedulingLinkMonthBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingNeedMachinePartSchedulingBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingNeedMachinePartSchedulingLinkBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskNeedMachinePartSchedulingBiz;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingMachinePartSchedulingLinkMonth;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNeedMachinePartScheduling;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingNeedMachinePartSchedulingLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingMachinePartSchedulingArtifactTaskLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNeedMachinePartScheduling;
import com.hzchum.scim.mes.building.core.api.service.initialization.InitializationService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingMachinePartSchedulingArtifactTaskLinkService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleTypesettingPartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechAssembleMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechAssembleTypesettingPartLinkService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Order(61)
@Component
public class MesTaskNeedMachinePartRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(MesTaskNeedMachinePartRunner.class);
   private final InitializationService service;
   private final MesBuildingNeedMachinePartSchedulingBiz needMachinePartSchedulingBiz;
   private final MesBuildingNeedMachinePartSchedulingLinkBiz needMachinePartSchedulingLinkBiz;
   private final MesBuildingTaskNeedMachinePartSchedulingBiz taskNeedMachinePartSchedulingBiz;
   private final MesBuildingTaskBiz taskBiz;
   private final TechArtifactMachinePartLinkService artifactMachinePartLinkService;
   private final TechAssembleMachinePartLinkService assembleMachinePartLinkService;
   private final TechAssembleTypesettingPartLinkService assembleTypesettingPartLinkService;
   private final MesBuildingMachinePartSchedulingArtifactTaskLinkService artifactTaskLinkService;
   private final TechMachinePartService machinePartService;
   private final MesBuildingMachinePartSchedulingLinkMonthBiz machinePartSchedulingLinkMonthBiz;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void run(String... args) {
      List<String> updateSqlList = new ArrayList<>();
      log.info("初始化构件需求表结构开始............................................");
      if (this.needMachinePartSchedulingBiz.count(Wrappers.lambdaQuery(MesBuildingNeedMachinePartScheduling.class)) > 0) {
         List<MesBuildingTask> taskList = this.taskBiz
            .list(
               Wrappers.lambdaQuery(MesBuildingTask.class)
                  .ne(MesBuildingTask::getTaskTypeEnum, TaskTypeEnum.MACHINE_PART.getType())
                  .orderByAsc(MesBuildingTask::getId)
            );
         taskList.forEach(
            e -> {
               if (e.getTaskTypeEnum().equals(TaskTypeEnum.ARTIFACT.getType())) {
                  this.artifactMachinePartLinkService
                     .list(Wrappers.lambdaQuery(TechArtifactMachinePartLink.class).eq(TechArtifactMachinePartLink::getArtifactId, e.getProductId()))
                     .forEach(
                        artifactMachinePartLink -> {
                           TechMachinePart machinePart = this.machinePartService.getById(artifactMachinePartLink.getMachinePartId());
                           if (machinePart.getRelationType().equals(TaskTypeEnum.ARTIFACT.getType()) && machinePart.getBoolProcess()) {
                              MesBuildingNeedMachinePartSchedulingLink link = this.needMachinePartSchedulingLinkBiz
                                 .getOne(
                                    Wrappers.lambdaQuery(MesBuildingNeedMachinePartSchedulingLink.class)
                                       .eq(MesBuildingNeedMachinePartSchedulingLink::getProductId, machinePart.getId())
                                       .eq(MesBuildingNeedMachinePartSchedulingLink::getGroupsId, e.getGroupsId())
                                       .apply("DATE_FORMAT(need_scheduling_time,'%Y-%m')={0}", e.getCreateTime().format(DateTimeFormatter.ofPattern("yyyy-MM")))
                                       .orderByAsc(MesBuildingNeedMachinePartSchedulingLink::getId)
                                 );
                              if (link != null) {
                                 MesBuildingTaskNeedMachinePartScheduling needMachinePartScheduling = MesBuildingTaskNeedMachinePartScheduling.builder()
                                    .projectId(e.getProjectId())
                                    .monomerId(e.getMonomerId())
                                    .areaId(e.getAreaId())
                                    .taskId(e.getId())
                                    .taskOrderId(e.getTaskOrderId())
                                    .workshopId(e.getWorkshopId())
                                    .groupsId(e.getGroupsId())
                                    .productionLineId(e.getProductionLineId())
                                    .askCompleteTime(e.getAskCompleteTime())
                                    .productId(machinePart.getId())
                                    .useId(e.getUserId())
                                    .build();
                                 needMachinePartScheduling.setNeedQuantity(e.getTaskQuantity() * artifactMachinePartLink.getQuantity());
                                 link.setNeedQuantity(link.getNeedQuantity() - needMachinePartScheduling.getNeedQuantity());
                                 if (link.getSchedulingQuantity() > 0) {
                                    if (link.getSchedulingQuantity() >= e.getTaskQuantity() * artifactMachinePartLink.getQuantity()) {
                                       needMachinePartScheduling.setSchedulingQuantity(e.getTaskQuantity() * artifactMachinePartLink.getQuantity());
                                       link.setSchedulingQuantity(link.getSchedulingQuantity() - e.getTaskQuantity() * artifactMachinePartLink.getQuantity());
                                    } else {
                                       needMachinePartScheduling.setSchedulingQuantity(link.getSchedulingQuantity());
                                       link.setNeedQuantity(0);
                                    }
                                 } else {
                                    needMachinePartScheduling.setSchedulingQuantity(0);
                                 }

                                 if (link.getSchedulingQuantity() < 0) {
                                    link.setSchedulingQuantity(0);
                                 }

                                 this.taskNeedMachinePartSchedulingBiz.save(needMachinePartScheduling);
                                 this.machinePartSchedulingLinkMonthBiz
                                    .list(
                                       Wrappers.lambdaQuery(MesBuildingMachinePartSchedulingLinkMonth.class)
                                          .eq(MesBuildingMachinePartSchedulingLinkMonth::getNeedLinkId, link.getId())
                                    )
                                    .forEach(
                                       linkMonth -> this.artifactTaskLinkService
                                          .save(
                                             MesBuildingMachinePartSchedulingArtifactTaskLink.builder()
                                                .taskId(e.getId())
                                                .needLinkId(link.getId())
                                                .schedulingId(linkMonth.getSchedulingId())
                                                .quantity(linkMonth.getQuantity())
                                                .schedulingLinkId(linkMonth.getSchedulingLinkId())
                                                .build()
                                          )
                                    );
                                 if (link.getNeedQuantity() != 0) {
                                    this.needMachinePartSchedulingLinkBiz.updateById(link);
                                 } else {
                                    this.needMachinePartSchedulingLinkBiz.removeById(link.getId());
                                 }
                              }
                           }
                        }
                     );
               } else if (e.getTaskTypeEnum().equals(TaskTypeEnum.ASSEMBLE.getType())) {
                  this.assembleMachinePartLinkService
                     .list(Wrappers.lambdaQuery(TechAssembleMachinePartLink.class).eq(TechAssembleMachinePartLink::getAssembleId, e.getProductId()))
                     .forEach(
                        assembleMachinePartLink -> {
                           TechMachinePart machinePart = this.machinePartService.getById(assembleMachinePartLink.getMachinePartId());
                           if (machinePart.getBoolProcess()) {
                              MesBuildingNeedMachinePartSchedulingLink link = this.needMachinePartSchedulingLinkBiz
                                 .getOne(
                                    Wrappers.lambdaQuery(MesBuildingNeedMachinePartSchedulingLink.class)
                                       .eq(MesBuildingNeedMachinePartSchedulingLink::getProductId, machinePart.getId())
                                       .eq(MesBuildingNeedMachinePartSchedulingLink::getGroupsId, e.getGroupsId())
                                       .orderByAsc(MesBuildingNeedMachinePartSchedulingLink::getId)
                                 );
                              if (link != null) {
                                 MesBuildingTaskNeedMachinePartScheduling needMachinePartScheduling = MesBuildingTaskNeedMachinePartScheduling.builder()
                                    .projectId(e.getProjectId())
                                    .monomerId(e.getMonomerId())
                                    .areaId(e.getAreaId())
                                    .taskId(e.getId())
                                    .taskOrderId(e.getTaskOrderId())
                                    .workshopId(e.getWorkshopId())
                                    .groupsId(e.getGroupsId())
                                    .productionLineId(e.getProductionLineId())
                                    .askCompleteTime(e.getAskCompleteTime())
                                    .productId(machinePart.getId())
                                    .useId(e.getUserId())
                                    .build();
                                 needMachinePartScheduling.setNeedQuantity(e.getTaskQuantity() * assembleMachinePartLink.getQuantity());
                                 link.setNeedQuantity(link.getNeedQuantity() - needMachinePartScheduling.getNeedQuantity());
                                 if (link.getSchedulingQuantity() > 0) {
                                    if (link.getSchedulingQuantity() >= e.getTaskQuantity() * assembleMachinePartLink.getQuantity()) {
                                       needMachinePartScheduling.setSchedulingQuantity(e.getTaskQuantity() * assembleMachinePartLink.getQuantity());
                                       link.setSchedulingQuantity(link.getSchedulingQuantity() - e.getTaskQuantity() * assembleMachinePartLink.getQuantity());
                                    } else {
                                       needMachinePartScheduling.setSchedulingQuantity(link.getSchedulingQuantity());
                                       link.setNeedQuantity(0);
                                    }
                                 } else {
                                    needMachinePartScheduling.setSchedulingQuantity(0);
                                 }

                                 if (link.getSchedulingQuantity() < 0) {
                                    link.setSchedulingQuantity(0);
                                 }

                                 this.taskNeedMachinePartSchedulingBiz.save(needMachinePartScheduling);
                                 this.machinePartSchedulingLinkMonthBiz
                                    .list(
                                       Wrappers.lambdaQuery(MesBuildingMachinePartSchedulingLinkMonth.class)
                                          .eq(MesBuildingMachinePartSchedulingLinkMonth::getNeedLinkId, link.getId())
                                    )
                                    .forEach(
                                       linkMonth -> this.artifactTaskLinkService
                                          .save(
                                             MesBuildingMachinePartSchedulingArtifactTaskLink.builder()
                                                .taskId(e.getId())
                                                .needLinkId(link.getId())
                                                .schedulingId(linkMonth.getSchedulingId())
                                                .quantity(linkMonth.getQuantity())
                                                .schedulingLinkId(linkMonth.getSchedulingLinkId())
                                                .build()
                                          )
                                    );
                                 if (link.getNeedQuantity() == 0) {
                                    this.needMachinePartSchedulingLinkBiz.updateById(link);
                                 } else {
                                    this.needMachinePartSchedulingLinkBiz.removeById(link.getId());
                                 }
                              }
                           }
                        }
                     );
               } else {
                  this.assembleTypesettingPartLinkService
                     .list(
                        Wrappers.lambdaQuery(TechAssembleTypesettingPartLink.class)
                           .eq(TechAssembleTypesettingPartLink::getAssembleTypesettingId, e.getProductId())
                     )
                     .forEach(
                        assembleTypesettingPartLink -> {
                           TechMachinePart machinePart = this.machinePartService.getById(assembleTypesettingPartLink.getMachinePartId());
                           if (machinePart.getBoolProcess()) {
                              MesBuildingNeedMachinePartSchedulingLink link = this.needMachinePartSchedulingLinkBiz
                                 .getOne(
                                    Wrappers.lambdaQuery(MesBuildingNeedMachinePartSchedulingLink.class)
                                       .eq(MesBuildingNeedMachinePartSchedulingLink::getProductId, machinePart.getId())
                                       .eq(MesBuildingNeedMachinePartSchedulingLink::getGroupsId, e.getGroupsId())
                                       .apply("DATE_FORMAT(need_scheduling_time,'%Y-%m')={0}", e.getCreateTime().format(DateTimeFormatter.ofPattern("yyyy-MM")))
                                       .orderByAsc(MesBuildingNeedMachinePartSchedulingLink::getId)
                                 );
                              if (link != null) {
                                 MesBuildingTaskNeedMachinePartScheduling needMachinePartScheduling = MesBuildingTaskNeedMachinePartScheduling.builder()
                                    .projectId(e.getProjectId())
                                    .monomerId(e.getMonomerId())
                                    .areaId(e.getAreaId())
                                    .taskId(e.getId())
                                    .taskOrderId(e.getTaskOrderId())
                                    .workshopId(e.getWorkshopId())
                                    .groupsId(e.getGroupsId())
                                    .productionLineId(e.getProductionLineId())
                                    .askCompleteTime(e.getAskCompleteTime())
                                    .productId(machinePart.getId())
                                    .useId(e.getUserId())
                                    .build();
                                 needMachinePartScheduling.setNeedQuantity(e.getTaskQuantity() * assembleTypesettingPartLink.getQuantity());
                                 link.setNeedQuantity(link.getNeedQuantity() - needMachinePartScheduling.getNeedQuantity());
                                 if (link.getSchedulingQuantity() > 0) {
                                    if (link.getSchedulingQuantity() >= e.getTaskQuantity() * assembleTypesettingPartLink.getQuantity()) {
                                       needMachinePartScheduling.setSchedulingQuantity(e.getTaskQuantity() * assembleTypesettingPartLink.getQuantity());
                                       link.setSchedulingQuantity(
                                          link.getSchedulingQuantity() - e.getTaskQuantity() * assembleTypesettingPartLink.getQuantity()
                                       );
                                    } else {
                                       needMachinePartScheduling.setSchedulingQuantity(link.getSchedulingQuantity());
                                       link.setNeedQuantity(0);
                                    }
                                 } else {
                                    needMachinePartScheduling.setSchedulingQuantity(0);
                                 }

                                 this.taskNeedMachinePartSchedulingBiz.save(needMachinePartScheduling);
                                 this.machinePartSchedulingLinkMonthBiz
                                    .list(
                                       Wrappers.lambdaQuery(MesBuildingMachinePartSchedulingLinkMonth.class)
                                          .eq(MesBuildingMachinePartSchedulingLinkMonth::getNeedLinkId, link.getId())
                                    )
                                    .forEach(
                                       linkMonth -> this.artifactTaskLinkService
                                          .save(
                                             MesBuildingMachinePartSchedulingArtifactTaskLink.builder()
                                                .taskId(e.getId())
                                                .needLinkId(link.getId())
                                                .schedulingId(linkMonth.getSchedulingId())
                                                .quantity(linkMonth.getQuantity())
                                                .schedulingLinkId(linkMonth.getSchedulingLinkId())
                                                .build()
                                          )
                                    );
                                 if (link.getNeedQuantity() == 0) {
                                    this.needMachinePartSchedulingLinkBiz.updateById(link);
                                 } else {
                                    this.needMachinePartSchedulingLinkBiz.removeById(link.getId());
                                 }
                              }
                           }
                        }
                     );
               }
            }
         );
         updateSqlList.clear();
         List<String> selectSqlList = new ArrayList<>();
         selectSqlList.add("TRUNCATE TABLE mes_building_need_machine_part_scheduling;");
         selectSqlList.add("TRUNCATE TABLE mes_building_need_machine_part_scheduling_link;");
         selectSqlList.forEach(e -> updateSqlList.addAll(this.service.selectSql(e)));
      }

      log.info("初始化构件需求表结构结束............................................");
   }

   public MesTaskNeedMachinePartRunner(
      final InitializationService service,
      final MesBuildingNeedMachinePartSchedulingBiz needMachinePartSchedulingBiz,
      final MesBuildingNeedMachinePartSchedulingLinkBiz needMachinePartSchedulingLinkBiz,
      final MesBuildingTaskNeedMachinePartSchedulingBiz taskNeedMachinePartSchedulingBiz,
      final MesBuildingTaskBiz taskBiz,
      final TechArtifactMachinePartLinkService artifactMachinePartLinkService,
      final TechAssembleMachinePartLinkService assembleMachinePartLinkService,
      final TechAssembleTypesettingPartLinkService assembleTypesettingPartLinkService,
      final MesBuildingMachinePartSchedulingArtifactTaskLinkService artifactTaskLinkService,
      final TechMachinePartService machinePartService,
      final MesBuildingMachinePartSchedulingLinkMonthBiz machinePartSchedulingLinkMonthBiz
   ) {
      this.service = service;
      this.needMachinePartSchedulingBiz = needMachinePartSchedulingBiz;
      this.needMachinePartSchedulingLinkBiz = needMachinePartSchedulingLinkBiz;
      this.taskNeedMachinePartSchedulingBiz = taskNeedMachinePartSchedulingBiz;
      this.taskBiz = taskBiz;
      this.artifactMachinePartLinkService = artifactMachinePartLinkService;
      this.assembleMachinePartLinkService = assembleMachinePartLinkService;
      this.assembleTypesettingPartLinkService = assembleTypesettingPartLinkService;
      this.artifactTaskLinkService = artifactTaskLinkService;
      this.machinePartService = machinePartService;
      this.machinePartSchedulingLinkMonthBiz = machinePartSchedulingLinkMonthBiz;
   }
}
