package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "CAPP 工艺管理 列表查询 请求参数")
public class CappCraftCardProductLinkListDTO {
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "productType", value = "产品类型参考枚举 ProductTypeEnum", notes = "产品类型参考枚举 ProductTypeEnum")
   private Integer productType;
   @ApiModelProperty(name = "productId", value = "是否绑定", notes = "是否绑定")
   private Boolean isBind;
   @ApiModelProperty(name = "craftType", value = "工艺类型参考枚举 CappCraftTypeEnum", notes = "工艺类型参考枚举 CappCraftTypeEnum")
   private Integer craftType;
   @ApiModelProperty(name = "batchNumber", value = "导入批次号")
   private String batchNumber;
   @ApiModelProperty(name = "productSpecification", value = "产品规格")
   private String productSpecification;
   @ApiModelProperty(name = "productMaterial", value = "产品材质")
   private String productMaterial;
   @ApiModelProperty(name = "weldSerialNumber", value = "焊缝编号")
   private String weldSerialNumber;
   @ApiModelProperty(name = "productName", value = "产品名称")
   private String productName;
   @ApiModelProperty(name = "productSerialNumber", value = "产品编号")
   private String productSerialNumber;
   @ApiModelProperty(name = "techCappCraftCardStorehouseSerialNumber", value = "工艺编号")
   private String techCappCraftCardStorehouseSerialNumber;
   @ApiModelProperty(name = "productDwgNum", value = "产品图号")
   private String productDwgNum;
   @ApiModelProperty(name = "pageNumber", value = "当前页码", notes = "当前页码")
   private Integer pageNumber;
   @ApiModelProperty(name = "pageSize", value = "每页条数", notes = "每页条数")
   private Integer pageSize;

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Boolean getIsBind() {
      return this.isBind;
   }

   public Integer getCraftType() {
      return this.craftType;
   }

   public String getBatchNumber() {
      return this.batchNumber;
   }

   public String getProductSpecification() {
      return this.productSpecification;
   }

   public String getProductMaterial() {
      return this.productMaterial;
   }

   public String getWeldSerialNumber() {
      return this.weldSerialNumber;
   }

   public String getProductName() {
      return this.productName;
   }

   public String getProductSerialNumber() {
      return this.productSerialNumber;
   }

   public String getTechCappCraftCardStorehouseSerialNumber() {
      return this.techCappCraftCardStorehouseSerialNumber;
   }

   public String getProductDwgNum() {
      return this.productDwgNum;
   }

   public Integer getPageNumber() {
      return this.pageNumber;
   }

   public Integer getPageSize() {
      return this.pageSize;
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

   public void setIsBind(final Boolean isBind) {
      this.isBind = isBind;
   }

   public void setCraftType(final Integer craftType) {
      this.craftType = craftType;
   }

   public void setBatchNumber(final String batchNumber) {
      this.batchNumber = batchNumber;
   }

   public void setProductSpecification(final String productSpecification) {
      this.productSpecification = productSpecification;
   }

   public void setProductMaterial(final String productMaterial) {
      this.productMaterial = productMaterial;
   }

   public void setWeldSerialNumber(final String weldSerialNumber) {
      this.weldSerialNumber = weldSerialNumber;
   }

   public void setProductName(final String productName) {
      this.productName = productName;
   }

   public void setProductSerialNumber(final String productSerialNumber) {
      this.productSerialNumber = productSerialNumber;
   }

   public void setTechCappCraftCardStorehouseSerialNumber(final String techCappCraftCardStorehouseSerialNumber) {
      this.techCappCraftCardStorehouseSerialNumber = techCappCraftCardStorehouseSerialNumber;
   }

   public void setProductDwgNum(final String productDwgNum) {
      this.productDwgNum = productDwgNum;
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

      if (!(o instanceof CappCraftCardProductLinkListDTO)) {
         return false;
      }

      CappCraftCardProductLinkListDTO other = (CappCraftCardProductLinkListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$monomerId = this.getMonomerId();
      Object other$monomerId = other.getMonomerId();
      if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
         Object this$areaId = this.getAreaId();
         Object other$areaId = other.getAreaId();
         if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$isBind = this.getIsBind();
               Object other$isBind = other.getIsBind();
               if (this$isBind == null ? other$isBind == null : this$isBind.equals(other$isBind)) {
                  Object this$craftType = this.getCraftType();
                  Object other$craftType = other.getCraftType();
                  if (this$craftType == null ? other$craftType == null : this$craftType.equals(other$craftType)) {
                     Object this$pageNumber = this.getPageNumber();
                     Object other$pageNumber = other.getPageNumber();
                     if (this$pageNumber == null ? other$pageNumber == null : this$pageNumber.equals(other$pageNumber)) {
                        Object this$pageSize = this.getPageSize();
                        Object other$pageSize = other.getPageSize();
                        if (this$pageSize == null ? other$pageSize == null : this$pageSize.equals(other$pageSize)) {
                           Object this$batchNumber = this.getBatchNumber();
                           Object other$batchNumber = other.getBatchNumber();
                           if (this$batchNumber == null ? other$batchNumber == null : this$batchNumber.equals(other$batchNumber)) {
                              Object this$productSpecification = this.getProductSpecification();
                              Object other$productSpecification = other.getProductSpecification();
                              if (this$productSpecification == null
                                 ? other$productSpecification == null
                                 : this$productSpecification.equals(other$productSpecification)) {
                                 Object this$productMaterial = this.getProductMaterial();
                                 Object other$productMaterial = other.getProductMaterial();
                                 if (this$productMaterial == null ? other$productMaterial == null : this$productMaterial.equals(other$productMaterial)) {
                                    Object this$weldSerialNumber = this.getWeldSerialNumber();
                                    Object other$weldSerialNumber = other.getWeldSerialNumber();
                                    if (this$weldSerialNumber == null ? other$weldSerialNumber == null : this$weldSerialNumber.equals(other$weldSerialNumber)) {
                                       Object this$productName = this.getProductName();
                                       Object other$productName = other.getProductName();
                                       if (this$productName == null ? other$productName == null : this$productName.equals(other$productName)) {
                                          Object this$productSerialNumber = this.getProductSerialNumber();
                                          Object other$productSerialNumber = other.getProductSerialNumber();
                                          if (this$productSerialNumber == null
                                             ? other$productSerialNumber == null
                                             : this$productSerialNumber.equals(other$productSerialNumber)) {
                                             Object this$techCappCraftCardStorehouseSerialNumber = this.getTechCappCraftCardStorehouseSerialNumber();
                                             Object other$techCappCraftCardStorehouseSerialNumber = other.getTechCappCraftCardStorehouseSerialNumber();
                                             if (this$techCappCraftCardStorehouseSerialNumber == null
                                                ? other$techCappCraftCardStorehouseSerialNumber == null
                                                : this$techCappCraftCardStorehouseSerialNumber.equals(other$techCappCraftCardStorehouseSerialNumber)) {
                                                Object this$productDwgNum = this.getProductDwgNum();
                                                Object other$productDwgNum = other.getProductDwgNum();
                                                return this$productDwgNum == null
                                                   ? other$productDwgNum == null
                                                   : this$productDwgNum.equals(other$productDwgNum);
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
      return other instanceof CappCraftCardProductLinkListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $isBind = this.getIsBind();
      result = result * 59 + ($isBind == null ? 43 : $isBind.hashCode());
      Object $craftType = this.getCraftType();
      result = result * 59 + ($craftType == null ? 43 : $craftType.hashCode());
      Object $pageNumber = this.getPageNumber();
      result = result * 59 + ($pageNumber == null ? 43 : $pageNumber.hashCode());
      Object $pageSize = this.getPageSize();
      result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
      Object $batchNumber = this.getBatchNumber();
      result = result * 59 + ($batchNumber == null ? 43 : $batchNumber.hashCode());
      Object $productSpecification = this.getProductSpecification();
      result = result * 59 + ($productSpecification == null ? 43 : $productSpecification.hashCode());
      Object $productMaterial = this.getProductMaterial();
      result = result * 59 + ($productMaterial == null ? 43 : $productMaterial.hashCode());
      Object $weldSerialNumber = this.getWeldSerialNumber();
      result = result * 59 + ($weldSerialNumber == null ? 43 : $weldSerialNumber.hashCode());
      Object $productName = this.getProductName();
      result = result * 59 + ($productName == null ? 43 : $productName.hashCode());
      Object $productSerialNumber = this.getProductSerialNumber();
      result = result * 59 + ($productSerialNumber == null ? 43 : $productSerialNumber.hashCode());
      Object $techCappCraftCardStorehouseSerialNumber = this.getTechCappCraftCardStorehouseSerialNumber();
      result = result * 59 + ($techCappCraftCardStorehouseSerialNumber == null ? 43 : $techCappCraftCardStorehouseSerialNumber.hashCode());
      Object $productDwgNum = this.getProductDwgNum();
      return result * 59 + ($productDwgNum == null ? 43 : $productDwgNum.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardProductLinkListDTO(monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", productType="
         + this.getProductType()
         + ", isBind="
         + this.getIsBind()
         + ", craftType="
         + this.getCraftType()
         + ", batchNumber="
         + this.getBatchNumber()
         + ", productSpecification="
         + this.getProductSpecification()
         + ", productMaterial="
         + this.getProductMaterial()
         + ", weldSerialNumber="
         + this.getWeldSerialNumber()
         + ", productName="
         + this.getProductName()
         + ", productSerialNumber="
         + this.getProductSerialNumber()
         + ", techCappCraftCardStorehouseSerialNumber="
         + this.getTechCappCraftCardStorehouseSerialNumber()
         + ", productDwgNum="
         + this.getProductDwgNum()
         + ", pageNumber="
         + this.getPageNumber()
         + ", pageSize="
         + this.getPageSize()
         + ")";
   }
}
