package com.hzchum.scim.rest.controller.plan;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.plan.core.api.biz.ProductBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "计划管理-产品")
@RestController
@RequestMapping("/api/plan/product")
public class ProductController {
   private static final Logger log = LoggerFactory.getLogger(ProductController.class);
   @Autowired
   private ProductBiz productBiz;

   @ApiOperation("根据产品id和产品类型获取产品基本信息")
   @GetMapping("/getProductInfo")
   public ResultVO list(@RequestParam Long productId, @RequestParam Integer productType) {
      log.info("API 调用 ：根据产品id和产品类型获取产品基本信息");
      return ResultBuilder.success(this.productBiz.getProductInfoBy(productId, productType));
   }
}
