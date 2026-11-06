package com.hzchum.scim.mes.building.core.api.pojo._do.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesBuildingEnclosureSchedulingSummaryDO", description = "")
public class MesBuildingEnclosureSchedulingSummaryDO {
   @ApiModelProperty(name = "schedulingQuantity", notes = "排产数量")
   @JsonProperty("schedulingQuantity")
   @JSONField(name = "schedulingQuantity")
   private Integer totalSchedulingQuantity;
   @ApiModelProperty(name = "totalSchedulingLength", notes = "排产总长度")
   @JsonProperty("totalSchedulingLength")
   @JSONField(name = "totalSchedulingLength")
   private BigDecimal totalSchedulingLength;
   @ApiModelProperty(name = "totalSchedulingArea", notes = "排产总面积")
   @JsonProperty("totalSchedulingArea")
   @JSONField(name = "totalSchedulingArea")
   private BigDecimal totalSchedulingArea;
   @ApiModelProperty(name = "taskQuantity", notes = "已下发数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer totalTaskQuantity;
   @ApiModelProperty(name = "totalTaskLength", notes = "已下发总长度")
   @JsonProperty("totalTaskLength")
   @JSONField(name = "totalTaskLength")
   private BigDecimal totalTaskLength;
   @ApiModelProperty(name = "totalTaskArea", notes = "已下发总面积")
   @JsonProperty("totalTaskArea")
   @JSONField(name = "totalTaskArea")
   private BigDecimal totalTaskArea;
   @ApiModelProperty(name = "completeQuantity", notes = "已完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer totalCompleteQuantity;
   @ApiModelProperty(name = "totalCompleteLength", notes = "已完成总长度")
   @JsonProperty("totalCompleteLength")
   @JSONField(name = "totalCompleteLength")
   private BigDecimal totalCompleteLength;
   @ApiModelProperty(name = "totalCompleteArea", notes = "已完成总面积")
   @JsonProperty("totalCompleteArea")
   @JSONField(name = "totalCompleteArea")
   private BigDecimal totalCompleteArea;
   @ApiModelProperty(name = "date", notes = "时间")
   @JsonProperty("date")
   @JSONField(name = "date")
   private String date;

   public static MesBuildingEnclosureSchedulingSummaryDO.MesBuildingEnclosureSchedulingSummaryDOBuilder builder() {
      return new MesBuildingEnclosureSchedulingSummaryDO.MesBuildingEnclosureSchedulingSummaryDOBuilder();
   }

   public MesBuildingEnclosureSchedulingSummaryDO() {
   }

   public MesBuildingEnclosureSchedulingSummaryDO(
      final Integer totalSchedulingQuantity,
      final BigDecimal totalSchedulingLength,
      final BigDecimal totalSchedulingArea,
      final Integer totalTaskQuantity,
      final BigDecimal totalTaskLength,
      final BigDecimal totalTaskArea,
      final Integer totalCompleteQuantity,
      final BigDecimal totalCompleteLength,
      final BigDecimal totalCompleteArea,
      final String date
   ) {
      this.totalSchedulingQuantity = totalSchedulingQuantity;
      this.totalSchedulingLength = totalSchedulingLength;
      this.totalSchedulingArea = totalSchedulingArea;
      this.totalTaskQuantity = totalTaskQuantity;
      this.totalTaskLength = totalTaskLength;
      this.totalTaskArea = totalTaskArea;
      this.totalCompleteQuantity = totalCompleteQuantity;
      this.totalCompleteLength = totalCompleteLength;
      this.totalCompleteArea = totalCompleteArea;
      this.date = date;
   }

   public Integer getTotalSchedulingQuantity() {
      return this.totalSchedulingQuantity;
   }

   public BigDecimal getTotalSchedulingLength() {
      return this.totalSchedulingLength;
   }

   public BigDecimal getTotalSchedulingArea() {
      return this.totalSchedulingArea;
   }

   public Integer getTotalTaskQuantity() {
      return this.totalTaskQuantity;
   }

   public BigDecimal getTotalTaskLength() {
      return this.totalTaskLength;
   }

   public BigDecimal getTotalTaskArea() {
      return this.totalTaskArea;
   }

   public Integer getTotalCompleteQuantity() {
      return this.totalCompleteQuantity;
   }

   public BigDecimal getTotalCompleteLength() {
      return this.totalCompleteLength;
   }

   public BigDecimal getTotalCompleteArea() {
      return this.totalCompleteArea;
   }

   public String getDate() {
      return this.date;
   }

   @JsonProperty("schedulingQuantity")
   public MesBuildingEnclosureSchedulingSummaryDO setTotalSchedulingQuantity(final Integer totalSchedulingQuantity) {
      this.totalSchedulingQuantity = totalSchedulingQuantity;
      return this;
   }

   @JsonProperty("totalSchedulingLength")
   public MesBuildingEnclosureSchedulingSummaryDO setTotalSchedulingLength(final BigDecimal totalSchedulingLength) {
      this.totalSchedulingLength = totalSchedulingLength;
      return this;
   }

   @JsonProperty("totalSchedulingArea")
   public MesBuildingEnclosureSchedulingSummaryDO setTotalSchedulingArea(final BigDecimal totalSchedulingArea) {
      this.totalSchedulingArea = totalSchedulingArea;
      return this;
   }

   @JsonProperty("taskQuantity")
   public MesBuildingEnclosureSchedulingSummaryDO setTotalTaskQuantity(final Integer totalTaskQuantity) {
      this.totalTaskQuantity = totalTaskQuantity;
      return this;
   }

   @JsonProperty("totalTaskLength")
   public MesBuildingEnclosureSchedulingSummaryDO setTotalTaskLength(final BigDecimal totalTaskLength) {
      this.totalTaskLength = totalTaskLength;
      return this;
   }

   @JsonProperty("totalTaskArea")
   public MesBuildingEnclosureSchedulingSummaryDO setTotalTaskArea(final BigDecimal totalTaskArea) {
      this.totalTaskArea = totalTaskArea;
      return this;
   }

   @JsonProperty("completeQuantity")
   public MesBuildingEnclosureSchedulingSummaryDO setTotalCompleteQuantity(final Integer totalCompleteQuantity) {
      this.totalCompleteQuantity = totalCompleteQuantity;
      return this;
   }

   @JsonProperty("totalCompleteLength")
   public MesBuildingEnclosureSchedulingSummaryDO setTotalCompleteLength(final BigDecimal totalCompleteLength) {
      this.totalCompleteLength = totalCompleteLength;
      return this;
   }

   @JsonProperty("totalCompleteArea")
   public MesBuildingEnclosureSchedulingSummaryDO setTotalCompleteArea(final BigDecimal totalCompleteArea) {
      this.totalCompleteArea = totalCompleteArea;
      return this;
   }

   @JsonProperty("date")
   public MesBuildingEnclosureSchedulingSummaryDO setDate(final String date) {
      this.date = date;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingEnclosureSchedulingSummaryDO)) {
         return false;
      }

      MesBuildingEnclosureSchedulingSummaryDO other = (MesBuildingEnclosureSchedulingSummaryDO)o;
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
                  Object this$totalSchedulingArea = this.getTotalSchedulingArea();
                  Object other$totalSchedulingArea = other.getTotalSchedulingArea();
                  if (this$totalSchedulingArea == null ? other$totalSchedulingArea == null : this$totalSchedulingArea.equals(other$totalSchedulingArea)) {
                     Object this$totalTaskLength = this.getTotalTaskLength();
                     Object other$totalTaskLength = other.getTotalTaskLength();
                     if (this$totalTaskLength == null ? other$totalTaskLength == null : this$totalTaskLength.equals(other$totalTaskLength)) {
                        Object this$totalTaskArea = this.getTotalTaskArea();
                        Object other$totalTaskArea = other.getTotalTaskArea();
                        if (this$totalTaskArea == null ? other$totalTaskArea == null : this$totalTaskArea.equals(other$totalTaskArea)) {
                           Object this$totalCompleteLength = this.getTotalCompleteLength();
                           Object other$totalCompleteLength = other.getTotalCompleteLength();
                           if (this$totalCompleteLength == null
                              ? other$totalCompleteLength == null
                              : this$totalCompleteLength.equals(other$totalCompleteLength)) {
                              Object this$totalCompleteArea = this.getTotalCompleteArea();
                              Object other$totalCompleteArea = other.getTotalCompleteArea();
                              if (this$totalCompleteArea == null ? other$totalCompleteArea == null : this$totalCompleteArea.equals(other$totalCompleteArea)) {
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
      return other instanceof MesBuildingEnclosureSchedulingSummaryDO;
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
      Object $totalSchedulingArea = this.getTotalSchedulingArea();
      result = result * 59 + ($totalSchedulingArea == null ? 43 : $totalSchedulingArea.hashCode());
      Object $totalTaskLength = this.getTotalTaskLength();
      result = result * 59 + ($totalTaskLength == null ? 43 : $totalTaskLength.hashCode());
      Object $totalTaskArea = this.getTotalTaskArea();
      result = result * 59 + ($totalTaskArea == null ? 43 : $totalTaskArea.hashCode());
      Object $totalCompleteLength = this.getTotalCompleteLength();
      result = result * 59 + ($totalCompleteLength == null ? 43 : $totalCompleteLength.hashCode());
      Object $totalCompleteArea = this.getTotalCompleteArea();
      result = result * 59 + ($totalCompleteArea == null ? 43 : $totalCompleteArea.hashCode());
      Object $date = this.getDate();
      return result * 59 + ($date == null ? 43 : $date.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingEnclosureSchedulingSummaryDO(totalSchedulingQuantity="
         + this.getTotalSchedulingQuantity()
         + ", totalSchedulingLength="
         + this.getTotalSchedulingLength()
         + ", totalSchedulingArea="
         + this.getTotalSchedulingArea()
         + ", totalTaskQuantity="
         + this.getTotalTaskQuantity()
         + ", totalTaskLength="
         + this.getTotalTaskLength()
         + ", totalTaskArea="
         + this.getTotalTaskArea()
         + ", totalCompleteQuantity="
         + this.getTotalCompleteQuantity()
         + ", totalCompleteLength="
         + this.getTotalCompleteLength()
         + ", totalCompleteArea="
         + this.getTotalCompleteArea()
         + ", date="
         + this.getDate()
         + ")";
   }

   public static class MesBuildingEnclosureSchedulingSummaryDOBuilder {
      private Integer totalSchedulingQuantity;
      private BigDecimal totalSchedulingLength;
      private BigDecimal totalSchedulingArea;
      private Integer totalTaskQuantity;
      private BigDecimal totalTaskLength;
      private BigDecimal totalTaskArea;
      private Integer totalCompleteQuantity;
      private BigDecimal totalCompleteLength;
      private BigDecimal totalCompleteArea;
      private String date;

      MesBuildingEnclosureSchedulingSummaryDOBuilder() {
      }

      @JsonProperty("schedulingQuantity")
      public MesBuildingEnclosureSchedulingSummaryDO.MesBuildingEnclosureSchedulingSummaryDOBuilder totalSchedulingQuantity(
         final Integer totalSchedulingQuantity
      ) {
         this.totalSchedulingQuantity = totalSchedulingQuantity;
         return this;
      }

      @JsonProperty("totalSchedulingLength")
      public MesBuildingEnclosureSchedulingSummaryDO.MesBuildingEnclosureSchedulingSummaryDOBuilder totalSchedulingLength(
         final BigDecimal totalSchedulingLength
      ) {
         this.totalSchedulingLength = totalSchedulingLength;
         return this;
      }

      @JsonProperty("totalSchedulingArea")
      public MesBuildingEnclosureSchedulingSummaryDO.MesBuildingEnclosureSchedulingSummaryDOBuilder totalSchedulingArea(final BigDecimal totalSchedulingArea) {
         this.totalSchedulingArea = totalSchedulingArea;
         return this;
      }

      @JsonProperty("taskQuantity")
      public MesBuildingEnclosureSchedulingSummaryDO.MesBuildingEnclosureSchedulingSummaryDOBuilder totalTaskQuantity(final Integer totalTaskQuantity) {
         this.totalTaskQuantity = totalTaskQuantity;
         return this;
      }

      @JsonProperty("totalTaskLength")
      public MesBuildingEnclosureSchedulingSummaryDO.MesBuildingEnclosureSchedulingSummaryDOBuilder totalTaskLength(final BigDecimal totalTaskLength) {
         this.totalTaskLength = totalTaskLength;
         return this;
      }

      @JsonProperty("totalTaskArea")
      public MesBuildingEnclosureSchedulingSummaryDO.MesBuildingEnclosureSchedulingSummaryDOBuilder totalTaskArea(final BigDecimal totalTaskArea) {
         this.totalTaskArea = totalTaskArea;
         return this;
      }

      @JsonProperty("completeQuantity")
      public MesBuildingEnclosureSchedulingSummaryDO.MesBuildingEnclosureSchedulingSummaryDOBuilder totalCompleteQuantity(final Integer totalCompleteQuantity) {
         this.totalCompleteQuantity = totalCompleteQuantity;
         return this;
      }

      @JsonProperty("totalCompleteLength")
      public MesBuildingEnclosureSchedulingSummaryDO.MesBuildingEnclosureSchedulingSummaryDOBuilder totalCompleteLength(final BigDecimal totalCompleteLength) {
         this.totalCompleteLength = totalCompleteLength;
         return this;
      }

      @JsonProperty("totalCompleteArea")
      public MesBuildingEnclosureSchedulingSummaryDO.MesBuildingEnclosureSchedulingSummaryDOBuilder totalCompleteArea(final BigDecimal totalCompleteArea) {
         this.totalCompleteArea = totalCompleteArea;
         return this;
      }

      @JsonProperty("date")
      public MesBuildingEnclosureSchedulingSummaryDO.MesBuildingEnclosureSchedulingSummaryDOBuilder date(final String date) {
         this.date = date;
         return this;
      }

      public MesBuildingEnclosureSchedulingSummaryDO build() {
         return new MesBuildingEnclosureSchedulingSummaryDO(
            this.totalSchedulingQuantity,
            this.totalSchedulingLength,
            this.totalSchedulingArea,
            this.totalTaskQuantity,
            this.totalTaskLength,
            this.totalTaskArea,
            this.totalCompleteQuantity,
            this.totalCompleteLength,
            this.totalCompleteArea,
            this.date
         );
      }

      @Override
      public String toString() {
         return "MesBuildingEnclosureSchedulingSummaryDO.MesBuildingEnclosureSchedulingSummaryDOBuilder(totalSchedulingQuantity="
            + this.totalSchedulingQuantity
            + ", totalSchedulingLength="
            + this.totalSchedulingLength
            + ", totalSchedulingArea="
            + this.totalSchedulingArea
            + ", totalTaskQuantity="
            + this.totalTaskQuantity
            + ", totalTaskLength="
            + this.totalTaskLength
            + ", totalTaskArea="
            + this.totalTaskArea
            + ", totalCompleteQuantity="
            + this.totalCompleteQuantity
            + ", totalCompleteLength="
            + this.totalCompleteLength
            + ", totalCompleteArea="
            + this.totalCompleteArea
            + ", date="
            + this.date
            + ")";
      }
   }
}
