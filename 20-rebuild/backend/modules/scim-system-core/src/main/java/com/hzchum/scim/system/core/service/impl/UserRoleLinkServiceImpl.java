package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.system.core.api.pojo._do.UserRoleLink;
import com.hzchum.scim.system.core.api.pojo.dto.ProjectUserLinkDTO;
import com.hzchum.scim.system.core.api.service.UserRoleLinkService;
import com.hzchum.scim.system.core.mapper.UserRoleLinkMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public class UserRoleLinkServiceImpl extends ServiceImpl<UserRoleLinkMapper, UserRoleLink> implements UserRoleLinkService {
   @Override
   public List<ProjectUserLinkDTO> listUserByRoleLink(@Param("roleId") Long roleId) {
      return this.baseMapper.listUserByRoleLink(roleId);
   }

   @Override
   public Boolean whetherUserHasPermission(Long userId, String permission) {
      Integer count = this.baseMapper.whetherUserHasPermission(userId, permission);
      return count > 0 ? true : false;
   }
}
