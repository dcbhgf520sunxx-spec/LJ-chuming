package com.hzchum.scim.wms.core.api.pojo._do.wmsConfig;

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

@Entity
@ApiModel(value = "Unit对象", description = "单位配置 ")
@TableName("wms_unit")
@Table(name = "wms_unit")
public class Unit extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", value = "单位名称", notes = "单位名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(128)  COMMENT '单位名称'", nullable = true)
   private String name;
   @ApiModelProperty(name = "symbol", value = "单位符号", notes = "单位符号")
   @JsonProperty("symbol")
   @JSONField(name = "symbol")
   @TableField("symbol")
   @Column(name = "symbol", columnDefinition = "varchar(128)  COMMENT '单位符号'", nullable = true)
   private String symbol;
   @ApiModelProperty(name = "type", value = "单位类型", notes = "单位类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int  COMMENT '单位类型'", nullable = true)
   private Integer type;
   @ApiModelProperty(name = "enabled", value = "使用状态[0 没有被使用,]", notes = "使用状态[0 没有被使用,]")
   @JsonProperty("enabled")
   @JSONField(name = "enabled")
   @TableField("enabled")
   @Column(name = "enabled", columnDefinition = "tinyint(1) default '1' COMMENT '使用状态[0 没有被使用,]'", nullable = false)
   private Boolean enabled;
   @ApiModelProperty(name = "boolSystem", value = "是否为系统配置,系统配置不可删除", notes = "是否为系统配置,系统配置不可删除")
   @JsonProperty("boolSystem")
   @JSONField(name = "boolSystem")
   @TableField("bool_system")
   @Column(name = "bool_system", columnDefinition = "tinyint(1)  COMMENT '是否为系统配置,系统配置不可删除'", nullable = false)
   private Boolean boolSystem;

   public static Unit.UnitBuilder builder() {
      return new Unit.UnitBuilder();
   }

   public Unit() {
   }

   public Unit(final Long id, final String name, final String symbol, final Integer type, final Boolean enabled, final Boolean boolSystem) {
      this.id = id;
      this.name = name;
      this.symbol = symbol;
      this.type = type;
      this.enabled = enabled;
      this.boolSystem = boolSystem;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getSymbol() {
      return this.symbol;
   }

   public Integer getType() {
      return this.type;
   }

   public Boolean getEnabled() {
      return this.enabled;
   }

   public Boolean getBoolSystem() {
      return this.boolSystem;
   }

   @JsonProperty("id")
   public Unit setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public Unit setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("symbol")
   public Unit setSymbol(final String symbol) {
      this.symbol = symbol;
      return this;
   }

   @JsonProperty("type")
   public Unit setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("enabled")
   public Unit setEnabled(final Boolean enabled) {
      this.enabled = enabled;
      return this;
   }

   @JsonProperty("boolSystem")
   public Unit setBoolSystem(final Boolean boolSystem) {
      this.boolSystem = boolSystem;
      return this;
   }

   @Override
   public String toString() {
      return "Unit(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", symbol="
         + this.getSymbol()
         + ", type="
         + this.getType()
         + ", enabled="
         + this.getEnabled()
         + ", boolSystem="
         + this.getBoolSystem()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof Unit)) {
         return false;
      }

      Unit other = (Unit)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$enabled = this.getEnabled();
            Object other$enabled = other.getEnabled();
            if (this$enabled == null ? other$enabled == null : this$enabled.equals(other$enabled)) {
               Object this$boolSystem = this.getBoolSystem();
               Object other$boolSystem = other.getBoolSystem();
               if (this$boolSystem == null ? other$boolSystem == null : this$boolSystem.equals(other$boolSystem)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$symbol = this.getSymbol();
                     Object other$symbol = other.getSymbol();
                     return this$symbol == null ? other$symbol == null : this$symbol.equals(other$symbol);
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
      return other instanceof Unit;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $enabled = this.getEnabled();
      result = result * 59 + ($enabled == null ? 43 : $enabled.hashCode());
      Object $boolSystem = this.getBoolSystem();
      result = result * 59 + ($boolSystem == null ? 43 : $boolSystem.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $symbol = this.getSymbol();
      return result * 59 + ($symbol == null ? 43 : $symbol.hashCode());
   }

   public static class UnitBuilder {
      private Long id;
      private String name;
      private String symbol;
      private Integer type;
      private Boolean enabled;
      private Boolean boolSystem;

      UnitBuilder() {
      }

      @JsonProperty("id")
      public Unit.UnitBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public Unit.UnitBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("symbol")
      public Unit.UnitBuilder symbol(final String symbol) {
         this.symbol = symbol;
         return this;
      }

      @JsonProperty("type")
      public Unit.UnitBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("enabled")
      public Unit.UnitBuilder enabled(final Boolean enabled) {
         this.enabled = enabled;
         return this;
      }

      @JsonProperty("boolSystem")
      public Unit.UnitBuilder boolSystem(final Boolean boolSystem) {
         this.boolSystem = boolSystem;
         return this;
      }

      public Unit build() {
         return new Unit(this.id, this.name, this.symbol, this.type, this.enabled, this.boolSystem);
      }

      @Override
      public String toString() {
         return "Unit.UnitBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", symbol="
            + this.symbol
            + ", type="
            + this.type
            + ", enabled="
            + this.enabled
            + ", boolSystem="
            + this.boolSystem
            + ")";
      }
   }
}
