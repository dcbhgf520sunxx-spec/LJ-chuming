package com.hzchum.scim.rest.runner;

import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.pojo.dto.AddressResponseVO;
import com.hzchum.scim.system.core.api.service.SysCountryService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class CountryRunner implements CommandLineRunner {
   private static final Logger LOGGER = LoggerFactory.getLogger(CountryRunner.class);
   private final SysCountryService countryService;
   private final RedisUtils redisUtils;

   @Override
   public void run(String... strings) throws Exception {
      LOGGER.info("初始化查询国家省市区信息开始............................................");
      String worldAddress = "world-address";
      this.redisUtils.del(worldAddress);
      List<AddressResponseVO> response = this.countryService.listAll();
      LOGGER.info("初始化查询国家省市区信息结束............................................");
   }

   public CountryRunner(final SysCountryService countryService, final RedisUtils redisUtils) {
      this.countryService = countryService;
      this.redisUtils = redisUtils;
   }
}
