package com.hzchum.scim.mes.building.core.api.pojo._dto.qhse;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class MesBuildingSpotStatisticsCountDowloadDTO {
   @ApiModelProperty(name = "orderNumber", value = "序号")
   private String orderNumber;
   @ApiModelProperty(name = "name", value = "项目/单体名称", notes = "项目/单体名称")
   private String name;
   @ApiModelProperty(name = "spotCheckUserNames", value = "抽检人")
   private String spotCheckUserNames;
   @ApiModelProperty(name = "qualifiedQuantity", value = "合格数")
   private Integer qualifiedQuantity;
   @ApiModelProperty(name = "samplingPassRate", value = "抽检合格率", notes = "抽检合格率")
   private BigDecimal samplingPassRate;
   @ApiModelProperty(name = "unQualifiedQuantity", value = "不合格数", notes = "不合格数")
   private Integer unQualifiedQuantity;
   @ApiModelProperty(name = "unSamplingPassRate", value = "抽检不合格率", notes = "抽检不合格率")
   private BigDecimal unSamplingPassRate;
   @ApiModelProperty(name = "totalCompanyQuantity", value = "完成总数", notes = "完成总数")
   private Integer totalCompanyQuantity;
   @ApiModelProperty(name = "samplingRate", value = "抽检率", notes = "抽检率")
   private BigDecimal samplingRate;

   public static MesBuildingSpotStatisticsCountDowloadDTO.MesBuildingSpotStatisticsCountDowloadDTOBuilder builder() {
      return new MesBuildingSpotStatisticsCountDowloadDTO.MesBuildingSpotStatisticsCountDowloadDTOBuilder();
   }

   public MesBuildingSpotStatisticsCountDowloadDTO() {
   }

   public MesBuildingSpotStatisticsCountDowloadDTO(
      final String orderNumber,
      final String name,
      final String spotCheckUserNames,
      final Integer qualifiedQuantity,
      final BigDecimal samplingPassRate,
      final Integer unQualifiedQuantity,
      final BigDecimal unSamplingPassRate,
      final Integer totalCompanyQuantity,
      final BigDecimal samplingRate
   ) {
      this.orderNumber = orderNumber;
      this.name = name;
      this.spotCheckUserNames = spotCheckUserNames;
      this.qualifiedQuantity = qualifiedQuantity;
      this.samplingPassRate = samplingPassRate;
      this.unQualifiedQuantity = unQualifiedQuantity;
      this.unSamplingPassRate = unSamplingPassRate;
      this.totalCompanyQuantity = totalCompanyQuantity;
      this.samplingRate = samplingRate;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public String getName() {
      return this.name;
   }

   public String getSpotCheckUserNames() {
      return this.spotCheckUserNames;
   }

   public Integer getQualifiedQuantity() {
      return this.qualifiedQuantity;
   }

   public BigDecimal getSamplingPassRate() {
      return this.samplingPassRate;
   }

   public Integer getUnQualifiedQuantity() {
      return this.unQualifiedQuantity;
   }

   public BigDecimal getUnSamplingPassRate() {
      return this.unSamplingPassRate;
   }

   public Integer getTotalCompanyQuantity() {
      return this.totalCompanyQuantity;
   }

   public BigDecimal getSamplingRate() {
      return this.samplingRate;
   }

   public void setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSpotCheckUserNames(final String spotCheckUserNames) {
      this.spotCheckUserNames = spotCheckUserNames;
   }

   public void setQualifiedQuantity(final Integer qualifiedQuantity) {
      this.qualifiedQuantity = qualifiedQuantity;
   }

   public void setSamplingPassRate(final BigDecimal samplingPassRate) {
      this.samplingPassRate = samplingPassRate;
   }

   public void setUnQualifiedQuantity(final Integer unQualifiedQuantity) {
      this.unQualifiedQuantity = unQualifiedQuantity;
   }

   public void setUnSamplingPassRate(final BigDecimal unSamplingPassRate) {
      this.unSamplingPassRate = unSamplingPassRate;
   }

   public void setTotalCompanyQuantity(final Integer totalCompanyQuantity) {
      this.totalCompanyQuantity = totalCompanyQuantity;
   }

   public void setSamplingRate(final BigDecimal samplingRate) {
      this.samplingRate = samplingRate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingSpotStatisticsCountDowloadDTO)) {
         return false;
      }

      MesBuildingSpotStatisticsCountDowloadDTO other = (MesBuildingSpotStatisticsCountDowloadDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$qualifiedQuantity = this.getQualifiedQuantity();
      Object other$qualifiedQuantity = other.getQualifiedQuantity();
      if (this$qualifiedQuantity == null ? other$qualifiedQuantity == null : this$qualifiedQuantity.equals(other$qualifiedQuantity)) {
         Object this$unQualifiedQuantity = this.getUnQualifiedQuantity();
         Object other$unQualifiedQuantity = other.getUnQualifiedQuantity();
         if (this$unQualifiedQuantity == null ? other$unQualifiedQuantity == null : this$unQualifiedQuantity.equals(other$unQualifiedQuantity)) {
            Object this$totalCompanyQuantity = this.getTotalCompanyQuantity();
            Object other$totalCompanyQuantity = other.getTotalCompanyQuantity();
            if (this$totalCompanyQuantity == null ? other$totalCompanyQuantity == null : this$totalCompanyQuantity.equals(other$totalCompanyQuantity)) {
               Object this$orderNumber = this.getOrderNumber();
               Object other$orderNumber = other.getOrderNumber();
               if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$spotCheckUserNames = this.getSpotCheckUserNames();
                     Object other$spotCheckUserNames = other.getSpotCheckUserNames();
                     if (this$spotCheckUserNames == null ? other$spotCheckUserNames == null : this$spotCheckUserNames.equals(other$spotCheckUserNames)) {
                        Object this$samplingPassRate = this.getSamplingPassRate();
                        Object other$samplingPassRate = other.getSamplingPassRate();
                        if (this$samplingPassRate == null ? other$samplingPassRate == null : this$samplingPassRate.equals(other$samplingPassRate)) {
                           Object this$unSamplingPassRate = this.getUnSamplingPassRate();
                           Object other$unSamplingPassRate = other.getUnSamplingPassRate();
                           if (this$unSamplingPassRate == null ? other$unSamplingPassRate == null : this$unSamplingPassRate.equals(other$unSamplingPassRate)) {
                              Object this$samplingRate = this.getSamplingRate();
                              Object other$samplingRate = other.getSamplingRate();
                              return this$samplingRate == null ? other$samplingRate == null : this$samplingRate.equals(other$samplingRate);
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
      return other instanceof MesBuildingSpotStatisticsCountDowloadDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $qualifiedQuantity = this.getQualifiedQuantity();
      result = result * 59 + ($qualifiedQuantity == null ? 43 : $qualifiedQuantity.hashCode());
      Object $unQualifiedQuantity = this.getUnQualifiedQuantity();
      result = result * 59 + ($unQualifiedQuantity == null ? 43 : $unQualifiedQuantity.hashCode());
      Object $totalCompanyQuantity = this.getTotalCompanyQuantity();
      result = result * 59 + ($totalCompanyQuantity == null ? 43 : $totalCompanyQuantity.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $spotCheckUserNames = this.getSpotCheckUserNames();
      result = result * 59 + ($spotCheckUserNames == null ? 43 : $spotCheckUserNames.hashCode());
      Object $samplingPassRate = this.getSamplingPassRate();
      result = result * 59 + ($samplingPassRate == null ? 43 : $samplingPassRate.hashCode());
      Object $unSamplingPassRate = this.getUnSamplingPassRate();
      result = result * 59 + ($unSamplingPassRate == null ? 43 : $unSamplingPassRate.hashCode());
      Object $samplingRate = this.getSamplingRate();
      return result * 59 + ($samplingRate == null ? 43 : $samplingRate.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingSpotStatisticsCountDowloadDTO(orderNumber="
         + this.getOrderNumber()
         + ", name="
         + this.getName()
         + ", spotCheckUserNames="
         + this.getSpotCheckUserNames()
         + ", qualifiedQuantity="
         + this.getQualifiedQuantity()
         + ", samplingPassRate="
         + this.getSamplingPassRate()
         + ", unQualifiedQuantity="
         + this.getUnQualifiedQuantity()
         + ", unSamplingPassRate="
         + this.getUnSamplingPassRate()
         + ", totalCompanyQuantity="
         + this.getTotalCompanyQuantity()
         + ", samplingRate="
         + this.getSamplingRate()
         + ")";
   }

   public static class MesBuildingSpotStatisticsCountDowloadDTOBuilder {
      private String orderNumber;
      private String name;
      private String spotCheckUserNames;
      private Integer qualifiedQuantity;
      private BigDecimal samplingPassRate;
      private Integer unQualifiedQuantity;
      private BigDecimal unSamplingPassRate;
      private Integer totalCompanyQuantity;
      private BigDecimal samplingRate;

      MesBuildingSpotStatisticsCountDowloadDTOBuilder() {
      }

      public MesBuildingSpotStatisticsCountDowloadDTO.MesBuildingSpotStatisticsCountDowloadDTOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      public MesBuildingSpotStatisticsCountDowloadDTO.MesBuildingSpotStatisticsCountDowloadDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesBuildingSpotStatisticsCountDowloadDTO.MesBuildingSpotStatisticsCountDowloadDTOBuilder spotCheckUserNames(final String spotCheckUserNames) {
         this.spotCheckUserNames = spotCheckUserNames;
         return this;
      }

      public MesBuildingSpotStatisticsCountDowloadDTO.MesBuildingSpotStatisticsCountDowloadDTOBuilder qualifiedQuantity(final Integer qualifiedQuantity) {
         this.qualifiedQuantity = qualifiedQuantity;
         return this;
      }

      public MesBuildingSpotStatisticsCountDowloadDTO.MesBuildingSpotStatisticsCountDowloadDTOBuilder samplingPassRate(final BigDecimal samplingPassRate) {
         this.samplingPassRate = samplingPassRate;
         return this;
      }

      public MesBuildingSpotStatisticsCountDowloadDTO.MesBuildingSpotStatisticsCountDowloadDTOBuilder unQualifiedQuantity(final Integer unQualifiedQuantity) {
         this.unQualifiedQuantity = unQualifiedQuantity;
         return this;
      }

      public MesBuildingSpotStatisticsCountDowloadDTO.MesBuildingSpotStatisticsCountDowloadDTOBuilder unSamplingPassRate(final BigDecimal unSamplingPassRate) {
         this.unSamplingPassRate = unSamplingPassRate;
         return this;
      }

      public MesBuildingSpotStatisticsCountDowloadDTO.MesBuildingSpotStatisticsCountDowloadDTOBuilder totalCompanyQuantity(final Integer totalCompanyQuantity) {
         this.totalCompanyQuantity = totalCompanyQuantity;
         return this;
      }

      public MesBuildingSpotStatisticsCountDowloadDTO.MesBuildingSpotStatisticsCountDowloadDTOBuilder samplingRate(final BigDecimal samplingRate) {
         this.samplingRate = samplingRate;
         return this;
      }

      public MesBuildingSpotStatisticsCountDowloadDTO build() {
         return new MesBuildingSpotStatisticsCountDowloadDTO(
            this.orderNumber,
            this.name,
            this.spotCheckUserNames,
            this.qualifiedQuantity,
            this.samplingPassRate,
            this.unQualifiedQuantity,
            this.unSamplingPassRate,
            this.totalCompanyQuantity,
            this.samplingRate
         );
      }

      @Override
      public String toString() {
         return "MesBuildingSpotStatisticsCountDowloadDTO.MesBuildingSpotStatisticsCountDowloadDTOBuilder(orderNumber="
            + this.orderNumber
            + ", name="
            + this.name
            + ", spotCheckUserNames="
            + this.spotCheckUserNames
            + ", qualifiedQuantity="
            + this.qualifiedQuantity
            + ", samplingPassRate="
            + this.samplingPassRate
            + ", unQualifiedQuantity="
            + this.unQualifiedQuantity
            + ", unSamplingPassRate="
            + this.unSamplingPassRate
            + ", totalCompanyQuantity="
            + this.totalCompanyQuantity
            + ", samplingRate="
            + this.samplingRate
            + ")";
      }
   }
}
