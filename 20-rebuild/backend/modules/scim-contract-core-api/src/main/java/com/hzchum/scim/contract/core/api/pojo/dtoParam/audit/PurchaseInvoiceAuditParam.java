package com.hzchum.scim.contract.core.api.pojo.dtoParam.audit;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PurchaseInvoiceAuditParam {
   @NotNull(message = "审批id不能为空")
   @ApiModelProperty(value = "审批id", notes = "审批id")
   private Long auditId;
   @Valid
   @NotEmpty(message = "订单开票列表不能为空!")
   @ApiModelProperty("订单开票明显列表")
   private List<PurchaseInvoiceAuditDetailParam> orderInvoiceList;
   @ApiModelProperty("发票编号")
   private String invoiceSerialNumber;
   @NotNull(message = "审批状态不能为空")
   @ApiModelProperty(value = "审批状态", notes = "审批状态")
   private Integer auditStatusEnum;
   @ApiModelProperty(value = "发票附件", notes = "发票附件")
   private Long attachmentId;
   @ApiModelProperty(value = "备注", notes = "备注")
   private String remark;

   public Long getAuditId() {
      return this.auditId;
   }

   public List<PurchaseInvoiceAuditDetailParam> getOrderInvoiceList() {
      return this.orderInvoiceList;
   }

   public String getInvoiceSerialNumber() {
      return this.invoiceSerialNumber;
   }

   public Integer getAuditStatusEnum() {
      return this.auditStatusEnum;
   }

   public Long getAttachmentId() {
      return this.attachmentId;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setAuditId(final Long auditId) {
      this.auditId = auditId;
   }

   public void setOrderInvoiceList(final List<PurchaseInvoiceAuditDetailParam> orderInvoiceList) {
      this.orderInvoiceList = orderInvoiceList;
   }

   public void setInvoiceSerialNumber(final String invoiceSerialNumber) {
      this.invoiceSerialNumber = invoiceSerialNumber;
   }

   public void setAuditStatusEnum(final Integer auditStatusEnum) {
      this.auditStatusEnum = auditStatusEnum;
   }

   public void setAttachmentId(final Long attachmentId) {
      this.attachmentId = attachmentId;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PurchaseInvoiceAuditParam)) {
         return false;
      }

      PurchaseInvoiceAuditParam other = (PurchaseInvoiceAuditParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$auditId = this.getAuditId();
      Object other$auditId = other.getAuditId();
      if (this$auditId == null ? other$auditId == null : this$auditId.equals(other$auditId)) {
         Object this$auditStatusEnum = this.getAuditStatusEnum();
         Object other$auditStatusEnum = other.getAuditStatusEnum();
         if (this$auditStatusEnum == null ? other$auditStatusEnum == null : this$auditStatusEnum.equals(other$auditStatusEnum)) {
            Object this$attachmentId = this.getAttachmentId();
            Object other$attachmentId = other.getAttachmentId();
            if (this$attachmentId == null ? other$attachmentId == null : this$attachmentId.equals(other$attachmentId)) {
               Object this$orderInvoiceList = this.getOrderInvoiceList();
               Object other$orderInvoiceList = other.getOrderInvoiceList();
               if (this$orderInvoiceList == null ? other$orderInvoiceList == null : this$orderInvoiceList.equals(other$orderInvoiceList)) {
                  Object this$invoiceSerialNumber = this.getInvoiceSerialNumber();
                  Object other$invoiceSerialNumber = other.getInvoiceSerialNumber();
                  if (this$invoiceSerialNumber == null ? other$invoiceSerialNumber == null : this$invoiceSerialNumber.equals(other$invoiceSerialNumber)) {
                     Object this$remark = this.getRemark();
                     Object other$remark = other.getRemark();
                     return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof PurchaseInvoiceAuditParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $auditId = this.getAuditId();
      result = result * 59 + ($auditId == null ? 43 : $auditId.hashCode());
      Object $auditStatusEnum = this.getAuditStatusEnum();
      result = result * 59 + ($auditStatusEnum == null ? 43 : $auditStatusEnum.hashCode());
      Object $attachmentId = this.getAttachmentId();
      result = result * 59 + ($attachmentId == null ? 43 : $attachmentId.hashCode());
      Object $orderInvoiceList = this.getOrderInvoiceList();
      result = result * 59 + ($orderInvoiceList == null ? 43 : $orderInvoiceList.hashCode());
      Object $invoiceSerialNumber = this.getInvoiceSerialNumber();
      result = result * 59 + ($invoiceSerialNumber == null ? 43 : $invoiceSerialNumber.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "PurchaseInvoiceAuditParam(auditId="
         + this.getAuditId()
         + ", orderInvoiceList="
         + this.getOrderInvoiceList()
         + ", invoiceSerialNumber="
         + this.getInvoiceSerialNumber()
         + ", auditStatusEnum="
         + this.getAuditStatusEnum()
         + ", attachmentId="
         + this.getAttachmentId()
         + ", remark="
         + this.getRemark()
         + ")";
   }
}
