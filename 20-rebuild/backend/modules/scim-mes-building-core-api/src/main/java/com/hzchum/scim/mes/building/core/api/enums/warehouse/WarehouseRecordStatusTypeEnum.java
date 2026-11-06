package com.hzchum.scim.mes.building.core.api.enums.warehouse;

import com.hzchum.pangu.common.exception.BusinessException;
import java.util.Arrays;
import java.util.Optional;

public enum WarehouseRecordStatusTypeEnum {
   INTO(1, "入库"),
   PACKAGING(2, "打包"),
   CARGOLIST(4, "装车"),
   OUT(8, "发运");

   private final int type;
   private String name;

   WarehouseRecordStatusTypeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(long type) {
      Optional<WarehouseRecordStatusTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public static String getNameByType(Integer type) {
      for (WarehouseRecordStatusTypeEnum statusTypeEnum : values()) {
         if (type.equals(statusTypeEnum.getType())) {
            return statusTypeEnum.getName();
         }
      }

      throw new BusinessException("出入库状态类型传入错误!");
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
