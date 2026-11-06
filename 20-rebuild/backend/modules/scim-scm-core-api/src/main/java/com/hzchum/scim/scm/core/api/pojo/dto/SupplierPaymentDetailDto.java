package com.hzchum.scim.scm.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class SupplierPaymentDetailDto {
   @ApiModelProperty(name = "付款日期")
   private LocalDateTime paymentDate;
   @ApiModelProperty(name = "付款类型")
   private Integer paymentType;
   @ApiModelProperty(name = "付款金额")
   private BigDecimal paymentAmount;
   @ApiModelProperty(name = "付款单位")
   private NameInfo contractSignBody;
   @ApiModelProperty(name = "付款银行")
   private String paymentBank;
   @ApiModelProperty("付款属性id")
   private Long paymentAttributeId;
   @ApiModelProperty("付款属性名称")
   private String paymentAttributeName;
   @ApiModelProperty("供应商id")
   private Long supplierId;
   @ApiModelProperty("供应商名称")
   private String supplierName;
   @ApiModelProperty(name = "办理人")
   private NameInfo paymentPerson;
   @ApiModelProperty(name = "审核人")
   private NameInfo auditUser;
   @ApiModelProperty(name = "附件列表")
   private List<AttachmentDTO> attachmentList;
   @ApiModelProperty(name = "附件列表")
   private List<AttachmentDTO> attachments;

   public static SupplierPaymentDetailDto.SupplierPaymentDetailDtoBuilder builder() {
      return new SupplierPaymentDetailDto.SupplierPaymentDetailDtoBuilder();
   }

   public LocalDateTime getPaymentDate() {
      return this.paymentDate;
   }

   public Integer getPaymentType() {
      return this.paymentType;
   }

   public BigDecimal getPaymentAmount() {
      return this.paymentAmount;
   }

   public NameInfo getContractSignBody() {
      return this.contractSignBody;
   }

   public String getPaymentBank() {
      return this.paymentBank;
   }

   public Long getPaymentAttributeId() {
      return this.paymentAttributeId;
   }

   public String getPaymentAttributeName() {
      return this.paymentAttributeName;
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

   public List<AttachmentDTO> getAttachmentList() {
      return this.attachmentList;
   }

   public List<AttachmentDTO> getAttachments() {
      return this.attachments;
   }

   public void setPaymentDate(final LocalDateTime paymentDate) {
      this.paymentDate = paymentDate;
   }

   public void setPaymentType(final Integer paymentType) {
      this.paymentType = paymentType;
   }

   public void setPaymentAmount(final BigDecimal paymentAmount) {
      this.paymentAmount = paymentAmount;
   }

   public void setContractSignBody(final NameInfo contractSignBody) {
      this.contractSignBody = contractSignBody;
   }

   public void setPaymentBank(final String paymentBank) {
      this.paymentBank = paymentBank;
   }

   public void setPaymentAttributeId(final Long paymentAttributeId) {
      this.paymentAttributeId = paymentAttributeId;
   }

   public void setPaymentAttributeName(final String paymentAttributeName) {
      this.paymentAttributeName = paymentAttributeName;
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

      if (!(o instanceof SupplierPaymentDetailDto)) {
         return false;
      }

      SupplierPaymentDetailDto other = (SupplierPaymentDetailDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$paymentType = this.getPaymentType();
      Object other$paymentType = other.getPaymentType();
      if (this$paymentType == null ? other$paymentType == null : this$paymentType.equals(other$paymentType)) {
         Object this$paymentAttributeId = this.getPaymentAttributeId();
         Object other$paymentAttributeId = other.getPaymentAttributeId();
         if (this$paymentAttributeId == null ? other$paymentAttributeId == null : this$paymentAttributeId.equals(other$paymentAttributeId)) {
            Object this$supplierId = this.getSupplierId();
            Object other$supplierId = other.getSupplierId();
            if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
               Object this$paymentDate = this.getPaymentDate();
               Object other$paymentDate = other.getPaymentDate();
               if (this$paymentDate == null ? other$paymentDate == null : this$paymentDate.equals(other$paymentDate)) {
                  Object this$paymentAmount = this.getPaymentAmount();
                  Object other$paymentAmount = other.getPaymentAmount();
                  if (this$paymentAmount == null ? other$paymentAmount == null : this$paymentAmount.equals(other$paymentAmount)) {
                     Object this$contractSignBody = this.getContractSignBody();
                     Object other$contractSignBody = other.getContractSignBody();
                     if (this$contractSignBody == null ? other$contractSignBody == null : this$contractSignBody.equals(other$contractSignBody)) {
                        Object this$paymentBank = this.getPaymentBank();
                        Object other$paymentBank = other.getPaymentBank();
                        if (this$paymentBank == null ? other$paymentBank == null : this$paymentBank.equals(other$paymentBank)) {
                           Object this$paymentAttributeName = this.getPaymentAttributeName();
                           Object other$paymentAttributeName = other.getPaymentAttributeName();
                           if (this$paymentAttributeName == null
                              ? other$paymentAttributeName == null
                              : this$paymentAttributeName.equals(other$paymentAttributeName)) {
                              Object this$supplierName = this.getSupplierName();
                              Object other$supplierName = other.getSupplierName();
                              if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                                 Object this$paymentPerson = this.getPaymentPerson();
                                 Object other$paymentPerson = other.getPaymentPerson();
                                 if (this$paymentPerson == null ? other$paymentPerson == null : this$paymentPerson.equals(other$paymentPerson)) {
                                    Object this$auditUser = this.getAuditUser();
                                    Object other$auditUser = other.getAuditUser();
                                    if (this$auditUser == null ? other$auditUser == null : this$auditUser.equals(other$auditUser)) {
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
      return other instanceof SupplierPaymentDetailDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $paymentType = this.getPaymentType();
      result = result * 59 + ($paymentType == null ? 43 : $paymentType.hashCode());
      Object $paymentAttributeId = this.getPaymentAttributeId();
      result = result * 59 + ($paymentAttributeId == null ? 43 : $paymentAttributeId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $paymentDate = this.getPaymentDate();
      result = result * 59 + ($paymentDate == null ? 43 : $paymentDate.hashCode());
      Object $paymentAmount = this.getPaymentAmount();
      result = result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
      Object $contractSignBody = this.getContractSignBody();
      result = result * 59 + ($contractSignBody == null ? 43 : $contractSignBody.hashCode());
      Object $paymentBank = this.getPaymentBank();
      result = result * 59 + ($paymentBank == null ? 43 : $paymentBank.hashCode());
      Object $paymentAttributeName = this.getPaymentAttributeName();
      result = result * 59 + ($paymentAttributeName == null ? 43 : $paymentAttributeName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $paymentPerson = this.getPaymentPerson();
      result = result * 59 + ($paymentPerson == null ? 43 : $paymentPerson.hashCode());
      Object $auditUser = this.getAuditUser();
      result = result * 59 + ($auditUser == null ? 43 : $auditUser.hashCode());
      Object $attachmentList = this.getAttachmentList();
      result = result * 59 + ($attachmentList == null ? 43 : $attachmentList.hashCode());
      Object $attachments = this.getAttachments();
      return result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierPaymentDetailDto(paymentDate="
         + this.getPaymentDate()
         + ", paymentType="
         + this.getPaymentType()
         + ", paymentAmount="
         + this.getPaymentAmount()
         + ", contractSignBody="
         + this.getContractSignBody()
         + ", paymentBank="
         + this.getPaymentBank()
         + ", paymentAttributeId="
         + this.getPaymentAttributeId()
         + ", paymentAttributeName="
         + this.getPaymentAttributeName()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", paymentPerson="
         + this.getPaymentPerson()
         + ", auditUser="
         + this.getAuditUser()
         + ", attachmentList="
         + this.getAttachmentList()
         + ", attachments="
         + this.getAttachments()
         + ")";
   }

   public SupplierPaymentDetailDto(
      final LocalDateTime paymentDate,
      final Integer paymentType,
      final BigDecimal paymentAmount,
      final NameInfo contractSignBody,
      final String paymentBank,
      final Long paymentAttributeId,
      final String paymentAttributeName,
      final Long supplierId,
      final String supplierName,
      final NameInfo paymentPerson,
      final NameInfo auditUser,
      final List<AttachmentDTO> attachmentList,
      final List<AttachmentDTO> attachments
   ) {
      this.paymentDate = paymentDate;
      this.paymentType = paymentType;
      this.paymentAmount = paymentAmount;
      this.contractSignBody = contractSignBody;
      this.paymentBank = paymentBank;
      this.paymentAttributeId = paymentAttributeId;
      this.paymentAttributeName = paymentAttributeName;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.paymentPerson = paymentPerson;
      this.auditUser = auditUser;
      this.attachmentList = attachmentList;
      this.attachments = attachments;
   }

   public SupplierPaymentDetailDto() {
   }

   public static class SupplierPaymentDetailDtoBuilder {
      private LocalDateTime paymentDate;
      private Integer paymentType;
      private BigDecimal paymentAmount;
      private NameInfo contractSignBody;
      private String paymentBank;
      private Long paymentAttributeId;
      private String paymentAttributeName;
      private Long supplierId;
      private String supplierName;
      private NameInfo paymentPerson;
      private NameInfo auditUser;
      private List<AttachmentDTO> attachmentList;
      private List<AttachmentDTO> attachments;

      SupplierPaymentDetailDtoBuilder() {
      }

      public SupplierPaymentDetailDto.SupplierPaymentDetailDtoBuilder paymentDate(final LocalDateTime paymentDate) {
         this.paymentDate = paymentDate;
         return this;
      }

      public SupplierPaymentDetailDto.SupplierPaymentDetailDtoBuilder paymentType(final Integer paymentType) {
         this.paymentType = paymentType;
         return this;
      }

      public SupplierPaymentDetailDto.SupplierPaymentDetailDtoBuilder paymentAmount(final BigDecimal paymentAmount) {
         this.paymentAmount = paymentAmount;
         return this;
      }

      public SupplierPaymentDetailDto.SupplierPaymentDetailDtoBuilder contractSignBody(final NameInfo contractSignBody) {
         this.contractSignBody = contractSignBody;
         return this;
      }

      public SupplierPaymentDetailDto.SupplierPaymentDetailDtoBuilder paymentBank(final String paymentBank) {
         this.paymentBank = paymentBank;
         return this;
      }

      public SupplierPaymentDetailDto.SupplierPaymentDetailDtoBuilder paymentAttributeId(final Long paymentAttributeId) {
         this.paymentAttributeId = paymentAttributeId;
         return this;
      }

      public SupplierPaymentDetailDto.SupplierPaymentDetailDtoBuilder paymentAttributeName(final String paymentAttributeName) {
         this.paymentAttributeName = paymentAttributeName;
         return this;
      }

      public SupplierPaymentDetailDto.SupplierPaymentDetailDtoBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public SupplierPaymentDetailDto.SupplierPaymentDetailDtoBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public SupplierPaymentDetailDto.SupplierPaymentDetailDtoBuilder paymentPerson(final NameInfo paymentPerson) {
         this.paymentPerson = paymentPerson;
         return this;
      }

      public SupplierPaymentDetailDto.SupplierPaymentDetailDtoBuilder auditUser(final NameInfo auditUser) {
         this.auditUser = auditUser;
         return this;
      }

      public SupplierPaymentDetailDto.SupplierPaymentDetailDtoBuilder attachmentList(final List<AttachmentDTO> attachmentList) {
         this.attachmentList = attachmentList;
         return this;
      }

      public SupplierPaymentDetailDto.SupplierPaymentDetailDtoBuilder attachments(final List<AttachmentDTO> attachments) {
         this.attachments = attachments;
         return this;
      }

      public SupplierPaymentDetailDto build() {
         return new SupplierPaymentDetailDto(
            this.paymentDate,
            this.paymentType,
            this.paymentAmount,
            this.contractSignBody,
            this.paymentBank,
            this.paymentAttributeId,
            this.paymentAttributeName,
            this.supplierId,
            this.supplierName,
            this.paymentPerson,
            this.auditUser,
            this.attachmentList,
            this.attachments
         );
      }

      @Override
      public String toString() {
         return "SupplierPaymentDetailDto.SupplierPaymentDetailDtoBuilder(paymentDate="
            + this.paymentDate
            + ", paymentType="
            + this.paymentType
            + ", paymentAmount="
            + this.paymentAmount
            + ", contractSignBody="
            + this.contractSignBody
            + ", paymentBank="
            + this.paymentBank
            + ", paymentAttributeId="
            + this.paymentAttributeId
            + ", paymentAttributeName="
            + this.paymentAttributeName
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", paymentPerson="
            + this.paymentPerson
            + ", auditUser="
            + this.auditUser
            + ", attachmentList="
            + this.attachmentList
            + ", attachments="
            + this.attachments
            + ")";
      }
   }
}
