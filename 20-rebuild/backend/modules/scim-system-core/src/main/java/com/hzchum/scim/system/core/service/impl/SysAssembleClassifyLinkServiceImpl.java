package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleClassifyLink;
import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassifyLinkDTO;
import com.hzchum.scim.system.core.api.service.SysAssembleClassifyLinkService;
import com.hzchum.scim.system.core.mapper.SysAssembleClassifyLinkMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SysAssembleClassifyLinkServiceImpl
   extends ServiceImpl<SysAssembleClassifyLinkMapper, SysAssembleClassifyLink>
   implements SysAssembleClassifyLinkService {
   @Override
   public List<SteelClassifyLinkDTO> listByCondition(Long assembleConfigId) {
      return this.baseMapper.selectByCondition(assembleConfigId);
   }
}
