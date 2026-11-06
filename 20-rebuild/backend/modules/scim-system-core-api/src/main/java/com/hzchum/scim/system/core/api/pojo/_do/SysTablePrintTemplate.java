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

@ApiModel(value = "SysTablePrintTemplate对象", description = "打印模板配置表")
@Entity
@TableName("sys_table_print_template")
@Table(name = "sys_table_print_template")
public class SysTablePrintTemplate extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "config", value = "配置Json")
   @JsonProperty("config")
   @JSONField(name = "config")
   @TableField("config")
   @Column(name = "config", columnDefinition = "text comment '配置Json' ", nullable = false)
   private String config;
   @ApiModelProperty(name = "enabled", value = "是否启用 true是 false否")
   @JsonProperty("enabled")
   @JSONField(name = "enabled")
   @TableField("enabled")
   @Column(name = "enabled", columnDefinition = "tinyint(1) default 1 comment '是否启用 1是 0否'", nullable = false)
   private Boolean enabled;
   @ApiModelProperty(name = "isDefault", value = "是否默认 true是 false否")
   @JsonProperty("isDefault")
   @JSONField(name = "isDefault")
   @TableField("is_default")
   @Column(name = "is_default", columnDefinition = "tinyint(1) default 0 comment '是否默认 1是 0否'", nullable = false)
   private Boolean isDefault;
   @ApiModelProperty(name = "name", value = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255) comment '名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "remark", value = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(1024) comment '备注'")
   private String remark;
   @ApiModelProperty(name = "type", value = "类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type", columnDefinition = "varchar(255) comment '类型'", nullable = false)
   private String type;

   public static SysTablePrintTemplate.SysTablePrintTemplateBuilder builder() {
      return new SysTablePrintTemplate.SysTablePrintTemplateBuilder();
   }

   public SysTablePrintTemplate() {
   }

   public SysTablePrintTemplate(
      final Long id, final String config, final Boolean enabled, final Boolean isDefault, final String name, final String remark, final String type
   ) {
      this.id = id;
      this.config = config;
      this.enabled = enabled;
      this.isDefault = isDefault;
      this.name = name;
      this.remark = remark;
      this.type = type;
   }

   public Long getId() {
      return this.id;
   }

   public String getConfig() {
      return this.config;
   }

   public Boolean getEnabled() {
      return this.enabled;
   }

   public Boolean getIsDefault() {
      return this.isDefault;
   }

   public String getName() {
      return this.name;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getType() {
      return this.type;
   }

   @JsonProperty("id")
   public SysTablePrintTemplate setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("config")
   public SysTablePrintTemplate setConfig(final String config) {
      this.config = config;
      return this;
   }

   @JsonProperty("enabled")
   public SysTablePrintTemplate setEnabled(final Boolean enabled) {
      this.enabled = enabled;
      return this;
   }

   @JsonProperty("isDefault")
   public SysTablePrintTemplate setIsDefault(final Boolean isDefault) {
      this.isDefault = isDefault;
      return this;
   }

   @JsonProperty("name")
   public SysTablePrintTemplate setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("remark")
   public SysTablePrintTemplate setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("type")
   public SysTablePrintTemplate setType(final String type) {
      this.type = type;
      return this;
   }

   @Override
   public String toString() {
      return "SysTablePrintTemplate(id="
         + this.getId()
         + ", config="
         + this.getConfig()
         + ", enabled="
         + this.getEnabled()
         + ", isDefault="
         + this.getIsDefault()
         + ", name="
         + this.getName()
         + ", remark="
         + this.getRemark()
         + ", type="
         + this.getType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysTablePrintTemplate)) {
         return false;
      }

      SysTablePrintTemplate other = (SysTablePrintTemplate)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$enabled = this.getEnabled();
         Object other$enabled = other.getEnabled();
         if (this$enabled == null ? other$enabled == null : this$enabled.equals(other$enabled)) {
            Object this$isDefault = this.getIsDefault();
            Object other$isDefault = other.getIsDefault();
            if (this$isDefault == null ? other$isDefault == null : this$isDefault.equals(other$isDefault)) {
               Object this$config = this.getConfig();
               Object other$config = other.getConfig();
               if (this$config == null ? other$config == null : this$config.equals(other$config)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$remark = this.getRemark();
                     Object other$remark = other.getRemark();
                     if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                        Object this$type = this.getType();
                        Object other$type = other.getType();
                        return this$type == null ? other$type == null : this$type.equals(other$type);
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
      return other instanceof SysTablePrintTemplate;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $enabled = this.getEnabled();
      result = result * 59 + ($enabled == null ? 43 : $enabled.hashCode());
      Object $isDefault = this.getIsDefault();
      result = result * 59 + ($isDefault == null ? 43 : $isDefault.hashCode());
      Object $config = this.getConfig();
      result = result * 59 + ($config == null ? 43 : $config.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $type = this.getType();
      return result * 59 + ($type == null ? 43 : $type.hashCode());
   }

   public static class SysTablePrintTemplateBuilder {
      private Long id;
      private String config;
      private Boolean enabled;
      private Boolean isDefault;
      private String name;
      private String remark;
      private String type;

      SysTablePrintTemplateBuilder() {
      }

      @JsonProperty("id")
      public SysTablePrintTemplate.SysTablePrintTemplateBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("config")
      public SysTablePrintTemplate.SysTablePrintTemplateBuilder config(final String config) {
         this.config = config;
         return this;
      }

      @JsonProperty("enabled")
      public SysTablePrintTemplate.SysTablePrintTemplateBuilder enabled(final Boolean enabled) {
         this.enabled = enabled;
         return this;
      }

      @JsonProperty("isDefault")
      public SysTablePrintTemplate.SysTablePrintTemplateBuilder isDefault(final Boolean isDefault) {
         this.isDefault = isDefault;
         return this;
      }

      @JsonProperty("name")
      public SysTablePrintTemplate.SysTablePrintTemplateBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("remark")
      public SysTablePrintTemplate.SysTablePrintTemplateBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("type")
      public SysTablePrintTemplate.SysTablePrintTemplateBuilder type(final String type) {
         this.type = type;
         return this;
      }

      public SysTablePrintTemplate build() {
         return new SysTablePrintTemplate(this.id, this.config, this.enabled, this.isDefault, this.name, this.remark, this.type);
      }

      @Override
      public String toString() {
         return "SysTablePrintTemplate.SysTablePrintTemplateBuilder(id="
            + this.id
            + ", config="
            + this.config
            + ", enabled="
            + this.enabled
            + ", isDefault="
            + this.isDefault
            + ", name="
            + this.name
            + ", remark="
            + this.remark
            + ", type="
            + this.type
            + ")";
      }
   }
}
