package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "CAPP 焊接数据采集记录列表  查询参数")
public class CappCraftCardWeldingGatherListDTO {
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   private Integer productType;
   @ApiModelProperty(name = "weldSerialNumber", value = "焊缝编号", notes = "焊缝编号")
   private String weldSerialNumber;
   @ApiModelProperty(name = "productSerialNumber", value = "产品编号", notes = "产品编号")
   private String productSerialNumber;
   @ApiModelProperty(name = "productName", value = "产品名称", notes = "产品名称")
   private String productName;
   @ApiModelProperty(name = "techCappCraftCardStorehouseSerialNumber", value = "工艺编号")
   private String techCappCraftCardStorehouseSerialNumber;
   @ApiModelProperty(name = "pageNumber", value = "当前页码", notes = "当前页码")
   private Integer pageNumber;
   @ApiModelProperty(name = "pageSize", value = "每页数量", notes = "每页数量")
   private Integer pageSize;

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getWeldSerialNumber() {
      return this.weldSerialNumber;
   }

   public String getProductSerialNumber() {
      return this.productSerialNumber;
   }

   public String getProductName() {
      return this.productName;
   }

   public String getTechCappCraftCardStorehouseSerialNumber() {
      return this.techCappCraftCardStorehouseSerialNumber;
   }

   public Integer getPageNumber() {
      return this.pageNumber;
   }

   public Integer getPageSize() {
      return this.pageSize;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setWeldSerialNumber(final String weldSerialNumber) {
      this.weldSerialNumber = weldSerialNumber;
   }

   public void setProductSerialNumber(final String productSerialNumber) {
      this.productSerialNumber = productSerialNumber;
   }

   public void setProductName(final String productName) {
      this.productName = productName;
   }

   public void setTechCappCraftCardStorehouseSerialNumber(final String techCappCraftCardStorehouseSerialNumber) {
      this.techCappCraftCardStorehouseSerialNumber = techCappCraftCardStorehouseSerialNumber;
   }

   public void setPageNumber(final Integer pageNumber) {
      this.pageNumber = pageNumber;
   }

   public void setPageSize(final Integer pageSize) {
      this.pageSize = pageSize;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CappCraftCardWeldingGatherListDTO)) {
         return false;
      }

      CappCraftCardWeldingGatherListDTO other = (CappCraftCardWeldingGatherListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                  Object this$pageNumber = this.getPageNumber();
                  Object other$pageNumber = other.getPageNumber();
                  if (this$pageNumber == null ? other$pageNumber == null : this$pageNumber.equals(other$pageNumber)) {
                     Object this$pageSize = this.getPageSize();
                     Object other$pageSize = other.getPageSize();
                     if (this$pageSize == null ? other$pageSize == null : this$pageSize.equals(other$pageSize)) {
                        Object this$weldSerialNumber = this.getWeldSerialNumber();
                        Object other$weldSerialNumber = other.getWeldSerialNumber();
                        if (this$weldSerialNumber == null ? other$weldSerialNumber == null : this$weldSerialNumber.equals(other$weldSerialNumber)) {
                           Object this$productSerialNumber = this.getProductSerialNumber();
                           Object other$productSerialNumber = other.getProductSerialNumber();
                           if (this$productSerialNumber == null
                              ? other$productSerialNumber == null
                              : this$productSerialNumber.equals(other$productSerialNumber)) {
                              Object this$productName = this.getProductName();
                              Object other$productName = other.getProductName();
                              if (this$productName == null ? other$productName == null : this$productName.equals(other$productName)) {
                                 Object this$techCappCraftCardStorehouseSerialNumber = this.getTechCappCraftCardStorehouseSerialNumber();
                                 Object other$techCappCraftCardStorehouseSerialNumber = other.getTechCappCraftCardStorehouseSerialNumber();
                                 return this$techCappCraftCardStorehouseSerialNumber == null
                                    ? other$techCappCraftCardStorehouseSerialNumber == null
                                    : this$techCappCraftCardStorehouseSerialNumber.equals(other$techCappCraftCardStorehouseSerialNumber);
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
      return other instanceof CappCraftCardWeldingGatherListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $pageNumber = this.getPageNumber();
      result = result * 59 + ($pageNumber == null ? 43 : $pageNumber.hashCode());
      Object $pageSize = this.getPageSize();
      result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
      Object $weldSerialNumber = this.getWeldSerialNumber();
      result = result * 59 + ($weldSerialNumber == null ? 43 : $weldSerialNumber.hashCode());
      Object $productSerialNumber = this.getProductSerialNumber();
      result = result * 59 + ($productSerialNumber == null ? 43 : $productSerialNumber.hashCode());
      Object $productName = this.getProductName();
      result = result * 59 + ($productName == null ? 43 : $productName.hashCode());
      Object $techCappCraftCardStorehouseSerialNumber = this.getTechCappCraftCardStorehouseSerialNumber();
      return result * 59 + ($techCappCraftCardStorehouseSerialNumber == null ? 43 : $techCappCraftCardStorehouseSerialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardWeldingGatherListDTO(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", productType="
         + this.getProductType()
         + ", weldSerialNumber="
         + this.getWeldSerialNumber()
         + ", productSerialNumber="
         + this.getProductSerialNumber()
         + ", productName="
         + this.getProductName()
         + ", techCappCraftCardStorehouseSerialNumber="
         + this.getTechCappCraftCardStorehouseSerialNumber()
         + ", pageNumber="
         + this.getPageNumber()
         + ", pageSize="
         + this.getPageSize()
         + ")";
   }
}
