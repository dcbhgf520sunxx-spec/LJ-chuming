package com.hzchum.scim.wms.core.api.service.wmsUse;

import com.hzchum.scim.common.core.api.pojo.common.MonthTimeRange;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.Statistics;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MonthWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WholeWeightedAveragePrice;

public interface WeightedAveragePriceService {
   Statistics createMoveWAP(InboundDetail inboundDetail, MaterialInventory materialInventory, Long receiptId, String receiptSerialNumber, Integer receiptType);

   Statistics createMonthWAP(InboundDetail inboundDetail, MaterialInventory materialInventory, Long receiptId, String receiptSerialNumber, Integer receiptType);

   MonthWeightedAveragePrice getPrice(MaterialInventory materialInventory);

   WholeWeightedAveragePrice getNowWholeWap(WholeWeightedAveragePrice wholeWAP, MonthTimeRange monthTimeRange);

   MonthWeightedAveragePrice getNowMothWap(MonthWeightedAveragePrice monthWAP, MonthTimeRange monthTimeRange);
}
