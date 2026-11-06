package com.hzchum.scim.system.core.api.pojo.dto.config;

import io.swagger.annotations.ApiModelProperty;

public class MesInspectConfigTeamLinkDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "inspectConfigId", value = "质检配置id", notes = "质检配置id")
   private Long inspectConfigId;
   @ApiModelProperty(name = "teamId", value = "班组id", notes = "班组id")
   private Long teamId;
   @ApiModelProperty(name = "teamLeaderName", value = "班组长名", notes = "班组长名")
   private String teamLeaderName;

   public static MesInspectConfigTeamLinkDTO.MesInspectConfigTeamLinkDTOBuilder builder() {
      return new MesInspectConfigTeamLinkDTO.MesInspectConfigTeamLinkDTOBuilder();
   }

   public MesInspectConfigTeamLinkDTO() {
   }

   public MesInspectConfigTeamLinkDTO(final Long id, final Long inspectConfigId, final Long teamId, final String teamLeaderName) {
      this.id = id;
      this.inspectConfigId = inspectConfigId;
      this.teamId = teamId;
      this.teamLeaderName = teamLeaderName;
   }

   public Long getId() {
      return this.id;
   }

   public Long getInspectConfigId() {
      return this.inspectConfigId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public String getTeamLeaderName() {
      return this.teamLeaderName;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setInspectConfigId(final Long inspectConfigId) {
      this.inspectConfigId = inspectConfigId;
   }

   public void setTeamId(final Long teamId) {
      this.teamId = teamId;
   }

   public void setTeamLeaderName(final String teamLeaderName) {
      this.teamLeaderName = teamLeaderName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesInspectConfigTeamLinkDTO)) {
         return false;
      }

      MesInspectConfigTeamLinkDTO other = (MesInspectConfigTeamLinkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$inspectConfigId = this.getInspectConfigId();
         Object other$inspectConfigId = other.getInspectConfigId();
         if (this$inspectConfigId == null ? other$inspectConfigId == null : this$inspectConfigId.equals(other$inspectConfigId)) {
            Object this$teamId = this.getTeamId();
            Object other$teamId = other.getTeamId();
            if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesInspectConfigTeamLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $inspectConfigId = this.getInspectConfigId();
      result = result * 59 + ($inspectConfigId == null ? 43 : $inspectConfigId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $teamLeaderName = this.getTeamLeaderName();
      return result * 59 + ($teamLeaderName == null ? 43 : $teamLeaderName.hashCode());
   }

   @Override
   public String toString() {
      return "MesInspectConfigTeamLinkDTO(id="
         + this.getId()
         + ", inspectConfigId="
         + this.getInspectConfigId()
         + ", teamId="
         + this.getTeamId()
         + ", teamLeaderName="
         + this.getTeamLeaderName()
         + ")";
   }

   public static class MesInspectConfigTeamLinkDTOBuilder {
      private Long id;
      private Long inspectConfigId;
      private Long teamId;
      private String teamLeaderName;

      MesInspectConfigTeamLinkDTOBuilder() {
      }

      public MesInspectConfigTeamLinkDTO.MesInspectConfigTeamLinkDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesInspectConfigTeamLinkDTO.MesInspectConfigTeamLinkDTOBuilder inspectConfigId(final Long inspectConfigId) {
         this.inspectConfigId = inspectConfigId;
         return this;
      }

      public MesInspectConfigTeamLinkDTO.MesInspectConfigTeamLinkDTOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public MesInspectConfigTeamLinkDTO.MesInspectConfigTeamLinkDTOBuilder teamLeaderName(final String teamLeaderName) {
         this.teamLeaderName = teamLeaderName;
         return this;
      }

      public MesInspectConfigTeamLinkDTO build() {
         return new MesInspectConfigTeamLinkDTO(this.id, this.inspectConfigId, this.teamId, this.teamLeaderName);
      }

      @Override
      public String toString() {
         return "MesInspectConfigTeamLinkDTO.MesInspectConfigTeamLinkDTOBuilder(id="
            + this.id
            + ", inspectConfigId="
            + this.inspectConfigId
            + ", teamId="
            + this.teamId
            + ", teamLeaderName="
            + this.teamLeaderName
            + ")";
      }
   }
}
