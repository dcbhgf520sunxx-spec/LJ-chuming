package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;

public class AdjustDetailsDTO {
   private Long id;
   private LocalDateTime createTime;
   private String serialNumber;
   @ApiModelProperty(name = "Amount", value = "调整入库总价")
   @JsonProperty("Amount")
   @JSONField(name = "Amount")
   @TableField("Amount")
   @Column(name = "Amount")
   private BigDecimal amount;
   @ApiModelProperty(name = "AmountExcludingVat", value = "调整入库不含税总价")
   @JsonProperty("AmountExcludingVat")
   @JSONField(name = "AmountExcludingVat")
   @TableField("amount_excluding_VAT")
   @Column(name = "amount_excluding_VAT")
   private BigDecimal amountExcludingVat;
   @ApiModelProperty(name = "inputVat", value = "调整入库进项税")
   @JsonProperty("inputVat")
   @JSONField(name = "inputVat")
   @TableField("input_VAT")
   @Column(name = "input_VAT")
   private BigDecimal inputVat;
   private Integer reviewStatus;

   public static AdjustDetailsDTO.AdjustDetailsDTOBuilder builder() {
      return new AdjustDetailsDTO.AdjustDetailsDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public BigDecimal getInputVat() {
      return this.inputVat;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @JsonProperty("Amount")
   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   @JsonProperty("AmountExcludingVat")
   public void setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
   }

   @JsonProperty("inputVat")
   public void setInputVat(final BigDecimal inputVat) {
      this.inputVat = inputVat;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AdjustDetailsDTO)) {
         return false;
      }

      AdjustDetailsDTO other = (AdjustDetailsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$reviewStatus = this.getReviewStatus();
         Object other$reviewStatus = other.getReviewStatus();
         if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
            Object this$createTime = this.getCreateTime();
            Object other$createTime = other.getCreateTime();
            if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$amount = this.getAmount();
                  Object other$amount = other.getAmount();
                  if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                     Object this$amountExcludingVat = this.getAmountExcludingVat();
                     Object other$amountExcludingVat = other.getAmountExcludingVat();
                     if (this$amountExcludingVat == null ? other$amountExcludingVat == null : this$amountExcludingVat.equals(other$amountExcludingVat)) {
                        Object this$inputVat = this.getInputVat();
                        Object other$inputVat = other.getInputVat();
                        return this$inputVat == null ? other$inputVat == null : this$inputVat.equals(other$inputVat);
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
      return other instanceof AdjustDetailsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $inputVat = this.getInputVat();
      return result * 59 + ($inputVat == null ? 43 : $inputVat.hashCode());
   }

   @Override
   public String toString() {
      return "AdjustDetailsDTO(id="
         + this.getId()
         + ", createTime="
         + this.getCreateTime()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", inputVat="
         + this.getInputVat()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ")";
   }

   public AdjustDetailsDTO(
      final Long id,
      final LocalDateTime createTime,
      final String serialNumber,
      final BigDecimal amount,
      final BigDecimal amountExcludingVat,
      final BigDecimal inputVat,
      final Integer reviewStatus
   ) {
      this.id = id;
      this.createTime = createTime;
      this.serialNumber = serialNumber;
      this.amount = amount;
      this.amountExcludingVat = amountExcludingVat;
      this.inputVat = inputVat;
      this.reviewStatus = reviewStatus;
   }

   public AdjustDetailsDTO() {
   }

   public static class AdjustDetailsDTOBuilder {
      private Long id;
      private LocalDateTime createTime;
      private String serialNumber;
      private BigDecimal amount;
      private BigDecimal amountExcludingVat;
      private BigDecimal inputVat;
      private Integer reviewStatus;

      AdjustDetailsDTOBuilder() {
      }

      public AdjustDetailsDTO.AdjustDetailsDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public AdjustDetailsDTO.AdjustDetailsDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public AdjustDetailsDTO.AdjustDetailsDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("Amount")
      public AdjustDetailsDTO.AdjustDetailsDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("AmountExcludingVat")
      public AdjustDetailsDTO.AdjustDetailsDTOBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      @JsonProperty("inputVat")
      public AdjustDetailsDTO.AdjustDetailsDTOBuilder inputVat(final BigDecimal inputVat) {
         this.inputVat = inputVat;
         return this;
      }

      public AdjustDetailsDTO.AdjustDetailsDTOBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public AdjustDetailsDTO build() {
         return new AdjustDetailsDTO(this.id, this.createTime, this.serialNumber, this.amount, this.amountExcludingVat, this.inputVat, this.reviewStatus);
      }

      @Override
      public String toString() {
         return "AdjustDetailsDTO.AdjustDetailsDTOBuilder(id="
            + this.id
            + ", createTime="
            + this.createTime
            + ", serialNumber="
            + this.serialNumber
            + ", amount="
            + this.amount
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", inputVat="
            + this.inputVat
            + ", reviewStatus="
            + this.reviewStatus
            + ")";
      }
   }
}
