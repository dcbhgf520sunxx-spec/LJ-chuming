package com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "今日上报问题列表")
public class InspectToDayListDTO {
   @ApiModelProperty(name = "time", notes = "时间", value = "时间")
   @JsonProperty("time")
   @JSONField(name = "time")
   private String time;
   @ApiModelProperty(name = "workShopName", notes = "车间名称", value = "车间名称")
   @JsonProperty("workShopName")
   @JSONField(name = "workShopName")
   private String workShopName;
   @ApiModelProperty(name = "teamName", notes = "班组名称", value = "班组名称")
   @JsonProperty("teamName")
   @JSONField(name = "teamName")
   private String teamName;
   @ApiModelProperty(name = "processName", notes = "工序名称", value = "工序名称")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "projectName", notes = "项目名称", value = "项目名称")
   @JsonProperty("projectName")
   @JSONField(name = "projectName")
   private String projectName;
   @ApiModelProperty(name = "serialNumber", notes = "编号", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "quantity", notes = "数量", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private String quantity;

   public static InspectToDayListDTO.InspectToDayListDTOBuilder builder() {
      return new InspectToDayListDTO.InspectToDayListDTOBuilder();
   }

   public String getTime() {
      return this.time;
   }

   public String getWorkShopName() {
      return this.workShopName;
   }

   public String getTeamName() {
      return this.teamName;
   }

   public String getProcessName() {
      return this.processName;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getQuantity() {
      return this.quantity;
   }

   @JsonProperty("time")
   public void setTime(final String time) {
      this.time = time;
   }

   @JsonProperty("workShopName")
   public void setWorkShopName(final String workShopName) {
      this.workShopName = workShopName;
   }

   @JsonProperty("teamName")
   public void setTeamName(final String teamName) {
      this.teamName = teamName;
   }

   @JsonProperty("processName")
   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   @JsonProperty("projectName")
   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   @JsonProperty("serialNumber")
   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @JsonProperty("quantity")
   public void setQuantity(final String quantity) {
      this.quantity = quantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InspectToDayListDTO)) {
         return false;
      }

      InspectToDayListDTO other = (InspectToDayListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$time = this.getTime();
      Object other$time = other.getTime();
      if (this$time == null ? other$time == null : this$time.equals(other$time)) {
         Object this$workShopName = this.getWorkShopName();
         Object other$workShopName = other.getWorkShopName();
         if (this$workShopName == null ? other$workShopName == null : this$workShopName.equals(other$workShopName)) {
            Object this$teamName = this.getTeamName();
            Object other$teamName = other.getTeamName();
            if (this$teamName == null ? other$teamName == null : this$teamName.equals(other$teamName)) {
               Object this$processName = this.getProcessName();
               Object other$processName = other.getProcessName();
               if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                  Object this$projectName = this.getProjectName();
                  Object other$projectName = other.getProjectName();
                  if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                     Object this$serialNumber = this.getSerialNumber();
                     Object other$serialNumber = other.getSerialNumber();
                     if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                        Object this$quantity = this.getQuantity();
                        Object other$quantity = other.getQuantity();
                        return this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity);
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
      return other instanceof InspectToDayListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $time = this.getTime();
      result = result * 59 + ($time == null ? 43 : $time.hashCode());
      Object $workShopName = this.getWorkShopName();
      result = result * 59 + ($workShopName == null ? 43 : $workShopName.hashCode());
      Object $teamName = this.getTeamName();
      result = result * 59 + ($teamName == null ? 43 : $teamName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   @Override
   public String toString() {
      return "InspectToDayListDTO(super="
         + super.toString()
         + ", time="
         + this.getTime()
         + ", workShopName="
         + this.getWorkShopName()
         + ", teamName="
         + this.getTeamName()
         + ", processName="
         + this.getProcessName()
         + ", projectName="
         + this.getProjectName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", quantity="
         + this.getQuantity()
         + ")";
   }

   public InspectToDayListDTO(
      final String time,
      final String workShopName,
      final String teamName,
      final String processName,
      final String projectName,
      final String serialNumber,
      final String quantity
   ) {
      this.time = time;
      this.workShopName = workShopName;
      this.teamName = teamName;
      this.processName = processName;
      this.projectName = projectName;
      this.serialNumber = serialNumber;
      this.quantity = quantity;
   }

   public InspectToDayListDTO() {
   }

   public static class InspectToDayListDTOBuilder {
      private String time;
      private String workShopName;
      private String teamName;
      private String processName;
      private String projectName;
      private String serialNumber;
      private String quantity;

      InspectToDayListDTOBuilder() {
      }

      @JsonProperty("time")
      public InspectToDayListDTO.InspectToDayListDTOBuilder time(final String time) {
         this.time = time;
         return this;
      }

      @JsonProperty("workShopName")
      public InspectToDayListDTO.InspectToDayListDTOBuilder workShopName(final String workShopName) {
         this.workShopName = workShopName;
         return this;
      }

      @JsonProperty("teamName")
      public InspectToDayListDTO.InspectToDayListDTOBuilder teamName(final String teamName) {
         this.teamName = teamName;
         return this;
      }

      @JsonProperty("processName")
      public InspectToDayListDTO.InspectToDayListDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("projectName")
      public InspectToDayListDTO.InspectToDayListDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      @JsonProperty("serialNumber")
      public InspectToDayListDTO.InspectToDayListDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("quantity")
      public InspectToDayListDTO.InspectToDayListDTOBuilder quantity(final String quantity) {
         this.quantity = quantity;
         return this;
      }

      public InspectToDayListDTO build() {
         return new InspectToDayListDTO(this.time, this.workShopName, this.teamName, this.processName, this.projectName, this.serialNumber, this.quantity);
      }

      @Override
      public String toString() {
         return "InspectToDayListDTO.InspectToDayListDTOBuilder(time="
            + this.time
            + ", workShopName="
            + this.workShopName
            + ", teamName="
            + this.teamName
            + ", processName="
            + this.processName
            + ", projectName="
            + this.projectName
            + ", serialNumber="
            + this.serialNumber
            + ", quantity="
            + this.quantity
            + ")";
      }
   }
}
