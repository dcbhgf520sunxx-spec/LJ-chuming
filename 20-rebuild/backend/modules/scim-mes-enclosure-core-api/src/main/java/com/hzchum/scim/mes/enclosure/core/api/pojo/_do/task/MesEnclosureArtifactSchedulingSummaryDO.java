package com.hzchum.scim.mes.enclosure.core.api.pojo._do.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesEnclosureSchedulingSummaryDTO", description = "")
public class MesEnclosureArtifactSchedulingSummaryDO {
   @ApiModelProperty(name = "schedulingQuantity", notes = "排产数量")
   @JsonProperty("schedulingQuantity")
   @JSONField(name = "schedulingQuantity")
   private Integer totalSchedulingQuantity;
   @ApiModelProperty(name = "totalSchedulingNetWeight", notes = "排产总净重量")
   @JsonProperty("totalSchedulingNetWeight")
   @JSONField(name = "totalSchedulingNetWeight")
   private BigDecimal totalSchedulingNetWeight;
   @ApiModelProperty(name = "totalSchedulingGrossWeight", notes = "排产总净重量")
   @JsonProperty("totalSchedulingGrossWeight")
   @JSONField(name = "totalSchedulingGrossWeight")
   private BigDecimal totalSchedulingGrossWeight;
   @ApiModelProperty(name = "taskQuantity", notes = "已下发数量")
   @JsonProperty("taskQuantity")
   @JSONField(name = "taskQuantity")
   private Integer totalTaskQuantity;
   @ApiModelProperty(name = "totalTaskNetWeight", notes = "已下发总净重量")
   @JsonProperty("totalTaskNetWeight")
   @JSONField(name = "totalTaskNetWeight")
   private BigDecimal totalTaskNetWeight;
   @ApiModelProperty(name = "totalTaskGrossWeight", notes = "已下发总净重量")
   @JsonProperty("totalTaskGrossWeight")
   @JSONField(name = "totalTaskGrossWeight")
   private BigDecimal totalTaskGrossWeight;
   @ApiModelProperty(name = "completeQuantity", notes = "已完成数量")
   @JsonProperty("completeQuantity")
   @JSONField(name = "completeQuantity")
   private Integer totalCompleteQuantity;
   @ApiModelProperty(name = "totalCompleteNetWeight", notes = "已完成总净重量")
   @JsonProperty("totalCompleteNetWeight")
   @JSONField(name = "totalCompleteNetWeight")
   private BigDecimal totalCompleteNetWeight;
   @ApiModelProperty(name = "totalCompleteGrossWeight", notes = "已完成总毛重量")
   @JsonProperty("totalCompleteGrossWeight")
   @JSONField(name = "totalCompleteGrossWeight")
   private BigDecimal totalCompleteGrossWeight;
   @ApiModelProperty(name = "date", notes = "时间")
   @JsonProperty("date")
   @JSONField(name = "date")
   private String date;

   public static MesEnclosureArtifactSchedulingSummaryDO.MesEnclosureArtifactSchedulingSummaryDOBuilder builder() {
      return new MesEnclosureArtifactSchedulingSummaryDO.MesEnclosureArtifactSchedulingSummaryDOBuilder();
   }

   public MesEnclosureArtifactSchedulingSummaryDO() {
   }

   public MesEnclosureArtifactSchedulingSummaryDO(
      final Integer totalSchedulingQuantity,
      final BigDecimal totalSchedulingNetWeight,
      final BigDecimal totalSchedulingGrossWeight,
      final Integer totalTaskQuantity,
      final BigDecimal totalTaskNetWeight,
      final BigDecimal totalTaskGrossWeight,
      final Integer totalCompleteQuantity,
      final BigDecimal totalCompleteNetWeight,
      final BigDecimal totalCompleteGrossWeight,
      final String date
   ) {
      this.totalSchedulingQuantity = totalSchedulingQuantity;
      this.totalSchedulingNetWeight = totalSchedulingNetWeight;
      this.totalSchedulingGrossWeight = totalSchedulingGrossWeight;
      this.totalTaskQuantity = totalTaskQuantity;
      this.totalTaskNetWeight = totalTaskNetWeight;
      this.totalTaskGrossWeight = totalTaskGrossWeight;
      this.totalCompleteQuantity = totalCompleteQuantity;
      this.totalCompleteNetWeight = totalCompleteNetWeight;
      this.totalCompleteGrossWeight = totalCompleteGrossWeight;
      this.date = date;
   }

   public Integer getTotalSchedulingQuantity() {
      return this.totalSchedulingQuantity;
   }

   public BigDecimal getTotalSchedulingNetWeight() {
      return this.totalSchedulingNetWeight;
   }

   public BigDecimal getTotalSchedulingGrossWeight() {
      return this.totalSchedulingGrossWeight;
   }

   public Integer getTotalTaskQuantity() {
      return this.totalTaskQuantity;
   }

   public BigDecimal getTotalTaskNetWeight() {
      return this.totalTaskNetWeight;
   }

   public BigDecimal getTotalTaskGrossWeight() {
      return this.totalTaskGrossWeight;
   }

   public Integer getTotalCompleteQuantity() {
      return this.totalCompleteQuantity;
   }

   public BigDecimal getTotalCompleteNetWeight() {
      return this.totalCompleteNetWeight;
   }

   public BigDecimal getTotalCompleteGrossWeight() {
      return this.totalCompleteGrossWeight;
   }

   public String getDate() {
      return this.date;
   }

   @JsonProperty("schedulingQuantity")
   public MesEnclosureArtifactSchedulingSummaryDO setTotalSchedulingQuantity(final Integer totalSchedulingQuantity) {
      this.totalSchedulingQuantity = totalSchedulingQuantity;
      return this;
   }

   @JsonProperty("totalSchedulingNetWeight")
   public MesEnclosureArtifactSchedulingSummaryDO setTotalSchedulingNetWeight(final BigDecimal totalSchedulingNetWeight) {
      this.totalSchedulingNetWeight = totalSchedulingNetWeight;
      return this;
   }

   @JsonProperty("totalSchedulingGrossWeight")
   public MesEnclosureArtifactSchedulingSummaryDO setTotalSchedulingGrossWeight(final BigDecimal totalSchedulingGrossWeight) {
      this.totalSchedulingGrossWeight = totalSchedulingGrossWeight;
      return this;
   }

   @JsonProperty("taskQuantity")
   public MesEnclosureArtifactSchedulingSummaryDO setTotalTaskQuantity(final Integer totalTaskQuantity) {
      this.totalTaskQuantity = totalTaskQuantity;
      return this;
   }

   @JsonProperty("totalTaskNetWeight")
   public MesEnclosureArtifactSchedulingSummaryDO setTotalTaskNetWeight(final BigDecimal totalTaskNetWeight) {
      this.totalTaskNetWeight = totalTaskNetWeight;
      return this;
   }

   @JsonProperty("totalTaskGrossWeight")
   public MesEnclosureArtifactSchedulingSummaryDO setTotalTaskGrossWeight(final BigDecimal totalTaskGrossWeight) {
      this.totalTaskGrossWeight = totalTaskGrossWeight;
      return this;
   }

   @JsonProperty("completeQuantity")
   public MesEnclosureArtifactSchedulingSummaryDO setTotalCompleteQuantity(final Integer totalCompleteQuantity) {
      this.totalCompleteQuantity = totalCompleteQuantity;
      return this;
   }

   @JsonProperty("totalCompleteNetWeight")
   public MesEnclosureArtifactSchedulingSummaryDO setTotalCompleteNetWeight(final BigDecimal totalCompleteNetWeight) {
      this.totalCompleteNetWeight = totalCompleteNetWeight;
      return this;
   }

   @JsonProperty("totalCompleteGrossWeight")
   public MesEnclosureArtifactSchedulingSummaryDO setTotalCompleteGrossWeight(final BigDecimal totalCompleteGrossWeight) {
      this.totalCompleteGrossWeight = totalCompleteGrossWeight;
      return this;
   }

   @JsonProperty("date")
   public MesEnclosureArtifactSchedulingSummaryDO setDate(final String date) {
      this.date = date;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureArtifactSchedulingSummaryDO)) {
         return false;
      }

      MesEnclosureArtifactSchedulingSummaryDO other = (MesEnclosureArtifactSchedulingSummaryDO)o;
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
               Object this$totalSchedulingNetWeight = this.getTotalSchedulingNetWeight();
               Object other$totalSchedulingNetWeight = other.getTotalSchedulingNetWeight();
               if (this$totalSchedulingNetWeight == null
                  ? other$totalSchedulingNetWeight == null
                  : this$totalSchedulingNetWeight.equals(other$totalSchedulingNetWeight)) {
                  Object this$totalSchedulingGrossWeight = this.getTotalSchedulingGrossWeight();
                  Object other$totalSchedulingGrossWeight = other.getTotalSchedulingGrossWeight();
                  if (this$totalSchedulingGrossWeight == null
                     ? other$totalSchedulingGrossWeight == null
                     : this$totalSchedulingGrossWeight.equals(other$totalSchedulingGrossWeight)) {
                     Object this$totalTaskNetWeight = this.getTotalTaskNetWeight();
                     Object other$totalTaskNetWeight = other.getTotalTaskNetWeight();
                     if (this$totalTaskNetWeight == null ? other$totalTaskNetWeight == null : this$totalTaskNetWeight.equals(other$totalTaskNetWeight)) {
                        Object this$totalTaskGrossWeight = this.getTotalTaskGrossWeight();
                        Object other$totalTaskGrossWeight = other.getTotalTaskGrossWeight();
                        if (this$totalTaskGrossWeight == null
                           ? other$totalTaskGrossWeight == null
                           : this$totalTaskGrossWeight.equals(other$totalTaskGrossWeight)) {
                           Object this$totalCompleteNetWeight = this.getTotalCompleteNetWeight();
                           Object other$totalCompleteNetWeight = other.getTotalCompleteNetWeight();
                           if (this$totalCompleteNetWeight == null
                              ? other$totalCompleteNetWeight == null
                              : this$totalCompleteNetWeight.equals(other$totalCompleteNetWeight)) {
                              Object this$totalCompleteGrossWeight = this.getTotalCompleteGrossWeight();
                              Object other$totalCompleteGrossWeight = other.getTotalCompleteGrossWeight();
                              if (this$totalCompleteGrossWeight == null
                                 ? other$totalCompleteGrossWeight == null
                                 : this$totalCompleteGrossWeight.equals(other$totalCompleteGrossWeight)) {
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
      return other instanceof MesEnclosureArtifactSchedulingSummaryDO;
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
      Object $totalSchedulingNetWeight = this.getTotalSchedulingNetWeight();
      result = result * 59 + ($totalSchedulingNetWeight == null ? 43 : $totalSchedulingNetWeight.hashCode());
      Object $totalSchedulingGrossWeight = this.getTotalSchedulingGrossWeight();
      result = result * 59 + ($totalSchedulingGrossWeight == null ? 43 : $totalSchedulingGrossWeight.hashCode());
      Object $totalTaskNetWeight = this.getTotalTaskNetWeight();
      result = result * 59 + ($totalTaskNetWeight == null ? 43 : $totalTaskNetWeight.hashCode());
      Object $totalTaskGrossWeight = this.getTotalTaskGrossWeight();
      result = result * 59 + ($totalTaskGrossWeight == null ? 43 : $totalTaskGrossWeight.hashCode());
      Object $totalCompleteNetWeight = this.getTotalCompleteNetWeight();
      result = result * 59 + ($totalCompleteNetWeight == null ? 43 : $totalCompleteNetWeight.hashCode());
      Object $totalCompleteGrossWeight = this.getTotalCompleteGrossWeight();
      result = result * 59 + ($totalCompleteGrossWeight == null ? 43 : $totalCompleteGrossWeight.hashCode());
      Object $date = this.getDate();
      return result * 59 + ($date == null ? 43 : $date.hashCode());
   }

   @Override
   public String toString() {
      return "MesEnclosureArtifactSchedulingSummaryDO(totalSchedulingQuantity="
         + this.getTotalSchedulingQuantity()
         + ", totalSchedulingNetWeight="
         + this.getTotalSchedulingNetWeight()
         + ", totalSchedulingGrossWeight="
         + this.getTotalSchedulingGrossWeight()
         + ", totalTaskQuantity="
         + this.getTotalTaskQuantity()
         + ", totalTaskNetWeight="
         + this.getTotalTaskNetWeight()
         + ", totalTaskGrossWeight="
         + this.getTotalTaskGrossWeight()
         + ", totalCompleteQuantity="
         + this.getTotalCompleteQuantity()
         + ", totalCompleteNetWeight="
         + this.getTotalCompleteNetWeight()
         + ", totalCompleteGrossWeight="
         + this.getTotalCompleteGrossWeight()
         + ", date="
         + this.getDate()
         + ")";
   }

   public static class MesEnclosureArtifactSchedulingSummaryDOBuilder {
      private Integer totalSchedulingQuantity;
      private BigDecimal totalSchedulingNetWeight;
      private BigDecimal totalSchedulingGrossWeight;
      private Integer totalTaskQuantity;
      private BigDecimal totalTaskNetWeight;
      private BigDecimal totalTaskGrossWeight;
      private Integer totalCompleteQuantity;
      private BigDecimal totalCompleteNetWeight;
      private BigDecimal totalCompleteGrossWeight;
      private String date;

      MesEnclosureArtifactSchedulingSummaryDOBuilder() {
      }

      @JsonProperty("schedulingQuantity")
      public MesEnclosureArtifactSchedulingSummaryDO.MesEnclosureArtifactSchedulingSummaryDOBuilder totalSchedulingQuantity(
         final Integer totalSchedulingQuantity
      ) {
         this.totalSchedulingQuantity = totalSchedulingQuantity;
         return this;
      }

      @JsonProperty("totalSchedulingNetWeight")
      public MesEnclosureArtifactSchedulingSummaryDO.MesEnclosureArtifactSchedulingSummaryDOBuilder totalSchedulingNetWeight(
         final BigDecimal totalSchedulingNetWeight
      ) {
         this.totalSchedulingNetWeight = totalSchedulingNetWeight;
         return this;
      }

      @JsonProperty("totalSchedulingGrossWeight")
      public MesEnclosureArtifactSchedulingSummaryDO.MesEnclosureArtifactSchedulingSummaryDOBuilder totalSchedulingGrossWeight(
         final BigDecimal totalSchedulingGrossWeight
      ) {
         this.totalSchedulingGrossWeight = totalSchedulingGrossWeight;
         return this;
      }

      @JsonProperty("taskQuantity")
      public MesEnclosureArtifactSchedulingSummaryDO.MesEnclosureArtifactSchedulingSummaryDOBuilder totalTaskQuantity(final Integer totalTaskQuantity) {
         this.totalTaskQuantity = totalTaskQuantity;
         return this;
      }

      @JsonProperty("totalTaskNetWeight")
      public MesEnclosureArtifactSchedulingSummaryDO.MesEnclosureArtifactSchedulingSummaryDOBuilder totalTaskNetWeight(final BigDecimal totalTaskNetWeight) {
         this.totalTaskNetWeight = totalTaskNetWeight;
         return this;
      }

      @JsonProperty("totalTaskGrossWeight")
      public MesEnclosureArtifactSchedulingSummaryDO.MesEnclosureArtifactSchedulingSummaryDOBuilder totalTaskGrossWeight(final BigDecimal totalTaskGrossWeight) {
         this.totalTaskGrossWeight = totalTaskGrossWeight;
         return this;
      }

      @JsonProperty("completeQuantity")
      public MesEnclosureArtifactSchedulingSummaryDO.MesEnclosureArtifactSchedulingSummaryDOBuilder totalCompleteQuantity(final Integer totalCompleteQuantity) {
         this.totalCompleteQuantity = totalCompleteQuantity;
         return this;
      }

      @JsonProperty("totalCompleteNetWeight")
      public MesEnclosureArtifactSchedulingSummaryDO.MesEnclosureArtifactSchedulingSummaryDOBuilder totalCompleteNetWeight(
         final BigDecimal totalCompleteNetWeight
      ) {
         this.totalCompleteNetWeight = totalCompleteNetWeight;
         return this;
      }

      @JsonProperty("totalCompleteGrossWeight")
      public MesEnclosureArtifactSchedulingSummaryDO.MesEnclosureArtifactSchedulingSummaryDOBuilder totalCompleteGrossWeight(
         final BigDecimal totalCompleteGrossWeight
      ) {
         this.totalCompleteGrossWeight = totalCompleteGrossWeight;
         return this;
      }

      @JsonProperty("date")
      public MesEnclosureArtifactSchedulingSummaryDO.MesEnclosureArtifactSchedulingSummaryDOBuilder date(final String date) {
         this.date = date;
         return this;
      }

      public MesEnclosureArtifactSchedulingSummaryDO build() {
         return new MesEnclosureArtifactSchedulingSummaryDO(
            this.totalSchedulingQuantity,
            this.totalSchedulingNetWeight,
            this.totalSchedulingGrossWeight,
            this.totalTaskQuantity,
            this.totalTaskNetWeight,
            this.totalTaskGrossWeight,
            this.totalCompleteQuantity,
            this.totalCompleteNetWeight,
            this.totalCompleteGrossWeight,
            this.date
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureArtifactSchedulingSummaryDO.MesEnclosureArtifactSchedulingSummaryDOBuilder(totalSchedulingQuantity="
            + this.totalSchedulingQuantity
            + ", totalSchedulingNetWeight="
            + this.totalSchedulingNetWeight
            + ", totalSchedulingGrossWeight="
            + this.totalSchedulingGrossWeight
            + ", totalTaskQuantity="
            + this.totalTaskQuantity
            + ", totalTaskNetWeight="
            + this.totalTaskNetWeight
            + ", totalTaskGrossWeight="
            + this.totalTaskGrossWeight
            + ", totalCompleteQuantity="
            + this.totalCompleteQuantity
            + ", totalCompleteNetWeight="
            + this.totalCompleteNetWeight
            + ", totalCompleteGrossWeight="
            + this.totalCompleteGrossWeight
            + ", date="
            + this.date
            + ")";
      }
   }
}
