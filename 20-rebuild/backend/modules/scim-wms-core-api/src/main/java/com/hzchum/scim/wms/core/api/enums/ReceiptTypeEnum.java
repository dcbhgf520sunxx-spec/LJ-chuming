package com.hzchum.scim.wms.core.api.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public enum ReceiptTypeEnum {
   PREPARATION(1, "备料单"),
   REQUISITIONS(2, "申购单"),
   PURCHASE(11, "采购单"),
   INBOUND(12, "入库单"),
   OUTBOUND_APPLY(13, "出库申请单"),
   OUTBOUND(14, "出库单"),
   TRANSFER(15, "调拨单"),
   RETURN(16, "退库单"),
   REJECTED(17, "退货单"),
   CONVERT(22, "转换单"),
   LUMP_SUM_SYSTEM_PURCHASE(23, "包干制采购单"),
   SUPPLEMENT(25, "红冲单"),
   CUT_SURPLUS(26, "切割余料"),
   BORROW(27, "借用单"),
   FOR_SALE(28, "对外出售"),
   OUTSOURCING(29, "外协原料"),
   SCRAPS(30, "废料出库"),
   ADJUST(31, "入库金额调整单"),
   DEFICIT(32, "盘亏单"),
   MOVE_WAREHOUSE(50, "移库单"),
   SCRAP_MATERIAL(51, "废料（会对库存量进行减少，记录库存使用统计时用到）"),
   PLANT_CONVERT(158, "钢板转换单"),
   SURPLUS(55, "盘盈单"),
   CONSTRUCTION_SITE_USE(63, "工地使用");

   private Integer type;
   private String name;

   ReceiptTypeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<RejectEnum> optional = Arrays.stream(RejectEnum.values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public static String getName(Integer type) {
      String v = "";

      for (ReceiptTypeEnum value : values()) {
         if (value.getType().equals(type)) {
            v = value.getName();
         }
      }

      return v;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public static ArrayList getInbound() {
      ArrayList<Integer> objects = new ArrayList<>();
      objects.add(INBOUND.type);
      objects.add(REJECTED.type);
      objects.add(SURPLUS.type);
      objects.add(ADJUST.type);
      objects.add(SUPPLEMENT.type);
      objects.add(DEFICIT.type);
      objects.add(CONVERT.type);
      objects.add(FOR_SALE.type);
      objects.add(PLANT_CONVERT.type);
      return objects;
   }
}
