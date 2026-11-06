package com.hzchum.scim.rest.controller.plan;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.plan.core.api.biz.ProjectExecutionDynamicsBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "计划管理-项目执行动态")
@RequestMapping("/api/plan/project-execution-dynamics")
@RestController
public class ProjectExecutionDynamicsController {
   private static final Logger log = LoggerFactory.getLogger(ProjectExecutionDynamicsController.class);
   @Autowired
   private ProjectExecutionDynamicsBiz projectExecutionDynamicsBiz;

   @ApiOperation("分页")
   @GetMapping("page")
   public ResultVO page(
      @ApiParam("年份") @RequestParam(required = false) Integer year,
      @ApiParam(value = "状态(1: 执行中, 4: 已完工)", required = true) @RequestParam Integer status,
      @ApiParam("项目ID") @RequestParam(required = false) Long projectId,
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize,
      @RequestParam(required = false) List<String> sort
   ) {
      log.info("API调用: 分页");
      return ResultBuilder.success(this.projectExecutionDynamicsBiz.pageInfo(year, status, projectId, pageNumber, pageSize, sort));
   }

   @ApiOperation("深化明细")
   @GetMapping("deepen-detail/{projectId}")
   public ResultVO deepenDetail(@PathVariable Long projectId) {
      log.info("API调用: 深化明细");
      return ResultBuilder.success(new ListVO<>(this.projectExecutionDynamicsBiz.deepenDetail(projectId)));
   }

   @ApiOperation("深化明细-产品明细")
   @GetMapping("deepen-detail/product/{projectId}")
   public ResultVO deepenDetailProduct(
      @PathVariable Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize,
      @RequestParam(required = false) List<String> sort
   ) {
      log.info("API调用: 深化明细-产品明细");
      return ResultBuilder.success(this.projectExecutionDynamicsBiz.deepenDetailProduct(projectId, monomerId, areaId, pageNumber, pageSize, sort));
   }

   @ApiOperation("排产明细")
   @GetMapping("scheduling-detail/{projectId}")
   public ResultVO schedulingDetail(@PathVariable Long projectId) {
      log.info("API调用: 排产明细");
      return ResultBuilder.success(new ListVO<>(this.projectExecutionDynamicsBiz.schedulingDetail(projectId)));
   }

   @ApiOperation("排产明细-产品明细")
   @GetMapping("scheduling-detail/product/{projectId}")
   public ResultVO schedulingDetailProduct(
      @PathVariable Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize,
      @RequestParam(required = false) List<String> sort
   ) {
      log.info("API调用: 排产明细-产品明细");
      return ResultBuilder.success(this.projectExecutionDynamicsBiz.schedulingDetailProduct(projectId, monomerId, areaId, pageNumber, pageSize, sort));
   }

   @ApiOperation("排产明细-产品明细打印")
   @GetMapping("scheduling-detail/product/print/{projectId}")
   public ResultVO schedulingDetailProductPrint(
      @PathVariable Long projectId, @RequestParam(required = false) Long monomerId, @RequestParam(required = false) Long areaId
   ) {
      log.info("API调用: 排产明细-产品明细打印");
      return ResultBuilder.success(this.projectExecutionDynamicsBiz.schedulingDetailProductPrint(projectId, monomerId, areaId));
   }

   @ApiOperation("生产明细")
   @GetMapping("produced-detail/{projectId}")
   public ResultVO producedDetail(@PathVariable Long projectId) {
      log.info("API调用: 生产明细");
      return ResultBuilder.success(new ListVO<>(this.projectExecutionDynamicsBiz.producedDetail(projectId)));
   }

   @ApiOperation("生产明细-产品明细")
   @GetMapping("produced-detail/product/{projectId}")
   public ResultVO producedDetailProduct(
      @PathVariable Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize,
      @RequestParam(required = false) List<String> sort
   ) {
      log.info("API调用: 生产明细-产品明细");
      return ResultBuilder.success(this.projectExecutionDynamicsBiz.producedDetailProduct(projectId, monomerId, areaId, pageNumber, pageSize, sort));
   }

   @ApiOperation("生产明细-产品明细打印")
   @GetMapping("produced-detail/product/print/{projectId}")
   public ResultVO producedDetailProductPrint(
      @PathVariable Long projectId, @RequestParam(required = false) Long monomerId, @RequestParam(required = false) Long areaId
   ) {
      log.info("API调用: 生产明细-产品明细打印");
      return ResultBuilder.success(this.projectExecutionDynamicsBiz.producedDetailProductPrint(projectId, monomerId, areaId));
   }

   @ApiOperation("未生产明细")
   @GetMapping("not-produced-detail/{projectId}")
   public ResultVO notProducedDetail(@PathVariable Long projectId) {
      log.info("API调用: 未生产明细");
      return ResultBuilder.success(new ListVO<>(this.projectExecutionDynamicsBiz.notProducedDetail(projectId)));
   }

   @ApiOperation("未生产明细-产品明细")
   @GetMapping("not-produced-detail/product/{projectId}")
   public ResultVO notProducedDetailProduct(
      @PathVariable Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize,
      @RequestParam(required = false) List<String> sort
   ) {
      log.info("API调用: 未生产明细-产品明细");
      return ResultBuilder.success(this.projectExecutionDynamicsBiz.notProducedDetailProduct(projectId, monomerId, areaId, pageNumber, pageSize, sort));
   }

   @ApiOperation("未生产明细-产品明细打印")
   @GetMapping("not-produced-detail/product/print/{projectId}")
   public ResultVO notProducedDetailProductPrint(
      @PathVariable Long projectId, @RequestParam(required = false) Long monomerId, @RequestParam(required = false) Long areaId
   ) {
      log.info("API调用: 未生产明细-产品明细打印");
      return ResultBuilder.success(this.projectExecutionDynamicsBiz.notProducedDetailProductPrint(projectId, monomerId, areaId));
   }

   @ApiOperation("发运明细")
   @GetMapping("delivery-detail/{projectId}")
   public ResultVO deliveryDetail(@PathVariable Long projectId) {
      log.info("API调用: 发运明细");
      return ResultBuilder.success(new ListVO<>(this.projectExecutionDynamicsBiz.deliveryDetail(projectId)));
   }

   @ApiOperation("发运明细-产品明细")
   @GetMapping("delivery-detail/product/{projectId}")
   public ResultVO deliveryDetailProduct(
      @PathVariable Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Long areaId,
      @RequestParam Integer pageNumber,
      @RequestParam Integer pageSize,
      @RequestParam(required = false) List<String> sort
   ) {
      log.info("API调用: 发运明细-产品明细");
      return ResultBuilder.success(this.projectExecutionDynamicsBiz.deliveryDetailProduct(projectId, monomerId, areaId, pageNumber, pageSize, sort));
   }

   @ApiOperation("发运明细-产品明细打印")
   @GetMapping("delivery-detail/product/print/{projectId}")
   public ResultVO deliveryDetailProductPrint(
      @PathVariable Long projectId, @RequestParam(required = false) Long monomerId, @RequestParam(required = false) Long areaId
   ) {
      log.info("API调用: 发运明细-产品明细打印");
      return ResultBuilder.success(this.projectExecutionDynamicsBiz.deliveryDetailProductPrint(projectId, monomerId, areaId));
   }
}
