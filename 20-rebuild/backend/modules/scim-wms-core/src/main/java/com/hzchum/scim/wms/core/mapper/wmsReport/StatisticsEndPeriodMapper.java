package com.hzchum.scim.wms.core.mapper.wmsReport;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.common.core.api.pojo.common.MonthTimeRange;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsEndPeriod;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MonthSummaryDO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.DetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.StatisticsDetailDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatisticsEndPeriodMapper extends BaseMapper<StatisticsEndPeriod> {
   DetailDTO getDetailDTO(Long id, boolean boolShowAmount);

   List<StatisticsDetailDTO> getDetailDTOListUser(List<Long> ids, @Param("times") MonthTimeRange monthTimeRange);

   List<StatisticsDetailDTO> getDetailDTOList(List<Long> ids, LocalDateTime date);

   BigDecimal getSumAmountUser(@Param("times") MonthTimeRange monthTimeRange);

   BigDecimal getSumAmount();

   MonthSummaryDO getByBasicClass(int type, int basicClass);

   StatisticsEndPeriod getOne(Long staId, Long materId);

   List<StatisticsEndPeriod> getList(Long staId);
}
