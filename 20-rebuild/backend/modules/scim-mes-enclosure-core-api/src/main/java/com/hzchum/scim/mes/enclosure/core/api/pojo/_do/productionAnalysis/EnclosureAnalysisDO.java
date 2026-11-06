package com.hzchum.scim.mes.enclosure.core.api.pojo._do.productionAnalysis;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class EnclosureAnalysisDO {
   @ApiModelProperty(notes = "期初数量")
   @JsonInclude(Include.NON_NULL)
   private Integer surplusQuantity;
   @ApiModelProperty(name = "surplusLength", notes = "期初长度")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal surplusLength;
   @ApiModelProperty(name = "surplusArea", notes = "期初面积")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal surplusArea;
   @ApiModelProperty(notes = "任务数量")
   @JsonInclude(Include.NON_NULL)
   private Integer taskQuantity;
   @ApiModelProperty(name = "taskLength", notes = "任务长度")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal taskLength;
   @ApiModelProperty(name = "taskArea", notes = "任务面积")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal taskArea;
   @ApiModelProperty(notes = "完成数量")
   @JsonInclude(Include.NON_NULL)
   private Integer completeQuantity;
   @ApiModelProperty(name = "completeLength", notes = "完成长度")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal completeLength;
   @ApiModelProperty(name = "completeArea", notes = "完成面积")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal completeArea;
   @ApiModelProperty(notes = "在制品数量")
   @JsonInclude(Include.NON_NULL)
   private Integer inProductionQuantity;
   @ApiModelProperty(name = "inProductionLength", notes = "在制品长度")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal inProductionLength;
   @ApiModelProperty(name = "inProductionArea", notes = "在制品面积")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal inProductionArea;
   @ApiModelProperty(notes = "未制品数量")
   @JsonInclude(Include.NON_NULL)
   private Integer unProductionQuantity;
   @ApiModelProperty(name = "unProductionLength", notes = "未制品长度")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal unProductionLength;
   @ApiModelProperty(name = "unProductionArea", notes = "未制品面积")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal unProductionArea;

   public Integer getSurplusQuantity() {
      return this.surplusQuantity;
   }

   public BigDecimal getSurplusLength() {
      return this.surplusLength;
   }

   public BigDecimal getSurplusArea() {
      return this.surplusArea;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public BigDecimal getTaskLength() {
      return this.taskLength;
   }

   public BigDecimal getTaskArea() {
      return this.taskArea;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getCompleteLength() {
      return this.completeLength;
   }

   public BigDecimal getCompleteArea() {
      return this.completeArea;
   }

   public Integer getInProductionQuantity() {
      return this.inProductionQuantity;
   }

   public BigDecimal getInProductionLength() {
      return this.inProductionLength;
   }

   public BigDecimal getInProductionArea() {
      return this.inProductionArea;
   }

   public Integer getUnProductionQuantity() {
      return this.unProductionQuantity;
   }

   public BigDecimal getUnProductionLength() {
      return this.unProductionLength;
   }

   public BigDecimal getUnProductionArea() {
      return this.unProductionArea;
   }

   public void setSurplusQuantity(final Integer surplusQuantity) {
      this.surplusQuantity = surplusQuantity;
   }

   public void setSurplusLength(final BigDecimal surplusLength) {
      this.surplusLength = surplusLength;
   }

   public void setSurplusArea(final BigDecimal surplusArea) {
      this.surplusArea = surplusArea;
   }

   public void setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
   }

   public void setTaskLength(final BigDecimal taskLength) {
      this.taskLength = taskLength;
   }

   public void setTaskArea(final BigDecimal taskArea) {
      this.taskArea = taskArea;
   }

   public void setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
   }

   public void setCompleteLength(final BigDecimal completeLength) {
      this.completeLength = completeLength;
   }

   public void setCompleteArea(final BigDecimal completeArea) {
      this.completeArea = completeArea;
   }

   public void setInProductionQuantity(final Integer inProductionQuantity) {
      this.inProductionQuantity = inProductionQuantity;
   }

   public void setInProductionLength(final BigDecimal inProductionLength) {
      this.inProductionLength = inProductionLength;
   }

   public void setInProductionArea(final BigDecimal inProductionArea) {
      this.inProductionArea = inProductionArea;
   }

   public void setUnProductionQuantity(final Integer unProductionQuantity) {
      this.unProductionQuantity = unProductionQuantity;
   }

   public void setUnProductionLength(final BigDecimal unProductionLength) {
      this.unProductionLength = unProductionLength;
   }

   public void setUnProductionArea(final BigDecimal unProductionArea) {
      this.unProductionArea = unProductionArea;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureAnalysisDO)) {
         return false;
      }

      EnclosureAnalysisDO other = (EnclosureAnalysisDO)o;
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
                     Object this$surplusLength = this.getSurplusLength();
                     Object other$surplusLength = other.getSurplusLength();
                     if (this$surplusLength == null ? other$surplusLength == null : this$surplusLength.equals(other$surplusLength)) {
                        Object this$surplusArea = this.getSurplusArea();
                        Object other$surplusArea = other.getSurplusArea();
                        if (this$surplusArea == null ? other$surplusArea == null : this$surplusArea.equals(other$surplusArea)) {
                           Object this$taskLength = this.getTaskLength();
                           Object other$taskLength = other.getTaskLength();
                           if (this$taskLength == null ? other$taskLength == null : this$taskLength.equals(other$taskLength)) {
                              Object this$taskArea = this.getTaskArea();
                              Object other$taskArea = other.getTaskArea();
                              if (this$taskArea == null ? other$taskArea == null : this$taskArea.equals(other$taskArea)) {
                                 Object this$completeLength = this.getCompleteLength();
                                 Object other$completeLength = other.getCompleteLength();
                                 if (this$completeLength == null ? other$completeLength == null : this$completeLength.equals(other$completeLength)) {
                                    Object this$completeArea = this.getCompleteArea();
                                    Object other$completeArea = other.getCompleteArea();
                                    if (this$completeArea == null ? other$completeArea == null : this$completeArea.equals(other$completeArea)) {
                                       Object this$inProductionLength = this.getInProductionLength();
                                       Object other$inProductionLength = other.getInProductionLength();
                                       if (this$inProductionLength == null
                                          ? other$inProductionLength == null
                                          : this$inProductionLength.equals(other$inProductionLength)) {
                                          Object this$inProductionArea = this.getInProductionArea();
                                          Object other$inProductionArea = other.getInProductionArea();
                                          if (this$inProductionArea == null
                                             ? other$inProductionArea == null
                                             : this$inProductionArea.equals(other$inProductionArea)) {
                                             Object this$unProductionLength = this.getUnProductionLength();
                                             Object other$unProductionLength = other.getUnProductionLength();
                                             if (this$unProductionLength == null
                                                ? other$unProductionLength == null
                                                : this$unProductionLength.equals(other$unProductionLength)) {
                                                Object this$unProductionArea = this.getUnProductionArea();
                                                Object other$unProductionArea = other.getUnProductionArea();
                                                return this$unProductionArea == null
                                                   ? other$unProductionArea == null
                                                   : this$unProductionArea.equals(other$unProductionArea);
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
      return other instanceof EnclosureAnalysisDO;
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
      Object $surplusLength = this.getSurplusLength();
      result = result * 59 + ($surplusLength == null ? 43 : $surplusLength.hashCode());
      Object $surplusArea = this.getSurplusArea();
      result = result * 59 + ($surplusArea == null ? 43 : $surplusArea.hashCode());
      Object $taskLength = this.getTaskLength();
      result = result * 59 + ($taskLength == null ? 43 : $taskLength.hashCode());
      Object $taskArea = this.getTaskArea();
      result = result * 59 + ($taskArea == null ? 43 : $taskArea.hashCode());
      Object $completeLength = this.getCompleteLength();
      result = result * 59 + ($completeLength == null ? 43 : $completeLength.hashCode());
      Object $completeArea = this.getCompleteArea();
      result = result * 59 + ($completeArea == null ? 43 : $completeArea.hashCode());
      Object $inProductionLength = this.getInProductionLength();
      result = result * 59 + ($inProductionLength == null ? 43 : $inProductionLength.hashCode());
      Object $inProductionArea = this.getInProductionArea();
      result = result * 59 + ($inProductionArea == null ? 43 : $inProductionArea.hashCode());
      Object $unProductionLength = this.getUnProductionLength();
      result = result * 59 + ($unProductionLength == null ? 43 : $unProductionLength.hashCode());
      Object $unProductionArea = this.getUnProductionArea();
      return result * 59 + ($unProductionArea == null ? 43 : $unProductionArea.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureAnalysisDO(surplusQuantity="
         + this.getSurplusQuantity()
         + ", surplusLength="
         + this.getSurplusLength()
         + ", surplusArea="
         + this.getSurplusArea()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", taskLength="
         + this.getTaskLength()
         + ", taskArea="
         + this.getTaskArea()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", completeLength="
         + this.getCompleteLength()
         + ", completeArea="
         + this.getCompleteArea()
         + ", inProductionQuantity="
         + this.getInProductionQuantity()
         + ", inProductionLength="
         + this.getInProductionLength()
         + ", inProductionArea="
         + this.getInProductionArea()
         + ", unProductionQuantity="
         + this.getUnProductionQuantity()
         + ", unProductionLength="
         + this.getUnProductionLength()
         + ", unProductionArea="
         + this.getUnProductionArea()
         + ")";
   }
}
