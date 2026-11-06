package com.hzchum.scim.mes.building.core.api.service.task;

import com.hzchum.scim.mes.building.core.api.pojo._do.task.FinishedProductWarehousingSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.FinishedProductWarehousingSummaryDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MonthlyWorkshopOutPutDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.TeamOutputStatisticsDetailsReportDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.TeamOutputStatisticsReportDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.report.TeamOutputStatisticsDetailsReport;
import com.hzchum.scim.mes.building.core.api.pojo.vo.task.YearlyOutputComparisonVO;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface MesBuildingOutputReportService {
   List<FinishedProductWarehousingSummaryDO> finishedProductWarehousingSummary(String yearMonth, Long workshopId, String workshopName);

   void finishedProductWarehousingSummaryDownload(String yearMonth, Long workshopId, String workshopName, HttpServletResponse response);

   List<FinishedProductWarehousingSummaryDetailDO> finishedProductWarehousingSummaryDetail(
      String yearMonth, Long workshopId, String structureType, String workshopName
   );

   void finishedProductWarehousingSummaryDetailDownload(
      String yearMonth, Long workshopId, String structureType, String workshopName, HttpServletResponse response
   );

   List<YearlyOutputComparisonVO> yearlyOutputComparison(String year, Long workshopId);

   void yearlyOutputComparisonDownload(String year, Long workshopId, String workshopName, HttpServletResponse response);

   List<TeamOutputStatisticsReportDO> teamOutputStatisticsReport(
      String startDate, String endDate, Long workshopId, Long productionLineId, String teamName, String processName, String processType
   );

   List<TeamOutputStatisticsDetailsReportDO> teamOutputStatisticsDetailsReport(
      String startDate,
      String endDate,
      Long workshopId,
      Long productionLineId,
      Long teamId,
      Long processId,
      String processType,
      String teamName,
      String processName
   );

   List<TeamOutputStatisticsDetailsReport> teamOutputStatisticsDetailsReportDownload(
      String startDate,
      String endDate,
      Long workshopId,
      Long productionLineId,
      Long teamId,
      Long processId,
      String processType,
      String teamName,
      String processName,
      String workshopName,
      HttpServletResponse response
   );

   List<MonthlyWorkshopOutPutDO> workshopProductionOutputStatisticsMonthlyReport(String yearMonth, Long workshopId, Long projectId, String structureType);

   void workshopProductionOutputStatisticsMonthlyReportDownload(
      String yearMonth, Long workshopId, String workshopName, Long projectId, String structureType, HttpServletResponse response
   );
}
