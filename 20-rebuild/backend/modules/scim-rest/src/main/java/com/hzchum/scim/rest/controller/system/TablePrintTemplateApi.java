package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.pojo.dto.TablePrintTemplateRequestDTOParam;
import com.hzchum.scim.system.core.api.service.SysTablePrintTemplateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "配置管理-表格模板")
@RestController
@RequestMapping("/api/tablePrintTemplate")
public class TablePrintTemplateApi {
   private static final Logger log = LoggerFactory.getLogger(TablePrintTemplateApi.class);
   private final SysTablePrintTemplateService tablePrintTemplateService;

   @ApiOperation("获取表格打印模板列表")
   @GetMapping("")
   @PreAuthorize("@permission.check('table_print_template:get')")
   public ResultVO list(
      String name, String type, Boolean enabled, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：获取表格打印模板列表");
      return ResultBuilder.success(this.tablePrintTemplateService.list(name, type, enabled, pageNumber, pageSize));
   }

   @ApiOperation("添加表格打印模板")
   @PostMapping("")
   @PreAuthorize("@permission.check('table_print_template:add')")
   public ResultVO save(@Valid @RequestBody TablePrintTemplateRequestDTOParam requestDTOParam) {
      log.info("API 调用 ：添加表格打印模板");
      return ResultBuilder.success(this.tablePrintTemplateService.save(requestDTOParam));
   }

   @ApiOperation("编辑表格打印模板")
   @PutMapping("{id}")
   @PreAuthorize("@permission.check('table_print_template:edit')")
   public ResultVO update(@PathVariable Long id, @Valid @RequestBody TablePrintTemplateRequestDTOParam requestVO) {
      log.info("API 调用 ：编辑表格打印模板");
      return ResultBuilder.success(this.tablePrintTemplateService.update(id, requestVO));
   }

   @ApiOperation("编辑表格打印模板启用状态")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "id", value = "模板id", paramType = "path", required = true),
            @ApiImplicitParam(name = "enabled", value = "状态 1启用 0禁用", paramType = "path", required = true)
      }
   )
   @PutMapping("{id}/enabled")
   @PreAuthorize("@permission.check('table_print_template:edit')")
   public ResultVO update(@PathVariable Long id, @RequestParam Boolean enabled) {
      log.info("API 调用 ：编辑表格打印模板启用状态");
      return ResultBuilder.success(this.tablePrintTemplateService.updateEnabled(id, enabled));
   }

   @ApiOperation("删除表格打印模板")
   @DeleteMapping("")
   @PreAuthorize("@permission.check('table_print_template:del')")
   public ResultVO deleteByIds(@RequestBody List<Long> ids) {
      log.info("API 调用 ：删除表格打印模板");
      return ids.isEmpty() ? ResultBuilder.failed("传入的模板id列表为空", ResultCodeEnum.ERROR) : ResultBuilder.success(this.tablePrintTemplateService.delete(ids));
   }

   @ApiOperation("根据 类型 获取表格打印模板列表")
   @ApiImplicitParam(name = "type", value = "表格类型", paramType = "path", required = true)
   @GetMapping("/type/{type}")
   public ResultVO list(@PathVariable String type) {
      log.info("API 调用 ：根据类型获取表格打印模板列表");
      return ResultBuilder.success(this.tablePrintTemplateService.listByType(type));
   }

   @ApiOperation("修改默认")
   @PutMapping("{id}/default/{isDefault}")
   @PreAuthorize("@permission.check('table_print_template:edit')")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "id", value = "模板id", paramType = "path", required = true),
            @ApiImplicitParam(name = "isDefault", value = "默认状态 true设为默认 false设为非默认", paramType = "path", required = true)
      }
   )
   public ResultVO list(@PathVariable Integer id, @PathVariable Boolean isDefault) {
      log.info("API 调用 ：修改默认");
      return ResultBuilder.success(this.tablePrintTemplateService.setDefault(id, isDefault));
   }

   @ApiOperation("根据 类型列表 获取 表格打印模板列表")
   @GetMapping("/condition")
   public ResultVO list(@RequestParam List<String> types) {
      log.info("API 调用 ：根据 类型列表 获取表格打印模板列表");
      return types.isEmpty() ? ResultBuilder.failed("类型列表为空!") : ResultBuilder.success(this.tablePrintTemplateService.listByTypes(types));
   }

   public TablePrintTemplateApi(final SysTablePrintTemplateService tablePrintTemplateService) {
      this.tablePrintTemplateService = tablePrintTemplateService;
   }
}
