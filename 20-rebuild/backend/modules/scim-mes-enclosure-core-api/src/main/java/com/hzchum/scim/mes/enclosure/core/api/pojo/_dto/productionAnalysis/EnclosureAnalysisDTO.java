package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.productionAnalysis;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProjectKanBanDTO", description = "项目看板")
public class EnclosureAnalysisDTO {
   @ApiModelProperty(name = "surplusTaskQuantity", notes = "剩余任务数量")
   @JsonProperty("surplusTaskQuantity")
   @JSONField(name = "surplusTaskQuantity")
   private Integer surplusTaskQuantity;
   @ApiModelProperty(name = "surplusLength", notes = "剩余任务长度")
   @JsonProperty("surplusLength")
   @JSONField(name = "surplusLength")
   private Integer surplusLength;
   @ApiModelProperty(name = "surplusArea", notes = "剩余任务面积")
   @JsonProperty("surplusArea")
   @JSONField(name = "surplusArea")
   private Integer surplusArea;
   @ApiModelProperty(name = "taskQuantity", notes = "本月任务数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "taskLength", notes = "任务长度")
   @JsonProperty("taskLength")
   @JSONField(name = "taskLength")
   private Integer taskLength;
   @ApiModelProperty(name = "taskArea", notes = "任务面积")
   @JsonProperty("taskArea")
   @JSONField(name = "taskArea")
   private Integer taskArea;
   @ApiModelProperty(name = "inProductionQuantity", notes = "在制品数量")
   @JsonProperty("inProductionQuantity")
   @JSONField(name = "inProductionQuantity")
   private Integer inProductionQuantity;
   @ApiModelProperty(name = "inProductionLength", notes = "在制品长度")
   @JsonProperty("inProductionLength")
   @JSONField(name = "inProductionLength")
   private Integer inProductionLength;
   @ApiModelProperty(name = "inProductionArea", notes = "在制品面积")
   @JsonProperty("inProductionArea")
   @JSONField(name = "inProductionArea")
   private Integer inProductionArea;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "completeLength", notes = "完成长度")
   @JsonProperty("completeLength")
   @JSONField(name = "completeLength")
   private Integer completeLength;
   @ApiModelProperty(name = "completeArea", notes = "完成长度")
   @JsonProperty("completeArea")
   @JSONField(name = "completeArea")
   private Integer completeArea;

   public static EnclosureAnalysisDTO.EnclosureAnalysisDTOBuilder builder() {
      return new EnclosureAnalysisDTO.EnclosureAnalysisDTOBuilder();
   }

   public EnclosureAnalysisDTO() {
   }

   public EnclosureAnalysisDTO(
      final Integer surplusTaskQuantity,
      final Integer surplusLength,
      final Integer surplusArea,
      final Integer taskQuantity,
      final Integer taskLength,
      final Integer taskArea,
      final Integer inProductionQuantity,
      final Integer inProductionLength,
      final Integer inProductionArea,
      final Integer completeQuantity,
      final Integer completeLength,
      final Integer completeArea
   ) {
      this.surplusTaskQuantity = surplusTaskQuantity;
      this.surplusLength = surplusLength;
      this.surplusArea = surplusArea;
      this.taskQuantity = taskQuantity;
      this.taskLength = taskLength;
      this.taskArea = taskArea;
      this.inProductionQuantity = inProductionQuantity;
      this.inProductionLength = inProductionLength;
      this.inProductionArea = inProductionArea;
      this.completeQuantity = completeQuantity;
      this.completeLength = completeLength;
      this.completeArea = completeArea;
   }

   public Integer getSurplusTaskQuantity() {
      return this.surplusTaskQuantity;
   }

   public Integer getSurplusLength() {
      return this.surplusLength;
   }

   public Integer getSurplusArea() {
      return this.surplusArea;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getTaskLength() {
      return this.taskLength;
   }

   public Integer getTaskArea() {
      return this.taskArea;
   }

   public Integer getInProductionQuantity() {
      return this.inProductionQuantity;
   }

   public Integer getInProductionLength() {
      return this.inProductionLength;
   }

   public Integer getInProductionArea() {
      return this.inProductionArea;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public Integer getCompleteLength() {
      return this.completeLength;
   }

   public Integer getCompleteArea() {
      return this.completeArea;
   }

   @JsonProperty("surplusTaskQuantity")
   public EnclosureAnalysisDTO setSurplusTaskQuantity(final Integer surplusTaskQuantity) {
      this.surplusTaskQuantity = surplusTaskQuantity;
      return this;
   }

   @JsonProperty("surplusLength")
   public EnclosureAnalysisDTO setSurplusLength(final Integer surplusLength) {
      this.surplusLength = surplusLength;
      return this;
   }

   @JsonProperty("surplusArea")
   public EnclosureAnalysisDTO setSurplusArea(final Integer surplusArea) {
      this.surplusArea = surplusArea;
      return this;
   }

   @JsonProperty("taskQuantity")
   public EnclosureAnalysisDTO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("taskLength")
   public EnclosureAnalysisDTO setTaskLength(final Integer taskLength) {
      this.taskLength = taskLength;
      return this;
   }

   @JsonProperty("taskArea")
   public EnclosureAnalysisDTO setTaskArea(final Integer taskArea) {
      this.taskArea = taskArea;
      return this;
   }

   @JsonProperty("inProductionQuantity")
   public EnclosureAnalysisDTO setInProductionQuantity(final Integer inProductionQuantity) {
      this.inProductionQuantity = inProductionQuantity;
      return this;
   }

   @JsonProperty("inProductionLength")
   public EnclosureAnalysisDTO setInProductionLength(final Integer inProductionLength) {
      this.inProductionLength = inProductionLength;
      return this;
   }

   @JsonProperty("inProductionArea")
   public EnclosureAnalysisDTO setInProductionArea(final Integer inProductionArea) {
      this.inProductionArea = inProductionArea;
      return this;
   }

   @JsonProperty("completeQuantity")
   public EnclosureAnalysisDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("completeLength")
   public EnclosureAnalysisDTO setCompleteLength(final Integer completeLength) {
      this.completeLength = completeLength;
      return this;
   }

   @JsonProperty("completeArea")
   public EnclosureAnalysisDTO setCompleteArea(final Integer completeArea) {
      this.completeArea = completeArea;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureAnalysisDTO)) {
         return false;
      }

      EnclosureAnalysisDTO other = (EnclosureAnalysisDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$surplusTaskQuantity = this.getSurplusTaskQuantity();
      Object other$surplusTaskQuantity = other.getSurplusTaskQuantity();
      if (this$surplusTaskQuantity == null ? other$surplusTaskQuantity == null : this$surplusTaskQuantity.equals(other$surplusTaskQuantity)) {
         Object this$surplusLength = this.getSurplusLength();
         Object other$surplusLength = other.getSurplusLength();
         if (this$surplusLength == null ? other$surplusLength == null : this$surplusLength.equals(other$surplusLength)) {
            Object this$surplusArea = this.getSurplusArea();
            Object other$surplusArea = other.getSurplusArea();
            if (this$surplusArea == null ? other$surplusArea == null : this$surplusArea.equals(other$surplusArea)) {
               Object this$taskQuantity = this.getTaskQuantity();
               Object other$taskQuantity = other.getTaskQuantity();
               if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
                  Object this$taskLength = this.getTaskLength();
                  Object other$taskLength = other.getTaskLength();
                  if (this$taskLength == null ? other$taskLength == null : this$taskLength.equals(other$taskLength)) {
                     Object this$taskArea = this.getTaskArea();
                     Object other$taskArea = other.getTaskArea();
                     if (this$taskArea == null ? other$taskArea == null : this$taskArea.equals(other$taskArea)) {
                        Object this$inProductionQuantity = this.getInProductionQuantity();
                        Object other$inProductionQuantity = other.getInProductionQuantity();
                        if (this$inProductionQuantity == null
                           ? other$inProductionQuantity == null
                           : this$inProductionQuantity.equals(other$inProductionQuantity)) {
                           Object this$inProductionLength = this.getInProductionLength();
                           Object other$inProductionLength = other.getInProductionLength();
                           if (this$inProductionLength == null ? other$inProductionLength == null : this$inProductionLength.equals(other$inProductionLength)) {
                              Object this$inProductionArea = this.getInProductionArea();
                              Object other$inProductionArea = other.getInProductionArea();
                              if (this$inProductionArea == null ? other$inProductionArea == null : this$inProductionArea.equals(other$inProductionArea)) {
                                 Object this$completeQuantity = this.getCompleteQuantity();
                                 Object other$completeQuantity = other.getCompleteQuantity();
                                 if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
                                    Object this$completeLength = this.getCompleteLength();
                                    Object other$completeLength = other.getCompleteLength();
                                    if (this$completeLength == null ? other$completeLength == null : this$completeLength.equals(other$completeLength)) {
                                       Object this$completeArea = this.getCompleteArea();
                                       Object other$completeArea = other.getCompleteArea();
                                       return this$completeArea == null ? other$completeArea == null : this$completeArea.equals(other$completeArea);
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
      return other instanceof EnclosureAnalysisDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $surplusTaskQuantity = this.getSurplusTaskQuantity();
      result = result * 59 + ($surplusTaskQuantity == null ? 43 : $surplusTaskQuantity.hashCode());
      Object $surplusLength = this.getSurplusLength();
      result = result * 59 + ($surplusLength == null ? 43 : $surplusLength.hashCode());
      Object $surplusArea = this.getSurplusArea();
      result = result * 59 + ($surplusArea == null ? 43 : $surplusArea.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $taskLength = this.getTaskLength();
      result = result * 59 + ($taskLength == null ? 43 : $taskLength.hashCode());
      Object $taskArea = this.getTaskArea();
      result = result * 59 + ($taskArea == null ? 43 : $taskArea.hashCode());
      Object $inProductionQuantity = this.getInProductionQuantity();
      result = result * 59 + ($inProductionQuantity == null ? 43 : $inProductionQuantity.hashCode());
      Object $inProductionLength = this.getInProductionLength();
      result = result * 59 + ($inProductionLength == null ? 43 : $inProductionLength.hashCode());
      Object $inProductionArea = this.getInProductionArea();
      result = result * 59 + ($inProductionArea == null ? 43 : $inProductionArea.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $completeLength = this.getCompleteLength();
      result = result * 59 + ($completeLength == null ? 43 : $completeLength.hashCode());
      Object $completeArea = this.getCompleteArea();
      return result * 59 + ($completeArea == null ? 43 : $completeArea.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureAnalysisDTO(surplusTaskQuantity="
         + this.getSurplusTaskQuantity()
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
         + ", inProductionQuantity="
         + this.getInProductionQuantity()
         + ", inProductionLength="
         + this.getInProductionLength()
         + ", inProductionArea="
         + this.getInProductionArea()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", completeLength="
         + this.getCompleteLength()
         + ", completeArea="
         + this.getCompleteArea()
         + ")";
   }

   public static class EnclosureAnalysisDTOBuilder {
      private Integer surplusTaskQuantity;
      private Integer surplusLength;
      private Integer surplusArea;
      private Integer taskQuantity;
      private Integer taskLength;
      private Integer taskArea;
      private Integer inProductionQuantity;
      private Integer inProductionLength;
      private Integer inProductionArea;
      private Integer completeQuantity;
      private Integer completeLength;
      private Integer completeArea;

      EnclosureAnalysisDTOBuilder() {
      }

      @JsonProperty("surplusTaskQuantity")
      public EnclosureAnalysisDTO.EnclosureAnalysisDTOBuilder surplusTaskQuantity(final Integer surplusTaskQuantity) {
         this.surplusTaskQuantity = surplusTaskQuantity;
         return this;
      }

      @JsonProperty("surplusLength")
      public EnclosureAnalysisDTO.EnclosureAnalysisDTOBuilder surplusLength(final Integer surplusLength) {
         this.surplusLength = surplusLength;
         return this;
      }

      @JsonProperty("surplusArea")
      public EnclosureAnalysisDTO.EnclosureAnalysisDTOBuilder surplusArea(final Integer surplusArea) {
         this.surplusArea = surplusArea;
         return this;
      }

      @JsonProperty("taskQuantity")
      public EnclosureAnalysisDTO.EnclosureAnalysisDTOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("taskLength")
      public EnclosureAnalysisDTO.EnclosureAnalysisDTOBuilder taskLength(final Integer taskLength) {
         this.taskLength = taskLength;
         return this;
      }

      @JsonProperty("taskArea")
      public EnclosureAnalysisDTO.EnclosureAnalysisDTOBuilder taskArea(final Integer taskArea) {
         this.taskArea = taskArea;
         return this;
      }

      @JsonProperty("inProductionQuantity")
      public EnclosureAnalysisDTO.EnclosureAnalysisDTOBuilder inProductionQuantity(final Integer inProductionQuantity) {
         this.inProductionQuantity = inProductionQuantity;
         return this;
      }

      @JsonProperty("inProductionLength")
      public EnclosureAnalysisDTO.EnclosureAnalysisDTOBuilder inProductionLength(final Integer inProductionLength) {
         this.inProductionLength = inProductionLength;
         return this;
      }

      @JsonProperty("inProductionArea")
      public EnclosureAnalysisDTO.EnclosureAnalysisDTOBuilder inProductionArea(final Integer inProductionArea) {
         this.inProductionArea = inProductionArea;
         return this;
      }

      @JsonProperty("completeQuantity")
      public EnclosureAnalysisDTO.EnclosureAnalysisDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("completeLength")
      public EnclosureAnalysisDTO.EnclosureAnalysisDTOBuilder completeLength(final Integer completeLength) {
         this.completeLength = completeLength;
         return this;
      }

      @JsonProperty("completeArea")
      public EnclosureAnalysisDTO.EnclosureAnalysisDTOBuilder completeArea(final Integer completeArea) {
         this.completeArea = completeArea;
         return this;
      }

      public EnclosureAnalysisDTO build() {
         return new EnclosureAnalysisDTO(
            this.surplusTaskQuantity,
            this.surplusLength,
            this.surplusArea,
            this.taskQuantity,
            this.taskLength,
            this.taskArea,
            this.inProductionQuantity,
            this.inProductionLength,
            this.inProductionArea,
            this.completeQuantity,
            this.completeLength,
            this.completeArea
         );
      }

      @Override
      public String toString() {
         return "EnclosureAnalysisDTO.EnclosureAnalysisDTOBuilder(surplusTaskQuantity="
            + this.surplusTaskQuantity
            + ", surplusLength="
            + this.surplusLength
            + ", surplusArea="
            + this.surplusArea
            + ", taskQuantity="
            + this.taskQuantity
            + ", taskLength="
            + this.taskLength
            + ", taskArea="
            + this.taskArea
            + ", inProductionQuantity="
            + this.inProductionQuantity
            + ", inProductionLength="
            + this.inProductionLength
            + ", inProductionArea="
            + this.inProductionArea
            + ", completeQuantity="
            + this.completeQuantity
            + ", completeLength="
            + this.completeLength
            + ", completeArea="
            + this.completeArea
            + ")";
      }
   }
}
