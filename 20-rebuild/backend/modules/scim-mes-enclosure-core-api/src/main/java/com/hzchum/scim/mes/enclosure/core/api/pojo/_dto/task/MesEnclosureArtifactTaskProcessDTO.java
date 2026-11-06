package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesEnclosureArtifatTaskProcessDO", description = "任务分配工序详情表 ")
public class MesEnclosureArtifactTaskProcessDTO {
   @ApiModelProperty(name = "number", notes = "一物一码编号")
   @JsonProperty("number")
   @JSONField(name = "number")
   private Integer number;
   @ApiModelProperty(name = "serialNumber", notes = "构件编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "teamLeaderName", notes = "班组组长")
   @JsonProperty("teamLeaderName")
   @JSONField(name = "teamLeaderName")
   private String teamLeaderName;

   public static MesEnclosureArtifactTaskProcessDTO.MesEnclosureArtifactTaskProcessDTOBuilder builder() {
      return new MesEnclosureArtifactTaskProcessDTO.MesEnclosureArtifactTaskProcessDTOBuilder();
   }

   public MesEnclosureArtifactTaskProcessDTO() {
   }

   public MesEnclosureArtifactTaskProcessDTO(final Integer number, final String serialNumber, final String teamLeaderName) {
      this.number = number;
      this.serialNumber = serialNumber;
      this.teamLeaderName = teamLeaderName;
   }

   public Integer getNumber() {
      return this.number;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getTeamLeaderName() {
      return this.teamLeaderName;
   }

   @JsonProperty("number")
   public MesEnclosureArtifactTaskProcessDTO setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesEnclosureArtifactTaskProcessDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("teamLeaderName")
   public MesEnclosureArtifactTaskProcessDTO setTeamLeaderName(final String teamLeaderName) {
      this.teamLeaderName = teamLeaderName;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureArtifactTaskProcessDTO(number="
         + this.getNumber()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", teamLeaderName="
         + this.getTeamLeaderName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureArtifactTaskProcessDTO)) {
         return false;
      }

      MesEnclosureArtifactTaskProcessDTO other = (MesEnclosureArtifactTaskProcessDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$number = this.getNumber();
      Object other$number = other.getNumber();
      if (this$number == null ? other$number == null : this$number.equals(other$number)) {
         Object this$serialNumber = this.getSerialNumber();
         Object other$serialNumber = other.getSerialNumber();
         if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
            Object this$teamLeaderName = this.getTeamLeaderName();
            Object other$teamLeaderName = other.getTeamLeaderName();
            return this$teamLeaderName == null ? other$teamLeaderName == null : this$teamLeaderName.equals(other$teamLeaderName);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureArtifactTaskProcessDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $teamLeaderName = this.getTeamLeaderName();
      return result * 59 + ($teamLeaderName == null ? 43 : $teamLeaderName.hashCode());
   }

   public static class MesEnclosureArtifactTaskProcessDTOBuilder {
      private Integer number;
      private String serialNumber;
      private String teamLeaderName;

      MesEnclosureArtifactTaskProcessDTOBuilder() {
      }

      @JsonProperty("number")
      public MesEnclosureArtifactTaskProcessDTO.MesEnclosureArtifactTaskProcessDTOBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesEnclosureArtifactTaskProcessDTO.MesEnclosureArtifactTaskProcessDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("teamLeaderName")
      public MesEnclosureArtifactTaskProcessDTO.MesEnclosureArtifactTaskProcessDTOBuilder teamLeaderName(final String teamLeaderName) {
         this.teamLeaderName = teamLeaderName;
         return this;
      }

      public MesEnclosureArtifactTaskProcessDTO build() {
         return new MesEnclosureArtifactTaskProcessDTO(this.number, this.serialNumber, this.teamLeaderName);
      }

      @Override
      public String toString() {
         return "MesEnclosureArtifactTaskProcessDTO.MesEnclosureArtifactTaskProcessDTOBuilder(number="
            + this.number
            + ", serialNumber="
            + this.serialNumber
            + ", teamLeaderName="
            + this.teamLeaderName
            + ")";
      }
   }
}
