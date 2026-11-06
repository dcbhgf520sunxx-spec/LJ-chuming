package com.hzchum.scim.rest.schedule;

import cn.hutool.core.date.DateUtil;
import com.hzchum.scim.system.core.api.service.ConfigService;
import java.time.LocalDateTime;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SystemExpirationSmsSchedule {
   private static final Logger log = LoggerFactory.getLogger(SystemExpirationSmsSchedule.class);
   @Resource
   private ConfigService configService;

   @Scheduled(cron = "0 0 10 * * ?")
   public void checkSystemExpirationAndSendSms() {
      log.warn("系统到期前短信提醒查询且发送开始.......................");
      LocalDateTime now = LocalDateTime.now();
      String formattedDate = DateUtil.format(now, "yyyy-MM-dd HH:mm:ss");
      log.warn("当前时间:{}", formattedDate);
      this.configService.checkSystemExpirationAndSendSms(now);
      log.warn("系统到期前短信提醒查询且发送结束.......................");
   }

   @Scheduled(cron = "0 10/10 10-23 * * ?")
   public void smsCompensation() {
      log.warn("失败短信补偿发送开始.......................");
      this.configService.smsCompensation();
      log.warn("失败短信补偿发送结束.......................");
   }
}
