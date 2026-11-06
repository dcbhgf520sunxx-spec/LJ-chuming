package com.hzchum.scim.system.core.api.pojo.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DictionaryUpdateRequestVO {
   @NotNull(message = "字典id不能为空")
   private Long id;
   @NotBlank(message = "字典详情名称不能为空")
   private String label;
   @NotNull(message = "字典详情值不能为空")
   private String value;
   @NotNull(message = "排序不能为空")
   private Integer sort;

   public Long getId() {
      return this.id;
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

   public void setId(final Long id) {
      this.id = id;
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

      if (!(o instanceof DictionaryUpdateRequestVO)) {
         return false;
      }

      DictionaryUpdateRequestVO other = (DictionaryUpdateRequestVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sort = this.getSort();
         Object other$sort = other.getSort();
         if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
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
      return other instanceof DictionaryUpdateRequestVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $label = this.getLabel();
      result = result * 59 + ($label == null ? 43 : $label.hashCode());
      Object $value = this.getValue();
      return result * 59 + ($value == null ? 43 : $value.hashCode());
   }

   @Override
   public String toString() {
      return "DictionaryUpdateRequestVO(id=" + this.getId() + ", label=" + this.getLabel() + ", value=" + this.getValue() + ", sort=" + this.getSort() + ")";
   }
}
