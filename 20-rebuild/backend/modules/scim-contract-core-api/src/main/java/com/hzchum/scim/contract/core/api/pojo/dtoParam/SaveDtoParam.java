package com.hzchum.scim.contract.core.api.pojo.dtoParam;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

public class SaveDtoParam {
   private Long projectId;
   private Integer auditStatus;
   @DecimalMin(value = "0.01", message = "金额必须大于0")
   private BigDecimal depositRefund;
   private BigDecimal finalAmount;
   @DecimalMax(value = "100", message = "费率不能大于100")
   @DecimalMin(value = "0.01", message = "费率必须大于0")
   private BigDecimal cashDeposit;
   private LocalDateTime dateTime;
   private LocalDateTime startTime;

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public BigDecimal getDepositRefund() {
      return this.depositRefund;
   }

   public BigDecimal getFinalAmount() {
      return this.finalAmount;
   }

   public BigDecimal getCashDeposit() {
      return this.cashDeposit;
   }

   public LocalDateTime getDateTime() {
      return this.dateTime;
   }

   public LocalDateTime getStartTime() {
      return this.startTime;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   public void setDepositRefund(final BigDecimal depositRefund) {
      this.depositRefund = depositRefund;
   }

   public void setFinalAmount(final BigDecimal finalAmount) {
      this.finalAmount = finalAmount;
   }

   public void setCashDeposit(final BigDecimal cashDeposit) {
      this.cashDeposit = cashDeposit;
   }

   public void setDateTime(final LocalDateTime dateTime) {
      this.dateTime = dateTime;
   }

   public void setStartTime(final LocalDateTime startTime) {
      this.startTime = startTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SaveDtoParam)) {
         return false;
      }

      SaveDtoParam other = (SaveDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$auditStatus = this.getAuditStatus();
         Object other$auditStatus = other.getAuditStatus();
         if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
            Object this$depositRefund = this.getDepositRefund();
            Object other$depositRefund = other.getDepositRefund();
            if (this$depositRefund == null ? other$depositRefund == null : this$depositRefund.equals(other$depositRefund)) {
               Object this$finalAmount = this.getFinalAmount();
               Object other$finalAmount = other.getFinalAmount();
               if (this$finalAmount == null ? other$finalAmount == null : this$finalAmount.equals(other$finalAmount)) {
                  Object this$cashDeposit = this.getCashDeposit();
                  Object other$cashDeposit = other.getCashDeposit();
                  if (this$cashDeposit == null ? other$cashDeposit == null : this$cashDeposit.equals(other$cashDeposit)) {
                     Object this$dateTime = this.getDateTime();
                     Object other$dateTime = other.getDateTime();
                     if (this$dateTime == null ? other$dateTime == null : this$dateTime.equals(other$dateTime)) {
                        Object this$startTime = this.getStartTime();
                        Object other$startTime = other.getStartTime();
                        return this$startTime == null ? other$startTime == null : this$startTime.equals(other$startTime);
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
      return other instanceof SaveDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $depositRefund = this.getDepositRefund();
      result = result * 59 + ($depositRefund == null ? 43 : $depositRefund.hashCode());
      Object $finalAmount = this.getFinalAmount();
      result = result * 59 + ($finalAmount == null ? 43 : $finalAmount.hashCode());
      Object $cashDeposit = this.getCashDeposit();
      result = result * 59 + ($cashDeposit == null ? 43 : $cashDeposit.hashCode());
      Object $dateTime = this.getDateTime();
      result = result * 59 + ($dateTime == null ? 43 : $dateTime.hashCode());
      Object $startTime = this.getStartTime();
      return result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
   }

   @Override
   public String toString() {
      return "SaveDtoParam(projectId="
         + this.getProjectId()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", depositRefund="
         + this.getDepositRefund()
         + ", finalAmount="
         + this.getFinalAmount()
         + ", cashDeposit="
         + this.getCashDeposit()
         + ", dateTime="
         + this.getDateTime()
         + ", startTime="
         + this.getStartTime()
         + ")";
   }

   public SaveDtoParam(
      final Long projectId,
      final Integer auditStatus,
      final BigDecimal depositRefund,
      final BigDecimal finalAmount,
      final BigDecimal cashDeposit,
      final LocalDateTime dateTime,
      final LocalDateTime startTime
   ) {
      this.projectId = projectId;
      this.auditStatus = auditStatus;
      this.depositRefund = depositRefund;
      this.finalAmount = finalAmount;
      this.cashDeposit = cashDeposit;
      this.dateTime = dateTime;
      this.startTime = startTime;
   }

   public SaveDtoParam() {
   }
}
