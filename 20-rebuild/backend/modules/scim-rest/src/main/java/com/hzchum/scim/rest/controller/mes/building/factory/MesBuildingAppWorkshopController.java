package com.hzchum.scim.rest.controller.mes.building.factory;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingCompleteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "app-MES车间")
@RestController
@RequestMapping("/api/app/mes/building/workshop")
public class MesBuildingAppWorkshopController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingAppWorkshopController.class);
   @Autowired
   private MesBuildingCompleteService completeService;

   @ApiOperation("获取车间报表")
   @GetMapping("/report")
   @PreAuthorize("@permission.check('factorySummary')")
   public ResultVO getWorkshopReport(LocalDateTime dateTime, Long workShopId, Long productionLineId) {
      log.info("API 调用 ：获取车间报表");
      return ResultBuilder.success(this.completeService.getWorkshopReport(dateTime, workShopId, productionLineId, 1));
   }

   @ApiOperation("全年累计产量")
   @GetMapping("/year/mete/summary")
   public ResultVO meteSummaryByYear(LocalDateTime dateTime, Long workShopId, Long productionLineId) {
      log.info("API 调用 ：全年累计产量");
      return ResultBuilder.success(this.completeService.meteSummaryByYear(dateTime, workShopId, productionLineId));
   }
}
