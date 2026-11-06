package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.Menu;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuMapper extends BaseMapper<Menu> {
   List<Menu> findByPid(@Param("pid") Long pid);

   Integer countByPermissionTypeId(@Param("permissionTypeId") Long permissionTypeId);

   List<Menu> listByCategory(@Param("category") Integer category);

   List<Menu> listByIds(List<Long> menuListId);

   List<Menu> listAllForUpdate();

   void updateMenuIdAndPid(@Param("menu") Menu menu, @Param("newId") long newId);

   void changeIdAndPid();

   List<Menu> queryList(@Param("category") int category, @Param("menuType") int menuType);
}
