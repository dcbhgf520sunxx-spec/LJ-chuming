package com.hzchum.scim.project.core.api.pojo.dtoParam.sub;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "ProjectLaborOrderDTOParam", description = "安装清单划分请求类")
public class ProjectLaborOrderDTOParam {
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @NotNull(message = "项目id不能为空!!!")
   private Long projectId;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @NotNull(message = "区域/批次id不能为空!!!")
   private Long areaId;
   @ApiModelProperty(name = "productType", notes = "产品类型")
   @NotNull(message = "产品类型不能为空!!!")
   @EnumValidator(value = ProductTypeEnum.class, message = "产品类型不正确")
   private Integer productType;
   @ApiModelProperty(name = "supplierId", value = "供应商id", notes = "供应商id")
   @NotNull(message = "供应商不能为空!!!")
   private Long supplierId;
   @ApiModelProperty(name = "productParamList", notes = "产品划分信息")
   @Valid
   @NotEmpty(message = "产品划分信息不能为空！")
   private List<ProjectLaborProductDTOParam> productParamList;

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public List<ProjectLaborProductDTOParam> getProductParamList() {
      return this.productParamList;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setProductParamList(final List<ProjectLaborProductDTOParam> productParamList) {
      this.productParamList = productParamList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectLaborOrderDTOParam)) {
         return false;
      }

      ProjectLaborOrderDTOParam other = (ProjectLaborOrderDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$areaId = this.getAreaId();
         Object other$areaId = other.getAreaId();
         if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$supplierId = this.getSupplierId();
               Object other$supplierId = other.getSupplierId();
               if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                  Object this$productParamList = this.getProductParamList();
                  Object other$productParamList = other.getProductParamList();
                  return this$productParamList == null ? other$productParamList == null : this$productParamList.equals(other$productParamList);
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
      return other instanceof ProjectLaborOrderDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $productParamList = this.getProductParamList();
      return result * 59 + ($productParamList == null ? 43 : $productParamList.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectLaborOrderDTOParam(projectId="
         + this.getProjectId()
         + ", areaId="
         + this.getAreaId()
         + ", productType="
         + this.getProductType()
         + ", supplierId="
         + this.getSupplierId()
         + ", productParamList="
         + this.getProductParamList()
         + ")";
   }
}
