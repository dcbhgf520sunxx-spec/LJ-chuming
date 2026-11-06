package com.hzchum.scim.mes.building.core.api.pojo._do.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesBuildingSchedulingSummaryDTO", description = "")
public class MesBuildingAssembleSchedulingSummaryDO {
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
   @ApiModelProperty(name = "totalTaskNetWeight", notes = "已下发总长度")
   @JsonProperty("totalTaskNetWeight")
   @JSONField(name = "totalTaskNetWeight")
   private BigDecimal totalTaskNetWeight;
   @ApiModelProperty(name = "completeQuantity", notes = "已完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer totalCompleteQuantity;
   @ApiModelProperty(name = "totalCompleteLength", notes = "已完成总长度")
   @JsonProperty("totalCompleteLength")
   @JSONField(name = "totalCompleteLength")
   private BigDecimal totalCompleteLength;
   @ApiModelProperty(name = "totalSchedulingNetWeight", notes = "总排产净重")
   @JsonProperty("totalSchedulingNetWeight")
   @JSONField(name = "totalSchedulingNetWeight")
   private BigDecimal totalSchedulingNetWeight;
   @ApiModelProperty(name = "totalCompleteNetWeight", notes = "已完成总净重")
   @JsonProperty("totalCompleteNetWeight")
   @JSONField(name = "totalCompleteNetWeight")
   private BigDecimal totalCompleteNetWeight;
   @ApiModelProperty(name = "date", notes = "时间")
   @JsonProperty("date")
   @JSONField(name = "date")
   private String date;

   public static MesBuildingAssembleSchedulingSummaryDO.MesBuildingAssembleSchedulingSummaryDOBuilder builder() {
      return new MesBuildingAssembleSchedulingSummaryDO.MesBuildingAssembleSchedulingSummaryDOBuilder();
   }

   public MesBuildingAssembleSchedulingSummaryDO() {
   }

   public MesBuildingAssembleSchedulingSummaryDO(
      final Integer totalSchedulingQuantity,
      final BigDecimal totalSchedulingLength,
      final Integer totalTaskQuantity,
      final BigDecimal totalTaskLength,
      final BigDecimal totalTaskNetWeight,
      final Integer totalCompleteQuantity,
      final BigDecimal totalCompleteLength,
      final BigDecimal totalSchedulingNetWeight,
      final BigDecimal totalCompleteNetWeight,
      final String date
   ) {
      this.totalSchedulingQuantity = totalSchedulingQuantity;
      this.totalSchedulingLength = totalSchedulingLength;
      this.totalTaskQuantity = totalTaskQuantity;
      this.totalTaskLength = totalTaskLength;
      this.totalTaskNetWeight = totalTaskNetWeight;
      this.totalCompleteQuantity = totalCompleteQuantity;
      this.totalCompleteLength = totalCompleteLength;
      this.totalSchedulingNetWeight = totalSchedulingNetWeight;
      this.totalCompleteNetWeight = totalCompleteNetWeight;
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

   public BigDecimal getTotalTaskNetWeight() {
      return this.totalTaskNetWeight;
   }

   public Integer getTotalCompleteQuantity() {
      return this.totalCompleteQuantity;
   }

   public BigDecimal getTotalCompleteLength() {
      return this.totalCompleteLength;
   }

   public BigDecimal getTotalSchedulingNetWeight() {
      return this.totalSchedulingNetWeight;
   }

   public BigDecimal getTotalCompleteNetWeight() {
      return this.totalCompleteNetWeight;
   }

   public String getDate() {
      return this.date;
   }

   @JsonProperty("schedulingQuantity")
   public MesBuildingAssembleSchedulingSummaryDO setTotalSchedulingQuantity(final Integer totalSchedulingQuantity) {
      this.totalSchedulingQuantity = totalSchedulingQuantity;
      return this;
   }

   @JsonProperty("totalSchedulingLength")
   public MesBuildingAssembleSchedulingSummaryDO setTotalSchedulingLength(final BigDecimal totalSchedulingLength) {
      this.totalSchedulingLength = totalSchedulingLength;
      return this;
   }

   @JsonProperty("taskQuantity")
   public MesBuildingAssembleSchedulingSummaryDO setTotalTaskQuantity(final Integer totalTaskQuantity) {
      this.totalTaskQuantity = totalTaskQuantity;
      return this;
   }

   @JsonProperty("totalTaskLength")
   public MesBuildingAssembleSchedulingSummaryDO setTotalTaskLength(final BigDecimal totalTaskLength) {
      this.totalTaskLength = totalTaskLength;
      return this;
   }

   @JsonProperty("totalTaskNetWeight")
   public MesBuildingAssembleSchedulingSummaryDO setTotalTaskNetWeight(final BigDecimal totalTaskNetWeight) {
      this.totalTaskNetWeight = totalTaskNetWeight;
      return this;
   }

   @JsonProperty("completeQuantity")
   public MesBuildingAssembleSchedulingSummaryDO setTotalCompleteQuantity(final Integer totalCompleteQuantity) {
      this.totalCompleteQuantity = totalCompleteQuantity;
      return this;
   }

   @JsonProperty("totalCompleteLength")
   public MesBuildingAssembleSchedulingSummaryDO setTotalCompleteLength(final BigDecimal totalCompleteLength) {
      this.totalCompleteLength = totalCompleteLength;
      return this;
   }

   @JsonProperty("totalSchedulingNetWeight")
   public MesBuildingAssembleSchedulingSummaryDO setTotalSchedulingNetWeight(final BigDecimal totalSchedulingNetWeight) {
      this.totalSchedulingNetWeight = totalSchedulingNetWeight;
      return this;
   }

   @JsonProperty("totalCompleteNetWeight")
   public MesBuildingAssembleSchedulingSummaryDO setTotalCompleteNetWeight(final BigDecimal totalCompleteNetWeight) {
      this.totalCompleteNetWeight = totalCompleteNetWeight;
      return this;
   }

   @JsonProperty("date")
   public MesBuildingAssembleSchedulingSummaryDO setDate(final String date) {
      this.date = date;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingAssembleSchedulingSummaryDO)) {
         return false;
      }

      MesBuildingAssembleSchedulingSummaryDO other = (MesBuildingAssembleSchedulingSummaryDO)o;
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
                     Object this$totalTaskNetWeight = this.getTotalTaskNetWeight();
                     Object other$totalTaskNetWeight = other.getTotalTaskNetWeight();
                     if (this$totalTaskNetWeight == null ? other$totalTaskNetWeight == null : this$totalTaskNetWeight.equals(other$totalTaskNetWeight)) {
                        Object this$totalCompleteLength = this.getTotalCompleteLength();
                        Object other$totalCompleteLength = other.getTotalCompleteLength();
                        if (this$totalCompleteLength == null ? other$totalCompleteLength == null : this$totalCompleteLength.equals(other$totalCompleteLength)) {
                           Object this$totalSchedulingNetWeight = this.getTotalSchedulingNetWeight();
                           Object other$totalSchedulingNetWeight = other.getTotalSchedulingNetWeight();
                           if (this$totalSchedulingNetWeight == null
                              ? other$totalSchedulingNetWeight == null
                              : this$totalSchedulingNetWeight.equals(other$totalSchedulingNetWeight)) {
                              Object this$totalCompleteNetWeight = this.getTotalCompleteNetWeight();
                              Object other$totalCompleteNetWeight = other.getTotalCompleteNetWeight();
                              if (this$totalCompleteNetWeight == null
                                 ? other$totalCompleteNetWeight == null
                                 : this$totalCompleteNetWeight.equals(other$totalCompleteNetWeight)) {
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
      return other instanceof MesBuildingAssembleSchedulingSummaryDO;
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
      Object $totalTaskNetWeight = this.getTotalTaskNetWeight();
      result = result * 59 + ($totalTaskNetWeight == null ? 43 : $totalTaskNetWeight.hashCode());
      Object $totalCompleteLength = this.getTotalCompleteLength();
      result = result * 59 + ($totalCompleteLength == null ? 43 : $totalCompleteLength.hashCode());
      Object $totalSchedulingNetWeight = this.getTotalSchedulingNetWeight();
      result = result * 59 + ($totalSchedulingNetWeight == null ? 43 : $totalSchedulingNetWeight.hashCode());
      Object $totalCompleteNetWeight = this.getTotalCompleteNetWeight();
      result = result * 59 + ($totalCompleteNetWeight == null ? 43 : $totalCompleteNetWeight.hashCode());
      Object $date = this.getDate();
      return result * 59 + ($date == null ? 43 : $date.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingAssembleSchedulingSummaryDO(totalSchedulingQuantity="
         + this.getTotalSchedulingQuantity()
         + ", totalSchedulingLength="
         + this.getTotalSchedulingLength()
         + ", totalTaskQuantity="
         + this.getTotalTaskQuantity()
         + ", totalTaskLength="
         + this.getTotalTaskLength()
         + ", totalTaskNetWeight="
         + this.getTotalTaskNetWeight()
         + ", totalCompleteQuantity="
         + this.getTotalCompleteQuantity()
         + ", totalCompleteLength="
         + this.getTotalCompleteLength()
         + ", totalSchedulingNetWeight="
         + this.getTotalSchedulingNetWeight()
         + ", totalCompleteNetWeight="
         + this.getTotalCompleteNetWeight()
         + ", date="
         + this.getDate()
         + ")";
   }

   public static class MesBuildingAssembleSchedulingSummaryDOBuilder {
      private Integer totalSchedulingQuantity;
      private BigDecimal totalSchedulingLength;
      private Integer totalTaskQuantity;
      private BigDecimal totalTaskLength;
      private BigDecimal totalTaskNetWeight;
      private Integer totalCompleteQuantity;
      private BigDecimal totalCompleteLength;
      private BigDecimal totalSchedulingNetWeight;
      private BigDecimal totalCompleteNetWeight;
      private String date;

      MesBuildingAssembleSchedulingSummaryDOBuilder() {
      }

      @JsonProperty("schedulingQuantity")
      public MesBuildingAssembleSchedulingSummaryDO.MesBuildingAssembleSchedulingSummaryDOBuilder totalSchedulingQuantity(final Integer totalSchedulingQuantity) {
         this.totalSchedulingQuantity = totalSchedulingQuantity;
         return this;
      }

      @JsonProperty("totalSchedulingLength")
      public MesBuildingAssembleSchedulingSummaryDO.MesBuildingAssembleSchedulingSummaryDOBuilder totalSchedulingLength(final BigDecimal totalSchedulingLength) {
         this.totalSchedulingLength = totalSchedulingLength;
         return this;
      }

      @JsonProperty("taskQuantity")
      public MesBuildingAssembleSchedulingSummaryDO.MesBuildingAssembleSchedulingSummaryDOBuilder totalTaskQuantity(final Integer totalTaskQuantity) {
         this.totalTaskQuantity = totalTaskQuantity;
         return this;
      }

      @JsonProperty("totalTaskLength")
      public MesBuildingAssembleSchedulingSummaryDO.MesBuildingAssembleSchedulingSummaryDOBuilder totalTaskLength(final BigDecimal totalTaskLength) {
         this.totalTaskLength = totalTaskLength;
         return this;
      }

      @JsonProperty("totalTaskNetWeight")
      public MesBuildingAssembleSchedulingSummaryDO.MesBuildingAssembleSchedulingSummaryDOBuilder totalTaskNetWeight(final BigDecimal totalTaskNetWeight) {
         this.totalTaskNetWeight = totalTaskNetWeight;
         return this;
      }

      @JsonProperty("completeQuantity")
      public MesBuildingAssembleSchedulingSummaryDO.MesBuildingAssembleSchedulingSummaryDOBuilder totalCompleteQuantity(final Integer totalCompleteQuantity) {
         this.totalCompleteQuantity = totalCompleteQuantity;
         return this;
      }

      @JsonProperty("totalCompleteLength")
      public MesBuildingAssembleSchedulingSummaryDO.MesBuildingAssembleSchedulingSummaryDOBuilder totalCompleteLength(final BigDecimal totalCompleteLength) {
         this.totalCompleteLength = totalCompleteLength;
         return this;
      }

      @JsonProperty("totalSchedulingNetWeight")
      public MesBuildingAssembleSchedulingSummaryDO.MesBuildingAssembleSchedulingSummaryDOBuilder totalSchedulingNetWeight(
         final BigDecimal totalSchedulingNetWeight
      ) {
         this.totalSchedulingNetWeight = totalSchedulingNetWeight;
         return this;
      }

      @JsonProperty("totalCompleteNetWeight")
      public MesBuildingAssembleSchedulingSummaryDO.MesBuildingAssembleSchedulingSummaryDOBuilder totalCompleteNetWeight(
         final BigDecimal totalCompleteNetWeight
      ) {
         this.totalCompleteNetWeight = totalCompleteNetWeight;
         return this;
      }

      @JsonProperty("date")
      public MesBuildingAssembleSchedulingSummaryDO.MesBuildingAssembleSchedulingSummaryDOBuilder date(final String date) {
         this.date = date;
         return this;
      }

      public MesBuildingAssembleSchedulingSummaryDO build() {
         return new MesBuildingAssembleSchedulingSummaryDO(
            this.totalSchedulingQuantity,
            this.totalSchedulingLength,
            this.totalTaskQuantity,
            this.totalTaskLength,
            this.totalTaskNetWeight,
            this.totalCompleteQuantity,
            this.totalCompleteLength,
            this.totalSchedulingNetWeight,
            this.totalCompleteNetWeight,
            this.date
         );
      }

      @Override
      public String toString() {
         return "MesBuildingAssembleSchedulingSummaryDO.MesBuildingAssembleSchedulingSummaryDOBuilder(totalSchedulingQuantity="
            + this.totalSchedulingQuantity
            + ", totalSchedulingLength="
            + this.totalSchedulingLength
            + ", totalTaskQuantity="
            + this.totalTaskQuantity
            + ", totalTaskLength="
            + this.totalTaskLength
            + ", totalTaskNetWeight="
            + this.totalTaskNetWeight
            + ", totalCompleteQuantity="
            + this.totalCompleteQuantity
            + ", totalCompleteLength="
            + this.totalCompleteLength
            + ", totalSchedulingNetWeight="
            + this.totalSchedulingNetWeight
            + ", totalCompleteNetWeight="
            + this.totalCompleteNetWeight
            + ", date="
            + this.date
            + ")";
      }
   }
}
