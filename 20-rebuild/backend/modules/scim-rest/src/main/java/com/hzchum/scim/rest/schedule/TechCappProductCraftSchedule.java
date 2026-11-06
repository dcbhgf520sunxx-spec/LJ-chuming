package com.hzchum.scim.rest.schedule;

import com.hzchum.scim.plan.core.api.biz.TechCappCraftProductPassTaskBiz;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftProductTaskBiz;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TechCappProductCraftSchedule {
   private static final Logger log = LoggerFactory.getLogger(TechCappProductCraftSchedule.class);
   @Resource
   private TechCappCraftProductTaskBiz techCappCraftProductTaskBiz;
   @Resource
   private TechCappCraftProductPassTaskBiz techCappCraftProductPassTaskBiz;

   @Scheduled(cron = "0/1 * * * * ?")
   public void getCappProductCraftData() {
   }
}
