package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class CrmBasicsConfigEnumListDTO {
   @ApiModelProperty(name = "id")
   private Integer crmBasicsConfigEnum;
   @ApiModelProperty(name = "crmBasicsConfigEnumName")
   private String crmBasicsConfigEnumName;
   @ApiModelProperty(name = "crmBasicsConfigDTOS")
   private List<CrmBasicsConfigDTO> crmBasicsConfigDTOS;

   public static CrmBasicsConfigEnumListDTO.CrmBasicsConfigEnumListDTOBuilder builder() {
      return new CrmBasicsConfigEnumListDTO.CrmBasicsConfigEnumListDTOBuilder();
   }

   public CrmBasicsConfigEnumListDTO() {
   }

   public CrmBasicsConfigEnumListDTO(
      final Integer crmBasicsConfigEnum, final String crmBasicsConfigEnumName, final List<CrmBasicsConfigDTO> crmBasicsConfigDTOS
   ) {
      this.crmBasicsConfigEnum = crmBasicsConfigEnum;
      this.crmBasicsConfigEnumName = crmBasicsConfigEnumName;
      this.crmBasicsConfigDTOS = crmBasicsConfigDTOS;
   }

   public Integer getCrmBasicsConfigEnum() {
      return this.crmBasicsConfigEnum;
   }

   public String getCrmBasicsConfigEnumName() {
      return this.crmBasicsConfigEnumName;
   }

   public List<CrmBasicsConfigDTO> getCrmBasicsConfigDTOS() {
      return this.crmBasicsConfigDTOS;
   }

   public CrmBasicsConfigEnumListDTO setCrmBasicsConfigEnum(final Integer crmBasicsConfigEnum) {
      this.crmBasicsConfigEnum = crmBasicsConfigEnum;
      return this;
   }

   public CrmBasicsConfigEnumListDTO setCrmBasicsConfigEnumName(final String crmBasicsConfigEnumName) {
      this.crmBasicsConfigEnumName = crmBasicsConfigEnumName;
      return this;
   }

   public CrmBasicsConfigEnumListDTO setCrmBasicsConfigDTOS(final List<CrmBasicsConfigDTO> crmBasicsConfigDTOS) {
      this.crmBasicsConfigDTOS = crmBasicsConfigDTOS;
      return this;
   }

   @Override
   public String toString() {
      return "CrmBasicsConfigEnumListDTO(crmBasicsConfigEnum="
         + this.getCrmBasicsConfigEnum()
         + ", crmBasicsConfigEnumName="
         + this.getCrmBasicsConfigEnumName()
         + ", crmBasicsConfigDTOS="
         + this.getCrmBasicsConfigDTOS()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmBasicsConfigEnumListDTO)) {
         return false;
      }

      CrmBasicsConfigEnumListDTO other = (CrmBasicsConfigEnumListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$crmBasicsConfigEnum = this.getCrmBasicsConfigEnum();
      Object other$crmBasicsConfigEnum = other.getCrmBasicsConfigEnum();
      if (this$crmBasicsConfigEnum == null ? other$crmBasicsConfigEnum == null : this$crmBasicsConfigEnum.equals(other$crmBasicsConfigEnum)) {
         Object this$crmBasicsConfigEnumName = this.getCrmBasicsConfigEnumName();
         Object other$crmBasicsConfigEnumName = other.getCrmBasicsConfigEnumName();
         if (this$crmBasicsConfigEnumName == null ? other$crmBasicsConfigEnumName == null : this$crmBasicsConfigEnumName.equals(other$crmBasicsConfigEnumName)) {
            Object this$crmBasicsConfigDTOS = this.getCrmBasicsConfigDTOS();
            Object other$crmBasicsConfigDTOS = other.getCrmBasicsConfigDTOS();
            return this$crmBasicsConfigDTOS == null ? other$crmBasicsConfigDTOS == null : this$crmBasicsConfigDTOS.equals(other$crmBasicsConfigDTOS);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmBasicsConfigEnumListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $crmBasicsConfigEnum = this.getCrmBasicsConfigEnum();
      result = result * 59 + ($crmBasicsConfigEnum == null ? 43 : $crmBasicsConfigEnum.hashCode());
      Object $crmBasicsConfigEnumName = this.getCrmBasicsConfigEnumName();
      result = result * 59 + ($crmBasicsConfigEnumName == null ? 43 : $crmBasicsConfigEnumName.hashCode());
      Object $crmBasicsConfigDTOS = this.getCrmBasicsConfigDTOS();
      return result * 59 + ($crmBasicsConfigDTOS == null ? 43 : $crmBasicsConfigDTOS.hashCode());
   }

   public static class CrmBasicsConfigEnumListDTOBuilder {
      private Integer crmBasicsConfigEnum;
      private String crmBasicsConfigEnumName;
      private List<CrmBasicsConfigDTO> crmBasicsConfigDTOS;

      CrmBasicsConfigEnumListDTOBuilder() {
      }

      public CrmBasicsConfigEnumListDTO.CrmBasicsConfigEnumListDTOBuilder crmBasicsConfigEnum(final Integer crmBasicsConfigEnum) {
         this.crmBasicsConfigEnum = crmBasicsConfigEnum;
         return this;
      }

      public CrmBasicsConfigEnumListDTO.CrmBasicsConfigEnumListDTOBuilder crmBasicsConfigEnumName(final String crmBasicsConfigEnumName) {
         this.crmBasicsConfigEnumName = crmBasicsConfigEnumName;
         return this;
      }

      public CrmBasicsConfigEnumListDTO.CrmBasicsConfigEnumListDTOBuilder crmBasicsConfigDTOS(final List<CrmBasicsConfigDTO> crmBasicsConfigDTOS) {
         this.crmBasicsConfigDTOS = crmBasicsConfigDTOS;
         return this;
      }

      public CrmBasicsConfigEnumListDTO build() {
         return new CrmBasicsConfigEnumListDTO(this.crmBasicsConfigEnum, this.crmBasicsConfigEnumName, this.crmBasicsConfigDTOS);
      }

      @Override
      public String toString() {
         return "CrmBasicsConfigEnumListDTO.CrmBasicsConfigEnumListDTOBuilder(crmBasicsConfigEnum="
            + this.crmBasicsConfigEnum
            + ", crmBasicsConfigEnumName="
            + this.crmBasicsConfigEnumName
            + ", crmBasicsConfigDTOS="
            + this.crmBasicsConfigDTOS
            + ")";
      }
   }
}
