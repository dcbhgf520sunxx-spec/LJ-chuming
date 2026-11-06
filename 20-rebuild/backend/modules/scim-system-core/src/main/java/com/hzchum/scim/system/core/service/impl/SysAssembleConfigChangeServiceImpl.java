package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleConfigChange;
import com.hzchum.scim.system.core.api.service.SysAssembleConfigChangeService;
import com.hzchum.scim.system.core.mapper.SysAssembleConfigChangeMapper;
import org.springframework.stereotype.Service;

@Service
public class SysAssembleConfigChangeServiceImpl
   extends ServiceImpl<SysAssembleConfigChangeMapper, SysAssembleConfigChange>
   implements SysAssembleConfigChangeService {
}
