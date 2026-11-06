package com.hzchum.scim.mes.building.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum MesLossWorkProgressStatisticsEnum {
   RAW_MATERIAL_OUTFLOW(1, "原料出库"),
   RAW_MATERIAL_FEEDING(2, "原料投料"),
   RAW_MATERIAL_RETURN(3, "原料退库"),
   RAW_MATERIAL_REQUISITION(4, "原料实际领料"),
   PARTS_ALLOCATION(5, "零件调拨"),
   SCHEDULING(6, "排产"),
   PROCESS_TASK(7, "工序任务"),
   IN_PRODUCTION(8, "待制品"),
   FINISHED(9, "制成品");

   private int type;
   private String name;

   MesLossWorkProgressStatisticsEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<MesLossWorkProgressStatisticsEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public static String getTitleByType(int type, Integer productType) {
      StringBuilder title = new StringBuilder();
      title.append(ProductTypeEnum.getNameByType(productType));
      if (SCHEDULING.type == type) {
         title.append("排产详情");
      }

      if (IN_PRODUCTION.type == type) {
         if (ProductTypeEnum.MACHINE_PART.getType().equals(productType)) {
            title.append("待制品统计");
         } else {
            title.append("在制品统计");
         }
      }

      if (FINISHED.type == type) {
         title.append("制成品统计");
      }

      if (PARTS_ALLOCATION.type == type) {
         title.append("调拨详情");
      }

      if (PROCESS_TASK.type == type) {
         title.append("工序任务详情");
      }

      return title.toString();
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
