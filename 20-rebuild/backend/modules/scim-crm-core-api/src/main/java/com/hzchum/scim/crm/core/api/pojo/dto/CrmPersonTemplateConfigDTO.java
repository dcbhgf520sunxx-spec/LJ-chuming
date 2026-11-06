package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class CrmPersonTemplateConfigDTO {
   @ApiModelProperty(name = "crmPersonTemplateEnum", value = "负责人类型枚举", notes = "负责人类型枚举")
   private Integer crmPersonTemplateEnum;
   @ApiModelProperty(name = "personCount", value = "人员数量", notes = "人员数量")
   private Integer personCount;

   public static CrmPersonTemplateConfigDTO.CrmPersonTemplateConfigDTOBuilder builder() {
      return new CrmPersonTemplateConfigDTO.CrmPersonTemplateConfigDTOBuilder();
   }

   public CrmPersonTemplateConfigDTO() {
   }

   public CrmPersonTemplateConfigDTO(final Integer crmPersonTemplateEnum, final Integer personCount) {
      this.crmPersonTemplateEnum = crmPersonTemplateEnum;
      this.personCount = personCount;
   }

   public Integer getCrmPersonTemplateEnum() {
      return this.crmPersonTemplateEnum;
   }

   public Integer getPersonCount() {
      return this.personCount;
   }

   public CrmPersonTemplateConfigDTO setCrmPersonTemplateEnum(final Integer crmPersonTemplateEnum) {
      this.crmPersonTemplateEnum = crmPersonTemplateEnum;
      return this;
   }

   public CrmPersonTemplateConfigDTO setPersonCount(final Integer personCount) {
      this.personCount = personCount;
      return this;
   }

   @Override
   public String toString() {
      return "CrmPersonTemplateConfigDTO(crmPersonTemplateEnum=" + this.getCrmPersonTemplateEnum() + ", personCount=" + this.getPersonCount() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CrmPersonTemplateConfigDTO)) {
         return false;
      } else {
         CrmPersonTemplateConfigDTO other = (CrmPersonTemplateConfigDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$crmPersonTemplateEnum = this.getCrmPersonTemplateEnum();
            Object other$crmPersonTemplateEnum = other.getCrmPersonTemplateEnum();
            if (this$crmPersonTemplateEnum == null ? other$crmPersonTemplateEnum == null : this$crmPersonTemplateEnum.equals(other$crmPersonTemplateEnum)) {
               Object this$personCount = this.getPersonCount();
               Object other$personCount = other.getPersonCount();
               return this$personCount == null ? other$personCount == null : this$personCount.equals(other$personCount);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmPersonTemplateConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $crmPersonTemplateEnum = this.getCrmPersonTemplateEnum();
      result = result * 59 + ($crmPersonTemplateEnum == null ? 43 : $crmPersonTemplateEnum.hashCode());
      Object $personCount = this.getPersonCount();
      return result * 59 + ($personCount == null ? 43 : $personCount.hashCode());
   }

   public static class CrmPersonTemplateConfigDTOBuilder {
      private Integer crmPersonTemplateEnum;
      private Integer personCount;

      CrmPersonTemplateConfigDTOBuilder() {
      }

      public CrmPersonTemplateConfigDTO.CrmPersonTemplateConfigDTOBuilder crmPersonTemplateEnum(final Integer crmPersonTemplateEnum) {
         this.crmPersonTemplateEnum = crmPersonTemplateEnum;
         return this;
      }

      public CrmPersonTemplateConfigDTO.CrmPersonTemplateConfigDTOBuilder personCount(final Integer personCount) {
         this.personCount = personCount;
         return this;
      }

      public CrmPersonTemplateConfigDTO build() {
         return new CrmPersonTemplateConfigDTO(this.crmPersonTemplateEnum, this.personCount);
      }

      @Override
      public String toString() {
         return "CrmPersonTemplateConfigDTO.CrmPersonTemplateConfigDTOBuilder(crmPersonTemplateEnum="
            + this.crmPersonTemplateEnum
            + ", personCount="
            + this.personCount
            + ")";
      }
   }
}
