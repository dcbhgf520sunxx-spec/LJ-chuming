package com.hzchum.scim.contract.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum ProjectBusinessTypeEnum {
   PROCESS(1, "加工承揽"),
   JOB(2, "项目承包"),
   INSTALL(4, "安装合同");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      Optional<ProjectBusinessTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.map(ProjectBusinessTypeEnum::getName).orElse(null);
   }

   public static Integer getTypeByName(String name) {
      Optional<ProjectBusinessTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getName().equals(name)).findFirst();
      return optional.map(ProjectBusinessTypeEnum::getType).orElse(null);
   }

   public static Boolean isExist(String name) {
      return Arrays.stream(values()).anyMatch(typeEnum -> typeEnum.getName().equals(name));
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   ProjectBusinessTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
