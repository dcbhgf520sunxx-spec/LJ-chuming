package com.hzchum.scim.bim.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum BimMenuBarEnum {
   PROJECT_TREE(1, "项目树"),
   COMPONENT_TREE(2, "构件树"),
   PRODUCTION_STATE(3, "生产状态"),
   SHIPMENT_STATUS(4, "发运状态"),
   INSTALLATION_CONDITION(5, "安装状态");

   private Integer type;
   private String name;

   BimMenuBarEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(Integer type) {
      Optional<BimMenuBarEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
