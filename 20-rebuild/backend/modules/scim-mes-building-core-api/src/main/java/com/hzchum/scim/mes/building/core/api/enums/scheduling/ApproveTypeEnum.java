package com.hzchum.scim.mes.building.core.api.enums.scheduling;

public enum ApproveTypeEnum {
   AutoCut(1, "数控"),
   FinishCut(2, "型材"),
   SemiAuto(3, "半自动");

   private final int type;
   private final String approveType;

   public int getType() {
      return this.type;
   }

   public String getApproveType() {
      return this.approveType;
   }

   ApproveTypeEnum(int type, String approveType) {
      this.type = type;
      this.approveType = approveType;
   }

   public static ApproveTypeEnum fromType(int type) {
      for (ApproveTypeEnum approveTypeEnum : values()) {
         if (approveTypeEnum.getType() == type) {
            return approveTypeEnum;
         }
      }

      return null;
   }
}
