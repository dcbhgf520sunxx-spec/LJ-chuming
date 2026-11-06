package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InboundDetailManufacturedDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("主键ID")
   private Long id;
   @ApiModelProperty("制成品入库单ID")
   private Long inboundManufacturedId;
   @ApiModelProperty("制成品入库单编号")
   private String inboundManufacturedSerialNumber;
   @ApiModelProperty("申请人ID")
   private Long applicantId;
   @ApiModelProperty("申请人名称")
   private String applicantName;
   @ApiModelProperty("审核通过时间")
   private LocalDateTime reviewPassTime;
   @ApiModelProperty("采购订单ID")
   private Long purchaseId;
   @ApiModelProperty("采购订单编号")
   private String purchaseSn;
   @ApiModelProperty("采购详情ID")
   private Long purchaseOrderDetailId;
   @ApiModelProperty("申购订单ID")
   private Long applyPurchaseId;
   @ApiModelProperty("物料基础类型")
   private Integer basicClass;
   @ApiModelProperty("构件/围护ID")
   private Long artifactEnclosureId;
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
   @ApiModelProperty("入库总价 含税")
   private BigDecimal amount;
   @ApiModelProperty("税率(百分比)")
   private BigDecimal taxRate;
   @ApiModelProperty("备注")
   private String remark;
   @ApiModelProperty("项目信息")
   private IdAndNameDTO project;
   @ApiModelProperty("单体")
   private IdAndNameDTO monomer;
   @ApiModelProperty("区域")
   private IdAndNameDTO area;
   @ApiModelProperty("仓库")
   private IdAndNameDTO workshop;
   @ApiModelProperty("仓库位置")
   private IdAndNameDTO warehouse;

   public static InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder builder() {
      return new InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getInboundManufacturedId() {
      return this.inboundManufacturedId;
   }

   public String getInboundManufacturedSerialNumber() {
      return this.inboundManufacturedSerialNumber;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public LocalDateTime getReviewPassTime() {
      return this.reviewPassTime;
   }

   public Long getPurchaseId() {
      return this.purchaseId;
   }

   public String getPurchaseSn() {
      return this.purchaseSn;
   }

   public Long getPurchaseOrderDetailId() {
      return this.purchaseOrderDetailId;
   }

   public Long getApplyPurchaseId() {
      return this.applyPurchaseId;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getArtifactEnclosureId() {
      return this.artifactEnclosureId;
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

   public BigDecimal getTaxRate() {
      return this.taxRate;
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

   public IdAndNameDTO getWorkshop() {
      return this.workshop;
   }

   public IdAndNameDTO getWarehouse() {
      return this.warehouse;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setInboundManufacturedId(final Long inboundManufacturedId) {
      this.inboundManufacturedId = inboundManufacturedId;
   }

   public void setInboundManufacturedSerialNumber(final String inboundManufacturedSerialNumber) {
      this.inboundManufacturedSerialNumber = inboundManufacturedSerialNumber;
   }

   public void setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setReviewPassTime(final LocalDateTime reviewPassTime) {
      this.reviewPassTime = reviewPassTime;
   }

   public void setPurchaseId(final Long purchaseId) {
      this.purchaseId = purchaseId;
   }

   public void setPurchaseSn(final String purchaseSn) {
      this.purchaseSn = purchaseSn;
   }

   public void setPurchaseOrderDetailId(final Long purchaseOrderDetailId) {
      this.purchaseOrderDetailId = purchaseOrderDetailId;
   }

   public void setApplyPurchaseId(final Long applyPurchaseId) {
      this.applyPurchaseId = applyPurchaseId;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setArtifactEnclosureId(final Long artifactEnclosureId) {
      this.artifactEnclosureId = artifactEnclosureId;
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

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
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

   public void setWorkshop(final IdAndNameDTO workshop) {
      this.workshop = workshop;
   }

   public void setWarehouse(final IdAndNameDTO warehouse) {
      this.warehouse = warehouse;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InboundDetailManufacturedDTO)) {
         return false;
      }

      InboundDetailManufacturedDTO other = (InboundDetailManufacturedDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$inboundManufacturedId = this.getInboundManufacturedId();
         Object other$inboundManufacturedId = other.getInboundManufacturedId();
         if (this$inboundManufacturedId == null ? other$inboundManufacturedId == null : this$inboundManufacturedId.equals(other$inboundManufacturedId)) {
            Object this$applicantId = this.getApplicantId();
            Object other$applicantId = other.getApplicantId();
            if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
               Object this$purchaseId = this.getPurchaseId();
               Object other$purchaseId = other.getPurchaseId();
               if (this$purchaseId == null ? other$purchaseId == null : this$purchaseId.equals(other$purchaseId)) {
                  Object this$purchaseOrderDetailId = this.getPurchaseOrderDetailId();
                  Object other$purchaseOrderDetailId = other.getPurchaseOrderDetailId();
                  if (this$purchaseOrderDetailId == null ? other$purchaseOrderDetailId == null : this$purchaseOrderDetailId.equals(other$purchaseOrderDetailId)
                     )
                   {
                     Object this$applyPurchaseId = this.getApplyPurchaseId();
                     Object other$applyPurchaseId = other.getApplyPurchaseId();
                     if (this$applyPurchaseId == null ? other$applyPurchaseId == null : this$applyPurchaseId.equals(other$applyPurchaseId)) {
                        Object this$basicClass = this.getBasicClass();
                        Object other$basicClass = other.getBasicClass();
                        if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                           Object this$artifactEnclosureId = this.getArtifactEnclosureId();
                           Object other$artifactEnclosureId = other.getArtifactEnclosureId();
                           if (this$artifactEnclosureId == null
                              ? other$artifactEnclosureId == null
                              : this$artifactEnclosureId.equals(other$artifactEnclosureId)) {
                              Object this$wageQuotaType = this.getWageQuotaType();
                              Object other$wageQuotaType = other.getWageQuotaType();
                              if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
                                 Object this$inboundManufacturedSerialNumber = this.getInboundManufacturedSerialNumber();
                                 Object other$inboundManufacturedSerialNumber = other.getInboundManufacturedSerialNumber();
                                 if (this$inboundManufacturedSerialNumber == null
                                    ? other$inboundManufacturedSerialNumber == null
                                    : this$inboundManufacturedSerialNumber.equals(other$inboundManufacturedSerialNumber)) {
                                    Object this$applicantName = this.getApplicantName();
                                    Object other$applicantName = other.getApplicantName();
                                    if (this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName)) {
                                       Object this$reviewPassTime = this.getReviewPassTime();
                                       Object other$reviewPassTime = other.getReviewPassTime();
                                       if (this$reviewPassTime == null ? other$reviewPassTime == null : this$reviewPassTime.equals(other$reviewPassTime)) {
                                          Object this$purchaseSn = this.getPurchaseSn();
                                          Object other$purchaseSn = other.getPurchaseSn();
                                          if (this$purchaseSn == null ? other$purchaseSn == null : this$purchaseSn.equals(other$purchaseSn)) {
                                             Object this$manufacturedName = this.getManufacturedName();
                                             Object other$manufacturedName = other.getManufacturedName();
                                             if (this$manufacturedName == null
                                                ? other$manufacturedName == null
                                                : this$manufacturedName.equals(other$manufacturedName)) {
                                                Object this$manufacturedSn = this.getManufacturedSn();
                                                Object other$manufacturedSn = other.getManufacturedSn();
                                                if (this$manufacturedSn == null
                                                   ? other$manufacturedSn == null
                                                   : this$manufacturedSn.equals(other$manufacturedSn)) {
                                                   Object this$material = this.getMaterial();
                                                   Object other$material = other.getMaterial();
                                                   if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                      Object this$specification = this.getSpecification();
                                                      Object other$specification = other.getSpecification();
                                                      if (this$specification == null
                                                         ? other$specification == null
                                                         : this$specification.equals(other$specification)) {
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
                                                                                                   : this$unitPriceExcludingVat.equals(
                                                                                                      other$unitPriceExcludingVat
                                                                                                   )) {
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
                                                                                                            Object this$taxRate = this.getTaxRate();
                                                                                                            Object other$taxRate = other.getTaxRate();
                                                                                                            if (this$taxRate == null
                                                                                                               ? other$taxRate == null
                                                                                                               : this$taxRate.equals(other$taxRate)) {
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
                                                                                                                        if (this$area == null
                                                                                                                           ? other$area == null
                                                                                                                           : this$area.equals(other$area)) {
                                                                                                                           Object this$workshop = this.getWorkshop();
                                                                                                                           Object other$workshop = other.getWorkshop();
                                                                                                                           if (this$workshop == null
                                                                                                                              ? other$workshop == null
                                                                                                                              : this$workshop.equals(
                                                                                                                                 other$workshop
                                                                                                                              )) {
                                                                                                                              Object this$warehouse = this.getWarehouse();
                                                                                                                              Object other$warehouse = other.getWarehouse();
                                                                                                                              return this$warehouse == null
                                                                                                                                 ? other$warehouse == null
                                                                                                                                 : this$warehouse.equals(
                                                                                                                                    other$warehouse
                                                                                                                                 );
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
      return other instanceof InboundDetailManufacturedDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $inboundManufacturedId = this.getInboundManufacturedId();
      result = result * 59 + ($inboundManufacturedId == null ? 43 : $inboundManufacturedId.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $purchaseId = this.getPurchaseId();
      result = result * 59 + ($purchaseId == null ? 43 : $purchaseId.hashCode());
      Object $purchaseOrderDetailId = this.getPurchaseOrderDetailId();
      result = result * 59 + ($purchaseOrderDetailId == null ? 43 : $purchaseOrderDetailId.hashCode());
      Object $applyPurchaseId = this.getApplyPurchaseId();
      result = result * 59 + ($applyPurchaseId == null ? 43 : $applyPurchaseId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $artifactEnclosureId = this.getArtifactEnclosureId();
      result = result * 59 + ($artifactEnclosureId == null ? 43 : $artifactEnclosureId.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $inboundManufacturedSerialNumber = this.getInboundManufacturedSerialNumber();
      result = result * 59 + ($inboundManufacturedSerialNumber == null ? 43 : $inboundManufacturedSerialNumber.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $reviewPassTime = this.getReviewPassTime();
      result = result * 59 + ($reviewPassTime == null ? 43 : $reviewPassTime.hashCode());
      Object $purchaseSn = this.getPurchaseSn();
      result = result * 59 + ($purchaseSn == null ? 43 : $purchaseSn.hashCode());
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
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $warehouse = this.getWarehouse();
      return result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
   }

   @Override
   public String toString() {
      return "InboundDetailManufacturedDTO(id="
         + this.getId()
         + ", inboundManufacturedId="
         + this.getInboundManufacturedId()
         + ", inboundManufacturedSerialNumber="
         + this.getInboundManufacturedSerialNumber()
         + ", applicantId="
         + this.getApplicantId()
         + ", applicantName="
         + this.getApplicantName()
         + ", reviewPassTime="
         + this.getReviewPassTime()
         + ", purchaseId="
         + this.getPurchaseId()
         + ", purchaseSn="
         + this.getPurchaseSn()
         + ", purchaseOrderDetailId="
         + this.getPurchaseOrderDetailId()
         + ", applyPurchaseId="
         + this.getApplyPurchaseId()
         + ", basicClass="
         + this.getBasicClass()
         + ", artifactEnclosureId="
         + this.getArtifactEnclosureId()
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
         + ", taxRate="
         + this.getTaxRate()
         + ", remark="
         + this.getRemark()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", workshop="
         + this.getWorkshop()
         + ", warehouse="
         + this.getWarehouse()
         + ")";
   }

   public InboundDetailManufacturedDTO(
      final Long id,
      final Long inboundManufacturedId,
      final String inboundManufacturedSerialNumber,
      final Long applicantId,
      final String applicantName,
      final LocalDateTime reviewPassTime,
      final Long purchaseId,
      final String purchaseSn,
      final Long purchaseOrderDetailId,
      final Long applyPurchaseId,
      final Integer basicClass,
      final Long artifactEnclosureId,
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
      final BigDecimal taxRate,
      final String remark,
      final IdAndNameDTO project,
      final IdAndNameDTO monomer,
      final IdAndNameDTO area,
      final IdAndNameDTO workshop,
      final IdAndNameDTO warehouse
   ) {
      this.id = id;
      this.inboundManufacturedId = inboundManufacturedId;
      this.inboundManufacturedSerialNumber = inboundManufacturedSerialNumber;
      this.applicantId = applicantId;
      this.applicantName = applicantName;
      this.reviewPassTime = reviewPassTime;
      this.purchaseId = purchaseId;
      this.purchaseSn = purchaseSn;
      this.purchaseOrderDetailId = purchaseOrderDetailId;
      this.applyPurchaseId = applyPurchaseId;
      this.basicClass = basicClass;
      this.artifactEnclosureId = artifactEnclosureId;
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
      this.taxRate = taxRate;
      this.remark = remark;
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.workshop = workshop;
      this.warehouse = warehouse;
   }

   public InboundDetailManufacturedDTO() {
   }

   public static class InboundDetailManufacturedDTOBuilder {
      private Long id;
      private Long inboundManufacturedId;
      private String inboundManufacturedSerialNumber;
      private Long applicantId;
      private String applicantName;
      private LocalDateTime reviewPassTime;
      private Long purchaseId;
      private String purchaseSn;
      private Long purchaseOrderDetailId;
      private Long applyPurchaseId;
      private Integer basicClass;
      private Long artifactEnclosureId;
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
      private BigDecimal taxRate;
      private String remark;
      private IdAndNameDTO project;
      private IdAndNameDTO monomer;
      private IdAndNameDTO area;
      private IdAndNameDTO workshop;
      private IdAndNameDTO warehouse;

      InboundDetailManufacturedDTOBuilder() {
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder inboundManufacturedId(final Long inboundManufacturedId) {
         this.inboundManufacturedId = inboundManufacturedId;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder inboundManufacturedSerialNumber(final String inboundManufacturedSerialNumber) {
         this.inboundManufacturedSerialNumber = inboundManufacturedSerialNumber;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder reviewPassTime(final LocalDateTime reviewPassTime) {
         this.reviewPassTime = reviewPassTime;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder purchaseId(final Long purchaseId) {
         this.purchaseId = purchaseId;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder purchaseSn(final String purchaseSn) {
         this.purchaseSn = purchaseSn;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder purchaseOrderDetailId(final Long purchaseOrderDetailId) {
         this.purchaseOrderDetailId = purchaseOrderDetailId;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder applyPurchaseId(final Long applyPurchaseId) {
         this.applyPurchaseId = applyPurchaseId;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder artifactEnclosureId(final Long artifactEnclosureId) {
         this.artifactEnclosureId = artifactEnclosureId;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder manufacturedName(final String manufacturedName) {
         this.manufacturedName = manufacturedName;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder manufacturedSn(final String manufacturedSn) {
         this.manufacturedSn = manufacturedSn;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder manufacturedUnit(final String manufacturedUnit) {
         this.manufacturedUnit = manufacturedUnit;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder unitPriceExcludingVat(final BigDecimal unitPriceExcludingVat) {
         this.unitPriceExcludingVat = unitPriceExcludingVat;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder inputVat(final BigDecimal inputVat) {
         this.inputVat = inputVat;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder project(final IdAndNameDTO project) {
         this.project = project;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder monomer(final IdAndNameDTO monomer) {
         this.monomer = monomer;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder area(final IdAndNameDTO area) {
         this.area = area;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder workshop(final IdAndNameDTO workshop) {
         this.workshop = workshop;
         return this;
      }

      public InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder warehouse(final IdAndNameDTO warehouse) {
         this.warehouse = warehouse;
         return this;
      }

      public InboundDetailManufacturedDTO build() {
         return new InboundDetailManufacturedDTO(
            this.id,
            this.inboundManufacturedId,
            this.inboundManufacturedSerialNumber,
            this.applicantId,
            this.applicantName,
            this.reviewPassTime,
            this.purchaseId,
            this.purchaseSn,
            this.purchaseOrderDetailId,
            this.applyPurchaseId,
            this.basicClass,
            this.artifactEnclosureId,
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
            this.taxRate,
            this.remark,
            this.project,
            this.monomer,
            this.area,
            this.workshop,
            this.warehouse
         );
      }

      @Override
      public String toString() {
         return "InboundDetailManufacturedDTO.InboundDetailManufacturedDTOBuilder(id="
            + this.id
            + ", inboundManufacturedId="
            + this.inboundManufacturedId
            + ", inboundManufacturedSerialNumber="
            + this.inboundManufacturedSerialNumber
            + ", applicantId="
            + this.applicantId
            + ", applicantName="
            + this.applicantName
            + ", reviewPassTime="
            + this.reviewPassTime
            + ", purchaseId="
            + this.purchaseId
            + ", purchaseSn="
            + this.purchaseSn
            + ", purchaseOrderDetailId="
            + this.purchaseOrderDetailId
            + ", applyPurchaseId="
            + this.applyPurchaseId
            + ", basicClass="
            + this.basicClass
            + ", artifactEnclosureId="
            + this.artifactEnclosureId
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
            + ", taxRate="
            + this.taxRate
            + ", remark="
            + this.remark
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", workshop="
            + this.workshop
            + ", warehouse="
            + this.warehouse
            + ")";
      }
   }
}
