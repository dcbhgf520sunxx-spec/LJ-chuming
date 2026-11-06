package com.hzchum.scim.rest.controller.mes.building.config;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesBuildingNestingTeamDTO;
import com.hzchum.scim.system.core.api.pojo.vo.MesBuildingNestingTeamVO;
import com.hzchum.scim.system.core.api.service.MesBuildingNestingTeamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mes/building/nestingTeam")
@Api(tags = "套料团队码")
public class MesBuildingNestingTeamController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingNestingTeamController.class);
   @Autowired
   private MesBuildingNestingTeamService mesBuildingNestingTeamService;

   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "条数", paramType = "query", defaultValue = "20")
      }
   )
   @GetMapping("/page")
   @PreAuthorize("@permission.check('nesting_group_config:get')")
   @ApiOperation("套料团队码分页查询")
   public ResultVO page(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
      PageVO<MesBuildingNestingTeamDTO> page = this.mesBuildingNestingTeamService.page(pageNumber, pageSize);
      return ResultBuilder.success(page);
   }

   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "条数", paramType = "query", defaultValue = "20")
      }
   )
   @GetMapping("/all")
   @ApiOperation("套料团队码分页查询")
   public ResultVO allMesBuildingNestingTeam(@RequestParam(name = "workshopId") Long workshopId) {
      return ResultBuilder.success(this.mesBuildingNestingTeamService.allMesBuildingNestingTeam(workshopId));
   }

   @GetMapping("/{id}")
   @PreAuthorize("@permission.check('nesting_group_config:get')")
   @ApiOperation("信息")
   public ResultVO getById(@RequestParam(name = "id") Long id) {
      return ResultBuilder.success(this.mesBuildingNestingTeamService.getByIdMesBuildingNestingTeam(id));
   }

   @PostMapping("/save")
   @PreAuthorize("@permission.check('nesting_group_config:add')")
   @ApiOperation("保存")
   public ResultVO save(@RequestBody MesBuildingNestingTeamVO vo) {
      this.mesBuildingNestingTeamService.save(vo);
      return ResultBuilder.success("保存成功");
   }

   @PutMapping("/update")
   @PreAuthorize("@permission.check('nesting_group_config:edit')")
   @ApiOperation("修改")
   public ResultVO update(@RequestBody @Valid MesBuildingNestingTeamVO vo) {
      this.mesBuildingNestingTeamService.update(vo);
      return ResultBuilder.success("修改成功");
   }

   @DeleteMapping("/delete")
   @PreAuthorize("@permission.check('nesting_group_config:del')")
   @ApiOperation("删除")
   public ResultVO delete(@RequestBody @Valid MesBuildingNestingTeamVO vo) {
      this.mesBuildingNestingTeamService.delete(vo);
      return ResultBuilder.success("删除成功");
   }

   public MesBuildingNestingTeamController(final MesBuildingNestingTeamService mesBuildingNestingTeamService) {
      this.mesBuildingNestingTeamService = mesBuildingNestingTeamService;
   }
}
