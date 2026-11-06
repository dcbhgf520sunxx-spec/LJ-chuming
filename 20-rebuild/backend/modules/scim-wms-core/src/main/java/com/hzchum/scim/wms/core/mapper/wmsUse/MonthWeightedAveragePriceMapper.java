package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MonthWeightedAveragePrice;
import java.util.List;

public interface MonthWeightedAveragePriceMapper extends BaseMapper<MonthWeightedAveragePrice> {
   MonthWeightedAveragePrice getPrice(MaterialInventory mi);

   MonthWeightedAveragePrice getPriceById(Long id);

   List<MonthWeightedAveragePrice> getPriceByIds(List<Long> ids);
}
