package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("组立添加构件请求类")
public class AssembleArtifactSaveDTOParam {
   @NotNull(message = "组立id不能为空")
   @ApiModelProperty(name = "assembleId", value = "组立id")
   private Long assembleId;
   @ApiModelProperty(name = "serialNumber", value = "构件编号")
   @NotBlank(message = "构件编号不能为空")
   private String serialNumber;
   @NotBlank(message = "构件规格不能为空")
   @ApiModelProperty(name = "specification", value = "构件规格")
   private String specification;
   @NotNull(message = "构件长度不能为空")
   @ApiModelProperty(name = "length", value = "构件长度")
   private BigDecimal length;
   @NotBlank(message = "构件材质不能为空")
   @ApiModelProperty(name = "material", value = "构件材质")
   private String material;
   @NotNull(message = "构件单净重不能为空")
   @ApiModelProperty(name = "netWeight", value = "构件单净重")
   private BigDecimal netWeight;
   @NotNull(message = "构件数量不能为空")
   @Min(value = 1L, message = "构建数量最小为1")
   @ApiModelProperty(name = "quantity", value = "构件数量")
   private Integer quantity;
   @NotNull(message = "组立数量数量不能为空")
   @Min(value = 1L, message = "组立数量数量最小为1")
   @ApiModelProperty(name = "assembleQuantity", value = "构件所需组立数量")
   private Integer assembleQuantity;

   public Long getAssembleId() {
      return this.assembleId;
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

   public Integer getAssembleQuantity() {
      return this.assembleQuantity;
   }

   public void setAssembleId(final Long assembleId) {
      this.assembleId = assembleId;
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

   public void setAssembleQuantity(final Integer assembleQuantity) {
      this.assembleQuantity = assembleQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssembleArtifactSaveDTOParam)) {
         return false;
      }

      AssembleArtifactSaveDTOParam other = (AssembleArtifactSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$assembleId = this.getAssembleId();
      Object other$assembleId = other.getAssembleId();
      if (this$assembleId == null ? other$assembleId == null : this$assembleId.equals(other$assembleId)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$assembleQuantity = this.getAssembleQuantity();
            Object other$assembleQuantity = other.getAssembleQuantity();
            if (this$assembleQuantity == null ? other$assembleQuantity == null : this$assembleQuantity.equals(other$assembleQuantity)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AssembleArtifactSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $assembleId = this.getAssembleId();
      result = result * 59 + ($assembleId == null ? 43 : $assembleId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $assembleQuantity = this.getAssembleQuantity();
      result = result * 59 + ($assembleQuantity == null ? 43 : $assembleQuantity.hashCode());
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
      return "AssembleArtifactSaveDTOParam(assembleId="
         + this.getAssembleId()
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
         + ", assembleQuantity="
         + this.getAssembleQuantity()
         + ")";
   }
}
