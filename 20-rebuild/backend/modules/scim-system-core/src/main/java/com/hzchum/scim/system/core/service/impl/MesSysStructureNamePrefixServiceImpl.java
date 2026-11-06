package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.MesSysStructureNamePrefix;
import com.hzchum.scim.system.core.api.service.MesSysStructureNamePrefixService;
import com.hzchum.scim.system.core.mapper.MesSysStructureNamePrefixMapper;
import org.springframework.stereotype.Service;

@Service
public class MesSysStructureNamePrefixServiceImpl
   extends ServiceImpl<MesSysStructureNamePrefixMapper, MesSysStructureNamePrefix>
   implements MesSysStructureNamePrefixService {
}
