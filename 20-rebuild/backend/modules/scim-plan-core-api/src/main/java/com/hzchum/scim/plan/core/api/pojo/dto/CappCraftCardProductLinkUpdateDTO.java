package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(description = "CAPP 工艺管理 修改 请求参数")
public class CappCraftCardProductLinkUpdateDTO {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @NotNull(message = "单体id不能为空")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   @NotNull(message = "区域id不能为空")
   private Long areaId;
   @ApiModelProperty(name = "productType", value = "产品类型参考枚举 ProductTypeEnum", notes = "产品类型参考枚举 ProductTypeEnum")
   @NotNull(message = "产品类型不能为空")
   private Integer productType;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @NotNull(message = "产品id不能为空")
   private Long productId;
   @ApiModelProperty(name = "weldingSerialNumber", value = "焊缝编号", notes = "焊缝编号")
   private String weldingSerialNumber;
   @ApiModelProperty(name = "productSerialNumber", value = "产品编号", notes = "产品编号")
   private String productSerialNumber;
   @ApiModelProperty(name = "craftType", value = "工艺类型参考枚举 CappCraftTypeEnum", notes = "工艺类型参考枚举 CappCraftTypeEnum")
   @NotNull(message = "工艺类型不能为空")
   private Integer craftType;
   @ApiModelProperty(name = "techCappCraftCardStorehouseId", value = "焊接工艺卡id", notes = "焊接工艺卡id")
   @NotNull(message = "焊接工艺卡id不能为空")
   private Long techCappCraftCardStorehouseId;
   @ApiModelProperty(
      name = "cappProductUpdateTypeEnum",
      value = "CAPP产品更新类型参考枚举 CappProductUpdateTypeEnum",
      notes = "CAPP产品更新类型参考枚举 CappProductUpdateTypeEnum"
   )
   private Integer cappProductUpdateTypeEnum;

   public Long getId() {
      return this.id;
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

   public Long getProductId() {
      return this.productId;
   }

   public String getWeldingSerialNumber() {
      return this.weldingSerialNumber;
   }

   public String getProductSerialNumber() {
      return this.productSerialNumber;
   }

   public Integer getCraftType() {
      return this.craftType;
   }

   public Long getTechCappCraftCardStorehouseId() {
      return this.techCappCraftCardStorehouseId;
   }

   public Integer getCappProductUpdateTypeEnum() {
      return this.cappProductUpdateTypeEnum;
   }

   public void setId(final Long id) {
      this.id = id;
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

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setWeldingSerialNumber(final String weldingSerialNumber) {
      this.weldingSerialNumber = weldingSerialNumber;
   }

   public void setProductSerialNumber(final String productSerialNumber) {
      this.productSerialNumber = productSerialNumber;
   }

   public void setCraftType(final Integer craftType) {
      this.craftType = craftType;
   }

   public void setTechCappCraftCardStorehouseId(final Long techCappCraftCardStorehouseId) {
      this.techCappCraftCardStorehouseId = techCappCraftCardStorehouseId;
   }

   public void setCappProductUpdateTypeEnum(final Integer cappProductUpdateTypeEnum) {
      this.cappProductUpdateTypeEnum = cappProductUpdateTypeEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CappCraftCardProductLinkUpdateDTO)) {
         return false;
      }

      CappCraftCardProductLinkUpdateDTO other = (CappCraftCardProductLinkUpdateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                  Object this$productId = this.getProductId();
                  Object other$productId = other.getProductId();
                  if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                     Object this$craftType = this.getCraftType();
                     Object other$craftType = other.getCraftType();
                     if (this$craftType == null ? other$craftType == null : this$craftType.equals(other$craftType)) {
                        Object this$techCappCraftCardStorehouseId = this.getTechCappCraftCardStorehouseId();
                        Object other$techCappCraftCardStorehouseId = other.getTechCappCraftCardStorehouseId();
                        if (this$techCappCraftCardStorehouseId == null
                           ? other$techCappCraftCardStorehouseId == null
                           : this$techCappCraftCardStorehouseId.equals(other$techCappCraftCardStorehouseId)) {
                           Object this$cappProductUpdateTypeEnum = this.getCappProductUpdateTypeEnum();
                           Object other$cappProductUpdateTypeEnum = other.getCappProductUpdateTypeEnum();
                           if (this$cappProductUpdateTypeEnum == null
                              ? other$cappProductUpdateTypeEnum == null
                              : this$cappProductUpdateTypeEnum.equals(other$cappProductUpdateTypeEnum)) {
                              Object this$weldingSerialNumber = this.getWeldingSerialNumber();
                              Object other$weldingSerialNumber = other.getWeldingSerialNumber();
                              if (this$weldingSerialNumber == null
                                 ? other$weldingSerialNumber == null
                                 : this$weldingSerialNumber.equals(other$weldingSerialNumber)) {
                                 Object this$productSerialNumber = this.getProductSerialNumber();
                                 Object other$productSerialNumber = other.getProductSerialNumber();
                                 return this$productSerialNumber == null
                                    ? other$productSerialNumber == null
                                    : this$productSerialNumber.equals(other$productSerialNumber);
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
      return other instanceof CappCraftCardProductLinkUpdateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $craftType = this.getCraftType();
      result = result * 59 + ($craftType == null ? 43 : $craftType.hashCode());
      Object $techCappCraftCardStorehouseId = this.getTechCappCraftCardStorehouseId();
      result = result * 59 + ($techCappCraftCardStorehouseId == null ? 43 : $techCappCraftCardStorehouseId.hashCode());
      Object $cappProductUpdateTypeEnum = this.getCappProductUpdateTypeEnum();
      result = result * 59 + ($cappProductUpdateTypeEnum == null ? 43 : $cappProductUpdateTypeEnum.hashCode());
      Object $weldingSerialNumber = this.getWeldingSerialNumber();
      result = result * 59 + ($weldingSerialNumber == null ? 43 : $weldingSerialNumber.hashCode());
      Object $productSerialNumber = this.getProductSerialNumber();
      return result * 59 + ($productSerialNumber == null ? 43 : $productSerialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardProductLinkUpdateDTO(id="
         + this.getId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", productType="
         + this.getProductType()
         + ", productId="
         + this.getProductId()
         + ", weldingSerialNumber="
         + this.getWeldingSerialNumber()
         + ", productSerialNumber="
         + this.getProductSerialNumber()
         + ", craftType="
         + this.getCraftType()
         + ", techCappCraftCardStorehouseId="
         + this.getTechCappCraftCardStorehouseId()
         + ", cappProductUpdateTypeEnum="
         + this.getCappProductUpdateTypeEnum()
         + ")";
   }
}
