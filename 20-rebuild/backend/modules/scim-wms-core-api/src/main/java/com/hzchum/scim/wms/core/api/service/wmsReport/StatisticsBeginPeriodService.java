package com.hzchum.scim.wms.core.api.service.wmsReport;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.common.core.api.pojo.common.MonthTimeRange;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsBeginPeriod;
import java.math.BigDecimal;
import java.util.List;

public interface StatisticsBeginPeriodService extends IService<StatisticsBeginPeriod> {
   BigDecimal getSumAmountNewOne(MonthTimeRange monthTimeRange, Long factoryId, Integer steelNum, Long workshopId, List<Long> classifyIds);

   BigDecimal getSumMeteNewOne(MonthTimeRange monthTimeRange, Long factoryId, Integer basicClass, Long workshopId, List<Long> classifyIds);
}
