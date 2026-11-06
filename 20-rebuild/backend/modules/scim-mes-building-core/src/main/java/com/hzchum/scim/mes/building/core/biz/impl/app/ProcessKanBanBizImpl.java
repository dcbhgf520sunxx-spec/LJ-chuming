package com.hzchum.scim.mes.building.core.biz.impl.app;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhse;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrder;
import com.hzchum.scim.mes.building.core.api.pojo._dto.app.AverageTaskDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.app.DateAndCount;
import com.hzchum.scim.mes.building.core.api.pojo._dto.app.OverdueOverInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.app.ProcessKanBanOverdueOverDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.app.ProcessKanBanQhseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.app.ProcessKanBanSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.AppTaskOrderSummaryDTO;
import com.hzchum.scim.mes.building.core.api.service.app.ProcessKanBanBiz;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingProduceTeamReportService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskOrderService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import com.hzchum.scim.system.core.api.pojo._do.MesQualityClassConfig;
import com.hzchum.scim.system.core.api.service.MesQualityClassConfigService;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ProcessKanBanBizImpl implements ProcessKanBanBiz {
   @Resource
   private MesBuildingQhseService qhseService;
   @Resource
   private MesBuildingProduceTeamReportService teamReportService;
   @Resource
   private MesBuildingTaskProcessService taskProcessService;
   @Resource
   private MesBuildingTaskOrderService taskOrderService;
   @Resource
   private SysDictionaryService dictionaryService;
   @Resource
   private MesQualityClassConfigService qualityClassConfigService;

   @Override
   public ProcessKanBanSummaryDTO getProcessKanBanSummary(LocalDateTime year, Long processId, Long userId) {
      int y = year == null ? LocalDateTime.now().getYear() : year.getYear();
      ProcessKanBanSummaryDTO summaryDTO = new ProcessKanBanSummaryDTO();
      Integer annualTotal = this.teamReportService.findAnnualTotal(y, processId, userId);
      Integer lastMonthTotal = this.teamReportService.findLastMonthTotal(processId, userId);
      Integer currentMonthTotal = this.teamReportService.findCurrentMonthTotal(processId, userId);
      Integer currentProjects = this.teamReportService.findCurrentProjects(processId, userId);
      Integer currentIncomplete = this.teamReportService.findCurrentIncomplete(processId, userId);
      Integer incompleteOnAssist = this.teamReportService.findCurrentIncompleteOnAssist(processId, userId);
      Integer yesterdayTotal = this.teamReportService.findYesterdayTotal(processId, userId);
      Integer todayTotal = this.teamReportService.findTodayTotal(processId, userId);
      summaryDTO.setAnnualTotal(annualTotal);
      summaryDTO.setLastMonthTotal(lastMonthTotal);
      summaryDTO.setCurrentMonthTotal(currentMonthTotal);
      summaryDTO.setCurrentProjects(currentProjects);
      summaryDTO.setCurrentIncomplete(currentIncomplete + incompleteOnAssist);
      summaryDTO.setYesterdayTotal(yesterdayTotal);
      summaryDTO.setTodayTotal(todayTotal);
      return summaryDTO;
   }

   @Override
   public Map<Integer, Integer> getMonthlyOutputByYear(LocalDateTime year, Long processId, Long userId) {
      int y = year == null ? LocalDateTime.now().getYear() : year.getYear();
      return this.teamReportService
         .getMonthlyOutputByYear(y, processId, userId)
         .stream()
         .collect(Collectors.toMap(s -> s.getDate().getMonthValue(), DateAndCount::getQuantity));
   }

   @Override
   public Map<Integer, Integer> getQhseCountByYear(LocalDateTime year, Long processId, Long userId) {
      int y = year == null ? LocalDateTime.now().getYear() : year.getYear();
      return this.qhseService
         .getQhseCountByYear(y, processId, userId)
         .stream()
         .collect(Collectors.toMap(s -> s.getDate().getMonthValue(), DateAndCount::getQuantity));
   }

   @Override
   public List<ProcessKanBanQhseDTO> getQhseAnalyseByYear(LocalDateTime year, Long processId, Long userId) {
      int y = year == null ? LocalDateTime.now().getYear() : year.getYear();
      List<MesBuildingQhse> allQuseByYear = this.qhseService.getQhseAnalyseByYear(y, processId, userId);
      List<MesBuildingQhse> qhseList = allQuseByYear.stream().peek(s -> {
         if (s.getProblemQuantity() == null) {
            s.setProblemQuantity(1);
         }
      }).collect(Collectors.toList());
      List<MesQualityClassConfig> classConfigList = this.qualityClassConfigService
         .list(Wrappers.lambdaQuery(MesQualityClassConfig.class).eq(MesQualityClassConfig::getPid, 0));
      List<ProcessKanBanQhseDTO> dtoList = new ArrayList<>();

      for (MesQualityClassConfig config : classConfigList) {
         ProcessKanBanQhseDTO qhseDTO = new ProcessKanBanQhseDTO();
         int quantity = (int)qhseList.stream().map(MesBuildingQhse::getLevelOneType).filter(s -> s.equals(config.getId())).count();
         qhseDTO.setQhseTypeName(config.getName());
         qhseDTO.setQuantity(quantity);
         dtoList.add(qhseDTO);
      }

      return dtoList;
   }

   @Override
   public AverageTaskDTO getAverageTaskCompletionRate(LocalDateTime year, Long processId, Long userId) {
      int y = year == null ? LocalDateTime.now().getYear() : year.getYear();
      AverageTaskDTO taskCompletionRate = this.taskProcessService.getAverageTaskCompletionRate(y, processId, userId);
      AverageTaskDTO taskOnAssistCompletion = this.taskProcessService.getAverageTaskCompletionOnAssist(y, processId, userId);
      taskCompletionRate.setTotalTaskCount(taskCompletionRate.getTotalTaskCount().add(taskOnAssistCompletion.getTotalTaskCount()));
      taskCompletionRate.setOnTimeCompletionCount(taskCompletionRate.getOnTimeCompletionCount().add(taskOnAssistCompletion.getOnTimeCompletionCount()));
      if (taskCompletionRate.getTotalTaskCount().compareTo(new BigDecimal(0)) != 0) {
         taskCompletionRate.setAverageCompletionRate(
            taskCompletionRate.getOnTimeCompletionCount().divide(taskCompletionRate.getTotalTaskCount(), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100))
         );
      }

      return taskCompletionRate;
   }

   @Override
   public ProcessKanBanOverdueOverDTO getOverdueOrderInfo(Long processId, Long userId) {
      List<OverdueOverInfoDTO> overdueOrderInfo = this.taskProcessService.getOverdueOrderInfo(processId, userId);
      overdueOrderInfo = overdueOrderInfo.stream()
         .filter(s -> !s.getQuantity().equals(s.getCompleteQuantity()))
         .filter(b -> b.getAskCompleteTime().isBefore(LocalDateTime.now()))
         .collect(Collectors.toList());
      ProcessKanBanOverdueOverDTO overDTO = new ProcessKanBanOverdueOverDTO();
      if (CollectionUtils.isEmpty(overdueOrderInfo)) {
         return overDTO;
      }

      List<MesBuildingTaskOrder> orderByUser = this.taskOrderService
         .listByIds(overdueOrderInfo.stream().map(AppTaskOrderSummaryDTO::getId).distinct().collect(Collectors.toList()));
      Map<Long, MesBuildingTaskOrder> taskOrderMap = orderByUser.stream().collect(Collectors.toMap(MesBuildingTaskOrder::getId, Function.identity()));
      List<OverdueOverInfoDTO> overdue = overdueOrderInfo.stream().peek(s -> {
         MesBuildingTaskOrder mesBuildingTaskOrder = taskOrderMap.get(s.getId());
         if (mesBuildingTaskOrder.getCompleteTime() != null) {
            if (s.getAskCompleteTime().isBefore(mesBuildingTaskOrder.getCompleteTime())) {
               long betweenDay = ChronoUnit.DAYS.between(s.getAskCompleteTime(), mesBuildingTaskOrder.getCompleteTime());
               s.setOverdueDay((int)betweenDay);
            } else {
               s.setOverdueDay(0);
            }
         } else {
            LocalDateTime nowTime = LocalDateTime.now();
            if (LocalDateTime.now().isAfter(s.getAskCompleteTime())) {
               long between = ChronoUnit.DAYS.between(s.getAskCompleteTime(), nowTime);
               s.setOverdueDay((int)between);
            } else {
               s.setOverdueDay(0);
            }
         }
      }).collect(Collectors.toList());
      long count = overdue.stream().filter(s -> s.getOverdueDay() != null).count();
      overDTO.setOrders(overdue);
      overDTO.setOverdueCount((int)count);
      return overDTO;
   }
}
