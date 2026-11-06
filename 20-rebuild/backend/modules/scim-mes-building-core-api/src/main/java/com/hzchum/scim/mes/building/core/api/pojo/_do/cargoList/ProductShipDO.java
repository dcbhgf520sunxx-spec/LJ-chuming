package com.hzchum.scim.mes.building.core.api.pojo._do.cargoList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel(description = "产品信息")
public class ProductShipDO {
   @ApiModelProperty(notes = "项目")
   private ProjectInfo project;
   @ApiModelProperty(notes = "单体")
   private NameInfo monomer;
   @ApiModelProperty(notes = "区域")
   private NameInfo area;
   @ApiModelProperty("结构计量方式 1理论计算 2磅记")
   private Integer structureMeasureMode;
   @ApiModelProperty("围护计量方式 1 长度计量 2 面积计量")
   private Integer enclosureMeasureMode;
   @ApiModelProperty("车牌号")
   private String licensePlate;
   @ApiModelProperty("发运时间")
   private LocalDateTime auditTime;
   @ApiModelProperty(notes = "产品类型")
   private Integer productType;
   @ApiModelProperty(notes = "产品id")
   private Long productId;
   @ApiModelProperty(notes = "围护类型")
   private Integer category;
   @ApiModelProperty(notes = "名称")
   private String name;
   @ApiModelProperty(notes = "编号")
   private String serialNumber;
   @ApiModelProperty(notes = "规格")
   private String specification;
   @ApiModelProperty(notes = "材质")
   private String material;
   @ApiModelProperty("计量单位")
   @JsonProperty("measureUnit")
   private String measureUnit;
   @ApiModelProperty(notes = "单净重（kg） 长度（mm） 辅材计量")
   private BigDecimal meteOne;
   @ApiModelProperty("核算单位")
   private String accountingUnit;
   @ApiModelProperty(notes = "构件长度（m） 面积（㎡） 辅材核算量")
   private BigDecimal meteTwo;
   @ApiModelProperty(notes = "过磅重量")
   private BigDecimal meteThree;
   @ApiModelProperty(notes = "发运数量")
   private Integer shipQuantity;
   @ApiModelProperty("单价")
   private BigDecimal unitPrice;

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public Integer getStructureMeasureMode() {
      return this.structureMeasureMode;
   }

   public Integer getEnclosureMeasureMode() {
      return this.enclosureMeasureMode;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getCategory() {
      return this.category;
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

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public BigDecimal getMeteOne() {
      return this.meteOne;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getMeteTwo() {
      return this.meteTwo;
   }

   public BigDecimal getMeteThree() {
      return this.meteThree;
   }

   public Integer getShipQuantity() {
      return this.shipQuantity;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setArea(final NameInfo area) {
      this.area = area;
   }

   public void setStructureMeasureMode(final Integer structureMeasureMode) {
      this.structureMeasureMode = structureMeasureMode;
   }

   public void setEnclosureMeasureMode(final Integer enclosureMeasureMode) {
      this.enclosureMeasureMode = enclosureMeasureMode;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setCategory(final Integer category) {
      this.category = category;
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

   @JsonProperty("measureUnit")
   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setMeteOne(final BigDecimal meteOne) {
      this.meteOne = meteOne;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setMeteTwo(final BigDecimal meteTwo) {
      this.meteTwo = meteTwo;
   }

   public void setMeteThree(final BigDecimal meteThree) {
      this.meteThree = meteThree;
   }

   public void setShipQuantity(final Integer shipQuantity) {
      this.shipQuantity = shipQuantity;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductShipDO)) {
         return false;
      }

      ProductShipDO other = (ProductShipDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$structureMeasureMode = this.getStructureMeasureMode();
      Object other$structureMeasureMode = other.getStructureMeasureMode();
      if (this$structureMeasureMode == null ? other$structureMeasureMode == null : this$structureMeasureMode.equals(other$structureMeasureMode)) {
         Object this$enclosureMeasureMode = this.getEnclosureMeasureMode();
         Object other$enclosureMeasureMode = other.getEnclosureMeasureMode();
         if (this$enclosureMeasureMode == null ? other$enclosureMeasureMode == null : this$enclosureMeasureMode.equals(other$enclosureMeasureMode)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$productId = this.getProductId();
               Object other$productId = other.getProductId();
               if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                  Object this$category = this.getCategory();
                  Object other$category = other.getCategory();
                  if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                     Object this$shipQuantity = this.getShipQuantity();
                     Object other$shipQuantity = other.getShipQuantity();
                     if (this$shipQuantity == null ? other$shipQuantity == null : this$shipQuantity.equals(other$shipQuantity)) {
                        Object this$project = this.getProject();
                        Object other$project = other.getProject();
                        if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                           Object this$monomer = this.getMonomer();
                           Object other$monomer = other.getMonomer();
                           if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                              Object this$area = this.getArea();
                              Object other$area = other.getArea();
                              if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                 Object this$licensePlate = this.getLicensePlate();
                                 Object other$licensePlate = other.getLicensePlate();
                                 if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                                    Object this$auditTime = this.getAuditTime();
                                    Object other$auditTime = other.getAuditTime();
                                    if (this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime)) {
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
                                                   Object this$measureUnit = this.getMeasureUnit();
                                                   Object other$measureUnit = other.getMeasureUnit();
                                                   if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                                                      Object this$meteOne = this.getMeteOne();
                                                      Object other$meteOne = other.getMeteOne();
                                                      if (this$meteOne == null ? other$meteOne == null : this$meteOne.equals(other$meteOne)) {
                                                         Object this$accountingUnit = this.getAccountingUnit();
                                                         Object other$accountingUnit = other.getAccountingUnit();
                                                         if (this$accountingUnit == null
                                                            ? other$accountingUnit == null
                                                            : this$accountingUnit.equals(other$accountingUnit)) {
                                                            Object this$meteTwo = this.getMeteTwo();
                                                            Object other$meteTwo = other.getMeteTwo();
                                                            if (this$meteTwo == null ? other$meteTwo == null : this$meteTwo.equals(other$meteTwo)) {
                                                               Object this$meteThree = this.getMeteThree();
                                                               Object other$meteThree = other.getMeteThree();
                                                               if (this$meteThree == null ? other$meteThree == null : this$meteThree.equals(other$meteThree)) {
                                                                  Object this$unitPrice = this.getUnitPrice();
                                                                  Object other$unitPrice = other.getUnitPrice();
                                                                  return this$unitPrice == null
                                                                     ? other$unitPrice == null
                                                                     : this$unitPrice.equals(other$unitPrice);
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
      return other instanceof ProductShipDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $structureMeasureMode = this.getStructureMeasureMode();
      result = result * 59 + ($structureMeasureMode == null ? 43 : $structureMeasureMode.hashCode());
      Object $enclosureMeasureMode = this.getEnclosureMeasureMode();
      result = result * 59 + ($enclosureMeasureMode == null ? 43 : $enclosureMeasureMode.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $shipQuantity = this.getShipQuantity();
      result = result * 59 + ($shipQuantity == null ? 43 : $shipQuantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $meteOne = this.getMeteOne();
      result = result * 59 + ($meteOne == null ? 43 : $meteOne.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $meteTwo = this.getMeteTwo();
      result = result * 59 + ($meteTwo == null ? 43 : $meteTwo.hashCode());
      Object $meteThree = this.getMeteThree();
      result = result * 59 + ($meteThree == null ? 43 : $meteThree.hashCode());
      Object $unitPrice = this.getUnitPrice();
      return result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
   }

   @Override
   public String toString() {
      return "ProductShipDO(project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", structureMeasureMode="
         + this.getStructureMeasureMode()
         + ", enclosureMeasureMode="
         + this.getEnclosureMeasureMode()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", auditTime="
         + this.getAuditTime()
         + ", productType="
         + this.getProductType()
         + ", productId="
         + this.getProductId()
         + ", category="
         + this.getCategory()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", meteOne="
         + this.getMeteOne()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", meteTwo="
         + this.getMeteTwo()
         + ", meteThree="
         + this.getMeteThree()
         + ", shipQuantity="
         + this.getShipQuantity()
         + ", unitPrice="
         + this.getUnitPrice()
         + ")";
   }
}
