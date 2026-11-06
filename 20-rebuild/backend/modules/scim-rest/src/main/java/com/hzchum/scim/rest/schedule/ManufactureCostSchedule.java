package com.hzchum.scim.rest.schedule;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.contract.core.api.pojo.dto.ManufactureCostDTO;
import com.hzchum.scim.contract.core.api.service.ManufactureCostService;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ManufactureCostSchedule {
   private static final Logger log = LoggerFactory.getLogger(ManufactureCostSchedule.class);
   private static final String NOTAX_REDIS_KEY = "manufacture_cost_data";
   private static final String TAX_REDIS_KEY = "manufacture_cost_data_tax_inclusive";
   @Resource
   private ManufactureCostService manufactureCostService;
   @Resource
   private RedisUtils redisUtils;

   @Scheduled(cron = "0 0 1 * * ?")
   public void task3() {
      try {
         if (this.redisUtils.hasKey("manufacture_cost_data")) {
            this.redisUtils.del("manufacture_cost_data");
         }

         if (this.redisUtils.hasKey("manufacture_cost_data_tax_inclusive")) {
            this.redisUtils.del("manufacture_cost_data_tax_inclusive");
         }

         PageVO<ManufactureCostDTO> taxManufactureCostDTOPageVO = this.manufactureCostService.manufactureCostPage(null, null, null, true, 1, 1);
         PageVO<ManufactureCostDTO> noTaxManufactureCostDTOPageVO = this.manufactureCostService.manufactureCostPage(null, null, null, false, 1, 1);
         if (taxManufactureCostDTOPageVO != null && noTaxManufactureCostDTOPageVO != null) {
            log.info("成本汇总定时任务执行成功");
         }
      } catch (Exception e) {
         log.error("成本汇总定时任务执行时发生异常:", e.getMessage());
         throw new IllegalStateException("Local business task failed", e);
      }
   }

   public ManufactureCostSchedule(final ManufactureCostService manufactureCostService, final RedisUtils redisUtils) {
      this.manufactureCostService = manufactureCostService;
      this.redisUtils = redisUtils;
   }
}
