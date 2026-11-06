package com.hzchum.scim.common.core.api.controller;

import com.hzchum.scim.common.core.api.config.WebSocketServer;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemController {
   @GetMapping("/socket/push")
   public Map pushMessage(@RequestParam("cid") String cid, @RequestParam("message") String message) {
      Map<String, Object> result = new HashMap<>();

      try {
         HashSet<String> sids = new HashSet<>();
         sids.add(cid);
         WebSocketServer.sendMessage("服务端推送消息：" + message, sids);
         result.put("code", cid);
         result.put("msg", message);
      } catch (IOException e) {
         e.printStackTrace();
      }

      return result;
   }
}
