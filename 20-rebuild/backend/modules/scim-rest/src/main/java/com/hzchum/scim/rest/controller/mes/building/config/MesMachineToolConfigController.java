package com.hzchum.scim.rest.controller.mes.building.config;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesMachineToolConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesMachineToolConfigSaveDTO;
import com.hzchum.scim.system.core.api.service.MesMachineToolConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "机床配置")
@RestController
@RequestMapping("/api/mes/building/machine/tool")
public class MesMachineToolConfigController {
   private static final Logger log = LoggerFactory.getLogger(MesMachineToolConfigController.class);
   @Resource
   MesMachineToolConfigService toolConfigService;

   @ApiOperation("机床配置列表")
   @GetMapping("/page")
   public ResultVO toolConfigPage(
      MesMachineToolConfigDTO toolConfig, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:查询机床配置列表");
      return ResultBuilder.success(this.toolConfigService.findMachineToolConfigList(toolConfig, pageNumber, pageSize));
   }

   @ApiOperation("新增机床配置")
   @PostMapping("/save")
   public ResultVO saveGroups(@RequestBody @Valid MesMachineToolConfigSaveDTO toolConfig) {
      log.info("API 调用 ：新增机床配置");
      return ResultBuilder.success(this.toolConfigService.saveConfig(toolConfig));
   }

   @ApiOperation("修改机床配置")
   @PutMapping("/update")
   public ResultVO updateConfigStatus(@RequestBody @Valid MesMachineToolConfigSaveDTO toolConfig) {
      log.info("API 调用 ：修改机床配置");
      return ResultBuilder.success(this.toolConfigService.updateConfigStatus(toolConfig));
   }

   @ApiOperation("删除机床配置")
   @DeleteMapping("/delete/{id}")
   public ResultVO delClassConfig(@PathVariable("id") Long toolConfigId) {
      log.info("API 调用 ：删除机床配置");
      return ResultBuilder.success(this.toolConfigService.delToolConfig(toolConfigId));
   }
}
