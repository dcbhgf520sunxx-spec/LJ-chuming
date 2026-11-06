package com.hzchum.scim.wms.core.service.impl.wmsUse;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MonthWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.service.wmsUse.MonthWeightedAveragePriceService;
import com.hzchum.scim.wms.core.mapper.wmsUse.MonthWeightedAveragePriceMapper;
import org.springframework.stereotype.Service;

@Service
public class MonthWeightedAveragePriceServiceImpl
   extends ServiceImpl<MonthWeightedAveragePriceMapper, MonthWeightedAveragePrice>
   implements MonthWeightedAveragePriceService {
}
