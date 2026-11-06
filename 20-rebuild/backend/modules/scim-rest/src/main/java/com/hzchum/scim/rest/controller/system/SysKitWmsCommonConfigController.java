package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.system.core.api.common.Result;
import com.hzchum.scim.system.core.api.common.ResultGenerator;
import com.hzchum.scim.system.core.api.pojo.vo.KitWmsCommonConfigVO;
import com.hzchum.scim.system.core.api.service.SysKitWmsCommonConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "配套件关联物料配置")
@RestController
@RequestMapping("/api/kit/wms/common/config")
public class SysKitWmsCommonConfigController {
   private static final Logger log = LoggerFactory.getLogger(SysKitWmsCommonConfigController.class);
   private SysKitWmsCommonConfigService kitWmsAssociationsConfigurationService;

   @ApiOperation("查询配套件关联物料配置")
   @GetMapping("/list")
   public Result getInventoryConfigurationList(
      @RequestParam Boolean boolGeneralConfig,
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Integer pageNumber,
      @RequestParam(required = false) Integer pageSize
   ) {
      log.info("API 调用 ：查询配套件关联物料配置");
      return ResultGenerator.genSuccessResult(
         this.kitWmsAssociationsConfigurationService.getKitWmsCommonConfigList(boolGeneralConfig, projectId, pageNumber, pageSize)
      );
   }

   @ApiOperation("新增配套件关联物料配置")
   @PostMapping("/save")
   @SignerCheck(boolMethodAndClassName = true, message = "正在新增配套件关联物料配置中,请稍后刷新重试!")
   public Result saveInventoryConfiguration(@RequestBody @Valid KitWmsCommonConfigVO configurationVO) {
      log.info("API 调用 ：修改配套件关联物料配置");
      return ResultGenerator.genSuccessResult(this.kitWmsAssociationsConfigurationService.saveKitWmsCommonConfig(configurationVO));
   }

   @ApiOperation("修改配套件关联物料配置")
   @PutMapping("/update")
   public Result updateInventoryConfiguration(@RequestBody @Valid KitWmsCommonConfigVO configurationVO) {
      log.info("API 调用 ：修改配套件关联物料配置");
      return ResultGenerator.genSuccessResult(this.kitWmsAssociationsConfigurationService.updateKitWmsCommonConfig(configurationVO));
   }

   @ApiOperation("删除项目配套件关联物料配置")
   @DeleteMapping("/delete/{id}")
   public Result deleteInventoryConfiguration(@PathVariable("id") Long projectId) {
      log.info("API 调用 ：删除项目配套件关联物料配置");
      return ResultGenerator.genSuccessResult(this.kitWmsAssociationsConfigurationService.deleteKitWmsCommonConfig(projectId));
   }

   public SysKitWmsCommonConfigController(final SysKitWmsCommonConfigService kitWmsAssociationsConfigurationService) {
      this.kitWmsAssociationsConfigurationService = kitWmsAssociationsConfigurationService;
   }
}
