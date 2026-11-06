package com.hzchum.scim.bid.core.api.pojo._do;

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

@ApiModel(value = "招标公告模板", description = "")
@TableName("tender_notice")
@Table(name = "tender_notice")
@Entity
public class TenderNotice extends BaseEntity<Long> {
   @ApiModelProperty(name = "id", value = "主键id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", value = "模板类型名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name")
   private String name;
   @ApiModelProperty(name = "value", value = "内容")
   @JsonProperty("value")
   @JSONField(name = "value")
   @TableField("value")
   @Column(name = "value", columnDefinition = "text")
   private String value;
   @ApiModelProperty(name = "type", value = "公告类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type")
   private Integer type;

   public static TenderNotice.TenderNoticeBuilder builder() {
      return new TenderNotice.TenderNoticeBuilder();
   }

   public TenderNotice() {
   }

   public TenderNotice(final Long id, final String name, final String value, final Integer type) {
      this.id = id;
      this.name = name;
      this.value = value;
      this.type = type;
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

   public Integer getType() {
      return this.type;
   }

   @JsonProperty("id")
   public TenderNotice setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public TenderNotice setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("value")
   public TenderNotice setValue(final String value) {
      this.value = value;
      return this;
   }

   @JsonProperty("type")
   public TenderNotice setType(final Integer type) {
      this.type = type;
      return this;
   }

   @Override
   public String toString() {
      return "TenderNotice(id=" + this.getId() + ", name=" + this.getName() + ", value=" + this.getValue() + ", type=" + this.getType() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TenderNotice)) {
         return false;
      }

      TenderNotice other = (TenderNotice)o;
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof TenderNotice;
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
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $value = this.getValue();
      return result * 59 + ($value == null ? 43 : $value.hashCode());
   }

   public static class TenderNoticeBuilder {
      private Long id;
      private String name;
      private String value;
      private Integer type;

      TenderNoticeBuilder() {
      }

      @JsonProperty("id")
      public TenderNotice.TenderNoticeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public TenderNotice.TenderNoticeBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("value")
      public TenderNotice.TenderNoticeBuilder value(final String value) {
         this.value = value;
         return this;
      }

      @JsonProperty("type")
      public TenderNotice.TenderNoticeBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public TenderNotice build() {
         return new TenderNotice(this.id, this.name, this.value, this.type);
      }

      @Override
      public String toString() {
         return "TenderNotice.TenderNoticeBuilder(id=" + this.id + ", name=" + this.name + ", value=" + this.value + ", type=" + this.type + ")";
      }
   }
}
