package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryByMaterialDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.VirtualWarehouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-虚拟仓库")
@RestController
@RequestMapping("/api/wms/virtual")
public class VirtualWarehouseController {
   private static final Logger log = LoggerFactory.getLogger(VirtualWarehouseController.class);
   @Resource
   VirtualWarehouseService virtualWarehouseService;

   @ApiOperation("获取虚拟物料列表")
   @GetMapping
   public ResultVO list(
      QueryByMaterialDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：获取虚拟物料列表");
      return ResultBuilder.success(this.virtualWarehouseService.pageInfo(param, pageNumber, pageSize, sort));
   }
}
