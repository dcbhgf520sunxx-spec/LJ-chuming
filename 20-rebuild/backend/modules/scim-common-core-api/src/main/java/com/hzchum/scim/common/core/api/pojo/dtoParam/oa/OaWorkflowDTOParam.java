package com.hzchum.scim.common.core.api.pojo.dtoParam.oa;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("OaWorkflowDTOParam")
public class OaWorkflowDTOParam {
   @ApiModelProperty(name = "requestId", value = "请求id", required = true)
   private String requestId;
   @ApiModelProperty(name = "workflowId", value = "流程id", required = true)
   private String workflowId;
   @ApiModelProperty(name = "workflowName", value = "流程名称", required = true)
   private String workflowName;
   @ApiModelProperty(name = "workflowTypeName", value = "流程类型名称", required = true)
   private String workflowTypeName;
   @ApiModelProperty(name = "requestmark", value = "流程编号", required = true)
   private String requestmark;
   @ApiModelProperty(name = "approveStatus", value = "1，通过。2，驳回", required = true)
   private String approveStatus;
   @ApiModelProperty(name = "actuallySettlementAmount", value = "以“元”为单位", required = true)
   private String actuallySettlementAmount;
   @ApiModelProperty(name = "lastOperatorId", value = "最后操作人id", required = true)
   private String lastOperatorId;
   @ApiModelProperty(name = "reason", value = "原由", required = true)
   private String reason;
   @ApiModelProperty(name = "actuallyPaymentDetails", value = "实付金额明细，以“元”为单位", required = true)
   private List<OaPaymentDetailDTO> actuallyPaymentDetails;

   public static OaWorkflowDTOParam.OaWorkflowDTOParamBuilder builder() {
      return new OaWorkflowDTOParam.OaWorkflowDTOParamBuilder();
   }

   public OaWorkflowDTOParam(
      final String requestId,
      final String workflowId,
      final String workflowName,
      final String workflowTypeName,
      final String requestmark,
      final String approveStatus,
      final String actuallySettlementAmount,
      final String lastOperatorId,
      final String reason,
      final List<OaPaymentDetailDTO> actuallyPaymentDetails
   ) {
      this.requestId = requestId;
      this.workflowId = workflowId;
      this.workflowName = workflowName;
      this.workflowTypeName = workflowTypeName;
      this.requestmark = requestmark;
      this.approveStatus = approveStatus;
      this.actuallySettlementAmount = actuallySettlementAmount;
      this.lastOperatorId = lastOperatorId;
      this.reason = reason;
      this.actuallyPaymentDetails = actuallyPaymentDetails;
   }

   public OaWorkflowDTOParam() {
   }

   public String getRequestId() {
      return this.requestId;
   }

   public String getWorkflowId() {
      return this.workflowId;
   }

   public String getWorkflowName() {
      return this.workflowName;
   }

   public String getWorkflowTypeName() {
      return this.workflowTypeName;
   }

   public String getRequestmark() {
      return this.requestmark;
   }

   public String getApproveStatus() {
      return this.approveStatus;
   }

   public String getActuallySettlementAmount() {
      return this.actuallySettlementAmount;
   }

   public String getLastOperatorId() {
      return this.lastOperatorId;
   }

   public String getReason() {
      return this.reason;
   }

   public List<OaPaymentDetailDTO> getActuallyPaymentDetails() {
      return this.actuallyPaymentDetails;
   }

   public OaWorkflowDTOParam setRequestId(final String requestId) {
      this.requestId = requestId;
      return this;
   }

   public OaWorkflowDTOParam setWorkflowId(final String workflowId) {
      this.workflowId = workflowId;
      return this;
   }

   public OaWorkflowDTOParam setWorkflowName(final String workflowName) {
      this.workflowName = workflowName;
      return this;
   }

   public OaWorkflowDTOParam setWorkflowTypeName(final String workflowTypeName) {
      this.workflowTypeName = workflowTypeName;
      return this;
   }

   public OaWorkflowDTOParam setRequestmark(final String requestmark) {
      this.requestmark = requestmark;
      return this;
   }

   public OaWorkflowDTOParam setApproveStatus(final String approveStatus) {
      this.approveStatus = approveStatus;
      return this;
   }

   public OaWorkflowDTOParam setActuallySettlementAmount(final String actuallySettlementAmount) {
      this.actuallySettlementAmount = actuallySettlementAmount;
      return this;
   }

   public OaWorkflowDTOParam setLastOperatorId(final String lastOperatorId) {
      this.lastOperatorId = lastOperatorId;
      return this;
   }

   public OaWorkflowDTOParam setReason(final String reason) {
      this.reason = reason;
      return this;
   }

   public OaWorkflowDTOParam setActuallyPaymentDetails(final List<OaPaymentDetailDTO> actuallyPaymentDetails) {
      this.actuallyPaymentDetails = actuallyPaymentDetails;
      return this;
   }

   @Override
   public String toString() {
      return "OaWorkflowDTOParam(requestId="
         + this.getRequestId()
         + ", workflowId="
         + this.getWorkflowId()
         + ", workflowName="
         + this.getWorkflowName()
         + ", workflowTypeName="
         + this.getWorkflowTypeName()
         + ", requestmark="
         + this.getRequestmark()
         + ", approveStatus="
         + this.getApproveStatus()
         + ", actuallySettlementAmount="
         + this.getActuallySettlementAmount()
         + ", lastOperatorId="
         + this.getLastOperatorId()
         + ", reason="
         + this.getReason()
         + ", actuallyPaymentDetails="
         + this.getActuallyPaymentDetails()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OaWorkflowDTOParam)) {
         return false;
      }

      OaWorkflowDTOParam other = (OaWorkflowDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$requestId = this.getRequestId();
      Object other$requestId = other.getRequestId();
      if (this$requestId == null ? other$requestId == null : this$requestId.equals(other$requestId)) {
         Object this$workflowId = this.getWorkflowId();
         Object other$workflowId = other.getWorkflowId();
         if (this$workflowId == null ? other$workflowId == null : this$workflowId.equals(other$workflowId)) {
            Object this$workflowName = this.getWorkflowName();
            Object other$workflowName = other.getWorkflowName();
            if (this$workflowName == null ? other$workflowName == null : this$workflowName.equals(other$workflowName)) {
               Object this$workflowTypeName = this.getWorkflowTypeName();
               Object other$workflowTypeName = other.getWorkflowTypeName();
               if (this$workflowTypeName == null ? other$workflowTypeName == null : this$workflowTypeName.equals(other$workflowTypeName)) {
                  Object this$requestmark = this.getRequestmark();
                  Object other$requestmark = other.getRequestmark();
                  if (this$requestmark == null ? other$requestmark == null : this$requestmark.equals(other$requestmark)) {
                     Object this$approveStatus = this.getApproveStatus();
                     Object other$approveStatus = other.getApproveStatus();
                     if (this$approveStatus == null ? other$approveStatus == null : this$approveStatus.equals(other$approveStatus)) {
                        Object this$actuallySettlementAmount = this.getActuallySettlementAmount();
                        Object other$actuallySettlementAmount = other.getActuallySettlementAmount();
                        if (this$actuallySettlementAmount == null
                           ? other$actuallySettlementAmount == null
                           : this$actuallySettlementAmount.equals(other$actuallySettlementAmount)) {
                           Object this$lastOperatorId = this.getLastOperatorId();
                           Object other$lastOperatorId = other.getLastOperatorId();
                           if (this$lastOperatorId == null ? other$lastOperatorId == null : this$lastOperatorId.equals(other$lastOperatorId)) {
                              Object this$reason = this.getReason();
                              Object other$reason = other.getReason();
                              if (this$reason == null ? other$reason == null : this$reason.equals(other$reason)) {
                                 Object this$actuallyPaymentDetails = this.getActuallyPaymentDetails();
                                 Object other$actuallyPaymentDetails = other.getActuallyPaymentDetails();
                                 return this$actuallyPaymentDetails == null
                                    ? other$actuallyPaymentDetails == null
                                    : this$actuallyPaymentDetails.equals(other$actuallyPaymentDetails);
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
      return other instanceof OaWorkflowDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $requestId = this.getRequestId();
      result = result * 59 + ($requestId == null ? 43 : $requestId.hashCode());
      Object $workflowId = this.getWorkflowId();
      result = result * 59 + ($workflowId == null ? 43 : $workflowId.hashCode());
      Object $workflowName = this.getWorkflowName();
      result = result * 59 + ($workflowName == null ? 43 : $workflowName.hashCode());
      Object $workflowTypeName = this.getWorkflowTypeName();
      result = result * 59 + ($workflowTypeName == null ? 43 : $workflowTypeName.hashCode());
      Object $requestmark = this.getRequestmark();
      result = result * 59 + ($requestmark == null ? 43 : $requestmark.hashCode());
      Object $approveStatus = this.getApproveStatus();
      result = result * 59 + ($approveStatus == null ? 43 : $approveStatus.hashCode());
      Object $actuallySettlementAmount = this.getActuallySettlementAmount();
      result = result * 59 + ($actuallySettlementAmount == null ? 43 : $actuallySettlementAmount.hashCode());
      Object $lastOperatorId = this.getLastOperatorId();
      result = result * 59 + ($lastOperatorId == null ? 43 : $lastOperatorId.hashCode());
      Object $reason = this.getReason();
      result = result * 59 + ($reason == null ? 43 : $reason.hashCode());
      Object $actuallyPaymentDetails = this.getActuallyPaymentDetails();
      return result * 59 + ($actuallyPaymentDetails == null ? 43 : $actuallyPaymentDetails.hashCode());
   }

   public static class OaWorkflowDTOParamBuilder {
      private String requestId;
      private String workflowId;
      private String workflowName;
      private String workflowTypeName;
      private String requestmark;
      private String approveStatus;
      private String actuallySettlementAmount;
      private String lastOperatorId;
      private String reason;
      private List<OaPaymentDetailDTO> actuallyPaymentDetails;

      OaWorkflowDTOParamBuilder() {
      }

      public OaWorkflowDTOParam.OaWorkflowDTOParamBuilder requestId(final String requestId) {
         this.requestId = requestId;
         return this;
      }

      public OaWorkflowDTOParam.OaWorkflowDTOParamBuilder workflowId(final String workflowId) {
         this.workflowId = workflowId;
         return this;
      }

      public OaWorkflowDTOParam.OaWorkflowDTOParamBuilder workflowName(final String workflowName) {
         this.workflowName = workflowName;
         return this;
      }

      public OaWorkflowDTOParam.OaWorkflowDTOParamBuilder workflowTypeName(final String workflowTypeName) {
         this.workflowTypeName = workflowTypeName;
         return this;
      }

      public OaWorkflowDTOParam.OaWorkflowDTOParamBuilder requestmark(final String requestmark) {
         this.requestmark = requestmark;
         return this;
      }

      public OaWorkflowDTOParam.OaWorkflowDTOParamBuilder approveStatus(final String approveStatus) {
         this.approveStatus = approveStatus;
         return this;
      }

      public OaWorkflowDTOParam.OaWorkflowDTOParamBuilder actuallySettlementAmount(final String actuallySettlementAmount) {
         this.actuallySettlementAmount = actuallySettlementAmount;
         return this;
      }

      public OaWorkflowDTOParam.OaWorkflowDTOParamBuilder lastOperatorId(final String lastOperatorId) {
         this.lastOperatorId = lastOperatorId;
         return this;
      }

      public OaWorkflowDTOParam.OaWorkflowDTOParamBuilder reason(final String reason) {
         this.reason = reason;
         return this;
      }

      public OaWorkflowDTOParam.OaWorkflowDTOParamBuilder actuallyPaymentDetails(final List<OaPaymentDetailDTO> actuallyPaymentDetails) {
         this.actuallyPaymentDetails = actuallyPaymentDetails;
         return this;
      }

      public OaWorkflowDTOParam build() {
         return new OaWorkflowDTOParam(
            this.requestId,
            this.workflowId,
            this.workflowName,
            this.workflowTypeName,
            this.requestmark,
            this.approveStatus,
            this.actuallySettlementAmount,
            this.lastOperatorId,
            this.reason,
            this.actuallyPaymentDetails
         );
      }

      @Override
      public String toString() {
         return "OaWorkflowDTOParam.OaWorkflowDTOParamBuilder(requestId="
            + this.requestId
            + ", workflowId="
            + this.workflowId
            + ", workflowName="
            + this.workflowName
            + ", workflowTypeName="
            + this.workflowTypeName
            + ", requestmark="
            + this.requestmark
            + ", approveStatus="
            + this.approveStatus
            + ", actuallySettlementAmount="
            + this.actuallySettlementAmount
            + ", lastOperatorId="
            + this.lastOperatorId
            + ", reason="
            + this.reason
            + ", actuallyPaymentDetails="
            + this.actuallyPaymentDetails
            + ")";
      }
   }
}
