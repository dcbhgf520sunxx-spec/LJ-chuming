package com.hzchum.scim.wms.core.mapper.wmsUse;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.StatisticsDTO;

public interface MoveWeightedAveragePriceMapper extends BaseMapper<MoveWeightedAveragePrice> {
   MoveWeightedAveragePrice getPrice(MaterialInventory mi);

   StatisticsDTO getById(Long id);
}
