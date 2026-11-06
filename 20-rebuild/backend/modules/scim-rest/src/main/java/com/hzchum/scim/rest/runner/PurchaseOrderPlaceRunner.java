package com.hzchum.scim.rest.runner;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(105)
public class PurchaseOrderPlaceRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(PurchaseOrderPlaceRunner.class);
   @Resource
   private PurchaseOrderService purchaseOrderService;

   @Override
   public void run(String... args) throws Exception {
      int count = this.purchaseOrderService.count((Wrapper<PurchaseOrder>)new LambdaQueryWrapper<PurchaseOrder>().isNull(PurchaseOrder::getOrderPlace));
      if (count > 0) {
         this.purchaseOrderService.initUpdateOrderPlace();
      }
   }
}
