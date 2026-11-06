package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.system.core.api.pojo.request.MesEnclosureWageConfigSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesEnclosureWageConfigService;
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

@Api(tags = "工价配置-围护工价配置")
@RequestMapping("/api/system/enclosure-wage-config")
@RestController
public class MesEnclosureWageConfigController {
   private static final Logger log = LoggerFactory.getLogger(MesEnclosureWageConfigController.class);
   @Autowired
   private MesEnclosureWageConfigService enclosureWageConfigService;

   @ApiOperation("围护工价配置列表")
   @GetMapping("list")
   public ResultVO list() {
      log.info("API 调用 ：围护工价配置列表");
      return ResultBuilder.success(this.enclosureWageConfigService.listInfo());
   }

   @ApiOperation("围护工价配置详情")
   @GetMapping("detail/{id}")
   public ResultVO detailById(@PathVariable Long id) {
      log.info("API 调用 ：围护工价配置详情");
      return ResultBuilder.success(this.enclosureWageConfigService.detailById(id));
   }

   @ApiOperation("新增-围护工价配置")
   @PostMapping
   public ResultVO save(@RequestBody @Validated(Add.class) MesEnclosureWageConfigSaveDTOParam param) {
      log.info("Api调用: 新增围护工价配置");
      return ResultBuilder.success(this.enclosureWageConfigService.saveEnclosureWageConfig(param));
   }

   @ApiOperation("修改-围护工价配置")
   @PutMapping
   public ResultVO edit(@RequestBody @Validated(Update.class) MesEnclosureWageConfigSaveDTOParam param) {
      log.info("Api调用: 修改围护工价配置");
      return ResultBuilder.success(this.enclosureWageConfigService.editEnclosureWageConfig(param));
   }

   @ApiOperation("修改状态-围护工价配置")
   @PutMapping("status")
   public ResultVO updateStatus(@RequestParam Long id, @RequestParam Boolean status) {
      log.info("API 调用 ：修改状态");
      return ResultBuilder.success(this.enclosureWageConfigService.updateStatus(id, status));
   }

   @ApiOperation("删除-围护工价配置")
   @DeleteMapping("/{id}")
   public ResultVO deleteById(@PathVariable Long id) {
      log.info("Api调用: 删除围护工价配置");
      return ResultBuilder.success(this.enclosureWageConfigService.deleteEnclosureWageConfigById(id));
   }
}
