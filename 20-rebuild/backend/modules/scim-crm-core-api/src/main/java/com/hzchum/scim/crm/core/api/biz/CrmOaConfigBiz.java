package com.hzchum.scim.crm.core.api.biz;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmOaConfig;

public interface CrmOaConfigBiz extends IBiz<CrmOaConfig> {
   CrmOaConfig getOaConfig();

   Boolean updateOaConfig(Boolean enabled);
}
