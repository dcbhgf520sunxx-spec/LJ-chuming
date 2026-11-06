package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class CrmProjectInformationConfigEnumListDTO {
   @ApiModelProperty(name = "crmProjectInformationConfigEnum", value = "项目信息配置枚举", notes = "项目信息配置枚举")
   private Integer crmProjectInformationConfigEnum;
   @ApiModelProperty(name = "crmProjectInformationConfigEnumName", value = "项目信息配置枚举", notes = "项目信息配置枚举")
   private String crmProjectInformationConfigEnumName;
   @ApiModelProperty(name = "crmProjectInformationConfigDTOS", value = "配置集合", notes = "配置集合")
   private List<CrmProjectInformationConfigDTO> crmProjectInformationConfigDTOS;

   public static CrmProjectInformationConfigEnumListDTO.CrmProjectInformationConfigEnumListDTOBuilder builder() {
      return new CrmProjectInformationConfigEnumListDTO.CrmProjectInformationConfigEnumListDTOBuilder();
   }

   public CrmProjectInformationConfigEnumListDTO() {
   }

   public CrmProjectInformationConfigEnumListDTO(
      final Integer crmProjectInformationConfigEnum,
      final String crmProjectInformationConfigEnumName,
      final List<CrmProjectInformationConfigDTO> crmProjectInformationConfigDTOS
   ) {
      this.crmProjectInformationConfigEnum = crmProjectInformationConfigEnum;
      this.crmProjectInformationConfigEnumName = crmProjectInformationConfigEnumName;
      this.crmProjectInformationConfigDTOS = crmProjectInformationConfigDTOS;
   }

   public Integer getCrmProjectInformationConfigEnum() {
      return this.crmProjectInformationConfigEnum;
   }

   public String getCrmProjectInformationConfigEnumName() {
      return this.crmProjectInformationConfigEnumName;
   }

   public List<CrmProjectInformationConfigDTO> getCrmProjectInformationConfigDTOS() {
      return this.crmProjectInformationConfigDTOS;
   }

   public CrmProjectInformationConfigEnumListDTO setCrmProjectInformationConfigEnum(final Integer crmProjectInformationConfigEnum) {
      this.crmProjectInformationConfigEnum = crmProjectInformationConfigEnum;
      return this;
   }

   public CrmProjectInformationConfigEnumListDTO setCrmProjectInformationConfigEnumName(final String crmProjectInformationConfigEnumName) {
      this.crmProjectInformationConfigEnumName = crmProjectInformationConfigEnumName;
      return this;
   }

   public CrmProjectInformationConfigEnumListDTO setCrmProjectInformationConfigDTOS(final List<CrmProjectInformationConfigDTO> crmProjectInformationConfigDTOS) {
      this.crmProjectInformationConfigDTOS = crmProjectInformationConfigDTOS;
      return this;
   }

   @Override
   public String toString() {
      return "CrmProjectInformationConfigEnumListDTO(crmProjectInformationConfigEnum="
         + this.getCrmProjectInformationConfigEnum()
         + ", crmProjectInformationConfigEnumName="
         + this.getCrmProjectInformationConfigEnumName()
         + ", crmProjectInformationConfigDTOS="
         + this.getCrmProjectInformationConfigDTOS()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmProjectInformationConfigEnumListDTO)) {
         return false;
      }

      CrmProjectInformationConfigEnumListDTO other = (CrmProjectInformationConfigEnumListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$crmProjectInformationConfigEnum = this.getCrmProjectInformationConfigEnum();
      Object other$crmProjectInformationConfigEnum = other.getCrmProjectInformationConfigEnum();
      if (this$crmProjectInformationConfigEnum == null
         ? other$crmProjectInformationConfigEnum == null
         : this$crmProjectInformationConfigEnum.equals(other$crmProjectInformationConfigEnum)) {
         Object this$crmProjectInformationConfigEnumName = this.getCrmProjectInformationConfigEnumName();
         Object other$crmProjectInformationConfigEnumName = other.getCrmProjectInformationConfigEnumName();
         if (this$crmProjectInformationConfigEnumName == null
            ? other$crmProjectInformationConfigEnumName == null
            : this$crmProjectInformationConfigEnumName.equals(other$crmProjectInformationConfigEnumName)) {
            Object this$crmProjectInformationConfigDTOS = this.getCrmProjectInformationConfigDTOS();
            Object other$crmProjectInformationConfigDTOS = other.getCrmProjectInformationConfigDTOS();
            return this$crmProjectInformationConfigDTOS == null
               ? other$crmProjectInformationConfigDTOS == null
               : this$crmProjectInformationConfigDTOS.equals(other$crmProjectInformationConfigDTOS);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmProjectInformationConfigEnumListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $crmProjectInformationConfigEnum = this.getCrmProjectInformationConfigEnum();
      result = result * 59 + ($crmProjectInformationConfigEnum == null ? 43 : $crmProjectInformationConfigEnum.hashCode());
      Object $crmProjectInformationConfigEnumName = this.getCrmProjectInformationConfigEnumName();
      result = result * 59 + ($crmProjectInformationConfigEnumName == null ? 43 : $crmProjectInformationConfigEnumName.hashCode());
      Object $crmProjectInformationConfigDTOS = this.getCrmProjectInformationConfigDTOS();
      return result * 59 + ($crmProjectInformationConfigDTOS == null ? 43 : $crmProjectInformationConfigDTOS.hashCode());
   }

   public static class CrmProjectInformationConfigEnumListDTOBuilder {
      private Integer crmProjectInformationConfigEnum;
      private String crmProjectInformationConfigEnumName;
      private List<CrmProjectInformationConfigDTO> crmProjectInformationConfigDTOS;

      CrmProjectInformationConfigEnumListDTOBuilder() {
      }

      public CrmProjectInformationConfigEnumListDTO.CrmProjectInformationConfigEnumListDTOBuilder crmProjectInformationConfigEnum(
         final Integer crmProjectInformationConfigEnum
      ) {
         this.crmProjectInformationConfigEnum = crmProjectInformationConfigEnum;
         return this;
      }

      public CrmProjectInformationConfigEnumListDTO.CrmProjectInformationConfigEnumListDTOBuilder crmProjectInformationConfigEnumName(
         final String crmProjectInformationConfigEnumName
      ) {
         this.crmProjectInformationConfigEnumName = crmProjectInformationConfigEnumName;
         return this;
      }

      public CrmProjectInformationConfigEnumListDTO.CrmProjectInformationConfigEnumListDTOBuilder crmProjectInformationConfigDTOS(
         final List<CrmProjectInformationConfigDTO> crmProjectInformationConfigDTOS
      ) {
         this.crmProjectInformationConfigDTOS = crmProjectInformationConfigDTOS;
         return this;
      }

      public CrmProjectInformationConfigEnumListDTO build() {
         return new CrmProjectInformationConfigEnumListDTO(
            this.crmProjectInformationConfigEnum, this.crmProjectInformationConfigEnumName, this.crmProjectInformationConfigDTOS
         );
      }

      @Override
      public String toString() {
         return "CrmProjectInformationConfigEnumListDTO.CrmProjectInformationConfigEnumListDTOBuilder(crmProjectInformationConfigEnum="
            + this.crmProjectInformationConfigEnum
            + ", crmProjectInformationConfigEnumName="
            + this.crmProjectInformationConfigEnumName
            + ", crmProjectInformationConfigDTOS="
            + this.crmProjectInformationConfigDTOS
            + ")";
      }
   }
}
