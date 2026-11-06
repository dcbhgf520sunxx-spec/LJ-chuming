package com.hzchum.scim.system.core.api.pojo.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DictionarySaveDTOParam {
   @NotBlank(message = "字典名称不能为空")
   private String name;
   @NotBlank(message = "字典详情名称不能为空")
   private String label;
   private String value;
   @NotNull(message = "排序不能为空")
   private Integer sort;

   public String getName() {
      return this.name;
   }

   public String getLabel() {
      return this.label;
   }

   public String getValue() {
      return this.value;
   }

   public Integer getSort() {
      return this.sort;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setLabel(final String label) {
      this.label = label;
   }

   public void setValue(final String value) {
      this.value = value;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DictionarySaveDTOParam)) {
         return false;
      }

      DictionarySaveDTOParam other = (DictionarySaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$sort = this.getSort();
      Object other$sort = other.getSort();
      if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$label = this.getLabel();
            Object other$label = other.getLabel();
            if (this$label == null ? other$label == null : this$label.equals(other$label)) {
               Object this$value = this.getValue();
               Object other$value = other.getValue();
               return this$value == null ? other$value == null : this$value.equals(other$value);
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DictionarySaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $label = this.getLabel();
      result = result * 59 + ($label == null ? 43 : $label.hashCode());
      Object $value = this.getValue();
      return result * 59 + ($value == null ? 43 : $value.hashCode());
   }

   @Override
   public String toString() {
      return "DictionarySaveDTOParam(name=" + this.getName() + ", label=" + this.getLabel() + ", value=" + this.getValue() + ", sort=" + this.getSort() + ")";
   }
}
