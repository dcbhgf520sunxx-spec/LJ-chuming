package com.hzchum.scim.mes.building.core.api.pojo._doParam.productionAnalysis;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class ProjectMaterialRequisitionAnalysisDOParam {
   @ApiModelProperty(name = "projectId", value = "项目id")
   @NotNull(message = "项目Id不可为空")
   private Long projectId;
   @ApiModelProperty(name = "workShopId", value = "车间Id")
   private Long workShopId;
   @ApiModelProperty(name = "productClassificationEnum", value = "零件分类 4.成品型材 8.钢板")
   private Integer productClassificationEnum;

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getWorkShopId() {
      return this.workShopId;
   }

   public Integer getProductClassificationEnum() {
      return this.productClassificationEnum;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setWorkShopId(final Long workShopId) {
      this.workShopId = workShopId;
   }

   public void setProductClassificationEnum(final Integer productClassificationEnum) {
      this.productClassificationEnum = productClassificationEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectMaterialRequisitionAnalysisDOParam)) {
         return false;
      }

      ProjectMaterialRequisitionAnalysisDOParam other = (ProjectMaterialRequisitionAnalysisDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$workShopId = this.getWorkShopId();
         Object other$workShopId = other.getWorkShopId();
         if (this$workShopId == null ? other$workShopId == null : this$workShopId.equals(other$workShopId)) {
            Object this$productClassificationEnum = this.getProductClassificationEnum();
            Object other$productClassificationEnum = other.getProductClassificationEnum();
            return this$productClassificationEnum == null
               ? other$productClassificationEnum == null
               : this$productClassificationEnum.equals(other$productClassificationEnum);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectMaterialRequisitionAnalysisDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $workShopId = this.getWorkShopId();
      result = result * 59 + ($workShopId == null ? 43 : $workShopId.hashCode());
      Object $productClassificationEnum = this.getProductClassificationEnum();
      return result * 59 + ($productClassificationEnum == null ? 43 : $productClassificationEnum.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectMaterialRequisitionAnalysisDOParam(projectId="
         + this.getProjectId()
         + ", workShopId="
         + this.getWorkShopId()
         + ", productClassificationEnum="
         + this.getProductClassificationEnum()
         + ")";
   }
}
