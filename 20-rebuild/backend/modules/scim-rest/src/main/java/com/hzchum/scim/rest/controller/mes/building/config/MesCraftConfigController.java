package com.hzchum.scim.rest.controller.mes.building.config;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.service.ConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "工艺配置")
@RestController
@RequestMapping("/api/mes/building/craft/config")
public class MesCraftConfigController {
   private static final Logger log = LoggerFactory.getLogger(MesCraftConfigController.class);
   @Autowired
   ConfigService configService;

   @ApiOperation("获取工艺配置")
   @GetMapping("")
   public ResultVO getCraftConfig() {
      log.info("Api调用:获取工艺配置");
      return ResultBuilder.success(this.configService.getCraftConfig());
   }
}
