package com.hzchum.scim.crm.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.crm.core.api.pojo._do.CrmPageManagementConfig;
import com.hzchum.scim.crm.core.api.service.CrmPageManagementConfigService;
import com.hzchum.scim.crm.core.mapper.CrmPageManagementConfigMapper;
import org.springframework.stereotype.Service;

@Service
public class CrmPageManagementConfigServiceImpl
   extends ServiceImpl<CrmPageManagementConfigMapper, CrmPageManagementConfig>
   implements CrmPageManagementConfigService {
}
