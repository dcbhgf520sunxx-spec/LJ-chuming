package com.hzchum.scim.rest.controller.business;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.business.core.api.biz.BusinessProductionControlCheckInfoBiz;
import com.hzchum.scim.business.core.api.pojo.dtoParam.ProductionControlCheckInfoDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.ProductionControlConditionFindDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.ProductionControlQuantityChangeDTOParam;
import com.hzchum.scim.business.core.api.service.BusinessProductionControlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "成本管理-生产控制")
@RestController
@RequestMapping("/api/production/control")
public class BusinessProductionControlController {
   private static final Logger log = LoggerFactory.getLogger(BusinessProductionControlController.class);
   @Resource
   private BusinessProductionControlService businessProductionControlService;
   @Resource
   private BusinessProductionControlCheckInfoBiz businessProductionControlCheckInfoBiz;

   @ApiOperation("获取生产控制列表")
   @GetMapping
   public ResultVO list(ProductionControlConditionFindDTOParam request) {
      log.info("API 调用 ：获取生产控制列表");
      return ResultBuilder.success(this.businessProductionControlService.listByCondition(request));
   }

   @ApiOperation("新增生产控制")
   @PostMapping
   public ResultVO save() {
      log.info("API 调用 ：新增生产控制");
      ProductionControlQuantityChangeDTOParam param = ProductionControlQuantityChangeDTOParam.builder()
         .projectId(1L)
         .name("name")
         .specification("specification")
         .material("material")
         .unit("unit")
         .quantity(10)
         .build();
      this.businessProductionControlService.updateControlList(param);
      return ResultBuilder.success(true);
   }

   @ApiOperation("批量修改生产控制")
   @PutMapping
   public ResultVO update(@Validated @RequestBody ProductionControlCheckInfoDTOParam param) {
      log.info("API 调用 ：批量修改生产控制");
      return ResultBuilder.success(this.businessProductionControlCheckInfoBiz.setLossFactor(param));
   }
}
