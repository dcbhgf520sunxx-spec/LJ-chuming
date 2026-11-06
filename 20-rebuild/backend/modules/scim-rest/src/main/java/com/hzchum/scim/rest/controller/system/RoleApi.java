package com.hzchum.scim.rest.controller.system;

import com.hzchum.scim.system.core.api.biz.RoleBiz;
import com.hzchum.scim.system.core.api.common.Result;
import com.hzchum.scim.system.core.api.common.ResultGenerator;
import com.hzchum.scim.system.core.api.pojo.dto.RoleAndUserUpdateDTO;
import com.hzchum.scim.system.core.api.pojo.dto.RoleSaveVO;
import com.hzchum.scim.system.core.api.pojo.dto.RoleUpdateVO;
import com.hzchum.scim.system.core.api.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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

@Api(tags = "系统管理-角色")
@RestController
@RequestMapping("/api/role")
public class RoleApi {
   private static final Logger log = LoggerFactory.getLogger(RoleApi.class);
   private final RoleService roleService;
   private final RoleBiz roleBiz;

   @ApiOperation(value = "角色信息", notes = "根据角色唯一标识获取角色详情")
   @ApiImplicitParam(name = "id", value = "角色id", paramType = "path")
   @GetMapping("/{id}")
   public Result getRole(@PathVariable Long id) {
      log.info("API 调用 ：根据id获取角色详情");
      return ResultGenerator.genSuccessResult(this.roleBiz.getRole(id));
   }

   @ApiOperation(value = "角色列表", notes = "分页获取角色列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "name", value = "角色名称", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", paramType = "query", defaultValue = "10")
      }
   )
   @GetMapping("")
   @PreAuthorize("@permission.check('role:get')")
   public Result pageRole(
      @RequestParam(required = false) String name, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ： 分页获取所有的角色");
      return ResultGenerator.genSuccessResult(this.roleBiz.pageRole(name, pageNumber, pageSize));
   }

   @ApiOperation(value = "角色列表", notes = "获取角色列表")
   @ApiImplicitParam(name = "name", value = "角色名称", paramType = "query")
   @GetMapping("/all")
   public Result listRole(@RequestParam(required = false) String name) {
      log.info("API 调用 ： 获取角色列表");
      return ResultGenerator.genSuccessResult(this.roleService.listRole(name));
   }

   @ApiOperation(value = "新增角色", notes = "新增角色")
   @PostMapping("")
   @PreAuthorize("@permission.check('role:add')")
   public Result saveRole(@Valid @RequestBody RoleSaveVO saveVO) {
      log.info("API 调用 ：保存一个新的角色");
      return ResultGenerator.genSuccessResult(this.roleService.saveRole(saveVO));
   }

   @ApiOperation(value = "角色更新", notes = "更新角色的信息")
   @PutMapping("")
   @PreAuthorize("@permission.check('role:edit')")
   public Result updateRole(@Valid @RequestBody RoleUpdateVO requestVO) {
      log.info("API 调用 ： 更新角色的信息");
      return ResultGenerator.genSuccessResult(this.roleService.updateRole(requestVO));
   }

   @ApiOperation(value = "删除角色", notes = "根据角色id集合批量删除角色信息")
   @DeleteMapping("")
   @PreAuthorize("@permission.check('role:del')")
   public Result deleteRoles(@RequestBody List<Long> ids) {
      log.info("API 调用 ：根据角色id集合批量删除角色信息");
      return ResultGenerator.genSuccessResult(this.roleBiz.deleteRoles(ids));
   }

   @ApiOperation(value = "根据角色获取用户与部门列表", notes = "根据角色获取用户与部门列表")
   @ApiImplicitParam(name = "roleId", value = "角色id", paramType = "query")
   @GetMapping("/user")
   public Result listUserByRole(@RequestParam Long roleId) {
      log.info("API 调用 ： 根据角色获取用户与部门列表");
      return ResultGenerator.genSuccessResult(this.roleBiz.listUserByRole(roleId));
   }

   @ApiOperation(value = "更新角色下的用户信息", notes = "更新角色下的用户信息")
   @PutMapping("/update/user")
   @PreAuthorize("@permission.check('role:edit')")
   public Result updateRoleAndUser(@Valid @RequestBody RoleAndUserUpdateDTO roleAndUserUpdateDTO) {
      log.info("API 调用 ： 更新角色下的用户信息");
      return ResultGenerator.genSuccessResult(this.roleBiz.updateRoleAndUser(roleAndUserUpdateDTO));
   }

   @ApiOperation(value = "查询角色的人员信息", notes = "查询角色的人员信息")
   @ApiImplicitParam(name = "roleId", value = "角色id", paramType = "query")
   @GetMapping("/query/user")
   public Result queryByRole(@RequestParam Long roleId) {
      log.info("API 调用 ：查询角色的人员信息");
      return ResultGenerator.genSuccessResult(this.roleBiz.getUserByRole(roleId));
   }

   @ApiOperation(value = "下载角色的人员信息", notes = "下载角色的人员信息")
   @GetMapping("/export")
   public void roleExport(HttpServletResponse response) {
      log.info("Api 调用 : 下载角色的人员信息");
      this.roleBiz.roleExport(response);
   }

   public RoleApi(final RoleService roleService, final RoleBiz roleBiz) {
      this.roleService = roleService;
      this.roleBiz = roleBiz;
   }
}
