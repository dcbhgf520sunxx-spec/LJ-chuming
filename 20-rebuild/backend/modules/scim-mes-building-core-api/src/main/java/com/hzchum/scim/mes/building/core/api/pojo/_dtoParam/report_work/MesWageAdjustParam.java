package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@ApiModel("工价调整新增修改param")
public class MesWageAdjustParam {
   @ApiModelProperty("项目id")
   @NotNull(message = "项目不能为空")
   private Long projectId;
   @ApiModelProperty("单体id")
   @NotNull(message = "单体不能为空")
   private Long monomerId;
   @ApiModelProperty("产品类型")
   @NotNull(message = "产品类型不能为空")
   private Integer productTypeEnum;
   @ApiModelProperty("车间id")
   @NotNull(message = "车间不能为空")
   private Long workshopId;
   @ApiModelProperty("工序id")
   @NotNull(message = "工序不能为空")
   private Long processId;
   @ApiModelProperty("班组id列表")
   private List<Long> teamIdList;
   @ApiModelProperty("产品列表")
   @Valid
   private List<MesWageAdjustProductParamV2> productList;

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Integer getProductTypeEnum() {
      return this.productTypeEnum;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public List<Long> getTeamIdList() {
      return this.teamIdList;
   }

   public List<MesWageAdjustProductParamV2> getProductList() {
      return this.productList;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setProductTypeEnum(final Integer productTypeEnum) {
      this.productTypeEnum = productTypeEnum;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setTeamIdList(final List<Long> teamIdList) {
      this.teamIdList = teamIdList;
   }

   public void setProductList(final List<MesWageAdjustProductParamV2> productList) {
      this.productList = productList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesWageAdjustParam)) {
         return false;
      }

      MesWageAdjustParam other = (MesWageAdjustParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$productTypeEnum = this.getProductTypeEnum();
            Object other$productTypeEnum = other.getProductTypeEnum();
            if (this$productTypeEnum == null ? other$productTypeEnum == null : this$productTypeEnum.equals(other$productTypeEnum)) {
               Object this$workshopId = this.getWorkshopId();
               Object other$workshopId = other.getWorkshopId();
               if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                  Object this$processId = this.getProcessId();
                  Object other$processId = other.getProcessId();
                  if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                     Object this$teamIdList = this.getTeamIdList();
                     Object other$teamIdList = other.getTeamIdList();
                     if (this$teamIdList == null ? other$teamIdList == null : this$teamIdList.equals(other$teamIdList)) {
                        Object this$productList = this.getProductList();
                        Object other$productList = other.getProductList();
                        return this$productList == null ? other$productList == null : this$productList.equals(other$productList);
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
      return other instanceof MesWageAdjustParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $productTypeEnum = this.getProductTypeEnum();
      result = result * 59 + ($productTypeEnum == null ? 43 : $productTypeEnum.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $teamIdList = this.getTeamIdList();
      result = result * 59 + ($teamIdList == null ? 43 : $teamIdList.hashCode());
      Object $productList = this.getProductList();
      return result * 59 + ($productList == null ? 43 : $productList.hashCode());
   }

   @Override
   public String toString() {
      return "MesWageAdjustParam(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", productTypeEnum="
         + this.getProductTypeEnum()
         + ", workshopId="
         + this.getWorkshopId()
         + ", processId="
         + this.getProcessId()
         + ", teamIdList="
         + this.getTeamIdList()
         + ", productList="
         + this.getProductList()
         + ")";
   }
}
