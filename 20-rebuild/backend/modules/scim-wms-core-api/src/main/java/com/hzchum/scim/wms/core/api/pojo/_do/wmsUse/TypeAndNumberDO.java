package com.hzchum.scim.wms.core.api.pojo._do.wmsUse;

public class TypeAndNumberDO {
   private Integer type;
   private Integer notPrinted;

   public static TypeAndNumberDO.TypeAndNumberDOBuilder builder() {
      return new TypeAndNumberDO.TypeAndNumberDOBuilder();
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getNotPrinted() {
      return this.notPrinted;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setNotPrinted(final Integer notPrinted) {
      this.notPrinted = notPrinted;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof TypeAndNumberDO)) {
         return false;
      } else {
         TypeAndNumberDO other = (TypeAndNumberDO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$notPrinted = this.getNotPrinted();
               Object other$notPrinted = other.getNotPrinted();
               return this$notPrinted == null ? other$notPrinted == null : this$notPrinted.equals(other$notPrinted);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TypeAndNumberDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $notPrinted = this.getNotPrinted();
      return result * 59 + ($notPrinted == null ? 43 : $notPrinted.hashCode());
   }

   @Override
   public String toString() {
      return "TypeAndNumberDO(type=" + this.getType() + ", notPrinted=" + this.getNotPrinted() + ")";
   }

   public TypeAndNumberDO(final Integer type, final Integer notPrinted) {
      this.type = type;
      this.notPrinted = notPrinted;
   }

   public TypeAndNumberDO() {
   }

   public static class TypeAndNumberDOBuilder {
      private Integer type;
      private Integer notPrinted;

      TypeAndNumberDOBuilder() {
      }

      public TypeAndNumberDO.TypeAndNumberDOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public TypeAndNumberDO.TypeAndNumberDOBuilder notPrinted(final Integer notPrinted) {
         this.notPrinted = notPrinted;
         return this;
      }

      public TypeAndNumberDO build() {
         return new TypeAndNumberDO(this.type, this.notPrinted);
      }

      @Override
      public String toString() {
         return "TypeAndNumberDO.TypeAndNumberDOBuilder(type=" + this.type + ", notPrinted=" + this.notPrinted + ")";
      }
   }
}
