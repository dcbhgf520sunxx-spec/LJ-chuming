package com.hzchum.scim.wms.core.api.enums;

import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import java.util.Arrays;
import java.util.Optional;

public enum DataStatusEnum {
   USELESS(0, "失效(未创建成功撤销、创建中被退回)"),
   UNDER_REVIEW(1, "审批中"),
   SUCCEED(2, "已通过"),
   CANCELLATION_UNDER_WAY(3, "删除中"),
   CANCELLATION(4, "已删除"),
   CANCEL(8, "撤销");

   private Integer type;
   private String name;

   DataStatusEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<ReviewStatusEnum> optional = Arrays.stream(ReviewStatusEnum.values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
