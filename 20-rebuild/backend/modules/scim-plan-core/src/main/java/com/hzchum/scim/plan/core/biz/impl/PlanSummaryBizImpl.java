package com.hzchum.scim.plan.core.biz.impl;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.DateTimeUtil;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.biz.PlanSummaryBiz;
import com.hzchum.scim.plan.core.api.pojo._do.PlanSummaryDO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanSummaryDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanSummaryDetailDTO;
import com.hzchum.scim.plan.core.api.service.PlanMonomerDetailService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanSummaryBizImpl implements PlanSummaryBiz {
   @Autowired
   private PlanMonomerDetailService monomerDetailService;
   @Autowired
   private ContractProjectService projectService;

   @Override
   public ListVO<PlanSummaryDTO> listMetByProduct(String year, Integer type) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (projectIds.size() == 0) {
         return new ListVO<>();
      }

      List<PlanSummaryDO> plans = this.monomerDetailService.listByYearAndType(year, type, projectIds);
      List<LocalDate> months = DateTimeUtil.allMonthsOfYear(LocalDate.of(Integer.parseInt(year), 1, 1));
      return new ListVO<>(plans.stream().map(item -> {
         PlanSummaryDTO summary = BeanUtil.copy(item, PlanSummaryDTO.class);
         LocalDate startDate = item.getStartDate();
         LocalDate endDate = item.getEndDate();
         long allDays = DateTimeUtil.getBetweenDay(startDate, endDate) + 1L;
         summary.setDetails(months.stream().map(month -> {
            PlanSummaryDetailDTO details = new PlanSummaryDetailDTO();
            details.setMonth(month.getMonthValue());
            long days = this.getMonthOfDays(startDate, endDate, month);
            if (days != 0L) {
               BigDecimal monthMete = item.getMete().multiply(BigDecimal.valueOf(days * 1.0 / allDays)).setScale(2, RoundingMode.HALF_UP);
               details.setMete(monthMete);
            }

            return details;
         }).collect(Collectors.toList()));
         return summary;
      }).collect(Collectors.toList()));
   }

   private long getMonthOfDays(LocalDate startDate, LocalDate endDate, LocalDate month) {
      LocalDate nextMonth = month.plusMonths(1L);
      long betweenDay = DateTimeUtil.getBetweenDay(startDate, month);
      long betweenDay1 = DateTimeUtil.getBetweenDay(startDate, nextMonth);
      long betweenDay2 = DateTimeUtil.getBetweenDay(endDate, month);
      long betweenDay3 = DateTimeUtil.getBetweenDay(endDate, nextMonth);
      if (betweenDay > 0L) {
         if (betweenDay2 > 0L) {
            return 0L;
         } else {
            return betweenDay3 > 0L ? -betweenDay2 + 1L : DateTimeUtil.getBetweenDay(month, nextMonth);
         }
      } else if (betweenDay1 < 0L) {
         return 0L;
      } else {
         return betweenDay3 > 0L ? DateTimeUtil.getBetweenDay(startDate, endDate) + 1L : betweenDay1;
      }
   }

   public static void main(String[] args) {
      List<LocalDate> months = DateTimeUtil.allMonthsOfYear(LocalDate.now());
      LocalDate startDate = LocalDate.of(2021, 1, 1);
      LocalDate endDate = LocalDate.of(2021, 2, 1);
      months.forEach(month -> DateTimeUtil.getBetweenDay(startDate, month));
   }
}
