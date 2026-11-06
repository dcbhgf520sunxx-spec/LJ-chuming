package com.hzchum.scim.rest.controller.wms.wmsConfig;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.RDRateDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.TaxRateDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.TaxRateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-订单税率")
@RestController
@RequestMapping("/api/wms/config/material")
public class TaxRateController {
   private static final Logger log = LoggerFactory.getLogger(TaxRateController.class);
   @Resource
   TaxRateService taxRateService;

   @ApiOperation("获取税率")
   @GetMapping("/tax-rate")
   public ResultVO list() {
      log.info("API 调用 ：获取税率");
      return ResultBuilder.success(this.taxRateService.listInfo());
   }

   @ApiOperation("获取简单税率")
   @GetMapping("/tax-rate/all/brief")
   public ResultVO getTaxRateBrief() {
      log.info("API 调用 ：获取简单税率");
      return ResultBuilder.success(this.taxRateService.getTaxRateBrief());
   }

   @ApiOperation("设置税率")
   @PutMapping("/tax-rate")
   @PreAuthorize("@permission.check('config_commonTaxRate:edit')")
   public ResultVO updateTaxRate(@RequestBody TaxRateDTOParam taxRateDTOParam) {
      log.info("API 调用 ：设置税率");
      return ResultBuilder.success(this.taxRateService.updateTaxRate(taxRateDTOParam));
   }

   @ApiOperation("获取高新研发比例")
   @GetMapping("/high-tech-rd-fee")
   public ResultVO rdRateList() {
      log.info("API 调用 ：获取高新研发比例");
      return ResultBuilder.success(this.taxRateService.rdRateList());
   }

   @ApiOperation("设置高新研发比例")
   @PutMapping("/high-tech-rd-fee")
   @PreAuthorize("@permission.check('wms_report_rawMat_highTechRDFee:setRdRate')")
   public ResultVO updateRdRate(@RequestBody List<RDRateDTOParam> params) {
      log.info("API 调用 ：设置高新研发比例");
      return ResultBuilder.success(this.taxRateService.updateRdRate(params));
   }
}
