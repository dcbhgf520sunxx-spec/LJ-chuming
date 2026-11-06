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

@ApiModel(value = "MesBuildingProductionLineTeamLink对象", description = "生产线 ")
@Entity
@TableName("mes_building_groups_team_link")
@Table(name = "mes_building_groups_team_link")
public class MesBuildingGroupsTeamLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   @TableField("groups_id")
   @Column(name = "groups_id", columnDefinition = "bigint(20)  COMMENT '生产组id'", nullable = false)
   private Long groupsId;
   @ApiModelProperty(name = "teamId", value = "生产班组id", notes = "生产班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20)  COMMENT '生产班组id'", nullable = false)
   private Long teamId;

   public static MesBuildingGroupsTeamLink.MesBuildingGroupsTeamLinkBuilder builder() {
      return new MesBuildingGroupsTeamLink.MesBuildingGroupsTeamLinkBuilder();
   }

   public MesBuildingGroupsTeamLink() {
   }

   public MesBuildingGroupsTeamLink(final Long id, final Long groupsId, final Long teamId) {
      this.id = id;
      this.groupsId = groupsId;
      this.teamId = teamId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   @JsonProperty("id")
   public MesBuildingGroupsTeamLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("groupsId")
   public MesBuildingGroupsTeamLink setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("teamId")
   public MesBuildingGroupsTeamLink setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingGroupsTeamLink(id=" + this.getId() + ", groupsId=" + this.getGroupsId() + ", teamId=" + this.getTeamId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingGroupsTeamLink)) {
         return false;
      }

      MesBuildingGroupsTeamLink other = (MesBuildingGroupsTeamLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$groupsId = this.getGroupsId();
         Object other$groupsId = other.getGroupsId();
         if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
            Object this$teamId = this.getTeamId();
            Object other$teamId = other.getTeamId();
            return this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingGroupsTeamLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $teamId = this.getTeamId();
      return result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
   }

   public static class MesBuildingGroupsTeamLinkBuilder {
      private Long id;
      private Long groupsId;
      private Long teamId;

      MesBuildingGroupsTeamLinkBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingGroupsTeamLink.MesBuildingGroupsTeamLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("groupsId")
      public MesBuildingGroupsTeamLink.MesBuildingGroupsTeamLinkBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("teamId")
      public MesBuildingGroupsTeamLink.MesBuildingGroupsTeamLinkBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public MesBuildingGroupsTeamLink build() {
         return new MesBuildingGroupsTeamLink(this.id, this.groupsId, this.teamId);
      }

      @Override
      public String toString() {
         return "MesBuildingGroupsTeamLink.MesBuildingGroupsTeamLinkBuilder(id=" + this.id + ", groupsId=" + this.groupsId + ", teamId=" + this.teamId + ")";
      }
   }
}
