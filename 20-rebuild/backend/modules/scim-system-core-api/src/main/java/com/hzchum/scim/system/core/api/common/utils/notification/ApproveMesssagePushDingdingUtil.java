package com.hzchum.scim.system.core.api.common.utils.notification;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONObject;
import com.alibaba.fastjson.JSON;
import com.aliyun.dingtalkrobot_1_0.Client;
import com.aliyun.dingtalkrobot_1_0.models.BatchSendOTOHeaders;
import com.aliyun.dingtalkrobot_1_0.models.BatchSendOTORequest;
import com.aliyun.tea.TeaException;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.teautil.Common;
import com.aliyun.teautil.models.RuntimeOptions;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.request.OapiV2UserGetbymobileRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiV2UserGetbymobileResponse;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ApproveTemplateVersionsFlowEnum;
import com.hzchum.scim.common.core.api.enums.EnableEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecordDetail;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.system.core.api.common.enums.notification.AppTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.notification.ApprovePushDTO;
import com.hzchum.scim.system.core.api.pojo.dto.notification.SysPushApproveConfigDTO;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.system.core.api.service.notification.SysPushApproveConfigService;
import com.taobao.api.ApiException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApproveMesssagePushDingdingUtil {
   private static final Logger log = LoggerFactory.getLogger(ApproveMesssagePushDingdingUtil.class);
   private static final String MSG_KEY = "sampleMarkdown";
   private final long TOKEN_EXPIRED_TIME = 6600L;
   @Resource
   private UserService userService;
   @Autowired
   private RedisUtils redisUtils;
   @Resource
   private SysPushApproveConfigService approveConfigService;
   @Resource
   private WmsApproveRecordService recordService;

   public void sendMessage(ApprovePushDTO approvePushDTO, List<WmsApproveRecordDetail> recordDetails, Boolean isCreate, Long approveRecordId) {
      List<SysPushApproveConfigDTO> pushApproveList = this.approveConfigService
         .getPushApproveList(null, EnableEnum.ENABLE.getType(), AppTypeEnum.DINGDING.getType());
      if (CollectionUtils.isNotEmpty(pushApproveList)) {
         String approveProcessName = "";
         AtomicReference<String> applicantUser = new AtomicReference<>();
         AtomicReference<String> applicantTime = new AtomicReference<>();
         List<Long> userIds;
         Integer flowType;
         String approveRecordSerialNumber;
         if (isCreate) {
            userIds = Arrays.stream(approvePushDTO.getUserIds().split(",")).filter(s -> !s.equals("0")).map(Long::parseLong).collect(Collectors.toList());
            flowType = approvePushDTO.getType();
            approveRecordSerialNumber = approvePushDTO.getApproveRecordSerialNumber();
            approveProcessName = ApproveProcessTypeEnumV2.getName(approvePushDTO.getApproveProcessName());
            applicantTime.set(approvePushDTO.getApplicantTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            applicantUser.set(
               this.userService.getById(approvePushDTO.getApplicantUser()).getId() != null
                  ? this.userService.getNameById(approvePushDTO.getApplicantUser())
                  : ""
            );
            log.info("创建审批，流程编号为：{}", approveRecordSerialNumber);
         } else {
            WmsApproveRecordFlowDTO approveRecordDTO = this.recordService.getApproveRecordDTO(approveRecordId);
            if (ObjectUtil.isNotEmpty(approveRecordDTO)) {
               approveRecordDTO.getWmsApproveFlowDTOS()
                  .stream()
                  .filter(wmsApproveFlowDTO -> ApproveTemplateVersionsFlowEnum.LAUNCH_APPLICATION.getName().equals(wmsApproveFlowDTO.getTypeName()))
                  .forEach(item -> item.getWmsApproveRecordDetailDTOS().forEach(wmsApproveRecordDetailDTO -> {
                     applicantTime.set(wmsApproveRecordDetailDTO.getApproveTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                     applicantUser.set(wmsApproveRecordDetailDTO.getUserSimpleResponseVOS().getName());
                  }));
            }

            WmsApproveRecordDetail recordDetail = recordDetails.get(0);
            userIds = recordDetails.stream().filter(w -> w.getCheckUserId() != null).map(w -> w.getCheckUserId()).collect(Collectors.toList());
            flowType = recordDetail.getFlowType();
            approveRecordSerialNumber = recordDetail.getApproveRecordSerialNumber();
            approveProcessName = ApproveProcessTypeEnumV2.getName(recordDetail.getApproveProcessType());
            log.info("处理审批，流程编号为：{}", approveRecordSerialNumber);
         }

         List<String> phones = this.userService
            .list(Wrappers.lambdaQuery(User.class).in(User::getId, userIds))
            .stream()
            .filter(user -> user.getPhone() != null)
            .map(user -> user.getPhone())
            .collect(Collectors.toList());
         if (!ApproveTemplateVersionsFlowEnum.COPY_SEND.getType().equals(flowType)) {
            StringBuilder message = new StringBuilder();
            message.append("流程名称:")
               .append(approveProcessName)
               .append("，")
               .append("流程编号:")
               .append(approveRecordSerialNumber)
               .append("，")
               .append("发起人:")
               .append(applicantUser.get())
               .append("，")
               .append("发起时间:")
               .append(applicantTime.get())
               .append("。");
            Map map = new HashMap();
            map.put("text", message);
            map.put("title", "【" + approveProcessName + "】审批流待审批");
            String jsonString = JSON.toJSONString(map);
            log.info("审批流推送钉钉的消息为：{}", jsonString);

            try {
               this.sendDingTalkMessage(
                  phones, jsonString, pushApproveList.get(0).getAppKey(), pushApproveList.get(0).getAppSecret(), pushApproveList.get(0).getRobotCode()
               );
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      } else {
         log.info("钉钉推送配置不存在");
      }
   }

   private ResultVO sendDingTalkMessage(List<String> phones, String message, String appKey, String appSecret, String robotCode) throws Exception {
      ResultVO<Object> build = ResultVO.<Object>builder().build();
      Client client = this.createClient();
      BatchSendOTOHeaders batchSendOTOHeaders = new BatchSendOTOHeaders();
      batchSendOTOHeaders.xAcsDingtalkAccessToken = this.cacheToken(appKey, appSecret);
      BatchSendOTORequest batchSendOTORequest = new BatchSendOTORequest()
         .setRobotCode(robotCode)
         .setUserIds(this.getDDUserId(phones, appKey, appSecret))
         .setMsgKey("sampleMarkdown")
         .setMsgParam(message);

      try {
         log.info(client.batchSendOTOWithOptions(batchSendOTORequest, batchSendOTOHeaders, new RuntimeOptions()).toString());
         log.info("审批流推送钉钉的成功");
      } catch (TeaException err) {
         if (!Common.empty(err.code) && !Common.empty(err.message)) {
            log.info("审批流推送钉钉的失败：{}", err.message);
            build.setMessage(err.message);
            build.setCode(500L);
         }
      } catch (Exception _err) {
         TeaException err = new TeaException(_err.getMessage(), _err);
         if (!Common.empty(err.code) && !Common.empty(err.message)) {
            log.info("审批流推送钉钉的失败：{}", err.message);
            build.setMessage(err.message);
            build.setCode(500L);
         }
      }

      return build;
   }

   public Client createClient() throws Exception {
      Config config = new Config();
      config.protocol = "https";
      config.regionId = "central";
      return new Client(config);
   }

   private String cacheToken(String appKey, String appSecret) throws ApiException {
      Object value = this.redisUtils.get("sync:approve:push:token" + appKey);
      if (ObjectUtil.isEmpty(value)) {
         String token = this.getToken(appKey, appSecret);
         this.redisUtils.set("sync:approve:push:token" + appKey, token, 6600L);
         log.info(String.format("缓存过期重启获取钉钉token，appKey:%s,appSecret:%s,token:%s", appKey, appSecret, token));
         return token;
      } else {
         log.info(String.format("缓存获取token成功，token:%s", value.toString()));
         return value.toString();
      }
   }

   private String getToken(String appKey, String appSecret) throws ApiException {
      DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
      OapiGettokenRequest request = new OapiGettokenRequest();
      request.setAppkey(appKey);
      request.setAppsecret(appSecret);
      request.setHttpMethod("GET");
      OapiGettokenResponse response = client.execute(request);
      JSONObject jsonObject = new JSONObject(response.getBody());
      return jsonObject.getStr("errmsg").equals("ok") ? jsonObject.getStr("access_token") : "";
   }

   private List<String> getDDUserId(List<String> phones, String appKey, String appSecret) {
      List<String> userIds = new ArrayList<>();
      phones.forEach(phone -> {
         try {
            DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/v2/user/getbymobile");
            OapiV2UserGetbymobileRequest req = new OapiV2UserGetbymobileRequest();
            req.setMobile(phone);
            OapiV2UserGetbymobileResponse rsp = client.execute(req, this.cacheToken(appKey, appSecret));
            JSONObject jsonObject = new JSONObject(rsp.getBody());
            if (jsonObject.getStr("errmsg").equals("ok")) {
               JSONObject resultObject = jsonObject.getJSONObject("result");
               userIds.add(resultObject.getStr("userid"));
            }
         } catch (ApiException e) {
            log.info("Failed to get user by mobile: " + phone);
            e.printStackTrace();
         }
      });
      log.info(String.format("钉钉人员ID获取成功，userIds:%s", userIds));
      return userIds;
   }
}
