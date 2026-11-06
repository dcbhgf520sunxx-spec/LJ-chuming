package com.hzchum.scim.rest.controller.mes.building.Kpi;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.kpi.MesBuildingKpiBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "发运KPI")
@RestController
@RequestMapping("/api/mes/building/kpi/cargo_list")
public class CargoListKpiController {
   private static final Logger log = LoggerFactory.getLogger(CargoListKpiController.class);
   @Autowired
   private MesBuildingKpiBiz kpiBiz;

   @ApiOperation("获取当年发运量")
   @GetMapping("/summary")
   public ResultVO cargoListSummary(LocalDateTime dateTime) {
      log.info("API 调用 ：获取当年发运量");
      return ResultBuilder.success(this.kpiBiz.cargoListSummary(dateTime));
   }

   @ApiOperation("获取每月发运车次")
   @GetMapping("/quantity")
   public ResultVO cargoListGroupByMonth(LocalDateTime dateTime) {
      log.info("API 调用 ：获取每月发运车次");
      return ResultBuilder.success(new ListVO<>(this.kpiBiz.cargoListGroupByMonth(dateTime)));
   }

   @ApiOperation("获取每月发运量")
   @GetMapping("/amount")
   public ResultVO cargoListAmountGroupByMonth(LocalDateTime dateTime) {
      log.info("API 调用 ：获取每月发运量");
      return ResultBuilder.success(new ListVO<>(this.kpiBiz.cargoListAmountGroupByMonth(dateTime)));
   }

   @ApiOperation("获取当年车型使用统计")
   @GetMapping("/model")
   public ResultVO carModelByYear(LocalDateTime dateTime) {
      log.info("API 调用 ：获取当年车型使用统计");
      return ResultBuilder.success(new ListVO<>(this.kpiBiz.carModelByYear(dateTime)));
   }

   @ApiOperation("获取当年项目发运统计")
   @GetMapping("/project/year")
   public ResultVO projectCargoListByYear(LocalDateTime dateTime) {
      log.info("API 调用 ：获取当年项目发运统计");
      return ResultBuilder.success(new ListVO<>(this.kpiBiz.projectCargoListByYear(dateTime)));
   }

   @ApiOperation("获取当天项目发运统计")
   @GetMapping("/project/day")
   public ResultVO projectCargoListByDay(LocalDateTime dateTime) {
      log.info("API 调用 ：获取当天项目发运统计");
      return ResultBuilder.success(new ListVO<>(this.kpiBiz.projectCargoListByDay(dateTime)));
   }
}
