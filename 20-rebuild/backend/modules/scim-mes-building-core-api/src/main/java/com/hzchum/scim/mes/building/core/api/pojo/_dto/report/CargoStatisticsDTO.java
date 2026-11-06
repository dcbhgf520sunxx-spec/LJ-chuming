package com.hzchum.scim.mes.building.core.api.pojo._dto.report;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "CargoStatisticsDTO", description = "制成品库存统计信息")
public class CargoStatisticsDTO {
   @ApiModelProperty(name = "id")
   private Long projectId;
   @ApiModelProperty(name = "workShopId")
   private Long workShopId;
   @ApiModelProperty(name = "inboundQuantity", value = "入库数量")
   @JsonProperty("inboundQuantity")
   @JSONField(name = "inboundQuantity")
   private Integer inboundQuantity;
   @ApiModelProperty(name = "cargoQuantity", value = "发运数量")
   @JsonProperty("cargoQuantity")
   @JSONField(name = "cargoQuantity")
   private Integer cargoQuantity;
   @ApiModelProperty(name = "productType", value = "产品类型")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   private Integer productType;
   @ApiModelProperty(name = "inboundWeight", value = "入库重量")
   @JsonProperty("inboundWeight")
   @JSONField(name = "inboundWeight")
   private BigDecimal inboundWeight;
   @ApiModelProperty(name = "cargoWeight", value = "发运重量")
   @JsonProperty("cargoWeight")
   @JSONField(name = "cargoWeight")
   private BigDecimal cargoWeight;

   public static CargoStatisticsDTO.CargoStatisticsDTOBuilder builder() {
      return new CargoStatisticsDTO.CargoStatisticsDTOBuilder();
   }

   public CargoStatisticsDTO() {
   }

   public CargoStatisticsDTO(
      final Long projectId,
      final Long workShopId,
      final Integer inboundQuantity,
      final Integer cargoQuantity,
      final Integer productType,
      final BigDecimal inboundWeight,
      final BigDecimal cargoWeight
   ) {
      this.projectId = projectId;
      this.workShopId = workShopId;
      this.inboundQuantity = inboundQuantity;
      this.cargoQuantity = cargoQuantity;
      this.productType = productType;
      this.inboundWeight = inboundWeight;
      this.cargoWeight = cargoWeight;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getWorkShopId() {
      return this.workShopId;
   }

   public Integer getInboundQuantity() {
      return this.inboundQuantity;
   }

   public Integer getCargoQuantity() {
      return this.cargoQuantity;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public BigDecimal getInboundWeight() {
      return this.inboundWeight;
   }

   public BigDecimal getCargoWeight() {
      return this.cargoWeight;
   }

   public CargoStatisticsDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public CargoStatisticsDTO setWorkShopId(final Long workShopId) {
      this.workShopId = workShopId;
      return this;
   }

   @JsonProperty("inboundQuantity")
   public CargoStatisticsDTO setInboundQuantity(final Integer inboundQuantity) {
      this.inboundQuantity = inboundQuantity;
      return this;
   }

   @JsonProperty("cargoQuantity")
   public CargoStatisticsDTO setCargoQuantity(final Integer cargoQuantity) {
      this.cargoQuantity = cargoQuantity;
      return this;
   }

   @JsonProperty("productType")
   public CargoStatisticsDTO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("inboundWeight")
   public CargoStatisticsDTO setInboundWeight(final BigDecimal inboundWeight) {
      this.inboundWeight = inboundWeight;
      return this;
   }

   @JsonProperty("cargoWeight")
   public CargoStatisticsDTO setCargoWeight(final BigDecimal cargoWeight) {
      this.cargoWeight = cargoWeight;
      return this;
   }

   @Override
   public String toString() {
      return "CargoStatisticsDTO(projectId="
         + this.getProjectId()
         + ", workShopId="
         + this.getWorkShopId()
         + ", inboundQuantity="
         + this.getInboundQuantity()
         + ", cargoQuantity="
         + this.getCargoQuantity()
         + ", productType="
         + this.getProductType()
         + ", inboundWeight="
         + this.getInboundWeight()
         + ", cargoWeight="
         + this.getCargoWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoStatisticsDTO)) {
         return false;
      }

      CargoStatisticsDTO other = (CargoStatisticsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$workShopId = this.getWorkShopId();
         Object other$workShopId = other.getWorkShopId();
         if (this$workShopId == null ? other$workShopId == null : this$workShopId.equals(other$workShopId)) {
            Object this$inboundQuantity = this.getInboundQuantity();
            Object other$inboundQuantity = other.getInboundQuantity();
            if (this$inboundQuantity == null ? other$inboundQuantity == null : this$inboundQuantity.equals(other$inboundQuantity)) {
               Object this$cargoQuantity = this.getCargoQuantity();
               Object other$cargoQuantity = other.getCargoQuantity();
               if (this$cargoQuantity == null ? other$cargoQuantity == null : this$cargoQuantity.equals(other$cargoQuantity)) {
                  Object this$productType = this.getProductType();
                  Object other$productType = other.getProductType();
                  if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                     Object this$inboundWeight = this.getInboundWeight();
                     Object other$inboundWeight = other.getInboundWeight();
                     if (this$inboundWeight == null ? other$inboundWeight == null : this$inboundWeight.equals(other$inboundWeight)) {
                        Object this$cargoWeight = this.getCargoWeight();
                        Object other$cargoWeight = other.getCargoWeight();
                        return this$cargoWeight == null ? other$cargoWeight == null : this$cargoWeight.equals(other$cargoWeight);
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
      return other instanceof CargoStatisticsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $workShopId = this.getWorkShopId();
      result = result * 59 + ($workShopId == null ? 43 : $workShopId.hashCode());
      Object $inboundQuantity = this.getInboundQuantity();
      result = result * 59 + ($inboundQuantity == null ? 43 : $inboundQuantity.hashCode());
      Object $cargoQuantity = this.getCargoQuantity();
      result = result * 59 + ($cargoQuantity == null ? 43 : $cargoQuantity.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $inboundWeight = this.getInboundWeight();
      result = result * 59 + ($inboundWeight == null ? 43 : $inboundWeight.hashCode());
      Object $cargoWeight = this.getCargoWeight();
      return result * 59 + ($cargoWeight == null ? 43 : $cargoWeight.hashCode());
   }

   public static class CargoStatisticsDTOBuilder {
      private Long projectId;
      private Long workShopId;
      private Integer inboundQuantity;
      private Integer cargoQuantity;
      private Integer productType;
      private BigDecimal inboundWeight;
      private BigDecimal cargoWeight;

      CargoStatisticsDTOBuilder() {
      }

      public CargoStatisticsDTO.CargoStatisticsDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public CargoStatisticsDTO.CargoStatisticsDTOBuilder workShopId(final Long workShopId) {
         this.workShopId = workShopId;
         return this;
      }

      @JsonProperty("inboundQuantity")
      public CargoStatisticsDTO.CargoStatisticsDTOBuilder inboundQuantity(final Integer inboundQuantity) {
         this.inboundQuantity = inboundQuantity;
         return this;
      }

      @JsonProperty("cargoQuantity")
      public CargoStatisticsDTO.CargoStatisticsDTOBuilder cargoQuantity(final Integer cargoQuantity) {
         this.cargoQuantity = cargoQuantity;
         return this;
      }

      @JsonProperty("productType")
      public CargoStatisticsDTO.CargoStatisticsDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("inboundWeight")
      public CargoStatisticsDTO.CargoStatisticsDTOBuilder inboundWeight(final BigDecimal inboundWeight) {
         this.inboundWeight = inboundWeight;
         return this;
      }

      @JsonProperty("cargoWeight")
      public CargoStatisticsDTO.CargoStatisticsDTOBuilder cargoWeight(final BigDecimal cargoWeight) {
         this.cargoWeight = cargoWeight;
         return this;
      }

      public CargoStatisticsDTO build() {
         return new CargoStatisticsDTO(
            this.projectId, this.workShopId, this.inboundQuantity, this.cargoQuantity, this.productType, this.inboundWeight, this.cargoWeight
         );
      }

      @Override
      public String toString() {
         return "CargoStatisticsDTO.CargoStatisticsDTOBuilder(projectId="
            + this.projectId
            + ", workShopId="
            + this.workShopId
            + ", inboundQuantity="
            + this.inboundQuantity
            + ", cargoQuantity="
            + this.cargoQuantity
            + ", productType="
            + this.productType
            + ", inboundWeight="
            + this.inboundWeight
            + ", cargoWeight="
            + this.cargoWeight
            + ")";
      }
   }
}
