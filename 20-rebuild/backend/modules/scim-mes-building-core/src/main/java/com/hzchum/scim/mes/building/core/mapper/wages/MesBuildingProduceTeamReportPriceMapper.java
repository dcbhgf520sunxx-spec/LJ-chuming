package com.hzchum.scim.mes.building.core.mapper.wages;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.common.MonthAmountInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.ProcessPriceDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.ProcessPriceDetailsDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.ProjectPainingPriceDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.TeamProcessPriceDetailsDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wages.MesBuildingProduceTeamReportPrice;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wages.FinanceProcessPriceDTO;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesBuildingProduceTeamReportPriceMapper extends BaseMapper<MesBuildingProduceTeamReportPrice> {
   BigDecimal getPriceSummaryByCondition(
      @Param("dateTime") LocalDateTime dateTime, @Param("timeTypeEnum") Integer timeTypeEnum, @Param("taskTypeEnum") Integer taskTypeEnum
   );

   List<ProcessPriceDO> getProcessPriceList(
      @Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime, @Param("workshopId") Long workshopId
   );

   List<ProcessPriceDetailsDO> getProcessPriceDayDetailsList(
      @Param("startTime") LocalDateTime startTime,
      @Param("endTime") LocalDateTime endTime,
      @Param("workshopId") Long workshopId,
      @Param("processId") Long processId,
      @Param("userName") String userName
   );

   List<TeamProcessPriceDetailsDO> getTeamProcessPriceDayDetailsList(
      @Param("startTime") LocalDateTime startTime,
      @Param("endTime") LocalDateTime endTime,
      @Param("workshopId") Long workshopId,
      @Param("processId") Long processId,
      @Param("userName") String userName,
      @Param("taskTypeEnum") Integer taskTypeEnum
   );

   List<ProjectPainingPriceDO> getProjectPaintingPrice(@Param("dateTime") LocalDateTime dateTime);

   List<MonthAmountInfo> selectByYear(@Param("year") Integer year);

   List<MonthAmountInfo> selectByYearV2(
      @Param("projectIds") List<Long> projectIds,
      @Param("yearDate") LocalDate yearDate,
      @Param("branchCompanyId") Long branchCompanyId,
      @Param("workshopId") Long workshopId
   );

   List<FinanceProcessPriceDTO> listWageSummaryByProjectId(@Param("projectIds") Collection<Long> projectIds);
}
