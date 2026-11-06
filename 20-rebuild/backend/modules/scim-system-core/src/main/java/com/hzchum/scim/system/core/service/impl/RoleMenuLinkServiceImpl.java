package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.system.core.api.common.enums.MenuCategoryEnum;
import com.hzchum.scim.system.core.api.common.enums.MenuSystemEnum;
import com.hzchum.scim.system.core.api.pojo._do.Menu;
import com.hzchum.scim.system.core.api.pojo._do.Role;
import com.hzchum.scim.system.core.api.pojo._do.RoleMenuLink;
import com.hzchum.scim.system.core.api.pojo.dto.MenuTreeResponseVO;
import com.hzchum.scim.system.core.api.service.MenuService;
import com.hzchum.scim.system.core.api.service.RoleMenuLinkService;
import com.hzchum.scim.system.core.api.service.RoleService;
import com.hzchum.scim.system.core.mapper.RoleMenuLinkMapper;
import com.hzchum.scim.system.core.security.GeneratorUserDetailService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleMenuLinkServiceImpl extends ServiceImpl<RoleMenuLinkMapper, RoleMenuLink> implements RoleMenuLinkService {
   @Resource
   private MenuService menuService;
   @Resource
   private RoleService roleService;

   @Override
   public List<MenuTreeResponseVO> getOwnMenuTree(Long roleId, Integer category, Integer systemEnum) {
      List<MenuTreeResponseVO> menuTree = this.menuService.getMenuTree(systemEnum);
      List<Long> menuIds = this.baseMapper.findMenusByRoleIdAndMenuKind(roleId, category).stream().map(Menu::getId).collect(Collectors.toList());
      return menuTree.stream().map(responseVO -> {
         if (menuIds.contains(responseVO.getId())) {
            responseVO.setOwn(Boolean.TRUE);
         } else {
            responseVO.setOwn(Boolean.FALSE);
         }

         List<MenuTreeResponseVO> childrenResponseVOs = responseVO.getChildren();
         this.dealChildMenu(childrenResponseVOs, menuIds);
         return (MenuTreeResponseVO)responseVO;
      }).collect(Collectors.toList());
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean updateLinks(Long roleId, List<Long> menuIds) {
      if (CollectionUtils.isEmpty(menuIds)) {
         this.baseMapper.delete(Wrappers.lambdaQuery(RoleMenuLink.class).eq(RoleMenuLink::getRoleId, roleId));
         GeneratorUserDetailService.USER_MAP.clear();
         return Boolean.TRUE;
      }

      menuIds = menuIds.stream().distinct().collect(Collectors.toList());
      List<Menu> menus = null;
      if (CollectionUtils.isNotEmpty(menuIds)) {
         menus = this.menuService.listByIds(menuIds);
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(menus), "操作失败,菜单不存在!");
      }

      Role role = this.roleService.getById(roleId);
      Preconditions.checkArgument(role != null, "角色不存在！");
      this.baseMapper.delete(Wrappers.lambdaQuery(RoleMenuLink.class).eq(RoleMenuLink::getRoleId, roleId));
      if (CollectionUtils.isNotEmpty(menuIds)) {
         Map<Long, Menu> menuMap = menus.stream().collect(Collectors.toMap(Menu::getId, Function.identity()));
         menuIds.forEach(menuId -> {
            if (menuMap.get(menuId) != null) {
               Integer menuSystemEnum = MenuSystemEnum.CONTAINS.getType();
               if (menuMap.get(menuId) != null) {
                  menuSystemEnum = MenuCategoryEnum.getMenuSystemEnum(menuMap.get(menuId).getCategory());
               }

               RoleMenuLink link = RoleMenuLink.builder().menuId(menuId).roleId(roleId).systemEnum(menuSystemEnum).build();
               this.baseMapper.insert(link);
            }
         });
      }

      GeneratorUserDetailService.USER_MAP.clear();
      return Boolean.TRUE;
   }

   @Override
   public List<Long> listByUserId(Long userId) {
      return this.baseMapper.listByUserId(userId);
   }

   private void dealChildMenu(List<MenuTreeResponseVO> childrenResponseVOs, List<Long> menuIds) {
      if (CollectionUtils.isNotEmpty(childrenResponseVOs)) {
         for (MenuTreeResponseVO children : childrenResponseVOs) {
            if (menuIds.contains(children.getId())) {
               children.setOwn(Boolean.TRUE);
            } else {
               children.setOwn(Boolean.FALSE);
            }

            this.dealChildMenu(children.getChildren(), menuIds);
         }
      }
   }

   @Override
   public List<Long> listMenuIdByRoleId(Long roleId) {
      return this.baseMapper
         .selectList(Wrappers.lambdaQuery(RoleMenuLink.class).eq(RoleMenuLink::getRoleId, roleId))
         .stream()
         .map(RoleMenuLink::getMenuId)
         .collect(Collectors.toList());
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean foreignUpdateLinks(List<String> permissions, List<Long> roleIds) {
      List<Role> roles = this.roleService.listByIds(roleIds);
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(roles) && roles.size() == roleIds.size(), "操作失败,角色列表不存在!");
      List<Menu> menuList = this.menuService.list((Wrapper<Menu>)new LambdaQueryWrapper<Menu>().in(Menu::getPermission, permissions));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(menuList) && menuList.size() == permissions.size(), "操作失败,菜单权限标识列表不存在");
      Preconditions.checkArgument(
         menuList.stream().allMatch(e -> ((MenuCategoryEnum.IOT_PC.getValue() | MenuCategoryEnum.IOT_APP.getValue()) & e.getCategory()) > 0),
         "操作失败,仅可添加物联系统的菜单权限!"
      );
      Map<Long, Menu> menuMap = menuList.stream().collect(Collectors.toMap(Menu::getId, Function.identity()));
      Map<Long, Map<Long, RoleMenuLink>> roleMenuLinkMapByRoleAndMenu = this.baseMapper
         .selectList(
            (Wrapper<RoleMenuLink>)(new LambdaQueryWrapper<RoleMenuLink>().in(RoleMenuLink::getRoleId, roleIds))
               .eq(RoleMenuLink::getSystemEnum, MenuSystemEnum.NOT_CONTAINS.getType())
         )
         .stream()
         .collect(Collectors.groupingBy(RoleMenuLink::getRoleId, Collectors.toMap(RoleMenuLink::getMenuId, Function.identity())));
      Map<Long, Menu> allMenuMap = this.menuService
         .list((Wrapper<Menu>)new LambdaQueryWrapper<Menu>().in(Menu::getCategory, MenuCategoryEnum.IOT_PC.getValue(), MenuCategoryEnum.IOT_APP.getValue()))
         .stream()
         .collect(Collectors.toMap(Menu::getId, Function.identity()));
      Menu menuServiceOne = this.menuService.getOne((Wrapper<Menu>)new LambdaQueryWrapper<Menu>().eq(Menu::getName, "设备管理"));
      if (menuServiceOne != null) {
         allMenuMap.put(menuServiceOne.getId(), menuServiceOne);
      }

      menuList.forEach(menu -> this.buildMenu(menu, menuMap, allMenuMap));
      Set<Long> menuIdList = menuMap.values().stream().map(Menu::getId).collect(Collectors.toSet());
      List<RoleMenuLink> addRoleMenuLinkList = new ArrayList<>();
      roleIds.forEach(roleId -> {
         Map<Long, RoleMenuLink> roleMenuLinkMap = roleMenuLinkMapByRoleAndMenu.getOrDefault(roleId, new HashMap<>());
         menuIdList.forEach(menuId -> {
            if (!roleMenuLinkMap.containsKey(menuId)) {
               RoleMenuLink link = RoleMenuLink.builder().menuId(menuId).roleId(roleId).systemEnum(MenuSystemEnum.NOT_CONTAINS.getType()).build();
               addRoleMenuLinkList.add(link);
            }
         });
      });
      if (CollectionUtils.isNotEmpty(addRoleMenuLinkList)) {
         this.saveBatch(addRoleMenuLinkList);
      }

      GeneratorUserDetailService.USER_MAP.clear();
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean removeLinks(List<String> permissions, List<Long> roleIds) {
      List<Role> roles = this.roleService.listByIds(roleIds);
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(roles) && roles.size() == roleIds.size(), "删除失败,角色列表不存在!");
      List<Menu> menuList = this.menuService.list((Wrapper<Menu>)new LambdaQueryWrapper<Menu>().in(Menu::getPermission, permissions));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(menuList) && menuList.size() == permissions.size(), "删除失败,菜单权限标识列表不存在");
      Preconditions.checkArgument(
         menuList.stream().allMatch(e -> ((MenuCategoryEnum.IOT_PC.getValue() | MenuCategoryEnum.IOT_APP.getValue()) & e.getCategory()) > 0),
         "操作失败,仅可删除物联系统的菜单权限!"
      );
      List<Menu> allmenuList = this.menuService
         .list((Wrapper<Menu>)new LambdaQueryWrapper<Menu>().in(Menu::getCategory, MenuCategoryEnum.IOT_PC.getValue(), MenuCategoryEnum.IOT_APP.getValue()));
      Menu menuServiceOne = this.menuService.getOne((Wrapper<Menu>)new LambdaQueryWrapper<Menu>().eq(Menu::getName, "设备管理"));
      if (menuServiceOne != null) {
         allmenuList.add(menuServiceOne);
      }

      Map<Long, Menu> allMenuMap = allmenuList.stream().collect(Collectors.toMap(Menu::getId, Function.identity()));
      Map<Long, List<Menu>> allMenuPanrantIdMap = allmenuList.stream().collect(Collectors.groupingBy(Menu::getPid));
      Map<Long, Map<Long, RoleMenuLink>> roleMenuLinkMapByRoleAndMenu = this.baseMapper
         .selectList(
            (Wrapper<RoleMenuLink>)(new LambdaQueryWrapper<RoleMenuLink>().in(RoleMenuLink::getRoleId, roleIds))
               .eq(RoleMenuLink::getSystemEnum, MenuSystemEnum.NOT_CONTAINS.getType())
         )
         .stream()
         .collect(Collectors.groupingBy(RoleMenuLink::getRoleId, Collectors.toMap(RoleMenuLink::getMenuId, Function.identity())));
      List<Long> menuIdList = menuList.stream().map(Menu::getId).collect(Collectors.toList());
      List<Long> delRoleMenuLinkIdList = new ArrayList<>();
      roleIds.forEach(roleId -> {
         Map<Long, RoleMenuLink> roleMenuLinkMap = roleMenuLinkMapByRoleAndMenu.get(roleId);
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(roleMenuLinkMap), "删除失败,该角色未绑定过菜单");
         menuIdList.forEach(menuId -> {
            if (roleMenuLinkMap.containsKey(menuId)) {
               delRoleMenuLinkIdList.add(roleMenuLinkMap.get(menuId).getId());
               roleMenuLinkMap.remove(menuId);
            }
         });
         if (CollectionUtils.isNotEmpty(roleMenuLinkMap)) {
            Set<Long> menuIds = roleMenuLinkMap.keySet();
            roleMenuLinkMap.forEach((menuId, link) -> {
               Menu menu = allMenuMap.get(menuId);
               if (menu.getPermission() == null) {
                  List<Menu> subMenuList = allMenuPanrantIdMap.get(menuId);
                  List<Menu> menus = subMenuList.stream().filter(e -> menuIds.contains(e.getId())).collect(Collectors.toList());
                  if (menus.isEmpty() || menus.stream().allMatch(e -> e.getPermission() == null)) {
                     delRoleMenuLinkIdList.add(roleMenuLinkMap.get(menuId).getId());
                  }
               }
            });
         }
      });
      if (CollectionUtils.isNotEmpty(delRoleMenuLinkIdList)) {
         this.removeByIds(delRoleMenuLinkIdList);
      }

      GeneratorUserDetailService.USER_MAP.clear();
      return Boolean.TRUE;
   }

   private void buildMenu(Menu menu, Map<Long, Menu> menuMap, Map<Long, Menu> allMenuMap) {
      Long pid = menu.getPid();
      if (pid != null && pid != 0L) {
         Menu parentMenu = allMenuMap.get(pid);
         if (!menuMap.containsKey(parentMenu.getId())) {
            menuMap.put(parentMenu.getId(), parentMenu);
         }

         this.buildMenu(parentMenu, menuMap, allMenuMap);
      }
   }
}
