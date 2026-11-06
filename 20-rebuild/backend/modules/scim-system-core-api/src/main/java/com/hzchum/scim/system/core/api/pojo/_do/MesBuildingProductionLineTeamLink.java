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

@ApiModel(value = "MesBuildingProductionLineTeamLink对象", description = "生产线班组关联表")
@Entity
@TableName("mes_building_production_line_team_link")
@Table(name = "mes_building_production_line_team_link")
@org.hibernate.annotations.Table(appliesTo = "mes_building_production_line_team_link", comment = "生产线班组关联表")
public class MesBuildingProductionLineTeamLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   @TableField("production_line_id")
   @Column(name = "production_line_id", columnDefinition = "bigint(20)  COMMENT '生产线id'", nullable = false)
   private Long productionLineId;
   @ApiModelProperty(name = "teamId", value = "生产班组id", notes = "生产班组id")
   @TableField("team_id")
   @Column(name = "team_id", columnDefinition = "bigint(20)  COMMENT '生产班组id'", nullable = false)
   private Long teamId;
   @ApiModelProperty(name = "teamType", value = "班组类型[0 班组 1 质检班组]", notes = "班组类型[0 班组 1 质检班组]")
   @TableField("team_type")
   @Column(name = "team_type", columnDefinition = "tinyint(1)  COMMENT '班组类型[0 班组 1 质检班组]'", nullable = true)
   private Boolean teamType;

   public static MesBuildingProductionLineTeamLink.MesBuildingProductionLineTeamLinkBuilder builder() {
      return new MesBuildingProductionLineTeamLink.MesBuildingProductionLineTeamLinkBuilder();
   }

   public MesBuildingProductionLineTeamLink() {
   }

   public MesBuildingProductionLineTeamLink(final Long id, final Long productionLineId, final Long teamId, final Boolean teamType) {
      this.id = id;
      this.productionLineId = productionLineId;
      this.teamId = teamId;
      this.teamType = teamType;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProductionLineId() {
      return this.productionLineId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Boolean getTeamType() {
      return this.teamType;
   }

   public MesBuildingProductionLineTeamLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingProductionLineTeamLink setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
      return this;
   }

   public MesBuildingProductionLineTeamLink setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   public MesBuildingProductionLineTeamLink setTeamType(final Boolean teamType) {
      this.teamType = teamType;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProductionLineTeamLink(id="
         + this.getId()
         + ", productionLineId="
         + this.getProductionLineId()
         + ", teamId="
         + this.getTeamId()
         + ", teamType="
         + this.getTeamType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProductionLineTeamLink)) {
         return false;
      }

      MesBuildingProductionLineTeamLink other = (MesBuildingProductionLineTeamLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productionLineId = this.getProductionLineId();
         Object other$productionLineId = other.getProductionLineId();
         if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
            Object this$teamId = this.getTeamId();
            Object other$teamId = other.getTeamId();
            if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
               Object this$teamType = this.getTeamType();
               Object other$teamType = other.getTeamType();
               return this$teamType == null ? other$teamType == null : this$teamType.equals(other$teamType);
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
      return other instanceof MesBuildingProductionLineTeamLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $teamType = this.getTeamType();
      return result * 59 + ($teamType == null ? 43 : $teamType.hashCode());
   }

   public static class MesBuildingProductionLineTeamLinkBuilder {
      private Long id;
      private Long productionLineId;
      private Long teamId;
      private Boolean teamType;

      MesBuildingProductionLineTeamLinkBuilder() {
      }

      public MesBuildingProductionLineTeamLink.MesBuildingProductionLineTeamLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingProductionLineTeamLink.MesBuildingProductionLineTeamLinkBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
         return this;
      }

      public MesBuildingProductionLineTeamLink.MesBuildingProductionLineTeamLinkBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public MesBuildingProductionLineTeamLink.MesBuildingProductionLineTeamLinkBuilder teamType(final Boolean teamType) {
         this.teamType = teamType;
         return this;
      }

      public MesBuildingProductionLineTeamLink build() {
         return new MesBuildingProductionLineTeamLink(this.id, this.productionLineId, this.teamId, this.teamType);
      }

      @Override
      public String toString() {
         return "MesBuildingProductionLineTeamLink.MesBuildingProductionLineTeamLinkBuilder(id="
            + this.id
            + ", productionLineId="
            + this.productionLineId
            + ", teamId="
            + this.teamId
            + ", teamType="
            + this.teamType
            + ")";
      }
   }
}
