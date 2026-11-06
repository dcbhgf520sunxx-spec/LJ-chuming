package com.hzchum.scim.rest.controller.contract;

import com.hzchum.scim.contract.core.api.pojo._do.SupplierInvoice;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SupplierInvoiceSaveDTOParam;
import com.hzchum.scim.contract.core.api.service.SupplierInvoiceService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/** Shared legacy writes must use the permission belonging to the actual invoice family. */
@Component("supplierInvoiceAccess")
public class SupplierInvoiceAccess {
   @Resource private SupplierInvoiceService invoices;

   public boolean create(List<SupplierInvoiceSaveDTOParam> params) {
      return params != null && !params.isEmpty()
         && params.stream().allMatch(param -> param != null && allowed(param.getPropertyType(), "add"));
   }

   public boolean record(Long id, String action) {
      if (!"edit".equals(action) && !"audit".equals(action) && !"del".equals(action)) return false;
      SupplierInvoice invoice = id == null ? null : invoices.getById(id);
      return invoice != null && allowed(invoice.getPropertyType(), action);
   }

   private boolean allowed(Integer propertyType, String action) {
      if (propertyType == null) return false;
      String family;
      switch (propertyType) {
         case 1: family = "material"; break;
         case 2: family = "logistics"; break;
         case 4: family = "product"; break;
         case 8: family = "subcontract"; break;
         default: return false;
      }
      SecurityUser user = UserUtil.getCurrentUser();
      return user != null && (user.isAdmin() || user.getPermissions() != null
         && user.getPermissions().contains("contract_supplier_" + family + "_invoice:" + action));
   }
}
