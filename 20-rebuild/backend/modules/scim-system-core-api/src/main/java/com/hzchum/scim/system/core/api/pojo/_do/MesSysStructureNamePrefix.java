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

@ApiModel(value = "MesSysStructureNamePrefix", description = "构件名称表")
@Entity
@TableName("mes_sys_structure_name_prefix")
@Table(name = "mes_sys_structure_name_prefix")
@org.hibernate.annotations.Table(appliesTo = "mes_sys_structure_name_prefix", comment = "构件名称表")
public class MesSysStructureNamePrefix extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(64)  COMMENT '名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "nameId", value = "截面类型库构件名称表Id", notes = "截面类型库构件名称表Id")
   @TableField("name_id")
   @Column(name = "name_id", columnDefinition = "bigint(20)  COMMENT '截面类型库构件名称表Id'", nullable = false)
   private Long nameId;
   @ApiModelProperty(name = "structureClassificationId", value = "构件种类配置id", notes = "构件种类配置id")
   @TableField("structure_classification_id")
   @Column(name = "structure_classification_id", columnDefinition = "bigint(20)  COMMENT '构件种类配置id'", nullable = false)
   private Long structureClassificationId;
   @ApiModelProperty("构件类型 1主构件 2次构件")
   @TableField("artifact_type")
   @Column(name = "artifact_type", columnDefinition = "int(11) DEFAULT 1 comment '构件类型 1主构件 2次构件'", nullable = false)
   private Integer artifactType;
   @ApiModelProperty("次构件分类(主构件为null): 1其他 2板材类 4型材类 8檩条类 ")
   @TableField("small_artifact_class_enum")
   @Column(name = "small_artifact_class_enum", columnDefinition = "int(11) default 1 comment '次构件分类(主构件为null): 1其他 2板材类 4型材类 8檩条类'")
   private Integer smallArtifactClassEnum;

   public static MesSysStructureNamePrefix.MesSysStructureNamePrefixBuilder builder() {
      return new MesSysStructureNamePrefix.MesSysStructureNamePrefixBuilder();
   }

   public MesSysStructureNamePrefix() {
   }

   public MesSysStructureNamePrefix(
      final Long id,
      final String name,
      final Long nameId,
      final Long structureClassificationId,
      final Integer artifactType,
      final Integer smallArtifactClassEnum
   ) {
      this.id = id;
      this.name = name;
      this.nameId = nameId;
      this.structureClassificationId = structureClassificationId;
      this.artifactType = artifactType;
      this.smallArtifactClassEnum = smallArtifactClassEnum;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Long getNameId() {
      return this.nameId;
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

   @JsonProperty("id")
   public MesSysStructureNamePrefix setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesSysStructureNamePrefix setName(final String name) {
      this.name = name;
      return this;
   }

   public MesSysStructureNamePrefix setNameId(final Long nameId) {
      this.nameId = nameId;
      return this;
   }

   public MesSysStructureNamePrefix setStructureClassificationId(final Long structureClassificationId) {
      this.structureClassificationId = structureClassificationId;
      return this;
   }

   public MesSysStructureNamePrefix setArtifactType(final Integer artifactType) {
      this.artifactType = artifactType;
      return this;
   }

   public MesSysStructureNamePrefix setSmallArtifactClassEnum(final Integer smallArtifactClassEnum) {
      this.smallArtifactClassEnum = smallArtifactClassEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MesSysStructureNamePrefix(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", nameId="
         + this.getNameId()
         + ", structureClassificationId="
         + this.getStructureClassificationId()
         + ", artifactType="
         + this.getArtifactType()
         + ", smallArtifactClassEnum="
         + this.getSmallArtifactClassEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesSysStructureNamePrefix)) {
         return false;
      }

      MesSysStructureNamePrefix other = (MesSysStructureNamePrefix)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$nameId = this.getNameId();
         Object other$nameId = other.getNameId();
         if (this$nameId == null ? other$nameId == null : this$nameId.equals(other$nameId)) {
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
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     return this$name == null ? other$name == null : this$name.equals(other$name);
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
      return other instanceof MesSysStructureNamePrefix;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $nameId = this.getNameId();
      result = result * 59 + ($nameId == null ? 43 : $nameId.hashCode());
      Object $structureClassificationId = this.getStructureClassificationId();
      result = result * 59 + ($structureClassificationId == null ? 43 : $structureClassificationId.hashCode());
      Object $artifactType = this.getArtifactType();
      result = result * 59 + ($artifactType == null ? 43 : $artifactType.hashCode());
      Object $smallArtifactClassEnum = this.getSmallArtifactClassEnum();
      result = result * 59 + ($smallArtifactClassEnum == null ? 43 : $smallArtifactClassEnum.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class MesSysStructureNamePrefixBuilder {
      private Long id;
      private String name;
      private Long nameId;
      private Long structureClassificationId;
      private Integer artifactType;
      private Integer smallArtifactClassEnum;

      MesSysStructureNamePrefixBuilder() {
      }

      @JsonProperty("id")
      public MesSysStructureNamePrefix.MesSysStructureNamePrefixBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesSysStructureNamePrefix.MesSysStructureNamePrefixBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesSysStructureNamePrefix.MesSysStructureNamePrefixBuilder nameId(final Long nameId) {
         this.nameId = nameId;
         return this;
      }

      public MesSysStructureNamePrefix.MesSysStructureNamePrefixBuilder structureClassificationId(final Long structureClassificationId) {
         this.structureClassificationId = structureClassificationId;
         return this;
      }

      public MesSysStructureNamePrefix.MesSysStructureNamePrefixBuilder artifactType(final Integer artifactType) {
         this.artifactType = artifactType;
         return this;
      }

      public MesSysStructureNamePrefix.MesSysStructureNamePrefixBuilder smallArtifactClassEnum(final Integer smallArtifactClassEnum) {
         this.smallArtifactClassEnum = smallArtifactClassEnum;
         return this;
      }

      public MesSysStructureNamePrefix build() {
         return new MesSysStructureNamePrefix(this.id, this.name, this.nameId, this.structureClassificationId, this.artifactType, this.smallArtifactClassEnum);
      }

      @Override
      public String toString() {
         return "MesSysStructureNamePrefix.MesSysStructureNamePrefixBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", nameId="
            + this.nameId
            + ", structureClassificationId="
            + this.structureClassificationId
            + ", artifactType="
            + this.artifactType
            + ", smallArtifactClassEnum="
            + this.smallArtifactClassEnum
            + ")";
      }
   }
}
