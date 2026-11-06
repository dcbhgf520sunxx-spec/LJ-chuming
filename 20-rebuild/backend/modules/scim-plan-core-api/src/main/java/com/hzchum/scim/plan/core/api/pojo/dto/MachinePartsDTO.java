package com.hzchum.scim.plan.core.api.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MachinePartsDTO", description = " ")
public class MachinePartsDTO {
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
   @ApiModelProperty(name = "grossWeight", notes = "单毛重")
   @JsonProperty("grossWeight")
   @JSONField(name = "grossWeight")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "cloudPath", value = "图片云路径")
   @JsonProperty("cloudPath")
   @JSONField(name = "cloudPath")
   private String cloudPath;

   public static MachinePartsDTO.MachinePartsDTOBuilder builder() {
      return new MachinePartsDTO.MachinePartsDTOBuilder();
   }

   public MachinePartsDTO() {
   }

   public MachinePartsDTO(
      final String serialNumber,
      final String specification,
      final Integer quantity,
      final BigDecimal length,
      final BigDecimal netWeight,
      final BigDecimal grossWeight,
      final String cloudPath
   ) {
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.quantity = quantity;
      this.length = length;
      this.netWeight = netWeight;
      this.grossWeight = grossWeight;
      this.cloudPath = cloudPath;
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

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public String getCloudPath() {
      return this.cloudPath;
   }

   @JsonProperty("serialNumber")
   public MachinePartsDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("specification")
   public MachinePartsDTO setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   @JsonProperty("quantity")
   public MachinePartsDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("length")
   public MachinePartsDTO setLength(final BigDecimal length) {
      this.length = length;
      return this;
   }

   @JsonProperty("netWeight")
   public MachinePartsDTO setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
      return this;
   }

   @JsonProperty("grossWeight")
   public MachinePartsDTO setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
      return this;
   }

   @JsonProperty("cloudPath")
   public MachinePartsDTO setCloudPath(final String cloudPath) {
      this.cloudPath = cloudPath;
      return this;
   }

   @Override
   public String toString() {
      return "MachinePartsDTO(serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", quantity="
         + this.getQuantity()
         + ", length="
         + this.getLength()
         + ", netWeight="
         + this.getNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", cloudPath="
         + this.getCloudPath()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachinePartsDTO)) {
         return false;
      }

      MachinePartsDTO other = (MachinePartsDTO)o;
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
                  if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                     Object this$grossWeight = this.getGrossWeight();
                     Object other$grossWeight = other.getGrossWeight();
                     if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                        Object this$cloudPath = this.getCloudPath();
                        Object other$cloudPath = other.getCloudPath();
                        return this$cloudPath == null ? other$cloudPath == null : this$cloudPath.equals(other$cloudPath);
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
      return other instanceof MachinePartsDTO;
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
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $cloudPath = this.getCloudPath();
      return result * 59 + ($cloudPath == null ? 43 : $cloudPath.hashCode());
   }

   public static class MachinePartsDTOBuilder {
      private String serialNumber;
      private String specification;
      private Integer quantity;
      private BigDecimal length;
      private BigDecimal netWeight;
      private BigDecimal grossWeight;
      private String cloudPath;

      MachinePartsDTOBuilder() {
      }

      @JsonProperty("serialNumber")
      public MachinePartsDTO.MachinePartsDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("specification")
      public MachinePartsDTO.MachinePartsDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      @JsonProperty("quantity")
      public MachinePartsDTO.MachinePartsDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("length")
      public MachinePartsDTO.MachinePartsDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      @JsonProperty("netWeight")
      public MachinePartsDTO.MachinePartsDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      @JsonProperty("grossWeight")
      public MachinePartsDTO.MachinePartsDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      @JsonProperty("cloudPath")
      public MachinePartsDTO.MachinePartsDTOBuilder cloudPath(final String cloudPath) {
         this.cloudPath = cloudPath;
         return this;
      }

      public MachinePartsDTO build() {
         return new MachinePartsDTO(this.serialNumber, this.specification, this.quantity, this.length, this.netWeight, this.grossWeight, this.cloudPath);
      }

      @Override
      public String toString() {
         return "MachinePartsDTO.MachinePartsDTOBuilder(serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", quantity="
            + this.quantity
            + ", length="
            + this.length
            + ", netWeight="
            + this.netWeight
            + ", grossWeight="
            + this.grossWeight
            + ", cloudPath="
            + this.cloudPath
            + ")";
      }
   }
}
