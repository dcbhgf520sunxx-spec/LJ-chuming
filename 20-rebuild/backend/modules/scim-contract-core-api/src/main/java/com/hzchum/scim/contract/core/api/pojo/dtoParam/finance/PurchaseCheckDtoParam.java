package com.hzchum.scim.contract.core.api.pojo.dtoParam.finance;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("审核付款接收类")
public class PurchaseCheckDtoParam {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   private Long id;
   @NotBlank(message = "实付金额不能为空")
   @DecimalMin(value = "0", message = "实付金额不能小于0")
   @ApiModelProperty(name = "paymentAmount", value = "实付金额", notes = "实付金额")
   private BigDecimal paymentAmount;
   @NotNull(message = "付款日期不能为空")
   @ApiModelProperty(name = "paymentDate", value = "付款日期", notes = "付款日期")
   private LocalDateTime paymentDate;
   @NotNull(message = "付款方式不能为空")
   @ApiModelProperty(name = "paymentType", value = "付款方式", notes = "付款方式")
   private Integer paymentType;
   @NotNull(message = "凭证号不能为空")
   @ApiModelProperty(name = "voucherNumber", value = "凭证号", notes = "凭证号")
   private String voucherNumber;
   @ApiModelProperty(name = "attachments", value = "项目的附件id数组")
   private List<Long> attachments;
   @ApiModelProperty(name = "attachments", value = "附件信息")
   private List<AttachmentDTO> AttachmentDTOList;

   public static PurchaseCheckDtoParam.PurchaseCheckDtoParamBuilder builder() {
      return new PurchaseCheckDtoParam.PurchaseCheckDtoParamBuilder();
   }

   public PurchaseCheckDtoParam() {
   }

   public PurchaseCheckDtoParam(
      final Long id,
      final BigDecimal paymentAmount,
      final LocalDateTime paymentDate,
      final Integer paymentType,
      final String voucherNumber,
      final List<Long> attachments,
      final List<AttachmentDTO> AttachmentDTOList
   ) {
      this.id = id;
      this.paymentAmount = paymentAmount;
      this.paymentDate = paymentDate;
      this.paymentType = paymentType;
      this.voucherNumber = voucherNumber;
      this.attachments = attachments;
      this.AttachmentDTOList = AttachmentDTOList;
   }

   public Long getId() {
      return this.id;
   }

   public BigDecimal getPaymentAmount() {
      return this.paymentAmount;
   }

   public LocalDateTime getPaymentDate() {
      return this.paymentDate;
   }

   public Integer getPaymentType() {
      return this.paymentType;
   }

   public String getVoucherNumber() {
      return this.voucherNumber;
   }

   public List<Long> getAttachments() {
      return this.attachments;
   }

   public List<AttachmentDTO> getAttachmentDTOList() {
      return this.AttachmentDTOList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPaymentAmount(final BigDecimal paymentAmount) {
      this.paymentAmount = paymentAmount;
   }

   public void setPaymentDate(final LocalDateTime paymentDate) {
      this.paymentDate = paymentDate;
   }

   public void setPaymentType(final Integer paymentType) {
      this.paymentType = paymentType;
   }

   public void setVoucherNumber(final String voucherNumber) {
      this.voucherNumber = voucherNumber;
   }

   public void setAttachments(final List<Long> attachments) {
      this.attachments = attachments;
   }

   public void setAttachmentDTOList(final List<AttachmentDTO> AttachmentDTOList) {
      this.AttachmentDTOList = AttachmentDTOList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PurchaseCheckDtoParam)) {
         return false;
      }

      PurchaseCheckDtoParam other = (PurchaseCheckDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$paymentType = this.getPaymentType();
         Object other$paymentType = other.getPaymentType();
         if (this$paymentType == null ? other$paymentType == null : this$paymentType.equals(other$paymentType)) {
            Object this$paymentAmount = this.getPaymentAmount();
            Object other$paymentAmount = other.getPaymentAmount();
            if (this$paymentAmount == null ? other$paymentAmount == null : this$paymentAmount.equals(other$paymentAmount)) {
               Object this$paymentDate = this.getPaymentDate();
               Object other$paymentDate = other.getPaymentDate();
               if (this$paymentDate == null ? other$paymentDate == null : this$paymentDate.equals(other$paymentDate)) {
                  Object this$voucherNumber = this.getVoucherNumber();
                  Object other$voucherNumber = other.getVoucherNumber();
                  if (this$voucherNumber == null ? other$voucherNumber == null : this$voucherNumber.equals(other$voucherNumber)) {
                     Object this$attachments = this.getAttachments();
                     Object other$attachments = other.getAttachments();
                     if (this$attachments == null ? other$attachments == null : this$attachments.equals(other$attachments)) {
                        Object this$AttachmentDTOList = this.getAttachmentDTOList();
                        Object other$AttachmentDTOList = other.getAttachmentDTOList();
                        return this$AttachmentDTOList == null ? other$AttachmentDTOList == null : this$AttachmentDTOList.equals(other$AttachmentDTOList);
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
      return other instanceof PurchaseCheckDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $paymentType = this.getPaymentType();
      result = result * 59 + ($paymentType == null ? 43 : $paymentType.hashCode());
      Object $paymentAmount = this.getPaymentAmount();
      result = result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
      Object $paymentDate = this.getPaymentDate();
      result = result * 59 + ($paymentDate == null ? 43 : $paymentDate.hashCode());
      Object $voucherNumber = this.getVoucherNumber();
      result = result * 59 + ($voucherNumber == null ? 43 : $voucherNumber.hashCode());
      Object $attachments = this.getAttachments();
      result = result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
      Object $AttachmentDTOList = this.getAttachmentDTOList();
      return result * 59 + ($AttachmentDTOList == null ? 43 : $AttachmentDTOList.hashCode());
   }

   @Override
   public String toString() {
      return "PurchaseCheckDtoParam(id="
         + this.getId()
         + ", paymentAmount="
         + this.getPaymentAmount()
         + ", paymentDate="
         + this.getPaymentDate()
         + ", paymentType="
         + this.getPaymentType()
         + ", voucherNumber="
         + this.getVoucherNumber()
         + ", attachments="
         + this.getAttachments()
         + ", AttachmentDTOList="
         + this.getAttachmentDTOList()
         + ")";
   }

   public static class PurchaseCheckDtoParamBuilder {
      private Long id;
      private BigDecimal paymentAmount;
      private LocalDateTime paymentDate;
      private Integer paymentType;
      private String voucherNumber;
      private List<Long> attachments;
      private List<AttachmentDTO> AttachmentDTOList;

      PurchaseCheckDtoParamBuilder() {
      }

      public PurchaseCheckDtoParam.PurchaseCheckDtoParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public PurchaseCheckDtoParam.PurchaseCheckDtoParamBuilder paymentAmount(final BigDecimal paymentAmount) {
         this.paymentAmount = paymentAmount;
         return this;
      }

      public PurchaseCheckDtoParam.PurchaseCheckDtoParamBuilder paymentDate(final LocalDateTime paymentDate) {
         this.paymentDate = paymentDate;
         return this;
      }

      public PurchaseCheckDtoParam.PurchaseCheckDtoParamBuilder paymentType(final Integer paymentType) {
         this.paymentType = paymentType;
         return this;
      }

      public PurchaseCheckDtoParam.PurchaseCheckDtoParamBuilder voucherNumber(final String voucherNumber) {
         this.voucherNumber = voucherNumber;
         return this;
      }

      public PurchaseCheckDtoParam.PurchaseCheckDtoParamBuilder attachments(final List<Long> attachments) {
         this.attachments = attachments;
         return this;
      }

      public PurchaseCheckDtoParam.PurchaseCheckDtoParamBuilder AttachmentDTOList(final List<AttachmentDTO> AttachmentDTOList) {
         this.AttachmentDTOList = AttachmentDTOList;
         return this;
      }

      public PurchaseCheckDtoParam build() {
         return new PurchaseCheckDtoParam(
            this.id, this.paymentAmount, this.paymentDate, this.paymentType, this.voucherNumber, this.attachments, this.AttachmentDTOList
         );
      }

      @Override
      public String toString() {
         return "PurchaseCheckDtoParam.PurchaseCheckDtoParamBuilder(id="
            + this.id
            + ", paymentAmount="
            + this.paymentAmount
            + ", paymentDate="
            + this.paymentDate
            + ", paymentType="
            + this.paymentType
            + ", voucherNumber="
            + this.voucherNumber
            + ", attachments="
            + this.attachments
            + ", AttachmentDTOList="
            + this.AttachmentDTOList
            + ")";
      }
   }
}
