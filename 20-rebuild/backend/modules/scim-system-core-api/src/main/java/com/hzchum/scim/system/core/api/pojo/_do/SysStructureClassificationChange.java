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
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "SysStructureClassificationChange对象", description = "构件种类变更表")
@Entity
@TableName("sys_structure_classification_change")
@Table(name = "sys_structure_classification_change")
public class SysStructureClassificationChange extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键", notes = "主键")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "changeUserId", value = "变更用户id", notes = "变更用户id")
   @JsonProperty("changeUserId")
   @JSONField(name = "changeUserId")
   @TableField("change_user_id")
   @Column(name = "change_user_id", columnDefinition = "bigint(20)  COMMENT '变更用户id'", nullable = false)
   private Long changeUserId;
   @ApiModelProperty(name = "auditUserId", value = "审批用户id", notes = "审批用户id")
   @JsonProperty("auditUserId")
   @JSONField(name = "auditUserId")
   @TableField("audit_user_id")
   @Column(name = "audit_user_id", columnDefinition = "bigint(20)  COMMENT '审批用户id'", nullable = true)
   private Long auditUserId;
   @ApiModelProperty(name = "auditStatus", value = "审批状态。1 待审核 2 通过 4 不通过", notes = "审批状态。1 待审核 2 通过 4 不通过")
   @JsonProperty("auditStatus")
   @JSONField(name = "auditStatus")
   @TableField("audit_status")
   @Column(name = "audit_status", columnDefinition = "int(11)  COMMENT '审批状态。1 待审核 2 通过 4 不通过'", nullable = true)
   private Integer auditStatus;
   @ApiModelProperty(name = "auditTime", value = "审批时间", notes = "审批时间")
   @JsonProperty("auditTime")
   @JSONField(name = "auditTime")
   @TableField("audit_time")
   @Column(name = "audit_time", columnDefinition = "datetime  COMMENT '审批时间'", nullable = true)
   private LocalDateTime auditTime;
   @ApiModelProperty(name = "structureClassificationId", value = "构件种类表id", notes = "构件种类表id")
   @JsonProperty("structureClassificationId")
   @JSONField(name = "structureClassificationId")
   @TableField("structure_classification_id")
   @Column(name = "structure_classification_id", columnDefinition = "bigint(20)  COMMENT '构件种类表id'", nullable = false)
   private Long structureClassificationId;
   @ApiModelProperty(name = "classificationName", value = "构件类型名称", notes = "构件类型名称")
   @JsonProperty("classificationName")
   @JSONField(name = "classificationName")
   @TableField("classification_name")
   @Column(name = "classification_name", columnDefinition = "varchar(64)  COMMENT '构件类型名称'", nullable = false)
   private String classificationName;
   @ApiModelProperty(name = "parentType", value = "父类型  1.梁 2.柱 (智能线)", notes = "父类型  1.梁 2.柱 (智能线)")
   @JsonProperty("parentType")
   @JSONField(name = "parentType")
   @TableField("parent_type")
   @Column(name = "parent_type", columnDefinition = "int(11)  COMMENT '父类型  1.梁 2.柱 (智能线)'", nullable = true)
   private Integer parentType;
   @ApiModelProperty(name = "definitionWord", value = "定义代码(智能线)", notes = "定义代码(智能线)")
   @JsonProperty("definitionWord")
   @JSONField(name = "definitionWord")
   @TableField("definition_word")
   @Column(name = "definition_word", columnDefinition = "varchar(32)  COMMENT '定义代码(智能线)'", nullable = true)
   private String definitionWord;
   @ApiModelProperty(name = "codingType", value = "打码方式", notes = "打码方式")
   @JsonProperty("codingType")
   @JSONField(name = "codingType")
   @TableField("coding_type")
   @Column(name = "coding_type", columnDefinition = "int(11) default '1' COMMENT '打码方式'", nullable = false)
   private Integer codingType;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   @TableField("sort")
   @Column(name = "sort", columnDefinition = "int(11) default '1' COMMENT '排序'", nullable = false)
   private Integer sort;
   @ApiModelProperty(name = "smallArtifactClassEnum", value = "次构件分类(主构件为null): 1其他 2板材类 4型材类 8檩条类", notes = "次构件分类(主构件为null): 1其他 2板材类 4型材类 8檩条类")
   @JsonProperty("smallArtifactClassEnum")
   @JSONField(name = "smallArtifactClassEnum")
   @TableField("small_artifact_class_enum")
   @Column(name = "small_artifact_class_enum", columnDefinition = "int(11)  COMMENT '次构件分类(主构件为null): 1其他 2板材类 4型材类 8檩条类'", nullable = true)
   private Integer smallArtifactClassEnum;
   @ApiModelProperty("mes分类 1建钢构件 2桥梁构件")
   @TableField("mes_product_enum")
   @Column(name = "mes_product_enum", columnDefinition = "int(11) default 1 COMMENT 'mes分类 1建钢构件 2桥梁构件'", nullable = false)
   private Integer mesProductEnum;
   @ApiModelProperty("PL构件是否组合部件")
   @TableField("bool_compose_assemble")
   @Column(name = "bool_compose_assemble", columnDefinition = "tinyint(1) default 1  COMMENT 'PL构件是否组合部件'")
   private Boolean boolComposeAssemble;

   public static SysStructureClassificationChange.SysStructureClassificationChangeBuilder builder() {
      return new SysStructureClassificationChange.SysStructureClassificationChangeBuilder();
   }

   public SysStructureClassificationChange() {
   }

   public SysStructureClassificationChange(
      final Long id,
      final Long changeUserId,
      final Long auditUserId,
      final Integer auditStatus,
      final LocalDateTime auditTime,
      final Long structureClassificationId,
      final String classificationName,
      final Integer parentType,
      final String definitionWord,
      final Integer codingType,
      final Integer sort,
      final Integer smallArtifactClassEnum,
      final Integer mesProductEnum,
      final Boolean boolComposeAssemble
   ) {
      this.id = id;
      this.changeUserId = changeUserId;
      this.auditUserId = auditUserId;
      this.auditStatus = auditStatus;
      this.auditTime = auditTime;
      this.structureClassificationId = structureClassificationId;
      this.classificationName = classificationName;
      this.parentType = parentType;
      this.definitionWord = definitionWord;
      this.codingType = codingType;
      this.sort = sort;
      this.smallArtifactClassEnum = smallArtifactClassEnum;
      this.mesProductEnum = mesProductEnum;
      this.boolComposeAssemble = boolComposeAssemble;
   }

   public Long getId() {
      return this.id;
   }

   public Long getChangeUserId() {
      return this.changeUserId;
   }

   public Long getAuditUserId() {
      return this.auditUserId;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public Long getStructureClassificationId() {
      return this.structureClassificationId;
   }

   public String getClassificationName() {
      return this.classificationName;
   }

   public Integer getParentType() {
      return this.parentType;
   }

   public String getDefinitionWord() {
      return this.definitionWord;
   }

   public Integer getCodingType() {
      return this.codingType;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Integer getSmallArtifactClassEnum() {
      return this.smallArtifactClassEnum;
   }

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
   }

   public Boolean getBoolComposeAssemble() {
      return this.boolComposeAssemble;
   }

   @JsonProperty("id")
   public SysStructureClassificationChange setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("changeUserId")
   public SysStructureClassificationChange setChangeUserId(final Long changeUserId) {
      this.changeUserId = changeUserId;
      return this;
   }

   @JsonProperty("auditUserId")
   public SysStructureClassificationChange setAuditUserId(final Long auditUserId) {
      this.auditUserId = auditUserId;
      return this;
   }

   @JsonProperty("auditStatus")
   public SysStructureClassificationChange setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
      return this;
   }

   @JsonProperty("auditTime")
   public SysStructureClassificationChange setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
      return this;
   }

   @JsonProperty("structureClassificationId")
   public SysStructureClassificationChange setStructureClassificationId(final Long structureClassificationId) {
      this.structureClassificationId = structureClassificationId;
      return this;
   }

   @JsonProperty("classificationName")
   public SysStructureClassificationChange setClassificationName(final String classificationName) {
      this.classificationName = classificationName;
      return this;
   }

   @JsonProperty("parentType")
   public SysStructureClassificationChange setParentType(final Integer parentType) {
      this.parentType = parentType;
      return this;
   }

   @JsonProperty("definitionWord")
   public SysStructureClassificationChange setDefinitionWord(final String definitionWord) {
      this.definitionWord = definitionWord;
      return this;
   }

   @JsonProperty("codingType")
   public SysStructureClassificationChange setCodingType(final Integer codingType) {
      this.codingType = codingType;
      return this;
   }

   @JsonProperty("sort")
   public SysStructureClassificationChange setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("smallArtifactClassEnum")
   public SysStructureClassificationChange setSmallArtifactClassEnum(final Integer smallArtifactClassEnum) {
      this.smallArtifactClassEnum = smallArtifactClassEnum;
      return this;
   }

   public SysStructureClassificationChange setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
      return this;
   }

   public SysStructureClassificationChange setBoolComposeAssemble(final Boolean boolComposeAssemble) {
      this.boolComposeAssemble = boolComposeAssemble;
      return this;
   }

   @Override
   public String toString() {
      return "SysStructureClassificationChange(id="
         + this.getId()
         + ", changeUserId="
         + this.getChangeUserId()
         + ", auditUserId="
         + this.getAuditUserId()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", auditTime="
         + this.getAuditTime()
         + ", structureClassificationId="
         + this.getStructureClassificationId()
         + ", classificationName="
         + this.getClassificationName()
         + ", parentType="
         + this.getParentType()
         + ", definitionWord="
         + this.getDefinitionWord()
         + ", codingType="
         + this.getCodingType()
         + ", sort="
         + this.getSort()
         + ", smallArtifactClassEnum="
         + this.getSmallArtifactClassEnum()
         + ", mesProductEnum="
         + this.getMesProductEnum()
         + ", boolComposeAssemble="
         + this.getBoolComposeAssemble()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysStructureClassificationChange)) {
         return false;
      }

      SysStructureClassificationChange other = (SysStructureClassificationChange)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$changeUserId = this.getChangeUserId();
         Object other$changeUserId = other.getChangeUserId();
         if (this$changeUserId == null ? other$changeUserId == null : this$changeUserId.equals(other$changeUserId)) {
            Object this$auditUserId = this.getAuditUserId();
            Object other$auditUserId = other.getAuditUserId();
            if (this$auditUserId == null ? other$auditUserId == null : this$auditUserId.equals(other$auditUserId)) {
               Object this$auditStatus = this.getAuditStatus();
               Object other$auditStatus = other.getAuditStatus();
               if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                  Object this$structureClassificationId = this.getStructureClassificationId();
                  Object other$structureClassificationId = other.getStructureClassificationId();
                  if (this$structureClassificationId == null
                     ? other$structureClassificationId == null
                     : this$structureClassificationId.equals(other$structureClassificationId)) {
                     Object this$parentType = this.getParentType();
                     Object other$parentType = other.getParentType();
                     if (this$parentType == null ? other$parentType == null : this$parentType.equals(other$parentType)) {
                        Object this$codingType = this.getCodingType();
                        Object other$codingType = other.getCodingType();
                        if (this$codingType == null ? other$codingType == null : this$codingType.equals(other$codingType)) {
                           Object this$sort = this.getSort();
                           Object other$sort = other.getSort();
                           if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                              Object this$smallArtifactClassEnum = this.getSmallArtifactClassEnum();
                              Object other$smallArtifactClassEnum = other.getSmallArtifactClassEnum();
                              if (this$smallArtifactClassEnum == null
                                 ? other$smallArtifactClassEnum == null
                                 : this$smallArtifactClassEnum.equals(other$smallArtifactClassEnum)) {
                                 Object this$mesProductEnum = this.getMesProductEnum();
                                 Object other$mesProductEnum = other.getMesProductEnum();
                                 if (this$mesProductEnum == null ? other$mesProductEnum == null : this$mesProductEnum.equals(other$mesProductEnum)) {
                                    Object this$boolComposeAssemble = this.getBoolComposeAssemble();
                                    Object other$boolComposeAssemble = other.getBoolComposeAssemble();
                                    if (this$boolComposeAssemble == null
                                       ? other$boolComposeAssemble == null
                                       : this$boolComposeAssemble.equals(other$boolComposeAssemble)) {
                                       Object this$auditTime = this.getAuditTime();
                                       Object other$auditTime = other.getAuditTime();
                                       if (this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime)) {
                                          Object this$classificationName = this.getClassificationName();
                                          Object other$classificationName = other.getClassificationName();
                                          if (this$classificationName == null
                                             ? other$classificationName == null
                                             : this$classificationName.equals(other$classificationName)) {
                                             Object this$definitionWord = this.getDefinitionWord();
                                             Object other$definitionWord = other.getDefinitionWord();
                                             return this$definitionWord == null
                                                ? other$definitionWord == null
                                                : this$definitionWord.equals(other$definitionWord);
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
      return other instanceof SysStructureClassificationChange;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $changeUserId = this.getChangeUserId();
      result = result * 59 + ($changeUserId == null ? 43 : $changeUserId.hashCode());
      Object $auditUserId = this.getAuditUserId();
      result = result * 59 + ($auditUserId == null ? 43 : $auditUserId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $structureClassificationId = this.getStructureClassificationId();
      result = result * 59 + ($structureClassificationId == null ? 43 : $structureClassificationId.hashCode());
      Object $parentType = this.getParentType();
      result = result * 59 + ($parentType == null ? 43 : $parentType.hashCode());
      Object $codingType = this.getCodingType();
      result = result * 59 + ($codingType == null ? 43 : $codingType.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $smallArtifactClassEnum = this.getSmallArtifactClassEnum();
      result = result * 59 + ($smallArtifactClassEnum == null ? 43 : $smallArtifactClassEnum.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $boolComposeAssemble = this.getBoolComposeAssemble();
      result = result * 59 + ($boolComposeAssemble == null ? 43 : $boolComposeAssemble.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $classificationName = this.getClassificationName();
      result = result * 59 + ($classificationName == null ? 43 : $classificationName.hashCode());
      Object $definitionWord = this.getDefinitionWord();
      return result * 59 + ($definitionWord == null ? 43 : $definitionWord.hashCode());
   }

   public static class SysStructureClassificationChangeBuilder {
      private Long id;
      private Long changeUserId;
      private Long auditUserId;
      private Integer auditStatus;
      private LocalDateTime auditTime;
      private Long structureClassificationId;
      private String classificationName;
      private Integer parentType;
      private String definitionWord;
      private Integer codingType;
      private Integer sort;
      private Integer smallArtifactClassEnum;
      private Integer mesProductEnum;
      private Boolean boolComposeAssemble;

      SysStructureClassificationChangeBuilder() {
      }

      @JsonProperty("id")
      public SysStructureClassificationChange.SysStructureClassificationChangeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("changeUserId")
      public SysStructureClassificationChange.SysStructureClassificationChangeBuilder changeUserId(final Long changeUserId) {
         this.changeUserId = changeUserId;
         return this;
      }

      @JsonProperty("auditUserId")
      public SysStructureClassificationChange.SysStructureClassificationChangeBuilder auditUserId(final Long auditUserId) {
         this.auditUserId = auditUserId;
         return this;
      }

      @JsonProperty("auditStatus")
      public SysStructureClassificationChange.SysStructureClassificationChangeBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      @JsonProperty("auditTime")
      public SysStructureClassificationChange.SysStructureClassificationChangeBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      @JsonProperty("structureClassificationId")
      public SysStructureClassificationChange.SysStructureClassificationChangeBuilder structureClassificationId(final Long structureClassificationId) {
         this.structureClassificationId = structureClassificationId;
         return this;
      }

      @JsonProperty("classificationName")
      public SysStructureClassificationChange.SysStructureClassificationChangeBuilder classificationName(final String classificationName) {
         this.classificationName = classificationName;
         return this;
      }

      @JsonProperty("parentType")
      public SysStructureClassificationChange.SysStructureClassificationChangeBuilder parentType(final Integer parentType) {
         this.parentType = parentType;
         return this;
      }

      @JsonProperty("definitionWord")
      public SysStructureClassificationChange.SysStructureClassificationChangeBuilder definitionWord(final String definitionWord) {
         this.definitionWord = definitionWord;
         return this;
      }

      @JsonProperty("codingType")
      public SysStructureClassificationChange.SysStructureClassificationChangeBuilder codingType(final Integer codingType) {
         this.codingType = codingType;
         return this;
      }

      @JsonProperty("sort")
      public SysStructureClassificationChange.SysStructureClassificationChangeBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("smallArtifactClassEnum")
      public SysStructureClassificationChange.SysStructureClassificationChangeBuilder smallArtifactClassEnum(final Integer smallArtifactClassEnum) {
         this.smallArtifactClassEnum = smallArtifactClassEnum;
         return this;
      }

      public SysStructureClassificationChange.SysStructureClassificationChangeBuilder mesProductEnum(final Integer mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      public SysStructureClassificationChange.SysStructureClassificationChangeBuilder boolComposeAssemble(final Boolean boolComposeAssemble) {
         this.boolComposeAssemble = boolComposeAssemble;
         return this;
      }

      public SysStructureClassificationChange build() {
         return new SysStructureClassificationChange(
            this.id,
            this.changeUserId,
            this.auditUserId,
            this.auditStatus,
            this.auditTime,
            this.structureClassificationId,
            this.classificationName,
            this.parentType,
            this.definitionWord,
            this.codingType,
            this.sort,
            this.smallArtifactClassEnum,
            this.mesProductEnum,
            this.boolComposeAssemble
         );
      }

      @Override
      public String toString() {
         return "SysStructureClassificationChange.SysStructureClassificationChangeBuilder(id="
            + this.id
            + ", changeUserId="
            + this.changeUserId
            + ", auditUserId="
            + this.auditUserId
            + ", auditStatus="
            + this.auditStatus
            + ", auditTime="
            + this.auditTime
            + ", structureClassificationId="
            + this.structureClassificationId
            + ", classificationName="
            + this.classificationName
            + ", parentType="
            + this.parentType
            + ", definitionWord="
            + this.definitionWord
            + ", codingType="
            + this.codingType
            + ", sort="
            + this.sort
            + ", smallArtifactClassEnum="
            + this.smallArtifactClassEnum
            + ", mesProductEnum="
            + this.mesProductEnum
            + ", boolComposeAssemble="
            + this.boolComposeAssemble
            + ")";
      }
   }
}
