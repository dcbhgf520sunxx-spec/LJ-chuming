package com.hzchum.scim.wms.core.api.service.wmsReport;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.common.core.api.pojo.common.MonthTimeRange;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsInbound;
import java.math.BigDecimal;

public interface StatisticsInboundService extends IService<StatisticsInbound> {
   BigDecimal getSumAmountNewOne(MonthTimeRange monthTimeRange, Long factoryId, Integer basicClass, Long workshopId);

   BigDecimal getSumMeteNewOne(MonthTimeRange monthTimeRange, Long factoryId, Integer basicClass, Long workshopId);
}
