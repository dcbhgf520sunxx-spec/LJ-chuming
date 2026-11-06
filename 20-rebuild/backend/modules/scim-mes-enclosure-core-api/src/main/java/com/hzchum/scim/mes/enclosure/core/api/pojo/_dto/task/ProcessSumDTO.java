package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProcessSumDTO", description = "")
public class ProcessSumDTO {
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "totalNetWeight", notes = "总净重")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "totalGrossWeight", notes = "总毛重")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;

   public static ProcessSumDTO.ProcessSumDTOBuilder builder() {
      return new ProcessSumDTO.ProcessSumDTOBuilder();
   }

   public ProcessSumDTO() {
   }

   public ProcessSumDTO(final Integer productType, final Integer quantity, final BigDecimal totalNetWeight, final BigDecimal totalGrossWeight) {
      this.productType = productType;
      this.quantity = quantity;
      this.totalNetWeight = totalNetWeight;
      this.totalGrossWeight = totalGrossWeight;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   @JsonProperty("productType")
   public ProcessSumDTO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("quantity")
   public ProcessSumDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public ProcessSumDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public ProcessSumDTO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @Override
   public String toString() {
      return "ProcessSumDTO(productType="
         + this.getProductType()
         + ", quantity="
         + this.getQuantity()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProcessSumDTO)) {
         return false;
      }

      ProcessSumDTO other = (ProcessSumDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productType = this.getProductType();
      Object other$productType = other.getProductType();
      if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$totalNetWeight = this.getTotalNetWeight();
            Object other$totalNetWeight = other.getTotalNetWeight();
            if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
               Object this$totalGrossWeight = this.getTotalGrossWeight();
               Object other$totalGrossWeight = other.getTotalGrossWeight();
               return this$totalGrossWeight == null ? other$totalGrossWeight == null : this$totalGrossWeight.equals(other$totalGrossWeight);
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
      return other instanceof ProcessSumDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      return result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
   }

   public static class ProcessSumDTOBuilder {
      private Integer productType;
      private Integer quantity;
      private BigDecimal totalNetWeight;
      private BigDecimal totalGrossWeight;

      ProcessSumDTOBuilder() {
      }

      @JsonProperty("productType")
      public ProcessSumDTO.ProcessSumDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("quantity")
      public ProcessSumDTO.ProcessSumDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public ProcessSumDTO.ProcessSumDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public ProcessSumDTO.ProcessSumDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public ProcessSumDTO build() {
         return new ProcessSumDTO(this.productType, this.quantity, this.totalNetWeight, this.totalGrossWeight);
      }

      @Override
      public String toString() {
         return "ProcessSumDTO.ProcessSumDTOBuilder(productType="
            + this.productType
            + ", quantity="
            + this.quantity
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ")";
      }
   }
}
