package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.pangu.common.valid.ValidList;
import com.hzchum.scim.system.core.api.pojo.request.MesContractProjectAssemblingWeldingConfigLinkSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesContractProjectAssemblingWeldingConfigLinkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
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

@Api(tags = "项目工价配置-装焊配置")
@RequestMapping("/api/system/project-assembling-welding-config")
@RestController
public class MesContractProjectAssemblingWeldingConfigLinkController {
   private static final Logger log = LoggerFactory.getLogger(MesContractProjectAssemblingWeldingConfigLinkController.class);
   @Autowired
   private MesContractProjectAssemblingWeldingConfigLinkService assemblingWeldingConfigLinkService;

   @ApiOperation("列表")
   @GetMapping("list")
   public ResultVO list(@RequestParam Long projectId) {
      log.info("API 调用 ：项目工价配置-装焊配置列表");
      return ResultBuilder.success(new ListVO<>(this.assemblingWeldingConfigLinkService.listInfo(projectId)));
   }

   @ApiOperation("分页")
   @GetMapping("page")
   public ResultVO page(
      @RequestParam Long projectId,
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：项目工价配置-装焊配置分页");
      return ResultBuilder.success(this.assemblingWeldingConfigLinkService.pageInfo(projectId, pageNumber, pageSize, sort));
   }

   @ApiOperation("详情")
   @GetMapping("detail/{id}")
   public ResultVO detailById(@PathVariable Long id) {
      log.info("API 调用 ：项目工价配置-装焊配置详情");
      return ResultBuilder.success(this.assemblingWeldingConfigLinkService.detailById(id));
   }

   @ApiOperation("新增")
   @PostMapping
   public ResultVO save(@RequestBody @Validated(Add.class) MesContractProjectAssemblingWeldingConfigLinkSaveDTOParam param) {
      log.info("API 调用 ：项目工价配置-装焊配置新增");
      return ResultBuilder.success(this.assemblingWeldingConfigLinkService.saveConfig(param));
   }

   @ApiOperation("批量新增")
   @PostMapping("batch-save")
   public ResultVO batchSave(@RequestBody @Validated(Add.class) ValidList<MesContractProjectAssemblingWeldingConfigLinkSaveDTOParam> params) {
      log.info("API 调用 ：项目工价配置-装焊配置批量新增");
      return ResultBuilder.success(this.assemblingWeldingConfigLinkService.batchSaveConfig(params));
   }

   @ApiOperation("修改")
   @PutMapping
   public ResultVO edit(@RequestBody @Validated(Update.class) MesContractProjectAssemblingWeldingConfigLinkSaveDTOParam param) {
      log.info("API 调用 ：项目工价配置-装焊配置修改");
      return ResultBuilder.success(this.assemblingWeldingConfigLinkService.updateConfig(param));
   }

   @ApiOperation("删除")
   @DeleteMapping("{id}")
   public ResultVO deleteById(@PathVariable Long id) {
      log.info("API 调用 ：项目工价配置-装焊配置删除");
      return ResultBuilder.success(this.assemblingWeldingConfigLinkService.deleteById(id));
   }
}
