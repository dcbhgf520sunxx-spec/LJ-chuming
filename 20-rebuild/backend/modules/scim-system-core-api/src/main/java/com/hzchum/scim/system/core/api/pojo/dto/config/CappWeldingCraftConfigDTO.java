package com.hzchum.scim.system.core.api.pojo.dto.config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "CAPP 焊接工艺配置")
public class CappWeldingCraftConfigDTO {
   @ApiModelProperty(name = "usageMode", notes = "使用模式")
   private Integer usageMode;
   @ApiModelProperty(name = "acquisitionFrequency", notes = "采集频率(秒)")
   private Long acquisitionFrequency;

   public Integer getUsageMode() {
      return this.usageMode;
   }

   public Long getAcquisitionFrequency() {
      return this.acquisitionFrequency;
   }

   public void setUsageMode(final Integer usageMode) {
      this.usageMode = usageMode;
   }

   public void setAcquisitionFrequency(final Long acquisitionFrequency) {
      this.acquisitionFrequency = acquisitionFrequency;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CappWeldingCraftConfigDTO)) {
         return false;
      } else {
         CappWeldingCraftConfigDTO other = (CappWeldingCraftConfigDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$usageMode = this.getUsageMode();
            Object other$usageMode = other.getUsageMode();
            if (this$usageMode == null ? other$usageMode == null : this$usageMode.equals(other$usageMode)) {
               Object this$acquisitionFrequency = this.getAcquisitionFrequency();
               Object other$acquisitionFrequency = other.getAcquisitionFrequency();
               return this$acquisitionFrequency == null ? other$acquisitionFrequency == null : this$acquisitionFrequency.equals(other$acquisitionFrequency);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CappWeldingCraftConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $usageMode = this.getUsageMode();
      result = result * 59 + ($usageMode == null ? 43 : $usageMode.hashCode());
      Object $acquisitionFrequency = this.getAcquisitionFrequency();
      return result * 59 + ($acquisitionFrequency == null ? 43 : $acquisitionFrequency.hashCode());
   }

   @Override
   public String toString() {
      return "CappWeldingCraftConfigDTO(usageMode=" + this.getUsageMode() + ", acquisitionFrequency=" + this.getAcquisitionFrequency() + ")";
   }
}
