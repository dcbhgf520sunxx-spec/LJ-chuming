package com.hzchum.scim.business.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel("车次跟踪列表")
public class TrackingDTO {
   @ApiModelProperty("发货清单id")
   private Long id;
   @ApiModelProperty("项目")
   private ProjectInfo project;
   @ApiModelProperty("制造类型【1：自制，2：外包】")
   private Integer manufactureType;
   @ApiModelProperty("装载类型")
   private Integer productType;
   @ApiModelProperty("车次编号")
   private String serialNumber;
   @ApiModelProperty("车牌号")
   private String licensePlate;
   @ApiModelProperty("发运金额")
   private BigDecimal shipAmount;
   @ApiModelProperty("发运时间")
   private LocalDateTime auditTime;

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Integer getManufactureType() {
      return this.manufactureType;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public BigDecimal getShipAmount() {
      return this.shipAmount;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setManufactureType(final Integer manufactureType) {
      this.manufactureType = manufactureType;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setShipAmount(final BigDecimal shipAmount) {
      this.shipAmount = shipAmount;
   }

   public void setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TrackingDTO)) {
         return false;
      }

      TrackingDTO other = (TrackingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$manufactureType = this.getManufactureType();
         Object other$manufactureType = other.getManufactureType();
         if (this$manufactureType == null ? other$manufactureType == null : this$manufactureType.equals(other$manufactureType)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$project = this.getProject();
               Object other$project = other.getProject();
               if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$licensePlate = this.getLicensePlate();
                     Object other$licensePlate = other.getLicensePlate();
                     if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                        Object this$shipAmount = this.getShipAmount();
                        Object other$shipAmount = other.getShipAmount();
                        if (this$shipAmount == null ? other$shipAmount == null : this$shipAmount.equals(other$shipAmount)) {
                           Object this$auditTime = this.getAuditTime();
                           Object other$auditTime = other.getAuditTime();
                           return this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime);
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
      return other instanceof TrackingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $manufactureType = this.getManufactureType();
      result = result * 59 + ($manufactureType == null ? 43 : $manufactureType.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $shipAmount = this.getShipAmount();
      result = result * 59 + ($shipAmount == null ? 43 : $shipAmount.hashCode());
      Object $auditTime = this.getAuditTime();
      return result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
   }

   @Override
   public String toString() {
      return "TrackingDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", manufactureType="
         + this.getManufactureType()
         + ", productType="
         + this.getProductType()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", shipAmount="
         + this.getShipAmount()
         + ", auditTime="
         + this.getAuditTime()
         + ")";
   }
}
