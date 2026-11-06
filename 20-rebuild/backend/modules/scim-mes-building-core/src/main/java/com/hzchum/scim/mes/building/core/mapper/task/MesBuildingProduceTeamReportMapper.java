package com.hzchum.scim.mes.building.core.mapper.task;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.common.KevMeteDO;
import com.hzchum.scim.common.core.api.pojo.dto.DateQuantityDTO;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.ProduceAbonrmalReportDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.ProduceInspectionTeamReportDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.ProduceTeamReportDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.ReportRecordNumbersV2DO;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.ReportSourceDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.YearMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MesBuildingArtifactTaskProcessDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.DistributionDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.DistributionProcessDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.OutStaffDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.ReckonPriceDetailDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.ReckonPriceTeamDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingProduceTeamReport;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.ProjectProductionStatistics.MesDailyProductionTaskDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.wages.OutStaffDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.wages.PriceDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.wages.get.PriceDetailsDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.InspectRealtimeInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.TeamProduceInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.WorkshopProduceInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.ProjectProductionStatistics.MesDailyProductionQuerySumDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.ProjectProductionStatistics.MesTeamReportProductStaticsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.app.DateAndCount;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.produceTeamRecourseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ArtifactReportSourceDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.DateMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.LastProcessInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.NewArtifactReportSourceDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProduceTeamReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProductProduceCargoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProductTeamSummaryDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProjectMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ReportRecordV2DTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.TeamReportRealTimeInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.UserProductionDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.UserProductionSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.productTeamSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingNestCutPlateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingQualityInspectionDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingReportNumberStatusDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.team.BatchInspectDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.team.TeamProduceOperateAnalyseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.team.TeamProduceOperateAnalyseDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.team.TeamProduceProcessDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.team.TeamProduceProcessInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingProduceTeamReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wages.PriceDTOParam;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingProduceTeamReportMapper extends BaseMapper<MesBuildingProduceTeamReport> {
   List<ProduceTeamReportDO> listByCondition(
      @Param("date") String date,
      @Param("taskId") Long taskId,
      @Param("productId") Long productId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("teamId") Long teamId,
      @Param("reportType") Integer reportType,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("workshopId") Long workshopId,
      @Param("productLineId") Long productLineId,
      @Param("factoryId") Long factoryId,
      @Param("serialNumber") String serialNumber
   );

   List<ProduceTeamReportDO> unInspectionListByCondition(
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("workshopId") Long workshopId,
      @Param("productLineId") Long productLineId,
      @Param("teamIdList") List<Long> teamIdList,
      @Param("serialNumber") String serialNumber
   );

   List<ProduceTeamReportDO> unInspectionListByCondition2(
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("workshopId") Long workshopId,
      @Param("productLineId") Long productLineId,
      @Param("teamIdList") List<Long> teamIdList,
      @Param("serialNumber") String serialNumber
   );

   List<ProduceInspectionTeamReportDO> inspectionListByCondition(
      @Param("date") String date,
      @Param("taskId") Long taskId,
      @Param("productId") Long productId,
      @Param("teamId") Long teamId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("boolAdoptEnum") Boolean boolAdoptEnum,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("workshopId") Long workshopId,
      @Param("productLineId") Long productLineId,
      @Param("factoryId") Long factoryId,
      @Param("serialNumber") String serialNumber
   );

   List<ProduceAbonrmalReportDO> reportList(
      @Param("productId") Long productId,
      @Param("productType") Integer productType,
      @Param("taskId") Long taskId,
      @Param("processIdList") List<Long> processIdList
   );

   DistributionDO getComplete(PriceDTOParam copy);

   List<OutStaffDO> outStaffWageList(OutStaffDOParam doParam);

   List<ReckonPriceTeamDO> getTeamMate(PriceDOParam doParam);

   List<ReckonPriceDetailDO> getTeamMateDetails(PriceDetailsDOParam copy);

   List<DistributionProcessDO> getProcessPrice(PriceDOParam copy);

   BigDecimal getProcessPriceSummary(PriceDOParam copy);

   List<ReportSourceDO> reportSourceList(@Param("id") Long id, @Param("prodcutType") Integer prodcutType);

   List<MesBuildingArtifactTaskProcessDO> artifactTaskList(
      @Param("previousTaskProcessId") Long previousTaskProcessId, @Param("taskProcessId") Long taskProcessId, @Param("number") Long number
   );

   List<MesBuildingArtifactTaskProcessDO> artifactTaskLogList(
      @Param("previousTaskProcessId") Long previousTaskProcessId, @Param("taskProcessId") Long taskProcessId, @Param("number") Long number
   );

   List<MesBuildingArtifactTaskProcessDO> artifactTaskLogLists(
      @Param("previousTaskProcessIds") List<Long> previousTaskProcessIds, @Param("taskProcessId") Long taskProcessId, @Param("number") Long number
   );

   List<MesBuildingArtifactTaskProcessDO> artifactInspectionTaskList(
      @Param("taskProcessId") Long taskProcessId, @Param("number") Long number, @Param("teamId") Long teamId
   );

   List<MesBuildingReportNumberStatusDTO> artifactNumberStatusList(
      @Param("productId") Long productId, @Param("taskId") Long taskId, @Param("taskTypeEnum") Integer taskTypeEnum, @Param("areaId") Long areaId
   );

   List<ProduceTeamReportDO> listByConditionBydate(
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("taskId") Long taskId,
      @Param("processId") Long processId,
      @Param("productId") Long productId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("teamIds") List<Long> teamIds,
      @Param("reportType") Integer reportType,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("areaBatchId") Long areaBatchId,
      @Param("workshopId") Long workshopId,
      @Param("productLineId") Long productLineId,
      @Param("factoryId") Long factoryId,
      @Param("serialNumber") String serialNumber,
      @Param("userId") Long userId,
      @Param("boolMarked") Boolean boolMarked
   );

   List<ProduceInspectionTeamReportDO> inspectionListByConditionByDate(
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("taskId") Long taskId,
      @Param("processId") Long processId,
      @Param("productId") Long productId,
      @Param("teamId") Long teamId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("boolAdoptEnum") Boolean boolAdoptEnum,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("areaBatchId") Long areaBatchId,
      @Param("workshopId") Long workshopId,
      @Param("productLineId") Long productLineId,
      @Param("factoryId") Long factoryId,
      @Param("serialNumber") String serialNumber,
      @Param("userId") Long userId
   );

   List<MesBuildingNestCutPlateDTO> teamReportNestCutPlateList(
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("processType") Integer processType,
      @Param("groupsIds") Set<Long> groupsIds
   );

   List<ProduceTeamReportDTO> teamReportMachinePartList(
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("processType") Integer processType,
      @Param("serialNumber") String serialNumber,
      @Param("projectId") Long projectId,
      @Param("cutId") Long cutId
   );

   List<ArtifactReportSourceDTO> artifactSourceReportProductList(
      @Param("productId") Long productId, @Param("number") Integer number, @Param("taskId") Long taskId
   );

   List<NewArtifactReportSourceDTO> newArtifactSourceReportProductList(
      @Param("productId") Long productId, @Param("taskTypeEnum") Integer taskTypeEnum, @Param("number") Integer number
   );

   List<YearMeteDO> getMeteByYear(
      @Param("dateTime") LocalDateTime dateTime, @Param("processTypeEnum") Integer processTypeEnum, @Param("projectId") Long projectId
   );

   List<productTeamSummaryDTO> productTeamSummaryReport(
      @Param("workshopId") Long workshopId,
      @Param("projectId") Long projectId,
      @Param("processId") Long processId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate
   );

   List<productTeamSummaryDTO> productTeamSummaryReportV2(
      @Param("workshopId") Long workshopId,
      @Param("projectId") Long projectId,
      @Param("projectIds") List<Long> projectIds,
      @Param("processId") Long processId,
      @Param("teamIds") List<Long> teamIds,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("taskReportTypeEnum") Integer taskReportTypeEnum
   );

   List<ProductTeamSummaryDetailDTO> productTeamSummaryReportDetailList(
      @Param("workshopId") Long workshopId,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("areaBatchId") Long areaBatchId,
      @Param("groupsId") Long groupsId,
      @Param("teamId") Long teamId,
      @Param("processId") Long processId,
      @Param("serialNumber") String serialNumber,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate
   );

   List<ProductTeamSummaryDetailDTO> productTeamSummaryReportDetailListV2(
      @Param("workshopId") Long workshopId,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("areaBatchId") Long areaBatchId,
      @Param("groupsId") Long groupsId,
      @Param("teamId") Long teamId,
      @Param("processId") Long processId,
      @Param("serialNumber") String serialNumber,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("taskReportTypeEnum") Integer taskReportTypeEnum
   );

   List<ProductTeamSummaryDetailDTO> productTeamSummaryReportDetailListPrint(
      @Param("workshopId") Long workshopId,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("groupsId") Long groupsId,
      @Param("teamId") Long teamId,
      @Param("teamIds") Long teamIds,
      @Param("processId") Long processId,
      @Param("serialNumber") String serialNumber,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("taskReportTypeEnum") Integer taskReportTypeEnum
   );

   List<produceTeamRecourseDTO> listproduceTeamByProcessIdAndProductIdAndType(
      @Param("processId") Long processId, @Param("productId") Long productId, @Param("type") Integer type, @Param("groupIds") List<Long> groupIds
   );

   List<produceTeamRecourseDTO> listproduceInfo(
      @Param("processIds") List<Long> processIds,
      @Param("productId") Long productId,
      @Param("type") Integer type,
      @Param("assitLinesIds") List<Long> assitLinesIds
   );

   List<produceTeamRecourseDTO> listProduceInfoByTypeAndNumber(
      @Param("processIds") List<Long> processIds,
      @Param("productId") Long productId,
      @Param("type") Integer type,
      @Param("assitLinesIds") List<Long> assitLinesIds,
      @Param("assembleNumberList") List<Integer> assembleNumberList
   );

   KevMeteDO inspectionTeamReportListSummary(
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("userId") Long userId
   );

   KevMeteDO teamReportListSummary(
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("userId") Long userId
   );

   KevMeteDO teamReportMachinePartListSummary(
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("processType") Integer processTyp,
      @Param("cutId") Long cutId
   );

   Integer findAnnualTotal(@Param("year") Integer year, @Param("processId") Long processId, @Param("userId") Long userId);

   Integer findLastMonthTotal(@Param("processId") Long processId, @Param("userId") Long userId);

   Integer findCurrentMonthTotal(@Param("processId") Long processId, @Param("userId") Long userId);

   Integer findCurrentProjects(@Param("processId") Long processId, @Param("userId") Long userId);

   Integer findCurrentIncomplete(@Param("processId") Long processId, @Param("userId") Long userId);

   Integer findCurrentIncompleteOnAssist(@Param("processId") Long processId, @Param("userId") Long userId);

   Integer findYesterdayTotal(@Param("processId") Long processId, @Param("userId") Long userId);

   Integer findTodayTotal(@Param("processId") Long processId, @Param("userId") Long userId);

   List<DateAndCount> getMonthlyOutputByYear(@Param("year") Integer year, @Param("processId") Long processId, @Param("userId") Long userId);

   MesBuildingProduceTeamReportDTO getTeamReportPrint(Long id);

   List<ReportRecordV2DTO> listReportDataByDate(
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("taskId") Long taskId,
      @Param("taskProcessId") Long taskProcessId,
      @Param("processId") Long processId,
      @Param("productId") Long productId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("groupId") Long groupId,
      @Param("teamIds") List<Long> teamIds,
      @Param("reportType") Integer reportType,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("workshopId") Long workshopId,
      @Param("productLineId") Long productLineId,
      @Param("factoryId") Long factoryId,
      @Param("serialNumber") String serialNumber,
      @Param("boolAll") Boolean boolAll
   );

   List<ReportRecordV2DTO> listReportDataByDate2(
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("taskId") Long taskId,
      @Param("taskProcessId") Long taskProcessId,
      @Param("processId") Long processId,
      @Param("productId") Long productId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("teamIds") List<Long> teamIds,
      @Param("reportType") Integer reportType,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("areaBatchId") Long areaBatchId,
      @Param("workshopId") Long workshopId,
      @Param("productLineId") Long productLineId,
      @Param("factoryId") Long factoryId,
      @Param("serialNumber") String serialNumber,
      @Param("boolAll") Boolean boolAll
   );

   List<ReportRecordV2DTO> listBatchReportDataByDate2List(@Param("dtos") List<BatchInspectDTO> dtos, @Param("taskTypeEnum") Integer taskTypeEnum);

   List<ReportRecordNumbersV2DO> listReportNumbers(@Param("recNumers") List<ReportRecordNumbersV2DO> recNumers);

   List<ReportRecordNumbersV2DO> listNeedInspectData(
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("taskId") Long taskId,
      @Param("taskProcessId") Long taskProcessId,
      @Param("processId") Long processId,
      @Param("productId") Long productId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("groupId") Long groupId,
      @Param("teamIds") List<Long> teamIds,
      @Param("reportType") Integer reportType,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("workshopId") Long workshopId,
      @Param("productLineId") Long productLineId,
      @Param("factoryId") Long factoryId,
      @Param("serialNumber") String serialNumber,
      @Param("boolAll") Boolean boolAll
   );

   List<MesBuildingProduceTeamReport> listReports(@Param("numberInfos") List<NumberInfoDTO> numberInfos, @Param("taskType") Integer taskType);

   List<MesBuildingReportNumberStatusDTO> listStatusBydata(
      @Param("dtos") List<ProductProduceCargoDTO> dtos,
      @Param("taskType") Integer taskType,
      @Param("areaId") Long areaId,
      @Param("monomerId") Long monomerId,
      @Param("projectId") Long projectId
   );

   Boolean existTeamId(@Param("teamId") Long teamId);

   List<TeamReportRealTimeInfoDTO> productTeamReportAvgInfo(@Param("workshopId") Long workshopId);

   List<TeamReportRealTimeInfoDTO> productTeamReportRealTimeInfo(@Param("workshopId") Long workshopId);

   List<LastProcessInfoDTO> lastProcessInfo(@Param("taskNumberMap") Map<Long, List<Integer>> taskNumberMap);

   List<LastProcessInfoDTO> lastProcessBatchInfo(@Param("taskNumberMap") Map<Long, List<Integer>> taskNumberMap);

   List<TeamProduceProcessInfoDTO> findEachTeamProduceInfo(
      @Param("workshopId") Long workshopId,
      @Param("projectId") Long projectId,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate
   );

   List<TeamProduceProcessDetailDTO> findEachTeamProduceDetail(
      @Param("workshopId") Long workshopId,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("teamId") Long teamId,
      @Param("processId") Long processId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate
   );

   List<NewArtifactReportSourceDTO> ArtifactSourceInspectReportProductList(
      @Param("productId") Long productId, @Param("taskTypeEnum") Integer taskTypeEnum, @Param("number") Integer number
   );

   List<TeamProduceProcessInfoDTO> findEachTeamProduceInfoV2(
      @Param("workshopId") Long workshopId,
      @Param("projectId") Long projectId,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate
   );

   List<TeamProduceProcessDetailDTO> findEachTeamProduceDetailV2(
      @Param("workshopId") Long workshopId,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("teamId") Long teamId,
      @Param("processId") Long processId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate
   );

   List<DateQuantityDTO> findAchievementGroupWorkshop(@Param("date") LocalDate date);

   List<MesBuildingQualityInspectionDTO> getQualityInspectionTimingDetails(@Param("teamReportIds") List<Long> teamReportIds);

   List<MesBuildingQualityInspectionDTO> getQualityInspectionDefiniteNumberDetails();

   List<TeamProduceInfoDTO> findTeamProjectProduceInfo(@Param("year") int year, @Param("workShopId") Long workShopId, Long productionId);

   List<WorkshopProduceInfoDTO> findWorkshopProjectProduceInfo(@Param("year") Integer year, @Param("workShopId") Long workShopId, Long productionId);

   List<WorkshopProduceInfoDTO> findWorkshopProjectProduceInfoV2(@Param("year") Integer year, @Param("workShopId") Long workShopId, Long productionId);

   List<InspectRealtimeInfoDTO> findInspectRealtimeInfo(Long workShopId, Long productionId);

   List<MesDailyProductionQuerySumDTO> getMesDailyProductionTaskSum(MesDailyProductionTaskDOParam param);

   List<MesDailyProductionQuerySumDTO> getProductionDetail(
      @Param("projectId") Long projectId,
      @Param("workShopId") Long workShopId,
      @Param("teamId") Long teamId,
      @Param("monomerId") Long monomerId,
      @Param("dateTime") LocalDateTime dateTime,
      @Param("processId") Long processId,
      @Param("meteUnitEnum") Integer meteUnitEnum,
      @Param("productionLineIds") List<Long> productionLineIds
   );

   List<ProductTeamSummaryDetailDTO> productTeamSummaryReportDetailListPrint(
      @Param("workshopId") Long workshopId,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("groupsId") Long groupsId,
      @Param("teamId") Long teamId,
      @Param("teamIds") List<Long> teamIds,
      @Param("processId") Long processId,
      @Param("serialNumber") String serialNumber,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("taskReportTypeEnum") Integer taskReportTypeEnum
   );

   List<ArtifactReportSourceDTO> assembleSourceReportProductList(
      @Param("productId") Long productId, @Param("number") Integer number, @Param("taskId") Long taskId
   );

   List<MesTeamReportProductStaticsDTO> getTeamReportProductList(
      @Param("productType") Integer productType,
      @Param("workshopId") Long workShopId,
      @Param("productionLineId") Long productionLineId,
      @Param("teamId") Long teamId,
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("areaId") Long areaId,
      @Param("areaBatchId") Long areaBatchId,
      @Param("processId") Long processId,
      @Param("serialNumber") String serialNumber,
      @Param("dateTimeList") List<LocalDateTime> dateTimeList
   );

   List<DateMeteDTO> getMeteByYearV2(
      @Param("dateTime") LocalDateTime dateTime,
      @Param("processTypeEnum") Integer processTypeEnum,
      @Param("branchCompanyId") Long branchCompanyId,
      @Param("workshopId") Long workshopId
   );

   List<DateMeteDTO> getProductionSummary(List<Long> projectIds, LocalDate year, Integer nowYear, Long branchCompanyId, Long workshopId);

   List<DateMeteDTO> getProductionMonthly(LocalDate year, Long branchCompanyId, Long workshopId);

   List<DateMeteDTO> getProductionMonthlyV2(List<Long> projectIds, LocalDate startDate, LocalDate endDate, Long branchCompanyId, Long workshopId);

   List<DateMeteDTO> getProductionGroupMonth(Long projectId, LocalDate year, Long branchCompanyId, Integer taskTypeEnum);

   List<DateMeteDTO> getNumbersMonthly(List<Long> projectIds, LocalDate startDate, LocalDate endDate, Long branchCompanyId, Long workshopId);

   List<DateMeteDTO> getNumbersYear(List<Long> projectIds, LocalDate year, Integer nowYear, Long branchCompanyId, Long workshopId);

   List<DateMeteDTO> getProductionDay(List<Long> projectIds, LocalDate yearDate, LocalDate mouthDate, Long branchCompanyId, Long workshopId);

   List<ProjectMeteDTO> getProjectMete(List<Long> projectIds, LocalDate dateTime, Long branchCompanyId, Long workshopId, Boolean isMonthly);

   List<DateMeteDTO> getSchedulingMonthly(List<Long> projectIds, LocalDate year, Long branchCompanyId, Long workshopId);

   List<DateMeteDTO> getYearSchedulingProductionInfo(List<Long> projectIds, LocalDate year, Long branchCompanyId, Long workshopId);

   List<DateMeteDTO> getYearSchedulingProductionInfoV2(List<Long> projectIds, LocalDate year, Long branchCompanyId, Long workshopId);

   List<ProjectMeteDTO> getProjectSchedulingProductionInfo(List<Long> projectIds, LocalDate yearMonth, Long branchCompanyId, Long workshopId);

   List<ProjectMeteDTO> getProjectSchedulingProductionInfoV2(List<Long> projectIds, LocalDate yearMonth, Long branchCompanyId, Long workshopId);

   List<TeamProduceOperateAnalyseDTO> getTeamProduceOperateAnalyse(
      List<Long> projectIds, LocalDate dateTime, Long branchCompanyId, Long workshopId, Long processId
   );

   List<TeamProduceOperateAnalyseDetailsDTO> getTeamProduceDetailsOperateAnalyse(
      List<Long> projectIds,
      LocalDate yearDate,
      LocalDate startDate,
      LocalDate endDate,
      Long branchCompanyId,
      Long workshopId,
      Long teamId,
      Integer taskTypeEnum,
      Long processId
   );

   List<DateMeteDTO> getProductionYear(List<LocalDate> dateList, Long branchCompanyId, Long workshopId);

   List<UserProductionSummaryDTO> UserProductionSummary(
      @Param("projectId") Long projectId,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate
   );

   List<UserProductionDetailDTO> UserProductionDetailList(
      @Param("projectId") Long projectId,
      @Param("monomerId") Long monomerId,
      @Param("serialNumber") String serialNumber,
      @Param("taskTypeEnum") Integer taskTypeEnum,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("userId") Long userId
   );

   List<TeamReportRealTimeInfoDTO> getCurrentMonthScheduledOutput(
      @Param("workshopId") Long workshopId, @Param("monthStart") LocalDateTime monthStart, @Param("monthEnd") LocalDateTime monthEnd
   );
}
