package com.hzchum.scim.mes.building.core.api.pojo._dto.productionAnalysis;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(value = "HysteresisVORequest", description = "围护迟滞返回类")
public class EnclosureHysteresisDTO {
   @ApiModelProperty(name = "dateTime", value = "时间")
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
   @ApiModelProperty(name = "taskLength", notes = "任务长度量")
   @JsonProperty("taskLength")
   @JSONField(name = "taskLength")
   private BigDecimal taskLength;
   @ApiModelProperty(name = "taskArea", notes = "任务面积量")
   @JsonProperty("taskArea")
   @JSONField(name = "taskArea")
   private BigDecimal taskArea;
   @ApiModelProperty(name = "completeLength", notes = "完成长度量")
   @JsonProperty("completeLength")
   @JSONField(name = "completeLength")
   private BigDecimal completeLength;
   @ApiModelProperty(name = "completeArea", notes = "完成面积量")
   @JsonProperty("completeArea")
   @JSONField(name = "completeArea")
   private BigDecimal completeArea;

   public static EnclosureHysteresisDTO.EnclosureHysteresisDTOBuilder builder() {
      return new EnclosureHysteresisDTO.EnclosureHysteresisDTOBuilder();
   }

   public EnclosureHysteresisDTO() {
   }

   public EnclosureHysteresisDTO(
      final String dateTime,
      final LocalDateTime askCompleteTime,
      final Integer taskQuantity,
      final Integer completeQuantity,
      final BigDecimal taskLength,
      final BigDecimal taskArea,
      final BigDecimal completeLength,
      final BigDecimal completeArea
   ) {
      this.dateTime = dateTime;
      this.askCompleteTime = askCompleteTime;
      this.taskQuantity = taskQuantity;
      this.completeQuantity = completeQuantity;
      this.taskLength = taskLength;
      this.taskArea = taskArea;
      this.completeLength = completeLength;
      this.completeArea = completeArea;
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

   public BigDecimal getTaskLength() {
      return this.taskLength;
   }

   public BigDecimal getTaskArea() {
      return this.taskArea;
   }

   public BigDecimal getCompleteLength() {
      return this.completeLength;
   }

   public BigDecimal getCompleteArea() {
      return this.completeArea;
   }

   @JsonProperty("dateTime")
   public EnclosureHysteresisDTO setDateTime(final String dateTime) {
      this.dateTime = dateTime;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public EnclosureHysteresisDTO setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @JsonProperty("taskQuantity")
   public EnclosureHysteresisDTO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   @JsonProperty("completeQuantity")
   public EnclosureHysteresisDTO setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
      return this;
   }

   @JsonProperty("taskLength")
   public EnclosureHysteresisDTO setTaskLength(final BigDecimal taskLength) {
      this.taskLength = taskLength;
      return this;
   }

   @JsonProperty("taskArea")
   public EnclosureHysteresisDTO setTaskArea(final BigDecimal taskArea) {
      this.taskArea = taskArea;
      return this;
   }

   @JsonProperty("completeLength")
   public EnclosureHysteresisDTO setCompleteLength(final BigDecimal completeLength) {
      this.completeLength = completeLength;
      return this;
   }

   @JsonProperty("completeArea")
   public EnclosureHysteresisDTO setCompleteArea(final BigDecimal completeArea) {
      this.completeArea = completeArea;
      return this;
   }

   @Override
   public String toString() {
      return "EnclosureHysteresisDTO(dateTime="
         + this.getDateTime()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", taskLength="
         + this.getTaskLength()
         + ", taskArea="
         + this.getTaskArea()
         + ", completeLength="
         + this.getCompleteLength()
         + ", completeArea="
         + this.getCompleteArea()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureHysteresisDTO)) {
         return false;
      }

      EnclosureHysteresisDTO other = (EnclosureHysteresisDTO)o;
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof EnclosureHysteresisDTO;
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
      Object $taskLength = this.getTaskLength();
      result = result * 59 + ($taskLength == null ? 43 : $taskLength.hashCode());
      Object $taskArea = this.getTaskArea();
      result = result * 59 + ($taskArea == null ? 43 : $taskArea.hashCode());
      Object $completeLength = this.getCompleteLength();
      result = result * 59 + ($completeLength == null ? 43 : $completeLength.hashCode());
      Object $completeArea = this.getCompleteArea();
      return result * 59 + ($completeArea == null ? 43 : $completeArea.hashCode());
   }

   public static class EnclosureHysteresisDTOBuilder {
      private String dateTime;
      private LocalDateTime askCompleteTime;
      private Integer taskQuantity;
      private Integer completeQuantity;
      private BigDecimal taskLength;
      private BigDecimal taskArea;
      private BigDecimal completeLength;
      private BigDecimal completeArea;

      EnclosureHysteresisDTOBuilder() {
      }

      @JsonProperty("dateTime")
      public EnclosureHysteresisDTO.EnclosureHysteresisDTOBuilder dateTime(final String dateTime) {
         this.dateTime = dateTime;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public EnclosureHysteresisDTO.EnclosureHysteresisDTOBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      @JsonProperty("taskQuantity")
      public EnclosureHysteresisDTO.EnclosureHysteresisDTOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      @JsonProperty("completeQuantity")
      public EnclosureHysteresisDTO.EnclosureHysteresisDTOBuilder completeQuantity(final Integer completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      @JsonProperty("taskLength")
      public EnclosureHysteresisDTO.EnclosureHysteresisDTOBuilder taskLength(final BigDecimal taskLength) {
         this.taskLength = taskLength;
         return this;
      }

      @JsonProperty("taskArea")
      public EnclosureHysteresisDTO.EnclosureHysteresisDTOBuilder taskArea(final BigDecimal taskArea) {
         this.taskArea = taskArea;
         return this;
      }

      @JsonProperty("completeLength")
      public EnclosureHysteresisDTO.EnclosureHysteresisDTOBuilder completeLength(final BigDecimal completeLength) {
         this.completeLength = completeLength;
         return this;
      }

      @JsonProperty("completeArea")
      public EnclosureHysteresisDTO.EnclosureHysteresisDTOBuilder completeArea(final BigDecimal completeArea) {
         this.completeArea = completeArea;
         return this;
      }

      public EnclosureHysteresisDTO build() {
         return new EnclosureHysteresisDTO(
            this.dateTime,
            this.askCompleteTime,
            this.taskQuantity,
            this.completeQuantity,
            this.taskLength,
            this.taskArea,
            this.completeLength,
            this.completeArea
         );
      }

      @Override
      public String toString() {
         return "EnclosureHysteresisDTO.EnclosureHysteresisDTOBuilder(dateTime="
            + this.dateTime
            + ", askCompleteTime="
            + this.askCompleteTime
            + ", taskQuantity="
            + this.taskQuantity
            + ", completeQuantity="
            + this.completeQuantity
            + ", taskLength="
            + this.taskLength
            + ", taskArea="
            + this.taskArea
            + ", completeLength="
            + this.completeLength
            + ", completeArea="
            + this.completeArea
            + ")";
      }
   }
}
