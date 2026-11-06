package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.util.List;

public class QueryByMaterialIdsDTOParam {
   private List<Long> ids;
   private Boolean boolPartyA;

   public static QueryByMaterialIdsDTOParam.QueryByMaterialIdsDTOParamBuilder builder() {
      return new QueryByMaterialIdsDTOParam.QueryByMaterialIdsDTOParamBuilder();
   }

   public List<Long> getIds() {
      return this.ids;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public void setIds(final List<Long> ids) {
      this.ids = ids;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof QueryByMaterialIdsDTOParam)) {
         return false;
      } else {
         QueryByMaterialIdsDTOParam other = (QueryByMaterialIdsDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$boolPartyA = this.getBoolPartyA();
            Object other$boolPartyA = other.getBoolPartyA();
            if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
               Object this$ids = this.getIds();
               Object other$ids = other.getIds();
               return this$ids == null ? other$ids == null : this$ids.equals(other$ids);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof QueryByMaterialIdsDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $ids = this.getIds();
      return result * 59 + ($ids == null ? 43 : $ids.hashCode());
   }

   @Override
   public String toString() {
      return "QueryByMaterialIdsDTOParam(ids=" + this.getIds() + ", boolPartyA=" + this.getBoolPartyA() + ")";
   }

   public QueryByMaterialIdsDTOParam(final List<Long> ids, final Boolean boolPartyA) {
      this.ids = ids;
      this.boolPartyA = boolPartyA;
   }

   public QueryByMaterialIdsDTOParam() {
   }

   public static class QueryByMaterialIdsDTOParamBuilder {
      private List<Long> ids;
      private Boolean boolPartyA;

      QueryByMaterialIdsDTOParamBuilder() {
      }

      public QueryByMaterialIdsDTOParam.QueryByMaterialIdsDTOParamBuilder ids(final List<Long> ids) {
         this.ids = ids;
         return this;
      }

      public QueryByMaterialIdsDTOParam.QueryByMaterialIdsDTOParamBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public QueryByMaterialIdsDTOParam build() {
         return new QueryByMaterialIdsDTOParam(this.ids, this.boolPartyA);
      }

      @Override
      public String toString() {
         return "QueryByMaterialIdsDTOParam.QueryByMaterialIdsDTOParamBuilder(ids=" + this.ids + ", boolPartyA=" + this.boolPartyA + ")";
      }
   }
}
