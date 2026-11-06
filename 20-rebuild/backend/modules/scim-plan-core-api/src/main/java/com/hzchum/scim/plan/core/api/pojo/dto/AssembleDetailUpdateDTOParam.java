package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class AssembleDetailUpdateDTOParam {
   @ApiModelProperty(name = "id", value = "主键ID")
   @NotNull(message = "组立详情ID不能为空")
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @NotBlank(message = "腹板翼缘编号不能为空!")
   @Length(max = 15, message = "腹板翼缘编号长度过长!")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   @NotBlank(message = "腹板翼缘规格不能为空!")
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   @NotNull(message = "腹板翼缘长度不能为空!")
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质")
   @NotBlank(message = "腹板翼缘材质不能为空!")
   private String material;
   @ApiModelProperty(name = "netWeight", value = "净重（kg）")
   @NotNull(message = "腹板翼缘单净重不能为空!")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "quantity", value = "数量")
   @NotNull(message = "腹板翼缘数量不能为空!")
   private Integer quantity;

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssembleDetailUpdateDTOParam)) {
         return false;
      }

      AssembleDetailUpdateDTOParam other = (AssembleDetailUpdateDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$serialNumber = this.getSerialNumber();
            Object other$serialNumber = other.getSerialNumber();
            if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
               Object this$specification = this.getSpecification();
               Object other$specification = other.getSpecification();
               if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                  Object this$length = this.getLength();
                  Object other$length = other.getLength();
                  if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                     Object this$material = this.getMaterial();
                     Object other$material = other.getMaterial();
                     if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                        Object this$netWeight = this.getNetWeight();
                        Object other$netWeight = other.getNetWeight();
                        return this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight);
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
      return other instanceof AssembleDetailUpdateDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      return result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
   }

   @Override
   public String toString() {
      return "AssembleDetailUpdateDTOParam(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", netWeight="
         + this.getNetWeight()
         + ", quantity="
         + this.getQuantity()
         + ")";
   }
}
