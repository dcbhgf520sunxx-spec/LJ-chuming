package com.hzchum.scim.rest.schedule;

import com.hzchum.scim.common.core.api.service.zhongnanoa.ShrPersonnelOrganizationServier;
import com.hzchum.scim.crm.core.api.service.CrmProjectInformationWarehousingService;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ShrPersonnelOrganizationSchedule {
   private static final Logger log = LoggerFactory.getLogger(ShrPersonnelOrganizationSchedule.class);
   @Resource
   private ShrPersonnelOrganizationServier shrService;
   @Resource
   private CrmProjectInformationWarehousingService crmProjectInformationWarehousingService;

   @Scheduled(cron = "0 0 3 * * ?")
   public void task() {
      this.shrService.syncSHRDept();
      log.info("定时任务：同步SHR部门");
      this.shrService.syncSHRJob();
      log.info("定时任务：同步SHR岗位");
      this.shrService.syncSHRUser();
      log.info("定时任务：同步SHR用户");
      this.crmProjectInformationWarehousingService.updateInformationOperatorDeptId();
   }
}
