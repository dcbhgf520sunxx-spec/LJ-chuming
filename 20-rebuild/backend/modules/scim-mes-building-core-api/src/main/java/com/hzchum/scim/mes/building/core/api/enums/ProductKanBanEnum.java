package com.hzchum.scim.mes.building.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum ProductKanBanEnum {
   UNFINISHED_PART(1, "未完成零件"),
   UNFINISHED_ASSEMBLE(2, "未完成部件"),
   UNFINISHED_ARTIFACT(3, "未完成构件"),
   PARTIAL_COMPLETION_PART(4, "部分完成零件"),
   PARTIAL_COMPLETION_ASSEMBLE(5, "部分完成部件"),
   PARTIAL_COMPLETION_ARTIFACT(6, "部分完成构件"),
   FINISHED_PART(7, "已完成零件"),
   FINISHED_ASSEMBLE(8, "已完成部件"),
   FINISHED_ARTIFACT(9, "已完成构件"),
   UNFINISHED_CARGO(10, "未发运"),
   PARTIAL_COMPLETION_CARGO(11, "部分发运"),
   FINISHED_CARGO(12, "已发运");

   private Integer type;
   private String name;

   ProductKanBanEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<ProductKanBanEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public static boolean checkBoolArtifactType(Integer type) {
      return !FINISHED_ARTIFACT.type.equals(type) && !PARTIAL_COMPLETION_ARTIFACT.type.equals(type) && !UNFINISHED_ARTIFACT.type.equals(type);
   }
}
