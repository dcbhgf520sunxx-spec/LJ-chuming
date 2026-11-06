package com.hzchum.scim.operational.analysis.core.api.pojo._dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("生产成本分析-返回类")
public class ProductionCostAnalysisBaseDTO {
   @ApiModelProperty(name = "className", value = "类别", notes = "类别")
   private String className;
   @ApiModelProperty(name = "sumMete", value = "合计(元)", notes = "合计(元)")
   private BigDecimal sumMete;

   public static ProductionCostAnalysisBaseDTO.ProductionCostAnalysisBaseDTOBuilder builder() {
      return new ProductionCostAnalysisBaseDTO.ProductionCostAnalysisBaseDTOBuilder();
   }

   public ProductionCostAnalysisBaseDTO() {
   }

   public ProductionCostAnalysisBaseDTO(final String className, final BigDecimal sumMete) {
      this.className = className;
      this.sumMete = sumMete;
   }

   public String getClassName() {
      return this.className;
   }

   public BigDecimal getSumMete() {
      return this.sumMete;
   }

   public void setClassName(final String className) {
      this.className = className;
   }

   public void setSumMete(final BigDecimal sumMete) {
      this.sumMete = sumMete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProductionCostAnalysisBaseDTO)) {
         return false;
      } else {
         ProductionCostAnalysisBaseDTO other = (ProductionCostAnalysisBaseDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$className = this.getClassName();
            Object other$className = other.getClassName();
            if (this$className == null ? other$className == null : this$className.equals(other$className)) {
               Object this$sumMete = this.getSumMete();
               Object other$sumMete = other.getSumMete();
               return this$sumMete == null ? other$sumMete == null : this$sumMete.equals(other$sumMete);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductionCostAnalysisBaseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $className = this.getClassName();
      result = result * 59 + ($className == null ? 43 : $className.hashCode());
      Object $sumMete = this.getSumMete();
      return result * 59 + ($sumMete == null ? 43 : $sumMete.hashCode());
   }

   @Override
   public String toString() {
      return "ProductionCostAnalysisBaseDTO(className=" + this.getClassName() + ", sumMete=" + this.getSumMete() + ")";
   }

   public static class ProductionCostAnalysisBaseDTOBuilder {
      private String className;
      private BigDecimal sumMete;

      ProductionCostAnalysisBaseDTOBuilder() {
      }

      public ProductionCostAnalysisBaseDTO.ProductionCostAnalysisBaseDTOBuilder className(final String className) {
         this.className = className;
         return this;
      }

      public ProductionCostAnalysisBaseDTO.ProductionCostAnalysisBaseDTOBuilder sumMete(final BigDecimal sumMete) {
         this.sumMete = sumMete;
         return this;
      }

      public ProductionCostAnalysisBaseDTO build() {
         return new ProductionCostAnalysisBaseDTO(this.className, this.sumMete);
      }

      @Override
      public String toString() {
         return "ProductionCostAnalysisBaseDTO.ProductionCostAnalysisBaseDTOBuilder(className=" + this.className + ", sumMete=" + this.sumMete + ")";
      }
   }
}
