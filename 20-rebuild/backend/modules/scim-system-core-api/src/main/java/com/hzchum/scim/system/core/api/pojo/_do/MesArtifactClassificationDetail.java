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

@ApiModel(value = "MesArtifactClassificationDetail对象", description = "构件分类详情表")
@Entity
@TableName("mes_artifact_classification_detail")
@Table(name = "mes_artifact_classification_detail")
@org.hibernate.annotations.Table(appliesTo = "mes_artifact_classification_detail", comment = "构件分类详情表")
public class MesArtifactClassificationDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "artifactClassificationId", value = "构件分类ID", notes = "构件分类ID")
   @TableField("artifact_classification_id")
   @Column(name = "artifact_classification_id", columnDefinition = "bigint(20)  COMMENT '构件分类ID'", nullable = true)
   private Long artifactClassificationId;
   @ApiModelProperty(name = "nameOrType", value = "1: 清单构件名称索引, 2: 截面类型索引", notes = "1: 清单构件名称索引, 2: 截面类型索引")
   @TableField("name_or_type")
   @Column(name = "name_or_type", columnDefinition = "int(11)  COMMENT '1: 清单构件名称索引, 2: 截面类型索引'", nullable = true)
   private Integer nameOrType;
   @ApiModelProperty(name = "indexName", value = "清单构件名称索引/截面类型索引", notes = "清单构件名称索引/截面类型索引")
   @TableField("index_name")
   @Column(name = "index_name", columnDefinition = "varchar(500)  COMMENT '清单构件名称索引/截面类型索引'", nullable = true)
   private String indexName;

   public static MesArtifactClassificationDetail.MesArtifactClassificationDetailBuilder builder() {
      return new MesArtifactClassificationDetail.MesArtifactClassificationDetailBuilder();
   }

   public MesArtifactClassificationDetail() {
   }

   public MesArtifactClassificationDetail(final Long id, final Long artifactClassificationId, final Integer nameOrType, final String indexName) {
      this.id = id;
      this.artifactClassificationId = artifactClassificationId;
      this.nameOrType = nameOrType;
      this.indexName = indexName;
   }

   public Long getId() {
      return this.id;
   }

   public Long getArtifactClassificationId() {
      return this.artifactClassificationId;
   }

   public Integer getNameOrType() {
      return this.nameOrType;
   }

   public String getIndexName() {
      return this.indexName;
   }

   public MesArtifactClassificationDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesArtifactClassificationDetail setArtifactClassificationId(final Long artifactClassificationId) {
      this.artifactClassificationId = artifactClassificationId;
      return this;
   }

   public MesArtifactClassificationDetail setNameOrType(final Integer nameOrType) {
      this.nameOrType = nameOrType;
      return this;
   }

   public MesArtifactClassificationDetail setIndexName(final String indexName) {
      this.indexName = indexName;
      return this;
   }

   @Override
   public String toString() {
      return "MesArtifactClassificationDetail(id="
         + this.getId()
         + ", artifactClassificationId="
         + this.getArtifactClassificationId()
         + ", nameOrType="
         + this.getNameOrType()
         + ", indexName="
         + this.getIndexName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesArtifactClassificationDetail)) {
         return false;
      }

      MesArtifactClassificationDetail other = (MesArtifactClassificationDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$artifactClassificationId = this.getArtifactClassificationId();
         Object other$artifactClassificationId = other.getArtifactClassificationId();
         if (this$artifactClassificationId == null
            ? other$artifactClassificationId == null
            : this$artifactClassificationId.equals(other$artifactClassificationId)) {
            Object this$nameOrType = this.getNameOrType();
            Object other$nameOrType = other.getNameOrType();
            if (this$nameOrType == null ? other$nameOrType == null : this$nameOrType.equals(other$nameOrType)) {
               Object this$indexName = this.getIndexName();
               Object other$indexName = other.getIndexName();
               return this$indexName == null ? other$indexName == null : this$indexName.equals(other$indexName);
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
      return other instanceof MesArtifactClassificationDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $artifactClassificationId = this.getArtifactClassificationId();
      result = result * 59 + ($artifactClassificationId == null ? 43 : $artifactClassificationId.hashCode());
      Object $nameOrType = this.getNameOrType();
      result = result * 59 + ($nameOrType == null ? 43 : $nameOrType.hashCode());
      Object $indexName = this.getIndexName();
      return result * 59 + ($indexName == null ? 43 : $indexName.hashCode());
   }

   public static class MesArtifactClassificationDetailBuilder {
      private Long id;
      private Long artifactClassificationId;
      private Integer nameOrType;
      private String indexName;

      MesArtifactClassificationDetailBuilder() {
      }

      public MesArtifactClassificationDetail.MesArtifactClassificationDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesArtifactClassificationDetail.MesArtifactClassificationDetailBuilder artifactClassificationId(final Long artifactClassificationId) {
         this.artifactClassificationId = artifactClassificationId;
         return this;
      }

      public MesArtifactClassificationDetail.MesArtifactClassificationDetailBuilder nameOrType(final Integer nameOrType) {
         this.nameOrType = nameOrType;
         return this;
      }

      public MesArtifactClassificationDetail.MesArtifactClassificationDetailBuilder indexName(final String indexName) {
         this.indexName = indexName;
         return this;
      }

      public MesArtifactClassificationDetail build() {
         return new MesArtifactClassificationDetail(this.id, this.artifactClassificationId, this.nameOrType, this.indexName);
      }

      @Override
      public String toString() {
         return "MesArtifactClassificationDetail.MesArtifactClassificationDetailBuilder(id="
            + this.id
            + ", artifactClassificationId="
            + this.artifactClassificationId
            + ", nameOrType="
            + this.nameOrType
            + ", indexName="
            + this.indexName
            + ")";
      }
   }
}
