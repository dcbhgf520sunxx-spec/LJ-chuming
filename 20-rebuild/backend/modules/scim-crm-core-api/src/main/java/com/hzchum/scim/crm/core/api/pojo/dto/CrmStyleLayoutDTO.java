package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

public class CrmStyleLayoutDTO {
   @ApiModelProperty(name = "crmPageManagementConfigEnumName", value = "页面配置枚举名称", notes = "页面配置枚举名称")
   private String crmPageManagementConfigEnumName;
   @ApiModelProperty(name = "crmPageManagementConfigEnum", value = "页面配置枚举", notes = "页面配置枚举")
   private Integer crmPageManagementConfigEnum;
   @ApiModelProperty(name = "finallyUpdateTime", value = "最后更新时间", notes = "最后更新时间")
   private LocalDateTime finallyUpdateTime;

   public static CrmStyleLayoutDTO.CrmStyleLayoutDTOBuilder builder() {
      return new CrmStyleLayoutDTO.CrmStyleLayoutDTOBuilder();
   }

   public CrmStyleLayoutDTO() {
   }

   public CrmStyleLayoutDTO(final String crmPageManagementConfigEnumName, final Integer crmPageManagementConfigEnum, final LocalDateTime finallyUpdateTime) {
      this.crmPageManagementConfigEnumName = crmPageManagementConfigEnumName;
      this.crmPageManagementConfigEnum = crmPageManagementConfigEnum;
      this.finallyUpdateTime = finallyUpdateTime;
   }

   public String getCrmPageManagementConfigEnumName() {
      return this.crmPageManagementConfigEnumName;
   }

   public Integer getCrmPageManagementConfigEnum() {
      return this.crmPageManagementConfigEnum;
   }

   public LocalDateTime getFinallyUpdateTime() {
      return this.finallyUpdateTime;
   }

   public CrmStyleLayoutDTO setCrmPageManagementConfigEnumName(final String crmPageManagementConfigEnumName) {
      this.crmPageManagementConfigEnumName = crmPageManagementConfigEnumName;
      return this;
   }

   public CrmStyleLayoutDTO setCrmPageManagementConfigEnum(final Integer crmPageManagementConfigEnum) {
      this.crmPageManagementConfigEnum = crmPageManagementConfigEnum;
      return this;
   }

   public CrmStyleLayoutDTO setFinallyUpdateTime(final LocalDateTime finallyUpdateTime) {
      this.finallyUpdateTime = finallyUpdateTime;
      return this;
   }

   @Override
   public String toString() {
      return "CrmStyleLayoutDTO(crmPageManagementConfigEnumName="
         + this.getCrmPageManagementConfigEnumName()
         + ", crmPageManagementConfigEnum="
         + this.getCrmPageManagementConfigEnum()
         + ", finallyUpdateTime="
         + this.getFinallyUpdateTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmStyleLayoutDTO)) {
         return false;
      }

      CrmStyleLayoutDTO other = (CrmStyleLayoutDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$crmPageManagementConfigEnum = this.getCrmPageManagementConfigEnum();
      Object other$crmPageManagementConfigEnum = other.getCrmPageManagementConfigEnum();
      if (this$crmPageManagementConfigEnum == null
         ? other$crmPageManagementConfigEnum == null
         : this$crmPageManagementConfigEnum.equals(other$crmPageManagementConfigEnum)) {
         Object this$crmPageManagementConfigEnumName = this.getCrmPageManagementConfigEnumName();
         Object other$crmPageManagementConfigEnumName = other.getCrmPageManagementConfigEnumName();
         if (this$crmPageManagementConfigEnumName == null
            ? other$crmPageManagementConfigEnumName == null
            : this$crmPageManagementConfigEnumName.equals(other$crmPageManagementConfigEnumName)) {
            Object this$finallyUpdateTime = this.getFinallyUpdateTime();
            Object other$finallyUpdateTime = other.getFinallyUpdateTime();
            return this$finallyUpdateTime == null ? other$finallyUpdateTime == null : this$finallyUpdateTime.equals(other$finallyUpdateTime);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmStyleLayoutDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $crmPageManagementConfigEnum = this.getCrmPageManagementConfigEnum();
      result = result * 59 + ($crmPageManagementConfigEnum == null ? 43 : $crmPageManagementConfigEnum.hashCode());
      Object $crmPageManagementConfigEnumName = this.getCrmPageManagementConfigEnumName();
      result = result * 59 + ($crmPageManagementConfigEnumName == null ? 43 : $crmPageManagementConfigEnumName.hashCode());
      Object $finallyUpdateTime = this.getFinallyUpdateTime();
      return result * 59 + ($finallyUpdateTime == null ? 43 : $finallyUpdateTime.hashCode());
   }

   public static class CrmStyleLayoutDTOBuilder {
      private String crmPageManagementConfigEnumName;
      private Integer crmPageManagementConfigEnum;
      private LocalDateTime finallyUpdateTime;

      CrmStyleLayoutDTOBuilder() {
      }

      public CrmStyleLayoutDTO.CrmStyleLayoutDTOBuilder crmPageManagementConfigEnumName(final String crmPageManagementConfigEnumName) {
         this.crmPageManagementConfigEnumName = crmPageManagementConfigEnumName;
         return this;
      }

      public CrmStyleLayoutDTO.CrmStyleLayoutDTOBuilder crmPageManagementConfigEnum(final Integer crmPageManagementConfigEnum) {
         this.crmPageManagementConfigEnum = crmPageManagementConfigEnum;
         return this;
      }

      public CrmStyleLayoutDTO.CrmStyleLayoutDTOBuilder finallyUpdateTime(final LocalDateTime finallyUpdateTime) {
         this.finallyUpdateTime = finallyUpdateTime;
         return this;
      }

      public CrmStyleLayoutDTO build() {
         return new CrmStyleLayoutDTO(this.crmPageManagementConfigEnumName, this.crmPageManagementConfigEnum, this.finallyUpdateTime);
      }

      @Override
      public String toString() {
         return "CrmStyleLayoutDTO.CrmStyleLayoutDTOBuilder(crmPageManagementConfigEnumName="
            + this.crmPageManagementConfigEnumName
            + ", crmPageManagementConfigEnum="
            + this.crmPageManagementConfigEnum
            + ", finallyUpdateTime="
            + this.finallyUpdateTime
            + ")";
      }
   }
}
