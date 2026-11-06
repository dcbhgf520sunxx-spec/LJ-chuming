package com.hzchum.scim.common.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class WmsApproveOpinionDTOParam implements Serializable {
   @ApiModelProperty(name = "approveRecordId ", value = "审批主日志信息ID")
   private Long approveRecordId;
   @ApiModelProperty(name = "dataId", value = "关联数据的ID")
   private Long dataId;
   @ApiModelProperty(name = "decision", value = "决策  1待决策  2通过 4 不通过 驳回")
   private Integer decision;
   @ApiModelProperty(name = "opinion", value = "意见")
   private String opinion;

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

   public void setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
   }

   public void setDataId(final Long dataId) {
      this.dataId = dataId;
   }

   public void setDecision(final Integer decision) {
      this.decision = decision;
   }

   public void setOpinion(final String opinion) {
      this.opinion = opinion;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsApproveOpinionDTOParam)) {
         return false;
      }

      WmsApproveOpinionDTOParam other = (WmsApproveOpinionDTOParam)o;
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
               return this$opinion == null ? other$opinion == null : this$opinion.equals(other$opinion);
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
      return other instanceof WmsApproveOpinionDTOParam;
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
      return result * 59 + ($opinion == null ? 43 : $opinion.hashCode());
   }

   @Override
   public String toString() {
      return "WmsApproveOpinionDTOParam(approveRecordId="
         + this.getApproveRecordId()
         + ", dataId="
         + this.getDataId()
         + ", decision="
         + this.getDecision()
         + ", opinion="
         + this.getOpinion()
         + ")";
   }
}
