package com.hzchum.scim.wms.core.service.impl.wmsReport;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.common.core.api.pojo.common.MonthTimeRange;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsInbound;
import com.hzchum.scim.wms.core.api.service.wmsReport.StatisticsInboundService;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsInboundMapper;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class StatisticsInboundServiceImpl extends ServiceImpl<StatisticsInboundMapper, StatisticsInbound> implements StatisticsInboundService {
   @Override
   public BigDecimal getSumAmountNewOne(MonthTimeRange monthTimeRange, Long factoryId, Integer basicClass, Long workshopId) {
      return this.baseMapper.getSumAmountNewOne(monthTimeRange, factoryId, basicClass, workshopId);
   }

   @Override
   public BigDecimal getSumMeteNewOne(MonthTimeRange monthTimeRange, Long factoryId, Integer basicClass, Long workshopId) {
      return this.baseMapper.getSumMeteNewOne(monthTimeRange, factoryId, basicClass, workshopId);
   }
}
