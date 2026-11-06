package com.hzchum.scim.contract.core.api.enums;

import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum ConfirmStatusEnum {
   CONFIRMING(1, "确认中"),
   SUCCEED(2, "审核通过"),
   FAILED(4, "已驳回");

   private final Integer type;
   private final String name;

   public static Boolean isExist(Integer type) {
      Preconditions.checkArgument(type != null, "参数为空");
      List<Integer> enumTypeList = Arrays.stream(values()).map(ConfirmStatusEnum::getType).sorted().collect(Collectors.toList());
      return enumTypeList.contains(type);
   }

   ConfirmStatusEnum(final Integer type, final String name) {
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
