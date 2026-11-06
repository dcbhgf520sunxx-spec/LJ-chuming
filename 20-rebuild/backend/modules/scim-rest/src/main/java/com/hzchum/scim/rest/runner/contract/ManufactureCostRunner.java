package com.hzchum.scim.rest.runner.contract;

import com.hzchum.scim.contract.core.api.service.ManufactureCostService;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

@Order(666)
public class ManufactureCostRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(ManufactureCostRunner.class);
   private static final String NOTAX_REDIS_KEY = "manufacture_cost_data";
   private static final String TAX_REDIS_KEY = "manufacture_cost_data_tax_inclusive";
   @Resource
   private ManufactureCostService manufactureCostService;
   @Resource
   private RedisUtils redisUtils;

   @Override
   public void run(String... args) throws Exception {
   }
}
