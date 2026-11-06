package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport;

import javax.validation.constraints.NotBlank;

public class QueryByStr {
   @NotBlank(message = "参数不能为空")
   private String idsStr;

   public static QueryByStr.QueryByStrBuilder builder() {
      return new QueryByStr.QueryByStrBuilder();
   }

   public String getIdsStr() {
      return this.idsStr;
   }

   public void setIdsStr(final String idsStr) {
      this.idsStr = idsStr;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryByStr)) {
         return false;
      }

      QueryByStr other = (QueryByStr)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$idsStr = this.getIdsStr();
      Object other$idsStr = other.getIdsStr();
      return this$idsStr == null ? other$idsStr == null : this$idsStr.equals(other$idsStr);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof QueryByStr;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $idsStr = this.getIdsStr();
      return result * 59 + ($idsStr == null ? 43 : $idsStr.hashCode());
   }

   @Override
   public String toString() {
      return "QueryByStr(idsStr=" + this.getIdsStr() + ")";
   }

   public QueryByStr(final String idsStr) {
      this.idsStr = idsStr;
   }

   public QueryByStr() {
   }

   public static class QueryByStrBuilder {
      private String idsStr;

      QueryByStrBuilder() {
      }

      public QueryByStr.QueryByStrBuilder idsStr(final String idsStr) {
         this.idsStr = idsStr;
         return this;
      }

      public QueryByStr build() {
         return new QueryByStr(this.idsStr);
      }

      @Override
      public String toString() {
         return "QueryByStr.QueryByStrBuilder(idsStr=" + this.idsStr + ")";
      }
   }
}
