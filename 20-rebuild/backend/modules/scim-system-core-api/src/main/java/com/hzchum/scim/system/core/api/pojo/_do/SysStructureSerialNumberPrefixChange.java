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

@ApiModel(value = "SysStructureSerialNumberPrefixChange对象", description = "构件编号前缀变更表")
@Entity
@TableName("sys_structure_serial_number_prefix_change")
@Table(name = "sys_structure_serial_number_prefix_change")
public class SysStructureSerialNumberPrefixChange extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "serialNumberPrefix", value = "编号前缀", notes = "编号前缀")
   @JsonProperty("serialNumberPrefix")
   @JSONField(name = "serialNumberPrefix")
   @TableField("serial_number_prefix")
   @Column(name = "serial_number_prefix", columnDefinition = "varchar(64)  COMMENT '编号前缀'", nullable = false)
   private String serialNumberPrefix;
   @ApiModelProperty(name = "structureSerialNumberPrefixId", value = "构件编号前缀表id", notes = "构件编号前缀表id")
   @JsonProperty("structureSerialNumberPrefixId")
   @JSONField(name = "structureSerialNumberPrefixId")
   @TableField("structure_serial_number_prefix_id")
   @Column(name = "structure_serial_number_prefix_id", columnDefinition = "bigint(20)  COMMENT '构件编号前缀表id'", nullable = true)
   private Long structureSerialNumberPrefixId;
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

   public static SysStructureSerialNumberPrefixChange.SysStructureSerialNumberPrefixChangeBuilder builder() {
      return new SysStructureSerialNumberPrefixChange.SysStructureSerialNumberPrefixChangeBuilder();
   }

   public SysStructureSerialNumberPrefixChange() {
   }

   public SysStructureSerialNumberPrefixChange(
      final Long id,
      final Long structureClassificationId,
      final Long structureClassificationChangeId,
      final String serialNumberPrefix,
      final Long structureSerialNumberPrefixId,
      final Integer changeType,
      final Integer mesProductEnum
   ) {
      this.id = id;
      this.structureClassificationId = structureClassificationId;
      this.structureClassificationChangeId = structureClassificationChangeId;
      this.serialNumberPrefix = serialNumberPrefix;
      this.structureSerialNumberPrefixId = structureSerialNumberPrefixId;
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

   public String getSerialNumberPrefix() {
      return this.serialNumberPrefix;
   }

   public Long getStructureSerialNumberPrefixId() {
      return this.structureSerialNumberPrefixId;
   }

   public Integer getChangeType() {
      return this.changeType;
   }

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
   }

   @JsonProperty("id")
   public SysStructureSerialNumberPrefixChange setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("structureClassificationId")
   public SysStructureSerialNumberPrefixChange setStructureClassificationId(final Long structureClassificationId) {
      this.structureClassificationId = structureClassificationId;
      return this;
   }

   @JsonProperty("structureClassificationChangeId")
   public SysStructureSerialNumberPrefixChange setStructureClassificationChangeId(final Long structureClassificationChangeId) {
      this.structureClassificationChangeId = structureClassificationChangeId;
      return this;
   }

   @JsonProperty("serialNumberPrefix")
   public SysStructureSerialNumberPrefixChange setSerialNumberPrefix(final String serialNumberPrefix) {
      this.serialNumberPrefix = serialNumberPrefix;
      return this;
   }

   @JsonProperty("structureSerialNumberPrefixId")
   public SysStructureSerialNumberPrefixChange setStructureSerialNumberPrefixId(final Long structureSerialNumberPrefixId) {
      this.structureSerialNumberPrefixId = structureSerialNumberPrefixId;
      return this;
   }

   @JsonProperty("changeType")
   public SysStructureSerialNumberPrefixChange setChangeType(final Integer changeType) {
      this.changeType = changeType;
      return this;
   }

   public SysStructureSerialNumberPrefixChange setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
      return this;
   }

   @Override
   public String toString() {
      return "SysStructureSerialNumberPrefixChange(id="
         + this.getId()
         + ", structureClassificationId="
         + this.getStructureClassificationId()
         + ", structureClassificationChangeId="
         + this.getStructureClassificationChangeId()
         + ", serialNumberPrefix="
         + this.getSerialNumberPrefix()
         + ", structureSerialNumberPrefixId="
         + this.getStructureSerialNumberPrefixId()
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

      if (!(o instanceof SysStructureSerialNumberPrefixChange)) {
         return false;
      }

      SysStructureSerialNumberPrefixChange other = (SysStructureSerialNumberPrefixChange)o;
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
               Object this$structureSerialNumberPrefixId = this.getStructureSerialNumberPrefixId();
               Object other$structureSerialNumberPrefixId = other.getStructureSerialNumberPrefixId();
               if (this$structureSerialNumberPrefixId == null
                  ? other$structureSerialNumberPrefixId == null
                  : this$structureSerialNumberPrefixId.equals(other$structureSerialNumberPrefixId)) {
                  Object this$changeType = this.getChangeType();
                  Object other$changeType = other.getChangeType();
                  if (this$changeType == null ? other$changeType == null : this$changeType.equals(other$changeType)) {
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
      return other instanceof SysStructureSerialNumberPrefixChange;
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
      Object $structureSerialNumberPrefixId = this.getStructureSerialNumberPrefixId();
      result = result * 59 + ($structureSerialNumberPrefixId == null ? 43 : $structureSerialNumberPrefixId.hashCode());
      Object $changeType = this.getChangeType();
      result = result * 59 + ($changeType == null ? 43 : $changeType.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $serialNumberPrefix = this.getSerialNumberPrefix();
      return result * 59 + ($serialNumberPrefix == null ? 43 : $serialNumberPrefix.hashCode());
   }

   public static class SysStructureSerialNumberPrefixChangeBuilder {
      private Long id;
      private Long structureClassificationId;
      private Long structureClassificationChangeId;
      private String serialNumberPrefix;
      private Long structureSerialNumberPrefixId;
      private Integer changeType;
      private Integer mesProductEnum;

      SysStructureSerialNumberPrefixChangeBuilder() {
      }

      @JsonProperty("id")
      public SysStructureSerialNumberPrefixChange.SysStructureSerialNumberPrefixChangeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("structureClassificationId")
      public SysStructureSerialNumberPrefixChange.SysStructureSerialNumberPrefixChangeBuilder structureClassificationId(final Long structureClassificationId) {
         this.structureClassificationId = structureClassificationId;
         return this;
      }

      @JsonProperty("structureClassificationChangeId")
      public SysStructureSerialNumberPrefixChange.SysStructureSerialNumberPrefixChangeBuilder structureClassificationChangeId(
         final Long structureClassificationChangeId
      ) {
         this.structureClassificationChangeId = structureClassificationChangeId;
         return this;
      }

      @JsonProperty("serialNumberPrefix")
      public SysStructureSerialNumberPrefixChange.SysStructureSerialNumberPrefixChangeBuilder serialNumberPrefix(final String serialNumberPrefix) {
         this.serialNumberPrefix = serialNumberPrefix;
         return this;
      }

      @JsonProperty("structureSerialNumberPrefixId")
      public SysStructureSerialNumberPrefixChange.SysStructureSerialNumberPrefixChangeBuilder structureSerialNumberPrefixId(
         final Long structureSerialNumberPrefixId
      ) {
         this.structureSerialNumberPrefixId = structureSerialNumberPrefixId;
         return this;
      }

      @JsonProperty("changeType")
      public SysStructureSerialNumberPrefixChange.SysStructureSerialNumberPrefixChangeBuilder changeType(final Integer changeType) {
         this.changeType = changeType;
         return this;
      }

      public SysStructureSerialNumberPrefixChange.SysStructureSerialNumberPrefixChangeBuilder mesProductEnum(final Integer mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      public SysStructureSerialNumberPrefixChange build() {
         return new SysStructureSerialNumberPrefixChange(
            this.id,
            this.structureClassificationId,
            this.structureClassificationChangeId,
            this.serialNumberPrefix,
            this.structureSerialNumberPrefixId,
            this.changeType,
            this.mesProductEnum
         );
      }

      @Override
      public String toString() {
         return "SysStructureSerialNumberPrefixChange.SysStructureSerialNumberPrefixChangeBuilder(id="
            + this.id
            + ", structureClassificationId="
            + this.structureClassificationId
            + ", structureClassificationChangeId="
            + this.structureClassificationChangeId
            + ", serialNumberPrefix="
            + this.serialNumberPrefix
            + ", structureSerialNumberPrefixId="
            + this.structureSerialNumberPrefixId
            + ", changeType="
            + this.changeType
            + ", mesProductEnum="
            + this.mesProductEnum
            + ")";
      }
   }
}
