package com.hzchum.scim.plan.core.api.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ArtifactsDTO", description = " ")
public class AssemblesDTO {
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   @JsonProperty("specification")
   @JSONField(name = "specification")
   private String specification;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   @JsonProperty("length")
   @JSONField(name = "length")
   private BigDecimal length;
   @ApiModelProperty(name = "netWeight", notes = "单净重")
   @JsonProperty("netWeight")
   @JSONField(name = "netWeight")
   private BigDecimal netWeight;

   public static AssemblesDTO.AssemblesDTOBuilder builder() {
      return new AssemblesDTO.AssemblesDTOBuilder();
   }

   public AssemblesDTO() {
   }

   public AssemblesDTO(final String serialNumber, final String specification, final Integer quantity, final BigDecimal length, final BigDecimal netWeight) {
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.quantity = quantity;
      this.length = length;
      this.netWeight = netWeight;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   @JsonProperty("serialNumber")
   public AssemblesDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public AssemblesDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("quantity")
   public AssemblesDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("length")
   public AssemblesDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("netWeight")
   public AssemblesDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @Override
   public String toString() {
      return "AssemblesDTO(serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", quantity="
         + this.getQuantity()
         + ", length="
         + this.getLength()
         + ", netWeight="
         + this.getNetWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssemblesDTO)) {
         return false;
      }

      AssemblesDTO other = (AssemblesDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$serialNumber = this.getSerialNumber();
         Object other$serialNumber = other.getSerialNumber();
         if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
            Object this$specification = this.getSpecification();
            Object other$specification = other.getSpecification();
            if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
               Object this$length = this.getLength();
               Object other$length = other.getLength();
               if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                  Object this$netWeight = this.getNetWeight();
                  Object other$netWeight = other.getNetWeight();
                  return this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight);
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
      return other instanceof AssemblesDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $netWeight = this.getNetWeight();
      return result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
   }

   public static class AssemblesDTOBuilder {
      private String serialNumber;
      private String specification;
      private Integer quantity;
      private BigDecimal length;
      private BigDecimal netWeight;

      AssemblesDTOBuilder() {
      }

      @JsonProperty("serialNumber")
      public AssemblesDTO.AssemblesDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public AssemblesDTO.AssemblesDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("quantity")
      public AssemblesDTO.AssemblesDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("length")
      public AssemblesDTO.AssemblesDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("netWeight")
      public AssemblesDTO.AssemblesDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public AssemblesDTO build() {
         return new AssemblesDTO(this.serialNumber, this.specification, this.quantity, this.length, this.netWeight);
      }

      @Override
      public String toString() {
         return "AssemblesDTO.AssemblesDTOBuilder(serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", quantity="
            + this.quantity
            + ", length="
            + this.length
            + ", netWeight="
            + this.netWeight
            + ")";
      }
   }
}
