package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.Menu;
import com.hzchum.scim.system.core.api.pojo._do.RoleMenuLink;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMenuLinkMapper extends BaseMapper<RoleMenuLink> {
   List<Long> listByUserId(@Param("userId") Long userId);

   List<Menu> findMenusByRoleIdAndMenuKind(@Param("roleId") Long roleId, @Param("category") Integer category);

   List<Menu> listMenusByRoleIdsAndCategory(@Param("category") Integer category, @Param("list") List<Long> roleIds);
}
