package com.hzchum.scim.rest.runner;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.system.core.api.pojo._do.SysSupplierPaymentAttribute;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.SysSupplierPaymentAttributeService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SupplierPaymentAttributeRunner implements CommandLineRunner {
   private final SysSupplierPaymentAttributeService supplierPaymentAttributeService;
   private final UserService userService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void run(String... args) throws Exception {
      List<SysSupplierPaymentAttribute> paymentAttributeList = this.supplierPaymentAttributeService.list();
      if (paymentAttributeList.isEmpty()) {
         List<String> nameList = Arrays.asList("工程进度款", "工人工资", "机械费");
         User admin = this.userService.getOne(Wrappers.lambdaQuery(User.builder().username("admin").build()));
         nameList.forEach(
            name -> {
               int index = nameList.indexOf(name);
               SysSupplierPaymentAttribute attribute = SysSupplierPaymentAttribute.builder()
                  .name(name)
                  .boolEnableStatus(true)
                  .createUserId(admin != null ? admin.getId() : 0L)
                  .createUserName(admin != null ? admin.getName() : "")
                  .sort(index + 1)
                  .remark("系统初始化自动创建")
                  .build();
               paymentAttributeList.add(attribute);
            }
         );
         this.supplierPaymentAttributeService.saveBatch(paymentAttributeList);
      }
   }

   public SupplierPaymentAttributeRunner(final SysSupplierPaymentAttributeService supplierPaymentAttributeService, final UserService userService) {
      this.supplierPaymentAttributeService = supplierPaymentAttributeService;
      this.userService = userService;
   }
}
