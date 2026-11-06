package com.hzchum.scim.rest.controller.wms.wmsConfig;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.WmsMaterialCodeConfigDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WmsMaterialCodeConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms物料编码配置-中南定制")
@RestController
@RequestMapping("/api/config/materialCodeConfig")
public class WmsMaterialCodeConfigController {
   private static final Logger log = LoggerFactory.getLogger(WmsMaterialCodeConfigController.class);
   @Resource
   WmsMaterialCodeConfigService wmsMaterialCodeConfigService;

   @ApiOperation("新增物料编码配置-中南定制")
   @PostMapping("/addBatch")
   @PreAuthorize("@permission.check('material_code_comparison:add')")
   public ResultVO addBatch(@RequestBody List<WmsMaterialCodeConfigDTOParam> params) {
      log.info("API 调用 ：新增物料编码配置-中南定制");
      return ResultBuilder.success(this.wmsMaterialCodeConfigService.saveMaterialCodeConfig(params));
   }

   @ApiOperation("更新物料编码配置-中南定制")
   @PostMapping("/updateBatch")
   @PreAuthorize("@permission.check('material_code_comparison:edit')")
   public ResultVO updateBatch(@RequestBody List<WmsMaterialCodeConfigDTOParam> params) {
      log.info("API 调用 ：更新物料编码配置-中南定制");
      return ResultBuilder.success(this.wmsMaterialCodeConfigService.updateMaterialCodeConfig(params));
   }

   @ApiOperation("根据条件分页查询物料编码配置-中南定制")
   @GetMapping("/record/raw-materials")
   @PreAuthorize("@permission.check('material_code_comparison:get')")
   public ResultVO list(
      WmsMaterialCodeConfigDTOParam queryInboundDTOParam,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：根据条件分页查询物料编码配置-中南定制");
      return ResultBuilder.success(this.wmsMaterialCodeConfigService.pageInfo(queryInboundDTOParam, pageNumber, pageSize, sort));
   }
}
