package com.hzchum.scim.scm.core.api.pojo._doModel.scm;

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

@ApiModel(value = "ScmSupplierConfig对象", description = "")
@Entity
@TableName("scm_supplier_config")
@Table(name = "scm_supplier_config")
@org.hibernate.annotations.Table(appliesTo = "scm_supplier_config")
public class ScmSupplierConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "configTypeEnum", value = "配置类型 ConfigTypeEnum", notes = "配置类型 ConfigTypeEnum")
   @TableField("config_type_enum")
   @Column(name = "config_type_enum", columnDefinition = "int  COMMENT '配置类型 ConfigTypeEnum'", nullable = true)
   private Integer configTypeEnum;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '名称'", nullable = true)
   private String name;
   @ApiModelProperty(name = "value")
   @TableField("value")
   @Column(name = "value", columnDefinition = "text  COMMENT ''", nullable = true)
   private String value;
   @ApiModelProperty(name = "minValue")
   @TableField("min_value")
   @Column(name = "min_value", columnDefinition = "int  COMMENT ''", nullable = true)
   private Integer minValue;
   @ApiModelProperty(name = "maxValue")
   @TableField("max_value")
   @Column(name = "max_value", columnDefinition = "int  COMMENT ''", nullable = true)
   private Integer maxValue;
   @ApiModelProperty(name = "classifyId", value = "分类id", notes = "分类id")
   @TableField("classify_id")
   @Column(name = "classify_id", columnDefinition = "bigint  COMMENT '分类id'", nullable = true)
   private Long classifyId;
   @ApiModelProperty(name = "columnMapJson")
   @TableField("column_map_json")
   @Column(name = "column_map_json", columnDefinition = "text  COMMENT '字段名称中英文映射json'", nullable = true)
   private String columnMapJson;

   public static ScmSupplierConfig.ScmSupplierConfigBuilder builder() {
      return new ScmSupplierConfig.ScmSupplierConfigBuilder();
   }

   public ScmSupplierConfig() {
   }

   public ScmSupplierConfig(
      final Long id,
      final Integer configTypeEnum,
      final String name,
      final String value,
      final Integer minValue,
      final Integer maxValue,
      final Long classifyId,
      final String columnMapJson
   ) {
      this.id = id;
      this.configTypeEnum = configTypeEnum;
      this.name = name;
      this.value = value;
      this.minValue = minValue;
      this.maxValue = maxValue;
      this.classifyId = classifyId;
      this.columnMapJson = columnMapJson;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getConfigTypeEnum() {
      return this.configTypeEnum;
   }

   public String getName() {
      return this.name;
   }

   public String getValue() {
      return this.value;
   }

   public Integer getMinValue() {
      return this.minValue;
   }

   public Integer getMaxValue() {
      return this.maxValue;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getColumnMapJson() {
      return this.columnMapJson;
   }

   public ScmSupplierConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public ScmSupplierConfig setConfigTypeEnum(final Integer configTypeEnum) {
      this.configTypeEnum = configTypeEnum;
      return this;
   }

   public ScmSupplierConfig setName(final String name) {
      this.name = name;
      return this;
   }

   public ScmSupplierConfig setValue(final String value) {
      this.value = value;
      return this;
   }

   public ScmSupplierConfig setMinValue(final Integer minValue) {
      this.minValue = minValue;
      return this;
   }

   public ScmSupplierConfig setMaxValue(final Integer maxValue) {
      this.maxValue = maxValue;
      return this;
   }

   public ScmSupplierConfig setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
      return this;
   }

   public ScmSupplierConfig setColumnMapJson(final String columnMapJson) {
      this.columnMapJson = columnMapJson;
      return this;
   }

   @Override
   public String toString() {
      return "ScmSupplierConfig(id="
         + this.getId()
         + ", configTypeEnum="
         + this.getConfigTypeEnum()
         + ", name="
         + this.getName()
         + ", value="
         + this.getValue()
         + ", minValue="
         + this.getMinValue()
         + ", maxValue="
         + this.getMaxValue()
         + ", classifyId="
         + this.getClassifyId()
         + ", columnMapJson="
         + this.getColumnMapJson()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ScmSupplierConfig)) {
         return false;
      }

      ScmSupplierConfig other = (ScmSupplierConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$configTypeEnum = this.getConfigTypeEnum();
         Object other$configTypeEnum = other.getConfigTypeEnum();
         if (this$configTypeEnum == null ? other$configTypeEnum == null : this$configTypeEnum.equals(other$configTypeEnum)) {
            Object this$minValue = this.getMinValue();
            Object other$minValue = other.getMinValue();
            if (this$minValue == null ? other$minValue == null : this$minValue.equals(other$minValue)) {
               Object this$maxValue = this.getMaxValue();
               Object other$maxValue = other.getMaxValue();
               if (this$maxValue == null ? other$maxValue == null : this$maxValue.equals(other$maxValue)) {
                  Object this$classifyId = this.getClassifyId();
                  Object other$classifyId = other.getClassifyId();
                  if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$value = this.getValue();
                        Object other$value = other.getValue();
                        if (this$value == null ? other$value == null : this$value.equals(other$value)) {
                           Object this$columnMapJson = this.getColumnMapJson();
                           Object other$columnMapJson = other.getColumnMapJson();
                           return this$columnMapJson == null ? other$columnMapJson == null : this$columnMapJson.equals(other$columnMapJson);
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
      return other instanceof ScmSupplierConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $configTypeEnum = this.getConfigTypeEnum();
      result = result * 59 + ($configTypeEnum == null ? 43 : $configTypeEnum.hashCode());
      Object $minValue = this.getMinValue();
      result = result * 59 + ($minValue == null ? 43 : $minValue.hashCode());
      Object $maxValue = this.getMaxValue();
      result = result * 59 + ($maxValue == null ? 43 : $maxValue.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $value = this.getValue();
      result = result * 59 + ($value == null ? 43 : $value.hashCode());
      Object $columnMapJson = this.getColumnMapJson();
      return result * 59 + ($columnMapJson == null ? 43 : $columnMapJson.hashCode());
   }

   public static class ScmSupplierConfigBuilder {
      private Long id;
      private Integer configTypeEnum;
      private String name;
      private String value;
      private Integer minValue;
      private Integer maxValue;
      private Long classifyId;
      private String columnMapJson;

      ScmSupplierConfigBuilder() {
      }

      public ScmSupplierConfig.ScmSupplierConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ScmSupplierConfig.ScmSupplierConfigBuilder configTypeEnum(final Integer configTypeEnum) {
         this.configTypeEnum = configTypeEnum;
         return this;
      }

      public ScmSupplierConfig.ScmSupplierConfigBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ScmSupplierConfig.ScmSupplierConfigBuilder value(final String value) {
         this.value = value;
         return this;
      }

      public ScmSupplierConfig.ScmSupplierConfigBuilder minValue(final Integer minValue) {
         this.minValue = minValue;
         return this;
      }

      public ScmSupplierConfig.ScmSupplierConfigBuilder maxValue(final Integer maxValue) {
         this.maxValue = maxValue;
         return this;
      }

      public ScmSupplierConfig.ScmSupplierConfigBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public ScmSupplierConfig.ScmSupplierConfigBuilder columnMapJson(final String columnMapJson) {
         this.columnMapJson = columnMapJson;
         return this;
      }

      public ScmSupplierConfig build() {
         return new ScmSupplierConfig(this.id, this.configTypeEnum, this.name, this.value, this.minValue, this.maxValue, this.classifyId, this.columnMapJson);
      }

      @Override
      public String toString() {
         return "ScmSupplierConfig.ScmSupplierConfigBuilder(id="
            + this.id
            + ", configTypeEnum="
            + this.configTypeEnum
            + ", name="
            + this.name
            + ", value="
            + this.value
            + ", minValue="
            + this.minValue
            + ", maxValue="
            + this.maxValue
            + ", classifyId="
            + this.classifyId
            + ", columnMapJson="
            + this.columnMapJson
            + ")";
      }
   }
}
