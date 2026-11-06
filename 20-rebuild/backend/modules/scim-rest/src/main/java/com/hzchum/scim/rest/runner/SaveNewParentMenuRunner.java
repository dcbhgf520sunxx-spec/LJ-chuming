package com.hzchum.scim.rest.runner;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.system.core.api.common.enums.MenuSystemEnum;
import com.hzchum.scim.system.core.api.pojo._do.Menu;
import com.hzchum.scim.system.core.api.pojo._do.RoleMenuLink;
import com.hzchum.scim.system.core.api.service.MenuService;
import com.hzchum.scim.system.core.api.service.RoleMenuLinkService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SaveNewParentMenuRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(SaveNewParentMenuRunner.class);
   @Resource
   private MenuService menuService;
   @Resource
   private RoleMenuLinkService roleMenuLinkService;

   @Override
   public void run(String... args) throws Exception {
      this.saveNewParentMenu(800000L);
      this.saveNewParentMenu(800005L);
      this.saveNewParentMenu(800100L);
   }

   private void saveNewParentMenu(Long menuId) {
      List<Menu> menuList = this.menuService.list(Wrappers.lambdaQuery(Menu.class).eq(Menu::getPid, menuId));
      if (!CollectionUtils.isEmpty(menuList)) {
         List<Long> ids = menuList.stream().map(Menu::getId).collect(Collectors.toList());
         List<RoleMenuLink> roleMenuLinkList = this.roleMenuLinkService.list(Wrappers.lambdaQuery(RoleMenuLink.class).in(RoleMenuLink::getMenuId, ids));
         if (!CollectionUtils.isEmpty(roleMenuLinkList)) {
            List<RoleMenuLink> resultList = new ArrayList<>();
            roleMenuLinkList.stream()
               .map(RoleMenuLink::getRoleId)
               .distinct()
               .forEach(e -> resultList.add(RoleMenuLink.builder().roleId(e).menuId(menuId).systemEnum(MenuSystemEnum.CONTAINS.getType()).build()));
            List<Long> hasRoleList = this.roleMenuLinkService
               .list(
                  Wrappers.lambdaQuery(RoleMenuLink.class)
                     .eq(RoleMenuLink::getMenuId, menuId)
                     .eq(RoleMenuLink::getSystemEnum, MenuSystemEnum.CONTAINS.getType())
               )
               .stream()
               .map(RoleMenuLink::getRoleId)
               .collect(Collectors.toList());
            List<RoleMenuLink> saveList = resultList.stream().filter(e -> !hasRoleList.contains(e.getRoleId())).collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(saveList)) {
               this.roleMenuLinkService.saveBatch(saveList);
            }
         }
      }
   }

   public SaveNewParentMenuRunner(final MenuService menuService, final RoleMenuLinkService roleMenuLinkService) {
      this.menuService = menuService;
      this.roleMenuLinkService = roleMenuLinkService;
   }
}
