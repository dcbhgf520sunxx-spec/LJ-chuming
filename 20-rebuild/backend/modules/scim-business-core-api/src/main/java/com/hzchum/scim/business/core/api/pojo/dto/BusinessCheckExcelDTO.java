package com.hzchum.scim.business.core.api.pojo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BusinessCheckExcelDTO {
   private String project;
   private String typeName;
   private String monomer;
   private String remark;
   private String createUserName;
   private LocalDateTime createTime;
   private String checkUserName;
   private LocalDateTime checkTime;
   private String status;
   private String name;
   private String material;
   private String specification;
   private BigDecimal totalWeight;
   private BigDecimal totalLength;
   private BigDecimal totalArea;
   private String pricingMannerName;
   private Integer totalQuantity;
   private BigDecimal totalAmount;
   private String price;
   private String enclosurePlanName;
   private String plate;
   private String thickness;
   private String brand;
   private String color;
   private String categoryName;
   private String usePropertyName;
   private String accountingUnit;
   private BigDecimal mete;
   private String measureUnit;

   public String getProject() {
      return this.project;
   }

   public String getTypeName() {
      return this.typeName;
   }

   public String getMonomer() {
      return this.monomer;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getCheckUserName() {
      return this.checkUserName;
   }

   public LocalDateTime getCheckTime() {
      return this.checkTime;
   }

   public String getStatus() {
      return this.status;
   }

   public String getName() {
      return this.name;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public String getPricingMannerName() {
      return this.pricingMannerName;
   }

   public Integer getTotalQuantity() {
      return this.totalQuantity;
   }

   public BigDecimal getTotalAmount() {
      return this.totalAmount;
   }

   public String getPrice() {
      return this.price;
   }

   public String getEnclosurePlanName() {
      return this.enclosurePlanName;
   }

   public String getPlate() {
      return this.plate;
   }

   public String getThickness() {
      return this.thickness;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getColor() {
      return this.color;
   }

   public String getCategoryName() {
      return this.categoryName;
   }

   public String getUsePropertyName() {
      return this.usePropertyName;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public void setProject(final String project) {
      this.project = project;
   }

   public void setTypeName(final String typeName) {
      this.typeName = typeName;
   }

   public void setMonomer(final String monomer) {
      this.monomer = monomer;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setCheckUserName(final String checkUserName) {
      this.checkUserName = checkUserName;
   }

   public void setCheckTime(final LocalDateTime checkTime) {
      this.checkTime = checkTime;
   }

   public void setStatus(final String status) {
      this.status = status;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   public void setPricingMannerName(final String pricingMannerName) {
      this.pricingMannerName = pricingMannerName;
   }

   public void setTotalQuantity(final Integer totalQuantity) {
      this.totalQuantity = totalQuantity;
   }

   public void setTotalAmount(final BigDecimal totalAmount) {
      this.totalAmount = totalAmount;
   }

   public void setPrice(final String price) {
      this.price = price;
   }

   public void setEnclosurePlanName(final String enclosurePlanName) {
      this.enclosurePlanName = enclosurePlanName;
   }

   public void setPlate(final String plate) {
      this.plate = plate;
   }

   public void setThickness(final String thickness) {
      this.thickness = thickness;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setCategoryName(final String categoryName) {
      this.categoryName = categoryName;
   }

   public void setUsePropertyName(final String usePropertyName) {
      this.usePropertyName = usePropertyName;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessCheckExcelDTO)) {
         return false;
      }

      BusinessCheckExcelDTO other = (BusinessCheckExcelDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$totalQuantity = this.getTotalQuantity();
      Object other$totalQuantity = other.getTotalQuantity();
      if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
         Object this$project = this.getProject();
         Object other$project = other.getProject();
         if (this$project == null ? other$project == null : this$project.equals(other$project)) {
            Object this$typeName = this.getTypeName();
            Object other$typeName = other.getTypeName();
            if (this$typeName == null ? other$typeName == null : this$typeName.equals(other$typeName)) {
               Object this$monomer = this.getMonomer();
               Object other$monomer = other.getMonomer();
               if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                  Object this$remark = this.getRemark();
                  Object other$remark = other.getRemark();
                  if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                     Object this$createUserName = this.getCreateUserName();
                     Object other$createUserName = other.getCreateUserName();
                     if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                        Object this$createTime = this.getCreateTime();
                        Object other$createTime = other.getCreateTime();
                        if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                           Object this$checkUserName = this.getCheckUserName();
                           Object other$checkUserName = other.getCheckUserName();
                           if (this$checkUserName == null ? other$checkUserName == null : this$checkUserName.equals(other$checkUserName)) {
                              Object this$checkTime = this.getCheckTime();
                              Object other$checkTime = other.getCheckTime();
                              if (this$checkTime == null ? other$checkTime == null : this$checkTime.equals(other$checkTime)) {
                                 Object this$status = this.getStatus();
                                 Object other$status = other.getStatus();
                                 if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                                    Object this$name = this.getName();
                                    Object other$name = other.getName();
                                    if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                       Object this$material = this.getMaterial();
                                       Object other$material = other.getMaterial();
                                       if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                          Object this$specification = this.getSpecification();
                                          Object other$specification = other.getSpecification();
                                          if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                             Object this$totalWeight = this.getTotalWeight();
                                             Object other$totalWeight = other.getTotalWeight();
                                             if (this$totalWeight == null ? other$totalWeight == null : this$totalWeight.equals(other$totalWeight)) {
                                                Object this$totalLength = this.getTotalLength();
                                                Object other$totalLength = other.getTotalLength();
                                                if (this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength)) {
                                                   Object this$totalArea = this.getTotalArea();
                                                   Object other$totalArea = other.getTotalArea();
                                                   if (this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea)) {
                                                      Object this$pricingMannerName = this.getPricingMannerName();
                                                      Object other$pricingMannerName = other.getPricingMannerName();
                                                      if (this$pricingMannerName == null
                                                         ? other$pricingMannerName == null
                                                         : this$pricingMannerName.equals(other$pricingMannerName)) {
                                                         Object this$totalAmount = this.getTotalAmount();
                                                         Object other$totalAmount = other.getTotalAmount();
                                                         if (this$totalAmount == null ? other$totalAmount == null : this$totalAmount.equals(other$totalAmount)) {
                                                            Object this$price = this.getPrice();
                                                            Object other$price = other.getPrice();
                                                            if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                                                               Object this$enclosurePlanName = this.getEnclosurePlanName();
                                                               Object other$enclosurePlanName = other.getEnclosurePlanName();
                                                               if (this$enclosurePlanName == null
                                                                  ? other$enclosurePlanName == null
                                                                  : this$enclosurePlanName.equals(other$enclosurePlanName)) {
                                                                  Object this$plate = this.getPlate();
                                                                  Object other$plate = other.getPlate();
                                                                  if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                                                                     Object this$thickness = this.getThickness();
                                                                     Object other$thickness = other.getThickness();
                                                                     if (this$thickness == null
                                                                        ? other$thickness == null
                                                                        : this$thickness.equals(other$thickness)) {
                                                                        Object this$brand = this.getBrand();
                                                                        Object other$brand = other.getBrand();
                                                                        if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                                           Object this$color = this.getColor();
                                                                           Object other$color = other.getColor();
                                                                           if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                                              Object this$categoryName = this.getCategoryName();
                                                                              Object other$categoryName = other.getCategoryName();
                                                                              if (this$categoryName == null
                                                                                 ? other$categoryName == null
                                                                                 : this$categoryName.equals(other$categoryName)) {
                                                                                 Object this$usePropertyName = this.getUsePropertyName();
                                                                                 Object other$usePropertyName = other.getUsePropertyName();
                                                                                 if (this$usePropertyName == null
                                                                                    ? other$usePropertyName == null
                                                                                    : this$usePropertyName.equals(other$usePropertyName)) {
                                                                                    Object this$accountingUnit = this.getAccountingUnit();
                                                                                    Object other$accountingUnit = other.getAccountingUnit();
                                                                                    if (this$accountingUnit == null
                                                                                       ? other$accountingUnit == null
                                                                                       : this$accountingUnit.equals(other$accountingUnit)) {
                                                                                       Object this$mete = this.getMete();
                                                                                       Object other$mete = other.getMete();
                                                                                       if (this$mete == null
                                                                                          ? other$mete == null
                                                                                          : this$mete.equals(other$mete)) {
                                                                                          Object this$measureUnit = this.getMeasureUnit();
                                                                                          Object other$measureUnit = other.getMeasureUnit();
                                                                                          return this$measureUnit == null
                                                                                             ? other$measureUnit == null
                                                                                             : this$measureUnit.equals(other$measureUnit);
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
      return other instanceof BusinessCheckExcelDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $typeName = this.getTypeName();
      result = result * 59 + ($typeName == null ? 43 : $typeName.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $checkUserName = this.getCheckUserName();
      result = result * 59 + ($checkUserName == null ? 43 : $checkUserName.hashCode());
      Object $checkTime = this.getCheckTime();
      result = result * 59 + ($checkTime == null ? 43 : $checkTime.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $pricingMannerName = this.getPricingMannerName();
      result = result * 59 + ($pricingMannerName == null ? 43 : $pricingMannerName.hashCode());
      Object $totalAmount = this.getTotalAmount();
      result = result * 59 + ($totalAmount == null ? 43 : $totalAmount.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $enclosurePlanName = this.getEnclosurePlanName();
      result = result * 59 + ($enclosurePlanName == null ? 43 : $enclosurePlanName.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $categoryName = this.getCategoryName();
      result = result * 59 + ($categoryName == null ? 43 : $categoryName.hashCode());
      Object $usePropertyName = this.getUsePropertyName();
      result = result * 59 + ($usePropertyName == null ? 43 : $usePropertyName.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      return result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
   }

   @Override
   public String toString() {
      return "BusinessCheckExcelDTO(project="
         + this.getProject()
         + ", typeName="
         + this.getTypeName()
         + ", monomer="
         + this.getMonomer()
         + ", remark="
         + this.getRemark()
         + ", createUserName="
         + this.getCreateUserName()
         + ", createTime="
         + this.getCreateTime()
         + ", checkUserName="
         + this.getCheckUserName()
         + ", checkTime="
         + this.getCheckTime()
         + ", status="
         + this.getStatus()
         + ", name="
         + this.getName()
         + ", material="
         + this.getMaterial()
         + ", specification="
         + this.getSpecification()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", totalLength="
         + this.getTotalLength()
         + ", totalArea="
         + this.getTotalArea()
         + ", pricingMannerName="
         + this.getPricingMannerName()
         + ", totalQuantity="
         + this.getTotalQuantity()
         + ", totalAmount="
         + this.getTotalAmount()
         + ", price="
         + this.getPrice()
         + ", enclosurePlanName="
         + this.getEnclosurePlanName()
         + ", plate="
         + this.getPlate()
         + ", thickness="
         + this.getThickness()
         + ", brand="
         + this.getBrand()
         + ", color="
         + this.getColor()
         + ", categoryName="
         + this.getCategoryName()
         + ", usePropertyName="
         + this.getUsePropertyName()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", mete="
         + this.getMete()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ")";
   }
}
