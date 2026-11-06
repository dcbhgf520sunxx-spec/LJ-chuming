package com.hzchum.scim.crm.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.crm.core.api.pojo._do.CrmBusinessLicenseInformation;
import com.hzchum.scim.crm.core.api.service.CrmBusinessLicenseInformationService;
import com.hzchum.scim.crm.core.mapper.CrmBusinessLicenseInformationMapper;
import org.springframework.stereotype.Service;

@Service
public class CrmBusinessLicenseInformationServiceImpl
   extends ServiceImpl<CrmBusinessLicenseInformationMapper, CrmBusinessLicenseInformation>
   implements CrmBusinessLicenseInformationService {
}
