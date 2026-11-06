package com.hzchum.scim.crm.core.biz.impl;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.crm.core.api.biz.CrmBusinessLicenseQueryLogBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmBusinessLicenseQueryLog;
import com.hzchum.scim.crm.core.api.service.CrmBusinessLicenseQueryLogService;
import com.hzchum.scim.crm.core.mapper.CrmBusinessLicenseQueryLogMapper;
import org.springframework.stereotype.Service;

@Service
public class CrmBusinessLicenseQueryLogBizImpl
   extends IBizImpl<CrmBusinessLicenseQueryLogService, CrmBusinessLicenseQueryLogMapper, CrmBusinessLicenseQueryLog>
   implements CrmBusinessLicenseQueryLogBiz {
}
