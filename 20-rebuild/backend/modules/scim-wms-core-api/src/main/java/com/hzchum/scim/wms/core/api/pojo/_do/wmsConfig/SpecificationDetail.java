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

@ApiModel(value = "SpecificationDetails对象", description = "规格详情")
@Entity
@TableName("wms_specification_details")
@Table(name = "wms_specification_details")
@org.hibernate.annotations.Table(appliesTo = "wms_specification_details", comment = "规格详情")
public class SpecificationDetail extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "specificationId", value = "规格ID", notes = "规格ID")
   @JsonProperty("specificationId")
   @JSONField(name = "specificationId")
   @TableField("specification_id")
   @Column(name = "specification_id", columnDefinition = "bigint  COMMENT '规格ID'", nullable = false)
   private Long specificationId;
   @ApiModelProperty(name = "value", value = "规格值", notes = "规格值")
   @JsonProperty("value")
   @JSONField(name = "value")
   @TableField("value")
   @Column(name = "value", columnDefinition = "varchar(64)  COMMENT '规格值'", nullable = false)
   private String value;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   @TableField("sort")
   @Column(name = "sort", columnDefinition = "int  COMMENT '排序'", nullable = false)
   private Integer sort;
   @ApiModelProperty(name = "code", value = "编号", notes = "编号")
   @JsonProperty("code")
   @JSONField(name = "code")
   @TableField("code")
   @Column(name = "code", columnDefinition = "varchar(128)  COMMENT '编号'", nullable = false)
   private String code;
   @ApiModelProperty(name = "boolUsed", value = "是否使用[0 未使用 ,1 已使用]", notes = "是否使用[0 未使用 ,1 已使用]")
   @JsonProperty("boolUsed")
   @JSONField(name = "boolUsed")
   @TableField("bool_used")
   @Column(name = "bool_used", columnDefinition = "tinyint(1)  COMMENT '是否使用[0 未使用 ,1 已使用]'", nullable = false)
   private Boolean boolUsed;

   public static SpecificationDetail.SpecificationDetailBuilder builder() {
      return new SpecificationDetail.SpecificationDetailBuilder();
   }

   public SpecificationDetail() {
   }

   public SpecificationDetail(final Long id, final Long specificationId, final String value, final Integer sort, final String code, final Boolean boolUsed) {
      this.id = id;
      this.specificationId = specificationId;
      this.value = value;
      this.sort = sort;
      this.code = code;
      this.boolUsed = boolUsed;
   }

   public Long getId() {
      return this.id;
   }

   public Long getSpecificationId() {
      return this.specificationId;
   }

   public String getValue() {
      return this.value;
   }

   public Integer getSort() {
      return this.sort;
   }

   public String getCode() {
      return this.code;
   }

   public Boolean getBoolUsed() {
      return this.boolUsed;
   }

   @JsonProperty("id")
   public SpecificationDetail setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("specificationId")
   public SpecificationDetail setSpecificationId(final Long specificationId) {
      this.specificationId = specificationId;
      return this;
   }

   @JsonProperty("value")
   public SpecificationDetail setValue(final String value) {
      this.value = value;
      return this;
   }

   @JsonProperty("sort")
   public SpecificationDetail setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("code")
   public SpecificationDetail setCode(final String code) {
      this.code = code;
      return this;
   }

   @JsonProperty("boolUsed")
   public SpecificationDetail setBoolUsed(final Boolean boolUsed) {
      this.boolUsed = boolUsed;
      return this;
   }

   @Override
   public String toString() {
      return "SpecificationDetail(id="
         + this.getId()
         + ", specificationId="
         + this.getSpecificationId()
         + ", value="
         + this.getValue()
         + ", sort="
         + this.getSort()
         + ", code="
         + this.getCode()
         + ", boolUsed="
         + this.getBoolUsed()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SpecificationDetail)) {
         return false;
      }

      SpecificationDetail other = (SpecificationDetail)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$specificationId = this.getSpecificationId();
         Object other$specificationId = other.getSpecificationId();
         if (this$specificationId == null ? other$specificationId == null : this$specificationId.equals(other$specificationId)) {
            Object this$sort = this.getSort();
            Object other$sort = other.getSort();
            if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
               Object this$boolUsed = this.getBoolUsed();
               Object other$boolUsed = other.getBoolUsed();
               if (this$boolUsed == null ? other$boolUsed == null : this$boolUsed.equals(other$boolUsed)) {
                  Object this$value = this.getValue();
                  Object other$value = other.getValue();
                  if (this$value == null ? other$value == null : this$value.equals(other$value)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SpecificationDetail;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $specificationId = this.getSpecificationId();
      result = result * 59 + ($specificationId == null ? 43 : $specificationId.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $boolUsed = this.getBoolUsed();
      result = result * 59 + ($boolUsed == null ? 43 : $boolUsed.hashCode());
      Object $value = this.getValue();
      result = result * 59 + ($value == null ? 43 : $value.hashCode());
      Object $code = this.getCode();
      return result * 59 + ($code == null ? 43 : $code.hashCode());
   }

   public static class SpecificationDetailBuilder {
      private Long id;
      private Long specificationId;
      private String value;
      private Integer sort;
      private String code;
      private Boolean boolUsed;

      SpecificationDetailBuilder() {
      }

      @JsonProperty("id")
      public SpecificationDetail.SpecificationDetailBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("specificationId")
      public SpecificationDetail.SpecificationDetailBuilder specificationId(final Long specificationId) {
         this.specificationId = specificationId;
         return this;
      }

      @JsonProperty("value")
      public SpecificationDetail.SpecificationDetailBuilder value(final String value) {
         this.value = value;
         return this;
      }

      @JsonProperty("sort")
      public SpecificationDetail.SpecificationDetailBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("code")
      public SpecificationDetail.SpecificationDetailBuilder code(final String code) {
         this.code = code;
         return this;
      }

      @JsonProperty("boolUsed")
      public SpecificationDetail.SpecificationDetailBuilder boolUsed(final Boolean boolUsed) {
         this.boolUsed = boolUsed;
         return this;
      }

      public SpecificationDetail build() {
         return new SpecificationDetail(this.id, this.specificationId, this.value, this.sort, this.code, this.boolUsed);
      }

      @Override
      public String toString() {
         return "SpecificationDetail.SpecificationDetailBuilder(id="
            + this.id
            + ", specificationId="
            + this.specificationId
            + ", value="
            + this.value
            + ", sort="
            + this.sort
            + ", code="
            + this.code
            + ", boolUsed="
            + this.boolUsed
            + ")";
      }
   }
}
