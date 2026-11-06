package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.SysCostingConfig;
import com.hzchum.scim.system.core.api.service.SysCostingConfigService;
import com.hzchum.scim.system.core.mapper.SysCostingConfigMapper;
import org.springframework.stereotype.Service;

@Service
public class SysCostingConfigServiceImpl extends ServiceImpl<SysCostingConfigMapper, SysCostingConfig> implements SysCostingConfigService {
   @Override
   public SysCostingConfig getCostingConfig() {
      return this.baseMapper.findCostingConfig();
   }
}
