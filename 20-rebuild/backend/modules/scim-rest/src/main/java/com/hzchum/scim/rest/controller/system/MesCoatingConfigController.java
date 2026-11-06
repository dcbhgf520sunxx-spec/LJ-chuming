package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.system.core.api.pojo.request.MesCoatingConfigSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesCoatingConfigService;
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

@Api(tags = "工价配置-涂装配置")
@RequestMapping("/api/system/coating-config")
@RestController
public class MesCoatingConfigController {
   private static final Logger log = LoggerFactory.getLogger(MesCoatingConfigController.class);
   @Autowired
   private MesCoatingConfigService coatingConfigService;

   @ApiOperation("涂装配置列表")
   @GetMapping("list")
   public ResultVO list() {
      log.info("API 调用 ：涂装配置列表");
      return ResultBuilder.success(this.coatingConfigService.listInfo());
   }

   @ApiOperation("涂装配置详情")
   @GetMapping("detail/{id}")
   public ResultVO detailById(@PathVariable Long id) {
      log.info("API 调用 ：涂装配置详情");
      return ResultBuilder.success(this.coatingConfigService.detailById(id));
   }

   @ApiOperation("涂装配置新增")
   @PostMapping
   public ResultVO save(@RequestBody @Validated(Add.class) MesCoatingConfigSaveDTOParam param) {
      log.info("API 调用 ：涂装配置新增");
      return ResultBuilder.success(this.coatingConfigService.saveCoatingConfig(param));
   }

   @ApiOperation("涂装配置修改")
   @PutMapping
   public ResultVO edit(@RequestBody @Validated(Update.class) MesCoatingConfigSaveDTOParam param) {
      log.info("API 调用 ：涂装配置修改");
      return ResultBuilder.success(this.coatingConfigService.updateCoatingConfig(param));
   }

   @ApiOperation("涂装配置修改状态")
   @PutMapping("update-status")
   public ResultVO updateStatus(@RequestParam Long id, @RequestParam Boolean status) {
      log.info("API 调用 ：涂装配置修改状态");
      return ResultBuilder.success(this.coatingConfigService.updateStatus(id, status));
   }

   @ApiOperation("涂装配置删除")
   @DeleteMapping("{id}")
   public ResultVO deleteById(@PathVariable Long id) {
      log.info("API 调用 ：涂装配置删除");
      return ResultBuilder.success(this.coatingConfigService.deleteById(id));
   }
}
