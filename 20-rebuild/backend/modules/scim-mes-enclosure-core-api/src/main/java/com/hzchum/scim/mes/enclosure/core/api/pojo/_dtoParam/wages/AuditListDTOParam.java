package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.wages;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "AuditListDTOParam", description = "")
public class AuditListDTOParam {
   @ApiModelProperty(name = "projectId", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @NotNull(message = "项目id不能为空")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @NotNull(message = "单体id不能为空")
   private Long monomerId;
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   @NotNull(message = "工序id不能为空")
   private Long processId;
   @ApiModelProperty(name = "status", notes = "状态")
   @JsonProperty("status")
   @JSONField(name = "status")
   private Integer status;
   @ApiModelProperty(name = "organizationType", notes = "编制类型")
   @JsonProperty("organizationType")
   @JSONField(name = "organizationType")
   private Boolean organizationType;

   public static AuditListDTOParam.AuditListDTOParamBuilder builder() {
      return new AuditListDTOParam.AuditListDTOParamBuilder();
   }

   public AuditListDTOParam(final Long projectId, final Long monomerId, final Long processId, final Integer status, final Boolean organizationType) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.processId = processId;
      this.status = status;
      this.organizationType = organizationType;
   }

   public AuditListDTOParam() {
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Boolean getOrganizationType() {
      return this.organizationType;
   }

   @JsonProperty("projectId")
   public AuditListDTOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public AuditListDTOParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("processId")
   public AuditListDTOParam setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("status")
   public AuditListDTOParam setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("organizationType")
   public AuditListDTOParam setOrganizationType(final Boolean organizationType) {
      this.organizationType = organizationType;
      return this;
   }

   @Override
   public String toString() {
      return "AuditListDTOParam(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", processId="
         + this.getProcessId()
         + ", status="
         + this.getStatus()
         + ", organizationType="
         + this.getOrganizationType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AuditListDTOParam)) {
         return false;
      }

      AuditListDTOParam other = (AuditListDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$status = this.getStatus();
               Object other$status = other.getStatus();
               if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                  Object this$organizationType = this.getOrganizationType();
                  Object other$organizationType = other.getOrganizationType();
                  return this$organizationType == null ? other$organizationType == null : this$organizationType.equals(other$organizationType);
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
      return other instanceof AuditListDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $organizationType = this.getOrganizationType();
      return result * 59 + ($organizationType == null ? 43 : $organizationType.hashCode());
   }

   public static class AuditListDTOParamBuilder {
      private Long projectId;
      private Long monomerId;
      private Long processId;
      private Integer status;
      private Boolean organizationType;

      AuditListDTOParamBuilder() {
      }

      @JsonProperty("projectId")
      public AuditListDTOParam.AuditListDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public AuditListDTOParam.AuditListDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("processId")
      public AuditListDTOParam.AuditListDTOParamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("status")
      public AuditListDTOParam.AuditListDTOParamBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("organizationType")
      public AuditListDTOParam.AuditListDTOParamBuilder organizationType(final Boolean organizationType) {
         this.organizationType = organizationType;
         return this;
      }

      public AuditListDTOParam build() {
         return new AuditListDTOParam(this.projectId, this.monomerId, this.processId, this.status, this.organizationType);
      }

      @Override
      public String toString() {
         return "AuditListDTOParam.AuditListDTOParamBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", processId="
            + this.processId
            + ", status="
            + this.status
            + ", organizationType="
            + this.organizationType
            + ")";
      }
   }
}
