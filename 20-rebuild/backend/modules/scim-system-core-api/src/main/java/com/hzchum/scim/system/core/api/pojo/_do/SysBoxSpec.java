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

@ApiModel(value = "SysBoxSpec对象", description = "")
@Entity
@TableName("sys_box_spec")
@Table(name = "sys_box_spec")
@org.hibernate.annotations.Table(appliesTo = "sys_box_spec")
public class SysBoxSpec extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "specPrefix")
   @JsonProperty("specPrefix")
   @JSONField(name = "specPrefix")
   @TableField("spec_prefix")
   @Column(name = "spec_prefix", columnDefinition = "varchar(64)  COMMENT ''", nullable = false)
   private String specPrefix;
   @ApiModelProperty(name = "structureClassificationId")
   @JsonProperty("structureClassificationId")
   @JSONField(name = "structureClassificationId")
   @TableField("structure_classification_id")
   @Column(name = "structure_classification_id", columnDefinition = "bigint(20)  COMMENT ''", nullable = false)
   private Long structureClassificationId;
   @ApiModelProperty(name = "productionLineTypeEnum", value = "生产线类型 1传统线 2智能线", notes = "生产线类型 1传统线 2智能线")
   @JsonProperty("productionLineTypeEnum")
   @JSONField(name = "productionLineTypeEnum")
   @TableField("production_line_type_enum")
   @Column(name = "production_line_type_enum", columnDefinition = "int(11) default '1' COMMENT '生产线类型 1传统线 2智能线'", nullable = true)
   private Integer productionLineTypeEnum;

   public static SysBoxSpec.SysBoxSpecBuilder builder() {
      return new SysBoxSpec.SysBoxSpecBuilder();
   }

   public SysBoxSpec() {
   }

   public SysBoxSpec(final Long id, final String specPrefix, final Long structureClassificationId, final Integer productionLineTypeEnum) {
      this.id = id;
      this.specPrefix = specPrefix;
      this.structureClassificationId = structureClassificationId;
      this.productionLineTypeEnum = productionLineTypeEnum;
   }

   public Long getId() {
      return this.id;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public Long getStructureClassificationId() {
      return this.structureClassificationId;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   @JsonProperty("id")
   public SysBoxSpec setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("specPrefix")
   public SysBoxSpec setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
      return this;
   }

   @JsonProperty("structureClassificationId")
   public SysBoxSpec setStructureClassificationId(final Long structureClassificationId) {
      this.structureClassificationId = structureClassificationId;
      return this;
   }

   @JsonProperty("productionLineTypeEnum")
   public SysBoxSpec setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
      return this;
   }

   @Override
   public String toString() {
      return "SysBoxSpec(id="
         + this.getId()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", structureClassificationId="
         + this.getStructureClassificationId()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysBoxSpec)) {
         return false;
      }

      SysBoxSpec other = (SysBoxSpec)o;
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
            Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
            Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
            if (this$productionLineTypeEnum == null ? other$productionLineTypeEnum == null : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysBoxSpec;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $structureClassificationId = this.getStructureClassificationId();
      result = result * 59 + ($structureClassificationId == null ? 43 : $structureClassificationId.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      return result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
   }

   public static class SysBoxSpecBuilder {
      private Long id;
      private String specPrefix;
      private Long structureClassificationId;
      private Integer productionLineTypeEnum;

      SysBoxSpecBuilder() {
      }

      @JsonProperty("id")
      public SysBoxSpec.SysBoxSpecBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("specPrefix")
      public SysBoxSpec.SysBoxSpecBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      @JsonProperty("structureClassificationId")
      public SysBoxSpec.SysBoxSpecBuilder structureClassificationId(final Long structureClassificationId) {
         this.structureClassificationId = structureClassificationId;
         return this;
      }

      @JsonProperty("productionLineTypeEnum")
      public SysBoxSpec.SysBoxSpecBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      public SysBoxSpec build() {
         return new SysBoxSpec(this.id, this.specPrefix, this.structureClassificationId, this.productionLineTypeEnum);
      }

      @Override
      public String toString() {
         return "SysBoxSpec.SysBoxSpecBuilder(id="
            + this.id
            + ", specPrefix="
            + this.specPrefix
            + ", structureClassificationId="
            + this.structureClassificationId
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ")";
      }
   }
}
