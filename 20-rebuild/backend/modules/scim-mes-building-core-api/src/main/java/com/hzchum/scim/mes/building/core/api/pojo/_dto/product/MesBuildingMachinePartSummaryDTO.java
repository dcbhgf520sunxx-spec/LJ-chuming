package com.hzchum.scim.mes.building.core.api.pojo._dto.product;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesBuildingMachinePartDTO", description = "")
public class MesBuildingMachinePartSummaryDTO {
   @ApiModelProperty(name = "name", notes = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "steelSpec", notes = "板厚或规格")
   @JsonProperty("steelSpec")
   @JSONField(name = "steelSpec")
   private String steelSpec;
   @ApiModelProperty(name = "steelId", notes = "版型id")
   @JsonProperty("steelId")
   @JSONField(name = "steelId")
   private Integer steelId;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private String quantity;
   @ApiModelProperty(name = "totalGrossWeight")
   @JsonProperty("totalGrossWeight")
   @JSONField(name = "totalGrossWeight")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "totalNetWeight")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "totalSchedulingQuantity", notes = "数量")
   @JsonProperty("totalSchedulingQuantity")
   @JSONField(name = "totalSchedulingQuantity")
   private String totalSchedulingQuantity;
   @ApiModelProperty(name = "totalSchedulingNetWeight")
   @JsonProperty("totalSchedulingNetWeight")
   @JSONField(name = "totalSchedulingNetWeight")
   private BigDecimal totalSchedulingNetWeight;
   @ApiModelProperty(name = "totalSchedulingGrossWeight")
   @JsonProperty("totalSchedulingGrossWeight")
   @JSONField(name = "totalSchedulingGrossWeight")
   private BigDecimal totalSchedulingGrossWeight;

   public static MesBuildingMachinePartSummaryDTO.MesBuildingMachinePartSummaryDTOBuilder builder() {
      return new MesBuildingMachinePartSummaryDTO.MesBuildingMachinePartSummaryDTOBuilder();
   }

   public MesBuildingMachinePartSummaryDTO(
      final String name,
      final String steelSpec,
      final Integer steelId,
      final String quantity,
      final BigDecimal totalGrossWeight,
      final BigDecimal totalNetWeight,
      final String totalSchedulingQuantity,
      final BigDecimal totalSchedulingNetWeight,
      final BigDecimal totalSchedulingGrossWeight
   ) {
      this.name = name;
      this.steelSpec = steelSpec;
      this.steelId = steelId;
      this.quantity = quantity;
      this.totalGrossWeight = totalGrossWeight;
      this.totalNetWeight = totalNetWeight;
      this.totalSchedulingQuantity = totalSchedulingQuantity;
      this.totalSchedulingNetWeight = totalSchedulingNetWeight;
      this.totalSchedulingGrossWeight = totalSchedulingGrossWeight;
   }

   public MesBuildingMachinePartSummaryDTO() {
   }

   public String getName() {
      return this.name;
   }

   public String getSteelSpec() {
      return this.steelSpec;
   }

   public Integer getSteelId() {
      return this.steelId;
   }

   public String getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public String getTotalSchedulingQuantity() {
      return this.totalSchedulingQuantity;
   }

   public BigDecimal getTotalSchedulingNetWeight() {
      return this.totalSchedulingNetWeight;
   }

   public BigDecimal getTotalSchedulingGrossWeight() {
      return this.totalSchedulingGrossWeight;
   }

   @JsonProperty("name")
   public MesBuildingMachinePartSummaryDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("steelSpec")
   public MesBuildingMachinePartSummaryDTO setSteelSpec(final String steelSpec) {
      this.steelSpec = steelSpec;
      return this;
   }

   @JsonProperty("steelId")
   public MesBuildingMachinePartSummaryDTO setSteelId(final Integer steelId) {
      this.steelId = steelId;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingMachinePartSummaryDTO setQuantity(final String quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalGrossWeight")
   public MesBuildingMachinePartSummaryDTO setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public MesBuildingMachinePartSummaryDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @JsonProperty("totalSchedulingQuantity")
   public MesBuildingMachinePartSummaryDTO setTotalSchedulingQuantity(final String totalSchedulingQuantity) {
      this.totalSchedulingQuantity = totalSchedulingQuantity;
      return this;
   }

   @JsonProperty("totalSchedulingNetWeight")
   public MesBuildingMachinePartSummaryDTO setTotalSchedulingNetWeight(final BigDecimal totalSchedulingNetWeight) {
      this.totalSchedulingNetWeight = totalSchedulingNetWeight;
      return this;
   }

   @JsonProperty("totalSchedulingGrossWeight")
   public MesBuildingMachinePartSummaryDTO setTotalSchedulingGrossWeight(final BigDecimal totalSchedulingGrossWeight) {
      this.totalSchedulingGrossWeight = totalSchedulingGrossWeight;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingMachinePartSummaryDTO(name="
         + this.getName()
         + ", steelSpec="
         + this.getSteelSpec()
         + ", steelId="
         + this.getSteelId()
         + ", quantity="
         + this.getQuantity()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalSchedulingQuantity="
         + this.getTotalSchedulingQuantity()
         + ", totalSchedulingNetWeight="
         + this.getTotalSchedulingNetWeight()
         + ", totalSchedulingGrossWeight="
         + this.getTotalSchedulingGrossWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingMachinePartSummaryDTO)) {
         return false;
      }

      MesBuildingMachinePartSummaryDTO other = (MesBuildingMachinePartSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$steelId = this.getSteelId();
      Object other$steelId = other.getSteelId();
      if (this$steelId == null ? other$steelId == null : this$steelId.equals(other$steelId)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$steelSpec = this.getSteelSpec();
            Object other$steelSpec = other.getSteelSpec();
            if (this$steelSpec == null ? other$steelSpec == null : this$steelSpec.equals(other$steelSpec)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$totalGrossWeight = this.getTotalGrossWeight();
                  Object other$totalGrossWeight = other.getTotalGrossWeight();
                  if (this$totalGrossWeight == null ? other$totalGrossWeight == null : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                     Object this$totalNetWeight = this.getTotalNetWeight();
                     Object other$totalNetWeight = other.getTotalNetWeight();
                     if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                        Object this$totalSchedulingQuantity = this.getTotalSchedulingQuantity();
                        Object other$totalSchedulingQuantity = other.getTotalSchedulingQuantity();
                        if (this$totalSchedulingQuantity == null
                           ? other$totalSchedulingQuantity == null
                           : this$totalSchedulingQuantity.equals(other$totalSchedulingQuantity)) {
                           Object this$totalSchedulingNetWeight = this.getTotalSchedulingNetWeight();
                           Object other$totalSchedulingNetWeight = other.getTotalSchedulingNetWeight();
                           if (this$totalSchedulingNetWeight == null
                              ? other$totalSchedulingNetWeight == null
                              : this$totalSchedulingNetWeight.equals(other$totalSchedulingNetWeight)) {
                              Object this$totalSchedulingGrossWeight = this.getTotalSchedulingGrossWeight();
                              Object other$totalSchedulingGrossWeight = other.getTotalSchedulingGrossWeight();
                              return this$totalSchedulingGrossWeight == null
                                 ? other$totalSchedulingGrossWeight == null
                                 : this$totalSchedulingGrossWeight.equals(other$totalSchedulingGrossWeight);
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
      return other instanceof MesBuildingMachinePartSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $steelId = this.getSteelId();
      result = result * 59 + ($steelId == null ? 43 : $steelId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $steelSpec = this.getSteelSpec();
      result = result * 59 + ($steelSpec == null ? 43 : $steelSpec.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalSchedulingQuantity = this.getTotalSchedulingQuantity();
      result = result * 59 + ($totalSchedulingQuantity == null ? 43 : $totalSchedulingQuantity.hashCode());
      Object $totalSchedulingNetWeight = this.getTotalSchedulingNetWeight();
      result = result * 59 + ($totalSchedulingNetWeight == null ? 43 : $totalSchedulingNetWeight.hashCode());
      Object $totalSchedulingGrossWeight = this.getTotalSchedulingGrossWeight();
      return result * 59 + ($totalSchedulingGrossWeight == null ? 43 : $totalSchedulingGrossWeight.hashCode());
   }

   public static class MesBuildingMachinePartSummaryDTOBuilder {
      private String name;
      private String steelSpec;
      private Integer steelId;
      private String quantity;
      private BigDecimal totalGrossWeight;
      private BigDecimal totalNetWeight;
      private String totalSchedulingQuantity;
      private BigDecimal totalSchedulingNetWeight;
      private BigDecimal totalSchedulingGrossWeight;

      MesBuildingMachinePartSummaryDTOBuilder() {
      }

      @JsonProperty("name")
      public MesBuildingMachinePartSummaryDTO.MesBuildingMachinePartSummaryDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("steelSpec")
      public MesBuildingMachinePartSummaryDTO.MesBuildingMachinePartSummaryDTOBuilder steelSpec(final String steelSpec) {
         this.steelSpec = steelSpec;
         return this;
      }

      @JsonProperty("steelId")
      public MesBuildingMachinePartSummaryDTO.MesBuildingMachinePartSummaryDTOBuilder steelId(final Integer steelId) {
         this.steelId = steelId;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingMachinePartSummaryDTO.MesBuildingMachinePartSummaryDTOBuilder quantity(final String quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalGrossWeight")
      public MesBuildingMachinePartSummaryDTO.MesBuildingMachinePartSummaryDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public MesBuildingMachinePartSummaryDTO.MesBuildingMachinePartSummaryDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      @JsonProperty("totalSchedulingQuantity")
      public MesBuildingMachinePartSummaryDTO.MesBuildingMachinePartSummaryDTOBuilder totalSchedulingQuantity(final String totalSchedulingQuantity) {
         this.totalSchedulingQuantity = totalSchedulingQuantity;
         return this;
      }

      @JsonProperty("totalSchedulingNetWeight")
      public MesBuildingMachinePartSummaryDTO.MesBuildingMachinePartSummaryDTOBuilder totalSchedulingNetWeight(final BigDecimal totalSchedulingNetWeight) {
         this.totalSchedulingNetWeight = totalSchedulingNetWeight;
         return this;
      }

      @JsonProperty("totalSchedulingGrossWeight")
      public MesBuildingMachinePartSummaryDTO.MesBuildingMachinePartSummaryDTOBuilder totalSchedulingGrossWeight(final BigDecimal totalSchedulingGrossWeight) {
         this.totalSchedulingGrossWeight = totalSchedulingGrossWeight;
         return this;
      }

      public MesBuildingMachinePartSummaryDTO build() {
         return new MesBuildingMachinePartSummaryDTO(
            this.name,
            this.steelSpec,
            this.steelId,
            this.quantity,
            this.totalGrossWeight,
            this.totalNetWeight,
            this.totalSchedulingQuantity,
            this.totalSchedulingNetWeight,
            this.totalSchedulingGrossWeight
         );
      }

      @Override
      public String toString() {
         return "MesBuildingMachinePartSummaryDTO.MesBuildingMachinePartSummaryDTOBuilder(name="
            + this.name
            + ", steelSpec="
            + this.steelSpec
            + ", steelId="
            + this.steelId
            + ", quantity="
            + this.quantity
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", totalSchedulingQuantity="
            + this.totalSchedulingQuantity
            + ", totalSchedulingNetWeight="
            + this.totalSchedulingNetWeight
            + ", totalSchedulingGrossWeight="
            + this.totalSchedulingGrossWeight
            + ")";
      }
   }
}
