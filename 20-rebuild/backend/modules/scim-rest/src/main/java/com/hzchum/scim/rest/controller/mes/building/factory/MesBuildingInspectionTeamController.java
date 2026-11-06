package com.hzchum.scim.rest.controller.mes.building.factory;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingInspectionTeamBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingInspectionTeamDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingInspectionTeamDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingInspectionTeamUserLinkDTOParam;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.inspectionTeam.get.InspectionTeamListVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.inspectionTeam.post.InspectionTeamSaveVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.inspectionTeam.put.InspectionTeamUpdateVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.voUtils.IdsVoRequest;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES质检班组")
@RestController
@RequestMapping("/api/mes/building/inspectionTeam")
public class MesBuildingInspectionTeamController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingInspectionTeamController.class);
   @Autowired
   private MesBuildingInspectionTeamBiz inspectionTeamBiz;

   @ApiOperation("获取质检班组列表")
   @GetMapping
   @PreAuthorize("@permission.check('productionLine_inspect:get')")
   public ResultVO<ListVO<MesBuildingInspectionTeamDTO>> inspectionTeamList(InspectionTeamListVORequest request) {
      log.info("API 调用 ：获取质检班组列表");
      return ResultBuilder.success(new ListVO<>(this.inspectionTeamBiz.listByCondition(BeanUtil.copy(request, MesBuildingInspectionTeamDTOParam.class))));
   }

   @ApiOperation("获取质检班组")
   @GetMapping("/{id}")
   @ApiImplicitParams(@ApiImplicitParam(name = "id", value = "id", dataType = "Long", paramType = "query", required = true))
   @PreAuthorize("@permission.check('productionLine_inspect:get')")
   public ResultVO<MesBuildingInspectionTeamDTO> inspectionTeamById(@PathVariable Long id) {
      log.info("API 调用 ：获取质检班组");
      return ResultBuilder.success(this.inspectionTeamBiz.inspectionTeamById(id));
   }

   @ApiOperation("获取质检班组列表-分页")
   @GetMapping("/page")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "request", value = "voRequest", dataTypeClass = InspectionTeamListVORequest.class, paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10", dataType = "Integer", required = true)
      }
   )
   @PreAuthorize("@permission.check('productionLine_inspect:get')")
   public ResultVO<PageVO<MesBuildingInspectionTeamDTO>> inspectionTeamPage(
      InspectionTeamListVORequest request,
      @RequestParam(name = "sort", required = false) String sort,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize
   ) {
      log.info("API 调用 ：获取质检班组列表-分页");
      return ResultBuilder.success(
         this.inspectionTeamBiz.inspectionTeamPage(BeanUtil.copy(request, MesBuildingInspectionTeamDTOParam.class), sort, pageNumber, pageSize)
      );
   }

   @ApiOperation("新增质检班组")
   @PostMapping
   @PreAuthorize("@permission.check('productionLine_inspect:add')")
   public ResultVO<Boolean> inspectionTeamSave(@RequestBody @Valid InspectionTeamSaveVORequest request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
      }

      Preconditions.checkArgument(request.getUserLinks().size() != 0, "添加失败，未填写质检班组人员");
      log.info("API 调用 ：新增质检班组");
      return ResultBuilder.success(this.inspectionTeamBiz.saveTeam(BeanUtil.copy(request, MesBuildingInspectionTeamDTOParam.class)));
   }

   @ApiOperation("修改质检班组")
   @PutMapping
   @PreAuthorize("@permission.check('productionLine_inspect:edit')")
   public ResultVO<Boolean> inspectionTeamUpdate(@RequestBody @Valid InspectionTeamUpdateVORequest request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
      }

      log.info("API 调用 ：修改质检班组");
      Preconditions.checkArgument(request.getId() != null, "id不能为空");
      MesBuildingInspectionTeamDTOParam dtoParam = BeanUtil.copy(request, MesBuildingInspectionTeamDTOParam.class);
      dtoParam.setUserLinks(
         request.getUserLinks().stream().map(e -> BeanUtil.copy(e, MesBuildingInspectionTeamUserLinkDTOParam.class)).collect(Collectors.toList())
      );
      return ResultBuilder.success(this.inspectionTeamBiz.updateTeam(dtoParam.setUserId(UserUtil.getCurrentUserId())));
   }

   @ApiOperation("删除质检班组")
   @DeleteMapping
   @PreAuthorize("@permission.check('productionLine_inspect:del')")
   public ResultVO<Boolean> inspectionTeamDelete(@RequestBody IdsVoRequest request) {
      log.info("API 调用 ：删除质检班组");
      return ResultBuilder.success(this.inspectionTeamBiz.deleteTeamByIds(request.getIds()));
   }
}
