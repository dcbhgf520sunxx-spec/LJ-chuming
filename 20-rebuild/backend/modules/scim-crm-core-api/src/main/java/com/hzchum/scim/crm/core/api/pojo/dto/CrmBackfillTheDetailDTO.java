package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class CrmBackfillTheDetailDTO {
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "departId", value = "所属部门id", notes = "所属部门id")
   private Long departId;
   @ApiModelProperty(name = "departName", value = "部门名称", notes = "部门名称")
   private String departName;
   @ApiModelProperty(name = "quantity", value = "工程量", notes = "工程量")
   private BigDecimal quantity;
   @ApiModelProperty(name = "structureStatus", value = "结构类型", notes = "结构类型")
   private Long structureStatus;
   @ApiModelProperty(name = "crmEnterpriseWarehousingName", value = "仓库名称", notes = "仓库名称")
   private String crmEnterpriseWarehousingName;
   @ApiModelProperty(name = "countryId", value = "国家id", notes = "国家id")
   private Long countryId;
   @ApiModelProperty(name = "provinceId", value = "省份id", notes = "省份id")
   private Long provinceId;
   @ApiModelProperty(name = "cityId", value = "城市id", notes = "城市id")
   private Long cityId;
   @ApiModelProperty(name = "regionId", value = "地区id", notes = "地区id")
   private Long regionId;
   @ApiModelProperty(name = "regionIdList", value = "国省市区ids", notes = "国省市区ids")
   private List<Long> regionIdList;
   @ApiModelProperty(name = "projectShortName", value = "项目简称", notes = "项目简称")
   private String projectShortName;
   @ApiModelProperty(name = "contractAmount", value = "合同金额", notes = "合同金额")
   private BigDecimal contractAmount;
   @ApiModelProperty(name = "taxRate", value = "税率", notes = "税率")
   private BigDecimal taxRate;
   @ApiModelProperty(name = "startDate", value = "开始时间", notes = "开始时间")
   private LocalDateTime startDate;
   @ApiModelProperty(name = "endDate", value = "结束时间", notes = "结束时间")
   private LocalDateTime endDate;
   @ApiModelProperty(name = "paymentMethod", value = "付款方式描述", notes = "付款方式描述")
   private String paymentMethod;
   @ApiModelProperty(name = "partyAPersonName", value = "收货负责人", notes = "收货负责人")
   private String partyAPersonName;
   @ApiModelProperty(name = "partyAPhone", value = "联系电话", notes = "联系电话")
   private String partyAPhone;

   public static CrmBackfillTheDetailDTO.CrmBackfillTheDetailDTOBuilder builder() {
      return new CrmBackfillTheDetailDTO.CrmBackfillTheDetailDTOBuilder();
   }

   public CrmBackfillTheDetailDTO() {
   }

   public CrmBackfillTheDetailDTO(
      final String projectName,
      final Long departId,
      final String departName,
      final BigDecimal quantity,
      final Long structureStatus,
      final String crmEnterpriseWarehousingName,
      final Long countryId,
      final Long provinceId,
      final Long cityId,
      final Long regionId,
      final List<Long> regionIdList,
      final String projectShortName,
      final BigDecimal contractAmount,
      final BigDecimal taxRate,
      final LocalDateTime startDate,
      final LocalDateTime endDate,
      final String paymentMethod,
      final String partyAPersonName,
      final String partyAPhone
   ) {
      this.projectName = projectName;
      this.departId = departId;
      this.departName = departName;
      this.quantity = quantity;
      this.structureStatus = structureStatus;
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      this.countryId = countryId;
      this.provinceId = provinceId;
      this.cityId = cityId;
      this.regionId = regionId;
      this.regionIdList = regionIdList;
      this.projectShortName = projectShortName;
      this.contractAmount = contractAmount;
      this.taxRate = taxRate;
      this.startDate = startDate;
      this.endDate = endDate;
      this.paymentMethod = paymentMethod;
      this.partyAPersonName = partyAPersonName;
      this.partyAPhone = partyAPhone;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Long getDepartId() {
      return this.departId;
   }

   public String getDepartName() {
      return this.departName;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public Long getStructureStatus() {
      return this.structureStatus;
   }

   public String getCrmEnterpriseWarehousingName() {
      return this.crmEnterpriseWarehousingName;
   }

   public Long getCountryId() {
      return this.countryId;
   }

   public Long getProvinceId() {
      return this.provinceId;
   }

   public Long getCityId() {
      return this.cityId;
   }

   public Long getRegionId() {
      return this.regionId;
   }

   public List<Long> getRegionIdList() {
      return this.regionIdList;
   }

   public String getProjectShortName() {
      return this.projectShortName;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public LocalDateTime getStartDate() {
      return this.startDate;
   }

   public LocalDateTime getEndDate() {
      return this.endDate;
   }

   public String getPaymentMethod() {
      return this.paymentMethod;
   }

   public String getPartyAPersonName() {
      return this.partyAPersonName;
   }

   public String getPartyAPhone() {
      return this.partyAPhone;
   }

   public CrmBackfillTheDetailDTO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public CrmBackfillTheDetailDTO setDepartId(final Long departId) {
      this.departId = departId;
      return this;
   }

   public CrmBackfillTheDetailDTO setDepartName(final String departName) {
      this.departName = departName;
      return this;
   }

   public CrmBackfillTheDetailDTO setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   public CrmBackfillTheDetailDTO setStructureStatus(final Long structureStatus) {
      this.structureStatus = structureStatus;
      return this;
   }

   public CrmBackfillTheDetailDTO setCrmEnterpriseWarehousingName(final String crmEnterpriseWarehousingName) {
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      return this;
   }

   public CrmBackfillTheDetailDTO setCountryId(final Long countryId) {
      this.countryId = countryId;
      return this;
   }

   public CrmBackfillTheDetailDTO setProvinceId(final Long provinceId) {
      this.provinceId = provinceId;
      return this;
   }

   public CrmBackfillTheDetailDTO setCityId(final Long cityId) {
      this.cityId = cityId;
      return this;
   }

   public CrmBackfillTheDetailDTO setRegionId(final Long regionId) {
      this.regionId = regionId;
      return this;
   }

   public CrmBackfillTheDetailDTO setRegionIdList(final List<Long> regionIdList) {
      this.regionIdList = regionIdList;
      return this;
   }

   public CrmBackfillTheDetailDTO setProjectShortName(final String projectShortName) {
      this.projectShortName = projectShortName;
      return this;
   }

   public CrmBackfillTheDetailDTO setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
      return this;
   }

   public CrmBackfillTheDetailDTO setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
      return this;
   }

   public CrmBackfillTheDetailDTO setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
      return this;
   }

   public CrmBackfillTheDetailDTO setEndDate(final LocalDateTime endDate) {
      this.endDate = endDate;
      return this;
   }

   public CrmBackfillTheDetailDTO setPaymentMethod(final String paymentMethod) {
      this.paymentMethod = paymentMethod;
      return this;
   }

   public CrmBackfillTheDetailDTO setPartyAPersonName(final String partyAPersonName) {
      this.partyAPersonName = partyAPersonName;
      return this;
   }

   public CrmBackfillTheDetailDTO setPartyAPhone(final String partyAPhone) {
      this.partyAPhone = partyAPhone;
      return this;
   }

   @Override
   public String toString() {
      return "CrmBackfillTheDetailDTO(projectName="
         + this.getProjectName()
         + ", departId="
         + this.getDepartId()
         + ", departName="
         + this.getDepartName()
         + ", quantity="
         + this.getQuantity()
         + ", structureStatus="
         + this.getStructureStatus()
         + ", crmEnterpriseWarehousingName="
         + this.getCrmEnterpriseWarehousingName()
         + ", countryId="
         + this.getCountryId()
         + ", provinceId="
         + this.getProvinceId()
         + ", cityId="
         + this.getCityId()
         + ", regionId="
         + this.getRegionId()
         + ", regionIdList="
         + this.getRegionIdList()
         + ", projectShortName="
         + this.getProjectShortName()
         + ", contractAmount="
         + this.getContractAmount()
         + ", taxRate="
         + this.getTaxRate()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", paymentMethod="
         + this.getPaymentMethod()
         + ", partyAPersonName="
         + this.getPartyAPersonName()
         + ", partyAPhone="
         + this.getPartyAPhone()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmBackfillTheDetailDTO)) {
         return false;
      }

      CrmBackfillTheDetailDTO other = (CrmBackfillTheDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$departId = this.getDepartId();
      Object other$departId = other.getDepartId();
      if (this$departId == null ? other$departId == null : this$departId.equals(other$departId)) {
         Object this$structureStatus = this.getStructureStatus();
         Object other$structureStatus = other.getStructureStatus();
         if (this$structureStatus == null ? other$structureStatus == null : this$structureStatus.equals(other$structureStatus)) {
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
                        Object this$projectName = this.getProjectName();
                        Object other$projectName = other.getProjectName();
                        if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                           Object this$departName = this.getDepartName();
                           Object other$departName = other.getDepartName();
                           if (this$departName == null ? other$departName == null : this$departName.equals(other$departName)) {
                              Object this$quantity = this.getQuantity();
                              Object other$quantity = other.getQuantity();
                              if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                 Object this$crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
                                 Object other$crmEnterpriseWarehousingName = other.getCrmEnterpriseWarehousingName();
                                 if (this$crmEnterpriseWarehousingName == null
                                    ? other$crmEnterpriseWarehousingName == null
                                    : this$crmEnterpriseWarehousingName.equals(other$crmEnterpriseWarehousingName)) {
                                    Object this$regionIdList = this.getRegionIdList();
                                    Object other$regionIdList = other.getRegionIdList();
                                    if (this$regionIdList == null ? other$regionIdList == null : this$regionIdList.equals(other$regionIdList)) {
                                       Object this$projectShortName = this.getProjectShortName();
                                       Object other$projectShortName = other.getProjectShortName();
                                       if (this$projectShortName == null
                                          ? other$projectShortName == null
                                          : this$projectShortName.equals(other$projectShortName)) {
                                          Object this$contractAmount = this.getContractAmount();
                                          Object other$contractAmount = other.getContractAmount();
                                          if (this$contractAmount == null ? other$contractAmount == null : this$contractAmount.equals(other$contractAmount)) {
                                             Object this$taxRate = this.getTaxRate();
                                             Object other$taxRate = other.getTaxRate();
                                             if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                                Object this$startDate = this.getStartDate();
                                                Object other$startDate = other.getStartDate();
                                                if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                                                   Object this$endDate = this.getEndDate();
                                                   Object other$endDate = other.getEndDate();
                                                   if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                                                      Object this$paymentMethod = this.getPaymentMethod();
                                                      Object other$paymentMethod = other.getPaymentMethod();
                                                      if (this$paymentMethod == null
                                                         ? other$paymentMethod == null
                                                         : this$paymentMethod.equals(other$paymentMethod)) {
                                                         Object this$partyAPersonName = this.getPartyAPersonName();
                                                         Object other$partyAPersonName = other.getPartyAPersonName();
                                                         if (this$partyAPersonName == null
                                                            ? other$partyAPersonName == null
                                                            : this$partyAPersonName.equals(other$partyAPersonName)) {
                                                            Object this$partyAPhone = this.getPartyAPhone();
                                                            Object other$partyAPhone = other.getPartyAPhone();
                                                            return this$partyAPhone == null
                                                               ? other$partyAPhone == null
                                                               : this$partyAPhone.equals(other$partyAPhone);
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
      return other instanceof CrmBackfillTheDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $departId = this.getDepartId();
      result = result * 59 + ($departId == null ? 43 : $departId.hashCode());
      Object $structureStatus = this.getStructureStatus();
      result = result * 59 + ($structureStatus == null ? 43 : $structureStatus.hashCode());
      Object $countryId = this.getCountryId();
      result = result * 59 + ($countryId == null ? 43 : $countryId.hashCode());
      Object $provinceId = this.getProvinceId();
      result = result * 59 + ($provinceId == null ? 43 : $provinceId.hashCode());
      Object $cityId = this.getCityId();
      result = result * 59 + ($cityId == null ? 43 : $cityId.hashCode());
      Object $regionId = this.getRegionId();
      result = result * 59 + ($regionId == null ? 43 : $regionId.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $departName = this.getDepartName();
      result = result * 59 + ($departName == null ? 43 : $departName.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
      result = result * 59 + ($crmEnterpriseWarehousingName == null ? 43 : $crmEnterpriseWarehousingName.hashCode());
      Object $regionIdList = this.getRegionIdList();
      result = result * 59 + ($regionIdList == null ? 43 : $regionIdList.hashCode());
      Object $projectShortName = this.getProjectShortName();
      result = result * 59 + ($projectShortName == null ? 43 : $projectShortName.hashCode());
      Object $contractAmount = this.getContractAmount();
      result = result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $paymentMethod = this.getPaymentMethod();
      result = result * 59 + ($paymentMethod == null ? 43 : $paymentMethod.hashCode());
      Object $partyAPersonName = this.getPartyAPersonName();
      result = result * 59 + ($partyAPersonName == null ? 43 : $partyAPersonName.hashCode());
      Object $partyAPhone = this.getPartyAPhone();
      return result * 59 + ($partyAPhone == null ? 43 : $partyAPhone.hashCode());
   }

   public static class CrmBackfillTheDetailDTOBuilder {
      private String projectName;
      private Long departId;
      private String departName;
      private BigDecimal quantity;
      private Long structureStatus;
      private String crmEnterpriseWarehousingName;
      private Long countryId;
      private Long provinceId;
      private Long cityId;
      private Long regionId;
      private List<Long> regionIdList;
      private String projectShortName;
      private BigDecimal contractAmount;
      private BigDecimal taxRate;
      private LocalDateTime startDate;
      private LocalDateTime endDate;
      private String paymentMethod;
      private String partyAPersonName;
      private String partyAPhone;

      CrmBackfillTheDetailDTOBuilder() {
      }

      public CrmBackfillTheDetailDTO.CrmBackfillTheDetailDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public CrmBackfillTheDetailDTO.CrmBackfillTheDetailDTOBuilder departId(final Long departId) {
         this.departId = departId;
         return this;
      }

      public CrmBackfillTheDetailDTO.CrmBackfillTheDetailDTOBuilder departName(final String departName) {
         this.departName = departName;
         return this;
      }

      public CrmBackfillTheDetailDTO.CrmBackfillTheDetailDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public CrmBackfillTheDetailDTO.CrmBackfillTheDetailDTOBuilder structureStatus(final Long structureStatus) {
         this.structureStatus = structureStatus;
         return this;
      }

      public CrmBackfillTheDetailDTO.CrmBackfillTheDetailDTOBuilder crmEnterpriseWarehousingName(final String crmEnterpriseWarehousingName) {
         this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
         return this;
      }

      public CrmBackfillTheDetailDTO.CrmBackfillTheDetailDTOBuilder countryId(final Long countryId) {
         this.countryId = countryId;
         return this;
      }

      public CrmBackfillTheDetailDTO.CrmBackfillTheDetailDTOBuilder provinceId(final Long provinceId) {
         this.provinceId = provinceId;
         return this;
      }

      public CrmBackfillTheDetailDTO.CrmBackfillTheDetailDTOBuilder cityId(final Long cityId) {
         this.cityId = cityId;
         return this;
      }

      public CrmBackfillTheDetailDTO.CrmBackfillTheDetailDTOBuilder regionId(final Long regionId) {
         this.regionId = regionId;
         return this;
      }

      public CrmBackfillTheDetailDTO.CrmBackfillTheDetailDTOBuilder regionIdList(final List<Long> regionIdList) {
         this.regionIdList = regionIdList;
         return this;
      }

      public CrmBackfillTheDetailDTO.CrmBackfillTheDetailDTOBuilder projectShortName(final String projectShortName) {
         this.projectShortName = projectShortName;
         return this;
      }

      public CrmBackfillTheDetailDTO.CrmBackfillTheDetailDTOBuilder contractAmount(final BigDecimal contractAmount) {
         this.contractAmount = contractAmount;
         return this;
      }

      public CrmBackfillTheDetailDTO.CrmBackfillTheDetailDTOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public CrmBackfillTheDetailDTO.CrmBackfillTheDetailDTOBuilder startDate(final LocalDateTime startDate) {
         this.startDate = startDate;
         return this;
      }

      public CrmBackfillTheDetailDTO.CrmBackfillTheDetailDTOBuilder endDate(final LocalDateTime endDate) {
         this.endDate = endDate;
         return this;
      }

      public CrmBackfillTheDetailDTO.CrmBackfillTheDetailDTOBuilder paymentMethod(final String paymentMethod) {
         this.paymentMethod = paymentMethod;
         return this;
      }

      public CrmBackfillTheDetailDTO.CrmBackfillTheDetailDTOBuilder partyAPersonName(final String partyAPersonName) {
         this.partyAPersonName = partyAPersonName;
         return this;
      }

      public CrmBackfillTheDetailDTO.CrmBackfillTheDetailDTOBuilder partyAPhone(final String partyAPhone) {
         this.partyAPhone = partyAPhone;
         return this;
      }

      public CrmBackfillTheDetailDTO build() {
         return new CrmBackfillTheDetailDTO(
            this.projectName,
            this.departId,
            this.departName,
            this.quantity,
            this.structureStatus,
            this.crmEnterpriseWarehousingName,
            this.countryId,
            this.provinceId,
            this.cityId,
            this.regionId,
            this.regionIdList,
            this.projectShortName,
            this.contractAmount,
            this.taxRate,
            this.startDate,
            this.endDate,
            this.paymentMethod,
            this.partyAPersonName,
            this.partyAPhone
         );
      }

      @Override
      public String toString() {
         return "CrmBackfillTheDetailDTO.CrmBackfillTheDetailDTOBuilder(projectName="
            + this.projectName
            + ", departId="
            + this.departId
            + ", departName="
            + this.departName
            + ", quantity="
            + this.quantity
            + ", structureStatus="
            + this.structureStatus
            + ", crmEnterpriseWarehousingName="
            + this.crmEnterpriseWarehousingName
            + ", countryId="
            + this.countryId
            + ", provinceId="
            + this.provinceId
            + ", cityId="
            + this.cityId
            + ", regionId="
            + this.regionId
            + ", regionIdList="
            + this.regionIdList
            + ", projectShortName="
            + this.projectShortName
            + ", contractAmount="
            + this.contractAmount
            + ", taxRate="
            + this.taxRate
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", paymentMethod="
            + this.paymentMethod
            + ", partyAPersonName="
            + this.partyAPersonName
            + ", partyAPhone="
            + this.partyAPhone
            + ")";
      }
   }
}
