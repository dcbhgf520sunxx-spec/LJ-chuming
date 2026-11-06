package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.common.core.api.enums.ProductClassificationEnum;
import com.hzchum.scim.common.core.api.enums.ProductSectionNameEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.system.core.api.pojo.vo.MesSectionWarehouseConfigVO;
import com.hzchum.scim.system.core.api.service.MesSectionWarehouseConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "类型截面库")
@RequestMapping("/api/system/section/warehouse/config")
@RestController
@Valid
public class MesSectionWarehouseConfigApi {
   private static final Logger log = LoggerFactory.getLogger(MesSectionWarehouseConfigApi.class);
   @Resource
   private MesSectionWarehouseConfigService mesSectionWarehouseConfigService;

   @ApiOperation("获取截面库列表")
   @GetMapping("list")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productType", value = "产品类型", paramType = "query"),
            @ApiImplicitParam(name = "productClassificationEnum", value = "产品分类", paramType = "query"),
            @ApiImplicitParam(name = "ProductSectionNameEnum", value = "产品截面类型名称分类", paramType = "query")
      }
   )
   public ResultVO list(
      @RequestParam(name = "productType") @EnumValidator(value = ProductTypeEnum.class, message = "产品类型不存在!!!") Integer productType,
      @RequestParam(name = "productClassificationEnum", required = false) @EnumValidator(value = ProductClassificationEnum.class, message = "产品分类不存在!!!") Integer productClassificationEnum,
      @RequestParam(name = "ProductSectionNameEnum", required = false) @EnumValidator(value = ProductSectionNameEnum.class, message = "产品截面类型名称分类不存在!!!") Integer productSectionNameEnum
   ) {
      log.info("API 调用 ：获取截面库列表");
      return ResultBuilder.success(
         this.mesSectionWarehouseConfigService.getSectionWarehouseConfigList(productType, productClassificationEnum, productSectionNameEnum)
      );
   }

   @ApiOperation("获取名称截面库列表")
   @GetMapping("list/sectionName")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productType", value = "产品类型", paramType = "query"),
            @ApiImplicitParam(name = "productClassificationEnum", value = "产品分类", paramType = "query"),
            @ApiImplicitParam(name = "ProductSectionNameEnum", value = "产品截面类型名称分类", paramType = "query")
      }
   )
   public ResultVO listBySectionName(
      @RequestParam(name = "productType", required = false) @EnumValidator(value = ProductTypeEnum.class, message = "产品类型不存在!!!") Integer productType,
      @RequestParam(name = "productClassificationEnum", required = false) @EnumValidator(value = ProductClassificationEnum.class, message = "产品分类不存在!!!") Integer productClassificationEnum,
      @RequestParam(name = "ProductSectionNameEnum", required = false, defaultValue = "1") @EnumValidator(
   value = ProductSectionNameEnum.class,
   message = "产品截面类型名称分类不存在!!!"
) Integer productSectionNameEnum
   ) {
      log.info("API 调用 ：获取截面库列表");
      return ResultBuilder.success(
         this.mesSectionWarehouseConfigService.getSectionWarehouseConfigList(productType, productClassificationEnum, productSectionNameEnum)
      );
   }

   @ApiOperation("获取简单截面库列表")
   @GetMapping("simpleness/list")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "productType", value = "产品类型", paramType = "query"),
            @ApiImplicitParam(name = "productClassificationEnum", value = "产品分类", paramType = "query"),
            @ApiImplicitParam(name = "ProductSectionNameEnum", value = "产品截面类型名称分类", paramType = "query")
      }
   )
   public ResultVO getSimplenessList(
      @RequestParam(name = "productType", required = false) @EnumValidator(value = ProductTypeEnum.class, message = "产品类型不存在!!!") Integer productType,
      @RequestParam(name = "productClassificationEnum", required = false) @EnumValidator(value = ProductClassificationEnum.class, message = "产品分类不存在!!!") Integer productClassificationEnum,
      @RequestParam(name = "ProductSectionNameEnum", required = false) @EnumValidator(value = ProductSectionNameEnum.class, message = "产品截面类型名称分类不存在!!!") Integer productSectionNameEnum
   ) {
      log.info("API 调用 ：获取简单截面库列表");
      return ResultBuilder.success(this.mesSectionWarehouseConfigService.getSimplenessList(productType, productClassificationEnum, productSectionNameEnum));
   }

   @ApiOperation("更新截面库类型")
   @PutMapping("update")
   @SignerCheck(boolMethodAndClassName = true, message = "类型截面库正在操作中,请稍后刷新重试")
   public ResultVO list(@RequestBody @Valid MesSectionWarehouseConfigVO vo) {
      log.info("API 调用 ：更新截面库列表");
      return ResultBuilder.success(this.mesSectionWarehouseConfigService.updateSectionWarehouseConfig(vo));
   }
}
