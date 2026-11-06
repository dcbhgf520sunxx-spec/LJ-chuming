package com.hzchum.scim.rest.controller.mes.building.qhse;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "APP-MES-Qhse")
@RestController
@RequestMapping("/api/app/mes/building/qhse")
public class AppQhseController {
   private static final Logger log = LoggerFactory.getLogger(AppQhseController.class);
   @Autowired
   private MesBuildingQhseService qhseService;

   @ApiOperation("QHSE报表")
   @GetMapping("/report")
   public ResultVO qhseById(@RequestParam String year) {
      log.info("API 调用 ：QHSE报表");
      return ResultBuilder.success(this.qhseService.report(year));
   }
}
