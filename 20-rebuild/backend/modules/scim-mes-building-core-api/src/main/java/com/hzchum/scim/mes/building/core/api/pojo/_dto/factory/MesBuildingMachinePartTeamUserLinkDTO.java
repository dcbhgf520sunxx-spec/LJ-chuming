package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class MesBuildingMachinePartTeamUserLinkDTO {
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
   @ApiModelProperty(name = "partTeamId", value = "零件班组id", notes = "零件班组id")
   @JsonProperty("partTeamId")
   @JSONField(name = "partTeamId")
   private Long partTeamId;

   public static MesBuildingMachinePartTeamUserLinkDTO.MesBuildingMachinePartTeamUserLinkDTOBuilder builder() {
      return new MesBuildingMachinePartTeamUserLinkDTO.MesBuildingMachinePartTeamUserLinkDTOBuilder();
   }

   public MesBuildingMachinePartTeamUserLinkDTO() {
   }

   public MesBuildingMachinePartTeamUserLinkDTO(final Long id, final Long userId, final String userName, final Boolean boolLeaderEnum, final Long partTeamId) {
      this.id = id;
      this.userId = userId;
      this.userName = userName;
      this.boolLeaderEnum = boolLeaderEnum;
      this.partTeamId = partTeamId;
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

   public Long getPartTeamId() {
      return this.partTeamId;
   }

   @JsonProperty("id")
   public MesBuildingMachinePartTeamUserLinkDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingMachinePartTeamUserLinkDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userName")
   public MesBuildingMachinePartTeamUserLinkDTO setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("boolLeaderEnum")
   public MesBuildingMachinePartTeamUserLinkDTO setBoolLeaderEnum(final Boolean boolLeaderEnum) {
      this.boolLeaderEnum = boolLeaderEnum;
      return this;
   }

   @JsonProperty("partTeamId")
   public MesBuildingMachinePartTeamUserLinkDTO setPartTeamId(final Long partTeamId) {
      this.partTeamId = partTeamId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingMachinePartTeamUserLinkDTO(id="
         + this.getId()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", boolLeaderEnum="
         + this.getBoolLeaderEnum()
         + ", partTeamId="
         + this.getPartTeamId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingMachinePartTeamUserLinkDTO)) {
         return false;
      }

      MesBuildingMachinePartTeamUserLinkDTO other = (MesBuildingMachinePartTeamUserLinkDTO)o;
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
               Object this$partTeamId = this.getPartTeamId();
               Object other$partTeamId = other.getPartTeamId();
               if (this$partTeamId == null ? other$partTeamId == null : this$partTeamId.equals(other$partTeamId)) {
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
      return other instanceof MesBuildingMachinePartTeamUserLinkDTO;
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
      Object $partTeamId = this.getPartTeamId();
      result = result * 59 + ($partTeamId == null ? 43 : $partTeamId.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   public static class MesBuildingMachinePartTeamUserLinkDTOBuilder {
      private Long id;
      private Long userId;
      private String userName;
      private Boolean boolLeaderEnum;
      private Long partTeamId;

      MesBuildingMachinePartTeamUserLinkDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingMachinePartTeamUserLinkDTO.MesBuildingMachinePartTeamUserLinkDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingMachinePartTeamUserLinkDTO.MesBuildingMachinePartTeamUserLinkDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userName")
      public MesBuildingMachinePartTeamUserLinkDTO.MesBuildingMachinePartTeamUserLinkDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("boolLeaderEnum")
      public MesBuildingMachinePartTeamUserLinkDTO.MesBuildingMachinePartTeamUserLinkDTOBuilder boolLeaderEnum(final Boolean boolLeaderEnum) {
         this.boolLeaderEnum = boolLeaderEnum;
         return this;
      }

      @JsonProperty("partTeamId")
      public MesBuildingMachinePartTeamUserLinkDTO.MesBuildingMachinePartTeamUserLinkDTOBuilder partTeamId(final Long partTeamId) {
         this.partTeamId = partTeamId;
         return this;
      }

      public MesBuildingMachinePartTeamUserLinkDTO build() {
         return new MesBuildingMachinePartTeamUserLinkDTO(this.id, this.userId, this.userName, this.boolLeaderEnum, this.partTeamId);
      }

      @Override
      public String toString() {
         return "MesBuildingMachinePartTeamUserLinkDTO.MesBuildingMachinePartTeamUserLinkDTOBuilder(id="
            + this.id
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", boolLeaderEnum="
            + this.boolLeaderEnum
            + ", partTeamId="
            + this.partTeamId
            + ")";
      }
   }
}
