package com.hzchum.scim.rest.controller.wms.wmsConfig;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.rest.pojo.vo.wms.wmsConfig.WarehouseVORequest;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.WarehouseDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.BatchWarehouseDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WarehouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms配置-仓库位置配置")
@RestController
@RequestMapping("/api/wms/config/material/warehouse")
public class WarehouseController {
   private static final Logger log = LoggerFactory.getLogger(WarehouseController.class);
   @Resource
   WarehouseService warehouseService;

   @ApiOperation("获取仓库位置")
   @GetMapping
   @PreAuthorize("@permission.check('config_wms_factory_warehouse:get')")
   public ResultVO list(
      @RequestParam(name = "workshopId", required = false) Long workshopId,
      @RequestParam(name = "enabled", required = false) Boolean enabled,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：获取仓库位置");
      return ResultBuilder.success(this.warehouseService.pageInfo(enabled, workshopId, pageNumber, pageSize, sort));
   }

   @ApiOperation("获取仓库位置")
   @GetMapping("/ids")
   public ResultVO getIds() {
      log.info("API 调用 ：获取仓库位置");
      return ResultBuilder.success(this.warehouseService.getWorkshopList());
   }

   @ApiOperation("获取简单仓库位置信息")
   @GetMapping("/all/brief")
   public ResultVO getWarehouseBrief() {
      log.info("API 调用 ：获取简单仓库位置信息");
      return ResultBuilder.success(this.warehouseService.listInfo(null, null));
   }

   @ApiOperation("新增仓库")
   @PostMapping
   @PreAuthorize("@permission.check('config_wms_factory_warehouse:add','config_wms_factory_warehouse_V2_storageLocation:add')")
   public ResultVO addWarehouse(@RequestBody List<WarehouseDTOParam> request) {
      log.info("API 调用 ：新增仓库");
      return ResultBuilder.success(this.warehouseService.addWarehouse(request));
   }

   @ApiOperation("批量新增仓库位置")
   @PostMapping("/batch")
   @PreAuthorize("@permission.check('config_wms_factory_warehouse:add','config_wms_factory_warehouse_V2_storageLocation:add')")
   public ResultVO batchAddWarehouse(@RequestBody BatchWarehouseDTOParam param) {
      log.info("API 调用 ：批量新增仓库位置");
      return ResultBuilder.success(this.warehouseService.batchAddWarehouse(param));
   }

   @ApiOperation("修改仓库信息")
   @PutMapping
   @PreAuthorize("@permission.check('config_wms_factory_warehouse:edit','config_wms_factory_warehouse_V2_storageLocation:edit')")
   public ResultVO update(@Valid @RequestBody WarehouseVORequest warehouseVORequest) {
      log.info("API 调用 ：修改仓库信息");
      WarehouseDTOParam dtoParam = BeanUtil.copy(warehouseVORequest, WarehouseDTOParam.class);
      return ResultBuilder.success(this.warehouseService.updateWarehouse(dtoParam));
   }

   @ApiOperation("修改启用状态")
   @PutMapping("/enabled")
   @PreAuthorize("@permission.check('config_wms_factory_warehouse:edit','config_wms_factory_warehouse_V2_storageLocation:editStatus')")
   public ResultVO editEnabled(@RequestParam("id") Long id, @RequestParam("enabled") Boolean enabled) {
      log.info("API 调用 ：修改仓库信息");
      return ResultBuilder.success(this.warehouseService.editEnabled(id, enabled));
   }

   @ApiOperation("批量删除仓库信息")
   @DeleteMapping
   @PreAuthorize("@permission.check('config_wms_factory_warehouse:del','config_wms_factory_warehouse_V2_storageLocation:del')")
   public ResultVO delete(@RequestBody List<Long> ids) {
      log.info("API 调用 ：批量删除仓库信息");
      return ResultBuilder.success(this.warehouseService.delete(ids));
   }
}
