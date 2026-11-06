package com.hzchum.scim.rest.runner;

import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Order(2)
@Component
public class DepartmentInitRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(DepartmentInitRunner.class);
   private final DepartmentService departmentService;

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public void run(String... args) throws Exception {
      log.info("开始初始化部门信息...........................................");
      Department department = this.departmentService.getById(1L);
      if (department == null) {
         department = new Department();
         department.setId(1L);
         department.setName("公司");
         department.setPid(0L);
         department.setIntroduction("公司顶级部门，不可修改，不可删除");
         this.departmentService.save(department);
      }

      log.info("部门信息初始化完成...........................................");
   }

   public DepartmentInitRunner(final DepartmentService departmentService) {
      this.departmentService = departmentService;
   }
}
