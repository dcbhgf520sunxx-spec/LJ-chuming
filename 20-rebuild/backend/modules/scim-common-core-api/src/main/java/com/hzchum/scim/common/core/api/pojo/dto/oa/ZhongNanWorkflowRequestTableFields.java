package com.hzchum.scim.common.core.api.pojo.dto.oa;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;

@ApiModel("OA返回工作流")
public class ZhongNanWorkflowRequestTableFields {
   @JsonProperty("是否可以编辑")
   private String edit;
   @JsonProperty("字段类型")
   private String fieldDBType;
   @JsonProperty("表单名称")
   private String fieldFormName;
   @JsonProperty("类型")
   private String fieldHtmlType;
   @JsonProperty("id")
   private String fieldId;
   @JsonProperty("名称")
   private String fieldName;
   @JsonProperty("订单")
   private String fieldOrder;
   @JsonProperty("显示名称")
   private String fieldShowName;
   @JsonProperty("显示值")
   private String fieldShowValue;
   @JsonProperty("类型")
   private String fieldType;
   @JsonProperty("值")
   private String fieldValue;
   @JsonProperty("是否可以编辑")
   private String filedHtmlShow;

   public static ZhongNanWorkflowRequestTableFields.ZhongNanWorkflowRequestTableFieldsBuilder builder() {
      return new ZhongNanWorkflowRequestTableFields.ZhongNanWorkflowRequestTableFieldsBuilder();
   }

   public ZhongNanWorkflowRequestTableFields() {
   }

   public ZhongNanWorkflowRequestTableFields(
      final String edit,
      final String fieldDBType,
      final String fieldFormName,
      final String fieldHtmlType,
      final String fieldId,
      final String fieldName,
      final String fieldOrder,
      final String fieldShowName,
      final String fieldShowValue,
      final String fieldType,
      final String fieldValue,
      final String filedHtmlShow
   ) {
      this.edit = edit;
      this.fieldDBType = fieldDBType;
      this.fieldFormName = fieldFormName;
      this.fieldHtmlType = fieldHtmlType;
      this.fieldId = fieldId;
      this.fieldName = fieldName;
      this.fieldOrder = fieldOrder;
      this.fieldShowName = fieldShowName;
      this.fieldShowValue = fieldShowValue;
      this.fieldType = fieldType;
      this.fieldValue = fieldValue;
      this.filedHtmlShow = filedHtmlShow;
   }

   public String getEdit() {
      return this.edit;
   }

   public String getFieldDBType() {
      return this.fieldDBType;
   }

   public String getFieldFormName() {
      return this.fieldFormName;
   }

   public String getFieldHtmlType() {
      return this.fieldHtmlType;
   }

   public String getFieldId() {
      return this.fieldId;
   }

   public String getFieldName() {
      return this.fieldName;
   }

   public String getFieldOrder() {
      return this.fieldOrder;
   }

   public String getFieldShowName() {
      return this.fieldShowName;
   }

   public String getFieldShowValue() {
      return this.fieldShowValue;
   }

   public String getFieldType() {
      return this.fieldType;
   }

   public String getFieldValue() {
      return this.fieldValue;
   }

   public String getFiledHtmlShow() {
      return this.filedHtmlShow;
   }

   @JsonProperty("是否可以编辑")
   public ZhongNanWorkflowRequestTableFields setEdit(final String edit) {
      this.edit = edit;
      return this;
   }

   @JsonProperty("字段类型")
   public ZhongNanWorkflowRequestTableFields setFieldDBType(final String fieldDBType) {
      this.fieldDBType = fieldDBType;
      return this;
   }

   @JsonProperty("表单名称")
   public ZhongNanWorkflowRequestTableFields setFieldFormName(final String fieldFormName) {
      this.fieldFormName = fieldFormName;
      return this;
   }

   @JsonProperty("类型")
   public ZhongNanWorkflowRequestTableFields setFieldHtmlType(final String fieldHtmlType) {
      this.fieldHtmlType = fieldHtmlType;
      return this;
   }

   @JsonProperty("id")
   public ZhongNanWorkflowRequestTableFields setFieldId(final String fieldId) {
      this.fieldId = fieldId;
      return this;
   }

   @JsonProperty("名称")
   public ZhongNanWorkflowRequestTableFields setFieldName(final String fieldName) {
      this.fieldName = fieldName;
      return this;
   }

   @JsonProperty("订单")
   public ZhongNanWorkflowRequestTableFields setFieldOrder(final String fieldOrder) {
      this.fieldOrder = fieldOrder;
      return this;
   }

   @JsonProperty("显示名称")
   public ZhongNanWorkflowRequestTableFields setFieldShowName(final String fieldShowName) {
      this.fieldShowName = fieldShowName;
      return this;
   }

   @JsonProperty("显示值")
   public ZhongNanWorkflowRequestTableFields setFieldShowValue(final String fieldShowValue) {
      this.fieldShowValue = fieldShowValue;
      return this;
   }

   @JsonProperty("类型")
   public ZhongNanWorkflowRequestTableFields setFieldType(final String fieldType) {
      this.fieldType = fieldType;
      return this;
   }

   @JsonProperty("值")
   public ZhongNanWorkflowRequestTableFields setFieldValue(final String fieldValue) {
      this.fieldValue = fieldValue;
      return this;
   }

   @JsonProperty("是否可以编辑")
   public ZhongNanWorkflowRequestTableFields setFiledHtmlShow(final String filedHtmlShow) {
      this.filedHtmlShow = filedHtmlShow;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ZhongNanWorkflowRequestTableFields)) {
         return false;
      }

      ZhongNanWorkflowRequestTableFields other = (ZhongNanWorkflowRequestTableFields)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$edit = this.getEdit();
      Object other$edit = other.getEdit();
      if (this$edit == null ? other$edit == null : this$edit.equals(other$edit)) {
         Object this$fieldDBType = this.getFieldDBType();
         Object other$fieldDBType = other.getFieldDBType();
         if (this$fieldDBType == null ? other$fieldDBType == null : this$fieldDBType.equals(other$fieldDBType)) {
            Object this$fieldFormName = this.getFieldFormName();
            Object other$fieldFormName = other.getFieldFormName();
            if (this$fieldFormName == null ? other$fieldFormName == null : this$fieldFormName.equals(other$fieldFormName)) {
               Object this$fieldHtmlType = this.getFieldHtmlType();
               Object other$fieldHtmlType = other.getFieldHtmlType();
               if (this$fieldHtmlType == null ? other$fieldHtmlType == null : this$fieldHtmlType.equals(other$fieldHtmlType)) {
                  Object this$fieldId = this.getFieldId();
                  Object other$fieldId = other.getFieldId();
                  if (this$fieldId == null ? other$fieldId == null : this$fieldId.equals(other$fieldId)) {
                     Object this$fieldName = this.getFieldName();
                     Object other$fieldName = other.getFieldName();
                     if (this$fieldName == null ? other$fieldName == null : this$fieldName.equals(other$fieldName)) {
                        Object this$fieldOrder = this.getFieldOrder();
                        Object other$fieldOrder = other.getFieldOrder();
                        if (this$fieldOrder == null ? other$fieldOrder == null : this$fieldOrder.equals(other$fieldOrder)) {
                           Object this$fieldShowName = this.getFieldShowName();
                           Object other$fieldShowName = other.getFieldShowName();
                           if (this$fieldShowName == null ? other$fieldShowName == null : this$fieldShowName.equals(other$fieldShowName)) {
                              Object this$fieldShowValue = this.getFieldShowValue();
                              Object other$fieldShowValue = other.getFieldShowValue();
                              if (this$fieldShowValue == null ? other$fieldShowValue == null : this$fieldShowValue.equals(other$fieldShowValue)) {
                                 Object this$fieldType = this.getFieldType();
                                 Object other$fieldType = other.getFieldType();
                                 if (this$fieldType == null ? other$fieldType == null : this$fieldType.equals(other$fieldType)) {
                                    Object this$fieldValue = this.getFieldValue();
                                    Object other$fieldValue = other.getFieldValue();
                                    if (this$fieldValue == null ? other$fieldValue == null : this$fieldValue.equals(other$fieldValue)) {
                                       Object this$filedHtmlShow = this.getFiledHtmlShow();
                                       Object other$filedHtmlShow = other.getFiledHtmlShow();
                                       return this$filedHtmlShow == null ? other$filedHtmlShow == null : this$filedHtmlShow.equals(other$filedHtmlShow);
                                    } else {
                                       return false;
                                    }
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof ZhongNanWorkflowRequestTableFields;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $edit = this.getEdit();
      result = result * 59 + ($edit == null ? 43 : $edit.hashCode());
      Object $fieldDBType = this.getFieldDBType();
      result = result * 59 + ($fieldDBType == null ? 43 : $fieldDBType.hashCode());
      Object $fieldFormName = this.getFieldFormName();
      result = result * 59 + ($fieldFormName == null ? 43 : $fieldFormName.hashCode());
      Object $fieldHtmlType = this.getFieldHtmlType();
      result = result * 59 + ($fieldHtmlType == null ? 43 : $fieldHtmlType.hashCode());
      Object $fieldId = this.getFieldId();
      result = result * 59 + ($fieldId == null ? 43 : $fieldId.hashCode());
      Object $fieldName = this.getFieldName();
      result = result * 59 + ($fieldName == null ? 43 : $fieldName.hashCode());
      Object $fieldOrder = this.getFieldOrder();
      result = result * 59 + ($fieldOrder == null ? 43 : $fieldOrder.hashCode());
      Object $fieldShowName = this.getFieldShowName();
      result = result * 59 + ($fieldShowName == null ? 43 : $fieldShowName.hashCode());
      Object $fieldShowValue = this.getFieldShowValue();
      result = result * 59 + ($fieldShowValue == null ? 43 : $fieldShowValue.hashCode());
      Object $fieldType = this.getFieldType();
      result = result * 59 + ($fieldType == null ? 43 : $fieldType.hashCode());
      Object $fieldValue = this.getFieldValue();
      result = result * 59 + ($fieldValue == null ? 43 : $fieldValue.hashCode());
      Object $filedHtmlShow = this.getFiledHtmlShow();
      return result * 59 + ($filedHtmlShow == null ? 43 : $filedHtmlShow.hashCode());
   }

   @Override
   public String toString() {
      return "ZhongNanWorkflowRequestTableFields(edit="
         + this.getEdit()
         + ", fieldDBType="
         + this.getFieldDBType()
         + ", fieldFormName="
         + this.getFieldFormName()
         + ", fieldHtmlType="
         + this.getFieldHtmlType()
         + ", fieldId="
         + this.getFieldId()
         + ", fieldName="
         + this.getFieldName()
         + ", fieldOrder="
         + this.getFieldOrder()
         + ", fieldShowName="
         + this.getFieldShowName()
         + ", fieldShowValue="
         + this.getFieldShowValue()
         + ", fieldType="
         + this.getFieldType()
         + ", fieldValue="
         + this.getFieldValue()
         + ", filedHtmlShow="
         + this.getFiledHtmlShow()
         + ")";
   }

   public static class ZhongNanWorkflowRequestTableFieldsBuilder {
      private String edit;
      private String fieldDBType;
      private String fieldFormName;
      private String fieldHtmlType;
      private String fieldId;
      private String fieldName;
      private String fieldOrder;
      private String fieldShowName;
      private String fieldShowValue;
      private String fieldType;
      private String fieldValue;
      private String filedHtmlShow;

      ZhongNanWorkflowRequestTableFieldsBuilder() {
      }

      @JsonProperty("是否可以编辑")
      public ZhongNanWorkflowRequestTableFields.ZhongNanWorkflowRequestTableFieldsBuilder edit(final String edit) {
         this.edit = edit;
         return this;
      }

      @JsonProperty("字段类型")
      public ZhongNanWorkflowRequestTableFields.ZhongNanWorkflowRequestTableFieldsBuilder fieldDBType(final String fieldDBType) {
         this.fieldDBType = fieldDBType;
         return this;
      }

      @JsonProperty("表单名称")
      public ZhongNanWorkflowRequestTableFields.ZhongNanWorkflowRequestTableFieldsBuilder fieldFormName(final String fieldFormName) {
         this.fieldFormName = fieldFormName;
         return this;
      }

      @JsonProperty("类型")
      public ZhongNanWorkflowRequestTableFields.ZhongNanWorkflowRequestTableFieldsBuilder fieldHtmlType(final String fieldHtmlType) {
         this.fieldHtmlType = fieldHtmlType;
         return this;
      }

      @JsonProperty("id")
      public ZhongNanWorkflowRequestTableFields.ZhongNanWorkflowRequestTableFieldsBuilder fieldId(final String fieldId) {
         this.fieldId = fieldId;
         return this;
      }

      @JsonProperty("名称")
      public ZhongNanWorkflowRequestTableFields.ZhongNanWorkflowRequestTableFieldsBuilder fieldName(final String fieldName) {
         this.fieldName = fieldName;
         return this;
      }

      @JsonProperty("订单")
      public ZhongNanWorkflowRequestTableFields.ZhongNanWorkflowRequestTableFieldsBuilder fieldOrder(final String fieldOrder) {
         this.fieldOrder = fieldOrder;
         return this;
      }

      @JsonProperty("显示名称")
      public ZhongNanWorkflowRequestTableFields.ZhongNanWorkflowRequestTableFieldsBuilder fieldShowName(final String fieldShowName) {
         this.fieldShowName = fieldShowName;
         return this;
      }

      @JsonProperty("显示值")
      public ZhongNanWorkflowRequestTableFields.ZhongNanWorkflowRequestTableFieldsBuilder fieldShowValue(final String fieldShowValue) {
         this.fieldShowValue = fieldShowValue;
         return this;
      }

      @JsonProperty("类型")
      public ZhongNanWorkflowRequestTableFields.ZhongNanWorkflowRequestTableFieldsBuilder fieldType(final String fieldType) {
         this.fieldType = fieldType;
         return this;
      }

      @JsonProperty("值")
      public ZhongNanWorkflowRequestTableFields.ZhongNanWorkflowRequestTableFieldsBuilder fieldValue(final String fieldValue) {
         this.fieldValue = fieldValue;
         return this;
      }

      @JsonProperty("是否可以编辑")
      public ZhongNanWorkflowRequestTableFields.ZhongNanWorkflowRequestTableFieldsBuilder filedHtmlShow(final String filedHtmlShow) {
         this.filedHtmlShow = filedHtmlShow;
         return this;
      }

      public ZhongNanWorkflowRequestTableFields build() {
         return new ZhongNanWorkflowRequestTableFields(
            this.edit,
            this.fieldDBType,
            this.fieldFormName,
            this.fieldHtmlType,
            this.fieldId,
            this.fieldName,
            this.fieldOrder,
            this.fieldShowName,
            this.fieldShowValue,
            this.fieldType,
            this.fieldValue,
            this.filedHtmlShow
         );
      }

      @Override
      public String toString() {
         return "ZhongNanWorkflowRequestTableFields.ZhongNanWorkflowRequestTableFieldsBuilder(edit="
            + this.edit
            + ", fieldDBType="
            + this.fieldDBType
            + ", fieldFormName="
            + this.fieldFormName
            + ", fieldHtmlType="
            + this.fieldHtmlType
            + ", fieldId="
            + this.fieldId
            + ", fieldName="
            + this.fieldName
            + ", fieldOrder="
            + this.fieldOrder
            + ", fieldShowName="
            + this.fieldShowName
            + ", fieldShowValue="
            + this.fieldShowValue
            + ", fieldType="
            + this.fieldType
            + ", fieldValue="
            + this.fieldValue
            + ", filedHtmlShow="
            + this.filedHtmlShow
            + ")";
      }
   }
}
