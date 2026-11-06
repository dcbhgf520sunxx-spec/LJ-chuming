package com.hzchum.scim.system.core.api.pojo._do;

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

@ApiModel(value = "SysAuxiliaryClassification对象", description = "配套件类型配置表 ")
@Entity
@TableName("sys_auxiliary_classification")
@Table(name = "sys_auxiliary_classification")
@org.hibernate.annotations.Table(appliesTo = "sys_auxiliary_classification", comment = "配套件类型配置表 ")
public class SysAuxiliaryClassification extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(255)  COMMENT '名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   @TableField("sort")
   @Column(name = "sort", columnDefinition = "int(11) default '1' COMMENT '排序'", nullable = false)
   private Integer sort;
   @ApiModelProperty("物料基础分类")
   @TableField("basic_class")
   @Column(name = "basic_class", columnDefinition = "int(11) DEFAULT 0 COMMENT '物料基础分类'", nullable = false)
   private Integer basicClass;
   @ApiModelProperty(name = "type", value = "配套件类型 1栓钉 2套筒 4其他")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(11) DEFAULT 4  COMMENT '配套件类型 1栓钉 2套筒 4其他'", nullable = false)
   private Integer type;

   public static SysAuxiliaryClassification.SysAuxiliaryClassificationBuilder builder() {
      return new SysAuxiliaryClassification.SysAuxiliaryClassificationBuilder();
   }

   public SysAuxiliaryClassification() {
   }

   public SysAuxiliaryClassification(final Long id, final String name, final Integer sort, final Integer basicClass, final Integer type) {
      this.id = id;
      this.name = name;
      this.sort = sort;
      this.basicClass = basicClass;
      this.type = type;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Integer getType() {
      return this.type;
   }

   public SysAuxiliaryClassification setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysAuxiliaryClassification setName(final String name) {
      this.name = name;
      return this;
   }

   public SysAuxiliaryClassification setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   public SysAuxiliaryClassification setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
      return this;
   }

   public SysAuxiliaryClassification setType(final Integer type) {
      this.type = type;
      return this;
   }

   @Override
   public String toString() {
      return "SysAuxiliaryClassification(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", sort="
         + this.getSort()
         + ", basicClass="
         + this.getBasicClass()
         + ", type="
         + this.getType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysAuxiliaryClassification)) {
         return false;
      }

      SysAuxiliaryClassification other = (SysAuxiliaryClassification)o;
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
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysAuxiliaryClassification;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class SysAuxiliaryClassificationBuilder {
      private Long id;
      private String name;
      private Integer sort;
      private Integer basicClass;
      private Integer type;

      SysAuxiliaryClassificationBuilder() {
      }

      public SysAuxiliaryClassification.SysAuxiliaryClassificationBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysAuxiliaryClassification.SysAuxiliaryClassificationBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SysAuxiliaryClassification.SysAuxiliaryClassificationBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public SysAuxiliaryClassification.SysAuxiliaryClassificationBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public SysAuxiliaryClassification.SysAuxiliaryClassificationBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public SysAuxiliaryClassification build() {
         return new SysAuxiliaryClassification(this.id, this.name, this.sort, this.basicClass, this.type);
      }

      @Override
      public String toString() {
         return "SysAuxiliaryClassification.SysAuxiliaryClassificationBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", sort="
            + this.sort
            + ", basicClass="
            + this.basicClass
            + ", type="
            + this.type
            + ")";
      }
   }
}
