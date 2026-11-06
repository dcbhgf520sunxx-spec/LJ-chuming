package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ArtifactSchedulingSummaryDTO", description = "构件排产信息")
public class ArtifactSchedulingSummaryDTO {
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "projectQuantity", value = "项目个数")
   @JsonProperty("projectQuantity")
   @JSONField(name = "projectQuantity")
   private Integer projectQuantity;
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

   ArtifactSchedulingSummaryDTO(
      final Long id,
      final Integer projectQuantity,
      final BigDecimal schedulingTotalGrossWeight,
      final BigDecimal schedulingTotalNetWeight,
      final BigDecimal completeTotalGrossWeight,
      final BigDecimal completeTotalNetWeight
   ) {
      this.id = id;
      this.projectQuantity = projectQuantity;
      this.schedulingTotalGrossWeight = schedulingTotalGrossWeight;
      this.schedulingTotalNetWeight = schedulingTotalNetWeight;
      this.completeTotalGrossWeight = completeTotalGrossWeight;
      this.completeTotalNetWeight = completeTotalNetWeight;
   }

   public static ArtifactSchedulingSummaryDTO.ArtifactSchedulingSummaryDTOBuilder builder() {
      return new ArtifactSchedulingSummaryDTO.ArtifactSchedulingSummaryDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getProjectQuantity() {
      return this.projectQuantity;
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

   @JsonProperty("id")
   public ArtifactSchedulingSummaryDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectQuantity")
   public ArtifactSchedulingSummaryDTO setProjectQuantity(final Integer projectQuantity) {
      this.projectQuantity = projectQuantity;
      return this;
   }

   @JsonProperty("schedulingTotalGrossWeight")
   public ArtifactSchedulingSummaryDTO setSchedulingTotalGrossWeight(final BigDecimal schedulingTotalGrossWeight) {
      this.schedulingTotalGrossWeight = schedulingTotalGrossWeight;
      return this;
   }

   @JsonProperty("schedulingTotalNetWeight")
   public ArtifactSchedulingSummaryDTO setSchedulingTotalNetWeight(final BigDecimal schedulingTotalNetWeight) {
      this.schedulingTotalNetWeight = schedulingTotalNetWeight;
      return this;
   }

   @JsonProperty("completeTotalGrossWeight")
   public ArtifactSchedulingSummaryDTO setCompleteTotalGrossWeight(final BigDecimal completeTotalGrossWeight) {
      this.completeTotalGrossWeight = completeTotalGrossWeight;
      return this;
   }

   @JsonProperty("completeTotalNetWeight")
   public ArtifactSchedulingSummaryDTO setCompleteTotalNetWeight(final BigDecimal completeTotalNetWeight) {
      this.completeTotalNetWeight = completeTotalNetWeight;
      return this;
   }

   @Override
   public String toString() {
      return "ArtifactSchedulingSummaryDTO(id="
         + this.getId()
         + ", projectQuantity="
         + this.getProjectQuantity()
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

      if (!(o instanceof ArtifactSchedulingSummaryDTO)) {
         return false;
      }

      ArtifactSchedulingSummaryDTO other = (ArtifactSchedulingSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectQuantity = this.getProjectQuantity();
         Object other$projectQuantity = other.getProjectQuantity();
         if (this$projectQuantity == null ? other$projectQuantity == null : this$projectQuantity.equals(other$projectQuantity)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactSchedulingSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectQuantity = this.getProjectQuantity();
      result = result * 59 + ($projectQuantity == null ? 43 : $projectQuantity.hashCode());
      Object $schedulingTotalGrossWeight = this.getSchedulingTotalGrossWeight();
      result = result * 59 + ($schedulingTotalGrossWeight == null ? 43 : $schedulingTotalGrossWeight.hashCode());
      Object $schedulingTotalNetWeight = this.getSchedulingTotalNetWeight();
      result = result * 59 + ($schedulingTotalNetWeight == null ? 43 : $schedulingTotalNetWeight.hashCode());
      Object $completeTotalGrossWeight = this.getCompleteTotalGrossWeight();
      result = result * 59 + ($completeTotalGrossWeight == null ? 43 : $completeTotalGrossWeight.hashCode());
      Object $completeTotalNetWeight = this.getCompleteTotalNetWeight();
      return result * 59 + ($completeTotalNetWeight == null ? 43 : $completeTotalNetWeight.hashCode());
   }

   public static class ArtifactSchedulingSummaryDTOBuilder {
      private Long id;
      private Integer projectQuantity;
      private BigDecimal schedulingTotalGrossWeight;
      private BigDecimal schedulingTotalNetWeight;
      private BigDecimal completeTotalGrossWeight;
      private BigDecimal completeTotalNetWeight;

      ArtifactSchedulingSummaryDTOBuilder() {
      }

      @JsonProperty("id")
      public ArtifactSchedulingSummaryDTO.ArtifactSchedulingSummaryDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectQuantity")
      public ArtifactSchedulingSummaryDTO.ArtifactSchedulingSummaryDTOBuilder projectQuantity(final Integer projectQuantity) {
         this.projectQuantity = projectQuantity;
         return this;
      }

      @JsonProperty("schedulingTotalGrossWeight")
      public ArtifactSchedulingSummaryDTO.ArtifactSchedulingSummaryDTOBuilder schedulingTotalGrossWeight(final BigDecimal schedulingTotalGrossWeight) {
         this.schedulingTotalGrossWeight = schedulingTotalGrossWeight;
         return this;
      }

      @JsonProperty("schedulingTotalNetWeight")
      public ArtifactSchedulingSummaryDTO.ArtifactSchedulingSummaryDTOBuilder schedulingTotalNetWeight(final BigDecimal schedulingTotalNetWeight) {
         this.schedulingTotalNetWeight = schedulingTotalNetWeight;
         return this;
      }

      @JsonProperty("completeTotalGrossWeight")
      public ArtifactSchedulingSummaryDTO.ArtifactSchedulingSummaryDTOBuilder completeTotalGrossWeight(final BigDecimal completeTotalGrossWeight) {
         this.completeTotalGrossWeight = completeTotalGrossWeight;
         return this;
      }

      @JsonProperty("completeTotalNetWeight")
      public ArtifactSchedulingSummaryDTO.ArtifactSchedulingSummaryDTOBuilder completeTotalNetWeight(final BigDecimal completeTotalNetWeight) {
         this.completeTotalNetWeight = completeTotalNetWeight;
         return this;
      }

      public ArtifactSchedulingSummaryDTO build() {
         return new ArtifactSchedulingSummaryDTO(
            this.id,
            this.projectQuantity,
            this.schedulingTotalGrossWeight,
            this.schedulingTotalNetWeight,
            this.completeTotalGrossWeight,
            this.completeTotalNetWeight
         );
      }

      @Override
      public String toString() {
         return "ArtifactSchedulingSummaryDTO.ArtifactSchedulingSummaryDTOBuilder(id="
            + this.id
            + ", projectQuantity="
            + this.projectQuantity
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
