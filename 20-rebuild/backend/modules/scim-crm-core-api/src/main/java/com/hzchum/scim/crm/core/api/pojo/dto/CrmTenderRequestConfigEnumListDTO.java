package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class CrmTenderRequestConfigEnumListDTO {
   @ApiModelProperty(name = "crmTenderRequestConfigEnum", value = "投标申请配置枚举", notes = "投标申请配置枚举")
   private Integer crmTenderRequestConfigEnum;
   @ApiModelProperty(name = "crmTenderRequestConfigEnumName", value = "投标申请配置枚举名称", notes = "投标申请配置枚举名称")
   private String crmTenderRequestConfigEnumName;
   @ApiModelProperty(name = "crmTenderRequestConfigDTOS", value = "配置集合", notes = "配置集合")
   private List<CrmTenderRequestConfigDTO> crmTenderRequestConfigDTOS;

   public static CrmTenderRequestConfigEnumListDTO.CrmTenderRequestConfigEnumListDTOBuilder builder() {
      return new CrmTenderRequestConfigEnumListDTO.CrmTenderRequestConfigEnumListDTOBuilder();
   }

   public CrmTenderRequestConfigEnumListDTO() {
   }

   public CrmTenderRequestConfigEnumListDTO(
      final Integer crmTenderRequestConfigEnum, final String crmTenderRequestConfigEnumName, final List<CrmTenderRequestConfigDTO> crmTenderRequestConfigDTOS
   ) {
      this.crmTenderRequestConfigEnum = crmTenderRequestConfigEnum;
      this.crmTenderRequestConfigEnumName = crmTenderRequestConfigEnumName;
      this.crmTenderRequestConfigDTOS = crmTenderRequestConfigDTOS;
   }

   public Integer getCrmTenderRequestConfigEnum() {
      return this.crmTenderRequestConfigEnum;
   }

   public String getCrmTenderRequestConfigEnumName() {
      return this.crmTenderRequestConfigEnumName;
   }

   public List<CrmTenderRequestConfigDTO> getCrmTenderRequestConfigDTOS() {
      return this.crmTenderRequestConfigDTOS;
   }

   public CrmTenderRequestConfigEnumListDTO setCrmTenderRequestConfigEnum(final Integer crmTenderRequestConfigEnum) {
      this.crmTenderRequestConfigEnum = crmTenderRequestConfigEnum;
      return this;
   }

   public CrmTenderRequestConfigEnumListDTO setCrmTenderRequestConfigEnumName(final String crmTenderRequestConfigEnumName) {
      this.crmTenderRequestConfigEnumName = crmTenderRequestConfigEnumName;
      return this;
   }

   public CrmTenderRequestConfigEnumListDTO setCrmTenderRequestConfigDTOS(final List<CrmTenderRequestConfigDTO> crmTenderRequestConfigDTOS) {
      this.crmTenderRequestConfigDTOS = crmTenderRequestConfigDTOS;
      return this;
   }

   @Override
   public String toString() {
      return "CrmTenderRequestConfigEnumListDTO(crmTenderRequestConfigEnum="
         + this.getCrmTenderRequestConfigEnum()
         + ", crmTenderRequestConfigEnumName="
         + this.getCrmTenderRequestConfigEnumName()
         + ", crmTenderRequestConfigDTOS="
         + this.getCrmTenderRequestConfigDTOS()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmTenderRequestConfigEnumListDTO)) {
         return false;
      }

      CrmTenderRequestConfigEnumListDTO other = (CrmTenderRequestConfigEnumListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$crmTenderRequestConfigEnum = this.getCrmTenderRequestConfigEnum();
      Object other$crmTenderRequestConfigEnum = other.getCrmTenderRequestConfigEnum();
      if (this$crmTenderRequestConfigEnum == null
         ? other$crmTenderRequestConfigEnum == null
         : this$crmTenderRequestConfigEnum.equals(other$crmTenderRequestConfigEnum)) {
         Object this$crmTenderRequestConfigEnumName = this.getCrmTenderRequestConfigEnumName();
         Object other$crmTenderRequestConfigEnumName = other.getCrmTenderRequestConfigEnumName();
         if (this$crmTenderRequestConfigEnumName == null
            ? other$crmTenderRequestConfigEnumName == null
            : this$crmTenderRequestConfigEnumName.equals(other$crmTenderRequestConfigEnumName)) {
            Object this$crmTenderRequestConfigDTOS = this.getCrmTenderRequestConfigDTOS();
            Object other$crmTenderRequestConfigDTOS = other.getCrmTenderRequestConfigDTOS();
            return this$crmTenderRequestConfigDTOS == null
               ? other$crmTenderRequestConfigDTOS == null
               : this$crmTenderRequestConfigDTOS.equals(other$crmTenderRequestConfigDTOS);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmTenderRequestConfigEnumListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $crmTenderRequestConfigEnum = this.getCrmTenderRequestConfigEnum();
      result = result * 59 + ($crmTenderRequestConfigEnum == null ? 43 : $crmTenderRequestConfigEnum.hashCode());
      Object $crmTenderRequestConfigEnumName = this.getCrmTenderRequestConfigEnumName();
      result = result * 59 + ($crmTenderRequestConfigEnumName == null ? 43 : $crmTenderRequestConfigEnumName.hashCode());
      Object $crmTenderRequestConfigDTOS = this.getCrmTenderRequestConfigDTOS();
      return result * 59 + ($crmTenderRequestConfigDTOS == null ? 43 : $crmTenderRequestConfigDTOS.hashCode());
   }

   public static class CrmTenderRequestConfigEnumListDTOBuilder {
      private Integer crmTenderRequestConfigEnum;
      private String crmTenderRequestConfigEnumName;
      private List<CrmTenderRequestConfigDTO> crmTenderRequestConfigDTOS;

      CrmTenderRequestConfigEnumListDTOBuilder() {
      }

      public CrmTenderRequestConfigEnumListDTO.CrmTenderRequestConfigEnumListDTOBuilder crmTenderRequestConfigEnum(final Integer crmTenderRequestConfigEnum) {
         this.crmTenderRequestConfigEnum = crmTenderRequestConfigEnum;
         return this;
      }

      public CrmTenderRequestConfigEnumListDTO.CrmTenderRequestConfigEnumListDTOBuilder crmTenderRequestConfigEnumName(
         final String crmTenderRequestConfigEnumName
      ) {
         this.crmTenderRequestConfigEnumName = crmTenderRequestConfigEnumName;
         return this;
      }

      public CrmTenderRequestConfigEnumListDTO.CrmTenderRequestConfigEnumListDTOBuilder crmTenderRequestConfigDTOS(
         final List<CrmTenderRequestConfigDTO> crmTenderRequestConfigDTOS
      ) {
         this.crmTenderRequestConfigDTOS = crmTenderRequestConfigDTOS;
         return this;
      }

      public CrmTenderRequestConfigEnumListDTO build() {
         return new CrmTenderRequestConfigEnumListDTO(this.crmTenderRequestConfigEnum, this.crmTenderRequestConfigEnumName, this.crmTenderRequestConfigDTOS);
      }

      @Override
      public String toString() {
         return "CrmTenderRequestConfigEnumListDTO.CrmTenderRequestConfigEnumListDTOBuilder(crmTenderRequestConfigEnum="
            + this.crmTenderRequestConfigEnum
            + ", crmTenderRequestConfigEnumName="
            + this.crmTenderRequestConfigEnumName
            + ", crmTenderRequestConfigDTOS="
            + this.crmTenderRequestConfigDTOS
            + ")";
      }
   }
}
