package com.hzchum.scim.system.core.api.common.utils;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentService;
import java.time.LocalDateTime;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class ProjectSerialNumberUtils {
   @Resource
   private SupplierPaymentService supplierPaymentService;
   @Resource
   private RedisUtils redisUtils;

   public void redisSaveSerialNumber() {
      Integer voucherNumber = this.supplierPaymentService.getVoucherNumber();
      voucherNumber = ObjectUtils.isNotEmpty(voucherNumber) ? voucherNumber : 1;
      this.redisUtils.set("supplierPaymentNumber", voucherNumber + 1);
   }

   public String dateUtil(String number) {
      LocalDateTime now = LocalDateTime.now();
      int year = now.getYear() % 100;
      String month = String.format("%02d", now.getMonthValue());
      String day = String.format("%02d", now.getDayOfMonth());
      return year + month + day + number;
   }
}
