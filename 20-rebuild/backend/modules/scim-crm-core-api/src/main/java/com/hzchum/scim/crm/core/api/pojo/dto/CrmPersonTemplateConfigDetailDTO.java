package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class CrmPersonTemplateConfigDetailDTO {
   @ApiModelProperty(name = "crmPersonTemplateEnum", value = "负责人类型枚举", notes = "负责人类型枚举")
   private Integer crmPersonTemplateEnum;
   @ApiModelProperty(name = "userSimpleInfoDTOS", value = "人员集合", notes = "人员集合")
   private List<CrmUserSimpleInfoDTO> userSimpleInfoDTOS;
   @ApiModelProperty(name = "crmPersonOperateTypeEnum", value = "操作类型", notes = "操作类型")
   private Integer crmPersonOperateTypeEnum;

   public static CrmPersonTemplateConfigDetailDTO.CrmPersonTemplateConfigDetailDTOBuilder builder() {
      return new CrmPersonTemplateConfigDetailDTO.CrmPersonTemplateConfigDetailDTOBuilder();
   }

   public CrmPersonTemplateConfigDetailDTO() {
   }

   public CrmPersonTemplateConfigDetailDTO(
      final Integer crmPersonTemplateEnum, final List<CrmUserSimpleInfoDTO> userSimpleInfoDTOS, final Integer crmPersonOperateTypeEnum
   ) {
      this.crmPersonTemplateEnum = crmPersonTemplateEnum;
      this.userSimpleInfoDTOS = userSimpleInfoDTOS;
      this.crmPersonOperateTypeEnum = crmPersonOperateTypeEnum;
   }

   public Integer getCrmPersonTemplateEnum() {
      return this.crmPersonTemplateEnum;
   }

   public List<CrmUserSimpleInfoDTO> getUserSimpleInfoDTOS() {
      return this.userSimpleInfoDTOS;
   }

   public Integer getCrmPersonOperateTypeEnum() {
      return this.crmPersonOperateTypeEnum;
   }

   public CrmPersonTemplateConfigDetailDTO setCrmPersonTemplateEnum(final Integer crmPersonTemplateEnum) {
      this.crmPersonTemplateEnum = crmPersonTemplateEnum;
      return this;
   }

   public CrmPersonTemplateConfigDetailDTO setUserSimpleInfoDTOS(final List<CrmUserSimpleInfoDTO> userSimpleInfoDTOS) {
      this.userSimpleInfoDTOS = userSimpleInfoDTOS;
      return this;
   }

   public CrmPersonTemplateConfigDetailDTO setCrmPersonOperateTypeEnum(final Integer crmPersonOperateTypeEnum) {
      this.crmPersonOperateTypeEnum = crmPersonOperateTypeEnum;
      return this;
   }

   @Override
   public String toString() {
      return "CrmPersonTemplateConfigDetailDTO(crmPersonTemplateEnum="
         + this.getCrmPersonTemplateEnum()
         + ", userSimpleInfoDTOS="
         + this.getUserSimpleInfoDTOS()
         + ", crmPersonOperateTypeEnum="
         + this.getCrmPersonOperateTypeEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmPersonTemplateConfigDetailDTO)) {
         return false;
      }

      CrmPersonTemplateConfigDetailDTO other = (CrmPersonTemplateConfigDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$crmPersonTemplateEnum = this.getCrmPersonTemplateEnum();
      Object other$crmPersonTemplateEnum = other.getCrmPersonTemplateEnum();
      if (this$crmPersonTemplateEnum == null ? other$crmPersonTemplateEnum == null : this$crmPersonTemplateEnum.equals(other$crmPersonTemplateEnum)) {
         Object this$crmPersonOperateTypeEnum = this.getCrmPersonOperateTypeEnum();
         Object other$crmPersonOperateTypeEnum = other.getCrmPersonOperateTypeEnum();
         if (this$crmPersonOperateTypeEnum == null
            ? other$crmPersonOperateTypeEnum == null
            : this$crmPersonOperateTypeEnum.equals(other$crmPersonOperateTypeEnum)) {
            Object this$userSimpleInfoDTOS = this.getUserSimpleInfoDTOS();
            Object other$userSimpleInfoDTOS = other.getUserSimpleInfoDTOS();
            return this$userSimpleInfoDTOS == null ? other$userSimpleInfoDTOS == null : this$userSimpleInfoDTOS.equals(other$userSimpleInfoDTOS);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmPersonTemplateConfigDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $crmPersonTemplateEnum = this.getCrmPersonTemplateEnum();
      result = result * 59 + ($crmPersonTemplateEnum == null ? 43 : $crmPersonTemplateEnum.hashCode());
      Object $crmPersonOperateTypeEnum = this.getCrmPersonOperateTypeEnum();
      result = result * 59 + ($crmPersonOperateTypeEnum == null ? 43 : $crmPersonOperateTypeEnum.hashCode());
      Object $userSimpleInfoDTOS = this.getUserSimpleInfoDTOS();
      return result * 59 + ($userSimpleInfoDTOS == null ? 43 : $userSimpleInfoDTOS.hashCode());
   }

   public static class CrmPersonTemplateConfigDetailDTOBuilder {
      private Integer crmPersonTemplateEnum;
      private List<CrmUserSimpleInfoDTO> userSimpleInfoDTOS;
      private Integer crmPersonOperateTypeEnum;

      CrmPersonTemplateConfigDetailDTOBuilder() {
      }

      public CrmPersonTemplateConfigDetailDTO.CrmPersonTemplateConfigDetailDTOBuilder crmPersonTemplateEnum(final Integer crmPersonTemplateEnum) {
         this.crmPersonTemplateEnum = crmPersonTemplateEnum;
         return this;
      }

      public CrmPersonTemplateConfigDetailDTO.CrmPersonTemplateConfigDetailDTOBuilder userSimpleInfoDTOS(final List<CrmUserSimpleInfoDTO> userSimpleInfoDTOS) {
         this.userSimpleInfoDTOS = userSimpleInfoDTOS;
         return this;
      }

      public CrmPersonTemplateConfigDetailDTO.CrmPersonTemplateConfigDetailDTOBuilder crmPersonOperateTypeEnum(final Integer crmPersonOperateTypeEnum) {
         this.crmPersonOperateTypeEnum = crmPersonOperateTypeEnum;
         return this;
      }

      public CrmPersonTemplateConfigDetailDTO build() {
         return new CrmPersonTemplateConfigDetailDTO(this.crmPersonTemplateEnum, this.userSimpleInfoDTOS, this.crmPersonOperateTypeEnum);
      }

      @Override
      public String toString() {
         return "CrmPersonTemplateConfigDetailDTO.CrmPersonTemplateConfigDetailDTOBuilder(crmPersonTemplateEnum="
            + this.crmPersonTemplateEnum
            + ", userSimpleInfoDTOS="
            + this.userSimpleInfoDTOS
            + ", crmPersonOperateTypeEnum="
            + this.crmPersonOperateTypeEnum
            + ")";
      }
   }
}
