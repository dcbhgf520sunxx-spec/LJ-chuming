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

@ApiModel(value = "SysAssembleSpecChange对象", description = "组立规格配置变更表")
@Entity
@TableName("sys_assemble_spec_change")
@Table(name = "sys_assemble_spec_change")
public class SysAssembleSpecChange extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "assembleConfigId", value = "部件配置表id", notes = "部件配置表id")
   @JsonProperty("assembleConfigId")
   @JSONField(name = "assembleConfigId")
   @TableField("assemble_config_id")
   @Column(name = "assemble_config_id", columnDefinition = "bigint(20)  COMMENT '部件配置表id'", nullable = false)
   private Long assembleConfigId;
   @ApiModelProperty(name = "specPrefix", value = "规格前缀", notes = "规格前缀")
   @JsonProperty("specPrefix")
   @JSONField(name = "specPrefix")
   @TableField("spec_prefix")
   @Column(name = "spec_prefix", columnDefinition = "varchar(64)  COMMENT '规格前缀'", nullable = false)
   private String specPrefix;
   @ApiModelProperty(name = "specIndex", value = "规格索引", notes = "规格索引")
   @JsonProperty("specIndex")
   @JSONField(name = "specIndex")
   @TableField("spec_index")
   @Column(name = "spec_index", columnDefinition = "int(2) default '0' COMMENT '规格索引'", nullable = false)
   private Integer specIndex;
   @ApiModelProperty(name = "assembleConfigChangeId", value = "部件配置变更表id", notes = "部件配置变更表id")
   @JsonProperty("assembleConfigChangeId")
   @JSONField(name = "assembleConfigChangeId")
   @TableField("assemble_config_change_id")
   @Column(name = "assemble_config_change_id", columnDefinition = "bigint(20)  COMMENT '部件配置变更表id'", nullable = true)
   private Long assembleConfigChangeId;
   @ApiModelProperty(name = "specId", value = "部件规格前缀表id", notes = "部件规格前缀表id")
   @JsonProperty("specId")
   @JSONField(name = "specId")
   @TableField("spec_id")
   @Column(name = "spec_id", columnDefinition = "bigint(20)  COMMENT '部件规格前缀表id'", nullable = true)
   private Long specId;
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

   public static SysAssembleSpecChange.SysAssembleSpecChangeBuilder builder() {
      return new SysAssembleSpecChange.SysAssembleSpecChangeBuilder();
   }

   public SysAssembleSpecChange() {
   }

   public SysAssembleSpecChange(
      final Long id,
      final Long assembleConfigId,
      final String specPrefix,
      final Integer specIndex,
      final Long assembleConfigChangeId,
      final Long specId,
      final Integer changeType,
      final Integer mesProductEnum
   ) {
      this.id = id;
      this.assembleConfigId = assembleConfigId;
      this.specPrefix = specPrefix;
      this.specIndex = specIndex;
      this.assembleConfigChangeId = assembleConfigChangeId;
      this.specId = specId;
      this.changeType = changeType;
      this.mesProductEnum = mesProductEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Long getAssembleConfigId() {
      return this.assembleConfigId;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public Integer getSpecIndex() {
      return this.specIndex;
   }

   public Long getAssembleConfigChangeId() {
      return this.assembleConfigChangeId;
   }

   public Long getSpecId() {
      return this.specId;
   }

   public Integer getChangeType() {
      return this.changeType;
   }

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
   }

   @JsonProperty("id")
   public SysAssembleSpecChange setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("assembleConfigId")
   public SysAssembleSpecChange setAssembleConfigId(final Long assembleConfigId) {
      this.assembleConfigId = assembleConfigId;
      return this;
   }

   @JsonProperty("specPrefix")
   public SysAssembleSpecChange setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
      return this;
   }

   @JsonProperty("specIndex")
   public SysAssembleSpecChange setSpecIndex(final Integer specIndex) {
      this.specIndex = specIndex;
      return this;
   }

   @JsonProperty("assembleConfigChangeId")
   public SysAssembleSpecChange setAssembleConfigChangeId(final Long assembleConfigChangeId) {
      this.assembleConfigChangeId = assembleConfigChangeId;
      return this;
   }

   @JsonProperty("specId")
   public SysAssembleSpecChange setSpecId(final Long specId) {
      this.specId = specId;
      return this;
   }

   @JsonProperty("changeType")
   public SysAssembleSpecChange setChangeType(final Integer changeType) {
      this.changeType = changeType;
      return this;
   }

   public SysAssembleSpecChange setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
      return this;
   }

   @Override
   public String toString() {
      return "SysAssembleSpecChange(id="
         + this.getId()
         + ", assembleConfigId="
         + this.getAssembleConfigId()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", specIndex="
         + this.getSpecIndex()
         + ", assembleConfigChangeId="
         + this.getAssembleConfigChangeId()
         + ", specId="
         + this.getSpecId()
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

      if (!(o instanceof SysAssembleSpecChange)) {
         return false;
      }

      SysAssembleSpecChange other = (SysAssembleSpecChange)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$assembleConfigId = this.getAssembleConfigId();
         Object other$assembleConfigId = other.getAssembleConfigId();
         if (this$assembleConfigId == null ? other$assembleConfigId == null : this$assembleConfigId.equals(other$assembleConfigId)) {
            Object this$specIndex = this.getSpecIndex();
            Object other$specIndex = other.getSpecIndex();
            if (this$specIndex == null ? other$specIndex == null : this$specIndex.equals(other$specIndex)) {
               Object this$assembleConfigChangeId = this.getAssembleConfigChangeId();
               Object other$assembleConfigChangeId = other.getAssembleConfigChangeId();
               if (this$assembleConfigChangeId == null
                  ? other$assembleConfigChangeId == null
                  : this$assembleConfigChangeId.equals(other$assembleConfigChangeId)) {
                  Object this$specId = this.getSpecId();
                  Object other$specId = other.getSpecId();
                  if (this$specId == null ? other$specId == null : this$specId.equals(other$specId)) {
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysAssembleSpecChange;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $assembleConfigId = this.getAssembleConfigId();
      result = result * 59 + ($assembleConfigId == null ? 43 : $assembleConfigId.hashCode());
      Object $specIndex = this.getSpecIndex();
      result = result * 59 + ($specIndex == null ? 43 : $specIndex.hashCode());
      Object $assembleConfigChangeId = this.getAssembleConfigChangeId();
      result = result * 59 + ($assembleConfigChangeId == null ? 43 : $assembleConfigChangeId.hashCode());
      Object $specId = this.getSpecId();
      result = result * 59 + ($specId == null ? 43 : $specId.hashCode());
      Object $changeType = this.getChangeType();
      result = result * 59 + ($changeType == null ? 43 : $changeType.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      return result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
   }

   public static class SysAssembleSpecChangeBuilder {
      private Long id;
      private Long assembleConfigId;
      private String specPrefix;
      private Integer specIndex;
      private Long assembleConfigChangeId;
      private Long specId;
      private Integer changeType;
      private Integer mesProductEnum;

      SysAssembleSpecChangeBuilder() {
      }

      @JsonProperty("id")
      public SysAssembleSpecChange.SysAssembleSpecChangeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("assembleConfigId")
      public SysAssembleSpecChange.SysAssembleSpecChangeBuilder assembleConfigId(final Long assembleConfigId) {
         this.assembleConfigId = assembleConfigId;
         return this;
      }

      @JsonProperty("specPrefix")
      public SysAssembleSpecChange.SysAssembleSpecChangeBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      @JsonProperty("specIndex")
      public SysAssembleSpecChange.SysAssembleSpecChangeBuilder specIndex(final Integer specIndex) {
         this.specIndex = specIndex;
         return this;
      }

      @JsonProperty("assembleConfigChangeId")
      public SysAssembleSpecChange.SysAssembleSpecChangeBuilder assembleConfigChangeId(final Long assembleConfigChangeId) {
         this.assembleConfigChangeId = assembleConfigChangeId;
         return this;
      }

      @JsonProperty("specId")
      public SysAssembleSpecChange.SysAssembleSpecChangeBuilder specId(final Long specId) {
         this.specId = specId;
         return this;
      }

      @JsonProperty("changeType")
      public SysAssembleSpecChange.SysAssembleSpecChangeBuilder changeType(final Integer changeType) {
         this.changeType = changeType;
         return this;
      }

      public SysAssembleSpecChange.SysAssembleSpecChangeBuilder mesProductEnum(final Integer mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      public SysAssembleSpecChange build() {
         return new SysAssembleSpecChange(
            this.id, this.assembleConfigId, this.specPrefix, this.specIndex, this.assembleConfigChangeId, this.specId, this.changeType, this.mesProductEnum
         );
      }

      @Override
      public String toString() {
         return "SysAssembleSpecChange.SysAssembleSpecChangeBuilder(id="
            + this.id
            + ", assembleConfigId="
            + this.assembleConfigId
            + ", specPrefix="
            + this.specPrefix
            + ", specIndex="
            + this.specIndex
            + ", assembleConfigChangeId="
            + this.assembleConfigChangeId
            + ", specId="
            + this.specId
            + ", changeType="
            + this.changeType
            + ", mesProductEnum="
            + this.mesProductEnum
            + ")";
      }
   }
}
