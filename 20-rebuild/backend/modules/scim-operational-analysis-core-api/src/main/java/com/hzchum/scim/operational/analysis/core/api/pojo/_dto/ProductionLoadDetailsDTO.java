package com.hzchum.scim.operational.analysis.core.api.pojo._dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class ProductionLoadDetailsDTO {
   @ApiModelProperty(name = "month", value = "月份", notes = "月份")
   @JsonProperty("month")
   @JSONField(name = "month")
   private Integer month;
   @ApiModelProperty(name = "target", value = "目标量", notes = "目标量")
   @JsonProperty("target")
   @JSONField(name = "target")
   private BigDecimal target;
   @ApiModelProperty(name = "complete", value = "完成量", notes = "完成量")
   @JsonProperty("complete")
   @JSONField(name = "complete")
   private BigDecimal complete;
   @ApiModelProperty(name = "lodaRatio", value = "负荷率", notes = "负荷率")
   @JsonProperty("lodaRatio")
   @JSONField(name = "lodaRatio")
   private BigDecimal lodaRatio;

   public static ProductionLoadDetailsDTO.ProductionLoadDetailsDTOBuilder builder() {
      return new ProductionLoadDetailsDTO.ProductionLoadDetailsDTOBuilder();
   }

   public Integer getMonth() {
      return this.month;
   }

   public BigDecimal getTarget() {
      return this.target;
   }

   public BigDecimal getComplete() {
      return this.complete;
   }

   public BigDecimal getLodaRatio() {
      return this.lodaRatio;
   }

   @JsonProperty("month")
   public void setMonth(final Integer month) {
      this.month = month;
   }

   @JsonProperty("target")
   public void setTarget(final BigDecimal target) {
      this.target = target;
   }

   @JsonProperty("complete")
   public void setComplete(final BigDecimal complete) {
      this.complete = complete;
   }

   @JsonProperty("lodaRatio")
   public void setLodaRatio(final BigDecimal lodaRatio) {
      this.lodaRatio = lodaRatio;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductionLoadDetailsDTO)) {
         return false;
      }

      ProductionLoadDetailsDTO other = (ProductionLoadDetailsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$month = this.getMonth();
      Object other$month = other.getMonth();
      if (this$month == null ? other$month == null : this$month.equals(other$month)) {
         Object this$target = this.getTarget();
         Object other$target = other.getTarget();
         if (this$target == null ? other$target == null : this$target.equals(other$target)) {
            Object this$complete = this.getComplete();
            Object other$complete = other.getComplete();
            if (this$complete == null ? other$complete == null : this$complete.equals(other$complete)) {
               Object this$lodaRatio = this.getLodaRatio();
               Object other$lodaRatio = other.getLodaRatio();
               return this$lodaRatio == null ? other$lodaRatio == null : this$lodaRatio.equals(other$lodaRatio);
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
      return other instanceof ProductionLoadDetailsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $target = this.getTarget();
      result = result * 59 + ($target == null ? 43 : $target.hashCode());
      Object $complete = this.getComplete();
      result = result * 59 + ($complete == null ? 43 : $complete.hashCode());
      Object $lodaRatio = this.getLodaRatio();
      return result * 59 + ($lodaRatio == null ? 43 : $lodaRatio.hashCode());
   }

   @Override
   public String toString() {
      return "ProductionLoadDetailsDTO(month="
         + this.getMonth()
         + ", target="
         + this.getTarget()
         + ", complete="
         + this.getComplete()
         + ", lodaRatio="
         + this.getLodaRatio()
         + ")";
   }

   public ProductionLoadDetailsDTO(final Integer month, final BigDecimal target, final BigDecimal complete, final BigDecimal lodaRatio) {
      this.month = month;
      this.target = target;
      this.complete = complete;
      this.lodaRatio = lodaRatio;
   }

   public ProductionLoadDetailsDTO() {
   }

   public static class ProductionLoadDetailsDTOBuilder {
      private Integer month;
      private BigDecimal target;
      private BigDecimal complete;
      private BigDecimal lodaRatio;

      ProductionLoadDetailsDTOBuilder() {
      }

      @JsonProperty("month")
      public ProductionLoadDetailsDTO.ProductionLoadDetailsDTOBuilder month(final Integer month) {
         this.month = month;
         return this;
      }

      @JsonProperty("target")
      public ProductionLoadDetailsDTO.ProductionLoadDetailsDTOBuilder target(final BigDecimal target) {
         this.target = target;
         return this;
      }

      @JsonProperty("complete")
      public ProductionLoadDetailsDTO.ProductionLoadDetailsDTOBuilder complete(final BigDecimal complete) {
         this.complete = complete;
         return this;
      }

      @JsonProperty("lodaRatio")
      public ProductionLoadDetailsDTO.ProductionLoadDetailsDTOBuilder lodaRatio(final BigDecimal lodaRatio) {
         this.lodaRatio = lodaRatio;
         return this;
      }

      public ProductionLoadDetailsDTO build() {
         return new ProductionLoadDetailsDTO(this.month, this.target, this.complete, this.lodaRatio);
      }

      @Override
      public String toString() {
         return "ProductionLoadDetailsDTO.ProductionLoadDetailsDTOBuilder(month="
            + this.month
            + ", target="
            + this.target
            + ", complete="
            + this.complete
            + ", lodaRatio="
            + this.lodaRatio
            + ")";
      }
   }
}
