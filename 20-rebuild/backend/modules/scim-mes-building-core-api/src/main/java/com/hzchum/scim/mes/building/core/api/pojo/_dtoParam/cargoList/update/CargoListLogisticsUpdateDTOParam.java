package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.update;

import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.CargoListLogisticsInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(description = "物流信息更新")
public class CargoListLogisticsUpdateDTOParam extends CargoListLogisticsInfo {
   @ApiModelProperty("发运id")
   @NotNull(message = "发运id")
   private Long id;

   public Long getId() {
      return this.id;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListLogisticsUpdateDTOParam)) {
         return false;
      }

      CargoListLogisticsUpdateDTOParam other = (CargoListLogisticsUpdateDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      return this$id == null ? other$id == null : this$id.equals(other$id);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof CargoListLogisticsUpdateDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      return result * 59 + ($id == null ? 43 : $id.hashCode());
   }

   @Override
   public String toString() {
      return "CargoListLogisticsUpdateDTOParam(id=" + this.getId() + ")";
   }
}
