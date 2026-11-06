package com.hzchum.scim.rest.runner;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.mes.building.core.api.enums.laborManagement.EmployeeStatusEnum;
import com.hzchum.scim.project.core.api.pojo._do.ProjectManageRoster;
import com.hzchum.scim.project.core.api.service.ProjectManageRosterService;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProjectRosterUserRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(ProjectRosterUserRunner.class);
   private final UserService userService;
   private final ProjectManageRosterService rosterService;

   @Override
   public void run(String... args) throws Exception {
      List<Long> userIds = this.rosterService
         .list(Wrappers.lambdaQuery(ProjectManageRoster.class).eq(ProjectManageRoster::getStatus, EmployeeStatusEnum.ON_JOB.getType()))
         .stream()
         .map(ProjectManageRoster::getUserId)
         .distinct()
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(userIds)) {
         List<User> userList = this.userService.list(Wrappers.lambdaQuery(User.class).in(User::getId, userIds).eq(User::getIsEnabled, Boolean.FALSE));
         if (CollectionUtils.isNotEmpty(userList)) {
            List<User> updateList = userList.stream().peek(user -> user.setIsEnabled(Boolean.TRUE)).collect(Collectors.toList());
            this.userService.updateBatchById(updateList);
         }
      }
   }

   public ProjectRosterUserRunner(final UserService userService, final ProjectManageRosterService rosterService) {
      this.userService = userService;
      this.rosterService = rosterService;
   }
}
