package com.hzchum.scim.common.core.api.pojo.dto.oa;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import java.util.List;

@ApiModel("OA返回工作流")
public class ZhongNanWorkflowMainTableInfo {
   @JsonProperty("表名")
   private String tableDBName;
   @JsonProperty("记录")
   private List<ZhongNanRequestRecords> requestRecords;

   public static ZhongNanWorkflowMainTableInfo.ZhongNanWorkflowMainTableInfoBuilder builder() {
      return new ZhongNanWorkflowMainTableInfo.ZhongNanWorkflowMainTableInfoBuilder();
   }

   public ZhongNanWorkflowMainTableInfo() {
   }

   public ZhongNanWorkflowMainTableInfo(final String tableDBName, final List<ZhongNanRequestRecords> requestRecords) {
      this.tableDBName = tableDBName;
      this.requestRecords = requestRecords;
   }

   public String getTableDBName() {
      return this.tableDBName;
   }

   public List<ZhongNanRequestRecords> getRequestRecords() {
      return this.requestRecords;
   }

   @JsonProperty("表名")
   public ZhongNanWorkflowMainTableInfo setTableDBName(final String tableDBName) {
      this.tableDBName = tableDBName;
      return this;
   }

   @JsonProperty("记录")
   public ZhongNanWorkflowMainTableInfo setRequestRecords(final List<ZhongNanRequestRecords> requestRecords) {
      this.requestRecords = requestRecords;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ZhongNanWorkflowMainTableInfo)) {
         return false;
      } else {
         ZhongNanWorkflowMainTableInfo other = (ZhongNanWorkflowMainTableInfo)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$tableDBName = this.getTableDBName();
            Object other$tableDBName = other.getTableDBName();
            if (this$tableDBName == null ? other$tableDBName == null : this$tableDBName.equals(other$tableDBName)) {
               Object this$requestRecords = this.getRequestRecords();
               Object other$requestRecords = other.getRequestRecords();
               return this$requestRecords == null ? other$requestRecords == null : this$requestRecords.equals(other$requestRecords);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ZhongNanWorkflowMainTableInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $tableDBName = this.getTableDBName();
      result = result * 59 + ($tableDBName == null ? 43 : $tableDBName.hashCode());
      Object $requestRecords = this.getRequestRecords();
      return result * 59 + ($requestRecords == null ? 43 : $requestRecords.hashCode());
   }

   @Override
   public String toString() {
      return "ZhongNanWorkflowMainTableInfo(tableDBName=" + this.getTableDBName() + ", requestRecords=" + this.getRequestRecords() + ")";
   }

   public static class ZhongNanWorkflowMainTableInfoBuilder {
      private String tableDBName;
      private List<ZhongNanRequestRecords> requestRecords;

      ZhongNanWorkflowMainTableInfoBuilder() {
      }

      @JsonProperty("表名")
      public ZhongNanWorkflowMainTableInfo.ZhongNanWorkflowMainTableInfoBuilder tableDBName(final String tableDBName) {
         this.tableDBName = tableDBName;
         return this;
      }

      @JsonProperty("记录")
      public ZhongNanWorkflowMainTableInfo.ZhongNanWorkflowMainTableInfoBuilder requestRecords(final List<ZhongNanRequestRecords> requestRecords) {
         this.requestRecords = requestRecords;
         return this;
      }

      public ZhongNanWorkflowMainTableInfo build() {
         return new ZhongNanWorkflowMainTableInfo(this.tableDBName, this.requestRecords);
      }

      @Override
      public String toString() {
         return "ZhongNanWorkflowMainTableInfo.ZhongNanWorkflowMainTableInfoBuilder(tableDBName="
            + this.tableDBName
            + ", requestRecords="
            + this.requestRecords
            + ")";
      }
   }
}
