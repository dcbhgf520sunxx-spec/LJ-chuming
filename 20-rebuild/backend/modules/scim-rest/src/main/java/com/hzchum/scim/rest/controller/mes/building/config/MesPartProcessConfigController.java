package com.hzchum.scim.rest.controller.mes.building.config;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesPartProcessConfigDTO;
import com.hzchum.scim.system.core.api.service.MesPartProcessConfigService;
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

@Api(tags = "零件工序配置")
@RestController
@RequestMapping("/api/mes/building/partProcess/config")
public class MesPartProcessConfigController {
   private static final Logger log = LoggerFactory.getLogger(MesPartProcessConfigController.class);
   @Resource
   MesPartProcessConfigService processConfigService;

   @GetMapping("/page")
   public ResultVO inspectConfigPage(@RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize) {
      log.info("Api调用:查询零件工序配置");
      return ResultBuilder.success(this.processConfigService.listInfo());
   }

   @ApiOperation("零件工序配置详情")
   @GetMapping("detail/{id}")
   public ResultVO detailById(@PathVariable Long id) {
      log.info("API 调用 ：零件工序配置详情");
      return ResultBuilder.success(this.processConfigService.detailById(id));
   }

   @ApiOperation("新增零件工序配置")
   @PostMapping("/save")
   public ResultVO savePartProcessConfig(@RequestBody @Valid MesPartProcessConfigDTO configDTO) {
      log.info("API 调用 ：新增零件工序配置");
      return ResultBuilder.success(this.processConfigService.savePartProcessConfig(configDTO));
   }

   @ApiOperation("修改零件工序配置")
   @PutMapping("/update")
   public ResultVO updatePartProcessConfig(@RequestBody @Valid MesPartProcessConfigDTO configDTO) {
      log.info("API 调用 ：修改零件工序配置");
      return ResultBuilder.success(this.processConfigService.updatePartProcessConfig(configDTO));
   }

   @ApiOperation("删除零件工序配置")
   @DeleteMapping("/delete")
   public ResultVO deleteById(@RequestBody Long ConfigId) {
      log.info("API 调用 ：删除零件工序配置");
      return ResultBuilder.success(this.processConfigService.deleteById(ConfigId));
   }
}
