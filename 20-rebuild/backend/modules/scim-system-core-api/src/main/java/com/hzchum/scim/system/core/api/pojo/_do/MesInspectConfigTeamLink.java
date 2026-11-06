package com.hzchum.scim.system.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "MesInspectConfigTeamLink对象", description = "质检基础配置、班组关联关系表")
@Entity
@TableName("mes_inspect_config_team_link")
@Table(name = "mes_inspect_config_team_link")
@org.hibernate.annotations.Table(appliesTo = "mes_inspect_config_team_link", comment = "质检基础配置、班组关联关系表")
public class MesInspectConfigTeamLink extends BaseEntity<Long> implements Cloneable {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "inspectConfigId", value = "质检配置id", notes = "质检配置id")
   @TableField("inspect_config_id")
   @Column(name = "inspect_config_id", columnDefinition = "bigint(20)  COMMENT '质检配置id'", nullable = false)
   private Long inspectConfigId;
   @ApiModelProperty(name = "teamId", value = "班组id", notes = "班组id")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20)  COMMENT '班组id'", nullable = false)
   private Long teamId;

   public MesInspectConfigTeamLink clone() throws CloneNotSupportedException {
      return (MesInspectConfigTeamLink)super.clone();
   }

   public static MesInspectConfigTeamLink.MesInspectConfigTeamLinkBuilder builder() {
      return new MesInspectConfigTeamLink.MesInspectConfigTeamLinkBuilder();
   }

   public MesInspectConfigTeamLink() {
   }

   public MesInspectConfigTeamLink(final Long id, final Long inspectConfigId, final Long teamId) {
      this.id = id;
      this.inspectConfigId = inspectConfigId;
      this.teamId = teamId;
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

   public MesInspectConfigTeamLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesInspectConfigTeamLink setInspectConfigId(final Long inspectConfigId) {
      this.inspectConfigId = inspectConfigId;
      return this;
   }

   public MesInspectConfigTeamLink setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @Override
   public String toString() {
      return "MesInspectConfigTeamLink(id=" + this.getId() + ", inspectConfigId=" + this.getInspectConfigId() + ", teamId=" + this.getTeamId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesInspectConfigTeamLink)) {
         return false;
      }

      MesInspectConfigTeamLink other = (MesInspectConfigTeamLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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
      return other instanceof MesInspectConfigTeamLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $inspectConfigId = this.getInspectConfigId();
      result = result * 59 + ($inspectConfigId == null ? 43 : $inspectConfigId.hashCode());
      Object $teamId = this.getTeamId();
      return result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
   }

   public static class MesInspectConfigTeamLinkBuilder {
      private Long id;
      private Long inspectConfigId;
      private Long teamId;

      MesInspectConfigTeamLinkBuilder() {
      }

      public MesInspectConfigTeamLink.MesInspectConfigTeamLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesInspectConfigTeamLink.MesInspectConfigTeamLinkBuilder inspectConfigId(final Long inspectConfigId) {
         this.inspectConfigId = inspectConfigId;
         return this;
      }

      public MesInspectConfigTeamLink.MesInspectConfigTeamLinkBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public MesInspectConfigTeamLink build() {
         return new MesInspectConfigTeamLink(this.id, this.inspectConfigId, this.teamId);
      }

      @Override
      public String toString() {
         return "MesInspectConfigTeamLink.MesInspectConfigTeamLinkBuilder(id="
            + this.id
            + ", inspectConfigId="
            + this.inspectConfigId
            + ", teamId="
            + this.teamId
            + ")";
      }
   }
}
