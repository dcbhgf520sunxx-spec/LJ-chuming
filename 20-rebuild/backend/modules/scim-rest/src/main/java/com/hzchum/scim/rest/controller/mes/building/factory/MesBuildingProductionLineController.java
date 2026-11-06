package com.hzchum.scim.rest.controller.mes.building.factory;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingProductionLineBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingProductionLineDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingProductionLineDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingTeamDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingArtifactSchedulingDTOParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.groups.get.GroupsVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.groups.post.LinesTeamSaveVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.productionLine.get.ProductionLineListVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.productionLine.get.SchedulingProductionTreeVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.productionLine.post.ProductionLineSaveVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.productionLine.put.ProductionLineUpdateStatusVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.productionLine.put.ProductionLineUpdateVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.scheduling.get.MesBuildingArtifactSchedulingVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.voUtils.IdsVoRequest;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES生产线")
@RestController
@RequestMapping("/api/mes/building/productionLine")
public class MesBuildingProductionLineController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingProductionLineController.class);
   @Autowired
   private MesBuildingProductionLineService mesBuildingProductionLineService;
   @Autowired
   private MesBuildingProductionLineBiz productionLineBiz;

   @ApiOperation("获取生产线列表")
   @GetMapping
   public ResultVO<ListVO<MesBuildingProductionLineDTO>> productionLineList(ProductionLineListVORequest voRequest) {
      log.info("API 调用 ：获取生产线列表");
      return ResultBuilder.success(new ListVO<>(this.productionLineBiz.listByCondition(BeanUtil.copy(voRequest, MesBuildingProductionLineDTOParam.class))));
   }

   @ApiOperation("分页获取生产线分页列表")
   @GetMapping("/page")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "voRequest", value = "请求类", dataTypeClass = ProductionLineListVORequest.class, paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10", dataType = "int", required = true)
      }
   )
   @PreAuthorize("@permission.check('productionLine:get')")
   public ResultVO<PageVO<MesBuildingProductionLineDTO>> productionLinePage(
      ProductionLineListVORequest voRequest,
      @RequestParam(name = "sort", required = false) String sort,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize
   ) {
      log.info("API 调用 ：分页获取生产线分页列表");
      return ResultBuilder.success(
         this.productionLineBiz.productionLinePage(BeanUtil.copy(voRequest, MesBuildingProductionLineDTOParam.class), sort, pageNumber, pageSize)
      );
   }

   @ApiOperation("新增生产线")
   @PostMapping
   @PreAuthorize("@permission.check('productionLine:add')")
   public ResultVO<Boolean> productionLineSave(@RequestBody @Valid ProductionLineSaveVORequest saveVORequest, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：新增生产线");
      return ResultBuilder.success(
         this.productionLineBiz
            .saveProductionLine(BeanUtil.copy(saveVORequest, MesBuildingProductionLineDTOParam.class).setUserId(UserUtil.getCurrentUserId()))
      );
   }

   @ApiOperation("修改生产线")
   @PutMapping
   @PreAuthorize("@permission.check('productionLine:edit')")
   public ResultVO<Boolean> productionLineUpdate(@RequestBody ProductionLineUpdateVORequest request, BindingResult result) {
      log.info("API 调用 ：修改生产线");
      return ResultBuilder.success(this.productionLineBiz.update(BeanUtil.copy(request, MesBuildingProductionLineDTOParam.class)));
   }

   @ApiOperation("删除生产线")
   @DeleteMapping
   @PreAuthorize("@permission.check('productionLine:del')")
   public ResultVO<Boolean> productionLineDelete(@RequestBody IdsVoRequest voRequest) {
      log.info("API 调用 ：删除生产线");
      return ResultBuilder.success(this.productionLineBiz.removeByIds(voRequest.getIds()));
   }

   @ApiOperation("修改生产线禁用状态")
   @PutMapping("/changeState")
   @PreAuthorize("@permission.check('productionLine:editStatus')")
   public ResultVO<Boolean> updateProductionLineState(@RequestBody ProductionLineUpdateStatusVORequest voRequest) {
      log.info("API 调用 ：修改生产线禁用状态");
      return ResultBuilder.success(
         this.productionLineBiz
            .productionLineUpdateState(BeanUtil.copy(voRequest, MesBuildingProductionLineDTOParam.class).setUserId(UserUtil.getCurrentUserId()))
      );
   }

   @ApiOperation("根据id和产品类型查询类型")
   @GetMapping("/type")
   public ResultVO updateProductionLineState(Integer productType, Integer productionLineTypeEnum) {
      log.info("API 调用 ：修改生产线禁用状态");
      return ResultBuilder.success(this.productionLineBiz.getTypeByProductType(productType, productionLineTypeEnum));
   }

   @ApiOperation("获取生产线名称列表")
   @GetMapping("/name")
   public ResultVO productionLineByNameList(ProductionLineListVORequest voRequest) {
      log.info("API 调用 ：获取生产线名称列表");
      return ResultBuilder.success(this.productionLineBiz.productionLineByNameList(BeanUtil.copy(voRequest, MesBuildingProductionLineDTOParam.class)));
   }

   @ApiOperation("获取可排产生产组树")
   @GetMapping("/scheduling/tree")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "voRequest", value = "请求类", dataTypeClass = GroupsVORequest.class, paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10", dataType = "int", required = true)
      }
   )
   public ResultVO getSchedulingLineTree(@Validated SchedulingProductionTreeVORequest voRequest) {
      log.info("API 调用 ：分页获取生产组分页列表");
      return ResultBuilder.success(
         this.productionLineBiz.getSchedulingLineTree(BeanUtil.copy(voRequest, MesBuildingTeamDTOParam.class), voRequest.getMesProductEnum())
      );
   }

   @ApiOperation("获取可排产生产组树")
   @GetMapping("/enclosure/scheduling/tree")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "voRequest", value = "请求类", dataTypeClass = GroupsVORequest.class, paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10", dataType = "int", required = true)
      }
   )
   public ResultVO getEnclosureSchedulingLineTree(@Validated SchedulingProductionTreeVORequest voRequest) {
      log.info("API 调用 ：分页获取生产组分页列表");
      return ResultBuilder.success(this.productionLineBiz.getEnclosureSchedulingLineTree(BeanUtil.copy(voRequest, MesBuildingTeamDTOParam.class)));
   }

   @ApiOperation("获取生产线构件预排产种类汇总信息")
   @GetMapping("/record/lines/summary")
   public ResultVO getGroupsRecordSummary(MesBuildingArtifactSchedulingVORequest voRequest) {
      log.info("API 调用 ：获取生产组构件预排产汇总信息");
      return ResultBuilder.success(
         new ListVO<>(this.productionLineBiz.getLinesRecordSummary(BeanUtil.copy(voRequest, MesBuildingArtifactSchedulingDTOParam.class)))
      );
   }

   @ApiOperation("获取生产组构件预排产汇总信息")
   @GetMapping("/record/lines/name/summary")
   public ResultVO getGroupsRecordSummary2(MesBuildingArtifactSchedulingVORequest voRequest) {
      log.info("API 调用 ：获取生产组构件预排产汇总信息");
      return ResultBuilder.success(
         new ListVO<>(this.productionLineBiz.getLinesRecordSummary(BeanUtil.copy(voRequest, MesBuildingArtifactSchedulingDTOParam.class)))
      );
   }

   @ApiOperation("批量添加班组信息")
   @PostMapping("/team/add")
   public ResultVO saveProductionLineTeam(@RequestBody LinesTeamSaveVORequest voRequest) {
      log.info("API 调用 ：批量添加班组信息");
      return ResultBuilder.success(this.productionLineBiz.saveTeam(voRequest.getId(), voRequest.getTeamIds(), voRequest.getTeamType()));
   }
}
