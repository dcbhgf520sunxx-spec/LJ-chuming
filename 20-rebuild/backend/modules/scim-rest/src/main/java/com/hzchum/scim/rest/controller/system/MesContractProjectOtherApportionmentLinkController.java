package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.system.core.api.pojo.request.MesContractProjectOtherApportionmentLinkSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesContractProjectOtherApportionmentLinkService;
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

@Api(tags = "项目工价配置-其他分摊")
@RequestMapping("/api/system/project-other-apportionment")
@RestController
public class MesContractProjectOtherApportionmentLinkController {
   private static final Logger log = LoggerFactory.getLogger(MesContractProjectOtherApportionmentLinkController.class);
   @Autowired
   private MesContractProjectOtherApportionmentLinkService otherApportionmentLinkService;

   @ApiOperation("列表")
   @GetMapping("list")
   public ResultVO list(@RequestParam Long projectId) {
      log.info("API 调用 ：项目工价配置-其他分摊列表");
      return ResultBuilder.success(new ListVO<>(this.otherApportionmentLinkService.listInfo(projectId)));
   }

   @ApiOperation("详情")
   @GetMapping("detail/{id}")
   public ResultVO detailById(@PathVariable Long id) {
      log.info("API 调用 ：项目工价配置-其他分摊详情");
      return ResultBuilder.success(this.otherApportionmentLinkService.detailById(id));
   }

   @ApiOperation("新增")
   @PostMapping
   public ResultVO save(@RequestBody @Validated(Add.class) MesContractProjectOtherApportionmentLinkSaveDTOParam param) {
      log.info("API 调用 ：项目工价配置-其他分摊新增");
      return ResultBuilder.success(this.otherApportionmentLinkService.saveConfig(param));
   }

   @ApiOperation("修改")
   @PutMapping
   public ResultVO edit(@RequestBody @Validated(Update.class) MesContractProjectOtherApportionmentLinkSaveDTOParam param) {
      log.info("API 调用 ：项目工价配置-其他分摊修改");
      return ResultBuilder.success(this.otherApportionmentLinkService.editConfig(param));
   }

   @ApiOperation("修改状态")
   @PutMapping("status")
   public ResultVO updateStatus(@RequestParam Long id, @RequestParam Boolean status) {
      log.info("API 调用 ：项目工价配置-其他分摊修改状态");
      return ResultBuilder.success(this.otherApportionmentLinkService.updateStatus(id, status));
   }

   @ApiOperation("删除")
   @DeleteMapping("{id}")
   public ResultVO deleteById(@PathVariable Long id) {
      log.info("API 调用 ：项目工价配置-其他分摊删除");
      return ResultBuilder.success(this.otherApportionmentLinkService.deleteById(id));
   }
}
