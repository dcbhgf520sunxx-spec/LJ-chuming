package com.hzchum.scim.contract.core.api.pojo.dtoParam.update;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("项目基本信息变更类")
public class ProjectBaseChangeDTOParam {
   @NotBlank(message = "项目编号不能为空!")
   @ApiModelProperty(name = "serialNumber", value = "项目编号")
   private String serialNumber;
   @NotBlank(message = "项目名称不能为空!")
   @ApiModelProperty(name = "name", value = "项目名称")
   private String name;
   @NotBlank(message = "合同简称不能为空!")
   @ApiModelProperty(name = "shortName", value = "合同简称")
   private String shortName;
   @NotNull(message = "项目计划开始日期")
   @ApiModelProperty(name = "startDate", value = "计划开始日期")
   private LocalDate startDate;
   @NotNull(message = "项目计划结束日期不能为空")
   @ApiModelProperty(name = "endDate", value = "计划结束日期")
   private LocalDate endDate;
   @ApiModelProperty(name = "orderSourceType", value = "项目订单来源类型 1内部 2外部 枚举:OrderSourceTypeEnum")
   private Integer orderSourceType;
   @ApiModelProperty(name = "countryId", value = "国家id")
   private Long countryId;
   @ApiModelProperty(name = "country_name", value = "国家名称")
   private String countryName;
   @ApiModelProperty(name = "provinceId", value = "省id")
   private Long provinceId;
   @ApiModelProperty(name = "provinceName", value = "省名称")
   private String provinceName;
   @ApiModelProperty(name = "cityId", value = "城市id")
   private Long cityId;
   @ApiModelProperty(name = "cityName", value = "城市名称")
   private String cityName;
   @ApiModelProperty(name = "regionId", value = "区id")
   private Long regionId;
   @ApiModelProperty(name = "regionName", value = "区名称")
   private String regionName;
   @ApiModelProperty(name = "address", value = "详细地址")
   private String address;
   @ApiModelProperty(name = "projectManagerId", value = "项目经理id")
   private Long projectManagerId;
   @ApiModelProperty(name = "projectManagerName", value = "项目经理名称")
   private String projectManagerName;
   @ApiModelProperty(name = "projectManagerPhone", value = "项目经理电话")
   private String projectManagerPhone;
   @ApiModelProperty(name = "signerId", value = "签约人id")
   private Long signerId;
   @ApiModelProperty(name = "signerName", value = "签约人名字")
   private String signerName;
   @ApiModelProperty(name = "signerPhone", value = "签约人电话")
   private String signerPhone;
   @ApiModelProperty(name = "businessLeaderId", value = "业务负责人一id")
   private Long businessLeaderId;
   @ApiModelProperty(name = "businessLeaderTwoId", value = "业务负责人二id")
   private Long businessLeaderTwoId;
   @ApiModelProperty(name = "contractAmount", value = "合同金额（万元）")
   private BigDecimal contractAmount;
   @ApiModelProperty(name = "prepayments", value = "预付款")
   private BigDecimal prepayments;
   @ApiModelProperty(name = "managementFeeRate", value = "管理费 %")
   private BigDecimal managementFeeRate;
   @ApiModelProperty(name = "marginAmount", value = "保证金金额（万元）")
   private BigDecimal marginAmount;
   @ApiModelProperty(name = "marginType", value = "保证金类型")
   private String marginType;
   @ApiModelProperty(name = "currencyType", value = "币种 (暂时先固定几种) RMB,EUR,USD,JPY")
   private String currencyType;
   @ApiModelProperty(name = "qualityGuaranteeDeposit", notes = "质保金(%)")
   private BigDecimal qualityGuaranteeDeposit;
   @ApiModelProperty(name = "contractAttachmentIds", value = "合同附件id列表")
   private List<Long> attachments;

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public Integer getOrderSourceType() {
      return this.orderSourceType;
   }

   public Long getCountryId() {
      return this.countryId;
   }

   public String getCountryName() {
      return this.countryName;
   }

   public Long getProvinceId() {
      return this.provinceId;
   }

   public String getProvinceName() {
      return this.provinceName;
   }

   public Long getCityId() {
      return this.cityId;
   }

   public String getCityName() {
      return this.cityName;
   }

   public Long getRegionId() {
      return this.regionId;
   }

   public String getRegionName() {
      return this.regionName;
   }

   public String getAddress() {
      return this.address;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public String getProjectManagerName() {
      return this.projectManagerName;
   }

   public String getProjectManagerPhone() {
      return this.projectManagerPhone;
   }

   public Long getSignerId() {
      return this.signerId;
   }

   public String getSignerName() {
      return this.signerName;
   }

   public String getSignerPhone() {
      return this.signerPhone;
   }

   public Long getBusinessLeaderId() {
      return this.businessLeaderId;
   }

   public Long getBusinessLeaderTwoId() {
      return this.businessLeaderTwoId;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public BigDecimal getPrepayments() {
      return this.prepayments;
   }

   public BigDecimal getManagementFeeRate() {
      return this.managementFeeRate;
   }

   public BigDecimal getMarginAmount() {
      return this.marginAmount;
   }

   public String getMarginType() {
      return this.marginType;
   }

   public String getCurrencyType() {
      return this.currencyType;
   }

   public BigDecimal getQualityGuaranteeDeposit() {
      return this.qualityGuaranteeDeposit;
   }

   public List<Long> getAttachments() {
      return this.attachments;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setOrderSourceType(final Integer orderSourceType) {
      this.orderSourceType = orderSourceType;
   }

   public void setCountryId(final Long countryId) {
      this.countryId = countryId;
   }

   public void setCountryName(final String countryName) {
      this.countryName = countryName;
   }

   public void setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
   }

   public void setProvinceName(final String provinceName) {
      this.provinceName = provinceName;
   }

   public void setCityId(final Long cityId) {
      this.cityId = cityId;
   }

   public void setCityName(final String cityName) {
      this.cityName = cityName;
   }

   public void setRegionId(final Long regionId) {
      this.regionId = regionId;
   }

   public void setRegionName(final String regionName) {
      this.regionName = regionName;
   }

   public void setAddress(final String address) {
      this.address = address;
   }

   public void setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
   }

   public void setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
   }

   public void setProjectManagerPhone(final String projectManagerPhone) {
      this.projectManagerPhone = projectManagerPhone;
   }

   public void setSignerId(final Long signerId) {
      this.signerId = signerId;
   }

   public void setSignerName(final String signerName) {
      this.signerName = signerName;
   }

   public void setSignerPhone(final String signerPhone) {
      this.signerPhone = signerPhone;
   }

   public void setBusinessLeaderId(final Long businessLeaderId) {
      this.businessLeaderId = businessLeaderId;
   }

   public void setBusinessLeaderTwoId(final Long businessLeaderTwoId) {
      this.businessLeaderTwoId = businessLeaderTwoId;
   }

   public void setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
   }

   public void setPrepayments(final BigDecimal prepayments) {
      this.prepayments = prepayments;
   }

   public void setManagementFeeRate(final BigDecimal managementFeeRate) {
      this.managementFeeRate = managementFeeRate;
   }

   public void setMarginAmount(final BigDecimal marginAmount) {
      this.marginAmount = marginAmount;
   }

   public void setMarginType(final String marginType) {
      this.marginType = marginType;
   }

   public void setCurrencyType(final String currencyType) {
      this.currencyType = currencyType;
   }

   public void setQualityGuaranteeDeposit(final BigDecimal qualityGuaranteeDeposit) {
      this.qualityGuaranteeDeposit = qualityGuaranteeDeposit;
   }

   public void setAttachments(final List<Long> attachments) {
      this.attachments = attachments;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectBaseChangeDTOParam)) {
         return false;
      }

      ProjectBaseChangeDTOParam other = (ProjectBaseChangeDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderSourceType = this.getOrderSourceType();
      Object other$orderSourceType = other.getOrderSourceType();
      if (this$orderSourceType == null ? other$orderSourceType == null : this$orderSourceType.equals(other$orderSourceType)) {
         Object this$countryId = this.getCountryId();
         Object other$countryId = other.getCountryId();
         if (this$countryId == null ? other$countryId == null : this$countryId.equals(other$countryId)) {
            Object this$provinceId = this.getProvinceId();
            Object other$provinceId = other.getProvinceId();
            if (this$provinceId == null ? other$provinceId == null : this$provinceId.equals(other$provinceId)) {
               Object this$cityId = this.getCityId();
               Object other$cityId = other.getCityId();
               if (this$cityId == null ? other$cityId == null : this$cityId.equals(other$cityId)) {
                  Object this$regionId = this.getRegionId();
                  Object other$regionId = other.getRegionId();
                  if (this$regionId == null ? other$regionId == null : this$regionId.equals(other$regionId)) {
                     Object this$projectManagerId = this.getProjectManagerId();
                     Object other$projectManagerId = other.getProjectManagerId();
                     if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
                        Object this$signerId = this.getSignerId();
                        Object other$signerId = other.getSignerId();
                        if (this$signerId == null ? other$signerId == null : this$signerId.equals(other$signerId)) {
                           Object this$businessLeaderId = this.getBusinessLeaderId();
                           Object other$businessLeaderId = other.getBusinessLeaderId();
                           if (this$businessLeaderId == null ? other$businessLeaderId == null : this$businessLeaderId.equals(other$businessLeaderId)) {
                              Object this$businessLeaderTwoId = this.getBusinessLeaderTwoId();
                              Object other$businessLeaderTwoId = other.getBusinessLeaderTwoId();
                              if (this$businessLeaderTwoId == null
                                 ? other$businessLeaderTwoId == null
                                 : this$businessLeaderTwoId.equals(other$businessLeaderTwoId)) {
                                 Object this$serialNumber = this.getSerialNumber();
                                 Object other$serialNumber = other.getSerialNumber();
                                 if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                    Object this$name = this.getName();
                                    Object other$name = other.getName();
                                    if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                       Object this$shortName = this.getShortName();
                                       Object other$shortName = other.getShortName();
                                       if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
                                          Object this$startDate = this.getStartDate();
                                          Object other$startDate = other.getStartDate();
                                          if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                                             Object this$endDate = this.getEndDate();
                                             Object other$endDate = other.getEndDate();
                                             if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                                                Object this$countryName = this.getCountryName();
                                                Object other$countryName = other.getCountryName();
                                                if (this$countryName == null ? other$countryName == null : this$countryName.equals(other$countryName)) {
                                                   Object this$provinceName = this.getProvinceName();
                                                   Object other$provinceName = other.getProvinceName();
                                                   if (this$provinceName == null ? other$provinceName == null : this$provinceName.equals(other$provinceName)) {
                                                      Object this$cityName = this.getCityName();
                                                      Object other$cityName = other.getCityName();
                                                      if (this$cityName == null ? other$cityName == null : this$cityName.equals(other$cityName)) {
                                                         Object this$regionName = this.getRegionName();
                                                         Object other$regionName = other.getRegionName();
                                                         if (this$regionName == null ? other$regionName == null : this$regionName.equals(other$regionName)) {
                                                            Object this$address = this.getAddress();
                                                            Object other$address = other.getAddress();
                                                            if (this$address == null ? other$address == null : this$address.equals(other$address)) {
                                                               Object this$projectManagerName = this.getProjectManagerName();
                                                               Object other$projectManagerName = other.getProjectManagerName();
                                                               if (this$projectManagerName == null
                                                                  ? other$projectManagerName == null
                                                                  : this$projectManagerName.equals(other$projectManagerName)) {
                                                                  Object this$projectManagerPhone = this.getProjectManagerPhone();
                                                                  Object other$projectManagerPhone = other.getProjectManagerPhone();
                                                                  if (this$projectManagerPhone == null
                                                                     ? other$projectManagerPhone == null
                                                                     : this$projectManagerPhone.equals(other$projectManagerPhone)) {
                                                                     Object this$signerName = this.getSignerName();
                                                                     Object other$signerName = other.getSignerName();
                                                                     if (this$signerName == null
                                                                        ? other$signerName == null
                                                                        : this$signerName.equals(other$signerName)) {
                                                                        Object this$signerPhone = this.getSignerPhone();
                                                                        Object other$signerPhone = other.getSignerPhone();
                                                                        if (this$signerPhone == null
                                                                           ? other$signerPhone == null
                                                                           : this$signerPhone.equals(other$signerPhone)) {
                                                                           Object this$contractAmount = this.getContractAmount();
                                                                           Object other$contractAmount = other.getContractAmount();
                                                                           if (this$contractAmount == null
                                                                              ? other$contractAmount == null
                                                                              : this$contractAmount.equals(other$contractAmount)) {
                                                                              Object this$prepayments = this.getPrepayments();
                                                                              Object other$prepayments = other.getPrepayments();
                                                                              if (this$prepayments == null
                                                                                 ? other$prepayments == null
                                                                                 : this$prepayments.equals(other$prepayments)) {
                                                                                 Object this$managementFeeRate = this.getManagementFeeRate();
                                                                                 Object other$managementFeeRate = other.getManagementFeeRate();
                                                                                 if (this$managementFeeRate == null
                                                                                    ? other$managementFeeRate == null
                                                                                    : this$managementFeeRate.equals(other$managementFeeRate)) {
                                                                                    Object this$marginAmount = this.getMarginAmount();
                                                                                    Object other$marginAmount = other.getMarginAmount();
                                                                                    if (this$marginAmount == null
                                                                                       ? other$marginAmount == null
                                                                                       : this$marginAmount.equals(other$marginAmount)) {
                                                                                       Object this$marginType = this.getMarginType();
                                                                                       Object other$marginType = other.getMarginType();
                                                                                       if (this$marginType == null
                                                                                          ? other$marginType == null
                                                                                          : this$marginType.equals(other$marginType)) {
                                                                                          Object this$currencyType = this.getCurrencyType();
                                                                                          Object other$currencyType = other.getCurrencyType();
                                                                                          if (this$currencyType == null
                                                                                             ? other$currencyType == null
                                                                                             : this$currencyType.equals(other$currencyType)) {
                                                                                             Object this$qualityGuaranteeDeposit = this.getQualityGuaranteeDeposit();
                                                                                             Object other$qualityGuaranteeDeposit = other.getQualityGuaranteeDeposit();
                                                                                             if (this$qualityGuaranteeDeposit == null
                                                                                                ? other$qualityGuaranteeDeposit == null
                                                                                                : this$qualityGuaranteeDeposit.equals(
                                                                                                   other$qualityGuaranteeDeposit
                                                                                                )) {
                                                                                                Object this$attachments = this.getAttachments();
                                                                                                Object other$attachments = other.getAttachments();
                                                                                                return this$attachments == null
                                                                                                   ? other$attachments == null
                                                                                                   : this$attachments.equals(other$attachments);
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
      return other instanceof ProjectBaseChangeDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderSourceType = this.getOrderSourceType();
      result = result * 59 + ($orderSourceType == null ? 43 : $orderSourceType.hashCode());
      Object $countryId = this.getCountryId();
      result = result * 59 + ($countryId == null ? 43 : $countryId.hashCode());
      Object $provinceId = this.getProvinceId();
      result = result * 59 + ($provinceId == null ? 43 : $provinceId.hashCode());
      Object $cityId = this.getCityId();
      result = result * 59 + ($cityId == null ? 43 : $cityId.hashCode());
      Object $regionId = this.getRegionId();
      result = result * 59 + ($regionId == null ? 43 : $regionId.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $signerId = this.getSignerId();
      result = result * 59 + ($signerId == null ? 43 : $signerId.hashCode());
      Object $businessLeaderId = this.getBusinessLeaderId();
      result = result * 59 + ($businessLeaderId == null ? 43 : $businessLeaderId.hashCode());
      Object $businessLeaderTwoId = this.getBusinessLeaderTwoId();
      result = result * 59 + ($businessLeaderTwoId == null ? 43 : $businessLeaderTwoId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $countryName = this.getCountryName();
      result = result * 59 + ($countryName == null ? 43 : $countryName.hashCode());
      Object $provinceName = this.getProvinceName();
      result = result * 59 + ($provinceName == null ? 43 : $provinceName.hashCode());
      Object $cityName = this.getCityName();
      result = result * 59 + ($cityName == null ? 43 : $cityName.hashCode());
      Object $regionName = this.getRegionName();
      result = result * 59 + ($regionName == null ? 43 : $regionName.hashCode());
      Object $address = this.getAddress();
      result = result * 59 + ($address == null ? 43 : $address.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      result = result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
      Object $projectManagerPhone = this.getProjectManagerPhone();
      result = result * 59 + ($projectManagerPhone == null ? 43 : $projectManagerPhone.hashCode());
      Object $signerName = this.getSignerName();
      result = result * 59 + ($signerName == null ? 43 : $signerName.hashCode());
      Object $signerPhone = this.getSignerPhone();
      result = result * 59 + ($signerPhone == null ? 43 : $signerPhone.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $prepayments = this.getPrepayments();
      result = result * 59 + ($prepayments == null ? 43 : $prepayments.hashCode());
      Object $managementFeeRate = this.getManagementFeeRate();
      result = result * 59 + ($managementFeeRate == null ? 43 : $managementFeeRate.hashCode());
      Object $marginAmount = this.getMarginAmount();
      result = result * 59 + ($marginAmount == null ? 43 : $marginAmount.hashCode());
      Object $marginType = this.getMarginType();
      result = result * 59 + ($marginType == null ? 43 : $marginType.hashCode());
      Object $currencyType = this.getCurrencyType();
      result = result * 59 + ($currencyType == null ? 43 : $currencyType.hashCode());
      Object $qualityGuaranteeDeposit = this.getQualityGuaranteeDeposit();
      result = result * 59 + ($qualityGuaranteeDeposit == null ? 43 : $qualityGuaranteeDeposit.hashCode());
      Object $attachments = this.getAttachments();
      return result * 59 + ($attachments == null ? 43 : $attachments.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectBaseChangeDTOParam(serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", orderSourceType="
         + this.getOrderSourceType()
         + ", countryId="
         + this.getCountryId()
         + ", countryName="
         + this.getCountryName()
         + ", provinceId="
         + this.getProvinceId()
         + ", provinceName="
         + this.getProvinceName()
         + ", cityId="
         + this.getCityId()
         + ", cityName="
         + this.getCityName()
         + ", regionId="
         + this.getRegionId()
         + ", regionName="
         + this.getRegionName()
         + ", address="
         + this.getAddress()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ", projectManagerPhone="
         + this.getProjectManagerPhone()
         + ", signerId="
         + this.getSignerId()
         + ", signerName="
         + this.getSignerName()
         + ", signerPhone="
         + this.getSignerPhone()
         + ", businessLeaderId="
         + this.getBusinessLeaderId()
         + ", businessLeaderTwoId="
         + this.getBusinessLeaderTwoId()
         + ", contractAmount="
         + this.getContractAmount()
         + ", prepayments="
         + this.getPrepayments()
         + ", managementFeeRate="
         + this.getManagementFeeRate()
         + ", marginAmount="
         + this.getMarginAmount()
         + ", marginType="
         + this.getMarginType()
         + ", currencyType="
         + this.getCurrencyType()
         + ", qualityGuaranteeDeposit="
         + this.getQualityGuaranteeDeposit()
         + ", attachments="
         + this.getAttachments()
         + ")";
   }
}
