package com.hzchum.scim.rest.controller.largeScreen;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.cargoList.MesBuildingCargoListBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListStatisticsQueryParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "中南定制:大屏-项目发运")
@RestController
@RequestMapping("/api/largeScreen/custom")
public class LargeScreenProjectShipmentController {
   private static final Logger log = LoggerFactory.getLogger(LargeScreenProjectShipmentController.class);
   private final MesBuildingCargoListBiz cargoListBiz;

   @ApiOperation("项目-发运信息")
   @GetMapping("/project/shipment/info")
   public ResultVO<ListVO<Map<String, Object>>> projectCargoListMeteSummary(CargoListStatisticsQueryParam param) {
      log.info("API调用:大屏查询-项目发运信息");
      param.setWeightStatus(param.getWeightStatus() != null ? param.getWeightStatus() : 1);
      List<Map<String, Object>> mapList = this.cargoListBiz.projectCargoListMeteSummaryV2(param).stream().map(s -> {
         Map<String, Object> map = new HashMap<>(16);
         Map<String, Object> project = new HashMap<>(16);
         if (s.getProject() != null) {
            project.put("id", s.getProject().getId());
            project.put("name", s.getProject().getName());
            project.put("shortName", s.getProject().getShortName());
            project.put("serialNumber", s.getProject().getSerialNumber());
         }

         map.put("project", project);
         map.put("warehouseGrossMete", s.getWarehouseGrossMete().divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP));
         map.put("sendGrossMete", s.getSendGrossMete().divide(BigDecimal.valueOf(1000L), 2, RoundingMode.HALF_UP));
         return map;
      }).collect(Collectors.toList());
      return ResultBuilder.success(new ListVO<>(mapList));
   }

   public LargeScreenProjectShipmentController(final MesBuildingCargoListBiz cargoListBiz) {
      this.cargoListBiz = cargoListBiz;
   }
}
