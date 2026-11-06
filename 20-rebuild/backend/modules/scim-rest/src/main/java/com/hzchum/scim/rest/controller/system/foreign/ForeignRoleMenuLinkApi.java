package com.hzchum.scim.rest.controller.system.foreign;

import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.common.core.api.biz.CommonTokenBiz;
import com.hzchum.scim.system.core.api.common.Result;
import com.hzchum.scim.system.core.api.common.ResultGenerator;
import com.hzchum.scim.system.core.api.pojo.request.foreign.ForeignRoleMenuUpdateRequestVO;
import com.hzchum.scim.system.core.api.service.RoleMenuLinkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "系统管理-角色菜单关联(物联调用)")
@RestController
@RequestMapping("/api/foreign/role/menu")
public class ForeignRoleMenuLinkApi {
   private static final Logger log = LoggerFactory.getLogger(ForeignRoleMenuLinkApi.class);
   private final RoleMenuLinkService roleMenuLinkService;
   private final CommonTokenBiz commonTokenBiz;

   @ApiOperation(value = "角色赋权", notes = "为多个角色赋予多个权限(物联调用)")
   @PutMapping("")
   @SignerCheck(boolMethodAndClassName = true, message = "正在添加角色权限中,请稍后刷新重试!")
   public Result updateLinks(@RequestBody @Valid ForeignRoleMenuUpdateRequestVO requestVO) {
      this.commonTokenBiz.checkToken(requestVO.getToken());
      log.info("API 调用 ：为多个角色赋予多个权限(物联调用)");
      return ResultGenerator.genSuccessResult(this.roleMenuLinkService.foreignUpdateLinks(requestVO.getPermissions(), requestVO.getRoleIds()));
   }

   @ApiOperation(value = "删除角色赋权", notes = "删除角色赋权(物联调用)")
   @DeleteMapping("")
   public Result removeLinks(@RequestBody @Valid ForeignRoleMenuUpdateRequestVO requestVO) {
      this.commonTokenBiz.checkToken(requestVO.getToken());
      log.info("API 调用 ：删除角色赋权(物联调用)");
      return ResultGenerator.genSuccessResult(this.roleMenuLinkService.removeLinks(requestVO.getPermissions(), requestVO.getRoleIds()));
   }

   public ForeignRoleMenuLinkApi(final RoleMenuLinkService roleMenuLinkService, final CommonTokenBiz commonTokenBiz) {
      this.roleMenuLinkService = roleMenuLinkService;
      this.commonTokenBiz = commonTokenBiz;
   }
}
