package com.hzchum.scim.rest.schedule;

import com.hzchum.scim.mes.building.core.api.service.attend.MesBuildingAttendanceStandConfigService;
import com.hzchum.scim.mes.building.core.api.service.attend.MesWxMsgService;
import com.hzchum.scim.project.core.api.service.attend.ProjectManageAttendanceService;
import com.hzchum.scim.project.core.api.service.attend.ProjectManageWxMsgService;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ProjectAttendanceSchedule {
   private static final Logger log = LoggerFactory.getLogger(ProjectAttendanceSchedule.class);
   @Resource
   private ProjectManageAttendanceService attendanceService;
   @Resource
   private ProjectManageWxMsgService wxMsgService;
   @Resource
   private MesBuildingAttendanceStandConfigService standConfigService;
   @Resource
   private MesWxMsgService mesWxMsgService;

   @Scheduled(cron = "1 0 0 * * ?")
   public void createAttendanceTask() {
      log.info("----------------- 考勤信息初始化 start -----------------");
      this.attendanceService.initToDayAttendanceInfo();
      this.standConfigService.generateAttendanceTask();
      // Rebuild: external WeChat message timers are outside the isolated local runtime.
      log.info("----------------- 考勤信息初始化 end -----------------");
   }
}
