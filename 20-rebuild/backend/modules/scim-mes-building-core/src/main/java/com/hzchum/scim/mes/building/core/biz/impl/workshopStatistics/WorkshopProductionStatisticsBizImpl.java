package com.hzchum.scim.mes.building.core.biz.impl.workshopStatistics;

import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.mes.building.core.api.biz.workshopStatistics.WorkshopProductionStatisticsBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.workshopStatistics.WorkshopProductionStatisticsQueryParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.workshopStatistics.WorkshopProductionStatisticsVO;
import com.hzchum.scim.mes.building.core.api.service.workshopStatistics.WorkshopProductionStatisticsService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class WorkshopProductionStatisticsBizImpl implements WorkshopProductionStatisticsBiz {
   private static final Logger log = LoggerFactory.getLogger(WorkshopProductionStatisticsBizImpl.class);
   private static final int PERCENT_SCALE = 2;
   @Resource
   private WorkshopProductionStatisticsService workshopProductionStatisticsService;

   @Override
   public List<WorkshopProductionStatisticsVO> listWorkshopProductionStatistics(WorkshopProductionStatisticsQueryParam param) {
      List<WorkshopProductionStatisticsVO> list = this.workshopProductionStatisticsService
         .queryWorkshopStatistics(param.getStartDate(), param.getEndDate(), param.getWorkshopId());
      if (list != null && !list.isEmpty()) {
         for (WorkshopProductionStatisticsVO vo : list) {
            vo.setActualPlanRatio(this.safeDividePercent(vo.getActualCompleteTon(), vo.getPlanSchedulingTon()));
            vo.setTargetAchievementRate(this.safeDividePercent(vo.getActualCompleteTon(), vo.getAnnualTargetTon()));
         }

         list.sort(Comparator.comparing(WorkshopProductionStatisticsVO::getTargetAchievementRate, Comparator.nullsLast(Comparator.reverseOrder())));

         for (int i = 0; i < list.size(); i++) {
            list.get(i).setRank(i + 1);
         }

         log.info("车间产量统计报表查询结果：共{}条", list.size());
         return list;
      } else {
         return list;
      }
   }

   @Override
   public void exportWorkshopProductionStatistics(WorkshopProductionStatisticsQueryParam param, HttpServletResponse response) {
      List<WorkshopProductionStatisticsVO> list = this.listWorkshopProductionStatistics(param);
      String title = "车间产量统计报表（" + param.getStartDate() + " 至 " + param.getEndDate() + "）";
      PoiUtils.exportExcel(list, title, "车间产量统计", WorkshopProductionStatisticsVO.class, "车间产量统计报表.xlsx", response);
   }

   private BigDecimal safeDividePercent(BigDecimal numerator, BigDecimal denominator) {
      if (denominator == null || denominator.compareTo(BigDecimal.ZERO) == 0) {
         return null;
      } else {
         return numerator == null
            ? BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP)
            : numerator.multiply(new BigDecimal("100")).divide(denominator, 2, RoundingMode.HALF_UP);
      }
   }
}
