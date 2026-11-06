package com.hzchum.scim.rest.schedule;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.crm.core.api.enums.CrmCheckStatusEnum;
import com.hzchum.scim.crm.core.api.enums.CrmProjectScheduleTypeEnum;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectInformationWarehousing;
import com.hzchum.scim.crm.core.api.service.CrmProjectInformationWarehousingService;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CrmProjectValidityDeadlineCheckSchedule {
   private static final Logger log = LoggerFactory.getLogger(CrmProjectValidityDeadlineCheckSchedule.class);
   @Resource
   private CrmProjectInformationWarehousingService crmProjectInformationWarehousingService;

   @Scheduled(cron = "0 0 0 * * ?")
   public void crmProjectValidityDeadlineCheckSchedule() {
      List<CrmProjectInformationWarehousing> crmProjectInformationWarehousings = this.crmProjectInformationWarehousingService
         .list(
            Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class)
               .ne(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.LAPSE_STATUS.getType())
               .ne(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.BID_APPLICATION_STATUS.getType())
               .ne(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.PREQUALIFICATION_STATUS.getType())
               .ne(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.WINNING_BIDDER.getType())
               .eq(CrmProjectInformationWarehousing::getCrmCheckStatusEnum, CrmCheckStatusEnum.PASS.getType())
               .ne(CrmProjectInformationWarehousing::getCrmProjectScheduleTypeEnum, CrmProjectScheduleTypeEnum.UNWINNING_BID.getType())
         );
      if (CollectionUtils.isNotEmpty(crmProjectInformationWarehousings)) {
         List<CrmProjectInformationWarehousing> updateList = new ArrayList<>();
         crmProjectInformationWarehousings.forEach(item -> {
            LocalDate localDate = LocalDate.now();
            long daysBetween = ChronoUnit.DAYS.between(localDate, item.getUpdateTime().toLocalDate().plusDays(item.getValidityOfRegistration().intValue()));
            if (daysBetween <= 0L) {
               daysBetween = 0L;
            }

            if (daysBetween <= 0L) {
               item.setCrmProjectScheduleTypeEnum(CrmProjectScheduleTypeEnum.LAPSE_STATUS.getType());
               updateList.add(item);
            }
         });
         if (CollectionUtils.isNotEmpty(updateList)) {
            this.crmProjectInformationWarehousingService.updateBatchById(updateList);
         }
      }
   }

   public CrmProjectValidityDeadlineCheckSchedule(final CrmProjectInformationWarehousingService crmProjectInformationWarehousingService) {
      this.crmProjectInformationWarehousingService = crmProjectInformationWarehousingService;
   }
}
