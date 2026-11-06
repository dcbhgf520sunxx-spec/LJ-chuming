package com.hzchum.scim.plan.core.api.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "CAPP 工艺管理 响应参数")
public class CappCraftCardProductLinkVO {
   @ApiModelProperty(name = "id", value = "id", notes = "产品焊接绑定表id")
   private Long id;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   private Long productId;
   @ApiModelProperty(name = "batchNumber", value = "批次名称", notes = "批次名称")
   private String batchNumber;
   @ApiModelProperty(name = "weldSerialNumber", value = "焊缝编号")
   private String weldSerialNumber;
   @ApiModelProperty(name = "productName", value = "产品名称")
   private String productName;
   @ApiModelProperty(name = "productSerialNumber", value = "产品编号")
   private String productSerialNumber;
   @ApiModelProperty(name = "productSpecification", value = "产品规格")
   private String productSpecification;
   @ApiModelProperty(name = "productLength", value = "产品长度")
   private String productLength;
   @ApiModelProperty(name = "productMaterial", value = "产品材质")
   private String productMaterial;
   @ApiModelProperty(name = "weldCount", value = "焊缝数量")
   private Integer weldCount;
   @ApiModelProperty(name = "productDwgNum", value = "产品图号")
   private String productDwgNum;
   @ApiModelProperty(name = "techCappCraftCardStorehouseId", value = "工艺id")
   private Long techCappCraftCardStorehouseId;
   @ApiModelProperty(name = "techCappCraftCardStorehouseSerialNumber", value = "工艺编号")
   private String techCappCraftCardStorehouseSerialNumber;
   @ApiModelProperty(name = "craftType", value = "工艺类型", notes = "工艺类型")
   private Integer craftType;
   @ApiModelProperty(name = "isIssued", value = "是否已下发任务", notes = "是否已下发任务")
   private Boolean isIssued;

   public Long getId() {
      return this.id;
   }

   public Long getProductId() {
      return this.productId;
   }

   public String getBatchNumber() {
      return this.batchNumber;
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

   public String getProductSpecification() {
      return this.productSpecification;
   }

   public String getProductLength() {
      return this.productLength;
   }

   public String getProductMaterial() {
      return this.productMaterial;
   }

   public Integer getWeldCount() {
      return this.weldCount;
   }

   public String getProductDwgNum() {
      return this.productDwgNum;
   }

   public Long getTechCappCraftCardStorehouseId() {
      return this.techCappCraftCardStorehouseId;
   }

   public String getTechCappCraftCardStorehouseSerialNumber() {
      return this.techCappCraftCardStorehouseSerialNumber;
   }

   public Integer getCraftType() {
      return this.craftType;
   }

   public Boolean getIsIssued() {
      return this.isIssued;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setBatchNumber(final String batchNumber) {
      this.batchNumber = batchNumber;
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

   public void setProductSpecification(final String productSpecification) {
      this.productSpecification = productSpecification;
   }

   public void setProductLength(final String productLength) {
      this.productLength = productLength;
   }

   public void setProductMaterial(final String productMaterial) {
      this.productMaterial = productMaterial;
   }

   public void setWeldCount(final Integer weldCount) {
      this.weldCount = weldCount;
   }

   public void setProductDwgNum(final String productDwgNum) {
      this.productDwgNum = productDwgNum;
   }

   public void setTechCappCraftCardStorehouseId(final Long techCappCraftCardStorehouseId) {
      this.techCappCraftCardStorehouseId = techCappCraftCardStorehouseId;
   }

   public void setTechCappCraftCardStorehouseSerialNumber(final String techCappCraftCardStorehouseSerialNumber) {
      this.techCappCraftCardStorehouseSerialNumber = techCappCraftCardStorehouseSerialNumber;
   }

   public void setCraftType(final Integer craftType) {
      this.craftType = craftType;
   }

   public void setIsIssued(final Boolean isIssued) {
      this.isIssued = isIssued;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CappCraftCardProductLinkVO)) {
         return false;
      }

      CappCraftCardProductLinkVO other = (CappCraftCardProductLinkVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$weldCount = this.getWeldCount();
            Object other$weldCount = other.getWeldCount();
            if (this$weldCount == null ? other$weldCount == null : this$weldCount.equals(other$weldCount)) {
               Object this$techCappCraftCardStorehouseId = this.getTechCappCraftCardStorehouseId();
               Object other$techCappCraftCardStorehouseId = other.getTechCappCraftCardStorehouseId();
               if (this$techCappCraftCardStorehouseId == null
                  ? other$techCappCraftCardStorehouseId == null
                  : this$techCappCraftCardStorehouseId.equals(other$techCappCraftCardStorehouseId)) {
                  Object this$craftType = this.getCraftType();
                  Object other$craftType = other.getCraftType();
                  if (this$craftType == null ? other$craftType == null : this$craftType.equals(other$craftType)) {
                     Object this$isIssued = this.getIsIssued();
                     Object other$isIssued = other.getIsIssued();
                     if (this$isIssued == null ? other$isIssued == null : this$isIssued.equals(other$isIssued)) {
                        Object this$batchNumber = this.getBatchNumber();
                        Object other$batchNumber = other.getBatchNumber();
                        if (this$batchNumber == null ? other$batchNumber == null : this$batchNumber.equals(other$batchNumber)) {
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
                                    Object this$productSpecification = this.getProductSpecification();
                                    Object other$productSpecification = other.getProductSpecification();
                                    if (this$productSpecification == null
                                       ? other$productSpecification == null
                                       : this$productSpecification.equals(other$productSpecification)) {
                                       Object this$productLength = this.getProductLength();
                                       Object other$productLength = other.getProductLength();
                                       if (this$productLength == null ? other$productLength == null : this$productLength.equals(other$productLength)) {
                                          Object this$productMaterial = this.getProductMaterial();
                                          Object other$productMaterial = other.getProductMaterial();
                                          if (this$productMaterial == null ? other$productMaterial == null : this$productMaterial.equals(other$productMaterial)
                                             )
                                           {
                                             Object this$productDwgNum = this.getProductDwgNum();
                                             Object other$productDwgNum = other.getProductDwgNum();
                                             if (this$productDwgNum == null ? other$productDwgNum == null : this$productDwgNum.equals(other$productDwgNum)) {
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
      return other instanceof CappCraftCardProductLinkVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $weldCount = this.getWeldCount();
      result = result * 59 + ($weldCount == null ? 43 : $weldCount.hashCode());
      Object $techCappCraftCardStorehouseId = this.getTechCappCraftCardStorehouseId();
      result = result * 59 + ($techCappCraftCardStorehouseId == null ? 43 : $techCappCraftCardStorehouseId.hashCode());
      Object $craftType = this.getCraftType();
      result = result * 59 + ($craftType == null ? 43 : $craftType.hashCode());
      Object $isIssued = this.getIsIssued();
      result = result * 59 + ($isIssued == null ? 43 : $isIssued.hashCode());
      Object $batchNumber = this.getBatchNumber();
      result = result * 59 + ($batchNumber == null ? 43 : $batchNumber.hashCode());
      Object $weldSerialNumber = this.getWeldSerialNumber();
      result = result * 59 + ($weldSerialNumber == null ? 43 : $weldSerialNumber.hashCode());
      Object $productName = this.getProductName();
      result = result * 59 + ($productName == null ? 43 : $productName.hashCode());
      Object $productSerialNumber = this.getProductSerialNumber();
      result = result * 59 + ($productSerialNumber == null ? 43 : $productSerialNumber.hashCode());
      Object $productSpecification = this.getProductSpecification();
      result = result * 59 + ($productSpecification == null ? 43 : $productSpecification.hashCode());
      Object $productLength = this.getProductLength();
      result = result * 59 + ($productLength == null ? 43 : $productLength.hashCode());
      Object $productMaterial = this.getProductMaterial();
      result = result * 59 + ($productMaterial == null ? 43 : $productMaterial.hashCode());
      Object $productDwgNum = this.getProductDwgNum();
      result = result * 59 + ($productDwgNum == null ? 43 : $productDwgNum.hashCode());
      Object $techCappCraftCardStorehouseSerialNumber = this.getTechCappCraftCardStorehouseSerialNumber();
      return result * 59 + ($techCappCraftCardStorehouseSerialNumber == null ? 43 : $techCappCraftCardStorehouseSerialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardProductLinkVO(id="
         + this.getId()
         + ", productId="
         + this.getProductId()
         + ", batchNumber="
         + this.getBatchNumber()
         + ", weldSerialNumber="
         + this.getWeldSerialNumber()
         + ", productName="
         + this.getProductName()
         + ", productSerialNumber="
         + this.getProductSerialNumber()
         + ", productSpecification="
         + this.getProductSpecification()
         + ", productLength="
         + this.getProductLength()
         + ", productMaterial="
         + this.getProductMaterial()
         + ", weldCount="
         + this.getWeldCount()
         + ", productDwgNum="
         + this.getProductDwgNum()
         + ", techCappCraftCardStorehouseId="
         + this.getTechCappCraftCardStorehouseId()
         + ", techCappCraftCardStorehouseSerialNumber="
         + this.getTechCappCraftCardStorehouseSerialNumber()
         + ", craftType="
         + this.getCraftType()
         + ", isIssued="
         + this.getIsIssued()
         + ")";
   }
}
