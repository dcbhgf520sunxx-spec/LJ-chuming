package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProjectSummaryDTO", description = "项目汇总信息 ")
public class ProjectSummaryDTO {
   @ApiModelProperty(name = "projectQuantity", notes = "项目总个数")
   @JsonProperty("projectQuantity")
   @JSONField(name = "projectQuantity")
   private Integer projectQuantity;
   @ApiModelProperty(name = "projectQuantityWeight", notes = "项目总量")
   @JsonProperty("projectQuantityWeight")
   @JSONField(name = "projectQuantityWeight")
   private BigDecimal projectQuantityWeight;
   @ApiModelProperty(name = "schedulingTotalNetWeight", notes = "排产量")
   @JsonProperty("schedulingTotalNetWeight")
   @JSONField(name = "schedulingTotalNetWeight")
   private BigDecimal schedulingTotalNetWeight;
   @ApiModelProperty(name = "unSchedulingTotalNetWeight", notes = "未排产")
   @JsonProperty("unSchedulingTotalNetWeight")
   @JSONField(name = "unSchedulingTotalNetWeight")
   private BigDecimal unSchedulingTotalNetWeight;

   public static ProjectSummaryDTO.ProjectSummaryDTOBuilder builder() {
      return new ProjectSummaryDTO.ProjectSummaryDTOBuilder();
   }

   public ProjectSummaryDTO() {
   }

   public ProjectSummaryDTO(
      final Integer projectQuantity,
      final BigDecimal projectQuantityWeight,
      final BigDecimal schedulingTotalNetWeight,
      final BigDecimal unSchedulingTotalNetWeight
   ) {
      this.projectQuantity = projectQuantity;
      this.projectQuantityWeight = projectQuantityWeight;
      this.schedulingTotalNetWeight = schedulingTotalNetWeight;
      this.unSchedulingTotalNetWeight = unSchedulingTotalNetWeight;
   }

   public Integer getProjectQuantity() {
      return this.projectQuantity;
   }

   public BigDecimal getProjectQuantityWeight() {
      return this.projectQuantityWeight;
   }

   public BigDecimal getSchedulingTotalNetWeight() {
      return this.schedulingTotalNetWeight;
   }

   public BigDecimal getUnSchedulingTotalNetWeight() {
      return this.unSchedulingTotalNetWeight;
   }

   @JsonProperty("projectQuantity")
   public ProjectSummaryDTO setProjectQuantity(final Integer projectQuantity) {
      this.projectQuantity = projectQuantity;
      return this;
   }

   @JsonProperty("projectQuantityWeight")
   public ProjectSummaryDTO setProjectQuantityWeight(final BigDecimal projectQuantityWeight) {
      this.projectQuantityWeight = projectQuantityWeight;
      return this;
   }

   @JsonProperty("schedulingTotalNetWeight")
   public ProjectSummaryDTO setSchedulingTotalNetWeight(final BigDecimal schedulingTotalNetWeight) {
      this.schedulingTotalNetWeight = schedulingTotalNetWeight;
      return this;
   }

   @JsonProperty("unSchedulingTotalNetWeight")
   public ProjectSummaryDTO setUnSchedulingTotalNetWeight(final BigDecimal unSchedulingTotalNetWeight) {
      this.unSchedulingTotalNetWeight = unSchedulingTotalNetWeight;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectSummaryDTO(projectQuantity="
         + this.getProjectQuantity()
         + ", projectQuantityWeight="
         + this.getProjectQuantityWeight()
         + ", schedulingTotalNetWeight="
         + this.getSchedulingTotalNetWeight()
         + ", unSchedulingTotalNetWeight="
         + this.getUnSchedulingTotalNetWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSummaryDTO)) {
         return false;
      }

      ProjectSummaryDTO other = (ProjectSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectQuantity = this.getProjectQuantity();
      Object other$projectQuantity = other.getProjectQuantity();
      if (this$projectQuantity == null ? other$projectQuantity == null : this$projectQuantity.equals(other$projectQuantity)) {
         Object this$projectQuantityWeight = this.getProjectQuantityWeight();
         Object other$projectQuantityWeight = other.getProjectQuantityWeight();
         if (this$projectQuantityWeight == null ? other$projectQuantityWeight == null : this$projectQuantityWeight.equals(other$projectQuantityWeight)) {
            Object this$schedulingTotalNetWeight = this.getSchedulingTotalNetWeight();
            Object other$schedulingTotalNetWeight = other.getSchedulingTotalNetWeight();
            if (this$schedulingTotalNetWeight == null
               ? other$schedulingTotalNetWeight == null
               : this$schedulingTotalNetWeight.equals(other$schedulingTotalNetWeight)) {
               Object this$unSchedulingTotalNetWeight = this.getUnSchedulingTotalNetWeight();
               Object other$unSchedulingTotalNetWeight = other.getUnSchedulingTotalNetWeight();
               return this$unSchedulingTotalNetWeight == null
                  ? other$unSchedulingTotalNetWeight == null
                  : this$unSchedulingTotalNetWeight.equals(other$unSchedulingTotalNetWeight);
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
      return other instanceof ProjectSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectQuantity = this.getProjectQuantity();
      result = result * 59 + ($projectQuantity == null ? 43 : $projectQuantity.hashCode());
      Object $projectQuantityWeight = this.getProjectQuantityWeight();
      result = result * 59 + ($projectQuantityWeight == null ? 43 : $projectQuantityWeight.hashCode());
      Object $schedulingTotalNetWeight = this.getSchedulingTotalNetWeight();
      result = result * 59 + ($schedulingTotalNetWeight == null ? 43 : $schedulingTotalNetWeight.hashCode());
      Object $unSchedulingTotalNetWeight = this.getUnSchedulingTotalNetWeight();
      return result * 59 + ($unSchedulingTotalNetWeight == null ? 43 : $unSchedulingTotalNetWeight.hashCode());
   }

   public static class ProjectSummaryDTOBuilder {
      private Integer projectQuantity;
      private BigDecimal projectQuantityWeight;
      private BigDecimal schedulingTotalNetWeight;
      private BigDecimal unSchedulingTotalNetWeight;

      ProjectSummaryDTOBuilder() {
      }

      @JsonProperty("projectQuantity")
      public ProjectSummaryDTO.ProjectSummaryDTOBuilder projectQuantity(final Integer projectQuantity) {
         this.projectQuantity = projectQuantity;
         return this;
      }

      @JsonProperty("projectQuantityWeight")
      public ProjectSummaryDTO.ProjectSummaryDTOBuilder projectQuantityWeight(final BigDecimal projectQuantityWeight) {
         this.projectQuantityWeight = projectQuantityWeight;
         return this;
      }

      @JsonProperty("schedulingTotalNetWeight")
      public ProjectSummaryDTO.ProjectSummaryDTOBuilder schedulingTotalNetWeight(final BigDecimal schedulingTotalNetWeight) {
         this.schedulingTotalNetWeight = schedulingTotalNetWeight;
         return this;
      }

      @JsonProperty("unSchedulingTotalNetWeight")
      public ProjectSummaryDTO.ProjectSummaryDTOBuilder unSchedulingTotalNetWeight(final BigDecimal unSchedulingTotalNetWeight) {
         this.unSchedulingTotalNetWeight = unSchedulingTotalNetWeight;
         return this;
      }

      public ProjectSummaryDTO build() {
         return new ProjectSummaryDTO(this.projectQuantity, this.projectQuantityWeight, this.schedulingTotalNetWeight, this.unSchedulingTotalNetWeight);
      }

      @Override
      public String toString() {
         return "ProjectSummaryDTO.ProjectSummaryDTOBuilder(projectQuantity="
            + this.projectQuantity
            + ", projectQuantityWeight="
            + this.projectQuantityWeight
            + ", schedulingTotalNetWeight="
            + this.schedulingTotalNetWeight
            + ", unSchedulingTotalNetWeight="
            + this.unSchedulingTotalNetWeight
            + ")";
      }
   }
}
