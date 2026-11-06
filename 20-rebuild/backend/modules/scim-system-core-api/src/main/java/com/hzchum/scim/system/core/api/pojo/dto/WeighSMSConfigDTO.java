package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel("过磅短信配置")
public class WeighSMSConfigDTO {
   @ApiModelProperty("短信接收人")
   @NotEmpty(message = "短信接收人配置不能为空")
   List<@Valid UserCheckVO> userChecks;
   @ApiModelProperty("过磅超标值")
   @NotNull(message = "过磅超标值不能为空")
   @Min(value = 0L, message = "过磅超标值不能小于0")
   private Double maxWeight;
   @ApiModelProperty("重量类型(毛重/净重)")
   @NotNull(message = "重量类型不能为空")
   private Integer weightTypeEnum;

   public List<@Valid UserCheckVO> getUserChecks() {
      return this.userChecks;
   }

   public Double getMaxWeight() {
      return this.maxWeight;
   }

   public Integer getWeightTypeEnum() {
      return this.weightTypeEnum;
   }

   public void setUserChecks(final List<@Valid UserCheckVO> userChecks) {
      this.userChecks = userChecks;
   }

   public void setMaxWeight(final Double maxWeight) {
      this.maxWeight = maxWeight;
   }

   public void setWeightTypeEnum(final Integer weightTypeEnum) {
      this.weightTypeEnum = weightTypeEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WeighSMSConfigDTO)) {
         return false;
      }

      WeighSMSConfigDTO other = (WeighSMSConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$maxWeight = this.getMaxWeight();
      Object other$maxWeight = other.getMaxWeight();
      if (this$maxWeight == null ? other$maxWeight == null : this$maxWeight.equals(other$maxWeight)) {
         Object this$weightTypeEnum = this.getWeightTypeEnum();
         Object other$weightTypeEnum = other.getWeightTypeEnum();
         if (this$weightTypeEnum == null ? other$weightTypeEnum == null : this$weightTypeEnum.equals(other$weightTypeEnum)) {
            Object this$userChecks = this.getUserChecks();
            Object other$userChecks = other.getUserChecks();
            return this$userChecks == null ? other$userChecks == null : this$userChecks.equals(other$userChecks);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof WeighSMSConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $maxWeight = this.getMaxWeight();
      result = result * 59 + ($maxWeight == null ? 43 : $maxWeight.hashCode());
      Object $weightTypeEnum = this.getWeightTypeEnum();
      result = result * 59 + ($weightTypeEnum == null ? 43 : $weightTypeEnum.hashCode());
      Object $userChecks = this.getUserChecks();
      return result * 59 + ($userChecks == null ? 43 : $userChecks.hashCode());
   }

   @Override
   public String toString() {
      return "WeighSMSConfigDTO(userChecks="
         + this.getUserChecks()
         + ", maxWeight="
         + this.getMaxWeight()
         + ", weightTypeEnum="
         + this.getWeightTypeEnum()
         + ")";
   }
}
