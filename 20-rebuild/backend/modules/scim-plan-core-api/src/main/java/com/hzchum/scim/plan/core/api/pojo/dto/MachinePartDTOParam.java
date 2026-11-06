package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("构件变更-零件类")
public class MachinePartDTOParam {
   @ApiModelProperty(name = "id", value = "零件id")
   private Long id;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @NotBlank(message = "零件编号不能为空")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   @NotBlank(message = "零件规格不能为空")
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   @NotNull(message = "零件长度不能为空")
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质")
   @NotBlank(message = "零件材质不能为空")
   private String material;
   @ApiModelProperty(name = "quantity", value = "本构件需要的零件总数量")
   @NotNull(message = "零件数量不能为空")
   @Min(value = 1L, message = "零件数量必须大于0")
   private Integer quantity;
   @ApiModelProperty(name = "type", value = "类型 1剪板 2数控")
   private Integer type;
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   @NotNull(message = "单净重不等为空")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "grossWeight", value = "单毛重（kg）")
   @NotNull(message = "单毛重不等为空")
   private BigDecimal grossWeight;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;

   public static MachinePartDTOParam.MachinePartDTOParamBuilder builder() {
      return new MachinePartDTOParam.MachinePartDTOParamBuilder();
   }

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

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getType() {
      return this.type;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public String getRemark() {
      return this.remark;
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

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public String toString() {
      return "MachinePartDTOParam(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", type="
         + this.getType()
         + ", netWeight="
         + this.getNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachinePartDTOParam)) {
         return false;
      }

      MachinePartDTOParam other = (MachinePartDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
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
                           if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                              Object this$grossWeight = this.getGrossWeight();
                              Object other$grossWeight = other.getGrossWeight();
                              if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                                 Object this$remark = this.getRemark();
                                 Object other$remark = other.getRemark();
                                 return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof MachinePartDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public MachinePartDTOParam(
      final Long id,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final Integer quantity,
      final Integer type,
      final BigDecimal netWeight,
      final BigDecimal grossWeight,
      final String remark
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.quantity = quantity;
      this.type = type;
      this.netWeight = netWeight;
      this.grossWeight = grossWeight;
      this.remark = remark;
   }

   public MachinePartDTOParam() {
   }

   public static class MachinePartDTOParamBuilder {
      private Long id;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private Integer quantity;
      private Integer type;
      private BigDecimal netWeight;
      private BigDecimal grossWeight;
      private String remark;

      MachinePartDTOParamBuilder() {
      }

      public MachinePartDTOParam.MachinePartDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MachinePartDTOParam.MachinePartDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MachinePartDTOParam.MachinePartDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public MachinePartDTOParam.MachinePartDTOParamBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public MachinePartDTOParam.MachinePartDTOParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public MachinePartDTOParam.MachinePartDTOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MachinePartDTOParam.MachinePartDTOParamBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public MachinePartDTOParam.MachinePartDTOParamBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public MachinePartDTOParam.MachinePartDTOParamBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public MachinePartDTOParam.MachinePartDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public MachinePartDTOParam build() {
         return new MachinePartDTOParam(
            this.id, this.serialNumber, this.specification, this.length, this.material, this.quantity, this.type, this.netWeight, this.grossWeight, this.remark
         );
      }

      @Override
      public String toString() {
         return "MachinePartDTOParam.MachinePartDTOParamBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", material="
            + this.material
            + ", quantity="
            + this.quantity
            + ", type="
            + this.type
            + ", netWeight="
            + this.netWeight
            + ", grossWeight="
            + this.grossWeight
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
