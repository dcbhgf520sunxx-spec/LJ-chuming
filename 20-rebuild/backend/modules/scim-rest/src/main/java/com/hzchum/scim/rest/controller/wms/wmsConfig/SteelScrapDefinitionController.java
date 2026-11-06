package com.hzchum.scim.rest.controller.wms.wmsConfig;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WasteConfig;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-配置废料定义")
@RestController
@RequestMapping("/api/wms/config/steel/scrap-definition")
public class SteelScrapDefinitionController {
   private static final Logger log = LoggerFactory.getLogger(SteelScrapDefinitionController.class);
   @Resource
   BasicConfigService basicConfigService;

   @ApiOperation("获取废料定义配置")
   @GetMapping
   @PreAuthorize("@permission.check('config_wms_steelScrapDefinition:get')")
   public ResultVO getSteelScrapDefinitionConf() {
      log.info("API 调用 ：获取废料定义配置");
      return ResultBuilder.success(this.basicConfigService.getSteelScrapDefinitionConf());
   }

   @ApiOperation("获取废料定义配置无权限")
   @GetMapping("/getSteelScrapDefinitionConf")
   public ResultVO getSteelScrapDefinitionConfs() {
      log.info("API 调用 ：获取废料定义配置");
      return ResultBuilder.success(this.basicConfigService.getSteelScrapDefinitionConf());
   }

   @ApiOperation("修改入库配置")
   @PutMapping
   @PreAuthorize("@permission.check('config_wms_steelScrapDefinition:edit')")
   public ResultVO setSteelScrapDefinitionConf(@RequestBody WasteConfig wasteConfig) {
      log.info("API 调用 ：修改入库配置");
      return ResultBuilder.success(this.basicConfigService.setSteelScrapDefinitionConf(wasteConfig));
   }
}
