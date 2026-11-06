package com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel("新增-收票填报类(自合营)")
public class SubOrderInvoiceAddParam {
   @ApiModelProperty("采购单id")
   @NotNull(message = "采购单id不能为空")
   private Long orderId;
   @ApiModelProperty("本次发票额")
   @NotNull(message = "本次发票额不能为空")
   private BigDecimal invoiceAmount;
   @ApiModelProperty("发票编号")
   @NotBlank(message = "发票编号不能为空")
   @Size(max = 50, message = "发票编号不能超过50个字符")
   private String invoiceSerialNumber;
   @ApiModelProperty("备注")
   @Size(max = 500, message = "备注不能超过500个字符")
   private String remark;
   @ApiModelProperty("附件id")
   private List<Long> attachmentId;

   public static SubOrderInvoiceAddParam.SubOrderInvoiceAddParamBuilder builder() {
      return new SubOrderInvoiceAddParam.SubOrderInvoiceAddParamBuilder();
   }

   public SubOrderInvoiceAddParam() {
   }

   public SubOrderInvoiceAddParam(
      final Long orderId, final BigDecimal invoiceAmount, final String invoiceSerialNumber, final String remark, final List<Long> attachmentId
   ) {
      this.orderId = orderId;
      this.invoiceAmount = invoiceAmount;
      this.invoiceSerialNumber = invoiceSerialNumber;
      this.remark = remark;
      this.attachmentId = attachmentId;
   }

   public Long getOrderId() {
      return this.orderId;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public String getInvoiceSerialNumber() {
      return this.invoiceSerialNumber;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<Long> getAttachmentId() {
      return this.attachmentId;
   }

   public void setOrderId(final Long orderId) {
      this.orderId = orderId;
   }

   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
   }

   public void setInvoiceSerialNumber(final String invoiceSerialNumber) {
      this.invoiceSerialNumber = invoiceSerialNumber;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setAttachmentId(final List<Long> attachmentId) {
      this.attachmentId = attachmentId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubOrderInvoiceAddParam)) {
         return false;
      }

      SubOrderInvoiceAddParam other = (SubOrderInvoiceAddParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderId = this.getOrderId();
      Object other$orderId = other.getOrderId();
      if (this$orderId == null ? other$orderId == null : this$orderId.equals(other$orderId)) {
         Object this$invoiceAmount = this.getInvoiceAmount();
         Object other$invoiceAmount = other.getInvoiceAmount();
         if (this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount)) {
            Object this$invoiceSerialNumber = this.getInvoiceSerialNumber();
            Object other$invoiceSerialNumber = other.getInvoiceSerialNumber();
            if (this$invoiceSerialNumber == null ? other$invoiceSerialNumber == null : this$invoiceSerialNumber.equals(other$invoiceSerialNumber)) {
               Object this$remark = this.getRemark();
               Object other$remark = other.getRemark();
               if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                  Object this$attachmentId = this.getAttachmentId();
                  Object other$attachmentId = other.getAttachmentId();
                  return this$attachmentId == null ? other$attachmentId == null : this$attachmentId.equals(other$attachmentId);
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
      return other instanceof SubOrderInvoiceAddParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $invoiceSerialNumber = this.getInvoiceSerialNumber();
      result = result * 59 + ($invoiceSerialNumber == null ? 43 : $invoiceSerialNumber.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $attachmentId = this.getAttachmentId();
      return result * 59 + ($attachmentId == null ? 43 : $attachmentId.hashCode());
   }

   @Override
   public String toString() {
      return "SubOrderInvoiceAddParam(orderId="
         + this.getOrderId()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", invoiceSerialNumber="
         + this.getInvoiceSerialNumber()
         + ", remark="
         + this.getRemark()
         + ", attachmentId="
         + this.getAttachmentId()
         + ")";
   }

   public static class SubOrderInvoiceAddParamBuilder {
      private Long orderId;
      private BigDecimal invoiceAmount;
      private String invoiceSerialNumber;
      private String remark;
      private List<Long> attachmentId;

      SubOrderInvoiceAddParamBuilder() {
      }

      public SubOrderInvoiceAddParam.SubOrderInvoiceAddParamBuilder orderId(final Long orderId) {
         this.orderId = orderId;
         return this;
      }

      public SubOrderInvoiceAddParam.SubOrderInvoiceAddParamBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public SubOrderInvoiceAddParam.SubOrderInvoiceAddParamBuilder invoiceSerialNumber(final String invoiceSerialNumber) {
         this.invoiceSerialNumber = invoiceSerialNumber;
         return this;
      }

      public SubOrderInvoiceAddParam.SubOrderInvoiceAddParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public SubOrderInvoiceAddParam.SubOrderInvoiceAddParamBuilder attachmentId(final List<Long> attachmentId) {
         this.attachmentId = attachmentId;
         return this;
      }

      public SubOrderInvoiceAddParam build() {
         return new SubOrderInvoiceAddParam(this.orderId, this.invoiceAmount, this.invoiceSerialNumber, this.remark, this.attachmentId);
      }

      @Override
      public String toString() {
         return "SubOrderInvoiceAddParam.SubOrderInvoiceAddParamBuilder(orderId="
            + this.orderId
            + ", invoiceAmount="
            + this.invoiceAmount
            + ", invoiceSerialNumber="
            + this.invoiceSerialNumber
            + ", remark="
            + this.remark
            + ", attachmentId="
            + this.attachmentId
            + ")";
      }
   }
}
