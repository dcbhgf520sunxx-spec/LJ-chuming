package com.hzchum.scim.system.core.api.enums;

import cn.hutool.core.util.ObjectUtil;
import java.util.Arrays;

public enum PartDrawingLayerProcessMethodEnum {
   PROCESS_NOWORK("process_nowork", "不加工"),
   PROCESS_MARK("process_mark", "打标"),
   PROCESS_WORK1("process_work1", "加工1"),
   PROCESS_WORK2("process_work2", "加工2"),
   PROCESS_WORK3("process_work3", "加工3");

   private final String type;
   private final String name;

   public static boolean isExist(String type) {
      return Arrays.stream(values()).anyMatch(e -> ObjectUtil.equal(e.getType(), type));
   }

   PartDrawingLayerProcessMethodEnum(final String type, final String name) {
      this.type = type;
      this.name = name;
   }

   public String getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
