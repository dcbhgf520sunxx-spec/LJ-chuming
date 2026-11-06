package com.hzchum.scim.rest.controller.wms.wmsUse;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryByMaterialDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryByMaterialIdsDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "wms-物料仓")
@RestController
@RequestMapping("/api/wms/material-inventory")
public class MaterialInventoryController {
   private static final Logger log = LoggerFactory.getLogger(MaterialInventoryController.class);
   @Resource
   MaterialInventoryService materialInventoryService;

   @ApiOperation("钢板查询")
   @GetMapping("/steel-plate")
   @PreAuthorize("@permission.check('wms_matWarehouse_steel:get')")
   public ResultVO getSteelPlate(
      QueryByMaterialDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：钢板查询");
      return ResultBuilder.success(this.materialInventoryService.pageInfo(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("钢板查询（不分页）")
   @GetMapping("/steel-plateDetail")
   public ResultVO getSteelPlateDetail(QueryByMaterialDTOParam param) {
      log.info("API 调用 ：钢板查询");
      return ResultBuilder.success(this.materialInventoryService.getSteelPlateDetail(param));
   }

   @ApiOperation("盘亏物料分组查询")
   @GetMapping("/group/steel-plateDetail")
   public ResultVO getSteelPlateDetailGroupByClassifyName(@RequestParam Integer basicClass, @RequestParam List<String> classifyNames) {
      log.info("API 调用 ：盘亏物料分组查询");
      return ResultBuilder.success(this.materialInventoryService.getSteelPlateDetailGroupByClassifyName(basicClass, classifyNames));
   }

   @ApiOperation("型钢查询")
   @GetMapping("/section-steel")
   @PreAuthorize("@permission.check('wms_matWarehouse_steel:get')")
   public ResultVO getSectionSteel(
      QueryByMaterialDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：型钢查询");
      return ResultBuilder.success(this.materialInventoryService.pageInfo(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("钢卷查询")
   @GetMapping("/steel-coil")
   @PreAuthorize("@permission.check('wms_matWarehouse_steel:get')")
   public ResultVO getSteelCoil(
      QueryByMaterialDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：钢卷查询");
      return ResultBuilder.success(this.materialInventoryService.pageInfo(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("辅材查询")
   @GetMapping("/auxiliary-material")
   @PreAuthorize("@permission.check('wms_matWarehouse_auxMaterial:get')")
   public ResultVO getAuxiliaryMaterial(
      QueryByMaterialDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：辅材查询");
      return ResultBuilder.success(this.materialInventoryService.pageInfo(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("其它查询")
   @GetMapping("/other-material")
   @PreAuthorize("@permission.check('wms_matWarehouse_other:get')")
   public ResultVO getOtherMaterial(
      QueryByMaterialDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：其它查询");
      return ResultBuilder.success(this.materialInventoryService.pageInfo(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("气体查询")
   @GetMapping("/gas")
   @PreAuthorize("@permission.check('wms_matWarehouse_gas:get')")
   public ResultVO getAas(
      QueryByMaterialDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：气体查询");
      return ResultBuilder.success(this.materialInventoryService.pageInfo(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("物料仓-根据ID查询")
   @GetMapping("/{id}")
   public ResultVO getById(@PathVariable("id") Long id) {
      log.info("API 调用 ：物料仓-根据ID查询");
      return ResultBuilder.success(this.materialInventoryService.getMatById(id));
   }

   @ApiOperation("物料仓-根据IDs查询")
   @GetMapping("/ids")
   public ResultVO getByIds(QueryByMaterialIdsDTOParam param) {
      log.info("API 调用 ：物料仓-根据IDs查询物料");
      return ResultBuilder.success(this.materialInventoryService.getMatByIds(param));
   }

   @ApiOperation("物料仓-根据末级科目IDs查询物料")
   @PostMapping("/classIds")
   public ResultVO getByClassIds(@RequestBody QueryByMaterialIdsDTOParam param) {
      log.info("API 调用 ：物料仓-根据末级科目IDs查询物料");
      return ResultBuilder.success(this.materialInventoryService.getByClassIds(param));
   }

   @ApiOperation("物料仓-虚拟物料查询")
   @GetMapping("/virtual")
   public ResultVO getById(
      QueryByMaterialDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：物料仓-虚拟物料查询");
      return ResultBuilder.success(this.materialInventoryService.getVirtual(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("查询可申购冻结物料")
   @GetMapping("/apply-purchase-steel")
   public ResultVO getByCondition(
      Integer warehouseType,
      @RequestParam(required = false) Long classifyId,
      Integer basicClass,
      @RequestParam(required = false) BigDecimal thickness,
      @RequestParam(required = false, defaultValue = "0") BigDecimal width,
      @RequestParam(required = false, defaultValue = "0") BigDecimal length,
      @RequestParam(required = false) String spec
   ) {
      log.info("API 调用 ：查询可申购冻结物料");
      return ResultBuilder.success(this.materialInventoryService.getByCondition(warehouseType, classifyId, basicClass, thickness, width, length, spec));
   }
}
