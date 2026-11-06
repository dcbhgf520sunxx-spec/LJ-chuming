package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryMaterialManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryManufacturedService;
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

@Api(tags = "wms-制成品物料仓")
@RestController
@RequestMapping("/api/wms/material-inventory/manufactured")
public class MaterialInventoryManufacturedController {
   private static final Logger log = LoggerFactory.getLogger(MaterialInventoryManufacturedController.class);
   @Resource
   MaterialInventoryManufacturedService materialInventoryManufacturedService;

   @ApiOperation("获取制成品库存信息")
   @GetMapping("/list")
   @PreAuthorize("@permission.check('wms_matWarehouse_manufactured_self:get')")
   public ResultVO getSteelPlate(
      QueryMaterialManufacturedDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：获取制成品库存信息");
      return ResultBuilder.success(this.materialInventoryManufacturedService.pageInfo(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("获取仓库中制成品所关联的项目信息")
   @GetMapping("/getProject")
   public ResultVO getProject() {
      log.info("API 调用 ：获取仓库中制成品所关联的项目信息");
      return ResultBuilder.success(this.materialInventoryManufacturedService.getProject());
   }
}
