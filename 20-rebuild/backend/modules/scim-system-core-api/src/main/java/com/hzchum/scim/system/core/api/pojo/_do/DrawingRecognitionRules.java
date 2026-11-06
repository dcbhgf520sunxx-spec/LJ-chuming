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

@ApiModel(value = "Job对象", description = "图纸识别规则")
@Entity
@TableName("sys_drawing_recognition_rules")
@Table(name = "sys_drawing_recognition_rules")
public class DrawingRecognitionRules extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(value = "id", type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", notes = "规则名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '规则名称'")
   private String name;
   @ApiModelProperty(name = "type", notes = "规则类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(1) default '1' COMMENT '规则类型'", nullable = false)
   private Integer type;

   public static DrawingRecognitionRules.DrawingRecognitionRulesBuilder builder() {
      return new DrawingRecognitionRules.DrawingRecognitionRulesBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getType() {
      return this.type;
   }

   @JsonProperty("id")
   public DrawingRecognitionRules setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public DrawingRecognitionRules setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("type")
   public DrawingRecognitionRules setType(final Integer type) {
      this.type = type;
      return this;
   }

   @Override
   public String toString() {
      return "DrawingRecognitionRules(id=" + this.getId() + ", name=" + this.getName() + ", type=" + this.getType() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DrawingRecognitionRules)) {
         return false;
      }

      DrawingRecognitionRules other = (DrawingRecognitionRules)o;
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
            Object this$name = this.getName();
            Object other$name = other.getName();
            return this$name == null ? other$name == null : this$name.equals(other$name);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof DrawingRecognitionRules;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public DrawingRecognitionRules(final Long id, final String name, final Integer type) {
      this.id = id;
      this.name = name;
      this.type = type;
   }

   public DrawingRecognitionRules() {
   }

   public static class DrawingRecognitionRulesBuilder {
      private Long id;
      private String name;
      private Integer type;

      DrawingRecognitionRulesBuilder() {
      }

      @JsonProperty("id")
      public DrawingRecognitionRules.DrawingRecognitionRulesBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public DrawingRecognitionRules.DrawingRecognitionRulesBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("type")
      public DrawingRecognitionRules.DrawingRecognitionRulesBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public DrawingRecognitionRules build() {
         return new DrawingRecognitionRules(this.id, this.name, this.type);
      }

      @Override
      public String toString() {
         return "DrawingRecognitionRules.DrawingRecognitionRulesBuilder(id=" + this.id + ", name=" + this.name + ", type=" + this.type + ")";
      }
   }
}
