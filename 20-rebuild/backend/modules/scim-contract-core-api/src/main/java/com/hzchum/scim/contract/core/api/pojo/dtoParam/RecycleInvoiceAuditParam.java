package com.hzchum.scim.contract.core.api.pojo.dtoParam;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.contract.core.api.enums.AuditStatusEnum;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class RecycleInvoiceAuditParam {
   @ApiModelProperty("收票记录id")
   @NotNull(message = "收票记录id不能为空")
   Long id;
   @ApiModelProperty("审核状态")
   @EnumValidator(value = AuditStatusEnum.class, message = "审核状态有误!")
   @NotNull(message = "审核状态不能为空")
   Integer auditStatus;

   public Long getId() {
      return this.id;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof RecycleInvoiceAuditParam)) {
         return false;
      } else {
         RecycleInvoiceAuditParam other = (RecycleInvoiceAuditParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$auditStatus = this.getAuditStatus();
               Object other$auditStatus = other.getAuditStatus();
               return this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof RecycleInvoiceAuditParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $auditStatus = this.getAuditStatus();
      return result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
   }

   @Override
   public String toString() {
      return "RecycleInvoiceAuditParam(id=" + this.getId() + ", auditStatus=" + this.getAuditStatus() + ")";
   }
}
