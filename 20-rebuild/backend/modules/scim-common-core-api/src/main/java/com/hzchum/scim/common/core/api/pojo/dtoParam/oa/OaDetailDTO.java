package com.hzchum.scim.common.core.api.pojo.dtoParam.oa;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("OaSupplierPaymentDTO")
public class OaDetailDTO {
   @ApiModelProperty(name = "tableDBName", value = "表名")
   private String tableDBName;
   @ApiModelProperty(name = "hkje", value = "汇款金额")
   private List<WorkflowRequestTableRecord> workflowRequestTableRecords;

   public static OaDetailDTO.OaDetailDTOBuilder builder() {
      return new OaDetailDTO.OaDetailDTOBuilder();
   }

   public OaDetailDTO(final String tableDBName, final List<WorkflowRequestTableRecord> workflowRequestTableRecords) {
      this.tableDBName = tableDBName;
      this.workflowRequestTableRecords = workflowRequestTableRecords;
   }

   public OaDetailDTO() {
   }

   public String getTableDBName() {
      return this.tableDBName;
   }

   public List<WorkflowRequestTableRecord> getWorkflowRequestTableRecords() {
      return this.workflowRequestTableRecords;
   }

   public OaDetailDTO setTableDBName(final String tableDBName) {
      this.tableDBName = tableDBName;
      return this;
   }

   public OaDetailDTO setWorkflowRequestTableRecords(final List<WorkflowRequestTableRecord> workflowRequestTableRecords) {
      this.workflowRequestTableRecords = workflowRequestTableRecords;
      return this;
   }

   @Override
   public String toString() {
      return "OaDetailDTO(tableDBName=" + this.getTableDBName() + ", workflowRequestTableRecords=" + this.getWorkflowRequestTableRecords() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof OaDetailDTO)) {
         return false;
      } else {
         OaDetailDTO other = (OaDetailDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$tableDBName = this.getTableDBName();
            Object other$tableDBName = other.getTableDBName();
            if (this$tableDBName == null ? other$tableDBName == null : this$tableDBName.equals(other$tableDBName)) {
               Object this$workflowRequestTableRecords = this.getWorkflowRequestTableRecords();
               Object other$workflowRequestTableRecords = other.getWorkflowRequestTableRecords();
               return this$workflowRequestTableRecords == null
                  ? other$workflowRequestTableRecords == null
                  : this$workflowRequestTableRecords.equals(other$workflowRequestTableRecords);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof OaDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $tableDBName = this.getTableDBName();
      result = result * 59 + ($tableDBName == null ? 43 : $tableDBName.hashCode());
      Object $workflowRequestTableRecords = this.getWorkflowRequestTableRecords();
      return result * 59 + ($workflowRequestTableRecords == null ? 43 : $workflowRequestTableRecords.hashCode());
   }

   public static class OaDetailDTOBuilder {
      private String tableDBName;
      private List<WorkflowRequestTableRecord> workflowRequestTableRecords;

      OaDetailDTOBuilder() {
      }

      public OaDetailDTO.OaDetailDTOBuilder tableDBName(final String tableDBName) {
         this.tableDBName = tableDBName;
         return this;
      }

      public OaDetailDTO.OaDetailDTOBuilder workflowRequestTableRecords(final List<WorkflowRequestTableRecord> workflowRequestTableRecords) {
         this.workflowRequestTableRecords = workflowRequestTableRecords;
         return this;
      }

      public OaDetailDTO build() {
         return new OaDetailDTO(this.tableDBName, this.workflowRequestTableRecords);
      }

      @Override
      public String toString() {
         return "OaDetailDTO.OaDetailDTOBuilder(tableDBName=" + this.tableDBName + ", workflowRequestTableRecords=" + this.workflowRequestTableRecords + ")";
      }
   }
}
