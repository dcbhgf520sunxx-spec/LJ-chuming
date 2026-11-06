package com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel("新增-收票填报类")
public class SupplierInvoiceAddDTOParam {
   @ApiModelProperty("开票日期")
   private LocalDateTime invoiceDate;
   @ApiModelProperty("采购单id")
   @NotNull(message = "采购单id不能为空")
   private Long orderId;
   @ApiModelProperty("项目经理id")
   @NotNull(message = "项目经理id不能为空")
   private Long projectManagerId;
   @ApiModelProperty("项目id")
   @NotNull(message = "项目id不能为空")
   private Long projectId;
   @ApiModelProperty("供应商id")
   @NotNull(message = "供应商id不能为空")
   private Long supplierId;
   @ApiModelProperty("采购合同号")
   @NotBlank(message = "采购合同号不能为空")
   private String purchaseContractNumber;
   @ApiModelProperty("本次发票额")
   @NotNull(message = "本次发票额不能为空")
   @DecimalMin(value = "0.01", message = "本次发票额不能小于0")
   private BigDecimal invoiceAmount;
   @ApiModelProperty("发票编号")
   @NotBlank(message = "发票编号不能为空")
   @Size(max = 50, message = "发票编号不能超过50个字符")
   private String invoiceSerialNumber;
   @ApiModelProperty("备注")
   @Size(max = 1024, message = "附件id不能超过1024个字符")
   private String remark;
   @ApiModelProperty("附件id")
   private Long attachmentId;

   public static SupplierInvoiceAddDTOParam.SupplierInvoiceAddDTOParamBuilder builder() {
      return new SupplierInvoiceAddDTOParam.SupplierInvoiceAddDTOParamBuilder();
   }

   public SupplierInvoiceAddDTOParam() {
   }

   public SupplierInvoiceAddDTOParam(
      final LocalDateTime invoiceDate,
      final Long orderId,
      final Long projectManagerId,
      final Long projectId,
      final Long supplierId,
      final String purchaseContractNumber,
      final BigDecimal invoiceAmount,
      final String invoiceSerialNumber,
      final String remark,
      final Long attachmentId
   ) {
      this.invoiceDate = invoiceDate;
      this.orderId = orderId;
      this.projectManagerId = projectManagerId;
      this.projectId = projectId;
      this.supplierId = supplierId;
      this.purchaseContractNumber = purchaseContractNumber;
      this.invoiceAmount = invoiceAmount;
      this.invoiceSerialNumber = invoiceSerialNumber;
      this.remark = remark;
      this.attachmentId = attachmentId;
   }

   public LocalDateTime getInvoiceDate() {
      return this.invoiceDate;
   }

   public Long getOrderId() {
      return this.orderId;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getPurchaseContractNumber() {
      return this.purchaseContractNumber;
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

   public Long getAttachmentId() {
      return this.attachmentId;
   }

   public void setInvoiceDate(final LocalDateTime invoiceDate) {
      this.invoiceDate = invoiceDate;
   }

   public void setOrderId(final Long orderId) {
      this.orderId = orderId;
   }

   public void setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setPurchaseContractNumber(final String purchaseContractNumber) {
      this.purchaseContractNumber = purchaseContractNumber;
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

   public void setAttachmentId(final Long attachmentId) {
      this.attachmentId = attachmentId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierInvoiceAddDTOParam)) {
         return false;
      }

      SupplierInvoiceAddDTOParam other = (SupplierInvoiceAddDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderId = this.getOrderId();
      Object other$orderId = other.getOrderId();
      if (this$orderId == null ? other$orderId == null : this$orderId.equals(other$orderId)) {
         Object this$projectManagerId = this.getProjectManagerId();
         Object other$projectManagerId = other.getProjectManagerId();
         if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$supplierId = this.getSupplierId();
               Object other$supplierId = other.getSupplierId();
               if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                  Object this$attachmentId = this.getAttachmentId();
                  Object other$attachmentId = other.getAttachmentId();
                  if (this$attachmentId == null ? other$attachmentId == null : this$attachmentId.equals(other$attachmentId)) {
                     Object this$invoiceDate = this.getInvoiceDate();
                     Object other$invoiceDate = other.getInvoiceDate();
                     if (this$invoiceDate == null ? other$invoiceDate == null : this$invoiceDate.equals(other$invoiceDate)) {
                        Object this$purchaseContractNumber = this.getPurchaseContractNumber();
                        Object other$purchaseContractNumber = other.getPurchaseContractNumber();
                        if (this$purchaseContractNumber == null
                           ? other$purchaseContractNumber == null
                           : this$purchaseContractNumber.equals(other$purchaseContractNumber)) {
                           Object this$invoiceAmount = this.getInvoiceAmount();
                           Object other$invoiceAmount = other.getInvoiceAmount();
                           if (this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount)) {
                              Object this$invoiceSerialNumber = this.getInvoiceSerialNumber();
                              Object other$invoiceSerialNumber = other.getInvoiceSerialNumber();
                              if (this$invoiceSerialNumber == null
                                 ? other$invoiceSerialNumber == null
                                 : this$invoiceSerialNumber.equals(other$invoiceSerialNumber)) {
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
      return other instanceof SupplierInvoiceAddDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $attachmentId = this.getAttachmentId();
      result = result * 59 + ($attachmentId == null ? 43 : $attachmentId.hashCode());
      Object $invoiceDate = this.getInvoiceDate();
      result = result * 59 + ($invoiceDate == null ? 43 : $invoiceDate.hashCode());
      Object $purchaseContractNumber = this.getPurchaseContractNumber();
      result = result * 59 + ($purchaseContractNumber == null ? 43 : $purchaseContractNumber.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $invoiceSerialNumber = this.getInvoiceSerialNumber();
      result = result * 59 + ($invoiceSerialNumber == null ? 43 : $invoiceSerialNumber.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierInvoiceAddDTOParam(invoiceDate="
         + this.getInvoiceDate()
         + ", orderId="
         + this.getOrderId()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", projectId="
         + this.getProjectId()
         + ", supplierId="
         + this.getSupplierId()
         + ", purchaseContractNumber="
         + this.getPurchaseContractNumber()
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

   public static class SupplierInvoiceAddDTOParamBuilder {
      private LocalDateTime invoiceDate;
      private Long orderId;
      private Long projectManagerId;
      private Long projectId;
      private Long supplierId;
      private String purchaseContractNumber;
      private BigDecimal invoiceAmount;
      private String invoiceSerialNumber;
      private String remark;
      private Long attachmentId;

      SupplierInvoiceAddDTOParamBuilder() {
      }

      public SupplierInvoiceAddDTOParam.SupplierInvoiceAddDTOParamBuilder invoiceDate(final LocalDateTime invoiceDate) {
         this.invoiceDate = invoiceDate;
         return this;
      }

      public SupplierInvoiceAddDTOParam.SupplierInvoiceAddDTOParamBuilder orderId(final Long orderId) {
         this.orderId = orderId;
         return this;
      }

      public SupplierInvoiceAddDTOParam.SupplierInvoiceAddDTOParamBuilder projectManagerId(final Long projectManagerId) {
         this.projectManagerId = projectManagerId;
         return this;
      }

      public SupplierInvoiceAddDTOParam.SupplierInvoiceAddDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public SupplierInvoiceAddDTOParam.SupplierInvoiceAddDTOParamBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public SupplierInvoiceAddDTOParam.SupplierInvoiceAddDTOParamBuilder purchaseContractNumber(final String purchaseContractNumber) {
         this.purchaseContractNumber = purchaseContractNumber;
         return this;
      }

      public SupplierInvoiceAddDTOParam.SupplierInvoiceAddDTOParamBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public SupplierInvoiceAddDTOParam.SupplierInvoiceAddDTOParamBuilder invoiceSerialNumber(final String invoiceSerialNumber) {
         this.invoiceSerialNumber = invoiceSerialNumber;
         return this;
      }

      public SupplierInvoiceAddDTOParam.SupplierInvoiceAddDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public SupplierInvoiceAddDTOParam.SupplierInvoiceAddDTOParamBuilder attachmentId(final Long attachmentId) {
         this.attachmentId = attachmentId;
         return this;
      }

      public SupplierInvoiceAddDTOParam build() {
         return new SupplierInvoiceAddDTOParam(
            this.invoiceDate,
            this.orderId,
            this.projectManagerId,
            this.projectId,
            this.supplierId,
            this.purchaseContractNumber,
            this.invoiceAmount,
            this.invoiceSerialNumber,
            this.remark,
            this.attachmentId
         );
      }

      @Override
      public String toString() {
         return "SupplierInvoiceAddDTOParam.SupplierInvoiceAddDTOParamBuilder(invoiceDate="
            + this.invoiceDate
            + ", orderId="
            + this.orderId
            + ", projectManagerId="
            + this.projectManagerId
            + ", projectId="
            + this.projectId
            + ", supplierId="
            + this.supplierId
            + ", purchaseContractNumber="
            + this.purchaseContractNumber
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
