package com.hzchum.scim.mes.building.core.maneger;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingProductionLineBiz;
import com.hzchum.scim.mes.building.core.api.enums.onecode.OneCodeTaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.manager.MesBuildingTaskManager;
import com.hzchum.scim.mes.building.core.api.pojo._doModel._package.MesBuildingPackageNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.cargoList.MesBuildingCargoListProductNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingComplete;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskNumberLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesProcessTeamProductionLineListDTO;
import com.hzchum.scim.mes.building.core.api.service._package.MesBuildingPackageNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListProductNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactExt;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactStatusDTO;
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
public class MesBuildingTaskManagerImpl implements MesBuildingTaskManager {
   @Autowired
   private MesBuildingTeamService teamService;
   @Autowired
   private MesBuildingProcessService processService;
   @Autowired
   private MesBuildingTaskProcessService taskProcessService;
   @Autowired
   private MesBuildingProduceTeamReportService produceTeamReportService;
   @Autowired
   private MesBuildingCompleteService completeService;
   @Autowired
   private MesBuildingProductionLineBiz productionLineBiz;
   @Autowired
   private MesBuildingPackageNumberLinkService packageNumberLinkService;
   @Autowired
   private MesBuildingCargoListProductNumberLinkService cargoListProductNumberLinkService;
   @Autowired
   private MesBuildingTaskNumberLinkService mesBuildingTaskNumberLinkService;

   @Override
   public List<ArtifactStatusDTO> listBatchArtifactStatus(Map<Long, TechArtifact> artifactMap, Map<Long, List<TechArtifactExt>> artifactExtMap) {
      List<ArtifactStatusDTO> dtos = new ArrayList<>();
      List<MesProcessTeamProductionLineListDTO> processTeamProductionLineListDTOS = this.teamService.listProductionLineTrees(null, null);
      Map<Long, List<MesProcessTeamProductionLineListDTO>> processTeamProductionLineListMap = processTeamProductionLineListDTOS.stream()
         .collect(Collectors.groupingBy(MesProcessTeamProductionLineListDTO::getLineId));
      Map<Long, String> teamLeaderNameMap = processTeamProductionLineListDTOS.stream()
         .collect(Collectors.toMap(MesProcessTeamProductionLineListDTO::getTeamId, MesProcessTeamProductionLineListDTO::getLeaderName, (s1, s2) -> s1));
      Map<Long, MesBuildingProductionLine> productionLineMap = this.productionLineBiz
         .list()
         .stream()
         .collect(Collectors.toMap(MesBuildingProductionLine::getId, Function.identity()));
      Map<Long, MesBuildingProcess> processMap = this.processService.list().stream().collect(Collectors.toMap(MesBuildingProcess::getId, Function.identity()));
      Map<Long, MesBuildingTaskProcess> taskProcessMap = this.taskProcessService
         .list(
            Wrappers.lambdaQuery(MesBuildingTaskProcess.class)
               .in(MesBuildingTaskProcess::getProductId, artifactMap.keySet())
               .eq(MesBuildingTaskProcess::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
         )
         .stream()
         .collect(Collectors.toMap(MesBuildingTaskProcess::getId, Function.identity()));
      Map<Long, List<MesBuildingTaskNumberLink>> artifactIdAndTaskNumberLinkMap = new HashMap<>();
      Map<Long, List<MesBuildingProduceTeamReport>> produceTeamReportMap = new HashMap<>();
      Map<Long, List<MesBuildingComplete>> allCompleteMap = new HashMap<>();
      Map<Long, List<MesBuildingPackageNumberLink>> allPackageNumberLinkMap = new HashMap<>();
      Map<Long, List<MesBuildingCargoListProductNumberLink>> allCargoListProductNumberLinkMap = new HashMap<>();
      List<MesBuildingTaskNumberLink> mesBuildingTaskNumberLinks = this.mesBuildingTaskNumberLinkService
         .list((Wrapper<MesBuildingTaskNumberLink>)new LambdaQueryWrapper<MesBuildingTaskNumberLink>().in(MesBuildingTaskNumberLink::getArtifactId, artifactMap.keySet()));
      if (CollectionUtils.isNotEmpty(mesBuildingTaskNumberLinks)) {
         artifactIdAndTaskNumberLinkMap = mesBuildingTaskNumberLinks.stream().collect(Collectors.groupingBy(MesBuildingTaskNumberLink::getArtifactId));
      }

      List<MesBuildingProduceTeamReport> produceTeamReportList = this.produceTeamReportService
         .list(
            (Wrapper<MesBuildingProduceTeamReport>)(new LambdaQueryWrapper<MesBuildingProduceTeamReport>()
                  .in(MesBuildingProduceTeamReport::getProductId, artifactMap.keySet()))
               .eq(MesBuildingProduceTeamReport::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
         );
      if (CollectionUtils.isNotEmpty(produceTeamReportList)) {
         produceTeamReportMap = produceTeamReportList.stream().collect(Collectors.groupingBy(MesBuildingProduceTeamReport::getProductId));
      }

      List<MesBuildingComplete> allCompleteList = this.completeService
         .list(
            (Wrapper<MesBuildingComplete>)(new LambdaQueryWrapper<MesBuildingComplete>().in(MesBuildingComplete::getProductId, artifactMap.keySet()))
               .eq(MesBuildingComplete::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
         );
      if (CollectionUtils.isNotEmpty(allCompleteList)) {
         allCompleteMap = allCompleteList.stream().collect(Collectors.groupingBy(MesBuildingComplete::getProductId));
      }

      List<MesBuildingPackageNumberLink> allPackageNumberLinkList = this.packageNumberLinkService
         .list(
            (Wrapper<MesBuildingPackageNumberLink>)(new LambdaQueryWrapper<MesBuildingPackageNumberLink>()
                  .in(MesBuildingPackageNumberLink::getProductId, artifactMap.keySet()))
               .eq(MesBuildingPackageNumberLink::getProductType, TaskTypeEnum.ARTIFACT.getType())
         );
      if (CollectionUtils.isNotEmpty(allPackageNumberLinkList)) {
         allPackageNumberLinkMap = allPackageNumberLinkList.stream().collect(Collectors.groupingBy(MesBuildingPackageNumberLink::getProductId));
      }

      List<MesBuildingCargoListProductNumberLink> allCargoListProductNumberLinkList = this.cargoListProductNumberLinkService
         .list(
            (Wrapper<MesBuildingCargoListProductNumberLink>)((new LambdaQueryWrapper<MesBuildingCargoListProductNumberLink>()
                     .in(MesBuildingCargoListProductNumberLink::getProductId, artifactMap.keySet()))
                  .eq(MesBuildingCargoListProductNumberLink::getProductType, TaskTypeEnum.ARTIFACT.getType()))
               .eq(MesBuildingCargoListProductNumberLink::getBoolCancelShip, Boolean.FALSE)
         );
      if (CollectionUtils.isNotEmpty(allCargoListProductNumberLinkList)) {
         allCargoListProductNumberLinkMap = allCargoListProductNumberLinkList.stream()
            .collect(Collectors.groupingBy(MesBuildingCargoListProductNumberLink::getProductId));
      }

      Map<Long, List<MesBuildingTaskNumberLink>> finalArtifactIdAndTaskNumberLinkMap = artifactIdAndTaskNumberLinkMap;
      Map<Long, List<MesBuildingProduceTeamReport>> finalProduceTeamReportMap = produceTeamReportMap;
      Map<Long, List<MesBuildingComplete>> finalAllCompleteMap = allCompleteMap;
      Map<Long, List<MesBuildingPackageNumberLink>> finalAllPackageNumberLinkMap = allPackageNumberLinkMap;
      Map<Long, List<MesBuildingCargoListProductNumberLink>> finalAllCargoListProductNumberLinkMap = allCargoListProductNumberLinkMap;
      artifactMap.forEach(
         (artifactId, artifact) -> {
            List<TechArtifactExt> artifactExtList = artifactExtMap.get(artifactId);
            List<Integer> schedulingNumbers = artifactExtList.stream()
               .filter(TechArtifactExt::getBoolScheduling)
               .filter(s -> !s.getBoolTask())
               .map(TechArtifactExt::getSortNumber)
               .collect(Collectors.toList());
            List<TechArtifactExt> taskNumbers = artifactExtList.stream().filter(TechArtifactExt::getBoolTask).collect(Collectors.toList());
            Map<Integer, MesBuildingTaskNumberLink> taskNumberLinkMap = new HashMap<>();
            Map<Integer, List<MesBuildingProduceTeamReport>> reportMap = new HashMap<>();
            Map<Integer, MesBuildingComplete> completeMap = new HashMap<>();
            Map<Integer, MesBuildingPackageNumberLink> packageNumberLinkMap = new HashMap<>();
            Map<Integer, MesBuildingCargoListProductNumberLink> cargoNumberLinkMap = new HashMap<>();
            if (CollectionUtils.isNotEmpty(taskNumbers)) {
               List<Integer> numbers = taskNumbers.stream().map(TechArtifactExt::getSortNumber).collect(Collectors.toList());
               List<MesBuildingTaskNumberLink> numberLinks = finalArtifactIdAndTaskNumberLinkMap.getOrDefault(artifactId, new ArrayList<>())
                  .stream()
                  .filter(e -> numbers.contains(e.getArtifactNumber()))
                  .collect(Collectors.toList());
               taskNumberLinkMap = numberLinks.stream()
                  .collect(Collectors.toMap(MesBuildingTaskNumberLink::getArtifactNumber, Function.identity(), (s1, s2) -> s1));
               List<MesBuildingProduceTeamReport> reports = finalProduceTeamReportMap.getOrDefault(artifactId, new ArrayList<>())
                  .stream()
                  .filter(e -> numbers.contains(e.getNumber()))
                  .collect(Collectors.toList());
               reportMap = reports.stream().collect(Collectors.groupingBy(MesBuildingProduceTeamReport::getNumber));
               List<MesBuildingComplete> completeList = finalAllCompleteMap.getOrDefault(artifactId, new ArrayList<>())
                  .stream()
                  .filter(e -> numbers.contains(e.getNumber()))
                  .collect(Collectors.toList());
               completeMap = completeList.stream().collect(Collectors.toMap(MesBuildingComplete::getNumber, Function.identity()));
               List<MesBuildingPackageNumberLink> packageList = finalAllPackageNumberLinkMap.getOrDefault(artifactId, new ArrayList<>())
                  .stream()
                  .filter(e -> numbers.contains(e.getNumber()))
                  .collect(Collectors.toList());
               packageNumberLinkMap = packageList.stream().collect(Collectors.toMap(MesBuildingPackageNumberLink::getNumber, Function.identity()));
               List<MesBuildingCargoListProductNumberLink> cargoLinks = finalAllCargoListProductNumberLinkMap.getOrDefault(artifactId, new ArrayList<>())
                  .stream()
                  .filter(e -> numbers.contains(e.getNumber()))
                  .collect(Collectors.toList());
               cargoNumberLinkMap = cargoLinks.stream().collect(Collectors.toMap(MesBuildingCargoListProductNumberLink::getNumber, Function.identity()));
            }

            for (TechArtifactExt ext : artifactExtList) {
               Integer number = ext.getSortNumber();
               ArtifactStatusDTO build = ArtifactStatusDTO.builder().productId(artifactId).number(number).build();
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
                  } else if (artifactMap.get(ext.getArtifactId()).getBoolAllPartSendDirectly()) {
                     build.setProcessName(OneCodeTaskTypeEnum.ALL_SEND_DIRECTLY.getName());
                     build.setBoolCargo(Boolean.FALSE);
                  } else if (numberLink.getBoolArtifactReport()) {
                     List<MesBuildingProduceTeamReport> reports = reportMap.get(number);
                     List<MesBuildingProduceTeamReport> needreports = reports.stream()
                        .filter(s -> s.getTaskProcessId().equals(numberLink.getArtifactTaskProcessId()))
                        .collect(Collectors.toList());
                     if (CollectionUtils.isNotEmpty(needreports)) {
                        MesBuildingProduceTeamReport report = needreports.get(0);
                        String leaderName = teamLeaderNameMap.get(report.getTeamId());
                        String groupName = productionLineMap.get(report.getProductionLineId()).getName();
                        build.setGroupId(report.getProductionLineId());
                        build.setGroupName(groupName);
                        build.setTeamId(report.getTeamId());
                        build.setLeaderName(leaderName);
                        build.setProcessId(report.getProcessId());
                        build.setTaskId(report.getTaskId());
                        build.setProcessName(processMap.get(report.getProcessId()).getName());
                        build.setLineName(groupName);
                     }

                     build.setBoolCargo(Boolean.FALSE);
                  } else {
                     MesBuildingTaskProcess taskProcess = taskProcessMap.get(numberLink.getArtifactTaskProcessId());
                     MesBuildingProductionLine line = productionLineMap.get(taskProcess.getProductionLineId());
                     build.setGroupId(taskProcess.getProductionLineId());
                     build.setGroupName(line.getName());
                     build.setLineId(taskProcess.getProductionLineId());
                     build.setLineName(line.getName());
                     String key = taskProcess.getTeamId() + "_" + taskProcess.getProcessId();
                     Map<String, MesProcessTeamProductionLineListDTO> teamProductionLineListDTOMap = processTeamProductionLineListMap.get(
                           taskProcess.getProductionLineId()
                        )
                        .stream()
                        .collect(Collectors.toMap(e -> e.getTeamId() + "-" + e.getProcessId(), Function.identity()));
                     MesProcessTeamProductionLineListDTO teamProductionLineListDTO = teamProductionLineListDTOMap.get(key);
                     if (teamProductionLineListDTO != null) {
                        build.setTeamId(teamProductionLineListDTO.getTeamId());
                        build.setLeaderName(teamProductionLineListDTO.getLeaderName());
                     }

                     build.setProcessId(taskProcess.getProcessId());
                     build.setTaskId(taskProcess.getTaskId());
                     build.setProcessName(processMap.get(taskProcess.getProcessId()).getName());
                     build.setLineName(line.getName());
                     build.setBoolCargo(Boolean.FALSE);
                  }
               }

               dtos.add(build);
            }
         }
      );
      return dtos;
   }
}
