package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.cargoList;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.cargoList.SupplierPriceInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "发运审核")
public class CargoListReviewDTO {
   @ApiModelProperty("发货清单id")
   private Long id;
   @ApiModelProperty("项目")
   private ProjectInfo project;
   @ApiModelProperty("运输方式 1运送到场 2客户自提")
   private Integer transportMode;
   @ApiModelProperty("结构计量方式 1理论 2磅记")
   private Integer structureMeasureMode;
   @ApiModelProperty("围护计量方式 1 长度计量 2 面积计量")
   private Integer enclosureMeasureMode;
   @ApiModelProperty("供应商")
   private SupplierPriceInfo supplier;
   @ApiModelProperty("车牌号")
   private String licensePlate;
   @ApiModelProperty("车次编号")
   private String serialNumber;
   @ApiModelProperty("装载类型")
   private Integer productType;
   @ApiModelProperty("总净重量")
   private BigDecimal totalNetWeight;
   @ApiModelProperty("总毛重量")
   private BigDecimal totalGrossWeight;
   @ApiModelProperty("过磅重量")
   private BigDecimal actualWeight;
   @ApiModelProperty("发货额")
   private BigDecimal shipAmount;
   @ApiModelProperty("装车人名称")
   private String userName;
   @ApiModelProperty("过磅人名称")
   private String actualUserName;
   @ApiModelProperty("发运审核人名称")
   private String auditUserName;
   @ApiModelProperty("发运是否审核通过")
   private Integer checkStatus;

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Integer getTransportMode() {
      return this.transportMode;
   }

   public Integer getStructureMeasureMode() {
      return this.structureMeasureMode;
   }

   public Integer getEnclosureMeasureMode() {
      return this.enclosureMeasureMode;
   }

   public SupplierPriceInfo getSupplier() {
      return this.supplier;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getActualWeight() {
      return this.actualWeight;
   }

   public BigDecimal getShipAmount() {
      return this.shipAmount;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getActualUserName() {
      return this.actualUserName;
   }

   public String getAuditUserName() {
      return this.auditUserName;
   }

   public Integer getCheckStatus() {
      return this.checkStatus;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setTransportMode(final Integer transportMode) {
      this.transportMode = transportMode;
   }

   public void setStructureMeasureMode(final Integer structureMeasureMode) {
      this.structureMeasureMode = structureMeasureMode;
   }

   public void setEnclosureMeasureMode(final Integer enclosureMeasureMode) {
      this.enclosureMeasureMode = enclosureMeasureMode;
   }

   public void setSupplier(final SupplierPriceInfo supplier) {
      this.supplier = supplier;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   public void setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
   }

   public void setActualWeight(final BigDecimal actualWeight) {
      this.actualWeight = actualWeight;
   }

   public void setShipAmount(final BigDecimal shipAmount) {
      this.shipAmount = shipAmount;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setActualUserName(final String actualUserName) {
      this.actualUserName = actualUserName;
   }

   public void setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
   }

   public void setCheckStatus(final Integer checkStatus) {
      this.checkStatus = checkStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListReviewDTO)) {
         return false;
      }

      CargoListReviewDTO other = (CargoListReviewDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$transportMode = this.getTransportMode();
         Object other$transportMode = other.getTransportMode();
         if (this$transportMode == null ? other$transportMode == null : this$transportMode.equals(other$transportMode)) {
            Object this$structureMeasureMode = this.getStructureMeasureMode();
            Object other$structureMeasureMode = other.getStructureMeasureMode();
            if (this$structureMeasureMode == null ? other$structureMeasureMode == null : this$structureMeasureMode.equals(other$structureMeasureMode)) {
               Object this$enclosureMeasureMode = this.getEnclosureMeasureMode();
               Object other$enclosureMeasureMode = other.getEnclosureMeasureMode();
               if (this$enclosureMeasureMode == null ? other$enclosureMeasureMode == null : this$enclosureMeasureMode.equals(other$enclosureMeasureMode)) {
                  Object this$productType = this.getProductType();
                  Object other$productType = other.getProductType();
                  if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                     Object this$checkStatus = this.getCheckStatus();
                     Object other$checkStatus = other.getCheckStatus();
                     if (this$checkStatus == null ? other$checkStatus == null : this$checkStatus.equals(other$checkStatus)) {
                        Object this$project = this.getProject();
                        Object other$project = other.getProject();
                        if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                           Object this$supplier = this.getSupplier();
                           Object other$supplier = other.getSupplier();
                           if (this$supplier == null ? other$supplier == null : this$supplier.equals(other$supplier)) {
                              Object this$licensePlate = this.getLicensePlate();
                              Object other$licensePlate = other.getLicensePlate();
                              if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                    Object this$totalNetWeight = this.getTotalNetWeight();
                                    Object other$totalNetWeight = other.getTotalNetWeight();
                                    if (this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight)) {
                                       Object this$totalGrossWeight = this.getTotalGrossWeight();
                                       Object other$totalGrossWeight = other.getTotalGrossWeight();
                                       if (this$totalGrossWeight == null
                                          ? other$totalGrossWeight == null
                                          : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                          Object this$actualWeight = this.getActualWeight();
                                          Object other$actualWeight = other.getActualWeight();
                                          if (this$actualWeight == null ? other$actualWeight == null : this$actualWeight.equals(other$actualWeight)) {
                                             Object this$shipAmount = this.getShipAmount();
                                             Object other$shipAmount = other.getShipAmount();
                                             if (this$shipAmount == null ? other$shipAmount == null : this$shipAmount.equals(other$shipAmount)) {
                                                Object this$userName = this.getUserName();
                                                Object other$userName = other.getUserName();
                                                if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                                   Object this$actualUserName = this.getActualUserName();
                                                   Object other$actualUserName = other.getActualUserName();
                                                   if (this$actualUserName == null
                                                      ? other$actualUserName == null
                                                      : this$actualUserName.equals(other$actualUserName)) {
                                                      Object this$auditUserName = this.getAuditUserName();
                                                      Object other$auditUserName = other.getAuditUserName();
                                                      return this$auditUserName == null
                                                         ? other$auditUserName == null
                                                         : this$auditUserName.equals(other$auditUserName);
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
      return other instanceof CargoListReviewDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $transportMode = this.getTransportMode();
      result = result * 59 + ($transportMode == null ? 43 : $transportMode.hashCode());
      Object $structureMeasureMode = this.getStructureMeasureMode();
      result = result * 59 + ($structureMeasureMode == null ? 43 : $structureMeasureMode.hashCode());
      Object $enclosureMeasureMode = this.getEnclosureMeasureMode();
      result = result * 59 + ($enclosureMeasureMode == null ? 43 : $enclosureMeasureMode.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $checkStatus = this.getCheckStatus();
      result = result * 59 + ($checkStatus == null ? 43 : $checkStatus.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $actualWeight = this.getActualWeight();
      result = result * 59 + ($actualWeight == null ? 43 : $actualWeight.hashCode());
      Object $shipAmount = this.getShipAmount();
      result = result * 59 + ($shipAmount == null ? 43 : $shipAmount.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $actualUserName = this.getActualUserName();
      result = result * 59 + ($actualUserName == null ? 43 : $actualUserName.hashCode());
      Object $auditUserName = this.getAuditUserName();
      return result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
   }

   @Override
   public String toString() {
      return "CargoListReviewDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", transportMode="
         + this.getTransportMode()
         + ", structureMeasureMode="
         + this.getStructureMeasureMode()
         + ", enclosureMeasureMode="
         + this.getEnclosureMeasureMode()
         + ", supplier="
         + this.getSupplier()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", productType="
         + this.getProductType()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", actualWeight="
         + this.getActualWeight()
         + ", shipAmount="
         + this.getShipAmount()
         + ", userName="
         + this.getUserName()
         + ", actualUserName="
         + this.getActualUserName()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", checkStatus="
         + this.getCheckStatus()
         + ")";
   }
}
