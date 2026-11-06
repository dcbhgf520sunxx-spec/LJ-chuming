package com.hzchum.scim.crm.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.crm.core.api.pojo._do.CrmInformationValidityPeriodConfig;
import com.hzchum.scim.crm.core.api.service.CrmInformationValidityPeriodConfigService;
import com.hzchum.scim.crm.core.mapper.CrmInformationValidityPeriodConfigMapper;
import org.springframework.stereotype.Service;

@Service
public class CrmInformationValidityPeriodConfigServiceImpl
   extends ServiceImpl<CrmInformationValidityPeriodConfigMapper, CrmInformationValidityPeriodConfig>
   implements CrmInformationValidityPeriodConfigService {
}
