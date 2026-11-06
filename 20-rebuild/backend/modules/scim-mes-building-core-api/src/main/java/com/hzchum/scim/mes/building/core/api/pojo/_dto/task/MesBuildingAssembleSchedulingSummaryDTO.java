package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesBuildingSchedulingSummaryDTO", description = "")
public class MesBuildingAssembleSchedulingSummaryDTO {
   @ApiModelProperty(name = "schedulingQuantity", notes = "排产数量")
   @JsonProperty("schedulingQuantity")
   @JSONField(name = "schedulingQuantity")
   private Integer totalSchedulingQuantity;
   @ApiModelProperty(name = "totalSchedulingLength", notes = "排产总长度")
   @JsonProperty("totalSchedulingLength")
   @JSONField(name = "totalSchedulingLength")
   private BigDecimal totalSchedulingLength;
   @ApiModelProperty(name = "taskQuantity", notes = "已下发数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer totalTaskQuantity;
   @ApiModelProperty(name = "totalTaskLength", notes = "已下发总长度")
   @JsonProperty("totalTaskLength")
   @JSONField(name = "totalTaskLength")
   private BigDecimal totalTaskLength;
   @ApiModelProperty(name = "completeQuantity", notes = "已完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer totalCompleteQuantity;
   @ApiModelProperty(name = "totalCompleteLength", notes = "已完成总长度")
   @JsonProperty("totalCompleteLength")
   @JSONField(name = "totalCompleteLength")
   private BigDecimal totalCompleteLength;
   @ApiModelProperty(name = "date", notes = "时间")
   @JsonProperty("date")
   @JSONField(name = "date")
   private String date;

   public static MesBuildingAssembleSchedulingSummaryDTO.MesBuildingAssembleSchedulingSummaryDTOBuilder builder() {
      return new MesBuildingAssembleSchedulingSummaryDTO.MesBuildingAssembleSchedulingSummaryDTOBuilder();
   }

   public MesBuildingAssembleSchedulingSummaryDTO() {
   }

   public MesBuildingAssembleSchedulingSummaryDTO(
      final Integer totalSchedulingQuantity,
      final BigDecimal totalSchedulingLength,
      final Integer totalTaskQuantity,
      final BigDecimal totalTaskLength,
      final Integer totalCompleteQuantity,
      final BigDecimal totalCompleteLength,
      final String date
   ) {
      this.totalSchedulingQuantity = totalSchedulingQuantity;
      this.totalSchedulingLength = totalSchedulingLength;
      this.totalTaskQuantity = totalTaskQuantity;
      this.totalTaskLength = totalTaskLength;
      this.totalCompleteQuantity = totalCompleteQuantity;
      this.totalCompleteLength = totalCompleteLength;
      this.date = date;
   }

   public Integer getTotalSchedulingQuantity() {
      return this.totalSchedulingQuantity;
   }

   public BigDecimal getTotalSchedulingLength() {
      return this.totalSchedulingLength;
   }

   public Integer getTotalTaskQuantity() {
      return this.totalTaskQuantity;
   }

   public BigDecimal getTotalTaskLength() {
      return this.totalTaskLength;
   }

   public Integer getTotalCompleteQuantity() {
      return this.totalCompleteQuantity;
   }

   public BigDecimal getTotalCompleteLength() {
      return this.totalCompleteLength;
   }

   public String getDate() {
      return this.date;
   }

   @JsonProperty("schedulingQuantity")
   public MesBuildingAssembleSchedulingSummaryDTO setTotalSchedulingQuantity(final Integer totalSchedulingQuantity) {
      this.totalSchedulingQuantity = totalSchedulingQuantity;
      return this;
   }

   @JsonProperty("totalSchedulingLength")
   public MesBuildingAssembleSchedulingSummaryDTO setTotalSchedulingLength(final BigDecimal totalSchedulingLength) {
      this.totalSchedulingLength = totalSchedulingLength;
      return this;
   }

   @JsonProperty("taskQuantity")
   public MesBuildingAssembleSchedulingSummaryDTO setTotalTaskQuantity(final Integer totalTaskQuantity) {
      this.totalTaskQuantity = totalTaskQuantity;
      return this;
   }

   @JsonProperty("totalTaskLength")
   public MesBuildingAssembleSchedulingSummaryDTO setTotalTaskLength(final BigDecimal totalTaskLength) {
      this.totalTaskLength = totalTaskLength;
      return this;
   }

   @JsonProperty("completeQuantity")
   public MesBuildingAssembleSchedulingSummaryDTO setTotalCompleteQuantity(final Integer totalCompleteQuantity) {
      this.totalCompleteQuantity = totalCompleteQuantity;
      return this;
   }

   @JsonProperty("totalCompleteLength")
   public MesBuildingAssembleSchedulingSummaryDTO setTotalCompleteLength(final BigDecimal totalCompleteLength) {
      this.totalCompleteLength = totalCompleteLength;
      return this;
   }

   @JsonProperty("date")
   public MesBuildingAssembleSchedulingSummaryDTO setDate(final String date) {
      this.date = date;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAssembleSchedulingSummaryDTO)) {
         return false;
      }

      MesBuildingAssembleSchedulingSummaryDTO other = (MesBuildingAssembleSchedulingSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$totalSchedulingQuantity = this.getTotalSchedulingQuantity();
      Object other$totalSchedulingQuantity = other.getTotalSchedulingQuantity();
      if (this$totalSchedulingQuantity == null ? other$totalSchedulingQuantity == null : this$totalSchedulingQuantity.equals(other$totalSchedulingQuantity)) {
         Object this$totalTaskQuantity = this.getTotalTaskQuantity();
         Object other$totalTaskQuantity = other.getTotalTaskQuantity();
         if (this$totalTaskQuantity == null ? other$totalTaskQuantity == null : this$totalTaskQuantity.equals(other$totalTaskQuantity)) {
            Object this$totalCompleteQuantity = this.getTotalCompleteQuantity();
            Object other$totalCompleteQuantity = other.getTotalCompleteQuantity();
            if (this$totalCompleteQuantity == null ? other$totalCompleteQuantity == null : this$totalCompleteQuantity.equals(other$totalCompleteQuantity)) {
               Object this$totalSchedulingLength = this.getTotalSchedulingLength();
               Object other$totalSchedulingLength = other.getTotalSchedulingLength();
               if (this$totalSchedulingLength == null ? other$totalSchedulingLength == null : this$totalSchedulingLength.equals(other$totalSchedulingLength)) {
                  Object this$totalTaskLength = this.getTotalTaskLength();
                  Object other$totalTaskLength = other.getTotalTaskLength();
                  if (this$totalTaskLength == null ? other$totalTaskLength == null : this$totalTaskLength.equals(other$totalTaskLength)) {
                     Object this$totalCompleteLength = this.getTotalCompleteLength();
                     Object other$totalCompleteLength = other.getTotalCompleteLength();
                     if (this$totalCompleteLength == null ? other$totalCompleteLength == null : this$totalCompleteLength.equals(other$totalCompleteLength)) {
                        Object this$date = this.getDate();
                        Object other$date = other.getDate();
                        return this$date == null ? other$date == null : this$date.equals(other$date);
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
      return other instanceof MesBuildingAssembleSchedulingSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $totalSchedulingQuantity = this.getTotalSchedulingQuantity();
      result = result * 59 + ($totalSchedulingQuantity == null ? 43 : $totalSchedulingQuantity.hashCode());
      Object $totalTaskQuantity = this.getTotalTaskQuantity();
      result = result * 59 + ($totalTaskQuantity == null ? 43 : $totalTaskQuantity.hashCode());
      Object $totalCompleteQuantity = this.getTotalCompleteQuantity();
      result = result * 59 + ($totalCompleteQuantity == null ? 43 : $totalCompleteQuantity.hashCode());
      Object $totalSchedulingLength = this.getTotalSchedulingLength();
      result = result * 59 + ($totalSchedulingLength == null ? 43 : $totalSchedulingLength.hashCode());
      Object $totalTaskLength = this.getTotalTaskLength();
      result = result * 59 + ($totalTaskLength == null ? 43 : $totalTaskLength.hashCode());
      Object $totalCompleteLength = this.getTotalCompleteLength();
      result = result * 59 + ($totalCompleteLength == null ? 43 : $totalCompleteLength.hashCode());
      Object $date = this.getDate();
      return result * 59 + ($date == null ? 43 : $date.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingAssembleSchedulingSummaryDTO(totalSchedulingQuantity="
         + this.getTotalSchedulingQuantity()
         + ", totalSchedulingLength="
         + this.getTotalSchedulingLength()
         + ", totalTaskQuantity="
         + this.getTotalTaskQuantity()
         + ", totalTaskLength="
         + this.getTotalTaskLength()
         + ", totalCompleteQuantity="
         + this.getTotalCompleteQuantity()
         + ", totalCompleteLength="
         + this.getTotalCompleteLength()
         + ", date="
         + this.getDate()
         + ")";
   }

   public static class MesBuildingAssembleSchedulingSummaryDTOBuilder {
      private Integer totalSchedulingQuantity;
      private BigDecimal totalSchedulingLength;
      private Integer totalTaskQuantity;
      private BigDecimal totalTaskLength;
      private Integer totalCompleteQuantity;
      private BigDecimal totalCompleteLength;
      private String date;

      MesBuildingAssembleSchedulingSummaryDTOBuilder() {
      }

      @JsonProperty("schedulingQuantity")
      public MesBuildingAssembleSchedulingSummaryDTO.MesBuildingAssembleSchedulingSummaryDTOBuilder totalSchedulingQuantity(
         final Integer totalSchedulingQuantity
      ) {
         this.totalSchedulingQuantity = totalSchedulingQuantity;
         return this;
      }

      @JsonProperty("totalSchedulingLength")
      public MesBuildingAssembleSchedulingSummaryDTO.MesBuildingAssembleSchedulingSummaryDTOBuilder totalSchedulingLength(
         final BigDecimal totalSchedulingLength
      ) {
         this.totalSchedulingLength = totalSchedulingLength;
         return this;
      }

      @JsonProperty("taskQuantity")
      public MesBuildingAssembleSchedulingSummaryDTO.MesBuildingAssembleSchedulingSummaryDTOBuilder totalTaskQuantity(final Integer totalTaskQuantity) {
         this.totalTaskQuantity = totalTaskQuantity;
         return this;
      }

      @JsonProperty("totalTaskLength")
      public MesBuildingAssembleSchedulingSummaryDTO.MesBuildingAssembleSchedulingSummaryDTOBuilder totalTaskLength(final BigDecimal totalTaskLength) {
         this.totalTaskLength = totalTaskLength;
         return this;
      }

      @JsonProperty("completeQuantity")
      public MesBuildingAssembleSchedulingSummaryDTO.MesBuildingAssembleSchedulingSummaryDTOBuilder totalCompleteQuantity(final Integer totalCompleteQuantity) {
         this.totalCompleteQuantity = totalCompleteQuantity;
         return this;
      }

      @JsonProperty("totalCompleteLength")
      public MesBuildingAssembleSchedulingSummaryDTO.MesBuildingAssembleSchedulingSummaryDTOBuilder totalCompleteLength(final BigDecimal totalCompleteLength) {
         this.totalCompleteLength = totalCompleteLength;
         return this;
      }

      @JsonProperty("date")
      public MesBuildingAssembleSchedulingSummaryDTO.MesBuildingAssembleSchedulingSummaryDTOBuilder date(final String date) {
         this.date = date;
         return this;
      }

      public MesBuildingAssembleSchedulingSummaryDTO build() {
         return new MesBuildingAssembleSchedulingSummaryDTO(
            this.totalSchedulingQuantity,
            this.totalSchedulingLength,
            this.totalTaskQuantity,
            this.totalTaskLength,
            this.totalCompleteQuantity,
            this.totalCompleteLength,
            this.date
         );
      }

      @Override
      public String toString() {
         return "MesBuildingAssembleSchedulingSummaryDTO.MesBuildingAssembleSchedulingSummaryDTOBuilder(totalSchedulingQuantity="
            + this.totalSchedulingQuantity
            + ", totalSchedulingLength="
            + this.totalSchedulingLength
            + ", totalTaskQuantity="
            + this.totalTaskQuantity
            + ", totalTaskLength="
            + this.totalTaskLength
            + ", totalCompleteQuantity="
            + this.totalCompleteQuantity
            + ", totalCompleteLength="
            + this.totalCompleteLength
            + ", date="
            + this.date
            + ")";
      }
   }
}
