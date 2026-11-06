package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.hzchum.scim.plan.core.api.pojo.dto.change.SimpleProject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "LossStatisticsDTO", description = "损耗统计")
public class LossStatisticsDTO {
   @ApiModelProperty(name = "project", notes = "项目")
   private SimpleProject project;
   @ApiModelProperty(name = "schedulingWeight", notes = "排产数量")
   private BigDecimal schedulingWeight;
   @ApiModelProperty(name = "steelFeedingWeight", notes = "钢板投料量")
   private BigDecimal steelFeedingWeight;
   @ApiModelProperty(name = "steelPickingWeight", notes = "钢板领料量")
   private BigDecimal steelPickingWeight;
   @ApiModelProperty(name = "steelReportWeight", notes = "板材零件上报量")
   private BigDecimal steelReportWeight;
   @ApiModelProperty(name = "steelLossWeight", notes = "钢板损耗量")
   private BigDecimal steelLossWeight;
   @ApiModelProperty(name = "profilesFeedingWeight", notes = "型材投料量")
   private BigDecimal profilesFeedingWeight;
   @ApiModelProperty(name = "profilesPickingWeight", notes = "型材领料量")
   private BigDecimal profilesPickingWeight;
   @ApiModelProperty(name = "profilesReportWeight", notes = "型材零件报工量")
   private BigDecimal profilesReportWeight;
   @ApiModelProperty(name = "profilesLossWeight", notes = "型材损耗量")
   private BigDecimal profilesLossWeight;
   @ApiModelProperty(name = "totalLossWeight", notes = "总损耗量")
   private BigDecimal totalLossWeight;
   @ApiModelProperty(name = "LossRate", notes = "损耗率")
   private BigDecimal LossRate;

   public static LossStatisticsDTO.LossStatisticsDTOBuilder builder() {
      return new LossStatisticsDTO.LossStatisticsDTOBuilder();
   }

   public LossStatisticsDTO() {
   }

   public LossStatisticsDTO(
      final SimpleProject project,
      final BigDecimal schedulingWeight,
      final BigDecimal steelFeedingWeight,
      final BigDecimal steelPickingWeight,
      final BigDecimal steelReportWeight,
      final BigDecimal steelLossWeight,
      final BigDecimal profilesFeedingWeight,
      final BigDecimal profilesPickingWeight,
      final BigDecimal profilesReportWeight,
      final BigDecimal profilesLossWeight,
      final BigDecimal totalLossWeight,
      final BigDecimal LossRate
   ) {
      this.project = project;
      this.schedulingWeight = schedulingWeight;
      this.steelFeedingWeight = steelFeedingWeight;
      this.steelPickingWeight = steelPickingWeight;
      this.steelReportWeight = steelReportWeight;
      this.steelLossWeight = steelLossWeight;
      this.profilesFeedingWeight = profilesFeedingWeight;
      this.profilesPickingWeight = profilesPickingWeight;
      this.profilesReportWeight = profilesReportWeight;
      this.profilesLossWeight = profilesLossWeight;
      this.totalLossWeight = totalLossWeight;
      this.LossRate = LossRate;
   }

   public SimpleProject getProject() {
      return this.project;
   }

   public BigDecimal getSchedulingWeight() {
      return this.schedulingWeight;
   }

   public BigDecimal getSteelFeedingWeight() {
      return this.steelFeedingWeight;
   }

   public BigDecimal getSteelPickingWeight() {
      return this.steelPickingWeight;
   }

   public BigDecimal getSteelReportWeight() {
      return this.steelReportWeight;
   }

   public BigDecimal getSteelLossWeight() {
      return this.steelLossWeight;
   }

   public BigDecimal getProfilesFeedingWeight() {
      return this.profilesFeedingWeight;
   }

   public BigDecimal getProfilesPickingWeight() {
      return this.profilesPickingWeight;
   }

   public BigDecimal getProfilesReportWeight() {
      return this.profilesReportWeight;
   }

   public BigDecimal getProfilesLossWeight() {
      return this.profilesLossWeight;
   }

   public BigDecimal getTotalLossWeight() {
      return this.totalLossWeight;
   }

   public BigDecimal getLossRate() {
      return this.LossRate;
   }

   public LossStatisticsDTO setProject(final SimpleProject project) {
      this.project = project;
      return this;
   }

   public LossStatisticsDTO setSchedulingWeight(final BigDecimal schedulingWeight) {
      this.schedulingWeight = schedulingWeight;
      return this;
   }

   public LossStatisticsDTO setSteelFeedingWeight(final BigDecimal steelFeedingWeight) {
      this.steelFeedingWeight = steelFeedingWeight;
      return this;
   }

   public LossStatisticsDTO setSteelPickingWeight(final BigDecimal steelPickingWeight) {
      this.steelPickingWeight = steelPickingWeight;
      return this;
   }

   public LossStatisticsDTO setSteelReportWeight(final BigDecimal steelReportWeight) {
      this.steelReportWeight = steelReportWeight;
      return this;
   }

   public LossStatisticsDTO setSteelLossWeight(final BigDecimal steelLossWeight) {
      this.steelLossWeight = steelLossWeight;
      return this;
   }

   public LossStatisticsDTO setProfilesFeedingWeight(final BigDecimal profilesFeedingWeight) {
      this.profilesFeedingWeight = profilesFeedingWeight;
      return this;
   }

   public LossStatisticsDTO setProfilesPickingWeight(final BigDecimal profilesPickingWeight) {
      this.profilesPickingWeight = profilesPickingWeight;
      return this;
   }

   public LossStatisticsDTO setProfilesReportWeight(final BigDecimal profilesReportWeight) {
      this.profilesReportWeight = profilesReportWeight;
      return this;
   }

   public LossStatisticsDTO setProfilesLossWeight(final BigDecimal profilesLossWeight) {
      this.profilesLossWeight = profilesLossWeight;
      return this;
   }

   public LossStatisticsDTO setTotalLossWeight(final BigDecimal totalLossWeight) {
      this.totalLossWeight = totalLossWeight;
      return this;
   }

   public LossStatisticsDTO setLossRate(final BigDecimal LossRate) {
      this.LossRate = LossRate;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof LossStatisticsDTO)) {
         return false;
      }

      LossStatisticsDTO other = (LossStatisticsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$project = this.getProject();
      Object other$project = other.getProject();
      if (this$project == null ? other$project == null : this$project.equals(other$project)) {
         Object this$schedulingWeight = this.getSchedulingWeight();
         Object other$schedulingWeight = other.getSchedulingWeight();
         if (this$schedulingWeight == null ? other$schedulingWeight == null : this$schedulingWeight.equals(other$schedulingWeight)) {
            Object this$steelFeedingWeight = this.getSteelFeedingWeight();
            Object other$steelFeedingWeight = other.getSteelFeedingWeight();
            if (this$steelFeedingWeight == null ? other$steelFeedingWeight == null : this$steelFeedingWeight.equals(other$steelFeedingWeight)) {
               Object this$steelPickingWeight = this.getSteelPickingWeight();
               Object other$steelPickingWeight = other.getSteelPickingWeight();
               if (this$steelPickingWeight == null ? other$steelPickingWeight == null : this$steelPickingWeight.equals(other$steelPickingWeight)) {
                  Object this$steelReportWeight = this.getSteelReportWeight();
                  Object other$steelReportWeight = other.getSteelReportWeight();
                  if (this$steelReportWeight == null ? other$steelReportWeight == null : this$steelReportWeight.equals(other$steelReportWeight)) {
                     Object this$steelLossWeight = this.getSteelLossWeight();
                     Object other$steelLossWeight = other.getSteelLossWeight();
                     if (this$steelLossWeight == null ? other$steelLossWeight == null : this$steelLossWeight.equals(other$steelLossWeight)) {
                        Object this$profilesFeedingWeight = this.getProfilesFeedingWeight();
                        Object other$profilesFeedingWeight = other.getProfilesFeedingWeight();
                        if (this$profilesFeedingWeight == null
                           ? other$profilesFeedingWeight == null
                           : this$profilesFeedingWeight.equals(other$profilesFeedingWeight)) {
                           Object this$profilesPickingWeight = this.getProfilesPickingWeight();
                           Object other$profilesPickingWeight = other.getProfilesPickingWeight();
                           if (this$profilesPickingWeight == null
                              ? other$profilesPickingWeight == null
                              : this$profilesPickingWeight.equals(other$profilesPickingWeight)) {
                              Object this$profilesReportWeight = this.getProfilesReportWeight();
                              Object other$profilesReportWeight = other.getProfilesReportWeight();
                              if (this$profilesReportWeight == null
                                 ? other$profilesReportWeight == null
                                 : this$profilesReportWeight.equals(other$profilesReportWeight)) {
                                 Object this$profilesLossWeight = this.getProfilesLossWeight();
                                 Object other$profilesLossWeight = other.getProfilesLossWeight();
                                 if (this$profilesLossWeight == null
                                    ? other$profilesLossWeight == null
                                    : this$profilesLossWeight.equals(other$profilesLossWeight)) {
                                    Object this$totalLossWeight = this.getTotalLossWeight();
                                    Object other$totalLossWeight = other.getTotalLossWeight();
                                    if (this$totalLossWeight == null ? other$totalLossWeight == null : this$totalLossWeight.equals(other$totalLossWeight)) {
                                       Object this$LossRate = this.getLossRate();
                                       Object other$LossRate = other.getLossRate();
                                       return this$LossRate == null ? other$LossRate == null : this$LossRate.equals(other$LossRate);
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
      return other instanceof LossStatisticsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $schedulingWeight = this.getSchedulingWeight();
      result = result * 59 + ($schedulingWeight == null ? 43 : $schedulingWeight.hashCode());
      Object $steelFeedingWeight = this.getSteelFeedingWeight();
      result = result * 59 + ($steelFeedingWeight == null ? 43 : $steelFeedingWeight.hashCode());
      Object $steelPickingWeight = this.getSteelPickingWeight();
      result = result * 59 + ($steelPickingWeight == null ? 43 : $steelPickingWeight.hashCode());
      Object $steelReportWeight = this.getSteelReportWeight();
      result = result * 59 + ($steelReportWeight == null ? 43 : $steelReportWeight.hashCode());
      Object $steelLossWeight = this.getSteelLossWeight();
      result = result * 59 + ($steelLossWeight == null ? 43 : $steelLossWeight.hashCode());
      Object $profilesFeedingWeight = this.getProfilesFeedingWeight();
      result = result * 59 + ($profilesFeedingWeight == null ? 43 : $profilesFeedingWeight.hashCode());
      Object $profilesPickingWeight = this.getProfilesPickingWeight();
      result = result * 59 + ($profilesPickingWeight == null ? 43 : $profilesPickingWeight.hashCode());
      Object $profilesReportWeight = this.getProfilesReportWeight();
      result = result * 59 + ($profilesReportWeight == null ? 43 : $profilesReportWeight.hashCode());
      Object $profilesLossWeight = this.getProfilesLossWeight();
      result = result * 59 + ($profilesLossWeight == null ? 43 : $profilesLossWeight.hashCode());
      Object $totalLossWeight = this.getTotalLossWeight();
      result = result * 59 + ($totalLossWeight == null ? 43 : $totalLossWeight.hashCode());
      Object $LossRate = this.getLossRate();
      return result * 59 + ($LossRate == null ? 43 : $LossRate.hashCode());
   }

   @Override
   public String toString() {
      return "LossStatisticsDTO(project="
         + this.getProject()
         + ", schedulingWeight="
         + this.getSchedulingWeight()
         + ", steelFeedingWeight="
         + this.getSteelFeedingWeight()
         + ", steelPickingWeight="
         + this.getSteelPickingWeight()
         + ", steelReportWeight="
         + this.getSteelReportWeight()
         + ", steelLossWeight="
         + this.getSteelLossWeight()
         + ", profilesFeedingWeight="
         + this.getProfilesFeedingWeight()
         + ", profilesPickingWeight="
         + this.getProfilesPickingWeight()
         + ", profilesReportWeight="
         + this.getProfilesReportWeight()
         + ", profilesLossWeight="
         + this.getProfilesLossWeight()
         + ", totalLossWeight="
         + this.getTotalLossWeight()
         + ", LossRate="
         + this.getLossRate()
         + ")";
   }

   public static class LossStatisticsDTOBuilder {
      private SimpleProject project;
      private BigDecimal schedulingWeight;
      private BigDecimal steelFeedingWeight;
      private BigDecimal steelPickingWeight;
      private BigDecimal steelReportWeight;
      private BigDecimal steelLossWeight;
      private BigDecimal profilesFeedingWeight;
      private BigDecimal profilesPickingWeight;
      private BigDecimal profilesReportWeight;
      private BigDecimal profilesLossWeight;
      private BigDecimal totalLossWeight;
      private BigDecimal LossRate;

      LossStatisticsDTOBuilder() {
      }

      public LossStatisticsDTO.LossStatisticsDTOBuilder project(final SimpleProject project) {
         this.project = project;
         return this;
      }

      public LossStatisticsDTO.LossStatisticsDTOBuilder schedulingWeight(final BigDecimal schedulingWeight) {
         this.schedulingWeight = schedulingWeight;
         return this;
      }

      public LossStatisticsDTO.LossStatisticsDTOBuilder steelFeedingWeight(final BigDecimal steelFeedingWeight) {
         this.steelFeedingWeight = steelFeedingWeight;
         return this;
      }

      public LossStatisticsDTO.LossStatisticsDTOBuilder steelPickingWeight(final BigDecimal steelPickingWeight) {
         this.steelPickingWeight = steelPickingWeight;
         return this;
      }

      public LossStatisticsDTO.LossStatisticsDTOBuilder steelReportWeight(final BigDecimal steelReportWeight) {
         this.steelReportWeight = steelReportWeight;
         return this;
      }

      public LossStatisticsDTO.LossStatisticsDTOBuilder steelLossWeight(final BigDecimal steelLossWeight) {
         this.steelLossWeight = steelLossWeight;
         return this;
      }

      public LossStatisticsDTO.LossStatisticsDTOBuilder profilesFeedingWeight(final BigDecimal profilesFeedingWeight) {
         this.profilesFeedingWeight = profilesFeedingWeight;
         return this;
      }

      public LossStatisticsDTO.LossStatisticsDTOBuilder profilesPickingWeight(final BigDecimal profilesPickingWeight) {
         this.profilesPickingWeight = profilesPickingWeight;
         return this;
      }

      public LossStatisticsDTO.LossStatisticsDTOBuilder profilesReportWeight(final BigDecimal profilesReportWeight) {
         this.profilesReportWeight = profilesReportWeight;
         return this;
      }

      public LossStatisticsDTO.LossStatisticsDTOBuilder profilesLossWeight(final BigDecimal profilesLossWeight) {
         this.profilesLossWeight = profilesLossWeight;
         return this;
      }

      public LossStatisticsDTO.LossStatisticsDTOBuilder totalLossWeight(final BigDecimal totalLossWeight) {
         this.totalLossWeight = totalLossWeight;
         return this;
      }

      public LossStatisticsDTO.LossStatisticsDTOBuilder LossRate(final BigDecimal LossRate) {
         this.LossRate = LossRate;
         return this;
      }

      public LossStatisticsDTO build() {
         return new LossStatisticsDTO(
            this.project,
            this.schedulingWeight,
            this.steelFeedingWeight,
            this.steelPickingWeight,
            this.steelReportWeight,
            this.steelLossWeight,
            this.profilesFeedingWeight,
            this.profilesPickingWeight,
            this.profilesReportWeight,
            this.profilesLossWeight,
            this.totalLossWeight,
            this.LossRate
         );
      }

      @Override
      public String toString() {
         return "LossStatisticsDTO.LossStatisticsDTOBuilder(project="
            + this.project
            + ", schedulingWeight="
            + this.schedulingWeight
            + ", steelFeedingWeight="
            + this.steelFeedingWeight
            + ", steelPickingWeight="
            + this.steelPickingWeight
            + ", steelReportWeight="
            + this.steelReportWeight
            + ", steelLossWeight="
            + this.steelLossWeight
            + ", profilesFeedingWeight="
            + this.profilesFeedingWeight
            + ", profilesPickingWeight="
            + this.profilesPickingWeight
            + ", profilesReportWeight="
            + this.profilesReportWeight
            + ", profilesLossWeight="
            + this.profilesLossWeight
            + ", totalLossWeight="
            + this.totalLossWeight
            + ", LossRate="
            + this.LossRate
            + ")";
      }
   }
}
