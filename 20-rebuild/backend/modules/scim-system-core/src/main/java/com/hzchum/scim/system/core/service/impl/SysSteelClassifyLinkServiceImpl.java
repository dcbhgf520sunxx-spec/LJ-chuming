package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.SysSteelClassifyLink;
import com.hzchum.scim.system.core.api.service.SysSteelClassifyLinkService;
import com.hzchum.scim.system.core.mapper.SysSteelClassifyLinkMapper;
import org.springframework.stereotype.Service;

@Service
public class SysSteelClassifyLinkServiceImpl extends ServiceImpl<SysSteelClassifyLinkMapper, SysSteelClassifyLink> implements SysSteelClassifyLinkService {
   @Override
   public void removeBySteelId(Long steelId) {
      this.baseMapper.delete((Wrapper<SysSteelClassifyLink>)Wrappers.<SysSteelClassifyLink>lambdaQuery().eq(SysSteelClassifyLink::getSteelId, steelId));
   }
}
