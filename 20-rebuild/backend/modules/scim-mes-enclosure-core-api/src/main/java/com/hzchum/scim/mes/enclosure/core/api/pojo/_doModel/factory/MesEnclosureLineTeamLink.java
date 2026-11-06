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

@ApiModel(value = "MesEnclosureLineTeamLink对象", description = "产线班组关联关系 ")
@Entity
@TableName("mes_enclosure_line_team_link")
@Table(name = "mes_enclosure_line_team_link")
public class MesEnclosureLineTeamLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "line_id", value = "产线id", notes = "产线id")
   @JsonProperty("line_id")
   @JSONField(name = "line_id")
   @TableField("line_id")
   @Column(name = "line_id", columnDefinition = "bigint(20)  COMMENT '产线id'", nullable = false)
   private Long lineId;
   @ApiModelProperty(name = "teamId", value = "生产班组id", notes = "生产班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20)  COMMENT '生产班组id'", nullable = false)
   private Long teamId;

   public static MesEnclosureLineTeamLink.MesEnclosureLineTeamLinkBuilder builder() {
      return new MesEnclosureLineTeamLink.MesEnclosureLineTeamLinkBuilder();
   }

   public MesEnclosureLineTeamLink() {
   }

   public MesEnclosureLineTeamLink(final Long id, final Long lineId, final Long teamId) {
      this.id = id;
      this.lineId = lineId;
      this.teamId = teamId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getLineId() {
      return this.lineId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   @JsonProperty("id")
   public MesEnclosureLineTeamLink setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("line_id")
   public MesEnclosureLineTeamLink setLineId(final Long lineId) {
      this.lineId = lineId;
      return this;
   }

   @JsonProperty("teamId")
   public MesEnclosureLineTeamLink setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureLineTeamLink(id=" + this.getId() + ", lineId=" + this.getLineId() + ", teamId=" + this.getTeamId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureLineTeamLink)) {
         return false;
      }

      MesEnclosureLineTeamLink other = (MesEnclosureLineTeamLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$lineId = this.getLineId();
         Object other$lineId = other.getLineId();
         if (this$lineId == null ? other$lineId == null : this$lineId.equals(other$lineId)) {
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
      return other instanceof MesEnclosureLineTeamLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $lineId = this.getLineId();
      result = result * 59 + ($lineId == null ? 43 : $lineId.hashCode());
      Object $teamId = this.getTeamId();
      return result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
   }

   public static class MesEnclosureLineTeamLinkBuilder {
      private Long id;
      private Long lineId;
      private Long teamId;

      MesEnclosureLineTeamLinkBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureLineTeamLink.MesEnclosureLineTeamLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("line_id")
      public MesEnclosureLineTeamLink.MesEnclosureLineTeamLinkBuilder lineId(final Long lineId) {
         this.lineId = lineId;
         return this;
      }

      @JsonProperty("teamId")
      public MesEnclosureLineTeamLink.MesEnclosureLineTeamLinkBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public MesEnclosureLineTeamLink build() {
         return new MesEnclosureLineTeamLink(this.id, this.lineId, this.teamId);
      }

      @Override
      public String toString() {
         return "MesEnclosureLineTeamLink.MesEnclosureLineTeamLinkBuilder(id=" + this.id + ", lineId=" + this.lineId + ", teamId=" + this.teamId + ")";
      }
   }
}
