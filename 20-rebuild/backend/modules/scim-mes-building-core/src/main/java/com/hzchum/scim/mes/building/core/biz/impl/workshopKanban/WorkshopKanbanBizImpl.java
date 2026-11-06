package com.hzchum.scim.mes.building.core.biz.impl.workshopKanban;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.DateTimeUtil;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.workshopKanban.WorkshopKanbanBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.TaskConditionByDateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.TeamEachMonthRateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.TeamTaskCompleteDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.TeamTaskCompleteRateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.WorkShopEachMonthRateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.WorkShopTaskCompleteDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.WorkShopTaskCompleteRateDTO;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseRecordService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkshopKanbanBizImpl implements WorkshopKanbanBiz {
   @Autowired
   private MesBuildingWarehouseRecordService warehouseService;
   @Autowired
   private MesBuildingTaskService taskService;
   @Autowired
   private MesBuildingWorkshopService workshopService;
   @Autowired
   private MesBuildingTeamService teamService;
   @Autowired
   private MesBuildingTeamUserLinkService teamUserLinkService;
   @Autowired
   private ContractProjectService contractProjectService;

   @Override
   public List<WorkShopTaskCompleteRateDTO> getWorkShopTaskPercentageComplete(LocalDateTime date) {
      LocalDateTime now = LocalDateTime.now();
      date = date == null ? now : date;
      Boolean IsCurrentYear = date.getYear() == now.getYear();
      List<MesBuildingWorkshop> workshops = this.workshopService.list();
      Map<Long, Map<String, TaskConditionByDateDTO>> taskWeightMap = this.taskService
         .getEachWorkShopTaskCondition(date)
         .stream()
         .collect(Collectors.groupingBy(TaskConditionByDateDTO::getWorkShopId, Collectors.toMap(TaskConditionByDateDTO::getDate, Function.identity())));
      Map<Long, Map<String, TaskConditionByDateDTO>> warehouseRecordMap = this.warehouseService
         .getEachWorkShopWarehouseRecord(date)
         .stream()
         .collect(Collectors.groupingBy(TaskConditionByDateDTO::getWorkShopId, Collectors.toMap(TaskConditionByDateDTO::getDate, Function.identity())));
      List<String> months = DateTimeUtil.getMonths(12);
      ArrayList<WorkShopTaskCompleteRateDTO> dtos = new ArrayList<>();

      for (MesBuildingWorkshop workshop : workshops) {
         Map<String, TaskConditionByDateDTO> taskDateMap = taskWeightMap.get(workshop.getId());
         Map<String, TaskConditionByDateDTO> warehouseDateMap = warehouseRecordMap.get(workshop.getId());
         ArrayList<WorkShopEachMonthRateDTO> monthRateDTOS = new ArrayList<>();

         for (String month : months) {
            WorkShopEachMonthRateDTO monthRateDTO = new WorkShopEachMonthRateDTO();
            boolean boolTask = taskDateMap.containsKey(month);
            boolean boolWare = warehouseDateMap.containsKey(month);
            if (boolTask && boolWare) {
               TaskConditionByDateDTO taskRateInfo = taskDateMap.get(month);
               TaskConditionByDateDTO wareRateInfo = warehouseDateMap.get(month);
               monthRateDTO.setWorkShopId(taskRateInfo.getWorkShopId())
                  .setWorkShopName(taskRateInfo.getWorkShopName())
                  .setDate(month)
                  .setRate(wareRateInfo.getNetWeightSum().divide(taskRateInfo.getNetWeightSum(), 0, RoundingMode.HALF_UP));
            } else if (boolTask) {
               TaskConditionByDateDTO taskRateInfo = taskDateMap.get(month);
               monthRateDTO.setWorkShopId(taskRateInfo.getWorkShopId()).setWorkShopName(taskRateInfo.getWorkShopName()).setDate(month).setRate(BigDecimal.ZERO);
            } else if (boolWare) {
               TaskConditionByDateDTO wareRateInfo = warehouseDateMap.get(month);
               monthRateDTO.setWorkShopId(wareRateInfo.getWorkShopId())
                  .setWorkShopName(wareRateInfo.getWorkShopName())
                  .setDate(month)
                  .setRate(new BigDecimal(100));
            } else {
               monthRateDTO.setWorkShopId(workshop.getId()).setWorkShopName(workshop.getName()).setDate(month).setRate(BigDecimal.ZERO);
            }

            monthRateDTOS.add(monthRateDTO);
         }

         BigDecimal reduce = monthRateDTOS.stream().map(e -> e.getRate()).reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal avgRate = IsCurrentYear
            ? reduce.divide(BigDecimal.valueOf(now.getMonthValue()), 0, RoundingMode.HALF_UP)
            : reduce.divide(BigDecimal.valueOf(12L), 0, RoundingMode.HALF_UP);
         WorkShopTaskCompleteRateDTO dto = new WorkShopTaskCompleteRateDTO();
         dto.setWorkShopId(workshop.getId());
         dto.setWorkShopName(workshop.getName());
         dto.setAvgRate(avgRate);
         dto.setMonthRateList(monthRateDTOS);
         dtos.add(dto);
      }

      return dtos;
   }

   @Override
   public List<TeamTaskCompleteRateDTO> getTeamTaskPercentageComplete(Long workShopId, Long processId, LocalDateTime time) {
      Preconditions.checkArgument(workShopId != null && processId != null, "车间工序必传");
      LocalDateTime now = LocalDateTime.now();
      List<MesBuildingTeam> teamList = this.teamService
         .list(Wrappers.lambdaQuery(MesBuildingTeam.class).eq(MesBuildingTeam::getWorkshopId, workShopId).eq(MesBuildingTeam::getProcessId, processId));
      if (CollectionUtil.isNotEmpty(teamList)) {
         return new ArrayList<>();
      }

      List<Long> teamIds = teamList.stream().map(e -> e.getId()).collect(Collectors.toList());
      Map<Long, String> userLinkMap = this.teamUserLinkService
         .list(
            Wrappers.lambdaQuery(MesBuildingTeamUserLink.class)
               .in(MesBuildingTeamUserLink::getTeamId, teamIds)
               .eq(MesBuildingTeamUserLink::getBoolLeaderEnum, Boolean.TRUE)
         )
         .stream()
         .collect(Collectors.toMap(e -> e.getTeamId(), s -> s.getUserName()));
      List<TeamEachMonthRateDTO> monthRateDTOS = this.taskService.getEachTeamTaskCondition(teamIds, time);
      Map<Long, Map<String, TeamEachMonthRateDTO>> teamMonthDTO = monthRateDTOS.stream()
         .collect(Collectors.groupingBy(e -> e.getTeamId(), Collectors.toMap(s -> s.getDate(), Function.identity())));
      List<String> months = DateTimeUtil.getMonths(12);
      ArrayList<TeamTaskCompleteRateDTO> dtos = new ArrayList<>();

      for (MesBuildingTeam team : teamList) {
         Map<String, TeamEachMonthRateDTO> monthRateDTOMap = teamMonthDTO.get(team.getId());
         List<TeamEachMonthRateDTO> rateDTOs = new ArrayList<>();

         for (String month : months) {
            TeamEachMonthRateDTO completeRateDTO = new TeamEachMonthRateDTO();
            TeamEachMonthRateDTO rateDTO = monthRateDTOMap.get(month);
            if (rateDTO != null) {
               if (rateDTO.getTaskQuantityWeight().compareTo(BigDecimal.ZERO) > 0) {
                  completeRateDTO.setTeamId(rateDTO.getTeamId());
                  completeRateDTO.setTeamLeaderName(rateDTO.getTeamLeaderName());
                  completeRateDTO.setRate(completeRateDTO.getTotalCompleteWeight().divide(completeRateDTO.getTaskQuantityWeight(), 0, RoundingMode.HALF_UP));
               } else {
                  completeRateDTO.setTeamId(rateDTO.getTeamId());
                  completeRateDTO.setTeamLeaderName(rateDTO.getTeamLeaderName());
                  completeRateDTO.setRate(BigDecimal.ZERO);
               }
            } else {
               completeRateDTO.setTeamId(team.getId());
               completeRateDTO.setTeamLeaderName(userLinkMap.get(team.getId()));
               completeRateDTO.setRate(BigDecimal.ZERO);
            }

            rateDTOs.add(completeRateDTO);
         }

         BigDecimal reduce = rateDTOs.stream().map(e -> e.getRate()).reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal avgRate = reduce.divide(BigDecimal.valueOf(now.getMonthValue()), 0, RoundingMode.HALF_UP);
         TeamTaskCompleteRateDTO dto = new TeamTaskCompleteRateDTO();
         dto.setTeamId(team.getId());
         dto.setTeamLeaderName(userLinkMap.get(team.getId()));
         dto.setAvgRate(avgRate);
         dto.setMonthRateList(rateDTOs);
         dtos.add(dto);
      }

      return dtos;
   }

   @Override
   public List<WorkShopTaskCompleteDetailDTO> findTaskPercentageDetail(LocalDateTime date, Long workShopId) {
      Preconditions.checkArgument(date != null && workShopId != null, "日期、车间参数必传");
      List<WorkShopTaskCompleteDetailDTO> taskPercentageDTOS = this.taskService.findWorkshopTaskPercentageDetail(date, workShopId);
      Map<Long, WorkShopTaskCompleteDetailDTO> taskPercentageMap = taskPercentageDTOS.stream().collect(Collectors.toMap(e -> e.getId(), Function.identity()));
      List<WorkShopTaskCompleteDetailDTO> completePercentageDTOS = this.warehouseService.findWorkshopCompletePercentageDetail(date, workShopId);
      Map<Long, WorkShopTaskCompleteDetailDTO> completePercentageMap = completePercentageDTOS.stream()
         .collect(Collectors.toMap(e -> e.getId(), Function.identity()));
      List<Long> projectIds = taskPercentageDTOS.stream().map(e -> e.getId()).distinct().collect(Collectors.toList());
      projectIds.addAll(completePercentageDTOS.stream().map(e -> e.getId()).distinct().collect(Collectors.toList()));
      List<ContractProject> projects = this.contractProjectService.listByIds(projectIds);
      ArrayList<WorkShopTaskCompleteDetailDTO> dtos = new ArrayList<>();

      for (ContractProject project : projects) {
         WorkShopTaskCompleteDetailDTO dto = new WorkShopTaskCompleteDetailDTO();
         WorkShopTaskCompleteDetailDTO taskDTO = taskPercentageMap.get(project.getId());
         WorkShopTaskCompleteDetailDTO completeDTO = completePercentageMap.get(project.getId());
         dto.setId(project.getId()).setShortName(project.getShortName()).setSerialNumber(project.getSerialNumber());
         if (taskDTO != null && completeDTO != null) {
            dto.setTaskQuantity(taskDTO.getTaskQuantity())
               .setTaskWeightSum(taskDTO.getTaskWeightSum())
               .setCompleteQuantity(completeDTO.getCompleteQuantity())
               .setCompleteWeightSum(completeDTO.getCompleteWeightSum());
            dto.setRate(completeDTO.getCompleteWeightSum().divide(completeDTO.getTaskWeightSum(), 0, RoundingMode.HALF_UP));
         } else if (taskDTO != null) {
            dto.setTaskQuantity(taskDTO.getTaskQuantity())
               .setTaskWeightSum(taskDTO.getTaskWeightSum())
               .setCompleteQuantity(0)
               .setCompleteWeightSum(BigDecimal.ZERO);
            dto.setRate(BigDecimal.ZERO);
         } else if (completeDTO != null) {
            dto.setTaskQuantity(0)
               .setTaskWeightSum(BigDecimal.ZERO)
               .setCompleteQuantity(completeDTO.getCompleteQuantity())
               .setCompleteWeightSum(completeDTO.getCompleteWeightSum());
            dto.setRate(new BigDecimal(100));
         }

         dtos.add(dto);
      }

      return dtos;
   }

   @Override
   public List<TeamTaskCompleteDetailDTO> findTeamPercentageDetail(LocalDateTime date, Long workShopId, Long processId, Long teamId) {
      Preconditions.checkArgument(date != null && teamId != null, "日期和班组参数不能为空");
      List<TeamTaskCompleteDetailDTO> taskDetailList = this.taskService.getEachTeamTaskDetail(date, teamId);
      taskDetailList.stream().forEach(e -> e.setRate(e.getCompleteWeightSum().divide(e.getTaskWeightSum(), 0, RoundingMode.HALF_UP)));
      return taskDetailList;
   }
}
