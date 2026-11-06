package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class CrmThisProjectBindEnterRecordInfoDTO {
   @ApiModelProperty(name = "id", value = "企业备案id", notes = "企业备案id")
   private Long id;
   @ApiModelProperty(name = "crmEnterpriseWarehousingName", value = "企业备案名称", notes = "企业备案名称")
   private String crmEnterpriseWarehousingName;

   public CrmThisProjectBindEnterRecordInfoDTO(final Long id, final String crmEnterpriseWarehousingName) {
      this.id = id;
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
   }

   public CrmThisProjectBindEnterRecordInfoDTO() {
   }

   public Long getId() {
      return this.id;
   }

   public String getCrmEnterpriseWarehousingName() {
      return this.crmEnterpriseWarehousingName;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setCrmEnterpriseWarehousingName(final String crmEnterpriseWarehousingName) {
      this.crmEnterpriseWarehousingName = crmEnterpriseWarehousingName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CrmThisProjectBindEnterRecordInfoDTO)) {
         return false;
      } else {
         CrmThisProjectBindEnterRecordInfoDTO other = (CrmThisProjectBindEnterRecordInfoDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
               Object other$crmEnterpriseWarehousingName = other.getCrmEnterpriseWarehousingName();
               return this$crmEnterpriseWarehousingName == null
                  ? other$crmEnterpriseWarehousingName == null
                  : this$crmEnterpriseWarehousingName.equals(other$crmEnterpriseWarehousingName);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmThisProjectBindEnterRecordInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $crmEnterpriseWarehousingName = this.getCrmEnterpriseWarehousingName();
      return result * 59 + ($crmEnterpriseWarehousingName == null ? 43 : $crmEnterpriseWarehousingName.hashCode());
   }

   @Override
   public String toString() {
      return "CrmThisProjectBindEnterRecordInfoDTO(id=" + this.getId() + ", crmEnterpriseWarehousingName=" + this.getCrmEnterpriseWarehousingName() + ")";
   }
}
