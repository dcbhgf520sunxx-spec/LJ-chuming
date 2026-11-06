package com.hzchum.scim.rest.controller.mes.building.report;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "APP-MES-产量汇总")
@RestController
@RequestMapping("/api/mes/building/mete/summary")
public class AppMeteSummaryController {
   private static final Logger log = LoggerFactory.getLogger(AppMeteSummaryController.class);
   @Autowired
   private MesBuildingCompleteService completeService;

   @ApiOperation("产量汇总数据")
   @GetMapping
   public ResultVO listGroupByDate(@RequestParam Integer productType, String year, String month, Long factoryId) {
      log.info("API 调用 ：产量汇总数据");
      return ResultBuilder.success(this.completeService.listGroupByDate(year, month, productType, factoryId));
   }

   @ApiOperation("围护产量汇总详情")
   @GetMapping("enclosure")
   public ResultVO listArtifactPrint(String month, String date, Long factoryId) {
      log.info("API 调用 ：围护产量汇总详情");
      return ResultBuilder.success(this.completeService.listEnclosureGroupByDate(month, date, factoryId));
   }
}
