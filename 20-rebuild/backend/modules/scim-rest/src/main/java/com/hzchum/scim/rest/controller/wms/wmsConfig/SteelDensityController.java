package com.hzchum.scim.rest.controller.wms.wmsConfig;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.SteelDensityDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.SteelDensityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms配置-钢材密度配置")
@RestController
@RequestMapping("/api/config/steel-density")
public class SteelDensityController {
   private static final Logger log = LoggerFactory.getLogger(SteelDensityController.class);
   @Autowired
   private SteelDensityService steelDensityService;

   @ApiOperation("获取钢材密度配置")
   @GetMapping
   @PreAuthorize("@permission.check('steels_density:get')")
   public ResultVO getSteelDensity(
      @RequestParam(name = "classifyId", required = false) Long classifyId,
      @RequestParam(name = "createBy", required = false) String createBy,
      @RequestParam(name = "updateBy", required = false) String updateBy
   ) {
      log.info("API 调用 ：获取钢材密度配置");
      return ResultBuilder.success(this.steelDensityService.getSteelDensityConf(classifyId, createBy, updateBy));
   }

   @ApiOperation("批量新增钢材密度配置")
   @PostMapping("/save")
   @PreAuthorize("@permission.check('steels_density:add')")
   public ResultVO save(@Valid @RequestBody List<SteelDensityDTOParam> steelDensityDTOParams) {
      log.info("API 调用 ：批量新增钢材密度配置");
      return ResultBuilder.success(this.steelDensityService.saveSteelDensity(steelDensityDTOParams));
   }

   @ApiOperation("修改钢材密度配置")
   @PutMapping("/update")
   @PreAuthorize("@permission.check('steels_density:edit')")
   public ResultVO update(@Valid @RequestBody SteelDensityDTOParam steelDensityDTOParam) {
      log.info("API 调用 ：修改钢材密度配置");
      return ResultBuilder.success(this.steelDensityService.updateSteelDensity(steelDensityDTOParam));
   }

   @ApiOperation("删除钢材密度配置")
   @DeleteMapping("/deleted")
   @PreAuthorize("@permission.check('steels_density:del')")
   public ResultVO deleted(@RequestBody List<Long> ids) {
      log.info("API 调用 ：删除钢材密度配置");
      return ResultBuilder.success(this.steelDensityService.deletedSteelDensity(ids));
   }

   @ApiOperation("获取Redis中的密度配置信息")
   @GetMapping("/getAll")
   public ResultVO getRedisSteelDensity() {
      log.info("API 调用 ：获取Redis中的密度配置信息");
      return ResultBuilder.success(this.steelDensityService.getRedisSteelDensity());
   }

   @ApiOperation("获取钢材科目的层级列表")
   @GetMapping("/getSteelClass")
   public ResultVO getSteelClass() {
      log.info("API 调用 ：获取钢材科目的层级列表");
      return ResultBuilder.success(this.steelDensityService.getSteelClass());
   }

   @ApiOperation("校验钢材密度是否一致")
   @PostMapping("/checkSteelDensity")
   public ResultVO checkSteelDensity(@RequestBody Map<String, BigDecimal> steelDensityMap) {
      log.info("API 调用 ：校验钢材密度是否一致");
      return ResultBuilder.success(this.steelDensityService.checkSteelDensity(steelDensityMap));
   }
}
