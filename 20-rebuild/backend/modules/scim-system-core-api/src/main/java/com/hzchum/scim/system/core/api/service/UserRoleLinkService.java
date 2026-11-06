package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.UserRoleLink;
import com.hzchum.scim.system.core.api.pojo.dto.ProjectUserLinkDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleLinkService extends IService<UserRoleLink> {
   List<ProjectUserLinkDTO> listUserByRoleLink(@Param("roleId") Long roleId);

   Boolean whetherUserHasPermission(Long userId, String permission);
}
