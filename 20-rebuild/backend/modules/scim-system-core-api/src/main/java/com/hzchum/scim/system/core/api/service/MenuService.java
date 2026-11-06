package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.pojo._do.Menu;
import com.hzchum.scim.system.core.api.pojo.dto.MenuBuildTreeResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.MenuFirst;
import com.hzchum.scim.system.core.api.pojo.dto.MenuRequestVO;
import com.hzchum.scim.system.core.api.pojo.dto.MenuResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.MenuTreeResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.PermissionDTO;
import java.util.List;

public interface MenuService extends IService<Menu> {
   Long addMenu(MenuRequestVO requestVO);

   boolean updateMenu(MenuRequestVO requestVO);

   boolean removeBatchMenu(List<Long> ids);

   List<MenuTreeResponseVO> getMenuTree(Integer systemEnum);

   ListVO<MenuResponseVO> listByName(String blurryName);

   List<MenuBuildTreeResponseVO> getMenuBuildTree(SecurityUser user);

   Boolean addMenusByAdmin(List<MenuFirst> menuFirst, Long pid);

   Boolean addMenuByAdmin(MenuFirst menuFirst, Long pid);

   Boolean addPermission(List<PermissionDTO> list, Long pid);

   Integer deleteMenuTree(Long rootId);

   Boolean updateIdAndPid();

   List<NameInfo> listModuleMenu(String name);
}
