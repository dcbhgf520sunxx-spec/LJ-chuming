package com.hzchum.scim.system.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.system.core.api.biz.MesQualityClassConfigBiz;
import com.hzchum.scim.system.core.api.pojo._do.MesQualityClassConfig;
import com.hzchum.scim.system.core.api.service.MesQualityClassConfigService;
import com.hzchum.scim.system.core.mapper.MesQualityClassConfigMapper;
import org.springframework.stereotype.Service;

@Service
public class MesQualityClassConfigBizImpl
   extends IBizImpl<MesQualityClassConfigService, MesQualityClassConfigMapper, MesQualityClassConfig>
   implements MesQualityClassConfigBiz {
}
