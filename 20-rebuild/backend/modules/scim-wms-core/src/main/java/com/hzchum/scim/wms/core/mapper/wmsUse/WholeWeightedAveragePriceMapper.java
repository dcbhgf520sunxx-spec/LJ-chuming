package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WholeWeightedAveragePrice;

public interface WholeWeightedAveragePriceMapper extends BaseMapper<WholeWeightedAveragePrice> {
   WholeWeightedAveragePrice getPrice(MaterialInventory mi);
}
