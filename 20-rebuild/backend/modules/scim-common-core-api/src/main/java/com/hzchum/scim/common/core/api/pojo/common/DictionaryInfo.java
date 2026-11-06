package com.hzchum.scim.common.core.api.pojo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("字典表 简单信息")
public class DictionaryInfo {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "value", notes = "字典详情值(在某个字典类型下，详情值都是唯一的)")
   private String value;
   @ApiModelProperty(name = "label", notes = "字典详情名称(在某个字典类型下，详情名称都是唯一的)")
   private String label;

   public static DictionaryInfo.DictionaryInfoBuilder builder() {
      return new DictionaryInfo.DictionaryInfoBuilder();
   }

   public DictionaryInfo() {
   }

   public DictionaryInfo(final Long id, final String value, final String label) {
      this.id = id;
      this.value = value;
      this.label = label;
   }

   public Long getId() {
      return this.id;
   }

   public String getValue() {
      return this.value;
   }

   public String getLabel() {
      return this.label;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setValue(final String value) {
      this.value = value;
   }

   public void setLabel(final String label) {
      this.label = label;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DictionaryInfo)) {
         return false;
      }

      DictionaryInfo other = (DictionaryInfo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$value = this.getValue();
         Object other$value = other.getValue();
         if (this$value == null ? other$value == null : this$value.equals(other$value)) {
            Object this$label = this.getLabel();
            Object other$label = other.getLabel();
            return this$label == null ? other$label == null : this$label.equals(other$label);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DictionaryInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $value = this.getValue();
      result = result * 59 + ($value == null ? 43 : $value.hashCode());
      Object $label = this.getLabel();
      return result * 59 + ($label == null ? 43 : $label.hashCode());
   }

   @Override
   public String toString() {
      return "DictionaryInfo(id=" + this.getId() + ", value=" + this.getValue() + ", label=" + this.getLabel() + ")";
   }

   public static class DictionaryInfoBuilder {
      private Long id;
      private String value;
      private String label;

      DictionaryInfoBuilder() {
      }

      public DictionaryInfo.DictionaryInfoBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public DictionaryInfo.DictionaryInfoBuilder value(final String value) {
         this.value = value;
         return this;
      }

      public DictionaryInfo.DictionaryInfoBuilder label(final String label) {
         this.label = label;
         return this;
      }

      public DictionaryInfo build() {
         return new DictionaryInfo(this.id, this.value, this.label);
      }

      @Override
      public String toString() {
         return "DictionaryInfo.DictionaryInfoBuilder(id=" + this.id + ", value=" + this.value + ", label=" + this.label + ")";
      }
   }
}
