package com.hzchum.scim.wms.core.api.enums;

public enum OutboundFailDestinationEnum {
   returnMaterials(1, "直接回到物料仓库"),
   returnOutboundInventory(2, "退至【出库清单】列表");

   private final Integer type;
   private final String name;

   OutboundFailDestinationEnum(Integer type, String name) {
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
