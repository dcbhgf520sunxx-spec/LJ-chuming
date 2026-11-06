package com.hzchum.scim.mes.building.core.api.enums;

import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingCoatingConfigDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

   public static PaintingTypeEnum getEnumByType(Integer type) {
      return Stream.of(values()).collect(Collectors.toMap(PaintingTypeEnum::getType, Function.identity())).get(type);
   }

   public static String getNameByType(Integer type) {
      Optional<PaintingTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.map(PaintingTypeEnum::getName).orElse(null);
   }

   public static Integer getTypeByName(String name) {
      return Stream.of(values()).filter(current -> Objects.equals(current.getName(), name)).findFirst().map(PaintingTypeEnum::getType).orElse(null);
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public static List<MesBuildingCoatingConfigDTO> listAll() {
      List<MesBuildingCoatingConfigDTO> responseVOS = new ArrayList<>();

      for (PaintingTypeEnum typeEnum : values()) {
         responseVOS.add(MesBuildingCoatingConfigDTO.builder().type(typeEnum.getType()).name(typeEnum.getName()).build());
      }

      return responseVOS;
   }
}
