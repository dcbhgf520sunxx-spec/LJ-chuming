package com.hzchum.scim.project.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("安装看板类")
public class ProjectInstallBoardDTO {
   @ApiModelProperty(name = "productType", value = "产品类型 2构件 4围护 8配套件", notes = "产品类型 2构件 4围护 8配套件")
   private Integer productType;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   private Long productId;
   @ApiModelProperty(name = "monomer", value = "单体信息", notes = "单体信息")
   private NameInfo monomer;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "area", value = "区域信息", notes = "区域信息")
   private NameInfo area;
   @ApiModelProperty(name = "serialNumber", value = "产品编号", notes = "产品编号")
   private String serialNumber;
   @ApiModelProperty(name = "name", value = "产品名称", notes = "产品名称")
   private String name;
   @ApiModelProperty(name = "quantity", value = "清单数量", notes = "清单数量")
   private Integer quantity;
   @ApiModelProperty(name = "InstallQuantity", value = "安装数量", notes = "安装数量")
   private Integer installQuantity;
   @ApiModelProperty(name = "installStatus", value = "安装状态 0未安装 1部分安装 2全部安装", notes = "安装状态")
   private Integer installStatus;

   public Integer getProductType() {
      return this.productType;
   }

   public Long getProductId() {
      return this.productId;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getInstallQuantity() {
      return this.installQuantity;
   }

   public Integer getInstallStatus() {
      return this.installStatus;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setArea(final NameInfo area) {
      this.area = area;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setInstallQuantity(final Integer installQuantity) {
      this.installQuantity = installQuantity;
   }

   public void setInstallStatus(final Integer installStatus) {
      this.installStatus = installStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectInstallBoardDTO)) {
         return false;
      }

      ProjectInstallBoardDTO other = (ProjectInstallBoardDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productType = this.getProductType();
      Object other$productType = other.getProductType();
      if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$installQuantity = this.getInstallQuantity();
               Object other$installQuantity = other.getInstallQuantity();
               if (this$installQuantity == null ? other$installQuantity == null : this$installQuantity.equals(other$installQuantity)) {
                  Object this$installStatus = this.getInstallStatus();
                  Object other$installStatus = other.getInstallStatus();
                  if (this$installStatus == null ? other$installStatus == null : this$installStatus.equals(other$installStatus)) {
                     Object this$monomer = this.getMonomer();
                     Object other$monomer = other.getMonomer();
                     if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                        Object this$area = this.getArea();
                        Object other$area = other.getArea();
                        if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
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
      return other instanceof ProjectInstallBoardDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $installQuantity = this.getInstallQuantity();
      result = result * 59 + ($installQuantity == null ? 43 : $installQuantity.hashCode());
      Object $installStatus = this.getInstallStatus();
      result = result * 59 + ($installStatus == null ? 43 : $installStatus.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectInstallBoardDTO(productType="
         + this.getProductType()
         + ", productId="
         + this.getProductId()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", quantity="
         + this.getQuantity()
         + ", installQuantity="
         + this.getInstallQuantity()
         + ", installStatus="
         + this.getInstallStatus()
         + ")";
   }
}
