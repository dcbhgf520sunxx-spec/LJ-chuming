package com.hzchum.scim.mes.building.core.api.service.workshopStatistics;

import com.hzchum.scim.mes.building.core.api.pojo._dto.workshopStatistics.WorkshopProductionStatisticsVO;
import java.time.LocalDate;
import java.util.List;

public interface WorkshopProductionStatisticsService {
   List<WorkshopProductionStatisticsVO> queryWorkshopStatistics(LocalDate startDate, LocalDate endDate, Long workshopId);
}
