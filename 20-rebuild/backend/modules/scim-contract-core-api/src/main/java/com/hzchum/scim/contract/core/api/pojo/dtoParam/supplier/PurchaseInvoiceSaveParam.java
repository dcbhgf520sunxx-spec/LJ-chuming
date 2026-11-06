package com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel("新增-收票填报类(自合营)")
public class PurchaseInvoiceSaveParam {
   @Valid
   @NotEmpty(message = "订单列表不能为空!")
   @ApiModelProperty("订单开票明细列表")
   List<PurchaseInvoiceDetailSaveParam> orderInvoiceList;
   @ApiModelProperty("发票编号")
   @NotBlank(message = "发票编号不能为空")
   @Size(max = 50, message = "发票编号不能超过50个字符")
   private String invoiceSerialNumber;
   @ApiModelProperty("备注")
   @Size(max = 500, message = "备注不能超过500个字符")
   private String remark;
   @ApiModelProperty("附件id列表")
   private List<Long> attachmentIds;

   public static PurchaseInvoiceSaveParam.PurchaseInvoiceSaveParamBuilder builder() {
      return new PurchaseInvoiceSaveParam.PurchaseInvoiceSaveParamBuilder();
   }

   public PurchaseInvoiceSaveParam() {
   }

   public PurchaseInvoiceSaveParam(
      final List<PurchaseInvoiceDetailSaveParam> orderInvoiceList, final String invoiceSerialNumber, final String remark, final List<Long> attachmentIds
   ) {
      this.orderInvoiceList = orderInvoiceList;
      this.invoiceSerialNumber = invoiceSerialNumber;
      this.remark = remark;
      this.attachmentIds = attachmentIds;
   }

   public List<PurchaseInvoiceDetailSaveParam> getOrderInvoiceList() {
      return this.orderInvoiceList;
   }

   public String getInvoiceSerialNumber() {
      return this.invoiceSerialNumber;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<Long> getAttachmentIds() {
      return this.attachmentIds;
   }

   public void setOrderInvoiceList(final List<PurchaseInvoiceDetailSaveParam> orderInvoiceList) {
      this.orderInvoiceList = orderInvoiceList;
   }

   public void setInvoiceSerialNumber(final String invoiceSerialNumber) {
      this.invoiceSerialNumber = invoiceSerialNumber;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setAttachmentIds(final List<Long> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PurchaseInvoiceSaveParam)) {
         return false;
      }

      PurchaseInvoiceSaveParam other = (PurchaseInvoiceSaveParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderInvoiceList = this.getOrderInvoiceList();
      Object other$orderInvoiceList = other.getOrderInvoiceList();
      if (this$orderInvoiceList == null ? other$orderInvoiceList == null : this$orderInvoiceList.equals(other$orderInvoiceList)) {
         Object this$invoiceSerialNumber = this.getInvoiceSerialNumber();
         Object other$invoiceSerialNumber = other.getInvoiceSerialNumber();
         if (this$invoiceSerialNumber == null ? other$invoiceSerialNumber == null : this$invoiceSerialNumber.equals(other$invoiceSerialNumber)) {
            Object this$remark = this.getRemark();
            Object other$remark = other.getRemark();
            if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
               Object this$attachmentIds = this.getAttachmentIds();
               Object other$attachmentIds = other.getAttachmentIds();
               return this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds);
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
      return other instanceof PurchaseInvoiceSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderInvoiceList = this.getOrderInvoiceList();
      result = result * 59 + ($orderInvoiceList == null ? 43 : $orderInvoiceList.hashCode());
      Object $invoiceSerialNumber = this.getInvoiceSerialNumber();
      result = result * 59 + ($invoiceSerialNumber == null ? 43 : $invoiceSerialNumber.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      return result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
   }

   @Override
   public String toString() {
      return "PurchaseInvoiceSaveParam(orderInvoiceList="
         + this.getOrderInvoiceList()
         + ", invoiceSerialNumber="
         + this.getInvoiceSerialNumber()
         + ", remark="
         + this.getRemark()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ")";
   }

   public static class PurchaseInvoiceSaveParamBuilder {
      private List<PurchaseInvoiceDetailSaveParam> orderInvoiceList;
      private String invoiceSerialNumber;
      private String remark;
      private List<Long> attachmentIds;

      PurchaseInvoiceSaveParamBuilder() {
      }

      public PurchaseInvoiceSaveParam.PurchaseInvoiceSaveParamBuilder orderInvoiceList(final List<PurchaseInvoiceDetailSaveParam> orderInvoiceList) {
         this.orderInvoiceList = orderInvoiceList;
         return this;
      }

      public PurchaseInvoiceSaveParam.PurchaseInvoiceSaveParamBuilder invoiceSerialNumber(final String invoiceSerialNumber) {
         this.invoiceSerialNumber = invoiceSerialNumber;
         return this;
      }

      public PurchaseInvoiceSaveParam.PurchaseInvoiceSaveParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public PurchaseInvoiceSaveParam.PurchaseInvoiceSaveParamBuilder attachmentIds(final List<Long> attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public PurchaseInvoiceSaveParam build() {
         return new PurchaseInvoiceSaveParam(this.orderInvoiceList, this.invoiceSerialNumber, this.remark, this.attachmentIds);
      }

      @Override
      public String toString() {
         return "PurchaseInvoiceSaveParam.PurchaseInvoiceSaveParamBuilder(orderInvoiceList="
            + this.orderInvoiceList
            + ", invoiceSerialNumber="
            + this.invoiceSerialNumber
            + ", remark="
            + this.remark
            + ", attachmentIds="
            + this.attachmentIds
            + ")";
      }
   }
}
