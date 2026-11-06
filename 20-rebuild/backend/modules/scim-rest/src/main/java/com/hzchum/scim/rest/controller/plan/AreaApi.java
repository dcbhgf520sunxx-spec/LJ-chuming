package com.hzchum.scim.rest.controller.plan;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.plan.core.api.biz.PlanAreaBiz;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanAreaBatchDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanAreaDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.AreaBatchUpdateVORequest;
import com.hzchum.scim.plan.core.api.pojo.vo.AreaSaveVORequest;
import com.hzchum.scim.plan.core.api.pojo.vo.AreaUpdateVORequest;
import com.hzchum.scim.plan.core.api.service.PlanAreaBatchService;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
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

@Api(tags = "计划管理-区域")
@RestController
@RequestMapping("/api/plan/area")
public class AreaApi {
   private static final Logger log = LoggerFactory.getLogger(AreaApi.class);
   private final PlanAreaService areaService;
   private final PlanAreaBiz areaBiz;
   private final PlanAreaBatchService areaBatchService;

   @ApiOperation(value = "区域列表", notes = "根据 项目id,单体id,和产品类型 获得区域列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query", required = true),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query"),
            @ApiImplicitParam(name = "productType", value = "产品类型 1结构件 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件 ", paramType = "query"),
            @ApiImplicitParam(name = "Integer itemizedType", value = "区域分项", paramType = "query")
      }
   )
   @GetMapping("")
   @PreAuthorize("@permission.check('plan_area_manage:get')")
   public ResultVO<PageVO<PlanAreaDTO>> pageByMonomerIdAndMaterialType(
      Long projectId,
      Long monomerId,
      Integer productType,
      @RequestParam(required = false) Integer itemizedType,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：根据单体id和产品类型获得区域列表");
      return ResultBuilder.success(this.areaService.listAreaByConditions(projectId, monomerId, productType, itemizedType, pageNumber, pageSize));
   }

   @ApiOperation(value = "区域列表", notes = "根据 项目id,单体id,和产品类型 获得区域列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query", required = true),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query"),
            @ApiImplicitParam(name = "productType", value = "产品类型 1结构件 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件 ", paramType = "query"),
            @ApiImplicitParam(name = "Integer itemizedType", value = "区域分项", paramType = "query")
      }
   )
   @GetMapping("/app")
   public ResultVO<PageVO<PlanAreaDTO>> appPageByMonomerIdAndMaterialType(
      Long projectId,
      Long monomerId,
      Integer productType,
      @RequestParam(required = false) Integer itemizedType,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：根据单体id和产品类型获得区域列表");
      return ResultBuilder.success(this.areaService.listAreaByConditions(projectId, monomerId, productType, itemizedType, pageNumber, pageSize));
   }

   @ApiOperation(value = "区域列表", notes = "根据 项目id,单体id,和产品类型 获得批次列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query", required = true),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query"),
            @ApiImplicitParam(name = "productType", value = "产品类型 1结构件 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件 ", paramType = "query"),
            @ApiImplicitParam(name = "Integer itemizedType", value = "区域分项", paramType = "query")
      }
   )
   @GetMapping("/batch/app")
   public ResultVO<PageVO<PlanAreaBatchDTO>> appPageByMonomerIdAndAreaBatchType(
      Long projectId,
      Long monomerId,
      Integer productType,
      @RequestParam(required = false) Integer itemizedType,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：根据单体id和产品类型获得区域列表");
      return ResultBuilder.success(
         this.areaBatchService.appPageByMonomerIdAndAreaBatchType(projectId, monomerId, productType, itemizedType, pageNumber, pageSize)
      );
   }

   @ApiOperation(value = "批次列表", notes = "根据 项目id,单体id,和产品类型 获得批次列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query", required = true),
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query"),
            @ApiImplicitParam(name = "productType", value = "产品类型 1结构件 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件 ", paramType = "query"),
            @ApiImplicitParam(name = "itemizedType", value = "区域分项", paramType = "query"),
            @ApiImplicitParam(name = "name", value = "批次名称", paramType = "query")
      }
   )
   @GetMapping("/batch/list")
   public ResultVO<List<PlanAreaBatchDTO>> getList(
      @RequestParam Long projectId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) Integer productType,
      @RequestParam(required = false) Integer itemizedType,
      @RequestParam(required = false) String name
   ) {
      log.info("API 调用 ：根据单体id和产品类型获得区域列表");
      return ResultBuilder.success(this.areaBatchService.getList(projectId, monomerId, productType, itemizedType, name));
   }

   @ApiOperation(value = "产品类型列表", notes = "根据单体id查询本单体下的产品类型列表")
   @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "path", required = true)
   @GetMapping("/listProductType/{monomerId}")
   public ResultVO listProductTypesBy(@PathVariable("monomerId") Long monomerId) {
      log.info("API 调用 : 根据单体id查询产品类型的列表");
      return ResultBuilder.success(this.areaService.listProductTypeByMonomerId(monomerId));
   }

   @ApiOperation(value = "查询单个区域", notes = "根据 id 查询单个区域")
   @ApiImplicitParam(name = "id", value = "区域id", paramType = "path", required = true)
   @GetMapping("/getById/{id}")
   public ResultVO getAreaById(@PathVariable("id") Long id) {
      log.info("API 调用 ：根据区域id获得区域信息");
      return ResultBuilder.success(this.areaService.getByIdFromCache(id));
   }

   @ApiOperation(value = "新增区域", notes = "新增区域")
   @PostMapping("")
   @PreAuthorize("@permission.check('plan_area_manage:add')")
   public ResultVO saveArea(@Valid @RequestBody AreaSaveVORequest voRequest) {
      log.info("API 调用 ：保存一个新的区域");
      return ResultBuilder.success(this.areaBiz.saveArea(voRequest));
   }

   @ApiOperation(value = "区域更新", notes = "更新区域的信息")
   @PutMapping("")
   @PreAuthorize("@permission.check('plan_area_manage:edit')")
   public ResultVO updateArea(@Valid @RequestBody AreaUpdateVORequest voRequest) {
      log.info("API 调用 ： 更新区域的信息");
      return ResultBuilder.success(this.areaBiz.updateArea(voRequest));
   }

   @ApiOperation(value = "删除区域", notes = "根据区域id列表删除区域")
   @DeleteMapping("")
   @PreAuthorize("@permission.check('plan_area_manage:del')")
   public ResultVO deleteArea(@RequestBody List<Long> ids) {
      log.info("API 调用 ： 根据区域id列表批量删除区域");
      return ResultBuilder.success(this.areaBiz.deleteAreas(ids));
   }

   @ApiOperation(value = "下载区域表单", notes = "下载区域表单")
   @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query", required = true)
   @GetMapping("/export")
   @PreAuthorize("@permission.check('plan_area_manage:print')")
   public ResultVO exportArea(@RequestParam Long monomerId, HttpServletResponse response) throws IOException {
      log.info("API 调用 ：下载区域表单");
      return ResultBuilder.success(this.areaBiz.exportArea(monomerId, response));
   }

   @ApiOperation("打印区域表单")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "monomerId", value = "单体id", paramType = "query", required = true),
            @ApiImplicitParam(name = "productType", value = "产品类型 1结构件 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件", paramType = "query", required = true)
      }
   )
   @GetMapping("/print")
   @PreAuthorize("@permission.check('plan_area_manage:print')")
   public ResultVO printArea(@RequestParam("monomerId") Long monomerId, @RequestParam("productType") Integer productType) {
      log.info("API 调用 ：打印区域表单");
      return ResultBuilder.success(this.areaBiz.printArea(monomerId, productType));
   }

   @ApiOperation(value = "项目三级树", notes = "根据项目id列表 查询项目单体区域 三级树")
   @GetMapping("/listProjectTree")
   public ResultVO listProjectTree(@RequestParam(required = false) List<Long> ids) {
      log.info("Api调用: 根据项目id列表 查询项目单体区域 三级树");
      return ResultBuilder.success(this.areaBiz.listProjectTree(ids));
   }

   @ApiOperation(value = "批次名称更新", notes = "批次名称更新")
   @PutMapping("/batch")
   @PreAuthorize("@permission.check('plan_artifact_tree_list:changeBtn')")
   public ResultVO updateArea(@Valid @RequestBody AreaBatchUpdateVORequest voRequest) {
      log.info("API 调用 ： 批次名称更新");
      return ResultBuilder.success(this.areaBatchService.updateAreaBatch(voRequest));
   }

   public AreaApi(final PlanAreaService areaService, final PlanAreaBiz areaBiz, final PlanAreaBatchService areaBatchService) {
      this.areaService = areaService;
      this.areaBiz = areaBiz;
      this.areaBatchService = areaBatchService;
   }
}
