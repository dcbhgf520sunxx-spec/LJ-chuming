package com.hzchum.scim.crm.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectInformationConfig;
import com.hzchum.scim.crm.core.api.service.CrmProjectInformationConfigService;
import com.hzchum.scim.crm.core.mapper.CrmProjectInformationConfigMapper;
import org.springframework.stereotype.Service;

@Service
public class CrmProjectInformationConfigServiceImpl
   extends ServiceImpl<CrmProjectInformationConfigMapper, CrmProjectInformationConfig>
   implements CrmProjectInformationConfigService {
}
