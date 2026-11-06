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

@ApiModel(value = "MesArtifactClassification对象", description = "构件分类表")
@Entity
@TableName("mes_artifact_classification")
@Table(name = "mes_artifact_classification")
@org.hibernate.annotations.Table(appliesTo = "mes_artifact_classification", comment = "构件分类表")
public class MesArtifactClassification extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "classification", value = "构件分类", notes = "构件分类")
   @TableField("classification")
   @Column(name = "classification", columnDefinition = "varchar(255)  COMMENT '构件分类'", nullable = true)
   private String classification;
   @ApiModelProperty(name = "artifactType", value = "构件类型", notes = "构件类型")
   @TableField("artifact_type")
   @Column(name = "artifact_type", columnDefinition = "int(11)  COMMENT '构件类型'", nullable = true)
   private Integer artifactType;

   public static MesArtifactClassification.MesArtifactClassificationBuilder builder() {
      return new MesArtifactClassification.MesArtifactClassificationBuilder();
   }

   public MesArtifactClassification() {
   }

   public MesArtifactClassification(final Long id, final String classification, final Integer artifactType) {
      this.id = id;
      this.classification = classification;
      this.artifactType = artifactType;
   }

   public Long getId() {
      return this.id;
   }

   public String getClassification() {
      return this.classification;
   }

   public Integer getArtifactType() {
      return this.artifactType;
   }

   public MesArtifactClassification setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesArtifactClassification setClassification(final String classification) {
      this.classification = classification;
      return this;
   }

   public MesArtifactClassification setArtifactType(final Integer artifactType) {
      this.artifactType = artifactType;
      return this;
   }

   @Override
   public String toString() {
      return "MesArtifactClassification(id=" + this.getId() + ", classification=" + this.getClassification() + ", artifactType=" + this.getArtifactType() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesArtifactClassification)) {
         return false;
      }

      MesArtifactClassification other = (MesArtifactClassification)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$artifactType = this.getArtifactType();
         Object other$artifactType = other.getArtifactType();
         if (this$artifactType == null ? other$artifactType == null : this$artifactType.equals(other$artifactType)) {
            Object this$classification = this.getClassification();
            Object other$classification = other.getClassification();
            return this$classification == null ? other$classification == null : this$classification.equals(other$classification);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesArtifactClassification;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $artifactType = this.getArtifactType();
      result = result * 59 + ($artifactType == null ? 43 : $artifactType.hashCode());
      Object $classification = this.getClassification();
      return result * 59 + ($classification == null ? 43 : $classification.hashCode());
   }

   public static class MesArtifactClassificationBuilder {
      private Long id;
      private String classification;
      private Integer artifactType;

      MesArtifactClassificationBuilder() {
      }

      public MesArtifactClassification.MesArtifactClassificationBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesArtifactClassification.MesArtifactClassificationBuilder classification(final String classification) {
         this.classification = classification;
         return this;
      }

      public MesArtifactClassification.MesArtifactClassificationBuilder artifactType(final Integer artifactType) {
         this.artifactType = artifactType;
         return this;
      }

      public MesArtifactClassification build() {
         return new MesArtifactClassification(this.id, this.classification, this.artifactType);
      }

      @Override
      public String toString() {
         return "MesArtifactClassification.MesArtifactClassificationBuilder(id="
            + this.id
            + ", classification="
            + this.classification
            + ", artifactType="
            + this.artifactType
            + ")";
      }
   }
}
