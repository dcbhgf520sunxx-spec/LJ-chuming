package com.hzchum.scim.rest.runner;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hzchum.scim.rest.controller.wms.wmsUse.client.WmsWebSocketClient;
import com.hzchum.scim.system.core.api.pojo._do.MesBuildingNestingTeam;
import com.hzchum.scim.system.core.api.service.MesBuildingNestingTeamService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order
@Component
public class NestWebSocketRunner implements CommandLineRunner {
   private static final String URL_TEMPLATE = "ws://pulsar-ws.fscut.com/ws/v2/consumer/non-persistent/prod/cloudnest/open_platform_{}/Exclusive-{}?consumerName=gc-client&receiverQueueSize=30&subscriptionType=Exclusive";
   @Autowired
   private MesBuildingNestingTeamService mesBuildingNestingTeamService;
   @Value("${chum.config.url}")
   private String companyUrl;

   private String getUrl(String teamCode, String subscriptionName) {
      return StrUtil.format(
         "ws://pulsar-ws.fscut.com/ws/v2/consumer/non-persistent/prod/cloudnest/open_platform_{}/Exclusive-{}?consumerName=gc-client&receiverQueueSize=30&subscriptionType=Exclusive",
         teamCode,
         subscriptionName
      );
   }

   @Override
   public void run(String... args) throws Exception {
      List<MesBuildingNestingTeam> mesBuildingNestingTeamList = this.mesBuildingNestingTeamService
         .list((Wrapper<MesBuildingNestingTeam>)new LambdaQueryWrapper<MesBuildingNestingTeam>().eq(MesBuildingNestingTeam::getBoolDrillHole, 1));

      for (MesBuildingNestingTeam mesBuildingNestingTeam : mesBuildingNestingTeamList.stream()
         .collect(Collectors.toMap(MesBuildingNestingTeam::getTeamCode, team -> (MesBuildingNestingTeam)team, (existing, replacement) -> existing))
         .values()
         .stream()
         .collect(Collectors.toList())) {
         WmsWebSocketClient wmsWebSocketClient = new WmsWebSocketClient();
         String teamCode = mesBuildingNestingTeam.getTeamCode();
         String url = this.getUrl(teamCode, String.valueOf(this.companyUrl.hashCode()));
         wmsWebSocketClient.startConnection(url);
      }
   }
}
