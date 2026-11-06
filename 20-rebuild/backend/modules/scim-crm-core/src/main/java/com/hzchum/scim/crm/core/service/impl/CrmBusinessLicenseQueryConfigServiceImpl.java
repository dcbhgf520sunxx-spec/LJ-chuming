package com.hzchum.scim.crm.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.crm.core.api.pojo._do.CrmBusinessLicenseQueryConfig;
import com.hzchum.scim.crm.core.api.service.CrmBusinessLicenseQueryConfigService;
import com.hzchum.scim.crm.core.mapper.CrmBusinessLicenseQueryConfigMapper;
import org.springframework.stereotype.Service;

@Service
public class CrmBusinessLicenseQueryConfigServiceImpl
   extends ServiceImpl<CrmBusinessLicenseQueryConfigMapper, CrmBusinessLicenseQueryConfig>
   implements CrmBusinessLicenseQueryConfigService {
}
