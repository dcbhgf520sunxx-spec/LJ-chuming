package com.hzchum.scim.rest.controller.zhongnanoa;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.enums.EnableEnum;
import com.hzchum.scim.common.core.api.pojo.dto.oa.SHRDeptInfoDTO;
import com.hzchum.scim.common.core.api.pojo.dto.oa.SHRJobtitleInfoDTO;
import com.hzchum.scim.common.core.api.pojo.dto.oa.SHRUserInfoDTO;
import com.hzchum.scim.system.core.api.biz.UserBiz;
import com.hzchum.scim.system.core.api.common.enums.CrudTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.DeptAndJobTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.UserTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.pojo._do.Job;
import com.hzchum.scim.system.core.api.pojo._do.ShrUserChangeRecord;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.JobService;
import com.hzchum.scim.system.core.api.service.ShrUserChangeRecordService;
import com.hzchum.scim.system.core.api.service.UserService;
import io.swagger.annotations.Api;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "自测SHR")
@RestController
@RequestMapping("/api/oa/flow")
public class MySHRThreeTest {
   private static final Logger log = LoggerFactory.getLogger(MySHRThreeTest.class);
   @Resource
   private DepartmentService departmentService;
   @Resource
   private JobService jobService;
   @Resource
   private UserService userService;
   @Resource
   private PasswordEncoder encoder;
   @Resource
   private UserBiz userBiz;
   @Resource
   private ShrUserChangeRecordService shrUserChangeRecordService;

   @PostMapping("/test1111")
   public ResultVO syncSHRDept(@RequestBody String date) {
      List<Department> departments = this.departmentService
         .list(Wrappers.lambdaQuery(Department.class).eq(Department::getDeptType, DeptAndJobTypeEnum.ESTABLISHMENT_INSIDE.getType()));
      JSONObject jsonObject = JSONObject.parseObject(date);
      List<SHRDeptInfoDTO> shrDeptInfoDTOS = JSONArray.parseArray(jsonObject.getString("data"), SHRDeptInfoDTO.class);
      log.info("获取部门数据" + jsonObject + ":获取数据量为:" + shrDeptInfoDTOS.size());
      this.syncSHR(shrDeptInfoDTOS, departments);
      return ResultBuilder.success(null, "同步成功");
   }

   private void syncSHR(List<SHRDeptInfoDTO> shrDepts, List<Department> departmentTrees) {
      log.info("同步 SHR 部门树到初鸣系统部门树");
      this.syncSHRToADepartments(shrDepts, departmentTrees);
      List<Department> departments = this.departmentService
         .list(Wrappers.lambdaQuery(Department.class).eq(Department::getDeptType, DeptAndJobTypeEnum.ESTABLISHMENT_INSIDE.getType()));
      log.info("标记未使用的部门为禁用");
      this.markUnusedDepartmentsAsDisabled(shrDepts, departments);
   }

   @Transactional(rollbackFor = Exception.class)
   public void syncSHRToADepartments(List<SHRDeptInfoDTO> shrDeptTree, List<Department> aDeptTree) {
      Map<String, Department> departmentMap = aDeptTree.stream()
         .filter(department -> StringUtils.isNotBlank(department.getOrgCode()))
         .collect(Collectors.toMap(Department::getOrgCode, Function.identity()));
      log.info("开始同步部门出PID以外的信息---------------------------");
      shrDeptTree.forEach(shrDept -> {
         if ("101010201".equals(shrDept.getOrgCode())) {
            Department topDept = this.departmentService.getById(1L);
            Preconditions.checkArgument(topDept != null, "顶级部门异常请联系管理人员!!!!!");
            topDept.setOrgCode(shrDept.getOrgCode());
            topDept.setName(shrDept.getOrgName());
            topDept.setParentOrgCode(shrDept.getParentOrgCode());
            topDept.setStatus(EnableEnum.ENABLE.getType());
            this.departmentService.updateById(topDept);
         } else {
            Department department = departmentMap.get(shrDept.getOrgCode());
            if (department != null) {
               department.setOrgCode(shrDept.getOrgCode());
               department.setParentOrgCode(shrDept.getParentOrgCode());
               department.setDeptType(DeptAndJobTypeEnum.ESTABLISHMENT_INSIDE.getType());
               department.setName(shrDept.getOrgName());
               this.departmentService.updateById(department);
            } else {
               Department newDept = new Department();
               newDept.setName(shrDept.getOrgName());
               newDept.setOrgCode(shrDept.getOrgCode());
               newDept.setDeptType(DeptAndJobTypeEnum.ESTABLISHMENT_INSIDE.getType());
               newDept.setParentOrgCode(shrDept.getParentOrgCode());
               this.departmentService.save(newDept);
            }
         }
      });
      log.info("结束同步部门出PID以外的信息---------------------------");
      List<Department> departments = this.departmentService
         .list(
            Wrappers.lambdaQuery(Department.class)
               .in(Department::getOrgCode, shrDeptTree.stream().map(SHRDeptInfoDTO::getOrgCode).collect(Collectors.toList()))
         );
      Map<String, Department> map = departments.stream().collect(Collectors.toMap(Department::getOrgCode, Function.identity()));
      log.info("开始修改部门父子结构状态-----------------------");
      departments.forEach(item -> {
         if (!"101010201".equals(item.getOrgCode())) {
            Department department = map.get(item.getParentOrgCode());
            Preconditions.checkArgument(department != null, "父级部门不存在,请联系管理人员!!!!");
            item.setPid(department.getId());
            this.departmentService.updateById(item);
         }
      });
      log.info("修改部门父子结构状态结束-----------------------");
   }

   private void markUnusedDepartmentsAsDisabled(List<SHRDeptInfoDTO> SHRDeptTree, List<Department> aDeptTree) {
      Set<String> shrDeptCodes = SHRDeptTree.stream().map(SHRDeptInfoDTO::getOrgCode).collect(Collectors.toSet());

      for (Department dept : aDeptTree) {
         if ("制造一部外协班组".equals(dept.getName()) || "制造二部外协班组".equals(dept.getName()) || "集团总部董事局".equals(dept.getName())) {
            dept.setDeptType(DeptAndJobTypeEnum.ESTABLISHMENT_OUTER.getType());
            dept.setPid(1L);
            this.departmentService.updateById(dept);
         } else if (!shrDeptCodes.contains(dept.getOrgCode())) {
            Department byId = this.departmentService.getById(dept.getId());
            byId.setStatus(EnableEnum.DISABLE.getType());
            this.departmentService.updateById(byId);
         }
      }
   }

   @PostMapping("/test2222")
   public ResultVO syncSHRJob(@RequestBody String date) {
      JSONObject jsonObject = JSONObject.parseObject(date);
      List<SHRJobtitleInfoDTO> shrJobtitleInfoDTO = JSONArray.parseArray(jsonObject.getString("data"), SHRJobtitleInfoDTO.class);
      log.info("获取岗位数据" + jsonObject + ":获取数据量为:" + shrJobtitleInfoDTO.size());
      List<Job> jobs = this.jobService.list(Wrappers.lambdaQuery(Job.class).eq(Job::getJobType, DeptAndJobTypeEnum.ESTABLISHMENT_INSIDE.getType()));
      log.info("同步 SHR 系统的岗位到初鸣系统");
      this.syncJobs(shrJobtitleInfoDTO, jobs);
      List<Job> newjobs = this.jobService.list(Wrappers.lambdaQuery(Job.class).eq(Job::getJobType, DeptAndJobTypeEnum.ESTABLISHMENT_INSIDE.getType()));
      log.info("禁用初鸣系统中多余的岗位");
      this.disableExtraJobs(newjobs, shrJobtitleInfoDTO);
      return ResultBuilder.success(null, "同步成功");
   }

   @Transactional(rollbackFor = Exception.class)
   public void syncJobs(List<SHRJobtitleInfoDTO> shrJobTitles, List<Job> jobs) {
      Map<String, Job> jobMap = jobs.stream()
         .filter(item -> StringUtils.isNotBlank(item.getPositionCode()))
         .collect(Collectors.toMap(Job::getPositionCode, Function.identity()));
      List<Department> departments = this.departmentService
         .list(
            Wrappers.lambdaQuery(Department.class)
               .isNotNull(Department::getOrgCode)
               .eq(Department::getDeptType, DeptAndJobTypeEnum.ESTABLISHMENT_INSIDE.getType())
         );
      Map<String, Department> deptMap = departments.stream().collect(Collectors.toMap(Department::getOrgCode, Function.identity()));
      shrJobTitles.forEach(job -> {
         Department department = deptMap.get(job.getOrgCode());
         Preconditions.checkArgument(department != null, job.getPositionName() + "岗位对应部门信息不存在,请联系管理人员!!!!!");
         Job thisJob = jobMap.get(job.getPositionCode());
         if (thisJob == null) {
            Job aJob = new Job();
            aJob.setName(job.getPositionName());
            aJob.setOrgCode(job.getOrgCode());
            aJob.setPositionCode(job.getPositionCode());
            aJob.setEnabled(EnableEnum.ENABLE.getType());
            aJob.setDeptId(department.getId());
            aJob.setIsAdmin(1);
            aJob.setSort(1);
            this.jobService.save(aJob);
         } else {
            Preconditions.checkArgument(job.getOrgCode().equals(thisJob.getOrgCode()), "变动岗位信息与岗位原部门信息不同,暂未开放岗位调转部门功能,请联系管理人员");
            thisJob.setName(job.getPositionName());
            thisJob.setOrgCode(job.getOrgCode());
            thisJob.setPositionCode(job.getPositionCode());
            thisJob.setEnabled(EnableEnum.ENABLE.getType());
            thisJob.setDeptId(department.getId());
            thisJob.setIsAdmin(1);
            thisJob.setSort(1);
            this.jobService.updateById(thisJob);
         }
      });
   }

   private void disableExtraJobs(List<Job> aSystemJobs, List<SHRJobtitleInfoDTO> shrJobTitles) {
      Set<String> shrJobPositionCodes = shrJobTitles.stream().map(SHRJobtitleInfoDTO::getPositionCode).collect(Collectors.toSet());

      for (Job aJob : aSystemJobs) {
         if (aJob.getDeptId() == 78L || aJob.getDeptId() == 47L || aJob.getDeptId() == 46L) {
            aJob.setJobType(DeptAndJobTypeEnum.ESTABLISHMENT_OUTER.getType());
            this.jobService.updateById(aJob);
         } else if (!shrJobPositionCodes.contains(aJob.getPositionCode())) {
            aJob.setEnabled(EnableEnum.DISABLE.getType());
            this.jobService.updateById(aJob);
         }
      }
   }

   @PostMapping("/test3333")
   public ResultVO syncSHRUser(@RequestBody String date) {
      JSONObject jsonObject = JSONObject.parseObject(date);
      List<SHRUserInfoDTO> shrUserInfoDTO = JSONArray.parseArray(jsonObject.getString("data"), SHRUserInfoDTO.class);
      log.info("获取用户数据" + jsonObject + ":获取数据量为:" + shrUserInfoDTO.size());
      List<User> users = this.userService.list();
      log.info("同步 SHR 系统的岗位到 A 系统");
      this.syncUser(shrUserInfoDTO, users);
      log.info("禁用初鸣系统中多余的人员");
      this.disableExtraUsers(this.userService.list(Wrappers.lambdaQuery(User.class).eq(User::getUserType, UserTypeEnum.COMMON_USER.getType())), shrUserInfoDTO);
      return ResultBuilder.success(null, "同步成功");
   }

   @Transactional(rollbackFor = Exception.class)
   public void syncUser(List<SHRUserInfoDTO> shrUserInfoDTO, List<User> users) {
      Map<String, User> allUserMap = this.userService.list().stream().collect(Collectors.toMap(User::getPhone, Function.identity()));
      Map<String, User> codeUserMap = users.stream().collect(Collectors.toMap(User::getUsername, Function.identity()));
      Map<String, User> codeUserMap2 = users.stream()
         .filter(item -> StringUtils.isNotBlank(item.getUserCode()))
         .collect(Collectors.toMap(User::getUserCode, Function.identity()));
      List<Department> departments = this.departmentService
         .list(
            Wrappers.lambdaQuery(Department.class)
               .isNotNull(Department::getOrgCode)
               .eq(Department::getDeptType, DeptAndJobTypeEnum.ESTABLISHMENT_INSIDE.getType())
         );
      List<Job> jobList = this.jobService
         .list(Wrappers.lambdaQuery(Job.class).isNotNull(Job::getPositionCode).eq(Job::getJobType, DeptAndJobTypeEnum.ESTABLISHMENT_INSIDE.getType()));
      Map<String, Job> jobByCodeMap = jobList.stream().collect(Collectors.toMap(Job::getPositionCode, Function.identity()));
      Map<Long, Department> deptMap = this.departmentService
         .list(Wrappers.lambdaQuery(Department.class))
         .stream()
         .collect(Collectors.toMap(Department::getId, Function.identity()));
      Map<String, Department> deptByCodeMap = departments.stream().collect(Collectors.toMap(Department::getOrgCode, Function.identity()));
      shrUserInfoDTO.forEach(
         shrUser -> {
            Preconditions.checkArgument(shrUser.getUserCode() != null, "人员SHR编号未传入!!!!");
            if (!shrUser.getUserCode().equals("005692")) {
               User user = codeUserMap.get("A" + shrUser.getUserCode());
               User user1 = codeUserMap2.get(shrUser.getUserCode());
               if (user == null && user1 == null) {
                  User getUserByPhone = allUserMap.get(shrUser.getPhone());
                  Preconditions.checkArgument(getUserByPhone == null, shrUser.getUserName() + "人员的手机号:" + shrUser.getPhone() + "已经被注册如有疑问请联系管理人员!!!!");
                  Department department = deptByCodeMap.get(shrUser.getDeptCode());
                  Preconditions.checkArgument(department != null, shrUser.getUserName() + "对应的部门不存在,请联系管理人员!!!!");
                  Job job = jobByCodeMap.get(shrUser.getPositionCode());
                  Preconditions.checkArgument(
                     job != null && job.getDeptId().equals(department.getId()), shrUser.getUserName() + "对应的岗位不存在或者岗位不属于该部门,请联系管理人员!!!!"
                  );
                  User newUser = User.builder()
                     .name(shrUser.getUserName())
                     .username("A" + shrUser.getUserCode())
                     .phone(shrUser.getPhone())
                     .jobId(job.getId())
                     .password(this.encoder.encode(java.util.Objects.requireNonNull(System.getenv("LJAPS_INITIAL_USER_PASSWORD"), "LJAPS_INITIAL_USER_PASSWORD is required")))
                     .email(shrUser.getEmail())
                     .isEnabled(true)
                     .userType(UserTypeEnum.COMMON_USER.getType())
                     .sex(Integer.getInteger(shrUser.getGender()))
                     .departmentId(department.getId())
                     .positionCode(shrUser.getPositionCode())
                     .deptCode(shrUser.getDeptCode())
                     .userCode(shrUser.getUserCode())
                     .isEnabled(true)
                     .build();
                  this.userService.save(newUser);
                  this.shrUserChangeRecordService
                     .save(
                        ShrUserChangeRecord.builder()
                           .deptName(
                              ObjectUtils.isNotEmpty(newUser.getDepartmentId()) ? this.departmentService.getById(newUser.getDepartmentId()).getName() : null
                           )
                           .jobName(ObjectUtils.isNotEmpty(newUser.getJobId()) ? this.jobService.getById(newUser.getJobId()).getName() : null)
                           .name(newUser.getName())
                           .phone(newUser.getPhone())
                           .userType(UserTypeEnum.COMMON_USER.getType())
                           .crudType(CrudTypeEnum.SAVE.getType())
                           .build()
                     );
               } else if (user != null) {
                  user.setIsEnabled(Boolean.TRUE);
                  user.setEmail(shrUser.getEmail());
                  user.setUserCode(shrUser.getUserCode());
                  if (user.getDeptCode() == null
                     || !user.getDeptCode().equals(shrUser.getDeptCode())
                     || user.getPositionCode() == null
                     || !user.getPositionCode().equals(shrUser.getPositionCode())
                     || !user.getName().equals(shrUser.getUserName())
                     || !user.getPhone().equals(shrUser.getPhone())) {
                     ShrUserChangeRecord userChangeRecord = ShrUserChangeRecord.builder()
                        .userType(UserTypeEnum.COMMON_USER.getType())
                        .crudType(CrudTypeEnum.UPDATE.getType())
                        .build();
                     if (!user.getName().equals(shrUser.getUserName())) {
                        userChangeRecord.setName(user.getName() + "->" + shrUser.getUserName());
                        user.setName(shrUser.getUserName());
                     } else {
                        userChangeRecord.setName(user.getName());
                     }

                     if (!user.getPhone().equals(shrUser.getPhone())) {
                        User getUserByPhone = allUserMap.get(shrUser.getPhone());
                        Preconditions.checkArgument(getUserByPhone == null, shrUser.getUserName() + "人员的手机号:" + shrUser.getPhone() + "已经被注册如有疑问请联系管理人员!!!!");
                        userChangeRecord.setPhone(user.getPhone() + "->" + shrUser.getPhone());
                        user.setPhone(shrUser.getPhone());
                     } else {
                        userChangeRecord.setPhone(user.getPhone());
                     }

                     if (user.getDeptCode() == null) {
                        Department department = deptByCodeMap.get(shrUser.getDeptCode());
                        Preconditions.checkArgument(department != null, shrUser.getUserName() + "对应的部门不存在,请联系管理人员!!!!");
                        Job job = jobByCodeMap.get(shrUser.getPositionCode());
                        Preconditions.checkArgument(job != null, user.getName() + "的岗位,在系统中不存在,如有疑问请联系管理人员!!!!");
                        Department department1 = deptMap.get(job.getDeptId());
                        Preconditions.checkArgument(department.getId().equals(department1.getId()), user.getName() + "当前岗位不适用于当前部门,如有疑问请联系管理人员!!!!");
                        userChangeRecord.setDeptName("- ->" + department.getName());
                        user.setDeptCode(shrUser.getDeptCode());
                        user.setDepartmentId(department.getId());
                     } else if (!user.getDeptCode().equals(shrUser.getDeptCode())) {
                        Department department = deptByCodeMap.get(shrUser.getDeptCode());
                        Preconditions.checkArgument(department != null, shrUser.getUserName() + "对应的部门不存在,请联系管理人员!!!!");
                        Job job = jobByCodeMap.get(shrUser.getPositionCode());
                        Preconditions.checkArgument(job != null, user.getName() + "的岗位,在系统中不存在,如有疑问请联系管理人员!!!!");
                        Department department1 = deptMap.get(job.getDeptId());
                        Preconditions.checkArgument(department.getId().equals(department1.getId()), user.getName() + "当前岗位不适用于当前部门,如有疑问请联系管理人员!!!!");
                        userChangeRecord.setDeptName(deptMap.get(user.getDepartmentId()).getName() + "->" + department.getName());
                        user.setDeptCode(shrUser.getDeptCode());
                        user.setDepartmentId(department.getId());
                     } else {
                        userChangeRecord.setDeptName(deptByCodeMap.get(user.getDeptCode()).getName());
                     }

                     if (user.getPositionCode() == null) {
                        Job job = jobByCodeMap.get(shrUser.getPositionCode());
                        Preconditions.checkArgument(job != null, user.getName() + "的岗位,在系统中不存在,如有疑问请联系管理人员!!!!");
                        Preconditions.checkArgument(
                           job.getOrgCode().equals(deptByCodeMap.get(user.getDeptCode()).getOrgCode()), user.getName() + "对应的岗位不属于该部门,请联系管理人员!!!!"
                        );
                        userChangeRecord.setJobName("- ->" + job.getName());
                        user.setJobId(job.getId());
                        user.setPositionCode(shrUser.getPositionCode());
                     } else if (!user.getPositionCode().equals(shrUser.getPositionCode())) {
                        Job job = jobByCodeMap.get(shrUser.getPositionCode());
                        Preconditions.checkArgument(job != null, user.getName() + "的岗位,在系统中不存在,如有疑问请联系管理人员!!!!");
                        Preconditions.checkArgument(
                           job.getOrgCode().equals(deptByCodeMap.get(user.getDeptCode()).getOrgCode()), user.getName() + "对应的岗位不属于该部门,请联系管理人员!!!!"
                        );
                        userChangeRecord.setJobName(jobByCodeMap.get(user.getPositionCode()).getName() + "->" + job.getName());
                        user.setJobId(job.getId());
                        user.setPositionCode(shrUser.getPositionCode());
                     } else {
                        userChangeRecord.setJobName(jobByCodeMap.get(user.getPositionCode()).getName());
                     }

                     this.shrUserChangeRecordService.save(userChangeRecord);
                  }

                  this.userService.updateById(user);
               } else {
                  user1.setIsEnabled(Boolean.TRUE);
                  user1.setEmail(shrUser.getEmail());
                  user1.setUserCode(shrUser.getUserCode());
                  if (!user1.getDeptCode().equals(shrUser.getDeptCode())
                     || !user1.getPositionCode().equals(shrUser.getPositionCode())
                     || !user1.getName().equals(shrUser.getUserName())
                     || !user1.getPhone().equals(shrUser.getPhone())) {
                     ShrUserChangeRecord userChangeRecord = ShrUserChangeRecord.builder()
                        .userType(UserTypeEnum.COMMON_USER.getType())
                        .crudType(CrudTypeEnum.UPDATE.getType())
                        .build();
                     if (!user1.getName().equals(shrUser.getUserName())) {
                        userChangeRecord.setName(user1.getName() + "->" + shrUser.getUserName());
                        user1.setName(shrUser.getUserName());
                     } else {
                        userChangeRecord.setName(user1.getName());
                     }

                     if (!user1.getPhone().equals(shrUser.getPhone())) {
                        User getUserByPhone = allUserMap.get(shrUser.getPhone());
                        Preconditions.checkArgument(getUserByPhone == null, shrUser.getUserName() + "人员的手机号:" + shrUser.getPhone() + "已经被注册如有疑问请联系管理人员!!!!");
                        userChangeRecord.setPhone(user1.getPhone() + "->" + shrUser.getPhone());
                        user1.setPhone(shrUser.getPhone());
                     } else {
                        userChangeRecord.setPhone(user1.getPhone());
                     }

                     if (!user1.getDeptCode().equals(shrUser.getDeptCode())) {
                        Department department = deptByCodeMap.get(shrUser.getDeptCode());
                        Preconditions.checkArgument(department != null, shrUser.getUserName() + "对应的部门不存在,请联系管理人员!!!!");
                        Job job = jobByCodeMap.get(shrUser.getPositionCode());
                        Preconditions.checkArgument(job != null, user1.getName() + "的岗位,在系统中不存在,如有疑问请联系管理人员!!!!");
                        Department department1 = deptMap.get(job.getDeptId());
                        Preconditions.checkArgument(department.getId().equals(department1.getId()), user1.getName() + "当前岗位不适用于当前部门,如有疑问请联系管理人员!!!!");
                        userChangeRecord.setDeptName(deptMap.get(user1.getDepartmentId()).getName() + "->" + department.getName());
                        user1.setDeptCode(shrUser.getDeptCode());
                        user1.setDepartmentId(department.getId());
                     } else {
                        userChangeRecord.setDeptName(deptByCodeMap.get(user1.getDeptCode()).getName());
                     }

                     if (!user1.getPositionCode().equals(shrUser.getPositionCode())) {
                        Job job = jobByCodeMap.get(shrUser.getPositionCode());
                        Preconditions.checkArgument(job != null, user1.getName() + "的岗位,在系统中不存在,如有疑问请联系管理人员!!!!");
                        Preconditions.checkArgument(
                           job.getOrgCode().equals(deptByCodeMap.get(user1.getDeptCode()).getOrgCode()), user1.getName() + "对应的岗位不属于该部门,请联系管理人员!!!!"
                        );
                        userChangeRecord.setJobName(jobByCodeMap.get(user1.getPositionCode()).getName() + "->" + job.getName());
                        user1.setJobId(job.getId());
                        user1.setPositionCode(shrUser.getPositionCode());
                     } else {
                        userChangeRecord.setJobName(jobByCodeMap.get(user1.getPositionCode()).getName());
                     }

                     this.shrUserChangeRecordService.save(userChangeRecord);
                  }

                  this.userService.updateById(user1);
               }
            }
         }
      );
      log.info("同步OA");
      List<User> collect = this.userService.list().stream().filter(item -> StringUtils.isNotBlank(item.getUserCode())).collect(Collectors.toList());
      String userCodes = collect.stream().map(User::getUserCode).collect(Collectors.joining(","));
   }

   private void disableExtraUsers(List<User> users, List<SHRUserInfoDTO> shrUserInfoDTO) {
      Set<String> shrUserCodes = shrUserInfoDTO.stream().map(SHRUserInfoDTO::getUserCode).collect(Collectors.toSet());

      for (User user : users) {
         if (!ObjectUtils.isNotEmpty(user.getDepartmentId()) || user.getDepartmentId() != 78L && user.getDepartmentId() != 47L && user.getDepartmentId() != 46L
            )
          {
            if (!shrUserCodes.contains(user.getUserCode()) && user.getIsEnabled() && user.getId() != 1L) {
               this.userBiz.changeUserDisable(user.getId(), false, null);
            }
         } else {
            user.setUserType(UserTypeEnum.LABOR_USER.getType());
            this.userService.updateById(user);
         }
      }
   }

   private void updateJob(Job job, SHRJobtitleInfoDTO shrJobTitle, Long departmentId) {
      job.setEnabled(EnableEnum.ENABLE.getType());
      job.setName(shrJobTitle.getPositionName());
      job.setOrgCode(shrJobTitle.getOrgCode());
      job.setPositionCode(shrJobTitle.getPositionCode());
      job.setDeptId(departmentId);
      job.setEnabled(EnableEnum.ENABLE.getType());
      this.jobService.updateById(job);
   }

   private void saveJob(SHRJobtitleInfoDTO shrJobTitle, Long departmentId) {
      Job aJob = new Job();
      aJob.setName(shrJobTitle.getPositionName());
      aJob.setOrgCode(shrJobTitle.getOrgCode());
      aJob.setPositionCode(shrJobTitle.getPositionCode());
      aJob.setEnabled(EnableEnum.ENABLE.getType());
      aJob.setDeptId(departmentId);
      aJob.setIsAdmin(1);
      aJob.setSort(1);
      this.jobService.save(aJob);
   }
}
