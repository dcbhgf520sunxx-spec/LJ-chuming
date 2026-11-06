package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

public class CrmEnterpriseWarehousingPageDownLoadDTO {
   @ApiModelProperty(name = "id", value = "主键", notes = "主键")
   private Long id;
   @ApiModelProperty(name = "informantDateTime", value = "填报日期", notes = "填报日期")
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "businessName", value = "企业名称", notes = "企业名称")
   private String businessName;
   @ApiModelProperty(name = "creditCode", value = "社会统一信用代码", notes = "社会统一信用代码")
   private String creditCode;
   @ApiModelProperty(name = "countryName", value = "国家名称", notes = "国家名称")
   private String countryName;
   @ApiModelProperty(name = "provinceNameAndCityName", value = "省市名称", notes = "省市名称")
   private String provinceNameAndCityName;
   @ApiModelProperty(name = "unitPropertyAllocationConfigName", value = "单位类别id  参考crm_basics_config", notes = "单位类别id  参考crm_basics_config")
   private String unitPropertyAllocationConfigName;
   @ApiModelProperty(name = "unitClassConfigurationName", value = "单位性质id  参考crm_basics_config", notes = "单位性质id  参考crm_basics_config")
   private String unitClassConfigurationName;
   @ApiModelProperty(name = "industryConfigurationName", value = "单位所属行业id  参考 crm_basice_config", notes = "单位所属行业id  参考 crm_basice_config")
   private String industryConfigurationName;
   @ApiModelProperty(name = "unitReputationAllocationConfigName", value = "企业信誉  参考 crm_basice_config", notes = "企业信誉  参考 crm_basice_config")
   private String unitReputationAllocationConfigName;
   @ApiModelProperty(name = "informantUserName", value = "填报人", notes = "填报人")
   private String informantUserName;
   @ApiModelProperty(name = "crmCheckStatusEnumName", value = "审核状态 参考枚举 CrmCheckStatusEnum", notes = "审核状态 参考枚举 CrmCheckStatusEnum")
   private String crmCheckStatusEnumName;
   @ApiModelProperty(name = "crmProjectInformationWarehousingName", notes = "项目备案名称")
   private String crmProjectInformationWarehousingName;
   @ApiModelProperty(name = "createUserName", value = "创建人名称", notes = "创建人名称")
   private String createUserName;

   public static CrmEnterpriseWarehousingPageDownLoadDTO.CrmEnterpriseWarehousingPageDownLoadDTOBuilder builder() {
      return new CrmEnterpriseWarehousingPageDownLoadDTO.CrmEnterpriseWarehousingPageDownLoadDTOBuilder();
   }

   public CrmEnterpriseWarehousingPageDownLoadDTO() {
   }

   public CrmEnterpriseWarehousingPageDownLoadDTO(
      final Long id,
      final LocalDateTime informantDateTime,
      final String businessName,
      final String creditCode,
      final String countryName,
      final String provinceNameAndCityName,
      final String unitPropertyAllocationConfigName,
      final String unitClassConfigurationName,
      final String industryConfigurationName,
      final String unitReputationAllocationConfigName,
      final String informantUserName,
      final String crmCheckStatusEnumName,
      final String crmProjectInformationWarehousingName,
      final String createUserName
   ) {
      this.id = id;
      this.informantDateTime = informantDateTime;
      this.businessName = businessName;
      this.creditCode = creditCode;
      this.countryName = countryName;
      this.provinceNameAndCityName = provinceNameAndCityName;
      this.unitPropertyAllocationConfigName = unitPropertyAllocationConfigName;
      this.unitClassConfigurationName = unitClassConfigurationName;
      this.industryConfigurationName = industryConfigurationName;
      this.unitReputationAllocationConfigName = unitReputationAllocationConfigName;
      this.informantUserName = informantUserName;
      this.crmCheckStatusEnumName = crmCheckStatusEnumName;
      this.crmProjectInformationWarehousingName = crmProjectInformationWarehousingName;
      this.createUserName = createUserName;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
   }

   public String getBusinessName() {
      return this.businessName;
   }

   public String getCreditCode() {
      return this.creditCode;
   }

   public String getCountryName() {
      return this.countryName;
   }

   public String getProvinceNameAndCityName() {
      return this.provinceNameAndCityName;
   }

   public String getUnitPropertyAllocationConfigName() {
      return this.unitPropertyAllocationConfigName;
   }

   public String getUnitClassConfigurationName() {
      return this.unitClassConfigurationName;
   }

   public String getIndustryConfigurationName() {
      return this.industryConfigurationName;
   }

   public String getUnitReputationAllocationConfigName() {
      return this.unitReputationAllocationConfigName;
   }

   public String getInformantUserName() {
      return this.informantUserName;
   }

   public String getCrmCheckStatusEnumName() {
      return this.crmCheckStatusEnumName;
   }

   public String getCrmProjectInformationWarehousingName() {
      return this.crmProjectInformationWarehousingName;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public CrmEnterpriseWarehousingPageDownLoadDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmEnterpriseWarehousingPageDownLoadDTO setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
      return this;
   }

   public CrmEnterpriseWarehousingPageDownLoadDTO setBusinessName(final String businessName) {
      this.businessName = businessName;
      return this;
   }

   public CrmEnterpriseWarehousingPageDownLoadDTO setCreditCode(final String creditCode) {
      this.creditCode = creditCode;
      return this;
   }

   public CrmEnterpriseWarehousingPageDownLoadDTO setCountryName(final String countryName) {
      this.countryName = countryName;
      return this;
   }

   public CrmEnterpriseWarehousingPageDownLoadDTO setProvinceNameAndCityName(final String provinceNameAndCityName) {
      this.provinceNameAndCityName = provinceNameAndCityName;
      return this;
   }

   public CrmEnterpriseWarehousingPageDownLoadDTO setUnitPropertyAllocationConfigName(final String unitPropertyAllocationConfigName) {
      this.unitPropertyAllocationConfigName = unitPropertyAllocationConfigName;
      return this;
   }

   public CrmEnterpriseWarehousingPageDownLoadDTO setUnitClassConfigurationName(final String unitClassConfigurationName) {
      this.unitClassConfigurationName = unitClassConfigurationName;
      return this;
   }

   public CrmEnterpriseWarehousingPageDownLoadDTO setIndustryConfigurationName(final String industryConfigurationName) {
      this.industryConfigurationName = industryConfigurationName;
      return this;
   }

   public CrmEnterpriseWarehousingPageDownLoadDTO setUnitReputationAllocationConfigName(final String unitReputationAllocationConfigName) {
      this.unitReputationAllocationConfigName = unitReputationAllocationConfigName;
      return this;
   }

   public CrmEnterpriseWarehousingPageDownLoadDTO setInformantUserName(final String informantUserName) {
      this.informantUserName = informantUserName;
      return this;
   }

   public CrmEnterpriseWarehousingPageDownLoadDTO setCrmCheckStatusEnumName(final String crmCheckStatusEnumName) {
      this.crmCheckStatusEnumName = crmCheckStatusEnumName;
      return this;
   }

   public CrmEnterpriseWarehousingPageDownLoadDTO setCrmProjectInformationWarehousingName(final String crmProjectInformationWarehousingName) {
      this.crmProjectInformationWarehousingName = crmProjectInformationWarehousingName;
      return this;
   }

   public CrmEnterpriseWarehousingPageDownLoadDTO setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   @Override
   public String toString() {
      return "CrmEnterpriseWarehousingPageDownLoadDTO(id="
         + this.getId()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ", businessName="
         + this.getBusinessName()
         + ", creditCode="
         + this.getCreditCode()
         + ", countryName="
         + this.getCountryName()
         + ", provinceNameAndCityName="
         + this.getProvinceNameAndCityName()
         + ", unitPropertyAllocationConfigName="
         + this.getUnitPropertyAllocationConfigName()
         + ", unitClassConfigurationName="
         + this.getUnitClassConfigurationName()
         + ", industryConfigurationName="
         + this.getIndustryConfigurationName()
         + ", unitReputationAllocationConfigName="
         + this.getUnitReputationAllocationConfigName()
         + ", informantUserName="
         + this.getInformantUserName()
         + ", crmCheckStatusEnumName="
         + this.getCrmCheckStatusEnumName()
         + ", crmProjectInformationWarehousingName="
         + this.getCrmProjectInformationWarehousingName()
         + ", createUserName="
         + this.getCreateUserName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmEnterpriseWarehousingPageDownLoadDTO)) {
         return false;
      }

      CrmEnterpriseWarehousingPageDownLoadDTO other = (CrmEnterpriseWarehousingPageDownLoadDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$informantDateTime = this.getInformantDateTime();
         Object other$informantDateTime = other.getInformantDateTime();
         if (this$informantDateTime == null ? other$informantDateTime == null : this$informantDateTime.equals(other$informantDateTime)) {
            Object this$businessName = this.getBusinessName();
            Object other$businessName = other.getBusinessName();
            if (this$businessName == null ? other$businessName == null : this$businessName.equals(other$businessName)) {
               Object this$creditCode = this.getCreditCode();
               Object other$creditCode = other.getCreditCode();
               if (this$creditCode == null ? other$creditCode == null : this$creditCode.equals(other$creditCode)) {
                  Object this$countryName = this.getCountryName();
                  Object other$countryName = other.getCountryName();
                  if (this$countryName == null ? other$countryName == null : this$countryName.equals(other$countryName)) {
                     Object this$provinceNameAndCityName = this.getProvinceNameAndCityName();
                     Object other$provinceNameAndCityName = other.getProvinceNameAndCityName();
                     if (this$provinceNameAndCityName == null
                        ? other$provinceNameAndCityName == null
                        : this$provinceNameAndCityName.equals(other$provinceNameAndCityName)) {
                        Object this$unitPropertyAllocationConfigName = this.getUnitPropertyAllocationConfigName();
                        Object other$unitPropertyAllocationConfigName = other.getUnitPropertyAllocationConfigName();
                        if (this$unitPropertyAllocationConfigName == null
                           ? other$unitPropertyAllocationConfigName == null
                           : this$unitPropertyAllocationConfigName.equals(other$unitPropertyAllocationConfigName)) {
                           Object this$unitClassConfigurationName = this.getUnitClassConfigurationName();
                           Object other$unitClassConfigurationName = other.getUnitClassConfigurationName();
                           if (this$unitClassConfigurationName == null
                              ? other$unitClassConfigurationName == null
                              : this$unitClassConfigurationName.equals(other$unitClassConfigurationName)) {
                              Object this$industryConfigurationName = this.getIndustryConfigurationName();
                              Object other$industryConfigurationName = other.getIndustryConfigurationName();
                              if (this$industryConfigurationName == null
                                 ? other$industryConfigurationName == null
                                 : this$industryConfigurationName.equals(other$industryConfigurationName)) {
                                 Object this$unitReputationAllocationConfigName = this.getUnitReputationAllocationConfigName();
                                 Object other$unitReputationAllocationConfigName = other.getUnitReputationAllocationConfigName();
                                 if (this$unitReputationAllocationConfigName == null
                                    ? other$unitReputationAllocationConfigName == null
                                    : this$unitReputationAllocationConfigName.equals(other$unitReputationAllocationConfigName)) {
                                    Object this$informantUserName = this.getInformantUserName();
                                    Object other$informantUserName = other.getInformantUserName();
                                    if (this$informantUserName == null
                                       ? other$informantUserName == null
                                       : this$informantUserName.equals(other$informantUserName)) {
                                       Object this$crmCheckStatusEnumName = this.getCrmCheckStatusEnumName();
                                       Object other$crmCheckStatusEnumName = other.getCrmCheckStatusEnumName();
                                       if (this$crmCheckStatusEnumName == null
                                          ? other$crmCheckStatusEnumName == null
                                          : this$crmCheckStatusEnumName.equals(other$crmCheckStatusEnumName)) {
                                          Object this$crmProjectInformationWarehousingName = this.getCrmProjectInformationWarehousingName();
                                          Object other$crmProjectInformationWarehousingName = other.getCrmProjectInformationWarehousingName();
                                          if (this$crmProjectInformationWarehousingName == null
                                             ? other$crmProjectInformationWarehousingName == null
                                             : this$crmProjectInformationWarehousingName.equals(other$crmProjectInformationWarehousingName)) {
                                             Object this$createUserName = this.getCreateUserName();
                                             Object other$createUserName = other.getCreateUserName();
                                             return this$createUserName == null
                                                ? other$createUserName == null
                                                : this$createUserName.equals(other$createUserName);
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
      return other instanceof CrmEnterpriseWarehousingPageDownLoadDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
      Object $businessName = this.getBusinessName();
      result = result * 59 + ($businessName == null ? 43 : $businessName.hashCode());
      Object $creditCode = this.getCreditCode();
      result = result * 59 + ($creditCode == null ? 43 : $creditCode.hashCode());
      Object $countryName = this.getCountryName();
      result = result * 59 + ($countryName == null ? 43 : $countryName.hashCode());
      Object $provinceNameAndCityName = this.getProvinceNameAndCityName();
      result = result * 59 + ($provinceNameAndCityName == null ? 43 : $provinceNameAndCityName.hashCode());
      Object $unitPropertyAllocationConfigName = this.getUnitPropertyAllocationConfigName();
      result = result * 59 + ($unitPropertyAllocationConfigName == null ? 43 : $unitPropertyAllocationConfigName.hashCode());
      Object $unitClassConfigurationName = this.getUnitClassConfigurationName();
      result = result * 59 + ($unitClassConfigurationName == null ? 43 : $unitClassConfigurationName.hashCode());
      Object $industryConfigurationName = this.getIndustryConfigurationName();
      result = result * 59 + ($industryConfigurationName == null ? 43 : $industryConfigurationName.hashCode());
      Object $unitReputationAllocationConfigName = this.getUnitReputationAllocationConfigName();
      result = result * 59 + ($unitReputationAllocationConfigName == null ? 43 : $unitReputationAllocationConfigName.hashCode());
      Object $informantUserName = this.getInformantUserName();
      result = result * 59 + ($informantUserName == null ? 43 : $informantUserName.hashCode());
      Object $crmCheckStatusEnumName = this.getCrmCheckStatusEnumName();
      result = result * 59 + ($crmCheckStatusEnumName == null ? 43 : $crmCheckStatusEnumName.hashCode());
      Object $crmProjectInformationWarehousingName = this.getCrmProjectInformationWarehousingName();
      result = result * 59 + ($crmProjectInformationWarehousingName == null ? 43 : $crmProjectInformationWarehousingName.hashCode());
      Object $createUserName = this.getCreateUserName();
      return result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
   }

   public static class CrmEnterpriseWarehousingPageDownLoadDTOBuilder {
      private Long id;
      private LocalDateTime informantDateTime;
      private String businessName;
      private String creditCode;
      private String countryName;
      private String provinceNameAndCityName;
      private String unitPropertyAllocationConfigName;
      private String unitClassConfigurationName;
      private String industryConfigurationName;
      private String unitReputationAllocationConfigName;
      private String informantUserName;
      private String crmCheckStatusEnumName;
      private String crmProjectInformationWarehousingName;
      private String createUserName;

      CrmEnterpriseWarehousingPageDownLoadDTOBuilder() {
      }

      public CrmEnterpriseWarehousingPageDownLoadDTO.CrmEnterpriseWarehousingPageDownLoadDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmEnterpriseWarehousingPageDownLoadDTO.CrmEnterpriseWarehousingPageDownLoadDTOBuilder informantDateTime(final LocalDateTime informantDateTime) {
         this.informantDateTime = informantDateTime;
         return this;
      }

      public CrmEnterpriseWarehousingPageDownLoadDTO.CrmEnterpriseWarehousingPageDownLoadDTOBuilder businessName(final String businessName) {
         this.businessName = businessName;
         return this;
      }

      public CrmEnterpriseWarehousingPageDownLoadDTO.CrmEnterpriseWarehousingPageDownLoadDTOBuilder creditCode(final String creditCode) {
         this.creditCode = creditCode;
         return this;
      }

      public CrmEnterpriseWarehousingPageDownLoadDTO.CrmEnterpriseWarehousingPageDownLoadDTOBuilder countryName(final String countryName) {
         this.countryName = countryName;
         return this;
      }

      public CrmEnterpriseWarehousingPageDownLoadDTO.CrmEnterpriseWarehousingPageDownLoadDTOBuilder provinceNameAndCityName(
         final String provinceNameAndCityName
      ) {
         this.provinceNameAndCityName = provinceNameAndCityName;
         return this;
      }

      public CrmEnterpriseWarehousingPageDownLoadDTO.CrmEnterpriseWarehousingPageDownLoadDTOBuilder unitPropertyAllocationConfigName(
         final String unitPropertyAllocationConfigName
      ) {
         this.unitPropertyAllocationConfigName = unitPropertyAllocationConfigName;
         return this;
      }

      public CrmEnterpriseWarehousingPageDownLoadDTO.CrmEnterpriseWarehousingPageDownLoadDTOBuilder unitClassConfigurationName(
         final String unitClassConfigurationName
      ) {
         this.unitClassConfigurationName = unitClassConfigurationName;
         return this;
      }

      public CrmEnterpriseWarehousingPageDownLoadDTO.CrmEnterpriseWarehousingPageDownLoadDTOBuilder industryConfigurationName(
         final String industryConfigurationName
      ) {
         this.industryConfigurationName = industryConfigurationName;
         return this;
      }

      public CrmEnterpriseWarehousingPageDownLoadDTO.CrmEnterpriseWarehousingPageDownLoadDTOBuilder unitReputationAllocationConfigName(
         final String unitReputationAllocationConfigName
      ) {
         this.unitReputationAllocationConfigName = unitReputationAllocationConfigName;
         return this;
      }

      public CrmEnterpriseWarehousingPageDownLoadDTO.CrmEnterpriseWarehousingPageDownLoadDTOBuilder informantUserName(final String informantUserName) {
         this.informantUserName = informantUserName;
         return this;
      }

      public CrmEnterpriseWarehousingPageDownLoadDTO.CrmEnterpriseWarehousingPageDownLoadDTOBuilder crmCheckStatusEnumName(final String crmCheckStatusEnumName) {
         this.crmCheckStatusEnumName = crmCheckStatusEnumName;
         return this;
      }

      public CrmEnterpriseWarehousingPageDownLoadDTO.CrmEnterpriseWarehousingPageDownLoadDTOBuilder crmProjectInformationWarehousingName(
         final String crmProjectInformationWarehousingName
      ) {
         this.crmProjectInformationWarehousingName = crmProjectInformationWarehousingName;
         return this;
      }

      public CrmEnterpriseWarehousingPageDownLoadDTO.CrmEnterpriseWarehousingPageDownLoadDTOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public CrmEnterpriseWarehousingPageDownLoadDTO build() {
         return new CrmEnterpriseWarehousingPageDownLoadDTO(
            this.id,
            this.informantDateTime,
            this.businessName,
            this.creditCode,
            this.countryName,
            this.provinceNameAndCityName,
            this.unitPropertyAllocationConfigName,
            this.unitClassConfigurationName,
            this.industryConfigurationName,
            this.unitReputationAllocationConfigName,
            this.informantUserName,
            this.crmCheckStatusEnumName,
            this.crmProjectInformationWarehousingName,
            this.createUserName
         );
      }

      @Override
      public String toString() {
         return "CrmEnterpriseWarehousingPageDownLoadDTO.CrmEnterpriseWarehousingPageDownLoadDTOBuilder(id="
            + this.id
            + ", informantDateTime="
            + this.informantDateTime
            + ", businessName="
            + this.businessName
            + ", creditCode="
            + this.creditCode
            + ", countryName="
            + this.countryName
            + ", provinceNameAndCityName="
            + this.provinceNameAndCityName
            + ", unitPropertyAllocationConfigName="
            + this.unitPropertyAllocationConfigName
            + ", unitClassConfigurationName="
            + this.unitClassConfigurationName
            + ", industryConfigurationName="
            + this.industryConfigurationName
            + ", unitReputationAllocationConfigName="
            + this.unitReputationAllocationConfigName
            + ", informantUserName="
            + this.informantUserName
            + ", crmCheckStatusEnumName="
            + this.crmCheckStatusEnumName
            + ", crmProjectInformationWarehousingName="
            + this.crmProjectInformationWarehousingName
            + ", createUserName="
            + this.createUserName
            + ")";
      }
   }
}
