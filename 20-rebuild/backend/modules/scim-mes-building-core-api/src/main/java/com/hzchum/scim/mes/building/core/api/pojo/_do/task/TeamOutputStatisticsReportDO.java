package com.hzchum.scim.mes.building.core.api.pojo._do.task;

import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;

@ApiModel(value = "YearlyOutputComparisonDO", description = "班组产量统计报表")
public class TeamOutputStatisticsReportDO {
   private Long teamId;
   private String teamName;
   private String processName;
   private String productType;
   private String productTypeName;
   private String workshopName;
   private String lineName;
   private BigDecimal totalTaskNetWeight;
   private BigDecimal totalCompleteNetWeight;
   private BigDecimal totalUncompleteNetWeight;
   private BigDecimal totalTaskNetWeightAll;
   private BigDecimal totalCompleteNetWeightAll;
   private BigDecimal totalUncompleteNetWeightAll;

   public static TeamOutputStatisticsReportDO.TeamOutputStatisticsReportDOBuilder builder() {
      return new TeamOutputStatisticsReportDO.TeamOutputStatisticsReportDOBuilder();
   }

   public TeamOutputStatisticsReportDO() {
   }

   public TeamOutputStatisticsReportDO(
      final Long teamId,
      final String teamName,
      final String processName,
      final String productType,
      final String productTypeName,
      final String workshopName,
      final String lineName,
      final BigDecimal totalTaskNetWeight,
      final BigDecimal totalCompleteNetWeight,
      final BigDecimal totalUncompleteNetWeight,
      final BigDecimal totalTaskNetWeightAll,
      final BigDecimal totalCompleteNetWeightAll,
      final BigDecimal totalUncompleteNetWeightAll
   ) {
      this.teamId = teamId;
      this.teamName = teamName;
      this.processName = processName;
      this.productType = productType;
      this.productTypeName = productTypeName;
      this.workshopName = workshopName;
      this.lineName = lineName;
      this.totalTaskNetWeight = totalTaskNetWeight;
      this.totalCompleteNetWeight = totalCompleteNetWeight;
      this.totalUncompleteNetWeight = totalUncompleteNetWeight;
      this.totalTaskNetWeightAll = totalTaskNetWeightAll;
      this.totalCompleteNetWeightAll = totalCompleteNetWeightAll;
      this.totalUncompleteNetWeightAll = totalUncompleteNetWeightAll;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public String getTeamName() {
      return this.teamName;
   }

   public String getProcessName() {
      return this.processName;
   }

   public String getProductType() {
      return this.productType;
   }

   public String getProductTypeName() {
      return this.productTypeName;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public String getLineName() {
      return this.lineName;
   }

   public BigDecimal getTotalTaskNetWeight() {
      return this.totalTaskNetWeight;
   }

   public BigDecimal getTotalCompleteNetWeight() {
      return this.totalCompleteNetWeight;
   }

   public BigDecimal getTotalUncompleteNetWeight() {
      return this.totalUncompleteNetWeight;
   }

   public BigDecimal getTotalTaskNetWeightAll() {
      return this.totalTaskNetWeightAll;
   }

   public BigDecimal getTotalCompleteNetWeightAll() {
      return this.totalCompleteNetWeightAll;
   }

   public BigDecimal getTotalUncompleteNetWeightAll() {
      return this.totalUncompleteNetWeightAll;
   }

   public TeamOutputStatisticsReportDO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   public TeamOutputStatisticsReportDO setTeamName(final String teamName) {
      this.teamName = teamName;
      return this;
   }

   public TeamOutputStatisticsReportDO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   public TeamOutputStatisticsReportDO setProductType(final String productType) {
      this.productType = productType;
      return this;
   }

   public TeamOutputStatisticsReportDO setProductTypeName(final String productTypeName) {
      this.productTypeName = productTypeName;
      return this;
   }

   public TeamOutputStatisticsReportDO setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
      return this;
   }

   public TeamOutputStatisticsReportDO setLineName(final String lineName) {
      this.lineName = lineName;
      return this;
   }

   public TeamOutputStatisticsReportDO setTotalTaskNetWeight(final BigDecimal totalTaskNetWeight) {
      this.totalTaskNetWeight = totalTaskNetWeight;
      return this;
   }

   public TeamOutputStatisticsReportDO setTotalCompleteNetWeight(final BigDecimal totalCompleteNetWeight) {
      this.totalCompleteNetWeight = totalCompleteNetWeight;
      return this;
   }

   public TeamOutputStatisticsReportDO setTotalUncompleteNetWeight(final BigDecimal totalUncompleteNetWeight) {
      this.totalUncompleteNetWeight = totalUncompleteNetWeight;
      return this;
   }

   public TeamOutputStatisticsReportDO setTotalTaskNetWeightAll(final BigDecimal totalTaskNetWeightAll) {
      this.totalTaskNetWeightAll = totalTaskNetWeightAll;
      return this;
   }

   public TeamOutputStatisticsReportDO setTotalCompleteNetWeightAll(final BigDecimal totalCompleteNetWeightAll) {
      this.totalCompleteNetWeightAll = totalCompleteNetWeightAll;
      return this;
   }

   public TeamOutputStatisticsReportDO setTotalUncompleteNetWeightAll(final BigDecimal totalUncompleteNetWeightAll) {
      this.totalUncompleteNetWeightAll = totalUncompleteNetWeightAll;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TeamOutputStatisticsReportDO)) {
         return false;
      }

      TeamOutputStatisticsReportDO other = (TeamOutputStatisticsReportDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$teamId = this.getTeamId();
      Object other$teamId = other.getTeamId();
      if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
         Object this$teamName = this.getTeamName();
         Object other$teamName = other.getTeamName();
         if (this$teamName == null ? other$teamName == null : this$teamName.equals(other$teamName)) {
            Object this$processName = this.getProcessName();
            Object other$processName = other.getProcessName();
            if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                  Object this$productTypeName = this.getProductTypeName();
                  Object other$productTypeName = other.getProductTypeName();
                  if (this$productTypeName == null ? other$productTypeName == null : this$productTypeName.equals(other$productTypeName)) {
                     Object this$workshopName = this.getWorkshopName();
                     Object other$workshopName = other.getWorkshopName();
                     if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                        Object this$lineName = this.getLineName();
                        Object other$lineName = other.getLineName();
                        if (this$lineName == null ? other$lineName == null : this$lineName.equals(other$lineName)) {
                           Object this$totalTaskNetWeight = this.getTotalTaskNetWeight();
                           Object other$totalTaskNetWeight = other.getTotalTaskNetWeight();
                           if (this$totalTaskNetWeight == null ? other$totalTaskNetWeight == null : this$totalTaskNetWeight.equals(other$totalTaskNetWeight)) {
                              Object this$totalCompleteNetWeight = this.getTotalCompleteNetWeight();
                              Object other$totalCompleteNetWeight = other.getTotalCompleteNetWeight();
                              if (this$totalCompleteNetWeight == null
                                 ? other$totalCompleteNetWeight == null
                                 : this$totalCompleteNetWeight.equals(other$totalCompleteNetWeight)) {
                                 Object this$totalUncompleteNetWeight = this.getTotalUncompleteNetWeight();
                                 Object other$totalUncompleteNetWeight = other.getTotalUncompleteNetWeight();
                                 if (this$totalUncompleteNetWeight == null
                                    ? other$totalUncompleteNetWeight == null
                                    : this$totalUncompleteNetWeight.equals(other$totalUncompleteNetWeight)) {
                                    Object this$totalTaskNetWeightAll = this.getTotalTaskNetWeightAll();
                                    Object other$totalTaskNetWeightAll = other.getTotalTaskNetWeightAll();
                                    if (this$totalTaskNetWeightAll == null
                                       ? other$totalTaskNetWeightAll == null
                                       : this$totalTaskNetWeightAll.equals(other$totalTaskNetWeightAll)) {
                                       Object this$totalCompleteNetWeightAll = this.getTotalCompleteNetWeightAll();
                                       Object other$totalCompleteNetWeightAll = other.getTotalCompleteNetWeightAll();
                                       if (this$totalCompleteNetWeightAll == null
                                          ? other$totalCompleteNetWeightAll == null
                                          : this$totalCompleteNetWeightAll.equals(other$totalCompleteNetWeightAll)) {
                                          Object this$totalUncompleteNetWeightAll = this.getTotalUncompleteNetWeightAll();
                                          Object other$totalUncompleteNetWeightAll = other.getTotalUncompleteNetWeightAll();
                                          return this$totalUncompleteNetWeightAll == null
                                             ? other$totalUncompleteNetWeightAll == null
                                             : this$totalUncompleteNetWeightAll.equals(other$totalUncompleteNetWeightAll);
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
      return other instanceof TeamOutputStatisticsReportDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $teamName = this.getTeamName();
      result = result * 59 + ($teamName == null ? 43 : $teamName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productTypeName = this.getProductTypeName();
      result = result * 59 + ($productTypeName == null ? 43 : $productTypeName.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $lineName = this.getLineName();
      result = result * 59 + ($lineName == null ? 43 : $lineName.hashCode());
      Object $totalTaskNetWeight = this.getTotalTaskNetWeight();
      result = result * 59 + ($totalTaskNetWeight == null ? 43 : $totalTaskNetWeight.hashCode());
      Object $totalCompleteNetWeight = this.getTotalCompleteNetWeight();
      result = result * 59 + ($totalCompleteNetWeight == null ? 43 : $totalCompleteNetWeight.hashCode());
      Object $totalUncompleteNetWeight = this.getTotalUncompleteNetWeight();
      result = result * 59 + ($totalUncompleteNetWeight == null ? 43 : $totalUncompleteNetWeight.hashCode());
      Object $totalTaskNetWeightAll = this.getTotalTaskNetWeightAll();
      result = result * 59 + ($totalTaskNetWeightAll == null ? 43 : $totalTaskNetWeightAll.hashCode());
      Object $totalCompleteNetWeightAll = this.getTotalCompleteNetWeightAll();
      result = result * 59 + ($totalCompleteNetWeightAll == null ? 43 : $totalCompleteNetWeightAll.hashCode());
      Object $totalUncompleteNetWeightAll = this.getTotalUncompleteNetWeightAll();
      return result * 59 + ($totalUncompleteNetWeightAll == null ? 43 : $totalUncompleteNetWeightAll.hashCode());
   }

   @Override
   public String toString() {
      return "TeamOutputStatisticsReportDO(teamId="
         + this.getTeamId()
         + ", teamName="
         + this.getTeamName()
         + ", processName="
         + this.getProcessName()
         + ", productType="
         + this.getProductType()
         + ", productTypeName="
         + this.getProductTypeName()
         + ", workshopName="
         + this.getWorkshopName()
         + ", lineName="
         + this.getLineName()
         + ", totalTaskNetWeight="
         + this.getTotalTaskNetWeight()
         + ", totalCompleteNetWeight="
         + this.getTotalCompleteNetWeight()
         + ", totalUncompleteNetWeight="
         + this.getTotalUncompleteNetWeight()
         + ", totalTaskNetWeightAll="
         + this.getTotalTaskNetWeightAll()
         + ", totalCompleteNetWeightAll="
         + this.getTotalCompleteNetWeightAll()
         + ", totalUncompleteNetWeightAll="
         + this.getTotalUncompleteNetWeightAll()
         + ")";
   }

   public static class TeamOutputStatisticsReportDOBuilder {
      private Long teamId;
      private String teamName;
      private String processName;
      private String productType;
      private String productTypeName;
      private String workshopName;
      private String lineName;
      private BigDecimal totalTaskNetWeight;
      private BigDecimal totalCompleteNetWeight;
      private BigDecimal totalUncompleteNetWeight;
      private BigDecimal totalTaskNetWeightAll;
      private BigDecimal totalCompleteNetWeightAll;
      private BigDecimal totalUncompleteNetWeightAll;

      TeamOutputStatisticsReportDOBuilder() {
      }

      public TeamOutputStatisticsReportDO.TeamOutputStatisticsReportDOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public TeamOutputStatisticsReportDO.TeamOutputStatisticsReportDOBuilder teamName(final String teamName) {
         this.teamName = teamName;
         return this;
      }

      public TeamOutputStatisticsReportDO.TeamOutputStatisticsReportDOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      public TeamOutputStatisticsReportDO.TeamOutputStatisticsReportDOBuilder productType(final String productType) {
         this.productType = productType;
         return this;
      }

      public TeamOutputStatisticsReportDO.TeamOutputStatisticsReportDOBuilder productTypeName(final String productTypeName) {
         this.productTypeName = productTypeName;
         return this;
      }

      public TeamOutputStatisticsReportDO.TeamOutputStatisticsReportDOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      public TeamOutputStatisticsReportDO.TeamOutputStatisticsReportDOBuilder lineName(final String lineName) {
         this.lineName = lineName;
         return this;
      }

      public TeamOutputStatisticsReportDO.TeamOutputStatisticsReportDOBuilder totalTaskNetWeight(final BigDecimal totalTaskNetWeight) {
         this.totalTaskNetWeight = totalTaskNetWeight;
         return this;
      }

      public TeamOutputStatisticsReportDO.TeamOutputStatisticsReportDOBuilder totalCompleteNetWeight(final BigDecimal totalCompleteNetWeight) {
         this.totalCompleteNetWeight = totalCompleteNetWeight;
         return this;
      }

      public TeamOutputStatisticsReportDO.TeamOutputStatisticsReportDOBuilder totalUncompleteNetWeight(final BigDecimal totalUncompleteNetWeight) {
         this.totalUncompleteNetWeight = totalUncompleteNetWeight;
         return this;
      }

      public TeamOutputStatisticsReportDO.TeamOutputStatisticsReportDOBuilder totalTaskNetWeightAll(final BigDecimal totalTaskNetWeightAll) {
         this.totalTaskNetWeightAll = totalTaskNetWeightAll;
         return this;
      }

      public TeamOutputStatisticsReportDO.TeamOutputStatisticsReportDOBuilder totalCompleteNetWeightAll(final BigDecimal totalCompleteNetWeightAll) {
         this.totalCompleteNetWeightAll = totalCompleteNetWeightAll;
         return this;
      }

      public TeamOutputStatisticsReportDO.TeamOutputStatisticsReportDOBuilder totalUncompleteNetWeightAll(final BigDecimal totalUncompleteNetWeightAll) {
         this.totalUncompleteNetWeightAll = totalUncompleteNetWeightAll;
         return this;
      }

      public TeamOutputStatisticsReportDO build() {
         return new TeamOutputStatisticsReportDO(
            this.teamId,
            this.teamName,
            this.processName,
            this.productType,
            this.productTypeName,
            this.workshopName,
            this.lineName,
            this.totalTaskNetWeight,
            this.totalCompleteNetWeight,
            this.totalUncompleteNetWeight,
            this.totalTaskNetWeightAll,
            this.totalCompleteNetWeightAll,
            this.totalUncompleteNetWeightAll
         );
      }

      @Override
      public String toString() {
         return "TeamOutputStatisticsReportDO.TeamOutputStatisticsReportDOBuilder(teamId="
            + this.teamId
            + ", teamName="
            + this.teamName
            + ", processName="
            + this.processName
            + ", productType="
            + this.productType
            + ", productTypeName="
            + this.productTypeName
            + ", workshopName="
            + this.workshopName
            + ", lineName="
            + this.lineName
            + ", totalTaskNetWeight="
            + this.totalTaskNetWeight
            + ", totalCompleteNetWeight="
            + this.totalCompleteNetWeight
            + ", totalUncompleteNetWeight="
            + this.totalUncompleteNetWeight
            + ", totalTaskNetWeightAll="
            + this.totalTaskNetWeightAll
            + ", totalCompleteNetWeightAll="
            + this.totalCompleteNetWeightAll
            + ", totalUncompleteNetWeightAll="
            + this.totalUncompleteNetWeightAll
            + ")";
      }
   }
}
