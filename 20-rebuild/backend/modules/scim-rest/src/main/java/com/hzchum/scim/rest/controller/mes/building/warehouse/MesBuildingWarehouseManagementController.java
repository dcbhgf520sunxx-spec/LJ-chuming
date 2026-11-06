package com.hzchum.scim.rest.controller.mes.building.warehouse;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.mes.building.core.api.biz.warehouse.MesBuildingWarehouseManagementBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.WarehouseProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.WorkshopWarehouseSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse.WarehouseManagementQueryParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse.WarehouseProductMoveDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse.WarehouseProductSaveParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES库位管理")
@Validated
@RestController
@RequestMapping("/api/mes/building/warehouseManagement")
public class MesBuildingWarehouseManagementController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingWarehouseManagementController.class);
   private final MesBuildingWarehouseManagementBiz warehouseManagementBiz;

   @ApiOperation("查询-未保存仓库(且未打包发运)-产品列表")
   @GetMapping("/getUnSaveWarehouseProductList")
   public ResultVO<PageVO<WarehouseProductDTO>> getUnWarehouseProductList(
      WarehouseManagementQueryParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:未保存仓库(且未打包发运)-产品列表");
      return ResultBuilder.success(this.warehouseManagementBiz.listUnSaveWarehouseProduct(param, pageNumber, pageSize));
   }

   @ApiOperation("产品-保存仓库")
   @PostMapping("/saveWarehouseProduct")
   public ResultVO<Boolean> saveWarehouseProduct(@RequestBody @Valid List<WarehouseProductSaveParam> paramList) {
      log.info("Api调用:获取未保存库位产品列表");
      return ResultBuilder.success(this.warehouseManagementBiz.saveWarehouseProduct(paramList));
   }

   @ApiOperation("车间仓库-库存项目列表")
   @GetMapping("/workshopWarehouse/projectList")
   public ResultVO<ListVO<ProjectInfo>> listWarehouseProject() {
      log.info("Api调用:车间仓库-库存项目列表");
      return ResultBuilder.success(new ListVO<>(this.warehouseManagementBiz.listWarehouseProject()));
   }

   @ApiOperation("车间仓库-产品数量/吨位汇总")
   @GetMapping("/workshopWarehouseSummary")
   @PreAuthorize("@permission.check('warehouse_management_data:get')")
   public ResultVO<ListVO<WorkshopWarehouseSummaryDTO>> listWorkshopWarehouseSummary(Long projectId) {
      log.info("Api调用:车间仓库-产品数量/吨位汇总");
      return ResultBuilder.success(new ListVO<>(this.warehouseManagementBiz.listWorkshopWarehouseSummary(projectId)));
   }

   @ApiOperation("查询-已保存仓库(且未打包发运)-产品列表")
   @GetMapping("/getSaveWarehouseProductList")
   @PreAuthorize("@permission.check('warehouse_management_data:get')")
   public ResultVO<PageVO<WarehouseProductDTO>> getWarehouseProductList(
      WarehouseManagementQueryParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:已保存仓库(且未打包发运)-产品列表");
      return ResultBuilder.success(this.warehouseManagementBiz.listSaveWarehouseProduct(param, pageNumber, pageSize));
   }

   @ApiOperation("产品-移库")
   @PostMapping("/moveWarehouseProduct")
   @PreAuthorize("@permission.check('warehouse_management_data:submit')")
   public ResultVO<Boolean> moveWarehouseProduct(@RequestBody @Valid List<WarehouseProductMoveDTOParam> paramList) {
      log.info("Api调用:库位产品移库");
      return ResultBuilder.success(this.warehouseManagementBiz.moveWarehouse(paramList));
   }

   public MesBuildingWarehouseManagementController(final MesBuildingWarehouseManagementBiz warehouseManagementBiz) {
      this.warehouseManagementBiz = warehouseManagementBiz;
   }
}
