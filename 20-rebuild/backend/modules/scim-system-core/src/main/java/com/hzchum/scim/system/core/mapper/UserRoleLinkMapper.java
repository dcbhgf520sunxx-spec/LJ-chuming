package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.UserRoleLink;
import com.hzchum.scim.system.core.api.pojo.dto.ProjectUserLinkDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleLinkMapper extends BaseMapper<UserRoleLink> {
   List<ProjectUserLinkDTO> listUserByRoleLink(@Param("roleId") Long roleId);

   Integer whetherUserHasPermission(@Param("userId") Long userId, @Param("permission") String permission);
}
