package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class CrmAuditCommonDTO {
   @ApiModelProperty(name = "approveRecordId ", value = "审批主日志信息ID")
   private Long approveRecordId;
   @ApiModelProperty(name = "dataId", value = "关联数据的ID")
   private Long dataId;
   @ApiModelProperty(name = "decision", value = "1.审核中,2.审核通过,4.审核驳回。")
   private Integer decision;
   @ApiModelProperty(name = "opinion", value = "意见")
   private String opinion;
   @ApiModelProperty("流程类型名称")
   private String approveProcessTypeName;

   public static CrmAuditCommonDTO.CrmAuditCommonDTOBuilder builder() {
      return new CrmAuditCommonDTO.CrmAuditCommonDTOBuilder();
   }

   public CrmAuditCommonDTO() {
   }

   public CrmAuditCommonDTO(final Long approveRecordId, final Long dataId, final Integer decision, final String opinion, final String approveProcessTypeName) {
      this.approveRecordId = approveRecordId;
      this.dataId = dataId;
      this.decision = decision;
      this.opinion = opinion;
      this.approveProcessTypeName = approveProcessTypeName;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public Long getDataId() {
      return this.dataId;
   }

   public Integer getDecision() {
      return this.decision;
   }

   public String getOpinion() {
      return this.opinion;
   }

   public String getApproveProcessTypeName() {
      return this.approveProcessTypeName;
   }

   public CrmAuditCommonDTO setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
      return this;
   }

   public CrmAuditCommonDTO setDataId(final Long dataId) {
      this.dataId = dataId;
      return this;
   }

   public CrmAuditCommonDTO setDecision(final Integer decision) {
      this.decision = decision;
      return this;
   }

   public CrmAuditCommonDTO setOpinion(final String opinion) {
      this.opinion = opinion;
      return this;
   }

   public CrmAuditCommonDTO setApproveProcessTypeName(final String approveProcessTypeName) {
      this.approveProcessTypeName = approveProcessTypeName;
      return this;
   }

   @Override
   public String toString() {
      return "CrmAuditCommonDTO(approveRecordId="
         + this.getApproveRecordId()
         + ", dataId="
         + this.getDataId()
         + ", decision="
         + this.getDecision()
         + ", opinion="
         + this.getOpinion()
         + ", approveProcessTypeName="
         + this.getApproveProcessTypeName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmAuditCommonDTO)) {
         return false;
      }

      CrmAuditCommonDTO other = (CrmAuditCommonDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$approveRecordId = this.getApproveRecordId();
      Object other$approveRecordId = other.getApproveRecordId();
      if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
         Object this$dataId = this.getDataId();
         Object other$dataId = other.getDataId();
         if (this$dataId == null ? other$dataId == null : this$dataId.equals(other$dataId)) {
            Object this$decision = this.getDecision();
            Object other$decision = other.getDecision();
            if (this$decision == null ? other$decision == null : this$decision.equals(other$decision)) {
               Object this$opinion = this.getOpinion();
               Object other$opinion = other.getOpinion();
               if (this$opinion == null ? other$opinion == null : this$opinion.equals(other$opinion)) {
                  Object this$approveProcessTypeName = this.getApproveProcessTypeName();
                  Object other$approveProcessTypeName = other.getApproveProcessTypeName();
                  return this$approveProcessTypeName == null
                     ? other$approveProcessTypeName == null
                     : this$approveProcessTypeName.equals(other$approveProcessTypeName);
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
      return other instanceof CrmAuditCommonDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $dataId = this.getDataId();
      result = result * 59 + ($dataId == null ? 43 : $dataId.hashCode());
      Object $decision = this.getDecision();
      result = result * 59 + ($decision == null ? 43 : $decision.hashCode());
      Object $opinion = this.getOpinion();
      result = result * 59 + ($opinion == null ? 43 : $opinion.hashCode());
      Object $approveProcessTypeName = this.getApproveProcessTypeName();
      return result * 59 + ($approveProcessTypeName == null ? 43 : $approveProcessTypeName.hashCode());
   }

   public static class CrmAuditCommonDTOBuilder {
      private Long approveRecordId;
      private Long dataId;
      private Integer decision;
      private String opinion;
      private String approveProcessTypeName;

      CrmAuditCommonDTOBuilder() {
      }

      public CrmAuditCommonDTO.CrmAuditCommonDTOBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public CrmAuditCommonDTO.CrmAuditCommonDTOBuilder dataId(final Long dataId) {
         this.dataId = dataId;
         return this;
      }

      public CrmAuditCommonDTO.CrmAuditCommonDTOBuilder decision(final Integer decision) {
         this.decision = decision;
         return this;
      }

      public CrmAuditCommonDTO.CrmAuditCommonDTOBuilder opinion(final String opinion) {
         this.opinion = opinion;
         return this;
      }

      public CrmAuditCommonDTO.CrmAuditCommonDTOBuilder approveProcessTypeName(final String approveProcessTypeName) {
         this.approveProcessTypeName = approveProcessTypeName;
         return this;
      }

      public CrmAuditCommonDTO build() {
         return new CrmAuditCommonDTO(this.approveRecordId, this.dataId, this.decision, this.opinion, this.approveProcessTypeName);
      }

      @Override
      public String toString() {
         return "CrmAuditCommonDTO.CrmAuditCommonDTOBuilder(approveRecordId="
            + this.approveRecordId
            + ", dataId="
            + this.dataId
            + ", decision="
            + this.decision
            + ", opinion="
            + this.opinion
            + ", approveProcessTypeName="
            + this.approveProcessTypeName
            + ")";
      }
   }
}
