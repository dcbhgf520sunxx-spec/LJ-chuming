package com.hzchum.scim.rest.controller.wms.wmsConfig;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.ValidList;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.MeasureDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms配置-计量配置")
@RestController
@RequestMapping("/api/config/classification/material/measure")
public class MeasureController {
   private static final Logger log = LoggerFactory.getLogger(MeasureController.class);
   @Resource
   MeasureService measureService;

   @ApiOperation("获取计量配置")
   @GetMapping
   @PreAuthorize("@permission.check('config_class_measureConfig:get')")
   public ResultVO list() {
      log.info("API 调用 ：获取计量配置");
      return ResultBuilder.success(this.measureService.listTree(1));
   }

   @ApiOperation("导出计量配置清单")
   @GetMapping("exportMeteringConfigurationList")
   @PreAuthorize("@permission.check('config_class_measureConfig:get')")
   public void exportMeteringConfigurationList(HttpServletResponse response) {
      log.info("API 调用 ：导出计量配置清单");
      this.measureService.exportMeasureList(response);
   }

   @ApiOperation("修改计量配置")
   @PutMapping
   @PreAuthorize("@permission.check('config_class_measureConfig:edit')")
   public ResultVO updateMetrology(@Valid @RequestBody ValidList<MeasureDTOParam> params, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：修改计量配置");
      return ResultBuilder.success(this.measureService.updateMeasure(params));
   }

   @ApiOperation("获取质检配置")
   @GetMapping("/quality-testing")
   @PreAuthorize("@permission.check('config_wms_inspectionRawMaterial:get')")
   public ResultVO getSteelConfig() {
      log.info("API 调用 ：获取钢材配置(质检配置)");
      return ResultBuilder.success(this.measureService.getSteelConfig());
   }

   @ApiOperation("修改质检配置")
   @PutMapping("/quality-testing")
   @PreAuthorize("@permission.check('config_wms_inspectionRawMaterial:add')")
   public ResultVO updateQualityTesting(@RequestBody List<Long> ids) {
      log.info("API 调用 ：修改质检配置");
      return ResultBuilder.success(this.measureService.updateQualityTesting(ids));
   }

   @ApiOperation("删除质检配置")
   @DeleteMapping("/quality-testing")
   @PreAuthorize("@permission.check('config_wms_inspectionRawMaterial:del')")
   public ResultVO delQualityTesting(@RequestBody List<Long> ids) {
      log.info("API 调用 ：删除质检配置");
      return ResultBuilder.success(this.measureService.delQualityTesting(ids));
   }

   @ApiOperation("根据classifyIds查询计量配置")
   @GetMapping("/listByIds")
   public ResultVO listByIds(List<Long> classificationIds) {
      log.info("API 调用 ：根据classifyIds查询计量配置");
      return ResultBuilder.success(this.measureService.measureListByIds(classificationIds));
   }
}
