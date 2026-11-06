package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "CAPP 焊接数据采集记录详情  查询参数")
public class CappCraftCardWeldingGatherDetailDTO {
   @ApiModelProperty(name = "passId", value = "焊道任务id", notes = "焊道任务id")
   private Long passId;
   @ApiModelProperty(name = "isWithinTheRatedRange", value = "是否在额定范围", notes = "是否在额定范围")
   private Boolean isWithinTheRatedRange;
   @ApiModelProperty(name = "ratedElectricity", value = "额定电流(A)", notes = "额定电流(A)")
   private String ratedElectricity;
   @ApiModelProperty(name = "ratedVoltage", value = "额定电压(V)", notes = "额定电压(V)")
   private String ratedVoltage;

   public Long getPassId() {
      return this.passId;
   }

   public Boolean getIsWithinTheRatedRange() {
      return this.isWithinTheRatedRange;
   }

   public String getRatedElectricity() {
      return this.ratedElectricity;
   }

   public String getRatedVoltage() {
      return this.ratedVoltage;
   }

   public void setPassId(final Long passId) {
      this.passId = passId;
   }

   public void setIsWithinTheRatedRange(final Boolean isWithinTheRatedRange) {
      this.isWithinTheRatedRange = isWithinTheRatedRange;
   }

   public void setRatedElectricity(final String ratedElectricity) {
      this.ratedElectricity = ratedElectricity;
   }

   public void setRatedVoltage(final String ratedVoltage) {
      this.ratedVoltage = ratedVoltage;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CappCraftCardWeldingGatherDetailDTO)) {
         return false;
      }

      CappCraftCardWeldingGatherDetailDTO other = (CappCraftCardWeldingGatherDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$passId = this.getPassId();
      Object other$passId = other.getPassId();
      if (this$passId == null ? other$passId == null : this$passId.equals(other$passId)) {
         Object this$isWithinTheRatedRange = this.getIsWithinTheRatedRange();
         Object other$isWithinTheRatedRange = other.getIsWithinTheRatedRange();
         if (this$isWithinTheRatedRange == null ? other$isWithinTheRatedRange == null : this$isWithinTheRatedRange.equals(other$isWithinTheRatedRange)) {
            Object this$ratedElectricity = this.getRatedElectricity();
            Object other$ratedElectricity = other.getRatedElectricity();
            if (this$ratedElectricity == null ? other$ratedElectricity == null : this$ratedElectricity.equals(other$ratedElectricity)) {
               Object this$ratedVoltage = this.getRatedVoltage();
               Object other$ratedVoltage = other.getRatedVoltage();
               return this$ratedVoltage == null ? other$ratedVoltage == null : this$ratedVoltage.equals(other$ratedVoltage);
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
      return other instanceof CappCraftCardWeldingGatherDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $passId = this.getPassId();
      result = result * 59 + ($passId == null ? 43 : $passId.hashCode());
      Object $isWithinTheRatedRange = this.getIsWithinTheRatedRange();
      result = result * 59 + ($isWithinTheRatedRange == null ? 43 : $isWithinTheRatedRange.hashCode());
      Object $ratedElectricity = this.getRatedElectricity();
      result = result * 59 + ($ratedElectricity == null ? 43 : $ratedElectricity.hashCode());
      Object $ratedVoltage = this.getRatedVoltage();
      return result * 59 + ($ratedVoltage == null ? 43 : $ratedVoltage.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardWeldingGatherDetailDTO(passId="
         + this.getPassId()
         + ", isWithinTheRatedRange="
         + this.getIsWithinTheRatedRange()
         + ", ratedElectricity="
         + this.getRatedElectricity()
         + ", ratedVoltage="
         + this.getRatedVoltage()
         + ")";
   }
}
