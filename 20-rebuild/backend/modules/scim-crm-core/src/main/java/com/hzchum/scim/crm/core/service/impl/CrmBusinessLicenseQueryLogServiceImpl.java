package com.hzchum.scim.crm.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.crm.core.api.pojo._do.CrmBusinessLicenseQueryLog;
import com.hzchum.scim.crm.core.api.service.CrmBusinessLicenseQueryLogService;
import com.hzchum.scim.crm.core.mapper.CrmBusinessLicenseQueryLogMapper;
import org.springframework.stereotype.Service;

@Service
public class CrmBusinessLicenseQueryLogServiceImpl
   extends ServiceImpl<CrmBusinessLicenseQueryLogMapper, CrmBusinessLicenseQueryLog>
   implements CrmBusinessLicenseQueryLogService {
}
