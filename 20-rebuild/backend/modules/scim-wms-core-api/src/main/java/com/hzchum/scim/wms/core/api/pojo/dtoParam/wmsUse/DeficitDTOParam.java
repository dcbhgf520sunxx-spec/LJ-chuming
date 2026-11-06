package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.util.List;

public class DeficitDTOParam {
   private Integer basicClass;
   private Integer deficitType;
   List<DeficitDTODetailParam> list;

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Integer getDeficitType() {
      return this.deficitType;
   }

   public List<DeficitDTODetailParam> getList() {
      return this.list;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setDeficitType(final Integer deficitType) {
      this.deficitType = deficitType;
   }

   public void setList(final List<DeficitDTODetailParam> list) {
      this.list = list;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DeficitDTOParam)) {
         return false;
      }

      DeficitDTOParam other = (DeficitDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$basicClass = this.getBasicClass();
      Object other$basicClass = other.getBasicClass();
      if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
         Object this$deficitType = this.getDeficitType();
         Object other$deficitType = other.getDeficitType();
         if (this$deficitType == null ? other$deficitType == null : this$deficitType.equals(other$deficitType)) {
            Object this$list = this.getList();
            Object other$list = other.getList();
            return this$list == null ? other$list == null : this$list.equals(other$list);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DeficitDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $deficitType = this.getDeficitType();
      result = result * 59 + ($deficitType == null ? 43 : $deficitType.hashCode());
      Object $list = this.getList();
      return result * 59 + ($list == null ? 43 : $list.hashCode());
   }

   @Override
   public String toString() {
      return "DeficitDTOParam(basicClass=" + this.getBasicClass() + ", deficitType=" + this.getDeficitType() + ", list=" + this.getList() + ")";
   }
}
