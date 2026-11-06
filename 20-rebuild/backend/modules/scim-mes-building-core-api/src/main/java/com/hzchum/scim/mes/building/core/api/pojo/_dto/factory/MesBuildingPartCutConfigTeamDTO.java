package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingPartCutConfigTeamDTO", description = "")
public class MesBuildingPartCutConfigTeamDTO {
   @ApiModelProperty(name = "id", notes = "班组id")
   @JsonProperty("id")
   private Long id;
   @ApiModelProperty(name = "teamName", value = "班组名称", notes = "班组名称")
   @JsonProperty("teamName")
   private String teamName;
   @ApiModelProperty(name = "deviceTypeName", value = "切割方式名称", notes = "切割方式名称")
   @JsonProperty("deviceTypeName")
   private String deviceTypeName;

   public static MesBuildingPartCutConfigTeamDTO.MesBuildingPartCutConfigTeamDTOBuilder builder() {
      return new MesBuildingPartCutConfigTeamDTO.MesBuildingPartCutConfigTeamDTOBuilder();
   }

   public MesBuildingPartCutConfigTeamDTO() {
   }

   public MesBuildingPartCutConfigTeamDTO(final Long id, final String teamName, final String deviceTypeName) {
      this.id = id;
      this.teamName = teamName;
      this.deviceTypeName = deviceTypeName;
   }

   public Long getId() {
      return this.id;
   }

   public String getTeamName() {
      return this.teamName;
   }

   public String getDeviceTypeName() {
      return this.deviceTypeName;
   }

   @JsonProperty("id")
   public MesBuildingPartCutConfigTeamDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("teamName")
   public MesBuildingPartCutConfigTeamDTO setTeamName(final String teamName) {
      this.teamName = teamName;
      return this;
   }

   @JsonProperty("deviceTypeName")
   public MesBuildingPartCutConfigTeamDTO setDeviceTypeName(final String deviceTypeName) {
      this.deviceTypeName = deviceTypeName;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingPartCutConfigTeamDTO(id=" + this.getId() + ", teamName=" + this.getTeamName() + ", deviceTypeName=" + this.getDeviceTypeName() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPartCutConfigTeamDTO)) {
         return false;
      }

      MesBuildingPartCutConfigTeamDTO other = (MesBuildingPartCutConfigTeamDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$teamName = this.getTeamName();
         Object other$teamName = other.getTeamName();
         if (this$teamName == null ? other$teamName == null : this$teamName.equals(other$teamName)) {
            Object this$deviceTypeName = this.getDeviceTypeName();
            Object other$deviceTypeName = other.getDeviceTypeName();
            return this$deviceTypeName == null ? other$deviceTypeName == null : this$deviceTypeName.equals(other$deviceTypeName);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingPartCutConfigTeamDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $teamName = this.getTeamName();
      result = result * 59 + ($teamName == null ? 43 : $teamName.hashCode());
      Object $deviceTypeName = this.getDeviceTypeName();
      return result * 59 + ($deviceTypeName == null ? 43 : $deviceTypeName.hashCode());
   }

   public static class MesBuildingPartCutConfigTeamDTOBuilder {
      private Long id;
      private String teamName;
      private String deviceTypeName;

      MesBuildingPartCutConfigTeamDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingPartCutConfigTeamDTO.MesBuildingPartCutConfigTeamDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("teamName")
      public MesBuildingPartCutConfigTeamDTO.MesBuildingPartCutConfigTeamDTOBuilder teamName(final String teamName) {
         this.teamName = teamName;
         return this;
      }

      @JsonProperty("deviceTypeName")
      public MesBuildingPartCutConfigTeamDTO.MesBuildingPartCutConfigTeamDTOBuilder deviceTypeName(final String deviceTypeName) {
         this.deviceTypeName = deviceTypeName;
         return this;
      }

      public MesBuildingPartCutConfigTeamDTO build() {
         return new MesBuildingPartCutConfigTeamDTO(this.id, this.teamName, this.deviceTypeName);
      }

      @Override
      public String toString() {
         return "MesBuildingPartCutConfigTeamDTO.MesBuildingPartCutConfigTeamDTOBuilder(id="
            + this.id
            + ", teamName="
            + this.teamName
            + ", deviceTypeName="
            + this.deviceTypeName
            + ")";
      }
   }
}
