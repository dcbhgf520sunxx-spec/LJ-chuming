package com.hzchum.scim.rest.controller.wms.wmsApp;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryByMaterialDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
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

@Api(tags = "wms-app物料仓")
@RestController
@RequestMapping("/api/app/wms/material-inventory")
public class AppMaterialInventoryController {
   private static final Logger log = LoggerFactory.getLogger(AppMaterialInventoryController.class);
   @Resource
   MaterialInventoryService materialInventoryService;

   @ApiOperation("钢板查询")
   @GetMapping("/steel-plate")
   @PreAuthorize("@permission.check('materialPool')")
   public ResultVO getSteelPlate(
      QueryByMaterialDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：钢板查询");
      return ResultBuilder.success(this.materialInventoryService.pageInfo(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("型钢查询")
   @GetMapping("/section-steel")
   @PreAuthorize("@permission.check('materialPool')")
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
   @PreAuthorize("@permission.check('materialPool')")
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
   @PreAuthorize("@permission.check('materialPool')")
   public ResultVO getAuxiliaryMaterial(
      QueryByMaterialDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize,
      @RequestParam(required = false, name = "sort") List<String> sort
   ) {
      log.info("API 调用 ：辅材查询");
      return ResultBuilder.success(this.materialInventoryService.pageInfo(param, pageNumber, pageSize, sort));
   }

   @ApiOperation("气体查询")
   @GetMapping("/gas")
   @PreAuthorize("@permission.check('materialPool')")
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
   @PreAuthorize("@permission.check('materialOutBoundV2')")
   public ResultVO getById(@PathVariable("id") Long id) {
      log.info("API 调用 ：物料仓-根据ID查询");
      return ResultBuilder.success(this.materialInventoryService.getMatById(id));
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

   @ApiOperation("物料仓-查询现有辅材库存顶级科目ID")
   @GetMapping("/one-level-classify")
   public ResultVO getById(Integer warehouseType, @RequestParam(required = false) Long projectId) {
      log.info("API 调用 ：物料仓-查询现有辅材库存顶级科目ID");
      return ResultBuilder.success(this.materialInventoryService.getClassifyIdByPid(warehouseType, projectId));
   }
}
