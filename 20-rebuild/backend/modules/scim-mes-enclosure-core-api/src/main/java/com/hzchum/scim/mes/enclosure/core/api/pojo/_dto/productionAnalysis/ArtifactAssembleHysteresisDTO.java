package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.productionAnalysis;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "HysteresisVORequest", description = "构件组立迟滞返回类")
public class ArtifactAssembleHysteresisDTO {
   @ApiModelProperty(name = "dateTime", value = "日期")
   @JsonProperty("dateTime")
   @JSONField(name = "dateTime")
   private String dateTime;
   @ApiModelProperty(name = "askCompleteTime", value = "时间")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;
   @ApiModelProperty(name = "taskQuantity", notes = "任务数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer taskQuantity;
   @ApiModelProperty(name = "completeQuantity", notes = "完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer completeQuantity;
   @ApiModelProperty(name = "taskNetWeight", notes = "任务净重量")
   @JsonProperty("taskNetWeight")
   @JSONField(name = "taskNetWeight")
   private BigDecimal taskNetWeight;
   @ApiModelProperty(name = "taskGrossWeight", notes = "任务毛重量")
   @JsonProperty("taskGrossWeight")
   @JSONField(name = "taskGrossWeight")
   private BigDecimal taskGrossWeight;
   @ApiModelProperty(name = "completeNetWeight", notes = "完成净重量")
   @JsonProperty("completeNetWeight")
   @JSONField(name = "completeNetWeight")
   private BigDecimal completeNetWeight;
   @ApiModelProperty(name = "completeGrossWeight", notes = "完成毛重量")
   @JsonProperty("completeGrossWeight")
   @JSONField(name = "completeGrossWeight")
   private BigDecimal completeGrossWeight;
   @ApiModelProperty(name = "taskLength", notes = "任务长度量")
   @JsonProperty("taskLength")
   @JSONField(name = "taskLength")
   private BigDecimal taskLength;
   @ApiModelProperty(name = "completeLength", notes = "完成长度量")
   @JsonProperty("completeLength")
   @JSONField(name = "completeLength")
   private BigDecimal completeLength;

   public static ArtifactAssembleHysteresisDTO.ArtifactAssembleHysteresisDTOBuilder builder() {
      return new ArtifactAssembleHysteresisDTO.ArtifactAssembleHysteresisDTOBuilder();
   }

   public ArtifactAssembleHysteresisDTO() {
   }

   public ArtifactAssembleHysteresisDTO(
      final String dateTime,
      final LocalDateTime askCompleteTime,
      final Integer taskQuantity,
      final Integer completeQuantity,
      final BigDecimal taskNetWeight,
      final BigDecimal taskGrossWeight,
      final BigDecimal completeNetWeight,
      final BigDecimal completeGrossWeight,
      final BigDecimal taskLength,
      final BigDecimal completeLength
   ) {
      this.dateTime = dateTime;
      this.askCompleteTime = askCompleteTime;
      this.taskQuantity = taskQuantity;
      this.completeQuantity = completeQuantity;
      this.taskNetWeight = taskNetWeight;
      this.taskGrossWeight = taskGrossWeight;
      this.completeNetWeight = completeNetWeight;
      this.completeGrossWeight = completeGrossWeight;
      this.taskLength = taskLength;
      this.completeLength = completeLength;
   }

   public String getDateTime() {
      return this.dateTime;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public BigDecimal getTaskNetWeight() {
      return this.taskNetWeight;
   }

   public BigDecimal getTaskGrossWeight() {
      return this.taskGrossWeight;
   }

   public BigDecimal getCompleteNetWeight() {
      return this.completeNetWeight;
   }

   public BigDecimal getCompleteGrossWeight() {
      return this.completeGrossWeight;
   }

   public BigDecimal getTaskLength() {
      return this.taskLength;
   }

   public BigDecimal getCompleteLength() {
      return this.completeLength;
   }

   @JsonProperty("dateTime")
   public ArtifactAssembleHysteresisDTO setDateTime(final String dateTime) {
      this.dateTime = dateTime;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public ArtifactAssembleHysteresisDTO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("taskQuantity")
   public ArtifactAssembleHysteresisDTO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("completeQuantity")
   public ArtifactAssembleHysteresisDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("taskNetWeight")
   public ArtifactAssembleHysteresisDTO setTaskNetWeight(final BigDecimal taskNetWeight) {
      this.taskNetWeight = taskNetWeight;
      return this;
   }

   @JsonProperty("taskGrossWeight")
   public ArtifactAssembleHysteresisDTO setTaskGrossWeight(final BigDecimal taskGrossWeight) {
      this.taskGrossWeight = taskGrossWeight;
      return this;
   }

   @JsonProperty("completeNetWeight")
   public ArtifactAssembleHysteresisDTO setCompleteNetWeight(final BigDecimal completeNetWeight) {
      this.completeNetWeight = completeNetWeight;
      return this;
   }

   @JsonProperty("completeGrossWeight")
   public ArtifactAssembleHysteresisDTO setCompleteGrossWeight(final BigDecimal completeGrossWeight) {
      this.completeGrossWeight = completeGrossWeight;
      return this;
   }

   @JsonProperty("taskLength")
   public ArtifactAssembleHysteresisDTO setTaskLength(final BigDecimal taskLength) {
      this.taskLength = taskLength;
      return this;
   }

   @JsonProperty("completeLength")
   public ArtifactAssembleHysteresisDTO setCompleteLength(final BigDecimal completeLength) {
      this.completeLength = completeLength;
      return this;
   }

   @Override
   public String toString() {
      return "ArtifactAssembleHysteresisDTO(dateTime="
         + this.getDateTime()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", taskNetWeight="
         + this.getTaskNetWeight()
         + ", taskGrossWeight="
         + this.getTaskGrossWeight()
         + ", completeNetWeight="
         + this.getCompleteNetWeight()
         + ", completeGrossWeight="
         + this.getCompleteGrossWeight()
         + ", taskLength="
         + this.getTaskLength()
         + ", completeLength="
         + this.getCompleteLength()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactAssembleHysteresisDTO)) {
         return false;
      }

      ArtifactAssembleHysteresisDTO other = (ArtifactAssembleHysteresisDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskQuantity = this.getTaskQuantity();
      Object other$taskQuantity = other.getTaskQuantity();
      if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
         Object this$completeQuantity = this.getCompleteQuantity();
         Object other$completeQuantity = other.getCompleteQuantity();
         if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
            Object this$dateTime = this.getDateTime();
            Object other$dateTime = other.getDateTime();
            if (this$dateTime == null ? other$dateTime == null : this$dateTime.equals(other$dateTime)) {
               Object this$askCompleteTime = this.getAskCompleteTime();
               Object other$askCompleteTime = other.getAskCompleteTime();
               if (this$askCompleteTime == null ? other$askCompleteTime == null : this$askCompleteTime.equals(other$askCompleteTime)) {
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
                              Object this$taskLength = this.getTaskLength();
                              Object other$taskLength = other.getTaskLength();
                              if (this$taskLength == null ? other$taskLength == null : this$taskLength.equals(other$taskLength)) {
                                 Object this$completeLength = this.getCompleteLength();
                                 Object other$completeLength = other.getCompleteLength();
                                 return this$completeLength == null ? other$completeLength == null : this$completeLength.equals(other$completeLength);
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
      return other instanceof ArtifactAssembleHysteresisDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $dateTime = this.getDateTime();
      result = result * 59 + ($dateTime == null ? 43 : $dateTime.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $taskNetWeight = this.getTaskNetWeight();
      result = result * 59 + ($taskNetWeight == null ? 43 : $taskNetWeight.hashCode());
      Object $taskGrossWeight = this.getTaskGrossWeight();
      result = result * 59 + ($taskGrossWeight == null ? 43 : $taskGrossWeight.hashCode());
      Object $completeNetWeight = this.getCompleteNetWeight();
      result = result * 59 + ($completeNetWeight == null ? 43 : $completeNetWeight.hashCode());
      Object $completeGrossWeight = this.getCompleteGrossWeight();
      result = result * 59 + ($completeGrossWeight == null ? 43 : $completeGrossWeight.hashCode());
      Object $taskLength = this.getTaskLength();
      result = result * 59 + ($taskLength == null ? 43 : $taskLength.hashCode());
      Object $completeLength = this.getCompleteLength();
      return result * 59 + ($completeLength == null ? 43 : $completeLength.hashCode());
   }

   public static class ArtifactAssembleHysteresisDTOBuilder {
      private String dateTime;
      private LocalDateTime askCompleteTime;
      private Integer taskQuantity;
      private Integer completeQuantity;
      private BigDecimal taskNetWeight;
      private BigDecimal taskGrossWeight;
      private BigDecimal completeNetWeight;
      private BigDecimal completeGrossWeight;
      private BigDecimal taskLength;
      private BigDecimal completeLength;

      ArtifactAssembleHysteresisDTOBuilder() {
      }

      @JsonProperty("dateTime")
      public ArtifactAssembleHysteresisDTO.ArtifactAssembleHysteresisDTOBuilder dateTime(final String dateTime) {
         this.dateTime = dateTime;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public ArtifactAssembleHysteresisDTO.ArtifactAssembleHysteresisDTOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("taskQuantity")
      public ArtifactAssembleHysteresisDTO.ArtifactAssembleHysteresisDTOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("completeQuantity")
      public ArtifactAssembleHysteresisDTO.ArtifactAssembleHysteresisDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("taskNetWeight")
      public ArtifactAssembleHysteresisDTO.ArtifactAssembleHysteresisDTOBuilder taskNetWeight(final BigDecimal taskNetWeight) {
         this.taskNetWeight = taskNetWeight;
         return this;
      }

      @JsonProperty("taskGrossWeight")
      public ArtifactAssembleHysteresisDTO.ArtifactAssembleHysteresisDTOBuilder taskGrossWeight(final BigDecimal taskGrossWeight) {
         this.taskGrossWeight = taskGrossWeight;
         return this;
      }

      @JsonProperty("completeNetWeight")
      public ArtifactAssembleHysteresisDTO.ArtifactAssembleHysteresisDTOBuilder completeNetWeight(final BigDecimal completeNetWeight) {
         this.completeNetWeight = completeNetWeight;
         return this;
      }

      @JsonProperty("completeGrossWeight")
      public ArtifactAssembleHysteresisDTO.ArtifactAssembleHysteresisDTOBuilder completeGrossWeight(final BigDecimal completeGrossWeight) {
         this.completeGrossWeight = completeGrossWeight;
         return this;
      }

      @JsonProperty("taskLength")
      public ArtifactAssembleHysteresisDTO.ArtifactAssembleHysteresisDTOBuilder taskLength(final BigDecimal taskLength) {
         this.taskLength = taskLength;
         return this;
      }

      @JsonProperty("completeLength")
      public ArtifactAssembleHysteresisDTO.ArtifactAssembleHysteresisDTOBuilder completeLength(final BigDecimal completeLength) {
         this.completeLength = completeLength;
         return this;
      }

      public ArtifactAssembleHysteresisDTO build() {
         return new ArtifactAssembleHysteresisDTO(
            this.dateTime,
            this.askCompleteTime,
            this.taskQuantity,
            this.completeQuantity,
            this.taskNetWeight,
            this.taskGrossWeight,
            this.completeNetWeight,
            this.completeGrossWeight,
            this.taskLength,
            this.completeLength
         );
      }

      @Override
      public String toString() {
         return "ArtifactAssembleHysteresisDTO.ArtifactAssembleHysteresisDTOBuilder(dateTime="
            + this.dateTime
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", taskQuantity="
            + this.taskQuantity
            + ", completeQuantity="
            + this.completeQuantity
            + ", taskNetWeight="
            + this.taskNetWeight
            + ", taskGrossWeight="
            + this.taskGrossWeight
            + ", completeNetWeight="
            + this.completeNetWeight
            + ", completeGrossWeight="
            + this.completeGrossWeight
            + ", taskLength="
            + this.taskLength
            + ", completeLength="
            + this.completeLength
            + ")";
      }
   }
}
