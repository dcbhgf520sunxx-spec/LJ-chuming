package com.hzchum.scim.project.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("收货看板类")
public class ProjectReceivingBoardDTO {
   @ApiModelProperty(name = "productType", value = "产品类型 2构件 4围护 8配套件", notes = "产品类型 2构件 4围护 8配套件")
   private Integer productType;
   @ApiModelProperty(name = "category", value = "围护类型", notes = "围护类型")
   private Integer category;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   private Long productId;
   @ApiModelProperty(name = "serialNumber", value = "产品编号", notes = "产品编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   private String specification;
   @ApiModelProperty(name = "name", value = "产品名称", notes = "产品名称")
   private String name;
   @ApiModelProperty(name = "quantity", value = "清单数量", notes = "清单数量")
   private Integer quantity;
   @ApiModelProperty(name = "quantity", value = "收货数量", notes = "收货数量")
   private Integer receivingQuantity;
   @ApiModelProperty(name = "receivingStatus", value = "收货状态", notes = "收货状态")
   private Integer receivingStatus;

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Long getProductId() {
      return this.productId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getName() {
      return this.name;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getReceivingQuantity() {
      return this.receivingQuantity;
   }

   public Integer getReceivingStatus() {
      return this.receivingStatus;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setReceivingQuantity(final Integer receivingQuantity) {
      this.receivingQuantity = receivingQuantity;
   }

   public void setReceivingStatus(final Integer receivingStatus) {
      this.receivingStatus = receivingStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectReceivingBoardDTO)) {
         return false;
      }

      ProjectReceivingBoardDTO other = (ProjectReceivingBoardDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productType = this.getProductType();
      Object other$productType = other.getProductType();
      if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
         Object this$category = this.getCategory();
         Object other$category = other.getCategory();
         if (this$category == null ? other$category == null : this$category.equals(other$category)) {
            Object this$productId = this.getProductId();
            Object other$productId = other.getProductId();
            if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$receivingQuantity = this.getReceivingQuantity();
                  Object other$receivingQuantity = other.getReceivingQuantity();
                  if (this$receivingQuantity == null ? other$receivingQuantity == null : this$receivingQuantity.equals(other$receivingQuantity)) {
                     Object this$receivingStatus = this.getReceivingStatus();
                     Object other$receivingStatus = other.getReceivingStatus();
                     if (this$receivingStatus == null ? other$receivingStatus == null : this$receivingStatus.equals(other$receivingStatus)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$specification = this.getSpecification();
                           Object other$specification = other.getSpecification();
                           if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                              Object this$name = this.getName();
                              Object other$name = other.getName();
                              return this$name == null ? other$name == null : this$name.equals(other$name);
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
      return other instanceof ProjectReceivingBoardDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $receivingQuantity = this.getReceivingQuantity();
      result = result * 59 + ($receivingQuantity == null ? 43 : $receivingQuantity.hashCode());
      Object $receivingStatus = this.getReceivingStatus();
      result = result * 59 + ($receivingStatus == null ? 43 : $receivingStatus.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectReceivingBoardDTO(productType="
         + this.getProductType()
         + ", category="
         + this.getCategory()
         + ", productId="
         + this.getProductId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", name="
         + this.getName()
         + ", quantity="
         + this.getQuantity()
         + ", receivingQuantity="
         + this.getReceivingQuantity()
         + ", receivingStatus="
         + this.getReceivingStatus()
         + ")";
   }
}
