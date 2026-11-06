package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.pangu.common.valid.ValidList;
import com.hzchum.scim.system.core.api.pojo.request.MesAssemblingWeldingConfigSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesAssemblingWeldingConfigService;
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

@Api(tags = "工价配置-装焊配置")
@RequestMapping("/api/system/assembling-welding-config")
@RestController
public class MesAssemblingWeldingConfigController {
   private static final Logger log = LoggerFactory.getLogger(MesAssemblingWeldingConfigController.class);
   @Autowired
   private MesAssemblingWeldingConfigService assemblingWeldingConfigService;

   @ApiOperation("装焊配置列表")
   @GetMapping("list")
   public ResultVO list() {
      log.info("API 调用 ：装焊配置列表");
      return ResultBuilder.success(new ListVO<>(this.assemblingWeldingConfigService.listInfo()));
   }

   @ApiOperation("装焊配置分页")
   @GetMapping("page")
   public ResultVO page(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
      log.info("API 调用 ：装焊配置分页");
      return ResultBuilder.success(this.assemblingWeldingConfigService.pageInfo(pageNumber, pageSize));
   }

   @ApiOperation("装焊配置详情")
   @GetMapping("detail/{id}")
   public ResultVO detailById(@PathVariable Long id) {
      log.info("API 调用 ：装焊配置详情");
      return ResultBuilder.success(this.assemblingWeldingConfigService.detailById(id));
   }

   @ApiOperation("装焊配置新增")
   @PostMapping
   public ResultVO save(@RequestBody @Validated(Add.class) MesAssemblingWeldingConfigSaveDTOParam param) {
      log.info("API 调用 ：装焊配置新增");
      return ResultBuilder.success(this.assemblingWeldingConfigService.saveAssemblingWeldingConfig(param));
   }

   @ApiOperation("装焊配置批量新增")
   @PostMapping("batch-save")
   public ResultVO batchSave(@RequestBody @Validated(Add.class) ValidList<MesAssemblingWeldingConfigSaveDTOParam> params) {
      log.info("API 调用 ：装焊配置批量新增");
      return ResultBuilder.success(this.assemblingWeldingConfigService.batchSaveAssemblingWeldingConfig(params));
   }

   @ApiOperation("装焊配置修改")
   @PutMapping
   public ResultVO edit(@RequestBody @Validated(Update.class) MesAssemblingWeldingConfigSaveDTOParam param) {
      log.info("API 调用 ：装焊配置修改");
      return ResultBuilder.success(this.assemblingWeldingConfigService.updateAssemblingWeldingConfig(param));
   }

   @ApiOperation("装焊配置删除")
   @DeleteMapping("{id}")
   public ResultVO deleteById(@PathVariable Long id) {
      log.info("API 调用 ：装焊配置删除");
      return ResultBuilder.success(this.assemblingWeldingConfigService.deleteById(id));
   }
}
