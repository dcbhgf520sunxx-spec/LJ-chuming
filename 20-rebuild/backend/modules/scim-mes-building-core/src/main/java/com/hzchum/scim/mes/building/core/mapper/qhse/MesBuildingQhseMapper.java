package com.hzchum.scim.mes.building.core.mapper.qhse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.mes.building.core.api.pojo._do.qhse.MesBuildingQhseDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.qhse.MonthQuantityDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.qhse.TypeQuantityDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhse;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.qhse.MesBuildingQhseCountParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.qhse.MesBuildingQhseFormParam;
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
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingInspectCountDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingQhseDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.QhseDetailsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.QhseReportDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.QhseReportListDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.qhse.QhseDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.InsepctUserConditionDTO;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingQhseMapper extends BaseMapper<MesBuildingQhse> {
   List<MesBuildingQhseDO> selectListByCondition(
      @Param("qhseId") Long qhseId,
      @Param("projectId") Long projectId,
      @Param("userName") String userName,
      @Param("dutyName") String dutyName,
      @Param("rectifyName") String rectifyName,
      @Param("serialNumber") String serialNumber,
      @Param("type") Integer type,
      @Param("status") Integer status,
      @Param("boolApp") Boolean boolApp,
      @Param("userId") Long userId,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("specifiedDate") LocalDateTime specifiedDate,
      @Param("qhseIds") List<Long> qhseIds,
      @Param("noStatus") Integer noStatus,
      @Param("processId") Long processId,
      @Param("levelOneType") Long levelOneType,
      @Param("levelTwoType") Long levelTwoType
   );

   MesBuildingQhseDO selectQhseById(@Param("id") Long id, @Param("userId") Long userId);

   List<TypeQuantityDO> listGroupByType(String year);

   List<MonthQuantityDO> listGroupByMonth(@Param("year") String year, @Param("type") Integer type);

   List<QhseDetailsDTO> qhseSummaryList(@Param("dateTime") LocalDateTime dateTime, @Param("type") Integer type, @Param("workShopId") Long workShopId);

   Integer getQuantityType(@Param("dateTime") LocalDateTime dateTime, @Param("type") Integer type);

   List<MesBuildingQhse> getListByTimeAndType(@Param("dateTime") LocalDateTime dateTime, @Param("type") Integer type);

   List<QhseDTOParam> getListTo();

   List<MesBuildingQhse> getListByTimesAndType(@Param("time") LocalDateTime time, @Param("workShopId") Long workShopId, @Param("type") Integer type);

   Integer productionQuality(@Param("type") String type, @Param("value") String value, @Param("projectId") Long projectId);

   List<DateAndCount> getQhseCountByYear(@Param("year") int year, @Param("processId") Long processId, @Param("userId") Long userId);

   List<MesBuildingQhse> getQhseAnalyseByYear(@Param("year") int year, @Param("processId") Long processId, @Param("userId") Long userId);

   List<MesBuildingQhse> listByData(@Param("numbers") List<NumberInfoDTO> numberInfors, @Param("taskType") Integer taskType);

   List<ArtNotRectifiedInfo> findInPackageNotRectifiedInfo(Set<Long> packageIds);

   List<ArtNotRectifiedInfo> findProductNotRectifiedInfo(@Param("productMap") Map<Long, List<Integer>> productMap);

   void updateSql(String sql);

   List<QhseReportListDTO> selectQualityTypeQhseList(MesBuildingQhseFormParam param);

   List<QhseReportDetailDTO> selectQualityTypeQhseDetails(@Param("userId") Long userId, @Param("date") LocalDate date);

   List<InspectRealtimeInfoDTO> findQhseRealtimeList(
      @Param("treeCondition") List<InsepctUserConditionDTO> treeCondition,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("projectId") Long projectId,
      @Param("workShopId") Long workShopId,
      @Param("serialNumber") String serialNumber
   );

   List<InspectRealtimeInfoDTO> findQhseRealtimeListV2(
      @Param("treeCondition") List<InsepctUserConditionDTO> treeCondition,
      @Param("startDate") LocalDateTime startDate,
      @Param("endDate") LocalDateTime endDate,
      @Param("projectIdList") Collection<Long> projectIdList,
      @Param("workShopId") Long workShopId
   );

   List<TeamQhseQuantityDTO> findTeamQhseQuantity(@Param("workShopId") Long workShopId, @Param("date") LocalDate date);

   List<QhseQuantitySummaryDTO> findQhseQuantityGroupQhseType(@Param("workShopId") Long workShopId, @Param("date") LocalDate date);

   List<QhseWarnToDayDTO> findQhseWarnToDay(@Param("workShopId") Long workShopId);

   List<MesBuildingInspectCountDTO> findAllInspectCount(MesBuildingQhseCountParam qhseCountParam);

   Integer findAllInspectQuantity(MesBuildingQhseCountParam qhseCountParam);

   MesBuildingQhseDetailDTO findQhseDetailList(Long qhseId);

   List<QualityGroupSummaryDTO> findQualityGroupSummary(Integer year);

   List<QhseGroupMonthByYearSummaryDTO> findQualityGroupMonthByYear(Integer year);

   List<MonthlyFirstPassRateDTO> findQhseCountGroupMonth(Integer year);

   List<QhseAlertDTO> findQuailyQhseAlert(@Param("type") Integer type, @Param("statuses") List<Integer> statuses);

   List<QualityInspectionStatisticsDTO> findQualityStatistics(Integer year);

   List<QualityInspectionStatisticsDTO> findInspectionStatistics(Integer year);

   List<TeamQhseRankingDTO> findTeamQhseRanking(Integer year);

   Integer getProblemQuantity(@Param("workshopId") Long workshopId, @Param("teamId") Long teamId);
}
