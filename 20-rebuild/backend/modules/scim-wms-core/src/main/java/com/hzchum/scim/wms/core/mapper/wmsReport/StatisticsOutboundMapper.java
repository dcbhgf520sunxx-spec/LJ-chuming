package com.hzchum.scim.wms.core.mapper.wmsReport;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.common.MonthTimeRange;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsOutbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MonthSummaryDO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.DetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.StatisticsDetailDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatisticsOutboundMapper extends BaseMapper<StatisticsOutbound> {
   DetailDTO getDetailDTO(Long id);

   List<StatisticsDetailDTO> getDetailDTOListUser(List<Long> ids, @Param("times") MonthTimeRange monthTimeRange);

   List<StatisticsDetailDTO> getDetailDTOList(List<Long> ids, @Param("times") MonthTimeRange monthTimeRange);

   StatisticsOutbound getOne(@Param("mat") MaterialInventory materialInventory, @Param("id") Long id);

   BigDecimal getSumAmount(@Param("times") MonthTimeRange monthTimeRange);

   List<MonthSummaryDO> getOutboundAmount(int basicClass, LocalDateTime year, int type);

   BigDecimal getSumAmountNewOne(
      @Param("times") MonthTimeRange monthTimeRange,
      @Param("factoryId") Long factoryId,
      @Param("basicClass") Integer basicClass,
      @Param("workshopId") Long workshopId
   );

   BigDecimal getSumMeteNewOne(
      @Param("times") MonthTimeRange monthTimeRange,
      @Param("factoryId") Long factoryId,
      @Param("basicClass") Integer basicClass,
      @Param("workshopId") Long workshopId
   );
}
