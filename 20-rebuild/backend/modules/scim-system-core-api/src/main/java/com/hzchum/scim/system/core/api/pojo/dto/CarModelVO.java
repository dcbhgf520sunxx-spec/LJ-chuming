package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

public class CarModelVO {
   @ApiModelProperty("车型配置")
   @NotNull(message = "车型配置不能为空")
   private List<String> carModels;

   public List<String> getCarModels() {
      return this.carModels;
   }

   public void setCarModels(final List<String> carModels) {
      this.carModels = carModels;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CarModelVO)) {
         return false;
      }

      CarModelVO other = (CarModelVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$carModels = this.getCarModels();
      Object other$carModels = other.getCarModels();
      return this$carModels == null ? other$carModels == null : this$carModels.equals(other$carModels);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CarModelVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $carModels = this.getCarModels();
      return result * 59 + ($carModels == null ? 43 : $carModels.hashCode());
   }

   @Override
   public String toString() {
      return "CarModelVO(carModels=" + this.getCarModels() + ")";
   }
}
