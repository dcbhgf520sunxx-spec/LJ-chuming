package com.hzchum.scim.common.core.api.config;

import cn.hutool.core.util.ObjectUtil;
import java.io.IOException;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
@ServerEndpoint("/websocket/{sid}/{userId}")
public class WebSocketServer {
   private static final Logger log = LoggerFactory.getLogger(WebSocketServer.class);
   private static AtomicInteger onlineCount = new AtomicInteger(0);
   private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<>();
   private Session session;
   private String sid = "";
   private String userId = "";

   @OnOpen
   public void onOpen(Session session, @PathParam("sid") String sid, @PathParam("userId") String userId) {
      this.session = session;
      webSocketSet.add(this);
      this.sid = sid;
      this.userId = userId;
      addOnlineCount();

      try {
         this.sendMessage("conn_success");
         log.info("有新客户端开始监听,sid=" + sid + ",当前在线人数为:" + getOnlineCount());
      } catch (IOException e) {
         log.error("websocket IO Exception");
      }
   }

   @OnClose
   public void onClose() {
      webSocketSet.remove(this);
      subOnlineCount();
      log.info("释放的sid=" + this.sid + "的客户端");
      this.releaseResource();
   }

   private void releaseResource() {
      log.info("有一连接关闭！当前在线人数为" + getOnlineCount());
   }

   @OnMessage
   public void onMessage(String message, Session session) {
      log.info("收到来自客户端 sid=" + this.sid + " 的信息:" + message);
      HashSet<String> sids = new HashSet<>();

      for (WebSocketServer item : webSocketSet) {
         sids.add(item.sid);
      }

      try {
         sendMessage("客户端 " + this.sid + "发布消息：" + message, sids);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   @OnError
   public void onError(Session session, Throwable error) {
      log.error(session.getBasicRemote() + "客户端发生错误");
      error.printStackTrace();
   }

   public static void sendMessage(String message, HashSet<String> toUserIds) throws IOException {
      log.info("推送消息到客户端 " + toUserIds + "，推送内容:" + message);

      for (WebSocketServer item : webSocketSet) {
         try {
            if (ObjectUtil.isEmpty(toUserIds) || toUserIds.size() <= 0) {
               item.sendMessage(message);
            } else if (toUserIds.contains(item.userId)) {
               item.sendMessage(message);
            }
         } catch (IOException e) {
            log.info("推送消息用户" + item.userId + "不在线");
         }
      }
   }

   public void sendMessage(String message) throws IOException {
      this.session.getBasicRemote().sendText(message);
   }

   public static int getOnlineCount() {
      return onlineCount.get();
   }

   public static void addOnlineCount() {
      onlineCount.getAndIncrement();
   }

   public static void subOnlineCount() {
      onlineCount.getAndDecrement();
   }

   public static CopyOnWriteArraySet<WebSocketServer> getWebSocketSet() {
      return webSocketSet;
   }
}
