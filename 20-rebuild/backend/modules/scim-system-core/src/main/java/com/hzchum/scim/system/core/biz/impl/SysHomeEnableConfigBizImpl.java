package com.hzchum.scim.system.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.system.core.api.biz.SysHomeEnableConfigBiz;
import com.hzchum.scim.system.core.api.pojo._doModel.system.SysHomeEnableConfig;
import com.hzchum.scim.system.core.api.service.SysHomeEnableConfigService;
import com.hzchum.scim.system.core.mapper.SysHomeEnableConfigMapper;
import org.springframework.stereotype.Service;

@Service
public class SysHomeEnableConfigBizImpl
   extends IBizImpl<SysHomeEnableConfigService, SysHomeEnableConfigMapper, SysHomeEnableConfig>
   implements SysHomeEnableConfigBiz {
}
