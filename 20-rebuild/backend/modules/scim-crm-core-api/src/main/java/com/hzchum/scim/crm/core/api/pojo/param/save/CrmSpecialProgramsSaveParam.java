package com.hzchum.scim.crm.core.api.pojo.param.save;

import io.swagger.annotations.ApiModelProperty;

public class CrmSpecialProgramsSaveParam {
   @ApiModelProperty(name = "id", value = "项目id", notes = "项目id")
   private Long id;
   @ApiModelProperty(name = "crmSpecialBubmissionStatusEnum", notes = "专项方案提报类型")
   private Integer crmSpecialBubmissionStatusEnum;
   @ApiModelProperty(name = "businessEssentials", value = "业务要点", notes = "业务要点")
   private String businessEssentials;

   public CrmSpecialProgramsSaveParam(final Long id, final Integer crmSpecialBubmissionStatusEnum, final String businessEssentials) {
      this.id = id;
      this.crmSpecialBubmissionStatusEnum = crmSpecialBubmissionStatusEnum;
      this.businessEssentials = businessEssentials;
   }

   public CrmSpecialProgramsSaveParam() {
   }

   public Long getId() {
      return this.id;
   }

   public Integer getCrmSpecialBubmissionStatusEnum() {
      return this.crmSpecialBubmissionStatusEnum;
   }

   public String getBusinessEssentials() {
      return this.businessEssentials;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setCrmSpecialBubmissionStatusEnum(final Integer crmSpecialBubmissionStatusEnum) {
      this.crmSpecialBubmissionStatusEnum = crmSpecialBubmissionStatusEnum;
   }

   public void setBusinessEssentials(final String businessEssentials) {
      this.businessEssentials = businessEssentials;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmSpecialProgramsSaveParam)) {
         return false;
      }

      CrmSpecialProgramsSaveParam other = (CrmSpecialProgramsSaveParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$crmSpecialBubmissionStatusEnum = this.getCrmSpecialBubmissionStatusEnum();
         Object other$crmSpecialBubmissionStatusEnum = other.getCrmSpecialBubmissionStatusEnum();
         if (this$crmSpecialBubmissionStatusEnum == null
            ? other$crmSpecialBubmissionStatusEnum == null
            : this$crmSpecialBubmissionStatusEnum.equals(other$crmSpecialBubmissionStatusEnum)) {
            Object this$businessEssentials = this.getBusinessEssentials();
            Object other$businessEssentials = other.getBusinessEssentials();
            return this$businessEssentials == null ? other$businessEssentials == null : this$businessEssentials.equals(other$businessEssentials);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmSpecialProgramsSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $crmSpecialBubmissionStatusEnum = this.getCrmSpecialBubmissionStatusEnum();
      result = result * 59 + ($crmSpecialBubmissionStatusEnum == null ? 43 : $crmSpecialBubmissionStatusEnum.hashCode());
      Object $businessEssentials = this.getBusinessEssentials();
      return result * 59 + ($businessEssentials == null ? 43 : $businessEssentials.hashCode());
   }

   @Override
   public String toString() {
      return "CrmSpecialProgramsSaveParam(id="
         + this.getId()
         + ", crmSpecialBubmissionStatusEnum="
         + this.getCrmSpecialBubmissionStatusEnum()
         + ", businessEssentials="
         + this.getBusinessEssentials()
         + ")";
   }
}
