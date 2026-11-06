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

@ApiModel(value = "SysStructureSpecNumberLink对象", description = "构件种类规格名称关联表 ")
@Entity
@TableName("sys_structure_spec_number_link")
@Table(name = "sys_structure_spec_number_link")
@org.hibernate.annotations.Table(appliesTo = "sys_structure_spec_number_link", comment = "构件种类规格名称关联表 ")
public class SysStructureSpecNumberLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "specPrefix", value = "规格前缀", notes = "规格前缀")
   @TableField("spec_prefix")
   @Column(name = "spec_prefix", columnDefinition = "varchar(255)  COMMENT '规格前缀'", nullable = false)
   private String specPrefix;
   @ApiModelProperty(name = "snPrefix", value = "名称", notes = "名称")
   @TableField("sn_prefix")
   @Column(name = "sn_prefix", columnDefinition = "varchar(255)  COMMENT '编号前缀'", nullable = false)
   private String snPrefix;
   @ApiModelProperty(name = "structureClassificationId", value = "构件种类ID", notes = "构件种类ID")
   @TableField("structure_classification_id")
   @Column(name = "structure_classification_id", columnDefinition = "bigint(20)  COMMENT '构件种类ID'", nullable = false)
   private Long structureClassificationId;
   @ApiModelProperty("次构件分类(主构件为null): 1其他 2板材类 4型材类 8檩条类 ")
   @TableField("small_artifact_class_enum")
   @Column(name = "small_artifact_class_enum", columnDefinition = "int(11) default 1 comment '次构件分类(主构件为null): 1其他 2板材类 4型材类 8檩条类'", nullable = false)
   private Integer smallArtifactClassEnum;
   @ApiModelProperty("构件分类 1主构件 2次构件")
   @TableField("artifact_type")
   @Column(name = "artifact_type", columnDefinition = "int(11) default 2 comment '构件分类  1主构件 2次构件'", nullable = false)
   private Integer artifactType;
   @ApiModelProperty("mes分类 1建钢 2桥梁")
   @TableField("mes_product_enum")
   @Column(name = "mes_product_enum", columnDefinition = "int(11) default 1 COMMENT 'mes分类 1建钢 2桥梁'", nullable = false)
   private Integer mesProductEnum;

   public static SysStructureSpecNumberLink.SysStructureSpecNumberLinkBuilder builder() {
      return new SysStructureSpecNumberLink.SysStructureSpecNumberLinkBuilder();
   }

   public SysStructureSpecNumberLink() {
   }

   public SysStructureSpecNumberLink(
      final Long id,
      final String specPrefix,
      final String snPrefix,
      final Long structureClassificationId,
      final Integer smallArtifactClassEnum,
      final Integer artifactType,
      final Integer mesProductEnum
   ) {
      this.id = id;
      this.specPrefix = specPrefix;
      this.snPrefix = snPrefix;
      this.structureClassificationId = structureClassificationId;
      this.smallArtifactClassEnum = smallArtifactClassEnum;
      this.artifactType = artifactType;
      this.mesProductEnum = mesProductEnum;
   }

   public Long getId() {
      return this.id;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public String getSnPrefix() {
      return this.snPrefix;
   }

   public Long getStructureClassificationId() {
      return this.structureClassificationId;
   }

   public Integer getSmallArtifactClassEnum() {
      return this.smallArtifactClassEnum;
   }

   public Integer getArtifactType() {
      return this.artifactType;
   }

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
   }

   public SysStructureSpecNumberLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysStructureSpecNumberLink setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
      return this;
   }

   public SysStructureSpecNumberLink setSnPrefix(final String snPrefix) {
      this.snPrefix = snPrefix;
      return this;
   }

   public SysStructureSpecNumberLink setStructureClassificationId(final Long structureClassificationId) {
      this.structureClassificationId = structureClassificationId;
      return this;
   }

   public SysStructureSpecNumberLink setSmallArtifactClassEnum(final Integer smallArtifactClassEnum) {
      this.smallArtifactClassEnum = smallArtifactClassEnum;
      return this;
   }

   public SysStructureSpecNumberLink setArtifactType(final Integer artifactType) {
      this.artifactType = artifactType;
      return this;
   }

   public SysStructureSpecNumberLink setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
      return this;
   }

   @Override
   public String toString() {
      return "SysStructureSpecNumberLink(id="
         + this.getId()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", snPrefix="
         + this.getSnPrefix()
         + ", structureClassificationId="
         + this.getStructureClassificationId()
         + ", smallArtifactClassEnum="
         + this.getSmallArtifactClassEnum()
         + ", artifactType="
         + this.getArtifactType()
         + ", mesProductEnum="
         + this.getMesProductEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysStructureSpecNumberLink)) {
         return false;
      }

      SysStructureSpecNumberLink other = (SysStructureSpecNumberLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$structureClassificationId = this.getStructureClassificationId();
         Object other$structureClassificationId = other.getStructureClassificationId();
         if (this$structureClassificationId == null
            ? other$structureClassificationId == null
            : this$structureClassificationId.equals(other$structureClassificationId)) {
            Object this$smallArtifactClassEnum = this.getSmallArtifactClassEnum();
            Object other$smallArtifactClassEnum = other.getSmallArtifactClassEnum();
            if (this$smallArtifactClassEnum == null ? other$smallArtifactClassEnum == null : this$smallArtifactClassEnum.equals(other$smallArtifactClassEnum)) {
               Object this$artifactType = this.getArtifactType();
               Object other$artifactType = other.getArtifactType();
               if (this$artifactType == null ? other$artifactType == null : this$artifactType.equals(other$artifactType)) {
                  Object this$mesProductEnum = this.getMesProductEnum();
                  Object other$mesProductEnum = other.getMesProductEnum();
                  if (this$mesProductEnum == null ? other$mesProductEnum == null : this$mesProductEnum.equals(other$mesProductEnum)) {
                     Object this$specPrefix = this.getSpecPrefix();
                     Object other$specPrefix = other.getSpecPrefix();
                     if (this$specPrefix == null ? other$specPrefix == null : this$specPrefix.equals(other$specPrefix)) {
                        Object this$snPrefix = this.getSnPrefix();
                        Object other$snPrefix = other.getSnPrefix();
                        return this$snPrefix == null ? other$snPrefix == null : this$snPrefix.equals(other$snPrefix);
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
      return other instanceof SysStructureSpecNumberLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $structureClassificationId = this.getStructureClassificationId();
      result = result * 59 + ($structureClassificationId == null ? 43 : $structureClassificationId.hashCode());
      Object $smallArtifactClassEnum = this.getSmallArtifactClassEnum();
      result = result * 59 + ($smallArtifactClassEnum == null ? 43 : $smallArtifactClassEnum.hashCode());
      Object $artifactType = this.getArtifactType();
      result = result * 59 + ($artifactType == null ? 43 : $artifactType.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      result = result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
      Object $snPrefix = this.getSnPrefix();
      return result * 59 + ($snPrefix == null ? 43 : $snPrefix.hashCode());
   }

   public static class SysStructureSpecNumberLinkBuilder {
      private Long id;
      private String specPrefix;
      private String snPrefix;
      private Long structureClassificationId;
      private Integer smallArtifactClassEnum;
      private Integer artifactType;
      private Integer mesProductEnum;

      SysStructureSpecNumberLinkBuilder() {
      }

      public SysStructureSpecNumberLink.SysStructureSpecNumberLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysStructureSpecNumberLink.SysStructureSpecNumberLinkBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      public SysStructureSpecNumberLink.SysStructureSpecNumberLinkBuilder snPrefix(final String snPrefix) {
         this.snPrefix = snPrefix;
         return this;
      }

      public SysStructureSpecNumberLink.SysStructureSpecNumberLinkBuilder structureClassificationId(final Long structureClassificationId) {
         this.structureClassificationId = structureClassificationId;
         return this;
      }

      public SysStructureSpecNumberLink.SysStructureSpecNumberLinkBuilder smallArtifactClassEnum(final Integer smallArtifactClassEnum) {
         this.smallArtifactClassEnum = smallArtifactClassEnum;
         return this;
      }

      public SysStructureSpecNumberLink.SysStructureSpecNumberLinkBuilder artifactType(final Integer artifactType) {
         this.artifactType = artifactType;
         return this;
      }

      public SysStructureSpecNumberLink.SysStructureSpecNumberLinkBuilder mesProductEnum(final Integer mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      public SysStructureSpecNumberLink build() {
         return new SysStructureSpecNumberLink(
            this.id, this.specPrefix, this.snPrefix, this.structureClassificationId, this.smallArtifactClassEnum, this.artifactType, this.mesProductEnum
         );
      }

      @Override
      public String toString() {
         return "SysStructureSpecNumberLink.SysStructureSpecNumberLinkBuilder(id="
            + this.id
            + ", specPrefix="
            + this.specPrefix
            + ", snPrefix="
            + this.snPrefix
            + ", structureClassificationId="
            + this.structureClassificationId
            + ", smallArtifactClassEnum="
            + this.smallArtifactClassEnum
            + ", artifactType="
            + this.artifactType
            + ", mesProductEnum="
            + this.mesProductEnum
            + ")";
      }
   }
}
