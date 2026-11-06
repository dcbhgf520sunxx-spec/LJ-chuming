package com.hzchum.scim.rest.controller.wms.wmsConfig;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.SectionSteelControlTableDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WmsSectionSteelControlTableService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms配置-mes截面规格对照")
@RestController
@RequestMapping("/api/config/SectionSteelControl")
public class SectionSteelControlTableController {
   private static final Logger log = LoggerFactory.getLogger(SectionSteelControlTableController.class);
   @Resource
   WmsSectionSteelControlTableService wmsSectionSteelControlTableService;

   @ApiOperation("截面规格对照配置列表")
   @GetMapping("/SectionSteelControlList")
   @PreAuthorize("@permission.check('config_wms_material_compare:get')")
   public ResultVO list(Integer mesProductEnum) {
      log.info("截面规格对照配置列表");
      return ResultBuilder.success(this.wmsSectionSteelControlTableService.SectionSteelControlList(mesProductEnum));
   }

   @ApiOperation("截面规格对照配置新增")
   @PostMapping("/saveSectionSteelControl")
   @PreAuthorize("@permission.check('config_wms_material_compare:add')")
   public ResultVO save(@RequestBody SectionSteelControlTableDTOParam param) {
      log.info("截面规格对照配置新增");
      return ResultBuilder.success(this.wmsSectionSteelControlTableService.saveSectionSteelControl(param));
   }

   @ApiOperation("获取型材所有末级科目")
   @GetMapping("/getSectionSteelLastSubjects")
   @PreAuthorize("@permission.check('config_wms_material_compare:get')")
   public ResultVO getSectionSteelLastSubjects() {
      log.info("获取型材所有末级科目");
      return ResultBuilder.success(this.wmsSectionSteelControlTableService.getSectionSteelLastSubjects());
   }
}
