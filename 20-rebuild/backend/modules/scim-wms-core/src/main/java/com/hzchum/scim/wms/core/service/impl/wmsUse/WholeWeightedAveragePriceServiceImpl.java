package com.hzchum.scim.wms.core.service.impl.wmsUse;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WholeWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.service.wmsUse.WholeWeightedAveragePriceService;
import com.hzchum.scim.wms.core.mapper.wmsUse.WholeWeightedAveragePriceMapper;
import org.springframework.stereotype.Service;

@Service
public class WholeWeightedAveragePriceServiceImpl
   extends ServiceImpl<WholeWeightedAveragePriceMapper, WholeWeightedAveragePrice>
   implements WholeWeightedAveragePriceService {
}
