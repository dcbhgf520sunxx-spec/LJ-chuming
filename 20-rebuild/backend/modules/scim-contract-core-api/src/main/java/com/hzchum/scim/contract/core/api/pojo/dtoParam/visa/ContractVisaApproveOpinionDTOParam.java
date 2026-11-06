package com.hzchum.scim.contract.core.api.pojo.dtoParam.visa;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class ContractVisaApproveOpinionDTOParam {
   @ApiModelProperty(name = "approveRecordId ", value = "审批主日志信息ID")
   @NotNull(message = "审批日志id不能为空！")
   private Long approveRecordId;
   @ApiModelProperty(name = "dataId", value = "关联数据的ID")
   @NotNull(message = "签证单id不能为空！")
   private Long dataId;
   @ApiModelProperty(name = "decision", value = "1.审核中,2.审核通过,4.审核驳回。")
   @EnumValidator(value = ReviewStatusEnum.class, message = "审核类型不正确！")
   private Integer decision;
   @ApiModelProperty(name = "opinion", value = "意见")
   private String opinion;
   @ApiModelProperty("流程类型名称")
   private String approveProcessTypeName;

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

   public void setApproveProcessTypeName(final String approveProcessTypeName) {
      this.approveProcessTypeName = approveProcessTypeName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractVisaApproveOpinionDTOParam)) {
         return false;
      }

      ContractVisaApproveOpinionDTOParam other = (ContractVisaApproveOpinionDTOParam)o;
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
      return other instanceof ContractVisaApproveOpinionDTOParam;
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

   @Override
   public String toString() {
      return "ContractVisaApproveOpinionDTOParam(approveRecordId="
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
}
