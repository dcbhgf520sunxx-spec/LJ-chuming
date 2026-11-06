package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.mesFactory.factory.put;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "FactoryUpdateVORequest", description = "修改工厂请求类")
public class FactoryUpdateVORequest {
   @ApiModelProperty(name = "id", notes = "id", value = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "工厂名称", value = "工厂名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "shortName", notes = "工厂简称", value = "工厂简称")
   @JsonProperty("shortName")
   @JSONField(name = "shortName")
   private String shortName;
   @ApiModelProperty(name = "tagColor", notes = "标签颜色", value = "标签颜色")
   @JsonProperty("tagColor")
   @JSONField(name = "tagColor")
   private String tagColor;
   @ApiModelProperty(name = "sort", notes = "排序", value = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   private Integer sort;
   @ApiModelProperty(name = "remark", notes = "备注", value = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   private String remark;
   @ApiModelProperty(name = "targetProduction", value = "目标产量", notes = "目标产量")
   @JsonProperty("targetProduction")
   @JSONField(name = "targetProduction")
   private BigDecimal targetProduction;

   public static FactoryUpdateVORequest.FactoryUpdateVORequestBuilder builder() {
      return new FactoryUpdateVORequest.FactoryUpdateVORequestBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getTagColor() {
      return this.tagColor;
   }

   public Integer getSort() {
      return this.sort;
   }

   public String getRemark() {
      return this.remark;
   }

   public BigDecimal getTargetProduction() {
      return this.targetProduction;
   }

   @JsonProperty("id")
   public FactoryUpdateVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public FactoryUpdateVORequest setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("shortName")
   public FactoryUpdateVORequest setShortName(final String shortName) {
      this.shortName = shortName;
      return this;
   }

   @JsonProperty("tagColor")
   public FactoryUpdateVORequest setTagColor(final String tagColor) {
      this.tagColor = tagColor;
      return this;
   }

   @JsonProperty("sort")
   public FactoryUpdateVORequest setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("remark")
   public FactoryUpdateVORequest setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("targetProduction")
   public FactoryUpdateVORequest setTargetProduction(final BigDecimal targetProduction) {
      this.targetProduction = targetProduction;
      return this;
   }

   @Override
   public String toString() {
      return "FactoryUpdateVORequest(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", tagColor="
         + this.getTagColor()
         + ", sort="
         + this.getSort()
         + ", remark="
         + this.getRemark()
         + ", targetProduction="
         + this.getTargetProduction()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof FactoryUpdateVORequest)) {
         return false;
      }

      FactoryUpdateVORequest other = (FactoryUpdateVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sort = this.getSort();
         Object other$sort = other.getSort();
         if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$shortName = this.getShortName();
               Object other$shortName = other.getShortName();
               if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                  Object this$tagColor = this.getTagColor();
                  Object other$tagColor = other.getTagColor();
                  if (this$tagColor == null ? other$tagColor == null : this$tagColor.equals(other$tagColor)) {
                     Object this$remark = this.getRemark();
                     Object other$remark = other.getRemark();
                     if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                        Object this$targetProduction = this.getTargetProduction();
                        Object other$targetProduction = other.getTargetProduction();
                        return this$targetProduction == null ? other$targetProduction == null : this$targetProduction.equals(other$targetProduction);
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

   protected boolean canEqual(final Object other) {
      return other instanceof FactoryUpdateVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $tagColor = this.getTagColor();
      result = result * 59 + ($tagColor == null ? 43 : $tagColor.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $targetProduction = this.getTargetProduction();
      return result * 59 + ($targetProduction == null ? 43 : $targetProduction.hashCode());
   }

   public FactoryUpdateVORequest(
      final Long id,
      final String name,
      final String shortName,
      final String tagColor,
      final Integer sort,
      final String remark,
      final BigDecimal targetProduction
   ) {
      this.id = id;
      this.name = name;
      this.shortName = shortName;
      this.tagColor = tagColor;
      this.sort = sort;
      this.remark = remark;
      this.targetProduction = targetProduction;
   }

   public FactoryUpdateVORequest() {
   }

   public static class FactoryUpdateVORequestBuilder {
      private Long id;
      private String name;
      private String shortName;
      private String tagColor;
      private Integer sort;
      private String remark;
      private BigDecimal targetProduction;

      FactoryUpdateVORequestBuilder() {
      }

      @JsonProperty("id")
      public FactoryUpdateVORequest.FactoryUpdateVORequestBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public FactoryUpdateVORequest.FactoryUpdateVORequestBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("shortName")
      public FactoryUpdateVORequest.FactoryUpdateVORequestBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      @JsonProperty("tagColor")
      public FactoryUpdateVORequest.FactoryUpdateVORequestBuilder tagColor(final String tagColor) {
         this.tagColor = tagColor;
         return this;
      }

      @JsonProperty("sort")
      public FactoryUpdateVORequest.FactoryUpdateVORequestBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("remark")
      public FactoryUpdateVORequest.FactoryUpdateVORequestBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("targetProduction")
      public FactoryUpdateVORequest.FactoryUpdateVORequestBuilder targetProduction(final BigDecimal targetProduction) {
         this.targetProduction = targetProduction;
         return this;
      }

      public FactoryUpdateVORequest build() {
         return new FactoryUpdateVORequest(this.id, this.name, this.shortName, this.tagColor, this.sort, this.remark, this.targetProduction);
      }

      @Override
      public String toString() {
         return "FactoryUpdateVORequest.FactoryUpdateVORequestBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", shortName="
            + this.shortName
            + ", tagColor="
            + this.tagColor
            + ", sort="
            + this.sort
            + ", remark="
            + this.remark
            + ", targetProduction="
            + this.targetProduction
            + ")";
      }
   }
}
