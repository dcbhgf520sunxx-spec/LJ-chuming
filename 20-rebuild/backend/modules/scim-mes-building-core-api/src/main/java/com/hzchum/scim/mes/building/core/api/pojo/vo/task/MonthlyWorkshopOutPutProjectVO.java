package com.hzchum.scim.mes.building.core.api.pojo.vo.task;

import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;

@ApiModel(value = "MonthlyWorkshopOutPutProjectVO", description = "车间制作产量月报（项目）")
public class MonthlyWorkshopOutPutProjectVO {
   private String projectName;
   private BigDecimal totalNetWeight;

   public static MonthlyWorkshopOutPutProjectVO.MonthlyWorkshopOutPutProjectVOBuilder builder() {
      return new MonthlyWorkshopOutPutProjectVO.MonthlyWorkshopOutPutProjectVOBuilder();
   }

   public MonthlyWorkshopOutPutProjectVO() {
   }

   public MonthlyWorkshopOutPutProjectVO(final String projectName, final BigDecimal totalNetWeight) {
      this.projectName = projectName;
      this.totalNetWeight = totalNetWeight;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public MonthlyWorkshopOutPutProjectVO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public MonthlyWorkshopOutPutProjectVO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MonthlyWorkshopOutPutProjectVO)) {
         return false;
      } else {
         MonthlyWorkshopOutPutProjectVO other = (MonthlyWorkshopOutPutProjectVO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$projectName = this.getProjectName();
            Object other$projectName = other.getProjectName();
            if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
               Object this$totalNetWeight = this.getTotalNetWeight();
               Object other$totalNetWeight = other.getTotalNetWeight();
               return this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MonthlyWorkshopOutPutProjectVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      return result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
   }

   @Override
   public String toString() {
      return "MonthlyWorkshopOutPutProjectVO(projectName=" + this.getProjectName() + ", totalNetWeight=" + this.getTotalNetWeight() + ")";
   }

   public static class MonthlyWorkshopOutPutProjectVOBuilder {
      private String projectName;
      private BigDecimal totalNetWeight;

      MonthlyWorkshopOutPutProjectVOBuilder() {
      }

      public MonthlyWorkshopOutPutProjectVO.MonthlyWorkshopOutPutProjectVOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public MonthlyWorkshopOutPutProjectVO.MonthlyWorkshopOutPutProjectVOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public MonthlyWorkshopOutPutProjectVO build() {
         return new MonthlyWorkshopOutPutProjectVO(this.projectName, this.totalNetWeight);
      }

      @Override
      public String toString() {
         return "MonthlyWorkshopOutPutProjectVO.MonthlyWorkshopOutPutProjectVOBuilder(projectName="
            + this.projectName
            + ", totalNetWeight="
            + this.totalNetWeight
            + ")";
      }
   }
}
