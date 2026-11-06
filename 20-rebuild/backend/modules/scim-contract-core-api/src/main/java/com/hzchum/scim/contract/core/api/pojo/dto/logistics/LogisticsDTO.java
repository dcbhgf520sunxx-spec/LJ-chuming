package com.hzchum.scim.contract.core.api.pojo.dto.logistics;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("物流汇总")
public class LogisticsDTO {
   @ApiModelProperty("项目id/采购订单id/物流公司id")
   private Long id;
   @ApiModelProperty("项目名称")
   @JsonInclude(Include.NON_NULL)
   private String projectName;
   @ApiModelProperty(name = "short_name", notes = "项目简称")
   private String shortName;
   @ApiModelProperty("采购/项目合同编号")
   @JsonInclude(Include.NON_NULL)
   private String serialNumber;
   @ApiModelProperty("物流公司")
   @JsonInclude(Include.NON_NULL)
   private String supplierName;
   @ApiModelProperty("车牌(个人)")
   @JsonInclude(Include.NON_NULL)
   private String licensePlate;
   @ApiModelProperty("累计车次")
   private Integer trainNumber;
   @ApiModelProperty("累计运费")
   private BigDecimal freight;
   @ApiModelProperty("是否个人")
   private Integer boolPersonalEnum;

   public Long getId() {
      return this.id;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public Integer getTrainNumber() {
      return this.trainNumber;
   }

   public BigDecimal getFreight() {
      return this.freight;
   }

   public Integer getBoolPersonalEnum() {
      return this.boolPersonalEnum;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setTrainNumber(final Integer trainNumber) {
      this.trainNumber = trainNumber;
   }

   public void setFreight(final BigDecimal freight) {
      this.freight = freight;
   }

   public void setBoolPersonalEnum(final Integer boolPersonalEnum) {
      this.boolPersonalEnum = boolPersonalEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof LogisticsDTO)) {
         return false;
      }

      LogisticsDTO other = (LogisticsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$trainNumber = this.getTrainNumber();
         Object other$trainNumber = other.getTrainNumber();
         if (this$trainNumber == null ? other$trainNumber == null : this$trainNumber.equals(other$trainNumber)) {
            Object this$boolPersonalEnum = this.getBoolPersonalEnum();
            Object other$boolPersonalEnum = other.getBoolPersonalEnum();
            if (this$boolPersonalEnum == null ? other$boolPersonalEnum == null : this$boolPersonalEnum.equals(other$boolPersonalEnum)) {
               Object this$projectName = this.getProjectName();
               Object other$projectName = other.getProjectName();
               if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                  Object this$shortName = this.getShortName();
                  Object other$shortName = other.getShortName();
                  if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                     Object this$serialNumber = this.getSerialNumber();
                     Object other$serialNumber = other.getSerialNumber();
                     if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                        Object this$supplierName = this.getSupplierName();
                        Object other$supplierName = other.getSupplierName();
                        if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                           Object this$licensePlate = this.getLicensePlate();
                           Object other$licensePlate = other.getLicensePlate();
                           if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                              Object this$freight = this.getFreight();
                              Object other$freight = other.getFreight();
                              return this$freight == null ? other$freight == null : this$freight.equals(other$freight);
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
      return other instanceof LogisticsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $trainNumber = this.getTrainNumber();
      result = result * 59 + ($trainNumber == null ? 43 : $trainNumber.hashCode());
      Object $boolPersonalEnum = this.getBoolPersonalEnum();
      result = result * 59 + ($boolPersonalEnum == null ? 43 : $boolPersonalEnum.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $freight = this.getFreight();
      return result * 59 + ($freight == null ? 43 : $freight.hashCode());
   }

   @Override
   public String toString() {
      return "LogisticsDTO(id="
         + this.getId()
         + ", projectName="
         + this.getProjectName()
         + ", shortName="
         + this.getShortName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", supplierName="
         + this.getSupplierName()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", trainNumber="
         + this.getTrainNumber()
         + ", freight="
         + this.getFreight()
         + ", boolPersonalEnum="
         + this.getBoolPersonalEnum()
         + ")";
   }
}
