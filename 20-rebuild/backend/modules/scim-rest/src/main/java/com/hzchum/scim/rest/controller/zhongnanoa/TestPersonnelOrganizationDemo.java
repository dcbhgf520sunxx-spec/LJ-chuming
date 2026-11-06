package com.hzchum.scim.rest.controller.zhongnanoa;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.oa.OaUserStatusEnum;
import com.hzchum.scim.common.core.api.pojo.dto.oa.ZhongNanDeptInfoDTO;
import com.hzchum.scim.common.core.api.pojo.dto.oa.ZhongNanJobtitleInfoDTO;
import com.hzchum.scim.common.core.api.pojo.dto.oa.ZhongNanSegmentInfoDTO;
import com.hzchum.scim.common.core.api.pojo.dto.oa.ZhongNanUserInfoDTO;
import com.hzchum.scim.common.core.api.pojo.dto.oa.ZhongNanWorkFlowDTO;
import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.pojo._do.Job;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.DepartmentTree;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.JobService;
import com.hzchum.scim.system.core.api.service.UserService;
import io.swagger.annotations.Api;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "远程调用")
@RestController
@RequestMapping("/api/oa/call/test")
public class TestPersonnelOrganizationDemo {
   private static final Logger log = LoggerFactory.getLogger(TestPersonnelOrganizationDemo.class);
   private static String authorization() {
      String value = System.getenv("LJAPS_OA_DEMO_AUTHORIZATION");
      if (value == null || value.trim().isEmpty()) throw new IllegalStateException("LJAPS_OA_DEMO_AUTHORIZATION is required for explicit demo requests");
      return value;
   }
   @Resource
   private DepartmentService departmentService;
   @Resource
   private JobService jobService;
   @Resource
   private UserService userService;
   @Resource
   private PasswordEncoder encoder;

   public static void main(String[] args) throws JsonProcessingException {
      HttpRequest request = HttpRequest.get(
            String.format("http://123.157.218.70:6006/api/oa/call/getHrmdepartmentWithPage?subcompanyid1=%s&departmentcode=%s", "", "000606")
         )
         .header(
            "Authorization",
            authorization()
         );
      JSONObject jsonObject = JSONObject.parseObject(new String(request.execute().body()));
      List<ZhongNanDeptInfoDTO> deptInfoDTOS = JSONObject.parseArray(
         JSONObject.parseObject(jsonObject.getString("data")).getString("dataList"), ZhongNanDeptInfoDTO.class
      );
      log.info(deptInfoDTOS.toString());
      HttpRequest requestUser = HttpRequest.get(
            String.format("http://123.157.218.70:6006/api/oa/call/getHrmUserInfoWithPage?subcompanyid1=%s&workcode=%s", "", "001504,002881,000773")
         )
         .header(
            "Authorization",
            authorization()
         );
      JSONObject jsonUser = JSONObject.parseObject(new String(requestUser.execute().body()));
      List<ZhongNanUserInfoDTO> userInfos = JSONObject.parseArray(
         JSONObject.parseObject(jsonUser.getString("data")).getString("dataList"), ZhongNanUserInfoDTO.class
      );
      log.info(userInfos.toString());
   }

   public void getHrmsubcompanyWithPage() {
      HttpRequest request = HttpRequest.get(String.format("http://123.157.218.70:6006/api/oa/call/getHrmsubcompanyWithPage?id=%s&supsubcomid=%s", 66, ""))
         .header(
            "Authorization",
            authorization()
         );
      JSONObject jsonObject = JSONObject.parseObject(new String(request.execute().body()));
      List<ZhongNanSegmentInfoDTO> segmentInfoDTOS = JSONObject.parseArray(
         JSONObject.parseObject(jsonObject.getString("data")).getString("dataList"), ZhongNanSegmentInfoDTO.class
      );
      log.info(segmentInfoDTOS.toString());
   }

   @GetMapping("/getHrmdepartment")
   public void getHrmdepartment() {
      List<User> collect = this.userService.list().stream().filter(item -> StringUtils.isNotBlank(item.getUsername())).collect(Collectors.toList());
      String userCodes = collect.stream().map(User::getUsername).collect(Collectors.joining(","));
      HttpRequest requestUser = HttpRequest.get(
            String.format("http://123.157.218.70:6006/api/oa/call/getHrmUserInfoWithPage?subcompanyid1=%s&workcode=%s", "", userCodes)
         )
         .header(
            "Authorization",
            authorization()
         );
      JSONObject jsonUser = JSONObject.parseObject(new String(requestUser.execute().body()));
      List<ZhongNanUserInfoDTO> userInfos = JSONObject.parseArray(
         JSONObject.parseObject(jsonUser.getString("data")).getString("dataList"), ZhongNanUserInfoDTO.class
      );
      collect.forEach(item -> {
         List<ZhongNanUserInfoDTO> newUserInfo = userInfos.stream().filter(user -> user.getWorkcode().equals(item.getUsername())).collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(newUserInfo)) {
            item.setOaUserId(Long.parseLong(newUserInfo.get(0).getId()));
            item.setOaDeptId(Long.parseLong(newUserInfo.get(0).getDepartmentid()));
            item.setOaSubDeptId(Long.parseLong(newUserInfo.get(0).getSubcompanyid1()));
            item.setOaSubDeptName(newUserInfo.get(0).getSubcompanyname());
            this.userService.updateById(item);
         }
      });
   }

   public void getHrmdepartmentWithPage(String subcompanyid1) {
      List<DepartmentTree> departmentTree = this.departmentService.getDepartmentTree(null, null, null, null);
      new ArrayList();
      List departmentTrees;
      if (subcompanyid1.equals("22")) {
         departmentTrees = departmentTree.get(0).getChildren().stream().filter(item -> item.getId() != 27L).collect(Collectors.toList());
      } else {
         departmentTrees = departmentTree.get(0).getChildren().stream().filter(item -> item.getId() == 27L).collect(Collectors.toList()).get(0).getChildren();
      }

      HttpRequest request = HttpRequest.get(String.format("http://123.157.218.70:6006/api/oa/call/getHrmdepartmentWithPage?subcompanyid1=%s", subcompanyid1))
         .header(
            "Authorization",
            authorization()
         );
      JSONObject jsonObject = JSONObject.parseObject(new String(request.execute().body()));
      List<ZhongNanDeptInfoDTO> deptInfoDTOS = JSONObject.parseArray(
         JSONObject.parseObject(jsonObject.getString("data")).getString("dataList"), ZhongNanDeptInfoDTO.class
      );
      List<ZhongNanDeptInfoDTO> oaDeptTree = this.convertFlatToTree(deptInfoDTOS);
      this.syncDept(oaDeptTree, departmentTrees, subcompanyid1);
      log.info(oaDeptTree.toString());
   }

   private void syncDept(List<ZhongNanDeptInfoDTO> oaDepts, List<DepartmentTree> bDepts, String subcompanyid1) {
      for (ZhongNanDeptInfoDTO oaDept : oaDepts) {
         Optional<DepartmentTree> optBDept = this.findDeptByName(bDepts, oaDept.getDepartmentname());
         if (!optBDept.isPresent()) {
            Department newDept = new Department();
            if ("0".equals(oaDept.getSupdepid()) && "22".equals(subcompanyid1)) {
               newDept.setPid(Long.parseLong("1"));
            } else if ("0".equals(oaDept.getSupdepid()) && "66".equals(subcompanyid1)) {
               newDept.setPid(Long.parseLong("27"));
            } else {
               int parentId = this.findParentId(bDepts, Long.parseLong(oaDept.getSupdepid()));
               newDept.setPid((long)parentId);
            }

            newDept.setOaDeptId(Long.parseLong(oaDept.getId()));
            newDept.setName(oaDept.getDepartmentname());
            this.departmentService.save(newDept);
         } else {
            Department updateDept = BeanUtil.copy(optBDept.get(), Department.class);
            updateDept.setOaDeptId(Long.parseLong(oaDept.getId()));
            this.departmentService.saveOrUpdate(updateDept);
         }

         DepartmentTree bParent = optBDept.orElse(null);
         List<ZhongNanDeptInfoDTO> children = oaDept.getChildren();
         boolean chumingChildren = ObjectUtils.isNotEmpty(bParent) && CollectionUtils.isNotEmpty(bParent.getChildren());
         boolean oaChildren = CollectionUtils.isNotEmpty(children);
         if (chumingChildren && oaChildren) {
            this.syncDept(children, bParent.getChildren(), subcompanyid1);
         }

         boolean isChildren = ObjectUtils.isNotEmpty(bParent) && CollectionUtils.isEmpty(bParent.getChildren());
         if (isChildren && oaChildren) {
            this.recursionSaveDept(bParent.getId(), children);
         }
      }
   }

   private void recursionSaveDept(Long pid, List<ZhongNanDeptInfoDTO> children) {
      children.forEach(oaDeptChildren -> {
         Department newDept = new Department();
         newDept.setOaDeptId(Long.parseLong(oaDeptChildren.getId()));
         newDept.setName(oaDeptChildren.getDepartmentname());
         newDept.setPid(pid);
         this.departmentService.save(newDept);
         if (CollectionUtils.isNotEmpty(oaDeptChildren.getChildren())) {
            this.recursionSaveDept(newDept.getId(), oaDeptChildren.getChildren());
         }
      });
   }

   private int findParentId(List<DepartmentTree> bDepts, Long pid) {
      return Math.toIntExact(bDepts.stream().filter(d -> d.getOaDeptId() == pid).map(d -> d.getId()).findFirst().orElse(0L));
   }

   private void handleDeletedDeptsInB(List<ZhongNanDeptInfoDTO> oaDepts, List<DepartmentTree> bDepts) {
      Set<String> oaNames = oaDepts.stream().map(d -> d.getDepartmentname()).collect(Collectors.toSet());

      for (DepartmentTree bDept : bDepts) {
         if (!oaNames.contains(bDept.getName())) {
            this.departmentService.removeById(bDept.getId());
         } else {
            this.handleDeletedDeptsInB(oaDepts, bDept.getChildren());
         }
      }
   }

   private Optional<DepartmentTree> findDeptByName(List<DepartmentTree> depts, String name) {
      return depts.stream().filter(d -> d.getName().equals(name)).findFirst();
   }

   public List<ZhongNanDeptInfoDTO> convertFlatToTree(List<ZhongNanDeptInfoDTO> flatDepartments) {
      Map<String, ZhongNanDeptInfoDTO> departmentMap = new HashMap<>();
      List<ZhongNanDeptInfoDTO> rootDepartments = new ArrayList<>();

      for (ZhongNanDeptInfoDTO dept : flatDepartments) {
         departmentMap.put(dept.getId(), dept);
      }

      for (ZhongNanDeptInfoDTO dept : flatDepartments) {
         String supdepid = dept.getSupdepid();
         if (!"0".equals(supdepid) && departmentMap.containsKey(supdepid)) {
            ZhongNanDeptInfoDTO parent = departmentMap.get(supdepid);
            parent.getChildren().add(dept);
         } else {
            rootDepartments.add(dept);
         }
      }

      return rootDepartments;
   }

   @GetMapping("/getJobtitleInfoWithPage")
   public void getJobtitleInfoWithPage() {
      HttpRequest request = HttpRequest.get("http://123.157.218.70:6006/api/oa/call/getJobtitleInfoWithPage")
         .header(
            "Authorization",
            authorization()
         );
      JSONObject jsonObject = JSONObject.parseObject(new String(request.execute().body()));
      List<ZhongNanJobtitleInfoDTO> jobtitleInfoDTOS = JSONObject.parseArray(
         JSONObject.parseObject(jsonObject.getString("data")).getString("dataList"), ZhongNanJobtitleInfoDTO.class
      );
      jobtitleInfoDTOS.forEach(oaJob -> {
         Job job = Job.builder().name(oaJob.getJobtitlename()).id(Long.parseLong(oaJob.getId())).build();
         this.jobService.saveOrUpdate(job);
      });
      log.info(jobtitleInfoDTOS.toString());
   }

   @GetMapping("/getHrmUserInfoWithPage")
   public void getHrmUserInfoWithPage(String subcompanyid1) {
      Map<String, List<User>> userByPhone = this.userService.list().stream().collect(Collectors.groupingBy(User::getPhone));
      HttpRequest request = HttpRequest.get(String.format("http://123.157.218.70:6006/api/oa/call/getHrmUserInfoWithPage?subcompanyid1=%s", subcompanyid1))
         .header(
            "Authorization",
            authorization()
         );
      JSONObject jsonObject = JSONObject.parseObject(new String(request.execute().body()));
      List<ZhongNanUserInfoDTO> userInfos = JSONObject.parseArray(
         JSONObject.parseObject(jsonObject.getString("data")).getString("dataList"), ZhongNanUserInfoDTO.class
      );
      List<ZhongNanUserInfoDTO> collect = userInfos.stream()
         .filter(
            user -> String.valueOf(OaUserStatusEnum.PRACTICE.getType()).equals(user.getStatus())
               || String.valueOf(OaUserStatusEnum.OFFICIAL.getType()).equals(user.getStatus())
         )
         .collect(Collectors.toList());
      collect.forEach(
         oaUser -> {
            List<User> users = userByPhone.get(oaUser.getMobile());
            if (CollectionUtils.isNotEmpty(users)) {
               User user = users.get(0);
               user.setOaUserId(Long.parseLong(oaUser.getId()));
               user.setOaDeptId(Long.parseLong(oaUser.getDepartmentid()));
               this.userService.saveOrUpdate(user);
            } else {
               Department dept = this.departmentService.getOne(Wrappers.lambdaQuery(Department.class).eq(Department::getOaDeptId, oaUser.getDepartmentid()));
               if (ObjectUtils.isNotEmpty(dept)) {
                  User info = User.builder()
                     .name(oaUser.getLastname())
                     .phone(oaUser.getMobile())
                     .jobId(Long.parseLong(oaUser.getJobtitle()))
                     .password(this.encoder.encode(java.util.Objects.requireNonNull(System.getenv("LJAPS_INITIAL_USER_PASSWORD"), "LJAPS_INITIAL_USER_PASSWORD is required")))
                     .email(oaUser.getEmail())
                     .username(oaUser.getLoginid())
                     .isEnabled(true)
                     .sex(Integer.getInteger(oaUser.getSex()))
                     .oaUserId(Long.parseLong(oaUser.getId()))
                     .oaDeptId(Long.parseLong(oaUser.getDepartmentid()))
                     .departmentId(dept.getId())
                     .build();
                  this.userService.saveOrUpdate(info);
               }
            }
         }
      );
      log.info(userInfos.toString());
   }

   public static List<ZhongNanWorkFlowDTO> getCreateWorkflowList(String userId) {
      try {
         URL url = new URL(String.format("http://123.157.218.70:6006/api/oa/call/getCreateWorkflowList?userId=%s", userId));
         HttpURLConnection connection = (HttpURLConnection)url.openConnection();
         connection.setRequestMethod("GET");
         connection.setDoOutput(true);
         connection.setRequestProperty(
            "Authorization",
            authorization()
         );
         connection.connect();
         InputStream inputStream = connection.getInputStream();
         BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
         StringBuilder stringBuilder = new StringBuilder();
         String line;
         if ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
            return JSONArray.parseArray(new String(stringBuilder.toString()), ZhongNanWorkFlowDTO.class);
         }
      } catch (JsonProcessingException e) {
         throw new RuntimeException(e);
      } catch (MalformedURLException e) {
         throw new RuntimeException(e);
      } catch (IOException e) {
         throw new RuntimeException(e);
      }

      return new ArrayList<>();
   }

   public static Boolean checkPermission(String userId, String workflowId) {
      List<ZhongNanWorkFlowDTO> zhongNanWorkFlowDTOS = getCreateWorkflowList(userId);
      List<String> workflowIds = zhongNanWorkFlowDTOS.stream()
         .filter(item -> item.getWorkflowId().equals(workflowId))
         .map(ZhongNanWorkFlowDTO::getWorkflowId)
         .collect(Collectors.toList());
      return !CollectionUtils.isEmpty(workflowIds);
   }

   public static String demo() {
      Map<String, Object> tokenMap = new HashMap<>();
      ObjectMapper mapper = new ObjectMapper();

      try {
         tokenMap.put("username", java.util.Objects.requireNonNull(System.getenv("LJAPS_SHR_TOKEN_USERNAME"), "LJAPS_SHR_TOKEN_USERNAME is required"));
         tokenMap.put(
            "password",
            System.getenv("LJAPS_SHR_TOKEN_PASSWORD")
         );
         String jsonInputString = mapper.writeValueAsString(tokenMap);
         String tokenJson = HttpUtil.post("http://123.157.218.70:6006/api/user/login", jsonInputString);
         JSONObject tokenJsonObject = JSON.parseObject(tokenJson);
         String token = JSON.parseObject(tokenJsonObject.getString("data")).getString("token");
         URL url = new URL("http://123.157.218.70:6006/api/oa/call/token");
         HttpURLConnection connection = (HttpURLConnection)url.openConnection();
         connection.setRequestMethod("GET");
         connection.setDoOutput(true);
         connection.setRequestProperty("Authorization", token);
         connection.connect();
         InputStream inputStream = connection.getInputStream();
         BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
         StringBuilder stringBuilder = new StringBuilder();
         String line;
         if ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
            return stringBuilder.toString();
         } else {
            return null;
         }
      } catch (JsonProcessingException e) {
         throw new RuntimeException(e);
      } catch (MalformedURLException e) {
         throw new RuntimeException(e);
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }
}
