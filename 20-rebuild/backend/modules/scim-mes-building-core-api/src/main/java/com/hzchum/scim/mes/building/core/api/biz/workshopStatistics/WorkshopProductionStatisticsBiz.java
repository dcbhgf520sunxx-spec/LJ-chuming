package com.hzchum.scim.mes.building.core.api.biz.workshopStatistics;

import com.hzchum.scim.mes.building.core.api.pojo._doParam.workshopStatistics.WorkshopProductionStatisticsQueryParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.workshopStatistics.WorkshopProductionStatisticsVO;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface WorkshopProductionStatisticsBiz {
   List<WorkshopProductionStatisticsVO> listWorkshopProductionStatistics(WorkshopProductionStatisticsQueryParam param);

   void exportWorkshopProductionStatistics(WorkshopProductionStatisticsQueryParam param, HttpServletResponse response);
}
