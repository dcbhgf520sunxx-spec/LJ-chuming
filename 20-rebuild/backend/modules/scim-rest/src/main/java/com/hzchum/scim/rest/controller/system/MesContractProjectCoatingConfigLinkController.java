package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.system.core.api.pojo.request.MesContractProjectCoatingConfigLinkSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesContractProjectCoatingConfigLinkService;
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

@Api(tags = "项目工价配置-涂装配置")
@RequestMapping("/api/system/project-coating-config")
@RestController
public class MesContractProjectCoatingConfigLinkController {
   private static final Logger log = LoggerFactory.getLogger(MesContractProjectCoatingConfigLinkController.class);
   @Autowired
   private MesContractProjectCoatingConfigLinkService coatingConfigLinkService;

   @ApiOperation("列表")
   @GetMapping("list")
   public ResultVO list(@RequestParam Long projectId) {
      log.info("API 调用 ：项目工价配置-涂装配置列表");
      return ResultBuilder.success(new ListVO<>(this.coatingConfigLinkService.listInfo(projectId)));
   }

   @ApiOperation("详情")
   @GetMapping("detail/{id}")
   public ResultVO detailById(@PathVariable Long id) {
      log.info("API 调用 ：项目工价配置-涂装配置详情");
      return ResultBuilder.success(this.coatingConfigLinkService.detailById(id));
   }

   @ApiOperation("新增")
   @PostMapping
   public ResultVO save(@RequestBody @Validated(Add.class) MesContractProjectCoatingConfigLinkSaveDTOParam param) {
      log.info("API 调用 ：项目工价配置-涂装配置新增");
      return ResultBuilder.success(this.coatingConfigLinkService.saveConfig(param));
   }

   @ApiOperation("修改")
   @PutMapping
   public ResultVO edit(@RequestBody @Validated(Update.class) MesContractProjectCoatingConfigLinkSaveDTOParam param) {
      log.info("API 调用 ：项目工价配置-涂装配置修改");
      return ResultBuilder.success(this.coatingConfigLinkService.updateConfig(param));
   }

   @ApiOperation("修改状态")
   @PutMapping("update-status")
   public ResultVO updateStatus(@RequestParam Long id, @RequestParam Boolean status) {
      log.info("API 调用 ：项目工价配置-涂装配置修改状态");
      return ResultBuilder.success(this.coatingConfigLinkService.updateStatus(id, status));
   }

   @ApiOperation("删除")
   @DeleteMapping("{id}")
   public ResultVO deleteById(@PathVariable Long id) {
      log.info("API 调用 ：项目工价配置-涂装配置删除");
      return ResultBuilder.success(this.coatingConfigLinkService.deleteById(id));
   }
}
