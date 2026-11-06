package com.hzchum.scim.mes.enclosure.core.api.pojo._do.projectKanban;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "EnclosureSummaryDO", description = "围护生产报表")
public class EnclosureSummaryDO {
   @ApiModelProperty(name = "category", notes = "围护类型")
   @JsonProperty("category")
   @JSONField(name = "category")
   private Integer category;
   @ApiModelProperty(name = "quantity", notes = "清单总数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "totalLength", notes = "清单总长度")
   @JsonProperty("totalLength")
   @JSONField(name = "totalLength")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "totalArea", notes = "清单总面积")
   @JsonProperty("totalArea")
   @JSONField(name = "totalArea")
   private BigDecimal totalArea;
   @ApiModelProperty(name = "completeQuantity", notes = "总完成量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "totalCompleteLength", notes = "总完成长度")
   @JsonProperty("totalCompleteLength")
   @JSONField(name = "totalCompleteLength")
   private BigDecimal totalCompleteLength;
   @ApiModelProperty(name = "totalCompleteArea", notes = "总完成面积")
   @JsonProperty("totalCompleteArea")
   @JSONField(name = "totalCompleteArea")
   private BigDecimal totalCompleteArea;

   public static EnclosureSummaryDO.EnclosureSummaryDOBuilder builder() {
      return new EnclosureSummaryDO.EnclosureSummaryDOBuilder();
   }

   public EnclosureSummaryDO() {
   }

   public EnclosureSummaryDO(
      final Integer category,
      final Integer quantity,
      final BigDecimal totalLength,
      final BigDecimal totalArea,
      final Integer completeQuantity,
      final BigDecimal totalCompleteLength,
      final BigDecimal totalCompleteArea
   ) {
      this.category = category;
      this.quantity = quantity;
      this.totalLength = totalLength;
      this.totalArea = totalArea;
      this.completeQuantity = completeQuantity;
      this.totalCompleteLength = totalCompleteLength;
      this.totalCompleteArea = totalCompleteArea;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getTotalCompleteLength() {
      return this.totalCompleteLength;
   }

   public BigDecimal getTotalCompleteArea() {
      return this.totalCompleteArea;
   }

   @JsonProperty("category")
   public EnclosureSummaryDO setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("quantity")
   public EnclosureSummaryDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalLength")
   public EnclosureSummaryDO setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
      return this;
   }

   @JsonProperty("totalArea")
   public EnclosureSummaryDO setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
      return this;
   }

   @JsonProperty("completeQuantity")
   public EnclosureSummaryDO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("totalCompleteLength")
   public EnclosureSummaryDO setTotalCompleteLength(final BigDecimal totalCompleteLength) {
      this.totalCompleteLength = totalCompleteLength;
      return this;
   }

   @JsonProperty("totalCompleteArea")
   public EnclosureSummaryDO setTotalCompleteArea(final BigDecimal totalCompleteArea) {
      this.totalCompleteArea = totalCompleteArea;
      return this;
   }

   @Override
   public String toString() {
      return "EnclosureSummaryDO(category="
         + this.getCategory()
         + ", quantity="
         + this.getQuantity()
         + ", totalLength="
         + this.getTotalLength()
         + ", totalArea="
         + this.getTotalArea()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", totalCompleteLength="
         + this.getTotalCompleteLength()
         + ", totalCompleteArea="
         + this.getTotalCompleteArea()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureSummaryDO)) {
         return false;
      }

      EnclosureSummaryDO other = (EnclosureSummaryDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$category = this.getCategory();
      Object other$category = other.getCategory();
      if (this$category == null ? other$category == null : this$category.equals(other$category)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$completeQuantity = this.getCompleteQuantity();
            Object other$completeQuantity = other.getCompleteQuantity();
            if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
               Object this$totalLength = this.getTotalLength();
               Object other$totalLength = other.getTotalLength();
               if (this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength)) {
                  Object this$totalArea = this.getTotalArea();
                  Object other$totalArea = other.getTotalArea();
                  if (this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea)) {
                     Object this$totalCompleteLength = this.getTotalCompleteLength();
                     Object other$totalCompleteLength = other.getTotalCompleteLength();
                     if (this$totalCompleteLength == null ? other$totalCompleteLength == null : this$totalCompleteLength.equals(other$totalCompleteLength)) {
                        Object this$totalCompleteArea = this.getTotalCompleteArea();
                        Object other$totalCompleteArea = other.getTotalCompleteArea();
                        return this$totalCompleteArea == null ? other$totalCompleteArea == null : this$totalCompleteArea.equals(other$totalCompleteArea);
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
      return other instanceof EnclosureSummaryDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $totalCompleteLength = this.getTotalCompleteLength();
      result = result * 59 + ($totalCompleteLength == null ? 43 : $totalCompleteLength.hashCode());
      Object $totalCompleteArea = this.getTotalCompleteArea();
      return result * 59 + ($totalCompleteArea == null ? 43 : $totalCompleteArea.hashCode());
   }

   public static class EnclosureSummaryDOBuilder {
      private Integer category;
      private Integer quantity;
      private BigDecimal totalLength;
      private BigDecimal totalArea;
      private Integer completeQuantity;
      private BigDecimal totalCompleteLength;
      private BigDecimal totalCompleteArea;

      EnclosureSummaryDOBuilder() {
      }

      @JsonProperty("category")
      public EnclosureSummaryDO.EnclosureSummaryDOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("quantity")
      public EnclosureSummaryDO.EnclosureSummaryDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalLength")
      public EnclosureSummaryDO.EnclosureSummaryDOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      @JsonProperty("totalArea")
      public EnclosureSummaryDO.EnclosureSummaryDOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      @JsonProperty("completeQuantity")
      public EnclosureSummaryDO.EnclosureSummaryDOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("totalCompleteLength")
      public EnclosureSummaryDO.EnclosureSummaryDOBuilder totalCompleteLength(final BigDecimal totalCompleteLength) {
         this.totalCompleteLength = totalCompleteLength;
         return this;
      }

      @JsonProperty("totalCompleteArea")
      public EnclosureSummaryDO.EnclosureSummaryDOBuilder totalCompleteArea(final BigDecimal totalCompleteArea) {
         this.totalCompleteArea = totalCompleteArea;
         return this;
      }

      public EnclosureSummaryDO build() {
         return new EnclosureSummaryDO(
            this.category, this.quantity, this.totalLength, this.totalArea, this.completeQuantity, this.totalCompleteLength, this.totalCompleteArea
         );
      }

      @Override
      public String toString() {
         return "EnclosureSummaryDO.EnclosureSummaryDOBuilder(category="
            + this.category
            + ", quantity="
            + this.quantity
            + ", totalLength="
            + this.totalLength
            + ", totalArea="
            + this.totalArea
            + ", completeQuantity="
            + this.completeQuantity
            + ", totalCompleteLength="
            + this.totalCompleteLength
            + ", totalCompleteArea="
            + this.totalCompleteArea
            + ")";
      }
   }
}
