package com.hzchum.scim.rest.controller.mes.building.projectKanban;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.projectKanban.ProductKanbanBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.projectKanban.ProductKanbanDTOParam;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.projectKanban.get.ProductKanbanVORequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES产品看板")
@RestController
@RequestMapping("/api/mes/building/kanban/product")
public class ProductKanbanController {
   private static final Logger log = LoggerFactory.getLogger(ProductKanbanController.class);
   @Autowired
   private ProductKanbanBiz productKanbanBiz;

   @ApiOperation("获取产品生产报表汇总")
   @GetMapping("/steelSpec")
   @PreAuthorize("@permission.check('mes_artifact_production_dashboard:get')")
   public ResultVO machinePartSteelSpec(ProductKanbanVORequest voRequest) {
      log.info("API 调用 ：获取产品生产报表汇总");
      return ResultBuilder.success(new ListVO<>(this.productKanbanBiz.machinePartSteelSpec(BeanUtil.copy(voRequest, ProductKanbanDTOParam.class))));
   }

   @ApiOperation("获取产品生产报表汇总")
   @GetMapping("/list")
   @PreAuthorize("@permission.check('mes_artifact_production_dashboard:get')")
   public ResultVO productSummary(ProductKanbanVORequest voRequest) {
      log.info("API 调用 ：获取产品生产报表汇总");
      return ResultBuilder.success(new ListVO<>(this.productKanbanBiz.productKanban(BeanUtil.copy(voRequest, ProductKanbanDTOParam.class))));
   }

   @ApiOperation("获取产品生产报表汇总")
   @GetMapping("/page")
   @PreAuthorize("@permission.check('mes_artifact_production_dashboard:get')")
   public ResultVO productSummary(
      ProductKanbanVORequest voRequest,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize
   ) {
      log.info("API 调用 ：获取产品生产报表汇总");
      return ResultBuilder.success(this.productKanbanBiz.productKanbanPage(BeanUtil.copy(voRequest, ProductKanbanDTOParam.class), pageNumber, pageSize));
   }

   @ApiOperation("获取构件工序汇总详情")
   @GetMapping("/detail/artifact")
   @PreAuthorize("@permission.check('mes_artifact_production_dashboard:get')")
   public ResultVO artifactDetail(Long id) {
      log.info("API 调用 ：获取构件工序汇总详情");
      return ResultBuilder.success(this.productKanbanBiz.artifactDetail(id));
   }

   @ApiOperation("获取围护工序汇总详情")
   @GetMapping("/detail/enclosure")
   @PreAuthorize("@permission.check('mes_artifact_production_dashboard:get')")
   public ResultVO enclosureDetail(Long id) {
      log.info("API 调用 ：获取围护工序汇总详情");
      return ResultBuilder.success(this.productKanbanBiz.enclosureDetail(id));
   }

   @ApiOperation("获取组立工序汇总详情")
   @GetMapping("/detail/assemble")
   @PreAuthorize("@permission.check('mes_artifact_production_dashboard:get')")
   public ResultVO assembleDetail(Long id) {
      log.info("API 调用 ：获取组立工序汇总详情");
      return ResultBuilder.success(this.productKanbanBiz.assembleDetail(id));
   }

   @ApiOperation("获取组立工序汇总详情")
   @GetMapping("/detail/machine_part")
   @PreAuthorize("@permission.check('mes_artifact_production_dashboard:get')")
   public ResultVO machinePartDetail(Long id) {
      log.info("API 调用 ：获取组立工序汇总详情");
      return ResultBuilder.success(this.productKanbanBiz.machinePartDetail(id));
   }

   @ApiOperation("结构看板查看构件及构件关联零部件生产信息")
   @GetMapping("/link/detail")
   @PreAuthorize("@permission.check('mes_artifact_production_dashboard:get')")
   public ResultVO getArtifactKanbanInfo(Long productId) {
      log.info("API 调用 ：结构看板查看构件及构件关联零部件生产信息");
      return ResultBuilder.success(this.productKanbanBiz.getArtifactKanbanInfo(productId));
   }
}
