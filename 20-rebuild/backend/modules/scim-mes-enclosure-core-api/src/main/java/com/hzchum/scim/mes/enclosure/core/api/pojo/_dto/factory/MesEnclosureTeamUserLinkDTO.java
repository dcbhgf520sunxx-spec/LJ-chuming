package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class MesEnclosureTeamUserLinkDTO {
   @ApiModelProperty(name = "id", notes = "主键ID", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "userId", notes = "用户id", value = "用户id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "userName", notes = "用户名", value = "用户名")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   private String userName;
   @ApiModelProperty(name = "boolLeaderEnum", notes = "用户类型 [0 组长, 1 组员]", value = "用户类型 [0 组长, 1 组员]")
   @JsonProperty("boolLeaderEnum")
   @JSONField(name = "boolLeaderEnum")
   private Boolean boolLeaderEnum;
   @ApiModelProperty(name = "teamId", notes = "班组id", value = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;

   public static MesEnclosureTeamUserLinkDTO.MesEnclosureTeamUserLinkDTOBuilder builder() {
      return new MesEnclosureTeamUserLinkDTO.MesEnclosureTeamUserLinkDTOBuilder();
   }

   public MesEnclosureTeamUserLinkDTO() {
   }

   public MesEnclosureTeamUserLinkDTO(final Long id, final Long userId, final String userName, final Boolean boolLeaderEnum, final Long teamId) {
      this.id = id;
      this.userId = userId;
      this.userName = userName;
      this.boolLeaderEnum = boolLeaderEnum;
      this.teamId = teamId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public Boolean getBoolLeaderEnum() {
      return this.boolLeaderEnum;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   @JsonProperty("id")
   public MesEnclosureTeamUserLinkDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureTeamUserLinkDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userName")
   public MesEnclosureTeamUserLinkDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("boolLeaderEnum")
   public MesEnclosureTeamUserLinkDTO setBoolLeaderEnum(final Boolean boolLeaderEnum) {
      this.boolLeaderEnum = boolLeaderEnum;
      return this;
   }

   @JsonProperty("teamId")
   public MesEnclosureTeamUserLinkDTO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureTeamUserLinkDTO(id="
         + this.getId()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", boolLeaderEnum="
         + this.getBoolLeaderEnum()
         + ", teamId="
         + this.getTeamId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureTeamUserLinkDTO)) {
         return false;
      }

      MesEnclosureTeamUserLinkDTO other = (MesEnclosureTeamUserLinkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$userId = this.getUserId();
         Object other$userId = other.getUserId();
         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
            Object this$boolLeaderEnum = this.getBoolLeaderEnum();
            Object other$boolLeaderEnum = other.getBoolLeaderEnum();
            if (this$boolLeaderEnum == null ? other$boolLeaderEnum == null : this$boolLeaderEnum.equals(other$boolLeaderEnum)) {
               Object this$teamId = this.getTeamId();
               Object other$teamId = other.getTeamId();
               if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                  Object this$userName = this.getUserName();
                  Object other$userName = other.getUserName();
                  return this$userName == null ? other$userName == null : this$userName.equals(other$userName);
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
      return other instanceof MesEnclosureTeamUserLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $boolLeaderEnum = this.getBoolLeaderEnum();
      result = result * 59 + ($boolLeaderEnum == null ? 43 : $boolLeaderEnum.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   public static class MesEnclosureTeamUserLinkDTOBuilder {
      private Long id;
      private Long userId;
      private String userName;
      private Boolean boolLeaderEnum;
      private Long teamId;

      MesEnclosureTeamUserLinkDTOBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureTeamUserLinkDTO.MesEnclosureTeamUserLinkDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureTeamUserLinkDTO.MesEnclosureTeamUserLinkDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userName")
      public MesEnclosureTeamUserLinkDTO.MesEnclosureTeamUserLinkDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("boolLeaderEnum")
      public MesEnclosureTeamUserLinkDTO.MesEnclosureTeamUserLinkDTOBuilder boolLeaderEnum(final Boolean boolLeaderEnum) {
         this.boolLeaderEnum = boolLeaderEnum;
         return this;
      }

      @JsonProperty("teamId")
      public MesEnclosureTeamUserLinkDTO.MesEnclosureTeamUserLinkDTOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public MesEnclosureTeamUserLinkDTO build() {
         return new MesEnclosureTeamUserLinkDTO(this.id, this.userId, this.userName, this.boolLeaderEnum, this.teamId);
      }

      @Override
      public String toString() {
         return "MesEnclosureTeamUserLinkDTO.MesEnclosureTeamUserLinkDTOBuilder(id="
            + this.id
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", boolLeaderEnum="
            + this.boolLeaderEnum
            + ", teamId="
            + this.teamId
            + ")";
      }
   }
}
