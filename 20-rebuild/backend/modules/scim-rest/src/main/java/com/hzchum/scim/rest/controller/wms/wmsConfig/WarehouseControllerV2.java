package com.hzchum.scim.rest.controller.wms.wmsConfig;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.WarehouseDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.WorkshopDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WarehouseService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WorkshopService;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms配置-仓库位置配置")
@RestController
@RequestMapping("/api/v2/wms/config/material/warehouse")
public class WarehouseControllerV2 {
   private static final Logger log = LoggerFactory.getLogger(WarehouseControllerV2.class);
   @Resource
   WarehouseService warehouseService;
   @Resource
   WorkshopService workshopService;

   @ApiOperation("获取仓库位置")
   @GetMapping
   @PreAuthorize("@permission.check('config_wms_factory_warehouse_V2_storageLocation:get')")
   public ResultVO list(
      @RequestParam(name = "workshopId", required = false) Long workshopId,
      @RequestParam(name = "enabled", required = false) Boolean enabled,
      @RequestParam(name = "materialType", required = false) Integer materialType,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort,
      @RequestParam(name = "name", required = false) String name
   ) {
      log.info("API 调用 ：获取仓库位置");
      return ResultBuilder.success(this.warehouseService.pageInfoV2(enabled, workshopId, materialType, pageNumber, pageSize, sort, name));
   }

   @ApiOperation("获取简单仓库位置信息")
   @GetMapping("/all/brief")
   public ResultVO getWarehouseBrief() {
      log.info("API 调用 ：获取简单仓库位置信息");
      return ResultBuilder.success(this.warehouseService.listInfoV2(null, null, null, null));
   }

   @ApiOperation("入库获取仓库位置")
   @GetMapping("/ids")
   public ResultVO getIds() {
      log.info("API 调用 ：获取仓库位置");
      return ResultBuilder.success(this.warehouseService.getWorkshopListV2());
   }

   @ApiOperation("app入库获取仓库位置")
   @GetMapping("/getWareHouse/{workShopId}")
   public ResultVO getWareHouse(@PathVariable Long workShopId) {
      log.info("API 调用 ：app入库获取仓库位置");
      return ResultBuilder.success(this.warehouseService.listInfoV2(null, workShopId, null, null));
   }

   @ApiOperation("批量新增workshop仓库")
   @PostMapping("/workshop/batch")
   @PreAuthorize("@permission.check('config_wms_factory_warehouse_V2:add')")
   public ResultVO batchAdd(@RequestBody List<WarehouseDTOParam> list) {
      log.info("API 调用 ：批量新增workshop仓库");
      return ResultBuilder.success(this.workshopService.batchAddWorkshop(list));
   }

   @ApiOperation("删除workshop仓库")
   @DeleteMapping("/workshop")
   @PreAuthorize("@permission.check('config_wms_factory_warehouse_V2:del')")
   public ResultVO delWorkshop(@RequestBody List<Long> ids) {
      log.info("API 调用 ：删除仓库");
      return ResultBuilder.success(this.workshopService.delWorkshop(ids));
   }

   @ApiOperation("获取车间(仓库)列表")
   @GetMapping("workshopList")
   @PreAuthorize("@permission.check('config_wms_factory_warehouse_V2:get')")
   public ResultVO workshopList(
      @RequestParam(name = "enabled", required = false) Boolean enabled,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort,
      @RequestParam(name = "factoryId", required = false) Long factoryId,
      @RequestParam(name = "name", required = false) String name,
      @RequestParam(name = "workshopType", required = false) Integer workshopType
   ) {
      log.info("API 调用 ：获取车间列表");
      return ResultBuilder.success(this.workshopService.pageInfo(enabled, pageNumber, pageSize, sort, factoryId, name, workshopType));
   }

   @ApiOperation("根据ID修改workshop仓库信息")
   @PutMapping("workshop/update")
   @PreAuthorize("@permission.check('config_wms_factory_warehouse_V2:edit')")
   public ResultVO workshopUpdate(@Valid @RequestBody WorkshopDTOParam workshopDTOParam) {
      log.info("API 调用 ：根据ID修改workshop仓库信息");
      return ResultBuilder.success(this.workshopService.updateWorkshop(workshopDTOParam));
   }

   @ApiOperation("根据ID查看workshop详情")
   @GetMapping("workshop/{id}")
   public ResultVO workshopUpdate(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据ID查看workshop详情");
      return ResultBuilder.success(this.workshopService.getById(id));
   }

   @ApiOperation("修改workshop仓库启用状态")
   @PutMapping("workshop/enabled")
   @PreAuthorize("@permission.check('config_wms_factory_warehouse_V2:editStatus')")
   public ResultVO workshopEditEnabled(@RequestParam("id") Long id, @RequestParam("enabled") Boolean enabled) {
      log.info("API 调用 ：修改仓库信息");
      return ResultBuilder.success(this.workshopService.workshopEditEnabled(id, enabled));
   }

   @ApiOperation("获取全部仓库信息")
   @GetMapping("workshop/getAll")
   public ResultVO workshopEditEnabled() {
      log.info("API 调用 ：获取全部仓库信息");
      return ResultBuilder.success(this.workshopService.list());
   }

   @ApiOperation("获取当前登录人所负责的仓库信息")
   @GetMapping("workshop/getWorkshopByUser")
   @PreAuthorize("@permission.check('config_wms_factory_warehouse_V2:get')")
   public ResultVO getWorkshopByUser(@RequestParam(name = "workShopId", required = false) Long workShopId) {
      log.info("API 调用 ：获取当前登录人所负责的仓库信息");
      return ResultBuilder.success(this.workshopService.getWorkshopByUser(workShopId));
   }

   @ApiOperation("获取当前登录人负责的仓库位置")
   @GetMapping("/getWorkShop")
   public ResultVO getWorkShop() {
      log.info("API 调用 ：获取当前登录人负责的仓库位置");
      return ResultBuilder.success(this.warehouseService.getWorkshopListV2One());
   }
}
