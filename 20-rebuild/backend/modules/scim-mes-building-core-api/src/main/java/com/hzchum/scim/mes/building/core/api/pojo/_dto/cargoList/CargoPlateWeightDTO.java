package com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "过磅采集的数据")
public class CargoPlateWeightDTO {
   @ApiModelProperty("编号")
   private Long id;
   @ApiModelProperty("司机名称")
   private String name;
   @ApiModelProperty("司机电话")
   private String phone;
   @ApiModelProperty("流水号")
   private String serialNumber;
   @ApiModelProperty("⻋牌号app接收使用")
   private String carNumber;
   @ApiModelProperty("⻋牌号app使用")
   private String plateNum;
   @ApiModelProperty("皮重")
   private BigDecimal tareWeight;
   @ApiModelProperty("毛重 app接收使用")
   private BigDecimal grossWeight;
   @ApiModelProperty("毛重 app使用")
   private BigDecimal roughWeight;
   @ApiModelProperty("实际重毛重接收使用")
   private BigDecimal weight;
   private String updateTime;

   public static CargoPlateWeightDTO.CargoPlateWeightDTOBuilder builder() {
      return new CargoPlateWeightDTO.CargoPlateWeightDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getPhone() {
      return this.phone;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getCarNumber() {
      return this.carNumber;
   }

   public String getPlateNum() {
      return this.plateNum;
   }

   public BigDecimal getTareWeight() {
      return this.tareWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getRoughWeight() {
      return this.roughWeight;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public String getUpdateTime() {
      return this.updateTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setPhone(final String phone) {
      this.phone = phone;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setCarNumber(final String carNumber) {
      this.carNumber = carNumber;
   }

   public void setPlateNum(final String plateNum) {
      this.plateNum = plateNum;
   }

   public void setTareWeight(final BigDecimal tareWeight) {
      this.tareWeight = tareWeight;
   }

   public void setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
   }

   public void setRoughWeight(final BigDecimal roughWeight) {
      this.roughWeight = roughWeight;
   }

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   public void setUpdateTime(final String updateTime) {
      this.updateTime = updateTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoPlateWeightDTO)) {
         return false;
      }

      CargoPlateWeightDTO other = (CargoPlateWeightDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$phone = this.getPhone();
            Object other$phone = other.getPhone();
            if (this$phone == null ? other$phone == null : this$phone.equals(other$phone)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$carNumber = this.getCarNumber();
                  Object other$carNumber = other.getCarNumber();
                  if (this$carNumber == null ? other$carNumber == null : this$carNumber.equals(other$carNumber)) {
                     Object this$plateNum = this.getPlateNum();
                     Object other$plateNum = other.getPlateNum();
                     if (this$plateNum == null ? other$plateNum == null : this$plateNum.equals(other$plateNum)) {
                        Object this$tareWeight = this.getTareWeight();
                        Object other$tareWeight = other.getTareWeight();
                        if (this$tareWeight == null ? other$tareWeight == null : this$tareWeight.equals(other$tareWeight)) {
                           Object this$grossWeight = this.getGrossWeight();
                           Object other$grossWeight = other.getGrossWeight();
                           if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                              Object this$roughWeight = this.getRoughWeight();
                              Object other$roughWeight = other.getRoughWeight();
                              if (this$roughWeight == null ? other$roughWeight == null : this$roughWeight.equals(other$roughWeight)) {
                                 Object this$weight = this.getWeight();
                                 Object other$weight = other.getWeight();
                                 if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                    Object this$updateTime = this.getUpdateTime();
                                    Object other$updateTime = other.getUpdateTime();
                                    return this$updateTime == null ? other$updateTime == null : this$updateTime.equals(other$updateTime);
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
      return other instanceof CargoPlateWeightDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $phone = this.getPhone();
      result = result * 59 + ($phone == null ? 43 : $phone.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $carNumber = this.getCarNumber();
      result = result * 59 + ($carNumber == null ? 43 : $carNumber.hashCode());
      Object $plateNum = this.getPlateNum();
      result = result * 59 + ($plateNum == null ? 43 : $plateNum.hashCode());
      Object $tareWeight = this.getTareWeight();
      result = result * 59 + ($tareWeight == null ? 43 : $tareWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $roughWeight = this.getRoughWeight();
      result = result * 59 + ($roughWeight == null ? 43 : $roughWeight.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $updateTime = this.getUpdateTime();
      return result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
   }

   @Override
   public String toString() {
      return "CargoPlateWeightDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", phone="
         + this.getPhone()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", carNumber="
         + this.getCarNumber()
         + ", plateNum="
         + this.getPlateNum()
         + ", tareWeight="
         + this.getTareWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", roughWeight="
         + this.getRoughWeight()
         + ", weight="
         + this.getWeight()
         + ", updateTime="
         + this.getUpdateTime()
         + ")";
   }

   public CargoPlateWeightDTO(
      final Long id,
      final String name,
      final String phone,
      final String serialNumber,
      final String carNumber,
      final String plateNum,
      final BigDecimal tareWeight,
      final BigDecimal grossWeight,
      final BigDecimal roughWeight,
      final BigDecimal weight,
      final String updateTime
   ) {
      this.id = id;
      this.name = name;
      this.phone = phone;
      this.serialNumber = serialNumber;
      this.carNumber = carNumber;
      this.plateNum = plateNum;
      this.tareWeight = tareWeight;
      this.grossWeight = grossWeight;
      this.roughWeight = roughWeight;
      this.weight = weight;
      this.updateTime = updateTime;
   }

   public CargoPlateWeightDTO() {
   }

   public static class CargoPlateWeightDTOBuilder {
      private Long id;
      private String name;
      private String phone;
      private String serialNumber;
      private String carNumber;
      private String plateNum;
      private BigDecimal tareWeight;
      private BigDecimal grossWeight;
      private BigDecimal roughWeight;
      private BigDecimal weight;
      private String updateTime;

      CargoPlateWeightDTOBuilder() {
      }

      public CargoPlateWeightDTO.CargoPlateWeightDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CargoPlateWeightDTO.CargoPlateWeightDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public CargoPlateWeightDTO.CargoPlateWeightDTOBuilder phone(final String phone) {
         this.phone = phone;
         return this;
      }

      public CargoPlateWeightDTO.CargoPlateWeightDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public CargoPlateWeightDTO.CargoPlateWeightDTOBuilder carNumber(final String carNumber) {
         this.carNumber = carNumber;
         return this;
      }

      public CargoPlateWeightDTO.CargoPlateWeightDTOBuilder plateNum(final String plateNum) {
         this.plateNum = plateNum;
         return this;
      }

      public CargoPlateWeightDTO.CargoPlateWeightDTOBuilder tareWeight(final BigDecimal tareWeight) {
         this.tareWeight = tareWeight;
         return this;
      }

      public CargoPlateWeightDTO.CargoPlateWeightDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public CargoPlateWeightDTO.CargoPlateWeightDTOBuilder roughWeight(final BigDecimal roughWeight) {
         this.roughWeight = roughWeight;
         return this;
      }

      public CargoPlateWeightDTO.CargoPlateWeightDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public CargoPlateWeightDTO.CargoPlateWeightDTOBuilder updateTime(final String updateTime) {
         this.updateTime = updateTime;
         return this;
      }

      public CargoPlateWeightDTO build() {
         return new CargoPlateWeightDTO(
            this.id,
            this.name,
            this.phone,
            this.serialNumber,
            this.carNumber,
            this.plateNum,
            this.tareWeight,
            this.grossWeight,
            this.roughWeight,
            this.weight,
            this.updateTime
         );
      }

      @Override
      public String toString() {
         return "CargoPlateWeightDTO.CargoPlateWeightDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", phone="
            + this.phone
            + ", serialNumber="
            + this.serialNumber
            + ", carNumber="
            + this.carNumber
            + ", plateNum="
            + this.plateNum
            + ", tareWeight="
            + this.tareWeight
            + ", grossWeight="
            + this.grossWeight
            + ", roughWeight="
            + this.roughWeight
            + ", weight="
            + this.weight
            + ", updateTime="
            + this.updateTime
            + ")";
      }
   }
}
