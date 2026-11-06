package com.hzchum.scim.scm.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class SupplierInvoiceDetailDto {
   @ApiModelProperty(name = "收票日期")
   private LocalDateTime invoiceDate;
   @ApiModelProperty(name = "发票类型")
   private Integer invoiceType;
   @ApiModelProperty(name = "发票金额")
   private BigDecimal invoiceAmount;
   @ApiModelProperty("税率")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "收票单位")
   private NameInfo invoiceSignBody;
   @ApiModelProperty(name = "发票编号")
   private String invoiceNumber;
   @ApiModelProperty("供应商id")
   private Long supplierId;
   @ApiModelProperty("供应商名称")
   private String supplierName;
   @ApiModelProperty(name = "办理人")
   private NameInfo paymentPerson;
   @ApiModelProperty(name = "审核人")
   private NameInfo auditUser;
   @ApiModelProperty(name = "附件")
   private AttachmentDTO attachment;
   @ApiModelProperty(name = "附件列表")
   private List<AttachmentDTO> attachmentList;
   @ApiModelProperty(name = "附件列表")
   private List<AttachmentDTO> attachments;

   public static SupplierInvoiceDetailDto.SupplierInvoiceDetailDtoBuilder builder() {
      return new SupplierInvoiceDetailDto.SupplierInvoiceDetailDtoBuilder();
   }

   public LocalDateTime getInvoiceDate() {
      return this.invoiceDate;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public NameInfo getInvoiceSignBody() {
      return this.invoiceSignBody;
   }

   public String getInvoiceNumber() {
      return this.invoiceNumber;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public NameInfo getPaymentPerson() {
      return this.paymentPerson;
   }

   public NameInfo getAuditUser() {
      return this.auditUser;
   }

   public AttachmentDTO getAttachment() {
      return this.attachment;
   }

   public List<AttachmentDTO> getAttachmentList() {
      return this.attachmentList;
   }

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public void setInvoiceDate(final LocalDateTime invoiceDate) {
      this.invoiceDate = invoiceDate;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setInvoiceSignBody(final NameInfo invoiceSignBody) {
      this.invoiceSignBody = invoiceSignBody;
   }

   public void setInvoiceNumber(final String invoiceNumber) {
      this.invoiceNumber = invoiceNumber;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setPaymentPerson(final NameInfo paymentPerson) {
      this.paymentPerson = paymentPerson;
   }

   public void setAuditUser(final NameInfo auditUser) {
      this.auditUser = auditUser;
   }

   public void setAttachment(final AttachmentDTO attachment) {
      this.attachment = attachment;
   }

   public void setAttachmentList(final List<AttachmentDTO> attachmentList) {
      this.attachmentList = attachmentList;
   }

   public void setAttachments(final List<AttachmentDTO> attachments) {
      this.attachments = attachments;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierInvoiceDetailDto)) {
         return false;
      }

      SupplierInvoiceDetailDto other = (SupplierInvoiceDetailDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$invoiceType = this.getInvoiceType();
      Object other$invoiceType = other.getInvoiceType();
      if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$invoiceDate = this.getInvoiceDate();
            Object other$invoiceDate = other.getInvoiceDate();
            if (this$invoiceDate == null ? other$invoiceDate == null : this$invoiceDate.equals(other$invoiceDate)) {
               Object this$invoiceAmount = this.getInvoiceAmount();
               Object other$invoiceAmount = other.getInvoiceAmount();
               if (this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount)) {
                  Object this$taxRate = this.getTaxRate();
                  Object other$taxRate = other.getTaxRate();
                  if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                     Object this$invoiceSignBody = this.getInvoiceSignBody();
                     Object other$invoiceSignBody = other.getInvoiceSignBody();
                     if (this$invoiceSignBody == null ? other$invoiceSignBody == null : this$invoiceSignBody.equals(other$invoiceSignBody)) {
                        Object this$invoiceNumber = this.getInvoiceNumber();
                        Object other$invoiceNumber = other.getInvoiceNumber();
                        if (this$invoiceNumber == null ? other$invoiceNumber == null : this$invoiceNumber.equals(other$invoiceNumber)) {
                           Object this$supplierName = this.getSupplierName();
                           Object other$supplierName = other.getSupplierName();
                           if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                              Object this$paymentPerson = this.getPaymentPerson();
                              Object other$paymentPerson = other.getPaymentPerson();
                              if (this$paymentPerson == null ? other$paymentPerson == null : this$paymentPerson.equals(other$paymentPerson)) {
                                 Object this$auditUser = this.getAuditUser();
                                 Object other$auditUser = other.getAuditUser();
                                 if (this$auditUser == null ? other$auditUser == null : this$auditUser.equals(other$auditUser)) {
                                    Object this$attachment = this.getAttachment();
                                    Object other$attachment = other.getAttachment();
                                    if (this$attachment == null ? other$attachment == null : this$attachment.equals(other$attachment)) {
                                       Object this$attachmentList = this.getAttachmentList();
                                       Object other$attachmentList = other.getAttachmentList();
                                       if (this$attachmentList == null ? other$attachmentList == null : this$attachmentList.equals(other$attachmentList)) {
                                          Object this$attachments = this.getAttachments();
                                          Object other$attachments = other.getAttachments();
                                          return this$attachments == null ? other$attachments == null : this$attachments.equals(other$attachments);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SupplierInvoiceDetailDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $invoiceDate = this.getInvoiceDate();
      result = result * 59 + ($invoiceDate == null ? 43 : $invoiceDate.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $invoiceSignBody = this.getInvoiceSignBody();
      result = result * 59 + ($invoiceSignBody == null ? 43 : $invoiceSignBody.hashCode());
      Object $invoiceNumber = this.getInvoiceNumber();
      result = result * 59 + ($invoiceNumber == null ? 43 : $invoiceNumber.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $paymentPerson = this.getPaymentPerson();
      result = result * 59 + ($paymentPerson == null ? 43 : $paymentPerson.hashCode());
      Object $auditUser = this.getAuditUser();
      result = result * 59 + ($auditUser == null ? 43 : $auditUser.hashCode());
      Object $attachment = this.getAttachment();
      result = result * 59 + ($attachment == null ? 43 : $attachment.hashCode());
      Object $attachmentList = this.getAttachmentList();
      result = result * 59 + ($attachmentList == null ? 43 : $attachmentList.hashCode());
      Object $attachments = this.getAttachments();
      return result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierInvoiceDetailDto(invoiceDate="
         + this.getInvoiceDate()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", taxRate="
         + this.getTaxRate()
         + ", invoiceSignBody="
         + this.getInvoiceSignBody()
         + ", invoiceNumber="
         + this.getInvoiceNumber()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", paymentPerson="
         + this.getPaymentPerson()
         + ", auditUser="
         + this.getAuditUser()
         + ", attachment="
         + this.getAttachment()
         + ", attachmentList="
         + this.getAttachmentList()
         + ", attachments="
         + this.getAttachments()
         + ")";
   }

   public SupplierInvoiceDetailDto(
      final LocalDateTime invoiceDate,
      final Integer invoiceType,
      final BigDecimal invoiceAmount,
      final BigDecimal taxRate,
      final NameInfo invoiceSignBody,
      final String invoiceNumber,
      final Long supplierId,
      final String supplierName,
      final NameInfo paymentPerson,
      final NameInfo auditUser,
      final AttachmentDTO attachment,
      final List<AttachmentDTO> attachmentList,
      final List<AttachmentDTO> attachments
   ) {
      this.invoiceDate = invoiceDate;
      this.invoiceType = invoiceType;
      this.invoiceAmount = invoiceAmount;
      this.taxRate = taxRate;
      this.invoiceSignBody = invoiceSignBody;
      this.invoiceNumber = invoiceNumber;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.paymentPerson = paymentPerson;
      this.auditUser = auditUser;
      this.attachment = attachment;
      this.attachmentList = attachmentList;
      this.attachments = attachments;
   }

   public SupplierInvoiceDetailDto() {
   }

   public static class SupplierInvoiceDetailDtoBuilder {
      private LocalDateTime invoiceDate;
      private Integer invoiceType;
      private BigDecimal invoiceAmount;
      private BigDecimal taxRate;
      private NameInfo invoiceSignBody;
      private String invoiceNumber;
      private Long supplierId;
      private String supplierName;
      private NameInfo paymentPerson;
      private NameInfo auditUser;
      private AttachmentDTO attachment;
      private List<AttachmentDTO> attachmentList;
      private List<AttachmentDTO> attachments;

      SupplierInvoiceDetailDtoBuilder() {
      }

      public SupplierInvoiceDetailDto.SupplierInvoiceDetailDtoBuilder invoiceDate(final LocalDateTime invoiceDate) {
         this.invoiceDate = invoiceDate;
         return this;
      }

      public SupplierInvoiceDetailDto.SupplierInvoiceDetailDtoBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public SupplierInvoiceDetailDto.SupplierInvoiceDetailDtoBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public SupplierInvoiceDetailDto.SupplierInvoiceDetailDtoBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public SupplierInvoiceDetailDto.SupplierInvoiceDetailDtoBuilder invoiceSignBody(final NameInfo invoiceSignBody) {
         this.invoiceSignBody = invoiceSignBody;
         return this;
      }

      public SupplierInvoiceDetailDto.SupplierInvoiceDetailDtoBuilder invoiceNumber(final String invoiceNumber) {
         this.invoiceNumber = invoiceNumber;
         return this;
      }

      public SupplierInvoiceDetailDto.SupplierInvoiceDetailDtoBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public SupplierInvoiceDetailDto.SupplierInvoiceDetailDtoBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public SupplierInvoiceDetailDto.SupplierInvoiceDetailDtoBuilder paymentPerson(final NameInfo paymentPerson) {
         this.paymentPerson = paymentPerson;
         return this;
      }

      public SupplierInvoiceDetailDto.SupplierInvoiceDetailDtoBuilder auditUser(final NameInfo auditUser) {
         this.auditUser = auditUser;
         return this;
      }

      public SupplierInvoiceDetailDto.SupplierInvoiceDetailDtoBuilder attachment(final AttachmentDTO attachment) {
         this.attachment = attachment;
         return this;
      }

      public SupplierInvoiceDetailDto.SupplierInvoiceDetailDtoBuilder attachmentList(final List<AttachmentDTO> attachmentList) {
         this.attachmentList = attachmentList;
         return this;
      }

      public SupplierInvoiceDetailDto.SupplierInvoiceDetailDtoBuilder attachments(final List<AttachmentDTO> attachments) {
         this.attachments = attachments;
         return this;
      }

      public SupplierInvoiceDetailDto build() {
         return new SupplierInvoiceDetailDto(
            this.invoiceDate,
            this.invoiceType,
            this.invoiceAmount,
            this.taxRate,
            this.invoiceSignBody,
            this.invoiceNumber,
            this.supplierId,
            this.supplierName,
            this.paymentPerson,
            this.auditUser,
            this.attachment,
            this.attachmentList,
            this.attachments
         );
      }

      @Override
      public String toString() {
         return "SupplierInvoiceDetailDto.SupplierInvoiceDetailDtoBuilder(invoiceDate="
            + this.invoiceDate
            + ", invoiceType="
            + this.invoiceType
            + ", invoiceAmount="
            + this.invoiceAmount
            + ", taxRate="
            + this.taxRate
            + ", invoiceSignBody="
            + this.invoiceSignBody
            + ", invoiceNumber="
            + this.invoiceNumber
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", paymentPerson="
            + this.paymentPerson
            + ", auditUser="
            + this.auditUser
            + ", attachment="
            + this.attachment
            + ", attachmentList="
            + this.attachmentList
            + ", attachments="
            + this.attachments
            + ")";
      }
   }
}
