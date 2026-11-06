package com.hzchum.scim.mes.building.core.api.service.task;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.common.core.api.pojo.common.KevMeteDO;
import com.hzchum.scim.common.core.api.pojo.common.MonthMeteInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectMeteInfo;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._do.complete.CompleteMeteByMonthDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.complete.CompleteProductDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.kpi.CompleteMeteYearDTO;
import com.hzchum.scim.mes.building.core.api.pojo._do.kpi.ProductionCompleteYieldKpiDO;
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
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.MesBuildingProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingWeeklyProductionReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.ProductMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.ResponseVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.artifactWarehouse.TonVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.manufacturingDeptProduction.TaskProductionVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.processProductionProgress.ProcessProductionProgressVO;
import com.hzchum.scim.plan.core.api.pojo.dto.ArtifactSumDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectProductDTO;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingCompleteService extends IService<MesBuildingComplete> {
   Map<String, BigDecimal> listGroupByDate(String year, String month, Integer productType, Long factoryId);

   Map<String, Object> listEnclosureGroupByDate(String month, String date, Long factoryId);

   List<KevMeteDO> listArtifactGroupByDate(String year, Long projectId);

   List<ArtifactProductionDetailDO> listArtifactByProjectIdAndMonth(Long projectId, String month);

   BigDecimal sumMeteByProjectId(Long projectId);

   BigDecimal getSumStructureCompleteMete(Long monomerId, Long areaId);

   List<ProjectProductDTO> getAreaArtifactOneCodeCompleteDetails(Long areaId, Long processId);

   ArtifactSumDTO listOneCodeByConditionsSummary(Long areaId, Long processId);

   List<MesBuildingProcessDTO> listOneCodeByConditionsProcessList(Long areaId);

   BigDecimal getSumEnclosureCompleteMete(List<Long> areaIds);

   List<ProductionAnalysisDetailsDO> getProductionByDateAndType(Long factoryId, LocalDateTime dateTime, Integer productType);

   List<ProjectProductionDO> getProjectProductionByDate(LocalDateTime dateTime);

   List<ProductionTypeAnalysisDO> productionTypeAnalysis(LocalDateTime dateTime, Integer productType);

   List<ProductionTypeAnalysisDO> productionTypeAnalysisV2(LocalDate dateTime, Integer productType, List<Long> projectIds, Long branchCompanyId);

   List<ProductionCompleteYieldKpiDO> completeYieldGropMonth(LocalDateTime dateTime);

   Map<Long, BigDecimal> completeYield(LocalDateTime dateTime, List<Long> productionLineIds);

   List<ProjectCompleteYieldKpiDO> projectCompleteYield(LocalDateTime dateTime);

   List<ProductionLoadDO> productionLoad(LocalDateTime dateTime, Long factoryId);

   List<CompleteProductDO> getTeamProduction(Long teamId, Integer productType, LocalDateTime dateTime);

   List<CompleteMeteByMonthDO> getTeamMeteByMonth(Long teamId, Integer productType, LocalDateTime dateTime);

   BigDecimal getMeteSummaryByCondition(LocalDateTime dateTime, Integer timeTypeEnum, Integer taskTypeEnum);

   List<WorkshopMonthAndMeteDTO> getWorkshopReport(LocalDateTime dateTime, Long workShopId, Long productionLineId, Integer type);

   List<WorkshopSummaryDTO> artifactSummary(LocalDateTime startTime, LocalDateTime endTime, Long workShopId, Long productionLineId, Long projectId, String name);

   WorkshopMonthAndMeteDTO meteSummaryByYear(LocalDateTime dateTime, Long workShopId, Long productionLineId);

   PageVO<WorkshopSummaryDTO> artifactSummaryPage(
      LocalDateTime startTime, LocalDateTime endTime, Long workShopId, Long productionLineId, Long projectId, String name, Integer pageNumber, Integer pageSize
   );

   PrintVO<List<Map<String, Object>>> artifactSummaryPrint(
      LocalDateTime startTime, LocalDateTime endTime, Long workShopId, Long productionLineId, Long projectId, String name
   );

   WorkshopMonthAndMeteDTO meteSummary(LocalDateTime startTime, LocalDateTime endTime, Long workShopId, Long productionLineId, Long projectId, String name);

   List<ProductMeteDTO> getWorkshopMeteByMonth(LocalDateTime dateTime, Long workShopId, Long productionLineId);

   List<ProductMeteDTO> getWorkshopMeteByMonthDetail(LocalDateTime dateTime, Long workShopId, Long productionLineId);

   List<ProductMeteDTO> getWorkshopMeteByDay(LocalDateTime dateTime, Long workShopId, Long productionLineId);

   CompleteMeteYearDTO getWorkshopMeteSummary(LocalDateTime dateTime, Long workShopId, Long productionLineId);

   List<MonthMeteInfo> listProjectMonthMete(Long projectId, Integer productType);

   List<MonthMeteInfo> listMonthTotalMete(Integer startMonth, Integer endMonth);

   Integer getLastProductionMonth(Integer startMonth);

   List<ProjectMeteInfo> listProjectMete(@Param("year") Integer year);

   List<TaskProductionVO> getCompleteProduction(Date date, List<String> taskIds);

   List<ResponseVO> manufacturingDeptProductionLaborEfficiency();

   BigDecimal sumProduceTon(Long projectId);

   List<TonVO> productAnalysis(Long projectId, String type);

   List<ProcessProductionProgressVO> processProductionProgress(Long projectId);

   List<MesBuildingComplete> listCompleteByData(List<NumberInfoDTO> numberInfoDTOS, Integer type);

   List<ProjectAnalysisDataDTO> findProjectAnalysisDataDTO(Long workShopId, String year);

   List<ProjectSteelRearingDTO> findProjectSteelRearing(Long workShopId, String year);

   List<MesBuildingWeeklyProductionReportDTO> getWeeklyProductionReportDetails(LocalDateTime StartTime, LocalDateTime EndTime);

   List<MesBuildingWeeklyProductionReportDTO> getMonthProductionReportDetails();

   List<ProjectInboundCurrentMonth> getProjectInboundCurrentMonth(Long workshopId, Long productionId);

   List<DateAndMeteDTO> getAccumulatedCompleteMeteByDate(List<String> monthStrList, String dateQueryFormat, Long factoryId, Long workshop, Long teamId);

   List<ProjectProductDTO> getEnclosureCompleteDetails(Long areaId);

   BigDecimal getYearAccumulatedCompleteMete(String dateQueryTypeEnum, Long workshopId, Long teamId);
}
