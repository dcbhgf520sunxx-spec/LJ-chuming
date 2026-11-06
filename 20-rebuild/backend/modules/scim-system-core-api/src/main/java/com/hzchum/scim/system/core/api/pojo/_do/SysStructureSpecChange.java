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

@ApiModel(value = "SysStructureSpecChange对象", description = "构件种类规格变更表")
@Entity
@TableName("sys_structure_spec_change")
@Table(name = "sys_structure_spec_change")
public class SysStructureSpecChange extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键", notes = "主键")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "structureClassificationId", value = "构件种类表id", notes = "构件种类表id")
   @JsonProperty("structureClassificationId")
   @JSONField(name = "structureClassificationId")
   @TableField("structure_classification_id")
   @Column(name = "structure_classification_id", columnDefinition = "bigint(20)  COMMENT '构件种类表id'", nullable = false)
   private Long structureClassificationId;
   @ApiModelProperty(name = "structureClassificationChangeId", value = "构件种类变更表id", notes = "构件种类变更表id")
   @JsonProperty("structureClassificationChangeId")
   @JSONField(name = "structureClassificationChangeId")
   @TableField("structure_classification_change_id")
   @Column(name = "structure_classification_change_id", columnDefinition = "bigint(20)  COMMENT '构件种类变更表id'", nullable = false)
   private Long structureClassificationChangeId;
   @ApiModelProperty(name = "specPrefix", value = "构件规格前缀", notes = "构件规格前缀")
   @JsonProperty("specPrefix")
   @JSONField(name = "specPrefix")
   @TableField("spec_prefix")
   @Column(name = "spec_prefix", columnDefinition = "varchar(128)  COMMENT '构件规格前缀'", nullable = false)
   private String specPrefix;
   @ApiModelProperty(name = "structureSpecId", value = "构件规格配置表id", notes = "构件规格配置表id")
   @JsonProperty("structureSpecId")
   @JSONField(name = "structureSpecId")
   @TableField("structure_spec_id")
   @Column(name = "structure_spec_id", columnDefinition = "bigint(20)  COMMENT '构件规格配置表id'", nullable = true)
   private Long structureSpecId;
   @ApiModelProperty(name = "changeType", value = "变更类型。1 新增 2 删除 4 修改 8 未修改", notes = "变更类型。1 新增 2 删除 4 修改 8 未修改")
   @JsonProperty("changeType")
   @JSONField(name = "changeType")
   @TableField("change_type")
   @Column(name = "change_type", columnDefinition = "int(11)  COMMENT '变更类型。1 新增 2 删除 4 修改 8 未修改'", nullable = false)
   private Integer changeType;
   @ApiModelProperty("mes分类 1建钢 2桥梁")
   @TableField("mes_product_enum")
   @Column(name = "mes_product_enum", columnDefinition = "int(11) default 1 COMMENT 'mes分类 1建钢 2桥梁'", nullable = false)
   private Integer mesProductEnum;

   public static SysStructureSpecChange.SysStructureSpecChangeBuilder builder() {
      return new SysStructureSpecChange.SysStructureSpecChangeBuilder();
   }

   public SysStructureSpecChange() {
   }

   public SysStructureSpecChange(
      final Long id,
      final Long structureClassificationId,
      final Long structureClassificationChangeId,
      final String specPrefix,
      final Long structureSpecId,
      final Integer changeType,
      final Integer mesProductEnum
   ) {
      this.id = id;
      this.structureClassificationId = structureClassificationId;
      this.structureClassificationChangeId = structureClassificationChangeId;
      this.specPrefix = specPrefix;
      this.structureSpecId = structureSpecId;
      this.changeType = changeType;
      this.mesProductEnum = mesProductEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Long getStructureClassificationId() {
      return this.structureClassificationId;
   }

   public Long getStructureClassificationChangeId() {
      return this.structureClassificationChangeId;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public Long getStructureSpecId() {
      return this.structureSpecId;
   }

   public Integer getChangeType() {
      return this.changeType;
   }

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
   }

   @JsonProperty("id")
   public SysStructureSpecChange setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("structureClassificationId")
   public SysStructureSpecChange setStructureClassificationId(final Long structureClassificationId) {
      this.structureClassificationId = structureClassificationId;
      return this;
   }

   @JsonProperty("structureClassificationChangeId")
   public SysStructureSpecChange setStructureClassificationChangeId(final Long structureClassificationChangeId) {
      this.structureClassificationChangeId = structureClassificationChangeId;
      return this;
   }

   @JsonProperty("specPrefix")
   public SysStructureSpecChange setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
      return this;
   }

   @JsonProperty("structureSpecId")
   public SysStructureSpecChange setStructureSpecId(final Long structureSpecId) {
      this.structureSpecId = structureSpecId;
      return this;
   }

   @JsonProperty("changeType")
   public SysStructureSpecChange setChangeType(final Integer changeType) {
      this.changeType = changeType;
      return this;
   }

   public SysStructureSpecChange setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
      return this;
   }

   @Override
   public String toString() {
      return "SysStructureSpecChange(id="
         + this.getId()
         + ", structureClassificationId="
         + this.getStructureClassificationId()
         + ", structureClassificationChangeId="
         + this.getStructureClassificationChangeId()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", structureSpecId="
         + this.getStructureSpecId()
         + ", changeType="
         + this.getChangeType()
         + ", mesProductEnum="
         + this.getMesProductEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysStructureSpecChange)) {
         return false;
      }

      SysStructureSpecChange other = (SysStructureSpecChange)o;
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
            Object this$structureClassificationChangeId = this.getStructureClassificationChangeId();
            Object other$structureClassificationChangeId = other.getStructureClassificationChangeId();
            if (this$structureClassificationChangeId == null
               ? other$structureClassificationChangeId == null
               : this$structureClassificationChangeId.equals(other$structureClassificationChangeId)) {
               Object this$structureSpecId = this.getStructureSpecId();
               Object other$structureSpecId = other.getStructureSpecId();
               if (this$structureSpecId == null ? other$structureSpecId == null : this$structureSpecId.equals(other$structureSpecId)) {
                  Object this$changeType = this.getChangeType();
                  Object other$changeType = other.getChangeType();
                  if (this$changeType == null ? other$changeType == null : this$changeType.equals(other$changeType)) {
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
      return other instanceof SysStructureSpecChange;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $structureClassificationId = this.getStructureClassificationId();
      result = result * 59 + ($structureClassificationId == null ? 43 : $structureClassificationId.hashCode());
      Object $structureClassificationChangeId = this.getStructureClassificationChangeId();
      result = result * 59 + ($structureClassificationChangeId == null ? 43 : $structureClassificationChangeId.hashCode());
      Object $structureSpecId = this.getStructureSpecId();
      result = result * 59 + ($structureSpecId == null ? 43 : $structureSpecId.hashCode());
      Object $changeType = this.getChangeType();
      result = result * 59 + ($changeType == null ? 43 : $changeType.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      return result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
   }

   public static class SysStructureSpecChangeBuilder {
      private Long id;
      private Long structureClassificationId;
      private Long structureClassificationChangeId;
      private String specPrefix;
      private Long structureSpecId;
      private Integer changeType;
      private Integer mesProductEnum;

      SysStructureSpecChangeBuilder() {
      }

      @JsonProperty("id")
      public SysStructureSpecChange.SysStructureSpecChangeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("structureClassificationId")
      public SysStructureSpecChange.SysStructureSpecChangeBuilder structureClassificationId(final Long structureClassificationId) {
         this.structureClassificationId = structureClassificationId;
         return this;
      }

      @JsonProperty("structureClassificationChangeId")
      public SysStructureSpecChange.SysStructureSpecChangeBuilder structureClassificationChangeId(final Long structureClassificationChangeId) {
         this.structureClassificationChangeId = structureClassificationChangeId;
         return this;
      }

      @JsonProperty("specPrefix")
      public SysStructureSpecChange.SysStructureSpecChangeBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      @JsonProperty("structureSpecId")
      public SysStructureSpecChange.SysStructureSpecChangeBuilder structureSpecId(final Long structureSpecId) {
         this.structureSpecId = structureSpecId;
         return this;
      }

      @JsonProperty("changeType")
      public SysStructureSpecChange.SysStructureSpecChangeBuilder changeType(final Integer changeType) {
         this.changeType = changeType;
         return this;
      }

      public SysStructureSpecChange.SysStructureSpecChangeBuilder mesProductEnum(final Integer mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      public SysStructureSpecChange build() {
         return new SysStructureSpecChange(
            this.id,
            this.structureClassificationId,
            this.structureClassificationChangeId,
            this.specPrefix,
            this.structureSpecId,
            this.changeType,
            this.mesProductEnum
         );
      }

      @Override
      public String toString() {
         return "SysStructureSpecChange.SysStructureSpecChangeBuilder(id="
            + this.id
            + ", structureClassificationId="
            + this.structureClassificationId
            + ", structureClassificationChangeId="
            + this.structureClassificationChangeId
            + ", specPrefix="
            + this.specPrefix
            + ", structureSpecId="
            + this.structureSpecId
            + ", changeType="
            + this.changeType
            + ", mesProductEnum="
            + this.mesProductEnum
            + ")";
      }
   }
}
