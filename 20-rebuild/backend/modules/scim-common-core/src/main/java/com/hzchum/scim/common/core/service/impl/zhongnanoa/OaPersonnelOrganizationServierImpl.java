package com.hzchum.scim.common.core.service.impl.zhongnanoa;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.pangu.common.util.HttpUrlUtils;
import com.hzchum.scim.common.core.api.config.ZhongNanOaProperties;
import com.hzchum.scim.common.core.api.pojo._do.zhongnanoa.OaUserInfo;
import com.hzchum.scim.common.core.api.pojo.dto.oa.ZhongNanDeptInfoDTO;
import com.hzchum.scim.common.core.api.pojo.dto.oa.ZhongNanWorkFlowDTO;
import com.hzchum.scim.common.core.api.service.zhongnanoa.OaPersonnelOrganizationServier;
import com.hzchum.scim.common.core.api.utils.oa.RSA;
import com.hzchum.scim.common.core.mapper.zhongnanoa.OaUserInfoMapper;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.pojo.dto.DepartmentTree;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class OaPersonnelOrganizationServierImpl extends ServiceImpl<OaUserInfoMapper, OaUserInfo> implements OaPersonnelOrganizationServier {
   private static final Logger log = LoggerFactory.getLogger(OaPersonnelOrganizationServierImpl.class);
   private final String CONTENT_TYPE = "application/json";
   @Resource
   private ZhongNanOaProperties oaProperties;
   @Resource
   private RedisUtils redisUtils;
   @Resource
   private DepartmentService departmentService;
   @Resource
   private UserService userService;
   @Resource
   private PasswordEncoder encoder;

   @Override
   public String getHrmsubcompanyWithPage(String id, String supsubcomid) {
      Map<String, Object> paramsMap = new HashMap<>();
      Map<String, Object> params = new HashMap<>();
      params.put("curpage", 1);
      params.put("pagesize", Integer.MAX_VALUE);
      if (StringUtils.isNotBlank(id)) {
         params.put("id", id);
      }

      if (StringUtils.isNotBlank(supsubcomid)) {
         params.put("supsubcomid", supsubcomid);
      }

      paramsMap.put("params", params);
      log.info("调用：getHrmsubcompanyWithPage:" + JSON.toJSONString(paramsMap));
      return HttpUrlUtils.doPostWithParamHeader(
         this.oaProperties.getHost() + "/api/hrm/resful/getHrmsubcompanyWithPage",
         null,
         this.getHeaderMap(null),
         JSON.toJSONString(paramsMap),
         "application/json"
      );
   }

   @Override
   public String getHrmdepartmentWithPage(String subcompanyid1, String departmentcode) {
      Map<String, Object> paramsMap = new HashMap<>();
      Map<String, Object> params = new HashMap<>();
      if (StringUtils.isNotBlank(subcompanyid1)) {
         params.put("subcompanyid1", subcompanyid1);
      }

      if (StringUtils.isNotBlank(departmentcode)) {
         params.put("departmentcode", departmentcode);
      }

      params.put("curpage", 1);
      params.put("pagesize", Integer.MAX_VALUE);
      paramsMap.put("params", params);
      log.info("调用：getHrmdepartmentWithPage:" + JSON.toJSONString(paramsMap));
      return HttpUrlUtils.doPostWithParamHeader(
         this.oaProperties.getHost() + "/api/hrm/resful/getHrmdepartmentWithPage",
         null,
         this.getHeaderMap(null),
         JSON.toJSONString(paramsMap),
         "application/json"
      );
   }

   @Override
   public String getJobtitleInfoWithPage() {
      Map<String, Object> paramsMap = new HashMap<>();
      Map<String, Object> params = new HashMap<>();
      params.put("curpage", 1);
      params.put("pagesize", Integer.MAX_VALUE);
      paramsMap.put("params", params);
      log.info("调用：getJobtitleInfoWithPage");
      return HttpUrlUtils.doPostWithParamHeader(
         this.oaProperties.getHost() + "/api/hrm/resful/getJobtitleInfoWithPage",
         null,
         this.getHeaderMap(null),
         JSON.toJSONString(paramsMap),
         "application/json"
      );
   }

   @Override
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

   @Override
   public String getCreateWorkflowList(String userId) {
      return HttpUrlUtils.doPostWithParamHeader(
         this.oaProperties.getHost() + "/api/workflow/paService/getCreateWorkflowList", null, this.getHeaderMap(userId), null, "application/json"
      );
   }

   public Boolean checkPermission(String userId, String workflowId) {
      String createWorkflowList = this.getCreateWorkflowList(userId);
      List<ZhongNanWorkFlowDTO> zhongNanWorkFlowDTOS = JSONArray.parseArray(new String(createWorkflowList), ZhongNanWorkFlowDTO.class);
      List<String> workflowIds = zhongNanWorkFlowDTOS.stream()
         .filter(item -> item.getWorkflowId().equals(workflowId))
         .map(ZhongNanWorkFlowDTO::getWorkflowId)
         .collect(Collectors.toList());
      return !CollectionUtils.isEmpty(workflowIds);
   }

   public String submitRequest() {
      Object token = this.redisUtils.get("token");
      log.info("token:" + token);
      Map<String, String> map = new HashMap<>();
      String url = "/api/workflow/paService/submitRequest";
      map.put("token", (String)token);
      map.put("appid", this.oaProperties.getAppId());
      map.put("userid", this.encrypt("1"));
      log.info("map:" + map);
      String tokenJson = HttpUrlUtils.doPostWithParamHeader(this.oaProperties.getHost() + url, null, map, null, "application/json");
      log.info("tokenJson:" + tokenJson);
      return tokenJson;
   }

   private String encrypt(String data) {
      RSA rsa = new RSA();
      return rsa.encrypt(null, data, null, "utf-8", this.oaProperties.getSpk(), false);
   }

   private Map getHeaderMap(String userId) {
      Map<String, String> HeaderMap = new HashMap<>();
      HeaderMap.put("appid", this.oaProperties.getAppId());
      HeaderMap.put("secret", this.encrypt(this.oaProperties.getSecret()));
      HeaderMap.put("token", this.getToken());
      HeaderMap.put("userid", this.encrypt(userId != null ? userId : "1"));
      return HeaderMap;
   }

   @Override
   public String getToken() {
      Map<String, String> map = new HashMap<>();
      String encrypt = this.encrypt(this.oaProperties.getSecret());
      map.put("appid", this.oaProperties.getAppId());
      map.put("secret", encrypt);
      log.info("map:" + map);
      String tokenJson = HttpUrlUtils.doPostWithParamHeader(this.oaProperties.getHost() + "/api/ec/dev/auth/applytoken", null, map, null, "application/json");
      log.info("tokenJson:" + tokenJson);
      JSONObject tokenJsonObject = JSON.parseObject(tokenJson);
      log.info("当前状态码： " + tokenJsonObject.getString("code"));
      if (0 == tokenJsonObject.getInteger("code")) {
         log.info("获取成功");
         return tokenJsonObject.getString("token");
      } else {
         return tokenJson;
      }
   }

   private List<ZhongNanDeptInfoDTO> convertFlatToTree(List<ZhongNanDeptInfoDTO> flatDepartments) {
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

   private int findParentId(List<DepartmentTree> bDepts, Long pid) {
      return Math.toIntExact(bDepts.stream().filter(d -> d.getOaDeptId() == pid).map(d -> d.getId()).findFirst().orElse(0L));
   }

   private Optional<DepartmentTree> findDeptByName(List<DepartmentTree> depts, String name) {
      return depts.stream().filter(d -> d.getName().equals(name)).findFirst();
   }
}
