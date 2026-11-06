package com.hzchum.scim.rest.controller.zhongnanoa;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.enums.EnableEnum;
import com.hzchum.scim.common.core.api.pojo.dto.oa.SHRDeptInfoDTO;
import com.hzchum.scim.common.core.api.pojo.dto.oa.SHRJobtitleInfoDTO;
import com.hzchum.scim.common.core.api.pojo.dto.oa.SHRUserInfoDTO;
import com.hzchum.scim.common.core.api.pojo.dto.oa.ZhongNanUserInfoDTO;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingInspectionTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamUserLinkService;
import com.hzchum.scim.system.core.api.common.enums.UserTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.pojo._do.Job;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.JobService;
import com.hzchum.scim.system.core.api.service.UserService;
import io.swagger.annotations.Api;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "SHR远程调用")
@RestController
@RequestMapping("/api/shr/call/test")
public class TestSHRPersonnelOrganizationDemo {
   private static final Logger log = LoggerFactory.getLogger(TestSHRPersonnelOrganizationDemo.class);
   private static final String AUTHORIZATION = System.getenv("LJAPS_OA_DEMO_AUTHORIZATION");
   @Resource
   private DepartmentService departmentService;
   @Resource
   private JobService jobService;
   @Resource
   private UserService userService;
   @Resource
   private PasswordEncoder encoder;
   @Resource
   private MesBuildingTeamUserLinkService teamUserLinkService;
   @Resource
   private MesBuildingInspectionTeamUserLinkService inspectionTeamUserLinkService;

   @GetMapping("/syncSHRDept")
   public ResultVO syncSHRDept() {
      List<Department> departments = this.departmentService.list();
      HttpRequest request = HttpRequest.post("http://122.224.88.14:7500/shr/resful/orgList").body(JSON.toJSONString(new Object()));
      JSONObject jsonObject = JSONObject.parseObject(new String(request.execute().body()));
      List<SHRDeptInfoDTO> shrDeptInfoDTOS = JSONArray.parseArray(jsonObject.getString("data"), SHRDeptInfoDTO.class);
      this.syncSHR(shrDeptInfoDTOS, departments);
      return ResultBuilder.success("同步成功");
   }

   private void syncSHR(List<SHRDeptInfoDTO> shrDepts, List<Department> departmentTrees) {
      this.syncSHRToADepartments(shrDepts, departmentTrees);
      List<Department> departments = this.departmentService.list();
      this.markUnusedDepartmentsAsDisabled(shrDepts, departments);
   }

   @Transactional(rollbackFor = Exception.class)
   public void syncSHRToADepartments(List<SHRDeptInfoDTO> shrDeptTree, List<Department> aDeptTree) {
      List<SHRDeptInfoDTO> multipleCreation = new ArrayList<>();

      for (SHRDeptInfoDTO shrDept : shrDeptTree) {
         List<Department> dept = aDeptTree.stream().filter(d -> d.getName().equals(shrDept.getOrgName())).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(dept)) {
            if (dept.size() == 1) {
               Department byId = this.departmentService.getById(dept.get(0).getId());
               if (!"浙江中南绿建科技集团有限公司".equals(shrDept.getOrgName())) {
                  Department one1 = this.departmentService.getOne(Wrappers.lambdaQuery(Department.class).in(Department::getId, byId.getPid()));
                  Department one = this.departmentService.getOne(Wrappers.lambdaQuery(Department.class).in(Department::getOrgCode, shrDept.getParentOrgCode()));
                  if (!one1.getName().equals(shrDept.getParentOrgName())) {
                     Department newDept = new Department();
                     newDept.setName(shrDept.getOrgName());
                     newDept.setOrgCode(shrDept.getOrgCode());
                     newDept.setParentOrgCode(shrDept.getParentOrgCode());
                     newDept.setPid(one.getId());
                     newDept.setStatus(EnableEnum.ENABLE.getType());
                     this.departmentService.save(newDept);
                     continue;
                  }

                  byId.setPid(one.getId());
               }

               byId.setOrgCode(shrDept.getOrgCode());
               byId.setParentOrgCode(shrDept.getParentOrgCode());
               byId.setStatus(EnableEnum.ENABLE.getType());
               this.departmentService.updateById(byId);
            } else {
               List<Long> pids = dept.stream().map(item -> item.getPid()).collect(Collectors.toList());
               List<Department> list = this.departmentService.list(Wrappers.lambdaQuery(Department.class).in(Department::getId, pids));
               List<String> names = list.stream().map(item -> item.getName()).collect(Collectors.toList());
               if (names.contains(shrDept.getParentOrgName())) {
                  list.forEach(item -> {
                     if (item.getName().equals(shrDept.getParentOrgName())) {
                        List<Department> updateDepts = this.departmentService.list(Wrappers.lambdaQuery(Department.class).eq(Department::getPid, item.getId()));
                        Department updateDept = updateDepts.stream().filter(x -> x.getName().equals(shrDept.getOrgName())).collect(Collectors.toList()).get(0);
                        updateDept.setOrgCode(shrDept.getOrgCode());
                        updateDept.setParentOrgCode(shrDept.getParentOrgCode());
                        updateDept.setStatus(EnableEnum.ENABLE.getType());
                        this.departmentService.updateById(updateDept);
                     }
                  });
               } else {
                  Department one = this.departmentService.getOne(Wrappers.lambdaQuery(Department.class).eq(Department::getName, shrDept.getParentOrgName()));
                  if (ObjectUtils.isNotEmpty(one)) {
                     Department newDept = new Department();
                     newDept.setName(shrDept.getOrgName());
                     newDept.setOrgCode(shrDept.getOrgCode());
                     newDept.setParentOrgCode(shrDept.getParentOrgCode());
                     newDept.setPid(one.getId());
                     newDept.setStatus(EnableEnum.ENABLE.getType());
                     this.departmentService.save(newDept);
                  }
               }
            }
         } else {
            Department newDept = new Department();
            newDept.setName(shrDept.getOrgName());
            newDept.setOrgCode(shrDept.getOrgCode());
            newDept.setParentOrgCode(shrDept.getParentOrgCode());
            Department one = this.departmentService.getOne(Wrappers.lambdaQuery(Department.class).eq(Department::getOrgCode, shrDept.getParentOrgCode()));
            if (ObjectUtils.isNotEmpty(one)) {
               newDept.setPid(one.getId());
               newDept.setStatus(EnableEnum.ENABLE.getType());
               this.departmentService.save(newDept);
            } else {
               multipleCreation.add(shrDept);
            }
         }
      }

      if (CollectionUtils.isNotEmpty(multipleCreation)) {
         this.syncSHRToADepartments(multipleCreation, aDeptTree);
      }
   }

   private void markUnusedDepartmentsAsDisabled(List<SHRDeptInfoDTO> SHRDeptTree, List<Department> aDeptTree) {
      Set<String> shrDeptCodes = SHRDeptTree.stream().map(SHRDeptInfoDTO::getOrgCode).collect(Collectors.toSet());

      for (Department dept : aDeptTree) {
         if (!shrDeptCodes.contains(dept.getOrgCode())) {
            Department byId = this.departmentService.getById(dept.getId());
            byId.setStatus(EnableEnum.DISABLE.getType());
            this.departmentService.updateById(byId);
         }
      }
   }

   @GetMapping("/syncSHRJob")
   public ResultVO syncSHRJob() {
      HttpRequest request = HttpRequest.post("http://122.224.88.14:7500/shr/resful/positionList").body(JSON.toJSONString(new Object()));
      JSONObject jsonObject = JSONObject.parseObject(new String(request.execute().body()));
      List<SHRJobtitleInfoDTO> shrJobtitleInfoDTO = JSONArray.parseArray(jsonObject.getString("data"), SHRJobtitleInfoDTO.class);
      List<Job> jobs = this.jobService.list();
      this.syncJobs(shrJobtitleInfoDTO, jobs);
      List<Job> newjobs = this.jobService.list();
      this.disableExtraJobs(newjobs, shrJobtitleInfoDTO);
      return ResultBuilder.success("同步成功");
   }

   @Transactional(rollbackFor = Exception.class)
   public void syncJobs(List<SHRJobtitleInfoDTO> shrJobTitles, List<Job> jobs) {
      for (SHRJobtitleInfoDTO shrJobTitle : shrJobTitles) {
         List<Job> jobList = jobs.stream().filter(item -> item.getName().equals(shrJobTitle.getPositionName())).collect(Collectors.toList());
         Department department = this.departmentService.getOne(Wrappers.lambdaQuery(Department.class).in(Department::getOrgCode, shrJobTitle.getOrgCode()));
         if (ObjectUtils.isNotEmpty(department)) {
            if (CollectionUtils.isEmpty(jobList)) {
               this.saveJob(shrJobTitle, department.getId());
            } else if (jobList.size() == 1) {
               Job job = jobList.get(0);
               if (job.getDeptId() == department.getId()) {
                  this.updateJob(job, shrJobTitle, department.getId());
               } else {
                  this.saveJob(shrJobTitle, department.getId());
               }
            } else {
               List<Job> updateJobs = jobList.stream().filter(item -> item.getDeptId().equals(department.getId())).collect(Collectors.toList());
               if (CollectionUtils.isNotEmpty(updateJobs)) {
                  List<Job> jobStream = updateJobs.stream().filter(item -> StringUtils.isBlank(item.getPositionCode())).collect(Collectors.toList());
                  if (CollectionUtils.isNotEmpty(jobStream)) {
                     this.updateJob(jobStream.get(0), shrJobTitle, department.getId());
                  }
               } else {
                  this.saveJob(shrJobTitle, department.getId());
               }
            }
         }
      }
   }

   private void disableExtraJobs(List<Job> aSystemJobs, List<SHRJobtitleInfoDTO> shrJobTitles) {
      Set<String> shrJobPositionCodes = shrJobTitles.stream().map(SHRJobtitleInfoDTO::getPositionCode).collect(Collectors.toSet());

      for (Job aJob : aSystemJobs) {
         if (!shrJobPositionCodes.contains(aJob.getPositionCode())) {
            aJob.setEnabled(EnableEnum.DISABLE.getType());
            this.jobService.updateById(aJob);
         }
      }
   }

   @GetMapping("/syncSHRUser")
   public ResultVO syncSHRUser() {
      HttpRequest request = HttpRequest.post("http://122.224.88.14:7500/shr/resful/userList").body(JSON.toJSONString(new Object()));
      JSONObject jsonObject = JSONObject.parseObject(new String(request.execute().body()));
      List<SHRUserInfoDTO> shrUserInfoDTO = JSONArray.parseArray(jsonObject.getString("data"), SHRUserInfoDTO.class);
      List<User> users = this.userService.list();
      this.syncUser(shrUserInfoDTO, users);
      this.disableExtraUsers(this.userService.list(), shrUserInfoDTO);
      return ResultBuilder.success("同步成功");
   }

   @Transactional(rollbackFor = Exception.class)
   public void syncUser(List<SHRUserInfoDTO> shrUserInfoDTO, List<User> users) {
      for (SHRUserInfoDTO shrUserTitle : shrUserInfoDTO) {
         List<User> userList = users.stream().filter(item -> item.getPhone().equals(shrUserTitle.getPhone())).collect(Collectors.toList());
         Department department = this.departmentService.getOne(Wrappers.lambdaQuery(Department.class).eq(Department::getOrgCode, shrUserTitle.getDeptCode()));
         List<Job> job = this.jobService.list(Wrappers.lambdaQuery(Job.class).eq(Job::getPositionCode, shrUserTitle.getPositionCode()));
         if (CollectionUtils.isEmpty(userList)) {
            if (ObjectUtils.isNotEmpty(department) && CollectionUtils.isNotEmpty(job)) {
               User user = User.builder()
                  .name(shrUserTitle.getUserName())
                  .username("A" + shrUserTitle.getUserCode())
                  .phone(shrUserTitle.getPhone())
                  .jobId(job.get(0).getId())
                  .password(this.encoder.encode(java.util.Objects.requireNonNull(System.getenv("LJAPS_INITIAL_USER_PASSWORD"), "LJAPS_INITIAL_USER_PASSWORD is required")))
                  .email(shrUserTitle.getEmail())
                  .isEnabled(true)
                  .userType(UserTypeEnum.COMMON_USER.getType())
                  .sex(Integer.getInteger(shrUserTitle.getGender()))
                  .departmentId(department.getId())
                  .positionCode(shrUserTitle.getPositionCode())
                  .deptCode(shrUserTitle.getDeptCode())
                  .userCode(shrUserTitle.getUserCode())
                  .isEnabled(true)
                  .build();
               this.userService.save(user);
            }
         } else if (ObjectUtils.isNotEmpty(department) && ObjectUtils.isNotEmpty(job)) {
            userList.forEach(userx -> {
               userx.setJobId(ObjectUtils.isNotEmpty(userx.getJobId()) ? userx.getJobId() : job.get(0).getId());
               userx.setDepartmentId(ObjectUtils.isNotEmpty(userx.getDepartmentId()) ? userx.getDepartmentId() : department.getId());
               userx.setPositionCode(shrUserTitle.getPositionCode());
               userx.setDeptCode(shrUserTitle.getDeptCode());
               userx.setUserCode(shrUserTitle.getUserCode());
               userx.setIsEnabled(true);
               this.userService.updateById(userx);
            });
         }
      }

      List<User> collect = this.userService.list().stream().filter(item -> StringUtils.isNotBlank(item.getUserCode())).collect(Collectors.toList());
      String userCodes = collect.stream().map(User::getUserCode).collect(Collectors.joining(","));
      HttpRequest requestUser = HttpRequest.get(
            String.format("http://123.157.218.70:6006/api/oa/call/getHrmUserInfoWithPage?subcompanyid1=%s&workcode=%s", "", userCodes)
         )
         .header(
            "Authorization",
            System.getenv("LJAPS_OA_DEMO_AUTHORIZATION")
         );
      JSONObject jsonUser = JSONObject.parseObject(new String(requestUser.execute().body()));
      List<ZhongNanUserInfoDTO> userInfos = JSONObject.parseArray(
         JSONObject.parseObject(jsonUser.getString("data")).getString("dataList"), ZhongNanUserInfoDTO.class
      );
      collect.forEach(
         item -> {
            List<ZhongNanUserInfoDTO> newUserInfo = userInfos.stream()
               .filter(userx -> userx.getWorkcode().equals(item.getUserCode()))
               .collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(newUserInfo)) {
               item.setOaUserId(Long.parseLong(newUserInfo.get(0).getId()));
               item.setOaDeptId(Long.parseLong(newUserInfo.get(0).getDepartmentid()));
               item.setOaSubDeptId(Long.parseLong(newUserInfo.get(0).getSubcompanyid1()));
               item.setOaSubDeptName(newUserInfo.get(0).getSubcompanyname());
               this.userService.updateById(item);
            }
         }
      );
   }

   private void disableExtraUsers(List<User> users, List<SHRUserInfoDTO> shrUserInfoDTO) {
      Set<String> shrUserCodes = shrUserInfoDTO.stream().map(SHRUserInfoDTO::getUserCode).collect(Collectors.toSet());

      for (User user : users) {
         if (!shrUserCodes.contains(user.getUserCode())) {
            user.setIsEnabled(false);
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
