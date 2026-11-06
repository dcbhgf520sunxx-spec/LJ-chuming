package com.hzchum.scim.mes.building.core.api.pojo._doModel.factory;

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

@ApiModel(value = "MesBuildingMachinePartTeamUserLink对象", description = "零件班组关联用户 ")
@Entity
@TableName("mes_building_machine_part_team_user_link")
@Table(name = "mes_building_machine_part_team_user_link")
public class MesBuildingMachinePartTeamUserLink extends BaseEntity<Long> {
   private static final long serialVersionUID = -5733409531837009449L;
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
   @ApiModelProperty(name = "partTeamId", value = "零件班组id", notes = "零件班组id")
   @JsonProperty("partTeamId")
   @JSONField(name = "partTeamId")
   @TableField("part_team_id")
   @Column(name = "part_team_id", columnDefinition = "bigint(20)  COMMENT '零件班组id'", nullable = false)
   private Long partTeamId;

   public static MesBuildingMachinePartTeamUserLink.MesBuildingMachinePartTeamUserLinkBuilder builder() {
      return new MesBuildingMachinePartTeamUserLink.MesBuildingMachinePartTeamUserLinkBuilder();
   }

   public MesBuildingMachinePartTeamUserLink() {
   }

   public MesBuildingMachinePartTeamUserLink(final Long id, final Long userId, final String userName, final Boolean boolLeaderEnum, final Long partTeamId) {
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
   public MesBuildingMachinePartTeamUserLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("userId")
   public MesBuildingMachinePartTeamUserLink setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("userName")
   public MesBuildingMachinePartTeamUserLink setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @JsonProperty("boolLeaderEnum")
   public MesBuildingMachinePartTeamUserLink setBoolLeaderEnum(final Boolean boolLeaderEnum) {
      this.boolLeaderEnum = boolLeaderEnum;
      return this;
   }

   @JsonProperty("partTeamId")
   public MesBuildingMachinePartTeamUserLink setPartTeamId(final Long partTeamId) {
      this.partTeamId = partTeamId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingMachinePartTeamUserLink(id="
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

      if (!(o instanceof MesBuildingMachinePartTeamUserLink)) {
         return false;
      }

      MesBuildingMachinePartTeamUserLink other = (MesBuildingMachinePartTeamUserLink)o;
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingMachinePartTeamUserLink;
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
      Object $partTeamId = this.getPartTeamId();
      result = result * 59 + ($partTeamId == null ? 43 : $partTeamId.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   public static class MesBuildingMachinePartTeamUserLinkBuilder {
      private Long id;
      private Long userId;
      private String userName;
      private Boolean boolLeaderEnum;
      private Long partTeamId;

      MesBuildingMachinePartTeamUserLinkBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingMachinePartTeamUserLink.MesBuildingMachinePartTeamUserLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("userId")
      public MesBuildingMachinePartTeamUserLink.MesBuildingMachinePartTeamUserLinkBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("userName")
      public MesBuildingMachinePartTeamUserLink.MesBuildingMachinePartTeamUserLinkBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      @JsonProperty("boolLeaderEnum")
      public MesBuildingMachinePartTeamUserLink.MesBuildingMachinePartTeamUserLinkBuilder boolLeaderEnum(final Boolean boolLeaderEnum) {
         this.boolLeaderEnum = boolLeaderEnum;
         return this;
      }

      @JsonProperty("partTeamId")
      public MesBuildingMachinePartTeamUserLink.MesBuildingMachinePartTeamUserLinkBuilder partTeamId(final Long partTeamId) {
         this.partTeamId = partTeamId;
         return this;
      }

      public MesBuildingMachinePartTeamUserLink build() {
         return new MesBuildingMachinePartTeamUserLink(this.id, this.userId, this.userName, this.boolLeaderEnum, this.partTeamId);
      }

      @Override
      public String toString() {
         return "MesBuildingMachinePartTeamUserLink.MesBuildingMachinePartTeamUserLinkBuilder(id="
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
