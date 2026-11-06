package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList;

import com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList.UserCheckDTO;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CargoListWeighSMSDTOParam {
   @ApiModelProperty("发货清单id")
   @NotNull(message = "发货清单id不能为空")
   public Long id;
   @ApiModelProperty("短信接收人信息")
   @NotEmpty(message = "短信接收人信息不能为空")
   public List<UserCheckDTO> userChecks;

   public static CargoListWeighSMSDTOParam.CargoListWeighSMSDTOParamBuilder builder() {
      return new CargoListWeighSMSDTOParam.CargoListWeighSMSDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public List<UserCheckDTO> getUserChecks() {
      return this.userChecks;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setUserChecks(final List<UserCheckDTO> userChecks) {
      this.userChecks = userChecks;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CargoListWeighSMSDTOParam)) {
         return false;
      } else {
         CargoListWeighSMSDTOParam other = (CargoListWeighSMSDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$userChecks = this.getUserChecks();
               Object other$userChecks = other.getUserChecks();
               return this$userChecks == null ? other$userChecks == null : this$userChecks.equals(other$userChecks);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CargoListWeighSMSDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userChecks = this.getUserChecks();
      return result * 59 + ($userChecks == null ? 43 : $userChecks.hashCode());
   }

   @Override
   public String toString() {
      return "CargoListWeighSMSDTOParam(id=" + this.getId() + ", userChecks=" + this.getUserChecks() + ")";
   }

   public CargoListWeighSMSDTOParam(final Long id, final List<UserCheckDTO> userChecks) {
      this.id = id;
      this.userChecks = userChecks;
   }

   public CargoListWeighSMSDTOParam() {
   }

   public static class CargoListWeighSMSDTOParamBuilder {
      private Long id;
      private List<UserCheckDTO> userChecks;

      CargoListWeighSMSDTOParamBuilder() {
      }

      public CargoListWeighSMSDTOParam.CargoListWeighSMSDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CargoListWeighSMSDTOParam.CargoListWeighSMSDTOParamBuilder userChecks(final List<UserCheckDTO> userChecks) {
         this.userChecks = userChecks;
         return this;
      }

      public CargoListWeighSMSDTOParam build() {
         return new CargoListWeighSMSDTOParam(this.id, this.userChecks);
      }

      @Override
      public String toString() {
         return "CargoListWeighSMSDTOParam.CargoListWeighSMSDTOParamBuilder(id=" + this.id + ", userChecks=" + this.userChecks + ")";
      }
   }
}
