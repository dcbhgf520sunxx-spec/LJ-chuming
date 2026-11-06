package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

public class CrmEnterpriseWarehousingPageDTO {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "informantDateTime", value = "填报日期", notes = "填报日期")
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "businessName", value = "企业名称", notes = "企业名称")
   private String businessName;
   @ApiModelProperty(name = "creditCode", value = "社会统一信用代码", notes = "社会统一信用代码")
   private String creditCode;
   @ApiModelProperty(name = "countryName", value = "国家名称", notes = "国家名称")
   private String countryName;
   @ApiModelProperty(name = "provinceName", value = "省份名称", notes = "省份名称")
   private String provinceName;
   @ApiModelProperty(name = "cityName", value = "城市名称", notes = "城市名称")
   private String cityName;
   @ApiModelProperty(name = "regionName", value = "地区名称", notes = "地区名称")
   private String regionName;
   @ApiModelProperty(name = "regionNameList", value = "国省市区名称", notes = "国省市区名称")
   private String regionNameList;
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
   @ApiModelProperty(name = "createUserName", value = "创建人", notes = "创建人")
   private String createUserName;
   @ApiModelProperty(name = "crmCheckStatusEnum", value = "审核状态 参考枚举 CrmCheckStatusEnum", notes = "审核状态 参考枚举 CrmCheckStatusEnum")
   private Integer crmCheckStatusEnum;

   public static CrmEnterpriseWarehousingPageDTO.CrmEnterpriseWarehousingPageDTOBuilder builder() {
      return new CrmEnterpriseWarehousingPageDTO.CrmEnterpriseWarehousingPageDTOBuilder();
   }

   public CrmEnterpriseWarehousingPageDTO() {
   }

   public CrmEnterpriseWarehousingPageDTO(
      final Long id,
      final LocalDateTime informantDateTime,
      final String businessName,
      final String creditCode,
      final String countryName,
      final String provinceName,
      final String cityName,
      final String regionName,
      final String regionNameList,
      final String unitPropertyAllocationConfigName,
      final String unitClassConfigurationName,
      final String industryConfigurationName,
      final String unitReputationAllocationConfigName,
      final String informantUserName,
      final String createUserName,
      final Integer crmCheckStatusEnum
   ) {
      this.id = id;
      this.informantDateTime = informantDateTime;
      this.businessName = businessName;
      this.creditCode = creditCode;
      this.countryName = countryName;
      this.provinceName = provinceName;
      this.cityName = cityName;
      this.regionName = regionName;
      this.regionNameList = regionNameList;
      this.unitPropertyAllocationConfigName = unitPropertyAllocationConfigName;
      this.unitClassConfigurationName = unitClassConfigurationName;
      this.industryConfigurationName = industryConfigurationName;
      this.unitReputationAllocationConfigName = unitReputationAllocationConfigName;
      this.informantUserName = informantUserName;
      this.createUserName = createUserName;
      this.crmCheckStatusEnum = crmCheckStatusEnum;
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

   public String getProvinceName() {
      return this.provinceName;
   }

   public String getCityName() {
      return this.cityName;
   }

   public String getRegionName() {
      return this.regionName;
   }

   public String getRegionNameList() {
      return this.regionNameList;
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

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Integer getCrmCheckStatusEnum() {
      return this.crmCheckStatusEnum;
   }

   public CrmEnterpriseWarehousingPageDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmEnterpriseWarehousingPageDTO setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
      return this;
   }

   public CrmEnterpriseWarehousingPageDTO setBusinessName(final String businessName) {
      this.businessName = businessName;
      return this;
   }

   public CrmEnterpriseWarehousingPageDTO setCreditCode(final String creditCode) {
      this.creditCode = creditCode;
      return this;
   }

   public CrmEnterpriseWarehousingPageDTO setCountryName(final String countryName) {
      this.countryName = countryName;
      return this;
   }

   public CrmEnterpriseWarehousingPageDTO setProvinceName(final String provinceName) {
      this.provinceName = provinceName;
      return this;
   }

   public CrmEnterpriseWarehousingPageDTO setCityName(final String cityName) {
      this.cityName = cityName;
      return this;
   }

   public CrmEnterpriseWarehousingPageDTO setRegionName(final String regionName) {
      this.regionName = regionName;
      return this;
   }

   public CrmEnterpriseWarehousingPageDTO setRegionNameList(final String regionNameList) {
      this.regionNameList = regionNameList;
      return this;
   }

   public CrmEnterpriseWarehousingPageDTO setUnitPropertyAllocationConfigName(final String unitPropertyAllocationConfigName) {
      this.unitPropertyAllocationConfigName = unitPropertyAllocationConfigName;
      return this;
   }

   public CrmEnterpriseWarehousingPageDTO setUnitClassConfigurationName(final String unitClassConfigurationName) {
      this.unitClassConfigurationName = unitClassConfigurationName;
      return this;
   }

   public CrmEnterpriseWarehousingPageDTO setIndustryConfigurationName(final String industryConfigurationName) {
      this.industryConfigurationName = industryConfigurationName;
      return this;
   }

   public CrmEnterpriseWarehousingPageDTO setUnitReputationAllocationConfigName(final String unitReputationAllocationConfigName) {
      this.unitReputationAllocationConfigName = unitReputationAllocationConfigName;
      return this;
   }

   public CrmEnterpriseWarehousingPageDTO setInformantUserName(final String informantUserName) {
      this.informantUserName = informantUserName;
      return this;
   }

   public CrmEnterpriseWarehousingPageDTO setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public CrmEnterpriseWarehousingPageDTO setCrmCheckStatusEnum(final Integer crmCheckStatusEnum) {
      this.crmCheckStatusEnum = crmCheckStatusEnum;
      return this;
   }

   @Override
   public String toString() {
      return "CrmEnterpriseWarehousingPageDTO(id="
         + this.getId()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ", businessName="
         + this.getBusinessName()
         + ", creditCode="
         + this.getCreditCode()
         + ", countryName="
         + this.getCountryName()
         + ", provinceName="
         + this.getProvinceName()
         + ", cityName="
         + this.getCityName()
         + ", regionName="
         + this.getRegionName()
         + ", regionNameList="
         + this.getRegionNameList()
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
         + ", createUserName="
         + this.getCreateUserName()
         + ", crmCheckStatusEnum="
         + this.getCrmCheckStatusEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmEnterpriseWarehousingPageDTO)) {
         return false;
      }

      CrmEnterpriseWarehousingPageDTO other = (CrmEnterpriseWarehousingPageDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$crmCheckStatusEnum = this.getCrmCheckStatusEnum();
         Object other$crmCheckStatusEnum = other.getCrmCheckStatusEnum();
         if (this$crmCheckStatusEnum == null ? other$crmCheckStatusEnum == null : this$crmCheckStatusEnum.equals(other$crmCheckStatusEnum)) {
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
                        Object this$provinceName = this.getProvinceName();
                        Object other$provinceName = other.getProvinceName();
                        if (this$provinceName == null ? other$provinceName == null : this$provinceName.equals(other$provinceName)) {
                           Object this$cityName = this.getCityName();
                           Object other$cityName = other.getCityName();
                           if (this$cityName == null ? other$cityName == null : this$cityName.equals(other$cityName)) {
                              Object this$regionName = this.getRegionName();
                              Object other$regionName = other.getRegionName();
                              if (this$regionName == null ? other$regionName == null : this$regionName.equals(other$regionName)) {
                                 Object this$regionNameList = this.getRegionNameList();
                                 Object other$regionNameList = other.getRegionNameList();
                                 if (this$regionNameList == null ? other$regionNameList == null : this$regionNameList.equals(other$regionNameList)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmEnterpriseWarehousingPageDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $crmCheckStatusEnum = this.getCrmCheckStatusEnum();
      result = result * 59 + ($crmCheckStatusEnum == null ? 43 : $crmCheckStatusEnum.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
      Object $businessName = this.getBusinessName();
      result = result * 59 + ($businessName == null ? 43 : $businessName.hashCode());
      Object $creditCode = this.getCreditCode();
      result = result * 59 + ($creditCode == null ? 43 : $creditCode.hashCode());
      Object $countryName = this.getCountryName();
      result = result * 59 + ($countryName == null ? 43 : $countryName.hashCode());
      Object $provinceName = this.getProvinceName();
      result = result * 59 + ($provinceName == null ? 43 : $provinceName.hashCode());
      Object $cityName = this.getCityName();
      result = result * 59 + ($cityName == null ? 43 : $cityName.hashCode());
      Object $regionName = this.getRegionName();
      result = result * 59 + ($regionName == null ? 43 : $regionName.hashCode());
      Object $regionNameList = this.getRegionNameList();
      result = result * 59 + ($regionNameList == null ? 43 : $regionNameList.hashCode());
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
      Object $createUserName = this.getCreateUserName();
      return result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
   }

   public static class CrmEnterpriseWarehousingPageDTOBuilder {
      private Long id;
      private LocalDateTime informantDateTime;
      private String businessName;
      private String creditCode;
      private String countryName;
      private String provinceName;
      private String cityName;
      private String regionName;
      private String regionNameList;
      private String unitPropertyAllocationConfigName;
      private String unitClassConfigurationName;
      private String industryConfigurationName;
      private String unitReputationAllocationConfigName;
      private String informantUserName;
      private String createUserName;
      private Integer crmCheckStatusEnum;

      CrmEnterpriseWarehousingPageDTOBuilder() {
      }

      public CrmEnterpriseWarehousingPageDTO.CrmEnterpriseWarehousingPageDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmEnterpriseWarehousingPageDTO.CrmEnterpriseWarehousingPageDTOBuilder informantDateTime(final LocalDateTime informantDateTime) {
         this.informantDateTime = informantDateTime;
         return this;
      }

      public CrmEnterpriseWarehousingPageDTO.CrmEnterpriseWarehousingPageDTOBuilder businessName(final String businessName) {
         this.businessName = businessName;
         return this;
      }

      public CrmEnterpriseWarehousingPageDTO.CrmEnterpriseWarehousingPageDTOBuilder creditCode(final String creditCode) {
         this.creditCode = creditCode;
         return this;
      }

      public CrmEnterpriseWarehousingPageDTO.CrmEnterpriseWarehousingPageDTOBuilder countryName(final String countryName) {
         this.countryName = countryName;
         return this;
      }

      public CrmEnterpriseWarehousingPageDTO.CrmEnterpriseWarehousingPageDTOBuilder provinceName(final String provinceName) {
         this.provinceName = provinceName;
         return this;
      }

      public CrmEnterpriseWarehousingPageDTO.CrmEnterpriseWarehousingPageDTOBuilder cityName(final String cityName) {
         this.cityName = cityName;
         return this;
      }

      public CrmEnterpriseWarehousingPageDTO.CrmEnterpriseWarehousingPageDTOBuilder regionName(final String regionName) {
         this.regionName = regionName;
         return this;
      }

      public CrmEnterpriseWarehousingPageDTO.CrmEnterpriseWarehousingPageDTOBuilder regionNameList(final String regionNameList) {
         this.regionNameList = regionNameList;
         return this;
      }

      public CrmEnterpriseWarehousingPageDTO.CrmEnterpriseWarehousingPageDTOBuilder unitPropertyAllocationConfigName(
         final String unitPropertyAllocationConfigName
      ) {
         this.unitPropertyAllocationConfigName = unitPropertyAllocationConfigName;
         return this;
      }

      public CrmEnterpriseWarehousingPageDTO.CrmEnterpriseWarehousingPageDTOBuilder unitClassConfigurationName(final String unitClassConfigurationName) {
         this.unitClassConfigurationName = unitClassConfigurationName;
         return this;
      }

      public CrmEnterpriseWarehousingPageDTO.CrmEnterpriseWarehousingPageDTOBuilder industryConfigurationName(final String industryConfigurationName) {
         this.industryConfigurationName = industryConfigurationName;
         return this;
      }

      public CrmEnterpriseWarehousingPageDTO.CrmEnterpriseWarehousingPageDTOBuilder unitReputationAllocationConfigName(
         final String unitReputationAllocationConfigName
      ) {
         this.unitReputationAllocationConfigName = unitReputationAllocationConfigName;
         return this;
      }

      public CrmEnterpriseWarehousingPageDTO.CrmEnterpriseWarehousingPageDTOBuilder informantUserName(final String informantUserName) {
         this.informantUserName = informantUserName;
         return this;
      }

      public CrmEnterpriseWarehousingPageDTO.CrmEnterpriseWarehousingPageDTOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public CrmEnterpriseWarehousingPageDTO.CrmEnterpriseWarehousingPageDTOBuilder crmCheckStatusEnum(final Integer crmCheckStatusEnum) {
         this.crmCheckStatusEnum = crmCheckStatusEnum;
         return this;
      }

      public CrmEnterpriseWarehousingPageDTO build() {
         return new CrmEnterpriseWarehousingPageDTO(
            this.id,
            this.informantDateTime,
            this.businessName,
            this.creditCode,
            this.countryName,
            this.provinceName,
            this.cityName,
            this.regionName,
            this.regionNameList,
            this.unitPropertyAllocationConfigName,
            this.unitClassConfigurationName,
            this.industryConfigurationName,
            this.unitReputationAllocationConfigName,
            this.informantUserName,
            this.createUserName,
            this.crmCheckStatusEnum
         );
      }

      @Override
      public String toString() {
         return "CrmEnterpriseWarehousingPageDTO.CrmEnterpriseWarehousingPageDTOBuilder(id="
            + this.id
            + ", informantDateTime="
            + this.informantDateTime
            + ", businessName="
            + this.businessName
            + ", creditCode="
            + this.creditCode
            + ", countryName="
            + this.countryName
            + ", provinceName="
            + this.provinceName
            + ", cityName="
            + this.cityName
            + ", regionName="
            + this.regionName
            + ", regionNameList="
            + this.regionNameList
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
            + ", createUserName="
            + this.createUserName
            + ", crmCheckStatusEnum="
            + this.crmCheckStatusEnum
            + ")";
      }
   }
}
