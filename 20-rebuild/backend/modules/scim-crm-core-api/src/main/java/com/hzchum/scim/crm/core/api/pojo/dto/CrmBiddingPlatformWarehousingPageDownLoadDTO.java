package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

public class CrmBiddingPlatformWarehousingPageDownLoadDTO {
   @ApiModelProperty(name = "id", value = "主键", notes = "主键")
   private Long id;
   @ApiModelProperty(name = "informantDateTime", value = "填报日期", notes = "填报日期")
   private LocalDateTime informantDateTime;
   @ApiModelProperty(name = "biddingPlatformName", value = "招标平台名称", notes = "招标平台名称")
   private String biddingPlatformName;
   @ApiModelProperty(name = "countryName", value = "国家名称", notes = "国家名称")
   private String countryName;
   @ApiModelProperty(name = "provinceNameAndCityName", value = "省市名称", notes = "省市名称")
   private String provinceNameAndCityName;
   @ApiModelProperty(name = "informantUserName", value = "填报人", notes = "填报人")
   private String informantUserName;
   @ApiModelProperty(name = "reasonForRegistration", value = "报名事由", notes = "报名事由")
   private String reasonForRegistration;
   @ApiModelProperty(name = "createUserName", value = "创建人名称", notes = "创建人名称")
   private String createUserName;
   @ApiModelProperty(name = "crmEnterpriseWarehousingName", notes = "企业名称")
   private String crmEnterpriseWarehousingName;
   @ApiModelProperty(name = "crmProjectInformationWarehousingName", value = "项目备案名称", notes = "项目备案名称")
   private String crmProjectInformationWarehousingName;
   @ApiModelProperty(name = "crmCheckStatusEnumName", value = "审核状态 参考枚举 CrmCheckStatusEnum", notes = "审核状态 参考枚举 CrmCheckStatusEnum")
   private String crmCheckStatusEnumName;

   public static CrmBiddingPlatformWarehousingPageDownLoadDTO.CrmBiddingPlatformWarehousingPageDownLoadDTOBuilder builder() {
      return new CrmBiddingPlatformWarehousingPageDownLoadDTO.CrmBiddingPlatformWarehousingPageDownLoadDTOBuilder();
   }

   public CrmBiddingPlatformWarehousingPageDownLoadDTO() {
   }

   public CrmBiddingPlatformWarehousingPageDownLoadDTO(
      final Long id,
      final LocalDateTime informantDateTime,
      final String biddingPlatformName,
      final String countryName,
      final String provinceNameAndCityName,
      final String informantUserName,
      final String reasonForRegistration,
      final String createUserName,
      final String crmEnterpriseWarehousingName,
      final String crmProjectInformationWarehousingName,
      final String crmCheckStatusEnumName
   ) {
      this.id = id;
      this.informantDateTime = informantDateTime;
      this.biddingPlatformName = biddingPlatformName;
      this.countryName = countryName;
      this.provinceNameAndCityName = provinceNameAndCityName;
      this.informantUserName = informantUserName;
      this.reasonForRegistration = reasonForRegistration;
      this.createUserName = createUserName;
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      this.crmProjectInformationWarehousingName = crmProjectInformationWarehousingName;
      this.crmCheckStatusEnumName = crmCheckStatusEnumName;
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
   }

   public String getBiddingPlatformName() {
      return this.biddingPlatformName;
   }

   public String getCountryName() {
      return this.countryName;
   }

   public String getProvinceNameAndCityName() {
      return this.provinceNameAndCityName;
   }

   public String getInformantUserName() {
      return this.informantUserName;
   }

   public String getReasonForRegistration() {
      return this.reasonForRegistration;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public String getCrmEnterpriseWarehousingName() {
      return this.crmEnterpriseWarehousingName;
   }

   public String getCrmProjectInformationWarehousingName() {
      return this.crmProjectInformationWarehousingName;
   }

   public String getCrmCheckStatusEnumName() {
      return this.crmCheckStatusEnumName;
   }

   public CrmBiddingPlatformWarehousingPageDownLoadDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDownLoadDTO setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDownLoadDTO setBiddingPlatformName(final String biddingPlatformName) {
      this.biddingPlatformName = biddingPlatformName;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDownLoadDTO setCountryName(final String countryName) {
      this.countryName = countryName;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDownLoadDTO setProvinceNameAndCityName(final String provinceNameAndCityName) {
      this.provinceNameAndCityName = provinceNameAndCityName;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDownLoadDTO setInformantUserName(final String informantUserName) {
      this.informantUserName = informantUserName;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDownLoadDTO setReasonForRegistration(final String reasonForRegistration) {
      this.reasonForRegistration = reasonForRegistration;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDownLoadDTO setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDownLoadDTO setCrmEnterpriseWarehousingName(final String crmEnterpriseWarehousingName) {
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDownLoadDTO setCrmProjectInformationWarehousingName(final String crmProjectInformationWarehousingName) {
      this.crmProjectInformationWarehousingName = crmProjectInformationWarehousingName;
      return this;
   }

   public CrmBiddingPlatformWarehousingPageDownLoadDTO setCrmCheckStatusEnumName(final String crmCheckStatusEnumName) {
      this.crmCheckStatusEnumName = crmCheckStatusEnumName;
      return this;
   }

   @Override
   public String toString() {
      return "CrmBiddingPlatformWarehousingPageDownLoadDTO(id="
         + this.getId()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ", biddingPlatformName="
         + this.getBiddingPlatformName()
         + ", countryName="
         + this.getCountryName()
         + ", provinceNameAndCityName="
         + this.getProvinceNameAndCityName()
         + ", informantUserName="
         + this.getInformantUserName()
         + ", reasonForRegistration="
         + this.getReasonForRegistration()
         + ", createUserName="
         + this.getCreateUserName()
         + ", crmEnterpriseWarehousingName="
         + this.getCrmEnterpriseWarehousingName()
         + ", crmProjectInformationWarehousingName="
         + this.getCrmProjectInformationWarehousingName()
         + ", crmCheckStatusEnumName="
         + this.getCrmCheckStatusEnumName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmBiddingPlatformWarehousingPageDownLoadDTO)) {
         return false;
      }

      CrmBiddingPlatformWarehousingPageDownLoadDTO other = (CrmBiddingPlatformWarehousingPageDownLoadDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$informantDateTime = this.getInformantDateTime();
         Object other$informantDateTime = other.getInformantDateTime();
         if (this$informantDateTime == null ? other$informantDateTime == null : this$informantDateTime.equals(other$informantDateTime)) {
            Object this$biddingPlatformName = this.getBiddingPlatformName();
            Object other$biddingPlatformName = other.getBiddingPlatformName();
            if (this$biddingPlatformName == null ? other$biddingPlatformName == null : this$biddingPlatformName.equals(other$biddingPlatformName)) {
               Object this$countryName = this.getCountryName();
               Object other$countryName = other.getCountryName();
               if (this$countryName == null ? other$countryName == null : this$countryName.equals(other$countryName)) {
                  Object this$provinceNameAndCityName = this.getProvinceNameAndCityName();
                  Object other$provinceNameAndCityName = other.getProvinceNameAndCityName();
                  if (this$provinceNameAndCityName == null
                     ? other$provinceNameAndCityName == null
                     : this$provinceNameAndCityName.equals(other$provinceNameAndCityName)) {
                     Object this$informantUserName = this.getInformantUserName();
                     Object other$informantUserName = other.getInformantUserName();
                     if (this$informantUserName == null ? other$informantUserName == null : this$informantUserName.equals(other$informantUserName)) {
                        Object this$reasonForRegistration = this.getReasonForRegistration();
                        Object other$reasonForRegistration = other.getReasonForRegistration();
                        if (this$reasonForRegistration == null
                           ? other$reasonForRegistration == null
                           : this$reasonForRegistration.equals(other$reasonForRegistration)) {
                           Object this$createUserName = this.getCreateUserName();
                           Object other$createUserName = other.getCreateUserName();
                           if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                              Object this$crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
                              Object other$crmEnterpriseWarehousingName = other.getCrmEnterpriseWarehousingName();
                              if (this$crmEnterpriseWarehousingName == null
                                 ? other$crmEnterpriseWarehousingName == null
                                 : this$crmEnterpriseWarehousingName.equals(other$crmEnterpriseWarehousingName)) {
                                 Object this$crmProjectInformationWarehousingName = this.getCrmProjectInformationWarehousingName();
                                 Object other$crmProjectInformationWarehousingName = other.getCrmProjectInformationWarehousingName();
                                 if (this$crmProjectInformationWarehousingName == null
                                    ? other$crmProjectInformationWarehousingName == null
                                    : this$crmProjectInformationWarehousingName.equals(other$crmProjectInformationWarehousingName)) {
                                    Object this$crmCheckStatusEnumName = this.getCrmCheckStatusEnumName();
                                    Object other$crmCheckStatusEnumName = other.getCrmCheckStatusEnumName();
                                    return this$crmCheckStatusEnumName == null
                                       ? other$crmCheckStatusEnumName == null
                                       : this$crmCheckStatusEnumName.equals(other$crmCheckStatusEnumName);
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
      return other instanceof CrmBiddingPlatformWarehousingPageDownLoadDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      result = result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
      Object $biddingPlatformName = this.getBiddingPlatformName();
      result = result * 59 + ($biddingPlatformName == null ? 43 : $biddingPlatformName.hashCode());
      Object $countryName = this.getCountryName();
      result = result * 59 + ($countryName == null ? 43 : $countryName.hashCode());
      Object $provinceNameAndCityName = this.getProvinceNameAndCityName();
      result = result * 59 + ($provinceNameAndCityName == null ? 43 : $provinceNameAndCityName.hashCode());
      Object $informantUserName = this.getInformantUserName();
      result = result * 59 + ($informantUserName == null ? 43 : $informantUserName.hashCode());
      Object $reasonForRegistration = this.getReasonForRegistration();
      result = result * 59 + ($reasonForRegistration == null ? 43 : $reasonForRegistration.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
      result = result * 59 + ($crmEnterpriseWarehousingName == null ? 43 : $crmEnterpriseWarehousingName.hashCode());
      Object $crmProjectInformationWarehousingName = this.getCrmProjectInformationWarehousingName();
      result = result * 59 + ($crmProjectInformationWarehousingName == null ? 43 : $crmProjectInformationWarehousingName.hashCode());
      Object $crmCheckStatusEnumName = this.getCrmCheckStatusEnumName();
      return result * 59 + ($crmCheckStatusEnumName == null ? 43 : $crmCheckStatusEnumName.hashCode());
   }

   public static class CrmBiddingPlatformWarehousingPageDownLoadDTOBuilder {
      private Long id;
      private LocalDateTime informantDateTime;
      private String biddingPlatformName;
      private String countryName;
      private String provinceNameAndCityName;
      private String informantUserName;
      private String reasonForRegistration;
      private String createUserName;
      private String crmEnterpriseWarehousingName;
      private String crmProjectInformationWarehousingName;
      private String crmCheckStatusEnumName;

      CrmBiddingPlatformWarehousingPageDownLoadDTOBuilder() {
      }

      public CrmBiddingPlatformWarehousingPageDownLoadDTO.CrmBiddingPlatformWarehousingPageDownLoadDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDownLoadDTO.CrmBiddingPlatformWarehousingPageDownLoadDTOBuilder informantDateTime(
         final LocalDateTime informantDateTime
      ) {
         this.informantDateTime = informantDateTime;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDownLoadDTO.CrmBiddingPlatformWarehousingPageDownLoadDTOBuilder biddingPlatformName(
         final String biddingPlatformName
      ) {
         this.biddingPlatformName = biddingPlatformName;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDownLoadDTO.CrmBiddingPlatformWarehousingPageDownLoadDTOBuilder countryName(final String countryName) {
         this.countryName = countryName;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDownLoadDTO.CrmBiddingPlatformWarehousingPageDownLoadDTOBuilder provinceNameAndCityName(
         final String provinceNameAndCityName
      ) {
         this.provinceNameAndCityName = provinceNameAndCityName;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDownLoadDTO.CrmBiddingPlatformWarehousingPageDownLoadDTOBuilder informantUserName(final String informantUserName) {
         this.informantUserName = informantUserName;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDownLoadDTO.CrmBiddingPlatformWarehousingPageDownLoadDTOBuilder reasonForRegistration(
         final String reasonForRegistration
      ) {
         this.reasonForRegistration = reasonForRegistration;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDownLoadDTO.CrmBiddingPlatformWarehousingPageDownLoadDTOBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDownLoadDTO.CrmBiddingPlatformWarehousingPageDownLoadDTOBuilder crmEnterpriseWarehousingName(
         final String crmEnterpriseWarehousingName
      ) {
         this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDownLoadDTO.CrmBiddingPlatformWarehousingPageDownLoadDTOBuilder crmProjectInformationWarehousingName(
         final String crmProjectInformationWarehousingName
      ) {
         this.crmProjectInformationWarehousingName = crmProjectInformationWarehousingName;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDownLoadDTO.CrmBiddingPlatformWarehousingPageDownLoadDTOBuilder crmCheckStatusEnumName(
         final String crmCheckStatusEnumName
      ) {
         this.crmCheckStatusEnumName = crmCheckStatusEnumName;
         return this;
      }

      public CrmBiddingPlatformWarehousingPageDownLoadDTO build() {
         return new CrmBiddingPlatformWarehousingPageDownLoadDTO(
            this.id,
            this.informantDateTime,
            this.biddingPlatformName,
            this.countryName,
            this.provinceNameAndCityName,
            this.informantUserName,
            this.reasonForRegistration,
            this.createUserName,
            this.crmEnterpriseWarehousingName,
            this.crmProjectInformationWarehousingName,
            this.crmCheckStatusEnumName
         );
      }

      @Override
      public String toString() {
         return "CrmBiddingPlatformWarehousingPageDownLoadDTO.CrmBiddingPlatformWarehousingPageDownLoadDTOBuilder(id="
            + this.id
            + ", informantDateTime="
            + this.informantDateTime
            + ", biddingPlatformName="
            + this.biddingPlatformName
            + ", countryName="
            + this.countryName
            + ", provinceNameAndCityName="
            + this.provinceNameAndCityName
            + ", informantUserName="
            + this.informantUserName
            + ", reasonForRegistration="
            + this.reasonForRegistration
            + ", createUserName="
            + this.createUserName
            + ", crmEnterpriseWarehousingName="
            + this.crmEnterpriseWarehousingName
            + ", crmProjectInformationWarehousingName="
            + this.crmProjectInformationWarehousingName
            + ", crmCheckStatusEnumName="
            + this.crmCheckStatusEnumName
            + ")";
      }
   }
}
