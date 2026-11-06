package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "CategoryProduceAnalysisDTO", description = "产量类型分析")
public class CategoryProduceAnalysisDTO {
   @ApiModelProperty(name = "category", notes = "类型枚举值", value = "类型枚举值")
   @JsonProperty("category")
   @JSONField(name = "category")
   private Integer category;
   @ApiModelProperty(name = "name", notes = "类型", value = "类型")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(name = "completeLength", notes = "生产量", value = "生产量")
   @JsonProperty("completeLength")
   @JSONField(name = "completeLength")
   private BigDecimal completeLength;
   @ApiModelProperty(name = "proportion", notes = "占比", value = "占比")
   @JsonProperty("proportion")
   @JSONField(name = "proportion")
   private BigDecimal proportion;

   public static CategoryProduceAnalysisDTO.CategoryProduceAnalysisDTOBuilder builder() {
      return new CategoryProduceAnalysisDTO.CategoryProduceAnalysisDTOBuilder();
   }

   public CategoryProduceAnalysisDTO() {
   }

   public CategoryProduceAnalysisDTO(final Integer category, final String name, final BigDecimal completeLength, final BigDecimal proportion) {
      this.category = category;
      this.name = name;
      this.completeLength = completeLength;
      this.proportion = proportion;
   }

   public Integer getCategory() {
      return this.category;
   }

   public String getName() {
      return this.name;
   }

   public BigDecimal getCompleteLength() {
      return this.completeLength;
   }

   public BigDecimal getProportion() {
      return this.proportion;
   }

   @JsonProperty("category")
   public CategoryProduceAnalysisDTO setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("name")
   public CategoryProduceAnalysisDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("completeLength")
   public CategoryProduceAnalysisDTO setCompleteLength(final BigDecimal completeLength) {
      this.completeLength = completeLength;
      return this;
   }

   @JsonProperty("proportion")
   public CategoryProduceAnalysisDTO setProportion(final BigDecimal proportion) {
      this.proportion = proportion;
      return this;
   }

   @Override
   public String toString() {
      return "CategoryProduceAnalysisDTO(category="
         + this.getCategory()
         + ", name="
         + this.getName()
         + ", completeLength="
         + this.getCompleteLength()
         + ", proportion="
         + this.getProportion()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CategoryProduceAnalysisDTO)) {
         return false;
      }

      CategoryProduceAnalysisDTO other = (CategoryProduceAnalysisDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$category = this.getCategory();
      Object other$category = other.getCategory();
      if (this$category == null ? other$category == null : this$category.equals(other$category)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$completeLength = this.getCompleteLength();
            Object other$completeLength = other.getCompleteLength();
            if (this$completeLength == null ? other$completeLength == null : this$completeLength.equals(other$completeLength)) {
               Object this$proportion = this.getProportion();
               Object other$proportion = other.getProportion();
               return this$proportion == null ? other$proportion == null : this$proportion.equals(other$proportion);
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
      return other instanceof CategoryProduceAnalysisDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $completeLength = this.getCompleteLength();
      result = result * 59 + ($completeLength == null ? 43 : $completeLength.hashCode());
      Object $proportion = this.getProportion();
      return result * 59 + ($proportion == null ? 43 : $proportion.hashCode());
   }

   public static class CategoryProduceAnalysisDTOBuilder {
      private Integer category;
      private String name;
      private BigDecimal completeLength;
      private BigDecimal proportion;

      CategoryProduceAnalysisDTOBuilder() {
      }

      @JsonProperty("category")
      public CategoryProduceAnalysisDTO.CategoryProduceAnalysisDTOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("name")
      public CategoryProduceAnalysisDTO.CategoryProduceAnalysisDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("completeLength")
      public CategoryProduceAnalysisDTO.CategoryProduceAnalysisDTOBuilder completeLength(final BigDecimal completeLength) {
         this.completeLength = completeLength;
         return this;
      }

      @JsonProperty("proportion")
      public CategoryProduceAnalysisDTO.CategoryProduceAnalysisDTOBuilder proportion(final BigDecimal proportion) {
         this.proportion = proportion;
         return this;
      }

      public CategoryProduceAnalysisDTO build() {
         return new CategoryProduceAnalysisDTO(this.category, this.name, this.completeLength, this.proportion);
      }

      @Override
      public String toString() {
         return "CategoryProduceAnalysisDTO.CategoryProduceAnalysisDTOBuilder(category="
            + this.category
            + ", name="
            + this.name
            + ", completeLength="
            + this.completeLength
            + ", proportion="
            + this.proportion
            + ")";
      }
   }
}
