package com.hzchum.scim.common.core.service.impl.zhongnanoa;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.HttpUrlUtils;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.config.ZhongNanOaProperties;
import com.hzchum.scim.common.core.api.enums.EnableEnum;
import com.hzchum.scim.common.core.api.pojo._do.zhongnanoa.OaUserInfo;
import com.hzchum.scim.common.core.api.pojo.dto.oa.SHRDeptInfoDTO;
import com.hzchum.scim.common.core.api.pojo.dto.oa.SHRJobtitleInfoDTO;
import com.hzchum.scim.common.core.api.pojo.dto.oa.SHRUserInfoDTO;
import com.hzchum.scim.common.core.api.pojo.dto.oa.ZhongNanUserInfoDTO;
import com.hzchum.scim.common.core.api.service.zhongnanoa.ShrPersonnelOrganizationServier;
import com.hzchum.scim.common.core.api.utils.oa.RSA;
import com.hzchum.scim.common.core.mapper.zhongnanoa.OaUserInfoMapper;
import com.hzchum.scim.system.core.api.common.enums.CrudTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.DeptAndJobTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.UserTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.notification.NotificationModuleTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.notification.MessagePushUtil;
import com.hzchum.scim.system.core.api.common.utils.notification.NotificationTemplateDetailsUtils;
import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.pojo._do.Job;
import com.hzchum.scim.system.core.api.pojo._do.ShrUserChangeRecord;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.JobService;
import com.hzchum.scim.system.core.api.service.ShrUserChangeRecordService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.system.core.biz.impl.UserBizImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShrPersonnelOrganizationServierImpl extends ServiceImpl<OaUserInfoMapper, OaUserInfo> implements ShrPersonnelOrganizationServier {
   private static final Logger log = LoggerFactory.getLogger(ShrPersonnelOrganizationServierImpl.class);
   @Value("${zhongnan.shr.host:}")
   private String shrHost;
   private final String CONTENT_TYPE = "application/json";
   @Resource
   private ZhongNanOaProperties oaProperties;
   @Resource
   private DepartmentService departmentService;
   @Resource
   private JobService jobService;
   @Resource
   private UserService userService;
   @Resource
   private PasswordEncoder encoder;
   @Resource
   private UserBizImpl userBiz;
   @Resource
   private ShrUserChangeRecordService shrUserChangeRecordService;
   @Resource
   private MessagePushUtil messagePushUtil;
   @Resource
   private NotificationTemplateDetailsUtils detailsUtils;

   @Override
   public ResultVO syncSHRDept() {
      List<Department> departments = this.departmentService
         .list(Wrappers.lambdaQuery(Department.class).eq(Department::getDeptType, DeptAndJobTypeEnum.ESTABLISHMENT_INSIDE.getType()));
      HttpRequest request = HttpRequest.post(this.shrEndpoint("/shr/resful/orgList")).body(JSON.toJSONString(new Object()));
      JSONObject jsonObject = JSONObject.parseObject(request.execute().body());
      List<SHRDeptInfoDTO> shrDeptInfoDTOS = JSONArray.parseArray(jsonObject.getString("data"), SHRDeptInfoDTO.class);
      this.requireSyncRows(shrDeptInfoDTOS, "部门");
      log.info("获取SHR部门数据，数量={}", shrDeptInfoDTOS.size());
      this.syncSHR(shrDeptInfoDTOS, departments);
      return ResultBuilder.success("同步成功");
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

   @Override
   public ResultVO syncSHRJob() {
      HttpRequest request = HttpRequest.post(this.shrEndpoint("/shr/resful/positionList")).body(JSON.toJSONString(new Object()));
      JSONObject jsonObject = JSONObject.parseObject(new String(request.execute().body()));
      List<SHRJobtitleInfoDTO> shrJobtitleInfoDTO = JSONArray.parseArray(jsonObject.getString("data"), SHRJobtitleInfoDTO.class);
      this.requireSyncRows(shrJobtitleInfoDTO, "岗位");
      log.info("获取SHR岗位数据，数量={}", shrJobtitleInfoDTO.size());
      List<Job> jobs = this.jobService.list(Wrappers.lambdaQuery(Job.class).eq(Job::getJobType, DeptAndJobTypeEnum.ESTABLISHMENT_INSIDE.getType()));
      log.info("同步 SHR 系统的岗位到初鸣系统");
      this.syncJobs(shrJobtitleInfoDTO, jobs);
      List<Job> newjobs = this.jobService.list(Wrappers.lambdaQuery(Job.class).eq(Job::getJobType, DeptAndJobTypeEnum.ESTABLISHMENT_INSIDE.getType()));
      log.info("禁用初鸣系统中多余的岗位");
      this.disableExtraJobs(newjobs, shrJobtitleInfoDTO);
      return ResultBuilder.success("同步成功");
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

   @Override
   public ResultVO syncSHRUser() {
      HttpRequest request = HttpRequest.post(this.shrEndpoint("/shr/resful/userList")).body(JSON.toJSONString(new Object()));
      JSONObject jsonObject = JSONObject.parseObject(new String(request.execute().body()));
      List<SHRUserInfoDTO> shrUserInfoDTO = JSONArray.parseArray(jsonObject.getString("data"), SHRUserInfoDTO.class);
      this.requireSyncRows(shrUserInfoDTO, "人员");
      log.info("获取SHR人员数据，数量={}", shrUserInfoDTO.size());
      List<User> users = this.userService.list();
      log.info("同步 SHR 系统的岗位到 A 系统");
      this.syncUser(shrUserInfoDTO, users);
      log.info("禁用初鸣系统中多余的岗位");
      this.disableExtraUsers(this.userService.list(Wrappers.lambdaQuery(User.class).eq(User::getUserType, UserTypeEnum.COMMON_USER.getType())), shrUserInfoDTO);
      return ResultBuilder.success("同步成功");
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
      List<ShrUserChangeRecord> allChangeRecords = new ArrayList<>();
      shrUserInfoDTO.forEach(
         shrUser -> {
            Preconditions.checkArgument(shrUser.getUserCode() != null, "人员SHR编号未传入!!!!");
            if (!shrUser.getUserCode().equals("005692") && shrUser.getAssignType() != null && shrUser.getAssignType().equals(1)) {
               User user = codeUserMap.get("A" + shrUser.getUserCode());
               User user1 = codeUserMap2.get(shrUser.getUserCode());
               ShrUserChangeRecord finalRecord = null;
               if (user == null && user1 == null) {
                  User getUserByPhone = allUserMap.get(shrUser.getPhone());
                  if (getUserByPhone == null) {
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
                        .departmentId(department.getId())
                        .positionCode(shrUser.getPositionCode())
                        .deptCode(shrUser.getDeptCode())
                        .userCode(shrUser.getUserCode())
                        .isEnabled(true)
                        .build();
                     if (shrUser.getGender() != null) {
                        Integer integer = Integer.getInteger(shrUser.getGender());
                        if (integer != null) {
                           newUser.setSex(integer == 2 ? 1 : 0);
                        }
                     }

                     this.userService.save(newUser);
                     ShrUserChangeRecord shrUserChangeRecord = ShrUserChangeRecord.builder()
                        .deptName(
                           ObjectUtils.isNotEmpty(newUser.getDepartmentId()) ? this.departmentService.getById(newUser.getDepartmentId()).getName() : null
                        )
                        .jobName(ObjectUtils.isNotEmpty(newUser.getJobId()) ? this.jobService.getById(newUser.getJobId()).getName() : null)
                        .name(newUser.getName())
                        .phone(newUser.getPhone())
                        .userType(UserTypeEnum.COMMON_USER.getType())
                        .crudType(CrudTypeEnum.SAVE.getType())
                        .build();
                     this.shrUserChangeRecordService.save(shrUserChangeRecord);
                     finalRecord = shrUserChangeRecord;
                  } else {
                     getUserByPhone.setUserType(UserTypeEnum.COMMON_USER.getType());
                     getUserByPhone.setIsEnabled(Boolean.TRUE);
                     getUserByPhone.setEmail(shrUser.getEmail());
                     getUserByPhone.setUserCode(shrUser.getUserCode());
                     if (shrUser.getGender() != null) {
                        Integer integer = Integer.getInteger(shrUser.getGender());
                        if (integer != null) {
                           getUserByPhone.setSex(integer == 2 ? 1 : 0);
                        }
                     }

                     if (getUserByPhone.getDeptCode() == null
                        || !getUserByPhone.getDeptCode().equals(shrUser.getDeptCode())
                        || getUserByPhone.getPositionCode() == null
                        || !getUserByPhone.getPositionCode().equals(shrUser.getPositionCode())
                        || !getUserByPhone.getName().equals(shrUser.getUserName())
                        || !getUserByPhone.getPhone().equals(shrUser.getPhone())) {
                        ShrUserChangeRecord userChangeRecord = ShrUserChangeRecord.builder()
                           .userType(UserTypeEnum.COMMON_USER.getType())
                           .crudType(CrudTypeEnum.UPDATE.getType())
                           .build();
                        if (!getUserByPhone.getName().equals(shrUser.getUserName())) {
                           userChangeRecord.setName(getUserByPhone.getName() + "->" + shrUser.getUserName());
                           getUserByPhone.setName(shrUser.getUserName());
                        } else {
                           userChangeRecord.setName(getUserByPhone.getName());
                        }

                        if (getUserByPhone.getDeptCode() == null) {
                           Department department = deptByCodeMap.get(shrUser.getDeptCode());
                           Preconditions.checkArgument(department != null, shrUser.getUserName() + "对应的部门不存在,请联系管理人员!!!!");
                           Job job = jobByCodeMap.get(shrUser.getPositionCode());
                           Preconditions.checkArgument(job != null, getUserByPhone.getName() + "的岗位,在系统中不存在,如有疑问请联系管理人员!!!!");
                           Department department1 = deptMap.get(job.getDeptId());
                           Preconditions.checkArgument(
                              department.getId().equals(department1.getId()), getUserByPhone.getName() + "当前岗位不适用于当前部门,如有疑问请联系管理人员!!!!"
                           );
                           userChangeRecord.setDeptName("- ->" + department.getName());
                           getUserByPhone.setDeptCode(shrUser.getDeptCode());
                           getUserByPhone.setDepartmentId(department.getId());
                        } else if (!getUserByPhone.getDeptCode().equals(shrUser.getDeptCode())) {
                           Department department = deptByCodeMap.get(shrUser.getDeptCode());
                           Preconditions.checkArgument(department != null, shrUser.getUserName() + "对应的部门不存在,请联系管理人员!!!!");
                           Job job = jobByCodeMap.get(shrUser.getPositionCode());
                           Preconditions.checkArgument(job != null, getUserByPhone.getName() + "的岗位,在系统中不存在,如有疑问请联系管理人员!!!!");
                           Department department1 = deptMap.get(job.getDeptId());
                           Preconditions.checkArgument(
                              department.getId().equals(department1.getId()), getUserByPhone.getName() + "当前岗位不适用于当前部门,如有疑问请联系管理人员!!!!"
                           );
                           userChangeRecord.setDeptName(deptMap.get(getUserByPhone.getDepartmentId()).getName() + "->" + department.getName());
                           getUserByPhone.setDeptCode(shrUser.getDeptCode());
                           getUserByPhone.setDepartmentId(department.getId());
                        } else {
                           userChangeRecord.setDeptName(deptByCodeMap.get(getUserByPhone.getDeptCode()).getName());
                        }

                        if (getUserByPhone.getPositionCode() == null) {
                           Job job = jobByCodeMap.get(shrUser.getPositionCode());
                           Preconditions.checkArgument(job != null, getUserByPhone.getName() + "的岗位,在系统中不存在,如有疑问请联系管理人员!!!!");
                           Preconditions.checkArgument(
                              job.getOrgCode().equals(deptByCodeMap.get(getUserByPhone.getDeptCode()).getOrgCode()),
                              getUserByPhone.getName() + "对应的岗位不属于该部门,请联系管理人员!!!!"
                           );
                           userChangeRecord.setJobName("- ->" + job.getName());
                           getUserByPhone.setJobId(job.getId());
                           getUserByPhone.setPositionCode(shrUser.getPositionCode());
                        } else if (!getUserByPhone.getPositionCode().equals(shrUser.getPositionCode())) {
                           Job job = jobByCodeMap.get(shrUser.getPositionCode());
                           Preconditions.checkArgument(job != null, getUserByPhone.getName() + "的岗位,在系统中不存在,如有疑问请联系管理人员!!!!");
                           Preconditions.checkArgument(
                              job.getOrgCode().equals(deptByCodeMap.get(getUserByPhone.getDeptCode()).getOrgCode()),
                              getUserByPhone.getName() + "对应的岗位不属于该部门,请联系管理人员!!!!"
                           );
                           userChangeRecord.setJobName(jobByCodeMap.get(getUserByPhone.getPositionCode()).getName() + "->" + job.getName());
                           getUserByPhone.setJobId(job.getId());
                           getUserByPhone.setPositionCode(shrUser.getPositionCode());
                        } else {
                           userChangeRecord.setJobName(jobByCodeMap.get(getUserByPhone.getPositionCode()).getName());
                        }

                        this.shrUserChangeRecordService.save(userChangeRecord);
                        finalRecord = userChangeRecord;
                     }

                     this.userService.updateById(getUserByPhone);
                  }
               } else if (user != null) {
                  user.setIsEnabled(Boolean.TRUE);
                  user.setEmail(shrUser.getEmail());
                  user.setUserCode(shrUser.getUserCode());
                  if (shrUser.getGender() != null) {
                     Integer integer = Integer.getInteger(shrUser.getGender());
                     if (integer != null) {
                        user.setSex(integer == 2 ? 1 : 0);
                     }
                  }

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
                     finalRecord = userChangeRecord;
                  }

                  this.userService.updateById(user);
               } else {
                  user1.setIsEnabled(Boolean.TRUE);
                  user1.setEmail(shrUser.getEmail());
                  user1.setUserCode(shrUser.getUserCode());
                  if (shrUser.getGender() != null) {
                     Integer integer = Integer.getInteger(shrUser.getGender());
                     if (integer != null) {
                        user1.setSex(integer == 2 ? 1 : 0);
                     }
                  }

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
                     finalRecord = userChangeRecord;
                  }

                  this.userService.updateById(user1);
               }

               if (finalRecord != null) {
                  allChangeRecords.add(finalRecord);
               }
            }
         }
      );
      log.info("需推送人员信息：allChangeRecords = " + allChangeRecords);
      allChangeRecords.forEach(
         finalRecord -> this.messagePushUtil
            .sendDingTalkMessage(
               this.detailsUtils.getShrChangeDetails(finalRecord).toString(), NotificationModuleTypeEnum.SHR_UPDATE_PUSH.getNotificationType(), null
            )
      );
      log.info("同步OA");
      List<User> collect = this.userService.list().stream().filter(item -> StringUtils.isNotBlank(item.getUserCode())).collect(Collectors.toList());
      String userCodes = collect.stream().map(User::getUserCode).collect(Collectors.joining(","));
      JSONObject jsonUser = JSONObject.parseObject(this.getHrmUserInfoWithPage("", userCodes));
      log.info("OA 返回人员id等信息：" + jsonUser);
      List<ZhongNanUserInfoDTO> userInfos = JSONObject.parseArray(
         JSONObject.parseObject(jsonUser.getString("data")).getString("dataList"), ZhongNanUserInfoDTO.class
      );
      collect.forEach(item -> {
         List<ZhongNanUserInfoDTO> newUserInfo = userInfos.stream().filter(user -> user.getWorkcode().equals(item.getUserCode())).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(newUserInfo)) {
            item.setOaUserId(Long.parseLong(newUserInfo.get(0).getId()));
            item.setOaDeptId(Long.parseLong(newUserInfo.get(0).getDepartmentid()));
            item.setOaSubDeptId(Long.parseLong(newUserInfo.get(0).getSubcompanyid1()));
            item.setOaSubDeptName(newUserInfo.get(0).getSubcompanyname());
            this.userService.updateById(item);
         }
      });
   }

   private void disableExtraUsers(List<User> users, List<SHRUserInfoDTO> shrUserInfoDTO) {
      Set<String> shrUserCodes = shrUserInfoDTO.stream().map(SHRUserInfoDTO::getUserCode).collect(Collectors.toSet());

      for (User user : users) {
         if (!ObjectUtils.isNotEmpty(user.getDepartmentId()) || user.getDepartmentId() != 78L && user.getDepartmentId() != 47L && user.getDepartmentId() != 46L
            )
          {
            if (!shrUserCodes.contains(user.getUserCode()) && user.getIsEnabled()) {
               this.userBiz.changeUserDisable(user.getId(), false, Boolean.FALSE);
            }
         } else {
            user.setUserType(UserTypeEnum.LABOR_USER.getType());
            this.userService.updateById(user);
         }
      }
   }

   public String getHrmUserInfoWithPage(String subcompanyid1, String workcode) {
      Map<String, Object> paramsMap = new HashMap<>();
      Map<String, Object> params = new HashMap<>();
      if (StringUtils.isNotBlank(subcompanyid1)) {
         params.put("subcompanyid1", subcompanyid1);
      }

      if (StringUtils.isNotBlank(workcode)) {
         params.put("workcode", workcode);
      }

      params.put("curpage", 1);
      params.put("pagesize", Integer.MAX_VALUE);
      paramsMap.put("params", params);
      log.info("调用：getHrmUserInfoWithPage:" + JSON.toJSONString(paramsMap));
      return HttpUrlUtils.doPostWithParamHeader(
         this.oaProperties.getHost() + "/api/hrm/resful/getHrmUserInfoWithPage",
         null,
         this.getHeaderMap(null),
         JSON.toJSONString(paramsMap),
         "application/json"
      );
   }

   private Map getHeaderMap(String userId) {
      Map<String, String> HeaderMap = new HashMap<>();
      HeaderMap.put("appid", this.oaProperties.getAppId());
      HeaderMap.put("secret", this.encrypt(this.oaProperties.getSecret()));
      HeaderMap.put("token", this.getToken());
      HeaderMap.put("userid", this.encrypt(userId != null ? userId : "1"));
      return HeaderMap;
   }

   private String shrEndpoint(String path) {
      Preconditions.checkArgument(StringUtils.isNotBlank(this.shrHost), "请先配置SHR测试服务地址 zhongnan.shr.host");
      String host = this.shrHost.trim().replaceAll("/+$", "");
      java.net.URI uri;
      try {
         uri = java.net.URI.create(host);
      } catch (IllegalArgumentException error) {
         throw new IllegalArgumentException("SHR服务地址格式无效");
      }
      Preconditions.checkArgument(("https".equalsIgnoreCase(uri.getScheme()) || "http".equalsIgnoreCase(uri.getScheme()))
         && uri.getHost() != null && uri.getUserInfo() == null && uri.getQuery() == null && uri.getFragment() == null,
         "SHR服务地址必须是无账号、查询参数和片段的HTTP(S)地址");
      return host + path;
   }

   private void requireSyncRows(List<?> rows, String kind) {
      // An empty/error response must not be interpreted as a full organization deletion.
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(rows), "SHR未返回有效" + kind + "数据，已停止同步，保留本地记录");
   }

   public String getToken() {
      Map<String, String> map = new HashMap<>();
      String encrypt = this.encrypt(this.oaProperties.getSecret());
      map.put("appid", this.oaProperties.getAppId());
      map.put("secret", encrypt);
      String tokenJson = HttpUrlUtils.doPostWithParamHeader(this.oaProperties.getHost() + "/api/ec/dev/auth/applytoken", null, map, null, "application/json");
      JSONObject tokenJsonObject = JSON.parseObject(tokenJson);
      log.info("当前状态码： " + tokenJsonObject.getString("code"));
      if (0 == tokenJsonObject.getInteger("code")) {
         log.info("获取成功");
         return tokenJsonObject.getString("token");
      } else {
         return tokenJson;
      }
   }

   private String encrypt(String data) {
      RSA rsa = new RSA();
      return rsa.encrypt(null, data, null, "utf-8", this.oaProperties.getSpk(), false);
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
