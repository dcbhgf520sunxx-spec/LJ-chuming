package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.biz.SysModuleDecimalScaleBiz;
import com.hzchum.scim.system.core.api.pojo.dto.ModuleDecimalScaleSimpleDTO;
import com.hzchum.scim.system.core.api.pojo.dto.SysModuleDecimalScaleDTO;
import com.hzchum.scim.system.core.api.pojo.request.SysModuleDecimalScaleDtoParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "配置管理-模块小数精度配置")
@Validated
@RequestMapping("/api/system/module-decimal-scale")
@RestController
public class ModuleDecimalScaleController {
   private static final Logger log = LoggerFactory.getLogger(ModuleDecimalScaleController.class);
   private final SysModuleDecimalScaleBiz sysModuleDecimalScaleBiz;

   @ApiOperation("模块小数精度配置-列表(公共接口)")
   @GetMapping("/all")
   public ResultVO<ListVO<ModuleDecimalScaleSimpleDTO>> listAll() {
      log.info("Api调用: 模块小数精度配置列表");
      return ResultBuilder.success(new ListVO<>(this.sysModuleDecimalScaleBiz.listModuleDecimalScale()));
   }

   @ApiOperation("模块小数精度配置-列表")
   @GetMapping
   @PreAuthorize("@permission.check('module_decimal_precision:get')")
   public ResultVO<ListVO<SysModuleDecimalScaleDTO>> list() {
      log.info("Api调用: 模块小数精度配置列表");
      return ResultBuilder.success(new ListVO<>(this.sysModuleDecimalScaleBiz.list()));
   }

   @ApiOperation("模块小数精度配置-保存")
   @PostMapping
   @PreAuthorize("@permission.check('module_decimal_precision:add')")
   public ResultVO save(@RequestBody @Valid List<SysModuleDecimalScaleDtoParam> paramList) {
      log.info("Api调用: 保存模块小数精度配置");
      return ResultBuilder.success(this.sysModuleDecimalScaleBiz.save(paramList));
   }

   @ApiOperation("模块小数精度配置-删除")
   @DeleteMapping
   @PreAuthorize("@permission.check('module_decimal_precision:del')")
   public ResultVO remove(@RequestBody List<Long> ids) {
      log.info("Api调用: 删除-模块小数精度配置");
      return ResultBuilder.success(this.sysModuleDecimalScaleBiz.remove(ids));
   }

   public ModuleDecimalScaleController(final SysModuleDecimalScaleBiz sysModuleDecimalScaleBiz) {
      this.sysModuleDecimalScaleBiz = sysModuleDecimalScaleBiz;
   }
}
