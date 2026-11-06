package com.hzchum.scim.wms.core.mapper.wmsReport;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.common.MonthTimeRange;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsInbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MonthSummaryDO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.DetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.StatisticsDetailDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatisticsInboundMapper extends BaseMapper<StatisticsInbound> {
   String EFFECTIVE_REAL_TIME_SQL = "COALESCE(real_time, CASE WHEN receipt_type = 15 THEN "
      + "(SELECT t.review_time FROM wms_transfer t WHERE t.id = wms_statistics_inbound.receipt_id "
      + "AND t.review_status = 2 AND t.bool_delete_enum = 0) END)";

   StatisticsInbound selectByMat(@Param("mat") MaterialInventory materialInventory, @Param("id") Long id, @Param("type") Integer type);

   DetailDTO getDetailDTO(Long id);

   List<StatisticsDetailDTO> getDetailDTOListUser(
      @Param("ids") List<Long> ids, @Param("times") MonthTimeRange monthTimeRange, @Param("list") ArrayList<Integer> list
   );

   List<StatisticsDetailDTO> getDetailDTOList(@Param("ids") List<Long> ids, @Param("times") MonthTimeRange monthTimeRange);

   List<StatisticsDetailDTO> getTransferDetailDTOListUser(@Param("ids") List<Long> ids, @Param("times") MonthTimeRange monthTimeRange, ArrayList<Integer> list);

   BigDecimal getSumAmountUser(@Param("times") MonthTimeRange monthTimeRange);

   BigDecimal getSumAmount(@Param("times") MonthTimeRange monthTimeRange, ArrayList<Integer> list);

   BigDecimal getGranterSumAmount(@Param("times") MonthTimeRange monthTimeRange, ArrayList<Integer> list);

   List<MonthSummaryDO> getInboundAmount(Integer basicClass, LocalDateTime year, int type);

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
