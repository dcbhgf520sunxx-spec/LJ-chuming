package com.hzchum.scim.wms.core.service.impl.wmsReport;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.common.core.api.pojo.common.MonthTimeRange;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsBeginPeriod;
import com.hzchum.scim.wms.core.api.service.wmsReport.StatisticsBeginPeriodService;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsBeginPeriodMapper;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StatisticsBeginPeriodServiceImpl extends ServiceImpl<StatisticsBeginPeriodMapper, StatisticsBeginPeriod> implements StatisticsBeginPeriodService {
   @Override
   public BigDecimal getSumAmountNewOne(MonthTimeRange monthTimeRange, Long factoryId, Integer basicClass, Long workshopId, List<Long> classifyIds) {
      return this.baseMapper.getSumAmountNewOne(monthTimeRange, factoryId, basicClass, workshopId, classifyIds);
   }

   @Override
   public BigDecimal getSumMeteNewOne(MonthTimeRange monthTimeRange, Long factoryId, Integer basicClass, Long workshopId, List<Long> classifyIds) {
      return this.baseMapper.getSumMeteNewOne(monthTimeRange, factoryId, basicClass, workshopId, classifyIds);
   }
}
