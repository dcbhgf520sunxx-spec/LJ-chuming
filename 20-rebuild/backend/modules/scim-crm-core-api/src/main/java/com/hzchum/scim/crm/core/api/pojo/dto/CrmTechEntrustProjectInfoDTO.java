package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class CrmTechEntrustProjectInfoDTO {
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", value = "项目备案id", notes = "项目备案id")
   private Long crmProjectInformationWarehousingId;
   @ApiModelProperty(name = "crmProjectInformationWarehousingName", value = "项目信息备案名称", notes = "项目信息备案名称")
   private String crmProjectInformationWarehousingName;
   @ApiModelProperty(name = "crmProjectInformationWarehousingSerialNumber", value = "项目编号", notes = "项目编号")
   private String crmProjectInformationWarehousingSerialNumber;

   public Long getCrmProjectInformationWarehousingId() {
      return this.crmProjectInformationWarehousingId;
   }

   public String getCrmProjectInformationWarehousingName() {
      return this.crmProjectInformationWarehousingName;
   }

   public String getCrmProjectInformationWarehousingSerialNumber() {
      return this.crmProjectInformationWarehousingSerialNumber;
   }

   public void setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
   }

   public void setCrmProjectInformationWarehousingName(final String crmProjectInformationWarehousingName) {
      this.crmProjectInformationWarehousingName = crmProjectInformationWarehousingName;
   }

   public void setCrmProjectInformationWarehousingSerialNumber(final String crmProjectInformationWarehousingSerialNumber) {
      this.crmProjectInformationWarehousingSerialNumber = crmProjectInformationWarehousingSerialNumber;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmTechEntrustProjectInfoDTO)) {
         return false;
      }

      CrmTechEntrustProjectInfoDTO other = (CrmTechEntrustProjectInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      Object other$crmProjectInformationWarehousingId = other.getCrmProjectInformationWarehousingId();
      if (this$crmProjectInformationWarehousingId == null
         ? other$crmProjectInformationWarehousingId == null
         : this$crmProjectInformationWarehousingId.equals(other$crmProjectInformationWarehousingId)) {
         Object this$crmProjectInformationWarehousingName = this.getCrmProjectInformationWarehousingName();
         Object other$crmProjectInformationWarehousingName = other.getCrmProjectInformationWarehousingName();
         if (this$crmProjectInformationWarehousingName == null
            ? other$crmProjectInformationWarehousingName == null
            : this$crmProjectInformationWarehousingName.equals(other$crmProjectInformationWarehousingName)) {
            Object this$crmProjectInformationWarehousingSerialNumber = this.getCrmProjectInformationWarehousingSerialNumber();
            Object other$crmProjectInformationWarehousingSerialNumber = other.getCrmProjectInformationWarehousingSerialNumber();
            return this$crmProjectInformationWarehousingSerialNumber == null
               ? other$crmProjectInformationWarehousingSerialNumber == null
               : this$crmProjectInformationWarehousingSerialNumber.equals(other$crmProjectInformationWarehousingSerialNumber);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmTechEntrustProjectInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      result = result * 59 + ($crmProjectInformationWarehousingId == null ? 43 : $crmProjectInformationWarehousingId.hashCode());
      Object $crmProjectInformationWarehousingName = this.getCrmProjectInformationWarehousingName();
      result = result * 59 + ($crmProjectInformationWarehousingName == null ? 43 : $crmProjectInformationWarehousingName.hashCode());
      Object $crmProjectInformationWarehousingSerialNumber = this.getCrmProjectInformationWarehousingSerialNumber();
      return result * 59 + ($crmProjectInformationWarehousingSerialNumber == null ? 43 : $crmProjectInformationWarehousingSerialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "CrmTechEntrustProjectInfoDTO(crmProjectInformationWarehousingId="
         + this.getCrmProjectInformationWarehousingId()
         + ", crmProjectInformationWarehousingName="
         + this.getCrmProjectInformationWarehousingName()
         + ", crmProjectInformationWarehousingSerialNumber="
         + this.getCrmProjectInformationWarehousingSerialNumber()
         + ")";
   }

   public CrmTechEntrustProjectInfoDTO(
      final Long crmProjectInformationWarehousingId,
      final String crmProjectInformationWarehousingName,
      final String crmProjectInformationWarehousingSerialNumber
   ) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      this.crmProjectInformationWarehousingName = crmProjectInformationWarehousingName;
      this.crmProjectInformationWarehousingSerialNumber = crmProjectInformationWarehousingSerialNumber;
   }

   public CrmTechEntrustProjectInfoDTO() {
   }
}
