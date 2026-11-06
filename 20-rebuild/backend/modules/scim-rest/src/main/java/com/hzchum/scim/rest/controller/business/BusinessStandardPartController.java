package com.hzchum.scim.rest.controller.business;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.business.core.api.biz.BusinessStandardPartBiz;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessStandardPartDTO;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessStandardPartQueryDtoParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.StandardPartCheckInfoDTOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "销售管理-商务管理-标准件")
@RestController
@RequestMapping("/api/business/standardPart")
public class BusinessStandardPartController {
   private static final Logger log = LoggerFactory.getLogger(BusinessStandardPartController.class);
   private final BusinessStandardPartBiz businessStandardPartBiz;

   @ApiOperation("标准件-商务列表")
   @GetMapping
   public ResultVO<PageVO<BusinessStandardPartDTO>> pageList(
      @Valid BusinessStandardPartQueryDtoParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:标准件商务价格列表");
      return ResultBuilder.success(this.businessStandardPartBiz.pageListBusiness(param, pageNumber, pageSize));
   }

   @ApiOperation("标准件-商务列表-打印")
   @GetMapping("/print")
   public ResultVO printList(@Valid BusinessStandardPartQueryDtoParam param) {
      log.info("Api调用:标准件商务价格列表打印");
      return ResultBuilder.success(this.businessStandardPartBiz.printListBusiness(param));
   }

   @ApiOperation("标准件商务-设置标准件价格")
   @PutMapping
   public ResultVO setPrice(@RequestBody @Valid StandardPartCheckInfoDTOParam param) {
      log.info("Api调用:标准件商务-设置价格");
      return ResultBuilder.success(this.businessStandardPartBiz.setUnitPrice(param));
   }

   public BusinessStandardPartController(final BusinessStandardPartBiz businessStandardPartBiz) {
      this.businessStandardPartBiz = businessStandardPartBiz;
   }
}
