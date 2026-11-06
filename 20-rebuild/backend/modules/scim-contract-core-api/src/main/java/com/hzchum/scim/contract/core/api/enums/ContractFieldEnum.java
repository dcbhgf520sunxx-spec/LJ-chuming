package com.hzchum.scim.contract.core.api.enums;

public enum ContractFieldEnum {
   STRUCTURE_TYPE(1, "结构类型"),
   CONTRACTUAL_NATURE(2, "承包性质"),
   BIDDING_METHOD(3, "招标方式"),
   PARTY_TYPE(4, "甲方类别"),
   CONTRACT_TYPE(5, "合同类型"),
   FIRST_LEVEL_DEPT(6, "所属一级部门"),
   SECOND_LEVEL_DEPT(7, "所属二级部门");

   private Integer type;
   private String name;

   ContractFieldEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
