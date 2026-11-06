package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.enums.MenuCategoryEnum;
import com.hzchum.scim.system.core.api.common.enums.MenuTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.Menu;
import com.hzchum.scim.system.core.api.pojo._do.Role;
import com.hzchum.scim.system.core.api.pojo.dto.MenuBuildMetaResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.MenuBuildTreeResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.MenuFirst;
import com.hzchum.scim.system.core.api.pojo.dto.MenuRequestVO;
import com.hzchum.scim.system.core.api.pojo.dto.MenuResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.MenuTreeResponseVO;
import com.hzchum.scim.system.core.api.pojo.dto.PermissionDTO;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.MenuService;
import com.hzchum.scim.system.core.mapper.MenuMapper;
import com.hzchum.scim.system.core.mapper.RoleMenuLinkMapper;
import com.hzchum.scim.system.core.security.GeneratorUserDetailService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
   @Resource
   private RoleMenuLinkMapper roleMenuLinkMapper;
   @Resource
   private RedisUtils redisUtils;
   @Lazy
   @Resource
   private BranchCompanyService branchCompanyService;
   private static final String MENU_IS_NULL = "菜单不存在！";
   private static final String MENU_LIST = "menus";

   @Override
   public List<MenuTreeResponseVO> getMenuTree(Integer systemEnum) {
      List<Integer> values = MenuCategoryEnum.getValuesByType(systemEnum);
      List<Menu> menuList = this.baseMapper
         .selectList(Wrappers.lambdaQuery(Menu.class).in(CollectionUtils.isNotEmpty(values), Menu::getCategory, values).orderByAsc(Menu::getSort));
      return menuList.isEmpty() ? new ArrayList<>() : menuList.stream().filter(menu -> menu.getPid().equals(0L)).map(menu -> {
         MenuTreeResponseVO parent = this.getMenuTreeResponseVO(menu);
         return this.getSimpleMenuTree(parent, menu.getId(), menuList);
      }).collect(Collectors.toList());
   }

   private MenuTreeResponseVO getMenuTreeResponseVO(Menu menu) {
      MenuTreeResponseVO responseVO = BeanUtil.copy(menu, MenuTreeResponseVO.class);
      responseVO.setLabel(menu.getName());
      return responseVO;
   }

   private MenuTreeResponseVO getSimpleMenuTree(MenuTreeResponseVO parent, Long pid, List<Menu> menuList) {
      menuList.forEach(menu -> {
         if (pid.equals(menu.getPid())) {
            if (CollectionUtils.isEmpty(parent.getChildren())) {
               parent.setChildren(new ArrayList<>());
            }

            MenuTreeResponseVO child = this.getMenuTreeResponseVO(menu);
            parent.getChildren().add(this.getSimpleMenuTree(child, menu.getId(), menuList));
         }
      });
      return parent;
   }

   @Override
   public ListVO<MenuResponseVO> listByName(String blurryName) {
      Object menuVOList = this.redisUtils.get("menus");
      List<MenuResponseVO> menuVOs;
      if (menuVOList != null) {
         menuVOs = (List<MenuResponseVO>)menuVOList;
      } else {
         menuVOs = this.baseMapper
            .selectList(Wrappers.lambdaQuery(Menu.class).orderByAsc(Menu::getSort))
            .stream()
            .map(m -> BeanUtil.copy(m, MenuResponseVO.class))
            .collect(Collectors.toList());
         this.redisUtils.set("menus", menuVOs);
      }

      if (menuVOs.isEmpty()) {
         return new ListVO<>();
      }

      List<MenuResponseVO> responseVOS = new ArrayList<>();
      menuVOs.forEach(menu -> {
         if (menu.getPid().equals(0L)) {
            MenuResponseVO responseVO = this.getMenuListChildren(menu, menuVOs);
            responseVOS.add(responseVO);
         }
      });
      if (StringUtils.isNotBlank(blurryName)) {
         this.checkTree(responseVOS, blurryName);
      }

      return new ListVO<>(responseVOS);
   }

   private MenuResponseVO getMenuListChildren(MenuResponseVO parent, List<MenuResponseVO> menus) {
      menus.forEach(menu -> {
         if (parent.getId().equals(menu.getPid())) {
            if (CollectionUtils.isEmpty(parent.getChildren())) {
               parent.setChildren(new ArrayList<>());
            }

            MenuResponseVO child = this.getMenuListChildren(menu, menus);
            parent.getChildren().add(child);
         }
      });
      return parent;
   }

   private List<MenuResponseVO> checkTree(List<MenuResponseVO> tree, String name) {
      int size = tree.size();

      for (int i = 0; i < size; i++) {
         MenuResponseVO menuResponseVO = tree.get(i);
         if (CollectionUtils.isNotEmpty(menuResponseVO.getChildren())) {
            this.checkTree(menuResponseVO.getChildren(), name);
         }

         if (CollectionUtils.isEmpty(menuResponseVO.getChildren()) && !menuResponseVO.getName().contains(name)) {
            tree.remove(i);
            i--;
            size--;
         }
      }

      return tree;
   }

   private void setPricingMenu(List<MenuBuildTreeResponseVO> responseVOS, Long menuId) {
      if (CollectionUtils.isNotEmpty(responseVOS)) {
         responseVOS.forEach(
            responseVO -> {
               if (responseVO.getId().equals(menuId)) {
                  List<MenuBuildTreeResponseVO> children = responseVO.getChildren();
                  MenuBuildTreeResponseVO menuBuildTreeResponseVO = children.get(0);
                  List<BranchCompany> branchCompanyList = this.branchCompanyService
                     .list(Wrappers.lambdaQuery(BranchCompany.class).orderByAsc(BranchCompany::getLevel).orderByAsc(BranchCompany::getId));
                  List<MenuBuildTreeResponseVO> newChildren = new ArrayList<>(16);
                  branchCompanyList.forEach(bc -> {
                     MenuBuildTreeResponseVO vo = BeanUtil.copy(menuBuildTreeResponseVO, MenuBuildTreeResponseVO.class);
                     vo.setBranchCompanyId(bc.getId());
                     vo.setName(menuBuildTreeResponseVO.getName() + bc.getId());
                     vo.setPath(menuBuildTreeResponseVO.getPath() + "/" + bc.getId());
                     MenuBuildMetaResponseVO newMeta = BeanUtil.copy(menuBuildTreeResponseVO.getMeta(), MenuBuildMetaResponseVO.class);
                     newMeta.setTitle(bc.getShortName());
                     vo.setMeta(newMeta);
                     String redirect = menuBuildTreeResponseVO.getRedirect();
                     List<String> redirectList = Arrays.stream(StringUtils.split(redirect, "/")).collect(Collectors.toList());
                     redirectList.add(redirectList.size() - 1, String.valueOf(bc.getId()));
                     vo.setRedirect(StringUtils.join(redirectList, "/"));
                     List<MenuBuildTreeResponseVO> copyList = menuBuildTreeResponseVO.getChildren().stream().map(c -> {
                        MenuBuildTreeResponseVO copy = BeanUtil.copy(c, MenuBuildTreeResponseVO.class);
                        copy.setBranchCompanyId(bc.getId());
                        copy.setName(c.getName() + bc.getId());
                        return copy;
                     }).collect(Collectors.toList());
                     vo.setChildren(copyList);
                     newChildren.add(vo);
                  });
                  responseVO.setChildren(newChildren);
               } else {
                  this.setPricingMenu(responseVO.getChildren(), menuId);
               }
            }
         );
      }
   }

   @Override
   public List<MenuBuildTreeResponseVO> getMenuBuildTree(SecurityUser user) {
      boolean isAdmin = false;
      if (CollectionUtils.isNotEmpty(user.getRoles())) {
         isAdmin = user.getRoles().stream().anyMatch(role -> "admin".equals(role.getPermission()));
      }

      List<Menu> menuList;
      if (isAdmin) {
         menuList = this.baseMapper.listByCategory(MenuCategoryEnum.PC.getValue());
      } else if (CollectionUtils.isNotEmpty(user.getRoles())) {
         List<Long> roleIds = user.getRoles().stream().map(Role::getId).collect(Collectors.toList());
         menuList = this.roleMenuLinkMapper.listMenusByRoleIdsAndCategory(MenuCategoryEnum.PC.getValue(), roleIds);
         List<Menu> menus = this.baseMapper.selectList((Wrapper<Menu>)new LambdaQueryWrapper<Menu>().eq(Menu::getPid, 0L));
         menuList.addAll(menus);
      } else {
         menuList = new ArrayList<>();
      }

      List<Menu> menus = menuList.stream().filter(menu -> MenuTypeEnum.BUTTON.getValue() != menu.getType()).distinct().collect(Collectors.toList());
      List<MenuBuildTreeResponseVO> responseVOS = new ArrayList<>();
      menus.forEach(menu -> {
         if (menu.getBoolMainSystem() || menu.getPid() == 0L) {
            MenuBuildTreeResponseVO parent = new MenuBuildTreeResponseVO();
            parent.setId(menu.getId());
            parent.setName(menu.getName());
            parent.setBoolMainSystem(menu.getBoolMainSystem());
            parent.setRedirect(menu.getRedirect());
            responseVOS.add(this.findChildren(parent, menus));
         }
      });
      if (menus.stream().anyMatch(menu -> menu.getId().equals(6000200L))) {
         this.setPricingMenu(responseVOS, 6000200L);
      }

      return responseVOS;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean addMenusByAdmin(List<MenuFirst> menuFirsts, Long pid) {
      if (CollectionUtils.isNotEmpty(menuFirsts)) {
         menuFirsts.forEach(menuFirst -> this.addMenuByAdmin(menuFirst, pid));
      }

      this.redisUtils.del("menus");
      return true;
   }

   @Override
   public Boolean addMenuByAdmin(MenuFirst menuFirst, Long pid) {
      Menu menu = Menu.builder().build();
      menu.setPid(pid);
      menu.setCategory(MenuCategoryEnum.PC.getValue());
      menu.setName(menuFirst.getMeta().getTitle());
      menu.setIcon(menuFirst.getMeta().getIcon());
      menu.setPath(menuFirst.getPath());
      menu.setRedirect(menuFirst.getRedirect());
      menu.setComponentName(menuFirst.getName());
      menu.setComponent(menuFirst.getComponent());
      menu.setCache(!menuFirst.getMeta().getNoCache());
      menu.setType(1);
      menu.setIframe(false);
      menu.setAlwaysShow(menuFirst.getAlwaysShow());
      menu.setHidden(menuFirst.getHidden());
      if (Objects.isNull(menuFirst.getSort())) {
         Integer sort = this.getMenuSort(pid);
         menu.setSort(sort);
      }

      this.baseMapper.insert(menu);
      if (CollectionUtils.isNotEmpty(menuFirst.getPermission())) {
         this.addPermission(menuFirst.getPermission(), menu.getId());
      }

      if (CollectionUtils.isNotEmpty(menuFirst.getChildren())) {
         menuFirst.getChildren().forEach(e -> this.addMenuByAdmin(e, menu.getId()));
      }

      return true;
   }

   private Integer getMenuSort(Long pid) {
      Menu menu = this.baseMapper
         .selectOne(
            (Wrapper<Menu>)((new LambdaQueryWrapper<Menu>().eq(Menu::getPid, pid)).orderByDesc(Menu::getSort))
               .last("limit 1")
         );
      return Objects.isNull(menu) ? 1 : menu.getSort() + 1;
   }

   @Override
   public Boolean addPermission(List<PermissionDTO> list, Long pid) {
      for (PermissionDTO p : list) {
         Menu menu = Menu.builder().build();
         menu.setPid(pid);
         menu.setCategory(MenuCategoryEnum.PC.getValue());
         menu.setName(p.getName());
         menu.setCache(false);
         menu.setType(2);
         menu.setIframe(false);
         if (Objects.isNull(p.getSort())) {
            Integer sort = this.getMenuSort(pid);
            menu.setSort(sort);
         } else {
            menu.setSort(p.getSort());
         }

         menu.setPermission(p.getPermission());
         this.baseMapper.insert(menu);
      }

      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Integer deleteMenuTree(Long rootId) {
      Menu rootMenu = this.baseMapper.selectById(rootId);
      if (rootMenu == null) {
         return 0;
      }

      Queue<Menu> menuQueue = new LinkedList<>();
      List<Long> menuIds = new ArrayList<>();
      menuQueue.add(rootMenu);

      while (menuQueue.size() > 0) {
         Menu poll = menuQueue.poll();
         menuIds.add(poll.getId());
         List<Menu> menus = this.baseMapper.findByPid(poll.getId());
         menuQueue.addAll(menus);
      }

      this.redisUtils.del("menus");
      return this.baseMapper.deleteBatchIds(menuIds);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean updateIdAndPid() {
      this.baseMapper.changeIdAndPid();
      long newPcModuleId = 1L;
      long newPcMenuId = 1000L;
      long newPcPermissionId = 2000L;
      long newAppModuleId = 8000L;
      long newAppMenuId = 8300L;
      long newAppPermissionId = 9000L;
      MenuCategoryEnum[] categoryEnum = MenuCategoryEnum.values();

      for (MenuCategoryEnum category : categoryEnum) {
         int[] typeArr = new int[]{0, 1, 2};

         for (int type : typeArr) {
            for (Menu menu : this.baseMapper.queryList(category.getValue(), type)) {
               long newId;
               if (category.getValue() == 0) {
                  if (type == 0) {
                     newId = newPcModuleId++;
                  } else if (type == 1) {
                     newId = newPcMenuId++;
                  } else {
                     newId = newPcPermissionId++;
                  }
               } else if (type == 0) {
                  newId = newAppModuleId++;
               } else if (type == 1) {
                  newId = newAppMenuId++;
               } else {
                  newId = newAppPermissionId++;
               }

               this.baseMapper.updateMenuIdAndPid(menu, newId);
            }
         }
      }

      return true;
   }

   private MenuBuildTreeResponseVO findChildren(MenuBuildTreeResponseVO parent, List<Menu> menus) {
      menus.forEach(menu -> {
         if (parent.getId().equals(menu.getPid())) {
            if (CollectionUtils.isEmpty(parent.getChildren())) {
               parent.setChildren(new ArrayList<>());
            }

            MenuBuildMetaResponseVO meta = new MenuBuildMetaResponseVO();
            meta.setTitle(menu.getName());
            meta.setIcon(menu.getIcon());
            meta.setNoCache(!menu.getCache());
            MenuBuildTreeResponseVO child = new MenuBuildTreeResponseVO();
            child.setId(menu.getId());
            child.setName(menu.getComponentName());
            child.setPath(menu.getPath());
            child.setHidden(menu.getHidden());
            child.setComponent(menu.getComponent());
            child.setAlwaysShow(menu.getAlwaysShow());
            child.setRedirect(menu.getRedirect());
            child.setMeta(meta);
            parent.getChildren().add(this.findChildren(child, menus));
         }
      });
      return parent;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Long addMenu(MenuRequestVO requestVO) {
      if (requestVO.getPid() != 0L) {
         Menu parentMenu = this.getById(requestVO.getPid());
         Preconditions.checkArgument(parentMenu != null, "父菜单不存在！");
         Preconditions.checkArgument(Objects.equals(parentMenu.getCategory(), requestVO.getCategory()), "父菜单种类和子菜单种类必须一致！");
         this.checkType(parentMenu.getType(), requestVO.getType());
      } else {
         Preconditions.checkArgument(MenuTypeEnum.SYSTEM.getValue().equals(requestVO.getType()), "pid为0时，菜单必须是系统类型");
      }

      List<Menu> menuList = this.lambdaQuery().eq(Menu::getPid, requestVO.getPid()).list();
      boolean anyMatch = menuList.stream().anyMatch(menux -> Objects.equals(menux.getName(), requestVO.getName()));
      Preconditions.checkArgument(!anyMatch, "名称不能重复！");
      Menu menu = BeanUtil.copy(requestVO, Menu.class);
      this.save(menu);
      this.redisUtils.del("menus");
      GeneratorUserDetailService.USER_MAP.clear();
      return menu.getId();
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public boolean updateMenu(MenuRequestVO requestVO) {
      Menu menu = this.baseMapper.selectById(requestVO.getId());
      Preconditions.checkArgument(menu != null, "菜单不存在！");
      Preconditions.checkArgument(!menu.getBoolMainSystem(), "主系统不可编辑");
      if (!menu.getPid().equals(0L)) {
         Menu parentMenu = this.baseMapper.selectById(requestVO.getPid());
         Preconditions.checkArgument(parentMenu != null, "父菜单不存在！");
         Preconditions.checkArgument(Objects.equals(parentMenu.getCategory(), requestVO.getCategory()), "父菜单种类和子菜单种类必须一致！");
         this.checkType(parentMenu.getType(), requestVO.getType());
      }

      List<Menu> menuList = this.baseMapper.findByPid(requestVO.getPid());
      if (!requestVO.getName().equals(menu.getName())) {
         boolean anyMatch = menuList.stream().anyMatch(childMenu -> Objects.equals(childMenu.getName(), requestVO.getName()));
         Preconditions.checkArgument(!anyMatch, "名称不能重复！");
      }

      BeanUtil.copy(requestVO, menu);
      this.baseMapper.updateById(menu);
      this.redisUtils.del("menus");
      GeneratorUserDetailService.USER_MAP.clear();
      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public boolean removeBatchMenu(List<Long> ids) {
      ids.forEach(id -> {
         Menu menu = this.baseMapper.selectById(id);
         Preconditions.checkArgument(menu != null, "菜单不存在！");
         Preconditions.checkArgument(!menu.getBoolMainSystem(), "主系统不可删除");
         List<Menu> menuList = this.baseMapper.findByPid(id);
         Preconditions.checkArgument(CollectionUtils.isEmpty(menuList), "当前菜单下有子菜单，不允许删除！");
         this.baseMapper.deleteById(id);
      });
      this.redisUtils.del("menus");
      GeneratorUserDetailService.USER_MAP.clear();
      return true;
   }

   private void checkType(Integer parentType, Integer type) {
      if (MenuTypeEnum.MODULE.getValue().equals(type)) {
         Preconditions.checkArgument(MenuTypeEnum.SYSTEM.getValue().equals(parentType), "模块父类型必须为系统");
      } else if (MenuTypeEnum.MENU.getValue().equals(type)) {
         Preconditions.checkArgument(MenuTypeEnum.MENU.getValue().equals(parentType) || MenuTypeEnum.MODULE.getValue().equals(parentType), "菜单父类型必须为模块或者菜单");
      } else {
         if (!MenuTypeEnum.BUTTON.getValue().equals(type)) {
            throw new IllegalArgumentException("类型错误");
         }

         Preconditions.checkArgument(MenuTypeEnum.MENU.getValue().equals(parentType) || MenuTypeEnum.MODULE.getValue().equals(parentType), "按钮父类型必须为模块或者菜单");
      }
   }

   @Override
   public List<NameInfo> listModuleMenu(String name) {
      return this.baseMapper
         .selectList(Wrappers.lambdaQuery(Menu.class).eq(Menu::getPid, 11111L).like(name != null, Menu::getName, name).orderByAsc(Menu::getSort))
         .stream()
         .map(m -> BeanUtil.copy(m, NameInfo.class))
         .collect(Collectors.toList());
   }
}
