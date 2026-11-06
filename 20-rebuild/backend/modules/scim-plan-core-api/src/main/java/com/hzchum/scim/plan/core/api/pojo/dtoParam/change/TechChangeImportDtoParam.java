package com.hzchum.scim.plan.core.api.pojo.dtoParam.change;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;

@ExcelTarget("TechChangeImportDtoParam")
public class TechChangeImportDtoParam implements Serializable {
   @Excel(name = "序号", width = 5.0, orderNum = "1")
   private Integer orderNo;
   @Excel(name = "名称", width = 15.0, orderNum = "2")
   private String name;
   @Excel(name = "构件编号", width = 18.0, orderNum = "3")
   private String artifactNo;
   @Excel(name = "零件编号", width = 13.0, orderNum = "4")
   private String serialNumber;
   @Excel(name = "规格", width = 18.0, orderNum = "5")
   private String specification;
   @Excel(name = "长度(mm)", orderNum = "6")
   private BigDecimal length;
   @Excel(name = "材质", orderNum = "7")
   private String material;
   @Excel(name = "数量", orderNum = "8")
   private Integer quantity;
   @Excel(name = "单净重(kg)", width = 12.0, orderNum = "9")
   private BigDecimal netWeight;
   @Excel(name = "总净重(kg)", width = 13.0, orderNum = "10")
   private BigDecimal totalNetWeight;
   @Excel(name = "单毛重(kg)", width = 12.0, orderNum = "11")
   private BigDecimal grossWeight;
   @Excel(name = "总毛重(kg)", width = 13.0, orderNum = "12")
   private BigDecimal totalGrossWeight;
   @Excel(name = "面积(m²)", orderNum = "13")
   private BigDecimal surfaceArea;
   @Excel(name = "面积(m2)", orderNum = "14")
   private BigDecimal surfaceArea2;
   @Excel(name = "面积(㎡)", orderNum = "15")
   private BigDecimal surfaceArea3;
   @Excel(name = "涂装(Y/N)", orderNum = "16", replace = {"Y_true", "N_false"})
   private Boolean boolCoatingEnum;
   @ApiModelProperty("规格前缀")
   private String specPrefix;
   @ApiModelProperty("零件种类")
   @Column(name = "steel_plate_type_enum", columnDefinition = "int(11) default '1' COMMENT '零件种类 1零件板,2翼腹板 3型材制品'")
   private Integer steelPlateTypeEnum;
   @ApiModelProperty(name = "productClassificationEnum", value = "产品分类 1.普通构件 2.次构件 4.型材制品 8.钢板制品 16.部件")
   private Integer productClassificationEnum;

   public Integer getOrderNo() {
      return this.orderNo;
   }

   public String getName() {
      return this.name;
   }

   public String getArtifactNo() {
      return this.artifactNo;
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

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public BigDecimal getSurfaceArea2() {
      return this.surfaceArea2;
   }

   public BigDecimal getSurfaceArea3() {
      return this.surfaceArea3;
   }

   public Boolean getBoolCoatingEnum() {
      return this.boolCoatingEnum;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public Integer getSteelPlateTypeEnum() {
      return this.steelPlateTypeEnum;
   }

   public Integer getProductClassificationEnum() {
      return this.productClassificationEnum;
   }

   public void setOrderNo(final Integer orderNo) {
      this.orderNo = orderNo;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setArtifactNo(final String artifactNo) {
      this.artifactNo = artifactNo;
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

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   public void setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
   }

   public void setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
   }

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setSurfaceArea2(final BigDecimal surfaceArea2) {
      this.surfaceArea2 = surfaceArea2;
   }

   public void setSurfaceArea3(final BigDecimal surfaceArea3) {
      this.surfaceArea3 = surfaceArea3;
   }

   public void setBoolCoatingEnum(final Boolean boolCoatingEnum) {
      this.boolCoatingEnum = boolCoatingEnum;
   }

   public void setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
   }

   public void setSteelPlateTypeEnum(final Integer steelPlateTypeEnum) {
      this.steelPlateTypeEnum = steelPlateTypeEnum;
   }

   public void setProductClassificationEnum(final Integer productClassificationEnum) {
      this.productClassificationEnum = productClassificationEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechChangeImportDtoParam)) {
         return false;
      }

      TechChangeImportDtoParam other = (TechChangeImportDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderNo = this.getOrderNo();
      Object other$orderNo = other.getOrderNo();
      if (this$orderNo == null ? other$orderNo == null : this$orderNo.equals(other$orderNo)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$boolCoatingEnum = this.getBoolCoatingEnum();
            Object other$boolCoatingEnum = other.getBoolCoatingEnum();
            if (this$boolCoatingEnum == null ? other$boolCoatingEnum == null : this$boolCoatingEnum.equals(other$boolCoatingEnum)) {
               Object this$steelPlateTypeEnum = this.getSteelPlateTypeEnum();
               Object other$steelPlateTypeEnum = other.getSteelPlateTypeEnum();
               if (this$steelPlateTypeEnum == null ? other$steelPlateTypeEnum == null : this$steelPlateTypeEnum.equals(other$steelPlateTypeEnum)) {
                  Object this$productClassificationEnum = this.getProductClassificationEnum();
                  Object other$productClassificationEnum = other.getProductClassificationEnum();
                  if (this$productClassificationEnum == null
                     ? other$productClassificationEnum == null
                     : this$productClassificationEnum.equals(other$productClassificationEnum)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$artifactNo = this.getArtifactNo();
                        Object other$artifactNo = other.getArtifactNo();
                        if (this$artifactNo == null ? other$artifactNo == null : this$artifactNo.equals(other$artifactNo)) {
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
                                          Object this$totalNetWeight = this.getTotalNetWeight();
                                          Object other$totalNetWeight = other.getTotalNetWeight();
                                          if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                                             Object this$grossWeight = this.getGrossWeight();
                                             Object other$grossWeight = other.getGrossWeight();
                                             if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                                                Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                if (this$totalGrossWeight == null
                                                   ? other$totalGrossWeight == null
                                                   : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                   Object this$surfaceArea = this.getSurfaceArea();
                                                   Object other$surfaceArea = other.getSurfaceArea();
                                                   if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
                                                      Object this$surfaceArea2 = this.getSurfaceArea2();
                                                      Object other$surfaceArea2 = other.getSurfaceArea2();
                                                      if (this$surfaceArea2 == null ? other$surfaceArea2 == null : this$surfaceArea2.equals(other$surfaceArea2)
                                                         )
                                                       {
                                                         Object this$surfaceArea3 = this.getSurfaceArea3();
                                                         Object other$surfaceArea3 = other.getSurfaceArea3();
                                                         if (this$surfaceArea3 == null
                                                            ? other$surfaceArea3 == null
                                                            : this$surfaceArea3.equals(other$surfaceArea3)) {
                                                            Object this$specPrefix = this.getSpecPrefix();
                                                            Object other$specPrefix = other.getSpecPrefix();
                                                            return this$specPrefix == null
                                                               ? other$specPrefix == null
                                                               : this$specPrefix.equals(other$specPrefix);
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
      return other instanceof TechChangeImportDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderNo = this.getOrderNo();
      result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $boolCoatingEnum = this.getBoolCoatingEnum();
      result = result * 59 + ($boolCoatingEnum == null ? 43 : $boolCoatingEnum.hashCode());
      Object $steelPlateTypeEnum = this.getSteelPlateTypeEnum();
      result = result * 59 + ($steelPlateTypeEnum == null ? 43 : $steelPlateTypeEnum.hashCode());
      Object $productClassificationEnum = this.getProductClassificationEnum();
      result = result * 59 + ($productClassificationEnum == null ? 43 : $productClassificationEnum.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $artifactNo = this.getArtifactNo();
      result = result * 59 + ($artifactNo == null ? 43 : $artifactNo.hashCode());
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
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $surfaceArea2 = this.getSurfaceArea2();
      result = result * 59 + ($surfaceArea2 == null ? 43 : $surfaceArea2.hashCode());
      Object $surfaceArea3 = this.getSurfaceArea3();
      result = result * 59 + ($surfaceArea3 == null ? 43 : $surfaceArea3.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      return result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
   }

   @Override
   public String toString() {
      return "TechChangeImportDtoParam(orderNo="
         + this.getOrderNo()
         + ", name="
         + this.getName()
         + ", artifactNo="
         + this.getArtifactNo()
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
         + ", netWeight="
         + this.getNetWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", surfaceArea2="
         + this.getSurfaceArea2()
         + ", surfaceArea3="
         + this.getSurfaceArea3()
         + ", boolCoatingEnum="
         + this.getBoolCoatingEnum()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ", steelPlateTypeEnum="
         + this.getSteelPlateTypeEnum()
         + ", productClassificationEnum="
         + this.getProductClassificationEnum()
         + ")";
   }
}
