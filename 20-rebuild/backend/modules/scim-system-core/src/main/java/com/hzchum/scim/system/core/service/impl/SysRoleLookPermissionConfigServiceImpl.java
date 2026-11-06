package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.SysRoleLookPermissionConfig;
import com.hzchum.scim.system.core.api.service.SysRoleLookPermissionConfigService;
import com.hzchum.scim.system.core.mapper.SysRoleLookPermissionConfigMapper;
import org.springframework.stereotype.Service;

@Service
public class SysRoleLookPermissionConfigServiceImpl
   extends ServiceImpl<SysRoleLookPermissionConfigMapper, SysRoleLookPermissionConfig>
   implements SysRoleLookPermissionConfigService {
}
