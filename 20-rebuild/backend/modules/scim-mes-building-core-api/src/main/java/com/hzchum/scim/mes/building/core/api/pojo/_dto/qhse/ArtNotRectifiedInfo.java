package com.hzchum.scim.mes.building.core.api.pojo._dto.qhse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class ArtNotRectifiedInfo {
   @ApiModelProperty(name = "serialNumber", value = "构件编号", notes = "构件编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "number", value = "码号", notes = "码号")
   @JsonProperty("number")
   @JSONField(name = "number")
   private String number;

   public static ArtNotRectifiedInfo.ArtNotRectifiedInfoBuilder builder() {
      return new ArtNotRectifiedInfo.ArtNotRectifiedInfoBuilder();
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getNumber() {
      return this.number;
   }

   @JsonProperty("serialNumber")
   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @JsonProperty("number")
   public void setNumber(final String number) {
      this.number = number;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ArtNotRectifiedInfo)) {
         return false;
      } else {
         ArtNotRectifiedInfo other = (ArtNotRectifiedInfo)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$serialNumber = this.getSerialNumber();
            Object other$serialNumber = other.getSerialNumber();
            if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
               Object this$number = this.getNumber();
               Object other$number = other.getNumber();
               return this$number == null ? other$number == null : this$number.equals(other$number);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ArtNotRectifiedInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $number = this.getNumber();
      return result * 59 + ($number == null ? 43 : $number.hashCode());
   }

   @Override
   public String toString() {
      return "ArtNotRectifiedInfo(serialNumber=" + this.getSerialNumber() + ", number=" + this.getNumber() + ")";
   }

   public ArtNotRectifiedInfo(final String serialNumber, final String number) {
      this.serialNumber = serialNumber;
      this.number = number;
   }

   public ArtNotRectifiedInfo() {
   }

   public static class ArtNotRectifiedInfoBuilder {
      private String serialNumber;
      private String number;

      ArtNotRectifiedInfoBuilder() {
      }

      @JsonProperty("serialNumber")
      public ArtNotRectifiedInfo.ArtNotRectifiedInfoBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("number")
      public ArtNotRectifiedInfo.ArtNotRectifiedInfoBuilder number(final String number) {
         this.number = number;
         return this;
      }

      public ArtNotRectifiedInfo build() {
         return new ArtNotRectifiedInfo(this.serialNumber, this.number);
      }

      @Override
      public String toString() {
         return "ArtNotRectifiedInfo.ArtNotRectifiedInfoBuilder(serialNumber=" + this.serialNumber + ", number=" + this.number + ")";
      }
   }
}
