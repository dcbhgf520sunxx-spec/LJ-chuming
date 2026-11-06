package com.hzchum.scim.contract.core.api.pojo.dto.supplier;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ProjectPaymentAllDTO {
   @ApiModelProperty("付款id")
   private Long id;
   @ApiModelProperty("付款日期")
   private LocalDateTime paymentTime;
   @ApiModelProperty("供应商")
   private SupplierInfo supplier;
   @ApiModelProperty("采购合同号")
   private String contractNumber;
   @ApiModelProperty("凭证号")
   private String voucherNumber;
   @ApiModelProperty("审批编号")
   private String approvalNumber;
   @ApiModelProperty("付款金额")
   private BigDecimal paymentAmount;
   @ApiModelProperty("创建人")
   private NameInfo user;
   @ApiModelProperty("附件")
   private List<AttachmentDTO> attachment;

   public static ProjectPaymentAllDTO.ProjectPaymentAllDTOBuilder builder() {
      return new ProjectPaymentAllDTO.ProjectPaymentAllDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getPaymentTime() {
      return this.paymentTime;
   }

   public SupplierInfo getSupplier() {
      return this.supplier;
   }

   public String getContractNumber() {
      return this.contractNumber;
   }

   public String getVoucherNumber() {
      return this.voucherNumber;
   }

   public String getApprovalNumber() {
      return this.approvalNumber;
   }

   public BigDecimal getPaymentAmount() {
      return this.paymentAmount;
   }

   public NameInfo getUser() {
      return this.user;
   }

   public List<AttachmentDTO> getAttachment() {
      return this.attachment;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPaymentTime(final LocalDateTime paymentTime) {
      this.paymentTime = paymentTime;
   }

   public void setSupplier(final SupplierInfo supplier) {
      this.supplier = supplier;
   }

   public void setContractNumber(final String contractNumber) {
      this.contractNumber = contractNumber;
   }

   public void setVoucherNumber(final String voucherNumber) {
      this.voucherNumber = voucherNumber;
   }

   public void setApprovalNumber(final String approvalNumber) {
      this.approvalNumber = approvalNumber;
   }

   public void setPaymentAmount(final BigDecimal paymentAmount) {
      this.paymentAmount = paymentAmount;
   }

   public void setUser(final NameInfo user) {
      this.user = user;
   }

   public void setAttachment(final List<AttachmentDTO> attachment) {
      this.attachment = attachment;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectPaymentAllDTO)) {
         return false;
      }

      ProjectPaymentAllDTO other = (ProjectPaymentAllDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$paymentTime = this.getPaymentTime();
         Object other$paymentTime = other.getPaymentTime();
         if (this$paymentTime == null ? other$paymentTime == null : this$paymentTime.equals(other$paymentTime)) {
            Object this$supplier = this.getSupplier();
            Object other$supplier = other.getSupplier();
            if (this$supplier == null ? other$supplier == null : this$supplier.equals(other$supplier)) {
               Object this$contractNumber = this.getContractNumber();
               Object other$contractNumber = other.getContractNumber();
               if (this$contractNumber == null ? other$contractNumber == null : this$contractNumber.equals(other$contractNumber)) {
                  Object this$voucherNumber = this.getVoucherNumber();
                  Object other$voucherNumber = other.getVoucherNumber();
                  if (this$voucherNumber == null ? other$voucherNumber == null : this$voucherNumber.equals(other$voucherNumber)) {
                     Object this$approvalNumber = this.getApprovalNumber();
                     Object other$approvalNumber = other.getApprovalNumber();
                     if (this$approvalNumber == null ? other$approvalNumber == null : this$approvalNumber.equals(other$approvalNumber)) {
                        Object this$paymentAmount = this.getPaymentAmount();
                        Object other$paymentAmount = other.getPaymentAmount();
                        if (this$paymentAmount == null ? other$paymentAmount == null : this$paymentAmount.equals(other$paymentAmount)) {
                           Object this$user = this.getUser();
                           Object other$user = other.getUser();
                           if (this$user == null ? other$user == null : this$user.equals(other$user)) {
                              Object this$attachment = this.getAttachment();
                              Object other$attachment = other.getAttachment();
                              return this$attachment == null ? other$attachment == null : this$attachment.equals(other$attachment);
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
      return other instanceof ProjectPaymentAllDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $paymentTime = this.getPaymentTime();
      result = result * 59 + ($paymentTime == null ? 43 : $paymentTime.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $contractNumber = this.getContractNumber();
      result = result * 59 + ($contractNumber == null ? 43 : $contractNumber.hashCode());
      Object $voucherNumber = this.getVoucherNumber();
      result = result * 59 + ($voucherNumber == null ? 43 : $voucherNumber.hashCode());
      Object $approvalNumber = this.getApprovalNumber();
      result = result * 59 + ($approvalNumber == null ? 43 : $approvalNumber.hashCode());
      Object $paymentAmount = this.getPaymentAmount();
      result = result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
      Object $user = this.getUser();
      result = result * 59 + ($user == null ? 43 : $user.hashCode());
      Object $attachment = this.getAttachment();
      return result * 59 + ($attachment == null ? 43 : $attachment.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectPaymentAllDTO(id="
         + this.getId()
         + ", paymentTime="
         + this.getPaymentTime()
         + ", supplier="
         + this.getSupplier()
         + ", contractNumber="
         + this.getContractNumber()
         + ", voucherNumber="
         + this.getVoucherNumber()
         + ", approvalNumber="
         + this.getApprovalNumber()
         + ", paymentAmount="
         + this.getPaymentAmount()
         + ", user="
         + this.getUser()
         + ", attachment="
         + this.getAttachment()
         + ")";
   }

   public ProjectPaymentAllDTO(
      final Long id,
      final LocalDateTime paymentTime,
      final SupplierInfo supplier,
      final String contractNumber,
      final String voucherNumber,
      final String approvalNumber,
      final BigDecimal paymentAmount,
      final NameInfo user,
      final List<AttachmentDTO> attachment
   ) {
      this.id = id;
      this.paymentTime = paymentTime;
      this.supplier = supplier;
      this.contractNumber = contractNumber;
      this.voucherNumber = voucherNumber;
      this.approvalNumber = approvalNumber;
      this.paymentAmount = paymentAmount;
      this.user = user;
      this.attachment = attachment;
   }

   public ProjectPaymentAllDTO() {
   }

   public static class ProjectPaymentAllDTOBuilder {
      private Long id;
      private LocalDateTime paymentTime;
      private SupplierInfo supplier;
      private String contractNumber;
      private String voucherNumber;
      private String approvalNumber;
      private BigDecimal paymentAmount;
      private NameInfo user;
      private List<AttachmentDTO> attachment;

      ProjectPaymentAllDTOBuilder() {
      }

      public ProjectPaymentAllDTO.ProjectPaymentAllDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectPaymentAllDTO.ProjectPaymentAllDTOBuilder paymentTime(final LocalDateTime paymentTime) {
         this.paymentTime = paymentTime;
         return this;
      }

      public ProjectPaymentAllDTO.ProjectPaymentAllDTOBuilder supplier(final SupplierInfo supplier) {
         this.supplier = supplier;
         return this;
      }

      public ProjectPaymentAllDTO.ProjectPaymentAllDTOBuilder contractNumber(final String contractNumber) {
         this.contractNumber = contractNumber;
         return this;
      }

      public ProjectPaymentAllDTO.ProjectPaymentAllDTOBuilder voucherNumber(final String voucherNumber) {
         this.voucherNumber = voucherNumber;
         return this;
      }

      public ProjectPaymentAllDTO.ProjectPaymentAllDTOBuilder approvalNumber(final String approvalNumber) {
         this.approvalNumber = approvalNumber;
         return this;
      }

      public ProjectPaymentAllDTO.ProjectPaymentAllDTOBuilder paymentAmount(final BigDecimal paymentAmount) {
         this.paymentAmount = paymentAmount;
         return this;
      }

      public ProjectPaymentAllDTO.ProjectPaymentAllDTOBuilder user(final NameInfo user) {
         this.user = user;
         return this;
      }

      public ProjectPaymentAllDTO.ProjectPaymentAllDTOBuilder attachment(final List<AttachmentDTO> attachment) {
         this.attachment = attachment;
         return this;
      }

      public ProjectPaymentAllDTO build() {
         return new ProjectPaymentAllDTO(
            this.id,
            this.paymentTime,
            this.supplier,
            this.contractNumber,
            this.voucherNumber,
            this.approvalNumber,
            this.paymentAmount,
            this.user,
            this.attachment
         );
      }

      @Override
      public String toString() {
         return "ProjectPaymentAllDTO.ProjectPaymentAllDTOBuilder(id="
            + this.id
            + ", paymentTime="
            + this.paymentTime
            + ", supplier="
            + this.supplier
            + ", contractNumber="
            + this.contractNumber
            + ", voucherNumber="
            + this.voucherNumber
            + ", approvalNumber="
            + this.approvalNumber
            + ", paymentAmount="
            + this.paymentAmount
            + ", user="
            + this.user
            + ", attachment="
            + this.attachment
            + ")";
      }
   }
}
