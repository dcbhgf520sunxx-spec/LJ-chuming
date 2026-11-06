package com.hzchum.scim.rest.runner;

import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.pojo._do.Role;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo._do.UserRoleLink;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.RoleService;
import com.hzchum.scim.system.core.api.service.UserRoleLinkService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Order(3)
@Component
public class UserInitRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(UserInitRunner.class);
   private final UserService userService;
   private final RoleService roleService;
   private final PasswordEncoder encoder;
   private final UserRoleLinkService userRoleLinkService;
   private final DepartmentService departmentService;
   private final ConfigProperties configProperties;

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public void run(String... strings) {
      log.info("超级管理员用户初始化开始............................................");
      User user = this.userService.getByUsername("admin");
      if (user == null) {
         Department department = this.departmentService.getById(1L);
         user = User.builder()
            .username("admin")
            .name("超级管理员")
            .sex(0)
            .lastPasswordResetDate(LocalDateTime.now())
            .phone(this.configProperties.getPhone())
            .email(this.configProperties.getEmail())
            .password(this.encoder.encode(this.configProperties.getPassword()))
            .isEnabled(true)
            .departmentId(department.getId())
            .build();
         this.userService.save(user);
         Role role = this.roleService.getByName("超级管理员");
         UserRoleLink userRoleLink = UserRoleLink.builder().userId(user.getId()).roleId(role.getId()).build();
         this.userRoleLinkService.save(userRoleLink);
      }

      log.info("超级管理员初始化完成............................................");
   }

   public UserInitRunner(
      final UserService userService,
      final RoleService roleService,
      final PasswordEncoder encoder,
      final UserRoleLinkService userRoleLinkService,
      final DepartmentService departmentService,
      final ConfigProperties configProperties
   ) {
      this.userService = userService;
      this.roleService = roleService;
      this.encoder = encoder;
      this.userRoleLinkService = userRoleLinkService;
      this.departmentService = departmentService;
      this.configProperties = configProperties;
   }
}
