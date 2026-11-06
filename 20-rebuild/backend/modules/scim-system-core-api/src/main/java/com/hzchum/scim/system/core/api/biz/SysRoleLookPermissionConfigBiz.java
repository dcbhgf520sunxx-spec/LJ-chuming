package com.hzchum.scim.system.core.api.biz;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.system.core.api.pojo._do.SysRoleLookPermissionConfig;
import com.hzchum.scim.system.core.api.pojo.dto.SysRoleLookPermissionConfigDTO;
import com.hzchum.scim.system.core.api.pojo.param.SysRoleLookPermissionConfigUpdateParam;
import java.util.Set;

public interface SysRoleLookPermissionConfigBiz extends IBiz<SysRoleLookPermissionConfig> {
   Set<Long> getCrmCanLookInfoDeptIdsByModuleAndUserId(Integer sysModuleTypeEnum, Long userId);

   Boolean updateLookPermissionsByModuleAndRoleId(SysRoleLookPermissionConfigUpdateParam copy);

   SysRoleLookPermissionConfigDTO getLookPermissionsByModuleAndRoleId(Integer sysModuleTypeEnum, Long roleId);
}
