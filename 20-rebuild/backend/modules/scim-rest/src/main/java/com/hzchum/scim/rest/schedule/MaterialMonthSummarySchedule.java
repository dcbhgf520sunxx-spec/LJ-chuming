package com.hzchum.scim.rest.schedule;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.pojo.common.MonthTimeRange;
import com.hzchum.scim.common.core.api.utils.DateTimeUtil;
import com.hzchum.scim.wms.core.api.biz.MaterialScheduleBiz;
import com.hzchum.scim.wms.core.api.enums.ReceiptTypeEnum;
import com.hzchum.scim.wms.core.api.enums.WeightedPriceTypeEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedExecutionPriceConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedPriceConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Supplement;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import com.hzchum.scim.wms.core.api.service.wmsReport.InventoryUseRecordService;
import com.hzchum.scim.wms.core.api.service.wmsReport.InventoryUseStatisticsService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import com.hzchum.scim.wms.core.api.service.wmsUse.SupplementService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MaterialMonthSummarySchedule {
   private static final Logger log = LoggerFactory.getLogger(MaterialMonthSummarySchedule.class);
   private static final String scheduledStr = "00 00 23 L * ?";
   @Resource
   private MaterialScheduleBiz materialScheduleBiz;
   @Resource
   private BasicConfigService basicConfigService;
   @Resource
   private SupplementService supplementService;
   @Resource
   private InventoryUseRecordService inventoryUseRecordService;
   @Resource
   private MaterialInventoryService materialInventoryService;
   @Resource
   private InventoryUseStatisticsService inventoryUseStatisticsService;

   @Scheduled(cron = "${wms.scheduled-cron}")
   public void calculateAveragePrice() {
      LocalDateTime now = LocalDateTime.now();
      MonthTimeRange monthTimeRange = DateTimeUtil.getMonthTimeRange(now.getMonthValue() + "");
      BasicConfig basicConfig = this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置"));
      WeightedExecutionPriceConf weightedExecutionPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权执行方式配置")).getValue(),
         WeightedExecutionPriceConf.class
      );
      WeightedPriceConf weightedPriceConf = JSON.parseObject(basicConfig.getValue(), WeightedPriceConf.class);
      if (weightedExecutionPriceConf.getWeightedExecutionType() == WeightedPriceTypeEnum.MONTH.getType()) {
         this.materialScheduleBiz.calculateAveragePrice(monthTimeRange, weightedPriceConf);
         this.materialScheduleBiz.virtualOutbound();
      }

      for (Supplement supplement : this.supplementService
         .list(
            (Wrapper<Supplement>)((new LambdaQueryWrapper<Supplement>().ge(BaseEntity::getCreateTime, now.with(LocalTime.MIN)))
                  .le(BaseEntity::getCreateTime, now.with(LocalTime.MAX)))
               .isNotNull(Supplement::getMaterialInventoryId)
         )) {
         if (ObjectUtil.isNotEmpty(supplement.getMete()) && supplement.getMete().compareTo(BigDecimal.ZERO) != 0) {
            MaterialInventory materialInventory = this.materialInventoryService.selectById(supplement.getMaterialInventoryId());
            this.inventoryUseRecordService
               .saveUseRecord(
                  materialInventory, null, supplement.getMete(), ReceiptTypeEnum.SUPPLEMENT, supplement.getId(), supplement.getSerialNumber(), 1, null
               );
         }
      }

      System.out.println("===============月末加权库存使用开始===============");
      LocalDateTime maxDate = now.with(LocalTime.MAX);
      this.inventoryUseStatisticsService.weighting(true, maxDate, "自动月末结存");
      System.out.println("===============月末加权库存使用结束===============");
   }

   @Async
   @Scheduled(cron = "00 00 23 L * ?")
   public void manufacturedStatistics() {
      this.materialScheduleBiz.manufacturedStatistics(LocalDateTime.now());
   }
}
