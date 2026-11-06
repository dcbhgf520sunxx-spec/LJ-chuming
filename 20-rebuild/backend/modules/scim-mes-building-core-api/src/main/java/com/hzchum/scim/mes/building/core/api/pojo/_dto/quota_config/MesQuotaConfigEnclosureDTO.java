package com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config;

import com.hzchum.scim.common.core.api.pojo.common.DictionaryInfo;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigEnclosure;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("定额配置围护DTO")
public class MesQuotaConfigEnclosureDTO extends MesQuotaConfigEnclosure {
   @ApiModelProperty("围护类型")
   private DictionaryInfo enclosureTypeDictionary;

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesQuotaConfigEnclosureDTO)) {
         return false;
      }

      MesQuotaConfigEnclosureDTO other = (MesQuotaConfigEnclosureDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$enclosureTypeDictionary = this.getEnclosureTypeDictionary();
      Object other$enclosureTypeDictionary = other.getEnclosureTypeDictionary();
      return this$enclosureTypeDictionary == null ? other$enclosureTypeDictionary == null : this$enclosureTypeDictionary.equals(other$enclosureTypeDictionary);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesQuotaConfigEnclosureDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $enclosureTypeDictionary = this.getEnclosureTypeDictionary();
      return result * 59 + ($enclosureTypeDictionary == null ? 43 : $enclosureTypeDictionary.hashCode());
   }

   public DictionaryInfo getEnclosureTypeDictionary() {
      return this.enclosureTypeDictionary;
   }

   public void setEnclosureTypeDictionary(final DictionaryInfo enclosureTypeDictionary) {
      this.enclosureTypeDictionary = enclosureTypeDictionary;
   }

   @Override
   public String toString() {
      return "MesQuotaConfigEnclosureDTO(enclosureTypeDictionary=" + this.getEnclosureTypeDictionary() + ")";
   }
}
