package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.PlantConvertDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsPlantConvertService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-钢板转换单")
@RestController
@RequestMapping("/api/wms/plant/convert")
public class PlantConvertController {
   private static final Logger log = LoggerFactory.getLogger(PlantConvertController.class);
   @Resource
   WmsPlantConvertService plantConvertService;

   @ApiOperation("根据条件分页查询钢板转换单（套料）")
   @GetMapping("/convert")
   @PreAuthorize("@permission.check('wms_report_form_conversion_record:get')")
   public ResultVO list(
      PlantConvertDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：根据条件分页查询转换单");
      return ResultBuilder.success(this.plantConvertService.pageInfo(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("根据id查询转换单详情（套料）")
   @GetMapping("/convertDetail/{id}")
   @PreAuthorize("@permission.check('wms_report_form_conversion_record:detail')")
   public ResultVO convertDetail(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据id查询转换单详情");
      return this.plantConvertService.convertDetail(id);
   }
}
