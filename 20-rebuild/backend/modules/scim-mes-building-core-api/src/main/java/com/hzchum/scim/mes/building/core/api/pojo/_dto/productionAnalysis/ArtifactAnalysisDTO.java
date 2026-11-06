package com.hzchum.scim.mes.building.core.api.pojo._dto.productionAnalysis;

import io.swagger.annotations.ApiModelProperty;

public class ArtifactAnalysisDTO {
   @ApiModelProperty(name = "surplusTaskQuantity", notes = "剩余任务数量")
   private Integer surplusTaskQuantity;
   @ApiModelProperty(name = "surplusNetWeight", notes = "剩余任务净重量")
   private Integer surplusNetWeight;
   @ApiModelProperty(name = "surplusGrossWeight", notes = "剩余任务毛重量")
   private Integer surplusGrossWeight;
   @ApiModelProperty(name = "taskQuantity", notes = "本月任务数量")
   private Integer taskQuantity;
   @ApiModelProperty(name = "taskNetWeight", notes = "任务净重量")
   private Integer taskNetWeight;
   @ApiModelProperty(name = "taskGrossWeight", notes = "任务毛重量")
   private Integer taskGrossWeight;
   @ApiModelProperty(name = "inProductionQuantity", notes = "在制品数量")
   private Integer inProductionQuantity;
   @ApiModelProperty(name = "inProductionNetWeight", notes = "在制品净重量")
   private Integer inProductionNetWeight;
   @ApiModelProperty(name = "inProductionGrossWeight", notes = "在制品毛重量")
   private Integer inProductionGrossWeight;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数量")
   private Integer completeQuantity;
   @ApiModelProperty(name = "completeNetWeight", notes = "完成净重量")
   private Integer completeNetWeight;
   @ApiModelProperty(name = "completeGrossWeight", notes = "完成毛重量")
   private Integer completeGrossWeight;

   public Integer getSurplusTaskQuantity() {
      return this.surplusTaskQuantity;
   }

   public Integer getSurplusNetWeight() {
      return this.surplusNetWeight;
   }

   public Integer getSurplusGrossWeight() {
      return this.surplusGrossWeight;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getTaskNetWeight() {
      return this.taskNetWeight;
   }

   public Integer getTaskGrossWeight() {
      return this.taskGrossWeight;
   }

   public Integer getInProductionQuantity() {
      return this.inProductionQuantity;
   }

   public Integer getInProductionNetWeight() {
      return this.inProductionNetWeight;
   }

   public Integer getInProductionGrossWeight() {
      return this.inProductionGrossWeight;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public Integer getCompleteNetWeight() {
      return this.completeNetWeight;
   }

   public Integer getCompleteGrossWeight() {
      return this.completeGrossWeight;
   }

   public void setSurplusTaskQuantity(final Integer surplusTaskQuantity) {
      this.surplusTaskQuantity = surplusTaskQuantity;
   }

   public void setSurplusNetWeight(final Integer surplusNetWeight) {
      this.surplusNetWeight = surplusNetWeight;
   }

   public void setSurplusGrossWeight(final Integer surplusGrossWeight) {
      this.surplusGrossWeight = surplusGrossWeight;
   }

   public void setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
   }

   public void setTaskNetWeight(final Integer taskNetWeight) {
      this.taskNetWeight = taskNetWeight;
   }

   public void setTaskGrossWeight(final Integer taskGrossWeight) {
      this.taskGrossWeight = taskGrossWeight;
   }

   public void setInProductionQuantity(final Integer inProductionQuantity) {
      this.inProductionQuantity = inProductionQuantity;
   }

   public void setInProductionNetWeight(final Integer inProductionNetWeight) {
      this.inProductionNetWeight = inProductionNetWeight;
   }

   public void setInProductionGrossWeight(final Integer inProductionGrossWeight) {
      this.inProductionGrossWeight = inProductionGrossWeight;
   }

   public void setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
   }

   public void setCompleteNetWeight(final Integer completeNetWeight) {
      this.completeNetWeight = completeNetWeight;
   }

   public void setCompleteGrossWeight(final Integer completeGrossWeight) {
      this.completeGrossWeight = completeGrossWeight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactAnalysisDTO)) {
         return false;
      }

      ArtifactAnalysisDTO other = (ArtifactAnalysisDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$surplusTaskQuantity = this.getSurplusTaskQuantity();
      Object other$surplusTaskQuantity = other.getSurplusTaskQuantity();
      if (this$surplusTaskQuantity == null ? other$surplusTaskQuantity == null : this$surplusTaskQuantity.equals(other$surplusTaskQuantity)) {
         Object this$surplusNetWeight = this.getSurplusNetWeight();
         Object other$surplusNetWeight = other.getSurplusNetWeight();
         if (this$surplusNetWeight == null ? other$surplusNetWeight == null : this$surplusNetWeight.equals(other$surplusNetWeight)) {
            Object this$surplusGrossWeight = this.getSurplusGrossWeight();
            Object other$surplusGrossWeight = other.getSurplusGrossWeight();
            if (this$surplusGrossWeight == null ? other$surplusGrossWeight == null : this$surplusGrossWeight.equals(other$surplusGrossWeight)) {
               Object this$taskQuantity = this.getTaskQuantity();
               Object other$taskQuantity = other.getTaskQuantity();
               if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
                  Object this$taskNetWeight = this.getTaskNetWeight();
                  Object other$taskNetWeight = other.getTaskNetWeight();
                  if (this$taskNetWeight == null ? other$taskNetWeight == null : this$taskNetWeight.equals(other$taskNetWeight)) {
                     Object this$taskGrossWeight = this.getTaskGrossWeight();
                     Object other$taskGrossWeight = other.getTaskGrossWeight();
                     if (this$taskGrossWeight == null ? other$taskGrossWeight == null : this$taskGrossWeight.equals(other$taskGrossWeight)) {
                        Object this$inProductionQuantity = this.getInProductionQuantity();
                        Object other$inProductionQuantity = other.getInProductionQuantity();
                        if (this$inProductionQuantity == null
                           ? other$inProductionQuantity == null
                           : this$inProductionQuantity.equals(other$inProductionQuantity)) {
                           Object this$inProductionNetWeight = this.getInProductionNetWeight();
                           Object other$inProductionNetWeight = other.getInProductionNetWeight();
                           if (this$inProductionNetWeight == null
                              ? other$inProductionNetWeight == null
                              : this$inProductionNetWeight.equals(other$inProductionNetWeight)) {
                              Object this$inProductionGrossWeight = this.getInProductionGrossWeight();
                              Object other$inProductionGrossWeight = other.getInProductionGrossWeight();
                              if (this$inProductionGrossWeight == null
                                 ? other$inProductionGrossWeight == null
                                 : this$inProductionGrossWeight.equals(other$inProductionGrossWeight)) {
                                 Object this$completeQuantity = this.getCompleteQuantity();
                                 Object other$completeQuantity = other.getCompleteQuantity();
                                 if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
                                    Object this$completeNetWeight = this.getCompleteNetWeight();
                                    Object other$completeNetWeight = other.getCompleteNetWeight();
                                    if (this$completeNetWeight == null
                                       ? other$completeNetWeight == null
                                       : this$completeNetWeight.equals(other$completeNetWeight)) {
                                       Object this$completeGrossWeight = this.getCompleteGrossWeight();
                                       Object other$completeGrossWeight = other.getCompleteGrossWeight();
                                       return this$completeGrossWeight == null
                                          ? other$completeGrossWeight == null
                                          : this$completeGrossWeight.equals(other$completeGrossWeight);
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
      return other instanceof ArtifactAnalysisDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $surplusTaskQuantity = this.getSurplusTaskQuantity();
      result = result * 59 + ($surplusTaskQuantity == null ? 43 : $surplusTaskQuantity.hashCode());
      Object $surplusNetWeight = this.getSurplusNetWeight();
      result = result * 59 + ($surplusNetWeight == null ? 43 : $surplusNetWeight.hashCode());
      Object $surplusGrossWeight = this.getSurplusGrossWeight();
      result = result * 59 + ($surplusGrossWeight == null ? 43 : $surplusGrossWeight.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $taskNetWeight = this.getTaskNetWeight();
      result = result * 59 + ($taskNetWeight == null ? 43 : $taskNetWeight.hashCode());
      Object $taskGrossWeight = this.getTaskGrossWeight();
      result = result * 59 + ($taskGrossWeight == null ? 43 : $taskGrossWeight.hashCode());
      Object $inProductionQuantity = this.getInProductionQuantity();
      result = result * 59 + ($inProductionQuantity == null ? 43 : $inProductionQuantity.hashCode());
      Object $inProductionNetWeight = this.getInProductionNetWeight();
      result = result * 59 + ($inProductionNetWeight == null ? 43 : $inProductionNetWeight.hashCode());
      Object $inProductionGrossWeight = this.getInProductionGrossWeight();
      result = result * 59 + ($inProductionGrossWeight == null ? 43 : $inProductionGrossWeight.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $completeNetWeight = this.getCompleteNetWeight();
      result = result * 59 + ($completeNetWeight == null ? 43 : $completeNetWeight.hashCode());
      Object $completeGrossWeight = this.getCompleteGrossWeight();
      return result * 59 + ($completeGrossWeight == null ? 43 : $completeGrossWeight.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactAnalysisDTO(surplusTaskQuantity="
         + this.getSurplusTaskQuantity()
         + ", surplusNetWeight="
         + this.getSurplusNetWeight()
         + ", surplusGrossWeight="
         + this.getSurplusGrossWeight()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", taskNetWeight="
         + this.getTaskNetWeight()
         + ", taskGrossWeight="
         + this.getTaskGrossWeight()
         + ", inProductionQuantity="
         + this.getInProductionQuantity()
         + ", inProductionNetWeight="
         + this.getInProductionNetWeight()
         + ", inProductionGrossWeight="
         + this.getInProductionGrossWeight()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", completeNetWeight="
         + this.getCompleteNetWeight()
         + ", completeGrossWeight="
         + this.getCompleteGrossWeight()
         + ")";
   }
}
