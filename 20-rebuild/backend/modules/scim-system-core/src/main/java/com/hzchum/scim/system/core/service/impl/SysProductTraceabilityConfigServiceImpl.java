package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.SysProductTraceabilityConfig;
import com.hzchum.scim.system.core.api.service.SysProductTraceabilityConfigService;
import com.hzchum.scim.system.core.mapper.SysProductTraceabilityConfigMapper;
import org.springframework.stereotype.Service;

@Service
public class SysProductTraceabilityConfigServiceImpl
   extends ServiceImpl<SysProductTraceabilityConfigMapper, SysProductTraceabilityConfig>
   implements SysProductTraceabilityConfigService {
}
