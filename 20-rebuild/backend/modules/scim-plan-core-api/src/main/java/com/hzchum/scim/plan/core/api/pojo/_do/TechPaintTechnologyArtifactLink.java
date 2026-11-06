package com.hzchum.scim.plan.core.api.pojo._do;

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
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "TechPaintTechnologyArtifactLink对象", description = "喷漆工艺构件关联表 ")
@Entity
@TableName("tech_paint_technology_artifact_link")
@Table(
   name = "tech_paint_technology_artifact_link",
   indexes = {
         @Index(name = "paint_technology_id", columnList = "paint_technology_id"),
         @Index(name = "project_id", columnList = "project_id, monomer_id, area_id"),
         @Index(name = "monomer_id", columnList = "monomer_id, area_id"),
         @Index(name = "area_id", columnList = "area_id"),
         @Index(name = "artifact_id", columnList = "artifact_id")
   }
)
@org.hibernate.annotations.Table(appliesTo = "tech_paint_technology_artifact_link", comment = "喷漆工艺构件关联表")
public class TechPaintTechnologyArtifactLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "paintTechnologyId", value = "喷漆工艺id", notes = "喷漆工艺id")
   @TableField("paint_technology_id")
   @Column(name = "paint_technology_id", columnDefinition = "bigint(20)  COMMENT '喷漆工艺id'", nullable = false)
   private Long paintTechnologyId;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体id'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域id'", nullable = false)
   private Long areaId;
   @ApiModelProperty(name = "artifactId", value = "构件id", notes = "构件id")
   @TableField("artifact_id")
   @Column(name = "artifact_id", columnDefinition = "bigint(20)  COMMENT '构件id'", nullable = false)
   private Long artifactId;

   public static TechPaintTechnologyArtifactLink.TechPaintTechnologyArtifactLinkBuilder builder() {
      return new TechPaintTechnologyArtifactLink.TechPaintTechnologyArtifactLinkBuilder();
   }

   public TechPaintTechnologyArtifactLink() {
   }

   public TechPaintTechnologyArtifactLink(
      final Long id, final Long paintTechnologyId, final Long projectId, final Long monomerId, final Long areaId, final Long artifactId
   ) {
      this.id = id;
      this.paintTechnologyId = paintTechnologyId;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.artifactId = artifactId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getPaintTechnologyId() {
      return this.paintTechnologyId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getArtifactId() {
      return this.artifactId;
   }

   public TechPaintTechnologyArtifactLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechPaintTechnologyArtifactLink setPaintTechnologyId(final Long paintTechnologyId) {
      this.paintTechnologyId = paintTechnologyId;
      return this;
   }

   public TechPaintTechnologyArtifactLink setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public TechPaintTechnologyArtifactLink setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public TechPaintTechnologyArtifactLink setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public TechPaintTechnologyArtifactLink setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
      return this;
   }

   @Override
   public String toString() {
      return "TechPaintTechnologyArtifactLink(id="
         + this.getId()
         + ", paintTechnologyId="
         + this.getPaintTechnologyId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", artifactId="
         + this.getArtifactId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechPaintTechnologyArtifactLink)) {
         return false;
      }

      TechPaintTechnologyArtifactLink other = (TechPaintTechnologyArtifactLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$paintTechnologyId = this.getPaintTechnologyId();
         Object other$paintTechnologyId = other.getPaintTechnologyId();
         if (this$paintTechnologyId == null ? other$paintTechnologyId == null : this$paintTechnologyId.equals(other$paintTechnologyId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$monomerId = this.getMonomerId();
               Object other$monomerId = other.getMonomerId();
               if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                  Object this$areaId = this.getAreaId();
                  Object other$areaId = other.getAreaId();
                  if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                     Object this$artifactId = this.getArtifactId();
                     Object other$artifactId = other.getArtifactId();
                     return this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId);
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof TechPaintTechnologyArtifactLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $paintTechnologyId = this.getPaintTechnologyId();
      result = result * 59 + ($paintTechnologyId == null ? 43 : $paintTechnologyId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $artifactId = this.getArtifactId();
      return result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
   }

   public static class TechPaintTechnologyArtifactLinkBuilder {
      private Long id;
      private Long paintTechnologyId;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long artifactId;

      TechPaintTechnologyArtifactLinkBuilder() {
      }

      public TechPaintTechnologyArtifactLink.TechPaintTechnologyArtifactLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechPaintTechnologyArtifactLink.TechPaintTechnologyArtifactLinkBuilder paintTechnologyId(final Long paintTechnologyId) {
         this.paintTechnologyId = paintTechnologyId;
         return this;
      }

      public TechPaintTechnologyArtifactLink.TechPaintTechnologyArtifactLinkBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public TechPaintTechnologyArtifactLink.TechPaintTechnologyArtifactLinkBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public TechPaintTechnologyArtifactLink.TechPaintTechnologyArtifactLinkBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public TechPaintTechnologyArtifactLink.TechPaintTechnologyArtifactLinkBuilder artifactId(final Long artifactId) {
         this.artifactId = artifactId;
         return this;
      }

      public TechPaintTechnologyArtifactLink build() {
         return new TechPaintTechnologyArtifactLink(this.id, this.paintTechnologyId, this.projectId, this.monomerId, this.areaId, this.artifactId);
      }

      @Override
      public String toString() {
         return "TechPaintTechnologyArtifactLink.TechPaintTechnologyArtifactLinkBuilder(id="
            + this.id
            + ", paintTechnologyId="
            + this.paintTechnologyId
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", artifactId="
            + this.artifactId
            + ")";
      }
   }
}
