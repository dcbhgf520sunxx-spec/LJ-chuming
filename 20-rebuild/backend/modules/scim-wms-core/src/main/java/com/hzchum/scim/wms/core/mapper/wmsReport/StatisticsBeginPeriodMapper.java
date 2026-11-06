package com.hzchum.scim.wms.core.mapper.wmsReport;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.common.MonthTimeRange;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsBeginPeriod;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MonthSummaryDO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.DetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.StatisticsDetailDTO;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatisticsBeginPeriodMapper extends BaseMapper<StatisticsBeginPeriod> {
   List<StatisticsBeginPeriod> getList(LocalDateTime createTime);

   List<DetailDTO> getBeginPeriodList(LocalDateTime createTime, boolean boolShowAmount);

   DetailDTO getDetail(@Param("id") Long id, @Param("times") MonthTimeRange monthTimeRange);

   List<StatisticsDetailDTO> getDetailDTOListUser(@Param("ids") List<Long> ids, @Param("times") MonthTimeRange monthTimeRange);

   List<StatisticsDetailDTO> getDetailDTOList(@Param("ids") List<Long> ids, @Param("times") MonthTimeRange monthTimeRange);

   BigDecimal getSumAmount(@Param("times") MonthTimeRange monthTimeRange);

   List<MonthSummaryDO> getAmountList(LocalDateTime year, Integer basicClass, int type);

   List<MonthSummaryDO> getAmountListV2(LocalDate yearDate, Long branchCompanyId, int type, Integer materialIsWhole, Integer basicClass);

   boolean boolHave(MaterialInventory materialInventory);

   List<DetailDTO> getDetailNew(@Param("ids") List<Long> ids, @Param("times") MonthTimeRange monthTimeRange, @Param("firstClosedPeriod") boolean firstClosedPeriod);

   BigDecimal getSumAmountNewOne(
      @Param("times") MonthTimeRange monthTimeRange,
      @Param("factoryId") Long factoryId,
      @Param("basicClass") Integer basicClass,
      @Param("workshopId") Long workshopId,
      @Param("classifyIds") List<Long> classifyIds
   );

   BigDecimal getSumMeteNewOne(
      @Param("times") MonthTimeRange monthTimeRange,
      @Param("factoryId") Long factoryId,
      @Param("basicClass") Integer basicClass,
      @Param("workshopId") Long workshopId,
      @Param("classifyIds") List<Long> classifyIds
   );
}
