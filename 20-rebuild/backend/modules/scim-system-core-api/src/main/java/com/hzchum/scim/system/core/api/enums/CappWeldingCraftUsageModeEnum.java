package com.hzchum.scim.system.core.api.enums;

public enum CappWeldingCraftUsageModeEnum {
   LINK_PRODUCTION_PROCESS(1, "强制关联工序生产流程"),
   INDEPENDENT_MANIFESTATION(2, "不关联工序生产流程，独立体现焊接工艺业务流程"),
   ONLY_DISPLAY(3, "仅做展示，不体现焊接工艺业务流程");

   private final Integer usageMode;
   private final String description;

   public Integer getUsageMode() {
      return this.usageMode;
   }

   public String getDescription() {
      return this.description;
   }

   CappWeldingCraftUsageModeEnum(final Integer usageMode, final String description) {
      this.usageMode = usageMode;
      this.description = description;
   }
}
