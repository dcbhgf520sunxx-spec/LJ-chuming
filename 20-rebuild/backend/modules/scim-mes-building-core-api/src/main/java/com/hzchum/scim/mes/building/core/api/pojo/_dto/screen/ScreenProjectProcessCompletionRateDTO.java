package com.hzchum.scim.mes.building.core.api.pojo._dto.screen;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ScreenProjectProcessCompletionRateDTO", description = "构建，零件，部件工序完成率")
public class ScreenProjectProcessCompletionRateDTO {
   @ApiModelProperty(name = "productTaskName", notes = "产品工序名称（零件，构件，部件）")
   private String productTaskName;
   @ApiModelProperty(name = "taskTypeName", notes = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "quantity", notes = "任务总数（重量）")
   private Double quantity;
   @ApiModelProperty(name = "inspectionQuantity", notes = "任务完成数（重量）")
   private Double inspectionQuantity;

   public static ScreenProjectProcessCompletionRateDTO.ScreenProjectProcessCompletionRateDTOBuilder builder() {
      return new ScreenProjectProcessCompletionRateDTO.ScreenProjectProcessCompletionRateDTOBuilder();
   }

   public ScreenProjectProcessCompletionRateDTO() {
   }

   public ScreenProjectProcessCompletionRateDTO(final String productTaskName, final String projectName, final Double quantity, final Double inspectionQuantity) {
      this.productTaskName = productTaskName;
      this.projectName = projectName;
      this.quantity = quantity;
      this.inspectionQuantity = inspectionQuantity;
   }

   public String getProductTaskName() {
      return this.productTaskName;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Double getQuantity() {
      return this.quantity;
   }

   public Double getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public ScreenProjectProcessCompletionRateDTO setProductTaskName(final String productTaskName) {
      this.productTaskName = productTaskName;
      return this;
   }

   public ScreenProjectProcessCompletionRateDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public ScreenProjectProcessCompletionRateDTO setQuantity(final Double quantity) {
      this.quantity = quantity;
      return this;
   }

   public ScreenProjectProcessCompletionRateDTO setInspectionQuantity(final Double inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "ScreenProjectProcessCompletionRateDTO(productTaskName="
         + this.getProductTaskName()
         + ", projectName="
         + this.getProjectName()
         + ", quantity="
         + this.getQuantity()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ScreenProjectProcessCompletionRateDTO)) {
         return false;
      }

      ScreenProjectProcessCompletionRateDTO other = (ScreenProjectProcessCompletionRateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$inspectionQuantity = this.getInspectionQuantity();
         Object other$inspectionQuantity = other.getInspectionQuantity();
         if (this$inspectionQuantity == null ? other$inspectionQuantity == null : this$inspectionQuantity.equals(other$inspectionQuantity)) {
            Object this$productTaskName = this.getProductTaskName();
            Object other$productTaskName = other.getProductTaskName();
            if (this$productTaskName == null ? other$productTaskName == null : this$productTaskName.equals(other$productTaskName)) {
               Object this$projectName = this.getProjectName();
               Object other$projectName = other.getProjectName();
               return this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName);
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
      return other instanceof ScreenProjectProcessCompletionRateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $productTaskName = this.getProductTaskName();
      result = result * 59 + ($productTaskName == null ? 43 : $productTaskName.hashCode());
      Object $projectName = this.getProjectName();
      return result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
   }

   public static class ScreenProjectProcessCompletionRateDTOBuilder {
      private String productTaskName;
      private String projectName;
      private Double quantity;
      private Double inspectionQuantity;

      ScreenProjectProcessCompletionRateDTOBuilder() {
      }

      public ScreenProjectProcessCompletionRateDTO.ScreenProjectProcessCompletionRateDTOBuilder productTaskName(final String productTaskName) {
         this.productTaskName = productTaskName;
         return this;
      }

      public ScreenProjectProcessCompletionRateDTO.ScreenProjectProcessCompletionRateDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public ScreenProjectProcessCompletionRateDTO.ScreenProjectProcessCompletionRateDTOBuilder quantity(final Double quantity) {
         this.quantity = quantity;
         return this;
      }

      public ScreenProjectProcessCompletionRateDTO.ScreenProjectProcessCompletionRateDTOBuilder inspectionQuantity(final Double inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      public ScreenProjectProcessCompletionRateDTO build() {
         return new ScreenProjectProcessCompletionRateDTO(this.productTaskName, this.projectName, this.quantity, this.inspectionQuantity);
      }

      @Override
      public String toString() {
         return "ScreenProjectProcessCompletionRateDTO.ScreenProjectProcessCompletionRateDTOBuilder(productTaskName="
            + this.productTaskName
            + ", projectName="
            + this.projectName
            + ", quantity="
            + this.quantity
            + ", inspectionQuantity="
            + this.inspectionQuantity
            + ")";
      }
   }
}
