package com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesEnclosureTeamUserLink对象", description = "生产班组用户关联表 ")
@Entity
@TableName("mes_enclosure_team_user_link")
@Table(name = "mes_enclosure_team_user_link")
public class MesEnclosureTeamUserLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "userId", value = "用户id", notes = "用户id")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '用户id'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "userName", value = "用户名", notes = "用户名")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   @TableField("user_name")
   @Column(name = "user_name", columnDefinition = "varchar(128)  COMMENT '用户名'", nullable = false)
   private String userName;
   @ApiModelProperty(name = "boolLeaderEnum", value = "用户类型 [0 组员, 1 组长]", notes = "用户类型 [0 组员, 1 组长]")
   @JsonProperty("boolLeaderEnum")
   @JSONField(name = "boolLeaderEnum")
   @TableField("bool_leader_enum")
   @Column(name = "bool_leader_enum", columnDefinition = "tinyint(1) default '0' COMMENT '用户类型 [0 组员, 1 组长]'", nullable = false)
   private Boolean boolLeaderEnum;
   @ApiModelProperty(name = "teamId", value = "班组id", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20)  COMMENT '班组id'", nullable = false)
   private Long teamId;

   public static MesEnclosureTeamUserLink.MesEnclosureTeamUserLinkBuilder builder() {
      return new MesEnclosureTeamUserLink.MesEnclosureTeamUserLinkBuilder();
   }

   public MesEnclosureTeamUserLink() {
   }

   public MesEnclosureTeamUserLink(final Long id, final Long userId, final String userName, final Boolean boolLeaderEnum, final Long teamId) {
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
   public MesEnclosureTeamUserLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureTeamUserLink setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userName")
   public MesEnclosureTeamUserLink setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("boolLeaderEnum")
   public MesEnclosureTeamUserLink setBoolLeaderEnum(final Boolean boolLeaderEnum) {
      this.boolLeaderEnum = boolLeaderEnum;
      return this;
   }

   @JsonProperty("teamId")
   public MesEnclosureTeamUserLink setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureTeamUserLink(id="
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

      if (!(o instanceof MesEnclosureTeamUserLink)) {
         return false;
      }

      MesEnclosureTeamUserLink other = (MesEnclosureTeamUserLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureTeamUserLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
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

   public static class MesEnclosureTeamUserLinkBuilder {
      private Long id;
      private Long userId;
      private String userName;
      private Boolean boolLeaderEnum;
      private Long teamId;

      MesEnclosureTeamUserLinkBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureTeamUserLink.MesEnclosureTeamUserLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureTeamUserLink.MesEnclosureTeamUserLinkBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userName")
      public MesEnclosureTeamUserLink.MesEnclosureTeamUserLinkBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("boolLeaderEnum")
      public MesEnclosureTeamUserLink.MesEnclosureTeamUserLinkBuilder boolLeaderEnum(final Boolean boolLeaderEnum) {
         this.boolLeaderEnum = boolLeaderEnum;
         return this;
      }

      @JsonProperty("teamId")
      public MesEnclosureTeamUserLink.MesEnclosureTeamUserLinkBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public MesEnclosureTeamUserLink build() {
         return new MesEnclosureTeamUserLink(this.id, this.userId, this.userName, this.boolLeaderEnum, this.teamId);
      }

      @Override
      public String toString() {
         return "MesEnclosureTeamUserLink.MesEnclosureTeamUserLinkBuilder(id="
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
