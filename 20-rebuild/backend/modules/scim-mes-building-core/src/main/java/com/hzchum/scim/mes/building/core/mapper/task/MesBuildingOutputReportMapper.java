package com.hzchum.scim.mes.building.core.mapper.task;

import com.hzchum.scim.mes.building.core.api.pojo._do.task.FinishedProductWarehousingSummaryDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.FinishedProductWarehousingSummaryDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MonthlyWorkshopOutPutDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.TeamOutputStatisticsDetailsReportDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.TeamOutputStatisticsReportDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.YearlyOutputComparisonDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.report.MesBeginConvertAssembleDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.report.MesBeginConvertAssembleDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.report.MesBeginConvertDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.report.MesBeginConvertDetailDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingOutputReportMapper {
   List<FinishedProductWarehousingSummaryDO> beginPutPart(@Param("yearMonth") String yearMonth, @Param("workshopId") Long workshopId);

   List<FinishedProductWarehousingSummaryDetailDO> beginPutPartGroupProject(
      @Param("yearMonth") String yearMonth, @Param("workshopId") Long workshopId, @Param("structureType") String structureType
   );

   List<FinishedProductWarehousingSummaryDO> beginFinishProduct(@Param("yearMonth") String yearMonth, @Param("workshopId") Long workshopId);

   List<FinishedProductWarehousingSummaryDetailDO> beginFinishProductGroupProject(
      @Param("yearMonth") String yearMonth, @Param("workshopId") Long workshopId, @Param("structureType") String structureType
   );

   List<FinishedProductWarehousingSummaryDO> beginPutPartThisMonth(@Param("yearMonth") String yearMonth, @Param("workshopId") Long workshopId);

   List<FinishedProductWarehousingSummaryDO> beginFinishProductThisMonth(@Param("yearMonth") String yearMonth, @Param("workshopId") Long workshopId);

   List<FinishedProductWarehousingSummaryDetailDO> beginPutPartThisMonthGroupProject(@Param("yearMonth") String yearMonth, @Param("workshopId") Long workshopId);

   List<FinishedProductWarehousingSummaryDetailDO> beginFinishProductThisMonthGroupProject(
      @Param("yearMonth") String yearMonth, @Param("workshopId") Long workshopId
   );

   List<FinishedProductWarehousingSummaryDO> beginSemiFinishProduct(@Param("yearMonth") String yearMonth, @Param("workshopId") Long workshopId);

   List<MesBeginConvertDO> beginConvertArtifact(@Param("yearMonth") String yearMonth, @Param("workshopId") Long workshopId);

   List<MesBeginConvertDO> beginConvertArtifactThisMonth(@Param("yearMonth") String yearMonth, @Param("workshopId") Long workshopId);

   List<MesBeginConvertDetailDO> beginConvertArtifactGroupProject(
      @Param("yearMonth") String yearMonth, @Param("workshopId") Long workshopId, @Param("structureType") String structureType
   );

   List<MesBeginConvertAssembleDO> beginConvertAssemble(@Param("yearMonth") String yearMonth, @Param("workshopId") Long workshopId);

   List<MesBeginConvertAssembleDetailDO> beginConvertAssembleGroupProject(
      @Param("yearMonth") String yearMonth, @Param("workshopId") Long workshopId, @Param("structureType") String structureType
   );

   List<MesBeginConvertAssembleDO> beginConvertAssembleFinish(@Param("yearMonth") String yearMonth, @Param("workshopId") Long workshopId);

   List<MesBeginConvertAssembleDetailDO> beginConvertAssembleFinishGroupProject(
      @Param("yearMonth") String yearMonth, @Param("workshopId") Long workshopId, @Param("structureType") String structureType
   );

   List<MesBeginConvertDO> beginConvertPart(@Param("yearMonth") String yearMonth, @Param("workshopId") Long workshopId);

   List<MesBeginConvertDO> beginConvertPartThisMonth(@Param("yearMonth") String yearMonth, @Param("workshopId") Long workshopId);

   List<MesBeginConvertDetailDO> beginConvertPartGroupProject(
      @Param("yearMonth") String yearMonth, @Param("workshopId") Long workshopId, @Param("structureType") String structureType
   );

   List<MesBeginConvertDetailDO> beginConvertPartGroupProjectThisMonth(
      @Param("yearMonth") String yearMonth, @Param("workshopId") Long workshopId, @Param("structureType") String structureType
   );

   List<YearlyOutputComparisonDO> yearlyOutputComparison(
      @Param("year") String year, @Param("workshopId") Long workshopId, @Param("structureTypeList") List<String> structureTypeList
   );

   List<TeamOutputStatisticsReportDO> teamOutputStatisticsReport(
      @Param("startDate") String startDate,
      @Param("endDate") String endDate,
      @Param("workshopId") Long workshopId,
      @Param("productionLineId") Long productionLineId,
      @Param("teamName") String teamName,
      @Param("processName") String processName,
      @Param("processType") String processType
   );

   List<TeamOutputStatisticsDetailsReportDO> teamOutputStatisticsDetailsReportArtifact(
      String startDate, String endDate, Long workshopId, Long productionLineId, Long teamId, Long processId, String processType
   );

   List<TeamOutputStatisticsDetailsReportDO> teamOutputStatisticsDetailsReportAssemble(
      String startDate, String endDate, Long workshopId, Long productionLineId, Long teamId, Long processId, String processType
   );

   List<TeamOutputStatisticsDetailsReportDO> teamOutputStatisticsDetailsReportPart(
      String startDate, String endDate, Long workshopId, Long productionLineId, Long teamId, Long processId, String processType
   );

   List<MonthlyWorkshopOutPutDO> workshopProductionOutputStatisticsMonthlyReport(
      @Param("yearMonth") String yearMonth,
      @Param("workshopId") Long workshopId,
      @Param("projectId") Long projectId,
      @Param("structureType") String structureType
   );
}
