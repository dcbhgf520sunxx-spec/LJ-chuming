package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.SysEnclosureDictionaryDetail;
import com.hzchum.scim.system.core.api.service.SysEnclosureDictionaryDetailService;
import com.hzchum.scim.system.core.mapper.SysEnclosureDictionaryDetailMapper;
import org.springframework.stereotype.Service;

@Service
public class SysEnclosureDictionaryDetailServiceImpl
   extends ServiceImpl<SysEnclosureDictionaryDetailMapper, SysEnclosureDictionaryDetail>
   implements SysEnclosureDictionaryDetailService {
   @Override
   public SysEnclosureDictionaryDetail selectDetail(Integer type, String name, String label) {
      return this.baseMapper.selectDetail(type, name, label);
   }
}
