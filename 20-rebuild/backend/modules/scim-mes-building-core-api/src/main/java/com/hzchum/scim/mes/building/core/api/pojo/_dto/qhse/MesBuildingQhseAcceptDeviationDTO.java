package com.hzchum.scim.mes.building.core.api.pojo._dto.qhse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingQhseAcceptDeviationDTO对象", description = "问题曝光 ")
public class MesBuildingQhseAcceptDeviationDTO extends BaseEntity<Long> {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "qhseId", value = "问题曝光id", notes = "问题曝光id")
   @JsonProperty("qhseId")
   @JSONField(name = "qhseId")
   private Long qhseId;
   @ApiModelProperty(name = "approvalRemark", value = "审批备注", notes = "审批备注")
   @JsonProperty("approvalRemark")
   @JSONField(name = "approvalRemark")
   private String approvalRemark;
   @ApiModelProperty(name = "submitRemark", value = "提交让步接收理由", notes = "提交让步接收理由")
   @JsonProperty("submitRemark")
   @JSONField(name = "submitRemark")
   private String submitRemark;
   @ApiModelProperty(name = "status", value = "状态 [0未审核1未通过收2已通过]", notes = "状态 [0未审核1未通过收2已通过]")
   @JsonProperty("status")
   @JSONField(name = "status")
   private Integer status;
   @ApiModelProperty(name = "userId", value = "审核人", notes = "审核人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;

   public static MesBuildingQhseAcceptDeviationDTO.MesBuildingQhseAcceptDeviationDTOBuilder builder() {
      return new MesBuildingQhseAcceptDeviationDTO.MesBuildingQhseAcceptDeviationDTOBuilder();
   }

   public MesBuildingQhseAcceptDeviationDTO() {
   }

   public MesBuildingQhseAcceptDeviationDTO(
      final Long id, final Long qhseId, final String approvalRemark, final String submitRemark, final Integer status, final Long userId
   ) {
      this.id = id;
      this.qhseId = qhseId;
      this.approvalRemark = approvalRemark;
      this.submitRemark = submitRemark;
      this.status = status;
      this.userId = userId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getQhseId() {
      return this.qhseId;
   }

   public String getApprovalRemark() {
      return this.approvalRemark;
   }

   public String getSubmitRemark() {
      return this.submitRemark;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Long getUserId() {
      return this.userId;
   }

   @JsonProperty("id")
   public MesBuildingQhseAcceptDeviationDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("qhseId")
   public MesBuildingQhseAcceptDeviationDTO setQhseId(final Long qhseId) {
      this.qhseId = qhseId;
      return this;
   }

   @JsonProperty("approvalRemark")
   public MesBuildingQhseAcceptDeviationDTO setApprovalRemark(final String approvalRemark) {
      this.approvalRemark = approvalRemark;
      return this;
   }

   @JsonProperty("submitRemark")
   public MesBuildingQhseAcceptDeviationDTO setSubmitRemark(final String submitRemark) {
      this.submitRemark = submitRemark;
      return this;
   }

   @JsonProperty("status")
   public MesBuildingQhseAcceptDeviationDTO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingQhseAcceptDeviationDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingQhseAcceptDeviationDTO(id="
         + this.getId()
         + ", qhseId="
         + this.getQhseId()
         + ", approvalRemark="
         + this.getApprovalRemark()
         + ", submitRemark="
         + this.getSubmitRemark()
         + ", status="
         + this.getStatus()
         + ", userId="
         + this.getUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingQhseAcceptDeviationDTO)) {
         return false;
      }

      MesBuildingQhseAcceptDeviationDTO other = (MesBuildingQhseAcceptDeviationDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$qhseId = this.getQhseId();
         Object other$qhseId = other.getQhseId();
         if (this$qhseId == null ? other$qhseId == null : this$qhseId.equals(other$qhseId)) {
            Object this$status = this.getStatus();
            Object other$status = other.getStatus();
            if (this$status == null ? other$status == null : this$status.equals(other$status)) {
               Object this$userId = this.getUserId();
               Object other$userId = other.getUserId();
               if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                  Object this$approvalRemark = this.getApprovalRemark();
                  Object other$approvalRemark = other.getApprovalRemark();
                  if (this$approvalRemark == null ? other$approvalRemark == null : this$approvalRemark.equals(other$approvalRemark)) {
                     Object this$submitRemark = this.getSubmitRemark();
                     Object other$submitRemark = other.getSubmitRemark();
                     return this$submitRemark == null ? other$submitRemark == null : this$submitRemark.equals(other$submitRemark);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingQhseAcceptDeviationDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $qhseId = this.getQhseId();
      result = result * 59 + ($qhseId == null ? 43 : $qhseId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $approvalRemark = this.getApprovalRemark();
      result = result * 59 + ($approvalRemark == null ? 43 : $approvalRemark.hashCode());
      Object $submitRemark = this.getSubmitRemark();
      return result * 59 + ($submitRemark == null ? 43 : $submitRemark.hashCode());
   }

   public static class MesBuildingQhseAcceptDeviationDTOBuilder {
      private Long id;
      private Long qhseId;
      private String approvalRemark;
      private String submitRemark;
      private Integer status;
      private Long userId;

      MesBuildingQhseAcceptDeviationDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingQhseAcceptDeviationDTO.MesBuildingQhseAcceptDeviationDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("qhseId")
      public MesBuildingQhseAcceptDeviationDTO.MesBuildingQhseAcceptDeviationDTOBuilder qhseId(final Long qhseId) {
         this.qhseId = qhseId;
         return this;
      }

      @JsonProperty("approvalRemark")
      public MesBuildingQhseAcceptDeviationDTO.MesBuildingQhseAcceptDeviationDTOBuilder approvalRemark(final String approvalRemark) {
         this.approvalRemark = approvalRemark;
         return this;
      }

      @JsonProperty("submitRemark")
      public MesBuildingQhseAcceptDeviationDTO.MesBuildingQhseAcceptDeviationDTOBuilder submitRemark(final String submitRemark) {
         this.submitRemark = submitRemark;
         return this;
      }

      @JsonProperty("status")
      public MesBuildingQhseAcceptDeviationDTO.MesBuildingQhseAcceptDeviationDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingQhseAcceptDeviationDTO.MesBuildingQhseAcceptDeviationDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesBuildingQhseAcceptDeviationDTO build() {
         return new MesBuildingQhseAcceptDeviationDTO(this.id, this.qhseId, this.approvalRemark, this.submitRemark, this.status, this.userId);
      }

      @Override
      public String toString() {
         return "MesBuildingQhseAcceptDeviationDTO.MesBuildingQhseAcceptDeviationDTOBuilder(id="
            + this.id
            + ", qhseId="
            + this.qhseId
            + ", approvalRemark="
            + this.approvalRemark
            + ", submitRemark="
            + this.submitRemark
            + ", status="
            + this.status
            + ", userId="
            + this.userId
            + ")";
      }
   }
}
