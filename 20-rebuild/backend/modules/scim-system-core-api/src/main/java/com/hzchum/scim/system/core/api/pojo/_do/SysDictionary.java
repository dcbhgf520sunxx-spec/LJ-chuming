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

@Entity
@ApiModel(value = "SysDictionary对象", description = "字典表")
@TableName("sys_dictionary")
@Table(name = "sys_dictionary")
public class SysDictionary extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(value = "id", type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "label", notes = "字典详情名称(在某个字典类型下，详情名称都是唯一的)")
   @JsonProperty("label")
   @JSONField(name = "label")
   @TableField("label")
   @Column(name = "label")
   private String label;
   @ApiModelProperty(name = "value", notes = "字典详情值(在某个字典类型下，详情值都是唯一的)")
   @JsonProperty("value")
   @JSONField(name = "value")
   @TableField("value")
   @Column(name = "value")
   private String value;
   @ApiModelProperty(name = "name", notes = "字典类型")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name")
   private String name;
   @ApiModelProperty(name = "remark", notes = "字典类型描述")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @TableField("remark")
   @Column(name = "remark")
   private String remark;
   @ApiModelProperty(name = "sort", notes = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   @TableField("sort")
   @Column(name = "sort")
   private Integer sort;

   public static SysDictionary.SysDictionaryBuilder builder() {
      return new SysDictionary.SysDictionaryBuilder();
   }

   public SysDictionary() {
   }

   public SysDictionary(final Long id, final String label, final String value, final String name, final String remark, final Integer sort) {
      this.id = id;
      this.label = label;
      this.value = value;
      this.name = name;
      this.remark = remark;
      this.sort = sort;
   }

   public Long getId() {
      return this.id;
   }

   public String getLabel() {
      return this.label;
   }

   public String getValue() {
      return this.value;
   }

   public String getName() {
      return this.name;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getSort() {
      return this.sort;
   }

   @JsonProperty("id")
   public SysDictionary setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("label")
   public SysDictionary setLabel(final String label) {
      this.label = label;
      return this;
   }

   @JsonProperty("value")
   public SysDictionary setValue(final String value) {
      this.value = value;
      return this;
   }

   @JsonProperty("name")
   public SysDictionary setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("remark")
   public SysDictionary setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("sort")
   public SysDictionary setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @Override
   public String toString() {
      return "SysDictionary(id="
         + this.getId()
         + ", label="
         + this.getLabel()
         + ", value="
         + this.getValue()
         + ", name="
         + this.getName()
         + ", remark="
         + this.getRemark()
         + ", sort="
         + this.getSort()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysDictionary)) {
         return false;
      }

      SysDictionary other = (SysDictionary)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sort = this.getSort();
         Object other$sort = other.getSort();
         if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
            Object this$label = this.getLabel();
            Object other$label = other.getLabel();
            if (this$label == null ? other$label == null : this$label.equals(other$label)) {
               Object this$value = this.getValue();
               Object other$value = other.getValue();
               if (this$value == null ? other$value == null : this$value.equals(other$value)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$remark = this.getRemark();
                     Object other$remark = other.getRemark();
                     return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof SysDictionary;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $label = this.getLabel();
      result = result * 59 + ($label == null ? 43 : $label.hashCode());
      Object $value = this.getValue();
      result = result * 59 + ($value == null ? 43 : $value.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class SysDictionaryBuilder {
      private Long id;
      private String label;
      private String value;
      private String name;
      private String remark;
      private Integer sort;

      SysDictionaryBuilder() {
      }

      @JsonProperty("id")
      public SysDictionary.SysDictionaryBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("label")
      public SysDictionary.SysDictionaryBuilder label(final String label) {
         this.label = label;
         return this;
      }

      @JsonProperty("value")
      public SysDictionary.SysDictionaryBuilder value(final String value) {
         this.value = value;
         return this;
      }

      @JsonProperty("name")
      public SysDictionary.SysDictionaryBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("remark")
      public SysDictionary.SysDictionaryBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("sort")
      public SysDictionary.SysDictionaryBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public SysDictionary build() {
         return new SysDictionary(this.id, this.label, this.value, this.name, this.remark, this.sort);
      }

      @Override
      public String toString() {
         return "SysDictionary.SysDictionaryBuilder(id="
            + this.id
            + ", label="
            + this.label
            + ", value="
            + this.value
            + ", name="
            + this.name
            + ", remark="
            + this.remark
            + ", sort="
            + this.sort
            + ")";
      }
   }
}
