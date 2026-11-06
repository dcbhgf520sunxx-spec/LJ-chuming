package com.hzchum.scim.rest.runner.crm;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.crm.core.api.enums.CrmSpecialBubmissionStatusEnum;
import com.hzchum.scim.crm.core.api.enums.CrmTenderRequestConfigEnum;
import com.hzchum.scim.crm.core.api.pojo._do.CrmApplyTechnologyBiddingRecord;
import com.hzchum.scim.crm.core.api.pojo._do.CrmTenderRequestConfig;
import com.hzchum.scim.crm.core.api.service.CrmApplyTechnologyBiddingRecordService;
import com.hzchum.scim.crm.core.api.service.CrmTenderRequestConfigService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

@Order(99)
public class CrmTenderRequestConfigRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(CrmTenderRequestConfigRunner.class);
   @Resource
   private CrmTenderRequestConfigService crmTenderRequestConfigService;
   @Resource
   private CrmApplyTechnologyBiddingRecordService crmApplyTechnologyBiddingRecordService;

   @Override
   public void run(String... args) throws Exception {
      List<CrmTenderRequestConfig> saveList = new ArrayList<>();

      for (CrmSpecialBubmissionStatusEnum specialBubmissionStatusEnum : CrmSpecialBubmissionStatusEnum.values()) {
         CrmTenderRequestConfig crmTenderRequestConfig = this.crmTenderRequestConfigService
            .getOne(
               Wrappers.lambdaQuery(CrmTenderRequestConfig.class)
                  .eq(CrmTenderRequestConfig::getCrmTenderRequestConfigEnum, CrmTenderRequestConfigEnum.JOB_DESCRIPTION.getType())
                  .eq(CrmTenderRequestConfig::getCrmSpecialBubmissionStatusEnum, specialBubmissionStatusEnum.getType())
                  .eq(CrmTenderRequestConfig::getName, "技术标")
            );
         if (crmTenderRequestConfig == null) {
            saveList.add(
               CrmTenderRequestConfig.builder()
                  .crmTenderRequestConfigEnum(CrmTenderRequestConfigEnum.JOB_DESCRIPTION.getType())
                  .crmSpecialBubmissionStatusEnum(specialBubmissionStatusEnum.getType())
                  .sort(1)
                  .name("技术标")
                  .build()
            );
         }

         CrmTenderRequestConfig crmTenderRequestConfig1 = this.crmTenderRequestConfigService
            .getOne(
               Wrappers.lambdaQuery(CrmTenderRequestConfig.class)
                  .eq(CrmTenderRequestConfig::getCrmTenderRequestConfigEnum, CrmTenderRequestConfigEnum.JOB_DESCRIPTION.getType())
                  .eq(CrmTenderRequestConfig::getCrmSpecialBubmissionStatusEnum, specialBubmissionStatusEnum.getType())
                  .eq(CrmTenderRequestConfig::getName, "措施标")
            );
         if (crmTenderRequestConfig1 == null) {
            saveList.add(
               CrmTenderRequestConfig.builder()
                  .crmTenderRequestConfigEnum(CrmTenderRequestConfigEnum.JOB_DESCRIPTION.getType())
                  .crmSpecialBubmissionStatusEnum(specialBubmissionStatusEnum.getType())
                  .sort(1)
                  .name("措施标")
                  .build()
            );
         }
      }

      if (CollectionUtils.isNotEmpty(saveList)) {
         this.crmTenderRequestConfigService.saveBatch(saveList);
      }

      Map<String, Long> newIdMap = this.crmTenderRequestConfigService
         .list(
            Wrappers.lambdaQuery(CrmTenderRequestConfig.class)
               .eq(CrmTenderRequestConfig::getCrmTenderRequestConfigEnum, CrmTenderRequestConfigEnum.JOB_DESCRIPTION.getType())
               .isNotNull(CrmTenderRequestConfig::getCrmSpecialBubmissionStatusEnum)
         )
         .stream()
         .collect(Collectors.toMap(e -> e.getCrmSpecialBubmissionStatusEnum() + "-" + e.getName(), CrmTenderRequestConfig::getId));
      Map<Long, CrmTenderRequestConfig> oldMap = this.crmTenderRequestConfigService
         .list(
            Wrappers.lambdaQuery(CrmTenderRequestConfig.class)
               .eq(CrmTenderRequestConfig::getCrmTenderRequestConfigEnum, CrmTenderRequestConfigEnum.JOB_DESCRIPTION.getType())
               .isNull(CrmTenderRequestConfig::getCrmSpecialBubmissionStatusEnum)
         )
         .stream()
         .collect(Collectors.toMap(CrmTenderRequestConfig::getId, Function.identity()));
      List<CrmApplyTechnologyBiddingRecord> updateList = new ArrayList<>();

      for (CrmApplyTechnologyBiddingRecord crmApplyTechnologyBiddingRecord : this.crmApplyTechnologyBiddingRecordService
         .list(
            Wrappers.lambdaQuery(CrmApplyTechnologyBiddingRecord.class)
               .in(CrmApplyTechnologyBiddingRecord::getTechnologyBidManagerJobDescriptionId, oldMap.keySet())
         )) {
         String key = crmApplyTechnologyBiddingRecord.getCrmSpecialBubmissionStatusEnum()
            + "-"
            + oldMap.get(crmApplyTechnologyBiddingRecord.getTechnologyBidManagerJobDescriptionId()).getName();
         Long newId = newIdMap.get(key);
         crmApplyTechnologyBiddingRecord.setTechnologyBidManagerJobDescriptionId(newId);
         updateList.add(crmApplyTechnologyBiddingRecord);
      }

      this.crmApplyTechnologyBiddingRecordService.updateBatchById(updateList);
   }

   public CrmTenderRequestConfigRunner(
      final CrmTenderRequestConfigService crmTenderRequestConfigService, final CrmApplyTechnologyBiddingRecordService crmApplyTechnologyBiddingRecordService
   ) {
      this.crmTenderRequestConfigService = crmTenderRequestConfigService;
      this.crmApplyTechnologyBiddingRecordService = crmApplyTechnologyBiddingRecordService;
   }
}
