package com.hzchum.scim.rest.controller.mes.enclosure.factory;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.enclosure.core.api.biz.factory.MesEnclosureProductionLineBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.MesEnclosureProductionLineDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.TeamsForLineDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.factory.MesEnclosureProductionLineDTOParam;
import com.hzchum.scim.mes.enclosure.core.api.service.factory.MesEnclosureProductionLineService;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.groups.post.GroupsTeamSaveVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.mesFactory.productionLine.get.ProductionLineListVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.mesFactory.productionLine.post.ProductionLineSaveVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.mesFactory.productionLine.put.ProductionLineUpdateStatusVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.mesFactory.productionLine.put.ProductionLineUpdateVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.voUtils.IdsVoRequest;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES生产线-围护")
@RestController
@RequestMapping("/api/mes/enclosure/productionLine")
public class MesEnclosureProductionLineController {
   private static final Logger log = LoggerFactory.getLogger(MesEnclosureProductionLineController.class);
   @Autowired
   private MesEnclosureProductionLineService mesEnclosureProductionLineService;
   @Autowired
   private MesEnclosureProductionLineBiz productionLineBiz;

   @ApiOperation("获取生产线列表(围护)")
   @GetMapping
   @PreAuthorize("@permission.check('enclosure_productionLine:get')")
   public ResultVO<ListVO<MesEnclosureProductionLineDTO>> productionLineList(ProductionLineListVORequest voRequest) {
      log.info("API 调用 ：获取生产线列表(围护)");
      return ResultBuilder.success(new ListVO<>(this.productionLineBiz.listByCondition(BeanUtil.copy(voRequest, MesEnclosureProductionLineDTOParam.class))));
   }

   @ApiOperation("分页获取生产线分页列表(围护)")
   @GetMapping("/page")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "voRequest", value = "请求类", dataTypeClass = ProductionLineListVORequest.class, paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10", dataType = "int", required = true)
      }
   )
   public ResultVO<PageVO<MesEnclosureProductionLineDTO>> productionLinePage(
      ProductionLineListVORequest voRequest,
      @RequestParam(name = "sort", required = false) String sort,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize
   ) {
      log.info("API 调用 ：分页获取生产线分页列表(围护)");
      return ResultBuilder.success(
         this.productionLineBiz.productionLinePage(BeanUtil.copy(voRequest, MesEnclosureProductionLineDTOParam.class), sort, pageNumber, pageSize)
      );
   }

   @ApiOperation("新增生产线(围护)")
   @PostMapping
   @PreAuthorize("@permission.check('enclosure_productionLine:add')")
   public ResultVO<Boolean> productionLineSave(@RequestBody @Valid ProductionLineSaveVORequest saveVORequest, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：新增生产线(围护)");
      return ResultBuilder.success(
         this.productionLineBiz
            .saveProductionLine(BeanUtil.copy(saveVORequest, MesEnclosureProductionLineDTOParam.class).setUserId(UserUtil.getCurrentUserId()))
      );
   }

   @ApiOperation("修改生产线(围护)")
   @PutMapping
   @PreAuthorize("@permission.check('enclosure_productionLine:edit')")
   public ResultVO<Boolean> productionLineUpdate(@RequestBody ProductionLineUpdateVORequest request, BindingResult result) {
      log.info("API 调用 ：修改生产线(围护)");
      return ResultBuilder.success(this.productionLineBiz.update(BeanUtil.copy(request, MesEnclosureProductionLineDTOParam.class)));
   }

   @ApiOperation("删除生产线(围护)")
   @DeleteMapping
   @PreAuthorize("@permission.check('enclosure_productionLine:del')")
   public ResultVO<Boolean> productionLineDelete(@RequestBody IdsVoRequest voRequest) {
      log.info("API 调用 ：删除生产线(围护)");
      return ResultBuilder.success(this.productionLineBiz.removeByIds(voRequest.getIds()));
   }

   @ApiOperation("修改生产线禁用状态(围护)")
   @PutMapping("/changeState")
   @PreAuthorize("@permission.check('enclosure_productionLine:editStatus')")
   public ResultVO<Boolean> updateProductionLineState(@RequestBody ProductionLineUpdateStatusVORequest voRequest) {
      log.info("API 调用 ：修改生产线禁用状态(围护)");
      return ResultBuilder.success(
         this.productionLineBiz
            .productionLineUpdateState(BeanUtil.copy(voRequest, MesEnclosureProductionLineDTOParam.class).setUserId(UserUtil.getCurrentUserId()))
      );
   }

   @ApiOperation("获取生产线名称列表(围护)")
   @GetMapping("/name")
   public ResultVO productionLineByNameList(ProductionLineListVORequest voRequest) {
      log.info("API 调用 ：获取生产线名称列表");
      return ResultBuilder.success(this.productionLineBiz.productionLineByNameList(BeanUtil.copy(voRequest, MesEnclosureProductionLineDTOParam.class)));
   }

   @ApiOperation("获取生产线下班组(生产+质检)信息-(围护)")
   @GetMapping("/teams")
   @PreAuthorize("@permission.check('enclosure_productionLine_group:get')")
   public ResultVO<TeamsForLineDTO> getTeamsByLine(Long id) {
      log.info("API 调用 ：获取生产线下班组(生产+质检)信息-(围护)");
      return ResultBuilder.success(this.productionLineBiz.getTeamsByLine(id));
   }

   @ApiOperation("批量添加生产班组信息(围护)")
   @PostMapping("/team")
   @PreAuthorize("@permission.check('enclosure_productionLine_group:edit')")
   public ResultVO saveProductionLineTeam(@RequestBody GroupsTeamSaveVORequest voRequest) {
      log.info("API 调用 ：批量添加生产班组信息(围护)");
      return ResultBuilder.success(this.productionLineBiz.saveTeamLink(voRequest.getId(), voRequest.getTeamIds()));
   }

   @ApiOperation("批量添加质检班组信息(围护)")
   @PostMapping("/inspection_team")
   public ResultVO saveProductionLineInspectionTeam(@RequestBody GroupsTeamSaveVORequest voRequest) {
      log.info("API 调用 ：批量添加质检班组信息(围护)");
      return ResultBuilder.success(this.productionLineBiz.saveInspectTeam(voRequest.getId(), voRequest.getTeamIds()));
   }
}
