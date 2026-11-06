package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.qhse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QhseSummaryDTO", description = "问题曝光类型汇总 ")
public class QhseSummaryDTO {
   @ApiModelProperty(name = "quantity", value = "问题类型数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "qualityType", value = "质量问题类型")
   @JsonProperty("qualityType")
   @JSONField(name = "qualityType")
   private String qualityType;
   @ApiModelProperty(name = "qualityValue", value = "质量问题类型字典值")
   @JsonProperty("qualityValue")
   @JSONField(name = "qualityValue")
   private String qualityValue;

   public static QhseSummaryDTO.QhseSummaryDTOBuilder builder() {
      return new QhseSummaryDTO.QhseSummaryDTOBuilder();
   }

   public QhseSummaryDTO() {
   }

   public QhseSummaryDTO(final Integer quantity, final String qualityType, final String qualityValue) {
      this.quantity = quantity;
      this.qualityType = qualityType;
      this.qualityValue = qualityValue;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getQualityType() {
      return this.qualityType;
   }

   public String getQualityValue() {
      return this.qualityValue;
   }

   @JsonProperty("quantity")
   public QhseSummaryDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("qualityType")
   public QhseSummaryDTO setQualityType(final String qualityType) {
      this.qualityType = qualityType;
      return this;
   }

   @JsonProperty("qualityValue")
   public QhseSummaryDTO setQualityValue(final String qualityValue) {
      this.qualityValue = qualityValue;
      return this;
   }

   @Override
   public String toString() {
      return "QhseSummaryDTO(quantity=" + this.getQuantity() + ", qualityType=" + this.getQualityType() + ", qualityValue=" + this.getQualityValue() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QhseSummaryDTO)) {
         return false;
      }

      QhseSummaryDTO other = (QhseSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$qualityType = this.getQualityType();
         Object other$qualityType = other.getQualityType();
         if (this$qualityType == null ? other$qualityType == null : this$qualityType.equals(other$qualityType)) {
            Object this$qualityValue = this.getQualityValue();
            Object other$qualityValue = other.getQualityValue();
            return this$qualityValue == null ? other$qualityValue == null : this$qualityValue.equals(other$qualityValue);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof QhseSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $qualityType = this.getQualityType();
      result = result * 59 + ($qualityType == null ? 43 : $qualityType.hashCode());
      Object $qualityValue = this.getQualityValue();
      return result * 59 + ($qualityValue == null ? 43 : $qualityValue.hashCode());
   }

   public static class QhseSummaryDTOBuilder {
      private Integer quantity;
      private String qualityType;
      private String qualityValue;

      QhseSummaryDTOBuilder() {
      }

      @JsonProperty("quantity")
      public QhseSummaryDTO.QhseSummaryDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("qualityType")
      public QhseSummaryDTO.QhseSummaryDTOBuilder qualityType(final String qualityType) {
         this.qualityType = qualityType;
         return this;
      }

      @JsonProperty("qualityValue")
      public QhseSummaryDTO.QhseSummaryDTOBuilder qualityValue(final String qualityValue) {
         this.qualityValue = qualityValue;
         return this;
      }

      public QhseSummaryDTO build() {
         return new QhseSummaryDTO(this.quantity, this.qualityType, this.qualityValue);
      }

      @Override
      public String toString() {
         return "QhseSummaryDTO.QhseSummaryDTOBuilder(quantity="
            + this.quantity
            + ", qualityType="
            + this.qualityType
            + ", qualityValue="
            + this.qualityValue
            + ")";
      }
   }
}
