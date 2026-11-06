package com.hzchum.scim.wms.core.api.enums;

public enum MaterialFreezeTypeEnum {
   STOCK(1, "备料"),
   REQUISITIONS(2, "申购"),
   OUTBOUND(13, "出库"),
   TRANSFER(15, "调拨"),
   REJECTED(17, "退货"),
   NESTING(18, "套料"),
   CONVERT(22, "转换"),
   MANUAL(26, "手动"),
   BORROW(27, "借出"),
   FOR_SALE(28, "对外出售"),
   OUTSOURCING(29, "外协"),
   SCRAPS(30, "废料"),
   DEFICIT(32, "盘亏单"),
   MOVE_WAREHOUSE(50, "移库"),
   SCHEDULING_OUTBOUND(101, "排产出库"),
   CONSTRUCTION_SITE_USE(107, "工地使用");

   private final Integer type;
   private final String name;

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   MaterialFreezeTypeEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }
}
