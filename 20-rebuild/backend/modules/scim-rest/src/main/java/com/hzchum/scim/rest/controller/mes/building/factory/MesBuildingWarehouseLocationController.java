package com.hzchum.scim.rest.controller.mes.building.factory;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingWarehouseBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingWarehouseDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingWarehouseDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingWarehouseQueryDTOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES库位")
@RequestMapping("/api/mes/building/warehouse")
@RestController
public class MesBuildingWarehouseLocationController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingWarehouseLocationController.class);
   private final MesBuildingWarehouseBiz warehouseBiz;

   @ApiOperation("车间-库位-树结构")
   @GetMapping("/tree")
   public ResultVO<ListVO<Map<String, Object>>> getWarehouseTree(@RequestHeader(value = "factoryId", required = false) Long factoryId) {
      log.info("获取车间-库位树");
      List<Map<String, Object>> workshopWarehouseTree = this.warehouseBiz.getWorkshopWarehouseTree(factoryId, true);
      return ResultBuilder.success(new ListVO<>(workshopWarehouseTree));
   }

   @ApiOperation("列表-公共接口")
   @GetMapping("/list/public")
   ResultVO<ListVO<MesBuildingWarehouseDTO>> publicList(Long workshopId, String name) {
      log.info("Api调用:库位-列表-公共接口");
      MesBuildingWarehouseQueryDTOParam param = MesBuildingWarehouseQueryDTOParam.builder().workshopId(workshopId).name(name).boolEnableEnum(true).build();
      return ResultBuilder.success(new ListVO<>(this.warehouseBiz.listWarehouse(param)));
   }

   @ApiOperation("列表-分页")
   @GetMapping("/list")
   ResultVO<PageVO<MesBuildingWarehouseDTO>> pageList(
      MesBuildingWarehouseQueryDTOParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:库位-分页列表");
      return ResultBuilder.success(this.warehouseBiz.pageList(param, pageNumber, pageSize));
   }

   @ApiOperation("新增")
   @PostMapping("/save")
   @PreAuthorize("@permission.check('manuf_warehouse_config:add')")
   public ResultVO<Boolean> save(@RequestBody @Valid MesBuildingWarehouseDTOParam param) {
      log.info("Api调用:库位-新增");
      return ResultBuilder.success(this.warehouseBiz.saveWarehouse(param));
   }

   @ApiOperation("修改")
   @PutMapping("/update")
   @PreAuthorize("@permission.check('manuf_warehouse_config:edit')")
   public ResultVO<Boolean> update(@RequestBody @Valid MesBuildingWarehouseDTOParam param) {
      log.info("Api调用:库位-修改");
      return ResultBuilder.success(this.warehouseBiz.updateWarehouse(param));
   }

   @ApiOperation("修改-状态")
   @PutMapping("/update/{id}/{boolEnableEnum}")
   @PreAuthorize("@permission.check('manuf_warehouse_config:editStatus')")
   public ResultVO<Boolean> updateStatus(@PathVariable Long id, @PathVariable Boolean boolEnableEnum) {
      log.info("Api调用:库位-修改状态");
      return ResultBuilder.success(this.warehouseBiz.updateWarehouseStatus(id, boolEnableEnum));
   }

   @ApiOperation("删除")
   @DeleteMapping("remove/{id}")
   @PreAuthorize("@permission.check('manuf_warehouse_config:del')")
   public ResultVO<Boolean> remove(@PathVariable Long id) {
      log.info("Api调用:库位-删除");
      Set<Long> ids = new HashSet<>();
      ids.add(id);
      return ResultBuilder.success(this.warehouseBiz.removeWarehouse(ids));
   }

   @ApiOperation("删除-批量")
   @DeleteMapping("remove/batch")
   @PreAuthorize("@permission.check('manuf_warehouse_config:del')")
   public ResultVO<Boolean> removeBatch(@RequestBody Set<Long> ids) {
      log.info("Api调用:库位-批量删除");
      return ResultBuilder.success(this.warehouseBiz.removeWarehouse(ids));
   }

   public MesBuildingWarehouseLocationController(final MesBuildingWarehouseBiz warehouseBiz) {
      this.warehouseBiz = warehouseBiz;
   }
}
