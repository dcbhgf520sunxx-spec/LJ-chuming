package com.hzchum.scim.wms.core.common;

public class SimpleEntityParam<T, T2> {
   private T v;
   private T2 v2;

   public static <T, T2> SimpleEntityParam.SimpleEntityParamBuilder<T, T2> builder() {
      return new SimpleEntityParam.SimpleEntityParamBuilder<>();
   }

   public T getV() {
      return this.v;
   }

   public T2 getV2() {
      return this.v2;
   }

   public void setV(final T v) {
      this.v = v;
   }

   public void setV2(final T2 v2) {
      this.v2 = v2;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SimpleEntityParam)) {
         return false;
      } else {
         SimpleEntityParam<?, ?> other = (SimpleEntityParam<?, ?>)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$v = this.getV();
            Object other$v = other.getV();
            if (this$v == null ? other$v == null : this$v.equals(other$v)) {
               Object this$v2 = this.getV2();
               Object other$v2 = other.getV2();
               return this$v2 == null ? other$v2 == null : this$v2.equals(other$v2);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SimpleEntityParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $v = this.getV();
      result = result * 59 + ($v == null ? 43 : $v.hashCode());
      Object $v2 = this.getV2();
      return result * 59 + ($v2 == null ? 43 : $v2.hashCode());
   }

   @Override
   public String toString() {
      return "SimpleEntityParam(v=" + this.getV() + ", v2=" + this.getV2() + ")";
   }

   public SimpleEntityParam(final T v, final T2 v2) {
      this.v = v;
      this.v2 = v2;
   }

   public SimpleEntityParam() {
   }

   public static class SimpleEntityParamBuilder<T, T2> {
      private T v;
      private T2 v2;

      SimpleEntityParamBuilder() {
      }

      public SimpleEntityParam.SimpleEntityParamBuilder<T, T2> v(final T v) {
         this.v = v;
         return this;
      }

      public SimpleEntityParam.SimpleEntityParamBuilder<T, T2> v2(final T2 v2) {
         this.v2 = v2;
         return this;
      }

      public SimpleEntityParam<T, T2> build() {
         return new SimpleEntityParam<>(this.v, this.v2);
      }

      @Override
      public String toString() {
         return "SimpleEntityParam.SimpleEntityParamBuilder(v=" + this.v + ", v2=" + this.v2 + ")";
      }
   }
}
