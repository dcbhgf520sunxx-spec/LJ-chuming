package com.hzchum.scim.mes.building.core.api.enums.scheduling;

import java.util.HashMap;
import java.util.Map;

public enum CuttingType {
   CNC(1, "数控切割", CuttingType.SubType.CNC_FLAME, CuttingType.SubType.CNC_PLASMA, CuttingType.SubType.CNC_LASER, CuttingType.SubType.FLAME_STRIP),
   SEMI_AUTOMATIC(2, "半自动切割", CuttingType.SubType.SEMI_AUTOMATIC_SHEARING, CuttingType.SubType.SEMI_AUTOMATIC, CuttingType.SubType.SEMI_AUTOMATIC_COILING);

   private final int id;
   private final String category;
   private final CuttingType.SubType[] subTypes;

   CuttingType(int id, String category, CuttingType.SubType... subTypes) {
      this.id = id;
      this.category = category;
      this.subTypes = subTypes;
   }

   public static Map getCutSubTypes(String boolNestCutEnum) {
      Map<Integer, String> map = new HashMap<>(10);
      if (boolNestCutEnum.equals(1)) {
         CuttingType.SubType[] subTypes = CNC.getSubTypes();

         for (CuttingType.SubType subType : subTypes) {
            map.put(subType.getId(), subType.getDescription());
         }
      } else if (boolNestCutEnum.equals(2)) {
         CuttingType.SubType[] subTypes = SEMI_AUTOMATIC.getSubTypes();

         for (CuttingType.SubType subType : subTypes) {
            map.put(subType.getId(), subType.getDescription());
         }
      }

      return map;
   }

   public int getId() {
      return this.id;
   }

   public String getCategory() {
      return this.category;
   }

   public CuttingType.SubType[] getSubTypes() {
      return this.subTypes;
   }

   public enum SubType {
      CNC_FLAME(1, "数控火焰"),
      CNC_PLASMA(2, "数控等离子"),
      CNC_LASER(3, "数控激光"),
      FLAME_STRIP(4, "火焰直条"),
      SEMI_AUTOMATIC_SHEARING(1, "剪板"),
      SEMI_AUTOMATIC(2, "半自动"),
      SEMI_AUTOMATIC_COILING(3, "卷板");

      private final int id;
      private final String description;

      SubType(int id, String description) {
         this.id = id;
         this.description = description;
      }

      public int getId() {
         return this.id;
      }

      public String getDescription() {
         return this.description;
      }

      @Override
      public String toString() {
         return this.description;
      }

      public static CuttingType.SubType fromDescription(String description) {
         for (CuttingType.SubType type : values()) {
            if (type.getDescription().equals(description)) {
               return type;
            }
         }

         throw new IllegalArgumentException("No enum constant with description " + description);
      }
   }
}
