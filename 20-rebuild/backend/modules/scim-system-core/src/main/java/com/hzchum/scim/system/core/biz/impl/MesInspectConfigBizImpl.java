package com.hzchum.scim.system.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.system.core.api.biz.MesInspectConfigBiz;
import com.hzchum.scim.system.core.api.pojo._do.MesInspectConfig;
import com.hzchum.scim.system.core.api.service.MesInspectConfigService;
import com.hzchum.scim.system.core.mapper.MesInspectConfigMapper;
import org.springframework.stereotype.Service;

@Service
public class MesInspectConfigBizImpl extends IBizImpl<MesInspectConfigService, MesInspectConfigMapper, MesInspectConfig> implements MesInspectConfigBiz {
}
