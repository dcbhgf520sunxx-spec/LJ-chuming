package com.hzchum.scim.system.core.api.pojo._do;

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

@ApiModel(value = "SysStructureSerialNumberPrefix", description = "构件编号前缀表")
@Entity
@TableName("sys_structure_serial_number_prefix")
@Table(name = "sys_structure_serial_number_prefix")
@org.hibernate.annotations.Table(appliesTo = "sys_structure_serial_number_prefix", comment = "构件编号前缀表")
public class SysStructureSerialNumberPrefix extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "serialNumberPrefix", value = "编号前缀", notes = "编号前缀")
   @TableField("serial_number_prefix")
   @Column(name = "serial_number_prefix", columnDefinition = "varchar(64)  COMMENT '编号前缀'", nullable = false)
   private String serialNumberPrefix;
   @ApiModelProperty(name = "structureClassificationId", value = "构件科目id", notes = "构件科目id")
   @TableField("structure_classification_id")
   @Column(name = "structure_classification_id", columnDefinition = "bigint(20)  COMMENT '构件科目id'", nullable = false)
   private Long structureClassificationId;
   @ApiModelProperty("构件类型 1主构件 2次构件")
   @TableField("artifact_type")
   @Column(name = "artifact_type", columnDefinition = "int(11) DEFAULT 1 comment '构件类型 1主构件 2次构件'", nullable = false)
   private Integer artifactType;
   @ApiModelProperty("次构件分类(主构件为null): 1其他 2板材类 4型材类 8檩条类 ")
   @TableField("small_artifact_class_enum")
   @Column(name = "small_artifact_class_enum", columnDefinition = "int(11) default 1 comment '次构件分类(主构件为null): 1其他 2板材类 4型材类 8檩条类'")
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

   public static SysStructureSerialNumberPrefix.SysStructureSerialNumberPrefixBuilder builder() {
      return new SysStructureSerialNumberPrefix.SysStructureSerialNumberPrefixBuilder();
   }

   public SysStructureSerialNumberPrefix() {
   }

   public SysStructureSerialNumberPrefix(
      final Long id,
      final String serialNumberPrefix,
      final Long structureClassificationId,
      final Integer artifactType,
      final Integer smallArtifactClassEnum,
      final Integer productionLineTypeEnum,
      final Integer mesProductEnum
   ) {
      this.id = id;
      this.serialNumberPrefix = serialNumberPrefix;
      this.structureClassificationId = structureClassificationId;
      this.artifactType = artifactType;
      this.smallArtifactClassEnum = smallArtifactClassEnum;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.mesProductEnum = mesProductEnum;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumberPrefix() {
      return this.serialNumberPrefix;
   }

   public Long getStructureClassificationId() {
      return this.structureClassificationId;
   }

   public Integer getArtifactType() {
      return this.artifactType;
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

   @JsonProperty("id")
   public SysStructureSerialNumberPrefix setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysStructureSerialNumberPrefix setSerialNumberPrefix(final String serialNumberPrefix) {
      this.serialNumberPrefix = serialNumberPrefix;
      return this;
   }

   public SysStructureSerialNumberPrefix setStructureClassificationId(final Long structureClassificationId) {
      this.structureClassificationId = structureClassificationId;
      return this;
   }

   public SysStructureSerialNumberPrefix setArtifactType(final Integer artifactType) {
      this.artifactType = artifactType;
      return this;
   }

   public SysStructureSerialNumberPrefix setSmallArtifactClassEnum(final Integer smallArtifactClassEnum) {
      this.smallArtifactClassEnum = smallArtifactClassEnum;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public SysStructureSerialNumberPrefix setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   public SysStructureSerialNumberPrefix setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
      return this;
   }

   @Override
   public String toString() {
      return "SysStructureSerialNumberPrefix(id="
         + this.getId()
         + ", serialNumberPrefix="
         + this.getSerialNumberPrefix()
         + ", structureClassificationId="
         + this.getStructureClassificationId()
         + ", artifactType="
         + this.getArtifactType()
         + ", smallArtifactClassEnum="
         + this.getSmallArtifactClassEnum()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", mesProductEnum="
         + this.getMesProductEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysStructureSerialNumberPrefix)) {
         return false;
      }

      SysStructureSerialNumberPrefix other = (SysStructureSerialNumberPrefix)o;
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
                        Object this$serialNumberPrefix = this.getSerialNumberPrefix();
                        Object other$serialNumberPrefix = other.getSerialNumberPrefix();
                        return this$serialNumberPrefix == null ? other$serialNumberPrefix == null : this$serialNumberPrefix.equals(other$serialNumberPrefix);
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
      return other instanceof SysStructureSerialNumberPrefix;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
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
      Object $serialNumberPrefix = this.getSerialNumberPrefix();
      return result * 59 + ($serialNumberPrefix == null ? 43 : $serialNumberPrefix.hashCode());
   }

   public static class SysStructureSerialNumberPrefixBuilder {
      private Long id;
      private String serialNumberPrefix;
      private Long structureClassificationId;
      private Integer artifactType;
      private Integer smallArtifactClassEnum;
      private Integer productionLineTypeEnum;
      private Integer mesProductEnum;

      SysStructureSerialNumberPrefixBuilder() {
      }

      @JsonProperty("id")
      public SysStructureSerialNumberPrefix.SysStructureSerialNumberPrefixBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysStructureSerialNumberPrefix.SysStructureSerialNumberPrefixBuilder serialNumberPrefix(final String serialNumberPrefix) {
         this.serialNumberPrefix = serialNumberPrefix;
         return this;
      }

      public SysStructureSerialNumberPrefix.SysStructureSerialNumberPrefixBuilder structureClassificationId(final Long structureClassificationId) {
         this.structureClassificationId = structureClassificationId;
         return this;
      }

      public SysStructureSerialNumberPrefix.SysStructureSerialNumberPrefixBuilder artifactType(final Integer artifactType) {
         this.artifactType = artifactType;
         return this;
      }

      public SysStructureSerialNumberPrefix.SysStructureSerialNumberPrefixBuilder smallArtifactClassEnum(final Integer smallArtifactClassEnum) {
         this.smallArtifactClassEnum = smallArtifactClassEnum;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public SysStructureSerialNumberPrefix.SysStructureSerialNumberPrefixBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      public SysStructureSerialNumberPrefix.SysStructureSerialNumberPrefixBuilder mesProductEnum(final Integer mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      public SysStructureSerialNumberPrefix build() {
         return new SysStructureSerialNumberPrefix(
            this.id,
            this.serialNumberPrefix,
            this.structureClassificationId,
            this.artifactType,
            this.smallArtifactClassEnum,
            this.productionLineTypeEnum,
            this.mesProductEnum
         );
      }

      @Override
      public String toString() {
         return "SysStructureSerialNumberPrefix.SysStructureSerialNumberPrefixBuilder(id="
            + this.id
            + ", serialNumberPrefix="
            + this.serialNumberPrefix
            + ", structureClassificationId="
            + this.structureClassificationId
            + ", artifactType="
            + this.artifactType
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
