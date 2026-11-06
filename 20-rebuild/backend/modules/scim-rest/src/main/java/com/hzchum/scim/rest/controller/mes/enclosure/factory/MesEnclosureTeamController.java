package com.hzchum.scim.rest.controller.mes.enclosure.factory;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.enclosure.core.api.biz.factory.MesEnclosureTeamBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.MesEnclosureTeamDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.factory.MesEnclosureTeamDTOParam;
import com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.mesFactory.team.get.TeamListVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.mesFactory.team.post.TeamSaveVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.mesFactory.team.put.TeamUpdateVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.voUtils.IdsVoRequest;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.Objects;
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

@Api(tags = "MES班组-围护")
@RestController
@RequestMapping("/api/mes/enclosure/team")
public class MesEnclosureTeamController {
   private static final Logger log = LoggerFactory.getLogger(MesEnclosureTeamController.class);
   @Autowired
   private MesEnclosureTeamBiz teamBiz;

   @ApiOperation("获取班组列表")
   @GetMapping
   @PreAuthorize("@permission.check('enclosure_productionLine_team:get')")
   public ResultVO<ListVO<MesEnclosureTeamDTO>> teamList(TeamListVORequest vORequest) {
      log.info("API 调用 ：获取班组列表");
      return ResultBuilder.success(new ListVO<>(this.teamBiz.listByCondition(BeanUtil.copy(vORequest, MesEnclosureTeamDTOParam.class))));
   }

   @ApiOperation("获取班组列表(通用)")
   @GetMapping("common-list")
   public ResultVO<ListVO<MesEnclosureTeamDTO>> teamCommonList(TeamListVORequest vORequest) {
      log.info("API 调用 ：获取班组列表(通用)");
      return ResultBuilder.success(new ListVO<>(this.teamBiz.listByCondition(BeanUtil.copy(vORequest, MesEnclosureTeamDTOParam.class))));
   }

   @ApiOperation("获取班组")
   @GetMapping("/{id}")
   @ApiImplicitParams(@ApiImplicitParam(name = "id", value = "id", dataType = "Long", paramType = "query", required = true))
   public ResultVO<MesEnclosureTeamDTO> teamById(@PathVariable Long id) {
      log.info("API 调用 ：获取班组列表");
      return ResultBuilder.success(this.teamBiz.teamById(id));
   }

   @ApiOperation("分页获取班组列表")
   @GetMapping("/page")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "voRequest", value = "请求实体类", dataTypeClass = TeamListVORequest.class, paramType = "query"),
            @ApiImplicitParam(name = "sort", value = "排序", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1", dataType = "int", required = true),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10", dataType = "int", required = true)
      }
   )
   public ResultVO<PageVO<MesEnclosureTeamDTO>> teamPage(
      TeamListVORequest voRequest,
      @RequestParam(name = "sort", required = false) Long sort,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "50") Integer pageSize
   ) {
      log.info("API 调用 ：获取班组列表");
      return ResultBuilder.success(this.teamBiz.teamPage(BeanUtil.copy(voRequest, MesEnclosureTeamDTOParam.class), sort, pageNumber, pageSize));
   }

   @ApiOperation("新增班组")
   @PostMapping
   @PreAuthorize("@permission.check('enclosure_productionLine_team:add')")
   public ResultVO<Boolean> saveTeam(@RequestBody @Valid TeamSaveVORequest request, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
      }

      Preconditions.checkArgument(request.getUserLinks().size() != 0, "添加失败，未填写班组人员");
      log.info("API 调用 ：新增班组");
      return ResultBuilder.success(this.teamBiz.saveTeam(BeanUtil.copy(request, MesEnclosureTeamDTOParam.class).setUserId(UserUtil.getCurrentUserId())));
   }

   @ApiOperation("修改班组")
   @PutMapping
   @PreAuthorize("@permission.check('enclosure_productionLine_team:edit')")
   public ResultVO<Boolean> teamUpdate(@RequestBody @Valid TeamUpdateVORequest voRequest, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
      }

      log.info("API 调用 ：修改班组");
      return ResultBuilder.success(this.teamBiz.teamUpdate(BeanUtil.copy(voRequest, MesEnclosureTeamDTOParam.class).setUserId(UserUtil.getCurrentUserId())));
   }

   @ApiOperation("删除班组")
   @DeleteMapping
   @PreAuthorize("@permission.check('enclosure_productionLine_team:del')")
   public ResultVO<Boolean> teamDelete(@RequestBody IdsVoRequest voRequest) {
      log.info("API 调用 ：删除班组");
      return ResultBuilder.success(this.teamBiz.deleteTeamByIds(voRequest.getIds()));
   }

   @ApiOperation("根据用户查询所在班组")
   @GetMapping("/user")
   public ResultVO userTeam() {
      log.info("API 调用 ：根据用户查询所在班组");
      return ResultBuilder.success(new ListVO<>(this.teamBiz.useTeam(UserUtil.getCurrentUserId())));
   }
}
