package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.system.core.api.pojo.request.MesContractProjectOddJobConfigLinkSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesContractProjectOddJobConfigLinkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@Api(tags = "项目工价配置-零工配置")
@RequestMapping("/api/system/project-odd-job-config")
@RestController
public class MesContractProjectOddJobConfigLinkController {
   private static final Logger log = LoggerFactory.getLogger(MesContractProjectOddJobConfigLinkController.class);
   @Resource
   private MesContractProjectOddJobConfigLinkService oddJobConfigLinkService;

   @ApiOperation("分页列表")
   @GetMapping("page")
   public ResultVO list(
      @RequestParam Long projectId,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：项目工价配置-零工配置列表");
      return ResultBuilder.success(this.oddJobConfigLinkService.pageInfo(projectId, pageNumber, pageSize, sort));
   }

   @ApiOperation("列表")
   @GetMapping("list")
   public ResultVO list(@RequestParam Long projectId) {
      log.info("API 调用 ：项目工价配置-零工配置列表");
      return ResultBuilder.success(new ListVO<>(this.oddJobConfigLinkService.listInfo(projectId)));
   }

   @ApiOperation("详情")
   @GetMapping("detail/{id}")
   public ResultVO detailById(@PathVariable Long id) {
      log.info("API 调用 ：项目工价配置-零工配置详情");
      return ResultBuilder.success(this.oddJobConfigLinkService.detailById(id));
   }

   @ApiOperation("新增")
   @PostMapping
   public ResultVO save(@RequestBody @Validated(Add.class) MesContractProjectOddJobConfigLinkSaveDTOParam param) {
      log.info("Api调用: 项目工价配置-零工配置新增");
      return ResultBuilder.success(this.oddJobConfigLinkService.saveConfig(param));
   }

   @ApiOperation("修改")
   @PutMapping
   public ResultVO edit(@RequestBody @Validated(Update.class) MesContractProjectOddJobConfigLinkSaveDTOParam param) {
      log.info("Api调用: 项目工价配置-零工配置修改");
      return ResultBuilder.success(this.oddJobConfigLinkService.editConfig(param));
   }

   @ApiOperation("修改状态")
   @PutMapping("status")
   public ResultVO updateStatus(@RequestParam Long id, @RequestParam Boolean status) {
      log.info("API 调用 ：项目工价配置-零工配置修改状态");
      return ResultBuilder.success(this.oddJobConfigLinkService.updateStatus(id, status));
   }

   @ApiOperation("删除")
   @DeleteMapping("/{id}")
   public ResultVO deleteById(@PathVariable Long id) {
      log.info("Api调用: 项目工价配置-零工配置删除");
      return ResultBuilder.success(this.oddJobConfigLinkService.deleteById(id));
   }
}
