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

@ApiModel(value = "Specification对象", description = "规格")
@Entity
@TableName("wms_specification")
@Table(name = "wms_specification")
@org.hibernate.annotations.Table(appliesTo = "wms_specification", comment = "规格")
public class Specification extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "boolWeightedAverage", value = "是否加权平均价 0[false],1[true]", notes = "是否加权平均价 0[false],1[true]")
   @JsonProperty("boolWeightedAverage")
   @JSONField(name = "boolWeightedAverage")
   @TableField("bool_weighted_average")
   @Column(name = "bool_weighted_average", columnDefinition = "tinyint(1)  COMMENT '是否加权平均价 0[false],1[true]'", nullable = false)
   private Boolean boolWeightedAverage;
   @ApiModelProperty(name = "classificationId")
   @JsonProperty("classificationId")
   @JSONField(name = "classificationId")
   @TableField("classification_id")
   @Column(name = "classification_id", columnDefinition = "bigint  COMMENT ''", nullable = false)
   private Long classificationId;
   @ApiModelProperty(name = "name", value = "规格名称", notes = "规格名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(64)  COMMENT '规格名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   @TableField("sort")
   @Column(name = "sort", columnDefinition = "int  COMMENT '排序'", nullable = false)
   private Integer sort;

   public static Specification.SpecificationBuilder builder() {
      return new Specification.SpecificationBuilder();
   }

   public Specification() {
   }

   public Specification(final Long id, final Boolean boolWeightedAverage, final Long classificationId, final String name, final Integer sort) {
      this.id = id;
      this.boolWeightedAverage = boolWeightedAverage;
      this.classificationId = classificationId;
      this.name = name;
      this.sort = sort;
   }

   public Long getId() {
      return this.id;
   }

   public Boolean getBoolWeightedAverage() {
      return this.boolWeightedAverage;
   }

   public Long getClassificationId() {
      return this.classificationId;
   }

   public String getName() {
      return this.name;
   }

   public Integer getSort() {
      return this.sort;
   }

   @JsonProperty("id")
   public Specification setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("boolWeightedAverage")
   public Specification setBoolWeightedAverage(final Boolean boolWeightedAverage) {
      this.boolWeightedAverage = boolWeightedAverage;
      return this;
   }

   @JsonProperty("classificationId")
   public Specification setClassificationId(final Long classificationId) {
      this.classificationId = classificationId;
      return this;
   }

   @JsonProperty("name")
   public Specification setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("sort")
   public Specification setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @Override
   public String toString() {
      return "Specification(id="
         + this.getId()
         + ", boolWeightedAverage="
         + this.getBoolWeightedAverage()
         + ", classificationId="
         + this.getClassificationId()
         + ", name="
         + this.getName()
         + ", sort="
         + this.getSort()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof Specification)) {
         return false;
      }

      Specification other = (Specification)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolWeightedAverage = this.getBoolWeightedAverage();
         Object other$boolWeightedAverage = other.getBoolWeightedAverage();
         if (this$boolWeightedAverage == null ? other$boolWeightedAverage == null : this$boolWeightedAverage.equals(other$boolWeightedAverage)) {
            Object this$classificationId = this.getClassificationId();
            Object other$classificationId = other.getClassificationId();
            if (this$classificationId == null ? other$classificationId == null : this$classificationId.equals(other$classificationId)) {
               Object this$sort = this.getSort();
               Object other$sort = other.getSort();
               if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
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
      return other instanceof Specification;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolWeightedAverage = this.getBoolWeightedAverage();
      result = result * 59 + ($boolWeightedAverage == null ? 43 : $boolWeightedAverage.hashCode());
      Object $classificationId = this.getClassificationId();
      result = result * 59 + ($classificationId == null ? 43 : $classificationId.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class SpecificationBuilder {
      private Long id;
      private Boolean boolWeightedAverage;
      private Long classificationId;
      private String name;
      private Integer sort;

      SpecificationBuilder() {
      }

      @JsonProperty("id")
      public Specification.SpecificationBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("boolWeightedAverage")
      public Specification.SpecificationBuilder boolWeightedAverage(final Boolean boolWeightedAverage) {
         this.boolWeightedAverage = boolWeightedAverage;
         return this;
      }

      @JsonProperty("classificationId")
      public Specification.SpecificationBuilder classificationId(final Long classificationId) {
         this.classificationId = classificationId;
         return this;
      }

      @JsonProperty("name")
      public Specification.SpecificationBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("sort")
      public Specification.SpecificationBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public Specification build() {
         return new Specification(this.id, this.boolWeightedAverage, this.classificationId, this.name, this.sort);
      }

      @Override
      public String toString() {
         return "Specification.SpecificationBuilder(id="
            + this.id
            + ", boolWeightedAverage="
            + this.boolWeightedAverage
            + ", classificationId="
            + this.classificationId
            + ", name="
            + this.name
            + ", sort="
            + this.sort
            + ")";
      }
   }
}
