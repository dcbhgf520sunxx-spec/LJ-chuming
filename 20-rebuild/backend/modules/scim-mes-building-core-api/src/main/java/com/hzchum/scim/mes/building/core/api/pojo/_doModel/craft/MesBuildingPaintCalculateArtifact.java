package com.hzchum.scim.mes.building.core.api.pojo._doModel.craft;

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

@ApiModel(value = "MesBuildingPaintCalculateArtifact对象", description = "油漆计算记录构件表")
@Entity
@TableName("mes_building_paint_calculate_artifact")
@Table(
   name = "mes_building_paint_calculate_artifact",
   indexes = {
         @Index(name = "paint_technology_id", columnList = "paint_technology_id"),
         @Index(name = "paint_calculate_record_id", columnList = "paint_calculate_record_id"),
         @Index(name = "structure_class_id", columnList = "structure_class_id"),
         @Index(name = "project_id", columnList = "project_id, monomer_id, area_id"),
         @Index(name = "artifact_id", columnList = "artifact_id")
   }
)
@org.hibernate.annotations.Table(appliesTo = "mes_building_paint_calculate_artifact", comment = "油漆计算记录构件表")
public class MesBuildingPaintCalculateArtifact extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "paintCalculateRecordId", value = "油漆计算记录id", notes = "油漆计算记录id")
   @TableField("paint_calculate_record_id")
   @Column(name = "paint_calculate_record_id", columnDefinition = "bigint(20)  COMMENT '油漆计算记录id'", nullable = false)
   private Long paintCalculateRecordId;
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
   @ApiModelProperty(name = "structureClassId", value = "构件种类id", notes = "构件种类id")
   @TableField("structure_class_id")
   @Column(name = "structure_class_id", columnDefinition = "bigint(20)  COMMENT '构件种类id'", nullable = false)
   private Long structureClassId;
   @ApiModelProperty(name = "artifactId", value = "构件id", notes = "构件id")
   @TableField("artifact_id")
   @Column(name = "artifact_id", columnDefinition = "bigint(20)  COMMENT '构件id'", nullable = false)
   private Long artifactId;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11)  COMMENT '数量'", nullable = false)
   private Integer quantity;

   public static MesBuildingPaintCalculateArtifact.MesBuildingPaintCalculateArtifactBuilder builder() {
      return new MesBuildingPaintCalculateArtifact.MesBuildingPaintCalculateArtifactBuilder();
   }

   public MesBuildingPaintCalculateArtifact() {
   }

   public MesBuildingPaintCalculateArtifact(
      final Long id,
      final Long paintTechnologyId,
      final Long paintCalculateRecordId,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long structureClassId,
      final Long artifactId,
      final Integer quantity
   ) {
      this.id = id;
      this.paintTechnologyId = paintTechnologyId;
      this.paintCalculateRecordId = paintCalculateRecordId;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.structureClassId = structureClassId;
      this.artifactId = artifactId;
      this.quantity = quantity;
   }

   public Long getId() {
      return this.id;
   }

   public Long getPaintTechnologyId() {
      return this.paintTechnologyId;
   }

   public Long getPaintCalculateRecordId() {
      return this.paintCalculateRecordId;
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

   public Long getStructureClassId() {
      return this.structureClassId;
   }

   public Long getArtifactId() {
      return this.artifactId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public MesBuildingPaintCalculateArtifact setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingPaintCalculateArtifact setPaintTechnologyId(final Long paintTechnologyId) {
      this.paintTechnologyId = paintTechnologyId;
      return this;
   }

   public MesBuildingPaintCalculateArtifact setPaintCalculateRecordId(final Long paintCalculateRecordId) {
      this.paintCalculateRecordId = paintCalculateRecordId;
      return this;
   }

   public MesBuildingPaintCalculateArtifact setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public MesBuildingPaintCalculateArtifact setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public MesBuildingPaintCalculateArtifact setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public MesBuildingPaintCalculateArtifact setStructureClassId(final Long structureClassId) {
      this.structureClassId = structureClassId;
      return this;
   }

   public MesBuildingPaintCalculateArtifact setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
      return this;
   }

   public MesBuildingPaintCalculateArtifact setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingPaintCalculateArtifact(id="
         + this.getId()
         + ", paintTechnologyId="
         + this.getPaintTechnologyId()
         + ", paintCalculateRecordId="
         + this.getPaintCalculateRecordId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", structureClassId="
         + this.getStructureClassId()
         + ", artifactId="
         + this.getArtifactId()
         + ", quantity="
         + this.getQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPaintCalculateArtifact)) {
         return false;
      }

      MesBuildingPaintCalculateArtifact other = (MesBuildingPaintCalculateArtifact)o;
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
            Object this$paintCalculateRecordId = this.getPaintCalculateRecordId();
            Object other$paintCalculateRecordId = other.getPaintCalculateRecordId();
            if (this$paintCalculateRecordId == null ? other$paintCalculateRecordId == null : this$paintCalculateRecordId.equals(other$paintCalculateRecordId)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$monomerId = this.getMonomerId();
                  Object other$monomerId = other.getMonomerId();
                  if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                     Object this$areaId = this.getAreaId();
                     Object other$areaId = other.getAreaId();
                     if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                        Object this$structureClassId = this.getStructureClassId();
                        Object other$structureClassId = other.getStructureClassId();
                        if (this$structureClassId == null ? other$structureClassId == null : this$structureClassId.equals(other$structureClassId)) {
                           Object this$artifactId = this.getArtifactId();
                           Object other$artifactId = other.getArtifactId();
                           if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
                              Object this$quantity = this.getQuantity();
                              Object other$quantity = other.getQuantity();
                              return this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity);
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
      return other instanceof MesBuildingPaintCalculateArtifact;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $paintTechnologyId = this.getPaintTechnologyId();
      result = result * 59 + ($paintTechnologyId == null ? 43 : $paintTechnologyId.hashCode());
      Object $paintCalculateRecordId = this.getPaintCalculateRecordId();
      result = result * 59 + ($paintCalculateRecordId == null ? 43 : $paintCalculateRecordId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $structureClassId = this.getStructureClassId();
      result = result * 59 + ($structureClassId == null ? 43 : $structureClassId.hashCode());
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   public static class MesBuildingPaintCalculateArtifactBuilder {
      private Long id;
      private Long paintTechnologyId;
      private Long paintCalculateRecordId;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long structureClassId;
      private Long artifactId;
      private Integer quantity;

      MesBuildingPaintCalculateArtifactBuilder() {
      }

      public MesBuildingPaintCalculateArtifact.MesBuildingPaintCalculateArtifactBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingPaintCalculateArtifact.MesBuildingPaintCalculateArtifactBuilder paintTechnologyId(final Long paintTechnologyId) {
         this.paintTechnologyId = paintTechnologyId;
         return this;
      }

      public MesBuildingPaintCalculateArtifact.MesBuildingPaintCalculateArtifactBuilder paintCalculateRecordId(final Long paintCalculateRecordId) {
         this.paintCalculateRecordId = paintCalculateRecordId;
         return this;
      }

      public MesBuildingPaintCalculateArtifact.MesBuildingPaintCalculateArtifactBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesBuildingPaintCalculateArtifact.MesBuildingPaintCalculateArtifactBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public MesBuildingPaintCalculateArtifact.MesBuildingPaintCalculateArtifactBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public MesBuildingPaintCalculateArtifact.MesBuildingPaintCalculateArtifactBuilder structureClassId(final Long structureClassId) {
         this.structureClassId = structureClassId;
         return this;
      }

      public MesBuildingPaintCalculateArtifact.MesBuildingPaintCalculateArtifactBuilder artifactId(final Long artifactId) {
         this.artifactId = artifactId;
         return this;
      }

      public MesBuildingPaintCalculateArtifact.MesBuildingPaintCalculateArtifactBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesBuildingPaintCalculateArtifact build() {
         return new MesBuildingPaintCalculateArtifact(
            this.id,
            this.paintTechnologyId,
            this.paintCalculateRecordId,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.structureClassId,
            this.artifactId,
            this.quantity
         );
      }

      @Override
      public String toString() {
         return "MesBuildingPaintCalculateArtifact.MesBuildingPaintCalculateArtifactBuilder(id="
            + this.id
            + ", paintTechnologyId="
            + this.paintTechnologyId
            + ", paintCalculateRecordId="
            + this.paintCalculateRecordId
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", structureClassId="
            + this.structureClassId
            + ", artifactId="
            + this.artifactId
            + ", quantity="
            + this.quantity
            + ")";
      }
   }
}
