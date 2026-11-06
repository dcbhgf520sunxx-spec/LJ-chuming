package com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "司机和车牌信息")
public class CargoListDriverDTO {
   @ApiModelProperty(name = "licensePlate", value = "车牌号", notes = "车牌号")
   private String licensePlate;
   @ApiModelProperty(name = "driverName", value = "司机姓名", notes = "司机姓名")
   private String driverName;
   @ApiModelProperty(name = "driverPhone", value = "司机电话", notes = "司机电话")
   private String driverPhone;
   @ApiModelProperty(name = "emptyCars", value = "空车重量 ", notes = "空车重量")
   private BigDecimal emptyCars;
   @ApiModelProperty("运输工具类型")
   private Integer meansConveyanceEnum;

   public static CargoListDriverDTO.CargoListDriverDTOBuilder builder() {
      return new CargoListDriverDTO.CargoListDriverDTOBuilder();
   }

   public CargoListDriverDTO(
      final String licensePlate, final String driverName, final String driverPhone, final BigDecimal emptyCars, final Integer meansConveyanceEnum
   ) {
      this.licensePlate = licensePlate;
      this.driverName = driverName;
      this.driverPhone = driverPhone;
      this.emptyCars = emptyCars;
      this.meansConveyanceEnum = meansConveyanceEnum;
   }

   public CargoListDriverDTO() {
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public String getDriverName() {
      return this.driverName;
   }

   public String getDriverPhone() {
      return this.driverPhone;
   }

   public BigDecimal getEmptyCars() {
      return this.emptyCars;
   }

   public Integer getMeansConveyanceEnum() {
      return this.meansConveyanceEnum;
   }

   public CargoListDriverDTO setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
      return this;
   }

   public CargoListDriverDTO setDriverName(final String driverName) {
      this.driverName = driverName;
      return this;
   }

   public CargoListDriverDTO setDriverPhone(final String driverPhone) {
      this.driverPhone = driverPhone;
      return this;
   }

   public CargoListDriverDTO setEmptyCars(final BigDecimal emptyCars) {
      this.emptyCars = emptyCars;
      return this;
   }

   public CargoListDriverDTO setMeansConveyanceEnum(final Integer meansConveyanceEnum) {
      this.meansConveyanceEnum = meansConveyanceEnum;
      return this;
   }

   @Override
   public String toString() {
      return "CargoListDriverDTO(licensePlate="
         + this.getLicensePlate()
         + ", driverName="
         + this.getDriverName()
         + ", driverPhone="
         + this.getDriverPhone()
         + ", emptyCars="
         + this.getEmptyCars()
         + ", meansConveyanceEnum="
         + this.getMeansConveyanceEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListDriverDTO)) {
         return false;
      }

      CargoListDriverDTO other = (CargoListDriverDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$meansConveyanceEnum = this.getMeansConveyanceEnum();
      Object other$meansConveyanceEnum = other.getMeansConveyanceEnum();
      if (this$meansConveyanceEnum == null ? other$meansConveyanceEnum == null : this$meansConveyanceEnum.equals(other$meansConveyanceEnum)) {
         Object this$licensePlate = this.getLicensePlate();
         Object other$licensePlate = other.getLicensePlate();
         if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
            Object this$driverName = this.getDriverName();
            Object other$driverName = other.getDriverName();
            if (this$driverName == null ? other$driverName == null : this$driverName.equals(other$driverName)) {
               Object this$driverPhone = this.getDriverPhone();
               Object other$driverPhone = other.getDriverPhone();
               if (this$driverPhone == null ? other$driverPhone == null : this$driverPhone.equals(other$driverPhone)) {
                  Object this$emptyCars = this.getEmptyCars();
                  Object other$emptyCars = other.getEmptyCars();
                  return this$emptyCars == null ? other$emptyCars == null : this$emptyCars.equals(other$emptyCars);
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
      return other instanceof CargoListDriverDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $meansConveyanceEnum = this.getMeansConveyanceEnum();
      result = result * 59 + ($meansConveyanceEnum == null ? 43 : $meansConveyanceEnum.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $driverName = this.getDriverName();
      result = result * 59 + ($driverName == null ? 43 : $driverName.hashCode());
      Object $driverPhone = this.getDriverPhone();
      result = result * 59 + ($driverPhone == null ? 43 : $driverPhone.hashCode());
      Object $emptyCars = this.getEmptyCars();
      return result * 59 + ($emptyCars == null ? 43 : $emptyCars.hashCode());
   }

   public static class CargoListDriverDTOBuilder {
      private String licensePlate;
      private String driverName;
      private String driverPhone;
      private BigDecimal emptyCars;
      private Integer meansConveyanceEnum;

      CargoListDriverDTOBuilder() {
      }

      public CargoListDriverDTO.CargoListDriverDTOBuilder licensePlate(final String licensePlate) {
         this.licensePlate = licensePlate;
         return this;
      }

      public CargoListDriverDTO.CargoListDriverDTOBuilder driverName(final String driverName) {
         this.driverName = driverName;
         return this;
      }

      public CargoListDriverDTO.CargoListDriverDTOBuilder driverPhone(final String driverPhone) {
         this.driverPhone = driverPhone;
         return this;
      }

      public CargoListDriverDTO.CargoListDriverDTOBuilder emptyCars(final BigDecimal emptyCars) {
         this.emptyCars = emptyCars;
         return this;
      }

      public CargoListDriverDTO.CargoListDriverDTOBuilder meansConveyanceEnum(final Integer meansConveyanceEnum) {
         this.meansConveyanceEnum = meansConveyanceEnum;
         return this;
      }

      public CargoListDriverDTO build() {
         return new CargoListDriverDTO(this.licensePlate, this.driverName, this.driverPhone, this.emptyCars, this.meansConveyanceEnum);
      }

      @Override
      public String toString() {
         return "CargoListDriverDTO.CargoListDriverDTOBuilder(licensePlate="
            + this.licensePlate
            + ", driverName="
            + this.driverName
            + ", driverPhone="
            + this.driverPhone
            + ", emptyCars="
            + this.emptyCars
            + ", meansConveyanceEnum="
            + this.meansConveyanceEnum
            + ")";
      }
   }
}
