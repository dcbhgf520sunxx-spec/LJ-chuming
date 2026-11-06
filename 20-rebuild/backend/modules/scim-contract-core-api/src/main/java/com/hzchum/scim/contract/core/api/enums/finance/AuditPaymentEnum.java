package com.hzchum.scim.contract.core.api.enums.finance;

public enum AuditPaymentEnum {
   PROCUREMENT_PAYMENT(1, "采购付款"),
   SUBCONTRACT_PAYMENT(2, "分包付款"),
   INCOMING_INVOICES(3, "进项发票"),
   OUTGOING_INVOICES(4, "销项发票"),
   LOGISTICS_PAYMENT(5, "物流付款"),
   LOGISTICS_INVOICES(6, "物流开票"),
   PURCHASE_SETTLEMENT(7, "采购结算"),
   PROJECT_SETTLEMENT(8, "项目结算"),
   SUBCONTRACT_SETTLEMENT(9, "分包结算"),
   PURCHASE_PRE_SETTLEMENT(10, "采购预结算"),
   SUBCONTRACT_PRE_SETTLEMENT(11, "分包预结算"),
   PROJECT_PRE_SETTLEMENT(12, "项目预结算"),
   PROJECT_COLLECTION(13, "项目收款"),
   TESTING_FEE(14, "检测费"),
   WATER_ELECTRICITY_FEE(15, "水电物业费"),
   REIMBURSEMENT_FEE(16, "报销费用"),
   STAFF_WAGE(17, "人员工资");

   private final Integer type;
   private final String name;

   public static AuditPaymentEnum getEnum(Integer type) {
      for (AuditPaymentEnum auditPaymentEnum : values()) {
         if (auditPaymentEnum.getType().equals(type)) {
            return auditPaymentEnum;
         }
      }

      throw new IllegalArgumentException("付款类型不存在");
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   AuditPaymentEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
