package com.hzchum.scim.crm.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.crm.core.api.biz.CrmTheNumberOfCustomProjectConfigBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmTheNumberOfCustomProjectConfig;
import com.hzchum.scim.crm.core.api.service.CrmTheNumberOfCustomProjectConfigService;
import com.hzchum.scim.crm.core.mapper.CrmTheNumberOfCustomProjectConfigMapper;
import org.springframework.stereotype.Service;

@Service
public class CrmTheNumberOfCustomProjectConfigBizImpl
   extends IBizImpl<CrmTheNumberOfCustomProjectConfigService, CrmTheNumberOfCustomProjectConfigMapper, CrmTheNumberOfCustomProjectConfig>
   implements CrmTheNumberOfCustomProjectConfigBiz {
}
