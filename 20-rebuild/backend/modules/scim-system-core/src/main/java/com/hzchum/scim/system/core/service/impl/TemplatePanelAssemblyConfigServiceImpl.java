package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.TemplatePanelAssemblyConfig;
import com.hzchum.scim.system.core.api.service.TemplatePanelAssemblyConfigService;
import com.hzchum.scim.system.core.mapper.TemplatePanelAssemblyConfigMapper;
import org.springframework.stereotype.Service;

@Service
public class TemplatePanelAssemblyConfigServiceImpl
   extends ServiceImpl<TemplatePanelAssemblyConfigMapper, TemplatePanelAssemblyConfig>
   implements TemplatePanelAssemblyConfigService {
}
