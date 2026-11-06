package com.hzchum.scim.common.core.api.pojo.dtoParam.oa;

import io.swagger.annotations.ApiModel;

@ApiModel("WorkflowRequestTableField")
public class WorkflowRequestTableField {
   private String fieldName;
   private Object fieldValue;

   public static WorkflowRequestTableField.WorkflowRequestTableFieldBuilder builder() {
      return new WorkflowRequestTableField.WorkflowRequestTableFieldBuilder();
   }

   public WorkflowRequestTableField(final String fieldName, final Object fieldValue) {
      this.fieldName = fieldName;
      this.fieldValue = fieldValue;
   }

   public WorkflowRequestTableField() {
   }

   public String getFieldName() {
      return this.fieldName;
   }

   public Object getFieldValue() {
      return this.fieldValue;
   }

   public WorkflowRequestTableField setFieldName(final String fieldName) {
      this.fieldName = fieldName;
      return this;
   }

   public WorkflowRequestTableField setFieldValue(final Object fieldValue) {
      this.fieldValue = fieldValue;
      return this;
   }

   @Override
   public String toString() {
      return "WorkflowRequestTableField(fieldName=" + this.getFieldName() + ", fieldValue=" + this.getFieldValue() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof WorkflowRequestTableField)) {
         return false;
      } else {
         WorkflowRequestTableField other = (WorkflowRequestTableField)o;
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
      return other instanceof WorkflowRequestTableField;
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

   public static class WorkflowRequestTableFieldBuilder {
      private String fieldName;
      private Object fieldValue;

      WorkflowRequestTableFieldBuilder() {
      }

      public WorkflowRequestTableField.WorkflowRequestTableFieldBuilder fieldName(final String fieldName) {
         this.fieldName = fieldName;
         return this;
      }

      public WorkflowRequestTableField.WorkflowRequestTableFieldBuilder fieldValue(final Object fieldValue) {
         this.fieldValue = fieldValue;
         return this;
      }

      public WorkflowRequestTableField build() {
         return new WorkflowRequestTableField(this.fieldName, this.fieldValue);
      }

      @Override
      public String toString() {
         return "WorkflowRequestTableField.WorkflowRequestTableFieldBuilder(fieldName=" + this.fieldName + ", fieldValue=" + this.fieldValue + ")";
      }
   }
}
