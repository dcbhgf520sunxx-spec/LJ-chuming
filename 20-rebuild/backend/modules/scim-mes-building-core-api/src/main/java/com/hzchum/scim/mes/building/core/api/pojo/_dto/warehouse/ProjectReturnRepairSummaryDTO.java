package com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;

public class ProjectReturnRepairSummaryDTO {
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   private Integer productType;
   @ApiModelProperty(name = "handleMethod", value = "处理方式", notes = "处理方式")
   private Integer handleMethod;
   @ApiModelProperty(name = "returnQuantity", value = "返修数量", notes = "返修数量")
   private Integer returnQuantity;
   @ApiModelProperty(name = "shipQuantity", value = "已发运数量", notes = "已发运数量")
   private Integer shipQuantity;
   @ApiModelProperty(name = "returnShipStatus", value = "返修发运状态 1.未发运 2.发运中 4.发运完毕", notes = "返修发运状态")
   private Integer returnShipStatus;

   public static ProjectReturnRepairSummaryDTO.ProjectReturnRepairSummaryDTOBuilder builder() {
      return new ProjectReturnRepairSummaryDTO.ProjectReturnRepairSummaryDTOBuilder();
   }

   public ProjectReturnRepairSummaryDTO() {
   }

   public ProjectReturnRepairSummaryDTO(
      final ProjectInfo project,
      final Integer productType,
      final Integer handleMethod,
      final Integer returnQuantity,
      final Integer shipQuantity,
      final Integer returnShipStatus
   ) {
      this.project = project;
      this.productType = productType;
      this.handleMethod = handleMethod;
      this.returnQuantity = returnQuantity;
      this.shipQuantity = shipQuantity;
      this.returnShipStatus = returnShipStatus;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getHandleMethod() {
      return this.handleMethod;
   }

   public Integer getReturnQuantity() {
      return this.returnQuantity;
   }

   public Integer getShipQuantity() {
      return this.shipQuantity;
   }

   public Integer getReturnShipStatus() {
      return this.returnShipStatus;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setHandleMethod(final Integer handleMethod) {
      this.handleMethod = handleMethod;
   }

   public void setReturnQuantity(final Integer returnQuantity) {
      this.returnQuantity = returnQuantity;
   }

   public void setShipQuantity(final Integer shipQuantity) {
      this.shipQuantity = shipQuantity;
   }

   public void setReturnShipStatus(final Integer returnShipStatus) {
      this.returnShipStatus = returnShipStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectReturnRepairSummaryDTO)) {
         return false;
      }

      ProjectReturnRepairSummaryDTO other = (ProjectReturnRepairSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productType = this.getProductType();
      Object other$productType = other.getProductType();
      if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
         Object this$handleMethod = this.getHandleMethod();
         Object other$handleMethod = other.getHandleMethod();
         if (this$handleMethod == null ? other$handleMethod == null : this$handleMethod.equals(other$handleMethod)) {
            Object this$returnQuantity = this.getReturnQuantity();
            Object other$returnQuantity = other.getReturnQuantity();
            if (this$returnQuantity == null ? other$returnQuantity == null : this$returnQuantity.equals(other$returnQuantity)) {
               Object this$shipQuantity = this.getShipQuantity();
               Object other$shipQuantity = other.getShipQuantity();
               if (this$shipQuantity == null ? other$shipQuantity == null : this$shipQuantity.equals(other$shipQuantity)) {
                  Object this$returnShipStatus = this.getReturnShipStatus();
                  Object other$returnShipStatus = other.getReturnShipStatus();
                  if (this$returnShipStatus == null ? other$returnShipStatus == null : this$returnShipStatus.equals(other$returnShipStatus)) {
                     Object this$project = this.getProject();
                     Object other$project = other.getProject();
                     return this$project == null ? other$project == null : this$project.equals(other$project);
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
      return other instanceof ProjectReturnRepairSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $handleMethod = this.getHandleMethod();
      result = result * 59 + ($handleMethod == null ? 43 : $handleMethod.hashCode());
      Object $returnQuantity = this.getReturnQuantity();
      result = result * 59 + ($returnQuantity == null ? 43 : $returnQuantity.hashCode());
      Object $shipQuantity = this.getShipQuantity();
      result = result * 59 + ($shipQuantity == null ? 43 : $shipQuantity.hashCode());
      Object $returnShipStatus = this.getReturnShipStatus();
      result = result * 59 + ($returnShipStatus == null ? 43 : $returnShipStatus.hashCode());
      Object $project = this.getProject();
      return result * 59 + ($project == null ? 43 : $project.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectReturnRepairSummaryDTO(project="
         + this.getProject()
         + ", productType="
         + this.getProductType()
         + ", handleMethod="
         + this.getHandleMethod()
         + ", returnQuantity="
         + this.getReturnQuantity()
         + ", shipQuantity="
         + this.getShipQuantity()
         + ", returnShipStatus="
         + this.getReturnShipStatus()
         + ")";
   }

   public static class ProjectReturnRepairSummaryDTOBuilder {
      private ProjectInfo project;
      private Integer productType;
      private Integer handleMethod;
      private Integer returnQuantity;
      private Integer shipQuantity;
      private Integer returnShipStatus;

      ProjectReturnRepairSummaryDTOBuilder() {
      }

      public ProjectReturnRepairSummaryDTO.ProjectReturnRepairSummaryDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ProjectReturnRepairSummaryDTO.ProjectReturnRepairSummaryDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectReturnRepairSummaryDTO.ProjectReturnRepairSummaryDTOBuilder handleMethod(final Integer handleMethod) {
         this.handleMethod = handleMethod;
         return this;
      }

      public ProjectReturnRepairSummaryDTO.ProjectReturnRepairSummaryDTOBuilder returnQuantity(final Integer returnQuantity) {
         this.returnQuantity = returnQuantity;
         return this;
      }

      public ProjectReturnRepairSummaryDTO.ProjectReturnRepairSummaryDTOBuilder shipQuantity(final Integer shipQuantity) {
         this.shipQuantity = shipQuantity;
         return this;
      }

      public ProjectReturnRepairSummaryDTO.ProjectReturnRepairSummaryDTOBuilder returnShipStatus(final Integer returnShipStatus) {
         this.returnShipStatus = returnShipStatus;
         return this;
      }

      public ProjectReturnRepairSummaryDTO build() {
         return new ProjectReturnRepairSummaryDTO(
            this.project, this.productType, this.handleMethod, this.returnQuantity, this.shipQuantity, this.returnShipStatus
         );
      }

      @Override
      public String toString() {
         return "ProjectReturnRepairSummaryDTO.ProjectReturnRepairSummaryDTOBuilder(project="
            + this.project
            + ", productType="
            + this.productType
            + ", handleMethod="
            + this.handleMethod
            + ", returnQuantity="
            + this.returnQuantity
            + ", shipQuantity="
            + this.shipQuantity
            + ", returnShipStatus="
            + this.returnShipStatus
            + ")";
      }
   }
}
