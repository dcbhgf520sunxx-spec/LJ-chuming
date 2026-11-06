package com.hzchum.scim.project.core.api.pojo.dtoParam.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel("基础查询类")
public class ProjectBaseQueryDTOParam {
   @ApiModelProperty(name = "productType", value = "产品类型 建钢: 2构件 4围护 8配套件 桥梁:1箱体件 2单元件 4零件 8配套件")
   @NotNull(message = "产品类型不能为空")
   private Integer productType;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   private Long monomerId;
   @ApiModelProperty(name = "category", value = "围护分类:2", notes = "围护分类")
   private Integer category;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   private Long areaId;
   @ApiModelProperty(name = "name", value = "产品名称", notes = "产品名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "产品编号", notes = "产品编号")
   private String serialNumber;
   @ApiModelProperty(name = "supplierName", value = "供应商", notes = "供应商")
   private String supplierName;
   @ApiModelProperty(name = "supplierId", value = "供应商", notes = "供应商")
   private Long supplierId;
   @ApiModelProperty(name = "areaIds", value = "供应商负责区域", notes = "供应商负责区域")
   private List<Long> areaIds;

   public Integer getProductType() {
      return this.productType;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public List<Long> getAreaIds() {
      return this.areaIds;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setAreaIds(final List<Long> areaIds) {
      this.areaIds = areaIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectBaseQueryDTOParam)) {
         return false;
      }

      ProjectBaseQueryDTOParam other = (ProjectBaseQueryDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productType = this.getProductType();
      Object other$productType = other.getProductType();
      if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$category = this.getCategory();
               Object other$category = other.getCategory();
               if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                  Object this$areaId = this.getAreaId();
                  Object other$areaId = other.getAreaId();
                  if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                     Object this$supplierId = this.getSupplierId();
                     Object other$supplierId = other.getSupplierId();
                     if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                        Object this$name = this.getName();
                        Object other$name = other.getName();
                        if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                              Object this$supplierName = this.getSupplierName();
                              Object other$supplierName = other.getSupplierName();
                              if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                                 Object this$areaIds = this.getAreaIds();
                                 Object other$areaIds = other.getAreaIds();
                                 return this$areaIds == null ? other$areaIds == null : this$areaIds.equals(other$areaIds);
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
      return other instanceof ProjectBaseQueryDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $areaIds = this.getAreaIds();
      return result * 59 + ($areaIds == null ? 43 : $areaIds.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectBaseQueryDTOParam(productType="
         + this.getProductType()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", category="
         + this.getCategory()
         + ", areaId="
         + this.getAreaId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", supplierName="
         + this.getSupplierName()
         + ", supplierId="
         + this.getSupplierId()
         + ", areaIds="
         + this.getAreaIds()
         + ")";
   }
}
