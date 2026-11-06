package com.hzchum.scim.scm.core.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractClassConfig;
import com.hzchum.scim.scm.core.api.service.SubcontractClassConfigService;
import com.hzchum.scim.scm.core.mapper.SubcontractClassConfigMapper;
import org.springframework.stereotype.Service;

@Service
public class SubcontractClassConfigServiceImpl
   extends ServiceImpl<SubcontractClassConfigMapper, SubcontractClassConfig>
   implements SubcontractClassConfigService {
}
