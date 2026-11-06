package com.hzchum.scim.rest.controller.mes.building.warehouse;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.mes.building.core.api.biz.warehouse.MesBuildingWarehouseManagementBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse.WarehouseProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse.AppWarehouseProductSaveParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse.AppWarehouseProductScanQrCodeParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse.WarehouseManagementQueryParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.Map;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES库位管理-APP")
@Validated
@RestController
@RequestMapping("/api/app/mes/building/warehouseManagement")
public class MesBuildingWarehouseManagementAppController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingWarehouseManagementAppController.class);
   private final MesBuildingWarehouseManagementBiz warehouseManagementBiz;

   @ApiOperation("产品扫码")
   @GetMapping("/scanQrCode/product")
   public ResultVO<Map<String, Object>> scanQrCode(@Valid AppWarehouseProductScanQrCodeParam param) {
      log.info("Api调用:扫描产品-保存库位");
      return ResultBuilder.success(this.warehouseManagementBiz.scanQrCodeWarehouse(param));
   }

   @ApiOperation("未保存库位(且未打包发运)-产品列表")
   @GetMapping("/unIntoWarehouseLocation/product/list")
   public ResultVO<PageVO<WarehouseProductDTO>> getUnWarehouseProductList(
      WarehouseManagementQueryParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:app端-查询未保存仓库(且未打包发运)-产品列表");
      return ResultBuilder.success(this.warehouseManagementBiz.listUnSaveWarehouseProduct(param, pageNumber, pageSize));
   }

   @ApiOperation("扫码存入库位-保存")
   @PostMapping("/scanQrCode/save")
   public ResultVO<Boolean> scanQrCodeSave(@RequestBody @Valid AppWarehouseProductSaveParam param) {
      log.info("Api调用:app端-保存-产品存入库位");
      return ResultBuilder.success(this.warehouseManagementBiz.appScanQrCodeSave(param));
   }

   @ApiOperation("未保存库位-项目列表")
   @GetMapping("/unIntoWarehouseLocation/project/list")
   public ResultVO<ListVO<ProjectInfo>> getUnWarehouseProjectList() {
      log.info("Api调用:app端-存在未保存库位产品-项目列表");
      return ResultBuilder.success(new ListVO<>(this.warehouseManagementBiz.getUnIntoWarehouseLocationProjectList()));
   }

   @ApiOperation("手动选择存入库位-保存")
   @PostMapping("/manualSelect/save")
   public ResultVO<Boolean> manualSelectSave(@RequestBody @Valid AppWarehouseProductSaveParam param) {
      log.info("Api调用:app端-保存-产品存入库位");
      return ResultBuilder.success(this.warehouseManagementBiz.appManualSelectCodeSave(param));
   }

   public MesBuildingWarehouseManagementAppController(final MesBuildingWarehouseManagementBiz warehouseManagementBiz) {
      this.warehouseManagementBiz = warehouseManagementBiz;
   }
}
