package com.hzchum.scim.mes.building.core.api.pojo._do.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "MesBuildingArtifatTaskProcessDO", description = "任务分配工序详情表 ")
public class MesBuildingArtifactTaskProcessDO {
   @ApiModelProperty(name = "id", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "completeTime", notes = "完成日期")
   @JsonProperty("completeTime")
   @JSONField(name = "completeTime")
   private LocalDateTime completeTime;
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

   public static MesBuildingArtifactTaskProcessDO.MesBuildingArtifactTaskProcessDOBuilder builder() {
      return new MesBuildingArtifactTaskProcessDO.MesBuildingArtifactTaskProcessDOBuilder();
   }

   public MesBuildingArtifactTaskProcessDO() {
   }

   public MesBuildingArtifactTaskProcessDO(
      final Long id, final LocalDateTime completeTime, final Integer number, final String serialNumber, final String teamLeaderName
   ) {
      this.id = id;
      this.completeTime = completeTime;
      this.number = number;
      this.serialNumber = serialNumber;
      this.teamLeaderName = teamLeaderName;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getCompleteTime() {
      return this.completeTime;
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

   @JsonProperty("id")
   public MesBuildingArtifactTaskProcessDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("completeTime")
   public MesBuildingArtifactTaskProcessDO setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
      return this;
   }

   @JsonProperty("number")
   public MesBuildingArtifactTaskProcessDO setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingArtifactTaskProcessDO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("teamLeaderName")
   public MesBuildingArtifactTaskProcessDO setTeamLeaderName(final String teamLeaderName) {
      this.teamLeaderName = teamLeaderName;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingArtifactTaskProcessDO(id="
         + this.getId()
         + ", completeTime="
         + this.getCompleteTime()
         + ", number="
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

      if (!(o instanceof MesBuildingArtifactTaskProcessDO)) {
         return false;
      }

      MesBuildingArtifactTaskProcessDO other = (MesBuildingArtifactTaskProcessDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$number = this.getNumber();
         Object other$number = other.getNumber();
         if (this$number == null ? other$number == null : this$number.equals(other$number)) {
            Object this$completeTime = this.getCompleteTime();
            Object other$completeTime = other.getCompleteTime();
            if (this$completeTime == null ? other$completeTime == null : this$completeTime.equals(other$completeTime)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingArtifactTaskProcessDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $completeTime = this.getCompleteTime();
      result = result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $teamLeaderName = this.getTeamLeaderName();
      return result * 59 + ($teamLeaderName == null ? 43 : $teamLeaderName.hashCode());
   }

   public static class MesBuildingArtifactTaskProcessDOBuilder {
      private Long id;
      private LocalDateTime completeTime;
      private Integer number;
      private String serialNumber;
      private String teamLeaderName;

      MesBuildingArtifactTaskProcessDOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingArtifactTaskProcessDO.MesBuildingArtifactTaskProcessDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("completeTime")
      public MesBuildingArtifactTaskProcessDO.MesBuildingArtifactTaskProcessDOBuilder completeTime(final LocalDateTime completeTime) {
         this.completeTime = completeTime;
         return this;
      }

      @JsonProperty("number")
      public MesBuildingArtifactTaskProcessDO.MesBuildingArtifactTaskProcessDOBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingArtifactTaskProcessDO.MesBuildingArtifactTaskProcessDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("teamLeaderName")
      public MesBuildingArtifactTaskProcessDO.MesBuildingArtifactTaskProcessDOBuilder teamLeaderName(final String teamLeaderName) {
         this.teamLeaderName = teamLeaderName;
         return this;
      }

      public MesBuildingArtifactTaskProcessDO build() {
         return new MesBuildingArtifactTaskProcessDO(this.id, this.completeTime, this.number, this.serialNumber, this.teamLeaderName);
      }

      @Override
      public String toString() {
         return "MesBuildingArtifactTaskProcessDO.MesBuildingArtifactTaskProcessDOBuilder(id="
            + this.id
            + ", completeTime="
            + this.completeTime
            + ", number="
            + this.number
            + ", serialNumber="
            + this.serialNumber
            + ", teamLeaderName="
            + this.teamLeaderName
            + ")";
      }
   }
}
