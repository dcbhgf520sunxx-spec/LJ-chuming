package com.hzchum.scim.wms.core.api.enums;

public enum ReturnDestinationEnum {
   ORIGINAL_ROAD_RETURN(1, "按出库原路返回"),
   DIRECT_RETURN_PUBLIC_WARE(2, "直接退库到公共库");

   private Integer type;
   private String name;

   ReturnDestinationEnum(int type, String name) {
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
