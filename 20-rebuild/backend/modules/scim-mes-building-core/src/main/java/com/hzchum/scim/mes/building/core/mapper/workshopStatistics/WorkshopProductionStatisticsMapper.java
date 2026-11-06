package com.hzchum.scim.mes.building.core.mapper.workshopStatistics;

import com.hzchum.scim.mes.building.core.api.pojo._dto.workshopStatistics.WorkshopProductionStatisticsVO;
import java.time.LocalDate;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkshopProductionStatisticsMapper {
   List<WorkshopProductionStatisticsVO> queryWorkshopStatistics(
      @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate, @Param("workshopId") Long workshopId
   );
}
