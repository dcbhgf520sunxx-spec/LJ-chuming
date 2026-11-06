package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.cargoList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "空车过磅信息")
public class AppEmptyCarsWeighingDTO {
   @ApiModelProperty("发运id")
   private Long id;
   @ApiModelProperty("车牌号")
   private String licensePlate;
   @ApiModelProperty("司机姓名")
   private String driverName;
   @ApiModelProperty("司机电话")
   private String driverPhone;
   @ApiModelProperty("理论总净重")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "emptyCars", value = "空车重量 ", notes = "空车重量")
   private BigDecimal emptyCars;
   @ApiModelProperty("状态")
   private Integer status;

   public static AppEmptyCarsWeighingDTO.AppEmptyCarsWeighingDTOBuilder builder() {
      return new AppEmptyCarsWeighingDTO.AppEmptyCarsWeighingDTOBuilder();
   }

   public AppEmptyCarsWeighingDTO(
      final Long id,
      final String licensePlate,
      final String driverName,
      final String driverPhone,
      final BigDecimal totalNetWeight,
      final BigDecimal emptyCars,
      final Integer status
   ) {
      this.id = id;
      this.licensePlate = licensePlate;
      this.driverName = driverName;
      this.driverPhone = driverPhone;
      this.totalNetWeight = totalNetWeight;
      this.emptyCars = emptyCars;
      this.status = status;
   }

   public AppEmptyCarsWeighingDTO() {
   }

   public Long getId() {
      return this.id;
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

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getEmptyCars() {
      return this.emptyCars;
   }

   public Integer getStatus() {
      return this.status;
   }

   public AppEmptyCarsWeighingDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public AppEmptyCarsWeighingDTO setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
      return this;
   }

   public AppEmptyCarsWeighingDTO setDriverName(final String driverName) {
      this.driverName = driverName;
      return this;
   }

   public AppEmptyCarsWeighingDTO setDriverPhone(final String driverPhone) {
      this.driverPhone = driverPhone;
      return this;
   }

   public AppEmptyCarsWeighingDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   public AppEmptyCarsWeighingDTO setEmptyCars(final BigDecimal emptyCars) {
      this.emptyCars = emptyCars;
      return this;
   }

   public AppEmptyCarsWeighingDTO setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   @Override
   public String toString() {
      return "AppEmptyCarsWeighingDTO(id="
         + this.getId()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", driverName="
         + this.getDriverName()
         + ", driverPhone="
         + this.getDriverPhone()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", emptyCars="
         + this.getEmptyCars()
         + ", status="
         + this.getStatus()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AppEmptyCarsWeighingDTO)) {
         return false;
      }

      AppEmptyCarsWeighingDTO other = (AppEmptyCarsWeighingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$status = this.getStatus();
         Object other$status = other.getStatus();
         if (this$status == null ? other$status == null : this$status.equals(other$status)) {
            Object this$licensePlate = this.getLicensePlate();
            Object other$licensePlate = other.getLicensePlate();
            if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
               Object this$driverName = this.getDriverName();
               Object other$driverName = other.getDriverName();
               if (this$driverName == null ? other$driverName == null : this$driverName.equals(other$driverName)) {
                  Object this$driverPhone = this.getDriverPhone();
                  Object other$driverPhone = other.getDriverPhone();
                  if (this$driverPhone == null ? other$driverPhone == null : this$driverPhone.equals(other$driverPhone)) {
                     Object this$totalNetWeight = this.getTotalNetWeight();
                     Object other$totalNetWeight = other.getTotalNetWeight();
                     if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AppEmptyCarsWeighingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $driverName = this.getDriverName();
      result = result * 59 + ($driverName == null ? 43 : $driverName.hashCode());
      Object $driverPhone = this.getDriverPhone();
      result = result * 59 + ($driverPhone == null ? 43 : $driverPhone.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $emptyCars = this.getEmptyCars();
      return result * 59 + ($emptyCars == null ? 43 : $emptyCars.hashCode());
   }

   public static class AppEmptyCarsWeighingDTOBuilder {
      private Long id;
      private String licensePlate;
      private String driverName;
      private String driverPhone;
      private BigDecimal totalNetWeight;
      private BigDecimal emptyCars;
      private Integer status;

      AppEmptyCarsWeighingDTOBuilder() {
      }

      public AppEmptyCarsWeighingDTO.AppEmptyCarsWeighingDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public AppEmptyCarsWeighingDTO.AppEmptyCarsWeighingDTOBuilder licensePlate(final String licensePlate) {
         this.licensePlate = licensePlate;
         return this;
      }

      public AppEmptyCarsWeighingDTO.AppEmptyCarsWeighingDTOBuilder driverName(final String driverName) {
         this.driverName = driverName;
         return this;
      }

      public AppEmptyCarsWeighingDTO.AppEmptyCarsWeighingDTOBuilder driverPhone(final String driverPhone) {
         this.driverPhone = driverPhone;
         return this;
      }

      public AppEmptyCarsWeighingDTO.AppEmptyCarsWeighingDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public AppEmptyCarsWeighingDTO.AppEmptyCarsWeighingDTOBuilder emptyCars(final BigDecimal emptyCars) {
         this.emptyCars = emptyCars;
         return this;
      }

      public AppEmptyCarsWeighingDTO.AppEmptyCarsWeighingDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public AppEmptyCarsWeighingDTO build() {
         return new AppEmptyCarsWeighingDTO(this.id, this.licensePlate, this.driverName, this.driverPhone, this.totalNetWeight, this.emptyCars, this.status);
      }

      @Override
      public String toString() {
         return "AppEmptyCarsWeighingDTO.AppEmptyCarsWeighingDTOBuilder(id="
            + this.id
            + ", licensePlate="
            + this.licensePlate
            + ", driverName="
            + this.driverName
            + ", driverPhone="
            + this.driverPhone
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", emptyCars="
            + this.emptyCars
            + ", status="
            + this.status
            + ")";
      }
   }
}
