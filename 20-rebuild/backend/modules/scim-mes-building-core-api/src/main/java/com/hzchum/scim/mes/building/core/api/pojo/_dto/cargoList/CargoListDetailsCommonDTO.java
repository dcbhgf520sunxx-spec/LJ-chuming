package com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class CargoListDetailsCommonDTO {
   @ApiModelProperty(notes = "包详情id")
   private Long linkId;
   @ApiModelProperty(notes = "项目")
   private ProjectInfo project;
   @ApiModelProperty(notes = "单体")
   @JsonInclude(Include.NON_NULL)
   private NameInfo monomer;
   @ApiModelProperty(notes = "区域")
   @JsonInclude(Include.NON_NULL)
   private NameInfo area;
   @ApiModelProperty(name = "productType", value = "产品类型")
   private Integer productType;
   @ApiModelProperty(name = "productId", value = "产品id")
   private Long productId;
   @ApiModelProperty("名称")
   private String name;
   @ApiModelProperty("编号")
   private String serialNumber;
   @ApiModelProperty("规格")
   private String specification;
   @ApiModelProperty("长度（mm）")
   private BigDecimal length;
   @ApiModelProperty("材质")
   private String material;
   @ApiModelProperty("清单数量")
   private BigDecimal quantity;
   @ApiModelProperty("单净重（kg）")
   private BigDecimal netWeight;
   @ApiModelProperty("总净重（kg）")
   private BigDecimal totalNetWeight;
   @ApiModelProperty("单毛重（kg）")
   private BigDecimal grossWeight;
   @ApiModelProperty("总毛重（kg）")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty("参与计算重量（kg）")
   private BigDecimal weight;
   @ApiModelProperty("总参与计算重量（kg）")
   private BigDecimal totalWeight;
   @ApiModelProperty("单价")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal unitPrice;
   @ApiModelProperty("总价")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal totalPrice;
   @ApiModelProperty("当前装车数")
   private BigDecimal shipQuantity;
   @ApiModelProperty("计量单位")
   private String measureUnit;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   private BigDecimal mete;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   private String accountingUnit;
   @ApiModelProperty(name = "unit", value = "核算单位", notes = "核算单位")
   private String unit;
   @ApiModelProperty(name = "packageId", value = "包id", notes = "包id")
   private Long packageId;
   @ApiModelProperty(name = "packSerialNumber", value = "包单号", notes = "包单号")
   private String packSerialNumber;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;

   public static CargoListDetailsCommonDTO.CargoListDetailsCommonDTOBuilder builder() {
      return new CargoListDetailsCommonDTO.CargoListDetailsCommonDTOBuilder();
   }

   public CargoListDetailsCommonDTO() {
   }

   public CargoListDetailsCommonDTO(
      final Long linkId,
      final ProjectInfo project,
      final NameInfo monomer,
      final NameInfo area,
      final Integer productType,
      final Long productId,
      final String name,
      final String serialNumber,
      final String specification,
      final BigDecimal length,
      final String material,
      final BigDecimal quantity,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal grossWeight,
      final BigDecimal totalGrossWeight,
      final BigDecimal weight,
      final BigDecimal totalWeight,
      final BigDecimal unitPrice,
      final BigDecimal totalPrice,
      final BigDecimal shipQuantity,
      final String measureUnit,
      final BigDecimal mete,
      final String accountingUnit,
      final String unit,
      final Long packageId,
      final String packSerialNumber,
      final String remark
   ) {
      this.linkId = linkId;
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.productType = productType;
      this.productId = productId;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.quantity = quantity;
      this.netWeight = netWeight;
      this.totalNetWeight = totalNetWeight;
      this.grossWeight = grossWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.weight = weight;
      this.totalWeight = totalWeight;
      this.unitPrice = unitPrice;
      this.totalPrice = totalPrice;
      this.shipQuantity = shipQuantity;
      this.measureUnit = measureUnit;
      this.mete = mete;
      this.accountingUnit = accountingUnit;
      this.unit = unit;
      this.packageId = packageId;
      this.packSerialNumber = packSerialNumber;
      this.remark = remark;
   }

   public Long getLinkId() {
      return this.linkId;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getProductId() {
      return this.productId;
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

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getQuantity() {
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

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public BigDecimal getShipQuantity() {
      return this.shipQuantity;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public String getUnit() {
      return this.unit;
   }

   public Long getPackageId() {
      return this.packageId;
   }

   public String getPackSerialNumber() {
      return this.packSerialNumber;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setLinkId(final Long linkId) {
      this.linkId = linkId;
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

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
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

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setQuantity(final BigDecimal quantity) {
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

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
   }

   public void setShipQuantity(final BigDecimal shipQuantity) {
      this.shipQuantity = shipQuantity;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setPackageId(final Long packageId) {
      this.packageId = packageId;
   }

   public void setPackSerialNumber(final String packSerialNumber) {
      this.packSerialNumber = packSerialNumber;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListDetailsCommonDTO)) {
         return false;
      }

      CargoListDetailsCommonDTO other = (CargoListDetailsCommonDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$linkId = this.getLinkId();
      Object other$linkId = other.getLinkId();
      if (this$linkId == null ? other$linkId == null : this$linkId.equals(other$linkId)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$productId = this.getProductId();
            Object other$productId = other.getProductId();
            if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
               Object this$packageId = this.getPackageId();
               Object other$packageId = other.getPackageId();
               if (this$packageId == null ? other$packageId == null : this$packageId.equals(other$packageId)) {
                  Object this$project = this.getProject();
                  Object other$project = other.getProject();
                  if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                     Object this$monomer = this.getMonomer();
                     Object other$monomer = other.getMonomer();
                     if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                        Object this$area = this.getArea();
                        Object other$area = other.getArea();
                        if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
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
                                          Object this$quantity = this.getQuantity();
                                          Object other$quantity = other.getQuantity();
                                          if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                             Object this$netWeight = this.getNetWeight();
                                             Object other$netWeight = other.getNetWeight();
                                             if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                                Object this$totalNetWeight = this.getTotalNetWeight();
                                                Object other$totalNetWeight = other.getTotalNetWeight();
                                                if (this$totalNetWeight == null
                                                   ? other$totalNetWeight == null
                                                   : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                   Object this$grossWeight = this.getGrossWeight();
                                                   Object other$grossWeight = other.getGrossWeight();
                                                   if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                                                      Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                      Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                      if (this$totalGrossWeight == null
                                                         ? other$totalGrossWeight == null
                                                         : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                         Object this$weight = this.getWeight();
                                                         Object other$weight = other.getWeight();
                                                         if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                                            Object this$totalWeight = this.getTotalWeight();
                                                            Object other$totalWeight = other.getTotalWeight();
                                                            if (this$totalWeight == null
                                                               ? other$totalWeight == null
                                                               : this$totalWeight.equals(other$totalWeight)) {
                                                               Object this$unitPrice = this.getUnitPrice();
                                                               Object other$unitPrice = other.getUnitPrice();
                                                               if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                                                                  Object this$totalPrice = this.getTotalPrice();
                                                                  Object other$totalPrice = other.getTotalPrice();
                                                                  if (this$totalPrice == null
                                                                     ? other$totalPrice == null
                                                                     : this$totalPrice.equals(other$totalPrice)) {
                                                                     Object this$shipQuantity = this.getShipQuantity();
                                                                     Object other$shipQuantity = other.getShipQuantity();
                                                                     if (this$shipQuantity == null
                                                                        ? other$shipQuantity == null
                                                                        : this$shipQuantity.equals(other$shipQuantity)) {
                                                                        Object this$measureUnit = this.getMeasureUnit();
                                                                        Object other$measureUnit = other.getMeasureUnit();
                                                                        if (this$measureUnit == null
                                                                           ? other$measureUnit == null
                                                                           : this$measureUnit.equals(other$measureUnit)) {
                                                                           Object this$mete = this.getMete();
                                                                           Object other$mete = other.getMete();
                                                                           if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                                              Object this$accountingUnit = this.getAccountingUnit();
                                                                              Object other$accountingUnit = other.getAccountingUnit();
                                                                              if (this$accountingUnit == null
                                                                                 ? other$accountingUnit == null
                                                                                 : this$accountingUnit.equals(other$accountingUnit)) {
                                                                                 Object this$unit = this.getUnit();
                                                                                 Object other$unit = other.getUnit();
                                                                                 if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                                                                                    Object this$packSerialNumber = this.getPackSerialNumber();
                                                                                    Object other$packSerialNumber = other.getPackSerialNumber();
                                                                                    if (this$packSerialNumber == null
                                                                                       ? other$packSerialNumber == null
                                                                                       : this$packSerialNumber.equals(other$packSerialNumber)) {
                                                                                       Object this$remark = this.getRemark();
                                                                                       Object other$remark = other.getRemark();
                                                                                       return this$remark == null
                                                                                          ? other$remark == null
                                                                                          : this$remark.equals(other$remark);
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
      return other instanceof CargoListDetailsCommonDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $linkId = this.getLinkId();
      result = result * 59 + ($linkId == null ? 43 : $linkId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $packageId = this.getPackageId();
      result = result * 59 + ($packageId == null ? 43 : $packageId.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $totalPrice = this.getTotalPrice();
      result = result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
      Object $shipQuantity = this.getShipQuantity();
      result = result * 59 + ($shipQuantity == null ? 43 : $shipQuantity.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $packSerialNumber = this.getPackSerialNumber();
      result = result * 59 + ($packSerialNumber == null ? 43 : $packSerialNumber.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "CargoListDetailsCommonDTO(linkId="
         + this.getLinkId()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", productType="
         + this.getProductType()
         + ", productId="
         + this.getProductId()
         + ", name="
         + this.getName()
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
         + ", weight="
         + this.getWeight()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", shipQuantity="
         + this.getShipQuantity()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", mete="
         + this.getMete()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", unit="
         + this.getUnit()
         + ", packageId="
         + this.getPackageId()
         + ", packSerialNumber="
         + this.getPackSerialNumber()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class CargoListDetailsCommonDTOBuilder {
      private Long linkId;
      private ProjectInfo project;
      private NameInfo monomer;
      private NameInfo area;
      private Integer productType;
      private Long productId;
      private String name;
      private String serialNumber;
      private String specification;
      private BigDecimal length;
      private String material;
      private BigDecimal quantity;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal grossWeight;
      private BigDecimal totalGrossWeight;
      private BigDecimal weight;
      private BigDecimal totalWeight;
      private BigDecimal unitPrice;
      private BigDecimal totalPrice;
      private BigDecimal shipQuantity;
      private String measureUnit;
      private BigDecimal mete;
      private String accountingUnit;
      private String unit;
      private Long packageId;
      private String packSerialNumber;
      private String remark;

      CargoListDetailsCommonDTOBuilder() {
      }

      public CargoListDetailsCommonDTO.CargoListDetailsCommonDTOBuilder linkId(final Long linkId) {
         this.linkId = linkId;
         return this;
      }

      public CargoListDetailsCommonDTO.CargoListDetailsCommonDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public CargoListDetailsCommonDTO.CargoListDetailsCommonDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public CargoListDetailsCommonDTO.CargoListDetailsCommonDTOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      public CargoListDetailsCommonDTO.CargoListDetailsCommonDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public CargoListDetailsCommonDTO.CargoListDetailsCommonDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public CargoListDetailsCommonDTO.CargoListDetailsCommonDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public CargoListDetailsCommonDTO.CargoListDetailsCommonDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public CargoListDetailsCommonDTO.CargoListDetailsCommonDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public CargoListDetailsCommonDTO.CargoListDetailsCommonDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public CargoListDetailsCommonDTO.CargoListDetailsCommonDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public CargoListDetailsCommonDTO.CargoListDetailsCommonDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public CargoListDetailsCommonDTO.CargoListDetailsCommonDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public CargoListDetailsCommonDTO.CargoListDetailsCommonDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public CargoListDetailsCommonDTO.CargoListDetailsCommonDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public CargoListDetailsCommonDTO.CargoListDetailsCommonDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public CargoListDetailsCommonDTO.CargoListDetailsCommonDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public CargoListDetailsCommonDTO.CargoListDetailsCommonDTOBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      public CargoListDetailsCommonDTO.CargoListDetailsCommonDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public CargoListDetailsCommonDTO.CargoListDetailsCommonDTOBuilder totalPrice(final BigDecimal totalPrice) {
         this.totalPrice = totalPrice;
         return this;
      }

      public CargoListDetailsCommonDTO.CargoListDetailsCommonDTOBuilder shipQuantity(final BigDecimal shipQuantity) {
         this.shipQuantity = shipQuantity;
         return this;
      }

      public CargoListDetailsCommonDTO.CargoListDetailsCommonDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public CargoListDetailsCommonDTO.CargoListDetailsCommonDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public CargoListDetailsCommonDTO.CargoListDetailsCommonDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public CargoListDetailsCommonDTO.CargoListDetailsCommonDTOBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public CargoListDetailsCommonDTO.CargoListDetailsCommonDTOBuilder packageId(final Long packageId) {
         this.packageId = packageId;
         return this;
      }

      public CargoListDetailsCommonDTO.CargoListDetailsCommonDTOBuilder packSerialNumber(final String packSerialNumber) {
         this.packSerialNumber = packSerialNumber;
         return this;
      }

      public CargoListDetailsCommonDTO.CargoListDetailsCommonDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public CargoListDetailsCommonDTO build() {
         return new CargoListDetailsCommonDTO(
            this.linkId,
            this.project,
            this.monomer,
            this.area,
            this.productType,
            this.productId,
            this.name,
            this.serialNumber,
            this.specification,
            this.length,
            this.material,
            this.quantity,
            this.netWeight,
            this.totalNetWeight,
            this.grossWeight,
            this.totalGrossWeight,
            this.weight,
            this.totalWeight,
            this.unitPrice,
            this.totalPrice,
            this.shipQuantity,
            this.measureUnit,
            this.mete,
            this.accountingUnit,
            this.unit,
            this.packageId,
            this.packSerialNumber,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "CargoListDetailsCommonDTO.CargoListDetailsCommonDTOBuilder(linkId="
            + this.linkId
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", productType="
            + this.productType
            + ", productId="
            + this.productId
            + ", name="
            + this.name
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
            + ", netWeight="
            + this.netWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", grossWeight="
            + this.grossWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", weight="
            + this.weight
            + ", totalWeight="
            + this.totalWeight
            + ", unitPrice="
            + this.unitPrice
            + ", totalPrice="
            + this.totalPrice
            + ", shipQuantity="
            + this.shipQuantity
            + ", measureUnit="
            + this.measureUnit
            + ", mete="
            + this.mete
            + ", accountingUnit="
            + this.accountingUnit
            + ", unit="
            + this.unit
            + ", packageId="
            + this.packageId
            + ", packSerialNumber="
            + this.packSerialNumber
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
