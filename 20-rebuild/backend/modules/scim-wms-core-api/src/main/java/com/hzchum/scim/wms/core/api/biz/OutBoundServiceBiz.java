package com.hzchum.scim.wms.core.api.biz;

import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.Statistics;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsEndPeriod;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsInbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsOutbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MonthWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WholeWeightedAveragePrice;

public interface OutBoundServiceBiz {
   Integer getCount();

   Statistics get(MaterialInventory materialInventory);

   Integer getMaxDayNumber();

   MonthWeightedAveragePrice getPrice(MaterialInventory mi);

   MonthWeightedAveragePrice getPriceById(Long id);

   Integer deleteWholeById(Long id);

   Integer updateWholeById(WholeWeightedAveragePrice wholeWeightedAveragePrice);

   Integer deleteMonthById(Long id);

   Integer updateMonthById(MonthWeightedAveragePrice monthWeightedAveragePrice);

   WholeWeightedAveragePrice getWholePrice(MaterialInventory materialInventory);

   Integer updateStatisticsById(Statistics statistics);

   Integer saveStatisticsInbound(StatisticsInbound statisticsInbound);

   Integer saveStatisticsOutbound(StatisticsOutbound statisticsOutbound);

   Integer saveStatisticsEndPeriod(StatisticsEndPeriod statisticsEndPeriod);

   StatisticsEndPeriod getOne(Long statisticsId, Long materialInventoryId);

   Integer deleteStatisticsEndPeriodById(Long id);

   Integer updateStatisticsEndPeriodById(StatisticsEndPeriod statisticsEndPeriod);
}
