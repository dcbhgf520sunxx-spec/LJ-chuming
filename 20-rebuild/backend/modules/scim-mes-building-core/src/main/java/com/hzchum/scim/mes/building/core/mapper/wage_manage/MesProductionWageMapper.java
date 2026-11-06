package com.hzchum.scim.mes.building.core.mapper.wage_manage;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_manage.MesProductionWage;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage.MesProductionWageReverseInferenceModeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage.MesWageStatisticsMonthSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage.MesWageStatisticsYearSummaryDTO;
import java.time.LocalDate;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesProductionWageMapper extends BaseMapper<MesProductionWage> {
   MesWageStatisticsYearSummaryDTO dateRangeSummary(
      @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate, @Param("workshopId") Long workshopId, @Param("projectId") Long projectId
   );

   List<MesWageStatisticsMonthSummaryDTO> monthSummaryList(
      @Param("startDate") LocalDate startDate,
      @Param("endDate") LocalDate endDate,
      @Param("workshopId") Long workshopId,
      @Param("lastMonthStartDate") LocalDate lastMonthStartDate,
      @Param("lastMonthEndDate") LocalDate lastMonthEndDate,
      @Param("projectId") Long projectId
   );

   List<MesProductionWageReverseInferenceModeDTO> reverseInferenceModePage(
      @Param("workshopId") Long workshopId,
      @Param("processId") Long processId,
      @Param("teamLeaderName") String teamLeaderName,
      @Param("startDate") LocalDate startDate,
      @Param("endDate") LocalDate endDate
   );
}
