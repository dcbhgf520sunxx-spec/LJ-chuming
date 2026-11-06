package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.system.core.api.pojo.request.MesOddJobConfigSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesOddJobConfigService;
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

@Api(tags = "工价配置-零工配置")
@RequestMapping("/api/system/odd-job-config")
@RestController
public class MesOddJobConfigController {
   private static final Logger log = LoggerFactory.getLogger(MesOddJobConfigController.class);
   @Resource
   private MesOddJobConfigService oddJobConfigService;

   @ApiOperation("零工配置分页列表")
   @GetMapping("page")
   public ResultVO list(
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：零工配置列表");
      return ResultBuilder.success(this.oddJobConfigService.pageInfo(pageNumber, pageSize, sort));
   }

   @ApiOperation("零工配置列表")
   @GetMapping("list")
   public ResultVO list() {
      log.info("API 调用 ：零工配置列表");
      return ResultBuilder.success(this.oddJobConfigService.listInfo());
   }

   @ApiOperation("零工配置详情")
   @GetMapping("detail/{id}")
   public ResultVO detailById(@PathVariable Long id) {
      log.info("API 调用 ：零工配置详情");
      return ResultBuilder.success(this.oddJobConfigService.detailById(id));
   }

   @ApiOperation("新增-零工配置")
   @PostMapping
   public ResultVO save(@RequestBody @Validated(Add.class) MesOddJobConfigSaveDTOParam param) {
      log.info("Api调用: 新增零工配置");
      return ResultBuilder.success(this.oddJobConfigService.saveOddJobConfig(param));
   }

   @ApiOperation("修改-零工配置")
   @PutMapping
   public ResultVO edit(@RequestBody @Validated(Update.class) MesOddJobConfigSaveDTOParam param) {
      log.info("Api调用: 修改零工配置");
      return ResultBuilder.success(this.oddJobConfigService.editOddJobConfig(param));
   }

   @ApiOperation("修改状态-零工配置")
   @PutMapping("status")
   public ResultVO updateStatus(@RequestParam Long id, @RequestParam Boolean status) {
      log.info("API 调用 ：修改状态");
      return ResultBuilder.success(this.oddJobConfigService.updateStatus(id, status));
   }

   @ApiOperation("删除-零工配置")
   @DeleteMapping("/{id}")
   public ResultVO deleteById(@PathVariable Long id) {
      log.info("Api调用: 删除零工配置");
      return ResultBuilder.success(this.oddJobConfigService.deleteOddJobConfigById(id));
   }
}
