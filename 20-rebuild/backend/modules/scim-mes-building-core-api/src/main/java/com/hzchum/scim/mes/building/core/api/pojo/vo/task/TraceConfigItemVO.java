package com.hzchum.scim.mes.building.core.api.pojo.vo.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "TraceConfigItemVO", description = "溯源附加属性")
public class TraceConfigItemVO {
   @ApiModelProperty("字段名称")
   private String fieldName;
   @ApiModelProperty("字段值")
   private String fieldValue;

   public static TraceConfigItemVO.TraceConfigItemVOBuilder builder() {
      return new TraceConfigItemVO.TraceConfigItemVOBuilder();
   }

   public TraceConfigItemVO() {
   }

   public TraceConfigItemVO(final String fieldName, final String fieldValue) {
      this.fieldName = fieldName;
      this.fieldValue = fieldValue;
   }

   public String getFieldName() {
      return this.fieldName;
   }

   public String getFieldValue() {
      return this.fieldValue;
   }

   public TraceConfigItemVO setFieldName(final String fieldName) {
      this.fieldName = fieldName;
      return this;
   }

   public TraceConfigItemVO setFieldValue(final String fieldValue) {
      this.fieldValue = fieldValue;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof TraceConfigItemVO)) {
         return false;
      } else {
         TraceConfigItemVO other = (TraceConfigItemVO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$fieldName = this.getFieldName();
            Object other$fieldName = other.getFieldName();
            if (this$fieldName == null ? other$fieldName == null : this$fieldName.equals(other$fieldName)) {
               Object this$fieldValue = this.getFieldValue();
               Object other$fieldValue = other.getFieldValue();
               return this$fieldValue == null ? other$fieldValue == null : this$fieldValue.equals(other$fieldValue);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TraceConfigItemVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $fieldName = this.getFieldName();
      result = result * 59 + ($fieldName == null ? 43 : $fieldName.hashCode());
      Object $fieldValue = this.getFieldValue();
      return result * 59 + ($fieldValue == null ? 43 : $fieldValue.hashCode());
   }

   @Override
   public String toString() {
      return "TraceConfigItemVO(fieldName=" + this.getFieldName() + ", fieldValue=" + this.getFieldValue() + ")";
   }

   public static class TraceConfigItemVOBuilder {
      private String fieldName;
      private String fieldValue;

      TraceConfigItemVOBuilder() {
      }

      public TraceConfigItemVO.TraceConfigItemVOBuilder fieldName(final String fieldName) {
         this.fieldName = fieldName;
         return this;
      }

      public TraceConfigItemVO.TraceConfigItemVOBuilder fieldValue(final String fieldValue) {
         this.fieldValue = fieldValue;
         return this;
      }

      public TraceConfigItemVO build() {
         return new TraceConfigItemVO(this.fieldName, this.fieldValue);
      }

      @Override
      public String toString() {
         return "TraceConfigItemVO.TraceConfigItemVOBuilder(fieldName=" + this.fieldName + ", fieldValue=" + this.fieldValue + ")";
      }
   }
}
