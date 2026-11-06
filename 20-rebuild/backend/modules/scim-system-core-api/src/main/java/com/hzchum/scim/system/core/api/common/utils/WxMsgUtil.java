package com.hzchum.scim.system.core.api.common.utils;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hzchum.scim.common.core.api.config.WeChatAppConfigProperties;
import com.hzchum.scim.system.core.api.pojo.request.SendMsgToWxUserBaseInfoDTOParam;
import com.hzchum.scim.system.core.api.pojo.request.SendMsgToWxUserRequestDTOParam;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class WxMsgUtil {
   private static final Logger log = LoggerFactory.getLogger(WxMsgUtil.class);
   @Resource
   private WeChatAppConfigProperties appConfigProperties;
   @Resource
   private RedisUtils redisUtils;
   private static final ConcurrentHashMap<String, HashSet<SendMsgToWxUserBaseInfoDTOParam>> timerMap = new ConcurrentHashMap<>();

   public void createTimer(LocalDateTime remindTime, HashSet<SendMsgToWxUserBaseInfoDTOParam> dtoParamList) {
      final String key = remindTime.getHour() + ":" + remindTime.getMinute();
      if (timerMap.containsKey(key)) {
         timerMap.get(key).addAll(dtoParamList);
         log.info("合并推送任务--->>>微信推送任务:" + key);
      } else {
         final Timer timer = new Timer();
         Calendar calendar = Calendar.getInstance();
         calendar.set(11, remindTime.getHour());
         calendar.set(12, remindTime.getMinute());
         calendar.set(13, 0);
         calendar.set(14, 0);
         Date date = calendar.getTime();
         timer.schedule(new TimerTask() {
            @Override
            public void run() {
               WxMsgUtil.this.sendWxMsgBatch(WxMsgUtil.timerMap.get(key));
               timer.cancel();
            }
         }, date);
         log.info("微信推送任务:" + key);
         timerMap.put(key, dtoParamList);
      }
   }

   public void removeTimer(LocalDateTime remindTime, HashSet<SendMsgToWxUserBaseInfoDTOParam> removeParam) {
      String key = remindTime.getHour() + ":" + remindTime.getMinute();
      if (timerMap.containsKey(key)) {
         timerMap.get(key).removeAll(removeParam);
         log.info("移除推送任务--->>>微信推送任务:" + key + " 用户：" + removeParam);
      }
   }

   public void sendWxMsg(SendMsgToWxUserBaseInfoDTOParam baseParam) {
      String wxToken = this.getWxToken();
      SendMsgToWxUserRequestDTOParam requestParam = new SendMsgToWxUserRequestDTOParam();
      requestParam.setData(baseParam.getData());
      requestParam.setTouser(baseParam.getTouser());
      String post = HttpUtil.post(
         this.appConfigProperties.getEndpoint() + "/cgi-bin/message/subscribe/send?access_token=" + wxToken, JSONObject.toJSONString(requestParam)
      );
      log.info("提醒通知(用户:" + requestParam.getTouser() + ")--->>>结果:" + post);
   }

   public void sendWxMsgBatch(HashSet<SendMsgToWxUserBaseInfoDTOParam> baseParamList) {
      if (!CollectionUtils.isEmpty(baseParamList)) {
         String wxToken = this.getWxToken();
         baseParamList.parallelStream()
            .forEach(
               baseInfo -> {
                  SendMsgToWxUserRequestDTOParam requestParam = new SendMsgToWxUserRequestDTOParam();
                  requestParam.setData(baseInfo.getData());
                  requestParam.setPage(baseInfo.getPage());
                  requestParam.setTouser(baseInfo.getTouser());
                  String post = HttpUtil.post(
                     this.appConfigProperties.getEndpoint() + "/cgi-bin/message/subscribe/send?access_token=" + wxToken, JSONObject.toJSONString(requestParam)
                  );
                  log.info("提醒通知(用户:" + requestParam.getTouser() + ")--->>>结果:" + post);
               }
            );
      }
   }

   public void clearMap() {
      timerMap.clear();
   }

   private String getWxToken() {
      HashMap<String, Object> tokenParamMap = new HashMap<>();
      tokenParamMap.put("appid", this.appConfigProperties.getAppid());
      tokenParamMap.put("secret", this.appConfigProperties.getSecret());
      String accessToken;
      if (this.redisUtils.hasKey("wx_msg_token")) {
         accessToken = String.valueOf(this.redisUtils.get("wx_msg_token"));
      } else {
         String responseJson = HttpUtil.get(this.appConfigProperties.getEndpoint() + "/cgi-bin/token?grant_type=client_credential", tokenParamMap);
         JSONObject tokenJsonObject = JSON.parseObject(responseJson);
         accessToken = tokenJsonObject.getString("access_token");
         if (StringUtils.isNotBlank(accessToken)) {
            this.redisUtils.set("wx_msg_token", accessToken, 7000L);
         }
      }

      return accessToken;
   }
}
