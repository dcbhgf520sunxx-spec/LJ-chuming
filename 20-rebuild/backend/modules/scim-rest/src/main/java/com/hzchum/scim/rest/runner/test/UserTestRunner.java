package com.hzchum.scim.rest.runner.test;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hzchum.scim.system.core.api.common.enums.UserTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.pojo._do.Job;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.JobService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Order(4)
public class UserTestRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(UserTestRunner.class);
   private final UserService userService;
   private final PasswordEncoder encoder;
   private final DepartmentService departmentService;
   private final JobService jobService;

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public void run(String... strings) {
      log.info("用户导入更新开始............................................");
      String a1 = java.util.Objects.requireNonNull(System.getenv("LJAPS_LEGACY_USER_IMPORT_BATCH_A"), "Explicit private user import batch A is required");
      String b1 = java.util.Objects.requireNonNull(System.getenv("LJAPS_LEGACY_USER_IMPORT_BATCH_B"), "Explicit private user import batch B is required");
      HashMap<String, String> map = new HashMap<>();
      String excludedNames = java.util.Objects.requireNonNull(System.getenv("LJAPS_LEGACY_USER_IMPORT_EXCLUDED_NAMES"), "Explicit private user exclusion mapping is required");
      for (String name : excludedNames.split(",")) {
         if (!name.trim().isEmpty()) map.put(name.trim(), name.trim());
      }
      String[] split = a1.split("\\+");
      String[] split1 = b1.split("\\+");
      this.setUser(split, map);
      this.setUser(split1, map);
      log.info("用户导入更新结束............................................");
   }

   private void setUser(String[] split, HashMap<String, String> map) {
      for (String s : split) {
         String trim = s.trim();
         List<String> stringList = Arrays.asList(trim.split(","));
         String userName = stringList.get(0).trim();
         String name = stringList.get(1).trim();
         if (!map.containsKey(name)) {
            String sexName = stringList.get(2).trim();
            String departmentName = stringList.get(3).trim();
            String jobName = stringList.get(4).trim();
            String dateOnBoard = stringList.get(5).trim();
            String phone = stringList.get(6).trim();
            if (phone.split("/").length > 1) {
               String[] split2 = phone.split("/");
               phone = split2[0];
            }

            Department department = this.departmentService
               .getOne((Wrapper<Department>)(new LambdaQueryWrapper<Department>().eq(Department::getName, departmentName)).eq(Department::getPid, 1));
            if (department == null) {
               department = new Department();
               department.setName(departmentName);
               department.setPid(1L);
               this.departmentService.save(department);
            }

            Job job = this.jobService
               .getOne((Wrapper<Job>)(new LambdaQueryWrapper<Job>().eq(Job::getName, jobName)).eq(Job::getDeptId, department.getId()));
            if (job == null) {
               job = new Job();
               job.setDeptId(department.getId());
               job.setEnabled(1);
               job.setIsAdmin(0);
               job.setName(jobName);
               job.setSort(162);
               this.jobService.save(job);
            }

            User user = this.userService.getOne((Wrapper<User>)new LambdaQueryWrapper<User>().eq(User::getName, name));
            if (user == null) {
               user = new User();
               user.setUsername(userName);
               user.setName(name);
               user.setPhone(phone);
               user.setSex(sexName.equals("男") ? 0 : 1);
               user.setPassword(this.encoder.encode(java.util.Objects.requireNonNull(System.getenv("LJAPS_INITIAL_USER_PASSWORD"), "LJAPS_INITIAL_USER_PASSWORD is required")));
               user.setDepartmentId(department.getId());
               user.setJobId(job.getId());
               user.setLastPasswordResetDate(LocalDateTime.now());
               user.setIsEnabled(Boolean.TRUE);
               user.setUserType(UserTypeEnum.COMMON_USER.getType());
               this.userService.save(user);
            } else {
               Boolean flag = false;
               if (!user.getUsername().equals(userName)) {
                  user.setUsername(userName);
                  flag = true;
               }

               if (!user.getPhone().equals(phone)) {
                  user.setPhone(phone);
                  flag = true;
               }

               if (flag) {
                  this.userService.updateById(user);
               }
            }
         }
      }
   }

   public UserTestRunner(final UserService userService, final PasswordEncoder encoder, final DepartmentService departmentService, final JobService jobService) {
      this.userService = userService;
      this.encoder = encoder;
      this.departmentService = departmentService;
      this.jobService = jobService;
   }
}
