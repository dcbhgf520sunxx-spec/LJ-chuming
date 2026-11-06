package com.hzchum.scim.business.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "BusinessShipCargoDTO对象", description = "发运跟踪汇总 ")
public class BusinessShipCargoDTO {
   @ApiModelProperty("累计发运金额(元)")
   private BigDecimal shipAmount;
   @ApiModelProperty("累计发运量(吨)")
   private BigDecimal shipMet;
   @ApiModelProperty("平均车次吨位（吨）")
   private BigDecimal shipMetAvg;
   @ApiModelProperty("累计发运长度(米)")
   private BigDecimal shipLength;
   @ApiModelProperty("累计发运面积(平方米)")
   private BigDecimal shipArea;
   @ApiModelProperty("筛选日期发运金额(元)")
   private BigDecimal shipAmountTime;
   @ApiModelProperty("筛选日期发运量(吨)")
   private BigDecimal shipMetTime;
   @ApiModelProperty("筛选日期发运长度(米)")
   private BigDecimal shipLengthTime;
   @ApiModelProperty("筛选日期发运面积(平方米)")
   private BigDecimal shipAreaTime;
   @ApiModelProperty("累计发运车次")
   private Integer cargoQuantity;
   @ApiModelProperty("筛选日期发运车次")
   private Integer cargoQuantityTime;
   @ApiModelProperty("开始时间")
   private LocalDateTime startDate;
   @ApiModelProperty("结束时间")
   private LocalDateTime endDate;

   public static BusinessShipCargoDTO.BusinessShipCargoDTOBuilder builder() {
      return new BusinessShipCargoDTO.BusinessShipCargoDTOBuilder();
   }

   public BusinessShipCargoDTO() {
   }

   public BusinessShipCargoDTO(
      final BigDecimal shipAmount,
      final BigDecimal shipMet,
      final BigDecimal shipMetAvg,
      final BigDecimal shipLength,
      final BigDecimal shipArea,
      final BigDecimal shipAmountTime,
      final BigDecimal shipMetTime,
      final BigDecimal shipLengthTime,
      final BigDecimal shipAreaTime,
      final Integer cargoQuantity,
      final Integer cargoQuantityTime,
      final LocalDateTime startDate,
      final LocalDateTime endDate
   ) {
      this.shipAmount = shipAmount;
      this.shipMet = shipMet;
      this.shipMetAvg = shipMetAvg;
      this.shipLength = shipLength;
      this.shipArea = shipArea;
      this.shipAmountTime = shipAmountTime;
      this.shipMetTime = shipMetTime;
      this.shipLengthTime = shipLengthTime;
      this.shipAreaTime = shipAreaTime;
      this.cargoQuantity = cargoQuantity;
      this.cargoQuantityTime = cargoQuantityTime;
      this.startDate = startDate;
      this.endDate = endDate;
   }

   public BigDecimal getShipAmount() {
      return this.shipAmount;
   }

   public BigDecimal getShipMet() {
      return this.shipMet;
   }

   public BigDecimal getShipMetAvg() {
      return this.shipMetAvg;
   }

   public BigDecimal getShipLength() {
      return this.shipLength;
   }

   public BigDecimal getShipArea() {
      return this.shipArea;
   }

   public BigDecimal getShipAmountTime() {
      return this.shipAmountTime;
   }

   public BigDecimal getShipMetTime() {
      return this.shipMetTime;
   }

   public BigDecimal getShipLengthTime() {
      return this.shipLengthTime;
   }

   public BigDecimal getShipAreaTime() {
      return this.shipAreaTime;
   }

   public Integer getCargoQuantity() {
      return this.cargoQuantity;
   }

   public Integer getCargoQuantityTime() {
      return this.cargoQuantityTime;
   }

   public LocalDateTime getStartDate() {
      return this.startDate;
   }

   public LocalDateTime getEndDate() {
      return this.endDate;
   }

   public BusinessShipCargoDTO setShipAmount(final BigDecimal shipAmount) {
      this.shipAmount = shipAmount;
      return this;
   }

   public BusinessShipCargoDTO setShipMet(final BigDecimal shipMet) {
      this.shipMet = shipMet;
      return this;
   }

   public BusinessShipCargoDTO setShipMetAvg(final BigDecimal shipMetAvg) {
      this.shipMetAvg = shipMetAvg;
      return this;
   }

   public BusinessShipCargoDTO setShipLength(final BigDecimal shipLength) {
      this.shipLength = shipLength;
      return this;
   }

   public BusinessShipCargoDTO setShipArea(final BigDecimal shipArea) {
      this.shipArea = shipArea;
      return this;
   }

   public BusinessShipCargoDTO setShipAmountTime(final BigDecimal shipAmountTime) {
      this.shipAmountTime = shipAmountTime;
      return this;
   }

   public BusinessShipCargoDTO setShipMetTime(final BigDecimal shipMetTime) {
      this.shipMetTime = shipMetTime;
      return this;
   }

   public BusinessShipCargoDTO setShipLengthTime(final BigDecimal shipLengthTime) {
      this.shipLengthTime = shipLengthTime;
      return this;
   }

   public BusinessShipCargoDTO setShipAreaTime(final BigDecimal shipAreaTime) {
      this.shipAreaTime = shipAreaTime;
      return this;
   }

   public BusinessShipCargoDTO setCargoQuantity(final Integer cargoQuantity) {
      this.cargoQuantity = cargoQuantity;
      return this;
   }

   public BusinessShipCargoDTO setCargoQuantityTime(final Integer cargoQuantityTime) {
      this.cargoQuantityTime = cargoQuantityTime;
      return this;
   }

   public BusinessShipCargoDTO setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
      return this;
   }

   public BusinessShipCargoDTO setEndDate(final LocalDateTime endDate) {
      this.endDate = endDate;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessShipCargoDTO)) {
         return false;
      }

      BusinessShipCargoDTO other = (BusinessShipCargoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$cargoQuantity = this.getCargoQuantity();
      Object other$cargoQuantity = other.getCargoQuantity();
      if (this$cargoQuantity == null ? other$cargoQuantity == null : this$cargoQuantity.equals(other$cargoQuantity)) {
         Object this$cargoQuantityTime = this.getCargoQuantityTime();
         Object other$cargoQuantityTime = other.getCargoQuantityTime();
         if (this$cargoQuantityTime == null ? other$cargoQuantityTime == null : this$cargoQuantityTime.equals(other$cargoQuantityTime)) {
            Object this$shipAmount = this.getShipAmount();
            Object other$shipAmount = other.getShipAmount();
            if (this$shipAmount == null ? other$shipAmount == null : this$shipAmount.equals(other$shipAmount)) {
               Object this$shipMet = this.getShipMet();
               Object other$shipMet = other.getShipMet();
               if (this$shipMet == null ? other$shipMet == null : this$shipMet.equals(other$shipMet)) {
                  Object this$shipMetAvg = this.getShipMetAvg();
                  Object other$shipMetAvg = other.getShipMetAvg();
                  if (this$shipMetAvg == null ? other$shipMetAvg == null : this$shipMetAvg.equals(other$shipMetAvg)) {
                     Object this$shipLength = this.getShipLength();
                     Object other$shipLength = other.getShipLength();
                     if (this$shipLength == null ? other$shipLength == null : this$shipLength.equals(other$shipLength)) {
                        Object this$shipArea = this.getShipArea();
                        Object other$shipArea = other.getShipArea();
                        if (this$shipArea == null ? other$shipArea == null : this$shipArea.equals(other$shipArea)) {
                           Object this$shipAmountTime = this.getShipAmountTime();
                           Object other$shipAmountTime = other.getShipAmountTime();
                           if (this$shipAmountTime == null ? other$shipAmountTime == null : this$shipAmountTime.equals(other$shipAmountTime)) {
                              Object this$shipMetTime = this.getShipMetTime();
                              Object other$shipMetTime = other.getShipMetTime();
                              if (this$shipMetTime == null ? other$shipMetTime == null : this$shipMetTime.equals(other$shipMetTime)) {
                                 Object this$shipLengthTime = this.getShipLengthTime();
                                 Object other$shipLengthTime = other.getShipLengthTime();
                                 if (this$shipLengthTime == null ? other$shipLengthTime == null : this$shipLengthTime.equals(other$shipLengthTime)) {
                                    Object this$shipAreaTime = this.getShipAreaTime();
                                    Object other$shipAreaTime = other.getShipAreaTime();
                                    if (this$shipAreaTime == null ? other$shipAreaTime == null : this$shipAreaTime.equals(other$shipAreaTime)) {
                                       Object this$startDate = this.getStartDate();
                                       Object other$startDate = other.getStartDate();
                                       if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                                          Object this$endDate = this.getEndDate();
                                          Object other$endDate = other.getEndDate();
                                          return this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate);
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
      return other instanceof BusinessShipCargoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $cargoQuantity = this.getCargoQuantity();
      result = result * 59 + ($cargoQuantity == null ? 43 : $cargoQuantity.hashCode());
      Object $cargoQuantityTime = this.getCargoQuantityTime();
      result = result * 59 + ($cargoQuantityTime == null ? 43 : $cargoQuantityTime.hashCode());
      Object $shipAmount = this.getShipAmount();
      result = result * 59 + ($shipAmount == null ? 43 : $shipAmount.hashCode());
      Object $shipMet = this.getShipMet();
      result = result * 59 + ($shipMet == null ? 43 : $shipMet.hashCode());
      Object $shipMetAvg = this.getShipMetAvg();
      result = result * 59 + ($shipMetAvg == null ? 43 : $shipMetAvg.hashCode());
      Object $shipLength = this.getShipLength();
      result = result * 59 + ($shipLength == null ? 43 : $shipLength.hashCode());
      Object $shipArea = this.getShipArea();
      result = result * 59 + ($shipArea == null ? 43 : $shipArea.hashCode());
      Object $shipAmountTime = this.getShipAmountTime();
      result = result * 59 + ($shipAmountTime == null ? 43 : $shipAmountTime.hashCode());
      Object $shipMetTime = this.getShipMetTime();
      result = result * 59 + ($shipMetTime == null ? 43 : $shipMetTime.hashCode());
      Object $shipLengthTime = this.getShipLengthTime();
      result = result * 59 + ($shipLengthTime == null ? 43 : $shipLengthTime.hashCode());
      Object $shipAreaTime = this.getShipAreaTime();
      result = result * 59 + ($shipAreaTime == null ? 43 : $shipAreaTime.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      return result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
   }

   @Override
   public String toString() {
      return "BusinessShipCargoDTO(shipAmount="
         + this.getShipAmount()
         + ", shipMet="
         + this.getShipMet()
         + ", shipMetAvg="
         + this.getShipMetAvg()
         + ", shipLength="
         + this.getShipLength()
         + ", shipArea="
         + this.getShipArea()
         + ", shipAmountTime="
         + this.getShipAmountTime()
         + ", shipMetTime="
         + this.getShipMetTime()
         + ", shipLengthTime="
         + this.getShipLengthTime()
         + ", shipAreaTime="
         + this.getShipAreaTime()
         + ", cargoQuantity="
         + this.getCargoQuantity()
         + ", cargoQuantityTime="
         + this.getCargoQuantityTime()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ")";
   }

   public static class BusinessShipCargoDTOBuilder {
      private BigDecimal shipAmount;
      private BigDecimal shipMet;
      private BigDecimal shipMetAvg;
      private BigDecimal shipLength;
      private BigDecimal shipArea;
      private BigDecimal shipAmountTime;
      private BigDecimal shipMetTime;
      private BigDecimal shipLengthTime;
      private BigDecimal shipAreaTime;
      private Integer cargoQuantity;
      private Integer cargoQuantityTime;
      private LocalDateTime startDate;
      private LocalDateTime endDate;

      BusinessShipCargoDTOBuilder() {
      }

      public BusinessShipCargoDTO.BusinessShipCargoDTOBuilder shipAmount(final BigDecimal shipAmount) {
         this.shipAmount = shipAmount;
         return this;
      }

      public BusinessShipCargoDTO.BusinessShipCargoDTOBuilder shipMet(final BigDecimal shipMet) {
         this.shipMet = shipMet;
         return this;
      }

      public BusinessShipCargoDTO.BusinessShipCargoDTOBuilder shipMetAvg(final BigDecimal shipMetAvg) {
         this.shipMetAvg = shipMetAvg;
         return this;
      }

      public BusinessShipCargoDTO.BusinessShipCargoDTOBuilder shipLength(final BigDecimal shipLength) {
         this.shipLength = shipLength;
         return this;
      }

      public BusinessShipCargoDTO.BusinessShipCargoDTOBuilder shipArea(final BigDecimal shipArea) {
         this.shipArea = shipArea;
         return this;
      }

      public BusinessShipCargoDTO.BusinessShipCargoDTOBuilder shipAmountTime(final BigDecimal shipAmountTime) {
         this.shipAmountTime = shipAmountTime;
         return this;
      }

      public BusinessShipCargoDTO.BusinessShipCargoDTOBuilder shipMetTime(final BigDecimal shipMetTime) {
         this.shipMetTime = shipMetTime;
         return this;
      }

      public BusinessShipCargoDTO.BusinessShipCargoDTOBuilder shipLengthTime(final BigDecimal shipLengthTime) {
         this.shipLengthTime = shipLengthTime;
         return this;
      }

      public BusinessShipCargoDTO.BusinessShipCargoDTOBuilder shipAreaTime(final BigDecimal shipAreaTime) {
         this.shipAreaTime = shipAreaTime;
         return this;
      }

      public BusinessShipCargoDTO.BusinessShipCargoDTOBuilder cargoQuantity(final Integer cargoQuantity) {
         this.cargoQuantity = cargoQuantity;
         return this;
      }

      public BusinessShipCargoDTO.BusinessShipCargoDTOBuilder cargoQuantityTime(final Integer cargoQuantityTime) {
         this.cargoQuantityTime = cargoQuantityTime;
         return this;
      }

      public BusinessShipCargoDTO.BusinessShipCargoDTOBuilder startDate(final LocalDateTime startDate) {
         this.startDate = startDate;
         return this;
      }

      public BusinessShipCargoDTO.BusinessShipCargoDTOBuilder endDate(final LocalDateTime endDate) {
         this.endDate = endDate;
         return this;
      }

      public BusinessShipCargoDTO build() {
         return new BusinessShipCargoDTO(
            this.shipAmount,
            this.shipMet,
            this.shipMetAvg,
            this.shipLength,
            this.shipArea,
            this.shipAmountTime,
            this.shipMetTime,
            this.shipLengthTime,
            this.shipAreaTime,
            this.cargoQuantity,
            this.cargoQuantityTime,
            this.startDate,
            this.endDate
         );
      }

      @Override
      public String toString() {
         return "BusinessShipCargoDTO.BusinessShipCargoDTOBuilder(shipAmount="
            + this.shipAmount
            + ", shipMet="
            + this.shipMet
            + ", shipMetAvg="
            + this.shipMetAvg
            + ", shipLength="
            + this.shipLength
            + ", shipArea="
            + this.shipArea
            + ", shipAmountTime="
            + this.shipAmountTime
            + ", shipMetTime="
            + this.shipMetTime
            + ", shipLengthTime="
            + this.shipLengthTime
            + ", shipAreaTime="
            + this.shipAreaTime
            + ", cargoQuantity="
            + this.cargoQuantity
            + ", cargoQuantityTime="
            + this.cargoQuantityTime
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ")";
      }
   }
}
