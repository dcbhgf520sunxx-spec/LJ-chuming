package com.hzchum.scim.mes.building.core.mapper.task;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.common.KevMeteDO;
import com.hzchum.scim.common.core.api.pojo.common.MonthMeteInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectMeteInfo;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._do.complete.CompleteMeteByMonthDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.complete.CompleteProductDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.kpi.ProductionCompleteYieldKpiDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.kpi.ProductionLineCompleteYieldKpiDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.kpi.ProductionTypeAnalysisDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.kpi.ProjectCompleteYieldKpiDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.ArtifactProductionDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.ProductionAnalysisDetailsDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.ProjectProductionDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.complete.ProductionLoadDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingComplete;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.DateAndMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.ProjectAnalysisDataDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.ProjectInboundCurrentMonth;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.ProjectSteelRearingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.WorkshopMonthAndMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.WorkshopSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingWeeklyProductionReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.ProductMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.artifactWarehouse.TonVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.manufacturingDeptProduction.TaskProductionVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.processProductionProgress.ProcessProductionProgressVO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectProductDTO;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingCompleteMapper extends BaseMapper<MesBuildingComplete> {
   List<KevMeteDO> listArtifactGroupByDate(
      @Param("year") String year, @Param("month") String month, @Param("projectId") Long projectId, @Param("factoryId") Long factoryId
   );

   List<KevMeteDO> listEnclosureGroupByDate(@Param("year") String year, @Param("month") String month, @Param("factoryId") Long factoryId);

   List<KevMeteDO> listEnclosureCategoryGroupByDate(@Param("month") String month, @Param("date") String date, @Param("factoryId") Long factoryId);

   List<KevMeteDO> listEnclosurePlateGroupByDate(@Param("month") String month, @Param("date") String date, @Param("factoryId") Long factoryId);

   List<ArtifactProductionDetailDO> listArtifactByProjectIdAndMonth(@Param("projectId") Long projectId, @Param("month") String month);

   BigDecimal sumMeteByProjectId(Long projectId);

   BigDecimal getSumStructureCompleteMete(@Param("monomerId") Long monomerId, @Param("areaId") Long areaId);

   List<ProjectProductDTO> getAreaArtifactOneCodeCompleteDetails(@Param("areaId") Long areaId, @Param("processId") Long processId);

   BigDecimal getSumEnclosureCompleteMete(List<Long> areaIds);

   List<ProductionAnalysisDetailsDO> getProductionByDateAndType(
      @Param("factoryId") Long factoryId, @Param("dateTime") LocalDateTime dateTime, @Param("productType") Integer productType
   );

   List<ProjectProductionDO> getProjectProductionByDate(@Param("dateTime") LocalDateTime dateTime);

   List<ProductionTypeAnalysisDO> productionTypeAnalysis(@Param("dateTime") LocalDateTime dateTime, @Param("productType") Integer productType);

   List<ProductionTypeAnalysisDO> productionTypeAnalysisV2(
      @Param("dateTime") LocalDate dateTime,
      @Param("productType") Integer productType,
      @Param("projectIds") List<Long> projectIds,
      @Param("branchCompanyId") Long branchCompanyId
   );

   List<ProductionCompleteYieldKpiDO> completeYieldGropMonth(@Param("dateTime") LocalDateTime dateTime);

   List<ProductionLineCompleteYieldKpiDO> completeYield(@Param("dateTime") LocalDateTime dateTime, @Param("productionLineIds") List<Long> productionLineIds);

   List<ProjectCompleteYieldKpiDO> projectCompleteYield(LocalDateTime dateTime);

   List<ProductionLoadDO> productionLoad(@Param("dateTime") LocalDateTime dateTime, @Param("factoryId") Long factoryId);

   List<CompleteProductDO> getTeamProduction(@Param("teamId") Long teamId, @Param("productType") Integer productType, @Param("dateTime") LocalDateTime dateTime);

   List<CompleteMeteByMonthDO> getTeamMeteByMonth(
      @Param("teamId") Long teamId, @Param("productType") Integer productType, @Param("dateTime") LocalDateTime dateTime
   );

   BigDecimal getMeteSummaryByCondition(
      @Param("dateTime") LocalDateTime dateTime, @Param("timeTypeEnum") Integer timeTypeEnum, @Param("taskTypeEnum") Integer taskTypeEnum
   );

   List<WorkshopMonthAndMeteDTO> getWorkshopReport(
      @Param("dateTime") LocalDateTime dateTime,
      @Param("workShopId") Long workShopId,
      @Param("productionLineId") Long productionLineId,
      @Param("type") Integer type
   );

   List<WorkshopSummaryDTO> artifactSummary(
      @Param("startTime") LocalDateTime startTime,
      @Param("endTime") LocalDateTime endTime,
      @Param("workShopId") Long workShopId,
      @Param("productionLineId") Long productionLineId,
      @Param("projectId") Long projectId
   );

   List<ProductMeteDTO> getWorkshopMete(
      @Param("type") Integer type,
      @Param("dateTime") LocalDateTime dateTime,
      @Param("workShopId") Long workShopId,
      @Param("productionLineId") Long productionLineId
   );

   List<ProductMeteDTO> getWorkshopMeteByMonthDetail(
      @Param("dateTime") LocalDateTime dateTime, @Param("workShopId") Long workShopId, @Param("productionLineId") Long productionLineId
   );

   List<MonthMeteInfo> selectProjectMonthMete(@Param("projectId") Long projectId, @Param("productType") Integer productType);

   List<MonthMeteInfo> selectMonthTotalMete(@Param("startMonth") Integer startMonth, @Param("endMonth") Integer endMonth);

   Integer selectLastProductionMonth(@Param("startMonth") Integer startMonth);

   List<ProjectMeteInfo> selectListProjectMete(@Param("year") Integer year);

   List<TaskProductionVO> getCompleteProduction(@Param("date") Date date, @Param("taskIds") List<String> taskIds);

   BigDecimal manufacturingDeptProductionLaborEfficiency(@Param("id") Long id, @Param("date") DateTime date);

   BigDecimal sumProduceTon(@Param("projectId") Long projectId);

   List<TonVO> getTechArtifactTonOfDimension(@Param("dimension") String dimension, @Param("val") int val, @Param("projectId") Long projectId);

   List<TonVO> getTechAssembleTonOfDimension(@Param("dimension") String dimension, @Param("val") int val, @Param("projectId") Long projectId);

   List<TonVO> getTechMachinePartTonOfDimension(@Param("dimension") String dimension, @Param("val") int val, @Param("projectId") Long projectId);

   List<ProcessProductionProgressVO> processProductionProgress(@Param("projectId") Long projectId);

   List<MesBuildingComplete> listCompleteByData(@Param("numberInfoDTOS") List<NumberInfoDTO> numberInfoDTOS, @Param("type") Integer type);

   List<WorkshopSummaryDTO> listArtifactSummary(
      @Param("startTime") LocalDateTime startTime,
      @Param("endTime") LocalDateTime endTime,
      @Param("workShopId") Long workShopId,
      @Param("productionLineId") Long productionLineId,
      @Param("projectId") Long projectId,
      @Param("name") String name
   );

   List<ProjectAnalysisDataDTO> findProjectAnalysisDataDTO(@Param("workShopId") Long workShopId, @Param("year") String year);

   List<ProjectSteelRearingDTO> findProjectSteelRearing(@Param("workShopId") Long workShopId, @Param("year") String year);

   List<MesBuildingWeeklyProductionReportDTO> getWeeklyProductionReportDetails(
      @Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime
   );

   List<MesBuildingWeeklyProductionReportDTO> getMonthlyProductionReportDetails();

   List<MesBuildingWeeklyProductionReportDTO> getYeaslyProductionReportDetails();

   List<ProjectInboundCurrentMonth> getProjectInboundCurrentMonth(Long workshopId, Long productionId);

   List<ProjectProductDTO> getEnclosureCompleteDetails(Long areaId);

   List<DateAndMeteDTO> getAccumulatedCompleteMeteByDate(
      @Param("dateStrList") List<String> dateStrList,
      @Param("dateQueryFormat") String dateQueryFormat,
      @Param("factoryId") Long factoryId,
      @Param("workshopId") Long workshopId,
      @Param("teamId") Long teamId
   );

   BigDecimal getYearAccumulatedCompleteMete(
      @Param("dateQueryTypeEnum") String dateQueryTypeEnum, @Param("workshopId") Long workshopId, @Param("teamId") Long teamId
   );
}
