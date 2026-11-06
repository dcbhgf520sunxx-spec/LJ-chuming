package com.hzchum.scim.wms.core.service.impl.wmsReport;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.common.core.api.pojo.common.MonthTimeRange;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsOutbound;
import com.hzchum.scim.wms.core.api.service.wmsReport.StatisticsOutboundService;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsOutboundMapper;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class StatisticsOutboundServiceImpl extends ServiceImpl<StatisticsOutboundMapper, StatisticsOutbound> implements StatisticsOutboundService {
   @Override
   public BigDecimal getSumAmountNewOne(MonthTimeRange monthTimeRange, Long factoryId, Integer basicClass, Long workshopId) {
      return this.baseMapper.getSumAmountNewOne(monthTimeRange, factoryId, basicClass, workshopId);
   }

   @Override
   public BigDecimal getSumMeteNewOne(MonthTimeRange monthTimeRange, Long factoryId, Integer basicClass, Long workshopId) {
      return this.baseMapper.getSumMeteNewOne(monthTimeRange, factoryId, basicClass, workshopId);
   }
}
