package com.hzchum.scim.common.core.api.enums;

public enum TableNameTypeEnum {
   WMS_INBOUND(1, "入库表", "wms_inbound"),
   WMS_INBOUND_MANUFACTURED(2, "制成品入库表", "wms_inbound_manufactured");

   private Integer type;
   private String tableDescribe;
   private String tableName;

   TableNameTypeEnum(int type, String tableDescribe, String tableName) {
      this.type = type;
      this.tableDescribe = tableDescribe;
      this.tableName = tableName;
   }

   public Integer getType() {
      return this.type;
   }

   public String getTableDescribe() {
      return this.tableDescribe;
   }

   public String getTableName() {
      return this.tableName;
   }
}
