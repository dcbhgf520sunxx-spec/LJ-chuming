package com.hzchum.scim.mes.building.core.api.pojo._dto.product;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.MesBuildingMachinePartDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.product.MesBuildingSchedulingProductionLineDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MesBuildingMachinePartDTO", description = "")
public class MesBuildingMachinePartDTO extends MesBuildingMachinePartDO {
   @ApiModelProperty(name = "schedulingProductionLineDTOS", notes = "分配的生产线详情")
   @JsonProperty("schedulingProductionLineDTOS")
   @JSONField(name = "schedulingProductionLineDTOS")
   private List<MesBuildingSchedulingProductionLineDO> schedulingProductionLineDTOS;

   public List<MesBuildingSchedulingProductionLineDO> getSchedulingProductionLineDTOS() {
      return this.schedulingProductionLineDTOS;
   }

   @JsonProperty("schedulingProductionLineDTOS")
   public MesBuildingMachinePartDTO setSchedulingProductionLineDTOS(final List<MesBuildingSchedulingProductionLineDO> schedulingProductionLineDTOS) {
      this.schedulingProductionLineDTOS = schedulingProductionLineDTOS;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingMachinePartDTO(schedulingProductionLineDTOS=" + this.getSchedulingProductionLineDTOS() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingMachinePartDTO)) {
         return false;
      }

      MesBuildingMachinePartDTO other = (MesBuildingMachinePartDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$schedulingProductionLineDTOS = this.getSchedulingProductionLineDTOS();
      Object other$schedulingProductionLineDTOS = other.getSchedulingProductionLineDTOS();
      return this$schedulingProductionLineDTOS == null
         ? other$schedulingProductionLineDTOS == null
         : this$schedulingProductionLineDTOS.equals(other$schedulingProductionLineDTOS);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingMachinePartDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $schedulingProductionLineDTOS = this.getSchedulingProductionLineDTOS();
      return result * 59 + ($schedulingProductionLineDTOS == null ? 43 : $schedulingProductionLineDTOS.hashCode());
   }
}
