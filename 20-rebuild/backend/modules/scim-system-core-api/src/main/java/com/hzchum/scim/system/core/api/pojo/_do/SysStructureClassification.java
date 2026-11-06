package com.hzchum.scim.system.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(description = "构件种类配置表 ")
@Entity
@Table(name = "sys_structure_classification")
public class SysStructureClassification extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("种类名称")
   @TableField("classification_name")
   @Column(name = "classification_name", columnDefinition = "varchar(64) comment '种类名称'", nullable = false)
   private String classificationName;
   @ApiModelProperty("构件分类 1主构件 2次构件")
   @TableField("artifact_type")
   @Column(name = "artifact_type", columnDefinition = "int(11) default 1 comment '构件分类  1主构件 2次构件'", nullable = false)
   private Integer artifactType;
   @ApiModelProperty("次构件分类(主构件为null): 1其他 2板材类 4型材类 8檩条类")
   @TableField("small_artifact_class_enum")
   @Column(name = "small_artifact_class_enum", columnDefinition = "int(11) DEFAULT NULL COMMENT '次构件分类(主构件为null): 1其他 2板材类 4型材类 8檩条类'")
   private Integer smallArtifactClassEnum;
   @ApiModelProperty("打码方式 1一物一码 2一物多码 codingTypeEnum")
   @TableField("coding_type")
   @Column(name = "coding_type", columnDefinition = "int(11) default 1 comment '打码方式 1 一物一码 2 一物多码 codingTypeEnum'", nullable = false)
   private Integer codingType;
   @ApiModelProperty("排序")
   @TableField("sort")
   @Column(name = "sort", columnDefinition = "int(11) default 1 comment '排序'", nullable = false)
   private Integer sort;
   @ApiModelProperty(name = "lastChangeId", value = "最新变更记录id", notes = "最新变更记录id")
   @TableField("last_change_id")
   @Column(name = "last_change_id", columnDefinition = "bigint(20)  COMMENT '最新变更记录id'", nullable = true)
   private Long lastChangeId;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   @TableField("production_line_type_enum")
   @Column(name = "production_line_type_enum", columnDefinition = "int(11) default 1 COMMENT '生产线类型 1传统线 2智能线'", nullable = false)
   private Integer productionLineTypeEnum;
   @ApiModelProperty("mes分类 1建钢 2桥梁")
   @TableField("mes_product_enum")
   @Column(name = "mes_product_enum", columnDefinition = "int(11) default 1 COMMENT 'mes分类 1建钢 2桥梁'", nullable = false)
   private Integer mesProductEnum;
   @ApiModelProperty("PL构件是否组合部件")
   @TableField("bool_compose_assemble")
   @Column(name = "bool_compose_assemble", columnDefinition = "tinyint(1) default 1  COMMENT 'PL构件是否组合部件'")
   private Boolean boolComposeAssemble;

   public static SysStructureClassification.SysStructureClassificationBuilder builder() {
      return new SysStructureClassification.SysStructureClassificationBuilder();
   }

   public SysStructureClassification() {
   }

   public SysStructureClassification(
      final Long id,
      final String classificationName,
      final Integer artifactType,
      final Integer smallArtifactClassEnum,
      final Integer codingType,
      final Integer sort,
      final Long lastChangeId,
      final Integer productionLineTypeEnum,
      final Integer mesProductEnum,
      final Boolean boolComposeAssemble
   ) {
      this.id = id;
      this.classificationName = classificationName;
      this.artifactType = artifactType;
      this.smallArtifactClassEnum = smallArtifactClassEnum;
      this.codingType = codingType;
      this.sort = sort;
      this.lastChangeId = lastChangeId;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.mesProductEnum = mesProductEnum;
      this.boolComposeAssemble = boolComposeAssemble;
   }

   public Long getId() {
      return this.id;
   }

   public String getClassificationName() {
      return this.classificationName;
   }

   public Integer getArtifactType() {
      return this.artifactType;
   }

   public Integer getSmallArtifactClassEnum() {
      return this.smallArtifactClassEnum;
   }

   public Integer getCodingType() {
      return this.codingType;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Long getLastChangeId() {
      return this.lastChangeId;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
   }

   public Boolean getBoolComposeAssemble() {
      return this.boolComposeAssemble;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setClassificationName(final String classificationName) {
      this.classificationName = classificationName;
   }

   public void setArtifactType(final Integer artifactType) {
      this.artifactType = artifactType;
   }

   public void setSmallArtifactClassEnum(final Integer smallArtifactClassEnum) {
      this.smallArtifactClassEnum = smallArtifactClassEnum;
   }

   public void setCodingType(final Integer codingType) {
      this.codingType = codingType;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setLastChangeId(final Long lastChangeId) {
      this.lastChangeId = lastChangeId;
   }

   public void setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
   }

   public void setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
   }

   public void setBoolComposeAssemble(final Boolean boolComposeAssemble) {
      this.boolComposeAssemble = boolComposeAssemble;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysStructureClassification)) {
         return false;
      }

      SysStructureClassification other = (SysStructureClassification)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$artifactType = this.getArtifactType();
         Object other$artifactType = other.getArtifactType();
         if (this$artifactType == null ? other$artifactType == null : this$artifactType.equals(other$artifactType)) {
            Object this$smallArtifactClassEnum = this.getSmallArtifactClassEnum();
            Object other$smallArtifactClassEnum = other.getSmallArtifactClassEnum();
            if (this$smallArtifactClassEnum == null ? other$smallArtifactClassEnum == null : this$smallArtifactClassEnum.equals(other$smallArtifactClassEnum)) {
               Object this$codingType = this.getCodingType();
               Object other$codingType = other.getCodingType();
               if (this$codingType == null ? other$codingType == null : this$codingType.equals(other$codingType)) {
                  Object this$sort = this.getSort();
                  Object other$sort = other.getSort();
                  if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                     Object this$lastChangeId = this.getLastChangeId();
                     Object other$lastChangeId = other.getLastChangeId();
                     if (this$lastChangeId == null ? other$lastChangeId == null : this$lastChangeId.equals(other$lastChangeId)) {
                        Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
                        Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
                        if (this$productionLineTypeEnum == null
                           ? other$productionLineTypeEnum == null
                           : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
                           Object this$mesProductEnum = this.getMesProductEnum();
                           Object other$mesProductEnum = other.getMesProductEnum();
                           if (this$mesProductEnum == null ? other$mesProductEnum == null : this$mesProductEnum.equals(other$mesProductEnum)) {
                              Object this$boolComposeAssemble = this.getBoolComposeAssemble();
                              Object other$boolComposeAssemble = other.getBoolComposeAssemble();
                              if (this$boolComposeAssemble == null
                                 ? other$boolComposeAssemble == null
                                 : this$boolComposeAssemble.equals(other$boolComposeAssemble)) {
                                 Object this$classificationName = this.getClassificationName();
                                 Object other$classificationName = other.getClassificationName();
                                 return this$classificationName == null
                                    ? other$classificationName == null
                                    : this$classificationName.equals(other$classificationName);
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysStructureClassification;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $artifactType = this.getArtifactType();
      result = result * 59 + ($artifactType == null ? 43 : $artifactType.hashCode());
      Object $smallArtifactClassEnum = this.getSmallArtifactClassEnum();
      result = result * 59 + ($smallArtifactClassEnum == null ? 43 : $smallArtifactClassEnum.hashCode());
      Object $codingType = this.getCodingType();
      result = result * 59 + ($codingType == null ? 43 : $codingType.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $lastChangeId = this.getLastChangeId();
      result = result * 59 + ($lastChangeId == null ? 43 : $lastChangeId.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $boolComposeAssemble = this.getBoolComposeAssemble();
      result = result * 59 + ($boolComposeAssemble == null ? 43 : $boolComposeAssemble.hashCode());
      Object $classificationName = this.getClassificationName();
      return result * 59 + ($classificationName == null ? 43 : $classificationName.hashCode());
   }

   @Override
   public String toString() {
      return "SysStructureClassification(id="
         + this.getId()
         + ", classificationName="
         + this.getClassificationName()
         + ", artifactType="
         + this.getArtifactType()
         + ", smallArtifactClassEnum="
         + this.getSmallArtifactClassEnum()
         + ", codingType="
         + this.getCodingType()
         + ", sort="
         + this.getSort()
         + ", lastChangeId="
         + this.getLastChangeId()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", mesProductEnum="
         + this.getMesProductEnum()
         + ", boolComposeAssemble="
         + this.getBoolComposeAssemble()
         + ")";
   }

   public static class SysStructureClassificationBuilder {
      private Long id;
      private String classificationName;
      private Integer artifactType;
      private Integer smallArtifactClassEnum;
      private Integer codingType;
      private Integer sort;
      private Long lastChangeId;
      private Integer productionLineTypeEnum;
      private Integer mesProductEnum;
      private Boolean boolComposeAssemble;

      SysStructureClassificationBuilder() {
      }

      public SysStructureClassification.SysStructureClassificationBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysStructureClassification.SysStructureClassificationBuilder classificationName(final String classificationName) {
         this.classificationName = classificationName;
         return this;
      }

      public SysStructureClassification.SysStructureClassificationBuilder artifactType(final Integer artifactType) {
         this.artifactType = artifactType;
         return this;
      }

      public SysStructureClassification.SysStructureClassificationBuilder smallArtifactClassEnum(final Integer smallArtifactClassEnum) {
         this.smallArtifactClassEnum = smallArtifactClassEnum;
         return this;
      }

      public SysStructureClassification.SysStructureClassificationBuilder codingType(final Integer codingType) {
         this.codingType = codingType;
         return this;
      }

      public SysStructureClassification.SysStructureClassificationBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public SysStructureClassification.SysStructureClassificationBuilder lastChangeId(final Long lastChangeId) {
         this.lastChangeId = lastChangeId;
         return this;
      }

      public SysStructureClassification.SysStructureClassificationBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      public SysStructureClassification.SysStructureClassificationBuilder mesProductEnum(final Integer mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      public SysStructureClassification.SysStructureClassificationBuilder boolComposeAssemble(final Boolean boolComposeAssemble) {
         this.boolComposeAssemble = boolComposeAssemble;
         return this;
      }

      public SysStructureClassification build() {
         return new SysStructureClassification(
            this.id,
            this.classificationName,
            this.artifactType,
            this.smallArtifactClassEnum,
            this.codingType,
            this.sort,
            this.lastChangeId,
            this.productionLineTypeEnum,
            this.mesProductEnum,
            this.boolComposeAssemble
         );
      }

      @Override
      public String toString() {
         return "SysStructureClassification.SysStructureClassificationBuilder(id="
            + this.id
            + ", classificationName="
            + this.classificationName
            + ", artifactType="
            + this.artifactType
            + ", smallArtifactClassEnum="
            + this.smallArtifactClassEnum
            + ", codingType="
            + this.codingType
            + ", sort="
            + this.sort
            + ", lastChangeId="
            + this.lastChangeId
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", mesProductEnum="
            + this.mesProductEnum
            + ", boolComposeAssemble="
            + this.boolComposeAssemble
            + ")";
      }
   }
}
