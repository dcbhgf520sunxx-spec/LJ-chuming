package com.hzchum.scim.contract.core.api.pojo.dtoParam.finance;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class ContractGivingCreditDetailDoParam {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "userId", value = "创建人", notes = "创建人")
   private Long userId;
   @ApiModelProperty(name = "creditId", value = "授信id", notes = "授信id")
   private Long creditId;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "purchaseId", value = "采购id", notes = "采购id")
   private Long purchaseId;
   @ApiModelProperty(name = "useAmount", value = "使用额度", notes = "使用额度")
   private BigDecimal useAmount;
   @ApiModelProperty(name = "residueAmount", value = "剩余额度", notes = "剩余额度")
   private BigDecimal residueAmount;
   @ApiModelProperty(name = "paymentReasonId", value = "付款事由", notes = "付款事由")
   private Integer paymentReasonId;
   @ApiModelProperty(name = "auditStatus", value = "审批状态 审批状态：1 待审核 2 通过 4 不通过", notes = "审批状态 审批状态：1 待审核 2 通过 4 不通过")
   private Integer auditStatus;

   public static ContractGivingCreditDetailDoParam.ContractGivingCreditDetailDoParamBuilder builder() {
      return new ContractGivingCreditDetailDoParam.ContractGivingCreditDetailDoParamBuilder();
   }

   public ContractGivingCreditDetailDoParam() {
   }

   public ContractGivingCreditDetailDoParam(
      final Long id,
      final Long userId,
      final Long creditId,
      final Long projectId,
      final Long purchaseId,
      final BigDecimal useAmount,
      final BigDecimal residueAmount,
      final Integer paymentReasonId,
      final Integer auditStatus
   ) {
      this.id = id;
      this.userId = userId;
      this.creditId = creditId;
      this.projectId = projectId;
      this.purchaseId = purchaseId;
      this.useAmount = useAmount;
      this.residueAmount = residueAmount;
      this.paymentReasonId = paymentReasonId;
      this.auditStatus = auditStatus;
   }

   public Long getId() {
      return this.id;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getCreditId() {
      return this.creditId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getPurchaseId() {
      return this.purchaseId;
   }

   public BigDecimal getUseAmount() {
      return this.useAmount;
   }

   public BigDecimal getResidueAmount() {
      return this.residueAmount;
   }

   public Integer getPaymentReasonId() {
      return this.paymentReasonId;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public ContractGivingCreditDetailDoParam setId(final Long id) {
      this.id = id;
      return this;
   }

   public ContractGivingCreditDetailDoParam setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public ContractGivingCreditDetailDoParam setCreditId(final Long creditId) {
      this.creditId = creditId;
      return this;
   }

   public ContractGivingCreditDetailDoParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ContractGivingCreditDetailDoParam setPurchaseId(final Long purchaseId) {
      this.purchaseId = purchaseId;
      return this;
   }

   public ContractGivingCreditDetailDoParam setUseAmount(final BigDecimal useAmount) {
      this.useAmount = useAmount;
      return this;
   }

   public ContractGivingCreditDetailDoParam setResidueAmount(final BigDecimal residueAmount) {
      this.residueAmount = residueAmount;
      return this;
   }

   public ContractGivingCreditDetailDoParam setPaymentReasonId(final Integer paymentReasonId) {
      this.paymentReasonId = paymentReasonId;
      return this;
   }

   public ContractGivingCreditDetailDoParam setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractGivingCreditDetailDoParam)) {
         return false;
      }

      ContractGivingCreditDetailDoParam other = (ContractGivingCreditDetailDoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$userId = this.getUserId();
         Object other$userId = other.getUserId();
         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
            Object this$creditId = this.getCreditId();
            Object other$creditId = other.getCreditId();
            if (this$creditId == null ? other$creditId == null : this$creditId.equals(other$creditId)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$purchaseId = this.getPurchaseId();
                  Object other$purchaseId = other.getPurchaseId();
                  if (this$purchaseId == null ? other$purchaseId == null : this$purchaseId.equals(other$purchaseId)) {
                     Object this$paymentReasonId = this.getPaymentReasonId();
                     Object other$paymentReasonId = other.getPaymentReasonId();
                     if (this$paymentReasonId == null ? other$paymentReasonId == null : this$paymentReasonId.equals(other$paymentReasonId)) {
                        Object this$auditStatus = this.getAuditStatus();
                        Object other$auditStatus = other.getAuditStatus();
                        if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                           Object this$useAmount = this.getUseAmount();
                           Object other$useAmount = other.getUseAmount();
                           if (this$useAmount == null ? other$useAmount == null : this$useAmount.equals(other$useAmount)) {
                              Object this$residueAmount = this.getResidueAmount();
                              Object other$residueAmount = other.getResidueAmount();
                              return this$residueAmount == null ? other$residueAmount == null : this$residueAmount.equals(other$residueAmount);
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
      return other instanceof ContractGivingCreditDetailDoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $creditId = this.getCreditId();
      result = result * 59 + ($creditId == null ? 43 : $creditId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $purchaseId = this.getPurchaseId();
      result = result * 59 + ($purchaseId == null ? 43 : $purchaseId.hashCode());
      Object $paymentReasonId = this.getPaymentReasonId();
      result = result * 59 + ($paymentReasonId == null ? 43 : $paymentReasonId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $useAmount = this.getUseAmount();
      result = result * 59 + ($useAmount == null ? 43 : $useAmount.hashCode());
      Object $residueAmount = this.getResidueAmount();
      return result * 59 + ($residueAmount == null ? 43 : $residueAmount.hashCode());
   }

   @Override
   public String toString() {
      return "ContractGivingCreditDetailDoParam(id="
         + this.getId()
         + ", userId="
         + this.getUserId()
         + ", creditId="
         + this.getCreditId()
         + ", projectId="
         + this.getProjectId()
         + ", purchaseId="
         + this.getPurchaseId()
         + ", useAmount="
         + this.getUseAmount()
         + ", residueAmount="
         + this.getResidueAmount()
         + ", paymentReasonId="
         + this.getPaymentReasonId()
         + ", auditStatus="
         + this.getAuditStatus()
         + ")";
   }

   public static class ContractGivingCreditDetailDoParamBuilder {
      private Long id;
      private Long userId;
      private Long creditId;
      private Long projectId;
      private Long purchaseId;
      private BigDecimal useAmount;
      private BigDecimal residueAmount;
      private Integer paymentReasonId;
      private Integer auditStatus;

      ContractGivingCreditDetailDoParamBuilder() {
      }

      public ContractGivingCreditDetailDoParam.ContractGivingCreditDetailDoParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractGivingCreditDetailDoParam.ContractGivingCreditDetailDoParamBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ContractGivingCreditDetailDoParam.ContractGivingCreditDetailDoParamBuilder creditId(final Long creditId) {
         this.creditId = creditId;
         return this;
      }

      public ContractGivingCreditDetailDoParam.ContractGivingCreditDetailDoParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractGivingCreditDetailDoParam.ContractGivingCreditDetailDoParamBuilder purchaseId(final Long purchaseId) {
         this.purchaseId = purchaseId;
         return this;
      }

      public ContractGivingCreditDetailDoParam.ContractGivingCreditDetailDoParamBuilder useAmount(final BigDecimal useAmount) {
         this.useAmount = useAmount;
         return this;
      }

      public ContractGivingCreditDetailDoParam.ContractGivingCreditDetailDoParamBuilder residueAmount(final BigDecimal residueAmount) {
         this.residueAmount = residueAmount;
         return this;
      }

      public ContractGivingCreditDetailDoParam.ContractGivingCreditDetailDoParamBuilder paymentReasonId(final Integer paymentReasonId) {
         this.paymentReasonId = paymentReasonId;
         return this;
      }

      public ContractGivingCreditDetailDoParam.ContractGivingCreditDetailDoParamBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public ContractGivingCreditDetailDoParam build() {
         return new ContractGivingCreditDetailDoParam(
            this.id, this.userId, this.creditId, this.projectId, this.purchaseId, this.useAmount, this.residueAmount, this.paymentReasonId, this.auditStatus
         );
      }

      @Override
      public String toString() {
         return "ContractGivingCreditDetailDoParam.ContractGivingCreditDetailDoParamBuilder(id="
            + this.id
            + ", userId="
            + this.userId
            + ", creditId="
            + this.creditId
            + ", projectId="
            + this.projectId
            + ", purchaseId="
            + this.purchaseId
            + ", useAmount="
            + this.useAmount
            + ", residueAmount="
            + this.residueAmount
            + ", paymentReasonId="
            + this.paymentReasonId
            + ", auditStatus="
            + this.auditStatus
            + ")";
      }
   }
}
