package com.hzchum.scim.business.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BusinessReturnProductDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   private Long projectId;
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   private Long monomerId;
   @ApiModelProperty(name = "monomerName", value = "单体名称", notes = "单体名称")
   private String monomerName;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   private Long areaId;
   @ApiModelProperty(name = "areaName", value = "区域名称", notes = "区域名称")
   private String areaName;
   @ApiModelProperty(name = "planId", value = "计划id", notes = "计划id")
   private Long planId;
   @ApiModelProperty(name = "planName", value = "计划名称", notes = "计划名称")
   private String planName;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   private Integer productType;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   private Long productId;
   @ApiModelProperty(name = "handleMethod", value = "处理方式", notes = "处理方式")
   private Integer handleMethod;
   @ApiModelProperty(name = "productName", value = "名称", notes = "名称")
   private String productName;
   @ApiModelProperty(name = "serialNumber", value = "编号", notes = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   private String specification;
   @ApiModelProperty(name = "material", value = "材质", notes = "材质")
   private String material;
   @ApiModelProperty(name = "pricingManner", value = "计价方式 0重量 1长度 2面积", notes = "计价方式 0重量 1长度 2面积")
   private Integer pricingManner;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   private BigDecimal quantity;
   @ApiModelProperty(name = "netWeight", value = "单重量(t)", notes = "单重量(t)")
   private BigDecimal netWeight;
   @ApiModelProperty(name = "totalNetWeight", value = "总重量(t)", notes = "总重量(t)")
   private BigDecimal totalNetWeight;
   @ApiModelProperty(name = "length", value = "长度(m)", notes = "长度(m)")
   private BigDecimal length;
   @ApiModelProperty(name = "totalLength", value = "总长度（m）", notes = "总长度（m）")
   private BigDecimal totalLength;
   @ApiModelProperty(name = "surfaceArea", notes = "单面积(m²)")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "totalArea", value = "总面积（㎡）", notes = "总面积（㎡）")
   private BigDecimal totalArea;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   private BigDecimal mete;
   @ApiModelProperty(name = "unitPrice", value = "单价", notes = "单价")
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "totalAmount", value = "总金额", notes = "总金额")
   private BigDecimal totalAmount;
   @ApiModelProperty(name = "measureUnit", value = "计量单位", notes = "计量单位")
   private String measureUnit;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   private String accountingUnit;
   @ApiModelProperty(name = "auditTime", value = "审核时间", notes = "审核时间")
   private LocalDateTime auditTime;

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public Long getPlanId() {
      return this.planId;
   }

   public String getPlanName() {
      return this.planName;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getHandleMethod() {
      return this.handleMethod;
   }

   public String getProductName() {
      return this.productName;
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

   public Integer getPricingManner() {
      return this.pricingManner;
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

   public BigDecimal getLength() {
      return this.length;
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

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getTotalAmount() {
      return this.totalAmount;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   public void setPlanId(final Long planId) {
      this.planId = planId;
   }

   public void setPlanName(final String planName) {
      this.planName = planName;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setHandleMethod(final Integer handleMethod) {
      this.handleMethod = handleMethod;
   }

   public void setProductName(final String productName) {
      this.productName = productName;
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

   public void setPricingManner(final Integer pricingManner) {
      this.pricingManner = pricingManner;
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

   public void setLength(final BigDecimal length) {
      this.length = length;
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

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setTotalAmount(final BigDecimal totalAmount) {
      this.totalAmount = totalAmount;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessReturnProductDTO)) {
         return false;
      }

      BusinessReturnProductDTO other = (BusinessReturnProductDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$planId = this.getPlanId();
                  Object other$planId = other.getPlanId();
                  if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
                     Object this$productType = this.getProductType();
                     Object other$productType = other.getProductType();
                     if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                        Object this$productId = this.getProductId();
                        Object other$productId = other.getProductId();
                        if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                           Object this$handleMethod = this.getHandleMethod();
                           Object other$handleMethod = other.getHandleMethod();
                           if (this$handleMethod == null ? other$handleMethod == null : this$handleMethod.equals(other$handleMethod)) {
                              Object this$pricingManner = this.getPricingManner();
                              Object other$pricingManner = other.getPricingManner();
                              if (this$pricingManner == null ? other$pricingManner == null : this$pricingManner.equals(other$pricingManner)) {
                                 Object this$project = this.getProject();
                                 Object other$project = other.getProject();
                                 if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                    Object this$monomerName = this.getMonomerName();
                                    Object other$monomerName = other.getMonomerName();
                                    if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                                       Object this$areaName = this.getAreaName();
                                       Object other$areaName = other.getAreaName();
                                       if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                                          Object this$planName = this.getPlanName();
                                          Object other$planName = other.getPlanName();
                                          if (this$planName == null ? other$planName == null : this$planName.equals(other$planName)) {
                                             Object this$productName = this.getProductName();
                                             Object other$productName = other.getProductName();
                                             if (this$productName == null ? other$productName == null : this$productName.equals(other$productName)) {
                                                Object this$serialNumber = this.getSerialNumber();
                                                Object other$serialNumber = other.getSerialNumber();
                                                if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                   Object this$specification = this.getSpecification();
                                                   Object other$specification = other.getSpecification();
                                                   if (this$specification == null
                                                      ? other$specification == null
                                                      : this$specification.equals(other$specification)) {
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
                                                                  Object this$length = this.getLength();
                                                                  Object other$length = other.getLength();
                                                                  if (this$length == null ? other$length == null : this$length.equals(other$length)) {
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
                                                                              Object this$mete = this.getMete();
                                                                              Object other$mete = other.getMete();
                                                                              if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                                                 Object this$unitPrice = this.getUnitPrice();
                                                                                 Object other$unitPrice = other.getUnitPrice();
                                                                                 if (this$unitPrice == null
                                                                                    ? other$unitPrice == null
                                                                                    : this$unitPrice.equals(other$unitPrice)) {
                                                                                    Object this$totalAmount = this.getTotalAmount();
                                                                                    Object other$totalAmount = other.getTotalAmount();
                                                                                    if (this$totalAmount == null
                                                                                       ? other$totalAmount == null
                                                                                       : this$totalAmount.equals(other$totalAmount)) {
                                                                                       Object this$measureUnit = this.getMeasureUnit();
                                                                                       Object other$measureUnit = other.getMeasureUnit();
                                                                                       if (this$measureUnit == null
                                                                                          ? other$measureUnit == null
                                                                                          : this$measureUnit.equals(other$measureUnit)) {
                                                                                          Object this$accountingUnit = this.getAccountingUnit();
                                                                                          Object other$accountingUnit = other.getAccountingUnit();
                                                                                          if (this$accountingUnit == null
                                                                                             ? other$accountingUnit == null
                                                                                             : this$accountingUnit.equals(other$accountingUnit)) {
                                                                                             Object this$auditTime = this.getAuditTime();
                                                                                             Object other$auditTime = other.getAuditTime();
                                                                                             return this$auditTime == null
                                                                                                ? other$auditTime == null
                                                                                                : this$auditTime.equals(other$auditTime);
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
      return other instanceof BusinessReturnProductDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $handleMethod = this.getHandleMethod();
      result = result * 59 + ($handleMethod == null ? 43 : $handleMethod.hashCode());
      Object $pricingManner = this.getPricingManner();
      result = result * 59 + ($pricingManner == null ? 43 : $pricingManner.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $planName = this.getPlanName();
      result = result * 59 + ($planName == null ? 43 : $planName.hashCode());
      Object $productName = this.getProductName();
      result = result * 59 + ($productName == null ? 43 : $productName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $totalAmount = this.getTotalAmount();
      result = result * 59 + ($totalAmount == null ? 43 : $totalAmount.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $auditTime = this.getAuditTime();
      return result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
   }

   @Override
   public String toString() {
      return "BusinessReturnProductDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", project="
         + this.getProject()
         + ", monomerId="
         + this.getMonomerId()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaId="
         + this.getAreaId()
         + ", areaName="
         + this.getAreaName()
         + ", planId="
         + this.getPlanId()
         + ", planName="
         + this.getPlanName()
         + ", productType="
         + this.getProductType()
         + ", productId="
         + this.getProductId()
         + ", handleMethod="
         + this.getHandleMethod()
         + ", productName="
         + this.getProductName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", pricingManner="
         + this.getPricingManner()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", length="
         + this.getLength()
         + ", totalLength="
         + this.getTotalLength()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", totalArea="
         + this.getTotalArea()
         + ", mete="
         + this.getMete()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", totalAmount="
         + this.getTotalAmount()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", auditTime="
         + this.getAuditTime()
         + ")";
   }
}
