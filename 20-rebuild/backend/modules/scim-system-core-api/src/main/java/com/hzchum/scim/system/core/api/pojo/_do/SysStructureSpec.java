package com.hzchum.scim.system.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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

@ApiModel(description = "构件规格配置表 ")
@Entity
@Table(name = "sys_structure_spec")
public class SysStructureSpec extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("构件种类表id")
   @TableField
   @Column(name = "structure_classification_id", columnDefinition = "bigint(20)  comment '构件种类表id'")
   private Long structureClassificationId;
   @ApiModelProperty("构件类型 1普通构件 2次构件")
   @TableField("artifact_type")
   @Column(name = "artifact_type", columnDefinition = "int(11) default 1 comment '构件类型 1普通构件 2次构件'")
   private Integer artifactType;
   @ApiModelProperty("构件规格前缀")
   @TableField("spec_prefix")
   @Column(name = "spec_prefix", columnDefinition = "varchar(128) comment '构件规格前缀'", nullable = false)
   private String specPrefix;
   @ApiModelProperty("次构件分类(主构件为null): 1其他 2板材类 4型材类 8檩条类")
   @TableField("small_artifact_class_enum")
   @Column(name = "small_artifact_class_enum", columnDefinition = "int(11) comment '次构件分类(主构件为null): 1其他 2板材类 4型材类 8檩条类'")
   private Integer smallArtifactClassEnum;
   @ApiModelProperty(name = "productionLineTypeEnum", value = "生产线类型 1传统线 2智能线", notes = "生产线类型 1传统线 2智能线")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   @TableField("production_line_type_enum")
   @Column(name = "production_line_type_enum", columnDefinition = "int(11) default '1' COMMENT '生产线类型 1传统线 2智能线'", nullable = true)
   private Integer productionLineTypeEnum;
   @ApiModelProperty("mes分类 1建钢 2桥梁")
   @TableField("mes_product_enum")
   @Column(name = "mes_product_enum", columnDefinition = "int(11) default 1 COMMENT 'mes分类 1建钢 2桥梁'", nullable = false)
   private Integer mesProductEnum;

   public static SysStructureSpec.SysStructureSpecBuilder builder() {
      return new SysStructureSpec.SysStructureSpecBuilder();
   }

   public SysStructureSpec() {
   }

   public SysStructureSpec(
      final Long id,
      final Long structureClassificationId,
      final Integer artifactType,
      final String specPrefix,
      final Integer smallArtifactClassEnum,
      final Integer productionLineTypeEnum,
      final Integer mesProductEnum
   ) {
      this.id = id;
      this.structureClassificationId = structureClassificationId;
      this.artifactType = artifactType;
      this.specPrefix = specPrefix;
      this.smallArtifactClassEnum = smallArtifactClassEnum;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.mesProductEnum = mesProductEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Long getStructureClassificationId() {
      return this.structureClassificationId;
   }

   public Integer getArtifactType() {
      return this.artifactType;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public Integer getSmallArtifactClassEnum() {
      return this.smallArtifactClassEnum;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setStructureClassificationId(final Long structureClassificationId) {
      this.structureClassificationId = structureClassificationId;
   }

   public void setArtifactType(final Integer artifactType) {
      this.artifactType = artifactType;
   }

   public void setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
   }

   public void setSmallArtifactClassEnum(final Integer smallArtifactClassEnum) {
      this.smallArtifactClassEnum = smallArtifactClassEnum;
   }

   @JsonProperty("productionLineTypeEnum")
   public void setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
   }

   public void setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysStructureSpec)) {
         return false;
      }

      SysStructureSpec other = (SysStructureSpec)o;
      if (!other.canEqual(this)) {
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
            Object this$artifactType = this.getArtifactType();
            Object other$artifactType = other.getArtifactType();
            if (this$artifactType == null ? other$artifactType == null : this$artifactType.equals(other$artifactType)) {
               Object this$smallArtifactClassEnum = this.getSmallArtifactClassEnum();
               Object other$smallArtifactClassEnum = other.getSmallArtifactClassEnum();
               if (this$smallArtifactClassEnum == null
                  ? other$smallArtifactClassEnum == null
                  : this$smallArtifactClassEnum.equals(other$smallArtifactClassEnum)) {
                  Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
                  Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
                  if (this$productionLineTypeEnum == null
                     ? other$productionLineTypeEnum == null
                     : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
                     Object this$mesProductEnum = this.getMesProductEnum();
                     Object other$mesProductEnum = other.getMesProductEnum();
                     if (this$mesProductEnum == null ? other$mesProductEnum == null : this$mesProductEnum.equals(other$mesProductEnum)) {
                        Object this$specPrefix = this.getSpecPrefix();
                        Object other$specPrefix = other.getSpecPrefix();
                        return this$specPrefix == null ? other$specPrefix == null : this$specPrefix.equals(other$specPrefix);
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
      return other instanceof SysStructureSpec;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $structureClassificationId = this.getStructureClassificationId();
      result = result * 59 + ($structureClassificationId == null ? 43 : $structureClassificationId.hashCode());
      Object $artifactType = this.getArtifactType();
      result = result * 59 + ($artifactType == null ? 43 : $artifactType.hashCode());
      Object $smallArtifactClassEnum = this.getSmallArtifactClassEnum();
      result = result * 59 + ($smallArtifactClassEnum == null ? 43 : $smallArtifactClassEnum.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      return result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
   }

   @Override
   public String toString() {
      return "SysStructureSpec(id="
         + this.getId()
         + ", structureClassificationId="
         + this.getStructureClassificationId()
         + ", artifactType="
         + this.getArtifactType()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", smallArtifactClassEnum="
         + this.getSmallArtifactClassEnum()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", mesProductEnum="
         + this.getMesProductEnum()
         + ")";
   }

   public static class SysStructureSpecBuilder {
      private Long id;
      private Long structureClassificationId;
      private Integer artifactType;
      private String specPrefix;
      private Integer smallArtifactClassEnum;
      private Integer productionLineTypeEnum;
      private Integer mesProductEnum;

      SysStructureSpecBuilder() {
      }

      public SysStructureSpec.SysStructureSpecBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysStructureSpec.SysStructureSpecBuilder structureClassificationId(final Long structureClassificationId) {
         this.structureClassificationId = structureClassificationId;
         return this;
      }

      public SysStructureSpec.SysStructureSpecBuilder artifactType(final Integer artifactType) {
         this.artifactType = artifactType;
         return this;
      }

      public SysStructureSpec.SysStructureSpecBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      public SysStructureSpec.SysStructureSpecBuilder smallArtifactClassEnum(final Integer smallArtifactClassEnum) {
         this.smallArtifactClassEnum = smallArtifactClassEnum;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public SysStructureSpec.SysStructureSpecBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      public SysStructureSpec.SysStructureSpecBuilder mesProductEnum(final Integer mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      public SysStructureSpec build() {
         return new SysStructureSpec(
            this.id,
            this.structureClassificationId,
            this.artifactType,
            this.specPrefix,
            this.smallArtifactClassEnum,
            this.productionLineTypeEnum,
            this.mesProductEnum
         );
      }

      @Override
      public String toString() {
         return "SysStructureSpec.SysStructureSpecBuilder(id="
            + this.id
            + ", structureClassificationId="
            + this.structureClassificationId
            + ", artifactType="
            + this.artifactType
            + ", specPrefix="
            + this.specPrefix
            + ", smallArtifactClassEnum="
            + this.smallArtifactClassEnum
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", mesProductEnum="
            + this.mesProductEnum
            + ")";
      }
   }
}
