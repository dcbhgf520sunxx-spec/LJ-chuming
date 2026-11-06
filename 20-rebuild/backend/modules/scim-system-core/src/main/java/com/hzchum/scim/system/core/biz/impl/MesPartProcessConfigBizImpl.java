package com.hzchum.scim.system.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.system.core.api.biz.MesPartProcessConfigBiz;
import com.hzchum.scim.system.core.api.pojo._do.MesPartProcessConfig;
import com.hzchum.scim.system.core.api.service.MesPartProcessConfigService;
import com.hzchum.scim.system.core.mapper.MesPartProcessConfigMapper;
import org.springframework.stereotype.Service;

@Service
public class MesPartProcessConfigBizImpl
   extends IBizImpl<MesPartProcessConfigService, MesPartProcessConfigMapper, MesPartProcessConfig>
   implements MesPartProcessConfigBiz {
}
