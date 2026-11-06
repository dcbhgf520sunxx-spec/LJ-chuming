package com.hzchum.scim.mes.building.core.api.pojo._do.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ArtifactSchedulingDTO", description = "项目排期信息 ")
public class ArtifactSchedulingDO {
   @ApiModelProperty(name = "projectId", value = "项目Id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "date", value = "日期")
   @JsonProperty("date")
   @JSONField(name = "date")
   private String date;
   @ApiModelProperty(name = "schedulingTotalGrossWeight", value = "排产总毛重（kg）")
   @JsonProperty("schedulingTotalGrossWeight")
   @JSONField(name = "schedulingTotalGrossWeight")
   private BigDecimal schedulingTotalGrossWeight;
   @ApiModelProperty(name = "schedulingTotalNetWeight", value = "排产总净重（kg）")
   @JsonProperty("schedulingTotalNetWeight")
   @JSONField(name = "schedulingTotalNetWeight")
   private BigDecimal schedulingTotalNetWeight;
   @ApiModelProperty(name = "completeTotalGrossWeight", value = "完成产总毛重（kg）")
   @JsonProperty("completeTotalGrossWeight")
   @JSONField(name = "completeTotalGrossWeight")
   private BigDecimal completeTotalGrossWeight;
   @ApiModelProperty(name = "completeTotalNetWeight", value = "完成总净重（kg）")
   @JsonProperty("completeTotalNetWeight")
   @JSONField(name = "completeTotalNetWeight")
   private BigDecimal completeTotalNetWeight;

   public static ArtifactSchedulingDO.ArtifactSchedulingDOBuilder builder() {
      return new ArtifactSchedulingDO.ArtifactSchedulingDOBuilder();
   }

   public ArtifactSchedulingDO() {
   }

   public ArtifactSchedulingDO(
      final Long projectId,
      final Long monomerId,
      final String date,
      final BigDecimal schedulingTotalGrossWeight,
      final BigDecimal schedulingTotalNetWeight,
      final BigDecimal completeTotalGrossWeight,
      final BigDecimal completeTotalNetWeight
   ) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.date = date;
      this.schedulingTotalGrossWeight = schedulingTotalGrossWeight;
      this.schedulingTotalNetWeight = schedulingTotalNetWeight;
      this.completeTotalGrossWeight = completeTotalGrossWeight;
      this.completeTotalNetWeight = completeTotalNetWeight;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getDate() {
      return this.date;
   }

   public BigDecimal getSchedulingTotalGrossWeight() {
      return this.schedulingTotalGrossWeight;
   }

   public BigDecimal getSchedulingTotalNetWeight() {
      return this.schedulingTotalNetWeight;
   }

   public BigDecimal getCompleteTotalGrossWeight() {
      return this.completeTotalGrossWeight;
   }

   public BigDecimal getCompleteTotalNetWeight() {
      return this.completeTotalNetWeight;
   }

   @JsonProperty("projectId")
   public ArtifactSchedulingDO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public ArtifactSchedulingDO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("date")
   public ArtifactSchedulingDO setDate(final String date) {
      this.date = date;
      return this;
   }

   @JsonProperty("schedulingTotalGrossWeight")
   public ArtifactSchedulingDO setSchedulingTotalGrossWeight(final BigDecimal schedulingTotalGrossWeight) {
      this.schedulingTotalGrossWeight = schedulingTotalGrossWeight;
      return this;
   }

   @JsonProperty("schedulingTotalNetWeight")
   public ArtifactSchedulingDO setSchedulingTotalNetWeight(final BigDecimal schedulingTotalNetWeight) {
      this.schedulingTotalNetWeight = schedulingTotalNetWeight;
      return this;
   }

   @JsonProperty("completeTotalGrossWeight")
   public ArtifactSchedulingDO setCompleteTotalGrossWeight(final BigDecimal completeTotalGrossWeight) {
      this.completeTotalGrossWeight = completeTotalGrossWeight;
      return this;
   }

   @JsonProperty("completeTotalNetWeight")
   public ArtifactSchedulingDO setCompleteTotalNetWeight(final BigDecimal completeTotalNetWeight) {
      this.completeTotalNetWeight = completeTotalNetWeight;
      return this;
   }

   @Override
   public String toString() {
      return "ArtifactSchedulingDO(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", date="
         + this.getDate()
         + ", schedulingTotalGrossWeight="
         + this.getSchedulingTotalGrossWeight()
         + ", schedulingTotalNetWeight="
         + this.getSchedulingTotalNetWeight()
         + ", completeTotalGrossWeight="
         + this.getCompleteTotalGrossWeight()
         + ", completeTotalNetWeight="
         + this.getCompleteTotalNetWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactSchedulingDO)) {
         return false;
      }

      ArtifactSchedulingDO other = (ArtifactSchedulingDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$date = this.getDate();
            Object other$date = other.getDate();
            if (this$date == null ? other$date == null : this$date.equals(other$date)) {
               Object this$schedulingTotalGrossWeight = this.getSchedulingTotalGrossWeight();
               Object other$schedulingTotalGrossWeight = other.getSchedulingTotalGrossWeight();
               if (this$schedulingTotalGrossWeight == null
                  ? other$schedulingTotalGrossWeight == null
                  : this$schedulingTotalGrossWeight.equals(other$schedulingTotalGrossWeight)) {
                  Object this$schedulingTotalNetWeight = this.getSchedulingTotalNetWeight();
                  Object other$schedulingTotalNetWeight = other.getSchedulingTotalNetWeight();
                  if (this$schedulingTotalNetWeight == null
                     ? other$schedulingTotalNetWeight == null
                     : this$schedulingTotalNetWeight.equals(other$schedulingTotalNetWeight)) {
                     Object this$completeTotalGrossWeight = this.getCompleteTotalGrossWeight();
                     Object other$completeTotalGrossWeight = other.getCompleteTotalGrossWeight();
                     if (this$completeTotalGrossWeight == null
                        ? other$completeTotalGrossWeight == null
                        : this$completeTotalGrossWeight.equals(other$completeTotalGrossWeight)) {
                        Object this$completeTotalNetWeight = this.getCompleteTotalNetWeight();
                        Object other$completeTotalNetWeight = other.getCompleteTotalNetWeight();
                        return this$completeTotalNetWeight == null
                           ? other$completeTotalNetWeight == null
                           : this$completeTotalNetWeight.equals(other$completeTotalNetWeight);
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
      return other instanceof ArtifactSchedulingDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $schedulingTotalGrossWeight = this.getSchedulingTotalGrossWeight();
      result = result * 59 + ($schedulingTotalGrossWeight == null ? 43 : $schedulingTotalGrossWeight.hashCode());
      Object $schedulingTotalNetWeight = this.getSchedulingTotalNetWeight();
      result = result * 59 + ($schedulingTotalNetWeight == null ? 43 : $schedulingTotalNetWeight.hashCode());
      Object $completeTotalGrossWeight = this.getCompleteTotalGrossWeight();
      result = result * 59 + ($completeTotalGrossWeight == null ? 43 : $completeTotalGrossWeight.hashCode());
      Object $completeTotalNetWeight = this.getCompleteTotalNetWeight();
      return result * 59 + ($completeTotalNetWeight == null ? 43 : $completeTotalNetWeight.hashCode());
   }

   public static class ArtifactSchedulingDOBuilder {
      private Long projectId;
      private Long monomerId;
      private String date;
      private BigDecimal schedulingTotalGrossWeight;
      private BigDecimal schedulingTotalNetWeight;
      private BigDecimal completeTotalGrossWeight;
      private BigDecimal completeTotalNetWeight;

      ArtifactSchedulingDOBuilder() {
      }

      @JsonProperty("projectId")
      public ArtifactSchedulingDO.ArtifactSchedulingDOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public ArtifactSchedulingDO.ArtifactSchedulingDOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("date")
      public ArtifactSchedulingDO.ArtifactSchedulingDOBuilder date(final String date) {
         this.date = date;
         return this;
      }

      @JsonProperty("schedulingTotalGrossWeight")
      public ArtifactSchedulingDO.ArtifactSchedulingDOBuilder schedulingTotalGrossWeight(final BigDecimal schedulingTotalGrossWeight) {
         this.schedulingTotalGrossWeight = schedulingTotalGrossWeight;
         return this;
      }

      @JsonProperty("schedulingTotalNetWeight")
      public ArtifactSchedulingDO.ArtifactSchedulingDOBuilder schedulingTotalNetWeight(final BigDecimal schedulingTotalNetWeight) {
         this.schedulingTotalNetWeight = schedulingTotalNetWeight;
         return this;
      }

      @JsonProperty("completeTotalGrossWeight")
      public ArtifactSchedulingDO.ArtifactSchedulingDOBuilder completeTotalGrossWeight(final BigDecimal completeTotalGrossWeight) {
         this.completeTotalGrossWeight = completeTotalGrossWeight;
         return this;
      }

      @JsonProperty("completeTotalNetWeight")
      public ArtifactSchedulingDO.ArtifactSchedulingDOBuilder completeTotalNetWeight(final BigDecimal completeTotalNetWeight) {
         this.completeTotalNetWeight = completeTotalNetWeight;
         return this;
      }

      public ArtifactSchedulingDO build() {
         return new ArtifactSchedulingDO(
            this.projectId,
            this.monomerId,
            this.date,
            this.schedulingTotalGrossWeight,
            this.schedulingTotalNetWeight,
            this.completeTotalGrossWeight,
            this.completeTotalNetWeight
         );
      }

      @Override
      public String toString() {
         return "ArtifactSchedulingDO.ArtifactSchedulingDOBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", date="
            + this.date
            + ", schedulingTotalGrossWeight="
            + this.schedulingTotalGrossWeight
            + ", schedulingTotalNetWeight="
            + this.schedulingTotalNetWeight
            + ", completeTotalGrossWeight="
            + this.completeTotalGrossWeight
            + ", completeTotalNetWeight="
            + this.completeTotalNetWeight
            + ")";
      }
   }
}
