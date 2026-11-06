package com.hzchum.scim.contract.core.api.enums;

public enum ScopeOfAuditEnum {
   CONTRACT_AUDIT(1, "合同审核"),
   SUPPLIER_AUDIT(2, "供应商审核");

   final Integer id;
   final String name;

   ScopeOfAuditEnum(final Integer id, final String name) {
      this.id = id;
      this.name = name;
   }

   public Integer getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }
}
