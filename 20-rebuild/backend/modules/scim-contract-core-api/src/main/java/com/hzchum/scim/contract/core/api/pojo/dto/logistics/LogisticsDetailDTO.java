package com.hzchum.scim.contract.core.api.pojo.dto.logistics;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel("物流明细")
public class LogisticsDetailDTO {
   @ApiModelProperty("id")
   private Long id;
   @ApiModelProperty("项目")
   private String projectName;
   @ApiModelProperty("类型 1原材料运输 2制成品发运")
   private Integer type;
   @ApiModelProperty("运输日期")
   private LocalDateTime shipDate;
   @ApiModelProperty("车牌号")
   private String licensePlate;
   @ApiModelProperty("装载重量")
   private BigDecimal loadingWeight;
   @ApiModelProperty("车型")
   private String carModel;
   @ApiModelProperty("司机姓名")
   private String driverName;
   @ApiModelProperty("司机电话")
   private String driverPhone;
   @ApiModelProperty("累计运费")
   private BigDecimal freight;
   @ApiModelProperty(name = "changeFreight", value = "运费变更类型")
   private Integer changeFreight;
   @ApiModelProperty("是否个人承运")
   private Integer boolPersonalEnum;
   @ApiModelProperty("项目id集合")
   private String projectIds;

   public Long getId() {
      return this.id;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Integer getType() {
      return this.type;
   }

   public LocalDateTime getShipDate() {
      return this.shipDate;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public BigDecimal getLoadingWeight() {
      return this.loadingWeight;
   }

   public String getCarModel() {
      return this.carModel;
   }

   public String getDriverName() {
      return this.driverName;
   }

   public String getDriverPhone() {
      return this.driverPhone;
   }

   public BigDecimal getFreight() {
      return this.freight;
   }

   public Integer getChangeFreight() {
      return this.changeFreight;
   }

   public Integer getBoolPersonalEnum() {
      return this.boolPersonalEnum;
   }

   public String getProjectIds() {
      return this.projectIds;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setShipDate(final LocalDateTime shipDate) {
      this.shipDate = shipDate;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setLoadingWeight(final BigDecimal loadingWeight) {
      this.loadingWeight = loadingWeight;
   }

   public void setCarModel(final String carModel) {
      this.carModel = carModel;
   }

   public void setDriverName(final String driverName) {
      this.driverName = driverName;
   }

   public void setDriverPhone(final String driverPhone) {
      this.driverPhone = driverPhone;
   }

   public void setFreight(final BigDecimal freight) {
      this.freight = freight;
   }

   public void setChangeFreight(final Integer changeFreight) {
      this.changeFreight = changeFreight;
   }

   public void setBoolPersonalEnum(final Integer boolPersonalEnum) {
      this.boolPersonalEnum = boolPersonalEnum;
   }

   public void setProjectIds(final String projectIds) {
      this.projectIds = projectIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof LogisticsDetailDTO)) {
         return false;
      }

      LogisticsDetailDTO other = (LogisticsDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$changeFreight = this.getChangeFreight();
            Object other$changeFreight = other.getChangeFreight();
            if (this$changeFreight == null ? other$changeFreight == null : this$changeFreight.equals(other$changeFreight)) {
               Object this$boolPersonalEnum = this.getBoolPersonalEnum();
               Object other$boolPersonalEnum = other.getBoolPersonalEnum();
               if (this$boolPersonalEnum == null ? other$boolPersonalEnum == null : this$boolPersonalEnum.equals(other$boolPersonalEnum)) {
                  Object this$projectName = this.getProjectName();
                  Object other$projectName = other.getProjectName();
                  if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                     Object this$shipDate = this.getShipDate();
                     Object other$shipDate = other.getShipDate();
                     if (this$shipDate == null ? other$shipDate == null : this$shipDate.equals(other$shipDate)) {
                        Object this$licensePlate = this.getLicensePlate();
                        Object other$licensePlate = other.getLicensePlate();
                        if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                           Object this$loadingWeight = this.getLoadingWeight();
                           Object other$loadingWeight = other.getLoadingWeight();
                           if (this$loadingWeight == null ? other$loadingWeight == null : this$loadingWeight.equals(other$loadingWeight)) {
                              Object this$carModel = this.getCarModel();
                              Object other$carModel = other.getCarModel();
                              if (this$carModel == null ? other$carModel == null : this$carModel.equals(other$carModel)) {
                                 Object this$driverName = this.getDriverName();
                                 Object other$driverName = other.getDriverName();
                                 if (this$driverName == null ? other$driverName == null : this$driverName.equals(other$driverName)) {
                                    Object this$driverPhone = this.getDriverPhone();
                                    Object other$driverPhone = other.getDriverPhone();
                                    if (this$driverPhone == null ? other$driverPhone == null : this$driverPhone.equals(other$driverPhone)) {
                                       Object this$freight = this.getFreight();
                                       Object other$freight = other.getFreight();
                                       if (this$freight == null ? other$freight == null : this$freight.equals(other$freight)) {
                                          Object this$projectIds = this.getProjectIds();
                                          Object other$projectIds = other.getProjectIds();
                                          return this$projectIds == null ? other$projectIds == null : this$projectIds.equals(other$projectIds);
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
      return other instanceof LogisticsDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $changeFreight = this.getChangeFreight();
      result = result * 59 + ($changeFreight == null ? 43 : $changeFreight.hashCode());
      Object $boolPersonalEnum = this.getBoolPersonalEnum();
      result = result * 59 + ($boolPersonalEnum == null ? 43 : $boolPersonalEnum.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $shipDate = this.getShipDate();
      result = result * 59 + ($shipDate == null ? 43 : $shipDate.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $loadingWeight = this.getLoadingWeight();
      result = result * 59 + ($loadingWeight == null ? 43 : $loadingWeight.hashCode());
      Object $carModel = this.getCarModel();
      result = result * 59 + ($carModel == null ? 43 : $carModel.hashCode());
      Object $driverName = this.getDriverName();
      result = result * 59 + ($driverName == null ? 43 : $driverName.hashCode());
      Object $driverPhone = this.getDriverPhone();
      result = result * 59 + ($driverPhone == null ? 43 : $driverPhone.hashCode());
      Object $freight = this.getFreight();
      result = result * 59 + ($freight == null ? 43 : $freight.hashCode());
      Object $projectIds = this.getProjectIds();
      return result * 59 + ($projectIds == null ? 43 : $projectIds.hashCode());
   }

   @Override
   public String toString() {
      return "LogisticsDetailDTO(id="
         + this.getId()
         + ", projectName="
         + this.getProjectName()
         + ", type="
         + this.getType()
         + ", shipDate="
         + this.getShipDate()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", loadingWeight="
         + this.getLoadingWeight()
         + ", carModel="
         + this.getCarModel()
         + ", driverName="
         + this.getDriverName()
         + ", driverPhone="
         + this.getDriverPhone()
         + ", freight="
         + this.getFreight()
         + ", changeFreight="
         + this.getChangeFreight()
         + ", boolPersonalEnum="
         + this.getBoolPersonalEnum()
         + ", projectIds="
         + this.getProjectIds()
         + ")";
   }
}
