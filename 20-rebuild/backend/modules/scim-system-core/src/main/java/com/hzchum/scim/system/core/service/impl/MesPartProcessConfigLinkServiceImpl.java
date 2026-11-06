package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.MesPartProcessConfigLink;
import com.hzchum.scim.system.core.api.service.MesPartProcessConfigLinkService;
import com.hzchum.scim.system.core.mapper.MesPartProcessConfigLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class MesPartProcessConfigLinkServiceImpl
   extends ServiceImpl<MesPartProcessConfigLinkMapper, MesPartProcessConfigLink>
   implements MesPartProcessConfigLinkService {
}
