package com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "物流信息")
public class CargoWeightDTO {
   @ApiModelProperty("id")
   private Integer id;
   @ApiModelProperty("设备id")
   private Integer deviceId;
   @ApiModelProperty("设备状态")
   private Integer commandType;
   @ApiModelProperty("时间戳")
   private Long timeStamp;
   @ApiModelProperty("重量")
   private BigDecimal weight;
   @ApiModelProperty("问题描述")
   private String message;

   public static CargoWeightDTO.CargoWeightDTOBuilder builder() {
      return new CargoWeightDTO.CargoWeightDTOBuilder();
   }

   public Integer getId() {
      return this.id;
   }

   public Integer getDeviceId() {
      return this.deviceId;
   }

   public Integer getCommandType() {
      return this.commandType;
   }

   public Long getTimeStamp() {
      return this.timeStamp;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public String getMessage() {
      return this.message;
   }

   public void setId(final Integer id) {
      this.id = id;
   }

   public void setDeviceId(final Integer deviceId) {
      this.deviceId = deviceId;
   }

   public void setCommandType(final Integer commandType) {
      this.commandType = commandType;
   }

   public void setTimeStamp(final Long timeStamp) {
      this.timeStamp = timeStamp;
   }

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   public void setMessage(final String message) {
      this.message = message;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoWeightDTO)) {
         return false;
      }

      CargoWeightDTO other = (CargoWeightDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$deviceId = this.getDeviceId();
         Object other$deviceId = other.getDeviceId();
         if (this$deviceId == null ? other$deviceId == null : this$deviceId.equals(other$deviceId)) {
            Object this$commandType = this.getCommandType();
            Object other$commandType = other.getCommandType();
            if (this$commandType == null ? other$commandType == null : this$commandType.equals(other$commandType)) {
               Object this$timeStamp = this.getTimeStamp();
               Object other$timeStamp = other.getTimeStamp();
               if (this$timeStamp == null ? other$timeStamp == null : this$timeStamp.equals(other$timeStamp)) {
                  Object this$weight = this.getWeight();
                  Object other$weight = other.getWeight();
                  if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                     Object this$message = this.getMessage();
                     Object other$message = other.getMessage();
                     return this$message == null ? other$message == null : this$message.equals(other$message);
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
      return other instanceof CargoWeightDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $deviceId = this.getDeviceId();
      result = result * 59 + ($deviceId == null ? 43 : $deviceId.hashCode());
      Object $commandType = this.getCommandType();
      result = result * 59 + ($commandType == null ? 43 : $commandType.hashCode());
      Object $timeStamp = this.getTimeStamp();
      result = result * 59 + ($timeStamp == null ? 43 : $timeStamp.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $message = this.getMessage();
      return result * 59 + ($message == null ? 43 : $message.hashCode());
   }

   @Override
   public String toString() {
      return "CargoWeightDTO(id="
         + this.getId()
         + ", deviceId="
         + this.getDeviceId()
         + ", commandType="
         + this.getCommandType()
         + ", timeStamp="
         + this.getTimeStamp()
         + ", weight="
         + this.getWeight()
         + ", message="
         + this.getMessage()
         + ")";
   }

   public CargoWeightDTO(
      final Integer id, final Integer deviceId, final Integer commandType, final Long timeStamp, final BigDecimal weight, final String message
   ) {
      this.id = id;
      this.deviceId = deviceId;
      this.commandType = commandType;
      this.timeStamp = timeStamp;
      this.weight = weight;
      this.message = message;
   }

   public CargoWeightDTO() {
   }

   public static class CargoWeightDTOBuilder {
      private Integer id;
      private Integer deviceId;
      private Integer commandType;
      private Long timeStamp;
      private BigDecimal weight;
      private String message;

      CargoWeightDTOBuilder() {
      }

      public CargoWeightDTO.CargoWeightDTOBuilder id(final Integer id) {
         this.id = id;
         return this;
      }

      public CargoWeightDTO.CargoWeightDTOBuilder deviceId(final Integer deviceId) {
         this.deviceId = deviceId;
         return this;
      }

      public CargoWeightDTO.CargoWeightDTOBuilder commandType(final Integer commandType) {
         this.commandType = commandType;
         return this;
      }

      public CargoWeightDTO.CargoWeightDTOBuilder timeStamp(final Long timeStamp) {
         this.timeStamp = timeStamp;
         return this;
      }

      public CargoWeightDTO.CargoWeightDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public CargoWeightDTO.CargoWeightDTOBuilder message(final String message) {
         this.message = message;
         return this;
      }

      public CargoWeightDTO build() {
         return new CargoWeightDTO(this.id, this.deviceId, this.commandType, this.timeStamp, this.weight, this.message);
      }

      @Override
      public String toString() {
         return "CargoWeightDTO.CargoWeightDTOBuilder(id="
            + this.id
            + ", deviceId="
            + this.deviceId
            + ", commandType="
            + this.commandType
            + ", timeStamp="
            + this.timeStamp
            + ", weight="
            + this.weight
            + ", message="
            + this.message
            + ")";
      }
   }
}
