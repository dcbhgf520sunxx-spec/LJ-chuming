package com.hzchum.scim.plan.core.api.pojo.dto.steel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InventoryDetailDTO {
   @ApiModelProperty("名称")
   private String name;
   @JsonInclude(Include.NON_NULL)
   private Long classifyId;
   @JsonInclude(Include.NON_NULL)
   private String classifyName;
   @ApiModelProperty("材质")
   private String material;
   @ApiModelProperty("厚度/规格")
   private String thickness;
   @ApiModelProperty("配置id")
   private String configId;
   @ApiModelProperty("重量")
   private BigDecimal mete;
   @ApiModelProperty("数量")
   private Integer quantity;
   @ApiModelProperty("工厂id")
   private Long factoryId;
   @ApiModelProperty("工厂名")
   private String factoryName;
   @ApiModelProperty("仓库id")
   private Long warehouseId;
   @ApiModelProperty("仓库名")
   private String warehouseName;
   @ApiModelProperty("时间")
   private LocalDateTime time;
   @JsonInclude(Include.NON_NULL)
   private Integer basicClass;
   @JsonInclude(Include.NON_NULL)
   private String serialNumber;
   @JsonInclude(Include.NON_NULL)
   private ProjectInfo project;
   @JsonInclude(Include.NON_NULL)
   private String monomerName;
   @JsonInclude(Include.NON_NULL)
   private Long monomerId;
   @JsonInclude(Include.NON_NULL)
   private String areaName;
   @JsonInclude(Include.NON_NULL)
   private Long areaId;
   @JsonInclude(Include.NON_NULL)
   private String specification;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal length;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal width;
   @JsonInclude(Include.NON_NULL)
   private String nationalStandard;
   @JsonInclude(Include.NON_NULL)
   private Boolean boolPartyA;
   @JsonInclude(Include.NON_NULL)
   private String brand;
   @JsonInclude(Include.NON_NULL)
   private String remark;
   @JsonInclude(Include.NON_NULL)
   private String heatNoAndBatchNo;
   @JsonInclude(Include.NON_NULL)
   private String barcode;
   @JsonInclude(Include.NON_NULL)
   private String color;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal unitNet;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal frozenMete;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal frozenQuantity;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal unitPrice;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal unitPriceExcludingVAT;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal amount;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal amountExcludingVAT;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal inputVAT;

   public static InventoryDetailDTO.InventoryDetailDTOBuilder builder() {
      return new InventoryDetailDTO.InventoryDetailDTOBuilder();
   }

   public String getName() {
      return this.name;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getThickness() {
      return this.thickness;
   }

   public String getConfigId() {
      return this.configId;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public String getFactoryName() {
      return this.factoryName;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public String getWarehouseName() {
      return this.warehouseName;
   }

   public LocalDateTime getTime() {
      return this.time;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public Long getAreaId() {
      return this.areaId;
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

   public String getNationalStandard() {
      return this.nationalStandard;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getBarcode() {
      return this.barcode;
   }

   public String getColor() {
      return this.color;
   }

   public BigDecimal getUnitNet() {
      return this.unitNet;
   }

   public BigDecimal getFrozenMete() {
      return this.frozenMete;
   }

   public BigDecimal getFrozenQuantity() {
      return this.frozenQuantity;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getUnitPriceExcludingVAT() {
      return this.unitPriceExcludingVAT;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountExcludingVAT() {
      return this.amountExcludingVAT;
   }

   public BigDecimal getInputVAT() {
      return this.inputVAT;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setThickness(final String thickness) {
      this.thickness = thickness;
   }

   public void setConfigId(final String configId) {
      this.configId = configId;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
   }

   public void setFactoryName(final String factoryName) {
      this.factoryName = factoryName;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setWarehouseName(final String warehouseName) {
      this.warehouseName = warehouseName;
   }

   public void setTime(final LocalDateTime time) {
      this.time = time;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
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

   public void setNationalStandard(final String nationalStandard) {
      this.nationalStandard = nationalStandard;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setBarcode(final String barcode) {
      this.barcode = barcode;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
   }

   public void setFrozenMete(final BigDecimal frozenMete) {
      this.frozenMete = frozenMete;
   }

   public void setFrozenQuantity(final BigDecimal frozenQuantity) {
      this.frozenQuantity = frozenQuantity;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setUnitPriceExcludingVAT(final BigDecimal unitPriceExcludingVAT) {
      this.unitPriceExcludingVAT = unitPriceExcludingVAT;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setAmountExcludingVAT(final BigDecimal amountExcludingVAT) {
      this.amountExcludingVAT = amountExcludingVAT;
   }

   public void setInputVAT(final BigDecimal inputVAT) {
      this.inputVAT = inputVAT;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InventoryDetailDTO)) {
         return false;
      }

      InventoryDetailDTO other = (InventoryDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$classifyId = this.getClassifyId();
      Object other$classifyId = other.getClassifyId();
      if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$factoryId = this.getFactoryId();
            Object other$factoryId = other.getFactoryId();
            if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
               Object this$warehouseId = this.getWarehouseId();
               Object other$warehouseId = other.getWarehouseId();
               if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                  Object this$basicClass = this.getBasicClass();
                  Object other$basicClass = other.getBasicClass();
                  if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                     Object this$monomerId = this.getMonomerId();
                     Object other$monomerId = other.getMonomerId();
                     if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                        Object this$areaId = this.getAreaId();
                        Object other$areaId = other.getAreaId();
                        if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                           Object this$boolPartyA = this.getBoolPartyA();
                           Object other$boolPartyA = other.getBoolPartyA();
                           if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                              Object this$name = this.getName();
                              Object other$name = other.getName();
                              if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                 Object this$classifyName = this.getClassifyName();
                                 Object other$classifyName = other.getClassifyName();
                                 if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                                    Object this$material = this.getMaterial();
                                    Object other$material = other.getMaterial();
                                    if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                       Object this$thickness = this.getThickness();
                                       Object other$thickness = other.getThickness();
                                       if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                          Object this$configId = this.getConfigId();
                                          Object other$configId = other.getConfigId();
                                          if (this$configId == null ? other$configId == null : this$configId.equals(other$configId)) {
                                             Object this$mete = this.getMete();
                                             Object other$mete = other.getMete();
                                             if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                Object this$factoryName = this.getFactoryName();
                                                Object other$factoryName = other.getFactoryName();
                                                if (this$factoryName == null ? other$factoryName == null : this$factoryName.equals(other$factoryName)) {
                                                   Object this$warehouseName = this.getWarehouseName();
                                                   Object other$warehouseName = other.getWarehouseName();
                                                   if (this$warehouseName == null
                                                      ? other$warehouseName == null
                                                      : this$warehouseName.equals(other$warehouseName)) {
                                                      Object this$time = this.getTime();
                                                      Object other$time = other.getTime();
                                                      if (this$time == null ? other$time == null : this$time.equals(other$time)) {
                                                         Object this$serialNumber = this.getSerialNumber();
                                                         Object other$serialNumber = other.getSerialNumber();
                                                         if (this$serialNumber == null
                                                            ? other$serialNumber == null
                                                            : this$serialNumber.equals(other$serialNumber)) {
                                                            Object this$project = this.getProject();
                                                            Object other$project = other.getProject();
                                                            if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                                               Object this$monomerName = this.getMonomerName();
                                                               Object other$monomerName = other.getMonomerName();
                                                               if (this$monomerName == null
                                                                  ? other$monomerName == null
                                                                  : this$monomerName.equals(other$monomerName)) {
                                                                  Object this$areaName = this.getAreaName();
                                                                  Object other$areaName = other.getAreaName();
                                                                  if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
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
                                                                              Object this$nationalStandard = this.getNationalStandard();
                                                                              Object other$nationalStandard = other.getNationalStandard();
                                                                              if (this$nationalStandard == null
                                                                                 ? other$nationalStandard == null
                                                                                 : this$nationalStandard.equals(other$nationalStandard)) {
                                                                                 Object this$brand = this.getBrand();
                                                                                 Object other$brand = other.getBrand();
                                                                                 if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                                                    Object this$remark = this.getRemark();
                                                                                    Object other$remark = other.getRemark();
                                                                                    if (this$remark == null
                                                                                       ? other$remark == null
                                                                                       : this$remark.equals(other$remark)) {
                                                                                       Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                                                       Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                                                       if (this$heatNoAndBatchNo == null
                                                                                          ? other$heatNoAndBatchNo == null
                                                                                          : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                                                          Object this$barcode = this.getBarcode();
                                                                                          Object other$barcode = other.getBarcode();
                                                                                          if (this$barcode == null
                                                                                             ? other$barcode == null
                                                                                             : this$barcode.equals(other$barcode)) {
                                                                                             Object this$color = this.getColor();
                                                                                             Object other$color = other.getColor();
                                                                                             if (this$color == null
                                                                                                ? other$color == null
                                                                                                : this$color.equals(other$color)) {
                                                                                                Object this$unitNet = this.getUnitNet();
                                                                                                Object other$unitNet = other.getUnitNet();
                                                                                                if (this$unitNet == null
                                                                                                   ? other$unitNet == null
                                                                                                   : this$unitNet.equals(other$unitNet)) {
                                                                                                   Object this$frozenMete = this.getFrozenMete();
                                                                                                   Object other$frozenMete = other.getFrozenMete();
                                                                                                   if (this$frozenMete == null
                                                                                                      ? other$frozenMete == null
                                                                                                      : this$frozenMete.equals(other$frozenMete)) {
                                                                                                      Object this$frozenQuantity = this.getFrozenQuantity();
                                                                                                      Object other$frozenQuantity = other.getFrozenQuantity();
                                                                                                      if (this$frozenQuantity == null
                                                                                                         ? other$frozenQuantity == null
                                                                                                         : this$frozenQuantity.equals(other$frozenQuantity)) {
                                                                                                         Object this$unitPrice = this.getUnitPrice();
                                                                                                         Object other$unitPrice = other.getUnitPrice();
                                                                                                         if (this$unitPrice == null
                                                                                                            ? other$unitPrice == null
                                                                                                            : this$unitPrice.equals(other$unitPrice)) {
                                                                                                            Object this$unitPriceExcludingVAT = this.getUnitPriceExcludingVAT();
                                                                                                            Object other$unitPriceExcludingVAT = other.getUnitPriceExcludingVAT();
                                                                                                            if (this$unitPriceExcludingVAT == null
                                                                                                               ? other$unitPriceExcludingVAT == null
                                                                                                               : this$unitPriceExcludingVAT.equals(
                                                                                                                  other$unitPriceExcludingVAT
                                                                                                               )) {
                                                                                                               Object this$amount = this.getAmount();
                                                                                                               Object other$amount = other.getAmount();
                                                                                                               if (this$amount == null
                                                                                                                  ? other$amount == null
                                                                                                                  : this$amount.equals(other$amount)) {
                                                                                                                  Object this$amountExcludingVAT = this.getAmountExcludingVAT();
                                                                                                                  Object other$amountExcludingVAT = other.getAmountExcludingVAT();
                                                                                                                  if (this$amountExcludingVAT == null
                                                                                                                     ? other$amountExcludingVAT == null
                                                                                                                     : this$amountExcludingVAT.equals(
                                                                                                                        other$amountExcludingVAT
                                                                                                                     )) {
                                                                                                                     Object this$inputVAT = this.getInputVAT();
                                                                                                                     Object other$inputVAT = other.getInputVAT();
                                                                                                                     return this$inputVAT == null
                                                                                                                        ? other$inputVAT == null
                                                                                                                        : this$inputVAT.equals(other$inputVAT);
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
      return other instanceof InventoryDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $configId = this.getConfigId();
      result = result * 59 + ($configId == null ? 43 : $configId.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $factoryName = this.getFactoryName();
      result = result * 59 + ($factoryName == null ? 43 : $factoryName.hashCode());
      Object $warehouseName = this.getWarehouseName();
      result = result * 59 + ($warehouseName == null ? 43 : $warehouseName.hashCode());
      Object $time = this.getTime();
      result = result * 59 + ($time == null ? 43 : $time.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $nationalStandard = this.getNationalStandard();
      result = result * 59 + ($nationalStandard == null ? 43 : $nationalStandard.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $barcode = this.getBarcode();
      result = result * 59 + ($barcode == null ? 43 : $barcode.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $unitNet = this.getUnitNet();
      result = result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
      Object $frozenMete = this.getFrozenMete();
      result = result * 59 + ($frozenMete == null ? 43 : $frozenMete.hashCode());
      Object $frozenQuantity = this.getFrozenQuantity();
      result = result * 59 + ($frozenQuantity == null ? 43 : $frozenQuantity.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $unitPriceExcludingVAT = this.getUnitPriceExcludingVAT();
      result = result * 59 + ($unitPriceExcludingVAT == null ? 43 : $unitPriceExcludingVAT.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVAT = this.getAmountExcludingVAT();
      result = result * 59 + ($amountExcludingVAT == null ? 43 : $amountExcludingVAT.hashCode());
      Object $inputVAT = this.getInputVAT();
      return result * 59 + ($inputVAT == null ? 43 : $inputVAT.hashCode());
   }

   @Override
   public String toString() {
      return "InventoryDetailDTO(name="
         + this.getName()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", material="
         + this.getMaterial()
         + ", thickness="
         + this.getThickness()
         + ", configId="
         + this.getConfigId()
         + ", mete="
         + this.getMete()
         + ", quantity="
         + this.getQuantity()
         + ", factoryId="
         + this.getFactoryId()
         + ", factoryName="
         + this.getFactoryName()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", warehouseName="
         + this.getWarehouseName()
         + ", time="
         + this.getTime()
         + ", basicClass="
         + this.getBasicClass()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", project="
         + this.getProject()
         + ", monomerName="
         + this.getMonomerName()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaName="
         + this.getAreaName()
         + ", areaId="
         + this.getAreaId()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", nationalStandard="
         + this.getNationalStandard()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", brand="
         + this.getBrand()
         + ", remark="
         + this.getRemark()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", barcode="
         + this.getBarcode()
         + ", color="
         + this.getColor()
         + ", unitNet="
         + this.getUnitNet()
         + ", frozenMete="
         + this.getFrozenMete()
         + ", frozenQuantity="
         + this.getFrozenQuantity()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", unitPriceExcludingVAT="
         + this.getUnitPriceExcludingVAT()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVAT="
         + this.getAmountExcludingVAT()
         + ", inputVAT="
         + this.getInputVAT()
         + ")";
   }

   public InventoryDetailDTO(
      final String name,
      final Long classifyId,
      final String classifyName,
      final String material,
      final String thickness,
      final String configId,
      final BigDecimal mete,
      final Integer quantity,
      final Long factoryId,
      final String factoryName,
      final Long warehouseId,
      final String warehouseName,
      final LocalDateTime time,
      final Integer basicClass,
      final String serialNumber,
      final ProjectInfo project,
      final String monomerName,
      final Long monomerId,
      final String areaName,
      final Long areaId,
      final String specification,
      final BigDecimal length,
      final BigDecimal width,
      final String nationalStandard,
      final Boolean boolPartyA,
      final String brand,
      final String remark,
      final String heatNoAndBatchNo,
      final String barcode,
      final String color,
      final BigDecimal unitNet,
      final BigDecimal frozenMete,
      final BigDecimal frozenQuantity,
      final BigDecimal unitPrice,
      final BigDecimal unitPriceExcludingVAT,
      final BigDecimal amount,
      final BigDecimal amountExcludingVAT,
      final BigDecimal inputVAT
   ) {
      this.name = name;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.material = material;
      this.thickness = thickness;
      this.configId = configId;
      this.mete = mete;
      this.quantity = quantity;
      this.factoryId = factoryId;
      this.factoryName = factoryName;
      this.warehouseId = warehouseId;
      this.warehouseName = warehouseName;
      this.time = time;
      this.basicClass = basicClass;
      this.serialNumber = serialNumber;
      this.project = project;
      this.monomerName = monomerName;
      this.monomerId = monomerId;
      this.areaName = areaName;
      this.areaId = areaId;
      this.specification = specification;
      this.length = length;
      this.width = width;
      this.nationalStandard = nationalStandard;
      this.boolPartyA = boolPartyA;
      this.brand = brand;
      this.remark = remark;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.barcode = barcode;
      this.color = color;
      this.unitNet = unitNet;
      this.frozenMete = frozenMete;
      this.frozenQuantity = frozenQuantity;
      this.unitPrice = unitPrice;
      this.unitPriceExcludingVAT = unitPriceExcludingVAT;
      this.amount = amount;
      this.amountExcludingVAT = amountExcludingVAT;
      this.inputVAT = inputVAT;
   }

   public InventoryDetailDTO() {
   }

   public static class InventoryDetailDTOBuilder {
      private String name;
      private Long classifyId;
      private String classifyName;
      private String material;
      private String thickness;
      private String configId;
      private BigDecimal mete;
      private Integer quantity;
      private Long factoryId;
      private String factoryName;
      private Long warehouseId;
      private String warehouseName;
      private LocalDateTime time;
      private Integer basicClass;
      private String serialNumber;
      private ProjectInfo project;
      private String monomerName;
      private Long monomerId;
      private String areaName;
      private Long areaId;
      private String specification;
      private BigDecimal length;
      private BigDecimal width;
      private String nationalStandard;
      private Boolean boolPartyA;
      private String brand;
      private String remark;
      private String heatNoAndBatchNo;
      private String barcode;
      private String color;
      private BigDecimal unitNet;
      private BigDecimal frozenMete;
      private BigDecimal frozenQuantity;
      private BigDecimal unitPrice;
      private BigDecimal unitPriceExcludingVAT;
      private BigDecimal amount;
      private BigDecimal amountExcludingVAT;
      private BigDecimal inputVAT;

      InventoryDetailDTOBuilder() {
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder thickness(final String thickness) {
         this.thickness = thickness;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder configId(final String configId) {
         this.configId = configId;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder factoryName(final String factoryName) {
         this.factoryName = factoryName;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder warehouseName(final String warehouseName) {
         this.warehouseName = warehouseName;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder time(final LocalDateTime time) {
         this.time = time;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder nationalStandard(final String nationalStandard) {
         this.nationalStandard = nationalStandard;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder barcode(final String barcode) {
         this.barcode = barcode;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder frozenMete(final BigDecimal frozenMete) {
         this.frozenMete = frozenMete;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder frozenQuantity(final BigDecimal frozenQuantity) {
         this.frozenQuantity = frozenQuantity;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder unitPriceExcludingVAT(final BigDecimal unitPriceExcludingVAT) {
         this.unitPriceExcludingVAT = unitPriceExcludingVAT;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder amountExcludingVAT(final BigDecimal amountExcludingVAT) {
         this.amountExcludingVAT = amountExcludingVAT;
         return this;
      }

      public InventoryDetailDTO.InventoryDetailDTOBuilder inputVAT(final BigDecimal inputVAT) {
         this.inputVAT = inputVAT;
         return this;
      }

      public InventoryDetailDTO build() {
         return new InventoryDetailDTO(
            this.name,
            this.classifyId,
            this.classifyName,
            this.material,
            this.thickness,
            this.configId,
            this.mete,
            this.quantity,
            this.factoryId,
            this.factoryName,
            this.warehouseId,
            this.warehouseName,
            this.time,
            this.basicClass,
            this.serialNumber,
            this.project,
            this.monomerName,
            this.monomerId,
            this.areaName,
            this.areaId,
            this.specification,
            this.length,
            this.width,
            this.nationalStandard,
            this.boolPartyA,
            this.brand,
            this.remark,
            this.heatNoAndBatchNo,
            this.barcode,
            this.color,
            this.unitNet,
            this.frozenMete,
            this.frozenQuantity,
            this.unitPrice,
            this.unitPriceExcludingVAT,
            this.amount,
            this.amountExcludingVAT,
            this.inputVAT
         );
      }

      @Override
      public String toString() {
         return "InventoryDetailDTO.InventoryDetailDTOBuilder(name="
            + this.name
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", material="
            + this.material
            + ", thickness="
            + this.thickness
            + ", configId="
            + this.configId
            + ", mete="
            + this.mete
            + ", quantity="
            + this.quantity
            + ", factoryId="
            + this.factoryId
            + ", factoryName="
            + this.factoryName
            + ", warehouseId="
            + this.warehouseId
            + ", warehouseName="
            + this.warehouseName
            + ", time="
            + this.time
            + ", basicClass="
            + this.basicClass
            + ", serialNumber="
            + this.serialNumber
            + ", project="
            + this.project
            + ", monomerName="
            + this.monomerName
            + ", monomerId="
            + this.monomerId
            + ", areaName="
            + this.areaName
            + ", areaId="
            + this.areaId
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", nationalStandard="
            + this.nationalStandard
            + ", boolPartyA="
            + this.boolPartyA
            + ", brand="
            + this.brand
            + ", remark="
            + this.remark
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", barcode="
            + this.barcode
            + ", color="
            + this.color
            + ", unitNet="
            + this.unitNet
            + ", frozenMete="
            + this.frozenMete
            + ", frozenQuantity="
            + this.frozenQuantity
            + ", unitPrice="
            + this.unitPrice
            + ", unitPriceExcludingVAT="
            + this.unitPriceExcludingVAT
            + ", amount="
            + this.amount
            + ", amountExcludingVAT="
            + this.amountExcludingVAT
            + ", inputVAT="
            + this.inputVAT
            + ")";
      }
   }
}
