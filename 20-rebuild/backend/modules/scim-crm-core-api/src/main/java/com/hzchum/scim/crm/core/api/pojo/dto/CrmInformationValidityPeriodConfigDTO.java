package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class CrmInformationValidityPeriodConfigDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "crmInformationValidityPeriodConfigEnum", value = "信息配置类型枚举（信息，ca锁）", notes = "信息配置类型枚举（信息，ca锁）")
   private Integer crmInformationValidityPeriodConfigEnum;
   @ApiModelProperty(name = "crmInformationValidityPeriodConfigEnumName", value = "信息配置类型枚举（信息，ca锁）名称", notes = "信息配置类型枚举（信息，ca锁）名称")
   private String crmInformationValidityPeriodConfigEnumName;
   @ApiModelProperty(name = "validityOfRegistration", value = "项目信息登记有效期", notes = "项目信息登记有效期")
   private Integer validityOfRegistration;
   @ApiModelProperty(name = "projectQuota", value = "项目名额数量配置", notes = "项目名额数量配置")
   private Integer projectQuota;
   @ApiModelProperty(name = "remindInAdvance", value = "有效期提前提醒设置", notes = "有效期提前提醒设置")
   private Integer remindInAdvance;

   public static CrmInformationValidityPeriodConfigDTO.CrmInformationValidityPeriodConfigDTOBuilder builder() {
      return new CrmInformationValidityPeriodConfigDTO.CrmInformationValidityPeriodConfigDTOBuilder();
   }

   public CrmInformationValidityPeriodConfigDTO() {
   }

   public CrmInformationValidityPeriodConfigDTO(
      final Long id,
      final Integer crmInformationValidityPeriodConfigEnum,
      final String crmInformationValidityPeriodConfigEnumName,
      final Integer validityOfRegistration,
      final Integer projectQuota,
      final Integer remindInAdvance
   ) {
      this.id = id;
      this.crmInformationValidityPeriodConfigEnum = crmInformationValidityPeriodConfigEnum;
      this.crmInformationValidityPeriodConfigEnumName = crmInformationValidityPeriodConfigEnumName;
      this.validityOfRegistration = validityOfRegistration;
      this.projectQuota = projectQuota;
      this.remindInAdvance = remindInAdvance;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getCrmInformationValidityPeriodConfigEnum() {
      return this.crmInformationValidityPeriodConfigEnum;
   }

   public String getCrmInformationValidityPeriodConfigEnumName() {
      return this.crmInformationValidityPeriodConfigEnumName;
   }

   public Integer getValidityOfRegistration() {
      return this.validityOfRegistration;
   }

   public Integer getProjectQuota() {
      return this.projectQuota;
   }

   public Integer getRemindInAdvance() {
      return this.remindInAdvance;
   }

   public CrmInformationValidityPeriodConfigDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmInformationValidityPeriodConfigDTO setCrmInformationValidityPeriodConfigEnum(final Integer crmInformationValidityPeriodConfigEnum) {
      this.crmInformationValidityPeriodConfigEnum = crmInformationValidityPeriodConfigEnum;
      return this;
   }

   public CrmInformationValidityPeriodConfigDTO setCrmInformationValidityPeriodConfigEnumName(final String crmInformationValidityPeriodConfigEnumName) {
      this.crmInformationValidityPeriodConfigEnumName = crmInformationValidityPeriodConfigEnumName;
      return this;
   }

   public CrmInformationValidityPeriodConfigDTO setValidityOfRegistration(final Integer validityOfRegistration) {
      this.validityOfRegistration = validityOfRegistration;
      return this;
   }

   public CrmInformationValidityPeriodConfigDTO setProjectQuota(final Integer projectQuota) {
      this.projectQuota = projectQuota;
      return this;
   }

   public CrmInformationValidityPeriodConfigDTO setRemindInAdvance(final Integer remindInAdvance) {
      this.remindInAdvance = remindInAdvance;
      return this;
   }

   @Override
   public String toString() {
      return "CrmInformationValidityPeriodConfigDTO(id="
         + this.getId()
         + ", crmInformationValidityPeriodConfigEnum="
         + this.getCrmInformationValidityPeriodConfigEnum()
         + ", crmInformationValidityPeriodConfigEnumName="
         + this.getCrmInformationValidityPeriodConfigEnumName()
         + ", validityOfRegistration="
         + this.getValidityOfRegistration()
         + ", projectQuota="
         + this.getProjectQuota()
         + ", remindInAdvance="
         + this.getRemindInAdvance()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmInformationValidityPeriodConfigDTO)) {
         return false;
      }

      CrmInformationValidityPeriodConfigDTO other = (CrmInformationValidityPeriodConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$crmInformationValidityPeriodConfigEnum = this.getCrmInformationValidityPeriodConfigEnum();
         Object other$crmInformationValidityPeriodConfigEnum = other.getCrmInformationValidityPeriodConfigEnum();
         if (this$crmInformationValidityPeriodConfigEnum == null
            ? other$crmInformationValidityPeriodConfigEnum == null
            : this$crmInformationValidityPeriodConfigEnum.equals(other$crmInformationValidityPeriodConfigEnum)) {
            Object this$validityOfRegistration = this.getValidityOfRegistration();
            Object other$validityOfRegistration = other.getValidityOfRegistration();
            if (this$validityOfRegistration == null ? other$validityOfRegistration == null : this$validityOfRegistration.equals(other$validityOfRegistration)) {
               Object this$projectQuota = this.getProjectQuota();
               Object other$projectQuota = other.getProjectQuota();
               if (this$projectQuota == null ? other$projectQuota == null : this$projectQuota.equals(other$projectQuota)) {
                  Object this$remindInAdvance = this.getRemindInAdvance();
                  Object other$remindInAdvance = other.getRemindInAdvance();
                  if (this$remindInAdvance == null ? other$remindInAdvance == null : this$remindInAdvance.equals(other$remindInAdvance)) {
                     Object this$crmInformationValidityPeriodConfigEnumName = this.getCrmInformationValidityPeriodConfigEnumName();
                     Object other$crmInformationValidityPeriodConfigEnumName = other.getCrmInformationValidityPeriodConfigEnumName();
                     return this$crmInformationValidityPeriodConfigEnumName == null
                        ? other$crmInformationValidityPeriodConfigEnumName == null
                        : this$crmInformationValidityPeriodConfigEnumName.equals(other$crmInformationValidityPeriodConfigEnumName);
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
      return other instanceof CrmInformationValidityPeriodConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $crmInformationValidityPeriodConfigEnum = this.getCrmInformationValidityPeriodConfigEnum();
      result = result * 59 + ($crmInformationValidityPeriodConfigEnum == null ? 43 : $crmInformationValidityPeriodConfigEnum.hashCode());
      Object $validityOfRegistration = this.getValidityOfRegistration();
      result = result * 59 + ($validityOfRegistration == null ? 43 : $validityOfRegistration.hashCode());
      Object $projectQuota = this.getProjectQuota();
      result = result * 59 + ($projectQuota == null ? 43 : $projectQuota.hashCode());
      Object $remindInAdvance = this.getRemindInAdvance();
      result = result * 59 + ($remindInAdvance == null ? 43 : $remindInAdvance.hashCode());
      Object $crmInformationValidityPeriodConfigEnumName = this.getCrmInformationValidityPeriodConfigEnumName();
      return result * 59 + ($crmInformationValidityPeriodConfigEnumName == null ? 43 : $crmInformationValidityPeriodConfigEnumName.hashCode());
   }

   public static class CrmInformationValidityPeriodConfigDTOBuilder {
      private Long id;
      private Integer crmInformationValidityPeriodConfigEnum;
      private String crmInformationValidityPeriodConfigEnumName;
      private Integer validityOfRegistration;
      private Integer projectQuota;
      private Integer remindInAdvance;

      CrmInformationValidityPeriodConfigDTOBuilder() {
      }

      public CrmInformationValidityPeriodConfigDTO.CrmInformationValidityPeriodConfigDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmInformationValidityPeriodConfigDTO.CrmInformationValidityPeriodConfigDTOBuilder crmInformationValidityPeriodConfigEnum(
         final Integer crmInformationValidityPeriodConfigEnum
      ) {
         this.crmInformationValidityPeriodConfigEnum = crmInformationValidityPeriodConfigEnum;
         return this;
      }

      public CrmInformationValidityPeriodConfigDTO.CrmInformationValidityPeriodConfigDTOBuilder crmInformationValidityPeriodConfigEnumName(
         final String crmInformationValidityPeriodConfigEnumName
      ) {
         this.crmInformationValidityPeriodConfigEnumName = crmInformationValidityPeriodConfigEnumName;
         return this;
      }

      public CrmInformationValidityPeriodConfigDTO.CrmInformationValidityPeriodConfigDTOBuilder validityOfRegistration(final Integer validityOfRegistration) {
         this.validityOfRegistration = validityOfRegistration;
         return this;
      }

      public CrmInformationValidityPeriodConfigDTO.CrmInformationValidityPeriodConfigDTOBuilder projectQuota(final Integer projectQuota) {
         this.projectQuota = projectQuota;
         return this;
      }

      public CrmInformationValidityPeriodConfigDTO.CrmInformationValidityPeriodConfigDTOBuilder remindInAdvance(final Integer remindInAdvance) {
         this.remindInAdvance = remindInAdvance;
         return this;
      }

      public CrmInformationValidityPeriodConfigDTO build() {
         return new CrmInformationValidityPeriodConfigDTO(
            this.id,
            this.crmInformationValidityPeriodConfigEnum,
            this.crmInformationValidityPeriodConfigEnumName,
            this.validityOfRegistration,
            this.projectQuota,
            this.remindInAdvance
         );
      }

      @Override
      public String toString() {
         return "CrmInformationValidityPeriodConfigDTO.CrmInformationValidityPeriodConfigDTOBuilder(id="
            + this.id
            + ", crmInformationValidityPeriodConfigEnum="
            + this.crmInformationValidityPeriodConfigEnum
            + ", crmInformationValidityPeriodConfigEnumName="
            + this.crmInformationValidityPeriodConfigEnumName
            + ", validityOfRegistration="
            + this.validityOfRegistration
            + ", projectQuota="
            + this.projectQuota
            + ", remindInAdvance="
            + this.remindInAdvance
            + ")";
      }
   }
}
