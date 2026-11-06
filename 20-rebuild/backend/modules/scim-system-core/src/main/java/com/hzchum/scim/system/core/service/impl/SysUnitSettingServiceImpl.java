package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.SysUnitSetting;
import com.hzchum.scim.system.core.api.service.SysUnitSettingService;
import com.hzchum.scim.system.core.mapper.SysUnitSettingMapper;
import org.springframework.stereotype.Service;

@Service
public class SysUnitSettingServiceImpl extends ServiceImpl<SysUnitSettingMapper, SysUnitSetting> implements SysUnitSettingService {
}
