package com.hzchum.scim.common.core.api.enums;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.exception.BusinessException;
import java.util.ArrayList;
import java.util.List;

public enum OutboundTypeEnum {
   PRODUCTION_USE(1, "生产使用"),
   FOR_SALE(2, "对外出售"),
   TEMPORARY_LOAN(4, "临时借出"),
   OUTSOURCING_RAW_MATERIALS(8, "外协原料"),
   SCRAPS(16, "废料"),
   MANUFACTURED_OUT(32, "制成品出库"),
   SCHEDULING_OUTBOUND(128, "排产出库"),
   CONSTRUCTION_SITE_USE(256, "工地使用");

   private Integer type;
   private String name;

   OutboundTypeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public static List<Integer> getNameStr(Integer type) {
      OutboundTypeEnum[] classEnums = values();
      List<Integer> names = new ArrayList<>();

      for (OutboundTypeEnum classEnum : classEnums) {
         if ((classEnum.getType() & type) > 0) {
            names.add(classEnum.getType());
         }
      }

      return names;
   }

   public static String getNameByType(Integer type) {
      Preconditions.checkArgument(type != null, "出库类型值不能为空!");
      OutboundTypeEnum[] values = values();

      for (OutboundTypeEnum outboundTypeEnum : values) {
         if (type.equals(outboundTypeEnum.getType())) {
            return outboundTypeEnum.getName();
         }
      }

      throw new BusinessException("出库类型值不存在!");
   }

   OutboundTypeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
