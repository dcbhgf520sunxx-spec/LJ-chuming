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

@ApiModel(value = "BasicConfig对象", description = "wms基础配置 ")
@Entity
@TableName("wms_basic_config")
@Table(name = "wms_basic_config")
@org.hibernate.annotations.Table(appliesTo = "wms_basic_config", comment = "wms基础配置 ")
public class BasicConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", value = "配置名称", notes = "配置名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(128)  COMMENT '配置名称'", nullable = true)
   private String name;
   @ApiModelProperty(name = "value", value = "配置值[JSON]", notes = "配置值[JSON]")
   @JsonProperty("value")
   @JSONField(name = "value")
   @TableField("value")
   @Column(name = "value", columnDefinition = "varchar(3000)  COMMENT '配置值[JSON]'", nullable = true)
   private String value;

   public static BasicConfig.BasicConfigBuilder builder() {
      return new BasicConfig.BasicConfigBuilder();
   }

   public BasicConfig() {
   }

   public BasicConfig(final Long id, final String name, final String value) {
      this.id = id;
      this.name = name;
      this.value = value;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getValue() {
      return this.value;
   }

   @JsonProperty("id")
   public BasicConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public BasicConfig setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("value")
   public BasicConfig setValue(final String value) {
      this.value = value;
      return this;
   }

   @Override
   public String toString() {
      return "BasicConfig(id=" + this.getId() + ", name=" + this.getName() + ", value=" + this.getValue() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BasicConfig)) {
         return false;
      }

      BasicConfig other = (BasicConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$value = this.getValue();
            Object other$value = other.getValue();
            return this$value == null ? other$value == null : this$value.equals(other$value);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof BasicConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $value = this.getValue();
      return result * 59 + ($value == null ? 43 : $value.hashCode());
   }

   public static class BasicConfigBuilder {
      private Long id;
      private String name;
      private String value;

      BasicConfigBuilder() {
      }

      @JsonProperty("id")
      public BasicConfig.BasicConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public BasicConfig.BasicConfigBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("value")
      public BasicConfig.BasicConfigBuilder value(final String value) {
         this.value = value;
         return this;
      }

      public BasicConfig build() {
         return new BasicConfig(this.id, this.name, this.value);
      }

      @Override
      public String toString() {
         return "BasicConfig.BasicConfigBuilder(id=" + this.id + ", name=" + this.name + ", value=" + this.value + ")";
      }
   }
}
