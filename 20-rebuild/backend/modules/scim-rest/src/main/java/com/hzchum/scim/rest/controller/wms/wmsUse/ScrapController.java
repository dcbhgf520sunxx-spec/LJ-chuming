package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryByMaterialDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.ScrapService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-废料")
@RestController
@RequestMapping("/api/wms/scrap")
public class ScrapController {
   private static final Logger log = LoggerFactory.getLogger(ScrapController.class);
   @Resource
   ScrapService scrapService;

   @ApiOperation("查询钢材废料")
   @GetMapping("/steel")
   @PreAuthorize("@permission.check('wms_steel_scrap:get')")
   public ResultVO getSteelPlate(
      QueryByMaterialDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：查询钢材废料");
      param.setMaterialIsWhole(4);
      return ResultBuilder.success(this.scrapService.pageInfo(param, pageNumber, pageSize, sort));
   }
}
