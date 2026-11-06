package com.hzchum.scim.rest.runner;

import com.hzchum.scim.system.core.api.pojo._do.Role;
import com.hzchum.scim.system.core.api.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Order(2)
@Component
public class RoleInitRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(RoleInitRunner.class);
   private final RoleService roleService;

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public void run(String... strings) {
      log.info("角色初始化开始............................................");
      Role savedBasicRole = this.roleService.getByName("超级管理员");
      if (savedBasicRole == null) {
         Role role = Role.builder().name("超级管理员").isDefault(true).permission("admin").build();
         this.roleService.save(role);
      }

      log.info("角色初始化完成............................................");
   }

   public RoleInitRunner(final RoleService roleService) {
      this.roleService = roleService;
   }
}
