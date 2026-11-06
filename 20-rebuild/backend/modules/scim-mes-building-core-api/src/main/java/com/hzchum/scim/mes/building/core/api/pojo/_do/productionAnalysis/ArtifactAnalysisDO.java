package com.hzchum.scim.mes.building.core.api.pojo._do.productionAnalysis;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class ArtifactAnalysisDO {
   @ApiModelProperty(notes = "期初数量")
   @JsonInclude(Include.NON_NULL)
   private Integer surplusQuantity;
   @ApiModelProperty(notes = "期初净重量")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal surplusNetWeight;
   @ApiModelProperty(notes = "期初毛重量")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal surplusGrossWeight;
   @ApiModelProperty(notes = "任务数量")
   @JsonInclude(Include.NON_NULL)
   private Integer taskQuantity;
   @ApiModelProperty(notes = "任务净重量")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal taskNetWeight;
   @ApiModelProperty(notes = "任务毛重量")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal taskGrossWeight;
   @ApiModelProperty(notes = "完成数量")
   @JsonInclude(Include.NON_NULL)
   private Integer completeQuantity;
   @ApiModelProperty(notes = "完成净重量")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal completeNetWeight;
   @ApiModelProperty(notes = "完成毛重量")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal completeGrossWeight;
   @ApiModelProperty(notes = "在制品数量")
   @JsonInclude(Include.NON_NULL)
   private Integer inProductionQuantity;
   @ApiModelProperty(notes = "在制品净重量")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal inProductionNetWeight;
   @ApiModelProperty(notes = "在制品毛重量")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal inProductionGrossWeight;
   @ApiModelProperty(notes = "未制品数量")
   @JsonInclude(Include.NON_NULL)
   private Integer unProductionQuantity;
   @ApiModelProperty(notes = "未制品净重量")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal unProductionNetWeight;
   @ApiModelProperty(notes = "未制品毛重量")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal unProductionGrossWeight;

   public Integer getSurplusQuantity() {
      return this.surplusQuantity;
   }

   public BigDecimal getSurplusNetWeight() {
      return this.surplusNetWeight;
   }

   public BigDecimal getSurplusGrossWeight() {
      return this.surplusGrossWeight;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public BigDecimal getTaskNetWeight() {
      return this.taskNetWeight;
   }

   public BigDecimal getTaskGrossWeight() {
      return this.taskGrossWeight;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getCompleteNetWeight() {
      return this.completeNetWeight;
   }

   public BigDecimal getCompleteGrossWeight() {
      return this.completeGrossWeight;
   }

   public Integer getInProductionQuantity() {
      return this.inProductionQuantity;
   }

   public BigDecimal getInProductionNetWeight() {
      return this.inProductionNetWeight;
   }

   public BigDecimal getInProductionGrossWeight() {
      return this.inProductionGrossWeight;
   }

   public Integer getUnProductionQuantity() {
      return this.unProductionQuantity;
   }

   public BigDecimal getUnProductionNetWeight() {
      return this.unProductionNetWeight;
   }

   public BigDecimal getUnProductionGrossWeight() {
      return this.unProductionGrossWeight;
   }

   public void setSurplusQuantity(final Integer surplusQuantity) {
      this.surplusQuantity = surplusQuantity;
   }

   public void setSurplusNetWeight(final BigDecimal surplusNetWeight) {
      this.surplusNetWeight = surplusNetWeight;
   }

   public void setSurplusGrossWeight(final BigDecimal surplusGrossWeight) {
      this.surplusGrossWeight = surplusGrossWeight;
   }

   public void setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
   }

   public void setTaskNetWeight(final BigDecimal taskNetWeight) {
      this.taskNetWeight = taskNetWeight;
   }

   public void setTaskGrossWeight(final BigDecimal taskGrossWeight) {
      this.taskGrossWeight = taskGrossWeight;
   }

   public void setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
   }

   public void setCompleteNetWeight(final BigDecimal completeNetWeight) {
      this.completeNetWeight = completeNetWeight;
   }

   public void setCompleteGrossWeight(final BigDecimal completeGrossWeight) {
      this.completeGrossWeight = completeGrossWeight;
   }

   public void setInProductionQuantity(final Integer inProductionQuantity) {
      this.inProductionQuantity = inProductionQuantity;
   }

   public void setInProductionNetWeight(final BigDecimal inProductionNetWeight) {
      this.inProductionNetWeight = inProductionNetWeight;
   }

   public void setInProductionGrossWeight(final BigDecimal inProductionGrossWeight) {
      this.inProductionGrossWeight = inProductionGrossWeight;
   }

   public void setUnProductionQuantity(final Integer unProductionQuantity) {
      this.unProductionQuantity = unProductionQuantity;
   }

   public void setUnProductionNetWeight(final BigDecimal unProductionNetWeight) {
      this.unProductionNetWeight = unProductionNetWeight;
   }

   public void setUnProductionGrossWeight(final BigDecimal unProductionGrossWeight) {
      this.unProductionGrossWeight = unProductionGrossWeight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactAnalysisDO)) {
         return false;
      }

      ArtifactAnalysisDO other = (ArtifactAnalysisDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$surplusQuantity = this.getSurplusQuantity();
      Object other$surplusQuantity = other.getSurplusQuantity();
      if (this$surplusQuantity == null ? other$surplusQuantity == null : this$surplusQuantity.equals(other$surplusQuantity)) {
         Object this$taskQuantity = this.getTaskQuantity();
         Object other$taskQuantity = other.getTaskQuantity();
         if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
            Object this$completeQuantity = this.getCompleteQuantity();
            Object other$completeQuantity = other.getCompleteQuantity();
            if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
               Object this$inProductionQuantity = this.getInProductionQuantity();
               Object other$inProductionQuantity = other.getInProductionQuantity();
               if (this$inProductionQuantity == null ? other$inProductionQuantity == null : this$inProductionQuantity.equals(other$inProductionQuantity)) {
                  Object this$unProductionQuantity = this.getUnProductionQuantity();
                  Object other$unProductionQuantity = other.getUnProductionQuantity();
                  if (this$unProductionQuantity == null ? other$unProductionQuantity == null : this$unProductionQuantity.equals(other$unProductionQuantity)) {
                     Object this$surplusNetWeight = this.getSurplusNetWeight();
                     Object other$surplusNetWeight = other.getSurplusNetWeight();
                     if (this$surplusNetWeight == null ? other$surplusNetWeight == null : this$surplusNetWeight.equals(other$surplusNetWeight)) {
                        Object this$surplusGrossWeight = this.getSurplusGrossWeight();
                        Object other$surplusGrossWeight = other.getSurplusGrossWeight();
                        if (this$surplusGrossWeight == null ? other$surplusGrossWeight == null : this$surplusGrossWeight.equals(other$surplusGrossWeight)) {
                           Object this$taskNetWeight = this.getTaskNetWeight();
                           Object other$taskNetWeight = other.getTaskNetWeight();
                           if (this$taskNetWeight == null ? other$taskNetWeight == null : this$taskNetWeight.equals(other$taskNetWeight)) {
                              Object this$taskGrossWeight = this.getTaskGrossWeight();
                              Object other$taskGrossWeight = other.getTaskGrossWeight();
                              if (this$taskGrossWeight == null ? other$taskGrossWeight == null : this$taskGrossWeight.equals(other$taskGrossWeight)) {
                                 Object this$completeNetWeight = this.getCompleteNetWeight();
                                 Object other$completeNetWeight = other.getCompleteNetWeight();
                                 if (this$completeNetWeight == null ? other$completeNetWeight == null : this$completeNetWeight.equals(other$completeNetWeight)) {
                                    Object this$completeGrossWeight = this.getCompleteGrossWeight();
                                    Object other$completeGrossWeight = other.getCompleteGrossWeight();
                                    if (this$completeGrossWeight == null
                                       ? other$completeGrossWeight == null
                                       : this$completeGrossWeight.equals(other$completeGrossWeight)) {
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
                                             Object this$unProductionNetWeight = this.getUnProductionNetWeight();
                                             Object other$unProductionNetWeight = other.getUnProductionNetWeight();
                                             if (this$unProductionNetWeight == null
                                                ? other$unProductionNetWeight == null
                                                : this$unProductionNetWeight.equals(other$unProductionNetWeight)) {
                                                Object this$unProductionGrossWeight = this.getUnProductionGrossWeight();
                                                Object other$unProductionGrossWeight = other.getUnProductionGrossWeight();
                                                return this$unProductionGrossWeight == null
                                                   ? other$unProductionGrossWeight == null
                                                   : this$unProductionGrossWeight.equals(other$unProductionGrossWeight);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactAnalysisDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $surplusQuantity = this.getSurplusQuantity();
      result = result * 59 + ($surplusQuantity == null ? 43 : $surplusQuantity.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $inProductionQuantity = this.getInProductionQuantity();
      result = result * 59 + ($inProductionQuantity == null ? 43 : $inProductionQuantity.hashCode());
      Object $unProductionQuantity = this.getUnProductionQuantity();
      result = result * 59 + ($unProductionQuantity == null ? 43 : $unProductionQuantity.hashCode());
      Object $surplusNetWeight = this.getSurplusNetWeight();
      result = result * 59 + ($surplusNetWeight == null ? 43 : $surplusNetWeight.hashCode());
      Object $surplusGrossWeight = this.getSurplusGrossWeight();
      result = result * 59 + ($surplusGrossWeight == null ? 43 : $surplusGrossWeight.hashCode());
      Object $taskNetWeight = this.getTaskNetWeight();
      result = result * 59 + ($taskNetWeight == null ? 43 : $taskNetWeight.hashCode());
      Object $taskGrossWeight = this.getTaskGrossWeight();
      result = result * 59 + ($taskGrossWeight == null ? 43 : $taskGrossWeight.hashCode());
      Object $completeNetWeight = this.getCompleteNetWeight();
      result = result * 59 + ($completeNetWeight == null ? 43 : $completeNetWeight.hashCode());
      Object $completeGrossWeight = this.getCompleteGrossWeight();
      result = result * 59 + ($completeGrossWeight == null ? 43 : $completeGrossWeight.hashCode());
      Object $inProductionNetWeight = this.getInProductionNetWeight();
      result = result * 59 + ($inProductionNetWeight == null ? 43 : $inProductionNetWeight.hashCode());
      Object $inProductionGrossWeight = this.getInProductionGrossWeight();
      result = result * 59 + ($inProductionGrossWeight == null ? 43 : $inProductionGrossWeight.hashCode());
      Object $unProductionNetWeight = this.getUnProductionNetWeight();
      result = result * 59 + ($unProductionNetWeight == null ? 43 : $unProductionNetWeight.hashCode());
      Object $unProductionGrossWeight = this.getUnProductionGrossWeight();
      return result * 59 + ($unProductionGrossWeight == null ? 43 : $unProductionGrossWeight.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactAnalysisDO(surplusQuantity="
         + this.getSurplusQuantity()
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
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", completeNetWeight="
         + this.getCompleteNetWeight()
         + ", completeGrossWeight="
         + this.getCompleteGrossWeight()
         + ", inProductionQuantity="
         + this.getInProductionQuantity()
         + ", inProductionNetWeight="
         + this.getInProductionNetWeight()
         + ", inProductionGrossWeight="
         + this.getInProductionGrossWeight()
         + ", unProductionQuantity="
         + this.getUnProductionQuantity()
         + ", unProductionNetWeight="
         + this.getUnProductionNetWeight()
         + ", unProductionGrossWeight="
         + this.getUnProductionGrossWeight()
         + ")";
   }
}
