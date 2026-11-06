package com.hzchum.scim.rest.schedule;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SupplierAnnualEvaluateResetSchedule {
   private static final Logger log = LoggerFactory.getLogger(SupplierAnnualEvaluateResetSchedule.class);
   @Resource
   private SupplierService supplierService;

   @Scheduled(cron = "0 0 2 1 1 ?")
   @Transactional(rollbackFor = Exception.class)
   public void resetSupplierAnnualEvaluateStatus() {
      log.info("----------------- 供应商年度评价状态重置任务 start -----------------");

      try {
         boolean result = this.supplierService.update((Wrapper<Supplier>)Wrappers.<Supplier>lambdaUpdate().set(Supplier::getBoolAnnualEvaluated, Boolean.FALSE));
         if (result) {
            log.info("供应商年度评价状态重置任务执行成功");
         } else {
            log.warn("供应商年度评价状态重置任务执行失败");
         }
      } catch (Exception e) {
         log.error("供应商年度评价状态重置任务执行异常", e);
         throw e;
      }

      log.info("----------------- 供应商年度评价状态重置任务 end -----------------");
   }
}
