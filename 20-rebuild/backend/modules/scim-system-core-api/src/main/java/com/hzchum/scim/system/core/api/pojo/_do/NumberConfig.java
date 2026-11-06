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

@ApiModel(value = "NumberConfig对象", description = "编号生成配置 ")
@Entity
@TableName("number_config")
@Table(name = "number_config")
public class NumberConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "code", value = "代号")
   @JsonProperty("code")
   @JSONField(name = "code")
   @TableField("code")
   @Column(name = "code")
   private String code;
   @ApiModelProperty(name = "type", value = "类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type")
   private Integer type;
   @ApiModelProperty(name = "number", value = "流水号[保留位数]")
   @JsonProperty("number")
   @JSONField(name = "number")
   @TableField("number")
   @Column(name = "number")
   private Integer number;

   public static NumberConfig.NumberConfigBuilder builder() {
      return new NumberConfig.NumberConfigBuilder();
   }

   public NumberConfig() {
   }

   public NumberConfig(final Long id, final String code, final Integer type, final Integer number) {
      this.id = id;
      this.code = code;
      this.type = type;
      this.number = number;
   }

   public Long getId() {
      return this.id;
   }

   public String getCode() {
      return this.code;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getNumber() {
      return this.number;
   }

   @JsonProperty("id")
   public NumberConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("code")
   public NumberConfig setCode(final String code) {
      this.code = code;
      return this;
   }

   @JsonProperty("type")
   public NumberConfig setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("number")
   public NumberConfig setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   @Override
   public String toString() {
      return "NumberConfig(id=" + this.getId() + ", code=" + this.getCode() + ", type=" + this.getType() + ", number=" + this.getNumber() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NumberConfig)) {
         return false;
      }

      NumberConfig other = (NumberConfig)o;
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
            Object this$number = this.getNumber();
            Object other$number = other.getNumber();
            if (this$number == null ? other$number == null : this$number.equals(other$number)) {
               Object this$code = this.getCode();
               Object other$code = other.getCode();
               return this$code == null ? other$code == null : this$code.equals(other$code);
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
      return other instanceof NumberConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $code = this.getCode();
      return result * 59 + ($code == null ? 43 : $code.hashCode());
   }

   public static class NumberConfigBuilder {
      private Long id;
      private String code;
      private Integer type;
      private Integer number;

      NumberConfigBuilder() {
      }

      @JsonProperty("id")
      public NumberConfig.NumberConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("code")
      public NumberConfig.NumberConfigBuilder code(final String code) {
         this.code = code;
         return this;
      }

      @JsonProperty("type")
      public NumberConfig.NumberConfigBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("number")
      public NumberConfig.NumberConfigBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public NumberConfig build() {
         return new NumberConfig(this.id, this.code, this.type, this.number);
      }

      @Override
      public String toString() {
         return "NumberConfig.NumberConfigBuilder(id=" + this.id + ", code=" + this.code + ", type=" + this.type + ", number=" + this.number + ")";
      }
   }
}
