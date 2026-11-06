package com.hzchum.scim.mes.building.core.biz.impl.largesreen;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hzchum.scim.common.core.api.enums.SteelPlateTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.largesreen.CompleteLargeScreenService;
import com.hzchum.scim.mes.building.core.api.enums.DateQueryTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.ArtifactCompleteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.DateAndMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.NetWeightAndQuantityDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.UnfinishedTaskDTO;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceInspectionTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNumberLinkService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskOrderService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactMachinePartLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleDetail;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.TechArtifactMachinePartLinkService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleDetailService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompleteLargeScreenServiceImpl implements CompleteLargeScreenService {
   @Resource
   private MesBuildingTaskProcessService mesBuildingTaskProcessService;
   @Resource
   private TechArtifactService techArtifactService;
   @Autowired
   private MesBuildingCompleteService completeService;
   @Autowired
   private MesBuildingTaskOrderService mesBuildingTaskOrderService;
   @Autowired
   private ContractProjectService contractProjectService;
   @Autowired
   private MesBuildingTaskService mesBuildingTaskService;
   @Autowired
   private MesBuildingProcessService processService;
   @Autowired
   private TechArtifactMachinePartLinkService techArtifactMachinePartLinkService;
   @Autowired
   private TechAssembleDetailService techAssembleDetailService;
   @Resource
   private TechMachinePartService techMachinePartService;
   @Resource
   private TechAssembleService techAssembleService;
   @Resource
   private MesBuildingTaskNumberLinkService mesBuildingTaskNumberLinkService;
   @Resource
   private MesBuildingQhseService mesBuildingQhseService;
   @Resource
   private MesBuildingProduceInspectionTeamReportService mesBuildingProduceInspectionTeamReportService;
   private static final BigDecimal ONE_HUNDRED = new BigDecimal(100);
   private static final BigDecimal THOUSAND = new BigDecimal(1000);
   private static final BigDecimal TEN_THOUSAND = new BigDecimal(10000);

   @Override
   public Map<String, BigDecimal> statistics(Long factoryId, Long workshopId, Long teamId, String processName) {
      Map<String, BigDecimal> map = new HashMap<>();
      List<Long> processIdList = this.processService
         .lambdaQuery()
         .in(MesBuildingProcess::getName, StrUtil.splitTrim(processName, ","))
         .list()
         .stream()
         .map(MesBuildingProcess::getId)
         .distinct()
         .collect(Collectors.toList());
      List<MesBuildingTaskProcess> mesBuildingTaskProcesses = this.mesBuildingTaskProcessService
         .lambdaQuery()
         .eq(workshopId != null, MesBuildingTaskProcess::getWorkshopId, workshopId)
         .eq(teamId != null, MesBuildingTaskProcess::getTeamId, teamId)
         .eq(MesBuildingTaskProcess::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
         .isNull(MesBuildingTaskProcess::getCompleteTime)
         .in(MesBuildingTaskProcess::getProcessId, processIdList)
         .list();
      List<MesBuildingTaskProcess> filterMesBuildingTaskProcesses = mesBuildingTaskProcesses.stream()
         .filter(m -> m.getNeedQuantity() - m.getCompleteQuantity() > 0)
         .collect(Collectors.toList());
      if (CollectionUtil.isEmpty(filterMesBuildingTaskProcesses)) {
         map.put("在手任务", BigDecimal.ZERO);
      } else {
         for (MesBuildingTaskProcess filterMesBuildingTaskProcess : filterMesBuildingTaskProcesses) {
            TechArtifact techArtifact = this.techArtifactService.getById(filterMesBuildingTaskProcess.getProductId());
            map.put(
               "在手任务",
               new BigDecimal(filterMesBuildingTaskProcess.getNeedQuantity() - filterMesBuildingTaskProcess.getCompleteQuantity())
                  .multiply(techArtifact.getNetWeight())
                  .divide(THOUSAND, 4, 4)
            );
         }
      }

      BigDecimal yearAccumulatedCompleteMete = this.completeService
         .getYearAccumulatedCompleteMete(DateQueryTypeEnum.YEAR.getTypeEn(), workshopId, teamId)
         .setScale(2, RoundingMode.HALF_UP);
      map.put("当年产量", yearAccumulatedCompleteMete);
      BigDecimal thisMonthCompleteMete = this.completeService
         .getYearAccumulatedCompleteMete(DateQueryTypeEnum.MONTH.getTypeEn(), workshopId, teamId)
         .setScale(2, RoundingMode.HALF_UP);
      map.put("本月产量", thisMonthCompleteMete);
      BigDecimal thisWeekCompleteMete = this.completeService
         .getYearAccumulatedCompleteMete(DateQueryTypeEnum.WEEK.getTypeEn(), workshopId, teamId)
         .setScale(2, RoundingMode.HALF_UP);
      map.put("本周产量", thisWeekCompleteMete);
      LocalDateTime now = LocalDateTime.now();
      int monthValue = now.getMonthValue();
      BigDecimal monthlyAverageCompleteMete = yearAccumulatedCompleteMete.divide(new BigDecimal(monthValue), 2, RoundingMode.HALF_UP);
      map.put("月度平均产能", monthlyAverageCompleteMete);
      if (CollectionUtil.isNotEmpty(mesBuildingTaskProcesses)) {
         List<Long> artifactIds = mesBuildingTaskProcesses.stream().map(MesBuildingTaskProcess::getProductId).collect(Collectors.toList());
         Map<Long, TechArtifact> artifactMap = this.techArtifactService
            .lambdaQuery()
            .in(TechArtifact::getId, artifactIds)
            .list()
            .stream()
            .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
         List<TechArtifactMachinePartLink> techArtifactMachinePartLinks = this.techArtifactMachinePartLinkService
            .lambdaQuery()
            .in(TechArtifactMachinePartLink::getArtifactId, artifactIds)
            .list();
         List<TechMachinePart> techMachineParts = CollectionUtil.isNotEmpty(techArtifactMachinePartLinks)
            ? this.techMachinePartService
               .lambdaQuery()
               .in(
                  TechMachinePart::getId, techArtifactMachinePartLinks.stream().map(TechArtifactMachinePartLink::getMachinePartId).collect(Collectors.toList())
               )
               .list()
            : new ArrayList<>();
         List<TechAssembleDetail> techAssembleDetails = this.techAssembleDetailService.lambdaQuery().in(TechAssembleDetail::getArtifactId, artifactIds).list();
         List<TechAssemble> techAssembles = CollectionUtil.isNotEmpty(techAssembleDetails)
            ? this.techAssembleService
               .lambdaQuery()
               .in(TechAssemble::getId, techAssembleDetails.stream().map(TechAssembleDetail::getAssembleId).collect(Collectors.toList()))
               .list()
            : new ArrayList<>();
         NetWeightAndQuantityDTO completeQuantity = this.getCompleteQuantity(
            mesBuildingTaskProcesses, techArtifactMachinePartLinks, techMachineParts, techAssembleDetails, techAssembles, artifactMap
         );
         map.put("齐套重量", completeQuantity.getWeight().divide(THOUSAND, 2, RoundingMode.HALF_UP));
         map.put("齐套数量", new BigDecimal(completeQuantity.getQuantity()));
      } else {
         map.put("齐套重量", BigDecimal.ZERO);
         map.put("齐套数量", BigDecimal.ZERO);
      }

      Integer problemQuantity = this.mesBuildingQhseService.getProblemQuantity(workshopId, teamId);
      Integer inspectionQuantity = this.mesBuildingProduceInspectionTeamReportService.getInspectionQuantity(workshopId, teamId);
      BigDecimal ratio = BigDecimal.ZERO;
      if (inspectionQuantity != 0) {
         ratio = BigDecimal.valueOf(problemQuantity.intValue())
            .divide(BigDecimal.valueOf(inspectionQuantity.intValue()), 4, RoundingMode.HALF_UP)
            .multiply(BigDecimal.valueOf(100L));
      }

      map.put("一次质检合格率", new BigDecimal(100).subtract(ratio));
      return map;
   }

   @Override
   public List<DateAndMeteDTO> monthlyOutput(Long factoryId, Long workshopId, Long teamId, String processName) {
      Year year = Year.now();
      DateTimeFormatter yyyyMM = DateTimeFormatter.ofPattern("yyyy-MM");
      List<String> monthStrList = new ArrayList<>();

      for (int i = 1; i <= 12; i++) {
         String format = yyyyMM.format(year.atMonth(i));
         monthStrList.add(format);
      }

      Map<String, DateAndMeteDTO> dateAndMeteDTOMap = this.completeService
         .getAccumulatedCompleteMeteByDate(monthStrList, DateQueryTypeEnum.MONTH.getFormat(), null, workshopId, teamId)
         .stream()
         .collect(Collectors.toMap(DateAndMeteDTO::getDateStr, t -> (DateAndMeteDTO)t));
      BigDecimal sumMete = new BigDecimal(0);
      List<DateAndMeteDTO> dateAndMeteDTOS = new ArrayList<>();

      for (String m : monthStrList) {
         DateAndMeteDTO dateAndMeteDTO = dateAndMeteDTOMap.get(m);
         if (dateAndMeteDTO == null) {
            dateAndMeteDTO = new DateAndMeteDTO();
            dateAndMeteDTO.setDateStr(m.substring(5, 7) + "月");
            dateAndMeteDTO.setValue(BigDecimal.ZERO);
            dateAndMeteDTOS.add(dateAndMeteDTO);
         } else {
            dateAndMeteDTO.setDateStr(m.substring(5, 7) + "月");
            dateAndMeteDTOS.add(dateAndMeteDTO);
         }

         sumMete = sumMete.add(dateAndMeteDTO.getValue());
      }

      dateAndMeteDTOS.add(DateAndMeteDTO.builder().dateStr("年度累计产量").value(sumMete).build());
      return dateAndMeteDTOS;
   }

   @Override
   public List<UnfinishedTaskDTO> unfinishedTask(Long factoryId, Long workshopId, Long teamId, String processName) {
      MesBuildingProcess pinzhaung = this.processService.lambdaQuery().eq(MesBuildingProcess::getName, processName).one();
      List<MesBuildingTaskProcess> taskProcessList = this.mesBuildingTaskProcessService
         .lambdaQuery()
         .eq(workshopId != null, MesBuildingTaskProcess::getWorkshopId, workshopId)
         .eq(teamId != null, MesBuildingTaskProcess::getTeamId, teamId)
         .eq(MesBuildingTaskProcess::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
         .isNull(MesBuildingTaskProcess::getCompleteTime)
         .eq(MesBuildingTaskProcess::getProcessId, pinzhaung.getId())
         .list();
      if (CollectionUtil.isEmpty(taskProcessList)) {
         return new ArrayList<>();
      }

      List<Long> taskOrderIds = taskProcessList.stream().map(MesBuildingTaskProcess::getTaskOrderId).distinct().collect(Collectors.toList());
      List<MesBuildingTaskOrder> mesBuildingTaskOrders = this.mesBuildingTaskOrderService
         .list(
            (Wrapper<MesBuildingTaskOrder>)((new LambdaQueryWrapper<MesBuildingTaskOrder>().in(MesBuildingTaskOrder::getId, taskOrderIds))
                  .eq(MesBuildingTaskOrder::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType()))
               .isNull(MesBuildingTaskOrder::getCompleteTime)
         );
      if (CollectionUtil.isEmpty(mesBuildingTaskOrders)) {
         return new ArrayList<>();
      }

      List<Long> artifactIds = taskProcessList.stream().map(MesBuildingTaskProcess::getProductId).distinct().collect(Collectors.toList());
      Map<Long, TechArtifact> artifactMap = Optional.of(artifactIds)
         .filter(CollUtil::isNotEmpty)
         .map(this.techArtifactService::listByIds)
         .orElseGet(Collections::emptyList)
         .stream()
         .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      List<TechArtifactMachinePartLink> techArtifactMachinePartLinks = this.techArtifactMachinePartLinkService
         .lambdaQuery()
         .in(TechArtifactMachinePartLink::getArtifactId, artifactIds)
         .list();
      List<Long> machinePartIds = techArtifactMachinePartLinks.stream()
         .map(TechArtifactMachinePartLink::getMachinePartId)
         .distinct()
         .collect(Collectors.toList());
      List<TechMachinePart> techMachineParts = Optional.of(machinePartIds)
         .filter(CollUtil::isNotEmpty)
         .map(this.techMachinePartService::listByIds)
         .orElseGet(Collections::emptyList);
      List<TechAssembleDetail> techAssembleDetails = this.techAssembleDetailService.lambdaQuery().in(TechAssembleDetail::getArtifactId, artifactIds).list();
      List<Long> assembleIds = techAssembleDetails.stream().map(TechAssembleDetail::getAssembleId).distinct().collect(Collectors.toList());
      List<TechAssemble> techAssembles = Optional.of(assembleIds)
         .filter(CollUtil::isNotEmpty)
         .map(this.techAssembleService::listByIds)
         .orElseGet(Collections::emptyList);
      List<Long> projectIds = mesBuildingTaskOrders.stream().map(MesBuildingTaskOrder::getProjectId).distinct().collect(Collectors.toList());
      Map<Long, String> projectMap = this.contractProjectService
         .getSimpleByIds(projectIds)
         .stream()
         .collect(Collectors.toMap(ProjectInfo::getId, ProjectInfo::getName));
      Map<Long, List<MesBuildingTask>> taskOrderIdMap = this.mesBuildingTaskService
         .listByIds(taskOrderIds)
         .stream()
         .collect(Collectors.groupingBy(MesBuildingTask::getTaskOrderId));
      List<UnfinishedTaskDTO> unfinishedTaskDTOS = new ArrayList<>();
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

      for (MesBuildingTaskOrder mesBuildingTaskOrder : mesBuildingTaskOrders) {
         UnfinishedTaskDTO unfinishedTaskDTO = new UnfinishedTaskDTO();
         unfinishedTaskDTO.setDateStr(dateTimeFormatter.format(mesBuildingTaskOrder.getAskCompleteTime()));
         unfinishedTaskDTO.setProject(projectMap.get(mesBuildingTaskOrder.getProjectId()));
         unfinishedTaskDTO.setOrderNumber(mesBuildingTaskOrder.getOrderNumber());
         unfinishedTaskDTO.setTaskOrderId(mesBuildingTaskOrder.getId());
         List<MesBuildingTask> mesBuildingTasks = taskOrderIdMap.get(mesBuildingTaskOrder.getId());
         if (mesBuildingTasks != null) {
            Integer sumTaskQuantity = mesBuildingTaskOrder.getQuantity();
            unfinishedTaskDTO.setTaskQuantity(sumTaskQuantity);
            Integer reduce = mesBuildingTasks != null ? mesBuildingTasks.stream().map(MesBuildingTask::getCompleteQuantity).reduce(0, Integer::sum) : 0;
            unfinishedTaskDTO.setUnfinishedQuantity(sumTaskQuantity - reduce);
            if (sumTaskQuantity != 0) {
               unfinishedTaskDTO.setFinishingRate(
                  new BigDecimal(reduce).divide(new BigDecimal(sumTaskQuantity), 4, RoundingMode.HALF_UP).multiply(new BigDecimal(100))
               );
            } else {
               unfinishedTaskDTO.setFinishingRate(new BigDecimal(0));
            }

            List<MesBuildingTaskProcess> mesBuildingTaskProcesses = taskProcessList.stream()
               .filter(t -> t.getTaskOrderId().equals(mesBuildingTaskOrder.getId()))
               .collect(Collectors.toList());
            NetWeightAndQuantityDTO netWeightAndQuantityDTO = this.getCompleteQuantity(
               mesBuildingTaskProcesses, techArtifactMachinePartLinks, techMachineParts, techAssembleDetails, techAssembles, artifactMap
            );
            unfinishedTaskDTO.setCompleteQuantity(netWeightAndQuantityDTO.getQuantity());
            unfinishedTaskDTOS.add(unfinishedTaskDTO);
         }
      }

      return unfinishedTaskDTOS;
   }

   @Override
   public List<ArtifactCompleteDTO> taskCompleteList(Long factoryId, Long workshopId, Long teamId, Long taskOrderId, String processName) {
      List<Long> processIdList = this.processService
         .lambdaQuery()
         .in(MesBuildingProcess::getName, StrUtil.splitTrim(processName, ","))
         .list()
         .stream()
         .map(MesBuildingProcess::getId)
         .distinct()
         .collect(Collectors.toList());
      List<MesBuildingTaskProcess> taskProcessList = this.mesBuildingTaskProcessService
         .lambdaQuery()
         .eq(workshopId != null, MesBuildingTaskProcess::getWorkshopId, workshopId)
         .eq(teamId != null, MesBuildingTaskProcess::getTeamId, teamId)
         .eq(MesBuildingTaskProcess::getTaskTypeEnum, TaskTypeEnum.ARTIFACT.getType())
         .isNull(MesBuildingTaskProcess::getCompleteTime)
         .in(MesBuildingTaskProcess::getProcessId, processIdList)
         .eq(MesBuildingTaskProcess::getTaskOrderId, taskOrderId)
         .list();
      if (CollectionUtil.isEmpty(taskProcessList)) {
         return new ArrayList<>();
      }

      List<Long> artifactIds = taskProcessList.stream().map(MesBuildingTaskProcess::getProductId).collect(Collectors.toList());
      Map<Long, TechArtifact> artifactMap = this.techArtifactService
         .listByIds(artifactIds)
         .stream()
         .collect(Collectors.toMap(TechArtifact::getId, Function.identity()));
      List<TechArtifactMachinePartLink> techArtifactMachinePartLinks = this.techArtifactMachinePartLinkService
         .lambdaQuery()
         .in(TechArtifactMachinePartLink::getArtifactId, artifactIds)
         .list();
      List<TechMachinePart> techMachineParts = CollectionUtil.isNotEmpty(techArtifactMachinePartLinks)
         ? this.techMachinePartService
            .lambdaQuery()
            .in(TechMachinePart::getId, techArtifactMachinePartLinks.stream().map(TechArtifactMachinePartLink::getMachinePartId).collect(Collectors.toList()))
            .list()
         : new ArrayList<>();
      List<TechAssembleDetail> techAssembleDetails = this.techAssembleDetailService.lambdaQuery().in(TechAssembleDetail::getArtifactId, artifactIds).list();
      List<TechAssemble> techAssembles = CollectionUtil.isNotEmpty(techAssembleDetails)
         ? this.techAssembleService
            .lambdaQuery()
            .in(TechAssemble::getId, techAssembleDetails.stream().map(TechAssembleDetail::getAssembleId).collect(Collectors.toList()))
            .list()
         : new ArrayList<>();
      return this.getCompleteList(taskProcessList, techArtifactMachinePartLinks, techMachineParts, techAssembleDetails, techAssembles, artifactMap);
   }

   private List<ArtifactCompleteDTO> getCompleteList(
      List<MesBuildingTaskProcess> taskProcessList,
      List<TechArtifactMachinePartLink> techArtifactMachinePartLinks,
      List<TechMachinePart> techMachineParts,
      List<TechAssembleDetail> techAssembleDetails,
      List<TechAssemble> techAssembles,
      Map<Long, TechArtifact> artifactMap
   ) {
      Map<Long, ArtifactCompleteDTO> map = new HashMap<>();
      Integer sumNum = 0;
      BigDecimal sumWeight = new BigDecimal(0);

      label73:
      for (MesBuildingTaskProcess mesBuildingTaskProcess : taskProcessList) {
         ArtifactCompleteDTO artifactCompleteDTO = map.get(mesBuildingTaskProcess.getProductId());
         if (artifactCompleteDTO == null) {
            artifactCompleteDTO = new ArtifactCompleteDTO();
            TechArtifact techArtifact = artifactMap.get(mesBuildingTaskProcess.getProductId());
            artifactCompleteDTO.setSerialNumber(techArtifact.getSerialNumber());
            artifactCompleteDTO.setArtifactQuantity(0);
            artifactCompleteDTO.setPartBoardProductionQuantity(0);
            artifactCompleteDTO.setPartBoardNeedQuantity(0);
            artifactCompleteDTO.setWingBoardProductionQuantity(0);
            artifactCompleteDTO.setWingBoardNeedQuantity(0);
            artifactCompleteDTO.setPartProductionQuantity(0);
            artifactCompleteDTO.setPartNeedQuantity(0);
            artifactCompleteDTO.setCompleteQuantity(0);
         }

         int i1 = mesBuildingTaskProcess.getNeedQuantity() - mesBuildingTaskProcess.getInspectionQuantity();
         artifactCompleteDTO.setArtifactQuantity(artifactCompleteDTO.getArtifactQuantity() + i1);
         Integer num = i1;
         List<TechArtifactMachinePartLink> techArtifactMachinePartLinkList = techArtifactMachinePartLinks.stream()
            .filter(t -> t.getArtifactId().equals(mesBuildingTaskProcess.getProductId()))
            .collect(Collectors.toList());
         if (techArtifactMachinePartLinkList != null) {
            for (TechArtifactMachinePartLink techArtifactMachinePartLink : techArtifactMachinePartLinkList) {
               List<TechMachinePart> collect = techMachineParts.stream()
                  .filter(t -> t.getId().equals(techArtifactMachinePartLink.getMachinePartId()))
                  .collect(Collectors.toList());
               Integer reduce = techMachineParts.stream()
                  .filter(t -> t.getId().equals(techArtifactMachinePartLink.getMachinePartId()))
                  .map(t -> t.getProducedQuantity() - t.getUsedQuantity())
                  .reduce(0, Integer::sum);
               int i = reduce / techArtifactMachinePartLink.getQuantity();
               if (i == 0) {
                  continue label73;
               }

               num = Math.min(i, num);
               List<TechMachinePart> collect1 = collect.stream()
                  .filter(c -> c.getSteelPlateTypeEnum().equals(SteelPlateTypeEnum.PRIMARY_MEMBER.getType()))
                  .collect(Collectors.toList());

               for (TechMachinePart techMachinePart : collect1) {
                  artifactCompleteDTO.setPartBoardProductionQuantity(
                     artifactCompleteDTO.getPartBoardProductionQuantity() + techMachinePart.getProducedQuantity() - techMachinePart.getUsedQuantity()
                  );
                  TechArtifactMachinePartLink techArtifactMachinePartLink1 = techArtifactMachinePartLinks.stream()
                     .filter(t -> t.getMachinePartId().equals(techMachinePart.getId()) && t.getArtifactId().equals(mesBuildingTaskProcess.getProductId()))
                     .findAny()
                     .orElse(null);
                  artifactCompleteDTO.setPartBoardNeedQuantity(artifactCompleteDTO.getPartBoardNeedQuantity() + techArtifactMachinePartLink1.getQuantity() * i1);
               }

               for (TechMachinePart techMachinePart : collect1.stream()
                  .filter(c -> c.getSteelPlateTypeEnum().equals(SteelPlateTypeEnum.SECONDARY_MEMBER.getType()))
                  .collect(Collectors.toList())) {
                  artifactCompleteDTO.setWingBoardProductionQuantity(
                     artifactCompleteDTO.getWingBoardProductionQuantity() + techMachinePart.getProducedQuantity() - techMachinePart.getUsedQuantity()
                  );
                  TechArtifactMachinePartLink techArtifactMachinePartLink2 = techArtifactMachinePartLinks.stream()
                     .filter(t -> t.getMachinePartId().equals(techMachinePart.getId()) && t.getArtifactId().equals(mesBuildingTaskProcess.getProductId()))
                     .findAny()
                     .orElse(null);
                  artifactCompleteDTO.setWingBoardNeedQuantity(artifactCompleteDTO.getWingBoardNeedQuantity() + techArtifactMachinePartLink2.getQuantity() * i1);
               }
            }
         }

         List<TechAssembleDetail> techAssembleDetailList = techAssembleDetails.stream()
            .filter(t -> t.getArtifactId().equals(mesBuildingTaskProcess.getProductId()))
            .collect(Collectors.toList());
         if (techAssembleDetailList != null) {
            for (TechAssembleDetail techAssembleDetail : techAssembleDetailList) {
               List<TechAssemble> collect = techAssembles.stream()
                  .filter(t -> t.getId().equals(techAssembleDetail.getAssembleId()))
                  .collect(Collectors.toList());
               Integer reduce = techAssembles.stream()
                  .filter(t -> t.getId().equals(techAssembleDetail.getAssembleId()))
                  .map(t -> t.getProducedQuantity() - t.getUsedQuantity())
                  .reduce(0, Integer::sum);
               int i = reduce / techAssembleDetail.getQuantity();
               if (i == 0) {
                  continue label73;
               }

               num = Math.min(i, num);

               for (TechAssemble techAssemble : collect) {
                  artifactCompleteDTO.setPartProductionQuantity(
                     artifactCompleteDTO.getPartProductionQuantity() + techAssemble.getProducedQuantity() - techAssemble.getUsedQuantity()
                  );
                  TechAssembleDetail techAssembleDetail1 = techAssembleDetails.stream()
                     .filter(t -> t.getAssembleId().equals(techAssemble.getId()) && t.getArtifactId().equals(mesBuildingTaskProcess.getProductId()))
                     .findAny()
                     .orElse(null);
                  artifactCompleteDTO.setPartNeedQuantity(artifactCompleteDTO.getPartNeedQuantity() + techAssembleDetail1.getQuantity() * i1);
               }
            }
         }

         sumNum = sumNum + num;
         TechArtifact techArtifact = artifactMap.get(mesBuildingTaskProcess.getProductId());
         sumWeight = sumWeight.add(techArtifact.getNetWeight().multiply(BigDecimal.valueOf(sumNum.intValue())));
         artifactCompleteDTO.setCompleteQuantity(artifactCompleteDTO.getCompleteQuantity() + num);
         map.put(techArtifact.getId(), artifactCompleteDTO);
      }

      map.forEach((k, v) -> {
         if (v.getCompleteQuantity() == 0) {
            v.setStatus("3");
         } else if (v.getCompleteQuantity() >= v.getArtifactQuantity()) {
            v.setStatus("1");
         } else {
            v.setStatus("2");
         }
      });
      return new ArrayList<>(map.values()).stream().filter(t -> t.getArtifactQuantity() > 0).collect(Collectors.toList());
   }

   private NetWeightAndQuantityDTO getCompleteQuantity(
      List<MesBuildingTaskProcess> mesBuildingTaskProcesses,
      List<TechArtifactMachinePartLink> techArtifactMachinePartLinks,
      List<TechMachinePart> techMachineParts,
      List<TechAssembleDetail> techAssembleDetails,
      List<TechAssemble> techAssembles,
      Map<Long, TechArtifact> artifactMap
   ) {
      NetWeightAndQuantityDTO netWeightAndQuantityDTO = new NetWeightAndQuantityDTO();
      Integer sumNum = 0;
      BigDecimal sumWeight = new BigDecimal(0);

      label44:
      for (MesBuildingTaskProcess mesBuildingTaskProcess : mesBuildingTaskProcesses) {
         int i1 = mesBuildingTaskProcess.getNeedQuantity() - mesBuildingTaskProcess.getInspectionQuantity();
         Integer num = i1;
         List<TechArtifactMachinePartLink> techArtifactMachinePartLinkList = techArtifactMachinePartLinks.stream()
            .filter(t -> t.getArtifactId().equals(mesBuildingTaskProcess.getProductId()))
            .collect(Collectors.toList());
         if (techArtifactMachinePartLinkList != null) {
            for (TechArtifactMachinePartLink techArtifactMachinePartLink : techArtifactMachinePartLinkList) {
               List<TechMachinePart> collect = techMachineParts.stream()
                  .filter(t -> t.getId().equals(techArtifactMachinePartLink.getMachinePartId()))
                  .collect(Collectors.toList());
               Integer reduce = techMachineParts.stream()
                  .filter(t -> t.getId().equals(techArtifactMachinePartLink.getMachinePartId()))
                  .map(t -> t.getProducedQuantity() - t.getUsedQuantity())
                  .reduce(0, Integer::sum);
               int i = reduce / techArtifactMachinePartLink.getQuantity();
               if (i == 0) {
                  continue label44;
               }

               num = Math.min(i, num);
            }
         }

         List<TechAssembleDetail> techAssembleDetailList = techAssembleDetails.stream()
            .filter(t -> t.getArtifactId().equals(mesBuildingTaskProcess.getProductId()))
            .collect(Collectors.toList());
         if (techAssembleDetailList != null) {
            for (TechAssembleDetail techAssembleDetail : techAssembleDetailList) {
               List<TechAssemble> collect = techAssembles.stream()
                  .filter(t -> t.getId().equals(techAssembleDetail.getAssembleId()))
                  .collect(Collectors.toList());
               Integer reduce = techAssembles.stream()
                  .filter(t -> t.getId().equals(techAssembleDetail.getAssembleId()))
                  .map(t -> t.getProducedQuantity() - t.getUsedQuantity())
                  .reduce(0, Integer::sum);
               int i = reduce / techAssembleDetail.getQuantity();
               if (i == 0) {
                  continue label44;
               }

               num = Math.min(i, num);
            }
         }

         sumNum = sumNum + num;
         TechArtifact techArtifact = artifactMap.get(mesBuildingTaskProcess.getProductId());
         sumWeight = sumWeight.add(techArtifact.getNetWeight().multiply(BigDecimal.valueOf(sumNum.intValue())));
      }

      netWeightAndQuantityDTO.setQuantity(sumNum);
      netWeightAndQuantityDTO.setWeight(sumWeight);
      return netWeightAndQuantityDTO;
   }
}
