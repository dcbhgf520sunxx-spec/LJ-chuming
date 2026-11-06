package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.system.core.api.pojo._do.RoleMenuLink;
import com.hzchum.scim.system.core.api.pojo.dto.MenuTreeResponseVO;
import java.util.List;

public interface RoleMenuLinkService extends IService<RoleMenuLink> {
   List<MenuTreeResponseVO> getOwnMenuTree(Long roleId, Integer category, Integer systemEnum);

   Boolean updateLinks(Long roleId, List<Long> menuIds);

   List<Long> listByUserId(Long userId);

   List<Long> listMenuIdByRoleId(Long roleId);

   Boolean foreignUpdateLinks(List<String> permissions, List<Long> roleIds);

   Boolean removeLinks(List<String> permissions, List<Long> roleIds);
}
