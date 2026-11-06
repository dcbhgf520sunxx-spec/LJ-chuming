package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.common.core.api.enums.ProductClassificationEnum;
import com.hzchum.scim.common.core.api.enums.ProductSectionNameEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.system.core.api.pojo.request.MesBoltSleeveSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesBoltSleeveService;
import com.hzchum.scim.system.core.api.service.MesSectionWarehouseConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "工价配置-栓钉套筒")
@RequestMapping("/api/system/bolt-sleeve")
@RestController
public class MesBoltSleeveController {
   private static final Logger log = LoggerFactory.getLogger(MesBoltSleeveController.class);
   @Autowired
   private MesBoltSleeveService boltSleeveService;
   @Autowired
   private MesSectionWarehouseConfigService sectionWarehouseConfigService;

   @ApiOperation("获取截面库列表")
   @GetMapping("get-section-config-name-list")
   public ResultVO getSectionConfigNameList() {
      log.info("API 调用 ：获取截面库列表");
      return ResultBuilder.success(
         this.sectionWarehouseConfigService
            .getSectionConfigNameList(
               ProductTypeEnum.ARTIFACT.getType(), ProductClassificationEnum.AUXILIARY_MATERIAL.getType(), ProductSectionNameEnum.PRODUCT_NAME.getType()
            )
      );
   }

   @ApiOperation("栓钉套筒列表")
   @GetMapping("list")
   public ResultVO list() {
      log.info("API 调用 ：栓钉套筒列表");
      return ResultBuilder.success(this.boltSleeveService.listInfo());
   }

   @ApiOperation("栓钉套筒详情")
   @GetMapping("detail/{id}")
   public ResultVO detailById(@PathVariable Long id) {
      log.info("API 调用 ：栓钉套筒详情");
      return ResultBuilder.success(this.boltSleeveService.detailById(id));
   }

   @ApiOperation("栓钉套筒新增")
   @PostMapping
   public ResultVO save(@RequestBody @Validated(Add.class) MesBoltSleeveSaveDTOParam param) {
      log.info("API 调用 ：栓钉套筒新增");
      return ResultBuilder.success(this.boltSleeveService.saveMesBoltSleeve(param));
   }

   @ApiOperation("栓钉套筒修改")
   @PutMapping
   public ResultVO edit(@RequestBody @Validated(Update.class) MesBoltSleeveSaveDTOParam param) {
      log.info("API 调用 ：栓钉套筒修改");
      return ResultBuilder.success(this.boltSleeveService.updateMesBoltSleeve(param));
   }

   @ApiOperation("栓钉套筒删除")
   @DeleteMapping("{id}")
   public ResultVO deleteById(@PathVariable Long id) {
      log.info("API 调用 ：栓钉套筒删除");
      return ResultBuilder.success(this.boltSleeveService.deleteById(id));
   }
}
