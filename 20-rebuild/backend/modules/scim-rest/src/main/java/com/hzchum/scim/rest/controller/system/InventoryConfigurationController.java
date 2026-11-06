package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.system.core.api.common.Result;
import com.hzchum.scim.system.core.api.common.ResultGenerator;
import com.hzchum.scim.system.core.api.pojo.vo.InventoryConfigurationVO;
import com.hzchum.scim.system.core.api.service.SysInventoryConfigurationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "清单误差配置")
@RestController
@RequestMapping("/api/inventory/configuration")
public class InventoryConfigurationController {
   private static final Logger log = LoggerFactory.getLogger(InventoryConfigurationController.class);
   @Resource
   private SysInventoryConfigurationService inventoryConfigurationService;

   @ApiOperation("查询清单误差配置列表")
   @GetMapping("/list")
   public Result getInventoryConfigurationList(
      @RequestParam Boolean boolGeneralConfig, @RequestParam(required = false) Long projectId, @RequestParam Integer pageNumber, @RequestParam Integer pageSize
   ) {
      log.info("API 调用 ：查询清单误差配置列表");
      return ResultGenerator.genSuccessResult(
         this.inventoryConfigurationService.getInventoryConfigurationList(boolGeneralConfig, projectId, pageNumber, pageSize)
      );
   }

   @ApiOperation("新增清单误差配置")
   @PostMapping("/add")
   @SignerCheck(boolMethodAndClassName = true, message = "正在新增清单误差配置中,请稍后刷新重试!")
   public Result saveInventoryConfiguration(@RequestBody @Valid InventoryConfigurationVO configurationVO) {
      log.info("API 调用 ：修改清单误差配置");
      return ResultGenerator.genSuccessResult(this.inventoryConfigurationService.saveInventoryConfiguration(configurationVO));
   }

   @ApiOperation("修改清单误差配置")
   @PutMapping("/update")
   public Result updateInventoryConfiguration(@RequestBody @Valid InventoryConfigurationVO configurationVO) {
      log.info("API 调用 ：修改清单误差配置");
      return ResultGenerator.genSuccessResult(this.inventoryConfigurationService.updateInventoryConfiguration(configurationVO));
   }

   @ApiOperation("删除项目清单误差配置")
   @DeleteMapping("/remove")
   public Result deleteInventoryConfiguration(Long projectId) {
      log.info("API 调用 ：删除项目清单误差配置");
      return ResultGenerator.genSuccessResult(this.inventoryConfigurationService.deleteInventoryConfiguration(projectId));
   }

   public InventoryConfigurationController(final SysInventoryConfigurationService inventoryConfigurationService) {
      this.inventoryConfigurationService = inventoryConfigurationService;
   }
}
