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

@ApiModel(description = "组立规格配置表 ")
@Entity
@Table(name = "sys_assemble_spec")
public class SysAssembleSpec extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty("规格前缀")
   @Column(name = "spec_prefix", nullable = false, columnDefinition = "varchar(64) comment '规格前缀'")
   private String specPrefix;
   @ApiModelProperty("规格索引")
   @JsonProperty("specIndex")
   @JSONField(name = "specIndex")
   @TableField("spec_index")
   @Column(name = "spec_index", columnDefinition = "int(2) default 0 COMMENT '规格索引'", nullable = false)
   private Integer specIndex;
   @ApiModelProperty("部件配置表id")
   @Column(name = "assemble_config_id", nullable = false, columnDefinition = "bigint(20) comment '部件配置表id'")
   private Long assembleConfigId;
   @ApiModelProperty(name = "boolSectionSteel", value = "是否成品型材 [0 否, 1 是]", notes = "是否成品型材 [0 否, 1 是]")
   @TableField("bool_section_steel")
   @Column(name = "bool_section_steel", columnDefinition = "tinyint(1) default '0' COMMENT '是否成品型材 [0 否, 1 是]'", nullable = false)
   private Boolean boolSectionSteel;
   @ApiModelProperty("对应的清单类型")
   @JsonProperty("inventoryTypeEnum")
   @JSONField(name = "inventoryTypeEnum")
   @TableField("inventory_type_enum")
   @Column(name = "inventory_type_enum", columnDefinition = "int(2) default 3 COMMENT '对应的清单类型'", nullable = false)
   private Integer inventoryTypeEnum;
   @ApiModelProperty("mes分类 1建钢 2桥梁")
   @TableField("mes_product_enum")
   @Column(name = "mes_product_enum", columnDefinition = "int(11) default 1 COMMENT 'mes分类 1建钢 2桥梁'", nullable = false)
   private Integer mesProductEnum;

   public static SysAssembleSpec.SysAssembleSpecBuilder builder() {
      return new SysAssembleSpec.SysAssembleSpecBuilder();
   }

   public SysAssembleSpec() {
   }

   public SysAssembleSpec(
      final Long id,
      final String specPrefix,
      final Integer specIndex,
      final Long assembleConfigId,
      final Boolean boolSectionSteel,
      final Integer inventoryTypeEnum,
      final Integer mesProductEnum
   ) {
      this.id = id;
      this.specPrefix = specPrefix;
      this.specIndex = specIndex;
      this.assembleConfigId = assembleConfigId;
      this.boolSectionSteel = boolSectionSteel;
      this.inventoryTypeEnum = inventoryTypeEnum;
      this.mesProductEnum = mesProductEnum;
   }

   public Long getId() {
      return this.id;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public Integer getSpecIndex() {
      return this.specIndex;
   }

   public Long getAssembleConfigId() {
      return this.assembleConfigId;
   }

   public Boolean getBoolSectionSteel() {
      return this.boolSectionSteel;
   }

   public Integer getInventoryTypeEnum() {
      return this.inventoryTypeEnum;
   }

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
   }

   @JsonProperty("specIndex")
   public void setSpecIndex(final Integer specIndex) {
      this.specIndex = specIndex;
   }

   public void setAssembleConfigId(final Long assembleConfigId) {
      this.assembleConfigId = assembleConfigId;
   }

   public void setBoolSectionSteel(final Boolean boolSectionSteel) {
      this.boolSectionSteel = boolSectionSteel;
   }

   @JsonProperty("inventoryTypeEnum")
   public void setInventoryTypeEnum(final Integer inventoryTypeEnum) {
      this.inventoryTypeEnum = inventoryTypeEnum;
   }

   public void setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysAssembleSpec)) {
         return false;
      }

      SysAssembleSpec other = (SysAssembleSpec)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$specIndex = this.getSpecIndex();
         Object other$specIndex = other.getSpecIndex();
         if (this$specIndex == null ? other$specIndex == null : this$specIndex.equals(other$specIndex)) {
            Object this$assembleConfigId = this.getAssembleConfigId();
            Object other$assembleConfigId = other.getAssembleConfigId();
            if (this$assembleConfigId == null ? other$assembleConfigId == null : this$assembleConfigId.equals(other$assembleConfigId)) {
               Object this$boolSectionSteel = this.getBoolSectionSteel();
               Object other$boolSectionSteel = other.getBoolSectionSteel();
               if (this$boolSectionSteel == null ? other$boolSectionSteel == null : this$boolSectionSteel.equals(other$boolSectionSteel)) {
                  Object this$inventoryTypeEnum = this.getInventoryTypeEnum();
                  Object other$inventoryTypeEnum = other.getInventoryTypeEnum();
                  if (this$inventoryTypeEnum == null ? other$inventoryTypeEnum == null : this$inventoryTypeEnum.equals(other$inventoryTypeEnum)) {
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
      return other instanceof SysAssembleSpec;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $specIndex = this.getSpecIndex();
      result = result * 59 + ($specIndex == null ? 43 : $specIndex.hashCode());
      Object $assembleConfigId = this.getAssembleConfigId();
      result = result * 59 + ($assembleConfigId == null ? 43 : $assembleConfigId.hashCode());
      Object $boolSectionSteel = this.getBoolSectionSteel();
      result = result * 59 + ($boolSectionSteel == null ? 43 : $boolSectionSteel.hashCode());
      Object $inventoryTypeEnum = this.getInventoryTypeEnum();
      result = result * 59 + ($inventoryTypeEnum == null ? 43 : $inventoryTypeEnum.hashCode());
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      return result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
   }

   @Override
   public String toString() {
      return "SysAssembleSpec(id="
         + this.getId()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", specIndex="
         + this.getSpecIndex()
         + ", assembleConfigId="
         + this.getAssembleConfigId()
         + ", boolSectionSteel="
         + this.getBoolSectionSteel()
         + ", inventoryTypeEnum="
         + this.getInventoryTypeEnum()
         + ", mesProductEnum="
         + this.getMesProductEnum()
         + ")";
   }

   public static class SysAssembleSpecBuilder {
      private Long id;
      private String specPrefix;
      private Integer specIndex;
      private Long assembleConfigId;
      private Boolean boolSectionSteel;
      private Integer inventoryTypeEnum;
      private Integer mesProductEnum;

      SysAssembleSpecBuilder() {
      }

      public SysAssembleSpec.SysAssembleSpecBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysAssembleSpec.SysAssembleSpecBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      @JsonProperty("specIndex")
      public SysAssembleSpec.SysAssembleSpecBuilder specIndex(final Integer specIndex) {
         this.specIndex = specIndex;
         return this;
      }

      public SysAssembleSpec.SysAssembleSpecBuilder assembleConfigId(final Long assembleConfigId) {
         this.assembleConfigId = assembleConfigId;
         return this;
      }

      public SysAssembleSpec.SysAssembleSpecBuilder boolSectionSteel(final Boolean boolSectionSteel) {
         this.boolSectionSteel = boolSectionSteel;
         return this;
      }

      @JsonProperty("inventoryTypeEnum")
      public SysAssembleSpec.SysAssembleSpecBuilder inventoryTypeEnum(final Integer inventoryTypeEnum) {
         this.inventoryTypeEnum = inventoryTypeEnum;
         return this;
      }

      public SysAssembleSpec.SysAssembleSpecBuilder mesProductEnum(final Integer mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      public SysAssembleSpec build() {
         return new SysAssembleSpec(
            this.id, this.specPrefix, this.specIndex, this.assembleConfigId, this.boolSectionSteel, this.inventoryTypeEnum, this.mesProductEnum
         );
      }

      @Override
      public String toString() {
         return "SysAssembleSpec.SysAssembleSpecBuilder(id="
            + this.id
            + ", specPrefix="
            + this.specPrefix
            + ", specIndex="
            + this.specIndex
            + ", assembleConfigId="
            + this.assembleConfigId
            + ", boolSectionSteel="
            + this.boolSectionSteel
            + ", inventoryTypeEnum="
            + this.inventoryTypeEnum
            + ", mesProductEnum="
            + this.mesProductEnum
            + ")";
      }
   }
}
