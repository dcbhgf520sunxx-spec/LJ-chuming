package com.hzchum.scim.mes.building.core.api.service.task;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.dto.DateQuantityDTO;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.ReportSourceDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.YearMeteDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.task.MesBuildingArtifactTaskProcessDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
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
import com.hzchum.scim.mes.building.core.api.pojo._dto.process.MesBuildingProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.TeamCapacityAnalysisDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban.produceTeamRecourseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ArtifactReportSourceDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.DateMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.LastProcessInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.NewArtifactReportSourceDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProcessKanBanAndQuantityDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProduceAbonrmalReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProduceInspectionTeamReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProduceTeamReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProductProduceCargoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProductTeamSummaryDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProductTeamSummaryDetailEnhanceDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ProjectMeteDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.ReportRecordV2DTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.TeamReportRealTimeInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.UserProductionDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.UserProductionSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.productTeamSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingNestCutPlateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingQualityInspectionDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingReportNumberStatusDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.AppTeamReportDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.team.BatchInspectDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.team.TeamProduceOperateAnalyseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.team.TeamProduceOperateAnalyseDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.team.TeamProduceProcessDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.team.TeamProduceProcessInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingProduceTeamReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wages.PriceDTOParam;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingProduceTeamReportService extends IService<MesBuildingProduceTeamReport> {
   List<ProduceTeamReportDTO> listByCondition(
      String date,
      Long taskId,
      Long productId,
      Integer productType,
      Long teamId,
      Integer reportType,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      Long productLineId,
      Long factoryId,
      String serialNumber
   );

   PageVO<ProduceTeamReportDTO> pageByCondition(
      String date,
      Long taskId,
      Long productId,
      Integer taskTypeEnum,
      Long teamId,
      Integer reportType,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      Long productLineId,
      Long factoryId,
      String serialNumber,
      Integer pageNumber,
      Integer pageSize
   );

   Integer unInspectionCun(Integer taskTypeEnum);

   Integer unInspectionCun2(Integer taskTypeEnum);

   List<ProduceTeamReportDTO> unInspectionListByCondition(
      Integer taskTypeEnum, Long projectId, Long monomerId, Long areaId, Long workshopId, Long productLineId, String serialNumber
   );

   PageVO<ProduceTeamReportDTO> unInspectionPageByCondition(
      Integer taskTypeEnum,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      Long productLineId,
      String serialNumber,
      Integer pageNumber,
      Integer pageSize
   );

   List<ProduceInspectionTeamReportDTO> inspectionListByCondition(
      String date,
      Long taskId,
      Long productId,
      Long teamId,
      Integer productType,
      Boolean boolAdoptEnum,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      Long productLineId,
      Long factoryId,
      String serialNumber
   );

   PageVO<ProduceInspectionTeamReportDTO> inspectionPageByCondition(
      String date,
      Long taskId,
      Long productId,
      Long teamId,
      Integer taskTypeEnum,
      Boolean boolAdoptEnum,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      Long productLineId,
      Long factoryId,
      String serialNumber,
      Integer pageNumber,
      Integer pageSize
   );

   List<ProduceAbonrmalReportDTO> reportList(Long productId, Integer productType, Long taskId, List<Long> processIdList);

   DistributionDO getComplete(PriceDTOParam copy);

   List<OutStaffDO> outStaffWageList(OutStaffDOParam doParam);

   List<ReckonPriceTeamDO> getTeamMate(PriceDOParam doParam);

   List<ReckonPriceDetailDO> getTeamMateDetails(PriceDetailsDOParam doParam);

   BigDecimal getProcessPriceSummary(PriceDOParam copy);

   List<DistributionProcessDO> getProcessPrice(PriceDOParam copy);

   List<ReportSourceDO> reportSourceList(Long id, Integer prodcutType);

   List<MesBuildingArtifactTaskProcessDO> artifactTaskList(Long previousTaskProcessId, Long taskProcessId, Long number);

   List<MesBuildingArtifactTaskProcessDO> artifactTaskLogList(Long previousTaskProcessId, Long taskProcessId, Long number);

   List<MesBuildingArtifactTaskProcessDO> artifactTaskLogLists(List<Long> previousTaskProcessIds, Long taskProcessId, Long number);

   List<MesBuildingArtifactTaskProcessDO> artifactInspectionTaskList(Long taskProcessId, Long number, Long teamId);

   PageVO<ProduceTeamReportDTO> pageByConditionByDate(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long taskId,
      Long processId,
      Long productId,
      Integer taskTypeEnum,
      Long teamId,
      Integer reportType,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long workshopId,
      Long productLineId,
      Long factoryId,
      String serialNumber,
      Boolean boolAll,
      Boolean isCurrentUser,
      Boolean boolMarkedInteger,
      Integer pageNumber,
      Integer pageSize
   );

   PageVO<ProduceInspectionTeamReportDTO> inspectionPageByConditionByDate(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long taskId,
      Long processId,
      Long productId,
      Long teamId,
      Integer taskTypeEnum,
      Boolean boolAdoptEnum,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long workshopId,
      Long productLineId,
      Long factoryId,
      String serialNumber,
      Boolean isCurrentUser,
      Integer pageNumber,
      Integer pageSize
   );

   Map teamReportListSummary(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long taskId,
      Long processId,
      Long productId,
      Integer taskTypeEnum,
      Long teamId,
      Integer reportType,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long workshopId,
      Long productLineId,
      Long factoryId,
      String serialNumber,
      Boolean isCurrentUser,
      Integer pageNumber,
      Integer pageSize
   );

   Map inspectionTeamReportListSummary(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long taskId,
      Long processId,
      Long productId,
      Long teamId,
      Integer taskTypeEnum,
      Boolean boolAdoptEnum,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long workshopId,
      Long productLineId,
      Long factoryId,
      String serialNumber,
      Boolean isCurrentUser,
      Integer pageNumber,
      Integer pageSize
   );

   PageVO pageTeamReportNestCutPlateList(
      LocalDateTime startDate, LocalDateTime endDate, Integer taskTypeEnum, Integer processType, Integer pageNumber, Integer pageSize
   );

   List<MesBuildingNestCutPlateDTO> teamReportNestCutPlateList(
      LocalDateTime startDate, LocalDateTime endDate, Integer taskTypeEnum, Integer processType, Set<Long> groupsId
   );

   PageVO<ProduceTeamReportDTO> pageTeamReportMachinePartList(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer taskTypeEnum,
      Integer processType,
      String serialNumber,
      Long projectId,
      Long cutId,
      Integer pageNumber,
      Integer pageSize
   );

   List<ProduceTeamReportDTO> teamReportMachinePartList(
      LocalDateTime startDate, LocalDateTime endDate, Integer taskTypeEnum, Integer processType, String serialNumber, Long projectId, Long cutId
   );

   Map teamReportMachinePartListSummary(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer taskTypeEnum,
      Integer processType,
      String serialNumber,
      Long projectId,
      Long cutId,
      Integer pageNumber,
      Integer pageSize
   );

   List<ArtifactReportSourceDTO> artifactSourceReportProductList(Long productId, Integer number, Long taskId);

   List<NewArtifactReportSourceDTO> newArtifactSourceReportProductList(Long productId, Integer taskTypeEnum, Integer number);

   List<NewArtifactReportSourceDTO> ArtifactSourceInspectReportProductList(Long productId, Integer taskTypeEnum, Integer number);

   List<YearMeteDO> getMeteByYear(LocalDateTime dateTime, Integer processTypeEnum, Long projectId);

   List<DateMeteDTO> getMeteByYearV2(LocalDateTime dateTime, Integer processTypeEnum, Long branchCompanyId, Long workshopId);

   List<productTeamSummaryDTO> productTeamSummaryReport(
      Long workshopId, Long projectId, Long processId, Integer taskTypeEnum, LocalDateTime startDate, LocalDateTime endDate
   );

   List<productTeamSummaryDTO> productTeamSummaryReportV2(
      Long workshopId,
      Long projectId,
      Long processId,
      List<Long> teamIds,
      Integer taskTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer taskReportTypeEnum
   );

   void productTeamSummaryReportDownload(
      Long workshopId,
      Long projectId,
      Long processId,
      List<Long> teamIds,
      Integer taskTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer taskReportTypeEnum,
      HttpServletResponse response
   ) throws IOException;

   PageVO<ProductTeamSummaryDetailDTO> productTeamSummaryReportDetailPage(
      Long workshopId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long groupsId,
      Long teamId,
      Long processId,
      String serialNumber,
      Integer taskTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer pageNumber,
      Integer pageSize
   );

   ProductTeamSummaryDetailEnhanceDTO productTeamSummaryReportDetailPageV2(
      Long workshopId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long groupsId,
      Long teamId,
      Long processId,
      String serialNumber,
      Integer taskTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer taskReportTypeEnum,
      Integer pageNumber,
      Integer pageSize
   );

   List<ProductTeamSummaryDetailDTO> productTeamSummaryReportDetailList(
      Long workshopId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long groupsId,
      Long teamId,
      Long processId,
      String serialNumber,
      Integer taskTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate
   );

   List<MesBuildingProcessDTO> getWorkshopByProcessList(Long workshopId);

   List<MesBuildingProcessDTO> getWorkshopByProcessListV2(Long workshopId);

   PrintVO<List<Map<String, Object>>> productTeamSummaryReportDetailPrint(
      Long workshopId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long groupsId,
      Long teamId,
      Long processId,
      String serialNumber,
      Integer taskTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer taskReportTypeEnum
   );

   AppTeamReportDetailsDTO teamReportDetailList(Long id);

   MesBuildingProduceTeamReportDTO getTeamReportPrint(Long id);

   List<produceTeamRecourseDTO> listproduceTeamByProcessIdAndProductIdAndType(Long processId, Long productId, Integer type, List<Long> groupId);

   ProcessKanBanAndQuantityDTO processProduceKanban(Long teamId, Long processId, Long groupsId);

   List<produceTeamRecourseDTO> listproduceInfo(List<Long> processId, Long productId, Integer taskTypeEnum, List<Long> assitLinesIds);

   List<produceTeamRecourseDTO> listProduceInfoByTypeAndNumber(
      List<Long> processIds, Long productId, Integer type, List<Long> assitLinesIds, List<Integer> assembleNumberList
   );

   Integer findAnnualTotal(Integer year, Long processId, Long userId);

   Integer findLastMonthTotal(Long processId, Long userId);

   Integer findCurrentMonthTotal(Long processId, Long userId);

   Integer findCurrentProjects(Long processId, Long userId);

   Integer findCurrentIncomplete(Long processId, Long userId);

   Integer findCurrentIncompleteOnAssist(Long processId, Long userId);

   Integer findYesterdayTotal(Long processId, Long userId);

   Integer findTodayTotal(Long processId, Long userId);

   List<DateAndCount> getMonthlyOutputByYear(Integer year, Long processId, Long userId);

   List<ProjectDetailDO> projectConditionList(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long taskId,
      Long processId,
      Long productId,
      Integer taskTypeEnum,
      Long teamId,
      Integer reportType,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBathId,
      Long workshopId,
      Long productLineId,
      Long factoryId,
      String serialNumber,
      Boolean boolAll
   );

   PageVO<ReportRecordV2DTO> pageByConditionByDateV2(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long taskId,
      Long taskProcessId,
      Long processId,
      Long productId,
      Integer taskTypeEnum,
      Long groupId,
      Long teamId,
      Integer reportType,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long workshopId,
      Long productLineId,
      Long factoryId,
      String serialNumber,
      Boolean boolAll,
      Integer pageNumber,
      Integer pageSize
   );

   PageVO<ReportRecordV2DTO> pageByConditionByDateV3(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long taskId,
      Long taskProcessId,
      Long processId,
      Long productId,
      Integer taskTypeEnum,
      Long groupId,
      Long teamId,
      Integer reportType,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long workshopId,
      Long productLineId,
      Long factoryId,
      String serialNumber,
      Boolean boolAll,
      Boolean boolBatch,
      Integer pageNumber,
      Integer pageSize
   );

   List<MesBuildingProduceTeamReport> listReports(List<NumberInfoDTO> numberInfos, Integer taskType);

   List<MesBuildingReportNumberStatusDTO> listStatusBydata(List<ProductProduceCargoDTO> dtos, Integer taskType, Long areaId, Long monomerId, Long projectId);

   List<TeamReportRealTimeInfoDTO> productTeamReportRealTimeInfo(Long workshopId);

   List<LastProcessInfoDTO> lastProcessInfo(Map<Long, List<Integer>> taskNumberMap);

   List<LastProcessInfoDTO> lastProcessBatchInfo(Map<Long, List<Integer>> taskNumberMap);

   List<TeamProduceProcessInfoDTO> findEachTeamProduceInfo(Long workshopId, Long projectId, LocalDateTime startDate, LocalDateTime endDate);

   List<TeamProduceProcessDetailDTO> findEachTeamProduceDetail(
      Long workshopId, Long projectId, Long monomerId, Long areaId, Long teamId, Long processId, LocalDateTime startDate, LocalDateTime endDate
   );

   List<TeamCapacityAnalysisDTO> findTeamCapacityAnalysis(Long workShopId, LocalDateTime date);

   PageVO<TeamCapacityAnalysisDTO> findTeamCapacityAnalysisV2(Long workShopId, LocalDateTime date, Integer pageNumber, Integer pageSize);

   PrintVO<List<Map<String, Object>>> findEachTeamProduceDetailPrint(
      Long workshopId, Long projectId, Long monomerId, Long areaId, Long teamId, Long processId, LocalDateTime startDate, LocalDateTime endDate
   );

   void findTeamCapacityAnalysisDownload(Long workShopId, LocalDateTime date);

   List<DateQuantityDTO> findAchievementGroupWorkshop(LocalDate date);

   List<MesBuildingQualityInspectionDTO> getQualityInspectionDetails(List<Long> teamReportIds);

   List<MesBuildingQualityInspectionDTO> getQualityInspectionDefiniteNumberDetails();

   List<TeamProduceInfoDTO> findTeamProjectProduceInfo(int year, Long workShopId, Long productionId);

   List<WorkshopProduceInfoDTO> findWorkshopProjectProduceInfo(Integer year, Long workShopId, Long productionId);

   List<InspectRealtimeInfoDTO> findInspectRealtimeInfo(Long workShopId, Long productionId);

   List<MesDailyProductionQuerySumDTO> getMesDailyProductionTaskSum(MesDailyProductionTaskDOParam param);

   List<MesDailyProductionQuerySumDTO> getProductionDetail(
      Long projectId, Long workShopId, Long teamId, Long monomerId, LocalDateTime dateTime, Long processId, Integer meteUnitEnum, List<Long> productionLineIds
   );

   List<ArtifactReportSourceDTO> assembleSourceReportProductList(Long productId, Integer number, Long taskId);

   List<ReportRecordV2DTO> listBatchReportDataByDate2List(@Param("dtos") List<BatchInspectDTO> dtos, @Param("taskTypeEnum") Integer taskTypeEnum);

   List<MesTeamReportProductStaticsDTO> getTeamReportProductList(
      Integer productType,
      Long workShopId,
      Long productionLineId,
      Long teamId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long processId,
      String serialNumber,
      List<LocalDateTime> dateTimeList
   );

   List<DateMeteDTO> getProductionSummary(List<Long> projectIds, LocalDate year, Long branchCompanyId, Long workshopId);

   List<DateMeteDTO> getProductionMonthly(LocalDate year, Long branchCompanyId, Long workshopId);

   List<DateMeteDTO> getProductionMonthlyV2(List<Long> projectIds, LocalDate startDate, LocalDate endDate, Long branchCompanyId, Long workshopId);

   List<DateMeteDTO> getNumbersMonthly(List<Long> projectIds, LocalDate startDate, LocalDate endDate, Long branchCompanyId, Long workshopId);

   List<DateMeteDTO> getNumbersYear(List<Long> projectIds, LocalDate year, Long branchCompanyId, Long workshopId);

   List<DateMeteDTO> getProductionDay(List<Long> projectIds, LocalDate yearDate, LocalDate mouthDate, Long branchCompanyId, Long workshopId);

   List<ProjectMeteDTO> getProjectMete(List<Long> projectIds, LocalDate dateTime, Long branchCompanyId, Long workshopId, Boolean isMonthly);

   List<DateMeteDTO> getSchedulingMonthly(List<Long> projectIds, LocalDate year, Long branchCompanyId, Long workshopId);

   List<DateMeteDTO> getYearSchedulingProductionInfo(List<Long> projectIds, LocalDate year, Long branchCompanyId, Long workshopId);

   List<ProjectMeteDTO> getProjectSchedulingProductionInfo(List<Long> projectIds, LocalDate yearMonth, Long branchCompanyId, Long workshopId);

   List<TeamProduceOperateAnalyseDTO> getTeamProduceOperateAnalyse(List<Long> projectIds, LocalDate year, Long branchCompanyId, Long workshopId, Long processId);

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

   List<DateMeteDTO> getProductionGroupMonth(Long projectId, LocalDate year, Long branchCompanyId, Integer taskType);

   void getProductionGroupMonthDownload(Long projectId, Long branchCompanyId, Integer taskType, HttpServletResponse response);

   List<DateMeteDTO> getProductionYear(List<LocalDate> dateList, Long branchCompanyId, Long workshopId);

   List<UserProductionSummaryDTO> UserProductionSummary(Long projectId, Integer taskTypeEnum, LocalDateTime startDate, LocalDateTime endDate);

   PageVO<UserProductionDetailDTO> UserProductionDetailList(
      Long projectId,
      Long monomerId,
      String serialNumber,
      Integer taskTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long userId,
      Integer pageNumber,
      Integer pageSize
   );

   void UserProductionSummaryDownload(Long projectId, Integer taskTypeEnum, LocalDateTime startDate, LocalDateTime endDate, HttpServletResponse response);

   void UserProductionDetailDownload(
      Long projectId,
      Long monomerId,
      String serialNumber,
      Integer taskTypeEnum,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long userId,
      HttpServletResponse response
   );

   Boolean teamReportMarked(NameInfo dto);
}
