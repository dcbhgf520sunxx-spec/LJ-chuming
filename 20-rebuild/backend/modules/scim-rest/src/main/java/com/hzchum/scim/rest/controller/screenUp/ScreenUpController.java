package com.hzchum.scim.rest.controller.screenUp;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.iot.core.api.pojo.dto.screen.IOTProducterDTO;
import com.hzchum.scim.mes.building.core.api.service.screen.ScreenUpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "物联设备对接")
@RestController
@RequestMapping("/api/screen")
public class ScreenUpController {
   private static final Logger log = LoggerFactory.getLogger(ScreenUpController.class);
   @Resource
   private ScreenUpService screenUpService;

   @GetMapping("/device-overview/summary")
   @ApiOperation("设备在线情况")
   public ResultVO<IOTProducterDTO> overview() {
      log.info("API 调用 ：设备在线情况");
      return ResultBuilder.success(this.screenUpService.overview());
   }

   @GetMapping("/use-electric-analysis/summary")
   @ApiOperation("用电分析电量汇总")
   public ResultVO<Map> electricSummary() {
      log.info("API 调用 ：用电分析电量汇总");
      return ResultBuilder.success(this.screenUpService.electricSummary());
   }

   @GetMapping("/use-electric-analysis/electric-chart")
   @ApiOperation("用电分析图表")
   public ResultVO electricAnalysis(Integer timeState) {
      log.info("API 调用 ：用电分析图表");
      return ResultBuilder.success(this.screenUpService.electricAnalysis(timeState));
   }

   @GetMapping("/gas-analysis/gas-chart")
   @ApiOperation("用气分析图表")
   public ResultVO<List<BigDecimal>> gasAnalysis(Integer timeState) {
      log.info("API 调用 ：用气分析图表");
      return ResultBuilder.success(this.screenUpService.gasAnalysis(timeState));
   }

   @GetMapping("/device-overview/device-table")
   @ApiOperation("设备概况列表")
   public ResultVO deviceOverview() {
      log.info("API 调用 ：设备概况列表");
      return ResultBuilder.success(this.screenUpService.deviceOverview());
   }

   @GetMapping("/intelligent/weather")
   @ApiOperation("天气")
   public ResultVO getWeather() {
      log.info("API 调用 ：天气");
      return ResultBuilder.success(this.screenUpService.getWeather());
   }
}
