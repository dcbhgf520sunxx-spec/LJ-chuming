package com.hzchum.scim.common.core.api.pojo.dtoParam.oa;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("WorkflowRequestTableRecord")
public class WorkflowRequestTableRecord {
   @ApiModelProperty(name = "workflowRequestTableRecords", value = "字段属性")
   private List<WorkflowRequestTableField> workflowRequestTableFields;

   public static WorkflowRequestTableRecord.WorkflowRequestTableRecordBuilder builder() {
      return new WorkflowRequestTableRecord.WorkflowRequestTableRecordBuilder();
   }

   public WorkflowRequestTableRecord(final List<WorkflowRequestTableField> workflowRequestTableFields) {
      this.workflowRequestTableFields = workflowRequestTableFields;
   }

   public WorkflowRequestTableRecord() {
   }

   public List<WorkflowRequestTableField> getWorkflowRequestTableFields() {
      return this.workflowRequestTableFields;
   }

   public WorkflowRequestTableRecord setWorkflowRequestTableFields(final List<WorkflowRequestTableField> workflowRequestTableFields) {
      this.workflowRequestTableFields = workflowRequestTableFields;
      return this;
   }

   @Override
   public String toString() {
      return "WorkflowRequestTableRecord(workflowRequestTableFields=" + this.getWorkflowRequestTableFields() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WorkflowRequestTableRecord)) {
         return false;
      }

      WorkflowRequestTableRecord other = (WorkflowRequestTableRecord)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workflowRequestTableFields = this.getWorkflowRequestTableFields();
      Object other$workflowRequestTableFields = other.getWorkflowRequestTableFields();
      return this$workflowRequestTableFields == null
         ? other$workflowRequestTableFields == null
         : this$workflowRequestTableFields.equals(other$workflowRequestTableFields);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof WorkflowRequestTableRecord;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workflowRequestTableFields = this.getWorkflowRequestTableFields();
      return result * 59 + ($workflowRequestTableFields == null ? 43 : $workflowRequestTableFields.hashCode());
   }

   public static class WorkflowRequestTableRecordBuilder {
      private List<WorkflowRequestTableField> workflowRequestTableFields;

      WorkflowRequestTableRecordBuilder() {
      }

      public WorkflowRequestTableRecord.WorkflowRequestTableRecordBuilder workflowRequestTableFields(
         final List<WorkflowRequestTableField> workflowRequestTableFields
      ) {
         this.workflowRequestTableFields = workflowRequestTableFields;
         return this;
      }

      public WorkflowRequestTableRecord build() {
         return new WorkflowRequestTableRecord(this.workflowRequestTableFields);
      }

      @Override
      public String toString() {
         return "WorkflowRequestTableRecord.WorkflowRequestTableRecordBuilder(workflowRequestTableFields=" + this.workflowRequestTableFields + ")";
      }
   }
}
