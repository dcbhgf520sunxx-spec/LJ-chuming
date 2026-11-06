package com.hzchum.scim.system.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.system.core.api.biz.MesSafetyClassConfigBiz;
import com.hzchum.scim.system.core.api.pojo._do.MesSafetyClassConfig;
import com.hzchum.scim.system.core.api.service.MesSafetyClassConfigService;
import com.hzchum.scim.system.core.mapper.MesSafetyClassConfigMapper;
import org.springframework.stereotype.Service;

@Service
public class MesSafetyClassConfigBizImpl
   extends IBizImpl<MesSafetyClassConfigService, MesSafetyClassConfigMapper, MesSafetyClassConfig>
   implements MesSafetyClassConfigBiz {
}
