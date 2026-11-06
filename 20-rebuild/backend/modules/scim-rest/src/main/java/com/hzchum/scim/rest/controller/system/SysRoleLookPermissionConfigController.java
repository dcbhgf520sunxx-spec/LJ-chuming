package com.hzchum.scim.rest.controller.system;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.rest.pojo.vo.system.SysRoleLookPermissionConfigUpdateVO;
import com.hzchum.scim.system.core.api.biz.SysRoleLookPermissionConfigBiz;
import com.hzchum.scim.system.core.api.pojo.param.SysRoleLookPermissionConfigUpdateParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "配置管理-角色查看权限配置")
@RestController
@RequestMapping("/api/role/look/permission/config")
public class SysRoleLookPermissionConfigController {
   private static final Logger log = LoggerFactory.getLogger(SysRoleLookPermissionConfigController.class);
   @Resource
   private SysRoleLookPermissionConfigBiz sysRoleLookPermissionConfigBiz;

   @ApiOperation("查看当前角色查看权")
   @GetMapping("/get/detail")
   public ResultVO getLookPermissionsByModuleAndRoleId(Integer sysModuleTypeEnum, Long roleId) {
      log.info("API调用:查看当前角色查看权");
      return ResultBuilder.success(this.sysRoleLookPermissionConfigBiz.getLookPermissionsByModuleAndRoleId(sysModuleTypeEnum, roleId));
   }

   @ApiOperation("当前角色修改查看权")
   @PostMapping("/update")
   public ResultVO updateLookPermissionsByModuleAndRoleId(@RequestBody SysRoleLookPermissionConfigUpdateVO vo) {
      log.info("API调用:当前角色修改查看权");
      return ResultBuilder.success(
         this.sysRoleLookPermissionConfigBiz.updateLookPermissionsByModuleAndRoleId(BeanUtil.copy(vo, SysRoleLookPermissionConfigUpdateParam.class))
      );
   }

   public SysRoleLookPermissionConfigController(final SysRoleLookPermissionConfigBiz sysRoleLookPermissionConfigBiz) {
      this.sysRoleLookPermissionConfigBiz = sysRoleLookPermissionConfigBiz;
   }
}
