package com.hzchum.scim.mes.building.core.api.pojo._dto.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingTeamLeaderDTO", description = "班组长信息DTO")
public class MesBuildingLeaderInfoDTO {
   @ApiModelProperty(name = "id", notes = "班组id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "leaderUserId", notes = "班组长id")
   @JsonProperty("leaderUserId")
   @JSONField(name = "leaderUserId")
   private Long leaderUserId;
   @ApiModelProperty(name = "leaderName", notes = "班组长名称")
   @JsonProperty("leaderName")
   @JSONField(name = "leaderName")
   private String leaderName;

   public static MesBuildingLeaderInfoDTO.MesBuildingLeaderInfoDTOBuilder builder() {
      return new MesBuildingLeaderInfoDTO.MesBuildingLeaderInfoDTOBuilder();
   }

   public MesBuildingLeaderInfoDTO() {
   }

   public MesBuildingLeaderInfoDTO(final Long id, final Long leaderUserId, final String leaderName) {
      this.id = id;
      this.leaderUserId = leaderUserId;
      this.leaderName = leaderName;
   }

   public Long getId() {
      return this.id;
   }

   public Long getLeaderUserId() {
      return this.leaderUserId;
   }

   public String getLeaderName() {
      return this.leaderName;
   }

   @JsonProperty("id")
   public MesBuildingLeaderInfoDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("leaderUserId")
   public MesBuildingLeaderInfoDTO setLeaderUserId(final Long leaderUserId) {
      this.leaderUserId = leaderUserId;
      return this;
   }

   @JsonProperty("leaderName")
   public MesBuildingLeaderInfoDTO setLeaderName(final String leaderName) {
      this.leaderName = leaderName;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingLeaderInfoDTO(id=" + this.getId() + ", leaderUserId=" + this.getLeaderUserId() + ", leaderName=" + this.getLeaderName() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingLeaderInfoDTO)) {
         return false;
      }

      MesBuildingLeaderInfoDTO other = (MesBuildingLeaderInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$leaderUserId = this.getLeaderUserId();
         Object other$leaderUserId = other.getLeaderUserId();
         if (this$leaderUserId == null ? other$leaderUserId == null : this$leaderUserId.equals(other$leaderUserId)) {
            Object this$leaderName = this.getLeaderName();
            Object other$leaderName = other.getLeaderName();
            return this$leaderName == null ? other$leaderName == null : this$leaderName.equals(other$leaderName);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingLeaderInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $leaderUserId = this.getLeaderUserId();
      result = result * 59 + ($leaderUserId == null ? 43 : $leaderUserId.hashCode());
      Object $leaderName = this.getLeaderName();
      return result * 59 + ($leaderName == null ? 43 : $leaderName.hashCode());
   }

   public static class MesBuildingLeaderInfoDTOBuilder {
      private Long id;
      private Long leaderUserId;
      private String leaderName;

      MesBuildingLeaderInfoDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingLeaderInfoDTO.MesBuildingLeaderInfoDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("leaderUserId")
      public MesBuildingLeaderInfoDTO.MesBuildingLeaderInfoDTOBuilder leaderUserId(final Long leaderUserId) {
         this.leaderUserId = leaderUserId;
         return this;
      }

      @JsonProperty("leaderName")
      public MesBuildingLeaderInfoDTO.MesBuildingLeaderInfoDTOBuilder leaderName(final String leaderName) {
         this.leaderName = leaderName;
         return this;
      }

      public MesBuildingLeaderInfoDTO build() {
         return new MesBuildingLeaderInfoDTO(this.id, this.leaderUserId, this.leaderName);
      }

      @Override
      public String toString() {
         return "MesBuildingLeaderInfoDTO.MesBuildingLeaderInfoDTOBuilder(id="
            + this.id
            + ", leaderUserId="
            + this.leaderUserId
            + ", leaderName="
            + this.leaderName
            + ")";
      }
   }
}
