package com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

@ApiModel(description = "")
public class PaymentFindDTOParam {
   @ApiModelProperty(notes = "付款单位")
   String paymentUnit;
   @ApiModelProperty(notes = "收款单位")
   String receivingUnit;
   @ApiModelProperty(notes = "项目id")
   Long projectId;
   @ApiModelProperty(notes = "订单号")
   String serialNumber;
   @ApiModelProperty(notes = "开始时间")
   LocalDate startDate;
   @ApiModelProperty(notes = "结束时间")
   LocalDate endDate;
   @ApiModelProperty("审核状态")
   Integer auditStatus;

   public String getPaymentUnit() {
      return this.paymentUnit;
   }

   public String getReceivingUnit() {
      return this.receivingUnit;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public void setPaymentUnit(final String paymentUnit) {
      this.paymentUnit = paymentUnit;
   }

   public void setReceivingUnit(final String receivingUnit) {
      this.receivingUnit = receivingUnit;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PaymentFindDTOParam)) {
         return false;
      }

      PaymentFindDTOParam other = (PaymentFindDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$auditStatus = this.getAuditStatus();
         Object other$auditStatus = other.getAuditStatus();
         if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
            Object this$paymentUnit = this.getPaymentUnit();
            Object other$paymentUnit = other.getPaymentUnit();
            if (this$paymentUnit == null ? other$paymentUnit == null : this$paymentUnit.equals(other$paymentUnit)) {
               Object this$receivingUnit = this.getReceivingUnit();
               Object other$receivingUnit = other.getReceivingUnit();
               if (this$receivingUnit == null ? other$receivingUnit == null : this$receivingUnit.equals(other$receivingUnit)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$startDate = this.getStartDate();
                     Object other$startDate = other.getStartDate();
                     if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                        Object this$endDate = this.getEndDate();
                        Object other$endDate = other.getEndDate();
                        return this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate);
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
      return other instanceof PaymentFindDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $paymentUnit = this.getPaymentUnit();
      result = result * 59 + ($paymentUnit == null ? 43 : $paymentUnit.hashCode());
      Object $receivingUnit = this.getReceivingUnit();
      result = result * 59 + ($receivingUnit == null ? 43 : $receivingUnit.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      return result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
   }

   @Override
   public String toString() {
      return "PaymentFindDTOParam(paymentUnit="
         + this.getPaymentUnit()
         + ", receivingUnit="
         + this.getReceivingUnit()
         + ", projectId="
         + this.getProjectId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", auditStatus="
         + this.getAuditStatus()
         + ")";
   }
}
