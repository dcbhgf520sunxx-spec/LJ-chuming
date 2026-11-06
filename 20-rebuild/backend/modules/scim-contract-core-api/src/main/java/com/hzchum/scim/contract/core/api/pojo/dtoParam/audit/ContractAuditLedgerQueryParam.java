package com.hzchum.scim.contract.core.api.pojo.dtoParam.audit;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

public class ContractAuditLedgerQueryParam {
   Integer paymentEnum;
   LocalDateTime time;
   Integer auditStatusEnum;
   Integer projectAttribute;
   Long projectId;
   @ApiModelProperty(name = "initiatorId", value = "发起人")
   Long initiatorId;
   String oaNumber;
   Long projectManagerId;
   Long salesLeaderId;
   Long supplierId;
   @ApiModelProperty(name = "writtenById", value = "填报人")
   Long writtenById;

   public Integer getPaymentEnum() {
      return this.paymentEnum;
   }

   public LocalDateTime getTime() {
      return this.time;
   }

   public Integer getAuditStatusEnum() {
      return this.auditStatusEnum;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getInitiatorId() {
      return this.initiatorId;
   }

   public String getOaNumber() {
      return this.oaNumber;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public Long getSalesLeaderId() {
      return this.salesLeaderId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public Long getWrittenById() {
      return this.writtenById;
   }

   public void setPaymentEnum(final Integer paymentEnum) {
      this.paymentEnum = paymentEnum;
   }

   public void setTime(final LocalDateTime time) {
      this.time = time;
   }

   public void setAuditStatusEnum(final Integer auditStatusEnum) {
      this.auditStatusEnum = auditStatusEnum;
   }

   public void setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setInitiatorId(final Long initiatorId) {
      this.initiatorId = initiatorId;
   }

   public void setOaNumber(final String oaNumber) {
      this.oaNumber = oaNumber;
   }

   public void setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
   }

   public void setSalesLeaderId(final Long salesLeaderId) {
      this.salesLeaderId = salesLeaderId;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setWrittenById(final Long writtenById) {
      this.writtenById = writtenById;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractAuditLedgerQueryParam)) {
         return false;
      }

      ContractAuditLedgerQueryParam other = (ContractAuditLedgerQueryParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$paymentEnum = this.getPaymentEnum();
      Object other$paymentEnum = other.getPaymentEnum();
      if (this$paymentEnum == null ? other$paymentEnum == null : this$paymentEnum.equals(other$paymentEnum)) {
         Object this$auditStatusEnum = this.getAuditStatusEnum();
         Object other$auditStatusEnum = other.getAuditStatusEnum();
         if (this$auditStatusEnum == null ? other$auditStatusEnum == null : this$auditStatusEnum.equals(other$auditStatusEnum)) {
            Object this$projectAttribute = this.getProjectAttribute();
            Object other$projectAttribute = other.getProjectAttribute();
            if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$initiatorId = this.getInitiatorId();
                  Object other$initiatorId = other.getInitiatorId();
                  if (this$initiatorId == null ? other$initiatorId == null : this$initiatorId.equals(other$initiatorId)) {
                     Object this$projectManagerId = this.getProjectManagerId();
                     Object other$projectManagerId = other.getProjectManagerId();
                     if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
                        Object this$salesLeaderId = this.getSalesLeaderId();
                        Object other$salesLeaderId = other.getSalesLeaderId();
                        if (this$salesLeaderId == null ? other$salesLeaderId == null : this$salesLeaderId.equals(other$salesLeaderId)) {
                           Object this$supplierId = this.getSupplierId();
                           Object other$supplierId = other.getSupplierId();
                           if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                              Object this$writtenById = this.getWrittenById();
                              Object other$writtenById = other.getWrittenById();
                              if (this$writtenById == null ? other$writtenById == null : this$writtenById.equals(other$writtenById)) {
                                 Object this$time = this.getTime();
                                 Object other$time = other.getTime();
                                 if (this$time == null ? other$time == null : this$time.equals(other$time)) {
                                    Object this$oaNumber = this.getOaNumber();
                                    Object other$oaNumber = other.getOaNumber();
                                    return this$oaNumber == null ? other$oaNumber == null : this$oaNumber.equals(other$oaNumber);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ContractAuditLedgerQueryParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $paymentEnum = this.getPaymentEnum();
      result = result * 59 + ($paymentEnum == null ? 43 : $paymentEnum.hashCode());
      Object $auditStatusEnum = this.getAuditStatusEnum();
      result = result * 59 + ($auditStatusEnum == null ? 43 : $auditStatusEnum.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $initiatorId = this.getInitiatorId();
      result = result * 59 + ($initiatorId == null ? 43 : $initiatorId.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $salesLeaderId = this.getSalesLeaderId();
      result = result * 59 + ($salesLeaderId == null ? 43 : $salesLeaderId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $writtenById = this.getWrittenById();
      result = result * 59 + ($writtenById == null ? 43 : $writtenById.hashCode());
      Object $time = this.getTime();
      result = result * 59 + ($time == null ? 43 : $time.hashCode());
      Object $oaNumber = this.getOaNumber();
      return result * 59 + ($oaNumber == null ? 43 : $oaNumber.hashCode());
   }

   @Override
   public String toString() {
      return "ContractAuditLedgerQueryParam(paymentEnum="
         + this.getPaymentEnum()
         + ", time="
         + this.getTime()
         + ", auditStatusEnum="
         + this.getAuditStatusEnum()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", projectId="
         + this.getProjectId()
         + ", initiatorId="
         + this.getInitiatorId()
         + ", oaNumber="
         + this.getOaNumber()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", salesLeaderId="
         + this.getSalesLeaderId()
         + ", supplierId="
         + this.getSupplierId()
         + ", writtenById="
         + this.getWrittenById()
         + ")";
   }
}
