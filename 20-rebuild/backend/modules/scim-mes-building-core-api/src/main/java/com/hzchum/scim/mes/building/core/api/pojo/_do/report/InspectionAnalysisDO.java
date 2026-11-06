package com.hzchum.scim.mes.building.core.api.pojo._do.report;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "InspectionAnalysisDO", description = "质检分析 ")
public class InspectionAnalysisDO {
   @ApiModelProperty(name = "month", value = "月份")
   @JsonProperty("month")
   @JSONField(name = "month")
   private Integer month;
   @ApiModelProperty(name = "quantity", value = "质检数")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "problemQuantity", value = "问题数")
   @JsonProperty("problemQuantity")
   @JSONField(name = "problemQuantity")
   private Integer problemQuantity;

   public static InspectionAnalysisDO.InspectionAnalysisDOBuilder builder() {
      return new InspectionAnalysisDO.InspectionAnalysisDOBuilder();
   }

   public InspectionAnalysisDO() {
   }

   public InspectionAnalysisDO(final Integer month, final Integer quantity, final Integer problemQuantity) {
      this.month = month;
      this.quantity = quantity;
      this.problemQuantity = problemQuantity;
   }

   public Integer getMonth() {
      return this.month;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getProblemQuantity() {
      return this.problemQuantity;
   }

   @JsonProperty("month")
   public InspectionAnalysisDO setMonth(final Integer month) {
      this.month = month;
      return this;
   }

   @JsonProperty("quantity")
   public InspectionAnalysisDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("problemQuantity")
   public InspectionAnalysisDO setProblemQuantity(final Integer problemQuantity) {
      this.problemQuantity = problemQuantity;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InspectionAnalysisDO)) {
         return false;
      }

      InspectionAnalysisDO other = (InspectionAnalysisDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$month = this.getMonth();
      Object other$month = other.getMonth();
      if (this$month == null ? other$month == null : this$month.equals(other$month)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$problemQuantity = this.getProblemQuantity();
            Object other$problemQuantity = other.getProblemQuantity();
            return this$problemQuantity == null ? other$problemQuantity == null : this$problemQuantity.equals(other$problemQuantity);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof InspectionAnalysisDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $problemQuantity = this.getProblemQuantity();
      return result * 59 + ($problemQuantity == null ? 43 : $problemQuantity.hashCode());
   }

   @Override
   public String toString() {
      return "InspectionAnalysisDO(month=" + this.getMonth() + ", quantity=" + this.getQuantity() + ", problemQuantity=" + this.getProblemQuantity() + ")";
   }

   public static class InspectionAnalysisDOBuilder {
      private Integer month;
      private Integer quantity;
      private Integer problemQuantity;

      InspectionAnalysisDOBuilder() {
      }

      @JsonProperty("month")
      public InspectionAnalysisDO.InspectionAnalysisDOBuilder month(final Integer month) {
         this.month = month;
         return this;
      }

      @JsonProperty("quantity")
      public InspectionAnalysisDO.InspectionAnalysisDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("problemQuantity")
      public InspectionAnalysisDO.InspectionAnalysisDOBuilder problemQuantity(final Integer problemQuantity) {
         this.problemQuantity = problemQuantity;
         return this;
      }

      public InspectionAnalysisDO build() {
         return new InspectionAnalysisDO(this.month, this.quantity, this.problemQuantity);
      }

      @Override
      public String toString() {
         return "InspectionAnalysisDO.InspectionAnalysisDOBuilder(month="
            + this.month
            + ", quantity="
            + this.quantity
            + ", problemQuantity="
            + this.problemQuantity
            + ")";
      }
   }
}
