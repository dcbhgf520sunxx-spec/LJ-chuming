package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import com.hzchum.scim.scm.core.api.pojo._do.LogisticsOrder;

public class PassedDTOParam {
   private Long inboundId;
   private String approvalComments;
   private LogisticsOrder logisticsOrder;

   public static PassedDTOParam.PassedDTOParamBuilder builder() {
      return new PassedDTOParam.PassedDTOParamBuilder();
   }

   public Long getInboundId() {
      return this.inboundId;
   }

   public String getApprovalComments() {
      return this.approvalComments;
   }

   public LogisticsOrder getLogisticsOrder() {
      return this.logisticsOrder;
   }

   public void setInboundId(final Long inboundId) {
      this.inboundId = inboundId;
   }

   public void setApprovalComments(final String approvalComments) {
      this.approvalComments = approvalComments;
   }

   public void setLogisticsOrder(final LogisticsOrder logisticsOrder) {
      this.logisticsOrder = logisticsOrder;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PassedDTOParam)) {
         return false;
      }

      PassedDTOParam other = (PassedDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$inboundId = this.getInboundId();
      Object other$inboundId = other.getInboundId();
      if (this$inboundId == null ? other$inboundId == null : this$inboundId.equals(other$inboundId)) {
         Object this$approvalComments = this.getApprovalComments();
         Object other$approvalComments = other.getApprovalComments();
         if (this$approvalComments == null ? other$approvalComments == null : this$approvalComments.equals(other$approvalComments)) {
            Object this$logisticsOrder = this.getLogisticsOrder();
            Object other$logisticsOrder = other.getLogisticsOrder();
            return this$logisticsOrder == null ? other$logisticsOrder == null : this$logisticsOrder.equals(other$logisticsOrder);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PassedDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $inboundId = this.getInboundId();
      result = result * 59 + ($inboundId == null ? 43 : $inboundId.hashCode());
      Object $approvalComments = this.getApprovalComments();
      result = result * 59 + ($approvalComments == null ? 43 : $approvalComments.hashCode());
      Object $logisticsOrder = this.getLogisticsOrder();
      return result * 59 + ($logisticsOrder == null ? 43 : $logisticsOrder.hashCode());
   }

   @Override
   public String toString() {
      return "PassedDTOParam(inboundId="
         + this.getInboundId()
         + ", approvalComments="
         + this.getApprovalComments()
         + ", logisticsOrder="
         + this.getLogisticsOrder()
         + ")";
   }

   public PassedDTOParam(final Long inboundId, final String approvalComments, final LogisticsOrder logisticsOrder) {
      this.inboundId = inboundId;
      this.approvalComments = approvalComments;
      this.logisticsOrder = logisticsOrder;
   }

   public PassedDTOParam() {
   }

   public static class PassedDTOParamBuilder {
      private Long inboundId;
      private String approvalComments;
      private LogisticsOrder logisticsOrder;

      PassedDTOParamBuilder() {
      }

      public PassedDTOParam.PassedDTOParamBuilder inboundId(final Long inboundId) {
         this.inboundId = inboundId;
         return this;
      }

      public PassedDTOParam.PassedDTOParamBuilder approvalComments(final String approvalComments) {
         this.approvalComments = approvalComments;
         return this;
      }

      public PassedDTOParam.PassedDTOParamBuilder logisticsOrder(final LogisticsOrder logisticsOrder) {
         this.logisticsOrder = logisticsOrder;
         return this;
      }

      public PassedDTOParam build() {
         return new PassedDTOParam(this.inboundId, this.approvalComments, this.logisticsOrder);
      }

      @Override
      public String toString() {
         return "PassedDTOParam.PassedDTOParamBuilder(inboundId="
            + this.inboundId
            + ", approvalComments="
            + this.approvalComments
            + ", logisticsOrder="
            + this.logisticsOrder
            + ")";
      }
   }
}
