package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.system.core.api.pojo.request.MesPriceModifyConfigSaveDTOParam;
import com.hzchum.scim.system.core.api.pojo.request.MesStatisticsModeConfigSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesPriceModifyConfigService;
import com.hzchum.scim.system.core.api.service.MesStatisticsModeConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "工价配置-统计配置")
@RequestMapping("/api/system/statistics-config")
@RestController
public class MesStatisticsConfigController {
   private static final Logger log = LoggerFactory.getLogger(MesStatisticsConfigController.class);
   @Autowired
   private MesStatisticsModeConfigService statisticsModeConfigService;
   @Autowired
   private MesPriceModifyConfigService priceModifyConfigService;

   @ApiOperation("统计模式配置详情")
   @GetMapping("statistics-mode-config/detail")
   public ResultVO statisticsModeConfigDetail() {
      log.info("API 调用 ：统计模式配置详情");
      return ResultBuilder.success(this.statisticsModeConfigService.getInfo());
   }

   @ApiOperation("统计模式配置编辑")
   @PutMapping("statistics-mode-config/edit")
   public ResultVO statisticsModeConfigEdit(@RequestBody @Validated(Update.class) MesStatisticsModeConfigSaveDTOParam param) {
      log.info("API 调用 ：统计模式配置编辑");
      return ResultBuilder.success(this.statisticsModeConfigService.editStatisticsModeConfig(param));
   }

   @ApiOperation("价格修改配置详情")
   @GetMapping("price-modify-config/detail")
   public ResultVO priceModifyConfigDetail() {
      log.info("API 调用 ：价格修改配置详情");
      return ResultBuilder.success(this.priceModifyConfigService.getInfo());
   }

   @ApiOperation("价格修改配置编辑")
   @PutMapping("price-modify-config/edit")
   public ResultVO priceModifyConfigEdit(@RequestBody @Validated(Update.class) MesPriceModifyConfigSaveDTOParam param) {
      log.info("API 调用 ：价格修改配置编辑");
      return ResultBuilder.success(this.priceModifyConfigService.editPriceModifyConfig(param));
   }
}
