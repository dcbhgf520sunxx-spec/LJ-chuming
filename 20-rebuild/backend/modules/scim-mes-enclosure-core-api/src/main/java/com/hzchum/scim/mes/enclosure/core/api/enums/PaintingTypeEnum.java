package com.hzchum.scim.mes.enclosure.core.api.enums;

import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.statistica.MesEnclosureCoatingConfigDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum PaintingTypeEnum {
   PRIMER(1, "底漆"),
   INTERMEDIATE_PAINT(2, "中间漆"),
   TOPCOAT(4, "面漆");

   private final int type;
   private String name;

   PaintingTypeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(long type) {
      Optional<PaintingTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public static String getNameByType(Integer type) {
      Optional<PaintingTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.map(PaintingTypeEnum::getName).orElse(null);
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public static List<MesEnclosureCoatingConfigDTO> listAll() {
      List<MesEnclosureCoatingConfigDTO> responseVOS = new ArrayList<>();

      for (PaintingTypeEnum typeEnum : values()) {
         responseVOS.add(MesEnclosureCoatingConfigDTO.builder().type(typeEnum.getType()).name(typeEnum.getName()).build());
      }

      return responseVOS;
   }
}
