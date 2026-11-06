package com.hzchum.scim.common.core.api.pojo.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("产品信息")
public class ProductInfo {
   @ApiModelProperty("ID")
   private Long id;
   @ApiModelProperty("名称")
   @JsonInclude(Include.NON_NULL)
   private String name;
   @ApiModelProperty("编号")
   private String serialNumber;
   @ApiModelProperty("规格")
   @JsonInclude(Include.NON_NULL)
   private String specification;
   @ApiModelProperty("材质")
   @JsonInclude(Include.NON_NULL)
   private String material;
   @ApiModelProperty("产品类型")
   @JsonInclude(Include.NON_NULL)
   private Integer productTypeEnum;
   @ApiModelProperty("产品分类")
   @JsonInclude(Include.NON_NULL)
   private Integer productClassificationEnum;
   @ApiModelProperty("种类ID")
   @JsonInclude(Include.NON_NULL)
   private Long classId;
   @ApiModelProperty("种类名称")
   @JsonInclude(Include.NON_NULL)
   private String className;
   @ApiModelProperty("数量")
   @JsonInclude(Include.NON_NULL)
   private Integer quantity;
   @ApiModelProperty("长度（mm）")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal length;
   @ApiModelProperty("单净重（kg）")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal netWeight;
   @ApiModelProperty("单面积（mm²）")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal surfaceArea;
   @ApiModelProperty("厚(mm)")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal thick;
   @ApiModelProperty("零件数量")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal machinePartQuantity;
   @ApiModelProperty("字典id")
   @JsonInclude(Include.NON_NULL)
   private Long dictionaryId;
   @ApiModelProperty("字典标签")
   @JsonInclude(Include.NON_NULL)
   private Long dictionaryLabel;
   @ApiModelProperty("版型")
   @JsonInclude(Include.NON_NULL)
   private String plate;
   @ApiModelProperty("单体id")
   @JsonInclude(Include.NON_NULL)
   private Long monomerId;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getProductTypeEnum() {
      return this.productTypeEnum;
   }

   public Integer getProductClassificationEnum() {
      return this.productClassificationEnum;
   }

   public Long getClassId() {
      return this.classId;
   }

   public String getClassName() {
      return this.className;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public BigDecimal getThick() {
      return this.thick;
   }

   public BigDecimal getMachinePartQuantity() {
      return this.machinePartQuantity;
   }

   public Long getDictionaryId() {
      return this.dictionaryId;
   }

   public Long getDictionaryLabel() {
      return this.dictionaryLabel;
   }

   public String getPlate() {
      return this.plate;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setProductTypeEnum(final Integer productTypeEnum) {
      this.productTypeEnum = productTypeEnum;
   }

   public void setProductClassificationEnum(final Integer productClassificationEnum) {
      this.productClassificationEnum = productClassificationEnum;
   }

   public void setClassId(final Long classId) {
      this.classId = classId;
   }

   public void setClassName(final String className) {
      this.className = className;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setThick(final BigDecimal thick) {
      this.thick = thick;
   }

   public void setMachinePartQuantity(final BigDecimal machinePartQuantity) {
      this.machinePartQuantity = machinePartQuantity;
   }

   public void setDictionaryId(final Long dictionaryId) {
      this.dictionaryId = dictionaryId;
   }

   public void setDictionaryLabel(final Long dictionaryLabel) {
      this.dictionaryLabel = dictionaryLabel;
   }

   public void setPlate(final String plate) {
      this.plate = plate;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductInfo)) {
         return false;
      }

      ProductInfo other = (ProductInfo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productTypeEnum = this.getProductTypeEnum();
         Object other$productTypeEnum = other.getProductTypeEnum();
         if (this$productTypeEnum == null ? other$productTypeEnum == null : this$productTypeEnum.equals(other$productTypeEnum)) {
            Object this$productClassificationEnum = this.getProductClassificationEnum();
            Object other$productClassificationEnum = other.getProductClassificationEnum();
            if (this$productClassificationEnum == null
               ? other$productClassificationEnum == null
               : this$productClassificationEnum.equals(other$productClassificationEnum)) {
               Object this$classId = this.getClassId();
               Object other$classId = other.getClassId();
               if (this$classId == null ? other$classId == null : this$classId.equals(other$classId)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$dictionaryId = this.getDictionaryId();
                     Object other$dictionaryId = other.getDictionaryId();
                     if (this$dictionaryId == null ? other$dictionaryId == null : this$dictionaryId.equals(other$dictionaryId)) {
                        Object this$dictionaryLabel = this.getDictionaryLabel();
                        Object other$dictionaryLabel = other.getDictionaryLabel();
                        if (this$dictionaryLabel == null ? other$dictionaryLabel == null : this$dictionaryLabel.equals(other$dictionaryLabel)) {
                           Object this$monomerId = this.getMonomerId();
                           Object other$monomerId = other.getMonomerId();
                           if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                              Object this$name = this.getName();
                              Object other$name = other.getName();
                              if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                    Object this$specification = this.getSpecification();
                                    Object other$specification = other.getSpecification();
                                    if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                       Object this$material = this.getMaterial();
                                       Object other$material = other.getMaterial();
                                       if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                          Object this$className = this.getClassName();
                                          Object other$className = other.getClassName();
                                          if (this$className == null ? other$className == null : this$className.equals(other$className)) {
                                             Object this$length = this.getLength();
                                             Object other$length = other.getLength();
                                             if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                Object this$netWeight = this.getNetWeight();
                                                Object other$netWeight = other.getNetWeight();
                                                if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                                   Object this$surfaceArea = this.getSurfaceArea();
                                                   Object other$surfaceArea = other.getSurfaceArea();
                                                   if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
                                                      Object this$thick = this.getThick();
                                                      Object other$thick = other.getThick();
                                                      if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
                                                         Object this$machinePartQuantity = this.getMachinePartQuantity();
                                                         Object other$machinePartQuantity = other.getMachinePartQuantity();
                                                         if (this$machinePartQuantity == null
                                                            ? other$machinePartQuantity == null
                                                            : this$machinePartQuantity.equals(other$machinePartQuantity)) {
                                                            Object this$plate = this.getPlate();
                                                            Object other$plate = other.getPlate();
                                                            return this$plate == null ? other$plate == null : this$plate.equals(other$plate);
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
      return other instanceof ProductInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productTypeEnum = this.getProductTypeEnum();
      result = result * 59 + ($productTypeEnum == null ? 43 : $productTypeEnum.hashCode());
      Object $productClassificationEnum = this.getProductClassificationEnum();
      result = result * 59 + ($productClassificationEnum == null ? 43 : $productClassificationEnum.hashCode());
      Object $classId = this.getClassId();
      result = result * 59 + ($classId == null ? 43 : $classId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $dictionaryId = this.getDictionaryId();
      result = result * 59 + ($dictionaryId == null ? 43 : $dictionaryId.hashCode());
      Object $dictionaryLabel = this.getDictionaryLabel();
      result = result * 59 + ($dictionaryLabel == null ? 43 : $dictionaryLabel.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $className = this.getClassName();
      result = result * 59 + ($className == null ? 43 : $className.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $machinePartQuantity = this.getMachinePartQuantity();
      result = result * 59 + ($machinePartQuantity == null ? 43 : $machinePartQuantity.hashCode());
      Object $plate = this.getPlate();
      return result * 59 + ($plate == null ? 43 : $plate.hashCode());
   }

   @Override
   public String toString() {
      return "ProductInfo(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", productTypeEnum="
         + this.getProductTypeEnum()
         + ", productClassificationEnum="
         + this.getProductClassificationEnum()
         + ", classId="
         + this.getClassId()
         + ", className="
         + this.getClassName()
         + ", quantity="
         + this.getQuantity()
         + ", length="
         + this.getLength()
         + ", netWeight="
         + this.getNetWeight()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", thick="
         + this.getThick()
         + ", machinePartQuantity="
         + this.getMachinePartQuantity()
         + ", dictionaryId="
         + this.getDictionaryId()
         + ", dictionaryLabel="
         + this.getDictionaryLabel()
         + ", plate="
         + this.getPlate()
         + ", monomerId="
         + this.getMonomerId()
         + ")";
   }
}
