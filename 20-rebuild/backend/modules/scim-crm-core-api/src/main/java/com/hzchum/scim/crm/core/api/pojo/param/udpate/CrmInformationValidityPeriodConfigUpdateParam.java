package com.hzchum.scim.crm.core.api.pojo.param.udpate;

import io.swagger.annotations.ApiModelProperty;

public class CrmInformationValidityPeriodConfigUpdateParam {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "validityOfRegistration", value = "项目信息登记有效期", notes = "项目信息登记有效期")
   private Integer validityOfRegistration;
   @ApiModelProperty(name = "remindInAdvance", value = "有效期提前提醒设置", notes = "有效期提前提醒设置")
   private Integer remindInAdvance;
   @ApiModelProperty(name = "projectQuota", value = "项目名额", notes = "项目名额")
   private Integer projectQuota;

   public CrmInformationValidityPeriodConfigUpdateParam(
      final Long id, final Integer validityOfRegistration, final Integer remindInAdvance, final Integer projectQuota
   ) {
      this.id = id;
      this.validityOfRegistration = validityOfRegistration;
      this.remindInAdvance = remindInAdvance;
      this.projectQuota = projectQuota;
   }

   public CrmInformationValidityPeriodConfigUpdateParam() {
   }

   public Long getId() {
      return this.id;
   }

   public Integer getValidityOfRegistration() {
      return this.validityOfRegistration;
   }

   public Integer getRemindInAdvance() {
      return this.remindInAdvance;
   }

   public Integer getProjectQuota() {
      return this.projectQuota;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setValidityOfRegistration(final Integer validityOfRegistration) {
      this.validityOfRegistration = validityOfRegistration;
   }

   public void setRemindInAdvance(final Integer remindInAdvance) {
      this.remindInAdvance = remindInAdvance;
   }

   public void setProjectQuota(final Integer projectQuota) {
      this.projectQuota = projectQuota;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmInformationValidityPeriodConfigUpdateParam)) {
         return false;
      }

      CrmInformationValidityPeriodConfigUpdateParam other = (CrmInformationValidityPeriodConfigUpdateParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$validityOfRegistration = this.getValidityOfRegistration();
         Object other$validityOfRegistration = other.getValidityOfRegistration();
         if (this$validityOfRegistration == null ? other$validityOfRegistration == null : this$validityOfRegistration.equals(other$validityOfRegistration)) {
            Object this$remindInAdvance = this.getRemindInAdvance();
            Object other$remindInAdvance = other.getRemindInAdvance();
            if (this$remindInAdvance == null ? other$remindInAdvance == null : this$remindInAdvance.equals(other$remindInAdvance)) {
               Object this$projectQuota = this.getProjectQuota();
               Object other$projectQuota = other.getProjectQuota();
               return this$projectQuota == null ? other$projectQuota == null : this$projectQuota.equals(other$projectQuota);
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
      return other instanceof CrmInformationValidityPeriodConfigUpdateParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $validityOfRegistration = this.getValidityOfRegistration();
      result = result * 59 + ($validityOfRegistration == null ? 43 : $validityOfRegistration.hashCode());
      Object $remindInAdvance = this.getRemindInAdvance();
      result = result * 59 + ($remindInAdvance == null ? 43 : $remindInAdvance.hashCode());
      Object $projectQuota = this.getProjectQuota();
      return result * 59 + ($projectQuota == null ? 43 : $projectQuota.hashCode());
   }

   @Override
   public String toString() {
      return "CrmInformationValidityPeriodConfigUpdateParam(id="
         + this.getId()
         + ", validityOfRegistration="
         + this.getValidityOfRegistration()
         + ", remindInAdvance="
         + this.getRemindInAdvance()
         + ", projectQuota="
         + this.getProjectQuota()
         + ")";
   }
}
