package com.hzchum.scim.project.core.api.pojo.daoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel("收货看板查询类")
public class ReceivingBoardQueryDOParam {
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @NotNull(message = "项目id不能为空")
   private Long projectId;
   @ApiModelProperty(name = "projectType", value = "项目类型", notes = "项目类型")
   private Integer projectType;
   @ApiModelProperty(name = "productType", value = "产品类型 2构件 4围护 8配套件", notes = "产品类型 2构件 4围护 8配套件")
   private Integer productType;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   private Long monomerId;
   @ApiModelProperty(name = "category", value = "围护分类", notes = "围护分类")
   private Integer category;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   private Long areaId;
   @ApiModelProperty(name = "name", value = "产品名称", notes = "产品名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "产品编号", notes = "产品编号")
   private String serialNumber;
   @ApiModelProperty(name = "receivingStatus", value = "收货状态 0未收货 1部分收货 2完全收货", notes = "收货状态")
   private Integer receivingStatus;

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public Integer getProductType() {
      return this.productType;
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

   public Integer getReceivingStatus() {
      return this.receivingStatus;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
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

   public void setReceivingStatus(final Integer receivingStatus) {
      this.receivingStatus = receivingStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReceivingBoardQueryDOParam)) {
         return false;
      }

      ReceivingBoardQueryDOParam other = (ReceivingBoardQueryDOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$projectType = this.getProjectType();
         Object other$projectType = other.getProjectType();
         if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$monomerId = this.getMonomerId();
               Object other$monomerId = other.getMonomerId();
               if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                  Object this$category = this.getCategory();
                  Object other$category = other.getCategory();
                  if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                     Object this$areaId = this.getAreaId();
                     Object other$areaId = other.getAreaId();
                     if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                        Object this$receivingStatus = this.getReceivingStatus();
                        Object other$receivingStatus = other.getReceivingStatus();
                        if (this$receivingStatus == null ? other$receivingStatus == null : this$receivingStatus.equals(other$receivingStatus)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              return this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber);
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
      return other instanceof ReceivingBoardQueryDOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $receivingStatus = this.getReceivingStatus();
      result = result * 59 + ($receivingStatus == null ? 43 : $receivingStatus.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "ReceivingBoardQueryDOParam(projectId="
         + this.getProjectId()
         + ", projectType="
         + this.getProjectType()
         + ", productType="
         + this.getProductType()
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
         + ", receivingStatus="
         + this.getReceivingStatus()
         + ")";
   }
}
