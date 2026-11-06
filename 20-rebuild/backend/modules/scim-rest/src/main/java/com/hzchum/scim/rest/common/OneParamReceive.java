package com.hzchum.scim.rest.common;

import java.io.Serializable;

public class OneParamReceive<T> implements Serializable {
   private T value;

   public static <T> OneParamReceive.OneParamReceiveBuilder<T> builder() {
      return new OneParamReceive.OneParamReceiveBuilder<>();
   }

   public T getValue() {
      return this.value;
   }

   public void setValue(final T value) {
      this.value = value;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OneParamReceive)) {
         return false;
      }

      OneParamReceive<?> other = (OneParamReceive<?>)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$value = this.getValue();
      Object other$value = other.getValue();
      return this$value == null ? other$value == null : this$value.equals(other$value);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof OneParamReceive;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $value = this.getValue();
      return result * 59 + ($value == null ? 43 : $value.hashCode());
   }

   @Override
   public String toString() {
      return "OneParamReceive(value=" + this.getValue() + ")";
   }

   public OneParamReceive(final T value) {
      this.value = value;
   }

   public OneParamReceive() {
   }

   public static class OneParamReceiveBuilder<T> {
      private T value;

      OneParamReceiveBuilder() {
      }

      public OneParamReceive.OneParamReceiveBuilder<T> value(final T value) {
         this.value = value;
         return this;
      }

      public OneParamReceive<T> build() {
         return new OneParamReceive<>(this.value);
      }

      @Override
      public String toString() {
         return "OneParamReceive.OneParamReceiveBuilder(value=" + this.value + ")";
      }
   }
}
