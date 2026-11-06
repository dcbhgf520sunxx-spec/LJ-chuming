package com.hzchum.scim.crm.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.crm.core.api.biz.CrmPersonTemplateConfigBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmPersonTemplateConfig;
import com.hzchum.scim.crm.core.api.service.CrmPersonTemplateConfigService;
import com.hzchum.scim.crm.core.mapper.CrmPersonTemplateConfigMapper;
import org.springframework.stereotype.Service;

@Service
public class CrmPersonTemplateConfigBizImpl
   extends IBizImpl<CrmPersonTemplateConfigService, CrmPersonTemplateConfigMapper, CrmPersonTemplateConfig>
   implements CrmPersonTemplateConfigBiz {
}
