package com.hzchum.scim.system.core.api.common.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WageConfigStatisticsModeEnum {
   ASSEMBLE(1, "按部件记"),
   ARTIFACT(2, "按构件记"),
   MACHINE_PART(3, "按零件记");

   private final Integer type;
   private final String name;
   private static final Map<Integer, WageConfigStatisticsModeEnum> TYPE_MAP = Stream.of(values())
      .collect(Collectors.toMap(WageConfigStatisticsModeEnum::getType, Function.identity()));

   public static String getNameByType(Integer type) {
      WageConfigStatisticsModeEnum modeEnum = TYPE_MAP.get(type);
      return modeEnum != null ? modeEnum.getName() : null;
   }

   public static WageConfigStatisticsModeEnum getEnumByType(Integer type) {
      return TYPE_MAP.get(type);
   }

   public static Boolean isExist(Integer type) {
      return TYPE_MAP.get(type) != null;
   }

   public static boolean existEliminateMachinePart(Integer type) {
      Map<Integer, WageConfigStatisticsModeEnum> typeMap = new HashMap<>(TYPE_MAP);
      typeMap.remove(MACHINE_PART.getType());
      return typeMap.get(type) != null;
   }

   public static boolean existEliminateAssemble(Integer type) {
      Map<Integer, WageConfigStatisticsModeEnum> typeMap = new HashMap<>(TYPE_MAP);
      typeMap.remove(ASSEMBLE.getType());
      return typeMap.get(type) != null;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   WageConfigStatisticsModeEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }
}
