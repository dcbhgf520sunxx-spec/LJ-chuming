package com.hzchum.scim.mes.building.core.api.biz.largesreen;

import com.hzchum.scim.common.core.api.pojo.dto.DateQuantityDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.CargoRealtimeInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.InsepectSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.InspectRealtimeInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.InspectToDayInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.LargeScreenSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.MonthlyFirstPassRateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.ProjectAnalysisDataDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.ProjectInboundCurrentMonth;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.ProjectProcessingProgressDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.ProjectSteelRearingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.QhseAlertDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.QhseGroupMonthByYearSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.QhseQuantitySummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.QhseWarnToDayDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.QualityGroupSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.QualityInspectionStatisticsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.TeamProduceInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.TeamProduceRealtimeInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.TeamQhseQuantityDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.TeamQhseRankingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.WorkshopAchievementRateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.WorkshopProduceInfoDTO;
import java.time.LocalDateTime;
import java.util.List;

public interface NewLargeScreenBiz {
   LargeScreenSummaryDTO getHeaderLargeScreenSummaryDTO(String year, Long workShopId);

   List<WorkshopAchievementRateDTO> findWorkshopAchievements(Long workShopId, String year);

   List<DateQuantityDTO> findAchievementGroupWorkshop(String year);

   List<TeamQhseQuantityDTO> findTeamQhseQuantity(Long workShopId, String year);

   List<QhseQuantitySummaryDTO> findQhseQuantityGroupQhseType(Long workShopId, String year);

   List<QhseWarnToDayDTO> findQhseWarnToDay(Long workShopId);

   List<ProjectAnalysisDataDTO> findProjectAnalysisDataDTO(Long workShopId, String year);

   List<ProjectSteelRearingDTO> findProjectSteelRearing(Long workshopId, String year);

   TeamProduceRealtimeInfoDTO findTeamProjectProduceInfo(LocalDateTime date, Long workShopId, Long productionId);

   List<TeamProduceInfoDTO> findTeamProduceInfo(LocalDateTime date, Long workShopId, Long productionId);

   List<WorkshopProduceInfoDTO> findWorkshopProjectProduceInfo(LocalDateTime date, Long workShopId, Long productionId);

   List<ProjectProcessingProgressDTO> projectProcessingProgress(LocalDateTime date, Long workShopId, Long productionId);

   List<ProjectInboundCurrentMonth> getProjectInboundCurrentMonth(Long workshopId, Long productionId);

   List<InspectRealtimeInfoDTO> findInspectRealtimeInfo(Long workShopId, Long productionId);

   List<CargoRealtimeInfoDTO> findCargoRealtimeInfo();

   InsepectSummaryDTO findInsepectSummary(LocalDateTime date);

   InspectToDayInfoDTO findInspectReportRealtime(Long workShopId);

   List<QualityGroupSummaryDTO> findQualityGroupSummary(LocalDateTime date);

   List<QhseGroupMonthByYearSummaryDTO> findQualityGroupMonthByYear(LocalDateTime date);

   List<MonthlyFirstPassRateDTO> findMonthlyFirstPassRate(LocalDateTime date);

   List<QhseAlertDTO> findQuailyQhseAlert();

   List<QhseAlertDTO> findQuailyQhsePassAlert();

   List<QualityInspectionStatisticsDTO> findQualityInspectionStatistics(LocalDateTime date);

   List<TeamQhseRankingDTO> findTeamQhseRanking(LocalDateTime date);
}
