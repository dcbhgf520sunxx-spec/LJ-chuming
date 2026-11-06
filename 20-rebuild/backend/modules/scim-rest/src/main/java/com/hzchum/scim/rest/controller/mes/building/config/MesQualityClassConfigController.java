package com.hzchum.scim.rest.controller.mes.building.config;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.pojo.dto.config.ChangStatusDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesQualityClassConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesQualityClassConfigSaveDTO;
import com.hzchum.scim.system.core.api.service.MesQualityClassConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
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

@Api(tags = "质检问题配置")
@RestController
@RequestMapping("/api/mes/building/quality/config")
@Validated
public class MesQualityClassConfigController {
   private static final Logger log = LoggerFactory.getLogger(MesQualityClassConfigController.class);
   @Resource
   MesQualityClassConfigService qualityConfigService;

   @GetMapping("/page")
   @ApiOperation("查询全部类目")
   @PreAuthorize("@permission.check('quality_class_com:get')")
   public ResultVO getQualityConfigPage(
      Long qualityClassId,
      Integer factoryOrConstructionSite,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 查询全部类目");
      return ResultBuilder.success(this.qualityConfigService.findQualityClassConfigList(qualityClassId, factoryOrConstructionSite, pageNumber, pageSize));
   }

   @GetMapping("/tree")
   @ApiOperation("查询全部父子树形类目")
   public ResultVO getQualityConfigPage(@RequestParam(defaultValue = "0", required = false) Integer factoryOrConstructionSite) {
      log.info("Api调用: 查询全部类目");
      return ResultBuilder.success(this.qualityConfigService.findQualityClassConfigTree(factoryOrConstructionSite));
   }

   @ApiOperation("新增质检问题配置")
   @PostMapping("/save")
   @PreAuthorize("@permission.check('quality_class_com:add')")
   public ResultVO saveParentGroups(@RequestBody @Valid MesQualityClassConfigSaveDTO classConfig) {
      log.info("API 调用 ：新增质检问题配置");
      return ResultBuilder.success(this.qualityConfigService.saveClassConfig(classConfig));
   }

   @ApiOperation("修改质检问题配置")
   @PutMapping("/update")
   @PreAuthorize("@permission.check('quality_class_com:edit')")
   public ResultVO updateConfigStatus(@RequestBody @Valid MesQualityClassConfigDTO classConfig) {
      log.info("API 调用 ：修改质检问题配置");
      return ResultBuilder.success(this.qualityConfigService.updateConfig(classConfig));
   }

   @ApiOperation("修改配置状态")
   @PutMapping("/changeState")
   @PreAuthorize("@permission.check('quality_class_com:editStatus')")
   public ResultVO changeState(@RequestBody @Valid ChangStatusDTO classConfig) {
      log.info("API 调用 ：修改配置状态");
      return ResultBuilder.success(this.qualityConfigService.changeState(classConfig));
   }

   @ApiOperation("删除质检问题配置")
   @DeleteMapping("/delete/{id}")
   @PreAuthorize("@permission.check('quality_class_com:del')")
   public ResultVO delClassConfig(@PathVariable("id") Long calssId) {
      log.info("API 调用 ：删除质检问题配置");
      return ResultBuilder.success(this.qualityConfigService.delClassConfig(calssId));
   }
}
