package com.hzchum.scim.rest.schedule;

import com.hzchum.scim.system.core.api.biz.ProjectInspectionTaskAbsencesRecordBiz;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
   private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
   @Resource
   private ProjectInspectionTaskAbsencesRecordBiz projectInspectionTaskAbsencesRecordBiz;

   @Scheduled(cron = "59 55 23 * * ?", zone = "GMT+8")
   public void generateInspectionTaskAbsencesRecord() {
      log.info("巡检缺卡记录生成开始-------");
      this.projectInspectionTaskAbsencesRecordBiz.generateInspectionTaskAbsencesRecord(null);
      log.info("巡检缺卡记录生成结束-------");
   }

   public ScheduledTasks(final ProjectInspectionTaskAbsencesRecordBiz projectInspectionTaskAbsencesRecordBiz) {
      this.projectInspectionTaskAbsencesRecordBiz = projectInspectionTaskAbsencesRecordBiz;
   }
}
