package com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "班组")
public class TeamProjectProduceInfo {
   @ApiModelProperty(name = "productionLineId", value = "产线id")
   @JsonProperty("productionLineId")
   @JSONField(name = "productionLineId")
   private Long productionLineId;
   @ApiModelProperty(name = "productionLineName", value = "产线名称")
   @JsonProperty("productionLineName")
   @JSONField(name = "productionLineName")
   private String productionLineName;
   @ApiModelProperty(name = "shortName", value = "项目名称")
   @JsonProperty("shortName")
   @JSONField(name = "shortName")
   private String shortName;
   @ApiModelProperty(name = "orderNumber", value = "工单编号")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   private String orderNumber;
   @ApiModelProperty(name = "totalWeight", value = "总重")
   @JsonProperty("totalWeight")
   @JSONField(name = "totalWeight")
   private BigDecimal totalWeight;
   @ApiModelProperty(name = "weldingRate", value = "焊接")
   @JsonProperty("weldingRate")
   @JSONField(name = "weldingRate")
   private BigDecimal weldingRate;
   @ApiModelProperty(name = "manufactureRate", value = "制造")
   @JsonProperty("manufactureRate")
   @JSONField(name = "manufactureRate")
   private BigDecimal manufactureRate;
   @ApiModelProperty(name = "assemblyRate", value = "装配")
   @JsonProperty("assemblyRate")
   @JSONField(name = "assemblyRate")
   private BigDecimal assemblyRate;
   @ApiModelProperty(name = "paintingRate", value = "涂装")
   @JsonProperty("paintingRate")
   @JSONField(name = "paintingRate")
   private BigDecimal paintingRate;
   @ApiModelProperty(name = "sparkOutRate", value = "清磨")
   @JsonProperty("sparkOutRate")
   @JSONField(name = "sparkOutRate")
   private BigDecimal sparkOutRate;

   public static TeamProjectProduceInfo.TeamProjectProduceInfoBuilder builder() {
      return new TeamProjectProduceInfo.TeamProjectProduceInfoBuilder();
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public String getProductionLineName() {
      return this.productionLineName;
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public BigDecimal getWeldingRate() {
      return this.weldingRate;
   }

   public BigDecimal getManufactureRate() {
      return this.manufactureRate;
   }

   public BigDecimal getAssemblyRate() {
      return this.assemblyRate;
   }

   public BigDecimal getPaintingRate() {
      return this.paintingRate;
   }

   public BigDecimal getSparkOutRate() {
      return this.sparkOutRate;
   }

   @JsonProperty("productionLineId")
   public void setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
   }

   @JsonProperty("productionLineName")
   public void setProductionLineName(final String productionLineName) {
      this.productionLineName = productionLineName;
   }

   @JsonProperty("shortName")
   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   @JsonProperty("orderNumber")
   public void setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
   }

   @JsonProperty("totalWeight")
   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   @JsonProperty("weldingRate")
   public void setWeldingRate(final BigDecimal weldingRate) {
      this.weldingRate = weldingRate;
   }

   @JsonProperty("manufactureRate")
   public void setManufactureRate(final BigDecimal manufactureRate) {
      this.manufactureRate = manufactureRate;
   }

   @JsonProperty("assemblyRate")
   public void setAssemblyRate(final BigDecimal assemblyRate) {
      this.assemblyRate = assemblyRate;
   }

   @JsonProperty("paintingRate")
   public void setPaintingRate(final BigDecimal paintingRate) {
      this.paintingRate = paintingRate;
   }

   @JsonProperty("sparkOutRate")
   public void setSparkOutRate(final BigDecimal sparkOutRate) {
      this.sparkOutRate = sparkOutRate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamProjectProduceInfo)) {
         return false;
      }

      TeamProjectProduceInfo other = (TeamProjectProduceInfo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productionLineId = this.getProductionLineId();
      Object other$productionLineId = other.getProductionLineId();
      if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
         Object this$productionLineName = this.getProductionLineName();
         Object other$productionLineName = other.getProductionLineName();
         if (this$productionLineName == null ? other$productionLineName == null : this$productionLineName.equals(other$productionLineName)) {
            Object this$shortName = this.getShortName();
            Object other$shortName = other.getShortName();
            if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
               Object this$orderNumber = this.getOrderNumber();
               Object other$orderNumber = other.getOrderNumber();
               if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                  Object this$totalWeight = this.getTotalWeight();
                  Object other$totalWeight = other.getTotalWeight();
                  if (this$totalWeight == null ? other$totalWeight == null : this$totalWeight.equals(other$totalWeight)) {
                     Object this$weldingRate = this.getWeldingRate();
                     Object other$weldingRate = other.getWeldingRate();
                     if (this$weldingRate == null ? other$weldingRate == null : this$weldingRate.equals(other$weldingRate)) {
                        Object this$manufactureRate = this.getManufactureRate();
                        Object other$manufactureRate = other.getManufactureRate();
                        if (this$manufactureRate == null ? other$manufactureRate == null : this$manufactureRate.equals(other$manufactureRate)) {
                           Object this$assemblyRate = this.getAssemblyRate();
                           Object other$assemblyRate = other.getAssemblyRate();
                           if (this$assemblyRate == null ? other$assemblyRate == null : this$assemblyRate.equals(other$assemblyRate)) {
                              Object this$paintingRate = this.getPaintingRate();
                              Object other$paintingRate = other.getPaintingRate();
                              if (this$paintingRate == null ? other$paintingRate == null : this$paintingRate.equals(other$paintingRate)) {
                                 Object this$sparkOutRate = this.getSparkOutRate();
                                 Object other$sparkOutRate = other.getSparkOutRate();
                                 return this$sparkOutRate == null ? other$sparkOutRate == null : this$sparkOutRate.equals(other$sparkOutRate);
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
      return other instanceof TeamProjectProduceInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $productionLineName = this.getProductionLineName();
      result = result * 59 + ($productionLineName == null ? 43 : $productionLineName.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $weldingRate = this.getWeldingRate();
      result = result * 59 + ($weldingRate == null ? 43 : $weldingRate.hashCode());
      Object $manufactureRate = this.getManufactureRate();
      result = result * 59 + ($manufactureRate == null ? 43 : $manufactureRate.hashCode());
      Object $assemblyRate = this.getAssemblyRate();
      result = result * 59 + ($assemblyRate == null ? 43 : $assemblyRate.hashCode());
      Object $paintingRate = this.getPaintingRate();
      result = result * 59 + ($paintingRate == null ? 43 : $paintingRate.hashCode());
      Object $sparkOutRate = this.getSparkOutRate();
      return result * 59 + ($sparkOutRate == null ? 43 : $sparkOutRate.hashCode());
   }

   @Override
   public String toString() {
      return "TeamProjectProduceInfo(super="
         + super.toString()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", productionLineName="
         + this.getProductionLineName()
         + ", shortName="
         + this.getShortName()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", weldingRate="
         + this.getWeldingRate()
         + ", manufactureRate="
         + this.getManufactureRate()
         + ", assemblyRate="
         + this.getAssemblyRate()
         + ", paintingRate="
         + this.getPaintingRate()
         + ", sparkOutRate="
         + this.getSparkOutRate()
         + ")";
   }

   public TeamProjectProduceInfo(
      final Long productionLineId,
      final String productionLineName,
      final String shortName,
      final String orderNumber,
      final BigDecimal totalWeight,
      final BigDecimal weldingRate,
      final BigDecimal manufactureRate,
      final BigDecimal assemblyRate,
      final BigDecimal paintingRate,
      final BigDecimal sparkOutRate
   ) {
      this.productionLineId = productionLineId;
      this.productionLineName = productionLineName;
      this.shortName = shortName;
      this.orderNumber = orderNumber;
      this.totalWeight = totalWeight;
      this.weldingRate = weldingRate;
      this.manufactureRate = manufactureRate;
      this.assemblyRate = assemblyRate;
      this.paintingRate = paintingRate;
      this.sparkOutRate = sparkOutRate;
   }

   public TeamProjectProduceInfo() {
   }

   public static class TeamProjectProduceInfoBuilder {
      private Long productionLineId;
      private String productionLineName;
      private String shortName;
      private String orderNumber;
      private BigDecimal totalWeight;
      private BigDecimal weldingRate;
      private BigDecimal manufactureRate;
      private BigDecimal assemblyRate;
      private BigDecimal paintingRate;
      private BigDecimal sparkOutRate;

      TeamProjectProduceInfoBuilder() {
      }

      @JsonProperty("productionLineId")
      public TeamProjectProduceInfo.TeamProjectProduceInfoBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      @JsonProperty("productionLineName")
      public TeamProjectProduceInfo.TeamProjectProduceInfoBuilder productionLineName(final String productionLineName) {
         this.productionLineName = productionLineName;
         return this;
      }

      @JsonProperty("shortName")
      public TeamProjectProduceInfo.TeamProjectProduceInfoBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      @JsonProperty("orderNumber")
      public TeamProjectProduceInfo.TeamProjectProduceInfoBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      @JsonProperty("totalWeight")
      public TeamProjectProduceInfo.TeamProjectProduceInfoBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      @JsonProperty("weldingRate")
      public TeamProjectProduceInfo.TeamProjectProduceInfoBuilder weldingRate(final BigDecimal weldingRate) {
         this.weldingRate = weldingRate;
         return this;
      }

      @JsonProperty("manufactureRate")
      public TeamProjectProduceInfo.TeamProjectProduceInfoBuilder manufactureRate(final BigDecimal manufactureRate) {
         this.manufactureRate = manufactureRate;
         return this;
      }

      @JsonProperty("assemblyRate")
      public TeamProjectProduceInfo.TeamProjectProduceInfoBuilder assemblyRate(final BigDecimal assemblyRate) {
         this.assemblyRate = assemblyRate;
         return this;
      }

      @JsonProperty("paintingRate")
      public TeamProjectProduceInfo.TeamProjectProduceInfoBuilder paintingRate(final BigDecimal paintingRate) {
         this.paintingRate = paintingRate;
         return this;
      }

      @JsonProperty("sparkOutRate")
      public TeamProjectProduceInfo.TeamProjectProduceInfoBuilder sparkOutRate(final BigDecimal sparkOutRate) {
         this.sparkOutRate = sparkOutRate;
         return this;
      }

      public TeamProjectProduceInfo build() {
         return new TeamProjectProduceInfo(
            this.productionLineId,
            this.productionLineName,
            this.shortName,
            this.orderNumber,
            this.totalWeight,
            this.weldingRate,
            this.manufactureRate,
            this.assemblyRate,
            this.paintingRate,
            this.sparkOutRate
         );
      }

      @Override
      public String toString() {
         return "TeamProjectProduceInfo.TeamProjectProduceInfoBuilder(productionLineId="
            + this.productionLineId
            + ", productionLineName="
            + this.productionLineName
            + ", shortName="
            + this.shortName
            + ", orderNumber="
            + this.orderNumber
            + ", totalWeight="
            + this.totalWeight
            + ", weldingRate="
            + this.weldingRate
            + ", manufactureRate="
            + this.manufactureRate
            + ", assemblyRate="
            + this.assemblyRate
            + ", paintingRate="
            + this.paintingRate
            + ", sparkOutRate="
            + this.sparkOutRate
            + ")";
      }
   }
}
