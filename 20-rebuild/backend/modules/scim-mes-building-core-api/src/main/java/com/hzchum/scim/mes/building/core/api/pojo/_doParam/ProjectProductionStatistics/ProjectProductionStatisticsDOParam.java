package com.hzchum.scim.mes.building.core.api.pojo._doParam.ProjectProductionStatistics;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class ProjectProductionStatisticsDOParam {
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "areaIdList", value = "区域Id")
   private List<Long> areaIdList;
   @ApiModelProperty(name = "productType", value = "产品类型")
   private Integer productType;
   @ApiModelProperty(name = "processId", value = "工序Id")
   private Long processId;

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public List<Long> getAreaIdList() {
      return this.areaIdList;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaIdList(final List<Long> areaIdList) {
      this.areaIdList = areaIdList;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectProductionStatisticsDOParam)) {
         return false;
      }

      ProjectProductionStatisticsDOParam other = (ProjectProductionStatisticsDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$processId = this.getProcessId();
               Object other$processId = other.getProcessId();
               if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                  Object this$areaIdList = this.getAreaIdList();
                  Object other$areaIdList = other.getAreaIdList();
                  return this$areaIdList == null ? other$areaIdList == null : this$areaIdList.equals(other$areaIdList);
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
      return other instanceof ProjectProductionStatisticsDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $areaIdList = this.getAreaIdList();
      return result * 59 + ($areaIdList == null ? 43 : $areaIdList.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectProductionStatisticsDOParam(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaIdList="
         + this.getAreaIdList()
         + ", productType="
         + this.getProductType()
         + ", processId="
         + this.getProcessId()
         + ")";
   }
}
