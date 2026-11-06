package com.hzchum.scim.rest.controller.wms.wmsConfig;

import cn.hutool.core.collection.CollectionUtil;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.rest.pojo.vo.wms.wmsConfig.SectionSteelSpecVORequest;
import com.hzchum.scim.wms.core.api.biz.SectionSteelSpecService;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.BatchSectionSteelDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.SectionSteelDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.SectionSteelSpecDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.StandardDetailDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.SectionSteelConfigService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.StandardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
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

@Api(tags = "wms配置-型材库配置")
@RestController
@RequestMapping("/api/config/classification/material/section-steel")
public class SectionSteelController {
   private static final Logger log = LoggerFactory.getLogger(SectionSteelController.class);
   @Resource
   SectionSteelConfigService sectionSteelConfigService;
   @Resource
   StandardService standardService;
   @Resource
   SectionSteelSpecService sectionSteelSpecService;

   @ApiOperation("获取型材库国标配置")
   @GetMapping
   @PreAuthorize("@permission.check('config_class_sectionSteelLibrary:get')")
   public ResultVO list() {
      log.info("API 调用 ：获取型材库国标配置");
      return ResultBuilder.success(this.sectionSteelConfigService.listInfo());
   }

   @ApiOperation("获取国标列表")
   @GetMapping("/standard")
   @PreAuthorize("@permission.check('config_class_sectionSteelLibrary:get')")
   public ResultVO listStandard() {
      log.info("API 调用 ：获取国标列表");
      return ResultBuilder.success(this.standardService.listStandard());
   }

   @ApiOperation("添加国标")
   @PostMapping("/standard")
   @PreAuthorize("@permission.check('config_class_sectionSteelLibrary:add')")
   public ResultVO addStandard(String name) {
      log.info("API 调用 ：添加国标");
      return ResultBuilder.success(this.standardService.addStandard(name));
   }

   @ApiOperation("删除国标")
   @DeleteMapping("/standard")
   @PreAuthorize("@permission.check('config_class_sectionSteelLibrary:del')")
   public ResultVO delete(@RequestParam("id") Long standardId) {
      log.info("API 调用 ：删除国标");
      return ResultBuilder.success(this.standardService.delete(standardId));
   }

   @ApiOperation("根据科目ID获取型材规格详情")
   @GetMapping("/specification")
   public ResultVO listBySubject(@RequestParam("id") Long classificationId, String specification) {
      log.info("API 调用 ：根据科目ID获取型材规格详情");
      return ResultBuilder.success(this.sectionSteelSpecService.listByClassificationId(classificationId, specification));
   }

   @ApiOperation("批量设置国标")
   @PutMapping("/standard/batch-settings")
   @PreAuthorize("@permission.check('config_class_sectionSteelLibrary:edit')")
   public ResultVO update(@RequestBody BatchSectionSteelDTOParam param) {
      log.info("API 调用 ：批量设置国标");
      return ResultBuilder.success(this.sectionSteelConfigService.BatchSectionSteelUpdate(param));
   }

   @ApiOperation("设置国标")
   @PutMapping("/standard/settings")
   @PreAuthorize("@permission.check('config_class_sectionSteelLibrary:edit')")
   public ResultVO batchUpdate(@RequestBody SectionSteelDTOParam param) {
      log.info("API 调用 ：修改型材执行标准");
      return ResultBuilder.success(this.sectionSteelConfigService.sectionSteelUpdate(param));
   }

   @ApiOperation("批量添加型材规格单位净量")
   @PostMapping("/{id}/specification/batch")
   @PreAuthorize("@permission.check('config_class_sectionSteelLibrary:add')")
   public ResultVO batchAddStandard(@PathVariable("id") Long sectionSteelId, @RequestBody List<SectionSteelSpecDTOParam> params) {
      log.info("API 调用 ：批量添加型材规格单位净量");
      return ResultBuilder.success(this.sectionSteelSpecService.batchSave(sectionSteelId, params));
   }

   @ApiOperation("添加型材规格单位净量")
   @PostMapping("/specification")
   @PreAuthorize("@permission.check('config_class_sectionSteelLibrary:add')")
   public ResultVO addStandard(@RequestBody SectionSteelSpecVORequest request) {
      log.info("API 调用 ：添加型材规格单位净量");
      List<SectionSteelSpecDTOParam> list = new ArrayList<>();
      SectionSteelSpecDTOParam build = SectionSteelSpecDTOParam.builder().specification(request.getSpecification()).build();
      if (CollectionUtil.isNotEmpty(request.getStandard())) {
         List<StandardDetailDTOParam> collect = request.getStandard()
            .stream()
            .map(s -> StandardDetailDTOParam.builder().id(s.getId()).unitNet(s.getUnitNet()).build())
            .collect(Collectors.toList());
         build.setStandard(collect);
      }

      list.add(build);
      return ResultBuilder.success(this.sectionSteelSpecService.add(request.getSectionSteelId(), list));
   }

   @ApiOperation("修改型材规格单位净量")
   @PutMapping("/specification")
   @PreAuthorize("@permission.check('config_class_sectionSteelLibrary:edit')")
   public ResultVO updateStandard(@RequestBody SectionSteelSpecDTOParam param) {
      log.info("API 调用 ：修改型材规格单位净量");
      return ResultBuilder.success(this.sectionSteelSpecService.updateStandard(param));
   }

   @ApiOperation("下载国标规格重量")
   @GetMapping("/{sectionSteelId}/standard/{standardId}/specification")
   public ResultVO download(@PathVariable("sectionSteelId") Long sectionSteelId, @PathVariable("standardId") Long standardId) {
      log.info("API 调用 ：下载国标规格重量");
      return ResultBuilder.success(this.sectionSteelSpecService.download(sectionSteelId, standardId));
   }

   @ApiOperation("删除国标规格重量配置")
   @DeleteMapping("/specification")
   @PreAuthorize("@permission.check('config_class_sectionSteelLibrary:del')")
   public ResultVO del(@RequestBody List<Long> ids) {
      log.info("API 调用 ：删除国标规格重量配置");
      return ResultBuilder.success(this.sectionSteelSpecService.delete(ids));
   }

   @ApiOperation("根据规格和类目ID获取型材国标重量")
   @GetMapping("/getStandardDetail")
   @PreAuthorize("@permission.check('config_class_sectionSteelLibrary:get')")
   public ResultVO getStandardDetail(@RequestParam("classificationId") Long classificationId, @RequestParam("specification") String specification) {
      log.info("API 调用 ：根据规格和类目ID获取国标重量配置信息");
      return ResultBuilder.success(this.sectionSteelSpecService.getStandardDetail(classificationId, specification));
   }

   @ApiOperation("启用禁用国标规格")
   @PutMapping("/updateStatus")
   @PreAuthorize("@permission.check('config_class_sectionSteelLibrary:editStatus')")
   public ResultVO updateStatus(@RequestBody List<Long> ids, Boolean status) {
      log.info("API 调用 ：启用禁用国标规格");
      return ResultBuilder.success(this.sectionSteelSpecService.updateStatus(ids, status));
   }
}
