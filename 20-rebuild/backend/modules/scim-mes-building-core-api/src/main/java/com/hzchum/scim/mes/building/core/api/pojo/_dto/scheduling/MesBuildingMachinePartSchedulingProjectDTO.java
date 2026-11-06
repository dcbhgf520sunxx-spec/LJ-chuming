package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.util.ProjectDetailDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "MesBuildingMachinePartSchedulingProjectDTO", description = "可排产项目信息")
public class MesBuildingMachinePartSchedulingProjectDTO {
   @ApiModelProperty(name = "project", value = "项目信息")
   @JsonProperty("project")
   @JSONField(name = "project")
   private ProjectDetailDO project;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "totalNetWeight", value = "总净重量")
   @JsonProperty("totalNetWeight")
   @JSONField(name = "totalNetWeight")
   private BigDecimal totalNetWeight;

   public static MesBuildingMachinePartSchedulingProjectDTO.MesBuildingMachinePartSchedulingProjectDTOBuilder builder() {
      return new MesBuildingMachinePartSchedulingProjectDTO.MesBuildingMachinePartSchedulingProjectDTOBuilder();
   }

   public MesBuildingMachinePartSchedulingProjectDTO(final ProjectDetailDO project, final Integer quantity, final BigDecimal totalNetWeight) {
      this.project = project;
      this.quantity = quantity;
      this.totalNetWeight = totalNetWeight;
   }

   public MesBuildingMachinePartSchedulingProjectDTO() {
   }

   public ProjectDetailDO getProject() {
      return this.project;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   @JsonProperty("project")
   public MesBuildingMachinePartSchedulingProjectDTO setProject(final ProjectDetailDO project) {
      this.project = project;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingMachinePartSchedulingProjectDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("totalNetWeight")
   public MesBuildingMachinePartSchedulingProjectDTO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingMachinePartSchedulingProjectDTO(project="
         + this.getProject()
         + ", quantity="
         + this.getQuantity()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingMachinePartSchedulingProjectDTO)) {
         return false;
      }

      MesBuildingMachinePartSchedulingProjectDTO other = (MesBuildingMachinePartSchedulingProjectDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$project = this.getProject();
         Object other$project = other.getProject();
         if (this$project == null ? other$project == null : this$project.equals(other$project)) {
            Object this$totalNetWeight = this.getTotalNetWeight();
            Object other$totalNetWeight = other.getTotalNetWeight();
            return this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingMachinePartSchedulingProjectDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      return result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
   }

   public static class MesBuildingMachinePartSchedulingProjectDTOBuilder {
      private ProjectDetailDO project;
      private Integer quantity;
      private BigDecimal totalNetWeight;

      MesBuildingMachinePartSchedulingProjectDTOBuilder() {
      }

      @JsonProperty("project")
      public MesBuildingMachinePartSchedulingProjectDTO.MesBuildingMachinePartSchedulingProjectDTOBuilder project(final ProjectDetailDO project) {
         this.project = project;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingMachinePartSchedulingProjectDTO.MesBuildingMachinePartSchedulingProjectDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("totalNetWeight")
      public MesBuildingMachinePartSchedulingProjectDTO.MesBuildingMachinePartSchedulingProjectDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public MesBuildingMachinePartSchedulingProjectDTO build() {
         return new MesBuildingMachinePartSchedulingProjectDTO(this.project, this.quantity, this.totalNetWeight);
      }

      @Override
      public String toString() {
         return "MesBuildingMachinePartSchedulingProjectDTO.MesBuildingMachinePartSchedulingProjectDTOBuilder(project="
            + this.project
            + ", quantity="
            + this.quantity
            + ", totalNetWeight="
            + this.totalNetWeight
            + ")";
      }
   }
}
