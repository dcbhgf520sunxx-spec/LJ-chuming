package com.hzchum.scim.wms.core.api.biz;

import com.hzchum.scim.common.core.api.pojo.common.MonthTimeRange;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedPriceConf;
import java.time.LocalDateTime;

public interface MaterialScheduleBiz {
   void calculateAveragePrice(MonthTimeRange monthTimeRange, WeightedPriceConf weightedPriceConf);

   void virtualOutbound();

   void calculateAveragePriceUser(MonthTimeRange monthTimeRange, WeightedPriceConf weightedPriceConf);

   void virtualOutbound(MonthTimeRange monthTimeRange);

   void manufacturedStatistics(LocalDateTime now);
}
