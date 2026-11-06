package com.hzchum.scim.wms.core.biz;

import com.hzchum.scim.wms.core.api.biz.OutBoundServiceBiz;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.Statistics;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsEndPeriod;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsInbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsOutbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MonthWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WholeWeightedAveragePrice;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsEndPeriodMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsInboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsOutboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.MonthWeightedAveragePriceMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.OutboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.TransferMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WholeWeightedAveragePriceMapper;
import java.time.LocalDateTime;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OutBoundServiceBizImpl implements OutBoundServiceBiz {
   private static final Logger log = LoggerFactory.getLogger(OutBoundServiceBizImpl.class);
   @Resource
   OutboundMapper outboundMapper;
   @Resource
   StatisticsMapper statisticsMapper;
   @Resource
   TransferMapper transferMapper;
   @Resource
   MonthWeightedAveragePriceMapper monthWeightedAveragePriceMapper;
   @Resource
   WholeWeightedAveragePriceMapper wholeWeightedAveragePriceMapper;
   @Resource
   StatisticsInboundMapper statisticsInboundMapper;
   @Resource
   StatisticsOutboundMapper statisticsOutboundMapper;
   @Resource
   StatisticsEndPeriodMapper statisticsEndPeriodMapper;

   @Override
   public Integer getCount() {
      return this.outboundMapper.getCount(LocalDateTime.now());
   }

   @Override
   public Integer getMaxDayNumber() {
      return this.transferMapper.getMaxDayNumber(LocalDateTime.now());
   }

   @Override
   public MonthWeightedAveragePrice getPrice(MaterialInventory mi) {
      return this.monthWeightedAveragePriceMapper.getPrice(mi);
   }

   @Override
   public MonthWeightedAveragePrice getPriceById(Long id) {
      return this.monthWeightedAveragePriceMapper.getPriceById(id);
   }

   @Override
   public Integer deleteWholeById(Long id) {
      return this.wholeWeightedAveragePriceMapper.deleteById(id);
   }

   @Override
   public Integer updateWholeById(WholeWeightedAveragePrice wholeWeightedAveragePrice) {
      return this.wholeWeightedAveragePriceMapper.updateById(wholeWeightedAveragePrice);
   }

   @Override
   public Integer deleteMonthById(Long id) {
      return this.monthWeightedAveragePriceMapper.deleteById(id);
   }

   @Override
   public Integer updateMonthById(MonthWeightedAveragePrice monthWeightedAveragePrice) {
      return this.monthWeightedAveragePriceMapper.updateById(monthWeightedAveragePrice);
   }

   @Override
   public WholeWeightedAveragePrice getWholePrice(MaterialInventory materialInventory) {
      return this.wholeWeightedAveragePriceMapper.getPrice(materialInventory);
   }

   @Override
   public Integer updateStatisticsById(Statistics statistics) {
      return this.statisticsMapper.updateById(statistics);
   }

   @Override
   public Integer saveStatisticsInbound(StatisticsInbound statisticsInbound) {
      return this.statisticsInboundMapper.insert(statisticsInbound);
   }

   @Override
   public Integer saveStatisticsOutbound(StatisticsOutbound statisticsOutbound) {
      return this.statisticsOutboundMapper.insert(statisticsOutbound);
   }

   @Override
   public Integer saveStatisticsEndPeriod(StatisticsEndPeriod statisticsEndPeriod) {
      return this.statisticsEndPeriodMapper.insert(statisticsEndPeriod);
   }

   @Override
   public Statistics get(MaterialInventory materialInventory) {
      return this.statisticsMapper.get(materialInventory);
   }

   @Override
   public Integer deleteStatisticsEndPeriodById(Long id) {
      return this.statisticsEndPeriodMapper.deleteById(id);
   }

   @Override
   public Integer updateStatisticsEndPeriodById(StatisticsEndPeriod statisticsEndPeriod) {
      return this.statisticsEndPeriodMapper.updateById(statisticsEndPeriod);
   }

   @Override
   public StatisticsEndPeriod getOne(Long statisticsId, Long materialInventoryId) {
      return this.statisticsEndPeriodMapper.getOne(statisticsId, materialInventoryId);
   }
}
