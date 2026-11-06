package com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "车间")
public class WorkshopProduceInfoDTO {
   @ApiModelProperty(name = "workshopName", value = "车间名称")
   @JsonProperty("workshopName")
   @JSONField(name = "workshopName")
   private String workshopName;
   @ApiModelProperty(name = "totalWeight", value = "总重")
   @JsonProperty("totalWeight")
   @JSONField(name = "totalWeight")
   private BigDecimal totalWeight;
   @ApiModelProperty(name = "todayWeight", value = "今日产量")
   @JsonProperty("todayWeight")
   @JSONField(name = "todayWeight")
   private BigDecimal todayWeight;
   @ApiModelProperty(name = "currentMonthWeight", value = "当前月重量")
   @JsonProperty("currentMonthWeight")
   @JSONField(name = "currentMonthWeight")
   private BigDecimal currentMonthWeight;
   @ApiModelProperty(name = "currentYearWeight", value = "当前年重量")
   @JsonProperty("currentYearWeight")
   @JSONField(name = "currentYearWeight")
   private BigDecimal currentYearWeight;

   public static WorkshopProduceInfoDTO.WorkshopProduceInfoDTOBuilder builder() {
      return new WorkshopProduceInfoDTO.WorkshopProduceInfoDTOBuilder();
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public BigDecimal getTodayWeight() {
      return this.todayWeight;
   }

   public BigDecimal getCurrentMonthWeight() {
      return this.currentMonthWeight;
   }

   public BigDecimal getCurrentYearWeight() {
      return this.currentYearWeight;
   }

   @JsonProperty("workshopName")
   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   @JsonProperty("totalWeight")
   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   @JsonProperty("todayWeight")
   public void setTodayWeight(final BigDecimal todayWeight) {
      this.todayWeight = todayWeight;
   }

   @JsonProperty("currentMonthWeight")
   public void setCurrentMonthWeight(final BigDecimal currentMonthWeight) {
      this.currentMonthWeight = currentMonthWeight;
   }

   @JsonProperty("currentYearWeight")
   public void setCurrentYearWeight(final BigDecimal currentYearWeight) {
      this.currentYearWeight = currentYearWeight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WorkshopProduceInfoDTO)) {
         return false;
      }

      WorkshopProduceInfoDTO other = (WorkshopProduceInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workshopName = this.getWorkshopName();
      Object other$workshopName = other.getWorkshopName();
      if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
         Object this$totalWeight = this.getTotalWeight();
         Object other$totalWeight = other.getTotalWeight();
         if (this$totalWeight == null ? other$totalWeight == null : this$totalWeight.equals(other$totalWeight)) {
            Object this$todayWeight = this.getTodayWeight();
            Object other$todayWeight = other.getTodayWeight();
            if (this$todayWeight == null ? other$todayWeight == null : this$todayWeight.equals(other$todayWeight)) {
               Object this$currentMonthWeight = this.getCurrentMonthWeight();
               Object other$currentMonthWeight = other.getCurrentMonthWeight();
               if (this$currentMonthWeight == null ? other$currentMonthWeight == null : this$currentMonthWeight.equals(other$currentMonthWeight)) {
                  Object this$currentYearWeight = this.getCurrentYearWeight();
                  Object other$currentYearWeight = other.getCurrentYearWeight();
                  return this$currentYearWeight == null ? other$currentYearWeight == null : this$currentYearWeight.equals(other$currentYearWeight);
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
      return other instanceof WorkshopProduceInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $todayWeight = this.getTodayWeight();
      result = result * 59 + ($todayWeight == null ? 43 : $todayWeight.hashCode());
      Object $currentMonthWeight = this.getCurrentMonthWeight();
      result = result * 59 + ($currentMonthWeight == null ? 43 : $currentMonthWeight.hashCode());
      Object $currentYearWeight = this.getCurrentYearWeight();
      return result * 59 + ($currentYearWeight == null ? 43 : $currentYearWeight.hashCode());
   }

   @Override
   public String toString() {
      return "WorkshopProduceInfoDTO(super="
         + super.toString()
         + ", workshopName="
         + this.getWorkshopName()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", todayWeight="
         + this.getTodayWeight()
         + ", currentMonthWeight="
         + this.getCurrentMonthWeight()
         + ", currentYearWeight="
         + this.getCurrentYearWeight()
         + ")";
   }

   public WorkshopProduceInfoDTO(
      final String workshopName,
      final BigDecimal totalWeight,
      final BigDecimal todayWeight,
      final BigDecimal currentMonthWeight,
      final BigDecimal currentYearWeight
   ) {
      this.workshopName = workshopName;
      this.totalWeight = totalWeight;
      this.todayWeight = todayWeight;
      this.currentMonthWeight = currentMonthWeight;
      this.currentYearWeight = currentYearWeight;
   }

   public WorkshopProduceInfoDTO() {
   }

   public static class WorkshopProduceInfoDTOBuilder {
      private String workshopName;
      private BigDecimal totalWeight;
      private BigDecimal todayWeight;
      private BigDecimal currentMonthWeight;
      private BigDecimal currentYearWeight;

      WorkshopProduceInfoDTOBuilder() {
      }

      @JsonProperty("workshopName")
      public WorkshopProduceInfoDTO.WorkshopProduceInfoDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      @JsonProperty("totalWeight")
      public WorkshopProduceInfoDTO.WorkshopProduceInfoDTOBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      @JsonProperty("todayWeight")
      public WorkshopProduceInfoDTO.WorkshopProduceInfoDTOBuilder todayWeight(final BigDecimal todayWeight) {
         this.todayWeight = todayWeight;
         return this;
      }

      @JsonProperty("currentMonthWeight")
      public WorkshopProduceInfoDTO.WorkshopProduceInfoDTOBuilder currentMonthWeight(final BigDecimal currentMonthWeight) {
         this.currentMonthWeight = currentMonthWeight;
         return this;
      }

      @JsonProperty("currentYearWeight")
      public WorkshopProduceInfoDTO.WorkshopProduceInfoDTOBuilder currentYearWeight(final BigDecimal currentYearWeight) {
         this.currentYearWeight = currentYearWeight;
         return this;
      }

      public WorkshopProduceInfoDTO build() {
         return new WorkshopProduceInfoDTO(this.workshopName, this.totalWeight, this.todayWeight, this.currentMonthWeight, this.currentYearWeight);
      }

      @Override
      public String toString() {
         return "WorkshopProduceInfoDTO.WorkshopProduceInfoDTOBuilder(workshopName="
            + this.workshopName
            + ", totalWeight="
            + this.totalWeight
            + ", todayWeight="
            + this.todayWeight
            + ", currentMonthWeight="
            + this.currentMonthWeight
            + ", currentYearWeight="
            + this.currentYearWeight
            + ")";
      }
   }
}
