package com.hzchum.scim.system.core.biz.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.base.Preconditions;
import com.hzchum.scim.system.core.api.biz.DepartmentBiz;
import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.pojo._do.Job;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.JobService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentBizImpl implements DepartmentBiz {
   private static final Logger log = LoggerFactory.getLogger(DepartmentBizImpl.class);
   private final UserService userService;
   private final DepartmentService departmentService;
   @Resource
   private JobService jobService;

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public boolean removeDepartments(List<Long> ids) {
      ids.forEach(id -> {
         Department department = this.departmentService.getById(id);
         Preconditions.checkArgument(department != null, "删除失败，要删除的部门不存在");
         Preconditions.checkArgument(!department.getPid().equals(0L), "删除失败，无法删除系统默认部门");
         Integer count = this.userService.count((Wrapper<User>)new LambdaQueryWrapper<User>().eq(User::getDepartmentId, id));
         Preconditions.checkArgument(count.equals(0), "删除失败，请先将该部门下的员工移除该部门");
         Integer integer = this.departmentService.count((Wrapper<Department>)new LambdaQueryWrapper<Department>().eq(Department::getPid, id));
         Preconditions.checkArgument(integer.equals(0), "删除失败，该部门下还存在子部门");
         Integer jobs = this.jobService.count(new LambdaQueryWrapper<Job>().eq(Job::getDeptId, id));
         Preconditions.checkArgument(jobs.equals(0), "删除失败，该部门下还存在岗位");
         this.departmentService.removeById(id);
      });
      return true;
   }

   public DepartmentBizImpl(final UserService userService, final DepartmentService departmentService) {
      this.userService = userService;
      this.departmentService = departmentService;
   }
}
