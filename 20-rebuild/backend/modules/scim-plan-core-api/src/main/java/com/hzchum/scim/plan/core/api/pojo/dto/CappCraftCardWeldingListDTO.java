package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "CAPP 产品焊缝列表 查询参数")
public class CappCraftCardWeldingListDTO {
   @ApiModelProperty(name = "id", value = "码号id", notes = "码号id")
   private Long id;
   @ApiModelProperty(name = "productSerialNumber", value = "产品编号", notes = "产品编号")
   private String productSerialNumber;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   private Long productId;
   @ApiModelProperty(name = "productType", value = "产品类型参考枚举 ProductTypeEnum", notes = "产品类型参考枚举 ProductTypeEnum")
   private Integer productType;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   private Long monomerId;

   public Long getId() {
      return this.id;
   }

   public String getProductSerialNumber() {
      return this.productSerialNumber;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProductSerialNumber(final String productSerialNumber) {
      this.productSerialNumber = productSerialNumber;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CappCraftCardWeldingListDTO)) {
         return false;
      }

      CappCraftCardWeldingListDTO other = (CappCraftCardWeldingListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$monomerId = this.getMonomerId();
                  Object other$monomerId = other.getMonomerId();
                  if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                     Object this$productSerialNumber = this.getProductSerialNumber();
                     Object other$productSerialNumber = other.getProductSerialNumber();
                     return this$productSerialNumber == null ? other$productSerialNumber == null : this$productSerialNumber.equals(other$productSerialNumber);
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
      return other instanceof CappCraftCardWeldingListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $productSerialNumber = this.getProductSerialNumber();
      return result * 59 + ($productSerialNumber == null ? 43 : $productSerialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardWeldingListDTO(id="
         + this.getId()
         + ", productSerialNumber="
         + this.getProductSerialNumber()
         + ", productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", areaId="
         + this.getAreaId()
         + ", monomerId="
         + this.getMonomerId()
         + ")";
   }
}
