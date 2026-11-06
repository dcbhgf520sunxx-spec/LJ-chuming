package com.hzchum.scim.contract.core.api.enums;

public enum PartyTypeEnum {
   PRIVATE_ENTERPRISE(1, "民企"),
   STATE_OWNED_ENTERPRISE(2, "国企"),
   CENTRAL_ENTERPRISES(3, "央企"),
   STATE_OWNED_ENTERPRISE_LISTED_COMPANY(4, "民企上市公司"),
   PRIVATE_ENTERPRISE_LISTED_COMPANY(5, "国企上市公司"),
   CENTRAL_ENTERPRISES_LISTED_COMPANY(6, "央企上市公司");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      for (PartyTypeEnum partyTypeEnum : values()) {
         if (partyTypeEnum.getType().equals(type)) {
            return partyTypeEnum.getName();
         }
      }

      return null;
   }

   public static Integer getTypeByName(String name) {
      for (PartyTypeEnum partyTypeEnum : values()) {
         if (partyTypeEnum.getName().equals(name)) {
            return partyTypeEnum.getType();
         }
      }

      return null;
   }

   public static Boolean isExist(String name) {
      for (PartyTypeEnum partyTypeEnum : values()) {
         if (partyTypeEnum.getName().equals(name)) {
            return true;
         }
      }

      return false;
   }

   PartyTypeEnum(final Integer type, final String name) {
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
