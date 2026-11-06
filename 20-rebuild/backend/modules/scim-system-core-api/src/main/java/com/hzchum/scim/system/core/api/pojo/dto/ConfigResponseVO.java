package com.hzchum.scim.system.core.api.pojo.dto;

import java.util.List;

public class ConfigResponseVO {
   private AmountVO amount;
   private ProjectConfigVO project;
   private CostingConfigResponseVO wmsBase;
   private List<UnitSettingResponseVO> unitSettings;
   private CompanyInfoVO company;

   public AmountVO getAmount() {
      return this.amount;
   }

   public ProjectConfigVO getProject() {
      return this.project;
   }

   public CostingConfigResponseVO getWmsBase() {
      return this.wmsBase;
   }

   public List<UnitSettingResponseVO> getUnitSettings() {
      return this.unitSettings;
   }

   public CompanyInfoVO getCompany() {
      return this.company;
   }

   public void setAmount(final AmountVO amount) {
      this.amount = amount;
   }

   public void setProject(final ProjectConfigVO project) {
      this.project = project;
   }

   public void setWmsBase(final CostingConfigResponseVO wmsBase) {
      this.wmsBase = wmsBase;
   }

   public void setUnitSettings(final List<UnitSettingResponseVO> unitSettings) {
      this.unitSettings = unitSettings;
   }

   public void setCompany(final CompanyInfoVO company) {
      this.company = company;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ConfigResponseVO)) {
         return false;
      }

      ConfigResponseVO other = (ConfigResponseVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$amount = this.getAmount();
      Object other$amount = other.getAmount();
      if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
         Object this$project = this.getProject();
         Object other$project = other.getProject();
         if (this$project == null ? other$project == null : this$project.equals(other$project)) {
            Object this$wmsBase = this.getWmsBase();
            Object other$wmsBase = other.getWmsBase();
            if (this$wmsBase == null ? other$wmsBase == null : this$wmsBase.equals(other$wmsBase)) {
               Object this$unitSettings = this.getUnitSettings();
               Object other$unitSettings = other.getUnitSettings();
               if (this$unitSettings == null ? other$unitSettings == null : this$unitSettings.equals(other$unitSettings)) {
                  Object this$company = this.getCompany();
                  Object other$company = other.getCompany();
                  return this$company == null ? other$company == null : this$company.equals(other$company);
               } else {
                  return false;
               }
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
      return other instanceof ConfigResponseVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $wmsBase = this.getWmsBase();
      result = result * 59 + ($wmsBase == null ? 43 : $wmsBase.hashCode());
      Object $unitSettings = this.getUnitSettings();
      result = result * 59 + ($unitSettings == null ? 43 : $unitSettings.hashCode());
      Object $company = this.getCompany();
      return result * 59 + ($company == null ? 43 : $company.hashCode());
   }

   @Override
   public String toString() {
      return "ConfigResponseVO(amount="
         + this.getAmount()
         + ", project="
         + this.getProject()
         + ", wmsBase="
         + this.getWmsBase()
         + ", unitSettings="
         + this.getUnitSettings()
         + ", company="
         + this.getCompany()
         + ")";
   }
}
