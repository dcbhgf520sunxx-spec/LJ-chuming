package com.hzchum.scim.rest.controller.contract;

import com.hzchum.scim.contract.core.api.enums.payment.SupplierPropertyTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPayment;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.util.Objects;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/** Bind the shared legacy audit to the stored payment family, independently of logistics detail subtypes. */
@Component("supplierPaymentAccess")
public class SupplierPaymentAccess {
   @Resource private SupplierPaymentService payments;

   public boolean audit(Long id) {
      SecurityUser user = UserUtil.getCurrentUser();
      SupplierPayment payment = id == null ? null : payments.getById(id);
      if (user == null || payment == null) return false;
      if (user.isAdmin()) return true;
      String permission;
      if (Objects.equals(payment.getPropertyType(), SupplierPropertyTypeEnum.TRANSPORT_FEE.getType())) {
         permission = "contract_supplier_logistics_payment:audit";
      } else if (Objects.equals(payment.getPropertyType(), SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType())) {
         permission = "contract_supplier_material_payment:audit";
      } else {
         return false;
      }
      return user.getPermissions() != null && user.getPermissions().contains(permission);
   }
}
