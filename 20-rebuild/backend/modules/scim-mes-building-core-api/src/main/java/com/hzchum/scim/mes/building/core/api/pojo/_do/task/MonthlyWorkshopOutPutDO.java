package com.hzchum.scim.mes.building.core.api.pojo._do.task;

import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;

@ApiModel(value = "MonthlyWorkshopOutPutDO", description = "车间制作产量月报")
public class MonthlyWorkshopOutPutDO {
   private String structureType;
   private String projectName;
   private BigDecimal totalNetWeight;
   private BigDecimal totalNetWeightAll;

   public static MonthlyWorkshopOutPutDO.MonthlyWorkshopOutPutDOBuilder builder() {
      return new MonthlyWorkshopOutPutDO.MonthlyWorkshopOutPutDOBuilder();
   }

   public MonthlyWorkshopOutPutDO() {
   }

   public MonthlyWorkshopOutPutDO(final String structureType, final String projectName, final BigDecimal totalNetWeight, final BigDecimal totalNetWeightAll) {
      this.structureType = structureType;
      this.projectName = projectName;
      this.totalNetWeight = totalNetWeight;
      this.totalNetWeightAll = totalNetWeightAll;
   }

   public String getStructureType() {
      return this.structureType;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getTotalNetWeightAll() {
      return this.totalNetWeightAll;
   }

   public MonthlyWorkshopOutPutDO setStructureType(final String structureType) {
      this.structureType = structureType;
      return this;
   }

   public MonthlyWorkshopOutPutDO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public MonthlyWorkshopOutPutDO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   public MonthlyWorkshopOutPutDO setTotalNetWeightAll(final BigDecimal totalNetWeightAll) {
      this.totalNetWeightAll = totalNetWeightAll;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MonthlyWorkshopOutPutDO)) {
         return false;
      }

      MonthlyWorkshopOutPutDO other = (MonthlyWorkshopOutPutDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$structureType = this.getStructureType();
      Object other$structureType = other.getStructureType();
      if (this$structureType == null ? other$structureType == null : this$structureType.equals(other$structureType)) {
         Object this$projectName = this.getProjectName();
         Object other$projectName = other.getProjectName();
         if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
            Object this$totalNetWeight = this.getTotalNetWeight();
            Object other$totalNetWeight = other.getTotalNetWeight();
            if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
               Object this$totalNetWeightAll = this.getTotalNetWeightAll();
               Object other$totalNetWeightAll = other.getTotalNetWeightAll();
               return this$totalNetWeightAll == null ? other$totalNetWeightAll == null : this$totalNetWeightAll.equals(other$totalNetWeightAll);
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
      return other instanceof MonthlyWorkshopOutPutDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalNetWeightAll = this.getTotalNetWeightAll();
      return result * 59 + ($totalNetWeightAll == null ? 43 : $totalNetWeightAll.hashCode());
   }

   @Override
   public String toString() {
      return "MonthlyWorkshopOutPutDO(structureType="
         + this.getStructureType()
         + ", projectName="
         + this.getProjectName()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalNetWeightAll="
         + this.getTotalNetWeightAll()
         + ")";
   }

   public static class MonthlyWorkshopOutPutDOBuilder {
      private String structureType;
      private String projectName;
      private BigDecimal totalNetWeight;
      private BigDecimal totalNetWeightAll;

      MonthlyWorkshopOutPutDOBuilder() {
      }

      public MonthlyWorkshopOutPutDO.MonthlyWorkshopOutPutDOBuilder structureType(final String structureType) {
         this.structureType = structureType;
         return this;
      }

      public MonthlyWorkshopOutPutDO.MonthlyWorkshopOutPutDOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public MonthlyWorkshopOutPutDO.MonthlyWorkshopOutPutDOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public MonthlyWorkshopOutPutDO.MonthlyWorkshopOutPutDOBuilder totalNetWeightAll(final BigDecimal totalNetWeightAll) {
         this.totalNetWeightAll = totalNetWeightAll;
         return this;
      }

      public MonthlyWorkshopOutPutDO build() {
         return new MonthlyWorkshopOutPutDO(this.structureType, this.projectName, this.totalNetWeight, this.totalNetWeightAll);
      }

      @Override
      public String toString() {
         return "MonthlyWorkshopOutPutDO.MonthlyWorkshopOutPutDOBuilder(structureType="
            + this.structureType
            + ", projectName="
            + this.projectName
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", totalNetWeightAll="
            + this.totalNetWeightAll
            + ")";
      }
   }
}
