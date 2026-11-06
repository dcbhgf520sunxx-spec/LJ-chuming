package com.hzchum.scim.rest.controller.mes.building.projectKanban;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.projectKanban.ProductKanbanBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.projectKanban.ProductKanbanDTOParam;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.projectKanban.get.AssembleMatchingVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.voUtils.IdsVoRequest;
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

@Api(tags = "MES总装匹配")
@RestController
@RequestMapping("/api/mes/building/kanban/assemble_matching")
public class AssembleMatchingController {
   private static final Logger log = LoggerFactory.getLogger(AssembleMatchingController.class);
   @Autowired
   private ProductKanbanBiz productKanbanBiz;

   @ApiOperation("获取构件")
   @GetMapping("/list")
   @PreAuthorize("@permission.check('mes_assembly_match:get')")
   public ResultVO artifactList(AssembleMatchingVORequest voRequest) {
      log.info("API 调用 ：获取产品生产报表汇总");
      return ResultBuilder.success(new ListVO<>(this.productKanbanBiz.artifactAssembleMatchingList(BeanUtil.copy(voRequest, ProductKanbanDTOParam.class))));
   }

   @ApiOperation("分页获取构件")
   @GetMapping("/page")
   @PreAuthorize("@permission.check('mes_assembly_match:get')")
   public ResultVO artifactPage(
      AssembleMatchingVORequest voRequest,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize
   ) {
      log.info("API 调用 ：获取产品生产报表汇总");
      return ResultBuilder.success(
         this.productKanbanBiz.artifactAssembleMatchingPage(BeanUtil.copy(voRequest, ProductKanbanDTOParam.class), pageNumber, pageSize)
      );
   }

   @ApiOperation("获取零件生产详情")
   @GetMapping("/detail")
   @PreAuthorize("@permission.check('mes_assembly_match:get')")
   public ResultVO machinePartDetail(IdsVoRequest voRequest) {
      log.info("API 调用 ：获取构件工序汇总详情");
      return ResultBuilder.success(this.productKanbanBiz.machinePartList(voRequest.getIds()));
   }

   @ApiOperation("获取零件生产详情")
   @GetMapping("/v2/detail")
   @PreAuthorize("@permission.check('mes_assembly_match:get')")
   public ResultVO machinePartListV2V2(IdsVoRequest voRequest, Integer taskTypeEnum) {
      log.info("API 调用 ：获取构件工序汇总详情");
      return ResultBuilder.success(this.productKanbanBiz.machinePartListV2(voRequest.getIds(), taskTypeEnum));
   }

   @ApiOperation("获取零件生产详情")
   @GetMapping("/detail/print")
   @PreAuthorize("@permission.check('mes_assembly_match:print')")
   public ResultVO machinePartListPrint(IdsVoRequest voRequest) {
      log.info("API 调用 ：获取构件工序汇总详情");
      return ResultBuilder.success(this.productKanbanBiz.machinePartListPrint(voRequest.getIds()));
   }

   @ApiOperation("获取区域下零部件生产数据")
   @GetMapping("/area/product")
   @PreAuthorize("@permission.check('mes_assembly_match:get')")
   public ResultVO areaProductList(Long projectId, Long monomerId, Long areaId) {
      log.info("API 调用 ：获取区域下零部件生产数据");
      return ResultBuilder.success(this.productKanbanBiz.areaProductList(projectId, monomerId, areaId));
   }

   @ApiOperation("获取区域下零部件生产数据")
   @GetMapping("/area/product/page")
   @PreAuthorize("@permission.check('mes_assembly_match:get')")
   public ResultVO areaProductListPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize
   ) {
      log.info("API 调用 ：获取区域下零部件生产数据");
      return ResultBuilder.success(this.productKanbanBiz.areaProductListPage(projectId, monomerId, areaId, pageNumber, pageSize));
   }

   @ApiOperation("打印区域下零部件生产数据")
   @GetMapping("/area/product/print")
   @PreAuthorize("@permission.check('mes_assembly_match:printDetail')")
   public ResultVO areaProductListPrint(Long projectId, Long monomerId, Long areaId) {
      log.info("API 调用 ：打印区域下零部件生产数据");
      return ResultBuilder.success(this.productKanbanBiz.areaProductListPrint(projectId, monomerId, areaId));
   }

   @ApiOperation("获取区域下构件汇总")
   @GetMapping("/area/artifact")
   @PreAuthorize("@permission.check('mes_assembly_match:get')")
   public ResultVO areaArtifactSummary(Long projectId, Long monomerId, Long areaId) {
      log.info("API 调用 ：获取区域下构件汇总");
      return ResultBuilder.success(this.productKanbanBiz.areaArtifactSummary(projectId, monomerId, areaId));
   }
}
