package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.bid.core.api.service.CnaRegionService;
import com.hzchum.scim.system.core.api.service.SysCountryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "系统管理-公共API")
@RestController
@RequestMapping("/api")
public class CommonApi {
   private static final Logger log = LoggerFactory.getLogger(CommonApi.class);
   private final SysCountryService countryService;
   private final CnaRegionService cnaRegionService;

   @ApiOperation(value = "国家/省/市/区 级联列表", notes = "国家/省/市/区 级联列表")
   @GetMapping("/regionalCascade")
   public ResultVO listAll() {
      log.info("API 调用 ：国家/省/市/区 级联列表");
      return ResultBuilder.success(this.countryService.listAll());
   }

   @ApiOperation(value = "区域 级联列表", notes = "区域 级联列表")
   @GetMapping("/regionalCascadeNew")
   public ResultVO listAllNew() {
      log.info("API 调用 ：国家/省/市/区 级联列表");
      return ResultBuilder.success(this.countryService.listAllNew());
   }

   @GetMapping("/cna/region")
   public ResultVO listCnaRegion() {
      log.info("API 调用(招标) ：大区/省/市/区(县) 级联列表");
      return ResultBuilder.success(this.cnaRegionService.listAll());
   }

   public CommonApi(final SysCountryService countryService, final CnaRegionService cnaRegionService) {
      this.countryService = countryService;
      this.cnaRegionService = cnaRegionService;
   }
}
