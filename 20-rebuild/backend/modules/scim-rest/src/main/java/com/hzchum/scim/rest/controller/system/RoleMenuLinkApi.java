package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.system.core.api.common.Result;
import com.hzchum.scim.system.core.api.common.ResultGenerator;
import com.hzchum.scim.system.core.api.pojo.request.RoleMenuUpdateRequestVO;
import com.hzchum.scim.system.core.api.service.RoleMenuLinkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "系统管理-角色菜单关联")
@RestController
@RequestMapping("/api/role/menu")
public class RoleMenuLinkApi {
   private static final Logger log = LoggerFactory.getLogger(RoleMenuLinkApi.class);
   private final RoleMenuLinkService roleMenuLinkService;

   @ApiOperation(value = "获得菜单树", notes = "获取菜单树")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "roleId", value = "角色id", paramType = "query"),
            @ApiImplicitParam(name = "category", value = "菜单种类 0：PC，1：APP", paramType = "query")
      }
   )
   @GetMapping("/tree")
   public Result getOwnMenuTree(@RequestParam Long roleId, @RequestParam Integer category, @RequestParam(required = false) Integer systemEnum) {
      log.info("API 调用 ： 获取某个角色下权限列表");
      return ResultGenerator.genSuccessResult(this.roleMenuLinkService.getOwnMenuTree(roleId, category, systemEnum));
   }

   @ApiOperation(value = "角色赋权", notes = "根据角色唯一标识为该角色赋予一个或多个权限")
   @PutMapping("")
   @PreAuthorize("@permission.check('role:edit')")
   @SignerCheck(boolMethodAndClassName = true, message = "正在添加角色权限中,请稍后刷新重试!")
   public Result updateLinks(@RequestBody RoleMenuUpdateRequestVO requestVO) {
      log.info("API 调用 ：为某个角色赋予一个或多个权限");
      return ResultGenerator.genSuccessResult(this.roleMenuLinkService.updateLinks(requestVO.getId(), requestVO.getMenus()));
   }

   public RoleMenuLinkApi(final RoleMenuLinkService roleMenuLinkService) {
      this.roleMenuLinkService = roleMenuLinkService;
   }
}
