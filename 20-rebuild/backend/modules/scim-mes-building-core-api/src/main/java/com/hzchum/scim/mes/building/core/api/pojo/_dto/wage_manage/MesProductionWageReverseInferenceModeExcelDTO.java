package com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import java.math.BigDecimal;

@ExcelTarget("MesProductionWageReverseInferenceModeExcelDTO")
public class MesProductionWageReverseInferenceModeExcelDTO {
   @Excel(name = "序号", width = 5.0)
   private Integer orderNo;
   @Excel(name = "项目编号")
   private String projectSerialNumber;
   @Excel(name = "项目名称")
   private String projectShortName;
   @Excel(name = "单体名称")
   private String monomerName;
   @Excel(name = "区域名称")
   private String areaName;
   @Excel(name = "类型名称")
   private String typeName;
   @Excel(name = "产品名称")
   private String productName;
   @Excel(name = "产品编号")
   private String productSerialNumber;
   @Excel(name = "产品规格")
   private String productSpecification;
   @Excel(name = "产品材质")
   private String productMaterial;
   @Excel(name = "工价统计模式")
   private String wageStatisticsModeName;
   @Excel(name = "入库数量")
   private Integer inboundQuantity;
   @Excel(name = "计量方式")
   private String measurementMannerName;
   @Excel(name = "计量量")
   private BigDecimal measurementQuantity;
   @Excel(name = "单价(元)")
   private BigDecimal wage;
   @Excel(name = "金额(元)")
   private BigDecimal totalWage;

   public Integer getOrderNo() {
      return this.orderNo;
   }

   public String getProjectSerialNumber() {
      return this.projectSerialNumber;
   }

   public String getProjectShortName() {
      return this.projectShortName;
   }

   public String getMonomerName() {
      return this.monomerName;
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

   public String getWageStatisticsModeName() {
      return this.wageStatisticsModeName;
   }

   public Integer getInboundQuantity() {
      return this.inboundQuantity;
   }

   public String getMeasurementMannerName() {
      return this.measurementMannerName;
   }

   public BigDecimal getMeasurementQuantity() {
      return this.measurementQuantity;
   }

   public BigDecimal getWage() {
      return this.wage;
   }

   public BigDecimal getTotalWage() {
      return this.totalWage;
   }

   public void setOrderNo(final Integer orderNo) {
      this.orderNo = orderNo;
   }

   public void setProjectSerialNumber(final String projectSerialNumber) {
      this.projectSerialNumber = projectSerialNumber;
   }

   public void setProjectShortName(final String projectShortName) {
      this.projectShortName = projectShortName;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
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

   public void setWageStatisticsModeName(final String wageStatisticsModeName) {
      this.wageStatisticsModeName = wageStatisticsModeName;
   }

   public void setInboundQuantity(final Integer inboundQuantity) {
      this.inboundQuantity = inboundQuantity;
   }

   public void setMeasurementMannerName(final String measurementMannerName) {
      this.measurementMannerName = measurementMannerName;
   }

   public void setMeasurementQuantity(final BigDecimal measurementQuantity) {
      this.measurementQuantity = measurementQuantity;
   }

   public void setWage(final BigDecimal wage) {
      this.wage = wage;
   }

   public void setTotalWage(final BigDecimal totalWage) {
      this.totalWage = totalWage;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesProductionWageReverseInferenceModeExcelDTO)) {
         return false;
      }

      MesProductionWageReverseInferenceModeExcelDTO other = (MesProductionWageReverseInferenceModeExcelDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderNo = this.getOrderNo();
      Object other$orderNo = other.getOrderNo();
      if (this$orderNo == null ? other$orderNo == null : this$orderNo.equals(other$orderNo)) {
         Object this$inboundQuantity = this.getInboundQuantity();
         Object other$inboundQuantity = other.getInboundQuantity();
         if (this$inboundQuantity == null ? other$inboundQuantity == null : this$inboundQuantity.equals(other$inboundQuantity)) {
            Object this$projectSerialNumber = this.getProjectSerialNumber();
            Object other$projectSerialNumber = other.getProjectSerialNumber();
            if (this$projectSerialNumber == null ? other$projectSerialNumber == null : this$projectSerialNumber.equals(other$projectSerialNumber)) {
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
                                    if (this$productMaterial == null ? other$productMaterial == null : this$productMaterial.equals(other$productMaterial)) {
                                       Object this$wageStatisticsModeName = this.getWageStatisticsModeName();
                                       Object other$wageStatisticsModeName = other.getWageStatisticsModeName();
                                       if (this$wageStatisticsModeName == null
                                          ? other$wageStatisticsModeName == null
                                          : this$wageStatisticsModeName.equals(other$wageStatisticsModeName)) {
                                          Object this$measurementMannerName = this.getMeasurementMannerName();
                                          Object other$measurementMannerName = other.getMeasurementMannerName();
                                          if (this$measurementMannerName == null
                                             ? other$measurementMannerName == null
                                             : this$measurementMannerName.equals(other$measurementMannerName)) {
                                             Object this$measurementQuantity = this.getMeasurementQuantity();
                                             Object other$measurementQuantity = other.getMeasurementQuantity();
                                             if (this$measurementQuantity == null
                                                ? other$measurementQuantity == null
                                                : this$measurementQuantity.equals(other$measurementQuantity)) {
                                                Object this$wage = this.getWage();
                                                Object other$wage = other.getWage();
                                                if (this$wage == null ? other$wage == null : this$wage.equals(other$wage)) {
                                                   Object this$totalWage = this.getTotalWage();
                                                   Object other$totalWage = other.getTotalWage();
                                                   return this$totalWage == null ? other$totalWage == null : this$totalWage.equals(other$totalWage);
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
      return other instanceof MesProductionWageReverseInferenceModeExcelDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderNo = this.getOrderNo();
      result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
      Object $inboundQuantity = this.getInboundQuantity();
      result = result * 59 + ($inboundQuantity == null ? 43 : $inboundQuantity.hashCode());
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
      Object $wageStatisticsModeName = this.getWageStatisticsModeName();
      result = result * 59 + ($wageStatisticsModeName == null ? 43 : $wageStatisticsModeName.hashCode());
      Object $measurementMannerName = this.getMeasurementMannerName();
      result = result * 59 + ($measurementMannerName == null ? 43 : $measurementMannerName.hashCode());
      Object $measurementQuantity = this.getMeasurementQuantity();
      result = result * 59 + ($measurementQuantity == null ? 43 : $measurementQuantity.hashCode());
      Object $wage = this.getWage();
      result = result * 59 + ($wage == null ? 43 : $wage.hashCode());
      Object $totalWage = this.getTotalWage();
      return result * 59 + ($totalWage == null ? 43 : $totalWage.hashCode());
   }

   @Override
   public String toString() {
      return "MesProductionWageReverseInferenceModeExcelDTO(orderNo="
         + this.getOrderNo()
         + ", projectSerialNumber="
         + this.getProjectSerialNumber()
         + ", projectShortName="
         + this.getProjectShortName()
         + ", monomerName="
         + this.getMonomerName()
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
         + ", wageStatisticsModeName="
         + this.getWageStatisticsModeName()
         + ", inboundQuantity="
         + this.getInboundQuantity()
         + ", measurementMannerName="
         + this.getMeasurementMannerName()
         + ", measurementQuantity="
         + this.getMeasurementQuantity()
         + ", wage="
         + this.getWage()
         + ", totalWage="
         + this.getTotalWage()
         + ")";
   }
}
