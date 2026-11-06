package com.hzchum.scim.bim.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum BimStatusEnum {
   ALL(0, "所有"),
   NO_LIST(1, "无清单"),
   NO_PRODUCE(2, "未生产"),
   PRODUCTION(3, "生产中"),
   FINISHED_PRODUCTION(4, "生产完毕"),
   NO_STORAGE(5, "未入库"),
   STORAGE(6, "已入库"),
   OUTBOUND(7, "已发运"),
   IS_LIST(9, "有清单"),
   NO_RECEIVING(10, "未收货"),
   RECEIVING(11, "已收货"),
   FINISHED_INSTALLED(12, "已安装");

   private Integer type;
   private String name;

   BimStatusEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(Integer type) {
      Optional<BimStatusEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
