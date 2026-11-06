package com.hzchum.scim.crm.core.api.biz;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmBusinessLicenseQueryConfig;

public interface CrmBusinessLicenseQueryConfigBiz extends IBiz<CrmBusinessLicenseQueryConfig> {
   Boolean updateBusinessLicenseQueryConfig(Integer times);

   Integer getBusinessLicenseQueryConfig();

   Boolean whetherItIsCappedOrNot();
}
