package com.hzchum.scim.rest.controller.mes.building.factory;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingGroupsBiz;
import com.hzchum.scim.mes.building.core.api.enums.WorkShopTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingGroupsDTOParam;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.groups.get.GroupsVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.groups.get.SchedulingGroupsTreeVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.groups.post.GroupsSaveVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.groups.post.GroupsTeamSaveVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.groups.put.GroupsUpdateVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.voUtils.IdsVoRequest;
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

@Api(tags = "MES生产组")
@RestController
@RequestMapping("/api/mes/building/groups")
public class MesBuildingGroupsController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingGroupsController.class);
   @Autowired
   private MesBuildingGroupsBiz groupsBiz;

   @ApiOperation("获取生产组列表")
   @GetMapping
   @PreAuthorize("@permission.check('productionLine_group:get')")
   public ResultVO listByCondition(GroupsVORequest voRequest) {
      log.info("API 调用 ：获取生产组列表");
      return ResultBuilder.success(new ListVO<>(this.groupsBiz.listByCondition(BeanUtil.copy(voRequest, MesBuildingGroupsDTOParam.class))));
   }

   @ApiOperation("分页获取生产组分页列表")
   @GetMapping("/page")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "voRequest", value = "请求类", dataTypeClass = GroupsVORequest.class, paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10", dataType = "int", required = true)
      }
   )
   @PreAuthorize("@permission.check('productionLine_group:get')")
   public ResultVO pageByCondition(
      GroupsVORequest voRequest,
      @RequestParam(name = "sort", required = false) String sort,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize
   ) {
      log.info("API 调用 ：分页获取生产组分页列表");
      return ResultBuilder.success(this.groupsBiz.pageByCondition(BeanUtil.copy(voRequest, MesBuildingGroupsDTOParam.class), sort, pageNumber, pageSize));
   }

   @ApiOperation("新增生产组")
   @PostMapping
   @PreAuthorize("@permission.check('productionLine_group:add')")
   public ResultVO saveGroups(@RequestBody @Valid GroupsSaveVORequest voRequest, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：新增生产组");
      return ResultBuilder.success(this.groupsBiz.saveGroups(BeanUtil.copy(voRequest, MesBuildingGroupsDTOParam.class)));
   }

   @ApiOperation("修改生产组")
   @PutMapping
   @PreAuthorize("@permission.check('productionLine_group:edit')")
   public ResultVO updateGroups(@RequestBody GroupsUpdateVORequest voRequest, BindingResult result) {
      log.info("API 调用 ：修改生产组");
      return ResultBuilder.success(this.groupsBiz.updateGroups(BeanUtil.copy(voRequest, MesBuildingGroupsDTOParam.class)));
   }

   @ApiOperation("删除生产组")
   @DeleteMapping
   @PreAuthorize("@permission.check('productionLine_group:del')")
   public ResultVO deleteGroups(@RequestBody IdsVoRequest voRequest) {
      log.info("API 调用 ：删除生产组");
      return ResultBuilder.success(this.groupsBiz.removeGroupsByIds(voRequest.getIds()));
   }

   @ApiOperation("批量添加班组信息")
   @PostMapping("/team")
   public ResultVO saveProductionLineTeam(@RequestBody GroupsTeamSaveVORequest voRequest) {
      log.info("API 调用 ：批量添加班组信息");
      return ResultBuilder.success(this.groupsBiz.saveTeam(voRequest.getId(), voRequest.getTeamIds()));
   }

   @ApiOperation("批量添加质检班组信息")
   @PostMapping("/inspection_team")
   public ResultVO saveProductionLineInspectionTeam(@RequestBody GroupsTeamSaveVORequest voRequest) {
      log.info("API 调用 ：批量添加质检班组信息");
      return ResultBuilder.success(this.groupsBiz.saveInspectionTeam(voRequest.getId(), voRequest.getTeamIds()));
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
   public ResultVO getSchedulingGroupsTree(@Validated SchedulingGroupsTreeVORequest voRequest) {
      log.info("API 调用 ：分页获取生产组分页列表");
      return ResultBuilder.success(
         this.groupsBiz.getSchedulingGroupsTree(BeanUtil.copy(voRequest, MesBuildingGroupsDTOParam.class), WorkShopTypeEnum.BUILDING.getType())
      );
   }

   @ApiOperation("获取钻孔可排产生产组树")
   @GetMapping("/drill/tree")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "voRequest", value = "请求类", dataTypeClass = GroupsVORequest.class, paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10", dataType = "int", required = true)
      }
   )
   public ResultVO getDrillGroupsTree(@Validated SchedulingGroupsTreeVORequest voRequest) {
      log.info("API 调用 ：获取钻孔可排产生产组树");
      return ResultBuilder.success(this.groupsBiz.getDrillGroupsTree(BeanUtil.copy(voRequest, MesBuildingGroupsDTOParam.class)));
   }
}
