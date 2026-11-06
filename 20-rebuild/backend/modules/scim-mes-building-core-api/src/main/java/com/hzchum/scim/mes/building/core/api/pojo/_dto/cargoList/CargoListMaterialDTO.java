package com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "过磅采集的数据")
public class CargoListMaterialDTO {
   @ApiModelProperty("进出场类型")
   private Integer inOutType;
   @ApiModelProperty("⻋牌号")
   private String plateNum;
   @ApiModelProperty("毛重")
   private BigDecimal roughWeight;
   @ApiModelProperty("净重")
   private BigDecimal netWeight;
   @ApiModelProperty("皮重")
   private BigDecimal tareWeight;
   @ApiModelProperty("称重时间")
   private String weightTime;

   public static CargoListMaterialDTO.CargoListMaterialDTOBuilder builder() {
      return new CargoListMaterialDTO.CargoListMaterialDTOBuilder();
   }

   public Integer getInOutType() {
      return this.inOutType;
   }

   public String getPlateNum() {
      return this.plateNum;
   }

   public BigDecimal getRoughWeight() {
      return this.roughWeight;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getTareWeight() {
      return this.tareWeight;
   }

   public String getWeightTime() {
      return this.weightTime;
   }

   public void setInOutType(final Integer inOutType) {
      this.inOutType = inOutType;
   }

   public void setPlateNum(final String plateNum) {
      this.plateNum = plateNum;
   }

   public void setRoughWeight(final BigDecimal roughWeight) {
      this.roughWeight = roughWeight;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setTareWeight(final BigDecimal tareWeight) {
      this.tareWeight = tareWeight;
   }

   public void setWeightTime(final String weightTime) {
      this.weightTime = weightTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListMaterialDTO)) {
         return false;
      }

      CargoListMaterialDTO other = (CargoListMaterialDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$inOutType = this.getInOutType();
      Object other$inOutType = other.getInOutType();
      if (this$inOutType == null ? other$inOutType == null : this$inOutType.equals(other$inOutType)) {
         Object this$plateNum = this.getPlateNum();
         Object other$plateNum = other.getPlateNum();
         if (this$plateNum == null ? other$plateNum == null : this$plateNum.equals(other$plateNum)) {
            Object this$roughWeight = this.getRoughWeight();
            Object other$roughWeight = other.getRoughWeight();
            if (this$roughWeight == null ? other$roughWeight == null : this$roughWeight.equals(other$roughWeight)) {
               Object this$netWeight = this.getNetWeight();
               Object other$netWeight = other.getNetWeight();
               if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                  Object this$tareWeight = this.getTareWeight();
                  Object other$tareWeight = other.getTareWeight();
                  if (this$tareWeight == null ? other$tareWeight == null : this$tareWeight.equals(other$tareWeight)) {
                     Object this$weightTime = this.getWeightTime();
                     Object other$weightTime = other.getWeightTime();
                     return this$weightTime == null ? other$weightTime == null : this$weightTime.equals(other$weightTime);
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
      return other instanceof CargoListMaterialDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $inOutType = this.getInOutType();
      result = result * 59 + ($inOutType == null ? 43 : $inOutType.hashCode());
      Object $plateNum = this.getPlateNum();
      result = result * 59 + ($plateNum == null ? 43 : $plateNum.hashCode());
      Object $roughWeight = this.getRoughWeight();
      result = result * 59 + ($roughWeight == null ? 43 : $roughWeight.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $tareWeight = this.getTareWeight();
      result = result * 59 + ($tareWeight == null ? 43 : $tareWeight.hashCode());
      Object $weightTime = this.getWeightTime();
      return result * 59 + ($weightTime == null ? 43 : $weightTime.hashCode());
   }

   @Override
   public String toString() {
      return "CargoListMaterialDTO(inOutType="
         + this.getInOutType()
         + ", plateNum="
         + this.getPlateNum()
         + ", roughWeight="
         + this.getRoughWeight()
         + ", netWeight="
         + this.getNetWeight()
         + ", tareWeight="
         + this.getTareWeight()
         + ", weightTime="
         + this.getWeightTime()
         + ")";
   }

   public CargoListMaterialDTO(
      final Integer inOutType,
      final String plateNum,
      final BigDecimal roughWeight,
      final BigDecimal netWeight,
      final BigDecimal tareWeight,
      final String weightTime
   ) {
      this.inOutType = inOutType;
      this.plateNum = plateNum;
      this.roughWeight = roughWeight;
      this.netWeight = netWeight;
      this.tareWeight = tareWeight;
      this.weightTime = weightTime;
   }

   public CargoListMaterialDTO() {
   }

   public static class CargoListMaterialDTOBuilder {
      private Integer inOutType;
      private String plateNum;
      private BigDecimal roughWeight;
      private BigDecimal netWeight;
      private BigDecimal tareWeight;
      private String weightTime;

      CargoListMaterialDTOBuilder() {
      }

      public CargoListMaterialDTO.CargoListMaterialDTOBuilder inOutType(final Integer inOutType) {
         this.inOutType = inOutType;
         return this;
      }

      public CargoListMaterialDTO.CargoListMaterialDTOBuilder plateNum(final String plateNum) {
         this.plateNum = plateNum;
         return this;
      }

      public CargoListMaterialDTO.CargoListMaterialDTOBuilder roughWeight(final BigDecimal roughWeight) {
         this.roughWeight = roughWeight;
         return this;
      }

      public CargoListMaterialDTO.CargoListMaterialDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public CargoListMaterialDTO.CargoListMaterialDTOBuilder tareWeight(final BigDecimal tareWeight) {
         this.tareWeight = tareWeight;
         return this;
      }

      public CargoListMaterialDTO.CargoListMaterialDTOBuilder weightTime(final String weightTime) {
         this.weightTime = weightTime;
         return this;
      }

      public CargoListMaterialDTO build() {
         return new CargoListMaterialDTO(this.inOutType, this.plateNum, this.roughWeight, this.netWeight, this.tareWeight, this.weightTime);
      }

      @Override
      public String toString() {
         return "CargoListMaterialDTO.CargoListMaterialDTOBuilder(inOutType="
            + this.inOutType
            + ", plateNum="
            + this.plateNum
            + ", roughWeight="
            + this.roughWeight
            + ", netWeight="
            + this.netWeight
            + ", tareWeight="
            + this.tareWeight
            + ", weightTime="
            + this.weightTime
            + ")";
      }
   }
}
