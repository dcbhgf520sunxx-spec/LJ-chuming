package com.hzchum.scim.common.core.api.pojo.dto.oa;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;

@ApiModel("OA返回工作流")
public class ZhongNanWorkFlowDTO {
   @JsonProperty(value = "formId", namespace = "表单id")
   private String formId;
   @JsonProperty(value = "workflowId", namespace = "流程id")
   private String workflowId;
   @JsonProperty(value = "workflowName", namespace = "流程名称")
   private String workflowName;
   @JsonProperty(value = "workflowTypeId", namespace = "流程类型id")
   private String workflowTypeId;
   @JsonProperty(value = "workflowTypeName", namespace = "流程类型名称")
   private String workflowTypeName;

   public static ZhongNanWorkFlowDTO.ZhongNanWorkFlowDTOBuilder builder() {
      return new ZhongNanWorkFlowDTO.ZhongNanWorkFlowDTOBuilder();
   }

   public ZhongNanWorkFlowDTO() {
   }

   public ZhongNanWorkFlowDTO(
      final String formId, final String workflowId, final String workflowName, final String workflowTypeId, final String workflowTypeName
   ) {
      this.formId = formId;
      this.workflowId = workflowId;
      this.workflowName = workflowName;
      this.workflowTypeId = workflowTypeId;
      this.workflowTypeName = workflowTypeName;
   }

   public String getFormId() {
      return this.formId;
   }

   public String getWorkflowId() {
      return this.workflowId;
   }

   public String getWorkflowName() {
      return this.workflowName;
   }

   public String getWorkflowTypeId() {
      return this.workflowTypeId;
   }

   public String getWorkflowTypeName() {
      return this.workflowTypeName;
   }

   @JsonProperty(value = "formId", namespace = "表单id")
   public ZhongNanWorkFlowDTO setFormId(final String formId) {
      this.formId = formId;
      return this;
   }

   @JsonProperty(value = "workflowId", namespace = "流程id")
   public ZhongNanWorkFlowDTO setWorkflowId(final String workflowId) {
      this.workflowId = workflowId;
      return this;
   }

   @JsonProperty(value = "workflowName", namespace = "流程名称")
   public ZhongNanWorkFlowDTO setWorkflowName(final String workflowName) {
      this.workflowName = workflowName;
      return this;
   }

   @JsonProperty(value = "workflowTypeId", namespace = "流程类型id")
   public ZhongNanWorkFlowDTO setWorkflowTypeId(final String workflowTypeId) {
      this.workflowTypeId = workflowTypeId;
      return this;
   }

   @JsonProperty(value = "workflowTypeName", namespace = "流程类型名称")
   public ZhongNanWorkFlowDTO setWorkflowTypeName(final String workflowTypeName) {
      this.workflowTypeName = workflowTypeName;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ZhongNanWorkFlowDTO)) {
         return false;
      }

      ZhongNanWorkFlowDTO other = (ZhongNanWorkFlowDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$formId = this.getFormId();
      Object other$formId = other.getFormId();
      if (this$formId == null ? other$formId == null : this$formId.equals(other$formId)) {
         Object this$workflowId = this.getWorkflowId();
         Object other$workflowId = other.getWorkflowId();
         if (this$workflowId == null ? other$workflowId == null : this$workflowId.equals(other$workflowId)) {
            Object this$workflowName = this.getWorkflowName();
            Object other$workflowName = other.getWorkflowName();
            if (this$workflowName == null ? other$workflowName == null : this$workflowName.equals(other$workflowName)) {
               Object this$workflowTypeId = this.getWorkflowTypeId();
               Object other$workflowTypeId = other.getWorkflowTypeId();
               if (this$workflowTypeId == null ? other$workflowTypeId == null : this$workflowTypeId.equals(other$workflowTypeId)) {
                  Object this$workflowTypeName = this.getWorkflowTypeName();
                  Object other$workflowTypeName = other.getWorkflowTypeName();
                  return this$workflowTypeName == null ? other$workflowTypeName == null : this$workflowTypeName.equals(other$workflowTypeName);
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
      return other instanceof ZhongNanWorkFlowDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $formId = this.getFormId();
      result = result * 59 + ($formId == null ? 43 : $formId.hashCode());
      Object $workflowId = this.getWorkflowId();
      result = result * 59 + ($workflowId == null ? 43 : $workflowId.hashCode());
      Object $workflowName = this.getWorkflowName();
      result = result * 59 + ($workflowName == null ? 43 : $workflowName.hashCode());
      Object $workflowTypeId = this.getWorkflowTypeId();
      result = result * 59 + ($workflowTypeId == null ? 43 : $workflowTypeId.hashCode());
      Object $workflowTypeName = this.getWorkflowTypeName();
      return result * 59 + ($workflowTypeName == null ? 43 : $workflowTypeName.hashCode());
   }

   @Override
   public String toString() {
      return "ZhongNanWorkFlowDTO(formId="
         + this.getFormId()
         + ", workflowId="
         + this.getWorkflowId()
         + ", workflowName="
         + this.getWorkflowName()
         + ", workflowTypeId="
         + this.getWorkflowTypeId()
         + ", workflowTypeName="
         + this.getWorkflowTypeName()
         + ")";
   }

   public static class ZhongNanWorkFlowDTOBuilder {
      private String formId;
      private String workflowId;
      private String workflowName;
      private String workflowTypeId;
      private String workflowTypeName;

      ZhongNanWorkFlowDTOBuilder() {
      }

      @JsonProperty(value = "formId", namespace = "表单id")
      public ZhongNanWorkFlowDTO.ZhongNanWorkFlowDTOBuilder formId(final String formId) {
         this.formId = formId;
         return this;
      }

      @JsonProperty(value = "workflowId", namespace = "流程id")
      public ZhongNanWorkFlowDTO.ZhongNanWorkFlowDTOBuilder workflowId(final String workflowId) {
         this.workflowId = workflowId;
         return this;
      }

      @JsonProperty(value = "workflowName", namespace = "流程名称")
      public ZhongNanWorkFlowDTO.ZhongNanWorkFlowDTOBuilder workflowName(final String workflowName) {
         this.workflowName = workflowName;
         return this;
      }

      @JsonProperty(value = "workflowTypeId", namespace = "流程类型id")
      public ZhongNanWorkFlowDTO.ZhongNanWorkFlowDTOBuilder workflowTypeId(final String workflowTypeId) {
         this.workflowTypeId = workflowTypeId;
         return this;
      }

      @JsonProperty(value = "workflowTypeName", namespace = "流程类型名称")
      public ZhongNanWorkFlowDTO.ZhongNanWorkFlowDTOBuilder workflowTypeName(final String workflowTypeName) {
         this.workflowTypeName = workflowTypeName;
         return this;
      }

      public ZhongNanWorkFlowDTO build() {
         return new ZhongNanWorkFlowDTO(this.formId, this.workflowId, this.workflowName, this.workflowTypeId, this.workflowTypeName);
      }

      @Override
      public String toString() {
         return "ZhongNanWorkFlowDTO.ZhongNanWorkFlowDTOBuilder(formId="
            + this.formId
            + ", workflowId="
            + this.workflowId
            + ", workflowName="
            + this.workflowName
            + ", workflowTypeId="
            + this.workflowTypeId
            + ", workflowTypeName="
            + this.workflowTypeName
            + ")";
      }
   }
}
