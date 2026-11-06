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

@ApiModel(value = "MesSysStructureNameLink对象", description = "构件种类规格-名称关联表 ")
@Entity
@TableName("mes_sys_structure_name_link")
@Table(name = "mes_sys_structure_name_link")
@org.hibernate.annotations.Table(appliesTo = "mes_sys_structure_name_link", comment = "构件种类规格-名称关联表 ")
public class MesSysStructureNameLink extends BaseEntity<Long> {
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
   @ApiModelProperty("截面类型库规格前缀表Id")
   @TableField("spec_prefix_id")
   @Column(name = "spec_prefix_id", columnDefinition = "bigint(20) comment '截面类型库规格前缀表Id'", nullable = false)
   private Long specPrefixId;
   @ApiModelProperty(name = "name", value = "构件名称", notes = "构件名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '构件名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "nameId", value = "截面类型库构件名称表Id", notes = "截面类型库构件名称表Id")
   @TableField("name_id")
   @Column(name = "name_id", columnDefinition = "bigint(20)  COMMENT '截面类型库构件名称表Id'", nullable = false)
   private Long nameId;
   @ApiModelProperty(name = "structureClassificationId", value = "构件种类ID", notes = "构件种类ID")
   @TableField("structure_classification_id")
   @Column(name = "structure_classification_id", columnDefinition = "bigint(20)  COMMENT '构件种类ID'", nullable = false)
   private Long structureClassificationId;
   @ApiModelProperty("次构件分类(主构件为null): 1其他 2板材类 4型材类 8檩条类 ")
   @TableField("small_artifact_class_enum")
   @Column(name = "small_artifact_class_enum", columnDefinition = "int(11) default 1 comment '次构件分类(主构件为null): 1其他 2板材类 4型材类 8檩条类'", nullable = false)
   private Integer smallArtifactClassEnum;

   public static MesSysStructureNameLink.MesSysStructureNameLinkBuilder builder() {
      return new MesSysStructureNameLink.MesSysStructureNameLinkBuilder();
   }

   public MesSysStructureNameLink() {
   }

   public MesSysStructureNameLink(
      final Long id,
      final String specPrefix,
      final Long specPrefixId,
      final String name,
      final Long nameId,
      final Long structureClassificationId,
      final Integer smallArtifactClassEnum
   ) {
      this.id = id;
      this.specPrefix = specPrefix;
      this.specPrefixId = specPrefixId;
      this.name = name;
      this.nameId = nameId;
      this.structureClassificationId = structureClassificationId;
      this.smallArtifactClassEnum = smallArtifactClassEnum;
   }

   public Long getId() {
      return this.id;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public Long getSpecPrefixId() {
      return this.specPrefixId;
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

   public Integer getSmallArtifactClassEnum() {
      return this.smallArtifactClassEnum;
   }

   public MesSysStructureNameLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesSysStructureNameLink setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
      return this;
   }

   public MesSysStructureNameLink setSpecPrefixId(final Long specPrefixId) {
      this.specPrefixId = specPrefixId;
      return this;
   }

   public MesSysStructureNameLink setName(final String name) {
      this.name = name;
      return this;
   }

   public MesSysStructureNameLink setNameId(final Long nameId) {
      this.nameId = nameId;
      return this;
   }

   public MesSysStructureNameLink setStructureClassificationId(final Long structureClassificationId) {
      this.structureClassificationId = structureClassificationId;
      return this;
   }

   public MesSysStructureNameLink setSmallArtifactClassEnum(final Integer smallArtifactClassEnum) {
      this.smallArtifactClassEnum = smallArtifactClassEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MesSysStructureNameLink(id="
         + this.getId()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", specPrefixId="
         + this.getSpecPrefixId()
         + ", name="
         + this.getName()
         + ", nameId="
         + this.getNameId()
         + ", structureClassificationId="
         + this.getStructureClassificationId()
         + ", smallArtifactClassEnum="
         + this.getSmallArtifactClassEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesSysStructureNameLink)) {
         return false;
      }

      MesSysStructureNameLink other = (MesSysStructureNameLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$specPrefixId = this.getSpecPrefixId();
         Object other$specPrefixId = other.getSpecPrefixId();
         if (this$specPrefixId == null ? other$specPrefixId == null : this$specPrefixId.equals(other$specPrefixId)) {
            Object this$nameId = this.getNameId();
            Object other$nameId = other.getNameId();
            if (this$nameId == null ? other$nameId == null : this$nameId.equals(other$nameId)) {
               Object this$structureClassificationId = this.getStructureClassificationId();
               Object other$structureClassificationId = other.getStructureClassificationId();
               if (this$structureClassificationId == null
                  ? other$structureClassificationId == null
                  : this$structureClassificationId.equals(other$structureClassificationId)) {
                  Object this$smallArtifactClassEnum = this.getSmallArtifactClassEnum();
                  Object other$smallArtifactClassEnum = other.getSmallArtifactClassEnum();
                  if (this$smallArtifactClassEnum == null
                     ? other$smallArtifactClassEnum == null
                     : this$smallArtifactClassEnum.equals(other$smallArtifactClassEnum)) {
                     Object this$specPrefix = this.getSpecPrefix();
                     Object other$specPrefix = other.getSpecPrefix();
                     if (this$specPrefix == null ? other$specPrefix == null : this$specPrefix.equals(other$specPrefix)) {
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesSysStructureNameLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $specPrefixId = this.getSpecPrefixId();
      result = result * 59 + ($specPrefixId == null ? 43 : $specPrefixId.hashCode());
      Object $nameId = this.getNameId();
      result = result * 59 + ($nameId == null ? 43 : $nameId.hashCode());
      Object $structureClassificationId = this.getStructureClassificationId();
      result = result * 59 + ($structureClassificationId == null ? 43 : $structureClassificationId.hashCode());
      Object $smallArtifactClassEnum = this.getSmallArtifactClassEnum();
      result = result * 59 + ($smallArtifactClassEnum == null ? 43 : $smallArtifactClassEnum.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      result = result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class MesSysStructureNameLinkBuilder {
      private Long id;
      private String specPrefix;
      private Long specPrefixId;
      private String name;
      private Long nameId;
      private Long structureClassificationId;
      private Integer smallArtifactClassEnum;

      MesSysStructureNameLinkBuilder() {
      }

      public MesSysStructureNameLink.MesSysStructureNameLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesSysStructureNameLink.MesSysStructureNameLinkBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      public MesSysStructureNameLink.MesSysStructureNameLinkBuilder specPrefixId(final Long specPrefixId) {
         this.specPrefixId = specPrefixId;
         return this;
      }

      public MesSysStructureNameLink.MesSysStructureNameLinkBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesSysStructureNameLink.MesSysStructureNameLinkBuilder nameId(final Long nameId) {
         this.nameId = nameId;
         return this;
      }

      public MesSysStructureNameLink.MesSysStructureNameLinkBuilder structureClassificationId(final Long structureClassificationId) {
         this.structureClassificationId = structureClassificationId;
         return this;
      }

      public MesSysStructureNameLink.MesSysStructureNameLinkBuilder smallArtifactClassEnum(final Integer smallArtifactClassEnum) {
         this.smallArtifactClassEnum = smallArtifactClassEnum;
         return this;
      }

      public MesSysStructureNameLink build() {
         return new MesSysStructureNameLink(
            this.id, this.specPrefix, this.specPrefixId, this.name, this.nameId, this.structureClassificationId, this.smallArtifactClassEnum
         );
      }

      @Override
      public String toString() {
         return "MesSysStructureNameLink.MesSysStructureNameLinkBuilder(id="
            + this.id
            + ", specPrefix="
            + this.specPrefix
            + ", specPrefixId="
            + this.specPrefixId
            + ", name="
            + this.name
            + ", nameId="
            + this.nameId
            + ", structureClassificationId="
            + this.structureClassificationId
            + ", smallArtifactClassEnum="
            + this.smallArtifactClassEnum
            + ")";
      }
   }
}
