package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

@ApiModel(value = "MesInspectClassIdTeamIdDTO", description = "质检种类和班组对照表 ")
public class MesInspectClassIdTeamIdDTO {
   @ApiModelProperty(name = "classId", notes = "种类id", value = "种类id")
   @JsonProperty("classId")
   @JSONField(name = "classId")
   private Long classId;
   @ApiModelProperty(name = "teamId", notes = "班组id", value = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (o != null && this.getClass() == o.getClass()) {
         MesInspectClassIdTeamIdDTO that = (MesInspectClassIdTeamIdDTO)o;
         return Objects.equals(this.classId, that.classId) && Objects.equals(this.teamId, that.teamId);
      } else {
         return false;
      }
   }

   @Override
   public int hashCode() {
      return Objects.hash(this.classId, this.teamId);
   }

   public static MesInspectClassIdTeamIdDTO.MesInspectClassIdTeamIdDTOBuilder builder() {
      return new MesInspectClassIdTeamIdDTO.MesInspectClassIdTeamIdDTOBuilder();
   }

   public MesInspectClassIdTeamIdDTO() {
   }

   public MesInspectClassIdTeamIdDTO(final Long classId, final Long teamId) {
      this.classId = classId;
      this.teamId = teamId;
   }

   public Long getClassId() {
      return this.classId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   @JsonProperty("classId")
   public MesInspectClassIdTeamIdDTO setClassId(final Long classId) {
      this.classId = classId;
      return this;
   }

   @JsonProperty("teamId")
   public MesInspectClassIdTeamIdDTO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @Override
   public String toString() {
      return "MesInspectClassIdTeamIdDTO(classId=" + this.getClassId() + ", teamId=" + this.getTeamId() + ")";
   }

   public static class MesInspectClassIdTeamIdDTOBuilder {
      private Long classId;
      private Long teamId;

      MesInspectClassIdTeamIdDTOBuilder() {
      }

      @JsonProperty("classId")
      public MesInspectClassIdTeamIdDTO.MesInspectClassIdTeamIdDTOBuilder classId(final Long classId) {
         this.classId = classId;
         return this;
      }

      @JsonProperty("teamId")
      public MesInspectClassIdTeamIdDTO.MesInspectClassIdTeamIdDTOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public MesInspectClassIdTeamIdDTO build() {
         return new MesInspectClassIdTeamIdDTO(this.classId, this.teamId);
      }

      @Override
      public String toString() {
         return "MesInspectClassIdTeamIdDTO.MesInspectClassIdTeamIdDTOBuilder(classId=" + this.classId + ", teamId=" + this.teamId + ")";
      }
   }
}
