package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.common.core.api.enums.ProductClassificationEnum;
import com.hzchum.scim.common.core.api.enums.ProductSectionNameEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.system.core.api.pojo.request.MesContractProjectBoltSleeveLinkSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesContractProjectBoltSleeveLinkService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "项目工价配置-栓钉套筒")
@RequestMapping("/api/system/project-bolt-sleeve")
@RestController
public class MesContractProjectBoltSleeveLinkController {
   private static final Logger log = LoggerFactory.getLogger(MesContractProjectBoltSleeveLinkController.class);
   @Autowired
   private MesContractProjectBoltSleeveLinkService boltSleeveLinkService;
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
   public ResultVO list(@RequestParam Long projectId) {
      log.info("API 调用 ：栓钉套筒列表");
      return ResultBuilder.success(new ListVO<>(this.boltSleeveLinkService.listInfo(projectId)));
   }

   @ApiOperation("栓钉套筒详情")
   @GetMapping("detail/{id}")
   public ResultVO detailById(@PathVariable Long id) {
      log.info("API 调用 ：栓钉套筒详情");
      return ResultBuilder.success(this.boltSleeveLinkService.detailById(id));
   }

   @ApiOperation("栓钉套筒新增")
   @PostMapping
   public ResultVO save(@RequestBody @Validated(Add.class) MesContractProjectBoltSleeveLinkSaveDTOParam param) {
      log.info("API 调用 ：栓钉套筒新增");
      return ResultBuilder.success(this.boltSleeveLinkService.saveConfig(param));
   }

   @ApiOperation("栓钉套筒修改")
   @PutMapping
   public ResultVO edit(@RequestBody @Validated(Update.class) MesContractProjectBoltSleeveLinkSaveDTOParam param) {
      log.info("API 调用 ：栓钉套筒修改");
      return ResultBuilder.success(this.boltSleeveLinkService.updateConfig(param));
   }

   @ApiOperation("栓钉套筒删除")
   @DeleteMapping("{id}")
   public ResultVO deleteById(@PathVariable Long id) {
      log.info("API 调用 ：栓钉套筒删除");
      return ResultBuilder.success(this.boltSleeveLinkService.deleteById(id));
   }
}
