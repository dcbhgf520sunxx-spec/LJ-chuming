package com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "实时报检信息")
public class InspectRealtimeInfoDTO {
   @ApiModelProperty(name = "projectName", notes = "项目名称", value = "项目名称")
   @JsonProperty("projectName")
   @JSONField(name = "projectName")
   private String projectName;
   @ApiModelProperty(name = "processName", value = "工序名称")
   @JsonProperty("processName")
   @JSONField(name = "processName")
   private String processName;
   @ApiModelProperty(name = "teamName", value = "班组名称")
   @JsonProperty("teamName")
   @JSONField(name = "teamName")
   private String teamName;
   @ApiModelProperty(name = "serial_number", notes = "产品编号")
   @JsonProperty("serial_number")
   @JSONField(name = "serial_number")
   private String serialNumber;
   @ApiModelProperty(name = "totalQuantity", notes = "总数量")
   @JsonProperty("totalQuantity")
   @JSONField(name = "totalQuantity")
   private String totalQuantity;

   public static InspectRealtimeInfoDTO.InspectRealtimeInfoDTOBuilder builder() {
      return new InspectRealtimeInfoDTO.InspectRealtimeInfoDTOBuilder();
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getProcessName() {
      return this.processName;
   }

   public String getTeamName() {
      return this.teamName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getTotalQuantity() {
      return this.totalQuantity;
   }

   @JsonProperty("projectName")
   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   @JsonProperty("processName")
   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   @JsonProperty("teamName")
   public void setTeamName(final String teamName) {
      this.teamName = teamName;
   }

   @JsonProperty("serial_number")
   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @JsonProperty("totalQuantity")
   public void setTotalQuantity(final String totalQuantity) {
      this.totalQuantity = totalQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InspectRealtimeInfoDTO)) {
         return false;
      }

      InspectRealtimeInfoDTO other = (InspectRealtimeInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectName = this.getProjectName();
      Object other$projectName = other.getProjectName();
      if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
         Object this$processName = this.getProcessName();
         Object other$processName = other.getProcessName();
         if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
            Object this$teamName = this.getTeamName();
            Object other$teamName = other.getTeamName();
            if (this$teamName == null ? other$teamName == null : this$teamName.equals(other$teamName)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$totalQuantity = this.getTotalQuantity();
                  Object other$totalQuantity = other.getTotalQuantity();
                  return this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity);
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
      return other instanceof InspectRealtimeInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $teamName = this.getTeamName();
      result = result * 59 + ($teamName == null ? 43 : $teamName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $totalQuantity = this.getTotalQuantity();
      return result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
   }

   @Override
   public String toString() {
      return "InspectRealtimeInfoDTO(super="
         + super.toString()
         + ", projectName="
         + this.getProjectName()
         + ", processName="
         + this.getProcessName()
         + ", teamName="
         + this.getTeamName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", totalQuantity="
         + this.getTotalQuantity()
         + ")";
   }

   public InspectRealtimeInfoDTO(
      final String projectName, final String processName, final String teamName, final String serialNumber, final String totalQuantity
   ) {
      this.projectName = projectName;
      this.processName = processName;
      this.teamName = teamName;
      this.serialNumber = serialNumber;
      this.totalQuantity = totalQuantity;
   }

   public InspectRealtimeInfoDTO() {
   }

   public static class InspectRealtimeInfoDTOBuilder {
      private String projectName;
      private String processName;
      private String teamName;
      private String serialNumber;
      private String totalQuantity;

      InspectRealtimeInfoDTOBuilder() {
      }

      @JsonProperty("projectName")
      public InspectRealtimeInfoDTO.InspectRealtimeInfoDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      @JsonProperty("processName")
      public InspectRealtimeInfoDTO.InspectRealtimeInfoDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      @JsonProperty("teamName")
      public InspectRealtimeInfoDTO.InspectRealtimeInfoDTOBuilder teamName(final String teamName) {
         this.teamName = teamName;
         return this;
      }

      @JsonProperty("serial_number")
      public InspectRealtimeInfoDTO.InspectRealtimeInfoDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("totalQuantity")
      public InspectRealtimeInfoDTO.InspectRealtimeInfoDTOBuilder totalQuantity(final String totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      public InspectRealtimeInfoDTO build() {
         return new InspectRealtimeInfoDTO(this.projectName, this.processName, this.teamName, this.serialNumber, this.totalQuantity);
      }

      @Override
      public String toString() {
         return "InspectRealtimeInfoDTO.InspectRealtimeInfoDTOBuilder(projectName="
            + this.projectName
            + ", processName="
            + this.processName
            + ", teamName="
            + this.teamName
            + ", serialNumber="
            + this.serialNumber
            + ", totalQuantity="
            + this.totalQuantity
            + ")";
      }
   }
}
