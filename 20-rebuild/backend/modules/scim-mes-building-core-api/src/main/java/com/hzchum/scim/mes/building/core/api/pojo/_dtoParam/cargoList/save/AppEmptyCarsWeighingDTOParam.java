package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.save;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Delete;
import com.hzchum.pangu.common.valid.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@ApiModel(description = "空车过磅信息")
public class AppEmptyCarsWeighingDTOParam {
   @ApiModelProperty("发运id")
   @NotNull(message = "发运id不能为空", groups = {Update.class, Delete.class})
   private Long id;
   @ApiModelProperty("车牌号/船号")
   @NotBlank(message = "车牌号/船号不能为空", groups = {Add.class, Update.class})
   private String licensePlate;
   @ApiModelProperty("设备id")
   private Long deviceId;
   @ApiModelProperty("司机姓名")
   @NotBlank(message = "司机姓名不能为空", groups = {Add.class, Update.class})
   private String driverName;
   @ApiModelProperty("司机电话")
   @NotBlank(message = "司机电话不能为空", groups = {Add.class, Update.class})
   @Pattern(regexp = "((13[0-9])|(14[0-9])|(15[0-9])|(16[0-9])|(17[0-9])|(18[0-9])|(19[0-9]))\\d{8}$", groups = {Add.class, Update.class})
   private String driverPhone;
   @ApiModelProperty(name = "emptyCars", value = "空车重量 ", notes = "空车重量")
   private BigDecimal emptyCars;
   @ApiModelProperty("运输工具类型")
   private Integer meansConveyanceEnum;

   public Long getId() {
      return this.id;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public Long getDeviceId() {
      return this.deviceId;
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

   public void setId(final Long id) {
      this.id = id;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setDeviceId(final Long deviceId) {
      this.deviceId = deviceId;
   }

   public void setDriverName(final String driverName) {
      this.driverName = driverName;
   }

   public void setDriverPhone(final String driverPhone) {
      this.driverPhone = driverPhone;
   }

   public void setEmptyCars(final BigDecimal emptyCars) {
      this.emptyCars = emptyCars;
   }

   public void setMeansConveyanceEnum(final Integer meansConveyanceEnum) {
      this.meansConveyanceEnum = meansConveyanceEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AppEmptyCarsWeighingDTOParam)) {
         return false;
      }

      AppEmptyCarsWeighingDTOParam other = (AppEmptyCarsWeighingDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$deviceId = this.getDeviceId();
         Object other$deviceId = other.getDeviceId();
         if (this$deviceId == null ? other$deviceId == null : this$deviceId.equals(other$deviceId)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AppEmptyCarsWeighingDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $deviceId = this.getDeviceId();
      result = result * 59 + ($deviceId == null ? 43 : $deviceId.hashCode());
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

   @Override
   public String toString() {
      return "AppEmptyCarsWeighingDTOParam(id="
         + this.getId()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", deviceId="
         + this.getDeviceId()
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
}
