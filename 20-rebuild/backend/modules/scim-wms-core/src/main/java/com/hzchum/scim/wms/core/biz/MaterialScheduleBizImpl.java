package com.hzchum.scim.wms.core.biz;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.pojo.common.MonthTimeRange;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.wms.core.api.biz.MaterialScheduleBiz;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedPriceConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.WmsClosingTime;
import com.hzchum.scim.wms.core.api.service.wmsReport.ReportService;
import com.hzchum.scim.wms.core.api.service.wmsReport.StatisticsMonthManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import com.hzchum.scim.wms.core.api.service.wmsUse.VirtualWarehouseService;
import com.hzchum.scim.wms.core.mapper.wmsReport.StatisticsMapper;
import com.hzchum.scim.wms.core.mapper.wmsReport.WmsClosingTimeMapper;
import java.time.LocalDateTime;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MaterialScheduleBizImpl implements MaterialScheduleBiz {
   private static final Logger log = LoggerFactory.getLogger(MaterialScheduleBizImpl.class);
   @Resource
   private MaterialInventoryService materialInventoryService;
   @Resource
   private ReportService reportService;
   @Resource
   private StatisticsMapper statisticsMapper;
   @Resource
   RedisUtils redisUtils;
   @Resource
   VirtualWarehouseService virtualWarehouseService;
   @Resource
   private StatisticsMonthManufacturedService statisticsMonthManufacturedService;
   @Resource
   WmsClosingTimeMapper wmsClosingTimeMapper;

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public void calculateAveragePrice(MonthTimeRange monthTimeRange, WeightedPriceConf weightedPriceConf) {
      this.redisUtils.set("calculatePrice", "计算中", -1L);
      log.info("----------------- 月末计算加权价格开始 -----------------");
      this.reportService.calculateAveragePrice(monthTimeRange, weightedPriceConf);
      log.info("----------------- 月末计算加权价格结束 -----------------");
      log.info("----------------- 月收发存持久化开始 -----------------");
      this.materialInventoryService.materialMonthSummary();
      log.info("----------------- 月收发存持久化结束 -----------------");
      this.redisUtils.del("calculatePrice");
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public void virtualOutbound() {
      if (!this.redisUtils.hasKey("calculatePrice")) {
         log.info("-----------------  虚拟物料出库开始 -----------------");
         this.virtualWarehouseService.setOutbound();
         log.info("----------------- 虚拟物料出库结束 -----------------");
      } else {
         log.error("月末加权失败,虚拟出库不能执行:{}");
      }
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public void calculateAveragePriceUser(MonthTimeRange monthTimeRange, WeightedPriceConf weightedPriceConf) {
      WmsClosingTime build = WmsClosingTime.builder()
         .startTime(monthTimeRange.getStartTime())
         .endTime(monthTimeRange.getEndTime())
         .name(monthTimeRange.getName())
         .build();
      WmsClosingTime name = this.wmsClosingTimeMapper
         .selectOne((Wrapper<WmsClosingTime>)new LambdaQueryWrapper<WmsClosingTime>().eq(WmsClosingTime::getName, monthTimeRange.getName()));
      Preconditions.checkArgument(name == null, "关账名已经存在");
      this.wmsClosingTimeMapper.insert(build);
      monthTimeRange.setWmsClosingTimeId(build.getId());
      monthTimeRange.setName(monthTimeRange.getName());
      this.redisUtils.set("calculatePrice", "计算中", -1L);
      log.info("----------------- 月末计算加权价格开始 -----------------");
      this.reportService.calculateAveragePriceUser(monthTimeRange, weightedPriceConf);
      log.info("----------------- 月末计算加权价格结束 -----------------");
      log.info("----------------- 月收发存持久化开始 -----------------");
      this.materialInventoryService.materialMonthSummaryUser(build);
      log.info("----------------- 月收发存持久化结束 -----------------");
      this.redisUtils.del("calculatePrice");
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public void virtualOutbound(MonthTimeRange monthTimeRange) {
      if (!this.redisUtils.hasKey("calculatePrice")) {
         log.info("-----------------  虚拟物料出库开始 -----------------");
         this.virtualWarehouseService.setOutboundUser(monthTimeRange);
         log.info("----------------- 虚拟物料出库结束 -----------------");
      } else {
         log.error("月末加权失败,虚拟出库不能执行:{}");
      }
   }

   @Override
   public void manufacturedStatistics(LocalDateTime now) {
      this.redisUtils.set("manufacturedStatistics", "计算中", -1L);
      log.info("----------------- 制成品计算期初期末开始 -----------------");
      this.statisticsMonthManufacturedService.manufacturedStatistics(now);
      log.info("----------------- 制成品计算期初期末结束 -----------------");
      this.redisUtils.del("manufacturedStatistics");
   }
}
