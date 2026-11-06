package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task.app;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AppTaskProcessArtifactNumberDTO", description = "构件一物一码信息 ")
public class AppTaskProcessArtifactNumberDTO {
   @ApiModelProperty(name = "number", notes = "一物一码编号")
   @JsonProperty("number")
   @JSONField(name = "number")
   private Integer number;
   @ApiModelProperty(name = "serialNumber", notes = "构件编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;

   public static AppTaskProcessArtifactNumberDTO.AppTaskProcessArtifactNumberDTOBuilder builder() {
      return new AppTaskProcessArtifactNumberDTO.AppTaskProcessArtifactNumberDTOBuilder();
   }

   public AppTaskProcessArtifactNumberDTO() {
   }

   public AppTaskProcessArtifactNumberDTO(final Integer number, final String serialNumber) {
      this.number = number;
      this.serialNumber = serialNumber;
   }

   public Integer getNumber() {
      return this.number;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   @JsonProperty("number")
   public AppTaskProcessArtifactNumberDTO setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   @JsonProperty("serialNumber")
   public AppTaskProcessArtifactNumberDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @Override
   public String toString() {
      return "AppTaskProcessArtifactNumberDTO(number=" + this.getNumber() + ", serialNumber=" + this.getSerialNumber() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AppTaskProcessArtifactNumberDTO)) {
         return false;
      } else {
         AppTaskProcessArtifactNumberDTO other = (AppTaskProcessArtifactNumberDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$number = this.getNumber();
            Object other$number = other.getNumber();
            if (this$number == null ? other$number == null : this$number.equals(other$number)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               return this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AppTaskProcessArtifactNumberDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }

   public static class AppTaskProcessArtifactNumberDTOBuilder {
      private Integer number;
      private String serialNumber;

      AppTaskProcessArtifactNumberDTOBuilder() {
      }

      @JsonProperty("number")
      public AppTaskProcessArtifactNumberDTO.AppTaskProcessArtifactNumberDTOBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      @JsonProperty("serialNumber")
      public AppTaskProcessArtifactNumberDTO.AppTaskProcessArtifactNumberDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public AppTaskProcessArtifactNumberDTO build() {
         return new AppTaskProcessArtifactNumberDTO(this.number, this.serialNumber);
      }

      @Override
      public String toString() {
         return "AppTaskProcessArtifactNumberDTO.AppTaskProcessArtifactNumberDTOBuilder(number=" + this.number + ", serialNumber=" + this.serialNumber + ")";
      }
   }
}
