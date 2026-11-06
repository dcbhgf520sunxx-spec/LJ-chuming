package com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "实时发运信息")
public class CargoRealtimeInfoDTO {
   @ApiModelProperty(name = "date", value = "日期")
   @JsonProperty("date")
   @JSONField(name = "date")
   private String date;
   @ApiModelProperty(name = "serialNumber", notes = "项目编号", value = "项目编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String projectName;
   @ApiModelProperty(name = "licensePlate", value = "车牌")
   @JsonProperty("licensePlate")
   @JSONField(name = "licensePlate")
   private String licensePlate;
   @ApiModelProperty(name = "status", value = "项目状态")
   @JsonProperty("status")
   @JSONField(name = "status")
   private Integer status;
   @ApiModelProperty(name = "statusName", value = "项目状态")
   @JsonProperty("statusName")
   @JSONField(name = "statusName")
   private String statusName;

   public static CargoRealtimeInfoDTO.CargoRealtimeInfoDTOBuilder builder() {
      return new CargoRealtimeInfoDTO.CargoRealtimeInfoDTOBuilder();
   }

   public String getDate() {
      return this.date;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public Integer getStatus() {
      return this.status;
   }

   public String getStatusName() {
      return this.statusName;
   }

   @JsonProperty("date")
   public void setDate(final String date) {
      this.date = date;
   }

   @JsonProperty("serialNumber")
   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   @JsonProperty("licensePlate")
   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   @JsonProperty("status")
   public void setStatus(final Integer status) {
      this.status = status;
   }

   @JsonProperty("statusName")
   public void setStatusName(final String statusName) {
      this.statusName = statusName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoRealtimeInfoDTO)) {
         return false;
      }

      CargoRealtimeInfoDTO other = (CargoRealtimeInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$status = this.getStatus();
      Object other$status = other.getStatus();
      if (this$status == null ? other$status == null : this$status.equals(other$status)) {
         Object this$date = this.getDate();
         Object other$date = other.getDate();
         if (this$date == null ? other$date == null : this$date.equals(other$date)) {
            Object this$projectName = this.getProjectName();
            Object other$projectName = other.getProjectName();
            if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
               Object this$licensePlate = this.getLicensePlate();
               Object other$licensePlate = other.getLicensePlate();
               if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                  Object this$statusName = this.getStatusName();
                  Object other$statusName = other.getStatusName();
                  return this$statusName == null ? other$statusName == null : this$statusName.equals(other$statusName);
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
      return other instanceof CargoRealtimeInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $statusName = this.getStatusName();
      return result * 59 + ($statusName == null ? 43 : $statusName.hashCode());
   }

   @Override
   public String toString() {
      return "CargoRealtimeInfoDTO(super="
         + super.toString()
         + ", date="
         + this.getDate()
         + ", projectName="
         + this.getProjectName()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", status="
         + this.getStatus()
         + ", statusName="
         + this.getStatusName()
         + ")";
   }

   public CargoRealtimeInfoDTO(final String date, final String projectName, final String licensePlate, final Integer status, final String statusName) {
      this.date = date;
      this.projectName = projectName;
      this.licensePlate = licensePlate;
      this.status = status;
      this.statusName = statusName;
   }

   public CargoRealtimeInfoDTO() {
   }

   public static class CargoRealtimeInfoDTOBuilder {
      private String date;
      private String projectName;
      private String licensePlate;
      private Integer status;
      private String statusName;

      CargoRealtimeInfoDTOBuilder() {
      }

      @JsonProperty("date")
      public CargoRealtimeInfoDTO.CargoRealtimeInfoDTOBuilder date(final String date) {
         this.date = date;
         return this;
      }

      @JsonProperty("serialNumber")
      public CargoRealtimeInfoDTO.CargoRealtimeInfoDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      @JsonProperty("licensePlate")
      public CargoRealtimeInfoDTO.CargoRealtimeInfoDTOBuilder licensePlate(final String licensePlate) {
         this.licensePlate = licensePlate;
         return this;
      }

      @JsonProperty("status")
      public CargoRealtimeInfoDTO.CargoRealtimeInfoDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      @JsonProperty("statusName")
      public CargoRealtimeInfoDTO.CargoRealtimeInfoDTOBuilder statusName(final String statusName) {
         this.statusName = statusName;
         return this;
      }

      public CargoRealtimeInfoDTO build() {
         return new CargoRealtimeInfoDTO(this.date, this.projectName, this.licensePlate, this.status, this.statusName);
      }

      @Override
      public String toString() {
         return "CargoRealtimeInfoDTO.CargoRealtimeInfoDTOBuilder(date="
            + this.date
            + ", projectName="
            + this.projectName
            + ", licensePlate="
            + this.licensePlate
            + ", status="
            + this.status
            + ", statusName="
            + this.statusName
            + ")";
      }
   }
}
