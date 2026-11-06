package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OutboundDetailManufacturedDTO {
   @ApiModelProperty("出库明细ID")
   private Long id;
   @ApiModelProperty("制成品出库单ID")
   private Long outboundManufacturedId;
   @ApiModelProperty("制成品出库单编号")
   private String outboundManufacturedSerialNumber;
   @ApiModelProperty("申请人")
   private String applicantName;
   @ApiModelProperty("申请日期")
   private LocalDateTime applicationTime;
   @ApiModelProperty("出库日期")
   private LocalDateTime reviewPassTime;
   @ApiModelProperty("物料基础类型")
   private Integer basicClass;
   @ApiModelProperty("制成品名称")
   private String manufacturedName;
   @ApiModelProperty("制成品编号")
   private String manufacturedSn;
   @ApiModelProperty("制成品材质")
   private String material;
   @ApiModelProperty("规格")
   private String specification;
   @ApiModelProperty("长度（mm）")
   private BigDecimal length;
   @ApiModelProperty("有效宽度（mm）")
   private BigDecimal width;
   @ApiModelProperty("厚度（mm）")
   private BigDecimal thickness;
   @ApiModelProperty("品牌")
   private String brand;
   @ApiModelProperty("颜色")
   private String color;
   @ApiModelProperty("单重（g）")
   private BigDecimal weight;
   @ApiModelProperty("总重（g）")
   private BigDecimal totalWeight;
   @ApiModelProperty("总长（mm）")
   private BigDecimal totalLength;
   @ApiModelProperty("单面积（mm²）")
   private BigDecimal surfaceArea;
   @ApiModelProperty("总面积（mm²）")
   private BigDecimal totalArea;
   @ApiModelProperty("制成品计价方式 WmsWageQuotaTypeEnum")
   private Integer wageQuotaType;
   @ApiModelProperty("数量")
   private BigDecimal quantity;
   @ApiModelProperty("制成品单位")
   private String manufacturedUnit;
   @ApiModelProperty("不含税总价")
   private BigDecimal amountExcludingVat;
   @ApiModelProperty("不含税单价")
   private BigDecimal unitPriceExcludingVat;
   @ApiModelProperty("进项税")
   private BigDecimal inputVat;
   @ApiModelProperty("含税单价")
   private BigDecimal unitPrice;
   @ApiModelProperty("出库总价 含税")
   private BigDecimal amount;
   @ApiModelProperty("备注")
   private String remark;
   @ApiModelProperty("项目信息")
   private IdAndNameDTO project;
   @ApiModelProperty("单体信息")
   private IdAndNameDTO monomer;
   @ApiModelProperty("区域信息")
   private IdAndNameDTO area;

   public static OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder builder() {
      return new OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getOutboundManufacturedId() {
      return this.outboundManufacturedId;
   }

   public String getOutboundManufacturedSerialNumber() {
      return this.outboundManufacturedSerialNumber;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public LocalDateTime getApplicationTime() {
      return this.applicationTime;
   }

   public LocalDateTime getReviewPassTime() {
      return this.reviewPassTime;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getManufacturedName() {
      return this.manufacturedName;
   }

   public String getManufacturedSn() {
      return this.manufacturedSn;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getColor() {
      return this.color;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public String getManufacturedUnit() {
      return this.manufacturedUnit;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public BigDecimal getUnitPriceExcludingVat() {
      return this.unitPriceExcludingVat;
   }

   public BigDecimal getInputVat() {
      return this.inputVat;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public String getRemark() {
      return this.remark;
   }

   public IdAndNameDTO getProject() {
      return this.project;
   }

   public IdAndNameDTO getMonomer() {
      return this.monomer;
   }

   public IdAndNameDTO getArea() {
      return this.area;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setOutboundManufacturedId(final Long outboundManufacturedId) {
      this.outboundManufacturedId = outboundManufacturedId;
   }

   public void setOutboundManufacturedSerialNumber(final String outboundManufacturedSerialNumber) {
      this.outboundManufacturedSerialNumber = outboundManufacturedSerialNumber;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setApplicationTime(final LocalDateTime applicationTime) {
      this.applicationTime = applicationTime;
   }

   public void setReviewPassTime(final LocalDateTime reviewPassTime) {
      this.reviewPassTime = reviewPassTime;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setManufacturedName(final String manufacturedName) {
      this.manufacturedName = manufacturedName;
   }

   public void setManufacturedSn(final String manufacturedSn) {
      this.manufacturedSn = manufacturedSn;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   public void setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setManufacturedUnit(final String manufacturedUnit) {
      this.manufacturedUnit = manufacturedUnit;
   }

   public void setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
   }

   public void setUnitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
      this.unitPriceExcludingVat = unitPriceExcludingVat;
   }

   public void setInputVat(final BigDecimal inputVat) {
      this.inputVat = inputVat;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setProject(final IdAndNameDTO project) {
      this.project = project;
   }

   public void setMonomer(final IdAndNameDTO monomer) {
      this.monomer = monomer;
   }

   public void setArea(final IdAndNameDTO area) {
      this.area = area;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OutboundDetailManufacturedDTO)) {
         return false;
      }

      OutboundDetailManufacturedDTO other = (OutboundDetailManufacturedDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$outboundManufacturedId = this.getOutboundManufacturedId();
         Object other$outboundManufacturedId = other.getOutboundManufacturedId();
         if (this$outboundManufacturedId == null ? other$outboundManufacturedId == null : this$outboundManufacturedId.equals(other$outboundManufacturedId)) {
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
               Object this$wageQuotaType = this.getWageQuotaType();
               Object other$wageQuotaType = other.getWageQuotaType();
               if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
                  Object this$outboundManufacturedSerialNumber = this.getOutboundManufacturedSerialNumber();
                  Object other$outboundManufacturedSerialNumber = other.getOutboundManufacturedSerialNumber();
                  if (this$outboundManufacturedSerialNumber == null
                     ? other$outboundManufacturedSerialNumber == null
                     : this$outboundManufacturedSerialNumber.equals(other$outboundManufacturedSerialNumber)) {
                     Object this$applicantName = this.getApplicantName();
                     Object other$applicantName = other.getApplicantName();
                     if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                        Object this$applicationTime = this.getApplicationTime();
                        Object other$applicationTime = other.getApplicationTime();
                        if (this$applicationTime == null ? other$applicationTime == null : this$applicationTime.equals(other$applicationTime)) {
                           Object this$reviewPassTime = this.getReviewPassTime();
                           Object other$reviewPassTime = other.getReviewPassTime();
                           if (this$reviewPassTime == null ? other$reviewPassTime == null : this$reviewPassTime.equals(other$reviewPassTime)) {
                              Object this$manufacturedName = this.getManufacturedName();
                              Object other$manufacturedName = other.getManufacturedName();
                              if (this$manufacturedName == null ? other$manufacturedName == null : this$manufacturedName.equals(other$manufacturedName)) {
                                 Object this$manufacturedSn = this.getManufacturedSn();
                                 Object other$manufacturedSn = other.getManufacturedSn();
                                 if (this$manufacturedSn == null ? other$manufacturedSn == null : this$manufacturedSn.equals(other$manufacturedSn)) {
                                    Object this$material = this.getMaterial();
                                    Object other$material = other.getMaterial();
                                    if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                       Object this$specification = this.getSpecification();
                                       Object other$specification = other.getSpecification();
                                       if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                          Object this$length = this.getLength();
                                          Object other$length = other.getLength();
                                          if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                             Object this$width = this.getWidth();
                                             Object other$width = other.getWidth();
                                             if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                Object this$thickness = this.getThickness();
                                                Object other$thickness = other.getThickness();
                                                if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                   Object this$brand = this.getBrand();
                                                   Object other$brand = other.getBrand();
                                                   if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                      Object this$color = this.getColor();
                                                      Object other$color = other.getColor();
                                                      if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                         Object this$weight = this.getWeight();
                                                         Object other$weight = other.getWeight();
                                                         if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                                            Object this$totalWeight = this.getTotalWeight();
                                                            Object other$totalWeight = other.getTotalWeight();
                                                            if (this$totalWeight == null
                                                               ? other$totalWeight == null
                                                               : this$totalWeight.equals(other$totalWeight)) {
                                                               Object this$totalLength = this.getTotalLength();
                                                               Object other$totalLength = other.getTotalLength();
                                                               if (this$totalLength == null
                                                                  ? other$totalLength == null
                                                                  : this$totalLength.equals(other$totalLength)) {
                                                                  Object this$surfaceArea = this.getSurfaceArea();
                                                                  Object other$surfaceArea = other.getSurfaceArea();
                                                                  if (this$surfaceArea == null
                                                                     ? other$surfaceArea == null
                                                                     : this$surfaceArea.equals(other$surfaceArea)) {
                                                                     Object this$totalArea = this.getTotalArea();
                                                                     Object other$totalArea = other.getTotalArea();
                                                                     if (this$totalArea == null
                                                                        ? other$totalArea == null
                                                                        : this$totalArea.equals(other$totalArea)) {
                                                                        Object this$quantity = this.getQuantity();
                                                                        Object other$quantity = other.getQuantity();
                                                                        if (this$quantity == null
                                                                           ? other$quantity == null
                                                                           : this$quantity.equals(other$quantity)) {
                                                                           Object this$manufacturedUnit = this.getManufacturedUnit();
                                                                           Object other$manufacturedUnit = other.getManufacturedUnit();
                                                                           if (this$manufacturedUnit == null
                                                                              ? other$manufacturedUnit == null
                                                                              : this$manufacturedUnit.equals(other$manufacturedUnit)) {
                                                                              Object this$amountExcludingVat = this.getAmountExcludingVat();
                                                                              Object other$amountExcludingVat = other.getAmountExcludingVat();
                                                                              if (this$amountExcludingVat == null
                                                                                 ? other$amountExcludingVat == null
                                                                                 : this$amountExcludingVat.equals(other$amountExcludingVat)) {
                                                                                 Object this$unitPriceExcludingVat = this.getUnitPriceExcludingVat();
                                                                                 Object other$unitPriceExcludingVat = other.getUnitPriceExcludingVat();
                                                                                 if (this$unitPriceExcludingVat == null
                                                                                    ? other$unitPriceExcludingVat == null
                                                                                    : this$unitPriceExcludingVat.equals(other$unitPriceExcludingVat)) {
                                                                                    Object this$inputVat = this.getInputVat();
                                                                                    Object other$inputVat = other.getInputVat();
                                                                                    if (this$inputVat == null
                                                                                       ? other$inputVat == null
                                                                                       : this$inputVat.equals(other$inputVat)) {
                                                                                       Object this$unitPrice = this.getUnitPrice();
                                                                                       Object other$unitPrice = other.getUnitPrice();
                                                                                       if (this$unitPrice == null
                                                                                          ? other$unitPrice == null
                                                                                          : this$unitPrice.equals(other$unitPrice)) {
                                                                                          Object this$amount = this.getAmount();
                                                                                          Object other$amount = other.getAmount();
                                                                                          if (this$amount == null
                                                                                             ? other$amount == null
                                                                                             : this$amount.equals(other$amount)) {
                                                                                             Object this$remark = this.getRemark();
                                                                                             Object other$remark = other.getRemark();
                                                                                             if (this$remark == null
                                                                                                ? other$remark == null
                                                                                                : this$remark.equals(other$remark)) {
                                                                                                Object this$project = this.getProject();
                                                                                                Object other$project = other.getProject();
                                                                                                if (this$project == null
                                                                                                   ? other$project == null
                                                                                                   : this$project.equals(other$project)) {
                                                                                                   Object this$monomer = this.getMonomer();
                                                                                                   Object other$monomer = other.getMonomer();
                                                                                                   if (this$monomer == null
                                                                                                      ? other$monomer == null
                                                                                                      : this$monomer.equals(other$monomer)) {
                                                                                                      Object this$area = this.getArea();
                                                                                                      Object other$area = other.getArea();
                                                                                                      return this$area == null
                                                                                                         ? other$area == null
                                                                                                         : this$area.equals(other$area);
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
      return other instanceof OutboundDetailManufacturedDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $outboundManufacturedId = this.getOutboundManufacturedId();
      result = result * 59 + ($outboundManufacturedId == null ? 43 : $outboundManufacturedId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $outboundManufacturedSerialNumber = this.getOutboundManufacturedSerialNumber();
      result = result * 59 + ($outboundManufacturedSerialNumber == null ? 43 : $outboundManufacturedSerialNumber.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $applicationTime = this.getApplicationTime();
      result = result * 59 + ($applicationTime == null ? 43 : $applicationTime.hashCode());
      Object $reviewPassTime = this.getReviewPassTime();
      result = result * 59 + ($reviewPassTime == null ? 43 : $reviewPassTime.hashCode());
      Object $manufacturedName = this.getManufacturedName();
      result = result * 59 + ($manufacturedName == null ? 43 : $manufacturedName.hashCode());
      Object $manufacturedSn = this.getManufacturedSn();
      result = result * 59 + ($manufacturedSn == null ? 43 : $manufacturedSn.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $manufacturedUnit = this.getManufacturedUnit();
      result = result * 59 + ($manufacturedUnit == null ? 43 : $manufacturedUnit.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $unitPriceExcludingVat = this.getUnitPriceExcludingVat();
      result = result * 59 + ($unitPriceExcludingVat == null ? 43 : $unitPriceExcludingVat.hashCode());
      Object $inputVat = this.getInputVat();
      result = result * 59 + ($inputVat == null ? 43 : $inputVat.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      return result * 59 + ($area == null ? 43 : $area.hashCode());
   }

   @Override
   public String toString() {
      return "OutboundDetailManufacturedDTO(id="
         + this.getId()
         + ", outboundManufacturedId="
         + this.getOutboundManufacturedId()
         + ", outboundManufacturedSerialNumber="
         + this.getOutboundManufacturedSerialNumber()
         + ", applicantName="
         + this.getApplicantName()
         + ", applicationTime="
         + this.getApplicationTime()
         + ", reviewPassTime="
         + this.getReviewPassTime()
         + ", basicClass="
         + this.getBasicClass()
         + ", manufacturedName="
         + this.getManufacturedName()
         + ", manufacturedSn="
         + this.getManufacturedSn()
         + ", material="
         + this.getMaterial()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", brand="
         + this.getBrand()
         + ", color="
         + this.getColor()
         + ", weight="
         + this.getWeight()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", totalLength="
         + this.getTotalLength()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", totalArea="
         + this.getTotalArea()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", quantity="
         + this.getQuantity()
         + ", manufacturedUnit="
         + this.getManufacturedUnit()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", unitPriceExcludingVat="
         + this.getUnitPriceExcludingVat()
         + ", inputVat="
         + this.getInputVat()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", amount="
         + this.getAmount()
         + ", remark="
         + this.getRemark()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ")";
   }

   public OutboundDetailManufacturedDTO(
      final Long id,
      final Long outboundManufacturedId,
      final String outboundManufacturedSerialNumber,
      final String applicantName,
      final LocalDateTime applicationTime,
      final LocalDateTime reviewPassTime,
      final Integer basicClass,
      final String manufacturedName,
      final String manufacturedSn,
      final String material,
      final String specification,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final String brand,
      final String color,
      final BigDecimal weight,
      final BigDecimal totalWeight,
      final BigDecimal totalLength,
      final BigDecimal surfaceArea,
      final BigDecimal totalArea,
      final Integer wageQuotaType,
      final BigDecimal quantity,
      final String manufacturedUnit,
      final BigDecimal amountExcludingVat,
      final BigDecimal unitPriceExcludingVat,
      final BigDecimal inputVat,
      final BigDecimal unitPrice,
      final BigDecimal amount,
      final String remark,
      final IdAndNameDTO project,
      final IdAndNameDTO monomer,
      final IdAndNameDTO area
   ) {
      this.id = id;
      this.outboundManufacturedId = outboundManufacturedId;
      this.outboundManufacturedSerialNumber = outboundManufacturedSerialNumber;
      this.applicantName = applicantName;
      this.applicationTime = applicationTime;
      this.reviewPassTime = reviewPassTime;
      this.basicClass = basicClass;
      this.manufacturedName = manufacturedName;
      this.manufacturedSn = manufacturedSn;
      this.material = material;
      this.specification = specification;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.brand = brand;
      this.color = color;
      this.weight = weight;
      this.totalWeight = totalWeight;
      this.totalLength = totalLength;
      this.surfaceArea = surfaceArea;
      this.totalArea = totalArea;
      this.wageQuotaType = wageQuotaType;
      this.quantity = quantity;
      this.manufacturedUnit = manufacturedUnit;
      this.amountExcludingVat = amountExcludingVat;
      this.unitPriceExcludingVat = unitPriceExcludingVat;
      this.inputVat = inputVat;
      this.unitPrice = unitPrice;
      this.amount = amount;
      this.remark = remark;
      this.project = project;
      this.monomer = monomer;
      this.area = area;
   }

   public OutboundDetailManufacturedDTO() {
   }

   public static class OutboundDetailManufacturedDTOBuilder {
      private Long id;
      private Long outboundManufacturedId;
      private String outboundManufacturedSerialNumber;
      private String applicantName;
      private LocalDateTime applicationTime;
      private LocalDateTime reviewPassTime;
      private Integer basicClass;
      private String manufacturedName;
      private String manufacturedSn;
      private String material;
      private String specification;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private String brand;
      private String color;
      private BigDecimal weight;
      private BigDecimal totalWeight;
      private BigDecimal totalLength;
      private BigDecimal surfaceArea;
      private BigDecimal totalArea;
      private Integer wageQuotaType;
      private BigDecimal quantity;
      private String manufacturedUnit;
      private BigDecimal amountExcludingVat;
      private BigDecimal unitPriceExcludingVat;
      private BigDecimal inputVat;
      private BigDecimal unitPrice;
      private BigDecimal amount;
      private String remark;
      private IdAndNameDTO project;
      private IdAndNameDTO monomer;
      private IdAndNameDTO area;

      OutboundDetailManufacturedDTOBuilder() {
      }

      public OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder outboundManufacturedId(final Long outboundManufacturedId) {
         this.outboundManufacturedId = outboundManufacturedId;
         return this;
      }

      public OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder outboundManufacturedSerialNumber(final String outboundManufacturedSerialNumber) {
         this.outboundManufacturedSerialNumber = outboundManufacturedSerialNumber;
         return this;
      }

      public OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder applicationTime(final LocalDateTime applicationTime) {
         this.applicationTime = applicationTime;
         return this;
      }

      public OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder reviewPassTime(final LocalDateTime reviewPassTime) {
         this.reviewPassTime = reviewPassTime;
         return this;
      }

      public OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder manufacturedName(final String manufacturedName) {
         this.manufacturedName = manufacturedName;
         return this;
      }

      public OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder manufacturedSn(final String manufacturedSn) {
         this.manufacturedSn = manufacturedSn;
         return this;
      }

      public OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      public OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      public OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      public OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder manufacturedUnit(final String manufacturedUnit) {
         this.manufacturedUnit = manufacturedUnit;
         return this;
      }

      public OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      public OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder unitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
         this.unitPriceExcludingVat = unitPriceExcludingVat;
         return this;
      }

      public OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder inputVat(final BigDecimal inputVat) {
         this.inputVat = inputVat;
         return this;
      }

      public OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder project(final IdAndNameDTO project) {
         this.project = project;
         return this;
      }

      public OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder monomer(final IdAndNameDTO monomer) {
         this.monomer = monomer;
         return this;
      }

      public OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder area(final IdAndNameDTO area) {
         this.area = area;
         return this;
      }

      public OutboundDetailManufacturedDTO build() {
         return new OutboundDetailManufacturedDTO(
            this.id,
            this.outboundManufacturedId,
            this.outboundManufacturedSerialNumber,
            this.applicantName,
            this.applicationTime,
            this.reviewPassTime,
            this.basicClass,
            this.manufacturedName,
            this.manufacturedSn,
            this.material,
            this.specification,
            this.length,
            this.width,
            this.thickness,
            this.brand,
            this.color,
            this.weight,
            this.totalWeight,
            this.totalLength,
            this.surfaceArea,
            this.totalArea,
            this.wageQuotaType,
            this.quantity,
            this.manufacturedUnit,
            this.amountExcludingVat,
            this.unitPriceExcludingVat,
            this.inputVat,
            this.unitPrice,
            this.amount,
            this.remark,
            this.project,
            this.monomer,
            this.area
         );
      }

      @Override
      public String toString() {
         return "OutboundDetailManufacturedDTO.OutboundDetailManufacturedDTOBuilder(id="
            + this.id
            + ", outboundManufacturedId="
            + this.outboundManufacturedId
            + ", outboundManufacturedSerialNumber="
            + this.outboundManufacturedSerialNumber
            + ", applicantName="
            + this.applicantName
            + ", applicationTime="
            + this.applicationTime
            + ", reviewPassTime="
            + this.reviewPassTime
            + ", basicClass="
            + this.basicClass
            + ", manufacturedName="
            + this.manufacturedName
            + ", manufacturedSn="
            + this.manufacturedSn
            + ", material="
            + this.material
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", brand="
            + this.brand
            + ", color="
            + this.color
            + ", weight="
            + this.weight
            + ", totalWeight="
            + this.totalWeight
            + ", totalLength="
            + this.totalLength
            + ", surfaceArea="
            + this.surfaceArea
            + ", totalArea="
            + this.totalArea
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", quantity="
            + this.quantity
            + ", manufacturedUnit="
            + this.manufacturedUnit
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", unitPriceExcludingVat="
            + this.unitPriceExcludingVat
            + ", inputVat="
            + this.inputVat
            + ", unitPrice="
            + this.unitPrice
            + ", amount="
            + this.amount
            + ", remark="
            + this.remark
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ")";
      }
   }
}
