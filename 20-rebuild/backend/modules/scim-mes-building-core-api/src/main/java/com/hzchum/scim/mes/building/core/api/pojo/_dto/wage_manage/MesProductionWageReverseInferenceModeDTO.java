package com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("生产工资反推模式生产明细DTO类")
public class MesProductionWageReverseInferenceModeDTO {
   @ApiModelProperty("主键ID")
   private Long id;
   @ApiModelProperty("项目ID")
   private Long projectId;
   @ApiModelProperty("项目编号")
   private String projectSerialNumber;
   @ApiModelProperty("项目名称")
   private String projectShortName;
   @ApiModelProperty("单体ID")
   private Long monomerId;
   @ApiModelProperty("单体名称")
   private String monomerName;
   @ApiModelProperty("区域ID")
   private Long areaId;
   @ApiModelProperty("区域名称")
   private String areaName;
   @ApiModelProperty("类型名称")
   private String typeName;
   @ApiModelProperty("产品名称")
   private String productName;
   @ApiModelProperty("产品编号")
   private String productSerialNumber;
   @ApiModelProperty("产品规格")
   private String productSpecification;
   @ApiModelProperty("产品材质")
   private String productMaterial;
   @ApiModelProperty("入库数量")
   private Integer inboundQuantity;
   @ApiModelProperty("单价(元)")
   private BigDecimal wage;
   @ApiModelProperty("金额(元)")
   private BigDecimal totalWage;
   @ApiModelProperty(name = "measurementManner", value = "计量方式", notes = "计量方式")
   private Integer measurementManner;
   @ApiModelProperty(name = "measurementQuantity", value = "计量量", notes = "计量量")
   private BigDecimal measurementQuantity;
   @ApiModelProperty(name = "wageStatisticsMode", value = "工价统计模式", notes = "工价统计模式")
   private Integer wageStatisticsMode;
   @ApiModelProperty("工序ID")
   private Long processId;
   @ApiModelProperty("工序名称")
   private String processName;

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectSerialNumber() {
      return this.projectSerialNumber;
   }

   public String getProjectShortName() {
      return this.projectShortName;
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

   public String getTypeName() {
      return this.typeName;
   }

   public String getProductName() {
      return this.productName;
   }

   public String getProductSerialNumber() {
      return this.productSerialNumber;
   }

   public String getProductSpecification() {
      return this.productSpecification;
   }

   public String getProductMaterial() {
      return this.productMaterial;
   }

   public Integer getInboundQuantity() {
      return this.inboundQuantity;
   }

   public BigDecimal getWage() {
      return this.wage;
   }

   public BigDecimal getTotalWage() {
      return this.totalWage;
   }

   public Integer getMeasurementManner() {
      return this.measurementManner;
   }

   public BigDecimal getMeasurementQuantity() {
      return this.measurementQuantity;
   }

   public Integer getWageStatisticsMode() {
      return this.wageStatisticsMode;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectSerialNumber(final String projectSerialNumber) {
      this.projectSerialNumber = projectSerialNumber;
   }

   public void setProjectShortName(final String projectShortName) {
      this.projectShortName = projectShortName;
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

   public void setTypeName(final String typeName) {
      this.typeName = typeName;
   }

   public void setProductName(final String productName) {
      this.productName = productName;
   }

   public void setProductSerialNumber(final String productSerialNumber) {
      this.productSerialNumber = productSerialNumber;
   }

   public void setProductSpecification(final String productSpecification) {
      this.productSpecification = productSpecification;
   }

   public void setProductMaterial(final String productMaterial) {
      this.productMaterial = productMaterial;
   }

   public void setInboundQuantity(final Integer inboundQuantity) {
      this.inboundQuantity = inboundQuantity;
   }

   public void setWage(final BigDecimal wage) {
      this.wage = wage;
   }

   public void setTotalWage(final BigDecimal totalWage) {
      this.totalWage = totalWage;
   }

   public void setMeasurementManner(final Integer measurementManner) {
      this.measurementManner = measurementManner;
   }

   public void setMeasurementQuantity(final BigDecimal measurementQuantity) {
      this.measurementQuantity = measurementQuantity;
   }

   public void setWageStatisticsMode(final Integer wageStatisticsMode) {
      this.wageStatisticsMode = wageStatisticsMode;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesProductionWageReverseInferenceModeDTO)) {
         return false;
      }

      MesProductionWageReverseInferenceModeDTO other = (MesProductionWageReverseInferenceModeDTO)o;
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
                  Object this$inboundQuantity = this.getInboundQuantity();
                  Object other$inboundQuantity = other.getInboundQuantity();
                  if (this$inboundQuantity == null ? other$inboundQuantity == null : this$inboundQuantity.equals(other$inboundQuantity)) {
                     Object this$measurementManner = this.getMeasurementManner();
                     Object other$measurementManner = other.getMeasurementManner();
                     if (this$measurementManner == null ? other$measurementManner == null : this$measurementManner.equals(other$measurementManner)) {
                        Object this$wageStatisticsMode = this.getWageStatisticsMode();
                        Object other$wageStatisticsMode = other.getWageStatisticsMode();
                        if (this$wageStatisticsMode == null ? other$wageStatisticsMode == null : this$wageStatisticsMode.equals(other$wageStatisticsMode)) {
                           Object this$processId = this.getProcessId();
                           Object other$processId = other.getProcessId();
                           if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                              Object this$projectSerialNumber = this.getProjectSerialNumber();
                              Object other$projectSerialNumber = other.getProjectSerialNumber();
                              if (this$projectSerialNumber == null
                                 ? other$projectSerialNumber == null
                                 : this$projectSerialNumber.equals(other$projectSerialNumber)) {
                                 Object this$projectShortName = this.getProjectShortName();
                                 Object other$projectShortName = other.getProjectShortName();
                                 if (this$projectShortName == null ? other$projectShortName == null : this$projectShortName.equals(other$projectShortName)) {
                                    Object this$monomerName = this.getMonomerName();
                                    Object other$monomerName = other.getMonomerName();
                                    if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                                       Object this$areaName = this.getAreaName();
                                       Object other$areaName = other.getAreaName();
                                       if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                                          Object this$typeName = this.getTypeName();
                                          Object other$typeName = other.getTypeName();
                                          if (this$typeName == null ? other$typeName == null : this$typeName.equals(other$typeName)) {
                                             Object this$productName = this.getProductName();
                                             Object other$productName = other.getProductName();
                                             if (this$productName == null ? other$productName == null : this$productName.equals(other$productName)) {
                                                Object this$productSerialNumber = this.getProductSerialNumber();
                                                Object other$productSerialNumber = other.getProductSerialNumber();
                                                if (this$productSerialNumber == null
                                                   ? other$productSerialNumber == null
                                                   : this$productSerialNumber.equals(other$productSerialNumber)) {
                                                   Object this$productSpecification = this.getProductSpecification();
                                                   Object other$productSpecification = other.getProductSpecification();
                                                   if (this$productSpecification == null
                                                      ? other$productSpecification == null
                                                      : this$productSpecification.equals(other$productSpecification)) {
                                                      Object this$productMaterial = this.getProductMaterial();
                                                      Object other$productMaterial = other.getProductMaterial();
                                                      if (this$productMaterial == null
                                                         ? other$productMaterial == null
                                                         : this$productMaterial.equals(other$productMaterial)) {
                                                         Object this$wage = this.getWage();
                                                         Object other$wage = other.getWage();
                                                         if (this$wage == null ? other$wage == null : this$wage.equals(other$wage)) {
                                                            Object this$totalWage = this.getTotalWage();
                                                            Object other$totalWage = other.getTotalWage();
                                                            if (this$totalWage == null ? other$totalWage == null : this$totalWage.equals(other$totalWage)) {
                                                               Object this$measurementQuantity = this.getMeasurementQuantity();
                                                               Object other$measurementQuantity = other.getMeasurementQuantity();
                                                               if (this$measurementQuantity == null
                                                                  ? other$measurementQuantity == null
                                                                  : this$measurementQuantity.equals(other$measurementQuantity)) {
                                                                  Object this$processName = this.getProcessName();
                                                                  Object other$processName = other.getProcessName();
                                                                  return this$processName == null
                                                                     ? other$processName == null
                                                                     : this$processName.equals(other$processName);
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
      return other instanceof MesProductionWageReverseInferenceModeDTO;
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
      Object $inboundQuantity = this.getInboundQuantity();
      result = result * 59 + ($inboundQuantity == null ? 43 : $inboundQuantity.hashCode());
      Object $measurementManner = this.getMeasurementManner();
      result = result * 59 + ($measurementManner == null ? 43 : $measurementManner.hashCode());
      Object $wageStatisticsMode = this.getWageStatisticsMode();
      result = result * 59 + ($wageStatisticsMode == null ? 43 : $wageStatisticsMode.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $projectSerialNumber = this.getProjectSerialNumber();
      result = result * 59 + ($projectSerialNumber == null ? 43 : $projectSerialNumber.hashCode());
      Object $projectShortName = this.getProjectShortName();
      result = result * 59 + ($projectShortName == null ? 43 : $projectShortName.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $typeName = this.getTypeName();
      result = result * 59 + ($typeName == null ? 43 : $typeName.hashCode());
      Object $productName = this.getProductName();
      result = result * 59 + ($productName == null ? 43 : $productName.hashCode());
      Object $productSerialNumber = this.getProductSerialNumber();
      result = result * 59 + ($productSerialNumber == null ? 43 : $productSerialNumber.hashCode());
      Object $productSpecification = this.getProductSpecification();
      result = result * 59 + ($productSpecification == null ? 43 : $productSpecification.hashCode());
      Object $productMaterial = this.getProductMaterial();
      result = result * 59 + ($productMaterial == null ? 43 : $productMaterial.hashCode());
      Object $wage = this.getWage();
      result = result * 59 + ($wage == null ? 43 : $wage.hashCode());
      Object $totalWage = this.getTotalWage();
      result = result * 59 + ($totalWage == null ? 43 : $totalWage.hashCode());
      Object $measurementQuantity = this.getMeasurementQuantity();
      result = result * 59 + ($measurementQuantity == null ? 43 : $measurementQuantity.hashCode());
      Object $processName = this.getProcessName();
      return result * 59 + ($processName == null ? 43 : $processName.hashCode());
   }

   @Override
   public String toString() {
      return "MesProductionWageReverseInferenceModeDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", projectSerialNumber="
         + this.getProjectSerialNumber()
         + ", projectShortName="
         + this.getProjectShortName()
         + ", monomerId="
         + this.getMonomerId()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaId="
         + this.getAreaId()
         + ", areaName="
         + this.getAreaName()
         + ", typeName="
         + this.getTypeName()
         + ", productName="
         + this.getProductName()
         + ", productSerialNumber="
         + this.getProductSerialNumber()
         + ", productSpecification="
         + this.getProductSpecification()
         + ", productMaterial="
         + this.getProductMaterial()
         + ", inboundQuantity="
         + this.getInboundQuantity()
         + ", wage="
         + this.getWage()
         + ", totalWage="
         + this.getTotalWage()
         + ", measurementManner="
         + this.getMeasurementManner()
         + ", measurementQuantity="
         + this.getMeasurementQuantity()
         + ", wageStatisticsMode="
         + this.getWageStatisticsMode()
         + ", processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ")";
   }
}
