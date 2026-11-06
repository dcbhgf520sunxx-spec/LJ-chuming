package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.mesFactory.factory.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

@ApiModel(value = "FactorySaveVORequest", description = "新增工厂请求类")
public class FactorySaveVORequest {
   @ApiModelProperty(name = "name", notes = "工厂名称", value = "工厂名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @NotNull(message = "名称不能为空")
   private String name;
   @ApiModelProperty(name = "shortName", notes = "工厂简称", value = "工厂简称")
   @JsonProperty("shortName")
   @JSONField(name = "shortName")
   @NotNull(message = "简称不能为空")
   private String shortName;
   @ApiModelProperty(name = "tagColor", notes = "标签颜色", value = "标签颜色")
   @JsonProperty("tagColor")
   @JSONField(name = "tagColor")
   @NotNull(message = "标签颜色不能为空")
   private String tagColor;
   @ApiModelProperty(name = "boolEnabledEnum", notes = "启用状态 [0 禁用, 1 启用]", value = "启用状态 [0 禁用, 1 启用]")
   @JsonProperty("boolEnabledEnum")
   @JSONField(name = "boolEnabledEnum")
   private Boolean boolEnabledEnum;
   @ApiModelProperty(name = "sort", notes = "排序", value = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   @NotNull(message = "排序不能为空")
   private Integer sort;
   @ApiModelProperty(name = "remark", notes = "备注", value = "备注")
   @JsonProperty("remark")
   @JSONField(name = "remark")
   @NotNull(message = "备注不能为空")
   private String remark;
   @ApiModelProperty(name = "targetProduction", value = "目标产量", notes = "目标产量")
   @JsonProperty("targetProduction")
   @JSONField(name = "targetProduction")
   private BigDecimal targetProduction;

   public static FactorySaveVORequest.FactorySaveVORequestBuilder builder() {
      return new FactorySaveVORequest.FactorySaveVORequestBuilder();
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

   public Boolean getBoolEnabledEnum() {
      return this.boolEnabledEnum;
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

   @JsonProperty("name")
   public FactorySaveVORequest setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("shortName")
   public FactorySaveVORequest setShortName(final String shortName) {
      this.shortName = shortName;
      return this;
   }

   @JsonProperty("tagColor")
   public FactorySaveVORequest setTagColor(final String tagColor) {
      this.tagColor = tagColor;
      return this;
   }

   @JsonProperty("boolEnabledEnum")
   public FactorySaveVORequest setBoolEnabledEnum(final Boolean boolEnabledEnum) {
      this.boolEnabledEnum = boolEnabledEnum;
      return this;
   }

   @JsonProperty("sort")
   public FactorySaveVORequest setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("remark")
   public FactorySaveVORequest setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @JsonProperty("targetProduction")
   public FactorySaveVORequest setTargetProduction(final BigDecimal targetProduction) {
      this.targetProduction = targetProduction;
      return this;
   }

   @Override
   public String toString() {
      return "FactorySaveVORequest(name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", tagColor="
         + this.getTagColor()
         + ", boolEnabledEnum="
         + this.getBoolEnabledEnum()
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

      if (!(o instanceof FactorySaveVORequest)) {
         return false;
      }

      FactorySaveVORequest other = (FactorySaveVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$boolEnabledEnum = this.getBoolEnabledEnum();
      Object other$boolEnabledEnum = other.getBoolEnabledEnum();
      if (this$boolEnabledEnum == null ? other$boolEnabledEnum == null : this$boolEnabledEnum.equals(other$boolEnabledEnum)) {
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
      return other instanceof FactorySaveVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolEnabledEnum = this.getBoolEnabledEnum();
      result = result * 59 + ($boolEnabledEnum == null ? 43 : $boolEnabledEnum.hashCode());
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

   public FactorySaveVORequest(
      final String name,
      final String shortName,
      final String tagColor,
      final Boolean boolEnabledEnum,
      final Integer sort,
      final String remark,
      final BigDecimal targetProduction
   ) {
      this.name = name;
      this.shortName = shortName;
      this.tagColor = tagColor;
      this.boolEnabledEnum = boolEnabledEnum;
      this.sort = sort;
      this.remark = remark;
      this.targetProduction = targetProduction;
   }

   public FactorySaveVORequest() {
   }

   public static class FactorySaveVORequestBuilder {
      private String name;
      private String shortName;
      private String tagColor;
      private Boolean boolEnabledEnum;
      private Integer sort;
      private String remark;
      private BigDecimal targetProduction;

      FactorySaveVORequestBuilder() {
      }

      @JsonProperty("name")
      public FactorySaveVORequest.FactorySaveVORequestBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("shortName")
      public FactorySaveVORequest.FactorySaveVORequestBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      @JsonProperty("tagColor")
      public FactorySaveVORequest.FactorySaveVORequestBuilder tagColor(final String tagColor) {
         this.tagColor = tagColor;
         return this;
      }

      @JsonProperty("boolEnabledEnum")
      public FactorySaveVORequest.FactorySaveVORequestBuilder boolEnabledEnum(final Boolean boolEnabledEnum) {
         this.boolEnabledEnum = boolEnabledEnum;
         return this;
      }

      @JsonProperty("sort")
      public FactorySaveVORequest.FactorySaveVORequestBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("remark")
      public FactorySaveVORequest.FactorySaveVORequestBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      @JsonProperty("targetProduction")
      public FactorySaveVORequest.FactorySaveVORequestBuilder targetProduction(final BigDecimal targetProduction) {
         this.targetProduction = targetProduction;
         return this;
      }

      public FactorySaveVORequest build() {
         return new FactorySaveVORequest(this.name, this.shortName, this.tagColor, this.boolEnabledEnum, this.sort, this.remark, this.targetProduction);
      }

      @Override
      public String toString() {
         return "FactorySaveVORequest.FactorySaveVORequestBuilder(name="
            + this.name
            + ", shortName="
            + this.shortName
            + ", tagColor="
            + this.tagColor
            + ", boolEnabledEnum="
            + this.boolEnabledEnum
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
