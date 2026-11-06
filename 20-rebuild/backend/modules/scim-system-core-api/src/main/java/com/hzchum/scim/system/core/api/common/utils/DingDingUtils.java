package com.hzchum.scim.system.core.api.common.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.dingtalkdrive_1_0.models.AddFileHeaders;
import com.aliyun.dingtalkdrive_1_0.models.AddFileRequest;
import com.aliyun.dingtalkdrive_1_0.models.AddFileResponse;
import com.aliyun.dingtalkdrive_1_0.models.AddFileResponseBody;
import com.aliyun.dingtalkdrive_1_0.models.GetUploadInfoHeaders;
import com.aliyun.dingtalkdrive_1_0.models.GetUploadInfoRequest;
import com.aliyun.dingtalkdrive_1_0.models.GetUploadInfoResponse;
import com.aliyun.dingtalkdrive_1_0.models.ListSpacesHeaders;
import com.aliyun.dingtalkdrive_1_0.models.ListSpacesRequest;
import com.aliyun.dingtalkdrive_1_0.models.ListSpacesResponse;
import com.aliyun.dingtalkdrive_1_0.models.ListSpacesResponseBody;
import com.aliyun.dingtalkdrive_1_0.models.GetUploadInfoResponseBody.GetUploadInfoResponseBodyStsUploadInfo;
import com.aliyun.dingtalkoauth2_1_0.Client;
import com.aliyun.dingtalkoauth2_1_0.models.GetAccessTokenRequest;
import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import com.aliyun.tea.TeaException;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.teautil.Common;
import com.aliyun.teautil.models.RuntimeOptions;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiCallBackDeleteCallBackRequest;
import com.dingtalk.api.request.OapiCallBackGetCallBackRequest;
import com.dingtalk.api.request.OapiCallBackRegisterCallBackRequest;
import com.dingtalk.api.request.OapiProcessGetByNameRequest;
import com.dingtalk.api.request.OapiProcessInstanceTerminateRequest;
import com.dingtalk.api.request.OapiProcessSaveRequest;
import com.dingtalk.api.request.OapiProcessinstanceCreateRequest;
import com.dingtalk.api.request.OapiProcessinstanceGetRequest;
import com.dingtalk.api.request.OapiV2DepartmentListsubRequest;
import com.dingtalk.api.request.OapiV2UserGetRequest;
import com.dingtalk.api.request.OapiV2UserGetbymobileRequest;
import com.dingtalk.api.request.OapiV2UserListRequest;
import com.dingtalk.api.request.OapiProcessInstanceTerminateRequest.TerminateProcessInstanceRequestV2;
import com.dingtalk.api.request.OapiProcessSaveRequest.FormComponentPropVo;
import com.dingtalk.api.request.OapiProcessSaveRequest.FormComponentPropVo2;
import com.dingtalk.api.request.OapiProcessSaveRequest.FormComponentVo;
import com.dingtalk.api.request.OapiProcessSaveRequest.FormComponentVo2;
import com.dingtalk.api.request.OapiProcessSaveRequest.SaveProcessRequest;
import com.dingtalk.api.response.OapiCallBackDeleteCallBackResponse;
import com.dingtalk.api.response.OapiCallBackGetCallBackResponse;
import com.dingtalk.api.response.OapiCallBackRegisterCallBackResponse;
import com.dingtalk.api.response.OapiProcessGetByNameResponse;
import com.dingtalk.api.response.OapiProcessInstanceTerminateResponse;
import com.dingtalk.api.response.OapiProcessSaveResponse;
import com.dingtalk.api.response.OapiProcessinstanceCreateResponse;
import com.dingtalk.api.response.OapiProcessinstanceGetResponse;
import com.dingtalk.api.response.OapiV2DepartmentListsubResponse;
import com.dingtalk.api.response.OapiV2UserGetResponse;
import com.dingtalk.api.response.OapiV2UserGetbymobileResponse;
import com.dingtalk.api.response.OapiV2UserListResponse;
import com.dingtalk.api.response.OapiProcessinstanceGetResponse.ProcessInstanceTopVo;
import com.dingtalk.api.response.OapiV2DepartmentListsubResponse.DeptBaseResponse;
import com.dingtalk.api.response.OapiV2UserGetResponse.UserGetResponse;
import com.dingtalk.api.response.OapiV2UserListResponse.ListUserResponse;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.contract.core.api.common.MapConstants;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.constant.ApprovalFormConstants;
import com.hzchum.scim.system.core.api.common.constant.DingDingConstants;
import com.hzchum.scim.system.core.api.common.constant.EventTypeConstants;
import com.hzchum.scim.system.core.api.pojo.dto.DDDepartment;
import com.hzchum.scim.system.core.api.pojo.dto.DDUser;
import com.hzchum.scim.system.core.api.pojo.dto.DingDing.SaveProcessInfo;
import com.taobao.api.ApiException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DingDingUtils {
   private static final Logger log = LoggerFactory.getLogger(DingDingUtils.class);
   private static final String DD_CALLBACK = "api/dd/callback";

   public static Client createClient() throws Exception {
      Config config = new Config();
      config.protocol = "https";
      config.regionId = "central";
      return new Client(config);
   }

   public static String getAccessToken(String appKey, String appSecret) {
      try {
         Client client = createClient();
         GetAccessTokenRequest getAccessTokenRequest = new GetAccessTokenRequest().setAppKey(appKey).setAppSecret(appSecret);
         return client.getAccessToken(getAccessTokenRequest).getBody().accessToken;
      } catch (TeaException err) {
         if (!Common.empty(err.code) && !Common.empty(err.message)) {
            log.error("AccessToken获取失败===> code{" + err.code + "},message{" + err.message + "}");
         }
      } catch (Exception _err) {
         TeaException err = new TeaException(_err.getMessage(), _err);
         if (!Common.empty(err.code) && !Common.empty(err.message)) {
            log.error("AccessToken获取失败===> code{" + err.code + "},message{" + err.message + "}");
         }
      }

      return null;
   }

   public static Boolean sendMessage(String chatId, String messageType, String message, String action) {
      try {
         JSONObject messageJson = new JSONObject();
         messageJson.put("msgtype", messageType);
         messageJson.put("chatid", chatId);
         messageJson.put(messageType, message);
         String result = RequestUtils.sendHttpsPostRequest(
            "https://oapi.dingtalk.com/chat/send?access_token=" + MapConstants.getStringConstantsMap().get("ddAccessToken"), messageJson
         );
         getJSONObject(result);
      } catch (Exception e) {
         log.error(action + "通知发送失败。");
      }

      return Boolean.TRUE;
   }

   public static String getMarkdownMessageJson(String title, String text) {
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("title", title);
      jsonObject.put("text", text);
      return jsonObject.toString();
   }

   public static String getToken(String ddAppKey, String ddAppSecret) {
      String result = RequestUtils.sendHttpsGetRequest("https://oapi.dingtalk.com/gettoken?appkey=" + ddAppKey + "&appsecret=" + ddAppSecret);
      JSONObject jsonObject = getJSONObject(result);
      return jsonObject.getString("access_token");
   }

   private static List<DDDepartment> getDepart() {
      String result = RequestUtils.sendHttpsGetRequest(
         "https://oapi.dingtalk.com/department/list?access_token=" + MapConstants.getStringConstantsMap().get("ddAccessToken")
      );
      JSONObject jsonObject = getJSONObject(result);
      JSONArray jsonArray = jsonObject.getJSONArray("department");
      return jsonArray.toJavaList(DDDepartment.class);
   }

   public static List<DDUser> getUser() {
      List<Long> departIds = getDepart().stream().map(DDDepartment::getId).collect(Collectors.toList());
      List<DDUser> ddUsers = new ArrayList<>();

      for (Long departId : departIds) {
         List<DDUser> departmentUser = getDepartmentUser(departId);
         ddUsers.addAll(departmentUser);
      }

      return ddUsers;
   }

   private static List<DDUser> getDepartmentUser(Long departId) {
      int offset = 0;
      int size = 100;
      Boolean hasMore = Boolean.TRUE;
      List<DDUser> responseList = new ArrayList<>();

      while (hasMore) {
         JSONObject jsonObject = getDepartmentUserByOffset(departId, offset, size);
         JSONArray jsonArray = jsonObject.getJSONArray("userlist");
         List<DDUser> ddUsers = jsonArray.toJavaList(DDUser.class);
         responseList.addAll(ddUsers);
         hasMore = jsonObject.getBoolean("hasMore");
         if (hasMore) {
            offset += size;
         }
      }

      return responseList;
   }

   private static JSONObject getDepartmentUserByOffset(Long departId, Integer offset, Integer size) {
      String getDepartUrl = "https://oapi.dingtalk.com/user/listbypage?access_token="
         + MapConstants.getStringConstantsMap().get("ddAccessToken")
         + "&department_id="
         + departId
         + "&offset="
         + offset
         + "&size="
         + size;
      String result = RequestUtils.sendHttpsGetRequest(getDepartUrl);
      return getJSONObject(result);
   }

   private static JSONObject getJSONObject(String result) {
      JSONObject jsonObject;
      try {
         jsonObject = JSONObject.parseObject(result);
      } catch (Exception e) {
         throw new RuntimeException("解析token返回信息失败");
      }

      Preconditions.checkArgument(
         DingDingConstants.DD_SUCCESS_ERRCODE.equals(jsonObject.getInteger("errcode")), "获取钉钉部门信息失败，错误提示：" + jsonObject.getString("errmsg")
      );
      return jsonObject;
   }

   public static String getProductMessage(
      SecurityUser user, String projectName, String monomerName, String areaName, String fileName, String name, String serialNumber, String action
   ) {
      StringBuilder message = new StringBuilder();
      message.append(LocalDate.now().toString()).append(" ").append("来自：");
      if (user.getDepartment() != null) {
         message.append(user.getDepartment().getName()).append("/");
      }

      message.append(user.getName()).append("  《").append(projectName).append("》项目").append("->").append(monomerName).append("->").append(areaName);
      if (fileName != null) {
         message.append("->《").append(fileName).append("》");
      }

      if (name != null) {
         message.append("->").append(name);
      }

      if (serialNumber != null) {
         message.append("/").append(serialNumber);
      }

      message.append("  进行了\"").append(action).append("\"操作，请相关单位知悉。");
      return message.toString();
   }

   public static boolean getCallBack() {
      String token = MapConstants.getStringConstantsMap().get("ddAccessToken");
      DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/call_back/get_call_back");
      OapiCallBackGetCallBackRequest req = new OapiCallBackGetCallBackRequest();
      req.setHttpMethod("GET");

      try {
         OapiCallBackGetCallBackResponse rsp = client.execute(req, token);
         log.info("查询订阅事件成功" + rsp.getBody());
         return rsp.isSuccess();
      } catch (ApiException e) {
         log.error("查询订阅事件失败-----------------", e);
         return false;
      }
   }

   public static boolean deleteCallBack() {
      String token = MapConstants.getStringConstantsMap().get("ddAccessToken");
      DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/call_back/delete_call_back");
      OapiCallBackDeleteCallBackRequest req = new OapiCallBackDeleteCallBackRequest();
      req.setHttpMethod("GET");

      try {
         OapiCallBackDeleteCallBackResponse rsp = client.execute(req, token);
         log.info("删除事件回调接口成功" + rsp.getBody());
         return rsp.isSuccess();
      } catch (ApiException e) {
         log.error("删除事件回调接口失败-----------------", e);
         return false;
      }
   }

   public static void callBackRegisterCallBack(ConfigProperties ddProperties) {
      DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/call_back/register_call_back");
      OapiCallBackRegisterCallBackRequest registerRequest = new OapiCallBackRegisterCallBackRequest();
      registerRequest.setUrl(ddProperties.getUrl() + "api/dd/callback");
      registerRequest.setAesKey(ddProperties.getAesKey());
      registerRequest.setToken(ddProperties.getToken());
      registerRequest.setCallBackTag(EventTypeConstants.eventList);

      try {
         OapiCallBackRegisterCallBackResponse response = client.execute(registerRequest, MapConstants.getStringConstantsMap().get("ddAccessToken"));
         if (!response.isSuccess()) {
            throw new ServiceException(response.getErrmsg());
         }

         log.info("注册回调成功了！！！");
      } catch (ApiException e) {
         log.error("注册回调失败-----------------", e);
      }
   }

   public static String getProcess(String name, String token) {
      DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/process/get_by_name");
      OapiProcessGetByNameRequest req = new OapiProcessGetByNameRequest();
      req.setName(name);
      OapiProcessGetByNameResponse rsp = null;

      try {
         rsp = client.execute(req, token);
         if (rsp.isSuccess()) {
            return rsp.getProcessCode();
         }
      } catch (ApiException e) {
         log.error("获取模板code失败", e);
      }

      return null;
   }

   public static String saveProcess(String name, String code, String token) {
      DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/process/save");
      OapiProcessSaveRequest request = new OapiProcessSaveRequest();
      SaveProcessInfo processInfo = ApprovalFormConstants.getByName(name);
      SaveProcessRequest processRequest = new SaveProcessRequest();
      BeanUtil.copy(processInfo, processRequest);
      processRequest.setProcessCode(code);
      List<FormComponentVo> formComponentList = processInfo.getFormComponentList().stream().map(info -> {
         FormComponentVo component = new FormComponentVo();
         FormComponentPropVo prop = BeanUtil.copy(info.getProps(), FormComponentPropVo.class);
         component.setComponentName(info.getComponentName());
         component.setProps(prop);
         if (CollectionUtils.isNotEmpty(info.getChildren())) {
            component.setChildren(info.getChildren().stream().map(children -> {
               FormComponentVo2 childrenVO = new FormComponentVo2();
               childrenVO.setComponentName(children.getComponentName());
               childrenVO.setProps(BeanUtil.copy(children.getProps(), FormComponentPropVo2.class));
               return childrenVO;
            }).collect(Collectors.toList()));
         }

         return component;
      }).collect(Collectors.toList());
      processRequest.setFormComponentList(formComponentList);
      request.setSaveProcessRequest(processRequest);

      try {
         OapiProcessSaveResponse response = client.execute(request, token);
         if (!response.isSuccess()) {
            throw new ServiceException("创建或更新审批模板失败，审批模板" + name + "已存在。" + response.getErrmsg());
         }

         log.info("创建或更新审批模板成功，name：" + name + "，processCode：" + response.getResult().getProcessCode());
         return response.getResult().getProcessCode();
      } catch (ApiException e) {
         log.error("创建或更新审批模板失败", e);
         return null;
      }
   }

   public static List<DeptBaseResponse> listDept(Long pid, List<String> excludeDeparts) {
      DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/v2/department/listsub");
      OapiV2DepartmentListsubRequest req = new OapiV2DepartmentListsubRequest();
      req.setDeptId(pid);

      try {
         OapiV2DepartmentListsubResponse rsp = client.execute(req, MapConstants.getStringConstantsMap().get("ddAccessToken"));
         if (!rsp.isSuccess()) {
            throw new ServiceException(rsp.getErrmsg());
         }

         if (CollectionUtils.isEmpty(rsp.getResult())) {
            return new ArrayList<>();
         }

         List<DeptBaseResponse> result = new ArrayList<>();

         for (DeptBaseResponse dept : rsp.getResult()) {
            List<DeptBaseResponse> child = new ArrayList<>();
            if (CollectionUtils.isNotEmpty(excludeDeparts)) {
               if (!excludeDeparts.contains(dept.getName())) {
                  child = listDept(dept.getDeptId(), null);
               }
            } else {
               child = listDept(dept.getDeptId(), null);
            }

            if (CollectionUtils.isNotEmpty(child)) {
               result.addAll(child);
            }

            result.add(dept);
         }

         return result;
      } catch (ApiException e) {
         log.error("获取部门列表失败", e);
         return new ArrayList<>();
      }
   }

   public static List<ListUserResponse> listUser(Long deptId) {
      DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/v2/user/list");
      OapiV2UserListRequest req = new OapiV2UserListRequest();
      req.setDeptId(deptId);
      req.setCursor(0L);
      req.setSize(100L);

      try {
         OapiV2UserListResponse rsp = client.execute(req, MapConstants.getStringConstantsMap().get("ddAccessToken"));
         if (!rsp.isSuccess()) {
            throw new ServiceException(rsp.getErrmsg());
         }

         log.info("获取部门用户详情成功");
         return rsp.getResult().getList();
      } catch (ApiException e) {
         log.error("获取部门用户详情失败", e);
         return null;
      }
   }

   public static String getUserByPhone(String phone) {
      DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/v2/user/getbymobile");
      String token = MapConstants.getStringConstantsMap().get("ddAccessToken");
      OapiV2UserGetbymobileRequest req = new OapiV2UserGetbymobileRequest();
      req.setMobile(phone);
      OapiV2UserGetbymobileResponse rsp = null;

      try {
         rsp = client.execute(req, token);
         if (rsp.isSuccess()) {
            log.info("根据手机号获取userid调用成功！");
            return rsp.getResult().getUserid();
         }
      } catch (ApiException e) {
         e.printStackTrace();
         log.error("根据手机号获取userid调用失败：", e);
      }

      return null;
   }

   public static UserGetResponse getUserByUserId(String userId) {
      DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/v2/user/get");
      OapiV2UserGetRequest req = new OapiV2UserGetRequest();
      req.setUserid(userId);
      req.setLanguage("zh_CN");
      OapiV2UserGetResponse rsp = null;

      try {
         rsp = client.execute(req, MapConstants.getStringConstantsMap().get("ddAccessToken"));
         if (rsp.isSuccess()) {
            log.info("根据userid获取用户详情调用成功！");
            return rsp.getResult();
         }
      } catch (ApiException e) {
         log.error("根据userid获取用户详情调用失败：", e);
      }

      return null;
   }

   public static String createProcessInstance(OapiProcessinstanceCreateRequest request) {
      DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/processinstance/create");

      try {
         OapiProcessinstanceCreateResponse response = client.execute(request, MapConstants.getStringConstantsMap().get("ddAccessToken"));
         if (!response.isSuccess()) {
            throw new ServiceException(response.getErrmsg());
         }

         log.info("发起审批实例成功，processInstanceId：" + response.getProcessInstanceId());
         return response.getProcessInstanceId();
      } catch (ApiException e) {
         log.error("发起审批实例失败", e);
         return null;
      }
   }

   public static ProcessInstanceTopVo getProcessInstance(String processInstanceId) {
      DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/processinstance/get");
      OapiProcessinstanceGetRequest req = new OapiProcessinstanceGetRequest();
      req.setProcessInstanceId(processInstanceId);

      try {
         OapiProcessinstanceGetResponse rsp = client.execute(req, MapConstants.getStringConstantsMap().get("ddAccessToken"));
         if (!rsp.isSuccess()) {
            throw new ServiceException(rsp.getErrmsg());
         }

         log.info("获取审批实例详情成功" + rsp.getProcessInstance());
         return rsp.getProcessInstance();
      } catch (ApiException e) {
         log.error("获取审批实例详情失败", e);
         DefaultCredentialProvider defaultCredentialProvider = new DefaultCredentialProvider("", "", "");
         ClientConfiguration clientConfiguration = new ClientConfiguration();
         new OSSClient("endpoint", defaultCredentialProvider, clientConfiguration);
         return null;
      }
   }

   public static ListSpacesResponseBody getDDSpaceList(String unionId, String spaceType, String nextToken) throws Exception {
      Config config = new Config();
      config.protocol = "https";
      config.regionId = "central";
      com.aliyun.dingtalkdrive_1_0.Client client = new com.aliyun.dingtalkdrive_1_0.Client(config);
      ListSpacesHeaders listSpacesHeaders = new ListSpacesHeaders();
      listSpacesHeaders.xAcsDingtalkAccessToken = MapConstants.getStringConstantsMap().get("ddAccessToken");
      ListSpacesRequest listSpacesRequest = new ListSpacesRequest().setUnionId(unionId).setSpaceType(spaceType).setNextToken(nextToken).setMaxResults(50);

      try {
         ListSpacesResponse response = client.listSpacesWithOptions(listSpacesRequest, listSpacesHeaders, new RuntimeOptions());
         return response.getBody();
      } catch (TeaException err) {
         if (!Common.empty(err.code) && !Common.empty(err.message)) {
            log.warn("服务端接口获取钉盘空间信息err.code：" + err.code);
            log.warn("服务端接口获取钉盘空间信息err.message：" + err.message);
         }
      } catch (Exception _err) {
         TeaException err = new TeaException(_err.getMessage(), _err);
         if (!Common.empty(err.code) && !Common.empty(err.message)) {
            log.warn("服务端接口获取钉盘空间信息err.code：" + err.code);
            log.warn("服务端接口获取钉盘空间信息err.message：" + err.message);
         }
      }

      return null;
   }

   public static GetUploadInfoResponseBodyStsUploadInfo addFileInfo(
      String unionId, String fileName, Long fileSize, String md5, String addConflictPolicy, String mediaId, String spaceId, String parentId
   ) throws Exception {
      Config config = new Config();
      config.protocol = "https";
      config.regionId = "central";
      com.aliyun.dingtalkdrive_1_0.Client client = new com.aliyun.dingtalkdrive_1_0.Client(config);
      GetUploadInfoHeaders getUploadInfoHeaders = new GetUploadInfoHeaders();
      getUploadInfoHeaders.xAcsDingtalkAccessToken = MapConstants.getStringConstantsMap().get("ddAccessToken");
      GetUploadInfoRequest getUploadInfoRequest = new GetUploadInfoRequest()
         .setUnionId(unionId)
         .setFileName(fileName)
         .setFileSize(fileSize)
         .setMd5(md5)
         .setAddConflictPolicy(addConflictPolicy)
         .setMediaId(mediaId);

      try {
         GetUploadInfoResponse response = client.getUploadInfoWithOptions(spaceId, parentId, getUploadInfoRequest, getUploadInfoHeaders, new RuntimeOptions());
         return response.getBody().getStsUploadInfo();
      } catch (TeaException err) {
         if (!Common.empty(err.code) && !Common.empty(err.message)) {
            log.warn("获取文件上传信息返回err.code：" + err.code);
            log.warn("获取文件上传信息返回err.message：" + err.message);
         }
      } catch (Exception _err) {
         TeaException err = new TeaException(_err.getMessage(), _err);
         if (!Common.empty(err.code) && !Common.empty(err.message)) {
            log.warn("获取文件上传信息返回err.code：" + err.code);
            log.warn("获取文件上传信息返回err.message：" + err.message);
         }
      }

      return null;
   }

   public static AddFileResponseBody addFileOrFolder(
      String parentId, String fileType, String fileName, String mediaId, String addConflictPolicy, String unionId, String spaceId
   ) throws Exception {
      Config config = new Config();
      config.protocol = "https";
      config.regionId = "central";
      com.aliyun.dingtalkdrive_1_0.Client client = new com.aliyun.dingtalkdrive_1_0.Client(config);
      AddFileHeaders addFileHeaders = new AddFileHeaders();
      addFileHeaders.xAcsDingtalkAccessToken = MapConstants.getStringConstantsMap().get("ddAccessToken");
      AddFileRequest addFileRequest = new AddFileRequest()
         .setParentId(parentId)
         .setFileType(fileType)
         .setFileName(fileName)
         .setMediaId(mediaId)
         .setAddConflictPolicy(addConflictPolicy)
         .setUnionId(unionId);

      try {
         AddFileResponse response = client.addFileWithOptions(spaceId, addFileRequest, addFileHeaders, new RuntimeOptions());
         return response.getBody();
      } catch (TeaException err) {
         if (!Common.empty(err.code) && !Common.empty(err.message)) {
            log.warn("添加文件（夹）err.code：" + err.code);
            log.warn("添加文件（夹）err.message：" + err.message);
         }
      } catch (Exception _err) {
         TeaException err = new TeaException(_err.getMessage(), _err);
         if (!Common.empty(err.code) && !Common.empty(err.message)) {
            log.warn("添加文件（夹）err.code：" + err.code);
            log.warn("添加文件（夹）err.message：" + err.message);
         }
      }

      return null;
   }

   public static boolean terminateProcessInstance(String processInstanceId) {
      DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/process/instance/terminate");
      OapiProcessInstanceTerminateRequest req = new OapiProcessInstanceTerminateRequest();
      TerminateProcessInstanceRequestV2 processInstanceRequestV2 = new TerminateProcessInstanceRequestV2();
      processInstanceRequestV2.setProcessInstanceId(processInstanceId);
      processInstanceRequestV2.setIsSystem(true);
      req.setRequest(processInstanceRequestV2);

      try {
         OapiProcessInstanceTerminateResponse rsp = client.execute(req, MapConstants.getStringConstantsMap().get("ddAccessToken"));
         if (!rsp.isSuccess()) {
            throw new IllegalArgumentException(rsp.getErrmsg());
         }

         log.info("终止审批流程成功");
         return true;
      } catch (ApiException e) {
         e.printStackTrace();
         log.info("终止审批流程失败");
         return false;
      }
   }
}
