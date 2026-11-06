package com.hzchum.scim.rest.controller.mes.building.cargoList;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES发运-报表")
@RestController
@RequestMapping("/api/mes/building/cargo/report")
public class CargoListReportController {
   private static final Logger log = LoggerFactory.getLogger(CargoListReportController.class);
   @Autowired
   private MesBuildingCargoListService cargoListService;

   @ApiOperation("发运报表")
   @GetMapping("ship")
   public ResultVO ship(Long projectId, String month) {
      log.info("API 调用 ：发运报表");
      return ResultBuilder.success(this.cargoListService.sumShipmentQuantityGroupByDate(projectId, month));
   }
}
