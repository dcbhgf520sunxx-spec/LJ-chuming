package com.hzchum.scim.mes.building.core.biz.impl.task;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingArtifactTaskBiz;
import com.hzchum.scim.mes.building.core.api.enums.onecode.OneCodeTaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.warehouse.WarehouseRecordStatusTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel._package.MesBuildingPackageNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoListProductNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingComplete;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseRecord;
import com.hzchum.scim.mes.building.core.api.service._package.MesBuildingPackageNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListProductNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import com.hzchum.scim.mes.building.core.mapper.task.MesBuildingTaskMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactExt;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactStatusQHSEDTO;
import com.hzchum.scim.plan.core.api.service.TechArtifactExtService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingArtifactTaskBizImpl extends ServiceImpl<MesBuildingTaskMapper, MesBuildingTask> implements MesBuildingArtifactTaskBiz {
   @Autowired
   private MesBuildingTaskNumberLinkService mesBuildingTaskNumberLinkService;
   @Autowired
   private TechArtifactExtService artifactExtService;
   @Autowired
   private MesBuildingPackageNumberLinkService packageNumberLinkService;
   @Autowired
   private MesBuildingCargoListProductNumberLinkService cargoListProductNumberLinkService;
   @Autowired
   private TechArtifactService artifactService;
   @Autowired
   private MesBuildingProcessService processService;
   @Autowired
   private MesBuildingTaskProcessService taskProcessService;
   @Autowired
   private MesBuildingProduceTeamReportService produceTeamReportService;
   @Autowired
   private MesBuildingCompleteService completeService;
   @Autowired
   private MesBuildingTaskService taskService;
   @Autowired
   private MesBuildingWarehouseRecordService warehouseRecordService;

   @Override
   public List<ArtifactStatusQHSEDTO> listArtifactQHSEStatus(Long artifactId) {
      TechArtifact techArtifact = this.artifactService.getById(artifactId);
      List<TechArtifactExt> artifactExtList = this.artifactExtService
         .list(Wrappers.lambdaQuery(TechArtifactExt.class).eq(TechArtifactExt::getArtifactId, artifactId));
      List<Integer> schedulingNumbers = artifactExtList.stream()
         .filter(TechArtifactExt::getBoolScheduling)
         .filter(s -> !s.getBoolTask())
         .map(TechArtifactExt::getSortNumber)
         .collect(Collectors.toList());
      List<TechArtifactExt> taskNumbers = artifactExtList.stream().filter(TechArtifactExt::getBoolTask).collect(Collectors.toList());
      Map<Long, MesBuildingProcess> processMap = this.processService.list().stream().collect(Collectors.toMap(MesBuildingProcess::getId, Function.identity()));
      Map<Long, MesBuildingTaskProcess> taskProcessMap = this.taskProcessService
         .list(
            Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
               .eq(MesBuildingTaskProcess::getProductId, artifactId)
               .eq(MesBuildingTaskProcess::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
         )
         .stream()
         .collect(Collectors.toMap(MesBuildingTaskProcess::getId, Function.identity()));
      Map<Integer, MesBuildingTaskNumberLink> taskNumberLinkMap = new HashMap<>();
      Map<Integer, List<MesBuildingProduceTeamReport>> reportMap = new HashMap<>();
      Map<Integer, MesBuildingComplete> completeMap = new HashMap<>();
      Map<Integer, MesBuildingPackageNumberLink> packageNumberLinkMap = new HashMap<>();
      Map<Integer, MesBuildingCargoListProductNumberLink> cargoNumberLinkMap = new HashMap<>();
      if (CollectionUtils.isNotEmpty(taskNumbers)) {
         List<Integer> numbers = taskNumbers.stream().map(TechArtifactExt::getSortNumber).collect(Collectors.toList());
         List<MesBuildingTaskNumberLink> numberLinks = this.mesBuildingTaskNumberLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingTaskNumberLink.class)
                  .eq(MesBuildingTaskNumberLink::getArtifactId, artifactId)
                  .in(MesBuildingTaskNumberLink::getArtifactNumber, numbers)
            );
         taskNumberLinkMap = numberLinks.stream().collect(Collectors.toMap(MesBuildingTaskNumberLink::getArtifactNumber, Function.identity(), (s1, s2) -> s1));
         List<MesBuildingProduceTeamReport> reports = this.produceTeamReportService
            .list(
               Wrappers.lambdaQuery(MesBuildingProduceTeamReport.class)
                  .eq(MesBuildingProduceTeamReport::getProductId, artifactId)
                  .in(MesBuildingProduceTeamReport::getNumber, numbers)
                  .eq(MesBuildingProduceTeamReport::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
            );
         reportMap = reports.stream().collect(Collectors.groupingBy(MesBuildingProduceTeamReport::getNumber));
         List<MesBuildingComplete> completeList = this.completeService
            .list(
               Wrappers.lambdaQuery(MesBuildingComplete.class)
                  .eq(MesBuildingComplete::getProductId, artifactId)
                  .in(MesBuildingComplete::getNumber, numbers)
                  .eq(MesBuildingComplete::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
            );
         completeMap = completeList.stream().collect(Collectors.toMap(MesBuildingComplete::getNumber, Function.identity()));
         List<MesBuildingPackageNumberLink> packageList = this.packageNumberLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingPackageNumberLink.class)
                  .eq(MesBuildingPackageNumberLink::getProductId, artifactId)
                  .eq(MesBuildingPackageNumberLink::getProductType, TaskTypeEnum.ARTIFACT.getType())
                  .in(MesBuildingPackageNumberLink::getNumber, numbers)
            );
         packageNumberLinkMap = packageList.stream().collect(Collectors.toMap(MesBuildingPackageNumberLink::getNumber, Function.identity()));
         List<MesBuildingCargoListProductNumberLink> cargoLinks = this.cargoListProductNumberLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingCargoListProductNumberLink.class)
                  .eq(MesBuildingCargoListProductNumberLink::getProductId, artifactId)
                  .eq(MesBuildingCargoListProductNumberLink::getProductType, TaskTypeEnum.ARTIFACT.getType())
                  .eq(MesBuildingCargoListProductNumberLink::getBoolCancelShip, false)
                  .in(MesBuildingCargoListProductNumberLink::getNumber, numbers)
            );
         cargoNumberLinkMap = cargoLinks.stream().collect(Collectors.toMap(MesBuildingCargoListProductNumberLink::getNumber, Function.identity()));
      }

      List<ArtifactStatusQHSEDTO> dtos = new ArrayList<>();

      for (TechArtifactExt ext : artifactExtList) {
         Integer number = ext.getSortNumber();
         ArtifactStatusQHSEDTO build = ArtifactStatusQHSEDTO.builder().productId(artifactId).number(number).build();
         if (!ext.getBoolScheduling()) {
            build.setProcessName(OneCodeTaskTypeEnum.UN_SCHEDULING.getName());
            build.setBoolCargo(Boolean.FALSE);
         } else if (schedulingNumbers.contains(number)) {
            build.setProcessName(OneCodeTaskTypeEnum.UN_TASK.getName());
            build.setBoolCargo(Boolean.FALSE);
         } else {
            MesBuildingTaskNumberLink numberLink = taskNumberLinkMap.get(number);
            if (cargoNumberLinkMap.containsKey(number)) {
               build.setProcessName(OneCodeTaskTypeEnum.CARGOLIST.getName());
               build.setBoolCargo(Boolean.TRUE);
            } else if (packageNumberLinkMap.containsKey(number)) {
               build.setProcessName(OneCodeTaskTypeEnum.PACKAGE.getName());
               build.setBoolCargo(Boolean.TRUE);
            } else if (completeMap.containsKey(number)) {
               build.setProcessName(OneCodeTaskTypeEnum.COMPLETE.getName());
               build.setBoolCargo(Boolean.FALSE);
               build.setTaskId(completeMap.get(number).getTaskId());
            } else if (techArtifact.getBoolAllPartSendDirectly()) {
               build.setProcessName(OneCodeTaskTypeEnum.ALL_SEND_DIRECTLY.getName());
               build.setBoolCargo(Boolean.FALSE);
            } else if (numberLink.getBoolArtifactReport()) {
               List<MesBuildingProduceTeamReport> reports = reportMap.get(number);
               List<MesBuildingProduceTeamReport> needreports = reports.stream()
                  .filter(s -> s.getTaskProcessId().equals(numberLink.getArtifactTaskProcessId()))
                  .collect(Collectors.toList());
               if (CollectionUtils.isNotEmpty(needreports)) {
                  MesBuildingProduceTeamReport report = needreports.get(0);
                  build.setProcessId(report.getProcessId());
                  build.setTaskId(report.getTaskId());
                  build.setProcessName(processMap.get(report.getProcessId()).getName());
               }

               build.setBoolCargo(Boolean.FALSE);
            } else {
               MesBuildingTaskProcess taskProcess = taskProcessMap.get(numberLink.getArtifactTaskProcessId());
               build.setProcessId(taskProcess.getProcessId());
               build.setProcessName(processMap.get(taskProcess.getProcessId()).getName());
               build.setBoolCargo(Boolean.FALSE);
               build.setTaskId(taskProcess.getTaskId());
            }
         }

         if (!build.getBoolCargo() && null != build.getTaskId() || completeMap.containsKey(number) && null != build.getTaskId()) {
            dtos.add(build);
         }
      }

      return dtos;
   }

   @Override
   public List<ArtifactStatusQHSEDTO> listArtifactCompanyQHSEStatus(Long artifactId) {
      TechArtifact techArtifact = this.artifactService.getById(artifactId);
      List<MesBuildingComplete> completes = this.completeService
         .list(
            (Wrapper<MesBuildingComplete>)((new LambdaQueryWrapper<MesBuildingComplete>().eq(MesBuildingComplete::getProductId, artifactId))
                  .eq(MesBuildingComplete::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType()))
               .eq(MesBuildingComplete::getBoolSpotCheck, Boolean.FALSE)
         );
      if (CollectionUtils.isEmpty(completes)) {
         return null;
      }

      Map<Long, List<MesBuildingComplete>> taskCompleteMap = completes.stream().collect(Collectors.groupingBy(MesBuildingComplete::getTaskId));
      List<MesBuildingWarehouseRecord> recordList = this.warehouseRecordService
         .list(
            (Wrapper<MesBuildingWarehouseRecord>)((new LambdaQueryWrapper<MesBuildingWarehouseRecord>()
                     .in(MesBuildingWarehouseRecord::getCompleteId, completes.stream().map(MesBuildingComplete::getId).collect(Collectors.toList())))
                  .eq(MesBuildingWarehouseRecord::getType, 1))
               .eq(MesBuildingWarehouseRecord::getProductId, artifactId)
         );
      Map<Long, MesBuildingWarehouseRecord> warehouseRecordMap = recordList.stream()
         .collect(Collectors.toMap(MesBuildingWarehouseRecord::getCompleteId, Function.identity()));
      Map<Long, MesBuildingTask> taskMap = this.taskService
         .listByIds(completes.stream().map(MesBuildingComplete::getTaskId).collect(Collectors.toList()))
         .stream()
         .collect(Collectors.toMap(MesBuildingTask::getId, Function.identity()));
      List<ArtifactStatusQHSEDTO> artifactStatusQHSEDTOS = new ArrayList<>();
      taskCompleteMap.forEach(
         (taskId, completeList) -> {
            MesBuildingTask task = taskMap.get(taskId);
            if (task.getBoolOneCode()) {
               for (MesBuildingComplete complete : completeList) {
                  MesBuildingWarehouseRecord record = warehouseRecordMap.get(complete.getId());
                  ArtifactStatusQHSEDTO build = ArtifactStatusQHSEDTO.builder()
                     .productId(artifactId)
                     .number(complete.getNumber())
                     .taskId(task.getId())
                     .quantity(1)
                     .boolOneCode(Boolean.TRUE)
                     .build();
                  build.setBoolCargo(Boolean.TRUE);
                  if (record.getStatus().equals(WarehouseRecordStatusTypeEnum.INTO.getType())
                     || record.getStatus().equals(WarehouseRecordStatusTypeEnum.PACKAGING.getType())) {
                     build.setBoolCargo(Boolean.FALSE);
                  }

                  if (!build.getBoolCargo()) {
                     build.setProcessName("完成");
                     artifactStatusQHSEDTOS.add(build);
                  }
               }
            } else {
               List<MesBuildingComplete> collect = completeList.stream()
                  .filter(
                     e -> warehouseRecordMap.get(e.getId()).getStatus().equals(WarehouseRecordStatusTypeEnum.INTO.getType())
                        || warehouseRecordMap.get(e.getId()).getStatus().equals(WarehouseRecordStatusTypeEnum.PACKAGING.getType())
                  )
                  .collect(Collectors.toList());
               if (CollectionUtils.isNotEmpty(collect)) {
                  ArtifactStatusQHSEDTO build = ArtifactStatusQHSEDTO.builder()
                     .productId(artifactId)
                     .taskId(task.getId())
                     .quantity(collect.stream().mapToInt(MesBuildingComplete::getQuantity).sum())
                     .boolOneCode(Boolean.TRUE)
                     .processName("完成")
                     .build();
                  artifactStatusQHSEDTOS.add(build);
               }
            }
         }
      );
      return artifactStatusQHSEDTOS;
   }
}
