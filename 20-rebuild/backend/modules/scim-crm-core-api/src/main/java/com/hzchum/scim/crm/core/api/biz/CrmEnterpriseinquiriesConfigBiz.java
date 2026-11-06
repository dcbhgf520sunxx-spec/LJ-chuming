package com.hzchum.scim.crm.core.api.biz;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmEnterpriseinquiriesConfig;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmEnterpriseinquiriesConfigUpdateParam;

public interface CrmEnterpriseinquiriesConfigBiz extends IBiz<CrmEnterpriseinquiriesConfig> {
   Boolean getEnterpriseinquiriesConfig();

   Boolean updateEnterpriseinquiriesConfig(CrmEnterpriseinquiriesConfigUpdateParam crmEnterpriseinquiriesConfigUpdateParam);
}
