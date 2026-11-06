package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.biz.SysProductTraceabilityConfigBiz;
import com.hzchum.scim.system.core.api.pojo._do.SysProductTraceabilityConfig;
import com.hzchum.scim.system.core.api.pojo.dto.SysProductTraceabilityConfigDTO;
import com.hzchum.scim.system.core.api.pojo.param.SysProductTraceabilityConfigParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "系统管理-产品溯源配置")
@Validated
@RequestMapping("/api/system/product-traceability-config")
@RestController
public class SysProductTraceabilityConfigController {
   private static final Logger log = LoggerFactory.getLogger(SysProductTraceabilityConfigController.class);
   private final SysProductTraceabilityConfigBiz productTraceabilityConfigBiz;

   @ApiOperation("获取-项目溯源配置")
   @GetMapping("/getByProjectId/public")
   public ResultVO<SysProductTraceabilityConfig> getByProjectId(@RequestParam(required = false) Long projectId) {
      log.info("Api调用:产品溯源配置列表");
      return ResultBuilder.success(this.productTraceabilityConfigBiz.getByProjectId(projectId));
   }

   @ApiOperation("列表")
   @ApiImplicitParams(
      {@ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"), @ApiImplicitParam(name = "projectName", value = "项目名称", paramType = "query")}
   )
   @GetMapping("/list")
   @PreAuthorize("@permission.check('mes_label_artifact:traceabilitySettingGet')")
   public ResultVO<ListVO<SysProductTraceabilityConfigDTO>> list(Long projectId, String projectName) {
      log.info("Api调用:产品溯源配置列表");
      return ResultBuilder.success(new ListVO<>(this.productTraceabilityConfigBiz.listByCondition(projectId, projectName)));
   }

   @ApiOperation("保存-批量")
   @PostMapping("/save-batch")
   @PreAuthorize("@permission.check('mes_label_artifact:traceabilitySettingEdit')")
   public ResultVO<Boolean> saveBatch(@RequestBody @Valid List<SysProductTraceabilityConfigParam> paramList) {
      log.info("Api调用:批量新增产品溯源配置");
      return ResultBuilder.success(this.productTraceabilityConfigBiz.saveBatch(paramList));
   }

   @ApiOperation("获取-系统默认配置")
   @GetMapping("/getDefault")
   @PreAuthorize("@permission.check('mes_label_artifact:traceabilitySettingGet')")
   public ResultVO<SysProductTraceabilityConfig> getDefault() {
      log.info("Api调用:获取系统默认配置");
      return ResultBuilder.success(this.productTraceabilityConfigBiz.getDefault());
   }

   @ApiOperation("保存-系统默认配置")
   @PostMapping("/save-default")
   @PreAuthorize("@permission.check('mes_label_artifact:traceabilitySettingEdit')")
   public ResultVO<Boolean> saveBatch(@RequestBody @Valid SysProductTraceabilityConfigParam param) {
      log.info("Api调用:保存系统默认配置");
      return ResultBuilder.success(this.productTraceabilityConfigBiz.saveDefault(param));
   }

   public SysProductTraceabilityConfigController(final SysProductTraceabilityConfigBiz productTraceabilityConfigBiz) {
      this.productTraceabilityConfigBiz = productTraceabilityConfigBiz;
   }
}
