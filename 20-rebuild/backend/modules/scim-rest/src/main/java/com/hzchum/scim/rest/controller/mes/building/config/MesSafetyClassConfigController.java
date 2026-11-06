package com.hzchum.scim.rest.controller.mes.building.config;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.pojo.dto.config.ChangStatusDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesSafetyClassConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesSafetyClassConfigSaveDTO;
import com.hzchum.scim.system.core.api.service.MesSafetyClassConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
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

@Api(tags = "安环问题配置")
@RestController
@RequestMapping("/api/mes/building/safety/config")
public class MesSafetyClassConfigController {
   private static final Logger log = LoggerFactory.getLogger(MesSafetyClassConfigController.class);
   @Resource
   MesSafetyClassConfigService safetyConfigService;

   @ApiOperation("安环分类子级菜单")
   @GetMapping("/page")
   @PreAuthorize("@permission.check('quality_ring_com:get')")
   public ResultVO getSafetyConfigPage(
      Long safetyClassId,
      Integer factoryOrConstructionSite,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 查询子菜单");
      return ResultBuilder.success(this.safetyConfigService.findSafetyClassConfigList(safetyClassId, factoryOrConstructionSite, pageNumber, pageSize));
   }

   @GetMapping("/tree")
   @ApiOperation("查询全部父子树形类目")
   public ResultVO getSafetyConfigPage(Integer type, @RequestParam(defaultValue = "0", required = false) Integer factoryOrConstructionSite) {
      log.info("Api调用: 查询全部类目");
      return ResultBuilder.success(this.safetyConfigService.findsSafetyClassConfigTree(type, factoryOrConstructionSite));
   }

   @ApiOperation("新增安环问题配置")
   @PostMapping("/save")
   @PreAuthorize("@permission.check('quality_ring_com:add')")
   public ResultVO saveGroups(@RequestBody @Valid MesSafetyClassConfigSaveDTO classConfig) {
      log.info("API 调用 ：新增安环问题配置");
      return ResultBuilder.success(this.safetyConfigService.saveFirstClassConfig(classConfig));
   }

   @ApiOperation("修改安环问题配置")
   @PutMapping("/update")
   @PreAuthorize("@permission.check('quality_ring_com:edit')")
   public ResultVO updateConfig(@RequestBody @Valid MesSafetyClassConfigDTO classConfig) {
      log.info("API 调用 ：修改安环问题配置");
      return ResultBuilder.success(this.safetyConfigService.updateConfig(classConfig));
   }

   @ApiOperation("删除安环问题配置")
   @DeleteMapping("/delete/{id}")
   @PreAuthorize("@permission.check('quality_ring_com:del')")
   public ResultVO delClassConfig(@PathVariable("id") @Valid Long classConfigId) {
      log.info("API 调用 ：删除安环问题配置");
      return ResultBuilder.success(this.safetyConfigService.delClassConfig(classConfigId));
   }

   @ApiOperation("修改配置状态")
   @PutMapping("/changeState")
   @PreAuthorize("@permission.check('quality_ring_com:editStatus')")
   public ResultVO changeState(@RequestBody @Valid ChangStatusDTO classConfig) {
      log.info("API 调用 ：修改配置状态");
      return ResultBuilder.success(this.safetyConfigService.changeState(classConfig));
   }
}
