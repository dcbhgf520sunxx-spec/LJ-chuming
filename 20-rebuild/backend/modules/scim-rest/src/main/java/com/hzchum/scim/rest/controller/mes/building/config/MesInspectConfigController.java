package com.hzchum.scim.rest.controller.mes.building.config;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.pojo.dto.config.ChangStatusDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesInspectConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesInspectConfigSaveDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesInspectConfigUpdateParam;
import com.hzchum.scim.system.core.api.service.MesInspectConfigService;
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

@Api(tags = "质检基础配置")
@RestController
@RequestMapping("/api/mes/building/inspect/config")
public class MesInspectConfigController {
   private static final Logger log = LoggerFactory.getLogger(MesInspectConfigController.class);
   @Resource
   MesInspectConfigService inspectConfigService;

   @ApiOperation("质检基础配置列表")
   @GetMapping("/page")
   @PreAuthorize("@permission.check('quality_base:get')")
   public ResultVO inspectConfigPage(
      MesInspectConfigDTO inspectConfig, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:查询质检基础配置列表");
      return ResultBuilder.success(this.inspectConfigService.findInspectConfigList(inspectConfig, pageNumber, pageSize));
   }

   @ApiOperation("新增质检基础配置")
   @PostMapping("/save")
   @PreAuthorize("@permission.check('quality_base:add')")
   public ResultVO saveGroups(@RequestBody @Valid MesInspectConfigSaveDTO inspectConfig) {
      log.info("API 调用 ：新增质检基础配置");
      return ResultBuilder.success(this.inspectConfigService.saveConfig(inspectConfig));
   }

   @ApiOperation("修改质检基础配置")
   @PutMapping("/update")
   @PreAuthorize("@permission.check('quality_base:edit')")
   public ResultVO updateConfig(@RequestBody @Valid MesInspectConfigUpdateParam inspectConfig) throws CloneNotSupportedException {
      log.info("API 调用 ：修改质检基础配置");
      return ResultBuilder.success(this.inspectConfigService.updateConfig(inspectConfig));
   }

   @ApiOperation("修改质检基础配置状态")
   @PutMapping("/changeState")
   @PreAuthorize("@permission.check('quality_base:editStatus')")
   public ResultVO changeState(@RequestBody @Valid ChangStatusDTO classConfig) {
      log.info("API 调用 ：修改质检基础配置状态");
      return ResultBuilder.success(this.inspectConfigService.changeState(classConfig));
   }

   @ApiOperation("删除质检基础配置")
   @DeleteMapping("/delete/{id}")
   @PreAuthorize("@permission.check('quality_base:del')")
   public ResultVO delClassConfig(@PathVariable("id") Long inspectConfigId) {
      log.info("API 调用 ：删除质检基础配置");
      return ResultBuilder.success(this.inspectConfigService.delClassConfig(inspectConfigId));
   }

   @ApiOperation("所有质检用户根据车间分组")
   @GetMapping("/find/all/inspect_user")
   public ResultVO findAllInspectUserGroupWorkShop() {
      log.info("API 调用 ：所有质检用户根据车间分组");
      return ResultBuilder.success(this.inspectConfigService.findAllInspectUserGroupWorkShop());
   }
}
