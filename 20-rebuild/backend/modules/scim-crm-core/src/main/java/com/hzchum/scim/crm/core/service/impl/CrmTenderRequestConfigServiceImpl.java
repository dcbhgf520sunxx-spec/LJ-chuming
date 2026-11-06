package com.hzchum.scim.crm.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.crm.core.api.pojo._do.CrmTenderRequestConfig;
import com.hzchum.scim.crm.core.api.service.CrmTenderRequestConfigService;
import com.hzchum.scim.crm.core.mapper.CrmTenderRequestConfigMapper;
import org.springframework.stereotype.Service;

@Service
public class CrmTenderRequestConfigServiceImpl
   extends ServiceImpl<CrmTenderRequestConfigMapper, CrmTenderRequestConfig>
   implements CrmTenderRequestConfigService {
}
