package com.hzchum.scim.rest.controller.business;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.business.core.api.biz.BusinessPriceTempBiz;
import com.hzchum.scim.business.core.api.pojo.dto.BusinessPriceTempDTO;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessPriceTempDtoQueryParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.BusinessPriceTempUpdateDtoParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.PriceTempQueryDtoParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.TempToCheckSaveDtoParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "价格管理-临时保存记录")
@Validated
@RestController
@RequestMapping("/api/business/tempPrice")
public class BusinessPriceTempController {
   private static final Logger log = LoggerFactory.getLogger(BusinessPriceTempController.class);
   private final BusinessPriceTempBiz businessPriceTempBiz;

   @ApiOperation("保存记录-列表")
   @GetMapping
   @PreAuthorize("@permission.check('sale_price_manage:log')")
   public ResultVO<PageVO<BusinessPriceTempDTO>> pageList(
      @Valid BusinessPriceTempDtoQueryParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 价格临时保存记录列表");
      return ResultBuilder.success(this.businessPriceTempBiz.pageList(param, pageNumber, pageSize));
   }

   @ApiOperation("保存记录-修改")
   @PutMapping
   public ResultVO update(@RequestBody @Valid List<BusinessPriceTempUpdateDtoParam> params) {
      log.info("Api调用: 价格临时保存记录修改");
      return ResultBuilder.success(this.businessPriceTempBiz.updateTemp(params));
   }

   @ApiOperation("保存记录-删除")
   @DeleteMapping
   public ResultVO del(@RequestBody List<Long> ids) {
      log.info("Api调用: 价格临时保存记录删除");
      return ResultBuilder.success(this.businessPriceTempBiz.delTemp(ids));
   }

   @ApiOperation("保存记录-提交审核")
   @PostMapping("/commitCheck")
   public ResultVO commitCheck(@RequestBody @Valid TempToCheckSaveDtoParam param) {
      log.info("Api调用: 价格临时保存记录提交审核");
      return ResultBuilder.success(this.businessPriceTempBiz.commitToCheck(param));
   }

   @ApiOperation("保存记录-条数")
   @GetMapping("/count")
   public ResultVO commitCheck(@Valid PriceTempQueryDtoParam param) {
      log.info("Api调用: 价格临时保存记录条数");
      return ResultBuilder.success(this.businessPriceTempBiz.priceTempCount(param));
   }

   public BusinessPriceTempController(final BusinessPriceTempBiz businessPriceTempBiz) {
      this.businessPriceTempBiz = businessPriceTempBiz;
   }
}
