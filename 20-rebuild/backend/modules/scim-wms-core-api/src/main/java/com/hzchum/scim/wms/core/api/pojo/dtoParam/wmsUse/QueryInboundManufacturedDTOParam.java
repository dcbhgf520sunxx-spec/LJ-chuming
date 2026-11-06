package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

public class QueryInboundManufacturedDTOParam {
   @ApiModelProperty("基础类型 [位运算]")
   private Integer basicClass;
   @ApiModelProperty("审核状态")
   private Integer reviewStatus;
   @ApiModelProperty("创建时间")
   private List<LocalDateTime> createTime;
   @ApiModelProperty("申请通过时间")
   private List<LocalDateTime> reviewPassTime;
   @ApiModelProperty("供应商ID")
   private Long supplierId;
   @ApiModelProperty("申请人名称")
   private String personName;
   @ApiModelProperty("采购订单编号")
   private String purchaseSN;
   @ApiModelProperty("入库单编号")
   private String serialNumber;
   @ApiModelProperty("项目ID")
   private Long projectId;
   @ApiModelProperty("车牌号")
   private String licensePlate;
   @ApiModelProperty("物流单号")
   private String shipmentNumber;
   @ApiModelProperty("规格")
   private String specification;
   @ApiModelProperty("品牌")
   private String brand;

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public List<LocalDateTime> getCreateTime() {
      return this.createTime;
   }

   public List<LocalDateTime> getReviewPassTime() {
      return this.reviewPassTime;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getPersonName() {
      return this.personName;
   }

   public String getPurchaseSN() {
      return this.purchaseSN;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public String getShipmentNumber() {
      return this.shipmentNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getBrand() {
      return this.brand;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setCreateTime(final List<LocalDateTime> createTime) {
      this.createTime = createTime;
   }

   public void setReviewPassTime(final List<LocalDateTime> reviewPassTime) {
      this.reviewPassTime = reviewPassTime;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setPersonName(final String personName) {
      this.personName = personName;
   }

   public void setPurchaseSN(final String purchaseSN) {
      this.purchaseSN = purchaseSN;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setShipmentNumber(final String shipmentNumber) {
      this.shipmentNumber = shipmentNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryInboundManufacturedDTOParam)) {
         return false;
      }

      QueryInboundManufacturedDTOParam other = (QueryInboundManufacturedDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$basicClass = this.getBasicClass();
      Object other$basicClass = other.getBasicClass();
      if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
         Object this$reviewStatus = this.getReviewStatus();
         Object other$reviewStatus = other.getReviewStatus();
         if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
            Object this$supplierId = this.getSupplierId();
            Object other$supplierId = other.getSupplierId();
            if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$createTime = this.getCreateTime();
                  Object other$createTime = other.getCreateTime();
                  if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                     Object this$reviewPassTime = this.getReviewPassTime();
                     Object other$reviewPassTime = other.getReviewPassTime();
                     if (this$reviewPassTime == null ? other$reviewPassTime == null : this$reviewPassTime.equals(other$reviewPassTime)) {
                        Object this$personName = this.getPersonName();
                        Object other$personName = other.getPersonName();
                        if (this$personName == null ? other$personName == null : this$personName.equals(other$personName)) {
                           Object this$purchaseSN = this.getPurchaseSN();
                           Object other$purchaseSN = other.getPurchaseSN();
                           if (this$purchaseSN == null ? other$purchaseSN == null : this$purchaseSN.equals(other$purchaseSN)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$licensePlate = this.getLicensePlate();
                                 Object other$licensePlate = other.getLicensePlate();
                                 if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                                    Object this$shipmentNumber = this.getShipmentNumber();
                                    Object other$shipmentNumber = other.getShipmentNumber();
                                    if (this$shipmentNumber == null ? other$shipmentNumber == null : this$shipmentNumber.equals(other$shipmentNumber)) {
                                       Object this$specification = this.getSpecification();
                                       Object other$specification = other.getSpecification();
                                       if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                          Object this$brand = this.getBrand();
                                          Object other$brand = other.getBrand();
                                          return this$brand == null ? other$brand == null : this$brand.equals(other$brand);
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
      return other instanceof QueryInboundManufacturedDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $reviewPassTime = this.getReviewPassTime();
      result = result * 59 + ($reviewPassTime == null ? 43 : $reviewPassTime.hashCode());
      Object $personName = this.getPersonName();
      result = result * 59 + ($personName == null ? 43 : $personName.hashCode());
      Object $purchaseSN = this.getPurchaseSN();
      result = result * 59 + ($purchaseSN == null ? 43 : $purchaseSN.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $shipmentNumber = this.getShipmentNumber();
      result = result * 59 + ($shipmentNumber == null ? 43 : $shipmentNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $brand = this.getBrand();
      return result * 59 + ($brand == null ? 43 : $brand.hashCode());
   }

   @Override
   public String toString() {
      return "QueryInboundManufacturedDTOParam(basicClass="
         + this.getBasicClass()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", createTime="
         + this.getCreateTime()
         + ", reviewPassTime="
         + this.getReviewPassTime()
         + ", supplierId="
         + this.getSupplierId()
         + ", personName="
         + this.getPersonName()
         + ", purchaseSN="
         + this.getPurchaseSN()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectId="
         + this.getProjectId()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", shipmentNumber="
         + this.getShipmentNumber()
         + ", specification="
         + this.getSpecification()
         + ", brand="
         + this.getBrand()
         + ")";
   }
}
