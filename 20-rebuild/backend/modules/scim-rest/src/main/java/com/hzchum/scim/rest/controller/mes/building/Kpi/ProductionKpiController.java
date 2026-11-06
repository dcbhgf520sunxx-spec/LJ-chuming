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

@Api(tags = "生产KPI")
@RestController
@RequestMapping("/api/mes/building/kpi/production")
public class ProductionKpiController {
   private static final Logger log = LoggerFactory.getLogger(ProductionKpiController.class);
   @Autowired
   private MesBuildingKpiBiz kpiBiz;

   @ApiOperation("获取每月生产量")
   @GetMapping("/complete/year")
   public ResultVO completeByYear(LocalDateTime dateTime) {
      log.info("API 调用 ：获取每月生产量");
      return ResultBuilder.success(this.kpiBiz.completeByYear(dateTime));
   }

   @ApiOperation("获取每月生产量")
   @GetMapping("/complete/yield")
   public ResultVO completeYieldGropMonth(LocalDateTime dateTime) {
      log.info("API 调用 ：获取每月生产量");
      return ResultBuilder.success(new ListVO<>(this.kpiBiz.completeYieldGropMonth(dateTime)));
   }

   @ApiOperation("获取生产线生产量")
   @GetMapping("/production_line/complete/yield")
   public ResultVO productionLineCompleteYieldGropMonth(LocalDateTime dateTime) {
      log.info("API 调用 ：获取生产线生产量");
      return ResultBuilder.success(new ListVO<>(this.kpiBiz.productionLineCompleteYieldGropMonth(dateTime)));
   }

   @ApiOperation("获取项目生产信息")
   @GetMapping("/project/complete/yield")
   public ResultVO projectCompleteYield(LocalDateTime dateTime) {
      log.info("API 调用 ：获取项目生产信息");
      return ResultBuilder.success(new ListVO<>(this.kpiBiz.projectCompleteYield(dateTime)));
   }

   @ApiOperation("获取每月发运车次")
   @GetMapping("/cargoList")
   public ResultVO cargoListGroupByMonth(LocalDateTime dateTime) {
      log.info("API 调用 ：获取每月发运车次");
      return ResultBuilder.success(new ListVO<>(this.kpiBiz.cargoListGroupByMonth(dateTime)));
   }

   @ApiOperation("获取当年问题上报数量按类型分组")
   @GetMapping("/qhse/type")
   public ResultVO qhseType(LocalDateTime dateTime) {
      log.info("API 调用 ：获取当年问题上报数量按类型分组");
      return ResultBuilder.success(new ListVO<>(this.kpiBiz.qhseType(dateTime)));
   }

   @ApiOperation("查询质量问题上报数量按问题原因分组")
   @GetMapping("/qhse/type/quality")
   public ResultVO qualityQhseType(LocalDateTime dateTime) {
      log.info("API 调用 ：查询质量问题上报数量按问题原因分组");
      return ResultBuilder.success(new ListVO<>(this.kpiBiz.qualityQhseType(dateTime)));
   }
}
