package com.hzchum.scim.rest.controller.wms.wmsUse.client;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hzchum.scim.cut.core.api.service.WmsNestMaterialService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNeedMachinePartSchedulingService;
import java.net.URI;
import java.util.Base64;
import java.util.Timer;
import java.util.TimerTask;
import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.ContainerProvider;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@ClientEndpoint
@Component
public class WmsWebSocketClient implements ApplicationContextAware {
   private static final Logger log = LoggerFactory.getLogger(WmsWebSocketClient.class);
   private Session session;
   private Timer heartBeatTimer;
   private String url = null;
   private static WmsNestMaterialService wmsNestMaterialService;
   private static MesBuildingTaskNeedMachinePartSchedulingService mesBuildingTaskNeedMachinePartSchedulingService;

   @Override
   public void setApplicationContext(ApplicationContext applicationContext) {
      wmsNestMaterialService = applicationContext.getBean(WmsNestMaterialService.class);
      mesBuildingTaskNeedMachinePartSchedulingService = applicationContext.getBean(MesBuildingTaskNeedMachinePartSchedulingService.class);
   }

   public void startConnection(String url) {
      try {
         WebSocketContainer container = ContainerProvider.getWebSocketContainer();
         container.connectToServer(this, new URI(url));
         this.url = url;
         this.startHeartBeat();
      } catch (Exception e) {
         log.error("套料ws连接错误:{}");
         e.printStackTrace();
      }
   }

   @OnOpen
   public void onOpen(Session session) {
      this.session = session;
      System.out.println("WebSocket 连接已建立");
      this.startHeartBeat();
   }

   @OnMessage
   @Transactional(rollbackFor = Exception.class)
   public void onMessage(String message) {
      log.info("收到柏楚套料完成推送到mes的消息：" + message);
      JSONObject jsonObject = JSONObject.parseObject(message);
      String payload = jsonObject.get("payload").toString();
      byte[] decode = Base64.getDecoder().decode(payload);
      String result = new String(decode);
      log.info("接受到套料软件的消息:{}", result);
      JSONObject resultObject = JSONObject.parseObject(result);
      String messageId = jsonObject.get("messageId").toString();
      this.sendBackMessage("{ \"messageId\": " + messageId + " }");
      if (resultObject.containsKey("type")) {
         String type = resultObject.getString("type");
         if (type.equals("SyncPlate")) {
            JSONObject objectData = resultObject.getJSONObject("object_data");
            String materialName = objectData.getString("material");
            Double thickness = objectData.getDouble("thickness");
            String syncKey = objectData.getString("sync_key");
            String teamCode = resultObject.getString("team_code");
            log.info("team_code：" + teamCode);
            wmsNestMaterialService.updatePlant(thickness, materialName, syncKey, teamCode);
         } else if (type.equals("ResultPushMes")) {
            JSONArray objectData = resultObject.getJSONArray("object_id");
            String teamCode = resultObject.getString("team_code");
            log.info("team_code：" + teamCode);
            if (resultObject.containsKey("job_id")) {
               Long job_id = resultObject.getLong("job_id");
               if (ObjectUtil.isNotEmpty(job_id)) {
                  wmsNestMaterialService.getJobPlant(job_id, objectData, teamCode, message);
               } else {
                  log.info("接收的套料推送消息job_id不存在:{}" + job_id);
               }
            } else {
               log.info("接收的套料推送消息不存在job_id键:{}" + resultObject);
            }
         }
      }
   }

   public void sendBackMessage(String backMessage) {
      try {
         this.session.getBasicRemote().sendText(backMessage);
         log.info("发送柏楚套料软件订阅消息：" + backMessage);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   @OnClose
   public void onClose(Session session, CloseReason closeReason) {
      log.info("WebSocket 连接关闭: " + closeReason.getReasonPhrase());
      this.reconnect();
   }

   @OnError
   public void onError(Session session, Throwable throwable) {
      log.info("WebSocket 套料错误:{} ", throwable.getMessage());
      this.reconnect();
   }

   private void reconnect() {
      try {
         log.info("WebSocket 尝试重新连接:{}", this.url);
         Thread.sleep(2000L);
         this.startConnection(this.url);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }

   private void startHeartBeat() {
      if (this.heartBeatTimer != null) {
         this.heartBeatTimer.cancel();
      }

      this.heartBeatTimer = new Timer(true);
      this.heartBeatTimer.scheduleAtFixedRate(new TimerTask() {
         @Override
         public void run() {
            WmsWebSocketClient.this.sendHeartBeat();
         }
      }, 0L, 5000L);
   }

   private void sendHeartBeat() {
      if (this.session != null && this.session.isOpen()) {
         String heartbeatMessage = "{\"messageId\": \"CAAQACAAMAE=\"}";

         try {
            this.session.getBasicRemote().sendText(heartbeatMessage);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }

   public void sendMessage(String message) {
      if (this.session != null && this.session.isOpen()) {
         this.session.getAsyncRemote().sendText(message);
      }
   }

   public void closeConnection() {
      try {
         if (this.session != null && this.session.isOpen()) {
            this.session.close();
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
