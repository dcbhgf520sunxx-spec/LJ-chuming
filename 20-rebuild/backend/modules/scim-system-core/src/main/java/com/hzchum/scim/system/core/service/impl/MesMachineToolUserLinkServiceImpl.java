package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.plan.core.api.pojo.dto.change.SimpleUser;
import com.hzchum.scim.system.core.api.pojo._do.MesMachineToolUserLink;
import com.hzchum.scim.system.core.api.service.MesMachineToolUserLinkService;
import com.hzchum.scim.system.core.mapper.MesMachineToolUserLinkMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MesMachineToolUserLinkServiceImpl
   extends ServiceImpl<MesMachineToolUserLinkMapper, MesMachineToolUserLink>
   implements MesMachineToolUserLinkService {
   @Override
   public List<SimpleUser> findUserInfoByCondition(Long partProcessId, List<Long> toolConfigIds, List<Long> userId) {
      return this.baseMapper.findUserInfoByCondition(partProcessId, toolConfigIds, userId);
   }
}
