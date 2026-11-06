package com.hzchum.scim.mes.building.core.api.service.qhse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.common.core.api.pojo.vo.StatisticsPageVO;
import com.hzchum.scim.mes.building.core.api.pojo._do.qhse.MesBuildingQhseDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhse;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.qhse.MesBuildingQhseCountParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.MonthlyFirstPassRateDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.QhseAlertDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.QhseGroupMonthByYearSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.QhseQuantitySummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.QhseWarnToDayDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.QualityGroupSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.QualityInspectionStatisticsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.TeamQhseQuantityDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen.TeamQhseRankingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.app.DateAndCount;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.ArtNotRectifiedInfo;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.InspectRealtimeInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.InspectRealtimeInfoSummary;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingInspectCountDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingQhseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingQhseDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.QhseDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.QhseReportDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.QhseReportSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.qhse.QhseDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.ResponseVO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletResponse;

public interface MesBuildingQhseService extends IService<MesBuildingQhse> {
   List<MesBuildingQhseDO> selectListByCondition(
      Long qhseId,
      Long projectId,
      String userName,
      String dutyName,
      String rectifyName,
      String serialNumber,
      Integer type,
      Integer status,
      Boolean boolApp,
      Long userId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      LocalDateTime specifiedDate,
      List<Long> qhseIds,
      Integer noStatus,
      Long processId,
      Long levelOneType,
      Long levelTwoType
   );

   MesBuildingQhseDetailDTO findQhseDetailList(Long qhseId);

   MesBuildingQhseDTO selectQhseById(Long id, Long userId);

   Map<String, Object> report(String year);

   List<QhseDetailsDTO> qhseSummaryList(LocalDateTime dateTime, Integer type, Long workShopId);

   Integer getQuantityType(LocalDateTime dateTime, Integer type);

   List<MesBuildingQhse> getListByTimeAndType(LocalDateTime dateTime, Integer type);

   List<QhseDTOParam> getListTo();

   List<MesBuildingQhse> getListByTimesAndType(LocalDateTime time, Long workShopId, Integer type);

   List<ResponseVO> productionQualityAnalysis(String type, String projectId);

   Double firstPassRateOfQualityInspection(Long projectId);

   List<DateAndCount> getQhseCountByYear(int year, Long processId, Long userId);

   List<MesBuildingQhse> getQhseAnalyseByYear(int year, Long processId, Long userId);

   List<MesBuildingQhse> listByData(List<NumberInfoDTO> numberInfors, Integer taskType);

   List<ArtNotRectifiedInfo> findInPackageNotRectifiedInfo(Set<Long> packageIds);

   List<ArtNotRectifiedInfo> findProductNotRectifiedInfo(Map<Long, List<Integer>> productMap);

   void updateSql(String sql);

   QhseReportSummaryDTO findQhseReportSummary(Integer type);

   List<QhseReportDetailDTO> findQhseReportList(Long userId, LocalDate date);

   InspectRealtimeInfoSummary findInspectRealtimeSummary(LocalDateTime date, Long workShopId, Long insepectUserId);

   List<TeamQhseQuantityDTO> findTeamQhseQuantity(Long workShopId, LocalDate date);

   List<QhseQuantitySummaryDTO> findQhseQuantityGroupQhseType(Long workShopId, LocalDate date);

   List<QhseWarnToDayDTO> findQhseWarnToDay(Long workShopId);

   StatisticsPageVO findInspectRealtimeInfos(
      LocalDateTime startDate,
      LocalDateTime endDate,
      Long projectId,
      Long workShopId,
      Long insepectUserId,
      Integer status,
      String serialNumber,
      Integer pageNumber,
      Integer pageSize
   );

   PageVO<MesBuildingInspectCountDTO> findInspectCountDTO(MesBuildingQhseCountParam qhseCountParam, Integer pageNumber, Integer pageSize);

   Integer findInspectTotalCount(MesBuildingQhseCountParam qhseCountParam);

   List<QualityGroupSummaryDTO> findQualityGroupSummary(Integer year);

   List<QhseGroupMonthByYearSummaryDTO> findQualityGroupMonthByYear(Integer year);

   List<MonthlyFirstPassRateDTO> findQhseCountGroupMonth(Integer year);

   List<QhseAlertDTO> findQuailyQhseAlert(Integer type, List<Integer> statuses);

   List<QualityInspectionStatisticsDTO> findQualityInspectionStatistics(Integer year);

   List<TeamQhseRankingDTO> findTeamQhseRanking(Integer year);

   Boolean findInspectCountDTODownload(MesBuildingQhseCountParam qhseCountParam, HttpServletResponse response);

   List<InspectRealtimeInfoDTO> productionKanbanRealtimeInfo(
      List<Long> projectIdList, Long workshopId, LocalDateTime startTime, LocalDateTime endTime, Integer status
   );

   Integer getProblemQuantity(Long workshopId, Long teamId);
}
