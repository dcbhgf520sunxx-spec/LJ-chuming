package com.hzchum.scim.rest.controller.mes.enclosure.factory;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.enclosure.core.api.biz.factory.MesEnclosureInspectionTeamBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.MesEnclosureInspectionTeamDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.factory.MesEnclosureInspectionTeamDTOParam;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.factory.MesEnclosureInspectionTeamUserLinkDTOParam;
import com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.mesFactory.inspectionTeam.get.InspectionTeamListVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.mesFactory.inspectionTeam.post.InspectionTeamSaveVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.mesFactory.inspectionTeam.put.InspectionTeamUpdateVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.voUtils.IdsVoRequest;
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

@Api(tags = "MES质检班组-围护")
@RestController
@RequestMapping("/api/mes/enclosure/inspectionTeam")
public class MesEnclosureInspectionTeamController {
   private static final Logger log = LoggerFactory.getLogger(MesEnclosureInspectionTeamController.class);
   @Autowired
   private MesEnclosureInspectionTeamBiz inspectionTeamBiz;

   @ApiOperation("获取质检班组列表(围护)")
   @GetMapping
   public ResultVO<ListVO<MesEnclosureInspectionTeamDTO>> inspectionTeamList(InspectionTeamListVORequest request) {
      log.info("API 调用 ：获取质检班组列表(围护)");
      return ResultBuilder.success(new ListVO<>(this.inspectionTeamBiz.listByCondition(BeanUtil.copy(request, MesEnclosureInspectionTeamDTOParam.class))));
   }

   @ApiOperation("获取质检班组(围护)")
   @GetMapping("/{id}")
   @ApiImplicitParams(@ApiImplicitParam(name = "id", value = "id", dataType = "Long", paramType = "query", required = true))
   public ResultVO<MesEnclosureInspectionTeamDTO> inspectionTeamById(@PathVariable Long id) {
      log.info("API 调用 ：获取质检班组(围护)");
      return ResultBuilder.success(this.inspectionTeamBiz.inspectionTeamById(id));
   }

   @ApiOperation("获取质检班组列表-分页(围护)")
   @GetMapping("/page")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "request", value = "voRequest", dataTypeClass = InspectionTeamListVORequest.class, paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "Integer", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10", dataType = "Integer", required = true)
      }
   )
   public ResultVO<PageVO<MesEnclosureInspectionTeamDTO>> inspectionTeamPage(
      InspectionTeamListVORequest request,
      @RequestParam(name = "sort", required = false) String sort,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize
   ) {
      log.info("API 调用 ：获取质检班组列表-分页(围护)");
      return ResultBuilder.success(
         this.inspectionTeamBiz.inspectionTeamPage(BeanUtil.copy(request, MesEnclosureInspectionTeamDTOParam.class), sort, pageNumber, pageSize)
      );
   }

   @ApiOperation("新增质检班组(围护)")
   @PostMapping
   public ResultVO<Boolean> inspectionTeamSave(@RequestBody @Valid InspectionTeamSaveVORequest request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
      }

      Preconditions.checkArgument(request.getUserLinks().size() != 0, "添加失败，未填写质检班组人员");
      log.info("API 调用 ：新增质检班组(围护)");
      return ResultBuilder.success(this.inspectionTeamBiz.saveTeam(BeanUtil.copy(request, MesEnclosureInspectionTeamDTOParam.class)));
   }

   @ApiOperation("修改质检班组(围护)")
   @PutMapping
   public ResultVO<Boolean> inspectionTeamUpdate(@RequestBody @Valid InspectionTeamUpdateVORequest request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
      }

      log.info("API 调用 ：修改质检班组(围护)");
      Preconditions.checkArgument(request.getId() != null, "id不能为空");
      MesEnclosureInspectionTeamDTOParam dtoParam = BeanUtil.copy(request, MesEnclosureInspectionTeamDTOParam.class);
      dtoParam.setUserLinks(
         request.getUserLinks().stream().map(e -> BeanUtil.copy(e, MesEnclosureInspectionTeamUserLinkDTOParam.class)).collect(Collectors.toList())
      );
      return ResultBuilder.success(this.inspectionTeamBiz.updateTeam(dtoParam.setUserId(UserUtil.getCurrentUserId())));
   }

   @ApiOperation("删除质检班组(围护)")
   @DeleteMapping
   public ResultVO<Boolean> inspectionTeamDelete(@RequestBody IdsVoRequest request) {
      log.info("API 调用 ：删除质检班组(围护)");
      return ResultBuilder.success(this.inspectionTeamBiz.deleteTeamByIds(request.getIds()));
   }
}
