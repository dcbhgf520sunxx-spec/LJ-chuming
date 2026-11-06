package com.hzchum.scim.mes.building.core.service.impl.workshopStatistics;

import com.hzchum.scim.mes.building.core.api.pojo._dto.workshopStatistics.WorkshopProductionStatisticsVO;
import com.hzchum.scim.mes.building.core.api.service.workshopStatistics.WorkshopProductionStatisticsService;
import com.hzchum.scim.mes.building.core.mapper.workshopStatistics.WorkshopProductionStatisticsMapper;
import java.time.LocalDate;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class WorkshopProductionStatisticsServiceImpl implements WorkshopProductionStatisticsService {
   @Resource
   private WorkshopProductionStatisticsMapper workshopProductionStatisticsMapper;

   @Override
   public List<WorkshopProductionStatisticsVO> queryWorkshopStatistics(LocalDate startDate, LocalDate endDate, Long workshopId) {
      return this.workshopProductionStatisticsMapper.queryWorkshopStatistics(startDate, endDate, workshopId);
   }
}
