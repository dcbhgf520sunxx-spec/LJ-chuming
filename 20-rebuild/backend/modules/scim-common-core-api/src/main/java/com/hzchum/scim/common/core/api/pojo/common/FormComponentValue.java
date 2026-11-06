package com.hzchum.scim.common.core.api.pojo.common;

public class FormComponentValue {
   private String name;
   private String value;
   private String ext_value;

   public FormComponentValue(String name, String value) {
      this.name = name;
      this.value = value;
   }

   public String getName() {
      return this.name;
   }

   public String getValue() {
      return this.value;
   }

   public String getExt_value() {
      return this.ext_value;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setValue(final String value) {
      this.value = value;
   }

   public void setExt_value(final String ext_value) {
      this.ext_value = ext_value;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof FormComponentValue)) {
         return false;
      }

      FormComponentValue other = (FormComponentValue)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$name = this.getName();
      Object other$name = other.getName();
      if (this$name == null ? other$name == null : this$name.equals(other$name)) {
         Object this$value = this.getValue();
         Object other$value = other.getValue();
         if (this$value == null ? other$value == null : this$value.equals(other$value)) {
            Object this$ext_value = this.getExt_value();
            Object other$ext_value = other.getExt_value();
            return this$ext_value == null ? other$ext_value == null : this$ext_value.equals(other$ext_value);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof FormComponentValue;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $value = this.getValue();
      result = result * 59 + ($value == null ? 43 : $value.hashCode());
      Object $ext_value = this.getExt_value();
      return result * 59 + ($ext_value == null ? 43 : $ext_value.hashCode());
   }

   @Override
   public String toString() {
      return "FormComponentValue(name=" + this.getName() + ", value=" + this.getValue() + ", ext_value=" + this.getExt_value() + ")";
   }
}
