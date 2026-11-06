package com.hzchum.scim.system.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.system.core.api.biz.SysKitWmsCommonConfigBiz;
import com.hzchum.scim.system.core.api.pojo._do.SysKitWmsCommonConfig;
import com.hzchum.scim.system.core.api.service.SysKitWmsCommonConfigService;
import com.hzchum.scim.system.core.mapper.SysKitWmsCommonConfigMapper;
import org.springframework.stereotype.Service;

@Service
public class SysKitWmsCommonConfigBizImpl
   extends IBizImpl<SysKitWmsCommonConfigService, SysKitWmsCommonConfigMapper, SysKitWmsCommonConfig>
   implements SysKitWmsCommonConfigBiz {
}
