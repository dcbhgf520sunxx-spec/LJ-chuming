package com.hzchum.scim.mes.building.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum QhseStatusEnum {
   UN_RECTIFIED(1, "未回复"),
   RECTIFIED(2, "已回复待确认"),
   ADOPT(4, "整改通过"),
   UN_ADOPT(8, "整改未通过"),
   CONCESSION_ACCEPTED(16, "让步接收"),
   CONCESSION_ACCEPTED_APPROVED(32, "让步接收通过"),
   CONCESSION_ACCEPTED_UN_APPROVED(64, "让步接收驳回");

   private int type;
   private String name;

   QhseStatusEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<QhseStatusEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public static String getVal(int type) {
      Optional<QhseStatusEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.get().getName();
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public static String getNameByType(Integer type) {
      Optional<QhseStatusEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.map(QhseStatusEnum::getName).orElse(null);
   }
}
